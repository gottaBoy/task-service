/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.View;

import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Core.View.IPSViewMsgGroup;
import SA.SRFDA.PS.Core.View.PSViewMsgGroupImpl;
import SA.SRFDA.PS.Data.PSViewMsgGroup;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSViewMsgGroupGlobalModel
extends PSSystemGlobalModelBase<String, PSViewMsgGroup, IPSViewMsgGroup> {
    private static final Log log = LogFactory.getLog(PSViewMsgGroupGlobalModel.class);

    @Override
    protected PSViewMsgGroup GetObject(String strPSViewMsgGroupId) {
        PSViewMsgGroup psViewMsgGroup = new PSViewMsgGroup();
        CallResult callResult = this.iPSModelHelper.getPSViewMsgGroup(strPSViewMsgGroupId, psViewMsgGroup);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u89c6\u56fe\u6d88\u606f\u7ec4[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSViewMsgGroupId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psViewMsgGroup;
    }

    @Override
    protected IPSViewMsgGroup OnCreateModelHelper(PSViewMsgGroup vt) throws Exception {
        PSViewMsgGroupImpl iPSViewMsgGroup = null;
        iPSViewMsgGroup = new PSViewMsgGroupImpl();
        iPSViewMsgGroup.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSViewMsgGroup;
    }

    @Override
    protected Boolean TestObjectRenew(PSViewMsgGroup obj) {
        return false;
    }

    @Override
    public void ResetAll() {
        super.ResetAll();
    }

    @Override
    protected IPSViewMsgGroup registerModel(PSViewMsgGroup vt) throws Exception {
        IPSViewMsgGroup iIPSViewMsgGroup = (IPSViewMsgGroup)this.InternalGetModelHelper(vt.getPSVIEWMSGGROUPID());
        if (iIPSViewMsgGroup != null) {
            return iIPSViewMsgGroup;
        }
        this.setModel(vt.getPSVIEWMSGGROUPID(), vt, null);
        return (IPSViewMsgGroup)this.FindModelHelper(vt.getPSVIEWMSGGROUPID());
    }

    @Override
    protected Vector<PSViewMsgGroup> getAllModels() throws Exception {
        Vector<PSViewMsgGroup> list = new Vector<PSViewMsgGroup>();
        CallResult callResult = this.iPSModelHelper.getAllPSViewMsgGroups(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u89c6\u56fe\u6d88\u606f\u7ec4\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSViewMsgGroup vt) {
        return vt.getPSVIEWMSGGROUPID();
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
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSViewMsgGroup vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

