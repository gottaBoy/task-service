/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDELogicParam
extends BaseDataEntity {
    public static final int PARAMTYPE_COMMON = 0;
    public static final int PARAMTYPE_GLOBAL = 1;
    public static final int PARAMTYPE_ENV = 2;
    public static final int PARAMTYPE_LAST = 3;
    public static final int PARAMTYPE_LASTRETURN = 4;
    public static final int PARAMTYPE_FILTER = 5;
    public static final int PARAMTYPE_ENTITYLIST = 6;
    public static final int PARAMTYPE_ENTITYPAGE = 7;
    public static final int PARAMTYPE_FILE = 8;
    public static final int PARAMTYPE_FILELIST = 9;
    public static final int PARAMTYPE_SIMPLE = 10;
    public static final int PARAMTYPE_SIMPLELIST = 11;
    public static final int PARAMTYPE_ENTITYMAP = 12;
    public static final int PARAMTYPE_APPCONTEXT = 24;
    public static final int PARAMTYPE_WEBCONTEXT = 31;
    public static final int PARAMTYPE_WEBRESPONSE = 32;
    public static final int PARAMTYPE_APPGLOBAL = 27;
    public static final int PARAMTYPE_APPLICATION = 30;
    public static final String TAG_PSDELOGICPARAMID = "PSDELOGICPARAMID";
    public static final String TAG_PSDELOGICPARAMNAME = "PSDELOGICPARAMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDELOGICID = "PSDELOGICID";
    public static final String TAG_PSDELOGICNAME = "PSDELOGICNAME";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PARAMPSDEID = "PARAMPSDEID";
    public static final String TAG_PARAMPSDENAME = "PARAMPSDENAME";
    public static final String TAG_DEFAULTPARAM = "DEFAULTPARAM";
    public static final String TAG_GLOBALPARAM = "GLOBALPARAM";
    public static final String TAG_PARAMTAG = "PARAMTAG";
    public static final String TAG_PARAMTAG2 = "PARAMTAG2";
    public static final String TAG_REFPARAMNAME = "REFPARAMNAME";
    public static final String TAG_REFFIELDNAME = "REFFIELDNAME";
    public static final String TAG_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String TAG_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String TAG_FILETYPE = "FILETYPE";
    public static final String TAG_FILEURL = "FILEURL";
    public static final String TAG_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String TAG_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String TAG_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String TAG_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String TAG_PARAMS = "PARAMS";
    public static final String TAG_USERPARAMS = "USERPARAMS";
    public static final String TAG_STDDATATYPE = "STDDATATYPE";
    public static final String TAG_DEFAULTVALUE = "DEFAULTVALUE";
    public static final String TAG_DEFAULTVALUETYPE = "DEFAULTVALUETYPE";
    public static final String TAG_CLONEPARAMFLAG = "CLONEPARAMFLAG";
    public static final String TAG_ORIGINENTITYFLAG = "ORIGINENTITYFLAG";
    public static final String TAG_PSSYSRESOURCEID = "PSSYSRESOURCEID";
    public static final String TAG_PSSYSRESOURCENAME = "PSSYSRESOURCENAME";
    public static final String TAG_PARAMPSDEFGROUPID = "PARAMPSDEFGROUPID";
    public static final String TAG_PARAMPSDEFGROUPNAME = "PARAMPSDEFGROUPNAME";
    public static final String TAG_PSSYSTRANSLATORID = "PSSYSTRANSLATORID";
    public static final String TAG_PSSYSTRANSLATORNAME = "PSSYSTRANSLATORNAME";

    public final boolean isPSDELOGICPARAMIDNull() {
        return this.IsParamNull(TAG_PSDELOGICPARAMID);
    }

    public final String getPSDELOGICPARAMID() {
        return this.GetParamStringValue(TAG_PSDELOGICPARAMID, "");
    }

    public final void setPSDELOGICPARAMID(String strValue) {
        this.SetParamValue(TAG_PSDELOGICPARAMID, strValue);
    }

    public final boolean isPSDELOGICPARAMNAMENull() {
        return this.IsParamNull(TAG_PSDELOGICPARAMNAME);
    }

    public final String getPSDELOGICPARAMNAME() {
        return this.GetParamStringValue(TAG_PSDELOGICPARAMNAME, "");
    }

    public final void setPSDELOGICPARAMNAME(String strValue) {
        this.SetParamValue(TAG_PSDELOGICPARAMNAME, strValue);
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

    public final boolean isPSDELOGICIDNull() {
        return this.IsParamNull(TAG_PSDELOGICID);
    }

    public final String getPSDELOGICID() {
        return this.GetParamStringValue(TAG_PSDELOGICID, "");
    }

    public final void setPSDELOGICID(String strValue) {
        this.SetParamValue(TAG_PSDELOGICID, strValue);
    }

    public final boolean isPSDELOGICNAMENull() {
        return this.IsParamNull(TAG_PSDELOGICNAME);
    }

    public final String getPSDELOGICNAME() {
        return this.GetParamStringValue(TAG_PSDELOGICNAME, "");
    }

    public final void setPSDELOGICNAME(String strValue) {
        this.SetParamValue(TAG_PSDELOGICNAME, strValue);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isPARAMPSDEIDNull() {
        return this.IsParamNull(TAG_PARAMPSDEID);
    }

    public final String getPARAMPSDEID() {
        return this.GetParamStringValue(TAG_PARAMPSDEID, "");
    }

    public final void setPARAMPSDEID(String strValue) {
        this.SetParamValue(TAG_PARAMPSDEID, strValue);
    }

    public final boolean isPARAMPSDENAMENull() {
        return this.IsParamNull(TAG_PARAMPSDENAME);
    }

    public final String getPARAMPSDENAME() {
        return this.GetParamStringValue(TAG_PARAMPSDENAME, "");
    }

    public final void setPARAMPSDENAME(String strValue) {
        this.SetParamValue(TAG_PARAMPSDENAME, strValue);
    }

    public final boolean isDEFAULTPARAMNull() {
        return this.IsParamNull(TAG_DEFAULTPARAM);
    }

    public final boolean getDEFAULTPARAM() {
        return this.GetParamIntValue(TAG_DEFAULTPARAM, 0) == 1;
    }

    public final void setDEFAULTPARAM(boolean bValue) {
        this.SetParamValue(TAG_DEFAULTPARAM, bValue ? 1 : 0);
    }

    public final boolean isGLOBALPARAMNull() {
        return this.IsParamNull(TAG_GLOBALPARAM);
    }

    public final int getGLOBALPARAM() {
        return this.GetParamIntValue(TAG_GLOBALPARAM, 0);
    }

    public final void setGLOBALPARAM(int nValue) {
        this.SetParamValue(TAG_GLOBALPARAM, nValue);
    }

    public final boolean isPARAMTAGNull() {
        return this.IsParamNull(TAG_PARAMTAG);
    }

    public final String getPARAMTAG() {
        return this.GetParamStringValue(TAG_PARAMTAG, "");
    }

    public final void setPARAMTAG(String strValue) {
        this.SetParamValue(TAG_PARAMTAG, strValue);
    }

    public final boolean isPARAMTAG2Null() {
        return this.IsParamNull(TAG_PARAMTAG2);
    }

    public final String getPARAMTAG2() {
        return this.GetParamStringValue(TAG_PARAMTAG2, "");
    }

    public final void setPARAMTAG2(String strValue) {
        this.SetParamValue(TAG_PARAMTAG2, strValue);
    }

    public final boolean isREFPARAMNAMENull() {
        return this.IsParamNull(TAG_REFPARAMNAME);
    }

    public final String getREFPARAMNAME() {
        return this.GetParamStringValue(TAG_REFPARAMNAME, "");
    }

    public final void setREFPARAMNAME(String strValue) {
        this.SetParamValue(TAG_REFPARAMNAME, strValue);
    }

    public final boolean isREFFIELDNAMENull() {
        return this.IsParamNull(TAG_REFFIELDNAME);
    }

    public final String getREFFIELDNAME() {
        return this.GetParamStringValue(TAG_REFFIELDNAME, "");
    }

    public final void setREFFIELDNAME(String strValue) {
        this.SetParamValue(TAG_REFFIELDNAME, strValue);
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

    public final boolean isFILETYPENull() {
        return this.IsParamNull(TAG_FILETYPE);
    }

    public final String getFILETYPE() {
        return this.GetParamStringValue(TAG_FILETYPE, "");
    }

    public final void setFILETYPE(String strValue) {
        this.SetParamValue(TAG_FILETYPE, strValue);
    }

    public final boolean isFILEURLNull() {
        return this.IsParamNull(TAG_FILEURL);
    }

    public final String getFILEURL() {
        return this.GetParamStringValue(TAG_FILEURL, "");
    }

    public final void setFILEURL(String strValue) {
        this.SetParamValue(TAG_FILEURL, strValue);
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

    public final boolean isPSSYSSFPLUGINIDNull() {
        return this.IsParamNull(TAG_PSSYSSFPLUGINID);
    }

    public final String getPSSYSSFPLUGINID() {
        return this.GetParamStringValue(TAG_PSSYSSFPLUGINID, "");
    }

    public final void setPSSYSSFPLUGINID(String strValue) {
        this.SetParamValue(TAG_PSSYSSFPLUGINID, strValue);
    }

    public final boolean isPSSYSSFPLUGINNAMENull() {
        return this.IsParamNull(TAG_PSSYSSFPLUGINNAME);
    }

    public final String getPSSYSSFPLUGINNAME() {
        return this.GetParamStringValue(TAG_PSSYSSFPLUGINNAME, "");
    }

    public final void setPSSYSSFPLUGINNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSSFPLUGINNAME, strValue);
    }

    public final boolean isPARAMSNull() {
        return this.IsParamNull(TAG_PARAMS);
    }

    public final String getPARAMS() {
        return this.GetParamStringValue(TAG_PARAMS, "");
    }

    public final void setPARAMS(String strValue) {
        this.SetParamValue(TAG_PARAMS, strValue);
    }

    public final boolean isUSERPARAMSNull() {
        return this.IsParamNull(TAG_USERPARAMS);
    }

    public final String getUSERPARAMS() {
        return this.GetParamStringValue(TAG_USERPARAMS, "");
    }

    public final void setUSERPARAMS(String strValue) {
        this.SetParamValue(TAG_USERPARAMS, strValue);
    }

    public final boolean isSTDDATATYPENull() {
        return this.IsParamNull(TAG_STDDATATYPE);
    }

    public final int getSTDDATATYPE() {
        return this.GetParamIntValue(TAG_STDDATATYPE, 0);
    }

    public final void setSTDDATATYPE(int nValue) {
        this.SetParamValue(TAG_STDDATATYPE, nValue);
    }

    public final boolean isDEFAULTVALUENull() {
        return this.IsParamNull(TAG_DEFAULTVALUE);
    }

    public final String getDEFAULTVALUE() {
        return this.GetParamStringValue(TAG_DEFAULTVALUE, "");
    }

    public final void setDEFAULTVALUE(String strValue) {
        this.SetParamValue(TAG_DEFAULTVALUE, strValue);
    }

    public final boolean isDEFAULTVALUETYPENull() {
        return this.IsParamNull(TAG_DEFAULTVALUETYPE);
    }

    public final String getDEFAULTVALUETYPE() {
        return this.GetParamStringValue(TAG_DEFAULTVALUETYPE, "");
    }

    public final void setDEFAULTVALUETYPE(String strValue) {
        this.SetParamValue(TAG_DEFAULTVALUETYPE, strValue);
    }

    public final boolean isCLONEPARAMFLAGNull() {
        return this.IsParamNull(TAG_CLONEPARAMFLAG);
    }

    public final boolean getCLONEPARAMFLAG() {
        return this.GetParamIntValue(TAG_CLONEPARAMFLAG, 0) == 1;
    }

    public final void setCLONEPARAMFLAG(boolean bValue) {
        this.SetParamValue(TAG_CLONEPARAMFLAG, bValue ? 1 : 0);
    }

    public final boolean isORIGINENTITYFLAGNull() {
        return this.IsParamNull(TAG_ORIGINENTITYFLAG);
    }

    public final boolean getORIGINENTITYFLAG() {
        return this.GetParamIntValue(TAG_ORIGINENTITYFLAG, 0) == 1;
    }

    public final void setORIGINENTITYFLAG(boolean bValue) {
        this.SetParamValue(TAG_ORIGINENTITYFLAG, bValue ? 1 : 0);
    }

    public final boolean isPSSYSRESOURCEIDNull() {
        return this.IsParamNull(TAG_PSSYSRESOURCEID);
    }

    public final String getPSSYSRESOURCEID() {
        return this.GetParamStringValue(TAG_PSSYSRESOURCEID, "");
    }

    public final void setPSSYSRESOURCEID(String strValue) {
        this.SetParamValue(TAG_PSSYSRESOURCEID, strValue);
    }

    public final boolean isPSSYSRESOURCENAMENull() {
        return this.IsParamNull(TAG_PSSYSRESOURCENAME);
    }

    public final String getPSSYSRESOURCENAME() {
        return this.GetParamStringValue(TAG_PSSYSRESOURCENAME, "");
    }

    public final void setPSSYSRESOURCENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSRESOURCENAME, strValue);
    }

    public final boolean isPARAMPSDEFGROUPIDNull() {
        return this.IsParamNull(TAG_PARAMPSDEFGROUPID);
    }

    public final String getPARAMPSDEFGROUPID() {
        return this.GetParamStringValue(TAG_PARAMPSDEFGROUPID, "");
    }

    public final void setPARAMPSDEFGROUPID(String strValue) {
        this.SetParamValue(TAG_PARAMPSDEFGROUPID, strValue);
    }

    public final boolean isPARAMPSDEFGROUPNAMENull() {
        return this.IsParamNull(TAG_PARAMPSDEFGROUPNAME);
    }

    public final String getPARAMPSDEFGROUPNAME() {
        return this.GetParamStringValue(TAG_PARAMPSDEFGROUPNAME, "");
    }

    public final void setPARAMPSDEFGROUPNAME(String strValue) {
        this.SetParamValue(TAG_PARAMPSDEFGROUPNAME, strValue);
    }

    public final boolean isPSSYSTRANSLATORIDNull() {
        return this.IsParamNull(TAG_PSSYSTRANSLATORID);
    }

    public final String getPSSYSTRANSLATORID() {
        return this.GetParamStringValue(TAG_PSSYSTRANSLATORID, "");
    }

    public final void setPSSYSTRANSLATORID(String strValue) {
        this.SetParamValue(TAG_PSSYSTRANSLATORID, strValue);
    }

    public final boolean isPSSYSTRANSLATORNAMENull() {
        return this.IsParamNull(TAG_PSSYSTRANSLATORNAME);
    }

    public final String getPSSYSTRANSLATORNAME() {
        return this.GetParamStringValue(TAG_PSSYSTRANSLATORNAME, "");
    }

    public final void setPSSYSTRANSLATORNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSTRANSLATORNAME, strValue);
    }
}

