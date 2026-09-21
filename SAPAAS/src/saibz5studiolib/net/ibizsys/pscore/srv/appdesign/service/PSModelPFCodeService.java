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
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.Base64Helper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.WebContext
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.appdesign.service;

import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.impl.SimpleDataRowImpl;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.Base64Helper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.pscore.srv.PSModelHelper;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppViewCode;
import net.ibizsys.pscore.srv.appdesign.entity.PSModelPFCode;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewCodeService;
import net.ibizsys.pscore.srv.appdesign.service.PSModelPFCodeServiceBase;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSModelPFCodeService
extends PSModelPFCodeServiceBase {
    private static final Log log = LogFactory.getLog(PSModelPFCodeService.class);

    protected CallResult internalGet(PSModelPFCode pSModelPFCode, boolean bl) throws Exception {
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
            return callResult;
        }
        Object object = WebContext.getCurrent().getAttribute(pSModelPFCode.getPSModelPFCodeId());
        if (object != null && object instanceof SimpleDataRowImpl) {
            DataObject.fromDataRow((IDataObject)pSModelPFCode, (IDataRow)((SimpleDataRowImpl)object));
            return callResult;
        }
        PSModelPFCode pSModelPFCode2 = new PSModelPFCode();
        pSModelPFCode2.set("srfdeid", PSModelHelper.getModelName(string));
        pSModelPFCode2.set("srfkey", string2);
        pSModelPFCode2.set("pssystemid", jSONObject.optString("pssystemid", ""));
        pSModelPFCode2.set("psdevslnsysid", jSONObject.optString("psdevslnsysid", ""));
        pSModelPFCode2.setPSModelPFCodeId(pSModelPFCode.getPSModelPFCodeId());
        try {
            this.executeAction("XG_GETCODE", (IEntity)pSModelPFCode2);
        }
        catch (Exception exception) {
            log.error((Object)exception);
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u6a21\u578b\u524d\u53f0\u4ee3\u7801\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)exception.getMessage()));
        }
        String string3 = DataObject.getStringValue((IDataObject)pSModelPFCode2, (String)"SRFMODELLIST", null);
        if (!StringHelper.isNullOrEmpty((String)string3) && (n = 0) < (jSONArray = JSONArray.fromString((String)new String(Base64Helper.decode((String)string3), "GBK"))).length()) {
            jSONObject = jSONArray.getJSONObject(n);
            SimpleDataRowImpl simpleDataRowImpl = new SimpleDataRowImpl();
            DataObject.fromJSONObject((IDataObject)simpleDataRowImpl, (JSONObject)jSONObject);
            WebContext.getCurrent().setAttribute(pSModelPFCode.getPSModelPFCodeId(), (Object)simpleDataRowImpl);
            simpleDataRowImpl.copyTo((IDataObject)pSModelPFCode, true);
            PSAppViewCodeService pSAppViewCodeService = (PSAppViewCodeService)ServiceGlobal.getService(PSAppViewCodeService.class, (SessionFactory)this.getSessionFactory());
            PSAppViewCode pSAppViewCode = new PSAppViewCode();
            pSAppViewCode.setPSAppViewCodeId(pSModelPFCode.getPSModelPFCodeId());
            if (pSAppViewCodeService.get((IEntity)pSAppViewCode, true)) {
                pSModelPFCode.setCustomFlag(1);
                pSModelPFCode.setUserCode(pSAppViewCode.getUserCode());
            } else {
                pSModelPFCode.setCustomFlag(0);
            }
            return callResult;
        }
        callResult.setRetCode(3);
        return callResult;
    }

    @Override
    protected void internalUpdate(PSModelPFCode pSModelPFCode) throws Exception {
        PSAppViewCodeService pSAppViewCodeService = (PSAppViewCodeService)ServiceGlobal.getService(PSAppViewCodeService.class, (SessionFactory)this.getSessionFactory());
        PSAppViewCode pSAppViewCode = new PSAppViewCode();
        pSAppViewCode.setPSAppViewCodeId(pSModelPFCode.getPSModelPFCodeId());
        if (DataObject.getBoolValue((Integer)pSModelPFCode.getCustomFlag(), (boolean)false)) {
            pSAppViewCode.setPSSysAppId(pSModelPFCode.getPSSysAppId());
            pSAppViewCode.setPrjType(pSModelPFCode.getPrjName());
            pSAppViewCode.setPSAppViewCodeName(pSModelPFCode.getPSModelPFCodeName());
            pSAppViewCode.setCodePath(pSModelPFCode.getCodePath());
            pSAppViewCode.setUserCode(pSModelPFCode.getUserCode());
            pSAppViewCodeService.save((IEntity)pSAppViewCode);
        } else if (pSAppViewCodeService.checkKey(pSAppViewCode) == 1) {
            pSAppViewCodeService.remove((IEntity)pSAppViewCode);
        }
    }

    @Override
    protected void onLocateCode(PSModelPFCode pSModelPFCode) throws Exception {
        if (WebContext.getCurrent() == null || WebContext.getCurrent().getCurAjaxActionResult() == null) {
            throw new Exception(StringHelper.format((String)"\u5f53\u524d\u8bf7\u6c42\u73af\u5883\u65e0\u6548"));
        }
        this.get((IEntity)pSModelPFCode);
        WebContext.getCurrent().getCurAjaxActionResult().setJSCode(StringHelper.format((String)"IBizApp.locateCode('%1$s/%2$s','pf')", (Object)pSModelPFCode.getCodePath(), (Object)pSModelPFCode.getPSModelPFCodeName()));
    }
}

