/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDCMavenRepo
extends BaseDataEntity {
    public static final String TAG_PSDCMAVENREPOID = "PSDCMAVENREPOID";
    public static final String TAG_PSDCMAVENREPONAME = "PSDCMAVENREPONAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String TAG_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String TAG_ROPASSWD = "ROPASSWD";
    public static final String TAG_ROUSERNAME = "ROUSERNAME";
    public static final String TAG_MAVENPASSWD = "MAVENPASSWD";
    public static final String TAG_MAVENUSERNAME = "MAVENUSERNAME";
    public static final String TAG_CONNSTR = "CONNSTR";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PARAM = "PARAM";
    public static final String TAG_PARAM2 = "PARAM2";
    public static final String TAG_PARAM3 = "PARAM3";
    public static final String TAG_PARAM4 = "PARAM4";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_DEFAULTFLAG = "DEFAULTFLAG";

    public final boolean isPSDCMAVENREPOIDNull() {
        return this.IsParamNull(TAG_PSDCMAVENREPOID);
    }

    public final String getPSDCMAVENREPOID() {
        return this.GetParamStringValue(TAG_PSDCMAVENREPOID, "");
    }

    public final void setPSDCMAVENREPOID(String strValue) {
        this.SetParamValue(TAG_PSDCMAVENREPOID, strValue);
    }

    public final boolean isPSDCMAVENREPONAMENull() {
        return this.IsParamNull(TAG_PSDCMAVENREPONAME);
    }

    public final String getPSDCMAVENREPONAME() {
        return this.GetParamStringValue(TAG_PSDCMAVENREPONAME, "");
    }

    public final void setPSDCMAVENREPONAME(String strValue) {
        this.SetParamValue(TAG_PSDCMAVENREPONAME, strValue);
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

    public final boolean isROPASSWDNull() {
        return this.IsParamNull(TAG_ROPASSWD);
    }

    public final String getROPASSWD() {
        return this.GetParamStringValue(TAG_ROPASSWD, "");
    }

    public final void setROPASSWD(String strValue) {
        this.SetParamValue(TAG_ROPASSWD, strValue);
    }

    public final boolean isROUSERNAMENull() {
        return this.IsParamNull(TAG_ROUSERNAME);
    }

    public final String getROUSERNAME() {
        return this.GetParamStringValue(TAG_ROUSERNAME, "");
    }

    public final void setROUSERNAME(String strValue) {
        this.SetParamValue(TAG_ROUSERNAME, strValue);
    }

    public final boolean isMAVENPASSWDNull() {
        return this.IsParamNull(TAG_MAVENPASSWD);
    }

    public final String getMAVENPASSWD() {
        return this.GetParamStringValue(TAG_MAVENPASSWD, "");
    }

    public final void setMAVENPASSWD(String strValue) {
        this.SetParamValue(TAG_MAVENPASSWD, strValue);
    }

    public final boolean isMAVENUSERNAMENull() {
        return this.IsParamNull(TAG_MAVENUSERNAME);
    }

    public final String getMAVENUSERNAME() {
        return this.GetParamStringValue(TAG_MAVENUSERNAME, "");
    }

    public final void setMAVENUSERNAME(String strValue) {
        this.SetParamValue(TAG_MAVENUSERNAME, strValue);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isPARAMNull() {
        return this.IsParamNull(TAG_PARAM);
    }

    public final String getPARAM() {
        return this.GetParamStringValue(TAG_PARAM, "");
    }

    public final void setPARAM(String strValue) {
        this.SetParamValue(TAG_PARAM, strValue);
    }

    public final boolean isPARAM2Null() {
        return this.IsParamNull(TAG_PARAM2);
    }

    public final String getPARAM2() {
        return this.GetParamStringValue(TAG_PARAM2, "");
    }

    public final void setPARAM2(String strValue) {
        this.SetParamValue(TAG_PARAM2, strValue);
    }

    public final boolean isPARAM3Null() {
        return this.IsParamNull(TAG_PARAM3);
    }

    public final String getPARAM3() {
        return this.GetParamStringValue(TAG_PARAM3, "");
    }

    public final void setPARAM3(String strValue) {
        this.SetParamValue(TAG_PARAM3, strValue);
    }

    public final boolean isPARAM4Null() {
        return this.IsParamNull(TAG_PARAM4);
    }

    public final String getPARAM4() {
        return this.GetParamStringValue(TAG_PARAM4, "");
    }

    public final void setPARAM4(String strValue) {
        this.SetParamValue(TAG_PARAM4, strValue);
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

    public final boolean isDEFAULTFLAGNull() {
        return this.IsParamNull(TAG_DEFAULTFLAG);
    }

    public final boolean getDEFAULTFLAG() {
        return this.GetParamIntValue(TAG_DEFAULTFLAG, 0) == 1;
    }

    public final void setDEFAULTFLAG(boolean bValue) {
        this.SetParamValue(TAG_DEFAULTFLAG, bValue ? 1 : 0);
    }
}

