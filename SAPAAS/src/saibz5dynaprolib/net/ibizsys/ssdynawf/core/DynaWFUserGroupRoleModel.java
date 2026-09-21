/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.wf.IPSWFRole
 *  net.ibizsys.paas.sysmodel.ISystemModel
 *  net.ibizsys.pswf.core.IWFRoleModel
 *  net.ibizsys.pswf.core.WFUserGroupRoleModelBase
 */
package net.ibizsys.ssdynawf.core;

import net.ibizsys.model.wf.IPSWFRole;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.pswf.core.IWFRoleModel;
import net.ibizsys.pswf.core.WFUserGroupRoleModelBase;
import net.ibizsys.ssdyna.sysmodel.IDynaSysModel;
import net.ibizsys.ssdynawf.core.IDynaWFRoleModel;

public class DynaWFUserGroupRoleModel
extends WFUserGroupRoleModelBase
implements IDynaWFRoleModel {
    private IDynaSysModel iDynaSysModel = null;
    private IPSWFRole iPSWFRole = null;

    public void init(IDynaSysModel iDynaSysModel, IPSWFRole iPSWFRole) throws Exception {
        this.iDynaSysModel = iDynaSysModel;
        this.iPSWFRole = iPSWFRole;
        this.setId(this.iPSWFRole.getId());
        this.setName(this.iPSWFRole.getName());
        this.setWFRoleSN(this.iPSWFRole.getWFRoleSN());
        this.setUserData(this.iPSWFRole.getUserData());
        this.setUserData2(this.iPSWFRole.getUserData2());
        this.getSystemModel().registerWFRoleModel((IWFRoleModel)this);
    }

    public ISystemModel getSystemModel() {
        return this.iDynaSysModel;
    }

    @Override
    public IDynaSysModel getDynaSysModel() {
        return this.iDynaSysModel;
    }

    @Override
    public IPSWFRole getPSWFRole() {
        return this.iPSWFRole;
    }
}

