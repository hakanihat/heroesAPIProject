package com.tinqin.project.error;

import com.tinqin.project.generics.Error;
import org.springframework.http.HttpStatus;

public class HeroServiceUnavailableError implements Error {
    @Override
    public String getMessage() {
        return "Hero service is unavailable!";
    }

    @Override
    public HttpStatus getCode() {
        return HttpStatus.SERVICE_UNAVAILABLE;
    }
}
