package com.restfulAPI.rest.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    private String Message;
    private String TypeOfData;
    private LocalDateTime DateTimeCreated;

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getTypeOfData() {
        return TypeOfData;
    }

    public void setTypeOfData(String typeOfData) {
        TypeOfData = typeOfData;
    }

    public LocalDateTime getDateTimeCreated() {
        return DateTimeCreated;
    }

    public void setDateTimeCreated(LocalDateTime dateTimeCreated) {
        DateTimeCreated = dateTimeCreated;
    }
}
