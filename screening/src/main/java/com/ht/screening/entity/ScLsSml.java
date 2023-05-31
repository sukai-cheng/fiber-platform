package com.ht.screening.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 石墨炉
 * @author chengsukai
 */
public class ScLsSml {
    private Integer id;

    private String lsbh;

    private BigDecimal lnqtyl;

    private BigDecimal lzsbqt;

    private BigDecimal lzzbqt;

    private BigDecimal mfgsysj;

    private BigDecimal zxgsysj;

    private BigDecimal bwgsysj;

    private Date lastupdatetime;

    private String lastupdateaccountid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLsbh() {
        return lsbh;
    }

    public void setLsbh(String lsbh) {
        this.lsbh = lsbh;
    }

    public BigDecimal getLnqtyl() {
        return lnqtyl;
    }

    public void setLnqtyl(BigDecimal lnqtyl) {
        this.lnqtyl = lnqtyl;
    }

    public BigDecimal getLzsbqt() {
        return lzsbqt;
    }

    public void setLzsbqt(BigDecimal lzsbqt) {
        this.lzsbqt = lzsbqt;
    }

    public BigDecimal getLzzbqt() {
        return lzzbqt;
    }

    public void setLzzbqt(BigDecimal lzzbqt) {
        this.lzzbqt = lzzbqt;
    }

    public BigDecimal getMfgsysj() {
        return mfgsysj;
    }

    public void setMfgsysj(BigDecimal mfgsysj) {
        this.mfgsysj = mfgsysj;
    }

    public BigDecimal getZxgsysj() {
        return zxgsysj;
    }

    public void setZxgsysj(BigDecimal zxgsysj) {
        this.zxgsysj = zxgsysj;
    }

    public BigDecimal getBwgsysj() {
        return bwgsysj;
    }

    public void setBwgsysj(BigDecimal bwgsysj) {
        this.bwgsysj = bwgsysj;
    }

    public Date getLastupdatetime() {
        return lastupdatetime;
    }

    public void setLastupdatetime(Date lastupdatetime) {
        this.lastupdatetime = lastupdatetime;
    }

    public String getLastupdateaccountid() {
        return lastupdateaccountid;
    }

    public void setLastupdateaccountid(String lastupdateaccountid) {
        this.lastupdateaccountid = lastupdateaccountid;
    }
}