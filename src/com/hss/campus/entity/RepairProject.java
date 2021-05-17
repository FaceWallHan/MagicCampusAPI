package com.hss.campus.entity;

//报修项目
public class RepairProject {
    private Integer id;
    private String smallProject;
    private String bigProject;

    public RepairProject() {
    }

    public RepairProject(Integer id, String smallProject, String bigProject) {
        this.id = id;
        this.smallProject = smallProject;
        this.bigProject = bigProject;
    }

    @Override
    public String toString() {
        return "RepairProject{" +
                "id=" + id +
                ", smallProject='" + smallProject + '\'' +
                ", bigProject='" + bigProject + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSmallProject() {
        return smallProject;
    }

    public void setSmallProject(String smallProject) {
        this.smallProject = smallProject;
    }

    public String getBigProject() {
        return bigProject;
    }

    public void setBigProject(String bigProject) {
        this.bigProject = bigProject;
    }
}
