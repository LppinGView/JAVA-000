package com.mysql.demo.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (TUser)实体类
 *
 * @author makejava
 * @since 2020-12-22 13:21:39
 */
public class TUser implements Serializable {
    private static final long serialVersionUID = 429680323545257214L;
    /**
     * id
     */
    private Long id;
    /**
     * uuid
     */
    private Long uuid;

    private String email;

    private String password;

    private String nickname;

    private String mobile;

    private Date createTime;

    private Date updateTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUuid() {
        return uuid;
    }

    public void setUuid(Long uuid) {
        this.uuid = uuid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}
