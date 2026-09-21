/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import java.util.Date;
import java.util.Properties;

public class DESubWF
extends BaseDataEntity {
    public static final String TAG_DESUBWFID = "DESUBWFID";
    public static final String TAG_DESUBWFNAME = "DESUBWFNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_WFID = "WFID";
    public static final String TAG_WFNAME = "WFNAME";
    public static final String TAG_RVDEFID = "RVDEFID";
    public static final String TAG_RVDEFNAME = "RVDEFNAME";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_WFSTEPDEFID = "WFSTEPDEFID";
    public static final String TAG_WFSTEPDEFNAME = "WFSTEPDEFNAME";
    public static final String TAG_DESUBWFSN = "DESUBWFSN";
    public static final String TAG_PARAMS = "PARAMS";
    public static final String TAG_EDITABLEWFSTEP = "EDITABLEWFSTEP";
    public static final String TAG_WFINSTDEFID = "WFINSTDEFID";
    public static final String TAG_WFINSTDEFNAME = "WFINSTDEFNAME";
    private Properties wfParams = null;

    public Properties getWFParams() {
        if (this.wfParams == null) {
            try {
                this.wfParams = PropertiesHelper.Load((String)this.getPARAMS());
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this.wfParams;
    }

    public String GetWFParam(String strPropertyName) {
        this.getWFParams();
        strPropertyName = strPropertyName.toUpperCase();
        String strDefaultValue = "";
        return PropertiesHelper.GetProperty((Properties)this.wfParams, (String)strPropertyName, (String)strDefaultValue);
    }

    public String GetWFParam(String strPropertyName, String strDefaultValue) {
        this.getWFParams();
        strPropertyName = strPropertyName.toUpperCase();
        return PropertiesHelper.GetProperty((Properties)this.wfParams, (String)strPropertyName, (String)strDefaultValue);
    }

    public boolean GetWFParam(String strPropertyName, boolean bDefaultValue) {
        String strValue = this.GetWFParam(strPropertyName);
        if (StringHelper.IsNullOrEmpty((String)strValue)) {
            return bDefaultValue;
        }
        return StringHelper.Compare((String)strValue, (String)"TRUE", (boolean)true) == 0;
    }

    public String getDESUBWFID() {
        return this.GetParamStringValue(TAG_DESUBWFID, "");
    }

    public void setDESUBWFID(String strValue) {
        this.SetParamValue(TAG_DESUBWFID, strValue);
    }

    public String getDESUBWFNAME() {
        return this.GetParamStringValue(TAG_DESUBWFNAME, "");
    }

    public void setDESUBWFNAME(String strValue) {
        this.SetParamValue(TAG_DESUBWFNAME, strValue);
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

    public String getDEID() {
        return this.GetParamStringValue(TAG_DEID, "");
    }

    public void setDEID(String strValue) {
        this.SetParamValue(TAG_DEID, strValue);
    }

    public String getDENAME() {
        return this.GetParamStringValue(TAG_DENAME, "");
    }

    public void setDENAME(String strValue) {
        this.SetParamValue(TAG_DENAME, strValue);
    }

    public String getWFID() {
        return this.GetParamStringValue(TAG_WFID, "");
    }

    public void setWFID(String strValue) {
        this.SetParamValue(TAG_WFID, strValue);
    }

    public String getWFNAME() {
        return this.GetParamStringValue(TAG_WFNAME, "");
    }

    public void setWFNAME(String strValue) {
        this.SetParamValue(TAG_WFNAME, strValue);
    }

    public String getRVDEFID() {
        return this.GetParamStringValue(TAG_RVDEFID, "");
    }

    public void setRVDEFID(String strValue) {
        this.SetParamValue(TAG_RVDEFID, strValue);
    }

    public String getRVDEFNAME() {
        return this.GetParamStringValue(TAG_RVDEFNAME, "");
    }

    public void setRVDEFNAME(String strValue) {
        this.SetParamValue(TAG_RVDEFNAME, strValue);
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }

    public String getWFSTEPDEFID() {
        return this.GetParamStringValue(TAG_WFSTEPDEFID, "");
    }

    public void setWFSTEPDEFID(String strValue) {
        this.SetParamValue(TAG_WFSTEPDEFID, strValue);
    }

    public String getWFSTEPDEFNAME() {
        return this.GetParamStringValue(TAG_WFSTEPDEFNAME, "");
    }

    public void setWFSTEPDEFNAME(String strValue) {
        this.SetParamValue(TAG_WFSTEPDEFNAME, strValue);
    }

    public String getDESUBWFSN() {
        return this.GetParamStringValue(TAG_DESUBWFSN, "");
    }

    public void setDESUBWFSN(String strValue) {
        this.SetParamValue(TAG_DESUBWFSN, strValue);
    }

    public String getPARAMS() {
        return this.GetParamStringValue(TAG_PARAMS, "");
    }

    public void setPARAMS(String strValue) {
        this.SetParamValue(TAG_PARAMS, strValue);
    }

    public String getEDITABLEWFSTEP() {
        return this.GetParamStringValue(TAG_EDITABLEWFSTEP, "");
    }

    public void setEDITABLEWFSTEP(String strValue) {
        this.SetParamValue(TAG_EDITABLEWFSTEP, strValue);
    }

    public String getWFINSTDEFID() {
        return this.GetParamStringValue(TAG_WFINSTDEFID, "");
    }

    public void setWFINSTDEFID(String strValue) {
        this.SetParamValue(TAG_WFINSTDEFID, strValue);
    }

    public String getWFINSTDEFNAME() {
        return this.GetParamStringValue(TAG_WFINSTDEFNAME, "");
    }

    public void setWFINSTDEFNAME(String strValue) {
        this.SetParamValue(TAG_WFINSTDEFNAME, strValue);
    }
}

