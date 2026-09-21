/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.SRFExHttpServlet
 *  SA.SRFramework.WebEx.SRFExHttpServletContext
 *  javax.servlet.ServletException
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SALicServer.Web;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExHttpServlet;
import SA.SRFramework.WebEx.SRFExHttpServletContext;
import SALicServer.Web.LicManager;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public final class LicAction
extends SRFExHttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Log log = LogFactory.getLog(LicAction.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.addTimeOutHeaders(response);
        SRFExHttpServletContext servletContext = new SRFExHttpServletContext(request, response, this.getServletContext());
        LicManager licManager = (LicManager)servletContext.GetGlobalValue("{33476B9F-96AB-4E6D-9BB6-60525536708E}");
        String strServerName = request.getServerName();
        int nServerPort = request.getServerPort();
        String strServerPath = request.getRequestURI();
        String strSign = StringHelper.Format((String)"%1$s|%2$s|%3$s", (Object)strServerName.toUpperCase(), (Object)nServerPort, (Object)strServerPath);
        String strAction = servletContext.GetParamValue("GAACTION");
        if (StringHelper.Compare((String)strAction, (String)"REGAPP", (boolean)true) == 0) {
            String strAppId = servletContext.GetParamValue("GAAPPPID");
            response.getWriter().print(licManager.RegApp(strSign, strAppId, servletContext.getRemoteAddr()));
            return;
        }
        if (StringHelper.Compare((String)strAction, (String)"UPDATEAPP", (boolean)true) == 0) {
            String strAppId = servletContext.GetParamValue("GAAPPPID");
            String strSessionId = servletContext.GetParamValue("SESSIONID");
            response.getWriter().print(licManager.UpdateApp(strSign, strAppId, strSessionId));
            return;
        }
    }
}

