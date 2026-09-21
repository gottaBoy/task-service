/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFDA.PS.Data.PSDEFInputTip;
import SA.SRFDA.PS.Data.PSDEFSearchMode;
import SA.SRFDA.PS.Data.PSDEFUIMode;
import SA.SRFDA.PS.Data.PSDEFValueRule;
import SA.SRFDA.PS.Data.PSSysSearchDEField;
import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.ArrayList;
import java.util.Date;

public class PSDEField
extends BaseDataEntity {
    public static final int DEFTYPE_PHISICAL = 1;
    public static final int DEFTYPE_FORMULA = 2;
    public static final int DEFTYPE_LINK = 3;
    public static final int DEFTYPE_DYNASTORAGE = 4;
    public static final int DEFTYPE_UI = 5;
    public static final int PKEY_NONE = 0;
    public static final int PKEY_PKEY = 1;
    public static final int PKEY_UNITAG = 2;
    public static final int MAJOR_NONE = 0;
    public static final int MAJOR_MAJOR = 1;
    public static final int MAJOR_KEYNAME = 2;
    public static final int ENABLEUSERINPUT_NONE = 0;
    public static final int ENABLEUSERINPUT_INSERT = 1;
    public static final int ENABLEUSERINPUT_UPDATE = 2;
    public static final int ENABLEUSERINPUT_ALL = 3;
    public static final String STRINGCASE_UCASE = "UCASE";
    public static final String STRINGCASE_LCASE = "LCASE";
    public static final String DATATYPE_TEXT = "TEXT";
    public static final String DATATYPE_GUID = "GUID";
    public static final String DATATYPE_LONGTEXT_1000 = "LONGTEXT_1000";
    public static final String DATATYPE_LONGTEXT = "LONGTEXT";
    public static final String DATATYPE_HTMLTEXT = "HTMLTEXT";
    public static final String DATATYPE_INT = "INT";
    public static final String DATATYPE_SBID = "SBID";
    public static final String DATATYPE_NBID = "NBID";
    public static final String DATATYPE_FLOAT = "FLOAT";
    public static final String DATATYPE_DECIMAL = "DECIMAL";
    public static final String DATATYPE_DATE = "DATE";
    public static final String DATATYPE_TIME = "TIME";
    public static final String DATATYPE_DATETIME = "DATETIME";
    public static final String DATATYPE_SSCODELIST = "SSCODELIST";
    public static final String DATATYPE_SMCODELIST = "SMCODELIST";
    public static final String DATATYPE_NSCODELIST = "NSCODELIST";
    public static final String DATATYPE_NMCODELIST = "NMCODELIST";
    public static final String DATATYPE_PICKUP = "PICKUP";
    public static final String DATATYPE_PICKUPTEXT = "PICKUPTEXT";
    public static final String DATATYPE_PICKUPDATA = "PICKUPDATA";
    public static final String DATATYPE_INHERIT = "INHERIT";
    public static final String DATATYPE_YESNO = "YESNO";
    public static final String DATATYPE_TRUEFALSE = "TRUEFALSE";
    public static final String DATATYPE_CURRENCY = "CURRENCY";
    public static final String DATATYPE_CURRENCYUNIT = "CURRENCYUNIT";
    public static final String DATATYPE_WFSTATE = "WFSTATE";
    public static final String DATATYPE_DATETIME_BIRTHDAY = "DATETIME_BIRTHDAY";
    public static final String DATATYPE_TEXT_EMAIL = "TEXT_EMAIL";
    public static final String DATATYPE_BINARY = "BINARY";
    public static final String DATATYPE_ONE2MANYDATA = "ONE2MANYDATA";
    public static final String UPDATEOVMODE_ALWAYS = "ALWAYS";
    public static final String UPDATEOVMODE_NOTEXISTS = "NOTEXISTS";
    public static final String PREDEFINETYPE_LOGICVALID = "LOGICVALID";
    public static final String PREDEFINETYPE_CREATEMAN = "CREATEMAN";
    public static final String PREDEFINETYPE_CREATEDATE = "CREATEDATE";
    public static final String PREDEFINETYPE_UPDATEMAN = "UPDATEMAN";
    public static final String PREDEFINETYPE_UPDATEDATE = "UPDATEDATE";
    public static final String PREDEFINETYPE_ORGID = "ORGID";
    public static final String PREDEFINETYPE_ORGSECTORID = "ORGSECTORID";
    public static final String PREDEFINETYPE_ORGNAME = "ORGNAME";
    public static final String PREDEFINETYPE_ORGSECTORNAME = "ORGSECTORNAME";
    public static final String PREDEFINETYPE_ORDERVALUE = "ORDERVALUE";
    public static final String PREDEFINETYPE_DATATYPE = "DATATYPE";
    public static final String PREDEFINETYPE_VERSION = "VERSION";
    public static final String PREDEFINETYPE_NONE = "NONE";
    public static final String UNIONKEYVALUE_KEY1 = "KEY1";
    public static final String UNIONKEYVALUE_KEY2 = "KEY2";
    public static final String UNIONKEYVALUE_KEY3 = "KEY3";
    public static final String UNIONKEYVALUE_KEY4 = "KEY4";
    public static final String DUPCHECKMODE_NONE = "NONE";
    public static final String DUPCHECKMODE_ALL = "ALL";
    public static final String DUPCHECKMODE_NOTNULL = "NOTNULL";
    public static final String DVT_SESSION = "SESSION";
    public static final String DVT_APPLICATION = "APPLICATION";
    public static final String DVT_UNIQUEID = "UNIQUEID";
    public static final String DVT_CONTEXT = "CONTEXT";
    public static final String DVT_PARAM = "PARAM";
    public static final String DVT_OPERATOR = "OPERATOR";
    public static final String DVT_OPERATORNAME = "OPERATORNAME";
    public static final String DVT_CURTIME = "CURTIME";
    public static final String STATEFIELD_STATE1 = "STATE1";
    public static final String STATEFIELD_STATE2 = "STATE2";
    public static final String STATEFIELD_STATE3 = "STATE3";
    public static final String TAG_PSDEFIELDID = "PSDEFIELDID";
    public static final String TAG_PSDEFIELDNAME = "PSDEFIELDNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_LENGTH = "LENGTH";
    public static final String TAG_DEFTYPE = "DEFTYPE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_ALLOWEMPTY = "ALLOWEMPTY";
    public static final String TAG_PKEY = "PKEY";
    public static final String TAG_MAJORFIELD = "MAJORFIELD";
    public static final String TAG_TABLENAME = "TABLENAME";
    public static final String TAG_PSCODELISTID = "PSCODELISTID";
    public static final String TAG_PSCODELISTNAME = "PSCODELISTNAME";
    public static final String TAG_UPDATEOVMODE = "UPDATEOVMODE";
    @Deprecated
    public static final String TAG_PREDEFINETYPE = "PREDEFINETYPE";
    @Deprecated
    public static final String TAG_PRECISION2 = "PRECISION2";
    public static final String TAG_PREDEFINEDTYPE = "PREDEFINEDTYPE";
    public static final String TAG_PRECISION = "PRECISION";
    public static final String TAG_AUDITINFOFORMAT = "AUDITINFOFORMAT";
    public static final String TAG_ENABLEAUDIT = "ENABLEAUDIT";
    public static final String TAG_PASTERESET = "PASTERESET";
    public static final String TAG_UNITWIDTH = "UNITWIDTH";
    public static final String TAG_UNIT = "UNIT";
    public static final String TAG_ENABLEUSERINPUT = "ENABLEUSERINPUT";
    public static final String TAG_STRINGCASE = "STRINGCASE";
    public static final String TAG_DEFAULTVALUE = "DEFAULTVALUE";
    public static final String TAG_PSDERID = "PSDERID";
    public static final String TAG_PSDERNAME = "PSDERNAME";
    public static final String TAG_DERPSDEFID = "DERPSDEFID";
    public static final String TAG_DERPSDEFNAME = "DERPSDEFNAME";
    public static final String TAG_PHYSICALFIELD = "PHYSICALFIELD";
    public static final String TAG_PSDATATYPEID = "PSDATATYPEID";
    public static final String TAG_PSDATATYPENAME = "PSDATATYPENAME";
    public static final String TAG_FKEY = "FKEY";
    public static final String TAG_VALUEFORMAT = "VALUEFORMAT";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_ENABLEQS = "ENABLEQS";
    public static final String TAG_UNIONKEYVALUE = "UNIONKEYVALUE";
    public static final String TAG_INDEXTYPE = "INDEXTYPE";
    public static final String TAG_MULTIFORMFIELD = "MULTIFORMFIELD";
    public static final String TAG_FORMULAFORMAT = "FORMULAFORMAT";
    public static final String TAG_FORMULAFIELDS = "FORMULAFIELDS";
    public static final String TAG_DUPCHECKMODE = "DUPCHECKMODE";
    public static final String TAG_DUPCHECKVALUES = "DUPCHECKVALUES";
    public static final String TAG_DUPCHKPSDEFID = "DUPCHKPSDEFID";
    public static final String TAG_DUPCHKPSDEFNAME = "DUPCHKPSDEFNAME";
    public static final String TAG_PSSYSVALUERULEID = "PSSYSVALUERULEID";
    public static final String TAG_PSSYSVALUERULENAME = "PSSYSVALUERULENAME";
    public static final String TAG_DVT = "DVT";
    public static final String TAG_QUERYCOLUMN = "QUERYCOLUMN";
    public static final String TAG_DBVALUEMODE = "DBVALUEMODE";
    public static final String TAG_STATEFIELD = "STATEFIELD";
    public static final String TAG_IMPORTKEY = "IMPORTKEY";
    public static final String TAG_IMPORTORDER = "IMPORTORDER";
    public static final String TAG_IMPORTTAG = "IMPORTTAG";
    public static final String TAG_EXTENDMODE = "EXTENDMODE";
    public static final String TAG_ENAWRITEBACK = "ENAWRITEBACK";
    public static final String TAG_STRLENGTH = "STRLENGTH";
    public static final String TAG_USERPARAMS = "USERPARAMS";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_TESTDATA = "TESTDATA";
    public static final String TAG_PSSYSSAMPLEVALUEID = "PSSYSSAMPLEVALUEID";
    public static final String TAG_PSSYSSAMPLEVALUENAME = "PSSYSSAMPLEVALUENAME";
    public static final String TAG_UNICODECHAR = "UNICODECHAR";
    public static final String TAG_ENABLECOLPRIV = "ENABLECOLPRIV";
    public static final String TAG_QUERYCS = "QUERYCS";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_ENABLETEMPDATA = "ENABLETEMPDATA";
    public static final String TAG_LNPSLANRESID = "LNPSLANRESID";
    public static final String TAG_LNPSLANRESNAME = "LNPSLANRESNAME";
    public static final String TAG_PSSYSUNITID = "PSSYSUNITID";
    public static final String TAG_PSSYSUNITNAME = "PSSYSUNITNAME";
    public static final String TAG_CHECKRECURSION = "CHECKRECURSION";
    public static final String TAG_VIEWCOLLEVEL = "VIEWCOLLEVEL";
    public static final String TAG_BIZTAG = "BIZTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_DBVALUEMODE2 = "DBVALUEMODE2";
    public static final String TAG_NO2DUPCHKPSDEFID = "NO2DUPCHKPSDEFID";
    public static final String TAG_NO2DUPCHKPSDEFNAME = "NO2DUPCHKPSDEFNAME";
    public static final String TAG_NO3DUPCHKPSDEFID = "NO3DUPCHKPSDEFID";
    public static final String TAG_NO3DUPCHKPSDEFNAME = "NO3DUPCHKPSDEFNAME";
    public static final String TAG_NULLVALORDER = "NULLVALORDER";
    public static final String TAG_SERVICECODENAME = "SERVICECODENAME";
    public static final String TAG_PSDETABLEID = "PSDETABLEID";
    public static final String TAG_PSSYSDBCOLUMNID = "PSSYSDBCOLUMNID";
    public static final String TAG_PSSUBSYSSADEFIELDID = "PSSUBSYSSADEFIELDID";
    public static final String TAG_PSSUBSYSSADEFIELDNAME = "PSSUBSYSSADEFIELDNAME";
    public static final String TAG_O2MPSDERID = "O2MPSDERID";
    public static final String TAG_O2MPSDERNAME = "O2MPSDERNAME";
    public static final String TAG_MAXVALUE = "MAXVALUE";
    public static final String TAG_MINVALUE = "MINVALUE";
    public static final String TAG_MINSTRLENGTH = "MINSTRLENGTH";
    public static final String TAG_READONLYMODE = "READONLYMODE";
    public static final String TAG_PSSYSSEQUENCEID = "PSSYSSEQUENCEID";
    public static final String TAG_PSSYSSEQUENCENAME = "PSSYSSEQUENCENAME";
    public static final String TAG_SEQUENCEMODE = "SEQUENCEMODE";
    public static final String TAG_COMPUTEEXP = "COMPUTEEXP";
    public static final String TAG_TRANSLATORMODE = "TRANSLATORMODE";
    public static final String TAG_PSSYSTRANSLATORID = "PSSYSTRANSLATORID";
    public static final String TAG_PSSYSTRANSLATORNAME = "PSSYSTRANSLATORNAME";
    public static final String TAG_O2OPSDERID = "O2OPSDERID";
    public static final String TAG_O2OPSDERNAME = "O2OPSDERNAME";
    public static final String TAG_RESTRICTEDPSDEFID = "RESTRICTEDPSDEFID";
    public static final String TAG_RESTRICTEDPSDEFNAME = "RESTRICTEDPSDEFNAME";
    public static final String TAG_VALUEPSDEFID = "VALUEPSDEFID";
    public static final String TAG_VALUEPSDEFNAME = "VALUEPSDEFNAME";
    public static final String TAG_JSFORMAT = "JSFORMAT";
    public static final String TAG_JSONFORMAT = "JSONFORMAT";
    public static final String TAG_REFPSSYSDYNAMODELID = "REFPSSYSDYNAMODELID";
    public static final String TAG_REFPSSYSDYNAMODELNAME = "REFPSSYSDYNAMODELNAME";
    public static final String TAG_FIELDTAG = "FIELDTAG";
    public static final String TAG_FIELDTAG2 = "FIELDTAG2";
    public static final String TAG_IMPPSSYSTRANSLATORID = "IMPPSSYSTRANSLATORID";
    public static final String TAG_IMPPSSYSTRANSLATORNAME = "IMPPSSYSTRANSLATORNAME";
    public static final String TAG_EXPPSSYSTRANSLATORID = "EXPPSSYSTRANSLATORID";
    public static final String TAG_EXPPSSYSTRANSLATORNAME = "EXPPSSYSTRANSLATORNAME";
    public static final String TAG_PREDEFINEDTYPEPARAM = "PREDEFINEDTYPEPARAM";
    private ArrayList<PSDEFUIMode> psDEFUIModeList = null;
    private ArrayList<PSDEFValueRule> psDEFValueRuleList = null;
    private ArrayList<PSDEFSearchMode> psDEFSearchModeList = null;
    private ArrayList<PSDEFInputTip> psDEFInputTipList = null;
    private ArrayList<PSSysSearchDEField> psSysSearchDEFieldList = null;

    public final boolean isPSDEFIELDIDNull() {
        return this.IsParamNull(TAG_PSDEFIELDID);
    }

    public final String getPSDEFIELDID() {
        return this.GetParamStringValue(TAG_PSDEFIELDID, "");
    }

    public final void setPSDEFIELDID(String strValue) {
        this.SetParamValue(TAG_PSDEFIELDID, strValue);
    }

    public final boolean isPSDEFIELDNAMENull() {
        return this.IsParamNull(TAG_PSDEFIELDNAME);
    }

    public final String getPSDEFIELDNAME() {
        return this.GetParamStringValue(TAG_PSDEFIELDNAME, "");
    }

    public final void setPSDEFIELDNAME(String strValue) {
        this.SetParamValue(TAG_PSDEFIELDNAME, strValue);
    }

    public final boolean isCREATEMANNull() {
        return this.IsParamNull("CREATEMAN");
    }

    public final String getCREATEMAN() {
        return this.GetParamStringValue("CREATEMAN", "");
    }

    public final void setCREATEMAN(String strValue) {
        this.SetParamValue("CREATEMAN", strValue);
    }

    public final boolean isCREATEDATENull() {
        return this.IsParamNull("CREATEDATE");
    }

    public final Date getCREATEDATE() {
        return this.GetParamDateValue("CREATEDATE", null);
    }

    public final void setCREATEDATE(Date dtValue) {
        this.SetParamValue("CREATEDATE", dtValue);
    }

    public final boolean isUPDATEMANNull() {
        return this.IsParamNull("UPDATEMAN");
    }

    public final String getUPDATEMAN() {
        return this.GetParamStringValue("UPDATEMAN", "");
    }

    public final void setUPDATEMAN(String strValue) {
        this.SetParamValue("UPDATEMAN", strValue);
    }

    public final boolean isUPDATEDATENull() {
        return this.IsParamNull("UPDATEDATE");
    }

    public final Date getUPDATEDATE() {
        return this.GetParamDateValue("UPDATEDATE", null);
    }

    public final void setUPDATEDATE(Date dtValue) {
        this.SetParamValue("UPDATEDATE", dtValue);
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

    public final boolean isLOGICNAMENull() {
        return this.IsParamNull(TAG_LOGICNAME);
    }

    public final String getLOGICNAME() {
        return this.GetParamStringValue(TAG_LOGICNAME, "");
    }

    public final void setLOGICNAME(String strValue) {
        this.SetParamValue(TAG_LOGICNAME, strValue);
    }

    public final boolean isLENGTHNull() {
        return this.IsParamNull(TAG_LENGTH);
    }

    public final int getLENGTH() {
        return this.GetParamIntValue(TAG_LENGTH, 0);
    }

    public final void setLENGTH(int nValue) {
        this.SetParamValue(TAG_LENGTH, nValue);
    }

    public final boolean isDEFTYPENull() {
        return this.IsParamNull(TAG_DEFTYPE);
    }

    public final int getDEFTYPE() {
        return this.GetParamIntValue(TAG_DEFTYPE, 0);
    }

    public final void setDEFTYPE(int nValue) {
        this.SetParamValue(TAG_DEFTYPE, nValue);
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

    public final boolean isALLOWEMPTYNull() {
        return this.IsParamNull(TAG_ALLOWEMPTY);
    }

    public final boolean getALLOWEMPTY() {
        return this.GetParamIntValue(TAG_ALLOWEMPTY, 0) == 1;
    }

    public final void setALLOWEMPTY(boolean bValue) {
        this.SetParamValue(TAG_ALLOWEMPTY, bValue ? 1 : 0);
    }

    public final boolean isPKEYNull() {
        return this.IsParamNull(TAG_PKEY);
    }

    public final int getPKEY() {
        return this.GetParamIntValue(TAG_PKEY, 0);
    }

    public final void setPKEY(int nValue) {
        this.SetParamValue(TAG_PKEY, nValue);
    }

    public final boolean isMAJORFIELDNull() {
        return this.IsParamNull(TAG_MAJORFIELD);
    }

    public final int getMAJORFIELD() {
        return this.GetParamIntValue(TAG_MAJORFIELD, 0);
    }

    public final void setMAJORFIELD(int nValue) {
        this.SetParamValue(TAG_MAJORFIELD, nValue);
    }

    public final boolean isTABLENAMENull() {
        return this.IsParamNull(TAG_TABLENAME);
    }

    public final String getTABLENAME() {
        return this.GetParamStringValue(TAG_TABLENAME, "");
    }

    public final void setTABLENAME(String strValue) {
        this.SetParamValue(TAG_TABLENAME, strValue);
    }

    public final boolean isPSCODELISTIDNull() {
        return this.IsParamNull(TAG_PSCODELISTID);
    }

    public final String getPSCODELISTID() {
        return this.GetParamStringValue(TAG_PSCODELISTID, "");
    }

    public final void setPSCODELISTID(String strValue) {
        this.SetParamValue(TAG_PSCODELISTID, strValue);
    }

    public final boolean isPSCODELISTNAMENull() {
        return this.IsParamNull(TAG_PSCODELISTNAME);
    }

    public final String getPSCODELISTNAME() {
        return this.GetParamStringValue(TAG_PSCODELISTNAME, "");
    }

    public final void setPSCODELISTNAME(String strValue) {
        this.SetParamValue(TAG_PSCODELISTNAME, strValue);
    }

    public final boolean isUPDATEOVMODENull() {
        return this.IsParamNull(TAG_UPDATEOVMODE);
    }

    public final String getUPDATEOVMODE() {
        return this.GetParamStringValue(TAG_UPDATEOVMODE, "");
    }

    public final void setUPDATEOVMODE(String strValue) {
        this.SetParamValue(TAG_UPDATEOVMODE, strValue);
    }

    public final boolean isPREDEFINETYPENull() {
        return this.IsParamNull(TAG_PREDEFINETYPE);
    }

    public final String getPREDEFINETYPE() {
        return this.GetParamStringValue(TAG_PREDEFINETYPE, "");
    }

    public final void setPREDEFINETYPE(String strValue) {
        this.SetParamValue(TAG_PREDEFINETYPE, strValue);
    }

    public final boolean isPRECISION2Null() {
        return this.IsParamNull(TAG_PRECISION2);
    }

    public final int getPRECISION2() {
        return this.GetParamIntValue(TAG_PRECISION2, 0);
    }

    public final void setPRECISION2(int nValue) {
        this.SetParamValue(TAG_PRECISION2, nValue);
    }

    public final boolean isAUDITINFOFORMATNull() {
        return this.IsParamNull(TAG_AUDITINFOFORMAT);
    }

    public final String getAUDITINFOFORMAT() {
        return this.GetParamStringValue(TAG_AUDITINFOFORMAT, "");
    }

    public final void setAUDITINFOFORMAT(String strValue) {
        this.SetParamValue(TAG_AUDITINFOFORMAT, strValue);
    }

    public final boolean isENABLEAUDITNull() {
        return this.IsParamNull(TAG_ENABLEAUDIT);
    }

    public final boolean getENABLEAUDIT() {
        return this.GetParamIntValue(TAG_ENABLEAUDIT, 0) == 1;
    }

    public final void setENABLEAUDIT(boolean bValue) {
        this.SetParamValue(TAG_ENABLEAUDIT, bValue ? 1 : 0);
    }

    public final boolean isPASTERESETNull() {
        return this.IsParamNull(TAG_PASTERESET);
    }

    public final boolean getPASTERESET() {
        return this.GetParamIntValue(TAG_PASTERESET, 0) == 1;
    }

    public final void setPASTERESET(boolean bValue) {
        this.SetParamValue(TAG_PASTERESET, bValue ? 1 : 0);
    }

    public final boolean isUNITWIDTHNull() {
        return this.IsParamNull(TAG_UNITWIDTH);
    }

    public final int getUNITWIDTH() {
        return this.GetParamIntValue(TAG_UNITWIDTH, 0);
    }

    public final void setUNITWIDTH(int nValue) {
        this.SetParamValue(TAG_UNITWIDTH, nValue);
    }

    public final boolean isUNITNull() {
        return this.IsParamNull(TAG_UNIT);
    }

    public final String getUNIT() {
        return this.GetParamStringValue(TAG_UNIT, "");
    }

    public final void setUNIT(String strValue) {
        this.SetParamValue(TAG_UNIT, strValue);
    }

    public final boolean isENABLEUSERINPUTNull() {
        return this.IsParamNull(TAG_ENABLEUSERINPUT);
    }

    public final int getENABLEUSERINPUT() {
        return this.GetParamIntValue(TAG_ENABLEUSERINPUT, 0);
    }

    public final void setENABLEUSERINPUT(int nValue) {
        this.SetParamValue(TAG_ENABLEUSERINPUT, nValue);
    }

    public final boolean isSTRINGCASENull() {
        return this.IsParamNull(TAG_STRINGCASE);
    }

    public final String getSTRINGCASE() {
        return this.GetParamStringValue(TAG_STRINGCASE, "");
    }

    public final void setSTRINGCASE(String strValue) {
        this.SetParamValue(TAG_STRINGCASE, strValue);
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

    public final boolean isPSDERIDNull() {
        return this.IsParamNull(TAG_PSDERID);
    }

    public final String getPSDERID() {
        return this.GetParamStringValue(TAG_PSDERID, "");
    }

    public final void setPSDERID(String strValue) {
        this.SetParamValue(TAG_PSDERID, strValue);
    }

    public final boolean isPSDERNAMENull() {
        return this.IsParamNull(TAG_PSDERNAME);
    }

    public final String getPSDERNAME() {
        return this.GetParamStringValue(TAG_PSDERNAME, "");
    }

    public final void setPSDERNAME(String strValue) {
        this.SetParamValue(TAG_PSDERNAME, strValue);
    }

    public final boolean isDERPSDEFIDNull() {
        return this.IsParamNull(TAG_DERPSDEFID);
    }

    public final String getDERPSDEFID() {
        return this.GetParamStringValue(TAG_DERPSDEFID, "");
    }

    public final void setDERPSDEFID(String strValue) {
        this.SetParamValue(TAG_DERPSDEFID, strValue);
    }

    public final boolean isDERPSDEFNAMENull() {
        return this.IsParamNull(TAG_DERPSDEFNAME);
    }

    public final String getDERPSDEFNAME() {
        return this.GetParamStringValue(TAG_DERPSDEFNAME, "");
    }

    public final void setDERPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_DERPSDEFNAME, strValue);
    }

    public final boolean isPHYSICALFIELDNull() {
        return this.IsParamNull(TAG_PHYSICALFIELD);
    }

    public final boolean getPHYSICALFIELD() {
        return this.GetParamIntValue(TAG_PHYSICALFIELD, 0) == 1;
    }

    public final void setPHYSICALFIELD(boolean bValue) {
        this.SetParamValue(TAG_PHYSICALFIELD, bValue ? 1 : 0);
    }

    public final boolean isPSDATATYPEIDNull() {
        return this.IsParamNull(TAG_PSDATATYPEID);
    }

    public final String getPSDATATYPEID() {
        return this.GetParamStringValue(TAG_PSDATATYPEID, "");
    }

    public final void setPSDATATYPEID(String strValue) {
        this.SetParamValue(TAG_PSDATATYPEID, strValue);
    }

    public final boolean isPSDATATYPENAMENull() {
        return this.IsParamNull(TAG_PSDATATYPENAME);
    }

    public final String getPSDATATYPENAME() {
        return this.GetParamStringValue(TAG_PSDATATYPENAME, "");
    }

    public final void setPSDATATYPENAME(String strValue) {
        this.SetParamValue(TAG_PSDATATYPENAME, strValue);
    }

    public final boolean isFKEYNull() {
        return this.IsParamNull(TAG_FKEY);
    }

    public final boolean getFKEY() {
        return this.GetParamIntValue(TAG_FKEY, 0) == 1;
    }

    public final void setFKEY(boolean bValue) {
        this.SetParamValue(TAG_FKEY, bValue ? 1 : 0);
    }

    public final boolean isVALUEFORMATNull() {
        return this.IsParamNull(TAG_VALUEFORMAT);
    }

    public final String getVALUEFORMAT() {
        return this.GetParamStringValue(TAG_VALUEFORMAT, "");
    }

    public final void setVALUEFORMAT(String strValue) {
        this.SetParamValue(TAG_VALUEFORMAT, strValue);
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

    public final boolean isENABLEQSNull() {
        return this.IsParamNull(TAG_ENABLEQS);
    }

    public final boolean getENABLEQS() {
        return this.GetParamIntValue(TAG_ENABLEQS, 0) == 1;
    }

    public final void setENABLEQS(boolean bValue) {
        this.SetParamValue(TAG_ENABLEQS, bValue ? 1 : 0);
    }

    public final boolean isUNIONKEYVALUENull() {
        return this.IsParamNull(TAG_UNIONKEYVALUE);
    }

    public final String getUNIONKEYVALUE() {
        return this.GetParamStringValue(TAG_UNIONKEYVALUE, "");
    }

    public final void setUNIONKEYVALUE(String strValue) {
        this.SetParamValue(TAG_UNIONKEYVALUE, strValue);
    }

    public final boolean isINDEXTYPENull() {
        return this.IsParamNull(TAG_INDEXTYPE);
    }

    public final boolean getINDEXTYPE() {
        return this.GetParamIntValue(TAG_INDEXTYPE, 0) == 1;
    }

    public final void setINDEXTYPE(boolean bValue) {
        this.SetParamValue(TAG_INDEXTYPE, bValue ? 1 : 0);
    }

    public final boolean isMULTIFORMFIELDNull() {
        return this.IsParamNull(TAG_MULTIFORMFIELD);
    }

    public final boolean getMULTIFORMFIELD() {
        return this.GetParamIntValue(TAG_MULTIFORMFIELD, 0) == 1;
    }

    public final void setMULTIFORMFIELD(boolean bValue) {
        this.SetParamValue(TAG_MULTIFORMFIELD, bValue ? 1 : 0);
    }

    public final boolean isFORMULAFORMATNull() {
        return this.IsParamNull(TAG_FORMULAFORMAT);
    }

    public final String getFORMULAFORMAT() {
        return this.GetParamStringValue(TAG_FORMULAFORMAT, "");
    }

    public final void setFORMULAFORMAT(String strValue) {
        this.SetParamValue(TAG_FORMULAFORMAT, strValue);
    }

    public final boolean isFORMULAFIELDSNull() {
        return this.IsParamNull(TAG_FORMULAFIELDS);
    }

    public final String getFORMULAFIELDS() {
        return this.GetParamStringValue(TAG_FORMULAFIELDS, "");
    }

    public final void setFORMULAFIELDS(String strValue) {
        this.SetParamValue(TAG_FORMULAFIELDS, strValue);
    }

    public final boolean isDUPCHECKMODENull() {
        return this.IsParamNull(TAG_DUPCHECKMODE);
    }

    public final String getDUPCHECKMODE() {
        return this.GetParamStringValue(TAG_DUPCHECKMODE, "");
    }

    public final void setDUPCHECKMODE(String strValue) {
        this.SetParamValue(TAG_DUPCHECKMODE, strValue);
    }

    public final boolean isDUPCHECKVALUESNull() {
        return this.IsParamNull(TAG_DUPCHECKVALUES);
    }

    public final String getDUPCHECKVALUES() {
        return this.GetParamStringValue(TAG_DUPCHECKVALUES, "");
    }

    public final void setDUPCHECKVALUES(String strValue) {
        this.SetParamValue(TAG_DUPCHECKVALUES, strValue);
    }

    public final boolean isDUPCHKPSDEFIDNull() {
        return this.IsParamNull(TAG_DUPCHKPSDEFID);
    }

    public final String getDUPCHKPSDEFID() {
        return this.GetParamStringValue(TAG_DUPCHKPSDEFID, "");
    }

    public final void setDUPCHKPSDEFID(String strValue) {
        this.SetParamValue(TAG_DUPCHKPSDEFID, strValue);
    }

    public final boolean isDUPCHKPSDEFNAMENull() {
        return this.IsParamNull(TAG_DUPCHKPSDEFNAME);
    }

    public final String getDUPCHKPSDEFNAME() {
        return this.GetParamStringValue(TAG_DUPCHKPSDEFNAME, "");
    }

    public final void setDUPCHKPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_DUPCHKPSDEFNAME, strValue);
    }

    public final boolean isPSSYSVALUERULEIDNull() {
        return this.IsParamNull(TAG_PSSYSVALUERULEID);
    }

    public final String getPSSYSVALUERULEID() {
        return this.GetParamStringValue(TAG_PSSYSVALUERULEID, "");
    }

    public final void setPSSYSVALUERULEID(String strValue) {
        this.SetParamValue(TAG_PSSYSVALUERULEID, strValue);
    }

    public final boolean isPSSYSVALUERULENAMENull() {
        return this.IsParamNull(TAG_PSSYSVALUERULENAME);
    }

    public final String getPSSYSVALUERULENAME() {
        return this.GetParamStringValue(TAG_PSSYSVALUERULENAME, "");
    }

    public final void setPSSYSVALUERULENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSVALUERULENAME, strValue);
    }

    public final boolean isDVTNull() {
        return this.IsParamNull(TAG_DVT);
    }

    public final String getDVT() {
        return this.GetParamStringValue(TAG_DVT, "");
    }

    public final void setDVT(String strValue) {
        this.SetParamValue(TAG_DVT, strValue);
    }

    public final boolean isQUERYCOLUMNNull() {
        return this.IsParamNull(TAG_QUERYCOLUMN);
    }

    public final boolean getQUERYCOLUMN() {
        return this.GetParamIntValue(TAG_QUERYCOLUMN, 0) == 1;
    }

    public final void setQUERYCOLUMN(boolean bValue) {
        this.SetParamValue(TAG_QUERYCOLUMN, bValue ? 1 : 0);
    }

    public final boolean isDBVALUEMODENull() {
        return this.IsParamNull(TAG_DBVALUEMODE);
    }

    public final String getDBVALUEMODE() {
        return this.GetParamStringValue(TAG_DBVALUEMODE, "");
    }

    public final void setDBVALUEMODE(String strValue) {
        this.SetParamValue(TAG_DBVALUEMODE, strValue);
    }

    public final boolean isSTATEFIELDNull() {
        return this.IsParamNull(TAG_STATEFIELD);
    }

    public final String getSTATEFIELD() {
        return this.GetParamStringValue(TAG_STATEFIELD, "");
    }

    public final void setSTATEFIELD(String strValue) {
        this.SetParamValue(TAG_STATEFIELD, strValue);
    }

    public final boolean isIMPORTKEYNull() {
        return this.IsParamNull(TAG_IMPORTKEY);
    }

    public final boolean getIMPORTKEY() {
        return this.GetParamIntValue(TAG_IMPORTKEY, 0) == 1;
    }

    public final void setIMPORTKEY(boolean bValue) {
        this.SetParamValue(TAG_IMPORTKEY, bValue ? 1 : 0);
    }

    public final boolean isIMPORTORDERNull() {
        return this.IsParamNull(TAG_IMPORTORDER);
    }

    public final int getIMPORTORDER() {
        return this.GetParamIntValue(TAG_IMPORTORDER, 0);
    }

    public final void setIMPORTORDER(int nValue) {
        this.SetParamValue(TAG_IMPORTORDER, nValue);
    }

    public final boolean isIMPORTTAGNull() {
        return this.IsParamNull(TAG_IMPORTTAG);
    }

    public final String getIMPORTTAG() {
        return this.GetParamStringValue(TAG_IMPORTTAG, "");
    }

    public final void setIMPORTTAG(String strValue) {
        this.SetParamValue(TAG_IMPORTTAG, strValue);
    }

    public final boolean isEXTENDMODENull() {
        return this.IsParamNull(TAG_EXTENDMODE);
    }

    public final int getEXTENDMODE() {
        return this.GetParamIntValue(TAG_EXTENDMODE, 0);
    }

    public final void setEXTENDMODE(int nValue) {
        this.SetParamValue(TAG_EXTENDMODE, nValue);
    }

    public final boolean isENAWRITEBACKNull() {
        return this.IsParamNull(TAG_ENAWRITEBACK);
    }

    public final int getENAWRITEBACK() {
        return this.GetParamIntValue(TAG_ENAWRITEBACK, 0);
    }

    public final void setENAWRITEBACK(int bValue) {
        this.SetParamValue(TAG_ENAWRITEBACK, bValue);
    }

    public final boolean isSTRLENGTHNull() {
        return this.IsParamNull(TAG_STRLENGTH);
    }

    public final int getSTRLENGTH() {
        return this.GetParamIntValue(TAG_STRLENGTH, 0);
    }

    public final void setSTRLENGTH(int nValue) {
        this.SetParamValue(TAG_STRLENGTH, nValue);
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

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
    }

    public final boolean isTESTDATANull() {
        return this.IsParamNull(TAG_TESTDATA);
    }

    public final String getTESTDATA() {
        return this.GetParamStringValue(TAG_TESTDATA, "");
    }

    public final void setTESTDATA(String strValue) {
        this.SetParamValue(TAG_TESTDATA, strValue);
    }

    public final boolean isPSSYSSAMPLEVALUEIDNull() {
        return this.IsParamNull(TAG_PSSYSSAMPLEVALUEID);
    }

    public final String getPSSYSSAMPLEVALUEID() {
        return this.GetParamStringValue(TAG_PSSYSSAMPLEVALUEID, "");
    }

    public final void setPSSYSSAMPLEVALUEID(String strValue) {
        this.SetParamValue(TAG_PSSYSSAMPLEVALUEID, strValue);
    }

    public final boolean isPSSYSSAMPLEVALUENAMENull() {
        return this.IsParamNull(TAG_PSSYSSAMPLEVALUENAME);
    }

    public final String getPSSYSSAMPLEVALUENAME() {
        return this.GetParamStringValue(TAG_PSSYSSAMPLEVALUENAME, "");
    }

    public final void setPSSYSSAMPLEVALUENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSSAMPLEVALUENAME, strValue);
    }

    public final boolean isUNICODECHARNull() {
        return this.IsParamNull(TAG_UNICODECHAR);
    }

    public final boolean getUNICODECHAR() {
        return this.GetParamIntValue(TAG_UNICODECHAR, 0) == 1;
    }

    public final void setUNICODECHAR(boolean bValue) {
        this.SetParamValue(TAG_UNICODECHAR, bValue ? 1 : 0);
    }

    public final boolean isENABLECOLPRIVNull() {
        return this.IsParamNull(TAG_ENABLECOLPRIV);
    }

    public final boolean getENABLECOLPRIV() {
        return this.GetParamIntValue(TAG_ENABLECOLPRIV, 0) == 1;
    }

    public final void setENABLECOLPRIV(boolean bValue) {
        this.SetParamValue(TAG_ENABLECOLPRIV, bValue ? 1 : 0);
    }

    public final boolean isQUERYCSNull() {
        return this.IsParamNull(TAG_QUERYCS);
    }

    public final String getQUERYCS() {
        return this.GetParamStringValue(TAG_QUERYCS, "");
    }

    public final void setQUERYCS(String strValue) {
        this.SetParamValue(TAG_QUERYCS, strValue);
    }

    public final boolean isORDERVALUENull() {
        return this.IsParamNull("ORDERVALUE");
    }

    public final int getORDERVALUE() {
        return this.GetParamIntValue("ORDERVALUE", 0);
    }

    public final void setORDERVALUE(int nValue) {
        this.SetParamValue("ORDERVALUE", nValue);
    }

    public final boolean isENABLETEMPDATANull() {
        return this.IsParamNull(TAG_ENABLETEMPDATA);
    }

    public final boolean getENABLETEMPDATA() {
        return this.GetParamIntValue(TAG_ENABLETEMPDATA, 0) == 1;
    }

    public final void setENABLETEMPDATA(boolean bValue) {
        this.SetParamValue(TAG_ENABLETEMPDATA, bValue ? 1 : 0);
    }

    public final boolean isLNPSLANRESIDNull() {
        return this.IsParamNull(TAG_LNPSLANRESID);
    }

    public final String getLNPSLANRESID() {
        return this.GetParamStringValue(TAG_LNPSLANRESID, "");
    }

    public final void setLNPSLANRESID(String strValue) {
        this.SetParamValue(TAG_LNPSLANRESID, strValue);
    }

    public final boolean isLNPSLANRESNAMENull() {
        return this.IsParamNull(TAG_LNPSLANRESNAME);
    }

    public final String getLNPSLANRESNAME() {
        return this.GetParamStringValue(TAG_LNPSLANRESNAME, "");
    }

    public final void setLNPSLANRESNAME(String strValue) {
        this.SetParamValue(TAG_LNPSLANRESNAME, strValue);
    }

    public final boolean isPSSYSUNITIDNull() {
        return this.IsParamNull(TAG_PSSYSUNITID);
    }

    public final String getPSSYSUNITID() {
        return this.GetParamStringValue(TAG_PSSYSUNITID, "");
    }

    public final void setPSSYSUNITID(String strValue) {
        this.SetParamValue(TAG_PSSYSUNITID, strValue);
    }

    public final boolean isPSSYSUNITNAMENull() {
        return this.IsParamNull(TAG_PSSYSUNITNAME);
    }

    public final String getPSSYSUNITNAME() {
        return this.GetParamStringValue(TAG_PSSYSUNITNAME, "");
    }

    public final void setPSSYSUNITNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSUNITNAME, strValue);
    }

    public final boolean isVIEWCOLLEVELNull() {
        return this.IsParamNull(TAG_VIEWCOLLEVEL);
    }

    public final int getVIEWCOLLEVEL() {
        return this.GetParamIntValue(TAG_VIEWCOLLEVEL, 0);
    }

    public final void setVIEWCOLLEVEL(int nValue) {
        this.SetParamValue(TAG_VIEWCOLLEVEL, nValue);
    }

    public final boolean isCHECKRECURSIONNull() {
        return this.IsParamNull(TAG_CHECKRECURSION);
    }

    public final boolean getCHECKRECURSION() {
        return this.GetParamIntValue(TAG_CHECKRECURSION, 0) == 1;
    }

    public final void setCHECKRECURSION(boolean bValue) {
        this.SetParamValue(TAG_CHECKRECURSION, bValue ? 1 : 0);
    }

    public final boolean isBIZTAGNull() {
        return this.IsParamNull(TAG_BIZTAG);
    }

    public final String getBIZTAG() {
        return this.GetParamStringValue(TAG_BIZTAG, "");
    }

    public final void setBIZTAG(String strValue) {
        this.SetParamValue(TAG_BIZTAG, strValue);
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

    public final boolean isDBVALUEMODE2Null() {
        return this.IsParamNull(TAG_DBVALUEMODE2);
    }

    public final String getDBVALUEMODE2() {
        return this.GetParamStringValue(TAG_DBVALUEMODE2, "");
    }

    public final void setDBVALUEMODE2(String strValue) {
        this.SetParamValue(TAG_DBVALUEMODE2, strValue);
    }

    public final boolean isNO2DUPCHKPSDEFIDNull() {
        return this.IsParamNull(TAG_NO2DUPCHKPSDEFID);
    }

    public final String getNO2DUPCHKPSDEFID() {
        return this.GetParamStringValue(TAG_NO2DUPCHKPSDEFID, "");
    }

    public final void setNO2DUPCHKPSDEFID(String strValue) {
        this.SetParamValue(TAG_NO2DUPCHKPSDEFID, strValue);
    }

    public final boolean isNO2DUPCHKPSDEFNAMENull() {
        return this.IsParamNull(TAG_NO2DUPCHKPSDEFNAME);
    }

    public final String getNO2DUPCHKPSDEFNAME() {
        return this.GetParamStringValue(TAG_NO2DUPCHKPSDEFNAME, "");
    }

    public final void setNO2DUPCHKPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_NO2DUPCHKPSDEFNAME, strValue);
    }

    public final boolean isNO3DUPCHKPSDEFIDNull() {
        return this.IsParamNull(TAG_NO3DUPCHKPSDEFID);
    }

    public final String getNO3DUPCHKPSDEFID() {
        return this.GetParamStringValue(TAG_NO3DUPCHKPSDEFID, "");
    }

    public final void setNO3DUPCHKPSDEFID(String strValue) {
        this.SetParamValue(TAG_NO3DUPCHKPSDEFID, strValue);
    }

    public final boolean isNO3DUPCHKPSDEFNAMENull() {
        return this.IsParamNull(TAG_NO3DUPCHKPSDEFNAME);
    }

    public final String getNO3DUPCHKPSDEFNAME() {
        return this.GetParamStringValue(TAG_NO3DUPCHKPSDEFNAME, "");
    }

    public final void setNO3DUPCHKPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_NO3DUPCHKPSDEFNAME, strValue);
    }

    public final boolean isNULLVALORDERNull() {
        return this.IsParamNull(TAG_NULLVALORDER);
    }

    public final String getNULLVALORDER() {
        return this.GetParamStringValue(TAG_NULLVALORDER, "");
    }

    public final void setNULLVALORDER(String strValue) {
        this.SetParamValue(TAG_NULLVALORDER, strValue);
    }

    public final boolean isSERVICECODENAMENull() {
        return this.IsParamNull(TAG_SERVICECODENAME);
    }

    public final String getSERVICECODENAME() {
        return this.GetParamStringValue(TAG_SERVICECODENAME, "");
    }

    public final void setSERVICECODENAME(String strValue) {
        this.SetParamValue(TAG_SERVICECODENAME, strValue);
    }

    public final boolean isPSDETABLEIDNull() {
        return this.IsParamNull(TAG_PSDETABLEID);
    }

    public final String getPSDETABLEID() {
        return this.GetParamStringValue(TAG_PSDETABLEID, "");
    }

    public final void setPSDETABLEID(String strValue) {
        this.SetParamValue(TAG_PSDETABLEID, strValue);
    }

    public final boolean isPSSYSDBCOLUMNIDNull() {
        return this.IsParamNull(TAG_PSSYSDBCOLUMNID);
    }

    public final String getPSSYSDBCOLUMNID() {
        return this.GetParamStringValue(TAG_PSSYSDBCOLUMNID, "");
    }

    public final void setPSSYSDBCOLUMNID(String strValue) {
        this.SetParamValue(TAG_PSSYSDBCOLUMNID, strValue);
    }

    public final boolean isPSSUBSYSSADEFIELDIDNull() {
        return this.IsParamNull(TAG_PSSUBSYSSADEFIELDID);
    }

    public final String getPSSUBSYSSADEFIELDID() {
        return this.GetParamStringValue(TAG_PSSUBSYSSADEFIELDID, "");
    }

    public final void setPSSUBSYSSADEFIELDID(String strValue) {
        this.SetParamValue(TAG_PSSUBSYSSADEFIELDID, strValue);
    }

    public final boolean isPSSUBSYSSADEFIELDNAMENull() {
        return this.IsParamNull(TAG_PSSUBSYSSADEFIELDNAME);
    }

    public final String getPSSUBSYSSADEFIELDNAME() {
        return this.GetParamStringValue(TAG_PSSUBSYSSADEFIELDNAME, "");
    }

    public final void setPSSUBSYSSADEFIELDNAME(String strValue) {
        this.SetParamValue(TAG_PSSUBSYSSADEFIELDNAME, strValue);
    }

    public final boolean isO2MPSDERIDNull() {
        return this.IsParamNull(TAG_O2MPSDERID);
    }

    public final String getO2MPSDERID() {
        return this.GetParamStringValue(TAG_O2MPSDERID, "");
    }

    public final void setO2MPSDERID(String strValue) {
        this.SetParamValue(TAG_O2MPSDERID, strValue);
    }

    public final boolean isO2MPSDERNAMENull() {
        return this.IsParamNull(TAG_O2MPSDERNAME);
    }

    public final String getO2MPSDERNAME() {
        return this.GetParamStringValue(TAG_O2MPSDERNAME, "");
    }

    public final void setO2MPSDERNAME(String strValue) {
        this.SetParamValue(TAG_O2MPSDERNAME, strValue);
    }

    public final boolean isMAXVALUENull() {
        return this.IsParamNull(TAG_MAXVALUE);
    }

    public final String getMAXVALUE() {
        return this.GetParamStringValue(TAG_MAXVALUE, "");
    }

    public final void setMAXVALUE(String strValue) {
        this.SetParamValue(TAG_MAXVALUE, strValue);
    }

    public final boolean isMINVALUENull() {
        return this.IsParamNull(TAG_MINVALUE);
    }

    public final String getMINVALUE() {
        return this.GetParamStringValue(TAG_MINVALUE, "");
    }

    public final void setMINVALUE(String strValue) {
        this.SetParamValue(TAG_MINVALUE, strValue);
    }

    public final boolean isMINSTRLENGTHNull() {
        return this.IsParamNull(TAG_MINSTRLENGTH);
    }

    public final int getMINSTRLENGTH() {
        return this.GetParamIntValue(TAG_MINSTRLENGTH, 0);
    }

    public final void setMINSTRLENGTH(int nValue) {
        this.SetParamValue(TAG_MINSTRLENGTH, nValue);
    }

    public final boolean isREADONLYMODENull() {
        return this.IsParamNull(TAG_READONLYMODE);
    }

    public final int getREADONLYMODE() {
        return this.GetParamIntValue(TAG_READONLYMODE, 0);
    }

    public final void setREADONLYMODE(int nValue) {
        this.SetParamValue(TAG_READONLYMODE, nValue);
    }

    public final boolean isPSSYSSEQUENCEIDNull() {
        return this.IsParamNull(TAG_PSSYSSEQUENCEID);
    }

    public final String getPSSYSSEQUENCEID() {
        return this.GetParamStringValue(TAG_PSSYSSEQUENCEID, "");
    }

    public final void setPSSYSSEQUENCEID(String strValue) {
        this.SetParamValue(TAG_PSSYSSEQUENCEID, strValue);
    }

    public final boolean isPSSYSSEQUENCENAMENull() {
        return this.IsParamNull(TAG_PSSYSSEQUENCENAME);
    }

    public final String getPSSYSSEQUENCENAME() {
        return this.GetParamStringValue(TAG_PSSYSSEQUENCENAME, "");
    }

    public final void setPSSYSSEQUENCENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSSEQUENCENAME, strValue);
    }

    public final boolean isSEQUENCEMODENull() {
        return this.IsParamNull(TAG_SEQUENCEMODE);
    }

    public final String getSEQUENCEMODE() {
        return this.GetParamStringValue(TAG_SEQUENCEMODE, "");
    }

    public final void setSEQUENCEMODE(String strValue) {
        this.SetParamValue(TAG_SEQUENCEMODE, strValue);
    }

    public final boolean isCOMPUTEEXPNull() {
        return this.IsParamNull(TAG_COMPUTEEXP);
    }

    public final String getCOMPUTEEXP() {
        return this.GetParamStringValue(TAG_COMPUTEEXP, "");
    }

    public final void setCOMPUTEEXP(String strValue) {
        this.SetParamValue(TAG_COMPUTEEXP, strValue);
    }

    public final boolean isTRANSLATORMODENull() {
        return this.IsParamNull(TAG_TRANSLATORMODE);
    }

    public final String getTRANSLATORMODE() {
        return this.GetParamStringValue(TAG_TRANSLATORMODE, "");
    }

    public final void setTRANSLATORMODE(String strValue) {
        this.SetParamValue(TAG_TRANSLATORMODE, strValue);
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

    public final boolean isO2OPSDERIDNull() {
        return this.IsParamNull(TAG_O2OPSDERID);
    }

    public final String getO2OPSDERID() {
        return this.GetParamStringValue(TAG_O2OPSDERID, "");
    }

    public final void setO2OPSDERID(String strValue) {
        this.SetParamValue(TAG_O2OPSDERID, strValue);
    }

    public final boolean isO2OPSDERNAMENull() {
        return this.IsParamNull(TAG_O2OPSDERNAME);
    }

    public final String getO2OPSDERNAME() {
        return this.GetParamStringValue(TAG_O2OPSDERNAME, "");
    }

    public final void setO2OPSDERNAME(String strValue) {
        this.SetParamValue(TAG_O2OPSDERNAME, strValue);
    }

    public final boolean isRESTRICTEDPSDEFIDNull() {
        return this.IsParamNull(TAG_RESTRICTEDPSDEFID);
    }

    public final String getRESTRICTEDPSDEFID() {
        return this.GetParamStringValue(TAG_RESTRICTEDPSDEFID, "");
    }

    public final void setRESTRICTEDPSDEFID(String strValue) {
        this.SetParamValue(TAG_RESTRICTEDPSDEFID, strValue);
    }

    public final boolean isRESTRICTEDPSDEFNAMENull() {
        return this.IsParamNull(TAG_RESTRICTEDPSDEFNAME);
    }

    public final String getRESTRICTEDPSDEFNAME() {
        return this.GetParamStringValue(TAG_RESTRICTEDPSDEFNAME, "");
    }

    public final void setRESTRICTEDPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_RESTRICTEDPSDEFNAME, strValue);
    }

    public final boolean isVALUEPSDEFIDNull() {
        return this.IsParamNull(TAG_VALUEPSDEFID);
    }

    public final String getVALUEPSDEFID() {
        return this.GetParamStringValue(TAG_VALUEPSDEFID, "");
    }

    public final void setVALUEPSDEFID(String strValue) {
        this.SetParamValue(TAG_VALUEPSDEFID, strValue);
    }

    public final boolean isVALUEPSDEFNAMENull() {
        return this.IsParamNull(TAG_VALUEPSDEFNAME);
    }

    public final String getVALUEPSDEFNAME() {
        return this.GetParamStringValue(TAG_VALUEPSDEFNAME, "");
    }

    public final void setVALUEPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_VALUEPSDEFNAME, strValue);
    }

    public final boolean isJSFORMATNull() {
        return this.IsParamNull(TAG_JSFORMAT);
    }

    public final String getJSFORMAT() {
        return this.GetParamStringValue(TAG_JSFORMAT, "");
    }

    public final void setJSFORMAT(String strValue) {
        this.SetParamValue(TAG_JSFORMAT, strValue);
    }

    public final boolean isJSONFORMATNull() {
        return this.IsParamNull(TAG_JSONFORMAT);
    }

    public final String getJSONFORMAT() {
        return this.GetParamStringValue(TAG_JSONFORMAT, "");
    }

    public final void setJSONFORMAT(String strValue) {
        this.SetParamValue(TAG_JSONFORMAT, strValue);
    }

    public final boolean isREFPSSYSDYNAMODELIDNull() {
        return this.IsParamNull(TAG_REFPSSYSDYNAMODELID);
    }

    public final String getREFPSSYSDYNAMODELID() {
        return this.GetParamStringValue(TAG_REFPSSYSDYNAMODELID, "");
    }

    public final void setREFPSSYSDYNAMODELID(String strValue) {
        this.SetParamValue(TAG_REFPSSYSDYNAMODELID, strValue);
    }

    public final boolean isREFPSSYSDYNAMODELNAMENull() {
        return this.IsParamNull(TAG_REFPSSYSDYNAMODELNAME);
    }

    public final String getREFPSSYSDYNAMODELNAME() {
        return this.GetParamStringValue(TAG_REFPSSYSDYNAMODELNAME, "");
    }

    public final void setREFPSSYSDYNAMODELNAME(String strValue) {
        this.SetParamValue(TAG_REFPSSYSDYNAMODELNAME, strValue);
    }

    public final boolean isFIELDTAGNull() {
        return this.IsParamNull(TAG_FIELDTAG);
    }

    public final String getFIELDTAG() {
        return this.GetParamStringValue(TAG_FIELDTAG, "");
    }

    public final void setFIELDTAG(String strValue) {
        this.SetParamValue(TAG_FIELDTAG, strValue);
    }

    public final boolean isFIELDTAG2Null() {
        return this.IsParamNull(TAG_FIELDTAG2);
    }

    public final String getFIELDTAG2() {
        return this.GetParamStringValue(TAG_FIELDTAG2, "");
    }

    public final void setFIELDTAG2(String strValue) {
        this.SetParamValue(TAG_FIELDTAG2, strValue);
    }

    public final boolean isIMPPSSYSTRANSLATORIDNull() {
        return this.IsParamNull(TAG_IMPPSSYSTRANSLATORID);
    }

    public final String getIMPPSSYSTRANSLATORID() {
        return this.GetParamStringValue(TAG_IMPPSSYSTRANSLATORID, "");
    }

    public final void setIMPPSSYSTRANSLATORID(String strValue) {
        this.SetParamValue(TAG_IMPPSSYSTRANSLATORID, strValue);
    }

    public final boolean isIMPPSSYSTRANSLATORNAMENull() {
        return this.IsParamNull(TAG_IMPPSSYSTRANSLATORNAME);
    }

    public final String getIMPPSSYSTRANSLATORNAME() {
        return this.GetParamStringValue(TAG_IMPPSSYSTRANSLATORNAME, "");
    }

    public final void setIMPPSSYSTRANSLATORNAME(String strValue) {
        this.SetParamValue(TAG_IMPPSSYSTRANSLATORNAME, strValue);
    }

    public final boolean isEXPPSSYSTRANSLATORIDNull() {
        return this.IsParamNull(TAG_EXPPSSYSTRANSLATORID);
    }

    public final String getEXPPSSYSTRANSLATORID() {
        return this.GetParamStringValue(TAG_EXPPSSYSTRANSLATORID, "");
    }

    public final void setEXPPSSYSTRANSLATORID(String strValue) {
        this.SetParamValue(TAG_EXPPSSYSTRANSLATORID, strValue);
    }

    public final boolean isEXPPSSYSTRANSLATORNAMENull() {
        return this.IsParamNull(TAG_EXPPSSYSTRANSLATORNAME);
    }

    public final String getEXPPSSYSTRANSLATORNAME() {
        return this.GetParamStringValue(TAG_EXPPSSYSTRANSLATORNAME, "");
    }

    public final void setEXPPSSYSTRANSLATORNAME(String strValue) {
        this.SetParamValue(TAG_EXPPSSYSTRANSLATORNAME, strValue);
    }

    public final boolean isPREDEFINEDTYPEPARAMNull() {
        return this.IsParamNull(TAG_PREDEFINEDTYPEPARAM);
    }

    public final String getPREDEFINEDTYPEPARAM() {
        return this.GetParamStringValue(TAG_PREDEFINEDTYPEPARAM, "");
    }

    public final void setPREDEFINEDTYPEPARAM(String strValue) {
        this.SetParamValue(TAG_PREDEFINEDTYPEPARAM, strValue);
    }

    public static String toDEFTypeString(int nDEFType) {
        switch (nDEFType) {
            case 1: {
                return "PHISICAL";
            }
            case 2: {
                return "FORMULA";
            }
            case 3: {
                return "LINK";
            }
            case 4: {
                return "DYNASTORAGE";
            }
            case 5: {
                return "UI";
            }
        }
        return "";
    }

    public ArrayList<PSDEFUIMode> getPSDEFUIModes(boolean bCreated) {
        if (this.psDEFUIModeList != null) {
            return this.psDEFUIModeList;
        }
        if (bCreated) {
            this.psDEFUIModeList = new ArrayList();
        }
        return this.psDEFUIModeList;
    }

    public ArrayList<PSDEFValueRule> getPSDEFValueRules(boolean bCreated) {
        if (this.psDEFValueRuleList != null) {
            return this.psDEFValueRuleList;
        }
        if (bCreated) {
            this.psDEFValueRuleList = new ArrayList();
        }
        return this.psDEFValueRuleList;
    }

    public ArrayList<PSDEFSearchMode> getPSDEFSearchModes(boolean bCreated) {
        if (this.psDEFSearchModeList != null) {
            return this.psDEFSearchModeList;
        }
        if (bCreated) {
            this.psDEFSearchModeList = new ArrayList();
        }
        return this.psDEFSearchModeList;
    }

    public ArrayList<PSDEFInputTip> getPSDEFInputTips(boolean bCreated) {
        if (this.psDEFInputTipList != null) {
            return this.psDEFInputTipList;
        }
        if (bCreated) {
            this.psDEFInputTipList = new ArrayList();
        }
        return this.psDEFInputTipList;
    }

    public ArrayList<PSSysSearchDEField> getPSSysSearchDEFields(boolean bCreated) {
        if (this.psSysSearchDEFieldList != null) {
            return this.psSysSearchDEFieldList;
        }
        if (bCreated) {
            this.psSysSearchDEFieldList = new ArrayList();
        }
        return this.psSysSearchDEFieldList;
    }

    public void resetChildDatas() {
        if (this.psDEFUIModeList != null) {
            this.psDEFUIModeList.clear();
            this.psDEFUIModeList = null;
        }
        if (this.psDEFValueRuleList != null) {
            this.psDEFValueRuleList.clear();
            this.psDEFValueRuleList = null;
        }
        if (this.psDEFSearchModeList != null) {
            this.psDEFSearchModeList.clear();
            this.psDEFSearchModeList = null;
        }
        if (this.psDEFInputTipList != null) {
            this.psDEFInputTipList.clear();
            this.psDEFInputTipList = null;
        }
        if (this.psSysSearchDEFieldList != null) {
            this.psSysSearchDEFieldList.clear();
            this.psSysSearchDEFieldList = null;
        }
    }
}

