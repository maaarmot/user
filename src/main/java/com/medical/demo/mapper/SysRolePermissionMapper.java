package com.medical.demo.mapper;

import com.medical.demo.model.SysRolePermissionExample;
import com.medical.demo.model.SysRolePermissionKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SysRolePermissionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_permission
     *
     * @mbg.generated Wed Mar 25 21:06:10 CST 2020
     */
    long countByExample(SysRolePermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_permission
     *
     * @mbg.generated Wed Mar 25 21:06:10 CST 2020
     */
    int deleteByExample(SysRolePermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_permission
     *
     * @mbg.generated Wed Mar 25 21:06:10 CST 2020
     */
    int deleteByPrimaryKey(SysRolePermissionKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_permission
     *
     * @mbg.generated Wed Mar 25 21:06:10 CST 2020
     */
    int insert(SysRolePermissionKey record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_permission
     *
     * @mbg.generated Wed Mar 25 21:06:10 CST 2020
     */
    int insertSelective(SysRolePermissionKey record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_permission
     *
     * @mbg.generated Wed Mar 25 21:06:10 CST 2020
     */
    List<SysRolePermissionKey> selectByExampleWithRowbounds(SysRolePermissionExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_permission
     *
     * @mbg.generated Wed Mar 25 21:06:10 CST 2020
     */
    List<SysRolePermissionKey> selectByExample(SysRolePermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_permission
     *
     * @mbg.generated Wed Mar 25 21:06:10 CST 2020
     */
    int updateByExampleSelective(@Param("record") SysRolePermissionKey record, @Param("example") SysRolePermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_permission
     *
     * @mbg.generated Wed Mar 25 21:06:10 CST 2020
     */
    int updateByExample(@Param("record") SysRolePermissionKey record, @Param("example") SysRolePermissionExample example);
}