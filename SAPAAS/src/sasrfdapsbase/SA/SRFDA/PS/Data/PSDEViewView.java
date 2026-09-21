/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDEViewView
extends BaseDataEntity {
    public static final String TAG_PSDEVIEWRVID = "PSDEVIEWRVID";
    public static final String TAG_PSDEVIEWRVNAME = "PSDEVIEWRVNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MAJORPSDEVIEWID = "MAJORPSDEVIEWID";
    public static final String TAG_MAJORPSDEVIEWNAME = "MAJORPSDEVIEWNAME";
    public static final String TAG_MINORPSDEVIEWID = "MINORPSDEVIEWID";
    public static final String TAG_MINORPSDEVIEWNAME = "MINORPSDEVIEWNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_DEFVIEWTYPE = "DEFVIEWTYPE";
    public static final String TAG_OPENMODE = "OPENMODE";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_VIEWPARAMS = "VIEWPARAMS";

    public final boolean isPSDEVIEWRVIDNull() {
        return this.IsParamNull(TAG_PSDEVIEWRVID);
    }

    public final String getPSDEVIEWRVID() {
        return this.GetParamStringValue(TAG_PSDEVIEWRVID, "");
    }

    public final void setPSDEVIEWRVID(String strValue) {
        this.SetParamValue(TAG_PSDEVIEWRVID, strValue);
    }

    public final boolean isPSDEVIEWRVNAMENull() {
        return this.IsParamNull(TAG_PSDEVIEWRVNAME);
    }

    public final String getPSDEVIEWRVNAME() {
        return this.GetParamStringValue(TAG_PSDEVIEWRVNAME, "");
    }

    public final void setPSDEVIEWRVNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVIEWRVNAME, strValue);
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

    public final boolean isMAJORPSDEVIEWIDNull() {
        return this.IsParamNull(TAG_MAJORPSDEVIEWID);
    }

    public final String getMAJORPSDEVIEWID() {
        return this.GetParamStringValue(TAG_MAJORPSDEVIEWID, "");
    }

    public final void setMAJORPSDEVIEWID(String strValue) {
        this.SetParamValue(TAG_MAJORPSDEVIEWID, strValue);
    }

    public final boolean isMAJORPSDEVIEWNAMENull() {
        return this.IsParamNull(TAG_MAJORPSDEVIEWNAME);
    }

    public final String getMAJORPSDEVIEWNAME() {
        return this.GetParamStringValue(TAG_MAJORPSDEVIEWNAME, "");
    }

    public final void setMAJORPSDEVIEWNAME(String strValue) {
        this.SetParamValue(TAG_MAJORPSDEVIEWNAME, strValue);
    }

    public final boolean isMINORPSDEVIEWIDNull() {
        return this.IsParamNull(TAG_MINORPSDEVIEWID);
    }

    public final String getMINORPSDEVIEWID() {
        return this.GetParamStringValue(TAG_MINORPSDEVIEWID, "");
    }

    public final void setMINORPSDEVIEWID(String strValue) {
        this.SetParamValue(TAG_MINORPSDEVIEWID, strValue);
    }

    public final boolean isMINORPSDEVIEWNAMENull() {
        return this.IsParamNull(TAG_MINORPSDEVIEWNAME);
    }

    public final String getMINORPSDEVIEWNAME() {
        return this.GetParamStringValue(TAG_MINORPSDEVIEWNAME, "");
    }

    public final void setMINORPSDEVIEWNAME(String strValue) {
        this.SetParamValue(TAG_MINORPSDEVIEWNAME, strValue);
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

    public final boolean isDEFVIEWTYPENull() {
        return this.IsParamNull(TAG_DEFVIEWTYPE);
    }

    public final String getDEFVIEWTYPE() {
        return this.GetParamStringValue(TAG_DEFVIEWTYPE, "");
    }

    public final void setDEFVIEWTYPE(String strValue) {
        this.SetParamValue(TAG_DEFVIEWTYPE, strValue);
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

    public final boolean isVIEWPARAMSNull() {
        return this.IsParamNull(TAG_VIEWPARAMS);
    }

    public final String getVIEWPARAMS() {
        return this.GetParamStringValue(TAG_VIEWPARAMS, "");
    }

    public final void setVIEWPARAMS(String strValue) {
        this.SetParamValue(TAG_VIEWPARAMS, strValue);
    }
}

