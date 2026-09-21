/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.wf.IPSWFRole
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.wf;

import java.util.Vector;
import net.ibizsys.model.PSSystemGlobalModelBase;
import net.ibizsys.model.entity.PSWFRole;
import net.ibizsys.model.wf.IPSWFRole;
import net.ibizsys.model.wf.PSWFRoleImpl;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSWFRoleGlobalModel
extends PSSystemGlobalModelBase<String, PSWFRole, IPSWFRole> {
    private static final Log log = LogFactory.getLog(PSWFRoleGlobalModel.class);

    @Override
    protected PSWFRole getObject(String strPSWFRoleId) {
        log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u5de5\u4f5c\u6d41\u89d2\u8272[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSWFRoleId, (Object)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6"));
        return null;
    }

    @Override
    protected IPSWFRole onCreateModelHelper(PSWFRole vt) throws Exception {
        PSWFRoleImpl iPSWFRole = new PSWFRoleImpl();
        iPSWFRole.init(this.getPSModelStorageContext(), this.getPSSystem(), vt);
        return iPSWFRole;
    }

    @Override
    protected Boolean testObjectRenew(PSWFRole obj) {
        return false;
    }

    @Override
    protected void onPreloadModels() {
        super.onPreloadModels();
        try {
            this.getAllModelHelpers();
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    @Override
    protected Vector<PSWFRole> getAllModels() throws Exception {
        Vector<PSWFRole> psDEDataSetList = new Vector<PSWFRole>();
        CallResult callResult = this.getPSModelQueryHelper().getAllPSWFRoles(this.getPSSystem().getId(), psDEDataSetList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u5de5\u4f5c\u6d41\u89d2\u8272\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return psDEDataSetList;
    }

    @Override
    protected IPSWFRole registerModel(PSWFRole vt) throws Exception {
        IPSWFRole iPSWFRole = (IPSWFRole)this.internalGetModelHelper(vt.getPSWFROLEID());
        if (iPSWFRole != null) {
            return iPSWFRole;
        }
        this.setModel(vt.getPSWFROLEID(), vt, null);
        return (IPSWFRole)this.findModelHelper(vt.getPSWFROLEID());
    }

    @Override
    protected String getObjectId(PSWFRole vt) {
        return vt.getPSWFROLEID();
    }
}

