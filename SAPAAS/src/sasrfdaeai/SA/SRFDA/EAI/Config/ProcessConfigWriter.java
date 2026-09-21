/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  SA.SRFramework.XML.SimpleXMLWriter
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.EAI.Config;

import SA.SRFDA.EAI.Config.BaseConfigWriter;
import SA.SRFDA.EAI.Ctrl.Data.EAIProcessType;
import SA.SRFDA.EAI.Endpoint.ProcessConfig;
import SA.SRFDA.EAI.Model.EAIProcessConfig;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import SA.SRFramework.XML.SimpleXMLWriter;
import java.util.Enumeration;
import java.util.Properties;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ProcessConfigWriter
extends BaseConfigWriter {
    private EAIProcessType processType = null;
    private static final Log log = LogFactory.getLog(ProcessConfigWriter.class);

    @Override
    protected CallResult OnInit() {
        CallResult callResult = super.OnInit();
        EAIProcessConfig realProcessConfig = (EAIProcessConfig)this.processConfig;
        String strProcessType = realProcessConfig.getProcessType();
        if (StringHelper.IsNullOrEmpty((String)strProcessType)) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u96c6\u6210\u5904\u7406\u7c7b\u578b"));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        this.processType = new EAIProcessType();
        callResult = this.configWriterContext.getEAIDataCtrl().GetProcessType(strProcessType, this.processType);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5904\u7406\u7c7b\u578b[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strProcessType, (Object)callResult.getErrorInfo()));
            return callResult;
        }
        return callResult;
    }

    @Override
    public CallResult ExportConnector(SimpleXMLWriter xmlWriter) {
        CallResult callResult = new CallResult();
        if (!StringHelper.IsNullOrEmpty((String)this.processConfig.getProcessConfigId())) {
            xmlWriter.WriteStartElement("spring:bean");
            xmlWriter.WriteAttributeString("id", "cfg_" + this.processConfig.getID());
            xmlWriter.WriteAttributeString("class", ProcessConfig.class.getName());
            xmlWriter.WriteStartElement("spring:property");
            xmlWriter.WriteAttributeString("name", "config");
            xmlWriter.WriteStartElement("spring:map");
            if (!StringHelper.IsNullOrEmpty((String)this.processType.getEXTPARAM())) {
                String strExtParams = this.processType.getEXTPARAM();
                strExtParams = strExtParams.replace("\r", ";");
                strExtParams = strExtParams.replace("\n", ";");
                String[] params = strExtParams.split("[;]");
                int i = 0;
                while (i < params.length) {
                    String strValue;
                    String strParam = params[i];
                    if (!StringHelper.IsNullOrEmpty((String)(strParam = strParam.trim())) && !StringHelper.IsNullOrEmpty((String)(strValue = this.eaiProcessConfig.GetParamStringValue(strParam, "")))) {
                        xmlWriter.WriteStartElement("spring:entry");
                        xmlWriter.WriteAttributeString("key", "@" + strParam);
                        xmlWriter.WriteAttributeString("value", strValue);
                        xmlWriter.WriteEndElement();
                    }
                    ++i;
                }
            }
            if (!StringHelper.IsNullOrEmpty((String)this.eaiProcessConfig.getPARAMS())) {
                try {
                    Properties properties = PropertiesHelper.Load((String)this.eaiProcessConfig.getPARAMS());
                    Enumeration<Object> en = properties.keys();
                    while (en.hasMoreElements()) {
                        String strKey = (String)en.nextElement();
                        String strValue = PropertiesHelper.GetProperty((Properties)properties, (String)strKey);
                        xmlWriter.WriteStartElement("spring:entry");
                        xmlWriter.WriteAttributeString("key", strKey);
                        xmlWriter.WriteAttributeString("value", strValue);
                        xmlWriter.WriteEndElement();
                    }
                }
                catch (Exception ex) {
                    callResult.setRetCode(1);
                    callResult.setErrorInfo("\u52a0\u8f7d\u5904\u7406\u6269\u5c55\u53c2\u6570\u5931\u8d25");
                    return callResult;
                }
            }
            xmlWriter.WriteEndElement();
            xmlWriter.WriteEndElement();
            xmlWriter.WriteEndElement();
        }
        return callResult;
    }

    @Override
    public CallResult ExportService(SimpleXMLWriter xmlWriter) {
        CallResult callResult = new CallResult();
        xmlWriter.WriteComment(this.processConfig.getLogicName());
        xmlWriter.WriteStartElement("service");
        xmlWriter.WriteAttributeString("name", this.processConfig.getID());
        this.ExportInbound(xmlWriter);
        String strProcessObject = this.eaiProcessConfig.getPARAM3();
        if (StringHelper.IsNullOrEmpty((String)strProcessObject)) {
            strProcessObject = this.processType.getPROCESSOBJECT();
        }
        if (!StringHelper.IsNullOrEmpty((String)strProcessObject)) {
            xmlWriter.WriteStartElement("component");
            xmlWriter.WriteAttributeString("class", strProcessObject);
            xmlWriter.WriteEndElement();
        }
        EAIProcessConfig realProcessConfig = (EAIProcessConfig)this.processConfig;
        this.ExportProcessOutbound(xmlWriter);
        xmlWriter.WriteEndElement();
        return callResult;
    }

    protected void ExportProcessOutbound(SimpleXMLWriter xmlWriter) {
        EAIProcessConfig realProcessConfig = (EAIProcessConfig)this.processConfig;
        String strNext = realProcessConfig.getNext();
        if (!StringHelper.IsNullOrEmpty((String)strNext)) {
            xmlWriter.WriteStartElement("outbound");
            xmlWriter.WriteStartElement("pass-through-router");
            xmlWriter.WriteStartElement("vm:outbound-endpoint");
            xmlWriter.WriteAttributeString("path", "vm_" + this.configWriterContext.getServiceId() + "_" + this.processConfig.getID());
            if (this.eaiProcessConfig.getSYNCMODE()) {
                xmlWriter.WriteAttributeString("synchronous", "true");
            }
            if (this.outProtocol != null) {
                xmlWriter.WriteAttributeString("transformer-refs", "out_" + this.processConfig.getID());
            }
            if (this.inProtocol != null) {
                xmlWriter.WriteAttributeString("responseTransformer-refs", "in_" + this.processConfig.getID());
            }
            xmlWriter.WriteEndElement();
            xmlWriter.WriteEndElement();
            xmlWriter.WriteEndElement();
        }
    }
}

