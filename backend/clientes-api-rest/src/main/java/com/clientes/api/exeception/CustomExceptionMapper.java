package com.clientes.api.exeception;

import java.util.HashMap;
import java.util.Map;

import static com.clientes.api.exeception.ExceptionConstants.*;

public class CustomExceptionMapper {

    public static Map<String, String> APPLICATION_EXCEPTIONS = new HashMap<>() {{
        put(DATA_ACCESS_EXCEPTION, DATA_ACCESS_EXCEPTION_ERROR_MESSAGE);
        put(CLIENT_NOT_FOUND_EXCEPTION, CLIENT_NOT_FOUND_ERROR_MESSAGE);
    }};

}
