/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.ajax.IPSAjaxControlHandler
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.control.ajax;

import java.util.Vector;
import net.ibizsys.model.control.ajax.IPSAjaxControlHandler;
import net.ibizsys.model.dataentity.PSDataEntityGlobalModelBase;
import net.ibizsys.model.entity.PSACHandler;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAjaxControlHandlerGlobalModel
extends PSDataEntityGlobalModelBase<String, PSACHandler, IPSAjaxControlHandler> {
    private static final Log log = LogFactory.getLog(PSAjaxControlHandlerGlobalModel.class);

    @Override
    protected PSACHandler getObject(String strPSAjaxControlHandlerId) {
        return null;
    }

    @Override
    protected IPSAjaxControlHandler onCreateModelHelper(PSACHandler vt) throws Exception {
        throw new Exception(StringHelper.format((String)"\u6ca1\u6709\u5b9e\u73b0"));
    }

    @Override
    protected Boolean testObjectRenew(PSACHandler obj) {
        return false;
    }

    @Override
    protected void onPreloadModels() {
        super.onPreloadModels();
        Vector<PSACHandler> psPSAjaxControlHandlerList = new Vector<PSACHandler>();
        CallResult callResult = this.getPSModelQueryHelper().getPSAjaxControlHandlers(this.getPSDataEntity().getId(), psPSAjaxControlHandlerList);
        if (callResult.isError()) {
            log.error((Object)StringHelper.format((String)"\u67e5\u8be2\u90e8\u4ef6\u540e\u53f0\u5904\u7406\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
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
}

