/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSystemModule
extends BaseDataEntity {
    public static final String SYSREFTYPE_SUBSYS = "SUBSYS";
    public static final String SYSREFTYPE_DEVSYS = "DEVSYS";
    public static final String SYSREFTYPE_DEVSYSCLOUD = "DEVSYSCLOUD";
    public static final String TAG_PSMODULEID = "PSMODULEID";
    public static final String TAG_PSMODULENAME = "PSMODULENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_SUBSYSMODULE = "SUBSYSMODULE";
    public static final String TAG_CLSPKGPARAMS = "CLSPKGPARAMS";
    public static final String TAG_PSSYSREFID = "PSSYSREFID";
    public static final String TAG_PSSYSREFNAME = "PSSYSREFNAME";
    public static final String TAG_PSSYSSFPUBID = "PSSYSSFPUBID";
    public static final String TAG_PSSYSSFPUBNAME = "PSSYSSFPUBNAME";
    public static final String TAG_COLOR = "COLOR";
    public static final String TAG_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String TAG_PSSYSMODELGROUPID = "PSSYSMODELGROUPID";
    public static final String TAG_PSSYSMODELGROUPNAME = "PSSYSMODELGROUPNAME";
    public static final String TAG_MODTAG = "MODTAG";
    public static final String TAG_MODTAG2 = "MODTAG2";
    public static final String TAG_MODTAG3 = "MODTAG3";
    public static final String TAG_MODTAG4 = "MODTAG4";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_PKGCODENAME = "PKGCODENAME";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_SERVICEAPIFLAG = "SERVICEAPIFLAG";
    public static final String TAG_NOVIEWMODE = "NOVIEWMODE";
    public static final String TAG_SYSREFTYPE = "SYSREFTYPE";
    public static final String TAG_DYNAINSTMODE = "DYNAINSTMODE";
    public static final String TAG_DYNAINSTTAG2 = "DYNAINSTTAG2";
    public static final String TAG_DYNAINSTTAG = "DYNAINSTTAG";
    public static final String TAG_SHORTTAG = "SHORTTAG";
    public static final String TAG_LANRESTAG = "LANRESTAG";
    public static final String TAG_DEPSSYSSFPLUGINID = "DEPSSYSSFPLUGINID";
    public static final String TAG_DEPSSYSSFPLUGINNAME = "DEPSSYSSFPLUGINNAME";
    public static final String TAG_UTILTYPE = "UTILTYPE";
    public static final String TAG_UTILTAG = "UTILTAG";
    public static final String TAG_UTILPARAMS = "UTILPARAMS";
    public static final String TAG_DSLINK = "DSLINK";
    public static final String TAG_MODULESN = "MODULESN";
    public static final String TAG_DTOFORMAT = "DTOFORMAT";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_REQMODULE = "REQMODULE";
    public static final String TAG_CODENAMEMODE = "CODENAMEMODE";
    public static final String TAG_ENABLEPQL = "ENABLEPQL";
    public static final String TAG_RUNTIMETYPE = "RUNTIMETYPE";

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

    public final boolean isCODENAMENull() {
        return this.IsParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.GetParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.SetParamValue(TAG_CODENAME, strValue);
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

    public final boolean isSUBSYSMODULENull() {
        return this.IsParamNull(TAG_SUBSYSMODULE);
    }

    public final boolean getSUBSYSMODULE() {
        return this.GetParamIntValue(TAG_SUBSYSMODULE, 0) == 1;
    }

    public final void setSUBSYSMODULE(boolean bValue) {
        this.SetParamValue(TAG_SUBSYSMODULE, bValue ? 1 : 0);
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

    public final boolean isPSSYSSFPUBIDNull() {
        return this.IsParamNull(TAG_PSSYSSFPUBID);
    }

    public final String getPSSYSSFPUBID() {
        return this.GetParamStringValue(TAG_PSSYSSFPUBID, "");
    }

    public final void setPSSYSSFPUBID(String strValue) {
        this.SetParamValue(TAG_PSSYSSFPUBID, strValue);
    }

    public final boolean isPSSYSSFPUBNAMENull() {
        return this.IsParamNull(TAG_PSSYSSFPUBNAME);
    }

    public final String getPSSYSSFPUBNAME() {
        return this.GetParamStringValue(TAG_PSSYSSFPUBNAME, "");
    }

    public final void setPSSYSSFPUBNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSSFPUBNAME, strValue);
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

    public final boolean isCOLORNull() {
        return this.IsParamNull(TAG_COLOR);
    }

    public final String getCOLOR() {
        return this.GetParamStringValue(TAG_COLOR, "");
    }

    public final void setCOLOR(String strValue) {
        this.SetParamValue(TAG_COLOR, strValue);
    }

    public final boolean isPSSYSMODELGROUPIDNull() {
        return this.IsParamNull(TAG_PSSYSMODELGROUPID);
    }

    public final String getPSSYSMODELGROUPID() {
        return this.GetParamStringValue(TAG_PSSYSMODELGROUPID, "");
    }

    public final void setPSSYSMODELGROUPID(String strValue) {
        this.SetParamValue(TAG_PSSYSMODELGROUPID, strValue);
    }

    public final boolean isPSSYSMODELGROUPNAMENull() {
        return this.IsParamNull(TAG_PSSYSMODELGROUPNAME);
    }

    public final String getPSSYSMODELGROUPNAME() {
        return this.GetParamStringValue(TAG_PSSYSMODELGROUPNAME, "");
    }

    public final void setPSSYSMODELGROUPNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSMODELGROUPNAME, strValue);
    }

    public final boolean isMODTAGNull() {
        return this.IsParamNull(TAG_MODTAG);
    }

    public final String getMODTAG() {
        return this.GetParamStringValue(TAG_MODTAG, "");
    }

    public final void setMODTAG(String strValue) {
        this.SetParamValue(TAG_MODTAG, strValue);
    }

    public final boolean isMODTAG2Null() {
        return this.IsParamNull(TAG_MODTAG2);
    }

    public final String getMODTAG2() {
        return this.GetParamStringValue(TAG_MODTAG2, "");
    }

    public final void setMODTAG2(String strValue) {
        this.SetParamValue(TAG_MODTAG2, strValue);
    }

    public final boolean isMODTAG3Null() {
        return this.IsParamNull(TAG_MODTAG3);
    }

    public final String getMODTAG3() {
        return this.GetParamStringValue(TAG_MODTAG3, "");
    }

    public final void setMODTAG3(String strValue) {
        this.SetParamValue(TAG_MODTAG3, strValue);
    }

    public final boolean isMODTAG4Null() {
        return this.IsParamNull(TAG_MODTAG4);
    }

    public final String getMODTAG4() {
        return this.GetParamStringValue(TAG_MODTAG4, "");
    }

    public final void setMODTAG4(String strValue) {
        this.SetParamValue(TAG_MODTAG4, strValue);
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

    public final boolean isPKGCODENAMENull() {
        return this.IsParamNull(TAG_PKGCODENAME);
    }

    public final String getPKGCODENAME() {
        return this.GetParamStringValue(TAG_PKGCODENAME, "");
    }

    public final void setPKGCODENAME(String strValue) {
        this.SetParamValue(TAG_PKGCODENAME, strValue);
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

    public final boolean isSERVICEAPIFLAGNull() {
        return this.IsParamNull(TAG_SERVICEAPIFLAG);
    }

    public final int getSERVICEAPIFLAG() {
        return this.GetParamIntValue(TAG_SERVICEAPIFLAG, 0);
    }

    public final void setSERVICEAPIFLAG(int nValue) {
        this.SetParamValue(TAG_SERVICEAPIFLAG, nValue);
    }

    public final boolean isNOVIEWMODENull() {
        return this.IsParamNull(TAG_NOVIEWMODE);
    }

    public final boolean getNOVIEWMODE() {
        return this.GetParamIntValue(TAG_NOVIEWMODE, 0) == 1;
    }

    public final void setNOVIEWMODE(boolean bValue) {
        this.SetParamValue(TAG_NOVIEWMODE, bValue ? 1 : 0);
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

    public final boolean isDYNAINSTMODENull() {
        return this.IsParamNull(TAG_DYNAINSTMODE);
    }

    public final int getDYNAINSTMODE() {
        return this.GetParamIntValue(TAG_DYNAINSTMODE, 0);
    }

    public final void setDYNAINSTMODE(int nValue) {
        this.SetParamValue(TAG_DYNAINSTMODE, nValue);
    }

    public final boolean isDYNAINSTTAG2Null() {
        return this.IsParamNull(TAG_DYNAINSTTAG2);
    }

    public final String getDYNAINSTTAG2() {
        return this.GetParamStringValue(TAG_DYNAINSTTAG2, "");
    }

    public final void setDYNAINSTTAG2(String strValue) {
        this.SetParamValue(TAG_DYNAINSTTAG2, strValue);
    }

    public final boolean isDYNAINSTTAGNull() {
        return this.IsParamNull(TAG_DYNAINSTTAG);
    }

    public final String getDYNAINSTTAG() {
        return this.GetParamStringValue(TAG_DYNAINSTTAG, "");
    }

    public final void setDYNAINSTTAG(String strValue) {
        this.SetParamValue(TAG_DYNAINSTTAG, strValue);
    }

    public final boolean isSHORTTAGNull() {
        return this.IsParamNull(TAG_SHORTTAG);
    }

    public final String getSHORTTAG() {
        return this.GetParamStringValue(TAG_SHORTTAG, "");
    }

    public final void setSHORTTAG(String strValue) {
        this.SetParamValue(TAG_SHORTTAG, strValue);
    }

    public final boolean isLANRESTAGNull() {
        return this.IsParamNull(TAG_LANRESTAG);
    }

    public final String getLANRESTAG() {
        return this.GetParamStringValue(TAG_LANRESTAG, "");
    }

    public final void setLANRESTAG(String strValue) {
        this.SetParamValue(TAG_LANRESTAG, strValue);
    }

    public final boolean isDEPSSYSSFPLUGINIDNull() {
        return this.IsParamNull(TAG_DEPSSYSSFPLUGINID);
    }

    public final String getDEPSSYSSFPLUGINID() {
        return this.GetParamStringValue(TAG_DEPSSYSSFPLUGINID, "");
    }

    public final void setDEPSSYSSFPLUGINID(String strValue) {
        this.SetParamValue(TAG_DEPSSYSSFPLUGINID, strValue);
    }

    public final boolean isDEPSSYSSFPLUGINNAMENull() {
        return this.IsParamNull(TAG_DEPSSYSSFPLUGINNAME);
    }

    public final String getDEPSSYSSFPLUGINNAME() {
        return this.GetParamStringValue(TAG_DEPSSYSSFPLUGINNAME, "");
    }

    public final void setDEPSSYSSFPLUGINNAME(String strValue) {
        this.SetParamValue(TAG_DEPSSYSSFPLUGINNAME, strValue);
    }

    public final boolean isUTILTYPENull() {
        return this.IsParamNull(TAG_UTILTYPE);
    }

    public final String getUTILTYPE() {
        return this.GetParamStringValue(TAG_UTILTYPE, "");
    }

    public final void setUTILTYPE(String strValue) {
        this.SetParamValue(TAG_UTILTYPE, strValue);
    }

    public final boolean isUTILTAGNull() {
        return this.IsParamNull(TAG_UTILTAG);
    }

    public final String getUTILTAG() {
        return this.GetParamStringValue(TAG_UTILTAG, "");
    }

    public final void setUTILTAG(String strValue) {
        this.SetParamValue(TAG_UTILTAG, strValue);
    }

    public final boolean isUTILPARAMSNull() {
        return this.IsParamNull(TAG_UTILPARAMS);
    }

    public final String getUTILPARAMS() {
        return this.GetParamStringValue(TAG_UTILPARAMS, "");
    }

    public final void setUTILPARAMS(String strValue) {
        this.SetParamValue(TAG_UTILPARAMS, strValue);
    }

    public final boolean isDSLINKNull() {
        return this.IsParamNull(TAG_DSLINK);
    }

    public final String getDSLINK() {
        return this.GetParamStringValue(TAG_DSLINK, "");
    }

    public final void setDSLINK(String strValue) {
        this.SetParamValue(TAG_DSLINK, strValue);
    }

    public final boolean isMODULESNNull() {
        return this.IsParamNull(TAG_MODULESN);
    }

    public final String getMODULESN() {
        return this.GetParamStringValue(TAG_MODULESN, "");
    }

    public final void setMODULESN(String strValue) {
        this.SetParamValue(TAG_MODULESN, strValue);
    }

    public final boolean isDTOFORMATNull() {
        return this.IsParamNull(TAG_DTOFORMAT);
    }

    public final String getDTOFORMAT() {
        return this.GetParamStringValue(TAG_DTOFORMAT, "");
    }

    public final void setDTOFORMAT(String strValue) {
        this.SetParamValue(TAG_DTOFORMAT, strValue);
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

    public final boolean isREQMODULENull() {
        return this.IsParamNull(TAG_REQMODULE);
    }

    public final boolean getREQMODULE() {
        return this.GetParamIntValue(TAG_REQMODULE, 0) == 1;
    }

    public final void setREQMODULE(boolean bValue) {
        this.SetParamValue(TAG_REQMODULE, bValue ? 1 : 0);
    }

    public final boolean isCODENAMEMODENull() {
        return this.IsParamNull(TAG_CODENAMEMODE);
    }

    public final String getCODENAMEMODE() {
        return this.GetParamStringValue(TAG_CODENAMEMODE, "");
    }

    public final void setCODENAMEMODE(String strValue) {
        this.SetParamValue(TAG_CODENAMEMODE, strValue);
    }

    public final boolean isENABLEPQLNull() {
        return this.IsParamNull(TAG_ENABLEPQL);
    }

    public final boolean getENABLEPQL() {
        return this.GetParamIntValue(TAG_ENABLEPQL, 0) == 1;
    }

    public final void setENABLEPQL(boolean bValue) {
        this.SetParamValue(TAG_ENABLEPQL, bValue ? 1 : 0);
    }

    public final boolean isRUNTIMETYPENull() {
        return this.IsParamNull(TAG_RUNTIMETYPE);
    }

    public final String getRUNTIMETYPE() {
        return this.GetParamStringValue(TAG_RUNTIMETYPE, "");
    }

    public final void setRUNTIMETYPE(String strValue) {
        this.SetParamValue(TAG_RUNTIMETYPE, strValue);
    }
}

