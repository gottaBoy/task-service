/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.psrt.srv.wf.entity.WFUser
 *  net.ibizsys.psrt.srv.wf.service.WFUserService
 *  net.ibizsys.pswf.core.IWFActionContext
 *  net.ibizsys.pswf.core.IWFRoleUser
 */
package net.ibizsys.pswf.core;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.wf.entity.WFUser;
import net.ibizsys.psrt.srv.wf.service.WFUserService;
import net.ibizsys.pswf.core.IWFActionContext;
import net.ibizsys.pswf.core.IWFRoleUser;
import net.ibizsys.pswf.core.WFProcRoleModelBase;
import net.ibizsys.pswf.core.WFRoleUser;

public class WFProcSysActorRoleModel
extends WFProcRoleModelBase {
    public static final String ROLETYPE_LASTTWOSTEPACTOR = "LASTTWOSTEPACTOR";
    public static final String ROLETYPE_LASTTHREESTEPACTOR = "LASTTHREESTEPACTOR";
    public static final String ROLETYPE_LASTSTEPACTOR = "LASTSTEPACTOR";
    public static final String ROLETYPE_CURACTOR = "CURACTOR";

    @Override
    public Iterator<IWFRoleUser> getWFRoleUserModels(IWFActionContext iWFActionContext) throws Exception {
        if (StringHelper.compare((String)this.getWFProcRoleType(), (String)ROLETYPE_CURACTOR, (boolean)true) == 0) {
            ArrayList<IWFRoleUser> wfRoleUserList = new ArrayList<IWFRoleUser>();
            String strWFUserId = iWFActionContext.getOpPersonId();
            if (StringHelper.isNullOrEmpty((String)strWFUserId)) {
                return null;
            }
            WFUserService wfUserService = (WFUserService)ServiceGlobal.getService(WFUserService.class);
            WFUser wfUser = new WFUser();
            wfUser.setWFUserId(strWFUserId);
            wfUserService.get((IEntity)wfUser);
            wfRoleUserList.add(WFRoleUser.fromWFUser(wfUser, null));
            return wfRoleUserList.iterator();
        }
        return null;
    }
}

