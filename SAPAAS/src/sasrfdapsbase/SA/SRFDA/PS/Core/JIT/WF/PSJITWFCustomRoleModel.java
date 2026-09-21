/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.sysmodel.ISystemModel
 *  net.ibizsys.pswf.core.IWFRoleModel
 *  net.ibizsys.pswf.core.WFCustomRoleModelBase
 */
package SA.SRFDA.PS.Core.JIT.WF;

import SA.SRFDA.PS.Core.JIT.SysModel.IPSJITSystemModel;
import SA.SRFDA.PS.Core.JIT.WF.IPSJITWFRoleModel;
import SA.SRFDA.PS.Core.WF.IPSWFRole;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.pswf.core.IWFRoleModel;
import net.ibizsys.pswf.core.WFCustomRoleModelBase;

public class PSJITWFCustomRoleModel
extends WFCustomRoleModelBase
implements IPSJITWFRoleModel {
    private IPSJITSystemModel iPSJITSystemModel = null;
    private IPSWFRole iPSWFRole = null;

    public void init(IPSJITSystemModel iPSJITSystemModel, IPSWFRole iPSWFRole) throws Exception {
        this.iPSJITSystemModel = iPSJITSystemModel;
        this.iPSWFRole = iPSWFRole;
        this.setId(this.iPSWFRole.getId());
        this.setName(this.iPSWFRole.getName());
        this.setWFRoleSN(this.iPSWFRole.getWFRoleSN());
        this.setUserData(this.iPSWFRole.getUserData());
        this.setUserData2(this.iPSWFRole.getUserData2());
        this.getSystemModel().registerWFRoleModel((IWFRoleModel)this);
    }

    public ISystemModel getSystemModel() {
        return this.iPSJITSystemModel;
    }

    @Override
    public IPSJITSystemModel getPSJITSystemModel() {
        return this.iPSJITSystemModel;
    }

    @Override
    public IPSWFRole getPSWFRole() {
        return this.iPSWFRole;
    }
}

