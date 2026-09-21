/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App;

import SA.SRFDA.PS.Core.App.IPSAppResource;
import SA.SRFDA.PS.Core.App.PSAppResourceImpl;
import SA.SRFDA.PS.Core.App.PSApplicationException;
import SA.SRFDA.PS.Core.App.PSApplicationGlobalModelBase;
import SA.SRFDA.PS.Data.PSAppResource;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppResourceGlobalModel
extends PSApplicationGlobalModelBase<String, PSAppResource, IPSAppResource> {
    private static final Log log = LogFactory.getLog(PSAppResourceGlobalModel.class);

    @Override
    protected PSAppResource GetObject(String strPSAppResourceId) {
        if (this.isPrepareModels()) {
            return null;
        }
        PSAppResource psAppResource = new PSAppResource();
        CallResult callResult = this.iPSModelHelper.getPSAppResource(strPSAppResourceId, psAppResource);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5e94\u7528\u9884\u7f6e\u8d44\u6e90[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSAppResourceId, (Object)callResult.getErrorInfo()));
            return null;
        }
        if (StringHelper.Compare((String)this.getPSApplication().getId(), (String)psAppResource.getPSSYSAPPID(), (boolean)false) != 0) {
            return null;
        }
        return psAppResource;
    }

    @Override
    protected IPSAppResource OnCreateModelHelper(PSAppResource vt, String strId) throws Exception {
        if (StringHelper.Compare((String)strId, (String)vt.getPSAPPRESOURCEID(), (boolean)false) == 0) {
            PSAppResourceImpl iPSAppResource = new PSAppResourceImpl();
            iPSAppResource.init(this.iDAGlobalHelper, this.getPSApplication(), vt);
            return iPSAppResource;
        }
        return (IPSAppResource)this.FindModelHelper(vt.getPSAPPRESOURCEID());
    }

    @Override
    protected Boolean TestObjectRenew(PSAppResource obj) {
        return false;
    }

    @Override
    protected IPSAppResource registerModel(PSAppResource vt) throws Exception {
        IPSAppResource iPSAppResource = (IPSAppResource)this.InternalGetModelHelper(vt.getPSAPPRESOURCEID());
        if (iPSAppResource != null) {
            return iPSAppResource;
        }
        this.setModel(vt.getPSAPPRESOURCEID(), vt, null);
        iPSAppResource = (IPSAppResource)this.FindModelHelper(vt.getPSAPPRESOURCEID());
        return iPSAppResource;
    }

    @Override
    protected Vector<PSAppResource> getAllModels() throws Exception {
        Vector<PSAppResource> list = new Vector<PSAppResource>();
        CallResult callResult = this.iPSModelHelper.getAllPSAppResources(this.iPSApplication.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u5168\u90e8\u5e94\u7528\u9884\u7f6e\u8d44\u6e90\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSAppResource vt) {
        return vt.getPSAPPRESOURCEID();
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
        return PSApplicationException.create(this.getPSApplication(), 40019, objObjectId);
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSAppResource vt) {
        if (!net.ibizsys.paas.util.StringHelper.isNullOrEmpty((String)vt.getRESTAG())) {
            return new String[]{vt.getRESTAG().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

