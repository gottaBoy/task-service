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

public class JDBCOBConfigWriter
extends OutboundConfigWriter {
    @Override
    public CallResult ExportConnector(SimpleXMLWriter xmlWriter) {
        CallResult callResult = new CallResult();
        if (!StringHelper.IsNullOrEmpty((String)this.processConfig.getProcessConfigId())) {
            xmlWriter.WriteStartElement("jdbc:connector");
            xmlWriter.WriteAttributeString("name", "jdbc_" + this.processConfig.getID());
            xmlWriter.WriteAttributeString("dataSource-ref", this.eaiProcessConfig.getEAIDATASOURCEID());
            xmlWriter.WriteStartElement("jdbc:query");
            xmlWriter.WriteAttributeString("key", "default");
            xmlWriter.WriteAttributeString("value", this.eaiProcessConfig.getPARAM3());
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
        if (!StringHelper.IsNullOrEmpty((String)this.processConfig.getProcessConfigId())) {
            xmlWriter.WriteStartElement("outbound");
            xmlWriter.WriteStartElement("pass-through-router");
            xmlWriter.WriteStartElement("jdbc:outbound-endpoint");
            xmlWriter.WriteAttributeString("queryKey", "default");
            xmlWriter.WriteAttributeString("connector-ref", "jdbc_" + this.processConfig.getID());
            this.ExportTransaction(xmlWriter);
            xmlWriter.WriteEndElement();
            xmlWriter.WriteEndElement();
            xmlWriter.WriteEndElement();
        }
        xmlWriter.WriteEndElement();
        return callResult;
    }
}

