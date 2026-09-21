/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.XML.SimpleXMLWriter
 */
package SA.SRFDA.EAI.Config;

import SA.SRFDA.EAI.Config.BaseConfigWriter;
import SA.SRFDA.EAI.Ctrl.Router.DecideOutboundRouter;
import SA.SRFDA.EAI.Model.EAIConnectionConfig;
import SA.SRFDA.EAI.Model.EAIDecideProcessConfig;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.XML.SimpleXMLWriter;
import java.util.Iterator;

public class DecideConfigWriter
extends BaseConfigWriter {
    @Override
    public CallResult ExportService(SimpleXMLWriter xmlWriter) {
        CallResult callResult = new CallResult();
        xmlWriter.WriteComment(this.processConfig.getLogicName());
        xmlWriter.WriteStartElement("service");
        xmlWriter.WriteAttributeString("name", this.processConfig.getID());
        this.ExportInbound(xmlWriter);
        EAIDecideProcessConfig realProcessConfig = (EAIDecideProcessConfig)this.processConfig;
        xmlWriter.WriteStartElement("outbound");
        xmlWriter.WriteStartElement("custom-outbound-router");
        String strRouterObject = this.eaiProcessConfig.getPARAM3();
        if (StringHelper.IsNullOrEmpty((String)strRouterObject)) {
            strRouterObject = DecideOutboundRouter.class.getName();
        }
        xmlWriter.WriteAttributeString("class", strRouterObject);
        Iterator iterator = realProcessConfig.getConnectionsConfig().iterator();
        while (iterator.hasNext()) {
            EAIConnectionConfig eaiConnectionConfig = (EAIConnectionConfig)((Object)iterator.next());
            xmlWriter.WriteComment(eaiConnectionConfig.getLogicName());
            xmlWriter.WriteStartElement("vm:outbound-endpoint");
            xmlWriter.WriteAttributeString("name", eaiConnectionConfig.getID());
            xmlWriter.WriteAttributeString("path", "vm_" + this.configWriterContext.getServiceId() + "_" + eaiConnectionConfig.getID());
            if (this.eaiProcessConfig.getSYNCMODE()) {
                xmlWriter.WriteAttributeString("synchronous", "true");
            }
            xmlWriter.WriteEndElement();
        }
        xmlWriter.WriteStartElement("spring:property");
        xmlWriter.WriteAttributeString("name", "processId");
        xmlWriter.WriteAttributeString("value", this.processConfig.getID());
        xmlWriter.WriteEndElement();
        xmlWriter.WriteStartElement("spring:property");
        xmlWriter.WriteAttributeString("name", "paramId");
        xmlWriter.WriteAttributeString("value", this.eaiProcessConfig.getPARAM4());
        xmlWriter.WriteEndElement();
        xmlWriter.WriteEndElement();
        xmlWriter.WriteEndElement();
        xmlWriter.WriteEndElement();
        return callResult;
    }
}

