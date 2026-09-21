/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.entity;

import net.ibizsys.paas.core.Errors;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.util.StringHelper;

public class EntityException
extends Exception {
    private static final long serialVersionUID = 1L;
    private EntityError entityError = null;
    private IDataEntity iDataEntity = null;
    private int nErrorCode = 0;

    public EntityException(EntityError entityError) {
        this.entityError = entityError;
    }

    public EntityException(EntityError entityError, String strMessage) {
        super(strMessage);
        this.entityError = entityError;
    }

    public EntityException(EntityError entityError, IDataEntity iDataEntity) {
        this.entityError = entityError;
        this.iDataEntity = iDataEntity;
    }

    public EntityException(EntityError entityError, String strMessage, IDataEntity iDataEntity) {
        super(strMessage);
        this.entityError = entityError;
        this.iDataEntity = iDataEntity;
    }

    public EntityException(EntityError entityError, int nErrorCode) {
        this.entityError = entityError;
        this.nErrorCode = nErrorCode;
    }

    public EntityException(EntityError entityError, int nErrorCode, String strMessage) {
        super(strMessage);
        this.entityError = entityError;
        this.nErrorCode = nErrorCode;
    }

    public EntityException(EntityError entityError, int nErrorCode, IDataEntity iDataEntity) {
        this.entityError = entityError;
        this.iDataEntity = iDataEntity;
        this.nErrorCode = nErrorCode;
    }

    public EntityException(EntityError entityError, int nErrorCode, String strMessage, IDataEntity iDataEntity) {
        super(strMessage);
        this.entityError = entityError;
        this.iDataEntity = iDataEntity;
        this.nErrorCode = nErrorCode;
    }

    public EntityError getEntityError() {
        return this.entityError;
    }

    @Override
    public String toString() {
        if (this.entityError != null) {
            return this.entityError.toString();
        }
        return super.toString();
    }

    @Override
    public String getMessage() {
        if (StringHelper.isNullOrEmpty(super.getMessage())) {
            if (this.entityError != null) {
                return this.entityError.toString();
            }
            if (this.getErrorCode() != 0) {
                return Errors.getErrorInfo(this.getErrorCode());
            }
        }
        return super.getMessage();
    }

    public IDataEntity getDataEntity() {
        return this.iDataEntity;
    }

    public int getErrorCode() {
        return this.nErrorCode;
    }
}

