/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDENotifyTarget
extends BaseDataEntity {
    public static final String TARGETTYPE_DEFIELD = "DEFIELD";
    public static final String TARGETTYPE_SYSMSGTARGET = "SYSMSGTARGET";
    public static final String TARGETTYPE_USER = "USER";
    public static final String TARGETTYPE_USER2 = "USER2";
    public static final String USERCAT_CAT1 = "CAT1";
    public static final String USERCAT_CAT2 = "CAT2";
    public static final String USERCAT_CAT3 = "CAT3";
    public static final String USERCAT_CAT4 = "CAT4";
    public static final String USERCAT_CAT5 = "CAT5";
    public static final String USERCAT_CAT6 = "CAT6";
    public static final String USERCAT_CAT7 = "CAT7";
    public static final String USERCAT_CAT8 = "CAT8";
    public static final String USERCAT_CAT9 = "CAT9";
    public static final String TAG_PSDENOTIFYTARGETID = "PSDENOTIFYTARGETID";
    public static final String TAG_PSDENOTIFYTARGETNAME = "PSDENOTIFYTARGETNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDENOTIFYID = "PSDENOTIFYID";
    public static final String TAG_PSDENOTIFYNAME = "PSDENOTIFYNAME";
    public static final String TAG_TARGETTYPE = "TARGETTYPE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_PSSYSMSGTARGETID = "PSSYSMSGTARGETID";
    public static final String TAG_PSSYSMSGTARGETNAME = "PSSYSMSGTARGETNAME";
    public static final String TAG_FILTER = "FILTER";
    public static final String TAG_TARGETPSDEFID = "TARGETPSDEFID";
    public static final String TAG_TARGETPSDEFNAME = "TARGETPSDEFNAME";
    public static final String TAG_TARGETTYPEPSDEFID = "TARGETTYPEPSDEFID";
    public static final String TAG_TARGETTYPEPSDEFNAME = "TARGETTYPEPSDEFNAME";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_DATA = "DATA";

    public final boolean isPSDENOTIFYTARGETIDNull() {
        return this.IsParamNull(TAG_PSDENOTIFYTARGETID);
    }

    public final String getPSDENOTIFYTARGETID() {
        return this.GetParamStringValue(TAG_PSDENOTIFYTARGETID, "");
    }

    public final void setPSDENOTIFYTARGETID(String strValue) {
        this.SetParamValue(TAG_PSDENOTIFYTARGETID, strValue);
    }

    public final boolean isPSDENOTIFYTARGETNAMENull() {
        return this.IsParamNull(TAG_PSDENOTIFYTARGETNAME);
    }

    public final String getPSDENOTIFYTARGETNAME() {
        return this.GetParamStringValue(TAG_PSDENOTIFYTARGETNAME, "");
    }

    public final void setPSDENOTIFYTARGETNAME(String strValue) {
        this.SetParamValue(TAG_PSDENOTIFYTARGETNAME, strValue);
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

    public final boolean isPSDENOTIFYIDNull() {
        return this.IsParamNull(TAG_PSDENOTIFYID);
    }

    public final String getPSDENOTIFYID() {
        return this.GetParamStringValue(TAG_PSDENOTIFYID, "");
    }

    public final void setPSDENOTIFYID(String strValue) {
        this.SetParamValue(TAG_PSDENOTIFYID, strValue);
    }

    public final boolean isPSDENOTIFYNAMENull() {
        return this.IsParamNull(TAG_PSDENOTIFYNAME);
    }

    public final String getPSDENOTIFYNAME() {
        return this.GetParamStringValue(TAG_PSDENOTIFYNAME, "");
    }

    public final void setPSDENOTIFYNAME(String strValue) {
        this.SetParamValue(TAG_PSDENOTIFYNAME, strValue);
    }

    public final boolean isTARGETTYPENull() {
        return this.IsParamNull(TAG_TARGETTYPE);
    }

    public final String getTARGETTYPE() {
        return this.GetParamStringValue(TAG_TARGETTYPE, "");
    }

    public final void setTARGETTYPE(String strValue) {
        this.SetParamValue(TAG_TARGETTYPE, strValue);
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

    public final boolean isUSERCATNull() {
        return this.IsParamNull(TAG_USERCAT);
    }

    public final String getUSERCAT() {
        return this.GetParamStringValue(TAG_USERCAT, "");
    }

    public final void setUSERCAT(String strValue) {
        this.SetParamValue(TAG_USERCAT, strValue);
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

    public final boolean isPSSYSMSGTARGETIDNull() {
        return this.IsParamNull(TAG_PSSYSMSGTARGETID);
    }

    public final String getPSSYSMSGTARGETID() {
        return this.GetParamStringValue(TAG_PSSYSMSGTARGETID, "");
    }

    public final void setPSSYSMSGTARGETID(String strValue) {
        this.SetParamValue(TAG_PSSYSMSGTARGETID, strValue);
    }

    public final boolean isPSSYSMSGTARGETNAMENull() {
        return this.IsParamNull(TAG_PSSYSMSGTARGETNAME);
    }

    public final String getPSSYSMSGTARGETNAME() {
        return this.GetParamStringValue(TAG_PSSYSMSGTARGETNAME, "");
    }

    public final void setPSSYSMSGTARGETNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSMSGTARGETNAME, strValue);
    }

    public final boolean isFILTERNull() {
        return this.IsParamNull(TAG_FILTER);
    }

    public final String getFILTER() {
        return this.GetParamStringValue(TAG_FILTER, "");
    }

    public final void setFILTER(String strValue) {
        this.SetParamValue(TAG_FILTER, strValue);
    }

    public final boolean isTARGETPSDEFIDNull() {
        return this.IsParamNull(TAG_TARGETPSDEFID);
    }

    public final String getTARGETPSDEFID() {
        return this.GetParamStringValue(TAG_TARGETPSDEFID, "");
    }

    public final void setTARGETPSDEFID(String strValue) {
        this.SetParamValue(TAG_TARGETPSDEFID, strValue);
    }

    public final boolean isTARGETPSDEFNAMENull() {
        return this.IsParamNull(TAG_TARGETPSDEFNAME);
    }

    public final String getTARGETPSDEFNAME() {
        return this.GetParamStringValue(TAG_TARGETPSDEFNAME, "");
    }

    public final void setTARGETPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_TARGETPSDEFNAME, strValue);
    }

    public final boolean isTARGETTYPEPSDEFIDNull() {
        return this.IsParamNull(TAG_TARGETTYPEPSDEFID);
    }

    public final String getTARGETTYPEPSDEFID() {
        return this.GetParamStringValue(TAG_TARGETTYPEPSDEFID, "");
    }

    public final void setTARGETTYPEPSDEFID(String strValue) {
        this.SetParamValue(TAG_TARGETTYPEPSDEFID, strValue);
    }

    public final boolean isTARGETTYPEPSDEFNAMENull() {
        return this.IsParamNull(TAG_TARGETTYPEPSDEFNAME);
    }

    public final String getTARGETTYPEPSDEFNAME() {
        return this.GetParamStringValue(TAG_TARGETTYPEPSDEFNAME, "");
    }

    public final void setTARGETTYPEPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_TARGETTYPEPSDEFNAME, strValue);
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

    public final boolean isDATANull() {
        return this.IsParamNull(TAG_DATA);
    }

    public final String getDATA() {
        return this.GetParamStringValue(TAG_DATA, "");
    }

    public final void setDATA(String strValue) {
        this.SetParamValue(TAG_DATA, strValue);
    }
}

