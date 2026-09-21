/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.WT.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class WTServiceSession
extends BaseDataEntity {
    public static final String TAG_WTSERVICESESSIONID = "WTSERVICESESSIONID";
    public static final String TAG_WTSERVICESESSIONNAME = "WTSERVICESESSIONNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_WTSERVICEBASEID = "WTSERVICEBASEID";
    public static final String TAG_WTSERVICEBASENAME = "WTSERVICEBASENAME";
    public static final String TAG_WTUSERID = "WTUSERID";
    public static final String TAG_WTUSERNAME = "WTUSERNAME";
    public static final String TAG_CURSTEPSN = "CURSTEPSN";
    public static final String TAG_UP_S1 = "UP_S1";
    public static final String TAG_UP_S2 = "UP_S2";
    public static final String TAG_UP_S3 = "UP_S3";
    public static final String TAG_UP_S4 = "UP_S4";
    public static final String TAG_UP_S5 = "UP_S5";
    public static final String TAG_UP_LS1 = "UP_LS1";
    public static final String TAG_UP_LS2 = "UP_LS2";
    public static final String TAG_UP_I1 = "UP_I1";
    public static final String TAG_UP_I2 = "UP_I2";
    public static final String TAG_UP_F2 = "UP_F2";
    public static final String TAG_UP_F1 = "UP_F1";
    public static final String TAG_UP_T1 = "UP_T1";
    public static final String TAG_UP_T2 = "UP_T2";
    public static final String TAG_SERVICELOG = "SERVICELOG";
    public static final String TAG_NEXTSTEPSN = "NEXTSTEPSN";
    public static final String TAG_PREVWTSRVSESSIONID = "PREVWTSRVSESSIONID";
    public static final String TAG_PREVWTSRVSESSIONNAME = "PREVWTSRVSESSIONNAME";
    public static final String TAG_PREVWTSERVICEID = "PREVWTSERVICEID";
    public static final String TAG_PREVWTSERVICENAME = "PREVWTSERVICENAME";
    public static final String TAG_NEXTSVRSN = "NEXTSVRSN";
    public static final String TAG_STOPSESSION = "STOPSESSION";

    public final boolean isWTSERVICESESSIONIDNull() {
        return this.IsParamNull(TAG_WTSERVICESESSIONID);
    }

    public final String getWTSERVICESESSIONID() {
        return this.GetParamStringValue(TAG_WTSERVICESESSIONID, "");
    }

    public final void setWTSERVICESESSIONID(String strValue) {
        this.SetParamValue(TAG_WTSERVICESESSIONID, strValue);
    }

    public final boolean isWTSERVICESESSIONNAMENull() {
        return this.IsParamNull(TAG_WTSERVICESESSIONNAME);
    }

    public final String getWTSERVICESESSIONNAME() {
        return this.GetParamStringValue(TAG_WTSERVICESESSIONNAME, "");
    }

    public final void setWTSERVICESESSIONNAME(String strValue) {
        this.SetParamValue(TAG_WTSERVICESESSIONNAME, strValue);
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

    public final boolean isWTSERVICEBASEIDNull() {
        return this.IsParamNull(TAG_WTSERVICEBASEID);
    }

    public final String getWTSERVICEBASEID() {
        return this.GetParamStringValue(TAG_WTSERVICEBASEID, "");
    }

    public final void setWTSERVICEBASEID(String strValue) {
        this.SetParamValue(TAG_WTSERVICEBASEID, strValue);
    }

    public final boolean isWTSERVICEBASENAMENull() {
        return this.IsParamNull(TAG_WTSERVICEBASENAME);
    }

    public final String getWTSERVICEBASENAME() {
        return this.GetParamStringValue(TAG_WTSERVICEBASENAME, "");
    }

    public final void setWTSERVICEBASENAME(String strValue) {
        this.SetParamValue(TAG_WTSERVICEBASENAME, strValue);
    }

    public final boolean isWTUSERIDNull() {
        return this.IsParamNull(TAG_WTUSERID);
    }

    public final String getWTUSERID() {
        return this.GetParamStringValue(TAG_WTUSERID, "");
    }

    public final void setWTUSERID(String strValue) {
        this.SetParamValue(TAG_WTUSERID, strValue);
    }

    public final boolean isWTUSERNAMENull() {
        return this.IsParamNull(TAG_WTUSERNAME);
    }

    public final String getWTUSERNAME() {
        return this.GetParamStringValue(TAG_WTUSERNAME, "");
    }

    public final void setWTUSERNAME(String strValue) {
        this.SetParamValue(TAG_WTUSERNAME, strValue);
    }

    public final boolean isCURSTEPSNNull() {
        return this.IsParamNull(TAG_CURSTEPSN);
    }

    public final String getCURSTEPSN() {
        return this.GetParamStringValue(TAG_CURSTEPSN, "");
    }

    public final void setCURSTEPSN(String strValue) {
        this.SetParamValue(TAG_CURSTEPSN, strValue);
    }

    public final boolean isUP_S1Null() {
        return this.IsParamNull(TAG_UP_S1);
    }

    public final String getUP_S1() {
        return this.GetParamStringValue(TAG_UP_S1, "");
    }

    public final void setUP_S1(String strValue) {
        this.SetParamValue(TAG_UP_S1, strValue);
    }

    public final boolean isUP_S2Null() {
        return this.IsParamNull(TAG_UP_S2);
    }

    public final String getUP_S2() {
        return this.GetParamStringValue(TAG_UP_S2, "");
    }

    public final void setUP_S2(String strValue) {
        this.SetParamValue(TAG_UP_S2, strValue);
    }

    public final boolean isUP_S3Null() {
        return this.IsParamNull(TAG_UP_S3);
    }

    public final String getUP_S3() {
        return this.GetParamStringValue(TAG_UP_S3, "");
    }

    public final void setUP_S3(String strValue) {
        this.SetParamValue(TAG_UP_S3, strValue);
    }

    public final boolean isUP_S4Null() {
        return this.IsParamNull(TAG_UP_S4);
    }

    public final String getUP_S4() {
        return this.GetParamStringValue(TAG_UP_S4, "");
    }

    public final void setUP_S4(String strValue) {
        this.SetParamValue(TAG_UP_S4, strValue);
    }

    public final boolean isUP_S5Null() {
        return this.IsParamNull(TAG_UP_S5);
    }

    public final String getUP_S5() {
        return this.GetParamStringValue(TAG_UP_S5, "");
    }

    public final void setUP_S5(String strValue) {
        this.SetParamValue(TAG_UP_S5, strValue);
    }

    public final boolean isUP_LS1Null() {
        return this.IsParamNull(TAG_UP_LS1);
    }

    public final String getUP_LS1() {
        return this.GetParamStringValue(TAG_UP_LS1, "");
    }

    public final void setUP_LS1(String strValue) {
        this.SetParamValue(TAG_UP_LS1, strValue);
    }

    public final boolean isUP_LS2Null() {
        return this.IsParamNull(TAG_UP_LS2);
    }

    public final String getUP_LS2() {
        return this.GetParamStringValue(TAG_UP_LS2, "");
    }

    public final void setUP_LS2(String strValue) {
        this.SetParamValue(TAG_UP_LS2, strValue);
    }

    public final boolean isUP_I1Null() {
        return this.IsParamNull(TAG_UP_I1);
    }

    public final int getUP_I1() {
        return this.GetParamIntValue(TAG_UP_I1, 0);
    }

    public final void setUP_I1(int nValue) {
        this.SetParamValue(TAG_UP_I1, nValue);
    }

    public final boolean isUP_I2Null() {
        return this.IsParamNull(TAG_UP_I2);
    }

    public final int getUP_I2() {
        return this.GetParamIntValue(TAG_UP_I2, 0);
    }

    public final void setUP_I2(int nValue) {
        this.SetParamValue(TAG_UP_I2, nValue);
    }

    public final boolean isUP_F2Null() {
        return this.IsParamNull(TAG_UP_F2);
    }

    public final float getUP_F2() {
        return this.GetParamFloatValue(TAG_UP_F2, 0.0f);
    }

    public final void setUP_F2(float fValue) {
        this.SetParamValue(TAG_UP_F2, Float.valueOf(fValue));
    }

    public final boolean isUP_F1Null() {
        return this.IsParamNull(TAG_UP_F1);
    }

    public final float getUP_F1() {
        return this.GetParamFloatValue(TAG_UP_F1, 0.0f);
    }

    public final void setUP_F1(float fValue) {
        this.SetParamValue(TAG_UP_F1, Float.valueOf(fValue));
    }

    public final boolean isUP_T1Null() {
        return this.IsParamNull(TAG_UP_T1);
    }

    public final Date getUP_T1() {
        return this.GetParamDateValue(TAG_UP_T1, null);
    }

    public final void setUP_T1(Date dtValue) {
        this.SetParamValue(TAG_UP_T1, dtValue);
    }

    public final boolean isUP_T2Null() {
        return this.IsParamNull(TAG_UP_T2);
    }

    public final Date getUP_T2() {
        return this.GetParamDateValue(TAG_UP_T2, null);
    }

    public final void setUP_T2(Date dtValue) {
        this.SetParamValue(TAG_UP_T2, dtValue);
    }

    public final boolean isSERVICELOGNull() {
        return this.IsParamNull(TAG_SERVICELOG);
    }

    public final String getSERVICELOG() {
        return this.GetParamStringValue(TAG_SERVICELOG, "");
    }

    public final void setSERVICELOG(String strValue) {
        this.SetParamValue(TAG_SERVICELOG, strValue);
    }

    public final boolean isNEXTSTEPSNNull() {
        return this.IsParamNull(TAG_NEXTSTEPSN);
    }

    public final String getNEXTSTEPSN() {
        return this.GetParamStringValue(TAG_NEXTSTEPSN, "");
    }

    public final void setNEXTSTEPSN(String strValue) {
        this.SetParamValue(TAG_NEXTSTEPSN, strValue);
    }

    public final boolean isPREVWTSRVSESSIONIDNull() {
        return this.IsParamNull(TAG_PREVWTSRVSESSIONID);
    }

    public final String getPREVWTSRVSESSIONID() {
        return this.GetParamStringValue(TAG_PREVWTSRVSESSIONID, "");
    }

    public final void setPREVWTSRVSESSIONID(String strValue) {
        this.SetParamValue(TAG_PREVWTSRVSESSIONID, strValue);
    }

    public final boolean isPREVWTSRVSESSIONNAMENull() {
        return this.IsParamNull(TAG_PREVWTSRVSESSIONNAME);
    }

    public final String getPREVWTSRVSESSIONNAME() {
        return this.GetParamStringValue(TAG_PREVWTSRVSESSIONNAME, "");
    }

    public final void setPREVWTSRVSESSIONNAME(String strValue) {
        this.SetParamValue(TAG_PREVWTSRVSESSIONNAME, strValue);
    }

    public final boolean isPREVWTSERVICEIDNull() {
        return this.IsParamNull(TAG_PREVWTSERVICEID);
    }

    public final String getPREVWTSERVICEID() {
        return this.GetParamStringValue(TAG_PREVWTSERVICEID, "");
    }

    public final void setPREVWTSERVICEID(String strValue) {
        this.SetParamValue(TAG_PREVWTSERVICEID, strValue);
    }

    public final boolean isPREVWTSERVICENAMENull() {
        return this.IsParamNull(TAG_PREVWTSERVICENAME);
    }

    public final String getPREVWTSERVICENAME() {
        return this.GetParamStringValue(TAG_PREVWTSERVICENAME, "");
    }

    public final void setPREVWTSERVICENAME(String strValue) {
        this.SetParamValue(TAG_PREVWTSERVICENAME, strValue);
    }

    public final boolean isNEXTSVRSNNull() {
        return this.IsParamNull(TAG_NEXTSVRSN);
    }

    public final String getNEXTSVRSN() {
        return this.GetParamStringValue(TAG_NEXTSVRSN, "");
    }

    public final void setNEXTSVRSN(String strValue) {
        this.SetParamValue(TAG_NEXTSVRSN, strValue);
    }

    public final boolean isSTOPSESSIONNull() {
        return this.IsParamNull(TAG_STOPSESSION);
    }

    public final boolean getSTOPSESSION() {
        return this.GetParamIntValue(TAG_STOPSESSION, 0) == 1;
    }

    public final void setSTOPSESSION(boolean bValue) {
        this.SetParamValue(TAG_STOPSESSION, bValue ? 1 : 0);
    }
}

