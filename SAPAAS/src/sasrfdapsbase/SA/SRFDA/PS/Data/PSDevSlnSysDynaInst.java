/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFDA.PS.Data.PSDevSlnSysDynaInstRef;
import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PSDevSlnSysDynaInst
extends BaseDataEntity {
    public static final String INSTTYPE_DEFAULT = "DEFAULT";
    public static final String INSTTYPE_MODULE = "MODULE";
    public static final String TAG_PSDEVSLNSYSDYNAINSTID = "PSDEVSLNSYSDYNAINSTID";
    public static final String TAG_PSDEVSLNSYSDYNAINSTNAME = "PSDEVSLNSYSDYNAINSTNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String TAG_PSDEVSLNSYSNAME = "PSDEVSLNSYSNAME";
    public static final String TAG_PPSDEVSLNSYSDYNAINSTID = "PPSDEVSLNSYSDYNAINSTID";
    public static final String TAG_PPSDEVSLNSYSDYNAINSTNAME = "PPSDEVSLNSYSDYNAINSTNAME";
    public static final String TAG_MODELPSDEVCENTERSVNID = "MODELPSDEVCENTERSVNID";
    public static final String TAG_MODELPSDEVCENTERSVNNAME = "MODELPSDEVCENTERSVNNAME";
    public static final String TAG_PSDEVSLNSYSDEPINSTID = "PSDEVSLNSYSDEPINSTID";
    public static final String TAG_PSDEVSLNSYSDEPINSTNAME = "PSDEVSLNSYSDEPINSTNAME";
    public static final String TAG_CFGPSDEVCENTERSVNID = "CFGPSDEVCENTERSVNID";
    public static final String TAG_CFGPSDEVCENTERSVNNAME = "CFGPSDEVCENTERSVNNAME";
    public static final String TAG_INSTTAG4 = "INSTTAG4";
    public static final String TAG_INSTTAG3 = "INSTTAG3";
    public static final String TAG_INSTTAG2 = "INSTTAG2";
    public static final String TAG_INSTTAG = "INSTTAG";
    public static final String TAG_INSTVER = "INSTVER";
    public static final String TAG_PSDEVSLNID = "PSDEVSLNID";
    public static final String TAG_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String TAG_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String TAG_SYSMODELPATH = "SYSMODELPATH";
    public static final String TAG_INSTMODELPATH = "INSTMODELPATH";
    public static final String TAG_INSTTYPE = "INSTTYPE";
    public static final String TAG_INSTSTATE = "INSTSTATE";
    public static final String TAG_PSDEVSLNNAME = "PSDEVSLNNAME";
    public static final String TAG_PINSTMODELPATH = "PINSTMODELPATH";
    public static final String TAG_INSTTAG5 = "INSTTAG5";
    public static final String TAG_INSTTAG6 = "INSTTAG6";
    public static final String TAG_INSTTAG7 = "INSTTAG7";
    public static final String TAG_INSTTAG8 = "INSTTAG8";
    public static final String TAG_EXPRIEDTIME = "EXPRIEDTIME";
    public static final String TAG_COLOR = "COLOR";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_ROOTINSTMODELPATH = "ROOTINSTMODELPATH";
    private List<PSDevSlnSysDynaInstRef> psDevSlnSysDynaInstRefList = null;
    private List<PSDevSlnSysDynaInstRef> ppsDevSlnSysDynaInstRefList = null;

    public final boolean isPSDEVSLNSYSDYNAINSTIDNull() {
        return this.IsParamNull(TAG_PSDEVSLNSYSDYNAINSTID);
    }

    public final String getPSDEVSLNSYSDYNAINSTID() {
        return this.GetParamStringValue(TAG_PSDEVSLNSYSDYNAINSTID, "");
    }

    public final void setPSDEVSLNSYSDYNAINSTID(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNSYSDYNAINSTID, strValue);
    }

    public final boolean isPSDEVSLNSYSDYNAINSTNAMENull() {
        return this.IsParamNull(TAG_PSDEVSLNSYSDYNAINSTNAME);
    }

    public final String getPSDEVSLNSYSDYNAINSTNAME() {
        return this.GetParamStringValue(TAG_PSDEVSLNSYSDYNAINSTNAME, "");
    }

    public final void setPSDEVSLNSYSDYNAINSTNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNSYSDYNAINSTNAME, strValue);
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

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
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

    public final boolean isUSERTAGNull() {
        return this.IsParamNull(TAG_USERTAG);
    }

    public final String getUSERTAG() {
        return this.GetParamStringValue(TAG_USERTAG, "");
    }

    public final void setUSERTAG(String strValue) {
        this.SetParamValue(TAG_USERTAG, strValue);
    }

    public final boolean isPSDEVSLNSYSIDNull() {
        return this.IsParamNull(TAG_PSDEVSLNSYSID);
    }

    public final String getPSDEVSLNSYSID() {
        return this.GetParamStringValue(TAG_PSDEVSLNSYSID, "");
    }

    public final void setPSDEVSLNSYSID(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNSYSID, strValue);
    }

    public final boolean isPSDEVSLNSYSNAMENull() {
        return this.IsParamNull(TAG_PSDEVSLNSYSNAME);
    }

    public final String getPSDEVSLNSYSNAME() {
        return this.GetParamStringValue(TAG_PSDEVSLNSYSNAME, "");
    }

    public final void setPSDEVSLNSYSNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNSYSNAME, strValue);
    }

    public final boolean isPPSDEVSLNSYSDYNAINSTIDNull() {
        return this.IsParamNull(TAG_PPSDEVSLNSYSDYNAINSTID);
    }

    public final String getPPSDEVSLNSYSDYNAINSTID() {
        return this.GetParamStringValue(TAG_PPSDEVSLNSYSDYNAINSTID, "");
    }

    public final void setPPSDEVSLNSYSDYNAINSTID(String strValue) {
        this.SetParamValue(TAG_PPSDEVSLNSYSDYNAINSTID, strValue);
    }

    public final boolean isPPSDEVSLNSYSDYNAINSTNAMENull() {
        return this.IsParamNull(TAG_PPSDEVSLNSYSDYNAINSTNAME);
    }

    public final String getPPSDEVSLNSYSDYNAINSTNAME() {
        return this.GetParamStringValue(TAG_PPSDEVSLNSYSDYNAINSTNAME, "");
    }

    public final void setPPSDEVSLNSYSDYNAINSTNAME(String strValue) {
        this.SetParamValue(TAG_PPSDEVSLNSYSDYNAINSTNAME, strValue);
    }

    public final boolean isMODELPSDEVCENTERSVNIDNull() {
        return this.IsParamNull(TAG_MODELPSDEVCENTERSVNID);
    }

    public final String getMODELPSDEVCENTERSVNID() {
        return this.GetParamStringValue(TAG_MODELPSDEVCENTERSVNID, "");
    }

    public final void setMODELPSDEVCENTERSVNID(String strValue) {
        this.SetParamValue(TAG_MODELPSDEVCENTERSVNID, strValue);
    }

    public final boolean isMODELPSDEVCENTERSVNNAMENull() {
        return this.IsParamNull(TAG_MODELPSDEVCENTERSVNNAME);
    }

    public final String getMODELPSDEVCENTERSVNNAME() {
        return this.GetParamStringValue(TAG_MODELPSDEVCENTERSVNNAME, "");
    }

    public final void setMODELPSDEVCENTERSVNNAME(String strValue) {
        this.SetParamValue(TAG_MODELPSDEVCENTERSVNNAME, strValue);
    }

    public final boolean isPSDEVSLNSYSDEPINSTIDNull() {
        return this.IsParamNull(TAG_PSDEVSLNSYSDEPINSTID);
    }

    public final String getPSDEVSLNSYSDEPINSTID() {
        return this.GetParamStringValue(TAG_PSDEVSLNSYSDEPINSTID, "");
    }

    public final void setPSDEVSLNSYSDEPINSTID(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNSYSDEPINSTID, strValue);
    }

    public final boolean isPSDEVSLNSYSDEPINSTNAMENull() {
        return this.IsParamNull(TAG_PSDEVSLNSYSDEPINSTNAME);
    }

    public final String getPSDEVSLNSYSDEPINSTNAME() {
        return this.GetParamStringValue(TAG_PSDEVSLNSYSDEPINSTNAME, "");
    }

    public final void setPSDEVSLNSYSDEPINSTNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNSYSDEPINSTNAME, strValue);
    }

    public final boolean isCFGPSDEVCENTERSVNIDNull() {
        return this.IsParamNull(TAG_CFGPSDEVCENTERSVNID);
    }

    public final String getCFGPSDEVCENTERSVNID() {
        return this.GetParamStringValue(TAG_CFGPSDEVCENTERSVNID, "");
    }

    public final void setCFGPSDEVCENTERSVNID(String strValue) {
        this.SetParamValue(TAG_CFGPSDEVCENTERSVNID, strValue);
    }

    public final boolean isCFGPSDEVCENTERSVNNAMENull() {
        return this.IsParamNull(TAG_CFGPSDEVCENTERSVNNAME);
    }

    public final String getCFGPSDEVCENTERSVNNAME() {
        return this.GetParamStringValue(TAG_CFGPSDEVCENTERSVNNAME, "");
    }

    public final void setCFGPSDEVCENTERSVNNAME(String strValue) {
        this.SetParamValue(TAG_CFGPSDEVCENTERSVNNAME, strValue);
    }

    public final boolean isINSTTAG4Null() {
        return this.IsParamNull(TAG_INSTTAG4);
    }

    public final String getINSTTAG4() {
        return this.GetParamStringValue(TAG_INSTTAG4, "");
    }

    public final void setINSTTAG4(String strValue) {
        this.SetParamValue(TAG_INSTTAG4, strValue);
    }

    public final boolean isINSTTAG3Null() {
        return this.IsParamNull(TAG_INSTTAG3);
    }

    public final String getINSTTAG3() {
        return this.GetParamStringValue(TAG_INSTTAG3, "");
    }

    public final void setINSTTAG3(String strValue) {
        this.SetParamValue(TAG_INSTTAG3, strValue);
    }

    public final boolean isINSTTAG2Null() {
        return this.IsParamNull(TAG_INSTTAG2);
    }

    public final String getINSTTAG2() {
        return this.GetParamStringValue(TAG_INSTTAG2, "");
    }

    public final void setINSTTAG2(String strValue) {
        this.SetParamValue(TAG_INSTTAG2, strValue);
    }

    public final boolean isINSTTAGNull() {
        return this.IsParamNull(TAG_INSTTAG);
    }

    public final String getINSTTAG() {
        return this.GetParamStringValue(TAG_INSTTAG, "");
    }

    public final void setINSTTAG(String strValue) {
        this.SetParamValue(TAG_INSTTAG, strValue);
    }

    public final boolean isINSTVERNull() {
        return this.IsParamNull(TAG_INSTVER);
    }

    public final int getINSTVER() {
        return this.GetParamIntValue(TAG_INSTVER, 0);
    }

    public final void setINSTVER(int nValue) {
        this.SetParamValue(TAG_INSTVER, nValue);
    }

    public final boolean isSYSMODELPATHNull() {
        return this.IsParamNull(TAG_SYSMODELPATH);
    }

    public final String getSYSMODELPATH() {
        return this.GetParamStringValue(TAG_SYSMODELPATH, "");
    }

    public final void setSYSMODELPATH(String strValue) {
        this.SetParamValue(TAG_SYSMODELPATH, strValue);
    }

    public final boolean isINSTMODELPATHNull() {
        return this.IsParamNull(TAG_INSTMODELPATH);
    }

    public final String getINSTMODELPATH() {
        return this.GetParamStringValue(TAG_INSTMODELPATH, "");
    }

    public final void setINSTMODELPATH(String strValue) {
        this.SetParamValue(TAG_INSTMODELPATH, strValue);
    }

    public final boolean isINSTTYPENull() {
        return this.IsParamNull(TAG_INSTTYPE);
    }

    public final String getINSTTYPE() {
        return this.GetParamStringValue(TAG_INSTTYPE, "");
    }

    public final void setINSTTYPE(String strValue) {
        this.SetParamValue(TAG_INSTTYPE, strValue);
    }

    public final boolean isINSTSTATENull() {
        return this.IsParamNull(TAG_INSTSTATE);
    }

    public final int getINSTSTATE() {
        return this.GetParamIntValue(TAG_INSTSTATE, 0);
    }

    public final void setINSTSTATE(int nValue) {
        this.SetParamValue(TAG_INSTSTATE, nValue);
    }

    public final boolean isPSDEVCENTERIDNull() {
        return this.IsParamNull(TAG_PSDEVCENTERID);
    }

    public final String getPSDEVCENTERID() {
        return this.GetParamStringValue(TAG_PSDEVCENTERID, "");
    }

    public final void setPSDEVCENTERID(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERID, strValue);
    }

    public final boolean isPSDEVCENTERNAMENull() {
        return this.IsParamNull(TAG_PSDEVCENTERNAME);
    }

    public final String getPSDEVCENTERNAME() {
        return this.GetParamStringValue(TAG_PSDEVCENTERNAME, "");
    }

    public final void setPSDEVCENTERNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERNAME, strValue);
    }

    public final boolean isPSDEVSLNIDNull() {
        return this.IsParamNull(TAG_PSDEVSLNID);
    }

    public final String getPSDEVSLNID() {
        return this.GetParamStringValue(TAG_PSDEVSLNID, "");
    }

    public final void setPSDEVSLNID(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNID, strValue);
    }

    public final boolean isPSDEVSLNNAMENull() {
        return this.IsParamNull(TAG_PSDEVSLNNAME);
    }

    public final String getPSDEVSLNNAME() {
        return this.GetParamStringValue(TAG_PSDEVSLNNAME, "");
    }

    public final void setPSDEVSLNNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNNAME, strValue);
    }

    public final boolean isPINSTMODELPATHNull() {
        return this.IsParamNull(TAG_PINSTMODELPATH);
    }

    public final String getPINSTMODELPATH() {
        return this.GetParamStringValue(TAG_PINSTMODELPATH, "");
    }

    public final void setPINSTMODELPATH(String strValue) {
        this.SetParamValue(TAG_PINSTMODELPATH, strValue);
    }

    public final boolean isINSTTAG5Null() {
        return this.IsParamNull(TAG_INSTTAG5);
    }

    public final String getINSTTAG5() {
        return this.GetParamStringValue(TAG_INSTTAG5, "");
    }

    public final void setINSTTAG5(String strValue) {
        this.SetParamValue(TAG_INSTTAG5, strValue);
    }

    public final boolean isINSTTAG6Null() {
        return this.IsParamNull(TAG_INSTTAG6);
    }

    public final String getINSTTAG6() {
        return this.GetParamStringValue(TAG_INSTTAG6, "");
    }

    public final void setINSTTAG6(String strValue) {
        this.SetParamValue(TAG_INSTTAG6, strValue);
    }

    public final boolean isINSTTAG7Null() {
        return this.IsParamNull(TAG_INSTTAG7);
    }

    public final String getINSTTAG7() {
        return this.GetParamStringValue(TAG_INSTTAG7, "");
    }

    public final void setINSTTAG7(String strValue) {
        this.SetParamValue(TAG_INSTTAG7, strValue);
    }

    public final boolean isINSTTAG8Null() {
        return this.IsParamNull(TAG_INSTTAG8);
    }

    public final String getINSTTAG8() {
        return this.GetParamStringValue(TAG_INSTTAG8, "");
    }

    public final void setINSTTAG8(String strValue) {
        this.SetParamValue(TAG_INSTTAG8, strValue);
    }

    public final boolean isEXPRIEDTIMENull() {
        return this.IsParamNull(TAG_EXPRIEDTIME);
    }

    public final Date getEXPRIEDTIME() {
        return this.GetParamDateValue(TAG_EXPRIEDTIME, null);
    }

    public final void setEXPRIEDTIME(Date dtValue) {
        this.SetParamValue(TAG_EXPRIEDTIME, dtValue);
    }

    public final boolean isCOLORNull() {
        return this.IsParamNull(TAG_COLOR);
    }

    public final String getCOLOR() {
        return this.GetParamStringValue(TAG_COLOR, "");
    }

    public final void setCOLOR(String strValue) {
        this.SetParamValue(TAG_COLOR, strValue);
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

    public final boolean isORDERVALUENull() {
        return this.IsParamNull(TAG_ORDERVALUE);
    }

    public final int getORDERVALUE() {
        return this.GetParamIntValue(TAG_ORDERVALUE, 0);
    }

    public final void setORDERVALUE(int nValue) {
        this.SetParamValue(TAG_ORDERVALUE, nValue);
    }

    public final boolean isROOTINSTMODELPATHNull() {
        return this.IsParamNull(TAG_ROOTINSTMODELPATH);
    }

    public final String getROOTINSTMODELPATH() {
        return this.GetParamStringValue(TAG_ROOTINSTMODELPATH, "");
    }

    public final void setROOTINSTMODELPATH(String strValue) {
        this.SetParamValue(TAG_ROOTINSTMODELPATH, strValue);
    }

    public List<PSDevSlnSysDynaInstRef> getPSDevSlnSysDynaInstRefList(boolean bCreateIf) {
        if (this.psDevSlnSysDynaInstRefList == null && bCreateIf) {
            this.psDevSlnSysDynaInstRefList = new ArrayList<PSDevSlnSysDynaInstRef>();
        }
        return this.psDevSlnSysDynaInstRefList;
    }

    public List<PSDevSlnSysDynaInstRef> getPPSDevSlnSysDynaInstRefList(boolean bCreateIf) {
        if (this.ppsDevSlnSysDynaInstRefList == null && bCreateIf) {
            this.ppsDevSlnSysDynaInstRefList = new ArrayList<PSDevSlnSysDynaInstRef>();
        }
        return this.ppsDevSlnSysDynaInstRefList;
    }
}

