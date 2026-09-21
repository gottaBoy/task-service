/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.psrt.srv.wf.entity.WFUser
 *  net.ibizsys.psrt.srv.wf.entity.WFUserGroupDetail
 *  net.ibizsys.pswf.core.IWFRoleModel
 *  net.ibizsys.pswf.core.IWFRoleUser
 */
package net.ibizsys.pswf.core;

import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.psrt.srv.wf.entity.WFUser;
import net.ibizsys.psrt.srv.wf.entity.WFUserGroupDetail;
import net.ibizsys.pswf.core.IWFRoleModel;
import net.ibizsys.pswf.core.IWFRoleUser;

public class WFRoleUser
extends WFUser
implements IWFRoleUser {
    private IWFRoleModel iWFRoleModel = null;

    public IWFRoleModel getWFRoleModel() {
        return this.iWFRoleModel;
    }

    public void setWFRoleModel(IWFRoleModel iWFRoleModel) {
        this.iWFRoleModel = iWFRoleModel;
    }

    public static IWFRoleUser fromWFUserGroupDetail(WFUserGroupDetail wfUserGroupDetail, IWFRoleModel iWFRoleModel) throws Exception {
        WFRoleUser wfRoleUser = new WFRoleUser();
        wfUserGroupDetail.copyTo((IDataObject)wfRoleUser, true);
        wfRoleUser.setWFRoleModel(iWFRoleModel);
        return wfRoleUser;
    }

    public static IWFRoleUser fromWFUser(WFUser wfUser, IWFRoleModel iWFRoleModel) throws Exception {
        WFRoleUser wfRoleUser = new WFRoleUser();
        wfUser.copyTo((IDataObject)wfRoleUser, true);
        wfRoleUser.setWFRoleModel(iWFRoleModel);
        return wfRoleUser;
    }
}

