/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSHelpPrjTempl
extends BaseDataEntity {
    public static final int PUBMODE_1 = 1;
    public static final int PUBMODE_2 = 2;
    public static final String TAG_PSHELPPRJTEMPLID = "PSHELPPRJTEMPLID";
    public static final String TAG_PSHELPPRJTEMPLNAME = "PSHELPPRJTEMPLNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PUBOBJ = "PUBOBJ";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_TEMPLCODE = "TEMPLCODE";
    public static final String TAG_TEMPLCODE2 = "TEMPLCODE2";
    public static final String TAG_PUBMODE = "PUBMODE";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String TAG_PSHELPPRJTYPEID = "PSHELPPRJTYPEID";
    public static final String TAG_PSHELPPRJTYPENAME = "PSHELPPRJTYPENAME";
    public static final String TAG_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String TAG_PSDEVCENTERNAME = "PSDEVCENTERNAME";

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

    public final boolean isPUBOBJNull() {
        return this.IsParamNull(TAG_PUBOBJ);
    }

    public final String getPUBOBJ() {
        return this.GetParamStringValue(TAG_PUBOBJ, "");
    }

    public final void setPUBOBJ(String strValue) {
        this.SetParamValue(TAG_PUBOBJ, strValue);
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

    public final boolean isTEMPLCODENull() {
        return this.IsParamNull(TAG_TEMPLCODE);
    }

    public final String getTEMPLCODE() {
        return this.GetParamStringValue(TAG_TEMPLCODE, "");
    }

    public final void setTEMPLCODE(String strValue) {
        this.SetParamValue(TAG_TEMPLCODE, strValue);
    }

    public final boolean isTEMPLCODE2Null() {
        return this.IsParamNull(TAG_TEMPLCODE2);
    }

    public final String getTEMPLCODE2() {
        return this.GetParamStringValue(TAG_TEMPLCODE2, "");
    }

    public final void setTEMPLCODE2(String strValue) {
        this.SetParamValue(TAG_TEMPLCODE2, strValue);
    }

    public final boolean isPUBMODENull() {
        return this.IsParamNull(TAG_PUBMODE);
    }

    public final int getPUBMODE() {
        return this.GetParamIntValue(TAG_PUBMODE, 0);
    }

    public final void setPUBMODE(int nValue) {
        this.SetParamValue(TAG_PUBMODE, nValue);
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

    public final boolean isDEFAULTFLAGNull() {
        return this.IsParamNull(TAG_DEFAULTFLAG);
    }

    public final boolean getDEFAULTFLAG() {
        return this.GetParamIntValue(TAG_DEFAULTFLAG, 0) == 1;
    }

    public final void setDEFAULTFLAG(boolean bValue) {
        this.SetParamValue(TAG_DEFAULTFLAG, bValue ? 1 : 0);
    }

    public final boolean isPSHELPPRJTYPEIDNull() {
        return this.IsParamNull(TAG_PSHELPPRJTYPEID);
    }

    public final String getPSHELPPRJTYPEID() {
        return this.GetParamStringValue(TAG_PSHELPPRJTYPEID, "");
    }

    public final void setPSHELPPRJTYPEID(String strValue) {
        this.SetParamValue(TAG_PSHELPPRJTYPEID, strValue);
    }

    public final boolean isPSHELPPRJTYPENAMENull() {
        return this.IsParamNull(TAG_PSHELPPRJTYPENAME);
    }

    public final String getPSHELPPRJTYPENAME() {
        return this.GetParamStringValue(TAG_PSHELPPRJTYPENAME, "");
    }

    public final void setPSHELPPRJTYPENAME(String strValue) {
        this.SetParamValue(TAG_PSHELPPRJTYPENAME, strValue);
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
}

