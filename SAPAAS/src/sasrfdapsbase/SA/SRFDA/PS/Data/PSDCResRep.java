/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDCResRep
extends BaseDataEntity {
    public static final String TAG_PSDCRESREPID = "PSDCRESREPID";
    public static final String TAG_PSDCRESREPNAME = "PSDCRESREPNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String TAG_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String TAG_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String TAG_REPTIME = "REPTIME";
    public static final String TAG_DISKSIZE = "DISKSIZE";
    public static final String TAG_DISKUSED = "DISKUSED";
    public static final String TAG_MONTHNWFLOWSIZE = "MONTHNWFLOWSIZE";
    public static final String TAG_MONTHNWFLOWUSED = "MONTHNWFLOWUSED";
    public static final String TAG_DBINSTCNT = "DBINSTCNT";
    public static final String TAG_USERDBINSTCNT = "USERDBINSTCNT";
    public static final String TAG_EXPIREDDBINSTCNT = "EXPIREDDBINSTCNT";
    public static final String TAG_EXPIREDDBINSTCNT2 = "EXPIREDDBINSTCNT2";
    public static final String TAG_ASCNT = "ASCNT";
    public static final String TAG_USERASCNT = "USERASCNT";
    public static final String TAG_EXPIREDASCNT = "EXPIREDASCNT";
    public static final String TAG_EXPIREDASCNT2 = "EXPIREDASCNT2";
    public static final String TAG_MQINSTCNT = "MQINSTCNT";
    public static final String TAG_USERMQINSTCNT = "USERMQINSTCNT";
    public static final String TAG_EXPIREDMQINSTCNT = "EXPIREDMQINSTCNT";
    public static final String TAG_EXPIREDMQINSTCNT2 = "EXPIREDMQINSTCNT2";
    public static final String TAG_CODEREPOCNT = "CODEREPOCNT";
    public static final String TAG_USERCODEREPOCNT = "USERCODEREPOCNT";
    public static final String TAG_EXPIREDCODEREPOCNT = "EXPIREDCODEREPOCNT";
    public static final String TAG_EXPIREDCODEREPOCNT2 = "EXPIREDCODEREPOCNT2";
    public static final String TAG_REPORTURL = "REPORTURL";
    public static final String TAG_CONTENT = "CONTENT";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_DCBALANCE = "DCBALANCE";
    public static final String TAG_ROBOTCNT = "ROBOTCNT";

    public final boolean isPSDCRESREPIDNull() {
        return this.IsParamNull(TAG_PSDCRESREPID);
    }

    public final String getPSDCRESREPID() {
        return this.GetParamStringValue(TAG_PSDCRESREPID, "");
    }

    public final void setPSDCRESREPID(String strValue) {
        this.SetParamValue(TAG_PSDCRESREPID, strValue);
    }

    public final boolean isPSDCRESREPNAMENull() {
        return this.IsParamNull(TAG_PSDCRESREPNAME);
    }

    public final String getPSDCRESREPNAME() {
        return this.GetParamStringValue(TAG_PSDCRESREPNAME, "");
    }

    public final void setPSDCRESREPNAME(String strValue) {
        this.SetParamValue(TAG_PSDCRESREPNAME, strValue);
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

    public final boolean isPSDEVCENTERIDNull() {
        return this.IsParamNull(TAG_PSDEVCENTERID);
    }

    public final String getPSDEVCENTERID() {
        return this.GetParamStringValue(TAG_PSDEVCENTERID, "");
    }

    public final void setPSDEVCENTERID(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERID, strValue);
    }

    public final boolean isPSDEVCENTERNAMENull() {
        return this.IsParamNull(TAG_PSDEVCENTERNAME);
    }

    public final String getPSDEVCENTERNAME() {
        return this.GetParamStringValue(TAG_PSDEVCENTERNAME, "");
    }

    public final void setPSDEVCENTERNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERNAME, strValue);
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

    public final boolean isREPTIMENull() {
        return this.IsParamNull(TAG_REPTIME);
    }

    public final Date getREPTIME() {
        return this.GetParamDateValue(TAG_REPTIME, null);
    }

    public final void setREPTIME(Date dtValue) {
        this.SetParamValue(TAG_REPTIME, dtValue);
    }

    public final boolean isDISKSIZENull() {
        return this.IsParamNull(TAG_DISKSIZE);
    }

    public final int getDISKSIZE() {
        return this.GetParamIntValue(TAG_DISKSIZE, 0);
    }

    public final void setDISKSIZE(int nValue) {
        this.SetParamValue(TAG_DISKSIZE, nValue);
    }

    public final boolean isDISKUSEDNull() {
        return this.IsParamNull(TAG_DISKUSED);
    }

    public final int getDISKUSED() {
        return this.GetParamIntValue(TAG_DISKUSED, 0);
    }

    public final void setDISKUSED(int nValue) {
        this.SetParamValue(TAG_DISKUSED, nValue);
    }

    public final boolean isMONTHNWFLOWSIZENull() {
        return this.IsParamNull(TAG_MONTHNWFLOWSIZE);
    }

    public final int getMONTHNWFLOWSIZE() {
        return this.GetParamIntValue(TAG_MONTHNWFLOWSIZE, 0);
    }

    public final void setMONTHNWFLOWSIZE(int nValue) {
        this.SetParamValue(TAG_MONTHNWFLOWSIZE, nValue);
    }

    public final boolean isMONTHNWFLOWUSEDNull() {
        return this.IsParamNull(TAG_MONTHNWFLOWUSED);
    }

    public final int getMONTHNWFLOWUSED() {
        return this.GetParamIntValue(TAG_MONTHNWFLOWUSED, 0);
    }

    public final void setMONTHNWFLOWUSED(int nValue) {
        this.SetParamValue(TAG_MONTHNWFLOWUSED, nValue);
    }

    public final boolean isDBINSTCNTNull() {
        return this.IsParamNull(TAG_DBINSTCNT);
    }

    public final int getDBINSTCNT() {
        return this.GetParamIntValue(TAG_DBINSTCNT, 0);
    }

    public final void setDBINSTCNT(int nValue) {
        this.SetParamValue(TAG_DBINSTCNT, nValue);
    }

    public final boolean isUSERDBINSTCNTNull() {
        return this.IsParamNull(TAG_USERDBINSTCNT);
    }

    public final int getUSERDBINSTCNT() {
        return this.GetParamIntValue(TAG_USERDBINSTCNT, 0);
    }

    public final void setUSERDBINSTCNT(int nValue) {
        this.SetParamValue(TAG_USERDBINSTCNT, nValue);
    }

    public final boolean isEXPIREDDBINSTCNTNull() {
        return this.IsParamNull(TAG_EXPIREDDBINSTCNT);
    }

    public final int getEXPIREDDBINSTCNT() {
        return this.GetParamIntValue(TAG_EXPIREDDBINSTCNT, 0);
    }

    public final void setEXPIREDDBINSTCNT(int nValue) {
        this.SetParamValue(TAG_EXPIREDDBINSTCNT, nValue);
    }

    public final boolean isEXPIREDDBINSTCNT2Null() {
        return this.IsParamNull(TAG_EXPIREDDBINSTCNT2);
    }

    public final int getEXPIREDDBINSTCNT2() {
        return this.GetParamIntValue(TAG_EXPIREDDBINSTCNT2, 0);
    }

    public final void setEXPIREDDBINSTCNT2(int nValue) {
        this.SetParamValue(TAG_EXPIREDDBINSTCNT2, nValue);
    }

    public final boolean isASCNTNull() {
        return this.IsParamNull(TAG_ASCNT);
    }

    public final int getASCNT() {
        return this.GetParamIntValue(TAG_ASCNT, 0);
    }

    public final void setASCNT(int nValue) {
        this.SetParamValue(TAG_ASCNT, nValue);
    }

    public final boolean isUSERASCNTNull() {
        return this.IsParamNull(TAG_USERASCNT);
    }

    public final int getUSERASCNT() {
        return this.GetParamIntValue(TAG_USERASCNT, 0);
    }

    public final void setUSERASCNT(int nValue) {
        this.SetParamValue(TAG_USERASCNT, nValue);
    }

    public final boolean isEXPIREDASCNTNull() {
        return this.IsParamNull(TAG_EXPIREDASCNT);
    }

    public final int getEXPIREDASCNT() {
        return this.GetParamIntValue(TAG_EXPIREDASCNT, 0);
    }

    public final void setEXPIREDASCNT(int nValue) {
        this.SetParamValue(TAG_EXPIREDASCNT, nValue);
    }

    public final boolean isEXPIREDASCNT2Null() {
        return this.IsParamNull(TAG_EXPIREDASCNT2);
    }

    public final int getEXPIREDASCNT2() {
        return this.GetParamIntValue(TAG_EXPIREDASCNT2, 0);
    }

    public final void setEXPIREDASCNT2(int nValue) {
        this.SetParamValue(TAG_EXPIREDASCNT2, nValue);
    }

    public final boolean isMQINSTCNTNull() {
        return this.IsParamNull(TAG_MQINSTCNT);
    }

    public final int getMQINSTCNT() {
        return this.GetParamIntValue(TAG_MQINSTCNT, 0);
    }

    public final void setMQINSTCNT(int nValue) {
        this.SetParamValue(TAG_MQINSTCNT, nValue);
    }

    public final boolean isUSERMQINSTCNTNull() {
        return this.IsParamNull(TAG_USERMQINSTCNT);
    }

    public final int getUSERMQINSTCNT() {
        return this.GetParamIntValue(TAG_USERMQINSTCNT, 0);
    }

    public final void setUSERMQINSTCNT(int nValue) {
        this.SetParamValue(TAG_USERMQINSTCNT, nValue);
    }

    public final boolean isEXPIREDMQINSTCNTNull() {
        return this.IsParamNull(TAG_EXPIREDMQINSTCNT);
    }

    public final int getEXPIREDMQINSTCNT() {
        return this.GetParamIntValue(TAG_EXPIREDMQINSTCNT, 0);
    }

    public final void setEXPIREDMQINSTCNT(int nValue) {
        this.SetParamValue(TAG_EXPIREDMQINSTCNT, nValue);
    }

    public final boolean isEXPIREDMQINSTCNT2Null() {
        return this.IsParamNull(TAG_EXPIREDMQINSTCNT2);
    }

    public final int getEXPIREDMQINSTCNT2() {
        return this.GetParamIntValue(TAG_EXPIREDMQINSTCNT2, 0);
    }

    public final void setEXPIREDMQINSTCNT2(int nValue) {
        this.SetParamValue(TAG_EXPIREDMQINSTCNT2, nValue);
    }

    public final boolean isCODEREPOCNTNull() {
        return this.IsParamNull(TAG_CODEREPOCNT);
    }

    public final int getCODEREPOCNT() {
        return this.GetParamIntValue(TAG_CODEREPOCNT, 0);
    }

    public final void setCODEREPOCNT(int nValue) {
        this.SetParamValue(TAG_CODEREPOCNT, nValue);
    }

    public final boolean isUSERCODEREPOCNTNull() {
        return this.IsParamNull(TAG_USERCODEREPOCNT);
    }

    public final int getUSERCODEREPOCNT() {
        return this.GetParamIntValue(TAG_USERCODEREPOCNT, 0);
    }

    public final void setUSERCODEREPOCNT(int nValue) {
        this.SetParamValue(TAG_USERCODEREPOCNT, nValue);
    }

    public final boolean isEXPIREDCODEREPOCNTNull() {
        return this.IsParamNull(TAG_EXPIREDCODEREPOCNT);
    }

    public final int getEXPIREDCODEREPOCNT() {
        return this.GetParamIntValue(TAG_EXPIREDCODEREPOCNT, 0);
    }

    public final void setEXPIREDCODEREPOCNT(int nValue) {
        this.SetParamValue(TAG_EXPIREDCODEREPOCNT, nValue);
    }

    public final boolean isEXPIREDCODEREPOCNT2Null() {
        return this.IsParamNull(TAG_EXPIREDCODEREPOCNT2);
    }

    public final int getEXPIREDCODEREPOCNT2() {
        return this.GetParamIntValue(TAG_EXPIREDCODEREPOCNT2, 0);
    }

    public final void setEXPIREDCODEREPOCNT2(int nValue) {
        this.SetParamValue(TAG_EXPIREDCODEREPOCNT2, nValue);
    }

    public final boolean isREPORTURLNull() {
        return this.IsParamNull(TAG_REPORTURL);
    }

    public final String getREPORTURL() {
        return this.GetParamStringValue(TAG_REPORTURL, "");
    }

    public final void setREPORTURL(String strValue) {
        this.SetParamValue(TAG_REPORTURL, strValue);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isDCBALANCENull() {
        return this.IsParamNull(TAG_DCBALANCE);
    }

    public final String getDCBALANCE() {
        return this.GetParamStringValue(TAG_DCBALANCE, "");
    }

    public final void setDCBALANCE(String strValue) {
        this.SetParamValue(TAG_DCBALANCE, strValue);
    }

    public final boolean isROBOTCNTNull() {
        return this.IsParamNull(TAG_ROBOTCNT);
    }

    public final int getROBOTCNT() {
        return this.GetParamIntValue(TAG_ROBOTCNT, 0);
    }

    public final void setROBOTCNT(int nValue) {
        this.SetParamValue(TAG_ROBOTCNT, nValue);
    }
}

