/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.demodel.entity;


import java.io.Serializable;
import java.util.HashMap;
import java.util.ArrayList;
import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Column;

import java.sql.Timestamp;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONObject;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.paas.service.ServiceGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * 实体[DataEntity] 数据对象基类
 */
public abstract class DataEntityBase extends net.ibizsys.paas.entity.EntityBase implements Serializable {

    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(DataEntityBase.class);
    /**
     * 属性[启动自填数据权限]
     */
    public final static String FIELD_ACENABLEDP = "ACENABLEDP";
    /**
     * 属性[自动填充附加信息]
     */
    public final static String FIELD_ACEXTINFO = "ACEXTINFO";
    /**
     * 属性[自动填充信息格式]
     */
    public final static String FIELD_ACINFOFORMAT = "ACINFOFORMAT";
    /**
     * 属性[自动填充信息参数]
     */
    public final static String FIELD_ACINFOPARAM = "ACINFOPARAM";
    /**
     * 属性[自填最大数量]
     */
    public final static String FIELD_ACMAXCNT = "ACMAXCNT";
    /**
     * 属性[自动填充处理对象]
     */
    public final static String FIELD_ACOBJECT = "ACOBJECT";
    /**
     * 属性[数据实体_自填查询模型]
     */
    public final static String FIELD_ACQUERYMODELID = "ACQUERYMODELID";
    /**
     * 属性[自填查询模型]
     */
    public final static String FIELD_ACQUERYMODELNAME = "ACQUERYMODELNAME";
    /**
     * 属性[自动排序方向]
     */
    public final static String FIELD_ACSORTDIR = "ACSORTDIR";
    /**
     * 属性[自填排序字段]
     */
    public final static String FIELD_ACSORTFIELD = "ACSORTFIELD";
    /**
     * 属性[大图标]
     */
    public final static String FIELD_BIGICON = "BIGICON";
    /**
     * 属性[配置辅助对象]
     */
    public final static String FIELD_CONFIGHELPER = "CONFIGHELPER";
    /**
     * 属性[建立时间]
     */
    public final static String FIELD_CREATEDATE = "CREATEDATE";
    /**
     * 属性[建立人]
     */
    public final static String FIELD_CREATEMAN = "CREATEMAN";
    /**
     * 属性[数据访问控制对象]
     */
    public final static String FIELD_DATAACCOBJECT = "DATAACCOBJECT";
    /**
     * 属性[数据变更日志类型]
     */
    public final static String FIELD_DATACHGLOGMODE = "DATACHGLOGMODE";
    /**
     * 属性[数据访问对象接口]
     */
    public final static String FIELD_DATACTRLINT = "DATACTRLINT";
    /**
     * 属性[数据访问对象]
     */
    public final static String FIELD_DATACTRLOBJECT = "DATACTRLOBJECT";
    /**
     * 属性[数据通知辅助对象]
     */
    public final static String FIELD_DATANOTIFYHELPER = "DATANOTIFYHELPER";
    /**
     * 属性[数据库存储]
     */
    public final static String FIELD_DBSTORAGE = "DBSTORAGE";
    /**
     * 属性[数据结构版本]
     */
    public final static String FIELD_DBVERSION = "DBVERSION";
    /**
     * 属性[实体归属]
     */
    public final static String FIELD_DEGROUP = "DEGROUP";
    /**
     * 属性[实体辅助对象]
     */
    public final static String FIELD_DEHELPER = "DEHELPER";
    /**
     * 属性[实体标识]
     */
    public final static String FIELD_DEID = "DEID";
    /**
     * 属性[逻辑名称]
     */
    public final static String FIELD_DELOGICNAME = "DELOGICNAME";
    /**
     * 属性[实体名称]
     */
    public final static String FIELD_DENAME = "DENAME";
    /**
     * 属性[数据对象类]
     */
    public final static String FIELD_DEOBJECT = "DEOBJECT";
    /**
     * 属性[实体次序]
     */
    public final static String FIELD_DEORDER = "DEORDER";
    /**
     * 属性[实体参数]
     */
    public final static String FIELD_DEPARAM = "DEPARAM";
    /**
     * 属性[1:1关系实体]
     */
    public final static String FIELD_DER11DEID = "DER11DEID";
    /**
     * 属性[DER11DENAME]
     */
    public final static String FIELD_DER11DENAME = "DER11DENAME";
    /**
     * 属性[实体类型]
     */
    public final static String FIELD_DETYPE = "DETYPE";
    /**
     * 属性[实体用户参数]
     */
    public final static String FIELD_DEUSERPARAM = "DEUSERPARAM";
    /**
     * 属性[版本]
     */
    public final static String FIELD_DEVERSION = "DEVERSION";
    /**
     * 属性[表格行样式辅助对象]
     */
    public final static String FIELD_DGROWCLASSHELPER = "DGROWCLASSHELPER";
    /**
     * 属性[表格信息区高度]
     */
    public final static String FIELD_DGSUMMARYHEIGHT = "DGSUMMARYHEIGHT";
    /**
     * 属性[数据锁辅助对象]
     */
    public final static String FIELD_DLKHELPER = "DLKHELPER";
    /**
     * 属性[动态表间隔时间]
     */
    public final static String FIELD_DYNAMICINTERVAL = "DYNAMICINTERVAL";
    /**
     * 属性[启用列权限控制]
     */
    public final static String FIELD_ENABLECOLPRIV = "ENABLECOLPRIV";
    /**
     * 属性[启用全局模型缓存]
     */
    public final static String FIELD_ENABLEGLOBALMODEL = "ENABLEGLOBALMODEL";
    /**
     * 属性[现存模型]
     */
    public final static String FIELD_EXITINGMODEL = "EXITINGMODEL";
    /**
     * 属性[导出模型包含空值]
     */
    public final static String FIELD_EXPORTINCEMPTY = "EXPORTINCEMPTY";
    /**
     * 属性[用户表]
     */
    public final static String FIELD_EXTABLENAME = "EXTABLENAME";
    /**
     * 属性[全局模型对象]
     */
    public final static String FIELD_GLOBALMODELOBJ = "GLOBALMODELOBJ";
    /**
     * 属性[索引模式]
     */
    public final static String FIELD_INDEXMODE = "INDEXMODE";
    /**
     * 属性[信息属性参数]
     */
    public final static String FIELD_INFOFIELD = "INFOFIELD";
    /**
     * 属性[信息格式化]
     */
    public final static String FIELD_INFOFORMAT = "INFOFORMAT";
    /**
     * 属性[继承模式]
     */
    public final static String FIELD_INHERITMODE = "INHERITMODE";
    /**
     * 属性[启用表格行编辑]
     */
    public final static String FIELD_ISDGROWEDIT = "ISDGROWEDIT";
    /**
     * 属性[启用审计]
     */
    public final static String FIELD_ISENABLEAUDIT = "ISENABLEAUDIT";
    /**
     * 属性[启用数据权限]
     */
    public final static String FIELD_ISENABLEDP = "ISENABLEDP";
    /**
     * 属性[索引实体]
     */
    public final static String FIELD_ISINDEXDE = "ISINDEXDE";
    /**
     * 属性[启用逻辑有效]
     */
    public final static String FIELD_ISLOGICVALID = "ISLOGICVALID";
    /**
     * 属性[多选打印]
     */
    public final static String FIELD_ISMULTIPRINT = "ISMULTIPRINT";
    /**
     * 属性[数据附件]
     */
    public final static String FIELD_ISSUPPORTFA = "ISSUPPORTFA";
    /**
     * 属性[系统实体]
     */
    public final static String FIELD_ISSYSTEM = "ISSYSTEM";
    /**
     * 属性[主键参数]
     */
    public final static String FIELD_KEYPARAMS = "KEYPARAMS";
    /**
     * 属性[授权代码]
     */
    public final static String FIELD_LICENSECODE = "LICENSECODE";
    /**
     * 属性[记录审计明细]
     */
    public final static String FIELD_LOGAUDITDETAIL = "LOGAUDITDETAIL";
    /**
     * 属性[备注]
     */
    public final static String FIELD_MEMO = "MEMO";
    /**
     * 属性[附表标识字段]
     */
    public final static String FIELD_MINORFIELDNAME = "MINORFIELDNAME";
    /**
     * 属性[附表标识值]
     */
    public final static String FIELD_MINORFIELDVALUE = "MINORFIELDVALUE";
    /**
     * 属性[附表名称]
     */
    public final static String FIELD_MINORTABLENAME = "MINORTABLENAME";
    /**
     * 属性[多主实体模式]
     */
    public final static String FIELD_MUTLIMAJOR = "MULTIMAJOR";
    /**
     * 属性[无数据信息]
     */
    public final static String FIELD_NODATAINFO = "NODATAINFO";
    /**
     * 属性[打印功能]
     */
    public final static String FIELD_PRINTFUNC = "PRINTFUNC";
    /**
     * 属性[保留1]
     */
    public final static String FIELD_RESERVER = "RESERVER";
    /**
     * 属性[保留2]
     */
    public final static String FIELD_RESERVER2 = "RESERVER2";
    /**
     * 属性[记录数量]
     */
    public final static String FIELD_ROWAMOUT = "ROWAMOUNT";
    /**
     * 属性[运行信息]
     */
    public final static String FIELD_RTINFO = "RTINFO";
    /**
     * 属性[小图标]
     */
    public final static String FIELD_SMALLICON = "SMALLICON";
    /**
     * 属性[实体存储类型]
     */
    public final static String FIELD_STORAGETYPE = "STORAGETYPE";
    /**
     * 属性[表名称]
     */
    public final static String FIELD_TABLENAME = "TABLENAME";
    /**
     * 属性[实体表空间]
     */
    public final static String FIELD_TABLESPACE = "TABLESPACE";
    /**
     * 属性[提示信息]
     */
    public final static String FIELD_TIPSINFO = "TIPSINFO";
    /**
     * 属性[更新时间]
     */
    public final static String FIELD_UPDATEDATE = "UPDATEDATE";
    /**
     * 属性[更新人]
     */
    public final static String FIELD_UPDATEMAN = "UPDATEMAN";
    /**
     * 属性[用户数据行为]
     */
    public final static String FIELD_USERACTION = "USERACTION";
    /**
     * 属性[是否启用]
     */
    public final static String FIELD_VALIDFLAG = "VALIDFLAG";
    /**
     * 属性[启用数据版本控制]
     */
    public final static String FIELD_VCFLAG = "VCFLAG";
    /**
     * 属性[版本检查间隔]
     */
    public final static String FIELD_VERCHECKTIMER = "VERCHECKTIMER";
    /**
     * 属性[版本属性]
     */
    public final static String FIELD_VERFIELD = "VERFIELD";
    /**
     * 属性[版本辅助对象]
     */
    public final static String FIELD_VERHELPER = "VERHELPER";
    /**
     * 属性[版本检查]
     */
    public final static String FIELD_VERSIONCHECK = "VERSIONCHECK";
    /**
     * 属性[视图名称]
     */
    public final static String FIELD_VIEWNAME = "VIEWNAME";

    private final static int INDEX_ACENABLEDP = 0;
    private final static int INDEX_ACEXTINFO = 1;
    private final static int INDEX_ACINFOFORMAT = 2;
    private final static int INDEX_ACINFOPARAM = 3;
    private final static int INDEX_ACMAXCNT = 4;
    private final static int INDEX_ACOBJECT = 5;
    private final static int INDEX_ACQUERYMODELID = 6;
    private final static int INDEX_ACQUERYMODELNAME = 7;
    private final static int INDEX_ACSORTDIR = 8;
    private final static int INDEX_ACSORTFIELD = 9;
    private final static int INDEX_BIGICON = 10;
    private final static int INDEX_CONFIGHELPER = 11;
    private final static int INDEX_CREATEDATE = 12;
    private final static int INDEX_CREATEMAN = 13;
    private final static int INDEX_DATAACCOBJECT = 14;
    private final static int INDEX_DATACHGLOGMODE = 15;
    private final static int INDEX_DATACTRLINT = 16;
    private final static int INDEX_DATACTRLOBJECT = 17;
    private final static int INDEX_DATANOTIFYHELPER = 18;
    private final static int INDEX_DBSTORAGE = 19;
    private final static int INDEX_DBVERSION = 20;
    private final static int INDEX_DEGROUP = 21;
    private final static int INDEX_DEHELPER = 22;
    private final static int INDEX_DEID = 23;
    private final static int INDEX_DELOGICNAME = 24;
    private final static int INDEX_DENAME = 25;
    private final static int INDEX_DEOBJECT = 26;
    private final static int INDEX_DEORDER = 27;
    private final static int INDEX_DEPARAM = 28;
    private final static int INDEX_DER11DEID = 29;
    private final static int INDEX_DER11DENAME = 30;
    private final static int INDEX_DETYPE = 31;
    private final static int INDEX_DEUSERPARAM = 32;
    private final static int INDEX_DEVERSION = 33;
    private final static int INDEX_DGROWCLASSHELPER = 34;
    private final static int INDEX_DGSUMMARYHEIGHT = 35;
    private final static int INDEX_DLKHELPER = 36;
    private final static int INDEX_DYNAMICINTERVAL = 37;
    private final static int INDEX_ENABLECOLPRIV = 38;
    private final static int INDEX_ENABLEGLOBALMODEL = 39;
    private final static int INDEX_EXITINGMODEL = 40;
    private final static int INDEX_EXPORTINCEMPTY = 41;
    private final static int INDEX_EXTABLENAME = 42;
    private final static int INDEX_GLOBALMODELOBJ = 43;
    private final static int INDEX_INDEXMODE = 44;
    private final static int INDEX_INFOFIELD = 45;
    private final static int INDEX_INFOFORMAT = 46;
    private final static int INDEX_INHERITMODE = 47;
    private final static int INDEX_ISDGROWEDIT = 48;
    private final static int INDEX_ISENABLEAUDIT = 49;
    private final static int INDEX_ISENABLEDP = 50;
    private final static int INDEX_ISINDEXDE = 51;
    private final static int INDEX_ISLOGICVALID = 52;
    private final static int INDEX_ISMULTIPRINT = 53;
    private final static int INDEX_ISSUPPORTFA = 54;
    private final static int INDEX_ISSYSTEM = 55;
    private final static int INDEX_KEYPARAMS = 56;
    private final static int INDEX_LICENSECODE = 57;
    private final static int INDEX_LOGAUDITDETAIL = 58;
    private final static int INDEX_MEMO = 59;
    private final static int INDEX_MINORFIELDNAME = 60;
    private final static int INDEX_MINORFIELDVALUE = 61;
    private final static int INDEX_MINORTABLENAME = 62;
    private final static int INDEX_MUTLIMAJOR = 63;
    private final static int INDEX_NODATAINFO = 64;
    private final static int INDEX_PRINTFUNC = 65;
    private final static int INDEX_RESERVER = 66;
    private final static int INDEX_RESERVER2 = 67;
    private final static int INDEX_ROWAMOUT = 68;
    private final static int INDEX_RTINFO = 69;
    private final static int INDEX_SMALLICON = 70;
    private final static int INDEX_STORAGETYPE = 71;
    private final static int INDEX_TABLENAME = 72;
    private final static int INDEX_TABLESPACE = 73;
    private final static int INDEX_TIPSINFO = 74;
    private final static int INDEX_UPDATEDATE = 75;
    private final static int INDEX_UPDATEMAN = 76;
    private final static int INDEX_USERACTION = 77;
    private final static int INDEX_VALIDFLAG = 78;
    private final static int INDEX_VCFLAG = 79;
    private final static int INDEX_VERCHECKTIMER = 80;
    private final static int INDEX_VERFIELD = 81;
    private final static int INDEX_VERHELPER = 82;
    private final static int INDEX_VERSIONCHECK = 83;
    private final static int INDEX_VIEWNAME = 84;

    private final static HashMap<String, Integer> fieldIndexMap = new HashMap<String, Integer>();
    static {
        fieldIndexMap.put( FIELD_ACENABLEDP, INDEX_ACENABLEDP);
        fieldIndexMap.put( FIELD_ACEXTINFO, INDEX_ACEXTINFO);
        fieldIndexMap.put( FIELD_ACINFOFORMAT, INDEX_ACINFOFORMAT);
        fieldIndexMap.put( FIELD_ACINFOPARAM, INDEX_ACINFOPARAM);
        fieldIndexMap.put( FIELD_ACMAXCNT, INDEX_ACMAXCNT);
        fieldIndexMap.put( FIELD_ACOBJECT, INDEX_ACOBJECT);
        fieldIndexMap.put( FIELD_ACQUERYMODELID, INDEX_ACQUERYMODELID);
        fieldIndexMap.put( FIELD_ACQUERYMODELNAME, INDEX_ACQUERYMODELNAME);
        fieldIndexMap.put( FIELD_ACSORTDIR, INDEX_ACSORTDIR);
        fieldIndexMap.put( FIELD_ACSORTFIELD, INDEX_ACSORTFIELD);
        fieldIndexMap.put( FIELD_BIGICON, INDEX_BIGICON);
        fieldIndexMap.put( FIELD_CONFIGHELPER, INDEX_CONFIGHELPER);
        fieldIndexMap.put( FIELD_CREATEDATE, INDEX_CREATEDATE);
        fieldIndexMap.put( FIELD_CREATEMAN, INDEX_CREATEMAN);
        fieldIndexMap.put( FIELD_DATAACCOBJECT, INDEX_DATAACCOBJECT);
        fieldIndexMap.put( FIELD_DATACHGLOGMODE, INDEX_DATACHGLOGMODE);
        fieldIndexMap.put( FIELD_DATACTRLINT, INDEX_DATACTRLINT);
        fieldIndexMap.put( FIELD_DATACTRLOBJECT, INDEX_DATACTRLOBJECT);
        fieldIndexMap.put( FIELD_DATANOTIFYHELPER, INDEX_DATANOTIFYHELPER);
        fieldIndexMap.put( FIELD_DBSTORAGE, INDEX_DBSTORAGE);
        fieldIndexMap.put( FIELD_DBVERSION, INDEX_DBVERSION);
        fieldIndexMap.put( FIELD_DEGROUP, INDEX_DEGROUP);
        fieldIndexMap.put( FIELD_DEHELPER, INDEX_DEHELPER);
        fieldIndexMap.put( FIELD_DEID, INDEX_DEID);
        fieldIndexMap.put( FIELD_DELOGICNAME, INDEX_DELOGICNAME);
        fieldIndexMap.put( FIELD_DENAME, INDEX_DENAME);
        fieldIndexMap.put( FIELD_DEOBJECT, INDEX_DEOBJECT);
        fieldIndexMap.put( FIELD_DEORDER, INDEX_DEORDER);
        fieldIndexMap.put( FIELD_DEPARAM, INDEX_DEPARAM);
        fieldIndexMap.put( FIELD_DER11DEID, INDEX_DER11DEID);
        fieldIndexMap.put( FIELD_DER11DENAME, INDEX_DER11DENAME);
        fieldIndexMap.put( FIELD_DETYPE, INDEX_DETYPE);
        fieldIndexMap.put( FIELD_DEUSERPARAM, INDEX_DEUSERPARAM);
        fieldIndexMap.put( FIELD_DEVERSION, INDEX_DEVERSION);
        fieldIndexMap.put( FIELD_DGROWCLASSHELPER, INDEX_DGROWCLASSHELPER);
        fieldIndexMap.put( FIELD_DGSUMMARYHEIGHT, INDEX_DGSUMMARYHEIGHT);
        fieldIndexMap.put( FIELD_DLKHELPER, INDEX_DLKHELPER);
        fieldIndexMap.put( FIELD_DYNAMICINTERVAL, INDEX_DYNAMICINTERVAL);
        fieldIndexMap.put( FIELD_ENABLECOLPRIV, INDEX_ENABLECOLPRIV);
        fieldIndexMap.put( FIELD_ENABLEGLOBALMODEL, INDEX_ENABLEGLOBALMODEL);
        fieldIndexMap.put( FIELD_EXITINGMODEL, INDEX_EXITINGMODEL);
        fieldIndexMap.put( FIELD_EXPORTINCEMPTY, INDEX_EXPORTINCEMPTY);
        fieldIndexMap.put( FIELD_EXTABLENAME, INDEX_EXTABLENAME);
        fieldIndexMap.put( FIELD_GLOBALMODELOBJ, INDEX_GLOBALMODELOBJ);
        fieldIndexMap.put( FIELD_INDEXMODE, INDEX_INDEXMODE);
        fieldIndexMap.put( FIELD_INFOFIELD, INDEX_INFOFIELD);
        fieldIndexMap.put( FIELD_INFOFORMAT, INDEX_INFOFORMAT);
        fieldIndexMap.put( FIELD_INHERITMODE, INDEX_INHERITMODE);
        fieldIndexMap.put( FIELD_ISDGROWEDIT, INDEX_ISDGROWEDIT);
        fieldIndexMap.put( FIELD_ISENABLEAUDIT, INDEX_ISENABLEAUDIT);
        fieldIndexMap.put( FIELD_ISENABLEDP, INDEX_ISENABLEDP);
        fieldIndexMap.put( FIELD_ISINDEXDE, INDEX_ISINDEXDE);
        fieldIndexMap.put( FIELD_ISLOGICVALID, INDEX_ISLOGICVALID);
        fieldIndexMap.put( FIELD_ISMULTIPRINT, INDEX_ISMULTIPRINT);
        fieldIndexMap.put( FIELD_ISSUPPORTFA, INDEX_ISSUPPORTFA);
        fieldIndexMap.put( FIELD_ISSYSTEM, INDEX_ISSYSTEM);
        fieldIndexMap.put( FIELD_KEYPARAMS, INDEX_KEYPARAMS);
        fieldIndexMap.put( FIELD_LICENSECODE, INDEX_LICENSECODE);
        fieldIndexMap.put( FIELD_LOGAUDITDETAIL, INDEX_LOGAUDITDETAIL);
        fieldIndexMap.put( FIELD_MEMO, INDEX_MEMO);
        fieldIndexMap.put( FIELD_MINORFIELDNAME, INDEX_MINORFIELDNAME);
        fieldIndexMap.put( FIELD_MINORFIELDVALUE, INDEX_MINORFIELDVALUE);
        fieldIndexMap.put( FIELD_MINORTABLENAME, INDEX_MINORTABLENAME);
        fieldIndexMap.put( FIELD_MUTLIMAJOR, INDEX_MUTLIMAJOR);
        fieldIndexMap.put( FIELD_NODATAINFO, INDEX_NODATAINFO);
        fieldIndexMap.put( FIELD_PRINTFUNC, INDEX_PRINTFUNC);
        fieldIndexMap.put( FIELD_RESERVER, INDEX_RESERVER);
        fieldIndexMap.put( FIELD_RESERVER2, INDEX_RESERVER2);
        fieldIndexMap.put( FIELD_ROWAMOUT, INDEX_ROWAMOUT);
        fieldIndexMap.put( FIELD_RTINFO, INDEX_RTINFO);
        fieldIndexMap.put( FIELD_SMALLICON, INDEX_SMALLICON);
        fieldIndexMap.put( FIELD_STORAGETYPE, INDEX_STORAGETYPE);
        fieldIndexMap.put( FIELD_TABLENAME, INDEX_TABLENAME);
        fieldIndexMap.put( FIELD_TABLESPACE, INDEX_TABLESPACE);
        fieldIndexMap.put( FIELD_TIPSINFO, INDEX_TIPSINFO);
        fieldIndexMap.put( FIELD_UPDATEDATE, INDEX_UPDATEDATE);
        fieldIndexMap.put( FIELD_UPDATEMAN, INDEX_UPDATEMAN);
        fieldIndexMap.put( FIELD_USERACTION, INDEX_USERACTION);
        fieldIndexMap.put( FIELD_VALIDFLAG, INDEX_VALIDFLAG);
        fieldIndexMap.put( FIELD_VCFLAG, INDEX_VCFLAG);
        fieldIndexMap.put( FIELD_VERCHECKTIMER, INDEX_VERCHECKTIMER);
        fieldIndexMap.put( FIELD_VERFIELD, INDEX_VERFIELD);
        fieldIndexMap.put( FIELD_VERHELPER, INDEX_VERHELPER);
        fieldIndexMap.put( FIELD_VERSIONCHECK, INDEX_VERSIONCHECK);
        fieldIndexMap.put( FIELD_VIEWNAME, INDEX_VIEWNAME);
    }

    private DataEntityBase proxyDataEntityBase = null;
    public DataEntityBase() {
        super();
    }
    private boolean acenabledpDirtyFlag = false;
    private boolean acextinfoDirtyFlag = false;
    private boolean acinfoformatDirtyFlag = false;
    private boolean acinfoparamDirtyFlag = false;
    private boolean acmaxcntDirtyFlag = false;
    private boolean acobjectDirtyFlag = false;
    private boolean acquerymodelidDirtyFlag = false;
    private boolean acquerymodelnameDirtyFlag = false;
    private boolean acsortdirDirtyFlag = false;
    private boolean acsortfieldDirtyFlag = false;
    private boolean bigiconDirtyFlag = false;
    private boolean confighelperDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dataaccobjectDirtyFlag = false;
    private boolean datachglogmodeDirtyFlag = false;
    private boolean datactrlintDirtyFlag = false;
    private boolean datactrlobjectDirtyFlag = false;
    private boolean datanotifyhelperDirtyFlag = false;
    private boolean dbstorageDirtyFlag = false;
    private boolean dbversionDirtyFlag = false;
    private boolean degroupDirtyFlag = false;
    private boolean dehelperDirtyFlag = false;
    private boolean deidDirtyFlag = false;
    private boolean delogicnameDirtyFlag = false;
    private boolean denameDirtyFlag = false;
    private boolean deobjectDirtyFlag = false;
    private boolean deorderDirtyFlag = false;
    private boolean deparamDirtyFlag = false;
    private boolean der11deidDirtyFlag = false;
    private boolean der11denameDirtyFlag = false;
    private boolean detypeDirtyFlag = false;
    private boolean deuserparamDirtyFlag = false;
    private boolean deversionDirtyFlag = false;
    private boolean dgrowclasshelperDirtyFlag = false;
    private boolean dgsummaryheightDirtyFlag = false;
    private boolean dlkhelperDirtyFlag = false;
    private boolean dynamicintervalDirtyFlag = false;
    private boolean enablecolprivDirtyFlag = false;
    private boolean enableglobalmodelDirtyFlag = false;
    private boolean exitingmodelDirtyFlag = false;
    private boolean exportincemptyDirtyFlag = false;
    private boolean extablenameDirtyFlag = false;
    private boolean globalmodelobjDirtyFlag = false;
    private boolean indexmodeDirtyFlag = false;
    private boolean infofieldDirtyFlag = false;
    private boolean infoformatDirtyFlag = false;
    private boolean inheritmodeDirtyFlag = false;
    private boolean isdgroweditDirtyFlag = false;
    private boolean isenableauditDirtyFlag = false;
    private boolean isenabledpDirtyFlag = false;
    private boolean isindexdeDirtyFlag = false;
    private boolean islogicvalidDirtyFlag = false;
    private boolean ismultiprintDirtyFlag = false;
    private boolean issupportfaDirtyFlag = false;
    private boolean issystemDirtyFlag = false;
    private boolean keyparamsDirtyFlag = false;
    private boolean licensecodeDirtyFlag = false;
    private boolean logauditdetailDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean minorfieldnameDirtyFlag = false;
    private boolean minorfieldvalueDirtyFlag = false;
    private boolean minortablenameDirtyFlag = false;
    private boolean mutlimajorDirtyFlag = false;
    private boolean nodatainfoDirtyFlag = false;
    private boolean printfuncDirtyFlag = false;
    private boolean reserverDirtyFlag = false;
    private boolean reserver2DirtyFlag = false;
    private boolean rowamoutDirtyFlag = false;
    private boolean rtinfoDirtyFlag = false;
    private boolean smalliconDirtyFlag = false;
    private boolean storagetypeDirtyFlag = false;
    private boolean tablenameDirtyFlag = false;
    private boolean tablespaceDirtyFlag = false;
    private boolean tipsinfoDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean useractionDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    private boolean vcflagDirtyFlag = false;
    private boolean verchecktimerDirtyFlag = false;
    private boolean verfieldDirtyFlag = false;
    private boolean verhelperDirtyFlag = false;
    private boolean versioncheckDirtyFlag = false;
    private boolean viewnameDirtyFlag = false;

