/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSUAWizard3
extends BaseDataEntity {
    public static final String WIZARDMODE_INITDC = "INITDC";
    public static final String WIZARDMODE_INITTRAININGENV = "INITTRAININGENV";
    public static final String TAG_PSUAWIZARD3ID = "PSUAWIZARD3ID";
    public static final String TAG_PSUAWIZARD3NAME = "PSUAWIZARD3NAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_WIZARDMODE = "WIZARDMODE";
    public static final String TAG_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String TAG_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String TAG_PSTASKSERVERID = "PSTASKSERVERID";
    public static final String TAG_PSTASKSERVERNAME = "PSTASKSERVERNAME";
    public static final String TAG_TOMCAT7ASCOUNT = "TOMCAT7ASCOUNT";
    public static final String TAG_MYSQL5INSTCOUNT = "MYSQL5INSTCOUNT";
    public static final String TAG_ORAINSTCOUNT = "ORAINSTCOUNT";
    public static final String TAG_MSSQLINSTCOUNT = "MSSQLINSTCOUNT";
    public static final String TAG_DEVSERVERCOUNT = "DEVSERVERCOUNT";
    public static final String TAG_ACTIONRESULT = "ACTIONRESULT";
    public static final String TAG_DEVSLNNAME = "DEVSLNNAME";
    public static final String TAG_DEVSLNCODENAME = "DEVSLNCODENAME";
    public static final String TAG_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String TAG_PSDEVSLNSYSNAME = "PSDEVSLNSYSNAME";
    public static final String TAG_USERNAME = "USERNAME";
    public static final String TAG_USERLOGINNAME = "USERLOGINNAME";
    public static final String TAG_USERCOUNTPERSYS = "USERCOUNTPERSYS";
    public static final String TAG_DEVSLNCOUNT = "DEVSLNCOUNT";

    public final boolean isPSUAWIZARD3IDNull() {
        return this.IsParamNull(TAG_PSUAWIZARD3ID);
    }

    public final String getPSUAWIZARD3ID() {
        return this.GetParamStringValue(TAG_PSUAWIZARD3ID, "");
    }

    public final void setPSUAWIZARD3ID(String strValue) {
        this.SetParamValue(TAG_PSUAWIZARD3ID, strValue);
    }

    public final boolean isPSUAWIZARD3NAMENull() {
        return this.IsParamNull(TAG_PSUAWIZARD3NAME);
    }

    public final String getPSUAWIZARD3NAME() {
        return this.GetParamStringValue(TAG_PSUAWIZARD3NAME, "");
    }

    public final void setPSUAWIZARD3NAME(String strValue) {
        this.SetParamValue(TAG_PSUAWIZARD3NAME, strValue);
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

    public final boolean isWIZARDMODENull() {
        return this.IsParamNull(TAG_WIZARDMODE);
    }

    public final String getWIZARDMODE() {
        return this.GetParamStringValue(TAG_WIZARDMODE, "");
    }

    public final void setWIZARDMODE(String strValue) {
        this.SetParamValue(TAG_WIZARDMODE, strValue);
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

    public final boolean isPSTASKSERVERIDNull() {
        return this.IsParamNull(TAG_PSTASKSERVERID);
    }

    public final String getPSTASKSERVERID() {
        return this.GetParamStringValue(TAG_PSTASKSERVERID, "");
    }

    public final void setPSTASKSERVERID(String strValue) {
        this.SetParamValue(TAG_PSTASKSERVERID, strValue);
    }

    public final boolean isPSTASKSERVERNAMENull() {
        return this.IsParamNull(TAG_PSTASKSERVERNAME);
    }

    public final String getPSTASKSERVERNAME() {
        return this.GetParamStringValue(TAG_PSTASKSERVERNAME, "");
    }

    public final void setPSTASKSERVERNAME(String strValue) {
        this.SetParamValue(TAG_PSTASKSERVERNAME, strValue);
    }

    public final boolean isTOMCAT7ASCOUNTNull() {
        return this.IsParamNull(TAG_TOMCAT7ASCOUNT);
    }

    public final int getTOMCAT7ASCOUNT() {
        return this.GetParamIntValue(TAG_TOMCAT7ASCOUNT, 0);
    }

    public final void setTOMCAT7ASCOUNT(int nValue) {
        this.SetParamValue(TAG_TOMCAT7ASCOUNT, nValue);
    }

    public final boolean isMYSQL5INSTCOUNTNull() {
        return this.IsParamNull(TAG_MYSQL5INSTCOUNT);
    }

    public final int getMYSQL5INSTCOUNT() {
        return this.GetParamIntValue(TAG_MYSQL5INSTCOUNT, 0);
    }

    public final void setMYSQL5INSTCOUNT(int nValue) {
        this.SetParamValue(TAG_MYSQL5INSTCOUNT, nValue);
    }

    public final boolean isORAINSTCOUNTNull() {
        return this.IsParamNull(TAG_ORAINSTCOUNT);
    }

    public final int getORAINSTCOUNT() {
        return this.GetParamIntValue(TAG_ORAINSTCOUNT, 0);
    }

    public final void setORAINSTCOUNT(int nValue) {
        this.SetParamValue(TAG_ORAINSTCOUNT, nValue);
    }

    public final boolean isMSSQLINSTCOUNTNull() {
        return this.IsParamNull(TAG_MSSQLINSTCOUNT);
    }

    public final int getMSSQLINSTCOUNT() {
        return this.GetParamIntValue(TAG_MSSQLINSTCOUNT, 0);
    }

    public final void setMSSQLINSTCOUNT(int nValue) {
        this.SetParamValue(TAG_MSSQLINSTCOUNT, nValue);
    }

    public final boolean isDEVSERVERCOUNTNull() {
        return this.IsParamNull(TAG_DEVSERVERCOUNT);
    }

    public final int getDEVSERVERCOUNT() {
        return this.GetParamIntValue(TAG_DEVSERVERCOUNT, 0);
    }

    public final void setDEVSERVERCOUNT(int nValue) {
        this.SetParamValue(TAG_DEVSERVERCOUNT, nValue);
    }

    public final boolean isACTIONRESULTNull() {
        return this.IsParamNull(TAG_ACTIONRESULT);
    }

    public final String getACTIONRESULT() {
        return this.GetParamStringValue(TAG_ACTIONRESULT, "");
    }

    public final void setACTIONRESULT(String strValue) {
        this.SetParamValue(TAG_ACTIONRESULT, strValue);
    }

    public final boolean isDEVSLNNAMENull() {
        return this.IsParamNull(TAG_DEVSLNNAME);
    }

    public final String getDEVSLNNAME() {
        return this.GetParamStringValue(TAG_DEVSLNNAME, "");
    }

    public final void setDEVSLNNAME(String strValue) {
        this.SetParamValue(TAG_DEVSLNNAME, strValue);
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

    public final boolean isUSERNAMENull() {
        return this.IsParamNull(TAG_USERNAME);
    }

    public final String getUSERNAME() {
        return this.GetParamStringValue(TAG_USERNAME, "");
    }

    public final void setUSERNAME(String strValue) {
        this.SetParamValue(TAG_USERNAME, strValue);
    }

    public final boolean isUSERLOGINNAMENull() {
        return this.IsParamNull(TAG_USERLOGINNAME);
    }

    public final String getUSERLOGINNAME() {
        return this.GetParamStringValue(TAG_USERLOGINNAME, "");
    }

    public final void setUSERLOGINNAME(String strValue) {
        this.SetParamValue(TAG_USERLOGINNAME, strValue);
    }

    public final boolean isUSERCOUNTPERSYSNull() {
        return this.IsParamNull(TAG_USERCOUNTPERSYS);
    }

    public final int getUSERCOUNTPERSYS() {
        return this.GetParamIntValue(TAG_USERCOUNTPERSYS, 0);
    }

    public final void setUSERCOUNTPERSYS(int nValue) {
        this.SetParamValue(TAG_USERCOUNTPERSYS, nValue);
    }

    public final boolean isDEVSLNCOUNTNull() {
        return this.IsParamNull(TAG_DEVSLNCOUNT);
    }

    public final int getDEVSLNCOUNT() {
        return this.GetParamIntValue(TAG_DEVSLNCOUNT, 0);
    }

    public final void setDEVSLNCOUNT(int nValue) {
        this.SetParamValue(TAG_DEVSLNCOUNT, nValue);
    }
}

