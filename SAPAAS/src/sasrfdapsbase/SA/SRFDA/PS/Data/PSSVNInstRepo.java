/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSVNInstRepo
extends BaseDataEntity {
    public static final int REPOSTATE_10 = 10;
    public static final int REPOSTATE_20 = 20;
    public static final int REPOSTATE_30 = 30;
    public static final int REPOSTATE_40 = 40;
    public static final String SVNTYPE_SVN = "SVN";
    public static final String SVNTYPE_GIT2 = "GIT2";
    public static final String TAG_PSSVNINSTREPOID = "PSSVNINSTREPOID";
    public static final String TAG_PSSVNINSTREPONAME = "PSSVNINSTREPONAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_REPOSTATE = "REPOSTATE";
    public static final String TAG_CONNSTR = "CONNSTR";
    public static final String TAG_PSSVNSERVERID = "PSSVNSERVERID";
    public static final String TAG_PSSVNSERVERNAME = "PSSVNSERVERNAME";
    public static final String TAG_PSSVRDOMAINID = "PSSVRDOMAINID";
    public static final String TAG_PSSVRDOMAINNAME = "PSSVRDOMAINNAME";
    public static final String TAG_REFINFO = "REFINFO";
    public static final String TAG_READONLYMODE = "READONLYMODE";
    public static final String TAG_GITPATH = "GITPATH";
    public static final String TAG_SVNTYPE = "SVNTYPE";
    public static final String TAG_PSGITUSERID = "PSGITUSERID";
    public static final String TAG_PSGITUSERNAME = "PSGITUSERNAME";
    public static final String TAG_REFOBJID = "REFOBJID";
    public static final String TAG_LOCALRES = "LOCALRES";
    public static final String TAG_GITBRANCH = "GITBRANCH";

    public final boolean isPSSVNINSTREPOIDNull() {
        return this.IsParamNull(TAG_PSSVNINSTREPOID);
    }

    public final String getPSSVNINSTREPOID() {
        return this.GetParamStringValue(TAG_PSSVNINSTREPOID, "");
    }

    public final void setPSSVNINSTREPOID(String strValue) {
        this.SetParamValue(TAG_PSSVNINSTREPOID, strValue);
    }

    public final boolean isPSSVNINSTREPONAMENull() {
        return this.IsParamNull(TAG_PSSVNINSTREPONAME);
    }

    public final String getPSSVNINSTREPONAME() {
        return this.GetParamStringValue(TAG_PSSVNINSTREPONAME, "");
    }

    public final void setPSSVNINSTREPONAME(String strValue) {
        this.SetParamValue(TAG_PSSVNINSTREPONAME, strValue);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isREPOSTATENull() {
        return this.IsParamNull(TAG_REPOSTATE);
    }

    public final int getREPOSTATE() {
        return this.GetParamIntValue(TAG_REPOSTATE, 0);
    }

    public final void setREPOSTATE(int nValue) {
        this.SetParamValue(TAG_REPOSTATE, nValue);
    }

    public final boolean isCONNSTRNull() {
        return this.IsParamNull(TAG_CONNSTR);
    }

    public final String getCONNSTR() {
        return this.GetParamStringValue(TAG_CONNSTR, "");
    }

    public final void setCONNSTR(String strValue) {
        this.SetParamValue(TAG_CONNSTR, strValue);
    }

    public final boolean isPSSVNSERVERIDNull() {
        return this.IsParamNull(TAG_PSSVNSERVERID);
    }

    public final String getPSSVNSERVERID() {
        return this.GetParamStringValue(TAG_PSSVNSERVERID, "");
    }

    public final void setPSSVNSERVERID(String strValue) {
        this.SetParamValue(TAG_PSSVNSERVERID, strValue);
    }

    public final boolean isPSSVNSERVERNAMENull() {
        return this.IsParamNull(TAG_PSSVNSERVERNAME);
    }

    public final String getPSSVNSERVERNAME() {
        return this.GetParamStringValue(TAG_PSSVNSERVERNAME, "");
    }

    public final void setPSSVNSERVERNAME(String strValue) {
        this.SetParamValue(TAG_PSSVNSERVERNAME, strValue);
    }

    public final boolean isPSSVRDOMAINIDNull() {
        return this.IsParamNull(TAG_PSSVRDOMAINID);
    }

    public final String getPSSVRDOMAINID() {
        return this.GetParamStringValue(TAG_PSSVRDOMAINID, "");
    }

    public final void setPSSVRDOMAINID(String strValue) {
        this.SetParamValue(TAG_PSSVRDOMAINID, strValue);
    }

    public final boolean isPSSVRDOMAINNAMENull() {
        return this.IsParamNull(TAG_PSSVRDOMAINNAME);
    }

    public final String getPSSVRDOMAINNAME() {
        return this.GetParamStringValue(TAG_PSSVRDOMAINNAME, "");
    }

    public final void setPSSVRDOMAINNAME(String strValue) {
        this.SetParamValue(TAG_PSSVRDOMAINNAME, strValue);
    }

    public final boolean isREFINFONull() {
        return this.IsParamNull(TAG_REFINFO);
    }

    public final String getREFINFO() {
        return this.GetParamStringValue(TAG_REFINFO, "");
    }

    public final void setREFINFO(String strValue) {
        this.SetParamValue(TAG_REFINFO, strValue);
    }

    public final boolean isREADONLYMODENull() {
        return this.IsParamNull(TAG_READONLYMODE);
    }

    public final boolean getREADONLYMODE() {
        return this.GetParamIntValue(TAG_READONLYMODE, 0) == 1;
    }

    public final void setREADONLYMODE(boolean bValue) {
        this.SetParamValue(TAG_READONLYMODE, bValue ? 1 : 0);
    }

    public final boolean isGITPATHNull() {
        return this.IsParamNull(TAG_GITPATH);
    }

    public final String getGITPATH() {
        return this.GetParamStringValue(TAG_GITPATH, "");
    }

    public final void setGITPATH(String strValue) {
        this.SetParamValue(TAG_GITPATH, strValue);
    }

    public final boolean isSVNTYPENull() {
        return this.IsParamNull(TAG_SVNTYPE);
    }

    public final String getSVNTYPE() {
        return this.GetParamStringValue(TAG_SVNTYPE, "");
    }

    public final void setSVNTYPE(String strValue) {
        this.SetParamValue(TAG_SVNTYPE, strValue);
    }

    public final boolean isPSGITUSERIDNull() {
        return this.IsParamNull(TAG_PSGITUSERID);
    }

    public final String getPSGITUSERID() {
        return this.GetParamStringValue(TAG_PSGITUSERID, "");
    }

    public final void setPSGITUSERID(String strValue) {
        this.SetParamValue(TAG_PSGITUSERID, strValue);
    }

    public final boolean isPSGITUSERNAMENull() {
        return this.IsParamNull(TAG_PSGITUSERNAME);
    }

    public final String getPSGITUSERNAME() {
        return this.GetParamStringValue(TAG_PSGITUSERNAME, "");
    }

    public final void setPSGITUSERNAME(String strValue) {
        this.SetParamValue(TAG_PSGITUSERNAME, strValue);
    }

    public final boolean isREFOBJIDNull() {
        return this.IsParamNull(TAG_REFOBJID);
    }

    public final String getREFOBJID() {
        return this.GetParamStringValue(TAG_REFOBJID, "");
    }

    public final void setREFOBJID(String strValue) {
        this.SetParamValue(TAG_REFOBJID, strValue);
    }

    public final boolean isLOCALRESNull() {
        return this.IsParamNull(TAG_LOCALRES);
    }

    public final boolean getLOCALRES() {
        return this.GetParamIntValue(TAG_LOCALRES, 0) == 1;
    }

    public final void setLOCALRES(boolean bValue) {
        this.SetParamValue(TAG_LOCALRES, bValue ? 1 : 0);
    }

    public final boolean isGITBRANCHNull() {
        return this.IsParamNull(TAG_GITBRANCH);
    }

    public final String getGITBRANCH() {
        return this.GetParamStringValue(TAG_GITBRANCH, "");
    }

    public final void setGITBRANCH(String strValue) {
        this.SetParamValue(TAG_GITBRANCH, strValue);
    }
}

