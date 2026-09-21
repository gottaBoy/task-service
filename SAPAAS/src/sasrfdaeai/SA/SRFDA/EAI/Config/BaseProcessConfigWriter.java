/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.XML.SimpleXMLWriter
 */
package SA.SRFDA.EAI.Config;

import SA.SRFDA.EAI.Config.ISRFEAIConfigWriterContext;
import SA.SRFDA.EAI.Ctrl.Data.EAIInbound;
import SA.SRFDA.EAI.Ctrl.Data.EAIJDBCIB;
import SA.SRFDA.EAI.Ctrl.Data.EAIJDBCOB;
import SA.SRFDA.EAI.Ctrl.Data.EAIOutbound;
import SA.SRFDA.EAI.Ctrl.Data.EAIProcess;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.XML.SimpleXMLWriter;
import java.util.Vector;

public class BaseProcessConfigWriter {
    public CallResult Export(EAIProcess eaiProcess, SimpleXMLWriter xmlWriter, ISRFEAIConfigWriterContext writerContext) {
        Vector<EAIInbound> ibList = new Vector<EAIInbound>();
        Vector<EAIOutbound> obList = new Vector<EAIOutbound>();
        CallResult callResult = writerContext.getEAIDataCtrl().GetProcessIBs(eaiProcess.getEAIPROCESSID(), ibList);
        if (callResult.IsError()) {
            return callResult;
        }
        callResult = writerContext.getEAIDataCtrl().GetProcessOBs(eaiProcess.getEAIPROCESSID(), obList);
        if (callResult.IsError()) {
            return callResult;
        }
        xmlWriter.WriteStartElement("service");
        xmlWriter.WriteAttributeString("name", eaiProcess.getEAIPROCESSID());
        if (StringHelper.Compare((String)eaiProcess.getIBROUTER(), (String)"NOROUTER", (boolean)true) == 0) {
            xmlWriter.WriteStartElement("inbound");
        }
        for (EAIInbound ib : ibList) {
            if (StringHelper.Compare((String)ib.getEAIINBOUNDTYPE(), (String)"JDBC", (boolean)true) != 0) continue;
            EAIJDBCIB eaiJDBCIB = new EAIJDBCIB();
            callResult = writerContext.getEAIDataCtrl().GetJDBCIB(ib.getEAIINBOUNDID(), eaiJDBCIB);
            if (callResult.IsError()) {
                return callResult;
            }
            xmlWriter.WriteStartElement("jdbc:inbound-endpoint");
            xmlWriter.WriteAttributeString("queryKey", "default");
            xmlWriter.WriteAttributeString("connector-ref", eaiJDBCIB.getEAIJDBCIBID());
            xmlWriter.WriteEndElement();
        }
        xmlWriter.WriteEndElement();
        if (!StringHelper.IsNullOrEmpty((String)eaiProcess.getCUSTOMOBJECT())) {
            xmlWriter.WriteStartElement("component");
            xmlWriter.WriteAttributeString("class", eaiProcess.getCUSTOMOBJECT());
            xmlWriter.WriteEndElement();
        }
        if (obList.size() > 0) {
            int nMaxCount = 99999;
            xmlWriter.WriteStartElement("outbound");
            if (StringHelper.Compare((String)eaiProcess.getOBROUTER(), (String)"PASSTHROUGH", (boolean)true) == 0) {
                nMaxCount = 1;
                xmlWriter.WriteStartElement("pass-through-router");
            }
            if (StringHelper.Compare((String)eaiProcess.getOBROUTER(), (String)"CHAINING", (boolean)true) == 0) {
                xmlWriter.WriteStartElement("chaining-router");
            }
            if (StringHelper.Compare((String)eaiProcess.getOBROUTER(), (String)"MULTICASTING", (boolean)true) == 0) {
                xmlWriter.WriteStartElement("multicasting-router");
            }
            for (EAIOutbound ob : obList) {
                if (nMaxCount == 0) break;
                --nMaxCount;
                if (StringHelper.Compare((String)ob.getEAIOUTBOUNDTYPE(), (String)"JDBC", (boolean)true) != 0) continue;
                EAIJDBCOB eaiJDBCOB = new EAIJDBCOB();
                callResult = writerContext.getEAIDataCtrl().GetJDBCOB(ob.getEAIOUTBOUNDID(), eaiJDBCOB);
                if (callResult.IsError()) {
                    return callResult;
                }
                xmlWriter.WriteStartElement("jdbc:outbound-endpoint ");
                xmlWriter.WriteAttributeString("queryKey", "default");
                xmlWriter.WriteAttributeString("connector-ref", eaiJDBCOB.getEAIJDBCOBID());
                xmlWriter.WriteEndElement();
            }
            xmlWriter.WriteEndElement();
            xmlWriter.WriteEndElement();
        }
        xmlWriter.WriteEndElement();
        return callResult;
    }
}

