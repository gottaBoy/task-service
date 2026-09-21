/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSSysUniState
extends BaseDataEntity {
    public static final String UNISTATETYPE_DE = "DE";
    public static final String TAG_PSSYSUNISTATEID = "PSSYSUNISTATEID";
    public static final String TAG_PSSYSUNISTATENAME = "PSSYSUNISTATENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_UNIQUETAG = "UNIQUETAG";
    public static final String TAG_KEYPSDEFID = "KEYPSDEFID";
    public static final String TAG_KEYPSDEFNAME = "KEYPSDEFNAME";
    public static final String TAG_KEY2PSDEFID = "KEY2PSDEFID";
    public static final String TAG_KEY2PSDEFNAME = "KEY2PSDEFNAME";
    public static final String TAG_KEY3PSDEFID = "KEY3PSDEFID";
    public static final String TAG_KEY3PSDEFNAME = "KEY3PSDEFNAME";
    public static final String TAG_STATEPSDEFID = "STATEPSDEFID";
    public static final String TAG_STATEPSDEFNAME = "STATEPSDEFNAME";
    public static final String TAG_STATE2PSDEFID = "STATE2PSDEFID";
    public static final String TAG_STATE2PSDEFNAME = "STATE2PSDEFNAME";
    public static final String TAG_STATE3PSDEFID = "STATE3PSDEFID";
    public static final String TAG_STATE3PSDEFNAME = "STATE3PSDEFNAME";
    public static final String TAG_STATE4PSDEFID = "STATE4PSDEFID";
    public static final String TAG_STATE4PSDEFNAME = "STATE4PSDEFNAME";
    public static final String TAG_STATE5PSDEFID = "STATE5PSDEFID";
    public static final String TAG_STATE5PSDEFNAME = "STATE5PSDEFNAME";
    public static final String TAG_STATE6PSDEFID = "STATE6PSDEFID";
    public static final String TAG_STATE6PSDEFNAME = "STATE6PSDEFNAME";
    public static final String TAG_STATE7PSDEFID = "STATE7PSDEFID";
    public static final String TAG_STATE7PSDEFNAME = "STATE7PSDEFNAME";
    public static final String TAG_STATE8PSDEFID = "STATE8PSDEFID";
    public static final String TAG_STATE8PSDEFNAME = "STATE8PSDEFNAME";
    public static final String TAG_KEY4PSDEFID = "KEY4PSDEFID";
    public static final String TAG_KEY4PSDEFNAME = "KEY4PSDEFNAME";
    public static final String TAG_UNISTATETYPE = "UNISTATETYPE";
    public static final String TAG_DEDEFAULTFLAG = "DEDEFAULTFLAG";

    public final boolean isPSSYSUNISTATEIDNull() {
        return this.isParamNull(TAG_PSSYSUNISTATEID);
    }

    public final String getPSSYSUNISTATEID() {
        return this.getParamStringValue(TAG_PSSYSUNISTATEID, "");
    }

    public final void setPSSYSUNISTATEID(String strValue) {
        this.setParamValue(TAG_PSSYSUNISTATEID, strValue);
    }

    public final boolean isPSSYSUNISTATENAMENull() {
        return this.isParamNull(TAG_PSSYSUNISTATENAME);
    }

    public final String getPSSYSUNISTATENAME() {
        return this.getParamStringValue(TAG_PSSYSUNISTATENAME, "");
    }

    public final void setPSSYSUNISTATENAME(String strValue) {
        this.setParamValue(TAG_PSSYSUNISTATENAME, strValue);
    }

    public final boolean isCREATEMANNull() {
        return this.isParamNull(TAG_CREATEMAN);
    }

    public final String getCREATEMAN() {
        return this.getParamStringValue(TAG_CREATEMAN, "");
    }

    public final void setCREATEMAN(String strValue) {
        this.setParamValue(TAG_CREATEMAN, strValue);
    }

    public final boolean isCREATEDATENull() {
        return this.isParamNull(TAG_CREATEDATE);
    }

    public final Date getCREATEDATE() {
        return this.getParamDateValue(TAG_CREATEDATE, null);
    }

    public final void setCREATEDATE(Date dtValue) {
        this.setParamValue(TAG_CREATEDATE, dtValue);
    }

    public final boolean isUPDATEMANNull() {
        return this.isParamNull(TAG_UPDATEMAN);
    }

    public final String getUPDATEMAN() {
        return this.getParamStringValue(TAG_UPDATEMAN, "");
    }

    public final void setUPDATEMAN(String strValue) {
        this.setParamValue(TAG_UPDATEMAN, strValue);
    }

    public final boolean isUPDATEDATENull() {
        return this.isParamNull(TAG_UPDATEDATE);
    }

    public final Date getUPDATEDATE() {
        return this.getParamDateValue(TAG_UPDATEDATE, null);
    }

    public final void setUPDATEDATE(Date dtValue) {
        this.setParamValue(TAG_UPDATEDATE, dtValue);
    }

    public final boolean isPSSYSTEMIDNull() {
        return this.isParamNull(TAG_PSSYSTEMID);
    }

    public final String getPSSYSTEMID() {
        return this.getParamStringValue(TAG_PSSYSTEMID, "");
    }

    public final void setPSSYSTEMID(String strValue) {
        this.setParamValue(TAG_PSSYSTEMID, strValue);
    }

    public final boolean isPSSYSTEMNAMENull() {
        return this.isParamNull(TAG_PSSYSTEMNAME);
    }

    public final String getPSSYSTEMNAME() {
        return this.getParamStringValue(TAG_PSSYSTEMNAME, "");
    }

    public final void setPSSYSTEMNAME(String strValue) {
        this.setParamValue(TAG_PSSYSTEMNAME, strValue);
    }

    public final boolean isPSDEIDNull() {
        return this.isParamNull(TAG_PSDEID);
    }

    public final String getPSDEID() {
        return this.getParamStringValue(TAG_PSDEID, "");
    }

    public final void setPSDEID(String strValue) {
        this.setParamValue(TAG_PSDEID, strValue);
    }

    public final boolean isPSDENAMENull() {
        return this.isParamNull(TAG_PSDENAME);
    }

    public final String getPSDENAME() {
        return this.getParamStringValue(TAG_PSDENAME, "");
    }

    public final void setPSDENAME(String strValue) {
        this.setParamValue(TAG_PSDENAME, strValue);
    }

    public final boolean isVALIDFLAGNull() {
        return this.isParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.getParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.setParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
    }

    public final boolean isUSERTAGNull() {
        return this.isParamNull(TAG_USERTAG);
    }

    public final String getUSERTAG() {
        return this.getParamStringValue(TAG_USERTAG, "");
    }

    public final void setUSERTAG(String strValue) {
        this.setParamValue(TAG_USERTAG, strValue);
    }

    public final boolean isUSERTAG2Null() {
        return this.isParamNull(TAG_USERTAG2);
    }

    public final String getUSERTAG2() {
        return this.getParamStringValue(TAG_USERTAG2, "");
    }

    public final void setUSERTAG2(String strValue) {
        this.setParamValue(TAG_USERTAG2, strValue);
    }

    public final boolean isMEMONull() {
        return this.isParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.getParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.setParamValue(TAG_MEMO, strValue);
    }

    public final boolean isUNIQUETAGNull() {
        return this.isParamNull(TAG_UNIQUETAG);
    }

    public final String getUNIQUETAG() {
        return this.getParamStringValue(TAG_UNIQUETAG, "");
    }

    public final void setUNIQUETAG(String strValue) {
        this.setParamValue(TAG_UNIQUETAG, strValue);
    }

    public final boolean isKEYPSDEFIDNull() {
        return this.isParamNull(TAG_KEYPSDEFID);
    }

    public final String getKEYPSDEFID() {
        return this.getParamStringValue(TAG_KEYPSDEFID, "");
    }

    public final void setKEYPSDEFID(String strValue) {
        this.setParamValue(TAG_KEYPSDEFID, strValue);
    }

    public final boolean isKEYPSDEFNAMENull() {
        return this.isParamNull(TAG_KEYPSDEFNAME);
    }

    public final String getKEYPSDEFNAME() {
        return this.getParamStringValue(TAG_KEYPSDEFNAME, "");
    }

    public final void setKEYPSDEFNAME(String strValue) {
        this.setParamValue(TAG_KEYPSDEFNAME, strValue);
    }

    public final boolean isKEY2PSDEFIDNull() {
        return this.isParamNull(TAG_KEY2PSDEFID);
    }

    public final String getKEY2PSDEFID() {
        return this.getParamStringValue(TAG_KEY2PSDEFID, "");
    }

    public final void setKEY2PSDEFID(String strValue) {
        this.setParamValue(TAG_KEY2PSDEFID, strValue);
    }

    public final boolean isKEY2PSDEFNAMENull() {
        return this.isParamNull(TAG_KEY2PSDEFNAME);
    }

    public final String getKEY2PSDEFNAME() {
        return this.getParamStringValue(TAG_KEY2PSDEFNAME, "");
    }

    public final void setKEY2PSDEFNAME(String strValue) {
        this.setParamValue(TAG_KEY2PSDEFNAME, strValue);
    }

    public final boolean isKEY3PSDEFIDNull() {
        return this.isParamNull(TAG_KEY3PSDEFID);
    }

    public final String getKEY3PSDEFID() {
        return this.getParamStringValue(TAG_KEY3PSDEFID, "");
    }

    public final void setKEY3PSDEFID(String strValue) {
        this.setParamValue(TAG_KEY3PSDEFID, strValue);
    }

    public final boolean isKEY3PSDEFNAMENull() {
        return this.isParamNull(TAG_KEY3PSDEFNAME);
    }

    public final String getKEY3PSDEFNAME() {
        return this.getParamStringValue(TAG_KEY3PSDEFNAME, "");
    }

    public final void setKEY3PSDEFNAME(String strValue) {
        this.setParamValue(TAG_KEY3PSDEFNAME, strValue);
    }

    public final boolean isSTATEPSDEFIDNull() {
        return this.isParamNull(TAG_STATEPSDEFID);
    }

    public final String getSTATEPSDEFID() {
        return this.getParamStringValue(TAG_STATEPSDEFID, "");
    }

    public final void setSTATEPSDEFID(String strValue) {
        this.setParamValue(TAG_STATEPSDEFID, strValue);
    }

    public final boolean isSTATEPSDEFNAMENull() {
        return this.isParamNull(TAG_STATEPSDEFNAME);
    }

    public final String getSTATEPSDEFNAME() {
        return this.getParamStringValue(TAG_STATEPSDEFNAME, "");
    }

    public final void setSTATEPSDEFNAME(String strValue) {
        this.setParamValue(TAG_STATEPSDEFNAME, strValue);
    }

    public final boolean isSTATE2PSDEFIDNull() {
        return this.isParamNull(TAG_STATE2PSDEFID);
    }

    public final String getSTATE2PSDEFID() {
        return this.getParamStringValue(TAG_STATE2PSDEFID, "");
    }

    public final void setSTATE2PSDEFID(String strValue) {
        this.setParamValue(TAG_STATE2PSDEFID, strValue);
    }

    public final boolean isSTATE2PSDEFNAMENull() {
        return this.isParamNull(TAG_STATE2PSDEFNAME);
    }

    public final String getSTATE2PSDEFNAME() {
        return this.getParamStringValue(TAG_STATE2PSDEFNAME, "");
    }

    public final void setSTATE2PSDEFNAME(String strValue) {
        this.setParamValue(TAG_STATE2PSDEFNAME, strValue);
    }

    public final boolean isSTATE3PSDEFIDNull() {
        return this.isParamNull(TAG_STATE3PSDEFID);
    }

    public final String getSTATE3PSDEFID() {
        return this.getParamStringValue(TAG_STATE3PSDEFID, "");
    }

    public final void setSTATE3PSDEFID(String strValue) {
        this.setParamValue(TAG_STATE3PSDEFID, strValue);
    }

    public final boolean isSTATE3PSDEFNAMENull() {
        return this.isParamNull(TAG_STATE3PSDEFNAME);
    }

    public final String getSTATE3PSDEFNAME() {
        return this.getParamStringValue(TAG_STATE3PSDEFNAME, "");
    }

    public final void setSTATE3PSDEFNAME(String strValue) {
        this.setParamValue(TAG_STATE3PSDEFNAME, strValue);
    }

    public final boolean isSTATE4PSDEFIDNull() {
        return this.isParamNull(TAG_STATE4PSDEFID);
    }

    public final String getSTATE4PSDEFID() {
        return this.getParamStringValue(TAG_STATE4PSDEFID, "");
    }

    public final void setSTATE4PSDEFID(String strValue) {
        this.setParamValue(TAG_STATE4PSDEFID, strValue);
    }

    public final boolean isSTATE4PSDEFNAMENull() {
        return this.isParamNull(TAG_STATE4PSDEFNAME);
    }

    public final String getSTATE4PSDEFNAME() {
        return this.getParamStringValue(TAG_STATE4PSDEFNAME, "");
    }

    public final void setSTATE4PSDEFNAME(String strValue) {
        this.setParamValue(TAG_STATE4PSDEFNAME, strValue);
    }

    public final boolean isSTATE5PSDEFIDNull() {
        return this.isParamNull(TAG_STATE5PSDEFID);
    }

    public final String getSTATE5PSDEFID() {
        return this.getParamStringValue(TAG_STATE5PSDEFID, "");
    }

    public final void setSTATE5PSDEFID(String strValue) {
        this.setParamValue(TAG_STATE5PSDEFID, strValue);
    }

    public final boolean isSTATE5PSDEFNAMENull() {
        return this.isParamNull(TAG_STATE5PSDEFNAME);
    }

    public final String getSTATE5PSDEFNAME() {
        return this.getParamStringValue(TAG_STATE5PSDEFNAME, "");
    }

    public final void setSTATE5PSDEFNAME(String strValue) {
        this.setParamValue(TAG_STATE5PSDEFNAME, strValue);
    }

    public final boolean isSTATE6PSDEFIDNull() {
        return this.isParamNull(TAG_STATE6PSDEFID);
    }

    public final String getSTATE6PSDEFID() {
        return this.getParamStringValue(TAG_STATE6PSDEFID, "");
    }

    public final void setSTATE6PSDEFID(String strValue) {
        this.setParamValue(TAG_STATE6PSDEFID, strValue);
    }

    public final boolean isSTATE6PSDEFNAMENull() {
        return this.isParamNull(TAG_STATE6PSDEFNAME);
    }

    public final String getSTATE6PSDEFNAME() {
        return this.getParamStringValue(TAG_STATE6PSDEFNAME, "");
    }

    public final void setSTATE6PSDEFNAME(String strValue) {
        this.setParamValue(TAG_STATE6PSDEFNAME, strValue);
    }

    public final boolean isSTATE7PSDEFIDNull() {
        return this.isParamNull(TAG_STATE7PSDEFID);
    }

    public final String getSTATE7PSDEFID() {
        return this.getParamStringValue(TAG_STATE7PSDEFID, "");
    }

    public final void setSTATE7PSDEFID(String strValue) {
        this.setParamValue(TAG_STATE7PSDEFID, strValue);
    }

    public final boolean isSTATE7PSDEFNAMENull() {
        return this.isParamNull(TAG_STATE7PSDEFNAME);
    }

    public final String getSTATE7PSDEFNAME() {
        return this.getParamStringValue(TAG_STATE7PSDEFNAME, "");
    }

    public final void setSTATE7PSDEFNAME(String strValue) {
        this.setParamValue(TAG_STATE7PSDEFNAME, strValue);
    }

    public final boolean isSTATE8PSDEFIDNull() {
        return this.isParamNull(TAG_STATE8PSDEFID);
    }

    public final String getSTATE8PSDEFID() {
        return this.getParamStringValue(TAG_STATE8PSDEFID, "");
    }

    public final void setSTATE8PSDEFID(String strValue) {
        this.setParamValue(TAG_STATE8PSDEFID, strValue);
    }

    public final boolean isSTATE8PSDEFNAMENull() {
        return this.isParamNull(TAG_STATE8PSDEFNAME);
    }

    public final String getSTATE8PSDEFNAME() {
        return this.getParamStringValue(TAG_STATE8PSDEFNAME, "");
    }

    public final void setSTATE8PSDEFNAME(String strValue) {
        this.setParamValue(TAG_STATE8PSDEFNAME, strValue);
    }

    public final boolean isKEY4PSDEFIDNull() {
        return this.isParamNull(TAG_KEY4PSDEFID);
    }

    public final String getKEY4PSDEFID() {
        return this.getParamStringValue(TAG_KEY4PSDEFID, "");
    }

    public final void setKEY4PSDEFID(String strValue) {
        this.setParamValue(TAG_KEY4PSDEFID, strValue);
    }

    public final boolean isKEY4PSDEFNAMENull() {
        return this.isParamNull(TAG_KEY4PSDEFNAME);
    }

    public final String getKEY4PSDEFNAME() {
        return this.getParamStringValue(TAG_KEY4PSDEFNAME, "");
    }

    public final void setKEY4PSDEFNAME(String strValue) {
        this.setParamValue(TAG_KEY4PSDEFNAME, strValue);
    }

    public final boolean isUNISTATETYPENull() {
        return this.isParamNull(TAG_UNISTATETYPE);
    }

    public final String getUNISTATETYPE() {
        return this.getParamStringValue(TAG_UNISTATETYPE, "");
    }

    public final void setUNISTATETYPE(String strValue) {
        this.setParamValue(TAG_UNISTATETYPE, strValue);
    }

    public final boolean isDEDEFAULTFLAGNull() {
        return this.isParamNull(TAG_DEDEFAULTFLAG);
    }

    public final boolean getDEDEFAULTFLAG() {
        return this.getParamIntValue(TAG_DEDEFAULTFLAG, 0) == 1;
    }

    public final void setDEDEFAULTFLAG(boolean bValue) {
        this.setParamValue(TAG_DEDEFAULTFLAG, bValue ? 1 : 0);
    }
}

