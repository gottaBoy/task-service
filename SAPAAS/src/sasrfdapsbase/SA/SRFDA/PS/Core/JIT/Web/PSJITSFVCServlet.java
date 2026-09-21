/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  javax.servlet.ServletConfig
 *  javax.servlet.ServletException
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.paas.web.WebContext
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.JIT.Web;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.JIT.Controller.IPSJITViewController;
import SA.SRFDA.PS.Core.JIT.Web.PSJITHttpServlet;
import SA.SRFramework.Utility.StringHelper;
import java.io.IOException;
import java.util.Iterator;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSJITSFVCServlet
extends PSJITHttpServlet {
    private String strPSSFId = "";
    private static final Log log = LogFactory.getLog(PSJITSFVCServlet.class);

    public void init(ServletConfig config) throws ServletException {
        this.strPSSFId = config.getInitParameter("SFID");
        super.init(config);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.addTimeOutHeaders(response);
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=UTF-8");
        try {
            IWebContext iWebContext = this.createWebContext(request, response);
            WebContext.setCurrent((IWebContext)iWebContext);
            String strCurPath = request.getRequestURL().toString();
            String strContextPath = request.getContextPath();
            int nContextPathPos = strCurPath.indexOf(strContextPath);
            if (nContextPathPos != -1) {
                strCurPath = strCurPath.substring(nContextPathPos + strContextPath.length());
            }
            String strFolder = StringHelper.Format((String)"/sapsjitsrv/", (Object)this.getPSJITWebContext().getPSApplication().getPSPF().getId().toLowerCase());
            strCurPath = strCurPath.replace(strFolder, "");
            String[] parts = strCurPath.split("[/]");
            String strModuleName = parts[0];
            String strViewName = parts[1].split("[?]")[0];
            strViewName = strViewName.split("[.]")[0];
            IPSAppView iPSAppView2 = null;
            Iterator<IPSAppView> psAppViews = this.getPSJITWebContext().getPSApplication().getAllPSAppViews();
            while (psAppViews.hasNext()) {
                IPSAppView iPSAppView = psAppViews.next();
                if (StringHelper.Compare((String)strViewName, (String)iPSAppView.getCodeName(), (boolean)false) != 0 || StringHelper.Compare((String)iPSAppView.getPSAppModule().getCodeName(), (String)strModuleName, (boolean)false) != 0) continue;
                iPSAppView2 = iPSAppView;
                break;
            }
            if (iPSAppView2 != null) {
                IPSJITViewController iPSJITViewController = this.getPSJITWebContext().getAppModel().getViewController(iPSAppView2);
                iPSJITViewController.process(request, response);
                return;
            }
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u89c6\u56fe");
        }
        catch (Exception ex) {
            throw new ServletException((Throwable)ex);
        }
    }
}

