/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data.PP;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PPEditForm
extends BaseDataEntity {
    public static final String PARAMTYPE = "PP_FORM";
    public static final String TAG_PPEDITFORMID = "PPEDITFORMID";
    public static final String TAG_PPEDITFORMNAME = "PPEDITFORMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_PAGETYPE = "PAGETYPE";
    public static final String TAG_PAGEID = "PAGEID";
    public static final String TAG_PAGENAME = "PAGENAME";
    public static final String TAG_PAGEPARAMTYPEID = "PAGEPARAMTYPEID";
    public static final String TAG_PAGEPARAMTYPENAME = "PAGEPARAMTYPENAME";
    public static final String TAG_CTRLID = "CTRLID";
    public static final String TAG_PPTYPEDESC = "PPTYPEDESC";
    public static final String TAG_ITEMPRIVILEGE = "ITEMPRIVILEGE";
    public static final String TAG_FORMID = "FORMID";
    public static final String TAG_FORMNAME = "FORMNAME";

    public String getPPEDITFORMID() {
        return this.GetParamStringValue(TAG_PPEDITFORMID, "");
    }

    public void setPPEDITFORMID(String strValue) {
        this.SetParamValue(TAG_PPEDITFORMID, strValue);
    }

    public String getPPEDITFORMNAME() {
        return this.GetParamStringValue(TAG_PPEDITFORMNAME, "");
    }

    public void setPPEDITFORMNAME(String strValue) {
        this.SetParamValue(TAG_PPEDITFORMNAME, strValue);
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

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }

    public String getPAGETYPE() {
        return this.GetParamStringValue(TAG_PAGETYPE, "");
    }

    public void setPAGETYPE(String strValue) {
        this.SetParamValue(TAG_PAGETYPE, strValue);
    }

    public String getPAGEID() {
        return this.GetParamStringValue(TAG_PAGEID, "");
    }

    public void setPAGEID(String strValue) {
        this.SetParamValue(TAG_PAGEID, strValue);
    }

    public String getPAGENAME() {
        return this.GetParamStringValue(TAG_PAGENAME, "");
    }

    public void setPAGENAME(String strValue) {
        this.SetParamValue(TAG_PAGENAME, strValue);
    }

    public String getPAGEPARAMTYPEID() {
        return this.GetParamStringValue(TAG_PAGEPARAMTYPEID, "");
    }

    public void setPAGEPARAMTYPEID(String strValue) {
        this.SetParamValue(TAG_PAGEPARAMTYPEID, strValue);
    }

    public String getPAGEPARAMTYPENAME() {
        return this.GetParamStringValue(TAG_PAGEPARAMTYPENAME, "");
    }

    public void setPAGEPARAMTYPENAME(String strValue) {
        this.SetParamValue(TAG_PAGEPARAMTYPENAME, strValue);
    }

    public String getCTRLID() {
        return this.GetParamStringValue(TAG_CTRLID, "");
    }

    public void setCTRLID(String strValue) {
        this.SetParamValue(TAG_CTRLID, strValue);
    }

    public String getPPTYPEDESC() {
        return this.GetParamStringValue(TAG_PPTYPEDESC, "");
    }

    public void setPPTYPEDESC(String strValue) {
        this.SetParamValue(TAG_PPTYPEDESC, strValue);
    }

    public boolean isITEMPRIVILEGENull() {
        return this.IsParamNull(TAG_ITEMPRIVILEGE);
    }

    public boolean getITEMPRIVILEGE() {
        return this.GetParamIntValue(TAG_ITEMPRIVILEGE, 0) == 1;
    }

    public void setITEMPRIVILEGE(boolean bValue) {
        this.SetParamValue(TAG_ITEMPRIVILEGE, bValue ? 1 : 0);
    }

    public boolean isFORMIDNull() {
        return this.IsParamNull(TAG_FORMID);
    }

    public String getFORMID() {
        return this.GetParamStringValue(TAG_FORMID, "");
    }

    public void setFORMID(String strValue) {
        this.SetParamValue(TAG_FORMID, strValue);
    }

    public boolean isFORMNAMENull() {
        return this.IsParamNull(TAG_FORMNAME);
    }

    public String getFORMNAME() {
        return this.GetParamStringValue(TAG_FORMNAME, "");
    }

    public void setFORMNAME(String strValue) {
        this.SetParamValue(TAG_FORMNAME, strValue);
    }
}

