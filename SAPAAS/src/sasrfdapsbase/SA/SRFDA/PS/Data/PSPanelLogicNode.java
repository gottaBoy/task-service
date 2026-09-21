/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFDA.PS.Data.PSPanelLogicLink;
import SA.SRFDA.PS.Data.PSPanelLogicNodeParam;
import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.ArrayList;
import java.util.Date;

public class PSPanelLogicNode
extends BaseDataEntity {
    public static final String LOGICNODETYPE_BEGIN = "BEGIN";
    public static final String LOGICNODETYPE_DEACTION = "DEACTION";
    public static final String LOGICNODETYPE_PREPAREPARAM = "PREPAREPARAM";
    public static final String TAG_PSPANELLOGICNODEID = "PSPANELLOGICNODEID";
    public static final String TAG_PSPANELLOGICNODENAME = "PSPANELLOGICNODENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_LOGICNODETYPE = "LOGICNODETYPE";
    public static final String TAG_PARAM9 = "PARAM9";
    public static final String TAG_PARAM8 = "PARAM8";
    public static final String TAG_PARAM7 = "PARAM7";
    public static final String TAG_PARAM3 = "PARAM3";
    public static final String TAG_PARAM2 = "PARAM2";
    public static final String TAG_PARAM6 = "PARAM6";
    public static final String TAG_PARAM5 = "PARAM5";
    public static final String TAG_PARAM4 = "PARAM4";
    public static final String TAG_PARAM14 = "PARAM14";
    public static final String TAG_PARAM13 = "PARAM13";
    public static final String TAG_PARAM12 = "PARAM12";
    public static final String TAG_PARAM11 = "PARAM11";
    public static final String TAG_PARAM10 = "PARAM10";
    public static final String TAG_PARAM1 = "PARAM1";
    public static final String TAG_TOPPOS = "TOPPOS";
    public static final String TAG_LEFTPOS = "LEFTPOS";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PARALLELOUTPUT = "PARALLELOUTPUT";
    public static final String TAG_PSSYSVIEWPANELLOGICID = "PSSYSVIEWPANELLOGICID";
    public static final String TAG_PSSYSVIEWPANELLOGICNAME = "PSSYSVIEWPANELLOGICNAME";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_PSSYSVIEWPANELID = "PSSYSVIEWPANELID";
    public static final String TAG_PSSYSVIEWPANELNAME = "PSSYSVIEWPANELNAME";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSVIEWPANELITEMID = "PSSYSVIEWPANELITEMID";
    public static final String TAG_PSSYSVIEWPANELITEMNAME = "PSSYSVIEWPANELITEMNAME";
    public static final String TAG_PSPANELLOGICPARAMID = "PSPANELLOGICPARAMID";
    public static final String TAG_PSPANELLOGICPARAMNAME = "PSPANELLOGICPARAMNAME";
    private ArrayList<PSPanelLogicLink> childPSPanelLogicLinkList = null;
    private ArrayList<PSPanelLogicNodeParam> childPSPanelLogicNodeParamList = null;

    public final boolean isPSPANELLOGICNODEIDNull() {
        return this.IsParamNull(TAG_PSPANELLOGICNODEID);
    }

    public final String getPSPANELLOGICNODEID() {
        return this.GetParamStringValue(TAG_PSPANELLOGICNODEID, "");
    }

    public final void setPSPANELLOGICNODEID(String strValue) {
        this.SetParamValue(TAG_PSPANELLOGICNODEID, strValue);
    }

    public final boolean isPSPANELLOGICNODENAMENull() {
        return this.IsParamNull(TAG_PSPANELLOGICNODENAME);
    }

    public final String getPSPANELLOGICNODENAME() {
        return this.GetParamStringValue(TAG_PSPANELLOGICNODENAME, "");
    }

    public final void setPSPANELLOGICNODENAME(String strValue) {
        this.SetParamValue(TAG_PSPANELLOGICNODENAME, strValue);
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

    public final boolean isLOGICNODETYPENull() {
        return this.IsParamNull(TAG_LOGICNODETYPE);
    }

    public final String getLOGICNODETYPE() {
        return this.GetParamStringValue(TAG_LOGICNODETYPE, "");
    }

    public final void setLOGICNODETYPE(String strValue) {
        this.SetParamValue(TAG_LOGICNODETYPE, strValue);
    }

    public final boolean isPARAM9Null() {
        return this.IsParamNull(TAG_PARAM9);
    }

    public final boolean getPARAM9() {
        return this.GetParamIntValue(TAG_PARAM9, 0) == 1;
    }

    public final void setPARAM9(boolean bValue) {
        this.SetParamValue(TAG_PARAM9, bValue ? 1 : 0);
    }

    public final boolean isPARAM8Null() {
        return this.IsParamNull(TAG_PARAM8);
    }

    public final int getPARAM8() {
        return this.GetParamIntValue(TAG_PARAM8, 0);
    }

    public final void setPARAM8(int nValue) {
        this.SetParamValue(TAG_PARAM8, nValue);
    }

    public final boolean isPARAM7Null() {
        return this.IsParamNull(TAG_PARAM7);
    }

    public final int getPARAM7() {
        return this.GetParamIntValue(TAG_PARAM7, 0);
    }

    public final void setPARAM7(int nValue) {
        this.SetParamValue(TAG_PARAM7, nValue);
    }

    public final boolean isPARAM3Null() {
        return this.IsParamNull(TAG_PARAM3);
    }

    public final String getPARAM3() {
        return this.GetParamStringValue(TAG_PARAM3, "");
    }

    public final void setPARAM3(String strValue) {
        this.SetParamValue(TAG_PARAM3, strValue);
    }

    public final boolean isPARAM2Null() {
        return this.IsParamNull(TAG_PARAM2);
    }

    public final String getPARAM2() {
        return this.GetParamStringValue(TAG_PARAM2, "");
    }

    public final void setPARAM2(String strValue) {
        this.SetParamValue(TAG_PARAM2, strValue);
    }

    public final boolean isPARAM6Null() {
        return this.IsParamNull(TAG_PARAM6);
    }

    public final String getPARAM6() {
        return this.GetParamStringValue(TAG_PARAM6, "");
    }

    public final void setPARAM6(String strValue) {
        this.SetParamValue(TAG_PARAM6, strValue);
    }

    public final boolean isPARAM5Null() {
        return this.IsParamNull(TAG_PARAM5);
    }

    public final String getPARAM5() {
        return this.GetParamStringValue(TAG_PARAM5, "");
    }

    public final void setPARAM5(String strValue) {
        this.SetParamValue(TAG_PARAM5, strValue);
    }

    public final boolean isPARAM4Null() {
        return this.IsParamNull(TAG_PARAM4);
    }

    public final String getPARAM4() {
        return this.GetParamStringValue(TAG_PARAM4, "");
    }

    public final void setPARAM4(String strValue) {
        this.SetParamValue(TAG_PARAM4, strValue);
    }

    public final boolean isPARAM14Null() {
        return this.IsParamNull(TAG_PARAM14);
    }

    public final String getPARAM14() {
        return this.GetParamStringValue(TAG_PARAM14, "");
    }

    public final void setPARAM14(String strValue) {
        this.SetParamValue(TAG_PARAM14, strValue);
    }

    public final boolean isPARAM13Null() {
        return this.IsParamNull(TAG_PARAM13);
    }

    public final String getPARAM13() {
        return this.GetParamStringValue(TAG_PARAM13, "");
    }

    public final void setPARAM13(String strValue) {
        this.SetParamValue(TAG_PARAM13, strValue);
    }

    public final boolean isPARAM12Null() {
        return this.IsParamNull(TAG_PARAM12);
    }

    public final String getPARAM12() {
        return this.GetParamStringValue(TAG_PARAM12, "");
    }

    public final void setPARAM12(String strValue) {
        this.SetParamValue(TAG_PARAM12, strValue);
    }

    public final boolean isPARAM11Null() {
        return this.IsParamNull(TAG_PARAM11);
    }

    public final String getPARAM11() {
        return this.GetParamStringValue(TAG_PARAM11, "");
    }

    public final void setPARAM11(String strValue) {
        this.SetParamValue(TAG_PARAM11, strValue);
    }

    public final boolean isPARAM10Null() {
        return this.IsParamNull(TAG_PARAM10);
    }

    public final boolean getPARAM10() {
        return this.GetParamIntValue(TAG_PARAM10, 0) == 1;
    }

    public final void setPARAM10(boolean bValue) {
        this.SetParamValue(TAG_PARAM10, bValue ? 1 : 0);
    }

    public final boolean isPARAM1Null() {
        return this.IsParamNull(TAG_PARAM1);
    }

    public final String getPARAM1() {
        return this.GetParamStringValue(TAG_PARAM1, "");
    }

    public final void setPARAM1(String strValue) {
        this.SetParamValue(TAG_PARAM1, strValue);
    }

    public final boolean isTOPPOSNull() {
        return this.IsParamNull(TAG_TOPPOS);
    }

    public final int getTOPPOS() {
        return this.GetParamIntValue(TAG_TOPPOS, 0);
    }

    public final void setTOPPOS(int nValue) {
        this.SetParamValue(TAG_TOPPOS, nValue);
    }

    public final boolean isLEFTPOSNull() {
        return this.IsParamNull(TAG_LEFTPOS);
    }

    public final int getLEFTPOS() {
        return this.GetParamIntValue(TAG_LEFTPOS, 0);
    }

    public final void setLEFTPOS(int nValue) {
        this.SetParamValue(TAG_LEFTPOS, nValue);
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

    public final boolean isPARALLELOUTPUTNull() {
        return this.IsParamNull(TAG_PARALLELOUTPUT);
    }

    public final boolean getPARALLELOUTPUT() {
        return this.GetParamIntValue(TAG_PARALLELOUTPUT, 0) == 1;
    }

    public final void setPARALLELOUTPUT(boolean bValue) {
        this.SetParamValue(TAG_PARALLELOUTPUT, bValue ? 1 : 0);
    }

    public final boolean isPSSYSVIEWPANELLOGICIDNull() {
        return this.IsParamNull(TAG_PSSYSVIEWPANELLOGICID);
    }

    public final String getPSSYSVIEWPANELLOGICID() {
        return this.GetParamStringValue(TAG_PSSYSVIEWPANELLOGICID, "");
    }

    public final void setPSSYSVIEWPANELLOGICID(String strValue) {
        this.SetParamValue(TAG_PSSYSVIEWPANELLOGICID, strValue);
    }

    public final boolean isPSSYSVIEWPANELLOGICNAMENull() {
        return this.IsParamNull(TAG_PSSYSVIEWPANELLOGICNAME);
    }

    public final String getPSSYSVIEWPANELLOGICNAME() {
        return this.GetParamStringValue(TAG_PSSYSVIEWPANELLOGICNAME, "");
    }

    public final void setPSSYSVIEWPANELLOGICNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSVIEWPANELLOGICNAME, strValue);
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

    public final boolean isPSSYSTEMIDNull() {
        return this.IsParamNull(TAG_PSSYSTEMID);
    }

    public final String getPSSYSTEMID() {
        return this.GetParamStringValue(TAG_PSSYSTEMID, "");
    }

    public final void setPSSYSTEMID(String strValue) {
        this.SetParamValue(TAG_PSSYSTEMID, strValue);
    }

    public final boolean isPSSYSVIEWPANELITEMIDNull() {
        return this.IsParamNull(TAG_PSSYSVIEWPANELITEMID);
    }

    public final String getPSSYSVIEWPANELITEMID() {
        return this.GetParamStringValue(TAG_PSSYSVIEWPANELITEMID, "");
    }

    public final void setPSSYSVIEWPANELITEMID(String strValue) {
        this.SetParamValue(TAG_PSSYSVIEWPANELITEMID, strValue);
    }

    public final boolean isPSSYSVIEWPANELITEMNAMENull() {
        return this.IsParamNull(TAG_PSSYSVIEWPANELITEMNAME);
    }

    public final String getPSSYSVIEWPANELITEMNAME() {
        return this.GetParamStringValue(TAG_PSSYSVIEWPANELITEMNAME, "");
    }

    public final void setPSSYSVIEWPANELITEMNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSVIEWPANELITEMNAME, strValue);
    }

    public final boolean isPSPANELLOGICPARAMIDNull() {
        return this.IsParamNull(TAG_PSPANELLOGICPARAMID);
    }

    public final String getPSPANELLOGICPARAMID() {
        return this.GetParamStringValue(TAG_PSPANELLOGICPARAMID, "");
    }

    public final void setPSPANELLOGICPARAMID(String strValue) {
        this.SetParamValue(TAG_PSPANELLOGICPARAMID, strValue);
    }

    public final boolean isPSPANELLOGICPARAMNAMENull() {
        return this.IsParamNull(TAG_PSPANELLOGICPARAMNAME);
    }

    public final String getPSPANELLOGICPARAMNAME() {
        return this.GetParamStringValue(TAG_PSPANELLOGICPARAMNAME, "");
    }

    public final void setPSPANELLOGICPARAMNAME(String strValue) {
        this.SetParamValue(TAG_PSPANELLOGICPARAMNAME, strValue);
    }

    public ArrayList<PSPanelLogicLink> getPSPanelLogicLinks(boolean bCreated) {
        if (this.childPSPanelLogicLinkList != null) {
            return this.childPSPanelLogicLinkList;
        }
        if (bCreated) {
            this.childPSPanelLogicLinkList = new ArrayList();
        }
        return this.childPSPanelLogicLinkList;
    }

    public ArrayList<PSPanelLogicNodeParam> getPSPanelLogicNodeParams(boolean bCreated) {
        if (this.childPSPanelLogicNodeParamList != null) {
            return this.childPSPanelLogicNodeParamList;
        }
        if (bCreated) {
            this.childPSPanelLogicNodeParamList = new ArrayList();
        }
        return this.childPSPanelLogicNodeParamList;
    }

    public void resetChildDatas() {
        if (this.childPSPanelLogicLinkList != null) {
            this.childPSPanelLogicLinkList.clear();
            this.childPSPanelLogicLinkList = null;
        }
        if (this.childPSPanelLogicNodeParamList != null) {
            this.childPSPanelLogicNodeParamList.clear();
            this.childPSPanelLogicNodeParamList = null;
        }
    }
}

