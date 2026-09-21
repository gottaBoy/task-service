/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.Control;

import SA.SRFDA.PS.Core.App.Control.IPSAppPortlet;
import SA.SRFDA.PS.Core.App.Control.PSAppPortletImpl;
import SA.SRFDA.PS.Core.App.PSApplicationException;
import SA.SRFDA.PS.Core.App.PSApplicationGlobalModelBase;
import SA.SRFDA.PS.Data.PSAppPortlet;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppPortletGlobalModel
extends PSApplicationGlobalModelBase<String, PSAppPortlet, IPSAppPortlet> {
    private static final Log log = LogFactory.getLog(PSAppPortletGlobalModel.class);

    @Override
    protected PSAppPortlet GetObject(String strPSAppPortletId) {
        if (this.isPrepareModels()) {
            return null;
        }
        PSAppPortlet psAppPortlet = new PSAppPortlet();
        CallResult callResult = this.iPSModelHelper.getPSAppPortlet(strPSAppPortletId, psAppPortlet);
        if (callResult.isError()) {
            String strInfo = StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5e94\u7528\u95e8\u6237\u90e8\u4ef6[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSAppPortletId, (Object)callResult.getErrorInfo());
            log.error((Object)strInfo);
            this.getPSApplicationRuntime().log(1, this.getPSApplication(), strInfo);
            return null;
        }
        return psAppPortlet;
    }

    @Override
    protected IPSAppPortlet OnCreateModelHelper(PSAppPortlet vt) throws Exception {
        PSAppPortletImpl iPSAppPortlet = new PSAppPortletImpl();
        iPSAppPortlet.init(this.iDAGlobalHelper, this.getPSApplication(), vt);
        return iPSAppPortlet;
    }

    @Override
    protected Boolean TestObjectRenew(PSAppPortlet obj) {
        return false;
    }

    @Override
    protected String getObjectId(PSAppPortlet vt) {
        return vt.getPSAPPPORTLETID();
    }

    @Override
    protected IPSAppPortlet registerModel(PSAppPortlet vt) throws Exception {
        IPSAppPortlet iPSAppPortlet = (IPSAppPortlet)this.InternalGetModelHelper(vt.getPSAPPPORTLETID());
        if (iPSAppPortlet != null) {
            return iPSAppPortlet;
        }
        this.setModel(vt.getPSAPPPORTLETID(), vt, null);
        return (IPSAppPortlet)this.FindModelHelper(vt.getPSAPPPORTLETID());
    }

    @Override
    protected Vector<PSAppPortlet> getAllModels() throws Exception {
        Vector<PSAppPortlet> list = new Vector<PSAppPortlet>();
        CallResult callResult = this.iPSModelHelper.getAllPSAppPortlets(this.iPSApplication.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u5168\u90e8\u5e94\u7528\u95e8\u6237\u90e8\u4ef6\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSAppPortlet psAppPortlet : list) {
            this.setModel(psAppPortlet.getPSAPPPORTLETID(), psAppPortlet, null);
        }
        return list;
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
        return PSApplicationException.create(this.getPSApplication(), 40021, objObjectId);
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSAppPortlet vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getPSSYSPORTLETID())) {
            if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
                return new String[]{vt.getPSSYSPORTLETID().toUpperCase(), vt.getCODENAME().toUpperCase()};
            }
            return new String[]{vt.getPSSYSPORTLETID().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

