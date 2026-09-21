/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.SRFDAHttpServlet
 *  SA.SRFDA.Web.SRFDAHttpServletContext
 *  SA.SRFDA.Web.Utility.GlobalHelperEx
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  javax.servlet.ServletException
 *  javax.servlet.ServletInputStream
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  org.apache.commons.httpclient.HttpClient
 *  org.apache.commons.httpclient.HttpMethod
 *  org.apache.commons.httpclient.methods.PostMethod
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.WT.Web;

import SA.SRFDA.Web.SRFDAHttpServlet;
import SA.SRFDA.Web.SRFDAHttpServletContext;
import SA.SRFDA.Web.Utility.GlobalHelperEx;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.WT.Ctrl.IWTAccountHelper;
import SA.WT.Ctrl.IWTModelStorage;
import SA.WT.Ctrl.WTModelStorageFactory;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class WTServlet
extends SRFDAHttpServlet {
    private static final Log log = LogFactory.getLog(WTServlet.class);
    private IWTAccountHelper iWTAccountHelper = null;

    public void init() throws ServletException {
        super.init();
        try {
            String strWTAccountId = this.getInitParameter("WTACCOUNT");
            GlobalHelperEx globalHelperEx = (GlobalHelperEx)this.getServletContext().getAttribute("SRFDACONTEXTHELPER");
            IWTModelStorage iWTModelStorage = WTModelStorageFactory.Create((ISRFDAGlobalHelper)globalHelperEx);
            this.iWTAccountHelper = iWTModelStorage.FindWTAccount(strWTAccountId);
        }
        catch (Exception ex) {
            throw new ServletException(ex.getMessage());
        }
    }

    public void destroy() {
        super.destroy();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=utf-8");
        this.addTimeOutHeaders(resp);
        SRFDAHttpServletContext servletContext = new SRFDAHttpServletContext(req, resp, this.getServletContext());
        String strSignature = servletContext.GetParamValue("signature");
        String strTimestamp = servletContext.GetParamValue("timestamp");
        String strNonce = servletContext.GetParamValue("nonce");
        String strEchostr = servletContext.GetParamValue("echostr");
        if (!StringHelper.IsNullOrEmpty((String)strEchostr)) {
            resp.getWriter().print(strEchostr);
            return;
        }
        try {
            resp.getWriter().print("");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=utf-8");
        this.addTimeOutHeaders(resp);
        try {
            ServletInputStream in = req.getInputStream();
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            byte[] tmpbuf = new byte[1024];
            int count = 0;
            while ((count = in.read(tmpbuf)) != -1) {
                bout.write(tmpbuf, 0, count);
                tmpbuf = new byte[1024];
            }
            in.close();
            byte[] orgData = bout.toByteArray();
            String strContent = new String(orgData, "UTF8");
            String strRep = this.iWTAccountHelper.ProcessIncomeMessage(strContent);
            log.debug((Object)strRep);
            resp.getWriter().print(strRep);
        }
        catch (Exception e) {
            log.error((Object)e.getMessage(), (Throwable)e);
            resp.getWriter().print("");
        }
    }

    private String PostMessage(String serverUrl, String strParamString, String strPostData) throws Exception {
        String response;
        block12: {
            HttpClient client = null;
            PostMethod postMethod = null;
            response = null;
            try {
                try {
                    client = new HttpClient();
                    client.getParams().setParameter("http.protocol.content-charset", (Object)"utf-8");
                    String[] parts = serverUrl.split("[?]");
                    if (parts.length == 1) {
                        postMethod = new PostMethod(serverUrl);
                        postMethod.setQueryString(strParamString);
                    } else {
                        postMethod = new PostMethod(parts[0]);
                        postMethod.setQueryString(String.valueOf(strParamString) + "&" + parts[1]);
                    }
                    ByteArrayInputStream in = new ByteArrayInputStream(strPostData.getBytes("UTF8"));
                    postMethod.setRequestBody((InputStream)in);
                    int statusCode = client.executeMethod((HttpMethod)postMethod);
                    if (statusCode == 200) {
                        response = postMethod.getResponseBodyAsString();
                        break block12;
                    }
                    log.error((Object)("\u8fdc\u7a0b\u8c03\u7528\u53d1\u751f\u9519\u8bef," + Integer.toString(statusCode)));
                }
                catch (Exception e) {
                    log.error((Object)("\u8fdc\u7a0b\u8c03\u7528\u53d1\u751f\u5f02\u5e38," + e.getMessage()));
                    if (client != null) {
                        client = null;
                    }
                    if (postMethod != null) {
                        postMethod = null;
                    }
                }
            }
            finally {
                if (client != null) {
                    client = null;
                }
                if (postMethod != null) {
                    postMethod = null;
                }
            }
        }
        return response;
    }
}

