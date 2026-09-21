/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data.PP;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PPETMForm
extends BaseDataEntity {
    public static final String PARAMTYPE = "PP_ETMFORM";
    public static final String TAG_PPETMFORMID = "PPETMFORMID";
    public static final String TAG_PPETMFORMNAME = "PPETMFORMNAME";
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
    public static final String TAG_EDITPAGEID = "EDITPAGEID";
    public static final String TAG_EDITPAGENAME = "EDITPAGENAME";
    public static final String TAG_DEFAULTCNT = "DEFAULTCNT";

    public boolean isPPETMFORMIDNull() {
        return this.IsParamNull(TAG_PPETMFORMID);
    }

    public String getPPETMFORMID() {
        return this.GetParamStringValue(TAG_PPETMFORMID, "");
    }

    public void setPPETMFORMID(String strValue) {
        this.SetParamValue(TAG_PPETMFORMID, strValue);
    }

    public boolean isPPETMFORMNAMENull() {
        return this.IsParamNull(TAG_PPETMFORMNAME);
    }

    public String getPPETMFORMNAME() {
        return this.GetParamStringValue(TAG_PPETMFORMNAME, "");
    }

    public void setPPETMFORMNAME(String strValue) {
        this.SetParamValue(TAG_PPETMFORMNAME, strValue);
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

    public boolean isEDITPAGEIDNull() {
        return this.IsParamNull(TAG_EDITPAGEID);
    }

    public String getEDITPAGEID() {
        return this.GetParamStringValue(TAG_EDITPAGEID, "");
    }

    public void setEDITPAGEID(String strValue) {
        this.SetParamValue(TAG_EDITPAGEID, strValue);
    }

    public boolean isEDITPAGENAMENull() {
        return this.IsParamNull(TAG_EDITPAGENAME);
    }

    public String getEDITPAGENAME() {
        return this.GetParamStringValue(TAG_EDITPAGENAME, "");
    }

    public void setEDITPAGENAME(String strValue) {
        this.SetParamValue(TAG_EDITPAGENAME, strValue);
    }

    public boolean isDEFAULTCNTNull() {
        return this.IsParamNull(TAG_DEFAULTCNT);
    }

    public int getDEFAULTCNT() {
        return this.GetParamIntValue(TAG_DEFAULTCNT, 0);
    }

    public void setDEFAULTCNT(int strValue) {
        this.SetParamValue(TAG_DEFAULTCNT, strValue);
    }
}

