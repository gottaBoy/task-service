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

public class TCPOBConfigWriter
extends OutboundConfigWriter {
    public TCPOBConfigWriter() {
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
        this.ExportInbound(xmlWriter);
        if (!StringHelper.IsNullOrEmpty((String)this.processConfig.getProcessConfigId())) {
            String strHost;
            xmlWriter.WriteStartElement("outbound");
            xmlWriter.WriteStartElement("pass-through-router");
            xmlWriter.WriteStartElement("tcp:outbound-endpoint");
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
        xmlWriter.WriteEndElement();
        return callResult;
    }
}

