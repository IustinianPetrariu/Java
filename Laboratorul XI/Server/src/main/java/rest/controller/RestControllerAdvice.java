package rest.controller;


import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.ExceptionHandler;
import rest.exceptions.CustomNotFoundException;
import rest.model.ResponseMsg;

@org.springframework.web.bind.annotation.RestControllerAdvice
public class RestControllerAdvice {
    @ExceptionHandler(CustomNotFoundException.class)
    public ResponseMsg handleNotFoundException(CustomNotFoundException ex)
    {
        ResponseMsg responseMsg = new ResponseMsg(ex.getMessage());
        return responseMsg;
    }


}
