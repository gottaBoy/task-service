/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSAppUtil
extends BaseDataEntity {
    public static final String UTILTYPE_USER = "USER";
    public static final String UTILTYPE_USER2 = "USER2";
    public static final String USERCAT_CAT1 = "CAT1";
    public static final String USERCAT_CAT2 = "CAT2";
    public static final String USERCAT_CAT3 = "CAT3";
    public static final String USERCAT_CAT4 = "CAT4";
    public static final String USERCAT_CAT5 = "CAT5";
    public static final String USERCAT_CAT6 = "CAT6";
    public static final String USERCAT_CAT7 = "CAT7";
    public static final String USERCAT_CAT8 = "CAT8";
    public static final String USERCAT_CAT9 = "CAT9";
    public static final String TAG_PSAPPUTILID = "PSAPPUTILID";
    public static final String TAG_PSAPPUTILNAME = "PSAPPUTILNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSAPPID = "PSSYSAPPID";
    public static final String TAG_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_UTILPARAM = "UTILPARAM";
    public static final String TAG_UTILPARAM10 = "UTILPARAM10";
    public static final String TAG_UTILPARAM11 = "UTILPARAM11";
    public static final String TAG_UTILPARAM12 = "UTILPARAM12";
    public static final String TAG_UTILPARAM2 = "UTILPARAM2";
    public static final String TAG_UTILPARAM3 = "UTILPARAM3";
    public static final String TAG_UTILPARAM4 = "UTILPARAM4";
    public static final String TAG_UTILPARAM5 = "UTILPARAM5";
    public static final String TAG_UTILPARAM6 = "UTILPARAM6";
    public static final String TAG_UTILPARAM7 = "UTILPARAM7";
    public static final String TAG_UTILPARAM8 = "UTILPARAM8";
    public static final String TAG_UTILPARAM9 = "UTILPARAM9";
    public static final String TAG_UTILTYPE = "UTILTYPE";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String TAG_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String TAG_UTILPARAMS = "UTILPARAMS";
    public static final String TAG_UTILOBJ = "UTILOBJ";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_UTILTAG = "UTILTAG";
    public static final String TAG_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String TAG_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String TAG_UTILPSDEID = "UTILPSDEID";
    public static final String TAG_UTILPSDENAME = "UTILPSDENAME";
    public static final String TAG_UTILPSDE2ID = "UTILPSDE2ID";
    public static final String TAG_UTILPSDE2NAME = "UTILPSDE2NAME";
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

    public final boolean isPSAPPUTILIDNull() {
        return this.IsParamNull(TAG_PSAPPUTILID);
    }

    public final String getPSAPPUTILID() {
        return this.GetParamStringValue(TAG_PSAPPUTILID, "");
    }

    public final void setPSAPPUTILID(String strValue) {
        this.SetParamValue(TAG_PSAPPUTILID, strValue);
    }

    public final boolean isPSAPPUTILNAMENull() {
        return this.IsParamNull(TAG_PSAPPUTILNAME);
    }

    public final String getPSAPPUTILNAME() {
        return this.GetParamStringValue(TAG_PSAPPUTILNAME, "");
    }

    public final void setPSAPPUTILNAME(String strValue) {
        this.SetParamValue(TAG_PSAPPUTILNAME, strValue);
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

    public final boolean isUTILPARAMNull() {
        return this.IsParamNull(TAG_UTILPARAM);
    }

    public final String getUTILPARAM() {
        return this.GetParamStringValue(TAG_UTILPARAM, "");
    }

    public final void setUTILPARAM(String strValue) {
        this.SetParamValue(TAG_UTILPARAM, strValue);
    }

    public final boolean isUTILPARAM10Null() {
        return this.IsParamNull(TAG_UTILPARAM10);
    }

    public final int getUTILPARAM10() {
        return this.GetParamIntValue(TAG_UTILPARAM10, 0);
    }

    public final void setUTILPARAM10(int nValue) {
        this.SetParamValue(TAG_UTILPARAM10, nValue);
    }

    public final boolean isUTILPARAM11Null() {
        return this.IsParamNull(TAG_UTILPARAM11);
    }

    public final String getUTILPARAM11() {
        return this.GetParamStringValue(TAG_UTILPARAM11, "");
    }

    public final void setUTILPARAM11(String strValue) {
        this.SetParamValue(TAG_UTILPARAM11, strValue);
    }

    public final boolean isUTILPARAM12Null() {
        return this.IsParamNull(TAG_UTILPARAM12);
    }

    public final String getUTILPARAM12() {
        return this.GetParamStringValue(TAG_UTILPARAM12, "");
    }

    public final void setUTILPARAM12(String strValue) {
        this.SetParamValue(TAG_UTILPARAM12, strValue);
    }

    public final boolean isUTILPARAM2Null() {
        return this.IsParamNull(TAG_UTILPARAM2);
    }

    public final String getUTILPARAM2() {
        return this.GetParamStringValue(TAG_UTILPARAM2, "");
    }

    public final void setUTILPARAM2(String strValue) {
        this.SetParamValue(TAG_UTILPARAM2, strValue);
    }

    public final boolean isUTILPARAM3Null() {
        return this.IsParamNull(TAG_UTILPARAM3);
    }

    public final String getUTILPARAM3() {
        return this.GetParamStringValue(TAG_UTILPARAM3, "");
    }

    public final void setUTILPARAM3(String strValue) {
        this.SetParamValue(TAG_UTILPARAM3, strValue);
    }

    public final boolean isUTILPARAM4Null() {
        return this.IsParamNull(TAG_UTILPARAM4);
    }

    public final String getUTILPARAM4() {
        return this.GetParamStringValue(TAG_UTILPARAM4, "");
    }

    public final void setUTILPARAM4(String strValue) {
        this.SetParamValue(TAG_UTILPARAM4, strValue);
    }

    public final boolean isUTILPARAM5Null() {
        return this.IsParamNull(TAG_UTILPARAM5);
    }

    public final boolean getUTILPARAM5() {
        return this.GetParamIntValue(TAG_UTILPARAM5, 0) == 1;
    }

    public final void setUTILPARAM5(boolean bValue) {
        this.SetParamValue(TAG_UTILPARAM5, bValue ? 1 : 0);
    }

    public final boolean isUTILPARAM6Null() {
        return this.IsParamNull(TAG_UTILPARAM6);
    }

    public final boolean getUTILPARAM6() {
        return this.GetParamIntValue(TAG_UTILPARAM6, 0) == 1;
    }

    public final void setUTILPARAM6(boolean bValue) {
        this.SetParamValue(TAG_UTILPARAM6, bValue ? 1 : 0);
    }

    public final boolean isUTILPARAM7Null() {
        return this.IsParamNull(TAG_UTILPARAM7);
    }

    public final int getUTILPARAM7() {
        return this.GetParamIntValue(TAG_UTILPARAM7, 0);
    }

    public final void setUTILPARAM7(int nValue) {
        this.SetParamValue(TAG_UTILPARAM7, nValue);
    }

    public final boolean isUTILPARAM8Null() {
        return this.IsParamNull(TAG_UTILPARAM8);
    }

    public final int getUTILPARAM8() {
        return this.GetParamIntValue(TAG_UTILPARAM8, 0);
    }

    public final void setUTILPARAM8(int nValue) {
        this.SetParamValue(TAG_UTILPARAM8, nValue);
    }

    public final boolean isUTILPARAM9Null() {
        return this.IsParamNull(TAG_UTILPARAM9);
    }

    public final int getUTILPARAM9() {
        return this.GetParamIntValue(TAG_UTILPARAM9, 0);
    }

    public final void setUTILPARAM9(int nValue) {
        this.SetParamValue(TAG_UTILPARAM9, nValue);
    }

    public final boolean isUTILTYPENull() {
        return this.IsParamNull(TAG_UTILTYPE);
    }

    public final String getUTILTYPE() {
        return this.GetParamStringValue(TAG_UTILTYPE, "");
    }

    public final void setUTILTYPE(String strValue) {
        this.SetParamValue(TAG_UTILTYPE, strValue);
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

    public final boolean isUTILPARAMSNull() {
        return this.IsParamNull(TAG_UTILPARAMS);
    }

    public final String getUTILPARAMS() {
        return this.GetParamStringValue(TAG_UTILPARAMS, "");
    }

    public final void setUTILPARAMS(String strValue) {
        this.SetParamValue(TAG_UTILPARAMS, strValue);
    }

    public final boolean isUTILOBJNull() {
        return this.IsParamNull(TAG_UTILOBJ);
    }

    public final String getUTILOBJ() {
        return this.GetParamStringValue(TAG_UTILOBJ, "");
    }

    public final void setUTILOBJ(String strValue) {
        this.SetParamValue(TAG_UTILOBJ, strValue);
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

    public final boolean isUTILTAGNull() {
        return this.IsParamNull(TAG_UTILTAG);
    }

    public final String getUTILTAG() {
        return this.GetParamStringValue(TAG_UTILTAG, "");
    }

    public final void setUTILTAG(String strValue) {
        this.SetParamValue(TAG_UTILTAG, strValue);
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

    public final boolean isUTILPSDEIDNull() {
        return this.IsParamNull(TAG_UTILPSDEID);
    }

    public final String getUTILPSDEID() {
        return this.GetParamStringValue(TAG_UTILPSDEID, "");
    }

    public final void setUTILPSDEID(String strValue) {
        this.SetParamValue(TAG_UTILPSDEID, strValue);
    }

    public final boolean isUTILPSDENAMENull() {
        return this.IsParamNull(TAG_UTILPSDENAME);
    }

    public final String getUTILPSDENAME() {
        return this.GetParamStringValue(TAG_UTILPSDENAME, "");
    }

    public final void setUTILPSDENAME(String strValue) {
        this.SetParamValue(TAG_UTILPSDENAME, strValue);
    }

    public final boolean isUTILPSDE2IDNull() {
        return this.IsParamNull(TAG_UTILPSDE2ID);
    }

    public final String getUTILPSDE2ID() {
        return this.GetParamStringValue(TAG_UTILPSDE2ID, "");
    }

    public final void setUTILPSDE2ID(String strValue) {
        this.SetParamValue(TAG_UTILPSDE2ID, strValue);
    }

    public final boolean isUTILPSDE2NAMENull() {
        return this.IsParamNull(TAG_UTILPSDE2NAME);
    }

    public final String getUTILPSDE2NAME() {
        return this.GetParamStringValue(TAG_UTILPSDE2NAME, "");
    }

    public final void setUTILPSDE2NAME(String strValue) {
        this.SetParamValue(TAG_UTILPSDE2NAME, strValue);
    }

    public final boolean isUTILPSDE3IDNull() {
        return this.IsParamNull(TAG_UTILPSDE3ID);
    }

    public final String getUTILPSDE3ID() {
        return this.GetParamStringValue(TAG_UTILPSDE3ID, "");
    }

    public final void setUTILPSDE3ID(String strValue) {
        this.SetParamValue(TAG_UTILPSDE3ID, strValue);
    }

    public final boolean isUTILPSDE3NAMENull() {
        return this.IsParamNull(TAG_UTILPSDE3NAME);
    }

    public final String getUTILPSDE3NAME() {
        return this.GetParamStringValue(TAG_UTILPSDE3NAME, "");
    }

    public final void setUTILPSDE3NAME(String strValue) {
        this.SetParamValue(TAG_UTILPSDE3NAME, strValue);
    }

    public final boolean isUTILPSDE4IDNull() {
        return this.IsParamNull(TAG_UTILPSDE4ID);
    }

    public final String getUTILPSDE4ID() {
        return this.GetParamStringValue(TAG_UTILPSDE4ID, "");
    }

    public final void setUTILPSDE4ID(String strValue) {
        this.SetParamValue(TAG_UTILPSDE4ID, strValue);
    }

    public final boolean isUTILPSDE4NAMENull() {
        return this.IsParamNull(TAG_UTILPSDE4NAME);
    }

    public final String getUTILPSDE4NAME() {
        return this.GetParamStringValue(TAG_UTILPSDE4NAME, "");
    }

    public final void setUTILPSDE4NAME(String strValue) {
        this.SetParamValue(TAG_UTILPSDE4NAME, strValue);
    }

    public final boolean isUTILPSDE5IDNull() {
        return this.IsParamNull(TAG_UTILPSDE5ID);
    }

    public final String getUTILPSDE5ID() {
        return this.GetParamStringValue(TAG_UTILPSDE5ID, "");
    }

    public final void setUTILPSDE5ID(String strValue) {
        this.SetParamValue(TAG_UTILPSDE5ID, strValue);
    }

    public final boolean isUTILPSDE5NAMENull() {
        return this.IsParamNull(TAG_UTILPSDE5NAME);
    }

    public final String getUTILPSDE5NAME() {
        return this.GetParamStringValue(TAG_UTILPSDE5NAME, "");
    }

    public final void setUTILPSDE5NAME(String strValue) {
        this.SetParamValue(TAG_UTILPSDE5NAME, strValue);
    }

    public final boolean isUTILPSDE6IDNull() {
        return this.IsParamNull(TAG_UTILPSDE6ID);
    }

    public final String getUTILPSDE6ID() {
        return this.GetParamStringValue(TAG_UTILPSDE6ID, "");
    }

    public final void setUTILPSDE6ID(String strValue) {
        this.SetParamValue(TAG_UTILPSDE6ID, strValue);
    }

    public final boolean isUTILPSDE6NAMENull() {
        return this.IsParamNull(TAG_UTILPSDE6NAME);
    }

    public final String getUTILPSDE6NAME() {
        return this.GetParamStringValue(TAG_UTILPSDE6NAME, "");
    }

    public final void setUTILPSDE6NAME(String strValue) {
        this.SetParamValue(TAG_UTILPSDE6NAME, strValue);
    }

    public final boolean isUTILPSDE7IDNull() {
        return this.IsParamNull(TAG_UTILPSDE7ID);
    }

    public final String getUTILPSDE7ID() {
        return this.GetParamStringValue(TAG_UTILPSDE7ID, "");
    }

    public final void setUTILPSDE7ID(String strValue) {
        this.SetParamValue(TAG_UTILPSDE7ID, strValue);
    }

    public final boolean isUTILPSDE7NAMENull() {
        return this.IsParamNull(TAG_UTILPSDE7NAME);
    }

    public final String getUTILPSDE7NAME() {
        return this.GetParamStringValue(TAG_UTILPSDE7NAME, "");
    }

    public final void setUTILPSDE7NAME(String strValue) {
        this.SetParamValue(TAG_UTILPSDE7NAME, strValue);
    }

    public final boolean isUTILPSDE8IDNull() {
        return this.IsParamNull(TAG_UTILPSDE8ID);
    }

    public final String getUTILPSDE8ID() {
        return this.GetParamStringValue(TAG_UTILPSDE8ID, "");
    }

    public final void setUTILPSDE8ID(String strValue) {
        this.SetParamValue(TAG_UTILPSDE8ID, strValue);
    }

    public final boolean isUTILPSDE8NAMENull() {
        return this.IsParamNull(TAG_UTILPSDE8NAME);
    }

    public final String getUTILPSDE8NAME() {
        return this.GetParamStringValue(TAG_UTILPSDE8NAME, "");
    }

    public final void setUTILPSDE8NAME(String strValue) {
        this.SetParamValue(TAG_UTILPSDE8NAME, strValue);
    }

    public final boolean isUTILPSDE9IDNull() {
        return this.IsParamNull(TAG_UTILPSDE9ID);
    }

    public final String getUTILPSDE9ID() {
        return this.GetParamStringValue(TAG_UTILPSDE9ID, "");
    }

    public final void setUTILPSDE9ID(String strValue) {
        this.SetParamValue(TAG_UTILPSDE9ID, strValue);
    }

    public final boolean isUTILPSDE9NAMENull() {
        return this.IsParamNull(TAG_UTILPSDE9NAME);
    }

    public final String getUTILPSDE9NAME() {
        return this.GetParamStringValue(TAG_UTILPSDE9NAME, "");
    }

    public final void setUTILPSDE9NAME(String strValue) {
        this.SetParamValue(TAG_UTILPSDE9NAME, strValue);
    }
}

