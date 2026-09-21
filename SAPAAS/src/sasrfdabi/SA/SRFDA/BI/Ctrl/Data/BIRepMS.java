/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.BI.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class BIRepMS
extends BaseDataEntity {
    public static final String TAG_BIREPMSID = "BIREPMSID";
    public static final String TAG_BIREPMSNAME = "BIREPMSNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_BIREPORTEXID = "BIREPORTEXID";
    public static final String TAG_BIREPORTEXNAME = "BIREPORTEXNAME";
    public static final String TAG_BICUBEMEASUREID = "BICUBEMEASUREID";
    public static final String TAG_BICUBEMEASURENAME = "BICUBEMEASURENAME";
    public static final String TAG_PLACEPOS = "PLACEPOS";
    public static final String TAG_COLUMNWIDTH = "COLUMNWIDTH";

    public boolean isBIREPMSIDNull() {
        return this.IsParamNull(TAG_BIREPMSID);
    }

    public String getBIREPMSID() {
        return this.GetParamStringValue(TAG_BIREPMSID, "");
    }

    public void setBIREPMSID(String strValue) {
        this.SetParamValue(TAG_BIREPMSID, strValue);
    }

    public boolean isBIREPMSNAMENull() {
        return this.IsParamNull(TAG_BIREPMSNAME);
    }

    public String getBIREPMSNAME() {
        return this.GetParamStringValue(TAG_BIREPMSNAME, "");
    }

    public void setBIREPMSNAME(String strValue) {
        this.SetParamValue(TAG_BIREPMSNAME, strValue);
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

    public boolean isBIREPORTEXIDNull() {
        return this.IsParamNull(TAG_BIREPORTEXID);
    }

    public String getBIREPORTEXID() {
        return this.GetParamStringValue(TAG_BIREPORTEXID, "");
    }

    public void setBIREPORTEXID(String strValue) {
        this.SetParamValue(TAG_BIREPORTEXID, strValue);
    }

    public boolean isBIREPORTEXNAMENull() {
        return this.IsParamNull(TAG_BIREPORTEXNAME);
    }

    public String getBIREPORTEXNAME() {
        return this.GetParamStringValue(TAG_BIREPORTEXNAME, "");
    }

    public void setBIREPORTEXNAME(String strValue) {
        this.SetParamValue(TAG_BIREPORTEXNAME, strValue);
    }

    public boolean isBICUBEMEASUREIDNull() {
        return this.IsParamNull(TAG_BICUBEMEASUREID);
    }

    public String getBICUBEMEASUREID() {
        return this.GetParamStringValue(TAG_BICUBEMEASUREID, "");
    }

    public void setBICUBEMEASUREID(String strValue) {
        this.SetParamValue(TAG_BICUBEMEASUREID, strValue);
    }

    public boolean isBICUBEMEASURENAMENull() {
        return this.IsParamNull(TAG_BICUBEMEASURENAME);
    }

    public String getBICUBEMEASURENAME() {
        return this.GetParamStringValue(TAG_BICUBEMEASURENAME, "");
    }

    public void setBICUBEMEASURENAME(String strValue) {
        this.SetParamValue(TAG_BICUBEMEASURENAME, strValue);
    }

    public boolean isPLACEPOSNull() {
        return this.IsParamNull(TAG_PLACEPOS);
    }

    public int getPLACEPOS() {
        return this.GetParamIntValue(TAG_PLACEPOS, 0);
    }

    public void setPLACEPOS(int strValue) {
        this.SetParamValue(TAG_PLACEPOS, strValue);
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

