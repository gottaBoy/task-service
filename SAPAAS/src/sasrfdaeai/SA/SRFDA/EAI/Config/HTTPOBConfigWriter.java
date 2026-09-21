/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.XML.SimpleXMLWriter
 */
package SA.SRFDA.EAI.Config;

import SA.SRFDA.EAI.Config.OutboundConfigWriter;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.XML.SimpleXMLWriter;

public class HTTPOBConfigWriter
extends OutboundConfigWriter {
    @Override
    public CallResult ExportService(SimpleXMLWriter xmlWriter) {
        CallResult callResult = new CallResult();
        xmlWriter.WriteComment(this.processConfig.getLogicName());
        xmlWriter.WriteStartElement("service");
        xmlWriter.WriteAttributeString("name", this.processConfig.getID());
        this.ExportInbound(xmlWriter);
        if (!StringHelper.IsNullOrEmpty((String)this.processConfig.getProcessConfigId())) {
            boolean bKeepAlive;
            xmlWriter.WriteStartElement("outbound");
            xmlWriter.WriteStartElement("pass-through-router");
            xmlWriter.WriteStartElement("http:outbound-endpoint");
            String strUserName = this.eaiProcessConfig.getPARAM7();
            String strPassword = this.eaiProcessConfig.getPARAM8();
            String strHost = this.eaiProcessConfig.getPARAM4();
            int nPort = this.eaiProcessConfig.getPARAM1(8999);
            String strPath = this.eaiProcessConfig.getPARAM3();
            String strContentType = this.eaiProcessConfig.getPARAM9();
            String strMethod = this.eaiProcessConfig.getPARAM10();
            boolean bl = bKeepAlive = this.eaiProcessConfig.getPARAM2(0) == 1;
            if (!StringHelper.IsNullOrEmpty((String)strUserName)) {
                xmlWriter.WriteAttributeString("name", strUserName);
            }
            if (!StringHelper.IsNullOrEmpty((String)strPassword)) {
                xmlWriter.WriteAttributeString("password", strPassword);
            }
            if (!StringHelper.IsNullOrEmpty((String)strHost)) {
                xmlWriter.WriteAttributeString("host", strHost);
            }
            if (nPort > 0) {
                xmlWriter.WriteAttributeString("port", StringHelper.Format((String)"%1$s", (Object)nPort));
            }
            if (!StringHelper.IsNullOrEmpty((String)strPath)) {
                xmlWriter.WriteAttributeString("path", strPath);
            }
            if (!StringHelper.IsNullOrEmpty((String)strContentType)) {
                xmlWriter.WriteAttributeString("contentType", strContentType);
            }
            if (!StringHelper.IsNullOrEmpty((String)strMethod)) {
                xmlWriter.WriteAttributeString("method", strMethod);
            }
            if (bKeepAlive) {
                xmlWriter.WriteAttributeString("keep-alive", "true");
            }
            xmlWriter.WriteEndElement();
            xmlWriter.WriteEndElement();
            xmlWriter.WriteEndElement();
        }
        xmlWriter.WriteEndElement();
        return callResult;
    }
}

