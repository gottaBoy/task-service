/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class DERGroupFolder
extends BaseDataEntity {
    public static final String TAG_DERGROUPFOLDERID = "DERGROUPFOLDERID";
    public static final String TAG_DERGROUPFOLDERNAME = "DERGROUPFOLDERNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_SMALLICON = "SMALLICON";
    public static final String TAG_ISCOLLAPSE = "ISCOLLAPSE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_SHOWORDER = "SHOWORDER";

    public boolean isDERGROUPFOLDERIDNull() {
        return this.IsParamNull(TAG_DERGROUPFOLDERID);
    }

    public String getDERGROUPFOLDERID() {
        return this.GetParamStringValue(TAG_DERGROUPFOLDERID, "");
    }

    public void setDERGROUPFOLDERID(String strValue) {
        this.SetParamValue(TAG_DERGROUPFOLDERID, strValue);
    }

    public boolean isDERGROUPFOLDERNAMENull() {
        return this.IsParamNull(TAG_DERGROUPFOLDERNAME);
    }

    public String getDERGROUPFOLDERNAME() {
        return this.GetParamStringValue(TAG_DERGROUPFOLDERNAME, "");
    }

    public void setDERGROUPFOLDERNAME(String strValue) {
        this.SetParamValue(TAG_DERGROUPFOLDERNAME, strValue);
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

    public boolean isSMALLICONNull() {
        return this.IsParamNull(TAG_SMALLICON);
    }

    public String getSMALLICON() {
        return this.GetParamStringValue(TAG_SMALLICON, "");
    }

    public void setSMALLICON(String strValue) {
        this.SetParamValue(TAG_SMALLICON, strValue);
    }

    public boolean isISCOLLAPSENull() {
        return this.IsParamNull(TAG_ISCOLLAPSE);
    }

    public boolean getISCOLLAPSE() {
        return this.GetParamIntValue(TAG_ISCOLLAPSE, 0) == 1;
    }

    public void setISCOLLAPSE(boolean bValue) {
        this.SetParamValue(TAG_ISCOLLAPSE, bValue ? 1 : 0);
    }

    public boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public boolean isSHOWORDERNull() {
        return this.IsParamNull(TAG_SHOWORDER);
    }

    public int getSHOWORDER() {
        return this.GetParamIntValue(TAG_SHOWORDER, 0);
    }

    public void setSHOWORDER(int nValue) {
        this.SetParamValue(TAG_SHOWORDER, nValue);
    }
}

