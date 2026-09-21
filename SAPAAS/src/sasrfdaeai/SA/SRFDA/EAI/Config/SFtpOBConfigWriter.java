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

public class SFtpOBConfigWriter
extends OutboundConfigWriter {
    public SFtpOBConfigWriter() {
        this.bTestAppInt = true;
    }

    @Override
    public CallResult ExportConnector(SimpleXMLWriter xmlWriter) {
        CallResult callResult = new CallResult();
        if (!StringHelper.IsNullOrEmpty((String)this.processConfig.getProcessConfigId())) {
            xmlWriter.WriteStartElement("sftp:connector");
            xmlWriter.WriteAttributeString("name", "sftp_" + this.processConfig.getID());
            String strHost = this.eaiAppInt.getHOSTNAME();
            if (!StringHelper.IsNullOrEmpty((String)strHost)) {
                xmlWriter.WriteAttributeString("host", strHost);
            }
            int nPort = this.eaiAppInt.getPORT(22);
            xmlWriter.WriteAttributeString("port", StringHelper.Format((String)"%1$s", (Object)nPort));
            String strUser = this.eaiAppInt.getUSERNAME();
            String strPassword = this.eaiAppInt.getPWD();
            xmlWriter.WriteAttributeString("user", strUser);
            xmlWriter.WriteAttributeString("password", strPassword);
            xmlWriter.WriteEndElement();
        }
        return callResult;
    }

    @Override
    public CallResult ExportService(SimpleXMLWriter xmlWriter) {
        CallResult callResult = new CallResult();
        String strRemoteFolder = this.eaiAppInt.getPARAM();
        String strAppendFolder = this.eaiAppInt.getPARAM5();
        String strFileName = this.eaiAppInt.getPARAM2();
        xmlWriter.WriteComment(this.processConfig.getLogicName());
        xmlWriter.WriteStartElement("service");
        xmlWriter.WriteAttributeString("name", this.processConfig.getID());
        this.ExportInbound(xmlWriter);
        if (!StringHelper.IsNullOrEmpty((String)this.processConfig.getProcessConfigId())) {
            xmlWriter.WriteStartElement("outbound");
            xmlWriter.WriteStartElement("pass-through-router");
            xmlWriter.WriteStartElement("sftp:outbound-endpoint");
            xmlWriter.WriteAttributeString("connector-ref", "sftp_" + this.processConfig.getID());
            String strHost = this.eaiAppInt.getHOSTNAME();
            xmlWriter.WriteAttributeString("host", strHost);
            xmlWriter.WriteAttributeString("remotefolder", strRemoteFolder);
            if (!StringHelper.IsNullOrEmpty((String)strAppendFolder)) {
                xmlWriter.WriteAttributeString("appendfolder", strAppendFolder);
            }
            if (!StringHelper.IsNullOrEmpty((String)strFileName)) {
                xmlWriter.WriteAttributeString("filename", strFileName);
            }
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

