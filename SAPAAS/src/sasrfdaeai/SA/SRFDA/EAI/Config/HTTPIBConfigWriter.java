/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.XML.SimpleXMLWriter
 */
package SA.SRFDA.EAI.Config;

import SA.SRFDA.EAI.Config.InboundConfigWriter;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.XML.SimpleXMLWriter;

public class HTTPIBConfigWriter
extends InboundConfigWriter {
    @Override
    public CallResult ExportConnector(SimpleXMLWriter xmlWriter) {
        CallResult callResult = new CallResult();
        if (!StringHelper.IsNullOrEmpty((String)this.processConfig.getProcessConfigId())) {
            boolean bKeepAlive = this.eaiProcessConfig.getPARAM2(0) == 1;
            xmlWriter.WriteStartElement("http:connector");
            xmlWriter.WriteAttributeString("name", "http_" + this.processConfig.getID());
            if (bKeepAlive) {
                xmlWriter.WriteAttributeString("keep-alive", "true");
            }
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
        if (!StringHelper.IsNullOrEmpty((String)this.processConfig.getProcessConfigId())) {
            xmlWriter.WriteStartElement("inbound");
            xmlWriter.WriteStartElement("http:inbound-endpoint");
            String strUserName = this.eaiAppInt.getUSERNAME();
            String strPassword = this.eaiAppInt.getPWD();
            String strHost = this.eaiAppInt.getHOSTNAME();
            int nPort = this.eaiAppInt.getPORT(8999);
            String strPath = this.eaiAppInt.getPARAM();
            String strContentType = this.eaiAppInt.getPARAM2();
            String strMethod = this.eaiAppInt.getPARAM6();
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
            xmlWriter.WriteAttributeString("connector-ref", "http_" + this.processConfig.getID());
            this.AppendEndPointProtocol(xmlWriter);
            xmlWriter.WriteEndElement();
            xmlWriter.WriteEndElement();
        }
        this.ExportOutbound(xmlWriter);
        xmlWriter.WriteEndElement();
        return callResult;
    }
}

