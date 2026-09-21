/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class DERCUSTOM
extends BaseDataEntity {
    public static final String TAG_CUSTOMDERID = "CUSTOMDERID";
    public static final String TAG_CUSTOMDERNAME = "CUSTOMDERNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MAJORDEID = "MAJORDEID";
    public static final String TAG_MAJORDENAME = "MAJORDENAME";
    public static final String TAG_MINORDEID = "MINORDEID";
    public static final String TAG_MINORDENAME = "MINORDENAME";
    public static final String TAG_JOINCOND = "JOINCOND";

    public String getCUSTOMDERID() {
        return this.GetParamStringValue(TAG_CUSTOMDERID, "");
    }

    public void setCUSTOMDERID(String strValue) {
        this.SetParamValue(TAG_CUSTOMDERID, strValue);
    }

    public String getCUSTOMDERNAME() {
        return this.GetParamStringValue(TAG_CUSTOMDERNAME, "");
    }

    public void setCUSTOMDERNAME(String strValue) {
        this.SetParamValue(TAG_CUSTOMDERNAME, strValue);
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

    public String getMAJORDEID() {
        return this.GetParamStringValue(TAG_MAJORDEID, "");
    }

    public void setMAJORDEID(String strValue) {
        this.SetParamValue(TAG_MAJORDEID, strValue);
    }

    public String getMAJORDENAME() {
        return this.GetParamStringValue(TAG_MAJORDENAME, "");
    }

    public void setMAJORDENAME(String strValue) {
        this.SetParamValue(TAG_MAJORDENAME, strValue);
    }

    public String getMINORDEID() {
        return this.GetParamStringValue(TAG_MINORDEID, "");
    }

    public void setMINORDEID(String strValue) {
        this.SetParamValue(TAG_MINORDEID, strValue);
    }

    public String getMINORDENAME() {
        return this.GetParamStringValue(TAG_MINORDENAME, "");
    }

    public void setMINORDENAME(String strValue) {
        this.SetParamValue(TAG_MINORDENAME, strValue);
    }

    public String getJOINCOND() {
        return this.GetParamStringValue(TAG_JOINCOND, "");
    }

    public void setJOINCOND(String strValue) {
        this.SetParamValue(TAG_JOINCOND, strValue);
    }
}

