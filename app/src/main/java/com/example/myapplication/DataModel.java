package com.example.myapplication;

import java.text.SimpleDateFormat;

public class DataModel {
    String assessment_id, assessment_name, assessment_date, assessment_description;
    int assesment_duration;
    DataModel(String assessment_id, String assessment_name, String assessment_date,
              int assesment_duration, String assessment_description){
        this.assessment_id = assessment_id;
        this.assessment_name = assessment_name;
        this.assessment_date = assessment_date;
        this.assesment_duration = assesment_duration;
        this.assessment_description = assessment_description;
    }

    public String getAssessment_id() {
        return assessment_id;
    }

    public String getAssessment_name() {
        return assessment_name;
    }

    public int getAssesment_duration() {
        return assesment_duration/60;
    }

    public String getAssessment_date() {
        return assessment_date;
    }

    public String getAssessment_description() {
        return assessment_description;
    }
}
