package com.medical.demo.mapper;

import com.medical.demo.model.Duty;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DutyDao {

    @Select("SELECT duty.* " +
            "FROM doctor_duty dd " +
            "LEFT JOIN duty ON duty.`id`=dd.`dutyId` " +
            "WHERE dd.`doctorId` = #{docId}")
    List<Duty> listByDocId(@Param("docId") Integer docId);
}
