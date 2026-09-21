/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  org.apache.axiom.om.OMAbstractFactory
 *  org.apache.axiom.om.OMElement
 *  org.apache.axiom.om.OMFactory
 *  org.apache.axiom.om.OMNamespace
 *  org.apache.axiom.om.OMNode
 *  org.apache.axiom.om.impl.builder.StAXOMBuilder
 *  org.apache.axiom.om.impl.llom.factory.OMXMLBuilderFactory
 *  org.apache.axis2.AxisFault
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
package SA.SRFDA.BR.Client;

import SA.SRFDA.BR.Client.BRParam;
import SA.SRFramework.DataEx.BaseDataEntity;
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
import org.apache.axis2.AxisFault;
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

public class BRClientAPI {
    private String strRemotePath = "";
    private boolean bJSPMode = false;
    private EndpointReference targetEPR = null;
    private static Log log = LogFactory.getLog(BRClientAPI.class);

    public CallResult Init(String strRemotePath, boolean bJSPMode) {
        this.strRemotePath = strRemotePath;
        this.bJSPMode = bJSPMode;
        this.targetEPR = new EndpointReference(strRemotePath);
        return new CallResult();
    }

    public CallResult Execute(String strEngineId, String strInstData, String strAction, BaseDataEntity dataEntity, String strOPPersonId) {
        BRParam brParam = new BRParam();
        brParam.setRuleEngineId(strEngineId);
        brParam.setInstData(strInstData);
        brParam.setRuleAction(strAction);
        brParam.setParam(BaseDataEntity.ToString((BaseDataEntity)dataEntity));
        brParam.setOpPersonId(strOPPersonId);
        ServiceClient sender = null;
        CallResult callResult = new CallResult();
        try {
            try {
                Options options = new Options();
                options.setTo(this.targetEPR);
                if (this.bJSPMode) {
                    options.setTransportInProtocol("http");
                    ConfigurationContext configctx = ConfigurationContextFactory.createConfigurationContextFromFileSystem(null, null);
                    sender = new ServiceClient(configctx, null);
                } else {
                    sender = new ServiceClient();
                }
                sender.setOptions(options);
                OMElement callMethod = this.GetBRParam("execute", brParam);
                OMElement result = sender.sendReceive(callMethod);
                callResult = this.GetResult(result);
                if (callResult.IsOk() && callResult.getUserObject() != null && callResult.getUserObject() instanceof BRParam) {
                    BaseDataEntity.FromString((String)((BRParam)callResult.getUserObject()).getParam()).CopyTo(dataEntity, true);
                    callResult.setUserObject(null);
                }
            }
            catch (Exception ex) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(ex.getMessage());
                try {
                    if (sender != null) {
                        sender.cleanupTransport();
                    }
                }
                catch (AxisFault e) {
                    e.printStackTrace();
                }
                try {
                    if (sender != null) {
                        sender.cleanup();
                    }
                }
                catch (AxisFault e) {
                    e.printStackTrace();
                }
            }
        }
        finally {
            try {
                if (sender != null) {
                    sender.cleanupTransport();
                }
            }
            catch (AxisFault e) {
                e.printStackTrace();
            }
            try {
                if (sender != null) {
                    sender.cleanup();
                }
            }
            catch (AxisFault e) {
                e.printStackTrace();
            }
        }
        return callResult;
    }

    public CallResult Manage(String strEngineId, String strAction, BaseDataEntity dataEntity, String strOPPersonId) {
        BRParam brParam = new BRParam();
        brParam.setRuleEngineId(strEngineId);
        brParam.setMgrAction(strAction);
        brParam.setParam(BaseDataEntity.ToString((BaseDataEntity)dataEntity));
        brParam.setOpPersonId(strOPPersonId);
        ServiceClient sender = null;
        CallResult callResult = new CallResult();
        try {
            try {
                Options options = new Options();
                options.setTo(this.targetEPR);
                if (this.bJSPMode) {
                    options.setTransportInProtocol("http");
                    ConfigurationContext configctx = ConfigurationContextFactory.createConfigurationContextFromFileSystem(null, null);
                    sender = new ServiceClient(configctx, null);
                } else {
                    sender = new ServiceClient();
                }
                sender.setOptions(options);
                OMElement callMethod = this.GetBRParam("manage", brParam);
                OMElement result = sender.sendReceive(callMethod);
                callResult = this.GetResult(result);
                if (callResult.IsOk() && callResult.getUserObject() != null && callResult.getUserObject() instanceof BRParam) {
                    BaseDataEntity.FromString((String)((BRParam)callResult.getUserObject()).getParam()).CopyTo(dataEntity, true);
                    callResult.setUserObject(null);
                }
            }
            catch (Exception ex) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(ex.getMessage());
                CallResult callResult2 = callResult;
                try {
                    if (sender != null) {
                        sender.cleanupTransport();
                    }
                }
                catch (AxisFault e) {
                    e.printStackTrace();
                }
                try {
                    if (sender != null) {
                        sender.cleanup();
                    }
                }
                catch (AxisFault e) {
                    e.printStackTrace();
                }
                return callResult2;
            }
        }
        finally {
            try {
                if (sender != null) {
                    sender.cleanupTransport();
                }
            }
            catch (AxisFault e) {
                e.printStackTrace();
            }
            try {
                if (sender != null) {
                    sender.cleanup();
                }
            }
            catch (AxisFault e) {
                e.printStackTrace();
            }
        }
        return callResult;
    }

    private CallResult GetResult(OMElement result) {
        CallResult callResult = new CallResult();
        try {
            OMNamespace omNs = result.getNamespace();
            String strRetCode = result.getAttributeValue(new QName(omNs.getNamespaceURI(), "retcode"));
            String strErrorInfo = result.getAttributeValue(new QName(omNs.getNamespaceURI(), "errorinfo"));
            callResult.setRetCode(Integer.parseInt(strRetCode));
            callResult.setErrorInfo(strErrorInfo);
            callResult.setUserObject((Object)this.GetBRParam(result));
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)"[GetResult]\u51fa\u73b0\u9519\u8bef", (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    private BRParam GetBRParam(OMElement in) {
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

    private OMElement GetBRParam(String strAction, BRParam brParam) {
        OMFactory fac = OMAbstractFactory.getOMFactory();
        OMNamespace omNs = fac.createOMNamespace("http://www.softanywhere.com/", "srfbr");
        OMElement method = fac.createOMElement(strAction, omNs);
        XMLStreamReader reader = BeanUtil.getPullParser((Object)brParam);
        StreamWrapper parser = new StreamWrapper(reader);
        StAXOMBuilder stAXOMBuilder = OMXMLBuilderFactory.createStAXOMBuilder((OMFactory)OMAbstractFactory.getOMFactory(), (XMLStreamReader)parser);
        OMElement element = stAXOMBuilder.getDocumentElement();
        method.addChild((OMNode)element);
        return method;
    }
}

