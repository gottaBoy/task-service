/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSModel
extends BaseDataEntity {
    public static final String MODELCAT_SYS = "SYS";
    public static final String MODELCAT_PAAS = "PAAS";
    public static final String MODELCAT_DC = "DC";
    public static final String MODELCAT_CFG = "CFG";
    public static final String MODELCAT_OTHER = "OTHER";
    public static final int ENABLEIBIZBAK_1 = 1;
    public static final int ENABLEIBIZBAK_2 = 2;
    public static final int ENABLEIBIZBAK_3 = 3;
    public static final int ENABLEIMPORT_1 = 1;
    public static final int ENABLEIMPORT_2 = 2;
    public static final int ENABLEIMPORT_3 = 3;
    public static final int MODELINSTMODE_NONE = 0;
    public static final int MODELINSTMODE_SYS = 1;
    public static final int MODELINSTMODE_DC = 2;
    public static final int MODELINSTMODE_SYSANDDC = 3;
    public static final String TAG_PSMODELID = "PSMODELID";
    public static final String TAG_PSMODELNAME = "PSMODELNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_MODELDESC = "MODELDESC";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_TYPEOBJ = "TYPEOBJ";
    public static final String TAG_TYPEFIELD = "TYPEFIELD";
    public static final String TAG_MODELCAT = "MODELCAT";
    public static final String TAG_STARTERRORCODE = "STARTERRORCODE";
    public static final String TAG_ENABLEIBIZBAK = "ENABLEIBIZBAK";
    public static final String TAG_ENABLEIMPORT = "ENABLEIMPORT";
    public static final String TAG_PPSMODELID = "PPSMODELID";
    public static final String TAG_PPSMODELNAME = "PPSMODELNAME";
    public static final String TAG_MODELINSTMODE = "MODELINSTMODE";
    public static final String TAG_MODELSTATEFLAG = "MODELSTATEFLAG";
    public static final String TAG_TYPEVALUE = "TYPEVALUE";
    public static final String TAG_ARTICLEURL = "ARTICLEURL";

    public final boolean isPSMODELIDNull() {
        return this.IsParamNull(TAG_PSMODELID);
    }

    public final String getPSMODELID() {
        return this.GetParamStringValue(TAG_PSMODELID, "");
    }

    public final void setPSMODELID(String strValue) {
        this.SetParamValue(TAG_PSMODELID, strValue);
    }

    public final boolean isPSMODELNAMENull() {
        return this.IsParamNull(TAG_PSMODELNAME);
    }

    public final String getPSMODELNAME() {
        return this.GetParamStringValue(TAG_PSMODELNAME, "");
    }

    public final void setPSMODELNAME(String strValue) {
        this.SetParamValue(TAG_PSMODELNAME, strValue);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isMODELDESCNull() {
        return this.IsParamNull(TAG_MODELDESC);
    }

    public final String getMODELDESC() {
        return this.GetParamStringValue(TAG_MODELDESC, "");
    }

    public final void setMODELDESC(String strValue) {
        this.SetParamValue(TAG_MODELDESC, strValue);
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

    public final boolean isTYPEOBJNull() {
        return this.IsParamNull(TAG_TYPEOBJ);
    }

    public final String getTYPEOBJ() {
        return this.GetParamStringValue(TAG_TYPEOBJ, "");
    }

    public final void setTYPEOBJ(String strValue) {
        this.SetParamValue(TAG_TYPEOBJ, strValue);
    }

    public final boolean isTYPEFIELDNull() {
        return this.IsParamNull(TAG_TYPEFIELD);
    }

    public final String getTYPEFIELD() {
        return this.GetParamStringValue(TAG_TYPEFIELD, "");
    }

    public final void setTYPEFIELD(String strValue) {
        this.SetParamValue(TAG_TYPEFIELD, strValue);
    }

    public final boolean isMODELCATNull() {
        return this.IsParamNull(TAG_MODELCAT);
    }

    public final String getMODELCAT() {
        return this.GetParamStringValue(TAG_MODELCAT, "");
    }

    public final void setMODELCAT(String strValue) {
        this.SetParamValue(TAG_MODELCAT, strValue);
    }

    public final boolean isSTARTERRORCODENull() {
        return this.IsParamNull(TAG_STARTERRORCODE);
    }

    public final int getSTARTERRORCODE() {
        return this.GetParamIntValue(TAG_STARTERRORCODE, 0);
    }

    public final void setSTARTERRORCODE(int nValue) {
        this.SetParamValue(TAG_STARTERRORCODE, nValue);
    }

    public final boolean isENABLEIBIZBAKNull() {
        return this.IsParamNull(TAG_ENABLEIBIZBAK);
    }

    public final int getENABLEIBIZBAK() {
        return this.GetParamIntValue(TAG_ENABLEIBIZBAK, 0);
    }

    public final void setENABLEIBIZBAK(int nValue) {
        this.SetParamValue(TAG_ENABLEIBIZBAK, nValue);
    }

    public final boolean isENABLEIMPORTNull() {
        return this.IsParamNull(TAG_ENABLEIMPORT);
    }

    public final int getENABLEIMPORT() {
        return this.GetParamIntValue(TAG_ENABLEIMPORT, 0);
    }

    public final void setENABLEIMPORT(int nValue) {
        this.SetParamValue(TAG_ENABLEIMPORT, nValue);
    }

    public final boolean isPPSMODELIDNull() {
        return this.IsParamNull(TAG_PPSMODELID);
    }

    public final String getPPSMODELID() {
        return this.GetParamStringValue(TAG_PPSMODELID, "");
    }

    public final void setPPSMODELID(String strValue) {
        this.SetParamValue(TAG_PPSMODELID, strValue);
    }

    public final boolean isPPSMODELNAMENull() {
        return this.IsParamNull(TAG_PPSMODELNAME);
    }

    public final String getPPSMODELNAME() {
        return this.GetParamStringValue(TAG_PPSMODELNAME, "");
    }

    public final void setPPSMODELNAME(String strValue) {
        this.SetParamValue(TAG_PPSMODELNAME, strValue);
    }

    public final boolean isMODELINSTMODENull() {
        return this.IsParamNull(TAG_MODELINSTMODE);
    }

    public final int getMODELINSTMODE() {
        return this.GetParamIntValue(TAG_MODELINSTMODE, 0);
    }

    public final void setMODELINSTMODE(int nValue) {
        this.SetParamValue(TAG_MODELINSTMODE, nValue);
    }

    public final boolean isMODELSTATEFLAGNull() {
        return this.IsParamNull(TAG_MODELSTATEFLAG);
    }

    public final boolean getMODELSTATEFLAG() {
        return this.GetParamIntValue(TAG_MODELSTATEFLAG, 0) == 1;
    }

    public final void setMODELSTATEFLAG(boolean bValue) {
        this.SetParamValue(TAG_MODELSTATEFLAG, bValue ? 1 : 0);
    }

    public final boolean isARTICLEURLNull() {
        return this.IsParamNull(TAG_ARTICLEURL);
    }

    public final String getARTICLEURL() {
        return this.GetParamStringValue(TAG_ARTICLEURL, "");
    }

    public final void setARTICLEURL(String strValue) {
        this.SetParamValue(TAG_ARTICLEURL, strValue);
    }
}

