package ru.protei.demo.api.request;

import ru.protei.demo.entity.Status;

public class StatusRequest {


    private Status status;

    public StatusRequest(Status status) {

        this.status = status;
    }

    public StatusRequest() {
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
