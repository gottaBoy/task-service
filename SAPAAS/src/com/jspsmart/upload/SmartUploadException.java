package com.jspsmart.upload;

/**
 * Compatibility exception for the legacy JSP SmartUpload API.
 */
public class SmartUploadException extends Exception {
    private static final long serialVersionUID = 1L;

    public SmartUploadException() {
        super();
    }

    public SmartUploadException(String message) {
        super(message);
    }

    public SmartUploadException(String message, Throwable cause) {
        super(message, cause);
    }

    public SmartUploadException(Throwable cause) {
        super(cause);
    }
}
