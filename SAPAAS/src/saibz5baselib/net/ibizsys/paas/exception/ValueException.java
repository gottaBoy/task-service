/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.exception;

import net.ibizsys.paas.core.IDataEntity;

public class ValueException
extends Exception {
    private static final long serialVersionUID = 1L;
    private IDataEntity iDataEntity = null;

    public ValueException(String strError) {
        super(strError);
    }

    public ValueException(String strError, IDataEntity iDataEntity) {
        super(strError);
        this.iDataEntity = iDataEntity;
    }

    public IDataEntity getDataEntity() {
        return this.iDataEntity;
    }
}

