/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSPanelEngine
extends BaseDataEntity {
    public static final String USERCAT_CAT1 = "CAT1";
    public static final String USERCAT_CAT2 = "CAT2";
    public static final String USERCAT_CAT3 = "CAT3";
    public static final String USERCAT_CAT4 = "CAT4";
    public static final String USERCAT_CAT5 = "CAT5";
    public static final String USERCAT_CAT6 = "CAT6";
    public static final String USERCAT_CAT7 = "CAT7";
    public static final String USERCAT_CAT8 = "CAT8";
    public static final String USERCAT_CAT9 = "CAT9";
    public static final String TAG_PSPANELENGINEID = "PSPANELENGINEID";
    public static final String TAG_PSPANELENGINENAME = "PSPANELENGINENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSVIEWPANELID = "PSSYSVIEWPANELID";
    public static final String TAG_PSSYSVIEWPANELNAME = "PSSYSVIEWPANELNAME";
    public static final String TAG_PSPANELITEMID = "PSPANELITEMID";
    public static final String TAG_PSPANELITEMNAME = "PSPANELITEMNAME";
    public static final String TAG_NO2PSPANELITEMID = "NO2PSPANELITEMID";
    public static final String TAG_NO2PSPANELITEMNAME = "NO2PSPANELITEMNAME";
    public static final String TAG_NO3PSPANELITEMID = "NO3PSPANELITEMID";
    public static final String TAG_NO3PSPANELITEMNAME = "NO3PSPANELITEMNAME";
    public static final String TAG_NO4PSPANELITEMID = "NO4PSPANELITEMID";
    public static final String TAG_NO4PSPANELITEMNAME = "NO4PSPANELITEMNAME";
    public static final String TAG_PSPANELLOGICID = "PSPANELLOGICID";
    public static final String TAG_PSPANELLOGICNAME = "PSPANELLOGICNAME";
    public static final String TAG_NO2PSPANELLOGICID = "NO2PSPANELLOGICID";
    public static final String TAG_NO2PSPANELLOGICNAME = "NO2PSPANELLOGICNAME";
    public static final String TAG_NO3PSPANELLOGICID = "NO3PSPANELLOGICID";
    public static final String TAG_NO3PSPANELLOGICNAME = "NO3PSPANELLOGICNAME";
    public static final String TAG_NO4PSPANELLOGICID = "NO4PSPANELLOGICID";
    public static final String TAG_NO4PSPANELLOGICNAME = "NO4PSPANELLOGICNAME";
    public static final String TAG_PSUIENGINETYPEID = "PSUIENGINETYPEID";
    public static final String TAG_PSUIENGINETYPENAME = "PSUIENGINETYPENAME";
    public static final String TAG_ENGINEPARAM = "ENGINEPARAM";
    public static final String TAG_ENGINEPARAM10 = "ENGINEPARAM10";
    public static final String TAG_ENGINEPARAM2 = "ENGINEPARAM2";
    public static final String TAG_ENGINEPARAM3 = "ENGINEPARAM3";
    public static final String TAG_ENGINEPARAM4 = "ENGINEPARAM4";
    public static final String TAG_ENGINEPARAM5 = "ENGINEPARAM5";
    public static final String TAG_ENGINEPARAM6 = "ENGINEPARAM6";
    public static final String TAG_ENGINEPARAM7 = "ENGINEPARAM7";
    public static final String TAG_ENGINEPARAM8 = "ENGINEPARAM8";
    public static final String TAG_ENGINEPARAM9 = "ENGINEPARAM9";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
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
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PANELITEMFLAG = "PANELITEMFLAG";
    public static final String TAG_NO2PANELITEMFLAG = "NO2PANELITEMFLAG";
    public static final String TAG_NO3PANELITEMFLAG = "NO3PANELITEMFLAG";
    public static final String TAG_NO4PANELITEMFLAG = "NO4PANELITEMFLAG";
    public static final String TAG_PANELITEMLABEL = "PANELITEMLABEL";
    public static final String TAG_NO2PANELITEMLABEL = "NO2PANELITEMLABEL";
    public static final String TAG_NO3PANELITEMLABEL = "NO3PANELITEMLABEL";
    public static final String TAG_NO4PANELITEMLABEL = "NO4PANELITEMLABEL";
    public static final String TAG_PANELLOGICFLAG = "PANELLOGICFLAG";
    public static final String TAG_NO2PANELLOGICFLAG = "NO2PANELLOGICFLAG";
    public static final String TAG_NO3PANELLOGICFLAG = "NO3PANELLOGICFLAG";
    public static final String TAG_NO4PANELLOGICFLAG = "NO4PANELLOGICFLAG";
    public static final String TAG_PANELLOGICLABEL = "PANELLOGICLABEL";
    public static final String TAG_NO2PANELLOGICLABEL = "NO2PANELLOGICLABEL";
    public static final String TAG_NO3PANELLOGICLABEL = "NO3PANELLOGICLABEL";
    public static final String TAG_NO4PANELLOGICLABEL = "NO4PANELLOGICLABEL";
    public static final String TAG_ENGINEPARAMFLAG = "ENGINEPARAMFLAG";
    public static final String TAG_ENGINEPARAM2FLAG = "ENGINEPARAM2FLAG";
    public static final String TAG_ENGINEPARAM3FLAG = "ENGINEPARAM3FLAG";
    public static final String TAG_ENGINEPARAM4FLAG = "ENGINEPARAM4FLAG";
    public static final String TAG_ENGINEPARAM5FLAG = "ENGINEPARAM5FLAG";
    public static final String TAG_ENGINEPARAM6FLAG = "ENGINEPARAM6FLAG";
    public static final String TAG_ENGINEPARAM7FLAG = "ENGINEPARAM7FLAG";
    public static final String TAG_ENGINEPARAM8FLAG = "ENGINEPARAM8FLAG";
    public static final String TAG_ENGINEPARAM9FLAG = "ENGINEPARAM9FLAG";
    public static final String TAG_ENGINEPARAM10FLAG = "ENGINEPARAM10FLAG";
    public static final String TAG_ENGINEPARAM10LABEL = "ENGINEPARAM10LABEL";
    public static final String TAG_ENGINEPARAM9LABEL = "ENGINEPARAM9LABEL";
    public static final String TAG_ENGINEPARAM8LABEL = "ENGINEPARAM8LABEL";
    public static final String TAG_ENGINEPARAM7LABEL = "ENGINEPARAM7LABEL";
    public static final String TAG_ENGINEPARAM6LABEL = "ENGINEPARAM6LABEL";
    public static final String TAG_ENGINEPARAM5LABEL = "ENGINEPARAM5LABEL";
    public static final String TAG_ENGINEPARAM4LABEL = "ENGINEPARAM4LABEL";
    public static final String TAG_ENGINEPARAM3LABEL = "ENGINEPARAM3LABEL";
    public static final String TAG_ENGINEPARAM2LABEL = "ENGINEPARAM2LABEL";
    public static final String TAG_ENGINEPARAMLABEL = "ENGINEPARAMLABEL";
    public static final String TAG_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String TAG_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";

    public final boolean isPSPANELENGINEIDNull() {
        return this.IsParamNull(TAG_PSPANELENGINEID);
    }

    public final String getPSPANELENGINEID() {
        return this.GetParamStringValue(TAG_PSPANELENGINEID, "");
    }

    public final void setPSPANELENGINEID(String strValue) {
        this.SetParamValue(TAG_PSPANELENGINEID, strValue);
    }

    public final boolean isPSPANELENGINENAMENull() {
        return this.IsParamNull(TAG_PSPANELENGINENAME);
    }

    public final String getPSPANELENGINENAME() {
        return this.GetParamStringValue(TAG_PSPANELENGINENAME, "");
    }

    public final void setPSPANELENGINENAME(String strValue) {
        this.SetParamValue(TAG_PSPANELENGINENAME, strValue);
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

    public final boolean isPSSYSVIEWPANELIDNull() {
        return this.IsParamNull(TAG_PSSYSVIEWPANELID);
    }

    public final String getPSSYSVIEWPANELID() {
        return this.GetParamStringValue(TAG_PSSYSVIEWPANELID, "");
    }

    public final void setPSSYSVIEWPANELID(String strValue) {
        this.SetParamValue(TAG_PSSYSVIEWPANELID, strValue);
    }

    public final boolean isPSSYSVIEWPANELNAMENull() {
        return this.IsParamNull(TAG_PSSYSVIEWPANELNAME);
    }

    public final String getPSSYSVIEWPANELNAME() {
        return this.GetParamStringValue(TAG_PSSYSVIEWPANELNAME, "");
    }

    public final void setPSSYSVIEWPANELNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSVIEWPANELNAME, strValue);
    }

    public final boolean isPSPANELITEMIDNull() {
        return this.IsParamNull(TAG_PSPANELITEMID);
    }

    public final String getPSPANELITEMID() {
        return this.GetParamStringValue(TAG_PSPANELITEMID, "");
    }

    public final void setPSPANELITEMID(String strValue) {
        this.SetParamValue(TAG_PSPANELITEMID, strValue);
    }

    public final boolean isPSPANELITEMNAMENull() {
        return this.IsParamNull(TAG_PSPANELITEMNAME);
    }

    public final String getPSPANELITEMNAME() {
        return this.GetParamStringValue(TAG_PSPANELITEMNAME, "");
    }

    public final void setPSPANELITEMNAME(String strValue) {
        this.SetParamValue(TAG_PSPANELITEMNAME, strValue);
    }

    public final boolean isNO2PSPANELITEMIDNull() {
        return this.IsParamNull(TAG_NO2PSPANELITEMID);
    }

    public final String getNO2PSPANELITEMID() {
        return this.GetParamStringValue(TAG_NO2PSPANELITEMID, "");
    }

    public final void setNO2PSPANELITEMID(String strValue) {
        this.SetParamValue(TAG_NO2PSPANELITEMID, strValue);
    }

    public final boolean isNO2PSPANELITEMNAMENull() {
        return this.IsParamNull(TAG_NO2PSPANELITEMNAME);
    }

    public final String getNO2PSPANELITEMNAME() {
        return this.GetParamStringValue(TAG_NO2PSPANELITEMNAME, "");
    }

    public final void setNO2PSPANELITEMNAME(String strValue) {
        this.SetParamValue(TAG_NO2PSPANELITEMNAME, strValue);
    }

    public final boolean isNO3PSPANELITEMIDNull() {
        return this.IsParamNull(TAG_NO3PSPANELITEMID);
    }

    public final String getNO3PSPANELITEMID() {
        return this.GetParamStringValue(TAG_NO3PSPANELITEMID, "");
    }

    public final void setNO3PSPANELITEMID(String strValue) {
        this.SetParamValue(TAG_NO3PSPANELITEMID, strValue);
    }

    public final boolean isNO3PSPANELITEMNAMENull() {
        return this.IsParamNull(TAG_NO3PSPANELITEMNAME);
    }

    public final String getNO3PSPANELITEMNAME() {
        return this.GetParamStringValue(TAG_NO3PSPANELITEMNAME, "");
    }

    public final void setNO3PSPANELITEMNAME(String strValue) {
        this.SetParamValue(TAG_NO3PSPANELITEMNAME, strValue);
    }

    public final boolean isNO4PSPANELITEMIDNull() {
        return this.IsParamNull(TAG_NO4PSPANELITEMID);
    }

    public final String getNO4PSPANELITEMID() {
        return this.GetParamStringValue(TAG_NO4PSPANELITEMID, "");
    }

    public final void setNO4PSPANELITEMID(String strValue) {
        this.SetParamValue(TAG_NO4PSPANELITEMID, strValue);
    }

    public final boolean isNO4PSPANELITEMNAMENull() {
        return this.IsParamNull(TAG_NO4PSPANELITEMNAME);
    }

    public final String getNO4PSPANELITEMNAME() {
        return this.GetParamStringValue(TAG_NO4PSPANELITEMNAME, "");
    }

    public final void setNO4PSPANELITEMNAME(String strValue) {
        this.SetParamValue(TAG_NO4PSPANELITEMNAME, strValue);
    }

    public final boolean isPSPANELLOGICIDNull() {
        return this.IsParamNull(TAG_PSPANELLOGICID);
    }

    public final String getPSPANELLOGICID() {
        return this.GetParamStringValue(TAG_PSPANELLOGICID, "");
    }

    public final void setPSPANELLOGICID(String strValue) {
        this.SetParamValue(TAG_PSPANELLOGICID, strValue);
    }

    public final boolean isPSPANELLOGICNAMENull() {
        return this.IsParamNull(TAG_PSPANELLOGICNAME);
    }

    public final String getPSPANELLOGICNAME() {
        return this.GetParamStringValue(TAG_PSPANELLOGICNAME, "");
    }

    public final void setPSPANELLOGICNAME(String strValue) {
        this.SetParamValue(TAG_PSPANELLOGICNAME, strValue);
    }

    public final boolean isNO2PSPANELLOGICIDNull() {
        return this.IsParamNull(TAG_NO2PSPANELLOGICID);
    }

    public final String getNO2PSPANELLOGICID() {
        return this.GetParamStringValue(TAG_NO2PSPANELLOGICID, "");
    }

    public final void setNO2PSPANELLOGICID(String strValue) {
        this.SetParamValue(TAG_NO2PSPANELLOGICID, strValue);
    }

    public final boolean isNO2PSPANELLOGICNAMENull() {
        return this.IsParamNull(TAG_NO2PSPANELLOGICNAME);
    }

    public final String getNO2PSPANELLOGICNAME() {
        return this.GetParamStringValue(TAG_NO2PSPANELLOGICNAME, "");
    }

    public final void setNO2PSPANELLOGICNAME(String strValue) {
        this.SetParamValue(TAG_NO2PSPANELLOGICNAME, strValue);
    }

    public final boolean isNO3PSPANELLOGICIDNull() {
        return this.IsParamNull(TAG_NO3PSPANELLOGICID);
    }

    public final String getNO3PSPANELLOGICID() {
        return this.GetParamStringValue(TAG_NO3PSPANELLOGICID, "");
    }

    public final void setNO3PSPANELLOGICID(String strValue) {
        this.SetParamValue(TAG_NO3PSPANELLOGICID, strValue);
    }

    public final boolean isNO3PSPANELLOGICNAMENull() {
        return this.IsParamNull(TAG_NO3PSPANELLOGICNAME);
    }

    public final String getNO3PSPANELLOGICNAME() {
        return this.GetParamStringValue(TAG_NO3PSPANELLOGICNAME, "");
    }

    public final void setNO3PSPANELLOGICNAME(String strValue) {
        this.SetParamValue(TAG_NO3PSPANELLOGICNAME, strValue);
    }

    public final boolean isNO4PSPANELLOGICIDNull() {
        return this.IsParamNull(TAG_NO4PSPANELLOGICID);
    }

    public final String getNO4PSPANELLOGICID() {
        return this.GetParamStringValue(TAG_NO4PSPANELLOGICID, "");
    }

    public final void setNO4PSPANELLOGICID(String strValue) {
        this.SetParamValue(TAG_NO4PSPANELLOGICID, strValue);
    }

    public final boolean isNO4PSPANELLOGICNAMENull() {
        return this.IsParamNull(TAG_NO4PSPANELLOGICNAME);
    }

    public final String getNO4PSPANELLOGICNAME() {
        return this.GetParamStringValue(TAG_NO4PSPANELLOGICNAME, "");
    }

    public final void setNO4PSPANELLOGICNAME(String strValue) {
        this.SetParamValue(TAG_NO4PSPANELLOGICNAME, strValue);
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

    public final boolean isENGINEPARAM10Null() {
        return this.IsParamNull(TAG_ENGINEPARAM10);
    }

    public final int getENGINEPARAM10() {
        return this.GetParamIntValue(TAG_ENGINEPARAM10, 0);
    }

    public final void setENGINEPARAM10(int nValue) {
        this.SetParamValue(TAG_ENGINEPARAM10, nValue);
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

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isPANELITEMFLAGNull() {
        return this.IsParamNull(TAG_PANELITEMFLAG);
    }

    public final boolean getPANELITEMFLAG() {
        return this.GetParamIntValue(TAG_PANELITEMFLAG, 0) == 1;
    }

    public final void setPANELITEMFLAG(boolean bValue) {
        this.SetParamValue(TAG_PANELITEMFLAG, bValue ? 1 : 0);
    }

    public final boolean isNO2PANELITEMFLAGNull() {
        return this.IsParamNull(TAG_NO2PANELITEMFLAG);
    }

    public final boolean getNO2PANELITEMFLAG() {
        return this.GetParamIntValue(TAG_NO2PANELITEMFLAG, 0) == 1;
    }

    public final void setNO2PANELITEMFLAG(boolean bValue) {
        this.SetParamValue(TAG_NO2PANELITEMFLAG, bValue ? 1 : 0);
    }

    public final boolean isNO3PANELITEMFLAGNull() {
        return this.IsParamNull(TAG_NO3PANELITEMFLAG);
    }

    public final boolean getNO3PANELITEMFLAG() {
        return this.GetParamIntValue(TAG_NO3PANELITEMFLAG, 0) == 1;
    }

    public final void setNO3PANELITEMFLAG(boolean bValue) {
        this.SetParamValue(TAG_NO3PANELITEMFLAG, bValue ? 1 : 0);
    }

    public final boolean isNO4PANELITEMFLAGNull() {
        return this.IsParamNull(TAG_NO4PANELITEMFLAG);
    }

    public final boolean getNO4PANELITEMFLAG() {
        return this.GetParamIntValue(TAG_NO4PANELITEMFLAG, 0) == 1;
    }

    public final void setNO4PANELITEMFLAG(boolean bValue) {
        this.SetParamValue(TAG_NO4PANELITEMFLAG, bValue ? 1 : 0);
    }

    public final boolean isPANELITEMLABELNull() {
        return this.IsParamNull(TAG_PANELITEMLABEL);
    }

    public final String getPANELITEMLABEL() {
        return this.GetParamStringValue(TAG_PANELITEMLABEL, "");
    }

    public final void setPANELITEMLABEL(String strValue) {
        this.SetParamValue(TAG_PANELITEMLABEL, strValue);
    }

    public final boolean isNO2PANELITEMLABELNull() {
        return this.IsParamNull(TAG_NO2PANELITEMLABEL);
    }

    public final String getNO2PANELITEMLABEL() {
        return this.GetParamStringValue(TAG_NO2PANELITEMLABEL, "");
    }

    public final void setNO2PANELITEMLABEL(String strValue) {
        this.SetParamValue(TAG_NO2PANELITEMLABEL, strValue);
    }

    public final boolean isNO3PANELITEMLABELNull() {
        return this.IsParamNull(TAG_NO3PANELITEMLABEL);
    }

    public final String getNO3PANELITEMLABEL() {
        return this.GetParamStringValue(TAG_NO3PANELITEMLABEL, "");
    }

    public final void setNO3PANELITEMLABEL(String strValue) {
        this.SetParamValue(TAG_NO3PANELITEMLABEL, strValue);
    }

    public final boolean isNO4PANELITEMLABELNull() {
        return this.IsParamNull(TAG_NO4PANELITEMLABEL);
    }

    public final String getNO4PANELITEMLABEL() {
        return this.GetParamStringValue(TAG_NO4PANELITEMLABEL, "");
    }

    public final void setNO4PANELITEMLABEL(String strValue) {
        this.SetParamValue(TAG_NO4PANELITEMLABEL, strValue);
    }

    public final boolean isPANELLOGICFLAGNull() {
        return this.IsParamNull(TAG_PANELLOGICFLAG);
    }

    public final boolean getPANELLOGICFLAG() {
        return this.GetParamIntValue(TAG_PANELLOGICFLAG, 0) == 1;
    }

    public final void setPANELLOGICFLAG(boolean bValue) {
        this.SetParamValue(TAG_PANELLOGICFLAG, bValue ? 1 : 0);
    }

    public final boolean isNO2PANELLOGICFLAGNull() {
        return this.IsParamNull(TAG_NO2PANELLOGICFLAG);
    }

    public final boolean getNO2PANELLOGICFLAG() {
        return this.GetParamIntValue(TAG_NO2PANELLOGICFLAG, 0) == 1;
    }

    public final void setNO2PANELLOGICFLAG(boolean bValue) {
        this.SetParamValue(TAG_NO2PANELLOGICFLAG, bValue ? 1 : 0);
    }

    public final boolean isNO3PANELLOGICFLAGNull() {
        return this.IsParamNull(TAG_NO3PANELLOGICFLAG);
    }

    public final boolean getNO3PANELLOGICFLAG() {
        return this.GetParamIntValue(TAG_NO3PANELLOGICFLAG, 0) == 1;
    }

    public final void setNO3PANELLOGICFLAG(boolean bValue) {
        this.SetParamValue(TAG_NO3PANELLOGICFLAG, bValue ? 1 : 0);
    }

    public final boolean isNO4PANELLOGICFLAGNull() {
        return this.IsParamNull(TAG_NO4PANELLOGICFLAG);
    }

    public final boolean getNO4PANELLOGICFLAG() {
        return this.GetParamIntValue(TAG_NO4PANELLOGICFLAG, 0) == 1;
    }

    public final void setNO4PANELLOGICFLAG(boolean bValue) {
        this.SetParamValue(TAG_NO4PANELLOGICFLAG, bValue ? 1 : 0);
    }

    public final boolean isPANELLOGICLABELNull() {
        return this.IsParamNull(TAG_PANELLOGICLABEL);
    }

    public final String getPANELLOGICLABEL() {
        return this.GetParamStringValue(TAG_PANELLOGICLABEL, "");
    }

    public final void setPANELLOGICLABEL(String strValue) {
        this.SetParamValue(TAG_PANELLOGICLABEL, strValue);
    }

    public final boolean isNO2PANELLOGICLABELNull() {
        return this.IsParamNull(TAG_NO2PANELLOGICLABEL);
    }

    public final String getNO2PANELLOGICLABEL() {
        return this.GetParamStringValue(TAG_NO2PANELLOGICLABEL, "");
    }

    public final void setNO2PANELLOGICLABEL(String strValue) {
        this.SetParamValue(TAG_NO2PANELLOGICLABEL, strValue);
    }

    public final boolean isNO3PANELLOGICLABELNull() {
        return this.IsParamNull(TAG_NO3PANELLOGICLABEL);
    }

    public final String getNO3PANELLOGICLABEL() {
        return this.GetParamStringValue(TAG_NO3PANELLOGICLABEL, "");
    }

    public final void setNO3PANELLOGICLABEL(String strValue) {
        this.SetParamValue(TAG_NO3PANELLOGICLABEL, strValue);
    }

    public final boolean isNO4PANELLOGICLABELNull() {
        return this.IsParamNull(TAG_NO4PANELLOGICLABEL);
    }

    public final String getNO4PANELLOGICLABEL() {
        return this.GetParamStringValue(TAG_NO4PANELLOGICLABEL, "");
    }

    public final void setNO4PANELLOGICLABEL(String strValue) {
        this.SetParamValue(TAG_NO4PANELLOGICLABEL, strValue);
    }

    public final boolean isENGINEPARAMFLAGNull() {
        return this.IsParamNull(TAG_ENGINEPARAMFLAG);
    }

    public final boolean getENGINEPARAMFLAG() {
        return this.GetParamIntValue(TAG_ENGINEPARAMFLAG, 0) == 1;
    }

    public final void setENGINEPARAMFLAG(boolean bValue) {
        this.SetParamValue(TAG_ENGINEPARAMFLAG, bValue ? 1 : 0);
    }

    public final boolean isENGINEPARAM2FLAGNull() {
        return this.IsParamNull(TAG_ENGINEPARAM2FLAG);
    }

    public final boolean getENGINEPARAM2FLAG() {
        return this.GetParamIntValue(TAG_ENGINEPARAM2FLAG, 0) == 1;
    }

    public final void setENGINEPARAM2FLAG(boolean bValue) {
        this.SetParamValue(TAG_ENGINEPARAM2FLAG, bValue ? 1 : 0);
    }

    public final boolean isENGINEPARAM3FLAGNull() {
        return this.IsParamNull(TAG_ENGINEPARAM3FLAG);
    }

    public final boolean getENGINEPARAM3FLAG() {
        return this.GetParamIntValue(TAG_ENGINEPARAM3FLAG, 0) == 1;
    }

    public final void setENGINEPARAM3FLAG(boolean bValue) {
        this.SetParamValue(TAG_ENGINEPARAM3FLAG, bValue ? 1 : 0);
    }

    public final boolean isENGINEPARAM4FLAGNull() {
        return this.IsParamNull(TAG_ENGINEPARAM4FLAG);
    }

    public final boolean getENGINEPARAM4FLAG() {
        return this.GetParamIntValue(TAG_ENGINEPARAM4FLAG, 0) == 1;
    }

    public final void setENGINEPARAM4FLAG(boolean bValue) {
        this.SetParamValue(TAG_ENGINEPARAM4FLAG, bValue ? 1 : 0);
    }

    public final boolean isENGINEPARAM5FLAGNull() {
        return this.IsParamNull(TAG_ENGINEPARAM5FLAG);
    }

    public final boolean getENGINEPARAM5FLAG() {
        return this.GetParamIntValue(TAG_ENGINEPARAM5FLAG, 0) == 1;
    }

    public final void setENGINEPARAM5FLAG(boolean bValue) {
        this.SetParamValue(TAG_ENGINEPARAM5FLAG, bValue ? 1 : 0);
    }

    public final boolean isENGINEPARAM6FLAGNull() {
        return this.IsParamNull(TAG_ENGINEPARAM6FLAG);
    }

    public final boolean getENGINEPARAM6FLAG() {
        return this.GetParamIntValue(TAG_ENGINEPARAM6FLAG, 0) == 1;
    }

    public final void setENGINEPARAM6FLAG(boolean bValue) {
        this.SetParamValue(TAG_ENGINEPARAM6FLAG, bValue ? 1 : 0);
    }

    public final boolean isENGINEPARAM7FLAGNull() {
        return this.IsParamNull(TAG_ENGINEPARAM7FLAG);
    }

    public final boolean getENGINEPARAM7FLAG() {
        return this.GetParamIntValue(TAG_ENGINEPARAM7FLAG, 0) == 1;
    }

    public final void setENGINEPARAM7FLAG(boolean bValue) {
        this.SetParamValue(TAG_ENGINEPARAM7FLAG, bValue ? 1 : 0);
    }

    public final boolean isENGINEPARAM8FLAGNull() {
        return this.IsParamNull(TAG_ENGINEPARAM8FLAG);
    }

    public final boolean getENGINEPARAM8FLAG() {
        return this.GetParamIntValue(TAG_ENGINEPARAM8FLAG, 0) == 1;
    }

    public final void setENGINEPARAM8FLAG(boolean bValue) {
        this.SetParamValue(TAG_ENGINEPARAM8FLAG, bValue ? 1 : 0);
    }

    public final boolean isENGINEPARAM9FLAGNull() {
        return this.IsParamNull(TAG_ENGINEPARAM9FLAG);
    }

    public final boolean getENGINEPARAM9FLAG() {
        return this.GetParamIntValue(TAG_ENGINEPARAM9FLAG, 0) == 1;
    }

    public final void setENGINEPARAM9FLAG(boolean bValue) {
        this.SetParamValue(TAG_ENGINEPARAM9FLAG, bValue ? 1 : 0);
    }

    public final boolean isENGINEPARAM10FLAGNull() {
        return this.IsParamNull(TAG_ENGINEPARAM10FLAG);
    }

    public final boolean getENGINEPARAM10FLAG() {
        return this.GetParamIntValue(TAG_ENGINEPARAM10FLAG, 0) == 1;
    }

    public final void setENGINEPARAM10FLAG(boolean bValue) {
        this.SetParamValue(TAG_ENGINEPARAM10FLAG, bValue ? 1 : 0);
    }

    public final boolean isENGINEPARAM10LABELNull() {
        return this.IsParamNull(TAG_ENGINEPARAM10LABEL);
    }

    public final String getENGINEPARAM10LABEL() {
        return this.GetParamStringValue(TAG_ENGINEPARAM10LABEL, "");
    }

    public final void setENGINEPARAM10LABEL(String strValue) {
        this.SetParamValue(TAG_ENGINEPARAM10LABEL, strValue);
    }

    public final boolean isENGINEPARAM9LABELNull() {
        return this.IsParamNull(TAG_ENGINEPARAM9LABEL);
    }

    public final String getENGINEPARAM9LABEL() {
        return this.GetParamStringValue(TAG_ENGINEPARAM9LABEL, "");
    }

    public final void setENGINEPARAM9LABEL(String strValue) {
        this.SetParamValue(TAG_ENGINEPARAM9LABEL, strValue);
    }

    public final boolean isENGINEPARAM8LABELNull() {
        return this.IsParamNull(TAG_ENGINEPARAM8LABEL);
    }

    public final String getENGINEPARAM8LABEL() {
        return this.GetParamStringValue(TAG_ENGINEPARAM8LABEL, "");
    }

    public final void setENGINEPARAM8LABEL(String strValue) {
        this.SetParamValue(TAG_ENGINEPARAM8LABEL, strValue);
    }

    public final boolean isENGINEPARAM7LABELNull() {
        return this.IsParamNull(TAG_ENGINEPARAM7LABEL);
    }

    public final String getENGINEPARAM7LABEL() {
        return this.GetParamStringValue(TAG_ENGINEPARAM7LABEL, "");
    }

    public final void setENGINEPARAM7LABEL(String strValue) {
        this.SetParamValue(TAG_ENGINEPARAM7LABEL, strValue);
    }

    public final boolean isENGINEPARAM6LABELNull() {
        return this.IsParamNull(TAG_ENGINEPARAM6LABEL);
    }

    public final String getENGINEPARAM6LABEL() {
        return this.GetParamStringValue(TAG_ENGINEPARAM6LABEL, "");
    }

    public final void setENGINEPARAM6LABEL(String strValue) {
        this.SetParamValue(TAG_ENGINEPARAM6LABEL, strValue);
    }

    public final boolean isENGINEPARAM5LABELNull() {
        return this.IsParamNull(TAG_ENGINEPARAM5LABEL);
    }

    public final String getENGINEPARAM5LABEL() {
        return this.GetParamStringValue(TAG_ENGINEPARAM5LABEL, "");
    }

    public final void setENGINEPARAM5LABEL(String strValue) {
        this.SetParamValue(TAG_ENGINEPARAM5LABEL, strValue);
    }

    public final boolean isENGINEPARAM4LABELNull() {
        return this.IsParamNull(TAG_ENGINEPARAM4LABEL);
    }

    public final String getENGINEPARAM4LABEL() {
        return this.GetParamStringValue(TAG_ENGINEPARAM4LABEL, "");
    }

    public final void setENGINEPARAM4LABEL(String strValue) {
        this.SetParamValue(TAG_ENGINEPARAM4LABEL, strValue);
    }

    public final boolean isENGINEPARAM3LABELNull() {
        return this.IsParamNull(TAG_ENGINEPARAM3LABEL);
    }

    public final String getENGINEPARAM3LABEL() {
        return this.GetParamStringValue(TAG_ENGINEPARAM3LABEL, "");
    }

    public final void setENGINEPARAM3LABEL(String strValue) {
        this.SetParamValue(TAG_ENGINEPARAM3LABEL, strValue);
    }

    public final boolean isENGINEPARAM2LABELNull() {
        return this.IsParamNull(TAG_ENGINEPARAM2LABEL);
    }

    public final String getENGINEPARAM2LABEL() {
        return this.GetParamStringValue(TAG_ENGINEPARAM2LABEL, "");
    }

    public final void setENGINEPARAM2LABEL(String strValue) {
        this.SetParamValue(TAG_ENGINEPARAM2LABEL, strValue);
    }

    public final boolean isENGINEPARAMLABELNull() {
        return this.IsParamNull(TAG_ENGINEPARAMLABEL);
    }

    public final String getENGINEPARAMLABEL() {
        return this.GetParamStringValue(TAG_ENGINEPARAMLABEL, "");
    }

    public final void setENGINEPARAMLABEL(String strValue) {
        this.SetParamValue(TAG_ENGINEPARAMLABEL, strValue);
    }

    public final boolean isPSSYSPFPLUGINIDNull() {
        return this.IsParamNull(TAG_PSSYSPFPLUGINID);
    }

    public final String getPSSYSPFPLUGINID() {
        return this.GetParamStringValue(TAG_PSSYSPFPLUGINID, "");
    }

    public final void setPSSYSPFPLUGINID(String strValue) {
        this.SetParamValue(TAG_PSSYSPFPLUGINID, strValue);
    }

    public final boolean isPSSYSPFPLUGINNAMENull() {
        return this.IsParamNull(TAG_PSSYSPFPLUGINNAME);
    }

    public final String getPSSYSPFPLUGINNAME() {
        return this.GetParamStringValue(TAG_PSSYSPFPLUGINNAME, "");
    }

    public final void setPSSYSPFPLUGINNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSPFPLUGINNAME, strValue);
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

    public final boolean isUSERTAG3Null() {
        return this.IsParamNull(TAG_USERTAG3);
    }

    public final String getUSERTAG3() {
        return this.GetParamStringValue(TAG_USERTAG3, "");
    }

    public final void setUSERTAG3(String strValue) {
        this.SetParamValue(TAG_USERTAG3, strValue);
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

    public final boolean isUSERCATNull() {
        return this.IsParamNull(TAG_USERCAT);
    }

    public final String getUSERCAT() {
        return this.GetParamStringValue(TAG_USERCAT, "");
    }

    public final void setUSERCAT(String strValue) {
        this.SetParamValue(TAG_USERCAT, strValue);
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

