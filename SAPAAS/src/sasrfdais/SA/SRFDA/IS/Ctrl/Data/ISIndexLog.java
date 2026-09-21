/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.IS.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class ISIndexLog
extends BaseDataEntity {
    public static final String TAG_ISINDEXLOGID = "ISINDEXLOGID";
    public static final String TAG_ISINDEXLOGNAME = "ISINDEXLOGNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_ISITEMID = "ISITEMID";
    public static final String TAG_ISITEMNAME = "ISITEMNAME";
    public static final String TAG_INDEXCOUNT = "INDEXCOUNT";
    public static final String TAG_INDEXCONTENT = "INDEXCONTENT";
    public static final String TAG_STARTTIME = "STARTTIME";
    public static final String TAG_ENDTIME = "ENDTIME";

    public String getISINDEXLOGID() {
        return this.GetParamStringValue(TAG_ISINDEXLOGID, "");
    }

    public void setISINDEXLOGID(String strValue) {
        this.SetParamValue(TAG_ISINDEXLOGID, strValue);
    }

    public String getISINDEXLOGNAME() {
        return this.GetParamStringValue(TAG_ISINDEXLOGNAME, "");
    }

    public void setISINDEXLOGNAME(String strValue) {
        this.SetParamValue(TAG_ISINDEXLOGNAME, strValue);
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

    public String getISITEMID() {
        return this.GetParamStringValue(TAG_ISITEMID, "");
    }

    public void setISITEMID(String strValue) {
        this.SetParamValue(TAG_ISITEMID, strValue);
    }

    public String getISITEMNAME() {
        return this.GetParamStringValue(TAG_ISITEMNAME, "");
    }

    public void setISITEMNAME(String strValue) {
        this.SetParamValue(TAG_ISITEMNAME, strValue);
    }

    public int getINDEXCOUNT() {
        return this.GetParamIntValue(TAG_INDEXCOUNT, 0);
    }

    public void setINDEXCOUNT(int strValue) {
        this.SetParamValue(TAG_INDEXCOUNT, strValue);
    }

    public String getINDEXCONTENT() {
        return this.GetParamStringValue(TAG_INDEXCONTENT, "");
    }

    public void setINDEXCONTENT(String strValue) {
        this.SetParamValue(TAG_INDEXCONTENT, strValue);
    }

    public Date getSTARTTIME() {
        return this.GetParamDateValue(TAG_STARTTIME, null);
    }

    public void setSTARTTIME(Date strValue) {
        this.SetParamValue(TAG_STARTTIME, strValue);
    }

    public Date getENDTIME() {
        return this.GetParamDateValue(TAG_ENDTIME, null);
    }

    public void setENDTIME(Date strValue) {
        this.SetParamValue(TAG_ENDTIME, strValue);
    }
}

