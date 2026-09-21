/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class GSR2TD
extends BaseDataEntity {
    public static final String TAG_GSR2TDID = "GSR2TDID";
    public static final String TAG_GSR2TDNAME = "GSR2TDNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_ORDERFLAG = "ORDERFLAG";
    public static final String TAG_ITEMFORMAT = "ITEMFORMAT";
    public static final String TAG_TSSDPOLICYID = "TSSDPOLICYID";
    public static final String TAG_TSSDPOLICYNAME = "TSSDPOLICYNAME";

    public String getGSR2TDID() {
        return this.GetParamStringValue(TAG_GSR2TDID, "");
    }

    public void setGSR2TDID(String strValue) {
        this.SetParamValue(TAG_GSR2TDID, strValue);
    }

    public String getGSR2TDNAME() {
        return this.GetParamStringValue(TAG_GSR2TDNAME, "");
    }

    public void setGSR2TDNAME(String strValue) {
        this.SetParamValue(TAG_GSR2TDNAME, strValue);
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

    public int getORDERFLAG() {
        return this.GetParamIntValue(TAG_ORDERFLAG, 0);
    }

    public void setORDERFLAG(int strValue) {
        this.SetParamValue(TAG_ORDERFLAG, strValue);
    }

    public String getITEMFORMAT() {
        return this.GetParamStringValue(TAG_ITEMFORMAT, "");
    }

    public void setITEMFORMAT(String strValue) {
        this.SetParamValue(TAG_ITEMFORMAT, strValue);
    }

    public String getTSSDPOLICYID() {
        return this.GetParamStringValue(TAG_TSSDPOLICYID, "");
    }

    public void setTSSDPOLICYID(String strValue) {
        this.SetParamValue(TAG_TSSDPOLICYID, strValue);
    }

    public String getTSSDPOLICYNAME() {
        return this.GetParamStringValue(TAG_TSSDPOLICYNAME, "");
    }

    public void setTSSDPOLICYNAME(String strValue) {
        this.SetParamValue(TAG_TSSDPOLICYNAME, strValue);
    }
}

