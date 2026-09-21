/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSWFRole
extends BaseDataEntity {
    public static final String WFROLETYPE_USERGROUP = "USERGROUP";
    public static final String WFROLETYPE_CUSTOM = "CUSTOM";
    public static final String WFROLETYPE_DEDATASET = "DEDATASET";
    public static final String TAG_PSWFROLEID = "PSWFROLEID";
    public static final String TAG_PSWFROLENAME = "PSWFROLENAME";
    public static final String TAG_ENABLE = "ENABLE";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_WFROLETYPE = "WFROLETYPE";
    public static final String TAG_WFROLESN = "WFROLESN";
    public static final String TAG_USERDATA = "USERDATA";
    public static final String TAG_USERDATA2 = "USERDATA2";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_PSDEDSID = "PSDEDSID";
    public static final String TAG_PSDEDSNAME = "PSDEDSNAME";
    public static final String TAG_WFUSERIDPSDEFID = "WFUSERIDPSDEFID";
    public static final String TAG_WFUSERIDPSDEFNAME = "WFUSERIDPSDEFNAME";
    public static final String TAG_WFUSERNAMEPSDEFID = "WFUSERNAMEPSDEFID";
    public static final String TAG_WFUSERNAMEPSDEFNAME = "WFUSERNAMEPSDEFNAME";
    public static final String TAG_PSMODULEID = "PSMODULEID";
    public static final String TAG_PSMODULENAME = "PSMODULENAME";
    public static final String TAG_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String TAG_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";

    public final boolean isPSWFROLEIDNull() {
        return this.IsParamNull(TAG_PSWFROLEID);
    }

    public final String getPSWFROLEID() {
        return this.GetParamStringValue(TAG_PSWFROLEID, "");
    }

    public final void setPSWFROLEID(String strValue) {
        this.SetParamValue(TAG_PSWFROLEID, strValue);
    }

    public final boolean isPSWFROLENAMENull() {
        return this.IsParamNull(TAG_PSWFROLENAME);
    }

    public final String getPSWFROLENAME() {
        return this.GetParamStringValue(TAG_PSWFROLENAME, "");
    }

    public final void setPSWFROLENAME(String strValue) {
        this.SetParamValue(TAG_PSWFROLENAME, strValue);
    }

    public final boolean isENABLENull() {
        return this.IsParamNull(TAG_ENABLE);
    }

    public final boolean getENABLE() {
        return this.GetParamIntValue(TAG_ENABLE, 0) == 1;
    }

    public final void setENABLE(boolean bValue) {
        this.SetParamValue(TAG_ENABLE, bValue ? 1 : 0);
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

    public final boolean isPSSYSTEMIDNull() {
        return this.IsParamNull(TAG_PSSYSTEMID);
    }

    public final String getPSSYSTEMID() {
        return this.GetParamStringValue(TAG_PSSYSTEMID, "");
    }

    public final void setPSSYSTEMID(String strValue) {
        this.SetParamValue(TAG_PSSYSTEMID, strValue);
    }

    public final boolean isPSSYSTEMNAMENull() {
        return this.IsParamNull(TAG_PSSYSTEMNAME);
    }

    public final String getPSSYSTEMNAME() {
        return this.GetParamStringValue(TAG_PSSYSTEMNAME, "");
    }

    public final void setPSSYSTEMNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSTEMNAME, strValue);
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

    public final boolean isCODENAMENull() {
        return this.IsParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.GetParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.SetParamValue(TAG_CODENAME, strValue);
    }

    public final boolean isWFROLETYPENull() {
        return this.IsParamNull(TAG_WFROLETYPE);
    }

    public final String getWFROLETYPE() {
        return this.GetParamStringValue(TAG_WFROLETYPE, "");
    }

    public final void setWFROLETYPE(String strValue) {
        this.SetParamValue(TAG_WFROLETYPE, strValue);
    }

    public final boolean isWFROLESNNull() {
        return this.IsParamNull(TAG_WFROLESN);
    }

    public final String getWFROLESN() {
        return this.GetParamStringValue(TAG_WFROLESN, "");
    }

    public final void setWFROLESN(String strValue) {
        this.SetParamValue(TAG_WFROLESN, strValue);
    }

    public final boolean isUSERDATANull() {
        return this.IsParamNull(TAG_USERDATA);
    }

    public final String getUSERDATA() {
        return this.GetParamStringValue(TAG_USERDATA, "");
    }

    public final void setUSERDATA(String strValue) {
        this.SetParamValue(TAG_USERDATA, strValue);
    }

    public final boolean isUSERDATA2Null() {
        return this.IsParamNull(TAG_USERDATA2);
    }

    public final String getUSERDATA2() {
        return this.GetParamStringValue(TAG_USERDATA2, "");
    }

    public final void setUSERDATA2(String strValue) {
        this.SetParamValue(TAG_USERDATA2, strValue);
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

    public final boolean isPSDEDSIDNull() {
        return this.IsParamNull(TAG_PSDEDSID);
    }

    public final String getPSDEDSID() {
        return this.GetParamStringValue(TAG_PSDEDSID, "");
    }

    public final void setPSDEDSID(String strValue) {
        this.SetParamValue(TAG_PSDEDSID, strValue);
    }

    public final boolean isPSDEDSNAMENull() {
        return this.IsParamNull(TAG_PSDEDSNAME);
    }

    public final String getPSDEDSNAME() {
        return this.GetParamStringValue(TAG_PSDEDSNAME, "");
    }

    public final void setPSDEDSNAME(String strValue) {
        this.SetParamValue(TAG_PSDEDSNAME, strValue);
    }

    public final boolean isWFUSERIDPSDEFIDNull() {
        return this.IsParamNull(TAG_WFUSERIDPSDEFID);
    }

    public final String getWFUSERIDPSDEFID() {
        return this.GetParamStringValue(TAG_WFUSERIDPSDEFID, "");
    }

    public final void setWFUSERIDPSDEFID(String strValue) {
        this.SetParamValue(TAG_WFUSERIDPSDEFID, strValue);
    }

    public final boolean isWFUSERIDPSDEFNAMENull() {
        return this.IsParamNull(TAG_WFUSERIDPSDEFNAME);
    }

    public final String getWFUSERIDPSDEFNAME() {
        return this.GetParamStringValue(TAG_WFUSERIDPSDEFNAME, "");
    }

    public final void setWFUSERIDPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_WFUSERIDPSDEFNAME, strValue);
    }

    public final boolean isWFUSERNAMEPSDEFIDNull() {
        return this.IsParamNull(TAG_WFUSERNAMEPSDEFID);
    }

    public final String getWFUSERNAMEPSDEFID() {
        return this.GetParamStringValue(TAG_WFUSERNAMEPSDEFID, "");
    }

    public final void setWFUSERNAMEPSDEFID(String strValue) {
        this.SetParamValue(TAG_WFUSERNAMEPSDEFID, strValue);
    }

    public final boolean isWFUSERNAMEPSDEFNAMENull() {
        return this.IsParamNull(TAG_WFUSERNAMEPSDEFNAME);
    }

    public final String getWFUSERNAMEPSDEFNAME() {
        return this.GetParamStringValue(TAG_WFUSERNAMEPSDEFNAME, "");
    }

    public final void setWFUSERNAMEPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_WFUSERNAMEPSDEFNAME, strValue);
    }

    public final boolean isPSMODULEIDNull() {
        return this.IsParamNull(TAG_PSMODULEID);
    }

    public final String getPSMODULEID() {
        return this.GetParamStringValue(TAG_PSMODULEID, "");
    }

    public final void setPSMODULEID(String strValue) {
        this.SetParamValue(TAG_PSMODULEID, strValue);
    }

    public final boolean isPSMODULENAMENull() {
        return this.IsParamNull(TAG_PSMODULENAME);
    }

    public final String getPSMODULENAME() {
        return this.GetParamStringValue(TAG_PSMODULENAME, "");
    }

    public final void setPSMODULENAME(String strValue) {
        this.SetParamValue(TAG_PSMODULENAME, strValue);
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

