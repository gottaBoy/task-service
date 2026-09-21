/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.BI.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class BICatalog
extends BaseDataEntity {
    public static final String TAG_BICATALOGID = "BICATALOGID";
    public static final String TAG_BICATALOGNAME = "BICATALOGNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_VERSION = "VERSION";
    public static final String TAG_ISVALID = "ISVALID";

    public String getBICATALOGID() {
        return this.GetParamStringValue(TAG_BICATALOGID, "");
    }

    public void setBICATALOGID(String strValue) {
        this.SetParamValue(TAG_BICATALOGID, strValue);
    }

    public String getBICATALOGNAME() {
        return this.GetParamStringValue(TAG_BICATALOGNAME, "");
    }

    public void setBICATALOGNAME(String strValue) {
        this.SetParamValue(TAG_BICATALOGNAME, strValue);
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

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }

    public final boolean isVERSIONNull() {
        return this.IsParamNull(TAG_VERSION);
    }

    public final int getVERSION() {
        return this.GetParamIntValue(TAG_VERSION, 0);
    }

    public final void setVERSION(int nValue) {
        this.SetParamValue(TAG_VERSION, nValue);
    }

    public final boolean isISVALIDNull() {
        return this.IsParamNull(TAG_ISVALID);
    }

    public final boolean getISVALID() {
        return this.GetParamIntValue(TAG_ISVALID, 0) == 1;
    }

    public final void setISVALID(boolean bValue) {
        this.SetParamValue(TAG_ISVALID, bValue ? 1 : 0);
    }
}

