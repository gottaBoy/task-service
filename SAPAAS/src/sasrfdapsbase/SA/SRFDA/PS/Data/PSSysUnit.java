/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysUnit
extends BaseDataEntity {
    public static final String TAG_PSSYSUNITID = "PSSYSUNITID";
    public static final String TAG_PSSYSUNITNAME = "PSSYSUNITNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_PSUNITID = "PSUNITID";
    public static final String TAG_PSUNITNAME = "PSUNITNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_UNITWIDTH = "UNITWIDTH";
    public static final String TAG_NAMEPSLANGUAGERESID = "NAMEPSLANGUAGERESID";
    public static final String TAG_NAMEPSLANGUAGERESNAME = "NAMEPSLANGUAGERESNAME";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_PSMODULEID = "PSMODULEID";
    public static final String TAG_PSMODULENAME = "PSMODULENAME";
    public static final String TAG_LOCKFLAG = "LOCKFLAG";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_UNITTAG = "UNITTAG";
    public static final String TAG_UNITTAG2 = "UNITTAG2";

    public final boolean isPSSYSUNITIDNull() {
        return this.IsParamNull(TAG_PSSYSUNITID);
    }

    public final String getPSSYSUNITID() {
        return this.GetParamStringValue(TAG_PSSYSUNITID, "");
    }

    public final void setPSSYSUNITID(String strValue) {
        this.SetParamValue(TAG_PSSYSUNITID, strValue);
    }

    public final boolean isPSSYSUNITNAMENull() {
        return this.IsParamNull(TAG_PSSYSUNITNAME);
    }

    public final String getPSSYSUNITNAME() {
        return this.GetParamStringValue(TAG_PSSYSUNITNAME, "");
    }

    public final void setPSSYSUNITNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSUNITNAME, strValue);
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

    public final boolean isPSSYSTEMIDNull() {
        return this.IsParamNull(TAG_PSSYSTEMID);
    }

    public final String getPSSYSTEMID() {
        return this.GetParamStringValue(TAG_PSSYSTEMID, "");
    }

    public final void setPSSYSTEMID(String strValue) {
        this.SetParamValue(TAG_PSSYSTEMID, strValue);
    }

    public final boolean isPSSYSTEMNAMENull() {
        return this.IsParamNull(TAG_PSSYSTEMNAME);
    }

    public final String getPSSYSTEMNAME() {
        return this.GetParamStringValue(TAG_PSSYSTEMNAME, "");
    }

    public final void setPSSYSTEMNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSTEMNAME, strValue);
    }

    public final boolean isPSUNITIDNull() {
        return this.IsParamNull(TAG_PSUNITID);
    }

    public final String getPSUNITID() {
        return this.GetParamStringValue(TAG_PSUNITID, "");
    }

    public final void setPSUNITID(String strValue) {
        this.SetParamValue(TAG_PSUNITID, strValue);
    }

    public final boolean isPSUNITNAMENull() {
        return this.IsParamNull(TAG_PSUNITNAME);
    }

    public final String getPSUNITNAME() {
        return this.GetParamStringValue(TAG_PSUNITNAME, "");
    }

    public final void setPSUNITNAME(String strValue) {
        this.SetParamValue(TAG_PSUNITNAME, strValue);
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

    public final boolean isUNITWIDTHNull() {
        return this.IsParamNull(TAG_UNITWIDTH);
    }

    public final int getUNITWIDTH() {
        return this.GetParamIntValue(TAG_UNITWIDTH, 0);
    }

    public final void setUNITWIDTH(int nValue) {
        this.SetParamValue(TAG_UNITWIDTH, nValue);
    }

    public final boolean isNAMEPSLANGUAGERESIDNull() {
        return this.IsParamNull(TAG_NAMEPSLANGUAGERESID);
    }

    public final String getNAMEPSLANGUAGERESID() {
        return this.GetParamStringValue(TAG_NAMEPSLANGUAGERESID, "");
    }

    public final void setNAMEPSLANGUAGERESID(String strValue) {
        this.SetParamValue(TAG_NAMEPSLANGUAGERESID, strValue);
    }

    public final boolean isNAMEPSLANGUAGERESNAMENull() {
        return this.IsParamNull(TAG_NAMEPSLANGUAGERESNAME);
    }

    public final String getNAMEPSLANGUAGERESNAME() {
        return this.GetParamStringValue(TAG_NAMEPSLANGUAGERESNAME, "");
    }

    public final void setNAMEPSLANGUAGERESNAME(String strValue) {
        this.SetParamValue(TAG_NAMEPSLANGUAGERESNAME, strValue);
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

    public final boolean isPSMODULEIDNull() {
        return this.IsParamNull(TAG_PSMODULEID);
    }

    public final String getPSMODULEID() {
        return this.GetParamStringValue(TAG_PSMODULEID, "");
    }

    public final void setPSMODULEID(String strValue) {
        this.SetParamValue(TAG_PSMODULEID, strValue);
    }

    public final boolean isPSMODULENAMENull() {
        return this.IsParamNull(TAG_PSMODULENAME);
    }

    public final String getPSMODULENAME() {
        return this.GetParamStringValue(TAG_PSMODULENAME, "");
    }

    public final void setPSMODULENAME(String strValue) {
        this.SetParamValue(TAG_PSMODULENAME, strValue);
    }

    public final boolean isLOCKFLAGNull() {
        return this.IsParamNull(TAG_LOCKFLAG);
    }

    public final boolean getLOCKFLAG() {
        return this.GetParamIntValue(TAG_LOCKFLAG, 0) == 1;
    }

    public final void setLOCKFLAG(boolean bValue) {
        this.SetParamValue(TAG_LOCKFLAG, bValue ? 1 : 0);
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

    public final boolean isUSERCATNull() {
        return this.IsParamNull(TAG_USERCAT);
    }

    public final String getUSERCAT() {
        return this.GetParamStringValue(TAG_USERCAT, "");
    }

    public final void setUSERCAT(String strValue) {
        this.SetParamValue(TAG_USERCAT, strValue);
    }

    public final boolean isUNITTAGNull() {
        return this.IsParamNull(TAG_UNITTAG);
    }

    public final String getUNITTAG() {
        return this.GetParamStringValue(TAG_UNITTAG, "");
    }

    public final void setUNITTAG(String strValue) {
        this.SetParamValue(TAG_UNITTAG, strValue);
    }

    public final boolean isUNITTAG2Null() {
        return this.IsParamNull(TAG_UNITTAG2);
    }

    public final String getUNITTAG2() {
        return this.GetParamStringValue(TAG_UNITTAG2, "");
    }

    public final void setUNITTAG2(String strValue) {
        this.SetParamValue(TAG_UNITTAG2, strValue);
    }
}

