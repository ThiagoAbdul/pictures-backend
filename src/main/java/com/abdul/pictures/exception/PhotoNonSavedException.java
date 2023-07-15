package com.abdul.pictures.exception;

public class PhotoNonSavedException extends Exception{

    public PhotoNonSavedException(Throwable cause) {
        super("Photo don't saved:\n" + cause.getMessage());
    }
}
