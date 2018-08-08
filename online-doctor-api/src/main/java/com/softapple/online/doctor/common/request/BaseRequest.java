/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softapple.online.doctor.common.request;

import java.util.List;

/**
 *
 * @author Md. Zakir Hossain
 */
public class BaseRequest {

    private String academicYear;
    
    private String classConfigId;
    
    private Long groupId;
    
    private Long studentCategoryId;
    
    private int studentRoll;
    
    private String instituteId;  
    
    private Long classId;
    
    private Long shiftId;
    
    private Long sectionId; 
    
    private Long studentIdentificationId;
    
    private List<Long> identificationIds;
    
    private Long periodId;
    
    private List<String> studentIds;
 
    private List<Long> groupIds;
    
    public String getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }

    public String getClassConfigId() {
        return classConfigId;
    }

    public void setClassConfigId(String classConfigId) {
        this.classConfigId = classConfigId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getStudentCategoryId() {
        return studentCategoryId;
    }

    public void setStudentCategoryId(Long studentCategoryId) {
        this.studentCategoryId = studentCategoryId;
    }

    public int getStudentRoll() {
        return studentRoll;
    }

    public void setStudentRoll(int studentRoll) {
        this.studentRoll = studentRoll;
    }

    public String getInstituteId() {
        return instituteId;
    }

    public void setInstituteId(String instituteId) {
        this.instituteId = instituteId;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public Long getShiftId() {
        return shiftId;
    }

    public void setShiftId(Long shiftId) {
        this.shiftId = shiftId;
    }

    public Long getSectionId() {
        return sectionId;
    }

    public void setSectionId(Long sectionId) {
        this.sectionId = sectionId;
    }

    public Long getStudentIdentificationId() {
        return studentIdentificationId;
    }

    public void setStudentIdentificationId(Long studentIdentificationId) {
        this.studentIdentificationId = studentIdentificationId;
    }

    public List<Long> getIdentificationIds() {
        return identificationIds;
    }

    public void setIdentificationIds(List<Long> identificationIds) {
        this.identificationIds = identificationIds;
    }

    public Long getPeriodId() {
        return periodId;
    }

    public void setPeriodId(Long periodId) {
        this.periodId = periodId;
    }

    public List<String> getStudentIds() {
        return studentIds;
    }

    public void setStudentIds(List<String> studentIds) {
        this.studentIds = studentIds;
    }

    public List<Long> getGroupIds() {
        return groupIds;
    }

    public void setGroupIds(List<Long> groupIds) {
        this.groupIds = groupIds;
    }

  }
