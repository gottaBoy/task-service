/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Core.Res.IPSSysPDTView;
import SA.SRFDA.PS.Core.Res.PSSysPDTViewImpl;
import SA.SRFDA.PS.Data.PSSysPDTView;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysPDTViewGlobalModel
extends PSSystemGlobalModelBase<String, PSSysPDTView, IPSSysPDTView> {
    private static final Log log = LogFactory.getLog(PSSysPDTViewGlobalModel.class);

    @Override
    protected PSSysPDTView GetObject(String strPSSysPDTViewId) {
        PSSysPDTView psSysPDTView = new PSSysPDTView();
        CallResult callResult = this.iPSModelHelper.getPSSysPDTView(strPSSysPDTViewId, psSysPDTView);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u9884\u7f6e\u89c6\u56fe[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysPDTViewId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSysPDTView;
    }

    @Override
    protected IPSSysPDTView OnCreateModelHelper(PSSysPDTView vt) throws Exception {
        PSSysPDTViewImpl iPSSysPDTView = new PSSysPDTViewImpl();
        iPSSysPDTView.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSSysPDTView;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysPDTView obj) {
        return false;
    }

    @Override
    public void ResetAll() {
        super.ResetAll();
    }

    @Override
    protected IPSSysPDTView registerModel(PSSysPDTView vt) throws Exception {
        IPSSysPDTView iIPSSysPDTView = (IPSSysPDTView)this.InternalGetModelHelper(vt.getPSSYSPDTVIEWID());
        if (iIPSSysPDTView != null) {
            return iIPSSysPDTView;
        }
        this.setModel(vt.getPSSYSPDTVIEWID(), vt, null);
        return (IPSSysPDTView)this.FindModelHelper(vt.getPSSYSPDTVIEWID());
    }

    @Override
    protected Vector<PSSysPDTView> getAllModels() throws Exception {
        Vector<PSSysPDTView> list = new Vector<PSSysPDTView>();
        CallResult callResult = this.iPSModelHelper.getAllPSSysPDTViews(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u9884\u7f6e\u89c6\u56fe\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysPDTView vt) {
        return vt.getPSSYSPDTVIEWID();
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

    protected String[] getObjectAliases(PSSysPDTView vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

