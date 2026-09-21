/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pswf.core.IWFRoleModel
 */
package net.ibizsys.pswf.core;

import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pswf.core.IWFInteractiveProcessModel;
import net.ibizsys.pswf.core.IWFProcRoleModel;
import net.ibizsys.pswf.core.IWFRoleModel;

public abstract class WFProcRoleModelBase
implements IWFProcRoleModel {
    private String strId = "";
    private String strName = "";
    private String strWFProcRoleType = "";
    private String strWFRoleId = "";
    private IWFRoleModel iWFRoleModel = null;
    private IWFInteractiveProcessModel iWFInteractiveProcessModel = null;

    @Override
    public void init(IWFInteractiveProcessModel iWFInteractiveProcessModel) throws Exception {
        this.iWFInteractiveProcessModel = iWFInteractiveProcessModel;
        this.onInit();
    }

    protected void onInit() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.getWFRoleId())) {
            this.iWFRoleModel = this.iWFInteractiveProcessModel.getWFVersionModel().getWFModel().getSystemModel().getWFRoleModel(this.getWFRoleId());
        }
    }

    @Override
    public String getId() {
        return this.strId;
    }

    @Override
    public String getName() {
        return this.strName;
    }

    public void setId(String strId) {
        this.strId = strId;
    }

    public void setName(String strName) {
        this.strName = strName;
    }

    @Override
    public IWFInteractiveProcessModel getWFInteractiveProcessModel() {
        return this.iWFInteractiveProcessModel;
    }

    @Override
    public String getWFRoleId() {
        return this.strWFRoleId;
    }

    @Override
    public String getWFProcRoleType() {
        return this.strWFProcRoleType;
    }

    public void setWFProcRoleType(String strWFProcRoleType) {
        this.strWFProcRoleType = strWFProcRoleType;
    }

    public void setWFRoleId(String strWFRoleId) {
        this.strWFRoleId = strWFRoleId;
    }

    @Override
    public IWFRoleModel getWFRoleModel() {
        return this.iWFRoleModel;
    }

    @Override
    public String[] getUDFields() {
        return null;
    }
}

