package com.example.Task1.Model.Data;

import com.example.Task1.Model.JFile.ProjectData;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Project {

    @JsonProperty("data")
    private List<ProjectData> data;

    public List<ProjectData> getData() {
        return data;
    }

    public void setData(List<ProjectData> data) {
        this.data = data;
    }
}
