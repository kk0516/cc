package com.xiaoshu.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "k_kuai")
public class Kuai implements Serializable {
    @Id
    @Column(name = "k_id")
    private Integer kId;

    @Column(name = "k_name")
    private String kName;

    private static final long serialVersionUID = 1L;

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

    /**
     * @return k_name
     */
    public String getkName() {
        return kName;
    }

    /**
     * @param kName
     */
    public void setkName(String kName) {
        this.kName = kName == null ? null : kName.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", kId=").append(kId);
        sb.append(", kName=").append(kName);
        sb.append("]");
        return sb.toString();
    }
}