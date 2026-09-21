/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PageParamDetail
extends BaseDataEntity {
    public static final String TAG_PAGEPARAMDETAILID = "PAGEPARAMDETAILID";
    public static final String TAG_PAGEPARAMDETAILNAME = "PAGEPARAMDETAILNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PAGEID = "PAGEID";
    public static final String TAG_PAGENAME = "PAGENAME";
    public static final String TAG_PARAM1 = "PARAM1";
    public static final String TAG_PARAM2 = "PARAM2";
    public static final String TAG_PAGEPARAM = "PAGEPARAM";

    public String getPAGEPARAMDETAILID() {
        return this.GetParamStringValue(TAG_PAGEPARAMDETAILID, "");
    }

    public void setPAGEPARAMDETAILID(String strValue) {
        this.SetParamValue(TAG_PAGEPARAMDETAILID, strValue);
    }

    public String getPAGEPARAMDETAILNAME() {
        return this.GetParamStringValue(TAG_PAGEPARAMDETAILNAME, "");
    }

    public void setPAGEPARAMDETAILNAME(String strValue) {
        this.SetParamValue(TAG_PAGEPARAMDETAILNAME, strValue);
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

    public String getPAGEID() {
        return this.GetParamStringValue(TAG_PAGEID, "");
    }

    public void setPAGEID(String strValue) {
        this.SetParamValue(TAG_PAGEID, strValue);
    }

    public String getPAGENAME() {
        return this.GetParamStringValue(TAG_PAGENAME, "");
    }

    public void setPAGENAME(String strValue) {
        this.SetParamValue(TAG_PAGENAME, strValue);
    }

    public String getPARAM1() {
        return this.GetParamStringValue(TAG_PARAM1, "");
    }

    public void setPARAM1(String strValue) {
        this.SetParamValue(TAG_PARAM1, strValue);
    }

    public String getPARAM2() {
        return this.GetParamStringValue(TAG_PARAM2, "");
    }

    public void setPARAM2(String strValue) {
        this.SetParamValue(TAG_PARAM2, strValue);
    }

    public String getPAGEPARAM() {
        return this.GetParamStringValue(TAG_PAGEPARAM, "");
    }

    public void setPAGEPARAM(String strValue) {
        this.SetParamValue(TAG_PAGEPARAM, strValue);
    }
}

