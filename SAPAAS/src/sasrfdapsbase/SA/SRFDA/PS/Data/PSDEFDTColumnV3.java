/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDEFDTColumnV3
extends BaseDataEntity {
    public static final String DBTYPE_MYSQL5 = "MYSQL5";
    public static final String TAG_PSDEFDTCOLID = "PSDEFDTCOLID";
    public static final String TAG_PSDEFDTCOLNAME = "PSDEFDTCOLNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DBTYPE = "DBTYPE";
    public static final String TAG_PSDEFID = "PSDEFID";
    public static final String TAG_PSDEFNAME = "PSDEFNAME";
    public static final String TAG_FORMULAFORMAT = "FORMULAFORMAT";
    public static final String TAG_FORMULAFIELDS = "FORMULAFIELDS";
    public static final String TAG_DEFAULTVALUE = "DEFAULTVALUE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_USERPARAMS = "USERPARAMS";
    public static final String TAG_DATATYPE = "DATATYPE";
    public static final String TAG_LENGTH = "LENGTH";
    public static final String TAG_PRECISION2 = "PRECISION2";
    public static final String TAG_CUSTOMDATATYPE = "CUSTOMDATATYPE";
    public static final String TAG_VALUEFUNCFORMAT = "VALUEFUNCFORMAT";
    public static final String TAG_VALUEFUNCFIELDS = "VALUEFUNCFIELDS";
    public static final String TAG_VALUEFUNC2FIELDS = "VALUEFUNC2FIELDS";
    public static final String TAG_VALUEFUNC2FORMAT = "VALUEFUNC2FORMAT";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_TABLENAME = "TABLENAME";
    public static final String TAG_NULLVALORDER = "NULLVALORDER";

    public final boolean isPSDEFDTCOLIDNull() {
        return this.IsParamNull(TAG_PSDEFDTCOLID);
    }

    public final String getPSDEFDTCOLID() {
        return this.GetParamStringValue(TAG_PSDEFDTCOLID, "");
    }

    public final void setPSDEFDTCOLID(String strValue) {
        this.SetParamValue(TAG_PSDEFDTCOLID, strValue);
    }

    public final boolean isPSDEFDTCOLNAMENull() {
        return this.IsParamNull(TAG_PSDEFDTCOLNAME);
    }

    public final String getPSDEFDTCOLNAME() {
        return this.GetParamStringValue(TAG_PSDEFDTCOLNAME, "");
    }

    public final void setPSDEFDTCOLNAME(String strValue) {
        this.SetParamValue(TAG_PSDEFDTCOLNAME, strValue);
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

    public final boolean isDBTYPENull() {
        return this.IsParamNull(TAG_DBTYPE);
    }

    public final String getDBTYPE() {
        return this.GetParamStringValue(TAG_DBTYPE, "");
    }

    public final void setDBTYPE(String strValue) {
        this.SetParamValue(TAG_DBTYPE, strValue);
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

    public final boolean isFORMULAFORMATNull() {
        return this.IsParamNull(TAG_FORMULAFORMAT);
    }

    public final String getFORMULAFORMAT() {
        return this.GetParamStringValue(TAG_FORMULAFORMAT, "");
    }

    public final void setFORMULAFORMAT(String strValue) {
        this.SetParamValue(TAG_FORMULAFORMAT, strValue);
    }

    public final boolean isFORMULAFIELDSNull() {
        return this.IsParamNull(TAG_FORMULAFIELDS);
    }

    public final String getFORMULAFIELDS() {
        return this.GetParamStringValue(TAG_FORMULAFIELDS, "");
    }

    public final void setFORMULAFIELDS(String strValue) {
        this.SetParamValue(TAG_FORMULAFIELDS, strValue);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isUSERPARAMSNull() {
        return this.IsParamNull(TAG_USERPARAMS);
    }

    public final String getUSERPARAMS() {
        return this.GetParamStringValue(TAG_USERPARAMS, "");
    }

    public final void setUSERPARAMS(String strValue) {
        this.SetParamValue(TAG_USERPARAMS, strValue);
    }

    public final boolean isDATATYPENull() {
        return this.IsParamNull(TAG_DATATYPE);
    }

    public final String getDATATYPE() {
        return this.GetParamStringValue(TAG_DATATYPE, "");
    }

    public final void setDATATYPE(String strValue) {
        this.SetParamValue(TAG_DATATYPE, strValue);
    }

    public final boolean isLENGTHNull() {
        return this.IsParamNull(TAG_LENGTH);
    }

    public final int getLENGTH() {
        return this.GetParamIntValue(TAG_LENGTH, 0);
    }

    public final void setLENGTH(int nValue) {
        this.SetParamValue(TAG_LENGTH, nValue);
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

    public final boolean isCUSTOMDATATYPENull() {
        return this.IsParamNull(TAG_CUSTOMDATATYPE);
    }

    public final boolean getCUSTOMDATATYPE() {
        return this.GetParamIntValue(TAG_CUSTOMDATATYPE, 0) == 1;
    }

    public final void setCUSTOMDATATYPE(boolean bValue) {
        this.SetParamValue(TAG_CUSTOMDATATYPE, bValue ? 1 : 0);
    }

    public final boolean isVALUEFUNCFORMATNull() {
        return this.IsParamNull(TAG_VALUEFUNCFORMAT);
    }

    public final String getVALUEFUNCFORMAT() {
        return this.GetParamStringValue(TAG_VALUEFUNCFORMAT, "");
    }

    public final void setVALUEFUNCFORMAT(String strValue) {
        this.SetParamValue(TAG_VALUEFUNCFORMAT, strValue);
    }

    public final boolean isVALUEFUNCFIELDSNull() {
        return this.IsParamNull(TAG_VALUEFUNCFIELDS);
    }

    public final String getVALUEFUNCFIELDS() {
        return this.GetParamStringValue(TAG_VALUEFUNCFIELDS, "");
    }

    public final void setVALUEFUNCFIELDS(String strValue) {
        this.SetParamValue(TAG_VALUEFUNCFIELDS, strValue);
    }

    public final boolean isVALUEFUNC2FIELDSNull() {
        return this.IsParamNull(TAG_VALUEFUNC2FIELDS);
    }

    public final String getVALUEFUNC2FIELDS() {
        return this.GetParamStringValue(TAG_VALUEFUNC2FIELDS, "");
    }

    public final void setVALUEFUNC2FIELDS(String strValue) {
        this.SetParamValue(TAG_VALUEFUNC2FIELDS, strValue);
    }

    public final boolean isVALUEFUNC2FORMATNull() {
        return this.IsParamNull(TAG_VALUEFUNC2FORMAT);
    }

    public final String getVALUEFUNC2FORMAT() {
        return this.GetParamStringValue(TAG_VALUEFUNC2FORMAT, "");
    }

    public final void setVALUEFUNC2FORMAT(String strValue) {
        this.SetParamValue(TAG_VALUEFUNC2FORMAT, strValue);
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

    public final boolean isTABLENAMENull() {
        return this.IsParamNull(TAG_TABLENAME);
    }

    public final String getTABLENAME() {
        return this.GetParamStringValue(TAG_TABLENAME, "");
    }

    public final void setTABLENAME(String strValue) {
        this.SetParamValue(TAG_TABLENAME, strValue);
    }

    public final boolean isNULLVALORDERNull() {
        return this.IsParamNull(TAG_NULLVALORDER);
    }

    public final String getNULLVALORDER() {
        return this.GetParamStringValue(TAG_NULLVALORDER, "");
    }

    public final void setNULLVALORDER(String strValue) {
        this.SetParamValue(TAG_NULLVALORDER, strValue);
    }
}

