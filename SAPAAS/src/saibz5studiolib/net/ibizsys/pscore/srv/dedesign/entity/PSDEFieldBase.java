/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.entity.IEntityActionHelper
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.JSONObjectHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.dedesign.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import javax.persistence.Column;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.config.entity.PSDEFDataType;
import net.ibizsys.pscore.srv.config.service.PSDEFDataTypeService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFDTCol;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFInputTip;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFSFItem;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFUIMode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFValueRule;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETable;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFDTColService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFInputTipService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFSFItemService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFUIModeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFValueRuleService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDERService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETableService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysSADEField;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBColumn;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSampleValue;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSequence;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysTranslator;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUnit;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysValueRule;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysSADEFieldService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBColumnService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSampleValueService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSequenceService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysTranslatorService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUnitService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysValueRuleService;
import net.ibizsys.pscore.srv.systest.entity.PSSysTestCase;
import net.ibizsys.pscore.srv.systest.service.PSSysTestCaseService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEFieldBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEFieldBase.class);
    public static final String FIELD_ALLOWEMPTY = "ALLOWEMPTY";
    public static final String FIELD_AUDITINFOFORMAT = "AUDITINFOFORMAT";
    public static final String FIELD_BIZTAG = "BIZTAG";
    public static final String FIELD_CHECKRECURSION = "CHECKRECURSION";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_COMPUTEEXP = "COMPUTEEXP";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMEXPORTSCOPE = "CUSTOMEXPORTSCOPE";
    public static final String FIELD_DBVALUEMODE = "DBVALUEMODE";
    public static final String FIELD_DBVALUEMODE2 = "DBVALUEMODE2";
    public static final String FIELD_DEFAULTVALUE = "DEFAULTVALUE";
    public static final String FIELD_DEFTYPE = "DEFTYPE";
    public static final String FIELD_DERPSDEFID = "DERPSDEFID";
    public static final String FIELD_DERPSDEFNAME = "DERPSDEFNAME";
    public static final String FIELD_DUPCHECKMODE = "DUPCHECKMODE";
    public static final String FIELD_DUPCHECKVALUES = "DUPCHECKVALUES";
    public static final String FIELD_DUPCHECKPSDEFID = "DUPCHKPSDEFID";
    public static final String FIELD_DUPCHECKPSDEFNAME = "DUPCHKPSDEFNAME";
    public static final String FIELD_DEFAULTVALUETYPE = "DVT";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_ENABLEAUDIT = "ENABLEAUDIT";
    public static final String FIELD_ENABLECOLPRIV = "ENABLECOLPRIV";
    public static final String FIELD_ENABLEQS = "ENABLEQS";
    public static final String FIELD_ENABLETEMPDATA = "ENABLETEMPDATA";
    public static final String FIELD_ENABLEUSERINPUT = "ENABLEUSERINPUT";
    public static final String FIELD_ENAWRITEBACK = "ENAWRITEBACK";
    public static final String FIELD_EXPORTSCOPE = "EXPORTSCOPE";
    public static final String FIELD_EXPPSSYSTRANSLATORID = "EXPPSSYSTRANSLATORID";
    public static final String FIELD_EXPPSSYSTRANSLATORNAME = "EXPPSSYSTRANSLATORNAME";
    public static final String FIELD_EXTENDMODE = "EXTENDMODE";
    public static final String FIELD_FIELDHOLDER = "FIELDHOLDER";
    public static final String FIELD_FIELDTAG = "FIELDTAG";
    public static final String FIELD_FIELDTAG2 = "FIELDTAG2";
    public static final String FIELD_FKEY = "FKEY";
    public static final String FIELD_FORMULAFIELDS = "FORMULAFIELDS";
    public static final String FIELD_FORMULAFORMAT = "FORMULAFORMAT";
    public static final String FIELD_IMPORTKEY = "IMPORTKEY";
    public static final String FIELD_IMPORTORDER = "IMPORTORDER";
    public static final String FIELD_IMPORTTAG = "IMPORTTAG";
    public static final String FIELD_IMPPSSYSTRANSLATORID = "IMPPSSYSTRANSLATORID";
    public static final String FIELD_IMPPSSYSTRANSLATORNAME = "IMPPSSYSTRANSLATORNAME";
    public static final String FIELD_INDEXTYPE = "INDEXTYPE";
    public static final String FIELD_JSFORMAT = "JSFORMAT";
    public static final String FIELD_JSONFORMAT = "JSONFORMAT";
    public static final String FIELD_LENGTH = "LENGTH";
    public static final String FIELD_LNPSLANRESID = "LNPSLANRESID";
    public static final String FIELD_LNPSLANRESNAME = "LNPSLANRESNAME";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MAJORFIELD = "MAJORFIELD";
    public static final String FIELD_MAXVALUE = "MAXVALUE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MINSTRLENGTH = "MINSTRLENGTH";
    public static final String FIELD_MINVALUE = "MINVALUE";
    public static final String FIELD_MULTIFORMFIELD = "MULTIFORMFIELD";
    public static final String FIELD_NO2DUPCHKPSDEFID = "NO2DUPCHKPSDEFID";
    public static final String FIELD_NO2DUPCHKPSDEFNAME = "NO2DUPCHKPSDEFNAME";
    public static final String FIELD_NO3DUPCHKPSDEFID = "NO3DUPCHKPSDEFID";
    public static final String FIELD_NO3DUPCHKPSDEFNAME = "NO3DUPCHKPSDEFNAME";
    public static final String FIELD_NULLVALORDER = "NULLVALORDER";
    public static final String FIELD_O2MPSDERID = "O2MPSDERID";
    public static final String FIELD_O2MPSDERNAME = "O2MPSDERNAME";
    public static final String FIELD_O2OPSDERID = "O2OPSDERID";
    public static final String FIELD_O2OPSDERNAME = "O2OPSDERNAME";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PASTERESET = "PASTERESET";
    public static final String FIELD_PHYSICALFIELD = "PHYSICALFIELD";
    public static final String FIELD_PKEY = "PKEY";
    public static final String FIELD_PRECISION2 = "PRECISION2";
    public static final String FIELD_PREDEFINEDTYPEPARAM = "PREDEFINEDTYPEPARAM";
    public static final String FIELD_PREDEFINETYPE = "PREDEFINETYPE";
    public static final String FIELD_PSCODELISTID = "PSCODELISTID";
    public static final String FIELD_PSCODELISTNAME = "PSCODELISTNAME";
    public static final String FIELD_PSDATATYPEID = "PSDATATYPEID";
    public static final String FIELD_PSDATATYPENAME = "PSDATATYPENAME";
    public static final String FIELD_PSDEFDTCOLSCNT = "PSDEFDTCOLSCNT";
    public static final String FIELD_PSDEFIELDID = "PSDEFIELDID";
    public static final String FIELD_PSDEFIELDNAME = "PSDEFIELDNAME";
    public static final String FIELD_PSDEFIELDSCNT = "PSDEFIELDSCNT";
    public static final String FIELD_PSDEFINPUTTIPSCNT = "PSDEFINPUTTIPSCNT";
    public static final String FIELD_PSDEFSFITEMSCNT = "PSDEFSFITEMSCNT";
    public static final String FIELD_PSDEFUIMODESCNT = "PSDEFUIMODESCNT";
    public static final String FIELD_PSDEFVALUERULESCNT = "PSDEFVALUERULESCNT";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDERID = "PSDERID";
    public static final String FIELD_PSDERNAME = "PSDERNAME";
    public static final String FIELD_PSDETABLEID = "PSDETABLEID";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSSUBSYSSADEFIELDID = "PSSUBSYSSADEFIELDID";
    public static final String FIELD_PSSUBSYSSADEFIELDNAME = "PSSUBSYSSADEFIELDNAME";
    public static final String FIELD_PSSUBSYSSADEID = "PSSUBSYSSADEID";
    public static final String FIELD_PSSYSDBCOLUMNID = "PSSYSDBCOLUMNID";
    public static final String FIELD_PSSYSSAMPLEVALUEID = "PSSYSSAMPLEVALUEID";
    public static final String FIELD_PSSYSSAMPLEVALUENAME = "PSSYSSAMPLEVALUENAME";
    public static final String FIELD_PSSYSSEQUENCEID = "PSSYSSEQUENCEID";
    public static final String FIELD_PSSYSSEQUENCENAME = "PSSYSSEQUENCENAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTESTCASESCNT = "PSSYSTESTCASESCNT";
    public static final String FIELD_PSSYSTRANSLATORID = "PSSYSTRANSLATORID";
    public static final String FIELD_PSSYSTRANSLATORNAME = "PSSYSTRANSLATORNAME";
    public static final String FIELD_PSSYSUNITID = "PSSYSUNITID";
    public static final String FIELD_PSSYSUNITNAME = "PSSYSUNITNAME";
    public static final String FIELD_PSSYSVALUERULEID = "PSSYSVALUERULEID";
    public static final String FIELD_PSSYSVALUERULENAME = "PSSYSVALUERULENAME";
    public static final String FIELD_QUERYCOLUMN = "QUERYCOLUMN";
    public static final String FIELD_QUERYCS = "QUERYCS";
    public static final String FIELD_READONLYMODE = "READONLYMODE";
    public static final String FIELD_REFPSSYSDYNAMODELID = "REFPSSYSDYNAMODELID";
    public static final String FIELD_REFPSSYSDYNAMODELNAME = "REFPSSYSDYNAMODELNAME";
    public static final String FIELD_RESTRICTEDPSDEFID = "RESTRICTEDPSDEFID";
    public static final String FIELD_RESTRICTEDPSDEFNAME = "RESTRICTEDPSDEFNAME";
    public static final String FIELD_SEQUENCEMODE = "SEQUENCEMODE";
    public static final String FIELD_SERVICECODENAME = "SERVICECODENAME";
    public static final String FIELD_STATEFIELD = "STATEFIELD";
    public static final String FIELD_STDDATATYPE = "STDDATATYPE";
    public static final String FIELD_STRINGCASE = "STRINGCASE";
    public static final String FIELD_STRLENGTH = "STRLENGTH";
    public static final String FIELD_TABLENAME = "TABLENAME";
    public static final String FIELD_TABLESCOPE = "TABLESCOPE";
    public static final String FIELD_TESTDATA = "TESTDATA";
    public static final String FIELD_TRANSLATORMODE = "TRANSLATORMODE";
    public static final String FIELD_UNICODECHAR = "UNICODECHAR";
    public static final String FIELD_UNIONKEYVALUE = "UNIONKEYVALUE";
    public static final String FIELD_UNIT = "UNIT";
    public static final String FIELD_UNITWIDTH = "UNITWIDTH";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_UPDATEOVMODE = "UPDATEOVMODE";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERPARAMS = "USERPARAMS";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    public static final String FIELD_VALUEFORMAT = "VALUEFORMAT";
    public static final String FIELD_VALUEPSDEFID = "VALUEPSDEFID";
    public static final String FIELD_VALUEPSDEFNAME = "VALUEPSDEFNAME";
    public static final String FIELD_VIEWCOLLEVEL = "VIEWCOLLEVEL";
    private static final int INDEX_ALLOWEMPTY = 0;
    private static final int INDEX_AUDITINFOFORMAT = 1;
    private static final int INDEX_BIZTAG = 2;
    private static final int INDEX_CHECKRECURSION = 3;
    private static final int INDEX_CODENAME = 4;
    private static final int INDEX_COMPUTEEXP = 5;
    private static final int INDEX_CREATEDATE = 6;
    private static final int INDEX_CREATEMAN = 7;
    private static final int INDEX_CUSTOMEXPORTSCOPE = 8;
    private static final int INDEX_DBVALUEMODE = 9;
    private static final int INDEX_DBVALUEMODE2 = 10;
    private static final int INDEX_DEFAULTVALUE = 11;
    private static final int INDEX_DEFTYPE = 12;
    private static final int INDEX_DERPSDEFID = 13;
    private static final int INDEX_DERPSDEFNAME = 14;
    private static final int INDEX_DUPCHECKMODE = 15;
    private static final int INDEX_DUPCHECKVALUES = 16;
    private static final int INDEX_DUPCHECKPSDEFID = 17;
    private static final int INDEX_DUPCHECKPSDEFNAME = 18;
    private static final int INDEX_DEFAULTVALUETYPE = 19;
    private static final int INDEX_DYNAMODELFLAG = 20;
    private static final int INDEX_ENABLEAUDIT = 21;
    private static final int INDEX_ENABLECOLPRIV = 22;
    private static final int INDEX_ENABLEQS = 23;
    private static final int INDEX_ENABLETEMPDATA = 24;
    private static final int INDEX_ENABLEUSERINPUT = 25;
    private static final int INDEX_ENAWRITEBACK = 26;
    private static final int INDEX_EXPORTSCOPE = 27;
    private static final int INDEX_EXPPSSYSTRANSLATORID = 28;
    private static final int INDEX_EXPPSSYSTRANSLATORNAME = 29;
    private static final int INDEX_EXTENDMODE = 30;
    private static final int INDEX_FIELDHOLDER = 31;
    private static final int INDEX_FIELDTAG = 32;
    private static final int INDEX_FIELDTAG2 = 33;
    private static final int INDEX_FKEY = 34;
    private static final int INDEX_FORMULAFIELDS = 35;
    private static final int INDEX_FORMULAFORMAT = 36;
    private static final int INDEX_IMPORTKEY = 37;
    private static final int INDEX_IMPORTORDER = 38;
    private static final int INDEX_IMPORTTAG = 39;
    private static final int INDEX_IMPPSSYSTRANSLATORID = 40;
    private static final int INDEX_IMPPSSYSTRANSLATORNAME = 41;
    private static final int INDEX_INDEXTYPE = 42;
    private static final int INDEX_JSFORMAT = 43;
    private static final int INDEX_JSONFORMAT = 44;
    private static final int INDEX_LENGTH = 45;
    private static final int INDEX_LNPSLANRESID = 46;
    private static final int INDEX_LNPSLANRESNAME = 47;
    private static final int INDEX_LOCKFLAG = 48;
    private static final int INDEX_LOGICNAME = 49;
    private static final int INDEX_MAJORFIELD = 50;
    private static final int INDEX_MAXVALUE = 51;
    private static final int INDEX_MEMO = 52;
    private static final int INDEX_MINSTRLENGTH = 53;
    private static final int INDEX_MINVALUE = 54;
    private static final int INDEX_MULTIFORMFIELD = 55;
    private static final int INDEX_NO2DUPCHKPSDEFID = 56;
    private static final int INDEX_NO2DUPCHKPSDEFNAME = 57;
    private static final int INDEX_NO3DUPCHKPSDEFID = 58;
    private static final int INDEX_NO3DUPCHKPSDEFNAME = 59;
    private static final int INDEX_NULLVALORDER = 60;
    private static final int INDEX_O2MPSDERID = 61;
    private static final int INDEX_O2MPSDERNAME = 62;
    private static final int INDEX_O2OPSDERID = 63;
    private static final int INDEX_O2OPSDERNAME = 64;
    private static final int INDEX_ORDERVALUE = 65;
    private static final int INDEX_PASTERESET = 66;
    private static final int INDEX_PHYSICALFIELD = 67;
    private static final int INDEX_PKEY = 68;
    private static final int INDEX_PRECISION2 = 69;
    private static final int INDEX_PREDEFINEDTYPEPARAM = 70;
    private static final int INDEX_PREDEFINETYPE = 71;
    private static final int INDEX_PSCODELISTID = 72;
    private static final int INDEX_PSCODELISTNAME = 73;
    private static final int INDEX_PSDATATYPEID = 74;
    private static final int INDEX_PSDATATYPENAME = 75;
    private static final int INDEX_PSDEFDTCOLSCNT = 76;
    private static final int INDEX_PSDEFIELDID = 77;
    private static final int INDEX_PSDEFIELDNAME = 78;
    private static final int INDEX_PSDEFIELDSCNT = 79;
    private static final int INDEX_PSDEFINPUTTIPSCNT = 80;
    private static final int INDEX_PSDEFSFITEMSCNT = 81;
    private static final int INDEX_PSDEFUIMODESCNT = 82;
    private static final int INDEX_PSDEFVALUERULESCNT = 83;
    private static final int INDEX_PSDEID = 84;
    private static final int INDEX_PSDENAME = 85;
    private static final int INDEX_PSDERID = 86;
    private static final int INDEX_PSDERNAME = 87;
    private static final int INDEX_PSDETABLEID = 88;
    private static final int INDEX_PSDYNAINSTID = 89;
    private static final int INDEX_PSSUBSYSSADEFIELDID = 90;
    private static final int INDEX_PSSUBSYSSADEFIELDNAME = 91;
    private static final int INDEX_PSSUBSYSSADEID = 92;
    private static final int INDEX_PSSYSDBCOLUMNID = 93;
    private static final int INDEX_PSSYSSAMPLEVALUEID = 94;
    private static final int INDEX_PSSYSSAMPLEVALUENAME = 95;
    private static final int INDEX_PSSYSSEQUENCEID = 96;
    private static final int INDEX_PSSYSSEQUENCENAME = 97;
    private static final int INDEX_PSSYSTEMID = 98;
    private static final int INDEX_PSSYSTESTCASESCNT = 99;
    private static final int INDEX_PSSYSTRANSLATORID = 100;
    private static final int INDEX_PSSYSTRANSLATORNAME = 101;
    private static final int INDEX_PSSYSUNITID = 102;
    private static final int INDEX_PSSYSUNITNAME = 103;
    private static final int INDEX_PSSYSVALUERULEID = 104;
    private static final int INDEX_PSSYSVALUERULENAME = 105;
    private static final int INDEX_QUERYCOLUMN = 106;
    private static final int INDEX_QUERYCS = 107;
    private static final int INDEX_READONLYMODE = 108;
    private static final int INDEX_REFPSSYSDYNAMODELID = 109;
    private static final int INDEX_REFPSSYSDYNAMODELNAME = 110;
    private static final int INDEX_RESTRICTEDPSDEFID = 111;
    private static final int INDEX_RESTRICTEDPSDEFNAME = 112;
    private static final int INDEX_SEQUENCEMODE = 113;
    private static final int INDEX_SERVICECODENAME = 114;
    private static final int INDEX_STATEFIELD = 115;
    private static final int INDEX_STDDATATYPE = 116;
    private static final int INDEX_STRINGCASE = 117;
    private static final int INDEX_STRLENGTH = 118;
    private static final int INDEX_TABLENAME = 119;
    private static final int INDEX_TABLESCOPE = 120;
    private static final int INDEX_TESTDATA = 121;
    private static final int INDEX_TRANSLATORMODE = 122;
    private static final int INDEX_UNICODECHAR = 123;
    private static final int INDEX_UNIONKEYVALUE = 124;
    private static final int INDEX_UNIT = 125;
    private static final int INDEX_UNITWIDTH = 126;
    private static final int INDEX_UPDATEDATE = 127;
    private static final int INDEX_UPDATEMAN = 128;
    private static final int INDEX_UPDATEOVMODE = 129;
    private static final int INDEX_USERCAT = 130;
    private static final int INDEX_USERPARAMS = 131;
    private static final int INDEX_USERTAG = 132;
    private static final int INDEX_USERTAG2 = 133;
    private static final int INDEX_USERTAG3 = 134;
    private static final int INDEX_USERTAG4 = 135;
    private static final int INDEX_VALIDFLAG = 136;
    private static final int INDEX_VALUEFORMAT = 137;
    private static final int INDEX_VALUEPSDEFID = 138;
    private static final int INDEX_VALUEPSDEFNAME = 139;
    private static final int INDEX_VIEWCOLLEVEL = 140;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEFieldBase proxyPSDEFieldBase = null;
    private boolean allowemptyDirtyFlag = false;
    private boolean auditinfoformatDirtyFlag = false;
    private boolean biztagDirtyFlag = false;
    private boolean checkrecursionDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean computeexpDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customexportscopeDirtyFlag = false;
    private boolean dbvaluemodeDirtyFlag = false;
    private boolean dbvaluemode2DirtyFlag = false;
    private boolean defaultvalueDirtyFlag = false;
    private boolean deftypeDirtyFlag = false;
    private boolean derpsdefidDirtyFlag = false;
    private boolean derpsdefnameDirtyFlag = false;
    private boolean dupcheckmodeDirtyFlag = false;
    private boolean dupcheckvaluesDirtyFlag = false;
    private boolean dupcheckpsdefidDirtyFlag = false;
    private boolean dupcheckpsdefnameDirtyFlag = false;
    private boolean defaultvaluetypeDirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean enableauditDirtyFlag = false;
    private boolean enablecolprivDirtyFlag = false;
    private boolean enableqsDirtyFlag = false;
    private boolean enabletempdataDirtyFlag = false;
    private boolean enableuserinputDirtyFlag = false;
    private boolean enawritebackDirtyFlag = false;
    private boolean exportscopeDirtyFlag = false;
    private boolean exppssystranslatoridDirtyFlag = false;
    private boolean exppssystranslatornameDirtyFlag = false;
    private boolean extendmodeDirtyFlag = false;
    private boolean fieldholderDirtyFlag = false;
    private boolean fieldtagDirtyFlag = false;
    private boolean fieldtag2DirtyFlag = false;
    private boolean fkeyDirtyFlag = false;
    private boolean formulafieldsDirtyFlag = false;
    private boolean formulaformatDirtyFlag = false;
    private boolean importkeyDirtyFlag = false;
    private boolean importorderDirtyFlag = false;
    private boolean importtagDirtyFlag = false;
    private boolean imppssystranslatoridDirtyFlag = false;
    private boolean imppssystranslatornameDirtyFlag = false;
    private boolean indextypeDirtyFlag = false;
    private boolean jsformatDirtyFlag = false;
    private boolean jsonformatDirtyFlag = false;
    private boolean lengthDirtyFlag = false;
    private boolean lnpslanresidDirtyFlag = false;
    private boolean lnpslanresnameDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean majorfieldDirtyFlag = false;
    private boolean maxvalueDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean minstrlengthDirtyFlag = false;
    private boolean minvalueDirtyFlag = false;
    private boolean multiformfieldDirtyFlag = false;
    private boolean no2dupchkpsdefidDirtyFlag = false;
    private boolean no2dupchkpsdefnameDirtyFlag = false;
    private boolean no3dupchkpsdefidDirtyFlag = false;
    private boolean no3dupchkpsdefnameDirtyFlag = false;
    private boolean nullvalorderDirtyFlag = false;
    private boolean o2mpsderidDirtyFlag = false;
    private boolean o2mpsdernameDirtyFlag = false;
    private boolean o2opsderidDirtyFlag = false;
    private boolean o2opsdernameDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean pasteresetDirtyFlag = false;
    private boolean physicalfieldDirtyFlag = false;
    private boolean pkeyDirtyFlag = false;
    private boolean precision2DirtyFlag = false;
    private boolean predefinedtypeparamDirtyFlag = false;
    private boolean predefinetypeDirtyFlag = false;
    private boolean pscodelistidDirtyFlag = false;
    private boolean pscodelistnameDirtyFlag = false;
    private boolean psdatatypeidDirtyFlag = false;
    private boolean psdatatypenameDirtyFlag = false;
    private boolean psdefdtcolscntDirtyFlag = false;
    private boolean psdefieldidDirtyFlag = false;
    private boolean psdefieldnameDirtyFlag = false;
    private boolean psdefieldscntDirtyFlag = false;
    private boolean psdefinputtipscntDirtyFlag = false;
    private boolean psdefsfitemscntDirtyFlag = false;
    private boolean psdefuimodescntDirtyFlag = false;
    private boolean psdefvaluerulescntDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psderidDirtyFlag = false;
    private boolean psdernameDirtyFlag = false;
    private boolean psdetableidDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean pssubsyssadefieldidDirtyFlag = false;
    private boolean pssubsyssadefieldnameDirtyFlag = false;
    private boolean pssubsyssadeidDirtyFlag = false;
    private boolean pssysdbcolumnidDirtyFlag = false;
    private boolean pssyssamplevalueidDirtyFlag = false;
    private boolean pssyssamplevaluenameDirtyFlag = false;
    private boolean pssyssequenceidDirtyFlag = false;
    private boolean pssyssequencenameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystestcasescntDirtyFlag = false;
    private boolean pssystranslatoridDirtyFlag = false;
    private boolean pssystranslatornameDirtyFlag = false;
    private boolean pssysunitidDirtyFlag = false;
    private boolean pssysunitnameDirtyFlag = false;
    private boolean pssysvalueruleidDirtyFlag = false;
    private boolean pssysvaluerulenameDirtyFlag = false;
    private boolean querycolumnDirtyFlag = false;
    private boolean querycsDirtyFlag = false;
    private boolean readonlymodeDirtyFlag = false;
    private boolean refpssysdynamodelidDirtyFlag = false;
    private boolean refpssysdynamodelnameDirtyFlag = false;
    private boolean restrictedpsdefidDirtyFlag = false;
    private boolean restrictedpsdefnameDirtyFlag = false;
    private boolean sequencemodeDirtyFlag = false;
    private boolean servicecodenameDirtyFlag = false;
    private boolean statefieldDirtyFlag = false;
    private boolean stddatatypeDirtyFlag = false;
    private boolean stringcaseDirtyFlag = false;
    private boolean strlengthDirtyFlag = false;
    private boolean tablenameDirtyFlag = false;
    private boolean tablescopeDirtyFlag = false;
    private boolean testdataDirtyFlag = false;
    private boolean translatormodeDirtyFlag = false;
    private boolean unicodecharDirtyFlag = false;
    private boolean unionkeyvalueDirtyFlag = false;
    private boolean unitDirtyFlag = false;
    private boolean unitwidthDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean updateovmodeDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean userparamsDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    private boolean valueformatDirtyFlag = false;
    private boolean valuepsdefidDirtyFlag = false;
    private boolean valuepsdefnameDirtyFlag = false;
    private boolean viewcollevelDirtyFlag = false;
    @Column(name="allowempty")
    private Integer allowempty;
    @Column(name="auditinfoformat")
    private String auditinfoformat;
    @Column(name="biztag")
    private String biztag;
    @Column(name="checkrecursion")
    private Integer checkrecursion;
    @Column(name="codename")
    private String codename;
    @Column(name="computeexp")
    private String computeexp;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="customexportscope")
    private Integer customexportscope;
    @Column(name="dbvaluemode")
    private String dbvaluemode;
    @Column(name="dbvaluemode2")
    private String dbvaluemode2;
    @Column(name="defaultvalue")
    private String defaultvalue;
    @Column(name="deftype")
    private Integer deftype;
    @Column(name="derpsdefid")
    private String derpsdefid;
    @Column(name="derpsdefname")
    private String derpsdefname;
    @Column(name="dupcheckmode")
    private String dupcheckmode;
    @Column(name="dupcheckvalues")
    private String dupcheckvalues;
    @Column(name="dupcheckpsdefid")
    private String dupcheckpsdefid;
    @Column(name="dupcheckpsdefname")
    private String dupcheckpsdefname;
    @Column(name="defaultvaluetype")
    private String defaultvaluetype;
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="enableaudit")
    private Integer enableaudit;
    @Column(name="enablecolpriv")
    private Integer enablecolpriv;
    @Column(name="enableqs")
    private Integer enableqs;
    @Column(name="enabletempdata")
    private Integer enabletempdata;
    @Column(name="enableuserinput")
    private Integer enableuserinput;
    @Column(name="enawriteback")
    private Integer enawriteback;
    @Column(name="exportscope")
    private Integer exportscope;
    @Column(name="exppssystranslatorid")
    private String exppssystranslatorid;
    @Column(name="exppssystranslatorname")
    private String exppssystranslatorname;
    @Column(name="extendmode")
    private Integer extendmode;
    @Column(name="fieldholder")
    private Integer fieldholder;
    @Column(name="fieldtag")
    private String fieldtag;
    @Column(name="fieldtag2")
    private String fieldtag2;
    @Column(name="fkey")
    private Integer fkey;
    @Column(name="formulafields")
    private String formulafields;
    @Column(name="formulaformat")
    private String formulaformat;
    @Column(name="importkey")
    private Integer importkey;
    @Column(name="importorder")
    private Integer importorder;
    @Column(name="importtag")
    private String importtag;
    @Column(name="imppssystranslatorid")
    private String imppssystranslatorid;
    @Column(name="imppssystranslatorname")
    private String imppssystranslatorname;
    @Column(name="indextype")
    private Integer indextype;
    @Column(name="jsformat")
    private String jsformat;
    @Column(name="jsonformat")
    private String jsonformat;
    @Column(name="length")
    private Integer length;
    @Column(name="lnpslanresid")
    private String lnpslanresid;
    @Column(name="lnpslanresname")
    private String lnpslanresname;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="logicname")
    private String logicname;
    @Column(name="majorfield")
    private Integer majorfield;
    @Column(name="maxvalue")
    private String maxvalue;
    @Column(name="memo")
    private String memo;
    @Column(name="minstrlength")
    private Integer minstrlength;
    @Column(name="minvalue")
    private String minvalue;
    @Column(name="multiformfield")
    private Integer multiformfield;
    @Column(name="no2dupchkpsdefid")
    private String no2dupchkpsdefid;
    @Column(name="no2dupchkpsdefname")
    private String no2dupchkpsdefname;
    @Column(name="no3dupchkpsdefid")
    private String no3dupchkpsdefid;
    @Column(name="no3dupchkpsdefname")
    private String no3dupchkpsdefname;
    @Column(name="nullvalorder")
    private String nullvalorder;
    @Column(name="o2mpsderid")
    private String o2mpsderid;
    @Column(name="o2mpsdername")
    private String o2mpsdername;
    @Column(name="o2opsderid")
    private String o2opsderid;
    @Column(name="o2opsdername")
    private String o2opsdername;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="pastereset")
    private Integer pastereset;
    @Column(name="physicalfield")
    private Integer physicalfield;
    @Column(name="pkey")
    private Integer pkey;
    @Column(name="precision2")
    private Integer precision2;
    @Column(name="predefinedtypeparam")
    private String predefinedtypeparam;
    @Column(name="predefinetype")
    private String predefinetype;
    @Column(name="pscodelistid")
    private String pscodelistid;
    @Column(name="pscodelistname")
    private String pscodelistname;
    @Column(name="psdatatypeid")
    private String psdatatypeid;
    @Column(name="psdatatypename")
    private String psdatatypename;
    @Column(name="psdefdtcolscnt")
    private Integer psdefdtcolscnt;
    @Column(name="psdefieldid")
    private String psdefieldid;
    @Column(name="psdefieldname")
    private String psdefieldname;
    @Column(name="psdefieldscnt")
    private Integer psdefieldscnt;
    @Column(name="psdefinputtipscnt")
    private Integer psdefinputtipscnt;
    @Column(name="psdefsfitemscnt")
    private Integer psdefsfitemscnt;
    @Column(name="psdefuimodescnt")
    private Integer psdefuimodescnt;
    @Column(name="psdefvaluerulescnt")
    private Integer psdefvaluerulescnt;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psderid")
    private String psderid;
    @Column(name="psdername")
    private String psdername;
    @Column(name="psdetableid")
    private String psdetableid;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="pssubsyssadefieldid")
    private String pssubsyssadefieldid;
    @Column(name="pssubsyssadefieldname")
    private String pssubsyssadefieldname;
    @Column(name="pssubsyssadeid")
    private String pssubsyssadeid;
    @Column(name="pssysdbcolumnid")
    private String pssysdbcolumnid;
    @Column(name="pssyssamplevalueid")
    private String pssyssamplevalueid;
    @Column(name="pssyssamplevaluename")
    private String pssyssamplevaluename;
    @Column(name="pssyssequenceid")
    private String pssyssequenceid;
    @Column(name="pssyssequencename")
    private String pssyssequencename;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystestcasescnt")
    private Integer pssystestcasescnt;
    @Column(name="pssystranslatorid")
    private String pssystranslatorid;
    @Column(name="pssystranslatorname")
    private String pssystranslatorname;
    @Column(name="pssysunitid")
    private String pssysunitid;
    @Column(name="pssysunitname")
    private String pssysunitname;
    @Column(name="pssysvalueruleid")
    private String pssysvalueruleid;
    @Column(name="pssysvaluerulename")
    private String pssysvaluerulename;
    @Column(name="querycolumn")
    private Integer querycolumn;
    @Column(name="querycs")
    private String querycs;
    @Column(name="readonlymode")
    private Integer readonlymode;
    @Column(name="refpssysdynamodelid")
    private String refpssysdynamodelid;
    @Column(name="refpssysdynamodelname")
    private String refpssysdynamodelname;
    @Column(name="restrictedpsdefid")
    private String restrictedpsdefid;
    @Column(name="restrictedpsdefname")
    private String restrictedpsdefname;
    @Column(name="sequencemode")
    private String sequencemode;
    @Column(name="servicecodename")
    private String servicecodename;
    @Column(name="statefield")
    private String statefield;
    @Column(name="stddatatype")
    private Integer stddatatype;
    @Column(name="stringcase")
    private String stringcase;
    @Column(name="strlength")
    private Integer strlength;
    @Column(name="tablename")
    private String tablename;
    @Column(name="tablescope")
    private String tablescope;
    @Column(name="testdata")
    private String testdata;
    @Column(name="translatormode")
    private String translatormode;
    @Column(name="unicodechar")
    private Integer unicodechar;
    @Column(name="unionkeyvalue")
    private String unionkeyvalue;
    @Column(name="unit")
    private String unit;
    @Column(name="unitwidth")
    private Integer unitwidth;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="updateovmode")
    private String updateovmode;
    @Column(name="usercat")
    private String usercat;
    @Column(name="userparams")
    private String userparams;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="usertag3")
    private String usertag3;
    @Column(name="usertag4")
    private String usertag4;
    @Column(name="validflag")
    private Integer validflag;
    @Column(name="valueformat")
    private String valueformat;
    @Column(name="valuepsdefid")
    private String valuepsdefid;
    @Column(name="valuepsdefname")
    private String valuepsdefname;
    @Column(name="viewcollevel")
    private Integer viewcollevel;
    private Integer objPSCodeListLock = new Integer(1);
    private PSCodeList pscodelist = null;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objPSDataTypeLock = new Integer(1);
    private PSDEFDataType psdatatype = null;
    private Integer objDERPSDEFLock = new Integer(1);
    private PSDEField derpsdef = null;
    private Integer objDupChkPSDEFLock = new Integer(1);
    private PSDEField dupchkpsdef = null;
    private Integer objNo2DupChkPSDEFLock = new Integer(1);
    private PSDEField no2dupchkpsdef = null;
    private Integer objNo3DupChkPSDEFLock = new Integer(1);
    private PSDEField no3dupchkpsdef = null;
    private Integer objRestrictedPSDEFLock = new Integer(1);
    private PSDEField restrictedpsdef = null;
    private Integer objValuePSDEFLock = new Integer(1);
    private PSDEField valuepsdef = null;
    private Integer objO2MPSDERLock = new Integer(1);
    private PSDER o2mpsder = null;
    private Integer objO2OPSDERLock = new Integer(1);
    private PSDER o2opsder = null;
    private Integer objPSDERLock = new Integer(1);
    private PSDER psder = null;
    private Integer objPSDETableLock = new Integer(1);
    private PSDETable psdetable = null;
    private Integer objLNPSLanResLock = new Integer(1);
    private PSLanguageRes lnpslanres = null;
    private Integer objPSSubSysSADEFieldLock = new Integer(1);
    private PSSubSysSADEField pssubsyssadefield = null;
    private Integer objPSSysDBColumnLock = new Integer(1);
    private PSSysDBColumn pssysdbcolumn = null;
    private Integer objRefPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel refpssysdynamodel = null;
    private Integer objPSSysSampleValueLock = new Integer(1);
    private PSSysSampleValue pssyssamplevalue = null;
    private Integer objPSSysSequenceLock = new Integer(1);
    private PSSysSequence pssyssequence = null;
    private Integer objExpPSSysTranslatorLock = new Integer(1);
    private PSSysTranslator exppssystranslator = null;
    private Integer objImpPSSysTranslatorLock = new Integer(1);
    private PSSysTranslator imppssystranslator = null;
    private Integer objPSSysTranslatorLock = new Integer(1);
    private PSSysTranslator pssystranslator = null;
    private Integer objPSSysUnitLock = new Integer(1);
    private PSSysUnit pssysunit = null;
    private Integer objPSSysValueRuleLock = new Integer(1);
    private PSSysValueRule pssysvaluerule = null;
    private Integer objPSDEFDTColsLock = new Integer(1);
    private ArrayList<PSDEFDTCol> psdefdtcols = null;
    private Integer objPSDEFUIModesLock = new Integer(1);
    private ArrayList<PSDEFUIMode> psdefuimodes = null;
    private Integer objPSDEFieldsLock = new Integer(1);
    private ArrayList<PSDEField> psdefields = null;
    private Integer objPSDEFInputTipsLock = new Integer(1);
    private ArrayList<PSDEFInputTip> psdefinputtips = null;
    private Integer objPSDEFSFItemsLock = new Integer(1);
    private ArrayList<PSDEFSFItem> psdefsfitems = null;
    private Integer objPSDEFValueRulesLock = new Integer(1);
    private ArrayList<PSDEFValueRule> psdefvaluerules = null;
    private Integer objPSSysTestCasesLock = new Integer(1);
    private ArrayList<PSSysTestCase> pssystestcases = null;

    public void setAllowEmpty(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAllowEmpty(n);
            return;
        }
        this.allowempty = n;
        this.allowemptyDirtyFlag = true;
    }

    public Integer getAllowEmpty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAllowEmpty();
        }
        return this.allowempty;
    }

    public boolean isAllowEmptyDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAllowEmptyDirty();
        }
        return this.allowemptyDirtyFlag;
    }

    public void resetAllowEmpty() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAllowEmpty();
            return;
        }
        this.allowemptyDirtyFlag = false;
        this.allowempty = null;
    }

    public void setAuditInfoFormat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAuditInfoFormat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.auditinfoformat = string;
        this.auditinfoformatDirtyFlag = true;
    }

    public String getAuditInfoFormat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAuditInfoFormat();
        }
        return this.auditinfoformat;
    }

    public boolean isAuditInfoFormatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAuditInfoFormatDirty();
        }
        return this.auditinfoformatDirtyFlag;
    }

    public void resetAuditInfoFormat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAuditInfoFormat();
            return;
        }
        this.auditinfoformatDirtyFlag = false;
        this.auditinfoformat = null;
    }

    public void setBizTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBizTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.biztag = string;
        this.biztagDirtyFlag = true;
    }

    public String getBizTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBizTag();
        }
        return this.biztag;
    }

    public boolean isBizTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBizTagDirty();
        }
        return this.biztagDirtyFlag;
    }

    public void resetBizTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBizTag();
            return;
        }
        this.biztagDirtyFlag = false;
        this.biztag = null;
    }

    public void setCheckRecursion(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCheckRecursion(n);
            return;
        }
        this.checkrecursion = n;
        this.checkrecursionDirtyFlag = true;
    }

    public Integer getCheckRecursion() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCheckRecursion();
        }
        return this.checkrecursion;
    }

    public boolean isCheckRecursionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCheckRecursionDirty();
        }
        return this.checkrecursionDirtyFlag;
    }

    public void resetCheckRecursion() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCheckRecursion();
            return;
        }
        this.checkrecursionDirtyFlag = false;
        this.checkrecursion = null;
    }

    public void setCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.codename = string;
        this.codenameDirtyFlag = true;
    }

    public String getCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeName();
        }
        return this.codename;
    }

    public boolean isCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeNameDirty();
        }
        return this.codenameDirtyFlag;
    }

    public void resetCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeName();
            return;
        }
        this.codenameDirtyFlag = false;
        this.codename = null;
    }

    public void setComputeExp(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setComputeExp(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.computeexp = string;
        this.computeexpDirtyFlag = true;
    }

    public String getComputeExp() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getComputeExp();
        }
        return this.computeexp;
    }

    public boolean isComputeExpDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isComputeExpDirty();
        }
        return this.computeexpDirtyFlag;
    }

    public void resetComputeExp() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetComputeExp();
            return;
        }
        this.computeexpDirtyFlag = false;
        this.computeexp = null;
    }

    public void setCreateDate(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateDate(timestamp);
            return;
        }
        this.createdate = timestamp;
        this.createdateDirtyFlag = true;
    }

    public Timestamp getCreateDate() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreateDate();
        }
        return this.createdate;
    }

    public boolean isCreateDateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCreateDateDirty();
        }
        return this.createdateDirtyFlag;
    }

    public void resetCreateDate() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCreateDate();
            return;
        }
        this.createdateDirtyFlag = false;
        this.createdate = null;
    }

    public void setCreateMan(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateMan(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.createman = string;
        this.createmanDirtyFlag = true;
    }

    public String getCreateMan() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreateMan();
        }
        return this.createman;
    }

    public boolean isCreateManDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCreateManDirty();
        }
        return this.createmanDirtyFlag;
    }

    public void resetCreateMan() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCreateMan();
            return;
        }
        this.createmanDirtyFlag = false;
        this.createman = null;
    }

    public void setCustomExportScope(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomExportScope(n);
            return;
        }
        this.customexportscope = n;
        this.customexportscopeDirtyFlag = true;
    }

    public Integer getCustomExportScope() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomExportScope();
        }
        return this.customexportscope;
    }

    public boolean isCustomExportScopeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomExportScopeDirty();
        }
        return this.customexportscopeDirtyFlag;
    }

    public void resetCustomExportScope() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomExportScope();
            return;
        }
        this.customexportscopeDirtyFlag = false;
        this.customexportscope = null;
    }

    public void setDBValueMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDBValueMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dbvaluemode = string;
        this.dbvaluemodeDirtyFlag = true;
    }

    public String getDBValueMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDBValueMode();
        }
        return this.dbvaluemode;
    }

    public boolean isDBValueModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDBValueModeDirty();
        }
        return this.dbvaluemodeDirtyFlag;
    }

    public void resetDBValueMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDBValueMode();
            return;
        }
        this.dbvaluemodeDirtyFlag = false;
        this.dbvaluemode = null;
    }

    public void setDBValueMode2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDBValueMode2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dbvaluemode2 = string;
        this.dbvaluemode2DirtyFlag = true;
    }

    public String getDBValueMode2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDBValueMode2();
        }
        return this.dbvaluemode2;
    }

    public boolean isDBValueMode2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDBValueMode2Dirty();
        }
        return this.dbvaluemode2DirtyFlag;
    }

    public void resetDBValueMode2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDBValueMode2();
            return;
        }
        this.dbvaluemode2DirtyFlag = false;
        this.dbvaluemode2 = null;
    }

    public void setDefaultValue(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefaultValue(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.defaultvalue = string;
        this.defaultvalueDirtyFlag = true;
    }

    public String getDefaultValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefaultValue();
        }
        return this.defaultvalue;
    }

    public boolean isDefaultValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefaultValueDirty();
        }
        return this.defaultvalueDirtyFlag;
    }

    public void resetDefaultValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefaultValue();
            return;
        }
        this.defaultvalueDirtyFlag = false;
        this.defaultvalue = null;
    }

    public void setDEFType(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEFType(n);
            return;
        }
        this.deftype = n;
        this.deftypeDirtyFlag = true;
    }

    public Integer getDEFType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEFType();
        }
        return this.deftype;
    }

    public boolean isDEFTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEFTypeDirty();
        }
        return this.deftypeDirtyFlag;
    }

    public void resetDEFType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEFType();
            return;
        }
        this.deftypeDirtyFlag = false;
        this.deftype = null;
    }

    public void setDERPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDERPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.derpsdefid = string;
        this.derpsdefidDirtyFlag = true;
    }

    public String getDERPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDERPSDEFId();
        }
        return this.derpsdefid;
    }

    public boolean isDERPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDERPSDEFIdDirty();
        }
        return this.derpsdefidDirtyFlag;
    }

    public void resetDERPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDERPSDEFId();
            return;
        }
        this.derpsdefidDirtyFlag = false;
        this.derpsdefid = null;
    }

    public void setDERPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDERPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.derpsdefname = string;
        this.derpsdefnameDirtyFlag = true;
    }

    public String getDERPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDERPSDEFName();
        }
        return this.derpsdefname;
    }

    public boolean isDERPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDERPSDEFNameDirty();
        }
        return this.derpsdefnameDirtyFlag;
    }

    public void resetDERPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDERPSDEFName();
            return;
        }
        this.derpsdefnameDirtyFlag = false;
        this.derpsdefname = null;
    }

    public void setDupCheckMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDupCheckMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dupcheckmode = string;
        this.dupcheckmodeDirtyFlag = true;
    }

    public String getDupCheckMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDupCheckMode();
        }
        return this.dupcheckmode;
    }

    public boolean isDupCheckModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDupCheckModeDirty();
        }
        return this.dupcheckmodeDirtyFlag;
    }

    public void resetDupCheckMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDupCheckMode();
            return;
        }
        this.dupcheckmodeDirtyFlag = false;
        this.dupcheckmode = null;
    }

    public void setDupCheckValues(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDupCheckValues(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dupcheckvalues = string;
        this.dupcheckvaluesDirtyFlag = true;
    }

    public String getDupCheckValues() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDupCheckValues();
        }
        return this.dupcheckvalues;
    }

    public boolean isDupCheckValuesDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDupCheckValuesDirty();
        }
        return this.dupcheckvaluesDirtyFlag;
    }

    public void resetDupCheckValues() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDupCheckValues();
            return;
        }
        this.dupcheckvaluesDirtyFlag = false;
        this.dupcheckvalues = null;
    }

    public void setDupCheckPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDupCheckPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dupcheckpsdefid = string;
        this.dupcheckpsdefidDirtyFlag = true;
    }

    public String getDupCheckPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDupCheckPSDEFId();
        }
        return this.dupcheckpsdefid;
    }

    public boolean isDupCheckPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDupCheckPSDEFIdDirty();
        }
        return this.dupcheckpsdefidDirtyFlag;
    }

    public void resetDupCheckPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDupCheckPSDEFId();
            return;
        }
        this.dupcheckpsdefidDirtyFlag = false;
        this.dupcheckpsdefid = null;
    }

    public void setDupCheckPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDupCheckPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dupcheckpsdefname = string;
        this.dupcheckpsdefnameDirtyFlag = true;
    }

    public String getDupCheckPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDupCheckPSDEFName();
        }
        return this.dupcheckpsdefname;
    }

    public boolean isDupCheckPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDupCheckPSDEFNameDirty();
        }
        return this.dupcheckpsdefnameDirtyFlag;
    }

    public void resetDupCheckPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDupCheckPSDEFName();
            return;
        }
        this.dupcheckpsdefnameDirtyFlag = false;
        this.dupcheckpsdefname = null;
    }

    public void setDefaultValueType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefaultValueType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.defaultvaluetype = string;
        this.defaultvaluetypeDirtyFlag = true;
    }

    public String getDefaultValueType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefaultValueType();
        }
        return this.defaultvaluetype;
    }

    public boolean isDefaultValueTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefaultValueTypeDirty();
        }
        return this.defaultvaluetypeDirtyFlag;
    }

    public void resetDefaultValueType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefaultValueType();
            return;
        }
        this.defaultvaluetypeDirtyFlag = false;
        this.defaultvaluetype = null;
    }

    public void setDynaModelFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynaModelFlag(n);
            return;
        }
        this.dynamodelflag = n;
        this.dynamodelflagDirtyFlag = true;
    }

    public Integer getDynaModelFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynaModelFlag();
        }
        return this.dynamodelflag;
    }

    public boolean isDynaModelFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynaModelFlagDirty();
        }
        return this.dynamodelflagDirtyFlag;
    }

    public void resetDynaModelFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynaModelFlag();
            return;
        }
        this.dynamodelflagDirtyFlag = false;
        this.dynamodelflag = null;
    }

    public void setEnableAudit(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableAudit(n);
            return;
        }
        this.enableaudit = n;
        this.enableauditDirtyFlag = true;
    }

    public Integer getEnableAudit() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableAudit();
        }
        return this.enableaudit;
    }

    public boolean isEnableAuditDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableAuditDirty();
        }
        return this.enableauditDirtyFlag;
    }

    public void resetEnableAudit() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableAudit();
            return;
        }
        this.enableauditDirtyFlag = false;
        this.enableaudit = null;
    }

    public void setEnableColPriv(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableColPriv(n);
            return;
        }
        this.enablecolpriv = n;
        this.enablecolprivDirtyFlag = true;
    }

    public Integer getEnableColPriv() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableColPriv();
        }
        return this.enablecolpriv;
    }

    public boolean isEnableColPrivDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableColPrivDirty();
        }
        return this.enablecolprivDirtyFlag;
    }

    public void resetEnableColPriv() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableColPriv();
            return;
        }
        this.enablecolprivDirtyFlag = false;
        this.enablecolpriv = null;
    }

    public void setEnableQS(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableQS(n);
            return;
        }
        this.enableqs = n;
        this.enableqsDirtyFlag = true;
    }

    public Integer getEnableQS() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableQS();
        }
        return this.enableqs;
    }

    public boolean isEnableQSDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableQSDirty();
        }
        return this.enableqsDirtyFlag;
    }

    public void resetEnableQS() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableQS();
            return;
        }
        this.enableqsDirtyFlag = false;
        this.enableqs = null;
    }

    public void setEnableTempData(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableTempData(n);
            return;
        }
        this.enabletempdata = n;
        this.enabletempdataDirtyFlag = true;
    }

    public Integer getEnableTempData() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableTempData();
        }
        return this.enabletempdata;
    }

    public boolean isEnableTempDataDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableTempDataDirty();
        }
        return this.enabletempdataDirtyFlag;
    }

    public void resetEnableTempData() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableTempData();
            return;
        }
        this.enabletempdataDirtyFlag = false;
        this.enabletempdata = null;
    }

    public void setEnableUserInput(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableUserInput(n);
            return;
        }
        this.enableuserinput = n;
        this.enableuserinputDirtyFlag = true;
    }

    public Integer getEnableUserInput() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableUserInput();
        }
        return this.enableuserinput;
    }

    public boolean isEnableUserInputDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableUserInputDirty();
        }
        return this.enableuserinputDirtyFlag;
    }

    public void resetEnableUserInput() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableUserInput();
            return;
        }
        this.enableuserinputDirtyFlag = false;
        this.enableuserinput = null;
    }

    public void setEnaWriteBack(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnaWriteBack(n);
            return;
        }
        this.enawriteback = n;
        this.enawritebackDirtyFlag = true;
    }

    public Integer getEnaWriteBack() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnaWriteBack();
        }
        return this.enawriteback;
    }

    public boolean isEnaWriteBackDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnaWriteBackDirty();
        }
        return this.enawritebackDirtyFlag;
    }

    public void resetEnaWriteBack() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnaWriteBack();
            return;
        }
        this.enawritebackDirtyFlag = false;
        this.enawriteback = null;
    }

    public void setExportScope(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExportScope(n);
            return;
        }
        this.exportscope = n;
        this.exportscopeDirtyFlag = true;
    }

    public Integer getExportScope() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExportScope();
        }
        return this.exportscope;
    }

    public boolean isExportScopeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExportScopeDirty();
        }
        return this.exportscopeDirtyFlag;
    }

    public void resetExportScope() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExportScope();
            return;
        }
        this.exportscopeDirtyFlag = false;
        this.exportscope = null;
    }

    public void setExpPSSysTranslatorId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExpPSSysTranslatorId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.exppssystranslatorid = string;
        this.exppssystranslatoridDirtyFlag = true;
    }

    public String getExpPSSysTranslatorId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExpPSSysTranslatorId();
        }
        return this.exppssystranslatorid;
    }

    public boolean isExpPSSysTranslatorIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExpPSSysTranslatorIdDirty();
        }
        return this.exppssystranslatoridDirtyFlag;
    }

    public void resetExpPSSysTranslatorId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExpPSSysTranslatorId();
            return;
        }
        this.exppssystranslatoridDirtyFlag = false;
        this.exppssystranslatorid = null;
    }

    public void setExpPSSysTranslatorName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExpPSSysTranslatorName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.exppssystranslatorname = string;
        this.exppssystranslatornameDirtyFlag = true;
    }

    public String getExpPSSysTranslatorName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExpPSSysTranslatorName();
        }
        return this.exppssystranslatorname;
    }

    public boolean isExpPSSysTranslatorNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExpPSSysTranslatorNameDirty();
        }
        return this.exppssystranslatornameDirtyFlag;
    }

    public void resetExpPSSysTranslatorName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExpPSSysTranslatorName();
            return;
        }
        this.exppssystranslatornameDirtyFlag = false;
        this.exppssystranslatorname = null;
    }

    public void setExtendMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExtendMode(n);
            return;
        }
        this.extendmode = n;
        this.extendmodeDirtyFlag = true;
    }

    public Integer getExtendMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExtendMode();
        }
        return this.extendmode;
    }

    public boolean isExtendModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExtendModeDirty();
        }
        return this.extendmodeDirtyFlag;
    }

    public void resetExtendMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExtendMode();
            return;
        }
        this.extendmodeDirtyFlag = false;
        this.extendmode = null;
    }

    public void setFieldHolder(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFieldHolder(n);
            return;
        }
        this.fieldholder = n;
        this.fieldholderDirtyFlag = true;
    }

    public Integer getFieldHolder() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFieldHolder();
        }
        return this.fieldholder;
    }

    public boolean isFieldHolderDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFieldHolderDirty();
        }
        return this.fieldholderDirtyFlag;
    }

    public void resetFieldHolder() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFieldHolder();
            return;
        }
        this.fieldholderDirtyFlag = false;
        this.fieldholder = null;
    }

    public void setFieldTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFieldTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.fieldtag = string;
        this.fieldtagDirtyFlag = true;
    }

    public String getFieldTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFieldTag();
        }
        return this.fieldtag;
    }

    public boolean isFieldTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFieldTagDirty();
        }
        return this.fieldtagDirtyFlag;
    }

    public void resetFieldTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFieldTag();
            return;
        }
        this.fieldtagDirtyFlag = false;
        this.fieldtag = null;
    }

    public void setFieldTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFieldTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.fieldtag2 = string;
        this.fieldtag2DirtyFlag = true;
    }

    public String getFieldTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFieldTag2();
        }
        return this.fieldtag2;
    }

    public boolean isFieldTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFieldTag2Dirty();
        }
        return this.fieldtag2DirtyFlag;
    }

    public void resetFieldTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFieldTag2();
            return;
        }
        this.fieldtag2DirtyFlag = false;
        this.fieldtag2 = null;
    }

    public void setFKey(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFKey(n);
            return;
        }
        this.fkey = n;
        this.fkeyDirtyFlag = true;
    }

    public Integer getFKey() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFKey();
        }
        return this.fkey;
    }

    public boolean isFKeyDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFKeyDirty();
        }
        return this.fkeyDirtyFlag;
    }

    public void resetFKey() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFKey();
            return;
        }
        this.fkeyDirtyFlag = false;
        this.fkey = null;
    }

    public void setFormulaFields(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFormulaFields(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.formulafields = string;
        this.formulafieldsDirtyFlag = true;
    }

    public String getFormulaFields() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFormulaFields();
        }
        return this.formulafields;
    }

    public boolean isFormulaFieldsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFormulaFieldsDirty();
        }
        return this.formulafieldsDirtyFlag;
    }

    public void resetFormulaFields() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFormulaFields();
            return;
        }
        this.formulafieldsDirtyFlag = false;
        this.formulafields = null;
    }

    public void setFormulaFormat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFormulaFormat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.formulaformat = string;
        this.formulaformatDirtyFlag = true;
    }

    public String getFormulaFormat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFormulaFormat();
        }
        return this.formulaformat;
    }

    public boolean isFormulaFormatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFormulaFormatDirty();
        }
        return this.formulaformatDirtyFlag;
    }

    public void resetFormulaFormat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFormulaFormat();
            return;
        }
        this.formulaformatDirtyFlag = false;
        this.formulaformat = null;
    }

    public void setImportKey(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setImportKey(n);
            return;
        }
        this.importkey = n;
        this.importkeyDirtyFlag = true;
    }

    public Integer getImportKey() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getImportKey();
        }
        return this.importkey;
    }

    public boolean isImportKeyDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isImportKeyDirty();
        }
        return this.importkeyDirtyFlag;
    }

    public void resetImportKey() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetImportKey();
            return;
        }
        this.importkeyDirtyFlag = false;
        this.importkey = null;
    }

    public void setImportOrder(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setImportOrder(n);
            return;
        }
        this.importorder = n;
        this.importorderDirtyFlag = true;
    }

    public Integer getImportOrder() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getImportOrder();
        }
        return this.importorder;
    }

    public boolean isImportOrderDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isImportOrderDirty();
        }
        return this.importorderDirtyFlag;
    }

    public void resetImportOrder() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetImportOrder();
            return;
        }
        this.importorderDirtyFlag = false;
        this.importorder = null;
    }

    public void setImportTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setImportTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.importtag = string;
        this.importtagDirtyFlag = true;
    }

    public String getImportTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getImportTag();
        }
        return this.importtag;
    }

    public boolean isImportTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isImportTagDirty();
        }
        return this.importtagDirtyFlag;
    }

    public void resetImportTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetImportTag();
            return;
        }
        this.importtagDirtyFlag = false;
        this.importtag = null;
    }

    public void setImpPSSysTranslatorId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setImpPSSysTranslatorId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.imppssystranslatorid = string;
        this.imppssystranslatoridDirtyFlag = true;
    }

    public String getImpPSSysTranslatorId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getImpPSSysTranslatorId();
        }
        return this.imppssystranslatorid;
    }

    public boolean isImpPSSysTranslatorIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isImpPSSysTranslatorIdDirty();
        }
        return this.imppssystranslatoridDirtyFlag;
    }

    public void resetImpPSSysTranslatorId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetImpPSSysTranslatorId();
            return;
        }
        this.imppssystranslatoridDirtyFlag = false;
        this.imppssystranslatorid = null;
    }

    public void setImpPSSysTranslatorName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setImpPSSysTranslatorName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.imppssystranslatorname = string;
        this.imppssystranslatornameDirtyFlag = true;
    }

    public String getImpPSSysTranslatorName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getImpPSSysTranslatorName();
        }
        return this.imppssystranslatorname;
    }

    public boolean isImpPSSysTranslatorNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isImpPSSysTranslatorNameDirty();
        }
        return this.imppssystranslatornameDirtyFlag;
    }

    public void resetImpPSSysTranslatorName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetImpPSSysTranslatorName();
            return;
        }
        this.imppssystranslatornameDirtyFlag = false;
        this.imppssystranslatorname = null;
    }

    public void setIndexType(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIndexType(n);
            return;
        }
        this.indextype = n;
        this.indextypeDirtyFlag = true;
    }

    public Integer getIndexType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIndexType();
        }
        return this.indextype;
    }

    public boolean isIndexTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIndexTypeDirty();
        }
        return this.indextypeDirtyFlag;
    }

    public void resetIndexType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIndexType();
            return;
        }
        this.indextypeDirtyFlag = false;
        this.indextype = null;
    }

    public void setJSFormat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setJSFormat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.jsformat = string;
        this.jsformatDirtyFlag = true;
    }

    public String getJSFormat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getJSFormat();
        }
        return this.jsformat;
    }

    public boolean isJSFormatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isJSFormatDirty();
        }
        return this.jsformatDirtyFlag;
    }

    public void resetJSFormat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetJSFormat();
            return;
        }
        this.jsformatDirtyFlag = false;
        this.jsformat = null;
    }

    public void setJsonFormat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setJsonFormat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.jsonformat = string;
        this.jsonformatDirtyFlag = true;
    }

    public String getJsonFormat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getJsonFormat();
        }
        return this.jsonformat;
    }

    public boolean isJsonFormatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isJsonFormatDirty();
        }
        return this.jsonformatDirtyFlag;
    }

    public void resetJsonFormat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetJsonFormat();
            return;
        }
        this.jsonformatDirtyFlag = false;
        this.jsonformat = null;
    }

    public void setLength(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLength(n);
            return;
        }
        this.length = n;
        this.lengthDirtyFlag = true;
    }

    public Integer getLength() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLength();
        }
        return this.length;
    }

    public boolean isLengthDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLengthDirty();
        }
        return this.lengthDirtyFlag;
    }

    public void resetLength() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLength();
            return;
        }
        this.lengthDirtyFlag = false;
        this.length = null;
    }

    public void setLNPSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLNPSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.lnpslanresid = string;
        this.lnpslanresidDirtyFlag = true;
    }

    public String getLNPSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLNPSLanResId();
        }
        return this.lnpslanresid;
    }

    public boolean isLNPSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLNPSLanResIdDirty();
        }
        return this.lnpslanresidDirtyFlag;
    }

    public void resetLNPSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLNPSLanResId();
            return;
        }
        this.lnpslanresidDirtyFlag = false;
        this.lnpslanresid = null;
    }

    public void setLNPSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLNPSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.lnpslanresname = string;
        this.lnpslanresnameDirtyFlag = true;
    }

    public String getLNPSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLNPSLanResName();
        }
        return this.lnpslanresname;
    }

    public boolean isLNPSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLNPSLanResNameDirty();
        }
        return this.lnpslanresnameDirtyFlag;
    }

    public void resetLNPSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLNPSLanResName();
            return;
        }
        this.lnpslanresnameDirtyFlag = false;
        this.lnpslanresname = null;
    }

    public void setLockFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLockFlag(n);
            return;
        }
        this.lockflag = n;
        this.lockflagDirtyFlag = true;
    }

    public Integer getLockFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLockFlag();
        }
        return this.lockflag;
    }

    public boolean isLockFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLockFlagDirty();
        }
        return this.lockflagDirtyFlag;
    }

    public void resetLockFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLockFlag();
            return;
        }
        this.lockflagDirtyFlag = false;
        this.lockflag = null;
    }

    public void setLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.logicname = string;
        this.logicnameDirtyFlag = true;
    }

    public String getLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogicName();
        }
        return this.logicname;
    }

    public boolean isLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogicNameDirty();
        }
        return this.logicnameDirtyFlag;
    }

    public void resetLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogicName();
            return;
        }
        this.logicnameDirtyFlag = false;
        this.logicname = null;
    }

    public void setMajorField(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMajorField(n);
            return;
        }
        this.majorfield = n;
        this.majorfieldDirtyFlag = true;
    }

    public Integer getMajorField() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMajorField();
        }
        return this.majorfield;
    }

    public boolean isMajorFieldDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMajorFieldDirty();
        }
        return this.majorfieldDirtyFlag;
    }

    public void resetMajorField() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMajorField();
            return;
        }
        this.majorfieldDirtyFlag = false;
        this.majorfield = null;
    }

    public void setMaxValue(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMaxValue(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.maxvalue = string;
        this.maxvalueDirtyFlag = true;
    }

    public String getMaxValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMaxValue();
        }
        return this.maxvalue;
    }

    public boolean isMaxValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMaxValueDirty();
        }
        return this.maxvalueDirtyFlag;
    }

    public void resetMaxValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMaxValue();
            return;
        }
        this.maxvalueDirtyFlag = false;
        this.maxvalue = null;
    }

    public void setMemo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMemo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.memo = string;
        this.memoDirtyFlag = true;
    }

    public String getMemo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMemo();
        }
        return this.memo;
    }

    public boolean isMemoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMemoDirty();
        }
        return this.memoDirtyFlag;
    }

    public void resetMemo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMemo();
            return;
        }
        this.memoDirtyFlag = false;
        this.memo = null;
    }

    public void setMinStrLength(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinStrLength(n);
            return;
        }
        this.minstrlength = n;
        this.minstrlengthDirtyFlag = true;
    }

    public Integer getMinStrLength() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinStrLength();
        }
        return this.minstrlength;
    }

    public boolean isMinStrLengthDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinStrLengthDirty();
        }
        return this.minstrlengthDirtyFlag;
    }

    public void resetMinStrLength() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinStrLength();
            return;
        }
        this.minstrlengthDirtyFlag = false;
        this.minstrlength = null;
    }

    public void setMinValue(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinValue(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.minvalue = string;
        this.minvalueDirtyFlag = true;
    }

    public String getMinValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinValue();
        }
        return this.minvalue;
    }

    public boolean isMinValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinValueDirty();
        }
        return this.minvalueDirtyFlag;
    }

    public void resetMinValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinValue();
            return;
        }
        this.minvalueDirtyFlag = false;
        this.minvalue = null;
    }

    public void setMultiFormField(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMultiFormField(n);
            return;
        }
        this.multiformfield = n;
        this.multiformfieldDirtyFlag = true;
    }

    public Integer getMultiFormField() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMultiFormField();
        }
        return this.multiformfield;
    }

    public boolean isMultiFormFieldDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMultiFormFieldDirty();
        }
        return this.multiformfieldDirtyFlag;
    }

    public void resetMultiFormField() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMultiFormField();
            return;
        }
        this.multiformfieldDirtyFlag = false;
        this.multiformfield = null;
    }

    public void setNo2DupChkPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo2DupChkPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no2dupchkpsdefid = string;
        this.no2dupchkpsdefidDirtyFlag = true;
    }

    public String getNo2DupChkPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo2DupChkPSDEFId();
        }
        return this.no2dupchkpsdefid;
    }

    public boolean isNo2DupChkPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo2DupChkPSDEFIdDirty();
        }
        return this.no2dupchkpsdefidDirtyFlag;
    }

    public void resetNo2DupChkPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo2DupChkPSDEFId();
            return;
        }
        this.no2dupchkpsdefidDirtyFlag = false;
        this.no2dupchkpsdefid = null;
    }

    public void setNo2DupChkPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo2DupChkPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no2dupchkpsdefname = string;
        this.no2dupchkpsdefnameDirtyFlag = true;
    }

    public String getNo2DupChkPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo2DupChkPSDEFName();
        }
        return this.no2dupchkpsdefname;
    }

    public boolean isNo2DupChkPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo2DupChkPSDEFNameDirty();
        }
        return this.no2dupchkpsdefnameDirtyFlag;
    }

    public void resetNo2DupChkPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo2DupChkPSDEFName();
            return;
        }
        this.no2dupchkpsdefnameDirtyFlag = false;
        this.no2dupchkpsdefname = null;
    }

    public void setNo3DupChkPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo3DupChkPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no3dupchkpsdefid = string;
        this.no3dupchkpsdefidDirtyFlag = true;
    }

    public String getNo3DupChkPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo3DupChkPSDEFId();
        }
        return this.no3dupchkpsdefid;
    }

    public boolean isNo3DupChkPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo3DupChkPSDEFIdDirty();
        }
        return this.no3dupchkpsdefidDirtyFlag;
    }

    public void resetNo3DupChkPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo3DupChkPSDEFId();
            return;
        }
        this.no3dupchkpsdefidDirtyFlag = false;
        this.no3dupchkpsdefid = null;
    }

    public void setNo3DupChkPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo3DupChkPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no3dupchkpsdefname = string;
        this.no3dupchkpsdefnameDirtyFlag = true;
    }

    public String getNo3DupChkPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo3DupChkPSDEFName();
        }
        return this.no3dupchkpsdefname;
    }

    public boolean isNo3DupChkPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo3DupChkPSDEFNameDirty();
        }
        return this.no3dupchkpsdefnameDirtyFlag;
    }

    public void resetNo3DupChkPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo3DupChkPSDEFName();
            return;
        }
        this.no3dupchkpsdefnameDirtyFlag = false;
        this.no3dupchkpsdefname = null;
    }

    public void setNullValOrder(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNullValOrder(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.nullvalorder = string;
        this.nullvalorderDirtyFlag = true;
    }

    public String getNullValOrder() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNullValOrder();
        }
        return this.nullvalorder;
    }

    public boolean isNullValOrderDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNullValOrderDirty();
        }
        return this.nullvalorderDirtyFlag;
    }

    public void resetNullValOrder() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNullValOrder();
            return;
        }
        this.nullvalorderDirtyFlag = false;
        this.nullvalorder = null;
    }

    public void setO2MPSDERId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setO2MPSDERId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.o2mpsderid = string;
        this.o2mpsderidDirtyFlag = true;
    }

    public String getO2MPSDERId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getO2MPSDERId();
        }
        return this.o2mpsderid;
    }

    public boolean isO2MPSDERIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isO2MPSDERIdDirty();
        }
        return this.o2mpsderidDirtyFlag;
    }

    public void resetO2MPSDERId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetO2MPSDERId();
            return;
        }
        this.o2mpsderidDirtyFlag = false;
        this.o2mpsderid = null;
    }

    public void setO2MPSDERName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setO2MPSDERName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.o2mpsdername = string;
        this.o2mpsdernameDirtyFlag = true;
    }

    public String getO2MPSDERName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getO2MPSDERName();
        }
        return this.o2mpsdername;
    }

    public boolean isO2MPSDERNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isO2MPSDERNameDirty();
        }
        return this.o2mpsdernameDirtyFlag;
    }

    public void resetO2MPSDERName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetO2MPSDERName();
            return;
        }
        this.o2mpsdernameDirtyFlag = false;
        this.o2mpsdername = null;
    }

    public void setO2OPSDERId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setO2OPSDERId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.o2opsderid = string;
        this.o2opsderidDirtyFlag = true;
    }

    public String getO2OPSDERId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getO2OPSDERId();
        }
        return this.o2opsderid;
    }

    public boolean isO2OPSDERIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isO2OPSDERIdDirty();
        }
        return this.o2opsderidDirtyFlag;
    }

    public void resetO2OPSDERId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetO2OPSDERId();
            return;
        }
        this.o2opsderidDirtyFlag = false;
        this.o2opsderid = null;
    }

    public void setO2OPSDERName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setO2OPSDERName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.o2opsdername = string;
        this.o2opsdernameDirtyFlag = true;
    }

    public String getO2OPSDERName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getO2OPSDERName();
        }
        return this.o2opsdername;
    }

    public boolean isO2OPSDERNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isO2OPSDERNameDirty();
        }
        return this.o2opsdernameDirtyFlag;
    }

    public void resetO2OPSDERName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetO2OPSDERName();
            return;
        }
        this.o2opsdernameDirtyFlag = false;
        this.o2opsdername = null;
    }

    public void setOrderValue(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOrderValue(n);
            return;
        }
        this.ordervalue = n;
        this.ordervalueDirtyFlag = true;
    }

    public Integer getOrderValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOrderValue();
        }
        return this.ordervalue;
    }

    public boolean isOrderValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOrderValueDirty();
        }
        return this.ordervalueDirtyFlag;
    }

    public void resetOrderValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOrderValue();
            return;
        }
        this.ordervalueDirtyFlag = false;
        this.ordervalue = null;
    }

    public void setPasteReset(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPasteReset(n);
            return;
        }
        this.pastereset = n;
        this.pasteresetDirtyFlag = true;
    }

    public Integer getPasteReset() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPasteReset();
        }
        return this.pastereset;
    }

    public boolean isPasteResetDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPasteResetDirty();
        }
        return this.pasteresetDirtyFlag;
    }

    public void resetPasteReset() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPasteReset();
            return;
        }
        this.pasteresetDirtyFlag = false;
        this.pastereset = null;
    }

    public void setPhysicalField(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPhysicalField(n);
            return;
        }
        this.physicalfield = n;
        this.physicalfieldDirtyFlag = true;
    }

    public Integer getPhysicalField() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPhysicalField();
        }
        return this.physicalfield;
    }

    public boolean isPhysicalFieldDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPhysicalFieldDirty();
        }
        return this.physicalfieldDirtyFlag;
    }

    public void resetPhysicalField() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPhysicalField();
            return;
        }
        this.physicalfieldDirtyFlag = false;
        this.physicalfield = null;
    }

    public void setPKey(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPKey(n);
            return;
        }
        this.pkey = n;
        this.pkeyDirtyFlag = true;
    }

    public Integer getPKey() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPKey();
        }
        return this.pkey;
    }

    public boolean isPKeyDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPKeyDirty();
        }
        return this.pkeyDirtyFlag;
    }

    public void resetPKey() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPKey();
            return;
        }
        this.pkeyDirtyFlag = false;
        this.pkey = null;
    }

    public void setPrecision2(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPrecision2(n);
            return;
        }
        this.precision2 = n;
        this.precision2DirtyFlag = true;
    }

    public Integer getPrecision2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPrecision2();
        }
        return this.precision2;
    }

    public boolean isPrecision2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPrecision2Dirty();
        }
        return this.precision2DirtyFlag;
    }

    public void resetPrecision2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPrecision2();
            return;
        }
        this.precision2DirtyFlag = false;
        this.precision2 = null;
    }

    public void setPredefinedTypeParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPredefinedTypeParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.predefinedtypeparam = string;
        this.predefinedtypeparamDirtyFlag = true;
    }

    public String getPredefinedTypeParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPredefinedTypeParam();
        }
        return this.predefinedtypeparam;
    }

    public boolean isPredefinedTypeParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPredefinedTypeParamDirty();
        }
        return this.predefinedtypeparamDirtyFlag;
    }

    public void resetPredefinedTypeParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPredefinedTypeParam();
            return;
        }
        this.predefinedtypeparamDirtyFlag = false;
        this.predefinedtypeparam = null;
    }

    public void setPreDefineType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPreDefineType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.predefinetype = string;
        this.predefinetypeDirtyFlag = true;
    }

    public String getPreDefineType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPreDefineType();
        }
        return this.predefinetype;
    }

    public boolean isPreDefineTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPreDefineTypeDirty();
        }
        return this.predefinetypeDirtyFlag;
    }

    public void resetPreDefineType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPreDefineType();
            return;
        }
        this.predefinetypeDirtyFlag = false;
        this.predefinetype = null;
    }

    public void setPSCodeListId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCodeListId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscodelistid = string;
        this.pscodelistidDirtyFlag = true;
    }

    public String getPSCodeListId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCodeListId();
        }
        return this.pscodelistid;
    }

    public boolean isPSCodeListIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCodeListIdDirty();
        }
        return this.pscodelistidDirtyFlag;
    }

    public void resetPSCodeListId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCodeListId();
            return;
        }
        this.pscodelistidDirtyFlag = false;
        this.pscodelistid = null;
    }

    public void setPSCodeListName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCodeListName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscodelistname = string;
        this.pscodelistnameDirtyFlag = true;
    }

    public String getPSCodeListName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCodeListName();
        }
        return this.pscodelistname;
    }

    public boolean isPSCodeListNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCodeListNameDirty();
        }
        return this.pscodelistnameDirtyFlag;
    }

    public void resetPSCodeListName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCodeListName();
            return;
        }
        this.pscodelistnameDirtyFlag = false;
        this.pscodelistname = null;
    }

    public void setPSDataTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDataTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdatatypeid = string;
        this.psdatatypeidDirtyFlag = true;
    }

    public String getPSDataTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDataTypeId();
        }
        return this.psdatatypeid;
    }

    public boolean isPSDataTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDataTypeIdDirty();
        }
        return this.psdatatypeidDirtyFlag;
    }

    public void resetPSDataTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDataTypeId();
            return;
        }
        this.psdatatypeidDirtyFlag = false;
        this.psdatatypeid = null;
    }

    public void setPSDataTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDataTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdatatypename = string;
        this.psdatatypenameDirtyFlag = true;
    }

    public String getPSDataTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDataTypeName();
        }
        return this.psdatatypename;
    }

    public boolean isPSDataTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDataTypeNameDirty();
        }
        return this.psdatatypenameDirtyFlag;
    }

    public void resetPSDataTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDataTypeName();
            return;
        }
        this.psdatatypenameDirtyFlag = false;
        this.psdatatypename = null;
    }

    public void setPSDEFDTColsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFDTColsCnt(n);
            return;
        }
        this.psdefdtcolscnt = n;
        this.psdefdtcolscntDirtyFlag = true;
    }

    public Integer getPSDEFDTColsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFDTColsCnt();
        }
        return this.psdefdtcolscnt;
    }

    public boolean isPSDEFDTColsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFDTColsCntDirty();
        }
        return this.psdefdtcolscntDirtyFlag;
    }

    public void resetPSDEFDTColsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFDTColsCnt();
            return;
        }
        this.psdefdtcolscntDirtyFlag = false;
        this.psdefdtcolscnt = null;
    }

    public void setPSDEFieldId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFieldId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefieldid = string;
        this.psdefieldidDirtyFlag = true;
    }

    public String getPSDEFieldId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFieldId();
        }
        return this.psdefieldid;
    }

    public boolean isPSDEFieldIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFieldIdDirty();
        }
        return this.psdefieldidDirtyFlag;
    }

    public void resetPSDEFieldId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFieldId();
            return;
        }
        this.psdefieldidDirtyFlag = false;
        this.psdefieldid = null;
    }

    public void setPSDEFieldName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFieldName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        if (string != null) {
            string = string.toUpperCase();
        }
        this.psdefieldname = string;
        this.psdefieldnameDirtyFlag = true;
    }

    public String getPSDEFieldName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFieldName();
        }
        return this.psdefieldname;
    }

    public boolean isPSDEFieldNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFieldNameDirty();
        }
        return this.psdefieldnameDirtyFlag;
    }

    public void resetPSDEFieldName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFieldName();
            return;
        }
        this.psdefieldnameDirtyFlag = false;
        this.psdefieldname = null;
    }

    public void setPSDEFieldsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFieldsCnt(n);
            return;
        }
        this.psdefieldscnt = n;
        this.psdefieldscntDirtyFlag = true;
    }

    public Integer getPSDEFieldsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFieldsCnt();
        }
        return this.psdefieldscnt;
    }

    public boolean isPSDEFieldsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFieldsCntDirty();
        }
        return this.psdefieldscntDirtyFlag;
    }

    public void resetPSDEFieldsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFieldsCnt();
            return;
        }
        this.psdefieldscntDirtyFlag = false;
        this.psdefieldscnt = null;
    }

    public void setPSDEFInputTipsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFInputTipsCnt(n);
            return;
        }
        this.psdefinputtipscnt = n;
        this.psdefinputtipscntDirtyFlag = true;
    }

    public Integer getPSDEFInputTipsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFInputTipsCnt();
        }
        return this.psdefinputtipscnt;
    }

    public boolean isPSDEFInputTipsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFInputTipsCntDirty();
        }
        return this.psdefinputtipscntDirtyFlag;
    }

    public void resetPSDEFInputTipsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFInputTipsCnt();
            return;
        }
        this.psdefinputtipscntDirtyFlag = false;
        this.psdefinputtipscnt = null;
    }

    public void setPSDEFSFItemsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFSFItemsCnt(n);
            return;
        }
        this.psdefsfitemscnt = n;
        this.psdefsfitemscntDirtyFlag = true;
    }

    public Integer getPSDEFSFItemsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFSFItemsCnt();
        }
        return this.psdefsfitemscnt;
    }

    public boolean isPSDEFSFItemsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFSFItemsCntDirty();
        }
        return this.psdefsfitemscntDirtyFlag;
    }

    public void resetPSDEFSFItemsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFSFItemsCnt();
            return;
        }
        this.psdefsfitemscntDirtyFlag = false;
        this.psdefsfitemscnt = null;
    }

    public void setPSDEFUIModesCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFUIModesCnt(n);
            return;
        }
        this.psdefuimodescnt = n;
        this.psdefuimodescntDirtyFlag = true;
    }

    public Integer getPSDEFUIModesCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFUIModesCnt();
        }
        return this.psdefuimodescnt;
    }

    public boolean isPSDEFUIModesCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFUIModesCntDirty();
        }
        return this.psdefuimodescntDirtyFlag;
    }

    public void resetPSDEFUIModesCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFUIModesCnt();
            return;
        }
        this.psdefuimodescntDirtyFlag = false;
        this.psdefuimodescnt = null;
    }

    public void setPSDEFValueRulesCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFValueRulesCnt(n);
            return;
        }
        this.psdefvaluerulescnt = n;
        this.psdefvaluerulescntDirtyFlag = true;
    }

    public Integer getPSDEFValueRulesCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFValueRulesCnt();
        }
        return this.psdefvaluerulescnt;
    }

    public boolean isPSDEFValueRulesCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFValueRulesCntDirty();
        }
        return this.psdefvaluerulescntDirtyFlag;
    }

    public void resetPSDEFValueRulesCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFValueRulesCnt();
            return;
        }
        this.psdefvaluerulescntDirtyFlag = false;
        this.psdefvaluerulescnt = null;
    }

    public void setPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeid = string;
        this.psdeidDirtyFlag = true;
    }

    public String getPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEId();
        }
        return this.psdeid;
    }

    public boolean isPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEIdDirty();
        }
        return this.psdeidDirtyFlag;
    }

    public void resetPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEId();
            return;
        }
        this.psdeidDirtyFlag = false;
        this.psdeid = null;
    }

    public void setPSDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdename = string;
        this.psdenameDirtyFlag = true;
    }

    public String getPSDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEName();
        }
        return this.psdename;
    }

    public boolean isPSDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDENameDirty();
        }
        return this.psdenameDirtyFlag;
    }

    public void resetPSDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEName();
            return;
        }
        this.psdenameDirtyFlag = false;
        this.psdename = null;
    }

    public void setPSDERId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDERId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psderid = string;
        this.psderidDirtyFlag = true;
    }

    public String getPSDERId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDERId();
        }
        return this.psderid;
    }

    public boolean isPSDERIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDERIdDirty();
        }
        return this.psderidDirtyFlag;
    }

    public void resetPSDERId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDERId();
            return;
        }
        this.psderidDirtyFlag = false;
        this.psderid = null;
    }

    public void setPSDERName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDERName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdername = string;
        this.psdernameDirtyFlag = true;
    }

    public String getPSDERName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDERName();
        }
        return this.psdername;
    }

    public boolean isPSDERNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDERNameDirty();
        }
        return this.psdernameDirtyFlag;
    }

    public void resetPSDERName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDERName();
            return;
        }
        this.psdernameDirtyFlag = false;
        this.psdername = null;
    }

    public void setPSDETableId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDETableId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdetableid = string;
        this.psdetableidDirtyFlag = true;
    }

    public String getPSDETableId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETableId();
        }
        return this.psdetableid;
    }

    public boolean isPSDETableIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDETableIdDirty();
        }
        return this.psdetableidDirtyFlag;
    }

    public void resetPSDETableId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDETableId();
            return;
        }
        this.psdetableidDirtyFlag = false;
        this.psdetableid = null;
    }

    public void setPSDynaInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynainstid = string;
        this.psdynainstidDirtyFlag = true;
    }

    public String getPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaInstId();
        }
        return this.psdynainstid;
    }

    public boolean isPSDynaInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaInstIdDirty();
        }
        return this.psdynainstidDirtyFlag;
    }

    public void resetPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaInstId();
            return;
        }
        this.psdynainstidDirtyFlag = false;
        this.psdynainstid = null;
    }

    public void setPSSubSysSADEFieldId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubSysSADEFieldId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubsyssadefieldid = string;
        this.pssubsyssadefieldidDirtyFlag = true;
    }

    public String getPSSubSysSADEFieldId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysSADEFieldId();
        }
        return this.pssubsyssadefieldid;
    }

    public boolean isPSSubSysSADEFieldIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubSysSADEFieldIdDirty();
        }
        return this.pssubsyssadefieldidDirtyFlag;
    }

    public void resetPSSubSysSADEFieldId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubSysSADEFieldId();
            return;
        }
        this.pssubsyssadefieldidDirtyFlag = false;
        this.pssubsyssadefieldid = null;
    }

    public void setPSSubSysSADEFieldName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubSysSADEFieldName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubsyssadefieldname = string;
        this.pssubsyssadefieldnameDirtyFlag = true;
    }

    public String getPSSubSysSADEFieldName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysSADEFieldName();
        }
        return this.pssubsyssadefieldname;
    }

    public boolean isPSSubSysSADEFieldNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubSysSADEFieldNameDirty();
        }
        return this.pssubsyssadefieldnameDirtyFlag;
    }

    public void resetPSSubSysSADEFieldName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubSysSADEFieldName();
            return;
        }
        this.pssubsyssadefieldnameDirtyFlag = false;
        this.pssubsyssadefieldname = null;
    }

    public void setPSSubSysSADEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubSysSADEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubsyssadeid = string;
        this.pssubsyssadeidDirtyFlag = true;
    }

    public String getPSSubSysSADEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysSADEId();
        }
        return this.pssubsyssadeid;
    }

    public boolean isPSSubSysSADEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubSysSADEIdDirty();
        }
        return this.pssubsyssadeidDirtyFlag;
    }

    public void resetPSSubSysSADEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubSysSADEId();
            return;
        }
        this.pssubsyssadeidDirtyFlag = false;
        this.pssubsyssadeid = null;
    }

    public void setPSSysDBColumnId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDBColumnId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdbcolumnid = string;
        this.pssysdbcolumnidDirtyFlag = true;
    }

    public String getPSSysDBColumnId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBColumnId();
        }
        return this.pssysdbcolumnid;
    }

    public boolean isPSSysDBColumnIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDBColumnIdDirty();
        }
        return this.pssysdbcolumnidDirtyFlag;
    }

    public void resetPSSysDBColumnId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDBColumnId();
            return;
        }
        this.pssysdbcolumnidDirtyFlag = false;
        this.pssysdbcolumnid = null;
    }

    public void setPSSysSampleValueId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSampleValueId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssamplevalueid = string;
        this.pssyssamplevalueidDirtyFlag = true;
    }

    public String getPSSysSampleValueId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSampleValueId();
        }
        return this.pssyssamplevalueid;
    }

    public boolean isPSSysSampleValueIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSampleValueIdDirty();
        }
        return this.pssyssamplevalueidDirtyFlag;
    }

    public void resetPSSysSampleValueId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSampleValueId();
            return;
        }
        this.pssyssamplevalueidDirtyFlag = false;
        this.pssyssamplevalueid = null;
    }

    public void setPSSysSampleValueName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSampleValueName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssamplevaluename = string;
        this.pssyssamplevaluenameDirtyFlag = true;
    }

    public String getPSSysSampleValueName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSampleValueName();
        }
        return this.pssyssamplevaluename;
    }

    public boolean isPSSysSampleValueNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSampleValueNameDirty();
        }
        return this.pssyssamplevaluenameDirtyFlag;
    }

    public void resetPSSysSampleValueName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSampleValueName();
            return;
        }
        this.pssyssamplevaluenameDirtyFlag = false;
        this.pssyssamplevaluename = null;
    }

    public void setPSSysSequenceId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSequenceId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssequenceid = string;
        this.pssyssequenceidDirtyFlag = true;
    }

    public String getPSSysSequenceId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSequenceId();
        }
        return this.pssyssequenceid;
    }

    public boolean isPSSysSequenceIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSequenceIdDirty();
        }
        return this.pssyssequenceidDirtyFlag;
    }

    public void resetPSSysSequenceId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSequenceId();
            return;
        }
        this.pssyssequenceidDirtyFlag = false;
        this.pssyssequenceid = null;
    }

    public void setPSSysSequenceName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSequenceName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssequencename = string;
        this.pssyssequencenameDirtyFlag = true;
    }

    public String getPSSysSequenceName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSequenceName();
        }
        return this.pssyssequencename;
    }

    public boolean isPSSysSequenceNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSequenceNameDirty();
        }
        return this.pssyssequencenameDirtyFlag;
    }

    public void resetPSSysSequenceName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSequenceName();
            return;
        }
        this.pssyssequencenameDirtyFlag = false;
        this.pssyssequencename = null;
    }

    public void setPSSystemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemid = string;
        this.pssystemidDirtyFlag = true;
    }

    public String getPSSystemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemId();
        }
        return this.pssystemid;
    }

    public boolean isPSSystemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemIdDirty();
        }
        return this.pssystemidDirtyFlag;
    }

    public void resetPSSystemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemId();
            return;
        }
        this.pssystemidDirtyFlag = false;
        this.pssystemid = null;
    }

    public void setPSSysTestCasesCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysTestCasesCnt(n);
            return;
        }
        this.pssystestcasescnt = n;
        this.pssystestcasescntDirtyFlag = true;
    }

    public Integer getPSSysTestCasesCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTestCasesCnt();
        }
        return this.pssystestcasescnt;
    }

    public boolean isPSSysTestCasesCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysTestCasesCntDirty();
        }
        return this.pssystestcasescntDirtyFlag;
    }

    public void resetPSSysTestCasesCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysTestCasesCnt();
            return;
        }
        this.pssystestcasescntDirtyFlag = false;
        this.pssystestcasescnt = null;
    }

    public void setPSSysTranslatorId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysTranslatorId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystranslatorid = string;
        this.pssystranslatoridDirtyFlag = true;
    }

    public String getPSSysTranslatorId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTranslatorId();
        }
        return this.pssystranslatorid;
    }

    public boolean isPSSysTranslatorIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysTranslatorIdDirty();
        }
        return this.pssystranslatoridDirtyFlag;
    }

    public void resetPSSysTranslatorId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysTranslatorId();
            return;
        }
        this.pssystranslatoridDirtyFlag = false;
        this.pssystranslatorid = null;
    }

    public void setPSSysTranslatorName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysTranslatorName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystranslatorname = string;
        this.pssystranslatornameDirtyFlag = true;
    }

    public String getPSSysTranslatorName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTranslatorName();
        }
        return this.pssystranslatorname;
    }

    public boolean isPSSysTranslatorNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysTranslatorNameDirty();
        }
        return this.pssystranslatornameDirtyFlag;
    }

    public void resetPSSysTranslatorName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysTranslatorName();
            return;
        }
        this.pssystranslatornameDirtyFlag = false;
        this.pssystranslatorname = null;
    }

    public void setPSSysUnitId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUnitId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysunitid = string;
        this.pssysunitidDirtyFlag = true;
    }

    public String getPSSysUnitId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUnitId();
        }
        return this.pssysunitid;
    }

    public boolean isPSSysUnitIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUnitIdDirty();
        }
        return this.pssysunitidDirtyFlag;
    }

    public void resetPSSysUnitId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUnitId();
            return;
        }
        this.pssysunitidDirtyFlag = false;
        this.pssysunitid = null;
    }

    public void setPSSysUnitName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUnitName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysunitname = string;
        this.pssysunitnameDirtyFlag = true;
    }

    public String getPSSysUnitName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUnitName();
        }
        return this.pssysunitname;
    }

    public boolean isPSSysUnitNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUnitNameDirty();
        }
        return this.pssysunitnameDirtyFlag;
    }

    public void resetPSSysUnitName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUnitName();
            return;
        }
        this.pssysunitnameDirtyFlag = false;
        this.pssysunitname = null;
    }

    public void setPSSysValueRuleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysValueRuleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysvalueruleid = string;
        this.pssysvalueruleidDirtyFlag = true;
    }

    public String getPSSysValueRuleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysValueRuleId();
        }
        return this.pssysvalueruleid;
    }

    public boolean isPSSysValueRuleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysValueRuleIdDirty();
        }
        return this.pssysvalueruleidDirtyFlag;
    }

    public void resetPSSysValueRuleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysValueRuleId();
            return;
        }
        this.pssysvalueruleidDirtyFlag = false;
        this.pssysvalueruleid = null;
    }

    public void setPSSysValueRuleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysValueRuleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysvaluerulename = string;
        this.pssysvaluerulenameDirtyFlag = true;
    }

    public String getPSSysValueRuleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysValueRuleName();
        }
        return this.pssysvaluerulename;
    }

    public boolean isPSSysValueRuleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysValueRuleNameDirty();
        }
        return this.pssysvaluerulenameDirtyFlag;
    }

    public void resetPSSysValueRuleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysValueRuleName();
            return;
        }
        this.pssysvaluerulenameDirtyFlag = false;
        this.pssysvaluerulename = null;
    }

    public void setQueryColumn(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setQueryColumn(n);
            return;
        }
        this.querycolumn = n;
        this.querycolumnDirtyFlag = true;
    }

    public Integer getQueryColumn() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getQueryColumn();
        }
        return this.querycolumn;
    }

    public boolean isQueryColumnDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isQueryColumnDirty();
        }
        return this.querycolumnDirtyFlag;
    }

    public void resetQueryColumn() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetQueryColumn();
            return;
        }
        this.querycolumnDirtyFlag = false;
        this.querycolumn = null;
    }

    public void setQueryCS(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setQueryCS(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.querycs = string;
        this.querycsDirtyFlag = true;
    }

    public String getQueryCS() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getQueryCS();
        }
        return this.querycs;
    }

    public boolean isQueryCSDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isQueryCSDirty();
        }
        return this.querycsDirtyFlag;
    }

    public void resetQueryCS() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetQueryCS();
            return;
        }
        this.querycsDirtyFlag = false;
        this.querycs = null;
    }

    public void setReadOnlyMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReadOnlyMode(n);
            return;
        }
        this.readonlymode = n;
        this.readonlymodeDirtyFlag = true;
    }

    public Integer getReadOnlyMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReadOnlyMode();
        }
        return this.readonlymode;
    }

    public boolean isReadOnlyModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReadOnlyModeDirty();
        }
        return this.readonlymodeDirtyFlag;
    }

    public void resetReadOnlyMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReadOnlyMode();
            return;
        }
        this.readonlymodeDirtyFlag = false;
        this.readonlymode = null;
    }

    public void setRefPSSysDynaModelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSSysDynaModelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpssysdynamodelid = string;
        this.refpssysdynamodelidDirtyFlag = true;
    }

    public String getRefPSSysDynaModelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSSysDynaModelId();
        }
        return this.refpssysdynamodelid;
    }

    public boolean isRefPSSysDynaModelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSSysDynaModelIdDirty();
        }
        return this.refpssysdynamodelidDirtyFlag;
    }

    public void resetRefPSSysDynaModelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSSysDynaModelId();
            return;
        }
        this.refpssysdynamodelidDirtyFlag = false;
        this.refpssysdynamodelid = null;
    }

    public void setRefPSSysDynaModelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSSysDynaModelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpssysdynamodelname = string;
        this.refpssysdynamodelnameDirtyFlag = true;
    }

    public String getRefPSSysDynaModelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSSysDynaModelName();
        }
        return this.refpssysdynamodelname;
    }

    public boolean isRefPSSysDynaModelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSSysDynaModelNameDirty();
        }
        return this.refpssysdynamodelnameDirtyFlag;
    }

    public void resetRefPSSysDynaModelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSSysDynaModelName();
            return;
        }
        this.refpssysdynamodelnameDirtyFlag = false;
        this.refpssysdynamodelname = null;
    }

    public void setRestrictedPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRestrictedPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.restrictedpsdefid = string;
        this.restrictedpsdefidDirtyFlag = true;
    }

    public String getRestrictedPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRestrictedPSDEFId();
        }
        return this.restrictedpsdefid;
    }

    public boolean isRestrictedPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRestrictedPSDEFIdDirty();
        }
        return this.restrictedpsdefidDirtyFlag;
    }

    public void resetRestrictedPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRestrictedPSDEFId();
            return;
        }
        this.restrictedpsdefidDirtyFlag = false;
        this.restrictedpsdefid = null;
    }

    public void setRestrictedPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRestrictedPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.restrictedpsdefname = string;
        this.restrictedpsdefnameDirtyFlag = true;
    }

    public String getRestrictedPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRestrictedPSDEFName();
        }
        return this.restrictedpsdefname;
    }

    public boolean isRestrictedPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRestrictedPSDEFNameDirty();
        }
        return this.restrictedpsdefnameDirtyFlag;
    }

    public void resetRestrictedPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRestrictedPSDEFName();
            return;
        }
        this.restrictedpsdefnameDirtyFlag = false;
        this.restrictedpsdefname = null;
    }

    public void setSequenceMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSequenceMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sequencemode = string;
        this.sequencemodeDirtyFlag = true;
    }

    public String getSequenceMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSequenceMode();
        }
        return this.sequencemode;
    }

    public boolean isSequenceModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSequenceModeDirty();
        }
        return this.sequencemodeDirtyFlag;
    }

    public void resetSequenceMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSequenceMode();
            return;
        }
        this.sequencemodeDirtyFlag = false;
        this.sequencemode = null;
    }

    public void setServiceCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setServiceCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.servicecodename = string;
        this.servicecodenameDirtyFlag = true;
    }

    public String getServiceCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getServiceCodeName();
        }
        return this.servicecodename;
    }

    public boolean isServiceCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isServiceCodeNameDirty();
        }
        return this.servicecodenameDirtyFlag;
    }

    public void resetServiceCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetServiceCodeName();
            return;
        }
        this.servicecodenameDirtyFlag = false;
        this.servicecodename = null;
    }

    public void setStateField(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStateField(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.statefield = string;
        this.statefieldDirtyFlag = true;
    }

    public String getStateField() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStateField();
        }
        return this.statefield;
    }

    public boolean isStateFieldDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStateFieldDirty();
        }
        return this.statefieldDirtyFlag;
    }

    public void resetStateField() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStateField();
            return;
        }
        this.statefieldDirtyFlag = false;
        this.statefield = null;
    }

    public void setStdDataType(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStdDataType(n);
            return;
        }
        this.stddatatype = n;
        this.stddatatypeDirtyFlag = true;
    }

    public Integer getStdDataType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStdDataType();
        }
        return this.stddatatype;
    }

    public boolean isStdDataTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStdDataTypeDirty();
        }
        return this.stddatatypeDirtyFlag;
    }

    public void resetStdDataType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStdDataType();
            return;
        }
        this.stddatatypeDirtyFlag = false;
        this.stddatatype = null;
    }

    public void setStringCase(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStringCase(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.stringcase = string;
        this.stringcaseDirtyFlag = true;
    }

    public String getStringCase() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStringCase();
        }
        return this.stringcase;
    }

    public boolean isStringCaseDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStringCaseDirty();
        }
        return this.stringcaseDirtyFlag;
    }

    public void resetStringCase() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStringCase();
            return;
        }
        this.stringcaseDirtyFlag = false;
        this.stringcase = null;
    }

    public void setStrLength(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStrLength(n);
            return;
        }
        this.strlength = n;
        this.strlengthDirtyFlag = true;
    }

    public Integer getStrLength() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStrLength();
        }
        return this.strlength;
    }

    public boolean isStrLengthDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStrLengthDirty();
        }
        return this.strlengthDirtyFlag;
    }

    public void resetStrLength() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStrLength();
            return;
        }
        this.strlengthDirtyFlag = false;
        this.strlength = null;
    }

    public void setTableName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTableName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tablename = string;
        this.tablenameDirtyFlag = true;
    }

    public String getTableName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTableName();
        }
        return this.tablename;
    }

    public boolean isTableNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTableNameDirty();
        }
        return this.tablenameDirtyFlag;
    }

    public void resetTableName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTableName();
            return;
        }
        this.tablenameDirtyFlag = false;
        this.tablename = null;
    }

    public void setTableScope(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTableScope(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tablescope = string;
        this.tablescopeDirtyFlag = true;
    }

    public String getTableScope() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTableScope();
        }
        return this.tablescope;
    }

    public boolean isTableScopeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTableScopeDirty();
        }
        return this.tablescopeDirtyFlag;
    }

    public void resetTableScope() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTableScope();
            return;
        }
        this.tablescopeDirtyFlag = false;
        this.tablescope = null;
    }

    public void setTestData(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTestData(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.testdata = string;
        this.testdataDirtyFlag = true;
    }

    public String getTestData() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTestData();
        }
        return this.testdata;
    }

    public boolean isTestDataDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTestDataDirty();
        }
        return this.testdataDirtyFlag;
    }

    public void resetTestData() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTestData();
            return;
        }
        this.testdataDirtyFlag = false;
        this.testdata = null;
    }

    public void setTranslatorMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTranslatorMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.translatormode = string;
        this.translatormodeDirtyFlag = true;
    }

    public String getTranslatorMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTranslatorMode();
        }
        return this.translatormode;
    }

    public boolean isTranslatorModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTranslatorModeDirty();
        }
        return this.translatormodeDirtyFlag;
    }

    public void resetTranslatorMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTranslatorMode();
            return;
        }
        this.translatormodeDirtyFlag = false;
        this.translatormode = null;
    }

    public void setUnicodeChar(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUnicodeChar(n);
            return;
        }
        this.unicodechar = n;
        this.unicodecharDirtyFlag = true;
    }

    public Integer getUnicodeChar() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUnicodeChar();
        }
        return this.unicodechar;
    }

    public boolean isUnicodeCharDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUnicodeCharDirty();
        }
        return this.unicodecharDirtyFlag;
    }

    public void resetUnicodeChar() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUnicodeChar();
            return;
        }
        this.unicodecharDirtyFlag = false;
        this.unicodechar = null;
    }

    public void setUnionKeyValue(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUnionKeyValue(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.unionkeyvalue = string;
        this.unionkeyvalueDirtyFlag = true;
    }

    public String getUnionKeyValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUnionKeyValue();
        }
        return this.unionkeyvalue;
    }

    public boolean isUnionKeyValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUnionKeyValueDirty();
        }
        return this.unionkeyvalueDirtyFlag;
    }

    public void resetUnionKeyValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUnionKeyValue();
            return;
        }
        this.unionkeyvalueDirtyFlag = false;
        this.unionkeyvalue = null;
    }

    public void setUnit(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUnit(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.unit = string;
        this.unitDirtyFlag = true;
    }

    public String getUnit() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUnit();
        }
        return this.unit;
    }

    public boolean isUnitDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUnitDirty();
        }
        return this.unitDirtyFlag;
    }

    public void resetUnit() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUnit();
            return;
        }
        this.unitDirtyFlag = false;
        this.unit = null;
    }

    public void setUnitWidth(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUnitWidth(n);
            return;
        }
        this.unitwidth = n;
        this.unitwidthDirtyFlag = true;
    }

    public Integer getUnitWidth() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUnitWidth();
        }
        return this.unitwidth;
    }

    public boolean isUnitWidthDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUnitWidthDirty();
        }
        return this.unitwidthDirtyFlag;
    }

    public void resetUnitWidth() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUnitWidth();
            return;
        }
        this.unitwidthDirtyFlag = false;
        this.unitwidth = null;
    }

    public void setUpdateDate(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateDate(timestamp);
            return;
        }
        this.updatedate = timestamp;
        this.updatedateDirtyFlag = true;
    }

    public Timestamp getUpdateDate() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUpdateDate();
        }
        return this.updatedate;
    }

    public boolean isUpdateDateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUpdateDateDirty();
        }
        return this.updatedateDirtyFlag;
    }

    public void resetUpdateDate() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUpdateDate();
            return;
        }
        this.updatedateDirtyFlag = false;
        this.updatedate = null;
    }

    public void setUpdateMan(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateMan(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.updateman = string;
        this.updatemanDirtyFlag = true;
    }

    public String getUpdateMan() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUpdateMan();
        }
        return this.updateman;
    }

    public boolean isUpdateManDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUpdateManDirty();
        }
        return this.updatemanDirtyFlag;
    }

    public void resetUpdateMan() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUpdateMan();
            return;
        }
        this.updatemanDirtyFlag = false;
        this.updateman = null;
    }

    public void setUpdateOVMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateOVMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.updateovmode = string;
        this.updateovmodeDirtyFlag = true;
    }

    public String getUpdateOVMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUpdateOVMode();
        }
        return this.updateovmode;
    }

    public boolean isUpdateOVModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUpdateOVModeDirty();
        }
        return this.updateovmodeDirtyFlag;
    }

    public void resetUpdateOVMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUpdateOVMode();
            return;
        }
        this.updateovmodeDirtyFlag = false;
        this.updateovmode = null;
    }

    public void setUserCat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserCat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usercat = string;
        this.usercatDirtyFlag = true;
    }

    public String getUserCat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserCat();
        }
        return this.usercat;
    }

    public boolean isUserCatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserCatDirty();
        }
        return this.usercatDirtyFlag;
    }

    public void resetUserCat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserCat();
            return;
        }
        this.usercatDirtyFlag = false;
        this.usercat = null;
    }

    public void setUserParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userparams = string;
        this.userparamsDirtyFlag = true;
    }

    public String getUserParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserParams();
        }
        return this.userparams;
    }

    public boolean isUserParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserParamsDirty();
        }
        return this.userparamsDirtyFlag;
    }

    public void resetUserParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserParams();
            return;
        }
        this.userparamsDirtyFlag = false;
        this.userparams = null;
    }

    public void setUserTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag = string;
        this.usertagDirtyFlag = true;
    }

    public String getUserTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag();
        }
        return this.usertag;
    }

    public boolean isUserTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTagDirty();
        }
        return this.usertagDirtyFlag;
    }

    public void resetUserTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag();
            return;
        }
        this.usertagDirtyFlag = false;
        this.usertag = null;
    }

    public void setUserTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag2 = string;
        this.usertag2DirtyFlag = true;
    }

    public String getUserTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag2();
        }
        return this.usertag2;
    }

    public boolean isUserTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag2Dirty();
        }
        return this.usertag2DirtyFlag;
    }

    public void resetUserTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag2();
            return;
        }
        this.usertag2DirtyFlag = false;
        this.usertag2 = null;
    }

    public void setUserTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag3 = string;
        this.usertag3DirtyFlag = true;
    }

    public String getUserTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag3();
        }
        return this.usertag3;
    }

    public boolean isUserTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag3Dirty();
        }
        return this.usertag3DirtyFlag;
    }

    public void resetUserTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag3();
            return;
        }
        this.usertag3DirtyFlag = false;
        this.usertag3 = null;
    }

    public void setUserTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag4 = string;
        this.usertag4DirtyFlag = true;
    }

    public String getUserTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag4();
        }
        return this.usertag4;
    }

    public boolean isUserTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag4Dirty();
        }
        return this.usertag4DirtyFlag;
    }

    public void resetUserTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag4();
            return;
        }
        this.usertag4DirtyFlag = false;
        this.usertag4 = null;
    }

    public void setValidFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValidFlag(n);
            return;
        }
        this.validflag = n;
        this.validflagDirtyFlag = true;
    }

    public Integer getValidFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValidFlag();
        }
        return this.validflag;
    }

    public boolean isValidFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValidFlagDirty();
        }
        return this.validflagDirtyFlag;
    }

    public void resetValidFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValidFlag();
            return;
        }
        this.validflagDirtyFlag = false;
        this.validflag = null;
    }

    public void setValueFormat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValueFormat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.valueformat = string;
        this.valueformatDirtyFlag = true;
    }

    public String getValueFormat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValueFormat();
        }
        return this.valueformat;
    }

    public boolean isValueFormatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValueFormatDirty();
        }
        return this.valueformatDirtyFlag;
    }

    public void resetValueFormat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValueFormat();
            return;
        }
        this.valueformatDirtyFlag = false;
        this.valueformat = null;
    }

    public void setValuePSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValuePSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.valuepsdefid = string;
        this.valuepsdefidDirtyFlag = true;
    }

    public String getValuePSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValuePSDEFId();
        }
        return this.valuepsdefid;
    }

    public boolean isValuePSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValuePSDEFIdDirty();
        }
        return this.valuepsdefidDirtyFlag;
    }

    public void resetValuePSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValuePSDEFId();
            return;
        }
        this.valuepsdefidDirtyFlag = false;
        this.valuepsdefid = null;
    }

    public void setValuePSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValuePSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.valuepsdefname = string;
        this.valuepsdefnameDirtyFlag = true;
    }

    public String getValuePSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValuePSDEFName();
        }
        return this.valuepsdefname;
    }

    public boolean isValuePSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValuePSDEFNameDirty();
        }
        return this.valuepsdefnameDirtyFlag;
    }

    public void resetValuePSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValuePSDEFName();
            return;
        }
        this.valuepsdefnameDirtyFlag = false;
        this.valuepsdefname = null;
    }

    public void setViewColLevel(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewColLevel(n);
            return;
        }
        this.viewcollevel = n;
        this.viewcollevelDirtyFlag = true;
    }

    public Integer getViewColLevel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewColLevel();
        }
        return this.viewcollevel;
    }

    public boolean isViewColLevelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewColLevelDirty();
        }
        return this.viewcollevelDirtyFlag;
    }

    public void resetViewColLevel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewColLevel();
            return;
        }
        this.viewcollevelDirtyFlag = false;
        this.viewcollevel = null;
    }

    protected void onReset() {
        PSDEFieldBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEFieldBase pSDEFieldBase) {
        pSDEFieldBase.resetAllowEmpty();
        pSDEFieldBase.resetAuditInfoFormat();
        pSDEFieldBase.resetBizTag();
        pSDEFieldBase.resetCheckRecursion();
        pSDEFieldBase.resetCodeName();
        pSDEFieldBase.resetComputeExp();
        pSDEFieldBase.resetCreateDate();
        pSDEFieldBase.resetCreateMan();
        pSDEFieldBase.resetCustomExportScope();
        pSDEFieldBase.resetDBValueMode();
        pSDEFieldBase.resetDBValueMode2();
        pSDEFieldBase.resetDefaultValue();
        pSDEFieldBase.resetDEFType();
        pSDEFieldBase.resetDERPSDEFId();
        pSDEFieldBase.resetDERPSDEFName();
        pSDEFieldBase.resetDupCheckMode();
        pSDEFieldBase.resetDupCheckValues();
        pSDEFieldBase.resetDupCheckPSDEFId();
        pSDEFieldBase.resetDupCheckPSDEFName();
        pSDEFieldBase.resetDefaultValueType();
        pSDEFieldBase.resetDynaModelFlag();
        pSDEFieldBase.resetEnableAudit();
        pSDEFieldBase.resetEnableColPriv();
        pSDEFieldBase.resetEnableQS();
        pSDEFieldBase.resetEnableTempData();
        pSDEFieldBase.resetEnableUserInput();
        pSDEFieldBase.resetEnaWriteBack();
        pSDEFieldBase.resetExportScope();
        pSDEFieldBase.resetExpPSSysTranslatorId();
        pSDEFieldBase.resetExpPSSysTranslatorName();
        pSDEFieldBase.resetExtendMode();
        pSDEFieldBase.resetFieldHolder();
        pSDEFieldBase.resetFieldTag();
        pSDEFieldBase.resetFieldTag2();
        pSDEFieldBase.resetFKey();
        pSDEFieldBase.resetFormulaFields();
        pSDEFieldBase.resetFormulaFormat();
        pSDEFieldBase.resetImportKey();
        pSDEFieldBase.resetImportOrder();
        pSDEFieldBase.resetImportTag();
        pSDEFieldBase.resetImpPSSysTranslatorId();
        pSDEFieldBase.resetImpPSSysTranslatorName();
        pSDEFieldBase.resetIndexType();
        pSDEFieldBase.resetJSFormat();
        pSDEFieldBase.resetJsonFormat();
        pSDEFieldBase.resetLength();
        pSDEFieldBase.resetLNPSLanResId();
        pSDEFieldBase.resetLNPSLanResName();
        pSDEFieldBase.resetLockFlag();
        pSDEFieldBase.resetLogicName();
        pSDEFieldBase.resetMajorField();
        pSDEFieldBase.resetMaxValue();
        pSDEFieldBase.resetMemo();
        pSDEFieldBase.resetMinStrLength();
        pSDEFieldBase.resetMinValue();
        pSDEFieldBase.resetMultiFormField();
        pSDEFieldBase.resetNo2DupChkPSDEFId();
        pSDEFieldBase.resetNo2DupChkPSDEFName();
        pSDEFieldBase.resetNo3DupChkPSDEFId();
        pSDEFieldBase.resetNo3DupChkPSDEFName();
        pSDEFieldBase.resetNullValOrder();
        pSDEFieldBase.resetO2MPSDERId();
        pSDEFieldBase.resetO2MPSDERName();
        pSDEFieldBase.resetO2OPSDERId();
        pSDEFieldBase.resetO2OPSDERName();
        pSDEFieldBase.resetOrderValue();
        pSDEFieldBase.resetPasteReset();
        pSDEFieldBase.resetPhysicalField();
        pSDEFieldBase.resetPKey();
        pSDEFieldBase.resetPrecision2();
        pSDEFieldBase.resetPredefinedTypeParam();
        pSDEFieldBase.resetPreDefineType();
        pSDEFieldBase.resetPSCodeListId();
        pSDEFieldBase.resetPSCodeListName();
        pSDEFieldBase.resetPSDataTypeId();
        pSDEFieldBase.resetPSDataTypeName();
        pSDEFieldBase.resetPSDEFDTColsCnt();
        pSDEFieldBase.resetPSDEFieldId();
        pSDEFieldBase.resetPSDEFieldName();
        pSDEFieldBase.resetPSDEFieldsCnt();
        pSDEFieldBase.resetPSDEFInputTipsCnt();
        pSDEFieldBase.resetPSDEFSFItemsCnt();
        pSDEFieldBase.resetPSDEFUIModesCnt();
        pSDEFieldBase.resetPSDEFValueRulesCnt();
        pSDEFieldBase.resetPSDEId();
        pSDEFieldBase.resetPSDEName();
        pSDEFieldBase.resetPSDERId();
        pSDEFieldBase.resetPSDERName();
        pSDEFieldBase.resetPSDETableId();
        pSDEFieldBase.resetPSDynaInstId();
        pSDEFieldBase.resetPSSubSysSADEFieldId();
        pSDEFieldBase.resetPSSubSysSADEFieldName();
        pSDEFieldBase.resetPSSubSysSADEId();
        pSDEFieldBase.resetPSSysDBColumnId();
        pSDEFieldBase.resetPSSysSampleValueId();
        pSDEFieldBase.resetPSSysSampleValueName();
        pSDEFieldBase.resetPSSysSequenceId();
        pSDEFieldBase.resetPSSysSequenceName();
        pSDEFieldBase.resetPSSystemId();
        pSDEFieldBase.resetPSSysTestCasesCnt();
        pSDEFieldBase.resetPSSysTranslatorId();
        pSDEFieldBase.resetPSSysTranslatorName();
        pSDEFieldBase.resetPSSysUnitId();
        pSDEFieldBase.resetPSSysUnitName();
        pSDEFieldBase.resetPSSysValueRuleId();
        pSDEFieldBase.resetPSSysValueRuleName();
        pSDEFieldBase.resetQueryColumn();
        pSDEFieldBase.resetQueryCS();
        pSDEFieldBase.resetReadOnlyMode();
        pSDEFieldBase.resetRefPSSysDynaModelId();
        pSDEFieldBase.resetRefPSSysDynaModelName();
        pSDEFieldBase.resetRestrictedPSDEFId();
        pSDEFieldBase.resetRestrictedPSDEFName();
        pSDEFieldBase.resetSequenceMode();
        pSDEFieldBase.resetServiceCodeName();
        pSDEFieldBase.resetStateField();
        pSDEFieldBase.resetStdDataType();
        pSDEFieldBase.resetStringCase();
        pSDEFieldBase.resetStrLength();
        pSDEFieldBase.resetTableName();
        pSDEFieldBase.resetTableScope();
        pSDEFieldBase.resetTestData();
        pSDEFieldBase.resetTranslatorMode();
        pSDEFieldBase.resetUnicodeChar();
        pSDEFieldBase.resetUnionKeyValue();
        pSDEFieldBase.resetUnit();
        pSDEFieldBase.resetUnitWidth();
        pSDEFieldBase.resetUpdateDate();
        pSDEFieldBase.resetUpdateMan();
        pSDEFieldBase.resetUpdateOVMode();
        pSDEFieldBase.resetUserCat();
        pSDEFieldBase.resetUserParams();
        pSDEFieldBase.resetUserTag();
        pSDEFieldBase.resetUserTag2();
        pSDEFieldBase.resetUserTag3();
        pSDEFieldBase.resetUserTag4();
        pSDEFieldBase.resetValidFlag();
        pSDEFieldBase.resetValueFormat();
        pSDEFieldBase.resetValuePSDEFId();
        pSDEFieldBase.resetValuePSDEFName();
        pSDEFieldBase.resetViewColLevel();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAllowEmptyDirty()) {
            hashMap.put(FIELD_ALLOWEMPTY, this.getAllowEmpty());
        }
        if (!bl || this.isAuditInfoFormatDirty()) {
            hashMap.put(FIELD_AUDITINFOFORMAT, this.getAuditInfoFormat());
        }
        if (!bl || this.isBizTagDirty()) {
            hashMap.put(FIELD_BIZTAG, this.getBizTag());
        }
        if (!bl || this.isCheckRecursionDirty()) {
            hashMap.put(FIELD_CHECKRECURSION, this.getCheckRecursion());
        }
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isComputeExpDirty()) {
            hashMap.put(FIELD_COMPUTEEXP, this.getComputeExp());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCustomExportScopeDirty()) {
            hashMap.put(FIELD_CUSTOMEXPORTSCOPE, this.getCustomExportScope());
        }
        if (!bl || this.isDBValueModeDirty()) {
            hashMap.put(FIELD_DBVALUEMODE, this.getDBValueMode());
        }
        if (!bl || this.isDBValueMode2Dirty()) {
            hashMap.put(FIELD_DBVALUEMODE2, this.getDBValueMode2());
        }
        if (!bl || this.isDefaultValueDirty()) {
            hashMap.put(FIELD_DEFAULTVALUE, this.getDefaultValue());
        }
        if (!bl || this.isDEFTypeDirty()) {
            hashMap.put(FIELD_DEFTYPE, this.getDEFType());
        }
        if (!bl || this.isDERPSDEFIdDirty()) {
            hashMap.put(FIELD_DERPSDEFID, this.getDERPSDEFId());
        }
        if (!bl || this.isDERPSDEFNameDirty()) {
            hashMap.put(FIELD_DERPSDEFNAME, this.getDERPSDEFName());
        }
        if (!bl || this.isDupCheckModeDirty()) {
            hashMap.put(FIELD_DUPCHECKMODE, this.getDupCheckMode());
        }
        if (!bl || this.isDupCheckValuesDirty()) {
            hashMap.put(FIELD_DUPCHECKVALUES, this.getDupCheckValues());
        }
        if (!bl || this.isDupCheckPSDEFIdDirty()) {
            hashMap.put(FIELD_DUPCHECKPSDEFID, this.getDupCheckPSDEFId());
        }
        if (!bl || this.isDupCheckPSDEFNameDirty()) {
            hashMap.put(FIELD_DUPCHECKPSDEFNAME, this.getDupCheckPSDEFName());
        }
        if (!bl || this.isDefaultValueTypeDirty()) {
            hashMap.put(FIELD_DEFAULTVALUETYPE, this.getDefaultValueType());
        }
        if (!bl || this.isDynaModelFlagDirty()) {
            hashMap.put(FIELD_DYNAMODELFLAG, this.getDynaModelFlag());
        }
        if (!bl || this.isEnableAuditDirty()) {
            hashMap.put(FIELD_ENABLEAUDIT, this.getEnableAudit());
        }
        if (!bl || this.isEnableColPrivDirty()) {
            hashMap.put(FIELD_ENABLECOLPRIV, this.getEnableColPriv());
        }
        if (!bl || this.isEnableQSDirty()) {
            hashMap.put(FIELD_ENABLEQS, this.getEnableQS());
        }
        if (!bl || this.isEnableTempDataDirty()) {
            hashMap.put(FIELD_ENABLETEMPDATA, this.getEnableTempData());
        }
        if (!bl || this.isEnableUserInputDirty()) {
            hashMap.put(FIELD_ENABLEUSERINPUT, this.getEnableUserInput());
        }
        if (!bl || this.isEnaWriteBackDirty()) {
            hashMap.put(FIELD_ENAWRITEBACK, this.getEnaWriteBack());
        }
        if (!bl || this.isExportScopeDirty()) {
            hashMap.put(FIELD_EXPORTSCOPE, this.getExportScope());
        }
        if (!bl || this.isExpPSSysTranslatorIdDirty()) {
            hashMap.put(FIELD_EXPPSSYSTRANSLATORID, this.getExpPSSysTranslatorId());
        }
        if (!bl || this.isExpPSSysTranslatorNameDirty()) {
            hashMap.put(FIELD_EXPPSSYSTRANSLATORNAME, this.getExpPSSysTranslatorName());
        }
        if (!bl || this.isExtendModeDirty()) {
            hashMap.put(FIELD_EXTENDMODE, this.getExtendMode());
        }
        if (!bl || this.isFieldHolderDirty()) {
            hashMap.put(FIELD_FIELDHOLDER, this.getFieldHolder());
        }
        if (!bl || this.isFieldTagDirty()) {
            hashMap.put(FIELD_FIELDTAG, this.getFieldTag());
        }
        if (!bl || this.isFieldTag2Dirty()) {
            hashMap.put(FIELD_FIELDTAG2, this.getFieldTag2());
        }
        if (!bl || this.isFKeyDirty()) {
            hashMap.put(FIELD_FKEY, this.getFKey());
        }
        if (!bl || this.isFormulaFieldsDirty()) {
            hashMap.put(FIELD_FORMULAFIELDS, this.getFormulaFields());
        }
        if (!bl || this.isFormulaFormatDirty()) {
            hashMap.put(FIELD_FORMULAFORMAT, this.getFormulaFormat());
        }
        if (!bl || this.isImportKeyDirty()) {
            hashMap.put(FIELD_IMPORTKEY, this.getImportKey());
        }
        if (!bl || this.isImportOrderDirty()) {
            hashMap.put(FIELD_IMPORTORDER, this.getImportOrder());
        }
        if (!bl || this.isImportTagDirty()) {
            hashMap.put(FIELD_IMPORTTAG, this.getImportTag());
        }
        if (!bl || this.isImpPSSysTranslatorIdDirty()) {
            hashMap.put(FIELD_IMPPSSYSTRANSLATORID, this.getImpPSSysTranslatorId());
        }
        if (!bl || this.isImpPSSysTranslatorNameDirty()) {
            hashMap.put(FIELD_IMPPSSYSTRANSLATORNAME, this.getImpPSSysTranslatorName());
        }
        if (!bl || this.isIndexTypeDirty()) {
            hashMap.put(FIELD_INDEXTYPE, this.getIndexType());
        }
        if (!bl || this.isJSFormatDirty()) {
            hashMap.put(FIELD_JSFORMAT, this.getJSFormat());
        }
        if (!bl || this.isJsonFormatDirty()) {
            hashMap.put(FIELD_JSONFORMAT, this.getJsonFormat());
        }
        if (!bl || this.isLengthDirty()) {
            hashMap.put(FIELD_LENGTH, this.getLength());
        }
        if (!bl || this.isLNPSLanResIdDirty()) {
            hashMap.put(FIELD_LNPSLANRESID, this.getLNPSLanResId());
        }
        if (!bl || this.isLNPSLanResNameDirty()) {
            hashMap.put(FIELD_LNPSLANRESNAME, this.getLNPSLanResName());
        }
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
        }
        if (!bl || this.isLogicNameDirty()) {
            hashMap.put(FIELD_LOGICNAME, this.getLogicName());
        }
        if (!bl || this.isMajorFieldDirty()) {
            hashMap.put(FIELD_MAJORFIELD, this.getMajorField());
        }
        if (!bl || this.isMaxValueDirty()) {
            hashMap.put(FIELD_MAXVALUE, this.getMaxValue());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMinStrLengthDirty()) {
            hashMap.put(FIELD_MINSTRLENGTH, this.getMinStrLength());
        }
        if (!bl || this.isMinValueDirty()) {
            hashMap.put(FIELD_MINVALUE, this.getMinValue());
        }
        if (!bl || this.isMultiFormFieldDirty()) {
            hashMap.put(FIELD_MULTIFORMFIELD, this.getMultiFormField());
        }
        if (!bl || this.isNo2DupChkPSDEFIdDirty()) {
            hashMap.put(FIELD_NO2DUPCHKPSDEFID, this.getNo2DupChkPSDEFId());
        }
        if (!bl || this.isNo2DupChkPSDEFNameDirty()) {
            hashMap.put(FIELD_NO2DUPCHKPSDEFNAME, this.getNo2DupChkPSDEFName());
        }
        if (!bl || this.isNo3DupChkPSDEFIdDirty()) {
            hashMap.put(FIELD_NO3DUPCHKPSDEFID, this.getNo3DupChkPSDEFId());
        }
        if (!bl || this.isNo3DupChkPSDEFNameDirty()) {
            hashMap.put(FIELD_NO3DUPCHKPSDEFNAME, this.getNo3DupChkPSDEFName());
        }
        if (!bl || this.isNullValOrderDirty()) {
            hashMap.put(FIELD_NULLVALORDER, this.getNullValOrder());
        }
        if (!bl || this.isO2MPSDERIdDirty()) {
            hashMap.put(FIELD_O2MPSDERID, this.getO2MPSDERId());
        }
        if (!bl || this.isO2MPSDERNameDirty()) {
            hashMap.put(FIELD_O2MPSDERNAME, this.getO2MPSDERName());
        }
        if (!bl || this.isO2OPSDERIdDirty()) {
            hashMap.put(FIELD_O2OPSDERID, this.getO2OPSDERId());
        }
        if (!bl || this.isO2OPSDERNameDirty()) {
            hashMap.put(FIELD_O2OPSDERNAME, this.getO2OPSDERName());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPasteResetDirty()) {
            hashMap.put(FIELD_PASTERESET, this.getPasteReset());
        }
        if (!bl || this.isPhysicalFieldDirty()) {
            hashMap.put(FIELD_PHYSICALFIELD, this.getPhysicalField());
        }
        if (!bl || this.isPKeyDirty()) {
            hashMap.put(FIELD_PKEY, this.getPKey());
        }
        if (!bl || this.isPrecision2Dirty()) {
            hashMap.put(FIELD_PRECISION2, this.getPrecision2());
        }
        if (!bl || this.isPredefinedTypeParamDirty()) {
            hashMap.put(FIELD_PREDEFINEDTYPEPARAM, this.getPredefinedTypeParam());
        }
        if (!bl || this.isPreDefineTypeDirty()) {
            hashMap.put(FIELD_PREDEFINETYPE, this.getPreDefineType());
        }
        if (!bl || this.isPSCodeListIdDirty()) {
            hashMap.put(FIELD_PSCODELISTID, this.getPSCodeListId());
        }
        if (!bl || this.isPSCodeListNameDirty()) {
            hashMap.put(FIELD_PSCODELISTNAME, this.getPSCodeListName());
        }
        if (!bl || this.isPSDataTypeIdDirty()) {
            hashMap.put(FIELD_PSDATATYPEID, this.getPSDataTypeId());
        }
        if (!bl || this.isPSDataTypeNameDirty()) {
            hashMap.put(FIELD_PSDATATYPENAME, this.getPSDataTypeName());
        }
        if (!bl || this.isPSDEFDTColsCntDirty()) {
            hashMap.put(FIELD_PSDEFDTCOLSCNT, this.getPSDEFDTColsCnt());
        }
        if (!bl || this.isPSDEFieldIdDirty()) {
            hashMap.put(FIELD_PSDEFIELDID, this.getPSDEFieldId());
        }
        if (!bl || this.isPSDEFieldNameDirty()) {
            hashMap.put(FIELD_PSDEFIELDNAME, this.getPSDEFieldName());
        }
        if (!bl || this.isPSDEFieldsCntDirty()) {
            hashMap.put(FIELD_PSDEFIELDSCNT, this.getPSDEFieldsCnt());
        }
        if (!bl || this.isPSDEFInputTipsCntDirty()) {
            hashMap.put(FIELD_PSDEFINPUTTIPSCNT, this.getPSDEFInputTipsCnt());
        }
        if (!bl || this.isPSDEFSFItemsCntDirty()) {
            hashMap.put(FIELD_PSDEFSFITEMSCNT, this.getPSDEFSFItemsCnt());
        }
        if (!bl || this.isPSDEFUIModesCntDirty()) {
            hashMap.put(FIELD_PSDEFUIMODESCNT, this.getPSDEFUIModesCnt());
        }
        if (!bl || this.isPSDEFValueRulesCntDirty()) {
            hashMap.put(FIELD_PSDEFVALUERULESCNT, this.getPSDEFValueRulesCnt());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSDERIdDirty()) {
            hashMap.put(FIELD_PSDERID, this.getPSDERId());
        }
        if (!bl || this.isPSDERNameDirty()) {
            hashMap.put(FIELD_PSDERNAME, this.getPSDERName());
        }
        if (!bl || this.isPSDETableIdDirty()) {
            hashMap.put(FIELD_PSDETABLEID, this.getPSDETableId());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSSubSysSADEFieldIdDirty()) {
            hashMap.put(FIELD_PSSUBSYSSADEFIELDID, this.getPSSubSysSADEFieldId());
        }
        if (!bl || this.isPSSubSysSADEFieldNameDirty()) {
            hashMap.put(FIELD_PSSUBSYSSADEFIELDNAME, this.getPSSubSysSADEFieldName());
        }
        if (!bl || this.isPSSubSysSADEIdDirty()) {
            hashMap.put(FIELD_PSSUBSYSSADEID, this.getPSSubSysSADEId());
        }
        if (!bl || this.isPSSysDBColumnIdDirty()) {
            hashMap.put(FIELD_PSSYSDBCOLUMNID, this.getPSSysDBColumnId());
        }
        if (!bl || this.isPSSysSampleValueIdDirty()) {
            hashMap.put(FIELD_PSSYSSAMPLEVALUEID, this.getPSSysSampleValueId());
        }
        if (!bl || this.isPSSysSampleValueNameDirty()) {
            hashMap.put(FIELD_PSSYSSAMPLEVALUENAME, this.getPSSysSampleValueName());
        }
        if (!bl || this.isPSSysSequenceIdDirty()) {
            hashMap.put(FIELD_PSSYSSEQUENCEID, this.getPSSysSequenceId());
        }
        if (!bl || this.isPSSysSequenceNameDirty()) {
            hashMap.put(FIELD_PSSYSSEQUENCENAME, this.getPSSysSequenceName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSysTestCasesCntDirty()) {
            hashMap.put(FIELD_PSSYSTESTCASESCNT, this.getPSSysTestCasesCnt());
        }
        if (!bl || this.isPSSysTranslatorIdDirty()) {
            hashMap.put(FIELD_PSSYSTRANSLATORID, this.getPSSysTranslatorId());
        }
        if (!bl || this.isPSSysTranslatorNameDirty()) {
            hashMap.put(FIELD_PSSYSTRANSLATORNAME, this.getPSSysTranslatorName());
        }
        if (!bl || this.isPSSysUnitIdDirty()) {
            hashMap.put(FIELD_PSSYSUNITID, this.getPSSysUnitId());
        }
        if (!bl || this.isPSSysUnitNameDirty()) {
            hashMap.put(FIELD_PSSYSUNITNAME, this.getPSSysUnitName());
        }
        if (!bl || this.isPSSysValueRuleIdDirty()) {
            hashMap.put(FIELD_PSSYSVALUERULEID, this.getPSSysValueRuleId());
        }
        if (!bl || this.isPSSysValueRuleNameDirty()) {
            hashMap.put(FIELD_PSSYSVALUERULENAME, this.getPSSysValueRuleName());
        }
        if (!bl || this.isQueryColumnDirty()) {
            hashMap.put(FIELD_QUERYCOLUMN, this.getQueryColumn());
        }
        if (!bl || this.isQueryCSDirty()) {
            hashMap.put(FIELD_QUERYCS, this.getQueryCS());
        }
        if (!bl || this.isReadOnlyModeDirty()) {
            hashMap.put(FIELD_READONLYMODE, this.getReadOnlyMode());
        }
        if (!bl || this.isRefPSSysDynaModelIdDirty()) {
            hashMap.put(FIELD_REFPSSYSDYNAMODELID, this.getRefPSSysDynaModelId());
        }
        if (!bl || this.isRefPSSysDynaModelNameDirty()) {
            hashMap.put(FIELD_REFPSSYSDYNAMODELNAME, this.getRefPSSysDynaModelName());
        }
        if (!bl || this.isRestrictedPSDEFIdDirty()) {
            hashMap.put(FIELD_RESTRICTEDPSDEFID, this.getRestrictedPSDEFId());
        }
        if (!bl || this.isRestrictedPSDEFNameDirty()) {
            hashMap.put(FIELD_RESTRICTEDPSDEFNAME, this.getRestrictedPSDEFName());
        }
        if (!bl || this.isSequenceModeDirty()) {
            hashMap.put(FIELD_SEQUENCEMODE, this.getSequenceMode());
        }
        if (!bl || this.isServiceCodeNameDirty()) {
            hashMap.put(FIELD_SERVICECODENAME, this.getServiceCodeName());
        }
        if (!bl || this.isStateFieldDirty()) {
            hashMap.put(FIELD_STATEFIELD, this.getStateField());
        }
        if (!bl || this.isStdDataTypeDirty()) {
            hashMap.put(FIELD_STDDATATYPE, this.getStdDataType());
        }
        if (!bl || this.isStringCaseDirty()) {
            hashMap.put(FIELD_STRINGCASE, this.getStringCase());
        }
        if (!bl || this.isStrLengthDirty()) {
            hashMap.put(FIELD_STRLENGTH, this.getStrLength());
        }
        if (!bl || this.isTableNameDirty()) {
            hashMap.put(FIELD_TABLENAME, this.getTableName());
        }
        if (!bl || this.isTableScopeDirty()) {
            hashMap.put(FIELD_TABLESCOPE, this.getTableScope());
        }
        if (!bl || this.isTestDataDirty()) {
            hashMap.put(FIELD_TESTDATA, this.getTestData());
        }
        if (!bl || this.isTranslatorModeDirty()) {
            hashMap.put(FIELD_TRANSLATORMODE, this.getTranslatorMode());
        }
        if (!bl || this.isUnicodeCharDirty()) {
            hashMap.put(FIELD_UNICODECHAR, this.getUnicodeChar());
        }
        if (!bl || this.isUnionKeyValueDirty()) {
            hashMap.put(FIELD_UNIONKEYVALUE, this.getUnionKeyValue());
        }
        if (!bl || this.isUnitDirty()) {
            hashMap.put(FIELD_UNIT, this.getUnit());
        }
        if (!bl || this.isUnitWidthDirty()) {
            hashMap.put(FIELD_UNITWIDTH, this.getUnitWidth());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUpdateOVModeDirty()) {
            hashMap.put(FIELD_UPDATEOVMODE, this.getUpdateOVMode());
        }
        if (!bl || this.isUserCatDirty()) {
            hashMap.put(FIELD_USERCAT, this.getUserCat());
        }
        if (!bl || this.isUserParamsDirty()) {
            hashMap.put(FIELD_USERPARAMS, this.getUserParams());
        }
        if (!bl || this.isUserTagDirty()) {
            hashMap.put(FIELD_USERTAG, this.getUserTag());
        }
        if (!bl || this.isUserTag2Dirty()) {
            hashMap.put(FIELD_USERTAG2, this.getUserTag2());
        }
        if (!bl || this.isUserTag3Dirty()) {
            hashMap.put(FIELD_USERTAG3, this.getUserTag3());
        }
        if (!bl || this.isUserTag4Dirty()) {
            hashMap.put(FIELD_USERTAG4, this.getUserTag4());
        }
        if (!bl || this.isValidFlagDirty()) {
            hashMap.put(FIELD_VALIDFLAG, this.getValidFlag());
        }
        if (!bl || this.isValueFormatDirty()) {
            hashMap.put(FIELD_VALUEFORMAT, this.getValueFormat());
        }
        if (!bl || this.isValuePSDEFIdDirty()) {
            hashMap.put(FIELD_VALUEPSDEFID, this.getValuePSDEFId());
        }
        if (!bl || this.isValuePSDEFNameDirty()) {
            hashMap.put(FIELD_VALUEPSDEFNAME, this.getValuePSDEFName());
        }
        if (!bl || this.isViewColLevelDirty()) {
            hashMap.put(FIELD_VIEWCOLLEVEL, this.getViewColLevel());
        }
        super.onFillMap(hashMap, bl);
    }

    public Object get(String string) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().get(string);
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer n = fieldIndexMap.get(string.toUpperCase());
        if (n == null) {
            return super.get(string);
        }
        return PSDEFieldBase.get(this, n);
    }

    private static Object get(PSDEFieldBase pSDEFieldBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFieldBase.getAllowEmpty();
            }
            case 1: {
                return pSDEFieldBase.getAuditInfoFormat();
            }
            case 2: {
                return pSDEFieldBase.getBizTag();
            }
            case 3: {
                return pSDEFieldBase.getCheckRecursion();
            }
            case 4: {
                return pSDEFieldBase.getCodeName();
            }
            case 5: {
                return pSDEFieldBase.getComputeExp();
            }
            case 6: {
                return pSDEFieldBase.getCreateDate();
            }
            case 7: {
                return pSDEFieldBase.getCreateMan();
            }
            case 8: {
                return pSDEFieldBase.getCustomExportScope();
            }
            case 9: {
                return pSDEFieldBase.getDBValueMode();
            }
            case 10: {
                return pSDEFieldBase.getDBValueMode2();
            }
            case 11: {
                return pSDEFieldBase.getDefaultValue();
            }
            case 12: {
                return pSDEFieldBase.getDEFType();
            }
            case 13: {
                return pSDEFieldBase.getDERPSDEFId();
            }
            case 14: {
                return pSDEFieldBase.getDERPSDEFName();
            }
            case 15: {
                return pSDEFieldBase.getDupCheckMode();
            }
            case 16: {
                return pSDEFieldBase.getDupCheckValues();
            }
            case 17: {
                return pSDEFieldBase.getDupCheckPSDEFId();
            }
            case 18: {
                return pSDEFieldBase.getDupCheckPSDEFName();
            }
            case 19: {
                return pSDEFieldBase.getDefaultValueType();
            }
            case 20: {
                return pSDEFieldBase.getDynaModelFlag();
            }
            case 21: {
                return pSDEFieldBase.getEnableAudit();
            }
            case 22: {
                return pSDEFieldBase.getEnableColPriv();
            }
            case 23: {
                return pSDEFieldBase.getEnableQS();
            }
            case 24: {
                return pSDEFieldBase.getEnableTempData();
            }
            case 25: {
                return pSDEFieldBase.getEnableUserInput();
            }
            case 26: {
                return pSDEFieldBase.getEnaWriteBack();
            }
            case 27: {
                return pSDEFieldBase.getExportScope();
            }
            case 28: {
                return pSDEFieldBase.getExpPSSysTranslatorId();
            }
            case 29: {
                return pSDEFieldBase.getExpPSSysTranslatorName();
            }
            case 30: {
                return pSDEFieldBase.getExtendMode();
            }
            case 31: {
                return pSDEFieldBase.getFieldHolder();
            }
            case 32: {
                return pSDEFieldBase.getFieldTag();
            }
            case 33: {
                return pSDEFieldBase.getFieldTag2();
            }
            case 34: {
                return pSDEFieldBase.getFKey();
            }
            case 35: {
                return pSDEFieldBase.getFormulaFields();
            }
            case 36: {
                return pSDEFieldBase.getFormulaFormat();
            }
            case 37: {
                return pSDEFieldBase.getImportKey();
            }
            case 38: {
                return pSDEFieldBase.getImportOrder();
            }
            case 39: {
                return pSDEFieldBase.getImportTag();
            }
            case 40: {
                return pSDEFieldBase.getImpPSSysTranslatorId();
            }
            case 41: {
                return pSDEFieldBase.getImpPSSysTranslatorName();
            }
            case 42: {
                return pSDEFieldBase.getIndexType();
            }
            case 43: {
                return pSDEFieldBase.getJSFormat();
            }
            case 44: {
                return pSDEFieldBase.getJsonFormat();
            }
            case 45: {
                return pSDEFieldBase.getLength();
            }
            case 46: {
                return pSDEFieldBase.getLNPSLanResId();
            }
            case 47: {
                return pSDEFieldBase.getLNPSLanResName();
            }
            case 48: {
                return pSDEFieldBase.getLockFlag();
            }
            case 49: {
                return pSDEFieldBase.getLogicName();
            }
            case 50: {
                return pSDEFieldBase.getMajorField();
            }
            case 51: {
                return pSDEFieldBase.getMaxValue();
            }
            case 52: {
                return pSDEFieldBase.getMemo();
            }
            case 53: {
                return pSDEFieldBase.getMinStrLength();
            }
            case 54: {
                return pSDEFieldBase.getMinValue();
            }
            case 55: {
                return pSDEFieldBase.getMultiFormField();
            }
            case 56: {
                return pSDEFieldBase.getNo2DupChkPSDEFId();
            }
            case 57: {
                return pSDEFieldBase.getNo2DupChkPSDEFName();
            }
            case 58: {
                return pSDEFieldBase.getNo3DupChkPSDEFId();
            }
            case 59: {
                return pSDEFieldBase.getNo3DupChkPSDEFName();
            }
            case 60: {
                return pSDEFieldBase.getNullValOrder();
            }
            case 61: {
                return pSDEFieldBase.getO2MPSDERId();
            }
            case 62: {
                return pSDEFieldBase.getO2MPSDERName();
            }
            case 63: {
                return pSDEFieldBase.getO2OPSDERId();
            }
            case 64: {
                return pSDEFieldBase.getO2OPSDERName();
            }
            case 65: {
                return pSDEFieldBase.getOrderValue();
            }
            case 66: {
                return pSDEFieldBase.getPasteReset();
            }
            case 67: {
                return pSDEFieldBase.getPhysicalField();
            }
            case 68: {
                return pSDEFieldBase.getPKey();
            }
            case 69: {
                return pSDEFieldBase.getPrecision2();
            }
            case 70: {
                return pSDEFieldBase.getPredefinedTypeParam();
            }
            case 71: {
                return pSDEFieldBase.getPreDefineType();
            }
            case 72: {
                return pSDEFieldBase.getPSCodeListId();
            }
            case 73: {
                return pSDEFieldBase.getPSCodeListName();
            }
            case 74: {
                return pSDEFieldBase.getPSDataTypeId();
            }
            case 75: {
                return pSDEFieldBase.getPSDataTypeName();
            }
            case 76: {
                return pSDEFieldBase.getPSDEFDTColsCnt();
            }
            case 77: {
                return pSDEFieldBase.getPSDEFieldId();
            }
            case 78: {
                return pSDEFieldBase.getPSDEFieldName();
            }
            case 79: {
                return pSDEFieldBase.getPSDEFieldsCnt();
            }
            case 80: {
                return pSDEFieldBase.getPSDEFInputTipsCnt();
            }
            case 81: {
                return pSDEFieldBase.getPSDEFSFItemsCnt();
            }
            case 82: {
                return pSDEFieldBase.getPSDEFUIModesCnt();
            }
            case 83: {
                return pSDEFieldBase.getPSDEFValueRulesCnt();
            }
            case 84: {
                return pSDEFieldBase.getPSDEId();
            }
            case 85: {
                return pSDEFieldBase.getPSDEName();
            }
            case 86: {
                return pSDEFieldBase.getPSDERId();
            }
            case 87: {
                return pSDEFieldBase.getPSDERName();
            }
            case 88: {
                return pSDEFieldBase.getPSDETableId();
            }
            case 89: {
                return pSDEFieldBase.getPSDynaInstId();
            }
            case 90: {
                return pSDEFieldBase.getPSSubSysSADEFieldId();
            }
            case 91: {
                return pSDEFieldBase.getPSSubSysSADEFieldName();
            }
            case 92: {
                return pSDEFieldBase.getPSSubSysSADEId();
            }
            case 93: {
                return pSDEFieldBase.getPSSysDBColumnId();
            }
            case 94: {
                return pSDEFieldBase.getPSSysSampleValueId();
            }
            case 95: {
                return pSDEFieldBase.getPSSysSampleValueName();
            }
            case 96: {
                return pSDEFieldBase.getPSSysSequenceId();
            }
            case 97: {
                return pSDEFieldBase.getPSSysSequenceName();
            }
            case 98: {
                return pSDEFieldBase.getPSSystemId();
            }
            case 99: {
                return pSDEFieldBase.getPSSysTestCasesCnt();
            }
            case 100: {
                return pSDEFieldBase.getPSSysTranslatorId();
            }
            case 101: {
                return pSDEFieldBase.getPSSysTranslatorName();
            }
            case 102: {
                return pSDEFieldBase.getPSSysUnitId();
            }
            case 103: {
                return pSDEFieldBase.getPSSysUnitName();
            }
            case 104: {
                return pSDEFieldBase.getPSSysValueRuleId();
            }
            case 105: {
                return pSDEFieldBase.getPSSysValueRuleName();
            }
            case 106: {
                return pSDEFieldBase.getQueryColumn();
            }
            case 107: {
                return pSDEFieldBase.getQueryCS();
            }
            case 108: {
                return pSDEFieldBase.getReadOnlyMode();
            }
            case 109: {
                return pSDEFieldBase.getRefPSSysDynaModelId();
            }
            case 110: {
                return pSDEFieldBase.getRefPSSysDynaModelName();
            }
            case 111: {
                return pSDEFieldBase.getRestrictedPSDEFId();
            }
            case 112: {
                return pSDEFieldBase.getRestrictedPSDEFName();
            }
            case 113: {
                return pSDEFieldBase.getSequenceMode();
            }
            case 114: {
                return pSDEFieldBase.getServiceCodeName();
            }
            case 115: {
                return pSDEFieldBase.getStateField();
            }
            case 116: {
                return pSDEFieldBase.getStdDataType();
            }
            case 117: {
                return pSDEFieldBase.getStringCase();
            }
            case 118: {
                return pSDEFieldBase.getStrLength();
            }
            case 119: {
                return pSDEFieldBase.getTableName();
            }
            case 120: {
                return pSDEFieldBase.getTableScope();
            }
            case 121: {
                return pSDEFieldBase.getTestData();
            }
            case 122: {
                return pSDEFieldBase.getTranslatorMode();
            }
            case 123: {
                return pSDEFieldBase.getUnicodeChar();
            }
            case 124: {
                return pSDEFieldBase.getUnionKeyValue();
            }
            case 125: {
                return pSDEFieldBase.getUnit();
            }
            case 126: {
                return pSDEFieldBase.getUnitWidth();
            }
            case 127: {
                return pSDEFieldBase.getUpdateDate();
            }
            case 128: {
                return pSDEFieldBase.getUpdateMan();
            }
            case 129: {
                return pSDEFieldBase.getUpdateOVMode();
            }
            case 130: {
                return pSDEFieldBase.getUserCat();
            }
            case 131: {
                return pSDEFieldBase.getUserParams();
            }
            case 132: {
                return pSDEFieldBase.getUserTag();
            }
            case 133: {
                return pSDEFieldBase.getUserTag2();
            }
            case 134: {
                return pSDEFieldBase.getUserTag3();
            }
            case 135: {
                return pSDEFieldBase.getUserTag4();
            }
            case 136: {
                return pSDEFieldBase.getValidFlag();
            }
            case 137: {
                return pSDEFieldBase.getValueFormat();
            }
            case 138: {
                return pSDEFieldBase.getValuePSDEFId();
            }
            case 139: {
                return pSDEFieldBase.getValuePSDEFName();
            }
            case 140: {
                return pSDEFieldBase.getViewColLevel();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    public void set(String string, Object object) throws Exception {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().set(string, object);
            return;
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer n = fieldIndexMap.get(string.toUpperCase());
        if (n == null) {
            super.set(string, object);
            return;
        }
        PSDEFieldBase.set(this, n, object);
    }

    private static void set(PSDEFieldBase pSDEFieldBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEFieldBase.setAllowEmpty(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSDEFieldBase.setAuditInfoFormat(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEFieldBase.setBizTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEFieldBase.setCheckRecursion(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSDEFieldBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEFieldBase.setComputeExp(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEFieldBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSDEFieldBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEFieldBase.setCustomExportScope(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSDEFieldBase.setDBValueMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEFieldBase.setDBValueMode2(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEFieldBase.setDefaultValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEFieldBase.setDEFType(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSDEFieldBase.setDERPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEFieldBase.setDERPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEFieldBase.setDupCheckMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEFieldBase.setDupCheckValues(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEFieldBase.setDupCheckPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEFieldBase.setDupCheckPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEFieldBase.setDefaultValueType(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDEFieldBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 21: {
                pSDEFieldBase.setEnableAudit(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 22: {
                pSDEFieldBase.setEnableColPriv(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 23: {
                pSDEFieldBase.setEnableQS(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 24: {
                pSDEFieldBase.setEnableTempData(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 25: {
                pSDEFieldBase.setEnableUserInput(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 26: {
                pSDEFieldBase.setEnaWriteBack(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 27: {
                pSDEFieldBase.setExportScope(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 28: {
                pSDEFieldBase.setExpPSSysTranslatorId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDEFieldBase.setExpPSSysTranslatorName(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDEFieldBase.setExtendMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 31: {
                pSDEFieldBase.setFieldHolder(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 32: {
                pSDEFieldBase.setFieldTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDEFieldBase.setFieldTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDEFieldBase.setFKey(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 35: {
                pSDEFieldBase.setFormulaFields(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDEFieldBase.setFormulaFormat(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSDEFieldBase.setImportKey(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 38: {
                pSDEFieldBase.setImportOrder(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 39: {
                pSDEFieldBase.setImportTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSDEFieldBase.setImpPSSysTranslatorId(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSDEFieldBase.setImpPSSysTranslatorName(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSDEFieldBase.setIndexType(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 43: {
                pSDEFieldBase.setJSFormat(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSDEFieldBase.setJsonFormat(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSDEFieldBase.setLength(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 46: {
                pSDEFieldBase.setLNPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSDEFieldBase.setLNPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSDEFieldBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 49: {
                pSDEFieldBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSDEFieldBase.setMajorField(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 51: {
                pSDEFieldBase.setMaxValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSDEFieldBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 53: {
                pSDEFieldBase.setMinStrLength(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 54: {
                pSDEFieldBase.setMinValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 55: {
                pSDEFieldBase.setMultiFormField(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 56: {
                pSDEFieldBase.setNo2DupChkPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 57: {
                pSDEFieldBase.setNo2DupChkPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 58: {
                pSDEFieldBase.setNo3DupChkPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 59: {
                pSDEFieldBase.setNo3DupChkPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 60: {
                pSDEFieldBase.setNullValOrder(DataObject.getStringValue((Object)object));
                return;
            }
            case 61: {
                pSDEFieldBase.setO2MPSDERId(DataObject.getStringValue((Object)object));
                return;
            }
            case 62: {
                pSDEFieldBase.setO2MPSDERName(DataObject.getStringValue((Object)object));
                return;
            }
            case 63: {
                pSDEFieldBase.setO2OPSDERId(DataObject.getStringValue((Object)object));
                return;
            }
            case 64: {
                pSDEFieldBase.setO2OPSDERName(DataObject.getStringValue((Object)object));
                return;
            }
            case 65: {
                pSDEFieldBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 66: {
                pSDEFieldBase.setPasteReset(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 67: {
                pSDEFieldBase.setPhysicalField(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 68: {
                pSDEFieldBase.setPKey(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 69: {
                pSDEFieldBase.setPrecision2(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 70: {
                pSDEFieldBase.setPredefinedTypeParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 71: {
                pSDEFieldBase.setPreDefineType(DataObject.getStringValue((Object)object));
                return;
            }
            case 72: {
                pSDEFieldBase.setPSCodeListId(DataObject.getStringValue((Object)object));
                return;
            }
            case 73: {
                pSDEFieldBase.setPSCodeListName(DataObject.getStringValue((Object)object));
                return;
            }
            case 74: {
                pSDEFieldBase.setPSDataTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 75: {
                pSDEFieldBase.setPSDataTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 76: {
                pSDEFieldBase.setPSDEFDTColsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 77: {
                pSDEFieldBase.setPSDEFieldId(DataObject.getStringValue((Object)object));
                return;
            }
            case 78: {
                pSDEFieldBase.setPSDEFieldName(DataObject.getStringValue((Object)object));
                return;
            }
            case 79: {
                pSDEFieldBase.setPSDEFieldsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 80: {
                pSDEFieldBase.setPSDEFInputTipsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 81: {
                pSDEFieldBase.setPSDEFSFItemsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 82: {
                pSDEFieldBase.setPSDEFUIModesCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 83: {
                pSDEFieldBase.setPSDEFValueRulesCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 84: {
                pSDEFieldBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 85: {
                pSDEFieldBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 86: {
                pSDEFieldBase.setPSDERId(DataObject.getStringValue((Object)object));
                return;
            }
            case 87: {
                pSDEFieldBase.setPSDERName(DataObject.getStringValue((Object)object));
                return;
            }
            case 88: {
                pSDEFieldBase.setPSDETableId(DataObject.getStringValue((Object)object));
                return;
            }
            case 89: {
                pSDEFieldBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 90: {
                pSDEFieldBase.setPSSubSysSADEFieldId(DataObject.getStringValue((Object)object));
                return;
            }
            case 91: {
                pSDEFieldBase.setPSSubSysSADEFieldName(DataObject.getStringValue((Object)object));
                return;
            }
            case 92: {
                pSDEFieldBase.setPSSubSysSADEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 93: {
                pSDEFieldBase.setPSSysDBColumnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 94: {
                pSDEFieldBase.setPSSysSampleValueId(DataObject.getStringValue((Object)object));
                return;
            }
            case 95: {
                pSDEFieldBase.setPSSysSampleValueName(DataObject.getStringValue((Object)object));
                return;
            }
            case 96: {
                pSDEFieldBase.setPSSysSequenceId(DataObject.getStringValue((Object)object));
                return;
            }
            case 97: {
                pSDEFieldBase.setPSSysSequenceName(DataObject.getStringValue((Object)object));
                return;
            }
            case 98: {
                pSDEFieldBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 99: {
                pSDEFieldBase.setPSSysTestCasesCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 100: {
                pSDEFieldBase.setPSSysTranslatorId(DataObject.getStringValue((Object)object));
                return;
            }
            case 101: {
                pSDEFieldBase.setPSSysTranslatorName(DataObject.getStringValue((Object)object));
                return;
            }
            case 102: {
                pSDEFieldBase.setPSSysUnitId(DataObject.getStringValue((Object)object));
                return;
            }
            case 103: {
                pSDEFieldBase.setPSSysUnitName(DataObject.getStringValue((Object)object));
                return;
            }
            case 104: {
                pSDEFieldBase.setPSSysValueRuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 105: {
                pSDEFieldBase.setPSSysValueRuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 106: {
                pSDEFieldBase.setQueryColumn(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 107: {
                pSDEFieldBase.setQueryCS(DataObject.getStringValue((Object)object));
                return;
            }
            case 108: {
                pSDEFieldBase.setReadOnlyMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 109: {
                pSDEFieldBase.setRefPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 110: {
                pSDEFieldBase.setRefPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 111: {
                pSDEFieldBase.setRestrictedPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 112: {
                pSDEFieldBase.setRestrictedPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 113: {
                pSDEFieldBase.setSequenceMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 114: {
                pSDEFieldBase.setServiceCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 115: {
                pSDEFieldBase.setStateField(DataObject.getStringValue((Object)object));
                return;
            }
            case 116: {
                pSDEFieldBase.setStdDataType(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 117: {
                pSDEFieldBase.setStringCase(DataObject.getStringValue((Object)object));
                return;
            }
            case 118: {
                pSDEFieldBase.setStrLength(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 119: {
                pSDEFieldBase.setTableName(DataObject.getStringValue((Object)object));
                return;
            }
            case 120: {
                pSDEFieldBase.setTableScope(DataObject.getStringValue((Object)object));
                return;
            }
            case 121: {
                pSDEFieldBase.setTestData(DataObject.getStringValue((Object)object));
                return;
            }
            case 122: {
                pSDEFieldBase.setTranslatorMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 123: {
                pSDEFieldBase.setUnicodeChar(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 124: {
                pSDEFieldBase.setUnionKeyValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 125: {
                pSDEFieldBase.setUnit(DataObject.getStringValue((Object)object));
                return;
            }
            case 126: {
                pSDEFieldBase.setUnitWidth(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 127: {
                pSDEFieldBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 128: {
                pSDEFieldBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 129: {
                pSDEFieldBase.setUpdateOVMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 130: {
                pSDEFieldBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 131: {
                pSDEFieldBase.setUserParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 132: {
                pSDEFieldBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 133: {
                pSDEFieldBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 134: {
                pSDEFieldBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 135: {
                pSDEFieldBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 136: {
                pSDEFieldBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 137: {
                pSDEFieldBase.setValueFormat(DataObject.getStringValue((Object)object));
                return;
            }
            case 138: {
                pSDEFieldBase.setValuePSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 139: {
                pSDEFieldBase.setValuePSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 140: {
                pSDEFieldBase.setViewColLevel(DataObject.getIntegerValue((Object)object));
                return;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    public boolean isNull(String string) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNull(string);
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer n = fieldIndexMap.get(string.toUpperCase());
        if (n == null) {
            return super.isNull(string);
        }
        return PSDEFieldBase.isNull(this, n);
    }

    private static boolean isNull(PSDEFieldBase pSDEFieldBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFieldBase.getAllowEmpty() == null;
            }
            case 1: {
                return pSDEFieldBase.getAuditInfoFormat() == null;
            }
            case 2: {
                return pSDEFieldBase.getBizTag() == null;
            }
            case 3: {
                return pSDEFieldBase.getCheckRecursion() == null;
            }
            case 4: {
                return pSDEFieldBase.getCodeName() == null;
            }
            case 5: {
                return pSDEFieldBase.getComputeExp() == null;
            }
            case 6: {
                return pSDEFieldBase.getCreateDate() == null;
            }
            case 7: {
                return pSDEFieldBase.getCreateMan() == null;
            }
            case 8: {
                return pSDEFieldBase.getCustomExportScope() == null;
            }
            case 9: {
                return pSDEFieldBase.getDBValueMode() == null;
            }
            case 10: {
                return pSDEFieldBase.getDBValueMode2() == null;
            }
            case 11: {
                return pSDEFieldBase.getDefaultValue() == null;
            }
            case 12: {
                return pSDEFieldBase.getDEFType() == null;
            }
            case 13: {
                return pSDEFieldBase.getDERPSDEFId() == null;
            }
            case 14: {
                return pSDEFieldBase.getDERPSDEFName() == null;
            }
            case 15: {
                return pSDEFieldBase.getDupCheckMode() == null;
            }
            case 16: {
                return pSDEFieldBase.getDupCheckValues() == null;
            }
            case 17: {
                return pSDEFieldBase.getDupCheckPSDEFId() == null;
            }
            case 18: {
                return pSDEFieldBase.getDupCheckPSDEFName() == null;
            }
            case 19: {
                return pSDEFieldBase.getDefaultValueType() == null;
            }
            case 20: {
                return pSDEFieldBase.getDynaModelFlag() == null;
            }
            case 21: {
                return pSDEFieldBase.getEnableAudit() == null;
            }
            case 22: {
                return pSDEFieldBase.getEnableColPriv() == null;
            }
            case 23: {
                return pSDEFieldBase.getEnableQS() == null;
            }
            case 24: {
                return pSDEFieldBase.getEnableTempData() == null;
            }
            case 25: {
                return pSDEFieldBase.getEnableUserInput() == null;
            }
            case 26: {
                return pSDEFieldBase.getEnaWriteBack() == null;
            }
            case 27: {
                return pSDEFieldBase.getExportScope() == null;
            }
            case 28: {
                return pSDEFieldBase.getExpPSSysTranslatorId() == null;
            }
            case 29: {
                return pSDEFieldBase.getExpPSSysTranslatorName() == null;
            }
            case 30: {
                return pSDEFieldBase.getExtendMode() == null;
            }
            case 31: {
                return pSDEFieldBase.getFieldHolder() == null;
            }
            case 32: {
                return pSDEFieldBase.getFieldTag() == null;
            }
            case 33: {
                return pSDEFieldBase.getFieldTag2() == null;
            }
            case 34: {
                return pSDEFieldBase.getFKey() == null;
            }
            case 35: {
                return pSDEFieldBase.getFormulaFields() == null;
            }
            case 36: {
                return pSDEFieldBase.getFormulaFormat() == null;
            }
            case 37: {
                return pSDEFieldBase.getImportKey() == null;
            }
            case 38: {
                return pSDEFieldBase.getImportOrder() == null;
            }
            case 39: {
                return pSDEFieldBase.getImportTag() == null;
            }
            case 40: {
                return pSDEFieldBase.getImpPSSysTranslatorId() == null;
            }
            case 41: {
                return pSDEFieldBase.getImpPSSysTranslatorName() == null;
            }
            case 42: {
                return pSDEFieldBase.getIndexType() == null;
            }
            case 43: {
                return pSDEFieldBase.getJSFormat() == null;
            }
            case 44: {
                return pSDEFieldBase.getJsonFormat() == null;
            }
            case 45: {
                return pSDEFieldBase.getLength() == null;
            }
            case 46: {
                return pSDEFieldBase.getLNPSLanResId() == null;
            }
            case 47: {
                return pSDEFieldBase.getLNPSLanResName() == null;
            }
            case 48: {
                return pSDEFieldBase.getLockFlag() == null;
            }
            case 49: {
                return pSDEFieldBase.getLogicName() == null;
            }
            case 50: {
                return pSDEFieldBase.getMajorField() == null;
            }
            case 51: {
                return pSDEFieldBase.getMaxValue() == null;
            }
            case 52: {
                return pSDEFieldBase.getMemo() == null;
            }
            case 53: {
                return pSDEFieldBase.getMinStrLength() == null;
            }
            case 54: {
                return pSDEFieldBase.getMinValue() == null;
            }
            case 55: {
                return pSDEFieldBase.getMultiFormField() == null;
            }
            case 56: {
                return pSDEFieldBase.getNo2DupChkPSDEFId() == null;
            }
            case 57: {
                return pSDEFieldBase.getNo2DupChkPSDEFName() == null;
            }
            case 58: {
                return pSDEFieldBase.getNo3DupChkPSDEFId() == null;
            }
            case 59: {
                return pSDEFieldBase.getNo3DupChkPSDEFName() == null;
            }
            case 60: {
                return pSDEFieldBase.getNullValOrder() == null;
            }
            case 61: {
                return pSDEFieldBase.getO2MPSDERId() == null;
            }
            case 62: {
                return pSDEFieldBase.getO2MPSDERName() == null;
            }
            case 63: {
                return pSDEFieldBase.getO2OPSDERId() == null;
            }
            case 64: {
                return pSDEFieldBase.getO2OPSDERName() == null;
            }
            case 65: {
                return pSDEFieldBase.getOrderValue() == null;
            }
            case 66: {
                return pSDEFieldBase.getPasteReset() == null;
            }
            case 67: {
                return pSDEFieldBase.getPhysicalField() == null;
            }
            case 68: {
                return pSDEFieldBase.getPKey() == null;
            }
            case 69: {
                return pSDEFieldBase.getPrecision2() == null;
            }
            case 70: {
                return pSDEFieldBase.getPredefinedTypeParam() == null;
            }
            case 71: {
                return pSDEFieldBase.getPreDefineType() == null;
            }
            case 72: {
                return pSDEFieldBase.getPSCodeListId() == null;
            }
            case 73: {
                return pSDEFieldBase.getPSCodeListName() == null;
            }
            case 74: {
                return pSDEFieldBase.getPSDataTypeId() == null;
            }
            case 75: {
                return pSDEFieldBase.getPSDataTypeName() == null;
            }
            case 76: {
                return pSDEFieldBase.getPSDEFDTColsCnt() == null;
            }
            case 77: {
                return pSDEFieldBase.getPSDEFieldId() == null;
            }
            case 78: {
                return pSDEFieldBase.getPSDEFieldName() == null;
            }
            case 79: {
                return pSDEFieldBase.getPSDEFieldsCnt() == null;
            }
            case 80: {
                return pSDEFieldBase.getPSDEFInputTipsCnt() == null;
            }
            case 81: {
                return pSDEFieldBase.getPSDEFSFItemsCnt() == null;
            }
            case 82: {
                return pSDEFieldBase.getPSDEFUIModesCnt() == null;
            }
            case 83: {
                return pSDEFieldBase.getPSDEFValueRulesCnt() == null;
            }
            case 84: {
                return pSDEFieldBase.getPSDEId() == null;
            }
            case 85: {
                return pSDEFieldBase.getPSDEName() == null;
            }
            case 86: {
                return pSDEFieldBase.getPSDERId() == null;
            }
            case 87: {
                return pSDEFieldBase.getPSDERName() == null;
            }
            case 88: {
                return pSDEFieldBase.getPSDETableId() == null;
            }
            case 89: {
                return pSDEFieldBase.getPSDynaInstId() == null;
            }
            case 90: {
                return pSDEFieldBase.getPSSubSysSADEFieldId() == null;
            }
            case 91: {
                return pSDEFieldBase.getPSSubSysSADEFieldName() == null;
            }
            case 92: {
                return pSDEFieldBase.getPSSubSysSADEId() == null;
            }
            case 93: {
                return pSDEFieldBase.getPSSysDBColumnId() == null;
            }
            case 94: {
                return pSDEFieldBase.getPSSysSampleValueId() == null;
            }
            case 95: {
                return pSDEFieldBase.getPSSysSampleValueName() == null;
            }
            case 96: {
                return pSDEFieldBase.getPSSysSequenceId() == null;
            }
            case 97: {
                return pSDEFieldBase.getPSSysSequenceName() == null;
            }
            case 98: {
                return pSDEFieldBase.getPSSystemId() == null;
            }
            case 99: {
                return pSDEFieldBase.getPSSysTestCasesCnt() == null;
            }
            case 100: {
                return pSDEFieldBase.getPSSysTranslatorId() == null;
            }
            case 101: {
                return pSDEFieldBase.getPSSysTranslatorName() == null;
            }
            case 102: {
                return pSDEFieldBase.getPSSysUnitId() == null;
            }
            case 103: {
                return pSDEFieldBase.getPSSysUnitName() == null;
            }
            case 104: {
                return pSDEFieldBase.getPSSysValueRuleId() == null;
            }
            case 105: {
                return pSDEFieldBase.getPSSysValueRuleName() == null;
            }
            case 106: {
                return pSDEFieldBase.getQueryColumn() == null;
            }
            case 107: {
                return pSDEFieldBase.getQueryCS() == null;
            }
            case 108: {
                return pSDEFieldBase.getReadOnlyMode() == null;
            }
            case 109: {
                return pSDEFieldBase.getRefPSSysDynaModelId() == null;
            }
            case 110: {
                return pSDEFieldBase.getRefPSSysDynaModelName() == null;
            }
            case 111: {
                return pSDEFieldBase.getRestrictedPSDEFId() == null;
            }
            case 112: {
                return pSDEFieldBase.getRestrictedPSDEFName() == null;
            }
            case 113: {
                return pSDEFieldBase.getSequenceMode() == null;
            }
            case 114: {
                return pSDEFieldBase.getServiceCodeName() == null;
            }
            case 115: {
                return pSDEFieldBase.getStateField() == null;
            }
            case 116: {
                return pSDEFieldBase.getStdDataType() == null;
            }
            case 117: {
                return pSDEFieldBase.getStringCase() == null;
            }
            case 118: {
                return pSDEFieldBase.getStrLength() == null;
            }
            case 119: {
                return pSDEFieldBase.getTableName() == null;
            }
            case 120: {
                return pSDEFieldBase.getTableScope() == null;
            }
            case 121: {
                return pSDEFieldBase.getTestData() == null;
            }
            case 122: {
                return pSDEFieldBase.getTranslatorMode() == null;
            }
            case 123: {
                return pSDEFieldBase.getUnicodeChar() == null;
            }
            case 124: {
                return pSDEFieldBase.getUnionKeyValue() == null;
            }
            case 125: {
                return pSDEFieldBase.getUnit() == null;
            }
            case 126: {
                return pSDEFieldBase.getUnitWidth() == null;
            }
            case 127: {
                return pSDEFieldBase.getUpdateDate() == null;
            }
            case 128: {
                return pSDEFieldBase.getUpdateMan() == null;
            }
            case 129: {
                return pSDEFieldBase.getUpdateOVMode() == null;
            }
            case 130: {
                return pSDEFieldBase.getUserCat() == null;
            }
            case 131: {
                return pSDEFieldBase.getUserParams() == null;
            }
            case 132: {
                return pSDEFieldBase.getUserTag() == null;
            }
            case 133: {
                return pSDEFieldBase.getUserTag2() == null;
            }
            case 134: {
                return pSDEFieldBase.getUserTag3() == null;
            }
            case 135: {
                return pSDEFieldBase.getUserTag4() == null;
            }
            case 136: {
                return pSDEFieldBase.getValidFlag() == null;
            }
            case 137: {
                return pSDEFieldBase.getValueFormat() == null;
            }
            case 138: {
                return pSDEFieldBase.getValuePSDEFId() == null;
            }
            case 139: {
                return pSDEFieldBase.getValuePSDEFName() == null;
            }
            case 140: {
                return pSDEFieldBase.getViewColLevel() == null;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    public boolean contains(String string) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().contains(string);
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer n = fieldIndexMap.get(string.toUpperCase());
        if (n == null) {
            return super.contains(string);
        }
        return PSDEFieldBase.contains(this, n);
    }

    private static boolean contains(PSDEFieldBase pSDEFieldBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFieldBase.isAllowEmptyDirty();
            }
            case 1: {
                return pSDEFieldBase.isAuditInfoFormatDirty();
            }
            case 2: {
                return pSDEFieldBase.isBizTagDirty();
            }
            case 3: {
                return pSDEFieldBase.isCheckRecursionDirty();
            }
            case 4: {
                return pSDEFieldBase.isCodeNameDirty();
            }
            case 5: {
                return pSDEFieldBase.isComputeExpDirty();
            }
            case 6: {
                return pSDEFieldBase.isCreateDateDirty();
            }
            case 7: {
                return pSDEFieldBase.isCreateManDirty();
            }
            case 8: {
                return pSDEFieldBase.isCustomExportScopeDirty();
            }
            case 9: {
                return pSDEFieldBase.isDBValueModeDirty();
            }
            case 10: {
                return pSDEFieldBase.isDBValueMode2Dirty();
            }
            case 11: {
                return pSDEFieldBase.isDefaultValueDirty();
            }
            case 12: {
                return pSDEFieldBase.isDEFTypeDirty();
            }
            case 13: {
                return pSDEFieldBase.isDERPSDEFIdDirty();
            }
            case 14: {
                return pSDEFieldBase.isDERPSDEFNameDirty();
            }
            case 15: {
                return pSDEFieldBase.isDupCheckModeDirty();
            }
            case 16: {
                return pSDEFieldBase.isDupCheckValuesDirty();
            }
            case 17: {
                return pSDEFieldBase.isDupCheckPSDEFIdDirty();
            }
            case 18: {
                return pSDEFieldBase.isDupCheckPSDEFNameDirty();
            }
            case 19: {
                return pSDEFieldBase.isDefaultValueTypeDirty();
            }
            case 20: {
                return pSDEFieldBase.isDynaModelFlagDirty();
            }
            case 21: {
                return pSDEFieldBase.isEnableAuditDirty();
            }
            case 22: {
                return pSDEFieldBase.isEnableColPrivDirty();
            }
            case 23: {
                return pSDEFieldBase.isEnableQSDirty();
            }
            case 24: {
                return pSDEFieldBase.isEnableTempDataDirty();
            }
            case 25: {
                return pSDEFieldBase.isEnableUserInputDirty();
            }
            case 26: {
                return pSDEFieldBase.isEnaWriteBackDirty();
            }
            case 27: {
                return pSDEFieldBase.isExportScopeDirty();
            }
            case 28: {
                return pSDEFieldBase.isExpPSSysTranslatorIdDirty();
            }
            case 29: {
                return pSDEFieldBase.isExpPSSysTranslatorNameDirty();
            }
            case 30: {
                return pSDEFieldBase.isExtendModeDirty();
            }
            case 31: {
                return pSDEFieldBase.isFieldHolderDirty();
            }
            case 32: {
                return pSDEFieldBase.isFieldTagDirty();
            }
            case 33: {
                return pSDEFieldBase.isFieldTag2Dirty();
            }
            case 34: {
                return pSDEFieldBase.isFKeyDirty();
            }
            case 35: {
                return pSDEFieldBase.isFormulaFieldsDirty();
            }
            case 36: {
                return pSDEFieldBase.isFormulaFormatDirty();
            }
            case 37: {
                return pSDEFieldBase.isImportKeyDirty();
            }
            case 38: {
                return pSDEFieldBase.isImportOrderDirty();
            }
            case 39: {
                return pSDEFieldBase.isImportTagDirty();
            }
            case 40: {
                return pSDEFieldBase.isImpPSSysTranslatorIdDirty();
            }
            case 41: {
                return pSDEFieldBase.isImpPSSysTranslatorNameDirty();
            }
            case 42: {
                return pSDEFieldBase.isIndexTypeDirty();
            }
            case 43: {
                return pSDEFieldBase.isJSFormatDirty();
            }
            case 44: {
                return pSDEFieldBase.isJsonFormatDirty();
            }
            case 45: {
                return pSDEFieldBase.isLengthDirty();
            }
            case 46: {
                return pSDEFieldBase.isLNPSLanResIdDirty();
            }
            case 47: {
                return pSDEFieldBase.isLNPSLanResNameDirty();
            }
            case 48: {
                return pSDEFieldBase.isLockFlagDirty();
            }
            case 49: {
                return pSDEFieldBase.isLogicNameDirty();
            }
            case 50: {
                return pSDEFieldBase.isMajorFieldDirty();
            }
            case 51: {
                return pSDEFieldBase.isMaxValueDirty();
            }
            case 52: {
                return pSDEFieldBase.isMemoDirty();
            }
            case 53: {
                return pSDEFieldBase.isMinStrLengthDirty();
            }
            case 54: {
                return pSDEFieldBase.isMinValueDirty();
            }
            case 55: {
                return pSDEFieldBase.isMultiFormFieldDirty();
            }
            case 56: {
                return pSDEFieldBase.isNo2DupChkPSDEFIdDirty();
            }
            case 57: {
                return pSDEFieldBase.isNo2DupChkPSDEFNameDirty();
            }
            case 58: {
                return pSDEFieldBase.isNo3DupChkPSDEFIdDirty();
            }
            case 59: {
                return pSDEFieldBase.isNo3DupChkPSDEFNameDirty();
            }
            case 60: {
                return pSDEFieldBase.isNullValOrderDirty();
            }
            case 61: {
                return pSDEFieldBase.isO2MPSDERIdDirty();
            }
            case 62: {
                return pSDEFieldBase.isO2MPSDERNameDirty();
            }
            case 63: {
                return pSDEFieldBase.isO2OPSDERIdDirty();
            }
            case 64: {
                return pSDEFieldBase.isO2OPSDERNameDirty();
            }
            case 65: {
                return pSDEFieldBase.isOrderValueDirty();
            }
            case 66: {
                return pSDEFieldBase.isPasteResetDirty();
            }
            case 67: {
                return pSDEFieldBase.isPhysicalFieldDirty();
            }
            case 68: {
                return pSDEFieldBase.isPKeyDirty();
            }
            case 69: {
                return pSDEFieldBase.isPrecision2Dirty();
            }
            case 70: {
                return pSDEFieldBase.isPredefinedTypeParamDirty();
            }
            case 71: {
                return pSDEFieldBase.isPreDefineTypeDirty();
            }
            case 72: {
                return pSDEFieldBase.isPSCodeListIdDirty();
            }
            case 73: {
                return pSDEFieldBase.isPSCodeListNameDirty();
            }
            case 74: {
                return pSDEFieldBase.isPSDataTypeIdDirty();
            }
            case 75: {
                return pSDEFieldBase.isPSDataTypeNameDirty();
            }
            case 76: {
                return pSDEFieldBase.isPSDEFDTColsCntDirty();
            }
            case 77: {
                return pSDEFieldBase.isPSDEFieldIdDirty();
            }
            case 78: {
                return pSDEFieldBase.isPSDEFieldNameDirty();
            }
            case 79: {
                return pSDEFieldBase.isPSDEFieldsCntDirty();
            }
            case 80: {
                return pSDEFieldBase.isPSDEFInputTipsCntDirty();
            }
            case 81: {
                return pSDEFieldBase.isPSDEFSFItemsCntDirty();
            }
            case 82: {
                return pSDEFieldBase.isPSDEFUIModesCntDirty();
            }
            case 83: {
                return pSDEFieldBase.isPSDEFValueRulesCntDirty();
            }
            case 84: {
                return pSDEFieldBase.isPSDEIdDirty();
            }
            case 85: {
                return pSDEFieldBase.isPSDENameDirty();
            }
            case 86: {
                return pSDEFieldBase.isPSDERIdDirty();
            }
            case 87: {
                return pSDEFieldBase.isPSDERNameDirty();
            }
            case 88: {
                return pSDEFieldBase.isPSDETableIdDirty();
            }
            case 89: {
                return pSDEFieldBase.isPSDynaInstIdDirty();
            }
            case 90: {
                return pSDEFieldBase.isPSSubSysSADEFieldIdDirty();
            }
            case 91: {
                return pSDEFieldBase.isPSSubSysSADEFieldNameDirty();
            }
            case 92: {
                return pSDEFieldBase.isPSSubSysSADEIdDirty();
            }
            case 93: {
                return pSDEFieldBase.isPSSysDBColumnIdDirty();
            }
            case 94: {
                return pSDEFieldBase.isPSSysSampleValueIdDirty();
            }
            case 95: {
                return pSDEFieldBase.isPSSysSampleValueNameDirty();
            }
            case 96: {
                return pSDEFieldBase.isPSSysSequenceIdDirty();
            }
            case 97: {
                return pSDEFieldBase.isPSSysSequenceNameDirty();
            }
            case 98: {
                return pSDEFieldBase.isPSSystemIdDirty();
            }
            case 99: {
                return pSDEFieldBase.isPSSysTestCasesCntDirty();
            }
            case 100: {
                return pSDEFieldBase.isPSSysTranslatorIdDirty();
            }
            case 101: {
                return pSDEFieldBase.isPSSysTranslatorNameDirty();
            }
            case 102: {
                return pSDEFieldBase.isPSSysUnitIdDirty();
            }
            case 103: {
                return pSDEFieldBase.isPSSysUnitNameDirty();
            }
            case 104: {
                return pSDEFieldBase.isPSSysValueRuleIdDirty();
            }
            case 105: {
                return pSDEFieldBase.isPSSysValueRuleNameDirty();
            }
            case 106: {
                return pSDEFieldBase.isQueryColumnDirty();
            }
            case 107: {
                return pSDEFieldBase.isQueryCSDirty();
            }
            case 108: {
                return pSDEFieldBase.isReadOnlyModeDirty();
            }
            case 109: {
                return pSDEFieldBase.isRefPSSysDynaModelIdDirty();
            }
            case 110: {
                return pSDEFieldBase.isRefPSSysDynaModelNameDirty();
            }
            case 111: {
                return pSDEFieldBase.isRestrictedPSDEFIdDirty();
            }
            case 112: {
                return pSDEFieldBase.isRestrictedPSDEFNameDirty();
            }
            case 113: {
                return pSDEFieldBase.isSequenceModeDirty();
            }
            case 114: {
                return pSDEFieldBase.isServiceCodeNameDirty();
            }
            case 115: {
                return pSDEFieldBase.isStateFieldDirty();
            }
            case 116: {
                return pSDEFieldBase.isStdDataTypeDirty();
            }
            case 117: {
                return pSDEFieldBase.isStringCaseDirty();
            }
            case 118: {
                return pSDEFieldBase.isStrLengthDirty();
            }
            case 119: {
                return pSDEFieldBase.isTableNameDirty();
            }
            case 120: {
                return pSDEFieldBase.isTableScopeDirty();
            }
            case 121: {
                return pSDEFieldBase.isTestDataDirty();
            }
            case 122: {
                return pSDEFieldBase.isTranslatorModeDirty();
            }
            case 123: {
                return pSDEFieldBase.isUnicodeCharDirty();
            }
            case 124: {
                return pSDEFieldBase.isUnionKeyValueDirty();
            }
            case 125: {
                return pSDEFieldBase.isUnitDirty();
            }
            case 126: {
                return pSDEFieldBase.isUnitWidthDirty();
            }
            case 127: {
                return pSDEFieldBase.isUpdateDateDirty();
            }
            case 128: {
                return pSDEFieldBase.isUpdateManDirty();
            }
            case 129: {
                return pSDEFieldBase.isUpdateOVModeDirty();
            }
            case 130: {
                return pSDEFieldBase.isUserCatDirty();
            }
            case 131: {
                return pSDEFieldBase.isUserParamsDirty();
            }
            case 132: {
                return pSDEFieldBase.isUserTagDirty();
            }
            case 133: {
                return pSDEFieldBase.isUserTag2Dirty();
            }
            case 134: {
                return pSDEFieldBase.isUserTag3Dirty();
            }
            case 135: {
                return pSDEFieldBase.isUserTag4Dirty();
            }
            case 136: {
                return pSDEFieldBase.isValidFlagDirty();
            }
            case 137: {
                return pSDEFieldBase.isValueFormatDirty();
            }
            case 138: {
                return pSDEFieldBase.isValuePSDEFIdDirty();
            }
            case 139: {
                return pSDEFieldBase.isValuePSDEFNameDirty();
            }
            case 140: {
                return pSDEFieldBase.isViewColLevelDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEFieldBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEFieldBase pSDEFieldBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEFieldBase.getAllowEmpty() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"allowempty", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getAllowEmpty()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getAuditInfoFormat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"auditinfoformat", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getAuditInfoFormat()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getBizTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"biztag", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getBizTag()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getCheckRecursion() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"checkrecursion", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getCheckRecursion()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getComputeExp() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"computeexp", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getComputeExp()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getCustomExportScope() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customexportscope", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getCustomExportScope()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getDBValueMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dbvaluemode", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getDBValueMode()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getDBValueMode2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dbvaluemode2", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getDBValueMode2()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getDefaultValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultvalue", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getDefaultValue()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getDEFType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"deftype", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getDEFType()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getDERPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"derpsdefid", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getDERPSDEFId()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getDERPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"derpsdefname", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getDERPSDEFName()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getDupCheckMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dupcheckmode", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getDupCheckMode()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getDupCheckValues() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dupcheckvalues", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getDupCheckValues()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getDupCheckPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dupchkpsdefid", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getDupCheckPSDEFId()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getDupCheckPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dupchkpsdefname", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getDupCheckPSDEFName()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getDefaultValueType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dvt", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getDefaultValueType()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getEnableAudit() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableaudit", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getEnableAudit()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getEnableColPriv() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablecolpriv", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getEnableColPriv()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getEnableQS() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableqs", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getEnableQS()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getEnableTempData() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enabletempdata", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getEnableTempData()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getEnableUserInput() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableuserinput", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getEnableUserInput()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getEnaWriteBack() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enawriteback", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getEnaWriteBack()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getExportScope() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"exportscope", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getExportScope()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getExpPSSysTranslatorId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"exppssystranslatorid", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getExpPSSysTranslatorId()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getExpPSSysTranslatorName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"exppssystranslatorname", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getExpPSSysTranslatorName()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getExtendMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"extendmode", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getExtendMode()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getFieldHolder() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fieldholder", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getFieldHolder()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getFieldTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fieldtag", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getFieldTag()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getFieldTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fieldtag2", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getFieldTag2()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getFKey() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fkey", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getFKey()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getFormulaFields() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"formulafields", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getFormulaFields()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getFormulaFormat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"formulaformat", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getFormulaFormat()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getImportKey() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"importkey", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getImportKey()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getImportOrder() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"importorder", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getImportOrder()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getImportTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"importtag", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getImportTag()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getImpPSSysTranslatorId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"imppssystranslatorid", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getImpPSSysTranslatorId()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getImpPSSysTranslatorName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"imppssystranslatorname", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getImpPSSysTranslatorName()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getIndexType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"indextype", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getIndexType()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getJSFormat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"jsformat", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getJSFormat()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getJsonFormat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"jsonformat", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getJsonFormat()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getLength() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"length", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getLength()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getLNPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lnpslanresid", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getLNPSLanResId()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getLNPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lnpslanresname", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getLNPSLanResName()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getLogicName()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getMajorField() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"majorfield", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getMajorField()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getMaxValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maxvalue", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getMaxValue()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getMinStrLength() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minstrlength", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getMinStrLength()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getMinValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minvalue", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getMinValue()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getMultiFormField() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"multiformfield", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getMultiFormField()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getNo2DupChkPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no2dupchkpsdefid", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getNo2DupChkPSDEFId()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getNo2DupChkPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no2dupchkpsdefname", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getNo2DupChkPSDEFName()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getNo3DupChkPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no3dupchkpsdefid", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getNo3DupChkPSDEFId()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getNo3DupChkPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no3dupchkpsdefname", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getNo3DupChkPSDEFName()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getNullValOrder() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"nullvalorder", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getNullValOrder()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getO2MPSDERId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"o2mpsderid", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getO2MPSDERId()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getO2MPSDERName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"o2mpsdername", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getO2MPSDERName()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getO2OPSDERId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"o2opsderid", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getO2OPSDERId()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getO2OPSDERName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"o2opsdername", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getO2OPSDERName()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getPasteReset() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pastereset", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getPasteReset()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getPhysicalField() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"physicalfield", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getPhysicalField()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getPKey() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pkey", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getPKey()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getPrecision2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"precision2", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getPrecision2()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getPredefinedTypeParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"predefinedtypeparam", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getPredefinedTypeParam()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getPreDefineType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"predefinetype", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getPreDefineType()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getPSCodeListId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscodelistid", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getPSCodeListId()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getPSCodeListName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscodelistname", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getPSCodeListName()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getPSDataTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdatatypeid", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getPSDataTypeId()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getPSDataTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdatatypename", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getPSDataTypeName()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getPSDEFDTColsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefdtcolscnt", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getPSDEFDTColsCnt()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getPSDEFieldId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefieldid", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getPSDEFieldId()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getPSDEFieldName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefieldname", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getPSDEFieldName()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getPSDEFieldsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefieldscnt", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getPSDEFieldsCnt()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getPSDEFInputTipsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefinputtipscnt", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getPSDEFInputTipsCnt()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getPSDEFSFItemsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefsfitemscnt", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getPSDEFSFItemsCnt()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getPSDEFUIModesCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefuimodescnt", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getPSDEFUIModesCnt()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getPSDEFValueRulesCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefvaluerulescnt", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getPSDEFValueRulesCnt()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getPSDERId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psderid", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getPSDERId()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getPSDERName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdername", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getPSDERName()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getPSDETableId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetableid", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getPSDETableId()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getPSSubSysSADEFieldId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsyssadefieldid", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getPSSubSysSADEFieldId()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getPSSubSysSADEFieldName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsyssadefieldname", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getPSSubSysSADEFieldName()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getPSSubSysSADEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsyssadeid", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getPSSubSysSADEId()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getPSSysDBColumnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdbcolumnid", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getPSSysDBColumnId()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getPSSysSampleValueId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssamplevalueid", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getPSSysSampleValueId()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getPSSysSampleValueName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssamplevaluename", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getPSSysSampleValueName()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getPSSysSequenceId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssequenceid", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getPSSysSequenceId()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getPSSysSequenceName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssequencename", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getPSSysSequenceName()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getPSSysTestCasesCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystestcasescnt", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getPSSysTestCasesCnt()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getPSSysTranslatorId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystranslatorid", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getPSSysTranslatorId()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getPSSysTranslatorName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystranslatorname", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getPSSysTranslatorName()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getPSSysUnitId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysunitid", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getPSSysUnitId()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getPSSysUnitName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysunitname", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getPSSysUnitName()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getPSSysValueRuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysvalueruleid", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getPSSysValueRuleId()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getPSSysValueRuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysvaluerulename", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getPSSysValueRuleName()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getQueryColumn() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"querycolumn", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getQueryColumn()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getQueryCS() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"querycs", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getQueryCS()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getReadOnlyMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"readonlymode", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getReadOnlyMode()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getRefPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpssysdynamodelid", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getRefPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getRefPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpssysdynamodelname", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getRefPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getRestrictedPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"restrictedpsdefid", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getRestrictedPSDEFId()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getRestrictedPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"restrictedpsdefname", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getRestrictedPSDEFName()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getSequenceMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sequencemode", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getSequenceMode()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getServiceCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"servicecodename", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getServiceCodeName()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getStateField() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"statefield", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getStateField()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getStdDataType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"stddatatype", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getStdDataType()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getStringCase() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"stringcase", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getStringCase()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getStrLength() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"strlength", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getStrLength()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getTableName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tablename", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getTableName()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getTableScope() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tablescope", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getTableScope()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getTestData() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"testdata", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getTestData()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getTranslatorMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"translatormode", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getTranslatorMode()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getUnicodeChar() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"unicodechar", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getUnicodeChar()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getUnionKeyValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"unionkeyvalue", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getUnionKeyValue()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getUnit() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"unit", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getUnit()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getUnitWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"unitwidth", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getUnitWidth()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getUpdateOVMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateovmode", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getUpdateOVMode()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getUserParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userparams", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getUserParams()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getValueFormat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"valueformat", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getValueFormat()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getValuePSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"valuepsdefid", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getValuePSDEFId()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getValuePSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"valuepsdefname", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getValuePSDEFName()), (boolean)false);
        }
        if (bl || pSDEFieldBase.getViewColLevel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewcollevel", (Object)PSDEFieldBase.getJSONValue((Object)pSDEFieldBase.getViewColLevel()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEFieldBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEFieldBase pSDEFieldBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEFieldBase.getAllowEmpty() != null) {
            object = pSDEFieldBase.getAllowEmpty();
            xmlNode.setAttribute(FIELD_ALLOWEMPTY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFieldBase.getAuditInfoFormat() != null) {
            object = pSDEFieldBase.getAuditInfoFormat();
            xmlNode.setAttribute(FIELD_AUDITINFOFORMAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getBizTag() != null) {
            object = pSDEFieldBase.getBizTag();
            xmlNode.setAttribute(FIELD_BIZTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getCheckRecursion() != null) {
            object = pSDEFieldBase.getCheckRecursion();
            xmlNode.setAttribute(FIELD_CHECKRECURSION, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFieldBase.getCodeName() != null) {
            object = pSDEFieldBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getComputeExp() != null) {
            object = pSDEFieldBase.getComputeExp();
            xmlNode.setAttribute(FIELD_COMPUTEEXP, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getCreateDate() != null) {
            object = pSDEFieldBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEFieldBase.getCreateMan() != null) {
            object = pSDEFieldBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getCustomExportScope() != null) {
            object = pSDEFieldBase.getCustomExportScope();
            xmlNode.setAttribute(FIELD_CUSTOMEXPORTSCOPE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFieldBase.getDBValueMode() != null) {
            object = pSDEFieldBase.getDBValueMode();
            xmlNode.setAttribute(FIELD_DBVALUEMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getDBValueMode2() != null) {
            object = pSDEFieldBase.getDBValueMode2();
            xmlNode.setAttribute(FIELD_DBVALUEMODE2, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getDefaultValue() != null) {
            object = pSDEFieldBase.getDefaultValue();
            xmlNode.setAttribute(FIELD_DEFAULTVALUE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getDEFType() != null) {
            object = pSDEFieldBase.getDEFType();
            xmlNode.setAttribute(FIELD_DEFTYPE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFieldBase.getDERPSDEFId() != null) {
            object = pSDEFieldBase.getDERPSDEFId();
            xmlNode.setAttribute(FIELD_DERPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getDERPSDEFName() != null) {
            object = pSDEFieldBase.getDERPSDEFName();
            xmlNode.setAttribute(FIELD_DERPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getDupCheckMode() != null) {
            object = pSDEFieldBase.getDupCheckMode();
            xmlNode.setAttribute(FIELD_DUPCHECKMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getDupCheckValues() != null) {
            object = pSDEFieldBase.getDupCheckValues();
            xmlNode.setAttribute(FIELD_DUPCHECKVALUES, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getDupCheckPSDEFId() != null) {
            object = pSDEFieldBase.getDupCheckPSDEFId();
            xmlNode.setAttribute("DUPCHECKPSDEFID", object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getDupCheckPSDEFName() != null) {
            object = pSDEFieldBase.getDupCheckPSDEFName();
            xmlNode.setAttribute("DUPCHECKPSDEFNAME", object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getDefaultValueType() != null) {
            object = pSDEFieldBase.getDefaultValueType();
            xmlNode.setAttribute("DEFAULTVALUETYPE", object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getDynaModelFlag() != null) {
            object = pSDEFieldBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFieldBase.getEnableAudit() != null) {
            object = pSDEFieldBase.getEnableAudit();
            xmlNode.setAttribute(FIELD_ENABLEAUDIT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFieldBase.getEnableColPriv() != null) {
            object = pSDEFieldBase.getEnableColPriv();
            xmlNode.setAttribute(FIELD_ENABLECOLPRIV, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFieldBase.getEnableQS() != null) {
            object = pSDEFieldBase.getEnableQS();
            xmlNode.setAttribute(FIELD_ENABLEQS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFieldBase.getEnableTempData() != null) {
            object = pSDEFieldBase.getEnableTempData();
            xmlNode.setAttribute(FIELD_ENABLETEMPDATA, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFieldBase.getEnableUserInput() != null) {
            object = pSDEFieldBase.getEnableUserInput();
            xmlNode.setAttribute(FIELD_ENABLEUSERINPUT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFieldBase.getEnaWriteBack() != null) {
            object = pSDEFieldBase.getEnaWriteBack();
            xmlNode.setAttribute(FIELD_ENAWRITEBACK, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFieldBase.getExportScope() != null) {
            object = pSDEFieldBase.getExportScope();
            xmlNode.setAttribute(FIELD_EXPORTSCOPE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFieldBase.getExpPSSysTranslatorId() != null) {
            object = pSDEFieldBase.getExpPSSysTranslatorId();
            xmlNode.setAttribute(FIELD_EXPPSSYSTRANSLATORID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getExpPSSysTranslatorName() != null) {
            object = pSDEFieldBase.getExpPSSysTranslatorName();
            xmlNode.setAttribute(FIELD_EXPPSSYSTRANSLATORNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getExtendMode() != null) {
            object = pSDEFieldBase.getExtendMode();
            xmlNode.setAttribute(FIELD_EXTENDMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFieldBase.getFieldHolder() != null) {
            object = pSDEFieldBase.getFieldHolder();
            xmlNode.setAttribute(FIELD_FIELDHOLDER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFieldBase.getFieldTag() != null) {
            object = pSDEFieldBase.getFieldTag();
            xmlNode.setAttribute(FIELD_FIELDTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getFieldTag2() != null) {
            object = pSDEFieldBase.getFieldTag2();
            xmlNode.setAttribute(FIELD_FIELDTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getFKey() != null) {
            object = pSDEFieldBase.getFKey();
            xmlNode.setAttribute(FIELD_FKEY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFieldBase.getFormulaFields() != null) {
            object = pSDEFieldBase.getFormulaFields();
            xmlNode.setAttribute(FIELD_FORMULAFIELDS, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getFormulaFormat() != null) {
            object = pSDEFieldBase.getFormulaFormat();
            xmlNode.setAttribute(FIELD_FORMULAFORMAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getImportKey() != null) {
            object = pSDEFieldBase.getImportKey();
            xmlNode.setAttribute(FIELD_IMPORTKEY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFieldBase.getImportOrder() != null) {
            object = pSDEFieldBase.getImportOrder();
            xmlNode.setAttribute(FIELD_IMPORTORDER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFieldBase.getImportTag() != null) {
            object = pSDEFieldBase.getImportTag();
            xmlNode.setAttribute(FIELD_IMPORTTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getImpPSSysTranslatorId() != null) {
            object = pSDEFieldBase.getImpPSSysTranslatorId();
            xmlNode.setAttribute(FIELD_IMPPSSYSTRANSLATORID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getImpPSSysTranslatorName() != null) {
            object = pSDEFieldBase.getImpPSSysTranslatorName();
            xmlNode.setAttribute(FIELD_IMPPSSYSTRANSLATORNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getIndexType() != null) {
            object = pSDEFieldBase.getIndexType();
            xmlNode.setAttribute(FIELD_INDEXTYPE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFieldBase.getJSFormat() != null) {
            object = pSDEFieldBase.getJSFormat();
            xmlNode.setAttribute(FIELD_JSFORMAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getJsonFormat() != null) {
            object = pSDEFieldBase.getJsonFormat();
            xmlNode.setAttribute(FIELD_JSONFORMAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getLength() != null) {
            object = pSDEFieldBase.getLength();
            xmlNode.setAttribute(FIELD_LENGTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFieldBase.getLNPSLanResId() != null) {
            object = pSDEFieldBase.getLNPSLanResId();
            xmlNode.setAttribute(FIELD_LNPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getLNPSLanResName() != null) {
            object = pSDEFieldBase.getLNPSLanResName();
            xmlNode.setAttribute(FIELD_LNPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getLockFlag() != null) {
            object = pSDEFieldBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFieldBase.getLogicName() != null) {
            object = pSDEFieldBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getMajorField() != null) {
            object = pSDEFieldBase.getMajorField();
            xmlNode.setAttribute(FIELD_MAJORFIELD, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFieldBase.getMaxValue() != null) {
            object = pSDEFieldBase.getMaxValue();
            xmlNode.setAttribute(FIELD_MAXVALUE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getMemo() != null) {
            object = pSDEFieldBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getMinStrLength() != null) {
            object = pSDEFieldBase.getMinStrLength();
            xmlNode.setAttribute(FIELD_MINSTRLENGTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFieldBase.getMinValue() != null) {
            object = pSDEFieldBase.getMinValue();
            xmlNode.setAttribute(FIELD_MINVALUE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getMultiFormField() != null) {
            object = pSDEFieldBase.getMultiFormField();
            xmlNode.setAttribute(FIELD_MULTIFORMFIELD, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFieldBase.getNo2DupChkPSDEFId() != null) {
            object = pSDEFieldBase.getNo2DupChkPSDEFId();
            xmlNode.setAttribute(FIELD_NO2DUPCHKPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getNo2DupChkPSDEFName() != null) {
            object = pSDEFieldBase.getNo2DupChkPSDEFName();
            xmlNode.setAttribute(FIELD_NO2DUPCHKPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getNo3DupChkPSDEFId() != null) {
            object = pSDEFieldBase.getNo3DupChkPSDEFId();
            xmlNode.setAttribute(FIELD_NO3DUPCHKPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getNo3DupChkPSDEFName() != null) {
            object = pSDEFieldBase.getNo3DupChkPSDEFName();
            xmlNode.setAttribute(FIELD_NO3DUPCHKPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getNullValOrder() != null) {
            object = pSDEFieldBase.getNullValOrder();
            xmlNode.setAttribute(FIELD_NULLVALORDER, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getO2MPSDERId() != null) {
            object = pSDEFieldBase.getO2MPSDERId();
            xmlNode.setAttribute(FIELD_O2MPSDERID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getO2MPSDERName() != null) {
            object = pSDEFieldBase.getO2MPSDERName();
            xmlNode.setAttribute(FIELD_O2MPSDERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getO2OPSDERId() != null) {
            object = pSDEFieldBase.getO2OPSDERId();
            xmlNode.setAttribute(FIELD_O2OPSDERID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getO2OPSDERName() != null) {
            object = pSDEFieldBase.getO2OPSDERName();
            xmlNode.setAttribute(FIELD_O2OPSDERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getOrderValue() != null) {
            object = pSDEFieldBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFieldBase.getPasteReset() != null) {
            object = pSDEFieldBase.getPasteReset();
            xmlNode.setAttribute(FIELD_PASTERESET, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFieldBase.getPhysicalField() != null) {
            object = pSDEFieldBase.getPhysicalField();
            xmlNode.setAttribute(FIELD_PHYSICALFIELD, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFieldBase.getPKey() != null) {
            object = pSDEFieldBase.getPKey();
            xmlNode.setAttribute(FIELD_PKEY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFieldBase.getPrecision2() != null) {
            object = pSDEFieldBase.getPrecision2();
            xmlNode.setAttribute(FIELD_PRECISION2, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFieldBase.getPredefinedTypeParam() != null) {
            object = pSDEFieldBase.getPredefinedTypeParam();
            xmlNode.setAttribute(FIELD_PREDEFINEDTYPEPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getPreDefineType() != null) {
            object = pSDEFieldBase.getPreDefineType();
            xmlNode.setAttribute(FIELD_PREDEFINETYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getPSCodeListId() != null) {
            object = pSDEFieldBase.getPSCodeListId();
            xmlNode.setAttribute(FIELD_PSCODELISTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getPSCodeListName() != null) {
            object = pSDEFieldBase.getPSCodeListName();
            xmlNode.setAttribute(FIELD_PSCODELISTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getPSDataTypeId() != null) {
            object = pSDEFieldBase.getPSDataTypeId();
            xmlNode.setAttribute(FIELD_PSDATATYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getPSDataTypeName() != null) {
            object = pSDEFieldBase.getPSDataTypeName();
            xmlNode.setAttribute(FIELD_PSDATATYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getPSDEFDTColsCnt() != null) {
            object = pSDEFieldBase.getPSDEFDTColsCnt();
            xmlNode.setAttribute(FIELD_PSDEFDTCOLSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFieldBase.getPSDEFieldId() != null) {
            object = pSDEFieldBase.getPSDEFieldId();
            xmlNode.setAttribute(FIELD_PSDEFIELDID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getPSDEFieldName() != null) {
            object = pSDEFieldBase.getPSDEFieldName();
            xmlNode.setAttribute(FIELD_PSDEFIELDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getPSDEFieldsCnt() != null) {
            object = pSDEFieldBase.getPSDEFieldsCnt();
            xmlNode.setAttribute(FIELD_PSDEFIELDSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFieldBase.getPSDEFInputTipsCnt() != null) {
            object = pSDEFieldBase.getPSDEFInputTipsCnt();
            xmlNode.setAttribute(FIELD_PSDEFINPUTTIPSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFieldBase.getPSDEFSFItemsCnt() != null) {
            object = pSDEFieldBase.getPSDEFSFItemsCnt();
            xmlNode.setAttribute(FIELD_PSDEFSFITEMSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFieldBase.getPSDEFUIModesCnt() != null) {
            object = pSDEFieldBase.getPSDEFUIModesCnt();
            xmlNode.setAttribute(FIELD_PSDEFUIMODESCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFieldBase.getPSDEFValueRulesCnt() != null) {
            object = pSDEFieldBase.getPSDEFValueRulesCnt();
            xmlNode.setAttribute(FIELD_PSDEFVALUERULESCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFieldBase.getPSDEId() != null) {
            object = pSDEFieldBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getPSDEName() != null) {
            object = pSDEFieldBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getPSDERId() != null) {
            object = pSDEFieldBase.getPSDERId();
            xmlNode.setAttribute(FIELD_PSDERID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getPSDERName() != null) {
            object = pSDEFieldBase.getPSDERName();
            xmlNode.setAttribute(FIELD_PSDERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getPSDETableId() != null) {
            object = pSDEFieldBase.getPSDETableId();
            xmlNode.setAttribute(FIELD_PSDETABLEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getPSDynaInstId() != null) {
            object = pSDEFieldBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getPSSubSysSADEFieldId() != null) {
            object = pSDEFieldBase.getPSSubSysSADEFieldId();
            xmlNode.setAttribute(FIELD_PSSUBSYSSADEFIELDID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getPSSubSysSADEFieldName() != null) {
            object = pSDEFieldBase.getPSSubSysSADEFieldName();
            xmlNode.setAttribute(FIELD_PSSUBSYSSADEFIELDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getPSSubSysSADEId() != null) {
            object = pSDEFieldBase.getPSSubSysSADEId();
            xmlNode.setAttribute(FIELD_PSSUBSYSSADEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getPSSysDBColumnId() != null) {
            object = pSDEFieldBase.getPSSysDBColumnId();
            xmlNode.setAttribute(FIELD_PSSYSDBCOLUMNID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getPSSysSampleValueId() != null) {
            object = pSDEFieldBase.getPSSysSampleValueId();
            xmlNode.setAttribute(FIELD_PSSYSSAMPLEVALUEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getPSSysSampleValueName() != null) {
            object = pSDEFieldBase.getPSSysSampleValueName();
            xmlNode.setAttribute(FIELD_PSSYSSAMPLEVALUENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getPSSysSequenceId() != null) {
            object = pSDEFieldBase.getPSSysSequenceId();
            xmlNode.setAttribute(FIELD_PSSYSSEQUENCEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getPSSysSequenceName() != null) {
            object = pSDEFieldBase.getPSSysSequenceName();
            xmlNode.setAttribute(FIELD_PSSYSSEQUENCENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getPSSystemId() != null) {
            object = pSDEFieldBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getPSSysTestCasesCnt() != null) {
            object = pSDEFieldBase.getPSSysTestCasesCnt();
            xmlNode.setAttribute(FIELD_PSSYSTESTCASESCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFieldBase.getPSSysTranslatorId() != null) {
            object = pSDEFieldBase.getPSSysTranslatorId();
            xmlNode.setAttribute(FIELD_PSSYSTRANSLATORID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getPSSysTranslatorName() != null) {
            object = pSDEFieldBase.getPSSysTranslatorName();
            xmlNode.setAttribute(FIELD_PSSYSTRANSLATORNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getPSSysUnitId() != null) {
            object = pSDEFieldBase.getPSSysUnitId();
            xmlNode.setAttribute(FIELD_PSSYSUNITID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getPSSysUnitName() != null) {
            object = pSDEFieldBase.getPSSysUnitName();
            xmlNode.setAttribute(FIELD_PSSYSUNITNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getPSSysValueRuleId() != null) {
            object = pSDEFieldBase.getPSSysValueRuleId();
            xmlNode.setAttribute(FIELD_PSSYSVALUERULEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getPSSysValueRuleName() != null) {
            object = pSDEFieldBase.getPSSysValueRuleName();
            xmlNode.setAttribute(FIELD_PSSYSVALUERULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getQueryColumn() != null) {
            object = pSDEFieldBase.getQueryColumn();
            xmlNode.setAttribute(FIELD_QUERYCOLUMN, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFieldBase.getQueryCS() != null) {
            object = pSDEFieldBase.getQueryCS();
            xmlNode.setAttribute(FIELD_QUERYCS, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getReadOnlyMode() != null) {
            object = pSDEFieldBase.getReadOnlyMode();
            xmlNode.setAttribute(FIELD_READONLYMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFieldBase.getRefPSSysDynaModelId() != null) {
            object = pSDEFieldBase.getRefPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_REFPSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getRefPSSysDynaModelName() != null) {
            object = pSDEFieldBase.getRefPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_REFPSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getRestrictedPSDEFId() != null) {
            object = pSDEFieldBase.getRestrictedPSDEFId();
            xmlNode.setAttribute(FIELD_RESTRICTEDPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getRestrictedPSDEFName() != null) {
            object = pSDEFieldBase.getRestrictedPSDEFName();
            xmlNode.setAttribute(FIELD_RESTRICTEDPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getSequenceMode() != null) {
            object = pSDEFieldBase.getSequenceMode();
            xmlNode.setAttribute(FIELD_SEQUENCEMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getServiceCodeName() != null) {
            object = pSDEFieldBase.getServiceCodeName();
            xmlNode.setAttribute(FIELD_SERVICECODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getStateField() != null) {
            object = pSDEFieldBase.getStateField();
            xmlNode.setAttribute(FIELD_STATEFIELD, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getStdDataType() != null) {
            object = pSDEFieldBase.getStdDataType();
            xmlNode.setAttribute(FIELD_STDDATATYPE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFieldBase.getStringCase() != null) {
            object = pSDEFieldBase.getStringCase();
            xmlNode.setAttribute(FIELD_STRINGCASE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getStrLength() != null) {
            object = pSDEFieldBase.getStrLength();
            xmlNode.setAttribute(FIELD_STRLENGTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFieldBase.getTableName() != null) {
            object = pSDEFieldBase.getTableName();
            xmlNode.setAttribute(FIELD_TABLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getTableScope() != null) {
            object = pSDEFieldBase.getTableScope();
            xmlNode.setAttribute(FIELD_TABLESCOPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getTestData() != null) {
            object = pSDEFieldBase.getTestData();
            xmlNode.setAttribute(FIELD_TESTDATA, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getTranslatorMode() != null) {
            object = pSDEFieldBase.getTranslatorMode();
            xmlNode.setAttribute(FIELD_TRANSLATORMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getUnicodeChar() != null) {
            object = pSDEFieldBase.getUnicodeChar();
            xmlNode.setAttribute(FIELD_UNICODECHAR, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFieldBase.getUnionKeyValue() != null) {
            object = pSDEFieldBase.getUnionKeyValue();
            xmlNode.setAttribute(FIELD_UNIONKEYVALUE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getUnit() != null) {
            object = pSDEFieldBase.getUnit();
            xmlNode.setAttribute(FIELD_UNIT, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getUnitWidth() != null) {
            object = pSDEFieldBase.getUnitWidth();
            xmlNode.setAttribute(FIELD_UNITWIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFieldBase.getUpdateDate() != null) {
            object = pSDEFieldBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEFieldBase.getUpdateMan() != null) {
            object = pSDEFieldBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getUpdateOVMode() != null) {
            object = pSDEFieldBase.getUpdateOVMode();
            xmlNode.setAttribute(FIELD_UPDATEOVMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getUserCat() != null) {
            object = pSDEFieldBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getUserParams() != null) {
            object = pSDEFieldBase.getUserParams();
            xmlNode.setAttribute(FIELD_USERPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getUserTag() != null) {
            object = pSDEFieldBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getUserTag2() != null) {
            object = pSDEFieldBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getUserTag3() != null) {
            object = pSDEFieldBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getUserTag4() != null) {
            object = pSDEFieldBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getValidFlag() != null) {
            object = pSDEFieldBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFieldBase.getValueFormat() != null) {
            object = pSDEFieldBase.getValueFormat();
            xmlNode.setAttribute(FIELD_VALUEFORMAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getValuePSDEFId() != null) {
            object = pSDEFieldBase.getValuePSDEFId();
            xmlNode.setAttribute(FIELD_VALUEPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getValuePSDEFName() != null) {
            object = pSDEFieldBase.getValuePSDEFName();
            xmlNode.setAttribute(FIELD_VALUEPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldBase.getViewColLevel() != null) {
            object = pSDEFieldBase.getViewColLevel();
            xmlNode.setAttribute(FIELD_VIEWCOLLEVEL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEFieldBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEFieldBase pSDEFieldBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEFieldBase.isAllowEmptyDirty() && (bl || pSDEFieldBase.getAllowEmpty() != null)) {
            iDataObject.set(FIELD_ALLOWEMPTY, (Object)pSDEFieldBase.getAllowEmpty());
        }
        if (pSDEFieldBase.isAuditInfoFormatDirty() && (bl || pSDEFieldBase.getAuditInfoFormat() != null)) {
            iDataObject.set(FIELD_AUDITINFOFORMAT, (Object)pSDEFieldBase.getAuditInfoFormat());
        }
        if (pSDEFieldBase.isBizTagDirty() && (bl || pSDEFieldBase.getBizTag() != null)) {
            iDataObject.set(FIELD_BIZTAG, (Object)pSDEFieldBase.getBizTag());
        }
        if (pSDEFieldBase.isCheckRecursionDirty() && (bl || pSDEFieldBase.getCheckRecursion() != null)) {
            iDataObject.set(FIELD_CHECKRECURSION, (Object)pSDEFieldBase.getCheckRecursion());
        }
        if (pSDEFieldBase.isCodeNameDirty() && (bl || pSDEFieldBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDEFieldBase.getCodeName());
        }
        if (pSDEFieldBase.isComputeExpDirty() && (bl || pSDEFieldBase.getComputeExp() != null)) {
            iDataObject.set(FIELD_COMPUTEEXP, (Object)pSDEFieldBase.getComputeExp());
        }
        if (pSDEFieldBase.isCreateDateDirty() && (bl || pSDEFieldBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEFieldBase.getCreateDate());
        }
        if (pSDEFieldBase.isCreateManDirty() && (bl || pSDEFieldBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEFieldBase.getCreateMan());
        }
        if (pSDEFieldBase.isCustomExportScopeDirty() && (bl || pSDEFieldBase.getCustomExportScope() != null)) {
            iDataObject.set(FIELD_CUSTOMEXPORTSCOPE, (Object)pSDEFieldBase.getCustomExportScope());
        }
        if (pSDEFieldBase.isDBValueModeDirty() && (bl || pSDEFieldBase.getDBValueMode() != null)) {
            iDataObject.set(FIELD_DBVALUEMODE, (Object)pSDEFieldBase.getDBValueMode());
        }
        if (pSDEFieldBase.isDBValueMode2Dirty() && (bl || pSDEFieldBase.getDBValueMode2() != null)) {
            iDataObject.set(FIELD_DBVALUEMODE2, (Object)pSDEFieldBase.getDBValueMode2());
        }
        if (pSDEFieldBase.isDefaultValueDirty() && (bl || pSDEFieldBase.getDefaultValue() != null)) {
            iDataObject.set(FIELD_DEFAULTVALUE, (Object)pSDEFieldBase.getDefaultValue());
        }
        if (pSDEFieldBase.isDEFTypeDirty() && (bl || pSDEFieldBase.getDEFType() != null)) {
            iDataObject.set(FIELD_DEFTYPE, (Object)pSDEFieldBase.getDEFType());
        }
        if (pSDEFieldBase.isDERPSDEFIdDirty() && (bl || pSDEFieldBase.getDERPSDEFId() != null)) {
            iDataObject.set(FIELD_DERPSDEFID, (Object)pSDEFieldBase.getDERPSDEFId());
        }
        if (pSDEFieldBase.isDERPSDEFNameDirty() && (bl || pSDEFieldBase.getDERPSDEFName() != null)) {
            iDataObject.set(FIELD_DERPSDEFNAME, (Object)pSDEFieldBase.getDERPSDEFName());
        }
        if (pSDEFieldBase.isDupCheckModeDirty() && (bl || pSDEFieldBase.getDupCheckMode() != null)) {
            iDataObject.set(FIELD_DUPCHECKMODE, (Object)pSDEFieldBase.getDupCheckMode());
        }
        if (pSDEFieldBase.isDupCheckValuesDirty() && (bl || pSDEFieldBase.getDupCheckValues() != null)) {
            iDataObject.set(FIELD_DUPCHECKVALUES, (Object)pSDEFieldBase.getDupCheckValues());
        }
        if (pSDEFieldBase.isDupCheckPSDEFIdDirty() && (bl || pSDEFieldBase.getDupCheckPSDEFId() != null)) {
            iDataObject.set(FIELD_DUPCHECKPSDEFID, (Object)pSDEFieldBase.getDupCheckPSDEFId());
        }
        if (pSDEFieldBase.isDupCheckPSDEFNameDirty() && (bl || pSDEFieldBase.getDupCheckPSDEFName() != null)) {
            iDataObject.set(FIELD_DUPCHECKPSDEFNAME, (Object)pSDEFieldBase.getDupCheckPSDEFName());
        }
        if (pSDEFieldBase.isDefaultValueTypeDirty() && (bl || pSDEFieldBase.getDefaultValueType() != null)) {
            iDataObject.set(FIELD_DEFAULTVALUETYPE, (Object)pSDEFieldBase.getDefaultValueType());
        }
        if (pSDEFieldBase.isDynaModelFlagDirty() && (bl || pSDEFieldBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSDEFieldBase.getDynaModelFlag());
        }
        if (pSDEFieldBase.isEnableAuditDirty() && (bl || pSDEFieldBase.getEnableAudit() != null)) {
            iDataObject.set(FIELD_ENABLEAUDIT, (Object)pSDEFieldBase.getEnableAudit());
        }
        if (pSDEFieldBase.isEnableColPrivDirty() && (bl || pSDEFieldBase.getEnableColPriv() != null)) {
            iDataObject.set(FIELD_ENABLECOLPRIV, (Object)pSDEFieldBase.getEnableColPriv());
        }
        if (pSDEFieldBase.isEnableQSDirty() && (bl || pSDEFieldBase.getEnableQS() != null)) {
            iDataObject.set(FIELD_ENABLEQS, (Object)pSDEFieldBase.getEnableQS());
        }
        if (pSDEFieldBase.isEnableTempDataDirty() && (bl || pSDEFieldBase.getEnableTempData() != null)) {
            iDataObject.set(FIELD_ENABLETEMPDATA, (Object)pSDEFieldBase.getEnableTempData());
        }
        if (pSDEFieldBase.isEnableUserInputDirty() && (bl || pSDEFieldBase.getEnableUserInput() != null)) {
            iDataObject.set(FIELD_ENABLEUSERINPUT, (Object)pSDEFieldBase.getEnableUserInput());
        }
        if (pSDEFieldBase.isEnaWriteBackDirty() && (bl || pSDEFieldBase.getEnaWriteBack() != null)) {
            iDataObject.set(FIELD_ENAWRITEBACK, (Object)pSDEFieldBase.getEnaWriteBack());
        }
        if (pSDEFieldBase.isExportScopeDirty() && (bl || pSDEFieldBase.getExportScope() != null)) {
            iDataObject.set(FIELD_EXPORTSCOPE, (Object)pSDEFieldBase.getExportScope());
        }
        if (pSDEFieldBase.isExpPSSysTranslatorIdDirty() && (bl || pSDEFieldBase.getExpPSSysTranslatorId() != null)) {
            iDataObject.set(FIELD_EXPPSSYSTRANSLATORID, (Object)pSDEFieldBase.getExpPSSysTranslatorId());
        }
        if (pSDEFieldBase.isExpPSSysTranslatorNameDirty() && (bl || pSDEFieldBase.getExpPSSysTranslatorName() != null)) {
            iDataObject.set(FIELD_EXPPSSYSTRANSLATORNAME, (Object)pSDEFieldBase.getExpPSSysTranslatorName());
        }
        if (pSDEFieldBase.isExtendModeDirty() && (bl || pSDEFieldBase.getExtendMode() != null)) {
            iDataObject.set(FIELD_EXTENDMODE, (Object)pSDEFieldBase.getExtendMode());
        }
        if (pSDEFieldBase.isFieldHolderDirty() && (bl || pSDEFieldBase.getFieldHolder() != null)) {
            iDataObject.set(FIELD_FIELDHOLDER, (Object)pSDEFieldBase.getFieldHolder());
        }
        if (pSDEFieldBase.isFieldTagDirty() && (bl || pSDEFieldBase.getFieldTag() != null)) {
            iDataObject.set(FIELD_FIELDTAG, (Object)pSDEFieldBase.getFieldTag());
        }
        if (pSDEFieldBase.isFieldTag2Dirty() && (bl || pSDEFieldBase.getFieldTag2() != null)) {
            iDataObject.set(FIELD_FIELDTAG2, (Object)pSDEFieldBase.getFieldTag2());
        }
        if (pSDEFieldBase.isFKeyDirty() && (bl || pSDEFieldBase.getFKey() != null)) {
            iDataObject.set(FIELD_FKEY, (Object)pSDEFieldBase.getFKey());
        }
        if (pSDEFieldBase.isFormulaFieldsDirty() && (bl || pSDEFieldBase.getFormulaFields() != null)) {
            iDataObject.set(FIELD_FORMULAFIELDS, (Object)pSDEFieldBase.getFormulaFields());
        }
        if (pSDEFieldBase.isFormulaFormatDirty() && (bl || pSDEFieldBase.getFormulaFormat() != null)) {
            iDataObject.set(FIELD_FORMULAFORMAT, (Object)pSDEFieldBase.getFormulaFormat());
        }
        if (pSDEFieldBase.isImportKeyDirty() && (bl || pSDEFieldBase.getImportKey() != null)) {
            iDataObject.set(FIELD_IMPORTKEY, (Object)pSDEFieldBase.getImportKey());
        }
        if (pSDEFieldBase.isImportOrderDirty() && (bl || pSDEFieldBase.getImportOrder() != null)) {
            iDataObject.set(FIELD_IMPORTORDER, (Object)pSDEFieldBase.getImportOrder());
        }
        if (pSDEFieldBase.isImportTagDirty() && (bl || pSDEFieldBase.getImportTag() != null)) {
            iDataObject.set(FIELD_IMPORTTAG, (Object)pSDEFieldBase.getImportTag());
        }
        if (pSDEFieldBase.isImpPSSysTranslatorIdDirty() && (bl || pSDEFieldBase.getImpPSSysTranslatorId() != null)) {
            iDataObject.set(FIELD_IMPPSSYSTRANSLATORID, (Object)pSDEFieldBase.getImpPSSysTranslatorId());
        }
        if (pSDEFieldBase.isImpPSSysTranslatorNameDirty() && (bl || pSDEFieldBase.getImpPSSysTranslatorName() != null)) {
            iDataObject.set(FIELD_IMPPSSYSTRANSLATORNAME, (Object)pSDEFieldBase.getImpPSSysTranslatorName());
        }
        if (pSDEFieldBase.isIndexTypeDirty() && (bl || pSDEFieldBase.getIndexType() != null)) {
            iDataObject.set(FIELD_INDEXTYPE, (Object)pSDEFieldBase.getIndexType());
        }
        if (pSDEFieldBase.isJSFormatDirty() && (bl || pSDEFieldBase.getJSFormat() != null)) {
            iDataObject.set(FIELD_JSFORMAT, (Object)pSDEFieldBase.getJSFormat());
        }
        if (pSDEFieldBase.isJsonFormatDirty() && (bl || pSDEFieldBase.getJsonFormat() != null)) {
            iDataObject.set(FIELD_JSONFORMAT, (Object)pSDEFieldBase.getJsonFormat());
        }
        if (pSDEFieldBase.isLengthDirty() && (bl || pSDEFieldBase.getLength() != null)) {
            iDataObject.set(FIELD_LENGTH, (Object)pSDEFieldBase.getLength());
        }
        if (pSDEFieldBase.isLNPSLanResIdDirty() && (bl || pSDEFieldBase.getLNPSLanResId() != null)) {
            iDataObject.set(FIELD_LNPSLANRESID, (Object)pSDEFieldBase.getLNPSLanResId());
        }
        if (pSDEFieldBase.isLNPSLanResNameDirty() && (bl || pSDEFieldBase.getLNPSLanResName() != null)) {
            iDataObject.set(FIELD_LNPSLANRESNAME, (Object)pSDEFieldBase.getLNPSLanResName());
        }
        if (pSDEFieldBase.isLockFlagDirty() && (bl || pSDEFieldBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSDEFieldBase.getLockFlag());
        }
        if (pSDEFieldBase.isLogicNameDirty() && (bl || pSDEFieldBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSDEFieldBase.getLogicName());
        }
        if (pSDEFieldBase.isMajorFieldDirty() && (bl || pSDEFieldBase.getMajorField() != null)) {
            iDataObject.set(FIELD_MAJORFIELD, (Object)pSDEFieldBase.getMajorField());
        }
        if (pSDEFieldBase.isMaxValueDirty() && (bl || pSDEFieldBase.getMaxValue() != null)) {
            iDataObject.set(FIELD_MAXVALUE, (Object)pSDEFieldBase.getMaxValue());
        }
        if (pSDEFieldBase.isMemoDirty() && (bl || pSDEFieldBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEFieldBase.getMemo());
        }
        if (pSDEFieldBase.isMinStrLengthDirty() && (bl || pSDEFieldBase.getMinStrLength() != null)) {
            iDataObject.set(FIELD_MINSTRLENGTH, (Object)pSDEFieldBase.getMinStrLength());
        }
        if (pSDEFieldBase.isMinValueDirty() && (bl || pSDEFieldBase.getMinValue() != null)) {
            iDataObject.set(FIELD_MINVALUE, (Object)pSDEFieldBase.getMinValue());
        }
        if (pSDEFieldBase.isMultiFormFieldDirty() && (bl || pSDEFieldBase.getMultiFormField() != null)) {
            iDataObject.set(FIELD_MULTIFORMFIELD, (Object)pSDEFieldBase.getMultiFormField());
        }
        if (pSDEFieldBase.isNo2DupChkPSDEFIdDirty() && (bl || pSDEFieldBase.getNo2DupChkPSDEFId() != null)) {
            iDataObject.set(FIELD_NO2DUPCHKPSDEFID, (Object)pSDEFieldBase.getNo2DupChkPSDEFId());
        }
        if (pSDEFieldBase.isNo2DupChkPSDEFNameDirty() && (bl || pSDEFieldBase.getNo2DupChkPSDEFName() != null)) {
            iDataObject.set(FIELD_NO2DUPCHKPSDEFNAME, (Object)pSDEFieldBase.getNo2DupChkPSDEFName());
        }
        if (pSDEFieldBase.isNo3DupChkPSDEFIdDirty() && (bl || pSDEFieldBase.getNo3DupChkPSDEFId() != null)) {
            iDataObject.set(FIELD_NO3DUPCHKPSDEFID, (Object)pSDEFieldBase.getNo3DupChkPSDEFId());
        }
        if (pSDEFieldBase.isNo3DupChkPSDEFNameDirty() && (bl || pSDEFieldBase.getNo3DupChkPSDEFName() != null)) {
            iDataObject.set(FIELD_NO3DUPCHKPSDEFNAME, (Object)pSDEFieldBase.getNo3DupChkPSDEFName());
        }
        if (pSDEFieldBase.isNullValOrderDirty() && (bl || pSDEFieldBase.getNullValOrder() != null)) {
            iDataObject.set(FIELD_NULLVALORDER, (Object)pSDEFieldBase.getNullValOrder());
        }
        if (pSDEFieldBase.isO2MPSDERIdDirty() && (bl || pSDEFieldBase.getO2MPSDERId() != null)) {
            iDataObject.set(FIELD_O2MPSDERID, (Object)pSDEFieldBase.getO2MPSDERId());
        }
        if (pSDEFieldBase.isO2MPSDERNameDirty() && (bl || pSDEFieldBase.getO2MPSDERName() != null)) {
            iDataObject.set(FIELD_O2MPSDERNAME, (Object)pSDEFieldBase.getO2MPSDERName());
        }
        if (pSDEFieldBase.isO2OPSDERIdDirty() && (bl || pSDEFieldBase.getO2OPSDERId() != null)) {
            iDataObject.set(FIELD_O2OPSDERID, (Object)pSDEFieldBase.getO2OPSDERId());
        }
        if (pSDEFieldBase.isO2OPSDERNameDirty() && (bl || pSDEFieldBase.getO2OPSDERName() != null)) {
            iDataObject.set(FIELD_O2OPSDERNAME, (Object)pSDEFieldBase.getO2OPSDERName());
        }
        if (pSDEFieldBase.isOrderValueDirty() && (bl || pSDEFieldBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDEFieldBase.getOrderValue());
        }
        if (pSDEFieldBase.isPasteResetDirty() && (bl || pSDEFieldBase.getPasteReset() != null)) {
            iDataObject.set(FIELD_PASTERESET, (Object)pSDEFieldBase.getPasteReset());
        }
        if (pSDEFieldBase.isPhysicalFieldDirty() && (bl || pSDEFieldBase.getPhysicalField() != null)) {
            iDataObject.set(FIELD_PHYSICALFIELD, (Object)pSDEFieldBase.getPhysicalField());
        }
        if (pSDEFieldBase.isPKeyDirty() && (bl || pSDEFieldBase.getPKey() != null)) {
            iDataObject.set(FIELD_PKEY, (Object)pSDEFieldBase.getPKey());
        }
        if (pSDEFieldBase.isPrecision2Dirty() && (bl || pSDEFieldBase.getPrecision2() != null)) {
            iDataObject.set(FIELD_PRECISION2, (Object)pSDEFieldBase.getPrecision2());
        }
        if (pSDEFieldBase.isPredefinedTypeParamDirty() && (bl || pSDEFieldBase.getPredefinedTypeParam() != null)) {
            iDataObject.set(FIELD_PREDEFINEDTYPEPARAM, (Object)pSDEFieldBase.getPredefinedTypeParam());
        }
        if (pSDEFieldBase.isPreDefineTypeDirty() && (bl || pSDEFieldBase.getPreDefineType() != null)) {
            iDataObject.set(FIELD_PREDEFINETYPE, (Object)pSDEFieldBase.getPreDefineType());
        }
        if (pSDEFieldBase.isPSCodeListIdDirty() && (bl || pSDEFieldBase.getPSCodeListId() != null)) {
            iDataObject.set(FIELD_PSCODELISTID, (Object)pSDEFieldBase.getPSCodeListId());
        }
        if (pSDEFieldBase.isPSCodeListNameDirty() && (bl || pSDEFieldBase.getPSCodeListName() != null)) {
            iDataObject.set(FIELD_PSCODELISTNAME, (Object)pSDEFieldBase.getPSCodeListName());
        }
        if (pSDEFieldBase.isPSDataTypeIdDirty() && (bl || pSDEFieldBase.getPSDataTypeId() != null)) {
            iDataObject.set(FIELD_PSDATATYPEID, (Object)pSDEFieldBase.getPSDataTypeId());
        }
        if (pSDEFieldBase.isPSDataTypeNameDirty() && (bl || pSDEFieldBase.getPSDataTypeName() != null)) {
            iDataObject.set(FIELD_PSDATATYPENAME, (Object)pSDEFieldBase.getPSDataTypeName());
        }
        if (pSDEFieldBase.isPSDEFDTColsCntDirty() && (bl || pSDEFieldBase.getPSDEFDTColsCnt() != null)) {
            iDataObject.set(FIELD_PSDEFDTCOLSCNT, (Object)pSDEFieldBase.getPSDEFDTColsCnt());
        }
        if (pSDEFieldBase.isPSDEFieldIdDirty() && (bl || pSDEFieldBase.getPSDEFieldId() != null)) {
            iDataObject.set(FIELD_PSDEFIELDID, (Object)pSDEFieldBase.getPSDEFieldId());
        }
        if (pSDEFieldBase.isPSDEFieldNameDirty() && (bl || pSDEFieldBase.getPSDEFieldName() != null)) {
            iDataObject.set(FIELD_PSDEFIELDNAME, (Object)pSDEFieldBase.getPSDEFieldName());
        }
        if (pSDEFieldBase.isPSDEFieldsCntDirty() && (bl || pSDEFieldBase.getPSDEFieldsCnt() != null)) {
            iDataObject.set(FIELD_PSDEFIELDSCNT, (Object)pSDEFieldBase.getPSDEFieldsCnt());
        }
        if (pSDEFieldBase.isPSDEFInputTipsCntDirty() && (bl || pSDEFieldBase.getPSDEFInputTipsCnt() != null)) {
            iDataObject.set(FIELD_PSDEFINPUTTIPSCNT, (Object)pSDEFieldBase.getPSDEFInputTipsCnt());
        }
        if (pSDEFieldBase.isPSDEFSFItemsCntDirty() && (bl || pSDEFieldBase.getPSDEFSFItemsCnt() != null)) {
            iDataObject.set(FIELD_PSDEFSFITEMSCNT, (Object)pSDEFieldBase.getPSDEFSFItemsCnt());
        }
        if (pSDEFieldBase.isPSDEFUIModesCntDirty() && (bl || pSDEFieldBase.getPSDEFUIModesCnt() != null)) {
            iDataObject.set(FIELD_PSDEFUIMODESCNT, (Object)pSDEFieldBase.getPSDEFUIModesCnt());
        }
        if (pSDEFieldBase.isPSDEFValueRulesCntDirty() && (bl || pSDEFieldBase.getPSDEFValueRulesCnt() != null)) {
            iDataObject.set(FIELD_PSDEFVALUERULESCNT, (Object)pSDEFieldBase.getPSDEFValueRulesCnt());
        }
        if (pSDEFieldBase.isPSDEIdDirty() && (bl || pSDEFieldBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEFieldBase.getPSDEId());
        }
        if (pSDEFieldBase.isPSDENameDirty() && (bl || pSDEFieldBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDEFieldBase.getPSDEName());
        }
        if (pSDEFieldBase.isPSDERIdDirty() && (bl || pSDEFieldBase.getPSDERId() != null)) {
            iDataObject.set(FIELD_PSDERID, (Object)pSDEFieldBase.getPSDERId());
        }
        if (pSDEFieldBase.isPSDERNameDirty() && (bl || pSDEFieldBase.getPSDERName() != null)) {
            iDataObject.set(FIELD_PSDERNAME, (Object)pSDEFieldBase.getPSDERName());
        }
        if (pSDEFieldBase.isPSDETableIdDirty() && (bl || pSDEFieldBase.getPSDETableId() != null)) {
            iDataObject.set(FIELD_PSDETABLEID, (Object)pSDEFieldBase.getPSDETableId());
        }
        if (pSDEFieldBase.isPSDynaInstIdDirty() && (bl || pSDEFieldBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSDEFieldBase.getPSDynaInstId());
        }
        if (pSDEFieldBase.isPSSubSysSADEFieldIdDirty() && (bl || pSDEFieldBase.getPSSubSysSADEFieldId() != null)) {
            iDataObject.set(FIELD_PSSUBSYSSADEFIELDID, (Object)pSDEFieldBase.getPSSubSysSADEFieldId());
        }
        if (pSDEFieldBase.isPSSubSysSADEFieldNameDirty() && (bl || pSDEFieldBase.getPSSubSysSADEFieldName() != null)) {
            iDataObject.set(FIELD_PSSUBSYSSADEFIELDNAME, (Object)pSDEFieldBase.getPSSubSysSADEFieldName());
        }
        if (pSDEFieldBase.isPSSubSysSADEIdDirty() && (bl || pSDEFieldBase.getPSSubSysSADEId() != null)) {
            iDataObject.set(FIELD_PSSUBSYSSADEID, (Object)pSDEFieldBase.getPSSubSysSADEId());
        }
        if (pSDEFieldBase.isPSSysDBColumnIdDirty() && (bl || pSDEFieldBase.getPSSysDBColumnId() != null)) {
            iDataObject.set(FIELD_PSSYSDBCOLUMNID, (Object)pSDEFieldBase.getPSSysDBColumnId());
        }
        if (pSDEFieldBase.isPSSysSampleValueIdDirty() && (bl || pSDEFieldBase.getPSSysSampleValueId() != null)) {
            iDataObject.set(FIELD_PSSYSSAMPLEVALUEID, (Object)pSDEFieldBase.getPSSysSampleValueId());
        }
        if (pSDEFieldBase.isPSSysSampleValueNameDirty() && (bl || pSDEFieldBase.getPSSysSampleValueName() != null)) {
            iDataObject.set(FIELD_PSSYSSAMPLEVALUENAME, (Object)pSDEFieldBase.getPSSysSampleValueName());
        }
        if (pSDEFieldBase.isPSSysSequenceIdDirty() && (bl || pSDEFieldBase.getPSSysSequenceId() != null)) {
            iDataObject.set(FIELD_PSSYSSEQUENCEID, (Object)pSDEFieldBase.getPSSysSequenceId());
        }
        if (pSDEFieldBase.isPSSysSequenceNameDirty() && (bl || pSDEFieldBase.getPSSysSequenceName() != null)) {
            iDataObject.set(FIELD_PSSYSSEQUENCENAME, (Object)pSDEFieldBase.getPSSysSequenceName());
        }
        if (pSDEFieldBase.isPSSystemIdDirty() && (bl || pSDEFieldBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSDEFieldBase.getPSSystemId());
        }
        if (pSDEFieldBase.isPSSysTestCasesCntDirty() && (bl || pSDEFieldBase.getPSSysTestCasesCnt() != null)) {
            iDataObject.set(FIELD_PSSYSTESTCASESCNT, (Object)pSDEFieldBase.getPSSysTestCasesCnt());
        }
        if (pSDEFieldBase.isPSSysTranslatorIdDirty() && (bl || pSDEFieldBase.getPSSysTranslatorId() != null)) {
            iDataObject.set(FIELD_PSSYSTRANSLATORID, (Object)pSDEFieldBase.getPSSysTranslatorId());
        }
        if (pSDEFieldBase.isPSSysTranslatorNameDirty() && (bl || pSDEFieldBase.getPSSysTranslatorName() != null)) {
            iDataObject.set(FIELD_PSSYSTRANSLATORNAME, (Object)pSDEFieldBase.getPSSysTranslatorName());
        }
        if (pSDEFieldBase.isPSSysUnitIdDirty() && (bl || pSDEFieldBase.getPSSysUnitId() != null)) {
            iDataObject.set(FIELD_PSSYSUNITID, (Object)pSDEFieldBase.getPSSysUnitId());
        }
        if (pSDEFieldBase.isPSSysUnitNameDirty() && (bl || pSDEFieldBase.getPSSysUnitName() != null)) {
            iDataObject.set(FIELD_PSSYSUNITNAME, (Object)pSDEFieldBase.getPSSysUnitName());
        }
        if (pSDEFieldBase.isPSSysValueRuleIdDirty() && (bl || pSDEFieldBase.getPSSysValueRuleId() != null)) {
            iDataObject.set(FIELD_PSSYSVALUERULEID, (Object)pSDEFieldBase.getPSSysValueRuleId());
        }
        if (pSDEFieldBase.isPSSysValueRuleNameDirty() && (bl || pSDEFieldBase.getPSSysValueRuleName() != null)) {
            iDataObject.set(FIELD_PSSYSVALUERULENAME, (Object)pSDEFieldBase.getPSSysValueRuleName());
        }
        if (pSDEFieldBase.isQueryColumnDirty() && (bl || pSDEFieldBase.getQueryColumn() != null)) {
            iDataObject.set(FIELD_QUERYCOLUMN, (Object)pSDEFieldBase.getQueryColumn());
        }
        if (pSDEFieldBase.isQueryCSDirty() && (bl || pSDEFieldBase.getQueryCS() != null)) {
            iDataObject.set(FIELD_QUERYCS, (Object)pSDEFieldBase.getQueryCS());
        }
        if (pSDEFieldBase.isReadOnlyModeDirty() && (bl || pSDEFieldBase.getReadOnlyMode() != null)) {
            iDataObject.set(FIELD_READONLYMODE, (Object)pSDEFieldBase.getReadOnlyMode());
        }
        if (pSDEFieldBase.isRefPSSysDynaModelIdDirty() && (bl || pSDEFieldBase.getRefPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_REFPSSYSDYNAMODELID, (Object)pSDEFieldBase.getRefPSSysDynaModelId());
        }
        if (pSDEFieldBase.isRefPSSysDynaModelNameDirty() && (bl || pSDEFieldBase.getRefPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_REFPSSYSDYNAMODELNAME, (Object)pSDEFieldBase.getRefPSSysDynaModelName());
        }
        if (pSDEFieldBase.isRestrictedPSDEFIdDirty() && (bl || pSDEFieldBase.getRestrictedPSDEFId() != null)) {
            iDataObject.set(FIELD_RESTRICTEDPSDEFID, (Object)pSDEFieldBase.getRestrictedPSDEFId());
        }
        if (pSDEFieldBase.isRestrictedPSDEFNameDirty() && (bl || pSDEFieldBase.getRestrictedPSDEFName() != null)) {
            iDataObject.set(FIELD_RESTRICTEDPSDEFNAME, (Object)pSDEFieldBase.getRestrictedPSDEFName());
        }
        if (pSDEFieldBase.isSequenceModeDirty() && (bl || pSDEFieldBase.getSequenceMode() != null)) {
            iDataObject.set(FIELD_SEQUENCEMODE, (Object)pSDEFieldBase.getSequenceMode());
        }
        if (pSDEFieldBase.isServiceCodeNameDirty() && (bl || pSDEFieldBase.getServiceCodeName() != null)) {
            iDataObject.set(FIELD_SERVICECODENAME, (Object)pSDEFieldBase.getServiceCodeName());
        }
        if (pSDEFieldBase.isStateFieldDirty() && (bl || pSDEFieldBase.getStateField() != null)) {
            iDataObject.set(FIELD_STATEFIELD, (Object)pSDEFieldBase.getStateField());
        }
        if (pSDEFieldBase.isStdDataTypeDirty() && (bl || pSDEFieldBase.getStdDataType() != null)) {
            iDataObject.set(FIELD_STDDATATYPE, (Object)pSDEFieldBase.getStdDataType());
        }
        if (pSDEFieldBase.isStringCaseDirty() && (bl || pSDEFieldBase.getStringCase() != null)) {
            iDataObject.set(FIELD_STRINGCASE, (Object)pSDEFieldBase.getStringCase());
        }
        if (pSDEFieldBase.isStrLengthDirty() && (bl || pSDEFieldBase.getStrLength() != null)) {
            iDataObject.set(FIELD_STRLENGTH, (Object)pSDEFieldBase.getStrLength());
        }
        if (pSDEFieldBase.isTableNameDirty() && (bl || pSDEFieldBase.getTableName() != null)) {
            iDataObject.set(FIELD_TABLENAME, (Object)pSDEFieldBase.getTableName());
        }
        if (pSDEFieldBase.isTableScopeDirty() && (bl || pSDEFieldBase.getTableScope() != null)) {
            iDataObject.set(FIELD_TABLESCOPE, (Object)pSDEFieldBase.getTableScope());
        }
        if (pSDEFieldBase.isTestDataDirty() && (bl || pSDEFieldBase.getTestData() != null)) {
            iDataObject.set(FIELD_TESTDATA, (Object)pSDEFieldBase.getTestData());
        }
        if (pSDEFieldBase.isTranslatorModeDirty() && (bl || pSDEFieldBase.getTranslatorMode() != null)) {
            iDataObject.set(FIELD_TRANSLATORMODE, (Object)pSDEFieldBase.getTranslatorMode());
        }
        if (pSDEFieldBase.isUnicodeCharDirty() && (bl || pSDEFieldBase.getUnicodeChar() != null)) {
            iDataObject.set(FIELD_UNICODECHAR, (Object)pSDEFieldBase.getUnicodeChar());
        }
        if (pSDEFieldBase.isUnionKeyValueDirty() && (bl || pSDEFieldBase.getUnionKeyValue() != null)) {
            iDataObject.set(FIELD_UNIONKEYVALUE, (Object)pSDEFieldBase.getUnionKeyValue());
        }
        if (pSDEFieldBase.isUnitDirty() && (bl || pSDEFieldBase.getUnit() != null)) {
            iDataObject.set(FIELD_UNIT, (Object)pSDEFieldBase.getUnit());
        }
        if (pSDEFieldBase.isUnitWidthDirty() && (bl || pSDEFieldBase.getUnitWidth() != null)) {
            iDataObject.set(FIELD_UNITWIDTH, (Object)pSDEFieldBase.getUnitWidth());
        }
        if (pSDEFieldBase.isUpdateDateDirty() && (bl || pSDEFieldBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEFieldBase.getUpdateDate());
        }
        if (pSDEFieldBase.isUpdateManDirty() && (bl || pSDEFieldBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEFieldBase.getUpdateMan());
        }
        if (pSDEFieldBase.isUpdateOVModeDirty() && (bl || pSDEFieldBase.getUpdateOVMode() != null)) {
            iDataObject.set(FIELD_UPDATEOVMODE, (Object)pSDEFieldBase.getUpdateOVMode());
        }
        if (pSDEFieldBase.isUserCatDirty() && (bl || pSDEFieldBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEFieldBase.getUserCat());
        }
        if (pSDEFieldBase.isUserParamsDirty() && (bl || pSDEFieldBase.getUserParams() != null)) {
            iDataObject.set(FIELD_USERPARAMS, (Object)pSDEFieldBase.getUserParams());
        }
        if (pSDEFieldBase.isUserTagDirty() && (bl || pSDEFieldBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEFieldBase.getUserTag());
        }
        if (pSDEFieldBase.isUserTag2Dirty() && (bl || pSDEFieldBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEFieldBase.getUserTag2());
        }
        if (pSDEFieldBase.isUserTag3Dirty() && (bl || pSDEFieldBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEFieldBase.getUserTag3());
        }
        if (pSDEFieldBase.isUserTag4Dirty() && (bl || pSDEFieldBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEFieldBase.getUserTag4());
        }
        if (pSDEFieldBase.isValidFlagDirty() && (bl || pSDEFieldBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDEFieldBase.getValidFlag());
        }
        if (pSDEFieldBase.isValueFormatDirty() && (bl || pSDEFieldBase.getValueFormat() != null)) {
            iDataObject.set(FIELD_VALUEFORMAT, (Object)pSDEFieldBase.getValueFormat());
        }
        if (pSDEFieldBase.isValuePSDEFIdDirty() && (bl || pSDEFieldBase.getValuePSDEFId() != null)) {
            iDataObject.set(FIELD_VALUEPSDEFID, (Object)pSDEFieldBase.getValuePSDEFId());
        }
        if (pSDEFieldBase.isValuePSDEFNameDirty() && (bl || pSDEFieldBase.getValuePSDEFName() != null)) {
            iDataObject.set(FIELD_VALUEPSDEFNAME, (Object)pSDEFieldBase.getValuePSDEFName());
        }
        if (pSDEFieldBase.isViewColLevelDirty() && (bl || pSDEFieldBase.getViewColLevel() != null)) {
            iDataObject.set(FIELD_VIEWCOLLEVEL, (Object)pSDEFieldBase.getViewColLevel());
        }
    }

    public boolean remove(String string) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().remove(string);
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer n = fieldIndexMap.get(string.toUpperCase());
        if (n == null) {
            return super.remove(string);
        }
        return PSDEFieldBase.remove(this, n);
    }

    private static boolean remove(PSDEFieldBase pSDEFieldBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEFieldBase.resetAllowEmpty();
                return true;
            }
            case 1: {
                pSDEFieldBase.resetAuditInfoFormat();
                return true;
            }
            case 2: {
                pSDEFieldBase.resetBizTag();
                return true;
            }
            case 3: {
                pSDEFieldBase.resetCheckRecursion();
                return true;
            }
            case 4: {
                pSDEFieldBase.resetCodeName();
                return true;
            }
            case 5: {
                pSDEFieldBase.resetComputeExp();
                return true;
            }
            case 6: {
                pSDEFieldBase.resetCreateDate();
                return true;
            }
            case 7: {
                pSDEFieldBase.resetCreateMan();
                return true;
            }
            case 8: {
                pSDEFieldBase.resetCustomExportScope();
                return true;
            }
            case 9: {
                pSDEFieldBase.resetDBValueMode();
                return true;
            }
            case 10: {
                pSDEFieldBase.resetDBValueMode2();
                return true;
            }
            case 11: {
                pSDEFieldBase.resetDefaultValue();
                return true;
            }
            case 12: {
                pSDEFieldBase.resetDEFType();
                return true;
            }
            case 13: {
                pSDEFieldBase.resetDERPSDEFId();
                return true;
            }
            case 14: {
                pSDEFieldBase.resetDERPSDEFName();
                return true;
            }
            case 15: {
                pSDEFieldBase.resetDupCheckMode();
                return true;
            }
            case 16: {
                pSDEFieldBase.resetDupCheckValues();
                return true;
            }
            case 17: {
                pSDEFieldBase.resetDupCheckPSDEFId();
                return true;
            }
            case 18: {
                pSDEFieldBase.resetDupCheckPSDEFName();
                return true;
            }
            case 19: {
                pSDEFieldBase.resetDefaultValueType();
                return true;
            }
            case 20: {
                pSDEFieldBase.resetDynaModelFlag();
                return true;
            }
            case 21: {
                pSDEFieldBase.resetEnableAudit();
                return true;
            }
            case 22: {
                pSDEFieldBase.resetEnableColPriv();
                return true;
            }
            case 23: {
                pSDEFieldBase.resetEnableQS();
                return true;
            }
            case 24: {
                pSDEFieldBase.resetEnableTempData();
                return true;
            }
            case 25: {
                pSDEFieldBase.resetEnableUserInput();
                return true;
            }
            case 26: {
                pSDEFieldBase.resetEnaWriteBack();
                return true;
            }
            case 27: {
                pSDEFieldBase.resetExportScope();
                return true;
            }
            case 28: {
                pSDEFieldBase.resetExpPSSysTranslatorId();
                return true;
            }
            case 29: {
                pSDEFieldBase.resetExpPSSysTranslatorName();
                return true;
            }
            case 30: {
                pSDEFieldBase.resetExtendMode();
                return true;
            }
            case 31: {
                pSDEFieldBase.resetFieldHolder();
                return true;
            }
            case 32: {
                pSDEFieldBase.resetFieldTag();
                return true;
            }
            case 33: {
                pSDEFieldBase.resetFieldTag2();
                return true;
            }
            case 34: {
                pSDEFieldBase.resetFKey();
                return true;
            }
            case 35: {
                pSDEFieldBase.resetFormulaFields();
                return true;
            }
            case 36: {
                pSDEFieldBase.resetFormulaFormat();
                return true;
            }
            case 37: {
                pSDEFieldBase.resetImportKey();
                return true;
            }
            case 38: {
                pSDEFieldBase.resetImportOrder();
                return true;
            }
            case 39: {
                pSDEFieldBase.resetImportTag();
                return true;
            }
            case 40: {
                pSDEFieldBase.resetImpPSSysTranslatorId();
                return true;
            }
            case 41: {
                pSDEFieldBase.resetImpPSSysTranslatorName();
                return true;
            }
            case 42: {
                pSDEFieldBase.resetIndexType();
                return true;
            }
            case 43: {
                pSDEFieldBase.resetJSFormat();
                return true;
            }
            case 44: {
                pSDEFieldBase.resetJsonFormat();
                return true;
            }
            case 45: {
                pSDEFieldBase.resetLength();
                return true;
            }
            case 46: {
                pSDEFieldBase.resetLNPSLanResId();
                return true;
            }
            case 47: {
                pSDEFieldBase.resetLNPSLanResName();
                return true;
            }
            case 48: {
                pSDEFieldBase.resetLockFlag();
                return true;
            }
            case 49: {
                pSDEFieldBase.resetLogicName();
                return true;
            }
            case 50: {
                pSDEFieldBase.resetMajorField();
                return true;
            }
            case 51: {
                pSDEFieldBase.resetMaxValue();
                return true;
            }
            case 52: {
                pSDEFieldBase.resetMemo();
                return true;
            }
            case 53: {
                pSDEFieldBase.resetMinStrLength();
                return true;
            }
            case 54: {
                pSDEFieldBase.resetMinValue();
                return true;
            }
            case 55: {
                pSDEFieldBase.resetMultiFormField();
                return true;
            }
            case 56: {
                pSDEFieldBase.resetNo2DupChkPSDEFId();
                return true;
            }
            case 57: {
                pSDEFieldBase.resetNo2DupChkPSDEFName();
                return true;
            }
            case 58: {
                pSDEFieldBase.resetNo3DupChkPSDEFId();
                return true;
            }
            case 59: {
                pSDEFieldBase.resetNo3DupChkPSDEFName();
                return true;
            }
            case 60: {
                pSDEFieldBase.resetNullValOrder();
                return true;
            }
            case 61: {
                pSDEFieldBase.resetO2MPSDERId();
                return true;
            }
            case 62: {
                pSDEFieldBase.resetO2MPSDERName();
                return true;
            }
            case 63: {
                pSDEFieldBase.resetO2OPSDERId();
                return true;
            }
            case 64: {
                pSDEFieldBase.resetO2OPSDERName();
                return true;
            }
            case 65: {
                pSDEFieldBase.resetOrderValue();
                return true;
            }
            case 66: {
                pSDEFieldBase.resetPasteReset();
                return true;
            }
            case 67: {
                pSDEFieldBase.resetPhysicalField();
                return true;
            }
            case 68: {
                pSDEFieldBase.resetPKey();
                return true;
            }
            case 69: {
                pSDEFieldBase.resetPrecision2();
                return true;
            }
            case 70: {
                pSDEFieldBase.resetPredefinedTypeParam();
                return true;
            }
            case 71: {
                pSDEFieldBase.resetPreDefineType();
                return true;
            }
            case 72: {
                pSDEFieldBase.resetPSCodeListId();
                return true;
            }
            case 73: {
                pSDEFieldBase.resetPSCodeListName();
                return true;
            }
            case 74: {
                pSDEFieldBase.resetPSDataTypeId();
                return true;
            }
            case 75: {
                pSDEFieldBase.resetPSDataTypeName();
                return true;
            }
            case 76: {
                pSDEFieldBase.resetPSDEFDTColsCnt();
                return true;
            }
            case 77: {
                pSDEFieldBase.resetPSDEFieldId();
                return true;
            }
            case 78: {
                pSDEFieldBase.resetPSDEFieldName();
                return true;
            }
            case 79: {
                pSDEFieldBase.resetPSDEFieldsCnt();
                return true;
            }
            case 80: {
                pSDEFieldBase.resetPSDEFInputTipsCnt();
                return true;
            }
            case 81: {
                pSDEFieldBase.resetPSDEFSFItemsCnt();
                return true;
            }
            case 82: {
                pSDEFieldBase.resetPSDEFUIModesCnt();
                return true;
            }
            case 83: {
                pSDEFieldBase.resetPSDEFValueRulesCnt();
                return true;
            }
            case 84: {
                pSDEFieldBase.resetPSDEId();
                return true;
            }
            case 85: {
                pSDEFieldBase.resetPSDEName();
                return true;
            }
            case 86: {
                pSDEFieldBase.resetPSDERId();
                return true;
            }
            case 87: {
                pSDEFieldBase.resetPSDERName();
                return true;
            }
            case 88: {
                pSDEFieldBase.resetPSDETableId();
                return true;
            }
            case 89: {
                pSDEFieldBase.resetPSDynaInstId();
                return true;
            }
            case 90: {
                pSDEFieldBase.resetPSSubSysSADEFieldId();
                return true;
            }
            case 91: {
                pSDEFieldBase.resetPSSubSysSADEFieldName();
                return true;
            }
            case 92: {
                pSDEFieldBase.resetPSSubSysSADEId();
                return true;
            }
            case 93: {
                pSDEFieldBase.resetPSSysDBColumnId();
                return true;
            }
            case 94: {
                pSDEFieldBase.resetPSSysSampleValueId();
                return true;
            }
            case 95: {
                pSDEFieldBase.resetPSSysSampleValueName();
                return true;
            }
            case 96: {
                pSDEFieldBase.resetPSSysSequenceId();
                return true;
            }
            case 97: {
                pSDEFieldBase.resetPSSysSequenceName();
                return true;
            }
            case 98: {
                pSDEFieldBase.resetPSSystemId();
                return true;
            }
            case 99: {
                pSDEFieldBase.resetPSSysTestCasesCnt();
                return true;
            }
            case 100: {
                pSDEFieldBase.resetPSSysTranslatorId();
                return true;
            }
            case 101: {
                pSDEFieldBase.resetPSSysTranslatorName();
                return true;
            }
            case 102: {
                pSDEFieldBase.resetPSSysUnitId();
                return true;
            }
            case 103: {
                pSDEFieldBase.resetPSSysUnitName();
                return true;
            }
            case 104: {
                pSDEFieldBase.resetPSSysValueRuleId();
                return true;
            }
            case 105: {
                pSDEFieldBase.resetPSSysValueRuleName();
                return true;
            }
            case 106: {
                pSDEFieldBase.resetQueryColumn();
                return true;
            }
            case 107: {
                pSDEFieldBase.resetQueryCS();
                return true;
            }
            case 108: {
                pSDEFieldBase.resetReadOnlyMode();
                return true;
            }
            case 109: {
                pSDEFieldBase.resetRefPSSysDynaModelId();
                return true;
            }
            case 110: {
                pSDEFieldBase.resetRefPSSysDynaModelName();
                return true;
            }
            case 111: {
                pSDEFieldBase.resetRestrictedPSDEFId();
                return true;
            }
            case 112: {
                pSDEFieldBase.resetRestrictedPSDEFName();
                return true;
            }
            case 113: {
                pSDEFieldBase.resetSequenceMode();
                return true;
            }
            case 114: {
                pSDEFieldBase.resetServiceCodeName();
                return true;
            }
            case 115: {
                pSDEFieldBase.resetStateField();
                return true;
            }
            case 116: {
                pSDEFieldBase.resetStdDataType();
                return true;
            }
            case 117: {
                pSDEFieldBase.resetStringCase();
                return true;
            }
            case 118: {
                pSDEFieldBase.resetStrLength();
                return true;
            }
            case 119: {
                pSDEFieldBase.resetTableName();
                return true;
            }
            case 120: {
                pSDEFieldBase.resetTableScope();
                return true;
            }
            case 121: {
                pSDEFieldBase.resetTestData();
                return true;
            }
            case 122: {
                pSDEFieldBase.resetTranslatorMode();
                return true;
            }
            case 123: {
                pSDEFieldBase.resetUnicodeChar();
                return true;
            }
            case 124: {
                pSDEFieldBase.resetUnionKeyValue();
                return true;
            }
            case 125: {
                pSDEFieldBase.resetUnit();
                return true;
            }
            case 126: {
                pSDEFieldBase.resetUnitWidth();
                return true;
            }
            case 127: {
                pSDEFieldBase.resetUpdateDate();
                return true;
            }
            case 128: {
                pSDEFieldBase.resetUpdateMan();
                return true;
            }
            case 129: {
                pSDEFieldBase.resetUpdateOVMode();
                return true;
            }
            case 130: {
                pSDEFieldBase.resetUserCat();
                return true;
            }
            case 131: {
                pSDEFieldBase.resetUserParams();
                return true;
            }
            case 132: {
                pSDEFieldBase.resetUserTag();
                return true;
            }
            case 133: {
                pSDEFieldBase.resetUserTag2();
                return true;
            }
            case 134: {
                pSDEFieldBase.resetUserTag3();
                return true;
            }
            case 135: {
                pSDEFieldBase.resetUserTag4();
                return true;
            }
            case 136: {
                pSDEFieldBase.resetValidFlag();
                return true;
            }
            case 137: {
                pSDEFieldBase.resetValueFormat();
                return true;
            }
            case 138: {
                pSDEFieldBase.resetValuePSDEFId();
                return true;
            }
            case 139: {
                pSDEFieldBase.resetValuePSDEFName();
                return true;
            }
            case 140: {
                pSDEFieldBase.resetViewColLevel();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCodeList getPSCodeList() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCodeList();
        }
        if (this.getPSCodeListId() == null) {
            return null;
        }
        Integer n = this.objPSCodeListLock;
        synchronized (n) {
            if (this.pscodelist != null && DataTypeHelper.compare((int)25, (Object)this.getPSCodeListId(), (Object)this.pscodelist.getPSCodeListId()) != 0L) {
                this.pscodelist = null;
            }
            if (this.pscodelist == null) {
                PSCodeList pSCodeList = new PSCodeList();
                pSCodeList.setPSCodeListId(this.getPSCodeListId());
                PSCodeListService pSCodeListService = (PSCodeListService)ServiceGlobal.getService(PSCodeListService.class, (SessionFactory)this.getSessionFactory());
                pSCodeListService.autoGet((IEntity)pSCodeList);
                this.pscodelist = pSCodeList;
            }
            return this.pscodelist;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getPSDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDE();
        }
        if (this.getPSDEId() == null) {
            return null;
        }
        Integer n = this.objPSDELock;
        synchronized (n) {
            if (this.psde != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEId(), (Object)this.psde.getPSDataEntityId()) != 0L) {
                this.psde = null;
            }
            if (this.psde == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getPSDEId());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet((IEntity)pSDataEntity);
                this.psde = pSDataEntity;
            }
            return this.psde;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEFDataType getPSDataType() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDataType();
        }
        if (this.getPSDataTypeId() == null) {
            return null;
        }
        Integer n = this.objPSDataTypeLock;
        synchronized (n) {
            if (this.psdatatype != null && DataTypeHelper.compare((int)25, (Object)this.getPSDataTypeId(), (Object)this.psdatatype.getPSDEFDataTypeId()) != 0L) {
                this.psdatatype = null;
            }
            if (this.psdatatype == null) {
                PSDEFDataType pSDEFDataType = new PSDEFDataType();
                pSDEFDataType.setPSDEFDataTypeId(this.getPSDataTypeId());
                PSDEFDataTypeService pSDEFDataTypeService = (PSDEFDataTypeService)ServiceGlobal.getService(PSDEFDataTypeService.class, (SessionFactory)this.getSessionFactory());
                pSDEFDataTypeService.autoGet((IEntity)pSDEFDataType);
                this.psdatatype = pSDEFDataType;
            }
            return this.psdatatype;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getDERPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDERPSDEF();
        }
        if (this.getDERPSDEFId() == null) {
            return null;
        }
        Integer n = this.objDERPSDEFLock;
        synchronized (n) {
            if (this.derpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getDERPSDEFId(), (Object)this.derpsdef.getPSDEFieldId()) != 0L) {
                this.derpsdef = null;
            }
            if (this.derpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getDERPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.derpsdef = pSDEField;
            }
            return this.derpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getDupChkPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDupChkPSDEF();
        }
        if (this.getDupCheckPSDEFId() == null) {
            return null;
        }
        Integer n = this.objDupChkPSDEFLock;
        synchronized (n) {
            if (this.dupchkpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getDupCheckPSDEFId(), (Object)this.dupchkpsdef.getPSDEFieldId()) != 0L) {
                this.dupchkpsdef = null;
            }
            if (this.dupchkpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getDupCheckPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.dupchkpsdef = pSDEField;
            }
            return this.dupchkpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getNo2DupChkPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo2DupChkPSDEF();
        }
        if (this.getNo2DupChkPSDEFId() == null) {
            return null;
        }
        Integer n = this.objNo2DupChkPSDEFLock;
        synchronized (n) {
            if (this.no2dupchkpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getNo2DupChkPSDEFId(), (Object)this.no2dupchkpsdef.getPSDEFieldId()) != 0L) {
                this.no2dupchkpsdef = null;
            }
            if (this.no2dupchkpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getNo2DupChkPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.no2dupchkpsdef = pSDEField;
            }
            return this.no2dupchkpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getNo3DupChkPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo3DupChkPSDEF();
        }
        if (this.getNo3DupChkPSDEFId() == null) {
            return null;
        }
        Integer n = this.objNo3DupChkPSDEFLock;
        synchronized (n) {
            if (this.no3dupchkpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getNo3DupChkPSDEFId(), (Object)this.no3dupchkpsdef.getPSDEFieldId()) != 0L) {
                this.no3dupchkpsdef = null;
            }
            if (this.no3dupchkpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getNo3DupChkPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.no3dupchkpsdef = pSDEField;
            }
            return this.no3dupchkpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getRestrictedPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRestrictedPSDEF();
        }
        if (this.getRestrictedPSDEFId() == null) {
            return null;
        }
        Integer n = this.objRestrictedPSDEFLock;
        synchronized (n) {
            if (this.restrictedpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getRestrictedPSDEFId(), (Object)this.restrictedpsdef.getPSDEFieldId()) != 0L) {
                this.restrictedpsdef = null;
            }
            if (this.restrictedpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getRestrictedPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.restrictedpsdef = pSDEField;
            }
            return this.restrictedpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getValuePSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValuePSDEF();
        }
        if (this.getValuePSDEFId() == null) {
            return null;
        }
        Integer n = this.objValuePSDEFLock;
        synchronized (n) {
            if (this.valuepsdef != null && DataTypeHelper.compare((int)25, (Object)this.getValuePSDEFId(), (Object)this.valuepsdef.getPSDEFieldId()) != 0L) {
                this.valuepsdef = null;
            }
            if (this.valuepsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getValuePSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.valuepsdef = pSDEField;
            }
            return this.valuepsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDER getO2MPSDER() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getO2MPSDER();
        }
        if (this.getO2MPSDERId() == null) {
            return null;
        }
        Integer n = this.objO2MPSDERLock;
        synchronized (n) {
            if (this.o2mpsder != null && DataTypeHelper.compare((int)25, (Object)this.getO2MPSDERId(), (Object)this.o2mpsder.getPSDERId()) != 0L) {
                this.o2mpsder = null;
            }
            if (this.o2mpsder == null) {
                PSDER pSDER = new PSDER();
                pSDER.setPSDERId(this.getO2MPSDERId());
                PSDERService pSDERService = (PSDERService)ServiceGlobal.getService(PSDERService.class, (SessionFactory)this.getSessionFactory());
                pSDERService.autoGet((IEntity)pSDER);
                this.o2mpsder = pSDER;
            }
            return this.o2mpsder;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDER getO2OPSDER() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getO2OPSDER();
        }
        if (this.getO2OPSDERId() == null) {
            return null;
        }
        Integer n = this.objO2OPSDERLock;
        synchronized (n) {
            if (this.o2opsder != null && DataTypeHelper.compare((int)25, (Object)this.getO2OPSDERId(), (Object)this.o2opsder.getPSDERId()) != 0L) {
                this.o2opsder = null;
            }
            if (this.o2opsder == null) {
                PSDER pSDER = new PSDER();
                pSDER.setPSDERId(this.getO2OPSDERId());
                PSDERService pSDERService = (PSDERService)ServiceGlobal.getService(PSDERService.class, (SessionFactory)this.getSessionFactory());
                pSDERService.autoGet((IEntity)pSDER);
                this.o2opsder = pSDER;
            }
            return this.o2opsder;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDER getPSDER() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDER();
        }
        if (this.getPSDERId() == null) {
            return null;
        }
        Integer n = this.objPSDERLock;
        synchronized (n) {
            if (this.psder != null && DataTypeHelper.compare((int)25, (Object)this.getPSDERId(), (Object)this.psder.getPSDERId()) != 0L) {
                this.psder = null;
            }
            if (this.psder == null) {
                PSDER pSDER = new PSDER();
                pSDER.setPSDERId(this.getPSDERId());
                PSDERService pSDERService = (PSDERService)ServiceGlobal.getService(PSDERService.class, (SessionFactory)this.getSessionFactory());
                pSDERService.autoGet((IEntity)pSDER);
                this.psder = pSDER;
            }
            return this.psder;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDETable getPSDETable() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETable();
        }
        if (this.getPSDETableId() == null) {
            return null;
        }
        Integer n = this.objPSDETableLock;
        synchronized (n) {
            if (this.psdetable != null && DataTypeHelper.compare((int)25, (Object)this.getPSDETableId(), (Object)this.psdetable.getPSDETableId()) != 0L) {
                this.psdetable = null;
            }
            if (this.psdetable == null) {
                PSDETable pSDETable = new PSDETable();
                pSDETable.setPSDETableId(this.getPSDETableId());
                PSDETableService pSDETableService = (PSDETableService)ServiceGlobal.getService(PSDETableService.class, (SessionFactory)this.getSessionFactory());
                pSDETableService.autoGet((IEntity)pSDETable);
                this.psdetable = pSDETable;
            }
            return this.psdetable;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguageRes getLNPSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLNPSLanRes();
        }
        if (this.getLNPSLanResId() == null) {
            return null;
        }
        Integer n = this.objLNPSLanResLock;
        synchronized (n) {
            if (this.lnpslanres != null && DataTypeHelper.compare((int)25, (Object)this.getLNPSLanResId(), (Object)this.lnpslanres.getPSLanguageResId()) != 0L) {
                this.lnpslanres = null;
            }
            if (this.lnpslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getLNPSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet((IEntity)pSLanguageRes);
                this.lnpslanres = pSLanguageRes;
            }
            return this.lnpslanres;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSubSysSADEField getPSSubSysSADEField() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysSADEField();
        }
        if (this.getPSSubSysSADEFieldId() == null) {
            return null;
        }
        Integer n = this.objPSSubSysSADEFieldLock;
        synchronized (n) {
            if (this.pssubsyssadefield != null && DataTypeHelper.compare((int)25, (Object)this.getPSSubSysSADEFieldId(), (Object)this.pssubsyssadefield.getPSSubSysSADEFieldId()) != 0L) {
                this.pssubsyssadefield = null;
            }
            if (this.pssubsyssadefield == null) {
                PSSubSysSADEField pSSubSysSADEField = new PSSubSysSADEField();
                pSSubSysSADEField.setPSSubSysSADEFieldId(this.getPSSubSysSADEFieldId());
                PSSubSysSADEFieldService pSSubSysSADEFieldService = (PSSubSysSADEFieldService)ServiceGlobal.getService(PSSubSysSADEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSSubSysSADEFieldService.autoGet((IEntity)pSSubSysSADEField);
                this.pssubsyssadefield = pSSubSysSADEField;
            }
            return this.pssubsyssadefield;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysDBColumn getPSSysDBColumn() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBColumn();
        }
        if (this.getPSSysDBColumnId() == null) {
            return null;
        }
        Integer n = this.objPSSysDBColumnLock;
        synchronized (n) {
            if (this.pssysdbcolumn != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysDBColumnId(), (Object)this.pssysdbcolumn.getPSSysDBColumnId()) != 0L) {
                this.pssysdbcolumn = null;
            }
            if (this.pssysdbcolumn == null) {
                PSSysDBColumn pSSysDBColumn = new PSSysDBColumn();
                pSSysDBColumn.setPSSysDBColumnId(this.getPSSysDBColumnId());
                PSSysDBColumnService pSSysDBColumnService = (PSSysDBColumnService)ServiceGlobal.getService(PSSysDBColumnService.class, (SessionFactory)this.getSessionFactory());
                pSSysDBColumnService.autoGet((IEntity)pSSysDBColumn);
                this.pssysdbcolumn = pSSysDBColumn;
            }
            return this.pssysdbcolumn;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysDynaModel getRefPSSysDynaModel() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSSysDynaModel();
        }
        if (this.getRefPSSysDynaModelId() == null) {
            return null;
        }
        Integer n = this.objRefPSSysDynaModelLock;
        synchronized (n) {
            if (this.refpssysdynamodel != null && DataTypeHelper.compare((int)25, (Object)this.getRefPSSysDynaModelId(), (Object)this.refpssysdynamodel.getPSSysDynaModelId()) != 0L) {
                this.refpssysdynamodel = null;
            }
            if (this.refpssysdynamodel == null) {
                PSSysDynaModel pSSysDynaModel = new PSSysDynaModel();
                pSSysDynaModel.setPSSysDynaModelId(this.getRefPSSysDynaModelId());
                PSSysDynaModelService pSSysDynaModelService = (PSSysDynaModelService)ServiceGlobal.getService(PSSysDynaModelService.class, (SessionFactory)this.getSessionFactory());
                pSSysDynaModelService.autoGet((IEntity)pSSysDynaModel);
                this.refpssysdynamodel = pSSysDynaModel;
            }
            return this.refpssysdynamodel;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysSampleValue getPSSysSampleValue() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSampleValue();
        }
        if (this.getPSSysSampleValueId() == null) {
            return null;
        }
        Integer n = this.objPSSysSampleValueLock;
        synchronized (n) {
            if (this.pssyssamplevalue != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysSampleValueId(), (Object)this.pssyssamplevalue.getPSSysSampleValueId()) != 0L) {
                this.pssyssamplevalue = null;
            }
            if (this.pssyssamplevalue == null) {
                PSSysSampleValue pSSysSampleValue = new PSSysSampleValue();
                pSSysSampleValue.setPSSysSampleValueId(this.getPSSysSampleValueId());
                PSSysSampleValueService pSSysSampleValueService = (PSSysSampleValueService)ServiceGlobal.getService(PSSysSampleValueService.class, (SessionFactory)this.getSessionFactory());
                pSSysSampleValueService.autoGet((IEntity)pSSysSampleValue);
                this.pssyssamplevalue = pSSysSampleValue;
            }
            return this.pssyssamplevalue;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysSequence getPSSysSequence() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSequence();
        }
        if (this.getPSSysSequenceId() == null) {
            return null;
        }
        Integer n = this.objPSSysSequenceLock;
        synchronized (n) {
            if (this.pssyssequence != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysSequenceId(), (Object)this.pssyssequence.getPSSysSequenceId()) != 0L) {
                this.pssyssequence = null;
            }
            if (this.pssyssequence == null) {
                PSSysSequence pSSysSequence = new PSSysSequence();
                pSSysSequence.setPSSysSequenceId(this.getPSSysSequenceId());
                PSSysSequenceService pSSysSequenceService = (PSSysSequenceService)ServiceGlobal.getService(PSSysSequenceService.class, (SessionFactory)this.getSessionFactory());
                pSSysSequenceService.autoGet((IEntity)pSSysSequence);
                this.pssyssequence = pSSysSequence;
            }
            return this.pssyssequence;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysTranslator getExpPSSysTranslator() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExpPSSysTranslator();
        }
        if (this.getExpPSSysTranslatorId() == null) {
            return null;
        }
        Integer n = this.objExpPSSysTranslatorLock;
        synchronized (n) {
            if (this.exppssystranslator != null && DataTypeHelper.compare((int)25, (Object)this.getExpPSSysTranslatorId(), (Object)this.exppssystranslator.getPSSysTranslatorId()) != 0L) {
                this.exppssystranslator = null;
            }
            if (this.exppssystranslator == null) {
                PSSysTranslator pSSysTranslator = new PSSysTranslator();
                pSSysTranslator.setPSSysTranslatorId(this.getExpPSSysTranslatorId());
                PSSysTranslatorService pSSysTranslatorService = (PSSysTranslatorService)ServiceGlobal.getService(PSSysTranslatorService.class, (SessionFactory)this.getSessionFactory());
                pSSysTranslatorService.autoGet((IEntity)pSSysTranslator);
                this.exppssystranslator = pSSysTranslator;
            }
            return this.exppssystranslator;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysTranslator getImpPSSysTranslator() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getImpPSSysTranslator();
        }
        if (this.getImpPSSysTranslatorId() == null) {
            return null;
        }
        Integer n = this.objImpPSSysTranslatorLock;
        synchronized (n) {
            if (this.imppssystranslator != null && DataTypeHelper.compare((int)25, (Object)this.getImpPSSysTranslatorId(), (Object)this.imppssystranslator.getPSSysTranslatorId()) != 0L) {
                this.imppssystranslator = null;
            }
            if (this.imppssystranslator == null) {
                PSSysTranslator pSSysTranslator = new PSSysTranslator();
                pSSysTranslator.setPSSysTranslatorId(this.getImpPSSysTranslatorId());
                PSSysTranslatorService pSSysTranslatorService = (PSSysTranslatorService)ServiceGlobal.getService(PSSysTranslatorService.class, (SessionFactory)this.getSessionFactory());
                pSSysTranslatorService.autoGet((IEntity)pSSysTranslator);
                this.imppssystranslator = pSSysTranslator;
            }
            return this.imppssystranslator;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysTranslator getPSSysTranslator() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTranslator();
        }
        if (this.getPSSysTranslatorId() == null) {
            return null;
        }
        Integer n = this.objPSSysTranslatorLock;
        synchronized (n) {
            if (this.pssystranslator != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysTranslatorId(), (Object)this.pssystranslator.getPSSysTranslatorId()) != 0L) {
                this.pssystranslator = null;
            }
            if (this.pssystranslator == null) {
                PSSysTranslator pSSysTranslator = new PSSysTranslator();
                pSSysTranslator.setPSSysTranslatorId(this.getPSSysTranslatorId());
                PSSysTranslatorService pSSysTranslatorService = (PSSysTranslatorService)ServiceGlobal.getService(PSSysTranslatorService.class, (SessionFactory)this.getSessionFactory());
                pSSysTranslatorService.autoGet((IEntity)pSSysTranslator);
                this.pssystranslator = pSSysTranslator;
            }
            return this.pssystranslator;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysUnit getPSSysUnit() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUnit();
        }
        if (this.getPSSysUnitId() == null) {
            return null;
        }
        Integer n = this.objPSSysUnitLock;
        synchronized (n) {
            if (this.pssysunit != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysUnitId(), (Object)this.pssysunit.getPSSysUnitId()) != 0L) {
                this.pssysunit = null;
            }
            if (this.pssysunit == null) {
                PSSysUnit pSSysUnit = new PSSysUnit();
                pSSysUnit.setPSSysUnitId(this.getPSSysUnitId());
                PSSysUnitService pSSysUnitService = (PSSysUnitService)ServiceGlobal.getService(PSSysUnitService.class, (SessionFactory)this.getSessionFactory());
                pSSysUnitService.autoGet((IEntity)pSSysUnit);
                this.pssysunit = pSSysUnit;
            }
            return this.pssysunit;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysValueRule getPSSysValueRule() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysValueRule();
        }
        if (this.getPSSysValueRuleId() == null) {
            return null;
        }
        Integer n = this.objPSSysValueRuleLock;
        synchronized (n) {
            if (this.pssysvaluerule != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysValueRuleId(), (Object)this.pssysvaluerule.getPSSysValueRuleId()) != 0L) {
                this.pssysvaluerule = null;
            }
            if (this.pssysvaluerule == null) {
                PSSysValueRule pSSysValueRule = new PSSysValueRule();
                pSSysValueRule.setPSSysValueRuleId(this.getPSSysValueRuleId());
                PSSysValueRuleService pSSysValueRuleService = (PSSysValueRuleService)ServiceGlobal.getService(PSSysValueRuleService.class, (SessionFactory)this.getSessionFactory());
                pSSysValueRuleService.autoGet((IEntity)pSSysValueRule);
                this.pssysvaluerule = pSSysValueRule;
            }
            return this.pssysvaluerule;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEFDTCol> getPSDEFDTCols() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFDTCols();
        }
        if (this.getPSDEFieldId() == null) {
            return null;
        }
        PSDEFDTColService pSDEFDTColService = (PSDEFDTColService)ServiceGlobal.getService(PSDEFDTColService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEFDTColsLock;
        synchronized (n) {
            if (this.psdefdtcols == null) {
                this.psdefdtcols = pSDEFDTColService.selectByPSDEF(this);
            }
            return this.psdefdtcols;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEFUIMode> getPSDEFUIModes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFUIModes();
        }
        if (this.getPSDEFieldId() == null) {
            return null;
        }
        PSDEFUIModeService pSDEFUIModeService = (PSDEFUIModeService)ServiceGlobal.getService(PSDEFUIModeService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEFUIModesLock;
        synchronized (n) {
            if (this.psdefuimodes == null) {
                this.psdefuimodes = pSDEFUIModeService.selectByPSDEF(this);
            }
            return this.psdefuimodes;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEField> getPSDEFields() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFields();
        }
        if (this.getPSDEFieldId() == null) {
            return null;
        }
        PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEFieldsLock;
        synchronized (n) {
            if (this.psdefields == null) {
                this.psdefields = pSDEFieldService.selectByDERPSDEF(this);
            }
            return this.psdefields;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEFInputTip> getPSDEFInputTips() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFInputTips();
        }
        if (this.getPSDEFieldId() == null) {
            return null;
        }
        PSDEFInputTipService pSDEFInputTipService = (PSDEFInputTipService)ServiceGlobal.getService(PSDEFInputTipService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEFInputTipsLock;
        synchronized (n) {
            if (this.psdefinputtips == null) {
                this.psdefinputtips = pSDEFInputTipService.selectByPSDEF(this);
            }
            return this.psdefinputtips;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEFSFItem> getPSDEFSFItems() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFSFItems();
        }
        if (this.getPSDEFieldId() == null) {
            return null;
        }
        PSDEFSFItemService pSDEFSFItemService = (PSDEFSFItemService)ServiceGlobal.getService(PSDEFSFItemService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEFSFItemsLock;
        synchronized (n) {
            if (this.psdefsfitems == null) {
                this.psdefsfitems = pSDEFSFItemService.selectByPSDEF(this);
            }
            return this.psdefsfitems;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEFValueRule> getPSDEFValueRules() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFValueRules();
        }
        if (this.getPSDEFieldId() == null) {
            return null;
        }
        PSDEFValueRuleService pSDEFValueRuleService = (PSDEFValueRuleService)ServiceGlobal.getService(PSDEFValueRuleService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEFValueRulesLock;
        synchronized (n) {
            if (this.psdefvaluerules == null) {
                this.psdefvaluerules = pSDEFValueRuleService.selectByPSDEF(this);
            }
            return this.psdefvaluerules;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysTestCase> getPSSysTestCases() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTestCases();
        }
        if (this.getPSDEFieldId() == null) {
            return null;
        }
        PSSysTestCaseService pSSysTestCaseService = (PSSysTestCaseService)ServiceGlobal.getService(PSSysTestCaseService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysTestCasesLock;
        synchronized (n) {
            if (this.pssystestcases == null) {
                this.pssystestcases = pSSysTestCaseService.selectByPSDEF(this);
            }
            return this.pssystestcases;
        }
    }

    private PSDEFieldBase getProxyEntity() {
        return this.proxyPSDEFieldBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEFieldBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEFieldBase) {
            this.proxyPSDEFieldBase = (PSDEFieldBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ALLOWEMPTY, 0);
        fieldIndexMap.put(FIELD_AUDITINFOFORMAT, 1);
        fieldIndexMap.put(FIELD_BIZTAG, 2);
        fieldIndexMap.put(FIELD_CHECKRECURSION, 3);
        fieldIndexMap.put(FIELD_CODENAME, 4);
        fieldIndexMap.put(FIELD_COMPUTEEXP, 5);
        fieldIndexMap.put(FIELD_CREATEDATE, 6);
        fieldIndexMap.put(FIELD_CREATEMAN, 7);
        fieldIndexMap.put(FIELD_CUSTOMEXPORTSCOPE, 8);
        fieldIndexMap.put(FIELD_DBVALUEMODE, 9);
        fieldIndexMap.put(FIELD_DBVALUEMODE2, 10);
        fieldIndexMap.put(FIELD_DEFAULTVALUE, 11);
        fieldIndexMap.put(FIELD_DEFTYPE, 12);
        fieldIndexMap.put(FIELD_DERPSDEFID, 13);
        fieldIndexMap.put(FIELD_DERPSDEFNAME, 14);
        fieldIndexMap.put(FIELD_DUPCHECKMODE, 15);
        fieldIndexMap.put(FIELD_DUPCHECKVALUES, 16);
        fieldIndexMap.put(FIELD_DUPCHECKPSDEFID, 17);
        fieldIndexMap.put(FIELD_DUPCHECKPSDEFNAME, 18);
        fieldIndexMap.put(FIELD_DEFAULTVALUETYPE, 19);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 20);
        fieldIndexMap.put(FIELD_ENABLEAUDIT, 21);
        fieldIndexMap.put(FIELD_ENABLECOLPRIV, 22);
        fieldIndexMap.put(FIELD_ENABLEQS, 23);
        fieldIndexMap.put(FIELD_ENABLETEMPDATA, 24);
        fieldIndexMap.put(FIELD_ENABLEUSERINPUT, 25);
        fieldIndexMap.put(FIELD_ENAWRITEBACK, 26);
        fieldIndexMap.put(FIELD_EXPORTSCOPE, 27);
        fieldIndexMap.put(FIELD_EXPPSSYSTRANSLATORID, 28);
        fieldIndexMap.put(FIELD_EXPPSSYSTRANSLATORNAME, 29);
        fieldIndexMap.put(FIELD_EXTENDMODE, 30);
        fieldIndexMap.put(FIELD_FIELDHOLDER, 31);
        fieldIndexMap.put(FIELD_FIELDTAG, 32);
        fieldIndexMap.put(FIELD_FIELDTAG2, 33);
        fieldIndexMap.put(FIELD_FKEY, 34);
        fieldIndexMap.put(FIELD_FORMULAFIELDS, 35);
        fieldIndexMap.put(FIELD_FORMULAFORMAT, 36);
        fieldIndexMap.put(FIELD_IMPORTKEY, 37);
        fieldIndexMap.put(FIELD_IMPORTORDER, 38);
        fieldIndexMap.put(FIELD_IMPORTTAG, 39);
        fieldIndexMap.put(FIELD_IMPPSSYSTRANSLATORID, 40);
        fieldIndexMap.put(FIELD_IMPPSSYSTRANSLATORNAME, 41);
        fieldIndexMap.put(FIELD_INDEXTYPE, 42);
        fieldIndexMap.put(FIELD_JSFORMAT, 43);
        fieldIndexMap.put(FIELD_JSONFORMAT, 44);
        fieldIndexMap.put(FIELD_LENGTH, 45);
        fieldIndexMap.put(FIELD_LNPSLANRESID, 46);
        fieldIndexMap.put(FIELD_LNPSLANRESNAME, 47);
        fieldIndexMap.put(FIELD_LOCKFLAG, 48);
        fieldIndexMap.put(FIELD_LOGICNAME, 49);
        fieldIndexMap.put(FIELD_MAJORFIELD, 50);
        fieldIndexMap.put(FIELD_MAXVALUE, 51);
        fieldIndexMap.put(FIELD_MEMO, 52);
        fieldIndexMap.put(FIELD_MINSTRLENGTH, 53);
        fieldIndexMap.put(FIELD_MINVALUE, 54);
        fieldIndexMap.put(FIELD_MULTIFORMFIELD, 55);
        fieldIndexMap.put(FIELD_NO2DUPCHKPSDEFID, 56);
        fieldIndexMap.put(FIELD_NO2DUPCHKPSDEFNAME, 57);
        fieldIndexMap.put(FIELD_NO3DUPCHKPSDEFID, 58);
        fieldIndexMap.put(FIELD_NO3DUPCHKPSDEFNAME, 59);
        fieldIndexMap.put(FIELD_NULLVALORDER, 60);
        fieldIndexMap.put(FIELD_O2MPSDERID, 61);
        fieldIndexMap.put(FIELD_O2MPSDERNAME, 62);
        fieldIndexMap.put(FIELD_O2OPSDERID, 63);
        fieldIndexMap.put(FIELD_O2OPSDERNAME, 64);
        fieldIndexMap.put(FIELD_ORDERVALUE, 65);
        fieldIndexMap.put(FIELD_PASTERESET, 66);
        fieldIndexMap.put(FIELD_PHYSICALFIELD, 67);
        fieldIndexMap.put(FIELD_PKEY, 68);
        fieldIndexMap.put(FIELD_PRECISION2, 69);
        fieldIndexMap.put(FIELD_PREDEFINEDTYPEPARAM, 70);
        fieldIndexMap.put(FIELD_PREDEFINETYPE, 71);
        fieldIndexMap.put(FIELD_PSCODELISTID, 72);
        fieldIndexMap.put(FIELD_PSCODELISTNAME, 73);
        fieldIndexMap.put(FIELD_PSDATATYPEID, 74);
        fieldIndexMap.put(FIELD_PSDATATYPENAME, 75);
        fieldIndexMap.put(FIELD_PSDEFDTCOLSCNT, 76);
        fieldIndexMap.put(FIELD_PSDEFIELDID, 77);
        fieldIndexMap.put(FIELD_PSDEFIELDNAME, 78);
        fieldIndexMap.put(FIELD_PSDEFIELDSCNT, 79);
        fieldIndexMap.put(FIELD_PSDEFINPUTTIPSCNT, 80);
        fieldIndexMap.put(FIELD_PSDEFSFITEMSCNT, 81);
        fieldIndexMap.put(FIELD_PSDEFUIMODESCNT, 82);
        fieldIndexMap.put(FIELD_PSDEFVALUERULESCNT, 83);
        fieldIndexMap.put(FIELD_PSDEID, 84);
        fieldIndexMap.put(FIELD_PSDENAME, 85);
        fieldIndexMap.put(FIELD_PSDERID, 86);
        fieldIndexMap.put(FIELD_PSDERNAME, 87);
        fieldIndexMap.put(FIELD_PSDETABLEID, 88);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 89);
        fieldIndexMap.put(FIELD_PSSUBSYSSADEFIELDID, 90);
        fieldIndexMap.put(FIELD_PSSUBSYSSADEFIELDNAME, 91);
        fieldIndexMap.put(FIELD_PSSUBSYSSADEID, 92);
        fieldIndexMap.put(FIELD_PSSYSDBCOLUMNID, 93);
        fieldIndexMap.put(FIELD_PSSYSSAMPLEVALUEID, 94);
        fieldIndexMap.put(FIELD_PSSYSSAMPLEVALUENAME, 95);
        fieldIndexMap.put(FIELD_PSSYSSEQUENCEID, 96);
        fieldIndexMap.put(FIELD_PSSYSSEQUENCENAME, 97);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 98);
        fieldIndexMap.put(FIELD_PSSYSTESTCASESCNT, 99);
        fieldIndexMap.put(FIELD_PSSYSTRANSLATORID, 100);
        fieldIndexMap.put(FIELD_PSSYSTRANSLATORNAME, 101);
        fieldIndexMap.put(FIELD_PSSYSUNITID, 102);
        fieldIndexMap.put(FIELD_PSSYSUNITNAME, 103);
        fieldIndexMap.put(FIELD_PSSYSVALUERULEID, 104);
        fieldIndexMap.put(FIELD_PSSYSVALUERULENAME, 105);
        fieldIndexMap.put(FIELD_QUERYCOLUMN, 106);
        fieldIndexMap.put(FIELD_QUERYCS, 107);
        fieldIndexMap.put(FIELD_READONLYMODE, 108);
        fieldIndexMap.put(FIELD_REFPSSYSDYNAMODELID, 109);
        fieldIndexMap.put(FIELD_REFPSSYSDYNAMODELNAME, 110);
        fieldIndexMap.put(FIELD_RESTRICTEDPSDEFID, 111);
        fieldIndexMap.put(FIELD_RESTRICTEDPSDEFNAME, 112);
        fieldIndexMap.put(FIELD_SEQUENCEMODE, 113);
        fieldIndexMap.put(FIELD_SERVICECODENAME, 114);
        fieldIndexMap.put(FIELD_STATEFIELD, 115);
        fieldIndexMap.put(FIELD_STDDATATYPE, 116);
        fieldIndexMap.put(FIELD_STRINGCASE, 117);
        fieldIndexMap.put(FIELD_STRLENGTH, 118);
        fieldIndexMap.put(FIELD_TABLENAME, 119);
        fieldIndexMap.put(FIELD_TABLESCOPE, 120);
        fieldIndexMap.put(FIELD_TESTDATA, 121);
        fieldIndexMap.put(FIELD_TRANSLATORMODE, 122);
        fieldIndexMap.put(FIELD_UNICODECHAR, 123);
        fieldIndexMap.put(FIELD_UNIONKEYVALUE, 124);
        fieldIndexMap.put(FIELD_UNIT, 125);
        fieldIndexMap.put(FIELD_UNITWIDTH, 126);
        fieldIndexMap.put(FIELD_UPDATEDATE, 127);
        fieldIndexMap.put(FIELD_UPDATEMAN, 128);
        fieldIndexMap.put(FIELD_UPDATEOVMODE, 129);
        fieldIndexMap.put(FIELD_USERCAT, 130);
        fieldIndexMap.put(FIELD_USERPARAMS, 131);
        fieldIndexMap.put(FIELD_USERTAG, 132);
        fieldIndexMap.put(FIELD_USERTAG2, 133);
        fieldIndexMap.put(FIELD_USERTAG3, 134);
        fieldIndexMap.put(FIELD_USERTAG4, 135);
        fieldIndexMap.put(FIELD_VALIDFLAG, 136);
        fieldIndexMap.put(FIELD_VALUEFORMAT, 137);
        fieldIndexMap.put(FIELD_VALUEPSDEFID, 138);
        fieldIndexMap.put(FIELD_VALUEPSDEFNAME, 139);
        fieldIndexMap.put(FIELD_VIEWCOLLEVEL, 140);
    }
}

