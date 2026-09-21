/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDEFInputTipSet
extends BaseDataEntity {
    public static final String TAG_PSDEFINPUTTIPSETID = "PSDEFINPUTTIPSETID";
    public static final String TAG_PSDEFINPUTTIPSETNAME = "PSDEFINPUTTIPSETNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_PSDEDATASETID = "PSDEDATASETID";
    public static final String TAG_PSDEDATASETNAME = "PSDEDATASETNAME";
    public static final String TAG_CONTENTPSDEFID = "CONTENTPSDEFID";
    public static final String TAG_CONTENTPSDEFNAME = "CONTENTPSDEFNAME";
    public static final String TAG_UNIQUETAGPSDEFID = "UNIQUETAGPSDEFID";
    public static final String TAG_UNIQUETAGPSDEFNAME = "UNIQUETAGPSDEFNAME";
    public static final String TAG_LINKPSDEFID = "LINKPSDEFID";
    public static final String TAG_LINKPSDEFNAME = "LINKPSDEFNAME";
    public static final String TAG_ECPSDEFID = "ECPSDEFID";
    public static final String TAG_ECPSDEFNAME = "ECPSDEFNAME";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSMODULEID = "PSMODULEID";
    public static final String TAG_PSMODULENAME = "PSMODULENAME";
    public static final String TAG_LOCKFLAG = "LOCKFLAG";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String TAG_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String TAG_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String TAG_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";

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

    public final boolean isPSDEDATASETIDNull() {
        return this.IsParamNull(TAG_PSDEDATASETID);
    }

    public final String getPSDEDATASETID() {
        return this.GetParamStringValue(TAG_PSDEDATASETID, "");
    }

    public final void setPSDEDATASETID(String strValue) {
        this.SetParamValue(TAG_PSDEDATASETID, strValue);
    }

    public final boolean isPSDEDATASETNAMENull() {
        return this.IsParamNull(TAG_PSDEDATASETNAME);
    }

    public final String getPSDEDATASETNAME() {
        return this.GetParamStringValue(TAG_PSDEDATASETNAME, "");
    }

    public final void setPSDEDATASETNAME(String strValue) {
        this.SetParamValue(TAG_PSDEDATASETNAME, strValue);
    }

    public final boolean isCONTENTPSDEFIDNull() {
        return this.IsParamNull(TAG_CONTENTPSDEFID);
    }

    public final String getCONTENTPSDEFID() {
        return this.GetParamStringValue(TAG_CONTENTPSDEFID, "");
    }

    public final void setCONTENTPSDEFID(String strValue) {
        this.SetParamValue(TAG_CONTENTPSDEFID, strValue);
    }

    public final boolean isCONTENTPSDEFNAMENull() {
        return this.IsParamNull(TAG_CONTENTPSDEFNAME);
    }

    public final String getCONTENTPSDEFNAME() {
        return this.GetParamStringValue(TAG_CONTENTPSDEFNAME, "");
    }

    public final void setCONTENTPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_CONTENTPSDEFNAME, strValue);
    }

    public final boolean isUNIQUETAGPSDEFIDNull() {
        return this.IsParamNull(TAG_UNIQUETAGPSDEFID);
    }

    public final String getUNIQUETAGPSDEFID() {
        return this.GetParamStringValue(TAG_UNIQUETAGPSDEFID, "");
    }

    public final void setUNIQUETAGPSDEFID(String strValue) {
        this.SetParamValue(TAG_UNIQUETAGPSDEFID, strValue);
    }

    public final boolean isUNIQUETAGPSDEFNAMENull() {
        return this.IsParamNull(TAG_UNIQUETAGPSDEFNAME);
    }

    public final String getUNIQUETAGPSDEFNAME() {
        return this.GetParamStringValue(TAG_UNIQUETAGPSDEFNAME, "");
    }

    public final void setUNIQUETAGPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_UNIQUETAGPSDEFNAME, strValue);
    }

    public final boolean isLINKPSDEFIDNull() {
        return this.IsParamNull(TAG_LINKPSDEFID);
    }

    public final String getLINKPSDEFID() {
        return this.GetParamStringValue(TAG_LINKPSDEFID, "");
    }

    public final void setLINKPSDEFID(String strValue) {
        this.SetParamValue(TAG_LINKPSDEFID, strValue);
    }

    public final boolean isLINKPSDEFNAMENull() {
        return this.IsParamNull(TAG_LINKPSDEFNAME);
    }

    public final String getLINKPSDEFNAME() {
        return this.GetParamStringValue(TAG_LINKPSDEFNAME, "");
    }

    public final void setLINKPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_LINKPSDEFNAME, strValue);
    }

    public final boolean isECPSDEFIDNull() {
        return this.IsParamNull(TAG_ECPSDEFID);
    }

    public final String getECPSDEFID() {
        return this.GetParamStringValue(TAG_ECPSDEFID, "");
    }

    public final void setECPSDEFID(String strValue) {
        this.SetParamValue(TAG_ECPSDEFID, strValue);
    }

    public final boolean isECPSDEFNAMENull() {
        return this.IsParamNull(TAG_ECPSDEFNAME);
    }

    public final String getECPSDEFNAME() {
        return this.GetParamStringValue(TAG_ECPSDEFNAME, "");
    }

    public final void setECPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_ECPSDEFNAME, strValue);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
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

    public final boolean isLOCKFLAGNull() {
        return this.IsParamNull(TAG_LOCKFLAG);
    }

    public final boolean getLOCKFLAG() {
        return this.GetParamIntValue(TAG_LOCKFLAG, 0) == 1;
    }

    public final void setLOCKFLAG(boolean bValue) {
        this.SetParamValue(TAG_LOCKFLAG, bValue ? 1 : 0);
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

    public final boolean isUSERCATNull() {
        return this.IsParamNull(TAG_USERCAT);
    }

    public final String getUSERCAT() {
        return this.GetParamStringValue(TAG_USERCAT, "");
    }

    public final boolean isPSSYSPFPLUGINIDNull() {
        return this.IsParamNull(TAG_PSSYSPFPLUGINID);
    }

    public final String getPSSYSPFPLUGINID() {
        return this.GetParamStringValue(TAG_PSSYSPFPLUGINID, "");
    }

    public final void setPSSYSPFPLUGINID(String strValue) {
        this.SetParamValue(TAG_PSSYSPFPLUGINID, strValue);
    }

    public final boolean isPSSYSPFPLUGINNAMENull() {
        return this.IsParamNull(TAG_PSSYSPFPLUGINNAME);
    }

    public final String getPSSYSPFPLUGINNAME() {
        return this.GetParamStringValue(TAG_PSSYSPFPLUGINNAME, "");
    }

    public final void setPSSYSPFPLUGINNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSPFPLUGINNAME, strValue);
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

