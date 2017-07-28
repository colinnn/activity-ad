package com.lenovo.ad.bean.game;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

/**
 * Created by chenlm3 on 2017/7/20.
 */
@Entity
@Table(name="xx_splash_intercept")
@JsonIgnoreProperties(value = {"id","createDate", "modifyDate"})
public class SplashIntercept{
    private static final long serialVersionUID = 5890311002839262275L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String packageName ;// 包名

    private Date startDate;// 拦截开始日期

    private Date endDate;// 拦截结束日期

    private Time startTime;// 拦截开始时间点

    private Time endTime;// 拦截结束时间点

    private Integer showTime;// 广告展示时间

    private Integer interceptCount;// 广告拦截次数

    private Long interceptSpace;// 两次拦截时间间隔

    private String flag;// 变更标志

    private Integer status;// 开光状态，1是开启，0是关闭

    private String app_id;


    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public Integer getShowTime() {
        return showTime;
    }

    public void setShowTime(Integer showTime) {
        this.showTime = showTime;
    }

    public Integer getInterceptCount() {
        return interceptCount;
    }

    public void setInterceptCount(Integer interceptCount) {
        this.interceptCount = interceptCount;
    }

    public Long getInterceptSpace() {
        return interceptSpace;
    }

    public void setInterceptSpace(Long interceptSpace) {
        this.interceptSpace = interceptSpace;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }
}