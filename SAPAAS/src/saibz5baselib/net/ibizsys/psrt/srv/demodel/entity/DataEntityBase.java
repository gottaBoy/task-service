/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.psrt.srv.demodel.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import javax.persistence.Column;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.psrt.srv.demodel.entity.DataEntity;
import net.ibizsys.psrt.srv.demodel.entity.QueryModel;
import net.ibizsys.psrt.srv.demodel.service.DataEntityService;
import net.ibizsys.psrt.srv.demodel.service.QueryModelService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class DataEntityBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(DataEntityBase.class);
    public static final String FIELD_ACENABLEDP = "ACENABLEDP";
    public static final String FIELD_ACEXTINFO = "ACEXTINFO";
    public static final String FIELD_ACINFOFORMAT = "ACINFOFORMAT";
    public static final String FIELD_ACINFOPARAM = "ACINFOPARAM";
    public static final String FIELD_ACMAXCNT = "ACMAXCNT";
    public static final String FIELD_ACOBJECT = "ACOBJECT";
    public static final String FIELD_ACQUERYMODELID = "ACQUERYMODELID";
    public static final String FIELD_ACQUERYMODELNAME = "ACQUERYMODELNAME";
    public static final String FIELD_ACSORTDIR = "ACSORTDIR";
    public static final String FIELD_ACSORTFIELD = "ACSORTFIELD";
    public static final String FIELD_BIGICON = "BIGICON";
    public static final String FIELD_CONFIGHELPER = "CONFIGHELPER";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DATAACCOBJECT = "DATAACCOBJECT";
    public static final String FIELD_DATACHGLOGMODE = "DATACHGLOGMODE";
    public static final String FIELD_DATACTRLINT = "DATACTRLINT";
    public static final String FIELD_DATACTRLOBJECT = "DATACTRLOBJECT";
    public static final String FIELD_DATANOTIFYHELPER = "DATANOTIFYHELPER";
    public static final String FIELD_DBSTORAGE = "DBSTORAGE";
    public static final String FIELD_DBVERSION = "DBVERSION";
    public static final String FIELD_DEGROUP = "DEGROUP";
    public static final String FIELD_DEHELPER = "DEHELPER";
    public static final String FIELD_DEID = "DEID";
    public static final String FIELD_DELOGICNAME = "DELOGICNAME";
    public static final String FIELD_DENAME = "DENAME";
    public static final String FIELD_DEOBJECT = "DEOBJECT";
    public static final String FIELD_DEORDER = "DEORDER";
    public static final String FIELD_DEPARAM = "DEPARAM";
    public static final String FIELD_DER11DEID = "DER11DEID";
    public static final String FIELD_DER11DENAME = "DER11DENAME";
    public static final String FIELD_DETYPE = "DETYPE";
    public static final String FIELD_DEUSERPARAM = "DEUSERPARAM";
    public static final String FIELD_DEVERSION = "DEVERSION";
    public static final String FIELD_DGROWCLASSHELPER = "DGROWCLASSHELPER";
    public static final String FIELD_DGSUMMARYHEIGHT = "DGSUMMARYHEIGHT";
    public static final String FIELD_DLKHELPER = "DLKHELPER";
    public static final String FIELD_DYNAMICINTERVAL = "DYNAMICINTERVAL";
    public static final String FIELD_ENABLECOLPRIV = "ENABLECOLPRIV";
    public static final String FIELD_ENABLEGLOBALMODEL = "ENABLEGLOBALMODEL";
    public static final String FIELD_EXITINGMODEL = "EXITINGMODEL";
    public static final String FIELD_EXPORTINCEMPTY = "EXPORTINCEMPTY";
    public static final String FIELD_EXTABLENAME = "EXTABLENAME";
    public static final String FIELD_GLOBALMODELOBJ = "GLOBALMODELOBJ";
    public static final String FIELD_INDEXMODE = "INDEXMODE";
    public static final String FIELD_INFOFIELD = "INFOFIELD";
    public static final String FIELD_INFOFORMAT = "INFOFORMAT";
    public static final String FIELD_INHERITMODE = "INHERITMODE";
    public static final String FIELD_ISDGROWEDIT = "ISDGROWEDIT";
    public static final String FIELD_ISENABLEAUDIT = "ISENABLEAUDIT";
    public static final String FIELD_ISENABLEDP = "ISENABLEDP";
    public static final String FIELD_ISINDEXDE = "ISINDEXDE";
    public static final String FIELD_ISLOGICVALID = "ISLOGICVALID";
    public static final String FIELD_ISMULTIPRINT = "ISMULTIPRINT";
    public static final String FIELD_ISSUPPORTFA = "ISSUPPORTFA";
    public static final String FIELD_ISSYSTEM = "ISSYSTEM";
    public static final String FIELD_KEYPARAMS = "KEYPARAMS";
    public static final String FIELD_LICENSECODE = "LICENSECODE";
    public static final String FIELD_LOGAUDITDETAIL = "LOGAUDITDETAIL";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MINORFIELDNAME = "MINORFIELDNAME";
    public static final String FIELD_MINORFIELDVALUE = "MINORFIELDVALUE";
    public static final String FIELD_MINORTABLENAME = "MINORTABLENAME";
    public static final String FIELD_MUTLIMAJOR = "MULTIMAJOR";
    public static final String FIELD_NODATAINFO = "NODATAINFO";
    public static final String FIELD_PRINTFUNC = "PRINTFUNC";
    public static final String FIELD_RESERVER = "RESERVER";
    public static final String FIELD_RESERVER2 = "RESERVER2";
    public static final String FIELD_ROWAMOUT = "ROWAMOUNT";
    public static final String FIELD_RTINFO = "RTINFO";
    public static final String FIELD_SMALLICON = "SMALLICON";
    public static final String FIELD_STORAGETYPE = "STORAGETYPE";
    public static final String FIELD_TABLENAME = "TABLENAME";
    public static final String FIELD_TABLESPACE = "TABLESPACE";
    public static final String FIELD_TIPSINFO = "TIPSINFO";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERACTION = "USERACTION";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    public static final String FIELD_VCFLAG = "VCFLAG";
    public static final String FIELD_VERCHECKTIMER = "VERCHECKTIMER";
    public static final String FIELD_VERFIELD = "VERFIELD";
    public static final String FIELD_VERHELPER = "VERHELPER";
    public static final String FIELD_VERSIONCHECK = "VERSIONCHECK";
    public static final String FIELD_VIEWNAME = "VIEWNAME";
    private static final int INDEX_ACENABLEDP = 0;
    private static final int INDEX_ACEXTINFO = 1;
    private static final int INDEX_ACINFOFORMAT = 2;
    private static final int INDEX_ACINFOPARAM = 3;
    private static final int INDEX_ACMAXCNT = 4;
    private static final int INDEX_ACOBJECT = 5;
    private static final int INDEX_ACQUERYMODELID = 6;
    private static final int INDEX_ACQUERYMODELNAME = 7;
    private static final int INDEX_ACSORTDIR = 8;
    private static final int INDEX_ACSORTFIELD = 9;
    private static final int INDEX_BIGICON = 10;
    private static final int INDEX_CONFIGHELPER = 11;
    private static final int INDEX_CREATEDATE = 12;
    private static final int INDEX_CREATEMAN = 13;
    private static final int INDEX_DATAACCOBJECT = 14;
    private static final int INDEX_DATACHGLOGMODE = 15;
    private static final int INDEX_DATACTRLINT = 16;
    private static final int INDEX_DATACTRLOBJECT = 17;
    private static final int INDEX_DATANOTIFYHELPER = 18;
    private static final int INDEX_DBSTORAGE = 19;
    private static final int INDEX_DBVERSION = 20;
    private static final int INDEX_DEGROUP = 21;
    private static final int INDEX_DEHELPER = 22;
    private static final int INDEX_DEID = 23;
    private static final int INDEX_DELOGICNAME = 24;
    private static final int INDEX_DENAME = 25;
    private static final int INDEX_DEOBJECT = 26;
    private static final int INDEX_DEORDER = 27;
    private static final int INDEX_DEPARAM = 28;
    private static final int INDEX_DER11DEID = 29;
    private static final int INDEX_DER11DENAME = 30;
    private static final int INDEX_DETYPE = 31;
    private static final int INDEX_DEUSERPARAM = 32;
    private static final int INDEX_DEVERSION = 33;
    private static final int INDEX_DGROWCLASSHELPER = 34;
    private static final int INDEX_DGSUMMARYHEIGHT = 35;
    private static final int INDEX_DLKHELPER = 36;
    private static final int INDEX_DYNAMICINTERVAL = 37;
    private static final int INDEX_ENABLECOLPRIV = 38;
    private static final int INDEX_ENABLEGLOBALMODEL = 39;
    private static final int INDEX_EXITINGMODEL = 40;
    private static final int INDEX_EXPORTINCEMPTY = 41;
    private static final int INDEX_EXTABLENAME = 42;
    private static final int INDEX_GLOBALMODELOBJ = 43;
    private static final int INDEX_INDEXMODE = 44;
    private static final int INDEX_INFOFIELD = 45;
    private static final int INDEX_INFOFORMAT = 46;
    private static final int INDEX_INHERITMODE = 47;
    private static final int INDEX_ISDGROWEDIT = 48;
    private static final int INDEX_ISENABLEAUDIT = 49;
    private static final int INDEX_ISENABLEDP = 50;
    private static final int INDEX_ISINDEXDE = 51;
    private static final int INDEX_ISLOGICVALID = 52;
    private static final int INDEX_ISMULTIPRINT = 53;
    private static final int INDEX_ISSUPPORTFA = 54;
    private static final int INDEX_ISSYSTEM = 55;
    private static final int INDEX_KEYPARAMS = 56;
    private static final int INDEX_LICENSECODE = 57;
    private static final int INDEX_LOGAUDITDETAIL = 58;
    private static final int INDEX_MEMO = 59;
    private static final int INDEX_MINORFIELDNAME = 60;
    private static final int INDEX_MINORFIELDVALUE = 61;
    private static final int INDEX_MINORTABLENAME = 62;
    private static final int INDEX_MUTLIMAJOR = 63;
    private static final int INDEX_NODATAINFO = 64;
    private static final int INDEX_PRINTFUNC = 65;
    private static final int INDEX_RESERVER = 66;
    private static final int INDEX_RESERVER2 = 67;
    private static final int INDEX_ROWAMOUT = 68;
    private static final int INDEX_RTINFO = 69;
    private static final int INDEX_SMALLICON = 70;
    private static final int INDEX_STORAGETYPE = 71;
    private static final int INDEX_TABLENAME = 72;
    private static final int INDEX_TABLESPACE = 73;
    private static final int INDEX_TIPSINFO = 74;
    private static final int INDEX_UPDATEDATE = 75;
    private static final int INDEX_UPDATEMAN = 76;
    private static final int INDEX_USERACTION = 77;
    private static final int INDEX_VALIDFLAG = 78;
    private static final int INDEX_VCFLAG = 79;
    private static final int INDEX_VERCHECKTIMER = 80;
    private static final int INDEX_VERFIELD = 81;
    private static final int INDEX_VERHELPER = 82;
    private static final int INDEX_VERSIONCHECK = 83;
    private static final int INDEX_VIEWNAME = 84;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private DataEntityBase proxyDataEntityBase = null;
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
    private Integer objDER11DELock = new Integer(1);
    private DataEntity der11de = null;
    private Integer objACQueryModelLock = new Integer(1);
    private QueryModel acquerymodel = null;

    static {
        fieldIndexMap.put(FIELD_ACENABLEDP, 0);
        fieldIndexMap.put(FIELD_ACEXTINFO, 1);
        fieldIndexMap.put(FIELD_ACINFOFORMAT, 2);
        fieldIndexMap.put(FIELD_ACINFOPARAM, 3);
        fieldIndexMap.put(FIELD_ACMAXCNT, 4);
        fieldIndexMap.put(FIELD_ACOBJECT, 5);
        fieldIndexMap.put(FIELD_ACQUERYMODELID, 6);
        fieldIndexMap.put(FIELD_ACQUERYMODELNAME, 7);
        fieldIndexMap.put(FIELD_ACSORTDIR, 8);
        fieldIndexMap.put(FIELD_ACSORTFIELD, 9);
        fieldIndexMap.put(FIELD_BIGICON, 10);
        fieldIndexMap.put(FIELD_CONFIGHELPER, 11);
        fieldIndexMap.put(FIELD_CREATEDATE, 12);
        fieldIndexMap.put(FIELD_CREATEMAN, 13);
        fieldIndexMap.put(FIELD_DATAACCOBJECT, 14);
        fieldIndexMap.put(FIELD_DATACHGLOGMODE, 15);
        fieldIndexMap.put(FIELD_DATACTRLINT, 16);
        fieldIndexMap.put(FIELD_DATACTRLOBJECT, 17);
        fieldIndexMap.put(FIELD_DATANOTIFYHELPER, 18);
        fieldIndexMap.put(FIELD_DBSTORAGE, 19);
        fieldIndexMap.put(FIELD_DBVERSION, 20);
        fieldIndexMap.put(FIELD_DEGROUP, 21);
        fieldIndexMap.put(FIELD_DEHELPER, 22);
        fieldIndexMap.put(FIELD_DEID, 23);
        fieldIndexMap.put(FIELD_DELOGICNAME, 24);
        fieldIndexMap.put(FIELD_DENAME, 25);
        fieldIndexMap.put(FIELD_DEOBJECT, 26);
        fieldIndexMap.put(FIELD_DEORDER, 27);
        fieldIndexMap.put(FIELD_DEPARAM, 28);
        fieldIndexMap.put(FIELD_DER11DEID, 29);
        fieldIndexMap.put(FIELD_DER11DENAME, 30);
        fieldIndexMap.put(FIELD_DETYPE, 31);
        fieldIndexMap.put(FIELD_DEUSERPARAM, 32);
        fieldIndexMap.put(FIELD_DEVERSION, 33);
        fieldIndexMap.put(FIELD_DGROWCLASSHELPER, 34);
        fieldIndexMap.put(FIELD_DGSUMMARYHEIGHT, 35);
        fieldIndexMap.put(FIELD_DLKHELPER, 36);
        fieldIndexMap.put(FIELD_DYNAMICINTERVAL, 37);
        fieldIndexMap.put(FIELD_ENABLECOLPRIV, 38);
        fieldIndexMap.put(FIELD_ENABLEGLOBALMODEL, 39);
        fieldIndexMap.put(FIELD_EXITINGMODEL, 40);
        fieldIndexMap.put(FIELD_EXPORTINCEMPTY, 41);
        fieldIndexMap.put(FIELD_EXTABLENAME, 42);
        fieldIndexMap.put(FIELD_GLOBALMODELOBJ, 43);
        fieldIndexMap.put(FIELD_INDEXMODE, 44);
        fieldIndexMap.put(FIELD_INFOFIELD, 45);
        fieldIndexMap.put(FIELD_INFOFORMAT, 46);
        fieldIndexMap.put(FIELD_INHERITMODE, 47);
        fieldIndexMap.put(FIELD_ISDGROWEDIT, 48);
        fieldIndexMap.put(FIELD_ISENABLEAUDIT, 49);
        fieldIndexMap.put(FIELD_ISENABLEDP, 50);
        fieldIndexMap.put(FIELD_ISINDEXDE, 51);
        fieldIndexMap.put(FIELD_ISLOGICVALID, 52);
        fieldIndexMap.put(FIELD_ISMULTIPRINT, 53);
        fieldIndexMap.put(FIELD_ISSUPPORTFA, 54);
        fieldIndexMap.put(FIELD_ISSYSTEM, 55);
        fieldIndexMap.put(FIELD_KEYPARAMS, 56);
        fieldIndexMap.put(FIELD_LICENSECODE, 57);
        fieldIndexMap.put(FIELD_LOGAUDITDETAIL, 58);
        fieldIndexMap.put(FIELD_MEMO, 59);
        fieldIndexMap.put(FIELD_MINORFIELDNAME, 60);
        fieldIndexMap.put(FIELD_MINORFIELDVALUE, 61);
        fieldIndexMap.put(FIELD_MINORTABLENAME, 62);
        fieldIndexMap.put(FIELD_MUTLIMAJOR, 63);
        fieldIndexMap.put(FIELD_NODATAINFO, 64);
        fieldIndexMap.put(FIELD_PRINTFUNC, 65);
        fieldIndexMap.put(FIELD_RESERVER, 66);
        fieldIndexMap.put(FIELD_RESERVER2, 67);
        fieldIndexMap.put(FIELD_ROWAMOUT, 68);
        fieldIndexMap.put(FIELD_RTINFO, 69);
        fieldIndexMap.put(FIELD_SMALLICON, 70);
        fieldIndexMap.put(FIELD_STORAGETYPE, 71);
        fieldIndexMap.put(FIELD_TABLENAME, 72);
        fieldIndexMap.put(FIELD_TABLESPACE, 73);
        fieldIndexMap.put(FIELD_TIPSINFO, 74);
        fieldIndexMap.put(FIELD_UPDATEDATE, 75);
        fieldIndexMap.put(FIELD_UPDATEMAN, 76);
        fieldIndexMap.put(FIELD_USERACTION, 77);
        fieldIndexMap.put(FIELD_VALIDFLAG, 78);
        fieldIndexMap.put(FIELD_VCFLAG, 79);
        fieldIndexMap.put(FIELD_VERCHECKTIMER, 80);
        fieldIndexMap.put(FIELD_VERFIELD, 81);
        fieldIndexMap.put(FIELD_VERHELPER, 82);
        fieldIndexMap.put(FIELD_VERSIONCHECK, 83);
        fieldIndexMap.put(FIELD_VIEWNAME, 84);
    }

    public void setACEnableDP(Integer acenabledp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setACEnableDP(acenabledp);
            return;
        }
        this.acenabledp = acenabledp;
        this.acenabledpDirtyFlag = true;
    }

    public Integer getACEnableDP() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getACEnableDP();
        }
        return this.acenabledp;
    }

    public boolean isACEnableDPDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isACEnableDPDirty();
        }
        return this.acenabledpDirtyFlag;
    }

    public void resetACEnableDP() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetACEnableDP();
            return;
        }
        this.acenabledpDirtyFlag = false;
        this.acenabledp = null;
    }

    public void setACExtInfo(String acextinfo) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setACExtInfo(acextinfo);
            return;
        }
        if (acextinfo != null && (acextinfo = StringHelper.trimRight(acextinfo)).length() == 0) {
            acextinfo = null;
        }
        this.acextinfo = acextinfo;
        this.acextinfoDirtyFlag = true;
    }

    public String getACExtInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getACExtInfo();
        }
        return this.acextinfo;
    }

    public boolean isACExtInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isACExtInfoDirty();
        }
        return this.acextinfoDirtyFlag;
    }

    public void resetACExtInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetACExtInfo();
            return;
        }
        this.acextinfoDirtyFlag = false;
        this.acextinfo = null;
    }

    public void setACInfoFormat(String acinfoformat) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setACInfoFormat(acinfoformat);
            return;
        }
        if (acinfoformat != null && (acinfoformat = StringHelper.trimRight(acinfoformat)).length() == 0) {
            acinfoformat = null;
        }
        this.acinfoformat = acinfoformat;
        this.acinfoformatDirtyFlag = true;
    }

    public String getACInfoFormat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getACInfoFormat();
        }
        return this.acinfoformat;
    }

    public boolean isACInfoFormatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isACInfoFormatDirty();
        }
        return this.acinfoformatDirtyFlag;
    }

    public void resetACInfoFormat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetACInfoFormat();
            return;
        }
        this.acinfoformatDirtyFlag = false;
        this.acinfoformat = null;
    }

    public void setACInfoParam(String acinfoparam) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setACInfoParam(acinfoparam);
            return;
        }
        if (acinfoparam != null && (acinfoparam = StringHelper.trimRight(acinfoparam)).length() == 0) {
            acinfoparam = null;
        }
        this.acinfoparam = acinfoparam;
        this.acinfoparamDirtyFlag = true;
    }

    public String getACInfoParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getACInfoParam();
        }
        return this.acinfoparam;
    }

    public boolean isACInfoParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isACInfoParamDirty();
        }
        return this.acinfoparamDirtyFlag;
    }

    public void resetACInfoParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetACInfoParam();
            return;
        }
        this.acinfoparamDirtyFlag = false;
        this.acinfoparam = null;
    }

    public void setACMaxCnt(Integer acmaxcnt) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setACMaxCnt(acmaxcnt);
            return;
        }
        this.acmaxcnt = acmaxcnt;
        this.acmaxcntDirtyFlag = true;
    }

    public Integer getACMaxCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getACMaxCnt();
        }
        return this.acmaxcnt;
    }

    public boolean isACMaxCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isACMaxCntDirty();
        }
        return this.acmaxcntDirtyFlag;
    }

    public void resetACMaxCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetACMaxCnt();
            return;
        }
        this.acmaxcntDirtyFlag = false;
        this.acmaxcnt = null;
    }

    public void setACObject(String acobject) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setACObject(acobject);
            return;
        }
        if (acobject != null && (acobject = StringHelper.trimRight(acobject)).length() == 0) {
            acobject = null;
        }
        this.acobject = acobject;
        this.acobjectDirtyFlag = true;
    }

    public String getACObject() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getACObject();
        }
        return this.acobject;
    }

    public boolean isACObjectDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isACObjectDirty();
        }
        return this.acobjectDirtyFlag;
    }

    public void resetACObject() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetACObject();
            return;
        }
        this.acobjectDirtyFlag = false;
        this.acobject = null;
    }

    public void setACQueryModelId(String acquerymodelid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setACQueryModelId(acquerymodelid);
            return;
        }
        if (acquerymodelid != null && (acquerymodelid = StringHelper.trimRight(acquerymodelid)).length() == 0) {
            acquerymodelid = null;
        }
        this.acquerymodelid = acquerymodelid;
        this.acquerymodelidDirtyFlag = true;
    }

    public String getACQueryModelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getACQueryModelId();
        }
        return this.acquerymodelid;
    }

    public boolean isACQueryModelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isACQueryModelIdDirty();
        }
        return this.acquerymodelidDirtyFlag;
    }

    public void resetACQueryModelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetACQueryModelId();
            return;
        }
        this.acquerymodelidDirtyFlag = false;
        this.acquerymodelid = null;
    }

    public void setACQueryModelName(String acquerymodelname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setACQueryModelName(acquerymodelname);
            return;
        }
        if (acquerymodelname != null && (acquerymodelname = StringHelper.trimRight(acquerymodelname)).length() == 0) {
            acquerymodelname = null;
        }
        this.acquerymodelname = acquerymodelname;
        this.acquerymodelnameDirtyFlag = true;
    }

    public String getACQueryModelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getACQueryModelName();
        }
        return this.acquerymodelname;
    }

    public boolean isACQueryModelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isACQueryModelNameDirty();
        }
        return this.acquerymodelnameDirtyFlag;
    }

    public void resetACQueryModelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetACQueryModelName();
            return;
        }
        this.acquerymodelnameDirtyFlag = false;
        this.acquerymodelname = null;
    }

    public void setACSortDir(String acsortdir) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setACSortDir(acsortdir);
            return;
        }
        if (acsortdir != null && (acsortdir = StringHelper.trimRight(acsortdir)).length() == 0) {
            acsortdir = null;
        }
        this.acsortdir = acsortdir;
        this.acsortdirDirtyFlag = true;
    }

    public String getACSortDir() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getACSortDir();
        }
        return this.acsortdir;
    }

    public boolean isACSortDirDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isACSortDirDirty();
        }
        return this.acsortdirDirtyFlag;
    }

    public void resetACSortDir() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetACSortDir();
            return;
        }
        this.acsortdirDirtyFlag = false;
        this.acsortdir = null;
    }

    public void setACSortField(String acsortfield) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setACSortField(acsortfield);
            return;
        }
        if (acsortfield != null && (acsortfield = StringHelper.trimRight(acsortfield)).length() == 0) {
            acsortfield = null;
        }
        this.acsortfield = acsortfield;
        this.acsortfieldDirtyFlag = true;
    }

    public String getACSortField() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getACSortField();
        }
        return this.acsortfield;
    }

    public boolean isACSortFieldDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isACSortFieldDirty();
        }
        return this.acsortfieldDirtyFlag;
    }

    public void resetACSortField() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetACSortField();
            return;
        }
        this.acsortfieldDirtyFlag = false;
        this.acsortfield = null;
    }

    public void setBigIcon(String bigicon) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBigIcon(bigicon);
            return;
        }
        if (bigicon != null && (bigicon = StringHelper.trimRight(bigicon)).length() == 0) {
            bigicon = null;
        }
        this.bigicon = bigicon;
        this.bigiconDirtyFlag = true;
    }

    public String getBigIcon() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBigIcon();
        }
        return this.bigicon;
    }

    public boolean isBigIconDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBigIconDirty();
        }
        return this.bigiconDirtyFlag;
    }

    public void resetBigIcon() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBigIcon();
            return;
        }
        this.bigiconDirtyFlag = false;
        this.bigicon = null;
    }

    public void setConfigHelper(String confighelper) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setConfigHelper(confighelper);
            return;
        }
        if (confighelper != null && (confighelper = StringHelper.trimRight(confighelper)).length() == 0) {
            confighelper = null;
        }
        this.confighelper = confighelper;
        this.confighelperDirtyFlag = true;
    }

    public String getConfigHelper() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getConfigHelper();
        }
        return this.confighelper;
    }

    public boolean isConfigHelperDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isConfigHelperDirty();
        }
        return this.confighelperDirtyFlag;
    }

    public void resetConfigHelper() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetConfigHelper();
            return;
        }
        this.confighelperDirtyFlag = false;
        this.confighelper = null;
    }

    public void setCreateDate(Timestamp createdate) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateDate(createdate);
            return;
        }
        this.createdate = createdate;
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

    public void setCreateMan(String createman) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateMan(createman);
            return;
        }
        if (createman != null && (createman = StringHelper.trimRight(createman)).length() == 0) {
            createman = null;
        }
        this.createman = createman;
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

    public void setDataAccObject(String dataaccobject) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDataAccObject(dataaccobject);
            return;
        }
        if (dataaccobject != null && (dataaccobject = StringHelper.trimRight(dataaccobject)).length() == 0) {
            dataaccobject = null;
        }
        this.dataaccobject = dataaccobject;
        this.dataaccobjectDirtyFlag = true;
    }

    public String getDataAccObject() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDataAccObject();
        }
        return this.dataaccobject;
    }

    public boolean isDataAccObjectDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataAccObjectDirty();
        }
        return this.dataaccobjectDirtyFlag;
    }

    public void resetDataAccObject() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDataAccObject();
            return;
        }
        this.dataaccobjectDirtyFlag = false;
        this.dataaccobject = null;
    }

    public void setDataChgLogMode(Integer datachglogmode) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDataChgLogMode(datachglogmode);
            return;
        }
        this.datachglogmode = datachglogmode;
        this.datachglogmodeDirtyFlag = true;
    }

    public Integer getDataChgLogMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDataChgLogMode();
        }
        return this.datachglogmode;
    }

    public boolean isDataChgLogModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataChgLogModeDirty();
        }
        return this.datachglogmodeDirtyFlag;
    }

    public void resetDataChgLogMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDataChgLogMode();
            return;
        }
        this.datachglogmodeDirtyFlag = false;
        this.datachglogmode = null;
    }

    public void setDataCtrlInt(String datactrlint) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDataCtrlInt(datactrlint);
            return;
        }
        if (datactrlint != null && (datactrlint = StringHelper.trimRight(datactrlint)).length() == 0) {
            datactrlint = null;
        }
        this.datactrlint = datactrlint;
        this.datactrlintDirtyFlag = true;
    }

    public String getDataCtrlInt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDataCtrlInt();
        }
        return this.datactrlint;
    }

    public boolean isDataCtrlIntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataCtrlIntDirty();
        }
        return this.datactrlintDirtyFlag;
    }

    public void resetDataCtrlInt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDataCtrlInt();
            return;
        }
        this.datactrlintDirtyFlag = false;
        this.datactrlint = null;
    }

    public void setDataCtrlObject(String datactrlobject) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDataCtrlObject(datactrlobject);
            return;
        }
        if (datactrlobject != null && (datactrlobject = StringHelper.trimRight(datactrlobject)).length() == 0) {
            datactrlobject = null;
        }
        this.datactrlobject = datactrlobject;
        this.datactrlobjectDirtyFlag = true;
    }

    public String getDataCtrlObject() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDataCtrlObject();
        }
        return this.datactrlobject;
    }

    public boolean isDataCtrlObjectDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataCtrlObjectDirty();
        }
        return this.datactrlobjectDirtyFlag;
    }

    public void resetDataCtrlObject() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDataCtrlObject();
            return;
        }
        this.datactrlobjectDirtyFlag = false;
        this.datactrlobject = null;
    }

    public void setDataNotifyHelper(String datanotifyhelper) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDataNotifyHelper(datanotifyhelper);
            return;
        }
        if (datanotifyhelper != null && (datanotifyhelper = StringHelper.trimRight(datanotifyhelper)).length() == 0) {
            datanotifyhelper = null;
        }
        this.datanotifyhelper = datanotifyhelper;
        this.datanotifyhelperDirtyFlag = true;
    }

    public String getDataNotifyHelper() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDataNotifyHelper();
        }
        return this.datanotifyhelper;
    }

    public boolean isDataNotifyHelperDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataNotifyHelperDirty();
        }
        return this.datanotifyhelperDirtyFlag;
    }

    public void resetDataNotifyHelper() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDataNotifyHelper();
            return;
        }
        this.datanotifyhelperDirtyFlag = false;
        this.datanotifyhelper = null;
    }

    public void setDBStorage(String dbstorage) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDBStorage(dbstorage);
            return;
        }
        if (dbstorage != null && (dbstorage = StringHelper.trimRight(dbstorage)).length() == 0) {
            dbstorage = null;
        }
        this.dbstorage = dbstorage;
        this.dbstorageDirtyFlag = true;
    }

    public String getDBStorage() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDBStorage();
        }
        return this.dbstorage;
    }

    public boolean isDBStorageDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDBStorageDirty();
        }
        return this.dbstorageDirtyFlag;
    }

    public void resetDBStorage() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDBStorage();
            return;
        }
        this.dbstorageDirtyFlag = false;
        this.dbstorage = null;
    }

    public void setDBVersion(Integer dbversion) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDBVersion(dbversion);
            return;
        }
        this.dbversion = dbversion;
        this.dbversionDirtyFlag = true;
    }

    public Integer getDBVersion() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDBVersion();
        }
        return this.dbversion;
    }

    public boolean isDBVersionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDBVersionDirty();
        }
        return this.dbversionDirtyFlag;
    }

    public void resetDBVersion() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDBVersion();
            return;
        }
        this.dbversionDirtyFlag = false;
        this.dbversion = null;
    }

    public void setDEGroup(String degroup) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEGroup(degroup);
            return;
        }
        if (degroup != null && (degroup = StringHelper.trimRight(degroup)).length() == 0) {
            degroup = null;
        }
        this.degroup = degroup;
        this.degroupDirtyFlag = true;
    }

    public String getDEGroup() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEGroup();
        }
        return this.degroup;
    }

    public boolean isDEGroupDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEGroupDirty();
        }
        return this.degroupDirtyFlag;
    }

    public void resetDEGroup() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEGroup();
            return;
        }
        this.degroupDirtyFlag = false;
        this.degroup = null;
    }

    public void setDEHelper(String dehelper) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEHelper(dehelper);
            return;
        }
        if (dehelper != null && (dehelper = StringHelper.trimRight(dehelper)).length() == 0) {
            dehelper = null;
        }
        this.dehelper = dehelper;
        this.dehelperDirtyFlag = true;
    }

    public String getDEHelper() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEHelper();
        }
        return this.dehelper;
    }

    public boolean isDEHelperDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEHelperDirty();
        }
        return this.dehelperDirtyFlag;
    }

    public void resetDEHelper() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEHelper();
            return;
        }
        this.dehelperDirtyFlag = false;
        this.dehelper = null;
    }

    public void setDEId(String deid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEId(deid);
            return;
        }
        if (deid != null && (deid = StringHelper.trimRight(deid)).length() == 0) {
            deid = null;
        }
        this.deid = deid;
        this.deidDirtyFlag = true;
    }

    public String getDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEId();
        }
        return this.deid;
    }

    public boolean isDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEIdDirty();
        }
        return this.deidDirtyFlag;
    }

    public void resetDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEId();
            return;
        }
        this.deidDirtyFlag = false;
        this.deid = null;
    }

    public void setDELogicName(String delogicname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDELogicName(delogicname);
            return;
        }
        if (delogicname != null && (delogicname = StringHelper.trimRight(delogicname)).length() == 0) {
            delogicname = null;
        }
        this.delogicname = delogicname;
        this.delogicnameDirtyFlag = true;
    }

    public String getDELogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDELogicName();
        }
        return this.delogicname;
    }

    public boolean isDELogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDELogicNameDirty();
        }
        return this.delogicnameDirtyFlag;
    }

    public void resetDELogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDELogicName();
            return;
        }
        this.delogicnameDirtyFlag = false;
        this.delogicname = null;
    }

    public void setDEName(String dename) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEName(dename);
            return;
        }
        if (dename != null && (dename = StringHelper.trimRight(dename)).length() == 0) {
            dename = null;
        }
        this.dename = dename;
        this.denameDirtyFlag = true;
    }

    public String getDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEName();
        }
        return this.dename;
    }

    public boolean isDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDENameDirty();
        }
        return this.denameDirtyFlag;
    }

    public void resetDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEName();
            return;
        }
        this.denameDirtyFlag = false;
        this.dename = null;
    }

    public void setDEObject(String deobject) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEObject(deobject);
            return;
        }
        if (deobject != null && (deobject = StringHelper.trimRight(deobject)).length() == 0) {
            deobject = null;
        }
        this.deobject = deobject;
        this.deobjectDirtyFlag = true;
    }

    public String getDEObject() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEObject();
        }
        return this.deobject;
    }

    public boolean isDEObjectDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEObjectDirty();
        }
        return this.deobjectDirtyFlag;
    }

    public void resetDEObject() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEObject();
            return;
        }
        this.deobjectDirtyFlag = false;
        this.deobject = null;
    }

    public void setDEOrder(Integer deorder) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEOrder(deorder);
            return;
        }
        this.deorder = deorder;
        this.deorderDirtyFlag = true;
    }

    public Integer getDEOrder() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEOrder();
        }
        return this.deorder;
    }

    public boolean isDEOrderDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEOrderDirty();
        }
        return this.deorderDirtyFlag;
    }

    public void resetDEOrder() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEOrder();
            return;
        }
        this.deorderDirtyFlag = false;
        this.deorder = null;
    }

    public void setDEParam(String deparam) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEParam(deparam);
            return;
        }
        if (deparam != null && (deparam = StringHelper.trimRight(deparam)).length() == 0) {
            deparam = null;
        }
        this.deparam = deparam;
        this.deparamDirtyFlag = true;
    }

    public String getDEParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEParam();
        }
        return this.deparam;
    }

    public boolean isDEParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEParamDirty();
        }
        return this.deparamDirtyFlag;
    }

    public void resetDEParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEParam();
            return;
        }
        this.deparamDirtyFlag = false;
        this.deparam = null;
    }

    public void setDER11DEId(String der11deid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDER11DEId(der11deid);
            return;
        }
        if (der11deid != null && (der11deid = StringHelper.trimRight(der11deid)).length() == 0) {
            der11deid = null;
        }
        this.der11deid = der11deid;
        this.der11deidDirtyFlag = true;
    }

    public String getDER11DEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDER11DEId();
        }
        return this.der11deid;
    }

    public boolean isDER11DEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDER11DEIdDirty();
        }
        return this.der11deidDirtyFlag;
    }

    public void resetDER11DEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDER11DEId();
            return;
        }
        this.der11deidDirtyFlag = false;
        this.der11deid = null;
    }

    public void setDER11DEName(String der11dename) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDER11DEName(der11dename);
            return;
        }
        if (der11dename != null && (der11dename = StringHelper.trimRight(der11dename)).length() == 0) {
            der11dename = null;
        }
        this.der11dename = der11dename;
        this.der11denameDirtyFlag = true;
    }

    public String getDER11DEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDER11DEName();
        }
        return this.der11dename;
    }

    public boolean isDER11DENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDER11DENameDirty();
        }
        return this.der11denameDirtyFlag;
    }

    public void resetDER11DEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDER11DEName();
            return;
        }
        this.der11denameDirtyFlag = false;
        this.der11dename = null;
    }

    public void setDEType(Integer detype) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEType(detype);
            return;
        }
        this.detype = detype;
        this.detypeDirtyFlag = true;
    }

    public Integer getDEType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEType();
        }
        return this.detype;
    }

    public boolean isDETypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDETypeDirty();
        }
        return this.detypeDirtyFlag;
    }

    public void resetDEType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEType();
            return;
        }
        this.detypeDirtyFlag = false;
        this.detype = null;
    }

    public void setDEUserParam(String deuserparam) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEUserParam(deuserparam);
            return;
        }
        if (deuserparam != null && (deuserparam = StringHelper.trimRight(deuserparam)).length() == 0) {
            deuserparam = null;
        }
        this.deuserparam = deuserparam;
        this.deuserparamDirtyFlag = true;
    }

    public String getDEUserParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEUserParam();
        }
        return this.deuserparam;
    }

    public boolean isDEUserParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEUserParamDirty();
        }
        return this.deuserparamDirtyFlag;
    }

    public void resetDEUserParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEUserParam();
            return;
        }
        this.deuserparamDirtyFlag = false;
        this.deuserparam = null;
    }

    public void setDEVersion(Integer deversion) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEVersion(deversion);
            return;
        }
        this.deversion = deversion;
        this.deversionDirtyFlag = true;
    }

    public Integer getDEVersion() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEVersion();
        }
        return this.deversion;
    }

    public boolean isDEVersionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEVersionDirty();
        }
        return this.deversionDirtyFlag;
    }

    public void resetDEVersion() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEVersion();
            return;
        }
        this.deversionDirtyFlag = false;
        this.deversion = null;
    }

    public void setDGRowClassHelper(String dgrowclasshelper) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDGRowClassHelper(dgrowclasshelper);
            return;
        }
        if (dgrowclasshelper != null && (dgrowclasshelper = StringHelper.trimRight(dgrowclasshelper)).length() == 0) {
            dgrowclasshelper = null;
        }
        this.dgrowclasshelper = dgrowclasshelper;
        this.dgrowclasshelperDirtyFlag = true;
    }

    public String getDGRowClassHelper() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDGRowClassHelper();
        }
        return this.dgrowclasshelper;
    }

    public boolean isDGRowClassHelperDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDGRowClassHelperDirty();
        }
        return this.dgrowclasshelperDirtyFlag;
    }

    public void resetDGRowClassHelper() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDGRowClassHelper();
            return;
        }
        this.dgrowclasshelperDirtyFlag = false;
        this.dgrowclasshelper = null;
    }

    public void setDGSUMMARYHeight(Integer dgsummaryheight) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDGSUMMARYHeight(dgsummaryheight);
            return;
        }
        this.dgsummaryheight = dgsummaryheight;
        this.dgsummaryheightDirtyFlag = true;
    }

    public Integer getDGSUMMARYHeight() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDGSUMMARYHeight();
        }
        return this.dgsummaryheight;
    }

    public boolean isDGSUMMARYHeightDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDGSUMMARYHeightDirty();
        }
        return this.dgsummaryheightDirtyFlag;
    }

    public void resetDGSUMMARYHeight() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDGSUMMARYHeight();
            return;
        }
        this.dgsummaryheightDirtyFlag = false;
        this.dgsummaryheight = null;
    }

    public void setDLKHelper(String dlkhelper) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDLKHelper(dlkhelper);
            return;
        }
        if (dlkhelper != null && (dlkhelper = StringHelper.trimRight(dlkhelper)).length() == 0) {
            dlkhelper = null;
        }
        this.dlkhelper = dlkhelper;
        this.dlkhelperDirtyFlag = true;
    }

    public String getDLKHelper() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDLKHelper();
        }
        return this.dlkhelper;
    }

    public boolean isDLKHelperDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDLKHelperDirty();
        }
        return this.dlkhelperDirtyFlag;
    }

    public void resetDLKHelper() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDLKHelper();
            return;
        }
        this.dlkhelperDirtyFlag = false;
        this.dlkhelper = null;
    }

    public void setDynamicInterval(Integer dynamicinterval) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynamicInterval(dynamicinterval);
            return;
        }
        this.dynamicinterval = dynamicinterval;
        this.dynamicintervalDirtyFlag = true;
    }

    public Integer getDynamicInterval() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynamicInterval();
        }
        return this.dynamicinterval;
    }

    public boolean isDynamicIntervalDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynamicIntervalDirty();
        }
        return this.dynamicintervalDirtyFlag;
    }

    public void resetDynamicInterval() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynamicInterval();
            return;
        }
        this.dynamicintervalDirtyFlag = false;
        this.dynamicinterval = null;
    }

    public void setEnableColPriv(Integer enablecolpriv) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableColPriv(enablecolpriv);
            return;
        }
        this.enablecolpriv = enablecolpriv;
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

    public void setEnableGlobalModel(Integer enableglobalmodel) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableGlobalModel(enableglobalmodel);
            return;
        }
        this.enableglobalmodel = enableglobalmodel;
        this.enableglobalmodelDirtyFlag = true;
    }

    public Integer getEnableGlobalModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableGlobalModel();
        }
        return this.enableglobalmodel;
    }

    public boolean isEnableGlobalModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableGlobalModelDirty();
        }
        return this.enableglobalmodelDirtyFlag;
    }

    public void resetEnableGlobalModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableGlobalModel();
            return;
        }
        this.enableglobalmodelDirtyFlag = false;
        this.enableglobalmodel = null;
    }

    public void setExitingModel(Integer exitingmodel) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExitingModel(exitingmodel);
            return;
        }
        this.exitingmodel = exitingmodel;
        this.exitingmodelDirtyFlag = true;
    }

    public Integer getExitingModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExitingModel();
        }
        return this.exitingmodel;
    }

    public boolean isExitingModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExitingModelDirty();
        }
        return this.exitingmodelDirtyFlag;
    }

    public void resetExitingModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExitingModel();
            return;
        }
        this.exitingmodelDirtyFlag = false;
        this.exitingmodel = null;
    }

    public void setExportIncEmpty(Integer exportincempty) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExportIncEmpty(exportincempty);
            return;
        }
        this.exportincempty = exportincempty;
        this.exportincemptyDirtyFlag = true;
    }

    public Integer getExportIncEmpty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExportIncEmpty();
        }
        return this.exportincempty;
    }

    public boolean isExportIncEmptyDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExportIncEmptyDirty();
        }
        return this.exportincemptyDirtyFlag;
    }

    public void resetExportIncEmpty() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExportIncEmpty();
            return;
        }
        this.exportincemptyDirtyFlag = false;
        this.exportincempty = null;
    }

    public void setExTableName(String extablename) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExTableName(extablename);
            return;
        }
        if (extablename != null && (extablename = StringHelper.trimRight(extablename)).length() == 0) {
            extablename = null;
        }
        this.extablename = extablename;
        this.extablenameDirtyFlag = true;
    }

    public String getExTableName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExTableName();
        }
        return this.extablename;
    }

    public boolean isExTableNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExTableNameDirty();
        }
        return this.extablenameDirtyFlag;
    }

    public void resetExTableName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExTableName();
            return;
        }
        this.extablenameDirtyFlag = false;
        this.extablename = null;
    }

    public void setGlobalModelObj(String globalmodelobj) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGlobalModelObj(globalmodelobj);
            return;
        }
        if (globalmodelobj != null && (globalmodelobj = StringHelper.trimRight(globalmodelobj)).length() == 0) {
            globalmodelobj = null;
        }
        this.globalmodelobj = globalmodelobj;
        this.globalmodelobjDirtyFlag = true;
    }

    public String getGlobalModelObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGlobalModelObj();
        }
        return this.globalmodelobj;
    }

    public boolean isGlobalModelObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGlobalModelObjDirty();
        }
        return this.globalmodelobjDirtyFlag;
    }

    public void resetGlobalModelObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGlobalModelObj();
            return;
        }
        this.globalmodelobjDirtyFlag = false;
        this.globalmodelobj = null;
    }

    public void setIndexMode(Integer indexmode) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIndexMode(indexmode);
            return;
        }
        this.indexmode = indexmode;
        this.indexmodeDirtyFlag = true;
    }

    public Integer getIndexMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIndexMode();
        }
        return this.indexmode;
    }

    public boolean isIndexModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIndexModeDirty();
        }
        return this.indexmodeDirtyFlag;
    }

    public void resetIndexMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIndexMode();
            return;
        }
        this.indexmodeDirtyFlag = false;
        this.indexmode = null;
    }

    public void setInfoField(String infofield) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInfoField(infofield);
            return;
        }
        if (infofield != null && (infofield = StringHelper.trimRight(infofield)).length() == 0) {
            infofield = null;
        }
        this.infofield = infofield;
        this.infofieldDirtyFlag = true;
    }

    public String getInfoField() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInfoField();
        }
        return this.infofield;
    }

    public boolean isInfoFieldDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInfoFieldDirty();
        }
        return this.infofieldDirtyFlag;
    }

    public void resetInfoField() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInfoField();
            return;
        }
        this.infofieldDirtyFlag = false;
        this.infofield = null;
    }

    public void setInfoFormat(String infoformat) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInfoFormat(infoformat);
            return;
        }
        if (infoformat != null && (infoformat = StringHelper.trimRight(infoformat)).length() == 0) {
            infoformat = null;
        }
        this.infoformat = infoformat;
        this.infoformatDirtyFlag = true;
    }

    public String getInfoFormat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInfoFormat();
        }
        return this.infoformat;
    }

    public boolean isInfoFormatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInfoFormatDirty();
        }
        return this.infoformatDirtyFlag;
    }

    public void resetInfoFormat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInfoFormat();
            return;
        }
        this.infoformatDirtyFlag = false;
        this.infoformat = null;
    }

    public void setInheritMode(Integer inheritmode) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInheritMode(inheritmode);
            return;
        }
        this.inheritmode = inheritmode;
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

    public void setIsDGRowEdit(Integer isdgrowedit) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIsDGRowEdit(isdgrowedit);
            return;
        }
        this.isdgrowedit = isdgrowedit;
        this.isdgroweditDirtyFlag = true;
    }

    public Integer getIsDGRowEdit() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIsDGRowEdit();
        }
        return this.isdgrowedit;
    }

    public boolean isIsDGRowEditDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIsDGRowEditDirty();
        }
        return this.isdgroweditDirtyFlag;
    }

    public void resetIsDGRowEdit() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIsDGRowEdit();
            return;
        }
        this.isdgroweditDirtyFlag = false;
        this.isdgrowedit = null;
    }

    public void setIsEnableAudit(Integer isenableaudit) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIsEnableAudit(isenableaudit);
            return;
        }
        this.isenableaudit = isenableaudit;
        this.isenableauditDirtyFlag = true;
    }

    public Integer getIsEnableAudit() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIsEnableAudit();
        }
        return this.isenableaudit;
    }

    public boolean isIsEnableAuditDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIsEnableAuditDirty();
        }
        return this.isenableauditDirtyFlag;
    }

    public void resetIsEnableAudit() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIsEnableAudit();
            return;
        }
        this.isenableauditDirtyFlag = false;
        this.isenableaudit = null;
    }

    public void setIsEnableDP(Integer isenabledp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIsEnableDP(isenabledp);
            return;
        }
        this.isenabledp = isenabledp;
        this.isenabledpDirtyFlag = true;
    }

    public Integer getIsEnableDP() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIsEnableDP();
        }
        return this.isenabledp;
    }

    public boolean isIsEnableDPDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIsEnableDPDirty();
        }
        return this.isenabledpDirtyFlag;
    }

    public void resetIsEnableDP() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIsEnableDP();
            return;
        }
        this.isenabledpDirtyFlag = false;
        this.isenabledp = null;
    }

    public void setIsIndexDE(Integer isindexde) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIsIndexDE(isindexde);
            return;
        }
        this.isindexde = isindexde;
        this.isindexdeDirtyFlag = true;
    }

    public Integer getIsIndexDE() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIsIndexDE();
        }
        return this.isindexde;
    }

    public boolean isIsIndexDEDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIsIndexDEDirty();
        }
        return this.isindexdeDirtyFlag;
    }

    public void resetIsIndexDE() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIsIndexDE();
            return;
        }
        this.isindexdeDirtyFlag = false;
        this.isindexde = null;
    }

    public void setIsLogicValid(Integer islogicvalid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIsLogicValid(islogicvalid);
            return;
        }
        this.islogicvalid = islogicvalid;
        this.islogicvalidDirtyFlag = true;
    }

    public Integer getIsLogicValid() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIsLogicValid();
        }
        return this.islogicvalid;
    }

    public boolean isIsLogicValidDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIsLogicValidDirty();
        }
        return this.islogicvalidDirtyFlag;
    }

    public void resetIsLogicValid() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIsLogicValid();
            return;
        }
        this.islogicvalidDirtyFlag = false;
        this.islogicvalid = null;
    }

    public void setISMULTIPRINT(Integer ismultiprint) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setISMULTIPRINT(ismultiprint);
            return;
        }
        this.ismultiprint = ismultiprint;
        this.ismultiprintDirtyFlag = true;
    }

    public Integer getISMULTIPRINT() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getISMULTIPRINT();
        }
        return this.ismultiprint;
    }

    public boolean isISMULTIPRINTDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isISMULTIPRINTDirty();
        }
        return this.ismultiprintDirtyFlag;
    }

    public void resetISMULTIPRINT() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetISMULTIPRINT();
            return;
        }
        this.ismultiprintDirtyFlag = false;
        this.ismultiprint = null;
    }

    public void setISSupportFA(Integer issupportfa) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setISSupportFA(issupportfa);
            return;
        }
        this.issupportfa = issupportfa;
        this.issupportfaDirtyFlag = true;
    }

    public Integer getISSupportFA() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getISSupportFA();
        }
        return this.issupportfa;
    }

    public boolean isISSupportFADirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isISSupportFADirty();
        }
        return this.issupportfaDirtyFlag;
    }

    public void resetISSupportFA() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetISSupportFA();
            return;
        }
        this.issupportfaDirtyFlag = false;
        this.issupportfa = null;
    }

    public void setIsSystem(Integer issystem) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIsSystem(issystem);
            return;
        }
        this.issystem = issystem;
        this.issystemDirtyFlag = true;
    }

    public Integer getIsSystem() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIsSystem();
        }
        return this.issystem;
    }

    public boolean isIsSystemDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIsSystemDirty();
        }
        return this.issystemDirtyFlag;
    }

    public void resetIsSystem() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIsSystem();
            return;
        }
        this.issystemDirtyFlag = false;
        this.issystem = null;
    }

    public void setKeyParams(String keyparams) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setKeyParams(keyparams);
            return;
        }
        if (keyparams != null && (keyparams = StringHelper.trimRight(keyparams)).length() == 0) {
            keyparams = null;
        }
        this.keyparams = keyparams;
        this.keyparamsDirtyFlag = true;
    }

    public String getKeyParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getKeyParams();
        }
        return this.keyparams;
    }

    public boolean isKeyParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isKeyParamsDirty();
        }
        return this.keyparamsDirtyFlag;
    }

    public void resetKeyParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetKeyParams();
            return;
        }
        this.keyparamsDirtyFlag = false;
        this.keyparams = null;
    }

    public void setLicenseCode(String licensecode) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLicenseCode(licensecode);
            return;
        }
        if (licensecode != null && (licensecode = StringHelper.trimRight(licensecode)).length() == 0) {
            licensecode = null;
        }
        this.licensecode = licensecode;
        this.licensecodeDirtyFlag = true;
    }

    public String getLicenseCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLicenseCode();
        }
        return this.licensecode;
    }

    public boolean isLicenseCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLicenseCodeDirty();
        }
        return this.licensecodeDirtyFlag;
    }

    public void resetLicenseCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLicenseCode();
            return;
        }
        this.licensecodeDirtyFlag = false;
        this.licensecode = null;
    }

    public void setLogAuditDetail(Integer logauditdetail) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogAuditDetail(logauditdetail);
            return;
        }
        this.logauditdetail = logauditdetail;
        this.logauditdetailDirtyFlag = true;
    }

    public Integer getLogAuditDetail() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogAuditDetail();
        }
        return this.logauditdetail;
    }

    public boolean isLogAuditDetailDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogAuditDetailDirty();
        }
        return this.logauditdetailDirtyFlag;
    }

    public void resetLogAuditDetail() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogAuditDetail();
            return;
        }
        this.logauditdetailDirtyFlag = false;
        this.logauditdetail = null;
    }

    public void setMemo(String memo) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMemo(memo);
            return;
        }
        if (memo != null && (memo = StringHelper.trimRight(memo)).length() == 0) {
            memo = null;
        }
        this.memo = memo;
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

    public void setMinorFieldName(String minorfieldname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinorFieldName(minorfieldname);
            return;
        }
        if (minorfieldname != null && (minorfieldname = StringHelper.trimRight(minorfieldname)).length() == 0) {
            minorfieldname = null;
        }
        this.minorfieldname = minorfieldname;
        this.minorfieldnameDirtyFlag = true;
    }

    public String getMinorFieldName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorFieldName();
        }
        return this.minorfieldname;
    }

    public boolean isMinorFieldNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinorFieldNameDirty();
        }
        return this.minorfieldnameDirtyFlag;
    }

    public void resetMinorFieldName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinorFieldName();
            return;
        }
        this.minorfieldnameDirtyFlag = false;
        this.minorfieldname = null;
    }

    public void setMinorFieldValue(String minorfieldvalue) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinorFieldValue(minorfieldvalue);
            return;
        }
        if (minorfieldvalue != null && (minorfieldvalue = StringHelper.trimRight(minorfieldvalue)).length() == 0) {
            minorfieldvalue = null;
        }
        this.minorfieldvalue = minorfieldvalue;
        this.minorfieldvalueDirtyFlag = true;
    }

    public String getMinorFieldValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorFieldValue();
        }
        return this.minorfieldvalue;
    }

    public boolean isMinorFieldValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinorFieldValueDirty();
        }
        return this.minorfieldvalueDirtyFlag;
    }

    public void resetMinorFieldValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinorFieldValue();
            return;
        }
        this.minorfieldvalueDirtyFlag = false;
        this.minorfieldvalue = null;
    }

    public void setMinorTableName(String minortablename) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinorTableName(minortablename);
            return;
        }
        if (minortablename != null && (minortablename = StringHelper.trimRight(minortablename)).length() == 0) {
            minortablename = null;
        }
        this.minortablename = minortablename;
        this.minortablenameDirtyFlag = true;
    }

    public String getMinorTableName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorTableName();
        }
        return this.minortablename;
    }

    public boolean isMinorTableNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinorTableNameDirty();
        }
        return this.minortablenameDirtyFlag;
    }

    public void resetMinorTableName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinorTableName();
            return;
        }
        this.minortablenameDirtyFlag = false;
        this.minortablename = null;
    }

    public void setMutliMajor(Integer mutlimajor) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMutliMajor(mutlimajor);
            return;
        }
        this.mutlimajor = mutlimajor;
        this.mutlimajorDirtyFlag = true;
    }

    public Integer getMutliMajor() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMutliMajor();
        }
        return this.mutlimajor;
    }

    public boolean isMutliMajorDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMutliMajorDirty();
        }
        return this.mutlimajorDirtyFlag;
    }

    public void resetMutliMajor() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMutliMajor();
            return;
        }
        this.mutlimajorDirtyFlag = false;
        this.mutlimajor = null;
    }

    public void setNoDataInfo(Integer nodatainfo) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNoDataInfo(nodatainfo);
            return;
        }
        this.nodatainfo = nodatainfo;
        this.nodatainfoDirtyFlag = true;
    }

    public Integer getNoDataInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNoDataInfo();
        }
        return this.nodatainfo;
    }

    public boolean isNoDataInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNoDataInfoDirty();
        }
        return this.nodatainfoDirtyFlag;
    }

    public void resetNoDataInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNoDataInfo();
            return;
        }
        this.nodatainfoDirtyFlag = false;
        this.nodatainfo = null;
    }

    public void setPrintFunc(String printfunc) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPrintFunc(printfunc);
            return;
        }
        if (printfunc != null && (printfunc = StringHelper.trimRight(printfunc)).length() == 0) {
            printfunc = null;
        }
        this.printfunc = printfunc;
        this.printfuncDirtyFlag = true;
    }

    public String getPrintFunc() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPrintFunc();
        }
        return this.printfunc;
    }

    public boolean isPrintFuncDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPrintFuncDirty();
        }
        return this.printfuncDirtyFlag;
    }

    public void resetPrintFunc() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPrintFunc();
            return;
        }
        this.printfuncDirtyFlag = false;
        this.printfunc = null;
    }

    public void setReserver(String reserver) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver(reserver);
            return;
        }
        if (reserver != null && (reserver = StringHelper.trimRight(reserver)).length() == 0) {
            reserver = null;
        }
        this.reserver = reserver;
        this.reserverDirtyFlag = true;
    }

    public String getReserver() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver();
        }
        return this.reserver;
    }

    public boolean isReserverDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserverDirty();
        }
        return this.reserverDirtyFlag;
    }

    public void resetReserver() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver();
            return;
        }
        this.reserverDirtyFlag = false;
        this.reserver = null;
    }

    public void setReserver2(String reserver2) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver2(reserver2);
            return;
        }
        if (reserver2 != null && (reserver2 = StringHelper.trimRight(reserver2)).length() == 0) {
            reserver2 = null;
        }
        this.reserver2 = reserver2;
        this.reserver2DirtyFlag = true;
    }

    public String getReserver2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver2();
        }
        return this.reserver2;
    }

    public boolean isReserver2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserver2Dirty();
        }
        return this.reserver2DirtyFlag;
    }

    public void resetReserver2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver2();
            return;
        }
        this.reserver2DirtyFlag = false;
        this.reserver2 = null;
    }

    public void setRowAmout(Integer rowamout) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRowAmout(rowamout);
            return;
        }
        this.rowamout = rowamout;
        this.rowamoutDirtyFlag = true;
    }

    public Integer getRowAmout() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRowAmout();
        }
        return this.rowamout;
    }

    public boolean isRowAmoutDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRowAmoutDirty();
        }
        return this.rowamoutDirtyFlag;
    }

    public void resetRowAmout() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRowAmout();
            return;
        }
        this.rowamoutDirtyFlag = false;
        this.rowamout = null;
    }

    public void setRTInfo(String rtinfo) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRTInfo(rtinfo);
            return;
        }
        if (rtinfo != null && (rtinfo = StringHelper.trimRight(rtinfo)).length() == 0) {
            rtinfo = null;
        }
        this.rtinfo = rtinfo;
        this.rtinfoDirtyFlag = true;
    }

    public String getRTInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRTInfo();
        }
        return this.rtinfo;
    }

    public boolean isRTInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRTInfoDirty();
        }
        return this.rtinfoDirtyFlag;
    }

    public void resetRTInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRTInfo();
            return;
        }
        this.rtinfoDirtyFlag = false;
        this.rtinfo = null;
    }

    public void setSMALLICON(String smallicon) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSMALLICON(smallicon);
            return;
        }
        if (smallicon != null && (smallicon = StringHelper.trimRight(smallicon)).length() == 0) {
            smallicon = null;
        }
        this.smallicon = smallicon;
        this.smalliconDirtyFlag = true;
    }

    public String getSMALLICON() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSMALLICON();
        }
        return this.smallicon;
    }

    public boolean isSMALLICONDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSMALLICONDirty();
        }
        return this.smalliconDirtyFlag;
    }

    public void resetSMALLICON() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSMALLICON();
            return;
        }
        this.smalliconDirtyFlag = false;
        this.smallicon = null;
    }

    public void setStorageType(String storagetype) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStorageType(storagetype);
            return;
        }
        if (storagetype != null && (storagetype = StringHelper.trimRight(storagetype)).length() == 0) {
            storagetype = null;
        }
        this.storagetype = storagetype;
        this.storagetypeDirtyFlag = true;
    }

    public String getStorageType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStorageType();
        }
        return this.storagetype;
    }

    public boolean isStorageTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStorageTypeDirty();
        }
        return this.storagetypeDirtyFlag;
    }

    public void resetStorageType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStorageType();
            return;
        }
        this.storagetypeDirtyFlag = false;
        this.storagetype = null;
    }

    public void setTableName(String tablename) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTableName(tablename);
            return;
        }
        if (tablename != null && (tablename = StringHelper.trimRight(tablename)).length() == 0) {
            tablename = null;
        }
        this.tablename = tablename;
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

    public void setTableSpace(String tablespace) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTableSpace(tablespace);
            return;
        }
        if (tablespace != null && (tablespace = StringHelper.trimRight(tablespace)).length() == 0) {
            tablespace = null;
        }
        this.tablespace = tablespace;
        this.tablespaceDirtyFlag = true;
    }

    public String getTableSpace() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTableSpace();
        }
        return this.tablespace;
    }

    public boolean isTableSpaceDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTableSpaceDirty();
        }
        return this.tablespaceDirtyFlag;
    }

    public void resetTableSpace() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTableSpace();
            return;
        }
        this.tablespaceDirtyFlag = false;
        this.tablespace = null;
    }

    public void setTipsInfo(String tipsinfo) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTipsInfo(tipsinfo);
            return;
        }
        if (tipsinfo != null && (tipsinfo = StringHelper.trimRight(tipsinfo)).length() == 0) {
            tipsinfo = null;
        }
        this.tipsinfo = tipsinfo;
        this.tipsinfoDirtyFlag = true;
    }

    public String getTipsInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTipsInfo();
        }
        return this.tipsinfo;
    }

    public boolean isTipsInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTipsInfoDirty();
        }
        return this.tipsinfoDirtyFlag;
    }

    public void resetTipsInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTipsInfo();
            return;
        }
        this.tipsinfoDirtyFlag = false;
        this.tipsinfo = null;
    }

    public void setUpdateDate(Timestamp updatedate) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateDate(updatedate);
            return;
        }
        this.updatedate = updatedate;
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

    public void setUpdateMan(String updateman) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateMan(updateman);
            return;
        }
        if (updateman != null && (updateman = StringHelper.trimRight(updateman)).length() == 0) {
            updateman = null;
        }
        this.updateman = updateman;
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

    public void setUserAction(Integer useraction) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserAction(useraction);
            return;
        }
        this.useraction = useraction;
        this.useractionDirtyFlag = true;
    }

    public Integer getUserAction() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserAction();
        }
        return this.useraction;
    }

    public boolean isUserActionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserActionDirty();
        }
        return this.useractionDirtyFlag;
    }

    public void resetUserAction() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserAction();
            return;
        }
        this.useractionDirtyFlag = false;
        this.useraction = null;
    }

    public void setValidFlag(Integer validflag) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValidFlag(validflag);
            return;
        }
        this.validflag = validflag;
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

    public void setVCFlag(Integer vcflag) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVCFlag(vcflag);
            return;
        }
        this.vcflag = vcflag;
        this.vcflagDirtyFlag = true;
    }

    public Integer getVCFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVCFlag();
        }
        return this.vcflag;
    }

    public boolean isVCFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVCFlagDirty();
        }
        return this.vcflagDirtyFlag;
    }

    public void resetVCFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVCFlag();
            return;
        }
        this.vcflagDirtyFlag = false;
        this.vcflag = null;
    }

    public void setVerCheckTimer(Integer verchecktimer) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVerCheckTimer(verchecktimer);
            return;
        }
        this.verchecktimer = verchecktimer;
        this.verchecktimerDirtyFlag = true;
    }

    public Integer getVerCheckTimer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVerCheckTimer();
        }
        return this.verchecktimer;
    }

    public boolean isVerCheckTimerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVerCheckTimerDirty();
        }
        return this.verchecktimerDirtyFlag;
    }

    public void resetVerCheckTimer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVerCheckTimer();
            return;
        }
        this.verchecktimerDirtyFlag = false;
        this.verchecktimer = null;
    }

    public void setVerField(String verfield) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVerField(verfield);
            return;
        }
        if (verfield != null && (verfield = StringHelper.trimRight(verfield)).length() == 0) {
            verfield = null;
        }
        this.verfield = verfield;
        this.verfieldDirtyFlag = true;
    }

    public String getVerField() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVerField();
        }
        return this.verfield;
    }

    public boolean isVerFieldDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVerFieldDirty();
        }
        return this.verfieldDirtyFlag;
    }

    public void resetVerField() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVerField();
            return;
        }
        this.verfieldDirtyFlag = false;
        this.verfield = null;
    }

    public void setVerHelper(String verhelper) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVerHelper(verhelper);
            return;
        }
        if (verhelper != null && (verhelper = StringHelper.trimRight(verhelper)).length() == 0) {
            verhelper = null;
        }
        this.verhelper = verhelper;
        this.verhelperDirtyFlag = true;
    }

    public String getVerHelper() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVerHelper();
        }
        return this.verhelper;
    }

    public boolean isVerHelperDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVerHelperDirty();
        }
        return this.verhelperDirtyFlag;
    }

    public void resetVerHelper() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVerHelper();
            return;
        }
        this.verhelperDirtyFlag = false;
        this.verhelper = null;
    }

    public void setVersionCheck(Integer versioncheck) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVersionCheck(versioncheck);
            return;
        }
        this.versioncheck = versioncheck;
        this.versioncheckDirtyFlag = true;
    }

    public Integer getVersionCheck() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVersionCheck();
        }
        return this.versioncheck;
    }

    public boolean isVersionCheckDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVersionCheckDirty();
        }
        return this.versioncheckDirtyFlag;
    }

    public void resetVersionCheck() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVersionCheck();
            return;
        }
        this.versioncheckDirtyFlag = false;
        this.versioncheck = null;
    }

    public void setViewName(String viewname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewName(viewname);
            return;
        }
        if (viewname != null && (viewname = StringHelper.trimRight(viewname)).length() == 0) {
            viewname = null;
        }
        this.viewname = viewname;
        this.viewnameDirtyFlag = true;
    }

    public String getViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewName();
        }
        return this.viewname;
    }

    public boolean isViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewNameDirty();
        }
        return this.viewnameDirtyFlag;
    }

    public void resetViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewName();
            return;
        }
        this.viewnameDirtyFlag = false;
        this.viewname = null;
    }

    @Override
    protected void onReset() {
        DataEntityBase.resetAll(this);
        super.onReset();
    }

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

    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if (!bDirtyOnly || this.isACEnableDPDirty()) {
            params.put(FIELD_ACENABLEDP, this.getACEnableDP());
        }
        if (!bDirtyOnly || this.isACExtInfoDirty()) {
            params.put(FIELD_ACEXTINFO, this.getACExtInfo());
        }
        if (!bDirtyOnly || this.isACInfoFormatDirty()) {
            params.put(FIELD_ACINFOFORMAT, this.getACInfoFormat());
        }
        if (!bDirtyOnly || this.isACInfoParamDirty()) {
            params.put(FIELD_ACINFOPARAM, this.getACInfoParam());
        }
        if (!bDirtyOnly || this.isACMaxCntDirty()) {
            params.put(FIELD_ACMAXCNT, this.getACMaxCnt());
        }
        if (!bDirtyOnly || this.isACObjectDirty()) {
            params.put(FIELD_ACOBJECT, this.getACObject());
        }
        if (!bDirtyOnly || this.isACQueryModelIdDirty()) {
            params.put(FIELD_ACQUERYMODELID, this.getACQueryModelId());
        }
        if (!bDirtyOnly || this.isACQueryModelNameDirty()) {
            params.put(FIELD_ACQUERYMODELNAME, this.getACQueryModelName());
        }
        if (!bDirtyOnly || this.isACSortDirDirty()) {
            params.put(FIELD_ACSORTDIR, this.getACSortDir());
        }
        if (!bDirtyOnly || this.isACSortFieldDirty()) {
            params.put(FIELD_ACSORTFIELD, this.getACSortField());
        }
        if (!bDirtyOnly || this.isBigIconDirty()) {
            params.put(FIELD_BIGICON, this.getBigIcon());
        }
        if (!bDirtyOnly || this.isConfigHelperDirty()) {
            params.put(FIELD_CONFIGHELPER, this.getConfigHelper());
        }
        if (!bDirtyOnly || this.isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bDirtyOnly || this.isCreateManDirty()) {
            params.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bDirtyOnly || this.isDataAccObjectDirty()) {
            params.put(FIELD_DATAACCOBJECT, this.getDataAccObject());
        }
        if (!bDirtyOnly || this.isDataChgLogModeDirty()) {
            params.put(FIELD_DATACHGLOGMODE, this.getDataChgLogMode());
        }
        if (!bDirtyOnly || this.isDataCtrlIntDirty()) {
            params.put(FIELD_DATACTRLINT, this.getDataCtrlInt());
        }
        if (!bDirtyOnly || this.isDataCtrlObjectDirty()) {
            params.put(FIELD_DATACTRLOBJECT, this.getDataCtrlObject());
        }
        if (!bDirtyOnly || this.isDataNotifyHelperDirty()) {
            params.put(FIELD_DATANOTIFYHELPER, this.getDataNotifyHelper());
        }
        if (!bDirtyOnly || this.isDBStorageDirty()) {
            params.put(FIELD_DBSTORAGE, this.getDBStorage());
        }
        if (!bDirtyOnly || this.isDBVersionDirty()) {
            params.put(FIELD_DBVERSION, this.getDBVersion());
        }
        if (!bDirtyOnly || this.isDEGroupDirty()) {
            params.put(FIELD_DEGROUP, this.getDEGroup());
        }
        if (!bDirtyOnly || this.isDEHelperDirty()) {
            params.put(FIELD_DEHELPER, this.getDEHelper());
        }
        if (!bDirtyOnly || this.isDEIdDirty()) {
            params.put(FIELD_DEID, this.getDEId());
        }
        if (!bDirtyOnly || this.isDELogicNameDirty()) {
            params.put(FIELD_DELOGICNAME, this.getDELogicName());
        }
        if (!bDirtyOnly || this.isDENameDirty()) {
            params.put(FIELD_DENAME, this.getDEName());
        }
        if (!bDirtyOnly || this.isDEObjectDirty()) {
            params.put(FIELD_DEOBJECT, this.getDEObject());
        }
        if (!bDirtyOnly || this.isDEOrderDirty()) {
            params.put(FIELD_DEORDER, this.getDEOrder());
        }
        if (!bDirtyOnly || this.isDEParamDirty()) {
            params.put(FIELD_DEPARAM, this.getDEParam());
        }
        if (!bDirtyOnly || this.isDER11DEIdDirty()) {
            params.put(FIELD_DER11DEID, this.getDER11DEId());
        }
        if (!bDirtyOnly || this.isDER11DENameDirty()) {
            params.put(FIELD_DER11DENAME, this.getDER11DEName());
        }
        if (!bDirtyOnly || this.isDETypeDirty()) {
            params.put(FIELD_DETYPE, this.getDEType());
        }
        if (!bDirtyOnly || this.isDEUserParamDirty()) {
            params.put(FIELD_DEUSERPARAM, this.getDEUserParam());
        }
        if (!bDirtyOnly || this.isDEVersionDirty()) {
            params.put(FIELD_DEVERSION, this.getDEVersion());
        }
        if (!bDirtyOnly || this.isDGRowClassHelperDirty()) {
            params.put(FIELD_DGROWCLASSHELPER, this.getDGRowClassHelper());
        }
        if (!bDirtyOnly || this.isDGSUMMARYHeightDirty()) {
            params.put(FIELD_DGSUMMARYHEIGHT, this.getDGSUMMARYHeight());
        }
        if (!bDirtyOnly || this.isDLKHelperDirty()) {
            params.put(FIELD_DLKHELPER, this.getDLKHelper());
        }
        if (!bDirtyOnly || this.isDynamicIntervalDirty()) {
            params.put(FIELD_DYNAMICINTERVAL, this.getDynamicInterval());
        }
        if (!bDirtyOnly || this.isEnableColPrivDirty()) {
            params.put(FIELD_ENABLECOLPRIV, this.getEnableColPriv());
        }
        if (!bDirtyOnly || this.isEnableGlobalModelDirty()) {
            params.put(FIELD_ENABLEGLOBALMODEL, this.getEnableGlobalModel());
        }
        if (!bDirtyOnly || this.isExitingModelDirty()) {
            params.put(FIELD_EXITINGMODEL, this.getExitingModel());
        }
        if (!bDirtyOnly || this.isExportIncEmptyDirty()) {
            params.put(FIELD_EXPORTINCEMPTY, this.getExportIncEmpty());
        }
        if (!bDirtyOnly || this.isExTableNameDirty()) {
            params.put(FIELD_EXTABLENAME, this.getExTableName());
        }
        if (!bDirtyOnly || this.isGlobalModelObjDirty()) {
            params.put(FIELD_GLOBALMODELOBJ, this.getGlobalModelObj());
        }
        if (!bDirtyOnly || this.isIndexModeDirty()) {
            params.put(FIELD_INDEXMODE, this.getIndexMode());
        }
        if (!bDirtyOnly || this.isInfoFieldDirty()) {
            params.put(FIELD_INFOFIELD, this.getInfoField());
        }
        if (!bDirtyOnly || this.isInfoFormatDirty()) {
            params.put(FIELD_INFOFORMAT, this.getInfoFormat());
        }
        if (!bDirtyOnly || this.isInheritModeDirty()) {
            params.put(FIELD_INHERITMODE, this.getInheritMode());
        }
        if (!bDirtyOnly || this.isIsDGRowEditDirty()) {
            params.put(FIELD_ISDGROWEDIT, this.getIsDGRowEdit());
        }
        if (!bDirtyOnly || this.isIsEnableAuditDirty()) {
            params.put(FIELD_ISENABLEAUDIT, this.getIsEnableAudit());
        }
        if (!bDirtyOnly || this.isIsEnableDPDirty()) {
            params.put(FIELD_ISENABLEDP, this.getIsEnableDP());
        }
        if (!bDirtyOnly || this.isIsIndexDEDirty()) {
            params.put(FIELD_ISINDEXDE, this.getIsIndexDE());
        }
        if (!bDirtyOnly || this.isIsLogicValidDirty()) {
            params.put(FIELD_ISLOGICVALID, this.getIsLogicValid());
        }
        if (!bDirtyOnly || this.isISMULTIPRINTDirty()) {
            params.put(FIELD_ISMULTIPRINT, this.getISMULTIPRINT());
        }
        if (!bDirtyOnly || this.isISSupportFADirty()) {
            params.put(FIELD_ISSUPPORTFA, this.getISSupportFA());
        }
        if (!bDirtyOnly || this.isIsSystemDirty()) {
            params.put(FIELD_ISSYSTEM, this.getIsSystem());
        }
        if (!bDirtyOnly || this.isKeyParamsDirty()) {
            params.put(FIELD_KEYPARAMS, this.getKeyParams());
        }
        if (!bDirtyOnly || this.isLicenseCodeDirty()) {
            params.put(FIELD_LICENSECODE, this.getLicenseCode());
        }
        if (!bDirtyOnly || this.isLogAuditDetailDirty()) {
            params.put(FIELD_LOGAUDITDETAIL, this.getLogAuditDetail());
        }
        if (!bDirtyOnly || this.isMemoDirty()) {
            params.put(FIELD_MEMO, this.getMemo());
        }
        if (!bDirtyOnly || this.isMinorFieldNameDirty()) {
            params.put(FIELD_MINORFIELDNAME, this.getMinorFieldName());
        }
        if (!bDirtyOnly || this.isMinorFieldValueDirty()) {
            params.put(FIELD_MINORFIELDVALUE, this.getMinorFieldValue());
        }
        if (!bDirtyOnly || this.isMinorTableNameDirty()) {
            params.put(FIELD_MINORTABLENAME, this.getMinorTableName());
        }
        if (!bDirtyOnly || this.isMutliMajorDirty()) {
            params.put(FIELD_MUTLIMAJOR, this.getMutliMajor());
        }
        if (!bDirtyOnly || this.isNoDataInfoDirty()) {
            params.put(FIELD_NODATAINFO, this.getNoDataInfo());
        }
        if (!bDirtyOnly || this.isPrintFuncDirty()) {
            params.put(FIELD_PRINTFUNC, this.getPrintFunc());
        }
        if (!bDirtyOnly || this.isReserverDirty()) {
            params.put(FIELD_RESERVER, this.getReserver());
        }
        if (!bDirtyOnly || this.isReserver2Dirty()) {
            params.put(FIELD_RESERVER2, this.getReserver2());
        }
        if (!bDirtyOnly || this.isRowAmoutDirty()) {
            params.put(FIELD_ROWAMOUT, this.getRowAmout());
        }
        if (!bDirtyOnly || this.isRTInfoDirty()) {
            params.put(FIELD_RTINFO, this.getRTInfo());
        }
        if (!bDirtyOnly || this.isSMALLICONDirty()) {
            params.put(FIELD_SMALLICON, this.getSMALLICON());
        }
        if (!bDirtyOnly || this.isStorageTypeDirty()) {
            params.put(FIELD_STORAGETYPE, this.getStorageType());
        }
        if (!bDirtyOnly || this.isTableNameDirty()) {
            params.put(FIELD_TABLENAME, this.getTableName());
        }
        if (!bDirtyOnly || this.isTableSpaceDirty()) {
            params.put(FIELD_TABLESPACE, this.getTableSpace());
        }
        if (!bDirtyOnly || this.isTipsInfoDirty()) {
            params.put(FIELD_TIPSINFO, this.getTipsInfo());
        }
        if (!bDirtyOnly || this.isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bDirtyOnly || this.isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bDirtyOnly || this.isUserActionDirty()) {
            params.put(FIELD_USERACTION, this.getUserAction());
        }
        if (!bDirtyOnly || this.isValidFlagDirty()) {
            params.put(FIELD_VALIDFLAG, this.getValidFlag());
        }
        if (!bDirtyOnly || this.isVCFlagDirty()) {
            params.put(FIELD_VCFLAG, this.getVCFlag());
        }
        if (!bDirtyOnly || this.isVerCheckTimerDirty()) {
            params.put(FIELD_VERCHECKTIMER, this.getVerCheckTimer());
        }
        if (!bDirtyOnly || this.isVerFieldDirty()) {
            params.put(FIELD_VERFIELD, this.getVerField());
        }
        if (!bDirtyOnly || this.isVerHelperDirty()) {
            params.put(FIELD_VERHELPER, this.getVerHelper());
        }
        if (!bDirtyOnly || this.isVersionCheckDirty()) {
            params.put(FIELD_VERSIONCHECK, this.getVersionCheck());
        }
        if (!bDirtyOnly || this.isViewNameDirty()) {
            params.put(FIELD_VIEWNAME, this.getViewName());
        }
        super.onFillMap(params, bDirtyOnly);
    }

    @Override
    public Object get(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().get(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.get(strParamName);
        }
        return DataEntityBase.get(this, index);
    }

    private static Object get(DataEntityBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getACEnableDP();
            }
            case 1: {
                return et.getACExtInfo();
            }
            case 2: {
                return et.getACInfoFormat();
            }
            case 3: {
                return et.getACInfoParam();
            }
            case 4: {
                return et.getACMaxCnt();
            }
            case 5: {
                return et.getACObject();
            }
            case 6: {
                return et.getACQueryModelId();
            }
            case 7: {
                return et.getACQueryModelName();
            }
            case 8: {
                return et.getACSortDir();
            }
            case 9: {
                return et.getACSortField();
            }
            case 10: {
                return et.getBigIcon();
            }
            case 11: {
                return et.getConfigHelper();
            }
            case 12: {
                return et.getCreateDate();
            }
            case 13: {
                return et.getCreateMan();
            }
            case 14: {
                return et.getDataAccObject();
            }
            case 15: {
                return et.getDataChgLogMode();
            }
            case 16: {
                return et.getDataCtrlInt();
            }
            case 17: {
                return et.getDataCtrlObject();
            }
            case 18: {
                return et.getDataNotifyHelper();
            }
            case 19: {
                return et.getDBStorage();
            }
            case 20: {
                return et.getDBVersion();
            }
            case 21: {
                return et.getDEGroup();
            }
            case 22: {
                return et.getDEHelper();
            }
            case 23: {
                return et.getDEId();
            }
            case 24: {
                return et.getDELogicName();
            }
            case 25: {
                return et.getDEName();
            }
            case 26: {
                return et.getDEObject();
            }
            case 27: {
                return et.getDEOrder();
            }
            case 28: {
                return et.getDEParam();
            }
            case 29: {
                return et.getDER11DEId();
            }
            case 30: {
                return et.getDER11DEName();
            }
            case 31: {
                return et.getDEType();
            }
            case 32: {
                return et.getDEUserParam();
            }
            case 33: {
                return et.getDEVersion();
            }
            case 34: {
                return et.getDGRowClassHelper();
            }
            case 35: {
                return et.getDGSUMMARYHeight();
            }
            case 36: {
                return et.getDLKHelper();
            }
            case 37: {
                return et.getDynamicInterval();
            }
            case 38: {
                return et.getEnableColPriv();
            }
            case 39: {
                return et.getEnableGlobalModel();
            }
            case 40: {
                return et.getExitingModel();
            }
            case 41: {
                return et.getExportIncEmpty();
            }
            case 42: {
                return et.getExTableName();
            }
            case 43: {
                return et.getGlobalModelObj();
            }
            case 44: {
                return et.getIndexMode();
            }
            case 45: {
                return et.getInfoField();
            }
            case 46: {
                return et.getInfoFormat();
            }
            case 47: {
                return et.getInheritMode();
            }
            case 48: {
                return et.getIsDGRowEdit();
            }
            case 49: {
                return et.getIsEnableAudit();
            }
            case 50: {
                return et.getIsEnableDP();
            }
            case 51: {
                return et.getIsIndexDE();
            }
            case 52: {
                return et.getIsLogicValid();
            }
            case 53: {
                return et.getISMULTIPRINT();
            }
            case 54: {
                return et.getISSupportFA();
            }
            case 55: {
                return et.getIsSystem();
            }
            case 56: {
                return et.getKeyParams();
            }
            case 57: {
                return et.getLicenseCode();
            }
            case 58: {
                return et.getLogAuditDetail();
            }
            case 59: {
                return et.getMemo();
            }
            case 60: {
                return et.getMinorFieldName();
            }
            case 61: {
                return et.getMinorFieldValue();
            }
            case 62: {
                return et.getMinorTableName();
            }
            case 63: {
                return et.getMutliMajor();
            }
            case 64: {
                return et.getNoDataInfo();
            }
            case 65: {
                return et.getPrintFunc();
            }
            case 66: {
                return et.getReserver();
            }
            case 67: {
                return et.getReserver2();
            }
            case 68: {
                return et.getRowAmout();
            }
            case 69: {
                return et.getRTInfo();
            }
            case 70: {
                return et.getSMALLICON();
            }
            case 71: {
                return et.getStorageType();
            }
            case 72: {
                return et.getTableName();
            }
            case 73: {
                return et.getTableSpace();
            }
            case 74: {
                return et.getTipsInfo();
            }
            case 75: {
                return et.getUpdateDate();
            }
            case 76: {
                return et.getUpdateMan();
            }
            case 77: {
                return et.getUserAction();
            }
            case 78: {
                return et.getValidFlag();
            }
            case 79: {
                return et.getVCFlag();
            }
            case 80: {
                return et.getVerCheckTimer();
            }
            case 81: {
                return et.getVerField();
            }
            case 82: {
                return et.getVerHelper();
            }
            case 83: {
                return et.getVersionCheck();
            }
            case 84: {
                return et.getViewName();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    public void set(String strParamName, Object objValue) throws Exception {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().set(strParamName, objValue);
            return;
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            super.set(strParamName, objValue);
            return;
        }
        DataEntityBase.set(this, index, objValue);
    }

    private static void set(DataEntityBase et, int index, Object obj) throws Exception {
        switch (index) {
            case 0: {
                et.setACEnableDP(DataObject.getIntegerValue(obj));
                return;
            }
            case 1: {
                et.setACExtInfo(DataObject.getStringValue(obj));
                return;
            }
            case 2: {
                et.setACInfoFormat(DataObject.getStringValue(obj));
                return;
            }
            case 3: {
                et.setACInfoParam(DataObject.getStringValue(obj));
                return;
            }
            case 4: {
                et.setACMaxCnt(DataObject.getIntegerValue(obj));
                return;
            }
            case 5: {
                et.setACObject(DataObject.getStringValue(obj));
                return;
            }
            case 6: {
                et.setACQueryModelId(DataObject.getStringValue(obj));
                return;
            }
            case 7: {
                et.setACQueryModelName(DataObject.getStringValue(obj));
                return;
            }
            case 8: {
                et.setACSortDir(DataObject.getStringValue(obj));
                return;
            }
            case 9: {
                et.setACSortField(DataObject.getStringValue(obj));
                return;
            }
            case 10: {
                et.setBigIcon(DataObject.getStringValue(obj));
                return;
            }
            case 11: {
                et.setConfigHelper(DataObject.getStringValue(obj));
                return;
            }
            case 12: {
                et.setCreateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 13: {
                et.setCreateMan(DataObject.getStringValue(obj));
                return;
            }
            case 14: {
                et.setDataAccObject(DataObject.getStringValue(obj));
                return;
            }
            case 15: {
                et.setDataChgLogMode(DataObject.getIntegerValue(obj));
                return;
            }
            case 16: {
                et.setDataCtrlInt(DataObject.getStringValue(obj));
                return;
            }
            case 17: {
                et.setDataCtrlObject(DataObject.getStringValue(obj));
                return;
            }
            case 18: {
                et.setDataNotifyHelper(DataObject.getStringValue(obj));
                return;
            }
            case 19: {
                et.setDBStorage(DataObject.getStringValue(obj));
                return;
            }
            case 20: {
                et.setDBVersion(DataObject.getIntegerValue(obj));
                return;
            }
            case 21: {
                et.setDEGroup(DataObject.getStringValue(obj));
                return;
            }
            case 22: {
                et.setDEHelper(DataObject.getStringValue(obj));
                return;
            }
            case 23: {
                et.setDEId(DataObject.getStringValue(obj));
                return;
            }
            case 24: {
                et.setDELogicName(DataObject.getStringValue(obj));
                return;
            }
            case 25: {
                et.setDEName(DataObject.getStringValue(obj));
                return;
            }
            case 26: {
                et.setDEObject(DataObject.getStringValue(obj));
                return;
            }
            case 27: {
                et.setDEOrder(DataObject.getIntegerValue(obj));
                return;
            }
            case 28: {
                et.setDEParam(DataObject.getStringValue(obj));
                return;
            }
            case 29: {
                et.setDER11DEId(DataObject.getStringValue(obj));
                return;
            }
            case 30: {
                et.setDER11DEName(DataObject.getStringValue(obj));
                return;
            }
            case 31: {
                et.setDEType(DataObject.getIntegerValue(obj));
                return;
            }
            case 32: {
                et.setDEUserParam(DataObject.getStringValue(obj));
                return;
            }
            case 33: {
                et.setDEVersion(DataObject.getIntegerValue(obj));
                return;
            }
            case 34: {
                et.setDGRowClassHelper(DataObject.getStringValue(obj));
                return;
            }
            case 35: {
                et.setDGSUMMARYHeight(DataObject.getIntegerValue(obj));
                return;
            }
            case 36: {
                et.setDLKHelper(DataObject.getStringValue(obj));
                return;
            }
            case 37: {
                et.setDynamicInterval(DataObject.getIntegerValue(obj));
                return;
            }
            case 38: {
                et.setEnableColPriv(DataObject.getIntegerValue(obj));
                return;
            }
            case 39: {
                et.setEnableGlobalModel(DataObject.getIntegerValue(obj));
                return;
            }
            case 40: {
                et.setExitingModel(DataObject.getIntegerValue(obj));
                return;
            }
            case 41: {
                et.setExportIncEmpty(DataObject.getIntegerValue(obj));
                return;
            }
            case 42: {
                et.setExTableName(DataObject.getStringValue(obj));
                return;
            }
            case 43: {
                et.setGlobalModelObj(DataObject.getStringValue(obj));
                return;
            }
            case 44: {
                et.setIndexMode(DataObject.getIntegerValue(obj));
                return;
            }
            case 45: {
                et.setInfoField(DataObject.getStringValue(obj));
                return;
            }
            case 46: {
                et.setInfoFormat(DataObject.getStringValue(obj));
                return;
            }
            case 47: {
                et.setInheritMode(DataObject.getIntegerValue(obj));
                return;
            }
            case 48: {
                et.setIsDGRowEdit(DataObject.getIntegerValue(obj));
                return;
            }
            case 49: {
                et.setIsEnableAudit(DataObject.getIntegerValue(obj));
                return;
            }
            case 50: {
                et.setIsEnableDP(DataObject.getIntegerValue(obj));
                return;
            }
            case 51: {
                et.setIsIndexDE(DataObject.getIntegerValue(obj));
                return;
            }
            case 52: {
                et.setIsLogicValid(DataObject.getIntegerValue(obj));
                return;
            }
            case 53: {
                et.setISMULTIPRINT(DataObject.getIntegerValue(obj));
                return;
            }
            case 54: {
                et.setISSupportFA(DataObject.getIntegerValue(obj));
                return;
            }
            case 55: {
                et.setIsSystem(DataObject.getIntegerValue(obj));
                return;
            }
            case 56: {
                et.setKeyParams(DataObject.getStringValue(obj));
                return;
            }
            case 57: {
                et.setLicenseCode(DataObject.getStringValue(obj));
                return;
            }
            case 58: {
                et.setLogAuditDetail(DataObject.getIntegerValue(obj));
                return;
            }
            case 59: {
                et.setMemo(DataObject.getStringValue(obj));
                return;
            }
            case 60: {
                et.setMinorFieldName(DataObject.getStringValue(obj));
                return;
            }
            case 61: {
                et.setMinorFieldValue(DataObject.getStringValue(obj));
                return;
            }
            case 62: {
                et.setMinorTableName(DataObject.getStringValue(obj));
                return;
            }
            case 63: {
                et.setMutliMajor(DataObject.getIntegerValue(obj));
                return;
            }
            case 64: {
                et.setNoDataInfo(DataObject.getIntegerValue(obj));
                return;
            }
            case 65: {
                et.setPrintFunc(DataObject.getStringValue(obj));
                return;
            }
            case 66: {
                et.setReserver(DataObject.getStringValue(obj));
                return;
            }
            case 67: {
                et.setReserver2(DataObject.getStringValue(obj));
                return;
            }
            case 68: {
                et.setRowAmout(DataObject.getIntegerValue(obj));
                return;
            }
            case 69: {
                et.setRTInfo(DataObject.getStringValue(obj));
                return;
            }
            case 70: {
                et.setSMALLICON(DataObject.getStringValue(obj));
                return;
            }
            case 71: {
                et.setStorageType(DataObject.getStringValue(obj));
                return;
            }
            case 72: {
                et.setTableName(DataObject.getStringValue(obj));
                return;
            }
            case 73: {
                et.setTableSpace(DataObject.getStringValue(obj));
                return;
            }
            case 74: {
                et.setTipsInfo(DataObject.getStringValue(obj));
                return;
            }
            case 75: {
                et.setUpdateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 76: {
                et.setUpdateMan(DataObject.getStringValue(obj));
                return;
            }
            case 77: {
                et.setUserAction(DataObject.getIntegerValue(obj));
                return;
            }
            case 78: {
                et.setValidFlag(DataObject.getIntegerValue(obj));
                return;
            }
            case 79: {
                et.setVCFlag(DataObject.getIntegerValue(obj));
                return;
            }
            case 80: {
                et.setVerCheckTimer(DataObject.getIntegerValue(obj));
                return;
            }
            case 81: {
                et.setVerField(DataObject.getStringValue(obj));
                return;
            }
            case 82: {
                et.setVerHelper(DataObject.getStringValue(obj));
                return;
            }
            case 83: {
                et.setVersionCheck(DataObject.getIntegerValue(obj));
                return;
            }
            case 84: {
                et.setViewName(DataObject.getStringValue(obj));
                return;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    public boolean isNull(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNull(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.isNull(strParamName);
        }
        return DataEntityBase.isNull(this, index);
    }

    private static boolean isNull(DataEntityBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getACEnableDP() == null;
            }
            case 1: {
                return et.getACExtInfo() == null;
            }
            case 2: {
                return et.getACInfoFormat() == null;
            }
            case 3: {
                return et.getACInfoParam() == null;
            }
            case 4: {
                return et.getACMaxCnt() == null;
            }
            case 5: {
                return et.getACObject() == null;
            }
            case 6: {
                return et.getACQueryModelId() == null;
            }
            case 7: {
                return et.getACQueryModelName() == null;
            }
            case 8: {
                return et.getACSortDir() == null;
            }
            case 9: {
                return et.getACSortField() == null;
            }
            case 10: {
                return et.getBigIcon() == null;
            }
            case 11: {
                return et.getConfigHelper() == null;
            }
            case 12: {
                return et.getCreateDate() == null;
            }
            case 13: {
                return et.getCreateMan() == null;
            }
            case 14: {
                return et.getDataAccObject() == null;
            }
            case 15: {
                return et.getDataChgLogMode() == null;
            }
            case 16: {
                return et.getDataCtrlInt() == null;
            }
            case 17: {
                return et.getDataCtrlObject() == null;
            }
            case 18: {
                return et.getDataNotifyHelper() == null;
            }
            case 19: {
                return et.getDBStorage() == null;
            }
            case 20: {
                return et.getDBVersion() == null;
            }
            case 21: {
                return et.getDEGroup() == null;
            }
            case 22: {
                return et.getDEHelper() == null;
            }
            case 23: {
                return et.getDEId() == null;
            }
            case 24: {
                return et.getDELogicName() == null;
            }
            case 25: {
                return et.getDEName() == null;
            }
            case 26: {
                return et.getDEObject() == null;
            }
            case 27: {
                return et.getDEOrder() == null;
            }
            case 28: {
                return et.getDEParam() == null;
            }
            case 29: {
                return et.getDER11DEId() == null;
            }
            case 30: {
                return et.getDER11DEName() == null;
            }
            case 31: {
                return et.getDEType() == null;
            }
            case 32: {
                return et.getDEUserParam() == null;
            }
            case 33: {
                return et.getDEVersion() == null;
            }
            case 34: {
                return et.getDGRowClassHelper() == null;
            }
            case 35: {
                return et.getDGSUMMARYHeight() == null;
            }
            case 36: {
                return et.getDLKHelper() == null;
            }
            case 37: {
                return et.getDynamicInterval() == null;
            }
            case 38: {
                return et.getEnableColPriv() == null;
            }
            case 39: {
                return et.getEnableGlobalModel() == null;
            }
            case 40: {
                return et.getExitingModel() == null;
            }
            case 41: {
                return et.getExportIncEmpty() == null;
            }
            case 42: {
                return et.getExTableName() == null;
            }
            case 43: {
                return et.getGlobalModelObj() == null;
            }
            case 44: {
                return et.getIndexMode() == null;
            }
            case 45: {
                return et.getInfoField() == null;
            }
            case 46: {
                return et.getInfoFormat() == null;
            }
            case 47: {
                return et.getInheritMode() == null;
            }
            case 48: {
                return et.getIsDGRowEdit() == null;
            }
            case 49: {
                return et.getIsEnableAudit() == null;
            }
            case 50: {
                return et.getIsEnableDP() == null;
            }
            case 51: {
                return et.getIsIndexDE() == null;
            }
            case 52: {
                return et.getIsLogicValid() == null;
            }
            case 53: {
                return et.getISMULTIPRINT() == null;
            }
            case 54: {
                return et.getISSupportFA() == null;
            }
            case 55: {
                return et.getIsSystem() == null;
            }
            case 56: {
                return et.getKeyParams() == null;
            }
            case 57: {
                return et.getLicenseCode() == null;
            }
            case 58: {
                return et.getLogAuditDetail() == null;
            }
            case 59: {
                return et.getMemo() == null;
            }
            case 60: {
                return et.getMinorFieldName() == null;
            }
            case 61: {
                return et.getMinorFieldValue() == null;
            }
            case 62: {
                return et.getMinorTableName() == null;
            }
            case 63: {
                return et.getMutliMajor() == null;
            }
            case 64: {
                return et.getNoDataInfo() == null;
            }
            case 65: {
                return et.getPrintFunc() == null;
            }
            case 66: {
                return et.getReserver() == null;
            }
            case 67: {
                return et.getReserver2() == null;
            }
            case 68: {
                return et.getRowAmout() == null;
            }
            case 69: {
                return et.getRTInfo() == null;
            }
            case 70: {
                return et.getSMALLICON() == null;
            }
            case 71: {
                return et.getStorageType() == null;
            }
            case 72: {
                return et.getTableName() == null;
            }
            case 73: {
                return et.getTableSpace() == null;
            }
            case 74: {
                return et.getTipsInfo() == null;
            }
            case 75: {
                return et.getUpdateDate() == null;
            }
            case 76: {
                return et.getUpdateMan() == null;
            }
            case 77: {
                return et.getUserAction() == null;
            }
            case 78: {
                return et.getValidFlag() == null;
            }
            case 79: {
                return et.getVCFlag() == null;
            }
            case 80: {
                return et.getVerCheckTimer() == null;
            }
            case 81: {
                return et.getVerField() == null;
            }
            case 82: {
                return et.getVerHelper() == null;
            }
            case 83: {
                return et.getVersionCheck() == null;
            }
            case 84: {
                return et.getViewName() == null;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    public boolean contains(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().contains(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.contains(strParamName);
        }
        return DataEntityBase.contains(this, index);
    }

    private static boolean contains(DataEntityBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isACEnableDPDirty();
            }
            case 1: {
                return et.isACExtInfoDirty();
            }
            case 2: {
                return et.isACInfoFormatDirty();
            }
            case 3: {
                return et.isACInfoParamDirty();
            }
            case 4: {
                return et.isACMaxCntDirty();
            }
            case 5: {
                return et.isACObjectDirty();
            }
            case 6: {
                return et.isACQueryModelIdDirty();
            }
            case 7: {
                return et.isACQueryModelNameDirty();
            }
            case 8: {
                return et.isACSortDirDirty();
            }
            case 9: {
                return et.isACSortFieldDirty();
            }
            case 10: {
                return et.isBigIconDirty();
            }
            case 11: {
                return et.isConfigHelperDirty();
            }
            case 12: {
                return et.isCreateDateDirty();
            }
            case 13: {
                return et.isCreateManDirty();
            }
            case 14: {
                return et.isDataAccObjectDirty();
            }
            case 15: {
                return et.isDataChgLogModeDirty();
            }
            case 16: {
                return et.isDataCtrlIntDirty();
            }
            case 17: {
                return et.isDataCtrlObjectDirty();
            }
            case 18: {
                return et.isDataNotifyHelperDirty();
            }
            case 19: {
                return et.isDBStorageDirty();
            }
            case 20: {
                return et.isDBVersionDirty();
            }
            case 21: {
                return et.isDEGroupDirty();
            }
            case 22: {
                return et.isDEHelperDirty();
            }
            case 23: {
                return et.isDEIdDirty();
            }
            case 24: {
                return et.isDELogicNameDirty();
            }
            case 25: {
                return et.isDENameDirty();
            }
            case 26: {
                return et.isDEObjectDirty();
            }
            case 27: {
                return et.isDEOrderDirty();
            }
            case 28: {
                return et.isDEParamDirty();
            }
            case 29: {
                return et.isDER11DEIdDirty();
            }
            case 30: {
                return et.isDER11DENameDirty();
            }
            case 31: {
                return et.isDETypeDirty();
            }
            case 32: {
                return et.isDEUserParamDirty();
            }
            case 33: {
                return et.isDEVersionDirty();
            }
            case 34: {
                return et.isDGRowClassHelperDirty();
            }
            case 35: {
                return et.isDGSUMMARYHeightDirty();
            }
            case 36: {
                return et.isDLKHelperDirty();
            }
            case 37: {
                return et.isDynamicIntervalDirty();
            }
            case 38: {
                return et.isEnableColPrivDirty();
            }
            case 39: {
                return et.isEnableGlobalModelDirty();
            }
            case 40: {
                return et.isExitingModelDirty();
            }
            case 41: {
                return et.isExportIncEmptyDirty();
            }
            case 42: {
                return et.isExTableNameDirty();
            }
            case 43: {
                return et.isGlobalModelObjDirty();
            }
            case 44: {
                return et.isIndexModeDirty();
            }
            case 45: {
                return et.isInfoFieldDirty();
            }
            case 46: {
                return et.isInfoFormatDirty();
            }
            case 47: {
                return et.isInheritModeDirty();
            }
            case 48: {
                return et.isIsDGRowEditDirty();
            }
            case 49: {
                return et.isIsEnableAuditDirty();
            }
            case 50: {
                return et.isIsEnableDPDirty();
            }
            case 51: {
                return et.isIsIndexDEDirty();
            }
            case 52: {
                return et.isIsLogicValidDirty();
            }
            case 53: {
                return et.isISMULTIPRINTDirty();
            }
            case 54: {
                return et.isISSupportFADirty();
            }
            case 55: {
                return et.isIsSystemDirty();
            }
            case 56: {
                return et.isKeyParamsDirty();
            }
            case 57: {
                return et.isLicenseCodeDirty();
            }
            case 58: {
                return et.isLogAuditDetailDirty();
            }
            case 59: {
                return et.isMemoDirty();
            }
            case 60: {
                return et.isMinorFieldNameDirty();
            }
            case 61: {
                return et.isMinorFieldValueDirty();
            }
            case 62: {
                return et.isMinorTableNameDirty();
            }
            case 63: {
                return et.isMutliMajorDirty();
            }
            case 64: {
                return et.isNoDataInfoDirty();
            }
            case 65: {
                return et.isPrintFuncDirty();
            }
            case 66: {
                return et.isReserverDirty();
            }
            case 67: {
                return et.isReserver2Dirty();
            }
            case 68: {
                return et.isRowAmoutDirty();
            }
            case 69: {
                return et.isRTInfoDirty();
            }
            case 70: {
                return et.isSMALLICONDirty();
            }
            case 71: {
                return et.isStorageTypeDirty();
            }
            case 72: {
                return et.isTableNameDirty();
            }
            case 73: {
                return et.isTableSpaceDirty();
            }
            case 74: {
                return et.isTipsInfoDirty();
            }
            case 75: {
                return et.isUpdateDateDirty();
            }
            case 76: {
                return et.isUpdateManDirty();
            }
            case 77: {
                return et.isUserActionDirty();
            }
            case 78: {
                return et.isValidFlagDirty();
            }
            case 79: {
                return et.isVCFlagDirty();
            }
            case 80: {
                return et.isVerCheckTimerDirty();
            }
            case 81: {
                return et.isVerFieldDirty();
            }
            case 82: {
                return et.isVerHelperDirty();
            }
            case 83: {
                return et.isVersionCheckDirty();
            }
            case 84: {
                return et.isViewNameDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        DataEntityBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(DataEntityBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getACEnableDP() != null) {
            JSONObjectHelper.put(json, "acenabledp", DataEntityBase.getJSONValue(et.getACEnableDP()), false);
        }
        if (bIncEmpty || et.getACExtInfo() != null) {
            JSONObjectHelper.put(json, "acextinfo", DataEntityBase.getJSONValue(et.getACExtInfo()), false);
        }
        if (bIncEmpty || et.getACInfoFormat() != null) {
            JSONObjectHelper.put(json, "acinfoformat", DataEntityBase.getJSONValue(et.getACInfoFormat()), false);
        }
        if (bIncEmpty || et.getACInfoParam() != null) {
            JSONObjectHelper.put(json, "acinfoparam", DataEntityBase.getJSONValue(et.getACInfoParam()), false);
        }
        if (bIncEmpty || et.getACMaxCnt() != null) {
            JSONObjectHelper.put(json, "acmaxcnt", DataEntityBase.getJSONValue(et.getACMaxCnt()), false);
        }
        if (bIncEmpty || et.getACObject() != null) {
            JSONObjectHelper.put(json, "acobject", DataEntityBase.getJSONValue(et.getACObject()), false);
        }
        if (bIncEmpty || et.getACQueryModelId() != null) {
            JSONObjectHelper.put(json, "acquerymodelid", DataEntityBase.getJSONValue(et.getACQueryModelId()), false);
        }
        if (bIncEmpty || et.getACQueryModelName() != null) {
            JSONObjectHelper.put(json, "acquerymodelname", DataEntityBase.getJSONValue(et.getACQueryModelName()), false);
        }
        if (bIncEmpty || et.getACSortDir() != null) {
            JSONObjectHelper.put(json, "acsortdir", DataEntityBase.getJSONValue(et.getACSortDir()), false);
        }
        if (bIncEmpty || et.getACSortField() != null) {
            JSONObjectHelper.put(json, "acsortfield", DataEntityBase.getJSONValue(et.getACSortField()), false);
        }
        if (bIncEmpty || et.getBigIcon() != null) {
            JSONObjectHelper.put(json, "bigicon", DataEntityBase.getJSONValue(et.getBigIcon()), false);
        }
        if (bIncEmpty || et.getConfigHelper() != null) {
            JSONObjectHelper.put(json, "confighelper", DataEntityBase.getJSONValue(et.getConfigHelper()), false);
        }
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", DataEntityBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", DataEntityBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getDataAccObject() != null) {
            JSONObjectHelper.put(json, "dataaccobject", DataEntityBase.getJSONValue(et.getDataAccObject()), false);
        }
        if (bIncEmpty || et.getDataChgLogMode() != null) {
            JSONObjectHelper.put(json, "datachglogmode", DataEntityBase.getJSONValue(et.getDataChgLogMode()), false);
        }
        if (bIncEmpty || et.getDataCtrlInt() != null) {
            JSONObjectHelper.put(json, "datactrlint", DataEntityBase.getJSONValue(et.getDataCtrlInt()), false);
        }
        if (bIncEmpty || et.getDataCtrlObject() != null) {
            JSONObjectHelper.put(json, "datactrlobject", DataEntityBase.getJSONValue(et.getDataCtrlObject()), false);
        }
        if (bIncEmpty || et.getDataNotifyHelper() != null) {
            JSONObjectHelper.put(json, "datanotifyhelper", DataEntityBase.getJSONValue(et.getDataNotifyHelper()), false);
        }
        if (bIncEmpty || et.getDBStorage() != null) {
            JSONObjectHelper.put(json, "dbstorage", DataEntityBase.getJSONValue(et.getDBStorage()), false);
        }
        if (bIncEmpty || et.getDBVersion() != null) {
            JSONObjectHelper.put(json, "dbversion", DataEntityBase.getJSONValue(et.getDBVersion()), false);
        }
        if (bIncEmpty || et.getDEGroup() != null) {
            JSONObjectHelper.put(json, "degroup", DataEntityBase.getJSONValue(et.getDEGroup()), false);
        }
        if (bIncEmpty || et.getDEHelper() != null) {
            JSONObjectHelper.put(json, "dehelper", DataEntityBase.getJSONValue(et.getDEHelper()), false);
        }
        if (bIncEmpty || et.getDEId() != null) {
            JSONObjectHelper.put(json, "deid", DataEntityBase.getJSONValue(et.getDEId()), false);
        }
        if (bIncEmpty || et.getDELogicName() != null) {
            JSONObjectHelper.put(json, "delogicname", DataEntityBase.getJSONValue(et.getDELogicName()), false);
        }
        if (bIncEmpty || et.getDEName() != null) {
            JSONObjectHelper.put(json, "dename", DataEntityBase.getJSONValue(et.getDEName()), false);
        }
        if (bIncEmpty || et.getDEObject() != null) {
            JSONObjectHelper.put(json, "deobject", DataEntityBase.getJSONValue(et.getDEObject()), false);
        }
        if (bIncEmpty || et.getDEOrder() != null) {
            JSONObjectHelper.put(json, "deorder", DataEntityBase.getJSONValue(et.getDEOrder()), false);
        }
        if (bIncEmpty || et.getDEParam() != null) {
            JSONObjectHelper.put(json, "deparam", DataEntityBase.getJSONValue(et.getDEParam()), false);
        }
        if (bIncEmpty || et.getDER11DEId() != null) {
            JSONObjectHelper.put(json, "der11deid", DataEntityBase.getJSONValue(et.getDER11DEId()), false);
        }
        if (bIncEmpty || et.getDER11DEName() != null) {
            JSONObjectHelper.put(json, "der11dename", DataEntityBase.getJSONValue(et.getDER11DEName()), false);
        }
        if (bIncEmpty || et.getDEType() != null) {
            JSONObjectHelper.put(json, "detype", DataEntityBase.getJSONValue(et.getDEType()), false);
        }
        if (bIncEmpty || et.getDEUserParam() != null) {
            JSONObjectHelper.put(json, "deuserparam", DataEntityBase.getJSONValue(et.getDEUserParam()), false);
        }
        if (bIncEmpty || et.getDEVersion() != null) {
            JSONObjectHelper.put(json, "deversion", DataEntityBase.getJSONValue(et.getDEVersion()), false);
        }
        if (bIncEmpty || et.getDGRowClassHelper() != null) {
            JSONObjectHelper.put(json, "dgrowclasshelper", DataEntityBase.getJSONValue(et.getDGRowClassHelper()), false);
        }
        if (bIncEmpty || et.getDGSUMMARYHeight() != null) {
            JSONObjectHelper.put(json, "dgsummaryheight", DataEntityBase.getJSONValue(et.getDGSUMMARYHeight()), false);
        }
        if (bIncEmpty || et.getDLKHelper() != null) {
            JSONObjectHelper.put(json, "dlkhelper", DataEntityBase.getJSONValue(et.getDLKHelper()), false);
        }
        if (bIncEmpty || et.getDynamicInterval() != null) {
            JSONObjectHelper.put(json, "dynamicinterval", DataEntityBase.getJSONValue(et.getDynamicInterval()), false);
        }
        if (bIncEmpty || et.getEnableColPriv() != null) {
            JSONObjectHelper.put(json, "enablecolpriv", DataEntityBase.getJSONValue(et.getEnableColPriv()), false);
        }
        if (bIncEmpty || et.getEnableGlobalModel() != null) {
            JSONObjectHelper.put(json, "enableglobalmodel", DataEntityBase.getJSONValue(et.getEnableGlobalModel()), false);
        }
        if (bIncEmpty || et.getExitingModel() != null) {
            JSONObjectHelper.put(json, "exitingmodel", DataEntityBase.getJSONValue(et.getExitingModel()), false);
        }
        if (bIncEmpty || et.getExportIncEmpty() != null) {
            JSONObjectHelper.put(json, "exportincempty", DataEntityBase.getJSONValue(et.getExportIncEmpty()), false);
        }
        if (bIncEmpty || et.getExTableName() != null) {
            JSONObjectHelper.put(json, "extablename", DataEntityBase.getJSONValue(et.getExTableName()), false);
        }
        if (bIncEmpty || et.getGlobalModelObj() != null) {
            JSONObjectHelper.put(json, "globalmodelobj", DataEntityBase.getJSONValue(et.getGlobalModelObj()), false);
        }
        if (bIncEmpty || et.getIndexMode() != null) {
            JSONObjectHelper.put(json, "indexmode", DataEntityBase.getJSONValue(et.getIndexMode()), false);
        }
        if (bIncEmpty || et.getInfoField() != null) {
            JSONObjectHelper.put(json, "infofield", DataEntityBase.getJSONValue(et.getInfoField()), false);
        }
        if (bIncEmpty || et.getInfoFormat() != null) {
            JSONObjectHelper.put(json, "infoformat", DataEntityBase.getJSONValue(et.getInfoFormat()), false);
        }
        if (bIncEmpty || et.getInheritMode() != null) {
            JSONObjectHelper.put(json, "inheritmode", DataEntityBase.getJSONValue(et.getInheritMode()), false);
        }
        if (bIncEmpty || et.getIsDGRowEdit() != null) {
            JSONObjectHelper.put(json, "isdgrowedit", DataEntityBase.getJSONValue(et.getIsDGRowEdit()), false);
        }
        if (bIncEmpty || et.getIsEnableAudit() != null) {
            JSONObjectHelper.put(json, "isenableaudit", DataEntityBase.getJSONValue(et.getIsEnableAudit()), false);
        }
        if (bIncEmpty || et.getIsEnableDP() != null) {
            JSONObjectHelper.put(json, "isenabledp", DataEntityBase.getJSONValue(et.getIsEnableDP()), false);
        }
        if (bIncEmpty || et.getIsIndexDE() != null) {
            JSONObjectHelper.put(json, "isindexde", DataEntityBase.getJSONValue(et.getIsIndexDE()), false);
        }
        if (bIncEmpty || et.getIsLogicValid() != null) {
            JSONObjectHelper.put(json, "islogicvalid", DataEntityBase.getJSONValue(et.getIsLogicValid()), false);
        }
        if (bIncEmpty || et.getISMULTIPRINT() != null) {
            JSONObjectHelper.put(json, "ismultiprint", DataEntityBase.getJSONValue(et.getISMULTIPRINT()), false);
        }
        if (bIncEmpty || et.getISSupportFA() != null) {
            JSONObjectHelper.put(json, "issupportfa", DataEntityBase.getJSONValue(et.getISSupportFA()), false);
        }
        if (bIncEmpty || et.getIsSystem() != null) {
            JSONObjectHelper.put(json, "issystem", DataEntityBase.getJSONValue(et.getIsSystem()), false);
        }
        if (bIncEmpty || et.getKeyParams() != null) {
            JSONObjectHelper.put(json, "keyparams", DataEntityBase.getJSONValue(et.getKeyParams()), false);
        }
        if (bIncEmpty || et.getLicenseCode() != null) {
            JSONObjectHelper.put(json, "licensecode", DataEntityBase.getJSONValue(et.getLicenseCode()), false);
        }
        if (bIncEmpty || et.getLogAuditDetail() != null) {
            JSONObjectHelper.put(json, "logauditdetail", DataEntityBase.getJSONValue(et.getLogAuditDetail()), false);
        }
        if (bIncEmpty || et.getMemo() != null) {
            JSONObjectHelper.put(json, "memo", DataEntityBase.getJSONValue(et.getMemo()), false);
        }
        if (bIncEmpty || et.getMinorFieldName() != null) {
            JSONObjectHelper.put(json, "minorfieldname", DataEntityBase.getJSONValue(et.getMinorFieldName()), false);
        }
        if (bIncEmpty || et.getMinorFieldValue() != null) {
            JSONObjectHelper.put(json, "minorfieldvalue", DataEntityBase.getJSONValue(et.getMinorFieldValue()), false);
        }
        if (bIncEmpty || et.getMinorTableName() != null) {
            JSONObjectHelper.put(json, "minortablename", DataEntityBase.getJSONValue(et.getMinorTableName()), false);
        }
        if (bIncEmpty || et.getMutliMajor() != null) {
            JSONObjectHelper.put(json, "multimajor", DataEntityBase.getJSONValue(et.getMutliMajor()), false);
        }
        if (bIncEmpty || et.getNoDataInfo() != null) {
            JSONObjectHelper.put(json, "nodatainfo", DataEntityBase.getJSONValue(et.getNoDataInfo()), false);
        }
        if (bIncEmpty || et.getPrintFunc() != null) {
            JSONObjectHelper.put(json, "printfunc", DataEntityBase.getJSONValue(et.getPrintFunc()), false);
        }
        if (bIncEmpty || et.getReserver() != null) {
            JSONObjectHelper.put(json, "reserver", DataEntityBase.getJSONValue(et.getReserver()), false);
        }
        if (bIncEmpty || et.getReserver2() != null) {
            JSONObjectHelper.put(json, "reserver2", DataEntityBase.getJSONValue(et.getReserver2()), false);
        }
        if (bIncEmpty || et.getRowAmout() != null) {
            JSONObjectHelper.put(json, "rowamount", DataEntityBase.getJSONValue(et.getRowAmout()), false);
        }
        if (bIncEmpty || et.getRTInfo() != null) {
            JSONObjectHelper.put(json, "rtinfo", DataEntityBase.getJSONValue(et.getRTInfo()), false);
        }
        if (bIncEmpty || et.getSMALLICON() != null) {
            JSONObjectHelper.put(json, "smallicon", DataEntityBase.getJSONValue(et.getSMALLICON()), false);
        }
        if (bIncEmpty || et.getStorageType() != null) {
            JSONObjectHelper.put(json, "storagetype", DataEntityBase.getJSONValue(et.getStorageType()), false);
        }
        if (bIncEmpty || et.getTableName() != null) {
            JSONObjectHelper.put(json, "tablename", DataEntityBase.getJSONValue(et.getTableName()), false);
        }
        if (bIncEmpty || et.getTableSpace() != null) {
            JSONObjectHelper.put(json, "tablespace", DataEntityBase.getJSONValue(et.getTableSpace()), false);
        }
        if (bIncEmpty || et.getTipsInfo() != null) {
            JSONObjectHelper.put(json, "tipsinfo", DataEntityBase.getJSONValue(et.getTipsInfo()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", DataEntityBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", DataEntityBase.getJSONValue(et.getUpdateMan()), false);
        }
        if (bIncEmpty || et.getUserAction() != null) {
            JSONObjectHelper.put(json, "useraction", DataEntityBase.getJSONValue(et.getUserAction()), false);
        }
        if (bIncEmpty || et.getValidFlag() != null) {
            JSONObjectHelper.put(json, "validflag", DataEntityBase.getJSONValue(et.getValidFlag()), false);
        }
        if (bIncEmpty || et.getVCFlag() != null) {
            JSONObjectHelper.put(json, "vcflag", DataEntityBase.getJSONValue(et.getVCFlag()), false);
        }
        if (bIncEmpty || et.getVerCheckTimer() != null) {
            JSONObjectHelper.put(json, "verchecktimer", DataEntityBase.getJSONValue(et.getVerCheckTimer()), false);
        }
        if (bIncEmpty || et.getVerField() != null) {
            JSONObjectHelper.put(json, "verfield", DataEntityBase.getJSONValue(et.getVerField()), false);
        }
        if (bIncEmpty || et.getVerHelper() != null) {
            JSONObjectHelper.put(json, "verhelper", DataEntityBase.getJSONValue(et.getVerHelper()), false);
        }
        if (bIncEmpty || et.getVersionCheck() != null) {
            JSONObjectHelper.put(json, "versioncheck", DataEntityBase.getJSONValue(et.getVersionCheck()), false);
        }
        if (bIncEmpty || et.getViewName() != null) {
            JSONObjectHelper.put(json, "viewname", DataEntityBase.getJSONValue(et.getViewName()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        DataEntityBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(DataEntityBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getACEnableDP() != null) {
            obj = et.getACEnableDP();
            node.setAttribute(FIELD_ACENABLEDP, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getACExtInfo() != null) {
            obj = et.getACExtInfo();
            node.setAttribute(FIELD_ACEXTINFO, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getACInfoFormat() != null) {
            obj = et.getACInfoFormat();
            node.setAttribute(FIELD_ACINFOFORMAT, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getACInfoParam() != null) {
            obj = et.getACInfoParam();
            node.setAttribute(FIELD_ACINFOPARAM, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getACMaxCnt() != null) {
            obj = et.getACMaxCnt();
            node.setAttribute(FIELD_ACMAXCNT, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getACObject() != null) {
            obj = et.getACObject();
            node.setAttribute(FIELD_ACOBJECT, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getACQueryModelId() != null) {
            obj = et.getACQueryModelId();
            node.setAttribute(FIELD_ACQUERYMODELID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getACQueryModelName() != null) {
            obj = et.getACQueryModelName();
            node.setAttribute(FIELD_ACQUERYMODELNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getACSortDir() != null) {
            obj = et.getACSortDir();
            node.setAttribute(FIELD_ACSORTDIR, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getACSortField() != null) {
            obj = et.getACSortField();
            node.setAttribute(FIELD_ACSORTFIELD, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getBigIcon() != null) {
            obj = et.getBigIcon();
            node.setAttribute(FIELD_BIGICON, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getConfigHelper() != null) {
            obj = et.getConfigHelper();
            node.setAttribute(FIELD_CONFIGHELPER, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getCreateDate() != null) {
            obj = et.getCreateDate();
            node.setAttribute(FIELD_CREATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            obj = et.getCreateMan();
            node.setAttribute(FIELD_CREATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDataAccObject() != null) {
            obj = et.getDataAccObject();
            node.setAttribute(FIELD_DATAACCOBJECT, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDataChgLogMode() != null) {
            obj = et.getDataChgLogMode();
            node.setAttribute(FIELD_DATACHGLOGMODE, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getDataCtrlInt() != null) {
            obj = et.getDataCtrlInt();
            node.setAttribute(FIELD_DATACTRLINT, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDataCtrlObject() != null) {
            obj = et.getDataCtrlObject();
            node.setAttribute(FIELD_DATACTRLOBJECT, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDataNotifyHelper() != null) {
            obj = et.getDataNotifyHelper();
            node.setAttribute(FIELD_DATANOTIFYHELPER, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDBStorage() != null) {
            obj = et.getDBStorage();
            node.setAttribute(FIELD_DBSTORAGE, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDBVersion() != null) {
            obj = et.getDBVersion();
            node.setAttribute(FIELD_DBVERSION, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getDEGroup() != null) {
            obj = et.getDEGroup();
            node.setAttribute(FIELD_DEGROUP, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDEHelper() != null) {
            obj = et.getDEHelper();
            node.setAttribute(FIELD_DEHELPER, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDEId() != null) {
            obj = et.getDEId();
            node.setAttribute(FIELD_DEID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDELogicName() != null) {
            obj = et.getDELogicName();
            node.setAttribute(FIELD_DELOGICNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDEName() != null) {
            obj = et.getDEName();
            node.setAttribute(FIELD_DENAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDEObject() != null) {
            obj = et.getDEObject();
            node.setAttribute(FIELD_DEOBJECT, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDEOrder() != null) {
            obj = et.getDEOrder();
            node.setAttribute(FIELD_DEORDER, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getDEParam() != null) {
            obj = et.getDEParam();
            node.setAttribute(FIELD_DEPARAM, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDER11DEId() != null) {
            obj = et.getDER11DEId();
            node.setAttribute(FIELD_DER11DEID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDER11DEName() != null) {
            obj = et.getDER11DEName();
            node.setAttribute(FIELD_DER11DENAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDEType() != null) {
            obj = et.getDEType();
            node.setAttribute(FIELD_DETYPE, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getDEUserParam() != null) {
            obj = et.getDEUserParam();
            node.setAttribute(FIELD_DEUSERPARAM, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDEVersion() != null) {
            obj = et.getDEVersion();
            node.setAttribute(FIELD_DEVERSION, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getDGRowClassHelper() != null) {
            obj = et.getDGRowClassHelper();
            node.setAttribute(FIELD_DGROWCLASSHELPER, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDGSUMMARYHeight() != null) {
            obj = et.getDGSUMMARYHeight();
            node.setAttribute(FIELD_DGSUMMARYHEIGHT, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getDLKHelper() != null) {
            obj = et.getDLKHelper();
            node.setAttribute(FIELD_DLKHELPER, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDynamicInterval() != null) {
            obj = et.getDynamicInterval();
            node.setAttribute(FIELD_DYNAMICINTERVAL, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getEnableColPriv() != null) {
            obj = et.getEnableColPriv();
            node.setAttribute(FIELD_ENABLECOLPRIV, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getEnableGlobalModel() != null) {
            obj = et.getEnableGlobalModel();
            node.setAttribute(FIELD_ENABLEGLOBALMODEL, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getExitingModel() != null) {
            obj = et.getExitingModel();
            node.setAttribute(FIELD_EXITINGMODEL, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getExportIncEmpty() != null) {
            obj = et.getExportIncEmpty();
            node.setAttribute(FIELD_EXPORTINCEMPTY, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getExTableName() != null) {
            obj = et.getExTableName();
            node.setAttribute(FIELD_EXTABLENAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getGlobalModelObj() != null) {
            obj = et.getGlobalModelObj();
            node.setAttribute(FIELD_GLOBALMODELOBJ, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getIndexMode() != null) {
            obj = et.getIndexMode();
            node.setAttribute(FIELD_INDEXMODE, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getInfoField() != null) {
            obj = et.getInfoField();
            node.setAttribute(FIELD_INFOFIELD, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getInfoFormat() != null) {
            obj = et.getInfoFormat();
            node.setAttribute(FIELD_INFOFORMAT, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getInheritMode() != null) {
            obj = et.getInheritMode();
            node.setAttribute(FIELD_INHERITMODE, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getIsDGRowEdit() != null) {
            obj = et.getIsDGRowEdit();
            node.setAttribute(FIELD_ISDGROWEDIT, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getIsEnableAudit() != null) {
            obj = et.getIsEnableAudit();
            node.setAttribute(FIELD_ISENABLEAUDIT, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getIsEnableDP() != null) {
            obj = et.getIsEnableDP();
            node.setAttribute(FIELD_ISENABLEDP, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getIsIndexDE() != null) {
            obj = et.getIsIndexDE();
            node.setAttribute(FIELD_ISINDEXDE, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getIsLogicValid() != null) {
            obj = et.getIsLogicValid();
            node.setAttribute(FIELD_ISLOGICVALID, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getISMULTIPRINT() != null) {
            obj = et.getISMULTIPRINT();
            node.setAttribute(FIELD_ISMULTIPRINT, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getISSupportFA() != null) {
            obj = et.getISSupportFA();
            node.setAttribute(FIELD_ISSUPPORTFA, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getIsSystem() != null) {
            obj = et.getIsSystem();
            node.setAttribute(FIELD_ISSYSTEM, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getKeyParams() != null) {
            obj = et.getKeyParams();
            node.setAttribute(FIELD_KEYPARAMS, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getLicenseCode() != null) {
            obj = et.getLicenseCode();
            node.setAttribute(FIELD_LICENSECODE, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getLogAuditDetail() != null) {
            obj = et.getLogAuditDetail();
            node.setAttribute(FIELD_LOGAUDITDETAIL, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getMemo() != null) {
            obj = et.getMemo();
            node.setAttribute(FIELD_MEMO, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getMinorFieldName() != null) {
            obj = et.getMinorFieldName();
            node.setAttribute(FIELD_MINORFIELDNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getMinorFieldValue() != null) {
            obj = et.getMinorFieldValue();
            node.setAttribute(FIELD_MINORFIELDVALUE, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getMinorTableName() != null) {
            obj = et.getMinorTableName();
            node.setAttribute(FIELD_MINORTABLENAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getMutliMajor() != null) {
            obj = et.getMutliMajor();
            node.setAttribute("MUTLIMAJOR", obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getNoDataInfo() != null) {
            obj = et.getNoDataInfo();
            node.setAttribute(FIELD_NODATAINFO, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getPrintFunc() != null) {
            obj = et.getPrintFunc();
            node.setAttribute(FIELD_PRINTFUNC, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getReserver() != null) {
            obj = et.getReserver();
            node.setAttribute(FIELD_RESERVER, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getReserver2() != null) {
            obj = et.getReserver2();
            node.setAttribute(FIELD_RESERVER2, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getRowAmout() != null) {
            obj = et.getRowAmout();
            node.setAttribute("ROWAMOUT", obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getRTInfo() != null) {
            obj = et.getRTInfo();
            node.setAttribute(FIELD_RTINFO, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getSMALLICON() != null) {
            obj = et.getSMALLICON();
            node.setAttribute(FIELD_SMALLICON, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getStorageType() != null) {
            obj = et.getStorageType();
            node.setAttribute(FIELD_STORAGETYPE, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getTableName() != null) {
            obj = et.getTableName();
            node.setAttribute(FIELD_TABLENAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getTableSpace() != null) {
            obj = et.getTableSpace();
            node.setAttribute(FIELD_TABLESPACE, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getTipsInfo() != null) {
            obj = et.getTipsInfo();
            node.setAttribute(FIELD_TIPSINFO, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            obj = et.getUpdateDate();
            node.setAttribute(FIELD_UPDATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            obj = et.getUpdateMan();
            node.setAttribute(FIELD_UPDATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserAction() != null) {
            obj = et.getUserAction();
            node.setAttribute(FIELD_USERACTION, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getValidFlag() != null) {
            obj = et.getValidFlag();
            node.setAttribute(FIELD_VALIDFLAG, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getVCFlag() != null) {
            obj = et.getVCFlag();
            node.setAttribute(FIELD_VCFLAG, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getVerCheckTimer() != null) {
            obj = et.getVerCheckTimer();
            node.setAttribute(FIELD_VERCHECKTIMER, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getVerField() != null) {
            obj = et.getVerField();
            node.setAttribute(FIELD_VERFIELD, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getVerHelper() != null) {
            obj = et.getVerHelper();
            node.setAttribute(FIELD_VERHELPER, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getVersionCheck() != null) {
            obj = et.getVersionCheck();
            node.setAttribute(FIELD_VERSIONCHECK, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getViewName() != null) {
            obj = et.getViewName();
            node.setAttribute(FIELD_VIEWNAME, obj == null ? "" : (String)obj);
        }
    }

    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        DataEntityBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(DataEntityBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isACEnableDPDirty() && (bIncEmpty || et.getACEnableDP() != null)) {
            dst.set(FIELD_ACENABLEDP, et.getACEnableDP());
        }
        if (et.isACExtInfoDirty() && (bIncEmpty || et.getACExtInfo() != null)) {
            dst.set(FIELD_ACEXTINFO, et.getACExtInfo());
        }
        if (et.isACInfoFormatDirty() && (bIncEmpty || et.getACInfoFormat() != null)) {
            dst.set(FIELD_ACINFOFORMAT, et.getACInfoFormat());
        }
        if (et.isACInfoParamDirty() && (bIncEmpty || et.getACInfoParam() != null)) {
            dst.set(FIELD_ACINFOPARAM, et.getACInfoParam());
        }
        if (et.isACMaxCntDirty() && (bIncEmpty || et.getACMaxCnt() != null)) {
            dst.set(FIELD_ACMAXCNT, et.getACMaxCnt());
        }
        if (et.isACObjectDirty() && (bIncEmpty || et.getACObject() != null)) {
            dst.set(FIELD_ACOBJECT, et.getACObject());
        }
        if (et.isACQueryModelIdDirty() && (bIncEmpty || et.getACQueryModelId() != null)) {
            dst.set(FIELD_ACQUERYMODELID, et.getACQueryModelId());
        }
        if (et.isACQueryModelNameDirty() && (bIncEmpty || et.getACQueryModelName() != null)) {
            dst.set(FIELD_ACQUERYMODELNAME, et.getACQueryModelName());
        }
        if (et.isACSortDirDirty() && (bIncEmpty || et.getACSortDir() != null)) {
            dst.set(FIELD_ACSORTDIR, et.getACSortDir());
        }
        if (et.isACSortFieldDirty() && (bIncEmpty || et.getACSortField() != null)) {
            dst.set(FIELD_ACSORTFIELD, et.getACSortField());
        }
        if (et.isBigIconDirty() && (bIncEmpty || et.getBigIcon() != null)) {
            dst.set(FIELD_BIGICON, et.getBigIcon());
        }
        if (et.isConfigHelperDirty() && (bIncEmpty || et.getConfigHelper() != null)) {
            dst.set(FIELD_CONFIGHELPER, et.getConfigHelper());
        }
        if (et.isCreateDateDirty() && (bIncEmpty || et.getCreateDate() != null)) {
            dst.set(FIELD_CREATEDATE, et.getCreateDate());
        }
        if (et.isCreateManDirty() && (bIncEmpty || et.getCreateMan() != null)) {
            dst.set(FIELD_CREATEMAN, et.getCreateMan());
        }
        if (et.isDataAccObjectDirty() && (bIncEmpty || et.getDataAccObject() != null)) {
            dst.set(FIELD_DATAACCOBJECT, et.getDataAccObject());
        }
        if (et.isDataChgLogModeDirty() && (bIncEmpty || et.getDataChgLogMode() != null)) {
            dst.set(FIELD_DATACHGLOGMODE, et.getDataChgLogMode());
        }
        if (et.isDataCtrlIntDirty() && (bIncEmpty || et.getDataCtrlInt() != null)) {
            dst.set(FIELD_DATACTRLINT, et.getDataCtrlInt());
        }
        if (et.isDataCtrlObjectDirty() && (bIncEmpty || et.getDataCtrlObject() != null)) {
            dst.set(FIELD_DATACTRLOBJECT, et.getDataCtrlObject());
        }
        if (et.isDataNotifyHelperDirty() && (bIncEmpty || et.getDataNotifyHelper() != null)) {
            dst.set(FIELD_DATANOTIFYHELPER, et.getDataNotifyHelper());
        }
        if (et.isDBStorageDirty() && (bIncEmpty || et.getDBStorage() != null)) {
            dst.set(FIELD_DBSTORAGE, et.getDBStorage());
        }
        if (et.isDBVersionDirty() && (bIncEmpty || et.getDBVersion() != null)) {
            dst.set(FIELD_DBVERSION, et.getDBVersion());
        }
        if (et.isDEGroupDirty() && (bIncEmpty || et.getDEGroup() != null)) {
            dst.set(FIELD_DEGROUP, et.getDEGroup());
        }
        if (et.isDEHelperDirty() && (bIncEmpty || et.getDEHelper() != null)) {
            dst.set(FIELD_DEHELPER, et.getDEHelper());
        }
        if (et.isDEIdDirty() && (bIncEmpty || et.getDEId() != null)) {
            dst.set(FIELD_DEID, et.getDEId());
        }
        if (et.isDELogicNameDirty() && (bIncEmpty || et.getDELogicName() != null)) {
            dst.set(FIELD_DELOGICNAME, et.getDELogicName());
        }
        if (et.isDENameDirty() && (bIncEmpty || et.getDEName() != null)) {
            dst.set(FIELD_DENAME, et.getDEName());
        }
        if (et.isDEObjectDirty() && (bIncEmpty || et.getDEObject() != null)) {
            dst.set(FIELD_DEOBJECT, et.getDEObject());
        }
        if (et.isDEOrderDirty() && (bIncEmpty || et.getDEOrder() != null)) {
            dst.set(FIELD_DEORDER, et.getDEOrder());
        }
        if (et.isDEParamDirty() && (bIncEmpty || et.getDEParam() != null)) {
            dst.set(FIELD_DEPARAM, et.getDEParam());
        }
        if (et.isDER11DEIdDirty() && (bIncEmpty || et.getDER11DEId() != null)) {
            dst.set(FIELD_DER11DEID, et.getDER11DEId());
        }
        if (et.isDER11DENameDirty() && (bIncEmpty || et.getDER11DEName() != null)) {
            dst.set(FIELD_DER11DENAME, et.getDER11DEName());
        }
        if (et.isDETypeDirty() && (bIncEmpty || et.getDEType() != null)) {
            dst.set(FIELD_DETYPE, et.getDEType());
        }
        if (et.isDEUserParamDirty() && (bIncEmpty || et.getDEUserParam() != null)) {
            dst.set(FIELD_DEUSERPARAM, et.getDEUserParam());
        }
        if (et.isDEVersionDirty() && (bIncEmpty || et.getDEVersion() != null)) {
            dst.set(FIELD_DEVERSION, et.getDEVersion());
        }
        if (et.isDGRowClassHelperDirty() && (bIncEmpty || et.getDGRowClassHelper() != null)) {
            dst.set(FIELD_DGROWCLASSHELPER, et.getDGRowClassHelper());
        }
        if (et.isDGSUMMARYHeightDirty() && (bIncEmpty || et.getDGSUMMARYHeight() != null)) {
            dst.set(FIELD_DGSUMMARYHEIGHT, et.getDGSUMMARYHeight());
        }
        if (et.isDLKHelperDirty() && (bIncEmpty || et.getDLKHelper() != null)) {
            dst.set(FIELD_DLKHELPER, et.getDLKHelper());
        }
        if (et.isDynamicIntervalDirty() && (bIncEmpty || et.getDynamicInterval() != null)) {
            dst.set(FIELD_DYNAMICINTERVAL, et.getDynamicInterval());
        }
        if (et.isEnableColPrivDirty() && (bIncEmpty || et.getEnableColPriv() != null)) {
            dst.set(FIELD_ENABLECOLPRIV, et.getEnableColPriv());
        }
        if (et.isEnableGlobalModelDirty() && (bIncEmpty || et.getEnableGlobalModel() != null)) {
            dst.set(FIELD_ENABLEGLOBALMODEL, et.getEnableGlobalModel());
        }
        if (et.isExitingModelDirty() && (bIncEmpty || et.getExitingModel() != null)) {
            dst.set(FIELD_EXITINGMODEL, et.getExitingModel());
        }
        if (et.isExportIncEmptyDirty() && (bIncEmpty || et.getExportIncEmpty() != null)) {
            dst.set(FIELD_EXPORTINCEMPTY, et.getExportIncEmpty());
        }
        if (et.isExTableNameDirty() && (bIncEmpty || et.getExTableName() != null)) {
            dst.set(FIELD_EXTABLENAME, et.getExTableName());
        }
        if (et.isGlobalModelObjDirty() && (bIncEmpty || et.getGlobalModelObj() != null)) {
            dst.set(FIELD_GLOBALMODELOBJ, et.getGlobalModelObj());
        }
        if (et.isIndexModeDirty() && (bIncEmpty || et.getIndexMode() != null)) {
            dst.set(FIELD_INDEXMODE, et.getIndexMode());
        }
        if (et.isInfoFieldDirty() && (bIncEmpty || et.getInfoField() != null)) {
            dst.set(FIELD_INFOFIELD, et.getInfoField());
        }
        if (et.isInfoFormatDirty() && (bIncEmpty || et.getInfoFormat() != null)) {
            dst.set(FIELD_INFOFORMAT, et.getInfoFormat());
        }
        if (et.isInheritModeDirty() && (bIncEmpty || et.getInheritMode() != null)) {
            dst.set(FIELD_INHERITMODE, et.getInheritMode());
        }
        if (et.isIsDGRowEditDirty() && (bIncEmpty || et.getIsDGRowEdit() != null)) {
            dst.set(FIELD_ISDGROWEDIT, et.getIsDGRowEdit());
        }
        if (et.isIsEnableAuditDirty() && (bIncEmpty || et.getIsEnableAudit() != null)) {
            dst.set(FIELD_ISENABLEAUDIT, et.getIsEnableAudit());
        }
        if (et.isIsEnableDPDirty() && (bIncEmpty || et.getIsEnableDP() != null)) {
            dst.set(FIELD_ISENABLEDP, et.getIsEnableDP());
        }
        if (et.isIsIndexDEDirty() && (bIncEmpty || et.getIsIndexDE() != null)) {
            dst.set(FIELD_ISINDEXDE, et.getIsIndexDE());
        }
        if (et.isIsLogicValidDirty() && (bIncEmpty || et.getIsLogicValid() != null)) {
            dst.set(FIELD_ISLOGICVALID, et.getIsLogicValid());
        }
        if (et.isISMULTIPRINTDirty() && (bIncEmpty || et.getISMULTIPRINT() != null)) {
            dst.set(FIELD_ISMULTIPRINT, et.getISMULTIPRINT());
        }
        if (et.isISSupportFADirty() && (bIncEmpty || et.getISSupportFA() != null)) {
            dst.set(FIELD_ISSUPPORTFA, et.getISSupportFA());
        }
        if (et.isIsSystemDirty() && (bIncEmpty || et.getIsSystem() != null)) {
            dst.set(FIELD_ISSYSTEM, et.getIsSystem());
        }
        if (et.isKeyParamsDirty() && (bIncEmpty || et.getKeyParams() != null)) {
            dst.set(FIELD_KEYPARAMS, et.getKeyParams());
        }
        if (et.isLicenseCodeDirty() && (bIncEmpty || et.getLicenseCode() != null)) {
            dst.set(FIELD_LICENSECODE, et.getLicenseCode());
        }
        if (et.isLogAuditDetailDirty() && (bIncEmpty || et.getLogAuditDetail() != null)) {
            dst.set(FIELD_LOGAUDITDETAIL, et.getLogAuditDetail());
        }
        if (et.isMemoDirty() && (bIncEmpty || et.getMemo() != null)) {
            dst.set(FIELD_MEMO, et.getMemo());
        }
        if (et.isMinorFieldNameDirty() && (bIncEmpty || et.getMinorFieldName() != null)) {
            dst.set(FIELD_MINORFIELDNAME, et.getMinorFieldName());
        }
        if (et.isMinorFieldValueDirty() && (bIncEmpty || et.getMinorFieldValue() != null)) {
            dst.set(FIELD_MINORFIELDVALUE, et.getMinorFieldValue());
        }
        if (et.isMinorTableNameDirty() && (bIncEmpty || et.getMinorTableName() != null)) {
            dst.set(FIELD_MINORTABLENAME, et.getMinorTableName());
        }
        if (et.isMutliMajorDirty() && (bIncEmpty || et.getMutliMajor() != null)) {
            dst.set(FIELD_MUTLIMAJOR, et.getMutliMajor());
        }
        if (et.isNoDataInfoDirty() && (bIncEmpty || et.getNoDataInfo() != null)) {
            dst.set(FIELD_NODATAINFO, et.getNoDataInfo());
        }
        if (et.isPrintFuncDirty() && (bIncEmpty || et.getPrintFunc() != null)) {
            dst.set(FIELD_PRINTFUNC, et.getPrintFunc());
        }
        if (et.isReserverDirty() && (bIncEmpty || et.getReserver() != null)) {
            dst.set(FIELD_RESERVER, et.getReserver());
        }
        if (et.isReserver2Dirty() && (bIncEmpty || et.getReserver2() != null)) {
            dst.set(FIELD_RESERVER2, et.getReserver2());
        }
        if (et.isRowAmoutDirty() && (bIncEmpty || et.getRowAmout() != null)) {
            dst.set(FIELD_ROWAMOUT, et.getRowAmout());
        }
        if (et.isRTInfoDirty() && (bIncEmpty || et.getRTInfo() != null)) {
            dst.set(FIELD_RTINFO, et.getRTInfo());
        }
        if (et.isSMALLICONDirty() && (bIncEmpty || et.getSMALLICON() != null)) {
            dst.set(FIELD_SMALLICON, et.getSMALLICON());
        }
        if (et.isStorageTypeDirty() && (bIncEmpty || et.getStorageType() != null)) {
            dst.set(FIELD_STORAGETYPE, et.getStorageType());
        }
        if (et.isTableNameDirty() && (bIncEmpty || et.getTableName() != null)) {
            dst.set(FIELD_TABLENAME, et.getTableName());
        }
        if (et.isTableSpaceDirty() && (bIncEmpty || et.getTableSpace() != null)) {
            dst.set(FIELD_TABLESPACE, et.getTableSpace());
        }
        if (et.isTipsInfoDirty() && (bIncEmpty || et.getTipsInfo() != null)) {
            dst.set(FIELD_TIPSINFO, et.getTipsInfo());
        }
        if (et.isUpdateDateDirty() && (bIncEmpty || et.getUpdateDate() != null)) {
            dst.set(FIELD_UPDATEDATE, et.getUpdateDate());
        }
        if (et.isUpdateManDirty() && (bIncEmpty || et.getUpdateMan() != null)) {
            dst.set(FIELD_UPDATEMAN, et.getUpdateMan());
        }
        if (et.isUserActionDirty() && (bIncEmpty || et.getUserAction() != null)) {
            dst.set(FIELD_USERACTION, et.getUserAction());
        }
        if (et.isValidFlagDirty() && (bIncEmpty || et.getValidFlag() != null)) {
            dst.set(FIELD_VALIDFLAG, et.getValidFlag());
        }
        if (et.isVCFlagDirty() && (bIncEmpty || et.getVCFlag() != null)) {
            dst.set(FIELD_VCFLAG, et.getVCFlag());
        }
        if (et.isVerCheckTimerDirty() && (bIncEmpty || et.getVerCheckTimer() != null)) {
            dst.set(FIELD_VERCHECKTIMER, et.getVerCheckTimer());
        }
        if (et.isVerFieldDirty() && (bIncEmpty || et.getVerField() != null)) {
            dst.set(FIELD_VERFIELD, et.getVerField());
        }
        if (et.isVerHelperDirty() && (bIncEmpty || et.getVerHelper() != null)) {
            dst.set(FIELD_VERHELPER, et.getVerHelper());
        }
        if (et.isVersionCheckDirty() && (bIncEmpty || et.getVersionCheck() != null)) {
            dst.set(FIELD_VERSIONCHECK, et.getVersionCheck());
        }
        if (et.isViewNameDirty() && (bIncEmpty || et.getViewName() != null)) {
            dst.set(FIELD_VIEWNAME, et.getViewName());
        }
    }

    @Override
    public boolean remove(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().remove(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.remove(strParamName);
        }
        return DataEntityBase.remove(this, index);
    }

    private static boolean remove(DataEntityBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                et.resetACEnableDP();
                return true;
            }
            case 1: {
                et.resetACExtInfo();
                return true;
            }
            case 2: {
                et.resetACInfoFormat();
                return true;
            }
            case 3: {
                et.resetACInfoParam();
                return true;
            }
            case 4: {
                et.resetACMaxCnt();
                return true;
            }
            case 5: {
                et.resetACObject();
                return true;
            }
            case 6: {
                et.resetACQueryModelId();
                return true;
            }
            case 7: {
                et.resetACQueryModelName();
                return true;
            }
            case 8: {
                et.resetACSortDir();
                return true;
            }
            case 9: {
                et.resetACSortField();
                return true;
            }
            case 10: {
                et.resetBigIcon();
                return true;
            }
            case 11: {
                et.resetConfigHelper();
                return true;
            }
            case 12: {
                et.resetCreateDate();
                return true;
            }
            case 13: {
                et.resetCreateMan();
                return true;
            }
            case 14: {
                et.resetDataAccObject();
                return true;
            }
            case 15: {
                et.resetDataChgLogMode();
                return true;
            }
            case 16: {
                et.resetDataCtrlInt();
                return true;
            }
            case 17: {
                et.resetDataCtrlObject();
                return true;
            }
            case 18: {
                et.resetDataNotifyHelper();
                return true;
            }
            case 19: {
                et.resetDBStorage();
                return true;
            }
            case 20: {
                et.resetDBVersion();
                return true;
            }
            case 21: {
                et.resetDEGroup();
                return true;
            }
            case 22: {
                et.resetDEHelper();
                return true;
            }
            case 23: {
                et.resetDEId();
                return true;
            }
            case 24: {
                et.resetDELogicName();
                return true;
            }
            case 25: {
                et.resetDEName();
                return true;
            }
            case 26: {
                et.resetDEObject();
                return true;
            }
            case 27: {
                et.resetDEOrder();
                return true;
            }
            case 28: {
                et.resetDEParam();
                return true;
            }
            case 29: {
                et.resetDER11DEId();
                return true;
            }
            case 30: {
                et.resetDER11DEName();
                return true;
            }
            case 31: {
                et.resetDEType();
                return true;
            }
            case 32: {
                et.resetDEUserParam();
                return true;
            }
            case 33: {
                et.resetDEVersion();
                return true;
            }
            case 34: {
                et.resetDGRowClassHelper();
                return true;
            }
            case 35: {
                et.resetDGSUMMARYHeight();
                return true;
            }
            case 36: {
                et.resetDLKHelper();
                return true;
            }
            case 37: {
                et.resetDynamicInterval();
                return true;
            }
            case 38: {
                et.resetEnableColPriv();
                return true;
            }
            case 39: {
                et.resetEnableGlobalModel();
                return true;
            }
            case 40: {
                et.resetExitingModel();
                return true;
            }
            case 41: {
                et.resetExportIncEmpty();
                return true;
            }
            case 42: {
                et.resetExTableName();
                return true;
            }
            case 43: {
                et.resetGlobalModelObj();
                return true;
            }
            case 44: {
                et.resetIndexMode();
                return true;
            }
            case 45: {
                et.resetInfoField();
                return true;
            }
            case 46: {
                et.resetInfoFormat();
                return true;
            }
            case 47: {
                et.resetInheritMode();
                return true;
            }
            case 48: {
                et.resetIsDGRowEdit();
                return true;
            }
            case 49: {
                et.resetIsEnableAudit();
                return true;
            }
            case 50: {
                et.resetIsEnableDP();
                return true;
            }
            case 51: {
                et.resetIsIndexDE();
                return true;
            }
            case 52: {
                et.resetIsLogicValid();
                return true;
            }
            case 53: {
                et.resetISMULTIPRINT();
                return true;
            }
            case 54: {
                et.resetISSupportFA();
                return true;
            }
            case 55: {
                et.resetIsSystem();
                return true;
            }
            case 56: {
                et.resetKeyParams();
                return true;
            }
            case 57: {
                et.resetLicenseCode();
                return true;
            }
            case 58: {
                et.resetLogAuditDetail();
                return true;
            }
            case 59: {
                et.resetMemo();
                return true;
            }
            case 60: {
                et.resetMinorFieldName();
                return true;
            }
            case 61: {
                et.resetMinorFieldValue();
                return true;
            }
            case 62: {
                et.resetMinorTableName();
                return true;
            }
            case 63: {
                et.resetMutliMajor();
                return true;
            }
            case 64: {
                et.resetNoDataInfo();
                return true;
            }
            case 65: {
                et.resetPrintFunc();
                return true;
            }
            case 66: {
                et.resetReserver();
                return true;
            }
            case 67: {
                et.resetReserver2();
                return true;
            }
            case 68: {
                et.resetRowAmout();
                return true;
            }
            case 69: {
                et.resetRTInfo();
                return true;
            }
            case 70: {
                et.resetSMALLICON();
                return true;
            }
            case 71: {
                et.resetStorageType();
                return true;
            }
            case 72: {
                et.resetTableName();
                return true;
            }
            case 73: {
                et.resetTableSpace();
                return true;
            }
            case 74: {
                et.resetTipsInfo();
                return true;
            }
            case 75: {
                et.resetUpdateDate();
                return true;
            }
            case 76: {
                et.resetUpdateMan();
                return true;
            }
            case 77: {
                et.resetUserAction();
                return true;
            }
            case 78: {
                et.resetValidFlag();
                return true;
            }
            case 79: {
                et.resetVCFlag();
                return true;
            }
            case 80: {
                et.resetVerCheckTimer();
                return true;
            }
            case 81: {
                et.resetVerField();
                return true;
            }
            case 82: {
                et.resetVerHelper();
                return true;
            }
            case 83: {
                et.resetVersionCheck();
                return true;
            }
            case 84: {
                et.resetViewName();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public DataEntity getDER11DE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDER11DE();
        }
        if (this.getDER11DEId() == null) {
            return null;
        }
        Integer n = this.objDER11DELock;
        synchronized (n) {
            if (this.der11de != null && DataTypeHelper.compare(25, (Object)this.getDER11DEId(), (Object)this.der11de.getDEId()) != 0L) {
                this.der11de = null;
            }
            if (this.der11de == null) {
                DataEntity der11de = new DataEntity();
                der11de.setDEId(this.getDER11DEId());
                DataEntityService service = (DataEntityService)ServiceGlobal.getService(DataEntityService.class, this.getSessionFactory());
                service.autoGet(der11de);
                this.der11de = der11de;
            }
            return this.der11de;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public QueryModel getACQueryModel() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getACQueryModel();
        }
        if (this.getACQueryModelId() == null) {
            return null;
        }
        Integer n = this.objACQueryModelLock;
        synchronized (n) {
            if (this.acquerymodel != null && DataTypeHelper.compare(25, (Object)this.getACQueryModelId(), (Object)this.acquerymodel.getQueryModelId()) != 0L) {
                this.acquerymodel = null;
            }
            if (this.acquerymodel == null) {
                QueryModel acquerymodel = new QueryModel();
                acquerymodel.setQueryModelId(this.getACQueryModelId());
                QueryModelService service = (QueryModelService)ServiceGlobal.getService(QueryModelService.class, this.getSessionFactory());
                service.autoGet(acquerymodel);
                this.acquerymodel = acquerymodel;
            }
            return this.acquerymodel;
        }
    }

    private DataEntityBase getProxyEntity() {
        return this.proxyDataEntityBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyDataEntityBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof DataEntityBase) {
            this.proxyDataEntityBase = (DataEntityBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.demodel.service.DataEntityService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

