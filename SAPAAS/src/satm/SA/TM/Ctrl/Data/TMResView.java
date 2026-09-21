/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.TM.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class TMResView
extends BaseDataEntity {
    public static final String TAG_TMRESVIEWID = "TMRESVIEWID";
    public static final String TAG_TMRESVIEWNAME = "TMRESVIEWNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_TMUSERID = "TMUSERID";
    public static final String TAG_TMUSERNAME = "TMUSERNAME";
    public static final String TAG_VERSION = "VERSION";

    public boolean isTMRESVIEWIDNull() {
        return this.IsParamNull(TAG_TMRESVIEWID);
    }

    public String getTMRESVIEWID() {
        return this.GetParamStringValue(TAG_TMRESVIEWID, "");
    }

    public void setTMRESVIEWID(String strValue) {
        this.SetParamValue(TAG_TMRESVIEWID, strValue);
    }

    public boolean isTMRESVIEWNAMENull() {
        return this.IsParamNull(TAG_TMRESVIEWNAME);
    }

    public String getTMRESVIEWNAME() {
        return this.GetParamStringValue(TAG_TMRESVIEWNAME, "");
    }

    public void setTMRESVIEWNAME(String strValue) {
        this.SetParamValue(TAG_TMRESVIEWNAME, strValue);
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

    public boolean isTMUSERIDNull() {
        return this.IsParamNull(TAG_TMUSERID);
    }

    public String getTMUSERID() {
        return this.GetParamStringValue(TAG_TMUSERID, "");
    }

    public void setTMUSERID(String strValue) {
        this.SetParamValue(TAG_TMUSERID, strValue);
    }

    public boolean isTMUSERNAMENull() {
        return this.IsParamNull(TAG_TMUSERNAME);
    }

    public String getTMUSERNAME() {
        return this.GetParamStringValue(TAG_TMUSERNAME, "");
    }

    public void setTMUSERNAME(String strValue) {
        this.SetParamValue(TAG_TMUSERNAME, strValue);
    }

    public boolean isVERSIONNull() {
        return this.IsParamNull(TAG_VERSION);
    }

    public int getVERSION() {
        return this.GetParamIntValue(TAG_VERSION, 0);
    }

    public void setVERSION(int strValue) {
        this.SetParamValue(TAG_VERSION, strValue);
    }
}

