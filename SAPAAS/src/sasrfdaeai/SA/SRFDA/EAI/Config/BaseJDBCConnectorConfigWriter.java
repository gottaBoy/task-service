/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.XML.SimpleXMLWriter
 */
package SA.SRFDA.EAI.Config;

import SA.SRFDA.EAI.Config.ISRFEAIConfigWriterContext;
import SA.SRFDA.EAI.Ctrl.Data.EAIJDBCIB;
import SA.SRFDA.EAI.Ctrl.Data.EAIJDBCOB;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.XML.SimpleXMLWriter;

public class BaseJDBCConnectorConfigWriter {
    public CallResult Export(BaseDataEntity jdbcConnector, SimpleXMLWriter xmlWriter, ISRFEAIConfigWriterContext writerContext) {
        CallResult callResult = new CallResult();
        if (jdbcConnector instanceof EAIJDBCIB) {
            EAIJDBCIB jdbcIB = (EAIJDBCIB)jdbcConnector;
            xmlWriter.WriteStartElement("jdbc:connector");
            xmlWriter.WriteAttributeString("name", jdbcIB.getEAIJDBCIBID());
            xmlWriter.WriteAttributeString("dataSource-ref", jdbcIB.getEAIDATASOURCEID());
            xmlWriter.WriteStartElement("jdbc:query");
            xmlWriter.WriteAttributeString("key", "default");
            xmlWriter.WriteAttributeString("value", jdbcIB.getSQLCMD());
            xmlWriter.WriteEndElement();
            xmlWriter.WriteEndElement();
            return callResult;
        }
        if (jdbcConnector instanceof EAIJDBCOB) {
            EAIJDBCOB jdbcOB = (EAIJDBCOB)jdbcConnector;
            xmlWriter.WriteStartElement("jdbc:connector");
            xmlWriter.WriteAttributeString("name", jdbcOB.getEAIJDBCOBID());
            xmlWriter.WriteAttributeString("dataSource-ref", jdbcOB.getEAIDATASOURCEID());
            xmlWriter.WriteStartElement("jdbc:query");
            xmlWriter.WriteAttributeString("key", "default");
            xmlWriter.WriteAttributeString("value", jdbcOB.getSQLCMD());
            xmlWriter.WriteEndElement();
            xmlWriter.WriteEndElement();
            return callResult;
        }
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

