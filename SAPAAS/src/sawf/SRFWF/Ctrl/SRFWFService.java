/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDBCallerHelperEx
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.Data.WebDBCallerHelperEx
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
package SRFWF.Ctrl;

import SA.SRFramework.DataEx.BaseDBCallerHelperEx;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Data.WebDBCallerHelperEx;
import SRFWF.Client.WFParam;
import SRFWF.Ctrl.Data.WFAction;
import SRFWF.Ctrl.SRFWFDefaultEngine;
import SRFWF.Model.WFInteractiveActionConfig;
import SRFWF.Model.WFInteractiveProcessConfig;
import SRFWF.Model.WFUserActionConfig;
import java.util.Date;
import java.util.HashMap;
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

public class SRFWFService {
    private static HashMap<String, String> currentProcessMap = new HashMap();
    private static Log log = LogFactory.getLog(SRFWFService.class);

    public OMElement startnew(OMElement in) {
        WebDBCallerHelperEx dbCallerHelper;
        long nStartProcessTime = new Date().getTime();
        SRFWFDefaultEngine defaultEngine = new SRFWFDefaultEngine();
        WFParam wfParam = this.GetWFParam(in);
        MessageContext messageContext = MessageContext.getCurrentMessageContext();
        ServiceContext serviceContext = messageContext.getServiceContext();
        ServletContext servletContext = (ServletContext)serviceContext.getProperty(HTTPConstants.MC_HTTP_SERVLETCONTEXT);
        CallResult callResult = defaultEngine.Init(servletContext, (BaseDBCallerHelperEx)(dbCallerHelper = (WebDBCallerHelperEx)servletContext.getAttribute("SRFDBCALLERHELPER")), wfParam.getWorkflowId());
        if (callResult == null || callResult.getRetCode() != 0) {
            return this.GetWFResult(callResult, null);
        }
        callResult = defaultEngine.StartNew(wfParam);
        if (callResult == null || callResult.getRetCode() != 0) {
            return this.GetWFResult(callResult, null);
        }
        long nProcessTime = new Date().getTime() - nStartProcessTime;
        if (defaultEngine.getContextHelper().getPOLogger() != null) {
            defaultEngine.getContextHelper().getPOLogger().LogWFAction(wfParam.getWorkflowId(), "STARTNEW", "", (int)nProcessTime);
        }
        return this.GetWFResult(callResult, null);
    }

    public OMElement restart(OMElement in) {
        WebDBCallerHelperEx dbCallerHelper;
        long nStartProcessTime = new Date().getTime();
        SRFWFDefaultEngine defaultEngine = new SRFWFDefaultEngine();
        WFParam wfParam = this.GetWFParam(in);
        MessageContext messageContext = MessageContext.getCurrentMessageContext();
        ServiceContext serviceContext = messageContext.getServiceContext();
        ServletContext servletContext = (ServletContext)serviceContext.getProperty(HTTPConstants.MC_HTTP_SERVLETCONTEXT);
        CallResult callResult = defaultEngine.Init(servletContext, (BaseDBCallerHelperEx)(dbCallerHelper = (WebDBCallerHelperEx)servletContext.getAttribute("SRFDBCALLERHELPER")), wfParam.getWorkflowId());
        if (callResult == null || callResult.getRetCode() != 0) {
            return this.GetWFResult(callResult, null);
        }
        callResult = defaultEngine.Restart(wfParam);
        if (callResult == null || callResult.getRetCode() != 0) {
            return this.GetWFResult(callResult, null);
        }
        long nProcessTime = new Date().getTime() - nStartProcessTime;
        if (defaultEngine.getContextHelper().getPOLogger() != null) {
            defaultEngine.getContextHelper().getPOLogger().LogWFAction(wfParam.getWorkflowId(), "RESTART", "", (int)nProcessTime);
        }
        return this.GetWFResult(callResult, null);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public OMElement submitiaaction(OMElement in) {
        WebDBCallerHelperEx dbCallerHelper;
        long nStartProcessTime = new Date().getTime();
        SRFWFDefaultEngine defaultEngine = new SRFWFDefaultEngine();
        WFParam wfParam = this.GetWFParam(in);
        MessageContext messageContext = MessageContext.getCurrentMessageContext();
        ServiceContext serviceContext = messageContext.getServiceContext();
        ServletContext servletContext = (ServletContext)serviceContext.getProperty(HTTPConstants.MC_HTTP_SERVLETCONTEXT);
        CallResult callResult = defaultEngine.Init(servletContext, (BaseDBCallerHelperEx)(dbCallerHelper = (WebDBCallerHelperEx)servletContext.getAttribute("SRFDBCALLERHELPER")), wfParam.getWorkflowId());
        if (callResult == null || callResult.getRetCode() != 0) {
            return this.GetWFResult(callResult, null);
        }
        String strTag = StringHelper.Format((String)"%1$s|%2$s|%3$s|%4$s|%5$s", (Object)wfParam.getWorkflowId(), (Object)wfParam.getUserData(), (Object)wfParam.getUserData2(), (Object)wfParam.getUserData3(), (Object)wfParam.getUserData4());
        HashMap<String, String> hashMap = currentProcessMap;
        synchronized (hashMap) {
            if (currentProcessMap.containsKey(strTag)) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u5f53\u524d\u6570\u636e\u6b63\u5728\u6d41\u7a0b\u5904\u7406\u4e2d"));
                return this.GetWFResult(callResult, null);
            }
            currentProcessMap.put(strTag, "");
        }
        callResult = defaultEngine.SubmitIAAction(false, wfParam);
        hashMap = currentProcessMap;
        synchronized (hashMap) {
            currentProcessMap.remove(strTag);
        }
        if (callResult == null || callResult.getRetCode() != 0) {
            return this.GetWFResult(callResult, null);
        }
        long nProcessTime = new Date().getTime() - nStartProcessTime;
        if (defaultEngine.getContextHelper().getPOLogger() != null) {
            defaultEngine.getContextHelper().getPOLogger().LogWFAction(wfParam.getWorkflowId(), "SUBMITIAACTION", "", (int)nProcessTime);
        }
        return this.GetWFResult(callResult, null);
    }

