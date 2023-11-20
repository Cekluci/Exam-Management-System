package com.nye.springboot.DTO.ExamList;

public class ExamList {

    private Long examId;
    private String examName;


    public ExamList() {
    }

    public ExamList(Long examId, String examName) {
        this.examId = examId;
        this.examName = examName;
    }


    public Long getExamId() {
        return this.examId;
    }

    public void setExamId(Long examId) {
        this.examId = examId;
    }

    public String getExamName() {
        return this.examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

}
