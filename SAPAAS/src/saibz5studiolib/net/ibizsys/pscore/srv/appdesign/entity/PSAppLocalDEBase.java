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
package net.ibizsys.pscore.srv.appdesign.entity;

import java.io.Serializable;
import java.sql.Timestamp;
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
import net.ibizsys.pscore.srv.appdesign.entity.PSAppLocalDE;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppModule;
import net.ibizsys.pscore.srv.appdesign.service.PSAppLocalDEService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppModuleService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEServiceAPI;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDERService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEServiceAPIService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysServiceAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUniRes;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysServiceAPIService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUniResService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppLocalDEBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSAppLocalDEBase.class);
    public static final String FIELD_ACCCTRLARCH = "ACCCTRLARCH";
    public static final String FIELD_AUTOADDMETHODMODE = "AUTOADDMETHODMODE";
    public static final String FIELD_AUTOADDVIEWMODE = "AUTOADDVIEWMODE";
    public static final String FIELD_BASECLSPARAMS = "BASECLSPARAMS";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CODENAME2 = "CODENAME2";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMUSERACTION = "CUSTOMUSERACTION";
    public static final String FIELD_DATAACCMODE = "DATAACCMODE";
    public static final String FIELD_DECODENAME = "DECODENAME";
    public static final String FIELD_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String FIELD_DEFGROUPMODE = "DEFGROUPMODE";
    public static final String FIELD_DELOGICNAME = "DELOGICNAME";
    public static final String FIELD_ENABLESTORAGE = "ENABLESTORAGE";
    public static final String FIELD_LINKPSDEVIEWID = "LINKPSDEVIEWID";
    public static final String FIELD_LINKPSDEVIEWNAME = "LINKPSDEVIEWNAME";
    public static final String FIELD_LNPSLANRESID = "LNPSLANRESID";
    public static final String FIELD_LNPSLANRESNAME = "LNPSLANRESNAME";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MAJORFLAG = "MAJORFLAG";
    public static final String FIELD_MDPSDEVIEWID = "MDPSDEVIEWID";
    public static final String FIELD_MDPSDEVIEWNAME = "MDPSDEVIEWNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PPSAPPLOCALDEID = "PPSAPPLOCALDEID";
    public static final String FIELD_PPSAPPLOCALDENAME = "PPSAPPLOCALDENAME";
    public static final String FIELD_PSAPPLOCALDEID = "PSAPPLOCALDEID";
    public static final String FIELD_PSAPPLOCALDENAME = "PSAPPLOCALDENAME";
    public static final String FIELD_PSAPPMODULEID = "PSAPPMODULEID";
    public static final String FIELD_PSAPPMODULENAME = "PSAPPMODULENAME";
    public static final String FIELD_PSDEFGROUPID = "PSDEFGROUPID";
    public static final String FIELD_PSDEFGROUPNAME = "PSDEFGROUPNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDERID = "PSDERID";
    public static final String FIELD_PSDERNAME = "PSDERNAME";
    public static final String FIELD_PSDESERVICEAPIID = "PSDESERVICEAPIID";
    public static final String FIELD_PSDESERVICEAPINAME = "PSDESERVICEAPINAME";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String FIELD_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String FIELD_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String FIELD_PSSYSREQITEMID = "PSSYSREQITEMID";
    public static final String FIELD_PSSYSREQITEMNAME = "PSSYSREQITEMNAME";
    public static final String FIELD_PSSYSSERVICEAPIID = "PSSYSSERVICEAPIID";
    public static final String FIELD_PSSYSSERVICEAPINAME = "PSSYSSERVICEAPINAME";
    public static final String FIELD_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String FIELD_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String FIELD_PSSYSUNIRESID = "PSSYSUNIRESID";
    public static final String FIELD_PSSYSUNIRESNAME = "PSSYSUNIRESNAME";
    public static final String FIELD_SDPSDEVIEWID = "SDPSDEVIEWID";
    public static final String FIELD_SDPSDEVIEWNAME = "SDPSDEVIEWNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERACTION = "USERACTION";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_ACCCTRLARCH = 0;
    private static final int INDEX_AUTOADDMETHODMODE = 1;
    private static final int INDEX_AUTOADDVIEWMODE = 2;
    private static final int INDEX_BASECLSPARAMS = 3;
    private static final int INDEX_CODENAME = 4;
    private static final int INDEX_CODENAME2 = 5;
    private static final int INDEX_CREATEDATE = 6;
    private static final int INDEX_CREATEMAN = 7;
    private static final int INDEX_CUSTOMUSERACTION = 8;
    private static final int INDEX_DATAACCMODE = 9;
    private static final int INDEX_DECODENAME = 10;
    private static final int INDEX_DEFAULTFLAG = 11;
    private static final int INDEX_DEFGROUPMODE = 12;
    private static final int INDEX_DELOGICNAME = 13;
    private static final int INDEX_ENABLESTORAGE = 14;
    private static final int INDEX_LINKPSDEVIEWID = 15;
    private static final int INDEX_LINKPSDEVIEWNAME = 16;
    private static final int INDEX_LNPSLANRESID = 17;
    private static final int INDEX_LNPSLANRESNAME = 18;
    private static final int INDEX_LOGICNAME = 19;
    private static final int INDEX_MAJORFLAG = 20;
    private static final int INDEX_MDPSDEVIEWID = 21;
    private static final int INDEX_MDPSDEVIEWNAME = 22;
    private static final int INDEX_MEMO = 23;
    private static final int INDEX_PPSAPPLOCALDEID = 24;
    private static final int INDEX_PPSAPPLOCALDENAME = 25;
    private static final int INDEX_PSAPPLOCALDEID = 26;
    private static final int INDEX_PSAPPLOCALDENAME = 27;
    private static final int INDEX_PSAPPMODULEID = 28;
    private static final int INDEX_PSAPPMODULENAME = 29;
    private static final int INDEX_PSDEFGROUPID = 30;
    private static final int INDEX_PSDEFGROUPNAME = 31;
    private static final int INDEX_PSDEID = 32;
    private static final int INDEX_PSDENAME = 33;
    private static final int INDEX_PSDERID = 34;
    private static final int INDEX_PSDERNAME = 35;
    private static final int INDEX_PSDESERVICEAPIID = 36;
    private static final int INDEX_PSDESERVICEAPINAME = 37;
    private static final int INDEX_PSMODULEID = 38;
    private static final int INDEX_PSSYSAPPID = 39;
    private static final int INDEX_PSSYSAPPNAME = 40;
    private static final int INDEX_PSSYSDYNAMODELID = 41;
    private static final int INDEX_PSSYSDYNAMODELNAME = 42;
    private static final int INDEX_PSSYSREQITEMID = 43;
    private static final int INDEX_PSSYSREQITEMNAME = 44;
    private static final int INDEX_PSSYSSERVICEAPIID = 45;
    private static final int INDEX_PSSYSSERVICEAPINAME = 46;
    private static final int INDEX_PSSYSSFPLUGINID = 47;
    private static final int INDEX_PSSYSSFPLUGINNAME = 48;
    private static final int INDEX_PSSYSUNIRESID = 49;
    private static final int INDEX_PSSYSUNIRESNAME = 50;
    private static final int INDEX_SDPSDEVIEWID = 51;
    private static final int INDEX_SDPSDEVIEWNAME = 52;
    private static final int INDEX_UPDATEDATE = 53;
    private static final int INDEX_UPDATEMAN = 54;
    private static final int INDEX_USERACTION = 55;
    private static final int INDEX_USERCAT = 56;
    private static final int INDEX_USERTAG = 57;
    private static final int INDEX_USERTAG2 = 58;
    private static final int INDEX_USERTAG3 = 59;
    private static final int INDEX_USERTAG4 = 60;
    private static final int INDEX_VALIDFLAG = 61;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSAppLocalDEBase proxyPSAppLocalDEBase = null;
    private boolean accctrlarchDirtyFlag = false;
    private boolean autoaddmethodmodeDirtyFlag = false;
    private boolean autoaddviewmodeDirtyFlag = false;
    private boolean baseclsparamsDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean codename2DirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customuseractionDirtyFlag = false;
    private boolean dataaccmodeDirtyFlag = false;
    private boolean decodenameDirtyFlag = false;
    private boolean defaultflagDirtyFlag = false;
    private boolean defgroupmodeDirtyFlag = false;
    private boolean delogicnameDirtyFlag = false;
    private boolean enablestorageDirtyFlag = false;
    private boolean linkpsdeviewidDirtyFlag = false;
    private boolean linkpsdeviewnameDirtyFlag = false;
    private boolean lnpslanresidDirtyFlag = false;
    private boolean lnpslanresnameDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean majorflagDirtyFlag = false;
    private boolean mdpsdeviewidDirtyFlag = false;
    private boolean mdpsdeviewnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ppsapplocaldeidDirtyFlag = false;
    private boolean ppsapplocaldenameDirtyFlag = false;
    private boolean psapplocaldeidDirtyFlag = false;
    private boolean psapplocaldenameDirtyFlag = false;
    private boolean psappmoduleidDirtyFlag = false;
    private boolean psappmodulenameDirtyFlag = false;
    private boolean psdefgroupidDirtyFlag = false;
    private boolean psdefgroupnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psderidDirtyFlag = false;
    private boolean psdernameDirtyFlag = false;
    private boolean psdeserviceapiidDirtyFlag = false;
    private boolean psdeserviceapinameDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean pssysappnameDirtyFlag = false;
    private boolean pssysdynamodelidDirtyFlag = false;
    private boolean pssysdynamodelnameDirtyFlag = false;
    private boolean pssysreqitemidDirtyFlag = false;
    private boolean pssysreqitemnameDirtyFlag = false;
    private boolean pssysserviceapiidDirtyFlag = false;
    private boolean pssysserviceapinameDirtyFlag = false;
    private boolean pssyssfpluginidDirtyFlag = false;
    private boolean pssyssfpluginnameDirtyFlag = false;
    private boolean pssysuniresidDirtyFlag = false;
    private boolean pssysuniresnameDirtyFlag = false;
    private boolean sdpsdeviewidDirtyFlag = false;
    private boolean sdpsdeviewnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean useractionDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="accctrlarch")
    private Integer accctrlarch;
    @Column(name="autoaddmethodmode")
    private Integer autoaddmethodmode;
    @Column(name="autoaddviewmode")
    private Integer autoaddviewmode;
    @Column(name="baseclsparams")
    private String baseclsparams;
    @Column(name="codename")
    private String codename;
    @Column(name="codename2")
    private String codename2;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="customuseraction")
    private Integer customuseraction;
    @Column(name="dataaccmode")
    private Integer dataaccmode;
    @Column(name="decodename")
    private String decodename;
    @Column(name="defaultflag")
    private Integer defaultflag;
    @Column(name="defgroupmode")
    private String defgroupmode;
    @Column(name="delogicname")
    private String delogicname;
    @Column(name="enablestorage")
    private Integer enablestorage;
    @Column(name="linkpsdeviewid")
    private String linkpsdeviewid;
    @Column(name="linkpsdeviewname")
    private String linkpsdeviewname;
    @Column(name="lnpslanresid")
    private String lnpslanresid;
    @Column(name="lnpslanresname")
    private String lnpslanresname;
    @Column(name="logicname")
    private String logicname;
    @Column(name="majorflag")
    private Integer majorflag;
    @Column(name="mdpsdeviewid")
    private String mdpsdeviewid;
    @Column(name="mdpsdeviewname")
    private String mdpsdeviewname;
    @Column(name="memo")
    private String memo;
    @Column(name="ppsapplocaldeid")
    private String ppsapplocaldeid;
    @Column(name="ppsapplocaldename")
    private String ppsapplocaldename;
    @Column(name="psapplocaldeid")
    private String psapplocaldeid;
    @Column(name="psapplocaldename")
    private String psapplocaldename;
    @Column(name="psappmoduleid")
    private String psappmoduleid;
    @Column(name="psappmodulename")
    private String psappmodulename;
    @Column(name="psdefgroupid")
    private String psdefgroupid;
    @Column(name="psdefgroupname")
    private String psdefgroupname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psderid")
    private String psderid;
    @Column(name="psdername")
    private String psdername;
    @Column(name="psdeserviceapiid")
    private String psdeserviceapiid;
    @Column(name="psdeserviceapiname")
    private String psdeserviceapiname;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="pssysappid")
    private String pssysappid;
    @Column(name="pssysappname")
    private String pssysappname;
    @Column(name="pssysdynamodelid")
    private String pssysdynamodelid;
    @Column(name="pssysdynamodelname")
    private String pssysdynamodelname;
    @Column(name="pssysreqitemid")
    private String pssysreqitemid;
    @Column(name="pssysreqitemname")
    private String pssysreqitemname;
    @Column(name="pssysserviceapiid")
    private String pssysserviceapiid;
    @Column(name="pssysserviceapiname")
    private String pssysserviceapiname;
    @Column(name="pssyssfpluginid")
    private String pssyssfpluginid;
    @Column(name="pssyssfpluginname")
    private String pssyssfpluginname;
    @Column(name="pssysuniresid")
    private String pssysuniresid;
    @Column(name="pssysuniresname")
    private String pssysuniresname;
    @Column(name="sdpsdeviewid")
    private String sdpsdeviewid;
    @Column(name="sdpsdeviewname")
    private String sdpsdeviewname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="useraction")
    private Integer useraction;
    @Column(name="usercat")
    private String usercat;
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
    private Integer objPPSAppLocalDELock = new Integer(1);
    private PSAppLocalDE ppsapplocalde = null;
    private Integer objPSAppModuleLock = new Integer(1);
    private PSAppModule psappmodule = null;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objPSDEFGroupLock = new Integer(1);
    private PSDEFGroup psdefgroup = null;
    private Integer objPSDERLock = new Integer(1);
    private PSDER psder = null;
    private Integer objPSDEServiceAPILock = new Integer(1);
    private PSDEServiceAPI psdeserviceapi = null;
    private Integer objLinkPSDEViewLock = new Integer(1);
    private PSDEViewBase linkpsdeview = null;
    private Integer objMDPSDEViewLock = new Integer(1);
    private PSDEViewBase mdpsdeview = null;
    private Integer objSDPSDEViewLock = new Integer(1);
    private PSDEViewBase sdpsdeview = null;
    private Integer objLNPSLanResLock = new Integer(1);
    private PSLanguageRes lnpslanres = null;
    private Integer objPSSysAppLock = new Integer(1);
    private PSSysApp pssysapp = null;
    private Integer objPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel pssysdynamodel = null;
    private Integer objPSSysReqItemLock = new Integer(1);
    private PSSysReqItem pssysreqitem = null;
    private Integer objPSSysServiceAPILock = new Integer(1);
    private PSSysServiceAPI pssysserviceapi = null;
    private Integer objPSSysSFPluginLock = new Integer(1);
    private PSSysSFPlugin pssyssfplugin = null;
    private Integer objPSSysUniResLock = new Integer(1);
    private PSSysUniRes pssysunires = null;

    public void setAccCtrlArch(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAccCtrlArch(n);
            return;
        }
        this.accctrlarch = n;
        this.accctrlarchDirtyFlag = true;
    }

    public Integer getAccCtrlArch() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAccCtrlArch();
        }
        return this.accctrlarch;
    }

    public boolean isAccCtrlArchDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAccCtrlArchDirty();
        }
        return this.accctrlarchDirtyFlag;
    }

    public void resetAccCtrlArch() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAccCtrlArch();
            return;
        }
        this.accctrlarchDirtyFlag = false;
        this.accctrlarch = null;
    }

    public void setAutoAddMethodMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAutoAddMethodMode(n);
            return;
        }
        this.autoaddmethodmode = n;
        this.autoaddmethodmodeDirtyFlag = true;
    }

    public Integer getAutoAddMethodMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAutoAddMethodMode();
        }
        return this.autoaddmethodmode;
    }

    public boolean isAutoAddMethodModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAutoAddMethodModeDirty();
        }
        return this.autoaddmethodmodeDirtyFlag;
    }

    public void resetAutoAddMethodMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAutoAddMethodMode();
            return;
        }
        this.autoaddmethodmodeDirtyFlag = false;
        this.autoaddmethodmode = null;
    }

    public void setAutoAddViewMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAutoAddViewMode(n);
            return;
        }
        this.autoaddviewmode = n;
        this.autoaddviewmodeDirtyFlag = true;
    }

    public Integer getAutoAddViewMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAutoAddViewMode();
        }
        return this.autoaddviewmode;
    }

    public boolean isAutoAddViewModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAutoAddViewModeDirty();
        }
        return this.autoaddviewmodeDirtyFlag;
    }

    public void resetAutoAddViewMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAutoAddViewMode();
            return;
        }
        this.autoaddviewmodeDirtyFlag = false;
        this.autoaddviewmode = null;
    }

    public void setBaseClsParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBaseClsParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.baseclsparams = string;
        this.baseclsparamsDirtyFlag = true;
    }

    public String getBaseClsParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBaseClsParams();
        }
        return this.baseclsparams;
    }

    public boolean isBaseClsParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBaseClsParamsDirty();
        }
        return this.baseclsparamsDirtyFlag;
    }

    public void resetBaseClsParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBaseClsParams();
            return;
        }
        this.baseclsparamsDirtyFlag = false;
        this.baseclsparams = null;
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

    public void setCodeName2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeName2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.codename2 = string;
        this.codename2DirtyFlag = true;
    }

    public String getCodeName2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeName2();
        }
        return this.codename2;
    }

    public boolean isCodeName2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeName2Dirty();
        }
        return this.codename2DirtyFlag;
    }

    public void resetCodeName2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeName2();
            return;
        }
        this.codename2DirtyFlag = false;
        this.codename2 = null;
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

    public void setCustomUserAction(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomUserAction(n);
            return;
        }
        this.customuseraction = n;
        this.customuseractionDirtyFlag = true;
    }

    public Integer getCustomUserAction() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomUserAction();
        }
        return this.customuseraction;
    }

    public boolean isCustomUserActionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomUserActionDirty();
        }
        return this.customuseractionDirtyFlag;
    }

    public void resetCustomUserAction() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomUserAction();
            return;
        }
        this.customuseractionDirtyFlag = false;
        this.customuseraction = null;
    }

    public void setDataAccMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDataAccMode(n);
            return;
        }
        this.dataaccmode = n;
        this.dataaccmodeDirtyFlag = true;
    }

    public Integer getDataAccMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDataAccMode();
        }
        return this.dataaccmode;
    }

    public boolean isDataAccModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataAccModeDirty();
        }
        return this.dataaccmodeDirtyFlag;
    }

    public void resetDataAccMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDataAccMode();
            return;
        }
        this.dataaccmodeDirtyFlag = false;
        this.dataaccmode = null;
    }

    public void setDECodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDECodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.decodename = string;
        this.decodenameDirtyFlag = true;
    }

    public String getDECodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDECodeName();
        }
        return this.decodename;
    }

    public boolean isDECodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDECodeNameDirty();
        }
        return this.decodenameDirtyFlag;
    }

    public void resetDECodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDECodeName();
            return;
        }
        this.decodenameDirtyFlag = false;
        this.decodename = null;
    }

    public void setDefaultFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefaultFlag(n);
            return;
        }
        this.defaultflag = n;
        this.defaultflagDirtyFlag = true;
    }

    public Integer getDefaultFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefaultFlag();
        }
        return this.defaultflag;
    }

    public boolean isDefaultFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefaultFlagDirty();
        }
        return this.defaultflagDirtyFlag;
    }

    public void resetDefaultFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefaultFlag();
            return;
        }
        this.defaultflagDirtyFlag = false;
        this.defaultflag = null;
    }

    public void setDEFGroupMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEFGroupMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.defgroupmode = string;
        this.defgroupmodeDirtyFlag = true;
    }

    public String getDEFGroupMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEFGroupMode();
        }
        return this.defgroupmode;
    }

    public boolean isDEFGroupModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEFGroupModeDirty();
        }
        return this.defgroupmodeDirtyFlag;
    }

    public void resetDEFGroupMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEFGroupMode();
            return;
        }
        this.defgroupmodeDirtyFlag = false;
        this.defgroupmode = null;
    }

    public void setDELogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDELogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.delogicname = string;
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

    public void setEnableStorage(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableStorage(n);
            return;
        }
        this.enablestorage = n;
        this.enablestorageDirtyFlag = true;
    }

    public Integer getEnableStorage() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableStorage();
        }
        return this.enablestorage;
    }

    public boolean isEnableStorageDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableStorageDirty();
        }
        return this.enablestorageDirtyFlag;
    }

    public void resetEnableStorage() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableStorage();
            return;
        }
        this.enablestorageDirtyFlag = false;
        this.enablestorage = null;
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

    public void setMajorFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMajorFlag(n);
            return;
        }
        this.majorflag = n;
        this.majorflagDirtyFlag = true;
    }

    public Integer getMajorFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMajorFlag();
        }
        return this.majorflag;
    }

    public boolean isMajorFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMajorFlagDirty();
        }
        return this.majorflagDirtyFlag;
    }

    public void resetMajorFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMajorFlag();
            return;
        }
        this.majorflagDirtyFlag = false;
        this.majorflag = null;
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

    public void setPPSAppLocalDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSAppLocalDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsapplocaldeid = string;
        this.ppsapplocaldeidDirtyFlag = true;
    }

    public String getPPSAppLocalDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSAppLocalDEId();
        }
        return this.ppsapplocaldeid;
    }

    public boolean isPPSAppLocalDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSAppLocalDEIdDirty();
        }
        return this.ppsapplocaldeidDirtyFlag;
    }

    public void resetPPSAppLocalDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSAppLocalDEId();
            return;
        }
        this.ppsapplocaldeidDirtyFlag = false;
        this.ppsapplocaldeid = null;
    }

    public void setPPSAppLocalDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSAppLocalDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsapplocaldename = string;
        this.ppsapplocaldenameDirtyFlag = true;
    }

    public String getPPSAppLocalDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSAppLocalDEName();
        }
        return this.ppsapplocaldename;
    }

    public boolean isPPSAppLocalDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSAppLocalDENameDirty();
        }
        return this.ppsapplocaldenameDirtyFlag;
    }

    public void resetPPSAppLocalDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSAppLocalDEName();
            return;
        }
        this.ppsapplocaldenameDirtyFlag = false;
        this.ppsapplocaldename = null;
    }

    public void setPSAppLocalDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppLocalDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psapplocaldeid = string;
        this.psapplocaldeidDirtyFlag = true;
    }

    public String getPSAppLocalDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppLocalDEId();
        }
        return this.psapplocaldeid;
    }

    public boolean isPSAppLocalDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppLocalDEIdDirty();
        }
        return this.psapplocaldeidDirtyFlag;
    }

    public void resetPSAppLocalDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppLocalDEId();
            return;
        }
        this.psapplocaldeidDirtyFlag = false;
        this.psapplocaldeid = null;
    }

    public void setPSAppLocalDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppLocalDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        if (string != null) {
            string = string.toUpperCase();
        }
        this.psapplocaldename = string;
        this.psapplocaldenameDirtyFlag = true;
    }

    public String getPSAppLocalDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppLocalDEName();
        }
        return this.psapplocaldename;
    }

    public boolean isPSAppLocalDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppLocalDENameDirty();
        }
        return this.psapplocaldenameDirtyFlag;
    }

    public void resetPSAppLocalDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppLocalDEName();
            return;
        }
        this.psapplocaldenameDirtyFlag = false;
        this.psapplocaldename = null;
    }

    public void setPSAppModuleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppModuleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappmoduleid = string;
        this.psappmoduleidDirtyFlag = true;
    }

    public String getPSAppModuleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppModuleId();
        }
        return this.psappmoduleid;
    }

    public boolean isPSAppModuleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppModuleIdDirty();
        }
        return this.psappmoduleidDirtyFlag;
    }

    public void resetPSAppModuleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppModuleId();
            return;
        }
        this.psappmoduleidDirtyFlag = false;
        this.psappmoduleid = null;
    }

    public void setPSAppModuleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppModuleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappmodulename = string;
        this.psappmodulenameDirtyFlag = true;
    }

    public String getPSAppModuleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppModuleName();
        }
        return this.psappmodulename;
    }

    public boolean isPSAppModuleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppModuleNameDirty();
        }
        return this.psappmodulenameDirtyFlag;
    }

    public void resetPSAppModuleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppModuleName();
            return;
        }
        this.psappmodulenameDirtyFlag = false;
        this.psappmodulename = null;
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

    public void setPSDEServiceAPIId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEServiceAPIId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeserviceapiid = string;
        this.psdeserviceapiidDirtyFlag = true;
    }

    public String getPSDEServiceAPIId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEServiceAPIId();
        }
        return this.psdeserviceapiid;
    }

    public boolean isPSDEServiceAPIIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEServiceAPIIdDirty();
        }
        return this.psdeserviceapiidDirtyFlag;
    }

    public void resetPSDEServiceAPIId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEServiceAPIId();
            return;
        }
        this.psdeserviceapiidDirtyFlag = false;
        this.psdeserviceapiid = null;
    }

    public void setPSDEServiceAPIName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEServiceAPIName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeserviceapiname = string;
        this.psdeserviceapinameDirtyFlag = true;
    }

    public String getPSDEServiceAPIName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEServiceAPIName();
        }
        return this.psdeserviceapiname;
    }

    public boolean isPSDEServiceAPINameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEServiceAPINameDirty();
        }
        return this.psdeserviceapinameDirtyFlag;
    }

    public void resetPSDEServiceAPIName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEServiceAPIName();
            return;
        }
        this.psdeserviceapinameDirtyFlag = false;
        this.psdeserviceapiname = null;
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

    public void setPSSysAppId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAppId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysappid = string;
        this.pssysappidDirtyFlag = true;
    }

    public String getPSSysAppId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAppId();
        }
        return this.pssysappid;
    }

    public boolean isPSSysAppIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAppIdDirty();
        }
        return this.pssysappidDirtyFlag;
    }

    public void resetPSSysAppId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAppId();
            return;
        }
        this.pssysappidDirtyFlag = false;
        this.pssysappid = null;
    }

    public void setPSSysAppName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAppName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysappname = string;
        this.pssysappnameDirtyFlag = true;
    }

    public String getPSSysAppName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAppName();
        }
        return this.pssysappname;
    }

    public boolean isPSSysAppNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAppNameDirty();
        }
        return this.pssysappnameDirtyFlag;
    }

    public void resetPSSysAppName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAppName();
            return;
        }
        this.pssysappnameDirtyFlag = false;
        this.pssysappname = null;
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

    public void setPSSysServiceAPIId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysServiceAPIId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysserviceapiid = string;
        this.pssysserviceapiidDirtyFlag = true;
    }

    public String getPSSysServiceAPIId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysServiceAPIId();
        }
        return this.pssysserviceapiid;
    }

    public boolean isPSSysServiceAPIIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysServiceAPIIdDirty();
        }
        return this.pssysserviceapiidDirtyFlag;
    }

    public void resetPSSysServiceAPIId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysServiceAPIId();
            return;
        }
        this.pssysserviceapiidDirtyFlag = false;
        this.pssysserviceapiid = null;
    }

    public void setPSSysServiceAPIName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysServiceAPIName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysserviceapiname = string;
        this.pssysserviceapinameDirtyFlag = true;
    }

    public String getPSSysServiceAPIName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysServiceAPIName();
        }
        return this.pssysserviceapiname;
    }

    public boolean isPSSysServiceAPINameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysServiceAPINameDirty();
        }
        return this.pssysserviceapinameDirtyFlag;
    }

    public void resetPSSysServiceAPIName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysServiceAPIName();
            return;
        }
        this.pssysserviceapinameDirtyFlag = false;
        this.pssysserviceapiname = null;
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

    public void setPSSysUniResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUniResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysuniresid = string;
        this.pssysuniresidDirtyFlag = true;
    }

    public String getPSSysUniResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUniResId();
        }
        return this.pssysuniresid;
    }

    public boolean isPSSysUniResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUniResIdDirty();
        }
        return this.pssysuniresidDirtyFlag;
    }

    public void resetPSSysUniResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUniResId();
            return;
        }
        this.pssysuniresidDirtyFlag = false;
        this.pssysuniresid = null;
    }

    public void setPSSysUniResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUniResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysuniresname = string;
        this.pssysuniresnameDirtyFlag = true;
    }

    public String getPSSysUniResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUniResName();
        }
        return this.pssysuniresname;
    }

    public boolean isPSSysUniResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUniResNameDirty();
        }
        return this.pssysuniresnameDirtyFlag;
    }

    public void resetPSSysUniResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUniResName();
            return;
        }
        this.pssysuniresnameDirtyFlag = false;
        this.pssysuniresname = null;
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

    public void setUserAction(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserAction(n);
            return;
        }
        this.useraction = n;
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
        PSAppLocalDEBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSAppLocalDEBase pSAppLocalDEBase) {
        pSAppLocalDEBase.resetAccCtrlArch();
        pSAppLocalDEBase.resetAutoAddMethodMode();
        pSAppLocalDEBase.resetAutoAddViewMode();
        pSAppLocalDEBase.resetBaseClsParams();
        pSAppLocalDEBase.resetCodeName();
        pSAppLocalDEBase.resetCodeName2();
        pSAppLocalDEBase.resetCreateDate();
        pSAppLocalDEBase.resetCreateMan();
        pSAppLocalDEBase.resetCustomUserAction();
        pSAppLocalDEBase.resetDataAccMode();
        pSAppLocalDEBase.resetDECodeName();
        pSAppLocalDEBase.resetDefaultFlag();
        pSAppLocalDEBase.resetDEFGroupMode();
        pSAppLocalDEBase.resetDELogicName();
        pSAppLocalDEBase.resetEnableStorage();
        pSAppLocalDEBase.resetLinkPSDEViewId();
        pSAppLocalDEBase.resetLinkPSDEViewName();
        pSAppLocalDEBase.resetLNPSLanResId();
        pSAppLocalDEBase.resetLNPSLanResName();
        pSAppLocalDEBase.resetLogicName();
        pSAppLocalDEBase.resetMajorFlag();
        pSAppLocalDEBase.resetMDPSDEViewId();
        pSAppLocalDEBase.resetMDPSDEViewName();
        pSAppLocalDEBase.resetMemo();
        pSAppLocalDEBase.resetPPSAppLocalDEId();
        pSAppLocalDEBase.resetPPSAppLocalDEName();
        pSAppLocalDEBase.resetPSAppLocalDEId();
        pSAppLocalDEBase.resetPSAppLocalDEName();
        pSAppLocalDEBase.resetPSAppModuleId();
        pSAppLocalDEBase.resetPSAppModuleName();
        pSAppLocalDEBase.resetPSDEFGroupId();
        pSAppLocalDEBase.resetPSDEFGroupName();
        pSAppLocalDEBase.resetPSDEId();
        pSAppLocalDEBase.resetPSDEName();
        pSAppLocalDEBase.resetPSDERId();
        pSAppLocalDEBase.resetPSDERName();
        pSAppLocalDEBase.resetPSDEServiceAPIId();
        pSAppLocalDEBase.resetPSDEServiceAPIName();
        pSAppLocalDEBase.resetPSModuleId();
        pSAppLocalDEBase.resetPSSysAppId();
        pSAppLocalDEBase.resetPSSysAppName();
        pSAppLocalDEBase.resetPSSysDynaModelId();
        pSAppLocalDEBase.resetPSSysDynaModelName();
        pSAppLocalDEBase.resetPSSysReqItemId();
        pSAppLocalDEBase.resetPSSysReqItemName();
        pSAppLocalDEBase.resetPSSysServiceAPIId();
        pSAppLocalDEBase.resetPSSysServiceAPIName();
        pSAppLocalDEBase.resetPSSysSFPluginId();
        pSAppLocalDEBase.resetPSSysSFPluginName();
        pSAppLocalDEBase.resetPSSysUniResId();
        pSAppLocalDEBase.resetPSSysUniResName();
        pSAppLocalDEBase.resetSDPSDEViewID();
        pSAppLocalDEBase.resetSDPSDEViewName();
        pSAppLocalDEBase.resetUpdateDate();
        pSAppLocalDEBase.resetUpdateMan();
        pSAppLocalDEBase.resetUserAction();
        pSAppLocalDEBase.resetUserCat();
        pSAppLocalDEBase.resetUserTag();
        pSAppLocalDEBase.resetUserTag2();
        pSAppLocalDEBase.resetUserTag3();
        pSAppLocalDEBase.resetUserTag4();
        pSAppLocalDEBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAccCtrlArchDirty()) {
            hashMap.put(FIELD_ACCCTRLARCH, this.getAccCtrlArch());
        }
        if (!bl || this.isAutoAddMethodModeDirty()) {
            hashMap.put(FIELD_AUTOADDMETHODMODE, this.getAutoAddMethodMode());
        }
        if (!bl || this.isAutoAddViewModeDirty()) {
            hashMap.put(FIELD_AUTOADDVIEWMODE, this.getAutoAddViewMode());
        }
        if (!bl || this.isBaseClsParamsDirty()) {
            hashMap.put(FIELD_BASECLSPARAMS, this.getBaseClsParams());
        }
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isCodeName2Dirty()) {
            hashMap.put(FIELD_CODENAME2, this.getCodeName2());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCustomUserActionDirty()) {
            hashMap.put(FIELD_CUSTOMUSERACTION, this.getCustomUserAction());
        }
        if (!bl || this.isDataAccModeDirty()) {
            hashMap.put(FIELD_DATAACCMODE, this.getDataAccMode());
        }
        if (!bl || this.isDECodeNameDirty()) {
            hashMap.put(FIELD_DECODENAME, this.getDECodeName());
        }
        if (!bl || this.isDefaultFlagDirty()) {
            hashMap.put(FIELD_DEFAULTFLAG, this.getDefaultFlag());
        }
        if (!bl || this.isDEFGroupModeDirty()) {
            hashMap.put(FIELD_DEFGROUPMODE, this.getDEFGroupMode());
        }
        if (!bl || this.isDELogicNameDirty()) {
            hashMap.put(FIELD_DELOGICNAME, this.getDELogicName());
        }
        if (!bl || this.isEnableStorageDirty()) {
            hashMap.put(FIELD_ENABLESTORAGE, this.getEnableStorage());
        }
        if (!bl || this.isLinkPSDEViewIdDirty()) {
            hashMap.put(FIELD_LINKPSDEVIEWID, this.getLinkPSDEViewId());
        }
        if (!bl || this.isLinkPSDEViewNameDirty()) {
            hashMap.put(FIELD_LINKPSDEVIEWNAME, this.getLinkPSDEViewName());
        }
        if (!bl || this.isLNPSLanResIdDirty()) {
            hashMap.put(FIELD_LNPSLANRESID, this.getLNPSLanResId());
        }
        if (!bl || this.isLNPSLanResNameDirty()) {
            hashMap.put(FIELD_LNPSLANRESNAME, this.getLNPSLanResName());
        }
        if (!bl || this.isLogicNameDirty()) {
            hashMap.put(FIELD_LOGICNAME, this.getLogicName());
        }
        if (!bl || this.isMajorFlagDirty()) {
            hashMap.put(FIELD_MAJORFLAG, this.getMajorFlag());
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
        if (!bl || this.isPPSAppLocalDEIdDirty()) {
            hashMap.put(FIELD_PPSAPPLOCALDEID, this.getPPSAppLocalDEId());
        }
        if (!bl || this.isPPSAppLocalDENameDirty()) {
            hashMap.put(FIELD_PPSAPPLOCALDENAME, this.getPPSAppLocalDEName());
        }
        if (!bl || this.isPSAppLocalDEIdDirty()) {
            hashMap.put(FIELD_PSAPPLOCALDEID, this.getPSAppLocalDEId());
        }
        if (!bl || this.isPSAppLocalDENameDirty()) {
            hashMap.put(FIELD_PSAPPLOCALDENAME, this.getPSAppLocalDEName());
        }
        if (!bl || this.isPSAppModuleIdDirty()) {
            hashMap.put(FIELD_PSAPPMODULEID, this.getPSAppModuleId());
        }
        if (!bl || this.isPSAppModuleNameDirty()) {
            hashMap.put(FIELD_PSAPPMODULENAME, this.getPSAppModuleName());
        }
        if (!bl || this.isPSDEFGroupIdDirty()) {
            hashMap.put(FIELD_PSDEFGROUPID, this.getPSDEFGroupId());
        }
        if (!bl || this.isPSDEFGroupNameDirty()) {
            hashMap.put(FIELD_PSDEFGROUPNAME, this.getPSDEFGroupName());
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
        if (!bl || this.isPSDEServiceAPIIdDirty()) {
            hashMap.put(FIELD_PSDESERVICEAPIID, this.getPSDEServiceAPIId());
        }
        if (!bl || this.isPSDEServiceAPINameDirty()) {
            hashMap.put(FIELD_PSDESERVICEAPINAME, this.getPSDEServiceAPIName());
        }
        if (!bl || this.isPSModuleIdDirty()) {
            hashMap.put(FIELD_PSMODULEID, this.getPSModuleId());
        }
        if (!bl || this.isPSSysAppIdDirty()) {
            hashMap.put(FIELD_PSSYSAPPID, this.getPSSysAppId());
        }
        if (!bl || this.isPSSysAppNameDirty()) {
            hashMap.put(FIELD_PSSYSAPPNAME, this.getPSSysAppName());
        }
        if (!bl || this.isPSSysDynaModelIdDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELID, this.getPSSysDynaModelId());
        }
        if (!bl || this.isPSSysDynaModelNameDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELNAME, this.getPSSysDynaModelName());
        }
        if (!bl || this.isPSSysReqItemIdDirty()) {
            hashMap.put(FIELD_PSSYSREQITEMID, this.getPSSysReqItemId());
        }
        if (!bl || this.isPSSysReqItemNameDirty()) {
            hashMap.put(FIELD_PSSYSREQITEMNAME, this.getPSSysReqItemName());
        }
        if (!bl || this.isPSSysServiceAPIIdDirty()) {
            hashMap.put(FIELD_PSSYSSERVICEAPIID, this.getPSSysServiceAPIId());
        }
        if (!bl || this.isPSSysServiceAPINameDirty()) {
            hashMap.put(FIELD_PSSYSSERVICEAPINAME, this.getPSSysServiceAPIName());
        }
        if (!bl || this.isPSSysSFPluginIdDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINID, this.getPSSysSFPluginId());
        }
        if (!bl || this.isPSSysSFPluginNameDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINNAME, this.getPSSysSFPluginName());
        }
        if (!bl || this.isPSSysUniResIdDirty()) {
            hashMap.put(FIELD_PSSYSUNIRESID, this.getPSSysUniResId());
        }
        if (!bl || this.isPSSysUniResNameDirty()) {
            hashMap.put(FIELD_PSSYSUNIRESNAME, this.getPSSysUniResName());
        }
        if (!bl || this.isSDPSDEViewIDDirty()) {
            hashMap.put(FIELD_SDPSDEVIEWID, this.getSDPSDEViewID());
        }
        if (!bl || this.isSDPSDEViewNameDirty()) {
            hashMap.put(FIELD_SDPSDEVIEWNAME, this.getSDPSDEViewName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserActionDirty()) {
            hashMap.put(FIELD_USERACTION, this.getUserAction());
        }
        if (!bl || this.isUserCatDirty()) {
            hashMap.put(FIELD_USERCAT, this.getUserCat());
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
        return PSAppLocalDEBase.get(this, n);
    }

    private static Object get(PSAppLocalDEBase pSAppLocalDEBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppLocalDEBase.getAccCtrlArch();
            }
            case 1: {
                return pSAppLocalDEBase.getAutoAddMethodMode();
            }
            case 2: {
                return pSAppLocalDEBase.getAutoAddViewMode();
            }
            case 3: {
                return pSAppLocalDEBase.getBaseClsParams();
            }
            case 4: {
                return pSAppLocalDEBase.getCodeName();
            }
            case 5: {
                return pSAppLocalDEBase.getCodeName2();
            }
            case 6: {
                return pSAppLocalDEBase.getCreateDate();
            }
            case 7: {
                return pSAppLocalDEBase.getCreateMan();
            }
            case 8: {
                return pSAppLocalDEBase.getCustomUserAction();
            }
            case 9: {
                return pSAppLocalDEBase.getDataAccMode();
            }
            case 10: {
                return pSAppLocalDEBase.getDECodeName();
            }
            case 11: {
                return pSAppLocalDEBase.getDefaultFlag();
            }
            case 12: {
                return pSAppLocalDEBase.getDEFGroupMode();
            }
            case 13: {
                return pSAppLocalDEBase.getDELogicName();
            }
            case 14: {
                return pSAppLocalDEBase.getEnableStorage();
            }
            case 15: {
                return pSAppLocalDEBase.getLinkPSDEViewId();
            }
            case 16: {
                return pSAppLocalDEBase.getLinkPSDEViewName();
            }
            case 17: {
                return pSAppLocalDEBase.getLNPSLanResId();
            }
            case 18: {
                return pSAppLocalDEBase.getLNPSLanResName();
            }
            case 19: {
                return pSAppLocalDEBase.getLogicName();
            }
            case 20: {
                return pSAppLocalDEBase.getMajorFlag();
            }
            case 21: {
                return pSAppLocalDEBase.getMDPSDEViewId();
            }
            case 22: {
                return pSAppLocalDEBase.getMDPSDEViewName();
            }
            case 23: {
                return pSAppLocalDEBase.getMemo();
            }
            case 24: {
                return pSAppLocalDEBase.getPPSAppLocalDEId();
            }
            case 25: {
                return pSAppLocalDEBase.getPPSAppLocalDEName();
            }
            case 26: {
                return pSAppLocalDEBase.getPSAppLocalDEId();
            }
            case 27: {
                return pSAppLocalDEBase.getPSAppLocalDEName();
            }
            case 28: {
                return pSAppLocalDEBase.getPSAppModuleId();
            }
            case 29: {
                return pSAppLocalDEBase.getPSAppModuleName();
            }
            case 30: {
                return pSAppLocalDEBase.getPSDEFGroupId();
            }
            case 31: {
                return pSAppLocalDEBase.getPSDEFGroupName();
            }
            case 32: {
                return pSAppLocalDEBase.getPSDEId();
            }
            case 33: {
                return pSAppLocalDEBase.getPSDEName();
            }
            case 34: {
                return pSAppLocalDEBase.getPSDERId();
            }
            case 35: {
                return pSAppLocalDEBase.getPSDERName();
            }
            case 36: {
                return pSAppLocalDEBase.getPSDEServiceAPIId();
            }
            case 37: {
                return pSAppLocalDEBase.getPSDEServiceAPIName();
            }
            case 38: {
                return pSAppLocalDEBase.getPSModuleId();
            }
            case 39: {
                return pSAppLocalDEBase.getPSSysAppId();
            }
            case 40: {
                return pSAppLocalDEBase.getPSSysAppName();
            }
            case 41: {
                return pSAppLocalDEBase.getPSSysDynaModelId();
            }
            case 42: {
                return pSAppLocalDEBase.getPSSysDynaModelName();
            }
            case 43: {
                return pSAppLocalDEBase.getPSSysReqItemId();
            }
            case 44: {
                return pSAppLocalDEBase.getPSSysReqItemName();
            }
            case 45: {
                return pSAppLocalDEBase.getPSSysServiceAPIId();
            }
            case 46: {
                return pSAppLocalDEBase.getPSSysServiceAPIName();
            }
            case 47: {
                return pSAppLocalDEBase.getPSSysSFPluginId();
            }
            case 48: {
                return pSAppLocalDEBase.getPSSysSFPluginName();
            }
            case 49: {
                return pSAppLocalDEBase.getPSSysUniResId();
            }
            case 50: {
                return pSAppLocalDEBase.getPSSysUniResName();
            }
            case 51: {
                return pSAppLocalDEBase.getSDPSDEViewID();
            }
            case 52: {
                return pSAppLocalDEBase.getSDPSDEViewName();
            }
            case 53: {
                return pSAppLocalDEBase.getUpdateDate();
            }
            case 54: {
                return pSAppLocalDEBase.getUpdateMan();
            }
            case 55: {
                return pSAppLocalDEBase.getUserAction();
            }
            case 56: {
                return pSAppLocalDEBase.getUserCat();
            }
            case 57: {
                return pSAppLocalDEBase.getUserTag();
            }
            case 58: {
                return pSAppLocalDEBase.getUserTag2();
            }
            case 59: {
                return pSAppLocalDEBase.getUserTag3();
            }
            case 60: {
                return pSAppLocalDEBase.getUserTag4();
            }
            case 61: {
                return pSAppLocalDEBase.getValidFlag();
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
        PSAppLocalDEBase.set(this, n, object);
    }

    private static void set(PSAppLocalDEBase pSAppLocalDEBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSAppLocalDEBase.setAccCtrlArch(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSAppLocalDEBase.setAutoAddMethodMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 2: {
                pSAppLocalDEBase.setAutoAddViewMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSAppLocalDEBase.setBaseClsParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSAppLocalDEBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSAppLocalDEBase.setCodeName2(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSAppLocalDEBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSAppLocalDEBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSAppLocalDEBase.setCustomUserAction(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSAppLocalDEBase.setDataAccMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSAppLocalDEBase.setDECodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSAppLocalDEBase.setDefaultFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSAppLocalDEBase.setDEFGroupMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSAppLocalDEBase.setDELogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSAppLocalDEBase.setEnableStorage(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSAppLocalDEBase.setLinkPSDEViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSAppLocalDEBase.setLinkPSDEViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSAppLocalDEBase.setLNPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSAppLocalDEBase.setLNPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSAppLocalDEBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSAppLocalDEBase.setMajorFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 21: {
                pSAppLocalDEBase.setMDPSDEViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSAppLocalDEBase.setMDPSDEViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSAppLocalDEBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSAppLocalDEBase.setPPSAppLocalDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSAppLocalDEBase.setPPSAppLocalDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSAppLocalDEBase.setPSAppLocalDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSAppLocalDEBase.setPSAppLocalDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSAppLocalDEBase.setPSAppModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSAppLocalDEBase.setPSAppModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSAppLocalDEBase.setPSDEFGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSAppLocalDEBase.setPSDEFGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSAppLocalDEBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSAppLocalDEBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSAppLocalDEBase.setPSDERId(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSAppLocalDEBase.setPSDERName(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSAppLocalDEBase.setPSDEServiceAPIId(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSAppLocalDEBase.setPSDEServiceAPIName(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSAppLocalDEBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSAppLocalDEBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSAppLocalDEBase.setPSSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSAppLocalDEBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSAppLocalDEBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSAppLocalDEBase.setPSSysReqItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSAppLocalDEBase.setPSSysReqItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSAppLocalDEBase.setPSSysServiceAPIId(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSAppLocalDEBase.setPSSysServiceAPIName(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSAppLocalDEBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSAppLocalDEBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSAppLocalDEBase.setPSSysUniResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSAppLocalDEBase.setPSSysUniResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSAppLocalDEBase.setSDPSDEViewID(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSAppLocalDEBase.setSDPSDEViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 53: {
                pSAppLocalDEBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 54: {
                pSAppLocalDEBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 55: {
                pSAppLocalDEBase.setUserAction(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 56: {
                pSAppLocalDEBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 57: {
                pSAppLocalDEBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 58: {
                pSAppLocalDEBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 59: {
                pSAppLocalDEBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 60: {
                pSAppLocalDEBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 61: {
                pSAppLocalDEBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSAppLocalDEBase.isNull(this, n);
    }

    private static boolean isNull(PSAppLocalDEBase pSAppLocalDEBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppLocalDEBase.getAccCtrlArch() == null;
            }
            case 1: {
                return pSAppLocalDEBase.getAutoAddMethodMode() == null;
            }
            case 2: {
                return pSAppLocalDEBase.getAutoAddViewMode() == null;
            }
            case 3: {
                return pSAppLocalDEBase.getBaseClsParams() == null;
            }
            case 4: {
                return pSAppLocalDEBase.getCodeName() == null;
            }
            case 5: {
                return pSAppLocalDEBase.getCodeName2() == null;
            }
            case 6: {
                return pSAppLocalDEBase.getCreateDate() == null;
            }
            case 7: {
                return pSAppLocalDEBase.getCreateMan() == null;
            }
            case 8: {
                return pSAppLocalDEBase.getCustomUserAction() == null;
            }
            case 9: {
                return pSAppLocalDEBase.getDataAccMode() == null;
            }
            case 10: {
                return pSAppLocalDEBase.getDECodeName() == null;
            }
            case 11: {
                return pSAppLocalDEBase.getDefaultFlag() == null;
            }
            case 12: {
                return pSAppLocalDEBase.getDEFGroupMode() == null;
            }
            case 13: {
                return pSAppLocalDEBase.getDELogicName() == null;
            }
            case 14: {
                return pSAppLocalDEBase.getEnableStorage() == null;
            }
            case 15: {
                return pSAppLocalDEBase.getLinkPSDEViewId() == null;
            }
            case 16: {
                return pSAppLocalDEBase.getLinkPSDEViewName() == null;
            }
            case 17: {
                return pSAppLocalDEBase.getLNPSLanResId() == null;
            }
            case 18: {
                return pSAppLocalDEBase.getLNPSLanResName() == null;
            }
            case 19: {
                return pSAppLocalDEBase.getLogicName() == null;
            }
            case 20: {
                return pSAppLocalDEBase.getMajorFlag() == null;
            }
            case 21: {
                return pSAppLocalDEBase.getMDPSDEViewId() == null;
            }
            case 22: {
                return pSAppLocalDEBase.getMDPSDEViewName() == null;
            }
            case 23: {
                return pSAppLocalDEBase.getMemo() == null;
            }
            case 24: {
                return pSAppLocalDEBase.getPPSAppLocalDEId() == null;
            }
            case 25: {
                return pSAppLocalDEBase.getPPSAppLocalDEName() == null;
            }
            case 26: {
                return pSAppLocalDEBase.getPSAppLocalDEId() == null;
            }
            case 27: {
                return pSAppLocalDEBase.getPSAppLocalDEName() == null;
            }
            case 28: {
                return pSAppLocalDEBase.getPSAppModuleId() == null;
            }
            case 29: {
                return pSAppLocalDEBase.getPSAppModuleName() == null;
            }
            case 30: {
                return pSAppLocalDEBase.getPSDEFGroupId() == null;
            }
            case 31: {
                return pSAppLocalDEBase.getPSDEFGroupName() == null;
            }
            case 32: {
                return pSAppLocalDEBase.getPSDEId() == null;
            }
            case 33: {
                return pSAppLocalDEBase.getPSDEName() == null;
            }
            case 34: {
                return pSAppLocalDEBase.getPSDERId() == null;
            }
            case 35: {
                return pSAppLocalDEBase.getPSDERName() == null;
            }
            case 36: {
                return pSAppLocalDEBase.getPSDEServiceAPIId() == null;
            }
            case 37: {
                return pSAppLocalDEBase.getPSDEServiceAPIName() == null;
            }
            case 38: {
                return pSAppLocalDEBase.getPSModuleId() == null;
            }
            case 39: {
                return pSAppLocalDEBase.getPSSysAppId() == null;
            }
            case 40: {
                return pSAppLocalDEBase.getPSSysAppName() == null;
            }
            case 41: {
                return pSAppLocalDEBase.getPSSysDynaModelId() == null;
            }
            case 42: {
                return pSAppLocalDEBase.getPSSysDynaModelName() == null;
            }
            case 43: {
                return pSAppLocalDEBase.getPSSysReqItemId() == null;
            }
            case 44: {
                return pSAppLocalDEBase.getPSSysReqItemName() == null;
            }
            case 45: {
                return pSAppLocalDEBase.getPSSysServiceAPIId() == null;
            }
            case 46: {
                return pSAppLocalDEBase.getPSSysServiceAPIName() == null;
            }
            case 47: {
                return pSAppLocalDEBase.getPSSysSFPluginId() == null;
            }
            case 48: {
                return pSAppLocalDEBase.getPSSysSFPluginName() == null;
            }
            case 49: {
                return pSAppLocalDEBase.getPSSysUniResId() == null;
            }
            case 50: {
                return pSAppLocalDEBase.getPSSysUniResName() == null;
            }
            case 51: {
                return pSAppLocalDEBase.getSDPSDEViewID() == null;
            }
            case 52: {
                return pSAppLocalDEBase.getSDPSDEViewName() == null;
            }
            case 53: {
                return pSAppLocalDEBase.getUpdateDate() == null;
            }
            case 54: {
                return pSAppLocalDEBase.getUpdateMan() == null;
            }
            case 55: {
                return pSAppLocalDEBase.getUserAction() == null;
            }
            case 56: {
                return pSAppLocalDEBase.getUserCat() == null;
            }
            case 57: {
                return pSAppLocalDEBase.getUserTag() == null;
            }
            case 58: {
                return pSAppLocalDEBase.getUserTag2() == null;
            }
            case 59: {
                return pSAppLocalDEBase.getUserTag3() == null;
            }
            case 60: {
                return pSAppLocalDEBase.getUserTag4() == null;
            }
            case 61: {
                return pSAppLocalDEBase.getValidFlag() == null;
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
        return PSAppLocalDEBase.contains(this, n);
    }

    private static boolean contains(PSAppLocalDEBase pSAppLocalDEBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppLocalDEBase.isAccCtrlArchDirty();
            }
            case 1: {
                return pSAppLocalDEBase.isAutoAddMethodModeDirty();
            }
            case 2: {
                return pSAppLocalDEBase.isAutoAddViewModeDirty();
            }
            case 3: {
                return pSAppLocalDEBase.isBaseClsParamsDirty();
            }
            case 4: {
                return pSAppLocalDEBase.isCodeNameDirty();
            }
            case 5: {
                return pSAppLocalDEBase.isCodeName2Dirty();
            }
            case 6: {
                return pSAppLocalDEBase.isCreateDateDirty();
            }
            case 7: {
                return pSAppLocalDEBase.isCreateManDirty();
            }
            case 8: {
                return pSAppLocalDEBase.isCustomUserActionDirty();
            }
            case 9: {
                return pSAppLocalDEBase.isDataAccModeDirty();
            }
            case 10: {
                return pSAppLocalDEBase.isDECodeNameDirty();
            }
            case 11: {
                return pSAppLocalDEBase.isDefaultFlagDirty();
            }
            case 12: {
                return pSAppLocalDEBase.isDEFGroupModeDirty();
            }
            case 13: {
                return pSAppLocalDEBase.isDELogicNameDirty();
            }
            case 14: {
                return pSAppLocalDEBase.isEnableStorageDirty();
            }
            case 15: {
                return pSAppLocalDEBase.isLinkPSDEViewIdDirty();
            }
            case 16: {
                return pSAppLocalDEBase.isLinkPSDEViewNameDirty();
            }
            case 17: {
                return pSAppLocalDEBase.isLNPSLanResIdDirty();
            }
            case 18: {
                return pSAppLocalDEBase.isLNPSLanResNameDirty();
            }
            case 19: {
                return pSAppLocalDEBase.isLogicNameDirty();
            }
            case 20: {
                return pSAppLocalDEBase.isMajorFlagDirty();
            }
            case 21: {
                return pSAppLocalDEBase.isMDPSDEViewIdDirty();
            }
            case 22: {
                return pSAppLocalDEBase.isMDPSDEViewNameDirty();
            }
            case 23: {
                return pSAppLocalDEBase.isMemoDirty();
            }
            case 24: {
                return pSAppLocalDEBase.isPPSAppLocalDEIdDirty();
            }
            case 25: {
                return pSAppLocalDEBase.isPPSAppLocalDENameDirty();
            }
            case 26: {
                return pSAppLocalDEBase.isPSAppLocalDEIdDirty();
            }
            case 27: {
                return pSAppLocalDEBase.isPSAppLocalDENameDirty();
            }
            case 28: {
                return pSAppLocalDEBase.isPSAppModuleIdDirty();
            }
            case 29: {
                return pSAppLocalDEBase.isPSAppModuleNameDirty();
            }
            case 30: {
                return pSAppLocalDEBase.isPSDEFGroupIdDirty();
            }
            case 31: {
                return pSAppLocalDEBase.isPSDEFGroupNameDirty();
            }
            case 32: {
                return pSAppLocalDEBase.isPSDEIdDirty();
            }
            case 33: {
                return pSAppLocalDEBase.isPSDENameDirty();
            }
            case 34: {
                return pSAppLocalDEBase.isPSDERIdDirty();
            }
            case 35: {
                return pSAppLocalDEBase.isPSDERNameDirty();
            }
            case 36: {
                return pSAppLocalDEBase.isPSDEServiceAPIIdDirty();
            }
            case 37: {
                return pSAppLocalDEBase.isPSDEServiceAPINameDirty();
            }
            case 38: {
                return pSAppLocalDEBase.isPSModuleIdDirty();
            }
            case 39: {
                return pSAppLocalDEBase.isPSSysAppIdDirty();
            }
            case 40: {
                return pSAppLocalDEBase.isPSSysAppNameDirty();
            }
            case 41: {
                return pSAppLocalDEBase.isPSSysDynaModelIdDirty();
            }
            case 42: {
                return pSAppLocalDEBase.isPSSysDynaModelNameDirty();
            }
            case 43: {
                return pSAppLocalDEBase.isPSSysReqItemIdDirty();
            }
            case 44: {
                return pSAppLocalDEBase.isPSSysReqItemNameDirty();
            }
            case 45: {
                return pSAppLocalDEBase.isPSSysServiceAPIIdDirty();
            }
            case 46: {
                return pSAppLocalDEBase.isPSSysServiceAPINameDirty();
            }
            case 47: {
                return pSAppLocalDEBase.isPSSysSFPluginIdDirty();
            }
            case 48: {
                return pSAppLocalDEBase.isPSSysSFPluginNameDirty();
            }
            case 49: {
                return pSAppLocalDEBase.isPSSysUniResIdDirty();
            }
            case 50: {
                return pSAppLocalDEBase.isPSSysUniResNameDirty();
            }
            case 51: {
                return pSAppLocalDEBase.isSDPSDEViewIDDirty();
            }
            case 52: {
                return pSAppLocalDEBase.isSDPSDEViewNameDirty();
            }
            case 53: {
                return pSAppLocalDEBase.isUpdateDateDirty();
            }
            case 54: {
                return pSAppLocalDEBase.isUpdateManDirty();
            }
            case 55: {
                return pSAppLocalDEBase.isUserActionDirty();
            }
            case 56: {
                return pSAppLocalDEBase.isUserCatDirty();
            }
            case 57: {
                return pSAppLocalDEBase.isUserTagDirty();
            }
            case 58: {
                return pSAppLocalDEBase.isUserTag2Dirty();
            }
            case 59: {
                return pSAppLocalDEBase.isUserTag3Dirty();
            }
            case 60: {
                return pSAppLocalDEBase.isUserTag4Dirty();
            }
            case 61: {
                return pSAppLocalDEBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSAppLocalDEBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSAppLocalDEBase pSAppLocalDEBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSAppLocalDEBase.getAccCtrlArch() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"accctrlarch", (Object)PSAppLocalDEBase.getJSONValue((Object)pSAppLocalDEBase.getAccCtrlArch()), (boolean)false);
        }
        if (bl || pSAppLocalDEBase.getAutoAddMethodMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"autoaddmethodmode", (Object)PSAppLocalDEBase.getJSONValue((Object)pSAppLocalDEBase.getAutoAddMethodMode()), (boolean)false);
        }
        if (bl || pSAppLocalDEBase.getAutoAddViewMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"autoaddviewmode", (Object)PSAppLocalDEBase.getJSONValue((Object)pSAppLocalDEBase.getAutoAddViewMode()), (boolean)false);
        }
        if (bl || pSAppLocalDEBase.getBaseClsParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"baseclsparams", (Object)PSAppLocalDEBase.getJSONValue((Object)pSAppLocalDEBase.getBaseClsParams()), (boolean)false);
        }
        if (bl || pSAppLocalDEBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSAppLocalDEBase.getJSONValue((Object)pSAppLocalDEBase.getCodeName()), (boolean)false);
        }
        if (bl || pSAppLocalDEBase.getCodeName2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename2", (Object)PSAppLocalDEBase.getJSONValue((Object)pSAppLocalDEBase.getCodeName2()), (boolean)false);
        }
        if (bl || pSAppLocalDEBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSAppLocalDEBase.getJSONValue((Object)pSAppLocalDEBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSAppLocalDEBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSAppLocalDEBase.getJSONValue((Object)pSAppLocalDEBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSAppLocalDEBase.getCustomUserAction() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customuseraction", (Object)PSAppLocalDEBase.getJSONValue((Object)pSAppLocalDEBase.getCustomUserAction()), (boolean)false);
        }
        if (bl || pSAppLocalDEBase.getDataAccMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dataaccmode", (Object)PSAppLocalDEBase.getJSONValue((Object)pSAppLocalDEBase.getDataAccMode()), (boolean)false);
        }
        if (bl || pSAppLocalDEBase.getDECodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"decodename", (Object)PSAppLocalDEBase.getJSONValue((Object)pSAppLocalDEBase.getDECodeName()), (boolean)false);
        }
        if (bl || pSAppLocalDEBase.getDefaultFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultflag", (Object)PSAppLocalDEBase.getJSONValue((Object)pSAppLocalDEBase.getDefaultFlag()), (boolean)false);
        }
        if (bl || pSAppLocalDEBase.getDEFGroupMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defgroupmode", (Object)PSAppLocalDEBase.getJSONValue((Object)pSAppLocalDEBase.getDEFGroupMode()), (boolean)false);
        }
        if (bl || pSAppLocalDEBase.getDELogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"delogicname", (Object)PSAppLocalDEBase.getJSONValue((Object)pSAppLocalDEBase.getDELogicName()), (boolean)false);
        }
        if (bl || pSAppLocalDEBase.getEnableStorage() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablestorage", (Object)PSAppLocalDEBase.getJSONValue((Object)pSAppLocalDEBase.getEnableStorage()), (boolean)false);
        }
        if (bl || pSAppLocalDEBase.getLinkPSDEViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"linkpsdeviewid", (Object)PSAppLocalDEBase.getJSONValue((Object)pSAppLocalDEBase.getLinkPSDEViewId()), (boolean)false);
        }
        if (bl || pSAppLocalDEBase.getLinkPSDEViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"linkpsdeviewname", (Object)PSAppLocalDEBase.getJSONValue((Object)pSAppLocalDEBase.getLinkPSDEViewName()), (boolean)false);
        }
        if (bl || pSAppLocalDEBase.getLNPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lnpslanresid", (Object)PSAppLocalDEBase.getJSONValue((Object)pSAppLocalDEBase.getLNPSLanResId()), (boolean)false);
        }
        if (bl || pSAppLocalDEBase.getLNPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lnpslanresname", (Object)PSAppLocalDEBase.getJSONValue((Object)pSAppLocalDEBase.getLNPSLanResName()), (boolean)false);
        }
        if (bl || pSAppLocalDEBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSAppLocalDEBase.getJSONValue((Object)pSAppLocalDEBase.getLogicName()), (boolean)false);
        }
        if (bl || pSAppLocalDEBase.getMajorFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"majorflag", (Object)PSAppLocalDEBase.getJSONValue((Object)pSAppLocalDEBase.getMajorFlag()), (boolean)false);
        }
        if (bl || pSAppLocalDEBase.getMDPSDEViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mdpsdeviewid", (Object)PSAppLocalDEBase.getJSONValue((Object)pSAppLocalDEBase.getMDPSDEViewId()), (boolean)false);
        }
        if (bl || pSAppLocalDEBase.getMDPSDEViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mdpsdeviewname", (Object)PSAppLocalDEBase.getJSONValue((Object)pSAppLocalDEBase.getMDPSDEViewName()), (boolean)false);
        }
        if (bl || pSAppLocalDEBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSAppLocalDEBase.getJSONValue((Object)pSAppLocalDEBase.getMemo()), (boolean)false);
        }
        if (bl || pSAppLocalDEBase.getPPSAppLocalDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsapplocaldeid", (Object)PSAppLocalDEBase.getJSONValue((Object)pSAppLocalDEBase.getPPSAppLocalDEId()), (boolean)false);
        }
        if (bl || pSAppLocalDEBase.getPPSAppLocalDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsapplocaldename", (Object)PSAppLocalDEBase.getJSONValue((Object)pSAppLocalDEBase.getPPSAppLocalDEName()), (boolean)false);
        }
        if (bl || pSAppLocalDEBase.getPSAppLocalDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psapplocaldeid", (Object)PSAppLocalDEBase.getJSONValue((Object)pSAppLocalDEBase.getPSAppLocalDEId()), (boolean)false);
        }
        if (bl || pSAppLocalDEBase.getPSAppLocalDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psapplocaldename", (Object)PSAppLocalDEBase.getJSONValue((Object)pSAppLocalDEBase.getPSAppLocalDEName()), (boolean)false);
        }
        if (bl || pSAppLocalDEBase.getPSAppModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappmoduleid", (Object)PSAppLocalDEBase.getJSONValue((Object)pSAppLocalDEBase.getPSAppModuleId()), (boolean)false);
        }
        if (bl || pSAppLocalDEBase.getPSAppModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappmodulename", (Object)PSAppLocalDEBase.getJSONValue((Object)pSAppLocalDEBase.getPSAppModuleName()), (boolean)false);
        }
        if (bl || pSAppLocalDEBase.getPSDEFGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefgroupid", (Object)PSAppLocalDEBase.getJSONValue((Object)pSAppLocalDEBase.getPSDEFGroupId()), (boolean)false);
        }
        if (bl || pSAppLocalDEBase.getPSDEFGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefgroupname", (Object)PSAppLocalDEBase.getJSONValue((Object)pSAppLocalDEBase.getPSDEFGroupName()), (boolean)false);
        }
        if (bl || pSAppLocalDEBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSAppLocalDEBase.getJSONValue((Object)pSAppLocalDEBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSAppLocalDEBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSAppLocalDEBase.getJSONValue((Object)pSAppLocalDEBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSAppLocalDEBase.getPSDERId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psderid", (Object)PSAppLocalDEBase.getJSONValue((Object)pSAppLocalDEBase.getPSDERId()), (boolean)false);
        }
        if (bl || pSAppLocalDEBase.getPSDERName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdername", (Object)PSAppLocalDEBase.getJSONValue((Object)pSAppLocalDEBase.getPSDERName()), (boolean)false);
        }
        if (bl || pSAppLocalDEBase.getPSDEServiceAPIId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeserviceapiid", (Object)PSAppLocalDEBase.getJSONValue((Object)pSAppLocalDEBase.getPSDEServiceAPIId()), (boolean)false);
        }
        if (bl || pSAppLocalDEBase.getPSDEServiceAPIName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeserviceapiname", (Object)PSAppLocalDEBase.getJSONValue((Object)pSAppLocalDEBase.getPSDEServiceAPIName()), (boolean)false);
        }
        if (bl || pSAppLocalDEBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSAppLocalDEBase.getJSONValue((Object)pSAppLocalDEBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSAppLocalDEBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSAppLocalDEBase.getJSONValue((Object)pSAppLocalDEBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSAppLocalDEBase.getPSSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappname", (Object)PSAppLocalDEBase.getJSONValue((Object)pSAppLocalDEBase.getPSSysAppName()), (boolean)false);
        }
        if (bl || pSAppLocalDEBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSAppLocalDEBase.getJSONValue((Object)pSAppLocalDEBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSAppLocalDEBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSAppLocalDEBase.getJSONValue((Object)pSAppLocalDEBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSAppLocalDEBase.getPSSysReqItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemid", (Object)PSAppLocalDEBase.getJSONValue((Object)pSAppLocalDEBase.getPSSysReqItemId()), (boolean)false);
        }
        if (bl || pSAppLocalDEBase.getPSSysReqItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemname", (Object)PSAppLocalDEBase.getJSONValue((Object)pSAppLocalDEBase.getPSSysReqItemName()), (boolean)false);
        }
        if (bl || pSAppLocalDEBase.getPSSysServiceAPIId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysserviceapiid", (Object)PSAppLocalDEBase.getJSONValue((Object)pSAppLocalDEBase.getPSSysServiceAPIId()), (boolean)false);
        }
        if (bl || pSAppLocalDEBase.getPSSysServiceAPIName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysserviceapiname", (Object)PSAppLocalDEBase.getJSONValue((Object)pSAppLocalDEBase.getPSSysServiceAPIName()), (boolean)false);
        }
        if (bl || pSAppLocalDEBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSAppLocalDEBase.getJSONValue((Object)pSAppLocalDEBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSAppLocalDEBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSAppLocalDEBase.getJSONValue((Object)pSAppLocalDEBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSAppLocalDEBase.getPSSysUniResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysuniresid", (Object)PSAppLocalDEBase.getJSONValue((Object)pSAppLocalDEBase.getPSSysUniResId()), (boolean)false);
        }
        if (bl || pSAppLocalDEBase.getPSSysUniResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysuniresname", (Object)PSAppLocalDEBase.getJSONValue((Object)pSAppLocalDEBase.getPSSysUniResName()), (boolean)false);
        }
        if (bl || pSAppLocalDEBase.getSDPSDEViewID() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sdpsdeviewid", (Object)PSAppLocalDEBase.getJSONValue((Object)pSAppLocalDEBase.getSDPSDEViewID()), (boolean)false);
        }
        if (bl || pSAppLocalDEBase.getSDPSDEViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sdpsdeviewname", (Object)PSAppLocalDEBase.getJSONValue((Object)pSAppLocalDEBase.getSDPSDEViewName()), (boolean)false);
        }
        if (bl || pSAppLocalDEBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSAppLocalDEBase.getJSONValue((Object)pSAppLocalDEBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSAppLocalDEBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSAppLocalDEBase.getJSONValue((Object)pSAppLocalDEBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSAppLocalDEBase.getUserAction() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"useraction", (Object)PSAppLocalDEBase.getJSONValue((Object)pSAppLocalDEBase.getUserAction()), (boolean)false);
        }
        if (bl || pSAppLocalDEBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSAppLocalDEBase.getJSONValue((Object)pSAppLocalDEBase.getUserCat()), (boolean)false);
        }
        if (bl || pSAppLocalDEBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSAppLocalDEBase.getJSONValue((Object)pSAppLocalDEBase.getUserTag()), (boolean)false);
        }
        if (bl || pSAppLocalDEBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSAppLocalDEBase.getJSONValue((Object)pSAppLocalDEBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSAppLocalDEBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSAppLocalDEBase.getJSONValue((Object)pSAppLocalDEBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSAppLocalDEBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSAppLocalDEBase.getJSONValue((Object)pSAppLocalDEBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSAppLocalDEBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSAppLocalDEBase.getJSONValue((Object)pSAppLocalDEBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSAppLocalDEBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSAppLocalDEBase pSAppLocalDEBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSAppLocalDEBase.getAccCtrlArch() != null) {
            object = pSAppLocalDEBase.getAccCtrlArch();
            xmlNode.setAttribute(FIELD_ACCCTRLARCH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppLocalDEBase.getAutoAddMethodMode() != null) {
            object = pSAppLocalDEBase.getAutoAddMethodMode();
            xmlNode.setAttribute(FIELD_AUTOADDMETHODMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppLocalDEBase.getAutoAddViewMode() != null) {
            object = pSAppLocalDEBase.getAutoAddViewMode();
            xmlNode.setAttribute(FIELD_AUTOADDVIEWMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppLocalDEBase.getBaseClsParams() != null) {
            object = pSAppLocalDEBase.getBaseClsParams();
            xmlNode.setAttribute(FIELD_BASECLSPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSAppLocalDEBase.getCodeName() != null) {
            object = pSAppLocalDEBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppLocalDEBase.getCodeName2() != null) {
            object = pSAppLocalDEBase.getCodeName2();
            xmlNode.setAttribute(FIELD_CODENAME2, object == null ? "" : (String)object);
        }
        if (bl || pSAppLocalDEBase.getCreateDate() != null) {
            object = pSAppLocalDEBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppLocalDEBase.getCreateMan() != null) {
            object = pSAppLocalDEBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppLocalDEBase.getCustomUserAction() != null) {
            object = pSAppLocalDEBase.getCustomUserAction();
            xmlNode.setAttribute(FIELD_CUSTOMUSERACTION, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppLocalDEBase.getDataAccMode() != null) {
            object = pSAppLocalDEBase.getDataAccMode();
            xmlNode.setAttribute(FIELD_DATAACCMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppLocalDEBase.getDECodeName() != null) {
            object = pSAppLocalDEBase.getDECodeName();
            xmlNode.setAttribute(FIELD_DECODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppLocalDEBase.getDefaultFlag() != null) {
            object = pSAppLocalDEBase.getDefaultFlag();
            xmlNode.setAttribute(FIELD_DEFAULTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppLocalDEBase.getDEFGroupMode() != null) {
            object = pSAppLocalDEBase.getDEFGroupMode();
            xmlNode.setAttribute(FIELD_DEFGROUPMODE, object == null ? "" : (String)object);
        }
        if (bl || pSAppLocalDEBase.getDELogicName() != null) {
            object = pSAppLocalDEBase.getDELogicName();
            xmlNode.setAttribute(FIELD_DELOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppLocalDEBase.getEnableStorage() != null) {
            object = pSAppLocalDEBase.getEnableStorage();
            xmlNode.setAttribute(FIELD_ENABLESTORAGE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppLocalDEBase.getLinkPSDEViewId() != null) {
            object = pSAppLocalDEBase.getLinkPSDEViewId();
            xmlNode.setAttribute(FIELD_LINKPSDEVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSAppLocalDEBase.getLinkPSDEViewName() != null) {
            object = pSAppLocalDEBase.getLinkPSDEViewName();
            xmlNode.setAttribute(FIELD_LINKPSDEVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppLocalDEBase.getLNPSLanResId() != null) {
            object = pSAppLocalDEBase.getLNPSLanResId();
            xmlNode.setAttribute(FIELD_LNPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSAppLocalDEBase.getLNPSLanResName() != null) {
            object = pSAppLocalDEBase.getLNPSLanResName();
            xmlNode.setAttribute(FIELD_LNPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppLocalDEBase.getLogicName() != null) {
            object = pSAppLocalDEBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppLocalDEBase.getMajorFlag() != null) {
            object = pSAppLocalDEBase.getMajorFlag();
            xmlNode.setAttribute(FIELD_MAJORFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppLocalDEBase.getMDPSDEViewId() != null) {
            object = pSAppLocalDEBase.getMDPSDEViewId();
            xmlNode.setAttribute(FIELD_MDPSDEVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSAppLocalDEBase.getMDPSDEViewName() != null) {
            object = pSAppLocalDEBase.getMDPSDEViewName();
            xmlNode.setAttribute(FIELD_MDPSDEVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppLocalDEBase.getMemo() != null) {
            object = pSAppLocalDEBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSAppLocalDEBase.getPPSAppLocalDEId() != null) {
            object = pSAppLocalDEBase.getPPSAppLocalDEId();
            xmlNode.setAttribute(FIELD_PPSAPPLOCALDEID, object == null ? "" : (String)object);
        }
        if (bl || pSAppLocalDEBase.getPPSAppLocalDEName() != null) {
            object = pSAppLocalDEBase.getPPSAppLocalDEName();
            xmlNode.setAttribute(FIELD_PPSAPPLOCALDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppLocalDEBase.getPSAppLocalDEId() != null) {
            object = pSAppLocalDEBase.getPSAppLocalDEId();
            xmlNode.setAttribute(FIELD_PSAPPLOCALDEID, object == null ? "" : (String)object);
        }
        if (bl || pSAppLocalDEBase.getPSAppLocalDEName() != null) {
            object = pSAppLocalDEBase.getPSAppLocalDEName();
            xmlNode.setAttribute(FIELD_PSAPPLOCALDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppLocalDEBase.getPSAppModuleId() != null) {
            object = pSAppLocalDEBase.getPSAppModuleId();
            xmlNode.setAttribute(FIELD_PSAPPMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSAppLocalDEBase.getPSAppModuleName() != null) {
            object = pSAppLocalDEBase.getPSAppModuleName();
            xmlNode.setAttribute(FIELD_PSAPPMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppLocalDEBase.getPSDEFGroupId() != null) {
            object = pSAppLocalDEBase.getPSDEFGroupId();
            xmlNode.setAttribute(FIELD_PSDEFGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSAppLocalDEBase.getPSDEFGroupName() != null) {
            object = pSAppLocalDEBase.getPSDEFGroupName();
            xmlNode.setAttribute(FIELD_PSDEFGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppLocalDEBase.getPSDEId() != null) {
            object = pSAppLocalDEBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSAppLocalDEBase.getPSDEName() != null) {
            object = pSAppLocalDEBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppLocalDEBase.getPSDERId() != null) {
            object = pSAppLocalDEBase.getPSDERId();
            xmlNode.setAttribute(FIELD_PSDERID, object == null ? "" : (String)object);
        }
        if (bl || pSAppLocalDEBase.getPSDERName() != null) {
            object = pSAppLocalDEBase.getPSDERName();
            xmlNode.setAttribute(FIELD_PSDERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppLocalDEBase.getPSDEServiceAPIId() != null) {
            object = pSAppLocalDEBase.getPSDEServiceAPIId();
            xmlNode.setAttribute(FIELD_PSDESERVICEAPIID, object == null ? "" : (String)object);
        }
        if (bl || pSAppLocalDEBase.getPSDEServiceAPIName() != null) {
            object = pSAppLocalDEBase.getPSDEServiceAPIName();
            xmlNode.setAttribute(FIELD_PSDESERVICEAPINAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppLocalDEBase.getPSModuleId() != null) {
            object = pSAppLocalDEBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSAppLocalDEBase.getPSSysAppId() != null) {
            object = pSAppLocalDEBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSAppLocalDEBase.getPSSysAppName() != null) {
            object = pSAppLocalDEBase.getPSSysAppName();
            xmlNode.setAttribute(FIELD_PSSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppLocalDEBase.getPSSysDynaModelId() != null) {
            object = pSAppLocalDEBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSAppLocalDEBase.getPSSysDynaModelName() != null) {
            object = pSAppLocalDEBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppLocalDEBase.getPSSysReqItemId() != null) {
            object = pSAppLocalDEBase.getPSSysReqItemId();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSAppLocalDEBase.getPSSysReqItemName() != null) {
            object = pSAppLocalDEBase.getPSSysReqItemName();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppLocalDEBase.getPSSysServiceAPIId() != null) {
            object = pSAppLocalDEBase.getPSSysServiceAPIId();
            xmlNode.setAttribute(FIELD_PSSYSSERVICEAPIID, object == null ? "" : (String)object);
        }
        if (bl || pSAppLocalDEBase.getPSSysServiceAPIName() != null) {
            object = pSAppLocalDEBase.getPSSysServiceAPIName();
            xmlNode.setAttribute(FIELD_PSSYSSERVICEAPINAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppLocalDEBase.getPSSysSFPluginId() != null) {
            object = pSAppLocalDEBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSAppLocalDEBase.getPSSysSFPluginName() != null) {
            object = pSAppLocalDEBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppLocalDEBase.getPSSysUniResId() != null) {
            object = pSAppLocalDEBase.getPSSysUniResId();
            xmlNode.setAttribute(FIELD_PSSYSUNIRESID, object == null ? "" : (String)object);
        }
        if (bl || pSAppLocalDEBase.getPSSysUniResName() != null) {
            object = pSAppLocalDEBase.getPSSysUniResName();
            xmlNode.setAttribute(FIELD_PSSYSUNIRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppLocalDEBase.getSDPSDEViewID() != null) {
            object = pSAppLocalDEBase.getSDPSDEViewID();
            xmlNode.setAttribute(FIELD_SDPSDEVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSAppLocalDEBase.getSDPSDEViewName() != null) {
            object = pSAppLocalDEBase.getSDPSDEViewName();
            xmlNode.setAttribute(FIELD_SDPSDEVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppLocalDEBase.getUpdateDate() != null) {
            object = pSAppLocalDEBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppLocalDEBase.getUpdateMan() != null) {
            object = pSAppLocalDEBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppLocalDEBase.getUserAction() != null) {
            object = pSAppLocalDEBase.getUserAction();
            xmlNode.setAttribute(FIELD_USERACTION, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppLocalDEBase.getUserCat() != null) {
            object = pSAppLocalDEBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSAppLocalDEBase.getUserTag() != null) {
            object = pSAppLocalDEBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSAppLocalDEBase.getUserTag2() != null) {
            object = pSAppLocalDEBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSAppLocalDEBase.getUserTag3() != null) {
            object = pSAppLocalDEBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSAppLocalDEBase.getUserTag4() != null) {
            object = pSAppLocalDEBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSAppLocalDEBase.getValidFlag() != null) {
            object = pSAppLocalDEBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSAppLocalDEBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSAppLocalDEBase pSAppLocalDEBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSAppLocalDEBase.isAccCtrlArchDirty() && (bl || pSAppLocalDEBase.getAccCtrlArch() != null)) {
            iDataObject.set(FIELD_ACCCTRLARCH, (Object)pSAppLocalDEBase.getAccCtrlArch());
        }
        if (pSAppLocalDEBase.isAutoAddMethodModeDirty() && (bl || pSAppLocalDEBase.getAutoAddMethodMode() != null)) {
            iDataObject.set(FIELD_AUTOADDMETHODMODE, (Object)pSAppLocalDEBase.getAutoAddMethodMode());
        }
        if (pSAppLocalDEBase.isAutoAddViewModeDirty() && (bl || pSAppLocalDEBase.getAutoAddViewMode() != null)) {
            iDataObject.set(FIELD_AUTOADDVIEWMODE, (Object)pSAppLocalDEBase.getAutoAddViewMode());
        }
        if (pSAppLocalDEBase.isBaseClsParamsDirty() && (bl || pSAppLocalDEBase.getBaseClsParams() != null)) {
            iDataObject.set(FIELD_BASECLSPARAMS, (Object)pSAppLocalDEBase.getBaseClsParams());
        }
        if (pSAppLocalDEBase.isCodeNameDirty() && (bl || pSAppLocalDEBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSAppLocalDEBase.getCodeName());
        }
        if (pSAppLocalDEBase.isCodeName2Dirty() && (bl || pSAppLocalDEBase.getCodeName2() != null)) {
            iDataObject.set(FIELD_CODENAME2, (Object)pSAppLocalDEBase.getCodeName2());
        }
        if (pSAppLocalDEBase.isCreateDateDirty() && (bl || pSAppLocalDEBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSAppLocalDEBase.getCreateDate());
        }
        if (pSAppLocalDEBase.isCreateManDirty() && (bl || pSAppLocalDEBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSAppLocalDEBase.getCreateMan());
        }
        if (pSAppLocalDEBase.isCustomUserActionDirty() && (bl || pSAppLocalDEBase.getCustomUserAction() != null)) {
            iDataObject.set(FIELD_CUSTOMUSERACTION, (Object)pSAppLocalDEBase.getCustomUserAction());
        }
        if (pSAppLocalDEBase.isDataAccModeDirty() && (bl || pSAppLocalDEBase.getDataAccMode() != null)) {
            iDataObject.set(FIELD_DATAACCMODE, (Object)pSAppLocalDEBase.getDataAccMode());
        }
        if (pSAppLocalDEBase.isDECodeNameDirty() && (bl || pSAppLocalDEBase.getDECodeName() != null)) {
            iDataObject.set(FIELD_DECODENAME, (Object)pSAppLocalDEBase.getDECodeName());
        }
        if (pSAppLocalDEBase.isDefaultFlagDirty() && (bl || pSAppLocalDEBase.getDefaultFlag() != null)) {
            iDataObject.set(FIELD_DEFAULTFLAG, (Object)pSAppLocalDEBase.getDefaultFlag());
        }
        if (pSAppLocalDEBase.isDEFGroupModeDirty() && (bl || pSAppLocalDEBase.getDEFGroupMode() != null)) {
            iDataObject.set(FIELD_DEFGROUPMODE, (Object)pSAppLocalDEBase.getDEFGroupMode());
        }
        if (pSAppLocalDEBase.isDELogicNameDirty() && (bl || pSAppLocalDEBase.getDELogicName() != null)) {
            iDataObject.set(FIELD_DELOGICNAME, (Object)pSAppLocalDEBase.getDELogicName());
        }
        if (pSAppLocalDEBase.isEnableStorageDirty() && (bl || pSAppLocalDEBase.getEnableStorage() != null)) {
            iDataObject.set(FIELD_ENABLESTORAGE, (Object)pSAppLocalDEBase.getEnableStorage());
        }
        if (pSAppLocalDEBase.isLinkPSDEViewIdDirty() && (bl || pSAppLocalDEBase.getLinkPSDEViewId() != null)) {
            iDataObject.set(FIELD_LINKPSDEVIEWID, (Object)pSAppLocalDEBase.getLinkPSDEViewId());
        }
        if (pSAppLocalDEBase.isLinkPSDEViewNameDirty() && (bl || pSAppLocalDEBase.getLinkPSDEViewName() != null)) {
            iDataObject.set(FIELD_LINKPSDEVIEWNAME, (Object)pSAppLocalDEBase.getLinkPSDEViewName());
        }
        if (pSAppLocalDEBase.isLNPSLanResIdDirty() && (bl || pSAppLocalDEBase.getLNPSLanResId() != null)) {
            iDataObject.set(FIELD_LNPSLANRESID, (Object)pSAppLocalDEBase.getLNPSLanResId());
        }
        if (pSAppLocalDEBase.isLNPSLanResNameDirty() && (bl || pSAppLocalDEBase.getLNPSLanResName() != null)) {
            iDataObject.set(FIELD_LNPSLANRESNAME, (Object)pSAppLocalDEBase.getLNPSLanResName());
        }
        if (pSAppLocalDEBase.isLogicNameDirty() && (bl || pSAppLocalDEBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSAppLocalDEBase.getLogicName());
        }
        if (pSAppLocalDEBase.isMajorFlagDirty() && (bl || pSAppLocalDEBase.getMajorFlag() != null)) {
            iDataObject.set(FIELD_MAJORFLAG, (Object)pSAppLocalDEBase.getMajorFlag());
        }
        if (pSAppLocalDEBase.isMDPSDEViewIdDirty() && (bl || pSAppLocalDEBase.getMDPSDEViewId() != null)) {
            iDataObject.set(FIELD_MDPSDEVIEWID, (Object)pSAppLocalDEBase.getMDPSDEViewId());
        }
        if (pSAppLocalDEBase.isMDPSDEViewNameDirty() && (bl || pSAppLocalDEBase.getMDPSDEViewName() != null)) {
            iDataObject.set(FIELD_MDPSDEVIEWNAME, (Object)pSAppLocalDEBase.getMDPSDEViewName());
        }
        if (pSAppLocalDEBase.isMemoDirty() && (bl || pSAppLocalDEBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSAppLocalDEBase.getMemo());
        }
        if (pSAppLocalDEBase.isPPSAppLocalDEIdDirty() && (bl || pSAppLocalDEBase.getPPSAppLocalDEId() != null)) {
            iDataObject.set(FIELD_PPSAPPLOCALDEID, (Object)pSAppLocalDEBase.getPPSAppLocalDEId());
        }
        if (pSAppLocalDEBase.isPPSAppLocalDENameDirty() && (bl || pSAppLocalDEBase.getPPSAppLocalDEName() != null)) {
            iDataObject.set(FIELD_PPSAPPLOCALDENAME, (Object)pSAppLocalDEBase.getPPSAppLocalDEName());
        }
        if (pSAppLocalDEBase.isPSAppLocalDEIdDirty() && (bl || pSAppLocalDEBase.getPSAppLocalDEId() != null)) {
            iDataObject.set(FIELD_PSAPPLOCALDEID, (Object)pSAppLocalDEBase.getPSAppLocalDEId());
        }
        if (pSAppLocalDEBase.isPSAppLocalDENameDirty() && (bl || pSAppLocalDEBase.getPSAppLocalDEName() != null)) {
            iDataObject.set(FIELD_PSAPPLOCALDENAME, (Object)pSAppLocalDEBase.getPSAppLocalDEName());
        }
        if (pSAppLocalDEBase.isPSAppModuleIdDirty() && (bl || pSAppLocalDEBase.getPSAppModuleId() != null)) {
            iDataObject.set(FIELD_PSAPPMODULEID, (Object)pSAppLocalDEBase.getPSAppModuleId());
        }
        if (pSAppLocalDEBase.isPSAppModuleNameDirty() && (bl || pSAppLocalDEBase.getPSAppModuleName() != null)) {
            iDataObject.set(FIELD_PSAPPMODULENAME, (Object)pSAppLocalDEBase.getPSAppModuleName());
        }
        if (pSAppLocalDEBase.isPSDEFGroupIdDirty() && (bl || pSAppLocalDEBase.getPSDEFGroupId() != null)) {
            iDataObject.set(FIELD_PSDEFGROUPID, (Object)pSAppLocalDEBase.getPSDEFGroupId());
        }
        if (pSAppLocalDEBase.isPSDEFGroupNameDirty() && (bl || pSAppLocalDEBase.getPSDEFGroupName() != null)) {
            iDataObject.set(FIELD_PSDEFGROUPNAME, (Object)pSAppLocalDEBase.getPSDEFGroupName());
        }
        if (pSAppLocalDEBase.isPSDEIdDirty() && (bl || pSAppLocalDEBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSAppLocalDEBase.getPSDEId());
        }
        if (pSAppLocalDEBase.isPSDENameDirty() && (bl || pSAppLocalDEBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSAppLocalDEBase.getPSDEName());
        }
        if (pSAppLocalDEBase.isPSDERIdDirty() && (bl || pSAppLocalDEBase.getPSDERId() != null)) {
            iDataObject.set(FIELD_PSDERID, (Object)pSAppLocalDEBase.getPSDERId());
        }
        if (pSAppLocalDEBase.isPSDERNameDirty() && (bl || pSAppLocalDEBase.getPSDERName() != null)) {
            iDataObject.set(FIELD_PSDERNAME, (Object)pSAppLocalDEBase.getPSDERName());
        }
        if (pSAppLocalDEBase.isPSDEServiceAPIIdDirty() && (bl || pSAppLocalDEBase.getPSDEServiceAPIId() != null)) {
            iDataObject.set(FIELD_PSDESERVICEAPIID, (Object)pSAppLocalDEBase.getPSDEServiceAPIId());
        }
        if (pSAppLocalDEBase.isPSDEServiceAPINameDirty() && (bl || pSAppLocalDEBase.getPSDEServiceAPIName() != null)) {
            iDataObject.set(FIELD_PSDESERVICEAPINAME, (Object)pSAppLocalDEBase.getPSDEServiceAPIName());
        }
        if (pSAppLocalDEBase.isPSModuleIdDirty() && (bl || pSAppLocalDEBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSAppLocalDEBase.getPSModuleId());
        }
        if (pSAppLocalDEBase.isPSSysAppIdDirty() && (bl || pSAppLocalDEBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSAppLocalDEBase.getPSSysAppId());
        }
        if (pSAppLocalDEBase.isPSSysAppNameDirty() && (bl || pSAppLocalDEBase.getPSSysAppName() != null)) {
            iDataObject.set(FIELD_PSSYSAPPNAME, (Object)pSAppLocalDEBase.getPSSysAppName());
        }
        if (pSAppLocalDEBase.isPSSysDynaModelIdDirty() && (bl || pSAppLocalDEBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSAppLocalDEBase.getPSSysDynaModelId());
        }
        if (pSAppLocalDEBase.isPSSysDynaModelNameDirty() && (bl || pSAppLocalDEBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSAppLocalDEBase.getPSSysDynaModelName());
        }
        if (pSAppLocalDEBase.isPSSysReqItemIdDirty() && (bl || pSAppLocalDEBase.getPSSysReqItemId() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMID, (Object)pSAppLocalDEBase.getPSSysReqItemId());
        }
        if (pSAppLocalDEBase.isPSSysReqItemNameDirty() && (bl || pSAppLocalDEBase.getPSSysReqItemName() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMNAME, (Object)pSAppLocalDEBase.getPSSysReqItemName());
        }
        if (pSAppLocalDEBase.isPSSysServiceAPIIdDirty() && (bl || pSAppLocalDEBase.getPSSysServiceAPIId() != null)) {
            iDataObject.set(FIELD_PSSYSSERVICEAPIID, (Object)pSAppLocalDEBase.getPSSysServiceAPIId());
        }
        if (pSAppLocalDEBase.isPSSysServiceAPINameDirty() && (bl || pSAppLocalDEBase.getPSSysServiceAPIName() != null)) {
            iDataObject.set(FIELD_PSSYSSERVICEAPINAME, (Object)pSAppLocalDEBase.getPSSysServiceAPIName());
        }
        if (pSAppLocalDEBase.isPSSysSFPluginIdDirty() && (bl || pSAppLocalDEBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSAppLocalDEBase.getPSSysSFPluginId());
        }
        if (pSAppLocalDEBase.isPSSysSFPluginNameDirty() && (bl || pSAppLocalDEBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSAppLocalDEBase.getPSSysSFPluginName());
        }
        if (pSAppLocalDEBase.isPSSysUniResIdDirty() && (bl || pSAppLocalDEBase.getPSSysUniResId() != null)) {
            iDataObject.set(FIELD_PSSYSUNIRESID, (Object)pSAppLocalDEBase.getPSSysUniResId());
        }
        if (pSAppLocalDEBase.isPSSysUniResNameDirty() && (bl || pSAppLocalDEBase.getPSSysUniResName() != null)) {
            iDataObject.set(FIELD_PSSYSUNIRESNAME, (Object)pSAppLocalDEBase.getPSSysUniResName());
        }
        if (pSAppLocalDEBase.isSDPSDEViewIDDirty() && (bl || pSAppLocalDEBase.getSDPSDEViewID() != null)) {
            iDataObject.set(FIELD_SDPSDEVIEWID, (Object)pSAppLocalDEBase.getSDPSDEViewID());
        }
        if (pSAppLocalDEBase.isSDPSDEViewNameDirty() && (bl || pSAppLocalDEBase.getSDPSDEViewName() != null)) {
            iDataObject.set(FIELD_SDPSDEVIEWNAME, (Object)pSAppLocalDEBase.getSDPSDEViewName());
        }
        if (pSAppLocalDEBase.isUpdateDateDirty() && (bl || pSAppLocalDEBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSAppLocalDEBase.getUpdateDate());
        }
        if (pSAppLocalDEBase.isUpdateManDirty() && (bl || pSAppLocalDEBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSAppLocalDEBase.getUpdateMan());
        }
        if (pSAppLocalDEBase.isUserActionDirty() && (bl || pSAppLocalDEBase.getUserAction() != null)) {
            iDataObject.set(FIELD_USERACTION, (Object)pSAppLocalDEBase.getUserAction());
        }
        if (pSAppLocalDEBase.isUserCatDirty() && (bl || pSAppLocalDEBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSAppLocalDEBase.getUserCat());
        }
        if (pSAppLocalDEBase.isUserTagDirty() && (bl || pSAppLocalDEBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSAppLocalDEBase.getUserTag());
        }
        if (pSAppLocalDEBase.isUserTag2Dirty() && (bl || pSAppLocalDEBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSAppLocalDEBase.getUserTag2());
        }
        if (pSAppLocalDEBase.isUserTag3Dirty() && (bl || pSAppLocalDEBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSAppLocalDEBase.getUserTag3());
        }
        if (pSAppLocalDEBase.isUserTag4Dirty() && (bl || pSAppLocalDEBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSAppLocalDEBase.getUserTag4());
        }
        if (pSAppLocalDEBase.isValidFlagDirty() && (bl || pSAppLocalDEBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSAppLocalDEBase.getValidFlag());
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
        return PSAppLocalDEBase.remove(this, n);
    }

    private static boolean remove(PSAppLocalDEBase pSAppLocalDEBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSAppLocalDEBase.resetAccCtrlArch();
                return true;
            }
            case 1: {
                pSAppLocalDEBase.resetAutoAddMethodMode();
                return true;
            }
            case 2: {
                pSAppLocalDEBase.resetAutoAddViewMode();
                return true;
            }
            case 3: {
                pSAppLocalDEBase.resetBaseClsParams();
                return true;
            }
            case 4: {
                pSAppLocalDEBase.resetCodeName();
                return true;
            }
            case 5: {
                pSAppLocalDEBase.resetCodeName2();
                return true;
            }
            case 6: {
                pSAppLocalDEBase.resetCreateDate();
                return true;
            }
            case 7: {
                pSAppLocalDEBase.resetCreateMan();
                return true;
            }
            case 8: {
                pSAppLocalDEBase.resetCustomUserAction();
                return true;
            }
            case 9: {
                pSAppLocalDEBase.resetDataAccMode();
                return true;
            }
            case 10: {
                pSAppLocalDEBase.resetDECodeName();
                return true;
            }
            case 11: {
                pSAppLocalDEBase.resetDefaultFlag();
                return true;
            }
            case 12: {
                pSAppLocalDEBase.resetDEFGroupMode();
                return true;
            }
            case 13: {
                pSAppLocalDEBase.resetDELogicName();
                return true;
            }
            case 14: {
                pSAppLocalDEBase.resetEnableStorage();
                return true;
            }
            case 15: {
                pSAppLocalDEBase.resetLinkPSDEViewId();
                return true;
            }
            case 16: {
                pSAppLocalDEBase.resetLinkPSDEViewName();
                return true;
            }
            case 17: {
                pSAppLocalDEBase.resetLNPSLanResId();
                return true;
            }
            case 18: {
                pSAppLocalDEBase.resetLNPSLanResName();
                return true;
            }
            case 19: {
                pSAppLocalDEBase.resetLogicName();
                return true;
            }
            case 20: {
                pSAppLocalDEBase.resetMajorFlag();
                return true;
            }
            case 21: {
                pSAppLocalDEBase.resetMDPSDEViewId();
                return true;
            }
            case 22: {
                pSAppLocalDEBase.resetMDPSDEViewName();
                return true;
            }
            case 23: {
                pSAppLocalDEBase.resetMemo();
                return true;
            }
            case 24: {
                pSAppLocalDEBase.resetPPSAppLocalDEId();
                return true;
            }
            case 25: {
                pSAppLocalDEBase.resetPPSAppLocalDEName();
                return true;
            }
            case 26: {
                pSAppLocalDEBase.resetPSAppLocalDEId();
                return true;
            }
            case 27: {
                pSAppLocalDEBase.resetPSAppLocalDEName();
                return true;
            }
            case 28: {
                pSAppLocalDEBase.resetPSAppModuleId();
                return true;
            }
            case 29: {
                pSAppLocalDEBase.resetPSAppModuleName();
                return true;
            }
            case 30: {
                pSAppLocalDEBase.resetPSDEFGroupId();
                return true;
            }
            case 31: {
                pSAppLocalDEBase.resetPSDEFGroupName();
                return true;
            }
            case 32: {
                pSAppLocalDEBase.resetPSDEId();
                return true;
            }
            case 33: {
                pSAppLocalDEBase.resetPSDEName();
                return true;
            }
            case 34: {
                pSAppLocalDEBase.resetPSDERId();
                return true;
            }
            case 35: {
                pSAppLocalDEBase.resetPSDERName();
                return true;
            }
            case 36: {
                pSAppLocalDEBase.resetPSDEServiceAPIId();
                return true;
            }
            case 37: {
                pSAppLocalDEBase.resetPSDEServiceAPIName();
                return true;
            }
            case 38: {
                pSAppLocalDEBase.resetPSModuleId();
                return true;
            }
            case 39: {
                pSAppLocalDEBase.resetPSSysAppId();
                return true;
            }
            case 40: {
                pSAppLocalDEBase.resetPSSysAppName();
                return true;
            }
            case 41: {
                pSAppLocalDEBase.resetPSSysDynaModelId();
                return true;
            }
            case 42: {
                pSAppLocalDEBase.resetPSSysDynaModelName();
                return true;
            }
            case 43: {
                pSAppLocalDEBase.resetPSSysReqItemId();
                return true;
            }
            case 44: {
                pSAppLocalDEBase.resetPSSysReqItemName();
                return true;
            }
            case 45: {
                pSAppLocalDEBase.resetPSSysServiceAPIId();
                return true;
            }
            case 46: {
                pSAppLocalDEBase.resetPSSysServiceAPIName();
                return true;
            }
            case 47: {
                pSAppLocalDEBase.resetPSSysSFPluginId();
                return true;
            }
            case 48: {
                pSAppLocalDEBase.resetPSSysSFPluginName();
                return true;
            }
            case 49: {
                pSAppLocalDEBase.resetPSSysUniResId();
                return true;
            }
            case 50: {
                pSAppLocalDEBase.resetPSSysUniResName();
                return true;
            }
            case 51: {
                pSAppLocalDEBase.resetSDPSDEViewID();
                return true;
            }
            case 52: {
                pSAppLocalDEBase.resetSDPSDEViewName();
                return true;
            }
            case 53: {
                pSAppLocalDEBase.resetUpdateDate();
                return true;
            }
            case 54: {
                pSAppLocalDEBase.resetUpdateMan();
                return true;
            }
            case 55: {
                pSAppLocalDEBase.resetUserAction();
                return true;
            }
            case 56: {
                pSAppLocalDEBase.resetUserCat();
                return true;
            }
            case 57: {
                pSAppLocalDEBase.resetUserTag();
                return true;
            }
            case 58: {
                pSAppLocalDEBase.resetUserTag2();
                return true;
            }
            case 59: {
                pSAppLocalDEBase.resetUserTag3();
                return true;
            }
            case 60: {
                pSAppLocalDEBase.resetUserTag4();
                return true;
            }
            case 61: {
                pSAppLocalDEBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSAppLocalDE getPPSAppLocalDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSAppLocalDE();
        }
        if (this.getPPSAppLocalDEId() == null) {
            return null;
        }
        Integer n = this.objPPSAppLocalDELock;
        synchronized (n) {
            if (this.ppsapplocalde != null && DataTypeHelper.compare((int)25, (Object)this.getPPSAppLocalDEId(), (Object)this.ppsapplocalde.getPSAppLocalDEId()) != 0L) {
                this.ppsapplocalde = null;
            }
            if (this.ppsapplocalde == null) {
                PSAppLocalDE pSAppLocalDE = new PSAppLocalDE();
                pSAppLocalDE.setPSAppLocalDEId(this.getPPSAppLocalDEId());
                PSAppLocalDEService pSAppLocalDEService = (PSAppLocalDEService)ServiceGlobal.getService(PSAppLocalDEService.class, (SessionFactory)this.getSessionFactory());
                pSAppLocalDEService.autoGet(pSAppLocalDE);
                this.ppsapplocalde = pSAppLocalDE;
            }
            return this.ppsapplocalde;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSAppModule getPSAppModule() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppModule();
        }
        if (this.getPSAppModuleId() == null) {
            return null;
        }
        Integer n = this.objPSAppModuleLock;
        synchronized (n) {
            if (this.psappmodule != null && DataTypeHelper.compare((int)25, (Object)this.getPSAppModuleId(), (Object)this.psappmodule.getPSAppModuleId()) != 0L) {
                this.psappmodule = null;
            }
            if (this.psappmodule == null) {
                PSAppModule pSAppModule = new PSAppModule();
                pSAppModule.setPSAppModuleId(this.getPSAppModuleId());
                PSAppModuleService pSAppModuleService = (PSAppModuleService)ServiceGlobal.getService(PSAppModuleService.class, (SessionFactory)this.getSessionFactory());
                pSAppModuleService.autoGet(pSAppModule);
                this.psappmodule = pSAppModule;
            }
            return this.psappmodule;
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
                pSDataEntityService.autoGet(pSDataEntity);
                this.psde = pSDataEntity;
            }
            return this.psde;
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
                pSDEFGroupService.autoGet(pSDEFGroup);
                this.psdefgroup = pSDEFGroup;
            }
            return this.psdefgroup;
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
                pSDERService.autoGet(pSDER);
                this.psder = pSDER;
            }
            return this.psder;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEServiceAPI getPSDEServiceAPI() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEServiceAPI();
        }
        if (this.getPSDEServiceAPIId() == null) {
            return null;
        }
        Integer n = this.objPSDEServiceAPILock;
        synchronized (n) {
            if (this.psdeserviceapi != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEServiceAPIId(), (Object)this.psdeserviceapi.getPSDEServiceAPIId()) != 0L) {
                this.psdeserviceapi = null;
            }
            if (this.psdeserviceapi == null) {
                PSDEServiceAPI pSDEServiceAPI = new PSDEServiceAPI();
                pSDEServiceAPI.setPSDEServiceAPIId(this.getPSDEServiceAPIId());
                PSDEServiceAPIService pSDEServiceAPIService = (PSDEServiceAPIService)ServiceGlobal.getService(PSDEServiceAPIService.class, (SessionFactory)this.getSessionFactory());
                pSDEServiceAPIService.autoGet(pSDEServiceAPI);
                this.psdeserviceapi = pSDEServiceAPI;
            }
            return this.psdeserviceapi;
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
                pSDEViewBaseService.autoGet(pSDEViewBase);
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
                pSDEViewBaseService.autoGet(pSDEViewBase);
                this.mdpsdeview = pSDEViewBase;
            }
            return this.mdpsdeview;
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
                pSDEViewBaseService.autoGet(pSDEViewBase);
                this.sdpsdeview = pSDEViewBase;
            }
            return this.sdpsdeview;
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
                pSLanguageResService.autoGet(pSLanguageRes);
                this.lnpslanres = pSLanguageRes;
            }
            return this.lnpslanres;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysApp getPSSysApp() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysApp();
        }
        if (this.getPSSysAppId() == null) {
            return null;
        }
        Integer n = this.objPSSysAppLock;
        synchronized (n) {
            if (this.pssysapp != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysAppId(), (Object)this.pssysapp.getPSSysAppId()) != 0L) {
                this.pssysapp = null;
            }
            if (this.pssysapp == null) {
                PSSysApp pSSysApp = new PSSysApp();
                pSSysApp.setPSSysAppId(this.getPSSysAppId());
                PSSysAppService pSSysAppService = (PSSysAppService)ServiceGlobal.getService(PSSysAppService.class, (SessionFactory)this.getSessionFactory());
                pSSysAppService.autoGet(pSSysApp);
                this.pssysapp = pSSysApp;
            }
            return this.pssysapp;
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
                pSSysDynaModelService.autoGet(pSSysDynaModel);
                this.pssysdynamodel = pSSysDynaModel;
            }
            return this.pssysdynamodel;
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
                pSSysReqItemService.autoGet(pSSysReqItem);
                this.pssysreqitem = pSSysReqItem;
            }
            return this.pssysreqitem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysServiceAPI getPSSysServiceAPI() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysServiceAPI();
        }
        if (this.getPSSysServiceAPIId() == null) {
            return null;
        }
        Integer n = this.objPSSysServiceAPILock;
        synchronized (n) {
            if (this.pssysserviceapi != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysServiceAPIId(), (Object)this.pssysserviceapi.getPSSysServiceAPIId()) != 0L) {
                this.pssysserviceapi = null;
            }
            if (this.pssysserviceapi == null) {
                PSSysServiceAPI pSSysServiceAPI = new PSSysServiceAPI();
                pSSysServiceAPI.setPSSysServiceAPIId(this.getPSSysServiceAPIId());
                PSSysServiceAPIService pSSysServiceAPIService = (PSSysServiceAPIService)ServiceGlobal.getService(PSSysServiceAPIService.class, (SessionFactory)this.getSessionFactory());
                pSSysServiceAPIService.autoGet(pSSysServiceAPI);
                this.pssysserviceapi = pSSysServiceAPI;
            }
            return this.pssysserviceapi;
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
                pSSysSFPluginService.autoGet(pSSysSFPlugin);
                this.pssyssfplugin = pSSysSFPlugin;
            }
            return this.pssyssfplugin;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysUniRes getPSSysUniRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUniRes();
        }
        if (this.getPSSysUniResId() == null) {
            return null;
        }
        Integer n = this.objPSSysUniResLock;
        synchronized (n) {
            if (this.pssysunires != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysUniResId(), (Object)this.pssysunires.getPSSysUniResId()) != 0L) {
                this.pssysunires = null;
            }
            if (this.pssysunires == null) {
                PSSysUniRes pSSysUniRes = new PSSysUniRes();
                pSSysUniRes.setPSSysUniResId(this.getPSSysUniResId());
                PSSysUniResService pSSysUniResService = (PSSysUniResService)ServiceGlobal.getService(PSSysUniResService.class, (SessionFactory)this.getSessionFactory());
                pSSysUniResService.autoGet(pSSysUniRes);
                this.pssysunires = pSSysUniRes;
            }
            return this.pssysunires;
        }
    }

    private PSAppLocalDEBase getProxyEntity() {
        return this.proxyPSAppLocalDEBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSAppLocalDEBase = null;
        if (iDataObject != null && iDataObject instanceof PSAppLocalDEBase) {
            this.proxyPSAppLocalDEBase = (PSAppLocalDEBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppLocalDEService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ACCCTRLARCH, 0);
        fieldIndexMap.put(FIELD_AUTOADDMETHODMODE, 1);
        fieldIndexMap.put(FIELD_AUTOADDVIEWMODE, 2);
        fieldIndexMap.put(FIELD_BASECLSPARAMS, 3);
        fieldIndexMap.put(FIELD_CODENAME, 4);
        fieldIndexMap.put(FIELD_CODENAME2, 5);
        fieldIndexMap.put(FIELD_CREATEDATE, 6);
        fieldIndexMap.put(FIELD_CREATEMAN, 7);
        fieldIndexMap.put(FIELD_CUSTOMUSERACTION, 8);
        fieldIndexMap.put(FIELD_DATAACCMODE, 9);
        fieldIndexMap.put(FIELD_DECODENAME, 10);
        fieldIndexMap.put(FIELD_DEFAULTFLAG, 11);
        fieldIndexMap.put(FIELD_DEFGROUPMODE, 12);
        fieldIndexMap.put(FIELD_DELOGICNAME, 13);
        fieldIndexMap.put(FIELD_ENABLESTORAGE, 14);
        fieldIndexMap.put(FIELD_LINKPSDEVIEWID, 15);
        fieldIndexMap.put(FIELD_LINKPSDEVIEWNAME, 16);
        fieldIndexMap.put(FIELD_LNPSLANRESID, 17);
        fieldIndexMap.put(FIELD_LNPSLANRESNAME, 18);
        fieldIndexMap.put(FIELD_LOGICNAME, 19);
        fieldIndexMap.put(FIELD_MAJORFLAG, 20);
        fieldIndexMap.put(FIELD_MDPSDEVIEWID, 21);
        fieldIndexMap.put(FIELD_MDPSDEVIEWNAME, 22);
        fieldIndexMap.put(FIELD_MEMO, 23);
        fieldIndexMap.put(FIELD_PPSAPPLOCALDEID, 24);
        fieldIndexMap.put(FIELD_PPSAPPLOCALDENAME, 25);
        fieldIndexMap.put(FIELD_PSAPPLOCALDEID, 26);
        fieldIndexMap.put(FIELD_PSAPPLOCALDENAME, 27);
        fieldIndexMap.put(FIELD_PSAPPMODULEID, 28);
        fieldIndexMap.put(FIELD_PSAPPMODULENAME, 29);
        fieldIndexMap.put(FIELD_PSDEFGROUPID, 30);
        fieldIndexMap.put(FIELD_PSDEFGROUPNAME, 31);
        fieldIndexMap.put(FIELD_PSDEID, 32);
        fieldIndexMap.put(FIELD_PSDENAME, 33);
        fieldIndexMap.put(FIELD_PSDERID, 34);
        fieldIndexMap.put(FIELD_PSDERNAME, 35);
        fieldIndexMap.put(FIELD_PSDESERVICEAPIID, 36);
        fieldIndexMap.put(FIELD_PSDESERVICEAPINAME, 37);
        fieldIndexMap.put(FIELD_PSMODULEID, 38);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 39);
        fieldIndexMap.put(FIELD_PSSYSAPPNAME, 40);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 41);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 42);
        fieldIndexMap.put(FIELD_PSSYSREQITEMID, 43);
        fieldIndexMap.put(FIELD_PSSYSREQITEMNAME, 44);
        fieldIndexMap.put(FIELD_PSSYSSERVICEAPIID, 45);
        fieldIndexMap.put(FIELD_PSSYSSERVICEAPINAME, 46);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 47);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 48);
        fieldIndexMap.put(FIELD_PSSYSUNIRESID, 49);
        fieldIndexMap.put(FIELD_PSSYSUNIRESNAME, 50);
        fieldIndexMap.put(FIELD_SDPSDEVIEWID, 51);
        fieldIndexMap.put(FIELD_SDPSDEVIEWNAME, 52);
        fieldIndexMap.put(FIELD_UPDATEDATE, 53);
        fieldIndexMap.put(FIELD_UPDATEMAN, 54);
        fieldIndexMap.put(FIELD_USERACTION, 55);
        fieldIndexMap.put(FIELD_USERCAT, 56);
        fieldIndexMap.put(FIELD_USERTAG, 57);
        fieldIndexMap.put(FIELD_USERTAG2, 58);
        fieldIndexMap.put(FIELD_USERTAG3, 59);
        fieldIndexMap.put(FIELD_USERTAG4, 60);
        fieldIndexMap.put(FIELD_VALIDFLAG, 61);
    }
}

