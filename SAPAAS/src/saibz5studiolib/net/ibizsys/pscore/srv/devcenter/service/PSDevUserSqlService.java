/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.Base64Helper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.paas.web.WebContext
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.devcenter.service;

import java.util.Date;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.Base64Helper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterDBInst;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevUserSql;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevUserSqlServiceBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDBDevInst;
import net.ibizsys.pscore.srv.paasmgr.service.PSDBDevInstService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDevUserSqlService
extends PSDevUserSqlServiceBase {
    private static final Log log = LogFactory.getLog(PSDevUserSqlService.class);

    @Override
    protected void onBeforeGetDraft(PSDevUserSql pSDevUserSql) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSDevUserSql.getPSDevUserSqlName())) {
            pSDevUserSql.setPSDevUserSqlName(String.format("%1$tY%1$tm%1$td%1$tH%1$tM%1$tS", new Date()));
        }
        super.onBeforeGetDraft(pSDevUserSql);
    }

    @Override
    protected void onExecuteSQL(PSDevUserSql pSDevUserSql) throws Exception {
        PSDBDevInst pSDBDevInst;
        Object object;
        String string;
        if (this.getWebContext() == null || this.getWebContext().getCurAjaxActionResult() == null) {
            throw new Exception("\u5f53\u524d\u8bf7\u6c42\u73af\u5883\u4e0d\u6b63\u786e");
        }
        String string2 = null;
        JSONObject jSONObject = WebContext.getAppData((IWebContext)this.getWebContext());
        if (jSONObject != null) {
            string2 = jSONObject.optString("psdcdbinstid");
        }
        if (StringHelper.isNullOrEmpty(string2)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u6570\u636e\u5e93\u5b9e\u4f8b");
        }
        String string3 = this.getWebContext().getPostValue("sql");
        PSDevCenterDBInst pSDevCenterDBInst = new PSDevCenterDBInst();
        PSDevCenterDBInstService pSDevCenterDBInstService = (PSDevCenterDBInstService)ServiceGlobal.getService(PSDevCenterDBInstService.class);
        pSDevCenterDBInst.setPSDevCenterDBInstId(string2);
        if (string2.indexOf("JITDBINST:") == 0) {
            string = string2.substring("JITDBINST:".length());
            object = (PSDBDevInstService)ServiceGlobal.getService(PSDBDevInstService.class);
            pSDBDevInst = new PSDBDevInst();
            pSDBDevInst.setPSDBDevInstId(string);
            if (!object.get((IEntity)pSDBDevInst, true)) {
                throw new Exception("\u6307\u5b9a\u5e73\u53f0\u6570\u636e\u5e93\u4e0d\u5b58\u5728");
            }
            if (StringHelper.compare((String)pSDBDevInst.getPSDevCenterId(), (String)this.getWebContext().getCurOrgId(), (boolean)false) != 0) {
                throw new Exception("\u5f53\u524d\u7528\u6237\u8eab\u4efd\u4e0d\u6b63\u786e");
            }
        } else {
            if (!pSDevCenterDBInstService.get((IEntity)pSDevCenterDBInst, true)) {
                throw new Exception("\u6307\u5b9a\u5e94\u7528\u4e2d\u5fc3\u6570\u636e\u5e93\u4e0d\u5b58\u5728");
            }
            if (StringHelper.compare((String)pSDevCenterDBInst.getPSDevCenterId(), (String)this.getWebContext().getCurOrgId(), (boolean)false) != 0) {
                throw new Exception("\u5f53\u524d\u7528\u6237\u8eab\u4efd\u4e0d\u6b63\u786e");
            }
        }
        pSDevCenterDBInst.set("SRFSQL", string3);
        pSDevCenterDBInstService.executeAction("X2G_EXECUTESQL", (IEntity)pSDevCenterDBInst);
        string = DataObject.getStringValue((IDataObject)pSDevCenterDBInst, (String)"SRFSQLERROR", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            this.getWebContext().getCurAjaxActionResult().setExtAttr("sqlerror", (Object)string);
            return;
        }
        object = DataObject.getStringValue((IDataObject)pSDevCenterDBInst, (String)"SRFMODELLIST", null);
        if (!StringHelper.isNullOrEmpty((String)object)) {
            pSDBDevInst = JSONArray.fromString((String)new String(Base64Helper.decode((String)object), "GBK"));
            this.getWebContext().getCurAjaxActionResult().setExtAttr("results", (Object)pSDBDevInst);
            String string4 = DataObject.getStringValue((IDataObject)pSDevCenterDBInst, (String)"SRFCOLUMNS", null);
            if (!StringHelper.isNullOrEmpty((String)string4)) {
                pSDBDevInst = JSONArray.fromString((String)new String(Base64Helper.decode((String)string4), "GBK"));
                this.getWebContext().getCurAjaxActionResult().setExtAttr("columns", (Object)pSDBDevInst);
            }
        }
        int n = DataObject.getIntegerValue((IDataObject)pSDevCenterDBInst, (String)"SRFUPDATECOUNT", (int)-1);
        this.getWebContext().getCurAjaxActionResult().setExtAttr("updatecount", (Object)n);
    }
}

