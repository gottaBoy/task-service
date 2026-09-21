/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class DataAuditDetail
extends BaseDataEntity {
    public static final String TAG_DATAAUDITDETAILID = "DATAAUDITDETAILID";
    public static final String TAG_DATAAUDITDETAILNAME = "DATAAUDITDETAILNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DATAAUDITID = "DATAAUDITID";
    public static final String TAG_DATAAUDITNAME = "DATAAUDITNAME";
    public static final String TAG_OLDVALUE = "OLDVALUE";
    public static final String TAG_NEWVALUE = "NEWVALUE";
    public static final String TAG_OLDTEXT = "OLDTEXT";
    public static final String TAG_NEWTEXT = "NEWTEXT";

    public String getDATAAUDITDETAILID() {
        return this.GetParamStringValue(TAG_DATAAUDITDETAILID, "");
    }

    public void setDATAAUDITDETAILID(String strValue) {
        this.SetParamValue(TAG_DATAAUDITDETAILID, strValue);
    }

    public String getDATAAUDITDETAILNAME() {
        return this.GetParamStringValue(TAG_DATAAUDITDETAILNAME, "");
    }

    public void setDATAAUDITDETAILNAME(String strValue) {
        this.SetParamValue(TAG_DATAAUDITDETAILNAME, strValue);
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

    public String getDATAAUDITID() {
        return this.GetParamStringValue(TAG_DATAAUDITID, "");
    }

    public void setDATAAUDITID(String strValue) {
        this.SetParamValue(TAG_DATAAUDITID, strValue);
    }

    public String getDATAAUDITNAME() {
        return this.GetParamStringValue(TAG_DATAAUDITNAME, "");
    }

    public void setDATAAUDITNAME(String strValue) {
        this.SetParamValue(TAG_DATAAUDITNAME, strValue);
    }

    public String getOLDVALUE() {
        return this.GetParamStringValue(TAG_OLDVALUE, "");
    }

    public void setOLDVALUE(String strValue) {
        this.SetParamValue(TAG_OLDVALUE, strValue);
    }

    public String getNEWVALUE() {
        return this.GetParamStringValue(TAG_NEWVALUE, "");
    }

    public void setNEWVALUE(String strValue) {
        this.SetParamValue(TAG_NEWVALUE, strValue);
    }

    public String getOLDTEXT() {
        return this.GetParamStringValue(TAG_OLDTEXT, "");
    }

    public void setOLDTEXT(String strValue) {
        this.SetParamValue(TAG_OLDTEXT, strValue);
    }

    public String getNEWTEXT() {
        return this.GetParamStringValue(TAG_NEWTEXT, "");
    }

    public void setNEWTEXT(String strValue) {
        this.SetParamValue(TAG_NEWTEXT, strValue);
    }
}

