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
import SA.SRFDA.PS.Core.Service.IPSSysServiceAPI;
import SA.SRFDA.PS.Core.Service.PSSysServiceAPIImpl;
import SA.SRFDA.PS.Data.PSSysServiceAPI;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysServiceAPIGlobalModel
extends PSSystemGlobalModelBase<String, PSSysServiceAPI, IPSSysServiceAPI> {
    private static final Log log = LogFactory.getLog(PSSysServiceAPIGlobalModel.class);

    @Override
    protected PSSysServiceAPI GetObject(String strPSSysServiceAPIId) {
        PSSysServiceAPI psSysServiceAPI = new PSSysServiceAPI();
        CallResult callResult = this.iPSModelHelper.getPSSysServiceAPI(strPSSysServiceAPIId, psSysServiceAPI);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u670d\u52a1API[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysServiceAPIId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSysServiceAPI;
    }

    @Override
    protected IPSSysServiceAPI OnCreateModelHelper(PSSysServiceAPI vt, String strObjectId) throws Exception {
        PSSysServiceAPIImpl iPSSysServiceAPI = new PSSysServiceAPIImpl();
        this.internalSetModelHelper(strObjectId, iPSSysServiceAPI);
        iPSSysServiceAPI.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSSysServiceAPI;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysServiceAPI obj) {
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
    protected IPSSysServiceAPI registerModel(PSSysServiceAPI vt) throws Exception {
        IPSSysServiceAPI iPSSysServiceAPI = (IPSSysServiceAPI)this.InternalGetModelHelper(vt.getPSSYSSERVICEAPIID());
        if (iPSSysServiceAPI != null) {
            return iPSSysServiceAPI;
        }
        this.setModel(vt.getPSSYSSERVICEAPIID(), vt, null);
        return (IPSSysServiceAPI)this.FindModelHelper(vt.getPSSYSSERVICEAPIID());
    }

    @Override
    protected Vector<PSSysServiceAPI> getAllModels() throws Exception {
        Vector<PSSysServiceAPI> list = new Vector<PSSysServiceAPI>();
        CallResult callResult = this.iPSModelHelper.getAllPSSysServiceAPIs(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u670d\u52a1API\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysServiceAPI vt) {
        return vt.getPSSYSSERVICEAPIID();
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSSysServiceAPI vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

