/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class MBPanel
extends BaseDataEntity {
    public static final String TAG_MBPANELID = "MBPANELID";
    public static final String TAG_MBPANELNAME = "MBPANELNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MBPANELTEMPLID = "MBPANELTEMPLID";
    public static final String TAG_MBPANELTEMPLNAME = "MBPANELTEMPLNAME";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_VERSION = "VERSION";
    public static final String TAG_PANELOBJECT = "PANELOBJECT";

    public boolean isMBPANELIDNull() {
        return this.IsParamNull(TAG_MBPANELID);
    }

    public String getMBPANELID() {
        return this.GetParamStringValue(TAG_MBPANELID, "");
    }

    public void setMBPANELID(String strValue) {
        this.SetParamValue(TAG_MBPANELID, strValue);
    }

    public boolean isMBPANELNAMENull() {
        return this.IsParamNull(TAG_MBPANELNAME);
    }

    public String getMBPANELNAME() {
        return this.GetParamStringValue(TAG_MBPANELNAME, "");
    }

    public void setMBPANELNAME(String strValue) {
        this.SetParamValue(TAG_MBPANELNAME, strValue);
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

    public boolean isMBPANELTEMPLIDNull() {
        return this.IsParamNull(TAG_MBPANELTEMPLID);
    }

    public String getMBPANELTEMPLID() {
        return this.GetParamStringValue(TAG_MBPANELTEMPLID, "");
    }

    public void setMBPANELTEMPLID(String strValue) {
        this.SetParamValue(TAG_MBPANELTEMPLID, strValue);
    }

    public boolean isMBPANELTEMPLNAMENull() {
        return this.IsParamNull(TAG_MBPANELTEMPLNAME);
    }

    public String getMBPANELTEMPLNAME() {
        return this.GetParamStringValue(TAG_MBPANELTEMPLNAME, "");
    }

    public void setMBPANELTEMPLNAME(String strValue) {
        this.SetParamValue(TAG_MBPANELTEMPLNAME, strValue);
    }

    public boolean isDEIDNull() {
        return this.IsParamNull(TAG_DEID);
    }

    public String getDEID() {
        return this.GetParamStringValue(TAG_DEID, "");
    }

    public void setDEID(String strValue) {
        this.SetParamValue(TAG_DEID, strValue);
    }

    public boolean isDENAMENull() {
        return this.IsParamNull(TAG_DENAME);
    }

    public String getDENAME() {
        return this.GetParamStringValue(TAG_DENAME, "");
    }

    public void setDENAME(String strValue) {
        this.SetParamValue(TAG_DENAME, strValue);
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

    public boolean isPANELOBJECTNull() {
        return this.IsParamNull(TAG_PANELOBJECT);
    }

    public String getPANELOBJECT() {
        return this.GetParamStringValue(TAG_PANELOBJECT, "");
    }

    public void setPANELOBJECT(String strValue) {
        this.SetParamValue(TAG_PANELOBJECT, strValue);
    }
}

