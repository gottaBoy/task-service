/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSAppViewRef
extends BaseDataEntity {
    public static final String TAG_PSAPPVIEWREFID = "PSAPPVIEWREFID";
    public static final String TAG_PSAPPVIEWREFNAME = "PSAPPVIEWREFNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MAJORPSAPPVIEWID = "MAJORPSAPPVIEWID";
    public static final String TAG_MAJORPSAPPVIEWNAME = "MAJORPSAPPVIEWNAME";
    public static final String TAG_MINORPSAPPVIEWID = "MINORPSAPPVIEWID";
    public static final String TAG_MINORPSAPPVIEWNAME = "MINORPSAPPVIEWNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_OPENMODE = "OPENMODE";
    public static final String TAG_WIDTH = "WIDTH";
    public static final String TAG_HEIGHT = "HEIGHT";
    public static final String TAG_TITLE = "TITLE";
    public static final String TAG_VIEWPARAMS = "VIEWPARAMS";
    public static final String TAG_TITLEPSLANRESID = "TITLEPSLANRESID";
    public static final String TAG_TITLEPSLANRESNAME = "TITLEPSLANRESNAME";
    public static final String TAG_REFMODETEXT = "REFMODETEXT";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";

    public final boolean isPSAPPVIEWREFIDNull() {
        return this.IsParamNull(TAG_PSAPPVIEWREFID);
    }

    public final String getPSAPPVIEWREFID() {
        return this.GetParamStringValue(TAG_PSAPPVIEWREFID, "");
    }

    public final void setPSAPPVIEWREFID(String strValue) {
        this.SetParamValue(TAG_PSAPPVIEWREFID, strValue);
    }

    public final boolean isPSAPPVIEWREFNAMENull() {
        return this.IsParamNull(TAG_PSAPPVIEWREFNAME);
    }

    public final String getPSAPPVIEWREFNAME() {
        return this.GetParamStringValue(TAG_PSAPPVIEWREFNAME, "");
    }

    public final void setPSAPPVIEWREFNAME(String strValue) {
        this.SetParamValue(TAG_PSAPPVIEWREFNAME, strValue);
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

    public final boolean isMAJORPSAPPVIEWIDNull() {
        return this.IsParamNull(TAG_MAJORPSAPPVIEWID);
    }

    public final String getMAJORPSAPPVIEWID() {
        return this.GetParamStringValue(TAG_MAJORPSAPPVIEWID, "");
    }

    public final void setMAJORPSAPPVIEWID(String strValue) {
        this.SetParamValue(TAG_MAJORPSAPPVIEWID, strValue);
    }

    public final boolean isMAJORPSAPPVIEWNAMENull() {
        return this.IsParamNull(TAG_MAJORPSAPPVIEWNAME);
    }

    public final String getMAJORPSAPPVIEWNAME() {
        return this.GetParamStringValue(TAG_MAJORPSAPPVIEWNAME, "");
    }

    public final void setMAJORPSAPPVIEWNAME(String strValue) {
        this.SetParamValue(TAG_MAJORPSAPPVIEWNAME, strValue);
    }

    public final boolean isMINORPSAPPVIEWIDNull() {
        return this.IsParamNull(TAG_MINORPSAPPVIEWID);
    }

    public final String getMINORPSAPPVIEWID() {
        return this.GetParamStringValue(TAG_MINORPSAPPVIEWID, "");
    }

    public final void setMINORPSAPPVIEWID(String strValue) {
        this.SetParamValue(TAG_MINORPSAPPVIEWID, strValue);
    }

    public final boolean isMINORPSAPPVIEWNAMENull() {
        return this.IsParamNull(TAG_MINORPSAPPVIEWNAME);
    }

    public final String getMINORPSAPPVIEWNAME() {
        return this.GetParamStringValue(TAG_MINORPSAPPVIEWNAME, "");
    }

    public final void setMINORPSAPPVIEWNAME(String strValue) {
        this.SetParamValue(TAG_MINORPSAPPVIEWNAME, strValue);
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

    public final boolean isOPENMODENull() {
        return this.IsParamNull(TAG_OPENMODE);
    }

    public final String getOPENMODE() {
        return this.GetParamStringValue(TAG_OPENMODE, "");
    }

    public final void setOPENMODE(String strValue) {
        this.SetParamValue(TAG_OPENMODE, strValue);
    }

    public final boolean isWIDTHNull() {
        return this.IsParamNull(TAG_WIDTH);
    }

    public final int getWIDTH() {
        return this.GetParamIntValue(TAG_WIDTH, 0);
    }

    public final void setWIDTH(int nValue) {
        this.SetParamValue(TAG_WIDTH, nValue);
    }

    public final boolean isHEIGHTNull() {
        return this.IsParamNull(TAG_HEIGHT);
    }

    public final int getHEIGHT() {
        return this.GetParamIntValue(TAG_HEIGHT, 0);
    }

    public final void setHEIGHT(int nValue) {
        this.SetParamValue(TAG_HEIGHT, nValue);
    }

    public final boolean isTITLENull() {
        return this.IsParamNull(TAG_TITLE);
    }

    public final String getTITLE() {
        return this.GetParamStringValue(TAG_TITLE, "");
    }

    public final void setTITLE(String strValue) {
        this.SetParamValue(TAG_TITLE, strValue);
    }

    public final boolean isVIEWPARAMSNull() {
        return this.IsParamNull(TAG_VIEWPARAMS);
    }

    public final String getVIEWPARAMS() {
        return this.GetParamStringValue(TAG_VIEWPARAMS, "");
    }

    public final void setVIEWPARAMS(String strValue) {
        this.SetParamValue(TAG_VIEWPARAMS, strValue);
    }

    public final boolean isTITLEPSLANRESIDNull() {
        return this.IsParamNull(TAG_TITLEPSLANRESID);
    }

    public final String getTITLEPSLANRESID() {
        return this.GetParamStringValue(TAG_TITLEPSLANRESID, "");
    }

    public final void setTITLEPSLANRESID(String strValue) {
        this.SetParamValue(TAG_TITLEPSLANRESID, strValue);
    }

    public final boolean isTITLEPSLANRESNAMENull() {
        return this.IsParamNull(TAG_TITLEPSLANRESNAME);
    }

    public final String getTITLEPSLANRESNAME() {
        return this.GetParamStringValue(TAG_TITLEPSLANRESNAME, "");
    }

    public final void setTITLEPSLANRESNAME(String strValue) {
        this.SetParamValue(TAG_TITLEPSLANRESNAME, strValue);
    }

    public final boolean isREFMODETEXTNull() {
        return this.IsParamNull(TAG_REFMODETEXT);
    }

    public final String getREFMODETEXT() {
        return this.GetParamStringValue(TAG_REFMODETEXT, "");
    }

    public final void setREFMODETEXT(String strValue) {
        this.SetParamValue(TAG_REFMODETEXT, strValue);
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
}

