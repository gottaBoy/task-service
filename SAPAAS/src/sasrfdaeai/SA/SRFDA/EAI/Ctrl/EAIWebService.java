/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  javax.servlet.ServletContext
 *  org.apache.axiom.om.OMAbstractFactory
 *  org.apache.axiom.om.OMElement
 *  org.apache.axiom.om.OMFactory
 *  org.apache.axiom.om.OMNamespace
 *  org.apache.axiom.om.OMNode
 *  org.apache.axiom.om.impl.builder.StAXOMBuilder
 *  org.apache.axiom.om.impl.llom.factory.OMXMLBuilderFactory
 *  org.apache.axis2.context.MessageContext
 *  org.apache.axis2.context.ServiceContext
 *  org.apache.axis2.databinding.utils.BeanUtil
 *  org.apache.axis2.engine.DefaultObjectSupplier
 *  org.apache.axis2.engine.ObjectSupplier
 *  org.apache.axis2.transport.http.HTTPConstants
 *  org.apache.axis2.util.StreamWrapper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.EAI.Ctrl;

import SA.SRFDA.EAI.Api.EAIParam;
import SA.SRFDA.EAI.Ctrl.EAIServiceMgr;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Iterator;
import javax.servlet.ServletContext;
import javax.xml.stream.XMLStreamReader;
import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axiom.om.OMNode;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;
import org.apache.axiom.om.impl.llom.factory.OMXMLBuilderFactory;
import org.apache.axis2.context.MessageContext;
import org.apache.axis2.context.ServiceContext;
import org.apache.axis2.databinding.utils.BeanUtil;
import org.apache.axis2.engine.DefaultObjectSupplier;
import org.apache.axis2.engine.ObjectSupplier;
import org.apache.axis2.transport.http.HTTPConstants;
import org.apache.axis2.util.StreamWrapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class EAIWebService {
    private static Log log = LogFactory.getLog(EAIWebService.class);

    public OMElement startservice(OMElement in) {
        CallResult callResult = new CallResult();
        EAIParam eaiParam = EAIWebService.GetEAIParam(in);
        MessageContext messageContext = MessageContext.getCurrentMessageContext();
        ServiceContext serviceContext = messageContext.getServiceContext();
        ServletContext servletContext = (ServletContext)serviceContext.getProperty(HTTPConstants.MC_HTTP_SERVLETCONTEXT);
        Object objService = servletContext.getAttribute("{753F59D7-C01F-4b0a-A0C9-2EAD77744308}");
        if (objService == null || !(objService instanceof EAIServiceMgr)) {
            callResult.setRetCode(1);
            callResult.setErrorInfo("\u96c6\u6210\u670d\u52a1\u7ba1\u7406\u5668\u5bf9\u8c61\u4e0d\u5b58\u5728\uff0c\u8bf7\u786e\u8ba4\u662f\u5426\u5df2\u7ecf\u542f\u52a8\u542f\u52a8\u670d\u52a1\u7ba1\u7406\u5668");
            return EAIWebService.GetResult(callResult, null);
        }
        EAIServiceMgr eaiServiceMgr = (EAIServiceMgr)objService;
        callResult = eaiServiceMgr.StartService(eaiParam.getServiceId());
        return EAIWebService.GetResult(callResult, null);
    }

    public OMElement stopservice(OMElement in) {
        CallResult callResult = new CallResult();
        EAIParam eaiParam = EAIWebService.GetEAIParam(in);
        MessageContext messageContext = MessageContext.getCurrentMessageContext();
        ServiceContext serviceContext = messageContext.getServiceContext();
        ServletContext servletContext = (ServletContext)serviceContext.getProperty(HTTPConstants.MC_HTTP_SERVLETCONTEXT);
        Object objService = servletContext.getAttribute("{753F59D7-C01F-4b0a-A0C9-2EAD77744308}");
        if (objService == null || !(objService instanceof EAIServiceMgr)) {
            callResult.setRetCode(1);
            callResult.setErrorInfo("\u96c6\u6210\u670d\u52a1\u7ba1\u7406\u5668\u5bf9\u8c61\u4e0d\u5b58\u5728\uff0c\u8bf7\u786e\u8ba4\u662f\u5426\u5df2\u7ecf\u542f\u52a8\u542f\u52a8\u670d\u52a1\u7ba1\u7406\u5668");
            return EAIWebService.GetResult(callResult, null);
        }
        EAIServiceMgr eaiServiceMgr = (EAIServiceMgr)objService;
        callResult = eaiServiceMgr.StopService(eaiParam.getServiceId());
        return EAIWebService.GetResult(callResult, null);
    }

    private static OMElement GetResult(CallResult callResult, EAIParam eaiParam) {
        if (callResult.getUserObject() != null && callResult.getUserObject() instanceof EAIParam) {
            eaiParam = (EAIParam)callResult.getUserObject();
        }
        OMFactory fac = OMAbstractFactory.getOMFactory();
        OMNamespace omNs = fac.createOMNamespace("http://www.softanywhere.com/", "srfeai");
        OMElement result = fac.createOMElement("callresult", omNs);
        if (callResult != null) {
            result.addAttribute("retcode", StringHelper.Format((String)"%1$s", (Object)callResult.getRetCode()), omNs);
            result.addAttribute("errorinfo", callResult.getErrorInfo(), omNs);
            if (callResult.getUserObject() != null) {
                result.addAttribute("runinfo", callResult.getUserObject().toString(), omNs);
            }
        } else {
            result.addAttribute("retcode", StringHelper.Format((String)"%1$s", (Object)1), omNs);
            result.addAttribute("runinfo", "\u7cfb\u7edf\u5185\u90e8\u53d1\u751f\u9519\u8bef", omNs);
        }
        if (eaiParam != null) {
            XMLStreamReader reader = BeanUtil.getPullParser((Object)eaiParam);
            StreamWrapper parser = new StreamWrapper(reader);
            StAXOMBuilder stAXOMBuilder = OMXMLBuilderFactory.createStAXOMBuilder((OMFactory)OMAbstractFactory.getOMFactory(), (XMLStreamReader)parser);
            OMElement element = stAXOMBuilder.getDocumentElement();
            result.addChild((OMNode)element);
        }
        return result;
    }

    private static EAIParam GetEAIParam(OMElement in) {
        Iterator iterator = in.getChildElements();
        while (iterator.hasNext()) {
            OMElement omElement;
            OMNode omNode = (OMNode)iterator.next();
            if (omNode.getType() != 1 || !(omElement = (OMElement)omNode).getLocalName().equals("EAIParam")) continue;
            try {
                return (EAIParam)BeanUtil.processObject((OMElement)omElement, EAIParam.class, null, (boolean)true, (ObjectSupplier)new DefaultObjectSupplier());
            }
            catch (Exception ex) {
                log.error((Object)"GetEAIParam", (Throwable)ex);
            }
        }
        return null;
    }
}

