/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class DataSyncIn2
extends BaseDataEntity {
    public static final String TAG_DATASYNCIN2ID = "DATASYNCIN2ID";
    public static final String TAG_DATASYNCIN2NAME = "DATASYNCIN2NAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_EVENTTYPE = "EVENTTYPE";
    public static final String TAG_DATA = "DATA";
    public static final String TAG_DATAKEY = "DATAKEY";
    public static final String TAG_ERROR = "ERROR";
    public static final String TAG_SYNCAGENT = "SYNCAGENT";
    public static final String TAG_LOGICDATA = "LOGICDATA";
    public static final String TAG_FILEFLAG = "FILEFLAG";

    public boolean isDATASYNCIN2IDNull() {
        return this.IsParamNull(TAG_DATASYNCIN2ID);
    }

    public String getDATASYNCIN2ID() {
        return this.GetParamStringValue(TAG_DATASYNCIN2ID, "");
    }

    public void setDATASYNCIN2ID(String strValue) {
        this.SetParamValue(TAG_DATASYNCIN2ID, strValue);
    }

    public boolean isDATASYNCIN2NAMENull() {
        return this.IsParamNull(TAG_DATASYNCIN2NAME);
    }

    public String getDATASYNCIN2NAME() {
        return this.GetParamStringValue(TAG_DATASYNCIN2NAME, "");
    }

    public void setDATASYNCIN2NAME(String strValue) {
        this.SetParamValue(TAG_DATASYNCIN2NAME, strValue);
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

    public boolean isDEIDNull() {
        return this.IsParamNull(TAG_DEID);
    }

    public String getDEID() {
        return this.GetParamStringValue(TAG_DEID, "");
    }

    public void setDEID(String strValue) {
        this.SetParamValue(TAG_DEID, strValue);
    }

    public boolean isDENAMENull() {
        return this.IsParamNull(TAG_DENAME);
    }

    public String getDENAME() {
        return this.GetParamStringValue(TAG_DENAME, "");
    }

    public void setDENAME(String strValue) {
        this.SetParamValue(TAG_DENAME, strValue);
    }

    public boolean isEVENTTYPENull() {
        return this.IsParamNull(TAG_EVENTTYPE);
    }

    public int getEVENTTYPE() {
        return this.GetParamIntValue(TAG_EVENTTYPE, 0);
    }

    public void setEVENTTYPE(int nValue) {
        this.SetParamValue(TAG_EVENTTYPE, nValue);
    }

    public boolean isDATANull() {
        return this.IsParamNull(TAG_DATA);
    }

    public String getDATA() {
        return this.GetParamStringValue(TAG_DATA, "");
    }

    public void setDATA(String strValue) {
        this.SetParamValue(TAG_DATA, strValue);
    }

    public boolean isDATAKEYNull() {
        return this.IsParamNull(TAG_DATAKEY);
    }

    public String getDATAKEY() {
        return this.GetParamStringValue(TAG_DATAKEY, "");
    }

    public void setDATAKEY(String strValue) {
        this.SetParamValue(TAG_DATAKEY, strValue);
    }

    public boolean isERRORNull() {
        return this.IsParamNull(TAG_ERROR);
    }

    public String getERROR() {
        return this.GetParamStringValue(TAG_ERROR, "");
    }

    public void setERROR(String strValue) {
        this.SetParamValue(TAG_ERROR, strValue);
    }

    public boolean isSYNCAGENTNull() {
        return this.IsParamNull(TAG_SYNCAGENT);
    }

    public String getSYNCAGENT() {
        return this.GetParamStringValue(TAG_SYNCAGENT, "");
    }

    public void setSYNCAGENT(String strValue) {
        this.SetParamValue(TAG_SYNCAGENT, strValue);
    }

    public boolean isLOGICDATANull() {
        return this.IsParamNull(TAG_LOGICDATA);
    }

    public String getLOGICDATA() {
        return this.GetParamStringValue(TAG_LOGICDATA, "");
    }

    public void setLOGICDATA(String strValue) {
        this.SetParamValue(TAG_LOGICDATA, strValue);
    }

    public boolean isFILEFLAGNull() {
        return this.IsParamNull(TAG_FILEFLAG);
    }

    public boolean getFILEFLAG() {
        return this.GetParamIntValue(TAG_FILEFLAG, 0) == 1;
    }

    public void setFILEFLAG(boolean bValue) {
        this.SetParamValue(TAG_FILEFLAG, bValue ? 1 : 0);
    }
}

