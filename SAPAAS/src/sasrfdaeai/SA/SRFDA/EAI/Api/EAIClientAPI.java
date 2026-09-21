/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  org.apache.axiom.om.OMAbstractFactory
 *  org.apache.axiom.om.OMElement
 *  org.apache.axiom.om.OMFactory
 *  org.apache.axiom.om.OMNamespace
 *  org.apache.axiom.om.OMNode
 *  org.apache.axiom.om.impl.builder.StAXOMBuilder
 *  org.apache.axiom.om.impl.llom.factory.OMXMLBuilderFactory
 *  org.apache.axis2.addressing.EndpointReference
 *  org.apache.axis2.client.Options
 *  org.apache.axis2.client.ServiceClient
 *  org.apache.axis2.context.ConfigurationContext
 *  org.apache.axis2.context.ConfigurationContextFactory
 *  org.apache.axis2.databinding.utils.BeanUtil
 *  org.apache.axis2.engine.DefaultObjectSupplier
 *  org.apache.axis2.engine.ObjectSupplier
 *  org.apache.axis2.util.StreamWrapper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.EAI.Api;

import SA.SRFDA.EAI.Api.EAIParam;
import SA.SRFramework.DataEx.CallResult;
import java.util.Iterator;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamReader;
import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axiom.om.OMNode;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;
import org.apache.axiom.om.impl.llom.factory.OMXMLBuilderFactory;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.context.ConfigurationContext;
import org.apache.axis2.context.ConfigurationContextFactory;
import org.apache.axis2.databinding.utils.BeanUtil;
import org.apache.axis2.engine.DefaultObjectSupplier;
import org.apache.axis2.engine.ObjectSupplier;
import org.apache.axis2.util.StreamWrapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class EAIClientAPI {
    private String strRemotePath = "";
    private boolean bJSPMode = false;
    private EndpointReference targetEPR = null;
    private static Log log = LogFactory.getLog(EAIClientAPI.class);

    public CallResult Init(String strRemotePath, boolean bJSPMode) {
        this.strRemotePath = strRemotePath;
        this.bJSPMode = bJSPMode;
        this.targetEPR = new EndpointReference(strRemotePath);
        return new CallResult();
    }

    public CallResult StartService(String strEAIServiceId, String strCurUserId) {
        EAIParam eaiParam = new EAIParam();
        eaiParam.setServiceId(strEAIServiceId);
        eaiParam.setOpPersonId(strCurUserId);
        try {
            Options options = new Options();
            options.setTo(this.targetEPR);
            ServiceClient sender = null;
            if (this.bJSPMode) {
                options.setTransportInProtocol("http");
                ConfigurationContext configctx = ConfigurationContextFactory.createConfigurationContextFromFileSystem(null, null);
                sender = new ServiceClient(configctx, null);
            } else {
                sender = new ServiceClient();
            }
            sender.setOptions(options);
            OMElement callMethod = this.GetEAIParam("startservice", eaiParam);
            OMElement result = sender.sendReceive(callMethod);
            return this.GetResult(result);
        }
        catch (Exception ex) {
            CallResult callResult = new CallResult();
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    public CallResult StopService(String strEAIServiceId, String strCurUserId) {
        EAIParam eaiParam = new EAIParam();
        eaiParam.setServiceId(strEAIServiceId);
        eaiParam.setOpPersonId(strCurUserId);
        try {
            Options options = new Options();
            options.setTo(this.targetEPR);
            ServiceClient sender = null;
            if (this.bJSPMode) {
                options.setTransportInProtocol("http");
                ConfigurationContext configctx = ConfigurationContextFactory.createConfigurationContextFromFileSystem(null, null);
                sender = new ServiceClient(configctx, null);
            } else {
                sender = new ServiceClient();
            }
            sender.setOptions(options);
            OMElement callMethod = this.GetEAIParam("stopservice", eaiParam);
            OMElement result = sender.sendReceive(callMethod);
            return this.GetResult(result);
        }
        catch (Exception ex) {
            CallResult callResult = new CallResult();
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    private CallResult GetResult(OMElement result) {
        CallResult callResult = new CallResult();
        try {
            OMNamespace omNs = result.getNamespace();
            String strRetCode = result.getAttributeValue(new QName(omNs.getNamespaceURI(), "retcode"));
            String strErrorInfo = result.getAttributeValue(new QName(omNs.getNamespaceURI(), "errorinfo"));
            callResult.setRetCode(Integer.parseInt(strRetCode));
            callResult.setErrorInfo(strErrorInfo);
            callResult.setUserObject((Object)this.GetEAIParam(result));
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)"[GetResult]\u51fa\u73b0\u9519\u8bef", (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    private EAIParam GetEAIParam(OMElement in) {
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

    private OMElement GetEAIParam(String strAction, EAIParam eaiParam) {
        OMFactory fac = OMAbstractFactory.getOMFactory();
        OMNamespace omNs = fac.createOMNamespace("http://www.softanywhere.com/", "srfeai");
        OMElement method = fac.createOMElement(strAction, omNs);
        XMLStreamReader reader = BeanUtil.getPullParser((Object)eaiParam);
        StreamWrapper parser = new StreamWrapper(reader);
        StAXOMBuilder stAXOMBuilder = OMXMLBuilderFactory.createStAXOMBuilder((OMFactory)OMAbstractFactory.getOMFactory(), (XMLStreamReader)parser);
        OMElement element = stAXOMBuilder.getDocumentElement();
        method.addChild((OMNode)element);
        return method;
    }
}

