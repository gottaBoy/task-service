/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.XML.SimpleXMLWriter
 */
package SA.SRFDA.EAI.Config;

import SA.SRFDA.EAI.Config.BaseConfigWriter;
import SA.SRFDA.EAI.Model.EAIInboundProcessConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.XML.SimpleXMLWriter;

public class InboundConfigWriter
extends BaseConfigWriter {
    protected void ExportOutbound(SimpleXMLWriter xmlWriter) {
        EAIInboundProcessConfig inboundProcessConfig = (EAIInboundProcessConfig)this.processConfig;
        String strNext = inboundProcessConfig.getNext();
        if (!StringHelper.IsNullOrEmpty((String)strNext)) {
            xmlWriter.WriteStartElement("outbound");
            xmlWriter.WriteStartElement("pass-through-router");
            xmlWriter.WriteStartElement("vm:outbound-endpoint");
            xmlWriter.WriteAttributeString("path", "vm_" + this.configWriterContext.getServiceId() + "_" + this.processConfig.getID());
            if (this.eaiAppInt != null && this.eaiAppInt.getSYNCMODE()) {
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

