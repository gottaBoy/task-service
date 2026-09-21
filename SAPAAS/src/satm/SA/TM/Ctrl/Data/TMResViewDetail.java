/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.TM.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class TMResViewDetail
extends BaseDataEntity {
    public static final String TAG_TMRESVIEWDETAILID = "TMRESVIEWDETAILID";
    public static final String TAG_TMRESVIEWDETAILNAME = "TMRESVIEWDETAILNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_TMRESVIEWID = "TMRESVIEWID";
    public static final String TAG_TMRESVIEWNAME = "TMRESVIEWNAME";
    public static final String TAG_TMRESBASEID = "TMRESBASEID";
    public static final String TAG_TMRESBASENAME = "TMRESBASENAME";

    public boolean isTMRESVIEWDETAILIDNull() {
        return this.IsParamNull(TAG_TMRESVIEWDETAILID);
    }

    public String getTMRESVIEWDETAILID() {
        return this.GetParamStringValue(TAG_TMRESVIEWDETAILID, "");
    }

    public void setTMRESVIEWDETAILID(String strValue) {
        this.SetParamValue(TAG_TMRESVIEWDETAILID, strValue);
    }

    public boolean isTMRESVIEWDETAILNAMENull() {
        return this.IsParamNull(TAG_TMRESVIEWDETAILNAME);
    }

    public String getTMRESVIEWDETAILNAME() {
        return this.GetParamStringValue(TAG_TMRESVIEWDETAILNAME, "");
    }

    public void setTMRESVIEWDETAILNAME(String strValue) {
        this.SetParamValue(TAG_TMRESVIEWDETAILNAME, strValue);
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

    public boolean isTMRESBASEIDNull() {
        return this.IsParamNull(TAG_TMRESBASEID);
    }

    public String getTMRESBASEID() {
        return this.GetParamStringValue(TAG_TMRESBASEID, "");
    }

    public void setTMRESBASEID(String strValue) {
        this.SetParamValue(TAG_TMRESBASEID, strValue);
    }

    public boolean isTMRESBASENAMENull() {
        return this.IsParamNull(TAG_TMRESBASENAME);
    }

    public String getTMRESBASENAME() {
        return this.GetParamStringValue(TAG_TMRESBASENAME, "");
    }

    public void setTMRESBASENAME(String strValue) {
        this.SetParamValue(TAG_TMRESBASENAME, strValue);
    }
}

