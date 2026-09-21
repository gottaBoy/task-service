/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.UAC.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class UACWebFile
extends BaseDataEntity {
    public static final String TAG_UACWEBFILEID = "UACWEBFILEID";
    public static final String TAG_UACWEBFILENAME = "UACWEBFILENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_WEBPATH = "WEBPATH";
    public static final String TAG_FILECONTENT = "FILECONTENT";
    public static final String TAG_FILEENC = "FILEENC";

    public String getUACWEBFILEID() {
        return this.GetParamStringValue(TAG_UACWEBFILEID, "");
    }

    public void setUACWEBFILEID(String strValue) {
        this.SetParamValue(TAG_UACWEBFILEID, strValue);
    }

    public String getUACWEBFILENAME() {
        return this.GetParamStringValue(TAG_UACWEBFILENAME, "");
    }

    public void setUACWEBFILENAME(String strValue) {
        this.SetParamValue(TAG_UACWEBFILENAME, strValue);
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

    public String getWEBPATH() {
        return this.GetParamStringValue(TAG_WEBPATH, "");
    }

    public void setWEBPATH(String strValue) {
        this.SetParamValue(TAG_WEBPATH, strValue);
    }

    public String getFILECONTENT() {
        return this.GetParamStringValue(TAG_FILECONTENT, "");
    }

    public void setFILECONTENT(String strValue) {
        this.SetParamValue(TAG_FILECONTENT, strValue);
    }

    public String getFILEENC() {
        return this.GetParamStringValue(TAG_FILEENC, "");
    }

    public void setFILEENC(String strValue) {
        this.SetParamValue(TAG_FILEENC, strValue);
    }
}

