/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSAppUtilPage
extends BaseDataEntity {
    public static final String PSAPPUTILPAGENAME_DOWNLOADTMPFILE = "DOWNLOADTMPFILE";
    public static final String PSAPPUTILPAGENAME_LOGIN = "LOGIN";
    public static final String PSAPPUTILPAGENAME_LOGOUT = "LOGOUT";
    public static final String TARGETTYPE_PAGEURL = "PAGEURL";
    public static final String TARGETTYPE_APPVIEW = "APPVIEW";
    public static final String TAG_PSAPPUTILPAGEID = "PSAPPUTILPAGEID";
    public static final String TAG_PSAPPUTILPAGENAME = "PSAPPUTILPAGENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PAGEURL = "PAGEURL";
    public static final String TAG_PSSYSAPPID = "PSSYSAPPID";
    public static final String TAG_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String TAG_PSAPPVIEWID = "PSAPPVIEWID";
    public static final String TAG_PSAPPVIEWNAME = "PSAPPVIEWNAME";
    public static final String TAG_TARGETTYPE = "TARGETTYPE";
    public static final String TAG_UTILTAG = "UTILTAG";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_UTILTYPE = "UTILTYPE";
    public static final String TAG_UTILPARAMS = "UTILPARAMS";
    public static final String TAG_PSSYSVIEWPANELID = "PSSYSVIEWPANELID";
    public static final String TAG_PSSYSVIEWPANELNAME = "PSSYSVIEWPANELNAME";

    public final boolean isPSAPPUTILPAGEIDNull() {
        return this.IsParamNull(TAG_PSAPPUTILPAGEID);
    }

    public final String getPSAPPUTILPAGEID() {
        return this.GetParamStringValue(TAG_PSAPPUTILPAGEID, "");
    }

    public final void setPSAPPUTILPAGEID(String strValue) {
        this.SetParamValue(TAG_PSAPPUTILPAGEID, strValue);
    }

    public final boolean isPSAPPUTILPAGENAMENull() {
        return this.IsParamNull(TAG_PSAPPUTILPAGENAME);
    }

    public final String getPSAPPUTILPAGENAME() {
        return this.GetParamStringValue(TAG_PSAPPUTILPAGENAME, "");
    }

    public final void setPSAPPUTILPAGENAME(String strValue) {
        this.SetParamValue(TAG_PSAPPUTILPAGENAME, strValue);
    }

    public final boolean isCREATEMANNull() {
        return this.IsParamNull(TAG_CREATEMAN);
    }

    public final String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public final void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public final boolean isCREATEDATENull() {
        return this.IsParamNull(TAG_CREATEDATE);
    }

    public final Date getCREATEDATE() {
        return this.GetParamDateValue(TAG_CREATEDATE, null);
    }

    public final void setCREATEDATE(Date dtValue) {
        this.SetParamValue(TAG_CREATEDATE, dtValue);
    }

    public final boolean isUPDATEMANNull() {
        return this.IsParamNull(TAG_UPDATEMAN);
    }

    public final String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public final void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public final boolean isUPDATEDATENull() {
        return this.IsParamNull(TAG_UPDATEDATE);
    }

    public final Date getUPDATEDATE() {
        return this.GetParamDateValue(TAG_UPDATEDATE, null);
    }

    public final void setUPDATEDATE(Date dtValue) {
        this.SetParamValue(TAG_UPDATEDATE, dtValue);
    }

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isPAGEURLNull() {
        return this.IsParamNull("PAGEURL");
    }

    public final String getPAGEURL() {
        return this.GetParamStringValue("PAGEURL", "");
    }

    public final void setPAGEURL(String strValue) {
        this.SetParamValue("PAGEURL", strValue);
    }

    public final boolean isPSSYSAPPIDNull() {
        return this.IsParamNull(TAG_PSSYSAPPID);
    }

    public final String getPSSYSAPPID() {
        return this.GetParamStringValue(TAG_PSSYSAPPID, "");
    }

    public final void setPSSYSAPPID(String strValue) {
        this.SetParamValue(TAG_PSSYSAPPID, strValue);
    }

    public final boolean isPSSYSAPPNAMENull() {
        return this.IsParamNull(TAG_PSSYSAPPNAME);
    }

    public final String getPSSYSAPPNAME() {
        return this.GetParamStringValue(TAG_PSSYSAPPNAME, "");
    }

    public final void setPSSYSAPPNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSAPPNAME, strValue);
    }

    public final boolean isPSAPPVIEWIDNull() {
        return this.IsParamNull(TAG_PSAPPVIEWID);
    }

    public final String getPSAPPVIEWID() {
        return this.GetParamStringValue(TAG_PSAPPVIEWID, "");
    }

    public final void setPSAPPVIEWID(String strValue) {
        this.SetParamValue(TAG_PSAPPVIEWID, strValue);
    }

    public final boolean isPSAPPVIEWNAMENull() {
        return this.IsParamNull(TAG_PSAPPVIEWNAME);
    }

    public final String getPSAPPVIEWNAME() {
        return this.GetParamStringValue(TAG_PSAPPVIEWNAME, "");
    }

    public final void setPSAPPVIEWNAME(String strValue) {
        this.SetParamValue(TAG_PSAPPVIEWNAME, strValue);
    }

    public final boolean isTARGETTYPENull() {
        return this.IsParamNull(TAG_TARGETTYPE);
    }

    public final String getTARGETTYPE() {
        return this.GetParamStringValue(TAG_TARGETTYPE, "");
    }

    public final void setTARGETTYPE(String strValue) {
        this.SetParamValue(TAG_TARGETTYPE, strValue);
    }

    public final boolean isUTILTAGNull() {
        return this.IsParamNull(TAG_UTILTAG);
    }

    public final String getUTILTAG() {
        return this.GetParamStringValue(TAG_UTILTAG, "");
    }

    public final void setUTILTAG(String strValue) {
        this.SetParamValue(TAG_UTILTAG, strValue);
    }

    public final boolean isCODENAMENull() {
        return this.IsParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.GetParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.SetParamValue(TAG_CODENAME, strValue);
    }

    public final boolean isUTILTYPENull() {
        return this.IsParamNull(TAG_UTILTYPE);
    }

    public final String getUTILTYPE() {
        return this.GetParamStringValue(TAG_UTILTYPE, "");
    }

    public final void setUTILTYPE(String strValue) {
        this.SetParamValue(TAG_UTILTYPE, strValue);
    }

    public final boolean isUTILPARAMSNull() {
        return this.IsParamNull(TAG_UTILPARAMS);
    }

    public final String getUTILPARAMS() {
        return this.GetParamStringValue(TAG_UTILPARAMS, "");
    }

    public final void setUTILPARAMS(String strValue) {
        this.SetParamValue(TAG_UTILPARAMS, strValue);
    }

    public final boolean isPSSYSVIEWPANELIDNull() {
        return this.IsParamNull(TAG_PSSYSVIEWPANELID);
    }

    public final String getPSSYSVIEWPANELID() {
        return this.GetParamStringValue(TAG_PSSYSVIEWPANELID, "");
    }

    public final void setPSSYSVIEWPANELID(String strValue) {
        this.SetParamValue(TAG_PSSYSVIEWPANELID, strValue);
    }

    public final boolean isPSSYSVIEWPANELNAMENull() {
        return this.IsParamNull(TAG_PSSYSVIEWPANELNAME);
    }

    public final String getPSSYSVIEWPANELNAME() {
        return this.GetParamStringValue(TAG_PSSYSVIEWPANELNAME, "");
    }

    public final void setPSSYSVIEWPANELNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSVIEWPANELNAME, strValue);
    }
}

