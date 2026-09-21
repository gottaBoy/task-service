/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.BI.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class BIHRCMemberRole
extends BaseDataEntity {
    public static final String TAG_BIHRCMEMBERROLEID = "BIHRCMEMBERROLEID";
    public static final String TAG_BIHRCMEMBERROLENAME = "BIHRCMEMBERROLENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_BIHIERARCHYROLEID = "BIHIERARCHYROLEID";
    public static final String TAG_BIHIERARCHYROLENAME = "BIHIERARCHYROLENAME";
    public static final String TAG_ACCESSTYPE = "ACCESSTYPE";
    public static final String TAG_MEMBER = "MEMBER";

    public String getBIHRCMEMBERROLEID() {
        return this.GetParamStringValue(TAG_BIHRCMEMBERROLEID, "");
    }

    public void setBIHRCMEMBERROLEID(String strValue) {
        this.SetParamValue(TAG_BIHRCMEMBERROLEID, strValue);
    }

    public String getBIHRCMEMBERROLENAME() {
        return this.GetParamStringValue(TAG_BIHRCMEMBERROLENAME, "");
    }

    public void setBIHRCMEMBERROLENAME(String strValue) {
        this.SetParamValue(TAG_BIHRCMEMBERROLENAME, strValue);
    }

    public String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public Date getCREATEDATE() {
        return this.GetParamDateValue(TAG_CREATEDATE, null);
    }

    public void setCREATEDATE(Date strValue) {
        this.SetParamValue(TAG_CREATEDATE, strValue);
    }

    public String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public Date getUPDATEDATE() {
        return this.GetParamDateValue(TAG_UPDATEDATE, null);
    }

    public void setUPDATEDATE(Date strValue) {
        this.SetParamValue(TAG_UPDATEDATE, strValue);
    }

    public String getBIHIERARCHYROLEID() {
        return this.GetParamStringValue(TAG_BIHIERARCHYROLEID, "");
    }

    public void setBIHIERARCHYROLEID(String strValue) {
        this.SetParamValue(TAG_BIHIERARCHYROLEID, strValue);
    }

    public String getBIHIERARCHYROLENAME() {
        return this.GetParamStringValue(TAG_BIHIERARCHYROLENAME, "");
    }

    public void setBIHIERARCHYROLENAME(String strValue) {
        this.SetParamValue(TAG_BIHIERARCHYROLENAME, strValue);
    }

    public String getACCESSTYPE() {
        return this.GetParamStringValue(TAG_ACCESSTYPE, "");
    }

    public void setACCESSTYPE(String strValue) {
        this.SetParamValue(TAG_ACCESSTYPE, strValue);
    }

    public String getMEMBER() {
        return this.GetParamStringValue(TAG_MEMBER, "");
    }

    public void setMEMBER(String strValue) {
        this.SetParamValue(TAG_MEMBER, strValue);
    }
}