    public OMElement rollbackiaaction(OMElement in) {
        WebDBCallerHelperEx dbCallerHelper;
        long nStartProcessTime = new Date().getTime();
        SRFWFDefaultEngine defaultEngine = new SRFWFDefaultEngine();
        WFParam wfParam = this.GetWFParam(in);
        MessageContext messageContext = MessageContext.getCurrentMessageContext();
        ServiceContext serviceContext = messageContext.getServiceContext();
        ServletContext servletContext = (ServletContext)serviceContext.getProperty(HTTPConstants.MC_HTTP_SERVLETCONTEXT);
        CallResult callResult = defaultEngine.Init(servletContext, (BaseDBCallerHelperEx)(dbCallerHelper = (WebDBCallerHelperEx)servletContext.getAttribute("SRFDBCALLERHELPER")), wfParam.getWorkflowId());
        if (callResult == null || callResult.getRetCode() != 0) {
            return this.GetWFResult(callResult, null);
        }
        callResult = defaultEngine.RollbackIAAction(wfParam);
        if (callResult == null || callResult.getRetCode() != 0) {
            return this.GetWFResult(callResult, null);
        }
        long nProcessTime = new Date().getTime() - nStartProcessTime;
        if (defaultEngine.getContextHelper().getPOLogger() != null) {
            defaultEngine.getContextHelper().getPOLogger().LogWFAction(wfParam.getWorkflowId(), "ROLLBACKIAACTION", "", (int)nProcessTime);
        }
        return this.GetWFResult(callResult, null);
    }

    public OMElement timeoutiaaction(OMElement in) {
        WebDBCallerHelperEx dbCallerHelper;
        long nStartProcessTime = new Date().getTime();
        SRFWFDefaultEngine defaultEngine = new SRFWFDefaultEngine();
        WFParam wfParam = this.GetWFParam(in);
        MessageContext messageContext = MessageContext.getCurrentMessageContext();
        ServiceContext serviceContext = messageContext.getServiceContext();
        ServletContext servletContext = (ServletContext)serviceContext.getProperty(HTTPConstants.MC_HTTP_SERVLETCONTEXT);
        CallResult callResult = defaultEngine.Init(servletContext, (BaseDBCallerHelperEx)(dbCallerHelper = (WebDBCallerHelperEx)servletContext.getAttribute("SRFDBCALLERHELPER")), wfParam.getWorkflowId());
        if (callResult == null || callResult.getRetCode() != 0) {
            return this.GetWFResult(callResult, null);
        }
        callResult = defaultEngine.TimeoutIAAction(wfParam);
        if (callResult == null || callResult.getRetCode() != 0) {
            return this.GetWFResult(callResult, null);
        }
        long nProcessTime = new Date().getTime() - nStartProcessTime;
        if (defaultEngine.getContextHelper().getPOLogger() != null) {
            defaultEngine.getContextHelper().getPOLogger().LogWFAction(wfParam.getWorkflowId(), "TIMEOUTIAACTION", "", (int)nProcessTime);
        }
        return this.GetWFResult(callResult, null);
    }

