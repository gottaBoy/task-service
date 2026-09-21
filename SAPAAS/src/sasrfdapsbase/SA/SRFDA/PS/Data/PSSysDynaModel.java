/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysDynaModel
extends BaseDataEntity {
    public static final String TAG_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String TAG_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String TAG_PPSSYSDYNAMODELID = "PPSSYSDYNAMODELID";
    public static final String TAG_PPSSYSDYNAMODELNAME = "PPSSYSDYNAMODELNAME";
    public static final String TAG_MODELTAG = "MODELTAG";
    public static final String TAG_DYNAMODEL = "DYNAMODEL";
    public static final String TAG_DYNAMODEL2 = "DYNAMODEL2";
    public static final String TAG_PSMODULEID = "PSMODULEID";
    public static final String TAG_PSMODULENAME = "PSMODULENAME";
    public static final String TAG_LOCKFLAG = "LOCKFLAG";
    public static final String TAG_PSSYSDYNAMODELCATID = "PSSYSDYNAMODELCATID";
    public static final String TAG_PSSYSDYNAMODELCATNAME = "PSSYSDYNAMODELCATNAME";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_DYNAMODELFMT = "DYNAMODELFMT";
    public static final String TAG_DYNAMODELUSAGE = "DYNAMODELUSAGE";
    public static final String TAG_DTOCODENAME = "DTOCODENAME";
    public static final String TAG_MODELTAG2 = "MODELTAG2";
    public static final String TAG_MODELTAG3 = "MODELTAG3";
    public static final String TAG_MODELTAG4 = "MODELTAG4";

    public final boolean isPSSYSDYNAMODELIDNull() {
        return this.IsParamNull(TAG_PSSYSDYNAMODELID);
    }

    public final String getPSSYSDYNAMODELID() {
        return this.GetParamStringValue(TAG_PSSYSDYNAMODELID, "");
    }

    public final void setPSSYSDYNAMODELID(String strValue) {
        this.SetParamValue(TAG_PSSYSDYNAMODELID, strValue);
    }

    public final boolean isPSSYSDYNAMODELNAMENull() {
        return this.IsParamNull(TAG_PSSYSDYNAMODELNAME);
    }

    public final String getPSSYSDYNAMODELNAME() {
        return this.GetParamStringValue(TAG_PSSYSDYNAMODELNAME, "");
    }

    public final void setPSSYSDYNAMODELNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSDYNAMODELNAME, strValue);
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

    public final boolean isLOGICNAMENull() {
        return this.IsParamNull(TAG_LOGICNAME);
    }

    public final String getLOGICNAME() {
        return this.GetParamStringValue(TAG_LOGICNAME, "");
    }

    public final void setLOGICNAME(String strValue) {
        this.SetParamValue(TAG_LOGICNAME, strValue);
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

    public final boolean isDEFAULTFLAGNull() {
        return this.IsParamNull(TAG_DEFAULTFLAG);
    }

    public final boolean getDEFAULTFLAG() {
        return this.GetParamIntValue(TAG_DEFAULTFLAG, 0) == 1;
    }

    public final void setDEFAULTFLAG(boolean bValue) {
        this.SetParamValue(TAG_DEFAULTFLAG, bValue ? 1 : 0);
    }

    public final boolean isPPSSYSDYNAMODELIDNull() {
        return this.IsParamNull(TAG_PPSSYSDYNAMODELID);
    }

    public final String getPPSSYSDYNAMODELID() {
        return this.GetParamStringValue(TAG_PPSSYSDYNAMODELID, "");
    }

    public final void setPPSSYSDYNAMODELID(String strValue) {
        this.SetParamValue(TAG_PPSSYSDYNAMODELID, strValue);
    }

    public final boolean isPPSSYSDYNAMODELNAMENull() {
        return this.IsParamNull(TAG_PPSSYSDYNAMODELNAME);
    }

    public final String getPPSSYSDYNAMODELNAME() {
        return this.GetParamStringValue(TAG_PPSSYSDYNAMODELNAME, "");
    }

    public final void setPPSSYSDYNAMODELNAME(String strValue) {
        this.SetParamValue(TAG_PPSSYSDYNAMODELNAME, strValue);
    }

    public final boolean isMODELTAGNull() {
        return this.IsParamNull(TAG_MODELTAG);
    }

    public final String getMODELTAG() {
        return this.GetParamStringValue(TAG_MODELTAG, "");
    }

    public final void setMODELTAG(String strValue) {
        this.SetParamValue(TAG_MODELTAG, strValue);
    }

    public final boolean isDYNAMODELNull() {
        return this.IsParamNull(TAG_DYNAMODEL);
    }

    public final String getDYNAMODEL() {
        return this.GetParamStringValue(TAG_DYNAMODEL, "");
    }

    public final void setDYNAMODEL(String strValue) {
        this.SetParamValue(TAG_DYNAMODEL, strValue);
    }

    public final boolean isDYNAMODEL2Null() {
        return this.IsParamNull(TAG_DYNAMODEL2);
    }

    public final String getDYNAMODEL2() {
        return this.GetParamStringValue(TAG_DYNAMODEL2, "");
    }

    public final void setDYNAMODEL2(String strValue) {
        this.SetParamValue(TAG_DYNAMODEL2, strValue);
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

    public final boolean isPSSYSDYNAMODELCATIDNull() {
        return this.IsParamNull(TAG_PSSYSDYNAMODELCATID);
    }

    public final String getPSSYSDYNAMODELCATID() {
        return this.GetParamStringValue(TAG_PSSYSDYNAMODELCATID, "");
    }

    public final void setPSSYSDYNAMODELCATID(String strValue) {
        this.SetParamValue(TAG_PSSYSDYNAMODELCATID, strValue);
    }

    public final boolean isPSSYSDYNAMODELCATNAMENull() {
        return this.IsParamNull(TAG_PSSYSDYNAMODELCATNAME);
    }

    public final String getPSSYSDYNAMODELCATNAME() {
        return this.GetParamStringValue(TAG_PSSYSDYNAMODELCATNAME, "");
    }

    public final void setPSSYSDYNAMODELCATNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSDYNAMODELCATNAME, strValue);
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

    public final boolean isDYNAMODELFMTNull() {
        return this.IsParamNull(TAG_DYNAMODELFMT);
    }

    public final String getDYNAMODELFMT() {
        return this.GetParamStringValue(TAG_DYNAMODELFMT, "");
    }

    public final void setDYNAMODELFMT(String strValue) {
        this.SetParamValue(TAG_DYNAMODELFMT, strValue);
    }

    public final boolean isDYNAMODELUSAGENull() {
        return this.IsParamNull(TAG_DYNAMODELUSAGE);
    }

    public final String getDYNAMODELUSAGE() {
        return this.GetParamStringValue(TAG_DYNAMODELUSAGE, "");
    }

    public final void setDYNAMODELUSAGE(String strValue) {
        this.SetParamValue(TAG_DYNAMODELUSAGE, strValue);
    }

    public final boolean isDTOCODENAMENull() {
        return this.IsParamNull(TAG_DTOCODENAME);
    }

    public final String getDTOCODENAME() {
        return this.GetParamStringValue(TAG_DTOCODENAME, "");
    }

    public final void setDTOCODENAME(String strValue) {
        this.SetParamValue(TAG_DTOCODENAME, strValue);
    }

    public final boolean isMODELTAG2Null() {
        return this.IsParamNull(TAG_MODELTAG2);
    }

    public final String getMODELTAG2() {
        return this.GetParamStringValue(TAG_MODELTAG2, "");
    }

    public final void setMODELTAG2(String strValue) {
        this.SetParamValue(TAG_MODELTAG2, strValue);
    }

    public final boolean isMODELTAG3Null() {
        return this.IsParamNull(TAG_MODELTAG3);
    }

    public final String getMODELTAG3() {
        return this.GetParamStringValue(TAG_MODELTAG3, "");
    }

    public final void setMODELTAG3(String strValue) {
        this.SetParamValue(TAG_MODELTAG3, strValue);
    }

    public final boolean isMODELTAG4Null() {
        return this.IsParamNull(TAG_MODELTAG4);
    }

    public final String getMODELTAG4() {
        return this.GetParamStringValue(TAG_MODELTAG4, "");
    }

    public final void setMODELTAG4(String strValue) {
        this.SetParamValue(TAG_MODELTAG4, strValue);
    }
}

