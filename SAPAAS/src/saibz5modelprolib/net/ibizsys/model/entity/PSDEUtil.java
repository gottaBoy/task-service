/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSDEUtil
extends BaseDataEntity {
    public static final String UTILTYPE_DATAAUDIT = "DATAAUDIT";
    public static final String TAG_PSDEUTILDEID = "PSDEUTILDEID";
    public static final String TAG_PSDEUTILDENAME = "PSDEUTILDENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_UTILTAG = "UTILTAG";
    public static final String TAG_UTILTYPE = "UTILTYPE";
    public static final String TAG_UTILPSDEID = "UTILPSDEID";
    public static final String TAG_UTILPSDENAME = "UTILPSDENAME";
    public static final String TAG_UNIQUETAG = "UNIQUETAG";
    public static final String TAG_UTILPSDE2ID = "UTILPSDE2ID";
    public static final String TAG_UTILPSDE2NAME = "UTILPSDE2NAME";
    public static final String TAG_UTILPARAM = "UTILPARAM";
    public static final String TAG_UTILPARAM2 = "UTILPARAM2";
    public static final String TAG_UTILPARAM3 = "UTILPARAM3";
    public static final String TAG_UTILPARAM4 = "UTILPARAM4";
    public static final String TAG_UTILPARAM5 = "UTILPARAM5";
    public static final String TAG_UTILPARAM6 = "UTILPARAM6";
    public static final String TAG_UTILPARAM7 = "UTILPARAM7";
    public static final String TAG_UTILPARAM8 = "UTILPARAM8";
    public static final String TAG_UTILPARAM9 = "UTILPARAM9";
    public static final String TAG_UTILPARAM10 = "UTILPARAM10";
    public static final String TAG_UTILPARAM11 = "UTILPARAM11";
    public static final String TAG_UTILPARAM12 = "UTILPARAM12";
    public static final String TAG_UTILPSDE3ID = "UTILPSDE3ID";
    public static final String TAG_UTILPSDE3NAME = "UTILPSDE3NAME";
    public static final String TAG_UTILPSDE4ID = "UTILPSDE4ID";
    public static final String TAG_UTILPSDE4NAME = "UTILPSDE4NAME";
    public static final String TAG_UTILPSDE5ID = "UTILPSDE5ID";
    public static final String TAG_UTILPSDE5NAME = "UTILPSDE5NAME";
    public static final String TAG_UTILPSDE6ID = "UTILPSDE6ID";
    public static final String TAG_UTILPSDE6NAME = "UTILPSDE6NAME";
    public static final String TAG_UTILPSDE7ID = "UTILPSDE7ID";
    public static final String TAG_UTILPSDE7NAME = "UTILPSDE7NAME";
    public static final String TAG_UTILPSDE8ID = "UTILPSDE8ID";
    public static final String TAG_UTILPSDE8NAME = "UTILPSDE8NAME";
    public static final String TAG_UTILPSDE9ID = "UTILPSDE9ID";
    public static final String TAG_UTILPSDE9NAME = "UTILPSDE9NAME";
    public static final String TAG_UTILPSDE10ID = "UTILPSDE10ID";
    public static final String TAG_UTILPSDE10NAME = "UTILPSDE10NAME";
    public static final String TAG_UTILPSDE11ID = "UTILPSDE11ID";
    public static final String TAG_UTILPSDE11NAME = "UTILPSDE11NAME";
    public static final String TAG_UTILPSDE12ID = "UTILPSDE12ID";
    public static final String TAG_UTILPSDE12NAME = "UTILPSDE12NAME";
    public static final String TAG_UTILPSDE13ID = "UTILPSDE13ID";
    public static final String TAG_UTILPSDE13NAME = "UTILPSDE13NAME";
    public static final String TAG_UTILPSDE14ID = "UTILPSDE14ID";
    public static final String TAG_UTILPSDE14NAME = "UTILPSDE14NAME";
    public static final String TAG_UTILPSDE15ID = "UTILPSDE15ID";
    public static final String TAG_UTILPSDE15NAME = "UTILPSDE15NAME";
    public static final String TAG_UTILPSDE16ID = "UTILPSDE16ID";
    public static final String TAG_UTILPSDE16NAME = "UTILPSDE16NAME";
    public static final String TAG_UTILPSDE17ID = "UTILPSDE17ID";
    public static final String TAG_UTILPSDE17NAME = "UTILPSDE17NAME";
    public static final String TAG_UTILPSDE18ID = "UTILPSDE18ID";
    public static final String TAG_UTILPSDE18NAME = "UTILPSDE18NAME";
    public static final String TAG_UTILPSDE19ID = "UTILPSDE19ID";
    public static final String TAG_UTILPSDE19NAME = "UTILPSDE19NAME";
    public static final String TAG_UTILPSDE20ID = "UTILPSDE20ID";
    public static final String TAG_UTILPSDE20NAME = "UTILPSDE20NAME";
    public static final String TAG_EXTENDMODE = "EXTENDMODE";

    public final boolean isPSDEUTILDEIDNull() {
        return this.isParamNull(TAG_PSDEUTILDEID);
    }

    public final String getPSDEUTILDEID() {
        return this.getParamStringValue(TAG_PSDEUTILDEID, "");
    }

    public final void setPSDEUTILDEID(String strValue) {
        this.setParamValue(TAG_PSDEUTILDEID, strValue);
    }

    public final boolean isPSDEUTILDENAMENull() {
        return this.isParamNull(TAG_PSDEUTILDENAME);
    }

    public final String getPSDEUTILDENAME() {
        return this.getParamStringValue(TAG_PSDEUTILDENAME, "");
    }

    public final void setPSDEUTILDENAME(String strValue) {
        this.setParamValue(TAG_PSDEUTILDENAME, strValue);
    }

    public final boolean isCREATEMANNull() {
        return this.isParamNull(TAG_CREATEMAN);
    }

    public final String getCREATEMAN() {
        return this.getParamStringValue(TAG_CREATEMAN, "");
    }

    public final void setCREATEMAN(String strValue) {
        this.setParamValue(TAG_CREATEMAN, strValue);
    }

    public final boolean isCREATEDATENull() {
        return this.isParamNull(TAG_CREATEDATE);
    }

    public final Date getCREATEDATE() {
        return this.getParamDateValue(TAG_CREATEDATE, null);
    }

    public final void setCREATEDATE(Date dtValue) {
        this.setParamValue(TAG_CREATEDATE, dtValue);
    }

    public final boolean isUPDATEMANNull() {
        return this.isParamNull(TAG_UPDATEMAN);
    }

    public final String getUPDATEMAN() {
        return this.getParamStringValue(TAG_UPDATEMAN, "");
    }

    public final void setUPDATEMAN(String strValue) {
        this.setParamValue(TAG_UPDATEMAN, strValue);
    }

    public final boolean isUPDATEDATENull() {
        return this.isParamNull(TAG_UPDATEDATE);
    }

    public final Date getUPDATEDATE() {
        return this.getParamDateValue(TAG_UPDATEDATE, null);
    }

    public final void setUPDATEDATE(Date dtValue) {
        this.setParamValue(TAG_UPDATEDATE, dtValue);
    }

    public final boolean isPSDEIDNull() {
        return this.isParamNull(TAG_PSDEID);
    }

    public final String getPSDEID() {
        return this.getParamStringValue(TAG_PSDEID, "");
    }

    public final void setPSDEID(String strValue) {
        this.setParamValue(TAG_PSDEID, strValue);
    }

    public final boolean isPSDENAMENull() {
        return this.isParamNull(TAG_PSDENAME);
    }

    public final String getPSDENAME() {
        return this.getParamStringValue(TAG_PSDENAME, "");
    }

    public final void setPSDENAME(String strValue) {
        this.setParamValue(TAG_PSDENAME, strValue);
    }

    public final boolean isMEMONull() {
        return this.isParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.getParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.setParamValue(TAG_MEMO, strValue);
    }

    public final boolean isVALIDFLAGNull() {
        return this.isParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.getParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.setParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
    }

    public final boolean isUTILTAGNull() {
        return this.isParamNull(TAG_UTILTAG);
    }

    public final String getUTILTAG() {
        return this.getParamStringValue(TAG_UTILTAG, "");
    }

    public final void setUTILTAG(String strValue) {
        this.setParamValue(TAG_UTILTAG, strValue);
    }

    public final boolean isUTILTYPENull() {
        return this.isParamNull(TAG_UTILTYPE);
    }

    public final String getUTILTYPE() {
        return this.getParamStringValue(TAG_UTILTYPE, "");
    }

    public final void setUTILTYPE(String strValue) {
        this.setParamValue(TAG_UTILTYPE, strValue);
    }

    public final boolean isUTILPSDEIDNull() {
        return this.isParamNull(TAG_UTILPSDEID);
    }

    public final String getUTILPSDEID() {
        return this.getParamStringValue(TAG_UTILPSDEID, "");
    }

    public final void setUTILPSDEID(String strValue) {
        this.setParamValue(TAG_UTILPSDEID, strValue);
    }

    public final boolean isUTILPSDENAMENull() {
        return this.isParamNull(TAG_UTILPSDENAME);
    }

    public final String getUTILPSDENAME() {
        return this.getParamStringValue(TAG_UTILPSDENAME, "");
    }

    public final void setUTILPSDENAME(String strValue) {
        this.setParamValue(TAG_UTILPSDENAME, strValue);
    }

    public final boolean isUNIQUETAGNull() {
        return this.isParamNull(TAG_UNIQUETAG);
    }

    public final String getUNIQUETAG() {
        return this.getParamStringValue(TAG_UNIQUETAG, "");
    }

    public final void setUNIQUETAG(String strValue) {
        this.setParamValue(TAG_UNIQUETAG, strValue);
    }

    public final boolean isUTILPSDE2IDNull() {
        return this.isParamNull(TAG_UTILPSDE2ID);
    }

    public final String getUTILPSDE2ID() {
        return this.getParamStringValue(TAG_UTILPSDE2ID, "");
    }

    public final void setUTILPSDE2ID(String strValue) {
        this.setParamValue(TAG_UTILPSDE2ID, strValue);
    }

    public final boolean isUTILPSDE2NAMENull() {
        return this.isParamNull(TAG_UTILPSDE2NAME);
    }

    public final String getUTILPSDE2NAME() {
        return this.getParamStringValue(TAG_UTILPSDE2NAME, "");
    }

    public final void setUTILPSDE2NAME(String strValue) {
        this.setParamValue(TAG_UTILPSDE2NAME, strValue);
    }

    public final boolean isUTILPARAMNull() {
        return this.isParamNull(TAG_UTILPARAM);
    }

    public final String getUTILPARAM() {
        return this.getParamStringValue(TAG_UTILPARAM, "");
    }

    public final void setUTILPARAM(String strValue) {
        this.setParamValue(TAG_UTILPARAM, strValue);
    }

    public final boolean isUTILPARAM2Null() {
        return this.isParamNull(TAG_UTILPARAM2);
    }

    public final String getUTILPARAM2() {
        return this.getParamStringValue(TAG_UTILPARAM2, "");
    }

    public final void setUTILPARAM2(String strValue) {
        this.setParamValue(TAG_UTILPARAM2, strValue);
    }

    public final boolean isUTILPARAM3Null() {
        return this.isParamNull(TAG_UTILPARAM3);
    }

    public final String getUTILPARAM3() {
        return this.getParamStringValue(TAG_UTILPARAM3, "");
    }

    public final void setUTILPARAM3(String strValue) {
        this.setParamValue(TAG_UTILPARAM3, strValue);
    }

    public final boolean isUTILPARAM4Null() {
        return this.isParamNull(TAG_UTILPARAM4);
    }

    public final String getUTILPARAM4() {
        return this.getParamStringValue(TAG_UTILPARAM4, "");
    }

    public final void setUTILPARAM4(String strValue) {
        this.setParamValue(TAG_UTILPARAM4, strValue);
    }

    public final boolean isUTILPARAM5Null() {
        return this.isParamNull(TAG_UTILPARAM5);
    }

    public final boolean getUTILPARAM5() {
        return this.getParamIntValue(TAG_UTILPARAM5, 0) == 1;
    }

    public final void setUTILPARAM5(boolean bValue) {
        this.setParamValue(TAG_UTILPARAM5, bValue ? 1 : 0);
    }

    public final boolean isUTILPARAM6Null() {
        return this.isParamNull(TAG_UTILPARAM6);
    }

    public final boolean getUTILPARAM6() {
        return this.getParamIntValue(TAG_UTILPARAM6, 0) == 1;
    }

    public final void setUTILPARAM6(boolean bValue) {
        this.setParamValue(TAG_UTILPARAM6, bValue ? 1 : 0);
    }

    public final boolean isUTILPARAM7Null() {
        return this.isParamNull(TAG_UTILPARAM7);
    }

    public final int getUTILPARAM7() {
        return this.getParamIntValue(TAG_UTILPARAM7, 0);
    }

    public final void setUTILPARAM7(int nValue) {
        this.setParamValue(TAG_UTILPARAM7, nValue);
    }

    public final boolean isUTILPARAM8Null() {
        return this.isParamNull(TAG_UTILPARAM8);
    }

    public final int getUTILPARAM8() {
        return this.getParamIntValue(TAG_UTILPARAM8, 0);
    }

    public final void setUTILPARAM8(int nValue) {
        this.setParamValue(TAG_UTILPARAM8, nValue);
    }

    public final boolean isUTILPARAM9Null() {
        return this.isParamNull(TAG_UTILPARAM9);
    }

    public final int getUTILPARAM9() {
        return this.getParamIntValue(TAG_UTILPARAM9, 0);
    }

    public final void setUTILPARAM9(int nValue) {
        this.setParamValue(TAG_UTILPARAM9, nValue);
    }

    public final boolean isUTILPARAM10Null() {
        return this.isParamNull(TAG_UTILPARAM10);
    }

    public final int getUTILPARAM10() {
        return this.getParamIntValue(TAG_UTILPARAM10, 0);
    }

    public final void setUTILPARAM10(int nValue) {
        this.setParamValue(TAG_UTILPARAM10, nValue);
    }

    public final boolean isUTILPARAM11Null() {
        return this.isParamNull(TAG_UTILPARAM11);
    }

    public final String getUTILPARAM11() {
        return this.getParamStringValue(TAG_UTILPARAM11, "");
    }

    public final void setUTILPARAM11(String strValue) {
        this.setParamValue(TAG_UTILPARAM11, strValue);
    }

    public final boolean isUTILPARAM12Null() {
        return this.isParamNull(TAG_UTILPARAM12);
    }

    public final String getUTILPARAM12() {
        return this.getParamStringValue(TAG_UTILPARAM12, "");
    }

    public final void setUTILPARAM12(String strValue) {
        this.setParamValue(TAG_UTILPARAM12, strValue);
    }

    public final boolean isUTILPSDE3IDNull() {
        return this.isParamNull(TAG_UTILPSDE3ID);
    }

    public final String getUTILPSDE3ID() {
        return this.getParamStringValue(TAG_UTILPSDE3ID, "");
    }

    public final void setUTILPSDE3ID(String strValue) {
        this.setParamValue(TAG_UTILPSDE3ID, strValue);
    }

    public final boolean isUTILPSDE3NAMENull() {
        return this.isParamNull(TAG_UTILPSDE3NAME);
    }

    public final String getUTILPSDE3NAME() {
        return this.getParamStringValue(TAG_UTILPSDE3NAME, "");
    }

    public final void setUTILPSDE3NAME(String strValue) {
        this.setParamValue(TAG_UTILPSDE3NAME, strValue);
    }

    public final boolean isUTILPSDE4IDNull() {
        return this.isParamNull(TAG_UTILPSDE4ID);
    }

    public final String getUTILPSDE4ID() {
        return this.getParamStringValue(TAG_UTILPSDE4ID, "");
    }

    public final void setUTILPSDE4ID(String strValue) {
        this.setParamValue(TAG_UTILPSDE4ID, strValue);
    }

    public final boolean isUTILPSDE4NAMENull() {
        return this.isParamNull(TAG_UTILPSDE4NAME);
    }

    public final String getUTILPSDE4NAME() {
        return this.getParamStringValue(TAG_UTILPSDE4NAME, "");
    }

    public final void setUTILPSDE4NAME(String strValue) {
        this.setParamValue(TAG_UTILPSDE4NAME, strValue);
    }

    public final boolean isUTILPSDE5IDNull() {
        return this.isParamNull(TAG_UTILPSDE5ID);
    }

    public final String getUTILPSDE5ID() {
        return this.getParamStringValue(TAG_UTILPSDE5ID, "");
    }

    public final void setUTILPSDE5ID(String strValue) {
        this.setParamValue(TAG_UTILPSDE5ID, strValue);
    }

    public final boolean isUTILPSDE5NAMENull() {
        return this.isParamNull(TAG_UTILPSDE5NAME);
    }

    public final String getUTILPSDE5NAME() {
        return this.getParamStringValue(TAG_UTILPSDE5NAME, "");
    }

    public final void setUTILPSDE5NAME(String strValue) {
        this.setParamValue(TAG_UTILPSDE5NAME, strValue);
    }

    public final boolean isUTILPSDE6IDNull() {
        return this.isParamNull(TAG_UTILPSDE6ID);
    }

    public final String getUTILPSDE6ID() {
        return this.getParamStringValue(TAG_UTILPSDE6ID, "");
    }

    public final void setUTILPSDE6ID(String strValue) {
        this.setParamValue(TAG_UTILPSDE6ID, strValue);
    }

    public final boolean isUTILPSDE6NAMENull() {
        return this.isParamNull(TAG_UTILPSDE6NAME);
    }

    public final String getUTILPSDE6NAME() {
        return this.getParamStringValue(TAG_UTILPSDE6NAME, "");
    }

    public final void setUTILPSDE6NAME(String strValue) {
        this.setParamValue(TAG_UTILPSDE6NAME, strValue);
    }

    public final boolean isUTILPSDE7IDNull() {
        return this.isParamNull(TAG_UTILPSDE7ID);
    }

    public final String getUTILPSDE7ID() {
        return this.getParamStringValue(TAG_UTILPSDE7ID, "");
    }

    public final void setUTILPSDE7ID(String strValue) {
        this.setParamValue(TAG_UTILPSDE7ID, strValue);
    }

    public final boolean isUTILPSDE7NAMENull() {
        return this.isParamNull(TAG_UTILPSDE7NAME);
    }

    public final String getUTILPSDE7NAME() {
        return this.getParamStringValue(TAG_UTILPSDE7NAME, "");
    }

    public final void setUTILPSDE7NAME(String strValue) {
        this.setParamValue(TAG_UTILPSDE7NAME, strValue);
    }

    public final boolean isUTILPSDE8IDNull() {
        return this.isParamNull(TAG_UTILPSDE8ID);
    }

    public final String getUTILPSDE8ID() {
        return this.getParamStringValue(TAG_UTILPSDE8ID, "");
    }

    public final void setUTILPSDE8ID(String strValue) {
        this.setParamValue(TAG_UTILPSDE8ID, strValue);
    }

    public final boolean isUTILPSDE8NAMENull() {
        return this.isParamNull(TAG_UTILPSDE8NAME);
    }

    public final String getUTILPSDE8NAME() {
        return this.getParamStringValue(TAG_UTILPSDE8NAME, "");
    }

    public final void setUTILPSDE8NAME(String strValue) {
        this.setParamValue(TAG_UTILPSDE8NAME, strValue);
    }

    public final boolean isUTILPSDE9IDNull() {
        return this.isParamNull(TAG_UTILPSDE9ID);
    }

    public final String getUTILPSDE9ID() {
        return this.getParamStringValue(TAG_UTILPSDE9ID, "");
    }

    public final void setUTILPSDE9ID(String strValue) {
        this.setParamValue(TAG_UTILPSDE9ID, strValue);
    }

    public final boolean isUTILPSDE9NAMENull() {
        return this.isParamNull(TAG_UTILPSDE9NAME);
    }

    public final String getUTILPSDE9NAME() {
        return this.getParamStringValue(TAG_UTILPSDE9NAME, "");
    }

    public final void setUTILPSDE9NAME(String strValue) {
        this.setParamValue(TAG_UTILPSDE9NAME, strValue);
    }

    public final boolean isUTILPSDE10IDNull() {
        return this.isParamNull(TAG_UTILPSDE10ID);
    }

    public final String getUTILPSDE10ID() {
        return this.getParamStringValue(TAG_UTILPSDE10ID, "");
    }

    public final void setUTILPSDE10ID(String strValue) {
        this.setParamValue(TAG_UTILPSDE10ID, strValue);
    }

    public final boolean isUTILPSDE10NAMENull() {
        return this.isParamNull(TAG_UTILPSDE10NAME);
    }

    public final String getUTILPSDE10NAME() {
        return this.getParamStringValue(TAG_UTILPSDE10NAME, "");
    }

    public final void setUTILPSDE10NAME(String strValue) {
        this.setParamValue(TAG_UTILPSDE10NAME, strValue);
    }

    public final boolean isUTILPSDE11IDNull() {
        return this.isParamNull(TAG_UTILPSDE11ID);
    }

    public final String getUTILPSDE11ID() {
        return this.getParamStringValue(TAG_UTILPSDE11ID, "");
    }

    public final void setUTILPSDE11ID(String strValue) {
        this.setParamValue(TAG_UTILPSDE11ID, strValue);
    }

    public final boolean isUTILPSDE11NAMENull() {
        return this.isParamNull(TAG_UTILPSDE11NAME);
    }

    public final String getUTILPSDE11NAME() {
        return this.getParamStringValue(TAG_UTILPSDE11NAME, "");
    }

    public final void setUTILPSDE11NAME(String strValue) {
        this.setParamValue(TAG_UTILPSDE11NAME, strValue);
    }

    public final boolean isUTILPSDE12IDNull() {
        return this.isParamNull(TAG_UTILPSDE12ID);
    }

    public final String getUTILPSDE12ID() {
        return this.getParamStringValue(TAG_UTILPSDE12ID, "");
    }

    public final void setUTILPSDE12ID(String strValue) {
        this.setParamValue(TAG_UTILPSDE12ID, strValue);
    }

    public final boolean isUTILPSDE12NAMENull() {
        return this.isParamNull(TAG_UTILPSDE12NAME);
    }

    public final String getUTILPSDE12NAME() {
        return this.getParamStringValue(TAG_UTILPSDE12NAME, "");
    }

    public final void setUTILPSDE12NAME(String strValue) {
        this.setParamValue(TAG_UTILPSDE12NAME, strValue);
    }

    public final boolean isUTILPSDE13IDNull() {
        return this.isParamNull(TAG_UTILPSDE13ID);
    }

    public final String getUTILPSDE13ID() {
        return this.getParamStringValue(TAG_UTILPSDE13ID, "");
    }

    public final void setUTILPSDE13ID(String strValue) {
        this.setParamValue(TAG_UTILPSDE13ID, strValue);
    }

    public final boolean isUTILPSDE13NAMENull() {
        return this.isParamNull(TAG_UTILPSDE13NAME);
    }

    public final String getUTILPSDE13NAME() {
        return this.getParamStringValue(TAG_UTILPSDE13NAME, "");
    }

    public final void setUTILPSDE13NAME(String strValue) {
        this.setParamValue(TAG_UTILPSDE13NAME, strValue);
    }

    public final boolean isUTILPSDE14IDNull() {
        return this.isParamNull(TAG_UTILPSDE14ID);
    }

    public final String getUTILPSDE14ID() {
        return this.getParamStringValue(TAG_UTILPSDE14ID, "");
    }

    public final void setUTILPSDE14ID(String strValue) {
        this.setParamValue(TAG_UTILPSDE14ID, strValue);
    }

    public final boolean isUTILPSDE14NAMENull() {
        return this.isParamNull(TAG_UTILPSDE14NAME);
    }

    public final String getUTILPSDE14NAME() {
        return this.getParamStringValue(TAG_UTILPSDE14NAME, "");
    }

    public final void setUTILPSDE14NAME(String strValue) {
        this.setParamValue(TAG_UTILPSDE14NAME, strValue);
    }

    public final boolean isUTILPSDE15IDNull() {
        return this.isParamNull(TAG_UTILPSDE15ID);
    }

    public final String getUTILPSDE15ID() {
        return this.getParamStringValue(TAG_UTILPSDE15ID, "");
    }

    public final void setUTILPSDE15ID(String strValue) {
        this.setParamValue(TAG_UTILPSDE15ID, strValue);
    }

    public final boolean isUTILPSDE15NAMENull() {
        return this.isParamNull(TAG_UTILPSDE15NAME);
    }

    public final String getUTILPSDE15NAME() {
        return this.getParamStringValue(TAG_UTILPSDE15NAME, "");
    }

    public final void setUTILPSDE15NAME(String strValue) {
        this.setParamValue(TAG_UTILPSDE15NAME, strValue);
    }

    public final boolean isUTILPSDE16IDNull() {
        return this.isParamNull(TAG_UTILPSDE16ID);
    }

    public final String getUTILPSDE16ID() {
        return this.getParamStringValue(TAG_UTILPSDE16ID, "");
    }

    public final void setUTILPSDE16ID(String strValue) {
        this.setParamValue(TAG_UTILPSDE16ID, strValue);
    }

    public final boolean isUTILPSDE16NAMENull() {
        return this.isParamNull(TAG_UTILPSDE16NAME);
    }

    public final String getUTILPSDE16NAME() {
        return this.getParamStringValue(TAG_UTILPSDE16NAME, "");
    }

    public final void setUTILPSDE16NAME(String strValue) {
        this.setParamValue(TAG_UTILPSDE16NAME, strValue);
    }

    public final boolean isUTILPSDE17IDNull() {
        return this.isParamNull(TAG_UTILPSDE17ID);
    }

    public final String getUTILPSDE17ID() {
        return this.getParamStringValue(TAG_UTILPSDE17ID, "");
    }

    public final void setUTILPSDE17ID(String strValue) {
        this.setParamValue(TAG_UTILPSDE17ID, strValue);
    }

    public final boolean isUTILPSDE17NAMENull() {
        return this.isParamNull(TAG_UTILPSDE17NAME);
    }

    public final String getUTILPSDE17NAME() {
        return this.getParamStringValue(TAG_UTILPSDE17NAME, "");
    }

    public final void setUTILPSDE17NAME(String strValue) {
        this.setParamValue(TAG_UTILPSDE17NAME, strValue);
    }

    public final boolean isUTILPSDE18IDNull() {
        return this.isParamNull(TAG_UTILPSDE18ID);
    }

    public final String getUTILPSDE18ID() {
        return this.getParamStringValue(TAG_UTILPSDE18ID, "");
    }

    public final void setUTILPSDE18ID(String strValue) {
        this.setParamValue(TAG_UTILPSDE18ID, strValue);
    }

    public final boolean isUTILPSDE18NAMENull() {
        return this.isParamNull(TAG_UTILPSDE18NAME);
    }

    public final String getUTILPSDE18NAME() {
        return this.getParamStringValue(TAG_UTILPSDE18NAME, "");
    }

    public final void setUTILPSDE18NAME(String strValue) {
        this.setParamValue(TAG_UTILPSDE18NAME, strValue);
    }

    public final boolean isUTILPSDE19IDNull() {
        return this.isParamNull(TAG_UTILPSDE19ID);
    }

    public final String getUTILPSDE19ID() {
        return this.getParamStringValue(TAG_UTILPSDE19ID, "");
    }

    public final void setUTILPSDE19ID(String strValue) {
        this.setParamValue(TAG_UTILPSDE19ID, strValue);
    }

    public final boolean isUTILPSDE19NAMENull() {
        return this.isParamNull(TAG_UTILPSDE19NAME);
    }

    public final String getUTILPSDE19NAME() {
        return this.getParamStringValue(TAG_UTILPSDE19NAME, "");
    }

    public final void setUTILPSDE19NAME(String strValue) {
        this.setParamValue(TAG_UTILPSDE19NAME, strValue);
    }

    public final boolean isUTILPSDE20IDNull() {
        return this.isParamNull(TAG_UTILPSDE20ID);
    }

    public final String getUTILPSDE20ID() {
        return this.getParamStringValue(TAG_UTILPSDE20ID, "");
    }

    public final void setUTILPSDE20ID(String strValue) {
        this.setParamValue(TAG_UTILPSDE20ID, strValue);
    }

    public final boolean isUTILPSDE20NAMENull() {
        return this.isParamNull(TAG_UTILPSDE20NAME);
    }

    public final String getUTILPSDE20NAME() {
        return this.getParamStringValue(TAG_UTILPSDE20NAME, "");
    }

    public final void setUTILPSDE20NAME(String strValue) {
        this.setParamValue(TAG_UTILPSDE20NAME, strValue);
    }

    public final boolean isEXTENDMODENull() {
        return this.isParamNull(TAG_EXTENDMODE);
    }

    public final int getEXTENDMODE() {
        return this.getParamIntValue(TAG_EXTENDMODE, 0);
    }

    public final void setEXTENDMODE(int nValue) {
        this.setParamValue(TAG_EXTENDMODE, nValue);
    }
}

