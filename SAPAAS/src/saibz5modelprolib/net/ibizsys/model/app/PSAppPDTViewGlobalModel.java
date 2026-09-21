/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.app;

import java.util.Vector;
import net.ibizsys.model.app.IPSAppPDTView;
import net.ibizsys.model.app.PSAppPDTViewImpl;
import net.ibizsys.model.app.PSApplicationException;
import net.ibizsys.model.app.PSApplicationGlobalModelBase;
import net.ibizsys.model.entity.PSAppPDTView;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppPDTViewGlobalModel
extends PSApplicationGlobalModelBase<String, PSAppPDTView, IPSAppPDTView> {
    private static final Log log = LogFactory.getLog(PSAppPDTViewGlobalModel.class);

    @Override
    protected PSAppPDTView getObject(String strPSAppPDTViewId) {
        PSAppPDTView psAppPDTView = new PSAppPDTView();
        CallResult callResult = this.getPSModelQueryHelper().getPSAppPDTView(strPSAppPDTViewId, psAppPDTView);
        if (callResult.isError()) {
            log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u5e94\u7528\u9884\u7f6e\u89c6\u56fe[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSAppPDTViewId, (Object)callResult.getErrorInfo()));
            return null;
        }
        if (StringHelper.compare((String)this.getPSApplication().getId(), (String)psAppPDTView.getPSSYSAPPID(), (boolean)false) != 0) {
            return null;
        }
        return psAppPDTView;
    }

    @Override
    protected IPSAppPDTView onCreateModelHelper(PSAppPDTView vt) throws Exception {
        PSAppPDTViewImpl iPSAppPDTView = new PSAppPDTViewImpl();
        iPSAppPDTView.init(this.getPSModelStorageContext(), this.getPSApplication(), vt);
        return iPSAppPDTView;
    }

    @Override
    protected Boolean testObjectRenew(PSAppPDTView obj) {
        return false;
    }

    @Override
    protected IPSAppPDTView registerModel(PSAppPDTView vt) throws Exception {
        IPSAppPDTView iPSAppPDTView = (IPSAppPDTView)this.internalGetModelHelper(vt.getPSAPPPDTVIEWID());
        if (iPSAppPDTView != null) {
            return iPSAppPDTView;
        }
        this.setModel(vt.getPSAPPPDTVIEWID(), vt, null);
        return (IPSAppPDTView)this.findModelHelper(vt.getPSAPPPDTVIEWID());
    }

    @Override
    protected Vector<PSAppPDTView> getAllModels() throws Exception {
        Vector<PSAppPDTView> list = new Vector<PSAppPDTView>();
        CallResult callResult = this.getPSModelQueryHelper().getAllPSAppPDTViews(this.iPSApplication.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u5e94\u7528\u5168\u90e8\u5e94\u7528\u9884\u7f6e\u89c6\u56fe\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSAppPDTView psAppPDTView : list) {
            this.setModel(psAppPDTView.getPSAPPPDTVIEWID(), psAppPDTView, null);
        }
        return list;
    }

    @Override
    protected String getObjectId(PSAppPDTView vt) {
        return vt.getPSAPPPDTVIEWID();
    }

    @Override
    protected void onPreloadModels() {
        super.onPreloadModels();
        try {
            this.getAllModelHelpers();
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    @Override
    protected Exception createNotFoundException(String objObjectId) throws Exception {
        return PSApplicationException.create(this.getPSApplication(), 40015, objObjectId);
    }
}

