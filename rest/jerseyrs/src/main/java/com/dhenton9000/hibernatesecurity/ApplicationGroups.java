package com.dhenton9000.hibernatesecurity;
// Generated Jun 17, 2010 4:41:51 PM by Hibernate Tools 3.2.1.GA



/**
 * ApplicationGroups generated by hbm2java
 */

public class ApplicationGroups  implements java.io.Serializable {


     private int id;
     private Groups groups;
     private Applications applications;

    public ApplicationGroups() {
    }

    public ApplicationGroups(int id, Groups groups, Applications applications) {
       this.id = id;
       this.groups = groups;
       this.applications = applications;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Groups getGroups() {
        return this.groups;
    }
    
    public void setGroups(Groups groups) {
        this.groups = groups;
    }
    public Applications getApplications() {
        return this.applications;
    }
   
    public void setApplications(Applications applications) {
        this.applications = applications;
    }




}


