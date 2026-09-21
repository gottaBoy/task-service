/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Ajax;

import SA.SRFDA.PS.Core.Control.Ajax.IPSAjaxControlHandler;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityGlobalModelBase;
import SA.SRFDA.PS.Data.PSACHandler;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAjaxControlHandlerGlobalModel
extends PSDataEntityGlobalModelBase<String, PSACHandler, IPSAjaxControlHandler> {
    private static final Log log = LogFactory.getLog(PSAjaxControlHandlerGlobalModel.class);

    @Override
    protected PSACHandler GetObject(String strPSAjaxControlHandlerId) {
        return null;
    }

    @Override
    protected IPSAjaxControlHandler OnCreateModelHelper(PSACHandler vt) throws Exception {
        throw new Exception(StringHelper.Format((String)"\u6ca1\u6709\u5b9e\u73b0"));
    }

    @Override
    protected Boolean TestObjectRenew(PSACHandler obj) {
        return false;
    }

    @Override
    protected void onPreloadModels() {
        super.onPreloadModels();
        Vector<PSACHandler> psPSAjaxControlHandlerList = new Vector<PSACHandler>();
        CallResult callResult = this.iPSModelHelper.getPSAjaxControlHandlers(this.getPSDataEntity().getId(), psPSAjaxControlHandlerList);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u90e8\u4ef6\u540e\u53f0\u5904\u7406\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return;
        }
        for (PSACHandler psPSAjaxControlHandler : psPSAjaxControlHandlerList) {
            this.setModel(psPSAjaxControlHandler.getPSACHANDLERID(), psPSAjaxControlHandler, null);
        }
    }

    @Override
    protected String getObjectId(PSACHandler vt) {
        return vt.getPSACHANDLERID();
    }

    @Override
    public PSACHandler FindModel(String objObjectId) {
        this.preloadModels();
        return (PSACHandler)((Object)this.InternalGetModel(objObjectId));
    }
}

