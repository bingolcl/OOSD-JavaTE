package com.example.cecihome.basicloginandregistersharedpreferences;

/**
 * Created by 689438 on 2018-03-19.
 */

import java.io.Serializable;
import java.util.Date;

public class Package implements Serializable {
    private static final long serialVersionUID = 1L;

    private int packageId;

    private String pkgName;

    private Date pkgStartDate;

    private Date pkgEndDate;

    private String pkgDesc;

    private Double pkgBasePrice;

    private Double 	PkgAgencyCommission;


    public Package() {
    }

    public Package(int packageId, String pkgName, Date pkgStartDate, Date pkgEndDate, String pkgDesc, Double pkgBasePrice, Double pkgAgencyCommission) {
        this.packageId = packageId;
        this.pkgName = pkgName;
        this.pkgStartDate = pkgStartDate;
        this.pkgEndDate = pkgEndDate;
        this.pkgDesc = pkgDesc;
        this.pkgBasePrice = pkgBasePrice;
        PkgAgencyCommission = pkgAgencyCommission;
    }

    public Package(int packageId, String pkgName, String pkgDesc) {
        this.packageId = packageId;
        this.pkgName = pkgName;
        this.pkgDesc = pkgDesc;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getPackageId() {
        return packageId;
    }

    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }

    public String getPkgName() {
        return pkgName;
    }

    public void setPkgName(String pkgName) {
        this.pkgName = pkgName;
    }

    public Date getPkgStartDate() {
        return pkgStartDate;
    }

    public void setPkgStartDate(Date pkgStartDate) {
        this.pkgStartDate = pkgStartDate;
    }

    public Date getPkgEndDate() {
        return pkgEndDate;
    }

    public void setPkgEndDate(Date pkgEndDate) {
        this.pkgEndDate = pkgEndDate;
    }

    public String getPkgDesc() {
        return pkgDesc;
    }

    public void setPkgDesc(String pkgDesc) {
        this.pkgDesc = pkgDesc;
    }

    public Double getPkgBasePrice() {
        return pkgBasePrice;
    }

    public void setPkgBasePrice(Double pkgBasePrice) {
        this.pkgBasePrice = pkgBasePrice;
    }

    public Double getPkgAgencyCommission() {
        return PkgAgencyCommission;
    }

    public void setPkgAgencyCommission(Double pkgAgencyCommission) {
        PkgAgencyCommission = pkgAgencyCommission;
    }

    @Override
    public String toString() {
        return pkgName + " - " + pkgDesc;
    }
}