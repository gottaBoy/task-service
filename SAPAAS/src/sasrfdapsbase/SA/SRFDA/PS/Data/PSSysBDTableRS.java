/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysBDTableRS
extends BaseDataEntity {
    public static final String TAG_PSSYSBDTABLERSID = "PSSYSBDTABLERSID";
    public static final String TAG_PSSYSBDTABLERSNAME = "PSSYSBDTABLERSNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSBDSCHEMEID = "PSSYSBDSCHEMEID";
    public static final String TAG_PSSYSBDSCHEMENAME = "PSSYSBDSCHEMENAME";
    public static final String TAG_MAJORPSSYSBDTABLEID = "MAJORPSSYSBDTABLEID";
    public static final String TAG_MAJORPSSYSBDTABLENAME = "MAJORPSSYSBDTABLENAME";
    public static final String TAG_MINORPSSYSBDTABLEID = "MINORPSSYSBDTABLEID";
    public static final String TAG_MINORPSSYSBDTABLENAME = "MINORPSSYSBDTABLENAME";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_MINORCODENAME = "MINORCODENAME";
    public static final String TAG_PSDERID = "PSDERID";
    public static final String TAG_PSDERNAME = "PSDERNAME";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";

    public final boolean isPSSYSBDTABLERSIDNull() {
        return this.IsParamNull(TAG_PSSYSBDTABLERSID);
    }

    public final String getPSSYSBDTABLERSID() {
        return this.GetParamStringValue(TAG_PSSYSBDTABLERSID, "");
    }

    public final void setPSSYSBDTABLERSID(String strValue) {
        this.SetParamValue(TAG_PSSYSBDTABLERSID, strValue);
    }

    public final boolean isPSSYSBDTABLERSNAMENull() {
        return this.IsParamNull(TAG_PSSYSBDTABLERSNAME);
    }

    public final String getPSSYSBDTABLERSNAME() {
        return this.GetParamStringValue(TAG_PSSYSBDTABLERSNAME, "");
    }

    public final void setPSSYSBDTABLERSNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSBDTABLERSNAME, strValue);
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

    public final boolean isPSSYSBDSCHEMEIDNull() {
        return this.IsParamNull(TAG_PSSYSBDSCHEMEID);
    }

    public final String getPSSYSBDSCHEMEID() {
        return this.GetParamStringValue(TAG_PSSYSBDSCHEMEID, "");
    }

    public final void setPSSYSBDSCHEMEID(String strValue) {
        this.SetParamValue(TAG_PSSYSBDSCHEMEID, strValue);
    }

    public final boolean isPSSYSBDSCHEMENAMENull() {
        return this.IsParamNull(TAG_PSSYSBDSCHEMENAME);
    }

    public final String getPSSYSBDSCHEMENAME() {
        return this.GetParamStringValue(TAG_PSSYSBDSCHEMENAME, "");
    }

    public final void setPSSYSBDSCHEMENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSBDSCHEMENAME, strValue);
    }

    public final boolean isMAJORPSSYSBDTABLEIDNull() {
        return this.IsParamNull(TAG_MAJORPSSYSBDTABLEID);
    }

    public final String getMAJORPSSYSBDTABLEID() {
        return this.GetParamStringValue(TAG_MAJORPSSYSBDTABLEID, "");
    }

    public final void setMAJORPSSYSBDTABLEID(String strValue) {
        this.SetParamValue(TAG_MAJORPSSYSBDTABLEID, strValue);
    }

    public final boolean isMAJORPSSYSBDTABLENAMENull() {
        return this.IsParamNull(TAG_MAJORPSSYSBDTABLENAME);
    }

    public final String getMAJORPSSYSBDTABLENAME() {
        return this.GetParamStringValue(TAG_MAJORPSSYSBDTABLENAME, "");
    }

    public final void setMAJORPSSYSBDTABLENAME(String strValue) {
        this.SetParamValue(TAG_MAJORPSSYSBDTABLENAME, strValue);
    }

    public final boolean isMINORPSSYSBDTABLEIDNull() {
        return this.IsParamNull(TAG_MINORPSSYSBDTABLEID);
    }

    public final String getMINORPSSYSBDTABLEID() {
        return this.GetParamStringValue(TAG_MINORPSSYSBDTABLEID, "");
    }

    public final void setMINORPSSYSBDTABLEID(String strValue) {
        this.SetParamValue(TAG_MINORPSSYSBDTABLEID, strValue);
    }

    public final boolean isMINORPSSYSBDTABLENAMENull() {
        return this.IsParamNull(TAG_MINORPSSYSBDTABLENAME);
    }

    public final String getMINORPSSYSBDTABLENAME() {
        return this.GetParamStringValue(TAG_MINORPSSYSBDTABLENAME, "");
    }

    public final void setMINORPSSYSBDTABLENAME(String strValue) {
        this.SetParamValue(TAG_MINORPSSYSBDTABLENAME, strValue);
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

    public final boolean isUSERCATNull() {
        return this.IsParamNull(TAG_USERCAT);
    }

    public final String getUSERCAT() {
        return this.GetParamStringValue(TAG_USERCAT, "");
    }

    public final void setUSERCAT(String strValue) {
        this.SetParamValue(TAG_USERCAT, strValue);
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

    public final boolean isUSERTAG2Null() {
        return this.IsParamNull(TAG_USERTAG2);
    }

    public final String getUSERTAG2() {
        return this.GetParamStringValue(TAG_USERTAG2, "");
    }

    public final void setUSERTAG2(String strValue) {
        this.SetParamValue(TAG_USERTAG2, strValue);
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

    public final boolean isUSERTAG4Null() {
        return this.IsParamNull(TAG_USERTAG4);
    }

    public final String getUSERTAG4() {
        return this.GetParamStringValue(TAG_USERTAG4, "");
    }

    public final void setUSERTAG4(String strValue) {
        this.SetParamValue(TAG_USERTAG4, strValue);
    }

    public final boolean isCODENAMENull() {
        return this.IsParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.GetParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.SetParamValue(TAG_CODENAME, strValue);
    }

    public final boolean isMINORCODENAMENull() {
        return this.IsParamNull(TAG_MINORCODENAME);
    }

    public final String getMINORCODENAME() {
        return this.GetParamStringValue(TAG_MINORCODENAME, "");
    }

    public final void setMINORCODENAME(String strValue) {
        this.SetParamValue(TAG_MINORCODENAME, strValue);
    }

    public final boolean isPSDERIDNull() {
        return this.IsParamNull(TAG_PSDERID);
    }

    public final String getPSDERID() {
        return this.GetParamStringValue(TAG_PSDERID, "");
    }

    public final void setPSDERID(String strValue) {
        this.SetParamValue(TAG_PSDERID, strValue);
    }

    public final boolean isPSDERNAMENull() {
        return this.IsParamNull(TAG_PSDERNAME);
    }

    public final String getPSDERNAME() {
        return this.GetParamStringValue(TAG_PSDERNAME, "");
    }

    public final void setPSDERNAME(String strValue) {
        this.SetParamValue(TAG_PSDERNAME, strValue);
    }

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
    }
}

