/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data.PP;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PPEVTabView
extends BaseDataEntity {
    public static final String PARAMTYPE = "PP_EVTABVIEW";
    public static final String TAG_PPEVTABVIEWID = "PPEVTABVIEWID";
    public static final String TAG_PPEVTABVIEWNAME = "PPEVTABVIEWNAME";
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
    public static final String TAG_DERGROUPID = "DERGROUPID";
    public static final String TAG_DERGROUPNAME = "DERGROUPNAME";
    public static final String TAG_FORMID = "FORMID";
    public static final String TAG_FORMNAME = "FORMNAME";
    public static final String TAG_FORMPAGEID = "FORMPAGEID";
    public static final String TAG_FORMPAGENAME = "FORMPAGENAME";
    public static final String TAG_FORMSTATE = "FORMSTATE";

    public String getPPEVTABVIEWID() {
        return this.GetParamStringValue(TAG_PPEVTABVIEWID, "");
    }

    public void setPPEVTABVIEWID(String strValue) {
        this.SetParamValue(TAG_PPEVTABVIEWID, strValue);
    }

    public String getPPEVTABVIEWNAME() {
        return this.GetParamStringValue(TAG_PPEVTABVIEWNAME, "");
    }

    public void setPPEVTABVIEWNAME(String strValue) {
        this.SetParamValue(TAG_PPEVTABVIEWNAME, strValue);
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

    public String getDERGROUPID() {
        return this.GetParamStringValue(TAG_DERGROUPID, "");
    }

    public void setDERGROUPID(String strValue) {
        this.SetParamValue(TAG_DERGROUPID, strValue);
    }

    public String getDERGROUPNAME() {
        return this.GetParamStringValue(TAG_DERGROUPNAME, "");
    }

    public void setDERGROUPNAME(String strValue) {
        this.SetParamValue(TAG_DERGROUPNAME, strValue);
    }

    public String getFORMID() {
        return this.GetParamStringValue(TAG_FORMID, "");
    }

    public void setFORMID(String strValue) {
        this.SetParamValue(TAG_FORMID, strValue);
    }

    public String getFORMNAME() {
        return this.GetParamStringValue(TAG_FORMNAME, "");
    }

    public void setFORMNAME(String strValue) {
        this.SetParamValue(TAG_FORMNAME, strValue);
    }

    public String getFORMPAGEID() {
        return this.GetParamStringValue(TAG_FORMPAGEID, "");
    }

    public void setFORMPAGEID(String strValue) {
        this.SetParamValue(TAG_FORMPAGEID, strValue);
    }

    public String getFORMPAGENAME() {
        return this.GetParamStringValue(TAG_FORMPAGENAME, "");
    }

    public void setFORMPAGENAME(String strValue) {
        this.SetParamValue(TAG_FORMPAGENAME, strValue);
    }

    public String getFORMSTATE() {
        return this.GetParamStringValue(TAG_FORMSTATE, "");
    }

    public void setFORMSTATE(String strValue) {
        this.SetParamValue(TAG_FORMSTATE, strValue);
    }
}

