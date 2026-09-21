/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.SRFDAHttpServlet
 *  SA.SRFDA.Web.SRFDAHttpServletContext
 *  SA.SRFramework.Utility.StringHelper
 *  javax.servlet.ServletException
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Web;

import SA.SRFDA.PS.Core.JIT.Web.PSJITWebContext;
import SA.SRFDA.Web.SRFDAHttpServlet;
import SA.SRFDA.Web.SRFDAHttpServletContext;
import SA.SRFramework.Utility.StringHelper;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SystemModelLogServlet
extends SRFDAHttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Log log = LogFactory.getLog(SystemModelLogServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String strSystemLogFilePath;
        File file;
        if (PSJITWebContext.getInstance() != null) {
            PSJITWebContext.setCurrent(null);
        }
        this.addTimeOutHeaders(response);
        SRFDAHttpServletContext servletContext = new SRFDAHttpServletContext(request, response, this.getServletContext());
        String strPSDevSlnSysId = servletContext.GetParamValue("PSDEVSLNSYSID");
        String strPSSystemId = servletContext.GetParamValue("PSSYSID");
        String strUserId = request.getHeader("X-SRFUSERID");
        String strLoginName = request.getHeader("X-SRFLOGINNAME");
        String strId = "";
        if (!StringHelper.IsNullOrEmpty((String)strPSDevSlnSysId)) {
            String strUserName = request.getHeader("X-SRFUSERNAME");
            if (StringHelper.IsNullOrEmpty((String)strUserId)) {
                throw new ServletException("\u6ca1\u6709\u6307\u5b9a\u5f53\u524d\u7528\u6237\u8eab\u4efd");
            }
            strId = strPSDevSlnSysId;
        } else if (!StringHelper.IsNullOrEmpty((String)strPSSystemId)) {
            if (StringHelper.IsNullOrEmpty((String)servletContext.getCurUserId())) {
                throw new ServletException("\u6ca1\u6709\u6307\u5b9a\u5f53\u524d\u7528\u6237\u8eab\u4efd");
            }
            strId = strPSSystemId;
        } else {
            throw new ServletException("\u8bf7\u6c42\u53c2\u6570\u65e0\u6548");
        }
        String strCodeFolder = servletContext.getWebExConfig().GetValue("SRFPS", "CODEFOLDER", null);
        if (!StringHelper.IsNullOrEmpty((String)strCodeFolder) && (file = new File(strSystemLogFilePath = StringHelper.Format((String)"%2$s/active.log", (Object)new Date(), (Object)(strCodeFolder = StringHelper.Format((String)"%1$s/_SYSLOG/%2$s", (Object)strCodeFolder, (Object)strId))))).exists()) {
            SystemModelLogServlet.sendBackFile(strSystemLogFilePath, request, response);
        }
    }

    protected static boolean sendBackFile(String strReportFile, HttpServletRequest request, HttpServletResponse response) {
        boolean bRet = true;
        try {
            response.setContentType("text/plain");
            BufferedInputStream bis = null;
            FilterOutputStream bos = null;
            try {
                try {
                    int bytesRead;
                    bis = new BufferedInputStream(new FileInputStream(strReportFile));
                    bos = new BufferedOutputStream((OutputStream)response.getOutputStream());
                    byte[] buff = new byte[2048];
                    while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                        ((BufferedOutputStream)bos).write(buff, 0, bytesRead);
                    }
                }
                catch (IOException e) {
                    bRet = false;
                    log.error((Object)e);
                    if (bis != null) {
                        bis.close();
                    }
                    if (bos != null) {
                        bos.close();
                    }
                }
            }
            finally {
                if (bis != null) {
                    bis.close();
                }
                if (bos != null) {
                    bos.close();
                }
            }
        }
        catch (Exception ex) {
            bRet = false;
            ex.printStackTrace();
        }
        return bRet;
    }
}

