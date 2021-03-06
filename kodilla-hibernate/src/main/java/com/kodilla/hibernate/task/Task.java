package com.kodilla.hibernate.task;

import com.kodilla.hibernate.taskslist.TasksList;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@NamedQueries ({
        @NamedQuery (
                name = "Task.retrieveLongTasks",
                query = "FROM Task WHERE duration > 10"

        ),

        @NamedQuery (
                name = "Task.retrieveShortTasks",
                query = "FROM Task where duration <= 10"
        ),
        @NamedQuery (
                name = "Task.retrieveTasksWithDurationLongerThan",
                query = "FROM Task WHERE Duration > :DURATION"
        )
})

@NamedNativeQuery(
        name = "Task.retrieveTasksWithEnoughTime",
        query = "SELECT * FROM TASKS" +
                " WHERE DATEDIFF(DATE_ADD(CREATED, INTERVAL DURATION DAY), NOW()) > 5",
        resultClass = Task.class
)

@Entity
@Table(name = "Tasks")

public class Task {
    private int id;
    private String description;
    private Date created;
    private int duration;
    private TaskFinancialDetails taskFinancialDetails;
    private TasksList tasksList;

    public Task() {
    }

    public Task(String description, int duration) {
        this.description = description;
        this.created = new Date();
        this.duration = duration;
    }

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "ID", unique = true)
    public int getId() {
        return id;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    @NotNull
    @Column(name = "CREATED")
    public Date getCreated() {
        return created;
    }

    public int getDuration() {
        return duration;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    private void setCreated(Date created) {
        this.created = created;
    }

    private void setDuration(int duration) {
        this.duration = duration;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "TASKS_FINANCIALS_ID")
    public TaskFinancialDetails getTaskFinancialDetails() {
        return taskFinancialDetails;
    }

    public void setTaskFinancialDetails(TaskFinancialDetails taskFinancialDetails) {
        this.taskFinancialDetails = taskFinancialDetails;
    }

    @ManyToOne
    @JoinColumn
    public TasksList getTasksList() {
        return tasksList;
    }

    public void setTasksList(TasksList tasksList) {
        this.tasksList = tasksList;
    }
}