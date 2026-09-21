/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.ModelBaseImpl;
import net.ibizsys.paas.demodel.IDEFDTColumnModel;

public class DEFDTColumnModel
extends ModelBaseImpl
implements IDEFDTColumnModel {
    private String strColumnName = null;
    private String strDBType = null;

    @Override
    public String getColumnName() {
        return this.strColumnName;
    }

    public void setColumnName(String strColumnName) {
        this.strColumnName = strColumnName;
    }

    @Override
    public String getDBType() {
        return this.strDBType;
    }

    public void setDBType(String strDBType) {
        this.strDBType = strDBType;
    }
}

