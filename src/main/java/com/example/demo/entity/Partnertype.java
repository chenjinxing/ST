package com.example.demo.entity;

public class Partnertype {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column partnertype.typeId
     *
     * @mbg.generated Tue Jun 12 16:59:45 CST 2018
     */
    private Integer typeid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column partnertype.typeName
     *
     * @mbg.generated Tue Jun 12 16:59:45 CST 2018
     */
    private String typename;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column partnertype.typeId
     *
     * @return the value of partnertype.typeId
     *
     * @mbg.generated Tue Jun 12 16:59:45 CST 2018
     */
    public Integer getTypeid() {
        return typeid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column partnertype.typeId
     *
     * @param typeid the value for partnertype.typeId
     *
     * @mbg.generated Tue Jun 12 16:59:45 CST 2018
     */
    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column partnertype.typeName
     *
     * @return the value of partnertype.typeName
     *
     * @mbg.generated Tue Jun 12 16:59:45 CST 2018
     */
    public String getTypename() {
        return typename;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column partnertype.typeName
     *
     * @param typename the value for partnertype.typeName
     *
     * @mbg.generated Tue Jun 12 16:59:45 CST 2018
     */
    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
    }
}