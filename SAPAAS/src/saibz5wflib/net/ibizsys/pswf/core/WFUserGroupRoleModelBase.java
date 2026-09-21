/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.psrt.srv.wf.entity.WFUserGroup
 *  net.ibizsys.psrt.srv.wf.entity.WFUserGroupBase
 *  net.ibizsys.psrt.srv.wf.entity.WFUserGroupDetail
 *  net.ibizsys.psrt.srv.wf.service.WFUserGroupDetailService
 *  net.ibizsys.pswf.core.IWFActionContext
 *  net.ibizsys.pswf.core.IWFRoleUser
 */
package net.ibizsys.pswf.core;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.psrt.srv.wf.entity.WFUserGroup;
import net.ibizsys.psrt.srv.wf.entity.WFUserGroupBase;
import net.ibizsys.psrt.srv.wf.entity.WFUserGroupDetail;
import net.ibizsys.psrt.srv.wf.service.WFUserGroupDetailService;
import net.ibizsys.pswf.core.IWFActionContext;
import net.ibizsys.pswf.core.IWFRoleUser;
import net.ibizsys.pswf.core.WFRoleModelBase;
import net.ibizsys.pswf.core.WFRoleUser;

public abstract class WFUserGroupRoleModelBase
extends WFRoleModelBase {
    public String getWFRoleType() {
        return "USERGROUP";
    }

    public Iterator<IWFRoleUser> getWFRoleUserModels(IWFActionContext iWFActionContext) throws Exception {
        WFUserGroup wfUserGroup = new WFUserGroup();
        wfUserGroup.setWFUserGroupId(this.getId());
        WFUserGroupDetailService wfUserGroupDetailService = (WFUserGroupDetailService)ServiceGlobal.getService(WFUserGroupDetailService.class);
        ArrayList wfUserGroupDetailList = wfUserGroupDetailService.selectByWFUserGroup((WFUserGroupBase)wfUserGroup);
        ArrayList<IWFRoleUser> wfRoleUserList = new ArrayList<IWFRoleUser>();
        for (WFUserGroupDetail wfUserGroupDetail : wfUserGroupDetailList) {
            wfRoleUserList.add(WFRoleUser.fromWFUserGroupDetail(wfUserGroupDetail, this));
        }
        return wfRoleUserList.iterator();
    }
}

