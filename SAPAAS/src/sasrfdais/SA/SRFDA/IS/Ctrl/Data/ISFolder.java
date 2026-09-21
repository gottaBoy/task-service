/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.IS.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class ISFolder
extends BaseDataEntity {
    public static final String TAG_ISFOLDERID = "ISFOLDERID";
    public static final String TAG_ISFOLDERNAME = "ISFOLDERNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_FOLDERPATH = "FOLDERPATH";

    public boolean isISFOLDERIDNull() {
        return this.IsParamNull(TAG_ISFOLDERID);
    }

    public String getISFOLDERID() {
        return this.GetParamStringValue(TAG_ISFOLDERID, "");
    }

    public void setISFOLDERID(String strValue) {
        this.SetParamValue(TAG_ISFOLDERID, strValue);
    }

    public boolean isISFOLDERNAMENull() {
        return this.IsParamNull(TAG_ISFOLDERNAME);
    }

    public String getISFOLDERNAME() {
        return this.GetParamStringValue(TAG_ISFOLDERNAME, "");
    }

    public void setISFOLDERNAME(String strValue) {
        this.SetParamValue(TAG_ISFOLDERNAME, strValue);
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

    public boolean isFOLDERPATHNull() {
        return this.IsParamNull(TAG_FOLDERPATH);
    }

    public String getFOLDERPATH() {
        return this.GetParamStringValue(TAG_FOLDERPATH, "");
    }

    public void setFOLDERPATH(String strValue) {
        this.SetParamValue(TAG_FOLDERPATH, strValue);
    }
}

