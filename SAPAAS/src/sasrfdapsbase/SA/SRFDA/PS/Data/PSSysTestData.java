/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysTestData
extends BaseDataEntity {
    public static final String TAG_PSSYSTESTDATAID = "PSSYSTESTDATAID";
    public static final String TAG_PSSYSTESTDATANAME = "PSSYSTESTDATANAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_USERFLAG = "USERFLAG";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_RANDOMCOUNT = "RANDOMCOUNT";
    public static final String TAG_BASEMODE = "BASEMODE";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_PSMODULEID = "PSMODULEID";
    public static final String TAG_PSMODULENAME = "PSMODULENAME";
    public static final String TAG_DATA = "DATA";
    public static final String TAG_TESTDATATYPE = "TESTDATATYPE";
    public static final String TAG_CUSTOMCODE = "CUSTOMCODE";

    public final boolean isPSSYSTESTDATAIDNull() {
        return this.IsParamNull(TAG_PSSYSTESTDATAID);
    }

    public final String getPSSYSTESTDATAID() {
        return this.GetParamStringValue(TAG_PSSYSTESTDATAID, "");
    }

    public final void setPSSYSTESTDATAID(String strValue) {
        this.SetParamValue(TAG_PSSYSTESTDATAID, strValue);
    }

    public final boolean isPSSYSTESTDATANAMENull() {
        return this.IsParamNull(TAG_PSSYSTESTDATANAME);
    }

    public final String getPSSYSTESTDATANAME() {
        return this.GetParamStringValue(TAG_PSSYSTESTDATANAME, "");
    }

    public final void setPSSYSTESTDATANAME(String strValue) {
        this.SetParamValue(TAG_PSSYSTESTDATANAME, strValue);
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

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
    }

    public final boolean isUSERFLAGNull() {
        return this.IsParamNull(TAG_USERFLAG);
    }

    public final boolean getUSERFLAG() {
        return this.GetParamIntValue(TAG_USERFLAG, 0) == 1;
    }

    public final void setUSERFLAG(boolean bValue) {
        this.SetParamValue(TAG_USERFLAG, bValue ? 1 : 0);
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

    public final boolean isRANDOMCOUNTNull() {
        return this.IsParamNull(TAG_RANDOMCOUNT);
    }

    public final int getRANDOMCOUNT() {
        return this.GetParamIntValue(TAG_RANDOMCOUNT, 0);
    }

    public final void setRANDOMCOUNT(int nValue) {
        this.SetParamValue(TAG_RANDOMCOUNT, nValue);
    }

    public final boolean isBASEMODENull() {
        return this.IsParamNull(TAG_BASEMODE);
    }

    public final boolean getBASEMODE() {
        return this.GetParamIntValue(TAG_BASEMODE, 0) == 1;
    }

    public final void setBASEMODE(boolean bValue) {
        this.SetParamValue(TAG_BASEMODE, bValue ? 1 : 0);
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

    public final boolean isDATANull() {
        return this.IsParamNull(TAG_DATA);
    }

    public final String getDATA() {
        return this.GetParamStringValue(TAG_DATA, "");
    }

    public final void setDATA(String strValue) {
        this.SetParamValue(TAG_DATA, strValue);
    }

    public final boolean isTESTDATATYPENull() {
        return this.IsParamNull(TAG_TESTDATATYPE);
    }

    public final String getTESTDATATYPE() {
        return this.GetParamStringValue(TAG_TESTDATATYPE, "");
    }

    public final void setTESTDATATYPE(String strValue) {
        this.SetParamValue(TAG_TESTDATATYPE, strValue);
    }

    public final boolean isCUSTOMCODENull() {
        return this.IsParamNull(TAG_CUSTOMCODE);
    }

    public final String getCUSTOMCODE() {
        return this.GetParamStringValue(TAG_CUSTOMCODE, "");
    }

    public final void setCUSTOMCODE(String strValue) {
        this.SetParamValue(TAG_CUSTOMCODE, strValue);
    }
}

