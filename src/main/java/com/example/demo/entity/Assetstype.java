package com.example.demo.entity;

public class Assetstype {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column assetstype.typeId
     *
     * @mbg.generated Wed Jun 13 10:19:49 CST 2018
     */
    private Integer typeid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column assetstype.typeName
     *
     * @mbg.generated Wed Jun 13 10:19:49 CST 2018
     */
    private String typename;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column assetstype.typeId
     *
     * @return the value of assetstype.typeId
     *
     * @mbg.generated Wed Jun 13 10:19:49 CST 2018
     */
    public Integer getTypeid() {
        return typeid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column assetstype.typeId
     *
     * @param typeid the value for assetstype.typeId
     *
     * @mbg.generated Wed Jun 13 10:19:49 CST 2018
     */
    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column assetstype.typeName
     *
     * @return the value of assetstype.typeName
     *
     * @mbg.generated Wed Jun 13 10:19:49 CST 2018
     */
    public String getTypename() {
        return typename;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column assetstype.typeName
     *
     * @param typename the value for assetstype.typeName
     *
     * @mbg.generated Wed Jun 13 10:19:49 CST 2018
     */
    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
    }
}