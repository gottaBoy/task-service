/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDESampleData
extends BaseDataEntity {
    public static final String DATATYPE_JSON = "JSON";
    public static final String DATATYPE_XML = "XML";
    public static final String DATATYPE_SCRIPT = "SCRIPT";
    public static final String DATATYPE_USER = "USER";
    public static final String LOGICMODE_INSTALLDATA = "INSTALLDATA";
    public static final String TAG_PSDESAMPLEDATAID = "PSDESAMPLEDATAID";
    public static final String TAG_PSDESAMPLEDATANAME = "PSDESAMPLEDATANAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_DATA = "DATA";
    @Deprecated
    public static final String TAG_RANDOMECNT = "RANDOMECNT";
    public static final String TAG_RANDOMCNT = "RANDOMCNT";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_RANDOMMODE = "RANDOMMODE";
    public static final String TAG_RANDOMPARAM = "RANDOMPARAM";
    public static final String TAG_RANDOMPARAM2 = "RANDOMPARAM2";
    public static final String TAG_RANDOMPARAM3 = "RANDOMPARAM3";
    public static final String TAG_RANDOMPARAM4 = "RANDOMPARAM4";
    public static final String TAG_PSDEMAINSTATEID = "PSDEMAINSTATEID";
    public static final String TAG_PSDEMAINSTATENAME = "PSDEMAINSTATENAME";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_DATA2 = "DATA2";
    public static final String TAG_DATATYPE = "DATATYPE";
    public static final String TAG_LOGICMODE = "LOGICMODE";
    public static final String TAG_PSSYSREQITEMID = "PSSYSREQITEMID";
    public static final String TAG_PSSYSREQITEMNAME = "PSSYSREQITEMNAME";
    public static final String TAG_SDTAG = "SDTAG";
    public static final String TAG_SDTAG2 = "SDTAG2";
    public static final String TAG_SDTAG3 = "SDTAG3";
    public static final String TAG_SDTAG4 = "SDTAG4";
    public static final String TAG_CUSTOMMODE = "CUSTOMMODE";
    public static final String TAG_CUSTOMCODE = "CUSTOMCODE";
    public static final String TAG_USAGE = "USAGE";

    public final boolean isPSDESAMPLEDATAIDNull() {
        return this.IsParamNull(TAG_PSDESAMPLEDATAID);
    }

    public final String getPSDESAMPLEDATAID() {
        return this.GetParamStringValue(TAG_PSDESAMPLEDATAID, "");
    }

    public final void setPSDESAMPLEDATAID(String strValue) {
        this.SetParamValue(TAG_PSDESAMPLEDATAID, strValue);
    }

    public final boolean isPSDESAMPLEDATANAMENull() {
        return this.IsParamNull(TAG_PSDESAMPLEDATANAME);
    }

    public final String getPSDESAMPLEDATANAME() {
        return this.GetParamStringValue(TAG_PSDESAMPLEDATANAME, "");
    }

    public final void setPSDESAMPLEDATANAME(String strValue) {
        this.SetParamValue(TAG_PSDESAMPLEDATANAME, strValue);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
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

    public final boolean isRANDOMECNTNull() {
        return this.IsParamNull(TAG_RANDOMECNT);
    }

    public final int getRANDOMECNT() {
        return this.GetParamIntValue(TAG_RANDOMECNT, 0);
    }

    public final void setRANDOMECNT(int nValue) {
        this.SetParamValue(TAG_RANDOMECNT, nValue);
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

    public final boolean isRANDOMMODENull() {
        return this.IsParamNull(TAG_RANDOMMODE);
    }

    public final String getRANDOMMODE() {
        return this.GetParamStringValue(TAG_RANDOMMODE, "");
    }

    public final void setRANDOMMODE(String strValue) {
        this.SetParamValue(TAG_RANDOMMODE, strValue);
    }

    public final boolean isRANDOMPARAMNull() {
        return this.IsParamNull(TAG_RANDOMPARAM);
    }

    public final String getRANDOMPARAM() {
        return this.GetParamStringValue(TAG_RANDOMPARAM, "");
    }

    public final void setRANDOMPARAM(String strValue) {
        this.SetParamValue(TAG_RANDOMPARAM, strValue);
    }

    public final boolean isRANDOMPARAM2Null() {
        return this.IsParamNull(TAG_RANDOMPARAM2);
    }

    public final String getRANDOMPARAM2() {
        return this.GetParamStringValue(TAG_RANDOMPARAM2, "");
    }

    public final void setRANDOMPARAM2(String strValue) {
        this.SetParamValue(TAG_RANDOMPARAM2, strValue);
    }

    public final boolean isRANDOMPARAM3Null() {
        return this.IsParamNull(TAG_RANDOMPARAM3);
    }

    public final int getRANDOMPARAM3() {
        return this.GetParamIntValue(TAG_RANDOMPARAM3, 0);
    }

    public final void setRANDOMPARAM3(int nValue) {
        this.SetParamValue(TAG_RANDOMPARAM3, nValue);
    }

    public final boolean isRANDOMPARAM4Null() {
        return this.IsParamNull(TAG_RANDOMPARAM4);
    }

    public final int getRANDOMPARAM4() {
        return this.GetParamIntValue(TAG_RANDOMPARAM4, 0);
    }

    public final void setRANDOMPARAM4(int nValue) {
        this.SetParamValue(TAG_RANDOMPARAM4, nValue);
    }

    public final boolean isPSDEMAINSTATEIDNull() {
        return this.IsParamNull(TAG_PSDEMAINSTATEID);
    }

    public final String getPSDEMAINSTATEID() {
        return this.GetParamStringValue(TAG_PSDEMAINSTATEID, "");
    }

    public final void setPSDEMAINSTATEID(String strValue) {
        this.SetParamValue(TAG_PSDEMAINSTATEID, strValue);
    }

    public final boolean isPSDEMAINSTATENAMENull() {
        return this.IsParamNull(TAG_PSDEMAINSTATENAME);
    }

    public final String getPSDEMAINSTATENAME() {
        return this.GetParamStringValue(TAG_PSDEMAINSTATENAME, "");
    }

    public final void setPSDEMAINSTATENAME(String strValue) {
        this.SetParamValue(TAG_PSDEMAINSTATENAME, strValue);
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

    public final boolean isUSERCATNull() {
        return this.IsParamNull(TAG_USERCAT);
    }

    public final String getUSERCAT() {
        return this.GetParamStringValue(TAG_USERCAT, "");
    }

    public final void setUSERCAT(String strValue) {
        this.SetParamValue(TAG_USERCAT, strValue);
    }

    public final boolean isUSERTAG4Null() {
        return this.IsParamNull(TAG_USERTAG4);
    }

    public final String getUSERTAG4() {
        return this.GetParamStringValue(TAG_USERTAG4, "");
    }

    public final void setUSERTAG4(String strValue) {
        this.SetParamValue(TAG_USERTAG4, strValue);
    }

    public final boolean isUSERTAG3Null() {
        return this.IsParamNull(TAG_USERTAG3);
    }

    public final String getUSERTAG3() {
        return this.GetParamStringValue(TAG_USERTAG3, "");
    }

    public final void setUSERTAG3(String strValue) {
        this.SetParamValue(TAG_USERTAG3, strValue);
    }

    public final boolean isDATA2Null() {
        return this.IsParamNull(TAG_DATA2);
    }

    public final String getDATA2() {
        return this.GetParamStringValue(TAG_DATA2, "");
    }

    public final void setDATA2(String strValue) {
        this.SetParamValue(TAG_DATA2, strValue);
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

    public final boolean isLOGICMODENull() {
        return this.IsParamNull(TAG_LOGICMODE);
    }

    public final String getLOGICMODE() {
        return this.GetParamStringValue(TAG_LOGICMODE, "");
    }

    public final void setLOGICMODE(String strValue) {
        this.SetParamValue(TAG_LOGICMODE, strValue);
    }

    public final boolean isPSSYSREQITEMIDNull() {
        return this.IsParamNull(TAG_PSSYSREQITEMID);
    }

    public final String getPSSYSREQITEMID() {
        return this.GetParamStringValue(TAG_PSSYSREQITEMID, "");
    }

    public final void setPSSYSREQITEMID(String strValue) {
        this.SetParamValue(TAG_PSSYSREQITEMID, strValue);
    }

    public final boolean isPSSYSREQITEMNAMENull() {
        return this.IsParamNull(TAG_PSSYSREQITEMNAME);
    }

    public final String getPSSYSREQITEMNAME() {
        return this.GetParamStringValue(TAG_PSSYSREQITEMNAME, "");
    }

    public final void setPSSYSREQITEMNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSREQITEMNAME, strValue);
    }

    public final boolean isSDTAGNull() {
        return this.IsParamNull(TAG_SDTAG);
    }

    public final String getSDTAG() {
        return this.GetParamStringValue(TAG_SDTAG, "");
    }

    public final void setSDTAG(String strValue) {
        this.SetParamValue(TAG_SDTAG, strValue);
    }

    public final boolean isSDTAG2Null() {
        return this.IsParamNull(TAG_SDTAG2);
    }

    public final String getSDTAG2() {
        return this.GetParamStringValue(TAG_SDTAG2, "");
    }

    public final void setSDTAG2(String strValue) {
        this.SetParamValue(TAG_SDTAG2, strValue);
    }

    public final boolean isSDTAG3Null() {
        return this.IsParamNull(TAG_SDTAG3);
    }

    public final String getSDTAG3() {
        return this.GetParamStringValue(TAG_SDTAG3, "");
    }

    public final void setSDTAG3(String strValue) {
        this.SetParamValue(TAG_SDTAG3, strValue);
    }

    public final boolean isSDTAG4Null() {
        return this.IsParamNull(TAG_SDTAG4);
    }

    public final String getSDTAG4() {
        return this.GetParamStringValue(TAG_SDTAG4, "");
    }

    public final void setSDTAG4(String strValue) {
        this.SetParamValue(TAG_SDTAG4, strValue);
    }

    public final boolean isCUSTOMMODENull() {
        return this.IsParamNull(TAG_CUSTOMMODE);
    }

    public final boolean getCUSTOMMODE() {
        return this.GetParamIntValue(TAG_CUSTOMMODE, 0) == 1;
    }

    public final void setCUSTOMMODE(boolean bValue) {
        this.SetParamValue(TAG_CUSTOMMODE, bValue ? 1 : 0);
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

    public final boolean isUSAGENull() {
        return this.IsParamNull(TAG_USAGE);
    }

    public final String getUSAGE() {
        return this.GetParamStringValue(TAG_USAGE, "");
    }

    public final void setUSAGE(String strValue) {
        this.SetParamValue(TAG_USAGE, strValue);
    }
}

