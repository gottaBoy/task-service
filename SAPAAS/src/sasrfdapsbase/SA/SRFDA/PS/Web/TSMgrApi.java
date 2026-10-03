/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.SRFDAHttpServlet
 *  SA.SRFDA.Web.SRFDAHttpServletContext
 *  SA.SRFDA.Web.Utility.GlobalHelperEx
 *  javax.servlet.ServletConfig
 *  javax.servlet.ServletException
 *  javax.servlet.ServletInputStream
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Web;

import SA.SRFDA.PS.Core.IPSModelStorage;
import SA.SRFDA.PS.Core.JIT.Web.PSJITWebContext;
import SA.SRFDA.PS.Core.PSObjectFactory;
import SA.SRFDA.PS.Web.RemoteCallResult;
import SA.SRFDA.Web.SRFDAHttpServlet;
import SA.SRFDA.Web.SRFDAHttpServletContext;
import SA.SRFDA.Web.Utility.GlobalHelperEx;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Scanner;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TSMgrApi
extends SRFDAHttpServlet {
    private static final Log log = LogFactory.getLog(TSMgrApi.class);
    private IPSModelStorage iPSModelStorage = null;
    public static final String CUSTOMCALL_GETCURRENTINFO = "GETCURRENTINFO";
    private HashMap<String, String> allowAddrMap = null;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        String strAllowAddrs = config.getInitParameter("ALLOWADDRS");
        if (!StringHelper.isNullOrEmpty((String)strAllowAddrs)) {
            String[] list;
            this.allowAddrMap = new HashMap();
            String[] stringArray = list = strAllowAddrs.split("[;]");
            int n = list.length;
            int n2 = 0;
            while (n2 < n) {
                String strAddr = stringArray[n2];
                this.allowAddrMap.put(strAddr, "");
                ++n2;
            }
        }
    }

    protected IPSModelStorage getPSModelStorage() throws Exception {
        if (this.iPSModelStorage == null) {
            this.iPSModelStorage = PSObjectFactory.getPSModelStorage(GlobalHelperEx.getInstance());
        }
        return this.iPSModelStorage;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (PSJITWebContext.getInstance() != null) {
            PSJITWebContext.setCurrent(null);
        }
        this.addTimeOutHeaders(response);
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        SRFDAHttpServletContext servletContext = new SRFDAHttpServletContext(request, response, this.getServletContext());
        RemoteCallResult remoteCallResult = new RemoteCallResult();
        if (this.allowAddrMap != null && !this.allowAddrMap.containsKey(servletContext.getRemoteAddr())) {
            remoteCallResult.setRetCode(2);
            response.getWriter().write(remoteCallResult.ToJSONString());
            return;
        }
        HashMap<String, String> postValueMap = new HashMap<String, String>();
        try {
            this.parsePost(request, postValueMap);
        }
        catch (Exception e) {
            log.error((Object)e.getMessage(), (Throwable)e);
        }
        String strCall = servletContext.GetPostValue("srfaction");
        if (StringHelper.isNullOrEmpty((String)strCall)) {
            strCall = postValueMap.get("srfaction");
        }
        try {
            if (StringHelper.compare((String)strCall, (String)CUSTOMCALL_GETCURRENTINFO, (boolean)true) == 0) {
                this.getPSModelStorage().getPSSysDevBKTaskGlobal().fillCurrentInfoResult(remoteCallResult);
            }
        }
        catch (Exception ex) {
            remoteCallResult = new RemoteCallResult();
            remoteCallResult.setRetCode(1);
            remoteCallResult.setErrorInfo(ex.getMessage());
        }
        response.getWriter().write(remoteCallResult.ToJSONString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void parsePost(HttpServletRequest request, HashMap<String, String> postValueMap) throws Exception {
        block14: {
            if (StringHelper.compare((String)request.getMethod(), (String)"POST", (boolean)true) != 0) {
                return;
            }
            if (request.getContentType() == null || request.getContentType().indexOf("application/x-www-form-urlencoded") != 0) {
                return;
            }
            ServletInputStream is = request.getInputStream();
            if (is != null) {
                try (Scanner br = new Scanner((InputStream)is)) {
                    try {
                        StringBuilderEx sb = new StringBuilderEx();
                        while (br.hasNextLine()) {
                            String tempStream = br.nextLine();
                            if (tempStream.trim() == null || tempStream.trim().equals("")) continue;
                            sb.append(tempStream);
                        }
                        String strFormValues = sb.toString();
                        if (StringHelper.isNullOrEmpty((String)strFormValues)) break block14;
                        String[] strLists = strFormValues.split("&");
                        int i = 0;
                        while (i < strLists.length) {
                            String[] set = strLists[i].split("=");
                            if (set.length == 2) {
                                try {
                                    String strValue = URLDecoder.decode(set[1], request.getCharacterEncoding());
                                    if (StringHelper.length((String)strValue) != 0) {
                                        postValueMap.put(set[0], strValue);
                                    }
                                }
                                catch (Exception ex) {
                                    ex.printStackTrace();
                                }
                            }
                            ++i;
                        }
                    }
                    catch (Exception exception) {
                        br.close();
                    }
                }
            }
        }
    }
}

