package SA.IM.Web;

import SA.IM.Ctrl.IIMMeetingServerInstance;
import SA.IM.Ctrl.IMException;
import SA.IM.Ctrl.IMMessagePackage;
import SA.IM.Ctrl.IMAsyncCometEvent;
import SA.SRFDA.Web.SRFDAHttpServlet;
import SA.SRFramework.Utility.StringHelper;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class IMMeetingCometServlet extends SRFDAHttpServlet {
    private static final Log log = LogFactory.getLog(IMMeetingCometServlet.class);
    private final Map<String, IMAsyncCometEvent> connections = new HashMap<String, IMAsyncCometEvent>();
    protected IIMMeetingServerInstance imMeetingServerInstance = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        final String meetingId = request.getParameter("MEETINGID");
        final String sessionId = request.getParameter("USERSESSIONID");
        final String userId = request.getParameter("USERID");
        if (StringHelper.IsNullOrEmpty(meetingId) || StringHelper.IsNullOrEmpty(sessionId) || StringHelper.IsNullOrEmpty(userId)) {
            return;
        }

        final IIMMeetingServerInstance server = getMeetingServerInstance();
        final String key = meetingId + '\u0000' + userId;
        AsyncContext context = request.startAsync();
        context.setTimeout(15000);
        final IMAsyncCometEvent[] holder = new IMAsyncCometEvent[1];
        IMAsyncCometEvent connection = new IMAsyncCometEvent(context, new Runnable() {
            @Override
            public void run() {
                synchronized (connections) {
                    if (connections.get(key) != holder[0]) {
                        return;
                    }
                    connections.remove(key);
                    try {
                        server.UnregisterUserConnection(meetingId, userId);
                    } catch (Exception ex) {
                        log.error(ex);
                    }
                    log.debug(StringHelper.Format("\u4f1a\u8bae\u53c2\u4e0e\u4ebaComet \u8d85\u65f6[%1$s][%2$s]", meetingId, userId));
                }
            }
        });
        holder[0] = connection;

        synchronized (connections) {
            if (connection.isClosed()) {
                return;
            }
            IMAsyncCometEvent previous = connections.put(key, connection);
            try {
                server.RegisterUserConnection(meetingId, userId, sessionId, connection);
            } catch (Exception ex) {
                restoreConnection(key, connection, previous);
                writeError(response, ex);
                connection.close();
                return;
            }
            if (previous != null) {
                previous.close();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }

    private void restoreConnection(String key, IMAsyncCometEvent connection, IMAsyncCometEvent previous) {
        if (connections.get(key) != connection) {
            return;
        }
        if (previous == null || previous.isClosed()) {
            connections.remove(key);
        } else {
            connections.put(key, previous);
        }
    }

    private void writeError(HttpServletResponse response, Exception ex) {
        IMMessagePackage message = new IMMessagePackage();
        if (ex instanceof IMException) {
            message.setRetCode(((IMException) ex).getErrorCode());
        } else {
            message.setRetCode(1);
        }
        message.setRetInfo(ex.getMessage());
        try {
            response.getWriter().print(message.toJSONString());
        } catch (Exception writeException) {
            log.error(writeException);
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
