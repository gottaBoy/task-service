/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class DEDataSync
extends BaseDataEntity {
    public static final String SYNCDIR_IN = "IN";
    public static final String SYNCDIR_OUT = "OUT";
    public static final String TAG_DEDATASYNCID = "DEDATASYNCID";
    public static final String TAG_DEDATASYNCNAME = "DEDATASYNCNAME";
    public static final String TAG_ENABLE = "ENABLE";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_SYNCDIR = "SYNCDIR";
    public static final String TAG_SYNCEXPORT = "SYNCEXPORT";
    public static final String TAG_EXPORTFULL = "EXPORTFULL";
    public static final String TAG_SYNCAGENTOUT = "SYNCAGENTOUT";
    public static final String TAG_SYNCAGENTIN = "SYNCAGENTIN";
    public static final String TAG_EVENTTYPE = "EVENTTYPE";
    public static final String TAG_DEDATACTRLID = "DEDATACTRLID";
    public static final String TAG_DEDATACTRLNAME = "DEDATACTRLNAME";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_FILEFIELDS = "FILEFIELDS";
    public static final String TAG_IMPORTACTIONMODE = "IMPORTACTIONMODE";

    public boolean isDEDATASYNCIDNull() {
        return this.IsParamNull(TAG_DEDATASYNCID);
    }

    public String getDEDATASYNCID() {
        return this.GetParamStringValue(TAG_DEDATASYNCID, "");
    }

    public void setDEDATASYNCID(String strValue) {
        this.SetParamValue(TAG_DEDATASYNCID, strValue);
    }

    public boolean isDEDATASYNCNAMENull() {
        return this.IsParamNull(TAG_DEDATASYNCNAME);
    }

    public String getDEDATASYNCNAME() {
        return this.GetParamStringValue(TAG_DEDATASYNCNAME, "");
    }

    public void setDEDATASYNCNAME(String strValue) {
        this.SetParamValue(TAG_DEDATASYNCNAME, strValue);
    }

    public boolean isENABLENull() {
        return this.IsParamNull(TAG_ENABLE);
    }

    public boolean getENABLE() {
        return this.GetParamIntValue(TAG_ENABLE, 0) == 1;
    }

    public void setENABLE(boolean bValue) {
        this.SetParamValue(TAG_ENABLE, bValue ? 1 : 0);
    }

    public boolean isCREATEMANNull() {
        return this.IsParamNull(TAG_CREATEMAN);
    }

    public String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public boolean isCREATEDATENull() {
        return this.IsParamNull(TAG_CREATEDATE);
    }

    public Date getCREATEDATE() {
        return this.GetParamDateValue(TAG_CREATEDATE, null);
    }

    public void setCREATEDATE(Date dtValue) {
        this.SetParamValue(TAG_CREATEDATE, dtValue);
    }

    public boolean isUPDATEMANNull() {
        return this.IsParamNull(TAG_UPDATEMAN);
    }

    public String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public boolean isUPDATEDATENull() {
        return this.IsParamNull(TAG_UPDATEDATE);
    }

    public Date getUPDATEDATE() {
        return this.GetParamDateValue(TAG_UPDATEDATE, null);
    }

    public void setUPDATEDATE(Date dtValue) {
        this.SetParamValue(TAG_UPDATEDATE, dtValue);
    }

    public boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
    }

    public boolean isDEIDNull() {
        return this.IsParamNull(TAG_DEID);
    }

    public String getDEID() {
        return this.GetParamStringValue(TAG_DEID, "");
    }

    public void setDEID(String strValue) {
        this.SetParamValue(TAG_DEID, strValue);
    }

    public boolean isDENAMENull() {
        return this.IsParamNull(TAG_DENAME);
    }

    public String getDENAME() {
        return this.GetParamStringValue(TAG_DENAME, "");
    }

    public void setDENAME(String strValue) {
        this.SetParamValue(TAG_DENAME, strValue);
    }

    public boolean isSYNCDIRNull() {
        return this.IsParamNull(TAG_SYNCDIR);
    }

    public String getSYNCDIR() {
        return this.GetParamStringValue(TAG_SYNCDIR, "");
    }

    public void setSYNCDIR(String strValue) {
        this.SetParamValue(TAG_SYNCDIR, strValue);
    }

    public boolean isSYNCEXPORTNull() {
        return this.IsParamNull(TAG_SYNCEXPORT);
    }

    public boolean getSYNCEXPORT() {
        return this.GetParamIntValue(TAG_SYNCEXPORT, 0) == 1;
    }

    public void setSYNCEXPORT(boolean bValue) {
        this.SetParamValue(TAG_SYNCEXPORT, bValue ? 1 : 0);
    }

    public boolean isEXPORTFULLNull() {
        return this.IsParamNull(TAG_EXPORTFULL);
    }

    public boolean getEXPORTFULL() {
        return this.GetParamIntValue(TAG_EXPORTFULL, 0) == 1;
    }

    public void setEXPORTFULL(boolean bValue) {
        this.SetParamValue(TAG_EXPORTFULL, bValue ? 1 : 0);
    }

    public boolean isSYNCAGENTOUTNull() {
        return this.IsParamNull(TAG_SYNCAGENTOUT);
    }

    public String getSYNCAGENTOUT() {
        return this.GetParamStringValue(TAG_SYNCAGENTOUT, "");
    }

    public void setSYNCAGENTOUT(String strValue) {
        this.SetParamValue(TAG_SYNCAGENTOUT, strValue);
    }

    public boolean isSYNCAGENTINNull() {
        return this.IsParamNull(TAG_SYNCAGENTIN);
    }

    public String getSYNCAGENTIN() {
        return this.GetParamStringValue(TAG_SYNCAGENTIN, "");
    }

    public void setSYNCAGENTIN(String strValue) {
        this.SetParamValue(TAG_SYNCAGENTIN, strValue);
    }

    public boolean isEVENTTYPENull() {
        return this.IsParamNull(TAG_EVENTTYPE);
    }

    public int getEVENTTYPE() {
        return this.GetParamIntValue(TAG_EVENTTYPE, 0);
    }

    public void setEVENTTYPE(int nValue) {
        this.SetParamValue(TAG_EVENTTYPE, nValue);
    }

    public boolean isDEDATACTRLIDNull() {
        return this.IsParamNull(TAG_DEDATACTRLID);
    }

    public String getDEDATACTRLID() {
        return this.GetParamStringValue(TAG_DEDATACTRLID, "");
    }

    public void setDEDATACTRLID(String strValue) {
        this.SetParamValue(TAG_DEDATACTRLID, strValue);
    }

    public boolean isDEDATACTRLNAMENull() {
        return this.IsParamNull(TAG_DEDATACTRLNAME);
    }

    public String getDEDATACTRLNAME() {
        return this.GetParamStringValue(TAG_DEDATACTRLNAME, "");
    }

    public void setDEDATACTRLNAME(String strValue) {
        this.SetParamValue(TAG_DEDATACTRLNAME, strValue);
    }

    public boolean isDESCRIPTIONNull() {
        return this.IsParamNull(TAG_DESCRIPTION);
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }

    public boolean isFILEFIELDSNull() {
        return this.IsParamNull(TAG_FILEFIELDS);
    }

    public String getFILEFIELDS() {
        return this.GetParamStringValue(TAG_FILEFIELDS, "");
    }

    public void setFILEFIELDS(String strValue) {
        this.SetParamValue(TAG_FILEFIELDS, strValue);
    }

    public final boolean isIMPORTACTIONMODENull() {
        return this.IsParamNull(TAG_IMPORTACTIONMODE);
    }

    public final String getIMPORTACTIONMODE() {
        return this.GetParamStringValue(TAG_IMPORTACTIONMODE, "");
    }

    public final void setIMPORTACTIONMODE(String strValue) {
        this.SetParamValue(TAG_IMPORTACTIONMODE, strValue);
    }
}

