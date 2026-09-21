/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysTestDataItem
extends BaseDataEntity {
    public static final String VALUETYPE_VALUE = "VALUE";
    public static final String VALUETYPE_VALUERANGE = "VALUERANGE";
    public static final String VALUETYPE_PICKUPVALUE = "PICKUPVALUE";
    public static final String VALUETYPE_RANDOMVALUE = "RANDOMVALUE";
    public static final String VALUETYPE_CODELISTVALUE = "CODELISTVALUE";
    public static final String VALUETYPE_REFTESTDATA = "REFTESTDATA";
    public static final String VALUETYPE_NULLVALUE = "NULLVALUE";
    public static final String TAG_PSSYSSAMPLEVALUEID = "PSSYSSAMPLEVALUEID";
    public static final String TAG_PSSYSSAMPLEVALUENAME = "PSSYSSAMPLEVALUENAME";
    public static final String TAG_PSSYSTDITEMID = "PSSYSTDITEMID";
    public static final String TAG_PSSYSTDITEMNAME = "PSSYSTDITEMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTESTDATAID = "PSSYSTESTDATAID";
    public static final String TAG_PSSYSTESTDATANAME = "PSSYSTESTDATANAME";
    public static final String TAG_VALUE = "VALUE";
    public static final String TAG_VALUETYPE = "VALUETYPE";
    public static final String TAG_VALUERANGE = "VALUERANGE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_REFPSDEID = "REFPSDEID";
    public static final String TAG_REFPSDENAME = "REFPSDENAME";
    public static final String TAG_PSCODELISTID = "PSCODELISTID";
    public static final String TAG_PSCODELISTNAME = "PSCODELISTNAME";
    public static final String TAG_REFPSSYSTESTDATAID = "REFPSSYSTESTDATAID";
    public static final String TAG_REFPSSYSTESTDATANAME = "REFPSSYSTESTDATANAME";
    public static final String TAG_BADVALUE = "BADVALUE";
    public static final String TAG_REFPSDEDATASETID = "REFPSDEDATASETID";
    public static final String TAG_REFPSDEDATASETNAME = "REFPSDEDATASETNAME";
    public static final String TAG_STDDATATYPE = "STDDATATYPE";

    public final boolean isPSSYSTDITEMIDNull() {
        return this.IsParamNull(TAG_PSSYSTDITEMID);
    }

    public final String getPSSYSTDITEMID() {
        return this.GetParamStringValue(TAG_PSSYSTDITEMID, "");
    }

    public final void setPSSYSTDITEMID(String strValue) {
        this.SetParamValue(TAG_PSSYSTDITEMID, strValue);
    }

    public final boolean isPSSYSTDITEMNAMENull() {
        return this.IsParamNull(TAG_PSSYSTDITEMNAME);
    }

    public final String getPSSYSTDITEMNAME() {
        return this.GetParamStringValue(TAG_PSSYSTDITEMNAME, "");
    }

    public final void setPSSYSTDITEMNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSTDITEMNAME, strValue);
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

    public final boolean isVALUENull() {
        return this.IsParamNull("VALUE");
    }

    public final String getVALUE() {
        return this.GetParamStringValue("VALUE", "");
    }

    public final void setVALUE(String strValue) {
        this.SetParamValue("VALUE", strValue);
    }

    public final boolean isVALUETYPENull() {
        return this.IsParamNull(TAG_VALUETYPE);
    }

    public final String getVALUETYPE() {
        return this.GetParamStringValue(TAG_VALUETYPE, "");
    }

    public final void setVALUETYPE(String strValue) {
        this.SetParamValue(TAG_VALUETYPE, strValue);
    }

    public final boolean isVALUERANGENull() {
        return this.IsParamNull("VALUERANGE");
    }

    public final String getVALUERANGE() {
        return this.GetParamStringValue("VALUERANGE", "");
    }

    public final void setVALUERANGE(String strValue) {
        this.SetParamValue("VALUERANGE", strValue);
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

    public final boolean isREFPSDEIDNull() {
        return this.IsParamNull(TAG_REFPSDEID);
    }

    public final String getREFPSDEID() {
        return this.GetParamStringValue(TAG_REFPSDEID, "");
    }

    public final void setREFPSDEID(String strValue) {
        this.SetParamValue(TAG_REFPSDEID, strValue);
    }

    public final boolean isREFPSDENAMENull() {
        return this.IsParamNull(TAG_REFPSDENAME);
    }

    public final String getREFPSDENAME() {
        return this.GetParamStringValue(TAG_REFPSDENAME, "");
    }

    public final void setREFPSDENAME(String strValue) {
        this.SetParamValue(TAG_REFPSDENAME, strValue);
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

    public final boolean isREFPSSYSTESTDATAIDNull() {
        return this.IsParamNull(TAG_REFPSSYSTESTDATAID);
    }

    public final String getREFPSSYSTESTDATAID() {
        return this.GetParamStringValue(TAG_REFPSSYSTESTDATAID, "");
    }

    public final void setREFPSSYSTESTDATAID(String strValue) {
        this.SetParamValue(TAG_REFPSSYSTESTDATAID, strValue);
    }

    public final boolean isREFPSSYSTESTDATANAMENull() {
        return this.IsParamNull(TAG_REFPSSYSTESTDATANAME);
    }

    public final String getREFPSSYSTESTDATANAME() {
        return this.GetParamStringValue(TAG_REFPSSYSTESTDATANAME, "");
    }

    public final void setREFPSSYSTESTDATANAME(String strValue) {
        this.SetParamValue(TAG_REFPSSYSTESTDATANAME, strValue);
    }

    public final boolean isBADVALUENull() {
        return this.IsParamNull(TAG_BADVALUE);
    }

    public final String getBADVALUE() {
        return this.GetParamStringValue(TAG_BADVALUE, "");
    }

    public final void setBADVALUE(String strValue) {
        this.SetParamValue(TAG_BADVALUE, strValue);
    }

    public final boolean isPSSYSSAMPLEVALUEIDNull() {
        return this.IsParamNull(TAG_PSSYSSAMPLEVALUEID);
    }

    public final String getPSSYSSAMPLEVALUEID() {
        return this.GetParamStringValue(TAG_PSSYSSAMPLEVALUEID, "");
    }

    public final void setPSSYSSAMPLEVALUEID(String strValue) {
        this.SetParamValue(TAG_PSSYSSAMPLEVALUEID, strValue);
    }

    public final boolean isPSSYSSAMPLEVALUENAMENull() {
        return this.IsParamNull(TAG_PSSYSSAMPLEVALUENAME);
    }

    public final String getPSSYSSAMPLEVALUENAME() {
        return this.GetParamStringValue(TAG_PSSYSSAMPLEVALUENAME, "");
    }

    public final void setPSSYSSAMPLEVALUENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSSAMPLEVALUENAME, strValue);
    }

    public final boolean isREFPSDEDATASETIDNull() {
        return this.IsParamNull(TAG_REFPSDEDATASETID);
    }

    public final String getREFPSDEDATASETID() {
        return this.GetParamStringValue(TAG_REFPSDEDATASETID, "");
    }

    public final void setREFPSDEDATASETID(String strValue) {
        this.SetParamValue(TAG_REFPSDEDATASETID, strValue);
    }

    public final boolean isREFPSDEDATASETNAMENull() {
        return this.IsParamNull(TAG_REFPSDEDATASETNAME);
    }

    public final String getREFPSDEDATASETNAME() {
        return this.GetParamStringValue(TAG_REFPSDEDATASETNAME, "");
    }

    public final void setREFPSDEDATASETNAME(String strValue) {
        this.SetParamValue(TAG_REFPSDEDATASETNAME, strValue);
    }

    public final boolean isSTDDATATYPENull() {
        return this.IsParamNull(TAG_STDDATATYPE);
    }

    public final int getSTDDATATYPE() {
        return this.GetParamIntValue(TAG_STDDATATYPE, 0);
    }

    public final void setSTDDATATYPE(int nValue) {
        this.SetParamValue(TAG_STDDATATYPE, nValue);
    }
}

