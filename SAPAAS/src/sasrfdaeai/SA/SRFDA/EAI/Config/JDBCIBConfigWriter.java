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

public class JDBCIBConfigWriter
extends InboundConfigWriter {
    @Override
    public CallResult ExportConnector(SimpleXMLWriter xmlWriter) {
        CallResult callResult = new CallResult();
        if (!StringHelper.IsNullOrEmpty((String)this.processConfig.getProcessConfigId())) {
            xmlWriter.WriteStartElement("jdbc:connector");
            xmlWriter.WriteAttributeString("name", "jdbc_" + this.processConfig.getID());
            xmlWriter.WriteAttributeString("dataSource-ref", this.eaiProcessConfig.getEAIDATASOURCEID());
            int nFrequency = this.eaiProcessConfig.getPARAM1(10000);
            if (nFrequency <= 0) {
                nFrequency = 10000;
            }
            xmlWriter.WriteAttributeString("pollingFrequency", StringHelper.Format((String)"%1$s", (Object)nFrequency));
            xmlWriter.WriteStartElement("jdbc:query");
            xmlWriter.WriteAttributeString("key", "default");
            xmlWriter.WriteAttributeString("value", this.eaiProcessConfig.getPARAM3());
            xmlWriter.WriteEndElement();
            if (!StringHelper.IsNullOrEmpty((String)this.eaiProcessConfig.getPARAMS())) {
                xmlWriter.WriteStartElement("jdbc:query");
                xmlWriter.WriteAttributeString("key", "default.ack");
                xmlWriter.WriteAttributeString("value", this.eaiProcessConfig.getPARAMS());
                xmlWriter.WriteEndElement();
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
            xmlWriter.WriteStartElement("jdbc:inbound-endpoint");
            xmlWriter.WriteAttributeString("queryKey", "default");
            xmlWriter.WriteAttributeString("connector-ref", "jdbc_" + this.processConfig.getID());
            this.ExportTransaction(xmlWriter);
            xmlWriter.WriteEndElement();
            xmlWriter.WriteEndElement();
        }
        this.ExportOutbound(xmlWriter);
        xmlWriter.WriteEndElement();
        return callResult;
    }
}

