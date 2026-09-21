/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class UIGear
extends BaseDataEntity {
    public static final String TAG_UIGEARID = "UIGEARID";
    public static final String TAG_UIGEARNAME = "UIGEARNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_UIGEARTYPE = "UIGEARTYPE";
    public static final String TAG_UIGEAROBJECT = "UIGEAROBJECT";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";

    public String getUIGEARID() {
        return this.GetParamStringValue(TAG_UIGEARID, "");
    }

    public void setUIGEARID(String strValue) {
        this.SetParamValue(TAG_UIGEARID, strValue);
    }

    public String getUIGEARNAME() {
        return this.GetParamStringValue(TAG_UIGEARNAME, "");
    }

    public void setUIGEARNAME(String strValue) {
        this.SetParamValue(TAG_UIGEARNAME, strValue);
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

    public String getUIGEARTYPE() {
        return this.GetParamStringValue(TAG_UIGEARTYPE, "");
    }

    public void setUIGEARTYPE(String strValue) {
        this.SetParamValue(TAG_UIGEARTYPE, strValue);
    }

    public String getUIGEAROBJECT() {
        return this.GetParamStringValue(TAG_UIGEAROBJECT, "");
    }

    public void setUIGEAROBJECT(String strValue) {
        this.SetParamValue(TAG_UIGEAROBJECT, strValue);
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }
}

