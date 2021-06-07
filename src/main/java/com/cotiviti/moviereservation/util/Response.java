package com.cotiviti.moviereservation.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {

    private String message;
    private Object object;

    public ResponseEntity<?> success(Object o) {
        Response response = new Response();
        response.setMessage("Success");
        response.setObject(o);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<?> failed(Object o) {
        Response response = new Response();
        response.setMessage("Failed");
        response.setObject(o);
        return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
    }


}
