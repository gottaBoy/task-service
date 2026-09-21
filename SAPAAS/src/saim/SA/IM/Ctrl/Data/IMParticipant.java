/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.IM.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class IMParticipant
extends BaseDataEntity {
    public static final String TAG_IMPARTICIPANTID = "IMPARTICIPANTID";
    public static final String TAG_IMPARTICIPANTNAME = "IMPARTICIPANTNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_IMMEETINGID = "IMMEETINGID";
    public static final String TAG_IMMEETINGNAME = "IMMEETINGNAME";
    public static final String TAG_IMUSERID = "IMUSERID";
    public static final String TAG_IMUSERNAME = "IMUSERNAME";
    public static final String TAG_ADMINFLAG = "ADMINFLAG";

    public boolean isIMPARTICIPANTIDNull() {
        return this.IsParamNull(TAG_IMPARTICIPANTID);
    }

    public String getIMPARTICIPANTID() {
        return this.GetParamStringValue(TAG_IMPARTICIPANTID, "");
    }

    public void setIMPARTICIPANTID(String strValue) {
        this.SetParamValue(TAG_IMPARTICIPANTID, strValue);
    }

    public boolean isIMPARTICIPANTNAMENull() {
        return this.IsParamNull(TAG_IMPARTICIPANTNAME);
    }

    public String getIMPARTICIPANTNAME() {
        return this.GetParamStringValue(TAG_IMPARTICIPANTNAME, "");
    }

    public void setIMPARTICIPANTNAME(String strValue) {
        this.SetParamValue(TAG_IMPARTICIPANTNAME, strValue);
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

    public boolean isIMUSERIDNull() {
        return this.IsParamNull(TAG_IMUSERID);
    }

    public String getIMUSERID() {
        return this.GetParamStringValue(TAG_IMUSERID, "");
    }

    public void setIMUSERID(String strValue) {
        this.SetParamValue(TAG_IMUSERID, strValue);
    }

    public boolean isIMUSERNAMENull() {
        return this.IsParamNull(TAG_IMUSERNAME);
    }

    public String getIMUSERNAME() {
        return this.GetParamStringValue(TAG_IMUSERNAME, "");
    }

    public void setIMUSERNAME(String strValue) {
        this.SetParamValue(TAG_IMUSERNAME, strValue);
    }

    public final boolean isADMINFLAGNull() {
        return this.IsParamNull(TAG_ADMINFLAG);
    }

    public final boolean getADMINFLAG() {
        return this.GetParamIntValue(TAG_ADMINFLAG, 0) == 1;
    }

    public final void setADMINFLAG(boolean bValue) {
        this.SetParamValue(TAG_ADMINFLAG, bValue ? 1 : 0);
    }
}

