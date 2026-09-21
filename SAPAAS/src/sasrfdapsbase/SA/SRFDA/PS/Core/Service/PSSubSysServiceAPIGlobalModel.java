/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Service;

import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPI;
import SA.SRFDA.PS.Core.Service.PSSubSysServiceAPIImpl;
import SA.SRFDA.PS.Data.PSSubSysServiceAPI;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSubSysServiceAPIGlobalModel
extends PSSystemGlobalModelBase<String, PSSubSysServiceAPI, IPSSubSysServiceAPI> {
    private static final Log log = LogFactory.getLog(PSSubSysServiceAPIGlobalModel.class);

    @Override
    protected PSSubSysServiceAPI GetObject(String strPSSubSysServiceAPIId) {
        PSSubSysServiceAPI psSubSysServiceAPI = new PSSubSysServiceAPI();
        CallResult callResult = this.iPSModelHelper.getPSSubSysServiceAPI(strPSSubSysServiceAPIId, psSubSysServiceAPI);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5916\u90e8\u670d\u52a1API[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSubSysServiceAPIId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSubSysServiceAPI;
    }

    @Override
    protected IPSSubSysServiceAPI OnCreateModelHelper(PSSubSysServiceAPI vt) throws Exception {
        PSSubSysServiceAPIImpl iPSSubSysServiceAPI = new PSSubSysServiceAPIImpl();
        iPSSubSysServiceAPI.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSSubSysServiceAPI;
    }

    @Override
    protected Boolean TestObjectRenew(PSSubSysServiceAPI obj) {
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
    protected IPSSubSysServiceAPI registerModel(PSSubSysServiceAPI vt) throws Exception {
        IPSSubSysServiceAPI iPSSubSysServiceAPI = (IPSSubSysServiceAPI)this.InternalGetModelHelper(vt.getPSSUBSYSSERVICEAPIID());
        if (iPSSubSysServiceAPI != null) {
            return iPSSubSysServiceAPI;
        }
        this.setModel(vt.getPSSUBSYSSERVICEAPIID(), vt, null);
        return (IPSSubSysServiceAPI)this.FindModelHelper(vt.getPSSUBSYSSERVICEAPIID());
    }

    @Override
    protected Vector<PSSubSysServiceAPI> getAllModels() throws Exception {
        Vector<PSSubSysServiceAPI> list = new Vector<PSSubSysServiceAPI>();
        CallResult callResult = this.iPSModelHelper.getAllPSSubSysServiceAPIs(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5168\u90e8\u5916\u90e8\u670d\u52a1API\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSubSysServiceAPI vt) {
        return vt.getPSSUBSYSSERVICEAPIID();
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSSubSysServiceAPI vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

