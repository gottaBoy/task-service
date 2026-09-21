/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.WF;

import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Core.WF.IPSWFRole;
import SA.SRFDA.PS.Core.WF.PSWFRoleImpl;
import SA.SRFDA.PS.Data.PSWFRole;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSWFRoleGlobalModel
extends PSSystemGlobalModelBase<String, PSWFRole, IPSWFRole> {
    private static final Log log = LogFactory.getLog(PSWFRoleGlobalModel.class);

    @Override
    protected PSWFRole GetObject(String strPSWFRoleId) {
        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u5de5\u4f5c\u6d41\u89d2\u8272[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSWFRoleId, (Object)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6"));
        return null;
    }

    @Override
    protected IPSWFRole OnCreateModelHelper(PSWFRole vt) throws Exception {
        PSWFRoleImpl iPSWFRole = new PSWFRoleImpl();
        iPSWFRole.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSWFRole;
    }

    @Override
    protected Boolean TestObjectRenew(PSWFRole obj) {
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
        CallResult callResult = this.iPSModelHelper.getAllPSWFRoles(this.getPSSystem().getId(), psDEDataSetList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u5de5\u4f5c\u6d41\u89d2\u8272\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return psDEDataSetList;
    }

    @Override
    protected IPSWFRole registerModel(PSWFRole vt) throws Exception {
        IPSWFRole iPSWFRole = (IPSWFRole)this.InternalGetModelHelper(vt.getPSWFROLEID());
        if (iPSWFRole != null) {
            return iPSWFRole;
        }
        this.setModel(vt.getPSWFROLEID(), vt, null);
        return (IPSWFRole)this.FindModelHelper(vt.getPSWFROLEID());
    }

    @Override
    protected String getObjectId(PSWFRole vt) {
        return vt.getPSWFROLEID();
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSWFRole vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

