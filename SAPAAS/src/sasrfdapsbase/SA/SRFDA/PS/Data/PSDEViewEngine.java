/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDEViewEngine
extends BaseDataEntity {
    public static final String TAG_PSDEVIEWENGINEID = "PSDEVIEWENGINEID";
    public static final String TAG_PSDEVIEWENGINENAME = "PSDEVIEWENGINENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEVIEWBASEID = "PSDEVIEWBASEID";
    public static final String TAG_PSDEVIEWBASENAME = "PSDEVIEWBASENAME";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_PSDEVIEWCTRLID = "PSDEVIEWCTRLID";
    public static final String TAG_PSDEVIEWCTRLNAME = "PSDEVIEWCTRLNAME";
    public static final String TAG_NO2PSDEVIEWCTRLID = "NO2PSDEVIEWCTRLID";
    public static final String TAG_NO2PSDEVIEWCTRLNAME = "NO2PSDEVIEWCTRLNAME";
    public static final String TAG_NO3PSDEVIEWCTRLID = "NO3PSDEVIEWCTRLID";
    public static final String TAG_NO3PSDEVIEWCTRLNAME = "NO3PSDEVIEWCTRLNAME";
    public static final String TAG_NO4PSDEVIEWCTRLID = "NO4PSDEVIEWCTRLID";
    public static final String TAG_NO4PSDEVIEWCTRLNAME = "NO4PSDEVIEWCTRLNAME";
    public static final String TAG_PSDEVIEWLOGICID = "PSDEVIEWLOGICID";
    public static final String TAG_PSDEVIEWLOGICNAME = "PSDEVIEWLOGICNAME";
    public static final String TAG_NO2PSDEVIEWLOGICID = "NO2PSDEVIEWLOGICID";
    public static final String TAG_NO2PSDEVIEWLOGICNAME = "NO2PSDEVIEWLOGICNAME";
    public static final String TAG_NO3PSDEVIEWLOGICID = "NO3PSDEVIEWLOGICID";
    public static final String TAG_NO3PSDEVIEWLOGICNAME = "NO3PSDEVIEWLOGICNAME";
    public static final String TAG_NO4PSDEVIEWLOGICID = "NO4PSDEVIEWLOGICID";
    public static final String TAG_NO4PSDEVIEWLOGICNAME = "NO4PSDEVIEWLOGICNAME";
    public static final String TAG_PSUIENGINETYPEID = "PSUIENGINETYPEID";
    public static final String TAG_PSUIENGINETYPENAME = "PSUIENGINETYPENAME";
    public static final String TAG_ENGINEPARAM = "ENGINEPARAM";
    public static final String TAG_ENGINEPARAM2 = "ENGINEPARAM2";
    public static final String TAG_ENGINEPARAM3 = "ENGINEPARAM3";
    public static final String TAG_ENGINEPARAM4 = "ENGINEPARAM4";
    public static final String TAG_ENGINEPARAM5 = "ENGINEPARAM5";
    public static final String TAG_ENGINEPARAM6 = "ENGINEPARAM6";
    public static final String TAG_ENGINEPARAM7 = "ENGINEPARAM7";
    public static final String TAG_ENGINEPARAM8 = "ENGINEPARAM8";
    public static final String TAG_ENGINEPARAM9 = "ENGINEPARAM9";
    public static final String TAG_ENGINEPARAM10 = "ENGINEPARAM10";
    public static final String TAG_VIEWPARAM = "VIEWPARAM";
    public static final String TAG_VIEWPARAM10 = "VIEWPARAM10";
    public static final String TAG_VIEWPARAM2 = "VIEWPARAM2";
    public static final String TAG_VIEWPARAM3 = "VIEWPARAM3";
    public static final String TAG_VIEWPARAM4 = "VIEWPARAM4";
    public static final String TAG_VIEWPARAM5 = "VIEWPARAM5";
    public static final String TAG_VIEWPARAM6 = "VIEWPARAM6";
    public static final String TAG_VIEWPARAM7 = "VIEWPARAM7";
    public static final String TAG_VIEWPARAM8 = "VIEWPARAM8";
    public static final String TAG_VIEWPARAM9 = "VIEWPARAM9";
    public static final String TAG_WFVIEWPARAM = "WFVIEWPARAM";
    public static final String TAG_WFVIEWPARAM2 = "WFVIEWPARAM2";
    public static final String TAG_WFVIEWPARAM3 = "WFVIEWPARAM3";
    public static final String TAG_WFVIEWPARAM4 = "WFVIEWPARAM4";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";

    public final boolean isPSDEVIEWENGINEIDNull() {
        return this.IsParamNull(TAG_PSDEVIEWENGINEID);
    }

    public final String getPSDEVIEWENGINEID() {
        return this.GetParamStringValue(TAG_PSDEVIEWENGINEID, "");
    }

    public final void setPSDEVIEWENGINEID(String strValue) {
        this.SetParamValue(TAG_PSDEVIEWENGINEID, strValue);
    }

    public final boolean isPSDEVIEWENGINENAMENull() {
        return this.IsParamNull(TAG_PSDEVIEWENGINENAME);
    }

    public final String getPSDEVIEWENGINENAME() {
        return this.GetParamStringValue(TAG_PSDEVIEWENGINENAME, "");
    }

    public final void setPSDEVIEWENGINENAME(String strValue) {
        this.SetParamValue(TAG_PSDEVIEWENGINENAME, strValue);
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

    public final boolean isPSDEVIEWBASEIDNull() {
        return this.IsParamNull(TAG_PSDEVIEWBASEID);
    }

    public final String getPSDEVIEWBASEID() {
        return this.GetParamStringValue(TAG_PSDEVIEWBASEID, "");
    }

    public final void setPSDEVIEWBASEID(String strValue) {
        this.SetParamValue(TAG_PSDEVIEWBASEID, strValue);
    }

    public final boolean isPSDEVIEWBASENAMENull() {
        return this.IsParamNull(TAG_PSDEVIEWBASENAME);
    }

    public final String getPSDEVIEWBASENAME() {
        return this.GetParamStringValue(TAG_PSDEVIEWBASENAME, "");
    }

    public final void setPSDEVIEWBASENAME(String strValue) {
        this.SetParamValue(TAG_PSDEVIEWBASENAME, strValue);
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

    public final boolean isPSDEVIEWCTRLIDNull() {
        return this.IsParamNull(TAG_PSDEVIEWCTRLID);
    }

    public final String getPSDEVIEWCTRLID() {
        return this.GetParamStringValue(TAG_PSDEVIEWCTRLID, "");
    }

    public final void setPSDEVIEWCTRLID(String strValue) {
        this.SetParamValue(TAG_PSDEVIEWCTRLID, strValue);
    }

    public final boolean isPSDEVIEWCTRLNAMENull() {
        return this.IsParamNull(TAG_PSDEVIEWCTRLNAME);
    }

    public final String getPSDEVIEWCTRLNAME() {
        return this.GetParamStringValue(TAG_PSDEVIEWCTRLNAME, "");
    }

    public final void setPSDEVIEWCTRLNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVIEWCTRLNAME, strValue);
    }

    public final boolean isNO2PSDEVIEWCTRLIDNull() {
        return this.IsParamNull(TAG_NO2PSDEVIEWCTRLID);
    }

    public final String getNO2PSDEVIEWCTRLID() {
        return this.GetParamStringValue(TAG_NO2PSDEVIEWCTRLID, "");
    }

    public final void setNO2PSDEVIEWCTRLID(String strValue) {
        this.SetParamValue(TAG_NO2PSDEVIEWCTRLID, strValue);
    }

    public final boolean isNO2PSDEVIEWCTRLNAMENull() {
        return this.IsParamNull(TAG_NO2PSDEVIEWCTRLNAME);
    }

    public final String getNO2PSDEVIEWCTRLNAME() {
        return this.GetParamStringValue(TAG_NO2PSDEVIEWCTRLNAME, "");
    }

    public final void setNO2PSDEVIEWCTRLNAME(String strValue) {
        this.SetParamValue(TAG_NO2PSDEVIEWCTRLNAME, strValue);
    }

    public final boolean isNO3PSDEVIEWCTRLIDNull() {
        return this.IsParamNull(TAG_NO3PSDEVIEWCTRLID);
    }

    public final String getNO3PSDEVIEWCTRLID() {
        return this.GetParamStringValue(TAG_NO3PSDEVIEWCTRLID, "");
    }

    public final void setNO3PSDEVIEWCTRLID(String strValue) {
        this.SetParamValue(TAG_NO3PSDEVIEWCTRLID, strValue);
    }

    public final boolean isNO3PSDEVIEWCTRLNAMENull() {
        return this.IsParamNull(TAG_NO3PSDEVIEWCTRLNAME);
    }

    public final String getNO3PSDEVIEWCTRLNAME() {
        return this.GetParamStringValue(TAG_NO3PSDEVIEWCTRLNAME, "");
    }

    public final void setNO3PSDEVIEWCTRLNAME(String strValue) {
        this.SetParamValue(TAG_NO3PSDEVIEWCTRLNAME, strValue);
    }

    public final boolean isNO4PSDEVIEWCTRLIDNull() {
        return this.IsParamNull(TAG_NO4PSDEVIEWCTRLID);
    }

    public final String getNO4PSDEVIEWCTRLID() {
        return this.GetParamStringValue(TAG_NO4PSDEVIEWCTRLID, "");
    }

    public final void setNO4PSDEVIEWCTRLID(String strValue) {
        this.SetParamValue(TAG_NO4PSDEVIEWCTRLID, strValue);
    }

    public final boolean isNO4PSDEVIEWCTRLNAMENull() {
        return this.IsParamNull(TAG_NO4PSDEVIEWCTRLNAME);
    }

    public final String getNO4PSDEVIEWCTRLNAME() {
        return this.GetParamStringValue(TAG_NO4PSDEVIEWCTRLNAME, "");
    }

    public final void setNO4PSDEVIEWCTRLNAME(String strValue) {
        this.SetParamValue(TAG_NO4PSDEVIEWCTRLNAME, strValue);
    }

    public final boolean isPSDEVIEWLOGICIDNull() {
        return this.IsParamNull(TAG_PSDEVIEWLOGICID);
    }

    public final String getPSDEVIEWLOGICID() {
        return this.GetParamStringValue(TAG_PSDEVIEWLOGICID, "");
    }

    public final void setPSDEVIEWLOGICID(String strValue) {
        this.SetParamValue(TAG_PSDEVIEWLOGICID, strValue);
    }

    public final boolean isPSDEVIEWLOGICNAMENull() {
        return this.IsParamNull(TAG_PSDEVIEWLOGICNAME);
    }

    public final String getPSDEVIEWLOGICNAME() {
        return this.GetParamStringValue(TAG_PSDEVIEWLOGICNAME, "");
    }

    public final void setPSDEVIEWLOGICNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVIEWLOGICNAME, strValue);
    }

    public final boolean isNO2PSDEVIEWLOGICIDNull() {
        return this.IsParamNull(TAG_NO2PSDEVIEWLOGICID);
    }

    public final String getNO2PSDEVIEWLOGICID() {
        return this.GetParamStringValue(TAG_NO2PSDEVIEWLOGICID, "");
    }

    public final void setNO2PSDEVIEWLOGICID(String strValue) {
        this.SetParamValue(TAG_NO2PSDEVIEWLOGICID, strValue);
    }

    public final boolean isNO2PSDEVIEWLOGICNAMENull() {
        return this.IsParamNull(TAG_NO2PSDEVIEWLOGICNAME);
    }

    public final String getNO2PSDEVIEWLOGICNAME() {
        return this.GetParamStringValue(TAG_NO2PSDEVIEWLOGICNAME, "");
    }

    public final void setNO2PSDEVIEWLOGICNAME(String strValue) {
        this.SetParamValue(TAG_NO2PSDEVIEWLOGICNAME, strValue);
    }

    public final boolean isNO3PSDEVIEWLOGICIDNull() {
        return this.IsParamNull(TAG_NO3PSDEVIEWLOGICID);
    }

    public final String getNO3PSDEVIEWLOGICID() {
        return this.GetParamStringValue(TAG_NO3PSDEVIEWLOGICID, "");
    }

    public final void setNO3PSDEVIEWLOGICID(String strValue) {
        this.SetParamValue(TAG_NO3PSDEVIEWLOGICID, strValue);
    }

    public final boolean isNO3PSDEVIEWLOGICNAMENull() {
        return this.IsParamNull(TAG_NO3PSDEVIEWLOGICNAME);
    }

    public final String getNO3PSDEVIEWLOGICNAME() {
        return this.GetParamStringValue(TAG_NO3PSDEVIEWLOGICNAME, "");
    }

    public final void setNO3PSDEVIEWLOGICNAME(String strValue) {
        this.SetParamValue(TAG_NO3PSDEVIEWLOGICNAME, strValue);
    }

    public final boolean isNO4PSDEVIEWLOGICIDNull() {
        return this.IsParamNull(TAG_NO4PSDEVIEWLOGICID);
    }

    public final String getNO4PSDEVIEWLOGICID() {
        return this.GetParamStringValue(TAG_NO4PSDEVIEWLOGICID, "");
    }

    public final void setNO4PSDEVIEWLOGICID(String strValue) {
        this.SetParamValue(TAG_NO4PSDEVIEWLOGICID, strValue);
    }

    public final boolean isNO4PSDEVIEWLOGICNAMENull() {
        return this.IsParamNull(TAG_NO4PSDEVIEWLOGICNAME);
    }

    public final String getNO4PSDEVIEWLOGICNAME() {
        return this.GetParamStringValue(TAG_NO4PSDEVIEWLOGICNAME, "");
    }

    public final void setNO4PSDEVIEWLOGICNAME(String strValue) {
        this.SetParamValue(TAG_NO4PSDEVIEWLOGICNAME, strValue);
    }

    public final boolean isPSUIENGINETYPEIDNull() {
        return this.IsParamNull(TAG_PSUIENGINETYPEID);
    }

    public final String getPSUIENGINETYPEID() {
        return this.GetParamStringValue(TAG_PSUIENGINETYPEID, "");
    }

    public final void setPSUIENGINETYPEID(String strValue) {
        this.SetParamValue(TAG_PSUIENGINETYPEID, strValue);
    }

    public final boolean isPSUIENGINETYPENAMENull() {
        return this.IsParamNull(TAG_PSUIENGINETYPENAME);
    }

    public final String getPSUIENGINETYPENAME() {
        return this.GetParamStringValue(TAG_PSUIENGINETYPENAME, "");
    }

    public final void setPSUIENGINETYPENAME(String strValue) {
        this.SetParamValue(TAG_PSUIENGINETYPENAME, strValue);
    }

    public final boolean isENGINEPARAMNull() {
        return this.IsParamNull(TAG_ENGINEPARAM);
    }

    public final String getENGINEPARAM() {
        return this.GetParamStringValue(TAG_ENGINEPARAM, "");
    }

    public final void setENGINEPARAM(String strValue) {
        this.SetParamValue(TAG_ENGINEPARAM, strValue);
    }

    public final boolean isENGINEPARAM2Null() {
        return this.IsParamNull(TAG_ENGINEPARAM2);
    }

    public final String getENGINEPARAM2() {
        return this.GetParamStringValue(TAG_ENGINEPARAM2, "");
    }

    public final void setENGINEPARAM2(String strValue) {
        this.SetParamValue(TAG_ENGINEPARAM2, strValue);
    }

    public final boolean isENGINEPARAM3Null() {
        return this.IsParamNull(TAG_ENGINEPARAM3);
    }

    public final String getENGINEPARAM3() {
        return this.GetParamStringValue(TAG_ENGINEPARAM3, "");
    }

    public final void setENGINEPARAM3(String strValue) {
        this.SetParamValue(TAG_ENGINEPARAM3, strValue);
    }

    public final boolean isENGINEPARAM4Null() {
        return this.IsParamNull(TAG_ENGINEPARAM4);
    }

    public final String getENGINEPARAM4() {
        return this.GetParamStringValue(TAG_ENGINEPARAM4, "");
    }

    public final void setENGINEPARAM4(String strValue) {
        this.SetParamValue(TAG_ENGINEPARAM4, strValue);
    }

    public final boolean isENGINEPARAM5Null() {
        return this.IsParamNull(TAG_ENGINEPARAM5);
    }

    public final boolean getENGINEPARAM5() {
        return this.GetParamIntValue(TAG_ENGINEPARAM5, 0) == 1;
    }

    public final void setENGINEPARAM5(boolean bValue) {
        this.SetParamValue(TAG_ENGINEPARAM5, bValue ? 1 : 0);
    }

    public final boolean isENGINEPARAM6Null() {
        return this.IsParamNull(TAG_ENGINEPARAM6);
    }

    public final boolean getENGINEPARAM6() {
        return this.GetParamIntValue(TAG_ENGINEPARAM6, 0) == 1;
    }

    public final void setENGINEPARAM6(boolean bValue) {
        this.SetParamValue(TAG_ENGINEPARAM6, bValue ? 1 : 0);
    }

    public final boolean isENGINEPARAM7Null() {
        return this.IsParamNull(TAG_ENGINEPARAM7);
    }

    public final int getENGINEPARAM7() {
        return this.GetParamIntValue(TAG_ENGINEPARAM7, 0);
    }

    public final void setENGINEPARAM7(int nValue) {
        this.SetParamValue(TAG_ENGINEPARAM7, nValue);
    }

    public final boolean isENGINEPARAM8Null() {
        return this.IsParamNull(TAG_ENGINEPARAM8);
    }

    public final int getENGINEPARAM8() {
        return this.GetParamIntValue(TAG_ENGINEPARAM8, 0);
    }

    public final void setENGINEPARAM8(int nValue) {
        this.SetParamValue(TAG_ENGINEPARAM8, nValue);
    }

    public final boolean isENGINEPARAM9Null() {
        return this.IsParamNull(TAG_ENGINEPARAM9);
    }

    public final int getENGINEPARAM9() {
        return this.GetParamIntValue(TAG_ENGINEPARAM9, 0);
    }

    public final void setENGINEPARAM9(int nValue) {
        this.SetParamValue(TAG_ENGINEPARAM9, nValue);
    }

    public final boolean isENGINEPARAM10Null() {
        return this.IsParamNull(TAG_ENGINEPARAM10);
    }

    public final int getENGINEPARAM10() {
        return this.GetParamIntValue(TAG_ENGINEPARAM10, 0);
    }

    public final void setENGINEPARAM10(int nValue) {
        this.SetParamValue(TAG_ENGINEPARAM10, nValue);
    }

    public final boolean isVIEWPARAMNull() {
        return this.IsParamNull(TAG_VIEWPARAM);
    }

    public final String getVIEWPARAM() {
        return this.GetParamStringValue(TAG_VIEWPARAM, "");
    }

    public final void setVIEWPARAM(String strValue) {
        this.SetParamValue(TAG_VIEWPARAM, strValue);
    }

    public final boolean isVIEWPARAM10Null() {
        return this.IsParamNull(TAG_VIEWPARAM10);
    }

    public final int getVIEWPARAM10() {
        return this.GetParamIntValue(TAG_VIEWPARAM10, 0);
    }

    public final void setVIEWPARAM10(int nValue) {
        this.SetParamValue(TAG_VIEWPARAM10, nValue);
    }

    public final boolean isVIEWPARAM2Null() {
        return this.IsParamNull(TAG_VIEWPARAM2);
    }

    public final String getVIEWPARAM2() {
        return this.GetParamStringValue(TAG_VIEWPARAM2, "");
    }

    public final void setVIEWPARAM2(String strValue) {
        this.SetParamValue(TAG_VIEWPARAM2, strValue);
    }

    public final boolean isVIEWPARAM3Null() {
        return this.IsParamNull(TAG_VIEWPARAM3);
    }

    public final int getVIEWPARAM3() {
        return this.GetParamIntValue(TAG_VIEWPARAM3, 0);
    }

    public final void setVIEWPARAM3(int nValue) {
        this.SetParamValue(TAG_VIEWPARAM3, nValue);
    }

    public final boolean isVIEWPARAM4Null() {
        return this.IsParamNull(TAG_VIEWPARAM4);
    }

    public final int getVIEWPARAM4() {
        return this.GetParamIntValue(TAG_VIEWPARAM4, 0);
    }

    public final void setVIEWPARAM4(int nValue) {
        this.SetParamValue(TAG_VIEWPARAM4, nValue);
    }

    public final boolean isVIEWPARAM5Null() {
        return this.IsParamNull(TAG_VIEWPARAM5);
    }

    public final boolean getVIEWPARAM5() {
        return this.GetParamIntValue(TAG_VIEWPARAM5, 0) == 1;
    }

    public final void setVIEWPARAM5(boolean bValue) {
        this.SetParamValue(TAG_VIEWPARAM5, bValue ? 1 : 0);
    }

    public final boolean isVIEWPARAM6Null() {
        return this.IsParamNull(TAG_VIEWPARAM6);
    }

    public final boolean getVIEWPARAM6() {
        return this.GetParamIntValue(TAG_VIEWPARAM6, 0) == 1;
    }

    public final void setVIEWPARAM6(boolean bValue) {
        this.SetParamValue(TAG_VIEWPARAM6, bValue ? 1 : 0);
    }

    public final boolean isVIEWPARAM7Null() {
        return this.IsParamNull(TAG_VIEWPARAM7);
    }

    public final String getVIEWPARAM7() {
        return this.GetParamStringValue(TAG_VIEWPARAM7, "");
    }

    public final void setVIEWPARAM7(String strValue) {
        this.SetParamValue(TAG_VIEWPARAM7, strValue);
    }

    public final boolean isVIEWPARAM8Null() {
        return this.IsParamNull(TAG_VIEWPARAM8);
    }

    public final String getVIEWPARAM8() {
        return this.GetParamStringValue(TAG_VIEWPARAM8, "");
    }

    public final void setVIEWPARAM8(String strValue) {
        this.SetParamValue(TAG_VIEWPARAM8, strValue);
    }

    public final boolean isVIEWPARAM9Null() {
        return this.IsParamNull(TAG_VIEWPARAM9);
    }

    public final int getVIEWPARAM9() {
        return this.GetParamIntValue(TAG_VIEWPARAM9, 0);
    }

    public final void setVIEWPARAM9(int nValue) {
        this.SetParamValue(TAG_VIEWPARAM9, nValue);
    }

    public final boolean isWFVIEWPARAMNull() {
        return this.IsParamNull(TAG_WFVIEWPARAM);
    }

    public final boolean getWFVIEWPARAM() {
        return this.GetParamIntValue(TAG_WFVIEWPARAM, 0) == 1;
    }

    public final void setWFVIEWPARAM(boolean bValue) {
        this.SetParamValue(TAG_WFVIEWPARAM, bValue ? 1 : 0);
    }

    public final boolean isWFVIEWPARAM2Null() {
        return this.IsParamNull(TAG_WFVIEWPARAM2);
    }

    public final boolean getWFVIEWPARAM2() {
        return this.GetParamIntValue(TAG_WFVIEWPARAM2, 0) == 1;
    }

    public final void setWFVIEWPARAM2(boolean bValue) {
        this.SetParamValue(TAG_WFVIEWPARAM2, bValue ? 1 : 0);
    }

    public final boolean isWFVIEWPARAM3Null() {
        return this.IsParamNull(TAG_WFVIEWPARAM3);
    }

    public final String getWFVIEWPARAM3() {
        return this.GetParamStringValue(TAG_WFVIEWPARAM3, "");
    }

    public final void setWFVIEWPARAM3(String strValue) {
        this.SetParamValue(TAG_WFVIEWPARAM3, strValue);
    }

    public final boolean isWFVIEWPARAM4Null() {
        return this.IsParamNull(TAG_WFVIEWPARAM4);
    }

    public final String getWFVIEWPARAM4() {
        return this.GetParamStringValue(TAG_WFVIEWPARAM4, "");
    }

    public final void setWFVIEWPARAM4(String strValue) {
        this.SetParamValue(TAG_WFVIEWPARAM4, strValue);
    }

    public final boolean isORDERVALUENull() {
        return this.IsParamNull(TAG_ORDERVALUE);
    }

    public final int getORDERVALUE() {
        return this.GetParamIntValue(TAG_ORDERVALUE, 0);
    }

    public final void setORDERVALUE(int nValue) {
        this.SetParamValue(TAG_ORDERVALUE, nValue);
    }
}

