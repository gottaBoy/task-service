/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysReqItem
extends BaseDataEntity {
    public static final String USERCAT_CAT1 = "CAT1";
    public static final String USERCAT_CAT2 = "CAT2";
    public static final String USERCAT_CAT3 = "CAT3";
    public static final String USERCAT_CAT4 = "CAT4";
    public static final String USERCAT_CAT5 = "CAT5";
    public static final String USERCAT_CAT6 = "CAT6";
    public static final String USERCAT_CAT7 = "CAT7";
    public static final String USERCAT_CAT8 = "CAT8";
    public static final String USERCAT_CAT9 = "CAT9";
    public static final String TAG_PSSYSREQITEMID = "PSSYSREQITEMID";
    public static final String TAG_PSSYSREQITEMNAME = "PSSYSREQITEMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_PPSSYSREQITEMID = "PPSSYSREQITEMID";
    public static final String TAG_PPSSYSREQITEMNAME = "PPSSYSREQITEMNAME";
    public static final String TAG_REQCONTENT = "REQCONTENT";
    public static final String TAG_ITEMTYPE = "ITEMTYPE";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_ITEMSN = "ITEMSN";
    public static final String TAG_PSSYSREQMODULEID = "PSSYSREQMODULEID";
    public static final String TAG_PSSYSREQMODULENAME = "PSSYSREQMODULENAME";
    public static final String TAG_VER = "VER";
    public static final String TAG_PSSYSREQITEMDATASCNT = "PSSYSREQITEMDATASCNT";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSSYSREQITEMHISESCNT = "PSSYSREQITEMHISESCNT";
    public static final String TAG_PSDEVPRDID = "PSDEVPRDID";
    public static final String TAG_PSDEVPRDNAME = "PSDEVPRDNAME";
    public static final String TAG_PSDEVPRDVERID = "PSDEVPRDVERID";
    public static final String TAG_PSDEVPRDVERNAME = "PSDEVPRDVERNAME";
    public static final String TAG_PSDEVPRDSPECID = "PSDEVPRDSPECID";
    public static final String TAG_PSDEVPRDSPECNAME = "PSDEVPRDSPECNAME";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_PSSYSUSERCASEID = "PSSYSUSERCASEID";
    public static final String TAG_PSSYSUSERCASENAME = "PSSYSUSERCASENAME";
    public static final String TAG_ITEMTAG = "ITEMTAG";
    public static final String TAG_ITEMTAG2 = "ITEMTAG2";
    public static final String TAG_PSMODULEID = "PSMODULEID";
    public static final String TAG_PSMODULENAME = "PSMODULENAME";

    public final boolean isPSSYSREQITEMIDNull() {
        return this.IsParamNull(TAG_PSSYSREQITEMID);
    }

    public final String getPSSYSREQITEMID() {
        return this.GetParamStringValue(TAG_PSSYSREQITEMID, "");
    }

    public final void setPSSYSREQITEMID(String strValue) {
        this.SetParamValue(TAG_PSSYSREQITEMID, strValue);
    }

    public final boolean isPSSYSREQITEMNAMENull() {
        return this.IsParamNull(TAG_PSSYSREQITEMNAME);
    }

    public final String getPSSYSREQITEMNAME() {
        return this.GetParamStringValue(TAG_PSSYSREQITEMNAME, "");
    }

    public final void setPSSYSREQITEMNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSREQITEMNAME, strValue);
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

    public final boolean isPPSSYSREQITEMIDNull() {
        return this.IsParamNull(TAG_PPSSYSREQITEMID);
    }

    public final String getPPSSYSREQITEMID() {
        return this.GetParamStringValue(TAG_PPSSYSREQITEMID, "");
    }

    public final void setPPSSYSREQITEMID(String strValue) {
        this.SetParamValue(TAG_PPSSYSREQITEMID, strValue);
    }

    public final boolean isPPSSYSREQITEMNAMENull() {
        return this.IsParamNull(TAG_PPSSYSREQITEMNAME);
    }

    public final String getPPSSYSREQITEMNAME() {
        return this.GetParamStringValue(TAG_PPSSYSREQITEMNAME, "");
    }

    public final void setPPSSYSREQITEMNAME(String strValue) {
        this.SetParamValue(TAG_PPSSYSREQITEMNAME, strValue);
    }

    public final boolean isREQCONTENTNull() {
        return this.IsParamNull(TAG_REQCONTENT);
    }

    public final String getREQCONTENT() {
        return this.GetParamStringValue(TAG_REQCONTENT, "");
    }

    public final void setREQCONTENT(String strValue) {
        this.SetParamValue(TAG_REQCONTENT, strValue);
    }

    public final boolean isITEMTYPENull() {
        return this.IsParamNull(TAG_ITEMTYPE);
    }

    public final String getITEMTYPE() {
        return this.GetParamStringValue(TAG_ITEMTYPE, "");
    }

    public final void setITEMTYPE(String strValue) {
        this.SetParamValue(TAG_ITEMTYPE, strValue);
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

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
    }

    public final boolean isITEMSNNull() {
        return this.IsParamNull(TAG_ITEMSN);
    }

    public final String getITEMSN() {
        return this.GetParamStringValue(TAG_ITEMSN, "");
    }

    public final void setITEMSN(String strValue) {
        this.SetParamValue(TAG_ITEMSN, strValue);
    }

    public final boolean isPSSYSREQMODULEIDNull() {
        return this.IsParamNull(TAG_PSSYSREQMODULEID);
    }

    public final String getPSSYSREQMODULEID() {
        return this.GetParamStringValue(TAG_PSSYSREQMODULEID, "");
    }

    public final void setPSSYSREQMODULEID(String strValue) {
        this.SetParamValue(TAG_PSSYSREQMODULEID, strValue);
    }

    public final boolean isPSSYSREQMODULENAMENull() {
        return this.IsParamNull(TAG_PSSYSREQMODULENAME);
    }

    public final String getPSSYSREQMODULENAME() {
        return this.GetParamStringValue(TAG_PSSYSREQMODULENAME, "");
    }

    public final void setPSSYSREQMODULENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSREQMODULENAME, strValue);
    }

    public final boolean isVERNull() {
        return this.IsParamNull(TAG_VER);
    }

    public final int getVER() {
        return this.GetParamIntValue(TAG_VER, 0);
    }

    public final void setVER(int nValue) {
        this.SetParamValue(TAG_VER, nValue);
    }

    public final boolean isPSSYSREQITEMDATASCNTNull() {
        return this.IsParamNull(TAG_PSSYSREQITEMDATASCNT);
    }

    public final int getPSSYSREQITEMDATASCNT() {
        return this.GetParamIntValue(TAG_PSSYSREQITEMDATASCNT, 0);
    }

    public final void setPSSYSREQITEMDATASCNT(int nValue) {
        this.SetParamValue(TAG_PSSYSREQITEMDATASCNT, nValue);
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

    public final boolean isPSSYSREQITEMHISESCNTNull() {
        return this.IsParamNull(TAG_PSSYSREQITEMHISESCNT);
    }

    public final int getPSSYSREQITEMHISESCNT() {
        return this.GetParamIntValue(TAG_PSSYSREQITEMHISESCNT, 0);
    }

    public final void setPSSYSREQITEMHISESCNT(int nValue) {
        this.SetParamValue(TAG_PSSYSREQITEMHISESCNT, nValue);
    }

    public final boolean isPSDEVPRDIDNull() {
        return this.IsParamNull(TAG_PSDEVPRDID);
    }

    public final String getPSDEVPRDID() {
        return this.GetParamStringValue(TAG_PSDEVPRDID, "");
    }

    public final void setPSDEVPRDID(String strValue) {
        this.SetParamValue(TAG_PSDEVPRDID, strValue);
    }

    public final boolean isPSDEVPRDNAMENull() {
        return this.IsParamNull(TAG_PSDEVPRDNAME);
    }

    public final String getPSDEVPRDNAME() {
        return this.GetParamStringValue(TAG_PSDEVPRDNAME, "");
    }

    public final void setPSDEVPRDNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVPRDNAME, strValue);
    }

    public final boolean isPSDEVPRDVERIDNull() {
        return this.IsParamNull(TAG_PSDEVPRDVERID);
    }

    public final String getPSDEVPRDVERID() {
        return this.GetParamStringValue(TAG_PSDEVPRDVERID, "");
    }

    public final void setPSDEVPRDVERID(String strValue) {
        this.SetParamValue(TAG_PSDEVPRDVERID, strValue);
    }

    public final boolean isPSDEVPRDVERNAMENull() {
        return this.IsParamNull(TAG_PSDEVPRDVERNAME);
    }

    public final String getPSDEVPRDVERNAME() {
        return this.GetParamStringValue(TAG_PSDEVPRDVERNAME, "");
    }

    public final void setPSDEVPRDVERNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVPRDVERNAME, strValue);
    }

    public final boolean isPSDEVPRDSPECIDNull() {
        return this.IsParamNull(TAG_PSDEVPRDSPECID);
    }

    public final String getPSDEVPRDSPECID() {
        return this.GetParamStringValue(TAG_PSDEVPRDSPECID, "");
    }

    public final void setPSDEVPRDSPECID(String strValue) {
        this.SetParamValue(TAG_PSDEVPRDSPECID, strValue);
    }

    public final boolean isPSDEVPRDSPECNAMENull() {
        return this.IsParamNull(TAG_PSDEVPRDSPECNAME);
    }

    public final String getPSDEVPRDSPECNAME() {
        return this.GetParamStringValue(TAG_PSDEVPRDSPECNAME, "");
    }

    public final void setPSDEVPRDSPECNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVPRDSPECNAME, strValue);
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

    public final void setUSERCAT(String strValue) {
        this.SetParamValue(TAG_USERCAT, strValue);
    }

    public final boolean isPSSYSUSERCASEIDNull() {
        return this.IsParamNull(TAG_PSSYSUSERCASEID);
    }

    public final String getPSSYSUSERCASEID() {
        return this.GetParamStringValue(TAG_PSSYSUSERCASEID, "");
    }

    public final void setPSSYSUSERCASEID(String strValue) {
        this.SetParamValue(TAG_PSSYSUSERCASEID, strValue);
    }

    public final boolean isPSSYSUSERCASENAMENull() {
        return this.IsParamNull(TAG_PSSYSUSERCASENAME);
    }

    public final String getPSSYSUSERCASENAME() {
        return this.GetParamStringValue(TAG_PSSYSUSERCASENAME, "");
    }

    public final void setPSSYSUSERCASENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSUSERCASENAME, strValue);
    }

    public final boolean isITEMTAGNull() {
        return this.IsParamNull(TAG_ITEMTAG);
    }

    public final String getITEMTAG() {
        return this.GetParamStringValue(TAG_ITEMTAG, "");
    }

    public final void setITEMTAG(String strValue) {
        this.SetParamValue(TAG_ITEMTAG, strValue);
    }

    public final boolean isITEMTAG2Null() {
        return this.IsParamNull(TAG_ITEMTAG2);
    }

    public final String getITEMTAG2() {
        return this.GetParamStringValue(TAG_ITEMTAG2, "");
    }

    public final void setITEMTAG2(String strValue) {
        this.SetParamValue(TAG_ITEMTAG2, strValue);
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
}

