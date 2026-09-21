/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSViewLogicTypeParam
extends BaseDataEntity {
    public static final String TAG_PSVIEWLOGICTYPEPARAMID = "PSVIEWLOGICTYPEPARAMID";
    public static final String TAG_PSVIEWLOGICTYPEPARAMNAME = "PSVIEWLOGICTYPEPARAMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSVIEWLOGICTYPEID = "PSVIEWLOGICTYPEID";
    public static final String TAG_PSVIEWLOGICTYPENAME = "PSVIEWLOGICTYPENAME";
    public static final String TAG_REFOBJTYPE = "REFOBJTYPE";
    public static final String TAG_PARAMVALUE = "PARAMVALUE";
    public static final String TAG_PARAMDESC = "PARAMDESC";
    public static final String TAG_PARAMVALUE2 = "PARAMVALUE2";
    public static final String TAG_REFOBJSCOPE = "REFOBJSCOPE";
    public static final String TAG_PARAMCAT = "PARAMCAT";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_MAXCOUNT = "MAXCOUNT";
    public static final String TAG_ENABLESUBKEY = "ENABLESUBKEY";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_PARAMTYPE = "PARAMTYPE";
    public static final String TAG_MEMO = "MEMO";

    public final boolean isPSVIEWLOGICTYPEPARAMIDNull() {
        return this.IsParamNull(TAG_PSVIEWLOGICTYPEPARAMID);
    }

    public final String getPSVIEWLOGICTYPEPARAMID() {
        return this.GetParamStringValue(TAG_PSVIEWLOGICTYPEPARAMID, "");
    }

    public final void setPSVIEWLOGICTYPEPARAMID(String strValue) {
        this.SetParamValue(TAG_PSVIEWLOGICTYPEPARAMID, strValue);
    }

    public final boolean isPSVIEWLOGICTYPEPARAMNAMENull() {
        return this.IsParamNull(TAG_PSVIEWLOGICTYPEPARAMNAME);
    }

    public final String getPSVIEWLOGICTYPEPARAMNAME() {
        return this.GetParamStringValue(TAG_PSVIEWLOGICTYPEPARAMNAME, "");
    }

    public final void setPSVIEWLOGICTYPEPARAMNAME(String strValue) {
        this.SetParamValue(TAG_PSVIEWLOGICTYPEPARAMNAME, strValue);
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

    public final boolean isPSVIEWLOGICTYPEIDNull() {
        return this.IsParamNull(TAG_PSVIEWLOGICTYPEID);
    }

    public final String getPSVIEWLOGICTYPEID() {
        return this.GetParamStringValue(TAG_PSVIEWLOGICTYPEID, "");
    }

    public final void setPSVIEWLOGICTYPEID(String strValue) {
        this.SetParamValue(TAG_PSVIEWLOGICTYPEID, strValue);
    }

    public final boolean isPSVIEWLOGICTYPENAMENull() {
        return this.IsParamNull(TAG_PSVIEWLOGICTYPENAME);
    }

    public final String getPSVIEWLOGICTYPENAME() {
        return this.GetParamStringValue(TAG_PSVIEWLOGICTYPENAME, "");
    }

    public final void setPSVIEWLOGICTYPENAME(String strValue) {
        this.SetParamValue(TAG_PSVIEWLOGICTYPENAME, strValue);
    }

    public final boolean isREFOBJTYPENull() {
        return this.IsParamNull(TAG_REFOBJTYPE);
    }

    public final String getREFOBJTYPE() {
        return this.GetParamStringValue(TAG_REFOBJTYPE, "");
    }

    public final void setREFOBJTYPE(String strValue) {
        this.SetParamValue(TAG_REFOBJTYPE, strValue);
    }

    public final boolean isPARAMVALUENull() {
        return this.IsParamNull(TAG_PARAMVALUE);
    }

    public final String getPARAMVALUE() {
        return this.GetParamStringValue(TAG_PARAMVALUE, "");
    }

    public final void setPARAMVALUE(String strValue) {
        this.SetParamValue(TAG_PARAMVALUE, strValue);
    }

    public final boolean isPARAMDESCNull() {
        return this.IsParamNull(TAG_PARAMDESC);
    }

    public final String getPARAMDESC() {
        return this.GetParamStringValue(TAG_PARAMDESC, "");
    }

    public final void setPARAMDESC(String strValue) {
        this.SetParamValue(TAG_PARAMDESC, strValue);
    }

    public final boolean isPARAMVALUE2Null() {
        return this.IsParamNull(TAG_PARAMVALUE2);
    }

    public final String getPARAMVALUE2() {
        return this.GetParamStringValue(TAG_PARAMVALUE2, "");
    }

    public final void setPARAMVALUE2(String strValue) {
        this.SetParamValue(TAG_PARAMVALUE2, strValue);
    }

    public final boolean isREFOBJSCOPENull() {
        return this.IsParamNull(TAG_REFOBJSCOPE);
    }

    public final String getREFOBJSCOPE() {
        return this.GetParamStringValue(TAG_REFOBJSCOPE, "");
    }

    public final void setREFOBJSCOPE(String strValue) {
        this.SetParamValue(TAG_REFOBJSCOPE, strValue);
    }

    public final boolean isPARAMCATNull() {
        return this.IsParamNull(TAG_PARAMCAT);
    }

    public final String getPARAMCAT() {
        return this.GetParamStringValue(TAG_PARAMCAT, "");
    }

    public final void setPARAMCAT(String strValue) {
        this.SetParamValue(TAG_PARAMCAT, strValue);
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

    public final boolean isMAXCOUNTNull() {
        return this.IsParamNull(TAG_MAXCOUNT);
    }

    public final int getMAXCOUNT() {
        return this.GetParamIntValue(TAG_MAXCOUNT, 0);
    }

    public final void setMAXCOUNT(int nValue) {
        this.SetParamValue(TAG_MAXCOUNT, nValue);
    }

    public final boolean isENABLESUBKEYNull() {
        return this.IsParamNull(TAG_ENABLESUBKEY);
    }

    public final boolean getENABLESUBKEY() {
        return this.GetParamIntValue(TAG_ENABLESUBKEY, 0) == 1;
    }

    public final void setENABLESUBKEY(boolean bValue) {
        this.SetParamValue(TAG_ENABLESUBKEY, bValue ? 1 : 0);
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

    public final boolean isPARAMTYPENull() {
        return this.IsParamNull(TAG_PARAMTYPE);
    }

    public final String getPARAMTYPE() {
        return this.GetParamStringValue(TAG_PARAMTYPE, "");
    }

    public final void setPARAMTYPE(String strValue) {
        this.SetParamValue(TAG_PARAMTYPE, strValue);
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
}

