/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.XML.SimpleXMLWriter
 */
package SA.SRFDA.EAI.Config;

import SA.SRFDA.EAI.Config.InboundConfigWriter;
import SA.SRFDA.EAI.Endpoint.ISimpleWebService;
import SA.SRFDA.EAI.Endpoint.SimpleWSEndpoint;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.XML.SimpleXMLWriter;

public class SimpleWSIBConfigWriter
extends InboundConfigWriter {
    public SimpleWSIBConfigWriter() {
        this.bTestAppInt = true;
    }

    @Override
    public CallResult ExportConnector(SimpleXMLWriter xmlWriter) {
        CallResult callResult = new CallResult();
        if (!StringHelper.IsNullOrEmpty((String)this.processConfig.getProcessConfigId())) {
            xmlWriter.WriteStartElement("axis:connector");
            xmlWriter.WriteAttributeString("name", "axis_" + this.processConfig.getID());
            xmlWriter.WriteEndElement();
        }
        return callResult;
    }

    @Override
    public CallResult ExportService(SimpleXMLWriter xmlWriter) {
        CallResult callResult = new CallResult();
        xmlWriter.WriteComment(this.processConfig.getLogicName());
        xmlWriter.WriteStartElement("service");
        xmlWriter.WriteAttributeString("name", this.eaiAppInt.getPARAM2());
        if (!StringHelper.IsNullOrEmpty((String)this.processConfig.getProcessConfigId())) {
            xmlWriter.WriteStartElement("inbound");
            xmlWriter.WriteStartElement("axis:inbound-endpoint");
            StringBuilderEx servicePath = new StringBuilderEx();
            servicePath.Append("http://%1$s", (Object)this.eaiAppInt.getHOSTNAME());
            if (this.eaiAppInt.getPORT(80) != 80) {
                servicePath.Append(":%1$s", (Object)this.eaiAppInt.getPORT(80));
            }
            servicePath.Append("/");
            servicePath.Append(this.eaiAppInt.getPARAM());
            xmlWriter.WriteAttributeString("address", servicePath.toString());
            xmlWriter.WriteAttributeString("style", "RPC");
            xmlWriter.WriteAttributeString("use", "LITERAL");
            if (this.eaiAppInt.getSYNCMODE()) {
                xmlWriter.WriteAttributeString("synchronous", "true");
            }
            xmlWriter.WriteAttributeString("connector-ref", "axis_" + this.processConfig.getID());
            this.AppendEndPointProtocol(xmlWriter);
            xmlWriter.WriteStartElement("axis:soap-service");
            xmlWriter.WriteAttributeString("interface", ISimpleWebService.class.getName());
            xmlWriter.WriteEndElement();
            xmlWriter.WriteEndElement();
            xmlWriter.WriteEndElement();
        }
        xmlWriter.WriteStartElement("component");
        String strObject = this.eaiProcessConfig.getCOMOBJECT();
        if (StringHelper.IsNullOrEmpty((String)strObject)) {
            strObject = SimpleWSEndpoint.class.getName();
        }
        xmlWriter.WriteAttributeString("class", strObject);
        xmlWriter.WriteEndElement();
        this.ExportOutbound(xmlWriter);
        xmlWriter.WriteEndElement();
        return callResult;
    }
}

