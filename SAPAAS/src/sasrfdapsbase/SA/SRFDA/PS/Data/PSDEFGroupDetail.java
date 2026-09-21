/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDEFGroupDetail
extends BaseDataEntity {
    public static final String TAG_PSDEFGROUPDETAILID = "PSDEFGROUPDETAILID";
    public static final String TAG_PSDEFGROUPDETAILNAME = "PSDEFGROUPDETAILNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEFGROUPID = "PSDEFGROUPID";
    public static final String TAG_PSDEFGROUPNAME = "PSDEFGROUPNAME";
    public static final String TAG_PSDEFID = "PSDEFID";
    public static final String TAG_PSDEFNAME = "PSDEFNAME";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_CODENAME2 = "CODENAME2";
    public static final String TAG_ALLOWEMPTY = "ALLOWEMPTY";
    public static final String TAG_ENABLEUSERINPUT = "ENABLEUSERINPUT";
    public static final String TAG_STRLENGTH = "STRLENGTH";
    public static final String TAG_PSCODELISTID = "PSCODELISTID";
    public static final String TAG_PSCODELISTNAME = "PSCODELISTNAME";
    public static final String TAG_PSSYSVALUERULEID = "PSSYSVALUERULEID";
    public static final String TAG_PSSYSVALUERULENAME = "PSSYSVALUERULENAME";
    public static final String TAG_MODIFYUSERINPUT = "MODIFYUSERINPUT";
    public static final String TAG_DETAILPARAM = "DETAILPARAM";
    public static final String TAG_DETAILPARAM2 = "DETAILPARAM2";
    public static final String TAG_MINSTRLENGTH = "MINSTRLENGTH";
    public static final String TAG_MINVALUE = "MINVALUE";
    public static final String TAG_MAXVALUE = "MAXVALUE";
    @Deprecated
    public static final String TAG_PRECISION2 = "PRECISION2";
    public static final String TAG_PRECISION = "PRECISION";
    public static final String TAG_LNPSLANRESID = "LNPSLANRESID";
    public static final String TAG_LNPSLANRESNAME = "LNPSLANRESNAME";
    public static final String TAG_JSONFORMAT = "JSONFORMAT";
    public static final String TAG_DVT = "DVT";
    public static final String TAG_DEFAULTVALUE = "DEFAULTVALUE";
    public static final String TAG_SEARCHMODES = "SEARCHMODES";
    public static final String TAG_SERVICECODENAME = "SERVICECODENAME";

    public final boolean isPSDEFGROUPDETAILIDNull() {
        return this.IsParamNull(TAG_PSDEFGROUPDETAILID);
    }

    public final String getPSDEFGROUPDETAILID() {
        return this.GetParamStringValue(TAG_PSDEFGROUPDETAILID, "");
    }

    public final void setPSDEFGROUPDETAILID(String strValue) {
        this.SetParamValue(TAG_PSDEFGROUPDETAILID, strValue);
    }

    public final boolean isPSDEFGROUPDETAILNAMENull() {
        return this.IsParamNull(TAG_PSDEFGROUPDETAILNAME);
    }

    public final String getPSDEFGROUPDETAILNAME() {
        return this.GetParamStringValue(TAG_PSDEFGROUPDETAILNAME, "");
    }

    public final void setPSDEFGROUPDETAILNAME(String strValue) {
        this.SetParamValue(TAG_PSDEFGROUPDETAILNAME, strValue);
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

    public final boolean isPSDEFGROUPIDNull() {
        return this.IsParamNull(TAG_PSDEFGROUPID);
    }

    public final String getPSDEFGROUPID() {
        return this.GetParamStringValue(TAG_PSDEFGROUPID, "");
    }

    public final void setPSDEFGROUPID(String strValue) {
        this.SetParamValue(TAG_PSDEFGROUPID, strValue);
    }

    public final boolean isPSDEFGROUPNAMENull() {
        return this.IsParamNull(TAG_PSDEFGROUPNAME);
    }

    public final String getPSDEFGROUPNAME() {
        return this.GetParamStringValue(TAG_PSDEFGROUPNAME, "");
    }

    public final void setPSDEFGROUPNAME(String strValue) {
        this.SetParamValue(TAG_PSDEFGROUPNAME, strValue);
    }

    public final boolean isPSDEFIDNull() {
        return this.IsParamNull(TAG_PSDEFID);
    }

    public final String getPSDEFID() {
        return this.GetParamStringValue(TAG_PSDEFID, "");
    }

    public final void setPSDEFID(String strValue) {
        this.SetParamValue(TAG_PSDEFID, strValue);
    }

    public final boolean isPSDEFNAMENull() {
        return this.IsParamNull(TAG_PSDEFNAME);
    }

    public final String getPSDEFNAME() {
        return this.GetParamStringValue(TAG_PSDEFNAME, "");
    }

    public final void setPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_PSDEFNAME, strValue);
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

    public final boolean isORDERVALUENull() {
        return this.IsParamNull(TAG_ORDERVALUE);
    }

    public final int getORDERVALUE() {
        return this.GetParamIntValue(TAG_ORDERVALUE, 0);
    }

    public final void setORDERVALUE(int nValue) {
        this.SetParamValue(TAG_ORDERVALUE, nValue);
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

    public final boolean isPSDEIDNull() {
        return this.IsParamNull(TAG_PSDEID);
    }

    public final String getPSDEID() {
        return this.GetParamStringValue(TAG_PSDEID, "");
    }

    public final void setPSDEID(String strValue) {
        this.SetParamValue(TAG_PSDEID, strValue);
    }

    public final boolean isCODENAME2Null() {
        return this.IsParamNull(TAG_CODENAME2);
    }

    public final String getCODENAME2() {
        return this.GetParamStringValue(TAG_CODENAME2, "");
    }

    public final void setCODENAME2(String strValue) {
        this.SetParamValue(TAG_CODENAME2, strValue);
    }

    public final boolean isALLOWEMPTYNull() {
        return this.IsParamNull(TAG_ALLOWEMPTY);
    }

    public final boolean getALLOWEMPTY() {
        return this.GetParamIntValue(TAG_ALLOWEMPTY, 0) == 1;
    }

    public final void setALLOWEMPTY(boolean bValue) {
        this.SetParamValue(TAG_ALLOWEMPTY, bValue ? 1 : 0);
    }

    public final boolean isENABLEUSERINPUTNull() {
        return this.IsParamNull(TAG_ENABLEUSERINPUT);
    }

    public final int getENABLEUSERINPUT() {
        return this.GetParamIntValue(TAG_ENABLEUSERINPUT, 0);
    }

    public final void setENABLEUSERINPUT(int nValue) {
        this.SetParamValue(TAG_ENABLEUSERINPUT, nValue);
    }

    public final boolean isSTRLENGTHNull() {
        return this.IsParamNull(TAG_STRLENGTH);
    }

    public final int getSTRLENGTH() {
        return this.GetParamIntValue(TAG_STRLENGTH, 0);
    }

    public final void setSTRLENGTH(int nValue) {
        this.SetParamValue(TAG_STRLENGTH, nValue);
    }

    public final boolean isPSCODELISTIDNull() {
        return this.IsParamNull(TAG_PSCODELISTID);
    }

    public final String getPSCODELISTID() {
        return this.GetParamStringValue(TAG_PSCODELISTID, "");
    }

    public final void setPSCODELISTID(String strValue) {
        this.SetParamValue(TAG_PSCODELISTID, strValue);
    }

    public final boolean isPSCODELISTNAMENull() {
        return this.IsParamNull(TAG_PSCODELISTNAME);
    }

    public final String getPSCODELISTNAME() {
        return this.GetParamStringValue(TAG_PSCODELISTNAME, "");
    }

    public final void setPSCODELISTNAME(String strValue) {
        this.SetParamValue(TAG_PSCODELISTNAME, strValue);
    }

    public final boolean isPSSYSVALUERULEIDNull() {
        return this.IsParamNull(TAG_PSSYSVALUERULEID);
    }

    public final String getPSSYSVALUERULEID() {
        return this.GetParamStringValue(TAG_PSSYSVALUERULEID, "");
    }

    public final void setPSSYSVALUERULEID(String strValue) {
        this.SetParamValue(TAG_PSSYSVALUERULEID, strValue);
    }

    public final boolean isPSSYSVALUERULENAMENull() {
        return this.IsParamNull(TAG_PSSYSVALUERULENAME);
    }

    public final String getPSSYSVALUERULENAME() {
        return this.GetParamStringValue(TAG_PSSYSVALUERULENAME, "");
    }

    public final void setPSSYSVALUERULENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSVALUERULENAME, strValue);
    }

    public final boolean isMODIFYUSERINPUTNull() {
        return this.IsParamNull(TAG_MODIFYUSERINPUT);
    }

    public final boolean getMODIFYUSERINPUT() {
        return this.GetParamIntValue(TAG_MODIFYUSERINPUT, 0) == 1;
    }

    public final void setMODIFYUSERINPUT(boolean bValue) {
        this.SetParamValue(TAG_MODIFYUSERINPUT, bValue ? 1 : 0);
    }

    public final boolean isDETAILPARAMNull() {
        return this.IsParamNull(TAG_DETAILPARAM);
    }

    public final String getDETAILPARAM() {
        return this.GetParamStringValue(TAG_DETAILPARAM, "");
    }

    public final void setDETAILPARAM(String strValue) {
        this.SetParamValue(TAG_DETAILPARAM, strValue);
    }

    public final boolean isDETAILPARAM2Null() {
        return this.IsParamNull(TAG_DETAILPARAM2);
    }

    public final String getDETAILPARAM2() {
        return this.GetParamStringValue(TAG_DETAILPARAM2, "");
    }

    public final void setDETAILPARAM2(String strValue) {
        this.SetParamValue(TAG_DETAILPARAM2, strValue);
    }

    public final boolean isMINSTRLENGTHNull() {
        return this.IsParamNull(TAG_MINSTRLENGTH);
    }

    public final int getMINSTRLENGTH() {
        return this.GetParamIntValue(TAG_MINSTRLENGTH, 0);
    }

    public final void setMINSTRLENGTH(int nValue) {
        this.SetParamValue(TAG_MINSTRLENGTH, nValue);
    }

    public final boolean isMINVALUENull() {
        return this.IsParamNull(TAG_MINVALUE);
    }

    public final String getMINVALUE() {
        return this.GetParamStringValue(TAG_MINVALUE, "");
    }

    public final void setMINVALUE(String strValue) {
        this.SetParamValue(TAG_MINVALUE, strValue);
    }

    public final boolean isMAXVALUENull() {
        return this.IsParamNull(TAG_MAXVALUE);
    }

    public final String getMAXVALUE() {
        return this.GetParamStringValue(TAG_MAXVALUE, "");
    }

    public final void setMAXVALUE(String strValue) {
        this.SetParamValue(TAG_MAXVALUE, strValue);
    }

    public final boolean isPRECISION2Null() {
        return this.IsParamNull(TAG_PRECISION2);
    }

    public final int getPRECISION2() {
        return this.GetParamIntValue(TAG_PRECISION2, 0);
    }

    public final void setPRECISION2(int nValue) {
        this.SetParamValue(TAG_PRECISION2, nValue);
    }

    public final boolean isLNPSLANRESIDNull() {
        return this.IsParamNull(TAG_LNPSLANRESID);
    }

    public final String getLNPSLANRESID() {
        return this.GetParamStringValue(TAG_LNPSLANRESID, "");
    }

    public final void setLNPSLANRESID(String strValue) {
        this.SetParamValue(TAG_LNPSLANRESID, strValue);
    }

    public final boolean isLNPSLANRESNAMENull() {
        return this.IsParamNull(TAG_LNPSLANRESNAME);
    }

    public final String getLNPSLANRESNAME() {
        return this.GetParamStringValue(TAG_LNPSLANRESNAME, "");
    }

    public final void setLNPSLANRESNAME(String strValue) {
        this.SetParamValue(TAG_LNPSLANRESNAME, strValue);
    }

    public final boolean isJSONFORMATNull() {
        return this.IsParamNull(TAG_JSONFORMAT);
    }

    public final String getJSONFORMAT() {
        return this.GetParamStringValue(TAG_JSONFORMAT, "");
    }

    public final void setJSONFORMAT(String strValue) {
        this.SetParamValue(TAG_JSONFORMAT, strValue);
    }

    public final boolean isDVTNull() {
        return this.IsParamNull(TAG_DVT);
    }

    public final String getDVT() {
        return this.GetParamStringValue(TAG_DVT, "");
    }

    public final void setDVT(String strValue) {
        this.SetParamValue(TAG_DVT, strValue);
    }

    public final boolean isDEFAULTVALUENull() {
        return this.IsParamNull(TAG_DEFAULTVALUE);
    }

    public final String getDEFAULTVALUE() {
        return this.GetParamStringValue(TAG_DEFAULTVALUE, "");
    }

    public final void setDEFAULTVALUE(String strValue) {
        this.SetParamValue(TAG_DEFAULTVALUE, strValue);
    }

    public final boolean isSEARCHMODESNull() {
        return this.IsParamNull(TAG_SEARCHMODES);
    }

    public final String getSEARCHMODES() {
        return this.GetParamStringValue(TAG_SEARCHMODES, "");
    }

    public final void setSEARCHMODES(String strValue) {
        this.SetParamValue(TAG_SEARCHMODES, strValue);
    }

    public final boolean isSERVICECODENAMENull() {
        return this.IsParamNull(TAG_SERVICECODENAME);
    }

    public final String getSERVICECODENAME() {
        return this.GetParamStringValue(TAG_SERVICECODENAME, "");
    }

    public final void setSERVICECODENAME(String strValue) {
        this.SetParamValue(TAG_SERVICECODENAME, strValue);
    }
}

