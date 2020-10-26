package com.hnkc.ydcj.main.wisdomPatrol.bean;

public class WisdTaskBean {
    private String taskID;
    private String taskType;
    private String taskName;
    private String taskState;


    public WisdTaskBean(String taskID, String taskState, String taskType, String taskName) {
        this.taskID = taskID;
        this.taskType = taskType;
        this.taskName = taskName;
        this.taskState = taskState;
    }

    public String getTaskState() {
        return taskState;
    }

    public String getTaskID() {
        return taskID;
    }

    public String getTaskType() {
        return taskType;
    }

    public String getTaskName() {
        return taskName;
    }
}
