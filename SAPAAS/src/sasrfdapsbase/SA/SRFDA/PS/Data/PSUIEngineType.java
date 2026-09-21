/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSUIEngineType
extends BaseDataEntity {
    public static final String ENGINECAT_VIEW = "VIEW";
    public static final String ENGINECAT_UXVIEW = "UXVIEW";
    public static final String TAG_PSUIENGINETYPEID = "PSUIENGINETYPEID";
    public static final String TAG_PSUIENGINETYPENAME = "PSUIENGINETYPENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_ENGINEOBJ = "ENGINEOBJ";
    public static final String TAG_TYPEOBJ = "TYPEOBJ";
    public static final String TAG_UTILPARAMS = "UTILPARAMS";
    public static final String TAG_PANELENGINEOBJ = "PANELENGINEOBJ";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_ENGINECAT = "ENGINECAT";
    public static final String TAG_TYPECODE = "TYPECODE";
    public static final String TAG_UICTRLFLAG = "UICTRLFLAG";
    public static final String TAG_NO2UICTRLFLAG = "NO2UICTRLFLAG";
    public static final String TAG_NO3UICTRLFLAG = "NO3UICTRLFLAG";
    public static final String TAG_NO4UICTRLFLAG = "NO4UICTRLFLAG";
    public static final String TAG_UILOGICFLAG = "UILOGICFLAG";
    public static final String TAG_NO2UILOGICFLAG = "NO2UILOGICFLAG";
    public static final String TAG_NO3UILOGICFLAG = "NO3UILOGICFLAG";
    public static final String TAG_NO4UILOGICFLAG = "NO4UILOGICFLAG";
    public static final String TAG_ENGINEPARAM10FLAG = "ENGINEPARAM10FLAG";
    public static final String TAG_ENGINEPARAM9FLAG = "ENGINEPARAM9FLAG";
    public static final String TAG_ENGINEPARAM8FLAG = "ENGINEPARAM8FLAG";
    public static final String TAG_ENGINEPARAM7FLAG = "ENGINEPARAM7FLAG";
    public static final String TAG_ENGINEPARAM6FLAG = "ENGINEPARAM6FLAG";
    public static final String TAG_ENGINEPARAM5FLAG = "ENGINEPARAM5FLAG";
    public static final String TAG_ENGINEPARAM4FLAG = "ENGINEPARAM4FLAG";
    public static final String TAG_ENGINEPARAM3FLAG = "ENGINEPARAM3FLAG";
    public static final String TAG_ENGINEPARAM2FLAG = "ENGINEPARAM2FLAG";
    public static final String TAG_ENGINEPARAMFLAG = "ENGINEPARAMFLAG";
    public static final String TAG_UICTRLLABEL = "UICTRLLABEL";
    public static final String TAG_UILOGICLABEL = "UILOGICLABEL";
    public static final String TAG_ENGINEPARAM10LABEL = "ENGINEPARAM10LABEL";
    public static final String TAG_ENGINEPARAM2LABEL = "ENGINEPARAM2LABEL";
    public static final String TAG_ENGINEPARAM3LABEL = "ENGINEPARAM3LABEL";
    public static final String TAG_ENGINEPARAM4LABEL = "ENGINEPARAM4LABEL";
    public static final String TAG_ENGINEPARAM5LABEL = "ENGINEPARAM5LABEL";
    public static final String TAG_ENGINEPARAM6LABEL = "ENGINEPARAM6LABEL";
    public static final String TAG_ENGINEPARAM7LABEL = "ENGINEPARAM7LABEL";
    public static final String TAG_ENGINEPARAM8LABEL = "ENGINEPARAM8LABEL";
    public static final String TAG_NO2UICTRLLABEL = "NO2UICTRLLABEL";
    public static final String TAG_NO3UICTRLLABEL = "NO3UICTRLLABEL";
    public static final String TAG_NO4UICTRLLABEL = "NO4UICTRLLABEL";
    public static final String TAG_NO2UILOGICLABEL = "NO2UILOGICLABEL";
    public static final String TAG_NO3UILOGICLABEL = "NO3UILOGICLABEL";
    public static final String TAG_NO4UILOGICLABEL = "NO4UILOGICLABEL";
    public static final String TAG_ENGINEPARAM9LABEL = "ENGINEPARAM9LABEL";
    public static final String TAG_ENGINEPARAMLABEL = "ENGINEPARAMLABEL";

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

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
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

    public final boolean isENGINEOBJNull() {
        return this.IsParamNull(TAG_ENGINEOBJ);
    }

    public final String getENGINEOBJ() {
        return this.GetParamStringValue(TAG_ENGINEOBJ, "");
    }

    public final void setENGINEOBJ(String strValue) {
        this.SetParamValue(TAG_ENGINEOBJ, strValue);
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

    public final boolean isUTILPARAMSNull() {
        return this.IsParamNull(TAG_UTILPARAMS);
    }

    public final String getUTILPARAMS() {
        return this.GetParamStringValue(TAG_UTILPARAMS, "");
    }

    public final void setUTILPARAMS(String strValue) {
        this.SetParamValue(TAG_UTILPARAMS, strValue);
    }

    public final boolean isPANELENGINEOBJNull() {
        return this.IsParamNull(TAG_PANELENGINEOBJ);
    }

    public final String getPANELENGINEOBJ() {
        return this.GetParamStringValue(TAG_PANELENGINEOBJ, "");
    }

    public final void setPANELENGINEOBJ(String strValue) {
        this.SetParamValue(TAG_PANELENGINEOBJ, strValue);
    }

    public final boolean isLOGICNAMENull() {
        return this.IsParamNull(TAG_LOGICNAME);
    }

    public final String getLOGICNAME() {
        return this.GetParamStringValue(TAG_LOGICNAME, "");
    }

    public final void setLOGICNAME(String strValue) {
        this.SetParamValue(TAG_LOGICNAME, strValue);
    }

    public final boolean isENGINECATNull() {
        return this.IsParamNull(TAG_ENGINECAT);
    }

    public final String getENGINECAT() {
        return this.GetParamStringValue(TAG_ENGINECAT, "");
    }

    public final void setENGINECAT(String strValue) {
        this.SetParamValue(TAG_ENGINECAT, strValue);
    }

    public final boolean isTYPECODENull() {
        return this.IsParamNull(TAG_TYPECODE);
    }

    public final String getTYPECODE() {
        return this.GetParamStringValue(TAG_TYPECODE, "");
    }

    public final void setTYPECODE(String strValue) {
        this.SetParamValue(TAG_TYPECODE, strValue);
    }

    public final boolean isUICTRLFLAGNull() {
        return this.IsParamNull(TAG_UICTRLFLAG);
    }

    public final int getUICTRLFLAG() {
        return this.GetParamIntValue(TAG_UICTRLFLAG, 0);
    }

    public final void setUICTRLFLAG(int nValue) {
        this.SetParamValue(TAG_UICTRLFLAG, nValue);
    }

    public final boolean isNO2UICTRLFLAGNull() {
        return this.IsParamNull(TAG_NO2UICTRLFLAG);
    }

    public final int getNO2UICTRLFLAG() {
        return this.GetParamIntValue(TAG_NO2UICTRLFLAG, 0);
    }

    public final void setNO2UICTRLFLAG(int nValue) {
        this.SetParamValue(TAG_NO2UICTRLFLAG, nValue);
    }

    public final boolean isNO3UICTRLFLAGNull() {
        return this.IsParamNull(TAG_NO3UICTRLFLAG);
    }

    public final int getNO3UICTRLFLAG() {
        return this.GetParamIntValue(TAG_NO3UICTRLFLAG, 0);
    }

    public final void setNO3UICTRLFLAG(int nValue) {
        this.SetParamValue(TAG_NO3UICTRLFLAG, nValue);
    }

    public final boolean isNO4UICTRLFLAGNull() {
        return this.IsParamNull(TAG_NO4UICTRLFLAG);
    }

    public final int getNO4UICTRLFLAG() {
        return this.GetParamIntValue(TAG_NO4UICTRLFLAG, 0);
    }

    public final void setNO4UICTRLFLAG(int nValue) {
        this.SetParamValue(TAG_NO4UICTRLFLAG, nValue);
    }

    public final boolean isUILOGICFLAGNull() {
        return this.IsParamNull(TAG_UILOGICFLAG);
    }

    public final int getUILOGICFLAG() {
        return this.GetParamIntValue(TAG_UILOGICFLAG, 0);
    }

    public final void setUILOGICFLAG(int nValue) {
        this.SetParamValue(TAG_UILOGICFLAG, nValue);
    }

    public final boolean isNO2UILOGICFLAGNull() {
        return this.IsParamNull(TAG_NO2UILOGICFLAG);
    }

    public final int getNO2UILOGICFLAG() {
        return this.GetParamIntValue(TAG_NO2UILOGICFLAG, 0);
    }

    public final void setNO2UILOGICFLAG(int nValue) {
        this.SetParamValue(TAG_NO2UILOGICFLAG, nValue);
    }

    public final boolean isNO3UILOGICFLAGNull() {
        return this.IsParamNull(TAG_NO3UILOGICFLAG);
    }

    public final int getNO3UILOGICFLAG() {
        return this.GetParamIntValue(TAG_NO3UILOGICFLAG, 0);
    }

    public final void setNO3UILOGICFLAG(int nValue) {
        this.SetParamValue(TAG_NO3UILOGICFLAG, nValue);
    }

    public final boolean isNO4UILOGICFLAGNull() {
        return this.IsParamNull(TAG_NO4UILOGICFLAG);
    }

    public final int getNO4UILOGICFLAG() {
        return this.GetParamIntValue(TAG_NO4UILOGICFLAG, 0);
    }

    public final void setNO4UILOGICFLAG(int nValue) {
        this.SetParamValue(TAG_NO4UILOGICFLAG, nValue);
    }

    public final boolean isENGINEPARAM10FLAGNull() {
        return this.IsParamNull(TAG_ENGINEPARAM10FLAG);
    }

    public final int getENGINEPARAM10FLAG() {
        return this.GetParamIntValue(TAG_ENGINEPARAM10FLAG, 0);
    }

    public final void setENGINEPARAM10FLAG(int nValue) {
        this.SetParamValue(TAG_ENGINEPARAM10FLAG, nValue);
    }

    public final boolean isENGINEPARAM9FLAGNull() {
        return this.IsParamNull(TAG_ENGINEPARAM9FLAG);
    }

    public final int getENGINEPARAM9FLAG() {
        return this.GetParamIntValue(TAG_ENGINEPARAM9FLAG, 0);
    }

    public final void setENGINEPARAM9FLAG(int nValue) {
        this.SetParamValue(TAG_ENGINEPARAM9FLAG, nValue);
    }

    public final boolean isENGINEPARAM8FLAGNull() {
        return this.IsParamNull(TAG_ENGINEPARAM8FLAG);
    }

    public final int getENGINEPARAM8FLAG() {
        return this.GetParamIntValue(TAG_ENGINEPARAM8FLAG, 0);
    }

    public final void setENGINEPARAM8FLAG(int nValue) {
        this.SetParamValue(TAG_ENGINEPARAM8FLAG, nValue);
    }

    public final boolean isENGINEPARAM7FLAGNull() {
        return this.IsParamNull(TAG_ENGINEPARAM7FLAG);
    }

    public final int getENGINEPARAM7FLAG() {
        return this.GetParamIntValue(TAG_ENGINEPARAM7FLAG, 0);
    }

    public final void setENGINEPARAM7FLAG(int nValue) {
        this.SetParamValue(TAG_ENGINEPARAM7FLAG, nValue);
    }

    public final boolean isENGINEPARAM6FLAGNull() {
        return this.IsParamNull(TAG_ENGINEPARAM6FLAG);
    }

    public final int getENGINEPARAM6FLAG() {
        return this.GetParamIntValue(TAG_ENGINEPARAM6FLAG, 0);
    }

    public final void setENGINEPARAM6FLAG(int nValue) {
        this.SetParamValue(TAG_ENGINEPARAM6FLAG, nValue);
    }

    public final boolean isENGINEPARAM5FLAGNull() {
        return this.IsParamNull(TAG_ENGINEPARAM5FLAG);
    }

    public final int getENGINEPARAM5FLAG() {
        return this.GetParamIntValue(TAG_ENGINEPARAM5FLAG, 0);
    }

    public final void setENGINEPARAM5FLAG(int nValue) {
        this.SetParamValue(TAG_ENGINEPARAM5FLAG, nValue);
    }

    public final boolean isENGINEPARAM4FLAGNull() {
        return this.IsParamNull(TAG_ENGINEPARAM4FLAG);
    }

    public final int getENGINEPARAM4FLAG() {
        return this.GetParamIntValue(TAG_ENGINEPARAM4FLAG, 0);
    }

    public final void setENGINEPARAM4FLAG(int nValue) {
        this.SetParamValue(TAG_ENGINEPARAM4FLAG, nValue);
    }

    public final boolean isENGINEPARAM3FLAGNull() {
        return this.IsParamNull(TAG_ENGINEPARAM3FLAG);
    }

    public final int getENGINEPARAM3FLAG() {
        return this.GetParamIntValue(TAG_ENGINEPARAM3FLAG, 0);
    }

    public final void setENGINEPARAM3FLAG(int nValue) {
        this.SetParamValue(TAG_ENGINEPARAM3FLAG, nValue);
    }

    public final boolean isENGINEPARAM2FLAGNull() {
        return this.IsParamNull(TAG_ENGINEPARAM2FLAG);
    }

    public final int getENGINEPARAM2FLAG() {
        return this.GetParamIntValue(TAG_ENGINEPARAM2FLAG, 0);
    }

    public final void setENGINEPARAM2FLAG(int nValue) {
        this.SetParamValue(TAG_ENGINEPARAM2FLAG, nValue);
    }

    public final boolean isENGINEPARAMFLAGNull() {
        return this.IsParamNull(TAG_ENGINEPARAMFLAG);
    }

    public final int getENGINEPARAMFLAG() {
        return this.GetParamIntValue(TAG_ENGINEPARAMFLAG, 0);
    }

    public final void setENGINEPARAMFLAG(int nValue) {
        this.SetParamValue(TAG_ENGINEPARAMFLAG, nValue);
    }

    public final boolean isUICTRLLABELNull() {
        return this.IsParamNull(TAG_UICTRLLABEL);
    }

    public final String getUICTRLLABEL() {
        return this.GetParamStringValue(TAG_UICTRLLABEL, "");
    }

    public final void setUICTRLLABEL(String strValue) {
        this.SetParamValue(TAG_UICTRLLABEL, strValue);
    }

    public final boolean isUILOGICLABELNull() {
        return this.IsParamNull(TAG_UILOGICLABEL);
    }

    public final String getUILOGICLABEL() {
        return this.GetParamStringValue(TAG_UILOGICLABEL, "");
    }

    public final void setUILOGICLABEL(String strValue) {
        this.SetParamValue(TAG_UILOGICLABEL, strValue);
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

    public final boolean isENGINEPARAM2LABELNull() {
        return this.IsParamNull(TAG_ENGINEPARAM2LABEL);
    }

    public final String getENGINEPARAM2LABEL() {
        return this.GetParamStringValue(TAG_ENGINEPARAM2LABEL, "");
    }

    public final void setENGINEPARAM2LABEL(String strValue) {
        this.SetParamValue(TAG_ENGINEPARAM2LABEL, strValue);
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

    public final boolean isENGINEPARAM4LABELNull() {
        return this.IsParamNull(TAG_ENGINEPARAM4LABEL);
    }

    public final String getENGINEPARAM4LABEL() {
        return this.GetParamStringValue(TAG_ENGINEPARAM4LABEL, "");
    }

    public final void setENGINEPARAM4LABEL(String strValue) {
        this.SetParamValue(TAG_ENGINEPARAM4LABEL, strValue);
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

    public final boolean isENGINEPARAM6LABELNull() {
        return this.IsParamNull(TAG_ENGINEPARAM6LABEL);
    }

    public final String getENGINEPARAM6LABEL() {
        return this.GetParamStringValue(TAG_ENGINEPARAM6LABEL, "");
    }

    public final void setENGINEPARAM6LABEL(String strValue) {
        this.SetParamValue(TAG_ENGINEPARAM6LABEL, strValue);
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

    public final boolean isENGINEPARAM8LABELNull() {
        return this.IsParamNull(TAG_ENGINEPARAM8LABEL);
    }

    public final String getENGINEPARAM8LABEL() {
        return this.GetParamStringValue(TAG_ENGINEPARAM8LABEL, "");
    }

    public final void setENGINEPARAM8LABEL(String strValue) {
        this.SetParamValue(TAG_ENGINEPARAM8LABEL, strValue);
    }

    public final boolean isNO2UICTRLLABELNull() {
        return this.IsParamNull(TAG_NO2UICTRLLABEL);
    }

    public final String getNO2UICTRLLABEL() {
        return this.GetParamStringValue(TAG_NO2UICTRLLABEL, "");
    }

    public final void setNO2UICTRLLABEL(String strValue) {
        this.SetParamValue(TAG_NO2UICTRLLABEL, strValue);
    }

    public final boolean isNO3UICTRLLABELNull() {
        return this.IsParamNull(TAG_NO3UICTRLLABEL);
    }

    public final String getNO3UICTRLLABEL() {
        return this.GetParamStringValue(TAG_NO3UICTRLLABEL, "");
    }

    public final void setNO3UICTRLLABEL(String strValue) {
        this.SetParamValue(TAG_NO3UICTRLLABEL, strValue);
    }

    public final boolean isNO4UICTRLLABELNull() {
        return this.IsParamNull(TAG_NO4UICTRLLABEL);
    }

    public final String getNO4UICTRLLABEL() {
        return this.GetParamStringValue(TAG_NO4UICTRLLABEL, "");
    }

    public final void setNO4UICTRLLABEL(String strValue) {
        this.SetParamValue(TAG_NO4UICTRLLABEL, strValue);
    }

    public final boolean isNO2UILOGICLABELNull() {
        return this.IsParamNull(TAG_NO2UILOGICLABEL);
    }

    public final String getNO2UILOGICLABEL() {
        return this.GetParamStringValue(TAG_NO2UILOGICLABEL, "");
    }

    public final void setNO2UILOGICLABEL(String strValue) {
        this.SetParamValue(TAG_NO2UILOGICLABEL, strValue);
    }

    public final boolean isNO3UILOGICLABELNull() {
        return this.IsParamNull(TAG_NO3UILOGICLABEL);
    }

    public final String getNO3UILOGICLABEL() {
        return this.GetParamStringValue(TAG_NO3UILOGICLABEL, "");
    }

    public final void setNO3UILOGICLABEL(String strValue) {
        this.SetParamValue(TAG_NO3UILOGICLABEL, strValue);
    }

    public final boolean isNO4UILOGICLABELNull() {
        return this.IsParamNull(TAG_NO4UILOGICLABEL);
    }

    public final String getNO4UILOGICLABEL() {
        return this.GetParamStringValue(TAG_NO4UILOGICLABEL, "");
    }

    public final void setNO4UILOGICLABEL(String strValue) {
        this.SetParamValue(TAG_NO4UILOGICLABEL, strValue);
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

    public final boolean isENGINEPARAMLABELNull() {
        return this.IsParamNull(TAG_ENGINEPARAMLABEL);
    }

    public final String getENGINEPARAMLABEL() {
        return this.GetParamStringValue(TAG_ENGINEPARAMLABEL, "");
    }

    public final void setENGINEPARAMLABEL(String strValue) {
        this.SetParamValue(TAG_ENGINEPARAMLABEL, strValue);
    }
}

