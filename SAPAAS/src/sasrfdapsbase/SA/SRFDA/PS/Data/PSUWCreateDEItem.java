/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSUWCreateDEItem
extends BaseDataEntity {
    public static final String TAG_PSUWCREATEDEITEMID = "PSUWCREATEDEITEMID";
    public static final String TAG_PSUWCREATEDEITEMNAME = "PSUWCREATEDEITEMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSUWCREATEDEID = "PSUWCREATEDEID";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_NEWDENAME = "NEWDENAME";
    public static final String TAG_NEWDELOGICNAME = "NEWDELOGICNAME";
    public static final String TAG_NEWDETABLENAME = "NEWDETABLENAME";
    public static final String TAG_NEWDEVIEWNAME = "NEWDEVIEWNAME";
    public static final String TAG_NEWCODENAME = "NEWCODENAME";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_ITEMPARAM = "ITEMPARAM";
    public static final String TAG_ITEMPARAM2 = "ITEMPARAM2";
    public static final String TAG_ITEMPARAM3 = "ITEMPARAM3";
    public static final String TAG_ITEMPARAM4 = "ITEMPARAM4";

    public final boolean isPSUWCREATEDEITEMIDNull() {
        return this.IsParamNull(TAG_PSUWCREATEDEITEMID);
    }

    public final String getPSUWCREATEDEITEMID() {
        return this.GetParamStringValue(TAG_PSUWCREATEDEITEMID, "");
    }

    public final void setPSUWCREATEDEITEMID(String strValue) {
        this.SetParamValue(TAG_PSUWCREATEDEITEMID, strValue);
    }

    public final boolean isPSUWCREATEDEITEMNAMENull() {
        return this.IsParamNull(TAG_PSUWCREATEDEITEMNAME);
    }

    public final String getPSUWCREATEDEITEMNAME() {
        return this.GetParamStringValue(TAG_PSUWCREATEDEITEMNAME, "");
    }

    public final void setPSUWCREATEDEITEMNAME(String strValue) {
        this.SetParamValue(TAG_PSUWCREATEDEITEMNAME, strValue);
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

    public final boolean isPSUWCREATEDEIDNull() {
        return this.IsParamNull(TAG_PSUWCREATEDEID);
    }

    public final String getPSUWCREATEDEID() {
        return this.GetParamStringValue(TAG_PSUWCREATEDEID, "");
    }

    public final void setPSUWCREATEDEID(String strValue) {
        this.SetParamValue(TAG_PSUWCREATEDEID, strValue);
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

    public final boolean isNEWDENAMENull() {
        return this.IsParamNull(TAG_NEWDENAME);
    }

    public final String getNEWDENAME() {
        return this.GetParamStringValue(TAG_NEWDENAME, "");
    }

    public final void setNEWDENAME(String strValue) {
        this.SetParamValue(TAG_NEWDENAME, strValue);
    }

    public final boolean isNEWDELOGICNAMENull() {
        return this.IsParamNull(TAG_NEWDELOGICNAME);
    }

    public final String getNEWDELOGICNAME() {
        return this.GetParamStringValue(TAG_NEWDELOGICNAME, "");
    }

    public final void setNEWDELOGICNAME(String strValue) {
        this.SetParamValue(TAG_NEWDELOGICNAME, strValue);
    }

    public final boolean isNEWDETABLENAMENull() {
        return this.IsParamNull(TAG_NEWDETABLENAME);
    }

    public final String getNEWDETABLENAME() {
        return this.GetParamStringValue(TAG_NEWDETABLENAME, "");
    }

    public final void setNEWDETABLENAME(String strValue) {
        this.SetParamValue(TAG_NEWDETABLENAME, strValue);
    }

    public final boolean isNEWDEVIEWNAMENull() {
        return this.IsParamNull(TAG_NEWDEVIEWNAME);
    }

    public final String getNEWDEVIEWNAME() {
        return this.GetParamStringValue(TAG_NEWDEVIEWNAME, "");
    }

    public final void setNEWDEVIEWNAME(String strValue) {
        this.SetParamValue(TAG_NEWDEVIEWNAME, strValue);
    }

    public final boolean isNEWCODENAMENull() {
        return this.IsParamNull(TAG_NEWCODENAME);
    }

    public final String getNEWCODENAME() {
        return this.GetParamStringValue(TAG_NEWCODENAME, "");
    }

    public final void setNEWCODENAME(String strValue) {
        this.SetParamValue(TAG_NEWCODENAME, strValue);
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

    public final boolean isITEMPARAMNull() {
        return this.IsParamNull(TAG_ITEMPARAM);
    }

    public final String getITEMPARAM() {
        return this.GetParamStringValue(TAG_ITEMPARAM, "");
    }

    public final void setITEMPARAM(String strValue) {
        this.SetParamValue(TAG_ITEMPARAM, strValue);
    }

    public final boolean isITEMPARAM2Null() {
        return this.IsParamNull(TAG_ITEMPARAM2);
    }

    public final String getITEMPARAM2() {
        return this.GetParamStringValue(TAG_ITEMPARAM2, "");
    }

    public final void setITEMPARAM2(String strValue) {
        this.SetParamValue(TAG_ITEMPARAM2, strValue);
    }

    public final boolean isITEMPARAM3Null() {
        return this.IsParamNull(TAG_ITEMPARAM3);
    }

    public final int getITEMPARAM3() {
        return this.GetParamIntValue(TAG_ITEMPARAM3, 0);
    }

    public final void setITEMPARAM3(int nValue) {
        this.SetParamValue(TAG_ITEMPARAM3, nValue);
    }

    public final boolean isITEMPARAM4Null() {
        return this.IsParamNull(TAG_ITEMPARAM4);
    }

    public final int getITEMPARAM4() {
        return this.GetParamIntValue(TAG_ITEMPARAM4, 0);
    }

    public final void setITEMPARAM4(int nValue) {
        this.SetParamValue(TAG_ITEMPARAM4, nValue);
    }
}

