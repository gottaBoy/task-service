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
import SA.SRFDA.PS.Core.Service.IPSSysServiceAPIHandler;
import SA.SRFDA.PS.Core.Service.PSSysServiceAPIHandlerImpl;
import SA.SRFDA.PS.Data.PSSysServiceAPIHandler;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysServiceAPIHandlerGlobalModel
extends PSSystemGlobalModelBase<String, PSSysServiceAPIHandler, IPSSysServiceAPIHandler> {
    private static final Log log = LogFactory.getLog(PSSysServiceAPIHandlerGlobalModel.class);

    @Override
    protected PSSysServiceAPIHandler GetObject(String strPSSysServiceAPIHandlerId) {
        if (this.isPrepareModels()) {
            return null;
        }
        PSSysServiceAPIHandler psSysServiceAPIHandler = new PSSysServiceAPIHandler();
        CallResult callResult = this.iPSModelHelper.getPSSysServiceAPIHandler(strPSSysServiceAPIHandlerId, psSysServiceAPIHandler);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u670d\u52a1\u63a5\u53e3\u5904\u7406\u5bf9\u8c61[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysServiceAPIHandlerId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSysServiceAPIHandler;
    }

    @Override
    protected IPSSysServiceAPIHandler OnCreateModelHelper(PSSysServiceAPIHandler vt) throws Exception {
        PSSysServiceAPIHandlerImpl iPSSysServiceAPIHandler = new PSSysServiceAPIHandlerImpl();
        iPSSysServiceAPIHandler.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSSysServiceAPIHandler;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysServiceAPIHandler obj) {
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
    protected IPSSysServiceAPIHandler registerModel(PSSysServiceAPIHandler vt) throws Exception {
        IPSSysServiceAPIHandler iPSSysServiceAPIHandler = (IPSSysServiceAPIHandler)this.InternalGetModelHelper(vt.getPSSYSSAHANDLERID());
        if (iPSSysServiceAPIHandler != null) {
            return iPSSysServiceAPIHandler;
        }
        this.setModel(vt.getPSSYSSAHANDLERID(), vt, null);
        return (IPSSysServiceAPIHandler)this.FindModelHelper(vt.getPSSYSSAHANDLERID());
    }

    @Override
    protected Vector<PSSysServiceAPIHandler> getAllModels() throws Exception {
        Vector<PSSysServiceAPIHandler> list = new Vector<PSSysServiceAPIHandler>();
        CallResult callResult = this.iPSModelHelper.getAllPSSysServiceAPIHandlers(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u670d\u52a1\u63a5\u53e3\u5904\u7406\u5bf9\u8c61\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysServiceAPIHandler vt) {
        return vt.getPSSYSSAHANDLERID();
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSSysServiceAPIHandler vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getSATYPE())) {
            return new String[]{vt.getSATYPE()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

