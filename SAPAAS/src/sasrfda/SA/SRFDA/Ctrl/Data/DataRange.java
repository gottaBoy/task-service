/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFDA.Model.DGModelMainQueryConfig;
import SA.SRFDA.Model.DataGridModelConfig;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;

public class DataRange
extends BaseDataEntity {
    public static final String TAG_DATARANGEID = "DATARANGEID";
    public static final String TAG_DATARANGENAME = "DATARANGENAME";
    public static final String TAG_DRMODEL = "DRMODEL";
    public static final String TAG_ISSYSTEM = "ISSYSTEM";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_RESERVER = "RESERVER";
    public static final String TAG_RESERVER2 = "RESERVER2";
    public static final String TAG_USERROLEID = "USERROLEID";
    public static final String TAG_UDVERSION = "UDVERSION";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_ISEXCLUDE = "ISEXCLUDE";
    private DataGridModelConfig dataGridModelConfig = null;

    public String getDATARANGEID() {
        return this.GetParamStringValue(TAG_DATARANGEID, "").trim();
    }

    public String getDEID() {
        return this.GetParamStringValue(TAG_DEID, "").trim();
    }

    public String getDATARANGENAME() {
        return this.GetParamStringValue(TAG_DATARANGENAME, "");
    }

    public String getUSERROLEID() {
        return this.GetParamStringValue(TAG_USERROLEID, "");
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public String getRESERVER() {
        return this.GetParamStringValue(TAG_RESERVER, "");
    }

    public String getRESERVER2() {
        return this.GetParamStringValue(TAG_RESERVER2, "");
    }

    public String getDRMODEL() {
        return this.GetParamStringValue(TAG_DRMODEL, "");
    }

    public void setDATARANGEID(String strValue) {
        this.SetParamValue(TAG_DATARANGEID, strValue);
    }

    public void setDEID(String strValue) {
        this.SetParamValue(TAG_DEID, strValue);
    }

    public void setDATARANGENAME(String strValue) {
        this.SetParamValue(TAG_DATARANGENAME, strValue);
    }

    public void setDRMODEL(String strValue) {
        this.SetParamValue(TAG_DRMODEL, strValue);
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }

    public void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public void setRESERVER(String strValue) {
        this.SetParamValue(TAG_RESERVER, strValue);
    }

    public void setRESERVER2(String strValue) {
        this.SetParamValue(TAG_RESERVER2, strValue);
    }

    public boolean isSYSTEM() {
        return this.GetParamIntValue(TAG_ISSYSTEM, 0) == 1;
    }

    public int getUDVERSION() {
        return this.GetParamIntValue(TAG_UDVERSION, 1);
    }

    public void setUDVERSION(int nValue) {
        this.SetParamValue(TAG_UDVERSION, nValue);
    }

    public boolean isEXCLUDE() {
        return this.GetParamIntValue(TAG_ISEXCLUDE, 0) == 1;
    }

    public DGModelMainQueryConfig getDRModelConfig() {
        if (this.dataGridModelConfig != null) {
            return this.dataGridModelConfig.getMainQueryConfig();
        }
        String strDRModelXML = this.getDRMODEL();
        if (StringHelper.Length((String)strDRModelXML) > 0) {
            this.dataGridModelConfig = new DataGridModelConfig();
            if (!XMLConfig.LoadFromXML((String)strDRModelXML, (XMLConfig)this.dataGridModelConfig)) {
                return null;
            }
            return this.dataGridModelConfig.getMainQueryConfig();
        }
        return null;
    }
}

