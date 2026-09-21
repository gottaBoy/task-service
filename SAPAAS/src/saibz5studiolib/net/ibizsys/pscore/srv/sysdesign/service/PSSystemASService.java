/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.Base64Helper
 *  net.ibizsys.paas.util.StringHelper
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
import net.ibizsys.paas.util.Base64Helper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSAppServer;
import net.ibizsys.pscore.srv.paasmgr.service.PSAppServerService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemAS;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemASServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSystemASService
extends PSSystemASServiceBase {
    private static final Log log = LogFactory.getLog(PSSystemASService.class);

    @Override
    protected void onOpenWebConsole(PSSystemAS pSSystemAS) throws Exception {
        if (this.getWebContext() == null || this.getWebContext().getCurAjaxActionResult() == null) {
            throw new Exception("\u5f53\u524d\u8bf7\u6c42\u73af\u5883\u4e0d\u6b63\u786e");
        }
        this.get((IEntity)pSSystemAS);
        if (StringHelper.isNullOrEmpty((String)pSSystemAS.getPSAppServerId())) {
            throw new Exception("\u5e94\u7528\u5bb9\u5668\u4e0d\u652f\u6301WebConsole");
        }
        PSAppServerService pSAppServerService = (PSAppServerService)ServiceGlobal.getService(PSAppServerService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSAppServer pSAppServer = new PSAppServer();
        pSAppServer.setPSAppServerId(pSSystemAS.getPSAppServerId());
        pSAppServerService.get((IEntity)pSAppServer);
        String string = pSAppServer.getWebConsolePath();
        if (StringHelper.isNullOrEmpty((String)string)) {
            if (pSAppServer.getPSSvrServer() == null || StringHelper.isNullOrEmpty((String)pSAppServer.getPSSvrServer().getWebConsolePath())) {
                throw new Exception("\u5e94\u7528\u5bb9\u5668\u4e0d\u652f\u6301WebConsole");
            }
            string = pSAppServer.getPSSvrServer().getWebConsolePath();
        }
        JSONObject jSONObject = new JSONObject();
        int n = 22;
        if (pSAppServer.getSSHPort() != null) {
            n = pSAppServer.getSSHPort();
        }
        jSONObject.put("src_vmaddr", (Object)StringHelper.format((String)"%1$s:%2$s", (Object)pSAppServer.getSSHIPAddr(), (Object)n));
        jSONObject.put("user_name", (Object)pSAppServer.getUserName());
        jSONObject.put("user_pwd", (Object)pSAppServer.getPasswd());
        String string2 = Base64Helper.encodeBytes((byte[])jSONObject.toString().getBytes());
        String string3 = string;
        string3 = StringHelper.format((String)string3, (Object)URLEncoder.encode(string2, "UTF-8"));
        this.getWebContext().getCurAjaxActionResult().setJSCode(StringHelper.format((String)"window.open('%1$s','_blank');", (Object)string3));
    }
}

