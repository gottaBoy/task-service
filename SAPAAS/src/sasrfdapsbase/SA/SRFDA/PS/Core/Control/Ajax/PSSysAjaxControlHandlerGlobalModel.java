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
package SA.SRFDA.PS.Core.Control.Ajax;

import SA.SRFDA.PS.Core.Control.Ajax.IPSAjaxControlHandler;
import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Data.PSACHandler;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.HashMap;
import java.util.Vector;
import net.ibizsys.paas.util.KeyValueHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysAjaxControlHandlerGlobalModel
extends PSSystemGlobalModelBase<String, PSACHandler, IPSAjaxControlHandler> {
    private static final Log log = LogFactory.getLog(PSSysAjaxControlHandlerGlobalModel.class);

    @Override
    protected PSACHandler GetObject(String strPSAjaxControlHandlerId) {
        return null;
    }

    @Override
    protected IPSAjaxControlHandler OnCreateModelHelper(PSACHandler vt) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    protected Boolean TestObjectRenew(PSACHandler obj) {
        return false;
    }

    @Override
    protected void onPreloadModels() {
        super.onPreloadModels();
        Vector<PSACHandler> psAjaxControlHandlerList = new Vector<PSACHandler>();
        CallResult callResult = this.iPSModelHelper.getPSSysAjaxControlHandlers(this.getPSSystem().getId(), psAjaxControlHandlerList);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u90e8\u4ef6\u540e\u53f0\u5904\u7406\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return;
        }
        HashMap<String, PSACHandler> psACHandlerMap = new HashMap<String, PSACHandler>();
        for (PSACHandler psAjaxControlHandler : psAjaxControlHandlerList) {
            psACHandlerMap.put(psAjaxControlHandler.getPSACHANDLERID(), psAjaxControlHandler);
        }
        for (PSACHandler psAjaxControlHandler : psAjaxControlHandlerList) {
            String strUniqueId;
            this.setModel(psAjaxControlHandler.getPSACHANDLERID(), psAjaxControlHandler, null);
            if (StringHelper.IsNullOrEmpty((String)psAjaxControlHandler.getPSSFACHANDLERID()) || StringHelper.Compare((String)(strUniqueId = KeyValueHelper.genUniqueId((String)this.getPSSystem().getId(), (String)psAjaxControlHandler.getPSSFACHANDLERID())), (String)psAjaxControlHandler.getPSACHANDLERID(), (boolean)false) == 0 || psACHandlerMap.containsKey(strUniqueId)) continue;
            this.setModel(strUniqueId, psAjaxControlHandler, null);
            psACHandlerMap.put(strUniqueId, psAjaxControlHandler);
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

