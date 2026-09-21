/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysPFPluginTempl
extends BaseDataEntity {
    public static final String TAG_PSSYSPFPITEMPLID = "PSSYSPFPITEMPLID";
    public static final String TAG_PSSYSPFPITEMPLNAME = "PSSYSPFPITEMPLNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String TAG_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String TAG_PSPFID = "PSPFID";
    public static final String TAG_PSPFNAME = "PSPFNAME";
    public static final String TAG_TEMPLCODE = "TEMPLCODE";
    public static final String TAG_TEMPLCODE2 = "TEMPLCODE2";
    public static final String TAG_TEMPLCODE3 = "TEMPLCODE3";
    public static final String TAG_TEMPLCODE4 = "TEMPLCODE4";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_TEMPLCODE2EX = "TEMPLCODE2EX";
    public static final String TAG_TEMPLCODEFLAG = "TEMPLCODEFLAG";
    public static final String TAG_TEMPLCODE2FLAG = "TEMPLCODE2FLAG";
    public static final String TAG_TEMPLCODE3FLAG = "TEMPLCODE3FLAG";
    public static final String TAG_TEMPLCODE4FLAG = "TEMPLCODE4FLAG";
    public static final String TAG_TEMPLCODEINFO = "TEMPLCODEINFO";
    public static final String TAG_TEMPLCODE2INFO = "TEMPLCODE2INFO";
    public static final String TAG_TEMPLCODE3INFO = "TEMPLCODE3INFO";
    public static final String TAG_TEMPLCODE4INFO = "TEMPLCODE4INFO";
    public static final String TAG_TEMPLCODE5 = "TEMPLCODE5";
    public static final String TAG_TEMPLCODE6 = "TEMPLCODE6";
    public static final String TAG_PSPFPUBCODEID = "PSPFPUBCODEID";
    public static final String TAG_PSPFPUBCODENAME = "PSPFPUBCODENAME";
    public static final String TAG_CODEMAP = "CODEMAP";
    public static final String TAG_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String TAG_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";

    public final boolean isPSSYSPFPITEMPLIDNull() {
        return this.IsParamNull(TAG_PSSYSPFPITEMPLID);
    }

    public final String getPSSYSPFPITEMPLID() {
        return this.GetParamStringValue(TAG_PSSYSPFPITEMPLID, "");
    }

    public final void setPSSYSPFPITEMPLID(String strValue) {
        this.SetParamValue(TAG_PSSYSPFPITEMPLID, strValue);
    }

    public final boolean isPSSYSPFPITEMPLNAMENull() {
        return this.IsParamNull(TAG_PSSYSPFPITEMPLNAME);
    }

    public final String getPSSYSPFPITEMPLNAME() {
        return this.GetParamStringValue(TAG_PSSYSPFPITEMPLNAME, "");
    }

    public final void setPSSYSPFPITEMPLNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSPFPITEMPLNAME, strValue);
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

    public final boolean isPSPFIDNull() {
        return this.IsParamNull(TAG_PSPFID);
    }

    public final String getPSPFID() {
        return this.GetParamStringValue(TAG_PSPFID, "");
    }

    public final void setPSPFID(String strValue) {
        this.SetParamValue(TAG_PSPFID, strValue);
    }

    public final boolean isPSPFNAMENull() {
        return this.IsParamNull(TAG_PSPFNAME);
    }

    public final String getPSPFNAME() {
        return this.GetParamStringValue(TAG_PSPFNAME, "");
    }

    public final void setPSPFNAME(String strValue) {
        this.SetParamValue(TAG_PSPFNAME, strValue);
    }

    public final boolean isTEMPLCODENull() {
        return this.IsParamNull(TAG_TEMPLCODE);
    }

    public final String getTEMPLCODE() {
        return this.GetParamStringValue(TAG_TEMPLCODE, "");
    }

    public final void setTEMPLCODE(String strValue) {
        this.SetParamValue(TAG_TEMPLCODE, strValue);
    }

    public final boolean isTEMPLCODE2Null() {
        return this.IsParamNull(TAG_TEMPLCODE2);
    }

    public final String getTEMPLCODE2() {
        return this.GetParamStringValue(TAG_TEMPLCODE2, "");
    }

    public final void setTEMPLCODE2(String strValue) {
        this.SetParamValue(TAG_TEMPLCODE2, strValue);
    }

    public final boolean isTEMPLCODE3Null() {
        return this.IsParamNull(TAG_TEMPLCODE3);
    }

    public final String getTEMPLCODE3() {
        return this.GetParamStringValue(TAG_TEMPLCODE3, "");
    }

    public final void setTEMPLCODE3(String strValue) {
        this.SetParamValue(TAG_TEMPLCODE3, strValue);
    }

    public final boolean isTEMPLCODE4Null() {
        return this.IsParamNull(TAG_TEMPLCODE4);
    }

    public final String getTEMPLCODE4() {
        return this.GetParamStringValue(TAG_TEMPLCODE4, "");
    }

    public final void setTEMPLCODE4(String strValue) {
        this.SetParamValue(TAG_TEMPLCODE4, strValue);
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

    public final boolean isTEMPLCODE2EXNull() {
        return this.IsParamNull(TAG_TEMPLCODE2EX);
    }

    public final String getTEMPLCODE2EX() {
        return this.GetParamStringValue(TAG_TEMPLCODE2EX, "");
    }

    public final void setTEMPLCODE2EX(String strValue) {
        this.SetParamValue(TAG_TEMPLCODE2EX, strValue);
    }

    public final boolean isTEMPLCODEFLAGNull() {
        return this.IsParamNull(TAG_TEMPLCODEFLAG);
    }

    public final boolean getTEMPLCODEFLAG() {
        return this.GetParamIntValue(TAG_TEMPLCODEFLAG, 0) == 1;
    }

    public final void setTEMPLCODEFLAG(boolean bValue) {
        this.SetParamValue(TAG_TEMPLCODEFLAG, bValue ? 1 : 0);
    }

    public final boolean isTEMPLCODE2FLAGNull() {
        return this.IsParamNull(TAG_TEMPLCODE2FLAG);
    }

    public final boolean getTEMPLCODE2FLAG() {
        return this.GetParamIntValue(TAG_TEMPLCODE2FLAG, 0) == 1;
    }

    public final void setTEMPLCODE2FLAG(boolean bValue) {
        this.SetParamValue(TAG_TEMPLCODE2FLAG, bValue ? 1 : 0);
    }

    public final boolean isTEMPLCODE3FLAGNull() {
        return this.IsParamNull(TAG_TEMPLCODE3FLAG);
    }

    public final boolean getTEMPLCODE3FLAG() {
        return this.GetParamIntValue(TAG_TEMPLCODE3FLAG, 0) == 1;
    }

    public final void setTEMPLCODE3FLAG(boolean bValue) {
        this.SetParamValue(TAG_TEMPLCODE3FLAG, bValue ? 1 : 0);
    }

    public final boolean isTEMPLCODE4FLAGNull() {
        return this.IsParamNull(TAG_TEMPLCODE4FLAG);
    }

    public final boolean getTEMPLCODE4FLAG() {
        return this.GetParamIntValue(TAG_TEMPLCODE4FLAG, 0) == 1;
    }

    public final void setTEMPLCODE4FLAG(boolean bValue) {
        this.SetParamValue(TAG_TEMPLCODE4FLAG, bValue ? 1 : 0);
    }

    public final boolean isTEMPLCODEINFONull() {
        return this.IsParamNull(TAG_TEMPLCODEINFO);
    }

    public final String getTEMPLCODEINFO() {
        return this.GetParamStringValue(TAG_TEMPLCODEINFO, "");
    }

    public final void setTEMPLCODEINFO(String strValue) {
        this.SetParamValue(TAG_TEMPLCODEINFO, strValue);
    }

    public final boolean isTEMPLCODE2INFONull() {
        return this.IsParamNull(TAG_TEMPLCODE2INFO);
    }

    public final String getTEMPLCODE2INFO() {
        return this.GetParamStringValue(TAG_TEMPLCODE2INFO, "");
    }

    public final void setTEMPLCODE2INFO(String strValue) {
        this.SetParamValue(TAG_TEMPLCODE2INFO, strValue);
    }

    public final boolean isTEMPLCODE3INFONull() {
        return this.IsParamNull(TAG_TEMPLCODE3INFO);
    }

    public final String getTEMPLCODE3INFO() {
        return this.GetParamStringValue(TAG_TEMPLCODE3INFO, "");
    }

    public final void setTEMPLCODE3INFO(String strValue) {
        this.SetParamValue(TAG_TEMPLCODE3INFO, strValue);
    }

    public final boolean isTEMPLCODE4INFONull() {
        return this.IsParamNull(TAG_TEMPLCODE4INFO);
    }

    public final String getTEMPLCODE4INFO() {
        return this.GetParamStringValue(TAG_TEMPLCODE4INFO, "");
    }

    public final void setTEMPLCODE4INFO(String strValue) {
        this.SetParamValue(TAG_TEMPLCODE4INFO, strValue);
    }

    public final boolean isTEMPLCODE5Null() {
        return this.IsParamNull(TAG_TEMPLCODE5);
    }

    public final String getTEMPLCODE5() {
        return this.GetParamStringValue(TAG_TEMPLCODE5, "");
    }

    public final void setTEMPLCODE5(String strValue) {
        this.SetParamValue(TAG_TEMPLCODE5, strValue);
    }

    public final boolean isTEMPLCODE6Null() {
        return this.IsParamNull(TAG_TEMPLCODE6);
    }

    public final String getTEMPLCODE6() {
        return this.GetParamStringValue(TAG_TEMPLCODE6, "");
    }

    public final void setTEMPLCODE6(String strValue) {
        this.SetParamValue(TAG_TEMPLCODE6, strValue);
    }

    public final boolean isPSPFPUBCODEIDNull() {
        return this.IsParamNull(TAG_PSPFPUBCODEID);
    }

    public final String getPSPFPUBCODEID() {
        return this.GetParamStringValue(TAG_PSPFPUBCODEID, "");
    }

    public final void setPSPFPUBCODEID(String strValue) {
        this.SetParamValue(TAG_PSPFPUBCODEID, strValue);
    }

    public final boolean isPSPFPUBCODENAMENull() {
        return this.IsParamNull(TAG_PSPFPUBCODENAME);
    }

    public final String getPSPFPUBCODENAME() {
        return this.GetParamStringValue(TAG_PSPFPUBCODENAME, "");
    }

    public final void setPSPFPUBCODENAME(String strValue) {
        this.SetParamValue(TAG_PSPFPUBCODENAME, strValue);
    }

    public final boolean isCODEMAPNull() {
        return this.IsParamNull(TAG_CODEMAP);
    }

    public final String getCODEMAP() {
        return this.GetParamStringValue(TAG_CODEMAP, "");
    }

    public final void setCODEMAP(String strValue) {
        this.SetParamValue(TAG_CODEMAP, strValue);
    }

    public final boolean isPSSYSDYNAMODELIDNull() {
        return this.IsParamNull(TAG_PSSYSDYNAMODELID);
    }

    public final String getPSSYSDYNAMODELID() {
        return this.GetParamStringValue(TAG_PSSYSDYNAMODELID, "");
    }

    public final void setPSSYSDYNAMODELID(String strValue) {
        this.SetParamValue(TAG_PSSYSDYNAMODELID, strValue);
    }

    public final boolean isPSSYSDYNAMODELNAMENull() {
        return this.IsParamNull(TAG_PSSYSDYNAMODELNAME);
    }

    public final String getPSSYSDYNAMODELNAME() {
        return this.GetParamStringValue(TAG_PSSYSDYNAMODELNAME, "");
    }

    public final void setPSSYSDYNAMODELNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSDYNAMODELNAME, strValue);
    }
}

