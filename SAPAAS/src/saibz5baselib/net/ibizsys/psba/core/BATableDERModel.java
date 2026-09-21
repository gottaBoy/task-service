/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psba.core;

import net.ibizsys.psba.core.BATableObjectModelBase;
import net.ibizsys.psba.core.IBATable;
import net.ibizsys.psba.core.IBATableDERModel;

public class BATableDERModel
extends BATableObjectModelBase
implements IBATableDERModel {
    private String strMajorDEName = null;
    private String strMinorDEName = null;
    private String strDERFieldName = null;

    public void init(IBATable iBATable) throws Exception {
        this.setBATable(iBATable);
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    public String getMajorDEName() {
        return this.strMajorDEName;
    }

    @Override
    public String getMinorDEName() {
        return this.strMinorDEName;
    }

    @Override
    public String getDERFieldName() {
        return this.strDERFieldName;
    }

    public void setMajorDEName(String strMajorDEName) {
        this.strMajorDEName = strMajorDEName;
    }

    public void setMinorDEName(String strMinorDEName) {
        this.strMinorDEName = strMinorDEName;
    }

    public void setDERFieldName(String strDERFieldName) {
        this.strDERFieldName = strDERFieldName;
    }
}

