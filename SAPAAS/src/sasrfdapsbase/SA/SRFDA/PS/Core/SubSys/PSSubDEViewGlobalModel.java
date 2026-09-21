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

import SA.SRFDA.PS.Core.SubSys.IPSSubDEView;
import SA.SRFDA.PS.Core.SubSys.PSSubDEViewImpl;
import SA.SRFDA.PS.Core.SubSys.PSSubSysGlobalModelBase;
import SA.SRFDA.PS.Data.PSSubDEView;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSubDEViewGlobalModel
extends PSSubSysGlobalModelBase<String, PSSubDEView, IPSSubDEView> {
    private static final Log log = LogFactory.getLog(PSSubDEViewGlobalModel.class);

    @Override
    protected PSSubDEView GetObject(String strPSSubDEViewId) {
        PSSubDEView psSubDEView = new PSSubDEView();
        CallResult callResult = this.iPSModelHelper.getPSSubDEView(strPSSubDEViewId, psSubDEView);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5b50\u7cfb\u7edf\u5b9e\u4f53\u89c6\u56fe[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSubDEViewId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSubDEView;
    }

    @Override
    protected IPSSubDEView OnCreateModelHelper(PSSubDEView vt) throws Exception {
        PSSubDEViewImpl iPSSubDEView = new PSSubDEViewImpl();
        iPSSubDEView.init(this.iDAGlobalHelper, this.getPSSubSys(), vt);
        return iPSSubDEView;
    }

    @Override
    protected Boolean TestObjectRenew(PSSubDEView obj) {
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
    protected IPSSubDEView registerModel(PSSubDEView vt) throws Exception {
        IPSSubDEView iPSSubDEView = (IPSSubDEView)this.InternalGetModelHelper(vt.getPSSUBDEVIEWID());
        if (iPSSubDEView != null) {
            return iPSSubDEView;
        }
        this.setModel(vt.getPSSUBDEVIEWID(), vt, null);
        return (IPSSubDEView)this.FindModelHelper(vt.getPSSUBDEVIEWID());
    }

    @Override
    protected Vector<PSSubDEView> getAllModels() throws Exception {
        Vector<PSSubDEView> list = new Vector<PSSubDEView>();
        CallResult callResult = this.iPSModelHelper.getAllPSSubDEViews(this.getPSSubSys().getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b50\u7cfb\u7edf\u5168\u90e8\u5b9e\u4f53\u89c6\u56fe\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSubDEView vt) {
        return vt.getPSSUBDEVIEWID();
    }
}

