/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.BI.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class BIRepChart
extends BaseDataEntity {
    public static final String TAG_BIREPCHARTID = "BIREPCHARTID";
    public static final String TAG_BIREPCHARTNAME = "BIREPCHARTNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_BIREPPARTTYPE = "BIREPPARTTYPE";
    public static final String TAG_BICUBEID = "BICUBEID";
    public static final String TAG_BICUBENAME = "BICUBENAME";
    public static final String TAG_VERSION = "VERSION";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_CUSTOMOBJECT = "CUSTOMOBJECT";

    public boolean isBIREPCHARTIDNull() {
        return this.IsParamNull(TAG_BIREPCHARTID);
    }

    public String getBIREPCHARTID() {
        return this.GetParamStringValue(TAG_BIREPCHARTID, "");
    }

    public void setBIREPCHARTID(String strValue) {
        this.SetParamValue(TAG_BIREPCHARTID, strValue);
    }

    public boolean isBIREPCHARTNAMENull() {
        return this.IsParamNull(TAG_BIREPCHARTNAME);
    }

    public String getBIREPCHARTNAME() {
        return this.GetParamStringValue(TAG_BIREPCHARTNAME, "");
    }

    public void setBIREPCHARTNAME(String strValue) {
        this.SetParamValue(TAG_BIREPCHARTNAME, strValue);
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

    public boolean isBIREPPARTTYPENull() {
        return this.IsParamNull(TAG_BIREPPARTTYPE);
    }

    public String getBIREPPARTTYPE() {
        return this.GetParamStringValue(TAG_BIREPPARTTYPE, "");
    }

    public void setBIREPPARTTYPE(String strValue) {
        this.SetParamValue(TAG_BIREPPARTTYPE, strValue);
    }

    public boolean isBICUBEIDNull() {
        return this.IsParamNull(TAG_BICUBEID);
    }

    public String getBICUBEID() {
        return this.GetParamStringValue(TAG_BICUBEID, "");
    }

    public void setBICUBEID(String strValue) {
        this.SetParamValue(TAG_BICUBEID, strValue);
    }

    public boolean isBICUBENAMENull() {
        return this.IsParamNull(TAG_BICUBENAME);
    }

    public String getBICUBENAME() {
        return this.GetParamStringValue(TAG_BICUBENAME, "");
    }

    public void setBICUBENAME(String strValue) {
        this.SetParamValue(TAG_BICUBENAME, strValue);
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

    public boolean isCUSTOMOBJECTNull() {
        return this.IsParamNull(TAG_CUSTOMOBJECT);
    }

    public String getCUSTOMOBJECT() {
        return this.GetParamStringValue(TAG_CUSTOMOBJECT, "");
    }

    public void setCUSTOMOBJECT(String strValue) {
        this.SetParamValue(TAG_CUSTOMOBJECT, strValue);
    }
}

