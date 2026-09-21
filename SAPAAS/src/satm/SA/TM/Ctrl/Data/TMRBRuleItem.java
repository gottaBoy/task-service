/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.TM.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class TMRBRuleItem
extends BaseDataEntity {
    public static final String TAG_TMRBRULEITEMID = "TMRBRULEITEMID";
    public static final String TAG_TMRBRULEITEMNAME = "TMRBRULEITEMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_TMRBRULEID = "TMRBRULEID";
    public static final String TAG_TMRBRULENAME = "TMRBRULENAME";
    public static final String TAG_BEGINTIME = "BEGINTIME";
    public static final String TAG_ENDTIME = "ENDTIME";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_TMRESBOOKINGID = "TMRESBOOKINGID";
    public static final String TAG_TMRESBOOKINGNAME = "TMRESBOOKINGNAME";
    public static final String TAG_RBSTATE = "RBSTATE";

    public boolean isTMRBRULEITEMIDNull() {
        return this.IsParamNull(TAG_TMRBRULEITEMID);
    }

    public String getTMRBRULEITEMID() {
        return this.GetParamStringValue(TAG_TMRBRULEITEMID, "");
    }

    public void setTMRBRULEITEMID(String strValue) {
        this.SetParamValue(TAG_TMRBRULEITEMID, strValue);
    }

    public boolean isTMRBRULEITEMNAMENull() {
        return this.IsParamNull(TAG_TMRBRULEITEMNAME);
    }

    public String getTMRBRULEITEMNAME() {
        return this.GetParamStringValue(TAG_TMRBRULEITEMNAME, "");
    }

    public void setTMRBRULEITEMNAME(String strValue) {
        this.SetParamValue(TAG_TMRBRULEITEMNAME, strValue);
    }

    public boolean isCREATEMANNull() {
        return this.IsParamNull(TAG_CREATEMAN);
    }

    public String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public boolean isCREATEDATENull() {
        return this.IsParamNull(TAG_CREATEDATE);
    }

    public Date getCREATEDATE() {
        return this.GetParamDateValue(TAG_CREATEDATE, null);
    }

    public void setCREATEDATE(Date strValue) {
        this.SetParamValue(TAG_CREATEDATE, strValue);
    }

    public boolean isUPDATEMANNull() {
        return this.IsParamNull(TAG_UPDATEMAN);
    }

    public String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public boolean isUPDATEDATENull() {
        return this.IsParamNull(TAG_UPDATEDATE);
    }

    public Date getUPDATEDATE() {
        return this.GetParamDateValue(TAG_UPDATEDATE, null);
    }

    public void setUPDATEDATE(Date strValue) {
        this.SetParamValue(TAG_UPDATEDATE, strValue);
    }

    public boolean isTMRBRULEIDNull() {
        return this.IsParamNull(TAG_TMRBRULEID);
    }

    public String getTMRBRULEID() {
        return this.GetParamStringValue(TAG_TMRBRULEID, "");
    }

    public void setTMRBRULEID(String strValue) {
        this.SetParamValue(TAG_TMRBRULEID, strValue);
    }

    public boolean isTMRBRULENAMENull() {
        return this.IsParamNull(TAG_TMRBRULENAME);
    }

    public String getTMRBRULENAME() {
        return this.GetParamStringValue(TAG_TMRBRULENAME, "");
    }

    public void setTMRBRULENAME(String strValue) {
        this.SetParamValue(TAG_TMRBRULENAME, strValue);
    }

    public boolean isBEGINTIMENull() {
        return this.IsParamNull(TAG_BEGINTIME);
    }

    public Date getBEGINTIME() {
        return this.GetParamDateValue(TAG_BEGINTIME, null);
    }

    public void setBEGINTIME(Date strValue) {
        this.SetParamValue(TAG_BEGINTIME, strValue);
    }

    public boolean isENDTIMENull() {
        return this.IsParamNull(TAG_ENDTIME);
    }

    public Date getENDTIME() {
        return this.GetParamDateValue(TAG_ENDTIME, null);
    }

    public void setENDTIME(Date strValue) {
        this.SetParamValue(TAG_ENDTIME, strValue);
    }

    public boolean isDESCRIPTIONNull() {
        return this.IsParamNull(TAG_DESCRIPTION);
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }

    public boolean isUSERTAGNull() {
        return this.IsParamNull(TAG_USERTAG);
    }

    public String getUSERTAG() {
        return this.GetParamStringValue(TAG_USERTAG, "");
    }

    public void setUSERTAG(String strValue) {
        this.SetParamValue(TAG_USERTAG, strValue);
    }

    public boolean isUSERTAG2Null() {
        return this.IsParamNull(TAG_USERTAG2);
    }

    public String getUSERTAG2() {
        return this.GetParamStringValue(TAG_USERTAG2, "");
    }

    public void setUSERTAG2(String strValue) {
        this.SetParamValue(TAG_USERTAG2, strValue);
    }

    public boolean isTMRESBOOKINGIDNull() {
        return this.IsParamNull(TAG_TMRESBOOKINGID);
    }

    public String getTMRESBOOKINGID() {
        return this.GetParamStringValue(TAG_TMRESBOOKINGID, "");
    }

    public void setTMRESBOOKINGID(String strValue) {
        this.SetParamValue(TAG_TMRESBOOKINGID, strValue);
    }

    public boolean isTMRESBOOKINGNAMENull() {
        return this.IsParamNull(TAG_TMRESBOOKINGNAME);
    }

    public String getTMRESBOOKINGNAME() {
        return this.GetParamStringValue(TAG_TMRESBOOKINGNAME, "");
    }

    public void setTMRESBOOKINGNAME(String strValue) {
        this.SetParamValue(TAG_TMRESBOOKINGNAME, strValue);
    }

    public boolean isRBSTATENull() {
        return this.IsParamNull(TAG_RBSTATE);
    }

    public String getRBSTATE() {
        return this.GetParamStringValue(TAG_RBSTATE, "");
    }

    public void setRBSTATE(String strValue) {
        this.SetParamValue(TAG_RBSTATE, strValue);
    }
}

