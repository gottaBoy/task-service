/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;

public class DEField
extends BaseDataEntity {
    public static final int ENCRYPTSTORAGE_NONE = 0;
    public static final int ENCRYPTSTORAGE_HASH = 1;
    public static final int PWDSTORAGE_NONE = 0;
    public static final int PWDSTORAGE_NOREVERT = 1;
    public static final int PWDSTORAGE_REVERT = 2;
    public static final String UPDATEOVMODE_ALWAYS = "ALWAYS";
    public static final String UPDATEOVMODE_NOTEXISTS = "NOTEXISTS";
    public static final String PROPERTY_FORMULAFORMAT = "FORMULAFORMAT";
    public static final String PROPERTY_FORMULAFIELD = "FORMULAFIELD";
    public static final String PROPERTY_DEFAULTVALUE = "DEFAULTVALUE";
    public static final String PREDEFINETYPE_CREATEMAN = "CREATEMAN";
    public static final String PREDEFINETYPE_CREATEDATE = "CREATEDATE";
    public static final String PREDEFINETYPE_UPDATEMAN = "UPDATEMAN";
    public static final String PREDEFINETYPE_UPDATEDATE = "UPDATEDATE";
    public static final String PREDEFINETYPE_LOGICVALID = "LOGICVALID";
    public static final String PREDEFINETYPE_ORGUNITID = "ORGUNITID";
    public static final String PREDEFINETYPE_ORGUNITNAME = "ORGUNITNAME";
    public static final int TAG_DEFTYPE_PHISICAL = 1;
    public static final int TAG_DEFTYPE_FORMULA = 2;
    public static final int TAG_DEFTYPE_LINK = 3;
    public static final String STRINGCASE_UCASE = "UCASE";
    public static final String STRINGCASE_LCASE = "LCASE";
    public static final String DERTYPE_DER1N = "DER1N";
    public static final String DERTYPE_DERCUSTOM = "DERCUSTOM";
    public static final String CARETRETMODE_NONE = "NONE";
    public static final String CARETRETMODE_USER = "USER";
    public static final String CARETRETMODE_GLOBAL = "GLOBAL";
    public static final String TAG_DATATYPE_TEXT = "TEXT";
    public static final String TAG_DATATYPE_LONGTEXT = "LONGTEXT";
    public static final String TAG_DATATYPE_HTMLTEXT = "HTMLTEXT";
    public static final String TAG_DATATYPE_INT = "INT";
    public static final String TAG_DATATYPE_FLOAT = "FLOAT";
    public static final String TAG_DATATYPE_GUID = "GUID";
    public static final String TAG_DATATYPE_SBID = "SBID";
    public static final String TAG_DATATYPE_NBID = "NBID";
    public static final String TAG_DATATYPE_DATETIME = "DATETIME";
    public static final String TAG_DATATYPE_TIME = "TIME";
    public static final String TAG_DATATYPE_DATE = "DATE";
    public static final String TAG_DATATYPE_SSCODELIST = "SSCODELIST";
    public static final String TAG_DATATYPE_SMCODELIST = "SMCODELIST";
    public static final String TAG_DATATYPE_NSCODELIST = "NSCODELIST";
    public static final String TAG_DATATYPE_NMCODELIST = "NMCODELIST";
    public static final String TAG_DATATYPE_PICKUP = "PICKUP";
    public static final String TAG_DATATYPE_PICKUPTEXT = "PICKUPTEXT";
    public static final String TAG_DATATYPE_PICKUPDATA = "PICKUPDATA";
    public static final String TAG_DATATYPE_YESNO = "YESNO";
    public static final String TAG_DATATYPE_TRUEFALSE = "TRUEFALSE";
    public static final String TAG_DATATYPE_INHERIT = "INHERIT";
    public static final String TAG_DEFID = "DEFID";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_TABLENAME = "TABLENAME";
    public static final String TAG_DEFNAME = "DEFNAME";
    public static final String TAG_DEFLOGICNAME = "DEFLOGICNAME";
    public static final String TAG_DEFTYPE = "DEFTYPE";
    public static final String TAG_DEFAULTVALUE = "DEFAULTVALUE";
    public static final String TAG_ISNULLABLE = "ISNULLABLE";
    public static final String TAG_DATATYPE = "DATATYPE";
    public static final String TAG_DATATYPEPARAM = "DATATYPEPARAM";
    public static final String TAG_LENGTH = "LENGTH";
    public static final String TAG_ISMAJOR = "ISMAJOR";
    public static final String TAG_ISPKEY = "ISPKEY";
    public static final String TAG_ISFKEY = "ISFKEY";
    public static final String TAG_ISSEARCHABLE = "ISSEARCHABLE";
    public static final String TAG_LOGICEXPRESSION = "LOGICEXPRESSION";
    public static final String TAG_ORDERFLAG = "ORDERFLAG";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_RESERVER = "RESERVER";
    public static final String TAG_RESERVER2 = "RESERVER2";
    public static final String TAG_ENABLE = "ENABLE";
    public static final String TAG_DATATYPEEXT = "DATATYPEEXT";
    public static final String TAG_DATATYPEPARAM2 = "DATATYPEPARAM2";
    public static final String TAG_DATATYPEPARAM3 = "DATATYPEPARAM3";
    public static final String TAG_DATATYPEPARAM4 = "DATATYPEPARAM4";
    public static final String TAG_ISENABLECREATE = "ISENABLECREATE";
    public static final String TAG_ISENABLEMODIFY = "ISENABLEMODIFY";
    public static final String TAG_FORMDV = "FORMDV";
    public static final String TAG_FORMDVT = "FORMDVT";
    public static final String TAG_ISDUPCHECK = "ISDUPCHECK";
    public static final String TAG_DUPCHECKRANGE = "DUPCHECKRANGE";
    public static final String TAG_ISSYSTEM = "ISSYSTEM";
    public static final String TAG_CODELIST = "CODELIST";
    public static final String TAG_PICKUPRANGE = "PICKUPRANGE";
    public static final String TAG_FORMITEMSTYLE = "FORMITEMSTYLE";
    public static final String TAG_FORMITEMXML = "FORMITEMXML";
    public static final String TAG_ISACSEARCH = "ISACSEARCH";
    public static final String TAG_SEARCHMODEL = "SEARCHMODEL";
    public static final String TAG_REALDATATYPE = "REALDATATYPE";
    public static final String TAG_REALDATATYPEEXT = "REALDATATYPEEXT";
    public static final String TAG_CODELISTID = "CODELISTID";
    public static final String TAG_CODELISTNAME = "CODELISTNAME";
    public static final String TAG_INSERTMODE = "INESRTMODE";
    public static final String TAG_UPDATEMODE = "UPDATEMODE";
    public static final String TAG_FORMULAFORMAT = "FORMULAFORMAT";
    public static final String TAG_FORMULAFIELD = "FORMULAFIELD";
    public static final String TAG_FORMITEMCONFIG = "FORMITEMCONFIG";
    public static final String TAG_DEFHELPER = "DEFHELPER";
    public static final String TAG_UNIT = "UNIT";
    public static final String TAG_UNITWIDTH = "UNITWIDTH";
    public static final String TAG_ISMTFIELD = "ISMTFIELD";
    public static final String TAG_ISINDEXTYPE = "ISINDEXTYPE";
    public static final String TAG_PASTERESET = "PASTERESET";
    public static final String TAG_FORMITEMFORMAT = "FORMITEMFORMAT";
    public static final String TAG_DSITEMFORMAT = "DSITEMFORMAT";
    public static final String TAG_DGCOLUMNCAPTION = "DGCOLUMNCAPTION";
    public static final String TAG_DSITEMCUSTOM = "DSITEMCUSTOM";
    public static final String TAG_DSITEMGROUP = "DSITEMGROUP";
    public static final String TAG_DGCOLRENDER = "DGCOLRENDER";
    public static final String TAG_DGCOLRENDERCUSTOM = "DGCOLRENDERCUSTOM";
    public static final String TAG_DGCOLRENDERPARAM = "DGCOLRENDERPARAM";
    public static final String TAG_ISDGCOLEDITABLE = "ISDGCOLEDITABLE";
    public static final String TAG_VALUERULE = "VALUERULE";
    public static final String TAG_CUSTOMVALUERULE = "CUSTOMVALUERULE";
    public static final String TAG_VALUERULEINFO = "VALUERULEINFO";
    public static final String TAG_DGCOLEDITOR = "DGCOLEDITOR";
    public static final String TAG_DGCOLEDITORPARAM = "DGCOLEDITORPARAM";
    public static final String TAG_AUDITINFOFORMAT = "AUDITINFOFORMAT";
    public static final String TAG_DGCOLVALIDCOND = "DGCOLVALIDCOND";
    public static final String TAG_STATNULLCONV = "STATNULLCONV";
    public static final String TAG_QUERYHELPER = "QUERYHELPER";
    public static final String TAG_DGCOLUMNALIGN = "DGCOLUMNALIGN";
    public static final String TAG_ISENABLEAUDIT = "ISENABLEAUDIT";
    public static final String TAG_ISUSERVISIBLE = "ISUSERVISIBLE";
    public static final String TAG_PRECISION2 = "PRECISION2";
    public static final String TAG_DUPCHECKCODE = "DUPCHECKCODE";
    public static final String TAG_DUPCHECKCODE2 = "DUPCHECKCODE2";
    public static final String TAG_PREDEFINETYPE = "PREDEFINETYPE";
    public static final String TAG_DEFPARAM = "DEFPARAM";
    public static final String TAG_DEFUSERPARAM = "DEFUSERPARAM";
    public static final String TAG_EXCELIMPID = "EXCELIMPID";
    public static final String TAG_EXCELIMPORDER = "EXCELIMPORDER";
    public static final String TAG_QUERYCS = "QUERYCS";
    public static final String TAG_NOSORT = "NOSORT";
    public static final String TAG_UNICODETEXT = "UNICODETEXT";
    public static final String TAG_ENABLECOLPRIV = "ENABLECOLPRIV";
    public static final String TAG_DERTYPE = "DERTYPE";
    public static final String TAG_DERCUSTOMID = "DERCUSTOMID";
    public static final String TAG_DERCUSTOMNAME = "DERCUSTOMNAME";
    public static final String TAG_RDEFID2 = "RDEFID2";
    public static final String TAG_EXCELIMPKEY = "EXCELIMPKEY";
    public static final String TAG_VALUERULEID = "VALUERULEID";
    public static final String TAG_VALUERULENAME = "VALUERULENAME";
    public static final String TAG_DGFIUPDATEID = "DGFIUPDATEID";
    public static final String TAG_DGFIUPDATENAME = "DGFIUPDATENAME";
    public static final String TAG_DGCOLEDITORCUSTOM = "DGCOLEDITORCUSTOM";
    public static final String TAG_DGCOLEXCLUDE = "DGCOLEXCLUDE";
    public static final String TAG_STRINGCASE = "STRINGCASE";
    public static final String TAG_CARETTEMPLGROUPID = "CARETTEMPLGROUPID";
    public static final String TAG_CARETTEMPLGROUPNAME = "CARETTEMPLGROUPNAME";
    public static final String TAG_CARETRETMODE = "CARETRETMODE";
    public static final String TAG_UPDATEOVMODE = "UPDATEOVMODE";
    public static final String TAG_PWDSTORAGE = "PWDSTORAGE";
    public static final String TAG_SAVEDATAACTION = "SAVEDATAACTION";
    public static final String TAG_REMOVEDATAACTION = "REMOVEDATAACTION";
    public static final String TAG_CODELISTPARAM = "CODELISTPARAM";
    public static final String TAG_UIASSIST = "UIASSIST";
    public static final String TAG_ENCRYPTSTORAGE = "ENCRYPTSTORAGE";
    public static final String TAG_INPUTTIPS = "INPUTTIPS";
    public static final String TAG_FORMULAPHY = "FORMULAPHY";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_RDEFNAME = "RDEFNAME";
    public static final String TAG_RDEFNAME2 = "RDEFNAME2";

    public String getDEFID() {
        return this.GetParamStringValue(TAG_DEFID, "").trim();
    }

    public String getDEID() {
        return this.GetParamStringValue(TAG_DEID, "").trim();
    }

    public String getTABLENAME() {
        return this.GetParamStringValue(TAG_TABLENAME, "");
    }

    public String getDEFNAME() {
        return this.GetParamStringValue(TAG_DEFNAME, "");
    }

    public String getDEFLOGICNAME() {
        return this.GetParamStringValue(TAG_DEFLOGICNAME, "");
    }

    public String getDEFAULTVALUE() {
        return this.GetParamStringValue("DEFAULTVALUE", "");
    }

    public String getDATATYPE() {
        return this.GetParamStringValue(TAG_DATATYPE, "");
    }

    public String getDATATYPEPARAM() {
        return this.GetParamStringValue(TAG_DATATYPEPARAM, "");
    }

    public String getLOGICEXPRESSION() {
        return this.GetParamStringValue(TAG_LOGICEXPRESSION, "");
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public String getCREATEMAN() {
        return this.GetParamStringValue("CREATEMAN", "");
    }

    public String getUPDATEMAN() {
        return this.GetParamStringValue("UPDATEMAN", "");
    }

    public String getRESERVER() {
        return this.GetParamStringValue(TAG_RESERVER, "");
    }

    public String getRESERVER2() {
        return this.GetParamStringValue(TAG_RESERVER2, "");
    }

    public String getDATATYPEEXT() {
        return this.GetParamStringValue(TAG_DATATYPEEXT, "");
    }

    public String getDATATYPEPARAM2() {
        return this.GetParamStringValue(TAG_DATATYPEPARAM2, "");
    }

    public String getDATATYPEPARAM3() {
        return this.GetParamStringValue(TAG_DATATYPEPARAM3, "");
    }

    public String getDATATYPEPARAM4() {
        return this.GetParamStringValue(TAG_DATATYPEPARAM4, "");
    }

    public String getFORMDV() {
        return this.GetParamStringValue(TAG_FORMDV, "");
    }

    public String getFORMDVT() {
        return this.GetParamStringValue(TAG_FORMDVT, "");
    }

    public String getDUPCHECKRANGE() {
        return this.GetParamStringValue(TAG_DUPCHECKRANGE, "");
    }

    public String getDUPCHECKCODE() {
        return this.GetParamStringValue(TAG_DUPCHECKCODE, "");
    }

    public String getDUPCHECKCODE2() {
        return this.GetParamStringValue(TAG_DUPCHECKCODE2, "");
    }

    public String getCODELIST() {
        return this.GetParamStringValue(TAG_CODELIST, "");
    }

    public String getPICKUPRANGE() {
        return this.GetParamStringValue(TAG_PICKUPRANGE, "");
    }

    public String getFORMITEMSTYLE() {
        return this.GetParamStringValue(TAG_FORMITEMSTYLE, "");
    }

    public String getFORMITEMXML() {
        return this.GetParamStringValue(TAG_FORMITEMXML, "");
    }

    public String getSEARCHMODEL() {
        return this.GetParamStringValue(TAG_SEARCHMODEL, "");
    }

    public String getQUERYHELPER() {
        return this.GetParamStringValue(TAG_QUERYHELPER, "");
    }

    public String getREALDATATYPE() {
        return this.GetParamStringValue(TAG_REALDATATYPE, "");
    }

    public String getREALDATATYPEEXT() {
        return this.GetParamStringValue(TAG_REALDATATYPEEXT, "");
    }

    public String getCODELISTID() {
        return this.GetParamStringValue(TAG_CODELISTID, "");
    }

    public String getINSERTMODE() {
        return this.GetParamStringValue(TAG_INSERTMODE, "");
    }

    public String getUPDATEMODE() {
        return this.GetParamStringValue(TAG_UPDATEMODE, "");
    }

    public String getFORMULAFORMAT() {
        return this.GetParamStringValue("FORMULAFORMAT", "");
    }

    public String getFORMULAFIELD() {
        return this.GetParamStringValue("FORMULAFIELD", "");
    }

    public String getFORMITEMCONFIG() {
        return this.GetParamStringValue(TAG_FORMITEMCONFIG, "");
    }

    public String getSTATNULLCONV() {
        return this.GetParamStringValue(TAG_STATNULLCONV, "");
    }

    public String getDGCOLUMNCAPTION() {
        return this.GetParamStringValue(TAG_DGCOLUMNCAPTION, "");
    }

    public String getDSITEMCUSTOM() {
        return this.GetParamStringValue(TAG_DSITEMCUSTOM, "");
    }

    public String getDSITEMGROUP() {
        return this.GetParamStringValue(TAG_DSITEMGROUP, "");
    }

    public String getDGCOLUMNALIGN() {
        return this.GetParamStringValue(TAG_DGCOLUMNALIGN, "");
    }

    public String getDGCOLRENDER() {
        return this.GetParamStringValue(TAG_DGCOLRENDER, "");
    }

    public String getDGCOLRENDERCUSTOM() {
        return this.GetParamStringValue(TAG_DGCOLRENDERCUSTOM, "");
    }

    public String getDGCOLRENDERPARAM() {
        return this.GetParamStringValue(TAG_DGCOLRENDERPARAM, "");
    }

    public String getDGCOLEDITOR() {
        return this.GetParamStringValue(TAG_DGCOLEDITOR, "");
    }

    public String getDGCOLEDITORPARAM() {
        return this.GetParamStringValue(TAG_DGCOLEDITORPARAM, "");
    }

    public String getDGCOLVALIDCOND() {
        return this.GetParamStringValue(TAG_DGCOLVALIDCOND, "");
    }

    public String getVALUERULE() {
        return this.GetParamStringValue(TAG_VALUERULE, "");
    }

    public String getCUSTOMVALUERULE() {
        return this.GetParamStringValue(TAG_CUSTOMVALUERULE, "");
    }

    public String getVALUERULEINFO() {
        return this.GetParamStringValue(TAG_VALUERULEINFO, "");
    }

    public String getPREDEFINETYPE() {
        return this.GetParamStringValue(TAG_PREDEFINETYPE, "");
    }

    public String getDEFPARAM() {
        return this.GetParamStringValue(TAG_DEFPARAM, "");
    }

    public String getDEFUSERPARAM() {
        return this.GetParamStringValue(TAG_DEFUSERPARAM, "");
    }

    public int getPRECISION2() {
        return this.GetParamIntValue(TAG_PRECISION2, -1);
    }

    public void setDEFID(String strValue) {
        this.SetParamValue(TAG_DEFID, strValue);
    }

    public void setDEID(String strValue) {
        this.SetParamValue(TAG_DEID, strValue);
    }

    public void setTABLENAME(String strValue) {
        this.SetParamValue(TAG_TABLENAME, strValue);
    }

    public void setDEFNAME(String strValue) {
        this.SetParamValue(TAG_DEFNAME, strValue);
    }

    public void setDEFLOGICNAME(String strValue) {
        this.SetParamValue(TAG_DEFLOGICNAME, strValue);
    }

    public void setDEFAULTVALUE(String strValue) {
        this.SetParamValue("DEFAULTVALUE", strValue);
    }

    public void setDATATYPE(String strValue) {
        this.SetParamValue(TAG_DATATYPE, strValue);
    }

    public void setDATATYPEPARAM(String strValue) {
        this.SetParamValue(TAG_DATATYPEPARAM, strValue);
    }

    public void setLOGICEXPRESSION(String strValue) {
        this.SetParamValue(TAG_LOGICEXPRESSION, strValue);
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }

    public void setCREATEMAN(String strValue) {
        this.SetParamValue("CREATEMAN", strValue);
    }

    public void setUPDATEMAN(String strValue) {
        this.SetParamValue("UPDATEMAN", strValue);
    }

    public void setRESERVER(String strValue) {
        this.SetParamValue(TAG_RESERVER, strValue);
    }

    public void setRESERVER2(String strValue) {
        this.SetParamValue(TAG_RESERVER2, strValue);
    }

    public void setDATATYPEEXT(String strValue) {
        this.SetParamValue(TAG_DATATYPEEXT, strValue);
    }

    public void setDATATYPEPARAM2(String strValue) {
        this.SetParamValue(TAG_DATATYPEPARAM2, strValue);
    }

    public void setDATATYPEPARAM3(String strValue) {
        this.SetParamValue(TAG_DATATYPEPARAM3, strValue);
    }

    public void setDATATYPEPARAM4(String strValue) {
        this.SetParamValue(TAG_DATATYPEPARAM4, strValue);
    }

    public void setFORMDV(String strValue) {
        this.SetParamValue(TAG_FORMDV, strValue);
    }

    public void setFORMDVT(String strValue) {
        this.SetParamValue(TAG_FORMDVT, strValue);
    }

    public void setDUPCHECKRANGE(String strValue) {
        this.SetParamValue(TAG_DUPCHECKRANGE, strValue);
    }

    public void setCODELIST(String strValue) {
        this.SetParamValue(TAG_CODELIST, strValue);
    }

    public void setPICKUPRANGE(String strValue) {
        this.SetParamValue(TAG_PICKUPRANGE, strValue);
    }

    public void setFORMITEMSTYLE(String strValue) {
        this.SetParamValue(TAG_FORMITEMSTYLE, strValue);
    }

    public void setFORMITEMXML(String strValue) {
        this.SetParamValue(TAG_FORMITEMXML, strValue);
    }

    public void setSEARCHMODEL(String strValue) {
        this.SetParamValue(TAG_SEARCHMODEL, strValue);
    }

    public void setREALDATATYPE(String strValue) {
        this.SetParamValue(TAG_REALDATATYPE, strValue);
    }

    public void setREALDATATYPEEXT(String strValue) {
        this.SetParamValue(TAG_REALDATATYPEEXT, strValue);
    }

    public void setCODELISTID(String strValue) {
        this.SetParamValue(TAG_CODELISTID, strValue);
    }

    public void setINSERTMODE(String strValue) {
        this.SetParamValue(TAG_INSERTMODE, strValue);
    }

    public void setUPDATEMODE(String strValue) {
        this.SetParamValue(TAG_UPDATEMODE, strValue);
    }

    public void setSTATNULLCONV(String strValue) {
        this.SetParamValue(TAG_STATNULLCONV, strValue);
    }

    public void setDEFPARAM(String strValue) {
        this.SetParamValue(TAG_DEFPARAM, strValue);
    }

    public boolean isNULLABLE() {
        return this.GetParamIntValue(TAG_ISNULLABLE, 0) == 1;
    }

    public boolean isMAJOR() {
        return this.GetParamIntValue(TAG_ISMAJOR, 0) == 1;
    }

    public boolean isPKEY() {
        return this.GetParamIntValue(TAG_ISPKEY, 0) == 1;
    }

    public boolean isFKEY() {
        return this.GetParamIntValue(TAG_ISFKEY, 0) == 1;
    }

    public boolean isSHORTWORDSEARCH() {
        return this.GetParamIntValue(TAG_ISSEARCHABLE, 0) == 1;
    }

    public boolean isENABLECREATE() {
        return this.GetParamIntValue(TAG_ISENABLECREATE, 1) == 1;
    }

    public boolean isENABLEMODIFY() {
        return this.GetParamIntValue(TAG_ISENABLEMODIFY, 1) == 1;
    }

    public boolean isDUPCHECK() {
        return this.GetParamIntValue(TAG_ISDUPCHECK, 0) == 1;
    }

    public boolean isSYSTEM() {
        return this.GetParamIntValue(TAG_ISSYSTEM, 0) == 1;
    }

    public boolean isACSEARCH() {
        return this.GetParamIntValue(TAG_ISACSEARCH, 0) == 1;
    }

    public boolean isACSEARCH(boolean bDefault) {
        return this.GetParamIntValue(TAG_ISACSEARCH, bDefault ? 1 : 0) == 1;
    }

    public boolean isMTFIELD() {
        return this.GetParamIntValue(TAG_ISMTFIELD, 0) == 1;
    }

    public boolean isINDEXTYPE() {
        return this.GetParamIntValue(TAG_ISINDEXTYPE, 0) == 1;
    }

    public boolean isPASTERESET() {
        return this.GetParamIntValue(TAG_PASTERESET, 0) == 1;
    }

    public boolean isDGCOLEDITABLE() {
        return this.GetParamIntValue(TAG_ISDGCOLEDITABLE, 0) == 1;
    }

    public void setISNULLABLE(boolean bValue) {
        this.SetParamValue(TAG_ISNULLABLE, bValue ? 1 : 0);
    }

    public void setISMAJOR(boolean bValue) {
        this.SetParamValue(TAG_ISMAJOR, bValue ? 1 : 0);
    }

    public void setISPKEY(boolean bValue) {
        this.SetParamValue(TAG_ISPKEY, bValue ? 1 : 0);
    }

    public void setISFKEY(boolean bValue) {
        this.SetParamValue(TAG_ISFKEY, bValue ? 1 : 0);
    }

    public void setISSEARCHABLE(boolean bValue) {
        this.SetParamValue(TAG_ISSEARCHABLE, bValue ? 1 : 0);
    }

    public void setISENABLECREATE(boolean bValue) {
        this.SetParamValue(TAG_ISENABLECREATE, bValue ? 1 : 0);
    }

    public void setISENABLEMODIFY(boolean bValue) {
        this.SetParamValue(TAG_ISENABLEMODIFY, bValue ? 1 : 0);
    }

    public void setISDUPCHECK(boolean bValue) {
        this.SetParamValue(TAG_ISDUPCHECK, bValue ? 1 : 0);
    }

    public void setISSYSTEM(boolean bValue) {
        this.SetParamValue(TAG_ISSYSTEM, bValue ? 1 : 0);
    }

    public void setISACSEAR(boolean bValue) {
        this.SetParamValue(TAG_ISACSEARCH, bValue ? 1 : 0);
    }

    public void setISMTFIELD(boolean bValue) {
        this.SetParamValue(TAG_ISMTFIELD, bValue ? 1 : 0);
    }

    public void setISINDEXTYPE(boolean bValue) {
        this.SetParamValue(TAG_ISINDEXTYPE, bValue ? 1 : 0);
    }

    public int getDEFTYPE() {
        return this.GetParamIntValue(TAG_DEFTYPE, 0);
    }

    public int getLENGTH() {
        return this.GetParamIntValue(TAG_LENGTH, 0);
    }

    public int getORDERFLAG() {
        return this.GetParamIntValue(TAG_ORDERFLAG, 0);
    }

    public int getENABLE() {
        return this.GetParamIntValue(TAG_ENABLE, 0);
    }

    public void setDEFTYPE(int nValue) {
        this.SetParamValue(TAG_DEFTYPE, nValue);
    }

    public void setLENGTH(int nValue) {
        this.SetParamValue(TAG_LENGTH, nValue);
    }

    public void setORDERFLAG(int nValue) {
        this.SetParamValue(TAG_ORDERFLAG, nValue);
    }

    public void setENABLE(int nValue) {
        this.SetParamValue(TAG_ENABLE, nValue);
    }

    public String getRELATEDDEFIELD() {
        return this.GetParamStringValue(TAG_DATATYPEPARAM, "");
    }

    public void setRELATEDDEFIELD(String strValue) {
        this.SetParamValue(TAG_DATATYPEPARAM, strValue);
    }

    public String getDERID() {
        return this.GetParamStringValue(TAG_DATATYPEPARAM4, "");
    }

    public void setDERID(String strValue) {
        this.SetParamValue(TAG_DATATYPEPARAM4, strValue);
    }

    public String getPICKUPTEXTDEFIELD() {
        return this.GetParamStringValue(TAG_DATATYPEPARAM2, "");
    }

    public void setPICKUPTEXTDEFIELD(String strValue) {
        this.SetParamValue(TAG_DATATYPEPARAM2, strValue);
    }

    public String getDEFHELPER() {
        return this.GetParamStringValue(TAG_DEFHELPER, "");
    }

    public void setDEFHELPER(String strValue) {
        this.SetParamValue(TAG_DEFHELPER, strValue);
    }

    public String getUNIT() {
        return this.GetParamStringValue(TAG_UNIT, "");
    }

    public void setUNIT(String strValue) {
        this.SetParamValue(TAG_UNIT, strValue);
    }

    public int getUNITWIDTH() {
        return this.GetParamIntValue(TAG_UNITWIDTH, 0);
    }

    public void setUNITWIDTH(int nWidth) {
        this.SetParamValue(TAG_UNITWIDTH, nWidth);
    }

    public String getFORMITEMFORMAT() {
        return this.GetParamStringValue(TAG_FORMITEMFORMAT, "");
    }

    public String getDSITEMFORMAT() {
        return this.GetParamStringValue(TAG_DSITEMFORMAT, "");
    }

    public String getDERTYPE() {
        return this.GetParamStringValue(TAG_DERTYPE, "");
    }

    public void setDERTYPE(String strValue) {
        this.SetParamValue(TAG_DERTYPE, strValue);
    }

    public String getDERCUSTOMID() {
        return this.GetParamStringValue(TAG_DERCUSTOMID, "");
    }

    public void setDERCUSTOMID(String strValue) {
        this.SetParamValue(TAG_DERCUSTOMID, strValue);
    }

    public String getDERCUSTOMNAME() {
        return this.GetParamStringValue(TAG_DERCUSTOMNAME, "");
    }

    public void setDERCUSTOMNAME(String strValue) {
        this.SetParamValue(TAG_DERCUSTOMNAME, strValue);
    }

    public String getRDEFID2() {
        return this.GetParamStringValue(TAG_RDEFID2, "");
    }

    public void setRDEFID2(String strValue) {
        this.SetParamValue(TAG_RDEFID2, strValue);
    }

    public String getRDEFNAME2() {
        return this.GetParamStringValue(TAG_RDEFNAME2, "");
    }

    public void setRDEFNAME2(String strValue) {
        this.SetParamValue(TAG_RDEFNAME2, strValue);
    }

    public static String ToDEFTypeString(int nDEFType) {
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

    public boolean isENABLEAUDIT() {
        return this.GetParamIntValue(TAG_ISENABLEAUDIT, 0) == 1;
    }

    public boolean isUSERVISIBLE() {
        return this.GetParamIntValue(TAG_ISUSERVISIBLE, 1) == 1;
    }

    public String getEXCELIMPID() {
        return this.GetParamStringValue(TAG_EXCELIMPID, this.getDEFNAME());
    }

    public void setEXCELIMPID(String strValue) {
        this.SetParamValue(TAG_EXCELIMPID, strValue);
    }

    public int getEXCELIMPORDER() {
        return this.GetParamIntValue(TAG_EXCELIMPORDER, 100);
    }

    public void setEXCELIMPORDER(int nValue) {
        this.SetParamValue(TAG_EXCELIMPORDER, nValue);
    }

    public String getAUDITINFOFORMAT() {
        return this.GetParamStringValue(TAG_AUDITINFOFORMAT, "");
    }

    public void setAUDITINFOFORMAT(String strValue) {
        this.SetParamValue(TAG_AUDITINFOFORMAT, strValue);
    }

    public String getQUERYCS() {
        return this.GetParamStringValue(TAG_QUERYCS, "");
    }

    public void setQUERYCS(String strValue) {
        this.SetParamValue(TAG_QUERYCS, strValue);
    }

    public boolean getNOSORT() {
        return this.GetParamIntValue(TAG_NOSORT, 0) == 1;
    }

    public void setNOSORT(boolean bValue) {
        this.SetParamValue(TAG_NOSORT, bValue ? 1 : 0);
    }

    public boolean getUNICODETEXT() {
        return this.GetParamIntValue(TAG_UNICODETEXT, 1) == 1;
    }

    public void setUNICODETEXT(boolean bValue) {
        this.SetParamValue(TAG_UNICODETEXT, bValue ? 1 : 0);
    }

    public boolean getENABLECOLPRIV() {
        return this.GetParamIntValue(TAG_ENABLECOLPRIV, 0) == 1;
    }

    public void setENABLECOLPRIV(boolean bValue) {
        this.SetParamValue(TAG_ENABLECOLPRIV, bValue ? 1 : 0);
    }

    public boolean getEXCELIMPKEY() {
        return this.GetParamIntValue(TAG_EXCELIMPKEY, 0) == 1;
    }

    public void setEXCELIMPKEY(boolean bValue) {
        this.SetParamValue(TAG_EXCELIMPKEY, bValue ? 1 : 0);
    }

    public String getVALUERULEID() {
        return this.GetParamStringValue(TAG_VALUERULEID, "");
    }

    public void setVALUERULEID(String strValue) {
        this.SetParamValue(TAG_VALUERULEID, strValue);
    }

    public String getVALUERULENAME() {
        return this.GetParamStringValue(TAG_VALUERULENAME, "");
    }

    public void setVALUERULENAME(String strValue) {
        this.SetParamValue(TAG_VALUERULENAME, strValue);
    }

    public boolean isDGFIUPDATEIDNull() {
        return this.IsParamNull(TAG_DGFIUPDATEID);
    }

    public String getDGFIUPDATEID() {
        return this.GetParamStringValue(TAG_DGFIUPDATEID, "");
    }

    public void setDGFIUPDATEID(String strValue) {
        this.SetParamValue(TAG_DGFIUPDATEID, strValue);
    }

    public boolean isDGFIUPDATENAMENull() {
        return this.IsParamNull(TAG_DGFIUPDATENAME);
    }

    public String getDGFIUPDATENAME() {
        return this.GetParamStringValue(TAG_DGFIUPDATENAME, "");
    }

    public void setDGFIUPDATENAME(String strValue) {
        this.SetParamValue(TAG_DGFIUPDATENAME, strValue);
    }

    public boolean isDGCOLEDITORCUSTOMNull() {
        return this.IsParamNull(TAG_DGCOLEDITORCUSTOM);
    }

    public String getDGCOLEDITORCUSTOM() {
        return this.GetParamStringValue(TAG_DGCOLEDITORCUSTOM, "");
    }

    public void setDGCOLEDITORCUSTOM(String strValue) {
        this.SetParamValue(TAG_DGCOLEDITORCUSTOM, strValue);
    }

    public boolean isDGCOLEXCLUDENull() {
        return this.IsParamNull(TAG_DGCOLEXCLUDE);
    }

    public boolean getDGCOLEXCLUDE() {
        return this.GetParamIntValue(TAG_DGCOLEXCLUDE, 0) == 1;
    }

    public void setDGCOLEXCLUDE(boolean bValue) {
        this.SetParamValue(TAG_DGCOLEXCLUDE, bValue ? 1 : 0);
    }

    public boolean isSTRINGCASENull() {
        return this.IsParamNull(TAG_STRINGCASE);
    }

    public String getSTRINGCASE() {
        return this.GetParamStringValue(TAG_STRINGCASE, "");
    }

    public void setSTRINGCASE(String strValue) {
        this.SetParamValue(TAG_STRINGCASE, strValue);
    }

    public boolean isCARETTEMPLGROUPIDNull() {
        return this.IsParamNull(TAG_CARETTEMPLGROUPID);
    }

    public String getCARETTEMPLGROUPID() {
        return this.GetParamStringValue(TAG_CARETTEMPLGROUPID, "");
    }

    public void setCARETTEMPLGROUPID(String strValue) {
        this.SetParamValue(TAG_CARETTEMPLGROUPID, strValue);
    }

    public boolean isCARETTEMPLGROUPNAMENull() {
        return this.IsParamNull(TAG_CARETTEMPLGROUPNAME);
    }

    public String getCARETTEMPLGROUPNAME() {
        return this.GetParamStringValue(TAG_CARETTEMPLGROUPNAME, "");
    }

    public void setCARETTEMPLGROUPNAME(String strValue) {
        this.SetParamValue(TAG_CARETTEMPLGROUPNAME, strValue);
    }

    public boolean isCARETRETMODENull() {
        return this.IsParamNull(TAG_CARETRETMODE);
    }

    public String getCARETRETMODE() {
        return this.GetParamStringValue(TAG_CARETRETMODE, "");
    }

    public void setCARETRETMODE(String strValue) {
        this.SetParamValue(TAG_CARETRETMODE, strValue);
    }

    public boolean isUPDATEOVMODENull() {
        return this.IsParamNull(TAG_UPDATEOVMODE);
    }

    public String getUPDATEOVMODE() {
        return this.GetParamStringValue(TAG_UPDATEOVMODE, "");
    }

    public void setUPDATEOVMODE(String strValue) {
        this.SetParamValue(TAG_UPDATEOVMODE, strValue);
    }

    public boolean isPWDSTORAGENull() {
        return this.IsParamNull(TAG_PWDSTORAGE);
    }

    public int getPWDSTORAGE() {
        return this.GetParamIntValue(TAG_PWDSTORAGE, 0);
    }

    public void setPWDSTORAGE(int nValue) {
        this.SetParamValue(TAG_PWDSTORAGE, nValue);
    }

    public final boolean isSAVEDATAACTIONNull() {
        return this.IsParamNull(TAG_SAVEDATAACTION);
    }

    public final String getSAVEDATAACTION() {
        return this.GetParamStringValue(TAG_SAVEDATAACTION, "");
    }

    public final void setSAVEDATAACTION(String strValue) {
        this.SetParamValue(TAG_SAVEDATAACTION, strValue);
    }

    public final boolean isREMOVEDATAACTIONNull() {
        return this.IsParamNull(TAG_REMOVEDATAACTION);
    }

    public final String getREMOVEDATAACTION() {
        return this.GetParamStringValue(TAG_REMOVEDATAACTION, "");
    }

    public final void setREMOVEDATAACTION(String strValue) {
        this.SetParamValue(TAG_REMOVEDATAACTION, strValue);
    }

    public final boolean isCODELISTPARAMNull() {
        return this.IsParamNull(TAG_CODELISTPARAM);
    }

    public final String getCODELISTPARAM() {
        return this.GetParamStringValue(TAG_CODELISTPARAM, "");
    }

    public final void setCODELISTPARAM(String strValue) {
        this.SetParamValue(TAG_CODELISTPARAM, strValue);
    }

    public final boolean isUIASSISTNull() {
        return this.IsParamNull(TAG_UIASSIST);
    }

    public final boolean getUIASSIST() {
        return this.GetParamIntValue(TAG_UIASSIST, 0) == 1;
    }

    public final void setUIASSIST(boolean bValue) {
        this.SetParamValue(TAG_UIASSIST, bValue ? 1 : 0);
    }

    public final boolean isENCRYPTSTORAGENull() {
        return this.IsParamNull(TAG_ENCRYPTSTORAGE);
    }

    public final int getENCRYPTSTORAGE() {
        return this.GetParamIntValue(TAG_ENCRYPTSTORAGE, 0);
    }

    public final void setENCRYPTSTORAGE(int nValue) {
        this.SetParamValue(TAG_ENCRYPTSTORAGE, nValue);
    }

    public final boolean isINPUTTIPSNull() {
        return this.IsParamNull(TAG_INPUTTIPS);
    }

    public final String getINPUTTIPS() {
        return this.GetParamStringValue(TAG_INPUTTIPS, "");
    }

    public final void setINPUTTIPS(String strValue) {
        this.SetParamValue(TAG_INPUTTIPS, strValue);
    }

    public final boolean isFORMULAPHYNull() {
        return this.IsParamNull(TAG_FORMULAPHY);
    }

    public final boolean getFORMULAPHY() {
        return this.GetParamIntValue(TAG_FORMULAPHY, 0) == 1;
    }

    public final void setFORMULAPHY(boolean bValue) {
        this.SetParamValue(TAG_FORMULAPHY, bValue ? 1 : 0);
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

    public final boolean isLENGTHNull() {
        return this.IsParamNull(TAG_LENGTH);
    }

    public final boolean isPRECISION2Null() {
        return this.IsParamNull(TAG_PRECISION2);
    }

    public final void setPRECISION2(int nValue) {
        this.SetParamValue(TAG_PRECISION2, nValue);
    }

    public final boolean isRDEFNAMENull() {
        return this.IsParamNull(TAG_RDEFNAME);
    }

    public final String getRDEFNAME() {
        return this.GetParamStringValue(TAG_RDEFNAME, "");
    }

    public final void setRDEFNAME(String strValue) {
        this.SetParamValue(TAG_RDEFNAME, strValue);
    }
}

