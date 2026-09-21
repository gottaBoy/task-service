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

public class TCPIBConfigWriter
extends InboundConfigWriter {
    public TCPIBConfigWriter() {
        this.bTestAppInt = true;
    }

    @Override
    public CallResult ExportConnector(SimpleXMLWriter xmlWriter) {
        CallResult callResult = new CallResult();
        if (!StringHelper.IsNullOrEmpty((String)this.processConfig.getProcessConfigId())) {
            xmlWriter.WriteStartElement("tcp:connector");
            xmlWriter.WriteAttributeString("name", "tcp_" + this.processConfig.getID());
            xmlWriter.WriteStartElement("tcp:direct-protocol");
            xmlWriter.WriteAttributeString("payloadOnly", "true");
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
        if (!StringHelper.IsNullOrEmpty((String)this.processConfig.getProcessConfigId())) {
            String strEncode;
            String strHost;
            xmlWriter.WriteStartElement("inbound");
            xmlWriter.WriteStartElement("tcp:inbound-endpoint");
            int nPort = this.eaiAppInt.getPORT(0);
            if (nPort > 0) {
                xmlWriter.WriteAttributeString("port", StringHelper.Format((String)"%1$s", (Object)nPort));
            }
            if (!StringHelper.IsNullOrEmpty((String)(strHost = this.eaiAppInt.getHOSTNAME()))) {
                xmlWriter.WriteAttributeString("host", strHost);
            }
            xmlWriter.WriteAttributeString("connector-ref", "tcp_" + this.processConfig.getID());
            if (this.eaiAppInt.getSYNCMODE()) {
                xmlWriter.WriteAttributeString("synchronous", "true");
            }
            if (!StringHelper.IsNullOrEmpty((String)(strEncode = this.eaiProcessConfig.getPARAM10()))) {
                xmlWriter.WriteAttributeString("encoding", strEncode);
            }
            this.AppendEndPointProtocol(xmlWriter);
            xmlWriter.WriteEndElement();
            xmlWriter.WriteEndElement();
        }
        this.ExportOutbound(xmlWriter);
        xmlWriter.WriteEndElement();
        return callResult;
    }
}

