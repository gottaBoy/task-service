/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 */
package SA.SRFDA.TS.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import java.util.Date;
import java.util.Properties;

public class TSSDEngine
extends BaseDataEntity {
    public static final String TAG_TSSDENGINEID = "TSSDENGINEID";
    public static final String TAG_TSSDENGINENAME = "TSSDENGINENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_ENGINEPARAM = "ENGINEPARAM";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_ENGINEOBJECT = "ENGINEOBJECT";
    protected Properties engineParam = null;

    public synchronized Properties getEngineParam() {
        if (this.engineParam != null) {
            return this.engineParam;
        }
        try {
            this.engineParam = PropertiesHelper.Load((String)this.getENGINEPARAM());
            return this.engineParam;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getTSSDENGINEID() {
        return this.GetParamStringValue(TAG_TSSDENGINEID, "");
    }

    public void setTSSDENGINEID(String strValue) {
        this.SetParamValue(TAG_TSSDENGINEID, strValue);
    }

    public String getTSSDENGINENAME() {
        return this.GetParamStringValue(TAG_TSSDENGINENAME, "");
    }

    public void setTSSDENGINENAME(String strValue) {
        this.SetParamValue(TAG_TSSDENGINENAME, strValue);
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

    public String getENGINEPARAM() {
        return this.GetParamStringValue(TAG_ENGINEPARAM, "");
    }

    public void setENGINEPARAM(String strValue) {
        this.SetParamValue(TAG_ENGINEPARAM, strValue);
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }

    public String getENGINEOBJECT() {
        return this.GetParamStringValue(TAG_ENGINEOBJECT, "");
    }

    public void setENGINEOBJECT(String strValue) {
        this.SetParamValue(TAG_ENGINEOBJECT, strValue);
    }
}

