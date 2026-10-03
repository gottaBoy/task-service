/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.IDataRow
 *  net.ibizsys.paas.db.impl.SimpleDataRowImpl
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.util.Base64Helper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.AjaxActionResult
 *  net.ibizsys.paas.web.WebContext
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.devcenter.service;

import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.impl.SimpleDataRowImpl;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.Base64Helper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCDBView;
import net.ibizsys.pscore.srv.devcenter.service.PSDCDBViewServiceBase;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDCDBViewService
extends PSDCDBViewServiceBase {
    private static final Log log = LogFactory.getLog(PSDCDBViewService.class);

    protected CallResult internalGet(PSDCDBView pSDCDBView, boolean bl) throws Exception {
        return this.getDBModelCode(pSDCDBView, "CREATEMODEL");
    }

    protected CallResult getDBModelCode(PSDCDBView pSDCDBView, String string) throws Exception {
        JSONArray jSONArray;
        int n;
        if (WebContext.getCurrent() == null) {
            throw new Exception(StringHelper.format((String)"\u5f53\u524d\u8bf7\u6c42\u73af\u5883\u65e0\u6548"));
        }
        JSONObject jSONObject = WebContext.getAppData();
        if (jSONObject == null) {
            throw new Exception(StringHelper.format((String)"\u5f53\u524d\u8bf7\u6c42\u53c2\u6570\u65e0\u6548"));
        }
        CallResult callResult = new CallResult();
        Object object = WebContext.getCurrent().getAttribute(pSDCDBView.getPSDCDBViewId() + ":" + string);
        if (object != null && object instanceof SimpleDataRowImpl) {
            DataObject.fromDataRow((IDataObject)pSDCDBView, (IDataRow)((SimpleDataRowImpl)object));
            return callResult;
        }
        PSDCDBView pSDCDBView2 = new PSDCDBView();
        pSDCDBView2.set("psdcdbinstid", jSONObject.optString("psdcdbinstid", ""));
        pSDCDBView2.set("srfcodetype", string);
        pSDCDBView2.set("pssystemid", jSONObject.optString("pssystemid", ""));
        pSDCDBView2.set("psdevslnsysid", jSONObject.optString("psdevslnsysid", ""));
        pSDCDBView2.set("psdevcenterid", this.getWebContext().getCurOrgId());
        pSDCDBView2.setPSDCDBViewId(pSDCDBView.getPSDCDBViewId());
        try {
            this.executeAction("X2G_GETCODE", pSDCDBView2);
        }
        catch (Exception exception) {
            log.error((Object)exception);
            throw new Exception("\u83b7\u53d6\u6570\u636e\u5e93\u4ee3\u7801\u53d1\u751f\u9519\u8bef");
        }
        String string2 = DataObject.getStringValue((IDataObject)pSDCDBView2, (String)"SRFMODELLIST", null);
        if (!StringHelper.isNullOrEmpty((String)string2) && (n = 0) < (jSONArray = JSONArray.fromString((String)new String(Base64Helper.decode((String)string2), "GBK"))).length()) {
            jSONObject = jSONArray.getJSONObject(n);
            SimpleDataRowImpl simpleDataRowImpl = new SimpleDataRowImpl();
            DataObject.fromJSONObject((IDataObject)simpleDataRowImpl, (JSONObject)jSONObject);
            simpleDataRowImpl.set("psdcdbviewid", (Object)pSDCDBView.getPSDCDBViewId());
            simpleDataRowImpl.set("psdcdbviewname", (Object)pSDCDBView.getPSDCDBViewId());
            WebContext.getCurrent().setAttribute(pSDCDBView.getPSDCDBViewId() + ":" + string, (Object)simpleDataRowImpl);
            simpleDataRowImpl.copyTo((IDataObject)pSDCDBView, true);
            return callResult;
        }
        callResult.setRetCode(3);
        return callResult;
    }

    @Override
    protected void onGenSelectCode(PSDCDBView pSDCDBView) throws Exception {
        CallResult callResult = this.getDBModelCode(pSDCDBView, "SELECTDATA");
        if (callResult.isError()) {
            throw new Exception(callResult.getErrorInfo());
        }
        AjaxActionResult ajaxActionResult = WebContext.getCurrent().getCurAjaxActionResult();
        ajaxActionResult.setExtAttr("sqlcode", (Object)pSDCDBView.getSQL());
    }
}

