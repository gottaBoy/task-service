/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
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
package SRFWF.Client;

import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SRFWF.Client.WFCallResult;
import SRFWF.Client.WFGetIAActionsResult;
import SRFWF.Client.WFParam;
import SRFWF.Model.WFInteractiveActionConfig;
import SRFWF.Model.WFUserActionConfig;
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

public class WFClientAPI {
    private String strRemotePath = "";
    private boolean bJSPMode = false;
    private EndpointReference targetEPR = null;
    private static Log log = LogFactory.getLog(WFClientAPI.class);

    public CallResult Init(String strRemotePath, boolean bJSPMode) {
        this.strRemotePath = strRemotePath;
        this.bJSPMode = bJSPMode;
        this.targetEPR = new EndpointReference(strRemotePath);
        return new CallResult();
    }

    public WFCallResult StartNew(String strWorkflowId, String strCurUserId, String strUserData, String strUserData2, String strUserData3, String strUserData4) {
        WFParam wfParam = new WFParam();
        wfParam.setWorkflowId(strWorkflowId);
        wfParam.setOpPersonId(strCurUserId);
        wfParam.setUserData(strUserData);
        wfParam.setUserData2(strUserData2);
        wfParam.setUserData3(strUserData3);
        wfParam.setUserData4(strUserData4);
        WFCallResult callResult = new WFCallResult();
        ServiceClient sender = null;
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
                OMElement callMethod = WFClientAPI.GetWFParam("startnew", wfParam);
                OMElement result = sender.sendReceive(callMethod);
                callResult = WFClientAPI.GetResult(result);
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

    public WFCallResult Restart(String strWorkflowId, String strCurUserId, String strUserData, String strUserData2, String strUserData3, String strUserData4) {
        WFParam wfParam = new WFParam();
        wfParam.setWorkflowId(strWorkflowId);
        wfParam.setOpPersonId(strCurUserId);
        wfParam.setUserData(strUserData);
        wfParam.setUserData2(strUserData2);
        wfParam.setUserData3(strUserData3);
        wfParam.setUserData4(strUserData4);
        WFCallResult callResult = new WFCallResult();
        ServiceClient sender = null;
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
                OMElement callMethod = WFClientAPI.GetWFParam("restart", wfParam);
                OMElement result = sender.sendReceive(callMethod);
                callResult = WFClientAPI.GetResult(result);
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

    public WFCallResult SubmitIAAction(String strWorkflowId, String strCurUserId, String strUserData, String strUserData2, String strUserData3, String strUserData4, String strStepName, String strConnection, String strDescription) {
        return this.SubmitIAAction(strWorkflowId, strCurUserId, strUserData, strUserData2, strUserData3, strUserData4, strStepName, strConnection, strDescription, "", "");
    }

    public WFCallResult SubmitIAAction(String strWorkflowId, String strCurUserId, String strUserData, String strUserData2, String strUserData3, String strUserData4, String strStepName, String strConnection, String strDescription, String strUserTag, String strUserTag2) {
        WFParam wfParam = new WFParam();
        wfParam.setWorkflowId(strWorkflowId);
        wfParam.setOpPersonId(strCurUserId);
        wfParam.setUserData(strUserData);
        wfParam.setUserData2(strUserData2);
        wfParam.setUserData3(strUserData3);
        wfParam.setUserData4(strUserData4);
        wfParam.setStepId(strStepName);
        wfParam.setConnection(strConnection);
        wfParam.setDescription(strDescription);
        wfParam.setUserTag(strUserTag);
        wfParam.setUserTag2(strUserTag2);
        WFCallResult callResult = new WFCallResult();
        ServiceClient sender = null;
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
                OMElement callMethod = WFClientAPI.GetWFParam("submitiaaction", wfParam);
                OMElement result = sender.sendReceive(callMethod);
                callResult = WFClientAPI.GetResult(result);
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

    public WFCallResult CalcNextIAProcessActor(String strWorkflowId, String strCurUserId, String strUserData, String strUserData2, String strUserData3, String strUserData4, String strStepName, String strConnection, String strDescription, String strUserTag, String strUserTag2) {
        WFParam wfParam = new WFParam();
        wfParam.setWorkflowId(strWorkflowId);
        wfParam.setOpPersonId(strCurUserId);
        wfParam.setUserData(strUserData);
        wfParam.setUserData2(strUserData2);
        wfParam.setUserData3(strUserData3);
        wfParam.setUserData4(strUserData4);
        wfParam.setStepId(strStepName);
        wfParam.setConnection(strConnection);
        wfParam.setDescription(strDescription);
        wfParam.setUserTag(strUserTag);
        wfParam.setUserTag2(strUserTag2);
        WFCallResult callResult = new WFCallResult();
        ServiceClient sender = null;
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
                OMElement callMethod = WFClientAPI.GetWFParam("calcnextiaprocessactor", wfParam);
                OMElement result = sender.sendReceive(callMethod);
                callResult = WFClientAPI.GetResult(result);
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

    public WFCallResult TimeoutIAAction(String strWorkflowId, String strCurUserId, String strUserData, String strUserData2, String strUserData3, String strUserData4, String strStepName, String strConnection, String strDescription, String strUserTag, String strUserTag2) {
        WFParam wfParam = new WFParam();
        wfParam.setWorkflowId(strWorkflowId);
        wfParam.setOpPersonId(strCurUserId);
        wfParam.setUserData(strUserData);
        wfParam.setUserData2(strUserData2);
        wfParam.setUserData3(strUserData3);
        wfParam.setUserData4(strUserData4);
        wfParam.setStepId(strStepName);
        wfParam.setConnection(strConnection);
        wfParam.setDescription(strDescription);
        wfParam.setUserTag(strUserTag);
        wfParam.setUserTag2(strUserTag2);
        WFCallResult callResult = new WFCallResult();
        ServiceClient sender = null;
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
                OMElement callMethod = WFClientAPI.GetWFParam("timeoutiaaction", wfParam);
                OMElement result = sender.sendReceive(callMethod);
                callResult = WFClientAPI.GetResult(result);
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

    public WFCallResult RollbackIAAction(String strWorkflowId, String strCurUserId, String strUserData, String strUserData2, String strUserData3, String strUserData4, String strStepName, String strConnection, String strDescription, String strUserTag, String strUserTag2) {
        WFParam wfParam = new WFParam();
        wfParam.setWorkflowId(strWorkflowId);
        wfParam.setOpPersonId(strCurUserId);
        wfParam.setUserData(strUserData);
        wfParam.setUserData2(strUserData2);
        wfParam.setUserData3(strUserData3);
        wfParam.setUserData4(strUserData4);
        wfParam.setStepId(strStepName);
        wfParam.setConnection(strConnection);
        wfParam.setDescription(strDescription);
        wfParam.setUserTag(strUserTag);
        wfParam.setUserTag2(strUserTag2);
        WFCallResult callResult = new WFCallResult();
        ServiceClient sender = null;
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
                OMElement callMethod = WFClientAPI.GetWFParam("rollbackiaaction", wfParam);
                OMElement result = sender.sendReceive(callMethod);
                callResult = WFClientAPI.GetResult(result);
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

    public WFCallResult ResubmitAction(String strWorkflowId, String strCurUserId, String strUserData, String strUserData2, String strUserData3, String strUserData4, String strStepName, String strConnection, String strDescription, String strUserTag, String strUserTag2) {
        WFParam wfParam = new WFParam();
        wfParam.setWorkflowId(strWorkflowId);
        wfParam.setOpPersonId(strCurUserId);
        wfParam.setUserData(strUserData);
        wfParam.setUserData2(strUserData2);
        wfParam.setUserData3(strUserData3);
        wfParam.setUserData4(strUserData4);
        wfParam.setStepId(strStepName);
        wfParam.setConnection(strConnection);
        wfParam.setDescription(strDescription);
        wfParam.setUserTag(strUserTag);
        wfParam.setUserTag2(strUserTag2);
        WFCallResult callResult = new WFCallResult();
        ServiceClient sender = null;
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
                OMElement callMethod = WFClientAPI.GetWFParam("resubmitaction", wfParam);
                OMElement result = sender.sendReceive(callMethod);
                callResult = WFClientAPI.GetResult(result);
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

    public WFCallResult TestSubmitIAAction(String strWorkflowId, String strCurUserId, String strUserData, String strUserData2, String strUserData3, String strUserData4, String strStepName, String strConnection, String strDescription, String strUserTag, String strUserTag2) {
        WFParam wfParam = new WFParam();
        wfParam.setWorkflowId(strWorkflowId);
        wfParam.setOpPersonId(strCurUserId);
        wfParam.setUserData(strUserData);
        wfParam.setUserData2(strUserData2);
        wfParam.setUserData3(strUserData3);
        wfParam.setUserData4(strUserData4);
        wfParam.setStepId(strStepName);
        wfParam.setConnection(strConnection);
        wfParam.setDescription(strDescription);
        wfParam.setUserTag(strUserTag);
        wfParam.setUserTag2(strUserTag2);
        WFCallResult callResult = new WFCallResult();
        ServiceClient sender = null;
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
                OMElement callMethod = WFClientAPI.GetWFParam("testsubmitiaaction", wfParam);
                OMElement result = sender.sendReceive(callMethod);
                callResult = WFClientAPI.GetResult(result);
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

    public WFCallResult UserClose(String strWorkflowId, String strCurUserId, String strUserData, String strUserData2, String strUserData3, String strUserData4, String strDescription) {
        WFParam wfParam = new WFParam();
        wfParam.setWorkflowId(strWorkflowId);
        wfParam.setOpPersonId(strCurUserId);
        wfParam.setUserData(strUserData);
        wfParam.setUserData2(strUserData2);
        wfParam.setUserData3(strUserData3);
        wfParam.setUserData4(strUserData4);
        wfParam.setDescription(strDescription);
        WFCallResult callResult = new WFCallResult();
        ServiceClient sender = null;
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
                OMElement callMethod = WFClientAPI.GetWFParam("userclose", wfParam);
                OMElement result = sender.sendReceive(callMethod);
                callResult = WFClientAPI.GetResult(result);
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

    public WFCallResult MarkReadFlag(String strWorkflowId, String strCurUserId, String strUserData, String strUserData2, String strUserData3, String strUserData4, String strStepName, String strDescription, String strUserTag, String strUserTag2) {
        WFParam wfParam = new WFParam();
        wfParam.setWorkflowId(strWorkflowId);
        wfParam.setOpPersonId(strCurUserId);
        wfParam.setUserData(strUserData);
        wfParam.setUserData2(strUserData2);
        wfParam.setUserData3(strUserData3);
        wfParam.setUserData4(strUserData4);
        wfParam.setDescription(strDescription);
        wfParam.setStepId(strStepName);
        wfParam.setUserTag(strUserTag);
        wfParam.setUserTag2(strUserTag2);
        WFCallResult callResult = new WFCallResult();
        ServiceClient sender = null;
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
                OMElement callMethod = WFClientAPI.GetWFParam("markreadflag", wfParam);
                OMElement result = sender.sendReceive(callMethod);
                callResult = WFClientAPI.GetResult(result);
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

    public WFGetIAActionsResult GetIAActions(String strWorkflowId, String strCurUserId, String strStepId, String strCodeListItemValue, String strUserData, String strUserData2, String strUserData3, String strUserData4) {
        WFParam wfParam = new WFParam();
        wfParam.setWorkflowId(strWorkflowId);
        wfParam.setOpPersonId(strCurUserId);
        wfParam.setStepId(strStepId);
        wfParam.setCodeListItemValue(strCodeListItemValue);
        wfParam.setUserData(strUserData);
        wfParam.setUserData2(strUserData2);
        wfParam.setUserData3(strUserData3);
        wfParam.setUserData4(strUserData4);
        WFGetIAActionsResult callResult = new WFGetIAActionsResult();
        ServiceClient sender = null;
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
                OMElement callMethod = WFClientAPI.GetWFParam("getiaactions", wfParam);
                OMElement result = sender.sendReceive(callMethod);
                callResult = WFClientAPI.GetIAActionsResult(result);
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

    private static WFGetIAActionsResult GetIAActionsResult(OMElement result) {
        WFGetIAActionsResult callResult = new WFGetIAActionsResult();
        try {
            OMNamespace omNs = result.getNamespace();
            String strRetCode = result.getAttributeValue(new QName(omNs.getNamespaceURI(), "retcode"));
            String strErrorInfo = result.getAttributeValue(new QName(omNs.getNamespaceURI(), "errorinfo"));
            callResult.setRetCode(Integer.parseInt(strRetCode));
            callResult.setErrorInfo(strErrorInfo);
            if (callResult.getRetCode() == 0) {
                String strProcessName = result.getAttributeValue(new QName(omNs.getNamespaceURI(), "processname"));
                callResult.setProcessName(strProcessName);
                String strVersion = result.getAttributeValue(new QName(omNs.getNamespaceURI(), "version"));
                callResult.setVersion(Integer.parseInt(strVersion));
                String strUserTag = result.getAttributeValue(new QName(omNs.getNamespaceURI(), "usertag"));
                callResult.setUserTag(strUserTag);
            }
            Iterator iterator = result.getChildElements();
            while (iterator.hasNext()) {
                OMNode omNode = (OMNode)iterator.next();
                if (omNode.getType() != 1) continue;
                OMElement omElement = (OMElement)omNode;
                if (omElement.getLocalName().equals("WFInteractiveActionConfig")) {
                    try {
                        callResult.getIAActionList().add((WFInteractiveActionConfig)((Object)BeanUtil.processObject((OMElement)omElement, WFInteractiveActionConfig.class, null, (boolean)true, (ObjectSupplier)new DefaultObjectSupplier())));
                    }
                    catch (Exception ex) {
                        log.error((Object)"WFInteractiveActionConfig", (Throwable)ex);
                    }
                    continue;
                }
                if (!omElement.getLocalName().equals("WFUserActionConfig")) continue;
                try {
                    callResult.getUserActionList().add((WFUserActionConfig)((Object)BeanUtil.processObject((OMElement)omElement, WFUserActionConfig.class, null, (boolean)true, (ObjectSupplier)new DefaultObjectSupplier())));
                }
                catch (Exception ex) {
                    log.error((Object)"WFUserActionConfig", (Throwable)ex);
                }
            }
            callResult.ReOrder();
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)"[GetResult]\u51fa\u73b0\u9519\u8bef", (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    private static WFCallResult GetResult(OMElement result) {
        WFCallResult callResult = new WFCallResult();
        try {
            OMNamespace omNs = result.getNamespace();
            String strRetCode = result.getAttributeValue(new QName(omNs.getNamespaceURI(), "retcode"));
            String strErrorInfo = result.getAttributeValue(new QName(omNs.getNamespaceURI(), "errorinfo"));
            String strRunInfo = result.getAttributeValue(new QName(omNs.getNamespaceURI(), "runinfo"));
            if (!StringHelper.IsNullOrEmpty((String)strRunInfo)) {
                callResult.setRunInfo(strRunInfo);
            }
            callResult.setRetCode(Integer.parseInt(strRetCode));
            callResult.setErrorInfo(strErrorInfo);
            callResult.setUserObject(WFClientAPI.GetWFParam(result));
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)"[GetResult]\u51fa\u73b0\u9519\u8bef", (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    private static WFParam GetWFParam(OMElement in) {
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

    private static OMElement GetWFParam(String strAction, WFParam wfParam) {
        OMFactory fac = OMAbstractFactory.getOMFactory();
        OMNamespace omNs = fac.createOMNamespace("http://www.softanywhere.com/", "srfwf");
        OMElement method = fac.createOMElement(strAction, omNs);
        XMLStreamReader reader = BeanUtil.getPullParser((Object)wfParam);
        StreamWrapper parser = new StreamWrapper(reader);
        StAXOMBuilder stAXOMBuilder = OMXMLBuilderFactory.createStAXOMBuilder((OMFactory)OMAbstractFactory.getOMFactory(), (XMLStreamReader)parser);
        OMElement element = stAXOMBuilder.getDocumentElement();
        method.addChild((OMNode)element);
        return method;
    }
}

