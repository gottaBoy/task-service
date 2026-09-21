/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.IM.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class IMMeeting
extends BaseDataEntity {
    public static final int MEETINGTYPE_STANDARD = 1;
    public static final int MEETINGTYPE_DISGROUP = 2;
    public static final String TAG_IMMEETINGID = "IMMEETINGID";
    public static final String TAG_IMMEETINGNAME = "IMMEETINGNAME";
    public static final String TAG_ENABLE = "ENABLE";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_BEGINTIME = "BEGINTIME";
    public static final String TAG_ENDTIME = "ENDTIME";
    public static final String TAG_IMMTSERVERID = "IMMTSERVERID";
    public static final String TAG_IMMTSERVERNAME = "IMMTSERVERNAME";
    public static final String TAG_CLOSEFLAG = "CLOSEFLAG";
    public static final String TAG_IMUSERIDS = "IMUSERIDS";
    public static final String TAG_MEETINGTYPE = "MEETINGTYPE";
    public static final String TAG_LASTMESSAGE = "LASTMESSAGE";
    public static final String TAG_LASTMESSAGETIME = "LASTMESSAGETIME";

    public boolean isIMMEETINGIDNull() {
        return this.IsParamNull(TAG_IMMEETINGID);
    }

    public String getIMMEETINGID() {
        return this.GetParamStringValue(TAG_IMMEETINGID, "");
    }

    public void setIMMEETINGID(String strValue) {
        this.SetParamValue(TAG_IMMEETINGID, strValue);
    }

    public boolean isIMMEETINGNAMENull() {
        return this.IsParamNull(TAG_IMMEETINGNAME);
    }

    public String getIMMEETINGNAME() {
        return this.GetParamStringValue(TAG_IMMEETINGNAME, "");
    }

    public void setIMMEETINGNAME(String strValue) {
        this.SetParamValue(TAG_IMMEETINGNAME, strValue);
    }

    public boolean isENABLENull() {
        return this.IsParamNull(TAG_ENABLE);
    }

    public boolean getENABLE() {
        return this.GetParamIntValue(TAG_ENABLE, 0) == 1;
    }

    public void setENABLE(boolean bValue) {
        this.SetParamValue(TAG_ENABLE, bValue ? 1 : 0);
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

    public void setCREATEDATE(Date dtValue) {
        this.SetParamValue(TAG_CREATEDATE, dtValue);
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

    public void setUPDATEDATE(Date dtValue) {
        this.SetParamValue(TAG_UPDATEDATE, dtValue);
    }

    public boolean isBEGINTIMENull() {
        return this.IsParamNull(TAG_BEGINTIME);
    }

    public Date getBEGINTIME() {
        return this.GetParamDateValue(TAG_BEGINTIME, null);
    }

    public void setBEGINTIME(Date dtValue) {
        this.SetParamValue(TAG_BEGINTIME, dtValue);
    }

    public boolean isENDTIMENull() {
        return this.IsParamNull(TAG_ENDTIME);
    }

    public Date getENDTIME() {
        return this.GetParamDateValue(TAG_ENDTIME, null);
    }

    public void setENDTIME(Date dtValue) {
        this.SetParamValue(TAG_ENDTIME, dtValue);
    }

    public boolean isIMMTSERVERIDNull() {
        return this.IsParamNull(TAG_IMMTSERVERID);
    }

    public String getIMMTSERVERID() {
        return this.GetParamStringValue(TAG_IMMTSERVERID, "");
    }

    public void setIMMTSERVERID(String strValue) {
        this.SetParamValue(TAG_IMMTSERVERID, strValue);
    }

    public boolean isIMMTSERVERNAMENull() {
        return this.IsParamNull(TAG_IMMTSERVERNAME);
    }

    public String getIMMTSERVERNAME() {
        return this.GetParamStringValue(TAG_IMMTSERVERNAME, "");
    }

    public void setIMMTSERVERNAME(String strValue) {
        this.SetParamValue(TAG_IMMTSERVERNAME, strValue);
    }

    public boolean isCLOSEFLAGNull() {
        return this.IsParamNull(TAG_CLOSEFLAG);
    }

    public boolean getCLOSEFLAG() {
        return this.GetParamIntValue(TAG_CLOSEFLAG, 0) == 1;
    }

    public void setCLOSEFLAG(boolean bValue) {
        this.SetParamValue(TAG_CLOSEFLAG, bValue ? 1 : 0);
    }

    public boolean isIMUSERIDSNull() {
        return this.IsParamNull(TAG_IMUSERIDS);
    }

    public String getIMUSERIDS() {
        return this.GetParamStringValue(TAG_IMUSERIDS, "");
    }

    public void setIMUSERIDS(String strValue) {
        this.SetParamValue(TAG_IMUSERIDS, strValue);
    }

    public final boolean isMEETINGTYPENull() {
        return this.IsParamNull(TAG_MEETINGTYPE);
    }

    public final int getMEETINGTYPE() {
        return this.GetParamIntValue(TAG_MEETINGTYPE, 0);
    }

    public final void setMEETINGTYPE(int nValue) {
        this.SetParamValue(TAG_MEETINGTYPE, nValue);
    }

    public final boolean isLASTMESSAGENull() {
        return this.IsParamNull(TAG_LASTMESSAGE);
    }

    public final String getLASTMESSAGE() {
        return this.GetParamStringValue(TAG_LASTMESSAGE, "");
    }

    public final void setLASTMESSAGE(String strValue) {
        this.SetParamValue(TAG_LASTMESSAGE, strValue);
    }

    public final boolean isLASTMESSAGETIMENull() {
        return this.IsParamNull(TAG_LASTMESSAGETIME);
    }

    public final Date getLASTMESSAGETIME() {
        return this.GetParamDateValue(TAG_LASTMESSAGETIME, null);
    }

    public final void setLASTMESSAGETIME(Date dtValue) {
        this.SetParamValue(TAG_LASTMESSAGETIME, dtValue);
    }
}

