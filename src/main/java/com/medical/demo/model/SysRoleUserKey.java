package com.medical.demo.model;

public class SysRoleUserKey {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role_user.userId
     *
     * @mbg.generated Wed Mar 25 21:06:10 CST 2020
     */
    private Integer userid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role_user.roleId
     *
     * @mbg.generated Wed Mar 25 21:06:10 CST 2020
     */
    private Integer roleid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role_user.userId
     *
     * @return the value of sys_role_user.userId
     *
     * @mbg.generated Wed Mar 25 21:06:10 CST 2020
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role_user.userId
     *
     * @param userid the value for sys_role_user.userId
     *
     * @mbg.generated Wed Mar 25 21:06:10 CST 2020
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role_user.roleId
     *
     * @return the value of sys_role_user.roleId
     *
     * @mbg.generated Wed Mar 25 21:06:10 CST 2020
     */
    public Integer getRoleid() {
        return roleid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role_user.roleId
     *
     * @param roleid the value for sys_role_user.roleId
     *
     * @mbg.generated Wed Mar 25 21:06:10 CST 2020
     */
    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }
}