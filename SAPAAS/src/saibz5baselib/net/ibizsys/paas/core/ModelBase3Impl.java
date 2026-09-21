/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core;

import net.ibizsys.paas.core.IModelBase3;
import net.ibizsys.paas.core.ModelBase2Impl;
import net.ibizsys.paas.data.DataObject;

public abstract class ModelBase3Impl
extends ModelBase2Impl
implements IModelBase3 {
    private DataObject dataObject = null;

    @Override
    public Object getAttribute(String strKey) throws Exception {
        if (this.dataObject == null) {
            return null;
        }
        return this.dataObject.get(strKey);
    }

    @Override
    public boolean getAttribute(String strKey, boolean bDefault) throws Exception {
        if (this.dataObject == null) {
            return bDefault;
        }
        return DataObject.getBoolValue(this.dataObject, strKey, bDefault);
    }

    @Override
    public String getAttribute(String strKey, String strDefault) throws Exception {
        if (this.dataObject == null) {
            return strDefault;
        }
        return DataObject.getStringValue(this.dataObject, strKey, strDefault);
    }

    @Override
    public int getAttribute(String strKey, int nDefault) throws Exception {
        if (this.dataObject == null) {
            return nDefault;
        }
        return DataObject.getIntegerValue(this.dataObject, strKey, nDefault);
    }

    @Override
    public double getAttribute(String strKey, double fDefault) throws Exception {
        if (this.dataObject == null) {
            return fDefault;
        }
        return DataObject.getDoubleValue(this.dataObject, strKey, fDefault);
    }

    @Override
    public void setAttribute(String strKey, Object objValue) throws Exception {
        if (this.dataObject == null) {
            this.dataObject = new DataObject();
        }
        this.dataObject.set(strKey, objValue);
    }
}

