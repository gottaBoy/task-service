/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.ArrayList;
import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;
import net.ibizsys.model.entity.PSDEFSearchMode;
import net.ibizsys.model.entity.PSDEFUIMode;
import net.ibizsys.model.entity.PSDEFValueRule;

public class PSDEField
extends BaseDataEntity {
    public static final int DEFTYPE_PHISICAL = 1;
    public static final int DEFTYPE_FORMULA = 2;
    public static final int DEFTYPE_LINK = 3;
    public static final int PKEY_NONE = 0;
    public static final int PKEY_PKEY = 1;
    public static final int PKEY_UNITAG = 2;
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
    public static final String TAG_PREDEFINETYPE = "PREDEFINETYPE";
    public static final String TAG_PRECISION2 = "PRECISION2";
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
    private ArrayList<PSDEFUIMode> psDEFUIModeList = null;
    private ArrayList<PSDEFValueRule> psDEFValueRuleList = null;
    private ArrayList<PSDEFSearchMode> psDEFSearchModeList = null;

    public final boolean isPSDEFIELDIDNull() {
        return this.isParamNull(TAG_PSDEFIELDID);
    }

    public final String getPSDEFIELDID() {
        return this.getParamStringValue(TAG_PSDEFIELDID, "");
    }

    public final void setPSDEFIELDID(String strValue) {
        this.setParamValue(TAG_PSDEFIELDID, strValue);
    }

    public final boolean isPSDEFIELDNAMENull() {
        return this.isParamNull(TAG_PSDEFIELDNAME);
    }

    public final String getPSDEFIELDNAME() {
        return this.getParamStringValue(TAG_PSDEFIELDNAME, "");
    }

    public final void setPSDEFIELDNAME(String strValue) {
        this.setParamValue(TAG_PSDEFIELDNAME, strValue);
    }

    public final boolean isCREATEMANNull() {
        return this.isParamNull("CREATEMAN");
    }

    public final String getCREATEMAN() {
        return this.getParamStringValue("CREATEMAN", "");
    }

    public final void setCREATEMAN(String strValue) {
        this.setParamValue("CREATEMAN", strValue);
    }

    public final boolean isCREATEDATENull() {
        return this.isParamNull("CREATEDATE");
    }

    public final Date getCREATEDATE() {
        return this.getParamDateValue("CREATEDATE", null);
    }

    public final void setCREATEDATE(Date dtValue) {
        this.setParamValue("CREATEDATE", dtValue);
    }

    public final boolean isUPDATEMANNull() {
        return this.isParamNull("UPDATEMAN");
    }

    public final String getUPDATEMAN() {
        return this.getParamStringValue("UPDATEMAN", "");
    }

    public final void setUPDATEMAN(String strValue) {
        this.setParamValue("UPDATEMAN", strValue);
    }

    public final boolean isUPDATEDATENull() {
        return this.isParamNull("UPDATEDATE");
    }

    public final Date getUPDATEDATE() {
        return this.getParamDateValue("UPDATEDATE", null);
    }

    public final void setUPDATEDATE(Date dtValue) {
        this.setParamValue("UPDATEDATE", dtValue);
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

    public final boolean isLOGICNAMENull() {
        return this.isParamNull(TAG_LOGICNAME);
    }

    public final String getLOGICNAME() {
        return this.getParamStringValue(TAG_LOGICNAME, "");
    }

    public final void setLOGICNAME(String strValue) {
        this.setParamValue(TAG_LOGICNAME, strValue);
    }

    public final boolean isLENGTHNull() {
        return this.isParamNull(TAG_LENGTH);
    }

    public final int getLENGTH() {
        return this.getParamIntValue(TAG_LENGTH, 0);
    }

    public final void setLENGTH(int nValue) {
        this.setParamValue(TAG_LENGTH, nValue);
    }

    public final boolean isDEFTYPENull() {
        return this.isParamNull(TAG_DEFTYPE);
    }

    public final int getDEFTYPE() {
        return this.getParamIntValue(TAG_DEFTYPE, 0);
    }

    public final void setDEFTYPE(int nValue) {
        this.setParamValue(TAG_DEFTYPE, nValue);
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

    public final boolean isALLOWEMPTYNull() {
        return this.isParamNull(TAG_ALLOWEMPTY);
    }

    public final boolean getALLOWEMPTY() {
        return this.getParamIntValue(TAG_ALLOWEMPTY, 0) == 1;
    }

    public final void setALLOWEMPTY(boolean bValue) {
        this.setParamValue(TAG_ALLOWEMPTY, bValue ? 1 : 0);
    }

    public final boolean isPKEYNull() {
        return this.isParamNull(TAG_PKEY);
    }

    public final int getPKEY() {
        return this.getParamIntValue(TAG_PKEY, 0);
    }

    public final void setPKEY(int nValue) {
        this.setParamValue(TAG_PKEY, nValue);
    }

    public final boolean isMAJORFIELDNull() {
        return this.isParamNull(TAG_MAJORFIELD);
    }

    public final boolean getMAJORFIELD() {
        return this.getParamIntValue(TAG_MAJORFIELD, 0) == 1;
    }

    public final void setMAJORFIELD(boolean bValue) {
        this.setParamValue(TAG_MAJORFIELD, bValue ? 1 : 0);
    }

    public final boolean isTABLENAMENull() {
        return this.isParamNull(TAG_TABLENAME);
    }

    public final String getTABLENAME() {
        return this.getParamStringValue(TAG_TABLENAME, "");
    }

    public final void setTABLENAME(String strValue) {
        this.setParamValue(TAG_TABLENAME, strValue);
    }

    public final boolean isPSCODELISTIDNull() {
        return this.isParamNull(TAG_PSCODELISTID);
    }

    public final String getPSCODELISTID() {
        return this.getParamStringValue(TAG_PSCODELISTID, "");
    }

    public final void setPSCODELISTID(String strValue) {
        this.setParamValue(TAG_PSCODELISTID, strValue);
    }

    public final boolean isPSCODELISTNAMENull() {
        return this.isParamNull(TAG_PSCODELISTNAME);
    }

    public final String getPSCODELISTNAME() {
        return this.getParamStringValue(TAG_PSCODELISTNAME, "");
    }

    public final void setPSCODELISTNAME(String strValue) {
        this.setParamValue(TAG_PSCODELISTNAME, strValue);
    }

    public final boolean isUPDATEOVMODENull() {
        return this.isParamNull(TAG_UPDATEOVMODE);
    }

    public final String getUPDATEOVMODE() {
        return this.getParamStringValue(TAG_UPDATEOVMODE, "");
    }

    public final void setUPDATEOVMODE(String strValue) {
        this.setParamValue(TAG_UPDATEOVMODE, strValue);
    }

    public final boolean isPREDEFINETYPENull() {
        return this.isParamNull(TAG_PREDEFINETYPE);
    }

    public final String getPREDEFINETYPE() {
        return this.getParamStringValue(TAG_PREDEFINETYPE, "");
    }

    public final void setPREDEFINETYPE(String strValue) {
        this.setParamValue(TAG_PREDEFINETYPE, strValue);
    }

    public final boolean isPRECISION2Null() {
        return this.isParamNull(TAG_PRECISION2);
    }

    public final int getPRECISION2() {
        return this.getParamIntValue(TAG_PRECISION2, 0);
    }

    public final void setPRECISION2(int nValue) {
        this.setParamValue(TAG_PRECISION2, nValue);
    }

    public final boolean isAUDITINFOFORMATNull() {
        return this.isParamNull(TAG_AUDITINFOFORMAT);
    }

    public final String getAUDITINFOFORMAT() {
        return this.getParamStringValue(TAG_AUDITINFOFORMAT, "");
    }

    public final void setAUDITINFOFORMAT(String strValue) {
        this.setParamValue(TAG_AUDITINFOFORMAT, strValue);
    }

    public final boolean isENABLEAUDITNull() {
        return this.isParamNull(TAG_ENABLEAUDIT);
    }

    public final boolean getENABLEAUDIT() {
        return this.getParamIntValue(TAG_ENABLEAUDIT, 0) == 1;
    }

    public final void setENABLEAUDIT(boolean bValue) {
        this.setParamValue(TAG_ENABLEAUDIT, bValue ? 1 : 0);
    }

    public final boolean isPASTERESETNull() {
        return this.isParamNull(TAG_PASTERESET);
    }

    public final boolean getPASTERESET() {
        return this.getParamIntValue(TAG_PASTERESET, 0) == 1;
    }

    public final void setPASTERESET(boolean bValue) {
        this.setParamValue(TAG_PASTERESET, bValue ? 1 : 0);
    }

    public final boolean isUNITWIDTHNull() {
        return this.isParamNull(TAG_UNITWIDTH);
    }

    public final int getUNITWIDTH() {
        return this.getParamIntValue(TAG_UNITWIDTH, 0);
    }

    public final void setUNITWIDTH(int nValue) {
        this.setParamValue(TAG_UNITWIDTH, nValue);
    }

    public final boolean isUNITNull() {
        return this.isParamNull(TAG_UNIT);
    }

    public final String getUNIT() {
        return this.getParamStringValue(TAG_UNIT, "");
    }

    public final void setUNIT(String strValue) {
        this.setParamValue(TAG_UNIT, strValue);
    }

    public final boolean isENABLEUSERINPUTNull() {
        return this.isParamNull(TAG_ENABLEUSERINPUT);
    }

    public final int getENABLEUSERINPUT() {
        return this.getParamIntValue(TAG_ENABLEUSERINPUT, 0);
    }

    public final void setENABLEUSERINPUT(int nValue) {
        this.setParamValue(TAG_ENABLEUSERINPUT, nValue);
    }

    public final boolean isSTRINGCASENull() {
        return this.isParamNull(TAG_STRINGCASE);
    }

    public final String getSTRINGCASE() {
        return this.getParamStringValue(TAG_STRINGCASE, "");
    }

    public final void setSTRINGCASE(String strValue) {
        this.setParamValue(TAG_STRINGCASE, strValue);
    }

    public final boolean isDEFAULTVALUENull() {
        return this.isParamNull(TAG_DEFAULTVALUE);
    }

    public final String getDEFAULTVALUE() {
        return this.getParamStringValue(TAG_DEFAULTVALUE, "");
    }

    public final void setDEFAULTVALUE(String strValue) {
        this.setParamValue(TAG_DEFAULTVALUE, strValue);
    }

    public final boolean isPSDERIDNull() {
        return this.isParamNull(TAG_PSDERID);
    }

    public final String getPSDERID() {
        return this.getParamStringValue(TAG_PSDERID, "");
    }

    public final void setPSDERID(String strValue) {
        this.setParamValue(TAG_PSDERID, strValue);
    }

    public final boolean isPSDERNAMENull() {
        return this.isParamNull(TAG_PSDERNAME);
    }

    public final String getPSDERNAME() {
        return this.getParamStringValue(TAG_PSDERNAME, "");
    }

    public final void setPSDERNAME(String strValue) {
        this.setParamValue(TAG_PSDERNAME, strValue);
    }

    public final boolean isDERPSDEFIDNull() {
        return this.isParamNull(TAG_DERPSDEFID);
    }

    public final String getDERPSDEFID() {
        return this.getParamStringValue(TAG_DERPSDEFID, "");
    }

    public final void setDERPSDEFID(String strValue) {
        this.setParamValue(TAG_DERPSDEFID, strValue);
    }

    public final boolean isDERPSDEFNAMENull() {
        return this.isParamNull(TAG_DERPSDEFNAME);
    }

    public final String getDERPSDEFNAME() {
        return this.getParamStringValue(TAG_DERPSDEFNAME, "");
    }

    public final void setDERPSDEFNAME(String strValue) {
        this.setParamValue(TAG_DERPSDEFNAME, strValue);
    }

    public final boolean isPHYSICALFIELDNull() {
        return this.isParamNull(TAG_PHYSICALFIELD);
    }

    public final boolean getPHYSICALFIELD() {
        return this.getParamIntValue(TAG_PHYSICALFIELD, 0) == 1;
    }

    public final void setPHYSICALFIELD(boolean bValue) {
        this.setParamValue(TAG_PHYSICALFIELD, bValue ? 1 : 0);
    }

    public final boolean isPSDATATYPEIDNull() {
        return this.isParamNull(TAG_PSDATATYPEID);
    }

    public final String getPSDATATYPEID() {
        return this.getParamStringValue(TAG_PSDATATYPEID, "");
    }

    public final void setPSDATATYPEID(String strValue) {
        this.setParamValue(TAG_PSDATATYPEID, strValue);
    }

    public final boolean isPSDATATYPENAMENull() {
        return this.isParamNull(TAG_PSDATATYPENAME);
    }

    public final String getPSDATATYPENAME() {
        return this.getParamStringValue(TAG_PSDATATYPENAME, "");
    }

    public final void setPSDATATYPENAME(String strValue) {
        this.setParamValue(TAG_PSDATATYPENAME, strValue);
    }

    public final boolean isFKEYNull() {
        return this.isParamNull(TAG_FKEY);
    }

    public final boolean getFKEY() {
        return this.getParamIntValue(TAG_FKEY, 0) == 1;
    }

    public final void setFKEY(boolean bValue) {
        this.setParamValue(TAG_FKEY, bValue ? 1 : 0);
    }

    public final boolean isVALUEFORMATNull() {
        return this.isParamNull(TAG_VALUEFORMAT);
    }

    public final String getVALUEFORMAT() {
        return this.getParamStringValue(TAG_VALUEFORMAT, "");
    }

    public final void setVALUEFORMAT(String strValue) {
        this.setParamValue(TAG_VALUEFORMAT, strValue);
    }

    public final boolean isCODENAMENull() {
        return this.isParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.getParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.setParamValue(TAG_CODENAME, strValue);
    }

    public final boolean isENABLEQSNull() {
        return this.isParamNull(TAG_ENABLEQS);
    }

    public final boolean getENABLEQS() {
        return this.getParamIntValue(TAG_ENABLEQS, 0) == 1;
    }

    public final void setENABLEQS(boolean bValue) {
        this.setParamValue(TAG_ENABLEQS, bValue ? 1 : 0);
    }

    public final boolean isUNIONKEYVALUENull() {
        return this.isParamNull(TAG_UNIONKEYVALUE);
    }

    public final String getUNIONKEYVALUE() {
        return this.getParamStringValue(TAG_UNIONKEYVALUE, "");
    }

    public final void setUNIONKEYVALUE(String strValue) {
        this.setParamValue(TAG_UNIONKEYVALUE, strValue);
    }

    public final boolean isINDEXTYPENull() {
        return this.isParamNull(TAG_INDEXTYPE);
    }

    public final boolean getINDEXTYPE() {
        return this.getParamIntValue(TAG_INDEXTYPE, 0) == 1;
    }

    public final void setINDEXTYPE(boolean bValue) {
        this.setParamValue(TAG_INDEXTYPE, bValue ? 1 : 0);
    }

    public final boolean isMULTIFORMFIELDNull() {
        return this.isParamNull(TAG_MULTIFORMFIELD);
    }

    public final boolean getMULTIFORMFIELD() {
        return this.getParamIntValue(TAG_MULTIFORMFIELD, 0) == 1;
    }

    public final void setMULTIFORMFIELD(boolean bValue) {
        this.setParamValue(TAG_MULTIFORMFIELD, bValue ? 1 : 0);
    }

    public final boolean isFORMULAFORMATNull() {
        return this.isParamNull(TAG_FORMULAFORMAT);
    }

    public final String getFORMULAFORMAT() {
        return this.getParamStringValue(TAG_FORMULAFORMAT, "");
    }

    public final void setFORMULAFORMAT(String strValue) {
        this.setParamValue(TAG_FORMULAFORMAT, strValue);
    }

    public final boolean isFORMULAFIELDSNull() {
        return this.isParamNull(TAG_FORMULAFIELDS);
    }

    public final String getFORMULAFIELDS() {
        return this.getParamStringValue(TAG_FORMULAFIELDS, "");
    }

    public final void setFORMULAFIELDS(String strValue) {
        this.setParamValue(TAG_FORMULAFIELDS, strValue);
    }

    public final boolean isDUPCHECKMODENull() {
        return this.isParamNull(TAG_DUPCHECKMODE);
    }

    public final String getDUPCHECKMODE() {
        return this.getParamStringValue(TAG_DUPCHECKMODE, "");
    }

    public final void setDUPCHECKMODE(String strValue) {
        this.setParamValue(TAG_DUPCHECKMODE, strValue);
    }

    public final boolean isDUPCHECKVALUESNull() {
        return this.isParamNull(TAG_DUPCHECKVALUES);
    }

    public final String getDUPCHECKVALUES() {
        return this.getParamStringValue(TAG_DUPCHECKVALUES, "");
    }

    public final void setDUPCHECKVALUES(String strValue) {
        this.setParamValue(TAG_DUPCHECKVALUES, strValue);
    }

    public final boolean isDUPCHKPSDEFIDNull() {
        return this.isParamNull(TAG_DUPCHKPSDEFID);
    }

    public final String getDUPCHKPSDEFID() {
        return this.getParamStringValue(TAG_DUPCHKPSDEFID, "");
    }

    public final void setDUPCHKPSDEFID(String strValue) {
        this.setParamValue(TAG_DUPCHKPSDEFID, strValue);
    }

    public final boolean isDUPCHKPSDEFNAMENull() {
        return this.isParamNull(TAG_DUPCHKPSDEFNAME);
    }

    public final String getDUPCHKPSDEFNAME() {
        return this.getParamStringValue(TAG_DUPCHKPSDEFNAME, "");
    }

    public final void setDUPCHKPSDEFNAME(String strValue) {
        this.setParamValue(TAG_DUPCHKPSDEFNAME, strValue);
    }

    public final boolean isPSSYSVALUERULEIDNull() {
        return this.isParamNull(TAG_PSSYSVALUERULEID);
    }

    public final String getPSSYSVALUERULEID() {
        return this.getParamStringValue(TAG_PSSYSVALUERULEID, "");
    }

    public final void setPSSYSVALUERULEID(String strValue) {
        this.setParamValue(TAG_PSSYSVALUERULEID, strValue);
    }

    public final boolean isPSSYSVALUERULENAMENull() {
        return this.isParamNull(TAG_PSSYSVALUERULENAME);
    }

    public final String getPSSYSVALUERULENAME() {
        return this.getParamStringValue(TAG_PSSYSVALUERULENAME, "");
    }

    public final void setPSSYSVALUERULENAME(String strValue) {
        this.setParamValue(TAG_PSSYSVALUERULENAME, strValue);
    }

    public final boolean isDVTNull() {
        return this.isParamNull(TAG_DVT);
    }

    public final String getDVT() {
        return this.getParamStringValue(TAG_DVT, "");
    }

    public final void setDVT(String strValue) {
        this.setParamValue(TAG_DVT, strValue);
    }

    public final boolean isQUERYCOLUMNNull() {
        return this.isParamNull(TAG_QUERYCOLUMN);
    }

    public final boolean getQUERYCOLUMN() {
        return this.getParamIntValue(TAG_QUERYCOLUMN, 0) == 1;
    }

    public final void setQUERYCOLUMN(boolean bValue) {
        this.setParamValue(TAG_QUERYCOLUMN, bValue ? 1 : 0);
    }

    public final boolean isDBVALUEMODENull() {
        return this.isParamNull(TAG_DBVALUEMODE);
    }

    public final String getDBVALUEMODE() {
        return this.getParamStringValue(TAG_DBVALUEMODE, "");
    }

    public final void setDBVALUEMODE(String strValue) {
        this.setParamValue(TAG_DBVALUEMODE, strValue);
    }

    public final boolean isSTATEFIELDNull() {
        return this.isParamNull(TAG_STATEFIELD);
    }

    public final String getSTATEFIELD() {
        return this.getParamStringValue(TAG_STATEFIELD, "");
    }

    public final void setSTATEFIELD(String strValue) {
        this.setParamValue(TAG_STATEFIELD, strValue);
    }

    public final boolean isIMPORTKEYNull() {
        return this.isParamNull(TAG_IMPORTKEY);
    }

    public final boolean getIMPORTKEY() {
        return this.getParamIntValue(TAG_IMPORTKEY, 0) == 1;
    }

    public final void setIMPORTKEY(boolean bValue) {
        this.setParamValue(TAG_IMPORTKEY, bValue ? 1 : 0);
    }

    public final boolean isIMPORTORDERNull() {
        return this.isParamNull(TAG_IMPORTORDER);
    }

    public final int getIMPORTORDER() {
        return this.getParamIntValue(TAG_IMPORTORDER, 0);
    }

    public final void setIMPORTORDER(int nValue) {
        this.setParamValue(TAG_IMPORTORDER, nValue);
    }

    public final boolean isIMPORTTAGNull() {
        return this.isParamNull(TAG_IMPORTTAG);
    }

    public final String getIMPORTTAG() {
        return this.getParamStringValue(TAG_IMPORTTAG, "");
    }

    public final void setIMPORTTAG(String strValue) {
        this.setParamValue(TAG_IMPORTTAG, strValue);
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

    public final boolean isENAWRITEBACKNull() {
        return this.isParamNull(TAG_ENAWRITEBACK);
    }

    public final boolean getENAWRITEBACK() {
        return this.getParamIntValue(TAG_ENAWRITEBACK, 0) == 1;
    }

    public final void setENAWRITEBACK(boolean bValue) {
        this.setParamValue(TAG_ENAWRITEBACK, bValue ? 1 : 0);
    }

    public final boolean isSTRLENGTHNull() {
        return this.isParamNull(TAG_STRLENGTH);
    }

    public final int getSTRLENGTH() {
        return this.getParamIntValue(TAG_STRLENGTH, 0);
    }

    public final void setSTRLENGTH(int nValue) {
        this.setParamValue(TAG_STRLENGTH, nValue);
    }

    public final boolean isUSERPARAMSNull() {
        return this.isParamNull(TAG_USERPARAMS);
    }

    public final String getUSERPARAMS() {
        return this.getParamStringValue(TAG_USERPARAMS, "");
    }

    public final void setUSERPARAMS(String strValue) {
        this.setParamValue(TAG_USERPARAMS, strValue);
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

    public final boolean isTESTDATANull() {
        return this.isParamNull(TAG_TESTDATA);
    }

    public final String getTESTDATA() {
        return this.getParamStringValue(TAG_TESTDATA, "");
    }

    public final void setTESTDATA(String strValue) {
        this.setParamValue(TAG_TESTDATA, strValue);
    }

    public final boolean isPSSYSSAMPLEVALUEIDNull() {
        return this.isParamNull(TAG_PSSYSSAMPLEVALUEID);
    }

    public final String getPSSYSSAMPLEVALUEID() {
        return this.getParamStringValue(TAG_PSSYSSAMPLEVALUEID, "");
    }

    public final void setPSSYSSAMPLEVALUEID(String strValue) {
        this.setParamValue(TAG_PSSYSSAMPLEVALUEID, strValue);
    }

    public final boolean isPSSYSSAMPLEVALUENAMENull() {
        return this.isParamNull(TAG_PSSYSSAMPLEVALUENAME);
    }

    public final String getPSSYSSAMPLEVALUENAME() {
        return this.getParamStringValue(TAG_PSSYSSAMPLEVALUENAME, "");
    }

    public final void setPSSYSSAMPLEVALUENAME(String strValue) {
        this.setParamValue(TAG_PSSYSSAMPLEVALUENAME, strValue);
    }

    public final boolean isUNICODECHARNull() {
        return this.isParamNull(TAG_UNICODECHAR);
    }

    public final boolean getUNICODECHAR() {
        return this.getParamIntValue(TAG_UNICODECHAR, 0) == 1;
    }

    public final void setUNICODECHAR(boolean bValue) {
        this.setParamValue(TAG_UNICODECHAR, bValue ? 1 : 0);
    }

    public final boolean isENABLECOLPRIVNull() {
        return this.isParamNull(TAG_ENABLECOLPRIV);
    }

    public final boolean getENABLECOLPRIV() {
        return this.getParamIntValue(TAG_ENABLECOLPRIV, 0) == 1;
    }

    public final void setENABLECOLPRIV(boolean bValue) {
        this.setParamValue(TAG_ENABLECOLPRIV, bValue ? 1 : 0);
    }

    public final boolean isQUERYCSNull() {
        return this.isParamNull(TAG_QUERYCS);
    }

    public final String getQUERYCS() {
        return this.getParamStringValue(TAG_QUERYCS, "");
    }

    public final void setQUERYCS(String strValue) {
        this.setParamValue(TAG_QUERYCS, strValue);
    }

    public final boolean isORDERVALUENull() {
        return this.isParamNull(TAG_ORDERVALUE);
    }

    public final int getORDERVALUE() {
        return this.getParamIntValue(TAG_ORDERVALUE, 0);
    }

    public final void setORDERVALUE(int nValue) {
        this.setParamValue(TAG_ORDERVALUE, nValue);
    }

    public final boolean isENABLETEMPDATANull() {
        return this.isParamNull(TAG_ENABLETEMPDATA);
    }

    public final boolean getENABLETEMPDATA() {
        return this.getParamIntValue(TAG_ENABLETEMPDATA, 0) == 1;
    }

    public final void setENABLETEMPDATA(boolean bValue) {
        this.setParamValue(TAG_ENABLETEMPDATA, bValue ? 1 : 0);
    }

    public final boolean isLNPSLANRESIDNull() {
        return this.isParamNull(TAG_LNPSLANRESID);
    }

    public final String getLNPSLANRESID() {
        return this.getParamStringValue(TAG_LNPSLANRESID, "");
    }

    public final void setLNPSLANRESID(String strValue) {
        this.setParamValue(TAG_LNPSLANRESID, strValue);
    }

    public final boolean isLNPSLANRESNAMENull() {
        return this.isParamNull(TAG_LNPSLANRESNAME);
    }

    public final String getLNPSLANRESNAME() {
        return this.getParamStringValue(TAG_LNPSLANRESNAME, "");
    }

    public final void setLNPSLANRESNAME(String strValue) {
        this.setParamValue(TAG_LNPSLANRESNAME, strValue);
    }

    public final boolean isPSSYSUNITIDNull() {
        return this.isParamNull(TAG_PSSYSUNITID);
    }

    public final String getPSSYSUNITID() {
        return this.getParamStringValue(TAG_PSSYSUNITID, "");
    }

    public final void setPSSYSUNITID(String strValue) {
        this.setParamValue(TAG_PSSYSUNITID, strValue);
    }

    public final boolean isPSSYSUNITNAMENull() {
        return this.isParamNull(TAG_PSSYSUNITNAME);
    }

    public final String getPSSYSUNITNAME() {
        return this.getParamStringValue(TAG_PSSYSUNITNAME, "");
    }

    public final void setPSSYSUNITNAME(String strValue) {
        this.setParamValue(TAG_PSSYSUNITNAME, strValue);
    }

    public final boolean isVIEWCOLLEVELNull() {
        return this.isParamNull(TAG_VIEWCOLLEVEL);
    }

    public final int getVIEWCOLLEVEL() {
        return this.getParamIntValue(TAG_VIEWCOLLEVEL, 0);
    }

    public final void setVIEWCOLLEVEL(int nValue) {
        this.setParamValue(TAG_VIEWCOLLEVEL, nValue);
    }

    public final boolean isCHECKRECURSIONNull() {
        return this.isParamNull(TAG_CHECKRECURSION);
    }

    public final boolean getCHECKRECURSION() {
        return this.getParamIntValue(TAG_CHECKRECURSION, 0) == 1;
    }

    public final void setCHECKRECURSION(boolean bValue) {
        this.setParamValue(TAG_CHECKRECURSION, bValue ? 1 : 0);
    }

    public final boolean isBIZTAGNull() {
        return this.isParamNull(TAG_BIZTAG);
    }

    public final String getBIZTAG() {
        return this.getParamStringValue(TAG_BIZTAG, "");
    }

    public final void setBIZTAG(String strValue) {
        this.setParamValue(TAG_BIZTAG, strValue);
    }

    public final boolean isUSERTAG2Null() {
        return this.isParamNull(TAG_USERTAG2);
    }

    public final String getUSERTAG2() {
        return this.getParamStringValue(TAG_USERTAG2, "");
    }

    public final void setUSERTAG2(String strValue) {
        this.setParamValue(TAG_USERTAG2, strValue);
    }

    public final boolean isUSERTAGNull() {
        return this.isParamNull(TAG_USERTAG);
    }

    public final String getUSERTAG() {
        return this.getParamStringValue(TAG_USERTAG, "");
    }

    public final void setUSERTAG(String strValue) {
        this.setParamValue(TAG_USERTAG, strValue);
    }

    public final boolean isDBVALUEMODE2Null() {
        return this.isParamNull(TAG_DBVALUEMODE2);
    }

    public final String getDBVALUEMODE2() {
        return this.getParamStringValue(TAG_DBVALUEMODE2, "");
    }

    public final void setDBVALUEMODE2(String strValue) {
        this.setParamValue(TAG_DBVALUEMODE2, strValue);
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
    }
}

