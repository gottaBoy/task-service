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

public class FTPPollingIBConfigWriter
extends InboundConfigWriter {
    public FTPPollingIBConfigWriter() {
        this.bTestAppInt = true;
    }

    @Override
    public CallResult ExportService(SimpleXMLWriter xmlWriter) {
        CallResult callResult = new CallResult();
        xmlWriter.WriteComment(this.processConfig.getLogicName());
        xmlWriter.WriteStartElement("service");
        xmlWriter.WriteAttributeString("name", this.processConfig.getID());
        if (!StringHelper.IsNullOrEmpty((String)this.processConfig.getProcessConfigId())) {
            xmlWriter.WriteStartElement("inbound");
            xmlWriter.WriteStartElement("ftp:inbound-endpoint");
            String strUserName = this.eaiAppInt.getUSERNAME();
            String strPassword = this.eaiAppInt.getPWD();
            String strHost = this.eaiAppInt.getHOSTNAME();
            int nPort = this.eaiAppInt.getPORT(21);
            String strPath = this.eaiAppInt.getPARAM();
            if (!StringHelper.IsNullOrEmpty((String)strUserName)) {
                xmlWriter.WriteAttributeString("user", strUserName);
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
            int nPolling = this.eaiProcessConfig.getPARAM1(10000);
            xmlWriter.WriteAttributeString("binary", this.eaiAppInt.getPARAM7() ? "true" : "false");
            xmlWriter.WriteAttributeString("passive", this.eaiAppInt.getPARAM8() ? "true" : "false");
            xmlWriter.WriteAttributeString("pollingFrequency", StringHelper.Format((String)"%1$s", (Object)nPolling));
            String strFileWildcard = this.eaiAppInt.getPARAM2();
            if (!StringHelper.IsNullOrEmpty((String)strFileWildcard)) {
                xmlWriter.WriteStartElement("file:filename-wildcard-filter");
                xmlWriter.WriteAttributeString("pattern", strFileWildcard);
                xmlWriter.WriteEndElement();
            }
            xmlWriter.WriteEndElement();
            xmlWriter.WriteEndElement();
        }
        this.ExportOutbound(xmlWriter);
        xmlWriter.WriteEndElement();
        return callResult;
    }
}

