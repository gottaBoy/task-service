/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.SubSys;

import SA.SRFDA.PS.Core.SubSys.IPSSubAppView;
import SA.SRFDA.PS.Core.SubSys.PSSubAppGlobalModelBase;
import SA.SRFDA.PS.Core.SubSys.PSSubAppViewImpl;
import SA.SRFDA.PS.Data.PSSubAppView;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.HashMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSubAppViewGlobalModel
extends PSSubAppGlobalModelBase<String, PSSubAppView, IPSSubAppView> {
    private static final Log log = LogFactory.getLog(PSSubAppViewGlobalModel.class);
    private HashMap<String, IPSSubAppView> psSubDEViewMap = new HashMap();

    @Override
    protected PSSubAppView GetObject(String strPSSubAppViewId) {
        PSSubAppView psSubAppView = new PSSubAppView();
        CallResult callResult = this.iPSModelHelper.getPSSubAppView(strPSSubAppViewId, psSubAppView);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5b50\u7cfb\u7edf\u5e94\u7528\u89c6\u56fe[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSubAppViewId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSubAppView;
    }

    @Override
    protected IPSSubAppView OnCreateModelHelper(PSSubAppView vt) throws Exception {
        PSSubAppViewImpl iPSSubAppView = new PSSubAppViewImpl();
        iPSSubAppView.init(this.iDAGlobalHelper, this.getPSSubApp(), vt);
        return iPSSubAppView;
    }

    @Override
    protected Boolean TestObjectRenew(PSSubAppView obj) {
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
    protected IPSSubAppView registerModel(PSSubAppView vt) throws Exception {
        IPSSubAppView iPSSubAppView = (IPSSubAppView)this.InternalGetModelHelper(vt.getPSSUBAPPVIEWID());
        if (iPSSubAppView != null) {
            return iPSSubAppView;
        }
        this.setModel(vt.getPSSUBAPPVIEWID(), vt, null);
        iPSSubAppView = (IPSSubAppView)this.FindModelHelper(vt.getPSSUBAPPVIEWID());
        if (iPSSubAppView != null) {
            this.psSubDEViewMap.put(iPSSubAppView.getPSSubDEViewId(), iPSSubAppView);
        }
        return iPSSubAppView;
    }

    @Override
    protected Vector<PSSubAppView> getAllModels() throws Exception {
        Vector<PSSubAppView> list = new Vector<PSSubAppView>();
        CallResult callResult = this.iPSModelHelper.getAllPSSubAppViews(this.getPSSubApp().getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b50\u7cfb\u7edf\u5168\u90e8\u5b9e\u4f53\u89c6\u56fe\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    public IPSSubAppView getPSSubAppViewBySubDEView(String strPSSubDEViewId, boolean bTryMode) throws Exception {
        this.preloadModels();
        IPSSubAppView iPSSubAppView = this.psSubDEViewMap.get(strPSSubDEViewId);
        if (iPSSubAppView == null && !bTryMode) {
            throw new Exception(StringHelper.Format((String)"[%1$s]\u65e0\u6cd5\u901a\u8fc7\u5b50\u7cfb\u7edf\u5b9e\u4f53\u89c6\u56fe[%2$s]\u83b7\u53d6\u6307\u5b9a\u5b50\u5e94\u7528\u89c6\u56fe", (Object)this.getModelInfo(), (Object)strPSSubDEViewId));
        }
        return iPSSubAppView;
    }

    @Override
    protected String getObjectId(PSSubAppView vt) {
        return vt.getPSSUBAPPVIEWID();
    }
}

