package com.example.demo.entity;

public class Permission {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column permission.permissionId
     *
     * @mbg.generated Wed Jun 13 08:48:43 CST 2018
     */
    private Integer permissionid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column permission.typeId
     *
     * @mbg.generated Wed Jun 13 08:48:43 CST 2018
     */
    private Integer typeid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column permission.permissionName
     *
     * @mbg.generated Wed Jun 13 08:48:43 CST 2018
     */
    private String permissionname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column permission.permissionCode
     *
     * @mbg.generated Wed Jun 13 08:48:43 CST 2018
     */
    private String permissioncode;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column permission.permissionId
     *
     * @return the value of permission.permissionId
     *
     * @mbg.generated Wed Jun 13 08:48:43 CST 2018
     */
    public Integer getPermissionid() {
        return permissionid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column permission.permissionId
     *
     * @param permissionid the value for permission.permissionId
     *
     * @mbg.generated Wed Jun 13 08:48:43 CST 2018
     */
    public void setPermissionid(Integer permissionid) {
        this.permissionid = permissionid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column permission.typeId
     *
     * @return the value of permission.typeId
     *
     * @mbg.generated Wed Jun 13 08:48:43 CST 2018
     */
    public Integer getTypeid() {
        return typeid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column permission.typeId
     *
     * @param typeid the value for permission.typeId
     *
     * @mbg.generated Wed Jun 13 08:48:43 CST 2018
     */
    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column permission.permissionName
     *
     * @return the value of permission.permissionName
     *
     * @mbg.generated Wed Jun 13 08:48:43 CST 2018
     */
    public String getPermissionname() {
        return permissionname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column permission.permissionName
     *
     * @param permissionname the value for permission.permissionName
     *
     * @mbg.generated Wed Jun 13 08:48:43 CST 2018
     */
    public void setPermissionname(String permissionname) {
        this.permissionname = permissionname == null ? null : permissionname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column permission.permissionCode
     *
     * @return the value of permission.permissionCode
     *
     * @mbg.generated Wed Jun 13 08:48:43 CST 2018
     */
    public String getPermissioncode() {
        return permissioncode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column permission.permissionCode
     *
     * @param permissioncode the value for permission.permissionCode
     *
     * @mbg.generated Wed Jun 13 08:48:43 CST 2018
     */
    public void setPermissioncode(String permissioncode) {
        this.permissioncode = permissioncode == null ? null : permissioncode.trim();
    }
}