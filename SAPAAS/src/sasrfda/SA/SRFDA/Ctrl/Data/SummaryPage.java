/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;

public class SummaryPage
extends BaseDataEntity {
    public static final String TAG_SUMMARYPAGEID = "SUMMARYPAGEID";
    public static final String TAG_SUMMARYPAGENAME = "SUMMARYPAGENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_SPTYPE = "SPTYPE";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_FORMID = "FORMID";
    public static final String TAG_FORMNAME = "FORMNAME";
    public static final String TAG_PAGEID = "PAGEID";
    public static final String TAG_PAGENAME = "PAGENAME";
    public static final String TAG_DERTYPEID = "DERTYPEID";
    public static final String TAG_DERTYPENAME = "DERTYPENAME";
    public static final String TAG_SMALLICON = "SMALLICON";
    public static final String TAG_DERSHOWORDER = "DERSHOWORDER";
    public static final String TAG_SUMSHOWORDER = "SUMSHOWORDER";
    public static final String TAG_APPENDPARAM = "APPENDPARAM";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_NAMELANRESID = "NAMELANRESID";
    public static final String TAG_NAMELANRESNAME = "NAMELANRESNAME";
    public static final String TAG_SPTYPE_FORM = "FORM";
    public static final String TAG_SPTYPE_DEGRIDVIEW = "DEGRIDVIEW";
    public static final String TAG_SPTYPE_PAGELINK = "PAGELINK";
    public static final String TAG_SPTYPE_JSCODE = "JSCODE";
    public static final String TAG_SPTYPE_PAGE = "PAGE";
    public static final String TAG_SUMMARYPAGE_SUM = "SUM";
    public static final String TAG_SUMMARYPAGE_DER = "DER";

    public String getSUMMARYPAGEID() {
        return this.GetParamStringValue(TAG_SUMMARYPAGEID, "").trim();
    }

    public String getSUMMARYPAGENAME() {
        return this.GetParamStringValue(TAG_SUMMARYPAGENAME, "");
    }

    public String getDEID() {
        return this.GetParamStringValue(TAG_DEID, "");
    }

    public String getSPTYPE() {
        return this.GetParamStringValue(TAG_SPTYPE, "");
    }

    public String getDERTYPEID() {
        return this.GetParamStringValue(TAG_DERTYPEID, "");
    }

    public String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public String getFORMID() {
        return this.GetParamStringValue(TAG_FORMID, "");
    }

    public String getPAGEID() {
        return this.GetParamStringValue(TAG_PAGEID, "");
    }

    public String getSMALLICON() {
        return this.GetParamStringValue(TAG_SMALLICON, "");
    }

    public String getAPPENDPARAM() {
        return this.GetParamStringValue(TAG_APPENDPARAM, "");
    }

    public void setSUMMARYPAGEID(String strValue) {
        this.SetParamValue(TAG_SUMMARYPAGEID, strValue);
    }

    public void setSUMMARYPAGENAME(String strValue) {
        this.SetParamValue(TAG_SUMMARYPAGENAME, strValue);
    }

    public void setDEID(String strValue) {
        this.SetParamValue(TAG_DEID, strValue);
    }

    public void setSPTYPE(String strValue) {
        this.SetParamValue(TAG_SPTYPE, strValue);
    }

    public void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public void setDERTYPEID(String strValue) {
        this.SetParamValue(TAG_DERTYPEID, strValue);
    }

    public String getDERTYPENAME() {
        return this.GetParamStringValue(TAG_DERTYPENAME, "");
    }

    public int getDERSHOWORDER() {
        return this.GetParamIntValue(TAG_DERSHOWORDER, 100);
    }

    public int getSUMSHOWORDER() {
        return this.GetParamIntValue(TAG_SUMSHOWORDER, 100);
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

    public boolean isNAMELANRESIDNull() {
        return this.IsParamNull(TAG_NAMELANRESID);
    }

    public String getNAMELANRESID() {
        return this.GetParamStringValue(TAG_NAMELANRESID, "");
    }

    public void setNAMELANRESID(String strValue) {
        this.SetParamValue(TAG_NAMELANRESID, strValue);
    }

    public boolean isNAMELANRESNAMENull() {
        return this.IsParamNull(TAG_NAMELANRESNAME);
    }

    public String getNAMELANRESNAME() {
        return this.GetParamStringValue(TAG_NAMELANRESNAME, "");
    }

    public void setNAMELANRESNAME(String strValue) {
        this.SetParamValue(TAG_NAMELANRESNAME, strValue);
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

    public boolean isFORMNAMENull() {
        return this.IsParamNull(TAG_FORMNAME);
    }

    public String getFORMNAME() {
        return this.GetParamStringValue(TAG_FORMNAME, "");
    }

    public void setFORMNAME(String strValue) {
        this.SetParamValue(TAG_FORMNAME, strValue);
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
}

