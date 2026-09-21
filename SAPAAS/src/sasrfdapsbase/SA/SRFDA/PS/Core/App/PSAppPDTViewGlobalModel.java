/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App;

import SA.SRFDA.PS.Core.App.IPSAppPDTView;
import SA.SRFDA.PS.Core.App.PSAppPDTViewImpl;
import SA.SRFDA.PS.Core.App.PSApplicationException;
import SA.SRFDA.PS.Core.App.PSApplicationGlobalModelBase;
import SA.SRFDA.PS.Data.PSAppPDTView;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import net.ibizsys.paas.util.KeyValueHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppPDTViewGlobalModel
extends PSApplicationGlobalModelBase<String, PSAppPDTView, IPSAppPDTView> {
    private static final Log log = LogFactory.getLog(PSAppPDTViewGlobalModel.class);

    @Override
    protected PSAppPDTView GetObject(String strPSAppPDTViewId) {
        PSAppPDTView psAppPDTView = new PSAppPDTView();
        CallResult callResult = this.iPSModelHelper.getPSAppPDTView(strPSAppPDTViewId, psAppPDTView);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5e94\u7528\u9884\u7f6e\u89c6\u56fe[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSAppPDTViewId, (Object)callResult.getErrorInfo()));
            return null;
        }
        if (StringHelper.Compare((String)this.getPSApplication().getId(), (String)psAppPDTView.getPSSYSAPPID(), (boolean)false) != 0) {
            return null;
        }
        return psAppPDTView;
    }

    @Override
    protected IPSAppPDTView OnCreateModelHelper(PSAppPDTView vt) throws Exception {
        PSAppPDTViewImpl iPSAppPDTView = new PSAppPDTViewImpl();
        iPSAppPDTView.init(this.iDAGlobalHelper, this.getPSApplication(), vt);
        return iPSAppPDTView;
    }

    @Override
    protected Boolean TestObjectRenew(PSAppPDTView obj) {
        return false;
    }

    @Override
    protected IPSAppPDTView registerModel(PSAppPDTView vt) throws Exception {
        IPSAppPDTView iPSAppPDTView = (IPSAppPDTView)this.InternalGetModelHelper(vt.getPSAPPPDTVIEWID());
        if (iPSAppPDTView != null) {
            return iPSAppPDTView;
        }
        this.setModel(vt.getPSAPPPDTVIEWID(), vt, null);
        iPSAppPDTView = (IPSAppPDTView)this.FindModelHelper(vt.getPSAPPPDTVIEWID());
        if (iPSAppPDTView != null && vt.getPSAPPPDTVIEWID().indexOf("S") == 0) {
            this.setModel(KeyValueHelper.genUniqueId((String)this.getPSApplication().getId(), (String)vt.getPSSYSPDTVIEWID()), vt, iPSAppPDTView);
        }
        return iPSAppPDTView;
    }

    @Override
    protected Vector<PSAppPDTView> getAllModels() throws Exception {
        Vector<PSAppPDTView> list = new Vector<PSAppPDTView>();
        CallResult callResult = this.iPSModelHelper.getAllPSAppPDTViews(this.iPSApplication.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u5168\u90e8\u5e94\u7528\u9884\u7f6e\u89c6\u56fe\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
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
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    @Override
    protected Exception createNotFoundException(String objObjectId) throws Exception {
        return PSApplicationException.create(this.getPSApplication(), 40015, objObjectId);
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSAppPDTView vt) {
        String strUniqueId;
        if (!StringHelper.IsNullOrEmpty((String)vt.getPSSYSPDTVIEWID()) && StringHelper.Compare((String)(strUniqueId = KeyValueHelper.genUniqueId((String)this.getPSApplication().getId(), (String)vt.getPSSYSPDTVIEWID())), (String)vt.getPSAPPPDTVIEWID(), (boolean)false) != 0) {
            return new String[]{strUniqueId.toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

