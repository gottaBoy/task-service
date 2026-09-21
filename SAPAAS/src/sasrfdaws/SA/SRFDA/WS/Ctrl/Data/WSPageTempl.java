/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.WS.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class WSPageTempl
extends BaseDataEntity {
    public static final String TAG_WSPAGETEMPLID = "WSPAGETEMPLID";
    public static final String TAG_WSPAGETEMPLNAME = "WSPAGETEMPLNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PAGEMODEL = "PAGEMODEL";
    public static final String TAG_WSPAGETYPEID = "WSPAGETYPEID";
    public static final String TAG_WSPAGETYPENAME = "WSPAGETYPENAME";
    public static final String TAG_VERSION = "VERSION";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";

    public boolean isWSPAGETEMPLIDNull() {
        return this.IsParamNull(TAG_WSPAGETEMPLID);
    }

    public String getWSPAGETEMPLID() {
        return this.GetParamStringValue(TAG_WSPAGETEMPLID, "");
    }

    public void setWSPAGETEMPLID(String strValue) {
        this.SetParamValue(TAG_WSPAGETEMPLID, strValue);
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

    public boolean isPAGEMODELNull() {
        return this.IsParamNull(TAG_PAGEMODEL);
    }

    public String getPAGEMODEL() {
        return this.GetParamStringValue(TAG_PAGEMODEL, "");
    }

    public void setPAGEMODEL(String strValue) {
        this.SetParamValue(TAG_PAGEMODEL, strValue);
    }

    public boolean isWSPAGETYPEIDNull() {
        return this.IsParamNull(TAG_WSPAGETYPEID);
    }

    public String getWSPAGETYPEID() {
        return this.GetParamStringValue(TAG_WSPAGETYPEID, "");
    }

    public void setWSPAGETYPEID(String strValue) {
        this.SetParamValue(TAG_WSPAGETYPEID, strValue);
    }

    public boolean isWSPAGETYPENAMENull() {
        return this.IsParamNull(TAG_WSPAGETYPENAME);
    }

    public String getWSPAGETYPENAME() {
        return this.GetParamStringValue(TAG_WSPAGETYPENAME, "");
    }

    public void setWSPAGETYPENAME(String strValue) {
        this.SetParamValue(TAG_WSPAGETYPENAME, strValue);
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
}

