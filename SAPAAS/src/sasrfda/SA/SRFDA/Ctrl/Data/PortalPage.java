/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PortalPage
extends BaseDataEntity {
    public static final String TAG_PORTALPAGEID = "PORTALPAGEID";
    public static final String TAG_PORTALPAGENAME = "PORTALPAGENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PORTALPAGEMEMO = "PORTALPAGEMEMO";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_ENABLECTX = "ENABLECTX";

    public String getPORTALPAGEID() {
        return this.GetParamStringValue(TAG_PORTALPAGEID, "");
    }

    public void setPORTALPAGEID(String strValue) {
        this.SetParamValue(TAG_PORTALPAGEID, strValue);
    }

    public String getPORTALPAGENAME() {
        return this.GetParamStringValue(TAG_PORTALPAGENAME, "");
    }

    public void setPORTALPAGENAME(String strValue) {
        this.SetParamValue(TAG_PORTALPAGENAME, strValue);
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

    public String getPORTALPAGEMEMO() {
        return this.GetParamStringValue(TAG_PORTALPAGEMEMO, "");
    }

    public void setPORTALPAGEMEMO(String strValue) {
        this.SetParamValue(TAG_PORTALPAGEMEMO, strValue);
    }

    public boolean isDESCRIPTIONNull() {
        return this.IsParamNull(TAG_DESCRIPTION);
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }

    public boolean isENABLECTXNull() {
        return this.IsParamNull(TAG_ENABLECTX);
    }

    public boolean getENABLECTX() {
        return this.GetParamIntValue(TAG_ENABLECTX, 0) == 1;
    }

    public void setENABLECTX(boolean bValue) {
        this.SetParamValue(TAG_ENABLECTX, bValue ? 1 : 0);
    }
}

