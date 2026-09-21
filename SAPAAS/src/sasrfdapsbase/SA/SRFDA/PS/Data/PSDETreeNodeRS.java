/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDETreeNodeRS
extends BaseDataEntity {
    public static final String TAG_PSDETREENODERSID = "PSDETREENODERSID";
    public static final String TAG_PSDETREENODERSNAME = "PSDETREENODERSNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PROCESSPARAM = "PROCESSPARAM";
    public static final String TAG_CMCREATE = "CMCREATE";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSDETREEVIEWID = "PSDETREEVIEWID";
    public static final String TAG_PSDETREEVIEWNAME = "PSDETREEVIEWNAME";
    public static final String TAG_PPSDETREENODEID = "PPSDETREENODEID";
    public static final String TAG_PPSDETREENODENAME = "PPSDETREENODENAME";
    public static final String TAG_CPSDETREENODEID = "CPSDETREENODEID";
    public static final String TAG_CPSDETREENODENAME = "CPSDETREENODENAME";
    public static final String TAG_PSDEACTIONID = "PSDEACTIONID";
    public static final String TAG_PSDEACTIONNAME = "PSDEACTIONNAME";
    public static final String TAG_PSDERID = "PSDERID";
    public static final String TAG_PSDERNAME = "PSDERNAME";
    public static final String TAG_PVALUELEVEL = "PVALUELEVEL";
    public static final String TAG_SEARCHMODE = "SEARCHMODE";
    public static final String TAG_CHILDFILTER = "CHILDFILTER";
    public static final String TAG_CHILDFILTERDESC = "CHILDFILTERDESC";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";

    public final boolean isPSDETREENODERSIDNull() {
        return this.IsParamNull(TAG_PSDETREENODERSID);
    }

    public final String getPSDETREENODERSID() {
        return this.GetParamStringValue(TAG_PSDETREENODERSID, "");
    }

    public final void setPSDETREENODERSID(String strValue) {
        this.SetParamValue(TAG_PSDETREENODERSID, strValue);
    }

    public final boolean isPSDETREENODERSNAMENull() {
        return this.IsParamNull(TAG_PSDETREENODERSNAME);
    }

    public final String getPSDETREENODERSNAME() {
        return this.GetParamStringValue(TAG_PSDETREENODERSNAME, "");
    }

    public final void setPSDETREENODERSNAME(String strValue) {
        this.SetParamValue(TAG_PSDETREENODERSNAME, strValue);
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

    public final boolean isPROCESSPARAMNull() {
        return this.IsParamNull(TAG_PROCESSPARAM);
    }

    public final String getPROCESSPARAM() {
        return this.GetParamStringValue(TAG_PROCESSPARAM, "");
    }

    public final void setPROCESSPARAM(String strValue) {
        this.SetParamValue(TAG_PROCESSPARAM, strValue);
    }

    public final boolean isCMCREATENull() {
        return this.IsParamNull(TAG_CMCREATE);
    }

    public final boolean getCMCREATE() {
        return this.GetParamIntValue(TAG_CMCREATE, 0) == 1;
    }

    public final void setCMCREATE(boolean bValue) {
        this.SetParamValue(TAG_CMCREATE, bValue ? 1 : 0);
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

    public final boolean isPSDETREEVIEWIDNull() {
        return this.IsParamNull(TAG_PSDETREEVIEWID);
    }

    public final String getPSDETREEVIEWID() {
        return this.GetParamStringValue(TAG_PSDETREEVIEWID, "");
    }

    public final void setPSDETREEVIEWID(String strValue) {
        this.SetParamValue(TAG_PSDETREEVIEWID, strValue);
    }

    public final boolean isPSDETREEVIEWNAMENull() {
        return this.IsParamNull(TAG_PSDETREEVIEWNAME);
    }

    public final String getPSDETREEVIEWNAME() {
        return this.GetParamStringValue(TAG_PSDETREEVIEWNAME, "");
    }

    public final void setPSDETREEVIEWNAME(String strValue) {
        this.SetParamValue(TAG_PSDETREEVIEWNAME, strValue);
    }

    public final boolean isPPSDETREENODEIDNull() {
        return this.IsParamNull(TAG_PPSDETREENODEID);
    }

    public final String getPPSDETREENODEID() {
        return this.GetParamStringValue(TAG_PPSDETREENODEID, "");
    }

    public final void setPPSDETREENODEID(String strValue) {
        this.SetParamValue(TAG_PPSDETREENODEID, strValue);
    }

    public final boolean isPPSDETREENODENAMENull() {
        return this.IsParamNull(TAG_PPSDETREENODENAME);
    }

    public final String getPPSDETREENODENAME() {
        return this.GetParamStringValue(TAG_PPSDETREENODENAME, "");
    }

    public final void setPPSDETREENODENAME(String strValue) {
        this.SetParamValue(TAG_PPSDETREENODENAME, strValue);
    }

    public final boolean isCPSDETREENODEIDNull() {
        return this.IsParamNull(TAG_CPSDETREENODEID);
    }

    public final String getCPSDETREENODEID() {
        return this.GetParamStringValue(TAG_CPSDETREENODEID, "");
    }

    public final void setCPSDETREENODEID(String strValue) {
        this.SetParamValue(TAG_CPSDETREENODEID, strValue);
    }

    public final boolean isCPSDETREENODENAMENull() {
        return this.IsParamNull(TAG_CPSDETREENODENAME);
    }

    public final String getCPSDETREENODENAME() {
        return this.GetParamStringValue(TAG_CPSDETREENODENAME, "");
    }

    public final void setCPSDETREENODENAME(String strValue) {
        this.SetParamValue(TAG_CPSDETREENODENAME, strValue);
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

    public final boolean isPSDERIDNull() {
        return this.IsParamNull(TAG_PSDERID);
    }

    public final String getPSDERID() {
        return this.GetParamStringValue(TAG_PSDERID, "");
    }

    public final void setPSDERID(String strValue) {
        this.SetParamValue(TAG_PSDERID, strValue);
    }

    public final boolean isPSDERNAMENull() {
        return this.IsParamNull(TAG_PSDERNAME);
    }

    public final String getPSDERNAME() {
        return this.GetParamStringValue(TAG_PSDERNAME, "");
    }

    public final void setPSDERNAME(String strValue) {
        this.SetParamValue(TAG_PSDERNAME, strValue);
    }

    public final boolean isPVALUELEVELNull() {
        return this.IsParamNull(TAG_PVALUELEVEL);
    }

    public final int getPVALUELEVEL() {
        return this.GetParamIntValue(TAG_PVALUELEVEL, 0);
    }

    public final void setPVALUELEVEL(int nValue) {
        this.SetParamValue(TAG_PVALUELEVEL, nValue);
    }

    public final boolean isSEARCHMODENull() {
        return this.IsParamNull(TAG_SEARCHMODE);
    }

    public final int getSEARCHMODE() {
        return this.GetParamIntValue(TAG_SEARCHMODE, 0);
    }

    public final void setSEARCHMODE(int nValue) {
        this.SetParamValue(TAG_SEARCHMODE, nValue);
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

    public final boolean isCHILDFILTERNull() {
        return this.IsParamNull(TAG_CHILDFILTER);
    }

    public final String getCHILDFILTER() {
        return this.GetParamStringValue(TAG_CHILDFILTER, "");
    }

    public final void setCHILDFILTER(String strValue) {
        this.SetParamValue(TAG_CHILDFILTER, strValue);
    }

    public final boolean isCHILDFILTERDESCNull() {
        return this.IsParamNull(TAG_CHILDFILTERDESC);
    }

    public final String getCHILDFILTERDESC() {
        return this.GetParamStringValue(TAG_CHILDFILTERDESC, "");
    }

    public final void setCHILDFILTERDESC(String strValue) {
        this.SetParamValue(TAG_CHILDFILTERDESC, strValue);
    }
}

