/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.sysmodel;

import net.ibizsys.paas.core.IDEDataSetSystemUserRole;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.sysmodel.SystemUserRoleModelBase;

public class DEDataSetSystemUserRoleModel
extends SystemUserRoleModelBase
implements IDEDataSetSystemUserRole {
    private String strDEName = null;
    private String strDEDataSetName = null;
    protected IDataEntityModel iDEModel = null;

    @Override
    protected void onInit() throws Exception {
        this.iDEModel = DEModelGlobal.getDEModel(this.getDEName());
        super.onInit();
    }

    @Override
    public String getRoleType() {
        return "DEDATASET";
    }

    @Override
    public String getDEName() {
        return this.strDEName;
    }

    @Override
    public String getDEDataSetName() {
        return this.strDEDataSetName;
    }

    public void setDEName(String strDEName) {
        this.strDEName = strDEName;
    }

    public void setDEDataSetName(String strDEDataSetName) {
        this.strDEDataSetName = strDEDataSetName;
    }
}

