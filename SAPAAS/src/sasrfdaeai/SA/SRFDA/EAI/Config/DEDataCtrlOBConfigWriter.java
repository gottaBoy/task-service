/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  SA.SRFramework.XML.SimpleXMLWriter
 */
package SA.SRFDA.EAI.Config;

import SA.SRFDA.EAI.Config.OutboundConfigWriter;
import SA.SRFDA.EAI.Endpoint.DEDataCtrlEndpoint;
import SA.SRFDA.EAI.Endpoint.ProcessConfig;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import SA.SRFramework.XML.SimpleXMLWriter;
import java.util.Enumeration;
import java.util.Properties;

public class DEDataCtrlOBConfigWriter
extends OutboundConfigWriter {
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
            xmlWriter.WriteStartElement("spring:entry");
            xmlWriter.WriteAttributeString("key", "DEID");
            xmlWriter.WriteAttributeString("value", this.eaiProcessConfig.getPARAM4());
            xmlWriter.WriteEndElement();
            xmlWriter.WriteStartElement("spring:entry");
            xmlWriter.WriteAttributeString("key", "ACTION");
            xmlWriter.WriteAttributeString("value", this.eaiProcessConfig.getPARAM5());
            xmlWriter.WriteEndElement();
            xmlWriter.WriteStartElement("spring:entry");
            xmlWriter.WriteAttributeString("key", "ACTIONMODE");
            xmlWriter.WriteAttributeString("value", this.eaiProcessConfig.getPARAM8());
            xmlWriter.WriteEndElement();
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
        String strObject = this.eaiProcessConfig.getCOMOBJECT();
        if (StringHelper.IsNullOrEmpty((String)strObject)) {
            strObject = DEDataCtrlEndpoint.class.getName();
        }
        xmlWriter.WriteStartElement("component");
        xmlWriter.WriteAttributeString("class", strObject);
        xmlWriter.WriteEndElement();
        xmlWriter.WriteEndElement();
        return callResult;
    }
}

