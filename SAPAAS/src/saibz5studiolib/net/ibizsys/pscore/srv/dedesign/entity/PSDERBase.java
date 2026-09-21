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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEACMode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDRItem;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPriv;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.entity.PSDERDEFMap;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEACModeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDRItemService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivService;
import net.ibizsys.pscore.srv.dedesign.service.PSDERDEFMapService;
import net.ibizsys.pscore.srv.dedesign.service.PSDERService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDERBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDERBase.class);
    public static final String FIELD_CLONEORDERVALUE = "CLONEORDERVALUE";
    public static final String FIELD_CLONERSFIELDS = "CLONERSFIELDS";
    public static final String FIELD_CNTPSDEFID = "CNTPSDEFID";
    public static final String FIELD_CNTPSDEFNAME = "CNTPSDEFNAME";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEFINHERITMODE = "DEFINHERITMODE";
    public static final String FIELD_DERFIELDLNAME = "DERFIELDLNAME";
    public static final String FIELD_DERFIELDNAME = "DERFIELDNAME";
    public static final String FIELD_DERSUBTYPE = "DERSUBTYPE";
    public static final String FIELD_DERTAG = "DERTAG";
    public static final String FIELD_DERTAG2 = "DERTAG2";
    public static final String FIELD_DERTYPE = "DERTYPE";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_ENABLECLONE = "ENABLECLONE";
    public static final String FIELD_ENADEFIELDWRITEBACK = "ENADEFIELDWRITEBACK";
    public static final String FIELD_ENAEXTRANGE = "ENAEXTRANGE";
    public static final String FIELD_ENAPDEREQ = "ENAPDEREQ";
    public static final String FIELD_EXPORTMAJORMODEL = "EXPORTMAJORMODEL";
    public static final String FIELD_EXPORTMODEL = "EXPORTMODEL";
    public static final String FIELD_EXPORTSCOPE = "EXPORTSCOPE";
    public static final String FIELD_EXPORTSCOPE2 = "EXPORTSCOPE2";
    public static final String FIELD_EXPORTSCOPE3 = "EXPORTSCOPE3";
    public static final String FIELD_EXPORTSCOPE4 = "EXPORTSCOPE4";
    public static final String FIELD_EXPORTSCOPE5 = "EXPORTSCOPE5";
    public static final String FIELD_EXPORTSCOPE6 = "EXPORTSCOPE6";
    public static final String FIELD_EXTMAJORPSDEFID = "EXTMAJORPSDEFID";
    public static final String FIELD_EXTMAJORPSDEFNAME = "EXTMAJORPSDEFNAME";
    public static final String FIELD_EXTMINORPSDEFID = "EXTMINORPSDEFID";
    public static final String FIELD_EXTMINORPSDEFNAME = "EXTMINORPSDEFNAME";
    public static final String FIELD_FKEYNAME = "FKEYNAME";
    public static final String FIELD_FOREIGNKEY = "FOREIGNKEY";
    public static final String FIELD_IGNOREDEFIELDS = "IGNOREDEFIELDS";
    public static final String FIELD_INDEXVALUE = "INDEXVALUE";
    public static final String FIELD_INHERITMODE = "INHERITMODE";
    public static final String FIELD_LINKPSDEVIEWID = "LINKPSDEVIEWID";
    public static final String FIELD_LINKPSDEVIEWNAME = "LINKPSDEVIEWNAME";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MAJORPSDEID = "MAJORPSDEID";
    public static final String FIELD_MAJORPSDENAME = "MAJORPSDENAME";
    public static final String FIELD_MAJORPSDERID = "MAJORPSDERID";
    public static final String FIELD_MAJORPSDERNAME = "MAJORPSDERNAME";
    public static final String FIELD_MASTERORDERVALUE = "MASTERORDERVALUE";
    public static final String FIELD_MASTERRS = "MASTERRS";
    public static final String FIELD_MDPSDEVIEWID = "MDPSDEVIEWID";
    public static final String FIELD_MDPSDEVIEWNAME = "MDPSDEVIEWNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MINORCODENAME = "MINORCODENAME";
    public static final String FIELD_MINORLOGICNAME = "MINORLOGICNAME";
    public static final String FIELD_MINORPSDEDSID = "MINORPSDEDSID";
    public static final String FIELD_MINORPSDEDSNAME = "MINORPSDEDSNAME";
    public static final String FIELD_MINORPSDEID = "MINORPSDEID";
    public static final String FIELD_MINORPSDENAME = "MINORPSDENAME";
    public static final String FIELD_MINORPSDERID = "MINORPSDERID";
    public static final String FIELD_MINORPSDERNAME = "MINORPSDERNAME";
    public static final String FIELD_MINORSERVICECODENAME = "MINORSERVICECODENAME";
    public static final String FIELD_MOBLINKPSDEVIEWID = "MOBLINKPSDEVIEWID";
    public static final String FIELD_MOBLINKPSDEVIEWNAME = "MOBLINKPSDEVIEWNAME";
    public static final String FIELD_MOBMDPSDEVIEWID = "MOBMDPSDEVIEWID";
    public static final String FIELD_MOBMDPSDEVIEWNAME = "MOBMDPSDEVIEWNAME";
    public static final String FIELD_MOBSDPSDEVIEWID = "MOBSDPSDEVIEWID";
    public static final String FIELD_MOBSDPSDEVIEWNAME = "MOBSDPSDEVIEWNAME";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PREDEFINEDTYPE = "PREDEFINEDTYPE";
    public static final String FIELD_PROPERTYMAP = "PROPERTYMAP";
    public static final String FIELD_PSDEACMODEID = "PSDEACMODEID";
    public static final String FIELD_PSDEACMODENAME = "PSDEACMODENAME";
    public static final String FIELD_PSDEDATASETID = "PSDEDATASETID";
    public static final String FIELD_PSDEDATASETNAME = "PSDEDATASETNAME";
    public static final String FIELD_PSDEDRITEMSCNT = "PSDEDRITEMSCNT";
    public static final String FIELD_PSDEFGROUPID = "PSDEFGROUPID";
    public static final String FIELD_PSDEFGROUPNAME = "PSDEFGROUPNAME";
    public static final String FIELD_PSDEFIELDSCNT = "PSDEFIELDSCNT";
    public static final String FIELD_PSDEOPPRIVSCNT = "PSDEOPPRIVSCNT";
    public static final String FIELD_PSDERDEFMAPSCNT = "PSDERDEFMAPSCNT";
    public static final String FIELD_PSDERID = "PSDERID";
    public static final String FIELD_PSDERNAME = "PSDERNAME";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String FIELD_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String FIELD_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String FIELD_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_REMOVEACTIONTYPE = "REMOVEACTIONTYPE";
    public static final String FIELD_REMOVEORDER = "REMOVEORDER";
    public static final String FIELD_REMOVEREJECTMSG = "REMOVEREJECTMSG";
    public static final String FIELD_REMOVEREJECTPSLANRESID = "REMOVEREJECTPSLANRESID";
    public static final String FIELD_REMOVEREJECTPSLANRESNAME = "REMOVEREJECTPSLANRESNAME";
    public static final String FIELD_RSPSDEVIEWID = "RSPSDEVIEWID";
    public static final String FIELD_RSPSDEVIEWNAME = "RSPSDEVIEWNAME";
    public static final String FIELD_SDPSDEVIEWID = "SDPSDEVIEWID";
    public static final String FIELD_SDPSDEVIEWNAME = "SDPSDEVIEWNAME";
    public static final String FIELD_SERVICECODENAME = "SERVICECODENAME";
    public static final String FIELD_SYNCEXPORTMODEL = "SYNCEXPORTMODEL";
    public static final String FIELD_TEMPORDERVALUE = "TEMPORDERVALUE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_UPDATEPHSICALDEFIELD = "UPDATEPHYSICALDEFIELD";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERPARAMS = "USERPARAMS";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CLONEORDERVALUE = 0;
    private static final int INDEX_CLONERSFIELDS = 1;
    private static final int INDEX_CNTPSDEFID = 2;
    private static final int INDEX_CNTPSDEFNAME = 3;
    private static final int INDEX_CODENAME = 4;
    private static final int INDEX_CREATEDATE = 5;
    private static final int INDEX_CREATEMAN = 6;
    private static final int INDEX_DEFINHERITMODE = 7;
    private static final int INDEX_DERFIELDLNAME = 8;
    private static final int INDEX_DERFIELDNAME = 9;
    private static final int INDEX_DERSUBTYPE = 10;
    private static final int INDEX_DERTAG = 11;
    private static final int INDEX_DERTAG2 = 12;
    private static final int INDEX_DERTYPE = 13;
    private static final int INDEX_DYNAMODELFLAG = 14;
    private static final int INDEX_ENABLECLONE = 15;
    private static final int INDEX_ENADEFIELDWRITEBACK = 16;
    private static final int INDEX_ENAEXTRANGE = 17;
    private static final int INDEX_ENAPDEREQ = 18;
    private static final int INDEX_EXPORTMAJORMODEL = 19;
    private static final int INDEX_EXPORTMODEL = 20;
    private static final int INDEX_EXPORTSCOPE = 21;
    private static final int INDEX_EXPORTSCOPE2 = 22;
    private static final int INDEX_EXPORTSCOPE3 = 23;
    private static final int INDEX_EXPORTSCOPE4 = 24;
    private static final int INDEX_EXPORTSCOPE5 = 25;
    private static final int INDEX_EXPORTSCOPE6 = 26;
    private static final int INDEX_EXTMAJORPSDEFID = 27;
    private static final int INDEX_EXTMAJORPSDEFNAME = 28;
    private static final int INDEX_EXTMINORPSDEFID = 29;
    private static final int INDEX_EXTMINORPSDEFNAME = 30;
    private static final int INDEX_FKEYNAME = 31;
    private static final int INDEX_FOREIGNKEY = 32;
    private static final int INDEX_IGNOREDEFIELDS = 33;
    private static final int INDEX_INDEXVALUE = 34;
    private static final int INDEX_INHERITMODE = 35;
    private static final int INDEX_LINKPSDEVIEWID = 36;
    private static final int INDEX_LINKPSDEVIEWNAME = 37;
    private static final int INDEX_LOCKFLAG = 38;
    private static final int INDEX_LOGICNAME = 39;
    private static final int INDEX_MAJORPSDEID = 40;
    private static final int INDEX_MAJORPSDENAME = 41;
    private static final int INDEX_MAJORPSDERID = 42;
    private static final int INDEX_MAJORPSDERNAME = 43;
    private static final int INDEX_MASTERORDERVALUE = 44;
    private static final int INDEX_MASTERRS = 45;
    private static final int INDEX_MDPSDEVIEWID = 46;
    private static final int INDEX_MDPSDEVIEWNAME = 47;
    private static final int INDEX_MEMO = 48;
    private static final int INDEX_MINORCODENAME = 49;
    private static final int INDEX_MINORLOGICNAME = 50;
    private static final int INDEX_MINORPSDEDSID = 51;
    private static final int INDEX_MINORPSDEDSNAME = 52;
    private static final int INDEX_MINORPSDEID = 53;
    private static final int INDEX_MINORPSDENAME = 54;
    private static final int INDEX_MINORPSDERID = 55;
    private static final int INDEX_MINORPSDERNAME = 56;
    private static final int INDEX_MINORSERVICECODENAME = 57;
    private static final int INDEX_MOBLINKPSDEVIEWID = 58;
    private static final int INDEX_MOBLINKPSDEVIEWNAME = 59;
    private static final int INDEX_MOBMDPSDEVIEWID = 60;
    private static final int INDEX_MOBMDPSDEVIEWNAME = 61;
    private static final int INDEX_MOBSDPSDEVIEWID = 62;
    private static final int INDEX_MOBSDPSDEVIEWNAME = 63;
    private static final int INDEX_ORDERVALUE = 64;
    private static final int INDEX_PREDEFINEDTYPE = 65;
    private static final int INDEX_PROPERTYMAP = 66;
    private static final int INDEX_PSDEACMODEID = 67;
    private static final int INDEX_PSDEACMODENAME = 68;
    private static final int INDEX_PSDEDATASETID = 69;
    private static final int INDEX_PSDEDATASETNAME = 70;
    private static final int INDEX_PSDEDRITEMSCNT = 71;
    private static final int INDEX_PSDEFGROUPID = 72;
    private static final int INDEX_PSDEFGROUPNAME = 73;
    private static final int INDEX_PSDEFIELDSCNT = 74;
    private static final int INDEX_PSDEOPPRIVSCNT = 75;
    private static final int INDEX_PSDERDEFMAPSCNT = 76;
    private static final int INDEX_PSDERID = 77;
    private static final int INDEX_PSDERNAME = 78;
    private static final int INDEX_PSDYNAINSTID = 79;
    private static final int INDEX_PSSYSDYNAMODELID = 80;
    private static final int INDEX_PSSYSDYNAMODELNAME = 81;
    private static final int INDEX_PSSYSSFPLUGINID = 82;
    private static final int INDEX_PSSYSSFPLUGINNAME = 83;
    private static final int INDEX_PSSYSTEMID = 84;
    private static final int INDEX_PSSYSTEMNAME = 85;
    private static final int INDEX_REMOVEACTIONTYPE = 86;
    private static final int INDEX_REMOVEORDER = 87;
    private static final int INDEX_REMOVEREJECTMSG = 88;
    private static final int INDEX_REMOVEREJECTPSLANRESID = 89;
    private static final int INDEX_REMOVEREJECTPSLANRESNAME = 90;
    private static final int INDEX_RSPSDEVIEWID = 91;
    private static final int INDEX_RSPSDEVIEWNAME = 92;
    private static final int INDEX_SDPSDEVIEWID = 93;
    private static final int INDEX_SDPSDEVIEWNAME = 94;
    private static final int INDEX_SERVICECODENAME = 95;
    private static final int INDEX_SYNCEXPORTMODEL = 96;
    private static final int INDEX_TEMPORDERVALUE = 97;
    private static final int INDEX_UPDATEDATE = 98;
    private static final int INDEX_UPDATEMAN = 99;
    private static final int INDEX_UPDATEPHSICALDEFIELD = 100;
    private static final int INDEX_USERCAT = 101;
    private static final int INDEX_USERPARAMS = 102;
    private static final int INDEX_USERTAG = 103;
    private static final int INDEX_USERTAG2 = 104;
    private static final int INDEX_USERTAG3 = 105;
    private static final int INDEX_USERTAG4 = 106;
    private static final int INDEX_VALIDFLAG = 107;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDERBase proxyPSDERBase = null;
    private boolean cloneordervalueDirtyFlag = false;
    private boolean clonersfieldsDirtyFlag = false;
    private boolean cntpsdefidDirtyFlag = false;
    private boolean cntpsdefnameDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean definheritmodeDirtyFlag = false;
    private boolean derfieldlnameDirtyFlag = false;
    private boolean derfieldnameDirtyFlag = false;
    private boolean dersubtypeDirtyFlag = false;
    private boolean dertagDirtyFlag = false;
    private boolean dertag2DirtyFlag = false;
    private boolean dertypeDirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean enablecloneDirtyFlag = false;
    private boolean enadefieldwritebackDirtyFlag = false;
    private boolean enaextrangeDirtyFlag = false;
    private boolean enapdereqDirtyFlag = false;
    private boolean exportmajormodelDirtyFlag = false;
    private boolean exportmodelDirtyFlag = false;
    private boolean exportscopeDirtyFlag = false;
    private boolean exportscope2DirtyFlag = false;
    private boolean exportscope3DirtyFlag = false;
    private boolean exportscope4DirtyFlag = false;
    private boolean exportscope5DirtyFlag = false;
    private boolean exportscope6DirtyFlag = false;
    private boolean extmajorpsdefidDirtyFlag = false;
    private boolean extmajorpsdefnameDirtyFlag = false;
    private boolean extminorpsdefidDirtyFlag = false;
    private boolean extminorpsdefnameDirtyFlag = false;
    private boolean fkeynameDirtyFlag = false;
    private boolean foreignkeyDirtyFlag = false;
    private boolean ignoredefieldsDirtyFlag = false;
    private boolean indexvalueDirtyFlag = false;
    private boolean inheritmodeDirtyFlag = false;
    private boolean linkpsdeviewidDirtyFlag = false;
    private boolean linkpsdeviewnameDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean majorpsdeidDirtyFlag = false;
    private boolean majorpsdenameDirtyFlag = false;
    private boolean majorpsderidDirtyFlag = false;
    private boolean majorpsdernameDirtyFlag = false;
    private boolean masterordervalueDirtyFlag = false;
    private boolean masterrsDirtyFlag = false;
    private boolean mdpsdeviewidDirtyFlag = false;
    private boolean mdpsdeviewnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean minorcodenameDirtyFlag = false;
    private boolean minorlogicnameDirtyFlag = false;
    private boolean minorpsdedsidDirtyFlag = false;
    private boolean minorpsdedsnameDirtyFlag = false;
    private boolean minorpsdeidDirtyFlag = false;
    private boolean minorpsdenameDirtyFlag = false;
    private boolean minorpsderidDirtyFlag = false;
    private boolean minorpsdernameDirtyFlag = false;
    private boolean minorservicecodenameDirtyFlag = false;
    private boolean moblinkpsdeviewidDirtyFlag = false;
    private boolean moblinkpsdeviewnameDirtyFlag = false;
    private boolean mobmdpsdeviewidDirtyFlag = false;
    private boolean mobmdpsdeviewnameDirtyFlag = false;
    private boolean mobsdpsdeviewidDirtyFlag = false;
    private boolean mobsdpsdeviewnameDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean predefinedtypeDirtyFlag = false;
    private boolean propertymapDirtyFlag = false;
    private boolean psdeacmodeidDirtyFlag = false;
    private boolean psdeacmodenameDirtyFlag = false;
    private boolean psdedatasetidDirtyFlag = false;
    private boolean psdedatasetnameDirtyFlag = false;
    private boolean psdedritemscntDirtyFlag = false;
    private boolean psdefgroupidDirtyFlag = false;
    private boolean psdefgroupnameDirtyFlag = false;
    private boolean psdefieldscntDirtyFlag = false;
    private boolean psdeopprivscntDirtyFlag = false;
    private boolean psderdefmapscntDirtyFlag = false;
    private boolean psderidDirtyFlag = false;
    private boolean psdernameDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean pssysdynamodelidDirtyFlag = false;
    private boolean pssysdynamodelnameDirtyFlag = false;
    private boolean pssyssfpluginidDirtyFlag = false;
    private boolean pssyssfpluginnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean removeactiontypeDirtyFlag = false;
    private boolean removeorderDirtyFlag = false;
    private boolean removerejectmsgDirtyFlag = false;
    private boolean removerejectpslanresidDirtyFlag = false;
    private boolean removerejectpslanresnameDirtyFlag = false;
    private boolean rspsdeviewidDirtyFlag = false;
    private boolean rspsdeviewnameDirtyFlag = false;
    private boolean sdpsdeviewidDirtyFlag = false;
    private boolean sdpsdeviewnameDirtyFlag = false;
    private boolean servicecodenameDirtyFlag = false;
    private boolean syncexportmodelDirtyFlag = false;
    private boolean tempordervalueDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean updatephsicaldefieldDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean userparamsDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="cloneordervalue")
    private Integer cloneordervalue;
    @Column(name="clonersfields")
    private String clonersfields;
    @Column(name="cntpsdefid")
    private String cntpsdefid;
    @Column(name="cntpsdefname")
    private String cntpsdefname;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="definheritmode")
    private Integer definheritmode;
    @Column(name="derfieldlname")
    private String derfieldlname;
    @Column(name="derfieldname")
    private String derfieldname;
    @Column(name="dersubtype")
    private String dersubtype;
    @Column(name="dertag")
    private String dertag;
    @Column(name="dertag2")
    private String dertag2;
    @Column(name="dertype")
    private String dertype;
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="enableclone")
    private Integer enableclone;
    @Column(name="enadefieldwriteback")
    private Integer enadefieldwriteback;
    @Column(name="enaextrange")
    private Integer enaextrange;
    @Column(name="enapdereq")
    private Integer enapdereq;
    @Column(name="exportmajormodel")
    private Integer exportmajormodel;
    @Column(name="exportmodel")
    private Integer exportmodel;
    @Column(name="exportscope")
    private Integer exportscope;
    @Column(name="exportscope2")
    private Integer exportscope2;
    @Column(name="exportscope3")
    private Integer exportscope3;
    @Column(name="exportscope4")
    private Integer exportscope4;
    @Column(name="exportscope5")
    private Integer exportscope5;
    @Column(name="exportscope6")
    private Integer exportscope6;
    @Column(name="extmajorpsdefid")
    private String extmajorpsdefid;
    @Column(name="extmajorpsdefname")
    private String extmajorpsdefname;
    @Column(name="extminorpsdefid")
    private String extminorpsdefid;
    @Column(name="extminorpsdefname")
    private String extminorpsdefname;
    @Column(name="fkeyname")
    private String fkeyname;
    @Column(name="foreignkey")
    private Integer foreignkey;
    @Column(name="ignoredefields")
    private String ignoredefields;
    @Column(name="indexvalue")
    private String indexvalue;
    @Column(name="inheritmode")
    private Integer inheritmode;
    @Column(name="linkpsdeviewid")
    private String linkpsdeviewid;
    @Column(name="linkpsdeviewname")
    private String linkpsdeviewname;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="logicname")
    private String logicname;
    @Column(name="majorpsdeid")
    private String majorpsdeid;
    @Column(name="majorpsdename")
    private String majorpsdename;
    @Column(name="majorpsderid")
    private String majorpsderid;
    @Column(name="majorpsdername")
    private String majorpsdername;
    @Column(name="masterordervalue")
    private Integer masterordervalue;
    @Column(name="masterrs")
    private Integer masterrs;
    @Column(name="mdpsdeviewid")
    private String mdpsdeviewid;
    @Column(name="mdpsdeviewname")
    private String mdpsdeviewname;
    @Column(name="memo")
    private String memo;
    @Column(name="minorcodename")
    private String minorcodename;
    @Column(name="minorlogicname")
    private String minorlogicname;
    @Column(name="minorpsdedsid")
    private String minorpsdedsid;
    @Column(name="minorpsdedsname")
    private String minorpsdedsname;
    @Column(name="minorpsdeid")
    private String minorpsdeid;
    @Column(name="minorpsdename")
    private String minorpsdename;
    @Column(name="minorpsderid")
    private String minorpsderid;
    @Column(name="minorpsdername")
    private String minorpsdername;
    @Column(name="minorservicecodename")
    private String minorservicecodename;
    @Column(name="moblinkpsdeviewid")
    private String moblinkpsdeviewid;
    @Column(name="moblinkpsdeviewname")
    private String moblinkpsdeviewname;
    @Column(name="mobmdpsdeviewid")
    private String mobmdpsdeviewid;
    @Column(name="mobmdpsdeviewname")
    private String mobmdpsdeviewname;
    @Column(name="mobsdpsdeviewid")
    private String mobsdpsdeviewid;
    @Column(name="mobsdpsdeviewname")
    private String mobsdpsdeviewname;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="predefinedtype")
    private String predefinedtype;
    @Column(name="propertymap")
    private String propertymap;
    @Column(name="psdeacmodeid")
    private String psdeacmodeid;
    @Column(name="psdeacmodename")
    private String psdeacmodename;
    @Column(name="psdedatasetid")
    private String psdedatasetid;
    @Column(name="psdedatasetname")
    private String psdedatasetname;
    @Column(name="psdedritemscnt")
    private Integer psdedritemscnt;
    @Column(name="psdefgroupid")
    private String psdefgroupid;
    @Column(name="psdefgroupname")
    private String psdefgroupname;
    @Column(name="psdefieldscnt")
    private Integer psdefieldscnt;
    @Column(name="psdeopprivscnt")
    private Integer psdeopprivscnt;
    @Column(name="psderdefmapscnt")
    private Integer psderdefmapscnt;
    @Column(name="psderid")
    private String psderid;
    @Column(name="psdername")
    private String psdername;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="pssysdynamodelid")
    private String pssysdynamodelid;
    @Column(name="pssysdynamodelname")
    private String pssysdynamodelname;
    @Column(name="pssyssfpluginid")
    private String pssyssfpluginid;
    @Column(name="pssyssfpluginname")
    private String pssyssfpluginname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="removeactiontype")
    private Integer removeactiontype;
    @Column(name="removeorder")
    private Integer removeorder;
    @Column(name="removerejectmsg")
    private String removerejectmsg;
    @Column(name="removerejectpslanresid")
    private String removerejectpslanresid;
    @Column(name="removerejectpslanresname")
    private String removerejectpslanresname;
    @Column(name="rspsdeviewid")
    private String rspsdeviewid;
    @Column(name="rspsdeviewname")
    private String rspsdeviewname;
    @Column(name="sdpsdeviewid")
    private String sdpsdeviewid;
    @Column(name="sdpsdeviewname")
    private String sdpsdeviewname;
    @Column(name="servicecodename")
    private String servicecodename;
    @Column(name="syncexportmodel")
    private Integer syncexportmodel;
    @Column(name="tempordervalue")
    private Integer tempordervalue;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="updatephsicaldefield")
    private Integer updatephsicaldefield;
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
    private Integer objMajorPSDELock = new Integer(1);
    private PSDataEntity majorpsde = null;
    private Integer objMinorPSDELock = new Integer(1);
    private PSDataEntity minorpsde = null;
    private Integer objPSDEACModeLock = new Integer(1);
    private PSDEACMode psdeacmode = null;
    private Integer objMinorPSDEDSLock = new Integer(1);
    private PSDEDataSet minorpsdeds = null;
    private Integer objPSDEDataSetLock = new Integer(1);
    private PSDEDataSet psdedataset = null;
    private Integer objPSDEFGroupLock = new Integer(1);
    private PSDEFGroup psdefgroup = null;
    private Integer objCntPSDEFLock = new Integer(1);
    private PSDEField cntpsdef = null;
    private Integer objExtMajorPSDEFLock = new Integer(1);
    private PSDEField extmajorpsdef = null;
    private Integer objExtMinorPSDEFLock = new Integer(1);
    private PSDEField extminorpsdef = null;
    private Integer objMajorPSDERLock = new Integer(1);
    private PSDER majorpsder = null;
    private Integer objMinorPSDERLock = new Integer(1);
    private PSDER minorpsder = null;
    private Integer objLinkPSDEViewLock = new Integer(1);
    private PSDEViewBase linkpsdeview = null;
    private Integer objMDPSDEViewLock = new Integer(1);
    private PSDEViewBase mdpsdeview = null;
    private Integer objMobLinkPSDEViewLock = new Integer(1);
    private PSDEViewBase moblinkpsdeview = null;
    private Integer objMobMDPSDEViewLock = new Integer(1);
    private PSDEViewBase mobmdpsdeview = null;
    private Integer objMobSDPSDEViewLock = new Integer(1);
    private PSDEViewBase mobsdpsdeview = null;
    private Integer objRSPSDEViewLock = new Integer(1);
    private PSDEViewBase rspsdeview = null;
    private Integer objSDPSDEViewLock = new Integer(1);
    private PSDEViewBase sdpsdeview = null;
    private Integer objRemoveRejectPSLanResLock = new Integer(1);
    private PSLanguageRes removerejectpslanres = null;
    private Integer objPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel pssysdynamodel = null;
    private Integer objPSSysSFPluginLock = new Integer(1);
    private PSSysSFPlugin pssyssfplugin = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSDEDRItemsLock = new Integer(1);
    private ArrayList<PSDEDRItem> psdedritems = null;
    private Integer objPSDEFieldsLock = new Integer(1);
    private ArrayList<PSDEField> psdefields = null;
    private Integer objPSDEOPPrivsLock = new Integer(1);
    private ArrayList<PSDEOPPriv> psdeopprivs = null;
    private Integer objPSDERDEFMapsLock = new Integer(1);
    private ArrayList<PSDERDEFMap> psderdefmaps = null;

    public void setCloneOrderValue(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCloneOrderValue(n);
            return;
        }
        this.cloneordervalue = n;
        this.cloneordervalueDirtyFlag = true;
    }

    public Integer getCloneOrderValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCloneOrderValue();
        }
        return this.cloneordervalue;
    }

    public boolean isCloneOrderValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCloneOrderValueDirty();
        }
        return this.cloneordervalueDirtyFlag;
    }

    public void resetCloneOrderValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCloneOrderValue();
            return;
        }
        this.cloneordervalueDirtyFlag = false;
        this.cloneordervalue = null;
    }

    public void setCloneRSFields(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCloneRSFields(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.clonersfields = string;
        this.clonersfieldsDirtyFlag = true;
    }

    public String getCloneRSFields() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCloneRSFields();
        }
        return this.clonersfields;
    }

    public boolean isCloneRSFieldsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCloneRSFieldsDirty();
        }
        return this.clonersfieldsDirtyFlag;
    }

    public void resetCloneRSFields() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCloneRSFields();
            return;
        }
        this.clonersfieldsDirtyFlag = false;
        this.clonersfields = null;
    }

    public void setCntPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCntPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cntpsdefid = string;
        this.cntpsdefidDirtyFlag = true;
    }

    public String getCntPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCntPSDEFId();
        }
        return this.cntpsdefid;
    }

    public boolean isCntPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCntPSDEFIdDirty();
        }
        return this.cntpsdefidDirtyFlag;
    }

    public void resetCntPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCntPSDEFId();
            return;
        }
        this.cntpsdefidDirtyFlag = false;
        this.cntpsdefid = null;
    }

    public void setCntPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCntPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cntpsdefname = string;
        this.cntpsdefnameDirtyFlag = true;
    }

    public String getCntPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCntPSDEFName();
        }
        return this.cntpsdefname;
    }

    public boolean isCntPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCntPSDEFNameDirty();
        }
        return this.cntpsdefnameDirtyFlag;
    }

    public void resetCntPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCntPSDEFName();
            return;
        }
        this.cntpsdefnameDirtyFlag = false;
        this.cntpsdefname = null;
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

    public void setDEFInheritMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEFInheritMode(n);
            return;
        }
        this.definheritmode = n;
        this.definheritmodeDirtyFlag = true;
    }

    public Integer getDEFInheritMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEFInheritMode();
        }
        return this.definheritmode;
    }

    public boolean isDEFInheritModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEFInheritModeDirty();
        }
        return this.definheritmodeDirtyFlag;
    }

    public void resetDEFInheritMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEFInheritMode();
            return;
        }
        this.definheritmodeDirtyFlag = false;
        this.definheritmode = null;
    }

    public void setDERFieldLName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDERFieldLName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.derfieldlname = string;
        this.derfieldlnameDirtyFlag = true;
    }

    public String getDERFieldLName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDERFieldLName();
        }
        return this.derfieldlname;
    }

    public boolean isDERFieldLNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDERFieldLNameDirty();
        }
        return this.derfieldlnameDirtyFlag;
    }

    public void resetDERFieldLName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDERFieldLName();
            return;
        }
        this.derfieldlnameDirtyFlag = false;
        this.derfieldlname = null;
    }

    public void setDERFieldName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDERFieldName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        if (string != null) {
            string = string.toUpperCase();
        }
        this.derfieldname = string;
        this.derfieldnameDirtyFlag = true;
    }

    public String getDERFieldName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDERFieldName();
        }
        return this.derfieldname;
    }

    public boolean isDERFieldNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDERFieldNameDirty();
        }
        return this.derfieldnameDirtyFlag;
    }

    public void resetDERFieldName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDERFieldName();
            return;
        }
        this.derfieldnameDirtyFlag = false;
        this.derfieldname = null;
    }

    public void setDERSubType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDERSubType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dersubtype = string;
        this.dersubtypeDirtyFlag = true;
    }

    public String getDERSubType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDERSubType();
        }
        return this.dersubtype;
    }

    public boolean isDERSubTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDERSubTypeDirty();
        }
        return this.dersubtypeDirtyFlag;
    }

    public void resetDERSubType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDERSubType();
            return;
        }
        this.dersubtypeDirtyFlag = false;
        this.dersubtype = null;
    }

    public void setDERTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDERTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dertag = string;
        this.dertagDirtyFlag = true;
    }

    public String getDERTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDERTag();
        }
        return this.dertag;
    }

    public boolean isDERTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDERTagDirty();
        }
        return this.dertagDirtyFlag;
    }

    public void resetDERTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDERTag();
            return;
        }
        this.dertagDirtyFlag = false;
        this.dertag = null;
    }

    public void setDERTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDERTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dertag2 = string;
        this.dertag2DirtyFlag = true;
    }

    public String getDERTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDERTag2();
        }
        return this.dertag2;
    }

    public boolean isDERTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDERTag2Dirty();
        }
        return this.dertag2DirtyFlag;
    }

    public void resetDERTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDERTag2();
            return;
        }
        this.dertag2DirtyFlag = false;
        this.dertag2 = null;
    }

    public void setDERType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDERType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dertype = string;
        this.dertypeDirtyFlag = true;
    }

    public String getDERType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDERType();
        }
        return this.dertype;
    }

    public boolean isDERTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDERTypeDirty();
        }
        return this.dertypeDirtyFlag;
    }

    public void resetDERType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDERType();
            return;
        }
        this.dertypeDirtyFlag = false;
        this.dertype = null;
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

    public void setEnableClone(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableClone(n);
            return;
        }
        this.enableclone = n;
        this.enablecloneDirtyFlag = true;
    }

    public Integer getEnableClone() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableClone();
        }
        return this.enableclone;
    }

    public boolean isEnableCloneDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableCloneDirty();
        }
        return this.enablecloneDirtyFlag;
    }

    public void resetEnableClone() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableClone();
            return;
        }
        this.enablecloneDirtyFlag = false;
        this.enableclone = null;
    }

    public void setEnaDEFieldWriteBack(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnaDEFieldWriteBack(n);
            return;
        }
        this.enadefieldwriteback = n;
        this.enadefieldwritebackDirtyFlag = true;
    }

    public Integer getEnaDEFieldWriteBack() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnaDEFieldWriteBack();
        }
        return this.enadefieldwriteback;
    }

    public boolean isEnaDEFieldWriteBackDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnaDEFieldWriteBackDirty();
        }
        return this.enadefieldwritebackDirtyFlag;
    }

    public void resetEnaDEFieldWriteBack() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnaDEFieldWriteBack();
            return;
        }
        this.enadefieldwritebackDirtyFlag = false;
        this.enadefieldwriteback = null;
    }

    public void setEnaExtRange(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnaExtRange(n);
            return;
        }
        this.enaextrange = n;
        this.enaextrangeDirtyFlag = true;
    }

    public Integer getEnaExtRange() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnaExtRange();
        }
        return this.enaextrange;
    }

    public boolean isEnaExtRangeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnaExtRangeDirty();
        }
        return this.enaextrangeDirtyFlag;
    }

    public void resetEnaExtRange() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnaExtRange();
            return;
        }
        this.enaextrangeDirtyFlag = false;
        this.enaextrange = null;
    }

    public void setEnaPDEREQ(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnaPDEREQ(n);
            return;
        }
        this.enapdereq = n;
        this.enapdereqDirtyFlag = true;
    }

    public Integer getEnaPDEREQ() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnaPDEREQ();
        }
        return this.enapdereq;
    }

    public boolean isEnaPDEREQDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnaPDEREQDirty();
        }
        return this.enapdereqDirtyFlag;
    }

    public void resetEnaPDEREQ() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnaPDEREQ();
            return;
        }
        this.enapdereqDirtyFlag = false;
        this.enapdereq = null;
    }

    public void setExportMajorModel(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExportMajorModel(n);
            return;
        }
        this.exportmajormodel = n;
        this.exportmajormodelDirtyFlag = true;
    }

    public Integer getExportMajorModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExportMajorModel();
        }
        return this.exportmajormodel;
    }

    public boolean isExportMajorModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExportMajorModelDirty();
        }
        return this.exportmajormodelDirtyFlag;
    }

    public void resetExportMajorModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExportMajorModel();
            return;
        }
        this.exportmajormodelDirtyFlag = false;
        this.exportmajormodel = null;
    }

    public void setExportModel(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExportModel(n);
            return;
        }
        this.exportmodel = n;
        this.exportmodelDirtyFlag = true;
    }

    public Integer getExportModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExportModel();
        }
        return this.exportmodel;
    }

    public boolean isExportModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExportModelDirty();
        }
        return this.exportmodelDirtyFlag;
    }

    public void resetExportModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExportModel();
            return;
        }
        this.exportmodelDirtyFlag = false;
        this.exportmodel = null;
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

    public void setExportScope2(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExportScope2(n);
            return;
        }
        this.exportscope2 = n;
        this.exportscope2DirtyFlag = true;
    }

    public Integer getExportScope2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExportScope2();
        }
        return this.exportscope2;
    }

    public boolean isExportScope2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExportScope2Dirty();
        }
        return this.exportscope2DirtyFlag;
    }

    public void resetExportScope2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExportScope2();
            return;
        }
        this.exportscope2DirtyFlag = false;
        this.exportscope2 = null;
    }

    public void setExportScope3(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExportScope3(n);
            return;
        }
        this.exportscope3 = n;
        this.exportscope3DirtyFlag = true;
    }

    public Integer getExportScope3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExportScope3();
        }
        return this.exportscope3;
    }

    public boolean isExportScope3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExportScope3Dirty();
        }
        return this.exportscope3DirtyFlag;
    }

    public void resetExportScope3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExportScope3();
            return;
        }
        this.exportscope3DirtyFlag = false;
        this.exportscope3 = null;
    }

    public void setExportScope4(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExportScope4(n);
            return;
        }
        this.exportscope4 = n;
        this.exportscope4DirtyFlag = true;
    }

    public Integer getExportScope4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExportScope4();
        }
        return this.exportscope4;
    }

    public boolean isExportScope4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExportScope4Dirty();
        }
        return this.exportscope4DirtyFlag;
    }

    public void resetExportScope4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExportScope4();
            return;
        }
        this.exportscope4DirtyFlag = false;
        this.exportscope4 = null;
    }

    public void setExportScope5(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExportScope5(n);
            return;
        }
        this.exportscope5 = n;
        this.exportscope5DirtyFlag = true;
    }

    public Integer getExportScope5() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExportScope5();
        }
        return this.exportscope5;
    }

    public boolean isExportScope5Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExportScope5Dirty();
        }
        return this.exportscope5DirtyFlag;
    }

    public void resetExportScope5() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExportScope5();
            return;
        }
        this.exportscope5DirtyFlag = false;
        this.exportscope5 = null;
    }

    public void setExportScope6(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExportScope6(n);
            return;
        }
        this.exportscope6 = n;
        this.exportscope6DirtyFlag = true;
    }

    public Integer getExportScope6() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExportScope6();
        }
        return this.exportscope6;
    }

    public boolean isExportScope6Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExportScope6Dirty();
        }
        return this.exportscope6DirtyFlag;
    }

    public void resetExportScope6() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExportScope6();
            return;
        }
        this.exportscope6DirtyFlag = false;
        this.exportscope6 = null;
    }

    public void setEXTMajorPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEXTMajorPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.extmajorpsdefid = string;
        this.extmajorpsdefidDirtyFlag = true;
    }

    public String getEXTMajorPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEXTMajorPSDEFId();
        }
        return this.extmajorpsdefid;
    }

    public boolean isEXTMajorPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEXTMajorPSDEFIdDirty();
        }
        return this.extmajorpsdefidDirtyFlag;
    }

    public void resetEXTMajorPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEXTMajorPSDEFId();
            return;
        }
        this.extmajorpsdefidDirtyFlag = false;
        this.extmajorpsdefid = null;
    }

    public void setEXTMajorPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEXTMajorPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.extmajorpsdefname = string;
        this.extmajorpsdefnameDirtyFlag = true;
    }

    public String getEXTMajorPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEXTMajorPSDEFName();
        }
        return this.extmajorpsdefname;
    }

    public boolean isEXTMajorPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEXTMajorPSDEFNameDirty();
        }
        return this.extmajorpsdefnameDirtyFlag;
    }

    public void resetEXTMajorPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEXTMajorPSDEFName();
            return;
        }
        this.extmajorpsdefnameDirtyFlag = false;
        this.extmajorpsdefname = null;
    }

    public void setEXTMinorPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEXTMinorPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.extminorpsdefid = string;
        this.extminorpsdefidDirtyFlag = true;
    }

    public String getEXTMinorPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEXTMinorPSDEFId();
        }
        return this.extminorpsdefid;
    }

    public boolean isEXTMinorPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEXTMinorPSDEFIdDirty();
        }
        return this.extminorpsdefidDirtyFlag;
    }

    public void resetEXTMinorPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEXTMinorPSDEFId();
            return;
        }
        this.extminorpsdefidDirtyFlag = false;
        this.extminorpsdefid = null;
    }

    public void setEXTMinorPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEXTMinorPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.extminorpsdefname = string;
        this.extminorpsdefnameDirtyFlag = true;
    }

    public String getEXTMinorPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEXTMinorPSDEFName();
        }
        return this.extminorpsdefname;
    }

    public boolean isEXTMinorPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEXTMinorPSDEFNameDirty();
        }
        return this.extminorpsdefnameDirtyFlag;
    }

    public void resetEXTMinorPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEXTMinorPSDEFName();
            return;
        }
        this.extminorpsdefnameDirtyFlag = false;
        this.extminorpsdefname = null;
    }

    public void setFKeyName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFKeyName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.fkeyname = string;
        this.fkeynameDirtyFlag = true;
    }

    public String getFKeyName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFKeyName();
        }
        return this.fkeyname;
    }

    public boolean isFKeyNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFKeyNameDirty();
        }
        return this.fkeynameDirtyFlag;
    }

    public void resetFKeyName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFKeyName();
            return;
        }
        this.fkeynameDirtyFlag = false;
        this.fkeyname = null;
    }

    public void setForeignKey(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setForeignKey(n);
            return;
        }
        this.foreignkey = n;
        this.foreignkeyDirtyFlag = true;
    }

    public Integer getForeignKey() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getForeignKey();
        }
        return this.foreignkey;
    }

    public boolean isForeignKeyDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isForeignKeyDirty();
        }
        return this.foreignkeyDirtyFlag;
    }

    public void resetForeignKey() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetForeignKey();
            return;
        }
        this.foreignkeyDirtyFlag = false;
        this.foreignkey = null;
    }

    public void setIgnoreDEFields(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIgnoreDEFields(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ignoredefields = string;
        this.ignoredefieldsDirtyFlag = true;
    }

    public String getIgnoreDEFields() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIgnoreDEFields();
        }
        return this.ignoredefields;
    }

    public boolean isIgnoreDEFieldsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIgnoreDEFieldsDirty();
        }
        return this.ignoredefieldsDirtyFlag;
    }

    public void resetIgnoreDEFields() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIgnoreDEFields();
            return;
        }
        this.ignoredefieldsDirtyFlag = false;
        this.ignoredefields = null;
    }

    public void setIndexValue(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIndexValue(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.indexvalue = string;
        this.indexvalueDirtyFlag = true;
    }

    public String getIndexValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIndexValue();
        }
        return this.indexvalue;
    }

    public boolean isIndexValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIndexValueDirty();
        }
        return this.indexvalueDirtyFlag;
    }

    public void resetIndexValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIndexValue();
            return;
        }
        this.indexvalueDirtyFlag = false;
        this.indexvalue = null;
    }

    public void setInheritMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInheritMode(n);
            return;
        }
        this.inheritmode = n;
        this.inheritmodeDirtyFlag = true;
    }

    public Integer getInheritMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInheritMode();
        }
        return this.inheritmode;
    }

    public boolean isInheritModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInheritModeDirty();
        }
        return this.inheritmodeDirtyFlag;
    }

    public void resetInheritMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInheritMode();
            return;
        }
        this.inheritmodeDirtyFlag = false;
        this.inheritmode = null;
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

    public void setMajorPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMajorPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.majorpsdeid = string;
        this.majorpsdeidDirtyFlag = true;
    }

    public String getMajorPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMajorPSDEId();
        }
        return this.majorpsdeid;
    }

    public boolean isMajorPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMajorPSDEIdDirty();
        }
        return this.majorpsdeidDirtyFlag;
    }

    public void resetMajorPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMajorPSDEId();
            return;
        }
        this.majorpsdeidDirtyFlag = false;
        this.majorpsdeid = null;
    }

    public void setMajorPSDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMajorPSDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.majorpsdename = string;
        this.majorpsdenameDirtyFlag = true;
    }

    public String getMajorPSDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMajorPSDEName();
        }
        return this.majorpsdename;
    }

    public boolean isMajorPSDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMajorPSDENameDirty();
        }
        return this.majorpsdenameDirtyFlag;
    }

    public void resetMajorPSDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMajorPSDEName();
            return;
        }
        this.majorpsdenameDirtyFlag = false;
        this.majorpsdename = null;
    }

    public void setMajorPSDERId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMajorPSDERId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.majorpsderid = string;
        this.majorpsderidDirtyFlag = true;
    }

    public String getMajorPSDERId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMajorPSDERId();
        }
        return this.majorpsderid;
    }

    public boolean isMajorPSDERIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMajorPSDERIdDirty();
        }
        return this.majorpsderidDirtyFlag;
    }

    public void resetMajorPSDERId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMajorPSDERId();
            return;
        }
        this.majorpsderidDirtyFlag = false;
        this.majorpsderid = null;
    }

    public void setMajorPSDERName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMajorPSDERName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.majorpsdername = string;
        this.majorpsdernameDirtyFlag = true;
    }

    public String getMajorPSDERName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMajorPSDERName();
        }
        return this.majorpsdername;
    }

    public boolean isMajorPSDERNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMajorPSDERNameDirty();
        }
        return this.majorpsdernameDirtyFlag;
    }

    public void resetMajorPSDERName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMajorPSDERName();
            return;
        }
        this.majorpsdernameDirtyFlag = false;
        this.majorpsdername = null;
    }

    public void setMasterOrderValue(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMasterOrderValue(n);
            return;
        }
        this.masterordervalue = n;
        this.masterordervalueDirtyFlag = true;
    }

    public Integer getMasterOrderValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMasterOrderValue();
        }
        return this.masterordervalue;
    }

    public boolean isMasterOrderValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMasterOrderValueDirty();
        }
        return this.masterordervalueDirtyFlag;
    }

    public void resetMasterOrderValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMasterOrderValue();
            return;
        }
        this.masterordervalueDirtyFlag = false;
        this.masterordervalue = null;
    }

    public void setMasterRS(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMasterRS(n);
            return;
        }
        this.masterrs = n;
        this.masterrsDirtyFlag = true;
    }

    public Integer getMasterRS() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMasterRS();
        }
        return this.masterrs;
    }

    public boolean isMasterRSDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMasterRSDirty();
        }
        return this.masterrsDirtyFlag;
    }

    public void resetMasterRS() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMasterRS();
            return;
        }
        this.masterrsDirtyFlag = false;
        this.masterrs = null;
    }

    public void setMDPSDEViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMDPSDEViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mdpsdeviewid = string;
        this.mdpsdeviewidDirtyFlag = true;
    }

    public String getMDPSDEViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMDPSDEViewId();
        }
        return this.mdpsdeviewid;
    }

    public boolean isMDPSDEViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMDPSDEViewIdDirty();
        }
        return this.mdpsdeviewidDirtyFlag;
    }

    public void resetMDPSDEViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMDPSDEViewId();
            return;
        }
        this.mdpsdeviewidDirtyFlag = false;
        this.mdpsdeviewid = null;
    }

    public void setMDPSDEViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMDPSDEViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mdpsdeviewname = string;
        this.mdpsdeviewnameDirtyFlag = true;
    }

    public String getMDPSDEViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMDPSDEViewName();
        }
        return this.mdpsdeviewname;
    }

    public boolean isMDPSDEViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMDPSDEViewNameDirty();
        }
        return this.mdpsdeviewnameDirtyFlag;
    }

    public void resetMDPSDEViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMDPSDEViewName();
            return;
        }
        this.mdpsdeviewnameDirtyFlag = false;
        this.mdpsdeviewname = null;
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

    public void setMinorCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinorCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.minorcodename = string;
        this.minorcodenameDirtyFlag = true;
    }

    public String getMinorCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorCodeName();
        }
        return this.minorcodename;
    }

    public boolean isMinorCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinorCodeNameDirty();
        }
        return this.minorcodenameDirtyFlag;
    }

    public void resetMinorCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinorCodeName();
            return;
        }
        this.minorcodenameDirtyFlag = false;
        this.minorcodename = null;
    }

    public void setMinorLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinorLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.minorlogicname = string;
        this.minorlogicnameDirtyFlag = true;
    }

    public String getMinorLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorLogicName();
        }
        return this.minorlogicname;
    }

    public boolean isMinorLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinorLogicNameDirty();
        }
        return this.minorlogicnameDirtyFlag;
    }

    public void resetMinorLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinorLogicName();
            return;
        }
        this.minorlogicnameDirtyFlag = false;
        this.minorlogicname = null;
    }

    public void setMinorPSDEDSId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinorPSDEDSId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.minorpsdedsid = string;
        this.minorpsdedsidDirtyFlag = true;
    }

    public String getMinorPSDEDSId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorPSDEDSId();
        }
        return this.minorpsdedsid;
    }

    public boolean isMinorPSDEDSIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinorPSDEDSIdDirty();
        }
        return this.minorpsdedsidDirtyFlag;
    }

    public void resetMinorPSDEDSId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinorPSDEDSId();
            return;
        }
        this.minorpsdedsidDirtyFlag = false;
        this.minorpsdedsid = null;
    }

    public void setMinorPSDEDSName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinorPSDEDSName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.minorpsdedsname = string;
        this.minorpsdedsnameDirtyFlag = true;
    }

    public String getMinorPSDEDSName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorPSDEDSName();
        }
        return this.minorpsdedsname;
    }

    public boolean isMinorPSDEDSNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinorPSDEDSNameDirty();
        }
        return this.minorpsdedsnameDirtyFlag;
    }

    public void resetMinorPSDEDSName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinorPSDEDSName();
            return;
        }
        this.minorpsdedsnameDirtyFlag = false;
        this.minorpsdedsname = null;
    }

    public void setMinorPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinorPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.minorpsdeid = string;
        this.minorpsdeidDirtyFlag = true;
    }

    public String getMinorPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorPSDEId();
        }
        return this.minorpsdeid;
    }

    public boolean isMinorPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinorPSDEIdDirty();
        }
        return this.minorpsdeidDirtyFlag;
    }

    public void resetMinorPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinorPSDEId();
            return;
        }
        this.minorpsdeidDirtyFlag = false;
        this.minorpsdeid = null;
    }

    public void setMinorPSDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinorPSDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.minorpsdename = string;
        this.minorpsdenameDirtyFlag = true;
    }

    public String getMinorPSDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorPSDEName();
        }
        return this.minorpsdename;
    }

    public boolean isMinorPSDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinorPSDENameDirty();
        }
        return this.minorpsdenameDirtyFlag;
    }

    public void resetMinorPSDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinorPSDEName();
            return;
        }
        this.minorpsdenameDirtyFlag = false;
        this.minorpsdename = null;
    }

    public void setMinorPSDERId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinorPSDERId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.minorpsderid = string;
        this.minorpsderidDirtyFlag = true;
    }

    public String getMinorPSDERId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorPSDERId();
        }
        return this.minorpsderid;
    }

    public boolean isMinorPSDERIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinorPSDERIdDirty();
        }
        return this.minorpsderidDirtyFlag;
    }

    public void resetMinorPSDERId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinorPSDERId();
            return;
        }
        this.minorpsderidDirtyFlag = false;
        this.minorpsderid = null;
    }

    public void setMinorPSDERName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinorPSDERName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.minorpsdername = string;
        this.minorpsdernameDirtyFlag = true;
    }

    public String getMinorPSDERName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorPSDERName();
        }
        return this.minorpsdername;
    }

    public boolean isMinorPSDERNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinorPSDERNameDirty();
        }
        return this.minorpsdernameDirtyFlag;
    }

    public void resetMinorPSDERName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinorPSDERName();
            return;
        }
        this.minorpsdernameDirtyFlag = false;
        this.minorpsdername = null;
    }

    public void setMinorServiceCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinorServiceCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.minorservicecodename = string;
        this.minorservicecodenameDirtyFlag = true;
    }

    public String getMinorServiceCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorServiceCodeName();
        }
        return this.minorservicecodename;
    }

    public boolean isMinorServiceCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinorServiceCodeNameDirty();
        }
        return this.minorservicecodenameDirtyFlag;
    }

    public void resetMinorServiceCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinorServiceCodeName();
            return;
        }
        this.minorservicecodenameDirtyFlag = false;
        this.minorservicecodename = null;
    }

    public void setMobLinkPSDEViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobLinkPSDEViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.moblinkpsdeviewid = string;
        this.moblinkpsdeviewidDirtyFlag = true;
    }

    public String getMobLinkPSDEViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobLinkPSDEViewId();
        }
        return this.moblinkpsdeviewid;
    }

    public boolean isMobLinkPSDEViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobLinkPSDEViewIdDirty();
        }
        return this.moblinkpsdeviewidDirtyFlag;
    }

    public void resetMobLinkPSDEViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobLinkPSDEViewId();
            return;
        }
        this.moblinkpsdeviewidDirtyFlag = false;
        this.moblinkpsdeviewid = null;
    }

    public void setMobLinkPSDEViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobLinkPSDEViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.moblinkpsdeviewname = string;
        this.moblinkpsdeviewnameDirtyFlag = true;
    }

    public String getMobLinkPSDEViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobLinkPSDEViewName();
        }
        return this.moblinkpsdeviewname;
    }

    public boolean isMobLinkPSDEViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobLinkPSDEViewNameDirty();
        }
        return this.moblinkpsdeviewnameDirtyFlag;
    }

    public void resetMobLinkPSDEViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobLinkPSDEViewName();
            return;
        }
        this.moblinkpsdeviewnameDirtyFlag = false;
        this.moblinkpsdeviewname = null;
    }

    public void setMobMDPSDEViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobMDPSDEViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mobmdpsdeviewid = string;
        this.mobmdpsdeviewidDirtyFlag = true;
    }

    public String getMobMDPSDEViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobMDPSDEViewId();
        }
        return this.mobmdpsdeviewid;
    }

    public boolean isMobMDPSDEViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobMDPSDEViewIdDirty();
        }
        return this.mobmdpsdeviewidDirtyFlag;
    }

    public void resetMobMDPSDEViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobMDPSDEViewId();
            return;
        }
        this.mobmdpsdeviewidDirtyFlag = false;
        this.mobmdpsdeviewid = null;
    }

    public void setMobMDPSDEViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobMDPSDEViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mobmdpsdeviewname = string;
        this.mobmdpsdeviewnameDirtyFlag = true;
    }

    public String getMobMDPSDEViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobMDPSDEViewName();
        }
        return this.mobmdpsdeviewname;
    }

    public boolean isMobMDPSDEViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobMDPSDEViewNameDirty();
        }
        return this.mobmdpsdeviewnameDirtyFlag;
    }

    public void resetMobMDPSDEViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobMDPSDEViewName();
            return;
        }
        this.mobmdpsdeviewnameDirtyFlag = false;
        this.mobmdpsdeviewname = null;
    }

    public void setMobSDPSDEViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobSDPSDEViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mobsdpsdeviewid = string;
        this.mobsdpsdeviewidDirtyFlag = true;
    }

    public String getMobSDPSDEViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobSDPSDEViewId();
        }
        return this.mobsdpsdeviewid;
    }

    public boolean isMobSDPSDEViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobSDPSDEViewIdDirty();
        }
        return this.mobsdpsdeviewidDirtyFlag;
    }

    public void resetMobSDPSDEViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobSDPSDEViewId();
            return;
        }
        this.mobsdpsdeviewidDirtyFlag = false;
        this.mobsdpsdeviewid = null;
    }

    public void setMobSDPSDEViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobSDPSDEViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mobsdpsdeviewname = string;
        this.mobsdpsdeviewnameDirtyFlag = true;
    }

    public String getMobSDPSDEViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobSDPSDEViewName();
        }
        return this.mobsdpsdeviewname;
    }

    public boolean isMobSDPSDEViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobSDPSDEViewNameDirty();
        }
        return this.mobsdpsdeviewnameDirtyFlag;
    }

    public void resetMobSDPSDEViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobSDPSDEViewName();
            return;
        }
        this.mobsdpsdeviewnameDirtyFlag = false;
        this.mobsdpsdeviewname = null;
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

    public void setPropertyMap(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPropertyMap(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.propertymap = string;
        this.propertymapDirtyFlag = true;
    }

    public String getPropertyMap() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPropertyMap();
        }
        return this.propertymap;
    }

    public boolean isPropertyMapDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPropertyMapDirty();
        }
        return this.propertymapDirtyFlag;
    }

    public void resetPropertyMap() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPropertyMap();
            return;
        }
        this.propertymapDirtyFlag = false;
        this.propertymap = null;
    }

    public void setPSDEACModeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEACModeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeacmodeid = string;
        this.psdeacmodeidDirtyFlag = true;
    }

    public String getPSDEACModeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEACModeId();
        }
        return this.psdeacmodeid;
    }

    public boolean isPSDEACModeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEACModeIdDirty();
        }
        return this.psdeacmodeidDirtyFlag;
    }

    public void resetPSDEACModeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEACModeId();
            return;
        }
        this.psdeacmodeidDirtyFlag = false;
        this.psdeacmodeid = null;
    }

    public void setPSDEACModeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEACModeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeacmodename = string;
        this.psdeacmodenameDirtyFlag = true;
    }

    public String getPSDEACModeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEACModeName();
        }
        return this.psdeacmodename;
    }

    public boolean isPSDEACModeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEACModeNameDirty();
        }
        return this.psdeacmodenameDirtyFlag;
    }

    public void resetPSDEACModeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEACModeName();
            return;
        }
        this.psdeacmodenameDirtyFlag = false;
        this.psdeacmodename = null;
    }

    public void setPSDEDataSetId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataSetId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedatasetid = string;
        this.psdedatasetidDirtyFlag = true;
    }

    public String getPSDEDataSetId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataSetId();
        }
        return this.psdedatasetid;
    }

    public boolean isPSDEDataSetIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataSetIdDirty();
        }
        return this.psdedatasetidDirtyFlag;
    }

    public void resetPSDEDataSetId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataSetId();
            return;
        }
        this.psdedatasetidDirtyFlag = false;
        this.psdedatasetid = null;
    }

    public void setPSDEDataSetName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataSetName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedatasetname = string;
        this.psdedatasetnameDirtyFlag = true;
    }

    public String getPSDEDataSetName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataSetName();
        }
        return this.psdedatasetname;
    }

    public boolean isPSDEDataSetNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataSetNameDirty();
        }
        return this.psdedatasetnameDirtyFlag;
    }

    public void resetPSDEDataSetName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataSetName();
            return;
        }
        this.psdedatasetnameDirtyFlag = false;
        this.psdedatasetname = null;
    }

    public void setPSDEDRItemsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDRItemsCnt(n);
            return;
        }
        this.psdedritemscnt = n;
        this.psdedritemscntDirtyFlag = true;
    }

    public Integer getPSDEDRItemsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDRItemsCnt();
        }
        return this.psdedritemscnt;
    }

    public boolean isPSDEDRItemsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDRItemsCntDirty();
        }
        return this.psdedritemscntDirtyFlag;
    }

    public void resetPSDEDRItemsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDRItemsCnt();
            return;
        }
        this.psdedritemscntDirtyFlag = false;
        this.psdedritemscnt = null;
    }

    public void setPSDEFGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefgroupid = string;
        this.psdefgroupidDirtyFlag = true;
    }

    public String getPSDEFGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFGroupId();
        }
        return this.psdefgroupid;
    }

    public boolean isPSDEFGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFGroupIdDirty();
        }
        return this.psdefgroupidDirtyFlag;
    }

    public void resetPSDEFGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFGroupId();
            return;
        }
        this.psdefgroupidDirtyFlag = false;
        this.psdefgroupid = null;
    }

    public void setPSDEFGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefgroupname = string;
        this.psdefgroupnameDirtyFlag = true;
    }

    public String getPSDEFGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFGroupName();
        }
        return this.psdefgroupname;
    }

    public boolean isPSDEFGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFGroupNameDirty();
        }
        return this.psdefgroupnameDirtyFlag;
    }

    public void resetPSDEFGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFGroupName();
            return;
        }
        this.psdefgroupnameDirtyFlag = false;
        this.psdefgroupname = null;
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

    public void setPSDEOPPrivsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEOPPrivsCnt(n);
            return;
        }
        this.psdeopprivscnt = n;
        this.psdeopprivscntDirtyFlag = true;
    }

    public Integer getPSDEOPPrivsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEOPPrivsCnt();
        }
        return this.psdeopprivscnt;
    }

    public boolean isPSDEOPPrivsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEOPPrivsCntDirty();
        }
        return this.psdeopprivscntDirtyFlag;
    }

    public void resetPSDEOPPrivsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEOPPrivsCnt();
            return;
        }
        this.psdeopprivscntDirtyFlag = false;
        this.psdeopprivscnt = null;
    }

    public void setPSDERDEFMapsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDERDEFMapsCnt(n);
            return;
        }
        this.psderdefmapscnt = n;
        this.psderdefmapscntDirtyFlag = true;
    }

    public Integer getPSDERDEFMapsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDERDEFMapsCnt();
        }
        return this.psderdefmapscnt;
    }

    public boolean isPSDERDEFMapsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDERDEFMapsCntDirty();
        }
        return this.psderdefmapscntDirtyFlag;
    }

    public void resetPSDERDEFMapsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDERDEFMapsCnt();
            return;
        }
        this.psderdefmapscntDirtyFlag = false;
        this.psderdefmapscnt = null;
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

    public void setRemoveActionType(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRemoveActionType(n);
            return;
        }
        this.removeactiontype = n;
        this.removeactiontypeDirtyFlag = true;
    }

    public Integer getRemoveActionType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRemoveActionType();
        }
        return this.removeactiontype;
    }

    public boolean isRemoveActionTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRemoveActionTypeDirty();
        }
        return this.removeactiontypeDirtyFlag;
    }

    public void resetRemoveActionType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRemoveActionType();
            return;
        }
        this.removeactiontypeDirtyFlag = false;
        this.removeactiontype = null;
    }

    public void setRemoveOrder(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRemoveOrder(n);
            return;
        }
        this.removeorder = n;
        this.removeorderDirtyFlag = true;
    }

    public Integer getRemoveOrder() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRemoveOrder();
        }
        return this.removeorder;
    }

    public boolean isRemoveOrderDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRemoveOrderDirty();
        }
        return this.removeorderDirtyFlag;
    }

    public void resetRemoveOrder() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRemoveOrder();
            return;
        }
        this.removeorderDirtyFlag = false;
        this.removeorder = null;
    }

    public void setRemoveRejectMsg(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRemoveRejectMsg(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.removerejectmsg = string;
        this.removerejectmsgDirtyFlag = true;
    }

    public String getRemoveRejectMsg() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRemoveRejectMsg();
        }
        return this.removerejectmsg;
    }

    public boolean isRemoveRejectMsgDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRemoveRejectMsgDirty();
        }
        return this.removerejectmsgDirtyFlag;
    }

    public void resetRemoveRejectMsg() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRemoveRejectMsg();
            return;
        }
        this.removerejectmsgDirtyFlag = false;
        this.removerejectmsg = null;
    }

    public void setRemoveRejectPSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRemoveRejectPSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.removerejectpslanresid = string;
        this.removerejectpslanresidDirtyFlag = true;
    }

    public String getRemoveRejectPSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRemoveRejectPSLanResId();
        }
        return this.removerejectpslanresid;
    }

    public boolean isRemoveRejectPSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRemoveRejectPSLanResIdDirty();
        }
        return this.removerejectpslanresidDirtyFlag;
    }

    public void resetRemoveRejectPSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRemoveRejectPSLanResId();
            return;
        }
        this.removerejectpslanresidDirtyFlag = false;
        this.removerejectpslanresid = null;
    }

    public void setRemoveRejectPSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRemoveRejectPSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.removerejectpslanresname = string;
        this.removerejectpslanresnameDirtyFlag = true;
    }

    public String getRemoveRejectPSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRemoveRejectPSLanResName();
        }
        return this.removerejectpslanresname;
    }

    public boolean isRemoveRejectPSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRemoveRejectPSLanResNameDirty();
        }
        return this.removerejectpslanresnameDirtyFlag;
    }

    public void resetRemoveRejectPSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRemoveRejectPSLanResName();
            return;
        }
        this.removerejectpslanresnameDirtyFlag = false;
        this.removerejectpslanresname = null;
    }

    public void setRSPSDEViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRSPSDEViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.rspsdeviewid = string;
        this.rspsdeviewidDirtyFlag = true;
    }

    public String getRSPSDEViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRSPSDEViewId();
        }
        return this.rspsdeviewid;
    }

    public boolean isRSPSDEViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRSPSDEViewIdDirty();
        }
        return this.rspsdeviewidDirtyFlag;
    }

    public void resetRSPSDEViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRSPSDEViewId();
            return;
        }
        this.rspsdeviewidDirtyFlag = false;
        this.rspsdeviewid = null;
    }

    public void setRSPSDEViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRSPSDEViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.rspsdeviewname = string;
        this.rspsdeviewnameDirtyFlag = true;
    }

    public String getRSPSDEViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRSPSDEViewName();
        }
        return this.rspsdeviewname;
    }

    public boolean isRSPSDEViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRSPSDEViewNameDirty();
        }
        return this.rspsdeviewnameDirtyFlag;
    }

    public void resetRSPSDEViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRSPSDEViewName();
            return;
        }
        this.rspsdeviewnameDirtyFlag = false;
        this.rspsdeviewname = null;
    }

    public void setSDPSDEViewID(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSDPSDEViewID(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sdpsdeviewid = string;
        this.sdpsdeviewidDirtyFlag = true;
    }

    public String getSDPSDEViewID() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSDPSDEViewID();
        }
        return this.sdpsdeviewid;
    }

    public boolean isSDPSDEViewIDDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSDPSDEViewIDDirty();
        }
        return this.sdpsdeviewidDirtyFlag;
    }

    public void resetSDPSDEViewID() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSDPSDEViewID();
            return;
        }
        this.sdpsdeviewidDirtyFlag = false;
        this.sdpsdeviewid = null;
    }

    public void setSDPSDEViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSDPSDEViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sdpsdeviewname = string;
        this.sdpsdeviewnameDirtyFlag = true;
    }

    public String getSDPSDEViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSDPSDEViewName();
        }
        return this.sdpsdeviewname;
    }

    public boolean isSDPSDEViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSDPSDEViewNameDirty();
        }
        return this.sdpsdeviewnameDirtyFlag;
    }

    public void resetSDPSDEViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSDPSDEViewName();
            return;
        }
        this.sdpsdeviewnameDirtyFlag = false;
        this.sdpsdeviewname = null;
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

    public void setSyncExportModel(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSyncExportModel(n);
            return;
        }
        this.syncexportmodel = n;
        this.syncexportmodelDirtyFlag = true;
    }

    public Integer getSyncExportModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSyncExportModel();
        }
        return this.syncexportmodel;
    }

    public boolean isSyncExportModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSyncExportModelDirty();
        }
        return this.syncexportmodelDirtyFlag;
    }

    public void resetSyncExportModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSyncExportModel();
            return;
        }
        this.syncexportmodelDirtyFlag = false;
        this.syncexportmodel = null;
    }

    public void setTempOrderValue(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTempOrderValue(n);
            return;
        }
        this.tempordervalue = n;
        this.tempordervalueDirtyFlag = true;
    }

    public Integer getTempOrderValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTempOrderValue();
        }
        return this.tempordervalue;
    }

    public boolean isTempOrderValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTempOrderValueDirty();
        }
        return this.tempordervalueDirtyFlag;
    }

    public void resetTempOrderValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTempOrderValue();
            return;
        }
        this.tempordervalueDirtyFlag = false;
        this.tempordervalue = null;
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

    public void setUpdatePhsicalDEField(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdatePhsicalDEField(n);
            return;
        }
        this.updatephsicaldefield = n;
        this.updatephsicaldefieldDirtyFlag = true;
    }

    public Integer getUpdatePhsicalDEField() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUpdatePhsicalDEField();
        }
        return this.updatephsicaldefield;
    }

    public boolean isUpdatePhsicalDEFieldDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUpdatePhsicalDEFieldDirty();
        }
        return this.updatephsicaldefieldDirtyFlag;
    }

    public void resetUpdatePhsicalDEField() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUpdatePhsicalDEField();
            return;
        }
        this.updatephsicaldefieldDirtyFlag = false;
        this.updatephsicaldefield = null;
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

    protected void onReset() {
        PSDERBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDERBase pSDERBase) {
        pSDERBase.resetCloneOrderValue();
        pSDERBase.resetCloneRSFields();
        pSDERBase.resetCntPSDEFId();
        pSDERBase.resetCntPSDEFName();
        pSDERBase.resetCodeName();
        pSDERBase.resetCreateDate();
        pSDERBase.resetCreateMan();
        pSDERBase.resetDEFInheritMode();
        pSDERBase.resetDERFieldLName();
        pSDERBase.resetDERFieldName();
        pSDERBase.resetDERSubType();
        pSDERBase.resetDERTag();
        pSDERBase.resetDERTag2();
        pSDERBase.resetDERType();
        pSDERBase.resetDynaModelFlag();
        pSDERBase.resetEnableClone();
        pSDERBase.resetEnaDEFieldWriteBack();
        pSDERBase.resetEnaExtRange();
        pSDERBase.resetEnaPDEREQ();
        pSDERBase.resetExportMajorModel();
        pSDERBase.resetExportModel();
        pSDERBase.resetExportScope();
        pSDERBase.resetExportScope2();
        pSDERBase.resetExportScope3();
        pSDERBase.resetExportScope4();
        pSDERBase.resetExportScope5();
        pSDERBase.resetExportScope6();
        pSDERBase.resetEXTMajorPSDEFId();
        pSDERBase.resetEXTMajorPSDEFName();
        pSDERBase.resetEXTMinorPSDEFId();
        pSDERBase.resetEXTMinorPSDEFName();
        pSDERBase.resetFKeyName();
        pSDERBase.resetForeignKey();
        pSDERBase.resetIgnoreDEFields();
        pSDERBase.resetIndexValue();
        pSDERBase.resetInheritMode();
        pSDERBase.resetLinkPSDEViewId();
        pSDERBase.resetLinkPSDEViewName();
        pSDERBase.resetLockFlag();
        pSDERBase.resetLogicName();
        pSDERBase.resetMajorPSDEId();
        pSDERBase.resetMajorPSDEName();
        pSDERBase.resetMajorPSDERId();
        pSDERBase.resetMajorPSDERName();
        pSDERBase.resetMasterOrderValue();
        pSDERBase.resetMasterRS();
        pSDERBase.resetMDPSDEViewId();
        pSDERBase.resetMDPSDEViewName();
        pSDERBase.resetMemo();
        pSDERBase.resetMinorCodeName();
        pSDERBase.resetMinorLogicName();
        pSDERBase.resetMinorPSDEDSId();
        pSDERBase.resetMinorPSDEDSName();
        pSDERBase.resetMinorPSDEId();
        pSDERBase.resetMinorPSDEName();
        pSDERBase.resetMinorPSDERId();
        pSDERBase.resetMinorPSDERName();
        pSDERBase.resetMinorServiceCodeName();
        pSDERBase.resetMobLinkPSDEViewId();
        pSDERBase.resetMobLinkPSDEViewName();
        pSDERBase.resetMobMDPSDEViewId();
        pSDERBase.resetMobMDPSDEViewName();
        pSDERBase.resetMobSDPSDEViewId();
        pSDERBase.resetMobSDPSDEViewName();
        pSDERBase.resetOrderValue();
        pSDERBase.resetPredefinedType();
        pSDERBase.resetPropertyMap();
        pSDERBase.resetPSDEACModeId();
        pSDERBase.resetPSDEACModeName();
        pSDERBase.resetPSDEDataSetId();
        pSDERBase.resetPSDEDataSetName();
        pSDERBase.resetPSDEDRItemsCnt();
        pSDERBase.resetPSDEFGroupId();
        pSDERBase.resetPSDEFGroupName();
        pSDERBase.resetPSDEFieldsCnt();
        pSDERBase.resetPSDEOPPrivsCnt();
        pSDERBase.resetPSDERDEFMapsCnt();
        pSDERBase.resetPSDERId();
        pSDERBase.resetPSDERName();
        pSDERBase.resetPSDynaInstId();
        pSDERBase.resetPSSysDynaModelId();
        pSDERBase.resetPSSysDynaModelName();
        pSDERBase.resetPSSysSFPluginId();
        pSDERBase.resetPSSysSFPluginName();
        pSDERBase.resetPSSystemId();
        pSDERBase.resetPSSystemName();
        pSDERBase.resetRemoveActionType();
        pSDERBase.resetRemoveOrder();
        pSDERBase.resetRemoveRejectMsg();
        pSDERBase.resetRemoveRejectPSLanResId();
        pSDERBase.resetRemoveRejectPSLanResName();
        pSDERBase.resetRSPSDEViewId();
        pSDERBase.resetRSPSDEViewName();
        pSDERBase.resetSDPSDEViewID();
        pSDERBase.resetSDPSDEViewName();
        pSDERBase.resetServiceCodeName();
        pSDERBase.resetSyncExportModel();
        pSDERBase.resetTempOrderValue();
        pSDERBase.resetUpdateDate();
        pSDERBase.resetUpdateMan();
        pSDERBase.resetUpdatePhsicalDEField();
        pSDERBase.resetUserCat();
        pSDERBase.resetUserParams();
        pSDERBase.resetUserTag();
        pSDERBase.resetUserTag2();
        pSDERBase.resetUserTag3();
        pSDERBase.resetUserTag4();
        pSDERBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCloneOrderValueDirty()) {
            hashMap.put(FIELD_CLONEORDERVALUE, this.getCloneOrderValue());
        }
        if (!bl || this.isCloneRSFieldsDirty()) {
            hashMap.put(FIELD_CLONERSFIELDS, this.getCloneRSFields());
        }
        if (!bl || this.isCntPSDEFIdDirty()) {
            hashMap.put(FIELD_CNTPSDEFID, this.getCntPSDEFId());
        }
        if (!bl || this.isCntPSDEFNameDirty()) {
            hashMap.put(FIELD_CNTPSDEFNAME, this.getCntPSDEFName());
        }
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDEFInheritModeDirty()) {
            hashMap.put(FIELD_DEFINHERITMODE, this.getDEFInheritMode());
        }
        if (!bl || this.isDERFieldLNameDirty()) {
            hashMap.put(FIELD_DERFIELDLNAME, this.getDERFieldLName());
        }
        if (!bl || this.isDERFieldNameDirty()) {
            hashMap.put(FIELD_DERFIELDNAME, this.getDERFieldName());
        }
        if (!bl || this.isDERSubTypeDirty()) {
            hashMap.put(FIELD_DERSUBTYPE, this.getDERSubType());
        }
        if (!bl || this.isDERTagDirty()) {
            hashMap.put(FIELD_DERTAG, this.getDERTag());
        }
        if (!bl || this.isDERTag2Dirty()) {
            hashMap.put(FIELD_DERTAG2, this.getDERTag2());
        }
        if (!bl || this.isDERTypeDirty()) {
            hashMap.put(FIELD_DERTYPE, this.getDERType());
        }
        if (!bl || this.isDynaModelFlagDirty()) {
            hashMap.put(FIELD_DYNAMODELFLAG, this.getDynaModelFlag());
        }
        if (!bl || this.isEnableCloneDirty()) {
            hashMap.put(FIELD_ENABLECLONE, this.getEnableClone());
        }
        if (!bl || this.isEnaDEFieldWriteBackDirty()) {
            hashMap.put(FIELD_ENADEFIELDWRITEBACK, this.getEnaDEFieldWriteBack());
        }
        if (!bl || this.isEnaExtRangeDirty()) {
            hashMap.put(FIELD_ENAEXTRANGE, this.getEnaExtRange());
        }
        if (!bl || this.isEnaPDEREQDirty()) {
            hashMap.put(FIELD_ENAPDEREQ, this.getEnaPDEREQ());
        }
        if (!bl || this.isExportMajorModelDirty()) {
            hashMap.put(FIELD_EXPORTMAJORMODEL, this.getExportMajorModel());
        }
        if (!bl || this.isExportModelDirty()) {
            hashMap.put(FIELD_EXPORTMODEL, this.getExportModel());
        }
        if (!bl || this.isExportScopeDirty()) {
            hashMap.put(FIELD_EXPORTSCOPE, this.getExportScope());
        }
        if (!bl || this.isExportScope2Dirty()) {
            hashMap.put(FIELD_EXPORTSCOPE2, this.getExportScope2());
        }
        if (!bl || this.isExportScope3Dirty()) {
            hashMap.put(FIELD_EXPORTSCOPE3, this.getExportScope3());
        }
        if (!bl || this.isExportScope4Dirty()) {
            hashMap.put(FIELD_EXPORTSCOPE4, this.getExportScope4());
        }
        if (!bl || this.isExportScope5Dirty()) {
            hashMap.put(FIELD_EXPORTSCOPE5, this.getExportScope5());
        }
        if (!bl || this.isExportScope6Dirty()) {
            hashMap.put(FIELD_EXPORTSCOPE6, this.getExportScope6());
        }
        if (!bl || this.isEXTMajorPSDEFIdDirty()) {
            hashMap.put(FIELD_EXTMAJORPSDEFID, this.getEXTMajorPSDEFId());
        }
        if (!bl || this.isEXTMajorPSDEFNameDirty()) {
            hashMap.put(FIELD_EXTMAJORPSDEFNAME, this.getEXTMajorPSDEFName());
        }
        if (!bl || this.isEXTMinorPSDEFIdDirty()) {
            hashMap.put(FIELD_EXTMINORPSDEFID, this.getEXTMinorPSDEFId());
        }
        if (!bl || this.isEXTMinorPSDEFNameDirty()) {
            hashMap.put(FIELD_EXTMINORPSDEFNAME, this.getEXTMinorPSDEFName());
        }
        if (!bl || this.isFKeyNameDirty()) {
            hashMap.put(FIELD_FKEYNAME, this.getFKeyName());
        }
        if (!bl || this.isForeignKeyDirty()) {
            hashMap.put(FIELD_FOREIGNKEY, this.getForeignKey());
        }
        if (!bl || this.isIgnoreDEFieldsDirty()) {
            hashMap.put(FIELD_IGNOREDEFIELDS, this.getIgnoreDEFields());
        }
        if (!bl || this.isIndexValueDirty()) {
            hashMap.put(FIELD_INDEXVALUE, this.getIndexValue());
        }
        if (!bl || this.isInheritModeDirty()) {
            hashMap.put(FIELD_INHERITMODE, this.getInheritMode());
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
        if (!bl || this.isLogicNameDirty()) {
            hashMap.put(FIELD_LOGICNAME, this.getLogicName());
        }
        if (!bl || this.isMajorPSDEIdDirty()) {
            hashMap.put(FIELD_MAJORPSDEID, this.getMajorPSDEId());
        }
        if (!bl || this.isMajorPSDENameDirty()) {
            hashMap.put(FIELD_MAJORPSDENAME, this.getMajorPSDEName());
        }
        if (!bl || this.isMajorPSDERIdDirty()) {
            hashMap.put(FIELD_MAJORPSDERID, this.getMajorPSDERId());
        }
        if (!bl || this.isMajorPSDERNameDirty()) {
            hashMap.put(FIELD_MAJORPSDERNAME, this.getMajorPSDERName());
        }
        if (!bl || this.isMasterOrderValueDirty()) {
            hashMap.put(FIELD_MASTERORDERVALUE, this.getMasterOrderValue());
        }
        if (!bl || this.isMasterRSDirty()) {
            hashMap.put(FIELD_MASTERRS, this.getMasterRS());
        }
        if (!bl || this.isMDPSDEViewIdDirty()) {
            hashMap.put(FIELD_MDPSDEVIEWID, this.getMDPSDEViewId());
        }
        if (!bl || this.isMDPSDEViewNameDirty()) {
            hashMap.put(FIELD_MDPSDEVIEWNAME, this.getMDPSDEViewName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMinorCodeNameDirty()) {
            hashMap.put(FIELD_MINORCODENAME, this.getMinorCodeName());
        }
        if (!bl || this.isMinorLogicNameDirty()) {
            hashMap.put(FIELD_MINORLOGICNAME, this.getMinorLogicName());
        }
        if (!bl || this.isMinorPSDEDSIdDirty()) {
            hashMap.put(FIELD_MINORPSDEDSID, this.getMinorPSDEDSId());
        }
        if (!bl || this.isMinorPSDEDSNameDirty()) {
            hashMap.put(FIELD_MINORPSDEDSNAME, this.getMinorPSDEDSName());
        }
        if (!bl || this.isMinorPSDEIdDirty()) {
            hashMap.put(FIELD_MINORPSDEID, this.getMinorPSDEId());
        }
        if (!bl || this.isMinorPSDENameDirty()) {
            hashMap.put(FIELD_MINORPSDENAME, this.getMinorPSDEName());
        }
        if (!bl || this.isMinorPSDERIdDirty()) {
            hashMap.put(FIELD_MINORPSDERID, this.getMinorPSDERId());
        }
        if (!bl || this.isMinorPSDERNameDirty()) {
            hashMap.put(FIELD_MINORPSDERNAME, this.getMinorPSDERName());
        }
        if (!bl || this.isMinorServiceCodeNameDirty()) {
            hashMap.put(FIELD_MINORSERVICECODENAME, this.getMinorServiceCodeName());
        }
        if (!bl || this.isMobLinkPSDEViewIdDirty()) {
            hashMap.put(FIELD_MOBLINKPSDEVIEWID, this.getMobLinkPSDEViewId());
        }
        if (!bl || this.isMobLinkPSDEViewNameDirty()) {
            hashMap.put(FIELD_MOBLINKPSDEVIEWNAME, this.getMobLinkPSDEViewName());
        }
        if (!bl || this.isMobMDPSDEViewIdDirty()) {
            hashMap.put(FIELD_MOBMDPSDEVIEWID, this.getMobMDPSDEViewId());
        }
        if (!bl || this.isMobMDPSDEViewNameDirty()) {
            hashMap.put(FIELD_MOBMDPSDEVIEWNAME, this.getMobMDPSDEViewName());
        }
        if (!bl || this.isMobSDPSDEViewIdDirty()) {
            hashMap.put(FIELD_MOBSDPSDEVIEWID, this.getMobSDPSDEViewId());
        }
        if (!bl || this.isMobSDPSDEViewNameDirty()) {
            hashMap.put(FIELD_MOBSDPSDEVIEWNAME, this.getMobSDPSDEViewName());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPredefinedTypeDirty()) {
            hashMap.put(FIELD_PREDEFINEDTYPE, this.getPredefinedType());
        }
        if (!bl || this.isPropertyMapDirty()) {
            hashMap.put(FIELD_PROPERTYMAP, this.getPropertyMap());
        }
        if (!bl || this.isPSDEACModeIdDirty()) {
            hashMap.put(FIELD_PSDEACMODEID, this.getPSDEACModeId());
        }
        if (!bl || this.isPSDEACModeNameDirty()) {
            hashMap.put(FIELD_PSDEACMODENAME, this.getPSDEACModeName());
        }
        if (!bl || this.isPSDEDataSetIdDirty()) {
            hashMap.put(FIELD_PSDEDATASETID, this.getPSDEDataSetId());
        }
        if (!bl || this.isPSDEDataSetNameDirty()) {
            hashMap.put(FIELD_PSDEDATASETNAME, this.getPSDEDataSetName());
        }
        if (!bl || this.isPSDEDRItemsCntDirty()) {
            hashMap.put(FIELD_PSDEDRITEMSCNT, this.getPSDEDRItemsCnt());
        }
        if (!bl || this.isPSDEFGroupIdDirty()) {
            hashMap.put(FIELD_PSDEFGROUPID, this.getPSDEFGroupId());
        }
        if (!bl || this.isPSDEFGroupNameDirty()) {
            hashMap.put(FIELD_PSDEFGROUPNAME, this.getPSDEFGroupName());
        }
        if (!bl || this.isPSDEFieldsCntDirty()) {
            hashMap.put(FIELD_PSDEFIELDSCNT, this.getPSDEFieldsCnt());
        }
        if (!bl || this.isPSDEOPPrivsCntDirty()) {
            hashMap.put(FIELD_PSDEOPPRIVSCNT, this.getPSDEOPPrivsCnt());
        }
        if (!bl || this.isPSDERDEFMapsCntDirty()) {
            hashMap.put(FIELD_PSDERDEFMAPSCNT, this.getPSDERDEFMapsCnt());
        }
        if (!bl || this.isPSDERIdDirty()) {
            hashMap.put(FIELD_PSDERID, this.getPSDERId());
        }
        if (!bl || this.isPSDERNameDirty()) {
            hashMap.put(FIELD_PSDERNAME, this.getPSDERName());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSSysDynaModelIdDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELID, this.getPSSysDynaModelId());
        }
        if (!bl || this.isPSSysDynaModelNameDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELNAME, this.getPSSysDynaModelName());
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
        if (!bl || this.isRemoveActionTypeDirty()) {
            hashMap.put(FIELD_REMOVEACTIONTYPE, this.getRemoveActionType());
        }
        if (!bl || this.isRemoveOrderDirty()) {
            hashMap.put(FIELD_REMOVEORDER, this.getRemoveOrder());
        }
        if (!bl || this.isRemoveRejectMsgDirty()) {
            hashMap.put(FIELD_REMOVEREJECTMSG, this.getRemoveRejectMsg());
        }
        if (!bl || this.isRemoveRejectPSLanResIdDirty()) {
            hashMap.put(FIELD_REMOVEREJECTPSLANRESID, this.getRemoveRejectPSLanResId());
        }
        if (!bl || this.isRemoveRejectPSLanResNameDirty()) {
            hashMap.put(FIELD_REMOVEREJECTPSLANRESNAME, this.getRemoveRejectPSLanResName());
        }
        if (!bl || this.isRSPSDEViewIdDirty()) {
            hashMap.put(FIELD_RSPSDEVIEWID, this.getRSPSDEViewId());
        }
        if (!bl || this.isRSPSDEViewNameDirty()) {
            hashMap.put(FIELD_RSPSDEVIEWNAME, this.getRSPSDEViewName());
        }
        if (!bl || this.isSDPSDEViewIDDirty()) {
            hashMap.put(FIELD_SDPSDEVIEWID, this.getSDPSDEViewID());
        }
        if (!bl || this.isSDPSDEViewNameDirty()) {
            hashMap.put(FIELD_SDPSDEVIEWNAME, this.getSDPSDEViewName());
        }
        if (!bl || this.isServiceCodeNameDirty()) {
            hashMap.put(FIELD_SERVICECODENAME, this.getServiceCodeName());
        }
        if (!bl || this.isSyncExportModelDirty()) {
            hashMap.put(FIELD_SYNCEXPORTMODEL, this.getSyncExportModel());
        }
        if (!bl || this.isTempOrderValueDirty()) {
            hashMap.put(FIELD_TEMPORDERVALUE, this.getTempOrderValue());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUpdatePhsicalDEFieldDirty()) {
            hashMap.put(FIELD_UPDATEPHSICALDEFIELD, this.getUpdatePhsicalDEField());
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
        return PSDERBase.get(this, n);
    }

    private static Object get(PSDERBase pSDERBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDERBase.getCloneOrderValue();
            }
            case 1: {
                return pSDERBase.getCloneRSFields();
            }
            case 2: {
                return pSDERBase.getCntPSDEFId();
            }
            case 3: {
                return pSDERBase.getCntPSDEFName();
            }
            case 4: {
                return pSDERBase.getCodeName();
            }
            case 5: {
                return pSDERBase.getCreateDate();
            }
            case 6: {
                return pSDERBase.getCreateMan();
            }
            case 7: {
                return pSDERBase.getDEFInheritMode();
            }
            case 8: {
                return pSDERBase.getDERFieldLName();
            }
            case 9: {
                return pSDERBase.getDERFieldName();
            }
            case 10: {
                return pSDERBase.getDERSubType();
            }
            case 11: {
                return pSDERBase.getDERTag();
            }
            case 12: {
                return pSDERBase.getDERTag2();
            }
            case 13: {
                return pSDERBase.getDERType();
            }
            case 14: {
                return pSDERBase.getDynaModelFlag();
            }
            case 15: {
                return pSDERBase.getEnableClone();
            }
            case 16: {
                return pSDERBase.getEnaDEFieldWriteBack();
            }
            case 17: {
                return pSDERBase.getEnaExtRange();
            }
            case 18: {
                return pSDERBase.getEnaPDEREQ();
            }
            case 19: {
                return pSDERBase.getExportMajorModel();
            }
            case 20: {
                return pSDERBase.getExportModel();
            }
            case 21: {
                return pSDERBase.getExportScope();
            }
            case 22: {
                return pSDERBase.getExportScope2();
            }
            case 23: {
                return pSDERBase.getExportScope3();
            }
            case 24: {
                return pSDERBase.getExportScope4();
            }
            case 25: {
                return pSDERBase.getExportScope5();
            }
            case 26: {
                return pSDERBase.getExportScope6();
            }
            case 27: {
                return pSDERBase.getEXTMajorPSDEFId();
            }
            case 28: {
                return pSDERBase.getEXTMajorPSDEFName();
            }
            case 29: {
                return pSDERBase.getEXTMinorPSDEFId();
            }
            case 30: {
                return pSDERBase.getEXTMinorPSDEFName();
            }
            case 31: {
                return pSDERBase.getFKeyName();
            }
            case 32: {
                return pSDERBase.getForeignKey();
            }
            case 33: {
                return pSDERBase.getIgnoreDEFields();
            }
            case 34: {
                return pSDERBase.getIndexValue();
            }
            case 35: {
                return pSDERBase.getInheritMode();
            }
            case 36: {
                return pSDERBase.getLinkPSDEViewId();
            }
            case 37: {
                return pSDERBase.getLinkPSDEViewName();
            }
            case 38: {
                return pSDERBase.getLockFlag();
            }
            case 39: {
                return pSDERBase.getLogicName();
            }
            case 40: {
                return pSDERBase.getMajorPSDEId();
            }
            case 41: {
                return pSDERBase.getMajorPSDEName();
            }
            case 42: {
                return pSDERBase.getMajorPSDERId();
            }
            case 43: {
                return pSDERBase.getMajorPSDERName();
            }
            case 44: {
                return pSDERBase.getMasterOrderValue();
            }
            case 45: {
                return pSDERBase.getMasterRS();
            }
            case 46: {
                return pSDERBase.getMDPSDEViewId();
            }
            case 47: {
                return pSDERBase.getMDPSDEViewName();
            }
            case 48: {
                return pSDERBase.getMemo();
            }
            case 49: {
                return pSDERBase.getMinorCodeName();
            }
            case 50: {
                return pSDERBase.getMinorLogicName();
            }
            case 51: {
                return pSDERBase.getMinorPSDEDSId();
            }
            case 52: {
                return pSDERBase.getMinorPSDEDSName();
            }
            case 53: {
                return pSDERBase.getMinorPSDEId();
            }
            case 54: {
                return pSDERBase.getMinorPSDEName();
            }
            case 55: {
                return pSDERBase.getMinorPSDERId();
            }
            case 56: {
                return pSDERBase.getMinorPSDERName();
            }
            case 57: {
                return pSDERBase.getMinorServiceCodeName();
            }
            case 58: {
                return pSDERBase.getMobLinkPSDEViewId();
            }
            case 59: {
                return pSDERBase.getMobLinkPSDEViewName();
            }
            case 60: {
                return pSDERBase.getMobMDPSDEViewId();
            }
            case 61: {
                return pSDERBase.getMobMDPSDEViewName();
            }
            case 62: {
                return pSDERBase.getMobSDPSDEViewId();
            }
            case 63: {
                return pSDERBase.getMobSDPSDEViewName();
            }
            case 64: {
                return pSDERBase.getOrderValue();
            }
            case 65: {
                return pSDERBase.getPredefinedType();
            }
            case 66: {
                return pSDERBase.getPropertyMap();
            }
            case 67: {
                return pSDERBase.getPSDEACModeId();
            }
            case 68: {
                return pSDERBase.getPSDEACModeName();
            }
            case 69: {
                return pSDERBase.getPSDEDataSetId();
            }
            case 70: {
                return pSDERBase.getPSDEDataSetName();
            }
            case 71: {
                return pSDERBase.getPSDEDRItemsCnt();
            }
            case 72: {
                return pSDERBase.getPSDEFGroupId();
            }
            case 73: {
                return pSDERBase.getPSDEFGroupName();
            }
            case 74: {
                return pSDERBase.getPSDEFieldsCnt();
            }
            case 75: {
                return pSDERBase.getPSDEOPPrivsCnt();
            }
            case 76: {
                return pSDERBase.getPSDERDEFMapsCnt();
            }
            case 77: {
                return pSDERBase.getPSDERId();
            }
            case 78: {
                return pSDERBase.getPSDERName();
            }
            case 79: {
                return pSDERBase.getPSDynaInstId();
            }
            case 80: {
                return pSDERBase.getPSSysDynaModelId();
            }
            case 81: {
                return pSDERBase.getPSSysDynaModelName();
            }
            case 82: {
                return pSDERBase.getPSSysSFPluginId();
            }
            case 83: {
                return pSDERBase.getPSSysSFPluginName();
            }
            case 84: {
                return pSDERBase.getPSSystemId();
            }
            case 85: {
                return pSDERBase.getPSSystemName();
            }
            case 86: {
                return pSDERBase.getRemoveActionType();
            }
            case 87: {
                return pSDERBase.getRemoveOrder();
            }
            case 88: {
                return pSDERBase.getRemoveRejectMsg();
            }
            case 89: {
                return pSDERBase.getRemoveRejectPSLanResId();
            }
            case 90: {
                return pSDERBase.getRemoveRejectPSLanResName();
            }
            case 91: {
                return pSDERBase.getRSPSDEViewId();
            }
            case 92: {
                return pSDERBase.getRSPSDEViewName();
            }
            case 93: {
                return pSDERBase.getSDPSDEViewID();
            }
            case 94: {
                return pSDERBase.getSDPSDEViewName();
            }
            case 95: {
                return pSDERBase.getServiceCodeName();
            }
            case 96: {
                return pSDERBase.getSyncExportModel();
            }
            case 97: {
                return pSDERBase.getTempOrderValue();
            }
            case 98: {
                return pSDERBase.getUpdateDate();
            }
            case 99: {
                return pSDERBase.getUpdateMan();
            }
            case 100: {
                return pSDERBase.getUpdatePhsicalDEField();
            }
            case 101: {
                return pSDERBase.getUserCat();
            }
            case 102: {
                return pSDERBase.getUserParams();
            }
            case 103: {
                return pSDERBase.getUserTag();
            }
            case 104: {
                return pSDERBase.getUserTag2();
            }
            case 105: {
                return pSDERBase.getUserTag3();
            }
            case 106: {
                return pSDERBase.getUserTag4();
            }
            case 107: {
                return pSDERBase.getValidFlag();
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
        PSDERBase.set(this, n, object);
    }

    private static void set(PSDERBase pSDERBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDERBase.setCloneOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSDERBase.setCloneRSFields(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDERBase.setCntPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDERBase.setCntPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDERBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDERBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 6: {
                pSDERBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDERBase.setDEFInheritMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSDERBase.setDERFieldLName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDERBase.setDERFieldName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDERBase.setDERSubType(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDERBase.setDERTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDERBase.setDERTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDERBase.setDERType(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDERBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSDERBase.setEnableClone(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSDERBase.setEnaDEFieldWriteBack(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 17: {
                pSDERBase.setEnaExtRange(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 18: {
                pSDERBase.setEnaPDEREQ(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 19: {
                pSDERBase.setExportMajorModel(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 20: {
                pSDERBase.setExportModel(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 21: {
                pSDERBase.setExportScope(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 22: {
                pSDERBase.setExportScope2(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 23: {
                pSDERBase.setExportScope3(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 24: {
                pSDERBase.setExportScope4(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 25: {
                pSDERBase.setExportScope5(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 26: {
                pSDERBase.setExportScope6(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 27: {
                pSDERBase.setEXTMajorPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDERBase.setEXTMajorPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDERBase.setEXTMinorPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDERBase.setEXTMinorPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDERBase.setFKeyName(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDERBase.setForeignKey(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 33: {
                pSDERBase.setIgnoreDEFields(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDERBase.setIndexValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDERBase.setInheritMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 36: {
                pSDERBase.setLinkPSDEViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSDERBase.setLinkPSDEViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDERBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 39: {
                pSDERBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSDERBase.setMajorPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSDERBase.setMajorPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSDERBase.setMajorPSDERId(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSDERBase.setMajorPSDERName(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSDERBase.setMasterOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 45: {
                pSDERBase.setMasterRS(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 46: {
                pSDERBase.setMDPSDEViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSDERBase.setMDPSDEViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSDERBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSDERBase.setMinorCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSDERBase.setMinorLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSDERBase.setMinorPSDEDSId(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSDERBase.setMinorPSDEDSName(DataObject.getStringValue((Object)object));
                return;
            }
            case 53: {
                pSDERBase.setMinorPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 54: {
                pSDERBase.setMinorPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 55: {
                pSDERBase.setMinorPSDERId(DataObject.getStringValue((Object)object));
                return;
            }
            case 56: {
                pSDERBase.setMinorPSDERName(DataObject.getStringValue((Object)object));
                return;
            }
            case 57: {
                pSDERBase.setMinorServiceCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 58: {
                pSDERBase.setMobLinkPSDEViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 59: {
                pSDERBase.setMobLinkPSDEViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 60: {
                pSDERBase.setMobMDPSDEViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 61: {
                pSDERBase.setMobMDPSDEViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 62: {
                pSDERBase.setMobSDPSDEViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 63: {
                pSDERBase.setMobSDPSDEViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 64: {
                pSDERBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 65: {
                pSDERBase.setPredefinedType(DataObject.getStringValue((Object)object));
                return;
            }
            case 66: {
                pSDERBase.setPropertyMap(DataObject.getStringValue((Object)object));
                return;
            }
            case 67: {
                pSDERBase.setPSDEACModeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 68: {
                pSDERBase.setPSDEACModeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 69: {
                pSDERBase.setPSDEDataSetId(DataObject.getStringValue((Object)object));
                return;
            }
            case 70: {
                pSDERBase.setPSDEDataSetName(DataObject.getStringValue((Object)object));
                return;
            }
            case 71: {
                pSDERBase.setPSDEDRItemsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 72: {
                pSDERBase.setPSDEFGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 73: {
                pSDERBase.setPSDEFGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 74: {
                pSDERBase.setPSDEFieldsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 75: {
                pSDERBase.setPSDEOPPrivsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 76: {
                pSDERBase.setPSDERDEFMapsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 77: {
                pSDERBase.setPSDERId(DataObject.getStringValue((Object)object));
                return;
            }
            case 78: {
                pSDERBase.setPSDERName(DataObject.getStringValue((Object)object));
                return;
            }
            case 79: {
                pSDERBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 80: {
                pSDERBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 81: {
                pSDERBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 82: {
                pSDERBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 83: {
                pSDERBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 84: {
                pSDERBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 85: {
                pSDERBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 86: {
                pSDERBase.setRemoveActionType(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 87: {
                pSDERBase.setRemoveOrder(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 88: {
                pSDERBase.setRemoveRejectMsg(DataObject.getStringValue((Object)object));
                return;
            }
            case 89: {
                pSDERBase.setRemoveRejectPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 90: {
                pSDERBase.setRemoveRejectPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 91: {
                pSDERBase.setRSPSDEViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 92: {
                pSDERBase.setRSPSDEViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 93: {
                pSDERBase.setSDPSDEViewID(DataObject.getStringValue((Object)object));
                return;
            }
            case 94: {
                pSDERBase.setSDPSDEViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 95: {
                pSDERBase.setServiceCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 96: {
                pSDERBase.setSyncExportModel(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 97: {
                pSDERBase.setTempOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 98: {
                pSDERBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 99: {
                pSDERBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 100: {
                pSDERBase.setUpdatePhsicalDEField(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 101: {
                pSDERBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 102: {
                pSDERBase.setUserParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 103: {
                pSDERBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 104: {
                pSDERBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 105: {
                pSDERBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 106: {
                pSDERBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 107: {
                pSDERBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDERBase.isNull(this, n);
    }

    private static boolean isNull(PSDERBase pSDERBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDERBase.getCloneOrderValue() == null;
            }
            case 1: {
                return pSDERBase.getCloneRSFields() == null;
            }
            case 2: {
                return pSDERBase.getCntPSDEFId() == null;
            }
            case 3: {
                return pSDERBase.getCntPSDEFName() == null;
            }
            case 4: {
                return pSDERBase.getCodeName() == null;
            }
            case 5: {
                return pSDERBase.getCreateDate() == null;
            }
            case 6: {
                return pSDERBase.getCreateMan() == null;
            }
            case 7: {
                return pSDERBase.getDEFInheritMode() == null;
            }
            case 8: {
                return pSDERBase.getDERFieldLName() == null;
            }
            case 9: {
                return pSDERBase.getDERFieldName() == null;
            }
            case 10: {
                return pSDERBase.getDERSubType() == null;
            }
            case 11: {
                return pSDERBase.getDERTag() == null;
            }
            case 12: {
                return pSDERBase.getDERTag2() == null;
            }
            case 13: {
                return pSDERBase.getDERType() == null;
            }
            case 14: {
                return pSDERBase.getDynaModelFlag() == null;
            }
            case 15: {
                return pSDERBase.getEnableClone() == null;
            }
            case 16: {
                return pSDERBase.getEnaDEFieldWriteBack() == null;
            }
            case 17: {
                return pSDERBase.getEnaExtRange() == null;
            }
            case 18: {
                return pSDERBase.getEnaPDEREQ() == null;
            }
            case 19: {
                return pSDERBase.getExportMajorModel() == null;
            }
            case 20: {
                return pSDERBase.getExportModel() == null;
            }
            case 21: {
                return pSDERBase.getExportScope() == null;
            }
            case 22: {
                return pSDERBase.getExportScope2() == null;
            }
            case 23: {
                return pSDERBase.getExportScope3() == null;
            }
            case 24: {
                return pSDERBase.getExportScope4() == null;
            }
            case 25: {
                return pSDERBase.getExportScope5() == null;
            }
            case 26: {
                return pSDERBase.getExportScope6() == null;
            }
            case 27: {
                return pSDERBase.getEXTMajorPSDEFId() == null;
            }
            case 28: {
                return pSDERBase.getEXTMajorPSDEFName() == null;
            }
            case 29: {
                return pSDERBase.getEXTMinorPSDEFId() == null;
            }
            case 30: {
                return pSDERBase.getEXTMinorPSDEFName() == null;
            }
            case 31: {
                return pSDERBase.getFKeyName() == null;
            }
            case 32: {
                return pSDERBase.getForeignKey() == null;
            }
            case 33: {
                return pSDERBase.getIgnoreDEFields() == null;
            }
            case 34: {
                return pSDERBase.getIndexValue() == null;
            }
            case 35: {
                return pSDERBase.getInheritMode() == null;
            }
            case 36: {
                return pSDERBase.getLinkPSDEViewId() == null;
            }
            case 37: {
                return pSDERBase.getLinkPSDEViewName() == null;
            }
            case 38: {
                return pSDERBase.getLockFlag() == null;
            }
            case 39: {
                return pSDERBase.getLogicName() == null;
            }
            case 40: {
                return pSDERBase.getMajorPSDEId() == null;
            }
            case 41: {
                return pSDERBase.getMajorPSDEName() == null;
            }
            case 42: {
                return pSDERBase.getMajorPSDERId() == null;
            }
            case 43: {
                return pSDERBase.getMajorPSDERName() == null;
            }
            case 44: {
                return pSDERBase.getMasterOrderValue() == null;
            }
            case 45: {
                return pSDERBase.getMasterRS() == null;
            }
            case 46: {
                return pSDERBase.getMDPSDEViewId() == null;
            }
            case 47: {
                return pSDERBase.getMDPSDEViewName() == null;
            }
            case 48: {
                return pSDERBase.getMemo() == null;
            }
            case 49: {
                return pSDERBase.getMinorCodeName() == null;
            }
            case 50: {
                return pSDERBase.getMinorLogicName() == null;
            }
            case 51: {
                return pSDERBase.getMinorPSDEDSId() == null;
            }
            case 52: {
                return pSDERBase.getMinorPSDEDSName() == null;
            }
            case 53: {
                return pSDERBase.getMinorPSDEId() == null;
            }
            case 54: {
                return pSDERBase.getMinorPSDEName() == null;
            }
            case 55: {
                return pSDERBase.getMinorPSDERId() == null;
            }
            case 56: {
                return pSDERBase.getMinorPSDERName() == null;
            }
            case 57: {
                return pSDERBase.getMinorServiceCodeName() == null;
            }
            case 58: {
                return pSDERBase.getMobLinkPSDEViewId() == null;
            }
            case 59: {
                return pSDERBase.getMobLinkPSDEViewName() == null;
            }
            case 60: {
                return pSDERBase.getMobMDPSDEViewId() == null;
            }
            case 61: {
                return pSDERBase.getMobMDPSDEViewName() == null;
            }
            case 62: {
                return pSDERBase.getMobSDPSDEViewId() == null;
            }
            case 63: {
                return pSDERBase.getMobSDPSDEViewName() == null;
            }
            case 64: {
                return pSDERBase.getOrderValue() == null;
            }
            case 65: {
                return pSDERBase.getPredefinedType() == null;
            }
            case 66: {
                return pSDERBase.getPropertyMap() == null;
            }
            case 67: {
                return pSDERBase.getPSDEACModeId() == null;
            }
            case 68: {
                return pSDERBase.getPSDEACModeName() == null;
            }
            case 69: {
                return pSDERBase.getPSDEDataSetId() == null;
            }
            case 70: {
                return pSDERBase.getPSDEDataSetName() == null;
            }
            case 71: {
                return pSDERBase.getPSDEDRItemsCnt() == null;
            }
            case 72: {
                return pSDERBase.getPSDEFGroupId() == null;
            }
            case 73: {
                return pSDERBase.getPSDEFGroupName() == null;
            }
            case 74: {
                return pSDERBase.getPSDEFieldsCnt() == null;
            }
            case 75: {
                return pSDERBase.getPSDEOPPrivsCnt() == null;
            }
            case 76: {
                return pSDERBase.getPSDERDEFMapsCnt() == null;
            }
            case 77: {
                return pSDERBase.getPSDERId() == null;
            }
            case 78: {
                return pSDERBase.getPSDERName() == null;
            }
            case 79: {
                return pSDERBase.getPSDynaInstId() == null;
            }
            case 80: {
                return pSDERBase.getPSSysDynaModelId() == null;
            }
            case 81: {
                return pSDERBase.getPSSysDynaModelName() == null;
            }
            case 82: {
                return pSDERBase.getPSSysSFPluginId() == null;
            }
            case 83: {
                return pSDERBase.getPSSysSFPluginName() == null;
            }
            case 84: {
                return pSDERBase.getPSSystemId() == null;
            }
            case 85: {
                return pSDERBase.getPSSystemName() == null;
            }
            case 86: {
                return pSDERBase.getRemoveActionType() == null;
            }
            case 87: {
                return pSDERBase.getRemoveOrder() == null;
            }
            case 88: {
                return pSDERBase.getRemoveRejectMsg() == null;
            }
            case 89: {
                return pSDERBase.getRemoveRejectPSLanResId() == null;
            }
            case 90: {
                return pSDERBase.getRemoveRejectPSLanResName() == null;
            }
            case 91: {
                return pSDERBase.getRSPSDEViewId() == null;
            }
            case 92: {
                return pSDERBase.getRSPSDEViewName() == null;
            }
            case 93: {
                return pSDERBase.getSDPSDEViewID() == null;
            }
            case 94: {
                return pSDERBase.getSDPSDEViewName() == null;
            }
            case 95: {
                return pSDERBase.getServiceCodeName() == null;
            }
            case 96: {
                return pSDERBase.getSyncExportModel() == null;
            }
            case 97: {
                return pSDERBase.getTempOrderValue() == null;
            }
            case 98: {
                return pSDERBase.getUpdateDate() == null;
            }
            case 99: {
                return pSDERBase.getUpdateMan() == null;
            }
            case 100: {
                return pSDERBase.getUpdatePhsicalDEField() == null;
            }
            case 101: {
                return pSDERBase.getUserCat() == null;
            }
            case 102: {
                return pSDERBase.getUserParams() == null;
            }
            case 103: {
                return pSDERBase.getUserTag() == null;
            }
            case 104: {
                return pSDERBase.getUserTag2() == null;
            }
            case 105: {
                return pSDERBase.getUserTag3() == null;
            }
            case 106: {
                return pSDERBase.getUserTag4() == null;
            }
            case 107: {
                return pSDERBase.getValidFlag() == null;
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
        return PSDERBase.contains(this, n);
    }

    private static boolean contains(PSDERBase pSDERBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDERBase.isCloneOrderValueDirty();
            }
            case 1: {
                return pSDERBase.isCloneRSFieldsDirty();
            }
            case 2: {
                return pSDERBase.isCntPSDEFIdDirty();
            }
            case 3: {
                return pSDERBase.isCntPSDEFNameDirty();
            }
            case 4: {
                return pSDERBase.isCodeNameDirty();
            }
            case 5: {
                return pSDERBase.isCreateDateDirty();
            }
            case 6: {
                return pSDERBase.isCreateManDirty();
            }
            case 7: {
                return pSDERBase.isDEFInheritModeDirty();
            }
            case 8: {
                return pSDERBase.isDERFieldLNameDirty();
            }
            case 9: {
                return pSDERBase.isDERFieldNameDirty();
            }
            case 10: {
                return pSDERBase.isDERSubTypeDirty();
            }
            case 11: {
                return pSDERBase.isDERTagDirty();
            }
            case 12: {
                return pSDERBase.isDERTag2Dirty();
            }
            case 13: {
                return pSDERBase.isDERTypeDirty();
            }
            case 14: {
                return pSDERBase.isDynaModelFlagDirty();
            }
            case 15: {
                return pSDERBase.isEnableCloneDirty();
            }
            case 16: {
                return pSDERBase.isEnaDEFieldWriteBackDirty();
            }
            case 17: {
                return pSDERBase.isEnaExtRangeDirty();
            }
            case 18: {
                return pSDERBase.isEnaPDEREQDirty();
            }
            case 19: {
                return pSDERBase.isExportMajorModelDirty();
            }
            case 20: {
                return pSDERBase.isExportModelDirty();
            }
            case 21: {
                return pSDERBase.isExportScopeDirty();
            }
            case 22: {
                return pSDERBase.isExportScope2Dirty();
            }
            case 23: {
                return pSDERBase.isExportScope3Dirty();
            }
            case 24: {
                return pSDERBase.isExportScope4Dirty();
            }
            case 25: {
                return pSDERBase.isExportScope5Dirty();
            }
            case 26: {
                return pSDERBase.isExportScope6Dirty();
            }
            case 27: {
                return pSDERBase.isEXTMajorPSDEFIdDirty();
            }
            case 28: {
                return pSDERBase.isEXTMajorPSDEFNameDirty();
            }
            case 29: {
                return pSDERBase.isEXTMinorPSDEFIdDirty();
            }
            case 30: {
                return pSDERBase.isEXTMinorPSDEFNameDirty();
            }
            case 31: {
                return pSDERBase.isFKeyNameDirty();
            }
            case 32: {
                return pSDERBase.isForeignKeyDirty();
            }
            case 33: {
                return pSDERBase.isIgnoreDEFieldsDirty();
            }
            case 34: {
                return pSDERBase.isIndexValueDirty();
            }
            case 35: {
                return pSDERBase.isInheritModeDirty();
            }
            case 36: {
                return pSDERBase.isLinkPSDEViewIdDirty();
            }
            case 37: {
                return pSDERBase.isLinkPSDEViewNameDirty();
            }
            case 38: {
                return pSDERBase.isLockFlagDirty();
            }
            case 39: {
                return pSDERBase.isLogicNameDirty();
            }
            case 40: {
                return pSDERBase.isMajorPSDEIdDirty();
            }
            case 41: {
                return pSDERBase.isMajorPSDENameDirty();
            }
            case 42: {
                return pSDERBase.isMajorPSDERIdDirty();
            }
            case 43: {
                return pSDERBase.isMajorPSDERNameDirty();
            }
            case 44: {
                return pSDERBase.isMasterOrderValueDirty();
            }
            case 45: {
                return pSDERBase.isMasterRSDirty();
            }
            case 46: {
                return pSDERBase.isMDPSDEViewIdDirty();
            }
            case 47: {
                return pSDERBase.isMDPSDEViewNameDirty();
            }
            case 48: {
                return pSDERBase.isMemoDirty();
            }
            case 49: {
                return pSDERBase.isMinorCodeNameDirty();
            }
            case 50: {
                return pSDERBase.isMinorLogicNameDirty();
            }
            case 51: {
                return pSDERBase.isMinorPSDEDSIdDirty();
            }
            case 52: {
                return pSDERBase.isMinorPSDEDSNameDirty();
            }
            case 53: {
                return pSDERBase.isMinorPSDEIdDirty();
            }
            case 54: {
                return pSDERBase.isMinorPSDENameDirty();
            }
            case 55: {
                return pSDERBase.isMinorPSDERIdDirty();
            }
            case 56: {
                return pSDERBase.isMinorPSDERNameDirty();
            }
            case 57: {
                return pSDERBase.isMinorServiceCodeNameDirty();
            }
            case 58: {
                return pSDERBase.isMobLinkPSDEViewIdDirty();
            }
            case 59: {
                return pSDERBase.isMobLinkPSDEViewNameDirty();
            }
            case 60: {
                return pSDERBase.isMobMDPSDEViewIdDirty();
            }
            case 61: {
                return pSDERBase.isMobMDPSDEViewNameDirty();
            }
            case 62: {
                return pSDERBase.isMobSDPSDEViewIdDirty();
            }
            case 63: {
                return pSDERBase.isMobSDPSDEViewNameDirty();
            }
            case 64: {
                return pSDERBase.isOrderValueDirty();
            }
            case 65: {
                return pSDERBase.isPredefinedTypeDirty();
            }
            case 66: {
                return pSDERBase.isPropertyMapDirty();
            }
            case 67: {
                return pSDERBase.isPSDEACModeIdDirty();
            }
            case 68: {
                return pSDERBase.isPSDEACModeNameDirty();
            }
            case 69: {
                return pSDERBase.isPSDEDataSetIdDirty();
            }
            case 70: {
                return pSDERBase.isPSDEDataSetNameDirty();
            }
            case 71: {
                return pSDERBase.isPSDEDRItemsCntDirty();
            }
            case 72: {
                return pSDERBase.isPSDEFGroupIdDirty();
            }
            case 73: {
                return pSDERBase.isPSDEFGroupNameDirty();
            }
            case 74: {
                return pSDERBase.isPSDEFieldsCntDirty();
            }
            case 75: {
                return pSDERBase.isPSDEOPPrivsCntDirty();
            }
            case 76: {
                return pSDERBase.isPSDERDEFMapsCntDirty();
            }
            case 77: {
                return pSDERBase.isPSDERIdDirty();
            }
            case 78: {
                return pSDERBase.isPSDERNameDirty();
            }
            case 79: {
                return pSDERBase.isPSDynaInstIdDirty();
            }
            case 80: {
                return pSDERBase.isPSSysDynaModelIdDirty();
            }
            case 81: {
                return pSDERBase.isPSSysDynaModelNameDirty();
            }
            case 82: {
                return pSDERBase.isPSSysSFPluginIdDirty();
            }
            case 83: {
                return pSDERBase.isPSSysSFPluginNameDirty();
            }
            case 84: {
                return pSDERBase.isPSSystemIdDirty();
            }
            case 85: {
                return pSDERBase.isPSSystemNameDirty();
            }
            case 86: {
                return pSDERBase.isRemoveActionTypeDirty();
            }
            case 87: {
                return pSDERBase.isRemoveOrderDirty();
            }
            case 88: {
                return pSDERBase.isRemoveRejectMsgDirty();
            }
            case 89: {
                return pSDERBase.isRemoveRejectPSLanResIdDirty();
            }
            case 90: {
                return pSDERBase.isRemoveRejectPSLanResNameDirty();
            }
            case 91: {
                return pSDERBase.isRSPSDEViewIdDirty();
            }
            case 92: {
                return pSDERBase.isRSPSDEViewNameDirty();
            }
            case 93: {
                return pSDERBase.isSDPSDEViewIDDirty();
            }
            case 94: {
                return pSDERBase.isSDPSDEViewNameDirty();
            }
            case 95: {
                return pSDERBase.isServiceCodeNameDirty();
            }
            case 96: {
                return pSDERBase.isSyncExportModelDirty();
            }
            case 97: {
                return pSDERBase.isTempOrderValueDirty();
            }
            case 98: {
                return pSDERBase.isUpdateDateDirty();
            }
            case 99: {
                return pSDERBase.isUpdateManDirty();
            }
            case 100: {
                return pSDERBase.isUpdatePhsicalDEFieldDirty();
            }
            case 101: {
                return pSDERBase.isUserCatDirty();
            }
            case 102: {
                return pSDERBase.isUserParamsDirty();
            }
            case 103: {
                return pSDERBase.isUserTagDirty();
            }
            case 104: {
                return pSDERBase.isUserTag2Dirty();
            }
            case 105: {
                return pSDERBase.isUserTag3Dirty();
            }
            case 106: {
                return pSDERBase.isUserTag4Dirty();
            }
            case 107: {
                return pSDERBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDERBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDERBase pSDERBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDERBase.getCloneOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cloneordervalue", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getCloneOrderValue()), (boolean)false);
        }
        if (bl || pSDERBase.getCloneRSFields() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"clonersfields", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getCloneRSFields()), (boolean)false);
        }
        if (bl || pSDERBase.getCntPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cntpsdefid", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getCntPSDEFId()), (boolean)false);
        }
        if (bl || pSDERBase.getCntPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cntpsdefname", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getCntPSDEFName()), (boolean)false);
        }
        if (bl || pSDERBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDERBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDERBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDERBase.getDEFInheritMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"definheritmode", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getDEFInheritMode()), (boolean)false);
        }
        if (bl || pSDERBase.getDERFieldLName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"derfieldlname", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getDERFieldLName()), (boolean)false);
        }
        if (bl || pSDERBase.getDERFieldName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"derfieldname", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getDERFieldName()), (boolean)false);
        }
        if (bl || pSDERBase.getDERSubType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dersubtype", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getDERSubType()), (boolean)false);
        }
        if (bl || pSDERBase.getDERTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dertag", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getDERTag()), (boolean)false);
        }
        if (bl || pSDERBase.getDERTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dertag2", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getDERTag2()), (boolean)false);
        }
        if (bl || pSDERBase.getDERType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dertype", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getDERType()), (boolean)false);
        }
        if (bl || pSDERBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSDERBase.getEnableClone() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableclone", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getEnableClone()), (boolean)false);
        }
        if (bl || pSDERBase.getEnaDEFieldWriteBack() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enadefieldwriteback", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getEnaDEFieldWriteBack()), (boolean)false);
        }
        if (bl || pSDERBase.getEnaExtRange() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enaextrange", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getEnaExtRange()), (boolean)false);
        }
        if (bl || pSDERBase.getEnaPDEREQ() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enapdereq", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getEnaPDEREQ()), (boolean)false);
        }
        if (bl || pSDERBase.getExportMajorModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"exportmajormodel", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getExportMajorModel()), (boolean)false);
        }
        if (bl || pSDERBase.getExportModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"exportmodel", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getExportModel()), (boolean)false);
        }
        if (bl || pSDERBase.getExportScope() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"exportscope", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getExportScope()), (boolean)false);
        }
        if (bl || pSDERBase.getExportScope2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"exportscope2", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getExportScope2()), (boolean)false);
        }
        if (bl || pSDERBase.getExportScope3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"exportscope3", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getExportScope3()), (boolean)false);
        }
        if (bl || pSDERBase.getExportScope4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"exportscope4", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getExportScope4()), (boolean)false);
        }
        if (bl || pSDERBase.getExportScope5() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"exportscope5", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getExportScope5()), (boolean)false);
        }
        if (bl || pSDERBase.getExportScope6() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"exportscope6", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getExportScope6()), (boolean)false);
        }
        if (bl || pSDERBase.getEXTMajorPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"extmajorpsdefid", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getEXTMajorPSDEFId()), (boolean)false);
        }
        if (bl || pSDERBase.getEXTMajorPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"extmajorpsdefname", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getEXTMajorPSDEFName()), (boolean)false);
        }
        if (bl || pSDERBase.getEXTMinorPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"extminorpsdefid", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getEXTMinorPSDEFId()), (boolean)false);
        }
        if (bl || pSDERBase.getEXTMinorPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"extminorpsdefname", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getEXTMinorPSDEFName()), (boolean)false);
        }
        if (bl || pSDERBase.getFKeyName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fkeyname", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getFKeyName()), (boolean)false);
        }
        if (bl || pSDERBase.getForeignKey() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"foreignkey", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getForeignKey()), (boolean)false);
        }
        if (bl || pSDERBase.getIgnoreDEFields() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ignoredefields", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getIgnoreDEFields()), (boolean)false);
        }
        if (bl || pSDERBase.getIndexValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"indexvalue", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getIndexValue()), (boolean)false);
        }
        if (bl || pSDERBase.getInheritMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"inheritmode", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getInheritMode()), (boolean)false);
        }
        if (bl || pSDERBase.getLinkPSDEViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"linkpsdeviewid", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getLinkPSDEViewId()), (boolean)false);
        }
        if (bl || pSDERBase.getLinkPSDEViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"linkpsdeviewname", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getLinkPSDEViewName()), (boolean)false);
        }
        if (bl || pSDERBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSDERBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getLogicName()), (boolean)false);
        }
        if (bl || pSDERBase.getMajorPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"majorpsdeid", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getMajorPSDEId()), (boolean)false);
        }
        if (bl || pSDERBase.getMajorPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"majorpsdename", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getMajorPSDEName()), (boolean)false);
        }
        if (bl || pSDERBase.getMajorPSDERId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"majorpsderid", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getMajorPSDERId()), (boolean)false);
        }
        if (bl || pSDERBase.getMajorPSDERName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"majorpsdername", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getMajorPSDERName()), (boolean)false);
        }
        if (bl || pSDERBase.getMasterOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"masterordervalue", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getMasterOrderValue()), (boolean)false);
        }
        if (bl || pSDERBase.getMasterRS() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"masterrs", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getMasterRS()), (boolean)false);
        }
        if (bl || pSDERBase.getMDPSDEViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mdpsdeviewid", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getMDPSDEViewId()), (boolean)false);
        }
        if (bl || pSDERBase.getMDPSDEViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mdpsdeviewname", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getMDPSDEViewName()), (boolean)false);
        }
        if (bl || pSDERBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getMemo()), (boolean)false);
        }
        if (bl || pSDERBase.getMinorCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minorcodename", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getMinorCodeName()), (boolean)false);
        }
        if (bl || pSDERBase.getMinorLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minorlogicname", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getMinorLogicName()), (boolean)false);
        }
        if (bl || pSDERBase.getMinorPSDEDSId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minorpsdedsid", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getMinorPSDEDSId()), (boolean)false);
        }
        if (bl || pSDERBase.getMinorPSDEDSName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minorpsdedsname", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getMinorPSDEDSName()), (boolean)false);
        }
        if (bl || pSDERBase.getMinorPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minorpsdeid", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getMinorPSDEId()), (boolean)false);
        }
        if (bl || pSDERBase.getMinorPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minorpsdename", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getMinorPSDEName()), (boolean)false);
        }
        if (bl || pSDERBase.getMinorPSDERId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minorpsderid", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getMinorPSDERId()), (boolean)false);
        }
        if (bl || pSDERBase.getMinorPSDERName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minorpsdername", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getMinorPSDERName()), (boolean)false);
        }
        if (bl || pSDERBase.getMinorServiceCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minorservicecodename", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getMinorServiceCodeName()), (boolean)false);
        }
        if (bl || pSDERBase.getMobLinkPSDEViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"moblinkpsdeviewid", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getMobLinkPSDEViewId()), (boolean)false);
        }
        if (bl || pSDERBase.getMobLinkPSDEViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"moblinkpsdeviewname", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getMobLinkPSDEViewName()), (boolean)false);
        }
        if (bl || pSDERBase.getMobMDPSDEViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobmdpsdeviewid", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getMobMDPSDEViewId()), (boolean)false);
        }
        if (bl || pSDERBase.getMobMDPSDEViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobmdpsdeviewname", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getMobMDPSDEViewName()), (boolean)false);
        }
        if (bl || pSDERBase.getMobSDPSDEViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobsdpsdeviewid", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getMobSDPSDEViewId()), (boolean)false);
        }
        if (bl || pSDERBase.getMobSDPSDEViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobsdpsdeviewname", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getMobSDPSDEViewName()), (boolean)false);
        }
        if (bl || pSDERBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDERBase.getPredefinedType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"predefinedtype", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getPredefinedType()), (boolean)false);
        }
        if (bl || pSDERBase.getPropertyMap() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"propertymap", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getPropertyMap()), (boolean)false);
        }
        if (bl || pSDERBase.getPSDEACModeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeacmodeid", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getPSDEACModeId()), (boolean)false);
        }
        if (bl || pSDERBase.getPSDEACModeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeacmodename", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getPSDEACModeName()), (boolean)false);
        }
        if (bl || pSDERBase.getPSDEDataSetId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedatasetid", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getPSDEDataSetId()), (boolean)false);
        }
        if (bl || pSDERBase.getPSDEDataSetName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedatasetname", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getPSDEDataSetName()), (boolean)false);
        }
        if (bl || pSDERBase.getPSDEDRItemsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedritemscnt", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getPSDEDRItemsCnt()), (boolean)false);
        }
        if (bl || pSDERBase.getPSDEFGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefgroupid", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getPSDEFGroupId()), (boolean)false);
        }
        if (bl || pSDERBase.getPSDEFGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefgroupname", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getPSDEFGroupName()), (boolean)false);
        }
        if (bl || pSDERBase.getPSDEFieldsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefieldscnt", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getPSDEFieldsCnt()), (boolean)false);
        }
        if (bl || pSDERBase.getPSDEOPPrivsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeopprivscnt", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getPSDEOPPrivsCnt()), (boolean)false);
        }
        if (bl || pSDERBase.getPSDERDEFMapsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psderdefmapscnt", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getPSDERDEFMapsCnt()), (boolean)false);
        }
        if (bl || pSDERBase.getPSDERId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psderid", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getPSDERId()), (boolean)false);
        }
        if (bl || pSDERBase.getPSDERName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdername", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getPSDERName()), (boolean)false);
        }
        if (bl || pSDERBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSDERBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSDERBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSDERBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSDERBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSDERBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSDERBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSDERBase.getRemoveActionType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"removeactiontype", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getRemoveActionType()), (boolean)false);
        }
        if (bl || pSDERBase.getRemoveOrder() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"removeorder", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getRemoveOrder()), (boolean)false);
        }
        if (bl || pSDERBase.getRemoveRejectMsg() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"removerejectmsg", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getRemoveRejectMsg()), (boolean)false);
        }
        if (bl || pSDERBase.getRemoveRejectPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"removerejectpslanresid", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getRemoveRejectPSLanResId()), (boolean)false);
        }
        if (bl || pSDERBase.getRemoveRejectPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"removerejectpslanresname", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getRemoveRejectPSLanResName()), (boolean)false);
        }
        if (bl || pSDERBase.getRSPSDEViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rspsdeviewid", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getRSPSDEViewId()), (boolean)false);
        }
        if (bl || pSDERBase.getRSPSDEViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rspsdeviewname", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getRSPSDEViewName()), (boolean)false);
        }
        if (bl || pSDERBase.getSDPSDEViewID() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sdpsdeviewid", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getSDPSDEViewID()), (boolean)false);
        }
        if (bl || pSDERBase.getSDPSDEViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sdpsdeviewname", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getSDPSDEViewName()), (boolean)false);
        }
        if (bl || pSDERBase.getServiceCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"servicecodename", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getServiceCodeName()), (boolean)false);
        }
        if (bl || pSDERBase.getSyncExportModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"syncexportmodel", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getSyncExportModel()), (boolean)false);
        }
        if (bl || pSDERBase.getTempOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tempordervalue", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getTempOrderValue()), (boolean)false);
        }
        if (bl || pSDERBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDERBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDERBase.getUpdatePhsicalDEField() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatephysicaldefield", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getUpdatePhsicalDEField()), (boolean)false);
        }
        if (bl || pSDERBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDERBase.getUserParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userparams", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getUserParams()), (boolean)false);
        }
        if (bl || pSDERBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDERBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDERBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDERBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDERBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDERBase.getJSONValue((Object)pSDERBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDERBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDERBase pSDERBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDERBase.getCloneOrderValue() != null) {
            object = pSDERBase.getCloneOrderValue();
            xmlNode.setAttribute(FIELD_CLONEORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDERBase.getCloneRSFields() != null) {
            object = pSDERBase.getCloneRSFields();
            xmlNode.setAttribute(FIELD_CLONERSFIELDS, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getCntPSDEFId() != null) {
            object = pSDERBase.getCntPSDEFId();
            xmlNode.setAttribute(FIELD_CNTPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getCntPSDEFName() != null) {
            object = pSDERBase.getCntPSDEFName();
            xmlNode.setAttribute(FIELD_CNTPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getCodeName() != null) {
            object = pSDERBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getCreateDate() != null) {
            object = pSDERBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDERBase.getCreateMan() != null) {
            object = pSDERBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getDEFInheritMode() != null) {
            object = pSDERBase.getDEFInheritMode();
            xmlNode.setAttribute(FIELD_DEFINHERITMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDERBase.getDERFieldLName() != null) {
            object = pSDERBase.getDERFieldLName();
            xmlNode.setAttribute(FIELD_DERFIELDLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getDERFieldName() != null) {
            object = pSDERBase.getDERFieldName();
            xmlNode.setAttribute(FIELD_DERFIELDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getDERSubType() != null) {
            object = pSDERBase.getDERSubType();
            xmlNode.setAttribute(FIELD_DERSUBTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getDERTag() != null) {
            object = pSDERBase.getDERTag();
            xmlNode.setAttribute(FIELD_DERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getDERTag2() != null) {
            object = pSDERBase.getDERTag2();
            xmlNode.setAttribute(FIELD_DERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getDERType() != null) {
            object = pSDERBase.getDERType();
            xmlNode.setAttribute(FIELD_DERTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getDynaModelFlag() != null) {
            object = pSDERBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDERBase.getEnableClone() != null) {
            object = pSDERBase.getEnableClone();
            xmlNode.setAttribute(FIELD_ENABLECLONE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDERBase.getEnaDEFieldWriteBack() != null) {
            object = pSDERBase.getEnaDEFieldWriteBack();
            xmlNode.setAttribute(FIELD_ENADEFIELDWRITEBACK, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDERBase.getEnaExtRange() != null) {
            object = pSDERBase.getEnaExtRange();
            xmlNode.setAttribute(FIELD_ENAEXTRANGE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDERBase.getEnaPDEREQ() != null) {
            object = pSDERBase.getEnaPDEREQ();
            xmlNode.setAttribute(FIELD_ENAPDEREQ, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDERBase.getExportMajorModel() != null) {
            object = pSDERBase.getExportMajorModel();
            xmlNode.setAttribute(FIELD_EXPORTMAJORMODEL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDERBase.getExportModel() != null) {
            object = pSDERBase.getExportModel();
            xmlNode.setAttribute(FIELD_EXPORTMODEL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDERBase.getExportScope() != null) {
            object = pSDERBase.getExportScope();
            xmlNode.setAttribute(FIELD_EXPORTSCOPE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDERBase.getExportScope2() != null) {
            object = pSDERBase.getExportScope2();
            xmlNode.setAttribute(FIELD_EXPORTSCOPE2, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDERBase.getExportScope3() != null) {
            object = pSDERBase.getExportScope3();
            xmlNode.setAttribute(FIELD_EXPORTSCOPE3, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDERBase.getExportScope4() != null) {
            object = pSDERBase.getExportScope4();
            xmlNode.setAttribute(FIELD_EXPORTSCOPE4, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDERBase.getExportScope5() != null) {
            object = pSDERBase.getExportScope5();
            xmlNode.setAttribute(FIELD_EXPORTSCOPE5, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDERBase.getExportScope6() != null) {
            object = pSDERBase.getExportScope6();
            xmlNode.setAttribute(FIELD_EXPORTSCOPE6, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDERBase.getEXTMajorPSDEFId() != null) {
            object = pSDERBase.getEXTMajorPSDEFId();
            xmlNode.setAttribute(FIELD_EXTMAJORPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getEXTMajorPSDEFName() != null) {
            object = pSDERBase.getEXTMajorPSDEFName();
            xmlNode.setAttribute(FIELD_EXTMAJORPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getEXTMinorPSDEFId() != null) {
            object = pSDERBase.getEXTMinorPSDEFId();
            xmlNode.setAttribute(FIELD_EXTMINORPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getEXTMinorPSDEFName() != null) {
            object = pSDERBase.getEXTMinorPSDEFName();
            xmlNode.setAttribute(FIELD_EXTMINORPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getFKeyName() != null) {
            object = pSDERBase.getFKeyName();
            xmlNode.setAttribute(FIELD_FKEYNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getForeignKey() != null) {
            object = pSDERBase.getForeignKey();
            xmlNode.setAttribute(FIELD_FOREIGNKEY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDERBase.getIgnoreDEFields() != null) {
            object = pSDERBase.getIgnoreDEFields();
            xmlNode.setAttribute(FIELD_IGNOREDEFIELDS, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getIndexValue() != null) {
            object = pSDERBase.getIndexValue();
            xmlNode.setAttribute(FIELD_INDEXVALUE, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getInheritMode() != null) {
            object = pSDERBase.getInheritMode();
            xmlNode.setAttribute(FIELD_INHERITMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDERBase.getLinkPSDEViewId() != null) {
            object = pSDERBase.getLinkPSDEViewId();
            xmlNode.setAttribute(FIELD_LINKPSDEVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getLinkPSDEViewName() != null) {
            object = pSDERBase.getLinkPSDEViewName();
            xmlNode.setAttribute(FIELD_LINKPSDEVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getLockFlag() != null) {
            object = pSDERBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDERBase.getLogicName() != null) {
            object = pSDERBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getMajorPSDEId() != null) {
            object = pSDERBase.getMajorPSDEId();
            xmlNode.setAttribute(FIELD_MAJORPSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getMajorPSDEName() != null) {
            object = pSDERBase.getMajorPSDEName();
            xmlNode.setAttribute(FIELD_MAJORPSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getMajorPSDERId() != null) {
            object = pSDERBase.getMajorPSDERId();
            xmlNode.setAttribute(FIELD_MAJORPSDERID, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getMajorPSDERName() != null) {
            object = pSDERBase.getMajorPSDERName();
            xmlNode.setAttribute(FIELD_MAJORPSDERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getMasterOrderValue() != null) {
            object = pSDERBase.getMasterOrderValue();
            xmlNode.setAttribute(FIELD_MASTERORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDERBase.getMasterRS() != null) {
            object = pSDERBase.getMasterRS();
            xmlNode.setAttribute(FIELD_MASTERRS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDERBase.getMDPSDEViewId() != null) {
            object = pSDERBase.getMDPSDEViewId();
            xmlNode.setAttribute(FIELD_MDPSDEVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getMDPSDEViewName() != null) {
            object = pSDERBase.getMDPSDEViewName();
            xmlNode.setAttribute(FIELD_MDPSDEVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getMemo() != null) {
            object = pSDERBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getMinorCodeName() != null) {
            object = pSDERBase.getMinorCodeName();
            xmlNode.setAttribute(FIELD_MINORCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getMinorLogicName() != null) {
            object = pSDERBase.getMinorLogicName();
            xmlNode.setAttribute(FIELD_MINORLOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getMinorPSDEDSId() != null) {
            object = pSDERBase.getMinorPSDEDSId();
            xmlNode.setAttribute(FIELD_MINORPSDEDSID, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getMinorPSDEDSName() != null) {
            object = pSDERBase.getMinorPSDEDSName();
            xmlNode.setAttribute(FIELD_MINORPSDEDSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getMinorPSDEId() != null) {
            object = pSDERBase.getMinorPSDEId();
            xmlNode.setAttribute(FIELD_MINORPSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getMinorPSDEName() != null) {
            object = pSDERBase.getMinorPSDEName();
            xmlNode.setAttribute(FIELD_MINORPSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getMinorPSDERId() != null) {
            object = pSDERBase.getMinorPSDERId();
            xmlNode.setAttribute(FIELD_MINORPSDERID, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getMinorPSDERName() != null) {
            object = pSDERBase.getMinorPSDERName();
            xmlNode.setAttribute(FIELD_MINORPSDERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getMinorServiceCodeName() != null) {
            object = pSDERBase.getMinorServiceCodeName();
            xmlNode.setAttribute(FIELD_MINORSERVICECODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getMobLinkPSDEViewId() != null) {
            object = pSDERBase.getMobLinkPSDEViewId();
            xmlNode.setAttribute(FIELD_MOBLINKPSDEVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getMobLinkPSDEViewName() != null) {
            object = pSDERBase.getMobLinkPSDEViewName();
            xmlNode.setAttribute(FIELD_MOBLINKPSDEVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getMobMDPSDEViewId() != null) {
            object = pSDERBase.getMobMDPSDEViewId();
            xmlNode.setAttribute(FIELD_MOBMDPSDEVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getMobMDPSDEViewName() != null) {
            object = pSDERBase.getMobMDPSDEViewName();
            xmlNode.setAttribute(FIELD_MOBMDPSDEVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getMobSDPSDEViewId() != null) {
            object = pSDERBase.getMobSDPSDEViewId();
            xmlNode.setAttribute(FIELD_MOBSDPSDEVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getMobSDPSDEViewName() != null) {
            object = pSDERBase.getMobSDPSDEViewName();
            xmlNode.setAttribute(FIELD_MOBSDPSDEVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getOrderValue() != null) {
            object = pSDERBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDERBase.getPredefinedType() != null) {
            object = pSDERBase.getPredefinedType();
            xmlNode.setAttribute(FIELD_PREDEFINEDTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getPropertyMap() != null) {
            object = pSDERBase.getPropertyMap();
            xmlNode.setAttribute(FIELD_PROPERTYMAP, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getPSDEACModeId() != null) {
            object = pSDERBase.getPSDEACModeId();
            xmlNode.setAttribute(FIELD_PSDEACMODEID, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getPSDEACModeName() != null) {
            object = pSDERBase.getPSDEACModeName();
            xmlNode.setAttribute(FIELD_PSDEACMODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getPSDEDataSetId() != null) {
            object = pSDERBase.getPSDEDataSetId();
            xmlNode.setAttribute(FIELD_PSDEDATASETID, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getPSDEDataSetName() != null) {
            object = pSDERBase.getPSDEDataSetName();
            xmlNode.setAttribute(FIELD_PSDEDATASETNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getPSDEDRItemsCnt() != null) {
            object = pSDERBase.getPSDEDRItemsCnt();
            xmlNode.setAttribute(FIELD_PSDEDRITEMSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDERBase.getPSDEFGroupId() != null) {
            object = pSDERBase.getPSDEFGroupId();
            xmlNode.setAttribute(FIELD_PSDEFGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getPSDEFGroupName() != null) {
            object = pSDERBase.getPSDEFGroupName();
            xmlNode.setAttribute(FIELD_PSDEFGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getPSDEFieldsCnt() != null) {
            object = pSDERBase.getPSDEFieldsCnt();
            xmlNode.setAttribute(FIELD_PSDEFIELDSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDERBase.getPSDEOPPrivsCnt() != null) {
            object = pSDERBase.getPSDEOPPrivsCnt();
            xmlNode.setAttribute(FIELD_PSDEOPPRIVSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDERBase.getPSDERDEFMapsCnt() != null) {
            object = pSDERBase.getPSDERDEFMapsCnt();
            xmlNode.setAttribute(FIELD_PSDERDEFMAPSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDERBase.getPSDERId() != null) {
            object = pSDERBase.getPSDERId();
            xmlNode.setAttribute(FIELD_PSDERID, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getPSDERName() != null) {
            object = pSDERBase.getPSDERName();
            xmlNode.setAttribute(FIELD_PSDERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getPSDynaInstId() != null) {
            object = pSDERBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getPSSysDynaModelId() != null) {
            object = pSDERBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getPSSysDynaModelName() != null) {
            object = pSDERBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getPSSysSFPluginId() != null) {
            object = pSDERBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getPSSysSFPluginName() != null) {
            object = pSDERBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getPSSystemId() != null) {
            object = pSDERBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getPSSystemName() != null) {
            object = pSDERBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getRemoveActionType() != null) {
            object = pSDERBase.getRemoveActionType();
            xmlNode.setAttribute(FIELD_REMOVEACTIONTYPE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDERBase.getRemoveOrder() != null) {
            object = pSDERBase.getRemoveOrder();
            xmlNode.setAttribute(FIELD_REMOVEORDER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDERBase.getRemoveRejectMsg() != null) {
            object = pSDERBase.getRemoveRejectMsg();
            xmlNode.setAttribute(FIELD_REMOVEREJECTMSG, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getRemoveRejectPSLanResId() != null) {
            object = pSDERBase.getRemoveRejectPSLanResId();
            xmlNode.setAttribute(FIELD_REMOVEREJECTPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getRemoveRejectPSLanResName() != null) {
            object = pSDERBase.getRemoveRejectPSLanResName();
            xmlNode.setAttribute(FIELD_REMOVEREJECTPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getRSPSDEViewId() != null) {
            object = pSDERBase.getRSPSDEViewId();
            xmlNode.setAttribute(FIELD_RSPSDEVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getRSPSDEViewName() != null) {
            object = pSDERBase.getRSPSDEViewName();
            xmlNode.setAttribute(FIELD_RSPSDEVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getSDPSDEViewID() != null) {
            object = pSDERBase.getSDPSDEViewID();
            xmlNode.setAttribute(FIELD_SDPSDEVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getSDPSDEViewName() != null) {
            object = pSDERBase.getSDPSDEViewName();
            xmlNode.setAttribute(FIELD_SDPSDEVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getServiceCodeName() != null) {
            object = pSDERBase.getServiceCodeName();
            xmlNode.setAttribute(FIELD_SERVICECODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getSyncExportModel() != null) {
            object = pSDERBase.getSyncExportModel();
            xmlNode.setAttribute(FIELD_SYNCEXPORTMODEL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDERBase.getTempOrderValue() != null) {
            object = pSDERBase.getTempOrderValue();
            xmlNode.setAttribute(FIELD_TEMPORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDERBase.getUpdateDate() != null) {
            object = pSDERBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDERBase.getUpdateMan() != null) {
            object = pSDERBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getUpdatePhsicalDEField() != null) {
            object = pSDERBase.getUpdatePhsicalDEField();
            xmlNode.setAttribute("UPDATEPHSICALDEFIELD", object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDERBase.getUserCat() != null) {
            object = pSDERBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getUserParams() != null) {
            object = pSDERBase.getUserParams();
            xmlNode.setAttribute(FIELD_USERPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getUserTag() != null) {
            object = pSDERBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getUserTag2() != null) {
            object = pSDERBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getUserTag3() != null) {
            object = pSDERBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getUserTag4() != null) {
            object = pSDERBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDERBase.getValidFlag() != null) {
            object = pSDERBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDERBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDERBase pSDERBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDERBase.isCloneOrderValueDirty() && (bl || pSDERBase.getCloneOrderValue() != null)) {
            iDataObject.set(FIELD_CLONEORDERVALUE, (Object)pSDERBase.getCloneOrderValue());
        }
        if (pSDERBase.isCloneRSFieldsDirty() && (bl || pSDERBase.getCloneRSFields() != null)) {
            iDataObject.set(FIELD_CLONERSFIELDS, (Object)pSDERBase.getCloneRSFields());
        }
        if (pSDERBase.isCntPSDEFIdDirty() && (bl || pSDERBase.getCntPSDEFId() != null)) {
            iDataObject.set(FIELD_CNTPSDEFID, (Object)pSDERBase.getCntPSDEFId());
        }
        if (pSDERBase.isCntPSDEFNameDirty() && (bl || pSDERBase.getCntPSDEFName() != null)) {
            iDataObject.set(FIELD_CNTPSDEFNAME, (Object)pSDERBase.getCntPSDEFName());
        }
        if (pSDERBase.isCodeNameDirty() && (bl || pSDERBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDERBase.getCodeName());
        }
        if (pSDERBase.isCreateDateDirty() && (bl || pSDERBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDERBase.getCreateDate());
        }
        if (pSDERBase.isCreateManDirty() && (bl || pSDERBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDERBase.getCreateMan());
        }
        if (pSDERBase.isDEFInheritModeDirty() && (bl || pSDERBase.getDEFInheritMode() != null)) {
            iDataObject.set(FIELD_DEFINHERITMODE, (Object)pSDERBase.getDEFInheritMode());
        }
        if (pSDERBase.isDERFieldLNameDirty() && (bl || pSDERBase.getDERFieldLName() != null)) {
            iDataObject.set(FIELD_DERFIELDLNAME, (Object)pSDERBase.getDERFieldLName());
        }
        if (pSDERBase.isDERFieldNameDirty() && (bl || pSDERBase.getDERFieldName() != null)) {
            iDataObject.set(FIELD_DERFIELDNAME, (Object)pSDERBase.getDERFieldName());
        }
        if (pSDERBase.isDERSubTypeDirty() && (bl || pSDERBase.getDERSubType() != null)) {
            iDataObject.set(FIELD_DERSUBTYPE, (Object)pSDERBase.getDERSubType());
        }
        if (pSDERBase.isDERTagDirty() && (bl || pSDERBase.getDERTag() != null)) {
            iDataObject.set(FIELD_DERTAG, (Object)pSDERBase.getDERTag());
        }
        if (pSDERBase.isDERTag2Dirty() && (bl || pSDERBase.getDERTag2() != null)) {
            iDataObject.set(FIELD_DERTAG2, (Object)pSDERBase.getDERTag2());
        }
        if (pSDERBase.isDERTypeDirty() && (bl || pSDERBase.getDERType() != null)) {
            iDataObject.set(FIELD_DERTYPE, (Object)pSDERBase.getDERType());
        }
        if (pSDERBase.isDynaModelFlagDirty() && (bl || pSDERBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSDERBase.getDynaModelFlag());
        }
        if (pSDERBase.isEnableCloneDirty() && (bl || pSDERBase.getEnableClone() != null)) {
            iDataObject.set(FIELD_ENABLECLONE, (Object)pSDERBase.getEnableClone());
        }
        if (pSDERBase.isEnaDEFieldWriteBackDirty() && (bl || pSDERBase.getEnaDEFieldWriteBack() != null)) {
            iDataObject.set(FIELD_ENADEFIELDWRITEBACK, (Object)pSDERBase.getEnaDEFieldWriteBack());
        }
        if (pSDERBase.isEnaExtRangeDirty() && (bl || pSDERBase.getEnaExtRange() != null)) {
            iDataObject.set(FIELD_ENAEXTRANGE, (Object)pSDERBase.getEnaExtRange());
        }
        if (pSDERBase.isEnaPDEREQDirty() && (bl || pSDERBase.getEnaPDEREQ() != null)) {
            iDataObject.set(FIELD_ENAPDEREQ, (Object)pSDERBase.getEnaPDEREQ());
        }
        if (pSDERBase.isExportMajorModelDirty() && (bl || pSDERBase.getExportMajorModel() != null)) {
            iDataObject.set(FIELD_EXPORTMAJORMODEL, (Object)pSDERBase.getExportMajorModel());
        }
        if (pSDERBase.isExportModelDirty() && (bl || pSDERBase.getExportModel() != null)) {
            iDataObject.set(FIELD_EXPORTMODEL, (Object)pSDERBase.getExportModel());
        }
        if (pSDERBase.isExportScopeDirty() && (bl || pSDERBase.getExportScope() != null)) {
            iDataObject.set(FIELD_EXPORTSCOPE, (Object)pSDERBase.getExportScope());
        }
        if (pSDERBase.isExportScope2Dirty() && (bl || pSDERBase.getExportScope2() != null)) {
            iDataObject.set(FIELD_EXPORTSCOPE2, (Object)pSDERBase.getExportScope2());
        }
        if (pSDERBase.isExportScope3Dirty() && (bl || pSDERBase.getExportScope3() != null)) {
            iDataObject.set(FIELD_EXPORTSCOPE3, (Object)pSDERBase.getExportScope3());
        }
        if (pSDERBase.isExportScope4Dirty() && (bl || pSDERBase.getExportScope4() != null)) {
            iDataObject.set(FIELD_EXPORTSCOPE4, (Object)pSDERBase.getExportScope4());
        }
        if (pSDERBase.isExportScope5Dirty() && (bl || pSDERBase.getExportScope5() != null)) {
            iDataObject.set(FIELD_EXPORTSCOPE5, (Object)pSDERBase.getExportScope5());
        }
        if (pSDERBase.isExportScope6Dirty() && (bl || pSDERBase.getExportScope6() != null)) {
            iDataObject.set(FIELD_EXPORTSCOPE6, (Object)pSDERBase.getExportScope6());
        }
        if (pSDERBase.isEXTMajorPSDEFIdDirty() && (bl || pSDERBase.getEXTMajorPSDEFId() != null)) {
            iDataObject.set(FIELD_EXTMAJORPSDEFID, (Object)pSDERBase.getEXTMajorPSDEFId());
        }
        if (pSDERBase.isEXTMajorPSDEFNameDirty() && (bl || pSDERBase.getEXTMajorPSDEFName() != null)) {
            iDataObject.set(FIELD_EXTMAJORPSDEFNAME, (Object)pSDERBase.getEXTMajorPSDEFName());
        }
        if (pSDERBase.isEXTMinorPSDEFIdDirty() && (bl || pSDERBase.getEXTMinorPSDEFId() != null)) {
            iDataObject.set(FIELD_EXTMINORPSDEFID, (Object)pSDERBase.getEXTMinorPSDEFId());
        }
        if (pSDERBase.isEXTMinorPSDEFNameDirty() && (bl || pSDERBase.getEXTMinorPSDEFName() != null)) {
            iDataObject.set(FIELD_EXTMINORPSDEFNAME, (Object)pSDERBase.getEXTMinorPSDEFName());
        }
        if (pSDERBase.isFKeyNameDirty() && (bl || pSDERBase.getFKeyName() != null)) {
            iDataObject.set(FIELD_FKEYNAME, (Object)pSDERBase.getFKeyName());
        }
        if (pSDERBase.isForeignKeyDirty() && (bl || pSDERBase.getForeignKey() != null)) {
            iDataObject.set(FIELD_FOREIGNKEY, (Object)pSDERBase.getForeignKey());
        }
        if (pSDERBase.isIgnoreDEFieldsDirty() && (bl || pSDERBase.getIgnoreDEFields() != null)) {
            iDataObject.set(FIELD_IGNOREDEFIELDS, (Object)pSDERBase.getIgnoreDEFields());
        }
        if (pSDERBase.isIndexValueDirty() && (bl || pSDERBase.getIndexValue() != null)) {
            iDataObject.set(FIELD_INDEXVALUE, (Object)pSDERBase.getIndexValue());
        }
        if (pSDERBase.isInheritModeDirty() && (bl || pSDERBase.getInheritMode() != null)) {
            iDataObject.set(FIELD_INHERITMODE, (Object)pSDERBase.getInheritMode());
        }
        if (pSDERBase.isLinkPSDEViewIdDirty() && (bl || pSDERBase.getLinkPSDEViewId() != null)) {
            iDataObject.set(FIELD_LINKPSDEVIEWID, (Object)pSDERBase.getLinkPSDEViewId());
        }
        if (pSDERBase.isLinkPSDEViewNameDirty() && (bl || pSDERBase.getLinkPSDEViewName() != null)) {
            iDataObject.set(FIELD_LINKPSDEVIEWNAME, (Object)pSDERBase.getLinkPSDEViewName());
        }
        if (pSDERBase.isLockFlagDirty() && (bl || pSDERBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSDERBase.getLockFlag());
        }
        if (pSDERBase.isLogicNameDirty() && (bl || pSDERBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSDERBase.getLogicName());
        }
        if (pSDERBase.isMajorPSDEIdDirty() && (bl || pSDERBase.getMajorPSDEId() != null)) {
            iDataObject.set(FIELD_MAJORPSDEID, (Object)pSDERBase.getMajorPSDEId());
        }
        if (pSDERBase.isMajorPSDENameDirty() && (bl || pSDERBase.getMajorPSDEName() != null)) {
            iDataObject.set(FIELD_MAJORPSDENAME, (Object)pSDERBase.getMajorPSDEName());
        }
        if (pSDERBase.isMajorPSDERIdDirty() && (bl || pSDERBase.getMajorPSDERId() != null)) {
            iDataObject.set(FIELD_MAJORPSDERID, (Object)pSDERBase.getMajorPSDERId());
        }
        if (pSDERBase.isMajorPSDERNameDirty() && (bl || pSDERBase.getMajorPSDERName() != null)) {
            iDataObject.set(FIELD_MAJORPSDERNAME, (Object)pSDERBase.getMajorPSDERName());
        }
        if (pSDERBase.isMasterOrderValueDirty() && (bl || pSDERBase.getMasterOrderValue() != null)) {
            iDataObject.set(FIELD_MASTERORDERVALUE, (Object)pSDERBase.getMasterOrderValue());
        }
        if (pSDERBase.isMasterRSDirty() && (bl || pSDERBase.getMasterRS() != null)) {
            iDataObject.set(FIELD_MASTERRS, (Object)pSDERBase.getMasterRS());
        }
        if (pSDERBase.isMDPSDEViewIdDirty() && (bl || pSDERBase.getMDPSDEViewId() != null)) {
            iDataObject.set(FIELD_MDPSDEVIEWID, (Object)pSDERBase.getMDPSDEViewId());
        }
        if (pSDERBase.isMDPSDEViewNameDirty() && (bl || pSDERBase.getMDPSDEViewName() != null)) {
            iDataObject.set(FIELD_MDPSDEVIEWNAME, (Object)pSDERBase.getMDPSDEViewName());
        }
        if (pSDERBase.isMemoDirty() && (bl || pSDERBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDERBase.getMemo());
        }
        if (pSDERBase.isMinorCodeNameDirty() && (bl || pSDERBase.getMinorCodeName() != null)) {
            iDataObject.set(FIELD_MINORCODENAME, (Object)pSDERBase.getMinorCodeName());
        }
        if (pSDERBase.isMinorLogicNameDirty() && (bl || pSDERBase.getMinorLogicName() != null)) {
            iDataObject.set(FIELD_MINORLOGICNAME, (Object)pSDERBase.getMinorLogicName());
        }
        if (pSDERBase.isMinorPSDEDSIdDirty() && (bl || pSDERBase.getMinorPSDEDSId() != null)) {
            iDataObject.set(FIELD_MINORPSDEDSID, (Object)pSDERBase.getMinorPSDEDSId());
        }
        if (pSDERBase.isMinorPSDEDSNameDirty() && (bl || pSDERBase.getMinorPSDEDSName() != null)) {
            iDataObject.set(FIELD_MINORPSDEDSNAME, (Object)pSDERBase.getMinorPSDEDSName());
        }
        if (pSDERBase.isMinorPSDEIdDirty() && (bl || pSDERBase.getMinorPSDEId() != null)) {
            iDataObject.set(FIELD_MINORPSDEID, (Object)pSDERBase.getMinorPSDEId());
        }
        if (pSDERBase.isMinorPSDENameDirty() && (bl || pSDERBase.getMinorPSDEName() != null)) {
            iDataObject.set(FIELD_MINORPSDENAME, (Object)pSDERBase.getMinorPSDEName());
        }
        if (pSDERBase.isMinorPSDERIdDirty() && (bl || pSDERBase.getMinorPSDERId() != null)) {
            iDataObject.set(FIELD_MINORPSDERID, (Object)pSDERBase.getMinorPSDERId());
        }
        if (pSDERBase.isMinorPSDERNameDirty() && (bl || pSDERBase.getMinorPSDERName() != null)) {
            iDataObject.set(FIELD_MINORPSDERNAME, (Object)pSDERBase.getMinorPSDERName());
        }
        if (pSDERBase.isMinorServiceCodeNameDirty() && (bl || pSDERBase.getMinorServiceCodeName() != null)) {
            iDataObject.set(FIELD_MINORSERVICECODENAME, (Object)pSDERBase.getMinorServiceCodeName());
        }
        if (pSDERBase.isMobLinkPSDEViewIdDirty() && (bl || pSDERBase.getMobLinkPSDEViewId() != null)) {
            iDataObject.set(FIELD_MOBLINKPSDEVIEWID, (Object)pSDERBase.getMobLinkPSDEViewId());
        }
        if (pSDERBase.isMobLinkPSDEViewNameDirty() && (bl || pSDERBase.getMobLinkPSDEViewName() != null)) {
            iDataObject.set(FIELD_MOBLINKPSDEVIEWNAME, (Object)pSDERBase.getMobLinkPSDEViewName());
        }
        if (pSDERBase.isMobMDPSDEViewIdDirty() && (bl || pSDERBase.getMobMDPSDEViewId() != null)) {
            iDataObject.set(FIELD_MOBMDPSDEVIEWID, (Object)pSDERBase.getMobMDPSDEViewId());
        }
        if (pSDERBase.isMobMDPSDEViewNameDirty() && (bl || pSDERBase.getMobMDPSDEViewName() != null)) {
            iDataObject.set(FIELD_MOBMDPSDEVIEWNAME, (Object)pSDERBase.getMobMDPSDEViewName());
        }
        if (pSDERBase.isMobSDPSDEViewIdDirty() && (bl || pSDERBase.getMobSDPSDEViewId() != null)) {
            iDataObject.set(FIELD_MOBSDPSDEVIEWID, (Object)pSDERBase.getMobSDPSDEViewId());
        }
        if (pSDERBase.isMobSDPSDEViewNameDirty() && (bl || pSDERBase.getMobSDPSDEViewName() != null)) {
            iDataObject.set(FIELD_MOBSDPSDEVIEWNAME, (Object)pSDERBase.getMobSDPSDEViewName());
        }
        if (pSDERBase.isOrderValueDirty() && (bl || pSDERBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDERBase.getOrderValue());
        }
        if (pSDERBase.isPredefinedTypeDirty() && (bl || pSDERBase.getPredefinedType() != null)) {
            iDataObject.set(FIELD_PREDEFINEDTYPE, (Object)pSDERBase.getPredefinedType());
        }
        if (pSDERBase.isPropertyMapDirty() && (bl || pSDERBase.getPropertyMap() != null)) {
            iDataObject.set(FIELD_PROPERTYMAP, (Object)pSDERBase.getPropertyMap());
        }
        if (pSDERBase.isPSDEACModeIdDirty() && (bl || pSDERBase.getPSDEACModeId() != null)) {
            iDataObject.set(FIELD_PSDEACMODEID, (Object)pSDERBase.getPSDEACModeId());
        }
        if (pSDERBase.isPSDEACModeNameDirty() && (bl || pSDERBase.getPSDEACModeName() != null)) {
            iDataObject.set(FIELD_PSDEACMODENAME, (Object)pSDERBase.getPSDEACModeName());
        }
        if (pSDERBase.isPSDEDataSetIdDirty() && (bl || pSDERBase.getPSDEDataSetId() != null)) {
            iDataObject.set(FIELD_PSDEDATASETID, (Object)pSDERBase.getPSDEDataSetId());
        }
        if (pSDERBase.isPSDEDataSetNameDirty() && (bl || pSDERBase.getPSDEDataSetName() != null)) {
            iDataObject.set(FIELD_PSDEDATASETNAME, (Object)pSDERBase.getPSDEDataSetName());
        }
        if (pSDERBase.isPSDEDRItemsCntDirty() && (bl || pSDERBase.getPSDEDRItemsCnt() != null)) {
            iDataObject.set(FIELD_PSDEDRITEMSCNT, (Object)pSDERBase.getPSDEDRItemsCnt());
        }
        if (pSDERBase.isPSDEFGroupIdDirty() && (bl || pSDERBase.getPSDEFGroupId() != null)) {
            iDataObject.set(FIELD_PSDEFGROUPID, (Object)pSDERBase.getPSDEFGroupId());
        }
        if (pSDERBase.isPSDEFGroupNameDirty() && (bl || pSDERBase.getPSDEFGroupName() != null)) {
            iDataObject.set(FIELD_PSDEFGROUPNAME, (Object)pSDERBase.getPSDEFGroupName());
        }
        if (pSDERBase.isPSDEFieldsCntDirty() && (bl || pSDERBase.getPSDEFieldsCnt() != null)) {
            iDataObject.set(FIELD_PSDEFIELDSCNT, (Object)pSDERBase.getPSDEFieldsCnt());
        }
        if (pSDERBase.isPSDEOPPrivsCntDirty() && (bl || pSDERBase.getPSDEOPPrivsCnt() != null)) {
            iDataObject.set(FIELD_PSDEOPPRIVSCNT, (Object)pSDERBase.getPSDEOPPrivsCnt());
        }
        if (pSDERBase.isPSDERDEFMapsCntDirty() && (bl || pSDERBase.getPSDERDEFMapsCnt() != null)) {
            iDataObject.set(FIELD_PSDERDEFMAPSCNT, (Object)pSDERBase.getPSDERDEFMapsCnt());
        }
        if (pSDERBase.isPSDERIdDirty() && (bl || pSDERBase.getPSDERId() != null)) {
            iDataObject.set(FIELD_PSDERID, (Object)pSDERBase.getPSDERId());
        }
        if (pSDERBase.isPSDERNameDirty() && (bl || pSDERBase.getPSDERName() != null)) {
            iDataObject.set(FIELD_PSDERNAME, (Object)pSDERBase.getPSDERName());
        }
        if (pSDERBase.isPSDynaInstIdDirty() && (bl || pSDERBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSDERBase.getPSDynaInstId());
        }
        if (pSDERBase.isPSSysDynaModelIdDirty() && (bl || pSDERBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSDERBase.getPSSysDynaModelId());
        }
        if (pSDERBase.isPSSysDynaModelNameDirty() && (bl || pSDERBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSDERBase.getPSSysDynaModelName());
        }
        if (pSDERBase.isPSSysSFPluginIdDirty() && (bl || pSDERBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSDERBase.getPSSysSFPluginId());
        }
        if (pSDERBase.isPSSysSFPluginNameDirty() && (bl || pSDERBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSDERBase.getPSSysSFPluginName());
        }
        if (pSDERBase.isPSSystemIdDirty() && (bl || pSDERBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSDERBase.getPSSystemId());
        }
        if (pSDERBase.isPSSystemNameDirty() && (bl || pSDERBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSDERBase.getPSSystemName());
        }
        if (pSDERBase.isRemoveActionTypeDirty() && (bl || pSDERBase.getRemoveActionType() != null)) {
            iDataObject.set(FIELD_REMOVEACTIONTYPE, (Object)pSDERBase.getRemoveActionType());
        }
        if (pSDERBase.isRemoveOrderDirty() && (bl || pSDERBase.getRemoveOrder() != null)) {
            iDataObject.set(FIELD_REMOVEORDER, (Object)pSDERBase.getRemoveOrder());
        }
        if (pSDERBase.isRemoveRejectMsgDirty() && (bl || pSDERBase.getRemoveRejectMsg() != null)) {
            iDataObject.set(FIELD_REMOVEREJECTMSG, (Object)pSDERBase.getRemoveRejectMsg());
        }
        if (pSDERBase.isRemoveRejectPSLanResIdDirty() && (bl || pSDERBase.getRemoveRejectPSLanResId() != null)) {
            iDataObject.set(FIELD_REMOVEREJECTPSLANRESID, (Object)pSDERBase.getRemoveRejectPSLanResId());
        }
        if (pSDERBase.isRemoveRejectPSLanResNameDirty() && (bl || pSDERBase.getRemoveRejectPSLanResName() != null)) {
            iDataObject.set(FIELD_REMOVEREJECTPSLANRESNAME, (Object)pSDERBase.getRemoveRejectPSLanResName());
        }
        if (pSDERBase.isRSPSDEViewIdDirty() && (bl || pSDERBase.getRSPSDEViewId() != null)) {
            iDataObject.set(FIELD_RSPSDEVIEWID, (Object)pSDERBase.getRSPSDEViewId());
        }
        if (pSDERBase.isRSPSDEViewNameDirty() && (bl || pSDERBase.getRSPSDEViewName() != null)) {
            iDataObject.set(FIELD_RSPSDEVIEWNAME, (Object)pSDERBase.getRSPSDEViewName());
        }
        if (pSDERBase.isSDPSDEViewIDDirty() && (bl || pSDERBase.getSDPSDEViewID() != null)) {
            iDataObject.set(FIELD_SDPSDEVIEWID, (Object)pSDERBase.getSDPSDEViewID());
        }
        if (pSDERBase.isSDPSDEViewNameDirty() && (bl || pSDERBase.getSDPSDEViewName() != null)) {
            iDataObject.set(FIELD_SDPSDEVIEWNAME, (Object)pSDERBase.getSDPSDEViewName());
        }
        if (pSDERBase.isServiceCodeNameDirty() && (bl || pSDERBase.getServiceCodeName() != null)) {
            iDataObject.set(FIELD_SERVICECODENAME, (Object)pSDERBase.getServiceCodeName());
        }
        if (pSDERBase.isSyncExportModelDirty() && (bl || pSDERBase.getSyncExportModel() != null)) {
            iDataObject.set(FIELD_SYNCEXPORTMODEL, (Object)pSDERBase.getSyncExportModel());
        }
        if (pSDERBase.isTempOrderValueDirty() && (bl || pSDERBase.getTempOrderValue() != null)) {
            iDataObject.set(FIELD_TEMPORDERVALUE, (Object)pSDERBase.getTempOrderValue());
        }
        if (pSDERBase.isUpdateDateDirty() && (bl || pSDERBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDERBase.getUpdateDate());
        }
        if (pSDERBase.isUpdateManDirty() && (bl || pSDERBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDERBase.getUpdateMan());
        }
        if (pSDERBase.isUpdatePhsicalDEFieldDirty() && (bl || pSDERBase.getUpdatePhsicalDEField() != null)) {
            iDataObject.set(FIELD_UPDATEPHSICALDEFIELD, (Object)pSDERBase.getUpdatePhsicalDEField());
        }
        if (pSDERBase.isUserCatDirty() && (bl || pSDERBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDERBase.getUserCat());
        }
        if (pSDERBase.isUserParamsDirty() && (bl || pSDERBase.getUserParams() != null)) {
            iDataObject.set(FIELD_USERPARAMS, (Object)pSDERBase.getUserParams());
        }
        if (pSDERBase.isUserTagDirty() && (bl || pSDERBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDERBase.getUserTag());
        }
        if (pSDERBase.isUserTag2Dirty() && (bl || pSDERBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDERBase.getUserTag2());
        }
        if (pSDERBase.isUserTag3Dirty() && (bl || pSDERBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDERBase.getUserTag3());
        }
        if (pSDERBase.isUserTag4Dirty() && (bl || pSDERBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDERBase.getUserTag4());
        }
        if (pSDERBase.isValidFlagDirty() && (bl || pSDERBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDERBase.getValidFlag());
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
        return PSDERBase.remove(this, n);
    }

    private static boolean remove(PSDERBase pSDERBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDERBase.resetCloneOrderValue();
                return true;
            }
            case 1: {
                pSDERBase.resetCloneRSFields();
                return true;
            }
            case 2: {
                pSDERBase.resetCntPSDEFId();
                return true;
            }
            case 3: {
                pSDERBase.resetCntPSDEFName();
                return true;
            }
            case 4: {
                pSDERBase.resetCodeName();
                return true;
            }
            case 5: {
                pSDERBase.resetCreateDate();
                return true;
            }
            case 6: {
                pSDERBase.resetCreateMan();
                return true;
            }
            case 7: {
                pSDERBase.resetDEFInheritMode();
                return true;
            }
            case 8: {
                pSDERBase.resetDERFieldLName();
                return true;
            }
            case 9: {
                pSDERBase.resetDERFieldName();
                return true;
            }
            case 10: {
                pSDERBase.resetDERSubType();
                return true;
            }
            case 11: {
                pSDERBase.resetDERTag();
                return true;
            }
            case 12: {
                pSDERBase.resetDERTag2();
                return true;
            }
            case 13: {
                pSDERBase.resetDERType();
                return true;
            }
            case 14: {
                pSDERBase.resetDynaModelFlag();
                return true;
            }
            case 15: {
                pSDERBase.resetEnableClone();
                return true;
            }
            case 16: {
                pSDERBase.resetEnaDEFieldWriteBack();
                return true;
            }
            case 17: {
                pSDERBase.resetEnaExtRange();
                return true;
            }
            case 18: {
                pSDERBase.resetEnaPDEREQ();
                return true;
            }
            case 19: {
                pSDERBase.resetExportMajorModel();
                return true;
            }
            case 20: {
                pSDERBase.resetExportModel();
                return true;
            }
            case 21: {
                pSDERBase.resetExportScope();
                return true;
            }
            case 22: {
                pSDERBase.resetExportScope2();
                return true;
            }
            case 23: {
                pSDERBase.resetExportScope3();
                return true;
            }
            case 24: {
                pSDERBase.resetExportScope4();
                return true;
            }
            case 25: {
                pSDERBase.resetExportScope5();
                return true;
            }
            case 26: {
                pSDERBase.resetExportScope6();
                return true;
            }
            case 27: {
                pSDERBase.resetEXTMajorPSDEFId();
                return true;
            }
            case 28: {
                pSDERBase.resetEXTMajorPSDEFName();
                return true;
            }
            case 29: {
                pSDERBase.resetEXTMinorPSDEFId();
                return true;
            }
            case 30: {
                pSDERBase.resetEXTMinorPSDEFName();
                return true;
            }
            case 31: {
                pSDERBase.resetFKeyName();
                return true;
            }
            case 32: {
                pSDERBase.resetForeignKey();
                return true;
            }
            case 33: {
                pSDERBase.resetIgnoreDEFields();
                return true;
            }
            case 34: {
                pSDERBase.resetIndexValue();
                return true;
            }
            case 35: {
                pSDERBase.resetInheritMode();
                return true;
            }
            case 36: {
                pSDERBase.resetLinkPSDEViewId();
                return true;
            }
            case 37: {
                pSDERBase.resetLinkPSDEViewName();
                return true;
            }
            case 38: {
                pSDERBase.resetLockFlag();
                return true;
            }
            case 39: {
                pSDERBase.resetLogicName();
                return true;
            }
            case 40: {
                pSDERBase.resetMajorPSDEId();
                return true;
            }
            case 41: {
                pSDERBase.resetMajorPSDEName();
                return true;
            }
            case 42: {
                pSDERBase.resetMajorPSDERId();
                return true;
            }
            case 43: {
                pSDERBase.resetMajorPSDERName();
                return true;
            }
            case 44: {
                pSDERBase.resetMasterOrderValue();
                return true;
            }
            case 45: {
                pSDERBase.resetMasterRS();
                return true;
            }
            case 46: {
                pSDERBase.resetMDPSDEViewId();
                return true;
            }
            case 47: {
                pSDERBase.resetMDPSDEViewName();
                return true;
            }
            case 48: {
                pSDERBase.resetMemo();
                return true;
            }
            case 49: {
                pSDERBase.resetMinorCodeName();
                return true;
            }
            case 50: {
                pSDERBase.resetMinorLogicName();
                return true;
            }
            case 51: {
                pSDERBase.resetMinorPSDEDSId();
                return true;
            }
            case 52: {
                pSDERBase.resetMinorPSDEDSName();
                return true;
            }
            case 53: {
                pSDERBase.resetMinorPSDEId();
                return true;
            }
            case 54: {
                pSDERBase.resetMinorPSDEName();
                return true;
            }
            case 55: {
                pSDERBase.resetMinorPSDERId();
                return true;
            }
            case 56: {
                pSDERBase.resetMinorPSDERName();
                return true;
            }
            case 57: {
                pSDERBase.resetMinorServiceCodeName();
                return true;
            }
            case 58: {
                pSDERBase.resetMobLinkPSDEViewId();
                return true;
            }
            case 59: {
                pSDERBase.resetMobLinkPSDEViewName();
                return true;
            }
            case 60: {
                pSDERBase.resetMobMDPSDEViewId();
                return true;
            }
            case 61: {
                pSDERBase.resetMobMDPSDEViewName();
                return true;
            }
            case 62: {
                pSDERBase.resetMobSDPSDEViewId();
                return true;
            }
            case 63: {
                pSDERBase.resetMobSDPSDEViewName();
                return true;
            }
            case 64: {
                pSDERBase.resetOrderValue();
                return true;
            }
            case 65: {
                pSDERBase.resetPredefinedType();
                return true;
            }
            case 66: {
                pSDERBase.resetPropertyMap();
                return true;
            }
            case 67: {
                pSDERBase.resetPSDEACModeId();
                return true;
            }
            case 68: {
                pSDERBase.resetPSDEACModeName();
                return true;
            }
            case 69: {
                pSDERBase.resetPSDEDataSetId();
                return true;
            }
            case 70: {
                pSDERBase.resetPSDEDataSetName();
                return true;
            }
            case 71: {
                pSDERBase.resetPSDEDRItemsCnt();
                return true;
            }
            case 72: {
                pSDERBase.resetPSDEFGroupId();
                return true;
            }
            case 73: {
                pSDERBase.resetPSDEFGroupName();
                return true;
            }
            case 74: {
                pSDERBase.resetPSDEFieldsCnt();
                return true;
            }
            case 75: {
                pSDERBase.resetPSDEOPPrivsCnt();
                return true;
            }
            case 76: {
                pSDERBase.resetPSDERDEFMapsCnt();
                return true;
            }
            case 77: {
                pSDERBase.resetPSDERId();
                return true;
            }
            case 78: {
                pSDERBase.resetPSDERName();
                return true;
            }
            case 79: {
                pSDERBase.resetPSDynaInstId();
                return true;
            }
            case 80: {
                pSDERBase.resetPSSysDynaModelId();
                return true;
            }
            case 81: {
                pSDERBase.resetPSSysDynaModelName();
                return true;
            }
            case 82: {
                pSDERBase.resetPSSysSFPluginId();
                return true;
            }
            case 83: {
                pSDERBase.resetPSSysSFPluginName();
                return true;
            }
            case 84: {
                pSDERBase.resetPSSystemId();
                return true;
            }
            case 85: {
                pSDERBase.resetPSSystemName();
                return true;
            }
            case 86: {
                pSDERBase.resetRemoveActionType();
                return true;
            }
            case 87: {
                pSDERBase.resetRemoveOrder();
                return true;
            }
            case 88: {
                pSDERBase.resetRemoveRejectMsg();
                return true;
            }
            case 89: {
                pSDERBase.resetRemoveRejectPSLanResId();
                return true;
            }
            case 90: {
                pSDERBase.resetRemoveRejectPSLanResName();
                return true;
            }
            case 91: {
                pSDERBase.resetRSPSDEViewId();
                return true;
            }
            case 92: {
                pSDERBase.resetRSPSDEViewName();
                return true;
            }
            case 93: {
                pSDERBase.resetSDPSDEViewID();
                return true;
            }
            case 94: {
                pSDERBase.resetSDPSDEViewName();
                return true;
            }
            case 95: {
                pSDERBase.resetServiceCodeName();
                return true;
            }
            case 96: {
                pSDERBase.resetSyncExportModel();
                return true;
            }
            case 97: {
                pSDERBase.resetTempOrderValue();
                return true;
            }
            case 98: {
                pSDERBase.resetUpdateDate();
                return true;
            }
            case 99: {
                pSDERBase.resetUpdateMan();
                return true;
            }
            case 100: {
                pSDERBase.resetUpdatePhsicalDEField();
                return true;
            }
            case 101: {
                pSDERBase.resetUserCat();
                return true;
            }
            case 102: {
                pSDERBase.resetUserParams();
                return true;
            }
            case 103: {
                pSDERBase.resetUserTag();
                return true;
            }
            case 104: {
                pSDERBase.resetUserTag2();
                return true;
            }
            case 105: {
                pSDERBase.resetUserTag3();
                return true;
            }
            case 106: {
                pSDERBase.resetUserTag4();
                return true;
            }
            case 107: {
                pSDERBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getMajorPSDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMajorPSDE();
        }
        if (this.getMajorPSDEId() == null) {
            return null;
        }
        Integer n = this.objMajorPSDELock;
        synchronized (n) {
            if (this.majorpsde != null && DataTypeHelper.compare((int)25, (Object)this.getMajorPSDEId(), (Object)this.majorpsde.getPSDataEntityId()) != 0L) {
                this.majorpsde = null;
            }
            if (this.majorpsde == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getMajorPSDEId());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet((IEntity)pSDataEntity);
                this.majorpsde = pSDataEntity;
            }
            return this.majorpsde;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getMinorPSDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorPSDE();
        }
        if (this.getMinorPSDEId() == null) {
            return null;
        }
        Integer n = this.objMinorPSDELock;
        synchronized (n) {
            if (this.minorpsde != null && DataTypeHelper.compare((int)25, (Object)this.getMinorPSDEId(), (Object)this.minorpsde.getPSDataEntityId()) != 0L) {
                this.minorpsde = null;
            }
            if (this.minorpsde == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getMinorPSDEId());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet((IEntity)pSDataEntity);
                this.minorpsde = pSDataEntity;
            }
            return this.minorpsde;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEACMode getPSDEACMode() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEACMode();
        }
        if (this.getPSDEACModeId() == null) {
            return null;
        }
        Integer n = this.objPSDEACModeLock;
        synchronized (n) {
            if (this.psdeacmode != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEACModeId(), (Object)this.psdeacmode.getPSDEACModeId()) != 0L) {
                this.psdeacmode = null;
            }
            if (this.psdeacmode == null) {
                PSDEACMode pSDEACMode = new PSDEACMode();
                pSDEACMode.setPSDEACModeId(this.getPSDEACModeId());
                PSDEACModeService pSDEACModeService = (PSDEACModeService)ServiceGlobal.getService(PSDEACModeService.class, (SessionFactory)this.getSessionFactory());
                pSDEACModeService.autoGet((IEntity)pSDEACMode);
                this.psdeacmode = pSDEACMode;
            }
            return this.psdeacmode;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDataSet getMinorPSDEDS() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorPSDEDS();
        }
        if (this.getMinorPSDEDSId() == null) {
            return null;
        }
        Integer n = this.objMinorPSDEDSLock;
        synchronized (n) {
            if (this.minorpsdeds != null && DataTypeHelper.compare((int)25, (Object)this.getMinorPSDEDSId(), (Object)this.minorpsdeds.getPSDEDataSetId()) != 0L) {
                this.minorpsdeds = null;
            }
            if (this.minorpsdeds == null) {
                PSDEDataSet pSDEDataSet = new PSDEDataSet();
                pSDEDataSet.setPSDEDataSetId(this.getMinorPSDEDSId());
                PSDEDataSetService pSDEDataSetService = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataSetService.autoGet((IEntity)pSDEDataSet);
                this.minorpsdeds = pSDEDataSet;
            }
            return this.minorpsdeds;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDataSet getPSDEDataSet() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataSet();
        }
        if (this.getPSDEDataSetId() == null) {
            return null;
        }
        Integer n = this.objPSDEDataSetLock;
        synchronized (n) {
            if (this.psdedataset != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEDataSetId(), (Object)this.psdedataset.getPSDEDataSetId()) != 0L) {
                this.psdedataset = null;
            }
            if (this.psdedataset == null) {
                PSDEDataSet pSDEDataSet = new PSDEDataSet();
                pSDEDataSet.setPSDEDataSetId(this.getPSDEDataSetId());
                PSDEDataSetService pSDEDataSetService = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataSetService.autoGet((IEntity)pSDEDataSet);
                this.psdedataset = pSDEDataSet;
            }
            return this.psdedataset;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEFGroup getPSDEFGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFGroup();
        }
        if (this.getPSDEFGroupId() == null) {
            return null;
        }
        Integer n = this.objPSDEFGroupLock;
        synchronized (n) {
            if (this.psdefgroup != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEFGroupId(), (Object)this.psdefgroup.getPSDEFGroupId()) != 0L) {
                this.psdefgroup = null;
            }
            if (this.psdefgroup == null) {
                PSDEFGroup pSDEFGroup = new PSDEFGroup();
                pSDEFGroup.setPSDEFGroupId(this.getPSDEFGroupId());
                PSDEFGroupService pSDEFGroupService = (PSDEFGroupService)ServiceGlobal.getService(PSDEFGroupService.class, (SessionFactory)this.getSessionFactory());
                pSDEFGroupService.autoGet((IEntity)pSDEFGroup);
                this.psdefgroup = pSDEFGroup;
            }
            return this.psdefgroup;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getCntPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCntPSDEF();
        }
        if (this.getCntPSDEFId() == null) {
            return null;
        }
        Integer n = this.objCntPSDEFLock;
        synchronized (n) {
            if (this.cntpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getCntPSDEFId(), (Object)this.cntpsdef.getPSDEFieldId()) != 0L) {
                this.cntpsdef = null;
            }
            if (this.cntpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getCntPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.cntpsdef = pSDEField;
            }
            return this.cntpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getExtMajorPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExtMajorPSDEF();
        }
        if (this.getEXTMajorPSDEFId() == null) {
            return null;
        }
        Integer n = this.objExtMajorPSDEFLock;
        synchronized (n) {
            if (this.extmajorpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getEXTMajorPSDEFId(), (Object)this.extmajorpsdef.getPSDEFieldId()) != 0L) {
                this.extmajorpsdef = null;
            }
            if (this.extmajorpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getEXTMajorPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.extmajorpsdef = pSDEField;
            }
            return this.extmajorpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getExtMinorPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExtMinorPSDEF();
        }
        if (this.getEXTMinorPSDEFId() == null) {
            return null;
        }
        Integer n = this.objExtMinorPSDEFLock;
        synchronized (n) {
            if (this.extminorpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getEXTMinorPSDEFId(), (Object)this.extminorpsdef.getPSDEFieldId()) != 0L) {
                this.extminorpsdef = null;
            }
            if (this.extminorpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getEXTMinorPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.extminorpsdef = pSDEField;
            }
            return this.extminorpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDER getMajorPSDER() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMajorPSDER();
        }
        if (this.getMajorPSDERId() == null) {
            return null;
        }
        Integer n = this.objMajorPSDERLock;
        synchronized (n) {
            if (this.majorpsder != null && DataTypeHelper.compare((int)25, (Object)this.getMajorPSDERId(), (Object)this.majorpsder.getPSDERId()) != 0L) {
                this.majorpsder = null;
            }
            if (this.majorpsder == null) {
                PSDER pSDER = new PSDER();
                pSDER.setPSDERId(this.getMajorPSDERId());
                PSDERService pSDERService = (PSDERService)ServiceGlobal.getService(PSDERService.class, (SessionFactory)this.getSessionFactory());
                pSDERService.autoGet((IEntity)pSDER);
                this.majorpsder = pSDER;
            }
            return this.majorpsder;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDER getMinorPSDER() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorPSDER();
        }
        if (this.getMinorPSDERId() == null) {
            return null;
        }
        Integer n = this.objMinorPSDERLock;
        synchronized (n) {
            if (this.minorpsder != null && DataTypeHelper.compare((int)25, (Object)this.getMinorPSDERId(), (Object)this.minorpsder.getPSDERId()) != 0L) {
                this.minorpsder = null;
            }
            if (this.minorpsder == null) {
                PSDER pSDER = new PSDER();
                pSDER.setPSDERId(this.getMinorPSDERId());
                PSDERService pSDERService = (PSDERService)ServiceGlobal.getService(PSDERService.class, (SessionFactory)this.getSessionFactory());
                pSDERService.autoGet((IEntity)pSDER);
                this.minorpsder = pSDER;
            }
            return this.minorpsder;
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
    public PSDEViewBase getMDPSDEView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMDPSDEView();
        }
        if (this.getMDPSDEViewId() == null) {
            return null;
        }
        Integer n = this.objMDPSDEViewLock;
        synchronized (n) {
            if (this.mdpsdeview != null && DataTypeHelper.compare((int)25, (Object)this.getMDPSDEViewId(), (Object)this.mdpsdeview.getPSDEViewBaseId()) != 0L) {
                this.mdpsdeview = null;
            }
            if (this.mdpsdeview == null) {
                PSDEViewBase pSDEViewBase = new PSDEViewBase();
                pSDEViewBase.setPSDEViewBaseId(this.getMDPSDEViewId());
                PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
                pSDEViewBaseService.autoGet((IEntity)pSDEViewBase);
                this.mdpsdeview = pSDEViewBase;
            }
            return this.mdpsdeview;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEViewBase getMobLinkPSDEView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobLinkPSDEView();
        }
        if (this.getMobLinkPSDEViewId() == null) {
            return null;
        }
        Integer n = this.objMobLinkPSDEViewLock;
        synchronized (n) {
            if (this.moblinkpsdeview != null && DataTypeHelper.compare((int)25, (Object)this.getMobLinkPSDEViewId(), (Object)this.moblinkpsdeview.getPSDEViewBaseId()) != 0L) {
                this.moblinkpsdeview = null;
            }
            if (this.moblinkpsdeview == null) {
                PSDEViewBase pSDEViewBase = new PSDEViewBase();
                pSDEViewBase.setPSDEViewBaseId(this.getMobLinkPSDEViewId());
                PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
                pSDEViewBaseService.autoGet((IEntity)pSDEViewBase);
                this.moblinkpsdeview = pSDEViewBase;
            }
            return this.moblinkpsdeview;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEViewBase getMobMDPSDEView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobMDPSDEView();
        }
        if (this.getMobMDPSDEViewId() == null) {
            return null;
        }
        Integer n = this.objMobMDPSDEViewLock;
        synchronized (n) {
            if (this.mobmdpsdeview != null && DataTypeHelper.compare((int)25, (Object)this.getMobMDPSDEViewId(), (Object)this.mobmdpsdeview.getPSDEViewBaseId()) != 0L) {
                this.mobmdpsdeview = null;
            }
            if (this.mobmdpsdeview == null) {
                PSDEViewBase pSDEViewBase = new PSDEViewBase();
                pSDEViewBase.setPSDEViewBaseId(this.getMobMDPSDEViewId());
                PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
                pSDEViewBaseService.autoGet((IEntity)pSDEViewBase);
                this.mobmdpsdeview = pSDEViewBase;
            }
            return this.mobmdpsdeview;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEViewBase getMobSDPSDEView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobSDPSDEView();
        }
        if (this.getMobSDPSDEViewId() == null) {
            return null;
        }
        Integer n = this.objMobSDPSDEViewLock;
        synchronized (n) {
            if (this.mobsdpsdeview != null && DataTypeHelper.compare((int)25, (Object)this.getMobSDPSDEViewId(), (Object)this.mobsdpsdeview.getPSDEViewBaseId()) != 0L) {
                this.mobsdpsdeview = null;
            }
            if (this.mobsdpsdeview == null) {
                PSDEViewBase pSDEViewBase = new PSDEViewBase();
                pSDEViewBase.setPSDEViewBaseId(this.getMobSDPSDEViewId());
                PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
                pSDEViewBaseService.autoGet((IEntity)pSDEViewBase);
                this.mobsdpsdeview = pSDEViewBase;
            }
            return this.mobsdpsdeview;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEViewBase getRSPSDEView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRSPSDEView();
        }
        if (this.getRSPSDEViewId() == null) {
            return null;
        }
        Integer n = this.objRSPSDEViewLock;
        synchronized (n) {
            if (this.rspsdeview != null && DataTypeHelper.compare((int)25, (Object)this.getRSPSDEViewId(), (Object)this.rspsdeview.getPSDEViewBaseId()) != 0L) {
                this.rspsdeview = null;
            }
            if (this.rspsdeview == null) {
                PSDEViewBase pSDEViewBase = new PSDEViewBase();
                pSDEViewBase.setPSDEViewBaseId(this.getRSPSDEViewId());
                PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
                pSDEViewBaseService.autoGet((IEntity)pSDEViewBase);
                this.rspsdeview = pSDEViewBase;
            }
            return this.rspsdeview;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEViewBase getSDPSDEView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSDPSDEView();
        }
        if (this.getSDPSDEViewID() == null) {
            return null;
        }
        Integer n = this.objSDPSDEViewLock;
        synchronized (n) {
            if (this.sdpsdeview != null && DataTypeHelper.compare((int)25, (Object)this.getSDPSDEViewID(), (Object)this.sdpsdeview.getPSDEViewBaseId()) != 0L) {
                this.sdpsdeview = null;
            }
            if (this.sdpsdeview == null) {
                PSDEViewBase pSDEViewBase = new PSDEViewBase();
                pSDEViewBase.setPSDEViewBaseId(this.getSDPSDEViewID());
                PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
                pSDEViewBaseService.autoGet((IEntity)pSDEViewBase);
                this.sdpsdeview = pSDEViewBase;
            }
            return this.sdpsdeview;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguageRes getRemoveRejectPSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRemoveRejectPSLanRes();
        }
        if (this.getRemoveRejectPSLanResId() == null) {
            return null;
        }
        Integer n = this.objRemoveRejectPSLanResLock;
        synchronized (n) {
            if (this.removerejectpslanres != null && DataTypeHelper.compare((int)25, (Object)this.getRemoveRejectPSLanResId(), (Object)this.removerejectpslanres.getPSLanguageResId()) != 0L) {
                this.removerejectpslanres = null;
            }
            if (this.removerejectpslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getRemoveRejectPSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet((IEntity)pSLanguageRes);
                this.removerejectpslanres = pSLanguageRes;
            }
            return this.removerejectpslanres;
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
    public ArrayList<PSDEDRItem> getPSDEDRItems() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDRItems();
        }
        if (this.getPSDERId() == null) {
            return null;
        }
        PSDEDRItemService pSDEDRItemService = (PSDEDRItemService)ServiceGlobal.getService(PSDEDRItemService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEDRItemsLock;
        synchronized (n) {
            if (this.psdedritems == null) {
                this.psdedritems = pSDEDRItemService.selectByPSDER(this);
            }
            return this.psdedritems;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEField> getPSDEFields() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFields();
        }
        if (this.getPSDERId() == null) {
            return null;
        }
        PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEFieldsLock;
        synchronized (n) {
            if (this.psdefields == null) {
                this.psdefields = pSDEFieldService.selectByPSDER(this);
            }
            return this.psdefields;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEOPPriv> getPSDEOPPrivs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEOPPrivs();
        }
        if (this.getPSDERId() == null) {
            return null;
        }
        PSDEOPPrivService pSDEOPPrivService = (PSDEOPPrivService)ServiceGlobal.getService(PSDEOPPrivService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEOPPrivsLock;
        synchronized (n) {
            if (this.psdeopprivs == null) {
                this.psdeopprivs = pSDEOPPrivService.selectByPSDER(this);
            }
            return this.psdeopprivs;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDERDEFMap> getPSDERDEFMaps() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDERDEFMaps();
        }
        if (this.getPSDERId() == null) {
            return null;
        }
        PSDERDEFMapService pSDERDEFMapService = (PSDERDEFMapService)ServiceGlobal.getService(PSDERDEFMapService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDERDEFMapsLock;
        synchronized (n) {
            if (this.psderdefmaps == null) {
                this.psderdefmaps = pSDERDEFMapService.selectByPSDER(this);
            }
            return this.psderdefmaps;
        }
    }

    private PSDERBase getProxyEntity() {
        return this.proxyPSDERBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDERBase = null;
        if (iDataObject != null && iDataObject instanceof PSDERBase) {
            this.proxyPSDERBase = (PSDERBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDERService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CLONEORDERVALUE, 0);
        fieldIndexMap.put(FIELD_CLONERSFIELDS, 1);
        fieldIndexMap.put(FIELD_CNTPSDEFID, 2);
        fieldIndexMap.put(FIELD_CNTPSDEFNAME, 3);
        fieldIndexMap.put(FIELD_CODENAME, 4);
        fieldIndexMap.put(FIELD_CREATEDATE, 5);
        fieldIndexMap.put(FIELD_CREATEMAN, 6);
        fieldIndexMap.put(FIELD_DEFINHERITMODE, 7);
        fieldIndexMap.put(FIELD_DERFIELDLNAME, 8);
        fieldIndexMap.put(FIELD_DERFIELDNAME, 9);
        fieldIndexMap.put(FIELD_DERSUBTYPE, 10);
        fieldIndexMap.put(FIELD_DERTAG, 11);
        fieldIndexMap.put(FIELD_DERTAG2, 12);
        fieldIndexMap.put(FIELD_DERTYPE, 13);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 14);
        fieldIndexMap.put(FIELD_ENABLECLONE, 15);
        fieldIndexMap.put(FIELD_ENADEFIELDWRITEBACK, 16);
        fieldIndexMap.put(FIELD_ENAEXTRANGE, 17);
        fieldIndexMap.put(FIELD_ENAPDEREQ, 18);
        fieldIndexMap.put(FIELD_EXPORTMAJORMODEL, 19);
        fieldIndexMap.put(FIELD_EXPORTMODEL, 20);
        fieldIndexMap.put(FIELD_EXPORTSCOPE, 21);
        fieldIndexMap.put(FIELD_EXPORTSCOPE2, 22);
        fieldIndexMap.put(FIELD_EXPORTSCOPE3, 23);
        fieldIndexMap.put(FIELD_EXPORTSCOPE4, 24);
        fieldIndexMap.put(FIELD_EXPORTSCOPE5, 25);
        fieldIndexMap.put(FIELD_EXPORTSCOPE6, 26);
        fieldIndexMap.put(FIELD_EXTMAJORPSDEFID, 27);
        fieldIndexMap.put(FIELD_EXTMAJORPSDEFNAME, 28);
        fieldIndexMap.put(FIELD_EXTMINORPSDEFID, 29);
        fieldIndexMap.put(FIELD_EXTMINORPSDEFNAME, 30);
        fieldIndexMap.put(FIELD_FKEYNAME, 31);
        fieldIndexMap.put(FIELD_FOREIGNKEY, 32);
        fieldIndexMap.put(FIELD_IGNOREDEFIELDS, 33);
        fieldIndexMap.put(FIELD_INDEXVALUE, 34);
        fieldIndexMap.put(FIELD_INHERITMODE, 35);
        fieldIndexMap.put(FIELD_LINKPSDEVIEWID, 36);
        fieldIndexMap.put(FIELD_LINKPSDEVIEWNAME, 37);
        fieldIndexMap.put(FIELD_LOCKFLAG, 38);
        fieldIndexMap.put(FIELD_LOGICNAME, 39);
        fieldIndexMap.put(FIELD_MAJORPSDEID, 40);
        fieldIndexMap.put(FIELD_MAJORPSDENAME, 41);
        fieldIndexMap.put(FIELD_MAJORPSDERID, 42);
        fieldIndexMap.put(FIELD_MAJORPSDERNAME, 43);
        fieldIndexMap.put(FIELD_MASTERORDERVALUE, 44);
        fieldIndexMap.put(FIELD_MASTERRS, 45);
        fieldIndexMap.put(FIELD_MDPSDEVIEWID, 46);
        fieldIndexMap.put(FIELD_MDPSDEVIEWNAME, 47);
        fieldIndexMap.put(FIELD_MEMO, 48);
        fieldIndexMap.put(FIELD_MINORCODENAME, 49);
        fieldIndexMap.put(FIELD_MINORLOGICNAME, 50);
        fieldIndexMap.put(FIELD_MINORPSDEDSID, 51);
        fieldIndexMap.put(FIELD_MINORPSDEDSNAME, 52);
        fieldIndexMap.put(FIELD_MINORPSDEID, 53);
        fieldIndexMap.put(FIELD_MINORPSDENAME, 54);
        fieldIndexMap.put(FIELD_MINORPSDERID, 55);
        fieldIndexMap.put(FIELD_MINORPSDERNAME, 56);
        fieldIndexMap.put(FIELD_MINORSERVICECODENAME, 57);
        fieldIndexMap.put(FIELD_MOBLINKPSDEVIEWID, 58);
        fieldIndexMap.put(FIELD_MOBLINKPSDEVIEWNAME, 59);
        fieldIndexMap.put(FIELD_MOBMDPSDEVIEWID, 60);
        fieldIndexMap.put(FIELD_MOBMDPSDEVIEWNAME, 61);
        fieldIndexMap.put(FIELD_MOBSDPSDEVIEWID, 62);
        fieldIndexMap.put(FIELD_MOBSDPSDEVIEWNAME, 63);
        fieldIndexMap.put(FIELD_ORDERVALUE, 64);
        fieldIndexMap.put(FIELD_PREDEFINEDTYPE, 65);
        fieldIndexMap.put(FIELD_PROPERTYMAP, 66);
        fieldIndexMap.put(FIELD_PSDEACMODEID, 67);
        fieldIndexMap.put(FIELD_PSDEACMODENAME, 68);
        fieldIndexMap.put(FIELD_PSDEDATASETID, 69);
        fieldIndexMap.put(FIELD_PSDEDATASETNAME, 70);
        fieldIndexMap.put(FIELD_PSDEDRITEMSCNT, 71);
        fieldIndexMap.put(FIELD_PSDEFGROUPID, 72);
        fieldIndexMap.put(FIELD_PSDEFGROUPNAME, 73);
        fieldIndexMap.put(FIELD_PSDEFIELDSCNT, 74);
        fieldIndexMap.put(FIELD_PSDEOPPRIVSCNT, 75);
        fieldIndexMap.put(FIELD_PSDERDEFMAPSCNT, 76);
        fieldIndexMap.put(FIELD_PSDERID, 77);
        fieldIndexMap.put(FIELD_PSDERNAME, 78);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 79);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 80);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 81);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 82);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 83);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 84);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 85);
        fieldIndexMap.put(FIELD_REMOVEACTIONTYPE, 86);
        fieldIndexMap.put(FIELD_REMOVEORDER, 87);
        fieldIndexMap.put(FIELD_REMOVEREJECTMSG, 88);
        fieldIndexMap.put(FIELD_REMOVEREJECTPSLANRESID, 89);
        fieldIndexMap.put(FIELD_REMOVEREJECTPSLANRESNAME, 90);
        fieldIndexMap.put(FIELD_RSPSDEVIEWID, 91);
        fieldIndexMap.put(FIELD_RSPSDEVIEWNAME, 92);
        fieldIndexMap.put(FIELD_SDPSDEVIEWID, 93);
        fieldIndexMap.put(FIELD_SDPSDEVIEWNAME, 94);
        fieldIndexMap.put(FIELD_SERVICECODENAME, 95);
        fieldIndexMap.put(FIELD_SYNCEXPORTMODEL, 96);
        fieldIndexMap.put(FIELD_TEMPORDERVALUE, 97);
        fieldIndexMap.put(FIELD_UPDATEDATE, 98);
        fieldIndexMap.put(FIELD_UPDATEMAN, 99);
        fieldIndexMap.put(FIELD_UPDATEPHSICALDEFIELD, 100);
        fieldIndexMap.put(FIELD_USERCAT, 101);
        fieldIndexMap.put(FIELD_USERPARAMS, 102);
        fieldIndexMap.put(FIELD_USERTAG, 103);
        fieldIndexMap.put(FIELD_USERTAG2, 104);
        fieldIndexMap.put(FIELD_USERTAG3, 105);
        fieldIndexMap.put(FIELD_USERTAG4, 106);
        fieldIndexMap.put(FIELD_VALIDFLAG, 107);
    }
}

