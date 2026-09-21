/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Model.QueryGroupModelConfig
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.KPI.Ctrl.Data;

import SA.SRFDA.Model.QueryGroupModelConfig;
import SA.SRFramework.DataEx.BaseDataEntity;

public class KPIMP
extends BaseDataEntity {
    public static final String TAG_KPIMPID = "KPIMPID";
    public static final String TAG_KPIMPNAME = "KPIMPNAME";
    public static final String TAG_MPTYPE = "MPTYPE";
    public static final String TAG_ROWID = "ROWID";
    public static final String TAG_COLUMNID = "COLUMNID";
    public static final String TAG_ISSYSTEM = "ISSYSTEM";
    public static final String TAG_KPIMPPARAM = "KPIMPPARAM";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_QUERYMODELID = "QUERYMODELID";
    public static final String TAG_GROUPMODEL = "GROUPMODEL";
    public static final String TAG_WIDTH = "WIDTH";
    public static final String TAG_HEIGHT = "HEIGHT";
    public static final String TAG_CUSTOMOBJECT = "CUSTOMOBJECT";
    public static final String TAG_FORMULA = "FORMULA";
    public static final String TAG_UPDATECMD = "UPDATECMD";
    public static final String TAG_MPTYPE_DATABASE = "DATABASE";
    public static final String TAG_MPTYPE_PROGRAM = "PROGRAM";
    public static final String TAG_MPTYPE_FORMULA = "FORMULA";
    protected QueryGroupModelConfig queryGroupModelConfig = null;

    public String getKPIMPNAME() {
        return this.GetParamStringValue(TAG_KPIMPNAME, "");
    }

    public String getKPIMPID() {
        return this.GetParamStringValue(TAG_KPIMPID, "");
    }

    public String getMPTYPE() {
        return this.GetParamStringValue(TAG_MPTYPE, "");
    }

    public String getKPIMPPARAM() {
        return this.GetParamStringValue(TAG_KPIMPPARAM, "");
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

    public String getGROUPMODEL() {
        return this.GetParamStringValue(TAG_GROUPMODEL, "");
    }

    public String getCUSTOMOBJECT() {
        return this.GetParamStringValue(TAG_CUSTOMOBJECT, "");
    }

    public String getFORMULA() {
        return this.GetParamStringValue("FORMULA", "");
    }

    public String getUPDATECMD() {
        return this.GetParamStringValue(TAG_UPDATECMD, "");
    }

    public void setKPIMPID(String strValue) {
        this.SetParamValue(TAG_KPIMPID, strValue);
    }

    public void setKPIMPNAME(String strValue) {
        this.SetParamValue(TAG_KPIMPNAME, strValue);
    }

    public void setMPTYPE(String strValue) {
        this.SetParamValue(TAG_MPTYPE, strValue);
    }

    public void setKPIMPPARAM(String strValue) {
        this.SetParamValue(TAG_KPIMPPARAM, strValue);
    }

    public void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public void setUPDATECMD(String strValue) {
        this.SetParamValue(TAG_UPDATECMD, strValue);
    }

    public boolean isSYSTEM() {
        return this.GetParamIntValue(TAG_ISSYSTEM, 0) == 1;
    }

    public int getROWID() {
        return this.GetParamIntValue(TAG_ROWID, 0);
    }

    public int getCOLUMNID() {
        return this.GetParamIntValue(TAG_COLUMNID, 0);
    }

    public void setMPTYPE(int nValue) {
        this.SetParamValue(TAG_MPTYPE, nValue);
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
}

