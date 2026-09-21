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

public class DEAction
extends BaseDataEntity {
    public static final String ACTIONTYPE_INSERT = "INSERT";
    public static final String ACTIONTYPE_UPDATE = "UPDATE";
    public static final String ACTIONTYPE_SAVE = "SAVE";
    public static final String ACTIONTYPE_DELETE = "DELETE";
    public static final String ACTIONTYPE_CUSTOMCALL = "CUSTOMCALL";
    public static final String ACTIONTYPE_CUSTOMPROCCALL = "CUSTOMPROCCALL";
    public static final String ACTIONTYPE_CUSTOMRAWPROCCALL = "CUSTOMRAWPROCCALL";
    public static final String ACTIONTYPE_GET = "GET";
    public static final String ACTIONTYPE_CHECKKEYSTATE = "CHECKKEYSTATE";
    public static final String TESTDATACTION_DEFAULT = "DEFAULT";
    public static final String TESTDATACTION_NONE = "NONE";
    public static final String TESTDATACTION_CUSTOM = "CUSTOM";
    public static final String TAG_DEACTIONID = "DEACTIONID";
    public static final String TAG_DEACTIONNAME = "DEACTIONNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_ACTIONTYPE = "ACTIONTYPE";
    public static final String TAG_ACTIONMODE = "ACTIONMODE";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_ACTIONCODE = "ACTIONCODE";
    public static final String TAG_DEDATAACTION = "DEDATAACTION";
    public static final String TAG_ACTIONPARAM = "ACTIONPARAM";
    public static final String TAG_CUSTOMDATAACTION = "CUSTOMDATAACTION";
    public static final String TAG_TESTDATAACTION = "TESTDATAACTION";
    private Properties actionParams = null;
    private boolean bBuildActionParams = false;

    public String getDEACTIONID() {
        return this.GetParamStringValue(TAG_DEACTIONID, "");
    }

    public void setDEACTIONID(String strValue) {
        this.SetParamValue(TAG_DEACTIONID, strValue);
    }

    public String getDEACTIONNAME() {
        return this.GetParamStringValue(TAG_DEACTIONNAME, "");
    }

    public void setDEACTIONNAME(String strValue) {
        this.SetParamValue(TAG_DEACTIONNAME, strValue);
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

    public String getACTIONTYPE() {
        return this.GetParamStringValue(TAG_ACTIONTYPE, "");
    }

    public void setACTIONTYPE(String strValue) {
        this.SetParamValue(TAG_ACTIONTYPE, strValue);
    }

    public String getACTIONMODE() {
        return this.GetParamStringValue(TAG_ACTIONMODE, "");
    }

    public void setACTIONMODE(String strValue) {
        this.SetParamValue(TAG_ACTIONMODE, strValue);
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }

    public String getACTIONCODE() {
        return this.GetParamStringValue(TAG_ACTIONCODE, "");
    }

    public void setACTIONCODE(String strValue) {
        this.SetParamValue(TAG_ACTIONCODE, strValue);
    }

    public String getDEDATAACTION() {
        return this.GetParamStringValue(TAG_DEDATAACTION, "");
    }

    public void setDEDATAACTION(String strValue) {
        this.SetParamValue(TAG_DEDATAACTION, strValue);
    }

    public boolean isACTIONPARAMNull() {
        return this.IsParamNull(TAG_ACTIONPARAM);
    }

    public String getACTIONPARAM() {
        return this.GetParamStringValue(TAG_ACTIONPARAM, "");
    }

    public void setACTIONPARAM(String strValue) {
        this.SetParamValue(TAG_ACTIONPARAM, strValue);
    }

    public boolean isCUSTOMDATAACTIONNull() {
        return this.IsParamNull(TAG_CUSTOMDATAACTION);
    }

    public String getCUSTOMDATAACTION() {
        return this.GetParamStringValue(TAG_CUSTOMDATAACTION, "");
    }

    public void setCUSTOMDATAACTION(String strValue) {
        this.SetParamValue(TAG_CUSTOMDATAACTION, strValue);
    }

    public boolean isTESTDATAACTIONNull() {
        return this.IsParamNull(TAG_TESTDATAACTION);
    }

    public String getTESTDATAACTION() {
        return this.GetParamStringValue(TAG_TESTDATAACTION, "");
    }

    public void setTESTDATAACTION(String strValue) {
        this.SetParamValue(TAG_TESTDATAACTION, strValue);
    }

    public void BuildActionParams() {
        try {
            if (this.actionParams != null) {
                return;
            }
            String strActionParam = this.getACTIONPARAM();
            if (!StringHelper.IsNullOrEmpty((String)strActionParam)) {
                this.actionParams = new Properties();
                this.actionParams = PropertiesHelper.Load((Properties)this.actionParams, (String)strActionParam);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public Properties getActionParams() {
        return this.actionParams;
    }
}