    public OMElement resubmitaction(OMElement in) {
        WebDBCallerHelperEx dbCallerHelper;
        long nStartProcessTime = new Date().getTime();
        SRFWFDefaultEngine defaultEngine = new SRFWFDefaultEngine();
        WFParam wfParam = this.GetWFParam(in);
        MessageContext messageContext = MessageContext.getCurrentMessageContext();
        ServiceContext serviceContext = messageContext.getServiceContext();
        ServletContext servletContext = (ServletContext)serviceContext.getProperty(HTTPConstants.MC_HTTP_SERVLETCONTEXT);
        CallResult callResult = defaultEngine.Init(servletContext, (BaseDBCallerHelperEx)(dbCallerHelper = (WebDBCallerHelperEx)servletContext.getAttribute("SRFDBCALLERHELPER")), wfParam.getWorkflowId());
        if (callResult == null || callResult.getRetCode() != 0) {
            return this.GetWFResult(callResult, null);
        }
        callResult = defaultEngine.ResubmitAction(wfParam);
        if (callResult == null || callResult.getRetCode() != 0) {
            return this.GetWFResult(callResult, null);
        }
        long nProcessTime = new Date().getTime() - nStartProcessTime;
        if (defaultEngine.getContextHelper().getPOLogger() != null) {
            defaultEngine.getContextHelper().getPOLogger().LogWFAction(wfParam.getWorkflowId(), "RESUBMITACTION", "", (int)nProcessTime);
        }
        return this.GetWFResult(callResult, null);
    }

    public OMElement calcnextiaprocessactor(OMElement in) {
        WebDBCallerHelperEx dbCallerHelper;
        long nStartProcessTime = new Date().getTime();
        SRFWFDefaultEngine defaultEngine = new SRFWFDefaultEngine();
        WFParam wfParam = this.GetWFParam(in);
        MessageContext messageContext = MessageContext.getCurrentMessageContext();
        ServiceContext serviceContext = messageContext.getServiceContext();
        ServletContext servletContext = (ServletContext)serviceContext.getProperty(HTTPConstants.MC_HTTP_SERVLETCONTEXT);
        CallResult callResult = defaultEngine.Init(servletContext, (BaseDBCallerHelperEx)(dbCallerHelper = (WebDBCallerHelperEx)servletContext.getAttribute("SRFDBCALLERHELPER")), wfParam.getWorkflowId());
        if (callResult == null || callResult.getRetCode() != 0) {
            return this.GetWFResult(callResult, null);
        }
        callResult = defaultEngine.CalcNextIAProcessActor(wfParam);
        if (callResult == null || callResult.getRetCode() != 0) {
            return this.GetWFResult(callResult, null);
        }
        long nProcessTime = new Date().getTime() - nStartProcessTime;
        if (defaultEngine.getContextHelper().getPOLogger() != null) {
            defaultEngine.getContextHelper().getPOLogger().LogWFAction(wfParam.getWorkflowId(), "CALCNEXTIAPROCESSACTOR", "", (int)nProcessTime);
        }
        return this.GetWFResult(callResult, null);
    }

    public OMElement testsubmitiaaction(OMElement in) {
        WebDBCallerHelperEx dbCallerHelper;
        long nStartProcessTime = new Date().getTime();
        SRFWFDefaultEngine defaultEngine = new SRFWFDefaultEngine();
        WFParam wfParam = this.GetWFParam(in);
        MessageContext messageContext = MessageContext.getCurrentMessageContext();
        ServiceContext serviceContext = messageContext.getServiceContext();
        ServletContext servletContext = (ServletContext)serviceContext.getProperty(HTTPConstants.MC_HTTP_SERVLETCONTEXT);
        CallResult callResult = defaultEngine.Init(servletContext, (BaseDBCallerHelperEx)(dbCallerHelper = (WebDBCallerHelperEx)servletContext.getAttribute("SRFDBCALLERHELPER")), wfParam.getWorkflowId());
        if (callResult == null || callResult.getRetCode() != 0) {
            return this.GetWFResult(callResult, null);
        }
        callResult = defaultEngine.SubmitIAAction(true, wfParam);
        if (callResult == null || callResult.getRetCode() != 0) {
            return this.GetWFResult(callResult, null);
        }
        long nProcessTime = new Date().getTime() - nStartProcessTime;
        if (defaultEngine.getContextHelper().getPOLogger() != null) {
            defaultEngine.getContextHelper().getPOLogger().LogWFAction(wfParam.getWorkflowId(), "TESTSUBMITIAACTION", "", (int)nProcessTime);
        }
        return this.GetWFResult(callResult, null);
    }

