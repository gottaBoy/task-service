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
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.pscore.srv.PSModelHelper;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCCodeSnippet;
import net.ibizsys.pscore.srv.devcenter.service.PSDCCodeSnippetServiceBase;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDCCodeSnippetService
extends PSDCCodeSnippetServiceBase {
    private static final Log log = LogFactory.getLog(PSDCCodeSnippetService.class);

    @Override
    protected void onGetModelCode(PSDCCodeSnippet pSDCCodeSnippet) throws Exception {
        JSONArray jSONArray;
        int n;
        if (WebContext.getCurrent() == null) {
            throw new Exception(StringHelper.format((String)"\u5f53\u524d\u8bf7\u6c42\u73af\u5883\u65e0\u6548"));
        }
        CallResult callResult = new CallResult();
        String string = WebContext.getParentDEId();
        String string2 = WebContext.getParentKey();
        JSONObject jSONObject = WebContext.getAppData();
        if (StringHelper.isNullOrEmpty((String)string) || StringHelper.isNullOrEmpty((String)string2) || jSONObject == null) {
            throw new Exception(StringHelper.format((String)"\u5f53\u524d\u8bf7\u6c42\u53c2\u6570\u65e0\u6548"));
        }
        Object object = WebContext.getCurrent().getAttribute(pSDCCodeSnippet.getPSDCCodeSnippetId());
        if (object != null && object instanceof SimpleDataRowImpl) {
            DataObject.fromDataRow((IDataObject)pSDCCodeSnippet, (IDataRow)((SimpleDataRowImpl)object));
            return;
        }
        PSDCCodeSnippet pSDCCodeSnippet2 = new PSDCCodeSnippet();
        pSDCCodeSnippet2.set("srfdeid", PSModelHelper.getModelName(string));
        pSDCCodeSnippet2.set("srfkey", string2);
        pSDCCodeSnippet2.set("pssystemid", jSONObject.optString("pssystemid", ""));
        pSDCCodeSnippet2.set("psdevslnsysid", jSONObject.optString("psdevslnsysid", ""));
        pSDCCodeSnippet2.setPSDCCodeSnippetId(pSDCCodeSnippet.getPSDCCodeSnippetId());
        try {
            this.executeAction("X3G_GETCODE", pSDCCodeSnippet2);
        }
        catch (Exception exception) {
            log.error((Object)exception);
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u6a21\u578b\u4ee3\u7801\u7247\u6bb5\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)exception.getMessage()));
        }
        String string3 = DataObject.getStringValue((IDataObject)pSDCCodeSnippet2, (String)"SRFMODELLIST", null);
        if (!StringHelper.isNullOrEmpty((String)string3) && (n = 0) < (jSONArray = JSONArray.fromString((String)new String(Base64Helper.decode((String)string3), "GBK"))).length()) {
            jSONObject = jSONArray.getJSONObject(n);
            SimpleDataRowImpl simpleDataRowImpl = new SimpleDataRowImpl();
            DataObject.fromJSONObject((IDataObject)simpleDataRowImpl, (JSONObject)jSONObject);
            WebContext.getCurrent().setAttribute(pSDCCodeSnippet.getPSDCCodeSnippetId(), (Object)simpleDataRowImpl);
            simpleDataRowImpl.copyTo((IDataObject)pSDCCodeSnippet, true);
            return;
        }
    }

    @Override
    protected void onPublish(PSDCCodeSnippet pSDCCodeSnippet) throws Exception {
        this.executeRemoteCall2All("RELOADMODEL", pSDCCodeSnippet);
    }
}

