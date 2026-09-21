/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.SRFDAHttpServlet
 *  SA.SRFDA.Web.SRFDAHttpServletContext
 *  SA.SRFDA.Web.Utility.GlobalHelperEx
 *  SA.SRFramework.DataEx.BaseDataEntity
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

import SA.SRFDA.PS.Core.DevCenter.IPSDevCenterRuntime;
import SA.SRFDA.PS.Core.IPSModelStorage;
import SA.SRFDA.PS.Core.JIT.Web.PSJITWebContext;
import SA.SRFDA.PS.Core.PSObjectFactory;
import SA.SRFDA.PS.Web.RemoteCallResult;
import SA.SRFDA.Web.SRFDAHttpServlet;
import SA.SRFDA.Web.SRFDAHttpServletContext;
import SA.SRFDA.Web.Utility.GlobalHelperEx;
import SA.SRFramework.DataEx.BaseDataEntity;
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

public class DevCenterApi
extends SRFDAHttpServlet {
    private static final Log log = LogFactory.getLog(DevCenterApi.class);
    private IPSModelStorage iPSModelStorage = null;
    public static final String CUSTOMCALL_USERLOGIN = "USERLOGIN";
    public static final String CUSTOMCALL_USERLOGOUT = "USERLOGOUT";
    public static final String CUSTOMCALL_USERACTIVE = "USERACTIVE";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    protected IPSModelStorage getPSModelStorage() throws Exception {
        if (this.iPSModelStorage == null) {
            this.iPSModelStorage = PSObjectFactory.getPSModelStorage(GlobalHelperEx.getInstance());
        }
        return this.iPSModelStorage;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String strArg2;
        if (PSJITWebContext.getInstance() != null) {
            PSJITWebContext.setCurrent(null);
        }
        this.addTimeOutHeaders(response);
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        SRFDAHttpServletContext servletContext = new SRFDAHttpServletContext(request, response, this.getServletContext());
        HashMap<String, String> postValueMap = new HashMap<String, String>();
        try {
            this.parsePost(request, postValueMap);
        }
        catch (Exception e) {
            log.error((Object)e.getMessage(), (Throwable)e);
        }
        String strCall = servletContext.GetParamValue("SRFCALL");
        String strActionMode = servletContext.GetPostValue("srfarg");
        if (StringHelper.isNullOrEmpty((String)strActionMode)) {
            strActionMode = postValueMap.get("srfarg");
        }
        if (StringHelper.isNullOrEmpty((String)(strArg2 = servletContext.GetPostValue("srfarg2")))) {
            strArg2 = postValueMap.get("srfarg2");
        }
        BaseDataEntity dataEntity = BaseDataEntity.FromJSONString((String)strArg2);
        RemoteCallResult remoteCallResult = null;
        try {
            remoteCallResult = new RemoteCallResult();
            String strPSDevCenterId = dataEntity.getParamStringValue("PSDEVCENTERID", "");
            if (StringHelper.isNullOrEmpty((String)strPSDevCenterId)) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5e94\u7528\u4e2d\u5fc3\u7f16\u53f7");
            }
            String strPSDevUserId = dataEntity.getParamStringValue("PSDEVUSERID", "");
            String strSessionId = dataEntity.getParamStringValue("SESSIONID", "");
            String strRemoteAddr = dataEntity.getParamStringValue("REMOTEADDR", "");
            IPSDevCenterRuntime iPSDevCenterRuntime = (IPSDevCenterRuntime)this.getPSModelStorage().getPSDevCenter(strPSDevCenterId);
            if (StringHelper.compare((String)strActionMode, (String)CUSTOMCALL_USERLOGIN, (boolean)true) == 0) {
                iPSDevCenterRuntime.loginUser(strPSDevUserId, strSessionId, strRemoteAddr);
            } else if (StringHelper.compare((String)strActionMode, (String)CUSTOMCALL_USERLOGOUT, (boolean)true) == 0) {
                iPSDevCenterRuntime.logoutUser(strPSDevUserId, strSessionId, strRemoteAddr);
            } else if (StringHelper.compare((String)strActionMode, (String)CUSTOMCALL_USERACTIVE, (boolean)true) == 0) {
                String strInfo = dataEntity.getParamStringValue("INFO", "");
                String strUserData = dataEntity.getParamStringValue("USERDATA", "");
                iPSDevCenterRuntime.activeUser(strPSDevUserId, strSessionId, strRemoteAddr, strInfo, strUserData);
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
        this.addTimeOutHeaders(response);
        SRFDAHttpServletContext servletContext = new SRFDAHttpServletContext(request, response, this.getServletContext());
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
                try (Scanner br = null;){
                    try {
                        br = new Scanner((InputStream)is);
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

