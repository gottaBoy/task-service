/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App;

import SA.SRFDA.PS.Core.App.IPSSubAppRef;
import SA.SRFDA.PS.Core.App.PSApplicationGlobalModelBase;
import SA.SRFDA.PS.Core.App.PSSubAppRefImpl;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSAppSubApp;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSSubAppRefGlobalModel
extends PSApplicationGlobalModelBase<String, PSAppSubApp, IPSSubAppRef> {
    private static final Log log = LogFactory.getLog(PSSubAppRefGlobalModel.class);
    private Map<String, IPSSubAppRef> psSubAppRefMap = new LinkedHashMap<String, IPSSubAppRef>();

    @Override
    protected PSAppSubApp GetObject(String strPSAppSubAppId) {
        PSAppSubApp psAppSubApp = new PSAppSubApp();
        CallResult callResult = this.iPSModelHelper.getPSAppSubApp(strPSAppSubAppId, psAppSubApp);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e94\u7528\u5e94\u7528\u5f15\u7528[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSAppSubAppId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psAppSubApp;
    }

    @Override
    protected IPSSubAppRef OnCreateModelHelper(PSAppSubApp vt) throws Exception {
        PSSubAppRefImpl iPSAppSubApp = new PSSubAppRefImpl();
        iPSAppSubApp.init(this.iDAGlobalHelper, this.getPSApplication(), vt);
        return iPSAppSubApp;
    }

    @Override
    protected Boolean TestObjectRenew(PSAppSubApp obj) {
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
    protected IPSSubAppRef registerModel(PSAppSubApp vt) throws Exception {
        IPSSubAppRef iPSSubAppRef = (IPSSubAppRef)this.InternalGetModelHelper(vt.getPSAPPSUBAPPID());
        if (iPSSubAppRef != null) {
            return iPSSubAppRef;
        }
        this.setModel(vt.getPSAPPSUBAPPID(), vt, null);
        iPSSubAppRef = (IPSSubAppRef)this.FindModelHelper(vt.getPSAPPSUBAPPID());
        this.psSubAppRefMap.put(iPSSubAppRef.getPSSubApp().getId(), iPSSubAppRef);
        return iPSSubAppRef;
    }

    @Override
    protected Vector<PSAppSubApp> getAllModels() throws Exception {
        Vector<PSAppSubApp> list = new Vector<PSAppSubApp>();
        CallResult callResult = this.iPSModelHelper.getAllPSAppSubApps(this.getPSApplication().getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u5168\u90e8\u5b50\u5e94\u7528\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    public IPSSubAppRef getPSSubAppRefBySubApp(String strPSSubAppId, boolean bTryMode) throws Exception {
        this.getAllModelHelpers();
        IPSSubAppRef iPSSubAppRef = this.psSubAppRefMap.get(strPSSubAppId);
        if (iPSSubAppRef == null && !bTryMode) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5b50\u5e94\u7528\u5f15\u7528"));
        }
        return iPSSubAppRef;
    }

    @Override
    protected String getObjectId(PSAppSubApp vt) {
        return vt.getPSAPPSUBAPPID();
    }
}

