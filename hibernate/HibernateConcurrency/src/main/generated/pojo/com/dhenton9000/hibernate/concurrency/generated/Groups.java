package com.dhenton9000.hibernate.concurrency.generated;
// Generated May 26, 2011 1:33:09 PM by Hibernate Tools 3.2.2.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Groups generated by hbm2java
 */
public class Groups  implements java.io.Serializable {


     private Integer id;
     private Integer version;
     private String groupName;
     private Set applicationGroupses = new HashSet(0);
     private Set groupAssignmentses = new HashSet(0);

    public Groups() {
    }

    public Groups(String groupName, Set applicationGroupses, Set groupAssignmentses) {
       this.groupName = groupName;
       this.applicationGroupses = applicationGroupses;
       this.groupAssignmentses = groupAssignmentses;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getVersion() {
        return this.version;
    }
    
    public void setVersion(Integer version) {
        this.version = version;
    }
    public String getGroupName() {
        return this.groupName;
    }
    
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    public Set getApplicationGroupses() {
        return this.applicationGroupses;
    }
    
    public void setApplicationGroupses(Set applicationGroupses) {
        this.applicationGroupses = applicationGroupses;
    }
    public Set getGroupAssignmentses() {
        return this.groupAssignmentses;
    }
    
    public void setGroupAssignmentses(Set groupAssignmentses) {
        this.groupAssignmentses = groupAssignmentses;
    }




}


