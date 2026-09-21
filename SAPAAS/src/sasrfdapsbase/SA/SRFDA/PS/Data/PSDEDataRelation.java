/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDEDataRelation
extends BaseDataEntity {
    public static final String TAG_PSDEDATARELATIONID = "PSDEDATARELATIONID";
    public static final String TAG_PSDEDATARELATIONNAME = "PSDEDATARELATIONNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_PSSYSCOUNTERID = "PSSYSCOUNTERID";
    public static final String TAG_PSSYSCOUNTERNAME = "PSSYSCOUNTERNAME";
    public static final String TAG_FORMPSDEVIEWBASEID = "FORMPSDEVIEWBASEID";
    public static final String TAG_FORMPSDEVIEWBASENAME = "FORMPSDEVIEWBASENAME";
    public static final String TAG_HIDEEDITITEM = "HIDEEDITITEM";
    public static final String TAG_FORMCAPTION = "FORMCAPTION";
    public static final String TAG_FORMCAPPSLANRESID = "FORMCAPPSLANRESID";
    public static final String TAG_FORMCAPPSLANRESNAME = "FORMCAPPSLANRESNAME";
    public static final String TAG_FORMPSSYSIMAGEID = "FORMPSSYSIMAGEID";
    public static final String TAG_FORMPSSYSIMAGENAME = "FORMPSSYSIMAGENAME";
    public static final String TAG_PSCTRLLOGICGROUPID = "PSCTRLLOGICGROUPID";
    public static final String TAG_PSCTRLLOGICGROUPNAME = "PSCTRLLOGICGROUPNAME";
    public static final String TAG_ENABLECUSTOMIZED = "ENABLECUSTOMIZED";
    public static final String TAG_PSDEUAGROUPID = "PSDEUAGROUPID";
    public static final String TAG_PSDEUAGROUPNAME = "PSDEUAGROUPNAME";

    public final boolean isPSDEDATARELATIONIDNull() {
        return this.IsParamNull(TAG_PSDEDATARELATIONID);
    }

    public final String getPSDEDATARELATIONID() {
        return this.GetParamStringValue(TAG_PSDEDATARELATIONID, "");
    }

    public final void setPSDEDATARELATIONID(String strValue) {
        this.SetParamValue(TAG_PSDEDATARELATIONID, strValue);
    }

    public final boolean isPSDEDATARELATIONNAMENull() {
        return this.IsParamNull(TAG_PSDEDATARELATIONNAME);
    }

    public final String getPSDEDATARELATIONNAME() {
        return this.GetParamStringValue(TAG_PSDEDATARELATIONNAME, "");
    }

    public final void setPSDEDATARELATIONNAME(String strValue) {
        this.SetParamValue(TAG_PSDEDATARELATIONNAME, strValue);
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

    public final boolean isCODENAMENull() {
        return this.IsParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.GetParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.SetParamValue(TAG_CODENAME, strValue);
    }

    public final boolean isPSSYSCOUNTERIDNull() {
        return this.IsParamNull(TAG_PSSYSCOUNTERID);
    }

    public final String getPSSYSCOUNTERID() {
        return this.GetParamStringValue(TAG_PSSYSCOUNTERID, "");
    }

    public final void setPSSYSCOUNTERID(String strValue) {
        this.SetParamValue(TAG_PSSYSCOUNTERID, strValue);
    }

    public final boolean isPSSYSCOUNTERNAMENull() {
        return this.IsParamNull(TAG_PSSYSCOUNTERNAME);
    }

    public final String getPSSYSCOUNTERNAME() {
        return this.GetParamStringValue(TAG_PSSYSCOUNTERNAME, "");
    }

    public final void setPSSYSCOUNTERNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSCOUNTERNAME, strValue);
    }

    public final boolean isFORMPSDEVIEWBASEIDNull() {
        return this.IsParamNull(TAG_FORMPSDEVIEWBASEID);
    }

    public final String getFORMPSDEVIEWBASEID() {
        return this.GetParamStringValue(TAG_FORMPSDEVIEWBASEID, "");
    }

    public final void setFORMPSDEVIEWBASEID(String strValue) {
        this.SetParamValue(TAG_FORMPSDEVIEWBASEID, strValue);
    }

    public final boolean isFORMPSDEVIEWBASENAMENull() {
        return this.IsParamNull(TAG_FORMPSDEVIEWBASENAME);
    }

    public final String getFORMPSDEVIEWBASENAME() {
        return this.GetParamStringValue(TAG_FORMPSDEVIEWBASENAME, "");
    }

    public final void setFORMPSDEVIEWBASENAME(String strValue) {
        this.SetParamValue(TAG_FORMPSDEVIEWBASENAME, strValue);
    }

    public final boolean isHIDEEDITITEMNull() {
        return this.IsParamNull(TAG_HIDEEDITITEM);
    }

    public final boolean getHIDEEDITITEM() {
        return this.GetParamIntValue(TAG_HIDEEDITITEM, 0) == 1;
    }

    public final void setHIDEEDITITEM(boolean bValue) {
        this.SetParamValue(TAG_HIDEEDITITEM, bValue ? 1 : 0);
    }

    public final String getFORMCAPTION() {
        return this.GetParamStringValue(TAG_FORMCAPTION, "");
    }

    public final void setFORMCAPTION(String strValue) {
        this.SetParamValue(TAG_FORMCAPTION, strValue);
    }

    public final boolean isFORMCAPPSLANRESIDNull() {
        return this.IsParamNull(TAG_FORMCAPPSLANRESID);
    }

    public final String getFORMCAPPSLANRESID() {
        return this.GetParamStringValue(TAG_FORMCAPPSLANRESID, "");
    }

    public final void setFORMCAPPSLANRESID(String strValue) {
        this.SetParamValue(TAG_FORMCAPPSLANRESID, strValue);
    }

    public final boolean isFORMCAPPSLANRESNAMENull() {
        return this.IsParamNull(TAG_FORMCAPPSLANRESNAME);
    }

    public final String getFORMCAPPSLANRESNAME() {
        return this.GetParamStringValue(TAG_FORMCAPPSLANRESNAME, "");
    }

    public final void setFORMCAPPSLANRESNAME(String strValue) {
        this.SetParamValue(TAG_FORMCAPPSLANRESNAME, strValue);
    }

    public final boolean isFORMPSSYSIMAGEIDNull() {
        return this.IsParamNull(TAG_FORMPSSYSIMAGEID);
    }

    public final String getFORMPSSYSIMAGEID() {
        return this.GetParamStringValue(TAG_FORMPSSYSIMAGEID, "");
    }

    public final void setFORMPSSYSIMAGEID(String strValue) {
        this.SetParamValue(TAG_FORMPSSYSIMAGEID, strValue);
    }

    public final boolean isFORMPSSYSIMAGENAMENull() {
        return this.IsParamNull(TAG_FORMPSSYSIMAGENAME);
    }

    public final String getFORMPSSYSIMAGENAME() {
        return this.GetParamStringValue(TAG_FORMPSSYSIMAGENAME, "");
    }

    public final void setFORMPSSYSIMAGENAME(String strValue) {
        this.SetParamValue(TAG_FORMPSSYSIMAGENAME, strValue);
    }

    public final boolean isPSCTRLLOGICGROUPIDNull() {
        return this.IsParamNull(TAG_PSCTRLLOGICGROUPID);
    }

    public final String getPSCTRLLOGICGROUPID() {
        return this.GetParamStringValue(TAG_PSCTRLLOGICGROUPID, "");
    }

    public final void setPSCTRLLOGICGROUPID(String strValue) {
        this.SetParamValue(TAG_PSCTRLLOGICGROUPID, strValue);
    }

    public final boolean isPSCTRLLOGICGROUPNAMENull() {
        return this.IsParamNull(TAG_PSCTRLLOGICGROUPNAME);
    }

    public final String getPSCTRLLOGICGROUPNAME() {
        return this.GetParamStringValue(TAG_PSCTRLLOGICGROUPNAME, "");
    }

    public final void setPSCTRLLOGICGROUPNAME(String strValue) {
        this.SetParamValue(TAG_PSCTRLLOGICGROUPNAME, strValue);
    }

    public final boolean isENABLECUSTOMIZEDNull() {
        return this.IsParamNull(TAG_ENABLECUSTOMIZED);
    }

    public final boolean getENABLECUSTOMIZED() {
        return this.GetParamIntValue(TAG_ENABLECUSTOMIZED, 0) == 1;
    }

    public final void setENABLECUSTOMIZED(boolean bValue) {
        this.SetParamValue(TAG_ENABLECUSTOMIZED, bValue ? 1 : 0);
    }

    public final boolean isPSDEUAGROUPIDNull() {
        return this.IsParamNull(TAG_PSDEUAGROUPID);
    }

    public final String getPSDEUAGROUPID() {
        return this.GetParamStringValue(TAG_PSDEUAGROUPID, "");
    }

    public final void setPSDEUAGROUPID(String strValue) {
        this.SetParamValue(TAG_PSDEUAGROUPID, strValue);
    }

    public final boolean isPSDEUAGROUPNAMENull() {
        return this.IsParamNull(TAG_PSDEUAGROUPNAME);
    }

    public final String getPSDEUAGROUPNAME() {
        return this.GetParamStringValue(TAG_PSDEUAGROUPNAME, "");
    }

    public final void setPSDEUAGROUPNAME(String strValue) {
        this.SetParamValue(TAG_PSDEUAGROUPNAME, strValue);
    }
}

