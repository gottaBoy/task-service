/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class DNMsgQueue
extends BaseDataEntity {
    public static final String TAG_DNMSGQUEUEID = "DNMSGQUEUEID";
    public static final String TAG_DNMSGQUEUENAME = "DNMSGQUEUENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MSGQUEUEID4 = "MSGQUEUEID4";
    public static final String TAG_MSGQUEUEID5 = "MSGQUEUEID5";
    public static final String TAG_DATANOTIFYID = "DATANOTIFYID";
    public static final String TAG_DATANOTIFYNAME = "DATANOTIFYNAME";
    public static final String TAG_MSGQUEUEID6 = "MSGQUEUEID6";
    public static final String TAG_MSGQUEUEID2 = "MSGQUEUEID2";
    public static final String TAG_MSGQUEUEID3 = "MSGQUEUEID3";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_DEDATA = "DEDATA";
    public static final String TAG_MSGQUEUEID = "MSGQUEUEID";
    public static final String TAG_MSGQUEUEID7 = "MSGQUEUEID7";
    public static final String TAG_MSGQUEUEID8 = "MSGQUEUEID8";

    public String getDNMSGQUEUEID() {
        return this.GetParamStringValue(TAG_DNMSGQUEUEID, "");
    }

    public void setDNMSGQUEUEID(String strValue) {
        this.SetParamValue(TAG_DNMSGQUEUEID, strValue);
    }

    public String getDNMSGQUEUENAME() {
        return this.GetParamStringValue(TAG_DNMSGQUEUENAME, "");
    }

    public void setDNMSGQUEUENAME(String strValue) {
        this.SetParamValue(TAG_DNMSGQUEUENAME, strValue);
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

    public String getMSGQUEUEID4() {
        return this.GetParamStringValue(TAG_MSGQUEUEID4, "");
    }

    public void setMSGQUEUEID4(String strValue) {
        this.SetParamValue(TAG_MSGQUEUEID4, strValue);
    }

    public String getMSGQUEUEID5() {
        return this.GetParamStringValue(TAG_MSGQUEUEID5, "");
    }

    public void setMSGQUEUEID5(String strValue) {
        this.SetParamValue(TAG_MSGQUEUEID5, strValue);
    }

    public String getDATANOTIFYID() {
        return this.GetParamStringValue(TAG_DATANOTIFYID, "");
    }

    public void setDATANOTIFYID(String strValue) {
        this.SetParamValue(TAG_DATANOTIFYID, strValue);
    }

    public String getDATANOTIFYNAME() {
        return this.GetParamStringValue(TAG_DATANOTIFYNAME, "");
    }

    public void setDATANOTIFYNAME(String strValue) {
        this.SetParamValue(TAG_DATANOTIFYNAME, strValue);
    }

    public String getMSGQUEUEID6() {
        return this.GetParamStringValue(TAG_MSGQUEUEID6, "");
    }

    public void setMSGQUEUEID6(String strValue) {
        this.SetParamValue(TAG_MSGQUEUEID6, strValue);
    }

    public String getMSGQUEUEID2() {
        return this.GetParamStringValue(TAG_MSGQUEUEID2, "");
    }

    public void setMSGQUEUEID2(String strValue) {
        this.SetParamValue(TAG_MSGQUEUEID2, strValue);
    }

    public String getMSGQUEUEID3() {
        return this.GetParamStringValue(TAG_MSGQUEUEID3, "");
    }

    public void setMSGQUEUEID3(String strValue) {
        this.SetParamValue(TAG_MSGQUEUEID3, strValue);
    }

    public String getDEID() {
        return this.GetParamStringValue(TAG_DEID, "");
    }

    public void setDEID(String strValue) {
        this.SetParamValue(TAG_DEID, strValue);
    }

    public String getDEDATA() {
        return this.GetParamStringValue(TAG_DEDATA, "");
    }

    public void setDEDATA(String strValue) {
        this.SetParamValue(TAG_DEDATA, strValue);
    }

    public String getMSGQUEUEID() {
        return this.GetParamStringValue(TAG_MSGQUEUEID, "");
    }

    public void setMSGQUEUEID(String strValue) {
        this.SetParamValue(TAG_MSGQUEUEID, strValue);
    }

    public String getMSGQUEUEID7() {
        return this.GetParamStringValue(TAG_MSGQUEUEID7, "");
    }

    public void setMSGQUEUEID7(String strValue) {
        this.SetParamValue(TAG_MSGQUEUEID7, strValue);
    }

    public String getMSGQUEUEID8() {
        return this.GetParamStringValue(TAG_MSGQUEUEID8, "");
    }

    public void setMSGQUEUEID8(String strValue) {
        this.SetParamValue(TAG_MSGQUEUEID8, strValue);
    }
}

