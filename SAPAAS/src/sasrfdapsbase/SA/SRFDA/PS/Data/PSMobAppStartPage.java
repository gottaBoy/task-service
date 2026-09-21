/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSMobAppStartPage
extends BaseDataEntity {
    public static final String PSMOBAPPSTARTPAGENAME_1080_1920 = "1080_1920";
    public static final String PSMOBAPPSTARTPAGENAME_1536_2048 = "1536_2048";
    public static final String PSMOBAPPSTARTPAGENAME_1125_2436 = "1125_2436";
    public static final String PSMOBAPPSTARTPAGENAME_750_1334 = "750_1334";
    public static final String PSMOBAPPSTARTPAGENAME_640_1136 = "640_1136";
    public static final String PSMOBAPPSTARTPAGENAME_640_960 = "640_960";
    public static final String PSMOBAPPSTARTPAGENAME_16_16 = "16_16";
    public static final String PSMOBAPPSTARTPAGENAME_32_32 = "32_32";
    public static final String PSMOBAPPSTARTPAGENAME_48_48 = "48_48";
    public static final String PSMOBAPPSTARTPAGENAME_64_64 = "64_64";
    public static final String PSMOBAPPSTARTPAGENAME_96_96 = "96_96";
    public static final String PSMOBAPPSTARTPAGENAME_128_128 = "128_128";
    public static final String RESTYPE_STARTPAGE = "STARTPAGE";
    public static final String RESTYPE_ICON = "ICON";
    public static final String TAG_PSMOBAPPSTARTPAGEID = "PSMOBAPPSTARTPAGEID";
    public static final String TAG_PSMOBAPPSTARTPAGENAME = "PSMOBAPPSTARTPAGENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSAPPID = "PSSYSAPPID";
    public static final String TAG_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_STARTPAGEFILE = "STARTPAGEFILE";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_RESTYPE = "RESTYPE";
    public static final String TAG_RESSPEC = "RESSPEC";

    public final boolean isPSMOBAPPSTARTPAGEIDNull() {
        return this.IsParamNull(TAG_PSMOBAPPSTARTPAGEID);
    }

    public final String getPSMOBAPPSTARTPAGEID() {
        return this.GetParamStringValue(TAG_PSMOBAPPSTARTPAGEID, "");
    }

    public final void setPSMOBAPPSTARTPAGEID(String strValue) {
        this.SetParamValue(TAG_PSMOBAPPSTARTPAGEID, strValue);
    }

    public final boolean isPSMOBAPPSTARTPAGENAMENull() {
        return this.IsParamNull(TAG_PSMOBAPPSTARTPAGENAME);
    }

    public final String getPSMOBAPPSTARTPAGENAME() {
        return this.GetParamStringValue(TAG_PSMOBAPPSTARTPAGENAME, "");
    }

    public final void setPSMOBAPPSTARTPAGENAME(String strValue) {
        this.SetParamValue(TAG_PSMOBAPPSTARTPAGENAME, strValue);
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

    public final boolean isPSSYSAPPIDNull() {
        return this.IsParamNull(TAG_PSSYSAPPID);
    }

    public final String getPSSYSAPPID() {
        return this.GetParamStringValue(TAG_PSSYSAPPID, "");
    }

    public final void setPSSYSAPPID(String strValue) {
        this.SetParamValue(TAG_PSSYSAPPID, strValue);
    }

    public final boolean isPSSYSAPPNAMENull() {
        return this.IsParamNull(TAG_PSSYSAPPNAME);
    }

    public final String getPSSYSAPPNAME() {
        return this.GetParamStringValue(TAG_PSSYSAPPNAME, "");
    }

    public final void setPSSYSAPPNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSAPPNAME, strValue);
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

    public final boolean isSTARTPAGEFILENull() {
        return this.IsParamNull(TAG_STARTPAGEFILE);
    }

    public final String getSTARTPAGEFILE() {
        return this.GetParamStringValue(TAG_STARTPAGEFILE, "");
    }

    public final void setSTARTPAGEFILE(String strValue) {
        this.SetParamValue(TAG_STARTPAGEFILE, strValue);
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

    public final boolean isRESTYPENull() {
        return this.IsParamNull(TAG_RESTYPE);
    }

    public final String getRESTYPE() {
        return this.GetParamStringValue(TAG_RESTYPE, "");
    }

    public final void setRESTYPE(String strValue) {
        this.SetParamValue(TAG_RESTYPE, strValue);
    }

    public final boolean isRESSPECNull() {
        return this.IsParamNull(TAG_RESSPEC);
    }

    public final String getRESSPEC() {
        return this.GetParamStringValue(TAG_RESSPEC, "");
    }

    public final void setRESSPEC(String strValue) {
        this.SetParamValue(TAG_RESSPEC, strValue);
    }
}

