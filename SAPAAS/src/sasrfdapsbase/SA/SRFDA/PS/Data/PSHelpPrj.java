/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFDA.PS.Data.PSHelpModule;
import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.ArrayList;
import java.util.Date;

public class PSHelpPrj
extends BaseDataEntity {
    public static final String PRJTYPE_COMMON = "COMMON";
    public static final String TAG_PSHELPPRJID = "PSHELPPRJID";
    public static final String TAG_PSHELPPRJNAME = "PSHELPPRJNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_TITLE = "TITLE";
    public static final String TAG_PRJSN = "PRJSN";
    public static final String TAG_PRJVER = "PRJVER";
    public static final String TAG_PRJTYPE = "PRJTYPE";
    public static final String TAG_CONTENT = "CONTENT";
    public static final String TAG_HEADERCONTENT = "HEADERCONTENT";
    public static final String TAG_BOTTOMCONTENT = "BOTTOMCONTENT";
    public static final String TAG_SUBCAPTION = "SUBCAPTION";
    public static final String TAG_PSHELPPRJTEMPLID = "PSHELPPRJTEMPLID";
    public static final String TAG_PSHELPPRJTEMPLNAME = "PSHELPPRJTEMPLNAME";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_PRJPARAM = "PRJPARAM";
    public static final String TAG_PRJPARAM2 = "PRJPARAM2";
    public static final String TAG_PSMODULEID = "PSMODULEID";
    public static final String TAG_PSMODULENAME = "PSMODULENAME";
    private ArrayList<PSHelpModule> rootPSHelpModuleList = null;

    public final boolean isPSHELPPRJIDNull() {
        return this.IsParamNull(TAG_PSHELPPRJID);
    }

    public final String getPSHELPPRJID() {
        return this.GetParamStringValue(TAG_PSHELPPRJID, "");
    }

    public final void setPSHELPPRJID(String strValue) {
        this.SetParamValue(TAG_PSHELPPRJID, strValue);
    }

    public final boolean isPSHELPPRJNAMENull() {
        return this.IsParamNull(TAG_PSHELPPRJNAME);
    }

    public final String getPSHELPPRJNAME() {
        return this.GetParamStringValue(TAG_PSHELPPRJNAME, "");
    }

    public final void setPSHELPPRJNAME(String strValue) {
        this.SetParamValue(TAG_PSHELPPRJNAME, strValue);
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

    public final boolean isTITLENull() {
        return this.IsParamNull(TAG_TITLE);
    }

    public final String getTITLE() {
        return this.GetParamStringValue(TAG_TITLE, "");
    }

    public final void setTITLE(String strValue) {
        this.SetParamValue(TAG_TITLE, strValue);
    }

    public final boolean isPRJSNNull() {
        return this.IsParamNull(TAG_PRJSN);
    }

    public final String getPRJSN() {
        return this.GetParamStringValue(TAG_PRJSN, "");
    }

    public final void setPRJSN(String strValue) {
        this.SetParamValue(TAG_PRJSN, strValue);
    }

    public final boolean isPRJVERNull() {
        return this.IsParamNull(TAG_PRJVER);
    }

    public final String getPRJVER() {
        return this.GetParamStringValue(TAG_PRJVER, "");
    }

    public final void setPRJVER(String strValue) {
        this.SetParamValue(TAG_PRJVER, strValue);
    }

    public final boolean isPRJTYPENull() {
        return this.IsParamNull(TAG_PRJTYPE);
    }

    public final String getPRJTYPE() {
        return this.GetParamStringValue(TAG_PRJTYPE, "");
    }

    public final void setPRJTYPE(String strValue) {
        this.SetParamValue(TAG_PRJTYPE, strValue);
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

    public final boolean isHEADERCONTENTNull() {
        return this.IsParamNull(TAG_HEADERCONTENT);
    }

    public final String getHEADERCONTENT() {
        return this.GetParamStringValue(TAG_HEADERCONTENT, "");
    }

    public final void setHEADERCONTENT(String strValue) {
        this.SetParamValue(TAG_HEADERCONTENT, strValue);
    }

    public final boolean isBOTTOMCONTENTNull() {
        return this.IsParamNull(TAG_BOTTOMCONTENT);
    }

    public final String getBOTTOMCONTENT() {
        return this.GetParamStringValue(TAG_BOTTOMCONTENT, "");
    }

    public final void setBOTTOMCONTENT(String strValue) {
        this.SetParamValue(TAG_BOTTOMCONTENT, strValue);
    }

    public final boolean isSUBCAPTIONNull() {
        return this.IsParamNull(TAG_SUBCAPTION);
    }

    public final String getSUBCAPTION() {
        return this.GetParamStringValue(TAG_SUBCAPTION, "");
    }

    public final void setSUBCAPTION(String strValue) {
        this.SetParamValue(TAG_SUBCAPTION, strValue);
    }

    public final boolean isPSHELPPRJTEMPLIDNull() {
        return this.IsParamNull(TAG_PSHELPPRJTEMPLID);
    }

    public final String getPSHELPPRJTEMPLID() {
        return this.GetParamStringValue(TAG_PSHELPPRJTEMPLID, "");
    }

    public final void setPSHELPPRJTEMPLID(String strValue) {
        this.SetParamValue(TAG_PSHELPPRJTEMPLID, strValue);
    }

    public final boolean isPSHELPPRJTEMPLNAMENull() {
        return this.IsParamNull(TAG_PSHELPPRJTEMPLNAME);
    }

    public final String getPSHELPPRJTEMPLNAME() {
        return this.GetParamStringValue(TAG_PSHELPPRJTEMPLNAME, "");
    }

    public final void setPSHELPPRJTEMPLNAME(String strValue) {
        this.SetParamValue(TAG_PSHELPPRJTEMPLNAME, strValue);
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

    public final boolean isPRJPARAMNull() {
        return this.IsParamNull(TAG_PRJPARAM);
    }

    public final String getPRJPARAM() {
        return this.GetParamStringValue(TAG_PRJPARAM, "");
    }

    public final void setPRJPARAM(String strValue) {
        this.SetParamValue(TAG_PRJPARAM, strValue);
    }

    public final boolean isPRJPARAM2Null() {
        return this.IsParamNull(TAG_PRJPARAM2);
    }

    public final String getPRJPARAM2() {
        return this.GetParamStringValue(TAG_PRJPARAM2, "");
    }

    public final void setPRJPARAM2(String strValue) {
        this.SetParamValue(TAG_PRJPARAM2, strValue);
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

    public ArrayList<PSHelpModule> getRootPSHelpModules(boolean bCreated) {
        if (this.rootPSHelpModuleList != null) {
            return this.rootPSHelpModuleList;
        }
        if (bCreated) {
            this.rootPSHelpModuleList = new ArrayList();
        }
        return this.rootPSHelpModuleList;
    }

    public void resetChildDatas() {
        if (this.rootPSHelpModuleList != null) {
            this.rootPSHelpModuleList.clear();
            this.rootPSHelpModuleList = null;
        }
    }
}

