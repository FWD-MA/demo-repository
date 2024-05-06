package com.test.FWD.common;

import lombok.Data;

import java.io.Serializable;


//统一返回的结果
@Data
public class Result<T> implements Serializable {


    private T data;

//    public static Result success(Object date){
//        Result result = new Result();
//        return result.
//    }

}
