/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.WF;

import SA.SRFDA.PS.Core.App.WF.IPSAppWF;
import SA.SRFDA.PS.Core.App.WF.IPSAppWFUIAction;
import SA.SRFDA.PS.Core.App.WF.IPSAppWFVer;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Core.WF.IPSWFVersion;
import SA.SRFDA.PS.Core.WF.IPSWorkflow;
import SA.SRFDA.PS.Core.WF.UIAction.PSWFUIActionImpl;
import SA.SRFDA.PS.Data.PSDEUIAction;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppWFUIActionGlobalModel
extends PSGlobalModelBase<String, PSDEUIAction, IPSAppWFUIAction> {
    private static final Log log = LogFactory.getLog(PSAppWFUIActionGlobalModel.class);
    protected IPSWFVersion iPSWFVersion = null;
    protected IPSWorkflow iPSWorkflow = null;
    private IPSAppWF iPSAppWF = null;
    private IPSAppWFVer iPSAppWFVer = null;

    public CallResult Init(ISRFDAGlobalHelper iDAGlobalHelper, IPSAppWFVer iPSAppWFVer) {
        this.iPSAppWFVer = iPSAppWFVer;
        this.iPSAppWF = this.iPSAppWFVer.getPSAppWF();
        this.iPSWFVersion = this.iPSAppWFVer.getPSWFVersion();
        this.iPSWorkflow = this.iPSWFVersion.getPSWorkflow();
        return super.Init(iDAGlobalHelper);
    }

    public CallResult Init(ISRFDAGlobalHelper iDAGlobalHelper, IPSAppWF iPSAppWF) {
        this.iPSAppWF = iPSAppWF;
        this.iPSWorkflow = this.iPSAppWF.getPSWorkflow();
        return super.Init(iDAGlobalHelper);
    }

    @Override
    protected PSDEUIAction GetObject(String strPSDEUIActionId) {
        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u6d41\u7a0b\u754c\u9762\u884c\u4e3a[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDEUIActionId, (Object)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6"));
        return null;
    }

    @Override
    protected IPSAppWFUIAction OnCreateModelHelper(PSDEUIAction vt) throws Exception {
        IPSAppWFUIAction iPSWFUIAction = null;
        String strItemObj = vt.getITEMOBJ();
        if (StringHelper.IsNullOrEmpty((String)strItemObj)) {
            strItemObj = vt.getSYSITEMOBJ();
        }
        iPSWFUIAction = StringHelper.IsNullOrEmpty((String)strItemObj) ? new PSWFUIActionImpl() : (IPSAppWFUIAction)ObjectHelper.Create((String)strItemObj);
        iPSWFUIAction.init(this.iDAGlobalHelper, this.iPSAppWF, this.iPSAppWFVer, vt);
        return iPSWFUIAction;
    }

    @Override
    protected Boolean TestObjectRenew(PSDEUIAction obj) {
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
    protected Vector<PSDEUIAction> getAllModels() throws Exception {
        Vector<PSDEUIAction> psDEUIActionList = new Vector<PSDEUIAction>();
        CallResult callResult = null;
        callResult = this.iPSWFVersion != null ? this.iPSModelHelper.getPSWFUIActions(this.iPSWFVersion.getId(), psDEUIActionList) : this.iPSModelHelper.getPSWFUIActions2(this.iPSWorkflow.getId(), psDEUIActionList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5168\u90e8\u6d41\u7a0b\u754c\u9762\u884c\u4e3a\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return psDEUIActionList;
    }

    @Override
    protected IPSAppWFUIAction registerModel(PSDEUIAction vt) throws Exception {
        IPSAppWFUIAction iPSWFUIAction = (IPSAppWFUIAction)this.InternalGetModelHelper(vt.getPSDEUIACTIONID());
        if (iPSWFUIAction != null) {
            return iPSWFUIAction;
        }
        this.setModel(vt.getPSDEUIACTIONID(), vt, null);
        return (IPSAppWFUIAction)this.FindModelHelper(vt.getPSDEUIACTIONID());
    }

    @Override
    public String getPSSysModelInstId() {
        if (this.iPSWFVersion != null) {
            return this.iPSWFVersion.getPSSysModelInstId();
        }
        return this.iPSWorkflow.getPSSysModelInstId();
    }

    @Override
    protected String getObjectId(PSDEUIAction vt) {
        return vt.getPSDEUIACTIONID();
    }
}

