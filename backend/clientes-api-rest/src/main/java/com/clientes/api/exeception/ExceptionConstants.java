package com.clientes.api.exeception;

public class ExceptionConstants {

    public static final String MENSAJE = "mensaje";
    public static final String ERROR = "error";
    public static final String ERRORS = "errors";

    public static final String DATA_ACCESS_EXCEPTION = "DATA_ACCESS_EXCEPTION";
    public static final String DATA_ACCESS_EXCEPTION_ERROR_MESSAGE = "Error al realizar la consulta en la base de datos";

    public static final String CLIENT_NOT_FOUND_EXCEPTION = "CLIENT_NOT_FOUND_EXCEPTION";
    public static final String CLIENT_NOT_FOUND_ERROR_MESSAGE = "El cliente ID: ${first} no existe en la base de datos";

}
