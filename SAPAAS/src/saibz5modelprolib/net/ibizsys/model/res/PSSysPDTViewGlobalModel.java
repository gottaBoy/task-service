/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.res.IPSSysPDTView
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.res;

import java.util.Vector;
import net.ibizsys.model.PSSystemGlobalModelBase;
import net.ibizsys.model.entity.PSSysPDTView;
import net.ibizsys.model.res.IPSSysPDTView;
import net.ibizsys.model.res.PSSysPDTViewImpl;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysPDTViewGlobalModel
extends PSSystemGlobalModelBase<String, PSSysPDTView, IPSSysPDTView> {
    private static final Log log = LogFactory.getLog(PSSysPDTViewGlobalModel.class);

    @Override
    protected PSSysPDTView getObject(String strPSSysPDTViewId) {
        PSSysPDTView psSysPDTView = new PSSysPDTView();
        CallResult callResult = this.getPSModelQueryHelper().getPSSysPDTView(strPSSysPDTViewId, psSysPDTView);
        if (callResult.isError()) {
            log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u9884\u7f6e\u89c6\u56fe[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysPDTViewId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSysPDTView;
    }

    @Override
    protected IPSSysPDTView onCreateModelHelper(PSSysPDTView vt) throws Exception {
        PSSysPDTViewImpl iPSSysPDTView = new PSSysPDTViewImpl();
        iPSSysPDTView.init(this.getPSModelStorageContext(), this.getPSSystem(), vt);
        return iPSSysPDTView;
    }

    @Override
    protected Boolean testObjectRenew(PSSysPDTView obj) {
        return false;
    }

    @Override
    protected IPSSysPDTView registerModel(PSSysPDTView vt) throws Exception {
        IPSSysPDTView iIPSSysPDTView = (IPSSysPDTView)this.internalGetModelHelper(vt.getPSSYSPDTVIEWID());
        if (iIPSSysPDTView != null) {
            return iIPSSysPDTView;
        }
        this.setModel(vt.getPSSYSPDTVIEWID(), vt, null);
        return (IPSSysPDTView)this.findModelHelper(vt.getPSSYSPDTVIEWID());
    }

    @Override
    protected Vector<PSSysPDTView> getAllModels() throws Exception {
        Vector<PSSysPDTView> list = new Vector<PSSysPDTView>();
        CallResult callResult = this.getPSModelQueryHelper().getAllPSSysPDTViews(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u9884\u7f6e\u89c6\u56fe\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysPDTView vt) {
        return vt.getPSSYSPDTVIEWID();
    }
}

