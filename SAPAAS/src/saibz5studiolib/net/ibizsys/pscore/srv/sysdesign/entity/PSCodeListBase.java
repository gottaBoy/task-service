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
package net.ibizsys.pscore.srv.sysdesign.entity;

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
import net.ibizsys.pscore.srv.config.entity.PSCodeListTempl;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.service.PSCodeListTemplService;
import net.ibizsys.pscore.srv.config.service.PSSysPFPluginService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaCodeList;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaInst;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaCodeListService;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaInstService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSCodeListBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSCodeListBase.class);
    public static final String FIELD_ALLTEXT = "ALLTEXT";
    public static final String FIELD_ALLTEXTPSLANRESID = "ALLTEXTPSLANRESID";
    public static final String FIELD_ALLTEXTPSLANRESNAME = "ALLTEXTPSLANRESNAME";
    public static final String FIELD_BEGINVALUEPSDEFID = "BEGINVALUEPSDEFID";
    public static final String FIELD_BEGINVALUEPSDEFNAME = "BEGINVALUEPSDEFNAME";
    public static final String FIELD_BKCOLORPSDEFID = "BKCOLORPSDEFID";
    public static final String FIELD_BKCOLORPSDEFNAME = "BKCOLORPSDEFNAME";
    public static final String FIELD_CACHECAT = "CACHECAT";
    public static final String FIELD_CACHETAG = "CACHETAG";
    public static final String FIELD_CACHETIMEOUT = "CACHETIMEOUT";
    public static final String FIELD_CLMODEL = "CLMODEL";
    public static final String FIELD_CLSPSDEFID = "CLSPSDEFID";
    public static final String FIELD_CLSPSDEFNAME = "CLSPSDEFNAME";
    public static final String FIELD_CLTYPE = "CLTYPE";
    public static final String FIELD_CODEITEMTAG = "CODEITEMTAG";
    public static final String FIELD_CODELISTSN = "CODELISTSN";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_COLORPSDEFID = "COLORPSDEFID";
    public static final String FIELD_COLORPSDEFNAME = "COLORPSDEFNAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMCOND = "CUSTOMCOND";
    public static final String FIELD_CUSTOMTYPE = "CUSTOMTYPE";
    public static final String FIELD_DATAPSDEFID = "DATAPSDEFID";
    public static final String FIELD_DATAPSDEFNAME = "DATAPSDEFNAME";
    public static final String FIELD_DISABLEPSDEFID = "DISABLEPSDEFID";
    public static final String FIELD_DISABLEPSDEFNAME = "DISABLEPSDEFNAME";
    public static final String FIELD_DSCONDITIONS = "DSCONDITIONS";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_DYNASYSREFMODE = "DYNASYSREFMODE";
    public static final String FIELD_EMPTYTEXT = "EMPTYTEXT";
    public static final String FIELD_EMPTYTEXTPSLANRESID = "EMPTYTEXTPSLANRESID";
    public static final String FIELD_EMPTYTEXTPSLANRESNAME = "EMPTYTEXTPSLANRESNAME";
    public static final String FIELD_ENABLECACHE = "ENABLECACHE";
    public static final String FIELD_ENABLEDYNASYS = "ENABLEDYNASYS";
    public static final String FIELD_ENDVALUEPSDEFID = "ENDVALUEPSDEFID";
    public static final String FIELD_ENDVALUEPSDEFNAME = "ENDVALUEPSDEFNAME";
    public static final String FIELD_EXTENDMODE = "EXTENDMODE";
    public static final String FIELD_ICONCLSPSDEFID = "ICONCLSPSDEFID";
    public static final String FIELD_ICONCLSPSDEFNAME = "ICONCLSPSDEFNAME";
    public static final String FIELD_ICONCLSXPSDEFID = "ICONCLSXPSDEFID";
    public static final String FIELD_ICONCLSXPSDEFNAME = "ICONCLSXPSDEFNAME";
    public static final String FIELD_ICONPATHPSDEFID = "ICONPATHPSDEFID";
    public static final String FIELD_ICONPATHPSDEFNAME = "ICONPATHPSDEFNAME";
    public static final String FIELD_ICONPATHXPSDEFID = "ICONPATHXPSDEFID";
    public static final String FIELD_ICONPATHXPSDEFNAME = "ICONPATHXPSDEFNAME";
    public static final String FIELD_INCBEGINVALUE = "INCBEGINVALUE";
    public static final String FIELD_INCENDVALUE = "INCENDVALUE";
    public static final String FIELD_LINKPSDEVIEWID = "LINKPSDEVIEWID";
    public static final String FIELD_LINKPSDEVIEWNAME = "LINKPSDEVIEWNAME";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MINORSORTDIR = "MINORSORTDIR";
    public static final String FIELD_MINORSORTPSDEFID = "MINORSORTPSDEFID";
    public static final String FIELD_MINORSORTPSDEFNAME = "MINORSORTPSDEFNAME";
    public static final String FIELD_MODCOLOR = "MODCOLOR";
    public static final String FIELD_NOVALUEEMPTY = "NOVALUEEMPTY";
    public static final String FIELD_NUMBERITEM = "NUMBERITEM";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_ORMODE = "ORMODE";
    public static final String FIELD_PREDEFINEDTYPE = "PREDEFINEDTYPE";
    public static final String FIELD_PSCODELISTID = "PSCODELISTID";
    public static final String FIELD_PSCODELISTNAME = "PSCODELISTNAME";
    public static final String FIELD_PSCODELISTTEMPLID = "PSCODELISTTEMPLID";
    public static final String FIELD_PSCODELISTTEMPLNAME = "PSCODELISTTEMPLNAME";
    public static final String FIELD_PSDEDSID = "PSDEDSID";
    public static final String FIELD_PSDEDSNAME = "PSDEDSNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDEMSLOGICID = "PSDEMSLOGICID";
    public static final String FIELD_PSDEMSLOGICNAME = "PSDEMSLOGICNAME";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDYNACODELISTID = "PSDYNACODELISTID";
    public static final String FIELD_PSDYNACODELISTNAME = "PSDYNACODELISTNAME";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSDYNAINSTNAME = "PSDYNAINSTNAME";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String FIELD_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String FIELD_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String FIELD_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String FIELD_PSSYSREQITEMID = "PSSYSREQITEMID";
    public static final String FIELD_PSSYSREQITEMNAME = "PSSYSREQITEMNAME";
    public static final String FIELD_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String FIELD_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_PVALUEPSDEFID = "PVALUEPSDEFID";
    public static final String FIELD_PVALUEPSDEFNAME = "PVALUEPSDEFNAME";
    public static final String FIELD_SEPERATOR = "SEPERATOR";
    public static final String FIELD_SRFSYSPUB = "SRFSYSPUB";
    public static final String FIELD_SYSREFFLAG = "SYSREFFLAG";
    public static final String FIELD_TEXTPSDEFID = "TEXTPSDEFID";
    public static final String FIELD_TEXTPSDEFNAME = "TEXTPSDEFNAME";
    public static final String FIELD_THRESHOLDGROUPFLAG = "THRESHOLDGROUPFLAG";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERDATA = "USERDATA";
    public static final String FIELD_USERDATA2 = "USERDATA2";
    public static final String FIELD_USERPARAMS = "USERPARAMS";
    public static final String FIELD_USERREFFLAG = "USERREFFLAG";
    public static final String FIELD_USERSCOPE = "USERSCOPE";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    public static final String FIELD_VALUEPSDEFID = "VALUEPSDEFID";
    public static final String FIELD_VALUEPSDEFNAME = "VALUEPSDEFNAME";
    public static final String FIELD_VALUESEPERATOR = "VALUESEPERATOR";
    private static final int INDEX_ALLTEXT = 0;
    private static final int INDEX_ALLTEXTPSLANRESID = 1;
    private static final int INDEX_ALLTEXTPSLANRESNAME = 2;
    private static final int INDEX_BEGINVALUEPSDEFID = 3;
    private static final int INDEX_BEGINVALUEPSDEFNAME = 4;
    private static final int INDEX_BKCOLORPSDEFID = 5;
    private static final int INDEX_BKCOLORPSDEFNAME = 6;
    private static final int INDEX_CACHECAT = 7;
    private static final int INDEX_CACHETAG = 8;
    private static final int INDEX_CACHETIMEOUT = 9;
    private static final int INDEX_CLMODEL = 10;
    private static final int INDEX_CLSPSDEFID = 11;
    private static final int INDEX_CLSPSDEFNAME = 12;
    private static final int INDEX_CLTYPE = 13;
    private static final int INDEX_CODEITEMTAG = 14;
    private static final int INDEX_CODELISTSN = 15;
    private static final int INDEX_CODENAME = 16;
    private static final int INDEX_COLORPSDEFID = 17;
    private static final int INDEX_COLORPSDEFNAME = 18;
    private static final int INDEX_CREATEDATE = 19;
    private static final int INDEX_CREATEMAN = 20;
    private static final int INDEX_CUSTOMCOND = 21;
    private static final int INDEX_CUSTOMTYPE = 22;
    private static final int INDEX_DATAPSDEFID = 23;
    private static final int INDEX_DATAPSDEFNAME = 24;
    private static final int INDEX_DISABLEPSDEFID = 25;
    private static final int INDEX_DISABLEPSDEFNAME = 26;
    private static final int INDEX_DSCONDITIONS = 27;
    private static final int INDEX_DYNAMODELFLAG = 28;
    private static final int INDEX_DYNASYSREFMODE = 29;
    private static final int INDEX_EMPTYTEXT = 30;
    private static final int INDEX_EMPTYTEXTPSLANRESID = 31;
    private static final int INDEX_EMPTYTEXTPSLANRESNAME = 32;
    private static final int INDEX_ENABLECACHE = 33;
    private static final int INDEX_ENABLEDYNASYS = 34;
    private static final int INDEX_ENDVALUEPSDEFID = 35;
    private static final int INDEX_ENDVALUEPSDEFNAME = 36;
    private static final int INDEX_EXTENDMODE = 37;
    private static final int INDEX_ICONCLSPSDEFID = 38;
    private static final int INDEX_ICONCLSPSDEFNAME = 39;
    private static final int INDEX_ICONCLSXPSDEFID = 40;
    private static final int INDEX_ICONCLSXPSDEFNAME = 41;
    private static final int INDEX_ICONPATHPSDEFID = 42;
    private static final int INDEX_ICONPATHPSDEFNAME = 43;
    private static final int INDEX_ICONPATHXPSDEFID = 44;
    private static final int INDEX_ICONPATHXPSDEFNAME = 45;
    private static final int INDEX_INCBEGINVALUE = 46;
    private static final int INDEX_INCENDVALUE = 47;
    private static final int INDEX_LINKPSDEVIEWID = 48;
    private static final int INDEX_LINKPSDEVIEWNAME = 49;
    private static final int INDEX_LOCKFLAG = 50;
    private static final int INDEX_MEMO = 51;
    private static final int INDEX_MINORSORTDIR = 52;
    private static final int INDEX_MINORSORTPSDEFID = 53;
    private static final int INDEX_MINORSORTPSDEFNAME = 54;
    private static final int INDEX_MODCOLOR = 55;
    private static final int INDEX_NOVALUEEMPTY = 56;
    private static final int INDEX_NUMBERITEM = 57;
    private static final int INDEX_ORDERVALUE = 58;
    private static final int INDEX_ORMODE = 59;
    private static final int INDEX_PREDEFINEDTYPE = 60;
    private static final int INDEX_PSCODELISTID = 61;
    private static final int INDEX_PSCODELISTNAME = 62;
    private static final int INDEX_PSCODELISTTEMPLID = 63;
    private static final int INDEX_PSCODELISTTEMPLNAME = 64;
    private static final int INDEX_PSDEDSID = 65;
    private static final int INDEX_PSDEDSNAME = 66;
    private static final int INDEX_PSDEID = 67;
    private static final int INDEX_PSDEMSLOGICID = 68;
    private static final int INDEX_PSDEMSLOGICNAME = 69;
    private static final int INDEX_PSDENAME = 70;
    private static final int INDEX_PSDYNACODELISTID = 71;
    private static final int INDEX_PSDYNACODELISTNAME = 72;
    private static final int INDEX_PSDYNAINSTID = 73;
    private static final int INDEX_PSDYNAINSTNAME = 74;
    private static final int INDEX_PSMODULEID = 75;
    private static final int INDEX_PSMODULENAME = 76;
    private static final int INDEX_PSSYSDYNAMODELID = 77;
    private static final int INDEX_PSSYSDYNAMODELNAME = 78;
    private static final int INDEX_PSSYSPFPLUGINID = 79;
    private static final int INDEX_PSSYSPFPLUGINNAME = 80;
    private static final int INDEX_PSSYSREQITEMID = 81;
    private static final int INDEX_PSSYSREQITEMNAME = 82;
    private static final int INDEX_PSSYSSFPLUGINID = 83;
    private static final int INDEX_PSSYSSFPLUGINNAME = 84;
    private static final int INDEX_PSSYSTEMID = 85;
    private static final int INDEX_PSSYSTEMNAME = 86;
    private static final int INDEX_PVALUEPSDEFID = 87;
    private static final int INDEX_PVALUEPSDEFNAME = 88;
    private static final int INDEX_SEPERATOR = 89;
    private static final int INDEX_SRFSYSPUB = 90;
    private static final int INDEX_SYSREFFLAG = 91;
    private static final int INDEX_TEXTPSDEFID = 92;
    private static final int INDEX_TEXTPSDEFNAME = 93;
    private static final int INDEX_THRESHOLDGROUPFLAG = 94;
    private static final int INDEX_UPDATEDATE = 95;
    private static final int INDEX_UPDATEMAN = 96;
    private static final int INDEX_USERCAT = 97;
    private static final int INDEX_USERDATA = 98;
    private static final int INDEX_USERDATA2 = 99;
    private static final int INDEX_USERPARAMS = 100;
    private static final int INDEX_USERREFFLAG = 101;
    private static final int INDEX_USERSCOPE = 102;
    private static final int INDEX_USERTAG = 103;
    private static final int INDEX_USERTAG2 = 104;
    private static final int INDEX_USERTAG3 = 105;
    private static final int INDEX_USERTAG4 = 106;
    private static final int INDEX_VALIDFLAG = 107;
    private static final int INDEX_VALUEPSDEFID = 108;
    private static final int INDEX_VALUEPSDEFNAME = 109;
    private static final int INDEX_VALUESEPERATOR = 110;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSCodeListBase proxyPSCodeListBase = null;
    private boolean alltextDirtyFlag = false;
    private boolean alltextpslanresidDirtyFlag = false;
    private boolean alltextpslanresnameDirtyFlag = false;
    private boolean beginvaluepsdefidDirtyFlag = false;
    private boolean beginvaluepsdefnameDirtyFlag = false;
    private boolean bkcolorpsdefidDirtyFlag = false;
    private boolean bkcolorpsdefnameDirtyFlag = false;
    private boolean cachecatDirtyFlag = false;
    private boolean cachetagDirtyFlag = false;
    private boolean cachetimeoutDirtyFlag = false;
    private boolean clmodelDirtyFlag = false;
    private boolean clspsdefidDirtyFlag = false;
    private boolean clspsdefnameDirtyFlag = false;
    private boolean cltypeDirtyFlag = false;
    private boolean codeitemtagDirtyFlag = false;
    private boolean codelistsnDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean colorpsdefidDirtyFlag = false;
    private boolean colorpsdefnameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customcondDirtyFlag = false;
    private boolean customtypeDirtyFlag = false;
    private boolean datapsdefidDirtyFlag = false;
    private boolean datapsdefnameDirtyFlag = false;
    private boolean disablepsdefidDirtyFlag = false;
    private boolean disablepsdefnameDirtyFlag = false;
    private boolean dsconditionsDirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean dynasysrefmodeDirtyFlag = false;
    private boolean emptytextDirtyFlag = false;
    private boolean emptytextpslanresidDirtyFlag = false;
    private boolean emptytextpslanresnameDirtyFlag = false;
    private boolean enablecacheDirtyFlag = false;
    private boolean enabledynasysDirtyFlag = false;
    private boolean endvaluepsdefidDirtyFlag = false;
    private boolean endvaluepsdefnameDirtyFlag = false;
    private boolean extendmodeDirtyFlag = false;
    private boolean iconclspsdefidDirtyFlag = false;
    private boolean iconclspsdefnameDirtyFlag = false;
    private boolean iconclsxpsdefidDirtyFlag = false;
    private boolean iconclsxpsdefnameDirtyFlag = false;
    private boolean iconpathpsdefidDirtyFlag = false;
    private boolean iconpathpsdefnameDirtyFlag = false;
    private boolean iconpathxpsdefidDirtyFlag = false;
    private boolean iconpathxpsdefnameDirtyFlag = false;
    private boolean incbeginvalueDirtyFlag = false;
    private boolean incendvalueDirtyFlag = false;
    private boolean linkpsdeviewidDirtyFlag = false;
    private boolean linkpsdeviewnameDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean minorsortdirDirtyFlag = false;
    private boolean minorsortpsdefidDirtyFlag = false;
    private boolean minorsortpsdefnameDirtyFlag = false;
    private boolean modcolorDirtyFlag = false;
    private boolean novalueemptyDirtyFlag = false;
    private boolean numberitemDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean ormodeDirtyFlag = false;
    private boolean predefinedtypeDirtyFlag = false;
    private boolean pscodelistidDirtyFlag = false;
    private boolean pscodelistnameDirtyFlag = false;
    private boolean pscodelisttemplidDirtyFlag = false;
    private boolean pscodelisttemplnameDirtyFlag = false;
    private boolean psdedsidDirtyFlag = false;
    private boolean psdedsnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdemslogicidDirtyFlag = false;
    private boolean psdemslogicnameDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psdynacodelistidDirtyFlag = false;
    private boolean psdynacodelistnameDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean psdynainstnameDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssysdynamodelidDirtyFlag = false;
    private boolean pssysdynamodelnameDirtyFlag = false;
    private boolean pssyspfpluginidDirtyFlag = false;
    private boolean pssyspfpluginnameDirtyFlag = false;
    private boolean pssysreqitemidDirtyFlag = false;
    private boolean pssysreqitemnameDirtyFlag = false;
    private boolean pssyssfpluginidDirtyFlag = false;
    private boolean pssyssfpluginnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean pvaluepsdefidDirtyFlag = false;
    private boolean pvaluepsdefnameDirtyFlag = false;
    private boolean seperatorDirtyFlag = false;
    private boolean srfsyspubDirtyFlag = false;
    private boolean sysrefflagDirtyFlag = false;
    private boolean textpsdefidDirtyFlag = false;
    private boolean textpsdefnameDirtyFlag = false;
    private boolean thresholdgroupflagDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean userdataDirtyFlag = false;
    private boolean userdata2DirtyFlag = false;
    private boolean userparamsDirtyFlag = false;
    private boolean userrefflagDirtyFlag = false;
    private boolean userscopeDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    private boolean valuepsdefidDirtyFlag = false;
    private boolean valuepsdefnameDirtyFlag = false;
    private boolean valueseperatorDirtyFlag = false;
    @Column(name="alltext")
    private String alltext;
    @Column(name="alltextpslanresid")
    private String alltextpslanresid;
    @Column(name="alltextpslanresname")
    private String alltextpslanresname;
    @Column(name="beginvaluepsdefid")
    private String beginvaluepsdefid;
    @Column(name="beginvaluepsdefname")
    private String beginvaluepsdefname;
    @Column(name="bkcolorpsdefid")
    private String bkcolorpsdefid;
    @Column(name="bkcolorpsdefname")
    private String bkcolorpsdefname;
    @Column(name="cachecat")
    private String cachecat;
    @Column(name="cachetag")
    private String cachetag;
    @Column(name="cachetimeout")
    private Integer cachetimeout;
    @Column(name="clmodel")
    private String clmodel;
    @Column(name="clspsdefid")
    private String clspsdefid;
    @Column(name="clspsdefname")
    private String clspsdefname;
    @Column(name="cltype")
    private String cltype;
    @Column(name="codeitemtag")
    private String codeitemtag;
    @Column(name="codelistsn")
    private String codelistsn;
    @Column(name="codename")
    private String codename;
    @Column(name="colorpsdefid")
    private String colorpsdefid;
    @Column(name="colorpsdefname")
    private String colorpsdefname;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="customcond")
    private String customcond;
    @Column(name="customtype")
    private String customtype;
    @Column(name="datapsdefid")
    private String datapsdefid;
    @Column(name="datapsdefname")
    private String datapsdefname;
    @Column(name="disablepsdefid")
    private String disablepsdefid;
    @Column(name="disablepsdefname")
    private String disablepsdefname;
    @Column(name="dsconditions")
    private String dsconditions;
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="dynasysrefmode")
    private Integer dynasysrefmode;
    @Column(name="emptytext")
    private String emptytext;
    @Column(name="emptytextpslanresid")
    private String emptytextpslanresid;
    @Column(name="emptytextpslanresname")
    private String emptytextpslanresname;
    @Column(name="enablecache")
    private Integer enablecache;
    @Column(name="enabledynasys")
    private Integer enabledynasys;
    @Column(name="endvaluepsdefid")
    private String endvaluepsdefid;
    @Column(name="endvaluepsdefname")
    private String endvaluepsdefname;
    @Column(name="extendmode")
    private Integer extendmode;
    @Column(name="iconclspsdefid")
    private String iconclspsdefid;
    @Column(name="iconclspsdefname")
    private String iconclspsdefname;
    @Column(name="iconclsxpsdefid")
    private String iconclsxpsdefid;
    @Column(name="iconclsxpsdefname")
    private String iconclsxpsdefname;
    @Column(name="iconpathpsdefid")
    private String iconpathpsdefid;
    @Column(name="iconpathpsdefname")
    private String iconpathpsdefname;
    @Column(name="iconpathxpsdefid")
    private String iconpathxpsdefid;
    @Column(name="iconpathxpsdefname")
    private String iconpathxpsdefname;
    @Column(name="incbeginvalue")
    private Integer incbeginvalue;
    @Column(name="incendvalue")
    private Integer incendvalue;
    @Column(name="linkpsdeviewid")
    private String linkpsdeviewid;
    @Column(name="linkpsdeviewname")
    private String linkpsdeviewname;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="memo")
    private String memo;
    @Column(name="minorsortdir")
    private String minorsortdir;
    @Column(name="minorsortpsdefid")
    private String minorsortpsdefid;
    @Column(name="minorsortpsdefname")
    private String minorsortpsdefname;
    @Column(name="modcolor")
    private String modcolor;
    @Column(name="novalueempty")
    private Integer novalueempty;
    @Column(name="numberitem")
    private Integer numberitem;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="ormode")
    private String ormode;
    @Column(name="predefinedtype")
    private String predefinedtype;
    @Column(name="pscodelistid")
    private String pscodelistid;
    @Column(name="pscodelistname")
    private String pscodelistname;
    @Column(name="pscodelisttemplid")
    private String pscodelisttemplid;
    @Column(name="pscodelisttemplname")
    private String pscodelisttemplname;
    @Column(name="psdedsid")
    private String psdedsid;
    @Column(name="psdedsname")
    private String psdedsname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdemslogicid")
    private String psdemslogicid;
    @Column(name="psdemslogicname")
    private String psdemslogicname;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psdynacodelistid")
    private String psdynacodelistid;
    @Column(name="psdynacodelistname")
    private String psdynacodelistname;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="psdynainstname")
    private String psdynainstname;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssysdynamodelid")
    private String pssysdynamodelid;
    @Column(name="pssysdynamodelname")
    private String pssysdynamodelname;
    @Column(name="pssyspfpluginid")
    private String pssyspfpluginid;
    @Column(name="pssyspfpluginname")
    private String pssyspfpluginname;
    @Column(name="pssysreqitemid")
    private String pssysreqitemid;
    @Column(name="pssysreqitemname")
    private String pssysreqitemname;
    @Column(name="pssyssfpluginid")
    private String pssyssfpluginid;
    @Column(name="pssyssfpluginname")
    private String pssyssfpluginname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="pvaluepsdefid")
    private String pvaluepsdefid;
    @Column(name="pvaluepsdefname")
    private String pvaluepsdefname;
    @Column(name="seperator")
    private String seperator;
    @Column(name="srfsyspub")
    private Integer srfsyspub;
    @Column(name="sysrefflag")
    private Integer sysrefflag;
    @Column(name="textpsdefid")
    private String textpsdefid;
    @Column(name="textpsdefname")
    private String textpsdefname;
    @Column(name="thresholdgroupflag")
    private Integer thresholdgroupflag;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usercat")
    private String usercat;
    @Column(name="userdata")
    private String userdata;
    @Column(name="userdata2")
    private String userdata2;
    @Column(name="userparams")
    private String userparams;
    @Column(name="userrefflag")
    private Integer userrefflag;
    @Column(name="userscope")
    private Integer userscope;
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
    @Column(name="valuepsdefid")
    private String valuepsdefid;
    @Column(name="valuepsdefname")
    private String valuepsdefname;
    @Column(name="valueseperator")
    private String valueseperator;
    private Integer objPSCodeListTemplLock = new Integer(1);
    private PSCodeListTempl pscodelisttempl = null;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objPSDEDSLock = new Integer(1);
    private PSDEDataSet psdeds = null;
    private Integer objBeginValuePSDEFLock = new Integer(1);
    private PSDEField beginvaluepsdef = null;
    private Integer objBKColorPSDEFLock = new Integer(1);
    private PSDEField bkcolorpsdef = null;
    private Integer objClsPSDEFLock = new Integer(1);
    private PSDEField clspsdef = null;
    private Integer objColorPSDEFLock = new Integer(1);
    private PSDEField colorpsdef = null;
    private Integer objDataPSDEFLock = new Integer(1);
    private PSDEField datapsdef = null;
    private Integer objDisablePSDEFLock = new Integer(1);
    private PSDEField disablepsdef = null;
    private Integer objEndValuePSDEFLock = new Integer(1);
    private PSDEField endvaluepsdef = null;
    private Integer objIconClsPSDEFLock = new Integer(1);
    private PSDEField iconclspsdef = null;
    private Integer objIconClsXPSDEFLock = new Integer(1);
    private PSDEField iconclsxpsdef = null;
    private Integer objIconPathPSDEFLock = new Integer(1);
    private PSDEField iconpathpsdef = null;
    private Integer objIconPathXPSDEFLock = new Integer(1);
    private PSDEField iconpathxpsdef = null;
    private Integer objMinorSortPSDEFLock = new Integer(1);
    private PSDEField minorsortpsdef = null;
    private Integer objPValuePSDEFLock = new Integer(1);
    private PSDEField pvaluepsdef = null;
    private Integer objTextPSDEFLock = new Integer(1);
    private PSDEField textpsdef = null;
    private Integer objValuePSDEFLock = new Integer(1);
    private PSDEField valuepsdef = null;
    private Integer objPSDEMSLogicLock = new Integer(1);
    private PSDELogic psdemslogic = null;
    private Integer objLinkPSDEViewLock = new Integer(1);
    private PSDEViewBase linkpsdeview = null;
    private Integer objPSDynaCodeListLock = new Integer(1);
    private PSDynaCodeList psdynacodelist = null;
    private Integer objPSDynaInstLock = new Integer(1);
    private PSDynaInst psdynainst = null;
    private Integer objAllTextPSLanResLock = new Integer(1);
    private PSLanguageRes alltextpslanres = null;
    private Integer objEmtpyTextPSLanResLock = new Integer(1);
    private PSLanguageRes emtpytextpslanres = null;
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel pssysdynamodel = null;
    private Integer objPSSysPFPluginLock = new Integer(1);
    private PSSysPFPlugin pssyspfplugin = null;
    private Integer objPSSysReqItemLock = new Integer(1);
    private PSSysReqItem pssysreqitem = null;
    private Integer objPSSysSFPluginLock = new Integer(1);
    private PSSysSFPlugin pssyssfplugin = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSCodeItemsLock = new Integer(1);
    private ArrayList<PSCodeItem> pscodeitems = null;

    public void setAllText(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAllText(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.alltext = string;
        this.alltextDirtyFlag = true;
    }

    public String getAllText() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAllText();
        }
        return this.alltext;
    }

    public boolean isAllTextDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAllTextDirty();
        }
        return this.alltextDirtyFlag;
    }

    public void resetAllText() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAllText();
            return;
        }
        this.alltextDirtyFlag = false;
        this.alltext = null;
    }

    public void setAllTextPSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAllTextPSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.alltextpslanresid = string;
        this.alltextpslanresidDirtyFlag = true;
    }

    public String getAllTextPSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAllTextPSLanResId();
        }
        return this.alltextpslanresid;
    }

    public boolean isAllTextPSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAllTextPSLanResIdDirty();
        }
        return this.alltextpslanresidDirtyFlag;
    }

    public void resetAllTextPSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAllTextPSLanResId();
            return;
        }
        this.alltextpslanresidDirtyFlag = false;
        this.alltextpslanresid = null;
    }

    public void setAllTextPSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAllTextPSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.alltextpslanresname = string;
        this.alltextpslanresnameDirtyFlag = true;
    }

    public String getAllTextPSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAllTextPSLanResName();
        }
        return this.alltextpslanresname;
    }

    public boolean isAllTextPSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAllTextPSLanResNameDirty();
        }
        return this.alltextpslanresnameDirtyFlag;
    }

    public void resetAllTextPSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAllTextPSLanResName();
            return;
        }
        this.alltextpslanresnameDirtyFlag = false;
        this.alltextpslanresname = null;
    }

    public void setBeginValuePSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBeginValuePSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.beginvaluepsdefid = string;
        this.beginvaluepsdefidDirtyFlag = true;
    }

    public String getBeginValuePSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBeginValuePSDEFId();
        }
        return this.beginvaluepsdefid;
    }

    public boolean isBeginValuePSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBeginValuePSDEFIdDirty();
        }
        return this.beginvaluepsdefidDirtyFlag;
    }

    public void resetBeginValuePSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBeginValuePSDEFId();
            return;
        }
        this.beginvaluepsdefidDirtyFlag = false;
        this.beginvaluepsdefid = null;
    }

    public void setBeginValuePSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBeginValuePSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.beginvaluepsdefname = string;
        this.beginvaluepsdefnameDirtyFlag = true;
    }

    public String getBeginValuePSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBeginValuePSDEFName();
        }
        return this.beginvaluepsdefname;
    }

    public boolean isBeginValuePSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBeginValuePSDEFNameDirty();
        }
        return this.beginvaluepsdefnameDirtyFlag;
    }

    public void resetBeginValuePSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBeginValuePSDEFName();
            return;
        }
        this.beginvaluepsdefnameDirtyFlag = false;
        this.beginvaluepsdefname = null;
    }

    public void setBKColorPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBKColorPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bkcolorpsdefid = string;
        this.bkcolorpsdefidDirtyFlag = true;
    }

    public String getBKColorPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBKColorPSDEFId();
        }
        return this.bkcolorpsdefid;
    }

    public boolean isBKColorPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBKColorPSDEFIdDirty();
        }
        return this.bkcolorpsdefidDirtyFlag;
    }

    public void resetBKColorPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBKColorPSDEFId();
            return;
        }
        this.bkcolorpsdefidDirtyFlag = false;
        this.bkcolorpsdefid = null;
    }

    public void setBKColorPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBKColorPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bkcolorpsdefname = string;
        this.bkcolorpsdefnameDirtyFlag = true;
    }

    public String getBKColorPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBKColorPSDEFName();
        }
        return this.bkcolorpsdefname;
    }

    public boolean isBKColorPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBKColorPSDEFNameDirty();
        }
        return this.bkcolorpsdefnameDirtyFlag;
    }

    public void resetBKColorPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBKColorPSDEFName();
            return;
        }
        this.bkcolorpsdefnameDirtyFlag = false;
        this.bkcolorpsdefname = null;
    }

    public void setCacheCat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCacheCat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cachecat = string;
        this.cachecatDirtyFlag = true;
    }

    public String getCacheCat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCacheCat();
        }
        return this.cachecat;
    }

    public boolean isCacheCatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCacheCatDirty();
        }
        return this.cachecatDirtyFlag;
    }

    public void resetCacheCat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCacheCat();
            return;
        }
        this.cachecatDirtyFlag = false;
        this.cachecat = null;
    }

    public void setCacheTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCacheTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cachetag = string;
        this.cachetagDirtyFlag = true;
    }

    public String getCacheTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCacheTag();
        }
        return this.cachetag;
    }

    public boolean isCacheTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCacheTagDirty();
        }
        return this.cachetagDirtyFlag;
    }

    public void resetCacheTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCacheTag();
            return;
        }
        this.cachetagDirtyFlag = false;
        this.cachetag = null;
    }

    public void setCacheTimeout(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCacheTimeout(n);
            return;
        }
        this.cachetimeout = n;
        this.cachetimeoutDirtyFlag = true;
    }

    public Integer getCacheTimeout() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCacheTimeout();
        }
        return this.cachetimeout;
    }

    public boolean isCacheTimeoutDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCacheTimeoutDirty();
        }
        return this.cachetimeoutDirtyFlag;
    }

    public void resetCacheTimeout() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCacheTimeout();
            return;
        }
        this.cachetimeoutDirtyFlag = false;
        this.cachetimeout = null;
    }

    public void setCLModel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCLModel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.clmodel = string;
        this.clmodelDirtyFlag = true;
    }

    public String getCLModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCLModel();
        }
        return this.clmodel;
    }

    public boolean isCLModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCLModelDirty();
        }
        return this.clmodelDirtyFlag;
    }

    public void resetCLModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCLModel();
            return;
        }
        this.clmodelDirtyFlag = false;
        this.clmodel = null;
    }

    public void setClsPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setClsPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.clspsdefid = string;
        this.clspsdefidDirtyFlag = true;
    }

    public String getClsPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getClsPSDEFId();
        }
        return this.clspsdefid;
    }

    public boolean isClsPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isClsPSDEFIdDirty();
        }
        return this.clspsdefidDirtyFlag;
    }

    public void resetClsPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetClsPSDEFId();
            return;
        }
        this.clspsdefidDirtyFlag = false;
        this.clspsdefid = null;
    }

    public void setClsPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setClsPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.clspsdefname = string;
        this.clspsdefnameDirtyFlag = true;
    }

    public String getClsPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getClsPSDEFName();
        }
        return this.clspsdefname;
    }

    public boolean isClsPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isClsPSDEFNameDirty();
        }
        return this.clspsdefnameDirtyFlag;
    }

    public void resetClsPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetClsPSDEFName();
            return;
        }
        this.clspsdefnameDirtyFlag = false;
        this.clspsdefname = null;
    }

    public void setCLType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCLType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cltype = string;
        this.cltypeDirtyFlag = true;
    }

    public String getCLType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCLType();
        }
        return this.cltype;
    }

    public boolean isCLTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCLTypeDirty();
        }
        return this.cltypeDirtyFlag;
    }

    public void resetCLType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCLType();
            return;
        }
        this.cltypeDirtyFlag = false;
        this.cltype = null;
    }

    public void setCodeItemTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeItemTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.codeitemtag = string;
        this.codeitemtagDirtyFlag = true;
    }

    public String getCodeItemTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeItemTag();
        }
        return this.codeitemtag;
    }

    public boolean isCodeItemTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeItemTagDirty();
        }
        return this.codeitemtagDirtyFlag;
    }

    public void resetCodeItemTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeItemTag();
            return;
        }
        this.codeitemtagDirtyFlag = false;
        this.codeitemtag = null;
    }

    public void setCodeListSN(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeListSN(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.codelistsn = string;
        this.codelistsnDirtyFlag = true;
    }

    public String getCodeListSN() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeListSN();
        }
        return this.codelistsn;
    }

    public boolean isCodeListSNDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeListSNDirty();
        }
        return this.codelistsnDirtyFlag;
    }

    public void resetCodeListSN() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeListSN();
            return;
        }
        this.codelistsnDirtyFlag = false;
        this.codelistsn = null;
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

    public void setColorPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setColorPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.colorpsdefid = string;
        this.colorpsdefidDirtyFlag = true;
    }

    public String getColorPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getColorPSDEFId();
        }
        return this.colorpsdefid;
    }

    public boolean isColorPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isColorPSDEFIdDirty();
        }
        return this.colorpsdefidDirtyFlag;
    }

    public void resetColorPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetColorPSDEFId();
            return;
        }
        this.colorpsdefidDirtyFlag = false;
        this.colorpsdefid = null;
    }

    public void setColorPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setColorPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.colorpsdefname = string;
        this.colorpsdefnameDirtyFlag = true;
    }

    public String getColorPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getColorPSDEFName();
        }
        return this.colorpsdefname;
    }

    public boolean isColorPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isColorPSDEFNameDirty();
        }
        return this.colorpsdefnameDirtyFlag;
    }

    public void resetColorPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetColorPSDEFName();
            return;
        }
        this.colorpsdefnameDirtyFlag = false;
        this.colorpsdefname = null;
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

    public void setCustomCond(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomCond(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.customcond = string;
        this.customcondDirtyFlag = true;
    }

    public String getCustomCond() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomCond();
        }
        return this.customcond;
    }

    public boolean isCustomCondDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomCondDirty();
        }
        return this.customcondDirtyFlag;
    }

    public void resetCustomCond() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomCond();
            return;
        }
        this.customcondDirtyFlag = false;
        this.customcond = null;
    }

    public void setCustomType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.customtype = string;
        this.customtypeDirtyFlag = true;
    }

    public String getCustomType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomType();
        }
        return this.customtype;
    }

    public boolean isCustomTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomTypeDirty();
        }
        return this.customtypeDirtyFlag;
    }

    public void resetCustomType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomType();
            return;
        }
        this.customtypeDirtyFlag = false;
        this.customtype = null;
    }

    public void setDataPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDataPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.datapsdefid = string;
        this.datapsdefidDirtyFlag = true;
    }

    public String getDataPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDataPSDEFId();
        }
        return this.datapsdefid;
    }

    public boolean isDataPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataPSDEFIdDirty();
        }
        return this.datapsdefidDirtyFlag;
    }

    public void resetDataPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDataPSDEFId();
            return;
        }
        this.datapsdefidDirtyFlag = false;
        this.datapsdefid = null;
    }

    public void setDataPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDataPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.datapsdefname = string;
        this.datapsdefnameDirtyFlag = true;
    }

    public String getDataPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDataPSDEFName();
        }
        return this.datapsdefname;
    }

    public boolean isDataPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataPSDEFNameDirty();
        }
        return this.datapsdefnameDirtyFlag;
    }

    public void resetDataPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDataPSDEFName();
            return;
        }
        this.datapsdefnameDirtyFlag = false;
        this.datapsdefname = null;
    }

    public void setDisablePSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDisablePSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.disablepsdefid = string;
        this.disablepsdefidDirtyFlag = true;
    }

    public String getDisablePSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDisablePSDEFId();
        }
        return this.disablepsdefid;
    }

    public boolean isDisablePSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDisablePSDEFIdDirty();
        }
        return this.disablepsdefidDirtyFlag;
    }

    public void resetDisablePSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDisablePSDEFId();
            return;
        }
        this.disablepsdefidDirtyFlag = false;
        this.disablepsdefid = null;
    }

    public void setDisablePSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDisablePSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.disablepsdefname = string;
        this.disablepsdefnameDirtyFlag = true;
    }

    public String getDisablePSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDisablePSDEFName();
        }
        return this.disablepsdefname;
    }

    public boolean isDisablePSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDisablePSDEFNameDirty();
        }
        return this.disablepsdefnameDirtyFlag;
    }

    public void resetDisablePSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDisablePSDEFName();
            return;
        }
        this.disablepsdefnameDirtyFlag = false;
        this.disablepsdefname = null;
    }

    public void setDSConditions(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDSConditions(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dsconditions = string;
        this.dsconditionsDirtyFlag = true;
    }

    public String getDSConditions() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDSConditions();
        }
        return this.dsconditions;
    }

    public boolean isDSConditionsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDSConditionsDirty();
        }
        return this.dsconditionsDirtyFlag;
    }

    public void resetDSConditions() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDSConditions();
            return;
        }
        this.dsconditionsDirtyFlag = false;
        this.dsconditions = null;
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

    public void setDynaSysRefMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynaSysRefMode(n);
            return;
        }
        this.dynasysrefmode = n;
        this.dynasysrefmodeDirtyFlag = true;
    }

    public Integer getDynaSysRefMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynaSysRefMode();
        }
        return this.dynasysrefmode;
    }

    public boolean isDynaSysRefModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynaSysRefModeDirty();
        }
        return this.dynasysrefmodeDirtyFlag;
    }

    public void resetDynaSysRefMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynaSysRefMode();
            return;
        }
        this.dynasysrefmodeDirtyFlag = false;
        this.dynasysrefmode = null;
    }

    public void setEmptyText(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEmptyText(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.emptytext = string;
        this.emptytextDirtyFlag = true;
    }

    public String getEmptyText() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEmptyText();
        }
        return this.emptytext;
    }

    public boolean isEmptyTextDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEmptyTextDirty();
        }
        return this.emptytextDirtyFlag;
    }

    public void resetEmptyText() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEmptyText();
            return;
        }
        this.emptytextDirtyFlag = false;
        this.emptytext = null;
    }

    public void setEmptyTextPSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEmptyTextPSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.emptytextpslanresid = string;
        this.emptytextpslanresidDirtyFlag = true;
    }

    public String getEmptyTextPSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEmptyTextPSLanResId();
        }
        return this.emptytextpslanresid;
    }

    public boolean isEmptyTextPSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEmptyTextPSLanResIdDirty();
        }
        return this.emptytextpslanresidDirtyFlag;
    }

    public void resetEmptyTextPSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEmptyTextPSLanResId();
            return;
        }
        this.emptytextpslanresidDirtyFlag = false;
        this.emptytextpslanresid = null;
    }

    public void setEmptyTextPSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEmptyTextPSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.emptytextpslanresname = string;
        this.emptytextpslanresnameDirtyFlag = true;
    }

    public String getEmptyTextPSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEmptyTextPSLanResName();
        }
        return this.emptytextpslanresname;
    }

    public boolean isEmptyTextPSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEmptyTextPSLanResNameDirty();
        }
        return this.emptytextpslanresnameDirtyFlag;
    }

    public void resetEmptyTextPSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEmptyTextPSLanResName();
            return;
        }
        this.emptytextpslanresnameDirtyFlag = false;
        this.emptytextpslanresname = null;
    }

    public void setEnableCache(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableCache(n);
            return;
        }
        this.enablecache = n;
        this.enablecacheDirtyFlag = true;
    }

    public Integer getEnableCache() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableCache();
        }
        return this.enablecache;
    }

    public boolean isEnableCacheDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableCacheDirty();
        }
        return this.enablecacheDirtyFlag;
    }

    public void resetEnableCache() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableCache();
            return;
        }
        this.enablecacheDirtyFlag = false;
        this.enablecache = null;
    }

    public void setEnableDynaSys(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableDynaSys(n);
            return;
        }
        this.enabledynasys = n;
        this.enabledynasysDirtyFlag = true;
    }

    public Integer getEnableDynaSys() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableDynaSys();
        }
        return this.enabledynasys;
    }

    public boolean isEnableDynaSysDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableDynaSysDirty();
        }
        return this.enabledynasysDirtyFlag;
    }

    public void resetEnableDynaSys() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableDynaSys();
            return;
        }
        this.enabledynasysDirtyFlag = false;
        this.enabledynasys = null;
    }

    public void setEndValuePSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEndValuePSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.endvaluepsdefid = string;
        this.endvaluepsdefidDirtyFlag = true;
    }

    public String getEndValuePSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEndValuePSDEFId();
        }
        return this.endvaluepsdefid;
    }

    public boolean isEndValuePSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEndValuePSDEFIdDirty();
        }
        return this.endvaluepsdefidDirtyFlag;
    }

    public void resetEndValuePSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEndValuePSDEFId();
            return;
        }
        this.endvaluepsdefidDirtyFlag = false;
        this.endvaluepsdefid = null;
    }

    public void setEndValuePSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEndValuePSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.endvaluepsdefname = string;
        this.endvaluepsdefnameDirtyFlag = true;
    }

    public String getEndValuePSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEndValuePSDEFName();
        }
        return this.endvaluepsdefname;
    }

    public boolean isEndValuePSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEndValuePSDEFNameDirty();
        }
        return this.endvaluepsdefnameDirtyFlag;
    }

    public void resetEndValuePSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEndValuePSDEFName();
            return;
        }
        this.endvaluepsdefnameDirtyFlag = false;
        this.endvaluepsdefname = null;
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

    public void setIconClsPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIconClsPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.iconclspsdefid = string;
        this.iconclspsdefidDirtyFlag = true;
    }

    public String getIconClsPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIconClsPSDEFId();
        }
        return this.iconclspsdefid;
    }

    public boolean isIconClsPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIconClsPSDEFIdDirty();
        }
        return this.iconclspsdefidDirtyFlag;
    }

    public void resetIconClsPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIconClsPSDEFId();
            return;
        }
        this.iconclspsdefidDirtyFlag = false;
        this.iconclspsdefid = null;
    }

    public void setIconClsPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIconClsPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.iconclspsdefname = string;
        this.iconclspsdefnameDirtyFlag = true;
    }

    public String getIconClsPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIconClsPSDEFName();
        }
        return this.iconclspsdefname;
    }

    public boolean isIconClsPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIconClsPSDEFNameDirty();
        }
        return this.iconclspsdefnameDirtyFlag;
    }

    public void resetIconClsPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIconClsPSDEFName();
            return;
        }
        this.iconclspsdefnameDirtyFlag = false;
        this.iconclspsdefname = null;
    }

    public void setIconClsXPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIconClsXPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.iconclsxpsdefid = string;
        this.iconclsxpsdefidDirtyFlag = true;
    }

    public String getIconClsXPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIconClsXPSDEFId();
        }
        return this.iconclsxpsdefid;
    }

    public boolean isIconClsXPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIconClsXPSDEFIdDirty();
        }
        return this.iconclsxpsdefidDirtyFlag;
    }

    public void resetIconClsXPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIconClsXPSDEFId();
            return;
        }
        this.iconclsxpsdefidDirtyFlag = false;
        this.iconclsxpsdefid = null;
    }

    public void setIconClsXPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIconClsXPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.iconclsxpsdefname = string;
        this.iconclsxpsdefnameDirtyFlag = true;
    }

    public String getIconClsXPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIconClsXPSDEFName();
        }
        return this.iconclsxpsdefname;
    }

    public boolean isIconClsXPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIconClsXPSDEFNameDirty();
        }
        return this.iconclsxpsdefnameDirtyFlag;
    }

    public void resetIconClsXPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIconClsXPSDEFName();
            return;
        }
        this.iconclsxpsdefnameDirtyFlag = false;
        this.iconclsxpsdefname = null;
    }

    public void setIconPathPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIconPathPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.iconpathpsdefid = string;
        this.iconpathpsdefidDirtyFlag = true;
    }

    public String getIconPathPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIconPathPSDEFId();
        }
        return this.iconpathpsdefid;
    }

    public boolean isIconPathPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIconPathPSDEFIdDirty();
        }
        return this.iconpathpsdefidDirtyFlag;
    }

    public void resetIconPathPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIconPathPSDEFId();
            return;
        }
        this.iconpathpsdefidDirtyFlag = false;
        this.iconpathpsdefid = null;
    }

    public void setIconPathPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIconPathPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.iconpathpsdefname = string;
        this.iconpathpsdefnameDirtyFlag = true;
    }

    public String getIconPathPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIconPathPSDEFName();
        }
        return this.iconpathpsdefname;
    }

    public boolean isIconPathPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIconPathPSDEFNameDirty();
        }
        return this.iconpathpsdefnameDirtyFlag;
    }

    public void resetIconPathPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIconPathPSDEFName();
            return;
        }
        this.iconpathpsdefnameDirtyFlag = false;
        this.iconpathpsdefname = null;
    }

    public void setIconPathXPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIconPathXPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.iconpathxpsdefid = string;
        this.iconpathxpsdefidDirtyFlag = true;
    }

    public String getIconPathXPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIconPathXPSDEFId();
        }
        return this.iconpathxpsdefid;
    }

    public boolean isIconPathXPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIconPathXPSDEFIdDirty();
        }
        return this.iconpathxpsdefidDirtyFlag;
    }

    public void resetIconPathXPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIconPathXPSDEFId();
            return;
        }
        this.iconpathxpsdefidDirtyFlag = false;
        this.iconpathxpsdefid = null;
    }

    public void setIconPathXPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIconPathXPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.iconpathxpsdefname = string;
        this.iconpathxpsdefnameDirtyFlag = true;
    }

    public String getIconPathXPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIconPathXPSDEFName();
        }
        return this.iconpathxpsdefname;
    }

    public boolean isIconPathXPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIconPathXPSDEFNameDirty();
        }
        return this.iconpathxpsdefnameDirtyFlag;
    }

    public void resetIconPathXPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIconPathXPSDEFName();
            return;
        }
        this.iconpathxpsdefnameDirtyFlag = false;
        this.iconpathxpsdefname = null;
    }

    public void setIncBeginValue(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIncBeginValue(n);
            return;
        }
        this.incbeginvalue = n;
        this.incbeginvalueDirtyFlag = true;
    }

    public Integer getIncBeginValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIncBeginValue();
        }
        return this.incbeginvalue;
    }

    public boolean isIncBeginValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIncBeginValueDirty();
        }
        return this.incbeginvalueDirtyFlag;
    }

    public void resetIncBeginValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIncBeginValue();
            return;
        }
        this.incbeginvalueDirtyFlag = false;
        this.incbeginvalue = null;
    }

    public void setIncEndValue(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIncEndValue(n);
            return;
        }
        this.incendvalue = n;
        this.incendvalueDirtyFlag = true;
    }

    public Integer getIncEndValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIncEndValue();
        }
        return this.incendvalue;
    }

    public boolean isIncEndValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIncEndValueDirty();
        }
        return this.incendvalueDirtyFlag;
    }

    public void resetIncEndValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIncEndValue();
            return;
        }
        this.incendvalueDirtyFlag = false;
        this.incendvalue = null;
    }

    public void setLinkPSDEViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLinkPSDEViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.linkpsdeviewid = string;
        this.linkpsdeviewidDirtyFlag = true;
    }

    public String getLinkPSDEViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLinkPSDEViewId();
        }
        return this.linkpsdeviewid;
    }

    public boolean isLinkPSDEViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLinkPSDEViewIdDirty();
        }
        return this.linkpsdeviewidDirtyFlag;
    }

    public void resetLinkPSDEViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLinkPSDEViewId();
            return;
        }
        this.linkpsdeviewidDirtyFlag = false;
        this.linkpsdeviewid = null;
    }

    public void setLinkPSDEViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLinkPSDEViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.linkpsdeviewname = string;
        this.linkpsdeviewnameDirtyFlag = true;
    }

    public String getLinkPSDEViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLinkPSDEViewName();
        }
        return this.linkpsdeviewname;
    }

    public boolean isLinkPSDEViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLinkPSDEViewNameDirty();
        }
        return this.linkpsdeviewnameDirtyFlag;
    }

    public void resetLinkPSDEViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLinkPSDEViewName();
            return;
        }
        this.linkpsdeviewnameDirtyFlag = false;
        this.linkpsdeviewname = null;
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

    public void setMinorSortDir(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinorSortDir(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.minorsortdir = string;
        this.minorsortdirDirtyFlag = true;
    }

    public String getMinorSortDir() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorSortDir();
        }
        return this.minorsortdir;
    }

    public boolean isMinorSortDirDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinorSortDirDirty();
        }
        return this.minorsortdirDirtyFlag;
    }

    public void resetMinorSortDir() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinorSortDir();
            return;
        }
        this.minorsortdirDirtyFlag = false;
        this.minorsortdir = null;
    }

    public void setMinorSortPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinorSortPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.minorsortpsdefid = string;
        this.minorsortpsdefidDirtyFlag = true;
    }

    public String getMinorSortPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorSortPSDEFId();
        }
        return this.minorsortpsdefid;
    }

    public boolean isMinorSortPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinorSortPSDEFIdDirty();
        }
        return this.minorsortpsdefidDirtyFlag;
    }

    public void resetMinorSortPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinorSortPSDEFId();
            return;
        }
        this.minorsortpsdefidDirtyFlag = false;
        this.minorsortpsdefid = null;
    }

    public void setMinorSortPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinorSortPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.minorsortpsdefname = string;
        this.minorsortpsdefnameDirtyFlag = true;
    }

    public String getMinorSortPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorSortPSDEFName();
        }
        return this.minorsortpsdefname;
    }

    public boolean isMinorSortPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinorSortPSDEFNameDirty();
        }
        return this.minorsortpsdefnameDirtyFlag;
    }

    public void resetMinorSortPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinorSortPSDEFName();
            return;
        }
        this.minorsortpsdefnameDirtyFlag = false;
        this.minorsortpsdefname = null;
    }

    public void setModColor(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModColor(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.modcolor = string;
        this.modcolorDirtyFlag = true;
    }

    public String getModColor() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModColor();
        }
        return this.modcolor;
    }

    public boolean isModColorDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModColorDirty();
        }
        return this.modcolorDirtyFlag;
    }

    public void resetModColor() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModColor();
            return;
        }
        this.modcolorDirtyFlag = false;
        this.modcolor = null;
    }

    public void setNoValueEmpty(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNoValueEmpty(n);
            return;
        }
        this.novalueempty = n;
        this.novalueemptyDirtyFlag = true;
    }

    public Integer getNoValueEmpty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNoValueEmpty();
        }
        return this.novalueempty;
    }

    public boolean isNoValueEmptyDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNoValueEmptyDirty();
        }
        return this.novalueemptyDirtyFlag;
    }

    public void resetNoValueEmpty() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNoValueEmpty();
            return;
        }
        this.novalueemptyDirtyFlag = false;
        this.novalueempty = null;
    }

    public void setNumberItem(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNumberItem(n);
            return;
        }
        this.numberitem = n;
        this.numberitemDirtyFlag = true;
    }

    public Integer getNumberItem() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNumberItem();
        }
        return this.numberitem;
    }

    public boolean isNumberItemDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNumberItemDirty();
        }
        return this.numberitemDirtyFlag;
    }

    public void resetNumberItem() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNumberItem();
            return;
        }
        this.numberitemDirtyFlag = false;
        this.numberitem = null;
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

    public void setOrMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOrMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ormode = string;
        this.ormodeDirtyFlag = true;
    }

    public String getOrMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOrMode();
        }
        return this.ormode;
    }

    public boolean isOrModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOrModeDirty();
        }
        return this.ormodeDirtyFlag;
    }

    public void resetOrMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOrMode();
            return;
        }
        this.ormodeDirtyFlag = false;
        this.ormode = null;
    }

    public void setPredefinedType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPredefinedType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.predefinedtype = string;
        this.predefinedtypeDirtyFlag = true;
    }

    public String getPredefinedType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPredefinedType();
        }
        return this.predefinedtype;
    }

    public boolean isPredefinedTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPredefinedTypeDirty();
        }
        return this.predefinedtypeDirtyFlag;
    }

    public void resetPredefinedType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPredefinedType();
            return;
        }
        this.predefinedtypeDirtyFlag = false;
        this.predefinedtype = null;
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

    public void setPSCodeListTemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCodeListTemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscodelisttemplid = string;
        this.pscodelisttemplidDirtyFlag = true;
    }

    public String getPSCodeListTemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCodeListTemplId();
        }
        return this.pscodelisttemplid;
    }

    public boolean isPSCodeListTemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCodeListTemplIdDirty();
        }
        return this.pscodelisttemplidDirtyFlag;
    }

    public void resetPSCodeListTemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCodeListTemplId();
            return;
        }
        this.pscodelisttemplidDirtyFlag = false;
        this.pscodelisttemplid = null;
    }

    public void setPSCodeListTemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCodeListTemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscodelisttemplname = string;
        this.pscodelisttemplnameDirtyFlag = true;
    }

    public String getPSCodeListTemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCodeListTemplName();
        }
        return this.pscodelisttemplname;
    }

    public boolean isPSCodeListTemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCodeListTemplNameDirty();
        }
        return this.pscodelisttemplnameDirtyFlag;
    }

    public void resetPSCodeListTemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCodeListTemplName();
            return;
        }
        this.pscodelisttemplnameDirtyFlag = false;
        this.pscodelisttemplname = null;
    }

    public void setPSDEDSId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDSId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedsid = string;
        this.psdedsidDirtyFlag = true;
    }

    public String getPSDEDSId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDSId();
        }
        return this.psdedsid;
    }

    public boolean isPSDEDSIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDSIdDirty();
        }
        return this.psdedsidDirtyFlag;
    }

    public void resetPSDEDSId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDSId();
            return;
        }
        this.psdedsidDirtyFlag = false;
        this.psdedsid = null;
    }

    public void setPSDEDSName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDSName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedsname = string;
        this.psdedsnameDirtyFlag = true;
    }

    public String getPSDEDSName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDSName();
        }
        return this.psdedsname;
    }

    public boolean isPSDEDSNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDSNameDirty();
        }
        return this.psdedsnameDirtyFlag;
    }

    public void resetPSDEDSName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDSName();
            return;
        }
        this.psdedsnameDirtyFlag = false;
        this.psdedsname = null;
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

    public void setPSDEMSLogicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEMSLogicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdemslogicid = string;
        this.psdemslogicidDirtyFlag = true;
    }

    public String getPSDEMSLogicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEMSLogicId();
        }
        return this.psdemslogicid;
    }

    public boolean isPSDEMSLogicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEMSLogicIdDirty();
        }
        return this.psdemslogicidDirtyFlag;
    }

    public void resetPSDEMSLogicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEMSLogicId();
            return;
        }
        this.psdemslogicidDirtyFlag = false;
        this.psdemslogicid = null;
    }

    public void setPSDEMSLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEMSLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdemslogicname = string;
        this.psdemslogicnameDirtyFlag = true;
    }

    public String getPSDEMSLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEMSLogicName();
        }
        return this.psdemslogicname;
    }

    public boolean isPSDEMSLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEMSLogicNameDirty();
        }
        return this.psdemslogicnameDirtyFlag;
    }

    public void resetPSDEMSLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEMSLogicName();
            return;
        }
        this.psdemslogicnameDirtyFlag = false;
        this.psdemslogicname = null;
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

    public void setPSDynaCodeListId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaCodeListId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynacodelistid = string;
        this.psdynacodelistidDirtyFlag = true;
    }

    public String getPSDynaCodeListId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaCodeListId();
        }
        return this.psdynacodelistid;
    }

    public boolean isPSDynaCodeListIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaCodeListIdDirty();
        }
        return this.psdynacodelistidDirtyFlag;
    }

    public void resetPSDynaCodeListId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaCodeListId();
            return;
        }
        this.psdynacodelistidDirtyFlag = false;
        this.psdynacodelistid = null;
    }

    public void setPSDynaCodeListName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaCodeListName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynacodelistname = string;
        this.psdynacodelistnameDirtyFlag = true;
    }

    public String getPSDynaCodeListName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaCodeListName();
        }
        return this.psdynacodelistname;
    }

    public boolean isPSDynaCodeListNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaCodeListNameDirty();
        }
        return this.psdynacodelistnameDirtyFlag;
    }

    public void resetPSDynaCodeListName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaCodeListName();
            return;
        }
        this.psdynacodelistnameDirtyFlag = false;
        this.psdynacodelistname = null;
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

    public void setPSDynaInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynainstname = string;
        this.psdynainstnameDirtyFlag = true;
    }

    public String getPSDynaInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaInstName();
        }
        return this.psdynainstname;
    }

    public boolean isPSDynaInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaInstNameDirty();
        }
        return this.psdynainstnameDirtyFlag;
    }

    public void resetPSDynaInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaInstName();
            return;
        }
        this.psdynainstnameDirtyFlag = false;
        this.psdynainstname = null;
    }

    public void setPSModuleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModuleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmoduleid = string;
        this.psmoduleidDirtyFlag = true;
    }

    public String getPSModuleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModuleId();
        }
        return this.psmoduleid;
    }

    public boolean isPSModuleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModuleIdDirty();
        }
        return this.psmoduleidDirtyFlag;
    }

    public void resetPSModuleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModuleId();
            return;
        }
        this.psmoduleidDirtyFlag = false;
        this.psmoduleid = null;
    }

    public void setPSModuleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModuleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodulename = string;
        this.psmodulenameDirtyFlag = true;
    }

    public String getPSModuleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModuleName();
        }
        return this.psmodulename;
    }

    public boolean isPSModuleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModuleNameDirty();
        }
        return this.psmodulenameDirtyFlag;
    }

    public void resetPSModuleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModuleName();
            return;
        }
        this.psmodulenameDirtyFlag = false;
        this.psmodulename = null;
    }

    public void setPSSysDynaModelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDynaModelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdynamodelid = string;
        this.pssysdynamodelidDirtyFlag = true;
    }

    public String getPSSysDynaModelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModelId();
        }
        return this.pssysdynamodelid;
    }

    public boolean isPSSysDynaModelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDynaModelIdDirty();
        }
        return this.pssysdynamodelidDirtyFlag;
    }

    public void resetPSSysDynaModelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDynaModelId();
            return;
        }
        this.pssysdynamodelidDirtyFlag = false;
        this.pssysdynamodelid = null;
    }

    public void setPSSysDynaModelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDynaModelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdynamodelname = string;
        this.pssysdynamodelnameDirtyFlag = true;
    }

    public String getPSSysDynaModelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModelName();
        }
        return this.pssysdynamodelname;
    }

    public boolean isPSSysDynaModelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDynaModelNameDirty();
        }
        return this.pssysdynamodelnameDirtyFlag;
    }

    public void resetPSSysDynaModelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDynaModelName();
            return;
        }
        this.pssysdynamodelnameDirtyFlag = false;
        this.pssysdynamodelname = null;
    }

    public void setPSSysPFPluginId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysPFPluginId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyspfpluginid = string;
        this.pssyspfpluginidDirtyFlag = true;
    }

    public String getPSSysPFPluginId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPFPluginId();
        }
        return this.pssyspfpluginid;
    }

    public boolean isPSSysPFPluginIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysPFPluginIdDirty();
        }
        return this.pssyspfpluginidDirtyFlag;
    }

    public void resetPSSysPFPluginId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysPFPluginId();
            return;
        }
        this.pssyspfpluginidDirtyFlag = false;
        this.pssyspfpluginid = null;
    }

    public void setPSSysPFPluginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysPFPluginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyspfpluginname = string;
        this.pssyspfpluginnameDirtyFlag = true;
    }

    public String getPSSysPFPluginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPFPluginName();
        }
        return this.pssyspfpluginname;
    }

    public boolean isPSSysPFPluginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysPFPluginNameDirty();
        }
        return this.pssyspfpluginnameDirtyFlag;
    }

    public void resetPSSysPFPluginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysPFPluginName();
            return;
        }
        this.pssyspfpluginnameDirtyFlag = false;
        this.pssyspfpluginname = null;
    }

    public void setPSSysReqItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysReqItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysreqitemid = string;
        this.pssysreqitemidDirtyFlag = true;
    }

    public String getPSSysReqItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysReqItemId();
        }
        return this.pssysreqitemid;
    }

    public boolean isPSSysReqItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysReqItemIdDirty();
        }
        return this.pssysreqitemidDirtyFlag;
    }

    public void resetPSSysReqItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysReqItemId();
            return;
        }
        this.pssysreqitemidDirtyFlag = false;
        this.pssysreqitemid = null;
    }

    public void setPSSysReqItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysReqItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysreqitemname = string;
        this.pssysreqitemnameDirtyFlag = true;
    }

    public String getPSSysReqItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysReqItemName();
        }
        return this.pssysreqitemname;
    }

    public boolean isPSSysReqItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysReqItemNameDirty();
        }
        return this.pssysreqitemnameDirtyFlag;
    }

    public void resetPSSysReqItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysReqItemName();
            return;
        }
        this.pssysreqitemnameDirtyFlag = false;
        this.pssysreqitemname = null;
    }

    public void setPSSysSFPluginId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSFPluginId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssfpluginid = string;
        this.pssyssfpluginidDirtyFlag = true;
    }

    public String getPSSysSFPluginId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPluginId();
        }
        return this.pssyssfpluginid;
    }

    public boolean isPSSysSFPluginIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSFPluginIdDirty();
        }
        return this.pssyssfpluginidDirtyFlag;
    }

    public void resetPSSysSFPluginId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSFPluginId();
            return;
        }
        this.pssyssfpluginidDirtyFlag = false;
        this.pssyssfpluginid = null;
    }

    public void setPSSysSFPluginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSFPluginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssfpluginname = string;
        this.pssyssfpluginnameDirtyFlag = true;
    }

    public String getPSSysSFPluginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPluginName();
        }
        return this.pssyssfpluginname;
    }

    public boolean isPSSysSFPluginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSFPluginNameDirty();
        }
        return this.pssyssfpluginnameDirtyFlag;
    }

    public void resetPSSysSFPluginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSFPluginName();
            return;
        }
        this.pssyssfpluginnameDirtyFlag = false;
        this.pssyssfpluginname = null;
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

    public void setPSSystemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemname = string;
        this.pssystemnameDirtyFlag = true;
    }

    public String getPSSystemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemName();
        }
        return this.pssystemname;
    }

    public boolean isPSSystemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemNameDirty();
        }
        return this.pssystemnameDirtyFlag;
    }

    public void resetPSSystemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemName();
            return;
        }
        this.pssystemnameDirtyFlag = false;
        this.pssystemname = null;
    }

    public void setPValuePSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPValuePSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pvaluepsdefid = string;
        this.pvaluepsdefidDirtyFlag = true;
    }

    public String getPValuePSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPValuePSDEFId();
        }
        return this.pvaluepsdefid;
    }

    public boolean isPValuePSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPValuePSDEFIdDirty();
        }
        return this.pvaluepsdefidDirtyFlag;
    }

    public void resetPValuePSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPValuePSDEFId();
            return;
        }
        this.pvaluepsdefidDirtyFlag = false;
        this.pvaluepsdefid = null;
    }

    public void setPValuePSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPValuePSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pvaluepsdefname = string;
        this.pvaluepsdefnameDirtyFlag = true;
    }

    public String getPValuePSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPValuePSDEFName();
        }
        return this.pvaluepsdefname;
    }

    public boolean isPValuePSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPValuePSDEFNameDirty();
        }
        return this.pvaluepsdefnameDirtyFlag;
    }

    public void resetPValuePSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPValuePSDEFName();
            return;
        }
        this.pvaluepsdefnameDirtyFlag = false;
        this.pvaluepsdefname = null;
    }

    public void setSeperator(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSeperator(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.seperator = string;
        this.seperatorDirtyFlag = true;
    }

    public String getSeperator() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSeperator();
        }
        return this.seperator;
    }

    public boolean isSeperatorDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSeperatorDirty();
        }
        return this.seperatorDirtyFlag;
    }

    public void resetSeperator() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSeperator();
            return;
        }
        this.seperatorDirtyFlag = false;
        this.seperator = null;
    }

    public void setSRFSysPub(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSRFSysPub(n);
            return;
        }
        this.srfsyspub = n;
        this.srfsyspubDirtyFlag = true;
    }

    public Integer getSRFSysPub() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSRFSysPub();
        }
        return this.srfsyspub;
    }

    public boolean isSRFSysPubDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSRFSysPubDirty();
        }
        return this.srfsyspubDirtyFlag;
    }

    public void resetSRFSysPub() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSRFSysPub();
            return;
        }
        this.srfsyspubDirtyFlag = false;
        this.srfsyspub = null;
    }

    public void setSysRefFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysRefFlag(n);
            return;
        }
        this.sysrefflag = n;
        this.sysrefflagDirtyFlag = true;
    }

    public Integer getSysRefFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysRefFlag();
        }
        return this.sysrefflag;
    }

    public boolean isSysRefFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysRefFlagDirty();
        }
        return this.sysrefflagDirtyFlag;
    }

    public void resetSysRefFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysRefFlag();
            return;
        }
        this.sysrefflagDirtyFlag = false;
        this.sysrefflag = null;
    }

    public void setTextPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTextPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.textpsdefid = string;
        this.textpsdefidDirtyFlag = true;
    }

    public String getTextPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTextPSDEFId();
        }
        return this.textpsdefid;
    }

    public boolean isTextPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTextPSDEFIdDirty();
        }
        return this.textpsdefidDirtyFlag;
    }

    public void resetTextPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTextPSDEFId();
            return;
        }
        this.textpsdefidDirtyFlag = false;
        this.textpsdefid = null;
    }

    public void setTextPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTextPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.textpsdefname = string;
        this.textpsdefnameDirtyFlag = true;
    }

    public String getTextPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTextPSDEFName();
        }
        return this.textpsdefname;
    }

    public boolean isTextPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTextPSDEFNameDirty();
        }
        return this.textpsdefnameDirtyFlag;
    }

    public void resetTextPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTextPSDEFName();
            return;
        }
        this.textpsdefnameDirtyFlag = false;
        this.textpsdefname = null;
    }

    public void setThresholdGroupFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setThresholdGroupFlag(n);
            return;
        }
        this.thresholdgroupflag = n;
        this.thresholdgroupflagDirtyFlag = true;
    }

    public Integer getThresholdGroupFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getThresholdGroupFlag();
        }
        return this.thresholdgroupflag;
    }

    public boolean isThresholdGroupFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isThresholdGroupFlagDirty();
        }
        return this.thresholdgroupflagDirtyFlag;
    }

    public void resetThresholdGroupFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetThresholdGroupFlag();
            return;
        }
        this.thresholdgroupflagDirtyFlag = false;
        this.thresholdgroupflag = null;
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

    public void setUserData(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserData(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userdata = string;
        this.userdataDirtyFlag = true;
    }

    public String getUserData() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserData();
        }
        return this.userdata;
    }

    public boolean isUserDataDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserDataDirty();
        }
        return this.userdataDirtyFlag;
    }

    public void resetUserData() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserData();
            return;
        }
        this.userdataDirtyFlag = false;
        this.userdata = null;
    }

    public void setUserData2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserData2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userdata2 = string;
        this.userdata2DirtyFlag = true;
    }

    public String getUserData2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserData2();
        }
        return this.userdata2;
    }

    public boolean isUserData2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserData2Dirty();
        }
        return this.userdata2DirtyFlag;
    }

    public void resetUserData2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserData2();
            return;
        }
        this.userdata2DirtyFlag = false;
        this.userdata2 = null;
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

    public void setUserRefFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserRefFlag(n);
            return;
        }
        this.userrefflag = n;
        this.userrefflagDirtyFlag = true;
    }

    public Integer getUserRefFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserRefFlag();
        }
        return this.userrefflag;
    }

    public boolean isUserRefFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserRefFlagDirty();
        }
        return this.userrefflagDirtyFlag;
    }

    public void resetUserRefFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserRefFlag();
            return;
        }
        this.userrefflagDirtyFlag = false;
        this.userrefflag = null;
    }

    public void setUserScope(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserScope(n);
            return;
        }
        this.userscope = n;
        this.userscopeDirtyFlag = true;
    }

    public Integer getUserScope() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserScope();
        }
        return this.userscope;
    }

    public boolean isUserScopeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserScopeDirty();
        }
        return this.userscopeDirtyFlag;
    }

    public void resetUserScope() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserScope();
            return;
        }
        this.userscopeDirtyFlag = false;
        this.userscope = null;
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

    public void setValueSeperator(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValueSeperator(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.valueseperator = string;
        this.valueseperatorDirtyFlag = true;
    }

    public String getValueSeperator() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValueSeperator();
        }
        return this.valueseperator;
    }

    public boolean isValueSeperatorDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValueSeperatorDirty();
        }
        return this.valueseperatorDirtyFlag;
    }

    public void resetValueSeperator() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValueSeperator();
            return;
        }
        this.valueseperatorDirtyFlag = false;
        this.valueseperator = null;
    }

    protected void onReset() {
        PSCodeListBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSCodeListBase pSCodeListBase) {
        pSCodeListBase.resetAllText();
        pSCodeListBase.resetAllTextPSLanResId();
        pSCodeListBase.resetAllTextPSLanResName();
        pSCodeListBase.resetBeginValuePSDEFId();
        pSCodeListBase.resetBeginValuePSDEFName();
        pSCodeListBase.resetBKColorPSDEFId();
        pSCodeListBase.resetBKColorPSDEFName();
        pSCodeListBase.resetCacheCat();
        pSCodeListBase.resetCacheTag();
        pSCodeListBase.resetCacheTimeout();
        pSCodeListBase.resetCLModel();
        pSCodeListBase.resetClsPSDEFId();
        pSCodeListBase.resetClsPSDEFName();
        pSCodeListBase.resetCLType();
        pSCodeListBase.resetCodeItemTag();
        pSCodeListBase.resetCodeListSN();
        pSCodeListBase.resetCodeName();
        pSCodeListBase.resetColorPSDEFId();
        pSCodeListBase.resetColorPSDEFName();
        pSCodeListBase.resetCreateDate();
        pSCodeListBase.resetCreateMan();
        pSCodeListBase.resetCustomCond();
        pSCodeListBase.resetCustomType();
        pSCodeListBase.resetDataPSDEFId();
        pSCodeListBase.resetDataPSDEFName();
        pSCodeListBase.resetDisablePSDEFId();
        pSCodeListBase.resetDisablePSDEFName();
        pSCodeListBase.resetDSConditions();
        pSCodeListBase.resetDynaModelFlag();
        pSCodeListBase.resetDynaSysRefMode();
        pSCodeListBase.resetEmptyText();
        pSCodeListBase.resetEmptyTextPSLanResId();
        pSCodeListBase.resetEmptyTextPSLanResName();
        pSCodeListBase.resetEnableCache();
        pSCodeListBase.resetEnableDynaSys();
        pSCodeListBase.resetEndValuePSDEFId();
        pSCodeListBase.resetEndValuePSDEFName();
        pSCodeListBase.resetExtendMode();
        pSCodeListBase.resetIconClsPSDEFId();
        pSCodeListBase.resetIconClsPSDEFName();
        pSCodeListBase.resetIconClsXPSDEFId();
        pSCodeListBase.resetIconClsXPSDEFName();
        pSCodeListBase.resetIconPathPSDEFId();
        pSCodeListBase.resetIconPathPSDEFName();
        pSCodeListBase.resetIconPathXPSDEFId();
        pSCodeListBase.resetIconPathXPSDEFName();
        pSCodeListBase.resetIncBeginValue();
        pSCodeListBase.resetIncEndValue();
        pSCodeListBase.resetLinkPSDEViewId();
        pSCodeListBase.resetLinkPSDEViewName();
        pSCodeListBase.resetLockFlag();
        pSCodeListBase.resetMemo();
        pSCodeListBase.resetMinorSortDir();
        pSCodeListBase.resetMinorSortPSDEFId();
        pSCodeListBase.resetMinorSortPSDEFName();
        pSCodeListBase.resetModColor();
        pSCodeListBase.resetNoValueEmpty();
        pSCodeListBase.resetNumberItem();
        pSCodeListBase.resetOrderValue();
        pSCodeListBase.resetOrMode();
        pSCodeListBase.resetPredefinedType();
        pSCodeListBase.resetPSCodeListId();
        pSCodeListBase.resetPSCodeListName();
        pSCodeListBase.resetPSCodeListTemplId();
        pSCodeListBase.resetPSCodeListTemplName();
        pSCodeListBase.resetPSDEDSId();
        pSCodeListBase.resetPSDEDSName();
        pSCodeListBase.resetPSDEId();
        pSCodeListBase.resetPSDEMSLogicId();
        pSCodeListBase.resetPSDEMSLogicName();
        pSCodeListBase.resetPSDEName();
        pSCodeListBase.resetPSDynaCodeListId();
        pSCodeListBase.resetPSDynaCodeListName();
        pSCodeListBase.resetPSDynaInstId();
        pSCodeListBase.resetPSDynaInstName();
        pSCodeListBase.resetPSModuleId();
        pSCodeListBase.resetPSModuleName();
        pSCodeListBase.resetPSSysDynaModelId();
        pSCodeListBase.resetPSSysDynaModelName();
        pSCodeListBase.resetPSSysPFPluginId();
        pSCodeListBase.resetPSSysPFPluginName();
        pSCodeListBase.resetPSSysReqItemId();
        pSCodeListBase.resetPSSysReqItemName();
        pSCodeListBase.resetPSSysSFPluginId();
        pSCodeListBase.resetPSSysSFPluginName();
        pSCodeListBase.resetPSSystemId();
        pSCodeListBase.resetPSSystemName();
        pSCodeListBase.resetPValuePSDEFId();
        pSCodeListBase.resetPValuePSDEFName();
        pSCodeListBase.resetSeperator();
        pSCodeListBase.resetSRFSysPub();
        pSCodeListBase.resetSysRefFlag();
        pSCodeListBase.resetTextPSDEFId();
        pSCodeListBase.resetTextPSDEFName();
        pSCodeListBase.resetThresholdGroupFlag();
        pSCodeListBase.resetUpdateDate();
        pSCodeListBase.resetUpdateMan();
        pSCodeListBase.resetUserCat();
        pSCodeListBase.resetUserData();
        pSCodeListBase.resetUserData2();
        pSCodeListBase.resetUserParams();
        pSCodeListBase.resetUserRefFlag();
        pSCodeListBase.resetUserScope();
        pSCodeListBase.resetUserTag();
        pSCodeListBase.resetUserTag2();
        pSCodeListBase.resetUserTag3();
        pSCodeListBase.resetUserTag4();
        pSCodeListBase.resetValidFlag();
        pSCodeListBase.resetValuePSDEFId();
        pSCodeListBase.resetValuePSDEFName();
        pSCodeListBase.resetValueSeperator();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAllTextDirty()) {
            hashMap.put(FIELD_ALLTEXT, this.getAllText());
        }
        if (!bl || this.isAllTextPSLanResIdDirty()) {
            hashMap.put(FIELD_ALLTEXTPSLANRESID, this.getAllTextPSLanResId());
        }
        if (!bl || this.isAllTextPSLanResNameDirty()) {
            hashMap.put(FIELD_ALLTEXTPSLANRESNAME, this.getAllTextPSLanResName());
        }
        if (!bl || this.isBeginValuePSDEFIdDirty()) {
            hashMap.put(FIELD_BEGINVALUEPSDEFID, this.getBeginValuePSDEFId());
        }
        if (!bl || this.isBeginValuePSDEFNameDirty()) {
            hashMap.put(FIELD_BEGINVALUEPSDEFNAME, this.getBeginValuePSDEFName());
        }
        if (!bl || this.isBKColorPSDEFIdDirty()) {
            hashMap.put(FIELD_BKCOLORPSDEFID, this.getBKColorPSDEFId());
        }
        if (!bl || this.isBKColorPSDEFNameDirty()) {
            hashMap.put(FIELD_BKCOLORPSDEFNAME, this.getBKColorPSDEFName());
        }
        if (!bl || this.isCacheCatDirty()) {
            hashMap.put(FIELD_CACHECAT, this.getCacheCat());
        }
        if (!bl || this.isCacheTagDirty()) {
            hashMap.put(FIELD_CACHETAG, this.getCacheTag());
        }
        if (!bl || this.isCacheTimeoutDirty()) {
            hashMap.put(FIELD_CACHETIMEOUT, this.getCacheTimeout());
        }
        if (!bl || this.isCLModelDirty()) {
            hashMap.put(FIELD_CLMODEL, this.getCLModel());
        }
        if (!bl || this.isClsPSDEFIdDirty()) {
            hashMap.put(FIELD_CLSPSDEFID, this.getClsPSDEFId());
        }
        if (!bl || this.isClsPSDEFNameDirty()) {
            hashMap.put(FIELD_CLSPSDEFNAME, this.getClsPSDEFName());
        }
        if (!bl || this.isCLTypeDirty()) {
            hashMap.put(FIELD_CLTYPE, this.getCLType());
        }
        if (!bl || this.isCodeItemTagDirty()) {
            hashMap.put(FIELD_CODEITEMTAG, this.getCodeItemTag());
        }
        if (!bl || this.isCodeListSNDirty()) {
            hashMap.put(FIELD_CODELISTSN, this.getCodeListSN());
        }
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isColorPSDEFIdDirty()) {
            hashMap.put(FIELD_COLORPSDEFID, this.getColorPSDEFId());
        }
        if (!bl || this.isColorPSDEFNameDirty()) {
            hashMap.put(FIELD_COLORPSDEFNAME, this.getColorPSDEFName());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCustomCondDirty()) {
            hashMap.put(FIELD_CUSTOMCOND, this.getCustomCond());
        }
        if (!bl || this.isCustomTypeDirty()) {
            hashMap.put(FIELD_CUSTOMTYPE, this.getCustomType());
        }
        if (!bl || this.isDataPSDEFIdDirty()) {
            hashMap.put(FIELD_DATAPSDEFID, this.getDataPSDEFId());
        }
        if (!bl || this.isDataPSDEFNameDirty()) {
            hashMap.put(FIELD_DATAPSDEFNAME, this.getDataPSDEFName());
        }
        if (!bl || this.isDisablePSDEFIdDirty()) {
            hashMap.put(FIELD_DISABLEPSDEFID, this.getDisablePSDEFId());
        }
        if (!bl || this.isDisablePSDEFNameDirty()) {
            hashMap.put(FIELD_DISABLEPSDEFNAME, this.getDisablePSDEFName());
        }
        if (!bl || this.isDSConditionsDirty()) {
            hashMap.put(FIELD_DSCONDITIONS, this.getDSConditions());
        }
        if (!bl || this.isDynaModelFlagDirty()) {
            hashMap.put(FIELD_DYNAMODELFLAG, this.getDynaModelFlag());
        }
        if (!bl || this.isDynaSysRefModeDirty()) {
            hashMap.put(FIELD_DYNASYSREFMODE, this.getDynaSysRefMode());
        }
        if (!bl || this.isEmptyTextDirty()) {
            hashMap.put(FIELD_EMPTYTEXT, this.getEmptyText());
        }
        if (!bl || this.isEmptyTextPSLanResIdDirty()) {
            hashMap.put(FIELD_EMPTYTEXTPSLANRESID, this.getEmptyTextPSLanResId());
        }
        if (!bl || this.isEmptyTextPSLanResNameDirty()) {
            hashMap.put(FIELD_EMPTYTEXTPSLANRESNAME, this.getEmptyTextPSLanResName());
        }
        if (!bl || this.isEnableCacheDirty()) {
            hashMap.put(FIELD_ENABLECACHE, this.getEnableCache());
        }
        if (!bl || this.isEnableDynaSysDirty()) {
            hashMap.put(FIELD_ENABLEDYNASYS, this.getEnableDynaSys());
        }
        if (!bl || this.isEndValuePSDEFIdDirty()) {
            hashMap.put(FIELD_ENDVALUEPSDEFID, this.getEndValuePSDEFId());
        }
        if (!bl || this.isEndValuePSDEFNameDirty()) {
            hashMap.put(FIELD_ENDVALUEPSDEFNAME, this.getEndValuePSDEFName());
        }
        if (!bl || this.isExtendModeDirty()) {
            hashMap.put(FIELD_EXTENDMODE, this.getExtendMode());
        }
        if (!bl || this.isIconClsPSDEFIdDirty()) {
            hashMap.put(FIELD_ICONCLSPSDEFID, this.getIconClsPSDEFId());
        }
        if (!bl || this.isIconClsPSDEFNameDirty()) {
            hashMap.put(FIELD_ICONCLSPSDEFNAME, this.getIconClsPSDEFName());
        }
        if (!bl || this.isIconClsXPSDEFIdDirty()) {
            hashMap.put(FIELD_ICONCLSXPSDEFID, this.getIconClsXPSDEFId());
        }
        if (!bl || this.isIconClsXPSDEFNameDirty()) {
            hashMap.put(FIELD_ICONCLSXPSDEFNAME, this.getIconClsXPSDEFName());
        }
        if (!bl || this.isIconPathPSDEFIdDirty()) {
            hashMap.put(FIELD_ICONPATHPSDEFID, this.getIconPathPSDEFId());
        }
        if (!bl || this.isIconPathPSDEFNameDirty()) {
            hashMap.put(FIELD_ICONPATHPSDEFNAME, this.getIconPathPSDEFName());
        }
        if (!bl || this.isIconPathXPSDEFIdDirty()) {
            hashMap.put(FIELD_ICONPATHXPSDEFID, this.getIconPathXPSDEFId());
        }
        if (!bl || this.isIconPathXPSDEFNameDirty()) {
            hashMap.put(FIELD_ICONPATHXPSDEFNAME, this.getIconPathXPSDEFName());
        }
        if (!bl || this.isIncBeginValueDirty()) {
            hashMap.put(FIELD_INCBEGINVALUE, this.getIncBeginValue());
        }
        if (!bl || this.isIncEndValueDirty()) {
            hashMap.put(FIELD_INCENDVALUE, this.getIncEndValue());
        }
        if (!bl || this.isLinkPSDEViewIdDirty()) {
            hashMap.put(FIELD_LINKPSDEVIEWID, this.getLinkPSDEViewId());
        }
        if (!bl || this.isLinkPSDEViewNameDirty()) {
            hashMap.put(FIELD_LINKPSDEVIEWNAME, this.getLinkPSDEViewName());
        }
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMinorSortDirDirty()) {
            hashMap.put(FIELD_MINORSORTDIR, this.getMinorSortDir());
        }
        if (!bl || this.isMinorSortPSDEFIdDirty()) {
            hashMap.put(FIELD_MINORSORTPSDEFID, this.getMinorSortPSDEFId());
        }
        if (!bl || this.isMinorSortPSDEFNameDirty()) {
            hashMap.put(FIELD_MINORSORTPSDEFNAME, this.getMinorSortPSDEFName());
        }
        if (!bl || this.isModColorDirty()) {
            hashMap.put(FIELD_MODCOLOR, this.getModColor());
        }
        if (!bl || this.isNoValueEmptyDirty()) {
            hashMap.put(FIELD_NOVALUEEMPTY, this.getNoValueEmpty());
        }
        if (!bl || this.isNumberItemDirty()) {
            hashMap.put(FIELD_NUMBERITEM, this.getNumberItem());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isOrModeDirty()) {
            hashMap.put(FIELD_ORMODE, this.getOrMode());
        }
        if (!bl || this.isPredefinedTypeDirty()) {
            hashMap.put(FIELD_PREDEFINEDTYPE, this.getPredefinedType());
        }
        if (!bl || this.isPSCodeListIdDirty()) {
            hashMap.put(FIELD_PSCODELISTID, this.getPSCodeListId());
        }
        if (!bl || this.isPSCodeListNameDirty()) {
            hashMap.put(FIELD_PSCODELISTNAME, this.getPSCodeListName());
        }
        if (!bl || this.isPSCodeListTemplIdDirty()) {
            hashMap.put(FIELD_PSCODELISTTEMPLID, this.getPSCodeListTemplId());
        }
        if (!bl || this.isPSCodeListTemplNameDirty()) {
            hashMap.put(FIELD_PSCODELISTTEMPLNAME, this.getPSCodeListTemplName());
        }
        if (!bl || this.isPSDEDSIdDirty()) {
            hashMap.put(FIELD_PSDEDSID, this.getPSDEDSId());
        }
        if (!bl || this.isPSDEDSNameDirty()) {
            hashMap.put(FIELD_PSDEDSNAME, this.getPSDEDSName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDEMSLogicIdDirty()) {
            hashMap.put(FIELD_PSDEMSLOGICID, this.getPSDEMSLogicId());
        }
        if (!bl || this.isPSDEMSLogicNameDirty()) {
            hashMap.put(FIELD_PSDEMSLOGICNAME, this.getPSDEMSLogicName());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSDynaCodeListIdDirty()) {
            hashMap.put(FIELD_PSDYNACODELISTID, this.getPSDynaCodeListId());
        }
        if (!bl || this.isPSDynaCodeListNameDirty()) {
            hashMap.put(FIELD_PSDYNACODELISTNAME, this.getPSDynaCodeListName());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSDynaInstNameDirty()) {
            hashMap.put(FIELD_PSDYNAINSTNAME, this.getPSDynaInstName());
        }
        if (!bl || this.isPSModuleIdDirty()) {
            hashMap.put(FIELD_PSMODULEID, this.getPSModuleId());
        }
        if (!bl || this.isPSModuleNameDirty()) {
            hashMap.put(FIELD_PSMODULENAME, this.getPSModuleName());
        }
        if (!bl || this.isPSSysDynaModelIdDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELID, this.getPSSysDynaModelId());
        }
        if (!bl || this.isPSSysDynaModelNameDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELNAME, this.getPSSysDynaModelName());
        }
        if (!bl || this.isPSSysPFPluginIdDirty()) {
            hashMap.put(FIELD_PSSYSPFPLUGINID, this.getPSSysPFPluginId());
        }
        if (!bl || this.isPSSysPFPluginNameDirty()) {
            hashMap.put(FIELD_PSSYSPFPLUGINNAME, this.getPSSysPFPluginName());
        }
        if (!bl || this.isPSSysReqItemIdDirty()) {
            hashMap.put(FIELD_PSSYSREQITEMID, this.getPSSysReqItemId());
        }
        if (!bl || this.isPSSysReqItemNameDirty()) {
            hashMap.put(FIELD_PSSYSREQITEMNAME, this.getPSSysReqItemName());
        }
        if (!bl || this.isPSSysSFPluginIdDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINID, this.getPSSysSFPluginId());
        }
        if (!bl || this.isPSSysSFPluginNameDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINNAME, this.getPSSysSFPluginName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
        }
        if (!bl || this.isPValuePSDEFIdDirty()) {
            hashMap.put(FIELD_PVALUEPSDEFID, this.getPValuePSDEFId());
        }
        if (!bl || this.isPValuePSDEFNameDirty()) {
            hashMap.put(FIELD_PVALUEPSDEFNAME, this.getPValuePSDEFName());
        }
        if (!bl || this.isSeperatorDirty()) {
            hashMap.put(FIELD_SEPERATOR, this.getSeperator());
        }
        if (!bl || this.isSRFSysPubDirty()) {
            hashMap.put(FIELD_SRFSYSPUB, this.getSRFSysPub());
        }
        if (!bl || this.isSysRefFlagDirty()) {
            hashMap.put(FIELD_SYSREFFLAG, this.getSysRefFlag());
        }
        if (!bl || this.isTextPSDEFIdDirty()) {
            hashMap.put(FIELD_TEXTPSDEFID, this.getTextPSDEFId());
        }
        if (!bl || this.isTextPSDEFNameDirty()) {
            hashMap.put(FIELD_TEXTPSDEFNAME, this.getTextPSDEFName());
        }
        if (!bl || this.isThresholdGroupFlagDirty()) {
            hashMap.put(FIELD_THRESHOLDGROUPFLAG, this.getThresholdGroupFlag());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserCatDirty()) {
            hashMap.put(FIELD_USERCAT, this.getUserCat());
        }
        if (!bl || this.isUserDataDirty()) {
            hashMap.put(FIELD_USERDATA, this.getUserData());
        }
        if (!bl || this.isUserData2Dirty()) {
            hashMap.put(FIELD_USERDATA2, this.getUserData2());
        }
        if (!bl || this.isUserParamsDirty()) {
            hashMap.put(FIELD_USERPARAMS, this.getUserParams());
        }
        if (!bl || this.isUserRefFlagDirty()) {
            hashMap.put(FIELD_USERREFFLAG, this.getUserRefFlag());
        }
        if (!bl || this.isUserScopeDirty()) {
            hashMap.put(FIELD_USERSCOPE, this.getUserScope());
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
        if (!bl || this.isValuePSDEFIdDirty()) {
            hashMap.put(FIELD_VALUEPSDEFID, this.getValuePSDEFId());
        }
        if (!bl || this.isValuePSDEFNameDirty()) {
            hashMap.put(FIELD_VALUEPSDEFNAME, this.getValuePSDEFName());
        }
        if (!bl || this.isValueSeperatorDirty()) {
            hashMap.put(FIELD_VALUESEPERATOR, this.getValueSeperator());
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
        return PSCodeListBase.get(this, n);
    }

    private static Object get(PSCodeListBase pSCodeListBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCodeListBase.getAllText();
            }
            case 1: {
                return pSCodeListBase.getAllTextPSLanResId();
            }
            case 2: {
                return pSCodeListBase.getAllTextPSLanResName();
            }
            case 3: {
                return pSCodeListBase.getBeginValuePSDEFId();
            }
            case 4: {
                return pSCodeListBase.getBeginValuePSDEFName();
            }
            case 5: {
                return pSCodeListBase.getBKColorPSDEFId();
            }
            case 6: {
                return pSCodeListBase.getBKColorPSDEFName();
            }
            case 7: {
                return pSCodeListBase.getCacheCat();
            }
            case 8: {
                return pSCodeListBase.getCacheTag();
            }
            case 9: {
                return pSCodeListBase.getCacheTimeout();
            }
            case 10: {
                return pSCodeListBase.getCLModel();
            }
            case 11: {
                return pSCodeListBase.getClsPSDEFId();
            }
            case 12: {
                return pSCodeListBase.getClsPSDEFName();
            }
            case 13: {
                return pSCodeListBase.getCLType();
            }
            case 14: {
                return pSCodeListBase.getCodeItemTag();
            }
            case 15: {
                return pSCodeListBase.getCodeListSN();
            }
            case 16: {
                return pSCodeListBase.getCodeName();
            }
            case 17: {
                return pSCodeListBase.getColorPSDEFId();
            }
            case 18: {
                return pSCodeListBase.getColorPSDEFName();
            }
            case 19: {
                return pSCodeListBase.getCreateDate();
            }
            case 20: {
                return pSCodeListBase.getCreateMan();
            }
            case 21: {
                return pSCodeListBase.getCustomCond();
            }
            case 22: {
                return pSCodeListBase.getCustomType();
            }
            case 23: {
                return pSCodeListBase.getDataPSDEFId();
            }
            case 24: {
                return pSCodeListBase.getDataPSDEFName();
            }
            case 25: {
                return pSCodeListBase.getDisablePSDEFId();
            }
            case 26: {
                return pSCodeListBase.getDisablePSDEFName();
            }
            case 27: {
                return pSCodeListBase.getDSConditions();
            }
            case 28: {
                return pSCodeListBase.getDynaModelFlag();
            }
            case 29: {
                return pSCodeListBase.getDynaSysRefMode();
            }
            case 30: {
                return pSCodeListBase.getEmptyText();
            }
            case 31: {
                return pSCodeListBase.getEmptyTextPSLanResId();
            }
            case 32: {
                return pSCodeListBase.getEmptyTextPSLanResName();
            }
            case 33: {
                return pSCodeListBase.getEnableCache();
            }
            case 34: {
                return pSCodeListBase.getEnableDynaSys();
            }
            case 35: {
                return pSCodeListBase.getEndValuePSDEFId();
            }
            case 36: {
                return pSCodeListBase.getEndValuePSDEFName();
            }
            case 37: {
                return pSCodeListBase.getExtendMode();
            }
            case 38: {
                return pSCodeListBase.getIconClsPSDEFId();
            }
            case 39: {
                return pSCodeListBase.getIconClsPSDEFName();
            }
            case 40: {
                return pSCodeListBase.getIconClsXPSDEFId();
            }
            case 41: {
                return pSCodeListBase.getIconClsXPSDEFName();
            }
            case 42: {
                return pSCodeListBase.getIconPathPSDEFId();
            }
            case 43: {
                return pSCodeListBase.getIconPathPSDEFName();
            }
            case 44: {
                return pSCodeListBase.getIconPathXPSDEFId();
            }
            case 45: {
                return pSCodeListBase.getIconPathXPSDEFName();
            }
            case 46: {
                return pSCodeListBase.getIncBeginValue();
            }
            case 47: {
                return pSCodeListBase.getIncEndValue();
            }
            case 48: {
                return pSCodeListBase.getLinkPSDEViewId();
            }
            case 49: {
                return pSCodeListBase.getLinkPSDEViewName();
            }
            case 50: {
                return pSCodeListBase.getLockFlag();
            }
            case 51: {
                return pSCodeListBase.getMemo();
            }
            case 52: {
                return pSCodeListBase.getMinorSortDir();
            }
            case 53: {
                return pSCodeListBase.getMinorSortPSDEFId();
            }
            case 54: {
                return pSCodeListBase.getMinorSortPSDEFName();
            }
            case 55: {
                return pSCodeListBase.getModColor();
            }
            case 56: {
                return pSCodeListBase.getNoValueEmpty();
            }
            case 57: {
                return pSCodeListBase.getNumberItem();
            }
            case 58: {
                return pSCodeListBase.getOrderValue();
            }
            case 59: {
                return pSCodeListBase.getOrMode();
            }
            case 60: {
                return pSCodeListBase.getPredefinedType();
            }
            case 61: {
                return pSCodeListBase.getPSCodeListId();
            }
            case 62: {
                return pSCodeListBase.getPSCodeListName();
            }
            case 63: {
                return pSCodeListBase.getPSCodeListTemplId();
            }
            case 64: {
                return pSCodeListBase.getPSCodeListTemplName();
            }
            case 65: {
                return pSCodeListBase.getPSDEDSId();
            }
            case 66: {
                return pSCodeListBase.getPSDEDSName();
            }
            case 67: {
                return pSCodeListBase.getPSDEId();
            }
            case 68: {
                return pSCodeListBase.getPSDEMSLogicId();
            }
            case 69: {
                return pSCodeListBase.getPSDEMSLogicName();
            }
            case 70: {
                return pSCodeListBase.getPSDEName();
            }
            case 71: {
                return pSCodeListBase.getPSDynaCodeListId();
            }
            case 72: {
                return pSCodeListBase.getPSDynaCodeListName();
            }
            case 73: {
                return pSCodeListBase.getPSDynaInstId();
            }
            case 74: {
                return pSCodeListBase.getPSDynaInstName();
            }
            case 75: {
                return pSCodeListBase.getPSModuleId();
            }
            case 76: {
                return pSCodeListBase.getPSModuleName();
            }
            case 77: {
                return pSCodeListBase.getPSSysDynaModelId();
            }
            case 78: {
                return pSCodeListBase.getPSSysDynaModelName();
            }
            case 79: {
                return pSCodeListBase.getPSSysPFPluginId();
            }
            case 80: {
                return pSCodeListBase.getPSSysPFPluginName();
            }
            case 81: {
                return pSCodeListBase.getPSSysReqItemId();
            }
            case 82: {
                return pSCodeListBase.getPSSysReqItemName();
            }
            case 83: {
                return pSCodeListBase.getPSSysSFPluginId();
            }
            case 84: {
                return pSCodeListBase.getPSSysSFPluginName();
            }
            case 85: {
                return pSCodeListBase.getPSSystemId();
            }
            case 86: {
                return pSCodeListBase.getPSSystemName();
            }
            case 87: {
                return pSCodeListBase.getPValuePSDEFId();
            }
            case 88: {
                return pSCodeListBase.getPValuePSDEFName();
            }
            case 89: {
                return pSCodeListBase.getSeperator();
            }
            case 90: {
                return pSCodeListBase.getSRFSysPub();
            }
            case 91: {
                return pSCodeListBase.getSysRefFlag();
            }
            case 92: {
                return pSCodeListBase.getTextPSDEFId();
            }
            case 93: {
                return pSCodeListBase.getTextPSDEFName();
            }
            case 94: {
                return pSCodeListBase.getThresholdGroupFlag();
            }
            case 95: {
                return pSCodeListBase.getUpdateDate();
            }
            case 96: {
                return pSCodeListBase.getUpdateMan();
            }
            case 97: {
                return pSCodeListBase.getUserCat();
            }
            case 98: {
                return pSCodeListBase.getUserData();
            }
            case 99: {
                return pSCodeListBase.getUserData2();
            }
            case 100: {
                return pSCodeListBase.getUserParams();
            }
            case 101: {
                return pSCodeListBase.getUserRefFlag();
            }
            case 102: {
                return pSCodeListBase.getUserScope();
            }
            case 103: {
                return pSCodeListBase.getUserTag();
            }
            case 104: {
                return pSCodeListBase.getUserTag2();
            }
            case 105: {
                return pSCodeListBase.getUserTag3();
            }
            case 106: {
                return pSCodeListBase.getUserTag4();
            }
            case 107: {
                return pSCodeListBase.getValidFlag();
            }
            case 108: {
                return pSCodeListBase.getValuePSDEFId();
            }
            case 109: {
                return pSCodeListBase.getValuePSDEFName();
            }
            case 110: {
                return pSCodeListBase.getValueSeperator();
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
        PSCodeListBase.set(this, n, object);
    }

    private static void set(PSCodeListBase pSCodeListBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSCodeListBase.setAllText(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSCodeListBase.setAllTextPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSCodeListBase.setAllTextPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSCodeListBase.setBeginValuePSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSCodeListBase.setBeginValuePSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSCodeListBase.setBKColorPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSCodeListBase.setBKColorPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSCodeListBase.setCacheCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSCodeListBase.setCacheTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSCodeListBase.setCacheTimeout(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSCodeListBase.setCLModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSCodeListBase.setClsPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSCodeListBase.setClsPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSCodeListBase.setCLType(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSCodeListBase.setCodeItemTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSCodeListBase.setCodeListSN(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSCodeListBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSCodeListBase.setColorPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSCodeListBase.setColorPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSCodeListBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 20: {
                pSCodeListBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSCodeListBase.setCustomCond(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSCodeListBase.setCustomType(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSCodeListBase.setDataPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSCodeListBase.setDataPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSCodeListBase.setDisablePSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSCodeListBase.setDisablePSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSCodeListBase.setDSConditions(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSCodeListBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 29: {
                pSCodeListBase.setDynaSysRefMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 30: {
                pSCodeListBase.setEmptyText(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSCodeListBase.setEmptyTextPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSCodeListBase.setEmptyTextPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSCodeListBase.setEnableCache(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 34: {
                pSCodeListBase.setEnableDynaSys(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 35: {
                pSCodeListBase.setEndValuePSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSCodeListBase.setEndValuePSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSCodeListBase.setExtendMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 38: {
                pSCodeListBase.setIconClsPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSCodeListBase.setIconClsPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSCodeListBase.setIconClsXPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSCodeListBase.setIconClsXPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSCodeListBase.setIconPathPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSCodeListBase.setIconPathPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSCodeListBase.setIconPathXPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSCodeListBase.setIconPathXPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSCodeListBase.setIncBeginValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 47: {
                pSCodeListBase.setIncEndValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 48: {
                pSCodeListBase.setLinkPSDEViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSCodeListBase.setLinkPSDEViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSCodeListBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 51: {
                pSCodeListBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSCodeListBase.setMinorSortDir(DataObject.getStringValue((Object)object));
                return;
            }
            case 53: {
                pSCodeListBase.setMinorSortPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 54: {
                pSCodeListBase.setMinorSortPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 55: {
                pSCodeListBase.setModColor(DataObject.getStringValue((Object)object));
                return;
            }
            case 56: {
                pSCodeListBase.setNoValueEmpty(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 57: {
                pSCodeListBase.setNumberItem(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 58: {
                pSCodeListBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 59: {
                pSCodeListBase.setOrMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 60: {
                pSCodeListBase.setPredefinedType(DataObject.getStringValue((Object)object));
                return;
            }
            case 61: {
                pSCodeListBase.setPSCodeListId(DataObject.getStringValue((Object)object));
                return;
            }
            case 62: {
                pSCodeListBase.setPSCodeListName(DataObject.getStringValue((Object)object));
                return;
            }
            case 63: {
                pSCodeListBase.setPSCodeListTemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 64: {
                pSCodeListBase.setPSCodeListTemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 65: {
                pSCodeListBase.setPSDEDSId(DataObject.getStringValue((Object)object));
                return;
            }
            case 66: {
                pSCodeListBase.setPSDEDSName(DataObject.getStringValue((Object)object));
                return;
            }
            case 67: {
                pSCodeListBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 68: {
                pSCodeListBase.setPSDEMSLogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 69: {
                pSCodeListBase.setPSDEMSLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 70: {
                pSCodeListBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 71: {
                pSCodeListBase.setPSDynaCodeListId(DataObject.getStringValue((Object)object));
                return;
            }
            case 72: {
                pSCodeListBase.setPSDynaCodeListName(DataObject.getStringValue((Object)object));
                return;
            }
            case 73: {
                pSCodeListBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 74: {
                pSCodeListBase.setPSDynaInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 75: {
                pSCodeListBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 76: {
                pSCodeListBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 77: {
                pSCodeListBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 78: {
                pSCodeListBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 79: {
                pSCodeListBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 80: {
                pSCodeListBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 81: {
                pSCodeListBase.setPSSysReqItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 82: {
                pSCodeListBase.setPSSysReqItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 83: {
                pSCodeListBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 84: {
                pSCodeListBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 85: {
                pSCodeListBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 86: {
                pSCodeListBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 87: {
                pSCodeListBase.setPValuePSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 88: {
                pSCodeListBase.setPValuePSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 89: {
                pSCodeListBase.setSeperator(DataObject.getStringValue((Object)object));
                return;
            }
            case 90: {
                pSCodeListBase.setSRFSysPub(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 91: {
                pSCodeListBase.setSysRefFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 92: {
                pSCodeListBase.setTextPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 93: {
                pSCodeListBase.setTextPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 94: {
                pSCodeListBase.setThresholdGroupFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 95: {
                pSCodeListBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 96: {
                pSCodeListBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 97: {
                pSCodeListBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 98: {
                pSCodeListBase.setUserData(DataObject.getStringValue((Object)object));
                return;
            }
            case 99: {
                pSCodeListBase.setUserData2(DataObject.getStringValue((Object)object));
                return;
            }
            case 100: {
                pSCodeListBase.setUserParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 101: {
                pSCodeListBase.setUserRefFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 102: {
                pSCodeListBase.setUserScope(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 103: {
                pSCodeListBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 104: {
                pSCodeListBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 105: {
                pSCodeListBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 106: {
                pSCodeListBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 107: {
                pSCodeListBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 108: {
                pSCodeListBase.setValuePSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 109: {
                pSCodeListBase.setValuePSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 110: {
                pSCodeListBase.setValueSeperator(DataObject.getStringValue((Object)object));
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
        return PSCodeListBase.isNull(this, n);
    }

    private static boolean isNull(PSCodeListBase pSCodeListBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCodeListBase.getAllText() == null;
            }
            case 1: {
                return pSCodeListBase.getAllTextPSLanResId() == null;
            }
            case 2: {
                return pSCodeListBase.getAllTextPSLanResName() == null;
            }
            case 3: {
                return pSCodeListBase.getBeginValuePSDEFId() == null;
            }
            case 4: {
                return pSCodeListBase.getBeginValuePSDEFName() == null;
            }
            case 5: {
                return pSCodeListBase.getBKColorPSDEFId() == null;
            }
            case 6: {
                return pSCodeListBase.getBKColorPSDEFName() == null;
            }
            case 7: {
                return pSCodeListBase.getCacheCat() == null;
            }
            case 8: {
                return pSCodeListBase.getCacheTag() == null;
            }
            case 9: {
                return pSCodeListBase.getCacheTimeout() == null;
            }
            case 10: {
                return pSCodeListBase.getCLModel() == null;
            }
            case 11: {
                return pSCodeListBase.getClsPSDEFId() == null;
            }
            case 12: {
                return pSCodeListBase.getClsPSDEFName() == null;
            }
            case 13: {
                return pSCodeListBase.getCLType() == null;
            }
            case 14: {
                return pSCodeListBase.getCodeItemTag() == null;
            }
            case 15: {
                return pSCodeListBase.getCodeListSN() == null;
            }
            case 16: {
                return pSCodeListBase.getCodeName() == null;
            }
            case 17: {
                return pSCodeListBase.getColorPSDEFId() == null;
            }
            case 18: {
                return pSCodeListBase.getColorPSDEFName() == null;
            }
            case 19: {
                return pSCodeListBase.getCreateDate() == null;
            }
            case 20: {
                return pSCodeListBase.getCreateMan() == null;
            }
            case 21: {
                return pSCodeListBase.getCustomCond() == null;
            }
            case 22: {
                return pSCodeListBase.getCustomType() == null;
            }
            case 23: {
                return pSCodeListBase.getDataPSDEFId() == null;
            }
            case 24: {
                return pSCodeListBase.getDataPSDEFName() == null;
            }
            case 25: {
                return pSCodeListBase.getDisablePSDEFId() == null;
            }
            case 26: {
                return pSCodeListBase.getDisablePSDEFName() == null;
            }
            case 27: {
                return pSCodeListBase.getDSConditions() == null;
            }
            case 28: {
                return pSCodeListBase.getDynaModelFlag() == null;
            }
            case 29: {
                return pSCodeListBase.getDynaSysRefMode() == null;
            }
            case 30: {
                return pSCodeListBase.getEmptyText() == null;
            }
            case 31: {
                return pSCodeListBase.getEmptyTextPSLanResId() == null;
            }
            case 32: {
                return pSCodeListBase.getEmptyTextPSLanResName() == null;
            }
            case 33: {
                return pSCodeListBase.getEnableCache() == null;
            }
            case 34: {
                return pSCodeListBase.getEnableDynaSys() == null;
            }
            case 35: {
                return pSCodeListBase.getEndValuePSDEFId() == null;
            }
            case 36: {
                return pSCodeListBase.getEndValuePSDEFName() == null;
            }
            case 37: {
                return pSCodeListBase.getExtendMode() == null;
            }
            case 38: {
                return pSCodeListBase.getIconClsPSDEFId() == null;
            }
            case 39: {
                return pSCodeListBase.getIconClsPSDEFName() == null;
            }
            case 40: {
                return pSCodeListBase.getIconClsXPSDEFId() == null;
            }
            case 41: {
                return pSCodeListBase.getIconClsXPSDEFName() == null;
            }
            case 42: {
                return pSCodeListBase.getIconPathPSDEFId() == null;
            }
            case 43: {
                return pSCodeListBase.getIconPathPSDEFName() == null;
            }
            case 44: {
                return pSCodeListBase.getIconPathXPSDEFId() == null;
            }
            case 45: {
                return pSCodeListBase.getIconPathXPSDEFName() == null;
            }
            case 46: {
                return pSCodeListBase.getIncBeginValue() == null;
            }
            case 47: {
                return pSCodeListBase.getIncEndValue() == null;
            }
            case 48: {
                return pSCodeListBase.getLinkPSDEViewId() == null;
            }
            case 49: {
                return pSCodeListBase.getLinkPSDEViewName() == null;
            }
            case 50: {
                return pSCodeListBase.getLockFlag() == null;
            }
            case 51: {
                return pSCodeListBase.getMemo() == null;
            }
            case 52: {
                return pSCodeListBase.getMinorSortDir() == null;
            }
            case 53: {
                return pSCodeListBase.getMinorSortPSDEFId() == null;
            }
            case 54: {
                return pSCodeListBase.getMinorSortPSDEFName() == null;
            }
            case 55: {
                return pSCodeListBase.getModColor() == null;
            }
            case 56: {
                return pSCodeListBase.getNoValueEmpty() == null;
            }
            case 57: {
                return pSCodeListBase.getNumberItem() == null;
            }
            case 58: {
                return pSCodeListBase.getOrderValue() == null;
            }
            case 59: {
                return pSCodeListBase.getOrMode() == null;
            }
            case 60: {
                return pSCodeListBase.getPredefinedType() == null;
            }
            case 61: {
                return pSCodeListBase.getPSCodeListId() == null;
            }
            case 62: {
                return pSCodeListBase.getPSCodeListName() == null;
            }
            case 63: {
                return pSCodeListBase.getPSCodeListTemplId() == null;
            }
            case 64: {
                return pSCodeListBase.getPSCodeListTemplName() == null;
            }
            case 65: {
                return pSCodeListBase.getPSDEDSId() == null;
            }
            case 66: {
                return pSCodeListBase.getPSDEDSName() == null;
            }
            case 67: {
                return pSCodeListBase.getPSDEId() == null;
            }
            case 68: {
                return pSCodeListBase.getPSDEMSLogicId() == null;
            }
            case 69: {
                return pSCodeListBase.getPSDEMSLogicName() == null;
            }
            case 70: {
                return pSCodeListBase.getPSDEName() == null;
            }
            case 71: {
                return pSCodeListBase.getPSDynaCodeListId() == null;
            }
            case 72: {
                return pSCodeListBase.getPSDynaCodeListName() == null;
            }
            case 73: {
                return pSCodeListBase.getPSDynaInstId() == null;
            }
            case 74: {
                return pSCodeListBase.getPSDynaInstName() == null;
            }
            case 75: {
                return pSCodeListBase.getPSModuleId() == null;
            }
            case 76: {
                return pSCodeListBase.getPSModuleName() == null;
            }
            case 77: {
                return pSCodeListBase.getPSSysDynaModelId() == null;
            }
            case 78: {
                return pSCodeListBase.getPSSysDynaModelName() == null;
            }
            case 79: {
                return pSCodeListBase.getPSSysPFPluginId() == null;
            }
            case 80: {
                return pSCodeListBase.getPSSysPFPluginName() == null;
            }
            case 81: {
                return pSCodeListBase.getPSSysReqItemId() == null;
            }
            case 82: {
                return pSCodeListBase.getPSSysReqItemName() == null;
            }
            case 83: {
                return pSCodeListBase.getPSSysSFPluginId() == null;
            }
            case 84: {
                return pSCodeListBase.getPSSysSFPluginName() == null;
            }
            case 85: {
                return pSCodeListBase.getPSSystemId() == null;
            }
            case 86: {
                return pSCodeListBase.getPSSystemName() == null;
            }
            case 87: {
                return pSCodeListBase.getPValuePSDEFId() == null;
            }
            case 88: {
                return pSCodeListBase.getPValuePSDEFName() == null;
            }
            case 89: {
                return pSCodeListBase.getSeperator() == null;
            }
            case 90: {
                return pSCodeListBase.getSRFSysPub() == null;
            }
            case 91: {
                return pSCodeListBase.getSysRefFlag() == null;
            }
            case 92: {
                return pSCodeListBase.getTextPSDEFId() == null;
            }
            case 93: {
                return pSCodeListBase.getTextPSDEFName() == null;
            }
            case 94: {
                return pSCodeListBase.getThresholdGroupFlag() == null;
            }
            case 95: {
                return pSCodeListBase.getUpdateDate() == null;
            }
            case 96: {
                return pSCodeListBase.getUpdateMan() == null;
            }
            case 97: {
                return pSCodeListBase.getUserCat() == null;
            }
            case 98: {
                return pSCodeListBase.getUserData() == null;
            }
            case 99: {
                return pSCodeListBase.getUserData2() == null;
            }
            case 100: {
                return pSCodeListBase.getUserParams() == null;
            }
            case 101: {
                return pSCodeListBase.getUserRefFlag() == null;
            }
            case 102: {
                return pSCodeListBase.getUserScope() == null;
            }
            case 103: {
                return pSCodeListBase.getUserTag() == null;
            }
            case 104: {
                return pSCodeListBase.getUserTag2() == null;
            }
            case 105: {
                return pSCodeListBase.getUserTag3() == null;
            }
            case 106: {
                return pSCodeListBase.getUserTag4() == null;
            }
            case 107: {
                return pSCodeListBase.getValidFlag() == null;
            }
            case 108: {
                return pSCodeListBase.getValuePSDEFId() == null;
            }
            case 109: {
                return pSCodeListBase.getValuePSDEFName() == null;
            }
            case 110: {
                return pSCodeListBase.getValueSeperator() == null;
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
        return PSCodeListBase.contains(this, n);
    }

    private static boolean contains(PSCodeListBase pSCodeListBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCodeListBase.isAllTextDirty();
            }
            case 1: {
                return pSCodeListBase.isAllTextPSLanResIdDirty();
            }
            case 2: {
                return pSCodeListBase.isAllTextPSLanResNameDirty();
            }
            case 3: {
                return pSCodeListBase.isBeginValuePSDEFIdDirty();
            }
            case 4: {
                return pSCodeListBase.isBeginValuePSDEFNameDirty();
            }
            case 5: {
                return pSCodeListBase.isBKColorPSDEFIdDirty();
            }
            case 6: {
                return pSCodeListBase.isBKColorPSDEFNameDirty();
            }
            case 7: {
                return pSCodeListBase.isCacheCatDirty();
            }
            case 8: {
                return pSCodeListBase.isCacheTagDirty();
            }
            case 9: {
                return pSCodeListBase.isCacheTimeoutDirty();
            }
            case 10: {
                return pSCodeListBase.isCLModelDirty();
            }
            case 11: {
                return pSCodeListBase.isClsPSDEFIdDirty();
            }
            case 12: {
                return pSCodeListBase.isClsPSDEFNameDirty();
            }
            case 13: {
                return pSCodeListBase.isCLTypeDirty();
            }
            case 14: {
                return pSCodeListBase.isCodeItemTagDirty();
            }
            case 15: {
                return pSCodeListBase.isCodeListSNDirty();
            }
            case 16: {
                return pSCodeListBase.isCodeNameDirty();
            }
            case 17: {
                return pSCodeListBase.isColorPSDEFIdDirty();
            }
            case 18: {
                return pSCodeListBase.isColorPSDEFNameDirty();
            }
            case 19: {
                return pSCodeListBase.isCreateDateDirty();
            }
            case 20: {
                return pSCodeListBase.isCreateManDirty();
            }
            case 21: {
                return pSCodeListBase.isCustomCondDirty();
            }
            case 22: {
                return pSCodeListBase.isCustomTypeDirty();
            }
            case 23: {
                return pSCodeListBase.isDataPSDEFIdDirty();
            }
            case 24: {
                return pSCodeListBase.isDataPSDEFNameDirty();
            }
            case 25: {
                return pSCodeListBase.isDisablePSDEFIdDirty();
            }
            case 26: {
                return pSCodeListBase.isDisablePSDEFNameDirty();
            }
            case 27: {
                return pSCodeListBase.isDSConditionsDirty();
            }
            case 28: {
                return pSCodeListBase.isDynaModelFlagDirty();
            }
            case 29: {
                return pSCodeListBase.isDynaSysRefModeDirty();
            }
            case 30: {
                return pSCodeListBase.isEmptyTextDirty();
            }
            case 31: {
                return pSCodeListBase.isEmptyTextPSLanResIdDirty();
            }
            case 32: {
                return pSCodeListBase.isEmptyTextPSLanResNameDirty();
            }
            case 33: {
                return pSCodeListBase.isEnableCacheDirty();
            }
            case 34: {
                return pSCodeListBase.isEnableDynaSysDirty();
            }
            case 35: {
                return pSCodeListBase.isEndValuePSDEFIdDirty();
            }
            case 36: {
                return pSCodeListBase.isEndValuePSDEFNameDirty();
            }
            case 37: {
                return pSCodeListBase.isExtendModeDirty();
            }
            case 38: {
                return pSCodeListBase.isIconClsPSDEFIdDirty();
            }
            case 39: {
                return pSCodeListBase.isIconClsPSDEFNameDirty();
            }
            case 40: {
                return pSCodeListBase.isIconClsXPSDEFIdDirty();
            }
            case 41: {
                return pSCodeListBase.isIconClsXPSDEFNameDirty();
            }
            case 42: {
                return pSCodeListBase.isIconPathPSDEFIdDirty();
            }
            case 43: {
                return pSCodeListBase.isIconPathPSDEFNameDirty();
            }
            case 44: {
                return pSCodeListBase.isIconPathXPSDEFIdDirty();
            }
            case 45: {
                return pSCodeListBase.isIconPathXPSDEFNameDirty();
            }
            case 46: {
                return pSCodeListBase.isIncBeginValueDirty();
            }
            case 47: {
                return pSCodeListBase.isIncEndValueDirty();
            }
            case 48: {
                return pSCodeListBase.isLinkPSDEViewIdDirty();
            }
            case 49: {
                return pSCodeListBase.isLinkPSDEViewNameDirty();
            }
            case 50: {
                return pSCodeListBase.isLockFlagDirty();
            }
            case 51: {
                return pSCodeListBase.isMemoDirty();
            }
            case 52: {
                return pSCodeListBase.isMinorSortDirDirty();
            }
            case 53: {
                return pSCodeListBase.isMinorSortPSDEFIdDirty();
            }
            case 54: {
                return pSCodeListBase.isMinorSortPSDEFNameDirty();
            }
            case 55: {
                return pSCodeListBase.isModColorDirty();
            }
            case 56: {
                return pSCodeListBase.isNoValueEmptyDirty();
            }
            case 57: {
                return pSCodeListBase.isNumberItemDirty();
            }
            case 58: {
                return pSCodeListBase.isOrderValueDirty();
            }
            case 59: {
                return pSCodeListBase.isOrModeDirty();
            }
            case 60: {
                return pSCodeListBase.isPredefinedTypeDirty();
            }
            case 61: {
                return pSCodeListBase.isPSCodeListIdDirty();
            }
            case 62: {
                return pSCodeListBase.isPSCodeListNameDirty();
            }
            case 63: {
                return pSCodeListBase.isPSCodeListTemplIdDirty();
            }
            case 64: {
                return pSCodeListBase.isPSCodeListTemplNameDirty();
            }
            case 65: {
                return pSCodeListBase.isPSDEDSIdDirty();
            }
            case 66: {
                return pSCodeListBase.isPSDEDSNameDirty();
            }
            case 67: {
                return pSCodeListBase.isPSDEIdDirty();
            }
            case 68: {
                return pSCodeListBase.isPSDEMSLogicIdDirty();
            }
            case 69: {
                return pSCodeListBase.isPSDEMSLogicNameDirty();
            }
            case 70: {
                return pSCodeListBase.isPSDENameDirty();
            }
            case 71: {
                return pSCodeListBase.isPSDynaCodeListIdDirty();
            }
            case 72: {
                return pSCodeListBase.isPSDynaCodeListNameDirty();
            }
            case 73: {
                return pSCodeListBase.isPSDynaInstIdDirty();
            }
            case 74: {
                return pSCodeListBase.isPSDynaInstNameDirty();
            }
            case 75: {
                return pSCodeListBase.isPSModuleIdDirty();
            }
            case 76: {
                return pSCodeListBase.isPSModuleNameDirty();
            }
            case 77: {
                return pSCodeListBase.isPSSysDynaModelIdDirty();
            }
            case 78: {
                return pSCodeListBase.isPSSysDynaModelNameDirty();
            }
            case 79: {
                return pSCodeListBase.isPSSysPFPluginIdDirty();
            }
            case 80: {
                return pSCodeListBase.isPSSysPFPluginNameDirty();
            }
            case 81: {
                return pSCodeListBase.isPSSysReqItemIdDirty();
            }
            case 82: {
                return pSCodeListBase.isPSSysReqItemNameDirty();
            }
            case 83: {
                return pSCodeListBase.isPSSysSFPluginIdDirty();
            }
            case 84: {
                return pSCodeListBase.isPSSysSFPluginNameDirty();
            }
            case 85: {
                return pSCodeListBase.isPSSystemIdDirty();
            }
            case 86: {
                return pSCodeListBase.isPSSystemNameDirty();
            }
            case 87: {
                return pSCodeListBase.isPValuePSDEFIdDirty();
            }
            case 88: {
                return pSCodeListBase.isPValuePSDEFNameDirty();
            }
            case 89: {
                return pSCodeListBase.isSeperatorDirty();
            }
            case 90: {
                return pSCodeListBase.isSRFSysPubDirty();
            }
            case 91: {
                return pSCodeListBase.isSysRefFlagDirty();
            }
            case 92: {
                return pSCodeListBase.isTextPSDEFIdDirty();
            }
            case 93: {
                return pSCodeListBase.isTextPSDEFNameDirty();
            }
            case 94: {
                return pSCodeListBase.isThresholdGroupFlagDirty();
            }
            case 95: {
                return pSCodeListBase.isUpdateDateDirty();
            }
            case 96: {
                return pSCodeListBase.isUpdateManDirty();
            }
            case 97: {
                return pSCodeListBase.isUserCatDirty();
            }
            case 98: {
                return pSCodeListBase.isUserDataDirty();
            }
            case 99: {
                return pSCodeListBase.isUserData2Dirty();
            }
            case 100: {
                return pSCodeListBase.isUserParamsDirty();
            }
            case 101: {
                return pSCodeListBase.isUserRefFlagDirty();
            }
            case 102: {
                return pSCodeListBase.isUserScopeDirty();
            }
            case 103: {
                return pSCodeListBase.isUserTagDirty();
            }
            case 104: {
                return pSCodeListBase.isUserTag2Dirty();
            }
            case 105: {
                return pSCodeListBase.isUserTag3Dirty();
            }
            case 106: {
                return pSCodeListBase.isUserTag4Dirty();
            }
            case 107: {
                return pSCodeListBase.isValidFlagDirty();
            }
            case 108: {
                return pSCodeListBase.isValuePSDEFIdDirty();
            }
            case 109: {
                return pSCodeListBase.isValuePSDEFNameDirty();
            }
            case 110: {
                return pSCodeListBase.isValueSeperatorDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSCodeListBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSCodeListBase pSCodeListBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSCodeListBase.getAllText() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"alltext", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getAllText()), (boolean)false);
        }
        if (bl || pSCodeListBase.getAllTextPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"alltextpslanresid", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getAllTextPSLanResId()), (boolean)false);
        }
        if (bl || pSCodeListBase.getAllTextPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"alltextpslanresname", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getAllTextPSLanResName()), (boolean)false);
        }
        if (bl || pSCodeListBase.getBeginValuePSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"beginvaluepsdefid", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getBeginValuePSDEFId()), (boolean)false);
        }
        if (bl || pSCodeListBase.getBeginValuePSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"beginvaluepsdefname", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getBeginValuePSDEFName()), (boolean)false);
        }
        if (bl || pSCodeListBase.getBKColorPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bkcolorpsdefid", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getBKColorPSDEFId()), (boolean)false);
        }
        if (bl || pSCodeListBase.getBKColorPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bkcolorpsdefname", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getBKColorPSDEFName()), (boolean)false);
        }
        if (bl || pSCodeListBase.getCacheCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cachecat", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getCacheCat()), (boolean)false);
        }
        if (bl || pSCodeListBase.getCacheTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cachetag", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getCacheTag()), (boolean)false);
        }
        if (bl || pSCodeListBase.getCacheTimeout() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cachetimeout", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getCacheTimeout()), (boolean)false);
        }
        if (bl || pSCodeListBase.getCLModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"clmodel", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getCLModel()), (boolean)false);
        }
        if (bl || pSCodeListBase.getClsPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"clspsdefid", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getClsPSDEFId()), (boolean)false);
        }
        if (bl || pSCodeListBase.getClsPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"clspsdefname", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getClsPSDEFName()), (boolean)false);
        }
        if (bl || pSCodeListBase.getCLType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cltype", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getCLType()), (boolean)false);
        }
        if (bl || pSCodeListBase.getCodeItemTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codeitemtag", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getCodeItemTag()), (boolean)false);
        }
        if (bl || pSCodeListBase.getCodeListSN() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codelistsn", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getCodeListSN()), (boolean)false);
        }
        if (bl || pSCodeListBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getCodeName()), (boolean)false);
        }
        if (bl || pSCodeListBase.getColorPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"colorpsdefid", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getColorPSDEFId()), (boolean)false);
        }
        if (bl || pSCodeListBase.getColorPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"colorpsdefname", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getColorPSDEFName()), (boolean)false);
        }
        if (bl || pSCodeListBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSCodeListBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSCodeListBase.getCustomCond() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcond", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getCustomCond()), (boolean)false);
        }
        if (bl || pSCodeListBase.getCustomType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customtype", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getCustomType()), (boolean)false);
        }
        if (bl || pSCodeListBase.getDataPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"datapsdefid", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getDataPSDEFId()), (boolean)false);
        }
        if (bl || pSCodeListBase.getDataPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"datapsdefname", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getDataPSDEFName()), (boolean)false);
        }
        if (bl || pSCodeListBase.getDisablePSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"disablepsdefid", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getDisablePSDEFId()), (boolean)false);
        }
        if (bl || pSCodeListBase.getDisablePSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"disablepsdefname", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getDisablePSDEFName()), (boolean)false);
        }
        if (bl || pSCodeListBase.getDSConditions() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dsconditions", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getDSConditions()), (boolean)false);
        }
        if (bl || pSCodeListBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSCodeListBase.getDynaSysRefMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynasysrefmode", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getDynaSysRefMode()), (boolean)false);
        }
        if (bl || pSCodeListBase.getEmptyText() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"emptytext", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getEmptyText()), (boolean)false);
        }
        if (bl || pSCodeListBase.getEmptyTextPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"emptytextpslanresid", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getEmptyTextPSLanResId()), (boolean)false);
        }
        if (bl || pSCodeListBase.getEmptyTextPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"emptytextpslanresname", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getEmptyTextPSLanResName()), (boolean)false);
        }
        if (bl || pSCodeListBase.getEnableCache() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablecache", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getEnableCache()), (boolean)false);
        }
        if (bl || pSCodeListBase.getEnableDynaSys() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enabledynasys", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getEnableDynaSys()), (boolean)false);
        }
        if (bl || pSCodeListBase.getEndValuePSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"endvaluepsdefid", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getEndValuePSDEFId()), (boolean)false);
        }
        if (bl || pSCodeListBase.getEndValuePSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"endvaluepsdefname", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getEndValuePSDEFName()), (boolean)false);
        }
        if (bl || pSCodeListBase.getExtendMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"extendmode", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getExtendMode()), (boolean)false);
        }
        if (bl || pSCodeListBase.getIconClsPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"iconclspsdefid", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getIconClsPSDEFId()), (boolean)false);
        }
        if (bl || pSCodeListBase.getIconClsPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"iconclspsdefname", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getIconClsPSDEFName()), (boolean)false);
        }
        if (bl || pSCodeListBase.getIconClsXPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"iconclsxpsdefid", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getIconClsXPSDEFId()), (boolean)false);
        }
        if (bl || pSCodeListBase.getIconClsXPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"iconclsxpsdefname", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getIconClsXPSDEFName()), (boolean)false);
        }
        if (bl || pSCodeListBase.getIconPathPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"iconpathpsdefid", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getIconPathPSDEFId()), (boolean)false);
        }
        if (bl || pSCodeListBase.getIconPathPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"iconpathpsdefname", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getIconPathPSDEFName()), (boolean)false);
        }
        if (bl || pSCodeListBase.getIconPathXPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"iconpathxpsdefid", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getIconPathXPSDEFId()), (boolean)false);
        }
        if (bl || pSCodeListBase.getIconPathXPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"iconpathxpsdefname", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getIconPathXPSDEFName()), (boolean)false);
        }
        if (bl || pSCodeListBase.getIncBeginValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"incbeginvalue", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getIncBeginValue()), (boolean)false);
        }
        if (bl || pSCodeListBase.getIncEndValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"incendvalue", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getIncEndValue()), (boolean)false);
        }
        if (bl || pSCodeListBase.getLinkPSDEViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"linkpsdeviewid", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getLinkPSDEViewId()), (boolean)false);
        }
        if (bl || pSCodeListBase.getLinkPSDEViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"linkpsdeviewname", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getLinkPSDEViewName()), (boolean)false);
        }
        if (bl || pSCodeListBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSCodeListBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getMemo()), (boolean)false);
        }
        if (bl || pSCodeListBase.getMinorSortDir() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minorsortdir", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getMinorSortDir()), (boolean)false);
        }
        if (bl || pSCodeListBase.getMinorSortPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minorsortpsdefid", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getMinorSortPSDEFId()), (boolean)false);
        }
        if (bl || pSCodeListBase.getMinorSortPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minorsortpsdefname", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getMinorSortPSDEFName()), (boolean)false);
        }
        if (bl || pSCodeListBase.getModColor() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modcolor", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getModColor()), (boolean)false);
        }
        if (bl || pSCodeListBase.getNoValueEmpty() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"novalueempty", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getNoValueEmpty()), (boolean)false);
        }
        if (bl || pSCodeListBase.getNumberItem() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"numberitem", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getNumberItem()), (boolean)false);
        }
        if (bl || pSCodeListBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSCodeListBase.getOrMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ormode", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getOrMode()), (boolean)false);
        }
        if (bl || pSCodeListBase.getPredefinedType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"predefinedtype", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getPredefinedType()), (boolean)false);
        }
        if (bl || pSCodeListBase.getPSCodeListId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscodelistid", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getPSCodeListId()), (boolean)false);
        }
        if (bl || pSCodeListBase.getPSCodeListName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscodelistname", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getPSCodeListName()), (boolean)false);
        }
        if (bl || pSCodeListBase.getPSCodeListTemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscodelisttemplid", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getPSCodeListTemplId()), (boolean)false);
        }
        if (bl || pSCodeListBase.getPSCodeListTemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscodelisttemplname", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getPSCodeListTemplName()), (boolean)false);
        }
        if (bl || pSCodeListBase.getPSDEDSId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedsid", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getPSDEDSId()), (boolean)false);
        }
        if (bl || pSCodeListBase.getPSDEDSName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedsname", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getPSDEDSName()), (boolean)false);
        }
        if (bl || pSCodeListBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSCodeListBase.getPSDEMSLogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdemslogicid", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getPSDEMSLogicId()), (boolean)false);
        }
        if (bl || pSCodeListBase.getPSDEMSLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdemslogicname", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getPSDEMSLogicName()), (boolean)false);
        }
        if (bl || pSCodeListBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSCodeListBase.getPSDynaCodeListId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynacodelistid", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getPSDynaCodeListId()), (boolean)false);
        }
        if (bl || pSCodeListBase.getPSDynaCodeListName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynacodelistname", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getPSDynaCodeListName()), (boolean)false);
        }
        if (bl || pSCodeListBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSCodeListBase.getPSDynaInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstname", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getPSDynaInstName()), (boolean)false);
        }
        if (bl || pSCodeListBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSCodeListBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSCodeListBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSCodeListBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSCodeListBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSCodeListBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSCodeListBase.getPSSysReqItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemid", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getPSSysReqItemId()), (boolean)false);
        }
        if (bl || pSCodeListBase.getPSSysReqItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemname", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getPSSysReqItemName()), (boolean)false);
        }
        if (bl || pSCodeListBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSCodeListBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSCodeListBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSCodeListBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSCodeListBase.getPValuePSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pvaluepsdefid", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getPValuePSDEFId()), (boolean)false);
        }
        if (bl || pSCodeListBase.getPValuePSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pvaluepsdefname", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getPValuePSDEFName()), (boolean)false);
        }
        if (bl || pSCodeListBase.getSeperator() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"seperator", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getSeperator()), (boolean)false);
        }
        if (bl || pSCodeListBase.getSRFSysPub() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srfsyspub", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getSRFSysPub()), (boolean)false);
        }
        if (bl || pSCodeListBase.getSysRefFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sysrefflag", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getSysRefFlag()), (boolean)false);
        }
        if (bl || pSCodeListBase.getTextPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"textpsdefid", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getTextPSDEFId()), (boolean)false);
        }
        if (bl || pSCodeListBase.getTextPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"textpsdefname", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getTextPSDEFName()), (boolean)false);
        }
        if (bl || pSCodeListBase.getThresholdGroupFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"thresholdgroupflag", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getThresholdGroupFlag()), (boolean)false);
        }
        if (bl || pSCodeListBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSCodeListBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSCodeListBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getUserCat()), (boolean)false);
        }
        if (bl || pSCodeListBase.getUserData() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userdata", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getUserData()), (boolean)false);
        }
        if (bl || pSCodeListBase.getUserData2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userdata2", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getUserData2()), (boolean)false);
        }
        if (bl || pSCodeListBase.getUserParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userparams", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getUserParams()), (boolean)false);
        }
        if (bl || pSCodeListBase.getUserRefFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userrefflag", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getUserRefFlag()), (boolean)false);
        }
        if (bl || pSCodeListBase.getUserScope() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userscope", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getUserScope()), (boolean)false);
        }
        if (bl || pSCodeListBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getUserTag()), (boolean)false);
        }
        if (bl || pSCodeListBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSCodeListBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSCodeListBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSCodeListBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSCodeListBase.getValuePSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"valuepsdefid", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getValuePSDEFId()), (boolean)false);
        }
        if (bl || pSCodeListBase.getValuePSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"valuepsdefname", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getValuePSDEFName()), (boolean)false);
        }
        if (bl || pSCodeListBase.getValueSeperator() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"valueseperator", (Object)PSCodeListBase.getJSONValue((Object)pSCodeListBase.getValueSeperator()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSCodeListBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSCodeListBase pSCodeListBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSCodeListBase.getAllText() != null) {
            object = pSCodeListBase.getAllText();
            xmlNode.setAttribute(FIELD_ALLTEXT, (String)(object == null ? "" : object));
        }
        if (bl || pSCodeListBase.getAllTextPSLanResId() != null) {
            object = pSCodeListBase.getAllTextPSLanResId();
            xmlNode.setAttribute(FIELD_ALLTEXTPSLANRESID, (String)(object == null ? "" : object));
        }
        if (bl || pSCodeListBase.getAllTextPSLanResName() != null) {
            object = pSCodeListBase.getAllTextPSLanResName();
            xmlNode.setAttribute(FIELD_ALLTEXTPSLANRESNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSCodeListBase.getBeginValuePSDEFId() != null) {
            object = pSCodeListBase.getBeginValuePSDEFId();
            xmlNode.setAttribute(FIELD_BEGINVALUEPSDEFID, (String)(object == null ? "" : object));
        }
        if (bl || pSCodeListBase.getBeginValuePSDEFName() != null) {
            object = pSCodeListBase.getBeginValuePSDEFName();
            xmlNode.setAttribute(FIELD_BEGINVALUEPSDEFNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSCodeListBase.getBKColorPSDEFId() != null) {
            object = pSCodeListBase.getBKColorPSDEFId();
            xmlNode.setAttribute(FIELD_BKCOLORPSDEFID, (String)(object == null ? "" : object));
        }
        if (bl || pSCodeListBase.getBKColorPSDEFName() != null) {
            object = pSCodeListBase.getBKColorPSDEFName();
            xmlNode.setAttribute(FIELD_BKCOLORPSDEFNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSCodeListBase.getCacheCat() != null) {
            object = pSCodeListBase.getCacheCat();
            xmlNode.setAttribute(FIELD_CACHECAT, (String)(object == null ? "" : object));
        }
        if (bl || pSCodeListBase.getCacheTag() != null) {
            object = pSCodeListBase.getCacheTag();
            xmlNode.setAttribute(FIELD_CACHETAG, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getCacheTimeout() != null) {
            object = pSCodeListBase.getCacheTimeout();
            xmlNode.setAttribute(FIELD_CACHETIMEOUT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSCodeListBase.getCLModel() != null) {
            object = pSCodeListBase.getCLModel();
            xmlNode.setAttribute(FIELD_CLMODEL, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getClsPSDEFId() != null) {
            object = pSCodeListBase.getClsPSDEFId();
            xmlNode.setAttribute(FIELD_CLSPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getClsPSDEFName() != null) {
            object = pSCodeListBase.getClsPSDEFName();
            xmlNode.setAttribute(FIELD_CLSPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getCLType() != null) {
            object = pSCodeListBase.getCLType();
            xmlNode.setAttribute(FIELD_CLTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getCodeItemTag() != null) {
            object = pSCodeListBase.getCodeItemTag();
            xmlNode.setAttribute(FIELD_CODEITEMTAG, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getCodeListSN() != null) {
            object = pSCodeListBase.getCodeListSN();
            xmlNode.setAttribute(FIELD_CODELISTSN, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getCodeName() != null) {
            object = pSCodeListBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getColorPSDEFId() != null) {
            object = pSCodeListBase.getColorPSDEFId();
            xmlNode.setAttribute(FIELD_COLORPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getColorPSDEFName() != null) {
            object = pSCodeListBase.getColorPSDEFName();
            xmlNode.setAttribute(FIELD_COLORPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getCreateDate() != null) {
            object = pSCodeListBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCodeListBase.getCreateMan() != null) {
            object = pSCodeListBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getCustomCond() != null) {
            object = pSCodeListBase.getCustomCond();
            xmlNode.setAttribute(FIELD_CUSTOMCOND, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getCustomType() != null) {
            object = pSCodeListBase.getCustomType();
            xmlNode.setAttribute(FIELD_CUSTOMTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getDataPSDEFId() != null) {
            object = pSCodeListBase.getDataPSDEFId();
            xmlNode.setAttribute(FIELD_DATAPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getDataPSDEFName() != null) {
            object = pSCodeListBase.getDataPSDEFName();
            xmlNode.setAttribute(FIELD_DATAPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getDisablePSDEFId() != null) {
            object = pSCodeListBase.getDisablePSDEFId();
            xmlNode.setAttribute(FIELD_DISABLEPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getDisablePSDEFName() != null) {
            object = pSCodeListBase.getDisablePSDEFName();
            xmlNode.setAttribute(FIELD_DISABLEPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getDSConditions() != null) {
            object = pSCodeListBase.getDSConditions();
            xmlNode.setAttribute(FIELD_DSCONDITIONS, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getDynaModelFlag() != null) {
            object = pSCodeListBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSCodeListBase.getDynaSysRefMode() != null) {
            object = pSCodeListBase.getDynaSysRefMode();
            xmlNode.setAttribute(FIELD_DYNASYSREFMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSCodeListBase.getEmptyText() != null) {
            object = pSCodeListBase.getEmptyText();
            xmlNode.setAttribute(FIELD_EMPTYTEXT, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getEmptyTextPSLanResId() != null) {
            object = pSCodeListBase.getEmptyTextPSLanResId();
            xmlNode.setAttribute(FIELD_EMPTYTEXTPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getEmptyTextPSLanResName() != null) {
            object = pSCodeListBase.getEmptyTextPSLanResName();
            xmlNode.setAttribute(FIELD_EMPTYTEXTPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getEnableCache() != null) {
            object = pSCodeListBase.getEnableCache();
            xmlNode.setAttribute(FIELD_ENABLECACHE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSCodeListBase.getEnableDynaSys() != null) {
            object = pSCodeListBase.getEnableDynaSys();
            xmlNode.setAttribute(FIELD_ENABLEDYNASYS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSCodeListBase.getEndValuePSDEFId() != null) {
            object = pSCodeListBase.getEndValuePSDEFId();
            xmlNode.setAttribute(FIELD_ENDVALUEPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getEndValuePSDEFName() != null) {
            object = pSCodeListBase.getEndValuePSDEFName();
            xmlNode.setAttribute(FIELD_ENDVALUEPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getExtendMode() != null) {
            object = pSCodeListBase.getExtendMode();
            xmlNode.setAttribute(FIELD_EXTENDMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSCodeListBase.getIconClsPSDEFId() != null) {
            object = pSCodeListBase.getIconClsPSDEFId();
            xmlNode.setAttribute(FIELD_ICONCLSPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getIconClsPSDEFName() != null) {
            object = pSCodeListBase.getIconClsPSDEFName();
            xmlNode.setAttribute(FIELD_ICONCLSPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getIconClsXPSDEFId() != null) {
            object = pSCodeListBase.getIconClsXPSDEFId();
            xmlNode.setAttribute(FIELD_ICONCLSXPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getIconClsXPSDEFName() != null) {
            object = pSCodeListBase.getIconClsXPSDEFName();
            xmlNode.setAttribute(FIELD_ICONCLSXPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getIconPathPSDEFId() != null) {
            object = pSCodeListBase.getIconPathPSDEFId();
            xmlNode.setAttribute(FIELD_ICONPATHPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getIconPathPSDEFName() != null) {
            object = pSCodeListBase.getIconPathPSDEFName();
            xmlNode.setAttribute(FIELD_ICONPATHPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getIconPathXPSDEFId() != null) {
            object = pSCodeListBase.getIconPathXPSDEFId();
            xmlNode.setAttribute(FIELD_ICONPATHXPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getIconPathXPSDEFName() != null) {
            object = pSCodeListBase.getIconPathXPSDEFName();
            xmlNode.setAttribute(FIELD_ICONPATHXPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getIncBeginValue() != null) {
            object = pSCodeListBase.getIncBeginValue();
            xmlNode.setAttribute(FIELD_INCBEGINVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSCodeListBase.getIncEndValue() != null) {
            object = pSCodeListBase.getIncEndValue();
            xmlNode.setAttribute(FIELD_INCENDVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSCodeListBase.getLinkPSDEViewId() != null) {
            object = pSCodeListBase.getLinkPSDEViewId();
            xmlNode.setAttribute(FIELD_LINKPSDEVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getLinkPSDEViewName() != null) {
            object = pSCodeListBase.getLinkPSDEViewName();
            xmlNode.setAttribute(FIELD_LINKPSDEVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getLockFlag() != null) {
            object = pSCodeListBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSCodeListBase.getMemo() != null) {
            object = pSCodeListBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getMinorSortDir() != null) {
            object = pSCodeListBase.getMinorSortDir();
            xmlNode.setAttribute(FIELD_MINORSORTDIR, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getMinorSortPSDEFId() != null) {
            object = pSCodeListBase.getMinorSortPSDEFId();
            xmlNode.setAttribute(FIELD_MINORSORTPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getMinorSortPSDEFName() != null) {
            object = pSCodeListBase.getMinorSortPSDEFName();
            xmlNode.setAttribute(FIELD_MINORSORTPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getModColor() != null) {
            object = pSCodeListBase.getModColor();
            xmlNode.setAttribute(FIELD_MODCOLOR, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getNoValueEmpty() != null) {
            object = pSCodeListBase.getNoValueEmpty();
            xmlNode.setAttribute(FIELD_NOVALUEEMPTY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSCodeListBase.getNumberItem() != null) {
            object = pSCodeListBase.getNumberItem();
            xmlNode.setAttribute(FIELD_NUMBERITEM, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSCodeListBase.getOrderValue() != null) {
            object = pSCodeListBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSCodeListBase.getOrMode() != null) {
            object = pSCodeListBase.getOrMode();
            xmlNode.setAttribute(FIELD_ORMODE, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getPredefinedType() != null) {
            object = pSCodeListBase.getPredefinedType();
            xmlNode.setAttribute(FIELD_PREDEFINEDTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getPSCodeListId() != null) {
            object = pSCodeListBase.getPSCodeListId();
            xmlNode.setAttribute(FIELD_PSCODELISTID, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getPSCodeListName() != null) {
            object = pSCodeListBase.getPSCodeListName();
            xmlNode.setAttribute(FIELD_PSCODELISTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getPSCodeListTemplId() != null) {
            object = pSCodeListBase.getPSCodeListTemplId();
            xmlNode.setAttribute(FIELD_PSCODELISTTEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getPSCodeListTemplName() != null) {
            object = pSCodeListBase.getPSCodeListTemplName();
            xmlNode.setAttribute(FIELD_PSCODELISTTEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getPSDEDSId() != null) {
            object = pSCodeListBase.getPSDEDSId();
            xmlNode.setAttribute(FIELD_PSDEDSID, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getPSDEDSName() != null) {
            object = pSCodeListBase.getPSDEDSName();
            xmlNode.setAttribute(FIELD_PSDEDSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getPSDEId() != null) {
            object = pSCodeListBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getPSDEMSLogicId() != null) {
            object = pSCodeListBase.getPSDEMSLogicId();
            xmlNode.setAttribute(FIELD_PSDEMSLOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getPSDEMSLogicName() != null) {
            object = pSCodeListBase.getPSDEMSLogicName();
            xmlNode.setAttribute(FIELD_PSDEMSLOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getPSDEName() != null) {
            object = pSCodeListBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getPSDynaCodeListId() != null) {
            object = pSCodeListBase.getPSDynaCodeListId();
            xmlNode.setAttribute(FIELD_PSDYNACODELISTID, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getPSDynaCodeListName() != null) {
            object = pSCodeListBase.getPSDynaCodeListName();
            xmlNode.setAttribute(FIELD_PSDYNACODELISTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getPSDynaInstId() != null) {
            object = pSCodeListBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getPSDynaInstName() != null) {
            object = pSCodeListBase.getPSDynaInstName();
            xmlNode.setAttribute(FIELD_PSDYNAINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getPSModuleId() != null) {
            object = pSCodeListBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getPSModuleName() != null) {
            object = pSCodeListBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getPSSysDynaModelId() != null) {
            object = pSCodeListBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getPSSysDynaModelName() != null) {
            object = pSCodeListBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getPSSysPFPluginId() != null) {
            object = pSCodeListBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getPSSysPFPluginName() != null) {
            object = pSCodeListBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getPSSysReqItemId() != null) {
            object = pSCodeListBase.getPSSysReqItemId();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getPSSysReqItemName() != null) {
            object = pSCodeListBase.getPSSysReqItemName();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getPSSysSFPluginId() != null) {
            object = pSCodeListBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getPSSysSFPluginName() != null) {
            object = pSCodeListBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getPSSystemId() != null) {
            object = pSCodeListBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getPSSystemName() != null) {
            object = pSCodeListBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getPValuePSDEFId() != null) {
            object = pSCodeListBase.getPValuePSDEFId();
            xmlNode.setAttribute(FIELD_PVALUEPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getPValuePSDEFName() != null) {
            object = pSCodeListBase.getPValuePSDEFName();
            xmlNode.setAttribute(FIELD_PVALUEPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getSeperator() != null) {
            object = pSCodeListBase.getSeperator();
            xmlNode.setAttribute(FIELD_SEPERATOR, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getSRFSysPub() != null) {
            object = pSCodeListBase.getSRFSysPub();
            xmlNode.setAttribute(FIELD_SRFSYSPUB, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSCodeListBase.getSysRefFlag() != null) {
            object = pSCodeListBase.getSysRefFlag();
            xmlNode.setAttribute(FIELD_SYSREFFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSCodeListBase.getTextPSDEFId() != null) {
            object = pSCodeListBase.getTextPSDEFId();
            xmlNode.setAttribute(FIELD_TEXTPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getTextPSDEFName() != null) {
            object = pSCodeListBase.getTextPSDEFName();
            xmlNode.setAttribute(FIELD_TEXTPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getThresholdGroupFlag() != null) {
            object = pSCodeListBase.getThresholdGroupFlag();
            xmlNode.setAttribute(FIELD_THRESHOLDGROUPFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSCodeListBase.getUpdateDate() != null) {
            object = pSCodeListBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCodeListBase.getUpdateMan() != null) {
            object = pSCodeListBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getUserCat() != null) {
            object = pSCodeListBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getUserData() != null) {
            object = pSCodeListBase.getUserData();
            xmlNode.setAttribute(FIELD_USERDATA, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getUserData2() != null) {
            object = pSCodeListBase.getUserData2();
            xmlNode.setAttribute(FIELD_USERDATA2, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getUserParams() != null) {
            object = pSCodeListBase.getUserParams();
            xmlNode.setAttribute(FIELD_USERPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getUserRefFlag() != null) {
            object = pSCodeListBase.getUserRefFlag();
            xmlNode.setAttribute(FIELD_USERREFFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSCodeListBase.getUserScope() != null) {
            object = pSCodeListBase.getUserScope();
            xmlNode.setAttribute(FIELD_USERSCOPE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSCodeListBase.getUserTag() != null) {
            object = pSCodeListBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getUserTag2() != null) {
            object = pSCodeListBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getUserTag3() != null) {
            object = pSCodeListBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getUserTag4() != null) {
            object = pSCodeListBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getValidFlag() != null) {
            object = pSCodeListBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSCodeListBase.getValuePSDEFId() != null) {
            object = pSCodeListBase.getValuePSDEFId();
            xmlNode.setAttribute(FIELD_VALUEPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getValuePSDEFName() != null) {
            object = pSCodeListBase.getValuePSDEFName();
            xmlNode.setAttribute(FIELD_VALUEPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListBase.getValueSeperator() != null) {
            object = pSCodeListBase.getValueSeperator();
            xmlNode.setAttribute(FIELD_VALUESEPERATOR, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSCodeListBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSCodeListBase pSCodeListBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSCodeListBase.isAllTextDirty() && (bl || pSCodeListBase.getAllText() != null)) {
            iDataObject.set(FIELD_ALLTEXT, (Object)pSCodeListBase.getAllText());
        }
        if (pSCodeListBase.isAllTextPSLanResIdDirty() && (bl || pSCodeListBase.getAllTextPSLanResId() != null)) {
            iDataObject.set(FIELD_ALLTEXTPSLANRESID, (Object)pSCodeListBase.getAllTextPSLanResId());
        }
        if (pSCodeListBase.isAllTextPSLanResNameDirty() && (bl || pSCodeListBase.getAllTextPSLanResName() != null)) {
            iDataObject.set(FIELD_ALLTEXTPSLANRESNAME, (Object)pSCodeListBase.getAllTextPSLanResName());
        }
        if (pSCodeListBase.isBeginValuePSDEFIdDirty() && (bl || pSCodeListBase.getBeginValuePSDEFId() != null)) {
            iDataObject.set(FIELD_BEGINVALUEPSDEFID, (Object)pSCodeListBase.getBeginValuePSDEFId());
        }
        if (pSCodeListBase.isBeginValuePSDEFNameDirty() && (bl || pSCodeListBase.getBeginValuePSDEFName() != null)) {
            iDataObject.set(FIELD_BEGINVALUEPSDEFNAME, (Object)pSCodeListBase.getBeginValuePSDEFName());
        }
        if (pSCodeListBase.isBKColorPSDEFIdDirty() && (bl || pSCodeListBase.getBKColorPSDEFId() != null)) {
            iDataObject.set(FIELD_BKCOLORPSDEFID, (Object)pSCodeListBase.getBKColorPSDEFId());
        }
        if (pSCodeListBase.isBKColorPSDEFNameDirty() && (bl || pSCodeListBase.getBKColorPSDEFName() != null)) {
            iDataObject.set(FIELD_BKCOLORPSDEFNAME, (Object)pSCodeListBase.getBKColorPSDEFName());
        }
        if (pSCodeListBase.isCacheCatDirty() && (bl || pSCodeListBase.getCacheCat() != null)) {
            iDataObject.set(FIELD_CACHECAT, (Object)pSCodeListBase.getCacheCat());
        }
        if (pSCodeListBase.isCacheTagDirty() && (bl || pSCodeListBase.getCacheTag() != null)) {
            iDataObject.set(FIELD_CACHETAG, (Object)pSCodeListBase.getCacheTag());
        }
        if (pSCodeListBase.isCacheTimeoutDirty() && (bl || pSCodeListBase.getCacheTimeout() != null)) {
            iDataObject.set(FIELD_CACHETIMEOUT, (Object)pSCodeListBase.getCacheTimeout());
        }
        if (pSCodeListBase.isCLModelDirty() && (bl || pSCodeListBase.getCLModel() != null)) {
            iDataObject.set(FIELD_CLMODEL, (Object)pSCodeListBase.getCLModel());
        }
        if (pSCodeListBase.isClsPSDEFIdDirty() && (bl || pSCodeListBase.getClsPSDEFId() != null)) {
            iDataObject.set(FIELD_CLSPSDEFID, (Object)pSCodeListBase.getClsPSDEFId());
        }
        if (pSCodeListBase.isClsPSDEFNameDirty() && (bl || pSCodeListBase.getClsPSDEFName() != null)) {
            iDataObject.set(FIELD_CLSPSDEFNAME, (Object)pSCodeListBase.getClsPSDEFName());
        }
        if (pSCodeListBase.isCLTypeDirty() && (bl || pSCodeListBase.getCLType() != null)) {
            iDataObject.set(FIELD_CLTYPE, (Object)pSCodeListBase.getCLType());
        }
        if (pSCodeListBase.isCodeItemTagDirty() && (bl || pSCodeListBase.getCodeItemTag() != null)) {
            iDataObject.set(FIELD_CODEITEMTAG, (Object)pSCodeListBase.getCodeItemTag());
        }
        if (pSCodeListBase.isCodeListSNDirty() && (bl || pSCodeListBase.getCodeListSN() != null)) {
            iDataObject.set(FIELD_CODELISTSN, (Object)pSCodeListBase.getCodeListSN());
        }
        if (pSCodeListBase.isCodeNameDirty() && (bl || pSCodeListBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSCodeListBase.getCodeName());
        }
        if (pSCodeListBase.isColorPSDEFIdDirty() && (bl || pSCodeListBase.getColorPSDEFId() != null)) {
            iDataObject.set(FIELD_COLORPSDEFID, (Object)pSCodeListBase.getColorPSDEFId());
        }
        if (pSCodeListBase.isColorPSDEFNameDirty() && (bl || pSCodeListBase.getColorPSDEFName() != null)) {
            iDataObject.set(FIELD_COLORPSDEFNAME, (Object)pSCodeListBase.getColorPSDEFName());
        }
        if (pSCodeListBase.isCreateDateDirty() && (bl || pSCodeListBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSCodeListBase.getCreateDate());
        }
        if (pSCodeListBase.isCreateManDirty() && (bl || pSCodeListBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSCodeListBase.getCreateMan());
        }
        if (pSCodeListBase.isCustomCondDirty() && (bl || pSCodeListBase.getCustomCond() != null)) {
            iDataObject.set(FIELD_CUSTOMCOND, (Object)pSCodeListBase.getCustomCond());
        }
        if (pSCodeListBase.isCustomTypeDirty() && (bl || pSCodeListBase.getCustomType() != null)) {
            iDataObject.set(FIELD_CUSTOMTYPE, (Object)pSCodeListBase.getCustomType());
        }
        if (pSCodeListBase.isDataPSDEFIdDirty() && (bl || pSCodeListBase.getDataPSDEFId() != null)) {
            iDataObject.set(FIELD_DATAPSDEFID, (Object)pSCodeListBase.getDataPSDEFId());
        }
        if (pSCodeListBase.isDataPSDEFNameDirty() && (bl || pSCodeListBase.getDataPSDEFName() != null)) {
            iDataObject.set(FIELD_DATAPSDEFNAME, (Object)pSCodeListBase.getDataPSDEFName());
        }
        if (pSCodeListBase.isDisablePSDEFIdDirty() && (bl || pSCodeListBase.getDisablePSDEFId() != null)) {
            iDataObject.set(FIELD_DISABLEPSDEFID, (Object)pSCodeListBase.getDisablePSDEFId());
        }
        if (pSCodeListBase.isDisablePSDEFNameDirty() && (bl || pSCodeListBase.getDisablePSDEFName() != null)) {
            iDataObject.set(FIELD_DISABLEPSDEFNAME, (Object)pSCodeListBase.getDisablePSDEFName());
        }
        if (pSCodeListBase.isDSConditionsDirty() && (bl || pSCodeListBase.getDSConditions() != null)) {
            iDataObject.set(FIELD_DSCONDITIONS, (Object)pSCodeListBase.getDSConditions());
        }
        if (pSCodeListBase.isDynaModelFlagDirty() && (bl || pSCodeListBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSCodeListBase.getDynaModelFlag());
        }
        if (pSCodeListBase.isDynaSysRefModeDirty() && (bl || pSCodeListBase.getDynaSysRefMode() != null)) {
            iDataObject.set(FIELD_DYNASYSREFMODE, (Object)pSCodeListBase.getDynaSysRefMode());
        }
        if (pSCodeListBase.isEmptyTextDirty() && (bl || pSCodeListBase.getEmptyText() != null)) {
            iDataObject.set(FIELD_EMPTYTEXT, (Object)pSCodeListBase.getEmptyText());
        }
        if (pSCodeListBase.isEmptyTextPSLanResIdDirty() && (bl || pSCodeListBase.getEmptyTextPSLanResId() != null)) {
            iDataObject.set(FIELD_EMPTYTEXTPSLANRESID, (Object)pSCodeListBase.getEmptyTextPSLanResId());
        }
        if (pSCodeListBase.isEmptyTextPSLanResNameDirty() && (bl || pSCodeListBase.getEmptyTextPSLanResName() != null)) {
            iDataObject.set(FIELD_EMPTYTEXTPSLANRESNAME, (Object)pSCodeListBase.getEmptyTextPSLanResName());
        }
        if (pSCodeListBase.isEnableCacheDirty() && (bl || pSCodeListBase.getEnableCache() != null)) {
            iDataObject.set(FIELD_ENABLECACHE, (Object)pSCodeListBase.getEnableCache());
        }
        if (pSCodeListBase.isEnableDynaSysDirty() && (bl || pSCodeListBase.getEnableDynaSys() != null)) {
            iDataObject.set(FIELD_ENABLEDYNASYS, (Object)pSCodeListBase.getEnableDynaSys());
        }
        if (pSCodeListBase.isEndValuePSDEFIdDirty() && (bl || pSCodeListBase.getEndValuePSDEFId() != null)) {
            iDataObject.set(FIELD_ENDVALUEPSDEFID, (Object)pSCodeListBase.getEndValuePSDEFId());
        }
        if (pSCodeListBase.isEndValuePSDEFNameDirty() && (bl || pSCodeListBase.getEndValuePSDEFName() != null)) {
            iDataObject.set(FIELD_ENDVALUEPSDEFNAME, (Object)pSCodeListBase.getEndValuePSDEFName());
        }
        if (pSCodeListBase.isExtendModeDirty() && (bl || pSCodeListBase.getExtendMode() != null)) {
            iDataObject.set(FIELD_EXTENDMODE, (Object)pSCodeListBase.getExtendMode());
        }
        if (pSCodeListBase.isIconClsPSDEFIdDirty() && (bl || pSCodeListBase.getIconClsPSDEFId() != null)) {
            iDataObject.set(FIELD_ICONCLSPSDEFID, (Object)pSCodeListBase.getIconClsPSDEFId());
        }
        if (pSCodeListBase.isIconClsPSDEFNameDirty() && (bl || pSCodeListBase.getIconClsPSDEFName() != null)) {
            iDataObject.set(FIELD_ICONCLSPSDEFNAME, (Object)pSCodeListBase.getIconClsPSDEFName());
        }
        if (pSCodeListBase.isIconClsXPSDEFIdDirty() && (bl || pSCodeListBase.getIconClsXPSDEFId() != null)) {
            iDataObject.set(FIELD_ICONCLSXPSDEFID, (Object)pSCodeListBase.getIconClsXPSDEFId());
        }
        if (pSCodeListBase.isIconClsXPSDEFNameDirty() && (bl || pSCodeListBase.getIconClsXPSDEFName() != null)) {
            iDataObject.set(FIELD_ICONCLSXPSDEFNAME, (Object)pSCodeListBase.getIconClsXPSDEFName());
        }
        if (pSCodeListBase.isIconPathPSDEFIdDirty() && (bl || pSCodeListBase.getIconPathPSDEFId() != null)) {
            iDataObject.set(FIELD_ICONPATHPSDEFID, (Object)pSCodeListBase.getIconPathPSDEFId());
        }
        if (pSCodeListBase.isIconPathPSDEFNameDirty() && (bl || pSCodeListBase.getIconPathPSDEFName() != null)) {
            iDataObject.set(FIELD_ICONPATHPSDEFNAME, (Object)pSCodeListBase.getIconPathPSDEFName());
        }
        if (pSCodeListBase.isIconPathXPSDEFIdDirty() && (bl || pSCodeListBase.getIconPathXPSDEFId() != null)) {
            iDataObject.set(FIELD_ICONPATHXPSDEFID, (Object)pSCodeListBase.getIconPathXPSDEFId());
        }
        if (pSCodeListBase.isIconPathXPSDEFNameDirty() && (bl || pSCodeListBase.getIconPathXPSDEFName() != null)) {
            iDataObject.set(FIELD_ICONPATHXPSDEFNAME, (Object)pSCodeListBase.getIconPathXPSDEFName());
        }
        if (pSCodeListBase.isIncBeginValueDirty() && (bl || pSCodeListBase.getIncBeginValue() != null)) {
            iDataObject.set(FIELD_INCBEGINVALUE, (Object)pSCodeListBase.getIncBeginValue());
        }
        if (pSCodeListBase.isIncEndValueDirty() && (bl || pSCodeListBase.getIncEndValue() != null)) {
            iDataObject.set(FIELD_INCENDVALUE, (Object)pSCodeListBase.getIncEndValue());
        }
        if (pSCodeListBase.isLinkPSDEViewIdDirty() && (bl || pSCodeListBase.getLinkPSDEViewId() != null)) {
            iDataObject.set(FIELD_LINKPSDEVIEWID, (Object)pSCodeListBase.getLinkPSDEViewId());
        }
        if (pSCodeListBase.isLinkPSDEViewNameDirty() && (bl || pSCodeListBase.getLinkPSDEViewName() != null)) {
            iDataObject.set(FIELD_LINKPSDEVIEWNAME, (Object)pSCodeListBase.getLinkPSDEViewName());
        }
        if (pSCodeListBase.isLockFlagDirty() && (bl || pSCodeListBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSCodeListBase.getLockFlag());
        }
        if (pSCodeListBase.isMemoDirty() && (bl || pSCodeListBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSCodeListBase.getMemo());
        }
        if (pSCodeListBase.isMinorSortDirDirty() && (bl || pSCodeListBase.getMinorSortDir() != null)) {
            iDataObject.set(FIELD_MINORSORTDIR, (Object)pSCodeListBase.getMinorSortDir());
        }
        if (pSCodeListBase.isMinorSortPSDEFIdDirty() && (bl || pSCodeListBase.getMinorSortPSDEFId() != null)) {
            iDataObject.set(FIELD_MINORSORTPSDEFID, (Object)pSCodeListBase.getMinorSortPSDEFId());
        }
        if (pSCodeListBase.isMinorSortPSDEFNameDirty() && (bl || pSCodeListBase.getMinorSortPSDEFName() != null)) {
            iDataObject.set(FIELD_MINORSORTPSDEFNAME, (Object)pSCodeListBase.getMinorSortPSDEFName());
        }
        if (pSCodeListBase.isModColorDirty() && (bl || pSCodeListBase.getModColor() != null)) {
            iDataObject.set(FIELD_MODCOLOR, (Object)pSCodeListBase.getModColor());
        }
        if (pSCodeListBase.isNoValueEmptyDirty() && (bl || pSCodeListBase.getNoValueEmpty() != null)) {
            iDataObject.set(FIELD_NOVALUEEMPTY, (Object)pSCodeListBase.getNoValueEmpty());
        }
        if (pSCodeListBase.isNumberItemDirty() && (bl || pSCodeListBase.getNumberItem() != null)) {
            iDataObject.set(FIELD_NUMBERITEM, (Object)pSCodeListBase.getNumberItem());
        }
        if (pSCodeListBase.isOrderValueDirty() && (bl || pSCodeListBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSCodeListBase.getOrderValue());
        }
        if (pSCodeListBase.isOrModeDirty() && (bl || pSCodeListBase.getOrMode() != null)) {
            iDataObject.set(FIELD_ORMODE, (Object)pSCodeListBase.getOrMode());
        }
        if (pSCodeListBase.isPredefinedTypeDirty() && (bl || pSCodeListBase.getPredefinedType() != null)) {
            iDataObject.set(FIELD_PREDEFINEDTYPE, (Object)pSCodeListBase.getPredefinedType());
        }
        if (pSCodeListBase.isPSCodeListIdDirty() && (bl || pSCodeListBase.getPSCodeListId() != null)) {
            iDataObject.set(FIELD_PSCODELISTID, (Object)pSCodeListBase.getPSCodeListId());
        }
        if (pSCodeListBase.isPSCodeListNameDirty() && (bl || pSCodeListBase.getPSCodeListName() != null)) {
            iDataObject.set(FIELD_PSCODELISTNAME, (Object)pSCodeListBase.getPSCodeListName());
        }
        if (pSCodeListBase.isPSCodeListTemplIdDirty() && (bl || pSCodeListBase.getPSCodeListTemplId() != null)) {
            iDataObject.set(FIELD_PSCODELISTTEMPLID, (Object)pSCodeListBase.getPSCodeListTemplId());
        }
        if (pSCodeListBase.isPSCodeListTemplNameDirty() && (bl || pSCodeListBase.getPSCodeListTemplName() != null)) {
            iDataObject.set(FIELD_PSCODELISTTEMPLNAME, (Object)pSCodeListBase.getPSCodeListTemplName());
        }
        if (pSCodeListBase.isPSDEDSIdDirty() && (bl || pSCodeListBase.getPSDEDSId() != null)) {
            iDataObject.set(FIELD_PSDEDSID, (Object)pSCodeListBase.getPSDEDSId());
        }
        if (pSCodeListBase.isPSDEDSNameDirty() && (bl || pSCodeListBase.getPSDEDSName() != null)) {
            iDataObject.set(FIELD_PSDEDSNAME, (Object)pSCodeListBase.getPSDEDSName());
        }
        if (pSCodeListBase.isPSDEIdDirty() && (bl || pSCodeListBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSCodeListBase.getPSDEId());
        }
        if (pSCodeListBase.isPSDEMSLogicIdDirty() && (bl || pSCodeListBase.getPSDEMSLogicId() != null)) {
            iDataObject.set(FIELD_PSDEMSLOGICID, (Object)pSCodeListBase.getPSDEMSLogicId());
        }
        if (pSCodeListBase.isPSDEMSLogicNameDirty() && (bl || pSCodeListBase.getPSDEMSLogicName() != null)) {
            iDataObject.set(FIELD_PSDEMSLOGICNAME, (Object)pSCodeListBase.getPSDEMSLogicName());
        }
        if (pSCodeListBase.isPSDENameDirty() && (bl || pSCodeListBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSCodeListBase.getPSDEName());
        }
        if (pSCodeListBase.isPSDynaCodeListIdDirty() && (bl || pSCodeListBase.getPSDynaCodeListId() != null)) {
            iDataObject.set(FIELD_PSDYNACODELISTID, (Object)pSCodeListBase.getPSDynaCodeListId());
        }
        if (pSCodeListBase.isPSDynaCodeListNameDirty() && (bl || pSCodeListBase.getPSDynaCodeListName() != null)) {
            iDataObject.set(FIELD_PSDYNACODELISTNAME, (Object)pSCodeListBase.getPSDynaCodeListName());
        }
        if (pSCodeListBase.isPSDynaInstIdDirty() && (bl || pSCodeListBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSCodeListBase.getPSDynaInstId());
        }
        if (pSCodeListBase.isPSDynaInstNameDirty() && (bl || pSCodeListBase.getPSDynaInstName() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTNAME, (Object)pSCodeListBase.getPSDynaInstName());
        }
        if (pSCodeListBase.isPSModuleIdDirty() && (bl || pSCodeListBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSCodeListBase.getPSModuleId());
        }
        if (pSCodeListBase.isPSModuleNameDirty() && (bl || pSCodeListBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSCodeListBase.getPSModuleName());
        }
        if (pSCodeListBase.isPSSysDynaModelIdDirty() && (bl || pSCodeListBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSCodeListBase.getPSSysDynaModelId());
        }
        if (pSCodeListBase.isPSSysDynaModelNameDirty() && (bl || pSCodeListBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSCodeListBase.getPSSysDynaModelName());
        }
        if (pSCodeListBase.isPSSysPFPluginIdDirty() && (bl || pSCodeListBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSCodeListBase.getPSSysPFPluginId());
        }
        if (pSCodeListBase.isPSSysPFPluginNameDirty() && (bl || pSCodeListBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSCodeListBase.getPSSysPFPluginName());
        }
        if (pSCodeListBase.isPSSysReqItemIdDirty() && (bl || pSCodeListBase.getPSSysReqItemId() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMID, (Object)pSCodeListBase.getPSSysReqItemId());
        }
        if (pSCodeListBase.isPSSysReqItemNameDirty() && (bl || pSCodeListBase.getPSSysReqItemName() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMNAME, (Object)pSCodeListBase.getPSSysReqItemName());
        }
        if (pSCodeListBase.isPSSysSFPluginIdDirty() && (bl || pSCodeListBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSCodeListBase.getPSSysSFPluginId());
        }
        if (pSCodeListBase.isPSSysSFPluginNameDirty() && (bl || pSCodeListBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSCodeListBase.getPSSysSFPluginName());
        }
        if (pSCodeListBase.isPSSystemIdDirty() && (bl || pSCodeListBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSCodeListBase.getPSSystemId());
        }
        if (pSCodeListBase.isPSSystemNameDirty() && (bl || pSCodeListBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSCodeListBase.getPSSystemName());
        }
        if (pSCodeListBase.isPValuePSDEFIdDirty() && (bl || pSCodeListBase.getPValuePSDEFId() != null)) {
            iDataObject.set(FIELD_PVALUEPSDEFID, (Object)pSCodeListBase.getPValuePSDEFId());
        }
        if (pSCodeListBase.isPValuePSDEFNameDirty() && (bl || pSCodeListBase.getPValuePSDEFName() != null)) {
            iDataObject.set(FIELD_PVALUEPSDEFNAME, (Object)pSCodeListBase.getPValuePSDEFName());
        }
        if (pSCodeListBase.isSeperatorDirty() && (bl || pSCodeListBase.getSeperator() != null)) {
            iDataObject.set(FIELD_SEPERATOR, (Object)pSCodeListBase.getSeperator());
        }
        if (pSCodeListBase.isSRFSysPubDirty() && (bl || pSCodeListBase.getSRFSysPub() != null)) {
            iDataObject.set(FIELD_SRFSYSPUB, (Object)pSCodeListBase.getSRFSysPub());
        }
        if (pSCodeListBase.isSysRefFlagDirty() && (bl || pSCodeListBase.getSysRefFlag() != null)) {
            iDataObject.set(FIELD_SYSREFFLAG, (Object)pSCodeListBase.getSysRefFlag());
        }
        if (pSCodeListBase.isTextPSDEFIdDirty() && (bl || pSCodeListBase.getTextPSDEFId() != null)) {
            iDataObject.set(FIELD_TEXTPSDEFID, (Object)pSCodeListBase.getTextPSDEFId());
        }
        if (pSCodeListBase.isTextPSDEFNameDirty() && (bl || pSCodeListBase.getTextPSDEFName() != null)) {
            iDataObject.set(FIELD_TEXTPSDEFNAME, (Object)pSCodeListBase.getTextPSDEFName());
        }
        if (pSCodeListBase.isThresholdGroupFlagDirty() && (bl || pSCodeListBase.getThresholdGroupFlag() != null)) {
            iDataObject.set(FIELD_THRESHOLDGROUPFLAG, (Object)pSCodeListBase.getThresholdGroupFlag());
        }
        if (pSCodeListBase.isUpdateDateDirty() && (bl || pSCodeListBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSCodeListBase.getUpdateDate());
        }
        if (pSCodeListBase.isUpdateManDirty() && (bl || pSCodeListBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSCodeListBase.getUpdateMan());
        }
        if (pSCodeListBase.isUserCatDirty() && (bl || pSCodeListBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSCodeListBase.getUserCat());
        }
        if (pSCodeListBase.isUserDataDirty() && (bl || pSCodeListBase.getUserData() != null)) {
            iDataObject.set(FIELD_USERDATA, (Object)pSCodeListBase.getUserData());
        }
        if (pSCodeListBase.isUserData2Dirty() && (bl || pSCodeListBase.getUserData2() != null)) {
            iDataObject.set(FIELD_USERDATA2, (Object)pSCodeListBase.getUserData2());
        }
        if (pSCodeListBase.isUserParamsDirty() && (bl || pSCodeListBase.getUserParams() != null)) {
            iDataObject.set(FIELD_USERPARAMS, (Object)pSCodeListBase.getUserParams());
        }
        if (pSCodeListBase.isUserRefFlagDirty() && (bl || pSCodeListBase.getUserRefFlag() != null)) {
            iDataObject.set(FIELD_USERREFFLAG, (Object)pSCodeListBase.getUserRefFlag());
        }
        if (pSCodeListBase.isUserScopeDirty() && (bl || pSCodeListBase.getUserScope() != null)) {
            iDataObject.set(FIELD_USERSCOPE, (Object)pSCodeListBase.getUserScope());
        }
        if (pSCodeListBase.isUserTagDirty() && (bl || pSCodeListBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSCodeListBase.getUserTag());
        }
        if (pSCodeListBase.isUserTag2Dirty() && (bl || pSCodeListBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSCodeListBase.getUserTag2());
        }
        if (pSCodeListBase.isUserTag3Dirty() && (bl || pSCodeListBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSCodeListBase.getUserTag3());
        }
        if (pSCodeListBase.isUserTag4Dirty() && (bl || pSCodeListBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSCodeListBase.getUserTag4());
        }
        if (pSCodeListBase.isValidFlagDirty() && (bl || pSCodeListBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSCodeListBase.getValidFlag());
        }
        if (pSCodeListBase.isValuePSDEFIdDirty() && (bl || pSCodeListBase.getValuePSDEFId() != null)) {
            iDataObject.set(FIELD_VALUEPSDEFID, (Object)pSCodeListBase.getValuePSDEFId());
        }
        if (pSCodeListBase.isValuePSDEFNameDirty() && (bl || pSCodeListBase.getValuePSDEFName() != null)) {
            iDataObject.set(FIELD_VALUEPSDEFNAME, (Object)pSCodeListBase.getValuePSDEFName());
        }
        if (pSCodeListBase.isValueSeperatorDirty() && (bl || pSCodeListBase.getValueSeperator() != null)) {
            iDataObject.set(FIELD_VALUESEPERATOR, (Object)pSCodeListBase.getValueSeperator());
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
        return PSCodeListBase.remove(this, n);
    }

    private static boolean remove(PSCodeListBase pSCodeListBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSCodeListBase.resetAllText();
                return true;
            }
            case 1: {
                pSCodeListBase.resetAllTextPSLanResId();
                return true;
            }
            case 2: {
                pSCodeListBase.resetAllTextPSLanResName();
                return true;
            }
            case 3: {
                pSCodeListBase.resetBeginValuePSDEFId();
                return true;
            }
            case 4: {
                pSCodeListBase.resetBeginValuePSDEFName();
                return true;
            }
            case 5: {
                pSCodeListBase.resetBKColorPSDEFId();
                return true;
            }
            case 6: {
                pSCodeListBase.resetBKColorPSDEFName();
                return true;
            }
            case 7: {
                pSCodeListBase.resetCacheCat();
                return true;
            }
            case 8: {
                pSCodeListBase.resetCacheTag();
                return true;
            }
            case 9: {
                pSCodeListBase.resetCacheTimeout();
                return true;
            }
            case 10: {
                pSCodeListBase.resetCLModel();
                return true;
            }
            case 11: {
                pSCodeListBase.resetClsPSDEFId();
                return true;
            }
            case 12: {
                pSCodeListBase.resetClsPSDEFName();
                return true;
            }
            case 13: {
                pSCodeListBase.resetCLType();
                return true;
            }
            case 14: {
                pSCodeListBase.resetCodeItemTag();
                return true;
            }
            case 15: {
                pSCodeListBase.resetCodeListSN();
                return true;
            }
            case 16: {
                pSCodeListBase.resetCodeName();
                return true;
            }
            case 17: {
                pSCodeListBase.resetColorPSDEFId();
                return true;
            }
            case 18: {
                pSCodeListBase.resetColorPSDEFName();
                return true;
            }
            case 19: {
                pSCodeListBase.resetCreateDate();
                return true;
            }
            case 20: {
                pSCodeListBase.resetCreateMan();
                return true;
            }
            case 21: {
                pSCodeListBase.resetCustomCond();
                return true;
            }
            case 22: {
                pSCodeListBase.resetCustomType();
                return true;
            }
            case 23: {
                pSCodeListBase.resetDataPSDEFId();
                return true;
            }
            case 24: {
                pSCodeListBase.resetDataPSDEFName();
                return true;
            }
            case 25: {
                pSCodeListBase.resetDisablePSDEFId();
                return true;
            }
            case 26: {
                pSCodeListBase.resetDisablePSDEFName();
                return true;
            }
            case 27: {
                pSCodeListBase.resetDSConditions();
                return true;
            }
            case 28: {
                pSCodeListBase.resetDynaModelFlag();
                return true;
            }
            case 29: {
                pSCodeListBase.resetDynaSysRefMode();
                return true;
            }
            case 30: {
                pSCodeListBase.resetEmptyText();
                return true;
            }
            case 31: {
                pSCodeListBase.resetEmptyTextPSLanResId();
                return true;
            }
            case 32: {
                pSCodeListBase.resetEmptyTextPSLanResName();
                return true;
            }
            case 33: {
                pSCodeListBase.resetEnableCache();
                return true;
            }
            case 34: {
                pSCodeListBase.resetEnableDynaSys();
                return true;
            }
            case 35: {
                pSCodeListBase.resetEndValuePSDEFId();
                return true;
            }
            case 36: {
                pSCodeListBase.resetEndValuePSDEFName();
                return true;
            }
            case 37: {
                pSCodeListBase.resetExtendMode();
                return true;
            }
            case 38: {
                pSCodeListBase.resetIconClsPSDEFId();
                return true;
            }
            case 39: {
                pSCodeListBase.resetIconClsPSDEFName();
                return true;
            }
            case 40: {
                pSCodeListBase.resetIconClsXPSDEFId();
                return true;
            }
            case 41: {
                pSCodeListBase.resetIconClsXPSDEFName();
                return true;
            }
            case 42: {
                pSCodeListBase.resetIconPathPSDEFId();
                return true;
            }
            case 43: {
                pSCodeListBase.resetIconPathPSDEFName();
                return true;
            }
            case 44: {
                pSCodeListBase.resetIconPathXPSDEFId();
                return true;
            }
            case 45: {
                pSCodeListBase.resetIconPathXPSDEFName();
                return true;
            }
            case 46: {
                pSCodeListBase.resetIncBeginValue();
                return true;
            }
            case 47: {
                pSCodeListBase.resetIncEndValue();
                return true;
            }
            case 48: {
                pSCodeListBase.resetLinkPSDEViewId();
                return true;
            }
            case 49: {
                pSCodeListBase.resetLinkPSDEViewName();
                return true;
            }
            case 50: {
                pSCodeListBase.resetLockFlag();
                return true;
            }
            case 51: {
                pSCodeListBase.resetMemo();
                return true;
            }
            case 52: {
                pSCodeListBase.resetMinorSortDir();
                return true;
            }
            case 53: {
                pSCodeListBase.resetMinorSortPSDEFId();
                return true;
            }
            case 54: {
                pSCodeListBase.resetMinorSortPSDEFName();
                return true;
            }
            case 55: {
                pSCodeListBase.resetModColor();
                return true;
            }
            case 56: {
                pSCodeListBase.resetNoValueEmpty();
                return true;
            }
            case 57: {
                pSCodeListBase.resetNumberItem();
                return true;
            }
            case 58: {
                pSCodeListBase.resetOrderValue();
                return true;
            }
            case 59: {
                pSCodeListBase.resetOrMode();
                return true;
            }
            case 60: {
                pSCodeListBase.resetPredefinedType();
                return true;
            }
            case 61: {
                pSCodeListBase.resetPSCodeListId();
                return true;
            }
            case 62: {
                pSCodeListBase.resetPSCodeListName();
                return true;
            }
            case 63: {
                pSCodeListBase.resetPSCodeListTemplId();
                return true;
            }
            case 64: {
                pSCodeListBase.resetPSCodeListTemplName();
                return true;
            }
            case 65: {
                pSCodeListBase.resetPSDEDSId();
                return true;
            }
            case 66: {
                pSCodeListBase.resetPSDEDSName();
                return true;
            }
            case 67: {
                pSCodeListBase.resetPSDEId();
                return true;
            }
            case 68: {
                pSCodeListBase.resetPSDEMSLogicId();
                return true;
            }
            case 69: {
                pSCodeListBase.resetPSDEMSLogicName();
                return true;
            }
            case 70: {
                pSCodeListBase.resetPSDEName();
                return true;
            }
            case 71: {
                pSCodeListBase.resetPSDynaCodeListId();
                return true;
            }
            case 72: {
                pSCodeListBase.resetPSDynaCodeListName();
                return true;
            }
            case 73: {
                pSCodeListBase.resetPSDynaInstId();
                return true;
            }
            case 74: {
                pSCodeListBase.resetPSDynaInstName();
                return true;
            }
            case 75: {
                pSCodeListBase.resetPSModuleId();
                return true;
            }
            case 76: {
                pSCodeListBase.resetPSModuleName();
                return true;
            }
            case 77: {
                pSCodeListBase.resetPSSysDynaModelId();
                return true;
            }
            case 78: {
                pSCodeListBase.resetPSSysDynaModelName();
                return true;
            }
            case 79: {
                pSCodeListBase.resetPSSysPFPluginId();
                return true;
            }
            case 80: {
                pSCodeListBase.resetPSSysPFPluginName();
                return true;
            }
            case 81: {
                pSCodeListBase.resetPSSysReqItemId();
                return true;
            }
            case 82: {
                pSCodeListBase.resetPSSysReqItemName();
                return true;
            }
            case 83: {
                pSCodeListBase.resetPSSysSFPluginId();
                return true;
            }
            case 84: {
                pSCodeListBase.resetPSSysSFPluginName();
                return true;
            }
            case 85: {
                pSCodeListBase.resetPSSystemId();
                return true;
            }
            case 86: {
                pSCodeListBase.resetPSSystemName();
                return true;
            }
            case 87: {
                pSCodeListBase.resetPValuePSDEFId();
                return true;
            }
            case 88: {
                pSCodeListBase.resetPValuePSDEFName();
                return true;
            }
            case 89: {
                pSCodeListBase.resetSeperator();
                return true;
            }
            case 90: {
                pSCodeListBase.resetSRFSysPub();
                return true;
            }
            case 91: {
                pSCodeListBase.resetSysRefFlag();
                return true;
            }
            case 92: {
                pSCodeListBase.resetTextPSDEFId();
                return true;
            }
            case 93: {
                pSCodeListBase.resetTextPSDEFName();
                return true;
            }
            case 94: {
                pSCodeListBase.resetThresholdGroupFlag();
                return true;
            }
            case 95: {
                pSCodeListBase.resetUpdateDate();
                return true;
            }
            case 96: {
                pSCodeListBase.resetUpdateMan();
                return true;
            }
            case 97: {
                pSCodeListBase.resetUserCat();
                return true;
            }
            case 98: {
                pSCodeListBase.resetUserData();
                return true;
            }
            case 99: {
                pSCodeListBase.resetUserData2();
                return true;
            }
            case 100: {
                pSCodeListBase.resetUserParams();
                return true;
            }
            case 101: {
                pSCodeListBase.resetUserRefFlag();
                return true;
            }
            case 102: {
                pSCodeListBase.resetUserScope();
                return true;
            }
            case 103: {
                pSCodeListBase.resetUserTag();
                return true;
            }
            case 104: {
                pSCodeListBase.resetUserTag2();
                return true;
            }
            case 105: {
                pSCodeListBase.resetUserTag3();
                return true;
            }
            case 106: {
                pSCodeListBase.resetUserTag4();
                return true;
            }
            case 107: {
                pSCodeListBase.resetValidFlag();
                return true;
            }
            case 108: {
                pSCodeListBase.resetValuePSDEFId();
                return true;
            }
            case 109: {
                pSCodeListBase.resetValuePSDEFName();
                return true;
            }
            case 110: {
                pSCodeListBase.resetValueSeperator();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCodeListTempl getPSCodeListTempl() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCodeListTempl();
        }
        if (this.getPSCodeListTemplId() == null) {
            return null;
        }
        Integer n = this.objPSCodeListTemplLock;
        synchronized (n) {
            if (this.pscodelisttempl != null && DataTypeHelper.compare((int)25, (Object)this.getPSCodeListTemplId(), (Object)this.pscodelisttempl.getPSCodeListTemplId()) != 0L) {
                this.pscodelisttempl = null;
            }
            if (this.pscodelisttempl == null) {
                PSCodeListTempl pSCodeListTempl = new PSCodeListTempl();
                pSCodeListTempl.setPSCodeListTemplId(this.getPSCodeListTemplId());
                PSCodeListTemplService pSCodeListTemplService = (PSCodeListTemplService)ServiceGlobal.getService(PSCodeListTemplService.class, (SessionFactory)this.getSessionFactory());
                pSCodeListTemplService.autoGet((IEntity)pSCodeListTempl);
                this.pscodelisttempl = pSCodeListTempl;
            }
            return this.pscodelisttempl;
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
    public PSDEDataSet getPSDEDS() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDS();
        }
        if (this.getPSDEDSId() == null) {
            return null;
        }
        Integer n = this.objPSDEDSLock;
        synchronized (n) {
            if (this.psdeds != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEDSId(), (Object)this.psdeds.getPSDEDataSetId()) != 0L) {
                this.psdeds = null;
            }
            if (this.psdeds == null) {
                PSDEDataSet pSDEDataSet = new PSDEDataSet();
                pSDEDataSet.setPSDEDataSetId(this.getPSDEDSId());
                PSDEDataSetService pSDEDataSetService = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataSetService.autoGet((IEntity)pSDEDataSet);
                this.psdeds = pSDEDataSet;
            }
            return this.psdeds;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getBeginValuePSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBeginValuePSDEF();
        }
        if (this.getBeginValuePSDEFId() == null) {
            return null;
        }
        Integer n = this.objBeginValuePSDEFLock;
        synchronized (n) {
            if (this.beginvaluepsdef != null && DataTypeHelper.compare((int)25, (Object)this.getBeginValuePSDEFId(), (Object)this.beginvaluepsdef.getPSDEFieldId()) != 0L) {
                this.beginvaluepsdef = null;
            }
            if (this.beginvaluepsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getBeginValuePSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.beginvaluepsdef = pSDEField;
            }
            return this.beginvaluepsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getBKColorPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBKColorPSDEF();
        }
        if (this.getBKColorPSDEFId() == null) {
            return null;
        }
        Integer n = this.objBKColorPSDEFLock;
        synchronized (n) {
            if (this.bkcolorpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getBKColorPSDEFId(), (Object)this.bkcolorpsdef.getPSDEFieldId()) != 0L) {
                this.bkcolorpsdef = null;
            }
            if (this.bkcolorpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getBKColorPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.bkcolorpsdef = pSDEField;
            }
            return this.bkcolorpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getClsPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getClsPSDEF();
        }
        if (this.getClsPSDEFId() == null) {
            return null;
        }
        Integer n = this.objClsPSDEFLock;
        synchronized (n) {
            if (this.clspsdef != null && DataTypeHelper.compare((int)25, (Object)this.getClsPSDEFId(), (Object)this.clspsdef.getPSDEFieldId()) != 0L) {
                this.clspsdef = null;
            }
            if (this.clspsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getClsPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.clspsdef = pSDEField;
            }
            return this.clspsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getColorPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getColorPSDEF();
        }
        if (this.getColorPSDEFId() == null) {
            return null;
        }
        Integer n = this.objColorPSDEFLock;
        synchronized (n) {
            if (this.colorpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getColorPSDEFId(), (Object)this.colorpsdef.getPSDEFieldId()) != 0L) {
                this.colorpsdef = null;
            }
            if (this.colorpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getColorPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.colorpsdef = pSDEField;
            }
            return this.colorpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getDataPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDataPSDEF();
        }
        if (this.getDataPSDEFId() == null) {
            return null;
        }
        Integer n = this.objDataPSDEFLock;
        synchronized (n) {
            if (this.datapsdef != null && DataTypeHelper.compare((int)25, (Object)this.getDataPSDEFId(), (Object)this.datapsdef.getPSDEFieldId()) != 0L) {
                this.datapsdef = null;
            }
            if (this.datapsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getDataPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.datapsdef = pSDEField;
            }
            return this.datapsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getDisablePSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDisablePSDEF();
        }
        if (this.getDisablePSDEFId() == null) {
            return null;
        }
        Integer n = this.objDisablePSDEFLock;
        synchronized (n) {
            if (this.disablepsdef != null && DataTypeHelper.compare((int)25, (Object)this.getDisablePSDEFId(), (Object)this.disablepsdef.getPSDEFieldId()) != 0L) {
                this.disablepsdef = null;
            }
            if (this.disablepsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getDisablePSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.disablepsdef = pSDEField;
            }
            return this.disablepsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getEndValuePSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEndValuePSDEF();
        }
        if (this.getEndValuePSDEFId() == null) {
            return null;
        }
        Integer n = this.objEndValuePSDEFLock;
        synchronized (n) {
            if (this.endvaluepsdef != null && DataTypeHelper.compare((int)25, (Object)this.getEndValuePSDEFId(), (Object)this.endvaluepsdef.getPSDEFieldId()) != 0L) {
                this.endvaluepsdef = null;
            }
            if (this.endvaluepsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getEndValuePSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.endvaluepsdef = pSDEField;
            }
            return this.endvaluepsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getIconClsPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIconClsPSDEF();
        }
        if (this.getIconClsPSDEFId() == null) {
            return null;
        }
        Integer n = this.objIconClsPSDEFLock;
        synchronized (n) {
            if (this.iconclspsdef != null && DataTypeHelper.compare((int)25, (Object)this.getIconClsPSDEFId(), (Object)this.iconclspsdef.getPSDEFieldId()) != 0L) {
                this.iconclspsdef = null;
            }
            if (this.iconclspsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getIconClsPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.iconclspsdef = pSDEField;
            }
            return this.iconclspsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getIconClsXPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIconClsXPSDEF();
        }
        if (this.getIconClsXPSDEFId() == null) {
            return null;
        }
        Integer n = this.objIconClsXPSDEFLock;
        synchronized (n) {
            if (this.iconclsxpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getIconClsXPSDEFId(), (Object)this.iconclsxpsdef.getPSDEFieldId()) != 0L) {
                this.iconclsxpsdef = null;
            }
            if (this.iconclsxpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getIconClsXPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.iconclsxpsdef = pSDEField;
            }
            return this.iconclsxpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getIconPathPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIconPathPSDEF();
        }
        if (this.getIconPathPSDEFId() == null) {
            return null;
        }
        Integer n = this.objIconPathPSDEFLock;
        synchronized (n) {
            if (this.iconpathpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getIconPathPSDEFId(), (Object)this.iconpathpsdef.getPSDEFieldId()) != 0L) {
                this.iconpathpsdef = null;
            }
            if (this.iconpathpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getIconPathPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.iconpathpsdef = pSDEField;
            }
            return this.iconpathpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getIconPathXPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIconPathXPSDEF();
        }
        if (this.getIconPathXPSDEFId() == null) {
            return null;
        }
        Integer n = this.objIconPathXPSDEFLock;
        synchronized (n) {
            if (this.iconpathxpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getIconPathXPSDEFId(), (Object)this.iconpathxpsdef.getPSDEFieldId()) != 0L) {
                this.iconpathxpsdef = null;
            }
            if (this.iconpathxpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getIconPathXPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.iconpathxpsdef = pSDEField;
            }
            return this.iconpathxpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getMinorSortPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorSortPSDEF();
        }
        if (this.getMinorSortPSDEFId() == null) {
            return null;
        }
        Integer n = this.objMinorSortPSDEFLock;
        synchronized (n) {
            if (this.minorsortpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getMinorSortPSDEFId(), (Object)this.minorsortpsdef.getPSDEFieldId()) != 0L) {
                this.minorsortpsdef = null;
            }
            if (this.minorsortpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getMinorSortPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.minorsortpsdef = pSDEField;
            }
            return this.minorsortpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getPValuePSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPValuePSDEF();
        }
        if (this.getPValuePSDEFId() == null) {
            return null;
        }
        Integer n = this.objPValuePSDEFLock;
        synchronized (n) {
            if (this.pvaluepsdef != null && DataTypeHelper.compare((int)25, (Object)this.getPValuePSDEFId(), (Object)this.pvaluepsdef.getPSDEFieldId()) != 0L) {
                this.pvaluepsdef = null;
            }
            if (this.pvaluepsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getPValuePSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.pvaluepsdef = pSDEField;
            }
            return this.pvaluepsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getTextPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTextPSDEF();
        }
        if (this.getTextPSDEFId() == null) {
            return null;
        }
        Integer n = this.objTextPSDEFLock;
        synchronized (n) {
            if (this.textpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getTextPSDEFId(), (Object)this.textpsdef.getPSDEFieldId()) != 0L) {
                this.textpsdef = null;
            }
            if (this.textpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getTextPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.textpsdef = pSDEField;
            }
            return this.textpsdef;
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
    public PSDELogic getPSDEMSLogic() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEMSLogic();
        }
        if (this.getPSDEMSLogicId() == null) {
            return null;
        }
        Integer n = this.objPSDEMSLogicLock;
        synchronized (n) {
            if (this.psdemslogic != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEMSLogicId(), (Object)this.psdemslogic.getPSDELogicId()) != 0L) {
                this.psdemslogic = null;
            }
            if (this.psdemslogic == null) {
                PSDELogic pSDELogic = new PSDELogic();
                pSDELogic.setPSDELogicId(this.getPSDEMSLogicId());
                PSDELogicService pSDELogicService = (PSDELogicService)ServiceGlobal.getService(PSDELogicService.class, (SessionFactory)this.getSessionFactory());
                pSDELogicService.autoGet((IEntity)pSDELogic);
                this.psdemslogic = pSDELogic;
            }
            return this.psdemslogic;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEViewBase getLinkPSDEView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLinkPSDEView();
        }
        if (this.getLinkPSDEViewId() == null) {
            return null;
        }
        Integer n = this.objLinkPSDEViewLock;
        synchronized (n) {
            if (this.linkpsdeview != null && DataTypeHelper.compare((int)25, (Object)this.getLinkPSDEViewId(), (Object)this.linkpsdeview.getPSDEViewBaseId()) != 0L) {
                this.linkpsdeview = null;
            }
            if (this.linkpsdeview == null) {
                PSDEViewBase pSDEViewBase = new PSDEViewBase();
                pSDEViewBase.setPSDEViewBaseId(this.getLinkPSDEViewId());
                PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
                pSDEViewBaseService.autoGet((IEntity)pSDEViewBase);
                this.linkpsdeview = pSDEViewBase;
            }
            return this.linkpsdeview;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDynaCodeList getPSDynaCodeList() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaCodeList();
        }
        if (this.getPSDynaCodeListId() == null) {
            return null;
        }
        Integer n = this.objPSDynaCodeListLock;
        synchronized (n) {
            if (this.psdynacodelist != null && DataTypeHelper.compare((int)25, (Object)this.getPSDynaCodeListId(), (Object)this.psdynacodelist.getPSDynaCodeListId()) != 0L) {
                this.psdynacodelist = null;
            }
            if (this.psdynacodelist == null) {
                PSDynaCodeList pSDynaCodeList = new PSDynaCodeList();
                pSDynaCodeList.setPSDynaCodeListId(this.getPSDynaCodeListId());
                PSDynaCodeListService pSDynaCodeListService = (PSDynaCodeListService)ServiceGlobal.getService(PSDynaCodeListService.class, (SessionFactory)this.getSessionFactory());
                pSDynaCodeListService.autoGet((IEntity)pSDynaCodeList);
                this.psdynacodelist = pSDynaCodeList;
            }
            return this.psdynacodelist;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDynaInst getPSDynaInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaInst();
        }
        if (this.getPSDynaInstId() == null) {
            return null;
        }
        Integer n = this.objPSDynaInstLock;
        synchronized (n) {
            if (this.psdynainst != null && DataTypeHelper.compare((int)25, (Object)this.getPSDynaInstId(), (Object)this.psdynainst.getPSDynaInstId()) != 0L) {
                this.psdynainst = null;
            }
            if (this.psdynainst == null) {
                PSDynaInst pSDynaInst = new PSDynaInst();
                pSDynaInst.setPSDynaInstId(this.getPSDynaInstId());
                PSDynaInstService pSDynaInstService = (PSDynaInstService)ServiceGlobal.getService(PSDynaInstService.class, (SessionFactory)this.getSessionFactory());
                pSDynaInstService.autoGet((IEntity)pSDynaInst);
                this.psdynainst = pSDynaInst;
            }
            return this.psdynainst;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguageRes getAllTextPSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAllTextPSLanRes();
        }
        if (this.getAllTextPSLanResId() == null) {
            return null;
        }
        Integer n = this.objAllTextPSLanResLock;
        synchronized (n) {
            if (this.alltextpslanres != null && DataTypeHelper.compare((int)25, (Object)this.getAllTextPSLanResId(), (Object)this.alltextpslanres.getPSLanguageResId()) != 0L) {
                this.alltextpslanres = null;
            }
            if (this.alltextpslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getAllTextPSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet((IEntity)pSLanguageRes);
                this.alltextpslanres = pSLanguageRes;
            }
            return this.alltextpslanres;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguageRes getEmtpyTextPSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEmtpyTextPSLanRes();
        }
        if (this.getEmptyTextPSLanResId() == null) {
            return null;
        }
        Integer n = this.objEmtpyTextPSLanResLock;
        synchronized (n) {
            if (this.emtpytextpslanres != null && DataTypeHelper.compare((int)25, (Object)this.getEmptyTextPSLanResId(), (Object)this.emtpytextpslanres.getPSLanguageResId()) != 0L) {
                this.emtpytextpslanres = null;
            }
            if (this.emtpytextpslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getEmptyTextPSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet((IEntity)pSLanguageRes);
                this.emtpytextpslanres = pSLanguageRes;
            }
            return this.emtpytextpslanres;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSModule getPSModule() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModule();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        Integer n = this.objPSModuleLock;
        synchronized (n) {
            if (this.psmodule != null && DataTypeHelper.compare((int)25, (Object)this.getPSModuleId(), (Object)this.psmodule.getPSModuleId()) != 0L) {
                this.psmodule = null;
            }
            if (this.psmodule == null) {
                PSModule pSModule = new PSModule();
                pSModule.setPSModuleId(this.getPSModuleId());
                PSModuleService pSModuleService = (PSModuleService)ServiceGlobal.getService(PSModuleService.class, (SessionFactory)this.getSessionFactory());
                pSModuleService.autoGet((IEntity)pSModule);
                this.psmodule = pSModule;
            }
            return this.psmodule;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysDynaModel getPSSysDynaModel() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModel();
        }
        if (this.getPSSysDynaModelId() == null) {
            return null;
        }
        Integer n = this.objPSSysDynaModelLock;
        synchronized (n) {
            if (this.pssysdynamodel != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysDynaModelId(), (Object)this.pssysdynamodel.getPSSysDynaModelId()) != 0L) {
                this.pssysdynamodel = null;
            }
            if (this.pssysdynamodel == null) {
                PSSysDynaModel pSSysDynaModel = new PSSysDynaModel();
                pSSysDynaModel.setPSSysDynaModelId(this.getPSSysDynaModelId());
                PSSysDynaModelService pSSysDynaModelService = (PSSysDynaModelService)ServiceGlobal.getService(PSSysDynaModelService.class, (SessionFactory)this.getSessionFactory());
                pSSysDynaModelService.autoGet((IEntity)pSSysDynaModel);
                this.pssysdynamodel = pSSysDynaModel;
            }
            return this.pssysdynamodel;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysPFPlugin getPSSysPFPlugin() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPFPlugin();
        }
        if (this.getPSSysPFPluginId() == null) {
            return null;
        }
        Integer n = this.objPSSysPFPluginLock;
        synchronized (n) {
            if (this.pssyspfplugin != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysPFPluginId(), (Object)this.pssyspfplugin.getPSSysPFPluginId()) != 0L) {
                this.pssyspfplugin = null;
            }
            if (this.pssyspfplugin == null) {
                PSSysPFPlugin pSSysPFPlugin = new PSSysPFPlugin();
                pSSysPFPlugin.setPSSysPFPluginId(this.getPSSysPFPluginId());
                PSSysPFPluginService pSSysPFPluginService = (PSSysPFPluginService)ServiceGlobal.getService(PSSysPFPluginService.class, (SessionFactory)this.getSessionFactory());
                pSSysPFPluginService.autoGet((IEntity)pSSysPFPlugin);
                this.pssyspfplugin = pSSysPFPlugin;
            }
            return this.pssyspfplugin;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysReqItem getPSSysReqItem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysReqItem();
        }
        if (this.getPSSysReqItemId() == null) {
            return null;
        }
        Integer n = this.objPSSysReqItemLock;
        synchronized (n) {
            if (this.pssysreqitem != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysReqItemId(), (Object)this.pssysreqitem.getPSSysReqItemId()) != 0L) {
                this.pssysreqitem = null;
            }
            if (this.pssysreqitem == null) {
                PSSysReqItem pSSysReqItem = new PSSysReqItem();
                pSSysReqItem.setPSSysReqItemId(this.getPSSysReqItemId());
                PSSysReqItemService pSSysReqItemService = (PSSysReqItemService)ServiceGlobal.getService(PSSysReqItemService.class, (SessionFactory)this.getSessionFactory());
                pSSysReqItemService.autoGet((IEntity)pSSysReqItem);
                this.pssysreqitem = pSSysReqItem;
            }
            return this.pssysreqitem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysSFPlugin getPSSysSFPlugin() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPlugin();
        }
        if (this.getPSSysSFPluginId() == null) {
            return null;
        }
        Integer n = this.objPSSysSFPluginLock;
        synchronized (n) {
            if (this.pssyssfplugin != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysSFPluginId(), (Object)this.pssyssfplugin.getPSSysSFPluginId()) != 0L) {
                this.pssyssfplugin = null;
            }
            if (this.pssyssfplugin == null) {
                PSSysSFPlugin pSSysSFPlugin = new PSSysSFPlugin();
                pSSysSFPlugin.setPSSysSFPluginId(this.getPSSysSFPluginId());
                PSSysSFPluginService pSSysSFPluginService = (PSSysSFPluginService)ServiceGlobal.getService(PSSysSFPluginService.class, (SessionFactory)this.getSessionFactory());
                pSSysSFPluginService.autoGet((IEntity)pSSysSFPlugin);
                this.pssyssfplugin = pSSysSFPlugin;
            }
            return this.pssyssfplugin;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSystem getPSSystem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystem();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        Integer n = this.objPSSystemLock;
        synchronized (n) {
            if (this.pssystem != null && DataTypeHelper.compare((int)25, (Object)this.getPSSystemId(), (Object)this.pssystem.getPSSystemId()) != 0L) {
                this.pssystem = null;
            }
            if (this.pssystem == null) {
                PSSystem pSSystem = new PSSystem();
                pSSystem.setPSSystemId(this.getPSSystemId());
                PSSystemService pSSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)this.getSessionFactory());
                pSSystemService.autoGet((IEntity)pSSystem);
                this.pssystem = pSSystem;
            }
            return this.pssystem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSCodeItem> getPSCodeItems() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCodeItems();
        }
        if (this.getPSCodeListId() == null) {
            return null;
        }
        PSCodeListService pSCodeListService = (PSCodeListService)ServiceGlobal.getService(PSCodeListService.class, (SessionFactory)this.getSessionFactory());
        PSCodeItemService pSCodeItemService = (PSCodeItemService)ServiceGlobal.getService(PSCodeItemService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSCodeItemsLock;
        synchronized (n) {
            if (this.pscodeitems == null) {
                this.pscodeitems = pSCodeListService.isTempData((IEntity)this) ? pSCodeItemService.selectTempByPSCodeList(this) : pSCodeItemService.selectByPSCodeList(this);
            }
            return this.pscodeitems;
        }
    }

    private PSCodeListBase getProxyEntity() {
        return this.proxyPSCodeListBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSCodeListBase = null;
        if (iDataObject != null && iDataObject instanceof PSCodeListBase) {
            this.proxyPSCodeListBase = (PSCodeListBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ALLTEXT, 0);
        fieldIndexMap.put(FIELD_ALLTEXTPSLANRESID, 1);
        fieldIndexMap.put(FIELD_ALLTEXTPSLANRESNAME, 2);
        fieldIndexMap.put(FIELD_BEGINVALUEPSDEFID, 3);
        fieldIndexMap.put(FIELD_BEGINVALUEPSDEFNAME, 4);
        fieldIndexMap.put(FIELD_BKCOLORPSDEFID, 5);
        fieldIndexMap.put(FIELD_BKCOLORPSDEFNAME, 6);
        fieldIndexMap.put(FIELD_CACHECAT, 7);
        fieldIndexMap.put(FIELD_CACHETAG, 8);
        fieldIndexMap.put(FIELD_CACHETIMEOUT, 9);
        fieldIndexMap.put(FIELD_CLMODEL, 10);
        fieldIndexMap.put(FIELD_CLSPSDEFID, 11);
        fieldIndexMap.put(FIELD_CLSPSDEFNAME, 12);
        fieldIndexMap.put(FIELD_CLTYPE, 13);
        fieldIndexMap.put(FIELD_CODEITEMTAG, 14);
        fieldIndexMap.put(FIELD_CODELISTSN, 15);
        fieldIndexMap.put(FIELD_CODENAME, 16);
        fieldIndexMap.put(FIELD_COLORPSDEFID, 17);
        fieldIndexMap.put(FIELD_COLORPSDEFNAME, 18);
        fieldIndexMap.put(FIELD_CREATEDATE, 19);
        fieldIndexMap.put(FIELD_CREATEMAN, 20);
        fieldIndexMap.put(FIELD_CUSTOMCOND, 21);
        fieldIndexMap.put(FIELD_CUSTOMTYPE, 22);
        fieldIndexMap.put(FIELD_DATAPSDEFID, 23);
        fieldIndexMap.put(FIELD_DATAPSDEFNAME, 24);
        fieldIndexMap.put(FIELD_DISABLEPSDEFID, 25);
        fieldIndexMap.put(FIELD_DISABLEPSDEFNAME, 26);
        fieldIndexMap.put(FIELD_DSCONDITIONS, 27);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 28);
        fieldIndexMap.put(FIELD_DYNASYSREFMODE, 29);
        fieldIndexMap.put(FIELD_EMPTYTEXT, 30);
        fieldIndexMap.put(FIELD_EMPTYTEXTPSLANRESID, 31);
        fieldIndexMap.put(FIELD_EMPTYTEXTPSLANRESNAME, 32);
        fieldIndexMap.put(FIELD_ENABLECACHE, 33);
        fieldIndexMap.put(FIELD_ENABLEDYNASYS, 34);
        fieldIndexMap.put(FIELD_ENDVALUEPSDEFID, 35);
        fieldIndexMap.put(FIELD_ENDVALUEPSDEFNAME, 36);
        fieldIndexMap.put(FIELD_EXTENDMODE, 37);
        fieldIndexMap.put(FIELD_ICONCLSPSDEFID, 38);
        fieldIndexMap.put(FIELD_ICONCLSPSDEFNAME, 39);
        fieldIndexMap.put(FIELD_ICONCLSXPSDEFID, 40);
        fieldIndexMap.put(FIELD_ICONCLSXPSDEFNAME, 41);
        fieldIndexMap.put(FIELD_ICONPATHPSDEFID, 42);
        fieldIndexMap.put(FIELD_ICONPATHPSDEFNAME, 43);
        fieldIndexMap.put(FIELD_ICONPATHXPSDEFID, 44);
        fieldIndexMap.put(FIELD_ICONPATHXPSDEFNAME, 45);
        fieldIndexMap.put(FIELD_INCBEGINVALUE, 46);
        fieldIndexMap.put(FIELD_INCENDVALUE, 47);
        fieldIndexMap.put(FIELD_LINKPSDEVIEWID, 48);
        fieldIndexMap.put(FIELD_LINKPSDEVIEWNAME, 49);
        fieldIndexMap.put(FIELD_LOCKFLAG, 50);
        fieldIndexMap.put(FIELD_MEMO, 51);
        fieldIndexMap.put(FIELD_MINORSORTDIR, 52);
        fieldIndexMap.put(FIELD_MINORSORTPSDEFID, 53);
        fieldIndexMap.put(FIELD_MINORSORTPSDEFNAME, 54);
        fieldIndexMap.put(FIELD_MODCOLOR, 55);
        fieldIndexMap.put(FIELD_NOVALUEEMPTY, 56);
        fieldIndexMap.put(FIELD_NUMBERITEM, 57);
        fieldIndexMap.put(FIELD_ORDERVALUE, 58);
        fieldIndexMap.put(FIELD_ORMODE, 59);
        fieldIndexMap.put(FIELD_PREDEFINEDTYPE, 60);
        fieldIndexMap.put(FIELD_PSCODELISTID, 61);
        fieldIndexMap.put(FIELD_PSCODELISTNAME, 62);
        fieldIndexMap.put(FIELD_PSCODELISTTEMPLID, 63);
        fieldIndexMap.put(FIELD_PSCODELISTTEMPLNAME, 64);
        fieldIndexMap.put(FIELD_PSDEDSID, 65);
        fieldIndexMap.put(FIELD_PSDEDSNAME, 66);
        fieldIndexMap.put(FIELD_PSDEID, 67);
        fieldIndexMap.put(FIELD_PSDEMSLOGICID, 68);
        fieldIndexMap.put(FIELD_PSDEMSLOGICNAME, 69);
        fieldIndexMap.put(FIELD_PSDENAME, 70);
        fieldIndexMap.put(FIELD_PSDYNACODELISTID, 71);
        fieldIndexMap.put(FIELD_PSDYNACODELISTNAME, 72);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 73);
        fieldIndexMap.put(FIELD_PSDYNAINSTNAME, 74);
        fieldIndexMap.put(FIELD_PSMODULEID, 75);
        fieldIndexMap.put(FIELD_PSMODULENAME, 76);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 77);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 78);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINID, 79);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINNAME, 80);
        fieldIndexMap.put(FIELD_PSSYSREQITEMID, 81);
        fieldIndexMap.put(FIELD_PSSYSREQITEMNAME, 82);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 83);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 84);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 85);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 86);
        fieldIndexMap.put(FIELD_PVALUEPSDEFID, 87);
        fieldIndexMap.put(FIELD_PVALUEPSDEFNAME, 88);
        fieldIndexMap.put(FIELD_SEPERATOR, 89);
        fieldIndexMap.put(FIELD_SRFSYSPUB, 90);
        fieldIndexMap.put(FIELD_SYSREFFLAG, 91);
        fieldIndexMap.put(FIELD_TEXTPSDEFID, 92);
        fieldIndexMap.put(FIELD_TEXTPSDEFNAME, 93);
        fieldIndexMap.put(FIELD_THRESHOLDGROUPFLAG, 94);
        fieldIndexMap.put(FIELD_UPDATEDATE, 95);
        fieldIndexMap.put(FIELD_UPDATEMAN, 96);
        fieldIndexMap.put(FIELD_USERCAT, 97);
        fieldIndexMap.put(FIELD_USERDATA, 98);
        fieldIndexMap.put(FIELD_USERDATA2, 99);
        fieldIndexMap.put(FIELD_USERPARAMS, 100);
        fieldIndexMap.put(FIELD_USERREFFLAG, 101);
        fieldIndexMap.put(FIELD_USERSCOPE, 102);
        fieldIndexMap.put(FIELD_USERTAG, 103);
        fieldIndexMap.put(FIELD_USERTAG2, 104);
        fieldIndexMap.put(FIELD_USERTAG3, 105);
        fieldIndexMap.put(FIELD_USERTAG4, 106);
        fieldIndexMap.put(FIELD_VALIDFLAG, 107);
        fieldIndexMap.put(FIELD_VALUEPSDEFID, 108);
        fieldIndexMap.put(FIELD_VALUEPSDEFNAME, 109);
        fieldIndexMap.put(FIELD_VALUESEPERATOR, 110);
    }
}

