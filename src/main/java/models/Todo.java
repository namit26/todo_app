package models;

import java.util.Date;

public class Todo {

    private long todoId = -1;
    private String title = "";
    private String desc = "";
    private Date created;
    private String status = "UnAssigned";
    private String assignedTo = null;
    private String createdBy = null;


    public Todo(int todoId, String title, String desc) {
        this.todoId = todoId;
        this.title = title;
        this.desc = desc;
        this.created = new Date();

    }

    public synchronized void setCreatedBy(String createdBy){
        this.createdBy = createdBy;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public synchronized void setAssignedTo(String assignedTo){
        setStatus("Assigned");
        this.assignedTo = assignedTo;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public long getTodoId() {
        return todoId;
    }

    public synchronized void setStatus(String status){
        setCreated(new Date());
        this.status = status;
    }

    public String getStatus(){

        return this.status;
    }

    public String getTitle() {
        return title;
    }

    public synchronized void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public synchronized void setDesc(String desc) {
        this.desc = desc;
    }

    public synchronized void setCreated(Date date) {
        this.created = date;
    }

    public Date getCreated() {
        return created;
    }

}
