/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.SRFDAHttpServlet
 *  SA.SRFDA.Web.SRFDAHttpServletContext
 *  SA.SRFramework.Utility.StringHelper
 *  javax.servlet.ServletException
 *  javax.servlet.ServletInputStream
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.IM.Web;

import SA.IM.Ctrl.IIMMeetingServerInstance;
import SA.IM.Ctrl.IMException;
import SA.IM.Ctrl.IMMessagePackage;
import SA.IM.Ctrl.IMRemoteAction;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAHttpServlet;
import SA.SRFDA.Web.SRFDAHttpServletContext;
import SA.SRFramework.Utility.StringHelper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class IMMeetingServlet
extends SRFDAHttpServlet {
    private static final Log log = LogFactory.getLog(IMMeetingServlet.class);
    public static final String PARAM_USERSESSIONID = "USERSESSIONID";
    public static final String PARAM_USERID = "USERID";
    protected IIMMeetingServerInstance imMeetingServerInstance = null;

    protected IIMMeetingServerInstance getMeetingServerInstance() throws ServletException {
        return this.imMeetingServerInstance;
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

    public void destroy() {
        this.imMeetingServerInstance = null;
        super.destroy();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=utf-8");
        this.addTimeOutHeaders(resp);
        SRFDAHttpServletContext servletContext = new SRFDAHttpServletContext(req, resp, this.getServletContext());
        IMMessagePackage imMessagePackage = null;
        try {
            IMRemoteAction imRemoteAction = new IMRemoteAction();
            imRemoteAction.FromWebContext((ISRFDAWebContext)servletContext);
            imMessagePackage = this.getMeetingServerInstance().ProcessRemoteAction(imRemoteAction);
        }
        catch (Exception ex) {
            imMessagePackage = new IMMessagePackage();
            if (ex instanceof IMException) {
                IMException e = (IMException)ex;
                imMessagePackage.setRetCode(e.getErrorCode());
                imMessagePackage.setRetInfo(e.getMessage());
            } else {
                imMessagePackage.setRetCode(1);
                imMessagePackage.setRetInfo(ex.getMessage());
            }
            log.error((Object)StringHelper.Format((String)"\u4f1a\u8bae\u670d\u52a1\u5668\u5904\u7406\u8fdc\u7aef\u8bf7\u6c42\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
        }
        try {
            resp.getWriter().print(imMessagePackage.toJSONString());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=utf-8");
        this.addTimeOutHeaders(resp);
        SRFDAHttpServletContext servletContext = new SRFDAHttpServletContext(req, resp, this.getServletContext());
        IMMessagePackage imMessagePackage = null;
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
            String strContent = new String(orgData, "UTF-8");
            IMRemoteAction imRemoteAction = new IMRemoteAction();
            imRemoteAction.FromWebContext((ISRFDAWebContext)servletContext);
            if (!StringHelper.IsNullOrEmpty((String)strContent)) {
                log.debug((Object)strContent);
                imRemoteAction.setContent(strContent);
            }
            imMessagePackage = this.getMeetingServerInstance().ProcessRemoteAction(imRemoteAction);
        }
        catch (Exception ex) {
            imMessagePackage = new IMMessagePackage();
            if (ex instanceof IMException) {
                IMException e = (IMException)ex;
                imMessagePackage.setRetCode(e.getErrorCode());
                imMessagePackage.setRetInfo(e.getMessage());
            } else {
                imMessagePackage.setRetCode(1);
                imMessagePackage.setRetInfo(ex.getMessage());
            }
            log.error((Object)StringHelper.Format((String)"\u4f1a\u8bae\u670d\u52a1\u5668\u5904\u7406\u8fdc\u7aef\u8bf7\u6c42\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
        }
        try {
            resp.getWriter().print(imMessagePackage.toJSONString());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

