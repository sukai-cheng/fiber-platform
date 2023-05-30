package com.ht.shaixuan.entity;

import java.util.Date;

/**
 * 拉丝产量表
 * @author chengsukai
 */
public class ScLsCl {
    private String lsbh;

    private Integer itemid;

    private String bz;

    private Date scTime;

    private String zzpbh;

    private Double cd;

    private String zdr;

    private Double clxs;

    private Double wz;

    private Date lastupdatetime;

    private String lastupdateaccountid;

    private String brokenposition;

    public String getLsbh() {
        return lsbh;
    }

    public void setLsbh(String lsbh) {
        this.lsbh = lsbh;
    }

    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public Date getScTime() {
        return scTime;
    }

    public void setScTime(Date scTime) {
        this.scTime = scTime;
    }

    public String getZzpbh() {
        return zzpbh;
    }

    public void setZzpbh(String zzpbh) {
        this.zzpbh = zzpbh;
    }

    public Double getCd() {
        return cd;
    }

    public void setCd(Double cd) {
        this.cd = cd;
    }

    public String getZdr() {
        return zdr;
    }

    public void setZdr(String zdr) {
        this.zdr = zdr;
    }

    public Double getClxs() {
        return clxs;
    }

    public void setClxs(Double clxs) {
        this.clxs = clxs;
    }

    public Double getWz() {
        return wz;
    }

    public void setWz(Double wz) {
        this.wz = wz;
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

    public String getBrokenposition() {
        return brokenposition;
    }

    public void setBrokenposition(String brokenposition) {
        this.brokenposition = brokenposition;
    }
}