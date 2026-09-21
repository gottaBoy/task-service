/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data.PP;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PPSearchForm
extends BaseDataEntity {
    public static final String PARAMTYPE = "PP_SEARCHFORM";
    public static final String TAG_PPSEARCHFORMID = "PPSEARCHFORMID";
    public static final String TAG_PPSEARCHFORMNAME = "PPSEARCHFORMNAME";
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
    public static final String TAG_SEARCHFORMID = "SEARCHFORMID";
    public static final String TAG_SEARCHFORMNAME = "SEARCHFORMNAME";
    public static final String TAG_SPCUSTOMSEARCH = "SPCUSTOMSEARCH";
    public static final String TAG_SPSAVELOAD = "SPSAVELOAD";

    public boolean isPPSEARCHFORMIDNull() {
        return this.IsParamNull(TAG_PPSEARCHFORMID);
    }

    public String getPPSEARCHFORMID() {
        return this.GetParamStringValue(TAG_PPSEARCHFORMID, "");
    }

    public void setPPSEARCHFORMID(String strValue) {
        this.SetParamValue(TAG_PPSEARCHFORMID, strValue);
    }

    public boolean isPPSEARCHFORMNAMENull() {
        return this.IsParamNull(TAG_PPSEARCHFORMNAME);
    }

    public String getPPSEARCHFORMNAME() {
        return this.GetParamStringValue(TAG_PPSEARCHFORMNAME, "");
    }

    public void setPPSEARCHFORMNAME(String strValue) {
        this.SetParamValue(TAG_PPSEARCHFORMNAME, strValue);
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

    public boolean isPAGETYPENull() {
        return this.IsParamNull(TAG_PAGETYPE);
    }

    public String getPAGETYPE() {
        return this.GetParamStringValue(TAG_PAGETYPE, "");
    }

    public void setPAGETYPE(String strValue) {
        this.SetParamValue(TAG_PAGETYPE, strValue);
    }

    public boolean isPAGEIDNull() {
        return this.IsParamNull(TAG_PAGEID);
    }

    public String getPAGEID() {
        return this.GetParamStringValue(TAG_PAGEID, "");
    }

    public void setPAGEID(String strValue) {
        this.SetParamValue(TAG_PAGEID, strValue);
    }

    public boolean isPAGENAMENull() {
        return this.IsParamNull(TAG_PAGENAME);
    }

    public String getPAGENAME() {
        return this.GetParamStringValue(TAG_PAGENAME, "");
    }

    public void setPAGENAME(String strValue) {
        this.SetParamValue(TAG_PAGENAME, strValue);
    }

    public boolean isPAGEPARAMTYPEIDNull() {
        return this.IsParamNull(TAG_PAGEPARAMTYPEID);
    }

    public String getPAGEPARAMTYPEID() {
        return this.GetParamStringValue(TAG_PAGEPARAMTYPEID, "");
    }

    public void setPAGEPARAMTYPEID(String strValue) {
        this.SetParamValue(TAG_PAGEPARAMTYPEID, strValue);
    }

    public boolean isPAGEPARAMTYPENAMENull() {
        return this.IsParamNull(TAG_PAGEPARAMTYPENAME);
    }

    public String getPAGEPARAMTYPENAME() {
        return this.GetParamStringValue(TAG_PAGEPARAMTYPENAME, "");
    }

    public void setPAGEPARAMTYPENAME(String strValue) {
        this.SetParamValue(TAG_PAGEPARAMTYPENAME, strValue);
    }

    public boolean isCTRLIDNull() {
        return this.IsParamNull(TAG_CTRLID);
    }

    public String getCTRLID() {
        return this.GetParamStringValue(TAG_CTRLID, "");
    }

    public void setCTRLID(String strValue) {
        this.SetParamValue(TAG_CTRLID, strValue);
    }

    public boolean isPPTYPEDESCNull() {
        return this.IsParamNull(TAG_PPTYPEDESC);
    }

    public String getPPTYPEDESC() {
        return this.GetParamStringValue(TAG_PPTYPEDESC, "");
    }

    public void setPPTYPEDESC(String strValue) {
        this.SetParamValue(TAG_PPTYPEDESC, strValue);
    }

    public boolean isSEARCHFORMIDNull() {
        return this.IsParamNull(TAG_SEARCHFORMID);
    }

    public String getSEARCHFORMID() {
        return this.GetParamStringValue(TAG_SEARCHFORMID, "");
    }

    public void setSEARCHFORMID(String strValue) {
        this.SetParamValue(TAG_SEARCHFORMID, strValue);
    }

    public boolean isSEARCHFORMNAMENull() {
        return this.IsParamNull(TAG_SEARCHFORMNAME);
    }

    public String getSEARCHFORMNAME() {
        return this.GetParamStringValue(TAG_SEARCHFORMNAME, "");
    }

    public void setSEARCHFORMNAME(String strValue) {
        this.SetParamValue(TAG_SEARCHFORMNAME, strValue);
    }

    public boolean isSPCUSTOMSEARCHNull() {
        return this.IsParamNull(TAG_SPCUSTOMSEARCH);
    }

    public boolean getSPCUSTOMSEARCH() {
        return this.GetParamIntValue(TAG_SPCUSTOMSEARCH, 0) == 1;
    }

    public void setSPCUSTOMSEARCH(boolean bValue) {
        this.SetParamValue(TAG_SPCUSTOMSEARCH, bValue ? 1 : 0);
    }

    public boolean isSPSAVELOADNull() {
        return this.IsParamNull(TAG_SPSAVELOAD);
    }

    public boolean getSPSAVELOAD() {
        return this.GetParamIntValue(TAG_SPSAVELOAD, 0) == 1;
    }

    public void setSPSAVELOAD(boolean bValue) {
        this.SetParamValue(TAG_SPSAVELOAD, bValue ? 1 : 0);
    }
}

