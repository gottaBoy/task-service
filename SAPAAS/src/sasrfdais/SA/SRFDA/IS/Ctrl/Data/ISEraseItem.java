/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.IS.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class ISEraseItem
extends BaseDataEntity {
    public static final String TAG_ISERASEITEMID = "ISERASEITEMID";
    public static final String TAG_ISERASEITEMNAME = "ISERASEITEMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_ISGROUPID = "ISGROUPID";
    public static final String TAG_ISGROUPNAME = "ISGROUPNAME";
    public static final String TAG_PAGESIZE = "PAGESIZE";
    public static final String TAG_PAGEORDERINFO = "PAGEORDERINFO";
    public static final String TAG_EXTCOND = "EXTCOND";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_DENAME = "DENAME";

    public String getISERASEITEMID() {
        return this.GetParamStringValue(TAG_ISERASEITEMID, "");
    }

    public void setISERASEITEMID(String strValue) {
        this.SetParamValue(TAG_ISERASEITEMID, strValue);
    }

    public String getISERASEITEMNAME() {
        return this.GetParamStringValue(TAG_ISERASEITEMNAME, "");
    }

    public void setISERASEITEMNAME(String strValue) {
        this.SetParamValue(TAG_ISERASEITEMNAME, strValue);
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

    public int getPAGESIZE() {
        return this.GetParamIntValue(TAG_PAGESIZE, 0);
    }

    public void setPAGESIZE(int strValue) {
        this.SetParamValue(TAG_PAGESIZE, strValue);
    }

    public String getPAGEORDERINFO() {
        return this.GetParamStringValue(TAG_PAGEORDERINFO, "");
    }

    public void setPAGEORDERINFO(String strValue) {
        this.SetParamValue(TAG_PAGEORDERINFO, strValue);
    }

    public String getEXTCOND() {
        return this.GetParamStringValue(TAG_EXTCOND, "");
    }

    public void setEXTCOND(String strValue) {
        this.SetParamValue(TAG_EXTCOND, strValue);
    }

    public String getDEID() {
        return this.GetParamStringValue(TAG_DEID, "");
    }

    public void setDEID(String strValue) {
        this.SetParamValue(TAG_DEID, strValue);
    }

    public String getDENAME() {
        return this.GetParamStringValue(TAG_DENAME, "");
    }

    public void setDENAME(String strValue) {
        this.SetParamValue(TAG_DENAME, strValue);
    }
}

