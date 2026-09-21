/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDEOPPrivRole
extends BaseDataEntity {
    public static final String ROLETYPE_SYSROLE = "SYSROLE";
    public static final String ROLETYPE_DEROLE = "DEROLE";
    public static final String ROLETYPE_NONE = "NONE";
    public static final String TAG_PSDEOPPRIVROLEID = "PSDEOPPRIVROLEID";
    public static final String TAG_PSDEOPPRIVROLENAME = "PSDEOPPRIVROLENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_PSDEOPPRIVID = "PSDEOPPRIVID";
    public static final String TAG_PSDEOPPRIVNAME = "PSDEOPPRIVNAME";
    public static final String TAG_ROLETYPE = "ROLETYPE";
    public static final String TAG_PSSYSOPPRIVID = "PSSYSOPPRIVID";
    public static final String TAG_PSSYSOPPRIVNAME = "PSSYSOPPRIVNAME";
    public static final String TAG_PSDEDQID = "PSDEDQID";
    public static final String TAG_PSDEDQNAME = "PSDEDQNAME";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSDEUSERROLEID = "PSDEUSERROLEID";
    public static final String TAG_PSDEUSERROLENAME = "PSDEUSERROLENAME";
    public static final String TAG_PSSYSUSERDRID = "PSSYSUSERDRID";
    public static final String TAG_PSSYSUSERDRNAME = "PSSYSUSERDRNAME";
    public static final String TAG_PSSYSUSERDRID2 = "PSSYSUSERDRID2";
    public static final String TAG_PSSYSUSERDRNAME2 = "PSSYSUSERDRNAME2";
    public static final String TAG_ENABLEUSERDR = "ENABLEUSERDR";
    public static final String TAG_ENABLESECDR = "ENABLESECDR";
    public static final String TAG_ENABLEORGDR = "ENABLEORGDR";
    public static final String TAG_SYSUSERDRPARAM = "SYSUSERDRPARAM";
    public static final String TAG_SYSUSERDR2PARAM = "SYSUSERDR2PARAM";
    public static final String TAG_SECDR = "SECDR";
    public static final String TAG_ORGDR = "ORGDR";
    public static final String TAG_ENABLESECBC = "ENABLESECBC";
    public static final String TAG_SECBC = "SECBC";
    public static final String TAG_CUSTOMDRFLAG = "CUSTOMDRFLAG";
    public static final String TAG_CUSTOMCOND = "CUSTOMCOND";

    public final boolean isPSDEOPPRIVROLEIDNull() {
        return this.IsParamNull(TAG_PSDEOPPRIVROLEID);
    }

    public final String getPSDEOPPRIVROLEID() {
        return this.GetParamStringValue(TAG_PSDEOPPRIVROLEID, "");
    }

    public final void setPSDEOPPRIVROLEID(String strValue) {
        this.SetParamValue(TAG_PSDEOPPRIVROLEID, strValue);
    }

    public final boolean isPSDEOPPRIVROLENAMENull() {
        return this.IsParamNull(TAG_PSDEOPPRIVROLENAME);
    }

    public final String getPSDEOPPRIVROLENAME() {
        return this.GetParamStringValue(TAG_PSDEOPPRIVROLENAME, "");
    }

    public final void setPSDEOPPRIVROLENAME(String strValue) {
        this.SetParamValue(TAG_PSDEOPPRIVROLENAME, strValue);
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

    public final boolean isPSDEIDNull() {
        return this.IsParamNull(TAG_PSDEID);
    }

    public final String getPSDEID() {
        return this.GetParamStringValue(TAG_PSDEID, "");
    }

    public final void setPSDEID(String strValue) {
        this.SetParamValue(TAG_PSDEID, strValue);
    }

    public final boolean isPSDENAMENull() {
        return this.IsParamNull(TAG_PSDENAME);
    }

    public final String getPSDENAME() {
        return this.GetParamStringValue(TAG_PSDENAME, "");
    }

    public final void setPSDENAME(String strValue) {
        this.SetParamValue(TAG_PSDENAME, strValue);
    }

    public final boolean isPSDEOPPRIVIDNull() {
        return this.IsParamNull(TAG_PSDEOPPRIVID);
    }

    public final String getPSDEOPPRIVID() {
        return this.GetParamStringValue(TAG_PSDEOPPRIVID, "");
    }

    public final void setPSDEOPPRIVID(String strValue) {
        this.SetParamValue(TAG_PSDEOPPRIVID, strValue);
    }

    public final boolean isPSDEOPPRIVNAMENull() {
        return this.IsParamNull(TAG_PSDEOPPRIVNAME);
    }

    public final String getPSDEOPPRIVNAME() {
        return this.GetParamStringValue(TAG_PSDEOPPRIVNAME, "");
    }

    public final void setPSDEOPPRIVNAME(String strValue) {
        this.SetParamValue(TAG_PSDEOPPRIVNAME, strValue);
    }

    public final boolean isROLETYPENull() {
        return this.IsParamNull(TAG_ROLETYPE);
    }

    public final String getROLETYPE() {
        return this.GetParamStringValue(TAG_ROLETYPE, "");
    }

    public final void setROLETYPE(String strValue) {
        this.SetParamValue(TAG_ROLETYPE, strValue);
    }

    public final boolean isPSSYSOPPRIVIDNull() {
        return this.IsParamNull(TAG_PSSYSOPPRIVID);
    }

    public final String getPSSYSOPPRIVID() {
        return this.GetParamStringValue(TAG_PSSYSOPPRIVID, "");
    }

    public final void setPSSYSOPPRIVID(String strValue) {
        this.SetParamValue(TAG_PSSYSOPPRIVID, strValue);
    }

    public final boolean isPSSYSOPPRIVNAMENull() {
        return this.IsParamNull(TAG_PSSYSOPPRIVNAME);
    }

    public final String getPSSYSOPPRIVNAME() {
        return this.GetParamStringValue(TAG_PSSYSOPPRIVNAME, "");
    }

    public final void setPSSYSOPPRIVNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSOPPRIVNAME, strValue);
    }

    public final boolean isPSDEDQIDNull() {
        return this.IsParamNull(TAG_PSDEDQID);
    }

    public final String getPSDEDQID() {
        return this.GetParamStringValue(TAG_PSDEDQID, "");
    }

    public final void setPSDEDQID(String strValue) {
        this.SetParamValue(TAG_PSDEDQID, strValue);
    }

    public final boolean isPSDEDQNAMENull() {
        return this.IsParamNull(TAG_PSDEDQNAME);
    }

    public final String getPSDEDQNAME() {
        return this.GetParamStringValue(TAG_PSDEDQNAME, "");
    }

    public final void setPSDEDQNAME(String strValue) {
        this.SetParamValue(TAG_PSDEDQNAME, strValue);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isPSDEUSERROLEIDNull() {
        return this.IsParamNull(TAG_PSDEUSERROLEID);
    }

    public final String getPSDEUSERROLEID() {
        return this.GetParamStringValue(TAG_PSDEUSERROLEID, "");
    }

    public final void setPSDEUSERROLEID(String strValue) {
        this.SetParamValue(TAG_PSDEUSERROLEID, strValue);
    }

    public final boolean isPSDEUSERROLENAMENull() {
        return this.IsParamNull(TAG_PSDEUSERROLENAME);
    }

    public final String getPSDEUSERROLENAME() {
        return this.GetParamStringValue(TAG_PSDEUSERROLENAME, "");
    }

    public final void setPSDEUSERROLENAME(String strValue) {
        this.SetParamValue(TAG_PSDEUSERROLENAME, strValue);
    }

    public final boolean isPSSYSUSERDRIDNull() {
        return this.IsParamNull(TAG_PSSYSUSERDRID);
    }

    public final String getPSSYSUSERDRID() {
        return this.GetParamStringValue(TAG_PSSYSUSERDRID, "");
    }

    public final void setPSSYSUSERDRID(String strValue) {
        this.SetParamValue(TAG_PSSYSUSERDRID, strValue);
    }

    public final boolean isPSSYSUSERDRNAMENull() {
        return this.IsParamNull(TAG_PSSYSUSERDRNAME);
    }

    public final String getPSSYSUSERDRNAME() {
        return this.GetParamStringValue(TAG_PSSYSUSERDRNAME, "");
    }

    public final void setPSSYSUSERDRNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSUSERDRNAME, strValue);
    }

    public final boolean isPSSYSUSERDRID2Null() {
        return this.IsParamNull(TAG_PSSYSUSERDRID2);
    }

    public final String getPSSYSUSERDRID2() {
        return this.GetParamStringValue(TAG_PSSYSUSERDRID2, "");
    }

    public final void setPSSYSUSERDRID2(String strValue) {
        this.SetParamValue(TAG_PSSYSUSERDRID2, strValue);
    }

    public final boolean isPSSYSUSERDRNAME2Null() {
        return this.IsParamNull(TAG_PSSYSUSERDRNAME2);
    }

    public final String getPSSYSUSERDRNAME2() {
        return this.GetParamStringValue(TAG_PSSYSUSERDRNAME2, "");
    }

    public final void setPSSYSUSERDRNAME2(String strValue) {
        this.SetParamValue(TAG_PSSYSUSERDRNAME2, strValue);
    }

    public final boolean isENABLEUSERDRNull() {
        return this.IsParamNull(TAG_ENABLEUSERDR);
    }

    public final boolean getENABLEUSERDR() {
        return this.GetParamIntValue(TAG_ENABLEUSERDR, 0) == 1;
    }

    public final void setENABLEUSERDR(boolean bValue) {
        this.SetParamValue(TAG_ENABLEUSERDR, bValue ? 1 : 0);
    }

    public final boolean isENABLESECDRNull() {
        return this.IsParamNull(TAG_ENABLESECDR);
    }

    public final boolean getENABLESECDR() {
        return this.GetParamIntValue(TAG_ENABLESECDR, 0) == 1;
    }

    public final void setENABLESECDR(boolean bValue) {
        this.SetParamValue(TAG_ENABLESECDR, bValue ? 1 : 0);
    }

    public final boolean isENABLEORGDRNull() {
        return this.IsParamNull(TAG_ENABLEORGDR);
    }

    public final boolean getENABLEORGDR() {
        return this.GetParamIntValue(TAG_ENABLEORGDR, 0) == 1;
    }

    public final void setENABLEORGDR(boolean bValue) {
        this.SetParamValue(TAG_ENABLEORGDR, bValue ? 1 : 0);
    }

    public final boolean isSYSUSERDRPARAMNull() {
        return this.IsParamNull(TAG_SYSUSERDRPARAM);
    }

    public final String getSYSUSERDRPARAM() {
        return this.GetParamStringValue(TAG_SYSUSERDRPARAM, "");
    }

    public final void setSYSUSERDRPARAM(String strValue) {
        this.SetParamValue(TAG_SYSUSERDRPARAM, strValue);
    }

    public final boolean isSYSUSERDR2PARAMNull() {
        return this.IsParamNull(TAG_SYSUSERDR2PARAM);
    }

    public final String getSYSUSERDR2PARAM() {
        return this.GetParamStringValue(TAG_SYSUSERDR2PARAM, "");
    }

    public final void setSYSUSERDR2PARAM(String strValue) {
        this.SetParamValue(TAG_SYSUSERDR2PARAM, strValue);
    }

    public final boolean isSECDRNull() {
        return this.IsParamNull(TAG_SECDR);
    }

    public final int getSECDR() {
        return this.GetParamIntValue(TAG_SECDR, 0);
    }

    public final void setSECDR(int nValue) {
        this.SetParamValue(TAG_SECDR, nValue);
    }

    public final boolean isORGDRNull() {
        return this.IsParamNull(TAG_ORGDR);
    }

    public final int getORGDR() {
        return this.GetParamIntValue(TAG_ORGDR, 0);
    }

    public final void setORGDR(int nValue) {
        this.SetParamValue(TAG_ORGDR, nValue);
    }

    public final boolean isENABLESECBCNull() {
        return this.IsParamNull(TAG_ENABLESECBC);
    }

    public final boolean getENABLESECBC() {
        return this.GetParamIntValue(TAG_ENABLESECBC, 0) == 1;
    }

    public final void setENABLESECBC(boolean bValue) {
        this.SetParamValue(TAG_ENABLESECBC, bValue ? 1 : 0);
    }

    public final boolean isSECBCNull() {
        return this.IsParamNull(TAG_SECBC);
    }

    public final String getSECBC() {
        return this.GetParamStringValue(TAG_SECBC, "");
    }

    public final void setSECBC(String strValue) {
        this.SetParamValue(TAG_SECBC, strValue);
    }

    public final boolean isCUSTOMDRFLAGNull() {
        return this.IsParamNull(TAG_CUSTOMDRFLAG);
    }

    public final boolean getCUSTOMDRFLAG() {
        return this.GetParamIntValue(TAG_CUSTOMDRFLAG, 0) == 1;
    }

    public final void setCUSTOMDRFLAG(boolean bValue) {
        this.SetParamValue(TAG_CUSTOMDRFLAG, bValue ? 1 : 0);
    }

    public final boolean isCUSTOMCONDNull() {
        return this.IsParamNull(TAG_CUSTOMCOND);
    }

    public final String getCUSTOMCOND() {
        return this.GetParamStringValue(TAG_CUSTOMCOND, "");
    }

    public final void setCUSTOMCOND(String strValue) {
        this.SetParamValue(TAG_CUSTOMCOND, strValue);
    }
}

