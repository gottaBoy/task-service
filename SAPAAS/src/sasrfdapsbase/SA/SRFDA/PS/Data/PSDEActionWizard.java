/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDEActionWizard
extends BaseDataEntity {
    public static final String TAG_PSDEACTIONWIZARDID = "PSDEACTIONWIZARDID";
    public static final String TAG_PSDEACTIONWIZARDNAME = "PSDEACTIONWIZARDNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_KEYWORDS = "KEYWORDS";
    public static final String TAG_PSDEVIEWBASEID = "PSDEVIEWBASEID";
    public static final String TAG_PSDEVIEWBASENAME = "PSDEVIEWBASENAME";
    public static final String TAG_DYNAMICMODE = "DYNAMICMODE";
    public static final String TAG_AWPSDEID = "AWPSDEID";
    public static final String TAG_AWPSDENAME = "AWPSDENAME";
    public static final String TAG_AWIPSDEID = "AWIPSDEID";
    public static final String TAG_AWIPSDENAME = "AWIPSDENAME";
    public static final String TAG_AWPSDEDSID = "AWPSDEDSID";
    public static final String TAG_AWPSDEDSNAME = "AWPSDEDSNAME";
    public static final String TAG_AWIPSDEDSID = "AWIPSDEDSID";
    public static final String TAG_AWIPSDEDSNAME = "AWIPSDEDSNAME";
    public static final String TAG_AWNAMEPSDEFID = "AWNAMEPSDEFID";
    public static final String TAG_AWNAMEPSDEFNAME = "AWNAMEPSDEFNAME";
    public static final String TAG_AWKWPSDEFID = "AWKWPSDEFID";
    public static final String TAG_AWKWPSDEFNAME = "AWKWPSDEFNAME";
    public static final String TAG_AWSORTPSDEFID = "AWSORTPSDEFID";
    public static final String TAG_AWSORTPSDEFNAME = "AWSORTPSDEFNAME";
    public static final String TAG_AWINAMEPSDEFID = "AWINAMEPSDEFID";
    public static final String TAG_AWINAMEPSDEFNAME = "AWINAMEPSDEFNAME";
    public static final String TAG_AWIVALUEPSDEFID = "AWIVALUEPSDEFID";
    public static final String TAG_AWIVALUEPSDEFNAME = "AWIVALUEPSDEFNAME";
    public static final String TAG_AWICONTENTPSDEFID = "AWICONTENTPSDEFID";
    public static final String TAG_AWICONTENTPSDEFNAME = "AWICONTENTPSDEFNAME";
    public static final String TAG_AWIURLPSDEFID = "AWIURLPSDEFID";
    public static final String TAG_AWIURLPSDEFNAME = "AWIURLPSDEFNAME";
    public static final String TAG_AWISORTPSDEFID = "AWISORTPSDEFID";
    public static final String TAG_AWISORTPSDEFNAME = "AWISORTPSDEFNAME";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_AWIFKEYPSDEFID = "AWIFKEYPSDEFID";
    public static final String TAG_AWIFKEYPSDEFNAME = "AWIFKEYPSDEFNAME";

    public final boolean isPSDEACTIONWIZARDIDNull() {
        return this.IsParamNull(TAG_PSDEACTIONWIZARDID);
    }

    public final String getPSDEACTIONWIZARDID() {
        return this.GetParamStringValue(TAG_PSDEACTIONWIZARDID, "");
    }

    public final void setPSDEACTIONWIZARDID(String strValue) {
        this.SetParamValue(TAG_PSDEACTIONWIZARDID, strValue);
    }

    public final boolean isPSDEACTIONWIZARDNAMENull() {
        return this.IsParamNull(TAG_PSDEACTIONWIZARDNAME);
    }

    public final String getPSDEACTIONWIZARDNAME() {
        return this.GetParamStringValue(TAG_PSDEACTIONWIZARDNAME, "");
    }

    public final void setPSDEACTIONWIZARDNAME(String strValue) {
        this.SetParamValue(TAG_PSDEACTIONWIZARDNAME, strValue);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
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

    public final boolean isKEYWORDSNull() {
        return this.IsParamNull(TAG_KEYWORDS);
    }

    public final String getKEYWORDS() {
        return this.GetParamStringValue(TAG_KEYWORDS, "");
    }

    public final void setKEYWORDS(String strValue) {
        this.SetParamValue(TAG_KEYWORDS, strValue);
    }

    public final boolean isPSDEVIEWBASEIDNull() {
        return this.IsParamNull(TAG_PSDEVIEWBASEID);
    }

    public final String getPSDEVIEWBASEID() {
        return this.GetParamStringValue(TAG_PSDEVIEWBASEID, "");
    }

    public final void setPSDEVIEWBASEID(String strValue) {
        this.SetParamValue(TAG_PSDEVIEWBASEID, strValue);
    }

    public final boolean isPSDEVIEWBASENAMENull() {
        return this.IsParamNull(TAG_PSDEVIEWBASENAME);
    }

    public final String getPSDEVIEWBASENAME() {
        return this.GetParamStringValue(TAG_PSDEVIEWBASENAME, "");
    }

    public final void setPSDEVIEWBASENAME(String strValue) {
        this.SetParamValue(TAG_PSDEVIEWBASENAME, strValue);
    }

    public final boolean isDYNAMICMODENull() {
        return this.IsParamNull(TAG_DYNAMICMODE);
    }

    public final int getDYNAMICMODE() {
        return this.GetParamIntValue(TAG_DYNAMICMODE, 0);
    }

    public final void setDYNAMICMODE(int nValue) {
        this.SetParamValue(TAG_DYNAMICMODE, nValue);
    }

    public final boolean isAWPSDEIDNull() {
        return this.IsParamNull(TAG_AWPSDEID);
    }

    public final String getAWPSDEID() {
        return this.GetParamStringValue(TAG_AWPSDEID, "");
    }

    public final void setAWPSDEID(String strValue) {
        this.SetParamValue(TAG_AWPSDEID, strValue);
    }

    public final boolean isAWPSDENAMENull() {
        return this.IsParamNull(TAG_AWPSDENAME);
    }

    public final String getAWPSDENAME() {
        return this.GetParamStringValue(TAG_AWPSDENAME, "");
    }

    public final void setAWPSDENAME(String strValue) {
        this.SetParamValue(TAG_AWPSDENAME, strValue);
    }

    public final boolean isAWIPSDEIDNull() {
        return this.IsParamNull(TAG_AWIPSDEID);
    }

    public final String getAWIPSDEID() {
        return this.GetParamStringValue(TAG_AWIPSDEID, "");
    }

    public final void setAWIPSDEID(String strValue) {
        this.SetParamValue(TAG_AWIPSDEID, strValue);
    }

    public final boolean isAWIPSDENAMENull() {
        return this.IsParamNull(TAG_AWIPSDENAME);
    }

    public final String getAWIPSDENAME() {
        return this.GetParamStringValue(TAG_AWIPSDENAME, "");
    }

    public final void setAWIPSDENAME(String strValue) {
        this.SetParamValue(TAG_AWIPSDENAME, strValue);
    }

    public final boolean isAWPSDEDSIDNull() {
        return this.IsParamNull(TAG_AWPSDEDSID);
    }

    public final String getAWPSDEDSID() {
        return this.GetParamStringValue(TAG_AWPSDEDSID, "");
    }

    public final void setAWPSDEDSID(String strValue) {
        this.SetParamValue(TAG_AWPSDEDSID, strValue);
    }

    public final boolean isAWPSDEDSNAMENull() {
        return this.IsParamNull(TAG_AWPSDEDSNAME);
    }

    public final String getAWPSDEDSNAME() {
        return this.GetParamStringValue(TAG_AWPSDEDSNAME, "");
    }

    public final void setAWPSDEDSNAME(String strValue) {
        this.SetParamValue(TAG_AWPSDEDSNAME, strValue);
    }

    public final boolean isAWIPSDEDSIDNull() {
        return this.IsParamNull(TAG_AWIPSDEDSID);
    }

    public final String getAWIPSDEDSID() {
        return this.GetParamStringValue(TAG_AWIPSDEDSID, "");
    }

    public final void setAWIPSDEDSID(String strValue) {
        this.SetParamValue(TAG_AWIPSDEDSID, strValue);
    }

    public final boolean isAWIPSDEDSNAMENull() {
        return this.IsParamNull(TAG_AWIPSDEDSNAME);
    }

    public final String getAWIPSDEDSNAME() {
        return this.GetParamStringValue(TAG_AWIPSDEDSNAME, "");
    }

    public final void setAWIPSDEDSNAME(String strValue) {
        this.SetParamValue(TAG_AWIPSDEDSNAME, strValue);
    }

    public final boolean isAWNAMEPSDEFIDNull() {
        return this.IsParamNull(TAG_AWNAMEPSDEFID);
    }

    public final String getAWNAMEPSDEFID() {
        return this.GetParamStringValue(TAG_AWNAMEPSDEFID, "");
    }

    public final void setAWNAMEPSDEFID(String strValue) {
        this.SetParamValue(TAG_AWNAMEPSDEFID, strValue);
    }

    public final boolean isAWNAMEPSDEFNAMENull() {
        return this.IsParamNull(TAG_AWNAMEPSDEFNAME);
    }

    public final String getAWNAMEPSDEFNAME() {
        return this.GetParamStringValue(TAG_AWNAMEPSDEFNAME, "");
    }

    public final void setAWNAMEPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_AWNAMEPSDEFNAME, strValue);
    }

    public final boolean isAWKWPSDEFIDNull() {
        return this.IsParamNull(TAG_AWKWPSDEFID);
    }

    public final String getAWKWPSDEFID() {
        return this.GetParamStringValue(TAG_AWKWPSDEFID, "");
    }

    public final void setAWKWPSDEFID(String strValue) {
        this.SetParamValue(TAG_AWKWPSDEFID, strValue);
    }

    public final boolean isAWKWPSDEFNAMENull() {
        return this.IsParamNull(TAG_AWKWPSDEFNAME);
    }

    public final String getAWKWPSDEFNAME() {
        return this.GetParamStringValue(TAG_AWKWPSDEFNAME, "");
    }

    public final void setAWKWPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_AWKWPSDEFNAME, strValue);
    }

    public final boolean isAWSORTPSDEFIDNull() {
        return this.IsParamNull(TAG_AWSORTPSDEFID);
    }

    public final String getAWSORTPSDEFID() {
        return this.GetParamStringValue(TAG_AWSORTPSDEFID, "");
    }

    public final void setAWSORTPSDEFID(String strValue) {
        this.SetParamValue(TAG_AWSORTPSDEFID, strValue);
    }

    public final boolean isAWSORTPSDEFNAMENull() {
        return this.IsParamNull(TAG_AWSORTPSDEFNAME);
    }

    public final String getAWSORTPSDEFNAME() {
        return this.GetParamStringValue(TAG_AWSORTPSDEFNAME, "");
    }

    public final void setAWSORTPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_AWSORTPSDEFNAME, strValue);
    }

    public final boolean isAWINAMEPSDEFIDNull() {
        return this.IsParamNull(TAG_AWINAMEPSDEFID);
    }

    public final String getAWINAMEPSDEFID() {
        return this.GetParamStringValue(TAG_AWINAMEPSDEFID, "");
    }

    public final void setAWINAMEPSDEFID(String strValue) {
        this.SetParamValue(TAG_AWINAMEPSDEFID, strValue);
    }

    public final boolean isAWINAMEPSDEFNAMENull() {
        return this.IsParamNull(TAG_AWINAMEPSDEFNAME);
    }

    public final String getAWINAMEPSDEFNAME() {
        return this.GetParamStringValue(TAG_AWINAMEPSDEFNAME, "");
    }

    public final void setAWINAMEPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_AWINAMEPSDEFNAME, strValue);
    }

    public final boolean isAWIVALUEPSDEFIDNull() {
        return this.IsParamNull(TAG_AWIVALUEPSDEFID);
    }

    public final String getAWIVALUEPSDEFID() {
        return this.GetParamStringValue(TAG_AWIVALUEPSDEFID, "");
    }

    public final void setAWIVALUEPSDEFID(String strValue) {
        this.SetParamValue(TAG_AWIVALUEPSDEFID, strValue);
    }

    public final boolean isAWIVALUEPSDEFNAMENull() {
        return this.IsParamNull(TAG_AWIVALUEPSDEFNAME);
    }

    public final String getAWIVALUEPSDEFNAME() {
        return this.GetParamStringValue(TAG_AWIVALUEPSDEFNAME, "");
    }

    public final void setAWIVALUEPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_AWIVALUEPSDEFNAME, strValue);
    }

    public final boolean isAWICONTENTPSDEFIDNull() {
        return this.IsParamNull(TAG_AWICONTENTPSDEFID);
    }

    public final String getAWICONTENTPSDEFID() {
        return this.GetParamStringValue(TAG_AWICONTENTPSDEFID, "");
    }

    public final void setAWICONTENTPSDEFID(String strValue) {
        this.SetParamValue(TAG_AWICONTENTPSDEFID, strValue);
    }

    public final boolean isAWICONTENTPSDEFNAMENull() {
        return this.IsParamNull(TAG_AWICONTENTPSDEFNAME);
    }

    public final String getAWICONTENTPSDEFNAME() {
        return this.GetParamStringValue(TAG_AWICONTENTPSDEFNAME, "");
    }

    public final void setAWICONTENTPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_AWICONTENTPSDEFNAME, strValue);
    }

    public final boolean isAWIURLPSDEFIDNull() {
        return this.IsParamNull(TAG_AWIURLPSDEFID);
    }

    public final String getAWIURLPSDEFID() {
        return this.GetParamStringValue(TAG_AWIURLPSDEFID, "");
    }

    public final void setAWIURLPSDEFID(String strValue) {
        this.SetParamValue(TAG_AWIURLPSDEFID, strValue);
    }

    public final boolean isAWIURLPSDEFNAMENull() {
        return this.IsParamNull(TAG_AWIURLPSDEFNAME);
    }

    public final String getAWIURLPSDEFNAME() {
        return this.GetParamStringValue(TAG_AWIURLPSDEFNAME, "");
    }

    public final void setAWIURLPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_AWIURLPSDEFNAME, strValue);
    }

    public final boolean isAWISORTPSDEFIDNull() {
        return this.IsParamNull(TAG_AWISORTPSDEFID);
    }

    public final String getAWISORTPSDEFID() {
        return this.GetParamStringValue(TAG_AWISORTPSDEFID, "");
    }

    public final void setAWISORTPSDEFID(String strValue) {
        this.SetParamValue(TAG_AWISORTPSDEFID, strValue);
    }

    public final boolean isAWISORTPSDEFNAMENull() {
        return this.IsParamNull(TAG_AWISORTPSDEFNAME);
    }

    public final String getAWISORTPSDEFNAME() {
        return this.GetParamStringValue(TAG_AWISORTPSDEFNAME, "");
    }

    public final void setAWISORTPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_AWISORTPSDEFNAME, strValue);
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

    public final boolean isAWIFKEYPSDEFIDNull() {
        return this.IsParamNull(TAG_AWIFKEYPSDEFID);
    }

    public final String getAWIFKEYPSDEFID() {
        return this.GetParamStringValue(TAG_AWIFKEYPSDEFID, "");
    }

    public final void setAWIFKEYPSDEFID(String strValue) {
        this.SetParamValue(TAG_AWIFKEYPSDEFID, strValue);
    }

    public final boolean isAWIFKEYPSDEFNAMENull() {
        return this.IsParamNull(TAG_AWIFKEYPSDEFNAME);
    }

    public final String getAWIFKEYPSDEFNAME() {
        return this.GetParamStringValue(TAG_AWIFKEYPSDEFNAME, "");
    }

    public final void setAWIFKEYPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_AWIFKEYPSDEFNAME, strValue);
    }
}

