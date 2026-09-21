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

public class KPIPoint
extends BaseDataEntity {
    public static final String TAG_KPIPOINTID = "KPIPOINTID";
    public static final String TAG_KPIPOINTNAME = "KPIPOINTNAME";
    public static final String TAG_MPTYPE = "MPTYPE";
    public static final String TAG_ROWID = "ROWID";
    public static final String TAG_COLUMNID = "COLUMNID";
    public static final String TAG_ISSYSTEM = "ISSYSTEM";
    public static final String TAG_KPIPOINTPARAM = "KPIPOINTPARAM";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_CUSTOMOBJECT = "CUSTOMOBJECT";
    public static final String TAG_CALCFORMULA = "CALCFORMULA";
    public static final String TAG_MAXSCORE = "MAXSCORE";
    public static final String TAG_MINSCORE = "MINSCORE";
    public static final String TAG_UPDATECMD = "UPDATECMD";
    public static final String TAG_MPTYPE_USERINPUT = "USERINPUT";
    public static final String TAG_MPTYPE_CUSTOM = "CUSTOM";
    public static final String TAG_MPTYPE_CALCFORMULA = "CALCFORMULA";
    protected QueryGroupModelConfig queryGroupModelConfig = null;

    public String getKPIPOINTNAME() {
        return this.GetParamStringValue(TAG_KPIPOINTNAME, "");
    }

    public String getKPIPOINTID() {
        return this.GetParamStringValue(TAG_KPIPOINTID, "");
    }

    public String getMPTYPE() {
        return this.GetParamStringValue(TAG_MPTYPE, "");
    }

    public String getKPIPOINTPARAM() {
        return this.GetParamStringValue(TAG_KPIPOINTPARAM, "");
    }

    public String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public String getCUSTOMOBJECT() {
        return this.GetParamStringValue(TAG_CUSTOMOBJECT, "");
    }

    public String getCALCFORMULA() {
        return this.GetParamStringValue("CALCFORMULA", "");
    }

    public String getUPDATECMD() {
        return this.GetParamStringValue(TAG_UPDATECMD, "");
    }

    public void setKPIPOINTID(String strValue) {
        this.SetParamValue(TAG_KPIPOINTID, strValue);
    }

    public void setKPIPOINTNAME(String strValue) {
        this.SetParamValue(TAG_KPIPOINTNAME, strValue);
    }

    public void setMPTYPE(String strValue) {
        this.SetParamValue(TAG_MPTYPE, strValue);
    }

    public void setKPIPOINTPARAM(String strValue) {
        this.SetParamValue(TAG_KPIPOINTPARAM, strValue);
    }

    public void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
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

    public double getMAXSCORE() {
        return this.GetParamDoubleValue(TAG_MAXSCORE, 0.0);
    }

    public double getMINSCORE() {
        return this.GetParamDoubleValue(TAG_MINSCORE, 0.0);
    }
}

