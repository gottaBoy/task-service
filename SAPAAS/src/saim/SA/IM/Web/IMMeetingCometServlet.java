/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.SRFDAHttpServlet
 *  SA.SRFramework.Utility.StringHelper
 *  javax.servlet.ServletException
 *  org.apache.catalina.CometEvent
 *  org.apache.catalina.CometEvent$EventType
 *  org.apache.catalina.CometProcessor
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.IM.Web;

import SA.IM.Ctrl.IIMMeetingServerInstance;
import SA.IM.Ctrl.IMException;
import SA.IM.Ctrl.IMMessagePackage;
import SA.IM.Ctrl.IMTomcat6CometEvent;
import SA.SRFDA.Web.SRFDAHttpServlet;
import SA.SRFramework.Utility.StringHelper;
import java.io.IOException;
import javax.servlet.ServletException;
import org.apache.catalina.CometEvent;
import org.apache.catalina.CometProcessor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class IMMeetingCometServlet
extends SRFDAHttpServlet
implements CometProcessor {
    private static final Log log = LogFactory.getLog(IMMeetingCometServlet.class);
    protected IIMMeetingServerInstance imMeetingServerInstance = null;

    public void event(CometEvent arg0) throws IOException, ServletException {
        if (arg0.getEventType() == CometEvent.EventType.BEGIN) {
            arg0.setTimeout(15000);
            arg0.getHttpServletResponse().setCharacterEncoding("utf-8");
            arg0.getHttpServletResponse().setContentType("text/html; charset=utf-8");
            String strMeetingId = arg0.getHttpServletRequest().getParameter("MEETINGID");
            if (StringHelper.IsNullOrEmpty((String)strMeetingId)) {
                arg0.close();
                return;
            }
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
                IMTomcat6CometEvent imTomcat6CometEvent = new IMTomcat6CometEvent(arg0);
                this.getMeetingServerInstance().RegisterUserConnection(strMeetingId, strUserId, strUserSessionId, imTomcat6CometEvent);
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
            return;
        }
        if (arg0.getEventType() == CometEvent.EventType.END || arg0.getEventType() == CometEvent.EventType.ERROR) {
            String strMeetingId = arg0.getHttpServletRequest().getParameter("MEETINGID");
            if (StringHelper.IsNullOrEmpty((String)strMeetingId)) {
                arg0.close();
                return;
            }
            String strUserId = arg0.getHttpServletRequest().getParameter("USERID");
            if (StringHelper.IsNullOrEmpty((String)strUserId)) {
                arg0.close();
                return;
            }
            try {
                log.debug((Object)StringHelper.Format((String)"\u4f1a\u8bae\u53c2\u4e0e\u4ebaComet \u8d85\u65f6[%1$s][%2$s]", (Object)strMeetingId, (Object)strUserId));
                this.getMeetingServerInstance().UnregisterUserConnection(strMeetingId, strUserId);
                arg0.getHttpServletResponse().getWriter().flush();
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
            arg0.close();
            return;
        }
    }

    protected IIMMeetingServerInstance getMeetingServerInstance() throws ServletException {
        return this.imMeetingServerInstance;
    }

    public void destroy() {
        this.imMeetingServerInstance = null;
        super.destroy();
    }

    public void init() throws ServletException {
        Object objMeetingServerInstance;
        super.init();
        String strServerKey = this.getInitParameter("SERVERKEY");
        if (StringHelper.IsNullOrEmpty((String)strServerKey)) {
            strServerKey = "SAIMMEETINGSERVERKEY";
        }
        if ((objMeetingServerInstance = this.getServletContext().getAttribute(strServerKey)) == null) {
            throw new ServletException("\u65e0\u6cd5\u83b7\u53d6\u4f1a\u8bae\u670d\u52a1\u5668\u5b9e\u4f8b");
        }
        if (!(objMeetingServerInstance instanceof IIMMeetingServerInstance)) {
            throw new ServletException("\u65e0\u6cd5\u83b7\u53d6\u4f1a\u8bae\u670d\u52a1\u5668\u5b9e\u4f8b\uff0c\u7c7b\u578b\u4e0d\u6b63\u786e");
        }
        this.imMeetingServerInstance = (IIMMeetingServerInstance)objMeetingServerInstance;
    }
}

