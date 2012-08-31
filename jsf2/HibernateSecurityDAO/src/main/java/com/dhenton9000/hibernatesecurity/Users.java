package com.dhenton9000.hibernatesecurity;
// Generated Jun 17, 2010 4:41:51 PM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Users generated by hbm2java
 */
public class Users  implements java.io.Serializable {


     private String userId;
     private String username;
     private Set groupAssignmentses = new HashSet(0);

    public Users() {
    }

	
    public Users(String userId) {
        this.userId = userId;
    }
    public Users(String userId, String username, Set groupAssignmentses) {
       this.userId = userId;
       this.username = username;
       this.groupAssignmentses = groupAssignmentses;
    }
   
    public String getUserId() {
        return this.userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public Set getGroupAssignmentses() {
        return this.groupAssignmentses;
    }
    
    public void setGroupAssignmentses(Set groupAssignmentses) {
        this.groupAssignmentses = groupAssignmentses;
    }


    @Override
    public String toString()
    {
        String info = "";
        info = "Id: "+userId+" -- name: "+username;


        return info;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Users other = (Users) obj;
        if ((this.userId == null) ? (other.userId != null) : !this.userId.equals(other.userId)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (this.userId != null ? this.userId.hashCode() : 0);
        return hash;
    }

}


