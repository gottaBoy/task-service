/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.WebContext
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.sysdesign.service;

import java.net.URLEncoder;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemDBCfg;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemDBCfgServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSystemDBCfgService
extends PSSystemDBCfgServiceBase {
    private static final Log log = LogFactory.getLog(PSSystemDBCfgService.class);

    @Override
    protected void onOpenDBTool(PSSystemDBCfg pSSystemDBCfg) throws Exception {
        if (this.getWebContext() == null || this.getWebContext().getCurAjaxActionResult() == null) {
            throw new Exception("\u5f53\u524d\u8bf7\u6c42\u73af\u5883\u4e0d\u6b63\u786e");
        }
        this.get((IEntity)pSSystemDBCfg);
        if (StringHelper.isNullOrEmpty((String)pSSystemDBCfg.getPSDBDevInstId())) {
            throw new Exception("\u6570\u636e\u5e93\u5b9e\u4f8b\u4e0d\u652f\u6301Web\u7ba1\u7406");
        }
        PSSystem pSSystem = pSSystemDBCfg.getPSSystem();
        String string = pSSystem.getPSDevSlnSysId();
        string = !StringHelper.isNullOrEmpty((String)string) ? StringHelper.format((String)"PSSYSDEVSLNID=%1$s", (Object)URLEncoder.encode(pSSystem.getPSDevSlnSysId(), "UTF-8")) : StringHelper.format((String)"PSSYSTEMID=%1$s", (Object)URLEncoder.encode(pSSystem.getPSSystemId(), "UTF-8"));
        this.getWebContext().getCurAjaxActionResult().setJSCode(StringHelper.format((String)"window.open('dcdbtoolview.jsp?SYSTEMDBCFG=1&%1$s&SRFKEYS=%2$s','_blank');", (Object)string, (Object)URLEncoder.encode(pSSystemDBCfg.getPSSystemDBCfgId(), "UTF-8")));
    }

    @Override
    protected void onOpenJITDBTool(PSSystemDBCfg pSSystemDBCfg) throws Exception {
        if (this.getWebContext() == null || this.getWebContext().getCurAjaxActionResult() == null) {
            throw new Exception("\u5f53\u524d\u8bf7\u6c42\u73af\u5883\u4e0d\u6b63\u786e");
        }
        JSONObject jSONObject = WebContext.getAppData();
        if (jSONObject == null) {
            throw new Exception("\u5f53\u524d\u8bf7\u6c42\u73af\u5883\u4e0d\u6b63\u786e");
        }
        String string = jSONObject.optString("pssystemid");
        PSSystemService pSSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)this.getSessionFactory());
        PSSystem pSSystem = new PSSystem();
        pSSystem.setPSSystemId(string);
        pSSystemService.get((IEntity)pSSystem);
        String string2 = pSSystem.getPSDevSlnSysId();
        if (StringHelper.isNullOrEmpty((String)string2)) {
            throw new Exception("\u5f53\u524d\u6ca1\u6709\u6307\u5b9aJIT\u6570\u636e\u6e90");
        }
        PSDevSlnSysService pSDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDevSlnSys pSDevSlnSys = new PSDevSlnSys();
        pSDevSlnSys.setPSDevSlnSysId(string2);
        pSDevSlnSysService.get((IEntity)pSDevSlnSys);
        if (StringHelper.isNullOrEmpty((String)pSDevSlnSys.getJITPSDBDevInstId())) {
            throw new Exception("\u5f53\u524d\u6ca1\u6709\u6307\u5b9aJIT\u6570\u636e\u6e90");
        }
        string2 = StringHelper.format((String)"PSSYSDEVSLNID=%1$s", (Object)URLEncoder.encode(pSSystem.getPSDevSlnSysId(), "UTF-8"));
        this.getWebContext().getCurAjaxActionResult().setJSCode(StringHelper.format((String)"window.open('dcdbtoolview.jsp?JITDBINST=1&%1$s','_blank');", (Object)string2));
    }
}

