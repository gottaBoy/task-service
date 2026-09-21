/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.ServletContext
 *  javax.servlet.http.HttpSession
 *  javax.servlet.http.HttpSessionEvent
 *  javax.servlet.http.HttpSessionListener
 */
package SA.SRFramework.WebEx;

import SA.SRFramework.WebEx.ISRFExUserSessionMgr;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SRFExSessionListener
implements HttpSessionListener {
    private static final String TAG_SM1 = "{A72E0CE7-3F75-4b84-BF06-7E91A0182C09}";
    private static final String TAG_SM2 = "{6D72D37E-29B4-42ad-A47F-697320B27611}";
    private static final String TAG_SM3 = "{CD9BA0FC-12CB-414b-8130-1285A2917050}";
    private static final String TAG_SM4 = "{C0E71D58-B43E-4553-AEA1-009A3BD75CC5}";

    public void sessionCreated(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        ServletContext application = session.getServletContext();
    }

    public final void sessionDestroyed(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        ServletContext application = session.getServletContext();
        Object obj = application.getAttribute(TAG_SM1);
        if (obj == null) {
            return;
        }
        if (obj instanceof ISRFExUserSessionMgr) {
            ISRFExUserSessionMgr iUserSessionMgr = (ISRFExUserSessionMgr)obj;
            iUserSessionMgr.RemoveSession(session);
        }
    }
}