    @Column(name="acenabledp")
    private Integer acenabledp;
    @Column(name="acextinfo")
    private String acextinfo;
    @Column(name="acinfoformat")
    private String acinfoformat;
    @Column(name="acinfoparam")
    private String acinfoparam;
    @Column(name="acmaxcnt")
    private Integer acmaxcnt;
    @Column(name="acobject")
    private String acobject;
    @Column(name="acquerymodelid")
    private String acquerymodelid;
    @Column(name="acquerymodelname")
    private String acquerymodelname;
    @Column(name="acsortdir")
    private String acsortdir;
    @Column(name="acsortfield")
    private String acsortfield;
    @Column(name="bigicon")
    private String bigicon;
    @Column(name="confighelper")
    private String confighelper;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dataaccobject")
    private String dataaccobject;
    @Column(name="datachglogmode")
    private Integer datachglogmode;
    @Column(name="datactrlint")
    private String datactrlint;
    @Column(name="datactrlobject")
    private String datactrlobject;
    @Column(name="datanotifyhelper")
    private String datanotifyhelper;
    @Column(name="dbstorage")
    private String dbstorage;
    @Column(name="dbversion")
    private Integer dbversion;
    @Column(name="degroup")
    private String degroup;
    @Column(name="dehelper")
    private String dehelper;
    @Column(name="deid")
    private String deid;
    @Column(name="delogicname")
    private String delogicname;
    @Column(name="dename")
    private String dename;
    @Column(name="deobject")
    private String deobject;
    @Column(name="deorder")
    private Integer deorder;
    @Column(name="deparam")
    private String deparam;
    @Column(name="der11deid")
    private String der11deid;
    @Column(name="der11dename")
    private String der11dename;
    @Column(name="detype")
    private Integer detype;
    @Column(name="deuserparam")
    private String deuserparam;
    @Column(name="deversion")
    private Integer deversion;
    @Column(name="dgrowclasshelper")
    private String dgrowclasshelper;
    @Column(name="dgsummaryheight")
    private Integer dgsummaryheight;
    @Column(name="dlkhelper")
    private String dlkhelper;
    @Column(name="dynamicinterval")
    private Integer dynamicinterval;
    @Column(name="enablecolpriv")
    private Integer enablecolpriv;
    @Column(name="enableglobalmodel")
    private Integer enableglobalmodel;
    @Column(name="exitingmodel")
    private Integer exitingmodel;
    @Column(name="exportincempty")
    private Integer exportincempty;
    @Column(name="extablename")
    private String extablename;
    @Column(name="globalmodelobj")
    private String globalmodelobj;
    @Column(name="indexmode")
    private Integer indexmode;
    @Column(name="infofield")
    private String infofield;
    @Column(name="infoformat")
    private String infoformat;
    @Column(name="inheritmode")
    private Integer inheritmode;
    @Column(name="isdgrowedit")
    private Integer isdgrowedit;
    @Column(name="isenableaudit")
    private Integer isenableaudit;
    @Column(name="isenabledp")
    private Integer isenabledp;
    @Column(name="isindexde")
    private Integer isindexde;
    @Column(name="islogicvalid")
    private Integer islogicvalid;
    @Column(name="ismultiprint")
    private Integer ismultiprint;
    @Column(name="issupportfa")
    private Integer issupportfa;
    @Column(name="issystem")
    private Integer issystem;
    @Column(name="keyparams")
    private String keyparams;
    @Column(name="licensecode")
    private String licensecode;
    @Column(name="logauditdetail")
    private Integer logauditdetail;
    @Column(name="memo")
    private String memo;
    @Column(name="minorfieldname")
    private String minorfieldname;
    @Column(name="minorfieldvalue")
    private String minorfieldvalue;
    @Column(name="minortablename")
    private String minortablename;
    @Column(name="mutlimajor")
    private Integer mutlimajor;
    @Column(name="nodatainfo")
    private Integer nodatainfo;
    @Column(name="printfunc")
    private String printfunc;
    @Column(name="reserver")
    private String reserver;
    @Column(name="reserver2")
    private String reserver2;
    @Column(name="rowamout")
    private Integer rowamout;
    @Column(name="rtinfo")
    private String rtinfo;
    @Column(name="smallicon")
    private String smallicon;
    @Column(name="storagetype")
    private String storagetype;
    @Column(name="tablename")
    private String tablename;
    @Column(name="tablespace")
    private String tablespace;
    @Column(name="tipsinfo")
    private String tipsinfo;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="useraction")
    private Integer useraction;
    @Column(name="validflag")
    private Integer validflag;
    @Column(name="vcflag")
    private Integer vcflag;
    @Column(name="verchecktimer")
    private Integer verchecktimer;
    @Column(name="verfield")
    private String verfield;
    @Column(name="verhelper")
    private String verhelper;
    @Column(name="versioncheck")
    private Integer versioncheck;
    @Column(name="viewname")
    private String viewname;


    /**
     *  设置属性值[启动自填数据权限]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     *  @param acenabledp
     */
    public void setACEnableDP(Integer acenabledp) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setACEnableDP(acenabledp);
            return;
        }
        this.acenabledp = acenabledp;
        this.acenabledpDirtyFlag  = true;
    }

    /**
     *  获取属性值[启动自填数据权限]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     */
    public Integer getACEnableDP() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getACEnableDP();
        }
        return this.acenabledp;
    }

    /**
     *  获取属性值[启动自填数据权限]是否修改
     */
    public boolean isACEnableDPDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isACEnableDPDirty();
        }
        return this.acenabledpDirtyFlag;
    }

    /**
     *  重置属性值[启动自填数据权限]
     */
    public void resetACEnableDP() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetACEnableDP();
            return;
        }

        this.acenabledpDirtyFlag = false;
        this.acenabledp = null;
    }
    /**
     *  设置属性值[自动填充附加信息]
     *  @param acextinfo
     */
    public void setACExtInfo(String acextinfo) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setACExtInfo(acextinfo);
            return;
        }
        if(acextinfo!=null) {
            acextinfo = StringHelper.trimRight(acextinfo);
            if(acextinfo.length()==0) {
                acextinfo = null;
            }
        }
        this.acextinfo = acextinfo;
        this.acextinfoDirtyFlag  = true;
    }

    /**
     *  获取属性值[自动填充附加信息]
     */
    public String getACExtInfo() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getACExtInfo();
        }
        return this.acextinfo;
    }

    /**
     *  获取属性值[自动填充附加信息]是否修改
     */
    public boolean isACExtInfoDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isACExtInfoDirty();
        }
        return this.acextinfoDirtyFlag;
    }

    /**
     *  重置属性值[自动填充附加信息]
     */
    public void resetACExtInfo() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetACExtInfo();
            return;
        }

        this.acextinfoDirtyFlag = false;
        this.acextinfo = null;
    }
    /**
     *  设置属性值[自动填充信息格式]
     *  @param acinfoformat
     */
    public void setACInfoFormat(String acinfoformat) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setACInfoFormat(acinfoformat);
            return;
        }
        if(acinfoformat!=null) {
            acinfoformat = StringHelper.trimRight(acinfoformat);
            if(acinfoformat.length()==0) {
                acinfoformat = null;
            }
        }
        this.acinfoformat = acinfoformat;
        this.acinfoformatDirtyFlag  = true;
    }

    /**
     *  获取属性值[自动填充信息格式]
     */
    public String getACInfoFormat() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getACInfoFormat();
        }
        return this.acinfoformat;
    }

    /**
     *  获取属性值[自动填充信息格式]是否修改
     */
    public boolean isACInfoFormatDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isACInfoFormatDirty();
        }
        return this.acinfoformatDirtyFlag;
    }

    /**
     *  重置属性值[自动填充信息格式]
     */
    public void resetACInfoFormat() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetACInfoFormat();
            return;
        }

        this.acinfoformatDirtyFlag = false;
        this.acinfoformat = null;
    }
    /**
     *  设置属性值[自动填充信息参数]
     *  @param acinfoparam
     */
    public void setACInfoParam(String acinfoparam) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setACInfoParam(acinfoparam);
            return;
        }
        if(acinfoparam!=null) {
            acinfoparam = StringHelper.trimRight(acinfoparam);
            if(acinfoparam.length()==0) {
                acinfoparam = null;
            }
        }
        this.acinfoparam = acinfoparam;
        this.acinfoparamDirtyFlag  = true;
    }

    /**
     *  获取属性值[自动填充信息参数]
     */
    public String getACInfoParam() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getACInfoParam();
        }
        return this.acinfoparam;
    }

    /**
     *  获取属性值[自动填充信息参数]是否修改
     */
    public boolean isACInfoParamDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isACInfoParamDirty();
        }
        return this.acinfoparamDirtyFlag;
    }

    /**
     *  重置属性值[自动填充信息参数]
     */
    public void resetACInfoParam() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetACInfoParam();
            return;
        }

        this.acinfoparamDirtyFlag = false;
        this.acinfoparam = null;
    }
    /**
     *  设置属性值[自填最大数量]
     *  @param acmaxcnt
     */
    public void setACMaxCnt(Integer acmaxcnt) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setACMaxCnt(acmaxcnt);
            return;
        }
        this.acmaxcnt = acmaxcnt;
        this.acmaxcntDirtyFlag  = true;
    }

    /**
     *  获取属性值[自填最大数量]
     */
    public Integer getACMaxCnt() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getACMaxCnt();
        }
        return this.acmaxcnt;
    }

    /**
     *  获取属性值[自填最大数量]是否修改
     */
    public boolean isACMaxCntDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isACMaxCntDirty();
        }
        return this.acmaxcntDirtyFlag;
    }

    /**
     *  重置属性值[自填最大数量]
     */
    public void resetACMaxCnt() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetACMaxCnt();
            return;
        }

        this.acmaxcntDirtyFlag = false;
        this.acmaxcnt = null;
    }
    /**
     *  设置属性值[自动填充处理对象]
     *  @param acobject
     */
    public void setACObject(String acobject) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setACObject(acobject);
            return;
        }
        if(acobject!=null) {
            acobject = StringHelper.trimRight(acobject);
            if(acobject.length()==0) {
                acobject = null;
            }
        }
        this.acobject = acobject;
        this.acobjectDirtyFlag  = true;
    }

    /**
     *  获取属性值[自动填充处理对象]
     */
    public String getACObject() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getACObject();
        }
        return this.acobject;
    }

    /**
     *  获取属性值[自动填充处理对象]是否修改
     */
    public boolean isACObjectDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isACObjectDirty();
        }
        return this.acobjectDirtyFlag;
    }

    /**
     *  重置属性值[自动填充处理对象]
     */
    public void resetACObject() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetACObject();
            return;
        }

        this.acobjectDirtyFlag = false;
        this.acobject = null;
    }
    /**
     *  设置属性值[数据实体_自填查询模型]
     *  @param acquerymodelid
     */
    public void setACQueryModelId(String acquerymodelid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setACQueryModelId(acquerymodelid);
            return;
        }
        if(acquerymodelid!=null) {
            acquerymodelid = StringHelper.trimRight(acquerymodelid);
            if(acquerymodelid.length()==0) {
                acquerymodelid = null;
            }
        }
        this.acquerymodelid = acquerymodelid;
        this.acquerymodelidDirtyFlag  = true;
    }

    /**
     *  获取属性值[数据实体_自填查询模型]
     */
    public String getACQueryModelId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getACQueryModelId();
        }
        return this.acquerymodelid;
    }

    /**
     *  获取属性值[数据实体_自填查询模型]是否修改
     */
    public boolean isACQueryModelIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isACQueryModelIdDirty();
        }
        return this.acquerymodelidDirtyFlag;
    }

    /**
     *  重置属性值[数据实体_自填查询模型]
     */
    public void resetACQueryModelId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetACQueryModelId();
            return;
        }

        this.acquerymodelidDirtyFlag = false;
        this.acquerymodelid = null;
    }
    /**
     *  设置属性值[自填查询模型]
     *  @param acquerymodelname
     */
    public void setACQueryModelName(String acquerymodelname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setACQueryModelName(acquerymodelname);
            return;
        }
        if(acquerymodelname!=null) {
            acquerymodelname = StringHelper.trimRight(acquerymodelname);
            if(acquerymodelname.length()==0) {
                acquerymodelname = null;
            }
        }
        this.acquerymodelname = acquerymodelname;
        this.acquerymodelnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[自填查询模型]
     */
    public String getACQueryModelName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getACQueryModelName();
        }
        return this.acquerymodelname;
    }

    /**
     *  获取属性值[自填查询模型]是否修改
     */
    public boolean isACQueryModelNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isACQueryModelNameDirty();
        }
        return this.acquerymodelnameDirtyFlag;
    }

    /**
     *  重置属性值[自填查询模型]
     */
    public void resetACQueryModelName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetACQueryModelName();
            return;
        }

        this.acquerymodelnameDirtyFlag = false;
        this.acquerymodelname = null;
    }
    /**
     *  设置属性值[自动排序方向]代码表：net.ibizsys.psrt.srv.codelist.CodeList25CodeListModel
     *  @param acsortdir
     */
    public void setACSortDir(String acsortdir) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setACSortDir(acsortdir);
            return;
        }
        if(acsortdir!=null) {
            acsortdir = StringHelper.trimRight(acsortdir);
            if(acsortdir.length()==0) {
                acsortdir = null;
            }
        }
        this.acsortdir = acsortdir;
        this.acsortdirDirtyFlag  = true;
    }

    /**
     *  获取属性值[自动排序方向]代码表：net.ibizsys.psrt.srv.codelist.CodeList25CodeListModel
     */
    public String getACSortDir() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getACSortDir();
        }
        return this.acsortdir;
    }

    /**
     *  获取属性值[自动排序方向]是否修改
     */
    public boolean isACSortDirDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isACSortDirDirty();
        }
        return this.acsortdirDirtyFlag;
    }

    /**
     *  重置属性值[自动排序方向]
     */
    public void resetACSortDir() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetACSortDir();
            return;
        }

        this.acsortdirDirtyFlag = false;
        this.acsortdir = null;
    }
    /**
     *  设置属性值[自填排序字段]
     *  @param acsortfield
     */
    public void setACSortField(String acsortfield) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setACSortField(acsortfield);
            return;
        }
        if(acsortfield!=null) {
            acsortfield = StringHelper.trimRight(acsortfield);
            if(acsortfield.length()==0) {
                acsortfield = null;
            }
        }
        this.acsortfield = acsortfield;
        this.acsortfieldDirtyFlag  = true;
    }

    /**
     *  获取属性值[自填排序字段]
     */
    public String getACSortField() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getACSortField();
        }
        return this.acsortfield;
    }

    /**
     *  获取属性值[自填排序字段]是否修改
     */
    public boolean isACSortFieldDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isACSortFieldDirty();
        }
        return this.acsortfieldDirtyFlag;
    }

    /**
     *  重置属性值[自填排序字段]
     */
    public void resetACSortField() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetACSortField();
            return;
        }

        this.acsortfieldDirtyFlag = false;
        this.acsortfield = null;
    }
    /**
     *  设置属性值[大图标]
     *  @param bigicon
     */
    public void setBigIcon(String bigicon) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setBigIcon(bigicon);
            return;
        }
        if(bigicon!=null) {
            bigicon = StringHelper.trimRight(bigicon);
            if(bigicon.length()==0) {
                bigicon = null;
            }
        }
        this.bigicon = bigicon;
        this.bigiconDirtyFlag  = true;
    }

    /**
     *  获取属性值[大图标]
     */
    public String getBigIcon() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getBigIcon();
        }
        return this.bigicon;
    }

    /**
     *  获取属性值[大图标]是否修改
     */
    public boolean isBigIconDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isBigIconDirty();
        }
        return this.bigiconDirtyFlag;
    }

    /**
     *  重置属性值[大图标]
     */
    public void resetBigIcon() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetBigIcon();
            return;
        }

        this.bigiconDirtyFlag = false;
        this.bigicon = null;
    }
    /**
     *  设置属性值[配置辅助对象]
     *  @param confighelper
     */
    public void setConfigHelper(String confighelper) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setConfigHelper(confighelper);
            return;
        }
        if(confighelper!=null) {
            confighelper = StringHelper.trimRight(confighelper);
            if(confighelper.length()==0) {
                confighelper = null;
            }
        }
        this.confighelper = confighelper;
        this.confighelperDirtyFlag  = true;
    }

    /**
     *  获取属性值[配置辅助对象]
     */
    public String getConfigHelper() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getConfigHelper();
        }
        return this.confighelper;
    }

    /**
     *  获取属性值[配置辅助对象]是否修改
     */
    public boolean isConfigHelperDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isConfigHelperDirty();
        }
        return this.confighelperDirtyFlag;
    }

    /**
     *  重置属性值[配置辅助对象]
     */
    public void resetConfigHelper() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetConfigHelper();
            return;
        }

        this.confighelperDirtyFlag = false;
        this.confighelper = null;
    }
    /**
     *  设置属性值[建立时间]
     *  @param createdate
     */
    public void setCreateDate(Timestamp createdate) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setCreateDate(createdate);
            return;
        }
        this.createdate = createdate;
        this.createdateDirtyFlag  = true;
    }

    /**
     *  获取属性值[建立时间]
     */
    public Timestamp getCreateDate() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getCreateDate();
        }
        return this.createdate;
    }

    /**
     *  获取属性值[建立时间]是否修改
     */
    public boolean isCreateDateDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isCreateDateDirty();
        }
        return this.createdateDirtyFlag;
    }

    /**
     *  重置属性值[建立时间]
     */
    public void resetCreateDate() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetCreateDate();
            return;
        }

        this.createdateDirtyFlag = false;
        this.createdate = null;
    }
    /**
     *  设置属性值[建立人]代码表：net.ibizsys.psrt.srv.codelist.SysOperatorCodeListModel
     *  @param createman
     */
    public void setCreateMan(String createman) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setCreateMan(createman);
            return;
        }
        if(createman!=null) {
            createman = StringHelper.trimRight(createman);
            if(createman.length()==0) {
                createman = null;
            }
        }
        this.createman = createman;
        this.createmanDirtyFlag  = true;
    }

    /**
     *  获取属性值[建立人]代码表：net.ibizsys.psrt.srv.codelist.SysOperatorCodeListModel
     */
    public String getCreateMan() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getCreateMan();
        }
        return this.createman;
    }

    /**
     *  获取属性值[建立人]是否修改
     */
    public boolean isCreateManDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isCreateManDirty();
        }
        return this.createmanDirtyFlag;
    }

    /**
     *  重置属性值[建立人]
     */
    public void resetCreateMan() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetCreateMan();
            return;
        }

        this.createmanDirtyFlag = false;
        this.createman = null;
    }
    /**
     *  设置属性值[数据访问控制对象]
     *  @param dataaccobject
     */
    public void setDataAccObject(String dataaccobject) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setDataAccObject(dataaccobject);
            return;
        }
        if(dataaccobject!=null) {
            dataaccobject = StringHelper.trimRight(dataaccobject);
            if(dataaccobject.length()==0) {
                dataaccobject = null;
            }
        }
        this.dataaccobject = dataaccobject;
        this.dataaccobjectDirtyFlag  = true;
    }

    /**
     *  获取属性值[数据访问控制对象]
     */
    public String getDataAccObject() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDataAccObject();
        }
        return this.dataaccobject;
    }

    /**
     *  获取属性值[数据访问控制对象]是否修改
     */
    public boolean isDataAccObjectDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isDataAccObjectDirty();
        }
        return this.dataaccobjectDirtyFlag;
    }

    /**
     *  重置属性值[数据访问控制对象]
     */
    public void resetDataAccObject() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetDataAccObject();
            return;
        }

        this.dataaccobjectDirtyFlag = false;
        this.dataaccobject = null;
    }
    /**
     *  设置属性值[数据变更日志类型]代码表：net.ibizsys.psrt.srv.codelist.DEDataChgLogTypeCodeListModel
     *  @param datachglogmode
     */
    public void setDataChgLogMode(Integer datachglogmode) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setDataChgLogMode(datachglogmode);
            return;
        }
        this.datachglogmode = datachglogmode;
        this.datachglogmodeDirtyFlag  = true;
    }

    /**
     *  获取属性值[数据变更日志类型]代码表：net.ibizsys.psrt.srv.codelist.DEDataChgLogTypeCodeListModel
     */
    public Integer getDataChgLogMode() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDataChgLogMode();
        }
        return this.datachglogmode;
    }

    /**
     *  获取属性值[数据变更日志类型]是否修改
     */
    public boolean isDataChgLogModeDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isDataChgLogModeDirty();
        }
        return this.datachglogmodeDirtyFlag;
    }

    /**
     *  重置属性值[数据变更日志类型]
     */
    public void resetDataChgLogMode() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetDataChgLogMode();
            return;
        }

        this.datachglogmodeDirtyFlag = false;
        this.datachglogmode = null;
    }
    /**
     *  设置属性值[数据访问对象接口]
     *  @param datactrlint
     */
    public void setDataCtrlInt(String datactrlint) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setDataCtrlInt(datactrlint);
            return;
        }
        if(datactrlint!=null) {
            datactrlint = StringHelper.trimRight(datactrlint);
            if(datactrlint.length()==0) {
                datactrlint = null;
            }
        }
        this.datactrlint = datactrlint;
        this.datactrlintDirtyFlag  = true;
    }

    /**
     *  获取属性值[数据访问对象接口]
     */
    public String getDataCtrlInt() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDataCtrlInt();
        }
        return this.datactrlint;
    }

    /**
     *  获取属性值[数据访问对象接口]是否修改
     */
    public boolean isDataCtrlIntDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isDataCtrlIntDirty();
        }
        return this.datactrlintDirtyFlag;
    }

    /**
     *  重置属性值[数据访问对象接口]
     */
    public void resetDataCtrlInt() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetDataCtrlInt();
            return;
        }

        this.datactrlintDirtyFlag = false;
        this.datactrlint = null;
    }
    /**
     *  设置属性值[数据访问对象]
     *  @param datactrlobject
     */
    public void setDataCtrlObject(String datactrlobject) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setDataCtrlObject(datactrlobject);
            return;
        }
        if(datactrlobject!=null) {
            datactrlobject = StringHelper.trimRight(datactrlobject);
            if(datactrlobject.length()==0) {
                datactrlobject = null;
            }
        }
        this.datactrlobject = datactrlobject;
        this.datactrlobjectDirtyFlag  = true;
    }

    /**
     *  获取属性值[数据访问对象]
     */
    public String getDataCtrlObject() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDataCtrlObject();
        }
        return this.datactrlobject;
    }

    /**
     *  获取属性值[数据访问对象]是否修改
     */
    public boolean isDataCtrlObjectDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isDataCtrlObjectDirty();
        }
        return this.datactrlobjectDirtyFlag;
    }

    /**
     *  重置属性值[数据访问对象]
     */
    public void resetDataCtrlObject() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetDataCtrlObject();
            return;
        }

        this.datactrlobjectDirtyFlag = false;
        this.datactrlobject = null;
    }
    /**
     *  设置属性值[数据通知辅助对象]
     *  @param datanotifyhelper
     */
    public void setDataNotifyHelper(String datanotifyhelper) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setDataNotifyHelper(datanotifyhelper);
            return;
        }
        if(datanotifyhelper!=null) {
            datanotifyhelper = StringHelper.trimRight(datanotifyhelper);
            if(datanotifyhelper.length()==0) {
                datanotifyhelper = null;
            }
        }
        this.datanotifyhelper = datanotifyhelper;
        this.datanotifyhelperDirtyFlag  = true;
    }

    /**
     *  获取属性值[数据通知辅助对象]
     */
    public String getDataNotifyHelper() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDataNotifyHelper();
        }
        return this.datanotifyhelper;
    }

    /**
     *  获取属性值[数据通知辅助对象]是否修改
     */
    public boolean isDataNotifyHelperDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isDataNotifyHelperDirty();
        }
        return this.datanotifyhelperDirtyFlag;
    }

    /**
     *  重置属性值[数据通知辅助对象]
     */
    public void resetDataNotifyHelper() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetDataNotifyHelper();
            return;
        }

        this.datanotifyhelperDirtyFlag = false;
        this.datanotifyhelper = null;
    }
    /**
     *  设置属性值[数据库存储]代码表：net.ibizsys.psrt.srv.codelist.CodeList105CodeListModel
     *  @param dbstorage
     */
    public void setDBStorage(String dbstorage) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setDBStorage(dbstorage);
            return;
        }
        if(dbstorage!=null) {
            dbstorage = StringHelper.trimRight(dbstorage);
            if(dbstorage.length()==0) {
                dbstorage = null;
            }
        }
        this.dbstorage = dbstorage;
        this.dbstorageDirtyFlag  = true;
    }

    /**
     *  获取属性值[数据库存储]代码表：net.ibizsys.psrt.srv.codelist.CodeList105CodeListModel
     */
    public String getDBStorage() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDBStorage();
        }
        return this.dbstorage;
    }

    /**
     *  获取属性值[数据库存储]是否修改
     */
    public boolean isDBStorageDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isDBStorageDirty();
        }
        return this.dbstorageDirtyFlag;
    }

    /**
     *  重置属性值[数据库存储]
     */
    public void resetDBStorage() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetDBStorage();
            return;
        }

        this.dbstorageDirtyFlag = false;
        this.dbstorage = null;
    }
    /**
     *  设置属性值[数据结构版本]
     *  @param dbversion
     */
    public void setDBVersion(Integer dbversion) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setDBVersion(dbversion);
            return;
        }
        this.dbversion = dbversion;
        this.dbversionDirtyFlag  = true;
    }

    /**
     *  获取属性值[数据结构版本]
     */
    public Integer getDBVersion() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDBVersion();
        }
        return this.dbversion;
    }

    /**
     *  获取属性值[数据结构版本]是否修改
     */
    public boolean isDBVersionDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isDBVersionDirty();
        }
        return this.dbversionDirtyFlag;
    }

    /**
     *  重置属性值[数据结构版本]
     */
    public void resetDBVersion() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetDBVersion();
            return;
        }

        this.dbversionDirtyFlag = false;
        this.dbversion = null;
    }
    /**
     *  设置属性值[实体归属]代码表：net.ibizsys.psrt.srv.codelist.CodeList19CodeListModel
     *  @param degroup
     */
    public void setDEGroup(String degroup) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setDEGroup(degroup);
            return;
        }
        if(degroup!=null) {
            degroup = StringHelper.trimRight(degroup);
            if(degroup.length()==0) {
                degroup = null;
            }
        }
        this.degroup = degroup;
        this.degroupDirtyFlag  = true;
    }

    /**
     *  获取属性值[实体归属]代码表：net.ibizsys.psrt.srv.codelist.CodeList19CodeListModel
     */
    public String getDEGroup() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDEGroup();
        }
        return this.degroup;
    }

    /**
     *  获取属性值[实体归属]是否修改
     */
    public boolean isDEGroupDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isDEGroupDirty();
        }
        return this.degroupDirtyFlag;
    }

    /**
     *  重置属性值[实体归属]
     */
    public void resetDEGroup() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetDEGroup();
            return;
        }

        this.degroupDirtyFlag = false;
        this.degroup = null;
    }
    /**
     *  设置属性值[实体辅助对象]
     *  @param dehelper
     */
    public void setDEHelper(String dehelper) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setDEHelper(dehelper);
            return;
        }
        if(dehelper!=null) {
            dehelper = StringHelper.trimRight(dehelper);
            if(dehelper.length()==0) {
                dehelper = null;
            }
        }
        this.dehelper = dehelper;
        this.dehelperDirtyFlag  = true;
    }

    /**
     *  获取属性值[实体辅助对象]
     */
    public String getDEHelper() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDEHelper();
        }
        return this.dehelper;
    }

    /**
     *  获取属性值[实体辅助对象]是否修改
     */
    public boolean isDEHelperDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isDEHelperDirty();
        }
        return this.dehelperDirtyFlag;
    }

    /**
     *  重置属性值[实体辅助对象]
     */
    public void resetDEHelper() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetDEHelper();
            return;
        }

        this.dehelperDirtyFlag = false;
        this.dehelper = null;
    }
    /**
     *  设置属性值[实体标识]
     *  @param deid
     */
    public void setDEId(String deid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setDEId(deid);
            return;
        }
        if(deid!=null) {
            deid = StringHelper.trimRight(deid);
            if(deid.length()==0) {
                deid = null;
            }
        }
        this.deid = deid;
        this.deidDirtyFlag  = true;
    }

    /**
     *  获取属性值[实体标识]
     */
    public String getDEId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDEId();
        }
        return this.deid;
    }

    /**
     *  获取属性值[实体标识]是否修改
     */
    public boolean isDEIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isDEIdDirty();
        }
        return this.deidDirtyFlag;
    }

    /**
     *  重置属性值[实体标识]
     */
    public void resetDEId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetDEId();
            return;
        }

        this.deidDirtyFlag = false;
        this.deid = null;
    }
    /**
     *  设置属性值[逻辑名称]
     *  @param delogicname
     */
    public void setDELogicName(String delogicname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setDELogicName(delogicname);
            return;
        }
        if(delogicname!=null) {
            delogicname = StringHelper.trimRight(delogicname);
            if(delogicname.length()==0) {
                delogicname = null;
            }
        }
        this.delogicname = delogicname;
        this.delogicnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[逻辑名称]
     */
    public String getDELogicName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDELogicName();
        }
        return this.delogicname;
    }

    /**
     *  获取属性值[逻辑名称]是否修改
     */
    public boolean isDELogicNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isDELogicNameDirty();
        }
        return this.delogicnameDirtyFlag;
    }

    /**
     *  重置属性值[逻辑名称]
     */
    public void resetDELogicName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetDELogicName();
            return;
        }

        this.delogicnameDirtyFlag = false;
        this.delogicname = null;
    }
    /**
     *  设置属性值[实体名称]
     *  @param dename
     */
    public void setDEName(String dename) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setDEName(dename);
            return;
        }
        if(dename!=null) {
            dename = StringHelper.trimRight(dename);
            if(dename.length()==0) {
                dename = null;
            }
        }
        this.dename = dename;
        this.denameDirtyFlag  = true;
    }

    /**
     *  获取属性值[实体名称]
     */
    public String getDEName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDEName();
        }
        return this.dename;
    }

    /**
     *  获取属性值[实体名称]是否修改
     */
    public boolean isDENameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isDENameDirty();
        }
        return this.denameDirtyFlag;
    }

    /**
     *  重置属性值[实体名称]
     */
    public void resetDEName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetDEName();
            return;
        }

        this.denameDirtyFlag = false;
        this.dename = null;
    }
    /**
     *  设置属性值[数据对象类]
     *  @param deobject
     */
    public void setDEObject(String deobject) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setDEObject(deobject);
            return;
        }
        if(deobject!=null) {
            deobject = StringHelper.trimRight(deobject);
            if(deobject.length()==0) {
                deobject = null;
            }
        }
        this.deobject = deobject;
        this.deobjectDirtyFlag  = true;
    }

    /**
     *  获取属性值[数据对象类]
     */
    public String getDEObject() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDEObject();
        }
        return this.deobject;
    }

    /**
     *  获取属性值[数据对象类]是否修改
     */
    public boolean isDEObjectDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isDEObjectDirty();
        }
        return this.deobjectDirtyFlag;
    }

    /**
     *  重置属性值[数据对象类]
     */
    public void resetDEObject() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetDEObject();
            return;
        }

        this.deobjectDirtyFlag = false;
        this.deobject = null;
    }
    /**
     *  设置属性值[实体次序]
     *  @param deorder
     */
    public void setDEOrder(Integer deorder) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setDEOrder(deorder);
            return;
        }
        this.deorder = deorder;
        this.deorderDirtyFlag  = true;
    }

    /**
     *  获取属性值[实体次序]
     */
    public Integer getDEOrder() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDEOrder();
        }
        return this.deorder;
    }

    /**
     *  获取属性值[实体次序]是否修改
     */
    public boolean isDEOrderDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isDEOrderDirty();
        }
        return this.deorderDirtyFlag;
    }

    /**
     *  重置属性值[实体次序]
     */
    public void resetDEOrder() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetDEOrder();
            return;
        }

        this.deorderDirtyFlag = false;
        this.deorder = null;
    }
    /**
     *  设置属性值[实体参数]
     *  @param deparam
     */
    public void setDEParam(String deparam) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setDEParam(deparam);
            return;
        }
        if(deparam!=null) {
            deparam = StringHelper.trimRight(deparam);
            if(deparam.length()==0) {
                deparam = null;
            }
        }
        this.deparam = deparam;
        this.deparamDirtyFlag  = true;
    }

    /**
     *  获取属性值[实体参数]
     */
    public String getDEParam() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDEParam();
        }
        return this.deparam;
    }

    /**
     *  获取属性值[实体参数]是否修改
     */
    public boolean isDEParamDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isDEParamDirty();
        }
        return this.deparamDirtyFlag;
    }

    /**
     *  重置属性值[实体参数]
     */
    public void resetDEParam() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetDEParam();
            return;
        }

        this.deparamDirtyFlag = false;
        this.deparam = null;
    }
    /**
     *  设置属性值[1:1关系实体]
     *  @param der11deid
     */
    public void setDER11DEId(String der11deid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setDER11DEId(der11deid);
            return;
        }
        if(der11deid!=null) {
            der11deid = StringHelper.trimRight(der11deid);
            if(der11deid.length()==0) {
                der11deid = null;
            }
        }
        this.der11deid = der11deid;
        this.der11deidDirtyFlag  = true;
    }

    /**
     *  获取属性值[1:1关系实体]
     */
    public String getDER11DEId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDER11DEId();
        }
        return this.der11deid;
    }

    /**
     *  获取属性值[1:1关系实体]是否修改
     */
    public boolean isDER11DEIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isDER11DEIdDirty();
        }
        return this.der11deidDirtyFlag;
    }

    /**
     *  重置属性值[1:1关系实体]
     */
    public void resetDER11DEId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetDER11DEId();
            return;
        }

        this.der11deidDirtyFlag = false;
        this.der11deid = null;
    }
    /**
     *  设置属性值[DER11DENAME]
     *  @param der11dename
     */
    public void setDER11DEName(String der11dename) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setDER11DEName(der11dename);
            return;
        }
        if(der11dename!=null) {
            der11dename = StringHelper.trimRight(der11dename);
            if(der11dename.length()==0) {
                der11dename = null;
            }
        }
        this.der11dename = der11dename;
        this.der11denameDirtyFlag  = true;
    }

    /**
     *  获取属性值[DER11DENAME]
     */
    public String getDER11DEName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDER11DEName();
        }
        return this.der11dename;
    }

    /**
     *  获取属性值[DER11DENAME]是否修改
     */
    public boolean isDER11DENameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isDER11DENameDirty();
        }
        return this.der11denameDirtyFlag;
    }

    /**
     *  重置属性值[DER11DENAME]
     */
    public void resetDER11DEName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetDER11DEName();
            return;
        }

        this.der11denameDirtyFlag = false;
        this.der11dename = null;
    }
    /**
     *  设置属性值[实体类型]
     *  @param detype
     */
    public void setDEType(Integer detype) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setDEType(detype);
            return;
        }
        this.detype = detype;
        this.detypeDirtyFlag  = true;
    }

    /**
     *  获取属性值[实体类型]
     */
    public Integer getDEType() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDEType();
        }
        return this.detype;
    }

    /**
     *  获取属性值[实体类型]是否修改
     */
    public boolean isDETypeDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isDETypeDirty();
        }
        return this.detypeDirtyFlag;
    }

    /**
     *  重置属性值[实体类型]
     */
    public void resetDEType() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetDEType();
            return;
        }

        this.detypeDirtyFlag = false;
        this.detype = null;
    }
    /**
     *  设置属性值[实体用户参数]
     *  @param deuserparam
     */
    public void setDEUserParam(String deuserparam) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setDEUserParam(deuserparam);
            return;
        }
        if(deuserparam!=null) {
            deuserparam = StringHelper.trimRight(deuserparam);
            if(deuserparam.length()==0) {
                deuserparam = null;
            }
        }
        this.deuserparam = deuserparam;
        this.deuserparamDirtyFlag  = true;
    }

    /**
     *  获取属性值[实体用户参数]
     */
    public String getDEUserParam() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDEUserParam();
        }
        return this.deuserparam;
    }

    /**
     *  获取属性值[实体用户参数]是否修改
     */
    public boolean isDEUserParamDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isDEUserParamDirty();
        }
        return this.deuserparamDirtyFlag;
    }

    /**
     *  重置属性值[实体用户参数]
     */
    public void resetDEUserParam() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetDEUserParam();
            return;
        }

        this.deuserparamDirtyFlag = false;
        this.deuserparam = null;
    }
    /**
     *  设置属性值[版本]
     *  @param deversion
     */
    public void setDEVersion(Integer deversion) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setDEVersion(deversion);
            return;
        }
        this.deversion = deversion;
        this.deversionDirtyFlag  = true;
    }

    /**
     *  获取属性值[版本]
     */
    public Integer getDEVersion() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDEVersion();
        }
        return this.deversion;
    }

    /**
     *  获取属性值[版本]是否修改
     */
    public boolean isDEVersionDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isDEVersionDirty();
        }
        return this.deversionDirtyFlag;
    }

    /**
     *  重置属性值[版本]
     */
    public void resetDEVersion() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetDEVersion();
            return;
        }

        this.deversionDirtyFlag = false;
        this.deversion = null;
    }
    /**
     *  设置属性值[表格行样式辅助对象]
     *  @param dgrowclasshelper
     */
    public void setDGRowClassHelper(String dgrowclasshelper) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setDGRowClassHelper(dgrowclasshelper);
            return;
        }
        if(dgrowclasshelper!=null) {
            dgrowclasshelper = StringHelper.trimRight(dgrowclasshelper);
            if(dgrowclasshelper.length()==0) {
                dgrowclasshelper = null;
            }
        }
        this.dgrowclasshelper = dgrowclasshelper;
        this.dgrowclasshelperDirtyFlag  = true;
    }

    /**
     *  获取属性值[表格行样式辅助对象]
     */
    public String getDGRowClassHelper() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDGRowClassHelper();
        }
        return this.dgrowclasshelper;
    }

    /**
     *  获取属性值[表格行样式辅助对象]是否修改
     */
    public boolean isDGRowClassHelperDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isDGRowClassHelperDirty();
        }
        return this.dgrowclasshelperDirtyFlag;
    }

    /**
     *  重置属性值[表格行样式辅助对象]
     */
    public void resetDGRowClassHelper() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetDGRowClassHelper();
            return;
        }

        this.dgrowclasshelperDirtyFlag = false;
        this.dgrowclasshelper = null;
    }
    /**
     *  设置属性值[表格信息区高度]
     *  @param dgsummaryheight
     */
    public void setDGSUMMARYHeight(Integer dgsummaryheight) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setDGSUMMARYHeight(dgsummaryheight);
            return;
        }
        this.dgsummaryheight = dgsummaryheight;
        this.dgsummaryheightDirtyFlag  = true;
    }

    /**
     *  获取属性值[表格信息区高度]
     */
    public Integer getDGSUMMARYHeight() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDGSUMMARYHeight();
        }
        return this.dgsummaryheight;
    }

    /**
     *  获取属性值[表格信息区高度]是否修改
     */
    public boolean isDGSUMMARYHeightDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isDGSUMMARYHeightDirty();
        }
        return this.dgsummaryheightDirtyFlag;
    }

    /**
     *  重置属性值[表格信息区高度]
     */
    public void resetDGSUMMARYHeight() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetDGSUMMARYHeight();
            return;
        }

        this.dgsummaryheightDirtyFlag = false;
        this.dgsummaryheight = null;
    }
    /**
     *  设置属性值[数据锁辅助对象]
     *  @param dlkhelper
     */
    public void setDLKHelper(String dlkhelper) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setDLKHelper(dlkhelper);
            return;
        }
        if(dlkhelper!=null) {
            dlkhelper = StringHelper.trimRight(dlkhelper);
            if(dlkhelper.length()==0) {
                dlkhelper = null;
            }
        }
        this.dlkhelper = dlkhelper;
        this.dlkhelperDirtyFlag  = true;
    }

    /**
     *  获取属性值[数据锁辅助对象]
     */
    public String getDLKHelper() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDLKHelper();
        }
        return this.dlkhelper;
    }

    /**
     *  获取属性值[数据锁辅助对象]是否修改
     */
    public boolean isDLKHelperDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isDLKHelperDirty();
        }
        return this.dlkhelperDirtyFlag;
    }

    /**
     *  重置属性值[数据锁辅助对象]
     */
    public void resetDLKHelper() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetDLKHelper();
            return;
        }

        this.dlkhelperDirtyFlag = false;
        this.dlkhelper = null;
    }
    /**
     *  设置属性值[动态表间隔时间]
     *  @param dynamicinterval
     */
    public void setDynamicInterval(Integer dynamicinterval) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setDynamicInterval(dynamicinterval);
            return;
        }
        this.dynamicinterval = dynamicinterval;
        this.dynamicintervalDirtyFlag  = true;
    }

    /**
     *  获取属性值[动态表间隔时间]
     */
    public Integer getDynamicInterval() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDynamicInterval();
        }
        return this.dynamicinterval;
    }

    /**
     *  获取属性值[动态表间隔时间]是否修改
     */
    public boolean isDynamicIntervalDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isDynamicIntervalDirty();
        }
        return this.dynamicintervalDirtyFlag;
    }

    /**
     *  重置属性值[动态表间隔时间]
     */
    public void resetDynamicInterval() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetDynamicInterval();
            return;
        }

        this.dynamicintervalDirtyFlag = false;
        this.dynamicinterval = null;
    }
    /**
     *  设置属性值[启用列权限控制]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     *  @param enablecolpriv
     */
    public void setEnableColPriv(Integer enablecolpriv) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setEnableColPriv(enablecolpriv);
            return;
        }
        this.enablecolpriv = enablecolpriv;
        this.enablecolprivDirtyFlag  = true;
    }

    /**
     *  获取属性值[启用列权限控制]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     */
    public Integer getEnableColPriv() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getEnableColPriv();
        }
        return this.enablecolpriv;
    }

    /**
     *  获取属性值[启用列权限控制]是否修改
     */
    public boolean isEnableColPrivDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isEnableColPrivDirty();
        }
        return this.enablecolprivDirtyFlag;
    }

    /**
     *  重置属性值[启用列权限控制]
     */
    public void resetEnableColPriv() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetEnableColPriv();
            return;
        }

        this.enablecolprivDirtyFlag = false;
        this.enablecolpriv = null;
    }
    /**
     *  设置属性值[启用全局模型缓存]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     *  @param enableglobalmodel
     */
    public void setEnableGlobalModel(Integer enableglobalmodel) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setEnableGlobalModel(enableglobalmodel);
            return;
        }
        this.enableglobalmodel = enableglobalmodel;
        this.enableglobalmodelDirtyFlag  = true;
    }

    /**
     *  获取属性值[启用全局模型缓存]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     */
    public Integer getEnableGlobalModel() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getEnableGlobalModel();
        }
        return this.enableglobalmodel;
    }

    /**
     *  获取属性值[启用全局模型缓存]是否修改
     */
    public boolean isEnableGlobalModelDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isEnableGlobalModelDirty();
        }
        return this.enableglobalmodelDirtyFlag;
    }

    /**
     *  重置属性值[启用全局模型缓存]
     */
    public void resetEnableGlobalModel() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetEnableGlobalModel();
            return;
        }

        this.enableglobalmodelDirtyFlag = false;
        this.enableglobalmodel = null;
    }
    /**
     *  设置属性值[现存模型]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     *  @param exitingmodel
     */
    public void setExitingModel(Integer exitingmodel) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setExitingModel(exitingmodel);
            return;
        }
        this.exitingmodel = exitingmodel;
        this.exitingmodelDirtyFlag  = true;
    }

    /**
     *  获取属性值[现存模型]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     */
    public Integer getExitingModel() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getExitingModel();
        }
        return this.exitingmodel;
    }

    /**
     *  获取属性值[现存模型]是否修改
     */
    public boolean isExitingModelDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isExitingModelDirty();
        }
        return this.exitingmodelDirtyFlag;
    }

    /**
     *  重置属性值[现存模型]
     */
    public void resetExitingModel() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetExitingModel();
            return;
        }

        this.exitingmodelDirtyFlag = false;
        this.exitingmodel = null;
    }
    /**
     *  设置属性值[导出模型包含空值]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     *  @param exportincempty
     */
    public void setExportIncEmpty(Integer exportincempty) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setExportIncEmpty(exportincempty);
            return;
        }
        this.exportincempty = exportincempty;
        this.exportincemptyDirtyFlag  = true;
    }

    /**
     *  获取属性值[导出模型包含空值]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     */
    public Integer getExportIncEmpty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getExportIncEmpty();
        }
        return this.exportincempty;
    }

    /**
     *  获取属性值[导出模型包含空值]是否修改
     */
    public boolean isExportIncEmptyDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isExportIncEmptyDirty();
        }
        return this.exportincemptyDirtyFlag;
    }

    /**
     *  重置属性值[导出模型包含空值]
     */
    public void resetExportIncEmpty() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetExportIncEmpty();
            return;
        }

        this.exportincemptyDirtyFlag = false;
        this.exportincempty = null;
    }
    /**
     *  设置属性值[用户表]
     *  @param extablename
     */
    public void setExTableName(String extablename) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setExTableName(extablename);
            return;
        }
        if(extablename!=null) {
            extablename = StringHelper.trimRight(extablename);
            if(extablename.length()==0) {
                extablename = null;
            }
        }
        this.extablename = extablename;
        this.extablenameDirtyFlag  = true;
    }

    /**
     *  获取属性值[用户表]
     */
    public String getExTableName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getExTableName();
        }
        return this.extablename;
    }

    /**
     *  获取属性值[用户表]是否修改
     */
    public boolean isExTableNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isExTableNameDirty();
        }
        return this.extablenameDirtyFlag;
    }

    /**
     *  重置属性值[用户表]
     */
    public void resetExTableName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetExTableName();
            return;
        }

        this.extablenameDirtyFlag = false;
        this.extablename = null;
    }
    /**
     *  设置属性值[全局模型对象]
     *  @param globalmodelobj
     */
    public void setGlobalModelObj(String globalmodelobj) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setGlobalModelObj(globalmodelobj);
            return;
        }
        if(globalmodelobj!=null) {
            globalmodelobj = StringHelper.trimRight(globalmodelobj);
            if(globalmodelobj.length()==0) {
                globalmodelobj = null;
            }
        }
        this.globalmodelobj = globalmodelobj;
        this.globalmodelobjDirtyFlag  = true;
    }

    /**
     *  获取属性值[全局模型对象]
     */
    public String getGlobalModelObj() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getGlobalModelObj();
        }
        return this.globalmodelobj;
    }

    /**
     *  获取属性值[全局模型对象]是否修改
     */
    public boolean isGlobalModelObjDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isGlobalModelObjDirty();
        }
        return this.globalmodelobjDirtyFlag;
    }

    /**
     *  重置属性值[全局模型对象]
     */
    public void resetGlobalModelObj() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetGlobalModelObj();
            return;
        }

        this.globalmodelobjDirtyFlag = false;
        this.globalmodelobj = null;
    }
    /**
     *  设置属性值[索引模式]代码表：net.ibizsys.psrt.srv.codelist.DEIndexModeCodeListModel
     *  @param indexmode
     */
    public void setIndexMode(Integer indexmode) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setIndexMode(indexmode);
            return;
        }
        this.indexmode = indexmode;
        this.indexmodeDirtyFlag  = true;
    }

    /**
     *  获取属性值[索引模式]代码表：net.ibizsys.psrt.srv.codelist.DEIndexModeCodeListModel
     */
    public Integer getIndexMode() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getIndexMode();
        }
        return this.indexmode;
    }

    /**
     *  获取属性值[索引模式]是否修改
     */
    public boolean isIndexModeDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isIndexModeDirty();
        }
        return this.indexmodeDirtyFlag;
    }

    /**
     *  重置属性值[索引模式]
     */
    public void resetIndexMode() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetIndexMode();
            return;
        }

        this.indexmodeDirtyFlag = false;
        this.indexmode = null;
    }
    /**
     *  设置属性值[信息属性参数]
     *  @param infofield
     */
    public void setInfoField(String infofield) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setInfoField(infofield);
            return;
        }
        if(infofield!=null) {
            infofield = StringHelper.trimRight(infofield);
            if(infofield.length()==0) {
                infofield = null;
            }
        }
        this.infofield = infofield;
        this.infofieldDirtyFlag  = true;
    }

    /**
     *  获取属性值[信息属性参数]
     */
    public String getInfoField() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getInfoField();
        }
        return this.infofield;
    }

    /**
     *  获取属性值[信息属性参数]是否修改
     */
    public boolean isInfoFieldDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isInfoFieldDirty();
        }
        return this.infofieldDirtyFlag;
    }

    /**
     *  重置属性值[信息属性参数]
     */
    public void resetInfoField() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetInfoField();
            return;
        }

        this.infofieldDirtyFlag = false;
        this.infofield = null;
    }
    /**
     *  设置属性值[信息格式化]
     *  @param infoformat
     */
    public void setInfoFormat(String infoformat) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setInfoFormat(infoformat);
            return;
        }
        if(infoformat!=null) {
            infoformat = StringHelper.trimRight(infoformat);
            if(infoformat.length()==0) {
                infoformat = null;
            }
        }
        this.infoformat = infoformat;
        this.infoformatDirtyFlag  = true;
    }

    /**
     *  获取属性值[信息格式化]
     */
    public String getInfoFormat() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getInfoFormat();
        }
        return this.infoformat;
    }

    /**
     *  获取属性值[信息格式化]是否修改
     */
    public boolean isInfoFormatDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isInfoFormatDirty();
        }
        return this.infoformatDirtyFlag;
    }

    /**
     *  重置属性值[信息格式化]
     */
    public void resetInfoFormat() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetInfoFormat();
            return;
        }

        this.infoformatDirtyFlag = false;
        this.infoformat = null;
    }
    /**
     *  设置属性值[继承模式]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     *  @param inheritmode
     */
    public void setInheritMode(Integer inheritmode) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setInheritMode(inheritmode);
            return;
        }
        this.inheritmode = inheritmode;
        this.inheritmodeDirtyFlag  = true;
    }

    /**
     *  获取属性值[继承模式]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     */
    public Integer getInheritMode() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getInheritMode();
        }
        return this.inheritmode;
    }

    /**
     *  获取属性值[继承模式]是否修改
     */
    public boolean isInheritModeDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isInheritModeDirty();
        }
        return this.inheritmodeDirtyFlag;
    }

    /**
     *  重置属性值[继承模式]
     */
    public void resetInheritMode() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetInheritMode();
            return;
        }

        this.inheritmodeDirtyFlag = false;
        this.inheritmode = null;
    }
    /**
     *  设置属性值[启用表格行编辑]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     *  @param isdgrowedit
     */
    public void setIsDGRowEdit(Integer isdgrowedit) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setIsDGRowEdit(isdgrowedit);
            return;
        }
        this.isdgrowedit = isdgrowedit;
        this.isdgroweditDirtyFlag  = true;
    }

    /**
     *  获取属性值[启用表格行编辑]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     */
    public Integer getIsDGRowEdit() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getIsDGRowEdit();
        }
        return this.isdgrowedit;
    }

    /**
     *  获取属性值[启用表格行编辑]是否修改
     */
    public boolean isIsDGRowEditDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isIsDGRowEditDirty();
        }
        return this.isdgroweditDirtyFlag;
    }

    /**
     *  重置属性值[启用表格行编辑]
     */
    public void resetIsDGRowEdit() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetIsDGRowEdit();
            return;
        }

        this.isdgroweditDirtyFlag = false;
        this.isdgrowedit = null;
    }
    /**
     *  设置属性值[启用审计]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     *  @param isenableaudit
     */
    public void setIsEnableAudit(Integer isenableaudit) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setIsEnableAudit(isenableaudit);
            return;
        }
        this.isenableaudit = isenableaudit;
        this.isenableauditDirtyFlag  = true;
    }

    /**
     *  获取属性值[启用审计]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     */
    public Integer getIsEnableAudit() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getIsEnableAudit();
        }
        return this.isenableaudit;
    }

    /**
     *  获取属性值[启用审计]是否修改
     */
    public boolean isIsEnableAuditDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isIsEnableAuditDirty();
        }
        return this.isenableauditDirtyFlag;
    }

    /**
     *  重置属性值[启用审计]
     */
    public void resetIsEnableAudit() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetIsEnableAudit();
            return;
        }

        this.isenableauditDirtyFlag = false;
        this.isenableaudit = null;
    }
    /**
     *  设置属性值[启用数据权限]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     *  @param isenabledp
     */
    public void setIsEnableDP(Integer isenabledp) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setIsEnableDP(isenabledp);
            return;
        }
        this.isenabledp = isenabledp;
        this.isenabledpDirtyFlag  = true;
    }

    /**
     *  获取属性值[启用数据权限]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     */
    public Integer getIsEnableDP() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getIsEnableDP();
        }
        return this.isenabledp;
    }

    /**
     *  获取属性值[启用数据权限]是否修改
     */
    public boolean isIsEnableDPDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isIsEnableDPDirty();
        }
        return this.isenabledpDirtyFlag;
    }

    /**
     *  重置属性值[启用数据权限]
     */
    public void resetIsEnableDP() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetIsEnableDP();
            return;
        }

        this.isenabledpDirtyFlag = false;
        this.isenabledp = null;
    }
    /**
     *  设置属性值[索引实体]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     *  @param isindexde
     */
    public void setIsIndexDE(Integer isindexde) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setIsIndexDE(isindexde);
            return;
        }
        this.isindexde = isindexde;
        this.isindexdeDirtyFlag  = true;
    }

    /**
     *  获取属性值[索引实体]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     */
    public Integer getIsIndexDE() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getIsIndexDE();
        }
        return this.isindexde;
    }

    /**
     *  获取属性值[索引实体]是否修改
     */
    public boolean isIsIndexDEDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isIsIndexDEDirty();
        }
        return this.isindexdeDirtyFlag;
    }

    /**
     *  重置属性值[索引实体]
     */
    public void resetIsIndexDE() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetIsIndexDE();
            return;
        }

        this.isindexdeDirtyFlag = false;
        this.isindexde = null;
    }
    /**
     *  设置属性值[启用逻辑有效]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     *  @param islogicvalid
     */
    public void setIsLogicValid(Integer islogicvalid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setIsLogicValid(islogicvalid);
            return;
        }
        this.islogicvalid = islogicvalid;
        this.islogicvalidDirtyFlag  = true;
    }

    /**
     *  获取属性值[启用逻辑有效]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     */
    public Integer getIsLogicValid() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getIsLogicValid();
        }
        return this.islogicvalid;
    }

    /**
     *  获取属性值[启用逻辑有效]是否修改
     */
    public boolean isIsLogicValidDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isIsLogicValidDirty();
        }
        return this.islogicvalidDirtyFlag;
    }

    /**
     *  重置属性值[启用逻辑有效]
     */
    public void resetIsLogicValid() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetIsLogicValid();
            return;
        }

        this.islogicvalidDirtyFlag = false;
        this.islogicvalid = null;
    }
    /**
     *  设置属性值[多选打印]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     *  @param ismultiprint
     */
    public void setISMULTIPRINT(Integer ismultiprint) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setISMULTIPRINT(ismultiprint);
            return;
        }
        this.ismultiprint = ismultiprint;
        this.ismultiprintDirtyFlag  = true;
    }

    /**
     *  获取属性值[多选打印]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     */
    public Integer getISMULTIPRINT() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getISMULTIPRINT();
        }
        return this.ismultiprint;
    }

    /**
     *  获取属性值[多选打印]是否修改
     */
    public boolean isISMULTIPRINTDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isISMULTIPRINTDirty();
        }
        return this.ismultiprintDirtyFlag;
    }

    /**
     *  重置属性值[多选打印]
     */
    public void resetISMULTIPRINT() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetISMULTIPRINT();
            return;
        }

        this.ismultiprintDirtyFlag = false;
        this.ismultiprint = null;
    }
    /**
     *  设置属性值[数据附件]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     *  @param issupportfa
     */
    public void setISSupportFA(Integer issupportfa) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setISSupportFA(issupportfa);
            return;
        }
        this.issupportfa = issupportfa;
        this.issupportfaDirtyFlag  = true;
    }

    /**
     *  获取属性值[数据附件]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     */
    public Integer getISSupportFA() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getISSupportFA();
        }
        return this.issupportfa;
    }

    /**
     *  获取属性值[数据附件]是否修改
     */
    public boolean isISSupportFADirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isISSupportFADirty();
        }
        return this.issupportfaDirtyFlag;
    }

    /**
     *  重置属性值[数据附件]
     */
    public void resetISSupportFA() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetISSupportFA();
            return;
        }

        this.issupportfaDirtyFlag = false;
        this.issupportfa = null;
    }
    /**
     *  设置属性值[系统实体]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     *  @param issystem
     */
    public void setIsSystem(Integer issystem) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setIsSystem(issystem);
            return;
        }
        this.issystem = issystem;
        this.issystemDirtyFlag  = true;
    }

    /**
     *  获取属性值[系统实体]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     */
    public Integer getIsSystem() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getIsSystem();
        }
        return this.issystem;
    }

    /**
     *  获取属性值[系统实体]是否修改
     */
    public boolean isIsSystemDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isIsSystemDirty();
        }
        return this.issystemDirtyFlag;
    }

    /**
     *  重置属性值[系统实体]
     */
    public void resetIsSystem() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetIsSystem();
            return;
        }

        this.issystemDirtyFlag = false;
        this.issystem = null;
    }
    /**
     *  设置属性值[主键参数]
     *  @param keyparams
     */
    public void setKeyParams(String keyparams) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setKeyParams(keyparams);
            return;
        }
        if(keyparams!=null) {
            keyparams = StringHelper.trimRight(keyparams);
            if(keyparams.length()==0) {
                keyparams = null;
            }
        }
        this.keyparams = keyparams;
        this.keyparamsDirtyFlag  = true;
    }

    /**
     *  获取属性值[主键参数]
     */
    public String getKeyParams() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getKeyParams();
        }
        return this.keyparams;
    }

    /**
     *  获取属性值[主键参数]是否修改
     */
    public boolean isKeyParamsDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isKeyParamsDirty();
        }
        return this.keyparamsDirtyFlag;
    }

    /**
     *  重置属性值[主键参数]
     */
    public void resetKeyParams() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetKeyParams();
            return;
        }

        this.keyparamsDirtyFlag = false;
        this.keyparams = null;
    }
    /**
     *  设置属性值[授权代码]
     *  @param licensecode
     */
    public void setLicenseCode(String licensecode) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setLicenseCode(licensecode);
            return;
        }
        if(licensecode!=null) {
            licensecode = StringHelper.trimRight(licensecode);
            if(licensecode.length()==0) {
                licensecode = null;
            }
        }
        this.licensecode = licensecode;
        this.licensecodeDirtyFlag  = true;
    }

    /**
     *  获取属性值[授权代码]
     */
    public String getLicenseCode() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getLicenseCode();
        }
        return this.licensecode;
    }

    /**
     *  获取属性值[授权代码]是否修改
     */
    public boolean isLicenseCodeDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isLicenseCodeDirty();
        }
        return this.licensecodeDirtyFlag;
    }

    /**
     *  重置属性值[授权代码]
     */
    public void resetLicenseCode() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetLicenseCode();
            return;
        }

        this.licensecodeDirtyFlag = false;
        this.licensecode = null;
    }
    /**
     *  设置属性值[记录审计明细]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     *  @param logauditdetail
     */
    public void setLogAuditDetail(Integer logauditdetail) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setLogAuditDetail(logauditdetail);
            return;
        }
        this.logauditdetail = logauditdetail;
        this.logauditdetailDirtyFlag  = true;
    }

    /**
     *  获取属性值[记录审计明细]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     */
    public Integer getLogAuditDetail() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getLogAuditDetail();
        }
        return this.logauditdetail;
    }

    /**
     *  获取属性值[记录审计明细]是否修改
     */
    public boolean isLogAuditDetailDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isLogAuditDetailDirty();
        }
        return this.logauditdetailDirtyFlag;
    }

    /**
     *  重置属性值[记录审计明细]
     */
    public void resetLogAuditDetail() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetLogAuditDetail();
            return;
        }

        this.logauditdetailDirtyFlag = false;
        this.logauditdetail = null;
    }
    /**
     *  设置属性值[备注]
     *  @param memo
     */
    public void setMemo(String memo) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setMemo(memo);
            return;
        }
        if(memo!=null) {
            memo = StringHelper.trimRight(memo);
            if(memo.length()==0) {
                memo = null;
            }
        }
        this.memo = memo;
        this.memoDirtyFlag  = true;
    }

    /**
     *  获取属性值[备注]
     */
    public String getMemo() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getMemo();
        }
        return this.memo;
    }

    /**
     *  获取属性值[备注]是否修改
     */
    public boolean isMemoDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isMemoDirty();
        }
        return this.memoDirtyFlag;
    }

    /**
     *  重置属性值[备注]
     */
    public void resetMemo() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetMemo();
            return;
        }

        this.memoDirtyFlag = false;
        this.memo = null;
    }
    /**
     *  设置属性值[附表标识字段]
     *  @param minorfieldname
     */
    public void setMinorFieldName(String minorfieldname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setMinorFieldName(minorfieldname);
            return;
        }
        if(minorfieldname!=null) {
            minorfieldname = StringHelper.trimRight(minorfieldname);
            if(minorfieldname.length()==0) {
                minorfieldname = null;
            }
        }
        this.minorfieldname = minorfieldname;
        this.minorfieldnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[附表标识字段]
     */
    public String getMinorFieldName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getMinorFieldName();
        }
        return this.minorfieldname;
    }

    /**
     *  获取属性值[附表标识字段]是否修改
     */
    public boolean isMinorFieldNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isMinorFieldNameDirty();
        }
        return this.minorfieldnameDirtyFlag;
    }

    /**
     *  重置属性值[附表标识字段]
     */
    public void resetMinorFieldName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetMinorFieldName();
            return;
        }

        this.minorfieldnameDirtyFlag = false;
        this.minorfieldname = null;
    }
    /**
     *  设置属性值[附表标识值]
     *  @param minorfieldvalue
     */
    public void setMinorFieldValue(String minorfieldvalue) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setMinorFieldValue(minorfieldvalue);
            return;
        }
        if(minorfieldvalue!=null) {
            minorfieldvalue = StringHelper.trimRight(minorfieldvalue);
            if(minorfieldvalue.length()==0) {
                minorfieldvalue = null;
            }
        }
        this.minorfieldvalue = minorfieldvalue;
        this.minorfieldvalueDirtyFlag  = true;
    }

    /**
     *  获取属性值[附表标识值]
     */
    public String getMinorFieldValue() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getMinorFieldValue();
        }
        return this.minorfieldvalue;
    }

    /**
     *  获取属性值[附表标识值]是否修改
     */
    public boolean isMinorFieldValueDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isMinorFieldValueDirty();
        }
        return this.minorfieldvalueDirtyFlag;
    }

    /**
     *  重置属性值[附表标识值]
     */
    public void resetMinorFieldValue() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetMinorFieldValue();
            return;
        }

        this.minorfieldvalueDirtyFlag = false;
        this.minorfieldvalue = null;
    }
    /**
     *  设置属性值[附表名称]
     *  @param minortablename
     */
    public void setMinorTableName(String minortablename) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setMinorTableName(minortablename);
            return;
        }
        if(minortablename!=null) {
            minortablename = StringHelper.trimRight(minortablename);
            if(minortablename.length()==0) {
                minortablename = null;
            }
        }
        this.minortablename = minortablename;
        this.minortablenameDirtyFlag  = true;
    }

    /**
     *  获取属性值[附表名称]
     */
    public String getMinorTableName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getMinorTableName();
        }
        return this.minortablename;
    }

    /**
     *  获取属性值[附表名称]是否修改
     */
    public boolean isMinorTableNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isMinorTableNameDirty();
        }
        return this.minortablenameDirtyFlag;
    }

    /**
     *  重置属性值[附表名称]
     */
    public void resetMinorTableName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetMinorTableName();
            return;
        }

        this.minortablenameDirtyFlag = false;
        this.minortablename = null;
    }
    /**
     *  设置属性值[多主实体模式]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     *  @param mutlimajor
     */
    public void setMutliMajor(Integer mutlimajor) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setMutliMajor(mutlimajor);
            return;
        }
        this.mutlimajor = mutlimajor;
        this.mutlimajorDirtyFlag  = true;
    }

    /**
     *  获取属性值[多主实体模式]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     */
    public Integer getMutliMajor() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getMutliMajor();
        }
        return this.mutlimajor;
    }

    /**
     *  获取属性值[多主实体模式]是否修改
     */
    public boolean isMutliMajorDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isMutliMajorDirty();
        }
        return this.mutlimajorDirtyFlag;
    }

    /**
     *  重置属性值[多主实体模式]
     */
    public void resetMutliMajor() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetMutliMajor();
            return;
        }

        this.mutlimajorDirtyFlag = false;
        this.mutlimajor = null;
    }
    /**
     *  设置属性值[无数据信息]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     *  @param nodatainfo
     */
    public void setNoDataInfo(Integer nodatainfo) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setNoDataInfo(nodatainfo);
            return;
        }
        this.nodatainfo = nodatainfo;
        this.nodatainfoDirtyFlag  = true;
    }

    /**
     *  获取属性值[无数据信息]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     */
    public Integer getNoDataInfo() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getNoDataInfo();
        }
        return this.nodatainfo;
    }

    /**
     *  获取属性值[无数据信息]是否修改
     */
    public boolean isNoDataInfoDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isNoDataInfoDirty();
        }
        return this.nodatainfoDirtyFlag;
    }

    /**
     *  重置属性值[无数据信息]
     */
    public void resetNoDataInfo() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetNoDataInfo();
            return;
        }

        this.nodatainfoDirtyFlag = false;
        this.nodatainfo = null;
    }
    /**
     *  设置属性值[打印功能]代码表：net.ibizsys.psrt.srv.codelist.DEPrintFuncCodeListModel
     *  @param printfunc
     */
    public void setPrintFunc(String printfunc) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setPrintFunc(printfunc);
            return;
        }
        if(printfunc!=null) {
            printfunc = StringHelper.trimRight(printfunc);
            if(printfunc.length()==0) {
                printfunc = null;
            }
        }
        this.printfunc = printfunc;
        this.printfuncDirtyFlag  = true;
    }

    /**
     *  获取属性值[打印功能]代码表：net.ibizsys.psrt.srv.codelist.DEPrintFuncCodeListModel
     */
    public String getPrintFunc() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getPrintFunc();
        }
        return this.printfunc;
    }

    /**
     *  获取属性值[打印功能]是否修改
     */
    public boolean isPrintFuncDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isPrintFuncDirty();
        }
        return this.printfuncDirtyFlag;
    }

    /**
     *  重置属性值[打印功能]
     */
    public void resetPrintFunc() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetPrintFunc();
            return;
        }

        this.printfuncDirtyFlag = false;
        this.printfunc = null;
    }
    /**
     *  设置属性值[保留1]
     *  @param reserver
     */
    public void setReserver(String reserver) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setReserver(reserver);
            return;
        }
        if(reserver!=null) {
            reserver = StringHelper.trimRight(reserver);
            if(reserver.length()==0) {
                reserver = null;
            }
        }
        this.reserver = reserver;
        this.reserverDirtyFlag  = true;
    }

    /**
     *  获取属性值[保留1]
     */
    public String getReserver() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getReserver();
        }
        return this.reserver;
    }

    /**
     *  获取属性值[保留1]是否修改
     */
    public boolean isReserverDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isReserverDirty();
        }
        return this.reserverDirtyFlag;
    }

    /**
     *  重置属性值[保留1]
     */
    public void resetReserver() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetReserver();
            return;
        }

        this.reserverDirtyFlag = false;
        this.reserver = null;
    }
    /**
     *  设置属性值[保留2]
     *  @param reserver2
     */
    public void setReserver2(String reserver2) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setReserver2(reserver2);
            return;
        }
        if(reserver2!=null) {
            reserver2 = StringHelper.trimRight(reserver2);
            if(reserver2.length()==0) {
                reserver2 = null;
            }
        }
        this.reserver2 = reserver2;
        this.reserver2DirtyFlag  = true;
    }

    /**
     *  获取属性值[保留2]
     */
    public String getReserver2() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getReserver2();
        }
        return this.reserver2;
    }

    /**
     *  获取属性值[保留2]是否修改
     */
    public boolean isReserver2Dirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isReserver2Dirty();
        }
        return this.reserver2DirtyFlag;
    }

    /**
     *  重置属性值[保留2]
     */
    public void resetReserver2() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetReserver2();
            return;
        }

        this.reserver2DirtyFlag = false;
        this.reserver2 = null;
    }
    /**
     *  设置属性值[记录数量]
     *  @param rowamout
     */
    public void setRowAmout(Integer rowamout) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setRowAmout(rowamout);
            return;
        }
        this.rowamout = rowamout;
        this.rowamoutDirtyFlag  = true;
    }

    /**
     *  获取属性值[记录数量]
     */
    public Integer getRowAmout() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getRowAmout();
        }
        return this.rowamout;
    }

    /**
     *  获取属性值[记录数量]是否修改
     */
    public boolean isRowAmoutDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isRowAmoutDirty();
        }
        return this.rowamoutDirtyFlag;
    }

    /**
     *  重置属性值[记录数量]
     */
    public void resetRowAmout() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetRowAmout();
            return;
        }

        this.rowamoutDirtyFlag = false;
        this.rowamout = null;
    }
    /**
     *  设置属性值[运行信息]
     *  @param rtinfo
     */
    public void setRTInfo(String rtinfo) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setRTInfo(rtinfo);
            return;
        }
        if(rtinfo!=null) {
            rtinfo = StringHelper.trimRight(rtinfo);
            if(rtinfo.length()==0) {
                rtinfo = null;
            }
        }
        this.rtinfo = rtinfo;
        this.rtinfoDirtyFlag  = true;
    }

    /**
     *  获取属性值[运行信息]
     */
    public String getRTInfo() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getRTInfo();
        }
        return this.rtinfo;
    }

    /**
     *  获取属性值[运行信息]是否修改
     */
    public boolean isRTInfoDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isRTInfoDirty();
        }
        return this.rtinfoDirtyFlag;
    }

    /**
     *  重置属性值[运行信息]
     */
    public void resetRTInfo() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetRTInfo();
            return;
        }

        this.rtinfoDirtyFlag = false;
        this.rtinfo = null;
    }
    /**
     *  设置属性值[小图标]
     *  @param smallicon
     */
    public void setSMALLICON(String smallicon) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setSMALLICON(smallicon);
            return;
        }
        if(smallicon!=null) {
            smallicon = StringHelper.trimRight(smallicon);
            if(smallicon.length()==0) {
                smallicon = null;
            }
        }
        this.smallicon = smallicon;
        this.smalliconDirtyFlag  = true;
    }

    /**
     *  获取属性值[小图标]
     */
    public String getSMALLICON() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getSMALLICON();
        }
        return this.smallicon;
    }

    /**
     *  获取属性值[小图标]是否修改
     */
    public boolean isSMALLICONDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isSMALLICONDirty();
        }
        return this.smalliconDirtyFlag;
    }

    /**
     *  重置属性值[小图标]
     */
    public void resetSMALLICON() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetSMALLICON();
            return;
        }

        this.smalliconDirtyFlag = false;
        this.smallicon = null;
    }
    /**
     *  设置属性值[实体存储类型]代码表：net.ibizsys.psrt.srv.codelist.CodeList80CodeListModel
     *  @param storagetype
     */
    public void setStorageType(String storagetype) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setStorageType(storagetype);
            return;
        }
        if(storagetype!=null) {
            storagetype = StringHelper.trimRight(storagetype);
            if(storagetype.length()==0) {
                storagetype = null;
            }
        }
        this.storagetype = storagetype;
        this.storagetypeDirtyFlag  = true;
    }

    /**
     *  获取属性值[实体存储类型]代码表：net.ibizsys.psrt.srv.codelist.CodeList80CodeListModel
     */
    public String getStorageType() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getStorageType();
        }
        return this.storagetype;
    }

    /**
     *  获取属性值[实体存储类型]是否修改
     */
    public boolean isStorageTypeDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isStorageTypeDirty();
        }
        return this.storagetypeDirtyFlag;
    }

    /**
     *  重置属性值[实体存储类型]
     */
    public void resetStorageType() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetStorageType();
            return;
        }

        this.storagetypeDirtyFlag = false;
        this.storagetype = null;
    }
    /**
     *  设置属性值[表名称]
     *  @param tablename
     */
    public void setTableName(String tablename) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setTableName(tablename);
            return;
        }
        if(tablename!=null) {
            tablename = StringHelper.trimRight(tablename);
            if(tablename.length()==0) {
                tablename = null;
            }
        }
        this.tablename = tablename;
        this.tablenameDirtyFlag  = true;
    }

    /**
     *  获取属性值[表名称]
     */
    public String getTableName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getTableName();
        }
        return this.tablename;
    }

    /**
     *  获取属性值[表名称]是否修改
     */
    public boolean isTableNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isTableNameDirty();
        }
        return this.tablenameDirtyFlag;
    }

    /**
     *  重置属性值[表名称]
     */
    public void resetTableName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetTableName();
            return;
        }

        this.tablenameDirtyFlag = false;
        this.tablename = null;
    }
    /**
     *  设置属性值[实体表空间]代码表：net.ibizsys.psrt.srv.codelist.DETableSpaceCodeListModel
     *  @param tablespace
     */
    public void setTableSpace(String tablespace) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setTableSpace(tablespace);
            return;
        }
        if(tablespace!=null) {
            tablespace = StringHelper.trimRight(tablespace);
            if(tablespace.length()==0) {
                tablespace = null;
            }
        }
        this.tablespace = tablespace;
        this.tablespaceDirtyFlag  = true;
    }

    /**
     *  获取属性值[实体表空间]代码表：net.ibizsys.psrt.srv.codelist.DETableSpaceCodeListModel
     */
    public String getTableSpace() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getTableSpace();
        }
        return this.tablespace;
    }

    /**
     *  获取属性值[实体表空间]是否修改
     */
    public boolean isTableSpaceDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isTableSpaceDirty();
        }
        return this.tablespaceDirtyFlag;
    }

    /**
     *  重置属性值[实体表空间]
     */
    public void resetTableSpace() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetTableSpace();
            return;
        }

        this.tablespaceDirtyFlag = false;
        this.tablespace = null;
    }
    /**
     *  设置属性值[提示信息]
     *  @param tipsinfo
     */
    public void setTipsInfo(String tipsinfo) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setTipsInfo(tipsinfo);
            return;
        }
        if(tipsinfo!=null) {
            tipsinfo = StringHelper.trimRight(tipsinfo);
            if(tipsinfo.length()==0) {
                tipsinfo = null;
            }
        }
        this.tipsinfo = tipsinfo;
        this.tipsinfoDirtyFlag  = true;
    }

    /**
     *  获取属性值[提示信息]
     */
    public String getTipsInfo() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getTipsInfo();
        }
        return this.tipsinfo;
    }

    /**
     *  获取属性值[提示信息]是否修改
     */
    public boolean isTipsInfoDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isTipsInfoDirty();
        }
        return this.tipsinfoDirtyFlag;
    }

    /**
     *  重置属性值[提示信息]
     */
    public void resetTipsInfo() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetTipsInfo();
            return;
        }

        this.tipsinfoDirtyFlag = false;
        this.tipsinfo = null;
    }
    /**
     *  设置属性值[更新时间]
     *  @param updatedate
     */
    public void setUpdateDate(Timestamp updatedate) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUpdateDate(updatedate);
            return;
        }
        this.updatedate = updatedate;
        this.updatedateDirtyFlag  = true;
    }

    /**
     *  获取属性值[更新时间]
     */
    public Timestamp getUpdateDate() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUpdateDate();
        }
        return this.updatedate;
    }

    /**
     *  获取属性值[更新时间]是否修改
     */
    public boolean isUpdateDateDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUpdateDateDirty();
        }
        return this.updatedateDirtyFlag;
    }

    /**
     *  重置属性值[更新时间]
     */
    public void resetUpdateDate() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUpdateDate();
            return;
        }

        this.updatedateDirtyFlag = false;
        this.updatedate = null;
    }
    /**
     *  设置属性值[更新人]代码表：net.ibizsys.psrt.srv.codelist.SysOperatorCodeListModel
     *  @param updateman
     */
    public void setUpdateMan(String updateman) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUpdateMan(updateman);
            return;
        }
        if(updateman!=null) {
            updateman = StringHelper.trimRight(updateman);
            if(updateman.length()==0) {
                updateman = null;
            }
        }
        this.updateman = updateman;
        this.updatemanDirtyFlag  = true;
    }

    /**
     *  获取属性值[更新人]代码表：net.ibizsys.psrt.srv.codelist.SysOperatorCodeListModel
     */
    public String getUpdateMan() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUpdateMan();
        }
        return this.updateman;
    }

    /**
     *  获取属性值[更新人]是否修改
     */
    public boolean isUpdateManDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUpdateManDirty();
        }
        return this.updatemanDirtyFlag;
    }

    /**
     *  重置属性值[更新人]
     */
    public void resetUpdateMan() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUpdateMan();
            return;
        }

        this.updatemanDirtyFlag = false;
        this.updateman = null;
    }
    /**
     *  设置属性值[用户数据行为]代码表：net.ibizsys.psrt.srv.codelist.CodeList71CodeListModel
     *  @param useraction
     */
    public void setUserAction(Integer useraction) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUserAction(useraction);
            return;
        }
        this.useraction = useraction;
        this.useractionDirtyFlag  = true;
    }

    /**
     *  获取属性值[用户数据行为]代码表：net.ibizsys.psrt.srv.codelist.CodeList71CodeListModel
     */
    public Integer getUserAction() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserAction();
        }
        return this.useraction;
    }

    /**
     *  获取属性值[用户数据行为]是否修改
     */
    public boolean isUserActionDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserActionDirty();
        }
        return this.useractionDirtyFlag;
    }

    /**
     *  重置属性值[用户数据行为]
     */
    public void resetUserAction() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUserAction();
            return;
        }

        this.useractionDirtyFlag = false;
        this.useraction = null;
    }
    /**
     *  设置属性值[是否启用]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     *  @param validflag
     */
    public void setValidFlag(Integer validflag) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setValidFlag(validflag);
            return;
        }
        this.validflag = validflag;
        this.validflagDirtyFlag  = true;
    }

    /**
     *  获取属性值[是否启用]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     */
    public Integer getValidFlag() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getValidFlag();
        }
        return this.validflag;
    }

    /**
     *  获取属性值[是否启用]是否修改
     */
    public boolean isValidFlagDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isValidFlagDirty();
        }
        return this.validflagDirtyFlag;
    }

    /**
     *  重置属性值[是否启用]
     */
    public void resetValidFlag() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetValidFlag();
            return;
        }

        this.validflagDirtyFlag = false;
        this.validflag = null;
    }
    /**
     *  设置属性值[启用数据版本控制]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     *  @param vcflag
     */
    public void setVCFlag(Integer vcflag) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setVCFlag(vcflag);
            return;
        }
        this.vcflag = vcflag;
        this.vcflagDirtyFlag  = true;
    }

    /**
     *  获取属性值[启用数据版本控制]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     */
    public Integer getVCFlag() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getVCFlag();
        }
        return this.vcflag;
    }

    /**
     *  获取属性值[启用数据版本控制]是否修改
     */
    public boolean isVCFlagDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isVCFlagDirty();
        }
        return this.vcflagDirtyFlag;
    }

    /**
     *  重置属性值[启用数据版本控制]
     */
    public void resetVCFlag() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetVCFlag();
            return;
        }

        this.vcflagDirtyFlag = false;
        this.vcflag = null;
    }
    /**
     *  设置属性值[版本检查间隔]
     *  @param verchecktimer
     */
    public void setVerCheckTimer(Integer verchecktimer) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setVerCheckTimer(verchecktimer);
            return;
        }
        this.verchecktimer = verchecktimer;
        this.verchecktimerDirtyFlag  = true;
    }

    /**
     *  获取属性值[版本检查间隔]
     */
    public Integer getVerCheckTimer() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getVerCheckTimer();
        }
        return this.verchecktimer;
    }

    /**
     *  获取属性值[版本检查间隔]是否修改
     */
    public boolean isVerCheckTimerDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isVerCheckTimerDirty();
        }
        return this.verchecktimerDirtyFlag;
    }

    /**
     *  重置属性值[版本检查间隔]
     */
    public void resetVerCheckTimer() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetVerCheckTimer();
            return;
        }

        this.verchecktimerDirtyFlag = false;
        this.verchecktimer = null;
    }
    /**
     *  设置属性值[版本属性]
     *  @param verfield
     */
    public void setVerField(String verfield) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setVerField(verfield);
            return;
        }
        if(verfield!=null) {
            verfield = StringHelper.trimRight(verfield);
            if(verfield.length()==0) {
                verfield = null;
            }
        }
        this.verfield = verfield;
        this.verfieldDirtyFlag  = true;
    }

    /**
     *  获取属性值[版本属性]
     */
    public String getVerField() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getVerField();
        }
        return this.verfield;
    }

    /**
     *  获取属性值[版本属性]是否修改
     */
    public boolean isVerFieldDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isVerFieldDirty();
        }
        return this.verfieldDirtyFlag;
    }

    /**
     *  重置属性值[版本属性]
     */
    public void resetVerField() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetVerField();
            return;
        }

        this.verfieldDirtyFlag = false;
        this.verfield = null;
    }
    /**
     *  设置属性值[版本辅助对象]
     *  @param verhelper
     */
    public void setVerHelper(String verhelper) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setVerHelper(verhelper);
            return;
        }
        if(verhelper!=null) {
            verhelper = StringHelper.trimRight(verhelper);
            if(verhelper.length()==0) {
                verhelper = null;
            }
        }
        this.verhelper = verhelper;
        this.verhelperDirtyFlag  = true;
    }

    /**
     *  获取属性值[版本辅助对象]
     */
    public String getVerHelper() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getVerHelper();
        }
        return this.verhelper;
    }

    /**
     *  获取属性值[版本辅助对象]是否修改
     */
    public boolean isVerHelperDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isVerHelperDirty();
        }
        return this.verhelperDirtyFlag;
    }

    /**
     *  重置属性值[版本辅助对象]
     */
    public void resetVerHelper() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetVerHelper();
            return;
        }

        this.verhelperDirtyFlag = false;
        this.verhelper = null;
    }
    /**
     *  设置属性值[版本检查]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     *  @param versioncheck
     */
    public void setVersionCheck(Integer versioncheck) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setVersionCheck(versioncheck);
            return;
        }
        this.versioncheck = versioncheck;
        this.versioncheckDirtyFlag  = true;
    }

    /**
     *  获取属性值[版本检查]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     */
    public Integer getVersionCheck() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getVersionCheck();
        }
        return this.versioncheck;
    }

    /**
     *  获取属性值[版本检查]是否修改
     */
    public boolean isVersionCheckDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isVersionCheckDirty();
        }
        return this.versioncheckDirtyFlag;
    }

    /**
     *  重置属性值[版本检查]
     */
    public void resetVersionCheck() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetVersionCheck();
            return;
        }

        this.versioncheckDirtyFlag = false;
        this.versioncheck = null;
    }
    /**
     *  设置属性值[视图名称]
     *  @param viewname
     */
    public void setViewName(String viewname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setViewName(viewname);
            return;
        }
        if(viewname!=null) {
            viewname = StringHelper.trimRight(viewname);
            if(viewname.length()==0) {
                viewname = null;
            }
        }
        this.viewname = viewname;
        this.viewnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[视图名称]
     */
    public String getViewName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getViewName();
        }
        return this.viewname;
    }

    /**
     *  获取属性值[视图名称]是否修改
     */
    public boolean isViewNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isViewNameDirty();
        }
        return this.viewnameDirtyFlag;
    }

    /**
     *  重置属性值[视图名称]
     */
    public void resetViewName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetViewName();
            return;
        }

        this.viewnameDirtyFlag = false;
        this.viewname = null;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onReset()
     */
    @Override
    protected void onReset() {
        DataEntityBase.resetAll(this);
        super.onReset();
    }

    /**
     * 重置当前数据对象属性值
     * @param entity
     */
    private static void resetAll(DataEntityBase et) {
        et.resetACEnableDP();
        et.resetACExtInfo();
        et.resetACInfoFormat();
        et.resetACInfoParam();
        et.resetACMaxCnt();
        et.resetACObject();
        et.resetACQueryModelId();
        et.resetACQueryModelName();
        et.resetACSortDir();
        et.resetACSortField();
        et.resetBigIcon();
        et.resetConfigHelper();
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetDataAccObject();
        et.resetDataChgLogMode();
        et.resetDataCtrlInt();
        et.resetDataCtrlObject();
        et.resetDataNotifyHelper();
        et.resetDBStorage();
        et.resetDBVersion();
        et.resetDEGroup();
        et.resetDEHelper();
        et.resetDEId();
        et.resetDELogicName();
        et.resetDEName();
        et.resetDEObject();
        et.resetDEOrder();
        et.resetDEParam();
        et.resetDER11DEId();
        et.resetDER11DEName();
        et.resetDEType();
        et.resetDEUserParam();
        et.resetDEVersion();
        et.resetDGRowClassHelper();
        et.resetDGSUMMARYHeight();
        et.resetDLKHelper();
        et.resetDynamicInterval();
        et.resetEnableColPriv();
        et.resetEnableGlobalModel();
        et.resetExitingModel();
        et.resetExportIncEmpty();
        et.resetExTableName();
        et.resetGlobalModelObj();
        et.resetIndexMode();
        et.resetInfoField();
        et.resetInfoFormat();
        et.resetInheritMode();
        et.resetIsDGRowEdit();
        et.resetIsEnableAudit();
        et.resetIsEnableDP();
        et.resetIsIndexDE();
        et.resetIsLogicValid();
        et.resetISMULTIPRINT();
        et.resetISSupportFA();
        et.resetIsSystem();
        et.resetKeyParams();
        et.resetLicenseCode();
        et.resetLogAuditDetail();
        et.resetMemo();
        et.resetMinorFieldName();
        et.resetMinorFieldValue();
        et.resetMinorTableName();
        et.resetMutliMajor();
        et.resetNoDataInfo();
        et.resetPrintFunc();
        et.resetReserver();
        et.resetReserver2();
        et.resetRowAmout();
        et.resetRTInfo();
        et.resetSMALLICON();
        et.resetStorageType();
        et.resetTableName();
        et.resetTableSpace();
        et.resetTipsInfo();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetUserAction();
        et.resetValidFlag();
        et.resetVCFlag();
        et.resetVerCheckTimer();
        et.resetVerField();
        et.resetVerHelper();
        et.resetVersionCheck();
        et.resetViewName();
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onFillMap(java.util.HashMap, boolean)
     */
    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if(!bDirtyOnly || isACEnableDPDirty()) {
            params.put(FIELD_ACENABLEDP,getACEnableDP());
        }
        if(!bDirtyOnly || isACExtInfoDirty()) {
            params.put(FIELD_ACEXTINFO,getACExtInfo());
        }
        if(!bDirtyOnly || isACInfoFormatDirty()) {
            params.put(FIELD_ACINFOFORMAT,getACInfoFormat());
        }
        if(!bDirtyOnly || isACInfoParamDirty()) {
            params.put(FIELD_ACINFOPARAM,getACInfoParam());
        }
        if(!bDirtyOnly || isACMaxCntDirty()) {
            params.put(FIELD_ACMAXCNT,getACMaxCnt());
        }
        if(!bDirtyOnly || isACObjectDirty()) {
            params.put(FIELD_ACOBJECT,getACObject());
        }
        if(!bDirtyOnly || isACQueryModelIdDirty()) {
            params.put(FIELD_ACQUERYMODELID,getACQueryModelId());
        }
        if(!bDirtyOnly || isACQueryModelNameDirty()) {
            params.put(FIELD_ACQUERYMODELNAME,getACQueryModelName());
        }
        if(!bDirtyOnly || isACSortDirDirty()) {
            params.put(FIELD_ACSORTDIR,getACSortDir());
        }
        if(!bDirtyOnly || isACSortFieldDirty()) {
            params.put(FIELD_ACSORTFIELD,getACSortField());
        }
        if(!bDirtyOnly || isBigIconDirty()) {
            params.put(FIELD_BIGICON,getBigIcon());
        }
        if(!bDirtyOnly || isConfigHelperDirty()) {
            params.put(FIELD_CONFIGHELPER,getConfigHelper());
        }
        if(!bDirtyOnly || isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE,getCreateDate());
        }
        if(!bDirtyOnly || isCreateManDirty()) {
            params.put(FIELD_CREATEMAN,getCreateMan());
        }
        if(!bDirtyOnly || isDataAccObjectDirty()) {
            params.put(FIELD_DATAACCOBJECT,getDataAccObject());
        }
        if(!bDirtyOnly || isDataChgLogModeDirty()) {
            params.put(FIELD_DATACHGLOGMODE,getDataChgLogMode());
        }
        if(!bDirtyOnly || isDataCtrlIntDirty()) {
            params.put(FIELD_DATACTRLINT,getDataCtrlInt());
        }
        if(!bDirtyOnly || isDataCtrlObjectDirty()) {
            params.put(FIELD_DATACTRLOBJECT,getDataCtrlObject());
        }
        if(!bDirtyOnly || isDataNotifyHelperDirty()) {
            params.put(FIELD_DATANOTIFYHELPER,getDataNotifyHelper());
        }
        if(!bDirtyOnly || isDBStorageDirty()) {
            params.put(FIELD_DBSTORAGE,getDBStorage());
        }
        if(!bDirtyOnly || isDBVersionDirty()) {
            params.put(FIELD_DBVERSION,getDBVersion());
        }
        if(!bDirtyOnly || isDEGroupDirty()) {
            params.put(FIELD_DEGROUP,getDEGroup());
        }
        if(!bDirtyOnly || isDEHelperDirty()) {
            params.put(FIELD_DEHELPER,getDEHelper());
        }
        if(!bDirtyOnly || isDEIdDirty()) {
            params.put(FIELD_DEID,getDEId());
        }
        if(!bDirtyOnly || isDELogicNameDirty()) {
            params.put(FIELD_DELOGICNAME,getDELogicName());
        }
        if(!bDirtyOnly || isDENameDirty()) {
            params.put(FIELD_DENAME,getDEName());
        }
        if(!bDirtyOnly || isDEObjectDirty()) {
            params.put(FIELD_DEOBJECT,getDEObject());
        }
        if(!bDirtyOnly || isDEOrderDirty()) {
            params.put(FIELD_DEORDER,getDEOrder());
        }
        if(!bDirtyOnly || isDEParamDirty()) {
            params.put(FIELD_DEPARAM,getDEParam());
        }
        if(!bDirtyOnly || isDER11DEIdDirty()) {
            params.put(FIELD_DER11DEID,getDER11DEId());
        }
        if(!bDirtyOnly || isDER11DENameDirty()) {
            params.put(FIELD_DER11DENAME,getDER11DEName());
        }
        if(!bDirtyOnly || isDETypeDirty()) {
            params.put(FIELD_DETYPE,getDEType());
        }
        if(!bDirtyOnly || isDEUserParamDirty()) {
            params.put(FIELD_DEUSERPARAM,getDEUserParam());
        }
        if(!bDirtyOnly || isDEVersionDirty()) {
            params.put(FIELD_DEVERSION,getDEVersion());
        }
        if(!bDirtyOnly || isDGRowClassHelperDirty()) {
            params.put(FIELD_DGROWCLASSHELPER,getDGRowClassHelper());
        }
        if(!bDirtyOnly || isDGSUMMARYHeightDirty()) {
            params.put(FIELD_DGSUMMARYHEIGHT,getDGSUMMARYHeight());
        }
        if(!bDirtyOnly || isDLKHelperDirty()) {
            params.put(FIELD_DLKHELPER,getDLKHelper());
        }
        if(!bDirtyOnly || isDynamicIntervalDirty()) {
            params.put(FIELD_DYNAMICINTERVAL,getDynamicInterval());
        }
        if(!bDirtyOnly || isEnableColPrivDirty()) {
            params.put(FIELD_ENABLECOLPRIV,getEnableColPriv());
        }
        if(!bDirtyOnly || isEnableGlobalModelDirty()) {
            params.put(FIELD_ENABLEGLOBALMODEL,getEnableGlobalModel());
        }
        if(!bDirtyOnly || isExitingModelDirty()) {
            params.put(FIELD_EXITINGMODEL,getExitingModel());
        }
        if(!bDirtyOnly || isExportIncEmptyDirty()) {
            params.put(FIELD_EXPORTINCEMPTY,getExportIncEmpty());
        }
        if(!bDirtyOnly || isExTableNameDirty()) {
            params.put(FIELD_EXTABLENAME,getExTableName());
        }
        if(!bDirtyOnly || isGlobalModelObjDirty()) {
            params.put(FIELD_GLOBALMODELOBJ,getGlobalModelObj());
        }
        if(!bDirtyOnly || isIndexModeDirty()) {
            params.put(FIELD_INDEXMODE,getIndexMode());
        }
        if(!bDirtyOnly || isInfoFieldDirty()) {
            params.put(FIELD_INFOFIELD,getInfoField());
        }
        if(!bDirtyOnly || isInfoFormatDirty()) {
            params.put(FIELD_INFOFORMAT,getInfoFormat());
        }
        if(!bDirtyOnly || isInheritModeDirty()) {
            params.put(FIELD_INHERITMODE,getInheritMode());
        }
        if(!bDirtyOnly || isIsDGRowEditDirty()) {
            params.put(FIELD_ISDGROWEDIT,getIsDGRowEdit());
        }
        if(!bDirtyOnly || isIsEnableAuditDirty()) {
            params.put(FIELD_ISENABLEAUDIT,getIsEnableAudit());
        }
        if(!bDirtyOnly || isIsEnableDPDirty()) {
            params.put(FIELD_ISENABLEDP,getIsEnableDP());
        }
        if(!bDirtyOnly || isIsIndexDEDirty()) {
            params.put(FIELD_ISINDEXDE,getIsIndexDE());
        }
        if(!bDirtyOnly || isIsLogicValidDirty()) {
            params.put(FIELD_ISLOGICVALID,getIsLogicValid());
        }
        if(!bDirtyOnly || isISMULTIPRINTDirty()) {
            params.put(FIELD_ISMULTIPRINT,getISMULTIPRINT());
        }
        if(!bDirtyOnly || isISSupportFADirty()) {
            params.put(FIELD_ISSUPPORTFA,getISSupportFA());
        }
        if(!bDirtyOnly || isIsSystemDirty()) {
            params.put(FIELD_ISSYSTEM,getIsSystem());
        }
        if(!bDirtyOnly || isKeyParamsDirty()) {
            params.put(FIELD_KEYPARAMS,getKeyParams());
        }
        if(!bDirtyOnly || isLicenseCodeDirty()) {
            params.put(FIELD_LICENSECODE,getLicenseCode());
        }
        if(!bDirtyOnly || isLogAuditDetailDirty()) {
            params.put(FIELD_LOGAUDITDETAIL,getLogAuditDetail());
        }
        if(!bDirtyOnly || isMemoDirty()) {
            params.put(FIELD_MEMO,getMemo());
        }
        if(!bDirtyOnly || isMinorFieldNameDirty()) {
            params.put(FIELD_MINORFIELDNAME,getMinorFieldName());
        }
        if(!bDirtyOnly || isMinorFieldValueDirty()) {
            params.put(FIELD_MINORFIELDVALUE,getMinorFieldValue());
        }
        if(!bDirtyOnly || isMinorTableNameDirty()) {
            params.put(FIELD_MINORTABLENAME,getMinorTableName());
        }
        if(!bDirtyOnly || isMutliMajorDirty()) {
            params.put(FIELD_MUTLIMAJOR,getMutliMajor());
        }
        if(!bDirtyOnly || isNoDataInfoDirty()) {
            params.put(FIELD_NODATAINFO,getNoDataInfo());
        }
        if(!bDirtyOnly || isPrintFuncDirty()) {
            params.put(FIELD_PRINTFUNC,getPrintFunc());
        }
        if(!bDirtyOnly || isReserverDirty()) {
            params.put(FIELD_RESERVER,getReserver());
        }
        if(!bDirtyOnly || isReserver2Dirty()) {
            params.put(FIELD_RESERVER2,getReserver2());
        }
        if(!bDirtyOnly || isRowAmoutDirty()) {
            params.put(FIELD_ROWAMOUT,getRowAmout());
        }
        if(!bDirtyOnly || isRTInfoDirty()) {
            params.put(FIELD_RTINFO,getRTInfo());
        }
        if(!bDirtyOnly || isSMALLICONDirty()) {
            params.put(FIELD_SMALLICON,getSMALLICON());
        }
        if(!bDirtyOnly || isStorageTypeDirty()) {
            params.put(FIELD_STORAGETYPE,getStorageType());
        }
        if(!bDirtyOnly || isTableNameDirty()) {
            params.put(FIELD_TABLENAME,getTableName());
        }
        if(!bDirtyOnly || isTableSpaceDirty()) {
            params.put(FIELD_TABLESPACE,getTableSpace());
        }
        if(!bDirtyOnly || isTipsInfoDirty()) {
            params.put(FIELD_TIPSINFO,getTipsInfo());
        }
        if(!bDirtyOnly || isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE,getUpdateDate());
        }
        if(!bDirtyOnly || isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN,getUpdateMan());
        }
        if(!bDirtyOnly || isUserActionDirty()) {
            params.put(FIELD_USERACTION,getUserAction());
        }
        if(!bDirtyOnly || isValidFlagDirty()) {
            params.put(FIELD_VALIDFLAG,getValidFlag());
        }
        if(!bDirtyOnly || isVCFlagDirty()) {
            params.put(FIELD_VCFLAG,getVCFlag());
        }
        if(!bDirtyOnly || isVerCheckTimerDirty()) {
            params.put(FIELD_VERCHECKTIMER,getVerCheckTimer());
        }
        if(!bDirtyOnly || isVerFieldDirty()) {
            params.put(FIELD_VERFIELD,getVerField());
        }
        if(!bDirtyOnly || isVerHelperDirty()) {
            params.put(FIELD_VERHELPER,getVerHelper());
        }
        if(!bDirtyOnly || isVersionCheckDirty()) {
            params.put(FIELD_VERSIONCHECK,getVersionCheck());
        }
        if(!bDirtyOnly || isViewNameDirty()) {
            params.put(FIELD_VIEWNAME,getViewName());
        }
        super.onFillMap(params, bDirtyOnly);
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#get(java.lang.String)
     */
    @Override
    public Object get(String strParamName) throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().get(strParamName);
        }

        if(StringHelper.isNullOrEmpty(strParamName))
            throw new Exception("没有指定属性");
        Integer index=fieldIndexMap.get(strParamName.toUpperCase());
        if(index==null)
            return super.get(strParamName);

        return  DataEntityBase.get(this, index);
    }

    /**
     * 通过属性标识获取属性值
     * @param et 数据对象
     * @param index 属性标识
     * @return
     * @throws Exception
     */
    private static Object get(DataEntityBase et,int index) throws Exception {

        switch(index) {
        case INDEX_ACENABLEDP:
            return et.getACEnableDP();
        case INDEX_ACEXTINFO:
            return et.getACExtInfo();
        case INDEX_ACINFOFORMAT:
            return et.getACInfoFormat();
        case INDEX_ACINFOPARAM:
            return et.getACInfoParam();
        case INDEX_ACMAXCNT:
            return et.getACMaxCnt();
        case INDEX_ACOBJECT:
            return et.getACObject();
        case INDEX_ACQUERYMODELID:
            return et.getACQueryModelId();
        case INDEX_ACQUERYMODELNAME:
            return et.getACQueryModelName();
        case INDEX_ACSORTDIR:
            return et.getACSortDir();
        case INDEX_ACSORTFIELD:
            return et.getACSortField();
        case INDEX_BIGICON:
            return et.getBigIcon();
        case INDEX_CONFIGHELPER:
            return et.getConfigHelper();
        case INDEX_CREATEDATE:
            return et.getCreateDate();
        case INDEX_CREATEMAN:
            return et.getCreateMan();
        case INDEX_DATAACCOBJECT:
            return et.getDataAccObject();
        case INDEX_DATACHGLOGMODE:
            return et.getDataChgLogMode();
        case INDEX_DATACTRLINT:
            return et.getDataCtrlInt();
        case INDEX_DATACTRLOBJECT:
            return et.getDataCtrlObject();
        case INDEX_DATANOTIFYHELPER:
            return et.getDataNotifyHelper();
        case INDEX_DBSTORAGE:
            return et.getDBStorage();
        case INDEX_DBVERSION:
            return et.getDBVersion();
        case INDEX_DEGROUP:
            return et.getDEGroup();
        case INDEX_DEHELPER:
            return et.getDEHelper();
        case INDEX_DEID:
            return et.getDEId();
        case INDEX_DELOGICNAME:
            return et.getDELogicName();
        case INDEX_DENAME:
            return et.getDEName();
        case INDEX_DEOBJECT:
            return et.getDEObject();
        case INDEX_DEORDER:
            return et.getDEOrder();
        case INDEX_DEPARAM:
            return et.getDEParam();
        case INDEX_DER11DEID:
            return et.getDER11DEId();
        case INDEX_DER11DENAME:
            return et.getDER11DEName();
        case INDEX_DETYPE:
            return et.getDEType();
        case INDEX_DEUSERPARAM:
            return et.getDEUserParam();
        case INDEX_DEVERSION:
            return et.getDEVersion();
        case INDEX_DGROWCLASSHELPER:
            return et.getDGRowClassHelper();
        case INDEX_DGSUMMARYHEIGHT:
            return et.getDGSUMMARYHeight();
        case INDEX_DLKHELPER:
            return et.getDLKHelper();
        case INDEX_DYNAMICINTERVAL:
            return et.getDynamicInterval();
        case INDEX_ENABLECOLPRIV:
            return et.getEnableColPriv();
        case INDEX_ENABLEGLOBALMODEL:
            return et.getEnableGlobalModel();
        case INDEX_EXITINGMODEL:
            return et.getExitingModel();
        case INDEX_EXPORTINCEMPTY:
            return et.getExportIncEmpty();
        case INDEX_EXTABLENAME:
            return et.getExTableName();
        case INDEX_GLOBALMODELOBJ:
            return et.getGlobalModelObj();
        case INDEX_INDEXMODE:
            return et.getIndexMode();
        case INDEX_INFOFIELD:
            return et.getInfoField();
        case INDEX_INFOFORMAT:
            return et.getInfoFormat();
        case INDEX_INHERITMODE:
            return et.getInheritMode();
        case INDEX_ISDGROWEDIT:
            return et.getIsDGRowEdit();
        case INDEX_ISENABLEAUDIT:
            return et.getIsEnableAudit();
        case INDEX_ISENABLEDP:
            return et.getIsEnableDP();
        case INDEX_ISINDEXDE:
            return et.getIsIndexDE();
        case INDEX_ISLOGICVALID:
            return et.getIsLogicValid();
        case INDEX_ISMULTIPRINT:
            return et.getISMULTIPRINT();
        case INDEX_ISSUPPORTFA:
            return et.getISSupportFA();
        case INDEX_ISSYSTEM:
            return et.getIsSystem();
        case INDEX_KEYPARAMS:
            return et.getKeyParams();
        case INDEX_LICENSECODE:
            return et.getLicenseCode();
        case INDEX_LOGAUDITDETAIL:
            return et.getLogAuditDetail();
        case INDEX_MEMO:
            return et.getMemo();
        case INDEX_MINORFIELDNAME:
            return et.getMinorFieldName();
        case INDEX_MINORFIELDVALUE:
            return et.getMinorFieldValue();
        case INDEX_MINORTABLENAME:
            return et.getMinorTableName();
        case INDEX_MUTLIMAJOR:
            return et.getMutliMajor();
        case INDEX_NODATAINFO:
            return et.getNoDataInfo();
        case INDEX_PRINTFUNC:
            return et.getPrintFunc();
        case INDEX_RESERVER:
            return et.getReserver();
        case INDEX_RESERVER2:
            return et.getReserver2();
        case INDEX_ROWAMOUT:
            return et.getRowAmout();
        case INDEX_RTINFO:
            return et.getRTInfo();
        case INDEX_SMALLICON:
            return et.getSMALLICON();
        case INDEX_STORAGETYPE:
            return et.getStorageType();
        case INDEX_TABLENAME:
            return et.getTableName();
        case INDEX_TABLESPACE:
            return et.getTableSpace();
        case INDEX_TIPSINFO:
            return et.getTipsInfo();
        case INDEX_UPDATEDATE:
            return et.getUpdateDate();
        case INDEX_UPDATEMAN:
            return et.getUpdateMan();
        case INDEX_USERACTION:
            return et.getUserAction();
        case INDEX_VALIDFLAG:
            return et.getValidFlag();
        case INDEX_VCFLAG:
            return et.getVCFlag();
        case INDEX_VERCHECKTIMER:
            return et.getVerCheckTimer();
        case INDEX_VERFIELD:
            return et.getVerField();
        case INDEX_VERHELPER:
            return et.getVerHelper();
        case INDEX_VERSIONCHECK:
            return et.getVersionCheck();
        case INDEX_VIEWNAME:
            return et.getViewName();
        default:
            throw new Exception("不明属性标识");
        }
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#set(java.lang.String, java.lang.Object)
     */
    @Override
    public void set(String strParamName,Object objValue) throws Exception {
        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().set(strParamName,objValue);
            return;
        }
        if(StringHelper.isNullOrEmpty(strParamName))
            throw new Exception("没有指定属性");

        Integer index=fieldIndexMap.get(strParamName.toUpperCase());
        if(index==null) {
            super.set(strParamName,objValue);
            return;
        }

        DataEntityBase.set(this,index,objValue);
    }

    /**
     * 通过属性标识设定属性值
     * @param et 数据对象
     * @param index 属性标识
     * @param obj 值
     * @throws Exception
     */
    private static void set(DataEntityBase et,int index,Object obj) throws Exception {
        switch(index) {
        case INDEX_ACENABLEDP:
            et.setACEnableDP(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_ACEXTINFO:
            et.setACExtInfo(DataObject.getStringValue(obj));
            return ;
        case INDEX_ACINFOFORMAT:
            et.setACInfoFormat(DataObject.getStringValue(obj));
            return ;
        case INDEX_ACINFOPARAM:
            et.setACInfoParam(DataObject.getStringValue(obj));
            return ;
        case INDEX_ACMAXCNT:
            et.setACMaxCnt(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_ACOBJECT:
            et.setACObject(DataObject.getStringValue(obj));
            return ;
        case INDEX_ACQUERYMODELID:
            et.setACQueryModelId(DataObject.getStringValue(obj));
            return ;
        case INDEX_ACQUERYMODELNAME:
            et.setACQueryModelName(DataObject.getStringValue(obj));
            return ;
        case INDEX_ACSORTDIR:
            et.setACSortDir(DataObject.getStringValue(obj));
            return ;
        case INDEX_ACSORTFIELD:
            et.setACSortField(DataObject.getStringValue(obj));
            return ;
        case INDEX_BIGICON:
            et.setBigIcon(DataObject.getStringValue(obj));
            return ;
        case INDEX_CONFIGHELPER:
            et.setConfigHelper(DataObject.getStringValue(obj));
            return ;
        case INDEX_CREATEDATE:
            et.setCreateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_CREATEMAN:
            et.setCreateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_DATAACCOBJECT:
            et.setDataAccObject(DataObject.getStringValue(obj));
            return ;
        case INDEX_DATACHGLOGMODE:
            et.setDataChgLogMode(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_DATACTRLINT:
            et.setDataCtrlInt(DataObject.getStringValue(obj));
            return ;
        case INDEX_DATACTRLOBJECT:
            et.setDataCtrlObject(DataObject.getStringValue(obj));
            return ;
        case INDEX_DATANOTIFYHELPER:
            et.setDataNotifyHelper(DataObject.getStringValue(obj));
            return ;
        case INDEX_DBSTORAGE:
            et.setDBStorage(DataObject.getStringValue(obj));
            return ;
        case INDEX_DBVERSION:
            et.setDBVersion(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_DEGROUP:
            et.setDEGroup(DataObject.getStringValue(obj));
            return ;
        case INDEX_DEHELPER:
            et.setDEHelper(DataObject.getStringValue(obj));
            return ;
        case INDEX_DEID:
            et.setDEId(DataObject.getStringValue(obj));
            return ;
        case INDEX_DELOGICNAME:
            et.setDELogicName(DataObject.getStringValue(obj));
            return ;
        case INDEX_DENAME:
            et.setDEName(DataObject.getStringValue(obj));
            return ;
        case INDEX_DEOBJECT:
            et.setDEObject(DataObject.getStringValue(obj));
            return ;
        case INDEX_DEORDER:
            et.setDEOrder(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_DEPARAM:
            et.setDEParam(DataObject.getStringValue(obj));
            return ;
        case INDEX_DER11DEID:
            et.setDER11DEId(DataObject.getStringValue(obj));
            return ;
        case INDEX_DER11DENAME:
            et.setDER11DEName(DataObject.getStringValue(obj));
            return ;
        case INDEX_DETYPE:
            et.setDEType(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_DEUSERPARAM:
            et.setDEUserParam(DataObject.getStringValue(obj));
            return ;
        case INDEX_DEVERSION:
            et.setDEVersion(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_DGROWCLASSHELPER:
            et.setDGRowClassHelper(DataObject.getStringValue(obj));
            return ;
        case INDEX_DGSUMMARYHEIGHT:
            et.setDGSUMMARYHeight(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_DLKHELPER:
            et.setDLKHelper(DataObject.getStringValue(obj));
            return ;
        case INDEX_DYNAMICINTERVAL:
            et.setDynamicInterval(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_ENABLECOLPRIV:
            et.setEnableColPriv(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_ENABLEGLOBALMODEL:
            et.setEnableGlobalModel(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_EXITINGMODEL:
            et.setExitingModel(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_EXPORTINCEMPTY:
            et.setExportIncEmpty(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_EXTABLENAME:
            et.setExTableName(DataObject.getStringValue(obj));
            return ;
        case INDEX_GLOBALMODELOBJ:
            et.setGlobalModelObj(DataObject.getStringValue(obj));
            return ;
        case INDEX_INDEXMODE:
            et.setIndexMode(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_INFOFIELD:
            et.setInfoField(DataObject.getStringValue(obj));
            return ;
        case INDEX_INFOFORMAT:
            et.setInfoFormat(DataObject.getStringValue(obj));
            return ;
        case INDEX_INHERITMODE:
            et.setInheritMode(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_ISDGROWEDIT:
            et.setIsDGRowEdit(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_ISENABLEAUDIT:
            et.setIsEnableAudit(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_ISENABLEDP:
            et.setIsEnableDP(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_ISINDEXDE:
            et.setIsIndexDE(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_ISLOGICVALID:
            et.setIsLogicValid(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_ISMULTIPRINT:
            et.setISMULTIPRINT(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_ISSUPPORTFA:
            et.setISSupportFA(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_ISSYSTEM:
            et.setIsSystem(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_KEYPARAMS:
            et.setKeyParams(DataObject.getStringValue(obj));
            return ;
        case INDEX_LICENSECODE:
            et.setLicenseCode(DataObject.getStringValue(obj));
            return ;
        case INDEX_LOGAUDITDETAIL:
            et.setLogAuditDetail(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_MEMO:
            et.setMemo(DataObject.getStringValue(obj));
            return ;
        case INDEX_MINORFIELDNAME:
            et.setMinorFieldName(DataObject.getStringValue(obj));
            return ;
        case INDEX_MINORFIELDVALUE:
            et.setMinorFieldValue(DataObject.getStringValue(obj));
            return ;
        case INDEX_MINORTABLENAME:
            et.setMinorTableName(DataObject.getStringValue(obj));
            return ;
        case INDEX_MUTLIMAJOR:
            et.setMutliMajor(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_NODATAINFO:
            et.setNoDataInfo(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_PRINTFUNC:
            et.setPrintFunc(DataObject.getStringValue(obj));
            return ;
        case INDEX_RESERVER:
            et.setReserver(DataObject.getStringValue(obj));
            return ;
        case INDEX_RESERVER2:
            et.setReserver2(DataObject.getStringValue(obj));
            return ;
        case INDEX_ROWAMOUT:
            et.setRowAmout(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_RTINFO:
            et.setRTInfo(DataObject.getStringValue(obj));
            return ;
        case INDEX_SMALLICON:
            et.setSMALLICON(DataObject.getStringValue(obj));
            return ;
        case INDEX_STORAGETYPE:
            et.setStorageType(DataObject.getStringValue(obj));
            return ;
        case INDEX_TABLENAME:
            et.setTableName(DataObject.getStringValue(obj));
            return ;
        case INDEX_TABLESPACE:
            et.setTableSpace(DataObject.getStringValue(obj));
            return ;
        case INDEX_TIPSINFO:
            et.setTipsInfo(DataObject.getStringValue(obj));
            return ;
        case INDEX_UPDATEDATE:
            et.setUpdateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_UPDATEMAN:
            et.setUpdateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_USERACTION:
            et.setUserAction(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_VALIDFLAG:
            et.setValidFlag(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_VCFLAG:
            et.setVCFlag(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_VERCHECKTIMER:
            et.setVerCheckTimer(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_VERFIELD:
            et.setVerField(DataObject.getStringValue(obj));
            return ;
        case INDEX_VERHELPER:
            et.setVerHelper(DataObject.getStringValue(obj));
            return ;
        case INDEX_VERSIONCHECK:
            et.setVersionCheck(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_VIEWNAME:
            et.setViewName(DataObject.getStringValue(obj));
            return ;
        default:
            throw new Exception("不明属性标识");
        }
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#isNull(java.lang.String)
     */
    @Override
    public boolean isNull(String strParamName) throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isNull(strParamName);
        }
        if(StringHelper.isNullOrEmpty(strParamName))
            throw new Exception("没有指定属性");

        Integer index=fieldIndexMap.get(strParamName.toUpperCase());
        if(index==null)
            return super.isNull(strParamName);

        return  DataEntityBase.isNull(this, index);
    }

    /**
     * 判断指定属性值是否为空值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean isNull(DataEntityBase et,int index) throws Exception {

        switch(index) {
        case INDEX_ACENABLEDP:
            return et.getACEnableDP()==null;
        case INDEX_ACEXTINFO:
            return et.getACExtInfo()==null;
        case INDEX_ACINFOFORMAT:
            return et.getACInfoFormat()==null;
        case INDEX_ACINFOPARAM:
            return et.getACInfoParam()==null;
        case INDEX_ACMAXCNT:
            return et.getACMaxCnt()==null;
        case INDEX_ACOBJECT:
            return et.getACObject()==null;
        case INDEX_ACQUERYMODELID:
            return et.getACQueryModelId()==null;
        case INDEX_ACQUERYMODELNAME:
            return et.getACQueryModelName()==null;
        case INDEX_ACSORTDIR:
            return et.getACSortDir()==null;
        case INDEX_ACSORTFIELD:
            return et.getACSortField()==null;
        case INDEX_BIGICON:
            return et.getBigIcon()==null;
        case INDEX_CONFIGHELPER:
            return et.getConfigHelper()==null;
        case INDEX_CREATEDATE:
            return et.getCreateDate()==null;
        case INDEX_CREATEMAN:
            return et.getCreateMan()==null;
        case INDEX_DATAACCOBJECT:
            return et.getDataAccObject()==null;
        case INDEX_DATACHGLOGMODE:
            return et.getDataChgLogMode()==null;
        case INDEX_DATACTRLINT:
            return et.getDataCtrlInt()==null;
        case INDEX_DATACTRLOBJECT:
            return et.getDataCtrlObject()==null;
        case INDEX_DATANOTIFYHELPER:
            return et.getDataNotifyHelper()==null;
        case INDEX_DBSTORAGE:
            return et.getDBStorage()==null;
        case INDEX_DBVERSION:
            return et.getDBVersion()==null;
        case INDEX_DEGROUP:
            return et.getDEGroup()==null;
        case INDEX_DEHELPER:
            return et.getDEHelper()==null;
        case INDEX_DEID:
            return et.getDEId()==null;
        case INDEX_DELOGICNAME:
            return et.getDELogicName()==null;
        case INDEX_DENAME:
            return et.getDEName()==null;
        case INDEX_DEOBJECT:
            return et.getDEObject()==null;
        case INDEX_DEORDER:
            return et.getDEOrder()==null;
        case INDEX_DEPARAM:
            return et.getDEParam()==null;
        case INDEX_DER11DEID:
            return et.getDER11DEId()==null;
        case INDEX_DER11DENAME:
            return et.getDER11DEName()==null;
        case INDEX_DETYPE:
            return et.getDEType()==null;
        case INDEX_DEUSERPARAM:
            return et.getDEUserParam()==null;
        case INDEX_DEVERSION:
            return et.getDEVersion()==null;
        case INDEX_DGROWCLASSHELPER:
            return et.getDGRowClassHelper()==null;
        case INDEX_DGSUMMARYHEIGHT:
            return et.getDGSUMMARYHeight()==null;
        case INDEX_DLKHELPER:
            return et.getDLKHelper()==null;
        case INDEX_DYNAMICINTERVAL:
            return et.getDynamicInterval()==null;
        case INDEX_ENABLECOLPRIV:
            return et.getEnableColPriv()==null;
        case INDEX_ENABLEGLOBALMODEL:
            return et.getEnableGlobalModel()==null;
        case INDEX_EXITINGMODEL:
            return et.getExitingModel()==null;
        case INDEX_EXPORTINCEMPTY:
            return et.getExportIncEmpty()==null;
        case INDEX_EXTABLENAME:
            return et.getExTableName()==null;
        case INDEX_GLOBALMODELOBJ:
            return et.getGlobalModelObj()==null;
        case INDEX_INDEXMODE:
            return et.getIndexMode()==null;
        case INDEX_INFOFIELD:
            return et.getInfoField()==null;
        case INDEX_INFOFORMAT:
            return et.getInfoFormat()==null;
        case INDEX_INHERITMODE:
            return et.getInheritMode()==null;
        case INDEX_ISDGROWEDIT:
            return et.getIsDGRowEdit()==null;
        case INDEX_ISENABLEAUDIT:
            return et.getIsEnableAudit()==null;
        case INDEX_ISENABLEDP:
            return et.getIsEnableDP()==null;
        case INDEX_ISINDEXDE:
            return et.getIsIndexDE()==null;
        case INDEX_ISLOGICVALID:
            return et.getIsLogicValid()==null;
        case INDEX_ISMULTIPRINT:
            return et.getISMULTIPRINT()==null;
        case INDEX_ISSUPPORTFA:
            return et.getISSupportFA()==null;
        case INDEX_ISSYSTEM:
            return et.getIsSystem()==null;
        case INDEX_KEYPARAMS:
            return et.getKeyParams()==null;
        case INDEX_LICENSECODE:
            return et.getLicenseCode()==null;
        case INDEX_LOGAUDITDETAIL:
            return et.getLogAuditDetail()==null;
        case INDEX_MEMO:
            return et.getMemo()==null;
        case INDEX_MINORFIELDNAME:
            return et.getMinorFieldName()==null;
        case INDEX_MINORFIELDVALUE:
            return et.getMinorFieldValue()==null;
        case INDEX_MINORTABLENAME:
            return et.getMinorTableName()==null;
        case INDEX_MUTLIMAJOR:
            return et.getMutliMajor()==null;
        case INDEX_NODATAINFO:
            return et.getNoDataInfo()==null;
        case INDEX_PRINTFUNC:
            return et.getPrintFunc()==null;
        case INDEX_RESERVER:
            return et.getReserver()==null;
        case INDEX_RESERVER2:
            return et.getReserver2()==null;
        case INDEX_ROWAMOUT:
            return et.getRowAmout()==null;
        case INDEX_RTINFO:
            return et.getRTInfo()==null;
        case INDEX_SMALLICON:
            return et.getSMALLICON()==null;
        case INDEX_STORAGETYPE:
            return et.getStorageType()==null;
        case INDEX_TABLENAME:
            return et.getTableName()==null;
        case INDEX_TABLESPACE:
            return et.getTableSpace()==null;
        case INDEX_TIPSINFO:
            return et.getTipsInfo()==null;
        case INDEX_UPDATEDATE:
            return et.getUpdateDate()==null;
        case INDEX_UPDATEMAN:
            return et.getUpdateMan()==null;
        case INDEX_USERACTION:
            return et.getUserAction()==null;
        case INDEX_VALIDFLAG:
            return et.getValidFlag()==null;
        case INDEX_VCFLAG:
            return et.getVCFlag()==null;
        case INDEX_VERCHECKTIMER:
            return et.getVerCheckTimer()==null;
        case INDEX_VERFIELD:
            return et.getVerField()==null;
        case INDEX_VERHELPER:
            return et.getVerHelper()==null;
        case INDEX_VERSIONCHECK:
            return et.getVersionCheck()==null;
        case INDEX_VIEWNAME:
            return et.getViewName()==null;
        default:
            throw new Exception("不明属性标识");
        }
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#contains(java.lang.String)
     */
    @Override
    public boolean contains(String strParamName) throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().contains(strParamName);
        }
        if(StringHelper.isNullOrEmpty(strParamName))
            throw new Exception("没有指定属性");
        Integer index=fieldIndexMap.get(strParamName.toUpperCase());
        if(index==null)
            return super.contains(strParamName);
        return  DataEntityBase.contains(this, index);
    }

    /**
     * 获取判断对象是否存在指定属性值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean contains(DataEntityBase et,int index) throws Exception {

        switch(index) {
        case INDEX_ACENABLEDP:
            return et.isACEnableDPDirty();
        case INDEX_ACEXTINFO:
            return et.isACExtInfoDirty();
        case INDEX_ACINFOFORMAT:
            return et.isACInfoFormatDirty();
        case INDEX_ACINFOPARAM:
            return et.isACInfoParamDirty();
        case INDEX_ACMAXCNT:
            return et.isACMaxCntDirty();
        case INDEX_ACOBJECT:
            return et.isACObjectDirty();
        case INDEX_ACQUERYMODELID:
            return et.isACQueryModelIdDirty();
        case INDEX_ACQUERYMODELNAME:
            return et.isACQueryModelNameDirty();
        case INDEX_ACSORTDIR:
            return et.isACSortDirDirty();
        case INDEX_ACSORTFIELD:
            return et.isACSortFieldDirty();
        case INDEX_BIGICON:
            return et.isBigIconDirty();
        case INDEX_CONFIGHELPER:
            return et.isConfigHelperDirty();
        case INDEX_CREATEDATE:
            return et.isCreateDateDirty();
        case INDEX_CREATEMAN:
            return et.isCreateManDirty();
        case INDEX_DATAACCOBJECT:
            return et.isDataAccObjectDirty();
        case INDEX_DATACHGLOGMODE:
            return et.isDataChgLogModeDirty();
        case INDEX_DATACTRLINT:
            return et.isDataCtrlIntDirty();
        case INDEX_DATACTRLOBJECT:
            return et.isDataCtrlObjectDirty();
        case INDEX_DATANOTIFYHELPER:
            return et.isDataNotifyHelperDirty();
        case INDEX_DBSTORAGE:
            return et.isDBStorageDirty();
        case INDEX_DBVERSION:
            return et.isDBVersionDirty();
        case INDEX_DEGROUP:
            return et.isDEGroupDirty();
        case INDEX_DEHELPER:
            return et.isDEHelperDirty();
        case INDEX_DEID:
            return et.isDEIdDirty();
        case INDEX_DELOGICNAME:
            return et.isDELogicNameDirty();
        case INDEX_DENAME:
            return et.isDENameDirty();
        case INDEX_DEOBJECT:
            return et.isDEObjectDirty();
        case INDEX_DEORDER:
            return et.isDEOrderDirty();
        case INDEX_DEPARAM:
            return et.isDEParamDirty();
        case INDEX_DER11DEID:
            return et.isDER11DEIdDirty();
        case INDEX_DER11DENAME:
            return et.isDER11DENameDirty();
        case INDEX_DETYPE:
            return et.isDETypeDirty();
        case INDEX_DEUSERPARAM:
            return et.isDEUserParamDirty();
        case INDEX_DEVERSION:
            return et.isDEVersionDirty();
        case INDEX_DGROWCLASSHELPER:
            return et.isDGRowClassHelperDirty();
        case INDEX_DGSUMMARYHEIGHT:
            return et.isDGSUMMARYHeightDirty();
        case INDEX_DLKHELPER:
            return et.isDLKHelperDirty();
        case INDEX_DYNAMICINTERVAL:
            return et.isDynamicIntervalDirty();
        case INDEX_ENABLECOLPRIV:
            return et.isEnableColPrivDirty();
        case INDEX_ENABLEGLOBALMODEL:
            return et.isEnableGlobalModelDirty();
        case INDEX_EXITINGMODEL:
            return et.isExitingModelDirty();
        case INDEX_EXPORTINCEMPTY:
            return et.isExportIncEmptyDirty();
        case INDEX_EXTABLENAME:
            return et.isExTableNameDirty();
        case INDEX_GLOBALMODELOBJ:
            return et.isGlobalModelObjDirty();
        case INDEX_INDEXMODE:
            return et.isIndexModeDirty();
        case INDEX_INFOFIELD:
            return et.isInfoFieldDirty();
        case INDEX_INFOFORMAT:
            return et.isInfoFormatDirty();
        case INDEX_INHERITMODE:
            return et.isInheritModeDirty();
        case INDEX_ISDGROWEDIT:
            return et.isIsDGRowEditDirty();
        case INDEX_ISENABLEAUDIT:
            return et.isIsEnableAuditDirty();
        case INDEX_ISENABLEDP:
            return et.isIsEnableDPDirty();
        case INDEX_ISINDEXDE:
            return et.isIsIndexDEDirty();
        case INDEX_ISLOGICVALID:
            return et.isIsLogicValidDirty();
        case INDEX_ISMULTIPRINT:
            return et.isISMULTIPRINTDirty();
        case INDEX_ISSUPPORTFA:
            return et.isISSupportFADirty();
        case INDEX_ISSYSTEM:
            return et.isIsSystemDirty();
        case INDEX_KEYPARAMS:
            return et.isKeyParamsDirty();
        case INDEX_LICENSECODE:
            return et.isLicenseCodeDirty();
        case INDEX_LOGAUDITDETAIL:
            return et.isLogAuditDetailDirty();
        case INDEX_MEMO:
            return et.isMemoDirty();
        case INDEX_MINORFIELDNAME:
            return et.isMinorFieldNameDirty();
        case INDEX_MINORFIELDVALUE:
            return et.isMinorFieldValueDirty();
        case INDEX_MINORTABLENAME:
            return et.isMinorTableNameDirty();
        case INDEX_MUTLIMAJOR:
            return et.isMutliMajorDirty();
        case INDEX_NODATAINFO:
            return et.isNoDataInfoDirty();
        case INDEX_PRINTFUNC:
            return et.isPrintFuncDirty();
        case INDEX_RESERVER:
            return et.isReserverDirty();
        case INDEX_RESERVER2:
            return et.isReserver2Dirty();
        case INDEX_ROWAMOUT:
            return et.isRowAmoutDirty();
        case INDEX_RTINFO:
            return et.isRTInfoDirty();
        case INDEX_SMALLICON:
            return et.isSMALLICONDirty();
        case INDEX_STORAGETYPE:
            return et.isStorageTypeDirty();
        case INDEX_TABLENAME:
            return et.isTableNameDirty();
        case INDEX_TABLESPACE:
            return et.isTableSpaceDirty();
        case INDEX_TIPSINFO:
            return et.isTipsInfoDirty();
        case INDEX_UPDATEDATE:
            return et.isUpdateDateDirty();
        case INDEX_UPDATEMAN:
            return et.isUpdateManDirty();
        case INDEX_USERACTION:
            return et.isUserActionDirty();
        case INDEX_VALIDFLAG:
            return et.isValidFlagDirty();
        case INDEX_VCFLAG:
            return et.isVCFlagDirty();
        case INDEX_VERCHECKTIMER:
            return et.isVerCheckTimerDirty();
        case INDEX_VERFIELD:
            return et.isVerFieldDirty();
        case INDEX_VERHELPER:
            return et.isVerHelperDirty();
        case INDEX_VERSIONCHECK:
            return et.isVersionCheckDirty();
        case INDEX_VIEWNAME:
            return et.isViewNameDirty();
        default:
            throw new Exception("不明属性标识");
        }
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onFillJSONObject(net.sf.json.JSONObject, boolean)
     */
    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        fillJSONObject(this,objJSON,bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    /**
     * 填充当前对象到JSON
     * @param et 当前数据对象
     * @param json JSON对象
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static  void fillJSONObject(DataEntityBase et,JSONObject json, boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getACEnableDP()!=null) {
            JSONObjectHelper.put(json,"acenabledp",getJSONValue(et.getACEnableDP()),false);
        }
        if(bIncEmpty||et.getACExtInfo()!=null) {
            JSONObjectHelper.put(json,"acextinfo",getJSONValue(et.getACExtInfo()),false);
        }
        if(bIncEmpty||et.getACInfoFormat()!=null) {
            JSONObjectHelper.put(json,"acinfoformat",getJSONValue(et.getACInfoFormat()),false);
        }
        if(bIncEmpty||et.getACInfoParam()!=null) {
            JSONObjectHelper.put(json,"acinfoparam",getJSONValue(et.getACInfoParam()),false);
        }
        if(bIncEmpty||et.getACMaxCnt()!=null) {
            JSONObjectHelper.put(json,"acmaxcnt",getJSONValue(et.getACMaxCnt()),false);
        }
        if(bIncEmpty||et.getACObject()!=null) {
            JSONObjectHelper.put(json,"acobject",getJSONValue(et.getACObject()),false);
        }
        if(bIncEmpty||et.getACQueryModelId()!=null) {
            JSONObjectHelper.put(json,"acquerymodelid",getJSONValue(et.getACQueryModelId()),false);
        }
        if(bIncEmpty||et.getACQueryModelName()!=null) {
            JSONObjectHelper.put(json,"acquerymodelname",getJSONValue(et.getACQueryModelName()),false);
        }
        if(bIncEmpty||et.getACSortDir()!=null) {
            JSONObjectHelper.put(json,"acsortdir",getJSONValue(et.getACSortDir()),false);
        }
        if(bIncEmpty||et.getACSortField()!=null) {
            JSONObjectHelper.put(json,"acsortfield",getJSONValue(et.getACSortField()),false);
        }
        if(bIncEmpty||et.getBigIcon()!=null) {
            JSONObjectHelper.put(json,"bigicon",getJSONValue(et.getBigIcon()),false);
        }
        if(bIncEmpty||et.getConfigHelper()!=null) {
            JSONObjectHelper.put(json,"confighelper",getJSONValue(et.getConfigHelper()),false);
        }
        if(bIncEmpty||et.getCreateDate()!=null) {
            JSONObjectHelper.put(json,"createdate",getJSONValue(et.getCreateDate()),false);
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            JSONObjectHelper.put(json,"createman",getJSONValue(et.getCreateMan()),false);
        }
        if(bIncEmpty||et.getDataAccObject()!=null) {
            JSONObjectHelper.put(json,"dataaccobject",getJSONValue(et.getDataAccObject()),false);
        }
        if(bIncEmpty||et.getDataChgLogMode()!=null) {
            JSONObjectHelper.put(json,"datachglogmode",getJSONValue(et.getDataChgLogMode()),false);
        }
        if(bIncEmpty||et.getDataCtrlInt()!=null) {
            JSONObjectHelper.put(json,"datactrlint",getJSONValue(et.getDataCtrlInt()),false);
        }
        if(bIncEmpty||et.getDataCtrlObject()!=null) {
            JSONObjectHelper.put(json,"datactrlobject",getJSONValue(et.getDataCtrlObject()),false);
        }
        if(bIncEmpty||et.getDataNotifyHelper()!=null) {
            JSONObjectHelper.put(json,"datanotifyhelper",getJSONValue(et.getDataNotifyHelper()),false);
        }
        if(bIncEmpty||et.getDBStorage()!=null) {
            JSONObjectHelper.put(json,"dbstorage",getJSONValue(et.getDBStorage()),false);
        }
        if(bIncEmpty||et.getDBVersion()!=null) {
            JSONObjectHelper.put(json,"dbversion",getJSONValue(et.getDBVersion()),false);
        }
        if(bIncEmpty||et.getDEGroup()!=null) {
            JSONObjectHelper.put(json,"degroup",getJSONValue(et.getDEGroup()),false);
        }
        if(bIncEmpty||et.getDEHelper()!=null) {
            JSONObjectHelper.put(json,"dehelper",getJSONValue(et.getDEHelper()),false);
        }
        if(bIncEmpty||et.getDEId()!=null) {
            JSONObjectHelper.put(json,"deid",getJSONValue(et.getDEId()),false);
        }
        if(bIncEmpty||et.getDELogicName()!=null) {
            JSONObjectHelper.put(json,"delogicname",getJSONValue(et.getDELogicName()),false);
        }
        if(bIncEmpty||et.getDEName()!=null) {
            JSONObjectHelper.put(json,"dename",getJSONValue(et.getDEName()),false);
        }
        if(bIncEmpty||et.getDEObject()!=null) {
            JSONObjectHelper.put(json,"deobject",getJSONValue(et.getDEObject()),false);
        }
        if(bIncEmpty||et.getDEOrder()!=null) {
            JSONObjectHelper.put(json,"deorder",getJSONValue(et.getDEOrder()),false);
        }
        if(bIncEmpty||et.getDEParam()!=null) {
            JSONObjectHelper.put(json,"deparam",getJSONValue(et.getDEParam()),false);
        }
        if(bIncEmpty||et.getDER11DEId()!=null) {
            JSONObjectHelper.put(json,"der11deid",getJSONValue(et.getDER11DEId()),false);
        }
        if(bIncEmpty||et.getDER11DEName()!=null) {
            JSONObjectHelper.put(json,"der11dename",getJSONValue(et.getDER11DEName()),false);
        }
        if(bIncEmpty||et.getDEType()!=null) {
            JSONObjectHelper.put(json,"detype",getJSONValue(et.getDEType()),false);
        }
        if(bIncEmpty||et.getDEUserParam()!=null) {
            JSONObjectHelper.put(json,"deuserparam",getJSONValue(et.getDEUserParam()),false);
        }
        if(bIncEmpty||et.getDEVersion()!=null) {
            JSONObjectHelper.put(json,"deversion",getJSONValue(et.getDEVersion()),false);
        }
        if(bIncEmpty||et.getDGRowClassHelper()!=null) {
            JSONObjectHelper.put(json,"dgrowclasshelper",getJSONValue(et.getDGRowClassHelper()),false);
        }
        if(bIncEmpty||et.getDGSUMMARYHeight()!=null) {
            JSONObjectHelper.put(json,"dgsummaryheight",getJSONValue(et.getDGSUMMARYHeight()),false);
        }
        if(bIncEmpty||et.getDLKHelper()!=null) {
            JSONObjectHelper.put(json,"dlkhelper",getJSONValue(et.getDLKHelper()),false);
        }
        if(bIncEmpty||et.getDynamicInterval()!=null) {
            JSONObjectHelper.put(json,"dynamicinterval",getJSONValue(et.getDynamicInterval()),false);
        }
        if(bIncEmpty||et.getEnableColPriv()!=null) {
            JSONObjectHelper.put(json,"enablecolpriv",getJSONValue(et.getEnableColPriv()),false);
        }
        if(bIncEmpty||et.getEnableGlobalModel()!=null) {
            JSONObjectHelper.put(json,"enableglobalmodel",getJSONValue(et.getEnableGlobalModel()),false);
        }
        if(bIncEmpty||et.getExitingModel()!=null) {
            JSONObjectHelper.put(json,"exitingmodel",getJSONValue(et.getExitingModel()),false);
        }
        if(bIncEmpty||et.getExportIncEmpty()!=null) {
            JSONObjectHelper.put(json,"exportincempty",getJSONValue(et.getExportIncEmpty()),false);
        }
        if(bIncEmpty||et.getExTableName()!=null) {
            JSONObjectHelper.put(json,"extablename",getJSONValue(et.getExTableName()),false);
        }
        if(bIncEmpty||et.getGlobalModelObj()!=null) {
            JSONObjectHelper.put(json,"globalmodelobj",getJSONValue(et.getGlobalModelObj()),false);
        }
        if(bIncEmpty||et.getIndexMode()!=null) {
            JSONObjectHelper.put(json,"indexmode",getJSONValue(et.getIndexMode()),false);
        }
        if(bIncEmpty||et.getInfoField()!=null) {
            JSONObjectHelper.put(json,"infofield",getJSONValue(et.getInfoField()),false);
        }
        if(bIncEmpty||et.getInfoFormat()!=null) {
            JSONObjectHelper.put(json,"infoformat",getJSONValue(et.getInfoFormat()),false);
        }
        if(bIncEmpty||et.getInheritMode()!=null) {
            JSONObjectHelper.put(json,"inheritmode",getJSONValue(et.getInheritMode()),false);
        }
        if(bIncEmpty||et.getIsDGRowEdit()!=null) {
            JSONObjectHelper.put(json,"isdgrowedit",getJSONValue(et.getIsDGRowEdit()),false);
        }
        if(bIncEmpty||et.getIsEnableAudit()!=null) {
            JSONObjectHelper.put(json,"isenableaudit",getJSONValue(et.getIsEnableAudit()),false);
        }
        if(bIncEmpty||et.getIsEnableDP()!=null) {
            JSONObjectHelper.put(json,"isenabledp",getJSONValue(et.getIsEnableDP()),false);
        }
        if(bIncEmpty||et.getIsIndexDE()!=null) {
            JSONObjectHelper.put(json,"isindexde",getJSONValue(et.getIsIndexDE()),false);
        }
        if(bIncEmpty||et.getIsLogicValid()!=null) {
            JSONObjectHelper.put(json,"islogicvalid",getJSONValue(et.getIsLogicValid()),false);
        }
        if(bIncEmpty||et.getISMULTIPRINT()!=null) {
            JSONObjectHelper.put(json,"ismultiprint",getJSONValue(et.getISMULTIPRINT()),false);
        }
        if(bIncEmpty||et.getISSupportFA()!=null) {
            JSONObjectHelper.put(json,"issupportfa",getJSONValue(et.getISSupportFA()),false);
        }
        if(bIncEmpty||et.getIsSystem()!=null) {
            JSONObjectHelper.put(json,"issystem",getJSONValue(et.getIsSystem()),false);
        }
        if(bIncEmpty||et.getKeyParams()!=null) {
            JSONObjectHelper.put(json,"keyparams",getJSONValue(et.getKeyParams()),false);
        }
        if(bIncEmpty||et.getLicenseCode()!=null) {
            JSONObjectHelper.put(json,"licensecode",getJSONValue(et.getLicenseCode()),false);
        }
        if(bIncEmpty||et.getLogAuditDetail()!=null) {
            JSONObjectHelper.put(json,"logauditdetail",getJSONValue(et.getLogAuditDetail()),false);
        }
        if(bIncEmpty||et.getMemo()!=null) {
            JSONObjectHelper.put(json,"memo",getJSONValue(et.getMemo()),false);
        }
        if(bIncEmpty||et.getMinorFieldName()!=null) {
            JSONObjectHelper.put(json,"minorfieldname",getJSONValue(et.getMinorFieldName()),false);
        }
        if(bIncEmpty||et.getMinorFieldValue()!=null) {
            JSONObjectHelper.put(json,"minorfieldvalue",getJSONValue(et.getMinorFieldValue()),false);
        }
        if(bIncEmpty||et.getMinorTableName()!=null) {
            JSONObjectHelper.put(json,"minortablename",getJSONValue(et.getMinorTableName()),false);
        }
        if(bIncEmpty||et.getMutliMajor()!=null) {
            JSONObjectHelper.put(json,"multimajor",getJSONValue(et.getMutliMajor()),false);
        }
        if(bIncEmpty||et.getNoDataInfo()!=null) {
            JSONObjectHelper.put(json,"nodatainfo",getJSONValue(et.getNoDataInfo()),false);
        }
        if(bIncEmpty||et.getPrintFunc()!=null) {
            JSONObjectHelper.put(json,"printfunc",getJSONValue(et.getPrintFunc()),false);
        }
        if(bIncEmpty||et.getReserver()!=null) {
            JSONObjectHelper.put(json,"reserver",getJSONValue(et.getReserver()),false);
        }
        if(bIncEmpty||et.getReserver2()!=null) {
            JSONObjectHelper.put(json,"reserver2",getJSONValue(et.getReserver2()),false);
        }
        if(bIncEmpty||et.getRowAmout()!=null) {
            JSONObjectHelper.put(json,"rowamount",getJSONValue(et.getRowAmout()),false);
        }
        if(bIncEmpty||et.getRTInfo()!=null) {
            JSONObjectHelper.put(json,"rtinfo",getJSONValue(et.getRTInfo()),false);
        }
        if(bIncEmpty||et.getSMALLICON()!=null) {
            JSONObjectHelper.put(json,"smallicon",getJSONValue(et.getSMALLICON()),false);
        }
        if(bIncEmpty||et.getStorageType()!=null) {
            JSONObjectHelper.put(json,"storagetype",getJSONValue(et.getStorageType()),false);
        }
        if(bIncEmpty||et.getTableName()!=null) {
            JSONObjectHelper.put(json,"tablename",getJSONValue(et.getTableName()),false);
        }
        if(bIncEmpty||et.getTableSpace()!=null) {
            JSONObjectHelper.put(json,"tablespace",getJSONValue(et.getTableSpace()),false);
        }
        if(bIncEmpty||et.getTipsInfo()!=null) {
            JSONObjectHelper.put(json,"tipsinfo",getJSONValue(et.getTipsInfo()),false);
        }
        if(bIncEmpty||et.getUpdateDate()!=null) {
            JSONObjectHelper.put(json,"updatedate",getJSONValue(et.getUpdateDate()),false);
        }
        if(bIncEmpty||et.getUpdateMan()!=null) {
            JSONObjectHelper.put(json,"updateman",getJSONValue(et.getUpdateMan()),false);
        }
        if(bIncEmpty||et.getUserAction()!=null) {
            JSONObjectHelper.put(json,"useraction",getJSONValue(et.getUserAction()),false);
        }
        if(bIncEmpty||et.getValidFlag()!=null) {
            JSONObjectHelper.put(json,"validflag",getJSONValue(et.getValidFlag()),false);
        }
        if(bIncEmpty||et.getVCFlag()!=null) {
            JSONObjectHelper.put(json,"vcflag",getJSONValue(et.getVCFlag()),false);
        }
        if(bIncEmpty||et.getVerCheckTimer()!=null) {
            JSONObjectHelper.put(json,"verchecktimer",getJSONValue(et.getVerCheckTimer()),false);
        }
        if(bIncEmpty||et.getVerField()!=null) {
            JSONObjectHelper.put(json,"verfield",getJSONValue(et.getVerField()),false);
        }
        if(bIncEmpty||et.getVerHelper()!=null) {
            JSONObjectHelper.put(json,"verhelper",getJSONValue(et.getVerHelper()),false);
        }
        if(bIncEmpty||et.getVersionCheck()!=null) {
            JSONObjectHelper.put(json,"versioncheck",getJSONValue(et.getVersionCheck()),false);
        }
        if(bIncEmpty||et.getViewName()!=null) {
            JSONObjectHelper.put(json,"viewname",getJSONValue(et.getViewName()),false);
        }
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onFillXmlNode(net.ibizsys.paas.xml.XmlNode, boolean)
     */
    @Override
    protected void onFillXmlNode(XmlNode xmlNode,boolean bIncludeEmpty) throws Exception {
        fillXmlNode(this,xmlNode,bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    /**
     * 填充当前对象到Xml节点中
     * @param et 当前数据对象
     * @param node Xml节点
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static void fillXmlNode(DataEntityBase et,XmlNode node,boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getACEnableDP()!=null) {
            Object obj = et.getACEnableDP();
            node.setAttribute("ACENABLEDP",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getACExtInfo()!=null) {
            Object obj = et.getACExtInfo();
            node.setAttribute("ACEXTINFO",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getACInfoFormat()!=null) {
            Object obj = et.getACInfoFormat();
            node.setAttribute("ACINFOFORMAT",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getACInfoParam()!=null) {
            Object obj = et.getACInfoParam();
            node.setAttribute("ACINFOPARAM",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getACMaxCnt()!=null) {
            Object obj = et.getACMaxCnt();
            node.setAttribute("ACMAXCNT",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getACObject()!=null) {
            Object obj = et.getACObject();
            node.setAttribute("ACOBJECT",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getACQueryModelId()!=null) {
            Object obj = et.getACQueryModelId();
            node.setAttribute("ACQUERYMODELID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getACQueryModelName()!=null) {
            Object obj = et.getACQueryModelName();
            node.setAttribute("ACQUERYMODELNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getACSortDir()!=null) {
            Object obj = et.getACSortDir();
            node.setAttribute("ACSORTDIR",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getACSortField()!=null) {
            Object obj = et.getACSortField();
            node.setAttribute("ACSORTFIELD",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getBigIcon()!=null) {
            Object obj = et.getBigIcon();
            node.setAttribute("BIGICON",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getConfigHelper()!=null) {
            Object obj = et.getConfigHelper();
            node.setAttribute("CONFIGHELPER",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getCreateDate()!=null) {
            Object obj = et.getCreateDate();
            node.setAttribute("CREATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            Object obj = et.getCreateMan();
            node.setAttribute("CREATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getDataAccObject()!=null) {
            Object obj = et.getDataAccObject();
            node.setAttribute("DATAACCOBJECT",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getDataChgLogMode()!=null) {
            Object obj = et.getDataChgLogMode();
            node.setAttribute("DATACHGLOGMODE",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getDataCtrlInt()!=null) {
            Object obj = et.getDataCtrlInt();
            node.setAttribute("DATACTRLINT",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getDataCtrlObject()!=null) {
            Object obj = et.getDataCtrlObject();
            node.setAttribute("DATACTRLOBJECT",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getDataNotifyHelper()!=null) {
            Object obj = et.getDataNotifyHelper();
            node.setAttribute("DATANOTIFYHELPER",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getDBStorage()!=null) {
            Object obj = et.getDBStorage();
            node.setAttribute("DBSTORAGE",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getDBVersion()!=null) {
            Object obj = et.getDBVersion();
            node.setAttribute("DBVERSION",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getDEGroup()!=null) {
            Object obj = et.getDEGroup();
            node.setAttribute("DEGROUP",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getDEHelper()!=null) {
            Object obj = et.getDEHelper();
            node.setAttribute("DEHELPER",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getDEId()!=null) {
            Object obj = et.getDEId();
            node.setAttribute("DEID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getDELogicName()!=null) {
            Object obj = et.getDELogicName();
            node.setAttribute("DELOGICNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getDEName()!=null) {
            Object obj = et.getDEName();
            node.setAttribute("DENAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getDEObject()!=null) {
            Object obj = et.getDEObject();
            node.setAttribute("DEOBJECT",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getDEOrder()!=null) {
            Object obj = et.getDEOrder();
            node.setAttribute("DEORDER",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getDEParam()!=null) {
            Object obj = et.getDEParam();
            node.setAttribute("DEPARAM",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getDER11DEId()!=null) {
            Object obj = et.getDER11DEId();
            node.setAttribute("DER11DEID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getDER11DEName()!=null) {
            Object obj = et.getDER11DEName();
            node.setAttribute("DER11DENAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getDEType()!=null) {
            Object obj = et.getDEType();
            node.setAttribute("DETYPE",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getDEUserParam()!=null) {
            Object obj = et.getDEUserParam();
            node.setAttribute("DEUSERPARAM",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getDEVersion()!=null) {
            Object obj = et.getDEVersion();
            node.setAttribute("DEVERSION",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getDGRowClassHelper()!=null) {
            Object obj = et.getDGRowClassHelper();
            node.setAttribute("DGROWCLASSHELPER",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getDGSUMMARYHeight()!=null) {
            Object obj = et.getDGSUMMARYHeight();
            node.setAttribute("DGSUMMARYHEIGHT",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getDLKHelper()!=null) {
            Object obj = et.getDLKHelper();
            node.setAttribute("DLKHELPER",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getDynamicInterval()!=null) {
            Object obj = et.getDynamicInterval();
            node.setAttribute("DYNAMICINTERVAL",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getEnableColPriv()!=null) {
            Object obj = et.getEnableColPriv();
            node.setAttribute("ENABLECOLPRIV",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getEnableGlobalModel()!=null) {
            Object obj = et.getEnableGlobalModel();
            node.setAttribute("ENABLEGLOBALMODEL",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getExitingModel()!=null) {
            Object obj = et.getExitingModel();
            node.setAttribute("EXITINGMODEL",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getExportIncEmpty()!=null) {
            Object obj = et.getExportIncEmpty();
            node.setAttribute("EXPORTINCEMPTY",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getExTableName()!=null) {
            Object obj = et.getExTableName();
            node.setAttribute("EXTABLENAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getGlobalModelObj()!=null) {
            Object obj = et.getGlobalModelObj();
            node.setAttribute("GLOBALMODELOBJ",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getIndexMode()!=null) {
            Object obj = et.getIndexMode();
            node.setAttribute("INDEXMODE",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getInfoField()!=null) {
            Object obj = et.getInfoField();
            node.setAttribute("INFOFIELD",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getInfoFormat()!=null) {
            Object obj = et.getInfoFormat();
            node.setAttribute("INFOFORMAT",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getInheritMode()!=null) {
            Object obj = et.getInheritMode();
            node.setAttribute("INHERITMODE",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getIsDGRowEdit()!=null) {
            Object obj = et.getIsDGRowEdit();
            node.setAttribute("ISDGROWEDIT",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getIsEnableAudit()!=null) {
            Object obj = et.getIsEnableAudit();
            node.setAttribute("ISENABLEAUDIT",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getIsEnableDP()!=null) {
            Object obj = et.getIsEnableDP();
            node.setAttribute("ISENABLEDP",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getIsIndexDE()!=null) {
            Object obj = et.getIsIndexDE();
            node.setAttribute("ISINDEXDE",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getIsLogicValid()!=null) {
            Object obj = et.getIsLogicValid();
            node.setAttribute("ISLOGICVALID",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getISMULTIPRINT()!=null) {
            Object obj = et.getISMULTIPRINT();
            node.setAttribute("ISMULTIPRINT",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getISSupportFA()!=null) {
            Object obj = et.getISSupportFA();
            node.setAttribute("ISSUPPORTFA",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getIsSystem()!=null) {
            Object obj = et.getIsSystem();
            node.setAttribute("ISSYSTEM",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getKeyParams()!=null) {
            Object obj = et.getKeyParams();
            node.setAttribute("KEYPARAMS",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getLicenseCode()!=null) {
            Object obj = et.getLicenseCode();
            node.setAttribute("LICENSECODE",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getLogAuditDetail()!=null) {
            Object obj = et.getLogAuditDetail();
            node.setAttribute("LOGAUDITDETAIL",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getMemo()!=null) {
            Object obj = et.getMemo();
            node.setAttribute("MEMO",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getMinorFieldName()!=null) {
            Object obj = et.getMinorFieldName();
            node.setAttribute("MINORFIELDNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getMinorFieldValue()!=null) {
            Object obj = et.getMinorFieldValue();
            node.setAttribute("MINORFIELDVALUE",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getMinorTableName()!=null) {
            Object obj = et.getMinorTableName();
            node.setAttribute("MINORTABLENAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getMutliMajor()!=null) {
            Object obj = et.getMutliMajor();
            node.setAttribute("MUTLIMAJOR",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getNoDataInfo()!=null) {
            Object obj = et.getNoDataInfo();
            node.setAttribute("NODATAINFO",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getPrintFunc()!=null) {
            Object obj = et.getPrintFunc();
            node.setAttribute("PRINTFUNC",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getReserver()!=null) {
            Object obj = et.getReserver();
            node.setAttribute("RESERVER",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getReserver2()!=null) {
            Object obj = et.getReserver2();
            node.setAttribute("RESERVER2",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getRowAmout()!=null) {
            Object obj = et.getRowAmout();
            node.setAttribute("ROWAMOUT",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getRTInfo()!=null) {
            Object obj = et.getRTInfo();
            node.setAttribute("RTINFO",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getSMALLICON()!=null) {
            Object obj = et.getSMALLICON();
            node.setAttribute("SMALLICON",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getStorageType()!=null) {
            Object obj = et.getStorageType();
            node.setAttribute("STORAGETYPE",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getTableName()!=null) {
            Object obj = et.getTableName();
            node.setAttribute("TABLENAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getTableSpace()!=null) {
            Object obj = et.getTableSpace();
            node.setAttribute("TABLESPACE",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getTipsInfo()!=null) {
            Object obj = et.getTipsInfo();
            node.setAttribute("TIPSINFO",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUpdateDate()!=null) {
            Object obj = et.getUpdateDate();
            node.setAttribute("UPDATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getUpdateMan()!=null) {
            Object obj = et.getUpdateMan();
            node.setAttribute("UPDATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUserAction()!=null) {
            Object obj = et.getUserAction();
            node.setAttribute("USERACTION",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getValidFlag()!=null) {
            Object obj = et.getValidFlag();
            node.setAttribute("VALIDFLAG",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getVCFlag()!=null) {
            Object obj = et.getVCFlag();
            node.setAttribute("VCFLAG",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getVerCheckTimer()!=null) {
            Object obj = et.getVerCheckTimer();
            node.setAttribute("VERCHECKTIMER",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getVerField()!=null) {
            Object obj = et.getVerField();
            node.setAttribute("VERFIELD",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getVerHelper()!=null) {
            Object obj = et.getVerHelper();
            node.setAttribute("VERHELPER",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getVersionCheck()!=null) {
            Object obj = et.getVersionCheck();
            node.setAttribute("VERSIONCHECK",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getViewName()!=null) {
            Object obj = et.getViewName();
            node.setAttribute("VIEWNAME",(obj==null)?"":(String)obj);
        }


    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onCopyTo(net.ibizsys.paas.data.IDataObject, boolean)
     */
    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        DataEntityBase.copyTo(this,dataEntity,bIncludeEmtpy);
        super.onCopyTo(dataEntity,bIncludeEmtpy);
    }

    /**
     * 复制当前对象数据到目标对象
     * @param et 当前数据对象
     * @param dst 目标数据对象
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static void copyTo(DataEntityBase et,IDataObject dst,boolean bIncEmpty) throws Exception {
        if(et.isACEnableDPDirty() && (bIncEmpty||et.getACEnableDP()!=null)) {
            dst.set(FIELD_ACENABLEDP,et.getACEnableDP());
        }
        if(et.isACExtInfoDirty() && (bIncEmpty||et.getACExtInfo()!=null)) {
            dst.set(FIELD_ACEXTINFO,et.getACExtInfo());
        }
        if(et.isACInfoFormatDirty() && (bIncEmpty||et.getACInfoFormat()!=null)) {
            dst.set(FIELD_ACINFOFORMAT,et.getACInfoFormat());
        }
        if(et.isACInfoParamDirty() && (bIncEmpty||et.getACInfoParam()!=null)) {
            dst.set(FIELD_ACINFOPARAM,et.getACInfoParam());
        }
        if(et.isACMaxCntDirty() && (bIncEmpty||et.getACMaxCnt()!=null)) {
            dst.set(FIELD_ACMAXCNT,et.getACMaxCnt());
        }
        if(et.isACObjectDirty() && (bIncEmpty||et.getACObject()!=null)) {
            dst.set(FIELD_ACOBJECT,et.getACObject());
        }
        if(et.isACQueryModelIdDirty() && (bIncEmpty||et.getACQueryModelId()!=null)) {
            dst.set(FIELD_ACQUERYMODELID,et.getACQueryModelId());
        }
        if(et.isACQueryModelNameDirty() && (bIncEmpty||et.getACQueryModelName()!=null)) {
            dst.set(FIELD_ACQUERYMODELNAME,et.getACQueryModelName());
        }
        if(et.isACSortDirDirty() && (bIncEmpty||et.getACSortDir()!=null)) {
            dst.set(FIELD_ACSORTDIR,et.getACSortDir());
        }
        if(et.isACSortFieldDirty() && (bIncEmpty||et.getACSortField()!=null)) {
            dst.set(FIELD_ACSORTFIELD,et.getACSortField());
        }
        if(et.isBigIconDirty() && (bIncEmpty||et.getBigIcon()!=null)) {
            dst.set(FIELD_BIGICON,et.getBigIcon());
        }
        if(et.isConfigHelperDirty() && (bIncEmpty||et.getConfigHelper()!=null)) {
            dst.set(FIELD_CONFIGHELPER,et.getConfigHelper());
        }
        if(et.isCreateDateDirty() && (bIncEmpty||et.getCreateDate()!=null)) {
            dst.set(FIELD_CREATEDATE,et.getCreateDate());
        }
        if(et.isCreateManDirty() && (bIncEmpty||et.getCreateMan()!=null)) {
            dst.set(FIELD_CREATEMAN,et.getCreateMan());
        }
        if(et.isDataAccObjectDirty() && (bIncEmpty||et.getDataAccObject()!=null)) {
            dst.set(FIELD_DATAACCOBJECT,et.getDataAccObject());
        }
        if(et.isDataChgLogModeDirty() && (bIncEmpty||et.getDataChgLogMode()!=null)) {
            dst.set(FIELD_DATACHGLOGMODE,et.getDataChgLogMode());
        }
        if(et.isDataCtrlIntDirty() && (bIncEmpty||et.getDataCtrlInt()!=null)) {
            dst.set(FIELD_DATACTRLINT,et.getDataCtrlInt());
        }
        if(et.isDataCtrlObjectDirty() && (bIncEmpty||et.getDataCtrlObject()!=null)) {
            dst.set(FIELD_DATACTRLOBJECT,et.getDataCtrlObject());
        }
        if(et.isDataNotifyHelperDirty() && (bIncEmpty||et.getDataNotifyHelper()!=null)) {
            dst.set(FIELD_DATANOTIFYHELPER,et.getDataNotifyHelper());
        }
        if(et.isDBStorageDirty() && (bIncEmpty||et.getDBStorage()!=null)) {
            dst.set(FIELD_DBSTORAGE,et.getDBStorage());
        }
        if(et.isDBVersionDirty() && (bIncEmpty||et.getDBVersion()!=null)) {
            dst.set(FIELD_DBVERSION,et.getDBVersion());
        }
        if(et.isDEGroupDirty() && (bIncEmpty||et.getDEGroup()!=null)) {
            dst.set(FIELD_DEGROUP,et.getDEGroup());
        }
        if(et.isDEHelperDirty() && (bIncEmpty||et.getDEHelper()!=null)) {
            dst.set(FIELD_DEHELPER,et.getDEHelper());
        }
        if(et.isDEIdDirty() && (bIncEmpty||et.getDEId()!=null)) {
            dst.set(FIELD_DEID,et.getDEId());
        }
        if(et.isDELogicNameDirty() && (bIncEmpty||et.getDELogicName()!=null)) {
            dst.set(FIELD_DELOGICNAME,et.getDELogicName());
        }
        if(et.isDENameDirty() && (bIncEmpty||et.getDEName()!=null)) {
            dst.set(FIELD_DENAME,et.getDEName());
        }
        if(et.isDEObjectDirty() && (bIncEmpty||et.getDEObject()!=null)) {
            dst.set(FIELD_DEOBJECT,et.getDEObject());
        }
        if(et.isDEOrderDirty() && (bIncEmpty||et.getDEOrder()!=null)) {
            dst.set(FIELD_DEORDER,et.getDEOrder());
        }
        if(et.isDEParamDirty() && (bIncEmpty||et.getDEParam()!=null)) {
            dst.set(FIELD_DEPARAM,et.getDEParam());
        }
        if(et.isDER11DEIdDirty() && (bIncEmpty||et.getDER11DEId()!=null)) {
            dst.set(FIELD_DER11DEID,et.getDER11DEId());
        }
        if(et.isDER11DENameDirty() && (bIncEmpty||et.getDER11DEName()!=null)) {
            dst.set(FIELD_DER11DENAME,et.getDER11DEName());
        }
        if(et.isDETypeDirty() && (bIncEmpty||et.getDEType()!=null)) {
            dst.set(FIELD_DETYPE,et.getDEType());
        }
        if(et.isDEUserParamDirty() && (bIncEmpty||et.getDEUserParam()!=null)) {
            dst.set(FIELD_DEUSERPARAM,et.getDEUserParam());
        }
        if(et.isDEVersionDirty() && (bIncEmpty||et.getDEVersion()!=null)) {
            dst.set(FIELD_DEVERSION,et.getDEVersion());
        }
        if(et.isDGRowClassHelperDirty() && (bIncEmpty||et.getDGRowClassHelper()!=null)) {
            dst.set(FIELD_DGROWCLASSHELPER,et.getDGRowClassHelper());
        }
        if(et.isDGSUMMARYHeightDirty() && (bIncEmpty||et.getDGSUMMARYHeight()!=null)) {
            dst.set(FIELD_DGSUMMARYHEIGHT,et.getDGSUMMARYHeight());
        }
        if(et.isDLKHelperDirty() && (bIncEmpty||et.getDLKHelper()!=null)) {
            dst.set(FIELD_DLKHELPER,et.getDLKHelper());
        }
        if(et.isDynamicIntervalDirty() && (bIncEmpty||et.getDynamicInterval()!=null)) {
            dst.set(FIELD_DYNAMICINTERVAL,et.getDynamicInterval());
        }
        if(et.isEnableColPrivDirty() && (bIncEmpty||et.getEnableColPriv()!=null)) {
            dst.set(FIELD_ENABLECOLPRIV,et.getEnableColPriv());
        }
        if(et.isEnableGlobalModelDirty() && (bIncEmpty||et.getEnableGlobalModel()!=null)) {
            dst.set(FIELD_ENABLEGLOBALMODEL,et.getEnableGlobalModel());
        }
        if(et.isExitingModelDirty() && (bIncEmpty||et.getExitingModel()!=null)) {
            dst.set(FIELD_EXITINGMODEL,et.getExitingModel());
        }
        if(et.isExportIncEmptyDirty() && (bIncEmpty||et.getExportIncEmpty()!=null)) {
            dst.set(FIELD_EXPORTINCEMPTY,et.getExportIncEmpty());
        }
        if(et.isExTableNameDirty() && (bIncEmpty||et.getExTableName()!=null)) {
            dst.set(FIELD_EXTABLENAME,et.getExTableName());
        }
        if(et.isGlobalModelObjDirty() && (bIncEmpty||et.getGlobalModelObj()!=null)) {
            dst.set(FIELD_GLOBALMODELOBJ,et.getGlobalModelObj());
        }
        if(et.isIndexModeDirty() && (bIncEmpty||et.getIndexMode()!=null)) {
            dst.set(FIELD_INDEXMODE,et.getIndexMode());
        }
        if(et.isInfoFieldDirty() && (bIncEmpty||et.getInfoField()!=null)) {
            dst.set(FIELD_INFOFIELD,et.getInfoField());
        }
        if(et.isInfoFormatDirty() && (bIncEmpty||et.getInfoFormat()!=null)) {
            dst.set(FIELD_INFOFORMAT,et.getInfoFormat());
        }
        if(et.isInheritModeDirty() && (bIncEmpty||et.getInheritMode()!=null)) {
            dst.set(FIELD_INHERITMODE,et.getInheritMode());
        }
        if(et.isIsDGRowEditDirty() && (bIncEmpty||et.getIsDGRowEdit()!=null)) {
            dst.set(FIELD_ISDGROWEDIT,et.getIsDGRowEdit());
        }
        if(et.isIsEnableAuditDirty() && (bIncEmpty||et.getIsEnableAudit()!=null)) {
            dst.set(FIELD_ISENABLEAUDIT,et.getIsEnableAudit());
        }
        if(et.isIsEnableDPDirty() && (bIncEmpty||et.getIsEnableDP()!=null)) {
            dst.set(FIELD_ISENABLEDP,et.getIsEnableDP());
        }
        if(et.isIsIndexDEDirty() && (bIncEmpty||et.getIsIndexDE()!=null)) {
            dst.set(FIELD_ISINDEXDE,et.getIsIndexDE());
        }
        if(et.isIsLogicValidDirty() && (bIncEmpty||et.getIsLogicValid()!=null)) {
            dst.set(FIELD_ISLOGICVALID,et.getIsLogicValid());
        }
        if(et.isISMULTIPRINTDirty() && (bIncEmpty||et.getISMULTIPRINT()!=null)) {
            dst.set(FIELD_ISMULTIPRINT,et.getISMULTIPRINT());
        }
        if(et.isISSupportFADirty() && (bIncEmpty||et.getISSupportFA()!=null)) {
            dst.set(FIELD_ISSUPPORTFA,et.getISSupportFA());
        }
        if(et.isIsSystemDirty() && (bIncEmpty||et.getIsSystem()!=null)) {
            dst.set(FIELD_ISSYSTEM,et.getIsSystem());
        }
        if(et.isKeyParamsDirty() && (bIncEmpty||et.getKeyParams()!=null)) {
            dst.set(FIELD_KEYPARAMS,et.getKeyParams());
        }
        if(et.isLicenseCodeDirty() && (bIncEmpty||et.getLicenseCode()!=null)) {
            dst.set(FIELD_LICENSECODE,et.getLicenseCode());
        }
        if(et.isLogAuditDetailDirty() && (bIncEmpty||et.getLogAuditDetail()!=null)) {
            dst.set(FIELD_LOGAUDITDETAIL,et.getLogAuditDetail());
        }
        if(et.isMemoDirty() && (bIncEmpty||et.getMemo()!=null)) {
            dst.set(FIELD_MEMO,et.getMemo());
        }
        if(et.isMinorFieldNameDirty() && (bIncEmpty||et.getMinorFieldName()!=null)) {
            dst.set(FIELD_MINORFIELDNAME,et.getMinorFieldName());
        }
        if(et.isMinorFieldValueDirty() && (bIncEmpty||et.getMinorFieldValue()!=null)) {
            dst.set(FIELD_MINORFIELDVALUE,et.getMinorFieldValue());
        }
        if(et.isMinorTableNameDirty() && (bIncEmpty||et.getMinorTableName()!=null)) {
            dst.set(FIELD_MINORTABLENAME,et.getMinorTableName());
        }
        if(et.isMutliMajorDirty() && (bIncEmpty||et.getMutliMajor()!=null)) {
            dst.set(FIELD_MUTLIMAJOR,et.getMutliMajor());
        }
        if(et.isNoDataInfoDirty() && (bIncEmpty||et.getNoDataInfo()!=null)) {
            dst.set(FIELD_NODATAINFO,et.getNoDataInfo());
        }
        if(et.isPrintFuncDirty() && (bIncEmpty||et.getPrintFunc()!=null)) {
            dst.set(FIELD_PRINTFUNC,et.getPrintFunc());
        }
        if(et.isReserverDirty() && (bIncEmpty||et.getReserver()!=null)) {
            dst.set(FIELD_RESERVER,et.getReserver());
        }
        if(et.isReserver2Dirty() && (bIncEmpty||et.getReserver2()!=null)) {
            dst.set(FIELD_RESERVER2,et.getReserver2());
        }
        if(et.isRowAmoutDirty() && (bIncEmpty||et.getRowAmout()!=null)) {
            dst.set(FIELD_ROWAMOUT,et.getRowAmout());
        }
        if(et.isRTInfoDirty() && (bIncEmpty||et.getRTInfo()!=null)) {
            dst.set(FIELD_RTINFO,et.getRTInfo());
        }
        if(et.isSMALLICONDirty() && (bIncEmpty||et.getSMALLICON()!=null)) {
            dst.set(FIELD_SMALLICON,et.getSMALLICON());
        }
        if(et.isStorageTypeDirty() && (bIncEmpty||et.getStorageType()!=null)) {
            dst.set(FIELD_STORAGETYPE,et.getStorageType());
        }
        if(et.isTableNameDirty() && (bIncEmpty||et.getTableName()!=null)) {
            dst.set(FIELD_TABLENAME,et.getTableName());
        }
        if(et.isTableSpaceDirty() && (bIncEmpty||et.getTableSpace()!=null)) {
            dst.set(FIELD_TABLESPACE,et.getTableSpace());
        }
        if(et.isTipsInfoDirty() && (bIncEmpty||et.getTipsInfo()!=null)) {
            dst.set(FIELD_TIPSINFO,et.getTipsInfo());
        }
        if(et.isUpdateDateDirty() && (bIncEmpty||et.getUpdateDate()!=null)) {
            dst.set(FIELD_UPDATEDATE,et.getUpdateDate());
        }
        if(et.isUpdateManDirty() && (bIncEmpty||et.getUpdateMan()!=null)) {
            dst.set(FIELD_UPDATEMAN,et.getUpdateMan());
        }
        if(et.isUserActionDirty() && (bIncEmpty||et.getUserAction()!=null)) {
            dst.set(FIELD_USERACTION,et.getUserAction());
        }
        if(et.isValidFlagDirty() && (bIncEmpty||et.getValidFlag()!=null)) {
            dst.set(FIELD_VALIDFLAG,et.getValidFlag());
        }
        if(et.isVCFlagDirty() && (bIncEmpty||et.getVCFlag()!=null)) {
            dst.set(FIELD_VCFLAG,et.getVCFlag());
        }
        if(et.isVerCheckTimerDirty() && (bIncEmpty||et.getVerCheckTimer()!=null)) {
            dst.set(FIELD_VERCHECKTIMER,et.getVerCheckTimer());
        }
        if(et.isVerFieldDirty() && (bIncEmpty||et.getVerField()!=null)) {
            dst.set(FIELD_VERFIELD,et.getVerField());
        }
        if(et.isVerHelperDirty() && (bIncEmpty||et.getVerHelper()!=null)) {
            dst.set(FIELD_VERHELPER,et.getVerHelper());
        }
        if(et.isVersionCheckDirty() && (bIncEmpty||et.getVersionCheck()!=null)) {
            dst.set(FIELD_VERSIONCHECK,et.getVersionCheck());
        }
        if(et.isViewNameDirty() && (bIncEmpty||et.getViewName()!=null)) {
            dst.set(FIELD_VIEWNAME,et.getViewName());
        }
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#remove(java.lang.String)
     */
    @Override
    public boolean remove(String strParamName) throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().remove(strParamName);
        }
        if(StringHelper.isNullOrEmpty(strParamName))
            throw new Exception("没有指定属性");
        Integer index=fieldIndexMap.get(strParamName.toUpperCase());
        if(index==null)
            return super.remove(strParamName);
        return  DataEntityBase.remove(this, index);
    }

    /**
     * 通过属性标识删除属性值
     * @param entity
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean remove(DataEntityBase et,int index) throws Exception {
        switch(index) {
        case INDEX_ACENABLEDP:
            et.resetACEnableDP();
            return true;
        case INDEX_ACEXTINFO:
            et.resetACExtInfo();
            return true;
        case INDEX_ACINFOFORMAT:
            et.resetACInfoFormat();
            return true;
        case INDEX_ACINFOPARAM:
            et.resetACInfoParam();
            return true;
        case INDEX_ACMAXCNT:
            et.resetACMaxCnt();
            return true;
        case INDEX_ACOBJECT:
            et.resetACObject();
            return true;
        case INDEX_ACQUERYMODELID:
            et.resetACQueryModelId();
            return true;
        case INDEX_ACQUERYMODELNAME:
            et.resetACQueryModelName();
            return true;
        case INDEX_ACSORTDIR:
            et.resetACSortDir();
            return true;
        case INDEX_ACSORTFIELD:
            et.resetACSortField();
            return true;
        case INDEX_BIGICON:
            et.resetBigIcon();
            return true;
        case INDEX_CONFIGHELPER:
            et.resetConfigHelper();
            return true;
        case INDEX_CREATEDATE:
            et.resetCreateDate();
            return true;
        case INDEX_CREATEMAN:
            et.resetCreateMan();
            return true;
        case INDEX_DATAACCOBJECT:
            et.resetDataAccObject();
            return true;
        case INDEX_DATACHGLOGMODE:
            et.resetDataChgLogMode();
            return true;
        case INDEX_DATACTRLINT:
            et.resetDataCtrlInt();
            return true;
        case INDEX_DATACTRLOBJECT:
            et.resetDataCtrlObject();
            return true;
        case INDEX_DATANOTIFYHELPER:
            et.resetDataNotifyHelper();
            return true;
        case INDEX_DBSTORAGE:
            et.resetDBStorage();
            return true;
        case INDEX_DBVERSION:
            et.resetDBVersion();
            return true;
        case INDEX_DEGROUP:
            et.resetDEGroup();
            return true;
        case INDEX_DEHELPER:
            et.resetDEHelper();
            return true;
        case INDEX_DEID:
            et.resetDEId();
            return true;
        case INDEX_DELOGICNAME:
            et.resetDELogicName();
            return true;
        case INDEX_DENAME:
            et.resetDEName();
            return true;
        case INDEX_DEOBJECT:
            et.resetDEObject();
            return true;
        case INDEX_DEORDER:
            et.resetDEOrder();
            return true;
        case INDEX_DEPARAM:
            et.resetDEParam();
            return true;
        case INDEX_DER11DEID:
            et.resetDER11DEId();
            return true;
        case INDEX_DER11DENAME:
            et.resetDER11DEName();
            return true;
        case INDEX_DETYPE:
            et.resetDEType();
            return true;
        case INDEX_DEUSERPARAM:
            et.resetDEUserParam();
            return true;
        case INDEX_DEVERSION:
            et.resetDEVersion();
            return true;
        case INDEX_DGROWCLASSHELPER:
            et.resetDGRowClassHelper();
            return true;
        case INDEX_DGSUMMARYHEIGHT:
            et.resetDGSUMMARYHeight();
            return true;
        case INDEX_DLKHELPER:
            et.resetDLKHelper();
            return true;
        case INDEX_DYNAMICINTERVAL:
            et.resetDynamicInterval();
            return true;
        case INDEX_ENABLECOLPRIV:
            et.resetEnableColPriv();
            return true;
        case INDEX_ENABLEGLOBALMODEL:
            et.resetEnableGlobalModel();
            return true;
        case INDEX_EXITINGMODEL:
            et.resetExitingModel();
            return true;
        case INDEX_EXPORTINCEMPTY:
            et.resetExportIncEmpty();
            return true;
        case INDEX_EXTABLENAME:
            et.resetExTableName();
            return true;
        case INDEX_GLOBALMODELOBJ:
            et.resetGlobalModelObj();
            return true;
        case INDEX_INDEXMODE:
            et.resetIndexMode();
            return true;
        case INDEX_INFOFIELD:
            et.resetInfoField();
            return true;
        case INDEX_INFOFORMAT:
            et.resetInfoFormat();
            return true;
        case INDEX_INHERITMODE:
            et.resetInheritMode();
            return true;
        case INDEX_ISDGROWEDIT:
            et.resetIsDGRowEdit();
            return true;
        case INDEX_ISENABLEAUDIT:
            et.resetIsEnableAudit();
            return true;
        case INDEX_ISENABLEDP:
            et.resetIsEnableDP();
            return true;
        case INDEX_ISINDEXDE:
            et.resetIsIndexDE();
            return true;
        case INDEX_ISLOGICVALID:
            et.resetIsLogicValid();
            return true;
        case INDEX_ISMULTIPRINT:
            et.resetISMULTIPRINT();
            return true;
        case INDEX_ISSUPPORTFA:
            et.resetISSupportFA();
            return true;
        case INDEX_ISSYSTEM:
            et.resetIsSystem();
            return true;
        case INDEX_KEYPARAMS:
            et.resetKeyParams();
            return true;
        case INDEX_LICENSECODE:
            et.resetLicenseCode();
            return true;
        case INDEX_LOGAUDITDETAIL:
            et.resetLogAuditDetail();
            return true;
        case INDEX_MEMO:
            et.resetMemo();
            return true;
        case INDEX_MINORFIELDNAME:
            et.resetMinorFieldName();
            return true;
        case INDEX_MINORFIELDVALUE:
            et.resetMinorFieldValue();
            return true;
        case INDEX_MINORTABLENAME:
            et.resetMinorTableName();
            return true;
        case INDEX_MUTLIMAJOR:
            et.resetMutliMajor();
            return true;
        case INDEX_NODATAINFO:
            et.resetNoDataInfo();
            return true;
        case INDEX_PRINTFUNC:
            et.resetPrintFunc();
            return true;
        case INDEX_RESERVER:
            et.resetReserver();
            return true;
        case INDEX_RESERVER2:
            et.resetReserver2();
            return true;
        case INDEX_ROWAMOUT:
            et.resetRowAmout();
            return true;
        case INDEX_RTINFO:
            et.resetRTInfo();
            return true;
        case INDEX_SMALLICON:
            et.resetSMALLICON();
            return true;
        case INDEX_STORAGETYPE:
            et.resetStorageType();
            return true;
        case INDEX_TABLENAME:
            et.resetTableName();
            return true;
        case INDEX_TABLESPACE:
            et.resetTableSpace();
            return true;
        case INDEX_TIPSINFO:
            et.resetTipsInfo();
            return true;
        case INDEX_UPDATEDATE:
            et.resetUpdateDate();
            return true;
        case INDEX_UPDATEMAN:
            et.resetUpdateMan();
            return true;
        case INDEX_USERACTION:
            et.resetUserAction();
            return true;
        case INDEX_VALIDFLAG:
            et.resetValidFlag();
            return true;
        case INDEX_VCFLAG:
            et.resetVCFlag();
            return true;
        case INDEX_VERCHECKTIMER:
            et.resetVerCheckTimer();
            return true;
        case INDEX_VERFIELD:
            et.resetVerField();
            return true;
        case INDEX_VERHELPER:
            et.resetVerHelper();
            return true;
        case INDEX_VERSIONCHECK:
            et.resetVersionCheck();
            return true;
        case INDEX_VIEWNAME:
            et.resetViewName();
            return true;
        default:
            throw new Exception("不明属性标识");
        }
    }


    private Integer objDER11DELock = new Integer(1);
    private net.ibizsys.psrt.srv.demodel.entity.DataEntity der11de = null;
    /**
    * 获取父数据 实体
     * @throws Exception
    */
    public net.ibizsys.psrt.srv.demodel.entity.DataEntity getDER11DE() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDER11DE();
        }

        if(this.getDER11DEId()==null)
            return null;
        synchronized(this.objDER11DELock) {
            if(this.der11de!=null) {
                if(net.ibizsys.paas.util.DataTypeHelper.compare(25,this.getDER11DEId(),der11de.getDEId())!=0) {
                    this.der11de = null;
                }
            }


            if(this.der11de==null) {
                net.ibizsys.psrt.srv.demodel.entity.DataEntity der11de = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
                der11de.setDEId(this.getDER11DEId());
                net.ibizsys.psrt.srv.demodel.service.DataEntityService service = (net.ibizsys.psrt.srv.demodel.service.DataEntityService)ServiceGlobal.getService(net.ibizsys.psrt.srv.demodel.service.DataEntityService.class,this.getSessionFactory());
                service.autoGet(der11de);
                this.der11de = der11de;
            }
            return this.der11de;
        }
    }

    private Integer objACQueryModelLock = new Integer(1);
    private net.ibizsys.psrt.srv.demodel.entity.QueryModel acquerymodel = null;
    /**
    * 获取父数据 实体查询模型
     * @throws Exception
    */
    public net.ibizsys.psrt.srv.demodel.entity.QueryModel getACQueryModel() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getACQueryModel();
        }

        if(this.getACQueryModelId()==null)
            return null;
        synchronized(this.objACQueryModelLock) {
            if(this.acquerymodel!=null) {
                if(net.ibizsys.paas.util.DataTypeHelper.compare(25,this.getACQueryModelId(),acquerymodel.getQueryModelId())!=0) {
                    this.acquerymodel = null;
                }
            }


            if(this.acquerymodel==null) {
                net.ibizsys.psrt.srv.demodel.entity.QueryModel acquerymodel = new net.ibizsys.psrt.srv.demodel.entity.QueryModel();
                acquerymodel.setQueryModelId(this.getACQueryModelId());
                net.ibizsys.psrt.srv.demodel.service.QueryModelService service = (net.ibizsys.psrt.srv.demodel.service.QueryModelService)ServiceGlobal.getService(net.ibizsys.psrt.srv.demodel.service.QueryModelService.class,this.getSessionFactory());
                service.autoGet(acquerymodel);
                this.acquerymodel = acquerymodel;
            }
            return this.acquerymodel;
        }
    }



    /**
     *  获取代理的数据对象
     */
    private DataEntityBase getProxyEntity() {
        return this.proxyDataEntityBase;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onProxy(net.ibizsys.paas.data.IDataObject)
     */
    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyDataEntityBase = null;
        if(proxyDataObject!=null && proxyDataObject instanceof DataEntityBase) {
            this.proxyDataEntityBase = (DataEntityBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }


    /**
    * 重写获取行为操作辅助对象
    */
    protected net.ibizsys.paas.entity.IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        net.ibizsys.paas.entity.IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if(!bMust || iEntityActionHelper!=null)
            return iEntityActionHelper;
        iEntityActionHelper = net.ibizsys.paas.service.ServiceGlobal.getService("net.ibizsys.psrt.srv.demodel.service.DataEntityService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

}