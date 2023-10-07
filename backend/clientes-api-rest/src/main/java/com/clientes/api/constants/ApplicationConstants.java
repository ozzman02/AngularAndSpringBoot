package com.clientes.api.constants;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ApplicationConstants {

    public static final Path UPLOADS_DIRECTORY = Paths.get("uploads");
    public static final Path IMAGES_DIRECTORY = Paths.get("src/main/resources/static/images");
    public static final String NO_USER_ICON_IMAGE_NAME = "no_user_icon.png";

    public static final String ANGULAR_APP_ORIGIN_URL = "http://localhost:4200";
    public static final String BASE_MAPPING = "/api";

    public static final int PAGE_SIZE = 4;

    public static final String MENSAJE = "mensaje";
    public static final String ERROR = "error";
    public static final String ERRORS = "errors";
    public static final String CAUSE = "cause";

    public static final String DATA_ACCESS_EXCEPTION = "DATA_ACCESS_EXCEPTION";
    public static final String DATA_ACCESS_EXCEPTION_ERROR_MESSAGE = "Error al realizar la consulta en la base de datos";

    public static final String CLIENT_NOT_FOUND_EXCEPTION = "CLIENT_NOT_FOUND_EXCEPTION";
    public static final String CLIENT_NOT_FOUND_ERROR_MESSAGE = "El cliente ID: ${first} no existe en la base de datos";

    public static final String FILE_UPLOAD_EXCEPTION = "FILE_UPLOAD_EXCEPTION";
    public static final String FILE_UPLOAD_EXCEPTION_ERROR_MESSAGE = "Error al subir la imagen del cliente. Nombre de la imagen: ${first}";

    public static final String DELETE_PROFILE_PHOTO_EXCEPTION = "DELETE_EXISTING_PROFILE_PHOTO_EXCEPTION";
    public static final String DELETE_PROFILE_PHOTO_EXCEPTION_ERROR_MESSAGE = "La imagen ${first} no tiene permisos de lectura";

    public static final String EMPTY_PROFILE_PHOTO_EXCEPTION = "EMPTY_FILE_EXCEPTION";
    public static final String EMPTY_PROFILE_PHOTO_EXCEPTION_ERROR_MESSAGE = "La imagen del perfil no puede estar vacía";

    public static final String MALFORMED_URL_EXCEPTION = "MALFORMED_URL_EXCEPTION";
    public static final String MALFORMED_URL_EXCEPTION_ERROR_MESSAGE = "Malformed URL has occurred";

    public static final String PROFILE_PHOTO_NOT_READABLE_EXCEPTION = "PROFILE_PHOTO_NOT_READABLE_EXCEPTION";
    public static final String PROFILE_PHOTO_NOT_READABLE_EXCEPTION_ERROR_MESSAGE = "La imagen ${first} no existe o no es legible";

    public static final String INVOICE_NOT_FOUND_EXCEPTION = "CLIENT_NOT_FOUND_EXCEPTION";
    public static final String INVOICE_NOT_FOUND_ERROR_MSG = "La factura #: ${first} no existe en la base de datos";

    public static final String TOKEN_KEY_ACCESS_PERMIT_ALL = "permitAll()";
    public static final String CHECK_TOKEN_ACCESS_IS_AUTHENTICATED = "isAuthenticated()";

    public static final String ANGULAR_CLIENT_NAME = "angularapp";
    public static final String ANGULAR_CLIENT_PASSWORD = "12345";
    public static final String SCOPE_READ = "read";
    public static final String SCOPE_WRITE = "write";
    public static final String PASSWORD_GRANT_TYPE = "password";
    public static final String REFRESH_TOKEN_GRANT_TYPE = "refresh_token";
    public static final int ACCESS_TOKEN_VALIDITY_SECONDS = 3600;
    public static final int REFRESH_TOKEN_VALIDITY_SECONDS = 3600;

    // Use these values when the prefix is not needed
    public static final String USER_ROLE = "USER";
    public static final String ADMIN_ROLE = "ADMIN";

    // Use these values when the prefix is needed
    public static final String ROLE_USER = "ROLE_USER";
    public static final String ROLE_ADMIN = "ROLE_ADMIN";

    public static final String[] PUBLIC_ENDPOINTS = {
            "/api/clientes",
            "/api/clientes/page/**",
            "/api/clientes/uploads/img/**",
            "/images/**",
            "/api/clientes/{id}",
            "/api/facturas/**"
    };

    public static final String SHOW_CLIENT_ENDPOINT = "/api/clientes/{id}";
    public static final String UPLOAD_CLIENT_ENDPOINT = "/api/clientes/upload";
    public static final String CREATE_CLIENT_ENDPOINT = "/api/clientes";
    public static final String PRIVATE_ENDPOINTS ="/api/clientes/**";

    public static final String ANGULAR_APP_ALLOWED_ORIGIN = "http://localhost:4200";
    public static final String[] ALLOWED_METHODS = {"GET", "POST", "PUT", "DELETE", "OPTIONS"};
    public static final String[] ALLOWED_HEADERS = {"Content-Type", "Authorization"};



}
