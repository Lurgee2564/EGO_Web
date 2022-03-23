package com.ego.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private int userID;
    private String userAccount;
    private String userName;
    private int userIdentity;
    private String userPassWord;
    private int userSex;
    private String userTelephone;
    private String userMail;
    private Date userBirthDay;
    private String userIntroduction;
    private String userLocation;
    private String userAvator;
    private Date userCreateTime;
    private Date userUpdateTime;



}
