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

public class DBAction
extends BaseDataEntity {
    public static final String TAG_ACTION_INSERT = "INSERT";
    public static final String TAG_ACTION_UPDATE = "UPDATE";
    public static final String TAG_ACTION_DELETE = "DELETE";
    public static final String TAG_ACTION_SELECT = "SELECT";
    public static final String TAG_ACTIONMODE_DEFAULT = "DEFAULT";
    public static final String TAG_DBACTIONID = "DBACTIONID";
    public static final String TAG_DBACTIONNAME = "DBACTIONNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_ACTION = "ACTION";
    public static final String TAG_ACTIONMODE = "ACTIONMODE";
    public static final String TAG_CHECKCOND = "CHECKCOND";
    public static final String TAG_ERRORCODE = "ERRORCODE";
    public static final String TAG_ERRORINFO = "ERRORINFO";
    public static final String TAG_ACTIONPARAM = "ACTIONPARAM";
    public static final String TAG_DBTYPE = "DBTYPE";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_DEID = "DEID";
    private Properties actionProperties = null;

    public String getDBACTIONID() {
        return this.GetParamStringValue(TAG_DBACTIONID, "");
    }

    public void setDBACTIONID(String strValue) {
        this.SetParamValue(TAG_DBACTIONID, strValue);
    }

    public String getDBACTIONNAME() {
        return this.GetParamStringValue(TAG_DBACTIONNAME, "");
    }

    public void setDBACTIONNAME(String strValue) {
        this.SetParamValue(TAG_DBACTIONNAME, strValue);
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

    public String getACTION() {
        return this.GetParamStringValue(TAG_ACTION, "");
    }

    public void setACTION(String strValue) {
        this.SetParamValue(TAG_ACTION, strValue);
    }

    public String getACTIONMODE() {
        return this.GetParamStringValue(TAG_ACTIONMODE, "");
    }

    public void setACTIONMODE(String strValue) {
        this.SetParamValue(TAG_ACTIONMODE, strValue);
    }

    public String getCHECKCOND() {
        return this.GetParamStringValue(TAG_CHECKCOND, "");
    }

    public void setCHECKCOND(String strValue) {
        this.SetParamValue(TAG_CHECKCOND, strValue);
    }

    public int getERRORCODE() {
        return this.GetParamIntValue(TAG_ERRORCODE, 0);
    }

    public void setERRORCODE(int strValue) {
        this.SetParamValue(TAG_ERRORCODE, strValue);
    }

    public String getERRORINFO() {
        return this.GetParamStringValue(TAG_ERRORINFO, "");
    }

    public void setERRORINFO(String strValue) {
        this.SetParamValue(TAG_ERRORINFO, strValue);
    }

    public String getACTIONPARAM() {
        return this.GetParamStringValue(TAG_ACTIONPARAM, "");
    }

    public void setACTIONPARAM(String strValue) {
        this.SetParamValue(TAG_ACTIONPARAM, strValue);
    }

    public String getDBTYPE() {
        return this.GetParamStringValue(TAG_DBTYPE, "");
    }

    public void setDBTYPE(String strValue) {
        this.SetParamValue(TAG_DBTYPE, strValue);
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

    public void BuildActionParams() {
        try {
            if (this.actionProperties != null) {
                return;
            }
            String strActionParam = this.getACTIONPARAM();
            if (!StringHelper.IsNullOrEmpty((String)strActionParam)) {
                this.actionProperties = new Properties();
                this.actionProperties = PropertiesHelper.Load((Properties)this.actionProperties, (String)strActionParam);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public Properties getActionParams() {
        return this.actionProperties;
    }
}

