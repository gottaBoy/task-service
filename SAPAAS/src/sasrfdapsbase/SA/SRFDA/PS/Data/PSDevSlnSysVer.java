/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDevSlnSysVer
extends BaseDataEntity {
    public static final int PACKSTATE_0 = 0;
    public static final int PACKSTATE_1 = 1;
    public static final int PACKSTATE_2 = 2;
    public static final String TAG_PSDEVSLNSYSVERID = "PSDEVSLNSYSVERID";
    public static final String TAG_PSDEVSLNSYSVERNAME = "PSDEVSLNSYSVERNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String TAG_PSDEVSLNSYSNAME = "PSDEVSLNSYSNAME";
    public static final String TAG_VERPSDEVSLNSYSID = "VERPSDEVSLNSYSID";
    public static final String TAG_VERPSDEVSLNSYSNAME = "VERPSDEVSLNSYSNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String TAG_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String TAG_VERLOG = "VERLOG";
    public static final String TAG_VERDETAIL = "VERDETAIL";
    public static final String TAG_PSDEVSLNID = "PSDEVSLNID";
    public static final String TAG_PSDEVSLNNAME = "PSDEVSLNNAME";
    public static final String TAG_VERSION = "VERSION";
    public static final String TAG_PACKSTATE = "PACKSTATE";
    public static final String TAG_PSDEVCENTERDBINSTID = "PSDEVCENTERDBINSTID";
    public static final String TAG_PSDEVCENTERDBINSTNAME = "PSDEVCENTERDBINSTNAME";
    public static final String TAG_PACKSYSMODELINST = "PACKSYSMODELINST";
    public static final String TAG_PSSYSMODELINSTID = "PSSYSMODELINSTID";
    public static final String TAG_PSSYSMODELINSTNAME = "PSSYSMODELINSTNAME";
    public static final String TAG_PACKMODELINST = "PACKMODELINST";

    public final boolean isPSDEVSLNSYSVERIDNull() {
        return this.IsParamNull(TAG_PSDEVSLNSYSVERID);
    }

    public final String getPSDEVSLNSYSVERID() {
        return this.GetParamStringValue(TAG_PSDEVSLNSYSVERID, "");
    }

    public final void setPSDEVSLNSYSVERID(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNSYSVERID, strValue);
    }

    public final boolean isPSDEVSLNSYSVERNAMENull() {
        return this.IsParamNull(TAG_PSDEVSLNSYSVERNAME);
    }

    public final String getPSDEVSLNSYSVERNAME() {
        return this.GetParamStringValue(TAG_PSDEVSLNSYSVERNAME, "");
    }

    public final void setPSDEVSLNSYSVERNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNSYSVERNAME, strValue);
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

    public final boolean isVERPSDEVSLNSYSIDNull() {
        return this.IsParamNull(TAG_VERPSDEVSLNSYSID);
    }

    public final String getVERPSDEVSLNSYSID() {
        return this.GetParamStringValue(TAG_VERPSDEVSLNSYSID, "");
    }

    public final void setVERPSDEVSLNSYSID(String strValue) {
        this.SetParamValue(TAG_VERPSDEVSLNSYSID, strValue);
    }

    public final boolean isVERPSDEVSLNSYSNAMENull() {
        return this.IsParamNull(TAG_VERPSDEVSLNSYSNAME);
    }

    public final String getVERPSDEVSLNSYSNAME() {
        return this.GetParamStringValue(TAG_VERPSDEVSLNSYSNAME, "");
    }

    public final void setVERPSDEVSLNSYSNAME(String strValue) {
        this.SetParamValue(TAG_VERPSDEVSLNSYSNAME, strValue);
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

    public final boolean isVERLOGNull() {
        return this.IsParamNull(TAG_VERLOG);
    }

    public final String getVERLOG() {
        return this.GetParamStringValue(TAG_VERLOG, "");
    }

    public final void setVERLOG(String strValue) {
        this.SetParamValue(TAG_VERLOG, strValue);
    }

    public final boolean isVERDETAILNull() {
        return this.IsParamNull(TAG_VERDETAIL);
    }

    public final String getVERDETAIL() {
        return this.GetParamStringValue(TAG_VERDETAIL, "");
    }

    public final void setVERDETAIL(String strValue) {
        this.SetParamValue(TAG_VERDETAIL, strValue);
    }

    public final boolean isPSDEVSLNIDNull() {
        return this.IsParamNull(TAG_PSDEVSLNID);
    }

    public final String getPSDEVSLNID() {
        return this.GetParamStringValue(TAG_PSDEVSLNID, "");
    }

    public final void setPSDEVSLNID(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNID, strValue);
    }

    public final boolean isPSDEVSLNNAMENull() {
        return this.IsParamNull(TAG_PSDEVSLNNAME);
    }

    public final String getPSDEVSLNNAME() {
        return this.GetParamStringValue(TAG_PSDEVSLNNAME, "");
    }

    public final void setPSDEVSLNNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNNAME, strValue);
    }

    public final boolean isVERSIONNull() {
        return this.IsParamNull(TAG_VERSION);
    }

    public final String getVERSION() {
        return this.GetParamStringValue(TAG_VERSION, "");
    }

    public final void setVERSION(String strValue) {
        this.SetParamValue(TAG_VERSION, strValue);
    }

    public final boolean isPACKSTATENull() {
        return this.IsParamNull(TAG_PACKSTATE);
    }

    public final int getPACKSTATE() {
        return this.GetParamIntValue(TAG_PACKSTATE, 0);
    }

    public final void setPACKSTATE(int nValue) {
        this.SetParamValue(TAG_PACKSTATE, nValue);
    }

    public final boolean isPSDEVCENTERDBINSTIDNull() {
        return this.IsParamNull(TAG_PSDEVCENTERDBINSTID);
    }

    public final String getPSDEVCENTERDBINSTID() {
        return this.GetParamStringValue(TAG_PSDEVCENTERDBINSTID, "");
    }

    public final void setPSDEVCENTERDBINSTID(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERDBINSTID, strValue);
    }

    public final boolean isPSDEVCENTERDBINSTNAMENull() {
        return this.IsParamNull(TAG_PSDEVCENTERDBINSTNAME);
    }

    public final String getPSDEVCENTERDBINSTNAME() {
        return this.GetParamStringValue(TAG_PSDEVCENTERDBINSTNAME, "");
    }

    public final void setPSDEVCENTERDBINSTNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERDBINSTNAME, strValue);
    }

    public final boolean isPACKSYSMODELINSTNull() {
        return this.IsParamNull(TAG_PACKSYSMODELINST);
    }

    public final boolean getPACKSYSMODELINST() {
        return this.GetParamIntValue(TAG_PACKSYSMODELINST, 0) == 1;
    }

    public final void setPACKSYSMODELINST(boolean bValue) {
        this.SetParamValue(TAG_PACKSYSMODELINST, bValue ? 1 : 0);
    }

    public final boolean isPSSYSMODELINSTIDNull() {
        return this.IsParamNull(TAG_PSSYSMODELINSTID);
    }

    public final String getPSSYSMODELINSTID() {
        return this.GetParamStringValue(TAG_PSSYSMODELINSTID, "");
    }

    public final void setPSSYSMODELINSTID(String strValue) {
        this.SetParamValue(TAG_PSSYSMODELINSTID, strValue);
    }

    public final boolean isPSSYSMODELINSTNAMENull() {
        return this.IsParamNull(TAG_PSSYSMODELINSTNAME);
    }

    public final String getPSSYSMODELINSTNAME() {
        return this.GetParamStringValue(TAG_PSSYSMODELINSTNAME, "");
    }

    public final void setPSSYSMODELINSTNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSMODELINSTNAME, strValue);
    }

    public final boolean isPACKMODELINSTNull() {
        return this.IsParamNull(TAG_PACKMODELINST);
    }

    public final boolean getPACKMODELINST() {
        return this.GetParamIntValue(TAG_PACKMODELINST, 0) == 1;
    }

    public final void setPACKMODELINST(boolean bValue) {
        this.SetParamValue(TAG_PACKMODELINST, bValue ? 1 : 0);
    }
}

