/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.wf.IPSWFInteractiveProcess
 *  net.ibizsys.model.wf.IPSWFProcess
 *  net.ibizsys.model.wf.IPSWFProcessRole
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pswf.core.IWFInteractiveProcessModel
 *  net.ibizsys.pswf.core.IWFProcRoleModel
 *  net.ibizsys.pswf.core.IWFVersionModel
 *  net.ibizsys.pswf.core.WFInteractiveProcessModelBase
 *  net.ibizsys.pswf.core.WFProcRoleModel
 */
package net.ibizsys.ssdynawf.core;

import java.util.Iterator;
import net.ibizsys.model.wf.IPSWFInteractiveProcess;
import net.ibizsys.model.wf.IPSWFProcess;
import net.ibizsys.model.wf.IPSWFProcessRole;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pswf.core.IWFInteractiveProcessModel;
import net.ibizsys.pswf.core.IWFProcRoleModel;
import net.ibizsys.pswf.core.IWFVersionModel;
import net.ibizsys.pswf.core.WFInteractiveProcessModelBase;
import net.ibizsys.pswf.core.WFProcRoleModel;
import net.ibizsys.ssdynawf.core.DynaWFProcSysActorRoleModel;
import net.ibizsys.ssdynawf.core.DynaWFProcUDActorRoleModel;
import net.ibizsys.ssdynawf.core.IDynaWFProcessModel;
import net.ibizsys.ssdynawf.core.IDynaWFVersionModel;

public class DynaWFInteractiveProcessModel
extends WFInteractiveProcessModelBase
implements IDynaWFProcessModel {
    private IDynaWFVersionModel iDynaWFVersionModel = null;
    private IPSWFInteractiveProcess iPSWFProcess = null;

    public void init(IDynaWFVersionModel iDynaWFVersionModel, IPSWFProcess iPSWFProcess) throws Exception {
        this.iDynaWFVersionModel = iDynaWFVersionModel;
        this.iPSWFProcess = (IPSWFInteractiveProcess)iPSWFProcess;
        this.setId(iPSWFProcess.getId());
        this.setName(iPSWFProcess.getName());
        this.setLeftPos(iPSWFProcess.getLeftPos());
        this.setTopPos(iPSWFProcess.getTopPos());
        this.setWFStepValue(iPSWFProcess.getWFStepValue());
        this.setBPMNModelId(iPSWFProcess.getBPMNModelId());
        if (this.iPSWFProcess.isEditable()) {
            this.setEditable(true);
        }
        if (!StringHelper.isNullOrEmpty((String)this.iPSWFProcess.getMemoField())) {
            this.setMemoField(this.iPSWFProcess.getMemoField());
        }
        if (!StringHelper.isNullOrEmpty((String)this.iPSWFProcess.getUserData())) {
            this.setUserData(this.iPSWFProcess.getUserData());
        }
        if (!StringHelper.isNullOrEmpty((String)this.iPSWFProcess.getUserData2())) {
            this.setUserData2(this.iPSWFProcess.getUserData2());
        }
        if (this.iPSWFProcess.isSendInform()) {
            this.setSendInform(true);
            this.setMsgTemplateId(this.iPSWFProcess.getMsgTemplateId());
            this.setMsgType(this.iPSWFProcess.getMsgType());
        }
        this.init((IWFVersionModel)iDynaWFVersionModel);
    }

    protected void onInit() throws Exception {
        super.onInit();
        Iterator procroles = this.iPSWFProcess.getPSWFProcessRoles();
        while (procroles.hasNext()) {
            Object procRole2;
            IPSWFProcessRole iWFProcRoleModel = (IPSWFProcessRole)procroles.next();
            Object procRole = null;
            if (StringHelper.compare((String)iWFProcRoleModel.getWFProcRoleType(), (String)"WFROLE", (boolean)false) == 0) {
                procRole = new WFProcRoleModel();
                procRole.setWFRoleId(iWFProcRoleModel.getWFRoleId());
            } else if (StringHelper.compare((String)iWFProcRoleModel.getWFProcRoleType(), (String)"UDACTOR", (boolean)false) == 0) {
                procRole2 = new DynaWFProcUDActorRoleModel();
                procRole2.setUDField(iWFProcRoleModel.getUDField());
                procRole = procRole2;
            } else {
                procRole2 = new DynaWFProcSysActorRoleModel();
                procRole = procRole2;
            }
            procRole.setId(iWFProcRoleModel.getId());
            procRole.setName(iWFProcRoleModel.getName());
            procRole.setWFProcRoleType(iWFProcRoleModel.getWFProcessRoleType());
            procRole.init((IWFInteractiveProcessModel)this);
            this.registerWFProcRoleModel((IWFProcRoleModel)procRole);
        }
    }

    @Override
    public IDynaWFVersionModel getDynaWFVersionModel() {
        return this.iDynaWFVersionModel;
    }
}

