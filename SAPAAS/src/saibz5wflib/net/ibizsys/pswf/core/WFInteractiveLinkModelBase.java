/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.codelist.ICodeList
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pswf.core.IWFActionContext
 *  net.ibizsys.pswf.core.IWFRoleModel
 *  net.ibizsys.pswf.core.IWFRoleUser
 */
package net.ibizsys.pswf.core;

import java.util.Iterator;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pswf.core.IWFActionContext;
import net.ibizsys.pswf.core.IWFInteractiveLinkModel;
import net.ibizsys.pswf.core.IWFProcRoleModel;
import net.ibizsys.pswf.core.IWFRoleModel;
import net.ibizsys.pswf.core.IWFRoleUser;
import net.ibizsys.pswf.core.WFLinkModelBase;

public abstract class WFInteractiveLinkModelBase
extends WFLinkModelBase
implements IWFInteractiveLinkModel {
    private String strNextCondition = "ALL";
    private int nActionCount = 0;
    private boolean bActorIAActionControl = false;
    private String strMemoField = "";
    private String strActionField = "";
    private String strAddWFRoleId = "";
    private ICodeList actionCodeList = null;
    private IWFRoleModel addedWFRoleModel = null;

    @Override
    protected void onInit() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.getAddedWFRoleId())) {
            this.addedWFRoleModel = this.getWFVersionModel().getWFModel().getSystemModel().getWFRoleModel(this.getAddedWFRoleId());
        }
        super.onInit();
    }

    @Override
    public boolean isActorIAActionControl() {
        return this.bActorIAActionControl;
    }

    @Override
    public boolean containsWFProcRole(IWFProcRoleModel iWFProcRoleModel) {
        return true;
    }

    @Override
    public boolean containsUDActor(String strUDActorId) {
        return false;
    }

    @Override
    public int getActionCount() {
        return this.nActionCount;
    }

    @Override
    public String getNextCondition() {
        return this.strNextCondition;
    }

    @Override
    protected void setNextCondition(String strNextCondition) {
        this.strNextCondition = strNextCondition;
    }

    protected void setActionCount(int nActionCount) {
        this.nActionCount = nActionCount;
    }

    protected void setActorIAActionControl(boolean bActorIAActionControl) {
        this.bActorIAActionControl = bActorIAActionControl;
    }

    @Override
    public String getMemoField() {
        return this.strMemoField;
    }

    protected void setMemoField(String strMemoField) {
        this.strMemoField = strMemoField;
    }

    @Override
    public String getActionField() {
        return this.strActionField;
    }

    protected void setActionField(String strActionField) {
        this.strActionField = strActionField;
    }

    @Override
    public ICodeList getActionCodeList() {
        return this.actionCodeList;
    }

    protected void setActionCodeList(ICodeList actionCodeList) {
        this.actionCodeList = actionCodeList;
    }

    @Override
    public String getAddedWFRoleId() {
        return this.strAddWFRoleId;
    }

    protected void setAddedWFRoleId(String strAddWFRoleId) {
        this.strAddWFRoleId = strAddWFRoleId;
    }

    @Override
    public Iterator<IWFRoleUser> getAddedWFRoleUserModels(IWFActionContext iWFActionContext) throws Exception {
        if (this.getAddedWFRoleModel() == null) {
            return null;
        }
        return this.getAddedWFRoleModel().getWFRoleUserModels(iWFActionContext);
    }

    @Override
    public IWFRoleModel getAddedWFRoleModel() {
        return this.addedWFRoleModel;
    }
}

