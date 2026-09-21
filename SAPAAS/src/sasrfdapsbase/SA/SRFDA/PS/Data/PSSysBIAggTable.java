/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysBIAggTable
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
    public static final String TAG_PSSYSBIAGGTABLEID = "PSSYSBIAGGTABLEID";
    public static final String TAG_PSSYSBIAGGTABLENAME = "PSSYSBIAGGTABLENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSBICUBEID = "PSSYSBICUBEID";
    public static final String TAG_PSSYSBICUBENAME = "PSSYSBICUBENAME";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_BIAGGTABLETAG = "BIAGGTABLETAG";
    public static final String TAG_BIAGGTABLETAG2 = "BIAGGTABLETAG2";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_REALTIMEMODE = "REALTIMEMODE";
    public static final String TAG_PSSYSBISCHEMEID = "PSSYSBISCHEMEID";
    public static final String TAG_PSSYSBISCHEMENAME = "PSSYSBISCHEMENAME";
    public static final String TAG_PSDEDATAQUERYID = "PSDEDATAQUERYID";
    public static final String TAG_PSDEDATAQUERYNAME = "PSDEDATAQUERYNAME";

    public final boolean isPSSYSBIAGGTABLEIDNull() {
        return this.IsParamNull(TAG_PSSYSBIAGGTABLEID);
    }

    public final String getPSSYSBIAGGTABLEID() {
        return this.GetParamStringValue(TAG_PSSYSBIAGGTABLEID, "");
    }

    public final void setPSSYSBIAGGTABLEID(String strValue) {
        this.SetParamValue(TAG_PSSYSBIAGGTABLEID, strValue);
    }

    public final boolean isPSSYSBIAGGTABLENAMENull() {
        return this.IsParamNull(TAG_PSSYSBIAGGTABLENAME);
    }

    public final String getPSSYSBIAGGTABLENAME() {
        return this.GetParamStringValue(TAG_PSSYSBIAGGTABLENAME, "");
    }

    public final void setPSSYSBIAGGTABLENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSBIAGGTABLENAME, strValue);
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

    public final boolean isPSSYSBICUBEIDNull() {
        return this.IsParamNull(TAG_PSSYSBICUBEID);
    }

    public final String getPSSYSBICUBEID() {
        return this.GetParamStringValue(TAG_PSSYSBICUBEID, "");
    }

    public final void setPSSYSBICUBEID(String strValue) {
        this.SetParamValue(TAG_PSSYSBICUBEID, strValue);
    }

    public final boolean isPSSYSBICUBENAMENull() {
        return this.IsParamNull(TAG_PSSYSBICUBENAME);
    }

    public final String getPSSYSBICUBENAME() {
        return this.GetParamStringValue(TAG_PSSYSBICUBENAME, "");
    }

    public final void setPSSYSBICUBENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSBICUBENAME, strValue);
    }

    public final boolean isPSDEIDNull() {
        return this.IsParamNull(TAG_PSDEID);
    }

    public final String getPSDEID() {
        return this.GetParamStringValue(TAG_PSDEID, "");
    }

    public final void setPSDEID(String strValue) {
        this.SetParamValue(TAG_PSDEID, strValue);
    }

    public final boolean isPSDENAMENull() {
        return this.IsParamNull(TAG_PSDENAME);
    }

    public final String getPSDENAME() {
        return this.GetParamStringValue(TAG_PSDENAME, "");
    }

    public final void setPSDENAME(String strValue) {
        this.SetParamValue(TAG_PSDENAME, strValue);
    }

    public final boolean isBIAGGTABLETAGNull() {
        return this.IsParamNull(TAG_BIAGGTABLETAG);
    }

    public final String getBIAGGTABLETAG() {
        return this.GetParamStringValue(TAG_BIAGGTABLETAG, "");
    }

    public final void setBIAGGTABLETAG(String strValue) {
        this.SetParamValue(TAG_BIAGGTABLETAG, strValue);
    }

    public final boolean isBIAGGTABLETAG2Null() {
        return this.IsParamNull(TAG_BIAGGTABLETAG2);
    }

    public final String getBIAGGTABLETAG2() {
        return this.GetParamStringValue(TAG_BIAGGTABLETAG2, "");
    }

    public final void setBIAGGTABLETAG2(String strValue) {
        this.SetParamValue(TAG_BIAGGTABLETAG2, strValue);
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

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
    }

    public final boolean isREALTIMEMODENull() {
        return this.IsParamNull(TAG_REALTIMEMODE);
    }

    public final boolean getREALTIMEMODE() {
        return this.GetParamIntValue(TAG_REALTIMEMODE, 0) == 1;
    }

    public final void setREALTIMEMODE(boolean bValue) {
        this.SetParamValue(TAG_REALTIMEMODE, bValue ? 1 : 0);
    }

    public final boolean isPSSYSBISCHEMEIDNull() {
        return this.IsParamNull(TAG_PSSYSBISCHEMEID);
    }

    public final String getPSSYSBISCHEMEID() {
        return this.GetParamStringValue(TAG_PSSYSBISCHEMEID, "");
    }

    public final void setPSSYSBISCHEMEID(String strValue) {
        this.SetParamValue(TAG_PSSYSBISCHEMEID, strValue);
    }

    public final boolean isPSSYSBISCHEMENAMENull() {
        return this.IsParamNull(TAG_PSSYSBISCHEMENAME);
    }

    public final String getPSSYSBISCHEMENAME() {
        return this.GetParamStringValue(TAG_PSSYSBISCHEMENAME, "");
    }

    public final void setPSSYSBISCHEMENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSBISCHEMENAME, strValue);
    }

    public final boolean isPSDEDATAQUERYIDNull() {
        return this.IsParamNull(TAG_PSDEDATAQUERYID);
    }

    public final String getPSDEDATAQUERYID() {
        return this.GetParamStringValue(TAG_PSDEDATAQUERYID, "");
    }

    public final void setPSDEDATAQUERYID(String strValue) {
        this.SetParamValue(TAG_PSDEDATAQUERYID, strValue);
    }

    public final boolean isPSDEDATAQUERYNAMENull() {
        return this.IsParamNull(TAG_PSDEDATAQUERYNAME);
    }

    public final String getPSDEDATAQUERYNAME() {
        return this.GetParamStringValue(TAG_PSDEDATAQUERYNAME, "");
    }

    public final void setPSDEDATAQUERYNAME(String strValue) {
        this.SetParamValue(TAG_PSDEDATAQUERYNAME, strValue);
    }
}

