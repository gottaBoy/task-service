/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class DataMsgBoard
extends BaseDataEntity {
    public static final String TAG_DATAMSGBOARDID = "DATAMSGBOARDID";
    public static final String TAG_DATAMSGBOARDNAME = "DATAMSGBOARDNAME";
    public static final String TAG_ENABLE = "ENABLE";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_DATAID = "DATAID";
    public static final String TAG_MSG = "MSG";

    public String getDATAMSGBOARDID() {
        return this.GetParamStringValue(TAG_DATAMSGBOARDID, "");
    }

    public void setDATAMSGBOARDID(String strValue) {
        this.SetParamValue(TAG_DATAMSGBOARDID, strValue);
    }

    public String getDATAMSGBOARDNAME() {
        return this.GetParamStringValue(TAG_DATAMSGBOARDNAME, "");
    }

    public void setDATAMSGBOARDNAME(String strValue) {
        this.SetParamValue(TAG_DATAMSGBOARDNAME, strValue);
    }

    public boolean getENABLE() {
        return this.GetParamIntValue(TAG_ENABLE, 0) == 1;
    }

    public void setENABLE(boolean bValue) {
        this.SetParamValue(TAG_ENABLE, bValue ? 1 : 0);
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

    public String getDATAID() {
        return this.GetParamStringValue(TAG_DATAID, "");
    }

    public void setDATAID(String strValue) {
        this.SetParamValue(TAG_DATAID, strValue);
    }

    public String getMSG() {
        return this.GetParamStringValue(TAG_MSG, "");
    }

    public void setMSG(String strValue) {
        this.SetParamValue(TAG_MSG, strValue);
    }
}

