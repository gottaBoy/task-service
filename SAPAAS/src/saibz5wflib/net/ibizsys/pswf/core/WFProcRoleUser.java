/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.psrt.srv.wf.entity.WFUser
 *  net.ibizsys.pswf.core.IWFRoleUser
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pswf.core;

import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.wf.entity.WFUser;
import net.ibizsys.pswf.core.IWFProcRoleModel;
import net.ibizsys.pswf.core.IWFProcRoleUser;
import net.ibizsys.pswf.core.IWFRoleUser;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class WFProcRoleUser
extends WFUser
implements IWFProcRoleUser {
    private static final Log log = LogFactory.getLog(WFProcRoleUser.class);
    private IWFProcRoleModel iWFProcRoleModel = null;
    private String strId = "";
    private String strName = "";
    private String strWFRoleId = null;

    @Override
    public String getId() {
        return this.strId;
    }

    @Override
    public String getName() {
        return this.strName;
    }

    public void setId(String strId) {
        this.strId = strId;
    }

    public void setName(String strName) {
        this.strName = strName;
    }

    @Override
    public IWFProcRoleModel getWFProcRoleModel() {
        return this.iWFProcRoleModel;
    }

    public void setWFProcRoleModel(IWFProcRoleModel iWFProcRoleModel) {
        this.iWFProcRoleModel = iWFProcRoleModel;
    }

    public static IWFProcRoleUser fromWFRoleUser(IWFRoleUser iWFRoleUser, String strWFRoleId) throws Exception {
        WFProcRoleUser wfProcRoleUser = new WFProcRoleUser();
        iWFRoleUser.copyTo((IDataObject)wfProcRoleUser, true);
        wfProcRoleUser.setWFRoleId(strWFRoleId);
        return wfProcRoleUser;
    }

    public static IWFProcRoleUser fromWFRoleUser(IWFRoleUser iWFRoleUser, IWFProcRoleModel iWFProcRoleModel) throws Exception {
        WFProcRoleUser wfProcRoleUser = new WFProcRoleUser();
        iWFRoleUser.copyTo((IDataObject)wfProcRoleUser, true);
        wfProcRoleUser.setWFProcRoleModel(iWFProcRoleModel);
        return wfProcRoleUser;
    }

    @Override
    public String getWFRoleId() {
        if (!StringHelper.isNullOrEmpty((String)this.strWFRoleId)) {
            return this.strWFRoleId;
        }
        if (this.getWFProcRoleModel() != null) {
            return this.getWFProcRoleModel().getWFRoleId();
        }
        return null;
    }

    public void setWFRoleId(String strWFRoleId) {
        this.strWFRoleId = strWFRoleId;
    }

    @Override
    public boolean isIgnoreSubstitute() {
        try {
            return DataObject.getBoolValue((IDataObject)this, (String)"IGNORESUBSTITUTE", (Boolean)false);
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return false;
        }
    }

    @Override
    public String getOriginalWFUserId() {
        try {
            return DataObject.getStringValue((IDataObject)this, (String)"ORIGINALWFUSERID", null);
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return null;
        }
    }
}

