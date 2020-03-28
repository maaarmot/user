package com.medical.demo.model;

public class Doctor {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column doctor.id
     *
     * @mbg.generated Wed Mar 25 21:06:10 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column doctor.depId
     *
     * @mbg.generated Wed Mar 25 21:06:10 CST 2020
     */
    private Integer depid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column doctor.posId
     *
     * @mbg.generated Wed Mar 25 21:06:10 CST 2020
     */
    private Integer posid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column doctor.detail
     *
     * @mbg.generated Wed Mar 25 21:06:10 CST 2020
     */
    private String detail;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column doctor.intro
     *
     * @mbg.generated Wed Mar 25 21:06:10 CST 2020
     */
    private String intro;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column doctor.regCount
     *
     * @mbg.generated Wed Mar 25 21:06:10 CST 2020
     */
    private Integer regcount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column doctor.inqCount
     *
     * @mbg.generated Wed Mar 25 21:06:10 CST 2020
     */
    private Integer inqcount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column doctor.userId
     *
     * @mbg.generated Wed Mar 25 21:06:10 CST 2020
     */
    private Integer userid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column doctor.id
     *
     * @return the value of doctor.id
     *
     * @mbg.generated Wed Mar 25 21:06:10 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column doctor.id
     *
     * @param id the value for doctor.id
     *
     * @mbg.generated Wed Mar 25 21:06:10 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column doctor.depId
     *
     * @return the value of doctor.depId
     *
     * @mbg.generated Wed Mar 25 21:06:10 CST 2020
     */
    public Integer getDepid() {
        return depid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column doctor.depId
     *
     * @param depid the value for doctor.depId
     *
     * @mbg.generated Wed Mar 25 21:06:10 CST 2020
     */
    public void setDepid(Integer depid) {
        this.depid = depid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column doctor.posId
     *
     * @return the value of doctor.posId
     *
     * @mbg.generated Wed Mar 25 21:06:10 CST 2020
     */
    public Integer getPosid() {
        return posid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column doctor.posId
     *
     * @param posid the value for doctor.posId
     *
     * @mbg.generated Wed Mar 25 21:06:10 CST 2020
     */
    public void setPosid(Integer posid) {
        this.posid = posid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column doctor.detail
     *
     * @return the value of doctor.detail
     *
     * @mbg.generated Wed Mar 25 21:06:10 CST 2020
     */
    public String getDetail() {
        return detail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column doctor.detail
     *
     * @param detail the value for doctor.detail
     *
     * @mbg.generated Wed Mar 25 21:06:10 CST 2020
     */
    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column doctor.intro
     *
     * @return the value of doctor.intro
     *
     * @mbg.generated Wed Mar 25 21:06:10 CST 2020
     */
    public String getIntro() {
        return intro;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column doctor.intro
     *
     * @param intro the value for doctor.intro
     *
     * @mbg.generated Wed Mar 25 21:06:10 CST 2020
     */
    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column doctor.regCount
     *
     * @return the value of doctor.regCount
     *
     * @mbg.generated Wed Mar 25 21:06:10 CST 2020
     */
    public Integer getRegcount() {
        return regcount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column doctor.regCount
     *
     * @param regcount the value for doctor.regCount
     *
     * @mbg.generated Wed Mar 25 21:06:10 CST 2020
     */
    public void setRegcount(Integer regcount) {
        this.regcount = regcount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column doctor.inqCount
     *
     * @return the value of doctor.inqCount
     *
     * @mbg.generated Wed Mar 25 21:06:10 CST 2020
     */
    public Integer getInqcount() {
        return inqcount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column doctor.inqCount
     *
     * @param inqcount the value for doctor.inqCount
     *
     * @mbg.generated Wed Mar 25 21:06:10 CST 2020
     */
    public void setInqcount(Integer inqcount) {
        this.inqcount = inqcount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column doctor.userId
     *
     * @return the value of doctor.userId
     *
     * @mbg.generated Wed Mar 25 21:06:10 CST 2020
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column doctor.userId
     *
     * @param userid the value for doctor.userId
     *
     * @mbg.generated Wed Mar 25 21:06:10 CST 2020
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}