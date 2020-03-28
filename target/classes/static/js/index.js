$(document).ready(function(){
    $('.intro').each(function(index){
        //获取图片的宽度
        $(this).css('height',100);
        $('.m-art-list-box img').css('height',100);
    });

    //当标题字符串过长，应该裁剪一下，用...结尾
    var cut=function(obj,num){
        // debugger;
        var str=obj.text();
        if(str.length>=num){
            obj.text(str.substr(0,num)+'...');
        }
    };

    cut($('.s-cut-21'),21);
    cut($('.s-cut-30'),30);
});