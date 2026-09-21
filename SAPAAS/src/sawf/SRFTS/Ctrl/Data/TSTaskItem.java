/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 */
package SRFTS.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import java.util.Date;
import java.util.Properties;

public class TSTaskItem
extends BaseDataEntity {
    public static final String TAG_TSTASKITEMID = "TSTASKITEMID";
    public static final String TAG_TSTASKID = "TSTASKID";
    public static final String TAG_TSSCHEDULEID = "TSSCHEDULEID";
    public static final String TAG_TASKITEMINFO = "TASKITEMINFO";
    public static final String TAG_REALTIME = "REALTIME";
    public static final String TAG_PLANTIME = "PLANTIME";
    public static final String TAG_REALSTARTTIME = "REALSTARTTIME";
    public static final String TAG_REALENDTIME = "REALENDTIME";
    public static final String TAG_ISCANCEL = "ISCANCEL";
    public static final String TAG_ISFINISH = "ISFINISH";
    public static final String TAG_RUNRESULT = "RUNRESULT";
    public static final String TAG_ISUSERDATA = "ISUSERDATA";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_RESERVER = "RESERVER";
    public static final String TAG_RESERVER2 = "RESERVER2";
    public static final String TAG_TASKOBJECT = "TASKOBJECT";
    public static final String TAG_TASKPARAM = "TASKPARAM";
    public static final String TAG_TASKPARAM2 = "TASKPARAM2";
    public static final String TAG_TASKPARAM3 = "TASKPARAM3";
    public static final String TAG_TASKPARAM4 = "TASKPARAM4";
    public static final String TAG_TASKPARAM5 = "TASKPARAM5";
    private Properties properties = null;

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

    public String getRUNRESULT() {
        return this.GetParamStringValue(TAG_RUNRESULT, "");
    }

    public String getTASKITEMINFO() {
        return this.GetParamStringValue(TAG_TASKITEMINFO, "");
    }

    public String getTSSCHEDULEID() {
        return this.GetParamStringValue(TAG_TSSCHEDULEID, "");
    }

    public String getTSTASKID() {
        return this.GetParamStringValue(TAG_TSTASKID, "");
    }

    public String getTSTASKITEMID() {
        return this.GetParamStringValue(TAG_TSTASKITEMID, "");
    }

    public String getTASKOBJECT() {
        return this.GetParamStringValue(TAG_TASKOBJECT, "");
    }

    public String getTASKPARAM4() {
        return this.GetParamStringValue(TAG_TASKPARAM4, "");
    }

    public String getTASKPARAM3() {
        return this.GetParamStringValue(TAG_TASKPARAM3, "");
    }

    public String getTASKPARAM2() {
        return this.GetParamStringValue(TAG_TASKPARAM2, "");
    }

    public String getTASKPARAM() {
        return this.GetParamStringValue(TAG_TASKPARAM, "");
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

    public void setRUNRESULT(String strValue) {
        this.SetParamValue(TAG_RUNRESULT, strValue);
    }

    public void setTASKITEMINFO(String strValue) {
        this.SetParamValue(TAG_TASKITEMINFO, strValue);
    }

    public void setTSSCHEDULEID(String strValue) {
        this.SetParamValue(TAG_TSSCHEDULEID, strValue);
    }

    public void setTSTASKID(String strValue) {
        this.SetParamValue(TAG_TSTASKID, strValue);
    }

    public void setTSTASKITEMID(String strValue) {
        this.SetParamValue(TAG_TSTASKITEMID, strValue);
    }

    public void setTASKOBJECT(String strValue) {
        this.SetParamValue(TAG_TASKOBJECT, strValue);
    }

    public boolean isCANCEL() {
        return this.GetParamIntValue(TAG_ISCANCEL, 0) == 1;
    }

    public boolean isFINISH() {
        return this.GetParamIntValue(TAG_ISFINISH, 0) == 1;
    }

    public boolean isUSERDATA() {
        return this.GetParamIntValue(TAG_ISUSERDATA, 0) == 1;
    }

    public void setISCANCEL(boolean bValue) {
        this.SetParamValue(TAG_ISCANCEL, bValue ? 1 : 0);
    }

    public void setISFINISH(boolean bValue) {
        this.SetParamValue(TAG_ISFINISH, bValue ? 1 : 0);
    }

    public void setISUSERDATA(boolean bValue) {
        this.SetParamValue(TAG_ISUSERDATA, bValue ? 1 : 0);
    }

    public void setREALTIME(Object objValue) {
        this.SetParamValue(TAG_REALTIME, objValue);
    }

    public void setPLANTIME(Object objValue) {
        this.SetParamValue(TAG_PLANTIME, objValue);
    }

    public Date getREALTIME() {
        return this.GetDate(this.GetParamDateValue(TAG_REALTIME, null));
    }

    public Date getPLANTIME() {
        return this.GetDate(this.GetParamDateValue(TAG_PLANTIME, null));
    }

    protected Date GetDate(java.sql.Date sqlDate) {
        if (sqlDate == null) {
            return null;
        }
        return new Date(sqlDate.getTime());
    }

    public void setTaskParam(String strParam, String strValue) {
        this.PrepareProperties();
        this.properties.setProperty(strParam, strValue);
    }

    public String getTaskParam(String strParam, String defaultValue) {
        this.PrepareProperties();
        return PropertiesHelper.GetProperty((Properties)this.properties, (String)strParam, (String)defaultValue);
    }

    private void PrepareProperties() {
        if (this.properties != null) {
            return;
        }
        String strParams = this.getTASKPARAM();
        strParams = String.valueOf(strParams) + "\r\n";
        strParams = String.valueOf(strParams) + this.getTASKPARAM2();
        strParams = String.valueOf(strParams) + "\r\n";
        strParams = String.valueOf(strParams) + this.getTASKPARAM3();
        strParams = String.valueOf(strParams) + "\r\n";
        strParams = String.valueOf(strParams) + this.getTASKPARAM4();
        try {
            this.properties = PropertiesHelper.Load((String)strParams);
        }
        catch (Exception ex) {
            return;
        }
    }

    public String getTASKPARAM5() {
        return this.GetParamStringValue(TAG_TASKPARAM5, "");
    }

    public void setTASKPARAM5(String strValue) {
        this.SetParamValue(TAG_TASKPARAM5, strValue);
    }
}

