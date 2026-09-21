/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class DEMSMA
extends BaseDataEntity {
    public static final String TAG_DEMSMAID = "DEMSMAID";
    public static final String TAG_DEMSMANAME = "DEMSMANAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DEMAINSTATEID = "DEMAINSTATEID";
    public static final String TAG_DEMAINSTATENAME = "DEMAINSTATENAME";
    public static final String TAG_DEMAINACTIONID = "DEMAINACTIONID";
    public static final String TAG_DEMAINACTIONNAME = "DEMAINACTIONNAME";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";

    public boolean isDEMSMAIDNull() {
        return this.IsParamNull(TAG_DEMSMAID);
    }

    public String getDEMSMAID() {
        return this.GetParamStringValue(TAG_DEMSMAID, "");
    }

    public void setDEMSMAID(String strValue) {
        this.SetParamValue(TAG_DEMSMAID, strValue);
    }

    public boolean isDEMSMANAMENull() {
        return this.IsParamNull(TAG_DEMSMANAME);
    }

    public String getDEMSMANAME() {
        return this.GetParamStringValue(TAG_DEMSMANAME, "");
    }

    public void setDEMSMANAME(String strValue) {
        this.SetParamValue(TAG_DEMSMANAME, strValue);
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

    public boolean isDEMAINSTATEIDNull() {
        return this.IsParamNull(TAG_DEMAINSTATEID);
    }

    public String getDEMAINSTATEID() {
        return this.GetParamStringValue(TAG_DEMAINSTATEID, "");
    }

    public void setDEMAINSTATEID(String strValue) {
        this.SetParamValue(TAG_DEMAINSTATEID, strValue);
    }

    public boolean isDEMAINSTATENAMENull() {
        return this.IsParamNull(TAG_DEMAINSTATENAME);
    }

    public String getDEMAINSTATENAME() {
        return this.GetParamStringValue(TAG_DEMAINSTATENAME, "");
    }

    public void setDEMAINSTATENAME(String strValue) {
        this.SetParamValue(TAG_DEMAINSTATENAME, strValue);
    }

    public boolean isDEMAINACTIONIDNull() {
        return this.IsParamNull(TAG_DEMAINACTIONID);
    }

    public String getDEMAINACTIONID() {
        return this.GetParamStringValue(TAG_DEMAINACTIONID, "");
    }

    public void setDEMAINACTIONID(String strValue) {
        this.SetParamValue(TAG_DEMAINACTIONID, strValue);
    }

    public boolean isDEMAINACTIONNAMENull() {
        return this.IsParamNull(TAG_DEMAINACTIONNAME);
    }

    public String getDEMAINACTIONNAME() {
        return this.GetParamStringValue(TAG_DEMAINACTIONNAME, "");
    }

    public void setDEMAINACTIONNAME(String strValue) {
        this.SetParamValue(TAG_DEMAINACTIONNAME, strValue);
    }

    public boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
    }
}

