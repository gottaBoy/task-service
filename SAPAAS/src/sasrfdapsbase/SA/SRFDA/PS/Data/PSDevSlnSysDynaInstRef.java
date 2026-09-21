/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDevSlnSysDynaInstRef
extends BaseDataEntity {
    public static final String TAG_INSTMODELPATH = "INSTMODELPATH";
    public static final String TAG_PSDEVSLNSYSDYNAINSTREFID = "PSDEVSLNSYSDYNAINSTREFID";
    public static final String TAG_PSDEVSLNSYSDYNAINSTREFNAME = "PSDEVSLNSYSDYNAINSTREFNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEVSLNSYSDYNAINSTID = "PSDEVSLNSYSDYNAINSTID";
    public static final String TAG_PSDEVSLNSYSDYNAINSTNAME = "PSDEVSLNSYSDYNAINSTNAME";
    public static final String TAG_REFPSDEVSLNSYSDYNAINSTID = "REFPSDEVSLNSYSDYNAINSTID";
    public static final String TAG_REFPSDEVSLNSYSDYNAINSTNAME = "REFPSDEVSLNSYSDYNAINSTNAME";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_REFTAG = "REFTAG";
    public static final String TAG_REFTAG2 = "REFTAG2";
    public static final String TAG_REFTAG3 = "REFTAG3";
    public static final String TAG_REFTAG4 = "REFTAG4";
    public static final String TAG_REFTAG5 = "REFTAG5";
    public static final String TAG_REFTAG6 = "REFTAG6";
    public static final String TAG_REFTAG7 = "REFTAG7";
    public static final String TAG_REFTAG8 = "REFTAG8";
    public static final String TAG_PSDEVSLNSYSDEPINSTID = "PSDEVSLNSYSDEPINSTID";

    public final boolean isPSDEVSLNSYSDYNAINSTREFIDNull() {
        return this.IsParamNull(TAG_PSDEVSLNSYSDYNAINSTREFID);
    }

    public final String getPSDEVSLNSYSDYNAINSTREFID() {
        return this.GetParamStringValue(TAG_PSDEVSLNSYSDYNAINSTREFID, "");
    }

    public final void setPSDEVSLNSYSDYNAINSTREFID(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNSYSDYNAINSTREFID, strValue);
    }

    public final boolean isPSDEVSLNSYSDYNAINSTREFNAMENull() {
        return this.IsParamNull(TAG_PSDEVSLNSYSDYNAINSTREFNAME);
    }

    public final String getPSDEVSLNSYSDYNAINSTREFNAME() {
        return this.GetParamStringValue(TAG_PSDEVSLNSYSDYNAINSTREFNAME, "");
    }

    public final void setPSDEVSLNSYSDYNAINSTREFNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNSYSDYNAINSTREFNAME, strValue);
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

    public final boolean isPSDEVSLNSYSDYNAINSTIDNull() {
        return this.IsParamNull(TAG_PSDEVSLNSYSDYNAINSTID);
    }

    public final String getPSDEVSLNSYSDYNAINSTID() {
        return this.GetParamStringValue(TAG_PSDEVSLNSYSDYNAINSTID, "");
    }

    public final void setPSDEVSLNSYSDYNAINSTID(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNSYSDYNAINSTID, strValue);
    }

    public final boolean isPSDEVSLNSYSDYNAINSTNAMENull() {
        return this.IsParamNull(TAG_PSDEVSLNSYSDYNAINSTNAME);
    }

    public final String getPSDEVSLNSYSDYNAINSTNAME() {
        return this.GetParamStringValue(TAG_PSDEVSLNSYSDYNAINSTNAME, "");
    }

    public final void setPSDEVSLNSYSDYNAINSTNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNSYSDYNAINSTNAME, strValue);
    }

    public final boolean isREFPSDEVSLNSYSDYNAINSTIDNull() {
        return this.IsParamNull(TAG_REFPSDEVSLNSYSDYNAINSTID);
    }

    public final String getREFPSDEVSLNSYSDYNAINSTID() {
        return this.GetParamStringValue(TAG_REFPSDEVSLNSYSDYNAINSTID, "");
    }

    public final void setREFPSDEVSLNSYSDYNAINSTID(String strValue) {
        this.SetParamValue(TAG_REFPSDEVSLNSYSDYNAINSTID, strValue);
    }

    public final boolean isREFPSDEVSLNSYSDYNAINSTNAMENull() {
        return this.IsParamNull(TAG_REFPSDEVSLNSYSDYNAINSTNAME);
    }

    public final String getREFPSDEVSLNSYSDYNAINSTNAME() {
        return this.GetParamStringValue(TAG_REFPSDEVSLNSYSDYNAINSTNAME, "");
    }

    public final void setREFPSDEVSLNSYSDYNAINSTNAME(String strValue) {
        this.SetParamValue(TAG_REFPSDEVSLNSYSDYNAINSTNAME, strValue);
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

    public final boolean isORDERVALUENull() {
        return this.IsParamNull(TAG_ORDERVALUE);
    }

    public final int getORDERVALUE() {
        return this.GetParamIntValue(TAG_ORDERVALUE, 0);
    }

    public final void setORDERVALUE(int nValue) {
        this.SetParamValue(TAG_ORDERVALUE, nValue);
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

    public final boolean isREFTAGNull() {
        return this.IsParamNull(TAG_REFTAG);
    }

    public final String getREFTAG() {
        return this.GetParamStringValue(TAG_REFTAG, "");
    }

    public final void setREFTAG(String strValue) {
        this.SetParamValue(TAG_REFTAG, strValue);
    }

    public final boolean isREFTAG2Null() {
        return this.IsParamNull(TAG_REFTAG2);
    }

    public final String getREFTAG2() {
        return this.GetParamStringValue(TAG_REFTAG2, "");
    }

    public final void setREFTAG2(String strValue) {
        this.SetParamValue(TAG_REFTAG2, strValue);
    }

    public final boolean isREFTAG3Null() {
        return this.IsParamNull(TAG_REFTAG3);
    }

    public final String getREFTAG3() {
        return this.GetParamStringValue(TAG_REFTAG3, "");
    }

    public final void setREFTAG3(String strValue) {
        this.SetParamValue(TAG_REFTAG3, strValue);
    }

    public final boolean isREFTAG4Null() {
        return this.IsParamNull(TAG_REFTAG4);
    }

    public final String getREFTAG4() {
        return this.GetParamStringValue(TAG_REFTAG4, "");
    }

    public final void setREFTAG4(String strValue) {
        this.SetParamValue(TAG_REFTAG4, strValue);
    }

    public final boolean isREFTAG5Null() {
        return this.IsParamNull(TAG_REFTAG5);
    }

    public final String getREFTAG5() {
        return this.GetParamStringValue(TAG_REFTAG5, "");
    }

    public final void setREFTAG5(String strValue) {
        this.SetParamValue(TAG_REFTAG5, strValue);
    }

    public final boolean isREFTAG6Null() {
        return this.IsParamNull(TAG_REFTAG6);
    }

    public final String getREFTAG6() {
        return this.GetParamStringValue(TAG_REFTAG6, "");
    }

    public final void setREFTAG6(String strValue) {
        this.SetParamValue(TAG_REFTAG6, strValue);
    }

    public final boolean isREFTAG7Null() {
        return this.IsParamNull(TAG_REFTAG7);
    }

    public final String getREFTAG7() {
        return this.GetParamStringValue(TAG_REFTAG7, "");
    }

    public final void setREFTAG7(String strValue) {
        this.SetParamValue(TAG_REFTAG7, strValue);
    }

    public final boolean isREFTAG8Null() {
        return this.IsParamNull(TAG_REFTAG8);
    }

    public final String getREFTAG8() {
        return this.GetParamStringValue(TAG_REFTAG8, "");
    }

    public final void setREFTAG8(String strValue) {
        this.SetParamValue(TAG_REFTAG8, strValue);
    }

    public final boolean isPSDEVSLNSYSDEPINSTIDNull() {
        return this.IsParamNull(TAG_PSDEVSLNSYSDEPINSTID);
    }

    public final String getPSDEVSLNSYSDEPINSTID() {
        return this.GetParamStringValue(TAG_PSDEVSLNSYSDEPINSTID, "");
    }

    public final void setPSDEVSLNSYSDEPINSTID(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNSYSDEPINSTID, strValue);
    }

    public final boolean isINSTMODELPATHNull() {
        return this.IsParamNull(TAG_INSTMODELPATH);
    }

    public final String getINSTMODELPATH() {
        return this.GetParamStringValue(TAG_INSTMODELPATH, "");
    }

    public final void setINSTMODELPATH(String strValue) {
        this.SetParamValue(TAG_INSTMODELPATH, strValue);
    }
}

