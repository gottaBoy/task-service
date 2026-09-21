/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.BI.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class BICubeMeasure
extends BaseDataEntity {
    public static final String BICUBEMEASURETYPE_NORMAL = "NORMAL";
    public static final String BICUBEMEASURETYPE_CALCULATED = "CALCULATED";
    public static final String FMTTYPE_CUSTOM = "CUSTOM";
    public static final String TAG_BICUBEMEASUREID = "BICUBEMEASUREID";
    public static final String TAG_BICUBEMEASURENAME = "BICUBEMEASURENAME";
    public static final String TAG_BICUBEMEASURETYPE = "BICUBEMEASURETYPE";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_BICUBEID = "BICUBEID";
    public static final String TAG_BICUBENAME = "BICUBENAME";
    public static final String TAG_CAPTION = "CAPTION";
    public static final String TAG_FMTTYPE = "FMTTYPE";
    public static final String TAG_CUSTOMFMT = "CUSTOMFMT";
    public static final String TAG_HIDDENFLAG = "HIDDENFLAG";
    public static final String TAG_ORDERFLAG = "ORDERFLAG";
    public static final String TAG_THGROUPID = "THGROUPID";
    public static final String TAG_THGROUPNAME = "THGROUPNAME";
    public static final String TAG_MEASUREGROUP = "MEASUREGROUP";
    public static final String TAG_COLUMNWIDTH = "COLUMNWIDTH";

    public String getBICUBEMEASUREID() {
        return this.GetParamStringValue(TAG_BICUBEMEASUREID, "");
    }

    public void setBICUBEMEASUREID(String strValue) {
        this.SetParamValue(TAG_BICUBEMEASUREID, strValue);
    }

    public String getBICUBEMEASURENAME() {
        return this.GetParamStringValue(TAG_BICUBEMEASURENAME, "");
    }

    public void setBICUBEMEASURENAME(String strValue) {
        this.SetParamValue(TAG_BICUBEMEASURENAME, strValue);
    }

    public String getBICUBEMEASURETYPE() {
        return this.GetParamStringValue(TAG_BICUBEMEASURETYPE, "");
    }

    public void setBICUBEMEASURETYPE(String strValue) {
        this.SetParamValue(TAG_BICUBEMEASURETYPE, strValue);
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

    public String getBICUBEID() {
        return this.GetParamStringValue(TAG_BICUBEID, "");
    }

    public void setBICUBEID(String strValue) {
        this.SetParamValue(TAG_BICUBEID, strValue);
    }

    public String getBICUBENAME() {
        return this.GetParamStringValue(TAG_BICUBENAME, "");
    }

    public void setBICUBENAME(String strValue) {
        this.SetParamValue(TAG_BICUBENAME, strValue);
    }

    public String getCAPTION() {
        return this.GetParamStringValue(TAG_CAPTION, "");
    }

    public void setCAPTION(String strValue) {
        this.SetParamValue(TAG_CAPTION, strValue);
    }

    public String getFMTTYPE() {
        return this.GetParamStringValue(TAG_FMTTYPE, "");
    }

    public void setFMTTYPE(String strValue) {
        this.SetParamValue(TAG_FMTTYPE, strValue);
    }

    public String getCUSTOMFMT() {
        return this.GetParamStringValue(TAG_CUSTOMFMT, "");
    }

    public void setCUSTOMFMT(String strValue) {
        this.SetParamValue(TAG_CUSTOMFMT, strValue);
    }

    public boolean isHIDDENFLAGNull() {
        return this.IsParamNull(TAG_HIDDENFLAG);
    }

    public boolean getHIDDENFLAG() {
        return this.GetParamIntValue(TAG_HIDDENFLAG, 0) == 1;
    }

    public void setHIDDENFLAG(boolean bValue) {
        this.SetParamValue(TAG_HIDDENFLAG, bValue ? 1 : 0);
    }

    public boolean isORDERFLAGNull() {
        return this.IsParamNull(TAG_ORDERFLAG);
    }

    public int getORDERFLAG() {
        return this.GetParamIntValue(TAG_ORDERFLAG, 0);
    }

    public void setORDERFLAG(int nValue) {
        this.SetParamValue(TAG_ORDERFLAG, nValue);
    }

    public boolean isTHGROUPIDNull() {
        return this.IsParamNull(TAG_THGROUPID);
    }

    public String getTHGROUPID() {
        return this.GetParamStringValue(TAG_THGROUPID, "");
    }

    public void setTHGROUPID(String strValue) {
        this.SetParamValue(TAG_THGROUPID, strValue);
    }

    public boolean isTHGROUPNAMENull() {
        return this.IsParamNull(TAG_THGROUPNAME);
    }

    public String getTHGROUPNAME() {
        return this.GetParamStringValue(TAG_THGROUPNAME, "");
    }

    public void setTHGROUPNAME(String strValue) {
        this.SetParamValue(TAG_THGROUPNAME, strValue);
    }

    public boolean isMEASUREGROUPNull() {
        return this.IsParamNull(TAG_MEASUREGROUP);
    }

    public String getMEASUREGROUP() {
        return this.GetParamStringValue(TAG_MEASUREGROUP, "");
    }

    public void setMEASUREGROUP(String strValue) {
        this.SetParamValue(TAG_MEASUREGROUP, strValue);
    }

    public boolean isCOLUMNWIDTHNull() {
        return this.IsParamNull(TAG_COLUMNWIDTH);
    }

    public int getCOLUMNWIDTH() {
        return this.GetParamIntValue(TAG_COLUMNWIDTH, 0);
    }

    public void setCOLUMNWIDTH(int nValue) {
        this.SetParamValue(TAG_COLUMNWIDTH, nValue);
    }
}

