/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDCRobotLog
extends BaseDataEntity {
    public static final String LOGLEVEL_DEBUG = "DEBUG";
    public static final String LOGLEVEL_INFO = "INFO";
    public static final String LOGLEVEL_WARN = "WARN";
    public static final String LOGLEVEL_ERROR = "ERROR";
    public static final String LOGLEVEL2_50000 = "50000";
    public static final String LOGLEVEL2_40000 = "40000";
    public static final String LOGLEVEL2_30000 = "30000";
    public static final String LOGLEVEL2_20000 = "20000";
    public static final String LOGLEVEL2_10000 = "10000";
    public static final String LOGLEVEL2_5000 = "5000";
    public static final String LOGTYPE_SYSBKTASK = "SYSBKTASK";
    public static final String LOGTYPE_DCBKTASK = "DCBKTASK";
    public static final String TAG_PSDCROBOTLOGID = "PSDCROBOTLOGID";
    public static final String TAG_PSDCROBOTLOGNAME = "PSDCROBOTLOGNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDCROBOTID = "PSDCROBOTID";
    public static final String TAG_PSDCROBOTNAME = "PSDCROBOTNAME";
    public static final String TAG_LOGINFO = "LOGINFO";
    public static final String TAG_LOGLEVEL = "LOGLEVEL";
    public static final String TAG_LOGLEVEL2 = "LOGLEVEL2";
    public static final String TAG_LOGTYPE = "LOGTYPE";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_ENERGY = "ENERGY";

    public final boolean isPSDCROBOTLOGIDNull() {
        return this.IsParamNull(TAG_PSDCROBOTLOGID);
    }

    public final String getPSDCROBOTLOGID() {
        return this.GetParamStringValue(TAG_PSDCROBOTLOGID, "");
    }

    public final void setPSDCROBOTLOGID(String strValue) {
        this.SetParamValue(TAG_PSDCROBOTLOGID, strValue);
    }

    public final boolean isPSDCROBOTLOGNAMENull() {
        return this.IsParamNull(TAG_PSDCROBOTLOGNAME);
    }

    public final String getPSDCROBOTLOGNAME() {
        return this.GetParamStringValue(TAG_PSDCROBOTLOGNAME, "");
    }

    public final void setPSDCROBOTLOGNAME(String strValue) {
        this.SetParamValue(TAG_PSDCROBOTLOGNAME, strValue);
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

    public final boolean isPSDCROBOTIDNull() {
        return this.IsParamNull(TAG_PSDCROBOTID);
    }

    public final String getPSDCROBOTID() {
        return this.GetParamStringValue(TAG_PSDCROBOTID, "");
    }

    public final void setPSDCROBOTID(String strValue) {
        this.SetParamValue(TAG_PSDCROBOTID, strValue);
    }

    public final boolean isPSDCROBOTNAMENull() {
        return this.IsParamNull(TAG_PSDCROBOTNAME);
    }

    public final String getPSDCROBOTNAME() {
        return this.GetParamStringValue(TAG_PSDCROBOTNAME, "");
    }

    public final void setPSDCROBOTNAME(String strValue) {
        this.SetParamValue(TAG_PSDCROBOTNAME, strValue);
    }

    public final boolean isLOGINFONull() {
        return this.IsParamNull(TAG_LOGINFO);
    }

    public final String getLOGINFO() {
        return this.GetParamStringValue(TAG_LOGINFO, "");
    }

    public final void setLOGINFO(String strValue) {
        this.SetParamValue(TAG_LOGINFO, strValue);
    }

    public final boolean isLOGLEVELNull() {
        return this.IsParamNull(TAG_LOGLEVEL);
    }

    public final String getLOGLEVEL() {
        return this.GetParamStringValue(TAG_LOGLEVEL, "");
    }

    public final void setLOGLEVEL(String strValue) {
        this.SetParamValue(TAG_LOGLEVEL, strValue);
    }

    public final boolean isLOGLEVEL2Null() {
        return this.IsParamNull(TAG_LOGLEVEL2);
    }

    public final int getLOGLEVEL2() {
        return this.GetParamIntValue(TAG_LOGLEVEL2, 0);
    }

    public final void setLOGLEVEL2(int nValue) {
        this.SetParamValue(TAG_LOGLEVEL2, nValue);
    }

    public final boolean isLOGTYPENull() {
        return this.IsParamNull(TAG_LOGTYPE);
    }

    public final String getLOGTYPE() {
        return this.GetParamStringValue(TAG_LOGTYPE, "");
    }

    public final void setLOGTYPE(String strValue) {
        this.SetParamValue(TAG_LOGTYPE, strValue);
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

    public final boolean isENERGYNull() {
        return this.IsParamNull(TAG_ENERGY);
    }

    public final int getENERGY() {
        return this.GetParamIntValue(TAG_ENERGY, 0);
    }

    public final void setENERGY(int nValue) {
        this.SetParamValue(TAG_ENERGY, nValue);
    }
}

