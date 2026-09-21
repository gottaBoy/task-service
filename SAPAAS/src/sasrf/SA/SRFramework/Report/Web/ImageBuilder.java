/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.ServletConfig
 *  javax.servlet.ServletException
 *  javax.servlet.ServletOutputStream
 *  javax.servlet.http.HttpServlet
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 */
package SA.SRFramework.Report.Web;

import SA.SRFramework.Report.ChartImage;
import SA.SRFramework.Report.UI.ChartConfig;
import SA.SRFramework.Report.Web.Storage.UserSessionChartConfigMgr;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ImageBuilder
extends HttpServlet {
    private static final String STATE = "state";
    private boolean debugged = false;
    private int requestCount = 0;
    private Byte lock = Byte.valueOf("0");

    public void init(ServletConfig servletCfg) throws ServletException {
        super.init(servletCfg);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String imgKey;
        this.addHeaders(response);
        if (request.getParameter(STATE) != null || !request.getParameterNames().hasMoreElements()) {
            this.requestState(response);
            return;
        }
        Byte by = this.lock;
        synchronized (by) {
            ++this.requestCount;
        }
        int width = 400;
        int height = 400;
        String strMimeStype = "image/png";
        if (request.getParameter("WIDTH") != null) {
            width = Integer.parseInt(request.getParameter("WIDTH"));
        }
        if (request.getParameter("HEIGHT") != null) {
            height = Integer.parseInt(request.getParameter("HEIGHT"));
        }
        if ((imgKey = request.getParameter("IMG_ID")) == null) {
            this.logAndRenderException((Throwable)new ServletException("no 'IMG_ID' parameter provided for Cewolf servlet."), response, width, height);
            return;
        }
        UserSessionChartConfigMgr chartConfigMgr = UserSessionChartConfigMgr.Current(request);
        ChartConfig chartConfig = chartConfigMgr.GetChart(imgKey);
        if (chartConfig == null) {
            this.renderImageExpiry(response, width, height);
            return;
        }
        ChartImage chartImage = chartConfig.getChartImage(width, height, strMimeStype);
        if (chartImage == null) {
            this.renderImageExpiry(response, width, height);
            return;
        }
        try {
            long start = System.currentTimeMillis();
            int size = chartImage.getSize();
            response.setContentType(strMimeStype);
            response.setContentLength(size);
            response.setBufferSize(size);
            response.setStatus(200);
            response.getOutputStream().write(chartImage.getBytes());
            long last = System.currentTimeMillis() - start;
            if (this.debugged) {
                this.log("creation time for chart " + imgKey + ": " + last + "ms.");
            }
        }
        catch (Throwable t) {
            this.logAndRenderException(t, response, width, height);
        }
    }

    private void addHeaders(HttpServletResponse response) {
        response.setDateHeader("Expires", System.currentTimeMillis());
    }

    private void requestState(HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        ((Writer)writer).write("<HTML><BODY>");
        ((Writer)writer).write("<b>Cewolf servlet up and running.</b><br>");
        ((Writer)writer).write("Requests served so far: " + this.requestCount);
        ((Writer)writer).write("</HTML></BODY>");
        ((Writer)writer).close();
    }

    private void logAndRenderException(Throwable ex, HttpServletResponse response, int width, int height) throws IOException {
        this.log(ex.getMessage(), ex);
        response.setContentType("image/jpg");
        ServletOutputStream out = response.getOutputStream();
        out.close();
    }

    private void renderImageExpiry(HttpServletResponse response, int width, int height) throws IOException {
        response.setContentType("image/jpg");
        ServletOutputStream out = response.getOutputStream();
        out.close();
    }
}

