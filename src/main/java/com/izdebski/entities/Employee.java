package com.izdebski.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.Table;

@Entity
@Table(name="employee")

@NamedEntityGraphs(value = {
        @NamedEntityGraph(name="employee.projects",attributeNodes=@NamedAttributeNode("projects"))
})
public class Employee {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="employee_name",length=60)
    private String employeeName;

    @Column(name="user_name",length=60,nullable=false)
    private String username;

    @Column(name="password",nullable=false)
    private String password;

    @Column(name="access_level")
    private int accessLevel;

    @ManyToOne
    @JoinColumn(name="department_id")
    private Department department;

    @ManyToMany(mappedBy="employees",cascade=CascadeType.PERSIST)
    private List<Project> projects = new ArrayList<Project>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }

    public int getAccessLevel() {
        return accessLevel;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
    public List<Project> getProjects() {
        return projects;
    }
}