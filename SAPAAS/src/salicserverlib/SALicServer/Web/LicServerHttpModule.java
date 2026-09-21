/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.Base64
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.SRFExWebHttpModule
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 */
package SALicServer.Web;

import SA.SRFramework.Utility.Base64;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExWebHttpModule;
import SALicServer.Web.LicManager;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LicServerHttpModule
extends SRFExWebHttpModule {
    private LicManager licManager = new LicManager();

    protected void OnInit() {
        super.OnInit();
        String path = this.filterConfig.getServletContext().getRealPath("/WEB-INF/server.lic");
        this.licManager.LoadLicenseFile(path);
        this.filterConfig.getServletContext().setAttribute("{33476B9F-96AB-4E6D-9BB6-60525536708E}", (Object)this.licManager);
    }

    protected void OutputLibsVersionInfo() {
        super.OutputLibsVersionInfo();
        try {
            InetAddress localhost = InetAddress.getLocalHost();
            String strTotalSign = StringHelper.Format((String)"%1$s|%2$s", (Object)localhost.getHostName().toUpperCase(), (Object)localhost.getHostAddress().toUpperCase());
            String strTotalSignShow = Base64.encodeBytes((byte[])strTotalSign.getBytes(), (int)2);
            strTotalSignShow = strTotalSignShow.replace("\r", "");
            strTotalSignShow = strTotalSignShow.replace("\n", "");
            System.out.print(StringHelper.Format((String)"\u6388\u6743\u670d\u52a1\u5668\u7279\u5f81\u7801[%1$s]\r\n", (Object)strTotalSignShow));
            System.out.print(StringHelper.Format((String)"\u6388\u6743\u670d\u52a1\u5668\u7248\u672c[3.10.0818]\r\n"));
        }
        catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    protected void DoWithPage(HttpServletRequest arg0, HttpServletResponse arg1) {
        super.DoWithPage(arg0, arg1);
        if (arg0.getSession().getAttribute("PERSONID") == null) {
            String strContextPath;
            String strCurPath = arg0.getRequestURL().toString();
            int nContextPathPos = strCurPath.indexOf(strContextPath = arg0.getContextPath());
            if (nContextPathPos != -1) {
                strCurPath = strCurPath.substring(nContextPathPos + strContextPath.length());
            }
            if (StringHelper.Compare((String)strCurPath, (String)"/licadmin/licserverlogin.jsp", (boolean)false) == 0) {
                return;
            }
            try {
                arg1.sendRedirect("../licadmin/licserverlogin.jsp");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

