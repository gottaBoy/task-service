/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  javax.servlet.ServletContext
 *  javax.servlet.http.HttpServletRequest
 *  org.apache.axis2.context.MessageContext
 *  org.apache.axis2.context.ServiceContext
 *  org.apache.axis2.transport.http.HTTPConstants
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.SOAResult;
import SA.SRFDA.Ctrl.SOAServiceMgr;
import SA.SRFramework.Utility.StringHelper;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.apache.axis2.context.MessageContext;
import org.apache.axis2.context.ServiceContext;
import org.apache.axis2.transport.http.HTTPConstants;

public class SOAService {
    public SOAResult Call(String strServiceCmd, String strArg, String strOpPersonId) {
        SOAResult soaResult = new SOAResult();
        MessageContext messageContext = MessageContext.getCurrentMessageContext();
        ServiceContext serviceContext = messageContext.getServiceContext();
        ServletContext servletContext = (ServletContext)serviceContext.getProperty(HTTPConstants.MC_HTTP_SERVLETCONTEXT);
        HttpServletRequest request = (HttpServletRequest)messageContext.getProperty(HTTPConstants.MC_HTTP_SERVLETREQUEST);
        Object obj = servletContext.getAttribute("SRFDASOASERVICEMGR");
        if (obj == null) {
            soaResult.setErrorCode(1);
            soaResult.setErrorInfo("\u65e0\u6cd5\u83b7\u53d6SOA\u670d\u52a1\u7ba1\u7406\u5bf9\u8c61");
            return soaResult;
        }
        SOAServiceMgr soaServiceMgr = null;
        if (obj instanceof SOAServiceMgr) {
            soaServiceMgr = (SOAServiceMgr)obj;
        }
        if (soaServiceMgr == null) {
            soaResult.setErrorCode(1);
            soaResult.setErrorInfo("SOA\u670d\u52a1\u7ba1\u7406\u5bf9\u8c61\u7c7b\u578b\u4e0d\u6b63\u786e");
            return soaResult;
        }
        if (!soaServiceMgr.isContainsService(strServiceCmd)) {
            soaResult.setErrorCode(1);
            soaResult.setErrorInfo(StringHelper.Format((String)"SOA\u670d\u52a1\u7ba1\u7406\u5bf9\u8c61\u4e0d\u63d0\u4f9b\u6240\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)strServiceCmd));
            return soaResult;
        }
        if (!soaServiceMgr.CheckClientAddress(strServiceCmd, request.getRemoteAddr())) {
            soaResult.setErrorCode(1);
            soaResult.setErrorInfo(StringHelper.Format((String)"\u8bbf\u95ee\u5730\u5740[%2$s]\u4e0d\u88ab\u5141\u8bb8\u8bbf\u95ee\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)strServiceCmd, (Object)request.getRemoteAddr()));
            return soaResult;
        }
        return soaResult;
    }
}

