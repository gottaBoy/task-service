/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDEGridEditItemVR
extends BaseDataEntity {
    public static final String USERCAT_CAT1 = "CAT1";
    public static final String USERCAT_CAT2 = "CAT2";
    public static final String USERCAT_CAT3 = "CAT3";
    public static final String USERCAT_CAT4 = "CAT4";
    public static final String USERCAT_CAT5 = "CAT5";
    public static final String USERCAT_CAT6 = "CAT6";
    public static final String USERCAT_CAT7 = "CAT7";
    public static final String USERCAT_CAT8 = "CAT8";
    public static final String USERCAT_CAT9 = "CAT9";
    public static final String VRTYPE_DEFVALUERULE = "DEFVALUERULE";
    public static final String VRTYPE_SYSVALUERULE = "SYSVALUERULE";
    public static final int CHECKMODE_1 = 1;
    public static final int CHECKMODE_2 = 2;
    public static final int CHECKMODE_3 = 3;
    public static final String TAG_PSDEGEIVRID = "PSDEGEIVRID";
    public static final String TAG_PSDEGEIVRNAME = "PSDEGEIVRNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEGRIDID = "PSDEGRIDID";
    public static final String TAG_PSDEGRIDNAME = "PSDEGRIDNAME";
    public static final String TAG_PSDEGRIDCOLID = "PSDEGRIDCOLID";
    public static final String TAG_PSDEGRIDCOLNAME = "PSDEGRIDCOLNAME";
    public static final String TAG_PSDEFVRID = "PSDEFVRID";
    public static final String TAG_PSDEFVRNAME = "PSDEFVRNAME";
    public static final String TAG_PSSYSVALUERULEID = "PSSYSVALUERULEID";
    public static final String TAG_PSSYSVALUERULENAME = "PSSYSVALUERULENAME";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_VRTYPE = "VRTYPE";
    public static final String TAG_CHECKMODE = "CHECKMODE";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_MEMO = "MEMO";

    public final boolean isPSDEGEIVRIDNull() {
        return this.IsParamNull(TAG_PSDEGEIVRID);
    }

    public final String getPSDEGEIVRID() {
        return this.GetParamStringValue(TAG_PSDEGEIVRID, "");
    }

    public final void setPSDEGEIVRID(String strValue) {
        this.SetParamValue(TAG_PSDEGEIVRID, strValue);
    }

    public final boolean isPSDEGEIVRNAMENull() {
        return this.IsParamNull(TAG_PSDEGEIVRNAME);
    }

    public final String getPSDEGEIVRNAME() {
        return this.GetParamStringValue(TAG_PSDEGEIVRNAME, "");
    }

    public final void setPSDEGEIVRNAME(String strValue) {
        this.SetParamValue(TAG_PSDEGEIVRNAME, strValue);
    }

    public final boolean isCREATEMANNull() {
        return this.IsParamNull(TAG_CREATEMAN);
    }

    public final String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public final void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public final boolean isCREATEDATENull() {
        return this.IsParamNull(TAG_CREATEDATE);
    }

    public final Date getCREATEDATE() {
        return this.GetParamDateValue(TAG_CREATEDATE, null);
    }

    public final void setCREATEDATE(Date dtValue) {
        this.SetParamValue(TAG_CREATEDATE, dtValue);
    }

    public final boolean isUPDATEMANNull() {
        return this.IsParamNull(TAG_UPDATEMAN);
    }

    public final String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public final void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public final boolean isUPDATEDATENull() {
        return this.IsParamNull(TAG_UPDATEDATE);
    }

    public final Date getUPDATEDATE() {
        return this.GetParamDateValue(TAG_UPDATEDATE, null);
    }

    public final void setUPDATEDATE(Date dtValue) {
        this.SetParamValue(TAG_UPDATEDATE, dtValue);
    }

    public final boolean isPSDEGRIDIDNull() {
        return this.IsParamNull(TAG_PSDEGRIDID);
    }

    public final String getPSDEGRIDID() {
        return this.GetParamStringValue(TAG_PSDEGRIDID, "");
    }

    public final void setPSDEGRIDID(String strValue) {
        this.SetParamValue(TAG_PSDEGRIDID, strValue);
    }

    public final boolean isPSDEGRIDNAMENull() {
        return this.IsParamNull(TAG_PSDEGRIDNAME);
    }

    public final String getPSDEGRIDNAME() {
        return this.GetParamStringValue(TAG_PSDEGRIDNAME, "");
    }

    public final void setPSDEGRIDNAME(String strValue) {
        this.SetParamValue(TAG_PSDEGRIDNAME, strValue);
    }

    public final boolean isPSDEGRIDCOLIDNull() {
        return this.IsParamNull(TAG_PSDEGRIDCOLID);
    }

    public final String getPSDEGRIDCOLID() {
        return this.GetParamStringValue(TAG_PSDEGRIDCOLID, "");
    }

    public final void setPSDEGRIDCOLID(String strValue) {
        this.SetParamValue(TAG_PSDEGRIDCOLID, strValue);
    }

    public final boolean isPSDEGRIDCOLNAMENull() {
        return this.IsParamNull(TAG_PSDEGRIDCOLNAME);
    }

    public final String getPSDEGRIDCOLNAME() {
        return this.GetParamStringValue(TAG_PSDEGRIDCOLNAME, "");
    }

    public final void setPSDEGRIDCOLNAME(String strValue) {
        this.SetParamValue(TAG_PSDEGRIDCOLNAME, strValue);
    }

    public final boolean isPSDEFVRIDNull() {
        return this.IsParamNull(TAG_PSDEFVRID);
    }

    public final String getPSDEFVRID() {
        return this.GetParamStringValue(TAG_PSDEFVRID, "");
    }

    public final void setPSDEFVRID(String strValue) {
        this.SetParamValue(TAG_PSDEFVRID, strValue);
    }

    public final boolean isPSDEFVRNAMENull() {
        return this.IsParamNull(TAG_PSDEFVRNAME);
    }

    public final String getPSDEFVRNAME() {
        return this.GetParamStringValue(TAG_PSDEFVRNAME, "");
    }

    public final void setPSDEFVRNAME(String strValue) {
        this.SetParamValue(TAG_PSDEFVRNAME, strValue);
    }

    public final boolean isPSSYSVALUERULEIDNull() {
        return this.IsParamNull(TAG_PSSYSVALUERULEID);
    }

    public final String getPSSYSVALUERULEID() {
        return this.GetParamStringValue(TAG_PSSYSVALUERULEID, "");
    }

    public final void setPSSYSVALUERULEID(String strValue) {
        this.SetParamValue(TAG_PSSYSVALUERULEID, strValue);
    }

    public final boolean isPSSYSVALUERULENAMENull() {
        return this.IsParamNull(TAG_PSSYSVALUERULENAME);
    }

    public final String getPSSYSVALUERULENAME() {
        return this.GetParamStringValue(TAG_PSSYSVALUERULENAME, "");
    }

    public final void setPSSYSVALUERULENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSVALUERULENAME, strValue);
    }

    public final boolean isUSERTAG4Null() {
        return this.IsParamNull(TAG_USERTAG4);
    }

    public final String getUSERTAG4() {
        return this.GetParamStringValue(TAG_USERTAG4, "");
    }

    public final void setUSERTAG4(String strValue) {
        this.SetParamValue(TAG_USERTAG4, strValue);
    }

    public final boolean isUSERTAG3Null() {
        return this.IsParamNull(TAG_USERTAG3);
    }

    public final String getUSERTAG3() {
        return this.GetParamStringValue(TAG_USERTAG3, "");
    }

    public final void setUSERTAG3(String strValue) {
        this.SetParamValue(TAG_USERTAG3, strValue);
    }

    public final boolean isUSERCATNull() {
        return this.IsParamNull(TAG_USERCAT);
    }

    public final String getUSERCAT() {
        return this.GetParamStringValue(TAG_USERCAT, "");
    }

    public final void setUSERCAT(String strValue) {
        this.SetParamValue(TAG_USERCAT, strValue);
    }

    public final boolean isUSERTAG2Null() {
        return this.IsParamNull(TAG_USERTAG2);
    }

    public final String getUSERTAG2() {
        return this.GetParamStringValue(TAG_USERTAG2, "");
    }

    public final void setUSERTAG2(String strValue) {
        this.SetParamValue(TAG_USERTAG2, strValue);
    }

    public final boolean isUSERTAGNull() {
        return this.IsParamNull(TAG_USERTAG);
    }

    public final String getUSERTAG() {
        return this.GetParamStringValue(TAG_USERTAG, "");
    }

    public final void setUSERTAG(String strValue) {
        this.SetParamValue(TAG_USERTAG, strValue);
    }

    public final boolean isVRTYPENull() {
        return this.IsParamNull(TAG_VRTYPE);
    }

    public final String getVRTYPE() {
        return this.GetParamStringValue(TAG_VRTYPE, "");
    }

    public final void setVRTYPE(String strValue) {
        this.SetParamValue(TAG_VRTYPE, strValue);
    }

    public final boolean isCHECKMODENull() {
        return this.IsParamNull(TAG_CHECKMODE);
    }

    public final int getCHECKMODE() {
        return this.GetParamIntValue(TAG_CHECKMODE, 0);
    }

    public final void setCHECKMODE(int nValue) {
        this.SetParamValue(TAG_CHECKMODE, nValue);
    }

    public final boolean isORDERVALUENull() {
        return this.IsParamNull(TAG_ORDERVALUE);
    }

    public final int getORDERVALUE() {
        return this.GetParamIntValue(TAG_ORDERVALUE, 0);
    }

    public final void setORDERVALUE(int nValue) {
        this.SetParamValue(TAG_ORDERVALUE, nValue);
    }

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }
}

