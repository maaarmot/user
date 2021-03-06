package com.medical.demo.mapper;

import com.medical.demo.model.SysRoleUserExample;
import com.medical.demo.model.SysRoleUserKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SysRoleUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_user
     *
     * @mbg.generated Wed Mar 25 21:06:10 CST 2020
     */
    long countByExample(SysRoleUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_user
     *
     * @mbg.generated Wed Mar 25 21:06:10 CST 2020
     */
    int deleteByExample(SysRoleUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_user
     *
     * @mbg.generated Wed Mar 25 21:06:10 CST 2020
     */
    int deleteByPrimaryKey(SysRoleUserKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_user
     *
     * @mbg.generated Wed Mar 25 21:06:10 CST 2020
     */
    int insert(SysRoleUserKey record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_user
     *
     * @mbg.generated Wed Mar 25 21:06:10 CST 2020
     */
    int insertSelective(SysRoleUserKey record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_user
     *
     * @mbg.generated Wed Mar 25 21:06:10 CST 2020
     */
    List<SysRoleUserKey> selectByExampleWithRowbounds(SysRoleUserExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_user
     *
     * @mbg.generated Wed Mar 25 21:06:10 CST 2020
     */
    List<SysRoleUserKey> selectByExample(SysRoleUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_user
     *
     * @mbg.generated Wed Mar 25 21:06:10 CST 2020
     */
    int updateByExampleSelective(@Param("record") SysRoleUserKey record, @Param("example") SysRoleUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_user
     *
     * @mbg.generated Wed Mar 25 21:06:10 CST 2020
     */
    int updateByExample(@Param("record") SysRoleUserKey record, @Param("example") SysRoleUserExample example);
}