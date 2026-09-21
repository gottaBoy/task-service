/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysTestModule
extends BaseDataEntity {
    public static final String MODULETYPE_APPVIEW = "APPVIEW";
    public static final String MODULETYPE_DESERVICEAPI = "DESERVICEAPI";
    public static final String MODULETYPE_USER = "USER";
    public static final String MODULETYPE_USER2 = "USER2";
    public static final String MODULETYPE_USER3 = "USER3";
    public static final String MODULETYPE_USER4 = "USER4";
    public static final String USERCAT_CAT1 = "CAT1";
    public static final String USERCAT_CAT2 = "CAT2";
    public static final String USERCAT_CAT3 = "CAT3";
    public static final String USERCAT_CAT4 = "CAT4";
    public static final String USERCAT_CAT5 = "CAT5";
    public static final String USERCAT_CAT6 = "CAT6";
    public static final String USERCAT_CAT7 = "CAT7";
    public static final String USERCAT_CAT8 = "CAT8";
    public static final String USERCAT_CAT9 = "CAT9";
    public static final String TAG_PSSYSTESTMODULEID = "PSSYSTESTMODULEID";
    public static final String TAG_PSSYSTESTMODULENAME = "PSSYSTESTMODULENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTESTPRJID = "PSSYSTESTPRJID";
    public static final String TAG_PSSYSTESTPRJNAME = "PSSYSTESTPRJNAME";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_MODULETYPE = "MODULETYPE";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_MODULETAG = "MODULETAG";
    public static final String TAG_MODULETAG2 = "MODULETAG2";
    public static final String TAG_PSSYSAPPID = "PSSYSAPPID";
    public static final String TAG_PSSYSSERVICEAPIID = "PSSYSSERVICEAPIID";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";

    public final boolean isPSSYSTESTMODULEIDNull() {
        return this.IsParamNull(TAG_PSSYSTESTMODULEID);
    }

    public final String getPSSYSTESTMODULEID() {
        return this.GetParamStringValue(TAG_PSSYSTESTMODULEID, "");
    }

    public final void setPSSYSTESTMODULEID(String strValue) {
        this.SetParamValue(TAG_PSSYSTESTMODULEID, strValue);
    }

    public final boolean isPSSYSTESTMODULENAMENull() {
        return this.IsParamNull(TAG_PSSYSTESTMODULENAME);
    }

    public final String getPSSYSTESTMODULENAME() {
        return this.GetParamStringValue(TAG_PSSYSTESTMODULENAME, "");
    }

    public final void setPSSYSTESTMODULENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSTESTMODULENAME, strValue);
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

    public final boolean isPSSYSTESTPRJIDNull() {
        return this.IsParamNull(TAG_PSSYSTESTPRJID);
    }

    public final String getPSSYSTESTPRJID() {
        return this.GetParamStringValue(TAG_PSSYSTESTPRJID, "");
    }

    public final void setPSSYSTESTPRJID(String strValue) {
        this.SetParamValue(TAG_PSSYSTESTPRJID, strValue);
    }

    public final boolean isPSSYSTESTPRJNAMENull() {
        return this.IsParamNull(TAG_PSSYSTESTPRJNAME);
    }

    public final String getPSSYSTESTPRJNAME() {
        return this.GetParamStringValue(TAG_PSSYSTESTPRJNAME, "");
    }

    public final void setPSSYSTESTPRJNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSTESTPRJNAME, strValue);
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

    public final boolean isMODULETYPENull() {
        return this.IsParamNull(TAG_MODULETYPE);
    }

    public final String getMODULETYPE() {
        return this.GetParamStringValue(TAG_MODULETYPE, "");
    }

    public final void setMODULETYPE(String strValue) {
        this.SetParamValue(TAG_MODULETYPE, strValue);
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

    public final boolean isUSERTAGNull() {
        return this.IsParamNull(TAG_USERTAG);
    }

    public final String getUSERTAG() {
        return this.GetParamStringValue(TAG_USERTAG, "");
    }

    public final void setUSERTAG(String strValue) {
        this.SetParamValue(TAG_USERTAG, strValue);
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

    public final boolean isUSERTAG3Null() {
        return this.IsParamNull(TAG_USERTAG3);
    }

    public final String getUSERTAG3() {
        return this.GetParamStringValue(TAG_USERTAG3, "");
    }

    public final void setUSERTAG3(String strValue) {
        this.SetParamValue(TAG_USERTAG3, strValue);
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

    public final boolean isPSSYSAPPIDNull() {
        return this.IsParamNull(TAG_PSSYSAPPID);
    }

    public final String getPSSYSAPPID() {
        return this.GetParamStringValue(TAG_PSSYSAPPID, "");
    }

    public final void setPSSYSAPPID(String strValue) {
        this.SetParamValue(TAG_PSSYSAPPID, strValue);
    }

    public final boolean isPSSYSSERVICEAPIIDNull() {
        return this.IsParamNull(TAG_PSSYSSERVICEAPIID);
    }

    public final String getPSSYSSERVICEAPIID() {
        return this.GetParamStringValue(TAG_PSSYSSERVICEAPIID, "");
    }

    public final void setPSSYSSERVICEAPIID(String strValue) {
        this.SetParamValue(TAG_PSSYSSERVICEAPIID, strValue);
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

    public final boolean isORDERVALUENull() {
        return this.IsParamNull(TAG_ORDERVALUE);
    }

    public final int getORDERVALUE() {
        return this.GetParamIntValue(TAG_ORDERVALUE, 0);
    }

    public final void setORDERVALUE(int nValue) {
        this.SetParamValue(TAG_ORDERVALUE, nValue);
    }
}

