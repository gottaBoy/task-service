/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysReqModule
extends BaseDataEntity {
    public static final String USERCAT_CAT1 = "CAT1";
    public static final String USERCAT_CAT2 = "CAT2";
    public static final String USERCAT_CAT3 = "CAT3";
    public static final String USERCAT_CAT4 = "CAT4";
    public static final String USERCAT_CAT5 = "CAT5";
    public static final String USERCAT_CAT6 = "CAT6";
    public static final String USERCAT_CAT7 = "CAT7";
    public static final String USERCAT_CAT8 = "CAT8";
    public static final String USERCAT_CAT9 = "CAT9";
    public static final String TAG_PSSYSREQMODULEID = "PSSYSREQMODULEID";
    public static final String TAG_PSSYSREQMODULENAME = "PSSYSREQMODULENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_PPSSYSREQMODULEID = "PPSSYSREQMODULEID";
    public static final String TAG_PPSSYSREQMODULENAME = "PPSSYSREQMODULENAME";
    public static final String TAG_MODULESN = "MODULESN";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSDEVPRDID = "PSDEVPRDID";
    public static final String TAG_PSDEVPRDNAME = "PSDEVPRDNAME";
    public static final String TAG_PSDEVPRDVERID = "PSDEVPRDVERID";
    public static final String TAG_PSDEVPRDVERNAME = "PSDEVPRDVERNAME";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_PSMODULEID = "PSMODULEID";
    public static final String TAG_PSMODULENAME = "PSMODULENAME";
    public static final String TAG_CONTENT = "CONTENT";
    public static final String TAG_MODULETAG = "MODULETAG";
    public static final String TAG_MODULETAG2 = "MODULETAG2";
    public static final String TAG_MODULETAG3 = "MODULETAG3";
    public static final String TAG_MODULETAG4 = "MODULETAG4";

    public final boolean isPSSYSREQMODULEIDNull() {
        return this.IsParamNull(TAG_PSSYSREQMODULEID);
    }

    public final String getPSSYSREQMODULEID() {
        return this.GetParamStringValue(TAG_PSSYSREQMODULEID, "");
    }

    public final void setPSSYSREQMODULEID(String strValue) {
        this.SetParamValue(TAG_PSSYSREQMODULEID, strValue);
    }

    public final boolean isPSSYSREQMODULENAMENull() {
        return this.IsParamNull(TAG_PSSYSREQMODULENAME);
    }

    public final String getPSSYSREQMODULENAME() {
        return this.GetParamStringValue(TAG_PSSYSREQMODULENAME, "");
    }

    public final void setPSSYSREQMODULENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSREQMODULENAME, strValue);
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

    public final boolean isPPSSYSREQMODULEIDNull() {
        return this.IsParamNull(TAG_PPSSYSREQMODULEID);
    }

    public final String getPPSSYSREQMODULEID() {
        return this.GetParamStringValue(TAG_PPSSYSREQMODULEID, "");
    }

    public final void setPPSSYSREQMODULEID(String strValue) {
        this.SetParamValue(TAG_PPSSYSREQMODULEID, strValue);
    }

    public final boolean isPPSSYSREQMODULENAMENull() {
        return this.IsParamNull(TAG_PPSSYSREQMODULENAME);
    }

    public final String getPPSSYSREQMODULENAME() {
        return this.GetParamStringValue(TAG_PPSSYSREQMODULENAME, "");
    }

    public final void setPPSSYSREQMODULENAME(String strValue) {
        this.SetParamValue(TAG_PPSSYSREQMODULENAME, strValue);
    }

    public final boolean isMODULESNNull() {
        return this.IsParamNull(TAG_MODULESN);
    }

    public final String getMODULESN() {
        return this.GetParamStringValue(TAG_MODULESN, "");
    }

    public final void setMODULESN(String strValue) {
        this.SetParamValue(TAG_MODULESN, strValue);
    }

    public final boolean isORDERVALUENull() {
        return this.IsParamNull(TAG_ORDERVALUE);
    }

    public final int getORDERVALUE() {
        return this.GetParamIntValue(TAG_ORDERVALUE, 0);
    }

    public final void setORDERVALUE(int nValue) {
        this.SetParamValue(TAG_ORDERVALUE, nValue);
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

    public final boolean isPSDEVPRDIDNull() {
        return this.IsParamNull(TAG_PSDEVPRDID);
    }

    public final String getPSDEVPRDID() {
        return this.GetParamStringValue(TAG_PSDEVPRDID, "");
    }

    public final void setPSDEVPRDID(String strValue) {
        this.SetParamValue(TAG_PSDEVPRDID, strValue);
    }

    public final boolean isPSDEVPRDNAMENull() {
        return this.IsParamNull(TAG_PSDEVPRDNAME);
    }

    public final String getPSDEVPRDNAME() {
        return this.GetParamStringValue(TAG_PSDEVPRDNAME, "");
    }

    public final void setPSDEVPRDNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVPRDNAME, strValue);
    }

    public final boolean isPSDEVPRDVERIDNull() {
        return this.IsParamNull(TAG_PSDEVPRDVERID);
    }

    public final String getPSDEVPRDVERID() {
        return this.GetParamStringValue(TAG_PSDEVPRDVERID, "");
    }

    public final void setPSDEVPRDVERID(String strValue) {
        this.SetParamValue(TAG_PSDEVPRDVERID, strValue);
    }

    public final boolean isPSDEVPRDVERNAMENull() {
        return this.IsParamNull(TAG_PSDEVPRDVERNAME);
    }

    public final String getPSDEVPRDVERNAME() {
        return this.GetParamStringValue(TAG_PSDEVPRDVERNAME, "");
    }

    public final void setPSDEVPRDVERNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVPRDVERNAME, strValue);
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

    public final boolean isUSERCATNull() {
        return this.IsParamNull(TAG_USERCAT);
    }

    public final String getUSERCAT() {
        return this.GetParamStringValue(TAG_USERCAT, "");
    }

    public final void setUSERCAT(String strValue) {
        this.SetParamValue(TAG_USERCAT, strValue);
    }

    public final boolean isUSERTAG4Null() {
        return this.IsParamNull(TAG_USERTAG4);
    }

    public final String getUSERTAG4() {
        return this.GetParamStringValue(TAG_USERTAG4, "");
    }

    public final void setUSERTAG4(String strValue) {
        this.SetParamValue(TAG_USERTAG4, strValue);
    }

    public final boolean isUSERTAG3Null() {
        return this.IsParamNull(TAG_USERTAG3);
    }

    public final String getUSERTAG3() {
        return this.GetParamStringValue(TAG_USERTAG3, "");
    }

    public final void setUSERTAG3(String strValue) {
        this.SetParamValue(TAG_USERTAG3, strValue);
    }

    public final boolean isUSERTAG2Null() {
        return this.IsParamNull(TAG_USERTAG2);
    }

    public final String getUSERTAG2() {
        return this.GetParamStringValue(TAG_USERTAG2, "");
    }

    public final void setUSERTAG2(String strValue) {
        this.SetParamValue(TAG_USERTAG2, strValue);
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

    public final boolean isCONTENTNull() {
        return this.IsParamNull(TAG_CONTENT);
    }

    public final String getCONTENT() {
        return this.GetParamStringValue(TAG_CONTENT, "");
    }

    public final void setCONTENT(String strValue) {
        this.SetParamValue(TAG_CONTENT, strValue);
    }

    public final boolean isMODULETAGNull() {
        return this.IsParamNull(TAG_MODULETAG);
    }

    public final String getMODULETAG() {
        return this.GetParamStringValue(TAG_MODULETAG, "");
    }

    public final void setMODULETAG(String strValue) {
        this.SetParamValue(TAG_MODULETAG, strValue);
    }

    public final boolean isMODULETAG2Null() {
        return this.IsParamNull(TAG_MODULETAG2);
    }

    public final String getMODULETAG2() {
        return this.GetParamStringValue(TAG_MODULETAG2, "");
    }

    public final void setMODULETAG2(String strValue) {
        this.SetParamValue(TAG_MODULETAG2, strValue);
    }

    public final boolean isMODULETAG3Null() {
        return this.IsParamNull(TAG_MODULETAG3);
    }

    public final String getMODULETAG3() {
        return this.GetParamStringValue(TAG_MODULETAG3, "");
    }

    public final void setMODULETAG3(String strValue) {
        this.SetParamValue(TAG_MODULETAG3, strValue);
    }

    public final boolean isMODULETAG4Null() {
        return this.IsParamNull(TAG_MODULETAG4);
    }

    public final String getMODULETAG4() {
        return this.GetParamStringValue(TAG_MODULETAG4, "");
    }

    public final void setMODULETAG4(String strValue) {
        this.SetParamValue(TAG_MODULETAG4, strValue);
    }
}

