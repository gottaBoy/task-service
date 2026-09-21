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
package SA.SRFDA.KPI.Ctrl;

import SA.SRFDA.KPI.Client.KPIParam;
import SA.SRFDA.KPI.Ctrl.DefaultKPIEngine;
import SA.SRFramework.DataEx.BaseDBCallerHelperEx;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Data.WebDBCallerHelperEx;
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

public class SRFKPIService {
    private static Log log = LogFactory.getLog(SRFKPIService.class);

    public OMElement startnew(OMElement in) {
        WebDBCallerHelperEx dbCallerHelper;
        DefaultKPIEngine defaultEngine = new DefaultKPIEngine();
        KPIParam wfParam = this.GetKPIParam(in);
        MessageContext messageContext = MessageContext.getCurrentMessageContext();
        ServiceContext serviceContext = messageContext.getServiceContext();
        ServletContext servletContext = (ServletContext)serviceContext.getProperty(HTTPConstants.MC_HTTP_SERVLETCONTEXT);
        CallResult callResult = defaultEngine.Init(servletContext, (BaseDBCallerHelperEx)(dbCallerHelper = (WebDBCallerHelperEx)servletContext.getAttribute("SRFDBCALLERHELPER")), wfParam.getKpiSetId());
        if (callResult == null || callResult.getRetCode() != 0) {
            return this.GetKPIResult(callResult, null);
        }
        callResult = defaultEngine.StartNew(wfParam);
        if (callResult == null || callResult.getRetCode() != 0) {
            return this.GetKPIResult(callResult, null);
        }
        return this.GetKPIResult(callResult, null);
    }

    private OMElement GetKPIResult(CallResult callResult, KPIParam wfParam) {
        if (callResult.getUserObject() != null && callResult.getUserObject() instanceof KPIParam) {
            wfParam = (KPIParam)callResult.getUserObject();
        }
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
        if (wfParam != null) {
            XMLStreamReader reader = BeanUtil.getPullParser((Object)wfParam);
            StreamWrapper parser = new StreamWrapper(reader);
            StAXOMBuilder stAXOMBuilder = OMXMLBuilderFactory.createStAXOMBuilder((OMFactory)OMAbstractFactory.getOMFactory(), (XMLStreamReader)parser);
            OMElement element = stAXOMBuilder.getDocumentElement();
            result.addChild((OMNode)element);
        }
        return result;
    }

    private KPIParam GetKPIParam(OMElement in) {
        Iterator iterator = in.getChildElements();
        while (iterator.hasNext()) {
            OMElement omElement;
            OMNode omNode = (OMNode)iterator.next();
            if (omNode.getType() != 1 || !(omElement = (OMElement)omNode).getLocalName().equals("KPIParam")) continue;
            try {
                return (KPIParam)BeanUtil.processObject((OMElement)omElement, KPIParam.class, null, (boolean)true, (ObjectSupplier)new DefaultObjectSupplier());
            }
            catch (Exception ex) {
                log.error((Object)"GetKPIParam", (Throwable)ex);
            }
        }
        return null;
    }
}

