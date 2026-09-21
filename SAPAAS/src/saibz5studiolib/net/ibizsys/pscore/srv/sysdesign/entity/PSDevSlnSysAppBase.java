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
import net.ibizsys.pscore.srv.config.entity.PSAppType;
import net.ibizsys.pscore.srv.config.entity.PSPF;
import net.ibizsys.pscore.srv.config.entity.PSPFStyle;
import net.ibizsys.pscore.srv.config.service.PSAppTypeService;
import net.ibizsys.pscore.srv.config.service.PSPFService;
import net.ibizsys.pscore.srv.config.service.PSPFStyleService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDepApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDepFuncItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnPipelineStep;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnTempl;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepFuncItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineStepService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnTemplService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSStudioTheme;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSStudioThemeService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnSysAppBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevSlnSysAppBase.class);
    public static final String FIELD_APPMDURL = "APPMDURL";
    public static final String FIELD_APPMODE = "APPMODE";
    public static final String FIELD_APPPKGNAME = "APPPKGNAME";
    public static final String FIELD_APPSN = "APPSN";
    public static final String FIELD_APPTAG = "APPTAG";
    public static final String FIELD_APPTAG2 = "APPTAG2";
    public static final String FIELD_APPTAG3 = "APPTAG3";
    public static final String FIELD_APPTAG4 = "APPTAG4";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEVSYSSTATE = "DEVSYSSTATE";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSAPPTYPEID = "PSAPPTYPEID";
    public static final String FIELD_PSAPPTYPENAME = "PSAPPTYPENAME";
    public static final String FIELD_PSDEVSLNID = "PSDEVSLNID";
    public static final String FIELD_PSDEVSLNSYSAPPID = "PSDEVSLNSYSAPPID";
    public static final String FIELD_PSDEVSLNSYSAPPNAME = "PSDEVSLNSYSAPPNAME";
    public static final String FIELD_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String FIELD_PSDEVSLNSYSNAME = "PSDEVSLNSYSNAME";
    public static final String FIELD_PSPFID = "PSPFID";
    public static final String FIELD_PSPFNAME = "PSPFNAME";
    public static final String FIELD_PSPFSTYLEID = "PSPFSTYLEID";
    public static final String FIELD_PSPFSTYLENAME = "PSPFSTYLENAME";
    public static final String FIELD_PSSTUDIOTHEMEID = "PSSTUDIOTHEMEID";
    public static final String FIELD_PSSTUDIOTHEMENAME = "PSSTUDIOTHEMENAME";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String FIELD_THEMECSSSTYLE = "THEMECSSSTYLE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_APPMDURL = 0;
    private static final int INDEX_APPMODE = 1;
    private static final int INDEX_APPPKGNAME = 2;
    private static final int INDEX_APPSN = 3;
    private static final int INDEX_APPTAG = 4;
    private static final int INDEX_APPTAG2 = 5;
    private static final int INDEX_APPTAG3 = 6;
    private static final int INDEX_APPTAG4 = 7;
    private static final int INDEX_CREATEDATE = 8;
    private static final int INDEX_CREATEMAN = 9;
    private static final int INDEX_DEVSYSSTATE = 10;
    private static final int INDEX_LOGICNAME = 11;
    private static final int INDEX_MEMO = 12;
    private static final int INDEX_PSAPPTYPEID = 13;
    private static final int INDEX_PSAPPTYPENAME = 14;
    private static final int INDEX_PSDEVSLNID = 15;
    private static final int INDEX_PSDEVSLNSYSAPPID = 16;
    private static final int INDEX_PSDEVSLNSYSAPPNAME = 17;
    private static final int INDEX_PSDEVSLNSYSID = 18;
    private static final int INDEX_PSDEVSLNSYSNAME = 19;
    private static final int INDEX_PSPFID = 20;
    private static final int INDEX_PSPFNAME = 21;
    private static final int INDEX_PSPFSTYLEID = 22;
    private static final int INDEX_PSPFSTYLENAME = 23;
    private static final int INDEX_PSSTUDIOTHEMEID = 24;
    private static final int INDEX_PSSTUDIOTHEMENAME = 25;
    private static final int INDEX_PSSYSAPPID = 26;
    private static final int INDEX_PSSYSAPPNAME = 27;
    private static final int INDEX_THEMECSSSTYLE = 28;
    private static final int INDEX_UPDATEDATE = 29;
    private static final int INDEX_UPDATEMAN = 30;
    private static final int INDEX_VALIDFLAG = 31;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevSlnSysAppBase proxyPSDevSlnSysAppBase = null;
    private boolean appmdurlDirtyFlag = false;
    private boolean appmodeDirtyFlag = false;
    private boolean apppkgnameDirtyFlag = false;
    private boolean appsnDirtyFlag = false;
    private boolean apptagDirtyFlag = false;
    private boolean apptag2DirtyFlag = false;
    private boolean apptag3DirtyFlag = false;
    private boolean apptag4DirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean devsysstateDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psapptypeidDirtyFlag = false;
    private boolean psapptypenameDirtyFlag = false;
    private boolean psdevslnidDirtyFlag = false;
    private boolean psdevslnsysappidDirtyFlag = false;
    private boolean psdevslnsysappnameDirtyFlag = false;
    private boolean psdevslnsysidDirtyFlag = false;
    private boolean psdevslnsysnameDirtyFlag = false;
    private boolean pspfidDirtyFlag = false;
    private boolean pspfnameDirtyFlag = false;
    private boolean pspfstyleidDirtyFlag = false;
    private boolean pspfstylenameDirtyFlag = false;
    private boolean psstudiothemeidDirtyFlag = false;
    private boolean psstudiothemenameDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean pssysappnameDirtyFlag = false;
    private boolean themecssstyleDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="appmdurl")
    private String appmdurl;
    @Column(name="appmode")
    private String appmode;
    @Column(name="apppkgname")
    private String apppkgname;
    @Column(name="appsn")
    private String appsn;
    @Column(name="apptag")
    private String apptag;
    @Column(name="apptag2")
    private String apptag2;
    @Column(name="apptag3")
    private String apptag3;
    @Column(name="apptag4")
    private String apptag4;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="devsysstate")
    private Integer devsysstate;
    @Column(name="logicname")
    private String logicname;
    @Column(name="memo")
    private String memo;
    @Column(name="psapptypeid")
    private String psapptypeid;
    @Column(name="psapptypename")
    private String psapptypename;
    @Column(name="psdevslnid")
    private String psdevslnid;
    @Column(name="psdevslnsysappid")
    private String psdevslnsysappid;
    @Column(name="psdevslnsysappname")
    private String psdevslnsysappname;
    @Column(name="psdevslnsysid")
    private String psdevslnsysid;
    @Column(name="psdevslnsysname")
    private String psdevslnsysname;
    @Column(name="pspfid")
    private String pspfid;
    @Column(name="pspfname")
    private String pspfname;
    @Column(name="pspfstyleid")
    private String pspfstyleid;
    @Column(name="pspfstylename")
    private String pspfstylename;
    @Column(name="psstudiothemeid")
    private String psstudiothemeid;
    @Column(name="psstudiothemename")
    private String psstudiothemename;
    @Column(name="pssysappid")
    private String pssysappid;
    @Column(name="pssysappname")
    private String pssysappname;
    @Column(name="themecssstyle")
    private String themecssstyle;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSAppTypeLock = new Integer(1);
    private PSAppType psapptype = null;
    private Integer objPSDevSlnSysLock = new Integer(1);
    private PSDevSlnSys psdevslnsys = null;
    private Integer objPSPFStyleLock = new Integer(1);
    private PSPFStyle pspfstyle = null;
    private Integer objPSPFLock = new Integer(1);
    private PSPF pspf = null;
    private Integer objPSStudioThemeLock = new Integer(1);
    private PSStudioTheme psstudiotheme = null;
    private Integer objPSSysAppLock = new Integer(1);
    private PSSysApp pssysapp = null;
    private Integer objPSDevSlnMSDepAppsLock = new Integer(1);
    private ArrayList<PSDevSlnMSDepApp> psdevslnmsdepapps = null;
    private Integer objPSDevSlnMSDepFuncItemsLock = new Integer(1);
    private ArrayList<PSDevSlnMSDepFuncItem> psdevslnmsdepfuncitems = null;
    private Integer objPSDevSlnPipelineStepsLock = new Integer(1);
    private ArrayList<PSDevSlnPipelineStep> psdevslnpipelinesteps = null;
    private Integer objPSDevSlnTemplsLock = new Integer(1);
    private ArrayList<PSDevSlnTempl> psdevslntempls = null;

    public void setAppMDUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAppMDUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.appmdurl = string;
        this.appmdurlDirtyFlag = true;
    }

    public String getAppMDUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAppMDUrl();
        }
        return this.appmdurl;
    }

    public boolean isAppMDUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAppMDUrlDirty();
        }
        return this.appmdurlDirtyFlag;
    }

    public void resetAppMDUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAppMDUrl();
            return;
        }
        this.appmdurlDirtyFlag = false;
        this.appmdurl = null;
    }

    public void setAppMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAppMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.appmode = string;
        this.appmodeDirtyFlag = true;
    }

    public String getAppMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAppMode();
        }
        return this.appmode;
    }

    public boolean isAppModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAppModeDirty();
        }
        return this.appmodeDirtyFlag;
    }

    public void resetAppMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAppMode();
            return;
        }
        this.appmodeDirtyFlag = false;
        this.appmode = null;
    }

    public void setAppPKGName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAppPKGName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.apppkgname = string;
        this.apppkgnameDirtyFlag = true;
    }

    public String getAppPKGName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAppPKGName();
        }
        return this.apppkgname;
    }

    public boolean isAppPKGNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAppPKGNameDirty();
        }
        return this.apppkgnameDirtyFlag;
    }

    public void resetAppPKGName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAppPKGName();
            return;
        }
        this.apppkgnameDirtyFlag = false;
        this.apppkgname = null;
    }

    public void setAppSN(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAppSN(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.appsn = string;
        this.appsnDirtyFlag = true;
    }

    public String getAppSN() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAppSN();
        }
        return this.appsn;
    }

    public boolean isAppSNDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAppSNDirty();
        }
        return this.appsnDirtyFlag;
    }

    public void resetAppSN() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAppSN();
            return;
        }
        this.appsnDirtyFlag = false;
        this.appsn = null;
    }

    public void setAppTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAppTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.apptag = string;
        this.apptagDirtyFlag = true;
    }

    public String getAppTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAppTag();
        }
        return this.apptag;
    }

    public boolean isAppTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAppTagDirty();
        }
        return this.apptagDirtyFlag;
    }

    public void resetAppTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAppTag();
            return;
        }
        this.apptagDirtyFlag = false;
        this.apptag = null;
    }

    public void setAppTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAppTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.apptag2 = string;
        this.apptag2DirtyFlag = true;
    }

    public String getAppTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAppTag2();
        }
        return this.apptag2;
    }

    public boolean isAppTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAppTag2Dirty();
        }
        return this.apptag2DirtyFlag;
    }

    public void resetAppTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAppTag2();
            return;
        }
        this.apptag2DirtyFlag = false;
        this.apptag2 = null;
    }

    public void setAppTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAppTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.apptag3 = string;
        this.apptag3DirtyFlag = true;
    }

    public String getAppTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAppTag3();
        }
        return this.apptag3;
    }

    public boolean isAppTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAppTag3Dirty();
        }
        return this.apptag3DirtyFlag;
    }

    public void resetAppTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAppTag3();
            return;
        }
        this.apptag3DirtyFlag = false;
        this.apptag3 = null;
    }

    public void setAppTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAppTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.apptag4 = string;
        this.apptag4DirtyFlag = true;
    }

    public String getAppTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAppTag4();
        }
        return this.apptag4;
    }

    public boolean isAppTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAppTag4Dirty();
        }
        return this.apptag4DirtyFlag;
    }

    public void resetAppTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAppTag4();
            return;
        }
        this.apptag4DirtyFlag = false;
        this.apptag4 = null;
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

    public void setDevSysState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDevSysState(n);
            return;
        }
        this.devsysstate = n;
        this.devsysstateDirtyFlag = true;
    }

    public Integer getDevSysState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDevSysState();
        }
        return this.devsysstate;
    }

    public boolean isDevSysStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDevSysStateDirty();
        }
        return this.devsysstateDirtyFlag;
    }

    public void resetDevSysState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDevSysState();
            return;
        }
        this.devsysstateDirtyFlag = false;
        this.devsysstate = null;
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

    public void setPSAppTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psapptypeid = string;
        this.psapptypeidDirtyFlag = true;
    }

    public String getPSAppTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppTypeId();
        }
        return this.psapptypeid;
    }

    public boolean isPSAppTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppTypeIdDirty();
        }
        return this.psapptypeidDirtyFlag;
    }

    public void resetPSAppTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppTypeId();
            return;
        }
        this.psapptypeidDirtyFlag = false;
        this.psapptypeid = null;
    }

    public void setPSAppTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psapptypename = string;
        this.psapptypenameDirtyFlag = true;
    }

    public String getPSAppTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppTypeName();
        }
        return this.psapptypename;
    }

    public boolean isPSAppTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppTypeNameDirty();
        }
        return this.psapptypenameDirtyFlag;
    }

    public void resetPSAppTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppTypeName();
            return;
        }
        this.psapptypenameDirtyFlag = false;
        this.psapptypename = null;
    }

    public void setPSDevSlnId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnid = string;
        this.psdevslnidDirtyFlag = true;
    }

    public String getPSDevSlnId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnId();
        }
        return this.psdevslnid;
    }

    public boolean isPSDevSlnIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnIdDirty();
        }
        return this.psdevslnidDirtyFlag;
    }

    public void resetPSDevSlnId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnId();
            return;
        }
        this.psdevslnidDirtyFlag = false;
        this.psdevslnid = null;
    }

    public void setPSDevSlnSysAppId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysAppId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysappid = string;
        this.psdevslnsysappidDirtyFlag = true;
    }

    public String getPSDevSlnSysAppId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysAppId();
        }
        return this.psdevslnsysappid;
    }

    public boolean isPSDevSlnSysAppIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysAppIdDirty();
        }
        return this.psdevslnsysappidDirtyFlag;
    }

    public void resetPSDevSlnSysAppId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysAppId();
            return;
        }
        this.psdevslnsysappidDirtyFlag = false;
        this.psdevslnsysappid = null;
    }

    public void setPSDevSlnSysAppName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysAppName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysappname = string;
        this.psdevslnsysappnameDirtyFlag = true;
    }

    public String getPSDevSlnSysAppName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysAppName();
        }
        return this.psdevslnsysappname;
    }

    public boolean isPSDevSlnSysAppNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysAppNameDirty();
        }
        return this.psdevslnsysappnameDirtyFlag;
    }

    public void resetPSDevSlnSysAppName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysAppName();
            return;
        }
        this.psdevslnsysappnameDirtyFlag = false;
        this.psdevslnsysappname = null;
    }

    public void setPSDevSlnSysId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysid = string;
        this.psdevslnsysidDirtyFlag = true;
    }

    public String getPSDevSlnSysId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysId();
        }
        return this.psdevslnsysid;
    }

    public boolean isPSDevSlnSysIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysIdDirty();
        }
        return this.psdevslnsysidDirtyFlag;
    }

    public void resetPSDevSlnSysId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysId();
            return;
        }
        this.psdevslnsysidDirtyFlag = false;
        this.psdevslnsysid = null;
    }

    public void setPSDevSlnSysName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysname = string;
        this.psdevslnsysnameDirtyFlag = true;
    }

    public String getPSDevSlnSysName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysName();
        }
        return this.psdevslnsysname;
    }

    public boolean isPSDevSlnSysNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysNameDirty();
        }
        return this.psdevslnsysnameDirtyFlag;
    }

    public void resetPSDevSlnSysName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysName();
            return;
        }
        this.psdevslnsysnameDirtyFlag = false;
        this.psdevslnsysname = null;
    }

    public void setPSPFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfid = string;
        this.pspfidDirtyFlag = true;
    }

    public String getPSPFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFId();
        }
        return this.pspfid;
    }

    public boolean isPSPFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFIdDirty();
        }
        return this.pspfidDirtyFlag;
    }

    public void resetPSPFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFId();
            return;
        }
        this.pspfidDirtyFlag = false;
        this.pspfid = null;
    }

    public void setPSPFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfname = string;
        this.pspfnameDirtyFlag = true;
    }

    public String getPSPFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFName();
        }
        return this.pspfname;
    }

    public boolean isPSPFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFNameDirty();
        }
        return this.pspfnameDirtyFlag;
    }

    public void resetPSPFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFName();
            return;
        }
        this.pspfnameDirtyFlag = false;
        this.pspfname = null;
    }

    public void setPSPFStyleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFStyleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfstyleid = string;
        this.pspfstyleidDirtyFlag = true;
    }

    public String getPSPFStyleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFStyleId();
        }
        return this.pspfstyleid;
    }

    public boolean isPSPFStyleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFStyleIdDirty();
        }
        return this.pspfstyleidDirtyFlag;
    }

    public void resetPSPFStyleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFStyleId();
            return;
        }
        this.pspfstyleidDirtyFlag = false;
        this.pspfstyleid = null;
    }

    public void setPSPFStyleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFStyleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfstylename = string;
        this.pspfstylenameDirtyFlag = true;
    }

    public String getPSPFStyleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFStyleName();
        }
        return this.pspfstylename;
    }

    public boolean isPSPFStyleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFStyleNameDirty();
        }
        return this.pspfstylenameDirtyFlag;
    }

    public void resetPSPFStyleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFStyleName();
            return;
        }
        this.pspfstylenameDirtyFlag = false;
        this.pspfstylename = null;
    }

    public void setPSStudioThemeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSStudioThemeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psstudiothemeid = string;
        this.psstudiothemeidDirtyFlag = true;
    }

    public String getPSStudioThemeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSStudioThemeId();
        }
        return this.psstudiothemeid;
    }

    public boolean isPSStudioThemeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSStudioThemeIdDirty();
        }
        return this.psstudiothemeidDirtyFlag;
    }

    public void resetPSStudioThemeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSStudioThemeId();
            return;
        }
        this.psstudiothemeidDirtyFlag = false;
        this.psstudiothemeid = null;
    }

    public void setPSStudioThemeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSStudioThemeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psstudiothemename = string;
        this.psstudiothemenameDirtyFlag = true;
    }

    public String getPSStudioThemeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSStudioThemeName();
        }
        return this.psstudiothemename;
    }

    public boolean isPSStudioThemeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSStudioThemeNameDirty();
        }
        return this.psstudiothemenameDirtyFlag;
    }

    public void resetPSStudioThemeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSStudioThemeName();
            return;
        }
        this.psstudiothemenameDirtyFlag = false;
        this.psstudiothemename = null;
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

    public void setThemeCssStyle(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setThemeCssStyle(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.themecssstyle = string;
        this.themecssstyleDirtyFlag = true;
    }

    public String getThemeCssStyle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getThemeCssStyle();
        }
        return this.themecssstyle;
    }

    public boolean isThemeCssStyleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isThemeCssStyleDirty();
        }
        return this.themecssstyleDirtyFlag;
    }

    public void resetThemeCssStyle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetThemeCssStyle();
            return;
        }
        this.themecssstyleDirtyFlag = false;
        this.themecssstyle = null;
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
        PSDevSlnSysAppBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevSlnSysAppBase pSDevSlnSysAppBase) {
        pSDevSlnSysAppBase.resetAppMDUrl();
        pSDevSlnSysAppBase.resetAppMode();
        pSDevSlnSysAppBase.resetAppPKGName();
        pSDevSlnSysAppBase.resetAppSN();
        pSDevSlnSysAppBase.resetAppTag();
        pSDevSlnSysAppBase.resetAppTag2();
        pSDevSlnSysAppBase.resetAppTag3();
        pSDevSlnSysAppBase.resetAppTag4();
        pSDevSlnSysAppBase.resetCreateDate();
        pSDevSlnSysAppBase.resetCreateMan();
        pSDevSlnSysAppBase.resetDevSysState();
        pSDevSlnSysAppBase.resetLogicName();
        pSDevSlnSysAppBase.resetMemo();
        pSDevSlnSysAppBase.resetPSAppTypeId();
        pSDevSlnSysAppBase.resetPSAppTypeName();
        pSDevSlnSysAppBase.resetPSDevSlnId();
        pSDevSlnSysAppBase.resetPSDevSlnSysAppId();
        pSDevSlnSysAppBase.resetPSDevSlnSysAppName();
        pSDevSlnSysAppBase.resetPSDevSlnSysId();
        pSDevSlnSysAppBase.resetPSDevSlnSysName();
        pSDevSlnSysAppBase.resetPSPFId();
        pSDevSlnSysAppBase.resetPSPFName();
        pSDevSlnSysAppBase.resetPSPFStyleId();
        pSDevSlnSysAppBase.resetPSPFStyleName();
        pSDevSlnSysAppBase.resetPSStudioThemeId();
        pSDevSlnSysAppBase.resetPSStudioThemeName();
        pSDevSlnSysAppBase.resetPSSysAppId();
        pSDevSlnSysAppBase.resetPSSysAppName();
        pSDevSlnSysAppBase.resetThemeCssStyle();
        pSDevSlnSysAppBase.resetUpdateDate();
        pSDevSlnSysAppBase.resetUpdateMan();
        pSDevSlnSysAppBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAppMDUrlDirty()) {
            hashMap.put(FIELD_APPMDURL, this.getAppMDUrl());
        }
        if (!bl || this.isAppModeDirty()) {
            hashMap.put(FIELD_APPMODE, this.getAppMode());
        }
        if (!bl || this.isAppPKGNameDirty()) {
            hashMap.put(FIELD_APPPKGNAME, this.getAppPKGName());
        }
        if (!bl || this.isAppSNDirty()) {
            hashMap.put(FIELD_APPSN, this.getAppSN());
        }
        if (!bl || this.isAppTagDirty()) {
            hashMap.put(FIELD_APPTAG, this.getAppTag());
        }
        if (!bl || this.isAppTag2Dirty()) {
            hashMap.put(FIELD_APPTAG2, this.getAppTag2());
        }
        if (!bl || this.isAppTag3Dirty()) {
            hashMap.put(FIELD_APPTAG3, this.getAppTag3());
        }
        if (!bl || this.isAppTag4Dirty()) {
            hashMap.put(FIELD_APPTAG4, this.getAppTag4());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDevSysStateDirty()) {
            hashMap.put(FIELD_DEVSYSSTATE, this.getDevSysState());
        }
        if (!bl || this.isLogicNameDirty()) {
            hashMap.put(FIELD_LOGICNAME, this.getLogicName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSAppTypeIdDirty()) {
            hashMap.put(FIELD_PSAPPTYPEID, this.getPSAppTypeId());
        }
        if (!bl || this.isPSAppTypeNameDirty()) {
            hashMap.put(FIELD_PSAPPTYPENAME, this.getPSAppTypeName());
        }
        if (!bl || this.isPSDevSlnIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNID, this.getPSDevSlnId());
        }
        if (!bl || this.isPSDevSlnSysAppIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSAPPID, this.getPSDevSlnSysAppId());
        }
        if (!bl || this.isPSDevSlnSysAppNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSAPPNAME, this.getPSDevSlnSysAppName());
        }
        if (!bl || this.isPSDevSlnSysIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSID, this.getPSDevSlnSysId());
        }
        if (!bl || this.isPSDevSlnSysNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSNAME, this.getPSDevSlnSysName());
        }
        if (!bl || this.isPSPFIdDirty()) {
            hashMap.put(FIELD_PSPFID, this.getPSPFId());
        }
        if (!bl || this.isPSPFNameDirty()) {
            hashMap.put(FIELD_PSPFNAME, this.getPSPFName());
        }
        if (!bl || this.isPSPFStyleIdDirty()) {
            hashMap.put(FIELD_PSPFSTYLEID, this.getPSPFStyleId());
        }
        if (!bl || this.isPSPFStyleNameDirty()) {
            hashMap.put(FIELD_PSPFSTYLENAME, this.getPSPFStyleName());
        }
        if (!bl || this.isPSStudioThemeIdDirty()) {
            hashMap.put(FIELD_PSSTUDIOTHEMEID, this.getPSStudioThemeId());
        }
        if (!bl || this.isPSStudioThemeNameDirty()) {
            hashMap.put(FIELD_PSSTUDIOTHEMENAME, this.getPSStudioThemeName());
        }
        if (!bl || this.isPSSysAppIdDirty()) {
            hashMap.put(FIELD_PSSYSAPPID, this.getPSSysAppId());
        }
        if (!bl || this.isPSSysAppNameDirty()) {
            hashMap.put(FIELD_PSSYSAPPNAME, this.getPSSysAppName());
        }
        if (!bl || this.isThemeCssStyleDirty()) {
            hashMap.put(FIELD_THEMECSSSTYLE, this.getThemeCssStyle());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
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
        return PSDevSlnSysAppBase.get(this, n);
    }

    private static Object get(PSDevSlnSysAppBase pSDevSlnSysAppBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnSysAppBase.getAppMDUrl();
            }
            case 1: {
                return pSDevSlnSysAppBase.getAppMode();
            }
            case 2: {
                return pSDevSlnSysAppBase.getAppPKGName();
            }
            case 3: {
                return pSDevSlnSysAppBase.getAppSN();
            }
            case 4: {
                return pSDevSlnSysAppBase.getAppTag();
            }
            case 5: {
                return pSDevSlnSysAppBase.getAppTag2();
            }
            case 6: {
                return pSDevSlnSysAppBase.getAppTag3();
            }
            case 7: {
                return pSDevSlnSysAppBase.getAppTag4();
            }
            case 8: {
                return pSDevSlnSysAppBase.getCreateDate();
            }
            case 9: {
                return pSDevSlnSysAppBase.getCreateMan();
            }
            case 10: {
                return pSDevSlnSysAppBase.getDevSysState();
            }
            case 11: {
                return pSDevSlnSysAppBase.getLogicName();
            }
            case 12: {
                return pSDevSlnSysAppBase.getMemo();
            }
            case 13: {
                return pSDevSlnSysAppBase.getPSAppTypeId();
            }
            case 14: {
                return pSDevSlnSysAppBase.getPSAppTypeName();
            }
            case 15: {
                return pSDevSlnSysAppBase.getPSDevSlnId();
            }
            case 16: {
                return pSDevSlnSysAppBase.getPSDevSlnSysAppId();
            }
            case 17: {
                return pSDevSlnSysAppBase.getPSDevSlnSysAppName();
            }
            case 18: {
                return pSDevSlnSysAppBase.getPSDevSlnSysId();
            }
            case 19: {
                return pSDevSlnSysAppBase.getPSDevSlnSysName();
            }
            case 20: {
                return pSDevSlnSysAppBase.getPSPFId();
            }
            case 21: {
                return pSDevSlnSysAppBase.getPSPFName();
            }
            case 22: {
                return pSDevSlnSysAppBase.getPSPFStyleId();
            }
            case 23: {
                return pSDevSlnSysAppBase.getPSPFStyleName();
            }
            case 24: {
                return pSDevSlnSysAppBase.getPSStudioThemeId();
            }
            case 25: {
                return pSDevSlnSysAppBase.getPSStudioThemeName();
            }
            case 26: {
                return pSDevSlnSysAppBase.getPSSysAppId();
            }
            case 27: {
                return pSDevSlnSysAppBase.getPSSysAppName();
            }
            case 28: {
                return pSDevSlnSysAppBase.getThemeCssStyle();
            }
            case 29: {
                return pSDevSlnSysAppBase.getUpdateDate();
            }
            case 30: {
                return pSDevSlnSysAppBase.getUpdateMan();
            }
            case 31: {
                return pSDevSlnSysAppBase.getValidFlag();
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
        PSDevSlnSysAppBase.set(this, n, object);
    }

    private static void set(PSDevSlnSysAppBase pSDevSlnSysAppBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnSysAppBase.setAppMDUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDevSlnSysAppBase.setAppMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDevSlnSysAppBase.setAppPKGName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDevSlnSysAppBase.setAppSN(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDevSlnSysAppBase.setAppTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDevSlnSysAppBase.setAppTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDevSlnSysAppBase.setAppTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDevSlnSysAppBase.setAppTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDevSlnSysAppBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 9: {
                pSDevSlnSysAppBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDevSlnSysAppBase.setDevSysState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSDevSlnSysAppBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDevSlnSysAppBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDevSlnSysAppBase.setPSAppTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDevSlnSysAppBase.setPSAppTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDevSlnSysAppBase.setPSDevSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDevSlnSysAppBase.setPSDevSlnSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDevSlnSysAppBase.setPSDevSlnSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDevSlnSysAppBase.setPSDevSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDevSlnSysAppBase.setPSDevSlnSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDevSlnSysAppBase.setPSPFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDevSlnSysAppBase.setPSPFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDevSlnSysAppBase.setPSPFStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDevSlnSysAppBase.setPSPFStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDevSlnSysAppBase.setPSStudioThemeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDevSlnSysAppBase.setPSStudioThemeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDevSlnSysAppBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDevSlnSysAppBase.setPSSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDevSlnSysAppBase.setThemeCssStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDevSlnSysAppBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 30: {
                pSDevSlnSysAppBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDevSlnSysAppBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDevSlnSysAppBase.isNull(this, n);
    }

    private static boolean isNull(PSDevSlnSysAppBase pSDevSlnSysAppBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnSysAppBase.getAppMDUrl() == null;
            }
            case 1: {
                return pSDevSlnSysAppBase.getAppMode() == null;
            }
            case 2: {
                return pSDevSlnSysAppBase.getAppPKGName() == null;
            }
            case 3: {
                return pSDevSlnSysAppBase.getAppSN() == null;
            }
            case 4: {
                return pSDevSlnSysAppBase.getAppTag() == null;
            }
            case 5: {
                return pSDevSlnSysAppBase.getAppTag2() == null;
            }
            case 6: {
                return pSDevSlnSysAppBase.getAppTag3() == null;
            }
            case 7: {
                return pSDevSlnSysAppBase.getAppTag4() == null;
            }
            case 8: {
                return pSDevSlnSysAppBase.getCreateDate() == null;
            }
            case 9: {
                return pSDevSlnSysAppBase.getCreateMan() == null;
            }
            case 10: {
                return pSDevSlnSysAppBase.getDevSysState() == null;
            }
            case 11: {
                return pSDevSlnSysAppBase.getLogicName() == null;
            }
            case 12: {
                return pSDevSlnSysAppBase.getMemo() == null;
            }
            case 13: {
                return pSDevSlnSysAppBase.getPSAppTypeId() == null;
            }
            case 14: {
                return pSDevSlnSysAppBase.getPSAppTypeName() == null;
            }
            case 15: {
                return pSDevSlnSysAppBase.getPSDevSlnId() == null;
            }
            case 16: {
                return pSDevSlnSysAppBase.getPSDevSlnSysAppId() == null;
            }
            case 17: {
                return pSDevSlnSysAppBase.getPSDevSlnSysAppName() == null;
            }
            case 18: {
                return pSDevSlnSysAppBase.getPSDevSlnSysId() == null;
            }
            case 19: {
                return pSDevSlnSysAppBase.getPSDevSlnSysName() == null;
            }
            case 20: {
                return pSDevSlnSysAppBase.getPSPFId() == null;
            }
            case 21: {
                return pSDevSlnSysAppBase.getPSPFName() == null;
            }
            case 22: {
                return pSDevSlnSysAppBase.getPSPFStyleId() == null;
            }
            case 23: {
                return pSDevSlnSysAppBase.getPSPFStyleName() == null;
            }
            case 24: {
                return pSDevSlnSysAppBase.getPSStudioThemeId() == null;
            }
            case 25: {
                return pSDevSlnSysAppBase.getPSStudioThemeName() == null;
            }
            case 26: {
                return pSDevSlnSysAppBase.getPSSysAppId() == null;
            }
            case 27: {
                return pSDevSlnSysAppBase.getPSSysAppName() == null;
            }
            case 28: {
                return pSDevSlnSysAppBase.getThemeCssStyle() == null;
            }
            case 29: {
                return pSDevSlnSysAppBase.getUpdateDate() == null;
            }
            case 30: {
                return pSDevSlnSysAppBase.getUpdateMan() == null;
            }
            case 31: {
                return pSDevSlnSysAppBase.getValidFlag() == null;
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
        return PSDevSlnSysAppBase.contains(this, n);
    }

    private static boolean contains(PSDevSlnSysAppBase pSDevSlnSysAppBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnSysAppBase.isAppMDUrlDirty();
            }
            case 1: {
                return pSDevSlnSysAppBase.isAppModeDirty();
            }
            case 2: {
                return pSDevSlnSysAppBase.isAppPKGNameDirty();
            }
            case 3: {
                return pSDevSlnSysAppBase.isAppSNDirty();
            }
            case 4: {
                return pSDevSlnSysAppBase.isAppTagDirty();
            }
            case 5: {
                return pSDevSlnSysAppBase.isAppTag2Dirty();
            }
            case 6: {
                return pSDevSlnSysAppBase.isAppTag3Dirty();
            }
            case 7: {
                return pSDevSlnSysAppBase.isAppTag4Dirty();
            }
            case 8: {
                return pSDevSlnSysAppBase.isCreateDateDirty();
            }
            case 9: {
                return pSDevSlnSysAppBase.isCreateManDirty();
            }
            case 10: {
                return pSDevSlnSysAppBase.isDevSysStateDirty();
            }
            case 11: {
                return pSDevSlnSysAppBase.isLogicNameDirty();
            }
            case 12: {
                return pSDevSlnSysAppBase.isMemoDirty();
            }
            case 13: {
                return pSDevSlnSysAppBase.isPSAppTypeIdDirty();
            }
            case 14: {
                return pSDevSlnSysAppBase.isPSAppTypeNameDirty();
            }
            case 15: {
                return pSDevSlnSysAppBase.isPSDevSlnIdDirty();
            }
            case 16: {
                return pSDevSlnSysAppBase.isPSDevSlnSysAppIdDirty();
            }
            case 17: {
                return pSDevSlnSysAppBase.isPSDevSlnSysAppNameDirty();
            }
            case 18: {
                return pSDevSlnSysAppBase.isPSDevSlnSysIdDirty();
            }
            case 19: {
                return pSDevSlnSysAppBase.isPSDevSlnSysNameDirty();
            }
            case 20: {
                return pSDevSlnSysAppBase.isPSPFIdDirty();
            }
            case 21: {
                return pSDevSlnSysAppBase.isPSPFNameDirty();
            }
            case 22: {
                return pSDevSlnSysAppBase.isPSPFStyleIdDirty();
            }
            case 23: {
                return pSDevSlnSysAppBase.isPSPFStyleNameDirty();
            }
            case 24: {
                return pSDevSlnSysAppBase.isPSStudioThemeIdDirty();
            }
            case 25: {
                return pSDevSlnSysAppBase.isPSStudioThemeNameDirty();
            }
            case 26: {
                return pSDevSlnSysAppBase.isPSSysAppIdDirty();
            }
            case 27: {
                return pSDevSlnSysAppBase.isPSSysAppNameDirty();
            }
            case 28: {
                return pSDevSlnSysAppBase.isThemeCssStyleDirty();
            }
            case 29: {
                return pSDevSlnSysAppBase.isUpdateDateDirty();
            }
            case 30: {
                return pSDevSlnSysAppBase.isUpdateManDirty();
            }
            case 31: {
                return pSDevSlnSysAppBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevSlnSysAppBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevSlnSysAppBase pSDevSlnSysAppBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevSlnSysAppBase.getAppMDUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"appmdurl", (Object)PSDevSlnSysAppBase.getJSONValue((Object)pSDevSlnSysAppBase.getAppMDUrl()), (boolean)false);
        }
        if (bl || pSDevSlnSysAppBase.getAppMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"appmode", (Object)PSDevSlnSysAppBase.getJSONValue((Object)pSDevSlnSysAppBase.getAppMode()), (boolean)false);
        }
        if (bl || pSDevSlnSysAppBase.getAppPKGName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"apppkgname", (Object)PSDevSlnSysAppBase.getJSONValue((Object)pSDevSlnSysAppBase.getAppPKGName()), (boolean)false);
        }
        if (bl || pSDevSlnSysAppBase.getAppSN() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"appsn", (Object)PSDevSlnSysAppBase.getJSONValue((Object)pSDevSlnSysAppBase.getAppSN()), (boolean)false);
        }
        if (bl || pSDevSlnSysAppBase.getAppTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"apptag", (Object)PSDevSlnSysAppBase.getJSONValue((Object)pSDevSlnSysAppBase.getAppTag()), (boolean)false);
        }
        if (bl || pSDevSlnSysAppBase.getAppTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"apptag2", (Object)PSDevSlnSysAppBase.getJSONValue((Object)pSDevSlnSysAppBase.getAppTag2()), (boolean)false);
        }
        if (bl || pSDevSlnSysAppBase.getAppTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"apptag3", (Object)PSDevSlnSysAppBase.getJSONValue((Object)pSDevSlnSysAppBase.getAppTag3()), (boolean)false);
        }
        if (bl || pSDevSlnSysAppBase.getAppTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"apptag4", (Object)PSDevSlnSysAppBase.getJSONValue((Object)pSDevSlnSysAppBase.getAppTag4()), (boolean)false);
        }
        if (bl || pSDevSlnSysAppBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevSlnSysAppBase.getJSONValue((Object)pSDevSlnSysAppBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevSlnSysAppBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevSlnSysAppBase.getJSONValue((Object)pSDevSlnSysAppBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevSlnSysAppBase.getDevSysState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"devsysstate", (Object)PSDevSlnSysAppBase.getJSONValue((Object)pSDevSlnSysAppBase.getDevSysState()), (boolean)false);
        }
        if (bl || pSDevSlnSysAppBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSDevSlnSysAppBase.getJSONValue((Object)pSDevSlnSysAppBase.getLogicName()), (boolean)false);
        }
        if (bl || pSDevSlnSysAppBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDevSlnSysAppBase.getJSONValue((Object)pSDevSlnSysAppBase.getMemo()), (boolean)false);
        }
        if (bl || pSDevSlnSysAppBase.getPSAppTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psapptypeid", (Object)PSDevSlnSysAppBase.getJSONValue((Object)pSDevSlnSysAppBase.getPSAppTypeId()), (boolean)false);
        }
        if (bl || pSDevSlnSysAppBase.getPSAppTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psapptypename", (Object)PSDevSlnSysAppBase.getJSONValue((Object)pSDevSlnSysAppBase.getPSAppTypeName()), (boolean)false);
        }
        if (bl || pSDevSlnSysAppBase.getPSDevSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnid", (Object)PSDevSlnSysAppBase.getJSONValue((Object)pSDevSlnSysAppBase.getPSDevSlnId()), (boolean)false);
        }
        if (bl || pSDevSlnSysAppBase.getPSDevSlnSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysappid", (Object)PSDevSlnSysAppBase.getJSONValue((Object)pSDevSlnSysAppBase.getPSDevSlnSysAppId()), (boolean)false);
        }
        if (bl || pSDevSlnSysAppBase.getPSDevSlnSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysappname", (Object)PSDevSlnSysAppBase.getJSONValue((Object)pSDevSlnSysAppBase.getPSDevSlnSysAppName()), (boolean)false);
        }
        if (bl || pSDevSlnSysAppBase.getPSDevSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysid", (Object)PSDevSlnSysAppBase.getJSONValue((Object)pSDevSlnSysAppBase.getPSDevSlnSysId()), (boolean)false);
        }
        if (bl || pSDevSlnSysAppBase.getPSDevSlnSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysname", (Object)PSDevSlnSysAppBase.getJSONValue((Object)pSDevSlnSysAppBase.getPSDevSlnSysName()), (boolean)false);
        }
        if (bl || pSDevSlnSysAppBase.getPSPFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfid", (Object)PSDevSlnSysAppBase.getJSONValue((Object)pSDevSlnSysAppBase.getPSPFId()), (boolean)false);
        }
        if (bl || pSDevSlnSysAppBase.getPSPFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfname", (Object)PSDevSlnSysAppBase.getJSONValue((Object)pSDevSlnSysAppBase.getPSPFName()), (boolean)false);
        }
        if (bl || pSDevSlnSysAppBase.getPSPFStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfstyleid", (Object)PSDevSlnSysAppBase.getJSONValue((Object)pSDevSlnSysAppBase.getPSPFStyleId()), (boolean)false);
        }
        if (bl || pSDevSlnSysAppBase.getPSPFStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfstylename", (Object)PSDevSlnSysAppBase.getJSONValue((Object)pSDevSlnSysAppBase.getPSPFStyleName()), (boolean)false);
        }
        if (bl || pSDevSlnSysAppBase.getPSStudioThemeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psstudiothemeid", (Object)PSDevSlnSysAppBase.getJSONValue((Object)pSDevSlnSysAppBase.getPSStudioThemeId()), (boolean)false);
        }
        if (bl || pSDevSlnSysAppBase.getPSStudioThemeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psstudiothemename", (Object)PSDevSlnSysAppBase.getJSONValue((Object)pSDevSlnSysAppBase.getPSStudioThemeName()), (boolean)false);
        }
        if (bl || pSDevSlnSysAppBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSDevSlnSysAppBase.getJSONValue((Object)pSDevSlnSysAppBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSDevSlnSysAppBase.getPSSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappname", (Object)PSDevSlnSysAppBase.getJSONValue((Object)pSDevSlnSysAppBase.getPSSysAppName()), (boolean)false);
        }
        if (bl || pSDevSlnSysAppBase.getThemeCssStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"themecssstyle", (Object)PSDevSlnSysAppBase.getJSONValue((Object)pSDevSlnSysAppBase.getThemeCssStyle()), (boolean)false);
        }
        if (bl || pSDevSlnSysAppBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevSlnSysAppBase.getJSONValue((Object)pSDevSlnSysAppBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevSlnSysAppBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevSlnSysAppBase.getJSONValue((Object)pSDevSlnSysAppBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDevSlnSysAppBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDevSlnSysAppBase.getJSONValue((Object)pSDevSlnSysAppBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevSlnSysAppBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevSlnSysAppBase pSDevSlnSysAppBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevSlnSysAppBase.getAppMDUrl() != null) {
            object = pSDevSlnSysAppBase.getAppMDUrl();
            xmlNode.setAttribute(FIELD_APPMDURL, (String)(object == null ? "" : object));
        }
        if (bl || pSDevSlnSysAppBase.getAppMode() != null) {
            object = pSDevSlnSysAppBase.getAppMode();
            xmlNode.setAttribute(FIELD_APPMODE, (String)(object == null ? "" : object));
        }
        if (bl || pSDevSlnSysAppBase.getAppPKGName() != null) {
            object = pSDevSlnSysAppBase.getAppPKGName();
            xmlNode.setAttribute(FIELD_APPPKGNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSDevSlnSysAppBase.getAppSN() != null) {
            object = pSDevSlnSysAppBase.getAppSN();
            xmlNode.setAttribute(FIELD_APPSN, (String)(object == null ? "" : object));
        }
        if (bl || pSDevSlnSysAppBase.getAppTag() != null) {
            object = pSDevSlnSysAppBase.getAppTag();
            xmlNode.setAttribute(FIELD_APPTAG, (String)(object == null ? "" : object));
        }
        if (bl || pSDevSlnSysAppBase.getAppTag2() != null) {
            object = pSDevSlnSysAppBase.getAppTag2();
            xmlNode.setAttribute(FIELD_APPTAG2, (String)(object == null ? "" : object));
        }
        if (bl || pSDevSlnSysAppBase.getAppTag3() != null) {
            object = pSDevSlnSysAppBase.getAppTag3();
            xmlNode.setAttribute(FIELD_APPTAG3, (String)(object == null ? "" : object));
        }
        if (bl || pSDevSlnSysAppBase.getAppTag4() != null) {
            object = pSDevSlnSysAppBase.getAppTag4();
            xmlNode.setAttribute(FIELD_APPTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysAppBase.getCreateDate() != null) {
            object = pSDevSlnSysAppBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysAppBase.getCreateMan() != null) {
            object = pSDevSlnSysAppBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysAppBase.getDevSysState() != null) {
            object = pSDevSlnSysAppBase.getDevSysState();
            xmlNode.setAttribute(FIELD_DEVSYSSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnSysAppBase.getLogicName() != null) {
            object = pSDevSlnSysAppBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysAppBase.getMemo() != null) {
            object = pSDevSlnSysAppBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysAppBase.getPSAppTypeId() != null) {
            object = pSDevSlnSysAppBase.getPSAppTypeId();
            xmlNode.setAttribute(FIELD_PSAPPTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysAppBase.getPSAppTypeName() != null) {
            object = pSDevSlnSysAppBase.getPSAppTypeName();
            xmlNode.setAttribute(FIELD_PSAPPTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysAppBase.getPSDevSlnId() != null) {
            object = pSDevSlnSysAppBase.getPSDevSlnId();
            xmlNode.setAttribute(FIELD_PSDEVSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysAppBase.getPSDevSlnSysAppId() != null) {
            object = pSDevSlnSysAppBase.getPSDevSlnSysAppId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysAppBase.getPSDevSlnSysAppName() != null) {
            object = pSDevSlnSysAppBase.getPSDevSlnSysAppName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysAppBase.getPSDevSlnSysId() != null) {
            object = pSDevSlnSysAppBase.getPSDevSlnSysId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysAppBase.getPSDevSlnSysName() != null) {
            object = pSDevSlnSysAppBase.getPSDevSlnSysName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysAppBase.getPSPFId() != null) {
            object = pSDevSlnSysAppBase.getPSPFId();
            xmlNode.setAttribute(FIELD_PSPFID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysAppBase.getPSPFName() != null) {
            object = pSDevSlnSysAppBase.getPSPFName();
            xmlNode.setAttribute(FIELD_PSPFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysAppBase.getPSPFStyleId() != null) {
            object = pSDevSlnSysAppBase.getPSPFStyleId();
            xmlNode.setAttribute(FIELD_PSPFSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysAppBase.getPSPFStyleName() != null) {
            object = pSDevSlnSysAppBase.getPSPFStyleName();
            xmlNode.setAttribute(FIELD_PSPFSTYLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysAppBase.getPSStudioThemeId() != null) {
            object = pSDevSlnSysAppBase.getPSStudioThemeId();
            xmlNode.setAttribute(FIELD_PSSTUDIOTHEMEID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysAppBase.getPSStudioThemeName() != null) {
            object = pSDevSlnSysAppBase.getPSStudioThemeName();
            xmlNode.setAttribute(FIELD_PSSTUDIOTHEMENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysAppBase.getPSSysAppId() != null) {
            object = pSDevSlnSysAppBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysAppBase.getPSSysAppName() != null) {
            object = pSDevSlnSysAppBase.getPSSysAppName();
            xmlNode.setAttribute(FIELD_PSSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysAppBase.getThemeCssStyle() != null) {
            object = pSDevSlnSysAppBase.getThemeCssStyle();
            xmlNode.setAttribute(FIELD_THEMECSSSTYLE, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysAppBase.getUpdateDate() != null) {
            object = pSDevSlnSysAppBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysAppBase.getUpdateMan() != null) {
            object = pSDevSlnSysAppBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysAppBase.getValidFlag() != null) {
            object = pSDevSlnSysAppBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevSlnSysAppBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevSlnSysAppBase pSDevSlnSysAppBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevSlnSysAppBase.isAppMDUrlDirty() && (bl || pSDevSlnSysAppBase.getAppMDUrl() != null)) {
            iDataObject.set(FIELD_APPMDURL, (Object)pSDevSlnSysAppBase.getAppMDUrl());
        }
        if (pSDevSlnSysAppBase.isAppModeDirty() && (bl || pSDevSlnSysAppBase.getAppMode() != null)) {
            iDataObject.set(FIELD_APPMODE, (Object)pSDevSlnSysAppBase.getAppMode());
        }
        if (pSDevSlnSysAppBase.isAppPKGNameDirty() && (bl || pSDevSlnSysAppBase.getAppPKGName() != null)) {
            iDataObject.set(FIELD_APPPKGNAME, (Object)pSDevSlnSysAppBase.getAppPKGName());
        }
        if (pSDevSlnSysAppBase.isAppSNDirty() && (bl || pSDevSlnSysAppBase.getAppSN() != null)) {
            iDataObject.set(FIELD_APPSN, (Object)pSDevSlnSysAppBase.getAppSN());
        }
        if (pSDevSlnSysAppBase.isAppTagDirty() && (bl || pSDevSlnSysAppBase.getAppTag() != null)) {
            iDataObject.set(FIELD_APPTAG, (Object)pSDevSlnSysAppBase.getAppTag());
        }
        if (pSDevSlnSysAppBase.isAppTag2Dirty() && (bl || pSDevSlnSysAppBase.getAppTag2() != null)) {
            iDataObject.set(FIELD_APPTAG2, (Object)pSDevSlnSysAppBase.getAppTag2());
        }
        if (pSDevSlnSysAppBase.isAppTag3Dirty() && (bl || pSDevSlnSysAppBase.getAppTag3() != null)) {
            iDataObject.set(FIELD_APPTAG3, (Object)pSDevSlnSysAppBase.getAppTag3());
        }
        if (pSDevSlnSysAppBase.isAppTag4Dirty() && (bl || pSDevSlnSysAppBase.getAppTag4() != null)) {
            iDataObject.set(FIELD_APPTAG4, (Object)pSDevSlnSysAppBase.getAppTag4());
        }
        if (pSDevSlnSysAppBase.isCreateDateDirty() && (bl || pSDevSlnSysAppBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevSlnSysAppBase.getCreateDate());
        }
        if (pSDevSlnSysAppBase.isCreateManDirty() && (bl || pSDevSlnSysAppBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevSlnSysAppBase.getCreateMan());
        }
        if (pSDevSlnSysAppBase.isDevSysStateDirty() && (bl || pSDevSlnSysAppBase.getDevSysState() != null)) {
            iDataObject.set(FIELD_DEVSYSSTATE, (Object)pSDevSlnSysAppBase.getDevSysState());
        }
        if (pSDevSlnSysAppBase.isLogicNameDirty() && (bl || pSDevSlnSysAppBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSDevSlnSysAppBase.getLogicName());
        }
        if (pSDevSlnSysAppBase.isMemoDirty() && (bl || pSDevSlnSysAppBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDevSlnSysAppBase.getMemo());
        }
        if (pSDevSlnSysAppBase.isPSAppTypeIdDirty() && (bl || pSDevSlnSysAppBase.getPSAppTypeId() != null)) {
            iDataObject.set(FIELD_PSAPPTYPEID, (Object)pSDevSlnSysAppBase.getPSAppTypeId());
        }
        if (pSDevSlnSysAppBase.isPSAppTypeNameDirty() && (bl || pSDevSlnSysAppBase.getPSAppTypeName() != null)) {
            iDataObject.set(FIELD_PSAPPTYPENAME, (Object)pSDevSlnSysAppBase.getPSAppTypeName());
        }
        if (pSDevSlnSysAppBase.isPSDevSlnIdDirty() && (bl || pSDevSlnSysAppBase.getPSDevSlnId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNID, (Object)pSDevSlnSysAppBase.getPSDevSlnId());
        }
        if (pSDevSlnSysAppBase.isPSDevSlnSysAppIdDirty() && (bl || pSDevSlnSysAppBase.getPSDevSlnSysAppId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSAPPID, (Object)pSDevSlnSysAppBase.getPSDevSlnSysAppId());
        }
        if (pSDevSlnSysAppBase.isPSDevSlnSysAppNameDirty() && (bl || pSDevSlnSysAppBase.getPSDevSlnSysAppName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSAPPNAME, (Object)pSDevSlnSysAppBase.getPSDevSlnSysAppName());
        }
        if (pSDevSlnSysAppBase.isPSDevSlnSysIdDirty() && (bl || pSDevSlnSysAppBase.getPSDevSlnSysId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSID, (Object)pSDevSlnSysAppBase.getPSDevSlnSysId());
        }
        if (pSDevSlnSysAppBase.isPSDevSlnSysNameDirty() && (bl || pSDevSlnSysAppBase.getPSDevSlnSysName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSNAME, (Object)pSDevSlnSysAppBase.getPSDevSlnSysName());
        }
        if (pSDevSlnSysAppBase.isPSPFIdDirty() && (bl || pSDevSlnSysAppBase.getPSPFId() != null)) {
            iDataObject.set(FIELD_PSPFID, (Object)pSDevSlnSysAppBase.getPSPFId());
        }
        if (pSDevSlnSysAppBase.isPSPFNameDirty() && (bl || pSDevSlnSysAppBase.getPSPFName() != null)) {
            iDataObject.set(FIELD_PSPFNAME, (Object)pSDevSlnSysAppBase.getPSPFName());
        }
        if (pSDevSlnSysAppBase.isPSPFStyleIdDirty() && (bl || pSDevSlnSysAppBase.getPSPFStyleId() != null)) {
            iDataObject.set(FIELD_PSPFSTYLEID, (Object)pSDevSlnSysAppBase.getPSPFStyleId());
        }
        if (pSDevSlnSysAppBase.isPSPFStyleNameDirty() && (bl || pSDevSlnSysAppBase.getPSPFStyleName() != null)) {
            iDataObject.set(FIELD_PSPFSTYLENAME, (Object)pSDevSlnSysAppBase.getPSPFStyleName());
        }
        if (pSDevSlnSysAppBase.isPSStudioThemeIdDirty() && (bl || pSDevSlnSysAppBase.getPSStudioThemeId() != null)) {
            iDataObject.set(FIELD_PSSTUDIOTHEMEID, (Object)pSDevSlnSysAppBase.getPSStudioThemeId());
        }
        if (pSDevSlnSysAppBase.isPSStudioThemeNameDirty() && (bl || pSDevSlnSysAppBase.getPSStudioThemeName() != null)) {
            iDataObject.set(FIELD_PSSTUDIOTHEMENAME, (Object)pSDevSlnSysAppBase.getPSStudioThemeName());
        }
        if (pSDevSlnSysAppBase.isPSSysAppIdDirty() && (bl || pSDevSlnSysAppBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSDevSlnSysAppBase.getPSSysAppId());
        }
        if (pSDevSlnSysAppBase.isPSSysAppNameDirty() && (bl || pSDevSlnSysAppBase.getPSSysAppName() != null)) {
            iDataObject.set(FIELD_PSSYSAPPNAME, (Object)pSDevSlnSysAppBase.getPSSysAppName());
        }
        if (pSDevSlnSysAppBase.isThemeCssStyleDirty() && (bl || pSDevSlnSysAppBase.getThemeCssStyle() != null)) {
            iDataObject.set(FIELD_THEMECSSSTYLE, (Object)pSDevSlnSysAppBase.getThemeCssStyle());
        }
        if (pSDevSlnSysAppBase.isUpdateDateDirty() && (bl || pSDevSlnSysAppBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevSlnSysAppBase.getUpdateDate());
        }
        if (pSDevSlnSysAppBase.isUpdateManDirty() && (bl || pSDevSlnSysAppBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevSlnSysAppBase.getUpdateMan());
        }
        if (pSDevSlnSysAppBase.isValidFlagDirty() && (bl || pSDevSlnSysAppBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDevSlnSysAppBase.getValidFlag());
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
        return PSDevSlnSysAppBase.remove(this, n);
    }

    private static boolean remove(PSDevSlnSysAppBase pSDevSlnSysAppBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnSysAppBase.resetAppMDUrl();
                return true;
            }
            case 1: {
                pSDevSlnSysAppBase.resetAppMode();
                return true;
            }
            case 2: {
                pSDevSlnSysAppBase.resetAppPKGName();
                return true;
            }
            case 3: {
                pSDevSlnSysAppBase.resetAppSN();
                return true;
            }
            case 4: {
                pSDevSlnSysAppBase.resetAppTag();
                return true;
            }
            case 5: {
                pSDevSlnSysAppBase.resetAppTag2();
                return true;
            }
            case 6: {
                pSDevSlnSysAppBase.resetAppTag3();
                return true;
            }
            case 7: {
                pSDevSlnSysAppBase.resetAppTag4();
                return true;
            }
            case 8: {
                pSDevSlnSysAppBase.resetCreateDate();
                return true;
            }
            case 9: {
                pSDevSlnSysAppBase.resetCreateMan();
                return true;
            }
            case 10: {
                pSDevSlnSysAppBase.resetDevSysState();
                return true;
            }
            case 11: {
                pSDevSlnSysAppBase.resetLogicName();
                return true;
            }
            case 12: {
                pSDevSlnSysAppBase.resetMemo();
                return true;
            }
            case 13: {
                pSDevSlnSysAppBase.resetPSAppTypeId();
                return true;
            }
            case 14: {
                pSDevSlnSysAppBase.resetPSAppTypeName();
                return true;
            }
            case 15: {
                pSDevSlnSysAppBase.resetPSDevSlnId();
                return true;
            }
            case 16: {
                pSDevSlnSysAppBase.resetPSDevSlnSysAppId();
                return true;
            }
            case 17: {
                pSDevSlnSysAppBase.resetPSDevSlnSysAppName();
                return true;
            }
            case 18: {
                pSDevSlnSysAppBase.resetPSDevSlnSysId();
                return true;
            }
            case 19: {
                pSDevSlnSysAppBase.resetPSDevSlnSysName();
                return true;
            }
            case 20: {
                pSDevSlnSysAppBase.resetPSPFId();
                return true;
            }
            case 21: {
                pSDevSlnSysAppBase.resetPSPFName();
                return true;
            }
            case 22: {
                pSDevSlnSysAppBase.resetPSPFStyleId();
                return true;
            }
            case 23: {
                pSDevSlnSysAppBase.resetPSPFStyleName();
                return true;
            }
            case 24: {
                pSDevSlnSysAppBase.resetPSStudioThemeId();
                return true;
            }
            case 25: {
                pSDevSlnSysAppBase.resetPSStudioThemeName();
                return true;
            }
            case 26: {
                pSDevSlnSysAppBase.resetPSSysAppId();
                return true;
            }
            case 27: {
                pSDevSlnSysAppBase.resetPSSysAppName();
                return true;
            }
            case 28: {
                pSDevSlnSysAppBase.resetThemeCssStyle();
                return true;
            }
            case 29: {
                pSDevSlnSysAppBase.resetUpdateDate();
                return true;
            }
            case 30: {
                pSDevSlnSysAppBase.resetUpdateMan();
                return true;
            }
            case 31: {
                pSDevSlnSysAppBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSAppType getPSAppType() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppType();
        }
        if (this.getPSAppTypeId() == null) {
            return null;
        }
        Integer n = this.objPSAppTypeLock;
        synchronized (n) {
            if (this.psapptype != null && DataTypeHelper.compare((int)25, (Object)this.getPSAppTypeId(), (Object)this.psapptype.getPSAppTypeId()) != 0L) {
                this.psapptype = null;
            }
            if (this.psapptype == null) {
                PSAppType pSAppType = new PSAppType();
                pSAppType.setPSAppTypeId(this.getPSAppTypeId());
                PSAppTypeService pSAppTypeService = (PSAppTypeService)ServiceGlobal.getService(PSAppTypeService.class, (SessionFactory)this.getSessionFactory());
                pSAppTypeService.autoGet((IEntity)pSAppType);
                this.psapptype = pSAppType;
            }
            return this.psapptype;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnSys getPSDevSlnSys() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSys();
        }
        if (this.getPSDevSlnSysId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnSysLock;
        synchronized (n) {
            if (this.psdevslnsys != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnSysId(), (Object)this.psdevslnsys.getPSDevSlnSysId()) != 0L) {
                this.psdevslnsys = null;
            }
            if (this.psdevslnsys == null) {
                PSDevSlnSys pSDevSlnSys = new PSDevSlnSys();
                pSDevSlnSys.setPSDevSlnSysId(this.getPSDevSlnSysId());
                PSDevSlnSysService pSDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnSysService.autoGet((IEntity)pSDevSlnSys);
                this.psdevslnsys = pSDevSlnSys;
            }
            return this.psdevslnsys;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSPFStyle getPSPFStyle() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFStyle();
        }
        if (this.getPSPFStyleId() == null) {
            return null;
        }
        Integer n = this.objPSPFStyleLock;
        synchronized (n) {
            if (this.pspfstyle != null && DataTypeHelper.compare((int)25, (Object)this.getPSPFStyleId(), (Object)this.pspfstyle.getPSPFStyleId()) != 0L) {
                this.pspfstyle = null;
            }
            if (this.pspfstyle == null) {
                PSPFStyle pSPFStyle = new PSPFStyle();
                pSPFStyle.setPSPFStyleId(this.getPSPFStyleId());
                PSPFStyleService pSPFStyleService = (PSPFStyleService)ServiceGlobal.getService(PSPFStyleService.class, (SessionFactory)this.getSessionFactory());
                pSPFStyleService.autoGet((IEntity)pSPFStyle);
                this.pspfstyle = pSPFStyle;
            }
            return this.pspfstyle;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSPF getPSPF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPF();
        }
        if (this.getPSPFId() == null) {
            return null;
        }
        Integer n = this.objPSPFLock;
        synchronized (n) {
            if (this.pspf != null && DataTypeHelper.compare((int)25, (Object)this.getPSPFId(), (Object)this.pspf.getPSPFId()) != 0L) {
                this.pspf = null;
            }
            if (this.pspf == null) {
                PSPF pSPF = new PSPF();
                pSPF.setPSPFId(this.getPSPFId());
                PSPFService pSPFService = (PSPFService)ServiceGlobal.getService(PSPFService.class, (SessionFactory)this.getSessionFactory());
                pSPFService.autoGet((IEntity)pSPF);
                this.pspf = pSPF;
            }
            return this.pspf;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSStudioTheme getPSStudioTheme() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSStudioTheme();
        }
        if (this.getPSStudioThemeId() == null) {
            return null;
        }
        Integer n = this.objPSStudioThemeLock;
        synchronized (n) {
            if (this.psstudiotheme != null && DataTypeHelper.compare((int)25, (Object)this.getPSStudioThemeId(), (Object)this.psstudiotheme.getPSStudioThemeId()) != 0L) {
                this.psstudiotheme = null;
            }
            if (this.psstudiotheme == null) {
                PSStudioTheme pSStudioTheme = new PSStudioTheme();
                pSStudioTheme.setPSStudioThemeId(this.getPSStudioThemeId());
                PSStudioThemeService pSStudioThemeService = (PSStudioThemeService)ServiceGlobal.getService(PSStudioThemeService.class, (SessionFactory)this.getSessionFactory());
                pSStudioThemeService.autoGet((IEntity)pSStudioTheme);
                this.psstudiotheme = pSStudioTheme;
            }
            return this.psstudiotheme;
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
    public ArrayList<PSDevSlnMSDepApp> getPSDevSlnMSDepApps() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnMSDepApps();
        }
        if (this.getPSDevSlnSysAppId() == null) {
            return null;
        }
        PSDevSlnMSDepAppService pSDevSlnMSDepAppService = (PSDevSlnMSDepAppService)ServiceGlobal.getService(PSDevSlnMSDepAppService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDevSlnMSDepAppsLock;
        synchronized (n) {
            if (this.psdevslnmsdepapps == null) {
                this.psdevslnmsdepapps = pSDevSlnMSDepAppService.selectByPSDevSlnSysApp(this);
            }
            return this.psdevslnmsdepapps;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDevSlnMSDepFuncItem> getPSDevSlnMSDepFuncItems() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnMSDepFuncItems();
        }
        if (this.getPSDevSlnSysAppId() == null) {
            return null;
        }
        PSDevSlnMSDepFuncItemService pSDevSlnMSDepFuncItemService = (PSDevSlnMSDepFuncItemService)ServiceGlobal.getService(PSDevSlnMSDepFuncItemService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDevSlnMSDepFuncItemsLock;
        synchronized (n) {
            if (this.psdevslnmsdepfuncitems == null) {
                this.psdevslnmsdepfuncitems = pSDevSlnMSDepFuncItemService.selectByPSDevSlnSysApp(this);
            }
            return this.psdevslnmsdepfuncitems;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDevSlnPipelineStep> getPSDevSlnPipelineSteps() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnPipelineSteps();
        }
        if (this.getPSDevSlnSysAppId() == null) {
            return null;
        }
        PSDevSlnPipelineStepService pSDevSlnPipelineStepService = (PSDevSlnPipelineStepService)ServiceGlobal.getService(PSDevSlnPipelineStepService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDevSlnPipelineStepsLock;
        synchronized (n) {
            if (this.psdevslnpipelinesteps == null) {
                this.psdevslnpipelinesteps = pSDevSlnPipelineStepService.selectByPSDevSlnSysApp(this);
            }
            return this.psdevslnpipelinesteps;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDevSlnTempl> getPSDevSlnTempls() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnTempls();
        }
        if (this.getPSDevSlnSysAppId() == null) {
            return null;
        }
        PSDevSlnTemplService pSDevSlnTemplService = (PSDevSlnTemplService)ServiceGlobal.getService(PSDevSlnTemplService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDevSlnTemplsLock;
        synchronized (n) {
            if (this.psdevslntempls == null) {
                this.psdevslntempls = pSDevSlnTemplService.selectByPSDevSlnSysApp(this);
            }
            return this.psdevslntempls;
        }
    }

    private PSDevSlnSysAppBase getProxyEntity() {
        return this.proxyPSDevSlnSysAppBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevSlnSysAppBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevSlnSysAppBase) {
            this.proxyPSDevSlnSysAppBase = (PSDevSlnSysAppBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysAppService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_APPMDURL, 0);
        fieldIndexMap.put(FIELD_APPMODE, 1);
        fieldIndexMap.put(FIELD_APPPKGNAME, 2);
        fieldIndexMap.put(FIELD_APPSN, 3);
        fieldIndexMap.put(FIELD_APPTAG, 4);
        fieldIndexMap.put(FIELD_APPTAG2, 5);
        fieldIndexMap.put(FIELD_APPTAG3, 6);
        fieldIndexMap.put(FIELD_APPTAG4, 7);
        fieldIndexMap.put(FIELD_CREATEDATE, 8);
        fieldIndexMap.put(FIELD_CREATEMAN, 9);
        fieldIndexMap.put(FIELD_DEVSYSSTATE, 10);
        fieldIndexMap.put(FIELD_LOGICNAME, 11);
        fieldIndexMap.put(FIELD_MEMO, 12);
        fieldIndexMap.put(FIELD_PSAPPTYPEID, 13);
        fieldIndexMap.put(FIELD_PSAPPTYPENAME, 14);
        fieldIndexMap.put(FIELD_PSDEVSLNID, 15);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSAPPID, 16);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSAPPNAME, 17);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSID, 18);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSNAME, 19);
        fieldIndexMap.put(FIELD_PSPFID, 20);
        fieldIndexMap.put(FIELD_PSPFNAME, 21);
        fieldIndexMap.put(FIELD_PSPFSTYLEID, 22);
        fieldIndexMap.put(FIELD_PSPFSTYLENAME, 23);
        fieldIndexMap.put(FIELD_PSSTUDIOTHEMEID, 24);
        fieldIndexMap.put(FIELD_PSSTUDIOTHEMENAME, 25);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 26);
        fieldIndexMap.put(FIELD_PSSYSAPPNAME, 27);
        fieldIndexMap.put(FIELD_THEMECSSSTYLE, 28);
        fieldIndexMap.put(FIELD_UPDATEDATE, 29);
        fieldIndexMap.put(FIELD_UPDATEMAN, 30);
        fieldIndexMap.put(FIELD_VALIDFLAG, 31);
    }
}

