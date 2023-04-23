package com.clientes.api.util;

public class ApplicationUtil {

    public static String buildErrorMessage(String errorMessage, String argument) {
        return errorMessage.replace("${first}", argument);
    }

}
