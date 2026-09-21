/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.gitlab;

public class GitLabApiException
extends Exception {
    private static final long serialVersionUID = 1L;
    private int httpStatus;
    private String message;

    public GitLabApiException(String string) {
        super(string);
        this.message = string;
    }

    public GitLabApiException(String string, int n) {
        super(string);
        this.message = string;
        this.httpStatus = n;
    }

    public GitLabApiException(Exception exception) {
        super(exception);
        this.message = exception.getMessage();
    }

    public final int getHttpStatus() {
        return this.httpStatus;
    }
}

