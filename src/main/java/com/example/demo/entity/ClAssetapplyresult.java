package com.example.demo.entity;

public class ClAssetapplyresult {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cl_assetapplyresult.proId
     *
     * @mbg.generated Fri Jul 13 10:25:43 CST 2018
     */
    private Integer proid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cl_assetapplyresult.statusId
     *
     * @mbg.generated Fri Jul 13 10:25:43 CST 2018
     */
    private Integer statusid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cl_assetapplyresult.leaseCode
     *
     * @mbg.generated Fri Jul 13 10:25:43 CST 2018
     */
    private String leasecode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cl_assetapplyresult.msg
     *
     * @mbg.generated Fri Jul 13 10:25:43 CST 2018
     */
    private String msg;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cl_assetapplyresult.time
     *
     * @mbg.generated Fri Jul 13 10:25:43 CST 2018
     */
    private String time;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cl_assetapplyresult.proId
     *
     * @return the value of cl_assetapplyresult.proId
     *
     * @mbg.generated Fri Jul 13 10:25:43 CST 2018
     */
    public Integer getProid() {
        return proid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cl_assetapplyresult.proId
     *
     * @param proid the value for cl_assetapplyresult.proId
     *
     * @mbg.generated Fri Jul 13 10:25:43 CST 2018
     */
    public void setProid(Integer proid) {
        this.proid = proid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cl_assetapplyresult.statusId
     *
     * @return the value of cl_assetapplyresult.statusId
     *
     * @mbg.generated Fri Jul 13 10:25:43 CST 2018
     */
    public Integer getStatusid() {
        return statusid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cl_assetapplyresult.statusId
     *
     * @param statusid the value for cl_assetapplyresult.statusId
     *
     * @mbg.generated Fri Jul 13 10:25:43 CST 2018
     */
    public void setStatusid(Integer statusid) {
        this.statusid = statusid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cl_assetapplyresult.leaseCode
     *
     * @return the value of cl_assetapplyresult.leaseCode
     *
     * @mbg.generated Fri Jul 13 10:25:43 CST 2018
     */
    public String getLeasecode() {
        return leasecode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cl_assetapplyresult.leaseCode
     *
     * @param leasecode the value for cl_assetapplyresult.leaseCode
     *
     * @mbg.generated Fri Jul 13 10:25:43 CST 2018
     */
    public void setLeasecode(String leasecode) {
        this.leasecode = leasecode == null ? null : leasecode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cl_assetapplyresult.msg
     *
     * @return the value of cl_assetapplyresult.msg
     *
     * @mbg.generated Fri Jul 13 10:25:43 CST 2018
     */
    public String getMsg() {
        return msg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cl_assetapplyresult.msg
     *
     * @param msg the value for cl_assetapplyresult.msg
     *
     * @mbg.generated Fri Jul 13 10:25:43 CST 2018
     */
    public void setMsg(String msg) {
        this.msg = msg == null ? null : msg.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cl_assetapplyresult.time
     *
     * @return the value of cl_assetapplyresult.time
     *
     * @mbg.generated Fri Jul 13 10:25:43 CST 2018
     */
    public String getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cl_assetapplyresult.time
     *
     * @param time the value for cl_assetapplyresult.time
     *
     * @mbg.generated Fri Jul 13 10:25:43 CST 2018
     */
    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }
}