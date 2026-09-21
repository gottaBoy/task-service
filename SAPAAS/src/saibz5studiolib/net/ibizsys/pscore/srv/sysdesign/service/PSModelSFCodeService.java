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
package net.ibizsys.pscore.srv.sysdesign.service;

import java.util.Map;
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
import net.ibizsys.pscore.srv.sysdesign.entity.PSModelSFCode;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFCode;
import net.ibizsys.pscore.srv.sysdesign.service.PSModelSFCodeServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFCodeService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSModelSFCodeService
extends PSModelSFCodeServiceBase {
    private static final Log log = LogFactory.getLog(PSModelSFCodeService.class);

    protected CallResult internalGet(PSModelSFCode pSModelSFCode, boolean bl) throws Exception {
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
        Object object = WebContext.getCurrent().getAttribute(pSModelSFCode.getPSModelSFCodeId());
        if (object != null && object instanceof SimpleDataRowImpl) {
            DataObject.fromDataRow((IDataObject)pSModelSFCode, (IDataRow)((SimpleDataRowImpl)object));
            return callResult;
        }
        PSModelSFCode pSModelSFCode2 = new PSModelSFCode();
        pSModelSFCode2.set("srfdeid", PSModelHelper.getModelName(string));
        pSModelSFCode2.set("srfkey", string2);
        pSModelSFCode2.set("pssystemid", jSONObject.optString("pssystemid", ""));
        pSModelSFCode2.set("psdevslnsysid", jSONObject.optString("psdevslnsysid", ""));
        pSModelSFCode2.setPSModelSFCodeId(pSModelSFCode.getPSModelSFCodeId());
        try {
            this.executeAction("XG_GETCODE", (IEntity)pSModelSFCode2);
        }
        catch (Exception exception) {
            log.error((Object)exception);
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u6a21\u578b\u540e\u53f0\u4ee3\u7801\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)exception.getMessage()));
        }
        String string3 = DataObject.getStringValue((IDataObject)pSModelSFCode2, (String)"SRFMODELLIST", null);
        if (!StringHelper.isNullOrEmpty((String)string3) && (n = 0) < (jSONArray = JSONArray.fromString((String)new String(Base64Helper.decode((String)string3), "GBK"))).length()) {
            jSONObject = jSONArray.getJSONObject(n);
            SimpleDataRowImpl simpleDataRowImpl = new SimpleDataRowImpl();
            DataObject.fromJSONObject((IDataObject)simpleDataRowImpl, (JSONObject)jSONObject);
            WebContext.getCurrent().setAttribute(pSModelSFCode.getPSModelSFCodeId(), (Object)simpleDataRowImpl);
            simpleDataRowImpl.copyTo((IDataObject)pSModelSFCode, true);
            PSSysSFCodeService pSSysSFCodeService = (PSSysSFCodeService)ServiceGlobal.getService(PSSysSFCodeService.class, (SessionFactory)this.getSessionFactory());
            PSSysSFCode pSSysSFCode = new PSSysSFCode();
            pSSysSFCode.setPSSysSFCodeId(pSModelSFCode.getPSModelSFCodeId());
            if (pSSysSFCodeService.get((IEntity)pSSysSFCode, true)) {
                pSModelSFCode.setCustomFlag(1);
                pSModelSFCode.setUserCode(pSSysSFCode.getUserCode());
            } else {
                pSModelSFCode.setCustomFlag(0);
            }
            return callResult;
        }
        callResult.setRetCode(3);
        return callResult;
    }

    @Override
    protected void internalUpdate(PSModelSFCode pSModelSFCode) throws Exception {
        PSSysSFCodeService pSSysSFCodeService = (PSSysSFCodeService)ServiceGlobal.getService(PSSysSFCodeService.class, (SessionFactory)this.getSessionFactory());
        PSSysSFCode pSSysSFCode = new PSSysSFCode();
        pSSysSFCode.setPSSysSFCodeId(pSModelSFCode.getPSModelSFCodeId());
        if (DataObject.getBoolValue((Integer)pSModelSFCode.getCustomFlag(), (boolean)false)) {
            pSSysSFCode.setPSSysSFPubId(pSModelSFCode.getPSSysSFPubId());
            pSSysSFCode.setCodePath(pSModelSFCode.getPrjName());
            pSSysSFCode.setPSSysSFCodeName(pSModelSFCode.getPSModelSFCodeName());
            pSSysSFCode.setFullCodeName(pSModelSFCode.getCodePath());
            pSSysSFCode.setUserCode(pSModelSFCode.getUserCode());
            pSSysSFCodeService.save((IEntity)pSSysSFCode);
        } else if (pSSysSFCodeService.checkKey(pSSysSFCode) == 1) {
            pSSysSFCodeService.remove((IEntity)pSSysSFCode);
        }
    }

    @Override
    protected void onLocateCode(PSModelSFCode pSModelSFCode) throws Exception {
        if (WebContext.getCurrent() == null || WebContext.getCurrent().getCurAjaxActionResult() == null) {
            throw new Exception(StringHelper.format((String)"\u5f53\u524d\u8bf7\u6c42\u73af\u5883\u65e0\u6548"));
        }
        this.get((IEntity)pSModelSFCode);
        WebContext.getCurrent().getCurAjaxActionResult().setJSCode(StringHelper.format((String)"IBizApp.locateCode('%1$s/%2$s','sf')", (Object)pSModelSFCode.getCodePath(), (Object)pSModelSFCode.getPSModelSFCodeName()));
    }

    @Override
    protected void getRemoteCallUrlParams(Map<String, String> map, String string, IEntity iEntity) throws Exception {
        super.getRemoteCallUrlParams(map, string, iEntity);
        map.put("action", "preview");
    }
}

