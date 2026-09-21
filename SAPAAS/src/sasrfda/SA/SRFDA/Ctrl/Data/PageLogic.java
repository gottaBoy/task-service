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

public class PageLogic
extends BaseDataEntity {
    public static final String LOGICTYPE_AFTERINITPAGEPARAM = "AFTERINITPAGEPARAM";
    public static final String TAG_PAGELOGICID = "PAGELOGICID";
    public static final String TAG_PAGELOGICNAME = "PAGELOGICNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PAGEID = "PAGEID";
    public static final String TAG_PAGENAME = "PAGENAME";
    public static final String TAG_LOGICTYPE = "LOGICTYPE";
    public static final String TAG_PROCESSMODEL = "PROCESSMODEL";
    public static final String TAG_DEBUGOUTPUT = "DEBUGOUTPUT";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_VERSION = "VERSION";
    DEDCConfig dedcConfig = null;

    public DEDCConfig getDEDCConfig() {
        if (this.dedcConfig == null) {
            this.dedcConfig = new DEDCConfig();
            if (!StringHelper.IsNullOrEmpty((String)this.getPROCESSMODEL())) {
                this.dedcConfig.LoadFromXML(this.getPROCESSMODEL());
            }
        }
        return this.dedcConfig;
    }

    public String getPAGELOGICID() {
        return this.GetParamStringValue(TAG_PAGELOGICID, "");
    }

    public void setPAGELOGICID(String strValue) {
        this.SetParamValue(TAG_PAGELOGICID, strValue);
    }

    public String getPAGELOGICNAME() {
        return this.GetParamStringValue(TAG_PAGELOGICNAME, "");
    }

    public void setPAGELOGICNAME(String strValue) {
        this.SetParamValue(TAG_PAGELOGICNAME, strValue);
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

    public String getPAGEID() {
        return this.GetParamStringValue(TAG_PAGEID, "");
    }

    public void setPAGEID(String strValue) {
        this.SetParamValue(TAG_PAGEID, strValue);
    }

    public String getPAGENAME() {
        return this.GetParamStringValue(TAG_PAGENAME, "");
    }

    public void setPAGENAME(String strValue) {
        this.SetParamValue(TAG_PAGENAME, strValue);
    }

    public String getLOGICTYPE() {
        return this.GetParamStringValue(TAG_LOGICTYPE, "");
    }

    public void setLOGICTYPE(String strValue) {
        this.SetParamValue(TAG_LOGICTYPE, strValue);
    }

    public String getPROCESSMODEL() {
        return this.GetParamStringValue(TAG_PROCESSMODEL, "");
    }

    public void setPROCESSMODEL(String strValue) {
        this.SetParamValue(TAG_PROCESSMODEL, strValue);
    }

    public boolean getDEBUGOUTPUT() {
        return this.GetParamIntValue(TAG_DEBUGOUTPUT, 0) == 1;
    }

    public void setDEBUGOUTPUT(boolean bValue) {
        this.SetParamValue(TAG_DEBUGOUTPUT, bValue ? 1 : 0);
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }

    public int getVERSION() {
        return this.GetParamIntValue(TAG_VERSION, 0);
    }

    public void setVERSION(int strValue) {
        this.SetParamValue(TAG_VERSION, strValue);
    }
}

