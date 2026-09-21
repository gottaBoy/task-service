/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.ModelBase3Impl;
import net.ibizsys.paas.demodel.IDEOPPrivRoleModel;
import net.ibizsys.paas.sysmodel.ISystemModel;

public class DEOPPrivRoleModel
extends ModelBase3Impl
implements IDEOPPrivRoleModel {
    private IDataEntity iDataEntity = null;
    private ISystemModel iSystemModel = null;
    private String strDEOPPrivTag = null;
    private String strRoleType = null;
    private String strDEDataQueryId = null;
    private String strDEUserRoleId = null;
    private String strSysUserRoleId = null;

    @Override
    public void init(IDataEntity iDataEntity) throws Exception {
        this.iDataEntity = iDataEntity;
        this.iSystemModel = (ISystemModel)this.iDataEntity.getSystem();
        this.onInit();
    }

    public void setId(String strId) {
        this.strId = strId;
    }

    public void setName(String strName) {
        this.strName = strName;
    }

    @Override
    public IDataEntity getDataEntity() {
        return this.iDataEntity;
    }

    @Override
    public String getDEOPPrivTag() {
        return this.strDEOPPrivTag;
    }

    @Override
    public String getRoleType() {
        return this.strRoleType;
    }

    @Override
    public String getDEDataQueryId() {
        return this.strDEDataQueryId;
    }

    public void setDEOPPrivTag(String strDEOPPrivTag) {
        this.strDEOPPrivTag = strDEOPPrivTag;
    }

    public void setRoleType(String strRoleType) {
        this.strRoleType = strRoleType;
    }

    public void setDEDataQueryId(String strDEDataQueryId) {
        this.strDEDataQueryId = strDEDataQueryId;
    }

    @Override
    public String getSysUserRoleId() {
        return this.strSysUserRoleId;
    }

    @Override
    public String getDEUserRoleId() {
        return this.strDEUserRoleId;
    }

    public void setDEUserRoleId(String strDEUserRoleId) {
        this.strDEUserRoleId = strDEUserRoleId;
    }

    public void setSysUserRoleId(String strSysUserRoleId) {
        this.strSysUserRoleId = strSysUserRoleId;
    }
}

