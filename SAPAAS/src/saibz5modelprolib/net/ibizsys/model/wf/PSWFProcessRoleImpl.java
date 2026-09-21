/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.core.IPSModelObject
 *  net.ibizsys.model.wf.IPSWFProcess
 *  net.ibizsys.pswf.core.IWFActionContext
 *  net.ibizsys.pswf.core.IWFInteractiveProcessModel
 *  net.ibizsys.pswf.core.IWFRoleModel
 *  net.ibizsys.pswf.core.IWFRoleUser
 */
package net.ibizsys.model.wf;

import java.util.Iterator;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.entity.PSWFProcRole;
import net.ibizsys.model.wf.IPSWFProcess;
import net.ibizsys.model.wf.IPSWFProcessRoleRuntime;
import net.ibizsys.pswf.core.IWFActionContext;
import net.ibizsys.pswf.core.IWFInteractiveProcessModel;
import net.ibizsys.pswf.core.IWFRoleModel;
import net.ibizsys.pswf.core.IWFRoleUser;

public class PSWFProcessRoleImpl
extends PSObjectImpl
implements IPSWFProcessRoleRuntime {
    protected IPSWFProcess iPSWFProcess;
    protected PSWFProcRole psWFProcRole;
    protected String strProcRoleType = "";
    protected String strPSWFRoleId = "";
    protected String strUDField = "";

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSWFProcess iPSWFProcess, PSWFProcRole psWFProcRole) throws Exception {
        this.setPSModelStorageContext(iPSModelStorageContext);
        this.iPSWFProcess = iPSWFProcess;
        this.psWFProcRole = psWFProcRole;
        this.setId(this.psWFProcRole.getPSWFPROCROLEID());
        this.setName(this.psWFProcRole.getPSWFPROCROLENAME());
        this.setPSObjectData(this.psWFProcRole);
        this.strProcRoleType = this.psWFProcRole.getROLETYPE();
        this.strPSWFRoleId = this.psWFProcRole.getPSWFROLEID();
        this.strUDField = this.psWFProcRole.getUDFIELDS();
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    public String getWFProcessRoleType() {
        return this.strProcRoleType;
    }

    public void init(IWFInteractiveProcessModel iWFInteractiveProcessModel) throws Exception {
    }

    public String getWFProcRoleType() {
        return this.getWFProcessRoleType();
    }

    public String getWFRoleId() {
        return this.strPSWFRoleId;
    }

    public IWFRoleModel getWFRoleModel() {
        return null;
    }

    public IWFInteractiveProcessModel getWFInteractiveProcessModel() {
        return (IWFInteractiveProcessModel)this.iPSWFProcess;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSysModelInstId((IPSModelObject)this.iPSWFProcess);
    }

    public String[] getUDFields() {
        return null;
    }

    public String getUDField() {
        return this.strUDField;
    }

    public Iterator<IWFRoleUser> getWFRoleUserModels(IWFActionContext iWFActionContext) throws Exception {
        return null;
    }
}

