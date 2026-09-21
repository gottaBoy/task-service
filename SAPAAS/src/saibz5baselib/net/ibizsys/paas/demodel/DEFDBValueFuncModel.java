/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.IDEFDBValueFunc;
import net.ibizsys.paas.core.ModelBaseImpl;

public class DEFDBValueFuncModel
extends ModelBaseImpl
implements IDEFDBValueFunc {
    private String strCodeFormat = null;
    private String[] fields = null;

    public void setId(String strId) {
        this.strId = strId;
    }

    public void setName(String strName) {
        this.strName = strName;
    }

    @Override
    public String getCodeFormat() {
        return this.strCodeFormat;
    }

    @Override
    public String[] getFields() {
        return this.fields;
    }

    public void setCodeFormat(String strCodeFormat) {
        this.strCodeFormat = strCodeFormat;
    }

    public void setFields(String[] fields) {
        this.fields = fields;
    }
}

