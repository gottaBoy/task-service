/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.IPSAppUtilPage
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.app;

import java.util.Vector;
import net.ibizsys.model.app.IPSAppUtilPage;
import net.ibizsys.model.app.PSAppUtilPageImpl;
import net.ibizsys.model.app.PSApplicationException;
import net.ibizsys.model.app.PSApplicationGlobalModelBase;
import net.ibizsys.model.entity.PSAppUtilPage;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppUtilPageGlobalModel
extends PSApplicationGlobalModelBase<String, PSAppUtilPage, IPSAppUtilPage> {
    private static final Log log = LogFactory.getLog(PSAppUtilPageGlobalModel.class);

    @Override
    protected PSAppUtilPage getObject(String strPSAppUtilPageId) {
        PSAppUtilPage psAppUtilPage = new PSAppUtilPage();
        CallResult callResult = this.getPSModelQueryHelper().getPSAppUtilPage(strPSAppUtilPageId, psAppUtilPage);
        if (callResult.isError()) {
            log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u5e94\u7528\u529f\u80fd\u9875\u9762[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSAppUtilPageId, (Object)callResult.getErrorInfo()));
            return null;
        }
        if (StringHelper.compare((String)this.getPSApplication().getId(), (String)psAppUtilPage.getPSSYSAPPID(), (boolean)false) != 0) {
            return null;
        }
        return psAppUtilPage;
    }

    @Override
    protected IPSAppUtilPage onCreateModelHelper(PSAppUtilPage vt) throws Exception {
        PSAppUtilPageImpl iPSAppUtilPage = new PSAppUtilPageImpl();
        iPSAppUtilPage.init(this.getPSModelStorageContext(), this.getPSApplication(), vt);
        return iPSAppUtilPage;
    }

    @Override
    protected Boolean testObjectRenew(PSAppUtilPage obj) {
        return false;
    }

    @Override
    protected IPSAppUtilPage registerModel(PSAppUtilPage vt) throws Exception {
        IPSAppUtilPage iPSAppUtilPage = (IPSAppUtilPage)this.internalGetModelHelper(vt.getPSAPPUTILPAGEID());
        if (iPSAppUtilPage != null) {
            return iPSAppUtilPage;
        }
        this.setModel(vt.getPSAPPUTILPAGEID(), vt, null);
        return (IPSAppUtilPage)this.findModelHelper(vt.getPSAPPUTILPAGEID());
    }

    @Override
    protected Vector<PSAppUtilPage> getAllModels() throws Exception {
        Vector<PSAppUtilPage> list = new Vector<PSAppUtilPage>();
        CallResult callResult = this.getPSModelQueryHelper().getAllPSAppUtilPages(this.iPSApplication.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u5e94\u7528\u5168\u90e8\u5e94\u7528\u529f\u80fd\u9875\u9762\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSAppUtilPage psAppUtilPage : list) {
            this.setModel(psAppUtilPage.getPSAPPUTILPAGEID(), psAppUtilPage, null);
        }
        return list;
    }

    @Override
    protected String getObjectId(PSAppUtilPage vt) {
        return vt.getPSAPPUTILPAGEID();
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
        return PSApplicationException.create(this.getPSApplication(), 40005, objObjectId);
    }
}