    public OMElement userclose(OMElement in) {
        WebDBCallerHelperEx dbCallerHelper;
        long nStartProcessTime = new Date().getTime();
        SRFWFDefaultEngine defaultEngine = new SRFWFDefaultEngine();
        WFParam wfParam = this.GetWFParam(in);
        MessageContext messageContext = MessageContext.getCurrentMessageContext();
        ServiceContext serviceContext = messageContext.getServiceContext();
        ServletContext servletContext = (ServletContext)serviceContext.getProperty(HTTPConstants.MC_HTTP_SERVLETCONTEXT);
        CallResult callResult = defaultEngine.Init(servletContext, (BaseDBCallerHelperEx)(dbCallerHelper = (WebDBCallerHelperEx)servletContext.getAttribute("SRFDBCALLERHELPER")), wfParam.getWorkflowId());
        if (callResult == null || callResult.getRetCode() != 0) {
            return this.GetWFResult(callResult, null);
        }
        callResult = defaultEngine.UserClose(wfParam);
        if (callResult == null || callResult.getRetCode() != 0) {
            return this.GetWFResult(callResult, null);
        }
        long nProcessTime = new Date().getTime() - nStartProcessTime;
        if (defaultEngine.getContextHelper().getPOLogger() != null) {
            defaultEngine.getContextHelper().getPOLogger().LogWFAction(wfParam.getWorkflowId(), "USERCLOSE", "", (int)nProcessTime);
        }
        return this.GetWFResult(callResult, null);
    }

    public OMElement markreadflag(OMElement in) {
        WebDBCallerHelperEx dbCallerHelper;
        long nStartProcessTime = new Date().getTime();
        SRFWFDefaultEngine defaultEngine = new SRFWFDefaultEngine();
        WFParam wfParam = this.GetWFParam(in);
        MessageContext messageContext = MessageContext.getCurrentMessageContext();
        ServiceContext serviceContext = messageContext.getServiceContext();
        ServletContext servletContext = (ServletContext)serviceContext.getProperty(HTTPConstants.MC_HTTP_SERVLETCONTEXT);
        CallResult callResult = defaultEngine.Init(servletContext, (BaseDBCallerHelperEx)(dbCallerHelper = (WebDBCallerHelperEx)servletContext.getAttribute("SRFDBCALLERHELPER")), wfParam.getWorkflowId());
        if (callResult == null || callResult.getRetCode() != 0) {
            return this.GetWFResult(callResult, null);
        }
        callResult = defaultEngine.MarkReadFlag(wfParam);
        if (callResult == null || callResult.getRetCode() != 0) {
            return this.GetWFResult(callResult, null);
        }
        long nProcessTime = new Date().getTime() - nStartProcessTime;
        if (defaultEngine.getContextHelper().getPOLogger() != null) {
            defaultEngine.getContextHelper().getPOLogger().LogWFAction(wfParam.getWorkflowId(), "MARKREADFLAG", "", (int)nProcessTime);
        }
        return this.GetWFResult(callResult, null);
    }

    public OMElement getiaactions(OMElement in) {
        WebDBCallerHelperEx dbCallerHelper;
        long nStartProcessTime = new Date().getTime();
        SRFWFDefaultEngine defaultEngine = new SRFWFDefaultEngine();
        WFParam wfParam = this.GetWFParam(in);
        MessageContext messageContext = MessageContext.getCurrentMessageContext();
        ServiceContext serviceContext = messageContext.getServiceContext();
        ServletContext servletContext = (ServletContext)serviceContext.getProperty(HTTPConstants.MC_HTTP_SERVLETCONTEXT);
        CallResult callResult = defaultEngine.Init(servletContext, (BaseDBCallerHelperEx)(dbCallerHelper = (WebDBCallerHelperEx)servletContext.getAttribute("SRFDBCALLERHELPER")), wfParam.getWorkflowId());
        if (callResult == null || callResult.getRetCode() != 0) {
            return this.GetWFResult(callResult, null);
        }
        callResult = defaultEngine.GetIAProcess(wfParam);
        if (callResult == null || callResult.getRetCode() != 0) {
            return this.GetWFResult(callResult, null);
        }
        long nProcessTime = new Date().getTime() - nStartProcessTime;
        if (defaultEngine.getContextHelper().getPOLogger() != null) {
            defaultEngine.getContextHelper().getPOLogger().LogWFAction(wfParam.getWorkflowId(), "GETIAACTIONS", "", (int)nProcessTime);
        }
        return this.GetWFIAActionsResult(callResult);
    }

