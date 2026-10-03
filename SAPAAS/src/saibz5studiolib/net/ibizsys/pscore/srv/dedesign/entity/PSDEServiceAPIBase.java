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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDESADetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDESAVR;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDESADetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDESAVRService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDESARS;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysServiceAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysTranslator;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUniRes;
import net.ibizsys.pscore.srv.sysdesign.service.PSDESARSService;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysServiceAPIService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysTranslatorService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUniResService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEServiceAPIBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEServiceAPIBase.class);
    public static final String FIELD_ACCCTRLARCH = "ACCCTRLARCH";
    public static final String FIELD_APITAG = "APITAG";
    public static final String FIELD_APITAG2 = "APITAG2";
    public static final String FIELD_BASECLSPARAMS = "BASECLSPARAMS";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CODENAME2 = "CODENAME2";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMCODE = "CUSTOMCODE";
    public static final String FIELD_CUSTOMMODE = "CUSTOMMODE";
    public static final String FIELD_DATAACCMODE = "DATAACCMODE";
    public static final String FIELD_DEFGROUPMODE = "DEFGROUPMODE";
    public static final String FIELD_DELOGICNAME = "DELOGICNAME";
    public static final String FIELD_ENABLEDATAEXPORT = "ENABLEDATAEXPORT";
    public static final String FIELD_ENABLEDATAIMPORT = "ENABLEDATAIMPORT";
    public static final String FIELD_ENABLEDEACTION = "ENABLEDEACTION";
    public static final String FIELD_ENABLEDEDATASET = "ENABLEDEDATASET";
    public static final String FIELD_ENABLESELECT = "ENABLESELECT";
    public static final String FIELD_ENATEMPDATA = "ENATEMPDATA";
    public static final String FIELD_LNPSLANRESID = "LNPSLANRESID";
    public static final String FIELD_LNPSLANRESNAME = "LNPSLANRESNAME";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MAJORFLAG = "MAJORFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_OUTPSSYSTRANSLATORID = "OUTPSSYSTRANSLATORID";
    public static final String FIELD_OUTPSSYSTRANSLATORNAME = "OUTPSSYSTRANSLATORNAME";
    public static final String FIELD_PSDEFGROUPID = "PSDEFGROUPID";
    public static final String FIELD_PSDEFGROUPNAME = "PSDEFGROUPNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDESERVICEAPIID = "PSDESERVICEAPIID";
    public static final String FIELD_PSDESERVICEAPINAME = "PSDESERVICEAPINAME";
    public static final String FIELD_PSSYSREQITEMID = "PSSYSREQITEMID";
    public static final String FIELD_PSSYSREQITEMNAME = "PSSYSREQITEMNAME";
    public static final String FIELD_PSSYSSERVICEAPIID = "PSSYSSERVICEAPIID";
    public static final String FIELD_PSSYSSERVICEAPINAME = "PSSYSSERVICEAPINAME";
    public static final String FIELD_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String FIELD_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String FIELD_PSSYSUNIRESID = "PSSYSUNIRESID";
    public static final String FIELD_PSSYSUNIRESNAME = "PSSYSUNIRESNAME";
    public static final String FIELD_SERVICEPARAM = "SERVICEPARAM";
    public static final String FIELD_SERVICEPARAM2 = "SERVICEPARAM2";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_ACCCTRLARCH = 0;
    private static final int INDEX_APITAG = 1;
    private static final int INDEX_APITAG2 = 2;
    private static final int INDEX_BASECLSPARAMS = 3;
    private static final int INDEX_CODENAME = 4;
    private static final int INDEX_CODENAME2 = 5;
    private static final int INDEX_CREATEDATE = 6;
    private static final int INDEX_CREATEMAN = 7;
    private static final int INDEX_CUSTOMCODE = 8;
    private static final int INDEX_CUSTOMMODE = 9;
    private static final int INDEX_DATAACCMODE = 10;
    private static final int INDEX_DEFGROUPMODE = 11;
    private static final int INDEX_DELOGICNAME = 12;
    private static final int INDEX_ENABLEDATAEXPORT = 13;
    private static final int INDEX_ENABLEDATAIMPORT = 14;
    private static final int INDEX_ENABLEDEACTION = 15;
    private static final int INDEX_ENABLEDEDATASET = 16;
    private static final int INDEX_ENABLESELECT = 17;
    private static final int INDEX_ENATEMPDATA = 18;
    private static final int INDEX_LNPSLANRESID = 19;
    private static final int INDEX_LNPSLANRESNAME = 20;
    private static final int INDEX_LOCKFLAG = 21;
    private static final int INDEX_LOGICNAME = 22;
    private static final int INDEX_MAJORFLAG = 23;
    private static final int INDEX_MEMO = 24;
    private static final int INDEX_ORDERVALUE = 25;
    private static final int INDEX_OUTPSSYSTRANSLATORID = 26;
    private static final int INDEX_OUTPSSYSTRANSLATORNAME = 27;
    private static final int INDEX_PSDEFGROUPID = 28;
    private static final int INDEX_PSDEFGROUPNAME = 29;
    private static final int INDEX_PSDEID = 30;
    private static final int INDEX_PSDENAME = 31;
    private static final int INDEX_PSDESERVICEAPIID = 32;
    private static final int INDEX_PSDESERVICEAPINAME = 33;
    private static final int INDEX_PSSYSREQITEMID = 34;
    private static final int INDEX_PSSYSREQITEMNAME = 35;
    private static final int INDEX_PSSYSSERVICEAPIID = 36;
    private static final int INDEX_PSSYSSERVICEAPINAME = 37;
    private static final int INDEX_PSSYSSFPLUGINID = 38;
    private static final int INDEX_PSSYSSFPLUGINNAME = 39;
    private static final int INDEX_PSSYSUNIRESID = 40;
    private static final int INDEX_PSSYSUNIRESNAME = 41;
    private static final int INDEX_SERVICEPARAM = 42;
    private static final int INDEX_SERVICEPARAM2 = 43;
    private static final int INDEX_UPDATEDATE = 44;
    private static final int INDEX_UPDATEMAN = 45;
    private static final int INDEX_USERCAT = 46;
    private static final int INDEX_USERTAG = 47;
    private static final int INDEX_USERTAG2 = 48;
    private static final int INDEX_USERTAG3 = 49;
    private static final int INDEX_USERTAG4 = 50;
    private static final int INDEX_VALIDFLAG = 51;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEServiceAPIBase proxyPSDEServiceAPIBase = null;
    private boolean accctrlarchDirtyFlag = false;
    private boolean apitagDirtyFlag = false;
    private boolean apitag2DirtyFlag = false;
    private boolean baseclsparamsDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean codename2DirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customcodeDirtyFlag = false;
    private boolean custommodeDirtyFlag = false;
    private boolean dataaccmodeDirtyFlag = false;
    private boolean defgroupmodeDirtyFlag = false;
    private boolean delogicnameDirtyFlag = false;
    private boolean enabledataexportDirtyFlag = false;
    private boolean enabledataimportDirtyFlag = false;
    private boolean enabledeactionDirtyFlag = false;
    private boolean enablededatasetDirtyFlag = false;
    private boolean enableselectDirtyFlag = false;
    private boolean enatempdataDirtyFlag = false;
    private boolean lnpslanresidDirtyFlag = false;
    private boolean lnpslanresnameDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean majorflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean outpssystranslatoridDirtyFlag = false;
    private boolean outpssystranslatornameDirtyFlag = false;
    private boolean psdefgroupidDirtyFlag = false;
    private boolean psdefgroupnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psdeserviceapiidDirtyFlag = false;
    private boolean psdeserviceapinameDirtyFlag = false;
    private boolean pssysreqitemidDirtyFlag = false;
    private boolean pssysreqitemnameDirtyFlag = false;
    private boolean pssysserviceapiidDirtyFlag = false;
    private boolean pssysserviceapinameDirtyFlag = false;
    private boolean pssyssfpluginidDirtyFlag = false;
    private boolean pssyssfpluginnameDirtyFlag = false;
    private boolean pssysuniresidDirtyFlag = false;
    private boolean pssysuniresnameDirtyFlag = false;
    private boolean serviceparamDirtyFlag = false;
    private boolean serviceparam2DirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="accctrlarch")
    private Integer accctrlarch;
    @Column(name="apitag")
    private String apitag;
    @Column(name="apitag2")
    private String apitag2;
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
    @Column(name="customcode")
    private String customcode;
    @Column(name="custommode")
    private Integer custommode;
    @Column(name="dataaccmode")
    private Integer dataaccmode;
    @Column(name="defgroupmode")
    private String defgroupmode;
    @Column(name="delogicname")
    private String delogicname;
    @Column(name="enabledataexport")
    private Integer enabledataexport;
    @Column(name="enabledataimport")
    private Integer enabledataimport;
    @Column(name="enabledeaction")
    private Integer enabledeaction;
    @Column(name="enablededataset")
    private Integer enablededataset;
    @Column(name="enableselect")
    private Integer enableselect;
    @Column(name="enatempdata")
    private Integer enatempdata;
    @Column(name="lnpslanresid")
    private String lnpslanresid;
    @Column(name="lnpslanresname")
    private String lnpslanresname;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="logicname")
    private String logicname;
    @Column(name="majorflag")
    private Integer majorflag;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="outpssystranslatorid")
    private String outpssystranslatorid;
    @Column(name="outpssystranslatorname")
    private String outpssystranslatorname;
    @Column(name="psdefgroupid")
    private String psdefgroupid;
    @Column(name="psdefgroupname")
    private String psdefgroupname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psdeserviceapiid")
    private String psdeserviceapiid;
    @Column(name="psdeserviceapiname")
    private String psdeserviceapiname;
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
    @Column(name="serviceparam")
    private String serviceparam;
    @Column(name="serviceparam2")
    private String serviceparam2;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
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
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objPSDEFGroupLock = new Integer(1);
    private PSDEFGroup psdefgroup = null;
    private Integer objLNPSLanResLock = new Integer(1);
    private PSLanguageRes lnpslanres = null;
    private Integer objPSSysReqItemLock = new Integer(1);
    private PSSysReqItem pssysreqitem = null;
    private Integer objPSSysServiceAPILock = new Integer(1);
    private PSSysServiceAPI pssysserviceapi = null;
    private Integer objPSSysSFPluginLock = new Integer(1);
    private PSSysSFPlugin pssyssfplugin = null;
    private Integer objOutPSSysTranslatorLock = new Integer(1);
    private PSSysTranslator outpssystranslator = null;
    private Integer objPSSysUniResLock = new Integer(1);
    private PSSysUniRes pssysunires = null;
    private Integer objPSDESADetailsLock = new Integer(1);
    private ArrayList<PSDESADetail> psdesadetails = null;
    private Integer objMinorPSDESARSsLock = new Integer(1);
    private ArrayList<PSDESARS> minorpsdesarss = null;
    private Integer objMajorPSDESARSsLock = new Integer(1);
    private ArrayList<PSDESARS> majorpsdesarss = null;
    private Integer objPSDESAVRsLock = new Integer(1);
    private ArrayList<PSDESAVR> psdesavrs = null;

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

    public void setAPITag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAPITag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.apitag = string;
        this.apitagDirtyFlag = true;
    }

    public String getAPITag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAPITag();
        }
        return this.apitag;
    }

    public boolean isAPITagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAPITagDirty();
        }
        return this.apitagDirtyFlag;
    }

    public void resetAPITag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAPITag();
            return;
        }
        this.apitagDirtyFlag = false;
        this.apitag = null;
    }

    public void setAPITag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAPITag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.apitag2 = string;
        this.apitag2DirtyFlag = true;
    }

    public String getAPITag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAPITag2();
        }
        return this.apitag2;
    }

    public boolean isAPITag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAPITag2Dirty();
        }
        return this.apitag2DirtyFlag;
    }

    public void resetAPITag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAPITag2();
            return;
        }
        this.apitag2DirtyFlag = false;
        this.apitag2 = null;
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

    public void setCustomCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.customcode = string;
        this.customcodeDirtyFlag = true;
    }

    public String getCustomCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomCode();
        }
        return this.customcode;
    }

    public boolean isCustomCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomCodeDirty();
        }
        return this.customcodeDirtyFlag;
    }

    public void resetCustomCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomCode();
            return;
        }
        this.customcodeDirtyFlag = false;
        this.customcode = null;
    }

    public void setCustomMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomMode(n);
            return;
        }
        this.custommode = n;
        this.custommodeDirtyFlag = true;
    }

    public Integer getCustomMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomMode();
        }
        return this.custommode;
    }

    public boolean isCustomModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomModeDirty();
        }
        return this.custommodeDirtyFlag;
    }

    public void resetCustomMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomMode();
            return;
        }
        this.custommodeDirtyFlag = false;
        this.custommode = null;
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

    public void setEnableDataExport(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableDataExport(n);
            return;
        }
        this.enabledataexport = n;
        this.enabledataexportDirtyFlag = true;
    }

    public Integer getEnableDataExport() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableDataExport();
        }
        return this.enabledataexport;
    }

    public boolean isEnableDataExportDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableDataExportDirty();
        }
        return this.enabledataexportDirtyFlag;
    }

    public void resetEnableDataExport() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableDataExport();
            return;
        }
        this.enabledataexportDirtyFlag = false;
        this.enabledataexport = null;
    }

    public void setEnableDataImport(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableDataImport(n);
            return;
        }
        this.enabledataimport = n;
        this.enabledataimportDirtyFlag = true;
    }

    public Integer getEnableDataImport() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableDataImport();
        }
        return this.enabledataimport;
    }

    public boolean isEnableDataImportDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableDataImportDirty();
        }
        return this.enabledataimportDirtyFlag;
    }

    public void resetEnableDataImport() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableDataImport();
            return;
        }
        this.enabledataimportDirtyFlag = false;
        this.enabledataimport = null;
    }

    public void setEnableDEAction(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableDEAction(n);
            return;
        }
        this.enabledeaction = n;
        this.enabledeactionDirtyFlag = true;
    }

    public Integer getEnableDEAction() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableDEAction();
        }
        return this.enabledeaction;
    }

    public boolean isEnableDEActionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableDEActionDirty();
        }
        return this.enabledeactionDirtyFlag;
    }

    public void resetEnableDEAction() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableDEAction();
            return;
        }
        this.enabledeactionDirtyFlag = false;
        this.enabledeaction = null;
    }

    public void setEnableDEDataSet(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableDEDataSet(n);
            return;
        }
        this.enablededataset = n;
        this.enablededatasetDirtyFlag = true;
    }

    public Integer getEnableDEDataSet() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableDEDataSet();
        }
        return this.enablededataset;
    }

    public boolean isEnableDEDataSetDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableDEDataSetDirty();
        }
        return this.enablededatasetDirtyFlag;
    }

    public void resetEnableDEDataSet() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableDEDataSet();
            return;
        }
        this.enablededatasetDirtyFlag = false;
        this.enablededataset = null;
    }

    public void setEnableSelect(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableSelect(n);
            return;
        }
        this.enableselect = n;
        this.enableselectDirtyFlag = true;
    }

    public Integer getEnableSelect() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableSelect();
        }
        return this.enableselect;
    }

    public boolean isEnableSelectDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableSelectDirty();
        }
        return this.enableselectDirtyFlag;
    }

    public void resetEnableSelect() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableSelect();
            return;
        }
        this.enableselectDirtyFlag = false;
        this.enableselect = null;
    }

    public void setEnaTempData(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnaTempData(n);
            return;
        }
        this.enatempdata = n;
        this.enatempdataDirtyFlag = true;
    }

    public Integer getEnaTempData() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnaTempData();
        }
        return this.enatempdata;
    }

    public boolean isEnaTempDataDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnaTempDataDirty();
        }
        return this.enatempdataDirtyFlag;
    }

    public void resetEnaTempData() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnaTempData();
            return;
        }
        this.enatempdataDirtyFlag = false;
        this.enatempdata = null;
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

    public void setOutPSSysTranslatorId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOutPSSysTranslatorId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.outpssystranslatorid = string;
        this.outpssystranslatoridDirtyFlag = true;
    }

    public String getOutPSSysTranslatorId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOutPSSysTranslatorId();
        }
        return this.outpssystranslatorid;
    }

    public boolean isOutPSSysTranslatorIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOutPSSysTranslatorIdDirty();
        }
        return this.outpssystranslatoridDirtyFlag;
    }

    public void resetOutPSSysTranslatorId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOutPSSysTranslatorId();
            return;
        }
        this.outpssystranslatoridDirtyFlag = false;
        this.outpssystranslatorid = null;
    }

    public void setOutPSSysTranslatorName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOutPSSysTranslatorName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.outpssystranslatorname = string;
        this.outpssystranslatornameDirtyFlag = true;
    }

    public String getOutPSSysTranslatorName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOutPSSysTranslatorName();
        }
        return this.outpssystranslatorname;
    }

    public boolean isOutPSSysTranslatorNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOutPSSysTranslatorNameDirty();
        }
        return this.outpssystranslatornameDirtyFlag;
    }

    public void resetOutPSSysTranslatorName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOutPSSysTranslatorName();
            return;
        }
        this.outpssystranslatornameDirtyFlag = false;
        this.outpssystranslatorname = null;
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

    public void setServiceParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setServiceParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.serviceparam = string;
        this.serviceparamDirtyFlag = true;
    }

    public String getServiceParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getServiceParam();
        }
        return this.serviceparam;
    }

    public boolean isServiceParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isServiceParamDirty();
        }
        return this.serviceparamDirtyFlag;
    }

    public void resetServiceParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetServiceParam();
            return;
        }
        this.serviceparamDirtyFlag = false;
        this.serviceparam = null;
    }

    public void setServiceParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setServiceParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.serviceparam2 = string;
        this.serviceparam2DirtyFlag = true;
    }

    public String getServiceParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getServiceParam2();
        }
        return this.serviceparam2;
    }

    public boolean isServiceParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isServiceParam2Dirty();
        }
        return this.serviceparam2DirtyFlag;
    }

    public void resetServiceParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetServiceParam2();
            return;
        }
        this.serviceparam2DirtyFlag = false;
        this.serviceparam2 = null;
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
        PSDEServiceAPIBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEServiceAPIBase pSDEServiceAPIBase) {
        pSDEServiceAPIBase.resetAccCtrlArch();
        pSDEServiceAPIBase.resetAPITag();
        pSDEServiceAPIBase.resetAPITag2();
        pSDEServiceAPIBase.resetBaseClsParams();
        pSDEServiceAPIBase.resetCodeName();
        pSDEServiceAPIBase.resetCodeName2();
        pSDEServiceAPIBase.resetCreateDate();
        pSDEServiceAPIBase.resetCreateMan();
        pSDEServiceAPIBase.resetCustomCode();
        pSDEServiceAPIBase.resetCustomMode();
        pSDEServiceAPIBase.resetDataAccMode();
        pSDEServiceAPIBase.resetDEFGroupMode();
        pSDEServiceAPIBase.resetDELogicName();
        pSDEServiceAPIBase.resetEnableDataExport();
        pSDEServiceAPIBase.resetEnableDataImport();
        pSDEServiceAPIBase.resetEnableDEAction();
        pSDEServiceAPIBase.resetEnableDEDataSet();
        pSDEServiceAPIBase.resetEnableSelect();
        pSDEServiceAPIBase.resetEnaTempData();
        pSDEServiceAPIBase.resetLNPSLanResId();
        pSDEServiceAPIBase.resetLNPSLanResName();
        pSDEServiceAPIBase.resetLockFlag();
        pSDEServiceAPIBase.resetLogicName();
        pSDEServiceAPIBase.resetMajorFlag();
        pSDEServiceAPIBase.resetMemo();
        pSDEServiceAPIBase.resetOrderValue();
        pSDEServiceAPIBase.resetOutPSSysTranslatorId();
        pSDEServiceAPIBase.resetOutPSSysTranslatorName();
        pSDEServiceAPIBase.resetPSDEFGroupId();
        pSDEServiceAPIBase.resetPSDEFGroupName();
        pSDEServiceAPIBase.resetPSDEId();
        pSDEServiceAPIBase.resetPSDEName();
        pSDEServiceAPIBase.resetPSDEServiceAPIId();
        pSDEServiceAPIBase.resetPSDEServiceAPIName();
        pSDEServiceAPIBase.resetPSSysReqItemId();
        pSDEServiceAPIBase.resetPSSysReqItemName();
        pSDEServiceAPIBase.resetPSSysServiceAPIId();
        pSDEServiceAPIBase.resetPSSysServiceAPIName();
        pSDEServiceAPIBase.resetPSSysSFPluginId();
        pSDEServiceAPIBase.resetPSSysSFPluginName();
        pSDEServiceAPIBase.resetPSSysUniResId();
        pSDEServiceAPIBase.resetPSSysUniResName();
        pSDEServiceAPIBase.resetServiceParam();
        pSDEServiceAPIBase.resetServiceParam2();
        pSDEServiceAPIBase.resetUpdateDate();
        pSDEServiceAPIBase.resetUpdateMan();
        pSDEServiceAPIBase.resetUserCat();
        pSDEServiceAPIBase.resetUserTag();
        pSDEServiceAPIBase.resetUserTag2();
        pSDEServiceAPIBase.resetUserTag3();
        pSDEServiceAPIBase.resetUserTag4();
        pSDEServiceAPIBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAccCtrlArchDirty()) {
            hashMap.put(FIELD_ACCCTRLARCH, this.getAccCtrlArch());
        }
        if (!bl || this.isAPITagDirty()) {
            hashMap.put(FIELD_APITAG, this.getAPITag());
        }
        if (!bl || this.isAPITag2Dirty()) {
            hashMap.put(FIELD_APITAG2, this.getAPITag2());
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
        if (!bl || this.isCustomCodeDirty()) {
            hashMap.put(FIELD_CUSTOMCODE, this.getCustomCode());
        }
        if (!bl || this.isCustomModeDirty()) {
            hashMap.put(FIELD_CUSTOMMODE, this.getCustomMode());
        }
        if (!bl || this.isDataAccModeDirty()) {
            hashMap.put(FIELD_DATAACCMODE, this.getDataAccMode());
        }
        if (!bl || this.isDEFGroupModeDirty()) {
            hashMap.put(FIELD_DEFGROUPMODE, this.getDEFGroupMode());
        }
        if (!bl || this.isDELogicNameDirty()) {
            hashMap.put(FIELD_DELOGICNAME, this.getDELogicName());
        }
        if (!bl || this.isEnableDataExportDirty()) {
            hashMap.put(FIELD_ENABLEDATAEXPORT, this.getEnableDataExport());
        }
        if (!bl || this.isEnableDataImportDirty()) {
            hashMap.put(FIELD_ENABLEDATAIMPORT, this.getEnableDataImport());
        }
        if (!bl || this.isEnableDEActionDirty()) {
            hashMap.put(FIELD_ENABLEDEACTION, this.getEnableDEAction());
        }
        if (!bl || this.isEnableDEDataSetDirty()) {
            hashMap.put(FIELD_ENABLEDEDATASET, this.getEnableDEDataSet());
        }
        if (!bl || this.isEnableSelectDirty()) {
            hashMap.put(FIELD_ENABLESELECT, this.getEnableSelect());
        }
        if (!bl || this.isEnaTempDataDirty()) {
            hashMap.put(FIELD_ENATEMPDATA, this.getEnaTempData());
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
        if (!bl || this.isMajorFlagDirty()) {
            hashMap.put(FIELD_MAJORFLAG, this.getMajorFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isOutPSSysTranslatorIdDirty()) {
            hashMap.put(FIELD_OUTPSSYSTRANSLATORID, this.getOutPSSysTranslatorId());
        }
        if (!bl || this.isOutPSSysTranslatorNameDirty()) {
            hashMap.put(FIELD_OUTPSSYSTRANSLATORNAME, this.getOutPSSysTranslatorName());
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
        if (!bl || this.isPSDEServiceAPIIdDirty()) {
            hashMap.put(FIELD_PSDESERVICEAPIID, this.getPSDEServiceAPIId());
        }
        if (!bl || this.isPSDEServiceAPINameDirty()) {
            hashMap.put(FIELD_PSDESERVICEAPINAME, this.getPSDEServiceAPIName());
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
        if (!bl || this.isServiceParamDirty()) {
            hashMap.put(FIELD_SERVICEPARAM, this.getServiceParam());
        }
        if (!bl || this.isServiceParam2Dirty()) {
            hashMap.put(FIELD_SERVICEPARAM2, this.getServiceParam2());
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
        return PSDEServiceAPIBase.get(this, n);
    }

    private static Object get(PSDEServiceAPIBase pSDEServiceAPIBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEServiceAPIBase.getAccCtrlArch();
            }
            case 1: {
                return pSDEServiceAPIBase.getAPITag();
            }
            case 2: {
                return pSDEServiceAPIBase.getAPITag2();
            }
            case 3: {
                return pSDEServiceAPIBase.getBaseClsParams();
            }
            case 4: {
                return pSDEServiceAPIBase.getCodeName();
            }
            case 5: {
                return pSDEServiceAPIBase.getCodeName2();
            }
            case 6: {
                return pSDEServiceAPIBase.getCreateDate();
            }
            case 7: {
                return pSDEServiceAPIBase.getCreateMan();
            }
            case 8: {
                return pSDEServiceAPIBase.getCustomCode();
            }
            case 9: {
                return pSDEServiceAPIBase.getCustomMode();
            }
            case 10: {
                return pSDEServiceAPIBase.getDataAccMode();
            }
            case 11: {
                return pSDEServiceAPIBase.getDEFGroupMode();
            }
            case 12: {
                return pSDEServiceAPIBase.getDELogicName();
            }
            case 13: {
                return pSDEServiceAPIBase.getEnableDataExport();
            }
            case 14: {
                return pSDEServiceAPIBase.getEnableDataImport();
            }
            case 15: {
                return pSDEServiceAPIBase.getEnableDEAction();
            }
            case 16: {
                return pSDEServiceAPIBase.getEnableDEDataSet();
            }
            case 17: {
                return pSDEServiceAPIBase.getEnableSelect();
            }
            case 18: {
                return pSDEServiceAPIBase.getEnaTempData();
            }
            case 19: {
                return pSDEServiceAPIBase.getLNPSLanResId();
            }
            case 20: {
                return pSDEServiceAPIBase.getLNPSLanResName();
            }
            case 21: {
                return pSDEServiceAPIBase.getLockFlag();
            }
            case 22: {
                return pSDEServiceAPIBase.getLogicName();
            }
            case 23: {
                return pSDEServiceAPIBase.getMajorFlag();
            }
            case 24: {
                return pSDEServiceAPIBase.getMemo();
            }
            case 25: {
                return pSDEServiceAPIBase.getOrderValue();
            }
            case 26: {
                return pSDEServiceAPIBase.getOutPSSysTranslatorId();
            }
            case 27: {
                return pSDEServiceAPIBase.getOutPSSysTranslatorName();
            }
            case 28: {
                return pSDEServiceAPIBase.getPSDEFGroupId();
            }
            case 29: {
                return pSDEServiceAPIBase.getPSDEFGroupName();
            }
            case 30: {
                return pSDEServiceAPIBase.getPSDEId();
            }
            case 31: {
                return pSDEServiceAPIBase.getPSDEName();
            }
            case 32: {
                return pSDEServiceAPIBase.getPSDEServiceAPIId();
            }
            case 33: {
                return pSDEServiceAPIBase.getPSDEServiceAPIName();
            }
            case 34: {
                return pSDEServiceAPIBase.getPSSysReqItemId();
            }
            case 35: {
                return pSDEServiceAPIBase.getPSSysReqItemName();
            }
            case 36: {
                return pSDEServiceAPIBase.getPSSysServiceAPIId();
            }
            case 37: {
                return pSDEServiceAPIBase.getPSSysServiceAPIName();
            }
            case 38: {
                return pSDEServiceAPIBase.getPSSysSFPluginId();
            }
            case 39: {
                return pSDEServiceAPIBase.getPSSysSFPluginName();
            }
            case 40: {
                return pSDEServiceAPIBase.getPSSysUniResId();
            }
            case 41: {
                return pSDEServiceAPIBase.getPSSysUniResName();
            }
            case 42: {
                return pSDEServiceAPIBase.getServiceParam();
            }
            case 43: {
                return pSDEServiceAPIBase.getServiceParam2();
            }
            case 44: {
                return pSDEServiceAPIBase.getUpdateDate();
            }
            case 45: {
                return pSDEServiceAPIBase.getUpdateMan();
            }
            case 46: {
                return pSDEServiceAPIBase.getUserCat();
            }
            case 47: {
                return pSDEServiceAPIBase.getUserTag();
            }
            case 48: {
                return pSDEServiceAPIBase.getUserTag2();
            }
            case 49: {
                return pSDEServiceAPIBase.getUserTag3();
            }
            case 50: {
                return pSDEServiceAPIBase.getUserTag4();
            }
            case 51: {
                return pSDEServiceAPIBase.getValidFlag();
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
        PSDEServiceAPIBase.set(this, n, object);
    }

    private static void set(PSDEServiceAPIBase pSDEServiceAPIBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEServiceAPIBase.setAccCtrlArch(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSDEServiceAPIBase.setAPITag(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEServiceAPIBase.setAPITag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEServiceAPIBase.setBaseClsParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEServiceAPIBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEServiceAPIBase.setCodeName2(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEServiceAPIBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSDEServiceAPIBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEServiceAPIBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEServiceAPIBase.setCustomMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSDEServiceAPIBase.setDataAccMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSDEServiceAPIBase.setDEFGroupMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEServiceAPIBase.setDELogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEServiceAPIBase.setEnableDataExport(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSDEServiceAPIBase.setEnableDataImport(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSDEServiceAPIBase.setEnableDEAction(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSDEServiceAPIBase.setEnableDEDataSet(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 17: {
                pSDEServiceAPIBase.setEnableSelect(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 18: {
                pSDEServiceAPIBase.setEnaTempData(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 19: {
                pSDEServiceAPIBase.setLNPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDEServiceAPIBase.setLNPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEServiceAPIBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 22: {
                pSDEServiceAPIBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDEServiceAPIBase.setMajorFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 24: {
                pSDEServiceAPIBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDEServiceAPIBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 26: {
                pSDEServiceAPIBase.setOutPSSysTranslatorId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDEServiceAPIBase.setOutPSSysTranslatorName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDEServiceAPIBase.setPSDEFGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDEServiceAPIBase.setPSDEFGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDEServiceAPIBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDEServiceAPIBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDEServiceAPIBase.setPSDEServiceAPIId(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDEServiceAPIBase.setPSDEServiceAPIName(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDEServiceAPIBase.setPSSysReqItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDEServiceAPIBase.setPSSysReqItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDEServiceAPIBase.setPSSysServiceAPIId(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSDEServiceAPIBase.setPSSysServiceAPIName(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDEServiceAPIBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSDEServiceAPIBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSDEServiceAPIBase.setPSSysUniResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSDEServiceAPIBase.setPSSysUniResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSDEServiceAPIBase.setServiceParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSDEServiceAPIBase.setServiceParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSDEServiceAPIBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 45: {
                pSDEServiceAPIBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSDEServiceAPIBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSDEServiceAPIBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSDEServiceAPIBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSDEServiceAPIBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSDEServiceAPIBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSDEServiceAPIBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDEServiceAPIBase.isNull(this, n);
    }

    private static boolean isNull(PSDEServiceAPIBase pSDEServiceAPIBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEServiceAPIBase.getAccCtrlArch() == null;
            }
            case 1: {
                return pSDEServiceAPIBase.getAPITag() == null;
            }
            case 2: {
                return pSDEServiceAPIBase.getAPITag2() == null;
            }
            case 3: {
                return pSDEServiceAPIBase.getBaseClsParams() == null;
            }
            case 4: {
                return pSDEServiceAPIBase.getCodeName() == null;
            }
            case 5: {
                return pSDEServiceAPIBase.getCodeName2() == null;
            }
            case 6: {
                return pSDEServiceAPIBase.getCreateDate() == null;
            }
            case 7: {
                return pSDEServiceAPIBase.getCreateMan() == null;
            }
            case 8: {
                return pSDEServiceAPIBase.getCustomCode() == null;
            }
            case 9: {
                return pSDEServiceAPIBase.getCustomMode() == null;
            }
            case 10: {
                return pSDEServiceAPIBase.getDataAccMode() == null;
            }
            case 11: {
                return pSDEServiceAPIBase.getDEFGroupMode() == null;
            }
            case 12: {
                return pSDEServiceAPIBase.getDELogicName() == null;
            }
            case 13: {
                return pSDEServiceAPIBase.getEnableDataExport() == null;
            }
            case 14: {
                return pSDEServiceAPIBase.getEnableDataImport() == null;
            }
            case 15: {
                return pSDEServiceAPIBase.getEnableDEAction() == null;
            }
            case 16: {
                return pSDEServiceAPIBase.getEnableDEDataSet() == null;
            }
            case 17: {
                return pSDEServiceAPIBase.getEnableSelect() == null;
            }
            case 18: {
                return pSDEServiceAPIBase.getEnaTempData() == null;
            }
            case 19: {
                return pSDEServiceAPIBase.getLNPSLanResId() == null;
            }
            case 20: {
                return pSDEServiceAPIBase.getLNPSLanResName() == null;
            }
            case 21: {
                return pSDEServiceAPIBase.getLockFlag() == null;
            }
            case 22: {
                return pSDEServiceAPIBase.getLogicName() == null;
            }
            case 23: {
                return pSDEServiceAPIBase.getMajorFlag() == null;
            }
            case 24: {
                return pSDEServiceAPIBase.getMemo() == null;
            }
            case 25: {
                return pSDEServiceAPIBase.getOrderValue() == null;
            }
            case 26: {
                return pSDEServiceAPIBase.getOutPSSysTranslatorId() == null;
            }
            case 27: {
                return pSDEServiceAPIBase.getOutPSSysTranslatorName() == null;
            }
            case 28: {
                return pSDEServiceAPIBase.getPSDEFGroupId() == null;
            }
            case 29: {
                return pSDEServiceAPIBase.getPSDEFGroupName() == null;
            }
            case 30: {
                return pSDEServiceAPIBase.getPSDEId() == null;
            }
            case 31: {
                return pSDEServiceAPIBase.getPSDEName() == null;
            }
            case 32: {
                return pSDEServiceAPIBase.getPSDEServiceAPIId() == null;
            }
            case 33: {
                return pSDEServiceAPIBase.getPSDEServiceAPIName() == null;
            }
            case 34: {
                return pSDEServiceAPIBase.getPSSysReqItemId() == null;
            }
            case 35: {
                return pSDEServiceAPIBase.getPSSysReqItemName() == null;
            }
            case 36: {
                return pSDEServiceAPIBase.getPSSysServiceAPIId() == null;
            }
            case 37: {
                return pSDEServiceAPIBase.getPSSysServiceAPIName() == null;
            }
            case 38: {
                return pSDEServiceAPIBase.getPSSysSFPluginId() == null;
            }
            case 39: {
                return pSDEServiceAPIBase.getPSSysSFPluginName() == null;
            }
            case 40: {
                return pSDEServiceAPIBase.getPSSysUniResId() == null;
            }
            case 41: {
                return pSDEServiceAPIBase.getPSSysUniResName() == null;
            }
            case 42: {
                return pSDEServiceAPIBase.getServiceParam() == null;
            }
            case 43: {
                return pSDEServiceAPIBase.getServiceParam2() == null;
            }
            case 44: {
                return pSDEServiceAPIBase.getUpdateDate() == null;
            }
            case 45: {
                return pSDEServiceAPIBase.getUpdateMan() == null;
            }
            case 46: {
                return pSDEServiceAPIBase.getUserCat() == null;
            }
            case 47: {
                return pSDEServiceAPIBase.getUserTag() == null;
            }
            case 48: {
                return pSDEServiceAPIBase.getUserTag2() == null;
            }
            case 49: {
                return pSDEServiceAPIBase.getUserTag3() == null;
            }
            case 50: {
                return pSDEServiceAPIBase.getUserTag4() == null;
            }
            case 51: {
                return pSDEServiceAPIBase.getValidFlag() == null;
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
        return PSDEServiceAPIBase.contains(this, n);
    }

    private static boolean contains(PSDEServiceAPIBase pSDEServiceAPIBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEServiceAPIBase.isAccCtrlArchDirty();
            }
            case 1: {
                return pSDEServiceAPIBase.isAPITagDirty();
            }
            case 2: {
                return pSDEServiceAPIBase.isAPITag2Dirty();
            }
            case 3: {
                return pSDEServiceAPIBase.isBaseClsParamsDirty();
            }
            case 4: {
                return pSDEServiceAPIBase.isCodeNameDirty();
            }
            case 5: {
                return pSDEServiceAPIBase.isCodeName2Dirty();
            }
            case 6: {
                return pSDEServiceAPIBase.isCreateDateDirty();
            }
            case 7: {
                return pSDEServiceAPIBase.isCreateManDirty();
            }
            case 8: {
                return pSDEServiceAPIBase.isCustomCodeDirty();
            }
            case 9: {
                return pSDEServiceAPIBase.isCustomModeDirty();
            }
            case 10: {
                return pSDEServiceAPIBase.isDataAccModeDirty();
            }
            case 11: {
                return pSDEServiceAPIBase.isDEFGroupModeDirty();
            }
            case 12: {
                return pSDEServiceAPIBase.isDELogicNameDirty();
            }
            case 13: {
                return pSDEServiceAPIBase.isEnableDataExportDirty();
            }
            case 14: {
                return pSDEServiceAPIBase.isEnableDataImportDirty();
            }
            case 15: {
                return pSDEServiceAPIBase.isEnableDEActionDirty();
            }
            case 16: {
                return pSDEServiceAPIBase.isEnableDEDataSetDirty();
            }
            case 17: {
                return pSDEServiceAPIBase.isEnableSelectDirty();
            }
            case 18: {
                return pSDEServiceAPIBase.isEnaTempDataDirty();
            }
            case 19: {
                return pSDEServiceAPIBase.isLNPSLanResIdDirty();
            }
            case 20: {
                return pSDEServiceAPIBase.isLNPSLanResNameDirty();
            }
            case 21: {
                return pSDEServiceAPIBase.isLockFlagDirty();
            }
            case 22: {
                return pSDEServiceAPIBase.isLogicNameDirty();
            }
            case 23: {
                return pSDEServiceAPIBase.isMajorFlagDirty();
            }
            case 24: {
                return pSDEServiceAPIBase.isMemoDirty();
            }
            case 25: {
                return pSDEServiceAPIBase.isOrderValueDirty();
            }
            case 26: {
                return pSDEServiceAPIBase.isOutPSSysTranslatorIdDirty();
            }
            case 27: {
                return pSDEServiceAPIBase.isOutPSSysTranslatorNameDirty();
            }
            case 28: {
                return pSDEServiceAPIBase.isPSDEFGroupIdDirty();
            }
            case 29: {
                return pSDEServiceAPIBase.isPSDEFGroupNameDirty();
            }
            case 30: {
                return pSDEServiceAPIBase.isPSDEIdDirty();
            }
            case 31: {
                return pSDEServiceAPIBase.isPSDENameDirty();
            }
            case 32: {
                return pSDEServiceAPIBase.isPSDEServiceAPIIdDirty();
            }
            case 33: {
                return pSDEServiceAPIBase.isPSDEServiceAPINameDirty();
            }
            case 34: {
                return pSDEServiceAPIBase.isPSSysReqItemIdDirty();
            }
            case 35: {
                return pSDEServiceAPIBase.isPSSysReqItemNameDirty();
            }
            case 36: {
                return pSDEServiceAPIBase.isPSSysServiceAPIIdDirty();
            }
            case 37: {
                return pSDEServiceAPIBase.isPSSysServiceAPINameDirty();
            }
            case 38: {
                return pSDEServiceAPIBase.isPSSysSFPluginIdDirty();
            }
            case 39: {
                return pSDEServiceAPIBase.isPSSysSFPluginNameDirty();
            }
            case 40: {
                return pSDEServiceAPIBase.isPSSysUniResIdDirty();
            }
            case 41: {
                return pSDEServiceAPIBase.isPSSysUniResNameDirty();
            }
            case 42: {
                return pSDEServiceAPIBase.isServiceParamDirty();
            }
            case 43: {
                return pSDEServiceAPIBase.isServiceParam2Dirty();
            }
            case 44: {
                return pSDEServiceAPIBase.isUpdateDateDirty();
            }
            case 45: {
                return pSDEServiceAPIBase.isUpdateManDirty();
            }
            case 46: {
                return pSDEServiceAPIBase.isUserCatDirty();
            }
            case 47: {
                return pSDEServiceAPIBase.isUserTagDirty();
            }
            case 48: {
                return pSDEServiceAPIBase.isUserTag2Dirty();
            }
            case 49: {
                return pSDEServiceAPIBase.isUserTag3Dirty();
            }
            case 50: {
                return pSDEServiceAPIBase.isUserTag4Dirty();
            }
            case 51: {
                return pSDEServiceAPIBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEServiceAPIBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEServiceAPIBase pSDEServiceAPIBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEServiceAPIBase.getAccCtrlArch() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"accctrlarch", (Object)PSDEServiceAPIBase.getJSONValue((Object)pSDEServiceAPIBase.getAccCtrlArch()), (boolean)false);
        }
        if (bl || pSDEServiceAPIBase.getAPITag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"apitag", (Object)PSDEServiceAPIBase.getJSONValue((Object)pSDEServiceAPIBase.getAPITag()), (boolean)false);
        }
        if (bl || pSDEServiceAPIBase.getAPITag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"apitag2", (Object)PSDEServiceAPIBase.getJSONValue((Object)pSDEServiceAPIBase.getAPITag2()), (boolean)false);
        }
        if (bl || pSDEServiceAPIBase.getBaseClsParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"baseclsparams", (Object)PSDEServiceAPIBase.getJSONValue((Object)pSDEServiceAPIBase.getBaseClsParams()), (boolean)false);
        }
        if (bl || pSDEServiceAPIBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDEServiceAPIBase.getJSONValue((Object)pSDEServiceAPIBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDEServiceAPIBase.getCodeName2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename2", (Object)PSDEServiceAPIBase.getJSONValue((Object)pSDEServiceAPIBase.getCodeName2()), (boolean)false);
        }
        if (bl || pSDEServiceAPIBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEServiceAPIBase.getJSONValue((Object)pSDEServiceAPIBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEServiceAPIBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEServiceAPIBase.getJSONValue((Object)pSDEServiceAPIBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEServiceAPIBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSDEServiceAPIBase.getJSONValue((Object)pSDEServiceAPIBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSDEServiceAPIBase.getCustomMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"custommode", (Object)PSDEServiceAPIBase.getJSONValue((Object)pSDEServiceAPIBase.getCustomMode()), (boolean)false);
        }
        if (bl || pSDEServiceAPIBase.getDataAccMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dataaccmode", (Object)PSDEServiceAPIBase.getJSONValue((Object)pSDEServiceAPIBase.getDataAccMode()), (boolean)false);
        }
        if (bl || pSDEServiceAPIBase.getDEFGroupMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defgroupmode", (Object)PSDEServiceAPIBase.getJSONValue((Object)pSDEServiceAPIBase.getDEFGroupMode()), (boolean)false);
        }
        if (bl || pSDEServiceAPIBase.getDELogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"delogicname", (Object)PSDEServiceAPIBase.getJSONValue((Object)pSDEServiceAPIBase.getDELogicName()), (boolean)false);
        }
        if (bl || pSDEServiceAPIBase.getEnableDataExport() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enabledataexport", (Object)PSDEServiceAPIBase.getJSONValue((Object)pSDEServiceAPIBase.getEnableDataExport()), (boolean)false);
        }
        if (bl || pSDEServiceAPIBase.getEnableDataImport() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enabledataimport", (Object)PSDEServiceAPIBase.getJSONValue((Object)pSDEServiceAPIBase.getEnableDataImport()), (boolean)false);
        }
        if (bl || pSDEServiceAPIBase.getEnableDEAction() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enabledeaction", (Object)PSDEServiceAPIBase.getJSONValue((Object)pSDEServiceAPIBase.getEnableDEAction()), (boolean)false);
        }
        if (bl || pSDEServiceAPIBase.getEnableDEDataSet() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablededataset", (Object)PSDEServiceAPIBase.getJSONValue((Object)pSDEServiceAPIBase.getEnableDEDataSet()), (boolean)false);
        }
        if (bl || pSDEServiceAPIBase.getEnableSelect() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableselect", (Object)PSDEServiceAPIBase.getJSONValue((Object)pSDEServiceAPIBase.getEnableSelect()), (boolean)false);
        }
        if (bl || pSDEServiceAPIBase.getEnaTempData() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enatempdata", (Object)PSDEServiceAPIBase.getJSONValue((Object)pSDEServiceAPIBase.getEnaTempData()), (boolean)false);
        }
        if (bl || pSDEServiceAPIBase.getLNPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lnpslanresid", (Object)PSDEServiceAPIBase.getJSONValue((Object)pSDEServiceAPIBase.getLNPSLanResId()), (boolean)false);
        }
        if (bl || pSDEServiceAPIBase.getLNPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lnpslanresname", (Object)PSDEServiceAPIBase.getJSONValue((Object)pSDEServiceAPIBase.getLNPSLanResName()), (boolean)false);
        }
        if (bl || pSDEServiceAPIBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSDEServiceAPIBase.getJSONValue((Object)pSDEServiceAPIBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSDEServiceAPIBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSDEServiceAPIBase.getJSONValue((Object)pSDEServiceAPIBase.getLogicName()), (boolean)false);
        }
        if (bl || pSDEServiceAPIBase.getMajorFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"majorflag", (Object)PSDEServiceAPIBase.getJSONValue((Object)pSDEServiceAPIBase.getMajorFlag()), (boolean)false);
        }
        if (bl || pSDEServiceAPIBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEServiceAPIBase.getJSONValue((Object)pSDEServiceAPIBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEServiceAPIBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDEServiceAPIBase.getJSONValue((Object)pSDEServiceAPIBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDEServiceAPIBase.getOutPSSysTranslatorId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"outpssystranslatorid", (Object)PSDEServiceAPIBase.getJSONValue((Object)pSDEServiceAPIBase.getOutPSSysTranslatorId()), (boolean)false);
        }
        if (bl || pSDEServiceAPIBase.getOutPSSysTranslatorName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"outpssystranslatorname", (Object)PSDEServiceAPIBase.getJSONValue((Object)pSDEServiceAPIBase.getOutPSSysTranslatorName()), (boolean)false);
        }
        if (bl || pSDEServiceAPIBase.getPSDEFGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefgroupid", (Object)PSDEServiceAPIBase.getJSONValue((Object)pSDEServiceAPIBase.getPSDEFGroupId()), (boolean)false);
        }
        if (bl || pSDEServiceAPIBase.getPSDEFGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefgroupname", (Object)PSDEServiceAPIBase.getJSONValue((Object)pSDEServiceAPIBase.getPSDEFGroupName()), (boolean)false);
        }
        if (bl || pSDEServiceAPIBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEServiceAPIBase.getJSONValue((Object)pSDEServiceAPIBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEServiceAPIBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDEServiceAPIBase.getJSONValue((Object)pSDEServiceAPIBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDEServiceAPIBase.getPSDEServiceAPIId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeserviceapiid", (Object)PSDEServiceAPIBase.getJSONValue((Object)pSDEServiceAPIBase.getPSDEServiceAPIId()), (boolean)false);
        }
        if (bl || pSDEServiceAPIBase.getPSDEServiceAPIName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeserviceapiname", (Object)PSDEServiceAPIBase.getJSONValue((Object)pSDEServiceAPIBase.getPSDEServiceAPIName()), (boolean)false);
        }
        if (bl || pSDEServiceAPIBase.getPSSysReqItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemid", (Object)PSDEServiceAPIBase.getJSONValue((Object)pSDEServiceAPIBase.getPSSysReqItemId()), (boolean)false);
        }
        if (bl || pSDEServiceAPIBase.getPSSysReqItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemname", (Object)PSDEServiceAPIBase.getJSONValue((Object)pSDEServiceAPIBase.getPSSysReqItemName()), (boolean)false);
        }
        if (bl || pSDEServiceAPIBase.getPSSysServiceAPIId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysserviceapiid", (Object)PSDEServiceAPIBase.getJSONValue((Object)pSDEServiceAPIBase.getPSSysServiceAPIId()), (boolean)false);
        }
        if (bl || pSDEServiceAPIBase.getPSSysServiceAPIName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysserviceapiname", (Object)PSDEServiceAPIBase.getJSONValue((Object)pSDEServiceAPIBase.getPSSysServiceAPIName()), (boolean)false);
        }
        if (bl || pSDEServiceAPIBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSDEServiceAPIBase.getJSONValue((Object)pSDEServiceAPIBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSDEServiceAPIBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSDEServiceAPIBase.getJSONValue((Object)pSDEServiceAPIBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSDEServiceAPIBase.getPSSysUniResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysuniresid", (Object)PSDEServiceAPIBase.getJSONValue((Object)pSDEServiceAPIBase.getPSSysUniResId()), (boolean)false);
        }
        if (bl || pSDEServiceAPIBase.getPSSysUniResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysuniresname", (Object)PSDEServiceAPIBase.getJSONValue((Object)pSDEServiceAPIBase.getPSSysUniResName()), (boolean)false);
        }
        if (bl || pSDEServiceAPIBase.getServiceParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"serviceparam", (Object)PSDEServiceAPIBase.getJSONValue((Object)pSDEServiceAPIBase.getServiceParam()), (boolean)false);
        }
        if (bl || pSDEServiceAPIBase.getServiceParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"serviceparam2", (Object)PSDEServiceAPIBase.getJSONValue((Object)pSDEServiceAPIBase.getServiceParam2()), (boolean)false);
        }
        if (bl || pSDEServiceAPIBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEServiceAPIBase.getJSONValue((Object)pSDEServiceAPIBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEServiceAPIBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEServiceAPIBase.getJSONValue((Object)pSDEServiceAPIBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEServiceAPIBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEServiceAPIBase.getJSONValue((Object)pSDEServiceAPIBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEServiceAPIBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEServiceAPIBase.getJSONValue((Object)pSDEServiceAPIBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEServiceAPIBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEServiceAPIBase.getJSONValue((Object)pSDEServiceAPIBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEServiceAPIBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEServiceAPIBase.getJSONValue((Object)pSDEServiceAPIBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEServiceAPIBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEServiceAPIBase.getJSONValue((Object)pSDEServiceAPIBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDEServiceAPIBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDEServiceAPIBase.getJSONValue((Object)pSDEServiceAPIBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEServiceAPIBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEServiceAPIBase pSDEServiceAPIBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEServiceAPIBase.getAccCtrlArch() != null) {
            object = pSDEServiceAPIBase.getAccCtrlArch();
            xmlNode.setAttribute(FIELD_ACCCTRLARCH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEServiceAPIBase.getAPITag() != null) {
            object = pSDEServiceAPIBase.getAPITag();
            xmlNode.setAttribute(FIELD_APITAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEServiceAPIBase.getAPITag2() != null) {
            object = pSDEServiceAPIBase.getAPITag2();
            xmlNode.setAttribute(FIELD_APITAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEServiceAPIBase.getBaseClsParams() != null) {
            object = pSDEServiceAPIBase.getBaseClsParams();
            xmlNode.setAttribute(FIELD_BASECLSPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDEServiceAPIBase.getCodeName() != null) {
            object = pSDEServiceAPIBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEServiceAPIBase.getCodeName2() != null) {
            object = pSDEServiceAPIBase.getCodeName2();
            xmlNode.setAttribute(FIELD_CODENAME2, object == null ? "" : (String)object);
        }
        if (bl || pSDEServiceAPIBase.getCreateDate() != null) {
            object = pSDEServiceAPIBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEServiceAPIBase.getCreateMan() != null) {
            object = pSDEServiceAPIBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEServiceAPIBase.getCustomCode() != null) {
            object = pSDEServiceAPIBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEServiceAPIBase.getCustomMode() != null) {
            object = pSDEServiceAPIBase.getCustomMode();
            xmlNode.setAttribute(FIELD_CUSTOMMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEServiceAPIBase.getDataAccMode() != null) {
            object = pSDEServiceAPIBase.getDataAccMode();
            xmlNode.setAttribute(FIELD_DATAACCMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEServiceAPIBase.getDEFGroupMode() != null) {
            object = pSDEServiceAPIBase.getDEFGroupMode();
            xmlNode.setAttribute(FIELD_DEFGROUPMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEServiceAPIBase.getDELogicName() != null) {
            object = pSDEServiceAPIBase.getDELogicName();
            xmlNode.setAttribute(FIELD_DELOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEServiceAPIBase.getEnableDataExport() != null) {
            object = pSDEServiceAPIBase.getEnableDataExport();
            xmlNode.setAttribute(FIELD_ENABLEDATAEXPORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEServiceAPIBase.getEnableDataImport() != null) {
            object = pSDEServiceAPIBase.getEnableDataImport();
            xmlNode.setAttribute(FIELD_ENABLEDATAIMPORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEServiceAPIBase.getEnableDEAction() != null) {
            object = pSDEServiceAPIBase.getEnableDEAction();
            xmlNode.setAttribute(FIELD_ENABLEDEACTION, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEServiceAPIBase.getEnableDEDataSet() != null) {
            object = pSDEServiceAPIBase.getEnableDEDataSet();
            xmlNode.setAttribute(FIELD_ENABLEDEDATASET, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEServiceAPIBase.getEnableSelect() != null) {
            object = pSDEServiceAPIBase.getEnableSelect();
            xmlNode.setAttribute(FIELD_ENABLESELECT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEServiceAPIBase.getEnaTempData() != null) {
            object = pSDEServiceAPIBase.getEnaTempData();
            xmlNode.setAttribute(FIELD_ENATEMPDATA, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEServiceAPIBase.getLNPSLanResId() != null) {
            object = pSDEServiceAPIBase.getLNPSLanResId();
            xmlNode.setAttribute(FIELD_LNPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDEServiceAPIBase.getLNPSLanResName() != null) {
            object = pSDEServiceAPIBase.getLNPSLanResName();
            xmlNode.setAttribute(FIELD_LNPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEServiceAPIBase.getLockFlag() != null) {
            object = pSDEServiceAPIBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEServiceAPIBase.getLogicName() != null) {
            object = pSDEServiceAPIBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEServiceAPIBase.getMajorFlag() != null) {
            object = pSDEServiceAPIBase.getMajorFlag();
            xmlNode.setAttribute(FIELD_MAJORFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEServiceAPIBase.getMemo() != null) {
            object = pSDEServiceAPIBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEServiceAPIBase.getOrderValue() != null) {
            object = pSDEServiceAPIBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEServiceAPIBase.getOutPSSysTranslatorId() != null) {
            object = pSDEServiceAPIBase.getOutPSSysTranslatorId();
            xmlNode.setAttribute(FIELD_OUTPSSYSTRANSLATORID, object == null ? "" : (String)object);
        }
        if (bl || pSDEServiceAPIBase.getOutPSSysTranslatorName() != null) {
            object = pSDEServiceAPIBase.getOutPSSysTranslatorName();
            xmlNode.setAttribute(FIELD_OUTPSSYSTRANSLATORNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEServiceAPIBase.getPSDEFGroupId() != null) {
            object = pSDEServiceAPIBase.getPSDEFGroupId();
            xmlNode.setAttribute(FIELD_PSDEFGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEServiceAPIBase.getPSDEFGroupName() != null) {
            object = pSDEServiceAPIBase.getPSDEFGroupName();
            xmlNode.setAttribute(FIELD_PSDEFGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEServiceAPIBase.getPSDEId() != null) {
            object = pSDEServiceAPIBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEServiceAPIBase.getPSDEName() != null) {
            object = pSDEServiceAPIBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEServiceAPIBase.getPSDEServiceAPIId() != null) {
            object = pSDEServiceAPIBase.getPSDEServiceAPIId();
            xmlNode.setAttribute(FIELD_PSDESERVICEAPIID, object == null ? "" : (String)object);
        }
        if (bl || pSDEServiceAPIBase.getPSDEServiceAPIName() != null) {
            object = pSDEServiceAPIBase.getPSDEServiceAPIName();
            xmlNode.setAttribute(FIELD_PSDESERVICEAPINAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEServiceAPIBase.getPSSysReqItemId() != null) {
            object = pSDEServiceAPIBase.getPSSysReqItemId();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEServiceAPIBase.getPSSysReqItemName() != null) {
            object = pSDEServiceAPIBase.getPSSysReqItemName();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEServiceAPIBase.getPSSysServiceAPIId() != null) {
            object = pSDEServiceAPIBase.getPSSysServiceAPIId();
            xmlNode.setAttribute(FIELD_PSSYSSERVICEAPIID, object == null ? "" : (String)object);
        }
        if (bl || pSDEServiceAPIBase.getPSSysServiceAPIName() != null) {
            object = pSDEServiceAPIBase.getPSSysServiceAPIName();
            xmlNode.setAttribute(FIELD_PSSYSSERVICEAPINAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEServiceAPIBase.getPSSysSFPluginId() != null) {
            object = pSDEServiceAPIBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDEServiceAPIBase.getPSSysSFPluginName() != null) {
            object = pSDEServiceAPIBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEServiceAPIBase.getPSSysUniResId() != null) {
            object = pSDEServiceAPIBase.getPSSysUniResId();
            xmlNode.setAttribute(FIELD_PSSYSUNIRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDEServiceAPIBase.getPSSysUniResName() != null) {
            object = pSDEServiceAPIBase.getPSSysUniResName();
            xmlNode.setAttribute(FIELD_PSSYSUNIRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEServiceAPIBase.getServiceParam() != null) {
            object = pSDEServiceAPIBase.getServiceParam();
            xmlNode.setAttribute(FIELD_SERVICEPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDEServiceAPIBase.getServiceParam2() != null) {
            object = pSDEServiceAPIBase.getServiceParam2();
            xmlNode.setAttribute(FIELD_SERVICEPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSDEServiceAPIBase.getUpdateDate() != null) {
            object = pSDEServiceAPIBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEServiceAPIBase.getUpdateMan() != null) {
            object = pSDEServiceAPIBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEServiceAPIBase.getUserCat() != null) {
            object = pSDEServiceAPIBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEServiceAPIBase.getUserTag() != null) {
            object = pSDEServiceAPIBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEServiceAPIBase.getUserTag2() != null) {
            object = pSDEServiceAPIBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEServiceAPIBase.getUserTag3() != null) {
            object = pSDEServiceAPIBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEServiceAPIBase.getUserTag4() != null) {
            object = pSDEServiceAPIBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEServiceAPIBase.getValidFlag() != null) {
            object = pSDEServiceAPIBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEServiceAPIBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEServiceAPIBase pSDEServiceAPIBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEServiceAPIBase.isAccCtrlArchDirty() && (bl || pSDEServiceAPIBase.getAccCtrlArch() != null)) {
            iDataObject.set(FIELD_ACCCTRLARCH, (Object)pSDEServiceAPIBase.getAccCtrlArch());
        }
        if (pSDEServiceAPIBase.isAPITagDirty() && (bl || pSDEServiceAPIBase.getAPITag() != null)) {
            iDataObject.set(FIELD_APITAG, (Object)pSDEServiceAPIBase.getAPITag());
        }
        if (pSDEServiceAPIBase.isAPITag2Dirty() && (bl || pSDEServiceAPIBase.getAPITag2() != null)) {
            iDataObject.set(FIELD_APITAG2, (Object)pSDEServiceAPIBase.getAPITag2());
        }
        if (pSDEServiceAPIBase.isBaseClsParamsDirty() && (bl || pSDEServiceAPIBase.getBaseClsParams() != null)) {
            iDataObject.set(FIELD_BASECLSPARAMS, (Object)pSDEServiceAPIBase.getBaseClsParams());
        }
        if (pSDEServiceAPIBase.isCodeNameDirty() && (bl || pSDEServiceAPIBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDEServiceAPIBase.getCodeName());
        }
        if (pSDEServiceAPIBase.isCodeName2Dirty() && (bl || pSDEServiceAPIBase.getCodeName2() != null)) {
            iDataObject.set(FIELD_CODENAME2, (Object)pSDEServiceAPIBase.getCodeName2());
        }
        if (pSDEServiceAPIBase.isCreateDateDirty() && (bl || pSDEServiceAPIBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEServiceAPIBase.getCreateDate());
        }
        if (pSDEServiceAPIBase.isCreateManDirty() && (bl || pSDEServiceAPIBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEServiceAPIBase.getCreateMan());
        }
        if (pSDEServiceAPIBase.isCustomCodeDirty() && (bl || pSDEServiceAPIBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSDEServiceAPIBase.getCustomCode());
        }
        if (pSDEServiceAPIBase.isCustomModeDirty() && (bl || pSDEServiceAPIBase.getCustomMode() != null)) {
            iDataObject.set(FIELD_CUSTOMMODE, (Object)pSDEServiceAPIBase.getCustomMode());
        }
        if (pSDEServiceAPIBase.isDataAccModeDirty() && (bl || pSDEServiceAPIBase.getDataAccMode() != null)) {
            iDataObject.set(FIELD_DATAACCMODE, (Object)pSDEServiceAPIBase.getDataAccMode());
        }
        if (pSDEServiceAPIBase.isDEFGroupModeDirty() && (bl || pSDEServiceAPIBase.getDEFGroupMode() != null)) {
            iDataObject.set(FIELD_DEFGROUPMODE, (Object)pSDEServiceAPIBase.getDEFGroupMode());
        }
        if (pSDEServiceAPIBase.isDELogicNameDirty() && (bl || pSDEServiceAPIBase.getDELogicName() != null)) {
            iDataObject.set(FIELD_DELOGICNAME, (Object)pSDEServiceAPIBase.getDELogicName());
        }
        if (pSDEServiceAPIBase.isEnableDataExportDirty() && (bl || pSDEServiceAPIBase.getEnableDataExport() != null)) {
            iDataObject.set(FIELD_ENABLEDATAEXPORT, (Object)pSDEServiceAPIBase.getEnableDataExport());
        }
        if (pSDEServiceAPIBase.isEnableDataImportDirty() && (bl || pSDEServiceAPIBase.getEnableDataImport() != null)) {
            iDataObject.set(FIELD_ENABLEDATAIMPORT, (Object)pSDEServiceAPIBase.getEnableDataImport());
        }
        if (pSDEServiceAPIBase.isEnableDEActionDirty() && (bl || pSDEServiceAPIBase.getEnableDEAction() != null)) {
            iDataObject.set(FIELD_ENABLEDEACTION, (Object)pSDEServiceAPIBase.getEnableDEAction());
        }
        if (pSDEServiceAPIBase.isEnableDEDataSetDirty() && (bl || pSDEServiceAPIBase.getEnableDEDataSet() != null)) {
            iDataObject.set(FIELD_ENABLEDEDATASET, (Object)pSDEServiceAPIBase.getEnableDEDataSet());
        }
        if (pSDEServiceAPIBase.isEnableSelectDirty() && (bl || pSDEServiceAPIBase.getEnableSelect() != null)) {
            iDataObject.set(FIELD_ENABLESELECT, (Object)pSDEServiceAPIBase.getEnableSelect());
        }
        if (pSDEServiceAPIBase.isEnaTempDataDirty() && (bl || pSDEServiceAPIBase.getEnaTempData() != null)) {
            iDataObject.set(FIELD_ENATEMPDATA, (Object)pSDEServiceAPIBase.getEnaTempData());
        }
        if (pSDEServiceAPIBase.isLNPSLanResIdDirty() && (bl || pSDEServiceAPIBase.getLNPSLanResId() != null)) {
            iDataObject.set(FIELD_LNPSLANRESID, (Object)pSDEServiceAPIBase.getLNPSLanResId());
        }
        if (pSDEServiceAPIBase.isLNPSLanResNameDirty() && (bl || pSDEServiceAPIBase.getLNPSLanResName() != null)) {
            iDataObject.set(FIELD_LNPSLANRESNAME, (Object)pSDEServiceAPIBase.getLNPSLanResName());
        }
        if (pSDEServiceAPIBase.isLockFlagDirty() && (bl || pSDEServiceAPIBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSDEServiceAPIBase.getLockFlag());
        }
        if (pSDEServiceAPIBase.isLogicNameDirty() && (bl || pSDEServiceAPIBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSDEServiceAPIBase.getLogicName());
        }
        if (pSDEServiceAPIBase.isMajorFlagDirty() && (bl || pSDEServiceAPIBase.getMajorFlag() != null)) {
            iDataObject.set(FIELD_MAJORFLAG, (Object)pSDEServiceAPIBase.getMajorFlag());
        }
        if (pSDEServiceAPIBase.isMemoDirty() && (bl || pSDEServiceAPIBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEServiceAPIBase.getMemo());
        }
        if (pSDEServiceAPIBase.isOrderValueDirty() && (bl || pSDEServiceAPIBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDEServiceAPIBase.getOrderValue());
        }
        if (pSDEServiceAPIBase.isOutPSSysTranslatorIdDirty() && (bl || pSDEServiceAPIBase.getOutPSSysTranslatorId() != null)) {
            iDataObject.set(FIELD_OUTPSSYSTRANSLATORID, (Object)pSDEServiceAPIBase.getOutPSSysTranslatorId());
        }
        if (pSDEServiceAPIBase.isOutPSSysTranslatorNameDirty() && (bl || pSDEServiceAPIBase.getOutPSSysTranslatorName() != null)) {
            iDataObject.set(FIELD_OUTPSSYSTRANSLATORNAME, (Object)pSDEServiceAPIBase.getOutPSSysTranslatorName());
        }
        if (pSDEServiceAPIBase.isPSDEFGroupIdDirty() && (bl || pSDEServiceAPIBase.getPSDEFGroupId() != null)) {
            iDataObject.set(FIELD_PSDEFGROUPID, (Object)pSDEServiceAPIBase.getPSDEFGroupId());
        }
        if (pSDEServiceAPIBase.isPSDEFGroupNameDirty() && (bl || pSDEServiceAPIBase.getPSDEFGroupName() != null)) {
            iDataObject.set(FIELD_PSDEFGROUPNAME, (Object)pSDEServiceAPIBase.getPSDEFGroupName());
        }
        if (pSDEServiceAPIBase.isPSDEIdDirty() && (bl || pSDEServiceAPIBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEServiceAPIBase.getPSDEId());
        }
        if (pSDEServiceAPIBase.isPSDENameDirty() && (bl || pSDEServiceAPIBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDEServiceAPIBase.getPSDEName());
        }
        if (pSDEServiceAPIBase.isPSDEServiceAPIIdDirty() && (bl || pSDEServiceAPIBase.getPSDEServiceAPIId() != null)) {
            iDataObject.set(FIELD_PSDESERVICEAPIID, (Object)pSDEServiceAPIBase.getPSDEServiceAPIId());
        }
        if (pSDEServiceAPIBase.isPSDEServiceAPINameDirty() && (bl || pSDEServiceAPIBase.getPSDEServiceAPIName() != null)) {
            iDataObject.set(FIELD_PSDESERVICEAPINAME, (Object)pSDEServiceAPIBase.getPSDEServiceAPIName());
        }
        if (pSDEServiceAPIBase.isPSSysReqItemIdDirty() && (bl || pSDEServiceAPIBase.getPSSysReqItemId() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMID, (Object)pSDEServiceAPIBase.getPSSysReqItemId());
        }
        if (pSDEServiceAPIBase.isPSSysReqItemNameDirty() && (bl || pSDEServiceAPIBase.getPSSysReqItemName() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMNAME, (Object)pSDEServiceAPIBase.getPSSysReqItemName());
        }
        if (pSDEServiceAPIBase.isPSSysServiceAPIIdDirty() && (bl || pSDEServiceAPIBase.getPSSysServiceAPIId() != null)) {
            iDataObject.set(FIELD_PSSYSSERVICEAPIID, (Object)pSDEServiceAPIBase.getPSSysServiceAPIId());
        }
        if (pSDEServiceAPIBase.isPSSysServiceAPINameDirty() && (bl || pSDEServiceAPIBase.getPSSysServiceAPIName() != null)) {
            iDataObject.set(FIELD_PSSYSSERVICEAPINAME, (Object)pSDEServiceAPIBase.getPSSysServiceAPIName());
        }
        if (pSDEServiceAPIBase.isPSSysSFPluginIdDirty() && (bl || pSDEServiceAPIBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSDEServiceAPIBase.getPSSysSFPluginId());
        }
        if (pSDEServiceAPIBase.isPSSysSFPluginNameDirty() && (bl || pSDEServiceAPIBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSDEServiceAPIBase.getPSSysSFPluginName());
        }
        if (pSDEServiceAPIBase.isPSSysUniResIdDirty() && (bl || pSDEServiceAPIBase.getPSSysUniResId() != null)) {
            iDataObject.set(FIELD_PSSYSUNIRESID, (Object)pSDEServiceAPIBase.getPSSysUniResId());
        }
        if (pSDEServiceAPIBase.isPSSysUniResNameDirty() && (bl || pSDEServiceAPIBase.getPSSysUniResName() != null)) {
            iDataObject.set(FIELD_PSSYSUNIRESNAME, (Object)pSDEServiceAPIBase.getPSSysUniResName());
        }
        if (pSDEServiceAPIBase.isServiceParamDirty() && (bl || pSDEServiceAPIBase.getServiceParam() != null)) {
            iDataObject.set(FIELD_SERVICEPARAM, (Object)pSDEServiceAPIBase.getServiceParam());
        }
        if (pSDEServiceAPIBase.isServiceParam2Dirty() && (bl || pSDEServiceAPIBase.getServiceParam2() != null)) {
            iDataObject.set(FIELD_SERVICEPARAM2, (Object)pSDEServiceAPIBase.getServiceParam2());
        }
        if (pSDEServiceAPIBase.isUpdateDateDirty() && (bl || pSDEServiceAPIBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEServiceAPIBase.getUpdateDate());
        }
        if (pSDEServiceAPIBase.isUpdateManDirty() && (bl || pSDEServiceAPIBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEServiceAPIBase.getUpdateMan());
        }
        if (pSDEServiceAPIBase.isUserCatDirty() && (bl || pSDEServiceAPIBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEServiceAPIBase.getUserCat());
        }
        if (pSDEServiceAPIBase.isUserTagDirty() && (bl || pSDEServiceAPIBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEServiceAPIBase.getUserTag());
        }
        if (pSDEServiceAPIBase.isUserTag2Dirty() && (bl || pSDEServiceAPIBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEServiceAPIBase.getUserTag2());
        }
        if (pSDEServiceAPIBase.isUserTag3Dirty() && (bl || pSDEServiceAPIBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEServiceAPIBase.getUserTag3());
        }
        if (pSDEServiceAPIBase.isUserTag4Dirty() && (bl || pSDEServiceAPIBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEServiceAPIBase.getUserTag4());
        }
        if (pSDEServiceAPIBase.isValidFlagDirty() && (bl || pSDEServiceAPIBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDEServiceAPIBase.getValidFlag());
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
        return PSDEServiceAPIBase.remove(this, n);
    }

    private static boolean remove(PSDEServiceAPIBase pSDEServiceAPIBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEServiceAPIBase.resetAccCtrlArch();
                return true;
            }
            case 1: {
                pSDEServiceAPIBase.resetAPITag();
                return true;
            }
            case 2: {
                pSDEServiceAPIBase.resetAPITag2();
                return true;
            }
            case 3: {
                pSDEServiceAPIBase.resetBaseClsParams();
                return true;
            }
            case 4: {
                pSDEServiceAPIBase.resetCodeName();
                return true;
            }
            case 5: {
                pSDEServiceAPIBase.resetCodeName2();
                return true;
            }
            case 6: {
                pSDEServiceAPIBase.resetCreateDate();
                return true;
            }
            case 7: {
                pSDEServiceAPIBase.resetCreateMan();
                return true;
            }
            case 8: {
                pSDEServiceAPIBase.resetCustomCode();
                return true;
            }
            case 9: {
                pSDEServiceAPIBase.resetCustomMode();
                return true;
            }
            case 10: {
                pSDEServiceAPIBase.resetDataAccMode();
                return true;
            }
            case 11: {
                pSDEServiceAPIBase.resetDEFGroupMode();
                return true;
            }
            case 12: {
                pSDEServiceAPIBase.resetDELogicName();
                return true;
            }
            case 13: {
                pSDEServiceAPIBase.resetEnableDataExport();
                return true;
            }
            case 14: {
                pSDEServiceAPIBase.resetEnableDataImport();
                return true;
            }
            case 15: {
                pSDEServiceAPIBase.resetEnableDEAction();
                return true;
            }
            case 16: {
                pSDEServiceAPIBase.resetEnableDEDataSet();
                return true;
            }
            case 17: {
                pSDEServiceAPIBase.resetEnableSelect();
                return true;
            }
            case 18: {
                pSDEServiceAPIBase.resetEnaTempData();
                return true;
            }
            case 19: {
                pSDEServiceAPIBase.resetLNPSLanResId();
                return true;
            }
            case 20: {
                pSDEServiceAPIBase.resetLNPSLanResName();
                return true;
            }
            case 21: {
                pSDEServiceAPIBase.resetLockFlag();
                return true;
            }
            case 22: {
                pSDEServiceAPIBase.resetLogicName();
                return true;
            }
            case 23: {
                pSDEServiceAPIBase.resetMajorFlag();
                return true;
            }
            case 24: {
                pSDEServiceAPIBase.resetMemo();
                return true;
            }
            case 25: {
                pSDEServiceAPIBase.resetOrderValue();
                return true;
            }
            case 26: {
                pSDEServiceAPIBase.resetOutPSSysTranslatorId();
                return true;
            }
            case 27: {
                pSDEServiceAPIBase.resetOutPSSysTranslatorName();
                return true;
            }
            case 28: {
                pSDEServiceAPIBase.resetPSDEFGroupId();
                return true;
            }
            case 29: {
                pSDEServiceAPIBase.resetPSDEFGroupName();
                return true;
            }
            case 30: {
                pSDEServiceAPIBase.resetPSDEId();
                return true;
            }
            case 31: {
                pSDEServiceAPIBase.resetPSDEName();
                return true;
            }
            case 32: {
                pSDEServiceAPIBase.resetPSDEServiceAPIId();
                return true;
            }
            case 33: {
                pSDEServiceAPIBase.resetPSDEServiceAPIName();
                return true;
            }
            case 34: {
                pSDEServiceAPIBase.resetPSSysReqItemId();
                return true;
            }
            case 35: {
                pSDEServiceAPIBase.resetPSSysReqItemName();
                return true;
            }
            case 36: {
                pSDEServiceAPIBase.resetPSSysServiceAPIId();
                return true;
            }
            case 37: {
                pSDEServiceAPIBase.resetPSSysServiceAPIName();
                return true;
            }
            case 38: {
                pSDEServiceAPIBase.resetPSSysSFPluginId();
                return true;
            }
            case 39: {
                pSDEServiceAPIBase.resetPSSysSFPluginName();
                return true;
            }
            case 40: {
                pSDEServiceAPIBase.resetPSSysUniResId();
                return true;
            }
            case 41: {
                pSDEServiceAPIBase.resetPSSysUniResName();
                return true;
            }
            case 42: {
                pSDEServiceAPIBase.resetServiceParam();
                return true;
            }
            case 43: {
                pSDEServiceAPIBase.resetServiceParam2();
                return true;
            }
            case 44: {
                pSDEServiceAPIBase.resetUpdateDate();
                return true;
            }
            case 45: {
                pSDEServiceAPIBase.resetUpdateMan();
                return true;
            }
            case 46: {
                pSDEServiceAPIBase.resetUserCat();
                return true;
            }
            case 47: {
                pSDEServiceAPIBase.resetUserTag();
                return true;
            }
            case 48: {
                pSDEServiceAPIBase.resetUserTag2();
                return true;
            }
            case 49: {
                pSDEServiceAPIBase.resetUserTag3();
                return true;
            }
            case 50: {
                pSDEServiceAPIBase.resetUserTag4();
                return true;
            }
            case 51: {
                pSDEServiceAPIBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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
    public PSSysTranslator getOutPSSysTranslator() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOutPSSysTranslator();
        }
        if (this.getOutPSSysTranslatorId() == null) {
            return null;
        }
        Integer n = this.objOutPSSysTranslatorLock;
        synchronized (n) {
            if (this.outpssystranslator != null && DataTypeHelper.compare((int)25, (Object)this.getOutPSSysTranslatorId(), (Object)this.outpssystranslator.getPSSysTranslatorId()) != 0L) {
                this.outpssystranslator = null;
            }
            if (this.outpssystranslator == null) {
                PSSysTranslator pSSysTranslator = new PSSysTranslator();
                pSSysTranslator.setPSSysTranslatorId(this.getOutPSSysTranslatorId());
                PSSysTranslatorService pSSysTranslatorService = (PSSysTranslatorService)ServiceGlobal.getService(PSSysTranslatorService.class, (SessionFactory)this.getSessionFactory());
                pSSysTranslatorService.autoGet(pSSysTranslator);
                this.outpssystranslator = pSSysTranslator;
            }
            return this.outpssystranslator;
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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDESADetail> getPSDESADetails() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDESADetails();
        }
        if (this.getPSDEServiceAPIId() == null) {
            return null;
        }
        PSDESADetailService pSDESADetailService = (PSDESADetailService)ServiceGlobal.getService(PSDESADetailService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDESADetailsLock;
        synchronized (n) {
            if (this.psdesadetails == null) {
                this.psdesadetails = pSDESADetailService.selectByPSDEServiceAPI(this);
            }
            return this.psdesadetails;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDESARS> getMinorPSDESARSs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorPSDESARSs();
        }
        if (this.getPSDEServiceAPIId() == null) {
            return null;
        }
        PSDESARSService pSDESARSService = (PSDESARSService)ServiceGlobal.getService(PSDESARSService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objMinorPSDESARSsLock;
        synchronized (n) {
            if (this.minorpsdesarss == null) {
                this.minorpsdesarss = pSDESARSService.selectByCPSDEServiceAPI(this);
            }
            return this.minorpsdesarss;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDESARS> getMajorPSDESARSs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMajorPSDESARSs();
        }
        if (this.getPSDEServiceAPIId() == null) {
            return null;
        }
        PSDESARSService pSDESARSService = (PSDESARSService)ServiceGlobal.getService(PSDESARSService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objMajorPSDESARSsLock;
        synchronized (n) {
            if (this.majorpsdesarss == null) {
                this.majorpsdesarss = pSDESARSService.selectByPPSDEServiceAPI(this);
            }
            return this.majorpsdesarss;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDESAVR> getPSDESAVRs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDESAVRs();
        }
        if (this.getPSDEServiceAPIId() == null) {
            return null;
        }
        PSDESAVRService pSDESAVRService = (PSDESAVRService)ServiceGlobal.getService(PSDESAVRService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDESAVRsLock;
        synchronized (n) {
            if (this.psdesavrs == null) {
                this.psdesavrs = pSDESAVRService.selectByPSDEServiceAPI(this);
            }
            return this.psdesavrs;
        }
    }

    private PSDEServiceAPIBase getProxyEntity() {
        return this.proxyPSDEServiceAPIBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEServiceAPIBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEServiceAPIBase) {
            this.proxyPSDEServiceAPIBase = (PSDEServiceAPIBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEServiceAPIService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ACCCTRLARCH, 0);
        fieldIndexMap.put(FIELD_APITAG, 1);
        fieldIndexMap.put(FIELD_APITAG2, 2);
        fieldIndexMap.put(FIELD_BASECLSPARAMS, 3);
        fieldIndexMap.put(FIELD_CODENAME, 4);
        fieldIndexMap.put(FIELD_CODENAME2, 5);
        fieldIndexMap.put(FIELD_CREATEDATE, 6);
        fieldIndexMap.put(FIELD_CREATEMAN, 7);
        fieldIndexMap.put(FIELD_CUSTOMCODE, 8);
        fieldIndexMap.put(FIELD_CUSTOMMODE, 9);
        fieldIndexMap.put(FIELD_DATAACCMODE, 10);
        fieldIndexMap.put(FIELD_DEFGROUPMODE, 11);
        fieldIndexMap.put(FIELD_DELOGICNAME, 12);
        fieldIndexMap.put(FIELD_ENABLEDATAEXPORT, 13);
        fieldIndexMap.put(FIELD_ENABLEDATAIMPORT, 14);
        fieldIndexMap.put(FIELD_ENABLEDEACTION, 15);
        fieldIndexMap.put(FIELD_ENABLEDEDATASET, 16);
        fieldIndexMap.put(FIELD_ENABLESELECT, 17);
        fieldIndexMap.put(FIELD_ENATEMPDATA, 18);
        fieldIndexMap.put(FIELD_LNPSLANRESID, 19);
        fieldIndexMap.put(FIELD_LNPSLANRESNAME, 20);
        fieldIndexMap.put(FIELD_LOCKFLAG, 21);
        fieldIndexMap.put(FIELD_LOGICNAME, 22);
        fieldIndexMap.put(FIELD_MAJORFLAG, 23);
        fieldIndexMap.put(FIELD_MEMO, 24);
        fieldIndexMap.put(FIELD_ORDERVALUE, 25);
        fieldIndexMap.put(FIELD_OUTPSSYSTRANSLATORID, 26);
        fieldIndexMap.put(FIELD_OUTPSSYSTRANSLATORNAME, 27);
        fieldIndexMap.put(FIELD_PSDEFGROUPID, 28);
        fieldIndexMap.put(FIELD_PSDEFGROUPNAME, 29);
        fieldIndexMap.put(FIELD_PSDEID, 30);
        fieldIndexMap.put(FIELD_PSDENAME, 31);
        fieldIndexMap.put(FIELD_PSDESERVICEAPIID, 32);
        fieldIndexMap.put(FIELD_PSDESERVICEAPINAME, 33);
        fieldIndexMap.put(FIELD_PSSYSREQITEMID, 34);
        fieldIndexMap.put(FIELD_PSSYSREQITEMNAME, 35);
        fieldIndexMap.put(FIELD_PSSYSSERVICEAPIID, 36);
        fieldIndexMap.put(FIELD_PSSYSSERVICEAPINAME, 37);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 38);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 39);
        fieldIndexMap.put(FIELD_PSSYSUNIRESID, 40);
        fieldIndexMap.put(FIELD_PSSYSUNIRESNAME, 41);
        fieldIndexMap.put(FIELD_SERVICEPARAM, 42);
        fieldIndexMap.put(FIELD_SERVICEPARAM2, 43);
        fieldIndexMap.put(FIELD_UPDATEDATE, 44);
        fieldIndexMap.put(FIELD_UPDATEMAN, 45);
        fieldIndexMap.put(FIELD_USERCAT, 46);
        fieldIndexMap.put(FIELD_USERTAG, 47);
        fieldIndexMap.put(FIELD_USERTAG2, 48);
        fieldIndexMap.put(FIELD_USERTAG3, 49);
        fieldIndexMap.put(FIELD_USERTAG4, 50);
        fieldIndexMap.put(FIELD_VALIDFLAG, 51);
    }
}

