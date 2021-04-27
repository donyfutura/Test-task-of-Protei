package ru.protei.demo.api.response;

import ru.protei.demo.entity.Status;
import com.fasterxml.jackson.annotation.JsonProperty;

public class StatusResponse {
    private long id;

    @JsonProperty("old_status")
    private Status oldStatus;

    @JsonProperty("new_status")
    private Status newStatus;

    public StatusResponse(long id, Status oldStatus, Status newStatus) {
        this.id = id;
        this.oldStatus = oldStatus;
        this.newStatus = newStatus;
    }

    public StatusResponse() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Status getOldStatus() {
        return oldStatus;
    }

    public void setOldStatus(Status oldStatus) {
        this.oldStatus = oldStatus;
    }

    public Status getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(Status newStatus) {
        this.newStatus = newStatus;
    }
}
