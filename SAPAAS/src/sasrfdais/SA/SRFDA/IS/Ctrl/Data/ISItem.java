/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.IS.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class ISItem
extends BaseDataEntity {
    public static final String TAG_ISITEMID = "ISITEMID";
    public static final String TAG_ISITEMNAME = "ISITEMNAME";
    public static final String TAG_ISITEMTYPE = "ISITEMTYPE";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_ISGROUPID = "ISGROUPID";
    public static final String TAG_ISGROUPNAME = "ISGROUPNAME";
    public static final String TAG_LASTINDEXTIME = "LASTINDEXTIME";
    public static final String TAG_LASTINDEXTAG = "LASTINDEXTAG";
    public static final String TAG_INDEXLIMIT = "INDEXLIMIT";

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

    public String getISITEMTYPE() {
        return this.GetParamStringValue(TAG_ISITEMTYPE, "");
    }

    public void setISITEMTYPE(String strValue) {
        this.SetParamValue(TAG_ISITEMTYPE, strValue);
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

    public String getISGROUPID() {
        return this.GetParamStringValue(TAG_ISGROUPID, "");
    }

    public void setISGROUPID(String strValue) {
        this.SetParamValue(TAG_ISGROUPID, strValue);
    }

    public String getISGROUPNAME() {
        return this.GetParamStringValue(TAG_ISGROUPNAME, "");
    }

    public void setISGROUPNAME(String strValue) {
        this.SetParamValue(TAG_ISGROUPNAME, strValue);
    }

    public Date getLASTINDEXTIME() {
        return this.GetParamDateValue(TAG_LASTINDEXTIME, null);
    }

    public void setLASTINDEXTIME(Date strValue) {
        this.SetParamValue(TAG_LASTINDEXTIME, strValue);
    }

    public String getLASTINDEXTAG() {
        return this.GetParamStringValue(TAG_LASTINDEXTAG, "");
    }

    public void setLASTINDEXTAG(String strValue) {
        this.SetParamValue(TAG_LASTINDEXTAG, strValue);
    }

    public int getINDEXLIMIT() {
        return this.GetParamIntValue(TAG_INDEXLIMIT, 0);
    }

    public void setINDEXLIMIT(int strValue) {
        this.SetParamValue(TAG_INDEXLIMIT, strValue);
    }
}

