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

public class FilePollingIBConfigWriter
extends InboundConfigWriter {
    public FilePollingIBConfigWriter() {
        this.bTestAppInt = true;
    }

    @Override
    public CallResult ExportConnector(SimpleXMLWriter xmlWriter) {
        CallResult callResult = new CallResult();
        if (!StringHelper.IsNullOrEmpty((String)this.processConfig.getProcessConfigId())) {
            int nPolling = this.eaiProcessConfig.getPARAM11(30000);
            xmlWriter.WriteStartElement("file:connector");
            xmlWriter.WriteAttributeString("name", "file_" + this.processConfig.getID());
            xmlWriter.WriteAttributeString("pollingFrequency", StringHelper.Format((String)"%1$s", (Object)nPolling));
            xmlWriter.WriteAttributeString("fileAge", "5000");
            xmlWriter.WriteAttributeString("autoDelete", this.eaiAppInt.getPARAM7() ? "true" : "false");
            xmlWriter.WriteAttributeString("streaming", "false");
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
            xmlWriter.WriteStartElement("file:inbound-endpoint");
            String strPath = this.eaiAppInt.getPARAM3();
            String strMoveToDirectory = this.eaiAppInt.getPARAM4();
            String strMoveToPattern = this.eaiAppInt.getPARAM2();
            if (!StringHelper.IsNullOrEmpty((String)strPath)) {
                xmlWriter.WriteAttributeString("path", strPath);
            }
            if (!this.eaiAppInt.getPARAM7()) {
                if (!StringHelper.IsNullOrEmpty((String)strMoveToDirectory)) {
                    xmlWriter.WriteAttributeString("moveToDirectory", strMoveToDirectory);
                }
                if (!StringHelper.IsNullOrEmpty((String)strMoveToPattern)) {
                    xmlWriter.WriteAttributeString("moveToPattern", strMoveToPattern);
                } else {
                    xmlWriter.WriteAttributeString("moveToPattern", "#[DATE]-#[ORIGINALNAME]");
                }
            }
            xmlWriter.WriteAttributeString("connector-ref", "file_" + this.processConfig.getID());
            String strFileWildcard = this.eaiAppInt.getPARAM();
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

