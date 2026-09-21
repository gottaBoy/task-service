/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.IM.Ctrl.IIMCometEvent
 *  SA.IM.Ctrl.IIMStateServerInstance
 *  SA.IM.Ctrl.IMException
 *  SA.IM.Ctrl.IMMessagePackage
 *  SA.SRFDA.Web.SRFDAHttpServlet
 *  SA.SRFramework.Utility.StringHelper
 *  javax.servlet.ServletException
 *  org.apache.catalina.comet.CometEvent
 *  org.apache.catalina.comet.CometEvent$EventType
 *  org.apache.catalina.comet.CometProcessor
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.IM.Web;

import SA.IM.Ctrl.IIMCometEvent;
import SA.IM.Ctrl.IIMStateServerInstance;
import SA.IM.Ctrl.IMException;
import SA.IM.Ctrl.IMMessagePackage;
import SA.IM.Ctrl.IMTomcat7CometEvent;
import SA.SRFDA.Web.SRFDAHttpServlet;
import SA.SRFramework.Utility.StringHelper;
import java.io.IOException;
import javax.servlet.ServletException;
import org.apache.catalina.comet.CometEvent;
import org.apache.catalina.comet.CometProcessor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class IMStateCometServlet7
extends SRFDAHttpServlet
implements CometProcessor {
    private static final Log log = LogFactory.getLog(IMStateCometServlet7.class);
    protected IIMStateServerInstance imStateServerInstance = null;

    public void event(CometEvent arg0) throws IOException, ServletException {
        if (arg0.getEventType() == CometEvent.EventType.BEGIN) {
            block14: {
                arg0.getHttpServletResponse().setCharacterEncoding("utf-8");
                arg0.getHttpServletResponse().setContentType("text/html; charset=utf-8");
                String strUserSessionId = arg0.getHttpServletRequest().getParameter("USERSESSIONID");
                if (StringHelper.IsNullOrEmpty((String)strUserSessionId)) {
                    arg0.close();
                    return;
                }
                String strUserId = arg0.getHttpServletRequest().getParameter("USERID");
                if (StringHelper.IsNullOrEmpty((String)strUserId)) {
                    arg0.close();
                    return;
                }
                try {
                    IMTomcat7CometEvent imTomcat6CometEvent = new IMTomcat7CometEvent(arg0);
                    if (this.getStateServerInstance().RegisterUserConnection(strUserId, strUserSessionId, (IIMCometEvent)imTomcat6CometEvent)) break block14;
                    IMMessagePackage imMessagePackage = new IMMessagePackage();
                    imMessagePackage.setRetCode(10001);
                    try {
                        arg0.getHttpServletResponse().getWriter().print(imMessagePackage.toJSONString());
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                    arg0.close();
                    return;
                }
                catch (Exception ex) {
                    IMMessagePackage imMessagePackage = new IMMessagePackage();
                    if (ex instanceof IMException) {
                        IMException e = (IMException)ex;
                        imMessagePackage.setRetCode(e.getErrorCode());
                        imMessagePackage.setRetInfo(e.getMessage());
                    } else {
                        imMessagePackage.setRetCode(1);
                        imMessagePackage.setRetInfo(ex.getMessage());
                    }
                    try {
                        arg0.getHttpServletResponse().getWriter().print(imMessagePackage.toJSONString());
                    }
                    catch (Exception e) {
                        log.error((Object)e);
                    }
                    arg0.close();
                    return;
                }
            }
            return;
        }
        if (arg0.getEventType() == CometEvent.EventType.END || arg0.getEventType() == CometEvent.EventType.ERROR) {
            String strUserSessionId = arg0.getHttpServletRequest().getParameter("USERSESSIONID");
            if (StringHelper.IsNullOrEmpty((String)strUserSessionId)) {
                arg0.close();
                return;
            }
            String strUserId = arg0.getHttpServletRequest().getParameter("USERID");
            if (StringHelper.IsNullOrEmpty((String)strUserId)) {
                arg0.close();
                return;
            }
            this.getStateServerInstance().UnregisterUserConnection(strUserId, strUserSessionId);
            arg0.close();
            log.debug((Object)StringHelper.Format((String)"Comet Timeout [%1$s][%2$s]", (Object)strUserId, (Object)strUserSessionId));
            return;
        }
    }

    protected IIMStateServerInstance getStateServerInstance() throws ServletException {
        return this.imStateServerInstance;
    }

    public void destroy() {
        this.imStateServerInstance = null;
        super.destroy();
    }

    public void init() throws ServletException {
        super.init();
        Object objStateServerInstance = this.getServletContext().getAttribute("SAIMSTATESERVERKEY");
        if (objStateServerInstance == null) {
            throw new ServletException("\u65e0\u6cd5\u83b7\u53d6\u72b6\u6001\u670d\u52a1\u5668\u5b9e\u4f8b");
        }
        if (!(objStateServerInstance instanceof IIMStateServerInstance)) {
            throw new ServletException("\u65e0\u6cd5\u83b7\u53d6\u72b6\u6001\u670d\u52a1\u5668\u5b9e\u4f8b\uff0c\u7c7b\u578b\u4e0d\u6b63\u786e");
        }
        this.imStateServerInstance = (IIMStateServerInstance)objStateServerInstance;
    }
}

