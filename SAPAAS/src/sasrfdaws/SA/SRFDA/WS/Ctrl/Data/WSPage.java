/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.WS.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class WSPage
extends BaseDataEntity {
    public static final String TAG_WSPAGEID = "WSPAGEID";
    public static final String TAG_WSPAGENAME = "WSPAGENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_WSPAGETEMPLNAME = "WSPAGETEMPLNAME";
    public static final String TAG_WSPAGETEMPLID = "WSPAGETEMPLID";
    public static final String TAG_WSWEBSITEID = "WSWEBSITEID";
    public static final String TAG_WSWEBSITENAME = "WSWEBSITENAME";
    public static final String TAG_PAGEMODEL = "PAGEMODEL";
    public static final String TAG_VERSION = "VERSION";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_ISINDEX = "ISINDEX";
    public static final String TAG_WSCHANNELID = "WSCHANNELID";
    public static final String TAG_WSCHANNELNAME = "WSCHANNELNAME";
    public static final String TAG_TARGET = "TARGET";

    public boolean isWSPAGEIDNull() {
        return this.IsParamNull(TAG_WSPAGEID);
    }

    public String getWSPAGEID() {
        return this.GetParamStringValue(TAG_WSPAGEID, "");
    }

    public void setWSPAGEID(String strValue) {
        this.SetParamValue(TAG_WSPAGEID, strValue);
    }

    public boolean isWSPAGENAMENull() {
        return this.IsParamNull(TAG_WSPAGENAME);
    }

    public String getWSPAGENAME() {
        return this.GetParamStringValue(TAG_WSPAGENAME, "");
    }

    public void setWSPAGENAME(String strValue) {
        this.SetParamValue(TAG_WSPAGENAME, strValue);
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

    public boolean isWSPAGETEMPLNAMENull() {
        return this.IsParamNull(TAG_WSPAGETEMPLNAME);
    }

    public String getWSPAGETEMPLNAME() {
        return this.GetParamStringValue(TAG_WSPAGETEMPLNAME, "");
    }

    public void setWSPAGETEMPLNAME(String strValue) {
        this.SetParamValue(TAG_WSPAGETEMPLNAME, strValue);
    }

    public boolean isWSPAGETEMPLIDNull() {
        return this.IsParamNull(TAG_WSPAGETEMPLID);
    }

    public String getWSPAGETEMPLID() {
        return this.GetParamStringValue(TAG_WSPAGETEMPLID, "");
    }

    public void setWSPAGETEMPLID(String strValue) {
        this.SetParamValue(TAG_WSPAGETEMPLID, strValue);
    }

    public boolean isWSWEBSITEIDNull() {
        return this.IsParamNull(TAG_WSWEBSITEID);
    }

    public String getWSWEBSITEID() {
        return this.GetParamStringValue(TAG_WSWEBSITEID, "");
    }

    public void setWSWEBSITEID(String strValue) {
        this.SetParamValue(TAG_WSWEBSITEID, strValue);
    }

    public boolean isWSWEBSITENAMENull() {
        return this.IsParamNull(TAG_WSWEBSITENAME);
    }

    public String getWSWEBSITENAME() {
        return this.GetParamStringValue(TAG_WSWEBSITENAME, "");
    }

    public void setWSWEBSITENAME(String strValue) {
        this.SetParamValue(TAG_WSWEBSITENAME, strValue);
    }

    public boolean isPAGEMODELNull() {
        return this.IsParamNull(TAG_PAGEMODEL);
    }

    public String getPAGEMODEL() {
        return this.GetParamStringValue(TAG_PAGEMODEL, "");
    }

    public void setPAGEMODEL(String strValue) {
        this.SetParamValue(TAG_PAGEMODEL, strValue);
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

    public boolean isDESCRIPTIONNull() {
        return this.IsParamNull(TAG_DESCRIPTION);
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }

    public boolean isISINDEXNull() {
        return this.IsParamNull(TAG_ISINDEX);
    }

    public boolean getISINDEX() {
        return this.GetParamIntValue(TAG_ISINDEX, 0) == 1;
    }

    public void setISINDEX(boolean bValue) {
        this.SetParamValue(TAG_ISINDEX, bValue ? 1 : 0);
    }

    public boolean isWSCHANNELIDNull() {
        return this.IsParamNull(TAG_WSCHANNELID);
    }

    public String getWSCHANNELID() {
        return this.GetParamStringValue(TAG_WSCHANNELID, "");
    }

    public void setWSCHANNELID(String strValue) {
        this.SetParamValue(TAG_WSCHANNELID, strValue);
    }

    public boolean isWSCHANNELNAMENull() {
        return this.IsParamNull(TAG_WSCHANNELNAME);
    }

    public String getWSCHANNELNAME() {
        return this.GetParamStringValue(TAG_WSCHANNELNAME, "");
    }

    public void setWSCHANNELNAME(String strValue) {
        this.SetParamValue(TAG_WSCHANNELNAME, strValue);
    }

    public boolean isTARGETNull() {
        return this.IsParamNull(TAG_TARGET);
    }

    public String getTARGET() {
        return this.GetParamStringValue(TAG_TARGET, "");
    }

    public void setTARGET(String strValue) {
        this.SetParamValue(TAG_TARGET, strValue);
    }
}

