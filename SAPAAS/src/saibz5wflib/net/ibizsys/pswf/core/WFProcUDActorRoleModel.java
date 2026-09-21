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

public class WFProcUDActorRoleModel
extends WFProcRoleModelBase {
    private String strUDField = "";
    private String[] udFields = null;

    public void setUDField(String strUDField) {
        this.strUDField = strUDField;
        if (!StringHelper.isNullOrEmpty((String)strUDField)) {
            this.udFields = StringHelper.splitEx((String)this.strUDField);
        }
    }

    @Override
    public String[] getUDFields() {
        return this.udFields;
    }

    @Override
    public Iterator<IWFRoleUser> getWFRoleUserModels(IWFActionContext iWFActionContext) throws Exception {
        if (this.getUDFields() != null) {
            WFUserService wfUserService = (WFUserService)ServiceGlobal.getService(WFUserService.class);
            ArrayList<IWFRoleUser> wfRoleUserList = new ArrayList<IWFRoleUser>();
            String[] stringArray = this.getUDFields();
            int n = stringArray.length;
            int n2 = 0;
            while (n2 < n) {
                String strUDField = stringArray[n2];
                String strWFUserId = (String)iWFActionContext.getActiveEntity().get(strUDField);
                if (!StringHelper.isNullOrEmpty((String)strWFUserId)) {
                    WFUser wfUser = new WFUser();
                    wfUser.setWFUserId(strWFUserId);
                    wfUserService.get((IEntity)wfUser);
                    wfRoleUserList.add(WFRoleUser.fromWFUser(wfUser, null));
                }
                ++n2;
            }
            return wfRoleUserList.iterator();
        }
        return null;
    }
}

