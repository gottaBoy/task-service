/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  SA.SRFramework.XML.SimpleXMLWriter
 */
package SA.SRFDA.EAI.Config;

import SA.SRFDA.EAI.Config.ISRFEAIConfigWriter;
import SA.SRFDA.EAI.Config.ISRFEAIConfigWriterContext;
import SA.SRFDA.EAI.Ctrl.Data.EAIAppInt;
import SA.SRFDA.EAI.Ctrl.Data.EAIProcessConfig;
import SA.SRFDA.EAI.Ctrl.Data.EAIProtocol;
import SA.SRFDA.EAI.Model.EAIBaseConnectionConfig;
import SA.SRFDA.EAI.Model.EAIBaseProcessConfig;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import SA.SRFramework.XML.SimpleXMLWriter;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;

public class BaseConfigWriter
implements ISRFEAIConfigWriter {
    protected EAIProcessConfig eaiProcessConfig = new EAIProcessConfig();
    protected EAIBaseProcessConfig processConfig;
    protected EAIAppInt eaiAppInt = null;
    protected ISRFEAIConfigWriterContext configWriterContext;
    protected EAIProtocol inProtocol = null;
    protected EAIProtocol outProtocol = null;
    protected boolean bTestAppInt = false;

    @Override
    public String GetDataSourceId() {
        return this.eaiProcessConfig.getEAIDATASOURCEID();
    }

    @Override
    public CallResult Init(EAIBaseProcessConfig processConfig, ISRFEAIConfigWriterContext configWriterContext) {
        CallResult callResult = new CallResult();
        this.processConfig = processConfig;
        this.configWriterContext = configWriterContext;
        if (StringHelper.IsNullOrEmpty((String)processConfig.getProcessConfigId())) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u5904\u7406[%1$s][%2$s]\u5177\u4f53\u914d\u7f6e", (Object)processConfig.getID(), (Object)processConfig.getName()));
            return callResult;
        }
        callResult = configWriterContext.getEAIDataCtrl().GetProcessConfig(processConfig.getProcessConfigId(), this.eaiProcessConfig);
        if (callResult.IsError()) {
            return callResult;
        }
        if (!StringHelper.IsNullOrEmpty((String)this.eaiProcessConfig.getEAIAPPINTID())) {
            this.eaiAppInt = new EAIAppInt();
            callResult = configWriterContext.getEAIDataCtrl().GetAppInt(this.eaiProcessConfig.getEAIAPPINTID(), this.eaiAppInt);
            if (callResult.IsError()) {
                return callResult;
            }
        }
        if (this.bTestAppInt && this.eaiAppInt == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u5904\u7406[%1$s][%2$s]\u5fc5\u987b\u6307\u5b9a\u63a5\u53e3", (Object)this.eaiProcessConfig.getEAIPROCESSCONFIGNAME(), (Object)this.eaiProcessConfig.getEAIPROCESSCONFIGID()));
            return callResult;
        }
        if (this.eaiAppInt != null) {
            if (!StringHelper.IsNullOrEmpty((String)this.eaiAppInt.getEAIOUTPROID())) {
                this.outProtocol = new EAIProtocol();
                callResult = configWriterContext.getEAIDataCtrl().GetProtocol(this.eaiAppInt.getEAIOUTPROID(), this.outProtocol);
                if (callResult.IsError()) {
                    return callResult;
                }
            }
            if (!StringHelper.IsNullOrEmpty((String)this.eaiAppInt.getEAIINPROID())) {
                this.inProtocol = new EAIProtocol();
                callResult = configWriterContext.getEAIDataCtrl().GetProtocol(this.eaiAppInt.getEAIINPROID(), this.inProtocol);
                if (callResult.IsError()) {
                    return callResult;
                }
            }
        }
        return this.OnInit();
    }

    protected CallResult OnInit() {
        return new CallResult();
    }

    @Override
    public CallResult ExportProtocol(SimpleXMLWriter xmlWriter) {
        String strValue;
        String strKey;
        Enumeration<Object> en;
        Properties properties;
        CallResult callResult = new CallResult();
        if (this.outProtocol != null && !StringHelper.IsNullOrEmpty((String)this.outProtocol.getTRANSFORMER())) {
            xmlWriter.WriteStartElement("custom-transformer");
            xmlWriter.WriteAttributeString("name", "out_" + this.processConfig.getID());
            xmlWriter.WriteAttributeString("class", this.outProtocol.getTRANSFORMER());
            if (!StringHelper.IsNullOrEmpty((String)this.eaiProcessConfig.getOBTSFPARAMS())) {
                xmlWriter.WriteStartElement("spring:property");
                xmlWriter.WriteAttributeString("name", "config");
                xmlWriter.WriteStartElement("spring:map");
                try {
                    properties = PropertiesHelper.Load((String)this.eaiProcessConfig.getOBTSFPARAMS());
                    en = properties.keys();
                    while (en.hasMoreElements()) {
                        strKey = (String)en.nextElement();
                        strValue = PropertiesHelper.GetProperty((Properties)properties, (String)strKey);
                        xmlWriter.WriteStartElement("spring:entry");
                        xmlWriter.WriteAttributeString("key", strKey);
                        xmlWriter.WriteAttributeString("value", strValue);
                        xmlWriter.WriteEndElement();
                    }
                }
                catch (Exception ex) {
                    callResult.setRetCode(1);
                    callResult.setErrorInfo("\u52a0\u8f7d\u534f\u8bae\u8f6c\u6362\u5668\u53c2\u6570\u5931\u8d25");
                    return callResult;
                }
                xmlWriter.WriteEndElement();
                xmlWriter.WriteEndElement();
            }
            xmlWriter.WriteEndElement();
        }
        if (this.inProtocol != null && !StringHelper.IsNullOrEmpty((String)this.inProtocol.getTRANSFORMER())) {
            xmlWriter.WriteStartElement("custom-transformer");
            xmlWriter.WriteAttributeString("name", "in_" + this.processConfig.getID());
            xmlWriter.WriteAttributeString("class", this.inProtocol.getTRANSFORMER());
            if (!StringHelper.IsNullOrEmpty((String)this.eaiProcessConfig.getOBREPTSFPARAMS())) {
                xmlWriter.WriteStartElement("spring:property");
                xmlWriter.WriteAttributeString("name", "config");
                xmlWriter.WriteStartElement("spring:map");
                try {
                    properties = PropertiesHelper.Load((String)this.eaiProcessConfig.getOBREPTSFPARAMS());
                    en = properties.keys();
                    while (en.hasMoreElements()) {
                        strKey = (String)en.nextElement();
                        strValue = PropertiesHelper.GetProperty((Properties)properties, (String)strKey);
                        xmlWriter.WriteStartElement("spring:entry");
                        xmlWriter.WriteAttributeString("key", strKey);
                        xmlWriter.WriteAttributeString("value", strValue);
                        xmlWriter.WriteEndElement();
                    }
                }
                catch (Exception ex) {
                    callResult.setRetCode(1);
                    callResult.setErrorInfo("\u52a0\u8f7d\u534f\u8bae\u8f6c\u6362\u5668\u53c2\u6570\u5931\u8d25");
                    return callResult;
                }
                xmlWriter.WriteEndElement();
                xmlWriter.WriteEndElement();
            }
            xmlWriter.WriteEndElement();
        }
        return callResult;
    }

    protected void AppendEndPointProtocol(SimpleXMLWriter xmlWriter) {
    }

    protected void AppendOutboundProtocol(SimpleXMLWriter xmlWriter) {
        if (this.outProtocol != null) {
            xmlWriter.WriteAttributeString("transformer-refs", "out_" + this.processConfig.getID());
        }
        if (this.inProtocol != null) {
            xmlWriter.WriteAttributeString("responseTransformer-refs", "in_" + this.processConfig.getID());
        }
    }

    @Override
    public CallResult ExportConnector(SimpleXMLWriter xmlWriter) {
        return new CallResult();
    }

    @Override
    public CallResult ExportService(SimpleXMLWriter xmlWriter) {
        return new CallResult();
    }

    protected void ExportInbound(SimpleXMLWriter xmlWriter) {
        Vector<XMLConfig> inbounds = new Vector<XMLConfig>();
        this.configWriterContext.getEAIConfig().getProcessesConfig().GetProcessInbounds(this.processConfig.getID(), inbounds);
        if (inbounds.size() > 0) {
            xmlWriter.WriteStartElement("inbound");
            for (XMLConfig xmlConfig : inbounds) {
                if (xmlConfig instanceof SA.SRFDA.EAI.Model.EAIProcessConfig) {
                    SA.SRFDA.EAI.Model.EAIProcessConfig processConfig = (SA.SRFDA.EAI.Model.EAIProcessConfig)xmlConfig;
                    EAIProcessConfig eaiProcessConfig = new EAIProcessConfig();
                    CallResult callResult = this.configWriterContext.getEAIDataCtrl().GetProcessConfig(processConfig.getProcessConfigId(), eaiProcessConfig);
                    xmlWriter.WriteStartElement("vm:inbound-endpoint");
                    xmlWriter.WriteAttributeString("path", "vm_" + this.configWriterContext.getServiceId() + "_" + xmlConfig.getID());
                    if (!callResult.IsError() && eaiProcessConfig.getSYNCMODE()) {
                        xmlWriter.WriteAttributeString("synchronous", "true");
                    }
                    this.AppendOutboundProtocol(xmlWriter);
                    xmlWriter.WriteEndElement();
                    continue;
                }
                if (!(xmlConfig instanceof EAIBaseConnectionConfig)) continue;
                xmlWriter.WriteStartElement("vm:inbound-endpoint");
                xmlWriter.WriteAttributeString("path", "vm_" + this.configWriterContext.getServiceId() + "_" + xmlConfig.getID());
                this.AppendOutboundProtocol(xmlWriter);
                xmlWriter.WriteEndElement();
            }
            xmlWriter.WriteEndElement();
        }
    }

    public void ExportTransaction(SimpleXMLWriter xmlWriter) {
    }
}