    private OMElement GetWFIAActionsResult(CallResult callResult) {
        OMFactory fac = OMAbstractFactory.getOMFactory();
        OMNamespace omNs = fac.createOMNamespace("http://www.softanywhere.com/", "srfwf");
        OMElement result = fac.createOMElement("callresult", omNs);
        if (callResult != null) {
            result.addAttribute("retcode", StringHelper.Format((String)"%1$s", (Object)callResult.getRetCode()), omNs);
            result.addAttribute("errorinfo", callResult.getErrorInfo(), omNs);
        } else {
            result.addAttribute("retcode", StringHelper.Format((String)"%1$s", (Object)1), omNs);
            result.addAttribute("errorinfo", "\u7cfb\u7edf\u5185\u90e8\u53d1\u751f\u9519\u8bef", omNs);
        }
        if (callResult.getUserObject() != null && callResult.getUserObject() instanceof WFInteractiveProcessConfig) {
            WFInteractiveProcessConfig processConfig = (WFInteractiveProcessConfig)((Object)callResult.getUserObject());
            result.addAttribute("processname", processConfig.getName(), omNs);
            result.addAttribute("version", processConfig.GetExtValue("VERSION", "1"), omNs);
            result.addAttribute("usertag", processConfig.GetExtValue("USERTAG", ""), omNs);
            Iterator<WFAction> iterator = processConfig.getIAActionsConfig().iterator();
            while (iterator.hasNext()) {
                WFInteractiveActionConfig iaActionConfig = (WFInteractiveActionConfig)((Object)iterator.next());
                XMLStreamReader reader = BeanUtil.getPullParser((Object)((Object)iaActionConfig));
                StreamWrapper parser = new StreamWrapper(reader);
                StAXOMBuilder stAXOMBuilder = OMXMLBuilderFactory.createStAXOMBuilder((OMFactory)OMAbstractFactory.getOMFactory(), (XMLStreamReader)parser);
                OMElement element = stAXOMBuilder.getDocumentElement();
                result.addChild((OMNode)element);
            }
            for (WFAction wfAction : processConfig.getUserActionList()) {
                WFUserActionConfig userActionConfig = new WFUserActionConfig();
                userActionConfig.From(wfAction);
                XMLStreamReader reader = BeanUtil.getPullParser((Object)((Object)userActionConfig));
                StreamWrapper parser = new StreamWrapper(reader);
                StAXOMBuilder stAXOMBuilder = OMXMLBuilderFactory.createStAXOMBuilder((OMFactory)OMAbstractFactory.getOMFactory(), (XMLStreamReader)parser);
                OMElement element = stAXOMBuilder.getDocumentElement();
                result.addChild((OMNode)element);
            }
        }
        return result;
    }

    private OMElement GetWFResult(CallResult callResult, WFParam wfParam) {
        if (callResult.getUserObject() != null && callResult.getUserObject() instanceof WFParam) {
            wfParam = (WFParam)callResult.getUserObject();
        }
        OMFactory fac = OMAbstractFactory.getOMFactory();
        OMNamespace omNs = fac.createOMNamespace("http://www.softanywhere.com/", "srfwf");
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
        if (wfParam != null) {
            XMLStreamReader reader = BeanUtil.getPullParser((Object)wfParam);
            StreamWrapper parser = new StreamWrapper(reader);
            StAXOMBuilder stAXOMBuilder = OMXMLBuilderFactory.createStAXOMBuilder((OMFactory)OMAbstractFactory.getOMFactory(), (XMLStreamReader)parser);
            OMElement element = stAXOMBuilder.getDocumentElement();
            result.addChild((OMNode)element);
        }
        return result;
    }

    private WFParam GetWFParam(OMElement in) {
        Iterator iterator = in.getChildElements();
        while (iterator.hasNext()) {
            OMElement omElement;
            OMNode omNode = (OMNode)iterator.next();
            if (omNode.getType() != 1 || !(omElement = (OMElement)omNode).getLocalName().equals("WFParam")) continue;
            try {
                return (WFParam)BeanUtil.processObject((OMElement)omElement, WFParam.class, null, (boolean)true, (ObjectSupplier)new DefaultObjectSupplier());
            }
            catch (Exception ex) {
                log.error((Object)"GetWFParam", (Throwable)ex);
            }
        }
        return null;
    }
}

