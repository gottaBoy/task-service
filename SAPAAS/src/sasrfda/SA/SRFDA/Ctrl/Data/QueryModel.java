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
import java.util.Date;

public class QueryModel
extends BaseDataEntity {
    public static final String TAG_QUERYMODELID = "QUERYMODELID";
    public static final String TAG_QUERYMODELNAME = "QUERYMODELNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_QUERYMODEL = "QUERYMODEL";
    public static final String TAG_QUERYOBJECT = "QUERYOBJECT";
    public static final String TAG_GROUPMODEL = "GROUPMODEL";
    public static final String TAG_QMVERSION = "QMVERSION";
    public static final String TAG_QUERYSQL = "QUERYSQL";
    public static final String TAG_QUERYCOND = "QUERYCOND";
    public static final String TAG_QUERYPARAM = "QUERYPARAM";
    public static final String TAG_QUERYFIELD = "QUERYFIELD";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_ISRAWMODE = "ISRAWMODE";
    public static final String TAG_SELECTMODE = "SELECTMODE";
    public static final String TAG_SELECTORDER = "SELECTORDER";
    public static final String QMMODEL_DEFAULT = "<?xml version=\"1.0\" encoding=\"utf-8\" ?><SRFDADATAGRIDMODEL><SRFDADGMODELCOLUMNS/><SRFDADGMODELMAINQUERY EXTSELECT=\"\" ALIAS=\"\"><SRFDADGMODELJOINQUERIES/><SRFDADGMODELGROUPLOGIC LOGICNAME=\"\u4e0e(AND)\" CONDITION=\"AND\" NOT=\"FALSE\"/></SRFDADGMODELMAINQUERY></SRFDADATAGRIDMODEL>";
    private DataGridModelConfig dataGridModelConfig = null;

    public String getQUERYMODELID() {
        return this.GetParamStringValue(TAG_QUERYMODELID, "").trim();
    }

    public String getDEID() {
        return this.GetParamStringValue(TAG_DEID, "").trim();
    }

    public int getQMVERSION() {
        return this.GetParamIntValue(TAG_QMVERSION, 0);
    }

    public void setQMVERSION(int nValue) {
        this.SetParamValue(TAG_QMVERSION, nValue);
    }

    public void setQUERYMODELID(String strValue) {
        this.SetParamValue(TAG_QUERYMODELID, strValue);
    }

    public String getQUERYMODELNAME() {
        return this.GetParamStringValue(TAG_QUERYMODELNAME, "");
    }

    public void setQUERYMODELNAME(String strValue) {
        this.SetParamValue(TAG_QUERYMODELNAME, strValue);
    }

    public String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public Date getCREATEDATE() {
        return this.GetParamDateValue(TAG_CREATEDATE, null);
    }

    public void setCREATEDATE(Date strValue) {
        this.SetParamValue(TAG_CREATEDATE, strValue);
    }

    public String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public Date getUPDATEDATE() {
        return this.GetParamDateValue(TAG_UPDATEDATE, null);
    }

    public void setUPDATEDATE(Date strValue) {
        this.SetParamValue(TAG_UPDATEDATE, strValue);
    }

    public String getQUERYMODEL() {
        return this.GetParamStringValue(TAG_QUERYMODEL, "");
    }

    public void setQUERYMODEL(String strValue) {
        this.SetParamValue(TAG_QUERYMODEL, strValue);
    }

    public String getQUERYOBJECT() {
        return this.GetParamStringValue(TAG_QUERYOBJECT, "");
    }

    public void setQUERYOBJECT(String strValue) {
        this.SetParamValue(TAG_QUERYOBJECT, strValue);
    }

    public String getGROUPMODEL() {
        return this.GetParamStringValue(TAG_GROUPMODEL, "");
    }

    public void setGROUPMODEL(String strValue) {
        this.SetParamValue(TAG_GROUPMODEL, strValue);
    }

    public void setQMVERSION(String strValue) {
        this.SetParamValue(TAG_QMVERSION, strValue);
    }

    public String getQUERYSQL() {
        return this.GetParamStringValue(TAG_QUERYSQL, "");
    }

    public void setQUERYSQL(String strValue) {
        this.SetParamValue(TAG_QUERYSQL, strValue);
    }

    public String getQUERYCOND() {
        return this.GetParamStringValue(TAG_QUERYCOND, "");
    }

    public void setQUERYCOND(String strValue) {
        this.SetParamValue(TAG_QUERYCOND, strValue);
    }

    public String getQUERYPARAM() {
        return this.GetParamStringValue(TAG_QUERYPARAM, "");
    }

    public void setQUERYPARAM(String strValue) {
        this.SetParamValue(TAG_QUERYPARAM, strValue);
    }

    public String getQUERYFIELD() {
        return this.GetParamStringValue(TAG_QUERYFIELD, "");
    }

    public void setQUERYFIELD(String strValue) {
        this.SetParamValue(TAG_QUERYFIELD, strValue);
    }

    public String getDENAME() {
        return this.GetParamStringValue(TAG_DENAME, "");
    }

    public void setDENAME(String strValue) {
        this.SetParamValue(TAG_DENAME, strValue);
    }

    public void setDEID(String strValue) {
        this.SetParamValue(TAG_DEID, strValue);
    }

    public boolean isRAWMODE() {
        return this.GetParamIntValue(TAG_ISRAWMODE, 0) == 1;
    }

    public void setRAWMODE(boolean bValue) {
        this.SetParamValue(TAG_ISRAWMODE, bValue ? 1 : 0);
    }

    public String getSELECTMODE() {
        return this.GetParamStringValue(TAG_SELECTMODE, "");
    }

    public void setSELECTMODE(String strValue) {
        this.SetParamValue(TAG_SELECTMODE, strValue);
    }

    public String getSELECTORDER() {
        return this.GetParamStringValue(TAG_SELECTORDER, "");
    }

    public void setSELECTORDER(String strValue) {
        this.SetParamValue(TAG_SELECTORDER, strValue);
    }

    public DGModelMainQueryConfig getQueryModelConfig() {
        return this.getQueryModelConfig(true);
    }

    public DGModelMainQueryConfig getQueryModelConfig(boolean bCache) {
        if (bCache) {
            if (this.dataGridModelConfig != null) {
                return this.dataGridModelConfig.getMainQueryConfig();
            }
            String strDGModelXML = this.getQUERYMODEL();
            if (StringHelper.Length((String)strDGModelXML) > 0) {
                this.dataGridModelConfig = new DataGridModelConfig();
                if (!XMLConfig.LoadFromXML((String)strDGModelXML, (XMLConfig)this.dataGridModelConfig)) {
                    return null;
                }
                return this.dataGridModelConfig.getMainQueryConfig();
            }
            return null;
        }
        String strDGModelXML = this.getQUERYMODEL();
        if (StringHelper.Length((String)strDGModelXML) > 0) {
            DataGridModelConfig dataGridModelConfig = new DataGridModelConfig();
            if (!XMLConfig.LoadFromXML((String)strDGModelXML, (XMLConfig)dataGridModelConfig)) {
                return null;
            }
            return dataGridModelConfig.getMainQueryConfig();
        }
        return null;
    }
}

