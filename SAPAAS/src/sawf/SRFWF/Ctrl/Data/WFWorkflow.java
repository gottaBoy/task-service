/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SRFWF.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import SRFWF.Model.WFConfig;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class WFWorkflow
extends BaseDataEntity {
    private static final Log log = LogFactory.getLog(WFWorkflow.class);
    public static final int WFSTATE_NORMAL = 1;
    public static final int WFSTATE_PAUSE = 2;
    public static final String TAG_WFWORKFLOWID = "WFWORKFLOWID";
    public static final String TAG_WFNAME = "WFNAME";
    public static final String TAG_WFWORKFLOWNAME = "WFWORKFLOWNAME";
    public static final String TAG_WFLOGICNAME = "WFLOGICNAME";
    public static final String TAG_WFSTATE = "WFSTATE";
    public static final String TAG_WFMODEL = "WFMODEL";
    public static final String TAG_WFVERSION = "WFVERSION";
    public static final String TAG_USERDATANAME = "USERDATANAME";
    public static final String TAG_USERDATACMD = "USERDATACMD";
    public static final String TAG_USERDATACMD2 = "USERDATACMD2";
    public static final String TAG_USERDATACMD3 = "USERDATACMD3";
    public static final String TAG_USERDATACMD4 = "USERDATACMD4";
    public static final String TAG_USERDATACMD5 = "USERDATACMD5";
    public static final String TAG_USERDATACMD6 = "USERDATACMD6";
    public static final String TAG_USERDATACMD7 = "USERDATACMD7";
    public static final String TAG_USERDATACMD8 = "USERDATACMD8";
    public static final String TAG_USERDATACMD9 = "USERDATACMD9";
    public static final String TAG_USERDATACMD10 = "USERDATACMD10";
    public static final String TAG_ENABLE = "ENABLE";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_RESERVER = "RESERVER";
    public static final String TAG_RESERVER2 = "RESERVER2";
    public static final String TAG_WFHELPER = "WFHELPER";
    public static final String TAG_WFHELPERPARAM = "WFHELPERPARAM";
    protected WFConfig wfConfig = null;

    public WFConfig getWFConfig() {
        if (this.wfConfig != null) {
            return this.wfConfig;
        }
        WFConfig tempConfig = new WFConfig();
        if (tempConfig.LoadFromXML(this.getWFMODEL())) {
            this.wfConfig = tempConfig;
        } else {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u89e3\u6790\u6d41\u7a0b\u6a21\u578b"));
        }
        return tempConfig;
    }

    public String getRESERVER2() {
        return this.GetParamStringValue(TAG_RESERVER2, "");
    }

    public String getRESERVER() {
        return this.GetParamStringValue(TAG_RESERVER, "");
    }

    public String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public String getUSERDATACMD10() {
        return this.GetParamStringValue(TAG_USERDATACMD10, "");
    }

    public String getUSERDATACMD9() {
        return this.GetParamStringValue(TAG_USERDATACMD9, "");
    }

    public String getUSERDATACMD8() {
        return this.GetParamStringValue(TAG_USERDATACMD8, "");
    }

    public String getUSERDATACMD7() {
        return this.GetParamStringValue(TAG_USERDATACMD7, "");
    }

    public String getUSERDATACMD6() {
        return this.GetParamStringValue(TAG_USERDATACMD6, "");
    }

    public String getRestartCmd() {
        return this.getUSERDATACMD6();
    }

    public String getUSERDATACMD5() {
        return this.GetParamStringValue(TAG_USERDATACMD5, "");
    }

    public String getUSERDATACMD4() {
        return this.GetParamStringValue(TAG_USERDATACMD4, "");
    }

    public String getUSERDATACMD3() {
        return this.GetParamStringValue(TAG_USERDATACMD3, "");
    }

    public String getUSERDATACMD2() {
        return this.GetParamStringValue(TAG_USERDATACMD2, "");
    }

    public String getUSERDATACMD() {
        return this.GetParamStringValue(TAG_USERDATACMD, "");
    }

    public String getUSERDATANAME() {
        return this.GetParamStringValue(TAG_USERDATANAME, "");
    }

    public String getWFMODEL() {
        return this.GetParamStringValue(TAG_WFMODEL, "");
    }

    public String getWFLOGICNAME() {
        return this.GetParamStringValue(TAG_WFLOGICNAME, "");
    }

    public String getWFNAME() {
        String strWFName = this.GetParamStringValue(TAG_WFNAME, "");
        if (StringHelper.IsNullOrEmpty((String)strWFName)) {
            return this.GetParamStringValue(TAG_WFWORKFLOWNAME, "");
        }
        return strWFName;
    }

    public String getWFWORKFLOWID() {
        return this.GetParamStringValue(TAG_WFWORKFLOWID, "");
    }

    public void setRESERVER2(String strValue) {
        this.SetParamValue(TAG_RESERVER2, strValue);
    }

    public void setRESERVER(String strValue) {
        this.SetParamValue(TAG_RESERVER, strValue);
    }

    public void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }

    public void setUSERDATACMD10(String strValue) {
        this.SetParamValue(TAG_USERDATACMD10, strValue);
    }

    public void setUSERDATACMD9(String strValue) {
        this.SetParamValue(TAG_USERDATACMD9, strValue);
    }

    public void setUSERDATACMD8(String strValue) {
        this.SetParamValue(TAG_USERDATACMD8, strValue);
    }

    public void setUSERDATACMD7(String strValue) {
        this.SetParamValue(TAG_USERDATACMD7, strValue);
    }

    public void setUSERDATACMD6(String strValue) {
        this.SetParamValue(TAG_USERDATACMD6, strValue);
    }

    public void setUSERDATACMD5(String strValue) {
        this.SetParamValue(TAG_USERDATACMD5, strValue);
    }

    public void setUSERDATACMD4(String strValue) {
        this.SetParamValue(TAG_USERDATACMD4, strValue);
    }

    public void setUSERDATACMD3(String strValue) {
        this.SetParamValue(TAG_USERDATACMD3, strValue);
    }

    public void setUSERDATACMD2(String strValue) {
        this.SetParamValue(TAG_USERDATACMD2, strValue);
    }

    public void setUSERDATACMD(String strValue) {
        this.SetParamValue(TAG_USERDATACMD, strValue);
    }

    public void setUSERDATANAME(String strValue) {
        this.SetParamValue(TAG_USERDATANAME, strValue);
    }

    public void setWFMODEL(String strValue) {
        this.SetParamValue(TAG_WFMODEL, strValue);
    }

    public void setWFLOGICNAME(String strValue) {
        this.SetParamValue(TAG_WFLOGICNAME, strValue);
    }

    public void setWFNAME(String strValue) {
        this.SetParamValue(TAG_WFNAME, strValue);
    }

    public void setWFWORKFLOWID(String strValue) {
        this.SetParamValue(TAG_WFWORKFLOWID, strValue);
    }

    public int getWFSTATE() {
        return this.GetParamIntValue(TAG_WFSTATE, 0);
    }

    public int getWFVERSION() {
        return this.GetParamIntValue(TAG_WFVERSION, 0);
    }

    public int getENABLE() {
        return this.GetParamIntValue(TAG_ENABLE, 0);
    }

    public void setWFSTATE(int nValue) {
        this.SetParamValue(TAG_WFSTATE, nValue);
    }

    public void setWFVERSION(int nValue) {
        this.SetParamValue(TAG_WFVERSION, nValue);
    }

    public void setENABLE(int nValue) {
        this.SetParamValue(TAG_ENABLE, nValue);
    }

    public final boolean isWFHELPERNull() {
        return this.IsParamNull(TAG_WFHELPER);
    }

    public final String getWFHELPER() {
        return this.GetParamStringValue(TAG_WFHELPER, "");
    }

    public final void setWFHELPER(String strValue) {
        this.SetParamValue(TAG_WFHELPER, strValue);
    }

    public final boolean isWFHELPERPARAMNull() {
        return this.IsParamNull(TAG_WFHELPERPARAM);
    }

    public final String getWFHELPERPARAM() {
        return this.GetParamStringValue(TAG_WFHELPERPARAM, "");
    }

    public final void setWFHELPERPARAM(String strValue) {
        this.SetParamValue(TAG_WFHELPERPARAM, strValue);
    }
}

