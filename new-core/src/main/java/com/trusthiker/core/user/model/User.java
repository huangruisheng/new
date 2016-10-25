package com.trusthiker.core.user.model;

import com.trusthiker.dto.user.*;
import lombok.Data;

import java.util.Date;

/**
 * Created by rui on 16/10/22.
 */
@Data
public class User {

    private Long id; //id

    private Long no;//平台号码

    private String nickName; //昵称

    private Integer gender; //性别

    private Date birthday; //生日

    private Integer cityCode; //城市代码

    private String cityName;//城市名

    private String university;//大学

    private String occupation;//职业

    private String tags;//标签

    private Integer level;//等级

    private String name; //姓名

    private String idCard; //身份证

    private String linkedinNo;//linkedin 号码

    private Boolean isBindZhima;//是否绑定zhima信用

    private Integer zhimaScore;//芝麻分数

    private String zhimaNo; //芝麻号码

    private String educationNo;//学历号码

    private String webchatOpenId;//微信openId

    private String wechatUnionId;//微信unionId

    private Integer followerNum;//粉丝数量

    private Integer followNum;//关注数量

    private Integer circlePublishNum;//圈子发表数量

    private UserBindLinkedinStatus bindLinkedinStatus; //绑定linkedin状态

    private UserBindWebchatStatus bindWebchatStatus;//绑定微信状态

    private UserRealNameAuthStatus realNameAuthStatus; //实名认证状态

    private UserEducationAuthStatus educationAuthStatus; //学历认证状态

    private UserStatus status;//用户状态


}
