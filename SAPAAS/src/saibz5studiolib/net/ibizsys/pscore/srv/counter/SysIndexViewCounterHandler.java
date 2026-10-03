/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.web.AjaxActionResult
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.paas.web.MDAjaxActionResult
 *  net.ibizsys.paas.web.WebContext
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.counter;

import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.pscore.srv.counter.SysIndexViewCounterHandlerBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.ibizsys.pscore.srv.util.PSSysDevUserUserGlobal;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class SysIndexViewCounterHandler
extends SysIndexViewCounterHandlerBase {
    private static final Log log = LogFactory.getLog(SysIndexViewCounterHandler.class);

    protected AjaxActionResult onFetch() throws Exception {
        MDAjaxActionResult mDAjaxActionResult = new MDAjaxActionResult();
        WebContext.getCurrent().setCurAjaxActionResult((AjaxActionResult)mDAjaxActionResult);
        JSONObject jSONObject = WebContext.getAppData((IWebContext)WebContext.getCurrent());
        if (jSONObject == null) {
            mDAjaxActionResult.setRetCode(5);
            return mDAjaxActionResult;
        }
        String string = jSONObject.optString("psdevslnsysid");
        String string2 = jSONObject.optString("pssystemid");
        String string3 = jSONObject.optString("pssysmodelinstid");
        try {
            PSSysDevUserUserGlobal.getPSSysDevUser(WebContext.getCurrent(), string, string2);
        }
        catch (Exception exception) {
            log.error((Object)exception);
            mDAjaxActionResult.setRetCode(2);
            return mDAjaxActionResult;
        }
        try {
            PSSystemService service = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory(string3));
            PSSystem pSSystem = new PSSystem();
            pSSystem.setPSSystemId(string2);
            service.get(pSSystem);
            mDAjaxActionResult.getData(true).put("MAXENTITYCNT", (Object)DataObject.getIntegerValue((Object)pSSystem.getMaxEntityCnt(), Integer.valueOf(-1)));
            mDAjaxActionResult.getData(true).put("ENTITYCNT", (Object)DataObject.getIntegerValue((Object)pSSystem.getEntityCnt(), (Integer)0));
            mDAjaxActionResult.getData(true).put("TASKCNT", (Object)DataObject.getIntegerValue((Object)pSSystem.getPSSysTasksCnt(), (Integer)0));
            mDAjaxActionResult.getData(true).put("ISSUECNT", (Object)DataObject.getIntegerValue((Object)pSSystem.getPSSysIssuesCnt(), (Integer)0));
            mDAjaxActionResult.getData(true).put("BKTASKCNT", (Object)DataObject.getIntegerValue((Object)pSSystem.getPSSysDevBKTasksCnt(), (Integer)0));
            return mDAjaxActionResult;
        }
        catch (Exception exception) {
            log.error((Object)exception);
            mDAjaxActionResult.setRetCode(1);
            mDAjaxActionResult.setErrorInfo(exception.getMessage());
            return mDAjaxActionResult;
        }
    }
}
