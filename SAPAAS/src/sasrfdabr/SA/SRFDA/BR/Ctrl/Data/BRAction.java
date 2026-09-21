/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCConfig
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.BR.Ctrl.Data;

import SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCConfig;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import java.util.Date;

public class BRAction
extends BaseDataEntity {
    public static final String TAG_BRACTIONID = "BRACTIONID";
    public static final String TAG_BRACTIONNAME = "BRACTIONNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_BRENGINEID = "BRENGINEID";
    public static final String TAG_BRENGINENAME = "BRENGINENAME";
    public static final String TAG_ACTIONMODEL = "ACTIONMODEL";
    public static final String TAG_DEBUGOUTPUT = "DEBUGOUTPUT";
    protected DEDCConfig dedcConfig = null;

    public DEDCConfig getDEDCConfig() {
        if (this.dedcConfig == null) {
            this.dedcConfig = new DEDCConfig();
            if (!StringHelper.IsNullOrEmpty((String)this.getACTIONMODEL())) {
                this.dedcConfig.LoadFromXML(this.getACTIONMODEL());
            }
        }
        return this.dedcConfig;
    }

    public String getBRACTIONID() {
        return this.GetParamStringValue(TAG_BRACTIONID, "");
    }

    public void setBRACTIONID(String strValue) {
        this.SetParamValue(TAG_BRACTIONID, strValue);
    }

    public String getBRACTIONNAME() {
        return this.GetParamStringValue(TAG_BRACTIONNAME, "");
    }

    public void setBRACTIONNAME(String strValue) {
        this.SetParamValue(TAG_BRACTIONNAME, strValue);
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

    public String getBRENGINEID() {
        return this.GetParamStringValue(TAG_BRENGINEID, "");
    }

    public void setBRENGINEID(String strValue) {
        this.SetParamValue(TAG_BRENGINEID, strValue);
    }

    public String getBRENGINENAME() {
        return this.GetParamStringValue(TAG_BRENGINENAME, "");
    }

    public void setBRENGINENAME(String strValue) {
        this.SetParamValue(TAG_BRENGINENAME, strValue);
    }

    public String getACTIONMODEL() {
        return this.GetParamStringValue(TAG_ACTIONMODEL, "");
    }

    public void setACTIONMODEL(String strValue) {
        this.SetParamValue(TAG_ACTIONMODEL, strValue);
    }

    public boolean getDEBUGOUTPUT() {
        return this.GetParamIntValue(TAG_DEBUGOUTPUT, 0) == 1;
    }

    public void setDEBUGOUTPUT(boolean bValue) {
        this.SetParamValue(TAG_DEBUGOUTPUT, bValue ? 1 : 0);
    }
}

