package com.xiaoshu.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Table(name = "e_express")
public class Express implements Serializable {
    @Id
    @Column(name = "e_id")
    private Integer eId;

    @Column(name = "e_name")
    private String eName;

     @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(name = "e_createtime")
    private Date eCreatetime;

    @Column(name = "e_zhi")
    private String eZhi;

    @Column(name = "k_id")
    private Integer kId;

    private static final long serialVersionUID = 1L;

    /**
     * @return e_id
     */
    public Integer geteId() {
        return eId;
    }

    /**
     * @param eId
     */
    public void seteId(Integer eId) {
        this.eId = eId;
    }

    /**
     * @return e_name
     */
    public String geteName() {
        return eName;
    }

    /**
     * @param eName
     */
    public void seteName(String eName) {
        this.eName = eName == null ? null : eName.trim();
    }

    /**
     * @return e_createtime
     */
    public Date geteCreatetime() {
        return eCreatetime;
    }

    /**
     * @param eCreatetime
     */
    public void seteCreatetime(Date eCreatetime) {
        this.eCreatetime = eCreatetime;
    }

    /**
     * @return e_zhi
     */
    public String geteZhi() {
        return eZhi;
    }

    /**
     * @param eZhi
     */
    public void seteZhi(String eZhi) {
        this.eZhi = eZhi == null ? null : eZhi.trim();
    }

    /**
     * @return k_id
     */
    public Integer getkId() {
        return kId;
    }

    /**
     * @param kId
     */
    public void setkId(Integer kId) {
        this.kId = kId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", eId=").append(eId);
        sb.append(", eName=").append(eName);
        sb.append(", eCreatetime=").append(eCreatetime);
        sb.append(", eZhi=").append(eZhi);
        sb.append(", kId=").append(kId);
        sb.append("]");
        return sb.toString();
    }
}