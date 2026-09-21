/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PwdStorage
extends BaseDataEntity {
    public static final String TAG_PWDSTORAGEID = "PWDSTORAGEID";
    public static final String TAG_PWDSTORAGENAME = "PWDSTORAGENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_REVERTFLAG = "REVERTFLAG";
    public static final String TAG_DATA = "DATA";

    public boolean isPWDSTORAGEIDNull() {
        return this.IsParamNull(TAG_PWDSTORAGEID);
    }

    public String getPWDSTORAGEID() {
        return this.GetParamStringValue(TAG_PWDSTORAGEID, "");
    }

    public void setPWDSTORAGEID(String strValue) {
        this.SetParamValue(TAG_PWDSTORAGEID, strValue);
    }

    public boolean isPWDSTORAGENAMENull() {
        return this.IsParamNull(TAG_PWDSTORAGENAME);
    }

    public String getPWDSTORAGENAME() {
        return this.GetParamStringValue(TAG_PWDSTORAGENAME, "");
    }

    public void setPWDSTORAGENAME(String strValue) {
        this.SetParamValue(TAG_PWDSTORAGENAME, strValue);
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

    public void setCREATEDATE(Date dtValue) {
        this.SetParamValue(TAG_CREATEDATE, dtValue);
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

    public void setUPDATEDATE(Date dtValue) {
        this.SetParamValue(TAG_UPDATEDATE, dtValue);
    }

    public boolean isREVERTFLAGNull() {
        return this.IsParamNull(TAG_REVERTFLAG);
    }

    public boolean getREVERTFLAG() {
        return this.GetParamIntValue(TAG_REVERTFLAG, 0) == 1;
    }

    public void setREVERTFLAG(boolean bValue) {
        this.SetParamValue(TAG_REVERTFLAG, bValue ? 1 : 0);
    }

    public boolean isDATANull() {
        return this.IsParamNull(TAG_DATA);
    }

    public String getDATA() {
        return this.GetParamStringValue(TAG_DATA, "");
    }

    public void setDATA(String strValue) {
        this.SetParamValue(TAG_DATA, strValue);
    }
}

