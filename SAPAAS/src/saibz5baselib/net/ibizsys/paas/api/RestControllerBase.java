/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.paas.api;

import java.security.Principal;
import javax.servlet.http.HttpServletRequest;
import net.ibizsys.paas.api.IRestCallContext;
import net.ibizsys.paas.api.IRestController;
import net.ibizsys.paas.api.IRestServiceWork;
import net.ibizsys.paas.api.RestCallContext;
import net.ibizsys.paas.api.RestCallResult;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class RestControllerBase
implements IRestController {
    private String strId = null;
    private ThreadLocal<SessionFactory> sessionFactory = new ThreadLocal();
    private static final Log log = LogFactory.getLog(RestControllerBase.class);

    @Override
    public String getId() {
        return this.strId;
    }

    protected void setId(String strId) {
        this.strId = strId;
    }

    @Override
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory.set(sessionFactory);
    }

    @Override
    public SessionFactory getSessionFactory() {
        return this.sessionFactory.get();
    }

    protected String doRestServiceWork(IRestServiceWork iRestServiceWork) {
        return this.doRestServiceWork(iRestServiceWork, null, null);
    }

    protected RestCallResult createRestCallResult() {
        return new RestCallResult();
    }

    protected String doRestServiceWork(IRestServiceWork iRestServiceWork, HttpServletRequest req, Principal principal) {
        long nBeginTime = System.currentTimeMillis();
        RestCallResult callResult = this.createRestCallResult();
        boolean bCreateWebContext = false;
        try {
            if (WebContext.getCurrent() == null) {
                WebContext.setCurrent(this.createRestCallContext(callResult));
                bCreateWebContext = true;
            }
            iRestServiceWork.execute(callResult);
            if (bCreateWebContext) {
                WebContext.setCurrent(null);
            }
        }
        catch (Exception ex) {
            log.error((Object)ex);
            if (bCreateWebContext) {
                WebContext.setCurrent(null);
            }
            RestCallResult.fromException(callResult, ex);
        }
        long nTime = System.currentTimeMillis() - nBeginTime;
        log.debug((Object)StringHelper.format("\u4f5c\u4e1a \u8017\u65f6[%1$s]", nTime));
        return callResult.toJSONObject(null).toString();
    }

    protected IRestCallContext createRestCallContext() throws Exception {
        return this.createRestCallContext(null);
    }

    protected IRestCallContext createRestCallContext(RestCallResult callResult) throws Exception {
        RestCallContext restCallContext = new RestCallContext();
        restCallContext.setRestCallResult(callResult);
        restCallContext.setSessionValue("SRFPERSONID", "SYSTEM");
        restCallContext.setSessionValue("SRFLOGINNAME", "SYSTEM");
        restCallContext.setSessionValue("SRFUSERNAME", "\u7cfb\u7edf\u5185\u7f6e\u7528\u6237");
        return restCallContext;
    }
}

