/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysRef
extends BaseDataEntity {
    public static final String SYSREFTYPE_SUBSYS = "SUBSYS";
    public static final String SYSREFTYPE_DEVSYS = "DEVSYS";
    public static final String TAG_PSSYSREFID = "PSSYSREFID";
    public static final String TAG_PSSYSREFNAME = "PSSYSREFNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_SYSREFTYPE = "SYSREFTYPE";
    public static final String TAG_PSSUBSYSID = "PSSUBSYSID";
    public static final String TAG_PSSUBSYSNAME = "PSSUBSYSNAME";
    public static final String TAG_VERSION = "VERSION";
    public static final String TAG_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String TAG_PSDEVSLNSYSNAME = "PSDEVSLNSYSNAME";
    public static final String TAG_REALSYSID = "REALSYSID";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_SFFWFLAG = "SFFWFLAG";
    public static final String TAG_CLSPKGPARAMS = "CLSPKGPARAMS";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_REFPARAM = "REFPARAM";
    public static final String TAG_REFPARAM2 = "REFPARAM2";
    public static final String TAG_REFPARAMS = "REFPARAMS";
    public static final String TAG_SYSCODENAME = "SYSCODENAME";
    public static final String TAG_SYSPKGNAME = "SYSPKGNAME";
    public static final String TAG_SYSNAME = "SYSNAME";
    public static final String TAG_DCDOMAINNAME = "DCDOMAINNAME";
    public static final String TAG_DEVSLNCODENAME = "DEVSLNCODENAME";
    public static final String TAG_SYSVCNAME = "SYSVCNAME";
    public static final String TAG_SRVCODENAME = "SRVCODENAME";

    public final boolean isPSSYSREFIDNull() {
        return this.IsParamNull(TAG_PSSYSREFID);
    }

    public final String getPSSYSREFID() {
        return this.GetParamStringValue(TAG_PSSYSREFID, "");
    }

    public final void setPSSYSREFID(String strValue) {
        this.SetParamValue(TAG_PSSYSREFID, strValue);
    }

    public final boolean isPSSYSREFNAMENull() {
        return this.IsParamNull(TAG_PSSYSREFNAME);
    }

    public final String getPSSYSREFNAME() {
        return this.GetParamStringValue(TAG_PSSYSREFNAME, "");
    }

    public final void setPSSYSREFNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSREFNAME, strValue);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isSYSREFTYPENull() {
        return this.IsParamNull(TAG_SYSREFTYPE);
    }

    public final String getSYSREFTYPE() {
        return this.GetParamStringValue(TAG_SYSREFTYPE, "");
    }

    public final void setSYSREFTYPE(String strValue) {
        this.SetParamValue(TAG_SYSREFTYPE, strValue);
    }

    public final boolean isPSSUBSYSIDNull() {
        return this.IsParamNull(TAG_PSSUBSYSID);
    }

    public final String getPSSUBSYSID() {
        return this.GetParamStringValue(TAG_PSSUBSYSID, "");
    }

    public final void setPSSUBSYSID(String strValue) {
        this.SetParamValue(TAG_PSSUBSYSID, strValue);
    }

    public final boolean isPSSUBSYSNAMENull() {
        return this.IsParamNull(TAG_PSSUBSYSNAME);
    }

    public final String getPSSUBSYSNAME() {
        return this.GetParamStringValue(TAG_PSSUBSYSNAME, "");
    }

    public final void setPSSUBSYSNAME(String strValue) {
        this.SetParamValue(TAG_PSSUBSYSNAME, strValue);
    }

    public final boolean isVERSIONNull() {
        return this.IsParamNull(TAG_VERSION);
    }

    public final int getVERSION() {
        return this.GetParamIntValue(TAG_VERSION, 0);
    }

    public final void setVERSION(int nValue) {
        this.SetParamValue(TAG_VERSION, nValue);
    }

    public final boolean isPSDEVSLNSYSIDNull() {
        return this.IsParamNull(TAG_PSDEVSLNSYSID);
    }

    public final String getPSDEVSLNSYSID() {
        return this.GetParamStringValue(TAG_PSDEVSLNSYSID, "");
    }

    public final void setPSDEVSLNSYSID(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNSYSID, strValue);
    }

    public final boolean isPSDEVSLNSYSNAMENull() {
        return this.IsParamNull(TAG_PSDEVSLNSYSNAME);
    }

    public final String getPSDEVSLNSYSNAME() {
        return this.GetParamStringValue(TAG_PSDEVSLNSYSNAME, "");
    }

    public final void setPSDEVSLNSYSNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNSYSNAME, strValue);
    }

    public final boolean isREALSYSIDNull() {
        return this.IsParamNull(TAG_REALSYSID);
    }

    public final String getREALSYSID() {
        return this.GetParamStringValue(TAG_REALSYSID, "");
    }

    public final void setREALSYSID(String strValue) {
        this.SetParamValue(TAG_REALSYSID, strValue);
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

    public final boolean isSFFWFLAGNull() {
        return this.IsParamNull(TAG_SFFWFLAG);
    }

    public final boolean getSFFWFLAG() {
        return this.GetParamIntValue(TAG_SFFWFLAG, 0) == 1;
    }

    public final void setSFFWFLAG(boolean bValue) {
        this.SetParamValue(TAG_SFFWFLAG, bValue ? 1 : 0);
    }

    public final boolean isCLSPKGPARAMSNull() {
        return this.IsParamNull(TAG_CLSPKGPARAMS);
    }

    public final String getCLSPKGPARAMS() {
        return this.GetParamStringValue(TAG_CLSPKGPARAMS, "");
    }

    public final void setCLSPKGPARAMS(String strValue) {
        this.SetParamValue(TAG_CLSPKGPARAMS, strValue);
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

    public final boolean isREFPARAMNull() {
        return this.IsParamNull(TAG_REFPARAM);
    }

    public final String getREFPARAM() {
        return this.GetParamStringValue(TAG_REFPARAM, "");
    }

    public final void setREFPARAM(String strValue) {
        this.SetParamValue(TAG_REFPARAM, strValue);
    }

    public final boolean isREFPARAM2Null() {
        return this.IsParamNull(TAG_REFPARAM2);
    }

    public final String getREFPARAM2() {
        return this.GetParamStringValue(TAG_REFPARAM2, "");
    }

    public final void setREFPARAM2(String strValue) {
        this.SetParamValue(TAG_REFPARAM2, strValue);
    }

    public final boolean isREFPARAMSNull() {
        return this.IsParamNull(TAG_REFPARAMS);
    }

    public final String getREFPARAMS() {
        return this.GetParamStringValue(TAG_REFPARAMS, "");
    }

    public final void setREFPARAMS(String strValue) {
        this.SetParamValue(TAG_REFPARAMS, strValue);
    }

    public final boolean isSYSCODENAMENull() {
        return this.IsParamNull(TAG_SYSCODENAME);
    }

    public final String getSYSCODENAME() {
        return this.GetParamStringValue(TAG_SYSCODENAME, "");
    }

    public final void setSYSCODENAME(String strValue) {
        this.SetParamValue(TAG_SYSCODENAME, strValue);
    }

    public final boolean isSYSPKGNAMENull() {
        return this.IsParamNull(TAG_SYSPKGNAME);
    }

    public final String getSYSPKGNAME() {
        return this.GetParamStringValue(TAG_SYSPKGNAME, "");
    }

    public final void setSYSPKGNAME(String strValue) {
        this.SetParamValue(TAG_SYSPKGNAME, strValue);
    }

    public final boolean isSYSNAMENull() {
        return this.IsParamNull(TAG_SYSNAME);
    }

    public final String getSYSNAME() {
        return this.GetParamStringValue(TAG_SYSNAME, "");
    }

    public final void setSYSNAME(String strValue) {
        this.SetParamValue(TAG_SYSNAME, strValue);
    }

    public final boolean isDCDOMAINNAMENull() {
        return this.IsParamNull(TAG_DCDOMAINNAME);
    }

    public final String getDCDOMAINNAME() {
        return this.GetParamStringValue(TAG_DCDOMAINNAME, "");
    }

    public final void setDCDOMAINNAME(String strValue) {
        this.SetParamValue(TAG_DCDOMAINNAME, strValue);
    }

    public final boolean isDEVSLNCODENAMENull() {
        return this.IsParamNull(TAG_DEVSLNCODENAME);
    }

    public final String getDEVSLNCODENAME() {
        return this.GetParamStringValue(TAG_DEVSLNCODENAME, "");
    }

    public final void setDEVSLNCODENAME(String strValue) {
        this.SetParamValue(TAG_DEVSLNCODENAME, strValue);
    }

    public final boolean isSYSVCNAMENull() {
        return this.IsParamNull(TAG_SYSVCNAME);
    }

    public final String getSYSVCNAME() {
        return this.GetParamStringValue(TAG_SYSVCNAME, "");
    }

    public final void setSYSVCNAME(String strValue) {
        this.SetParamValue(TAG_SYSVCNAME, strValue);
    }

    public final boolean isSRVCODENAMENull() {
        return this.IsParamNull(TAG_SRVCODENAME);
    }

    public final String getSRVCODENAME() {
        return this.GetParamStringValue(TAG_SRVCODENAME, "");
    }

    public final void setSRVCODENAME(String strValue) {
        this.SetParamValue(TAG_SRVCODENAME, strValue);
    }
}

