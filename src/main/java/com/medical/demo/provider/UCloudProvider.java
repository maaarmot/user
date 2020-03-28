package com.medical.demo.provider;

import cn.ucloud.ufile.UfileClient;
import cn.ucloud.ufile.api.object.ObjectConfig;
import cn.ucloud.ufile.auth.ObjectAuthorization;
import cn.ucloud.ufile.auth.UfileObjectLocalAuthorization;
import cn.ucloud.ufile.bean.PutObjectResultBean;
import cn.ucloud.ufile.exception.UfileClientException;
import cn.ucloud.ufile.exception.UfileServerException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.UUID;

@Service
@Slf4j
public class UCloudProvider {
    @Value("${ucloud.ufile.public-key}")
    private String publicKey;
    @Value("${ucloud.ufile.private-key}")
    private String privateKey;
    @Value("${ucloud.ufile.bucket-name}")
    private String bucketName;
    @Value("${ucloud.ufile.region}")
    private String region;
    @Value("${ucloud.ufile.suffix}")
    private String suffix;
    @Value("${ucloud.ufile.expires}")
    private Integer expires;

    public String upload(InputStream inputStream, String mimeType, String fileName){
        String generatedFileName="";
        String[] filePaths=fileName.split("\\.");
        if(filePaths.length>1){
            generatedFileName= UUID.randomUUID().toString()+"."+filePaths[filePaths.length-1];
        }else{
            log.error("upload error,{}",fileName);
//            throw new CustomizeException(CustomizeErrorCode.FILE_UPLOAD_FAIL);
        }

        try {
            //Bucket相关API的授权器
            ObjectAuthorization objectAuthorization = new UfileObjectLocalAuthorization(publicKey, privateKey);
            //对象操作需要ObjectConfig来配置你的地区和域名后缀
            ObjectConfig config = new ObjectConfig(region,suffix);

            PutObjectResultBean response = UfileClient.object(objectAuthorization, config)
                    .putObject(inputStream, mimeType)
                    .nameAs(generatedFileName)
                    .toBucket(bucketName)
                    .setOnProgressListener((bytesWritten, contentLength) -> {

                    })
                    .execute();

            if(response!=null && response.getRetCode()==0){
                String url = UfileClient.object(objectAuthorization, config)
                        .getDownloadUrlFromPrivateBucket(generatedFileName, bucketName,expires)
                        .createUrl();
                return url;
            }else{
                log.error("upload error,{}",response);
//                throw new CustomizeException(CustomizeErrorCode.FILE_UPLOAD_FAIL);
                return null;
            }
        } catch (UfileClientException e) {
            e.printStackTrace();
            log.error("upload error,{}",fileName,e);
//            throw new CustomizeException(CustomizeErrorCode.FILE_UPLOAD_FAIL);
            return null;
        } catch (UfileServerException e) {
            e.printStackTrace();
            log.error("upload error,{}",fileName,e);
//            throw new CustomizeException(CustomizeErrorCode.FILE_UPLOAD_FAIL);
            return null;
        }
    }
}
