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
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSDepSysApp;
import SA.SRFDA.PS.Core.Deploy.IPSDepSysType;
import SA.SRFDA.PS.Core.Deploy.IPSDepSysVer;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Data.PSDepSysApp;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDepSysAppGlobalModel
extends PSGlobalModelBase<String, PSDepSysApp, IPSDepSysApp> {
    private static final Log log = LogFactory.getLog(PSDepSysAppGlobalModel.class);
    protected IPSDepSysVer iPSDepSysVer = null;

    public CallResult Init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDepSysVer iPSDepSysVer) {
        this.iPSDepSysVer = iPSDepSysVer;
        return this.Init(iDAGlobalHelper);
    }

    protected IPSDepSysVer getPSDepSysVer() {
        return this.iPSDepSysVer;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSDepSysVer().getPSSysModelInstId();
    }

    @Override
    protected PSDepSysApp GetObject(String strPSDepSysAppId) {
        return null;
    }

    @Override
    protected IPSDepSysApp OnCreateModelHelper(PSDepSysApp vt) throws Exception {
        IPSDepSysType iPSDepSysType = this.iPSModelStorage.getPSDepSysType(vt.getPSDEPSYSAPPTYPE());
        IPSDepSysApp iPSDepSysApp = iPSDepSysType.createPSDepSysApp(vt);
        return iPSDepSysApp;
    }

    @Override
    protected Boolean TestObjectRenew(PSDepSysApp obj) {
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
    protected IPSDepSysApp registerModel(PSDepSysApp vt) throws Exception {
        IPSDepSysApp iPSDepSysApp = (IPSDepSysApp)this.InternalGetModelHelper(vt.getPSDEPSYSAPPID());
        if (iPSDepSysApp != null) {
            return iPSDepSysApp;
        }
        this.setModel(vt.getPSDEPSYSAPPID(), vt, null);
        return (IPSDepSysApp)this.FindModelHelper(vt.getPSDEPSYSAPPID());
    }

    @Override
    protected Vector<PSDepSysApp> getAllModels() throws Exception {
        Vector<PSDepSysApp> list = new Vector<PSDepSysApp>();
        CallResult callResult = this.iPSModelHelper.getAllPSDepSysApps(this.iPSDepSysVer.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u53ef\u90e8\u7f72\u7cfb\u7edf\u7248\u672c\u5168\u90e8\u5e94\u7528\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSDepSysApp vt) {
        return vt.getPSDEPSYSAPPID();
    }
}

