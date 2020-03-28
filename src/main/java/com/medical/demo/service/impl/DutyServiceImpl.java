package com.medical.demo.service.impl;

import com.medical.demo.dto.DutyDTO;
import com.medical.demo.mapper.DutyDao;
import com.medical.demo.mapper.DutyMapper;
import com.medical.demo.model.Duty;
import com.medical.demo.model.DutyExample;
import com.medical.demo.service.DutyService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DutyServiceImpl implements DutyService {

    @Resource
    private DutyDao dutyDao;
    @Resource
    private DutyMapper dutyMapper;

    @Override
    public List<DutyDTO> getDutyById(Integer id) {
        //先根据医生id找到对应的所有duty
        List<Duty> dutyList = dutyDao.listByDocId(id);
        //把找到的所有duty的id都存进集合里
        List<Integer> dutyIds=new ArrayList<>();
        for (Duty duty : dutyList) {
            Integer dutyId = duty.getId();
            dutyIds.add(dutyId);
        }

        //再挑出父级duty
        dutyList = dutyList.stream().filter(p -> p.getParentid().equals(0)).collect(Collectors.toList());

        //最后找到父级duty下面的子duty并组装为dto
        List<DutyDTO> dutyDTOList=new ArrayList<>();

        for(Duty duty:dutyList){
            DutyExample example = new DutyExample();
            example.createCriteria()
                    .andParentidEqualTo(duty.getId())
                    //必须是属于dutyList集合
                    .andIdIn(dutyIds);
            List<Duty> chilDutys = dutyMapper.selectByExample(example);

            //下面这句是哪里写不对?为啥过滤完chilDutys就空了?
            //chilDutys = chilDutys.stream().filter(p -> dutyDao.listByDocId(id).contains(p)).collect(Collectors.toList());

            //用for循环也不行...
//            List<Duty> finalChil = new ArrayList<>();
//            List<Duty> all = dutyDao.listByDocId(id);
//            for (Duty chilDuty : chilDutys) {
//                System.out.println(all.contains(chilDuty));
//                System.out.println(all.get(1).equals(chilDuty));
//                System.out.println(all.get(1).equals(chilDutys.get(0)));
//                System.out.println("end");
//                if(all.contains(chilDuty)){
//                    finalChil.add(chilDuty);
//                }
//            }

            DutyDTO dutyDTO=new DutyDTO();
            BeanUtils.copyProperties(duty,dutyDTO);
            dutyDTO.setChilDutys(chilDutys);
//            dutyDTO.setChilDutys(finalChil);
            dutyDTOList.add(dutyDTO);
        }
        return dutyDTOList;
    }
}