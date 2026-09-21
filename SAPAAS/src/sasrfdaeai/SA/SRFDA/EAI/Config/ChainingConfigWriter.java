/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.XML.SimpleXMLWriter
 */
package SA.SRFDA.EAI.Config;

import SA.SRFDA.EAI.Config.BaseConfigWriter;
import SA.SRFDA.EAI.Model.EAIChainingProcessConfig;
import SA.SRFDA.EAI.Model.EAIRouteConnectionConfig;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.XML.SimpleXMLWriter;
import java.util.Iterator;
import java.util.Vector;

public class ChainingConfigWriter
extends BaseConfigWriter {
    @Override
    public CallResult ExportService(SimpleXMLWriter xmlWriter) {
        CallResult callResult = new CallResult();
        xmlWriter.WriteComment(this.processConfig.getLogicName());
        xmlWriter.WriteStartElement("service");
        xmlWriter.WriteAttributeString("name", this.processConfig.getID());
        this.ExportInbound(xmlWriter);
        EAIChainingProcessConfig realProcessConfig = (EAIChainingProcessConfig)this.processConfig;
        xmlWriter.WriteStartElement("outbound");
        xmlWriter.WriteStartElement("chaining-router");
        Vector<EAIRouteConnectionConfig> sortList = new Vector<EAIRouteConnectionConfig>();
        Iterator iterator = realProcessConfig.getConnectionsConfig().iterator();
        while (iterator.hasNext()) {
            EAIRouteConnectionConfig eaiConnectionConfig = (EAIRouteConnectionConfig)((Object)iterator.next());
            int nInsertPos = -1;
            int nCount = sortList.size();
            int i = 0;
            while (i < nCount) {
                EAIRouteConnectionConfig tempConfig = (EAIRouteConnectionConfig)((Object)sortList.get(i));
                if (tempConfig.getShowOrder() > eaiConnectionConfig.getShowOrder()) {
                    nInsertPos = i;
                    sortList.add(i, eaiConnectionConfig);
                    break;
                }
                ++i;
            }
            if (nInsertPos != -1) continue;
            sortList.add(eaiConnectionConfig);
        }
        for (EAIRouteConnectionConfig eaiConnectionConfig : sortList) {
            xmlWriter.WriteComment(eaiConnectionConfig.getLogicName());
            xmlWriter.WriteStartElement("vm:outbound-endpoint");
            xmlWriter.WriteAttributeString("name", eaiConnectionConfig.getID());
            xmlWriter.WriteAttributeString("path", "vm_" + this.configWriterContext.getServiceId() + "_" + eaiConnectionConfig.getID());
            xmlWriter.WriteEndElement();
        }
        xmlWriter.WriteEndElement();
        xmlWriter.WriteEndElement();
        xmlWriter.WriteEndElement();
        return callResult;
    }
}

