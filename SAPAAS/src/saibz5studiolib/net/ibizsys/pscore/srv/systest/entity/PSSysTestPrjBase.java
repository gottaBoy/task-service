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
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysServiceAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysServiceAPIService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.ibizsys.pscore.srv.systest.entity.PSSysTestCase;
import net.ibizsys.pscore.srv.systest.entity.PSSysTestModule;
import net.ibizsys.pscore.srv.systest.service.PSSysTestCaseService;
import net.ibizsys.pscore.srv.systest.service.PSSysTestModuleService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysTestPrjBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysTestPrjBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PRJPARAMS = "PRJPARAMS";
    public static final String FIELD_PRJTAG = "PRJTAG";
    public static final String FIELD_PRJTAG2 = "PRJTAG2";
    public static final String FIELD_PRJTYPE = "PRJTYPE";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
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
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_PSSYSTESTPRJID = "PSSYSTESTPRJID";
    public static final String FIELD_PSSYSTESTPRJNAME = "PSSYSTESTPRJNAME";
    public static final String FIELD_TOOLPARAMS = "TOOLPARAMS";
    public static final String FIELD_TOOLTYPE = "TOOLTYPE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERPARAMS = "USERPARAMS";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_DEFAULTFLAG = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PRJPARAMS = 5;
    private static final int INDEX_PRJTAG = 6;
    private static final int INDEX_PRJTAG2 = 7;
    private static final int INDEX_PRJTYPE = 8;
    private static final int INDEX_PSMODULEID = 9;
    private static final int INDEX_PSMODULENAME = 10;
    private static final int INDEX_PSSYSAPPID = 11;
    private static final int INDEX_PSSYSAPPNAME = 12;
    private static final int INDEX_PSSYSDYNAMODELID = 13;
    private static final int INDEX_PSSYSDYNAMODELNAME = 14;
    private static final int INDEX_PSSYSREQITEMID = 15;
    private static final int INDEX_PSSYSREQITEMNAME = 16;
    private static final int INDEX_PSSYSSERVICEAPIID = 17;
    private static final int INDEX_PSSYSSERVICEAPINAME = 18;
    private static final int INDEX_PSSYSSFPLUGINID = 19;
    private static final int INDEX_PSSYSSFPLUGINNAME = 20;
    private static final int INDEX_PSSYSTEMID = 21;
    private static final int INDEX_PSSYSTEMNAME = 22;
    private static final int INDEX_PSSYSTESTPRJID = 23;
    private static final int INDEX_PSSYSTESTPRJNAME = 24;
    private static final int INDEX_TOOLPARAMS = 25;
    private static final int INDEX_TOOLTYPE = 26;
    private static final int INDEX_UPDATEDATE = 27;
    private static final int INDEX_UPDATEMAN = 28;
    private static final int INDEX_USERCAT = 29;
    private static final int INDEX_USERPARAMS = 30;
    private static final int INDEX_USERTAG = 31;
    private static final int INDEX_USERTAG2 = 32;
    private static final int INDEX_USERTAG3 = 33;
    private static final int INDEX_USERTAG4 = 34;
    private static final int INDEX_VALIDFLAG = 35;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysTestPrjBase proxyPSSysTestPrjBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean defaultflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean prjparamsDirtyFlag = false;
    private boolean prjtagDirtyFlag = false;
    private boolean prjtag2DirtyFlag = false;
    private boolean prjtypeDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
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
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean pssystestprjidDirtyFlag = false;
    private boolean pssystestprjnameDirtyFlag = false;
    private boolean toolparamsDirtyFlag = false;
    private boolean tooltypeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean userparamsDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="defaultflag")
    private Integer defaultflag;
    @Column(name="memo")
    private String memo;
    @Column(name="prjparams")
    private String prjparams;
    @Column(name="prjtag")
    private String prjtag;
    @Column(name="prjtag2")
    private String prjtag2;
    @Column(name="prjtype")
    private String prjtype;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
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
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="pssystestprjid")
    private String pssystestprjid;
    @Column(name="pssystestprjname")
    private String pssystestprjname;
    @Column(name="toolparams")
    private String toolparams;
    @Column(name="tooltype")
    private String tooltype;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
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
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
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
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSSysTestCasesLock = new Integer(1);
    private ArrayList<PSSysTestCase> pssystestcases = null;
    private Integer objPSSysTestModulesLock = new Integer(1);
    private ArrayList<PSSysTestModule> pssystestmodules = null;

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

    public void setPrjParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPrjParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.prjparams = string;
        this.prjparamsDirtyFlag = true;
    }

    public String getPrjParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPrjParams();
        }
        return this.prjparams;
    }

    public boolean isPrjParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPrjParamsDirty();
        }
        return this.prjparamsDirtyFlag;
    }

    public void resetPrjParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPrjParams();
            return;
        }
        this.prjparamsDirtyFlag = false;
        this.prjparams = null;
    }

    public void setPrjTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPrjTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.prjtag = string;
        this.prjtagDirtyFlag = true;
    }

    public String getPrjTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPrjTag();
        }
        return this.prjtag;
    }

    public boolean isPrjTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPrjTagDirty();
        }
        return this.prjtagDirtyFlag;
    }

    public void resetPrjTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPrjTag();
            return;
        }
        this.prjtagDirtyFlag = false;
        this.prjtag = null;
    }

    public void setPrjTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPrjTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.prjtag2 = string;
        this.prjtag2DirtyFlag = true;
    }

    public String getPrjTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPrjTag2();
        }
        return this.prjtag2;
    }

    public boolean isPrjTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPrjTag2Dirty();
        }
        return this.prjtag2DirtyFlag;
    }

    public void resetPrjTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPrjTag2();
            return;
        }
        this.prjtag2DirtyFlag = false;
        this.prjtag2 = null;
    }

    public void setPrjType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPrjType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.prjtype = string;
        this.prjtypeDirtyFlag = true;
    }

    public String getPrjType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPrjType();
        }
        return this.prjtype;
    }

    public boolean isPrjTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPrjTypeDirty();
        }
        return this.prjtypeDirtyFlag;
    }

    public void resetPrjType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPrjType();
            return;
        }
        this.prjtypeDirtyFlag = false;
        this.prjtype = null;
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

    public void setToolParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setToolParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.toolparams = string;
        this.toolparamsDirtyFlag = true;
    }

    public String getToolParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getToolParams();
        }
        return this.toolparams;
    }

    public boolean isToolParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isToolParamsDirty();
        }
        return this.toolparamsDirtyFlag;
    }

    public void resetToolParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetToolParams();
            return;
        }
        this.toolparamsDirtyFlag = false;
        this.toolparams = null;
    }

    public void setToolType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setToolType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tooltype = string;
        this.tooltypeDirtyFlag = true;
    }

    public String getToolType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getToolType();
        }
        return this.tooltype;
    }

    public boolean isToolTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isToolTypeDirty();
        }
        return this.tooltypeDirtyFlag;
    }

    public void resetToolType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetToolType();
            return;
        }
        this.tooltypeDirtyFlag = false;
        this.tooltype = null;
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
        PSSysTestPrjBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysTestPrjBase pSSysTestPrjBase) {
        pSSysTestPrjBase.resetCodeName();
        pSSysTestPrjBase.resetCreateDate();
        pSSysTestPrjBase.resetCreateMan();
        pSSysTestPrjBase.resetDefaultFlag();
        pSSysTestPrjBase.resetMemo();
        pSSysTestPrjBase.resetPrjParams();
        pSSysTestPrjBase.resetPrjTag();
        pSSysTestPrjBase.resetPrjTag2();
        pSSysTestPrjBase.resetPrjType();
        pSSysTestPrjBase.resetPSModuleId();
        pSSysTestPrjBase.resetPSModuleName();
        pSSysTestPrjBase.resetPSSysAppId();
        pSSysTestPrjBase.resetPSSysAppName();
        pSSysTestPrjBase.resetPSSysDynaModelId();
        pSSysTestPrjBase.resetPSSysDynaModelName();
        pSSysTestPrjBase.resetPSSysReqItemId();
        pSSysTestPrjBase.resetPSSysReqItemName();
        pSSysTestPrjBase.resetPSSysServiceAPIId();
        pSSysTestPrjBase.resetPSSysServiceAPIName();
        pSSysTestPrjBase.resetPSSysSFPluginId();
        pSSysTestPrjBase.resetPSSysSFPluginName();
        pSSysTestPrjBase.resetPSSystemId();
        pSSysTestPrjBase.resetPSSystemName();
        pSSysTestPrjBase.resetPSSysTestPrjId();
        pSSysTestPrjBase.resetPSSysTestPrjName();
        pSSysTestPrjBase.resetToolParams();
        pSSysTestPrjBase.resetToolType();
        pSSysTestPrjBase.resetUpdateDate();
        pSSysTestPrjBase.resetUpdateMan();
        pSSysTestPrjBase.resetUserCat();
        pSSysTestPrjBase.resetUserParams();
        pSSysTestPrjBase.resetUserTag();
        pSSysTestPrjBase.resetUserTag2();
        pSSysTestPrjBase.resetUserTag3();
        pSSysTestPrjBase.resetUserTag4();
        pSSysTestPrjBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDefaultFlagDirty()) {
            hashMap.put(FIELD_DEFAULTFLAG, this.getDefaultFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPrjParamsDirty()) {
            hashMap.put(FIELD_PRJPARAMS, this.getPrjParams());
        }
        if (!bl || this.isPrjTagDirty()) {
            hashMap.put(FIELD_PRJTAG, this.getPrjTag());
        }
        if (!bl || this.isPrjTag2Dirty()) {
            hashMap.put(FIELD_PRJTAG2, this.getPrjTag2());
        }
        if (!bl || this.isPrjTypeDirty()) {
            hashMap.put(FIELD_PRJTYPE, this.getPrjType());
        }
        if (!bl || this.isPSModuleIdDirty()) {
            hashMap.put(FIELD_PSMODULEID, this.getPSModuleId());
        }
        if (!bl || this.isPSModuleNameDirty()) {
            hashMap.put(FIELD_PSMODULENAME, this.getPSModuleName());
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
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
        }
        if (!bl || this.isPSSysTestPrjIdDirty()) {
            hashMap.put(FIELD_PSSYSTESTPRJID, this.getPSSysTestPrjId());
        }
        if (!bl || this.isPSSysTestPrjNameDirty()) {
            hashMap.put(FIELD_PSSYSTESTPRJNAME, this.getPSSysTestPrjName());
        }
        if (!bl || this.isToolParamsDirty()) {
            hashMap.put(FIELD_TOOLPARAMS, this.getToolParams());
        }
        if (!bl || this.isToolTypeDirty()) {
            hashMap.put(FIELD_TOOLTYPE, this.getToolType());
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
        return PSSysTestPrjBase.get(this, n);
    }

    private static Object get(PSSysTestPrjBase pSSysTestPrjBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysTestPrjBase.getCodeName();
            }
            case 1: {
                return pSSysTestPrjBase.getCreateDate();
            }
            case 2: {
                return pSSysTestPrjBase.getCreateMan();
            }
            case 3: {
                return pSSysTestPrjBase.getDefaultFlag();
            }
            case 4: {
                return pSSysTestPrjBase.getMemo();
            }
            case 5: {
                return pSSysTestPrjBase.getPrjParams();
            }
            case 6: {
                return pSSysTestPrjBase.getPrjTag();
            }
            case 7: {
                return pSSysTestPrjBase.getPrjTag2();
            }
            case 8: {
                return pSSysTestPrjBase.getPrjType();
            }
            case 9: {
                return pSSysTestPrjBase.getPSModuleId();
            }
            case 10: {
                return pSSysTestPrjBase.getPSModuleName();
            }
            case 11: {
                return pSSysTestPrjBase.getPSSysAppId();
            }
            case 12: {
                return pSSysTestPrjBase.getPSSysAppName();
            }
            case 13: {
                return pSSysTestPrjBase.getPSSysDynaModelId();
            }
            case 14: {
                return pSSysTestPrjBase.getPSSysDynaModelName();
            }
            case 15: {
                return pSSysTestPrjBase.getPSSysReqItemId();
            }
            case 16: {
                return pSSysTestPrjBase.getPSSysReqItemName();
            }
            case 17: {
                return pSSysTestPrjBase.getPSSysServiceAPIId();
            }
            case 18: {
                return pSSysTestPrjBase.getPSSysServiceAPIName();
            }
            case 19: {
                return pSSysTestPrjBase.getPSSysSFPluginId();
            }
            case 20: {
                return pSSysTestPrjBase.getPSSysSFPluginName();
            }
            case 21: {
                return pSSysTestPrjBase.getPSSystemId();
            }
            case 22: {
                return pSSysTestPrjBase.getPSSystemName();
            }
            case 23: {
                return pSSysTestPrjBase.getPSSysTestPrjId();
            }
            case 24: {
                return pSSysTestPrjBase.getPSSysTestPrjName();
            }
            case 25: {
                return pSSysTestPrjBase.getToolParams();
            }
            case 26: {
                return pSSysTestPrjBase.getToolType();
            }
            case 27: {
                return pSSysTestPrjBase.getUpdateDate();
            }
            case 28: {
                return pSSysTestPrjBase.getUpdateMan();
            }
            case 29: {
                return pSSysTestPrjBase.getUserCat();
            }
            case 30: {
                return pSSysTestPrjBase.getUserParams();
            }
            case 31: {
                return pSSysTestPrjBase.getUserTag();
            }
            case 32: {
                return pSSysTestPrjBase.getUserTag2();
            }
            case 33: {
                return pSSysTestPrjBase.getUserTag3();
            }
            case 34: {
                return pSSysTestPrjBase.getUserTag4();
            }
            case 35: {
                return pSSysTestPrjBase.getValidFlag();
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
        PSSysTestPrjBase.set(this, n, object);
    }

    private static void set(PSSysTestPrjBase pSSysTestPrjBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysTestPrjBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysTestPrjBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysTestPrjBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysTestPrjBase.setDefaultFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSSysTestPrjBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysTestPrjBase.setPrjParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysTestPrjBase.setPrjTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysTestPrjBase.setPrjTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysTestPrjBase.setPrjType(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysTestPrjBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysTestPrjBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysTestPrjBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysTestPrjBase.setPSSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysTestPrjBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysTestPrjBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysTestPrjBase.setPSSysReqItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysTestPrjBase.setPSSysReqItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysTestPrjBase.setPSSysServiceAPIId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysTestPrjBase.setPSSysServiceAPIName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysTestPrjBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysTestPrjBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysTestPrjBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysTestPrjBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysTestPrjBase.setPSSysTestPrjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysTestPrjBase.setPSSysTestPrjName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysTestPrjBase.setToolParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysTestPrjBase.setToolType(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysTestPrjBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 28: {
                pSSysTestPrjBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSysTestPrjBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSysTestPrjBase.setUserParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSSysTestPrjBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSysTestPrjBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSSysTestPrjBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSSysTestPrjBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSSysTestPrjBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSysTestPrjBase.isNull(this, n);
    }

    private static boolean isNull(PSSysTestPrjBase pSSysTestPrjBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysTestPrjBase.getCodeName() == null;
            }
            case 1: {
                return pSSysTestPrjBase.getCreateDate() == null;
            }
            case 2: {
                return pSSysTestPrjBase.getCreateMan() == null;
            }
            case 3: {
                return pSSysTestPrjBase.getDefaultFlag() == null;
            }
            case 4: {
                return pSSysTestPrjBase.getMemo() == null;
            }
            case 5: {
                return pSSysTestPrjBase.getPrjParams() == null;
            }
            case 6: {
                return pSSysTestPrjBase.getPrjTag() == null;
            }
            case 7: {
                return pSSysTestPrjBase.getPrjTag2() == null;
            }
            case 8: {
                return pSSysTestPrjBase.getPrjType() == null;
            }
            case 9: {
                return pSSysTestPrjBase.getPSModuleId() == null;
            }
            case 10: {
                return pSSysTestPrjBase.getPSModuleName() == null;
            }
            case 11: {
                return pSSysTestPrjBase.getPSSysAppId() == null;
            }
            case 12: {
                return pSSysTestPrjBase.getPSSysAppName() == null;
            }
            case 13: {
                return pSSysTestPrjBase.getPSSysDynaModelId() == null;
            }
            case 14: {
                return pSSysTestPrjBase.getPSSysDynaModelName() == null;
            }
            case 15: {
                return pSSysTestPrjBase.getPSSysReqItemId() == null;
            }
            case 16: {
                return pSSysTestPrjBase.getPSSysReqItemName() == null;
            }
            case 17: {
                return pSSysTestPrjBase.getPSSysServiceAPIId() == null;
            }
            case 18: {
                return pSSysTestPrjBase.getPSSysServiceAPIName() == null;
            }
            case 19: {
                return pSSysTestPrjBase.getPSSysSFPluginId() == null;
            }
            case 20: {
                return pSSysTestPrjBase.getPSSysSFPluginName() == null;
            }
            case 21: {
                return pSSysTestPrjBase.getPSSystemId() == null;
            }
            case 22: {
                return pSSysTestPrjBase.getPSSystemName() == null;
            }
            case 23: {
                return pSSysTestPrjBase.getPSSysTestPrjId() == null;
            }
            case 24: {
                return pSSysTestPrjBase.getPSSysTestPrjName() == null;
            }
            case 25: {
                return pSSysTestPrjBase.getToolParams() == null;
            }
            case 26: {
                return pSSysTestPrjBase.getToolType() == null;
            }
            case 27: {
                return pSSysTestPrjBase.getUpdateDate() == null;
            }
            case 28: {
                return pSSysTestPrjBase.getUpdateMan() == null;
            }
            case 29: {
                return pSSysTestPrjBase.getUserCat() == null;
            }
            case 30: {
                return pSSysTestPrjBase.getUserParams() == null;
            }
            case 31: {
                return pSSysTestPrjBase.getUserTag() == null;
            }
            case 32: {
                return pSSysTestPrjBase.getUserTag2() == null;
            }
            case 33: {
                return pSSysTestPrjBase.getUserTag3() == null;
            }
            case 34: {
                return pSSysTestPrjBase.getUserTag4() == null;
            }
            case 35: {
                return pSSysTestPrjBase.getValidFlag() == null;
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
        return PSSysTestPrjBase.contains(this, n);
    }

    private static boolean contains(PSSysTestPrjBase pSSysTestPrjBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysTestPrjBase.isCodeNameDirty();
            }
            case 1: {
                return pSSysTestPrjBase.isCreateDateDirty();
            }
            case 2: {
                return pSSysTestPrjBase.isCreateManDirty();
            }
            case 3: {
                return pSSysTestPrjBase.isDefaultFlagDirty();
            }
            case 4: {
                return pSSysTestPrjBase.isMemoDirty();
            }
            case 5: {
                return pSSysTestPrjBase.isPrjParamsDirty();
            }
            case 6: {
                return pSSysTestPrjBase.isPrjTagDirty();
            }
            case 7: {
                return pSSysTestPrjBase.isPrjTag2Dirty();
            }
            case 8: {
                return pSSysTestPrjBase.isPrjTypeDirty();
            }
            case 9: {
                return pSSysTestPrjBase.isPSModuleIdDirty();
            }
            case 10: {
                return pSSysTestPrjBase.isPSModuleNameDirty();
            }
            case 11: {
                return pSSysTestPrjBase.isPSSysAppIdDirty();
            }
            case 12: {
                return pSSysTestPrjBase.isPSSysAppNameDirty();
            }
            case 13: {
                return pSSysTestPrjBase.isPSSysDynaModelIdDirty();
            }
            case 14: {
                return pSSysTestPrjBase.isPSSysDynaModelNameDirty();
            }
            case 15: {
                return pSSysTestPrjBase.isPSSysReqItemIdDirty();
            }
            case 16: {
                return pSSysTestPrjBase.isPSSysReqItemNameDirty();
            }
            case 17: {
                return pSSysTestPrjBase.isPSSysServiceAPIIdDirty();
            }
            case 18: {
                return pSSysTestPrjBase.isPSSysServiceAPINameDirty();
            }
            case 19: {
                return pSSysTestPrjBase.isPSSysSFPluginIdDirty();
            }
            case 20: {
                return pSSysTestPrjBase.isPSSysSFPluginNameDirty();
            }
            case 21: {
                return pSSysTestPrjBase.isPSSystemIdDirty();
            }
            case 22: {
                return pSSysTestPrjBase.isPSSystemNameDirty();
            }
            case 23: {
                return pSSysTestPrjBase.isPSSysTestPrjIdDirty();
            }
            case 24: {
                return pSSysTestPrjBase.isPSSysTestPrjNameDirty();
            }
            case 25: {
                return pSSysTestPrjBase.isToolParamsDirty();
            }
            case 26: {
                return pSSysTestPrjBase.isToolTypeDirty();
            }
            case 27: {
                return pSSysTestPrjBase.isUpdateDateDirty();
            }
            case 28: {
                return pSSysTestPrjBase.isUpdateManDirty();
            }
            case 29: {
                return pSSysTestPrjBase.isUserCatDirty();
            }
            case 30: {
                return pSSysTestPrjBase.isUserParamsDirty();
            }
            case 31: {
                return pSSysTestPrjBase.isUserTagDirty();
            }
            case 32: {
                return pSSysTestPrjBase.isUserTag2Dirty();
            }
            case 33: {
                return pSSysTestPrjBase.isUserTag3Dirty();
            }
            case 34: {
                return pSSysTestPrjBase.isUserTag4Dirty();
            }
            case 35: {
                return pSSysTestPrjBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysTestPrjBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysTestPrjBase pSSysTestPrjBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysTestPrjBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysTestPrjBase.getJSONValue((Object)pSSysTestPrjBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysTestPrjBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysTestPrjBase.getJSONValue((Object)pSSysTestPrjBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysTestPrjBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysTestPrjBase.getJSONValue((Object)pSSysTestPrjBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysTestPrjBase.getDefaultFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultflag", (Object)PSSysTestPrjBase.getJSONValue((Object)pSSysTestPrjBase.getDefaultFlag()), (boolean)false);
        }
        if (bl || pSSysTestPrjBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysTestPrjBase.getJSONValue((Object)pSSysTestPrjBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysTestPrjBase.getPrjParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"prjparams", (Object)PSSysTestPrjBase.getJSONValue((Object)pSSysTestPrjBase.getPrjParams()), (boolean)false);
        }
        if (bl || pSSysTestPrjBase.getPrjTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"prjtag", (Object)PSSysTestPrjBase.getJSONValue((Object)pSSysTestPrjBase.getPrjTag()), (boolean)false);
        }
        if (bl || pSSysTestPrjBase.getPrjTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"prjtag2", (Object)PSSysTestPrjBase.getJSONValue((Object)pSSysTestPrjBase.getPrjTag2()), (boolean)false);
        }
        if (bl || pSSysTestPrjBase.getPrjType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"prjtype", (Object)PSSysTestPrjBase.getJSONValue((Object)pSSysTestPrjBase.getPrjType()), (boolean)false);
        }
        if (bl || pSSysTestPrjBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSSysTestPrjBase.getJSONValue((Object)pSSysTestPrjBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSSysTestPrjBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSSysTestPrjBase.getJSONValue((Object)pSSysTestPrjBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSSysTestPrjBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSSysTestPrjBase.getJSONValue((Object)pSSysTestPrjBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSSysTestPrjBase.getPSSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappname", (Object)PSSysTestPrjBase.getJSONValue((Object)pSSysTestPrjBase.getPSSysAppName()), (boolean)false);
        }
        if (bl || pSSysTestPrjBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSSysTestPrjBase.getJSONValue((Object)pSSysTestPrjBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSSysTestPrjBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSSysTestPrjBase.getJSONValue((Object)pSSysTestPrjBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSSysTestPrjBase.getPSSysReqItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemid", (Object)PSSysTestPrjBase.getJSONValue((Object)pSSysTestPrjBase.getPSSysReqItemId()), (boolean)false);
        }
        if (bl || pSSysTestPrjBase.getPSSysReqItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemname", (Object)PSSysTestPrjBase.getJSONValue((Object)pSSysTestPrjBase.getPSSysReqItemName()), (boolean)false);
        }
        if (bl || pSSysTestPrjBase.getPSSysServiceAPIId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysserviceapiid", (Object)PSSysTestPrjBase.getJSONValue((Object)pSSysTestPrjBase.getPSSysServiceAPIId()), (boolean)false);
        }
        if (bl || pSSysTestPrjBase.getPSSysServiceAPIName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysserviceapiname", (Object)PSSysTestPrjBase.getJSONValue((Object)pSSysTestPrjBase.getPSSysServiceAPIName()), (boolean)false);
        }
        if (bl || pSSysTestPrjBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSSysTestPrjBase.getJSONValue((Object)pSSysTestPrjBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSSysTestPrjBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSSysTestPrjBase.getJSONValue((Object)pSSysTestPrjBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSSysTestPrjBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysTestPrjBase.getJSONValue((Object)pSSysTestPrjBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysTestPrjBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysTestPrjBase.getJSONValue((Object)pSSysTestPrjBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysTestPrjBase.getPSSysTestPrjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystestprjid", (Object)PSSysTestPrjBase.getJSONValue((Object)pSSysTestPrjBase.getPSSysTestPrjId()), (boolean)false);
        }
        if (bl || pSSysTestPrjBase.getPSSysTestPrjName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystestprjname", (Object)PSSysTestPrjBase.getJSONValue((Object)pSSysTestPrjBase.getPSSysTestPrjName()), (boolean)false);
        }
        if (bl || pSSysTestPrjBase.getToolParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"toolparams", (Object)PSSysTestPrjBase.getJSONValue((Object)pSSysTestPrjBase.getToolParams()), (boolean)false);
        }
        if (bl || pSSysTestPrjBase.getToolType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tooltype", (Object)PSSysTestPrjBase.getJSONValue((Object)pSSysTestPrjBase.getToolType()), (boolean)false);
        }
        if (bl || pSSysTestPrjBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysTestPrjBase.getJSONValue((Object)pSSysTestPrjBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysTestPrjBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysTestPrjBase.getJSONValue((Object)pSSysTestPrjBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysTestPrjBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysTestPrjBase.getJSONValue((Object)pSSysTestPrjBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysTestPrjBase.getUserParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userparams", (Object)PSSysTestPrjBase.getJSONValue((Object)pSSysTestPrjBase.getUserParams()), (boolean)false);
        }
        if (bl || pSSysTestPrjBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysTestPrjBase.getJSONValue((Object)pSSysTestPrjBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysTestPrjBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysTestPrjBase.getJSONValue((Object)pSSysTestPrjBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysTestPrjBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysTestPrjBase.getJSONValue((Object)pSSysTestPrjBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysTestPrjBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysTestPrjBase.getJSONValue((Object)pSSysTestPrjBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysTestPrjBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysTestPrjBase.getJSONValue((Object)pSSysTestPrjBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysTestPrjBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysTestPrjBase pSSysTestPrjBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysTestPrjBase.getCodeName() != null) {
            object = pSSysTestPrjBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestPrjBase.getCreateDate() != null) {
            object = pSSysTestPrjBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysTestPrjBase.getCreateMan() != null) {
            object = pSSysTestPrjBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestPrjBase.getDefaultFlag() != null) {
            object = pSSysTestPrjBase.getDefaultFlag();
            xmlNode.setAttribute(FIELD_DEFAULTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysTestPrjBase.getMemo() != null) {
            object = pSSysTestPrjBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestPrjBase.getPrjParams() != null) {
            object = pSSysTestPrjBase.getPrjParams();
            xmlNode.setAttribute(FIELD_PRJPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestPrjBase.getPrjTag() != null) {
            object = pSSysTestPrjBase.getPrjTag();
            xmlNode.setAttribute(FIELD_PRJTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestPrjBase.getPrjTag2() != null) {
            object = pSSysTestPrjBase.getPrjTag2();
            xmlNode.setAttribute(FIELD_PRJTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestPrjBase.getPrjType() != null) {
            object = pSSysTestPrjBase.getPrjType();
            xmlNode.setAttribute(FIELD_PRJTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestPrjBase.getPSModuleId() != null) {
            object = pSSysTestPrjBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestPrjBase.getPSModuleName() != null) {
            object = pSSysTestPrjBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestPrjBase.getPSSysAppId() != null) {
            object = pSSysTestPrjBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestPrjBase.getPSSysAppName() != null) {
            object = pSSysTestPrjBase.getPSSysAppName();
            xmlNode.setAttribute(FIELD_PSSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestPrjBase.getPSSysDynaModelId() != null) {
            object = pSSysTestPrjBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestPrjBase.getPSSysDynaModelName() != null) {
            object = pSSysTestPrjBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestPrjBase.getPSSysReqItemId() != null) {
            object = pSSysTestPrjBase.getPSSysReqItemId();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestPrjBase.getPSSysReqItemName() != null) {
            object = pSSysTestPrjBase.getPSSysReqItemName();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestPrjBase.getPSSysServiceAPIId() != null) {
            object = pSSysTestPrjBase.getPSSysServiceAPIId();
            xmlNode.setAttribute(FIELD_PSSYSSERVICEAPIID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestPrjBase.getPSSysServiceAPIName() != null) {
            object = pSSysTestPrjBase.getPSSysServiceAPIName();
            xmlNode.setAttribute(FIELD_PSSYSSERVICEAPINAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestPrjBase.getPSSysSFPluginId() != null) {
            object = pSSysTestPrjBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestPrjBase.getPSSysSFPluginName() != null) {
            object = pSSysTestPrjBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestPrjBase.getPSSystemId() != null) {
            object = pSSysTestPrjBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestPrjBase.getPSSystemName() != null) {
            object = pSSysTestPrjBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestPrjBase.getPSSysTestPrjId() != null) {
            object = pSSysTestPrjBase.getPSSysTestPrjId();
            xmlNode.setAttribute(FIELD_PSSYSTESTPRJID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestPrjBase.getPSSysTestPrjName() != null) {
            object = pSSysTestPrjBase.getPSSysTestPrjName();
            xmlNode.setAttribute(FIELD_PSSYSTESTPRJNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestPrjBase.getToolParams() != null) {
            object = pSSysTestPrjBase.getToolParams();
            xmlNode.setAttribute(FIELD_TOOLPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestPrjBase.getToolType() != null) {
            object = pSSysTestPrjBase.getToolType();
            xmlNode.setAttribute(FIELD_TOOLTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestPrjBase.getUpdateDate() != null) {
            object = pSSysTestPrjBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysTestPrjBase.getUpdateMan() != null) {
            object = pSSysTestPrjBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestPrjBase.getUserCat() != null) {
            object = pSSysTestPrjBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestPrjBase.getUserParams() != null) {
            object = pSSysTestPrjBase.getUserParams();
            xmlNode.setAttribute(FIELD_USERPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestPrjBase.getUserTag() != null) {
            object = pSSysTestPrjBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestPrjBase.getUserTag2() != null) {
            object = pSSysTestPrjBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestPrjBase.getUserTag3() != null) {
            object = pSSysTestPrjBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestPrjBase.getUserTag4() != null) {
            object = pSSysTestPrjBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestPrjBase.getValidFlag() != null) {
            object = pSSysTestPrjBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysTestPrjBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysTestPrjBase pSSysTestPrjBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysTestPrjBase.isCodeNameDirty() && (bl || pSSysTestPrjBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysTestPrjBase.getCodeName());
        }
        if (pSSysTestPrjBase.isCreateDateDirty() && (bl || pSSysTestPrjBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysTestPrjBase.getCreateDate());
        }
        if (pSSysTestPrjBase.isCreateManDirty() && (bl || pSSysTestPrjBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysTestPrjBase.getCreateMan());
        }
        if (pSSysTestPrjBase.isDefaultFlagDirty() && (bl || pSSysTestPrjBase.getDefaultFlag() != null)) {
            iDataObject.set(FIELD_DEFAULTFLAG, (Object)pSSysTestPrjBase.getDefaultFlag());
        }
        if (pSSysTestPrjBase.isMemoDirty() && (bl || pSSysTestPrjBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysTestPrjBase.getMemo());
        }
        if (pSSysTestPrjBase.isPrjParamsDirty() && (bl || pSSysTestPrjBase.getPrjParams() != null)) {
            iDataObject.set(FIELD_PRJPARAMS, (Object)pSSysTestPrjBase.getPrjParams());
        }
        if (pSSysTestPrjBase.isPrjTagDirty() && (bl || pSSysTestPrjBase.getPrjTag() != null)) {
            iDataObject.set(FIELD_PRJTAG, (Object)pSSysTestPrjBase.getPrjTag());
        }
        if (pSSysTestPrjBase.isPrjTag2Dirty() && (bl || pSSysTestPrjBase.getPrjTag2() != null)) {
            iDataObject.set(FIELD_PRJTAG2, (Object)pSSysTestPrjBase.getPrjTag2());
        }
        if (pSSysTestPrjBase.isPrjTypeDirty() && (bl || pSSysTestPrjBase.getPrjType() != null)) {
            iDataObject.set(FIELD_PRJTYPE, (Object)pSSysTestPrjBase.getPrjType());
        }
        if (pSSysTestPrjBase.isPSModuleIdDirty() && (bl || pSSysTestPrjBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSSysTestPrjBase.getPSModuleId());
        }
        if (pSSysTestPrjBase.isPSModuleNameDirty() && (bl || pSSysTestPrjBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSSysTestPrjBase.getPSModuleName());
        }
        if (pSSysTestPrjBase.isPSSysAppIdDirty() && (bl || pSSysTestPrjBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSSysTestPrjBase.getPSSysAppId());
        }
        if (pSSysTestPrjBase.isPSSysAppNameDirty() && (bl || pSSysTestPrjBase.getPSSysAppName() != null)) {
            iDataObject.set(FIELD_PSSYSAPPNAME, (Object)pSSysTestPrjBase.getPSSysAppName());
        }
        if (pSSysTestPrjBase.isPSSysDynaModelIdDirty() && (bl || pSSysTestPrjBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSSysTestPrjBase.getPSSysDynaModelId());
        }
        if (pSSysTestPrjBase.isPSSysDynaModelNameDirty() && (bl || pSSysTestPrjBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSSysTestPrjBase.getPSSysDynaModelName());
        }
        if (pSSysTestPrjBase.isPSSysReqItemIdDirty() && (bl || pSSysTestPrjBase.getPSSysReqItemId() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMID, (Object)pSSysTestPrjBase.getPSSysReqItemId());
        }
        if (pSSysTestPrjBase.isPSSysReqItemNameDirty() && (bl || pSSysTestPrjBase.getPSSysReqItemName() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMNAME, (Object)pSSysTestPrjBase.getPSSysReqItemName());
        }
        if (pSSysTestPrjBase.isPSSysServiceAPIIdDirty() && (bl || pSSysTestPrjBase.getPSSysServiceAPIId() != null)) {
            iDataObject.set(FIELD_PSSYSSERVICEAPIID, (Object)pSSysTestPrjBase.getPSSysServiceAPIId());
        }
        if (pSSysTestPrjBase.isPSSysServiceAPINameDirty() && (bl || pSSysTestPrjBase.getPSSysServiceAPIName() != null)) {
            iDataObject.set(FIELD_PSSYSSERVICEAPINAME, (Object)pSSysTestPrjBase.getPSSysServiceAPIName());
        }
        if (pSSysTestPrjBase.isPSSysSFPluginIdDirty() && (bl || pSSysTestPrjBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSSysTestPrjBase.getPSSysSFPluginId());
        }
        if (pSSysTestPrjBase.isPSSysSFPluginNameDirty() && (bl || pSSysTestPrjBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSSysTestPrjBase.getPSSysSFPluginName());
        }
        if (pSSysTestPrjBase.isPSSystemIdDirty() && (bl || pSSysTestPrjBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysTestPrjBase.getPSSystemId());
        }
        if (pSSysTestPrjBase.isPSSystemNameDirty() && (bl || pSSysTestPrjBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysTestPrjBase.getPSSystemName());
        }
        if (pSSysTestPrjBase.isPSSysTestPrjIdDirty() && (bl || pSSysTestPrjBase.getPSSysTestPrjId() != null)) {
            iDataObject.set(FIELD_PSSYSTESTPRJID, (Object)pSSysTestPrjBase.getPSSysTestPrjId());
        }
        if (pSSysTestPrjBase.isPSSysTestPrjNameDirty() && (bl || pSSysTestPrjBase.getPSSysTestPrjName() != null)) {
            iDataObject.set(FIELD_PSSYSTESTPRJNAME, (Object)pSSysTestPrjBase.getPSSysTestPrjName());
        }
        if (pSSysTestPrjBase.isToolParamsDirty() && (bl || pSSysTestPrjBase.getToolParams() != null)) {
            iDataObject.set(FIELD_TOOLPARAMS, (Object)pSSysTestPrjBase.getToolParams());
        }
        if (pSSysTestPrjBase.isToolTypeDirty() && (bl || pSSysTestPrjBase.getToolType() != null)) {
            iDataObject.set(FIELD_TOOLTYPE, (Object)pSSysTestPrjBase.getToolType());
        }
        if (pSSysTestPrjBase.isUpdateDateDirty() && (bl || pSSysTestPrjBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysTestPrjBase.getUpdateDate());
        }
        if (pSSysTestPrjBase.isUpdateManDirty() && (bl || pSSysTestPrjBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysTestPrjBase.getUpdateMan());
        }
        if (pSSysTestPrjBase.isUserCatDirty() && (bl || pSSysTestPrjBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysTestPrjBase.getUserCat());
        }
        if (pSSysTestPrjBase.isUserParamsDirty() && (bl || pSSysTestPrjBase.getUserParams() != null)) {
            iDataObject.set(FIELD_USERPARAMS, (Object)pSSysTestPrjBase.getUserParams());
        }
        if (pSSysTestPrjBase.isUserTagDirty() && (bl || pSSysTestPrjBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysTestPrjBase.getUserTag());
        }
        if (pSSysTestPrjBase.isUserTag2Dirty() && (bl || pSSysTestPrjBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysTestPrjBase.getUserTag2());
        }
        if (pSSysTestPrjBase.isUserTag3Dirty() && (bl || pSSysTestPrjBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysTestPrjBase.getUserTag3());
        }
        if (pSSysTestPrjBase.isUserTag4Dirty() && (bl || pSSysTestPrjBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysTestPrjBase.getUserTag4());
        }
        if (pSSysTestPrjBase.isValidFlagDirty() && (bl || pSSysTestPrjBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysTestPrjBase.getValidFlag());
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
        return PSSysTestPrjBase.remove(this, n);
    }

    private static boolean remove(PSSysTestPrjBase pSSysTestPrjBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysTestPrjBase.resetCodeName();
                return true;
            }
            case 1: {
                pSSysTestPrjBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSysTestPrjBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSysTestPrjBase.resetDefaultFlag();
                return true;
            }
            case 4: {
                pSSysTestPrjBase.resetMemo();
                return true;
            }
            case 5: {
                pSSysTestPrjBase.resetPrjParams();
                return true;
            }
            case 6: {
                pSSysTestPrjBase.resetPrjTag();
                return true;
            }
            case 7: {
                pSSysTestPrjBase.resetPrjTag2();
                return true;
            }
            case 8: {
                pSSysTestPrjBase.resetPrjType();
                return true;
            }
            case 9: {
                pSSysTestPrjBase.resetPSModuleId();
                return true;
            }
            case 10: {
                pSSysTestPrjBase.resetPSModuleName();
                return true;
            }
            case 11: {
                pSSysTestPrjBase.resetPSSysAppId();
                return true;
            }
            case 12: {
                pSSysTestPrjBase.resetPSSysAppName();
                return true;
            }
            case 13: {
                pSSysTestPrjBase.resetPSSysDynaModelId();
                return true;
            }
            case 14: {
                pSSysTestPrjBase.resetPSSysDynaModelName();
                return true;
            }
            case 15: {
                pSSysTestPrjBase.resetPSSysReqItemId();
                return true;
            }
            case 16: {
                pSSysTestPrjBase.resetPSSysReqItemName();
                return true;
            }
            case 17: {
                pSSysTestPrjBase.resetPSSysServiceAPIId();
                return true;
            }
            case 18: {
                pSSysTestPrjBase.resetPSSysServiceAPIName();
                return true;
            }
            case 19: {
                pSSysTestPrjBase.resetPSSysSFPluginId();
                return true;
            }
            case 20: {
                pSSysTestPrjBase.resetPSSysSFPluginName();
                return true;
            }
            case 21: {
                pSSysTestPrjBase.resetPSSystemId();
                return true;
            }
            case 22: {
                pSSysTestPrjBase.resetPSSystemName();
                return true;
            }
            case 23: {
                pSSysTestPrjBase.resetPSSysTestPrjId();
                return true;
            }
            case 24: {
                pSSysTestPrjBase.resetPSSysTestPrjName();
                return true;
            }
            case 25: {
                pSSysTestPrjBase.resetToolParams();
                return true;
            }
            case 26: {
                pSSysTestPrjBase.resetToolType();
                return true;
            }
            case 27: {
                pSSysTestPrjBase.resetUpdateDate();
                return true;
            }
            case 28: {
                pSSysTestPrjBase.resetUpdateMan();
                return true;
            }
            case 29: {
                pSSysTestPrjBase.resetUserCat();
                return true;
            }
            case 30: {
                pSSysTestPrjBase.resetUserParams();
                return true;
            }
            case 31: {
                pSSysTestPrjBase.resetUserTag();
                return true;
            }
            case 32: {
                pSSysTestPrjBase.resetUserTag2();
                return true;
            }
            case 33: {
                pSSysTestPrjBase.resetUserTag3();
                return true;
            }
            case 34: {
                pSSysTestPrjBase.resetUserTag4();
                return true;
            }
            case 35: {
                pSSysTestPrjBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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
                pSSysAppService.autoGet((IEntity)pSSysApp);
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
                pSSysDynaModelService.autoGet((IEntity)pSSysDynaModel);
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
                pSSysReqItemService.autoGet((IEntity)pSSysReqItem);
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
                pSSysServiceAPIService.autoGet((IEntity)pSSysServiceAPI);
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
    public ArrayList<PSSysTestCase> getPSSysTestCases() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTestCases();
        }
        if (this.getPSSysTestPrjId() == null) {
            return null;
        }
        PSSysTestCaseService pSSysTestCaseService = (PSSysTestCaseService)ServiceGlobal.getService(PSSysTestCaseService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysTestCasesLock;
        synchronized (n) {
            if (this.pssystestcases == null) {
                this.pssystestcases = pSSysTestCaseService.selectByPSSysTestPrj(this);
            }
            return this.pssystestcases;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysTestModule> getPSSysTestModules() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTestModules();
        }
        if (this.getPSSysTestPrjId() == null) {
            return null;
        }
        PSSysTestModuleService pSSysTestModuleService = (PSSysTestModuleService)ServiceGlobal.getService(PSSysTestModuleService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysTestModulesLock;
        synchronized (n) {
            if (this.pssystestmodules == null) {
                this.pssystestmodules = pSSysTestModuleService.selectByPSSysTestPrj(this);
            }
            return this.pssystestmodules;
        }
    }

    private PSSysTestPrjBase getProxyEntity() {
        return this.proxyPSSysTestPrjBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysTestPrjBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysTestPrjBase) {
            this.proxyPSSysTestPrjBase = (PSSysTestPrjBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.systest.service.PSSysTestPrjService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_DEFAULTFLAG, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PRJPARAMS, 5);
        fieldIndexMap.put(FIELD_PRJTAG, 6);
        fieldIndexMap.put(FIELD_PRJTAG2, 7);
        fieldIndexMap.put(FIELD_PRJTYPE, 8);
        fieldIndexMap.put(FIELD_PSMODULEID, 9);
        fieldIndexMap.put(FIELD_PSMODULENAME, 10);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 11);
        fieldIndexMap.put(FIELD_PSSYSAPPNAME, 12);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 13);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 14);
        fieldIndexMap.put(FIELD_PSSYSREQITEMID, 15);
        fieldIndexMap.put(FIELD_PSSYSREQITEMNAME, 16);
        fieldIndexMap.put(FIELD_PSSYSSERVICEAPIID, 17);
        fieldIndexMap.put(FIELD_PSSYSSERVICEAPINAME, 18);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 19);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 20);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 21);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 22);
        fieldIndexMap.put(FIELD_PSSYSTESTPRJID, 23);
        fieldIndexMap.put(FIELD_PSSYSTESTPRJNAME, 24);
        fieldIndexMap.put(FIELD_TOOLPARAMS, 25);
        fieldIndexMap.put(FIELD_TOOLTYPE, 26);
        fieldIndexMap.put(FIELD_UPDATEDATE, 27);
        fieldIndexMap.put(FIELD_UPDATEMAN, 28);
        fieldIndexMap.put(FIELD_USERCAT, 29);
        fieldIndexMap.put(FIELD_USERPARAMS, 30);
        fieldIndexMap.put(FIELD_USERTAG, 31);
        fieldIndexMap.put(FIELD_USERTAG2, 32);
        fieldIndexMap.put(FIELD_USERTAG3, 33);
        fieldIndexMap.put(FIELD_USERTAG4, 34);
        fieldIndexMap.put(FIELD_VALIDFLAG, 35);
    }
}

