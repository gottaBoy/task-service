/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.WF;

import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Core.WF.IPSSysWFSetting;
import SA.SRFDA.PS.Core.WF.IPSWFUtilUIAction;
import SA.SRFDA.PS.Core.WF.PSWFUtilUIActionImpl;
import SA.SRFDA.PS.Data.PSWFUtilUIAction;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSWFUtilUIActionGlobalModel
extends PSGlobalModelBase<String, PSWFUtilUIAction, IPSWFUtilUIAction> {
    private static final Log log = LogFactory.getLog(PSWFUtilUIActionGlobalModel.class);
    protected IPSSysWFSetting iPSSysWFSetting = null;

    public CallResult Init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysWFSetting iPSSysWFSetting) {
        this.iPSSysWFSetting = iPSSysWFSetting;
        return super.Init(iDAGlobalHelper);
    }

    @Override
    protected PSWFUtilUIAction GetObject(String strPSWFUtilUIActionId) {
        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5de5\u4f5c\u6d41\u529f\u80fd\u754c\u9762\u884c\u4e3a[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSWFUtilUIActionId, (Object)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6"));
        return null;
    }

    @Override
    protected IPSWFUtilUIAction OnCreateModelHelper(PSWFUtilUIAction vt) throws Exception {
        PSWFUtilUIActionImpl iPSWFUtilUIAction = new PSWFUtilUIActionImpl();
        iPSWFUtilUIAction.init(this.iDAGlobalHelper, this.getPSSysWFSetting(), vt);
        return iPSWFUtilUIAction;
    }

    @Override
    protected Boolean TestObjectRenew(PSWFUtilUIAction obj) {
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
    protected Vector<PSWFUtilUIAction> getAllModels() throws Exception {
        Vector<PSWFUtilUIAction> psWFUtilUIActionList2 = new Vector<PSWFUtilUIAction>();
        CallResult callResult = this.iPSModelHelper.getPSWFUtilUIActions(this.getPSSysWFSetting().getId(), psWFUtilUIActionList2);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5168\u90e8\u5de5\u4f5c\u6d41\u529f\u80fd\u754c\u9762\u884c\u4e3a\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return psWFUtilUIActionList2;
    }

    @Override
    protected IPSWFUtilUIAction registerModel(PSWFUtilUIAction vt) throws Exception {
        IPSWFUtilUIAction iPSWFUtilUIAction = (IPSWFUtilUIAction)this.InternalGetModelHelper(vt.getPSWFUTILUIACTIONID());
        if (iPSWFUtilUIAction != null) {
            return iPSWFUtilUIAction;
        }
        this.setModel(vt.getPSWFUTILUIACTIONID(), vt, null);
        return (IPSWFUtilUIAction)this.FindModelHelper(vt.getPSWFUTILUIACTIONID());
    }

    public IPSSysWFSetting getPSSysWFSetting() {
        return this.iPSSysWFSetting;
    }

    protected void setPSSysWFSetting(IPSSysWFSetting iPSSysWFSetting) {
        this.iPSSysWFSetting = iPSSysWFSetting;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSysWFSetting().getPSSysModelInstId();
    }

    @Override
    protected String getObjectId(PSWFUtilUIAction vt) {
        return vt.getPSWFUTILUIACTIONID();
    }
}

