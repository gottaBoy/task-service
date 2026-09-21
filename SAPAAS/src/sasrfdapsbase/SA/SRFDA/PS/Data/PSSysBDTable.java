/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysBDTable
extends BaseDataEntity {
    public static final int ADDCOLMODE_MANUAL = 0;
    public static final int ADDCOLMODE_EXCLUDE = 1;
    public static final int ADDCOLMODE_INCLUDE = 2;
    public static final int BDTABLETYPE_MAJOR = 1;
    public static final int BDTABLETYPE_RELATED = 3;
    public static final int BDTABLETYPE_INHERIT = 9;
    public static final String TAG_PSSYSBDTABLEID = "PSSYSBDTABLEID";
    public static final String TAG_PSSYSBDTABLENAME = "PSSYSBDTABLENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSBDSCHEMEID = "PSSYSBDSCHEMEID";
    public static final String TAG_PSSYSBDSCHEMENAME = "PSSYSBDSCHEMENAME";
    public static final String TAG_PSSYSBDPARTID = "PSSYSBDPARTID";
    public static final String TAG_PSSYSBDPARTNAME = "PSSYSBDPARTNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_PSSYSBDCOLSETSCNT = "PSSYSBDCOLSETSCNT";
    public static final String TAG_PSSYSBDTABLEDESCNT = "PSSYSBDTABLEDESCNT";
    public static final String TAG_PSSYSBDCOLUMNSCNT = "PSSYSBDCOLUMNSCNT";
    public static final String TAG_MODELVER = "MODELVER";
    public static final String TAG_ADDCOLMODE = "ADDCOLMODE";
    public static final String TAG_COLFILTER = "COLFILTER";
    public static final String TAG_BDTABLETYPE = "BDTABLETYPE";
    public static final String TAG_MINORPSDEID = "MINORPSDEID";
    public static final String TAG_MINORPSDENAME = "MINORPSDENAME";
    public static final String TAG_PSSYSBDTABLEDERSCNT = "PSSYSBDTABLEDERSCNT";
    public static final String TAG_PSSYSBDMODULEID = "PSSYSBDMODULEID";
    public static final String TAG_PSSYSBDMODULENAME = "PSSYSBDMODULENAME";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_INHERITPSDEID = "INHERITPSDEID";
    public static final String TAG_INHERITPSDENAME = "INHERITPSDENAME";
    public static final String TAG_TYPEVALUE = "TYPEVALUE";
    public static final String TAG_PICKUPDEFNAME = "PICKUPDEFNAME";
    public static final String TAG_PSDERID = "PSDERID";
    public static final String TAG_PSDERNAME = "PSDERNAME";

    public final boolean isPSSYSBDTABLEIDNull() {
        return this.IsParamNull(TAG_PSSYSBDTABLEID);
    }

    public final String getPSSYSBDTABLEID() {
        return this.GetParamStringValue(TAG_PSSYSBDTABLEID, "");
    }

    public final void setPSSYSBDTABLEID(String strValue) {
        this.SetParamValue(TAG_PSSYSBDTABLEID, strValue);
    }

    public final boolean isPSSYSBDTABLENAMENull() {
        return this.IsParamNull(TAG_PSSYSBDTABLENAME);
    }

    public final String getPSSYSBDTABLENAME() {
        return this.GetParamStringValue(TAG_PSSYSBDTABLENAME, "");
    }

    public final void setPSSYSBDTABLENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSBDTABLENAME, strValue);
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

    public final boolean isPSSYSBDSCHEMEIDNull() {
        return this.IsParamNull(TAG_PSSYSBDSCHEMEID);
    }

    public final String getPSSYSBDSCHEMEID() {
        return this.GetParamStringValue(TAG_PSSYSBDSCHEMEID, "");
    }

    public final void setPSSYSBDSCHEMEID(String strValue) {
        this.SetParamValue(TAG_PSSYSBDSCHEMEID, strValue);
    }

    public final boolean isPSSYSBDSCHEMENAMENull() {
        return this.IsParamNull(TAG_PSSYSBDSCHEMENAME);
    }

    public final String getPSSYSBDSCHEMENAME() {
        return this.GetParamStringValue(TAG_PSSYSBDSCHEMENAME, "");
    }

    public final void setPSSYSBDSCHEMENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSBDSCHEMENAME, strValue);
    }

    public final boolean isPSSYSBDPARTIDNull() {
        return this.IsParamNull(TAG_PSSYSBDPARTID);
    }

    public final String getPSSYSBDPARTID() {
        return this.GetParamStringValue(TAG_PSSYSBDPARTID, "");
    }

    public final void setPSSYSBDPARTID(String strValue) {
        this.SetParamValue(TAG_PSSYSBDPARTID, strValue);
    }

    public final boolean isPSSYSBDPARTNAMENull() {
        return this.IsParamNull(TAG_PSSYSBDPARTNAME);
    }

    public final String getPSSYSBDPARTNAME() {
        return this.GetParamStringValue(TAG_PSSYSBDPARTNAME, "");
    }

    public final void setPSSYSBDPARTNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSBDPARTNAME, strValue);
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

    public final boolean isCODENAMENull() {
        return this.IsParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.GetParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.SetParamValue(TAG_CODENAME, strValue);
    }

    public final boolean isLOGICNAMENull() {
        return this.IsParamNull(TAG_LOGICNAME);
    }

    public final String getLOGICNAME() {
        return this.GetParamStringValue(TAG_LOGICNAME, "");
    }

    public final void setLOGICNAME(String strValue) {
        this.SetParamValue(TAG_LOGICNAME, strValue);
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

    public final boolean isPSSYSBDCOLSETSCNTNull() {
        return this.IsParamNull(TAG_PSSYSBDCOLSETSCNT);
    }

    public final int getPSSYSBDCOLSETSCNT() {
        return this.GetParamIntValue(TAG_PSSYSBDCOLSETSCNT, 0);
    }

    public final void setPSSYSBDCOLSETSCNT(int nValue) {
        this.SetParamValue(TAG_PSSYSBDCOLSETSCNT, nValue);
    }

    public final boolean isPSSYSBDTABLEDESCNTNull() {
        return this.IsParamNull(TAG_PSSYSBDTABLEDESCNT);
    }

    public final int getPSSYSBDTABLEDESCNT() {
        return this.GetParamIntValue(TAG_PSSYSBDTABLEDESCNT, 0);
    }

    public final void setPSSYSBDTABLEDESCNT(int nValue) {
        this.SetParamValue(TAG_PSSYSBDTABLEDESCNT, nValue);
    }

    public final boolean isPSSYSBDCOLUMNSCNTNull() {
        return this.IsParamNull(TAG_PSSYSBDCOLUMNSCNT);
    }

    public final int getPSSYSBDCOLUMNSCNT() {
        return this.GetParamIntValue(TAG_PSSYSBDCOLUMNSCNT, 0);
    }

    public final void setPSSYSBDCOLUMNSCNT(int nValue) {
        this.SetParamValue(TAG_PSSYSBDCOLUMNSCNT, nValue);
    }

    public final boolean isMODELVERNull() {
        return this.IsParamNull(TAG_MODELVER);
    }

    public final int getMODELVER() {
        return this.GetParamIntValue(TAG_MODELVER, 0);
    }

    public final void setMODELVER(int nValue) {
        this.SetParamValue(TAG_MODELVER, nValue);
    }

    public final boolean isADDCOLMODENull() {
        return this.IsParamNull(TAG_ADDCOLMODE);
    }

    public final int getADDCOLMODE() {
        return this.GetParamIntValue(TAG_ADDCOLMODE, 0);
    }

    public final void setADDCOLMODE(int nValue) {
        this.SetParamValue(TAG_ADDCOLMODE, nValue);
    }

    public final boolean isCOLFILTERNull() {
        return this.IsParamNull(TAG_COLFILTER);
    }

    public final String getCOLFILTER() {
        return this.GetParamStringValue(TAG_COLFILTER, "");
    }

    public final void setCOLFILTER(String strValue) {
        this.SetParamValue(TAG_COLFILTER, strValue);
    }

    public final boolean isBDTABLETYPENull() {
        return this.IsParamNull(TAG_BDTABLETYPE);
    }

    public final int getBDTABLETYPE() {
        return this.GetParamIntValue(TAG_BDTABLETYPE, 0);
    }

    public final void setBDTABLETYPE(int nValue) {
        this.SetParamValue(TAG_BDTABLETYPE, nValue);
    }

    public final boolean isMINORPSDEIDNull() {
        return this.IsParamNull(TAG_MINORPSDEID);
    }

    public final String getMINORPSDEID() {
        return this.GetParamStringValue(TAG_MINORPSDEID, "");
    }

    public final void setMINORPSDEID(String strValue) {
        this.SetParamValue(TAG_MINORPSDEID, strValue);
    }

    public final boolean isMINORPSDENAMENull() {
        return this.IsParamNull(TAG_MINORPSDENAME);
    }

    public final String getMINORPSDENAME() {
        return this.GetParamStringValue(TAG_MINORPSDENAME, "");
    }

    public final void setMINORPSDENAME(String strValue) {
        this.SetParamValue(TAG_MINORPSDENAME, strValue);
    }

    public final boolean isPSSYSBDTABLEDERSCNTNull() {
        return this.IsParamNull(TAG_PSSYSBDTABLEDERSCNT);
    }

    public final int getPSSYSBDTABLEDERSCNT() {
        return this.GetParamIntValue(TAG_PSSYSBDTABLEDERSCNT, 0);
    }

    public final void setPSSYSBDTABLEDERSCNT(int nValue) {
        this.SetParamValue(TAG_PSSYSBDTABLEDERSCNT, nValue);
    }

    public final boolean isPSSYSBDMODULEIDNull() {
        return this.IsParamNull(TAG_PSSYSBDMODULEID);
    }

    public final String getPSSYSBDMODULEID() {
        return this.GetParamStringValue(TAG_PSSYSBDMODULEID, "");
    }

    public final void setPSSYSBDMODULEID(String strValue) {
        this.SetParamValue(TAG_PSSYSBDMODULEID, strValue);
    }

    public final boolean isPSSYSBDMODULENAMENull() {
        return this.IsParamNull(TAG_PSSYSBDMODULENAME);
    }

    public final String getPSSYSBDMODULENAME() {
        return this.GetParamStringValue(TAG_PSSYSBDMODULENAME, "");
    }

    public final void setPSSYSBDMODULENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSBDMODULENAME, strValue);
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

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
    }

    public final boolean isINHERITPSDEIDNull() {
        return this.IsParamNull(TAG_INHERITPSDEID);
    }

    public final String getINHERITPSDEID() {
        return this.GetParamStringValue(TAG_INHERITPSDEID, "");
    }

    public final void setINHERITPSDEID(String strValue) {
        this.SetParamValue(TAG_INHERITPSDEID, strValue);
    }

    public final boolean isINHERITPSDENAMENull() {
        return this.IsParamNull(TAG_INHERITPSDENAME);
    }

    public final String getINHERITPSDENAME() {
        return this.GetParamStringValue(TAG_INHERITPSDENAME, "");
    }

    public final void setINHERITPSDENAME(String strValue) {
        this.SetParamValue(TAG_INHERITPSDENAME, strValue);
    }

    public final boolean isTYPEVALUENull() {
        return this.IsParamNull(TAG_TYPEVALUE);
    }

    public final String getTYPEVALUE() {
        return this.GetParamStringValue(TAG_TYPEVALUE, "");
    }

    public final void setTYPEVALUE(String strValue) {
        this.SetParamValue(TAG_TYPEVALUE, strValue);
    }

    public final boolean isPICKUPDEFNAMENull() {
        return this.IsParamNull(TAG_PICKUPDEFNAME);
    }

    public final String getPICKUPDEFNAME() {
        return this.GetParamStringValue(TAG_PICKUPDEFNAME, "");
    }

    public final void setPICKUPDEFNAME(String strValue) {
        this.SetParamValue(TAG_PICKUPDEFNAME, strValue);
    }

    public final boolean isPSDERIDNull() {
        return this.IsParamNull(TAG_PSDERID);
    }

    public final String getPSDERID() {
        return this.GetParamStringValue(TAG_PSDERID, "");
    }

    public final void setPSDERID(String strValue) {
        this.SetParamValue(TAG_PSDERID, strValue);
    }

    public final boolean isPSDERNAMENull() {
        return this.IsParamNull(TAG_PSDERNAME);
    }

    public final String getPSDERNAME() {
        return this.GetParamStringValue(TAG_PSDERNAME, "");
    }

    public final void setPSDERNAME(String strValue) {
        this.SetParamValue(TAG_PSDERNAME, strValue);
    }
}

