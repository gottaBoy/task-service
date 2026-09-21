/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.exception;

import net.ibizsys.paas.core.Errors;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.util.StringHelper;

public class ErrorException
extends Exception {
    private static final long serialVersionUID = 1L;
    private int nErrorCode = 0;
    private IDataEntity iDataEntity = null;

    public ErrorException(int nErrorCode) {
        this.nErrorCode = nErrorCode;
    }

    public ErrorException(int nErrorCode, String strMessage) {
        super(strMessage);
        this.nErrorCode = nErrorCode;
    }

    public ErrorException(int nErrorCode, IDataEntity iDataEntity) {
        this.nErrorCode = nErrorCode;
        this.iDataEntity = iDataEntity;
    }

    public ErrorException(int nErrorCode, String strMessage, IDataEntity iDataEntity) {
        super(strMessage);
        this.nErrorCode = nErrorCode;
        this.iDataEntity = iDataEntity;
    }

    public int getErrorCode() {
        return this.nErrorCode;
    }

    @Override
    public String getMessage() {
        String strMessage = super.getMessage();
        if (StringHelper.isNullOrEmpty(strMessage)) {
            return Errors.getErrorInfo(this.getErrorCode());
        }
        return strMessage;
    }

    public IDataEntity getDataEntity() {
        return this.iDataEntity;
    }
}

