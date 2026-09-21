/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class GSR2Dimension2
extends BaseDataEntity {
    public static final String TAG_GSR2DIMENSION2ID = "GSR2DIMENSION2ID";
    public static final String TAG_GSR2DIMENSION2NAME = "GSR2DIMENSION2NAME";
    public static final String TAG_ENABLE = "ENABLE";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_GSR2ID = "GSR2ID";
    public static final String TAG_GSR2NAME = "GSR2NAME";
    public static final String TAG_DEFID = "DEFID";
    public static final String TAG_DEFNAME = "DEFNAME";
    public static final String TAG_ORDERFLAG = "ORDERFLAG";
    public static final String TAG_WIDTH = "WIDTH";

    public String getGSR2DIMENSION2ID() {
        return this.GetParamStringValue(TAG_GSR2DIMENSION2ID, "");
    }

    public void setGSR2DIMENSION2ID(String strValue) {
        this.SetParamValue(TAG_GSR2DIMENSION2ID, strValue);
    }

    public String getGSR2DIMENSION2NAME() {
        return this.GetParamStringValue(TAG_GSR2DIMENSION2NAME, "");
    }

    public void setGSR2DIMENSION2NAME(String strValue) {
        this.SetParamValue(TAG_GSR2DIMENSION2NAME, strValue);
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

    public String getGSR2ID() {
        return this.GetParamStringValue(TAG_GSR2ID, "");
    }

    public void setGSR2ID(String strValue) {
        this.SetParamValue(TAG_GSR2ID, strValue);
    }

    public String getGSR2NAME() {
        return this.GetParamStringValue(TAG_GSR2NAME, "");
    }

    public void setGSR2NAME(String strValue) {
        this.SetParamValue(TAG_GSR2NAME, strValue);
    }

    public String getDEFID() {
        return this.GetParamStringValue(TAG_DEFID, "");
    }

    public void setDEFID(String strValue) {
        this.SetParamValue(TAG_DEFID, strValue);
    }

    public String getDEFNAME() {
        return this.GetParamStringValue(TAG_DEFNAME, "");
    }

    public void setDEFNAME(String strValue) {
        this.SetParamValue(TAG_DEFNAME, strValue);
    }

    public int getORDERFLAG() {
        return this.GetParamIntValue(TAG_ORDERFLAG, 0);
    }

    public void setORDERFLAG(int strValue) {
        this.SetParamValue(TAG_ORDERFLAG, strValue);
    }

    public int getWIDTH() {
        return this.GetParamIntValue(TAG_WIDTH, 100);
    }

    public void setWIDTH(int strValue) {
        this.SetParamValue(TAG_WIDTH, strValue);
    }
}

