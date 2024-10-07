/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.minddevicetech.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author dell
 */
@Entity
@Table(name="USERR")
public class Userr implements Serializable {

    private String userName=null;
    private String Password=null;

    @Id
    @Column(name="USER_NAME")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name="PASSWORD")
    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

}
