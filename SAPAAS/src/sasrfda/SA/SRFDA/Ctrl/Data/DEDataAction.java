/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;

public class DEDataAction
extends BaseDataEntity {
    public static final String TAG_DEDATAACTIONID = "DEDATAACTIONID";
    public static final String TAG_DEDATAACTIONNAME = "DEDATAACTIONNAME";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_RESERVER = "RESERVER";
    public static final String TAG_RESERVER2 = "RESERVER2";
    public static final String TAG_MAJORDEACTION = "MAJORDEACTION";
    public static final String TAG_ISMAPTOMAJOR = "ISMAPTOMAJOR";

    public String getDEDATAACTIONID() {
        return this.GetParamStringValue(TAG_DEDATAACTIONID, "").trim();
    }

    public String getDEDATAACTIONNAME() {
        return this.GetParamStringValue(TAG_DEDATAACTIONNAME, "");
    }

    public String getDEID() {
        return this.GetParamStringValue(TAG_DEID, "");
    }

    public String getRESERVER() {
        return this.GetParamStringValue(TAG_RESERVER, "");
    }

    public String getRESERVER2() {
        return this.GetParamStringValue(TAG_RESERVER2, "");
    }

    public String getMAJORDEACTION() {
        return this.GetParamStringValue(TAG_MAJORDEACTION, "");
    }

    public void setMAJORDEACTION(String strValue) {
        this.SetParamValue(TAG_MAJORDEACTION, strValue);
    }

    public void setDEDATAACTIONID(String strValue) {
        this.SetParamValue(TAG_DEDATAACTIONID, strValue);
    }

    public void setDEDATAACTIONNAME(String strValue) {
        this.SetParamValue(TAG_DEDATAACTIONNAME, strValue);
    }

    public void setDEID(String strValue) {
        this.SetParamValue(TAG_DEID, strValue);
    }

    public void setRESERVER(String strValue) {
        this.SetParamValue(TAG_RESERVER, strValue);
    }

    public void setRESERVER2(String strValue) {
        this.SetParamValue(TAG_RESERVER2, strValue);
    }

    public int getDENAME() {
        return this.GetParamIntValue(TAG_DENAME, 0);
    }

    public boolean isMAPTOMAJOR() {
        return this.GetParamIntValue(TAG_ISMAPTOMAJOR, 0) == 1;
    }

    public void setISMAPTOMAJOR(boolean bMajorDE) {
        this.SetParamValue(TAG_ISMAPTOMAJOR, bMajorDE ? 1 : 0);
    }
}

