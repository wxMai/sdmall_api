package com.mmall.vo;

import com.mmall.pojo.Shipping;
import com.mmall.pojo.User;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by geely
 */
public class UserVo
{

    private Integer id;

    private String username;

    private String password;

    private String email;

    private String phone;

    private String question;

    private String answer;

    private Integer role;

    private Date createTime;

    private Date updateTime;

    private Shipping shipping;

    public UserVo(Integer id, String username, String password, String email, String phone, String question, String answer, Integer role, Date createTime, Date updateTime)
    {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.question = question;
        this.answer = answer;
        this.role = role;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public UserVo()
    {
        super();
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username == null ? null : username.trim();
    }

    public void setValueByUser(User user)
    {
        this.id = user.getId();
        this.username = user.getUsername();
        this.phone = user.getPhone();
        this.email = user.getEmail();
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password == null ? null : password.trim();
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getQuestion()
    {
        return question;
    }

    public void setQuestion(String question)
    {
        this.question = question == null ? null : question.trim();
    }

    public String getAnswer()
    {
        return answer;
    }

    public void setAnswer(String answer)
    {
        this.answer = answer == null ? null : answer.trim();
    }

    public Integer getRole()
    {
        return role;
    }

    public void setRole(Integer role)
    {
        this.role = role;
    }

    public Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public Date getUpdateTime()
    {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime)
    {
        this.updateTime = updateTime;
    }

    public Shipping getShipping()
    {
        return shipping;
    }

    public void setShipping(Shipping shipping)
    {
        this.shipping = shipping;
    }


}
