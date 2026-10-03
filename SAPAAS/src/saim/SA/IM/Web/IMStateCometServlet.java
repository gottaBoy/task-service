package SA.IM.Web;

import SA.IM.Ctrl.IIMStateServerInstance;
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

public class IMStateCometServlet extends SRFDAHttpServlet {
    private static final Log log = LogFactory.getLog(IMStateCometServlet.class);
    private final Map<String, IMAsyncCometEvent> connections = new HashMap<String, IMAsyncCometEvent>();
    protected IIMStateServerInstance imStateServerInstance = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        final String sessionId = request.getParameter("USERSESSIONID");
        final String userId = request.getParameter("USERID");
        if (StringHelper.IsNullOrEmpty(sessionId) || StringHelper.IsNullOrEmpty(userId)) {
            return;
        }

        final IIMStateServerInstance server = getStateServerInstance();
        AsyncContext context = request.startAsync();
        context.setTimeout(15000);
        final IMAsyncCometEvent[] holder = new IMAsyncCometEvent[1];
        IMAsyncCometEvent connection = new IMAsyncCometEvent(context, new Runnable() {
            @Override
            public void run() {
                synchronized (connections) {
                    if (connections.get(userId) != holder[0]) {
                        return;
                    }
                    connections.remove(userId);
                    try {
                        server.UnregisterUserConnection(userId, sessionId);
                    } catch (RuntimeException ex) {
                        log.error(ex);
                    }
                    log.debug(StringHelper.Format("Comet Timeout [%1$s][%2$s]", userId, sessionId));
                }
            }
        });
        holder[0] = connection;

        synchronized (connections) {
            if (connection.isClosed()) {
                return;
            }
            IMAsyncCometEvent previous = connections.put(userId, connection);
            try {
                if (!server.RegisterUserConnection(userId, sessionId, connection)) {
                    IMMessagePackage message = new IMMessagePackage();
                    message.setRetCode(10001);
                    writeMessage(response, message);
                    restoreConnection(userId, connection, previous);
                    connection.close();
                    return;
                }
            } catch (Exception ex) {
                restoreConnection(userId, connection, previous);
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

    private void restoreConnection(String userId, IMAsyncCometEvent connection, IMAsyncCometEvent previous) {
        if (connections.get(userId) != connection) {
            return;
        }
        if (previous == null || previous.isClosed()) {
            connections.remove(userId);
        } else {
            connections.put(userId, previous);
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
        writeMessage(response, message);
    }

    private void writeMessage(HttpServletResponse response, IMMessagePackage message) {
        try {
            response.getWriter().print(message.toJSONString());
        } catch (Exception ex) {
            log.error(ex);
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
        Object objStateServerInstance;
        super.init();
        String strServerKey = this.getInitParameter("SERVERKEY");
        if (StringHelper.IsNullOrEmpty((String)strServerKey)) {
            strServerKey = "SAIMSTATESERVERKEY";
        }
        if ((objStateServerInstance = this.getServletContext().getAttribute(strServerKey)) == null) {
            throw new ServletException("\u65e0\u6cd5\u83b7\u53d6\u72b6\u6001\u670d\u52a1\u5668\u5b9e\u4f8b");
        }
        if (!(objStateServerInstance instanceof IIMStateServerInstance)) {
            throw new ServletException("\u65e0\u6cd5\u83b7\u53d6\u72b6\u6001\u670d\u52a1\u5668\u5b9e\u4f8b\uff0c\u7c7b\u578b\u4e0d\u6b63\u786e");
        }
        this.imStateServerInstance = (IIMStateServerInstance)objStateServerInstance;
    }
}
