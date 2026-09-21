/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
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
package SA.SRFDA.BR.Web;

import SA.SRFDA.BR.Client.BRParam;
import SA.SRFDA.BR.Ctrl.BREngineMgr;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Date;
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

public class SRFBRService {
    private static Log log = LogFactory.getLog(SRFBRService.class);

    public OMElement execute(OMElement in) {
        long nStartProcessTime = new Date().getTime();
        BRParam brParam = SRFBRService.GetBRParam(in);
        MessageContext messageContext = MessageContext.getCurrentMessageContext();
        ServiceContext serviceContext = messageContext.getServiceContext();
        ServletContext servletContext = (ServletContext)serviceContext.getProperty(HTTPConstants.MC_HTTP_SERVLETCONTEXT);
        BREngineMgr brEngineMgr = null;
        Object objBREngineMgr = servletContext.getAttribute("{F8A3DF77-41FF-4789-BDA1-63C7FD37783D}");
        if (objBREngineMgr != null && objBREngineMgr instanceof BREngineMgr) {
            brEngineMgr = (BREngineMgr)objBREngineMgr;
        }
        CallResult result = new CallResult();
        if (brEngineMgr == null) {
            result.setRetCode(1);
            result.setErrorInfo("\u89c4\u5219\u5f15\u64ce\u7ba1\u7406\u5bf9\u8c61\u65e0\u6548");
            return SRFBRService.GetBRResult(result, null);
        }
        BaseDataEntity dataEntity = BaseDataEntity.FromString((String)brParam.getParam());
        result = brEngineMgr.Execute(brParam.getRuleEngineId(), brParam.getInstData(), brParam.getRuleAction(), dataEntity, brParam.getOpPersonId());
        if (result.IsError()) {
            return SRFBRService.GetBRResult(result, null);
        }
        brParam.setParam(BaseDataEntity.ToString((BaseDataEntity)dataEntity));
        return SRFBRService.GetBRResult(result, brParam);
    }

    public OMElement manage(OMElement in) {
        long nStartProcessTime = new Date().getTime();
        BRParam brParam = SRFBRService.GetBRParam(in);
        MessageContext messageContext = MessageContext.getCurrentMessageContext();
        ServiceContext serviceContext = messageContext.getServiceContext();
        ServletContext servletContext = (ServletContext)serviceContext.getProperty(HTTPConstants.MC_HTTP_SERVLETCONTEXT);
        BREngineMgr brEngineMgr = null;
        Object objBREngineMgr = servletContext.getAttribute("{F8A3DF77-41FF-4789-BDA1-63C7FD37783D}");
        if (objBREngineMgr != null && objBREngineMgr instanceof BREngineMgr) {
            brEngineMgr = (BREngineMgr)objBREngineMgr;
        }
        CallResult result = new CallResult();
        if (brEngineMgr == null) {
            result.setRetCode(1);
            result.setErrorInfo("\u89c4\u5219\u5f15\u64ce\u7ba1\u7406\u5bf9\u8c61\u65e0\u6548");
            return SRFBRService.GetBRResult(result, null);
        }
        BaseDataEntity dataEntity = BaseDataEntity.FromString((String)brParam.getParam());
        result = brEngineMgr.Manage(brParam.getRuleEngineId(), brParam.getMgrAction(), dataEntity, brParam.getOpPersonId());
        if (result.IsError()) {
            return SRFBRService.GetBRResult(result, null);
        }
        brParam.setParam(BaseDataEntity.ToString((BaseDataEntity)dataEntity));
        return SRFBRService.GetBRResult(result, brParam);
    }

    private static OMElement GetBRResult(CallResult callResult, BRParam brParam) {
        if (callResult.getUserObject() != null && callResult.getUserObject() instanceof BRParam) {
            brParam = (BRParam)callResult.getUserObject();
        }
        OMFactory fac = OMAbstractFactory.getOMFactory();
        OMNamespace omNs = fac.createOMNamespace("http://www.softanywhere.com/", "srfbr");
        OMElement result = fac.createOMElement("callresult", omNs);
        if (callResult != null) {
            result.addAttribute("retcode", StringHelper.Format((String)"%1$s", (Object)callResult.getRetCode()), omNs);
            result.addAttribute("errorinfo", callResult.getErrorInfo(), omNs);
        } else {
            result.addAttribute("retcode", StringHelper.Format((String)"%1$s", (Object)1), omNs);
            result.addAttribute("runinfo", "\u7cfb\u7edf\u5185\u90e8\u53d1\u751f\u9519\u8bef", omNs);
        }
        if (brParam != null) {
            XMLStreamReader reader = BeanUtil.getPullParser((Object)brParam);
            StreamWrapper parser = new StreamWrapper(reader);
            StAXOMBuilder stAXOMBuilder = OMXMLBuilderFactory.createStAXOMBuilder((OMFactory)OMAbstractFactory.getOMFactory(), (XMLStreamReader)parser);
            OMElement element = stAXOMBuilder.getDocumentElement();
            result.addChild((OMNode)element);
        }
        return result;
    }

    private static BRParam GetBRParam(OMElement in) {
        Iterator iterator = in.getChildElements();
        while (iterator.hasNext()) {
            OMElement omElement;
            OMNode omNode = (OMNode)iterator.next();
            if (omNode.getType() != 1 || !(omElement = (OMElement)omNode).getLocalName().equals("BRParam")) continue;
            try {
                return (BRParam)BeanUtil.processObject((OMElement)omElement, BRParam.class, null, (boolean)true, (ObjectSupplier)new DefaultObjectSupplier());
            }
            catch (Exception ex) {
                log.error((Object)"GetBRParam", (Throwable)ex);
            }
        }
        return null;
    }
}

