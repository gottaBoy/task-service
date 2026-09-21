/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCConfig;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import java.util.Date;

public class DEDataCtrl
extends BaseDataEntity {
    public static final String DCSTEP_GETDEFAULT = "GETDEFAULT";
    public static final String DCSTEP_TESTSAVE = "TESTSAVE";
    public static final String DCSTEP_BEFORESAVE = "BEFORESAVE";
    public static final String DCSTEP_AFTERSAVE = "AFTERSAVE";
    public static final String DCSTEP_BEFOREREMOVE = "BEFOREREMOVE";
    public static final String DCSTEP_AFTERREMOVE = "AFTERREMOVE";
    public static final String DCSTEP_CUSTOMCALL = "CUSTOMCALL";
    public static final String DCSTEP_INTERNALCALL = "INTERNALCALL";
    public static final String TAG_DEDATACTRLID = "DEDATACTRLID";
    public static final String TAG_DEDATACTRLNAME = "DEDATACTRLNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DCSTEP = "DCSTEP";
    public static final String TAG_ACTIONMODE = "ACTIONMODE";
    public static final String TAG_PROCESSMODEL = "PROCESSMODEL";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_DEBUGOUTPUT = "DEBUGOUTPUT";
    public static final String TAG_DEDCOBJECT = "DEDCOBJECT";
    public static final String TAG_DEDCCODE = "DEDCCODE";
    protected DEDCConfig dedcConfig = null;

    public String getDEDATACTRLID() {
        return this.GetParamStringValue(TAG_DEDATACTRLID, "");
    }

    public void setDEDATACTRLID(String strValue) {
        this.SetParamValue(TAG_DEDATACTRLID, strValue);
    }

    public String getDEDATACTRLNAME() {
        return this.GetParamStringValue(TAG_DEDATACTRLNAME, "");
    }

    public void setDEDATACTRLNAME(String strValue) {
        this.SetParamValue(TAG_DEDATACTRLNAME, strValue);
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

    public String getDCSTEP() {
        return this.GetParamStringValue(TAG_DCSTEP, "");
    }

    public void setDCSTEP(String strValue) {
        this.SetParamValue(TAG_DCSTEP, strValue);
    }

    public String getACTIONMODE() {
        return this.GetParamStringValue(TAG_ACTIONMODE, "DEFAULT");
    }

    public void setACTIONMODE(String strValue) {
        this.SetParamValue(TAG_ACTIONMODE, strValue);
    }

    public String getPROCESSMODEL() {
        return this.GetParamStringValue(TAG_PROCESSMODEL, "");
    }

    public void setPROCESSMODEL(String strValue) {
        this.SetParamValue(TAG_PROCESSMODEL, strValue);
    }

    public String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public String getDENAME() {
        return this.GetParamStringValue(TAG_DENAME, "");
    }

    public void setDENAME(String strValue) {
        this.SetParamValue(TAG_DENAME, strValue);
    }

    public String getDEID() {
        return this.GetParamStringValue(TAG_DEID, "");
    }

    public void setDEID(String strValue) {
        this.SetParamValue(TAG_DEID, strValue);
    }

    public boolean getDEBUGOUTPUT() {
        return this.GetParamIntValue(TAG_DEBUGOUTPUT, 0) == 1;
    }

    public void setDEBUGOUTPUT(boolean bValue) {
        this.SetParamValue(TAG_DEBUGOUTPUT, bValue ? 1 : 0);
    }

    public String getDEDCOBJECT() {
        return this.GetParamStringValue(TAG_DEDCOBJECT, "");
    }

    public void setDEDCOBJECT(String strValue) {
        this.SetParamValue(TAG_DEDCOBJECT, strValue);
    }

    public String getDEDCCODE() {
        return this.GetParamStringValue(TAG_DEDCCODE, "");
    }

    public void setDEDCCODE(String strValue) {
        this.SetParamValue(TAG_DEDCCODE, strValue);
    }

    public DEDCConfig getDEDCConfig() {
        if (this.dedcConfig == null) {
            this.dedcConfig = new DEDCConfig();
            if (!StringHelper.IsNullOrEmpty((String)this.getPROCESSMODEL())) {
                this.dedcConfig.LoadFromXML(this.getPROCESSMODEL());
            }
        }
        return this.dedcConfig;
    }
}

