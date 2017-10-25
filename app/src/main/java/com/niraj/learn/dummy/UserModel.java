package com.niraj.learn.dummy;

import java.io.Serializable;

/**
 * Created by niraj on 26/10/17.
 */

public class UserModel implements Serializable{

    private String lname,fname,username,password;

    boolean is_logedin;


    public UserModel (String fname,String lname,String username,String password)
    {
        this.username=username;
        this.lname=lname;
        this.fname=fname;
        this.password=password;
        this.is_logedin=true;

    }

    public String getLname(){
        return lname;
    }
    public String getFname(){
        return fname;
    }
    public String getUsername(){
        return username;
    }
    public boolean isIs_logedin(){
        return is_logedin;
    }

    public int isValid()
    {
        if (fname.length()==0)
        {
            return 1;
        }
        if (lname.length()==0)
        {
            return 2;
        }
        if (username.length()<5)
        {
            return 3;
        }
        if (password.length()<5)
        {
            return 4;
        }

        return 5;
    }

}
