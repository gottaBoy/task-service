/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDevCenterSVN
extends BaseDataEntity {
    public static final String SVNTYPE_SVN = "SVN";
    public static final String SVNTYPE_GIT = "GIT";
    public static final String GITREPO_IBIZ = "IBIZ";
    public static final String GITREPO_GITEE = "GITEE";
    public static final String GITREPO_OTHER = "OTHER";
    public static final String TAG_PSDEVCENTERSVNID = "PSDEVCENTERSVNID";
    public static final String TAG_PSDEVCENTERSVNNAME = "PSDEVCENTERSVNNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSVNINSTREPOID = "PSSVNINSTREPOID";
    public static final String TAG_PSSVNINSTREPONAME = "PSSVNINSTREPONAME";
    public static final String TAG_REFFLAG = "REFFLAG";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_REFOBJID = "REFOBJID";
    public static final String TAG_REFOBJNAME = "REFOBJNAME";
    public static final String TAG_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String TAG_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String TAG_SVNTYPE = "SVNTYPE";
    public static final String TAG_PSGITUSERID = "PSGITUSERID";
    public static final String TAG_PSGITUSERNAME = "PSGITUSERNAME";
    public static final String TAG_GITPATH = "GITPATH";
    public static final String TAG_RESSTATE = "RESSTATE";
    public static final String TAG_RESPOS = "RESPOS";
    public static final String TAG_EXPRIEDTIME = "EXPRIEDTIME";
    public static final String TAG_GITPRJ = "GITPRJ";
    public static final String TAG_GITREPO = "GITREPO";
    public static final String TAG_GITBRANCH = "GITBRANCH";

    public final boolean isPSDEVCENTERSVNIDNull() {
        return this.IsParamNull(TAG_PSDEVCENTERSVNID);
    }

    public final String getPSDEVCENTERSVNID() {
        return this.GetParamStringValue(TAG_PSDEVCENTERSVNID, "");
    }

    public final void setPSDEVCENTERSVNID(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERSVNID, strValue);
    }

    public final boolean isPSDEVCENTERSVNNAMENull() {
        return this.IsParamNull(TAG_PSDEVCENTERSVNNAME);
    }

    public final String getPSDEVCENTERSVNNAME() {
        return this.GetParamStringValue(TAG_PSDEVCENTERSVNNAME, "");
    }

    public final void setPSDEVCENTERSVNNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERSVNNAME, strValue);
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

    public final boolean isREFFLAGNull() {
        return this.IsParamNull(TAG_REFFLAG);
    }

    public final boolean getREFFLAG() {
        return this.GetParamIntValue(TAG_REFFLAG, 0) == 1;
    }

    public final void setREFFLAG(boolean bValue) {
        this.SetParamValue(TAG_REFFLAG, bValue ? 1 : 0);
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

    public final boolean isREFOBJIDNull() {
        return this.IsParamNull(TAG_REFOBJID);
    }

    public final String getREFOBJID() {
        return this.GetParamStringValue(TAG_REFOBJID, "");
    }

    public final void setREFOBJID(String strValue) {
        this.SetParamValue(TAG_REFOBJID, strValue);
    }

    public final boolean isREFOBJNAMENull() {
        return this.IsParamNull(TAG_REFOBJNAME);
    }

    public final String getREFOBJNAME() {
        return this.GetParamStringValue(TAG_REFOBJNAME, "");
    }

    public final void setREFOBJNAME(String strValue) {
        this.SetParamValue(TAG_REFOBJNAME, strValue);
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

    public final boolean isGITPATHNull() {
        return this.IsParamNull(TAG_GITPATH);
    }

    public final String getGITPATH() {
        return this.GetParamStringValue(TAG_GITPATH, "");
    }

    public final void setGITPATH(String strValue) {
        this.SetParamValue(TAG_GITPATH, strValue);
    }

    public final boolean isRESSTATENull() {
        return this.IsParamNull(TAG_RESSTATE);
    }

    public final int getRESSTATE() {
        return this.GetParamIntValue(TAG_RESSTATE, 0);
    }

    public final void setRESSTATE(int nValue) {
        this.SetParamValue(TAG_RESSTATE, nValue);
    }

    public final boolean isRESPOSNull() {
        return this.IsParamNull(TAG_RESPOS);
    }

    public final int getRESPOS() {
        return this.GetParamIntValue(TAG_RESPOS, 0);
    }

    public final void setRESPOS(int nValue) {
        this.SetParamValue(TAG_RESPOS, nValue);
    }

    public final boolean isEXPRIEDTIMENull() {
        return this.IsParamNull(TAG_EXPRIEDTIME);
    }

    public final Date getEXPRIEDTIME() {
        return this.GetParamDateValue(TAG_EXPRIEDTIME, null);
    }

    public final void setEXPRIEDTIME(Date dtValue) {
        this.SetParamValue(TAG_EXPRIEDTIME, dtValue);
    }

    public final boolean isGITPRJNull() {
        return this.IsParamNull(TAG_GITPRJ);
    }

    public final String getGITPRJ() {
        return this.GetParamStringValue(TAG_GITPRJ, "");
    }

    public final void setGITPRJ(String strValue) {
        this.SetParamValue(TAG_GITPRJ, strValue);
    }

    public final boolean isGITREPONull() {
        return this.IsParamNull(TAG_GITREPO);
    }

    public final String getGITREPO() {
        return this.GetParamStringValue(TAG_GITREPO, "");
    }

    public final void setGITREPO(String strValue) {
        this.SetParamValue(TAG_GITREPO, strValue);
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

