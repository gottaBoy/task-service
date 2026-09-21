/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.BaseDAGlobalModel;
import SA.SRFDA.Ctrl.DETBBHandlerHelper;
import SA.SRFDA.Ctrl.Data.DETBBHandler;
import SA.SRFDA.Ctrl.IDETBBHandlerHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DETBBHandlerGlobalModel
extends BaseDAGlobalModel<String, DETBBHandler, IDETBBHandlerHelper> {
    private static final Log log = LogFactory.getLog(DETBBHandlerGlobalModel.class);

    @Override
    protected CallResult OnInit() {
        CallResult callResult = super.OnInit();
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            this.Reload();
        }
        catch (Exception e) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u91cd\u65b0\u52a0\u8f7d\u5b9e\u4f53\u5de5\u5177\u680f\u6309\u94ae\u5904\u7406\u5bf9\u8c61\u914d\u7f6e\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)e.getMessage()));
            log.error((Object)callResult.getErrorInfo(), (Throwable)e);
            return callResult;
        }
        return callResult;
    }

    @Override
    protected DETBBHandler GetObject(String objObjectId) {
        return null;
    }

    @Override
    protected Boolean TestObjectRenew(DETBBHandler obj) {
        return false;
    }

    public void Reload() throws Exception {
        this.ResetAll();
        Vector<DETBBHandler> list = new Vector<DETBBHandler>();
        CallResult callResult = this.iDAGlobalHelper.getDAModelHelper().GetDETBBHandlers(list);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u5de5\u5177\u680f\u6309\u94ae\u5904\u7406\u5bf9\u8c61\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        for (DETBBHandler deTBBHandler : list) {
            String strOldHandler;
            String strFullId;
            String strDEId = deTBBHandler.getDEID();
            if (StringHelper.IsNullOrEmpty((String)strDEId)) {
                strDEId = "*";
            }
            if (this.objMap.containsKey(strFullId = StringHelper.Format((String)"%1$s|%2$s", (Object)strDEId, (Object)(strOldHandler = deTBBHandler.getDETBBHANDLERNAME())))) continue;
            this.objMap.put(strFullId, deTBBHandler);
            DETBBHandlerHelper iDETBBHandlerHelper = new DETBBHandlerHelper();
            iDETBBHandlerHelper.Init(this.iDAGlobalHelper, deTBBHandler);
            this.objHelperMap.put(strFullId, iDETBBHandlerHelper);
        }
    }

    public String GetTBBHandler(String strDEId, String strOldHandler) {
        String strFullId = StringHelper.Format((String)"%1$s|%2$s", (Object)strDEId, (Object)strOldHandler);
        DETBBHandler deTBBHandler = (DETBBHandler)((Object)this.objMap.get(strFullId));
        if (deTBBHandler != null) {
            return deTBBHandler.getNEWHANDLER();
        }
        strFullId = StringHelper.Format((String)"%1$s|%2$s", (Object)"*", (Object)strOldHandler);
        deTBBHandler = (DETBBHandler)((Object)this.objMap.get(strFullId));
        if (deTBBHandler != null) {
            return deTBBHandler.getNEWHANDLER();
        }
        return strOldHandler;
    }
}

