package com.clientes.api.constants;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ApplicationConstants {

    public static final Path UPLOADS_DIRECTORY = Paths.get("uploads");
    public static final Path IMAGES_DIRECTORY = Paths.get("src/main/resources/static/images");
    public static final String NO_USER_ICON_IMAGE_NAME = "no_user_icon.png";

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

}
