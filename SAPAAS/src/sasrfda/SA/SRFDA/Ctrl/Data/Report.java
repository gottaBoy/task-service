/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFDA.Model.QueryGroupModelConfig;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import java.util.Properties;

public class Report
extends BaseDataEntity {
    public static final String TAG_REPORTID = "REPORTID";
    public static final String TAG_REPORTNAME = "REPORTNAME";
    public static final String TAG_REPORTTYPE = "REPORTTYPE";
    public static final String TAG_ROWID = "ROWID";
    public static final String TAG_COLUMNID = "COLUMNID";
    public static final String TAG_ISSYSTEM = "ISSYSTEM";
    public static final String TAG_REPORTPARAM = "REPORTPARAM";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_QUERYMODELID = "QUERYMODELID";
    public static final String TAG_SEARCHPANEL = "SEARCHPANEL";
    public static final String TAG_WIDTH = "WIDTH";
    public static final String TAG_HEIGHT = "HEIGHT";
    public static final String TAG_REPORTOBJECT = "REPORTOBJECT";
    public static final String TAG_USERMODE = "USERMODE";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_REPORTPATH = "REPORTPATH";
    public static final String TAG_ISENABLEGROUP = "ISENABLEGROUP";
    public static final String TAG_GROUPMODEL = "GROUPMODEL";
    public static final String TAG_REPORTTYPE_PDF = "PDF";
    public static final String TAG_REPORTTYPE_EXCEL = "EXCEL";
    public static final String TAG_REPORTTYPE_HTML = "HTML";
    public static final String TAG_REPORTPARAM_TOPCOUNT = "TOPCOUNT";
    public static final String TAG_REPORTPARAM_REPORT_ITEMCOUNT = "REPORT.ITEMCOUNT";
    public static final String TAG_REPORTPARAM_REPORT_HIDEHEADER = "REPORT.HIDEHEADER";
    public static final String TAG_REPORTPARAM_REPORT_ITEM = "REPORT.ITEM";
    public static final String TAG_REPORTTYPE_NORMAL = "NORMAL";
    public static final String TAG_MULTIPAGE = "MULTIPAGE";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    protected QueryGroupModelConfig queryGroupModelConfig = null;
    private Properties reportParams = null;

    public String getREPORTNAME() {
        return this.GetParamStringValue(TAG_REPORTNAME, "");
    }

    public String getREPORTID() {
        return this.GetParamStringValue(TAG_REPORTID, "");
    }

    public String getREPORTTYPE() {
        return this.GetParamStringValue(TAG_REPORTTYPE, "");
    }

    public String getREPORTPARAM() {
        return this.GetParamStringValue(TAG_REPORTPARAM, "");
    }

    public String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public String getQUERYMODELID() {
        return this.GetParamStringValue(TAG_QUERYMODELID, "");
    }

    public String getSEARCHPANEL() {
        return this.GetParamStringValue(TAG_SEARCHPANEL, "");
    }

    public String getREPORTOBJECT() {
        return this.GetParamStringValue(TAG_REPORTOBJECT, "");
    }

    public String getUSERMODE() {
        return this.GetParamStringValue(TAG_USERMODE, "");
    }

    public String getDEID() {
        return this.GetParamStringValue(TAG_DEID, "");
    }

    public String getREPORTPATH() {
        return this.GetParamStringValue(TAG_REPORTPATH, "");
    }

    public String getGROUPMODEL() {
        return this.GetParamStringValue(TAG_GROUPMODEL, "");
    }

    public void setREPORTID(String strValue) {
        this.SetParamValue(TAG_REPORTID, strValue);
    }

    public void setREPORTNAME(String strValue) {
        this.SetParamValue(TAG_REPORTNAME, strValue);
    }

    public void setREPORTTYPE(String strValue) {
        this.SetParamValue(TAG_REPORTTYPE, strValue);
    }

    public void setREPORTPARAM(String strValue) {
        this.SetParamValue(TAG_REPORTPARAM, strValue);
    }

    public void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public void setQUERYMODELID(String strValue) {
        this.SetParamValue(TAG_QUERYMODELID, strValue);
    }

    public void setSEARCHPANEL(String strValue) {
        this.SetParamValue(TAG_SEARCHPANEL, strValue);
    }

    public boolean isSYSTEM() {
        return this.GetParamIntValue(TAG_ISSYSTEM, 0) == 1;
    }

    public boolean isENABLEGROUP() {
        return this.GetParamIntValue(TAG_ISENABLEGROUP, 0) == 1;
    }

    public int getROWID() {
        return this.GetParamIntValue(TAG_ROWID, 0);
    }

    public int getCOLUMNID() {
        return this.GetParamIntValue(TAG_COLUMNID, 0);
    }

    public void setREPORTTYPE(int nValue) {
        this.SetParamValue(TAG_REPORTTYPE, nValue);
    }

    public void setROWID(int nValue) {
        this.SetParamValue(TAG_ROWID, nValue);
    }

    public void setCOLUMNID(int nValue) {
        this.SetParamValue(TAG_COLUMNID, nValue);
    }

    public int getWIDTH() {
        return this.GetParamIntValue(TAG_WIDTH, 0);
    }

    public int getHEIGHT() {
        return this.GetParamIntValue(TAG_HEIGHT, 0);
    }

    public void setWIDTH(int nValue) {
        this.SetParamValue(TAG_WIDTH, nValue);
    }

    public void setHEIGHT(int nValue) {
        this.SetParamValue(TAG_HEIGHT, nValue);
    }

    public boolean getMULTIPAGE() {
        return this.GetParamIntValue(TAG_MULTIPAGE, 0) == 1;
    }

    public void setMULTIPAGE(boolean bValue) {
        this.SetParamValue(TAG_MULTIPAGE, bValue ? 1 : 0);
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }

    public QueryGroupModelConfig getQueryGroupModelConfig() {
        if (this.queryGroupModelConfig != null) {
            return this.queryGroupModelConfig;
        }
        String strGroupModelXML = this.getGROUPMODEL();
        if (StringHelper.Length((String)strGroupModelXML) > 0) {
            this.queryGroupModelConfig = new QueryGroupModelConfig();
            if (!XMLConfig.LoadFromXML((String)strGroupModelXML, (XMLConfig)this.queryGroupModelConfig)) {
                return null;
            }
        }
        return this.queryGroupModelConfig;
    }

    public synchronized void BuildProperties() {
        try {
            if (this.reportParams != null) {
                return;
            }
            String strReportParam = this.getREPORTPARAM();
            if (!StringHelper.IsNullOrEmpty((String)strReportParam)) {
                this.reportParams = PropertiesHelper.Load((Properties)this.reportParams, (String)strReportParam);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public Properties getReportProperties() {
        this.BuildProperties();
        return this.reportParams;
    }

    public String GetReportProperty(String strName, String strDefault) {
        this.BuildProperties();
        if (this.reportParams == null) {
            return strDefault;
        }
        return PropertiesHelper.GetProperty((Properties)this.reportParams, (String)strName, (String)strDefault);
    }
}

