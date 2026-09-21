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

public class WebServiceIBConfigWriter
extends InboundConfigWriter {
    public WebServiceIBConfigWriter() {
        this.bTestAppInt = true;
    }

    @Override
    public CallResult ExportService(SimpleXMLWriter xmlWriter) {
        CallResult callResult = new CallResult();
        xmlWriter.WriteComment(this.processConfig.getLogicName());
        xmlWriter.WriteStartElement("service");
        xmlWriter.WriteAttributeString("name", this.processConfig.getID());
        xmlWriter.WriteStartElement("inbound");
        xmlWriter.WriteStartElement("inbound-endpoint");
        String strURL = "cxf:http://";
        String strHost = this.eaiAppInt.getHOSTNAME();
        strURL = String.valueOf(strURL) + strHost;
        int nPort = this.eaiAppInt.getPORT(0);
        if (nPort > 0) {
            strURL = String.valueOf(strURL) + StringHelper.Format((String)":%1$s", (Object)nPort);
        }
        strURL = String.valueOf(strURL) + this.eaiAppInt.getPARAM();
        xmlWriter.WriteAttributeString("address", strURL);
        xmlWriter.WriteEndElement();
        xmlWriter.WriteEndElement();
        String strProcessObject = this.eaiAppInt.getPARAM3();
        xmlWriter.WriteStartElement("component");
        xmlWriter.WriteStartElement("singleton-object");
        xmlWriter.WriteAttributeString("class", strProcessObject);
        xmlWriter.WriteEndElement();
        xmlWriter.WriteEndElement();
        this.ExportOutbound(xmlWriter);
        xmlWriter.WriteEndElement();
        return callResult;
    }
}

