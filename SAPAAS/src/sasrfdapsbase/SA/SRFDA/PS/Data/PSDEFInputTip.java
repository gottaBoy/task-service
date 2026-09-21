/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDEFInputTip
extends BaseDataEntity {
    public static final String TIPMODE_MODE = "MODE";
    public static final String TIPMODE_MODE2 = "MODE2";
    public static final String TIPMODE_MODE3 = "MODE3";
    public static final String TIPMODE_MODE4 = "MODE4";
    public static final String TIPMODE_MODE5 = "MODE5";
    public static final String TIPMODE_MODE6 = "MODE6";
    public static final String TIPMODE_MODE7 = "MODE7";
    public static final String TIPMODE_MODE8 = "MODE8";
    public static final String TIPMODE_MODE9 = "MODE9";
    public static final String TAG_PSDEFINPUTTIPID = "PSDEFINPUTTIPID";
    public static final String TAG_PSDEFINPUTTIPNAME = "PSDEFINPUTTIPNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_PSDEFID = "PSDEFID";
    public static final String TAG_PSDEFNAME = "PSDEFNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_CONTENT = "CONTENT";
    public static final String TAG_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_ENABLECLOSE = "ENABLECLOSE";
    public static final String TAG_MOREURL = "MOREURL";
    public static final String TAG_CONTENTPSLANRESID = "CONTENTPSLANRESID";
    public static final String TAG_CONTENTPSLANRESNAME = "CONTENTPSLANRESNAME";
    public static final String TAG_PSDEFINPUTTIPSETID = "PSDEFINPUTTIPSETID";
    public static final String TAG_PSDEFINPUTTIPSETNAME = "PSDEFINPUTTIPSETNAME";
    public static final String TAG_UNIQUETAG = "UNIQUETAG";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_TIPMODE = "TIPMODE";
    public static final String TAG_RAWCONTENT = "RAWCONTENT";

    public final boolean isPSDEFINPUTTIPIDNull() {
        return this.IsParamNull(TAG_PSDEFINPUTTIPID);
    }

    public final String getPSDEFINPUTTIPID() {
        return this.GetParamStringValue(TAG_PSDEFINPUTTIPID, "");
    }

    public final void setPSDEFINPUTTIPID(String strValue) {
        this.SetParamValue(TAG_PSDEFINPUTTIPID, strValue);
    }

    public final boolean isPSDEFINPUTTIPNAMENull() {
        return this.IsParamNull(TAG_PSDEFINPUTTIPNAME);
    }

    public final String getPSDEFINPUTTIPNAME() {
        return this.GetParamStringValue(TAG_PSDEFINPUTTIPNAME, "");
    }

    public final void setPSDEFINPUTTIPNAME(String strValue) {
        this.SetParamValue(TAG_PSDEFINPUTTIPNAME, strValue);
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

    public final boolean isPSDEFIDNull() {
        return this.IsParamNull(TAG_PSDEFID);
    }

    public final String getPSDEFID() {
        return this.GetParamStringValue(TAG_PSDEFID, "");
    }

    public final void setPSDEFID(String strValue) {
        this.SetParamValue(TAG_PSDEFID, strValue);
    }

    public final boolean isPSDEFNAMENull() {
        return this.IsParamNull(TAG_PSDEFNAME);
    }

    public final String getPSDEFNAME() {
        return this.GetParamStringValue(TAG_PSDEFNAME, "");
    }

    public final void setPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_PSDEFNAME, strValue);
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

    public final boolean isCONTENTNull() {
        return this.IsParamNull(TAG_CONTENT);
    }

    public final String getCONTENT() {
        return this.GetParamStringValue(TAG_CONTENT, "");
    }

    public final void setCONTENT(String strValue) {
        this.SetParamValue(TAG_CONTENT, strValue);
    }

    public final boolean isDEFAULTFLAGNull() {
        return this.IsParamNull(TAG_DEFAULTFLAG);
    }

    public final boolean getDEFAULTFLAG() {
        return this.GetParamIntValue(TAG_DEFAULTFLAG, 0) == 1;
    }

    public final void setDEFAULTFLAG(boolean bValue) {
        this.SetParamValue(TAG_DEFAULTFLAG, bValue ? 1 : 0);
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

    public final boolean isENABLECLOSENull() {
        return this.IsParamNull(TAG_ENABLECLOSE);
    }

    public final boolean getENABLECLOSE() {
        return this.GetParamIntValue(TAG_ENABLECLOSE, 0) == 1;
    }

    public final void setENABLECLOSE(boolean bValue) {
        this.SetParamValue(TAG_ENABLECLOSE, bValue ? 1 : 0);
    }

    public final boolean isMOREURLNull() {
        return this.IsParamNull(TAG_MOREURL);
    }

    public final String getMOREURL() {
        return this.GetParamStringValue(TAG_MOREURL, "");
    }

    public final void setMOREURL(String strValue) {
        this.SetParamValue(TAG_MOREURL, strValue);
    }

    public final boolean isCONTENTPSLANRESIDNull() {
        return this.IsParamNull(TAG_CONTENTPSLANRESID);
    }

    public final String getCONTENTPSLANRESID() {
        return this.GetParamStringValue(TAG_CONTENTPSLANRESID, "");
    }

    public final void setCONTENTPSLANRESID(String strValue) {
        this.SetParamValue(TAG_CONTENTPSLANRESID, strValue);
    }

    public final boolean isCONTENTPSLANRESNAMENull() {
        return this.IsParamNull(TAG_CONTENTPSLANRESNAME);
    }

    public final String getCONTENTPSLANRESNAME() {
        return this.GetParamStringValue(TAG_CONTENTPSLANRESNAME, "");
    }

    public final void setCONTENTPSLANRESNAME(String strValue) {
        this.SetParamValue(TAG_CONTENTPSLANRESNAME, strValue);
    }

    public final boolean isPSDEFINPUTTIPSETIDNull() {
        return this.IsParamNull(TAG_PSDEFINPUTTIPSETID);
    }

    public final String getPSDEFINPUTTIPSETID() {
        return this.GetParamStringValue(TAG_PSDEFINPUTTIPSETID, "");
    }

    public final void setPSDEFINPUTTIPSETID(String strValue) {
        this.SetParamValue(TAG_PSDEFINPUTTIPSETID, strValue);
    }

    public final boolean isPSDEFINPUTTIPSETNAMENull() {
        return this.IsParamNull(TAG_PSDEFINPUTTIPSETNAME);
    }

    public final String getPSDEFINPUTTIPSETNAME() {
        return this.GetParamStringValue(TAG_PSDEFINPUTTIPSETNAME, "");
    }

    public final void setPSDEFINPUTTIPSETNAME(String strValue) {
        this.SetParamValue(TAG_PSDEFINPUTTIPSETNAME, strValue);
    }

    public final boolean isUNIQUETAGNull() {
        return this.IsParamNull(TAG_UNIQUETAG);
    }

    public final String getUNIQUETAG() {
        return this.GetParamStringValue(TAG_UNIQUETAG, "");
    }

    public final void setUNIQUETAG(String strValue) {
        this.SetParamValue(TAG_UNIQUETAG, strValue);
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

    public final boolean isCODENAMENull() {
        return this.IsParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.GetParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.SetParamValue(TAG_CODENAME, strValue);
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

    public final boolean isTIPMODENull() {
        return this.IsParamNull(TAG_TIPMODE);
    }

    public final String getTIPMODE() {
        return this.GetParamStringValue(TAG_TIPMODE, "");
    }

    public final void setTIPMODE(String strValue) {
        this.SetParamValue(TAG_TIPMODE, strValue);
    }

    public final boolean isRAWCONTENTNull() {
        return this.IsParamNull(TAG_RAWCONTENT);
    }

    public final String getRAWCONTENT() {
        return this.GetParamStringValue(TAG_RAWCONTENT, "");
    }

    public final void setRAWCONTENT(String strValue) {
        this.SetParamValue(TAG_RAWCONTENT, strValue);
    }
}

