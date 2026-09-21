/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.sysmodel.ISystemModel
 *  net.ibizsys.pswf.core.IWFRoleModel
 */
package net.ibizsys.pswf.core;

import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.pswf.core.IWFRoleModel;

public abstract class WFRoleModelBase
implements IWFRoleModel {
    private String strId = "";
    private String strName = "";
    private String strWFRoleSN = "";
    private String strUserData = null;
    private String strUserData2 = null;
    private Object objRuntimeId = null;

    public abstract ISystemModel getSystemModel();

    public String getId() {
        return this.strId;
    }

    public String getName() {
        return this.strName;
    }

    protected void setId(String strId) {
        this.strId = strId;
    }

    protected void setName(String strName) {
        this.strName = strName;
    }

    protected String getWFRoleSN() {
        return this.strWFRoleSN;
    }

    protected void setWFRoleSN(String strWFRoleSN) {
        this.strWFRoleSN = strWFRoleSN;
    }

    protected String getUserData() {
        return this.strUserData;
    }

    protected void setUserData(String strUserData) {
        this.strUserData = strUserData;
    }

    protected String getUserData2() {
        return this.strUserData2;
    }

    protected void setUserData2(String strUserData2) {
        this.strUserData2 = strUserData2;
    }

    public Object getRuntimeId() {
        if (this.objRuntimeId == null) {
            return this.getId();
        }
        return this.objRuntimeId;
    }

    public void setRuntimeId(Object objRuntimeId) {
        this.objRuntimeId = objRuntimeId;
    }
}

