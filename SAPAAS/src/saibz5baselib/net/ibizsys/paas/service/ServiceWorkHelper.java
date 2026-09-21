/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.service;

import net.ibizsys.paas.service.ActionSessionManager;
import net.ibizsys.paas.service.CloneSessionManager;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.paas.web.util.SimpleWebContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ServiceWorkHelper {
    private static final Log log = LogFactory.getLog(ServiceWorkHelper.class);
    private static IWebContext simpleWebContext = null;
    private IWebContext iWebContext = null;

    static {
        SimpleWebContext webContext = new SimpleWebContext();
        webContext.setSessionValue("SRFPERSONID", "SYSTEM");
        webContext.setSessionValue("SRFLOGINNAME", "SYSTEM");
        webContext.setSessionValue("SRFUSERNAME", "\u7cfb\u7edf\u5185\u7f6e\u7528\u6237");
        simpleWebContext = webContext;
    }

    public static void setWebContext(IWebContext iWebContext) {
        simpleWebContext = iWebContext;
    }

    public static IWebContext getWebContext() {
        return simpleWebContext;
    }

    public ServiceWorkHelper(IWebContext iWebContext) {
        this.iWebContext = iWebContext;
    }

    public ServiceWorkHelper() {
    }

    public static ServiceWorkHelper getInstance(IWebContext iWebContext) {
        return new ServiceWorkHelper(iWebContext);
    }

    public static ServiceWorkHelper getInstance() {
        return new ServiceWorkHelper();
    }

    public void execute(IServiceWork iServiceWork) throws Exception {
        boolean bOpenCloneSession;
        boolean bOpenActionSession;
        boolean bl = bOpenActionSession = ActionSessionManager.getCurrentSession() == null;
        if (bOpenActionSession) {
            ActionSessionManager.openSession().setName("SERVICEWORKHELPER");
        }
        boolean bl2 = bOpenCloneSession = CloneSessionManager.getCurrentSession() == null;
        if (bOpenCloneSession) {
            CloneSessionManager.openSession().setOwner("SERVICEWORKHELPER");
        }
        boolean bCreateWebContext = false;
        int nLastRef = 0;
        try {
            nLastRef = SessionFactoryManager.addRef();
            if (WebContext.getCurrent() == null) {
                if (this.iWebContext != null) {
                    WebContext.setCurrent(this.iWebContext);
                } else {
                    WebContext.setCurrent(ServiceWorkHelper.getWebContext());
                }
                bCreateWebContext = true;
            }
            iServiceWork.execute(null);
            if (bCreateWebContext) {
                WebContext.setCurrent(null);
            }
            if (nLastRef != SessionFactoryManager.releaseRef(true) + 1) {
                log.warn((Object)StringHelper.format("\u5b9e\u4f53\u670d\u52a1[%1$s]\u4f1a\u8bdd\u5de5\u5382\u5f15\u7528\u8ba1\u6570\u6267\u884c\u524d\u540e\u4e0d\u4e00\u81f4\uff0c\u53ef\u80fd\u5b58\u5728\u6570\u636e\u9501\u95ee\u9898", "SERVICEWORKHELPER"));
            }
            if (bOpenActionSession) {
                ActionSessionManager.closeSession();
            }
            if (bOpenCloneSession) {
                CloneSessionManager.closeSession();
            }
        }
        catch (Exception ex) {
            if (bCreateWebContext) {
                WebContext.setCurrent(null);
            }
            if (nLastRef != SessionFactoryManager.releaseRef(false) + 1) {
                log.warn((Object)StringHelper.format("\u5b9e\u4f53\u670d\u52a1[%1$s]\u4f1a\u8bdd\u5de5\u5382\u5f15\u7528\u8ba1\u6570\u6267\u884c\u524d\u540e\u4e0d\u4e00\u81f4\uff0c\u53ef\u80fd\u5b58\u5728\u6570\u636e\u9501\u95ee\u9898", "SERVICEWORKHELPER"));
            }
            if (bOpenActionSession) {
                ActionSessionManager.closeSession();
            }
            if (bOpenCloneSession) {
                CloneSessionManager.closeSession();
            }
            throw ex;
        }
    }
}

