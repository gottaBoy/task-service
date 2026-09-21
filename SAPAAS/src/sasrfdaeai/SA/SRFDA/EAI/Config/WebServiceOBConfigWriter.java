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

public class WebServiceOBConfigWriter
extends OutboundConfigWriter {
    public WebServiceOBConfigWriter() {
        this.bTestAppInt = true;
    }

    @Override
    public CallResult ExportService(SimpleXMLWriter xmlWriter) {
        CallResult callResult = new CallResult();
        String strWebServiceURL = this.eaiAppInt.getPARAM();
        String strClientClass = this.eaiAppInt.getPARAM4();
        String strOperation = this.eaiAppInt.getPARAM5();
        String strWSDLPort = this.eaiAppInt.getPARAM6();
        if (StringHelper.IsNullOrEmpty((String)strClientClass)) {
            callResult.setRetCode(1);
            callResult.setErrorInfo("\u6ca1\u6709\u4e3aWebService\u6307\u5b9a\u4ee3\u7406\u670d\u52a1\u7c7b");
            return callResult;
        }
        if (StringHelper.IsNullOrEmpty((String)strOperation)) {
            callResult.setRetCode(1);
            callResult.setErrorInfo("\u6ca1\u6709\u4e3aWebService\u6307\u5b9a\u8c03\u7528\u65b9\u6cd5");
            return callResult;
        }
        if (StringHelper.IsNullOrEmpty((String)strWSDLPort)) {
            callResult.setRetCode(1);
            callResult.setErrorInfo("\u6ca1\u6709\u4e3aWebService\u6307\u5b9a WSDL \u7aef\u70b9");
            return callResult;
        }
        xmlWriter.WriteComment(this.processConfig.getLogicName());
        xmlWriter.WriteStartElement("service");
        xmlWriter.WriteAttributeString("name", this.processConfig.getID());
        this.ExportInbound(xmlWriter);
        if (!StringHelper.IsNullOrEmpty((String)this.processConfig.getProcessConfigId())) {
            xmlWriter.WriteStartElement("outbound");
            xmlWriter.WriteStartElement("pass-through-router");
            xmlWriter.WriteStartElement("cxf:outbound-endpoint");
            xmlWriter.WriteAttributeString("address", strWebServiceURL);
            xmlWriter.WriteAttributeString("wsdlPort", strWSDLPort);
            xmlWriter.WriteAttributeString("wsdlLocation", String.valueOf(strWebServiceURL) + "?wsdl");
            xmlWriter.WriteAttributeString("clientClass", strClientClass);
            xmlWriter.WriteAttributeString("operation", strOperation);
            if (this.eaiAppInt.getSYNCMODE()) {
                xmlWriter.WriteAttributeString("synchronous", "true");
            }
            xmlWriter.WriteEndElement();
            xmlWriter.WriteEndElement();
            xmlWriter.WriteEndElement();
        }
        xmlWriter.WriteEndElement();
        return callResult;
    }
}

