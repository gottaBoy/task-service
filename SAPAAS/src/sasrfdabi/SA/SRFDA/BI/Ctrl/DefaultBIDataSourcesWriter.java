/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.XML.SimpleXMLWriter
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.XML.SimpleXMLWriter;
import java.util.Date;
import java.util.Vector;

public class DefaultBIDataSourcesWriter {
    public CallResult Export(ISRFDAGlobalHelper iDAGlobalHelper, SimpleXMLWriter xmlWriter) {
        CallResult callResult = new CallResult();
        try {
            IDEHelper iDEHelper = iDAGlobalHelper.getDAModelStorage().FindDEHelper("BI0000");
            String strSQL = "SELECT * from V_SRFBICATALOG where ISVALID IS NULL OR ISVALID = 1";
            Vector<BaseDataEntity> cataLogs = new Vector<BaseDataEntity>();
            callResult = BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)iDAGlobalHelper, (String)iDEHelper.GetDBStorage(), (String)strSQL, null, cataLogs, (String)"");
            if (callResult.IsError()) {
                return callResult;
            }
            xmlWriter.WriteStartElement("DataSources");
            xmlWriter.WriteComment(StringHelper.Format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)new Date()));
            xmlWriter.WriteStartElement("DataSource");
            xmlWriter.WriteStartElement("DataSourceName");
            xmlWriter.WriteCDATA("SABIDataSource");
            xmlWriter.WriteEndElement();
            xmlWriter.WriteStartElement("DataSourceDescription");
            xmlWriter.WriteCDATA("SABIDataSource");
            xmlWriter.WriteEndElement();
            xmlWriter.WriteStartElement("URL");
            xmlWriter.WriteCDATA(iDAGlobalHelper.getWebExConfig().GetValue("SRFBI", "XMLAPATH", "http://localhost:8080/SAIBIZSYS/srfbi/xmla"));
            xmlWriter.WriteEndElement();
            xmlWriter.WriteStartElement("DataSourceInfo");
            String strDataSource = iDAGlobalHelper.getWebExConfig().GetValue("SRFBI", "DATASOURCE", "");
            if (strDataSource.indexOf("Provider=mondrian;") == -1) {
                strDataSource = "Provider=mondrian;" + strDataSource;
            }
            xmlWriter.WriteCDATA(strDataSource);
            xmlWriter.WriteEndElement();
            xmlWriter.WriteStartElement("ProviderName");
            xmlWriter.WriteCDATA("Mondrian");
            xmlWriter.WriteEndElement();
            xmlWriter.WriteStartElement("ProviderType");
            xmlWriter.WriteCDATA("MDP");
            xmlWriter.WriteEndElement();
            xmlWriter.WriteStartElement("AuthenticationMode");
            xmlWriter.WriteCDATA("Authenticated");
            xmlWriter.WriteEndElement();
            xmlWriter.WriteStartElement("Catalogs");
            for (BaseDataEntity cataLog : cataLogs) {
                xmlWriter.WriteStartElement("Catalog");
                xmlWriter.WriteAttributeString("name", cataLog.GetParamStringValue("BICATALOGNAME", ""));
                xmlWriter.WriteStartElement("Definition");
                xmlWriter.WriteCDATA(StringHelper.Format((String)"/WEB-INF/biconf/%1$s.xml", (Object)cataLog.GetParamStringValue("BICATALOGID", "").toLowerCase()));
                xmlWriter.WriteEndElement();
                xmlWriter.WriteEndElement();
            }
            xmlWriter.WriteEndElement();
            xmlWriter.WriteEndElement();
            xmlWriter.WriteEndElement();
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u5bfc\u51fa\u5206\u6790\u6a21\u578b\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)ex.getMessage()));
        }
        return callResult;
    }
}
