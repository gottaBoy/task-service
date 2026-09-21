/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class ConfigPublisher
extends BaseDataEntity {
    public static final String TAG_CONFIGPUBLISHERID = "CONFIGPUBLISHERID";
    public static final String TAG_CONFIGPUBLISHERNAME = "CONFIGPUBLISHERNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PARAM = "PARAM";
    public static final String TAG_PUBLISHEROBJ = "PUBLISHEROBJ";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_CONFIGTYPE = "CONFIGTYPE";
    public static final String TAG_CONFIGMODE = "CONFIGMODE";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_PAGETYPE = "PAGETYPE";

    public boolean isCONFIGPUBLISHERIDNull() {
        return this.IsParamNull(TAG_CONFIGPUBLISHERID);
    }

    public String getCONFIGPUBLISHERID() {
        return this.GetParamStringValue(TAG_CONFIGPUBLISHERID, "");
    }

    public void setCONFIGPUBLISHERID(String strValue) {
        this.SetParamValue(TAG_CONFIGPUBLISHERID, strValue);
    }

    public boolean isCONFIGPUBLISHERNAMENull() {
        return this.IsParamNull(TAG_CONFIGPUBLISHERNAME);
    }

    public String getCONFIGPUBLISHERNAME() {
        return this.GetParamStringValue(TAG_CONFIGPUBLISHERNAME, "");
    }

    public void setCONFIGPUBLISHERNAME(String strValue) {
        this.SetParamValue(TAG_CONFIGPUBLISHERNAME, strValue);
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

    public boolean isPARAMNull() {
        return this.IsParamNull(TAG_PARAM);
    }

    public String getPARAM() {
        return this.GetParamStringValue(TAG_PARAM, "");
    }

    public void setPARAM(String strValue) {
        this.SetParamValue(TAG_PARAM, strValue);
    }

    public boolean isPUBLISHEROBJNull() {
        return this.IsParamNull(TAG_PUBLISHEROBJ);
    }

    public String getPUBLISHEROBJ() {
        return this.GetParamStringValue(TAG_PUBLISHEROBJ, "");
    }

    public void setPUBLISHEROBJ(String strValue) {
        this.SetParamValue(TAG_PUBLISHEROBJ, strValue);
    }

    public boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
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

    public boolean isCONFIGTYPENull() {
        return this.IsParamNull(TAG_CONFIGTYPE);
    }

    public String getCONFIGTYPE() {
        return this.GetParamStringValue(TAG_CONFIGTYPE, "");
    }

    public void setCONFIGTYPE(String strValue) {
        this.SetParamValue(TAG_CONFIGTYPE, strValue);
    }

    public boolean isCONFIGMODENull() {
        return this.IsParamNull(TAG_CONFIGMODE);
    }

    public String getCONFIGMODE() {
        return this.GetParamStringValue(TAG_CONFIGMODE, "");
    }

    public void setCONFIGMODE(String strValue) {
        this.SetParamValue(TAG_CONFIGMODE, strValue);
    }

    public boolean isDEIDNull() {
        return this.IsParamNull(TAG_DEID);
    }

    public String getDEID() {
        return this.GetParamStringValue(TAG_DEID, "");
    }

    public void setDEID(String strValue) {
        this.SetParamValue(TAG_DEID, strValue);
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
}

