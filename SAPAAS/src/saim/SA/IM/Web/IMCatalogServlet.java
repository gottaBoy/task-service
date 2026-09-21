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

import SA.IM.Ctrl.IIMCatalogServerInstance;
import SA.IM.Ctrl.IMException;
import SA.IM.Ctrl.IMMessagePackage;
import SA.IM.Ctrl.IMRemoteAction;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAHttpServlet;
import SA.SRFDA.Web.SRFDAHttpServletContext;
import SA.SRFramework.Utility.StringHelper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URLDecoder;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class IMCatalogServlet
extends SRFDAHttpServlet {
    protected IIMCatalogServerInstance imCatalogServerInstance = null;
    private static final Log log = LogFactory.getLog(IMCatalogServlet.class);

    public void init() throws ServletException {
        super.init();
        Object objCatalogServerInstance = this.getServletContext().getAttribute("SAIMCATALOGSERVERKEY");
        if (objCatalogServerInstance == null) {
            throw new ServletException("\u65e0\u6cd5\u83b7\u53d6\u7f16\u76ee\u670d\u52a1\u5668\u5b9e\u4f8b");
        }
        if (!(objCatalogServerInstance instanceof IIMCatalogServerInstance)) {
            throw new ServletException("\u65e0\u6cd5\u83b7\u53d6\u7f16\u76ee\u670d\u52a1\u5668\u5b9e\u4f8b\uff0c\u7c7b\u578b\u4e0d\u6b63\u786e");
        }
        this.imCatalogServerInstance = (IIMCatalogServerInstance)objCatalogServerInstance;
    }

    public void destroy() {
        this.imCatalogServerInstance = null;
        super.destroy();
    }

    protected IIMCatalogServerInstance getCatalogServerInstance() throws ServletException {
        return this.imCatalogServerInstance;
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.addTimeOutHeaders(resp);
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=utf-8");
        SRFDAHttpServletContext servletContext = new SRFDAHttpServletContext(req, resp, this.getServletContext());
        IMMessagePackage imMessagePackage = null;
        try {
            IMRemoteAction imRemoteAction = new IMRemoteAction();
            imRemoteAction.FromWebContext((ISRFDAWebContext)servletContext);
            imMessagePackage = this.getCatalogServerInstance().ProcessRemoteAction(imRemoteAction);
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
            log.error((Object)StringHelper.Format((String)"\u76ee\u5f55\u670d\u52a1\u5668\u5904\u7406\u8fdc\u7aef\u8bf7\u6c42\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
        }
        try {
            resp.getWriter().print(imMessagePackage.toJSONString());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.addTimeOutHeaders(resp);
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=utf-8");
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
                if (strContent.startsWith("content=")) {
                    strContent = strContent.substring(8);
                    strContent = URLDecoder.decode(strContent, "UTF-8");
                }
                log.debug((Object)strContent);
                imRemoteAction.setContent(strContent);
            }
            imMessagePackage = this.getCatalogServerInstance().ProcessRemoteAction(imRemoteAction);
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
            log.error((Object)StringHelper.Format((String)"\u76ee\u5f55\u670d\u52a1\u5668\u5904\u7406\u8fdc\u7aef\u8bf7\u6c42\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
        }
        try {
            resp.getWriter().print(imMessagePackage.toJSONString());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

