/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSWXLogic
extends BaseDataEntity {
    public static final String EVENTTYPE_app_in = "app_in";
    public static final String EVENTTYPE_location_in = "location_in";
    public static final String EVENTTYPE_asynctask_finish = "asynctask_finish";
    public static final String EVENTTYPE_menu_click = "menu_click";
    public static final String EVENTTYPE_message_in = "message_in";
    public static final String TAG_PSWXLOGICID = "PSWXLOGICID";
    public static final String TAG_PSWXLOGICNAME = "PSWXLOGICNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSWXACCOUNTID = "PSWXACCOUNTID";
    public static final String TAG_PSWXACCOUNTNAME = "PSWXACCOUNTNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_EVENTTYPE = "EVENTTYPE";
    public static final String TAG_PSWXMENUFUNCID = "PSWXMENUFUNCID";
    public static final String TAG_PSWXMENUFUNCNAME = "PSWXMENUFUNCNAME";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_PSDEACTIONID = "PSDEACTIONID";
    public static final String TAG_PSDEACTIONNAME = "PSDEACTIONNAME";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_PSWXENTAPPID = "PSWXENTAPPID";
    public static final String TAG_PSWXENTAPPNAME = "PSWXENTAPPNAME";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String TAG_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";

    public final boolean isPSWXLOGICIDNull() {
        return this.IsParamNull(TAG_PSWXLOGICID);
    }

    public final String getPSWXLOGICID() {
        return this.GetParamStringValue(TAG_PSWXLOGICID, "");
    }

    public final void setPSWXLOGICID(String strValue) {
        this.SetParamValue(TAG_PSWXLOGICID, strValue);
    }

    public final boolean isPSWXLOGICNAMENull() {
        return this.IsParamNull(TAG_PSWXLOGICNAME);
    }

    public final String getPSWXLOGICNAME() {
        return this.GetParamStringValue(TAG_PSWXLOGICNAME, "");
    }

    public final void setPSWXLOGICNAME(String strValue) {
        this.SetParamValue(TAG_PSWXLOGICNAME, strValue);
    }

    public final boolean isCREATEMANNull() {
        return this.IsParamNull(TAG_CREATEMAN);
    }

    public final String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public final void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public final boolean isCREATEDATENull() {
        return this.IsParamNull(TAG_CREATEDATE);
    }

    public final Date getCREATEDATE() {
        return this.GetParamDateValue(TAG_CREATEDATE, null);
    }

    public final void setCREATEDATE(Date dtValue) {
        this.SetParamValue(TAG_CREATEDATE, dtValue);
    }

    public final boolean isUPDATEMANNull() {
        return this.IsParamNull(TAG_UPDATEMAN);
    }

    public final String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public final void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public final boolean isUPDATEDATENull() {
        return this.IsParamNull(TAG_UPDATEDATE);
    }

    public final Date getUPDATEDATE() {
        return this.GetParamDateValue(TAG_UPDATEDATE, null);
    }

    public final void setUPDATEDATE(Date dtValue) {
        this.SetParamValue(TAG_UPDATEDATE, dtValue);
    }

    public final boolean isPSWXACCOUNTIDNull() {
        return this.IsParamNull(TAG_PSWXACCOUNTID);
    }

    public final String getPSWXACCOUNTID() {
        return this.GetParamStringValue(TAG_PSWXACCOUNTID, "");
    }

    public final void setPSWXACCOUNTID(String strValue) {
        this.SetParamValue(TAG_PSWXACCOUNTID, strValue);
    }

    public final boolean isPSWXACCOUNTNAMENull() {
        return this.IsParamNull(TAG_PSWXACCOUNTNAME);
    }

    public final String getPSWXACCOUNTNAME() {
        return this.GetParamStringValue(TAG_PSWXACCOUNTNAME, "");
    }

    public final void setPSWXACCOUNTNAME(String strValue) {
        this.SetParamValue(TAG_PSWXACCOUNTNAME, strValue);
    }

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isEVENTTYPENull() {
        return this.IsParamNull(TAG_EVENTTYPE);
    }

    public final String getEVENTTYPE() {
        return this.GetParamStringValue(TAG_EVENTTYPE, "");
    }

    public final void setEVENTTYPE(String strValue) {
        this.SetParamValue(TAG_EVENTTYPE, strValue);
    }

    public final boolean isPSWXMENUFUNCIDNull() {
        return this.IsParamNull(TAG_PSWXMENUFUNCID);
    }

    public final String getPSWXMENUFUNCID() {
        return this.GetParamStringValue(TAG_PSWXMENUFUNCID, "");
    }

    public final void setPSWXMENUFUNCID(String strValue) {
        this.SetParamValue(TAG_PSWXMENUFUNCID, strValue);
    }

    public final boolean isPSWXMENUFUNCNAMENull() {
        return this.IsParamNull(TAG_PSWXMENUFUNCNAME);
    }

    public final String getPSWXMENUFUNCNAME() {
        return this.GetParamStringValue(TAG_PSWXMENUFUNCNAME, "");
    }

    public final void setPSWXMENUFUNCNAME(String strValue) {
        this.SetParamValue(TAG_PSWXMENUFUNCNAME, strValue);
    }

    public final boolean isPSDEIDNull() {
        return this.IsParamNull(TAG_PSDEID);
    }

    public final String getPSDEID() {
        return this.GetParamStringValue(TAG_PSDEID, "");
    }

    public final void setPSDEID(String strValue) {
        this.SetParamValue(TAG_PSDEID, strValue);
    }

    public final boolean isPSDENAMENull() {
        return this.IsParamNull(TAG_PSDENAME);
    }

    public final String getPSDENAME() {
        return this.GetParamStringValue(TAG_PSDENAME, "");
    }

    public final void setPSDENAME(String strValue) {
        this.SetParamValue(TAG_PSDENAME, strValue);
    }

    public final boolean isPSDEACTIONIDNull() {
        return this.IsParamNull(TAG_PSDEACTIONID);
    }

    public final String getPSDEACTIONID() {
        return this.GetParamStringValue(TAG_PSDEACTIONID, "");
    }

    public final void setPSDEACTIONID(String strValue) {
        this.SetParamValue(TAG_PSDEACTIONID, strValue);
    }

    public final boolean isPSDEACTIONNAMENull() {
        return this.IsParamNull(TAG_PSDEACTIONNAME);
    }

    public final String getPSDEACTIONNAME() {
        return this.GetParamStringValue(TAG_PSDEACTIONNAME, "");
    }

    public final void setPSDEACTIONNAME(String strValue) {
        this.SetParamValue(TAG_PSDEACTIONNAME, strValue);
    }

    public final boolean isCODENAMENull() {
        return this.IsParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.GetParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.SetParamValue(TAG_CODENAME, strValue);
    }

    public final boolean isPSWXENTAPPIDNull() {
        return this.IsParamNull(TAG_PSWXENTAPPID);
    }

    public final String getPSWXENTAPPID() {
        return this.GetParamStringValue(TAG_PSWXENTAPPID, "");
    }

    public final void setPSWXENTAPPID(String strValue) {
        this.SetParamValue(TAG_PSWXENTAPPID, strValue);
    }

    public final boolean isPSWXENTAPPNAMENull() {
        return this.IsParamNull(TAG_PSWXENTAPPNAME);
    }

    public final String getPSWXENTAPPNAME() {
        return this.GetParamStringValue(TAG_PSWXENTAPPNAME, "");
    }

    public final void setPSWXENTAPPNAME(String strValue) {
        this.SetParamValue(TAG_PSWXENTAPPNAME, strValue);
    }

    public final boolean isUSERTAGNull() {
        return this.IsParamNull(TAG_USERTAG);
    }

    public final String getUSERTAG() {
        return this.GetParamStringValue(TAG_USERTAG, "");
    }

    public final void setUSERTAG(String strValue) {
        this.SetParamValue(TAG_USERTAG, strValue);
    }

    public final boolean isPSSYSSFPLUGINIDNull() {
        return this.IsParamNull(TAG_PSSYSSFPLUGINID);
    }

    public final String getPSSYSSFPLUGINID() {
        return this.GetParamStringValue(TAG_PSSYSSFPLUGINID, "");
    }

    public final void setPSSYSSFPLUGINID(String strValue) {
        this.SetParamValue(TAG_PSSYSSFPLUGINID, strValue);
    }

    public final boolean isPSSYSSFPLUGINNAMENull() {
        return this.IsParamNull(TAG_PSSYSSFPLUGINNAME);
    }

    public final String getPSSYSSFPLUGINNAME() {
        return this.GetParamStringValue(TAG_PSSYSSFPLUGINNAME, "");
    }

    public final void setPSSYSSFPLUGINNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSSFPLUGINNAME, strValue);
    }
}

