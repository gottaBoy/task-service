/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.TM.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class TMResBT
extends BaseDataEntity {
    public static final String TAG_TMRESBTID = "TMRESBTID";
    public static final String TAG_TMRESBTNAME = "TMRESBTNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_ENABLEUC = "ENABLEUC";
    public static final String TAG_BKTHEME = "BKTHEME";

    public boolean isTMRESBTIDNull() {
        return this.IsParamNull(TAG_TMRESBTID);
    }

    public String getTMRESBTID() {
        return this.GetParamStringValue(TAG_TMRESBTID, "");
    }

    public void setTMRESBTID(String strValue) {
        this.SetParamValue(TAG_TMRESBTID, strValue);
    }

    public boolean isTMRESBTNAMENull() {
        return this.IsParamNull(TAG_TMRESBTNAME);
    }

    public String getTMRESBTNAME() {
        return this.GetParamStringValue(TAG_TMRESBTNAME, "");
    }

    public void setTMRESBTNAME(String strValue) {
        this.SetParamValue(TAG_TMRESBTNAME, strValue);
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

    public boolean isDESCRIPTIONNull() {
        return this.IsParamNull(TAG_DESCRIPTION);
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }

    public boolean isENABLEUCNull() {
        return this.IsParamNull(TAG_ENABLEUC);
    }

    public boolean getENABLEUC() {
        return this.GetParamIntValue(TAG_ENABLEUC, 0) == 1;
    }

    public void setENABLEUC(boolean bValue) {
        this.SetParamValue(TAG_ENABLEUC, bValue ? 1 : 0);
    }

    public boolean isBKTHEMENull() {
        return this.IsParamNull(TAG_BKTHEME);
    }

    public String getBKTHEME() {
        return this.GetParamStringValue(TAG_BKTHEME, "");
    }

    public void setBKTHEME(String strValue) {
        this.SetParamValue(TAG_BKTHEME, strValue);
    }
}

