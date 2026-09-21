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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCDBTable;
import net.ibizsys.pscore.srv.devcenter.service.PSDCDBTableServiceBase;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDCDBTableService
extends PSDCDBTableServiceBase {
    private static final Log log = LogFactory.getLog(PSDCDBTableService.class);

    protected CallResult internalGet(PSDCDBTable pSDCDBTable, boolean bl) throws Exception {
        return this.getDBModelCode(pSDCDBTable, "CREATEMODEL");
    }

    protected CallResult getDBModelCode(PSDCDBTable pSDCDBTable, String string) throws Exception {
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
        Object object = WebContext.getCurrent().getAttribute(pSDCDBTable.getPSDCDBTableId() + ":" + string);
        if (object != null && object instanceof SimpleDataRowImpl) {
            DataObject.fromDataRow((IDataObject)pSDCDBTable, (IDataRow)((SimpleDataRowImpl)object));
            return callResult;
        }
        PSDCDBTable pSDCDBTable2 = new PSDCDBTable();
        pSDCDBTable2.set("psdcdbinstid", jSONObject.optString("psdcdbinstid", ""));
        pSDCDBTable2.set("srfcodetype", string);
        pSDCDBTable2.set("pssystemid", jSONObject.optString("pssystemid", ""));
        pSDCDBTable2.set("psdevslnsysid", jSONObject.optString("psdevslnsysid", ""));
        pSDCDBTable2.set("psdevcenterid", this.getWebContext().getCurOrgId());
        pSDCDBTable2.setPSDCDBTableId(pSDCDBTable.getPSDCDBTableId());
        try {
            this.executeAction("X2G_GETCODE", (IEntity)pSDCDBTable2);
        }
        catch (Exception exception) {
            log.error((Object)exception);
            throw new Exception("\u83b7\u53d6\u6570\u636e\u5e93\u4ee3\u7801\u53d1\u751f\u9519\u8bef");
        }
        String string2 = DataObject.getStringValue((IDataObject)pSDCDBTable2, (String)"SRFMODELLIST", null);
        if (!StringHelper.isNullOrEmpty((String)string2) && (n = 0) < (jSONArray = JSONArray.fromString((String)new String(Base64Helper.decode((String)string2), "GBK"))).length()) {
            jSONObject = jSONArray.getJSONObject(n);
            SimpleDataRowImpl simpleDataRowImpl = new SimpleDataRowImpl();
            DataObject.fromJSONObject((IDataObject)simpleDataRowImpl, (JSONObject)jSONObject);
            simpleDataRowImpl.set("psdcdbtableid", (Object)pSDCDBTable.getPSDCDBTableId());
            simpleDataRowImpl.set("psdcdbtablename", (Object)pSDCDBTable.getPSDCDBTableId());
            WebContext.getCurrent().setAttribute(pSDCDBTable.getPSDCDBTableId() + ":" + string, (Object)simpleDataRowImpl);
            simpleDataRowImpl.copyTo((IDataObject)pSDCDBTable, true);
            return callResult;
        }
        callResult.setRetCode(3);
        return callResult;
    }

    @Override
    protected void onGenSelectCode(PSDCDBTable pSDCDBTable) throws Exception {
        CallResult callResult = this.getDBModelCode(pSDCDBTable, "SELECTDATA");
        if (callResult.isError()) {
            throw new Exception(callResult.getErrorInfo());
        }
        AjaxActionResult ajaxActionResult = WebContext.getCurrent().getCurAjaxActionResult();
        ajaxActionResult.setExtAttr("sqlcode", (Object)pSDCDBTable.getSQL());
    }

    @Override
    protected void onGenInsertCode(PSDCDBTable pSDCDBTable) throws Exception {
        CallResult callResult = this.getDBModelCode(pSDCDBTable, "INSERTDATA");
        if (callResult.isError()) {
            throw new Exception(callResult.getErrorInfo());
        }
        AjaxActionResult ajaxActionResult = WebContext.getCurrent().getCurAjaxActionResult();
        ajaxActionResult.setExtAttr("sqlcode", (Object)pSDCDBTable.getSQL());
    }
}

