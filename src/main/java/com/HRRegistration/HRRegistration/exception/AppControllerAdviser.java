package com.HRRegistration.HRRegistration.exception;

import com.HRRegistration.HRRegistration.controller.response.EmployeeResponse;
import com.HRRegistration.HRRegistration.controller.response.MsgResp;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppControllerAdviser {
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler({EmployeeNotFoundException.class})
    public MsgResp handleException(Exception exception){
        MsgResp msgResp=new MsgResp();
        System.out.println(exception.getMessage());
        msgResp.setMsg(exception.getMessage());
        return msgResp;
    }
}
