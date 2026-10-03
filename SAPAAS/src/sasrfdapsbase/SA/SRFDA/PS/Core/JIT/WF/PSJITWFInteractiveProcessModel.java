/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pswf.core.IWFInteractiveProcessModel
 *  net.ibizsys.pswf.core.IWFProcRoleModel
 *  net.ibizsys.pswf.core.WFInteractiveProcessModelBase
 *  net.ibizsys.pswf.core.WFProcRoleModel
 */
package SA.SRFDA.PS.Core.JIT.WF;

import SA.SRFDA.PS.Core.JIT.WF.IPSJITIWFProcessModel;
import SA.SRFDA.PS.Core.JIT.WF.IPSJITWFVersionModel;
import SA.SRFDA.PS.Core.JIT.WF.PSJITWFProcSysActorRoleModel;
import SA.SRFDA.PS.Core.JIT.WF.PSJITWFProcUDActorRoleModel;
import SA.SRFDA.PS.Core.WF.IPSWFInteractiveProcess;
import SA.SRFDA.PS.Core.WF.IPSWFProcess;
import SA.SRFDA.PS.Core.WF.IPSWFProcessRole;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pswf.core.IWFInteractiveProcessModel;
import net.ibizsys.pswf.core.IWFProcRoleModel;
import net.ibizsys.pswf.core.WFInteractiveProcessModelBase;
import net.ibizsys.pswf.core.WFProcRoleModel;
import net.ibizsys.pswf.core.WFProcRoleModelBase;
import net.ibizsys.pswf.core.WFProcUDActorRoleModel;

public class PSJITWFInteractiveProcessModel
extends WFInteractiveProcessModelBase
implements IPSJITIWFProcessModel {
    private IPSJITWFVersionModel iPSJITWFVersionModel = null;
    private IPSWFInteractiveProcess iPSWFProcess = null;

    public void init(IPSJITWFVersionModel iPSJITWFVersionModel, IPSWFProcess iPSWFProcess) throws Exception {
        this.iPSJITWFVersionModel = iPSJITWFVersionModel;
        this.iPSWFProcess = (IPSWFInteractiveProcess)iPSWFProcess;
        this.setId(iPSWFProcess.getId());
        this.setName(iPSWFProcess.getName());
        this.setLeftPos(iPSWFProcess.getLeftPos());
        this.setTopPos(iPSWFProcess.getTopPos());
        this.setWFStepValue(iPSWFProcess.getWFStepValue());
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
        this.init(iPSJITWFVersionModel);
    }

    protected void onInit() throws Exception {
        super.onInit();
        Iterator<IPSWFProcessRole> procroles = this.iPSWFProcess.getPSWFProcessRoles();
        while (procroles.hasNext()) {
            IPSWFProcessRole iWFProcRoleModel = procroles.next();
            WFProcRoleModelBase procRole = null;
            if (StringHelper.compare((String)iWFProcRoleModel.getWFProcRoleType(), (String)"WFROLE", (boolean)false) == 0) {
                procRole = new WFProcRoleModel();
                procRole.setWFRoleId(iWFProcRoleModel.getWFRoleId());
            } else if (StringHelper.compare((String)iWFProcRoleModel.getWFProcRoleType(), (String)"UDACTOR", (boolean)false) == 0) {
                WFProcUDActorRoleModel procRole2 = new PSJITWFProcUDActorRoleModel();
                procRole2.setUDField(iWFProcRoleModel.getUDField());
                procRole = procRole2;
            } else {
                procRole = new PSJITWFProcSysActorRoleModel();
            }
            procRole.setId(iWFProcRoleModel.getId());
            procRole.setName(iWFProcRoleModel.getName());
            procRole.setWFProcRoleType(iWFProcRoleModel.getWFProcessRoleType());
            procRole.init((IWFInteractiveProcessModel)this);
            this.registerWFProcRoleModel((IWFProcRoleModel)procRole);
        }
    }

    @Override
    public IPSJITWFVersionModel getPSJITWFVersionModel() {
        return this.iPSJITWFVersionModel;
    }
}

