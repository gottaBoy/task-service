/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class CaretTemplate
extends BaseDataEntity {
    public static final String TAG_CARETTEMPLATEID = "CARETTEMPLATEID";
    public static final String TAG_CARETTEMPLATENAME = "CARETTEMPLATENAME";
    public static final String TAG_ENABLE = "ENABLE";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_KEYWORDS = "KEYWORDS";
    public static final String TAG_TEMPLATETYPE = "TEMPLATETYPE";
    public static final String TAG_CARETCONDITION = "CARETCONDITION";
    public static final String TAG_CARETWORD = "CARETWORD";
    public static final String TAG_IMPORTANTTYPE = "IMPORTANTTYPE";
    public static final String TAG_ISPRIVATE = "ISPRIVATE";
    public static final String TAG_CARETTEMPLGROUPNAME = "CARETTEMPLGROUPNAME";
    public static final String TAG_CARETTEMPLGROUPID = "CARETTEMPLGROUPID";
    public static final String TAG_CARETDESC = "CARETDESC";
    public static final String TAG_OWNERID = "OWNERID";

    public String getCARETTEMPLATEID() {
        return this.GetParamStringValue(TAG_CARETTEMPLATEID, "");
    }

    public void setCARETTEMPLATEID(String strValue) {
        this.SetParamValue(TAG_CARETTEMPLATEID, strValue);
    }

    public String getCARETTEMPLATENAME() {
        return this.GetParamStringValue(TAG_CARETTEMPLATENAME, "");
    }

    public void setCARETTEMPLATENAME(String strValue) {
        this.SetParamValue(TAG_CARETTEMPLATENAME, strValue);
    }

    public boolean getENABLE() {
        return this.GetParamIntValue(TAG_ENABLE, 0) == 1;
    }

    public void setENABLE(boolean bValue) {
        this.SetParamValue(TAG_ENABLE, bValue ? 1 : 0);
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

    public String getKEYWORDS() {
        return this.GetParamStringValue(TAG_KEYWORDS, "");
    }

    public void setKEYWORDS(String strValue) {
        this.SetParamValue(TAG_KEYWORDS, strValue);
    }

    public String getTEMPLATETYPE() {
        return this.GetParamStringValue(TAG_TEMPLATETYPE, "");
    }

    public void setTEMPLATETYPE(String strValue) {
        this.SetParamValue(TAG_TEMPLATETYPE, strValue);
    }

    public String getCARETCONDITION() {
        return this.GetParamStringValue(TAG_CARETCONDITION, "");
    }

    public void setCARETCONDITION(String strValue) {
        this.SetParamValue(TAG_CARETCONDITION, strValue);
    }

    public String getCARETWORD() {
        return this.GetParamStringValue(TAG_CARETWORD, "");
    }

    public void setCARETWORD(String strValue) {
        this.SetParamValue(TAG_CARETWORD, strValue);
    }

    public String getIMPORTANTTYPE() {
        return this.GetParamStringValue(TAG_IMPORTANTTYPE, "");
    }

    public void setIMPORTANTTYPE(String strValue) {
        this.SetParamValue(TAG_IMPORTANTTYPE, strValue);
    }

    public boolean getISPRIVATE() {
        return this.GetParamIntValue(TAG_ISPRIVATE, 0) == 1;
    }

    public void setISPRIVATE(boolean bValue) {
        this.SetParamValue(TAG_ISPRIVATE, bValue ? 1 : 0);
    }

    public String getCARETTEMPLGROUPNAME() {
        return this.GetParamStringValue(TAG_CARETTEMPLGROUPNAME, "");
    }

    public void setCARETTEMPLGROUPNAME(String strValue) {
        this.SetParamValue(TAG_CARETTEMPLGROUPNAME, strValue);
    }

    public String getCARETTEMPLGROUPID() {
        return this.GetParamStringValue(TAG_CARETTEMPLGROUPID, "");
    }

    public void setCARETTEMPLGROUPID(String strValue) {
        this.SetParamValue(TAG_CARETTEMPLGROUPID, strValue);
    }

    public boolean isCARETDESCNull() {
        return this.IsParamNull(TAG_CARETDESC);
    }

    public String getCARETDESC() {
        return this.GetParamStringValue(TAG_CARETDESC, "");
    }

    public void setCARETDESC(String strValue) {
        this.SetParamValue(TAG_CARETDESC, strValue);
    }

    public boolean isOWNERIDNull() {
        return this.IsParamNull(TAG_OWNERID);
    }

    public String getOWNERID() {
        return this.GetParamStringValue(TAG_OWNERID, "");
    }

    public void setOWNERID(String strValue) {
        this.SetParamValue(TAG_OWNERID, strValue);
    }
}

