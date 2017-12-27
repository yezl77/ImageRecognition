package com.ssm.entity;

import java.util.Date;

public class Image {
    private Integer id;

    private String name;

    private String origin;

    private String separateposition;

    private String bacterial;

    private String method;

    private String remark;

    private Date uploadtime;

    private String province;

    private String city;

    private String location;

    private String url;

    private String urlMini;

    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin == null ? null : origin.trim();
    }

    public String getSeparateposition() {
        return separateposition;
    }

    public void setSeparateposition(String separateposition) {
        this.separateposition = separateposition == null ? null : separateposition.trim();
    }

    public String getBacterial() {
        return bacterial;
    }

    public void setBacterial(String bacterial) {
        this.bacterial = bacterial == null ? null : bacterial.trim();
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getUploadtime() {
        return uploadtime;
    }

    public void setUploadtime(Date uploadtime) {
        this.uploadtime = uploadtime;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getUrlMini() {
        return urlMini;
    }

    public void setUrlMini(String urlMini) {
        this.urlMini = urlMini == null ? null : urlMini.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}