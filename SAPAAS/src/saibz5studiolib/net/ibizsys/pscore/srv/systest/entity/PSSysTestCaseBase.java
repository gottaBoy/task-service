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
package net.ibizsys.pscore.srv.systest.entity;

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
import net.ibizsys.pscore.srv.appdesign.entity.PSAppView;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDESADetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEServiceAPI;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDESADetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEServiceAPIService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSampleValue;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSampleValueService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.ibizsys.pscore.srv.systest.entity.PSSysTestData;
import net.ibizsys.pscore.srv.systest.entity.PSSysTestModule;
import net.ibizsys.pscore.srv.systest.entity.PSSysTestPrj;
import net.ibizsys.pscore.srv.systest.service.PSSysTestDataService;
import net.ibizsys.pscore.srv.systest.service.PSSysTestModuleService;
import net.ibizsys.pscore.srv.systest.service.PSSysTestPrjService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysTestCaseBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysTestCaseBase.class);
    public static final String FIELD_ACTIONPARAMS = "ACTIONPARAMS";
    public static final String FIELD_ASSERTRESULT = "ASSERTRESULT";
    public static final String FIELD_ASSERTTYPE = "ASSERTTYPE";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CONTENT = "CONTENT";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEFPSSYSSAMPLEVALUEID = "DEFPSSYSSAMPLEVALUEID";
    public static final String FIELD_DEFPSSYSSAMPLEVALUENAME = "DEFPSSYSSAMPLEVALUENAME";
    public static final String FIELD_DEFVALUE = "DEFVALUE";
    public static final String FIELD_EXCEPTIONDATA = "EXCEPTIONDATA";
    public static final String FIELD_EXCEPTIONDATA2 = "EXCEPTIONDATA2";
    public static final String FIELD_EXCEPTIONNAME = "EXCEPTIONNAME";
    public static final String FIELD_INPUTVALUES = "INPUTVALUES";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSAPPVIEWID = "PSAPPVIEWID";
    public static final String FIELD_PSAPPVIEWNAME = "PSAPPVIEWNAME";
    public static final String FIELD_PSDEACTIONID = "PSDEACTIONID";
    public static final String FIELD_PSDEACTIONNAME = "PSDEACTIONNAME";
    public static final String FIELD_PSDEFID = "PSDEFID";
    public static final String FIELD_PSDEFNAME = "PSDEFNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDELOGICID = "PSDELOGICID";
    public static final String FIELD_PSDELOGICNAME = "PSDELOGICNAME";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDESADETAILID = "PSDESADETAILID";
    public static final String FIELD_PSDESADETAILNAME = "PSDESADETAILNAME";
    public static final String FIELD_PSDESERVICEAPIID = "PSDESERVICEAPIID";
    public static final String FIELD_PSDESERVICEAPINAME = "PSDESERVICEAPINAME";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSSYSREQITEMID = "PSSYSREQITEMID";
    public static final String FIELD_PSSYSREQITEMNAME = "PSSYSREQITEMNAME";
    public static final String FIELD_PSSYSSERVICEAPIID = "PSSYSSERVICEAPIID";
    public static final String FIELD_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String FIELD_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_PSSYSTESTCASEID = "PSSYSTESTCASEID";
    public static final String FIELD_PSSYSTESTCASENAME = "PSSYSTESTCASENAME";
    public static final String FIELD_PSSYSTESTDATAID = "PSSYSTESTDATAID";
    public static final String FIELD_PSSYSTESTDATANAME = "PSSYSTESTDATANAME";
    public static final String FIELD_PSSYSTESTMODULEID = "PSSYSTESTMODULEID";
    public static final String FIELD_PSSYSTESTMODULENAME = "PSSYSTESTMODULENAME";
    public static final String FIELD_PSSYSTESTPRJID = "PSSYSTESTPRJID";
    public static final String FIELD_PSSYSTESTPRJNAME = "PSSYSTESTPRJNAME";
    public static final String FIELD_ROLLBACKTRAN = "ROLLBACKTRAN";
    public static final String FIELD_TARGETTYPE = "TARGETTYPE";
    public static final String FIELD_TESTCASELEVEL = "TESTCASELEVEL";
    public static final String FIELD_TESTCASESN = "TESTCASESN";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERDATA = "USERDATA";
    public static final String FIELD_USERDATA2 = "USERDATA2";
    public static final String FIELD_USERDATA3 = "USERDATA3";
    public static final String FIELD_USERDATA4 = "USERDATA4";
    public static final String FIELD_USERFLAG = "USERFLAG";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_ACTIONPARAMS = 0;
    private static final int INDEX_ASSERTRESULT = 1;
    private static final int INDEX_ASSERTTYPE = 2;
    private static final int INDEX_CODENAME = 3;
    private static final int INDEX_CONTENT = 4;
    private static final int INDEX_CREATEDATE = 5;
    private static final int INDEX_CREATEMAN = 6;
    private static final int INDEX_DEFPSSYSSAMPLEVALUEID = 7;
    private static final int INDEX_DEFPSSYSSAMPLEVALUENAME = 8;
    private static final int INDEX_DEFVALUE = 9;
    private static final int INDEX_EXCEPTIONDATA = 10;
    private static final int INDEX_EXCEPTIONDATA2 = 11;
    private static final int INDEX_EXCEPTIONNAME = 12;
    private static final int INDEX_INPUTVALUES = 13;
    private static final int INDEX_LOCKFLAG = 14;
    private static final int INDEX_MEMO = 15;
    private static final int INDEX_ORDERVALUE = 16;
    private static final int INDEX_PSAPPVIEWID = 17;
    private static final int INDEX_PSAPPVIEWNAME = 18;
    private static final int INDEX_PSDEACTIONID = 19;
    private static final int INDEX_PSDEACTIONNAME = 20;
    private static final int INDEX_PSDEFID = 21;
    private static final int INDEX_PSDEFNAME = 22;
    private static final int INDEX_PSDEID = 23;
    private static final int INDEX_PSDELOGICID = 24;
    private static final int INDEX_PSDELOGICNAME = 25;
    private static final int INDEX_PSDENAME = 26;
    private static final int INDEX_PSDESADETAILID = 27;
    private static final int INDEX_PSDESADETAILNAME = 28;
    private static final int INDEX_PSDESERVICEAPIID = 29;
    private static final int INDEX_PSDESERVICEAPINAME = 30;
    private static final int INDEX_PSSYSAPPID = 31;
    private static final int INDEX_PSSYSREQITEMID = 32;
    private static final int INDEX_PSSYSREQITEMNAME = 33;
    private static final int INDEX_PSSYSSERVICEAPIID = 34;
    private static final int INDEX_PSSYSSFPLUGINID = 35;
    private static final int INDEX_PSSYSSFPLUGINNAME = 36;
    private static final int INDEX_PSSYSTEMID = 37;
    private static final int INDEX_PSSYSTEMNAME = 38;
    private static final int INDEX_PSSYSTESTCASEID = 39;
    private static final int INDEX_PSSYSTESTCASENAME = 40;
    private static final int INDEX_PSSYSTESTDATAID = 41;
    private static final int INDEX_PSSYSTESTDATANAME = 42;
    private static final int INDEX_PSSYSTESTMODULEID = 43;
    private static final int INDEX_PSSYSTESTMODULENAME = 44;
    private static final int INDEX_PSSYSTESTPRJID = 45;
    private static final int INDEX_PSSYSTESTPRJNAME = 46;
    private static final int INDEX_ROLLBACKTRAN = 47;
    private static final int INDEX_TARGETTYPE = 48;
    private static final int INDEX_TESTCASELEVEL = 49;
    private static final int INDEX_TESTCASESN = 50;
    private static final int INDEX_UPDATEDATE = 51;
    private static final int INDEX_UPDATEMAN = 52;
    private static final int INDEX_USERCAT = 53;
    private static final int INDEX_USERDATA = 54;
    private static final int INDEX_USERDATA2 = 55;
    private static final int INDEX_USERDATA3 = 56;
    private static final int INDEX_USERDATA4 = 57;
    private static final int INDEX_USERFLAG = 58;
    private static final int INDEX_USERTAG = 59;
    private static final int INDEX_USERTAG2 = 60;
    private static final int INDEX_USERTAG3 = 61;
    private static final int INDEX_USERTAG4 = 62;
    private static final int INDEX_VALIDFLAG = 63;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysTestCaseBase proxyPSSysTestCaseBase = null;
    private boolean actionparamsDirtyFlag = false;
    private boolean assertresultDirtyFlag = false;
    private boolean asserttypeDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean contentDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean defpssyssamplevalueidDirtyFlag = false;
    private boolean defpssyssamplevaluenameDirtyFlag = false;
    private boolean defvalueDirtyFlag = false;
    private boolean exceptiondataDirtyFlag = false;
    private boolean exceptiondata2DirtyFlag = false;
    private boolean exceptionnameDirtyFlag = false;
    private boolean inputvaluesDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psappviewidDirtyFlag = false;
    private boolean psappviewnameDirtyFlag = false;
    private boolean psdeactionidDirtyFlag = false;
    private boolean psdeactionnameDirtyFlag = false;
    private boolean psdefidDirtyFlag = false;
    private boolean psdefnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdelogicidDirtyFlag = false;
    private boolean psdelogicnameDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psdesadetailidDirtyFlag = false;
    private boolean psdesadetailnameDirtyFlag = false;
    private boolean psdeserviceapiidDirtyFlag = false;
    private boolean psdeserviceapinameDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean pssysreqitemidDirtyFlag = false;
    private boolean pssysreqitemnameDirtyFlag = false;
    private boolean pssysserviceapiidDirtyFlag = false;
    private boolean pssyssfpluginidDirtyFlag = false;
    private boolean pssyssfpluginnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean pssystestcaseidDirtyFlag = false;
    private boolean pssystestcasenameDirtyFlag = false;
    private boolean pssystestdataidDirtyFlag = false;
    private boolean pssystestdatanameDirtyFlag = false;
    private boolean pssystestmoduleidDirtyFlag = false;
    private boolean pssystestmodulenameDirtyFlag = false;
    private boolean pssystestprjidDirtyFlag = false;
    private boolean pssystestprjnameDirtyFlag = false;
    private boolean rollbacktranDirtyFlag = false;
    private boolean targettypeDirtyFlag = false;
    private boolean testcaselevelDirtyFlag = false;
    private boolean testcasesnDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean userdataDirtyFlag = false;
    private boolean userdata2DirtyFlag = false;
    private boolean userdata3DirtyFlag = false;
    private boolean userdata4DirtyFlag = false;
    private boolean userflagDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="actionparams")
    private String actionparams;
    @Column(name="assertresult")
    private String assertresult;
    @Column(name="asserttype")
    private String asserttype;
    @Column(name="codename")
    private String codename;
    @Column(name="content")
    private String content;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="defpssyssamplevalueid")
    private String defpssyssamplevalueid;
    @Column(name="defpssyssamplevaluename")
    private String defpssyssamplevaluename;
    @Column(name="defvalue")
    private String defvalue;
    @Column(name="exceptiondata")
    private String exceptiondata;
    @Column(name="exceptiondata2")
    private String exceptiondata2;
    @Column(name="exceptionname")
    private String exceptionname;
    @Column(name="inputvalues")
    private String inputvalues;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psappviewid")
    private String psappviewid;
    @Column(name="psappviewname")
    private String psappviewname;
    @Column(name="psdeactionid")
    private String psdeactionid;
    @Column(name="psdeactionname")
    private String psdeactionname;
    @Column(name="psdefid")
    private String psdefid;
    @Column(name="psdefname")
    private String psdefname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdelogicid")
    private String psdelogicid;
    @Column(name="psdelogicname")
    private String psdelogicname;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psdesadetailid")
    private String psdesadetailid;
    @Column(name="psdesadetailname")
    private String psdesadetailname;
    @Column(name="psdeserviceapiid")
    private String psdeserviceapiid;
    @Column(name="psdeserviceapiname")
    private String psdeserviceapiname;
    @Column(name="pssysappid")
    private String pssysappid;
    @Column(name="pssysreqitemid")
    private String pssysreqitemid;
    @Column(name="pssysreqitemname")
    private String pssysreqitemname;
    @Column(name="pssysserviceapiid")
    private String pssysserviceapiid;
    @Column(name="pssyssfpluginid")
    private String pssyssfpluginid;
    @Column(name="pssyssfpluginname")
    private String pssyssfpluginname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="pssystestcaseid")
    private String pssystestcaseid;
    @Column(name="pssystestcasename")
    private String pssystestcasename;
    @Column(name="pssystestdataid")
    private String pssystestdataid;
    @Column(name="pssystestdataname")
    private String pssystestdataname;
    @Column(name="pssystestmoduleid")
    private String pssystestmoduleid;
    @Column(name="pssystestmodulename")
    private String pssystestmodulename;
    @Column(name="pssystestprjid")
    private String pssystestprjid;
    @Column(name="pssystestprjname")
    private String pssystestprjname;
    @Column(name="rollbacktran")
    private Integer rollbacktran;
    @Column(name="targettype")
    private String targettype;
    @Column(name="testcaselevel")
    private String testcaselevel;
    @Column(name="testcasesn")
    private String testcasesn;
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
    @Column(name="userdata3")
    private String userdata3;
    @Column(name="userdata4")
    private String userdata4;
    @Column(name="userflag")
    private Integer userflag;
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
    private Integer objPSAppViewLock = new Integer(1);
    private PSAppView psappview = null;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objPSDEActionLock = new Integer(1);
    private PSDEAction psdeaction = null;
    private Integer objPSDEFLock = new Integer(1);
    private PSDEField psdef = null;
    private Integer objPSDELogicLock = new Integer(1);
    private PSDELogic psdelogic = null;
    private Integer objPSDESADetailLock = new Integer(1);
    private PSDESADetail psdesadetail = null;
    private Integer objPSDEServiceAPILock = new Integer(1);
    private PSDEServiceAPI psdeserviceapi = null;
    private Integer objPSSysReqItemLock = new Integer(1);
    private PSSysReqItem pssysreqitem = null;
    private Integer objDEFPSSysSampleValueLock = new Integer(1);
    private PSSysSampleValue defpssyssamplevalue = null;
    private Integer objPSSysSFPluginLock = new Integer(1);
    private PSSysSFPlugin pssyssfplugin = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSSysTestDataLock = new Integer(1);
    private PSSysTestData pssystestdata = null;
    private Integer objPSSysTestModuleLock = new Integer(1);
    private PSSysTestModule pssystestmodule = null;
    private Integer objPSSysTestPrjLock = new Integer(1);
    private PSSysTestPrj pssystestprj = null;

    public void setActionParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actionparams = string;
        this.actionparamsDirtyFlag = true;
    }

    public String getActionParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionParams();
        }
        return this.actionparams;
    }

    public boolean isActionParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionParamsDirty();
        }
        return this.actionparamsDirtyFlag;
    }

    public void resetActionParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionParams();
            return;
        }
        this.actionparamsDirtyFlag = false;
        this.actionparams = null;
    }

    public void setAssertResult(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAssertResult(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.assertresult = string;
        this.assertresultDirtyFlag = true;
    }

    public String getAssertResult() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAssertResult();
        }
        return this.assertresult;
    }

    public boolean isAssertResultDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAssertResultDirty();
        }
        return this.assertresultDirtyFlag;
    }

    public void resetAssertResult() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAssertResult();
            return;
        }
        this.assertresultDirtyFlag = false;
        this.assertresult = null;
    }

    public void setAssertType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAssertType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.asserttype = string;
        this.asserttypeDirtyFlag = true;
    }

    public String getAssertType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAssertType();
        }
        return this.asserttype;
    }

    public boolean isAssertTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAssertTypeDirty();
        }
        return this.asserttypeDirtyFlag;
    }

    public void resetAssertType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAssertType();
            return;
        }
        this.asserttypeDirtyFlag = false;
        this.asserttype = null;
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

    public void setContent(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setContent(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.content = string;
        this.contentDirtyFlag = true;
    }

    public String getContent() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContent();
        }
        return this.content;
    }

    public boolean isContentDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isContentDirty();
        }
        return this.contentDirtyFlag;
    }

    public void resetContent() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetContent();
            return;
        }
        this.contentDirtyFlag = false;
        this.content = null;
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

    public void setDEFPSSysSampleValueId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEFPSSysSampleValueId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.defpssyssamplevalueid = string;
        this.defpssyssamplevalueidDirtyFlag = true;
    }

    public String getDEFPSSysSampleValueId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEFPSSysSampleValueId();
        }
        return this.defpssyssamplevalueid;
    }

    public boolean isDEFPSSysSampleValueIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEFPSSysSampleValueIdDirty();
        }
        return this.defpssyssamplevalueidDirtyFlag;
    }

    public void resetDEFPSSysSampleValueId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEFPSSysSampleValueId();
            return;
        }
        this.defpssyssamplevalueidDirtyFlag = false;
        this.defpssyssamplevalueid = null;
    }

    public void setDEFPSSysSampleValueName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEFPSSysSampleValueName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.defpssyssamplevaluename = string;
        this.defpssyssamplevaluenameDirtyFlag = true;
    }

    public String getDEFPSSysSampleValueName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEFPSSysSampleValueName();
        }
        return this.defpssyssamplevaluename;
    }

    public boolean isDEFPSSysSampleValueNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEFPSSysSampleValueNameDirty();
        }
        return this.defpssyssamplevaluenameDirtyFlag;
    }

    public void resetDEFPSSysSampleValueName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEFPSSysSampleValueName();
            return;
        }
        this.defpssyssamplevaluenameDirtyFlag = false;
        this.defpssyssamplevaluename = null;
    }

    public void setDEFValue(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEFValue(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.defvalue = string;
        this.defvalueDirtyFlag = true;
    }

    public String getDEFValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEFValue();
        }
        return this.defvalue;
    }

    public boolean isDEFValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEFValueDirty();
        }
        return this.defvalueDirtyFlag;
    }

    public void resetDEFValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEFValue();
            return;
        }
        this.defvalueDirtyFlag = false;
        this.defvalue = null;
    }

    public void setExceptionData(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExceptionData(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.exceptiondata = string;
        this.exceptiondataDirtyFlag = true;
    }

    public String getExceptionData() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExceptionData();
        }
        return this.exceptiondata;
    }

    public boolean isExceptionDataDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExceptionDataDirty();
        }
        return this.exceptiondataDirtyFlag;
    }

    public void resetExceptionData() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExceptionData();
            return;
        }
        this.exceptiondataDirtyFlag = false;
        this.exceptiondata = null;
    }

    public void setExceptionData2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExceptionData2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.exceptiondata2 = string;
        this.exceptiondata2DirtyFlag = true;
    }

    public String getExceptionData2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExceptionData2();
        }
        return this.exceptiondata2;
    }

    public boolean isExceptionData2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExceptionData2Dirty();
        }
        return this.exceptiondata2DirtyFlag;
    }

    public void resetExceptionData2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExceptionData2();
            return;
        }
        this.exceptiondata2DirtyFlag = false;
        this.exceptiondata2 = null;
    }

    public void setExceptionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExceptionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.exceptionname = string;
        this.exceptionnameDirtyFlag = true;
    }

    public String getExceptionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExceptionName();
        }
        return this.exceptionname;
    }

    public boolean isExceptionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExceptionNameDirty();
        }
        return this.exceptionnameDirtyFlag;
    }

    public void resetExceptionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExceptionName();
            return;
        }
        this.exceptionnameDirtyFlag = false;
        this.exceptionname = null;
    }

    public void setInputValues(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInputValues(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.inputvalues = string;
        this.inputvaluesDirtyFlag = true;
    }

    public String getInputValues() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInputValues();
        }
        return this.inputvalues;
    }

    public boolean isInputValuesDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInputValuesDirty();
        }
        return this.inputvaluesDirtyFlag;
    }

    public void resetInputValues() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInputValues();
            return;
        }
        this.inputvaluesDirtyFlag = false;
        this.inputvalues = null;
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

    public void setPSAppViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappviewid = string;
        this.psappviewidDirtyFlag = true;
    }

    public String getPSAppViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppViewId();
        }
        return this.psappviewid;
    }

    public boolean isPSAppViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppViewIdDirty();
        }
        return this.psappviewidDirtyFlag;
    }

    public void resetPSAppViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppViewId();
            return;
        }
        this.psappviewidDirtyFlag = false;
        this.psappviewid = null;
    }

    public void setPSAppViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappviewname = string;
        this.psappviewnameDirtyFlag = true;
    }

    public String getPSAppViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppViewName();
        }
        return this.psappviewname;
    }

    public boolean isPSAppViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppViewNameDirty();
        }
        return this.psappviewnameDirtyFlag;
    }

    public void resetPSAppViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppViewName();
            return;
        }
        this.psappviewnameDirtyFlag = false;
        this.psappviewname = null;
    }

    public void setPSDEActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeactionid = string;
        this.psdeactionidDirtyFlag = true;
    }

    public String getPSDEActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEActionId();
        }
        return this.psdeactionid;
    }

    public boolean isPSDEActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEActionIdDirty();
        }
        return this.psdeactionidDirtyFlag;
    }

    public void resetPSDEActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEActionId();
            return;
        }
        this.psdeactionidDirtyFlag = false;
        this.psdeactionid = null;
    }

    public void setPSDEActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeactionname = string;
        this.psdeactionnameDirtyFlag = true;
    }

    public String getPSDEActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEActionName();
        }
        return this.psdeactionname;
    }

    public boolean isPSDEActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEActionNameDirty();
        }
        return this.psdeactionnameDirtyFlag;
    }

    public void resetPSDEActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEActionName();
            return;
        }
        this.psdeactionnameDirtyFlag = false;
        this.psdeactionname = null;
    }

    public void setPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefid = string;
        this.psdefidDirtyFlag = true;
    }

    public String getPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFId();
        }
        return this.psdefid;
    }

    public boolean isPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFIdDirty();
        }
        return this.psdefidDirtyFlag;
    }

    public void resetPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFId();
            return;
        }
        this.psdefidDirtyFlag = false;
        this.psdefid = null;
    }

    public void setPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefname = string;
        this.psdefnameDirtyFlag = true;
    }

    public String getPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFName();
        }
        return this.psdefname;
    }

    public boolean isPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFNameDirty();
        }
        return this.psdefnameDirtyFlag;
    }

    public void resetPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFName();
            return;
        }
        this.psdefnameDirtyFlag = false;
        this.psdefname = null;
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

    public void setPSDELogicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDELogicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdelogicid = string;
        this.psdelogicidDirtyFlag = true;
    }

    public String getPSDELogicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDELogicId();
        }
        return this.psdelogicid;
    }

    public boolean isPSDELogicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDELogicIdDirty();
        }
        return this.psdelogicidDirtyFlag;
    }

    public void resetPSDELogicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDELogicId();
            return;
        }
        this.psdelogicidDirtyFlag = false;
        this.psdelogicid = null;
    }

    public void setPSDELogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDELogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdelogicname = string;
        this.psdelogicnameDirtyFlag = true;
    }

    public String getPSDELogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDELogicName();
        }
        return this.psdelogicname;
    }

    public boolean isPSDELogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDELogicNameDirty();
        }
        return this.psdelogicnameDirtyFlag;
    }

    public void resetPSDELogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDELogicName();
            return;
        }
        this.psdelogicnameDirtyFlag = false;
        this.psdelogicname = null;
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

    public void setPSDESADetailId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDESADetailId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdesadetailid = string;
        this.psdesadetailidDirtyFlag = true;
    }

    public String getPSDESADetailId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDESADetailId();
        }
        return this.psdesadetailid;
    }

    public boolean isPSDESADetailIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDESADetailIdDirty();
        }
        return this.psdesadetailidDirtyFlag;
    }

    public void resetPSDESADetailId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDESADetailId();
            return;
        }
        this.psdesadetailidDirtyFlag = false;
        this.psdesadetailid = null;
    }

    public void setPSDESADetailName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDESADetailName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdesadetailname = string;
        this.psdesadetailnameDirtyFlag = true;
    }

    public String getPSDESADetailName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDESADetailName();
        }
        return this.psdesadetailname;
    }

    public boolean isPSDESADetailNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDESADetailNameDirty();
        }
        return this.psdesadetailnameDirtyFlag;
    }

    public void resetPSDESADetailName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDESADetailName();
            return;
        }
        this.psdesadetailnameDirtyFlag = false;
        this.psdesadetailname = null;
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

    public void setPSSysTestCaseId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysTestCaseId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystestcaseid = string;
        this.pssystestcaseidDirtyFlag = true;
    }

    public String getPSSysTestCaseId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTestCaseId();
        }
        return this.pssystestcaseid;
    }

    public boolean isPSSysTestCaseIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysTestCaseIdDirty();
        }
        return this.pssystestcaseidDirtyFlag;
    }

    public void resetPSSysTestCaseId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysTestCaseId();
            return;
        }
        this.pssystestcaseidDirtyFlag = false;
        this.pssystestcaseid = null;
    }

    public void setPSSysTestCaseName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysTestCaseName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystestcasename = string;
        this.pssystestcasenameDirtyFlag = true;
    }

    public String getPSSysTestCaseName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTestCaseName();
        }
        return this.pssystestcasename;
    }

    public boolean isPSSysTestCaseNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysTestCaseNameDirty();
        }
        return this.pssystestcasenameDirtyFlag;
    }

    public void resetPSSysTestCaseName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysTestCaseName();
            return;
        }
        this.pssystestcasenameDirtyFlag = false;
        this.pssystestcasename = null;
    }

    public void setPSSysTestDataId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysTestDataId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystestdataid = string;
        this.pssystestdataidDirtyFlag = true;
    }

    public String getPSSysTestDataId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTestDataId();
        }
        return this.pssystestdataid;
    }

    public boolean isPSSysTestDataIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysTestDataIdDirty();
        }
        return this.pssystestdataidDirtyFlag;
    }

    public void resetPSSysTestDataId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysTestDataId();
            return;
        }
        this.pssystestdataidDirtyFlag = false;
        this.pssystestdataid = null;
    }

    public void setPSSysTestDataName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysTestDataName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystestdataname = string;
        this.pssystestdatanameDirtyFlag = true;
    }

    public String getPSSysTestDataName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTestDataName();
        }
        return this.pssystestdataname;
    }

    public boolean isPSSysTestDataNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysTestDataNameDirty();
        }
        return this.pssystestdatanameDirtyFlag;
    }

    public void resetPSSysTestDataName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysTestDataName();
            return;
        }
        this.pssystestdatanameDirtyFlag = false;
        this.pssystestdataname = null;
    }

    public void setPSSysTestModuleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysTestModuleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystestmoduleid = string;
        this.pssystestmoduleidDirtyFlag = true;
    }

    public String getPSSysTestModuleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTestModuleId();
        }
        return this.pssystestmoduleid;
    }

    public boolean isPSSysTestModuleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysTestModuleIdDirty();
        }
        return this.pssystestmoduleidDirtyFlag;
    }

    public void resetPSSysTestModuleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysTestModuleId();
            return;
        }
        this.pssystestmoduleidDirtyFlag = false;
        this.pssystestmoduleid = null;
    }

    public void setPSSysTestModuleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysTestModuleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystestmodulename = string;
        this.pssystestmodulenameDirtyFlag = true;
    }

    public String getPSSysTestModuleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTestModuleName();
        }
        return this.pssystestmodulename;
    }

    public boolean isPSSysTestModuleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysTestModuleNameDirty();
        }
        return this.pssystestmodulenameDirtyFlag;
    }

    public void resetPSSysTestModuleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysTestModuleName();
            return;
        }
        this.pssystestmodulenameDirtyFlag = false;
        this.pssystestmodulename = null;
    }

    public void setPSSysTestPrjId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysTestPrjId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystestprjid = string;
        this.pssystestprjidDirtyFlag = true;
    }

    public String getPSSysTestPrjId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTestPrjId();
        }
        return this.pssystestprjid;
    }

    public boolean isPSSysTestPrjIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysTestPrjIdDirty();
        }
        return this.pssystestprjidDirtyFlag;
    }

    public void resetPSSysTestPrjId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysTestPrjId();
            return;
        }
        this.pssystestprjidDirtyFlag = false;
        this.pssystestprjid = null;
    }

    public void setPSSysTestPrjName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysTestPrjName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystestprjname = string;
        this.pssystestprjnameDirtyFlag = true;
    }

    public String getPSSysTestPrjName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTestPrjName();
        }
        return this.pssystestprjname;
    }

    public boolean isPSSysTestPrjNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysTestPrjNameDirty();
        }
        return this.pssystestprjnameDirtyFlag;
    }

    public void resetPSSysTestPrjName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysTestPrjName();
            return;
        }
        this.pssystestprjnameDirtyFlag = false;
        this.pssystestprjname = null;
    }

    public void setRollbackTran(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRollbackTran(n);
            return;
        }
        this.rollbacktran = n;
        this.rollbacktranDirtyFlag = true;
    }

    public Integer getRollbackTran() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRollbackTran();
        }
        return this.rollbacktran;
    }

    public boolean isRollbackTranDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRollbackTranDirty();
        }
        return this.rollbacktranDirtyFlag;
    }

    public void resetRollbackTran() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRollbackTran();
            return;
        }
        this.rollbacktranDirtyFlag = false;
        this.rollbacktran = null;
    }

    public void setTargetType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTargetType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.targettype = string;
        this.targettypeDirtyFlag = true;
    }

    public String getTargetType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTargetType();
        }
        return this.targettype;
    }

    public boolean isTargetTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTargetTypeDirty();
        }
        return this.targettypeDirtyFlag;
    }

    public void resetTargetType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTargetType();
            return;
        }
        this.targettypeDirtyFlag = false;
        this.targettype = null;
    }

    public void setTestCaseLevel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTestCaseLevel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.testcaselevel = string;
        this.testcaselevelDirtyFlag = true;
    }

    public String getTestCaseLevel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTestCaseLevel();
        }
        return this.testcaselevel;
    }

    public boolean isTestCaseLevelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTestCaseLevelDirty();
        }
        return this.testcaselevelDirtyFlag;
    }

    public void resetTestCaseLevel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTestCaseLevel();
            return;
        }
        this.testcaselevelDirtyFlag = false;
        this.testcaselevel = null;
    }

    public void setTestCaseSN(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTestCaseSN(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.testcasesn = string;
        this.testcasesnDirtyFlag = true;
    }

    public String getTestCaseSN() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTestCaseSN();
        }
        return this.testcasesn;
    }

    public boolean isTestCaseSNDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTestCaseSNDirty();
        }
        return this.testcasesnDirtyFlag;
    }

    public void resetTestCaseSN() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTestCaseSN();
            return;
        }
        this.testcasesnDirtyFlag = false;
        this.testcasesn = null;
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

    public void setUserData3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserData3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userdata3 = string;
        this.userdata3DirtyFlag = true;
    }

    public String getUserData3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserData3();
        }
        return this.userdata3;
    }

    public boolean isUserData3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserData3Dirty();
        }
        return this.userdata3DirtyFlag;
    }

    public void resetUserData3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserData3();
            return;
        }
        this.userdata3DirtyFlag = false;
        this.userdata3 = null;
    }

    public void setUserData4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserData4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userdata4 = string;
        this.userdata4DirtyFlag = true;
    }

    public String getUserData4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserData4();
        }
        return this.userdata4;
    }

    public boolean isUserData4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserData4Dirty();
        }
        return this.userdata4DirtyFlag;
    }

    public void resetUserData4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserData4();
            return;
        }
        this.userdata4DirtyFlag = false;
        this.userdata4 = null;
    }

    public void setUserFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserFlag(n);
            return;
        }
        this.userflag = n;
        this.userflagDirtyFlag = true;
    }

    public Integer getUserFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserFlag();
        }
        return this.userflag;
    }

    public boolean isUserFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserFlagDirty();
        }
        return this.userflagDirtyFlag;
    }

    public void resetUserFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserFlag();
            return;
        }
        this.userflagDirtyFlag = false;
        this.userflag = null;
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
        PSSysTestCaseBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysTestCaseBase pSSysTestCaseBase) {
        pSSysTestCaseBase.resetActionParams();
        pSSysTestCaseBase.resetAssertResult();
        pSSysTestCaseBase.resetAssertType();
        pSSysTestCaseBase.resetCodeName();
        pSSysTestCaseBase.resetContent();
        pSSysTestCaseBase.resetCreateDate();
        pSSysTestCaseBase.resetCreateMan();
        pSSysTestCaseBase.resetDEFPSSysSampleValueId();
        pSSysTestCaseBase.resetDEFPSSysSampleValueName();
        pSSysTestCaseBase.resetDEFValue();
        pSSysTestCaseBase.resetExceptionData();
        pSSysTestCaseBase.resetExceptionData2();
        pSSysTestCaseBase.resetExceptionName();
        pSSysTestCaseBase.resetInputValues();
        pSSysTestCaseBase.resetLockFlag();
        pSSysTestCaseBase.resetMemo();
        pSSysTestCaseBase.resetOrderValue();
        pSSysTestCaseBase.resetPSAppViewId();
        pSSysTestCaseBase.resetPSAppViewName();
        pSSysTestCaseBase.resetPSDEActionId();
        pSSysTestCaseBase.resetPSDEActionName();
        pSSysTestCaseBase.resetPSDEFId();
        pSSysTestCaseBase.resetPSDEFName();
        pSSysTestCaseBase.resetPSDEId();
        pSSysTestCaseBase.resetPSDELogicId();
        pSSysTestCaseBase.resetPSDELogicName();
        pSSysTestCaseBase.resetPSDEName();
        pSSysTestCaseBase.resetPSDESADetailId();
        pSSysTestCaseBase.resetPSDESADetailName();
        pSSysTestCaseBase.resetPSDEServiceAPIId();
        pSSysTestCaseBase.resetPSDEServiceAPIName();
        pSSysTestCaseBase.resetPSSysAppId();
        pSSysTestCaseBase.resetPSSysReqItemId();
        pSSysTestCaseBase.resetPSSysReqItemName();
        pSSysTestCaseBase.resetPSSysServiceAPIId();
        pSSysTestCaseBase.resetPSSysSFPluginId();
        pSSysTestCaseBase.resetPSSysSFPluginName();
        pSSysTestCaseBase.resetPSSystemId();
        pSSysTestCaseBase.resetPSSystemName();
        pSSysTestCaseBase.resetPSSysTestCaseId();
        pSSysTestCaseBase.resetPSSysTestCaseName();
        pSSysTestCaseBase.resetPSSysTestDataId();
        pSSysTestCaseBase.resetPSSysTestDataName();
        pSSysTestCaseBase.resetPSSysTestModuleId();
        pSSysTestCaseBase.resetPSSysTestModuleName();
        pSSysTestCaseBase.resetPSSysTestPrjId();
        pSSysTestCaseBase.resetPSSysTestPrjName();
        pSSysTestCaseBase.resetRollbackTran();
        pSSysTestCaseBase.resetTargetType();
        pSSysTestCaseBase.resetTestCaseLevel();
        pSSysTestCaseBase.resetTestCaseSN();
        pSSysTestCaseBase.resetUpdateDate();
        pSSysTestCaseBase.resetUpdateMan();
        pSSysTestCaseBase.resetUserCat();
        pSSysTestCaseBase.resetUserData();
        pSSysTestCaseBase.resetUserData2();
        pSSysTestCaseBase.resetUserData3();
        pSSysTestCaseBase.resetUserData4();
        pSSysTestCaseBase.resetUserFlag();
        pSSysTestCaseBase.resetUserTag();
        pSSysTestCaseBase.resetUserTag2();
        pSSysTestCaseBase.resetUserTag3();
        pSSysTestCaseBase.resetUserTag4();
        pSSysTestCaseBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isActionParamsDirty()) {
            hashMap.put(FIELD_ACTIONPARAMS, this.getActionParams());
        }
        if (!bl || this.isAssertResultDirty()) {
            hashMap.put(FIELD_ASSERTRESULT, this.getAssertResult());
        }
        if (!bl || this.isAssertTypeDirty()) {
            hashMap.put(FIELD_ASSERTTYPE, this.getAssertType());
        }
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isContentDirty()) {
            hashMap.put(FIELD_CONTENT, this.getContent());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDEFPSSysSampleValueIdDirty()) {
            hashMap.put(FIELD_DEFPSSYSSAMPLEVALUEID, this.getDEFPSSysSampleValueId());
        }
        if (!bl || this.isDEFPSSysSampleValueNameDirty()) {
            hashMap.put(FIELD_DEFPSSYSSAMPLEVALUENAME, this.getDEFPSSysSampleValueName());
        }
        if (!bl || this.isDEFValueDirty()) {
            hashMap.put(FIELD_DEFVALUE, this.getDEFValue());
        }
        if (!bl || this.isExceptionDataDirty()) {
            hashMap.put(FIELD_EXCEPTIONDATA, this.getExceptionData());
        }
        if (!bl || this.isExceptionData2Dirty()) {
            hashMap.put(FIELD_EXCEPTIONDATA2, this.getExceptionData2());
        }
        if (!bl || this.isExceptionNameDirty()) {
            hashMap.put(FIELD_EXCEPTIONNAME, this.getExceptionName());
        }
        if (!bl || this.isInputValuesDirty()) {
            hashMap.put(FIELD_INPUTVALUES, this.getInputValues());
        }
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSAppViewIdDirty()) {
            hashMap.put(FIELD_PSAPPVIEWID, this.getPSAppViewId());
        }
        if (!bl || this.isPSAppViewNameDirty()) {
            hashMap.put(FIELD_PSAPPVIEWNAME, this.getPSAppViewName());
        }
        if (!bl || this.isPSDEActionIdDirty()) {
            hashMap.put(FIELD_PSDEACTIONID, this.getPSDEActionId());
        }
        if (!bl || this.isPSDEActionNameDirty()) {
            hashMap.put(FIELD_PSDEACTIONNAME, this.getPSDEActionName());
        }
        if (!bl || this.isPSDEFIdDirty()) {
            hashMap.put(FIELD_PSDEFID, this.getPSDEFId());
        }
        if (!bl || this.isPSDEFNameDirty()) {
            hashMap.put(FIELD_PSDEFNAME, this.getPSDEFName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDELogicIdDirty()) {
            hashMap.put(FIELD_PSDELOGICID, this.getPSDELogicId());
        }
        if (!bl || this.isPSDELogicNameDirty()) {
            hashMap.put(FIELD_PSDELOGICNAME, this.getPSDELogicName());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSDESADetailIdDirty()) {
            hashMap.put(FIELD_PSDESADETAILID, this.getPSDESADetailId());
        }
        if (!bl || this.isPSDESADetailNameDirty()) {
            hashMap.put(FIELD_PSDESADETAILNAME, this.getPSDESADetailName());
        }
        if (!bl || this.isPSDEServiceAPIIdDirty()) {
            hashMap.put(FIELD_PSDESERVICEAPIID, this.getPSDEServiceAPIId());
        }
        if (!bl || this.isPSDEServiceAPINameDirty()) {
            hashMap.put(FIELD_PSDESERVICEAPINAME, this.getPSDEServiceAPIName());
        }
        if (!bl || this.isPSSysAppIdDirty()) {
            hashMap.put(FIELD_PSSYSAPPID, this.getPSSysAppId());
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
        if (!bl || this.isPSSysTestCaseIdDirty()) {
            hashMap.put(FIELD_PSSYSTESTCASEID, this.getPSSysTestCaseId());
        }
        if (!bl || this.isPSSysTestCaseNameDirty()) {
            hashMap.put(FIELD_PSSYSTESTCASENAME, this.getPSSysTestCaseName());
        }
        if (!bl || this.isPSSysTestDataIdDirty()) {
            hashMap.put(FIELD_PSSYSTESTDATAID, this.getPSSysTestDataId());
        }
        if (!bl || this.isPSSysTestDataNameDirty()) {
            hashMap.put(FIELD_PSSYSTESTDATANAME, this.getPSSysTestDataName());
        }
        if (!bl || this.isPSSysTestModuleIdDirty()) {
            hashMap.put(FIELD_PSSYSTESTMODULEID, this.getPSSysTestModuleId());
        }
        if (!bl || this.isPSSysTestModuleNameDirty()) {
            hashMap.put(FIELD_PSSYSTESTMODULENAME, this.getPSSysTestModuleName());
        }
        if (!bl || this.isPSSysTestPrjIdDirty()) {
            hashMap.put(FIELD_PSSYSTESTPRJID, this.getPSSysTestPrjId());
        }
        if (!bl || this.isPSSysTestPrjNameDirty()) {
            hashMap.put(FIELD_PSSYSTESTPRJNAME, this.getPSSysTestPrjName());
        }
        if (!bl || this.isRollbackTranDirty()) {
            hashMap.put(FIELD_ROLLBACKTRAN, this.getRollbackTran());
        }
        if (!bl || this.isTargetTypeDirty()) {
            hashMap.put(FIELD_TARGETTYPE, this.getTargetType());
        }
        if (!bl || this.isTestCaseLevelDirty()) {
            hashMap.put(FIELD_TESTCASELEVEL, this.getTestCaseLevel());
        }
        if (!bl || this.isTestCaseSNDirty()) {
            hashMap.put(FIELD_TESTCASESN, this.getTestCaseSN());
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
        if (!bl || this.isUserData3Dirty()) {
            hashMap.put(FIELD_USERDATA3, this.getUserData3());
        }
        if (!bl || this.isUserData4Dirty()) {
            hashMap.put(FIELD_USERDATA4, this.getUserData4());
        }
        if (!bl || this.isUserFlagDirty()) {
            hashMap.put(FIELD_USERFLAG, this.getUserFlag());
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
        return PSSysTestCaseBase.get(this, n);
    }

    private static Object get(PSSysTestCaseBase pSSysTestCaseBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysTestCaseBase.getActionParams();
            }
            case 1: {
                return pSSysTestCaseBase.getAssertResult();
            }
            case 2: {
                return pSSysTestCaseBase.getAssertType();
            }
            case 3: {
                return pSSysTestCaseBase.getCodeName();
            }
            case 4: {
                return pSSysTestCaseBase.getContent();
            }
            case 5: {
                return pSSysTestCaseBase.getCreateDate();
            }
            case 6: {
                return pSSysTestCaseBase.getCreateMan();
            }
            case 7: {
                return pSSysTestCaseBase.getDEFPSSysSampleValueId();
            }
            case 8: {
                return pSSysTestCaseBase.getDEFPSSysSampleValueName();
            }
            case 9: {
                return pSSysTestCaseBase.getDEFValue();
            }
            case 10: {
                return pSSysTestCaseBase.getExceptionData();
            }
            case 11: {
                return pSSysTestCaseBase.getExceptionData2();
            }
            case 12: {
                return pSSysTestCaseBase.getExceptionName();
            }
            case 13: {
                return pSSysTestCaseBase.getInputValues();
            }
            case 14: {
                return pSSysTestCaseBase.getLockFlag();
            }
            case 15: {
                return pSSysTestCaseBase.getMemo();
            }
            case 16: {
                return pSSysTestCaseBase.getOrderValue();
            }
            case 17: {
                return pSSysTestCaseBase.getPSAppViewId();
            }
            case 18: {
                return pSSysTestCaseBase.getPSAppViewName();
            }
            case 19: {
                return pSSysTestCaseBase.getPSDEActionId();
            }
            case 20: {
                return pSSysTestCaseBase.getPSDEActionName();
            }
            case 21: {
                return pSSysTestCaseBase.getPSDEFId();
            }
            case 22: {
                return pSSysTestCaseBase.getPSDEFName();
            }
            case 23: {
                return pSSysTestCaseBase.getPSDEId();
            }
            case 24: {
                return pSSysTestCaseBase.getPSDELogicId();
            }
            case 25: {
                return pSSysTestCaseBase.getPSDELogicName();
            }
            case 26: {
                return pSSysTestCaseBase.getPSDEName();
            }
            case 27: {
                return pSSysTestCaseBase.getPSDESADetailId();
            }
            case 28: {
                return pSSysTestCaseBase.getPSDESADetailName();
            }
            case 29: {
                return pSSysTestCaseBase.getPSDEServiceAPIId();
            }
            case 30: {
                return pSSysTestCaseBase.getPSDEServiceAPIName();
            }
            case 31: {
                return pSSysTestCaseBase.getPSSysAppId();
            }
            case 32: {
                return pSSysTestCaseBase.getPSSysReqItemId();
            }
            case 33: {
                return pSSysTestCaseBase.getPSSysReqItemName();
            }
            case 34: {
                return pSSysTestCaseBase.getPSSysServiceAPIId();
            }
            case 35: {
                return pSSysTestCaseBase.getPSSysSFPluginId();
            }
            case 36: {
                return pSSysTestCaseBase.getPSSysSFPluginName();
            }
            case 37: {
                return pSSysTestCaseBase.getPSSystemId();
            }
            case 38: {
                return pSSysTestCaseBase.getPSSystemName();
            }
            case 39: {
                return pSSysTestCaseBase.getPSSysTestCaseId();
            }
            case 40: {
                return pSSysTestCaseBase.getPSSysTestCaseName();
            }
            case 41: {
                return pSSysTestCaseBase.getPSSysTestDataId();
            }
            case 42: {
                return pSSysTestCaseBase.getPSSysTestDataName();
            }
            case 43: {
                return pSSysTestCaseBase.getPSSysTestModuleId();
            }
            case 44: {
                return pSSysTestCaseBase.getPSSysTestModuleName();
            }
            case 45: {
                return pSSysTestCaseBase.getPSSysTestPrjId();
            }
            case 46: {
                return pSSysTestCaseBase.getPSSysTestPrjName();
            }
            case 47: {
                return pSSysTestCaseBase.getRollbackTran();
            }
            case 48: {
                return pSSysTestCaseBase.getTargetType();
            }
            case 49: {
                return pSSysTestCaseBase.getTestCaseLevel();
            }
            case 50: {
                return pSSysTestCaseBase.getTestCaseSN();
            }
            case 51: {
                return pSSysTestCaseBase.getUpdateDate();
            }
            case 52: {
                return pSSysTestCaseBase.getUpdateMan();
            }
            case 53: {
                return pSSysTestCaseBase.getUserCat();
            }
            case 54: {
                return pSSysTestCaseBase.getUserData();
            }
            case 55: {
                return pSSysTestCaseBase.getUserData2();
            }
            case 56: {
                return pSSysTestCaseBase.getUserData3();
            }
            case 57: {
                return pSSysTestCaseBase.getUserData4();
            }
            case 58: {
                return pSSysTestCaseBase.getUserFlag();
            }
            case 59: {
                return pSSysTestCaseBase.getUserTag();
            }
            case 60: {
                return pSSysTestCaseBase.getUserTag2();
            }
            case 61: {
                return pSSysTestCaseBase.getUserTag3();
            }
            case 62: {
                return pSSysTestCaseBase.getUserTag4();
            }
            case 63: {
                return pSSysTestCaseBase.getValidFlag();
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
        PSSysTestCaseBase.set(this, n, object);
    }

    private static void set(PSSysTestCaseBase pSSysTestCaseBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysTestCaseBase.setActionParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysTestCaseBase.setAssertResult(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysTestCaseBase.setAssertType(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysTestCaseBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysTestCaseBase.setContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysTestCaseBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 6: {
                pSSysTestCaseBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysTestCaseBase.setDEFPSSysSampleValueId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysTestCaseBase.setDEFPSSysSampleValueName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysTestCaseBase.setDEFValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysTestCaseBase.setExceptionData(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysTestCaseBase.setExceptionData2(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysTestCaseBase.setExceptionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysTestCaseBase.setInputValues(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysTestCaseBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSSysTestCaseBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysTestCaseBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 17: {
                pSSysTestCaseBase.setPSAppViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysTestCaseBase.setPSAppViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysTestCaseBase.setPSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysTestCaseBase.setPSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysTestCaseBase.setPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysTestCaseBase.setPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysTestCaseBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysTestCaseBase.setPSDELogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysTestCaseBase.setPSDELogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysTestCaseBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysTestCaseBase.setPSDESADetailId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysTestCaseBase.setPSDESADetailName(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSysTestCaseBase.setPSDEServiceAPIId(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSysTestCaseBase.setPSDEServiceAPIName(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSSysTestCaseBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSysTestCaseBase.setPSSysReqItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSSysTestCaseBase.setPSSysReqItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSSysTestCaseBase.setPSSysServiceAPIId(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSSysTestCaseBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSSysTestCaseBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSSysTestCaseBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSSysTestCaseBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSSysTestCaseBase.setPSSysTestCaseId(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSSysTestCaseBase.setPSSysTestCaseName(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSSysTestCaseBase.setPSSysTestDataId(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSSysTestCaseBase.setPSSysTestDataName(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSSysTestCaseBase.setPSSysTestModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSSysTestCaseBase.setPSSysTestModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSSysTestCaseBase.setPSSysTestPrjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSSysTestCaseBase.setPSSysTestPrjName(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSSysTestCaseBase.setRollbackTran(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 48: {
                pSSysTestCaseBase.setTargetType(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSSysTestCaseBase.setTestCaseLevel(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSSysTestCaseBase.setTestCaseSN(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSSysTestCaseBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 52: {
                pSSysTestCaseBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 53: {
                pSSysTestCaseBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 54: {
                pSSysTestCaseBase.setUserData(DataObject.getStringValue((Object)object));
                return;
            }
            case 55: {
                pSSysTestCaseBase.setUserData2(DataObject.getStringValue((Object)object));
                return;
            }
            case 56: {
                pSSysTestCaseBase.setUserData3(DataObject.getStringValue((Object)object));
                return;
            }
            case 57: {
                pSSysTestCaseBase.setUserData4(DataObject.getStringValue((Object)object));
                return;
            }
            case 58: {
                pSSysTestCaseBase.setUserFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 59: {
                pSSysTestCaseBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 60: {
                pSSysTestCaseBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 61: {
                pSSysTestCaseBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 62: {
                pSSysTestCaseBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 63: {
                pSSysTestCaseBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSysTestCaseBase.isNull(this, n);
    }

    private static boolean isNull(PSSysTestCaseBase pSSysTestCaseBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysTestCaseBase.getActionParams() == null;
            }
            case 1: {
                return pSSysTestCaseBase.getAssertResult() == null;
            }
            case 2: {
                return pSSysTestCaseBase.getAssertType() == null;
            }
            case 3: {
                return pSSysTestCaseBase.getCodeName() == null;
            }
            case 4: {
                return pSSysTestCaseBase.getContent() == null;
            }
            case 5: {
                return pSSysTestCaseBase.getCreateDate() == null;
            }
            case 6: {
                return pSSysTestCaseBase.getCreateMan() == null;
            }
            case 7: {
                return pSSysTestCaseBase.getDEFPSSysSampleValueId() == null;
            }
            case 8: {
                return pSSysTestCaseBase.getDEFPSSysSampleValueName() == null;
            }
            case 9: {
                return pSSysTestCaseBase.getDEFValue() == null;
            }
            case 10: {
                return pSSysTestCaseBase.getExceptionData() == null;
            }
            case 11: {
                return pSSysTestCaseBase.getExceptionData2() == null;
            }
            case 12: {
                return pSSysTestCaseBase.getExceptionName() == null;
            }
            case 13: {
                return pSSysTestCaseBase.getInputValues() == null;
            }
            case 14: {
                return pSSysTestCaseBase.getLockFlag() == null;
            }
            case 15: {
                return pSSysTestCaseBase.getMemo() == null;
            }
            case 16: {
                return pSSysTestCaseBase.getOrderValue() == null;
            }
            case 17: {
                return pSSysTestCaseBase.getPSAppViewId() == null;
            }
            case 18: {
                return pSSysTestCaseBase.getPSAppViewName() == null;
            }
            case 19: {
                return pSSysTestCaseBase.getPSDEActionId() == null;
            }
            case 20: {
                return pSSysTestCaseBase.getPSDEActionName() == null;
            }
            case 21: {
                return pSSysTestCaseBase.getPSDEFId() == null;
            }
            case 22: {
                return pSSysTestCaseBase.getPSDEFName() == null;
            }
            case 23: {
                return pSSysTestCaseBase.getPSDEId() == null;
            }
            case 24: {
                return pSSysTestCaseBase.getPSDELogicId() == null;
            }
            case 25: {
                return pSSysTestCaseBase.getPSDELogicName() == null;
            }
            case 26: {
                return pSSysTestCaseBase.getPSDEName() == null;
            }
            case 27: {
                return pSSysTestCaseBase.getPSDESADetailId() == null;
            }
            case 28: {
                return pSSysTestCaseBase.getPSDESADetailName() == null;
            }
            case 29: {
                return pSSysTestCaseBase.getPSDEServiceAPIId() == null;
            }
            case 30: {
                return pSSysTestCaseBase.getPSDEServiceAPIName() == null;
            }
            case 31: {
                return pSSysTestCaseBase.getPSSysAppId() == null;
            }
            case 32: {
                return pSSysTestCaseBase.getPSSysReqItemId() == null;
            }
            case 33: {
                return pSSysTestCaseBase.getPSSysReqItemName() == null;
            }
            case 34: {
                return pSSysTestCaseBase.getPSSysServiceAPIId() == null;
            }
            case 35: {
                return pSSysTestCaseBase.getPSSysSFPluginId() == null;
            }
            case 36: {
                return pSSysTestCaseBase.getPSSysSFPluginName() == null;
            }
            case 37: {
                return pSSysTestCaseBase.getPSSystemId() == null;
            }
            case 38: {
                return pSSysTestCaseBase.getPSSystemName() == null;
            }
            case 39: {
                return pSSysTestCaseBase.getPSSysTestCaseId() == null;
            }
            case 40: {
                return pSSysTestCaseBase.getPSSysTestCaseName() == null;
            }
            case 41: {
                return pSSysTestCaseBase.getPSSysTestDataId() == null;
            }
            case 42: {
                return pSSysTestCaseBase.getPSSysTestDataName() == null;
            }
            case 43: {
                return pSSysTestCaseBase.getPSSysTestModuleId() == null;
            }
            case 44: {
                return pSSysTestCaseBase.getPSSysTestModuleName() == null;
            }
            case 45: {
                return pSSysTestCaseBase.getPSSysTestPrjId() == null;
            }
            case 46: {
                return pSSysTestCaseBase.getPSSysTestPrjName() == null;
            }
            case 47: {
                return pSSysTestCaseBase.getRollbackTran() == null;
            }
            case 48: {
                return pSSysTestCaseBase.getTargetType() == null;
            }
            case 49: {
                return pSSysTestCaseBase.getTestCaseLevel() == null;
            }
            case 50: {
                return pSSysTestCaseBase.getTestCaseSN() == null;
            }
            case 51: {
                return pSSysTestCaseBase.getUpdateDate() == null;
            }
            case 52: {
                return pSSysTestCaseBase.getUpdateMan() == null;
            }
            case 53: {
                return pSSysTestCaseBase.getUserCat() == null;
            }
            case 54: {
                return pSSysTestCaseBase.getUserData() == null;
            }
            case 55: {
                return pSSysTestCaseBase.getUserData2() == null;
            }
            case 56: {
                return pSSysTestCaseBase.getUserData3() == null;
            }
            case 57: {
                return pSSysTestCaseBase.getUserData4() == null;
            }
            case 58: {
                return pSSysTestCaseBase.getUserFlag() == null;
            }
            case 59: {
                return pSSysTestCaseBase.getUserTag() == null;
            }
            case 60: {
                return pSSysTestCaseBase.getUserTag2() == null;
            }
            case 61: {
                return pSSysTestCaseBase.getUserTag3() == null;
            }
            case 62: {
                return pSSysTestCaseBase.getUserTag4() == null;
            }
            case 63: {
                return pSSysTestCaseBase.getValidFlag() == null;
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
        return PSSysTestCaseBase.contains(this, n);
    }

    private static boolean contains(PSSysTestCaseBase pSSysTestCaseBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysTestCaseBase.isActionParamsDirty();
            }
            case 1: {
                return pSSysTestCaseBase.isAssertResultDirty();
            }
            case 2: {
                return pSSysTestCaseBase.isAssertTypeDirty();
            }
            case 3: {
                return pSSysTestCaseBase.isCodeNameDirty();
            }
            case 4: {
                return pSSysTestCaseBase.isContentDirty();
            }
            case 5: {
                return pSSysTestCaseBase.isCreateDateDirty();
            }
            case 6: {
                return pSSysTestCaseBase.isCreateManDirty();
            }
            case 7: {
                return pSSysTestCaseBase.isDEFPSSysSampleValueIdDirty();
            }
            case 8: {
                return pSSysTestCaseBase.isDEFPSSysSampleValueNameDirty();
            }
            case 9: {
                return pSSysTestCaseBase.isDEFValueDirty();
            }
            case 10: {
                return pSSysTestCaseBase.isExceptionDataDirty();
            }
            case 11: {
                return pSSysTestCaseBase.isExceptionData2Dirty();
            }
            case 12: {
                return pSSysTestCaseBase.isExceptionNameDirty();
            }
            case 13: {
                return pSSysTestCaseBase.isInputValuesDirty();
            }
            case 14: {
                return pSSysTestCaseBase.isLockFlagDirty();
            }
            case 15: {
                return pSSysTestCaseBase.isMemoDirty();
            }
            case 16: {
                return pSSysTestCaseBase.isOrderValueDirty();
            }
            case 17: {
                return pSSysTestCaseBase.isPSAppViewIdDirty();
            }
            case 18: {
                return pSSysTestCaseBase.isPSAppViewNameDirty();
            }
            case 19: {
                return pSSysTestCaseBase.isPSDEActionIdDirty();
            }
            case 20: {
                return pSSysTestCaseBase.isPSDEActionNameDirty();
            }
            case 21: {
                return pSSysTestCaseBase.isPSDEFIdDirty();
            }
            case 22: {
                return pSSysTestCaseBase.isPSDEFNameDirty();
            }
            case 23: {
                return pSSysTestCaseBase.isPSDEIdDirty();
            }
            case 24: {
                return pSSysTestCaseBase.isPSDELogicIdDirty();
            }
            case 25: {
                return pSSysTestCaseBase.isPSDELogicNameDirty();
            }
            case 26: {
                return pSSysTestCaseBase.isPSDENameDirty();
            }
            case 27: {
                return pSSysTestCaseBase.isPSDESADetailIdDirty();
            }
            case 28: {
                return pSSysTestCaseBase.isPSDESADetailNameDirty();
            }
            case 29: {
                return pSSysTestCaseBase.isPSDEServiceAPIIdDirty();
            }
            case 30: {
                return pSSysTestCaseBase.isPSDEServiceAPINameDirty();
            }
            case 31: {
                return pSSysTestCaseBase.isPSSysAppIdDirty();
            }
            case 32: {
                return pSSysTestCaseBase.isPSSysReqItemIdDirty();
            }
            case 33: {
                return pSSysTestCaseBase.isPSSysReqItemNameDirty();
            }
            case 34: {
                return pSSysTestCaseBase.isPSSysServiceAPIIdDirty();
            }
            case 35: {
                return pSSysTestCaseBase.isPSSysSFPluginIdDirty();
            }
            case 36: {
                return pSSysTestCaseBase.isPSSysSFPluginNameDirty();
            }
            case 37: {
                return pSSysTestCaseBase.isPSSystemIdDirty();
            }
            case 38: {
                return pSSysTestCaseBase.isPSSystemNameDirty();
            }
            case 39: {
                return pSSysTestCaseBase.isPSSysTestCaseIdDirty();
            }
            case 40: {
                return pSSysTestCaseBase.isPSSysTestCaseNameDirty();
            }
            case 41: {
                return pSSysTestCaseBase.isPSSysTestDataIdDirty();
            }
            case 42: {
                return pSSysTestCaseBase.isPSSysTestDataNameDirty();
            }
            case 43: {
                return pSSysTestCaseBase.isPSSysTestModuleIdDirty();
            }
            case 44: {
                return pSSysTestCaseBase.isPSSysTestModuleNameDirty();
            }
            case 45: {
                return pSSysTestCaseBase.isPSSysTestPrjIdDirty();
            }
            case 46: {
                return pSSysTestCaseBase.isPSSysTestPrjNameDirty();
            }
            case 47: {
                return pSSysTestCaseBase.isRollbackTranDirty();
            }
            case 48: {
                return pSSysTestCaseBase.isTargetTypeDirty();
            }
            case 49: {
                return pSSysTestCaseBase.isTestCaseLevelDirty();
            }
            case 50: {
                return pSSysTestCaseBase.isTestCaseSNDirty();
            }
            case 51: {
                return pSSysTestCaseBase.isUpdateDateDirty();
            }
            case 52: {
                return pSSysTestCaseBase.isUpdateManDirty();
            }
            case 53: {
                return pSSysTestCaseBase.isUserCatDirty();
            }
            case 54: {
                return pSSysTestCaseBase.isUserDataDirty();
            }
            case 55: {
                return pSSysTestCaseBase.isUserData2Dirty();
            }
            case 56: {
                return pSSysTestCaseBase.isUserData3Dirty();
            }
            case 57: {
                return pSSysTestCaseBase.isUserData4Dirty();
            }
            case 58: {
                return pSSysTestCaseBase.isUserFlagDirty();
            }
            case 59: {
                return pSSysTestCaseBase.isUserTagDirty();
            }
            case 60: {
                return pSSysTestCaseBase.isUserTag2Dirty();
            }
            case 61: {
                return pSSysTestCaseBase.isUserTag3Dirty();
            }
            case 62: {
                return pSSysTestCaseBase.isUserTag4Dirty();
            }
            case 63: {
                return pSSysTestCaseBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysTestCaseBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysTestCaseBase pSSysTestCaseBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysTestCaseBase.getActionParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionparams", (Object)PSSysTestCaseBase.getJSONValue((Object)pSSysTestCaseBase.getActionParams()), (boolean)false);
        }
        if (bl || pSSysTestCaseBase.getAssertResult() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"assertresult", (Object)PSSysTestCaseBase.getJSONValue((Object)pSSysTestCaseBase.getAssertResult()), (boolean)false);
        }
        if (bl || pSSysTestCaseBase.getAssertType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"asserttype", (Object)PSSysTestCaseBase.getJSONValue((Object)pSSysTestCaseBase.getAssertType()), (boolean)false);
        }
        if (bl || pSSysTestCaseBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysTestCaseBase.getJSONValue((Object)pSSysTestCaseBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysTestCaseBase.getContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"content", (Object)PSSysTestCaseBase.getJSONValue((Object)pSSysTestCaseBase.getContent()), (boolean)false);
        }
        if (bl || pSSysTestCaseBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysTestCaseBase.getJSONValue((Object)pSSysTestCaseBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysTestCaseBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysTestCaseBase.getJSONValue((Object)pSSysTestCaseBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysTestCaseBase.getDEFPSSysSampleValueId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defpssyssamplevalueid", (Object)PSSysTestCaseBase.getJSONValue((Object)pSSysTestCaseBase.getDEFPSSysSampleValueId()), (boolean)false);
        }
        if (bl || pSSysTestCaseBase.getDEFPSSysSampleValueName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defpssyssamplevaluename", (Object)PSSysTestCaseBase.getJSONValue((Object)pSSysTestCaseBase.getDEFPSSysSampleValueName()), (boolean)false);
        }
        if (bl || pSSysTestCaseBase.getDEFValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defvalue", (Object)PSSysTestCaseBase.getJSONValue((Object)pSSysTestCaseBase.getDEFValue()), (boolean)false);
        }
        if (bl || pSSysTestCaseBase.getExceptionData() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"exceptiondata", (Object)PSSysTestCaseBase.getJSONValue((Object)pSSysTestCaseBase.getExceptionData()), (boolean)false);
        }
        if (bl || pSSysTestCaseBase.getExceptionData2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"exceptiondata2", (Object)PSSysTestCaseBase.getJSONValue((Object)pSSysTestCaseBase.getExceptionData2()), (boolean)false);
        }
        if (bl || pSSysTestCaseBase.getExceptionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"exceptionname", (Object)PSSysTestCaseBase.getJSONValue((Object)pSSysTestCaseBase.getExceptionName()), (boolean)false);
        }
        if (bl || pSSysTestCaseBase.getInputValues() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"inputvalues", (Object)PSSysTestCaseBase.getJSONValue((Object)pSSysTestCaseBase.getInputValues()), (boolean)false);
        }
        if (bl || pSSysTestCaseBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSSysTestCaseBase.getJSONValue((Object)pSSysTestCaseBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSSysTestCaseBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysTestCaseBase.getJSONValue((Object)pSSysTestCaseBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysTestCaseBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSysTestCaseBase.getJSONValue((Object)pSSysTestCaseBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSysTestCaseBase.getPSAppViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappviewid", (Object)PSSysTestCaseBase.getJSONValue((Object)pSSysTestCaseBase.getPSAppViewId()), (boolean)false);
        }
        if (bl || pSSysTestCaseBase.getPSAppViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappviewname", (Object)PSSysTestCaseBase.getJSONValue((Object)pSSysTestCaseBase.getPSAppViewName()), (boolean)false);
        }
        if (bl || pSSysTestCaseBase.getPSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactionid", (Object)PSSysTestCaseBase.getJSONValue((Object)pSSysTestCaseBase.getPSDEActionId()), (boolean)false);
        }
        if (bl || pSSysTestCaseBase.getPSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactionname", (Object)PSSysTestCaseBase.getJSONValue((Object)pSSysTestCaseBase.getPSDEActionName()), (boolean)false);
        }
        if (bl || pSSysTestCaseBase.getPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefid", (Object)PSSysTestCaseBase.getJSONValue((Object)pSSysTestCaseBase.getPSDEFId()), (boolean)false);
        }
        if (bl || pSSysTestCaseBase.getPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefname", (Object)PSSysTestCaseBase.getJSONValue((Object)pSSysTestCaseBase.getPSDEFName()), (boolean)false);
        }
        if (bl || pSSysTestCaseBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSSysTestCaseBase.getJSONValue((Object)pSSysTestCaseBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSSysTestCaseBase.getPSDELogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicid", (Object)PSSysTestCaseBase.getJSONValue((Object)pSSysTestCaseBase.getPSDELogicId()), (boolean)false);
        }
        if (bl || pSSysTestCaseBase.getPSDELogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicname", (Object)PSSysTestCaseBase.getJSONValue((Object)pSSysTestCaseBase.getPSDELogicName()), (boolean)false);
        }
        if (bl || pSSysTestCaseBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSSysTestCaseBase.getJSONValue((Object)pSSysTestCaseBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSSysTestCaseBase.getPSDESADetailId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdesadetailid", (Object)PSSysTestCaseBase.getJSONValue((Object)pSSysTestCaseBase.getPSDESADetailId()), (boolean)false);
        }
        if (bl || pSSysTestCaseBase.getPSDESADetailName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdesadetailname", (Object)PSSysTestCaseBase.getJSONValue((Object)pSSysTestCaseBase.getPSDESADetailName()), (boolean)false);
        }
        if (bl || pSSysTestCaseBase.getPSDEServiceAPIId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeserviceapiid", (Object)PSSysTestCaseBase.getJSONValue((Object)pSSysTestCaseBase.getPSDEServiceAPIId()), (boolean)false);
        }
        if (bl || pSSysTestCaseBase.getPSDEServiceAPIName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeserviceapiname", (Object)PSSysTestCaseBase.getJSONValue((Object)pSSysTestCaseBase.getPSDEServiceAPIName()), (boolean)false);
        }
        if (bl || pSSysTestCaseBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSSysTestCaseBase.getJSONValue((Object)pSSysTestCaseBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSSysTestCaseBase.getPSSysReqItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemid", (Object)PSSysTestCaseBase.getJSONValue((Object)pSSysTestCaseBase.getPSSysReqItemId()), (boolean)false);
        }
        if (bl || pSSysTestCaseBase.getPSSysReqItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemname", (Object)PSSysTestCaseBase.getJSONValue((Object)pSSysTestCaseBase.getPSSysReqItemName()), (boolean)false);
        }
        if (bl || pSSysTestCaseBase.getPSSysServiceAPIId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysserviceapiid", (Object)PSSysTestCaseBase.getJSONValue((Object)pSSysTestCaseBase.getPSSysServiceAPIId()), (boolean)false);
        }
        if (bl || pSSysTestCaseBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSSysTestCaseBase.getJSONValue((Object)pSSysTestCaseBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSSysTestCaseBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSSysTestCaseBase.getJSONValue((Object)pSSysTestCaseBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSSysTestCaseBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysTestCaseBase.getJSONValue((Object)pSSysTestCaseBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysTestCaseBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysTestCaseBase.getJSONValue((Object)pSSysTestCaseBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysTestCaseBase.getPSSysTestCaseId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystestcaseid", (Object)PSSysTestCaseBase.getJSONValue((Object)pSSysTestCaseBase.getPSSysTestCaseId()), (boolean)false);
        }
        if (bl || pSSysTestCaseBase.getPSSysTestCaseName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystestcasename", (Object)PSSysTestCaseBase.getJSONValue((Object)pSSysTestCaseBase.getPSSysTestCaseName()), (boolean)false);
        }
        if (bl || pSSysTestCaseBase.getPSSysTestDataId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystestdataid", (Object)PSSysTestCaseBase.getJSONValue((Object)pSSysTestCaseBase.getPSSysTestDataId()), (boolean)false);
        }
        if (bl || pSSysTestCaseBase.getPSSysTestDataName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystestdataname", (Object)PSSysTestCaseBase.getJSONValue((Object)pSSysTestCaseBase.getPSSysTestDataName()), (boolean)false);
        }
        if (bl || pSSysTestCaseBase.getPSSysTestModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystestmoduleid", (Object)PSSysTestCaseBase.getJSONValue((Object)pSSysTestCaseBase.getPSSysTestModuleId()), (boolean)false);
        }
        if (bl || pSSysTestCaseBase.getPSSysTestModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystestmodulename", (Object)PSSysTestCaseBase.getJSONValue((Object)pSSysTestCaseBase.getPSSysTestModuleName()), (boolean)false);
        }
        if (bl || pSSysTestCaseBase.getPSSysTestPrjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystestprjid", (Object)PSSysTestCaseBase.getJSONValue((Object)pSSysTestCaseBase.getPSSysTestPrjId()), (boolean)false);
        }
        if (bl || pSSysTestCaseBase.getPSSysTestPrjName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystestprjname", (Object)PSSysTestCaseBase.getJSONValue((Object)pSSysTestCaseBase.getPSSysTestPrjName()), (boolean)false);
        }
        if (bl || pSSysTestCaseBase.getRollbackTran() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rollbacktran", (Object)PSSysTestCaseBase.getJSONValue((Object)pSSysTestCaseBase.getRollbackTran()), (boolean)false);
        }
        if (bl || pSSysTestCaseBase.getTargetType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"targettype", (Object)PSSysTestCaseBase.getJSONValue((Object)pSSysTestCaseBase.getTargetType()), (boolean)false);
        }
        if (bl || pSSysTestCaseBase.getTestCaseLevel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"testcaselevel", (Object)PSSysTestCaseBase.getJSONValue((Object)pSSysTestCaseBase.getTestCaseLevel()), (boolean)false);
        }
        if (bl || pSSysTestCaseBase.getTestCaseSN() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"testcasesn", (Object)PSSysTestCaseBase.getJSONValue((Object)pSSysTestCaseBase.getTestCaseSN()), (boolean)false);
        }
        if (bl || pSSysTestCaseBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysTestCaseBase.getJSONValue((Object)pSSysTestCaseBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysTestCaseBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysTestCaseBase.getJSONValue((Object)pSSysTestCaseBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysTestCaseBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysTestCaseBase.getJSONValue((Object)pSSysTestCaseBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysTestCaseBase.getUserData() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userdata", (Object)PSSysTestCaseBase.getJSONValue((Object)pSSysTestCaseBase.getUserData()), (boolean)false);
        }
        if (bl || pSSysTestCaseBase.getUserData2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userdata2", (Object)PSSysTestCaseBase.getJSONValue((Object)pSSysTestCaseBase.getUserData2()), (boolean)false);
        }
        if (bl || pSSysTestCaseBase.getUserData3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userdata3", (Object)PSSysTestCaseBase.getJSONValue((Object)pSSysTestCaseBase.getUserData3()), (boolean)false);
        }
        if (bl || pSSysTestCaseBase.getUserData4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userdata4", (Object)PSSysTestCaseBase.getJSONValue((Object)pSSysTestCaseBase.getUserData4()), (boolean)false);
        }
        if (bl || pSSysTestCaseBase.getUserFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userflag", (Object)PSSysTestCaseBase.getJSONValue((Object)pSSysTestCaseBase.getUserFlag()), (boolean)false);
        }
        if (bl || pSSysTestCaseBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysTestCaseBase.getJSONValue((Object)pSSysTestCaseBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysTestCaseBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysTestCaseBase.getJSONValue((Object)pSSysTestCaseBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysTestCaseBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysTestCaseBase.getJSONValue((Object)pSSysTestCaseBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysTestCaseBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysTestCaseBase.getJSONValue((Object)pSSysTestCaseBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysTestCaseBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysTestCaseBase.getJSONValue((Object)pSSysTestCaseBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysTestCaseBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysTestCaseBase pSSysTestCaseBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysTestCaseBase.getActionParams() != null) {
            object = pSSysTestCaseBase.getActionParams();
            xmlNode.setAttribute(FIELD_ACTIONPARAMS, (String)(object == null ? "" : object));
        }
        if (bl || pSSysTestCaseBase.getAssertResult() != null) {
            object = pSSysTestCaseBase.getAssertResult();
            xmlNode.setAttribute(FIELD_ASSERTRESULT, (String)(object == null ? "" : object));
        }
        if (bl || pSSysTestCaseBase.getAssertType() != null) {
            object = pSSysTestCaseBase.getAssertType();
            xmlNode.setAttribute(FIELD_ASSERTTYPE, (String)(object == null ? "" : object));
        }
        if (bl || pSSysTestCaseBase.getCodeName() != null) {
            object = pSSysTestCaseBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, (String)(object == null ? "" : object));
        }
        if (bl || pSSysTestCaseBase.getContent() != null) {
            object = pSSysTestCaseBase.getContent();
            xmlNode.setAttribute(FIELD_CONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestCaseBase.getCreateDate() != null) {
            object = pSSysTestCaseBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysTestCaseBase.getCreateMan() != null) {
            object = pSSysTestCaseBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestCaseBase.getDEFPSSysSampleValueId() != null) {
            object = pSSysTestCaseBase.getDEFPSSysSampleValueId();
            xmlNode.setAttribute(FIELD_DEFPSSYSSAMPLEVALUEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestCaseBase.getDEFPSSysSampleValueName() != null) {
            object = pSSysTestCaseBase.getDEFPSSysSampleValueName();
            xmlNode.setAttribute(FIELD_DEFPSSYSSAMPLEVALUENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestCaseBase.getDEFValue() != null) {
            object = pSSysTestCaseBase.getDEFValue();
            xmlNode.setAttribute(FIELD_DEFVALUE, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestCaseBase.getExceptionData() != null) {
            object = pSSysTestCaseBase.getExceptionData();
            xmlNode.setAttribute(FIELD_EXCEPTIONDATA, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestCaseBase.getExceptionData2() != null) {
            object = pSSysTestCaseBase.getExceptionData2();
            xmlNode.setAttribute(FIELD_EXCEPTIONDATA2, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestCaseBase.getExceptionName() != null) {
            object = pSSysTestCaseBase.getExceptionName();
            xmlNode.setAttribute(FIELD_EXCEPTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestCaseBase.getInputValues() != null) {
            object = pSSysTestCaseBase.getInputValues();
            xmlNode.setAttribute(FIELD_INPUTVALUES, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestCaseBase.getLockFlag() != null) {
            object = pSSysTestCaseBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysTestCaseBase.getMemo() != null) {
            object = pSSysTestCaseBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestCaseBase.getOrderValue() != null) {
            object = pSSysTestCaseBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysTestCaseBase.getPSAppViewId() != null) {
            object = pSSysTestCaseBase.getPSAppViewId();
            xmlNode.setAttribute(FIELD_PSAPPVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestCaseBase.getPSAppViewName() != null) {
            object = pSSysTestCaseBase.getPSAppViewName();
            xmlNode.setAttribute(FIELD_PSAPPVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestCaseBase.getPSDEActionId() != null) {
            object = pSSysTestCaseBase.getPSDEActionId();
            xmlNode.setAttribute(FIELD_PSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestCaseBase.getPSDEActionName() != null) {
            object = pSSysTestCaseBase.getPSDEActionName();
            xmlNode.setAttribute(FIELD_PSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestCaseBase.getPSDEFId() != null) {
            object = pSSysTestCaseBase.getPSDEFId();
            xmlNode.setAttribute(FIELD_PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestCaseBase.getPSDEFName() != null) {
            object = pSSysTestCaseBase.getPSDEFName();
            xmlNode.setAttribute(FIELD_PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestCaseBase.getPSDEId() != null) {
            object = pSSysTestCaseBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestCaseBase.getPSDELogicId() != null) {
            object = pSSysTestCaseBase.getPSDELogicId();
            xmlNode.setAttribute(FIELD_PSDELOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestCaseBase.getPSDELogicName() != null) {
            object = pSSysTestCaseBase.getPSDELogicName();
            xmlNode.setAttribute(FIELD_PSDELOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestCaseBase.getPSDEName() != null) {
            object = pSSysTestCaseBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestCaseBase.getPSDESADetailId() != null) {
            object = pSSysTestCaseBase.getPSDESADetailId();
            xmlNode.setAttribute(FIELD_PSDESADETAILID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestCaseBase.getPSDESADetailName() != null) {
            object = pSSysTestCaseBase.getPSDESADetailName();
            xmlNode.setAttribute(FIELD_PSDESADETAILNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestCaseBase.getPSDEServiceAPIId() != null) {
            object = pSSysTestCaseBase.getPSDEServiceAPIId();
            xmlNode.setAttribute(FIELD_PSDESERVICEAPIID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestCaseBase.getPSDEServiceAPIName() != null) {
            object = pSSysTestCaseBase.getPSDEServiceAPIName();
            xmlNode.setAttribute(FIELD_PSDESERVICEAPINAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestCaseBase.getPSSysAppId() != null) {
            object = pSSysTestCaseBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestCaseBase.getPSSysReqItemId() != null) {
            object = pSSysTestCaseBase.getPSSysReqItemId();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestCaseBase.getPSSysReqItemName() != null) {
            object = pSSysTestCaseBase.getPSSysReqItemName();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestCaseBase.getPSSysServiceAPIId() != null) {
            object = pSSysTestCaseBase.getPSSysServiceAPIId();
            xmlNode.setAttribute(FIELD_PSSYSSERVICEAPIID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestCaseBase.getPSSysSFPluginId() != null) {
            object = pSSysTestCaseBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestCaseBase.getPSSysSFPluginName() != null) {
            object = pSSysTestCaseBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestCaseBase.getPSSystemId() != null) {
            object = pSSysTestCaseBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestCaseBase.getPSSystemName() != null) {
            object = pSSysTestCaseBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestCaseBase.getPSSysTestCaseId() != null) {
            object = pSSysTestCaseBase.getPSSysTestCaseId();
            xmlNode.setAttribute(FIELD_PSSYSTESTCASEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestCaseBase.getPSSysTestCaseName() != null) {
            object = pSSysTestCaseBase.getPSSysTestCaseName();
            xmlNode.setAttribute(FIELD_PSSYSTESTCASENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestCaseBase.getPSSysTestDataId() != null) {
            object = pSSysTestCaseBase.getPSSysTestDataId();
            xmlNode.setAttribute(FIELD_PSSYSTESTDATAID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestCaseBase.getPSSysTestDataName() != null) {
            object = pSSysTestCaseBase.getPSSysTestDataName();
            xmlNode.setAttribute(FIELD_PSSYSTESTDATANAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestCaseBase.getPSSysTestModuleId() != null) {
            object = pSSysTestCaseBase.getPSSysTestModuleId();
            xmlNode.setAttribute(FIELD_PSSYSTESTMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestCaseBase.getPSSysTestModuleName() != null) {
            object = pSSysTestCaseBase.getPSSysTestModuleName();
            xmlNode.setAttribute(FIELD_PSSYSTESTMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestCaseBase.getPSSysTestPrjId() != null) {
            object = pSSysTestCaseBase.getPSSysTestPrjId();
            xmlNode.setAttribute(FIELD_PSSYSTESTPRJID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestCaseBase.getPSSysTestPrjName() != null) {
            object = pSSysTestCaseBase.getPSSysTestPrjName();
            xmlNode.setAttribute(FIELD_PSSYSTESTPRJNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestCaseBase.getRollbackTran() != null) {
            object = pSSysTestCaseBase.getRollbackTran();
            xmlNode.setAttribute(FIELD_ROLLBACKTRAN, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysTestCaseBase.getTargetType() != null) {
            object = pSSysTestCaseBase.getTargetType();
            xmlNode.setAttribute(FIELD_TARGETTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestCaseBase.getTestCaseLevel() != null) {
            object = pSSysTestCaseBase.getTestCaseLevel();
            xmlNode.setAttribute(FIELD_TESTCASELEVEL, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestCaseBase.getTestCaseSN() != null) {
            object = pSSysTestCaseBase.getTestCaseSN();
            xmlNode.setAttribute(FIELD_TESTCASESN, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestCaseBase.getUpdateDate() != null) {
            object = pSSysTestCaseBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysTestCaseBase.getUpdateMan() != null) {
            object = pSSysTestCaseBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestCaseBase.getUserCat() != null) {
            object = pSSysTestCaseBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestCaseBase.getUserData() != null) {
            object = pSSysTestCaseBase.getUserData();
            xmlNode.setAttribute(FIELD_USERDATA, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestCaseBase.getUserData2() != null) {
            object = pSSysTestCaseBase.getUserData2();
            xmlNode.setAttribute(FIELD_USERDATA2, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestCaseBase.getUserData3() != null) {
            object = pSSysTestCaseBase.getUserData3();
            xmlNode.setAttribute(FIELD_USERDATA3, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestCaseBase.getUserData4() != null) {
            object = pSSysTestCaseBase.getUserData4();
            xmlNode.setAttribute(FIELD_USERDATA4, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestCaseBase.getUserFlag() != null) {
            object = pSSysTestCaseBase.getUserFlag();
            xmlNode.setAttribute(FIELD_USERFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysTestCaseBase.getUserTag() != null) {
            object = pSSysTestCaseBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestCaseBase.getUserTag2() != null) {
            object = pSSysTestCaseBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestCaseBase.getUserTag3() != null) {
            object = pSSysTestCaseBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestCaseBase.getUserTag4() != null) {
            object = pSSysTestCaseBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestCaseBase.getValidFlag() != null) {
            object = pSSysTestCaseBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysTestCaseBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysTestCaseBase pSSysTestCaseBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysTestCaseBase.isActionParamsDirty() && (bl || pSSysTestCaseBase.getActionParams() != null)) {
            iDataObject.set(FIELD_ACTIONPARAMS, (Object)pSSysTestCaseBase.getActionParams());
        }
        if (pSSysTestCaseBase.isAssertResultDirty() && (bl || pSSysTestCaseBase.getAssertResult() != null)) {
            iDataObject.set(FIELD_ASSERTRESULT, (Object)pSSysTestCaseBase.getAssertResult());
        }
        if (pSSysTestCaseBase.isAssertTypeDirty() && (bl || pSSysTestCaseBase.getAssertType() != null)) {
            iDataObject.set(FIELD_ASSERTTYPE, (Object)pSSysTestCaseBase.getAssertType());
        }
        if (pSSysTestCaseBase.isCodeNameDirty() && (bl || pSSysTestCaseBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysTestCaseBase.getCodeName());
        }
        if (pSSysTestCaseBase.isContentDirty() && (bl || pSSysTestCaseBase.getContent() != null)) {
            iDataObject.set(FIELD_CONTENT, (Object)pSSysTestCaseBase.getContent());
        }
        if (pSSysTestCaseBase.isCreateDateDirty() && (bl || pSSysTestCaseBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysTestCaseBase.getCreateDate());
        }
        if (pSSysTestCaseBase.isCreateManDirty() && (bl || pSSysTestCaseBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysTestCaseBase.getCreateMan());
        }
        if (pSSysTestCaseBase.isDEFPSSysSampleValueIdDirty() && (bl || pSSysTestCaseBase.getDEFPSSysSampleValueId() != null)) {
            iDataObject.set(FIELD_DEFPSSYSSAMPLEVALUEID, (Object)pSSysTestCaseBase.getDEFPSSysSampleValueId());
        }
        if (pSSysTestCaseBase.isDEFPSSysSampleValueNameDirty() && (bl || pSSysTestCaseBase.getDEFPSSysSampleValueName() != null)) {
            iDataObject.set(FIELD_DEFPSSYSSAMPLEVALUENAME, (Object)pSSysTestCaseBase.getDEFPSSysSampleValueName());
        }
        if (pSSysTestCaseBase.isDEFValueDirty() && (bl || pSSysTestCaseBase.getDEFValue() != null)) {
            iDataObject.set(FIELD_DEFVALUE, (Object)pSSysTestCaseBase.getDEFValue());
        }
        if (pSSysTestCaseBase.isExceptionDataDirty() && (bl || pSSysTestCaseBase.getExceptionData() != null)) {
            iDataObject.set(FIELD_EXCEPTIONDATA, (Object)pSSysTestCaseBase.getExceptionData());
        }
        if (pSSysTestCaseBase.isExceptionData2Dirty() && (bl || pSSysTestCaseBase.getExceptionData2() != null)) {
            iDataObject.set(FIELD_EXCEPTIONDATA2, (Object)pSSysTestCaseBase.getExceptionData2());
        }
        if (pSSysTestCaseBase.isExceptionNameDirty() && (bl || pSSysTestCaseBase.getExceptionName() != null)) {
            iDataObject.set(FIELD_EXCEPTIONNAME, (Object)pSSysTestCaseBase.getExceptionName());
        }
        if (pSSysTestCaseBase.isInputValuesDirty() && (bl || pSSysTestCaseBase.getInputValues() != null)) {
            iDataObject.set(FIELD_INPUTVALUES, (Object)pSSysTestCaseBase.getInputValues());
        }
        if (pSSysTestCaseBase.isLockFlagDirty() && (bl || pSSysTestCaseBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSSysTestCaseBase.getLockFlag());
        }
        if (pSSysTestCaseBase.isMemoDirty() && (bl || pSSysTestCaseBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysTestCaseBase.getMemo());
        }
        if (pSSysTestCaseBase.isOrderValueDirty() && (bl || pSSysTestCaseBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSysTestCaseBase.getOrderValue());
        }
        if (pSSysTestCaseBase.isPSAppViewIdDirty() && (bl || pSSysTestCaseBase.getPSAppViewId() != null)) {
            iDataObject.set(FIELD_PSAPPVIEWID, (Object)pSSysTestCaseBase.getPSAppViewId());
        }
        if (pSSysTestCaseBase.isPSAppViewNameDirty() && (bl || pSSysTestCaseBase.getPSAppViewName() != null)) {
            iDataObject.set(FIELD_PSAPPVIEWNAME, (Object)pSSysTestCaseBase.getPSAppViewName());
        }
        if (pSSysTestCaseBase.isPSDEActionIdDirty() && (bl || pSSysTestCaseBase.getPSDEActionId() != null)) {
            iDataObject.set(FIELD_PSDEACTIONID, (Object)pSSysTestCaseBase.getPSDEActionId());
        }
        if (pSSysTestCaseBase.isPSDEActionNameDirty() && (bl || pSSysTestCaseBase.getPSDEActionName() != null)) {
            iDataObject.set(FIELD_PSDEACTIONNAME, (Object)pSSysTestCaseBase.getPSDEActionName());
        }
        if (pSSysTestCaseBase.isPSDEFIdDirty() && (bl || pSSysTestCaseBase.getPSDEFId() != null)) {
            iDataObject.set(FIELD_PSDEFID, (Object)pSSysTestCaseBase.getPSDEFId());
        }
        if (pSSysTestCaseBase.isPSDEFNameDirty() && (bl || pSSysTestCaseBase.getPSDEFName() != null)) {
            iDataObject.set(FIELD_PSDEFNAME, (Object)pSSysTestCaseBase.getPSDEFName());
        }
        if (pSSysTestCaseBase.isPSDEIdDirty() && (bl || pSSysTestCaseBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSSysTestCaseBase.getPSDEId());
        }
        if (pSSysTestCaseBase.isPSDELogicIdDirty() && (bl || pSSysTestCaseBase.getPSDELogicId() != null)) {
            iDataObject.set(FIELD_PSDELOGICID, (Object)pSSysTestCaseBase.getPSDELogicId());
        }
        if (pSSysTestCaseBase.isPSDELogicNameDirty() && (bl || pSSysTestCaseBase.getPSDELogicName() != null)) {
            iDataObject.set(FIELD_PSDELOGICNAME, (Object)pSSysTestCaseBase.getPSDELogicName());
        }
        if (pSSysTestCaseBase.isPSDENameDirty() && (bl || pSSysTestCaseBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSSysTestCaseBase.getPSDEName());
        }
        if (pSSysTestCaseBase.isPSDESADetailIdDirty() && (bl || pSSysTestCaseBase.getPSDESADetailId() != null)) {
            iDataObject.set(FIELD_PSDESADETAILID, (Object)pSSysTestCaseBase.getPSDESADetailId());
        }
        if (pSSysTestCaseBase.isPSDESADetailNameDirty() && (bl || pSSysTestCaseBase.getPSDESADetailName() != null)) {
            iDataObject.set(FIELD_PSDESADETAILNAME, (Object)pSSysTestCaseBase.getPSDESADetailName());
        }
        if (pSSysTestCaseBase.isPSDEServiceAPIIdDirty() && (bl || pSSysTestCaseBase.getPSDEServiceAPIId() != null)) {
            iDataObject.set(FIELD_PSDESERVICEAPIID, (Object)pSSysTestCaseBase.getPSDEServiceAPIId());
        }
        if (pSSysTestCaseBase.isPSDEServiceAPINameDirty() && (bl || pSSysTestCaseBase.getPSDEServiceAPIName() != null)) {
            iDataObject.set(FIELD_PSDESERVICEAPINAME, (Object)pSSysTestCaseBase.getPSDEServiceAPIName());
        }
        if (pSSysTestCaseBase.isPSSysAppIdDirty() && (bl || pSSysTestCaseBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSSysTestCaseBase.getPSSysAppId());
        }
        if (pSSysTestCaseBase.isPSSysReqItemIdDirty() && (bl || pSSysTestCaseBase.getPSSysReqItemId() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMID, (Object)pSSysTestCaseBase.getPSSysReqItemId());
        }
        if (pSSysTestCaseBase.isPSSysReqItemNameDirty() && (bl || pSSysTestCaseBase.getPSSysReqItemName() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMNAME, (Object)pSSysTestCaseBase.getPSSysReqItemName());
        }
        if (pSSysTestCaseBase.isPSSysServiceAPIIdDirty() && (bl || pSSysTestCaseBase.getPSSysServiceAPIId() != null)) {
            iDataObject.set(FIELD_PSSYSSERVICEAPIID, (Object)pSSysTestCaseBase.getPSSysServiceAPIId());
        }
        if (pSSysTestCaseBase.isPSSysSFPluginIdDirty() && (bl || pSSysTestCaseBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSSysTestCaseBase.getPSSysSFPluginId());
        }
        if (pSSysTestCaseBase.isPSSysSFPluginNameDirty() && (bl || pSSysTestCaseBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSSysTestCaseBase.getPSSysSFPluginName());
        }
        if (pSSysTestCaseBase.isPSSystemIdDirty() && (bl || pSSysTestCaseBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysTestCaseBase.getPSSystemId());
        }
        if (pSSysTestCaseBase.isPSSystemNameDirty() && (bl || pSSysTestCaseBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysTestCaseBase.getPSSystemName());
        }
        if (pSSysTestCaseBase.isPSSysTestCaseIdDirty() && (bl || pSSysTestCaseBase.getPSSysTestCaseId() != null)) {
            iDataObject.set(FIELD_PSSYSTESTCASEID, (Object)pSSysTestCaseBase.getPSSysTestCaseId());
        }
        if (pSSysTestCaseBase.isPSSysTestCaseNameDirty() && (bl || pSSysTestCaseBase.getPSSysTestCaseName() != null)) {
            iDataObject.set(FIELD_PSSYSTESTCASENAME, (Object)pSSysTestCaseBase.getPSSysTestCaseName());
        }
        if (pSSysTestCaseBase.isPSSysTestDataIdDirty() && (bl || pSSysTestCaseBase.getPSSysTestDataId() != null)) {
            iDataObject.set(FIELD_PSSYSTESTDATAID, (Object)pSSysTestCaseBase.getPSSysTestDataId());
        }
        if (pSSysTestCaseBase.isPSSysTestDataNameDirty() && (bl || pSSysTestCaseBase.getPSSysTestDataName() != null)) {
            iDataObject.set(FIELD_PSSYSTESTDATANAME, (Object)pSSysTestCaseBase.getPSSysTestDataName());
        }
        if (pSSysTestCaseBase.isPSSysTestModuleIdDirty() && (bl || pSSysTestCaseBase.getPSSysTestModuleId() != null)) {
            iDataObject.set(FIELD_PSSYSTESTMODULEID, (Object)pSSysTestCaseBase.getPSSysTestModuleId());
        }
        if (pSSysTestCaseBase.isPSSysTestModuleNameDirty() && (bl || pSSysTestCaseBase.getPSSysTestModuleName() != null)) {
            iDataObject.set(FIELD_PSSYSTESTMODULENAME, (Object)pSSysTestCaseBase.getPSSysTestModuleName());
        }
        if (pSSysTestCaseBase.isPSSysTestPrjIdDirty() && (bl || pSSysTestCaseBase.getPSSysTestPrjId() != null)) {
            iDataObject.set(FIELD_PSSYSTESTPRJID, (Object)pSSysTestCaseBase.getPSSysTestPrjId());
        }
        if (pSSysTestCaseBase.isPSSysTestPrjNameDirty() && (bl || pSSysTestCaseBase.getPSSysTestPrjName() != null)) {
            iDataObject.set(FIELD_PSSYSTESTPRJNAME, (Object)pSSysTestCaseBase.getPSSysTestPrjName());
        }
        if (pSSysTestCaseBase.isRollbackTranDirty() && (bl || pSSysTestCaseBase.getRollbackTran() != null)) {
            iDataObject.set(FIELD_ROLLBACKTRAN, (Object)pSSysTestCaseBase.getRollbackTran());
        }
        if (pSSysTestCaseBase.isTargetTypeDirty() && (bl || pSSysTestCaseBase.getTargetType() != null)) {
            iDataObject.set(FIELD_TARGETTYPE, (Object)pSSysTestCaseBase.getTargetType());
        }
        if (pSSysTestCaseBase.isTestCaseLevelDirty() && (bl || pSSysTestCaseBase.getTestCaseLevel() != null)) {
            iDataObject.set(FIELD_TESTCASELEVEL, (Object)pSSysTestCaseBase.getTestCaseLevel());
        }
        if (pSSysTestCaseBase.isTestCaseSNDirty() && (bl || pSSysTestCaseBase.getTestCaseSN() != null)) {
            iDataObject.set(FIELD_TESTCASESN, (Object)pSSysTestCaseBase.getTestCaseSN());
        }
        if (pSSysTestCaseBase.isUpdateDateDirty() && (bl || pSSysTestCaseBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysTestCaseBase.getUpdateDate());
        }
        if (pSSysTestCaseBase.isUpdateManDirty() && (bl || pSSysTestCaseBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysTestCaseBase.getUpdateMan());
        }
        if (pSSysTestCaseBase.isUserCatDirty() && (bl || pSSysTestCaseBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysTestCaseBase.getUserCat());
        }
        if (pSSysTestCaseBase.isUserDataDirty() && (bl || pSSysTestCaseBase.getUserData() != null)) {
            iDataObject.set(FIELD_USERDATA, (Object)pSSysTestCaseBase.getUserData());
        }
        if (pSSysTestCaseBase.isUserData2Dirty() && (bl || pSSysTestCaseBase.getUserData2() != null)) {
            iDataObject.set(FIELD_USERDATA2, (Object)pSSysTestCaseBase.getUserData2());
        }
        if (pSSysTestCaseBase.isUserData3Dirty() && (bl || pSSysTestCaseBase.getUserData3() != null)) {
            iDataObject.set(FIELD_USERDATA3, (Object)pSSysTestCaseBase.getUserData3());
        }
        if (pSSysTestCaseBase.isUserData4Dirty() && (bl || pSSysTestCaseBase.getUserData4() != null)) {
            iDataObject.set(FIELD_USERDATA4, (Object)pSSysTestCaseBase.getUserData4());
        }
        if (pSSysTestCaseBase.isUserFlagDirty() && (bl || pSSysTestCaseBase.getUserFlag() != null)) {
            iDataObject.set(FIELD_USERFLAG, (Object)pSSysTestCaseBase.getUserFlag());
        }
        if (pSSysTestCaseBase.isUserTagDirty() && (bl || pSSysTestCaseBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysTestCaseBase.getUserTag());
        }
        if (pSSysTestCaseBase.isUserTag2Dirty() && (bl || pSSysTestCaseBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysTestCaseBase.getUserTag2());
        }
        if (pSSysTestCaseBase.isUserTag3Dirty() && (bl || pSSysTestCaseBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysTestCaseBase.getUserTag3());
        }
        if (pSSysTestCaseBase.isUserTag4Dirty() && (bl || pSSysTestCaseBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysTestCaseBase.getUserTag4());
        }
        if (pSSysTestCaseBase.isValidFlagDirty() && (bl || pSSysTestCaseBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysTestCaseBase.getValidFlag());
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
        return PSSysTestCaseBase.remove(this, n);
    }

    private static boolean remove(PSSysTestCaseBase pSSysTestCaseBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysTestCaseBase.resetActionParams();
                return true;
            }
            case 1: {
                pSSysTestCaseBase.resetAssertResult();
                return true;
            }
            case 2: {
                pSSysTestCaseBase.resetAssertType();
                return true;
            }
            case 3: {
                pSSysTestCaseBase.resetCodeName();
                return true;
            }
            case 4: {
                pSSysTestCaseBase.resetContent();
                return true;
            }
            case 5: {
                pSSysTestCaseBase.resetCreateDate();
                return true;
            }
            case 6: {
                pSSysTestCaseBase.resetCreateMan();
                return true;
            }
            case 7: {
                pSSysTestCaseBase.resetDEFPSSysSampleValueId();
                return true;
            }
            case 8: {
                pSSysTestCaseBase.resetDEFPSSysSampleValueName();
                return true;
            }
            case 9: {
                pSSysTestCaseBase.resetDEFValue();
                return true;
            }
            case 10: {
                pSSysTestCaseBase.resetExceptionData();
                return true;
            }
            case 11: {
                pSSysTestCaseBase.resetExceptionData2();
                return true;
            }
            case 12: {
                pSSysTestCaseBase.resetExceptionName();
                return true;
            }
            case 13: {
                pSSysTestCaseBase.resetInputValues();
                return true;
            }
            case 14: {
                pSSysTestCaseBase.resetLockFlag();
                return true;
            }
            case 15: {
                pSSysTestCaseBase.resetMemo();
                return true;
            }
            case 16: {
                pSSysTestCaseBase.resetOrderValue();
                return true;
            }
            case 17: {
                pSSysTestCaseBase.resetPSAppViewId();
                return true;
            }
            case 18: {
                pSSysTestCaseBase.resetPSAppViewName();
                return true;
            }
            case 19: {
                pSSysTestCaseBase.resetPSDEActionId();
                return true;
            }
            case 20: {
                pSSysTestCaseBase.resetPSDEActionName();
                return true;
            }
            case 21: {
                pSSysTestCaseBase.resetPSDEFId();
                return true;
            }
            case 22: {
                pSSysTestCaseBase.resetPSDEFName();
                return true;
            }
            case 23: {
                pSSysTestCaseBase.resetPSDEId();
                return true;
            }
            case 24: {
                pSSysTestCaseBase.resetPSDELogicId();
                return true;
            }
            case 25: {
                pSSysTestCaseBase.resetPSDELogicName();
                return true;
            }
            case 26: {
                pSSysTestCaseBase.resetPSDEName();
                return true;
            }
            case 27: {
                pSSysTestCaseBase.resetPSDESADetailId();
                return true;
            }
            case 28: {
                pSSysTestCaseBase.resetPSDESADetailName();
                return true;
            }
            case 29: {
                pSSysTestCaseBase.resetPSDEServiceAPIId();
                return true;
            }
            case 30: {
                pSSysTestCaseBase.resetPSDEServiceAPIName();
                return true;
            }
            case 31: {
                pSSysTestCaseBase.resetPSSysAppId();
                return true;
            }
            case 32: {
                pSSysTestCaseBase.resetPSSysReqItemId();
                return true;
            }
            case 33: {
                pSSysTestCaseBase.resetPSSysReqItemName();
                return true;
            }
            case 34: {
                pSSysTestCaseBase.resetPSSysServiceAPIId();
                return true;
            }
            case 35: {
                pSSysTestCaseBase.resetPSSysSFPluginId();
                return true;
            }
            case 36: {
                pSSysTestCaseBase.resetPSSysSFPluginName();
                return true;
            }
            case 37: {
                pSSysTestCaseBase.resetPSSystemId();
                return true;
            }
            case 38: {
                pSSysTestCaseBase.resetPSSystemName();
                return true;
            }
            case 39: {
                pSSysTestCaseBase.resetPSSysTestCaseId();
                return true;
            }
            case 40: {
                pSSysTestCaseBase.resetPSSysTestCaseName();
                return true;
            }
            case 41: {
                pSSysTestCaseBase.resetPSSysTestDataId();
                return true;
            }
            case 42: {
                pSSysTestCaseBase.resetPSSysTestDataName();
                return true;
            }
            case 43: {
                pSSysTestCaseBase.resetPSSysTestModuleId();
                return true;
            }
            case 44: {
                pSSysTestCaseBase.resetPSSysTestModuleName();
                return true;
            }
            case 45: {
                pSSysTestCaseBase.resetPSSysTestPrjId();
                return true;
            }
            case 46: {
                pSSysTestCaseBase.resetPSSysTestPrjName();
                return true;
            }
            case 47: {
                pSSysTestCaseBase.resetRollbackTran();
                return true;
            }
            case 48: {
                pSSysTestCaseBase.resetTargetType();
                return true;
            }
            case 49: {
                pSSysTestCaseBase.resetTestCaseLevel();
                return true;
            }
            case 50: {
                pSSysTestCaseBase.resetTestCaseSN();
                return true;
            }
            case 51: {
                pSSysTestCaseBase.resetUpdateDate();
                return true;
            }
            case 52: {
                pSSysTestCaseBase.resetUpdateMan();
                return true;
            }
            case 53: {
                pSSysTestCaseBase.resetUserCat();
                return true;
            }
            case 54: {
                pSSysTestCaseBase.resetUserData();
                return true;
            }
            case 55: {
                pSSysTestCaseBase.resetUserData2();
                return true;
            }
            case 56: {
                pSSysTestCaseBase.resetUserData3();
                return true;
            }
            case 57: {
                pSSysTestCaseBase.resetUserData4();
                return true;
            }
            case 58: {
                pSSysTestCaseBase.resetUserFlag();
                return true;
            }
            case 59: {
                pSSysTestCaseBase.resetUserTag();
                return true;
            }
            case 60: {
                pSSysTestCaseBase.resetUserTag2();
                return true;
            }
            case 61: {
                pSSysTestCaseBase.resetUserTag3();
                return true;
            }
            case 62: {
                pSSysTestCaseBase.resetUserTag4();
                return true;
            }
            case 63: {
                pSSysTestCaseBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSAppView getPSAppView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppView();
        }
        if (this.getPSAppViewId() == null) {
            return null;
        }
        Integer n = this.objPSAppViewLock;
        synchronized (n) {
            if (this.psappview != null && DataTypeHelper.compare((int)25, (Object)this.getPSAppViewId(), (Object)this.psappview.getPSAppViewId()) != 0L) {
                this.psappview = null;
            }
            if (this.psappview == null) {
                PSAppView pSAppView = new PSAppView();
                pSAppView.setPSAppViewId(this.getPSAppViewId());
                PSAppViewService pSAppViewService = (PSAppViewService)ServiceGlobal.getService(PSAppViewService.class, (SessionFactory)this.getSessionFactory());
                pSAppViewService.autoGet((IEntity)pSAppView);
                this.psappview = pSAppView;
            }
            return this.psappview;
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
    public PSDEAction getPSDEAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEAction();
        }
        if (this.getPSDEActionId() == null) {
            return null;
        }
        Integer n = this.objPSDEActionLock;
        synchronized (n) {
            if (this.psdeaction != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEActionId(), (Object)this.psdeaction.getPSDEActionId()) != 0L) {
                this.psdeaction = null;
            }
            if (this.psdeaction == null) {
                PSDEAction pSDEAction = new PSDEAction();
                pSDEAction.setPSDEActionId(this.getPSDEActionId());
                PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEActionService.autoGet((IEntity)pSDEAction);
                this.psdeaction = pSDEAction;
            }
            return this.psdeaction;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEF();
        }
        if (this.getPSDEFId() == null) {
            return null;
        }
        Integer n = this.objPSDEFLock;
        synchronized (n) {
            if (this.psdef != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEFId(), (Object)this.psdef.getPSDEFieldId()) != 0L) {
                this.psdef = null;
            }
            if (this.psdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.psdef = pSDEField;
            }
            return this.psdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDELogic getPSDELogic() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDELogic();
        }
        if (this.getPSDELogicId() == null) {
            return null;
        }
        Integer n = this.objPSDELogicLock;
        synchronized (n) {
            if (this.psdelogic != null && DataTypeHelper.compare((int)25, (Object)this.getPSDELogicId(), (Object)this.psdelogic.getPSDELogicId()) != 0L) {
                this.psdelogic = null;
            }
            if (this.psdelogic == null) {
                PSDELogic pSDELogic = new PSDELogic();
                pSDELogic.setPSDELogicId(this.getPSDELogicId());
                PSDELogicService pSDELogicService = (PSDELogicService)ServiceGlobal.getService(PSDELogicService.class, (SessionFactory)this.getSessionFactory());
                pSDELogicService.autoGet((IEntity)pSDELogic);
                this.psdelogic = pSDELogic;
            }
            return this.psdelogic;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDESADetail getPSDESADetail() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDESADetail();
        }
        if (this.getPSDESADetailId() == null) {
            return null;
        }
        Integer n = this.objPSDESADetailLock;
        synchronized (n) {
            if (this.psdesadetail != null && DataTypeHelper.compare((int)25, (Object)this.getPSDESADetailId(), (Object)this.psdesadetail.getPSDESADetailId()) != 0L) {
                this.psdesadetail = null;
            }
            if (this.psdesadetail == null) {
                PSDESADetail pSDESADetail = new PSDESADetail();
                pSDESADetail.setPSDESADetailId(this.getPSDESADetailId());
                PSDESADetailService pSDESADetailService = (PSDESADetailService)ServiceGlobal.getService(PSDESADetailService.class, (SessionFactory)this.getSessionFactory());
                pSDESADetailService.autoGet((IEntity)pSDESADetail);
                this.psdesadetail = pSDESADetail;
            }
            return this.psdesadetail;
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
                pSDEServiceAPIService.autoGet((IEntity)pSDEServiceAPI);
                this.psdeserviceapi = pSDEServiceAPI;
            }
            return this.psdeserviceapi;
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
    public PSSysSampleValue getDEFPSSysSampleValue() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEFPSSysSampleValue();
        }
        if (this.getDEFPSSysSampleValueId() == null) {
            return null;
        }
        Integer n = this.objDEFPSSysSampleValueLock;
        synchronized (n) {
            if (this.defpssyssamplevalue != null && DataTypeHelper.compare((int)25, (Object)this.getDEFPSSysSampleValueId(), (Object)this.defpssyssamplevalue.getPSSysSampleValueId()) != 0L) {
                this.defpssyssamplevalue = null;
            }
            if (this.defpssyssamplevalue == null) {
                PSSysSampleValue pSSysSampleValue = new PSSysSampleValue();
                pSSysSampleValue.setPSSysSampleValueId(this.getDEFPSSysSampleValueId());
                PSSysSampleValueService pSSysSampleValueService = (PSSysSampleValueService)ServiceGlobal.getService(PSSysSampleValueService.class, (SessionFactory)this.getSessionFactory());
                pSSysSampleValueService.autoGet((IEntity)pSSysSampleValue);
                this.defpssyssamplevalue = pSSysSampleValue;
            }
            return this.defpssyssamplevalue;
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
    public PSSysTestData getPSSysTestData() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTestData();
        }
        if (this.getPSSysTestDataId() == null) {
            return null;
        }
        Integer n = this.objPSSysTestDataLock;
        synchronized (n) {
            if (this.pssystestdata != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysTestDataId(), (Object)this.pssystestdata.getPSSysTestDataId()) != 0L) {
                this.pssystestdata = null;
            }
            if (this.pssystestdata == null) {
                PSSysTestData pSSysTestData = new PSSysTestData();
                pSSysTestData.setPSSysTestDataId(this.getPSSysTestDataId());
                PSSysTestDataService pSSysTestDataService = (PSSysTestDataService)ServiceGlobal.getService(PSSysTestDataService.class, (SessionFactory)this.getSessionFactory());
                pSSysTestDataService.autoGet((IEntity)pSSysTestData);
                this.pssystestdata = pSSysTestData;
            }
            return this.pssystestdata;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysTestModule getPSSysTestModule() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTestModule();
        }
        if (this.getPSSysTestModuleId() == null) {
            return null;
        }
        Integer n = this.objPSSysTestModuleLock;
        synchronized (n) {
            if (this.pssystestmodule != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysTestModuleId(), (Object)this.pssystestmodule.getPSSysTestModuleId()) != 0L) {
                this.pssystestmodule = null;
            }
            if (this.pssystestmodule == null) {
                PSSysTestModule pSSysTestModule = new PSSysTestModule();
                pSSysTestModule.setPSSysTestModuleId(this.getPSSysTestModuleId());
                PSSysTestModuleService pSSysTestModuleService = (PSSysTestModuleService)ServiceGlobal.getService(PSSysTestModuleService.class, (SessionFactory)this.getSessionFactory());
                pSSysTestModuleService.autoGet((IEntity)pSSysTestModule);
                this.pssystestmodule = pSSysTestModule;
            }
            return this.pssystestmodule;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysTestPrj getPSSysTestPrj() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTestPrj();
        }
        if (this.getPSSysTestPrjId() == null) {
            return null;
        }
        Integer n = this.objPSSysTestPrjLock;
        synchronized (n) {
            if (this.pssystestprj != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysTestPrjId(), (Object)this.pssystestprj.getPSSysTestPrjId()) != 0L) {
                this.pssystestprj = null;
            }
            if (this.pssystestprj == null) {
                PSSysTestPrj pSSysTestPrj = new PSSysTestPrj();
                pSSysTestPrj.setPSSysTestPrjId(this.getPSSysTestPrjId());
                PSSysTestPrjService pSSysTestPrjService = (PSSysTestPrjService)ServiceGlobal.getService(PSSysTestPrjService.class, (SessionFactory)this.getSessionFactory());
                pSSysTestPrjService.autoGet((IEntity)pSSysTestPrj);
                this.pssystestprj = pSSysTestPrj;
            }
            return this.pssystestprj;
        }
    }

    private PSSysTestCaseBase getProxyEntity() {
        return this.proxyPSSysTestCaseBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysTestCaseBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysTestCaseBase) {
            this.proxyPSSysTestCaseBase = (PSSysTestCaseBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.systest.service.PSSysTestCaseService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ACTIONPARAMS, 0);
        fieldIndexMap.put(FIELD_ASSERTRESULT, 1);
        fieldIndexMap.put(FIELD_ASSERTTYPE, 2);
        fieldIndexMap.put(FIELD_CODENAME, 3);
        fieldIndexMap.put(FIELD_CONTENT, 4);
        fieldIndexMap.put(FIELD_CREATEDATE, 5);
        fieldIndexMap.put(FIELD_CREATEMAN, 6);
        fieldIndexMap.put(FIELD_DEFPSSYSSAMPLEVALUEID, 7);
        fieldIndexMap.put(FIELD_DEFPSSYSSAMPLEVALUENAME, 8);
        fieldIndexMap.put(FIELD_DEFVALUE, 9);
        fieldIndexMap.put(FIELD_EXCEPTIONDATA, 10);
        fieldIndexMap.put(FIELD_EXCEPTIONDATA2, 11);
        fieldIndexMap.put(FIELD_EXCEPTIONNAME, 12);
        fieldIndexMap.put(FIELD_INPUTVALUES, 13);
        fieldIndexMap.put(FIELD_LOCKFLAG, 14);
        fieldIndexMap.put(FIELD_MEMO, 15);
        fieldIndexMap.put(FIELD_ORDERVALUE, 16);
        fieldIndexMap.put(FIELD_PSAPPVIEWID, 17);
        fieldIndexMap.put(FIELD_PSAPPVIEWNAME, 18);
        fieldIndexMap.put(FIELD_PSDEACTIONID, 19);
        fieldIndexMap.put(FIELD_PSDEACTIONNAME, 20);
        fieldIndexMap.put(FIELD_PSDEFID, 21);
        fieldIndexMap.put(FIELD_PSDEFNAME, 22);
        fieldIndexMap.put(FIELD_PSDEID, 23);
        fieldIndexMap.put(FIELD_PSDELOGICID, 24);
        fieldIndexMap.put(FIELD_PSDELOGICNAME, 25);
        fieldIndexMap.put(FIELD_PSDENAME, 26);
        fieldIndexMap.put(FIELD_PSDESADETAILID, 27);
        fieldIndexMap.put(FIELD_PSDESADETAILNAME, 28);
        fieldIndexMap.put(FIELD_PSDESERVICEAPIID, 29);
        fieldIndexMap.put(FIELD_PSDESERVICEAPINAME, 30);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 31);
        fieldIndexMap.put(FIELD_PSSYSREQITEMID, 32);
        fieldIndexMap.put(FIELD_PSSYSREQITEMNAME, 33);
        fieldIndexMap.put(FIELD_PSSYSSERVICEAPIID, 34);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 35);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 36);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 37);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 38);
        fieldIndexMap.put(FIELD_PSSYSTESTCASEID, 39);
        fieldIndexMap.put(FIELD_PSSYSTESTCASENAME, 40);
        fieldIndexMap.put(FIELD_PSSYSTESTDATAID, 41);
        fieldIndexMap.put(FIELD_PSSYSTESTDATANAME, 42);
        fieldIndexMap.put(FIELD_PSSYSTESTMODULEID, 43);
        fieldIndexMap.put(FIELD_PSSYSTESTMODULENAME, 44);
        fieldIndexMap.put(FIELD_PSSYSTESTPRJID, 45);
        fieldIndexMap.put(FIELD_PSSYSTESTPRJNAME, 46);
        fieldIndexMap.put(FIELD_ROLLBACKTRAN, 47);
        fieldIndexMap.put(FIELD_TARGETTYPE, 48);
        fieldIndexMap.put(FIELD_TESTCASELEVEL, 49);
        fieldIndexMap.put(FIELD_TESTCASESN, 50);
        fieldIndexMap.put(FIELD_UPDATEDATE, 51);
        fieldIndexMap.put(FIELD_UPDATEMAN, 52);
        fieldIndexMap.put(FIELD_USERCAT, 53);
        fieldIndexMap.put(FIELD_USERDATA, 54);
        fieldIndexMap.put(FIELD_USERDATA2, 55);
        fieldIndexMap.put(FIELD_USERDATA3, 56);
        fieldIndexMap.put(FIELD_USERDATA4, 57);
        fieldIndexMap.put(FIELD_USERFLAG, 58);
        fieldIndexMap.put(FIELD_USERTAG, 59);
        fieldIndexMap.put(FIELD_USERTAG2, 60);
        fieldIndexMap.put(FIELD_USERTAG3, 61);
        fieldIndexMap.put(FIELD_USERTAG4, 62);
        fieldIndexMap.put(FIELD_VALIDFLAG, 63);
    }
}

