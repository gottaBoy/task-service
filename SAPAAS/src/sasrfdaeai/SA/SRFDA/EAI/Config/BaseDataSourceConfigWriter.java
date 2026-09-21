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
import SA.SRFDA.EAI.Ctrl.Data.EAIDataSource;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.XML.SimpleXMLWriter;

public class BaseDataSourceConfigWriter {
    public CallResult Export(EAIDataSource eaiDataSource, SimpleXMLWriter xmlWriter, ISRFEAIConfigWriterContext writerContext) {
        CallResult callResult = new CallResult();
        xmlWriter.WriteStartElement("spring:bean");
        xmlWriter.WriteAttributeString("id", eaiDataSource.getEAIDATASOURCEID());
        xmlWriter.WriteAttributeString("class", "org.enhydra.jdbc.standard.StandardDataSource");
        xmlWriter.WriteAttributeString("destroy-method", "shutdown");
        xmlWriter.WriteStartElement("spring:property");
        xmlWriter.WriteAttributeString("name", "driverName");
        xmlWriter.WriteAttributeString("value", this.OnGetDBDriverName(eaiDataSource.getDBTYPE()));
        xmlWriter.WriteEndElement();
        xmlWriter.WriteStartElement("spring:property");
        xmlWriter.WriteAttributeString("name", "url");
        xmlWriter.WriteAttributeString("value", eaiDataSource.getURL());
        xmlWriter.WriteEndElement();
        xmlWriter.WriteStartElement("spring:property");
        xmlWriter.WriteAttributeString("name", "user");
        xmlWriter.WriteAttributeString("value", eaiDataSource.getUSERNAME());
        xmlWriter.WriteEndElement();
        xmlWriter.WriteStartElement("spring:property");
        xmlWriter.WriteAttributeString("name", "password");
        xmlWriter.WriteAttributeString("value", eaiDataSource.getPWD());
        xmlWriter.WriteEndElement();
        xmlWriter.WriteEndElement();
        return callResult;
    }

    protected String OnGetDBDriverName(String strDBType) {
        if (StringHelper.Compare((String)strDBType, (String)"DB2", (boolean)true) == 0) {
            return "COM.ibm.db2.jdbc.net.DB2Driver";
        }
        if (StringHelper.Compare((String)strDBType, (String)"ORACLE", (boolean)true) == 0) {
            return "oracle.jdbc.driver.OracleDriver";
        }
        if (StringHelper.Compare((String)strDBType, (String)"MSSQL", (boolean)true) == 0) {
            return "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        }
        return "";
    }
}

