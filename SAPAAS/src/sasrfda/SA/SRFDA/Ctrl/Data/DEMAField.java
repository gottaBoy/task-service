/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class DEMAField
extends BaseDataEntity {
    public static final String UPDATEMODE_NOTUPDATE = "NOTUPDATE";
    public static final String UPDATEMODE_UPDATENULL = "UPDATENULL";
    public static final String UPDATEMODE_UPDATEOV = "UPDATEOV";
    public static final String UPDATEMODE_UPDATEOVWHENNULL = "UPDATEOVWHENNULL";
    public static final String TAG_DEMAFIELDID = "DEMAFIELDID";
    public static final String TAG_DEMAFIELDNAME = "DEMAFIELDNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DEMAINACTIONID = "DEMAINACTIONID";
    public static final String TAG_DEMAINACTIONNAME = "DEMAINACTIONNAME";
    public static final String TAG_DEFID = "DEFID";
    public static final String TAG_DEFNAME = "DEFNAME";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_CODELISTID = "CODELISTID";
    public static final String TAG_CODELISTNAME = "CODELISTNAME";
    public static final String TAG_FORMITEMSTYLE = "FORMITEMSTYLE";
    public static final String TAG_ISENABLEMODIFY = "ISENABLEMODIFY";
    public static final String TAG_UPDATEMODE = "UPDATEMODE";
    public static final String TAG_UPDATEVALUE = "UPDATEVALUE";
    public static final String TAG_CHECKDATAACTION = "CHECKDATAACTION";

    public final boolean isDEMAFIELDIDNull() {
        return this.IsParamNull(TAG_DEMAFIELDID);
    }

    public final String getDEMAFIELDID() {
        return this.GetParamStringValue(TAG_DEMAFIELDID, "");
    }

    public final void setDEMAFIELDID(String strValue) {
        this.SetParamValue(TAG_DEMAFIELDID, strValue);
    }

    public final boolean isDEMAFIELDNAMENull() {
        return this.IsParamNull(TAG_DEMAFIELDNAME);
    }

    public final String getDEMAFIELDNAME() {
        return this.GetParamStringValue(TAG_DEMAFIELDNAME, "");
    }

    public final void setDEMAFIELDNAME(String strValue) {
        this.SetParamValue(TAG_DEMAFIELDNAME, strValue);
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

    public final boolean isDEMAINACTIONIDNull() {
        return this.IsParamNull(TAG_DEMAINACTIONID);
    }

    public final String getDEMAINACTIONID() {
        return this.GetParamStringValue(TAG_DEMAINACTIONID, "");
    }

    public final void setDEMAINACTIONID(String strValue) {
        this.SetParamValue(TAG_DEMAINACTIONID, strValue);
    }

    public final boolean isDEMAINACTIONNAMENull() {
        return this.IsParamNull(TAG_DEMAINACTIONNAME);
    }

    public final String getDEMAINACTIONNAME() {
        return this.GetParamStringValue(TAG_DEMAINACTIONNAME, "");
    }

    public final void setDEMAINACTIONNAME(String strValue) {
        this.SetParamValue(TAG_DEMAINACTIONNAME, strValue);
    }

    public final boolean isDEFIDNull() {
        return this.IsParamNull(TAG_DEFID);
    }

    public final String getDEFID() {
        return this.GetParamStringValue(TAG_DEFID, "");
    }

    public final void setDEFID(String strValue) {
        this.SetParamValue(TAG_DEFID, strValue);
    }

    public final boolean isDEFNAMENull() {
        return this.IsParamNull(TAG_DEFNAME);
    }

    public final String getDEFNAME() {
        return this.GetParamStringValue(TAG_DEFNAME, "");
    }

    public final void setDEFNAME(String strValue) {
        this.SetParamValue(TAG_DEFNAME, strValue);
    }

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
    }

    public final boolean isCODELISTIDNull() {
        return this.IsParamNull(TAG_CODELISTID);
    }

    public final String getCODELISTID() {
        return this.GetParamStringValue(TAG_CODELISTID, "");
    }

    public final void setCODELISTID(String strValue) {
        this.SetParamValue(TAG_CODELISTID, strValue);
    }

    public final boolean isCODELISTNAMENull() {
        return this.IsParamNull(TAG_CODELISTNAME);
    }

    public final String getCODELISTNAME() {
        return this.GetParamStringValue(TAG_CODELISTNAME, "");
    }

    public final void setCODELISTNAME(String strValue) {
        this.SetParamValue(TAG_CODELISTNAME, strValue);
    }

    public final boolean isFORMITEMSTYLENull() {
        return this.IsParamNull(TAG_FORMITEMSTYLE);
    }

    public final String getFORMITEMSTYLE() {
        return this.GetParamStringValue(TAG_FORMITEMSTYLE, "");
    }

    public final void setFORMITEMSTYLE(String strValue) {
        this.SetParamValue(TAG_FORMITEMSTYLE, strValue);
    }

    public final boolean isISENABLEMODIFYNull() {
        return this.IsParamNull(TAG_ISENABLEMODIFY);
    }

    public final boolean getISENABLEMODIFY() {
        return this.GetParamIntValue(TAG_ISENABLEMODIFY, 0) == 1;
    }

    public final void setISENABLEMODIFY(boolean bValue) {
        this.SetParamValue(TAG_ISENABLEMODIFY, bValue ? 1 : 0);
    }

    public final boolean isUPDATEMODENull() {
        return this.IsParamNull(TAG_UPDATEMODE);
    }

    public final String getUPDATEMODE() {
        return this.GetParamStringValue(TAG_UPDATEMODE, "");
    }

    public final void setUPDATEMODE(String strValue) {
        this.SetParamValue(TAG_UPDATEMODE, strValue);
    }

    public final boolean isUPDATEVALUENull() {
        return this.IsParamNull(TAG_UPDATEVALUE);
    }

    public final String getUPDATEVALUE() {
        return this.GetParamStringValue(TAG_UPDATEVALUE, "");
    }

    public final void setUPDATEVALUE(String strValue) {
        this.SetParamValue(TAG_UPDATEVALUE, strValue);
    }

    public final boolean isCHECKDATAACTIONNull() {
        return this.IsParamNull(TAG_CHECKDATAACTION);
    }

    public final String getCHECKDATAACTION() {
        return this.GetParamStringValue(TAG_CHECKDATAACTION, "");
    }

    public final void setCHECKDATAACTION(String strValue) {
        this.SetParamValue(TAG_CHECKDATAACTION, strValue);
    }
}

