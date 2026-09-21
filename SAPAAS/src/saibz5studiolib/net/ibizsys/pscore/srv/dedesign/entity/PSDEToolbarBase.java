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
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSSysToolbar;
import net.ibizsys.pscore.srv.config.service.PSSysPFPluginService;
import net.ibizsys.pscore.srv.config.service.PSSysToolbarService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETBItem;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEToolbarLogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDETBItemService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlLogicGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCounter;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewMsgGroup;
import net.ibizsys.pscore.srv.sysdesign.service.PSCtrlLogicGroupService;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCounterService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgGroupService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEToolbarBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEToolbarBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ICONALIGN = "ICONALIGN";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MOBFLAG = "MOBFLAG";
    public static final String FIELD_NO2PSDEUAGROUPID = "NO2PSDEUAGROUPID";
    public static final String FIELD_NO2PSDEUAGROUPNAME = "NO2PSDEUAGROUPNAME";
    public static final String FIELD_NO3PSDEUAGROUPID = "NO3PSDEUAGROUPID";
    public static final String FIELD_NO3PSDEUAGROUPNAME = "NO3PSDEUAGROUPNAME";
    public static final String FIELD_NO4PSDEUAGROUPID = "NO4PSDEUAGROUPID";
    public static final String FIELD_NO4PSDEUAGROUPNAME = "NO4PSDEUAGROUPNAME";
    public static final String FIELD_NO5PSDEUAGROUPID = "NO5PSDEUAGROUPID";
    public static final String FIELD_NO5PSDEUAGROUPNAME = "NO5PSDEUAGROUPNAME";
    public static final String FIELD_NO6PSDEUAGROUPID = "NO6PSDEUAGROUPID";
    public static final String FIELD_NO6PSDEUAGROUPNAME = "NO6PSDEUAGROUPNAME";
    public static final String FIELD_PSCTRLLOGICGROUPID = "PSCTRLLOGICGROUPID";
    public static final String FIELD_PSCTRLLOGICGROUPNAME = "PSCTRLLOGICGROUPNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDETOOLBARID = "PSDETOOLBARID";
    public static final String FIELD_PSDETOOLBARNAME = "PSDETOOLBARNAME";
    public static final String FIELD_PSDEUAGROUPID = "PSDEUAGROUPID";
    public static final String FIELD_PSDEUAGROUPNAME = "PSDEUAGROUPNAME";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String FIELD_PSSYSCOUNTERID = "PSSYSCOUNTERID";
    public static final String FIELD_PSSYSCOUNTERNAME = "PSSYSCOUNTERNAME";
    public static final String FIELD_PSSYSCSSID = "PSSYSCSSID";
    public static final String FIELD_PSSYSCSSNAME = "PSSYSCSSNAME";
    public static final String FIELD_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String FIELD_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_PSSYSTOOLBARID = "PSSYSTOOLBARID";
    public static final String FIELD_PSSYSTOOLBARNAME = "PSSYSTOOLBARNAME";
    public static final String FIELD_PSVIEWMSGGROUPID = "PSVIEWMSGGROUPID";
    public static final String FIELD_PSVIEWMSGGROUPNAME = "PSVIEWMSGGROUPNAME";
    public static final String FIELD_SYSAPPFLAG = "SYSAPPFLAG";
    public static final String FIELD_TBMODEL = "TBMODEL";
    public static final String FIELD_TEMPLTOOLBAR = "TEMPLTOOLBAR";
    public static final String FIELD_TOOLBARSN = "TOOLBARSN";
    public static final String FIELD_TOOLBARSTYLE = "TOOLBARSTYLE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERPARAMS = "USERPARAMS";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_ICONALIGN = 3;
    private static final int INDEX_LOCKFLAG = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_MOBFLAG = 6;
    private static final int INDEX_NO2PSDEUAGROUPID = 7;
    private static final int INDEX_NO2PSDEUAGROUPNAME = 8;
    private static final int INDEX_NO3PSDEUAGROUPID = 9;
    private static final int INDEX_NO3PSDEUAGROUPNAME = 10;
    private static final int INDEX_NO4PSDEUAGROUPID = 11;
    private static final int INDEX_NO4PSDEUAGROUPNAME = 12;
    private static final int INDEX_NO5PSDEUAGROUPID = 13;
    private static final int INDEX_NO5PSDEUAGROUPNAME = 14;
    private static final int INDEX_NO6PSDEUAGROUPID = 15;
    private static final int INDEX_NO6PSDEUAGROUPNAME = 16;
    private static final int INDEX_PSCTRLLOGICGROUPID = 17;
    private static final int INDEX_PSCTRLLOGICGROUPNAME = 18;
    private static final int INDEX_PSDEID = 19;
    private static final int INDEX_PSDENAME = 20;
    private static final int INDEX_PSDETOOLBARID = 21;
    private static final int INDEX_PSDETOOLBARNAME = 22;
    private static final int INDEX_PSDEUAGROUPID = 23;
    private static final int INDEX_PSDEUAGROUPNAME = 24;
    private static final int INDEX_PSMODULEID = 25;
    private static final int INDEX_PSMODULENAME = 26;
    private static final int INDEX_PSSYSAPPID = 27;
    private static final int INDEX_PSSYSAPPNAME = 28;
    private static final int INDEX_PSSYSCOUNTERID = 29;
    private static final int INDEX_PSSYSCOUNTERNAME = 30;
    private static final int INDEX_PSSYSCSSID = 31;
    private static final int INDEX_PSSYSCSSNAME = 32;
    private static final int INDEX_PSSYSPFPLUGINID = 33;
    private static final int INDEX_PSSYSPFPLUGINNAME = 34;
    private static final int INDEX_PSSYSTEMID = 35;
    private static final int INDEX_PSSYSTEMNAME = 36;
    private static final int INDEX_PSSYSTOOLBARID = 37;
    private static final int INDEX_PSSYSTOOLBARNAME = 38;
    private static final int INDEX_PSVIEWMSGGROUPID = 39;
    private static final int INDEX_PSVIEWMSGGROUPNAME = 40;
    private static final int INDEX_SYSAPPFLAG = 41;
    private static final int INDEX_TBMODEL = 42;
    private static final int INDEX_TEMPLTOOLBAR = 43;
    private static final int INDEX_TOOLBARSN = 44;
    private static final int INDEX_TOOLBARSTYLE = 45;
    private static final int INDEX_UPDATEDATE = 46;
    private static final int INDEX_UPDATEMAN = 47;
    private static final int INDEX_USERPARAMS = 48;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEToolbarBase proxyPSDEToolbarBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean iconalignDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean mobflagDirtyFlag = false;
    private boolean no2psdeuagroupidDirtyFlag = false;
    private boolean no2psdeuagroupnameDirtyFlag = false;
    private boolean no3psdeuagroupidDirtyFlag = false;
    private boolean no3psdeuagroupnameDirtyFlag = false;
    private boolean no4psdeuagroupidDirtyFlag = false;
    private boolean no4psdeuagroupnameDirtyFlag = false;
    private boolean no5psdeuagroupidDirtyFlag = false;
    private boolean no5psdeuagroupnameDirtyFlag = false;
    private boolean no6psdeuagroupidDirtyFlag = false;
    private boolean no6psdeuagroupnameDirtyFlag = false;
    private boolean psctrllogicgroupidDirtyFlag = false;
    private boolean psctrllogicgroupnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psdetoolbaridDirtyFlag = false;
    private boolean psdetoolbarnameDirtyFlag = false;
    private boolean psdeuagroupidDirtyFlag = false;
    private boolean psdeuagroupnameDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean pssysappnameDirtyFlag = false;
    private boolean pssyscounteridDirtyFlag = false;
    private boolean pssyscounternameDirtyFlag = false;
    private boolean pssyscssidDirtyFlag = false;
    private boolean pssyscssnameDirtyFlag = false;
    private boolean pssyspfpluginidDirtyFlag = false;
    private boolean pssyspfpluginnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean pssystoolbaridDirtyFlag = false;
    private boolean pssystoolbarnameDirtyFlag = false;
    private boolean psviewmsggroupidDirtyFlag = false;
    private boolean psviewmsggroupnameDirtyFlag = false;
    private boolean sysappflagDirtyFlag = false;
    private boolean tbmodelDirtyFlag = false;
    private boolean templtoolbarDirtyFlag = false;
    private boolean toolbarsnDirtyFlag = false;
    private boolean toolbarstyleDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean userparamsDirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="iconalign")
    private String iconalign;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="memo")
    private String memo;
    @Column(name="mobflag")
    private Integer mobflag;
    @Column(name="no2psdeuagroupid")
    private String no2psdeuagroupid;
    @Column(name="no2psdeuagroupname")
    private String no2psdeuagroupname;
    @Column(name="no3psdeuagroupid")
    private String no3psdeuagroupid;
    @Column(name="no3psdeuagroupname")
    private String no3psdeuagroupname;
    @Column(name="no4psdeuagroupid")
    private String no4psdeuagroupid;
    @Column(name="no4psdeuagroupname")
    private String no4psdeuagroupname;
    @Column(name="no5psdeuagroupid")
    private String no5psdeuagroupid;
    @Column(name="no5psdeuagroupname")
    private String no5psdeuagroupname;
    @Column(name="no6psdeuagroupid")
    private String no6psdeuagroupid;
    @Column(name="no6psdeuagroupname")
    private String no6psdeuagroupname;
    @Column(name="psctrllogicgroupid")
    private String psctrllogicgroupid;
    @Column(name="psctrllogicgroupname")
    private String psctrllogicgroupname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psdetoolbarid")
    private String psdetoolbarid;
    @Column(name="psdetoolbarname")
    private String psdetoolbarname;
    @Column(name="psdeuagroupid")
    private String psdeuagroupid;
    @Column(name="psdeuagroupname")
    private String psdeuagroupname;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssysappid")
    private String pssysappid;
    @Column(name="pssysappname")
    private String pssysappname;
    @Column(name="pssyscounterid")
    private String pssyscounterid;
    @Column(name="pssyscountername")
    private String pssyscountername;
    @Column(name="pssyscssid")
    private String pssyscssid;
    @Column(name="pssyscssname")
    private String pssyscssname;
    @Column(name="pssyspfpluginid")
    private String pssyspfpluginid;
    @Column(name="pssyspfpluginname")
    private String pssyspfpluginname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="pssystoolbarid")
    private String pssystoolbarid;
    @Column(name="pssystoolbarname")
    private String pssystoolbarname;
    @Column(name="psviewmsggroupid")
    private String psviewmsggroupid;
    @Column(name="psviewmsggroupname")
    private String psviewmsggroupname;
    @Column(name="sysappflag")
    private Integer sysappflag;
    @Column(name="tbmodel")
    private String tbmodel;
    @Column(name="templtoolbar")
    private Integer templtoolbar;
    @Column(name="toolbarsn")
    private String toolbarsn;
    @Column(name="toolbarstyle")
    private String toolbarstyle;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="userparams")
    private String userparams;
    private Integer objPSCtrlLogicGroupLock = new Integer(1);
    private PSCtrlLogicGroup psctrllogicgroup = null;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objNo2PSDEUAGroupLock = new Integer(1);
    private PSDEUAGroup no2psdeuagroup = null;
    private Integer objNo3PSDEUAGroupLock = new Integer(1);
    private PSDEUAGroup no3psdeuagroup = null;
    private Integer objNo4PSDEUAGroupLock = new Integer(1);
    private PSDEUAGroup no4psdeuagroup = null;
    private Integer objNo5PSDEUAGroupLock = new Integer(1);
    private PSDEUAGroup no5psdeuagroup = null;
    private Integer objNo6PSDEUAGroupLock = new Integer(1);
    private PSDEUAGroup no6psdeuagroup = null;
    private Integer objPSDEUAGroupLock = new Integer(1);
    private PSDEUAGroup psdeuagroup = null;
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objPSSysAppLock = new Integer(1);
    private PSSysApp pssysapp = null;
    private Integer objPSSysCounterLock = new Integer(1);
    private PSSysCounter pssyscounter = null;
    private Integer objPSSysCssLock = new Integer(1);
    private PSSysCss pssyscss = null;
    private Integer objPSSysPFPluginLock = new Integer(1);
    private PSSysPFPlugin pssyspfplugin = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSSysToolbarLock = new Integer(1);
    private PSSysToolbar pssystoolbar = null;
    private Integer objPSViewMsgGroupLock = new Integer(1);
    private PSViewMsgGroup psviewmsggroup = null;
    private Integer objPSDETBItemsLock = new Integer(1);
    private ArrayList<PSDETBItem> psdetbitems = null;
    private Integer objPSDEToolbarLogicsLock = new Integer(1);
    private ArrayList<PSDEToolbarLogic> psdetoolbarlogics = null;

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

    public void setIconAlign(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIconAlign(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.iconalign = string;
        this.iconalignDirtyFlag = true;
    }

    public String getIconAlign() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIconAlign();
        }
        return this.iconalign;
    }

    public boolean isIconAlignDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIconAlignDirty();
        }
        return this.iconalignDirtyFlag;
    }

    public void resetIconAlign() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIconAlign();
            return;
        }
        this.iconalignDirtyFlag = false;
        this.iconalign = null;
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

    public void setMobFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobFlag(n);
            return;
        }
        this.mobflag = n;
        this.mobflagDirtyFlag = true;
    }

    public Integer getMobFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobFlag();
        }
        return this.mobflag;
    }

    public boolean isMobFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobFlagDirty();
        }
        return this.mobflagDirtyFlag;
    }

    public void resetMobFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobFlag();
            return;
        }
        this.mobflagDirtyFlag = false;
        this.mobflag = null;
    }

    public void setNo2PSDEUAGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo2PSDEUAGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no2psdeuagroupid = string;
        this.no2psdeuagroupidDirtyFlag = true;
    }

    public String getNo2PSDEUAGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo2PSDEUAGroupId();
        }
        return this.no2psdeuagroupid;
    }

    public boolean isNo2PSDEUAGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo2PSDEUAGroupIdDirty();
        }
        return this.no2psdeuagroupidDirtyFlag;
    }

    public void resetNo2PSDEUAGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo2PSDEUAGroupId();
            return;
        }
        this.no2psdeuagroupidDirtyFlag = false;
        this.no2psdeuagroupid = null;
    }

    public void setNo2PSDEUAGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo2PSDEUAGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no2psdeuagroupname = string;
        this.no2psdeuagroupnameDirtyFlag = true;
    }

    public String getNo2PSDEUAGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo2PSDEUAGroupName();
        }
        return this.no2psdeuagroupname;
    }

    public boolean isNo2PSDEUAGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo2PSDEUAGroupNameDirty();
        }
        return this.no2psdeuagroupnameDirtyFlag;
    }

    public void resetNo2PSDEUAGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo2PSDEUAGroupName();
            return;
        }
        this.no2psdeuagroupnameDirtyFlag = false;
        this.no2psdeuagroupname = null;
    }

    public void setNo3PSDEUAGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo3PSDEUAGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no3psdeuagroupid = string;
        this.no3psdeuagroupidDirtyFlag = true;
    }

    public String getNo3PSDEUAGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo3PSDEUAGroupId();
        }
        return this.no3psdeuagroupid;
    }

    public boolean isNo3PSDEUAGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo3PSDEUAGroupIdDirty();
        }
        return this.no3psdeuagroupidDirtyFlag;
    }

    public void resetNo3PSDEUAGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo3PSDEUAGroupId();
            return;
        }
        this.no3psdeuagroupidDirtyFlag = false;
        this.no3psdeuagroupid = null;
    }

    public void setNo3PSDEUAGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo3PSDEUAGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no3psdeuagroupname = string;
        this.no3psdeuagroupnameDirtyFlag = true;
    }

    public String getNo3PSDEUAGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo3PSDEUAGroupName();
        }
        return this.no3psdeuagroupname;
    }

    public boolean isNo3PSDEUAGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo3PSDEUAGroupNameDirty();
        }
        return this.no3psdeuagroupnameDirtyFlag;
    }

    public void resetNo3PSDEUAGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo3PSDEUAGroupName();
            return;
        }
        this.no3psdeuagroupnameDirtyFlag = false;
        this.no3psdeuagroupname = null;
    }

    public void setNo4PSDEUAGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo4PSDEUAGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no4psdeuagroupid = string;
        this.no4psdeuagroupidDirtyFlag = true;
    }

    public String getNo4PSDEUAGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo4PSDEUAGroupId();
        }
        return this.no4psdeuagroupid;
    }

    public boolean isNo4PSDEUAGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo4PSDEUAGroupIdDirty();
        }
        return this.no4psdeuagroupidDirtyFlag;
    }

    public void resetNo4PSDEUAGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo4PSDEUAGroupId();
            return;
        }
        this.no4psdeuagroupidDirtyFlag = false;
        this.no4psdeuagroupid = null;
    }

    public void setNo4PSDEUAGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo4PSDEUAGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no4psdeuagroupname = string;
        this.no4psdeuagroupnameDirtyFlag = true;
    }

    public String getNo4PSDEUAGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo4PSDEUAGroupName();
        }
        return this.no4psdeuagroupname;
    }

    public boolean isNo4PSDEUAGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo4PSDEUAGroupNameDirty();
        }
        return this.no4psdeuagroupnameDirtyFlag;
    }

    public void resetNo4PSDEUAGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo4PSDEUAGroupName();
            return;
        }
        this.no4psdeuagroupnameDirtyFlag = false;
        this.no4psdeuagroupname = null;
    }

    public void setNo5PSDEUAGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo5PSDEUAGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no5psdeuagroupid = string;
        this.no5psdeuagroupidDirtyFlag = true;
    }

    public String getNo5PSDEUAGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo5PSDEUAGroupId();
        }
        return this.no5psdeuagroupid;
    }

    public boolean isNo5PSDEUAGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo5PSDEUAGroupIdDirty();
        }
        return this.no5psdeuagroupidDirtyFlag;
    }

    public void resetNo5PSDEUAGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo5PSDEUAGroupId();
            return;
        }
        this.no5psdeuagroupidDirtyFlag = false;
        this.no5psdeuagroupid = null;
    }

    public void setNo5PSDEUAGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo5PSDEUAGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no5psdeuagroupname = string;
        this.no5psdeuagroupnameDirtyFlag = true;
    }

    public String getNo5PSDEUAGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo5PSDEUAGroupName();
        }
        return this.no5psdeuagroupname;
    }

    public boolean isNo5PSDEUAGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo5PSDEUAGroupNameDirty();
        }
        return this.no5psdeuagroupnameDirtyFlag;
    }

    public void resetNo5PSDEUAGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo5PSDEUAGroupName();
            return;
        }
        this.no5psdeuagroupnameDirtyFlag = false;
        this.no5psdeuagroupname = null;
    }

    public void setNo6PSDEUAGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo6PSDEUAGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no6psdeuagroupid = string;
        this.no6psdeuagroupidDirtyFlag = true;
    }

    public String getNo6PSDEUAGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo6PSDEUAGroupId();
        }
        return this.no6psdeuagroupid;
    }

    public boolean isNo6PSDEUAGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo6PSDEUAGroupIdDirty();
        }
        return this.no6psdeuagroupidDirtyFlag;
    }

    public void resetNo6PSDEUAGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo6PSDEUAGroupId();
            return;
        }
        this.no6psdeuagroupidDirtyFlag = false;
        this.no6psdeuagroupid = null;
    }

    public void setNo6PSDEUAGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo6PSDEUAGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no6psdeuagroupname = string;
        this.no6psdeuagroupnameDirtyFlag = true;
    }

    public String getNo6PSDEUAGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo6PSDEUAGroupName();
        }
        return this.no6psdeuagroupname;
    }

    public boolean isNo6PSDEUAGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo6PSDEUAGroupNameDirty();
        }
        return this.no6psdeuagroupnameDirtyFlag;
    }

    public void resetNo6PSDEUAGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo6PSDEUAGroupName();
            return;
        }
        this.no6psdeuagroupnameDirtyFlag = false;
        this.no6psdeuagroupname = null;
    }

    public void setPSCtrlLogicGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlLogicGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrllogicgroupid = string;
        this.psctrllogicgroupidDirtyFlag = true;
    }

    public String getPSCtrlLogicGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlLogicGroupId();
        }
        return this.psctrllogicgroupid;
    }

    public boolean isPSCtrlLogicGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlLogicGroupIdDirty();
        }
        return this.psctrllogicgroupidDirtyFlag;
    }

    public void resetPSCtrlLogicGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlLogicGroupId();
            return;
        }
        this.psctrllogicgroupidDirtyFlag = false;
        this.psctrllogicgroupid = null;
    }

    public void setPSCtrlLogicGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlLogicGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrllogicgroupname = string;
        this.psctrllogicgroupnameDirtyFlag = true;
    }

    public String getPSCtrlLogicGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlLogicGroupName();
        }
        return this.psctrllogicgroupname;
    }

    public boolean isPSCtrlLogicGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlLogicGroupNameDirty();
        }
        return this.psctrllogicgroupnameDirtyFlag;
    }

    public void resetPSCtrlLogicGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlLogicGroupName();
            return;
        }
        this.psctrllogicgroupnameDirtyFlag = false;
        this.psctrllogicgroupname = null;
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

    public void setPSDEToolbarId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEToolbarId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdetoolbarid = string;
        this.psdetoolbaridDirtyFlag = true;
    }

    public String getPSDEToolbarId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEToolbarId();
        }
        return this.psdetoolbarid;
    }

    public boolean isPSDEToolbarIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEToolbarIdDirty();
        }
        return this.psdetoolbaridDirtyFlag;
    }

    public void resetPSDEToolbarId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEToolbarId();
            return;
        }
        this.psdetoolbaridDirtyFlag = false;
        this.psdetoolbarid = null;
    }

    public void setPSDEToolbarName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEToolbarName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdetoolbarname = string;
        this.psdetoolbarnameDirtyFlag = true;
    }

    public String getPSDEToolbarName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEToolbarName();
        }
        return this.psdetoolbarname;
    }

    public boolean isPSDEToolbarNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEToolbarNameDirty();
        }
        return this.psdetoolbarnameDirtyFlag;
    }

    public void resetPSDEToolbarName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEToolbarName();
            return;
        }
        this.psdetoolbarnameDirtyFlag = false;
        this.psdetoolbarname = null;
    }

    public void setPSDEUAGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEUAGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeuagroupid = string;
        this.psdeuagroupidDirtyFlag = true;
    }

    public String getPSDEUAGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUAGroupId();
        }
        return this.psdeuagroupid;
    }

    public boolean isPSDEUAGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEUAGroupIdDirty();
        }
        return this.psdeuagroupidDirtyFlag;
    }

    public void resetPSDEUAGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEUAGroupId();
            return;
        }
        this.psdeuagroupidDirtyFlag = false;
        this.psdeuagroupid = null;
    }

    public void setPSDEUAGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEUAGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeuagroupname = string;
        this.psdeuagroupnameDirtyFlag = true;
    }

    public String getPSDEUAGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUAGroupName();
        }
        return this.psdeuagroupname;
    }

    public boolean isPSDEUAGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEUAGroupNameDirty();
        }
        return this.psdeuagroupnameDirtyFlag;
    }

    public void resetPSDEUAGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEUAGroupName();
            return;
        }
        this.psdeuagroupnameDirtyFlag = false;
        this.psdeuagroupname = null;
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

    public void setPSSysCounterId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCounterId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscounterid = string;
        this.pssyscounteridDirtyFlag = true;
    }

    public String getPSSysCounterId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCounterId();
        }
        return this.pssyscounterid;
    }

    public boolean isPSSysCounterIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCounterIdDirty();
        }
        return this.pssyscounteridDirtyFlag;
    }

    public void resetPSSysCounterId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCounterId();
            return;
        }
        this.pssyscounteridDirtyFlag = false;
        this.pssyscounterid = null;
    }

    public void setPSSysCounterName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCounterName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscountername = string;
        this.pssyscounternameDirtyFlag = true;
    }

    public String getPSSysCounterName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCounterName();
        }
        return this.pssyscountername;
    }

    public boolean isPSSysCounterNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCounterNameDirty();
        }
        return this.pssyscounternameDirtyFlag;
    }

    public void resetPSSysCounterName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCounterName();
            return;
        }
        this.pssyscounternameDirtyFlag = false;
        this.pssyscountername = null;
    }

    public void setPSSysCssId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCssId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscssid = string;
        this.pssyscssidDirtyFlag = true;
    }

    public String getPSSysCssId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCssId();
        }
        return this.pssyscssid;
    }

    public boolean isPSSysCssIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCssIdDirty();
        }
        return this.pssyscssidDirtyFlag;
    }

    public void resetPSSysCssId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCssId();
            return;
        }
        this.pssyscssidDirtyFlag = false;
        this.pssyscssid = null;
    }

    public void setPSSysCssName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCssName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscssname = string;
        this.pssyscssnameDirtyFlag = true;
    }

    public String getPSSysCssName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCssName();
        }
        return this.pssyscssname;
    }

    public boolean isPSSysCssNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCssNameDirty();
        }
        return this.pssyscssnameDirtyFlag;
    }

    public void resetPSSysCssName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCssName();
            return;
        }
        this.pssyscssnameDirtyFlag = false;
        this.pssyscssname = null;
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

    public void setPSSysToolbarId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysToolbarId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystoolbarid = string;
        this.pssystoolbaridDirtyFlag = true;
    }

    public String getPSSysToolbarId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysToolbarId();
        }
        return this.pssystoolbarid;
    }

    public boolean isPSSysToolbarIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysToolbarIdDirty();
        }
        return this.pssystoolbaridDirtyFlag;
    }

    public void resetPSSysToolbarId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysToolbarId();
            return;
        }
        this.pssystoolbaridDirtyFlag = false;
        this.pssystoolbarid = null;
    }

    public void setPSSysToolbarName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysToolbarName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystoolbarname = string;
        this.pssystoolbarnameDirtyFlag = true;
    }

    public String getPSSysToolbarName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysToolbarName();
        }
        return this.pssystoolbarname;
    }

    public boolean isPSSysToolbarNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysToolbarNameDirty();
        }
        return this.pssystoolbarnameDirtyFlag;
    }

    public void resetPSSysToolbarName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysToolbarName();
            return;
        }
        this.pssystoolbarnameDirtyFlag = false;
        this.pssystoolbarname = null;
    }

    public void setPSViewMsgGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewMsgGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewmsggroupid = string;
        this.psviewmsggroupidDirtyFlag = true;
    }

    public String getPSViewMsgGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewMsgGroupId();
        }
        return this.psviewmsggroupid;
    }

    public boolean isPSViewMsgGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewMsgGroupIdDirty();
        }
        return this.psviewmsggroupidDirtyFlag;
    }

    public void resetPSViewMsgGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewMsgGroupId();
            return;
        }
        this.psviewmsggroupidDirtyFlag = false;
        this.psviewmsggroupid = null;
    }

    public void setPSViewMsgGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewMsgGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewmsggroupname = string;
        this.psviewmsggroupnameDirtyFlag = true;
    }

    public String getPSViewMsgGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewMsgGroupName();
        }
        return this.psviewmsggroupname;
    }

    public boolean isPSViewMsgGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewMsgGroupNameDirty();
        }
        return this.psviewmsggroupnameDirtyFlag;
    }

    public void resetPSViewMsgGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewMsgGroupName();
            return;
        }
        this.psviewmsggroupnameDirtyFlag = false;
        this.psviewmsggroupname = null;
    }

    public void setSysAppFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysAppFlag(n);
            return;
        }
        this.sysappflag = n;
        this.sysappflagDirtyFlag = true;
    }

    public Integer getSysAppFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysAppFlag();
        }
        return this.sysappflag;
    }

    public boolean isSysAppFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysAppFlagDirty();
        }
        return this.sysappflagDirtyFlag;
    }

    public void resetSysAppFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysAppFlag();
            return;
        }
        this.sysappflagDirtyFlag = false;
        this.sysappflag = null;
    }

    public void setTBModel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTBModel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tbmodel = string;
        this.tbmodelDirtyFlag = true;
    }

    public String getTBModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTBModel();
        }
        return this.tbmodel;
    }

    public boolean isTBModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTBModelDirty();
        }
        return this.tbmodelDirtyFlag;
    }

    public void resetTBModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTBModel();
            return;
        }
        this.tbmodelDirtyFlag = false;
        this.tbmodel = null;
    }

    public void setTemplToolbar(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplToolbar(n);
            return;
        }
        this.templtoolbar = n;
        this.templtoolbarDirtyFlag = true;
    }

    public Integer getTemplToolbar() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplToolbar();
        }
        return this.templtoolbar;
    }

    public boolean isTemplToolbarDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplToolbarDirty();
        }
        return this.templtoolbarDirtyFlag;
    }

    public void resetTemplToolbar() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplToolbar();
            return;
        }
        this.templtoolbarDirtyFlag = false;
        this.templtoolbar = null;
    }

    public void setToolbarSN(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setToolbarSN(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.toolbarsn = string;
        this.toolbarsnDirtyFlag = true;
    }

    public String getToolbarSN() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getToolbarSN();
        }
        return this.toolbarsn;
    }

    public boolean isToolbarSNDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isToolbarSNDirty();
        }
        return this.toolbarsnDirtyFlag;
    }

    public void resetToolbarSN() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetToolbarSN();
            return;
        }
        this.toolbarsnDirtyFlag = false;
        this.toolbarsn = null;
    }

    public void setToolbarStyle(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setToolbarStyle(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.toolbarstyle = string;
        this.toolbarstyleDirtyFlag = true;
    }

    public String getToolbarStyle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getToolbarStyle();
        }
        return this.toolbarstyle;
    }

    public boolean isToolbarStyleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isToolbarStyleDirty();
        }
        return this.toolbarstyleDirtyFlag;
    }

    public void resetToolbarStyle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetToolbarStyle();
            return;
        }
        this.toolbarstyleDirtyFlag = false;
        this.toolbarstyle = null;
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

    protected void onReset() {
        PSDEToolbarBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEToolbarBase pSDEToolbarBase) {
        pSDEToolbarBase.resetCodeName();
        pSDEToolbarBase.resetCreateDate();
        pSDEToolbarBase.resetCreateMan();
        pSDEToolbarBase.resetIconAlign();
        pSDEToolbarBase.resetLockFlag();
        pSDEToolbarBase.resetMemo();
        pSDEToolbarBase.resetMobFlag();
        pSDEToolbarBase.resetNo2PSDEUAGroupId();
        pSDEToolbarBase.resetNo2PSDEUAGroupName();
        pSDEToolbarBase.resetNo3PSDEUAGroupId();
        pSDEToolbarBase.resetNo3PSDEUAGroupName();
        pSDEToolbarBase.resetNo4PSDEUAGroupId();
        pSDEToolbarBase.resetNo4PSDEUAGroupName();
        pSDEToolbarBase.resetNo5PSDEUAGroupId();
        pSDEToolbarBase.resetNo5PSDEUAGroupName();
        pSDEToolbarBase.resetNo6PSDEUAGroupId();
        pSDEToolbarBase.resetNo6PSDEUAGroupName();
        pSDEToolbarBase.resetPSCtrlLogicGroupId();
        pSDEToolbarBase.resetPSCtrlLogicGroupName();
        pSDEToolbarBase.resetPSDEId();
        pSDEToolbarBase.resetPSDEName();
        pSDEToolbarBase.resetPSDEToolbarId();
        pSDEToolbarBase.resetPSDEToolbarName();
        pSDEToolbarBase.resetPSDEUAGroupId();
        pSDEToolbarBase.resetPSDEUAGroupName();
        pSDEToolbarBase.resetPSModuleId();
        pSDEToolbarBase.resetPSModuleName();
        pSDEToolbarBase.resetPSSysAppId();
        pSDEToolbarBase.resetPSSysAppName();
        pSDEToolbarBase.resetPSSysCounterId();
        pSDEToolbarBase.resetPSSysCounterName();
        pSDEToolbarBase.resetPSSysCssId();
        pSDEToolbarBase.resetPSSysCssName();
        pSDEToolbarBase.resetPSSysPFPluginId();
        pSDEToolbarBase.resetPSSysPFPluginName();
        pSDEToolbarBase.resetPSSystemId();
        pSDEToolbarBase.resetPSSystemName();
        pSDEToolbarBase.resetPSSysToolbarId();
        pSDEToolbarBase.resetPSSysToolbarName();
        pSDEToolbarBase.resetPSViewMsgGroupId();
        pSDEToolbarBase.resetPSViewMsgGroupName();
        pSDEToolbarBase.resetSysAppFlag();
        pSDEToolbarBase.resetTBModel();
        pSDEToolbarBase.resetTemplToolbar();
        pSDEToolbarBase.resetToolbarSN();
        pSDEToolbarBase.resetToolbarStyle();
        pSDEToolbarBase.resetUpdateDate();
        pSDEToolbarBase.resetUpdateMan();
        pSDEToolbarBase.resetUserParams();
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
        if (!bl || this.isIconAlignDirty()) {
            hashMap.put(FIELD_ICONALIGN, this.getIconAlign());
        }
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMobFlagDirty()) {
            hashMap.put(FIELD_MOBFLAG, this.getMobFlag());
        }
        if (!bl || this.isNo2PSDEUAGroupIdDirty()) {
            hashMap.put(FIELD_NO2PSDEUAGROUPID, this.getNo2PSDEUAGroupId());
        }
        if (!bl || this.isNo2PSDEUAGroupNameDirty()) {
            hashMap.put(FIELD_NO2PSDEUAGROUPNAME, this.getNo2PSDEUAGroupName());
        }
        if (!bl || this.isNo3PSDEUAGroupIdDirty()) {
            hashMap.put(FIELD_NO3PSDEUAGROUPID, this.getNo3PSDEUAGroupId());
        }
        if (!bl || this.isNo3PSDEUAGroupNameDirty()) {
            hashMap.put(FIELD_NO3PSDEUAGROUPNAME, this.getNo3PSDEUAGroupName());
        }
        if (!bl || this.isNo4PSDEUAGroupIdDirty()) {
            hashMap.put(FIELD_NO4PSDEUAGROUPID, this.getNo4PSDEUAGroupId());
        }
        if (!bl || this.isNo4PSDEUAGroupNameDirty()) {
            hashMap.put(FIELD_NO4PSDEUAGROUPNAME, this.getNo4PSDEUAGroupName());
        }
        if (!bl || this.isNo5PSDEUAGroupIdDirty()) {
            hashMap.put(FIELD_NO5PSDEUAGROUPID, this.getNo5PSDEUAGroupId());
        }
        if (!bl || this.isNo5PSDEUAGroupNameDirty()) {
            hashMap.put(FIELD_NO5PSDEUAGROUPNAME, this.getNo5PSDEUAGroupName());
        }
        if (!bl || this.isNo6PSDEUAGroupIdDirty()) {
            hashMap.put(FIELD_NO6PSDEUAGROUPID, this.getNo6PSDEUAGroupId());
        }
        if (!bl || this.isNo6PSDEUAGroupNameDirty()) {
            hashMap.put(FIELD_NO6PSDEUAGROUPNAME, this.getNo6PSDEUAGroupName());
        }
        if (!bl || this.isPSCtrlLogicGroupIdDirty()) {
            hashMap.put(FIELD_PSCTRLLOGICGROUPID, this.getPSCtrlLogicGroupId());
        }
        if (!bl || this.isPSCtrlLogicGroupNameDirty()) {
            hashMap.put(FIELD_PSCTRLLOGICGROUPNAME, this.getPSCtrlLogicGroupName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSDEToolbarIdDirty()) {
            hashMap.put(FIELD_PSDETOOLBARID, this.getPSDEToolbarId());
        }
        if (!bl || this.isPSDEToolbarNameDirty()) {
            hashMap.put(FIELD_PSDETOOLBARNAME, this.getPSDEToolbarName());
        }
        if (!bl || this.isPSDEUAGroupIdDirty()) {
            hashMap.put(FIELD_PSDEUAGROUPID, this.getPSDEUAGroupId());
        }
        if (!bl || this.isPSDEUAGroupNameDirty()) {
            hashMap.put(FIELD_PSDEUAGROUPNAME, this.getPSDEUAGroupName());
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
        if (!bl || this.isPSSysCounterIdDirty()) {
            hashMap.put(FIELD_PSSYSCOUNTERID, this.getPSSysCounterId());
        }
        if (!bl || this.isPSSysCounterNameDirty()) {
            hashMap.put(FIELD_PSSYSCOUNTERNAME, this.getPSSysCounterName());
        }
        if (!bl || this.isPSSysCssIdDirty()) {
            hashMap.put(FIELD_PSSYSCSSID, this.getPSSysCssId());
        }
        if (!bl || this.isPSSysCssNameDirty()) {
            hashMap.put(FIELD_PSSYSCSSNAME, this.getPSSysCssName());
        }
        if (!bl || this.isPSSysPFPluginIdDirty()) {
            hashMap.put(FIELD_PSSYSPFPLUGINID, this.getPSSysPFPluginId());
        }
        if (!bl || this.isPSSysPFPluginNameDirty()) {
            hashMap.put(FIELD_PSSYSPFPLUGINNAME, this.getPSSysPFPluginName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
        }
        if (!bl || this.isPSSysToolbarIdDirty()) {
            hashMap.put(FIELD_PSSYSTOOLBARID, this.getPSSysToolbarId());
        }
        if (!bl || this.isPSSysToolbarNameDirty()) {
            hashMap.put(FIELD_PSSYSTOOLBARNAME, this.getPSSysToolbarName());
        }
        if (!bl || this.isPSViewMsgGroupIdDirty()) {
            hashMap.put(FIELD_PSVIEWMSGGROUPID, this.getPSViewMsgGroupId());
        }
        if (!bl || this.isPSViewMsgGroupNameDirty()) {
            hashMap.put(FIELD_PSVIEWMSGGROUPNAME, this.getPSViewMsgGroupName());
        }
        if (!bl || this.isSysAppFlagDirty()) {
            hashMap.put(FIELD_SYSAPPFLAG, this.getSysAppFlag());
        }
        if (!bl || this.isTBModelDirty()) {
            hashMap.put(FIELD_TBMODEL, this.getTBModel());
        }
        if (!bl || this.isTemplToolbarDirty()) {
            hashMap.put(FIELD_TEMPLTOOLBAR, this.getTemplToolbar());
        }
        if (!bl || this.isToolbarSNDirty()) {
            hashMap.put(FIELD_TOOLBARSN, this.getToolbarSN());
        }
        if (!bl || this.isToolbarStyleDirty()) {
            hashMap.put(FIELD_TOOLBARSTYLE, this.getToolbarStyle());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserParamsDirty()) {
            hashMap.put(FIELD_USERPARAMS, this.getUserParams());
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
        return PSDEToolbarBase.get(this, n);
    }

    private static Object get(PSDEToolbarBase pSDEToolbarBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEToolbarBase.getCodeName();
            }
            case 1: {
                return pSDEToolbarBase.getCreateDate();
            }
            case 2: {
                return pSDEToolbarBase.getCreateMan();
            }
            case 3: {
                return pSDEToolbarBase.getIconAlign();
            }
            case 4: {
                return pSDEToolbarBase.getLockFlag();
            }
            case 5: {
                return pSDEToolbarBase.getMemo();
            }
            case 6: {
                return pSDEToolbarBase.getMobFlag();
            }
            case 7: {
                return pSDEToolbarBase.getNo2PSDEUAGroupId();
            }
            case 8: {
                return pSDEToolbarBase.getNo2PSDEUAGroupName();
            }
            case 9: {
                return pSDEToolbarBase.getNo3PSDEUAGroupId();
            }
            case 10: {
                return pSDEToolbarBase.getNo3PSDEUAGroupName();
            }
            case 11: {
                return pSDEToolbarBase.getNo4PSDEUAGroupId();
            }
            case 12: {
                return pSDEToolbarBase.getNo4PSDEUAGroupName();
            }
            case 13: {
                return pSDEToolbarBase.getNo5PSDEUAGroupId();
            }
            case 14: {
                return pSDEToolbarBase.getNo5PSDEUAGroupName();
            }
            case 15: {
                return pSDEToolbarBase.getNo6PSDEUAGroupId();
            }
            case 16: {
                return pSDEToolbarBase.getNo6PSDEUAGroupName();
            }
            case 17: {
                return pSDEToolbarBase.getPSCtrlLogicGroupId();
            }
            case 18: {
                return pSDEToolbarBase.getPSCtrlLogicGroupName();
            }
            case 19: {
                return pSDEToolbarBase.getPSDEId();
            }
            case 20: {
                return pSDEToolbarBase.getPSDEName();
            }
            case 21: {
                return pSDEToolbarBase.getPSDEToolbarId();
            }
            case 22: {
                return pSDEToolbarBase.getPSDEToolbarName();
            }
            case 23: {
                return pSDEToolbarBase.getPSDEUAGroupId();
            }
            case 24: {
                return pSDEToolbarBase.getPSDEUAGroupName();
            }
            case 25: {
                return pSDEToolbarBase.getPSModuleId();
            }
            case 26: {
                return pSDEToolbarBase.getPSModuleName();
            }
            case 27: {
                return pSDEToolbarBase.getPSSysAppId();
            }
            case 28: {
                return pSDEToolbarBase.getPSSysAppName();
            }
            case 29: {
                return pSDEToolbarBase.getPSSysCounterId();
            }
            case 30: {
                return pSDEToolbarBase.getPSSysCounterName();
            }
            case 31: {
                return pSDEToolbarBase.getPSSysCssId();
            }
            case 32: {
                return pSDEToolbarBase.getPSSysCssName();
            }
            case 33: {
                return pSDEToolbarBase.getPSSysPFPluginId();
            }
            case 34: {
                return pSDEToolbarBase.getPSSysPFPluginName();
            }
            case 35: {
                return pSDEToolbarBase.getPSSystemId();
            }
            case 36: {
                return pSDEToolbarBase.getPSSystemName();
            }
            case 37: {
                return pSDEToolbarBase.getPSSysToolbarId();
            }
            case 38: {
                return pSDEToolbarBase.getPSSysToolbarName();
            }
            case 39: {
                return pSDEToolbarBase.getPSViewMsgGroupId();
            }
            case 40: {
                return pSDEToolbarBase.getPSViewMsgGroupName();
            }
            case 41: {
                return pSDEToolbarBase.getSysAppFlag();
            }
            case 42: {
                return pSDEToolbarBase.getTBModel();
            }
            case 43: {
                return pSDEToolbarBase.getTemplToolbar();
            }
            case 44: {
                return pSDEToolbarBase.getToolbarSN();
            }
            case 45: {
                return pSDEToolbarBase.getToolbarStyle();
            }
            case 46: {
                return pSDEToolbarBase.getUpdateDate();
            }
            case 47: {
                return pSDEToolbarBase.getUpdateMan();
            }
            case 48: {
                return pSDEToolbarBase.getUserParams();
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
        PSDEToolbarBase.set(this, n, object);
    }

    private static void set(PSDEToolbarBase pSDEToolbarBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEToolbarBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDEToolbarBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDEToolbarBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEToolbarBase.setIconAlign(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEToolbarBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSDEToolbarBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEToolbarBase.setMobFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSDEToolbarBase.setNo2PSDEUAGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEToolbarBase.setNo2PSDEUAGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEToolbarBase.setNo3PSDEUAGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEToolbarBase.setNo3PSDEUAGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEToolbarBase.setNo4PSDEUAGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEToolbarBase.setNo4PSDEUAGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEToolbarBase.setNo5PSDEUAGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEToolbarBase.setNo5PSDEUAGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEToolbarBase.setNo6PSDEUAGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEToolbarBase.setNo6PSDEUAGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEToolbarBase.setPSCtrlLogicGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEToolbarBase.setPSCtrlLogicGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEToolbarBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDEToolbarBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEToolbarBase.setPSDEToolbarId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDEToolbarBase.setPSDEToolbarName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDEToolbarBase.setPSDEUAGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDEToolbarBase.setPSDEUAGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDEToolbarBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDEToolbarBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDEToolbarBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDEToolbarBase.setPSSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDEToolbarBase.setPSSysCounterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDEToolbarBase.setPSSysCounterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDEToolbarBase.setPSSysCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDEToolbarBase.setPSSysCssName(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDEToolbarBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDEToolbarBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDEToolbarBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDEToolbarBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSDEToolbarBase.setPSSysToolbarId(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDEToolbarBase.setPSSysToolbarName(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSDEToolbarBase.setPSViewMsgGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSDEToolbarBase.setPSViewMsgGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSDEToolbarBase.setSysAppFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 42: {
                pSDEToolbarBase.setTBModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSDEToolbarBase.setTemplToolbar(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 44: {
                pSDEToolbarBase.setToolbarSN(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSDEToolbarBase.setToolbarStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSDEToolbarBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 47: {
                pSDEToolbarBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSDEToolbarBase.setUserParams(DataObject.getStringValue((Object)object));
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
        return PSDEToolbarBase.isNull(this, n);
    }

    private static boolean isNull(PSDEToolbarBase pSDEToolbarBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEToolbarBase.getCodeName() == null;
            }
            case 1: {
                return pSDEToolbarBase.getCreateDate() == null;
            }
            case 2: {
                return pSDEToolbarBase.getCreateMan() == null;
            }
            case 3: {
                return pSDEToolbarBase.getIconAlign() == null;
            }
            case 4: {
                return pSDEToolbarBase.getLockFlag() == null;
            }
            case 5: {
                return pSDEToolbarBase.getMemo() == null;
            }
            case 6: {
                return pSDEToolbarBase.getMobFlag() == null;
            }
            case 7: {
                return pSDEToolbarBase.getNo2PSDEUAGroupId() == null;
            }
            case 8: {
                return pSDEToolbarBase.getNo2PSDEUAGroupName() == null;
            }
            case 9: {
                return pSDEToolbarBase.getNo3PSDEUAGroupId() == null;
            }
            case 10: {
                return pSDEToolbarBase.getNo3PSDEUAGroupName() == null;
            }
            case 11: {
                return pSDEToolbarBase.getNo4PSDEUAGroupId() == null;
            }
            case 12: {
                return pSDEToolbarBase.getNo4PSDEUAGroupName() == null;
            }
            case 13: {
                return pSDEToolbarBase.getNo5PSDEUAGroupId() == null;
            }
            case 14: {
                return pSDEToolbarBase.getNo5PSDEUAGroupName() == null;
            }
            case 15: {
                return pSDEToolbarBase.getNo6PSDEUAGroupId() == null;
            }
            case 16: {
                return pSDEToolbarBase.getNo6PSDEUAGroupName() == null;
            }
            case 17: {
                return pSDEToolbarBase.getPSCtrlLogicGroupId() == null;
            }
            case 18: {
                return pSDEToolbarBase.getPSCtrlLogicGroupName() == null;
            }
            case 19: {
                return pSDEToolbarBase.getPSDEId() == null;
            }
            case 20: {
                return pSDEToolbarBase.getPSDEName() == null;
            }
            case 21: {
                return pSDEToolbarBase.getPSDEToolbarId() == null;
            }
            case 22: {
                return pSDEToolbarBase.getPSDEToolbarName() == null;
            }
            case 23: {
                return pSDEToolbarBase.getPSDEUAGroupId() == null;
            }
            case 24: {
                return pSDEToolbarBase.getPSDEUAGroupName() == null;
            }
            case 25: {
                return pSDEToolbarBase.getPSModuleId() == null;
            }
            case 26: {
                return pSDEToolbarBase.getPSModuleName() == null;
            }
            case 27: {
                return pSDEToolbarBase.getPSSysAppId() == null;
            }
            case 28: {
                return pSDEToolbarBase.getPSSysAppName() == null;
            }
            case 29: {
                return pSDEToolbarBase.getPSSysCounterId() == null;
            }
            case 30: {
                return pSDEToolbarBase.getPSSysCounterName() == null;
            }
            case 31: {
                return pSDEToolbarBase.getPSSysCssId() == null;
            }
            case 32: {
                return pSDEToolbarBase.getPSSysCssName() == null;
            }
            case 33: {
                return pSDEToolbarBase.getPSSysPFPluginId() == null;
            }
            case 34: {
                return pSDEToolbarBase.getPSSysPFPluginName() == null;
            }
            case 35: {
                return pSDEToolbarBase.getPSSystemId() == null;
            }
            case 36: {
                return pSDEToolbarBase.getPSSystemName() == null;
            }
            case 37: {
                return pSDEToolbarBase.getPSSysToolbarId() == null;
            }
            case 38: {
                return pSDEToolbarBase.getPSSysToolbarName() == null;
            }
            case 39: {
                return pSDEToolbarBase.getPSViewMsgGroupId() == null;
            }
            case 40: {
                return pSDEToolbarBase.getPSViewMsgGroupName() == null;
            }
            case 41: {
                return pSDEToolbarBase.getSysAppFlag() == null;
            }
            case 42: {
                return pSDEToolbarBase.getTBModel() == null;
            }
            case 43: {
                return pSDEToolbarBase.getTemplToolbar() == null;
            }
            case 44: {
                return pSDEToolbarBase.getToolbarSN() == null;
            }
            case 45: {
                return pSDEToolbarBase.getToolbarStyle() == null;
            }
            case 46: {
                return pSDEToolbarBase.getUpdateDate() == null;
            }
            case 47: {
                return pSDEToolbarBase.getUpdateMan() == null;
            }
            case 48: {
                return pSDEToolbarBase.getUserParams() == null;
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
        return PSDEToolbarBase.contains(this, n);
    }

    private static boolean contains(PSDEToolbarBase pSDEToolbarBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEToolbarBase.isCodeNameDirty();
            }
            case 1: {
                return pSDEToolbarBase.isCreateDateDirty();
            }
            case 2: {
                return pSDEToolbarBase.isCreateManDirty();
            }
            case 3: {
                return pSDEToolbarBase.isIconAlignDirty();
            }
            case 4: {
                return pSDEToolbarBase.isLockFlagDirty();
            }
            case 5: {
                return pSDEToolbarBase.isMemoDirty();
            }
            case 6: {
                return pSDEToolbarBase.isMobFlagDirty();
            }
            case 7: {
                return pSDEToolbarBase.isNo2PSDEUAGroupIdDirty();
            }
            case 8: {
                return pSDEToolbarBase.isNo2PSDEUAGroupNameDirty();
            }
            case 9: {
                return pSDEToolbarBase.isNo3PSDEUAGroupIdDirty();
            }
            case 10: {
                return pSDEToolbarBase.isNo3PSDEUAGroupNameDirty();
            }
            case 11: {
                return pSDEToolbarBase.isNo4PSDEUAGroupIdDirty();
            }
            case 12: {
                return pSDEToolbarBase.isNo4PSDEUAGroupNameDirty();
            }
            case 13: {
                return pSDEToolbarBase.isNo5PSDEUAGroupIdDirty();
            }
            case 14: {
                return pSDEToolbarBase.isNo5PSDEUAGroupNameDirty();
            }
            case 15: {
                return pSDEToolbarBase.isNo6PSDEUAGroupIdDirty();
            }
            case 16: {
                return pSDEToolbarBase.isNo6PSDEUAGroupNameDirty();
            }
            case 17: {
                return pSDEToolbarBase.isPSCtrlLogicGroupIdDirty();
            }
            case 18: {
                return pSDEToolbarBase.isPSCtrlLogicGroupNameDirty();
            }
            case 19: {
                return pSDEToolbarBase.isPSDEIdDirty();
            }
            case 20: {
                return pSDEToolbarBase.isPSDENameDirty();
            }
            case 21: {
                return pSDEToolbarBase.isPSDEToolbarIdDirty();
            }
            case 22: {
                return pSDEToolbarBase.isPSDEToolbarNameDirty();
            }
            case 23: {
                return pSDEToolbarBase.isPSDEUAGroupIdDirty();
            }
            case 24: {
                return pSDEToolbarBase.isPSDEUAGroupNameDirty();
            }
            case 25: {
                return pSDEToolbarBase.isPSModuleIdDirty();
            }
            case 26: {
                return pSDEToolbarBase.isPSModuleNameDirty();
            }
            case 27: {
                return pSDEToolbarBase.isPSSysAppIdDirty();
            }
            case 28: {
                return pSDEToolbarBase.isPSSysAppNameDirty();
            }
            case 29: {
                return pSDEToolbarBase.isPSSysCounterIdDirty();
            }
            case 30: {
                return pSDEToolbarBase.isPSSysCounterNameDirty();
            }
            case 31: {
                return pSDEToolbarBase.isPSSysCssIdDirty();
            }
            case 32: {
                return pSDEToolbarBase.isPSSysCssNameDirty();
            }
            case 33: {
                return pSDEToolbarBase.isPSSysPFPluginIdDirty();
            }
            case 34: {
                return pSDEToolbarBase.isPSSysPFPluginNameDirty();
            }
            case 35: {
                return pSDEToolbarBase.isPSSystemIdDirty();
            }
            case 36: {
                return pSDEToolbarBase.isPSSystemNameDirty();
            }
            case 37: {
                return pSDEToolbarBase.isPSSysToolbarIdDirty();
            }
            case 38: {
                return pSDEToolbarBase.isPSSysToolbarNameDirty();
            }
            case 39: {
                return pSDEToolbarBase.isPSViewMsgGroupIdDirty();
            }
            case 40: {
                return pSDEToolbarBase.isPSViewMsgGroupNameDirty();
            }
            case 41: {
                return pSDEToolbarBase.isSysAppFlagDirty();
            }
            case 42: {
                return pSDEToolbarBase.isTBModelDirty();
            }
            case 43: {
                return pSDEToolbarBase.isTemplToolbarDirty();
            }
            case 44: {
                return pSDEToolbarBase.isToolbarSNDirty();
            }
            case 45: {
                return pSDEToolbarBase.isToolbarStyleDirty();
            }
            case 46: {
                return pSDEToolbarBase.isUpdateDateDirty();
            }
            case 47: {
                return pSDEToolbarBase.isUpdateManDirty();
            }
            case 48: {
                return pSDEToolbarBase.isUserParamsDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEToolbarBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEToolbarBase pSDEToolbarBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEToolbarBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDEToolbarBase.getJSONValue((Object)pSDEToolbarBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDEToolbarBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEToolbarBase.getJSONValue((Object)pSDEToolbarBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEToolbarBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEToolbarBase.getJSONValue((Object)pSDEToolbarBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEToolbarBase.getIconAlign() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"iconalign", (Object)PSDEToolbarBase.getJSONValue((Object)pSDEToolbarBase.getIconAlign()), (boolean)false);
        }
        if (bl || pSDEToolbarBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSDEToolbarBase.getJSONValue((Object)pSDEToolbarBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSDEToolbarBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEToolbarBase.getJSONValue((Object)pSDEToolbarBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEToolbarBase.getMobFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobflag", (Object)PSDEToolbarBase.getJSONValue((Object)pSDEToolbarBase.getMobFlag()), (boolean)false);
        }
        if (bl || pSDEToolbarBase.getNo2PSDEUAGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no2psdeuagroupid", (Object)PSDEToolbarBase.getJSONValue((Object)pSDEToolbarBase.getNo2PSDEUAGroupId()), (boolean)false);
        }
        if (bl || pSDEToolbarBase.getNo2PSDEUAGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no2psdeuagroupname", (Object)PSDEToolbarBase.getJSONValue((Object)pSDEToolbarBase.getNo2PSDEUAGroupName()), (boolean)false);
        }
        if (bl || pSDEToolbarBase.getNo3PSDEUAGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no3psdeuagroupid", (Object)PSDEToolbarBase.getJSONValue((Object)pSDEToolbarBase.getNo3PSDEUAGroupId()), (boolean)false);
        }
        if (bl || pSDEToolbarBase.getNo3PSDEUAGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no3psdeuagroupname", (Object)PSDEToolbarBase.getJSONValue((Object)pSDEToolbarBase.getNo3PSDEUAGroupName()), (boolean)false);
        }
        if (bl || pSDEToolbarBase.getNo4PSDEUAGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no4psdeuagroupid", (Object)PSDEToolbarBase.getJSONValue((Object)pSDEToolbarBase.getNo4PSDEUAGroupId()), (boolean)false);
        }
        if (bl || pSDEToolbarBase.getNo4PSDEUAGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no4psdeuagroupname", (Object)PSDEToolbarBase.getJSONValue((Object)pSDEToolbarBase.getNo4PSDEUAGroupName()), (boolean)false);
        }
        if (bl || pSDEToolbarBase.getNo5PSDEUAGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no5psdeuagroupid", (Object)PSDEToolbarBase.getJSONValue((Object)pSDEToolbarBase.getNo5PSDEUAGroupId()), (boolean)false);
        }
        if (bl || pSDEToolbarBase.getNo5PSDEUAGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no5psdeuagroupname", (Object)PSDEToolbarBase.getJSONValue((Object)pSDEToolbarBase.getNo5PSDEUAGroupName()), (boolean)false);
        }
        if (bl || pSDEToolbarBase.getNo6PSDEUAGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no6psdeuagroupid", (Object)PSDEToolbarBase.getJSONValue((Object)pSDEToolbarBase.getNo6PSDEUAGroupId()), (boolean)false);
        }
        if (bl || pSDEToolbarBase.getNo6PSDEUAGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no6psdeuagroupname", (Object)PSDEToolbarBase.getJSONValue((Object)pSDEToolbarBase.getNo6PSDEUAGroupName()), (boolean)false);
        }
        if (bl || pSDEToolbarBase.getPSCtrlLogicGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrllogicgroupid", (Object)PSDEToolbarBase.getJSONValue((Object)pSDEToolbarBase.getPSCtrlLogicGroupId()), (boolean)false);
        }
        if (bl || pSDEToolbarBase.getPSCtrlLogicGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrllogicgroupname", (Object)PSDEToolbarBase.getJSONValue((Object)pSDEToolbarBase.getPSCtrlLogicGroupName()), (boolean)false);
        }
        if (bl || pSDEToolbarBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEToolbarBase.getJSONValue((Object)pSDEToolbarBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEToolbarBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDEToolbarBase.getJSONValue((Object)pSDEToolbarBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDEToolbarBase.getPSDEToolbarId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetoolbarid", (Object)PSDEToolbarBase.getJSONValue((Object)pSDEToolbarBase.getPSDEToolbarId()), (boolean)false);
        }
        if (bl || pSDEToolbarBase.getPSDEToolbarName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetoolbarname", (Object)PSDEToolbarBase.getJSONValue((Object)pSDEToolbarBase.getPSDEToolbarName()), (boolean)false);
        }
        if (bl || pSDEToolbarBase.getPSDEUAGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuagroupid", (Object)PSDEToolbarBase.getJSONValue((Object)pSDEToolbarBase.getPSDEUAGroupId()), (boolean)false);
        }
        if (bl || pSDEToolbarBase.getPSDEUAGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuagroupname", (Object)PSDEToolbarBase.getJSONValue((Object)pSDEToolbarBase.getPSDEUAGroupName()), (boolean)false);
        }
        if (bl || pSDEToolbarBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSDEToolbarBase.getJSONValue((Object)pSDEToolbarBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSDEToolbarBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSDEToolbarBase.getJSONValue((Object)pSDEToolbarBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSDEToolbarBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSDEToolbarBase.getJSONValue((Object)pSDEToolbarBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSDEToolbarBase.getPSSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappname", (Object)PSDEToolbarBase.getJSONValue((Object)pSDEToolbarBase.getPSSysAppName()), (boolean)false);
        }
        if (bl || pSDEToolbarBase.getPSSysCounterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscounterid", (Object)PSDEToolbarBase.getJSONValue((Object)pSDEToolbarBase.getPSSysCounterId()), (boolean)false);
        }
        if (bl || pSDEToolbarBase.getPSSysCounterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscountername", (Object)PSDEToolbarBase.getJSONValue((Object)pSDEToolbarBase.getPSSysCounterName()), (boolean)false);
        }
        if (bl || pSDEToolbarBase.getPSSysCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssid", (Object)PSDEToolbarBase.getJSONValue((Object)pSDEToolbarBase.getPSSysCssId()), (boolean)false);
        }
        if (bl || pSDEToolbarBase.getPSSysCssName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssname", (Object)PSDEToolbarBase.getJSONValue((Object)pSDEToolbarBase.getPSSysCssName()), (boolean)false);
        }
        if (bl || pSDEToolbarBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSDEToolbarBase.getJSONValue((Object)pSDEToolbarBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSDEToolbarBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSDEToolbarBase.getJSONValue((Object)pSDEToolbarBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSDEToolbarBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSDEToolbarBase.getJSONValue((Object)pSDEToolbarBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSDEToolbarBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSDEToolbarBase.getJSONValue((Object)pSDEToolbarBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSDEToolbarBase.getPSSysToolbarId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystoolbarid", (Object)PSDEToolbarBase.getJSONValue((Object)pSDEToolbarBase.getPSSysToolbarId()), (boolean)false);
        }
        if (bl || pSDEToolbarBase.getPSSysToolbarName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystoolbarname", (Object)PSDEToolbarBase.getJSONValue((Object)pSDEToolbarBase.getPSSysToolbarName()), (boolean)false);
        }
        if (bl || pSDEToolbarBase.getPSViewMsgGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewmsggroupid", (Object)PSDEToolbarBase.getJSONValue((Object)pSDEToolbarBase.getPSViewMsgGroupId()), (boolean)false);
        }
        if (bl || pSDEToolbarBase.getPSViewMsgGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewmsggroupname", (Object)PSDEToolbarBase.getJSONValue((Object)pSDEToolbarBase.getPSViewMsgGroupName()), (boolean)false);
        }
        if (bl || pSDEToolbarBase.getSysAppFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sysappflag", (Object)PSDEToolbarBase.getJSONValue((Object)pSDEToolbarBase.getSysAppFlag()), (boolean)false);
        }
        if (bl || pSDEToolbarBase.getTBModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tbmodel", (Object)PSDEToolbarBase.getJSONValue((Object)pSDEToolbarBase.getTBModel()), (boolean)false);
        }
        if (bl || pSDEToolbarBase.getTemplToolbar() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templtoolbar", (Object)PSDEToolbarBase.getJSONValue((Object)pSDEToolbarBase.getTemplToolbar()), (boolean)false);
        }
        if (bl || pSDEToolbarBase.getToolbarSN() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"toolbarsn", (Object)PSDEToolbarBase.getJSONValue((Object)pSDEToolbarBase.getToolbarSN()), (boolean)false);
        }
        if (bl || pSDEToolbarBase.getToolbarStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"toolbarstyle", (Object)PSDEToolbarBase.getJSONValue((Object)pSDEToolbarBase.getToolbarStyle()), (boolean)false);
        }
        if (bl || pSDEToolbarBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEToolbarBase.getJSONValue((Object)pSDEToolbarBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEToolbarBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEToolbarBase.getJSONValue((Object)pSDEToolbarBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEToolbarBase.getUserParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userparams", (Object)PSDEToolbarBase.getJSONValue((Object)pSDEToolbarBase.getUserParams()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEToolbarBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEToolbarBase pSDEToolbarBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEToolbarBase.getCodeName() != null) {
            object = pSDEToolbarBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarBase.getCreateDate() != null) {
            object = pSDEToolbarBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEToolbarBase.getCreateMan() != null) {
            object = pSDEToolbarBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarBase.getIconAlign() != null) {
            object = pSDEToolbarBase.getIconAlign();
            xmlNode.setAttribute(FIELD_ICONALIGN, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarBase.getLockFlag() != null) {
            object = pSDEToolbarBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEToolbarBase.getMemo() != null) {
            object = pSDEToolbarBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarBase.getMobFlag() != null) {
            object = pSDEToolbarBase.getMobFlag();
            xmlNode.setAttribute(FIELD_MOBFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEToolbarBase.getNo2PSDEUAGroupId() != null) {
            object = pSDEToolbarBase.getNo2PSDEUAGroupId();
            xmlNode.setAttribute(FIELD_NO2PSDEUAGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarBase.getNo2PSDEUAGroupName() != null) {
            object = pSDEToolbarBase.getNo2PSDEUAGroupName();
            xmlNode.setAttribute(FIELD_NO2PSDEUAGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarBase.getNo3PSDEUAGroupId() != null) {
            object = pSDEToolbarBase.getNo3PSDEUAGroupId();
            xmlNode.setAttribute(FIELD_NO3PSDEUAGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarBase.getNo3PSDEUAGroupName() != null) {
            object = pSDEToolbarBase.getNo3PSDEUAGroupName();
            xmlNode.setAttribute(FIELD_NO3PSDEUAGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarBase.getNo4PSDEUAGroupId() != null) {
            object = pSDEToolbarBase.getNo4PSDEUAGroupId();
            xmlNode.setAttribute(FIELD_NO4PSDEUAGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarBase.getNo4PSDEUAGroupName() != null) {
            object = pSDEToolbarBase.getNo4PSDEUAGroupName();
            xmlNode.setAttribute(FIELD_NO4PSDEUAGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarBase.getNo5PSDEUAGroupId() != null) {
            object = pSDEToolbarBase.getNo5PSDEUAGroupId();
            xmlNode.setAttribute(FIELD_NO5PSDEUAGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarBase.getNo5PSDEUAGroupName() != null) {
            object = pSDEToolbarBase.getNo5PSDEUAGroupName();
            xmlNode.setAttribute(FIELD_NO5PSDEUAGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarBase.getNo6PSDEUAGroupId() != null) {
            object = pSDEToolbarBase.getNo6PSDEUAGroupId();
            xmlNode.setAttribute(FIELD_NO6PSDEUAGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarBase.getNo6PSDEUAGroupName() != null) {
            object = pSDEToolbarBase.getNo6PSDEUAGroupName();
            xmlNode.setAttribute(FIELD_NO6PSDEUAGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarBase.getPSCtrlLogicGroupId() != null) {
            object = pSDEToolbarBase.getPSCtrlLogicGroupId();
            xmlNode.setAttribute(FIELD_PSCTRLLOGICGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarBase.getPSCtrlLogicGroupName() != null) {
            object = pSDEToolbarBase.getPSCtrlLogicGroupName();
            xmlNode.setAttribute(FIELD_PSCTRLLOGICGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarBase.getPSDEId() != null) {
            object = pSDEToolbarBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarBase.getPSDEName() != null) {
            object = pSDEToolbarBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarBase.getPSDEToolbarId() != null) {
            object = pSDEToolbarBase.getPSDEToolbarId();
            xmlNode.setAttribute(FIELD_PSDETOOLBARID, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarBase.getPSDEToolbarName() != null) {
            object = pSDEToolbarBase.getPSDEToolbarName();
            xmlNode.setAttribute(FIELD_PSDETOOLBARNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarBase.getPSDEUAGroupId() != null) {
            object = pSDEToolbarBase.getPSDEUAGroupId();
            xmlNode.setAttribute(FIELD_PSDEUAGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarBase.getPSDEUAGroupName() != null) {
            object = pSDEToolbarBase.getPSDEUAGroupName();
            xmlNode.setAttribute(FIELD_PSDEUAGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarBase.getPSModuleId() != null) {
            object = pSDEToolbarBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarBase.getPSModuleName() != null) {
            object = pSDEToolbarBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarBase.getPSSysAppId() != null) {
            object = pSDEToolbarBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarBase.getPSSysAppName() != null) {
            object = pSDEToolbarBase.getPSSysAppName();
            xmlNode.setAttribute(FIELD_PSSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarBase.getPSSysCounterId() != null) {
            object = pSDEToolbarBase.getPSSysCounterId();
            xmlNode.setAttribute(FIELD_PSSYSCOUNTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarBase.getPSSysCounterName() != null) {
            object = pSDEToolbarBase.getPSSysCounterName();
            xmlNode.setAttribute(FIELD_PSSYSCOUNTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarBase.getPSSysCssId() != null) {
            object = pSDEToolbarBase.getPSSysCssId();
            xmlNode.setAttribute(FIELD_PSSYSCSSID, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarBase.getPSSysCssName() != null) {
            object = pSDEToolbarBase.getPSSysCssName();
            xmlNode.setAttribute(FIELD_PSSYSCSSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarBase.getPSSysPFPluginId() != null) {
            object = pSDEToolbarBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarBase.getPSSysPFPluginName() != null) {
            object = pSDEToolbarBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarBase.getPSSystemId() != null) {
            object = pSDEToolbarBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarBase.getPSSystemName() != null) {
            object = pSDEToolbarBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarBase.getPSSysToolbarId() != null) {
            object = pSDEToolbarBase.getPSSysToolbarId();
            xmlNode.setAttribute(FIELD_PSSYSTOOLBARID, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarBase.getPSSysToolbarName() != null) {
            object = pSDEToolbarBase.getPSSysToolbarName();
            xmlNode.setAttribute(FIELD_PSSYSTOOLBARNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarBase.getPSViewMsgGroupId() != null) {
            object = pSDEToolbarBase.getPSViewMsgGroupId();
            xmlNode.setAttribute(FIELD_PSVIEWMSGGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarBase.getPSViewMsgGroupName() != null) {
            object = pSDEToolbarBase.getPSViewMsgGroupName();
            xmlNode.setAttribute(FIELD_PSVIEWMSGGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarBase.getSysAppFlag() != null) {
            object = pSDEToolbarBase.getSysAppFlag();
            xmlNode.setAttribute(FIELD_SYSAPPFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEToolbarBase.getTBModel() != null) {
            object = pSDEToolbarBase.getTBModel();
            xmlNode.setAttribute(FIELD_TBMODEL, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarBase.getTemplToolbar() != null) {
            object = pSDEToolbarBase.getTemplToolbar();
            xmlNode.setAttribute(FIELD_TEMPLTOOLBAR, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEToolbarBase.getToolbarSN() != null) {
            object = pSDEToolbarBase.getToolbarSN();
            xmlNode.setAttribute(FIELD_TOOLBARSN, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarBase.getToolbarStyle() != null) {
            object = pSDEToolbarBase.getToolbarStyle();
            xmlNode.setAttribute(FIELD_TOOLBARSTYLE, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarBase.getUpdateDate() != null) {
            object = pSDEToolbarBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEToolbarBase.getUpdateMan() != null) {
            object = pSDEToolbarBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarBase.getUserParams() != null) {
            object = pSDEToolbarBase.getUserParams();
            xmlNode.setAttribute(FIELD_USERPARAMS, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEToolbarBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEToolbarBase pSDEToolbarBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEToolbarBase.isCodeNameDirty() && (bl || pSDEToolbarBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDEToolbarBase.getCodeName());
        }
        if (pSDEToolbarBase.isCreateDateDirty() && (bl || pSDEToolbarBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEToolbarBase.getCreateDate());
        }
        if (pSDEToolbarBase.isCreateManDirty() && (bl || pSDEToolbarBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEToolbarBase.getCreateMan());
        }
        if (pSDEToolbarBase.isIconAlignDirty() && (bl || pSDEToolbarBase.getIconAlign() != null)) {
            iDataObject.set(FIELD_ICONALIGN, (Object)pSDEToolbarBase.getIconAlign());
        }
        if (pSDEToolbarBase.isLockFlagDirty() && (bl || pSDEToolbarBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSDEToolbarBase.getLockFlag());
        }
        if (pSDEToolbarBase.isMemoDirty() && (bl || pSDEToolbarBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEToolbarBase.getMemo());
        }
        if (pSDEToolbarBase.isMobFlagDirty() && (bl || pSDEToolbarBase.getMobFlag() != null)) {
            iDataObject.set(FIELD_MOBFLAG, (Object)pSDEToolbarBase.getMobFlag());
        }
        if (pSDEToolbarBase.isNo2PSDEUAGroupIdDirty() && (bl || pSDEToolbarBase.getNo2PSDEUAGroupId() != null)) {
            iDataObject.set(FIELD_NO2PSDEUAGROUPID, (Object)pSDEToolbarBase.getNo2PSDEUAGroupId());
        }
        if (pSDEToolbarBase.isNo2PSDEUAGroupNameDirty() && (bl || pSDEToolbarBase.getNo2PSDEUAGroupName() != null)) {
            iDataObject.set(FIELD_NO2PSDEUAGROUPNAME, (Object)pSDEToolbarBase.getNo2PSDEUAGroupName());
        }
        if (pSDEToolbarBase.isNo3PSDEUAGroupIdDirty() && (bl || pSDEToolbarBase.getNo3PSDEUAGroupId() != null)) {
            iDataObject.set(FIELD_NO3PSDEUAGROUPID, (Object)pSDEToolbarBase.getNo3PSDEUAGroupId());
        }
        if (pSDEToolbarBase.isNo3PSDEUAGroupNameDirty() && (bl || pSDEToolbarBase.getNo3PSDEUAGroupName() != null)) {
            iDataObject.set(FIELD_NO3PSDEUAGROUPNAME, (Object)pSDEToolbarBase.getNo3PSDEUAGroupName());
        }
        if (pSDEToolbarBase.isNo4PSDEUAGroupIdDirty() && (bl || pSDEToolbarBase.getNo4PSDEUAGroupId() != null)) {
            iDataObject.set(FIELD_NO4PSDEUAGROUPID, (Object)pSDEToolbarBase.getNo4PSDEUAGroupId());
        }
        if (pSDEToolbarBase.isNo4PSDEUAGroupNameDirty() && (bl || pSDEToolbarBase.getNo4PSDEUAGroupName() != null)) {
            iDataObject.set(FIELD_NO4PSDEUAGROUPNAME, (Object)pSDEToolbarBase.getNo4PSDEUAGroupName());
        }
        if (pSDEToolbarBase.isNo5PSDEUAGroupIdDirty() && (bl || pSDEToolbarBase.getNo5PSDEUAGroupId() != null)) {
            iDataObject.set(FIELD_NO5PSDEUAGROUPID, (Object)pSDEToolbarBase.getNo5PSDEUAGroupId());
        }
        if (pSDEToolbarBase.isNo5PSDEUAGroupNameDirty() && (bl || pSDEToolbarBase.getNo5PSDEUAGroupName() != null)) {
            iDataObject.set(FIELD_NO5PSDEUAGROUPNAME, (Object)pSDEToolbarBase.getNo5PSDEUAGroupName());
        }
        if (pSDEToolbarBase.isNo6PSDEUAGroupIdDirty() && (bl || pSDEToolbarBase.getNo6PSDEUAGroupId() != null)) {
            iDataObject.set(FIELD_NO6PSDEUAGROUPID, (Object)pSDEToolbarBase.getNo6PSDEUAGroupId());
        }
        if (pSDEToolbarBase.isNo6PSDEUAGroupNameDirty() && (bl || pSDEToolbarBase.getNo6PSDEUAGroupName() != null)) {
            iDataObject.set(FIELD_NO6PSDEUAGROUPNAME, (Object)pSDEToolbarBase.getNo6PSDEUAGroupName());
        }
        if (pSDEToolbarBase.isPSCtrlLogicGroupIdDirty() && (bl || pSDEToolbarBase.getPSCtrlLogicGroupId() != null)) {
            iDataObject.set(FIELD_PSCTRLLOGICGROUPID, (Object)pSDEToolbarBase.getPSCtrlLogicGroupId());
        }
        if (pSDEToolbarBase.isPSCtrlLogicGroupNameDirty() && (bl || pSDEToolbarBase.getPSCtrlLogicGroupName() != null)) {
            iDataObject.set(FIELD_PSCTRLLOGICGROUPNAME, (Object)pSDEToolbarBase.getPSCtrlLogicGroupName());
        }
        if (pSDEToolbarBase.isPSDEIdDirty() && (bl || pSDEToolbarBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEToolbarBase.getPSDEId());
        }
        if (pSDEToolbarBase.isPSDENameDirty() && (bl || pSDEToolbarBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDEToolbarBase.getPSDEName());
        }
        if (pSDEToolbarBase.isPSDEToolbarIdDirty() && (bl || pSDEToolbarBase.getPSDEToolbarId() != null)) {
            iDataObject.set(FIELD_PSDETOOLBARID, (Object)pSDEToolbarBase.getPSDEToolbarId());
        }
        if (pSDEToolbarBase.isPSDEToolbarNameDirty() && (bl || pSDEToolbarBase.getPSDEToolbarName() != null)) {
            iDataObject.set(FIELD_PSDETOOLBARNAME, (Object)pSDEToolbarBase.getPSDEToolbarName());
        }
        if (pSDEToolbarBase.isPSDEUAGroupIdDirty() && (bl || pSDEToolbarBase.getPSDEUAGroupId() != null)) {
            iDataObject.set(FIELD_PSDEUAGROUPID, (Object)pSDEToolbarBase.getPSDEUAGroupId());
        }
        if (pSDEToolbarBase.isPSDEUAGroupNameDirty() && (bl || pSDEToolbarBase.getPSDEUAGroupName() != null)) {
            iDataObject.set(FIELD_PSDEUAGROUPNAME, (Object)pSDEToolbarBase.getPSDEUAGroupName());
        }
        if (pSDEToolbarBase.isPSModuleIdDirty() && (bl || pSDEToolbarBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSDEToolbarBase.getPSModuleId());
        }
        if (pSDEToolbarBase.isPSModuleNameDirty() && (bl || pSDEToolbarBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSDEToolbarBase.getPSModuleName());
        }
        if (pSDEToolbarBase.isPSSysAppIdDirty() && (bl || pSDEToolbarBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSDEToolbarBase.getPSSysAppId());
        }
        if (pSDEToolbarBase.isPSSysAppNameDirty() && (bl || pSDEToolbarBase.getPSSysAppName() != null)) {
            iDataObject.set(FIELD_PSSYSAPPNAME, (Object)pSDEToolbarBase.getPSSysAppName());
        }
        if (pSDEToolbarBase.isPSSysCounterIdDirty() && (bl || pSDEToolbarBase.getPSSysCounterId() != null)) {
            iDataObject.set(FIELD_PSSYSCOUNTERID, (Object)pSDEToolbarBase.getPSSysCounterId());
        }
        if (pSDEToolbarBase.isPSSysCounterNameDirty() && (bl || pSDEToolbarBase.getPSSysCounterName() != null)) {
            iDataObject.set(FIELD_PSSYSCOUNTERNAME, (Object)pSDEToolbarBase.getPSSysCounterName());
        }
        if (pSDEToolbarBase.isPSSysCssIdDirty() && (bl || pSDEToolbarBase.getPSSysCssId() != null)) {
            iDataObject.set(FIELD_PSSYSCSSID, (Object)pSDEToolbarBase.getPSSysCssId());
        }
        if (pSDEToolbarBase.isPSSysCssNameDirty() && (bl || pSDEToolbarBase.getPSSysCssName() != null)) {
            iDataObject.set(FIELD_PSSYSCSSNAME, (Object)pSDEToolbarBase.getPSSysCssName());
        }
        if (pSDEToolbarBase.isPSSysPFPluginIdDirty() && (bl || pSDEToolbarBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSDEToolbarBase.getPSSysPFPluginId());
        }
        if (pSDEToolbarBase.isPSSysPFPluginNameDirty() && (bl || pSDEToolbarBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSDEToolbarBase.getPSSysPFPluginName());
        }
        if (pSDEToolbarBase.isPSSystemIdDirty() && (bl || pSDEToolbarBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSDEToolbarBase.getPSSystemId());
        }
        if (pSDEToolbarBase.isPSSystemNameDirty() && (bl || pSDEToolbarBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSDEToolbarBase.getPSSystemName());
        }
        if (pSDEToolbarBase.isPSSysToolbarIdDirty() && (bl || pSDEToolbarBase.getPSSysToolbarId() != null)) {
            iDataObject.set(FIELD_PSSYSTOOLBARID, (Object)pSDEToolbarBase.getPSSysToolbarId());
        }
        if (pSDEToolbarBase.isPSSysToolbarNameDirty() && (bl || pSDEToolbarBase.getPSSysToolbarName() != null)) {
            iDataObject.set(FIELD_PSSYSTOOLBARNAME, (Object)pSDEToolbarBase.getPSSysToolbarName());
        }
        if (pSDEToolbarBase.isPSViewMsgGroupIdDirty() && (bl || pSDEToolbarBase.getPSViewMsgGroupId() != null)) {
            iDataObject.set(FIELD_PSVIEWMSGGROUPID, (Object)pSDEToolbarBase.getPSViewMsgGroupId());
        }
        if (pSDEToolbarBase.isPSViewMsgGroupNameDirty() && (bl || pSDEToolbarBase.getPSViewMsgGroupName() != null)) {
            iDataObject.set(FIELD_PSVIEWMSGGROUPNAME, (Object)pSDEToolbarBase.getPSViewMsgGroupName());
        }
        if (pSDEToolbarBase.isSysAppFlagDirty() && (bl || pSDEToolbarBase.getSysAppFlag() != null)) {
            iDataObject.set(FIELD_SYSAPPFLAG, (Object)pSDEToolbarBase.getSysAppFlag());
        }
        if (pSDEToolbarBase.isTBModelDirty() && (bl || pSDEToolbarBase.getTBModel() != null)) {
            iDataObject.set(FIELD_TBMODEL, (Object)pSDEToolbarBase.getTBModel());
        }
        if (pSDEToolbarBase.isTemplToolbarDirty() && (bl || pSDEToolbarBase.getTemplToolbar() != null)) {
            iDataObject.set(FIELD_TEMPLTOOLBAR, (Object)pSDEToolbarBase.getTemplToolbar());
        }
        if (pSDEToolbarBase.isToolbarSNDirty() && (bl || pSDEToolbarBase.getToolbarSN() != null)) {
            iDataObject.set(FIELD_TOOLBARSN, (Object)pSDEToolbarBase.getToolbarSN());
        }
        if (pSDEToolbarBase.isToolbarStyleDirty() && (bl || pSDEToolbarBase.getToolbarStyle() != null)) {
            iDataObject.set(FIELD_TOOLBARSTYLE, (Object)pSDEToolbarBase.getToolbarStyle());
        }
        if (pSDEToolbarBase.isUpdateDateDirty() && (bl || pSDEToolbarBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEToolbarBase.getUpdateDate());
        }
        if (pSDEToolbarBase.isUpdateManDirty() && (bl || pSDEToolbarBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEToolbarBase.getUpdateMan());
        }
        if (pSDEToolbarBase.isUserParamsDirty() && (bl || pSDEToolbarBase.getUserParams() != null)) {
            iDataObject.set(FIELD_USERPARAMS, (Object)pSDEToolbarBase.getUserParams());
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
        return PSDEToolbarBase.remove(this, n);
    }

    private static boolean remove(PSDEToolbarBase pSDEToolbarBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEToolbarBase.resetCodeName();
                return true;
            }
            case 1: {
                pSDEToolbarBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDEToolbarBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDEToolbarBase.resetIconAlign();
                return true;
            }
            case 4: {
                pSDEToolbarBase.resetLockFlag();
                return true;
            }
            case 5: {
                pSDEToolbarBase.resetMemo();
                return true;
            }
            case 6: {
                pSDEToolbarBase.resetMobFlag();
                return true;
            }
            case 7: {
                pSDEToolbarBase.resetNo2PSDEUAGroupId();
                return true;
            }
            case 8: {
                pSDEToolbarBase.resetNo2PSDEUAGroupName();
                return true;
            }
            case 9: {
                pSDEToolbarBase.resetNo3PSDEUAGroupId();
                return true;
            }
            case 10: {
                pSDEToolbarBase.resetNo3PSDEUAGroupName();
                return true;
            }
            case 11: {
                pSDEToolbarBase.resetNo4PSDEUAGroupId();
                return true;
            }
            case 12: {
                pSDEToolbarBase.resetNo4PSDEUAGroupName();
                return true;
            }
            case 13: {
                pSDEToolbarBase.resetNo5PSDEUAGroupId();
                return true;
            }
            case 14: {
                pSDEToolbarBase.resetNo5PSDEUAGroupName();
                return true;
            }
            case 15: {
                pSDEToolbarBase.resetNo6PSDEUAGroupId();
                return true;
            }
            case 16: {
                pSDEToolbarBase.resetNo6PSDEUAGroupName();
                return true;
            }
            case 17: {
                pSDEToolbarBase.resetPSCtrlLogicGroupId();
                return true;
            }
            case 18: {
                pSDEToolbarBase.resetPSCtrlLogicGroupName();
                return true;
            }
            case 19: {
                pSDEToolbarBase.resetPSDEId();
                return true;
            }
            case 20: {
                pSDEToolbarBase.resetPSDEName();
                return true;
            }
            case 21: {
                pSDEToolbarBase.resetPSDEToolbarId();
                return true;
            }
            case 22: {
                pSDEToolbarBase.resetPSDEToolbarName();
                return true;
            }
            case 23: {
                pSDEToolbarBase.resetPSDEUAGroupId();
                return true;
            }
            case 24: {
                pSDEToolbarBase.resetPSDEUAGroupName();
                return true;
            }
            case 25: {
                pSDEToolbarBase.resetPSModuleId();
                return true;
            }
            case 26: {
                pSDEToolbarBase.resetPSModuleName();
                return true;
            }
            case 27: {
                pSDEToolbarBase.resetPSSysAppId();
                return true;
            }
            case 28: {
                pSDEToolbarBase.resetPSSysAppName();
                return true;
            }
            case 29: {
                pSDEToolbarBase.resetPSSysCounterId();
                return true;
            }
            case 30: {
                pSDEToolbarBase.resetPSSysCounterName();
                return true;
            }
            case 31: {
                pSDEToolbarBase.resetPSSysCssId();
                return true;
            }
            case 32: {
                pSDEToolbarBase.resetPSSysCssName();
                return true;
            }
            case 33: {
                pSDEToolbarBase.resetPSSysPFPluginId();
                return true;
            }
            case 34: {
                pSDEToolbarBase.resetPSSysPFPluginName();
                return true;
            }
            case 35: {
                pSDEToolbarBase.resetPSSystemId();
                return true;
            }
            case 36: {
                pSDEToolbarBase.resetPSSystemName();
                return true;
            }
            case 37: {
                pSDEToolbarBase.resetPSSysToolbarId();
                return true;
            }
            case 38: {
                pSDEToolbarBase.resetPSSysToolbarName();
                return true;
            }
            case 39: {
                pSDEToolbarBase.resetPSViewMsgGroupId();
                return true;
            }
            case 40: {
                pSDEToolbarBase.resetPSViewMsgGroupName();
                return true;
            }
            case 41: {
                pSDEToolbarBase.resetSysAppFlag();
                return true;
            }
            case 42: {
                pSDEToolbarBase.resetTBModel();
                return true;
            }
            case 43: {
                pSDEToolbarBase.resetTemplToolbar();
                return true;
            }
            case 44: {
                pSDEToolbarBase.resetToolbarSN();
                return true;
            }
            case 45: {
                pSDEToolbarBase.resetToolbarStyle();
                return true;
            }
            case 46: {
                pSDEToolbarBase.resetUpdateDate();
                return true;
            }
            case 47: {
                pSDEToolbarBase.resetUpdateMan();
                return true;
            }
            case 48: {
                pSDEToolbarBase.resetUserParams();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCtrlLogicGroup getPSCtrlLogicGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlLogicGroup();
        }
        if (this.getPSCtrlLogicGroupId() == null) {
            return null;
        }
        Integer n = this.objPSCtrlLogicGroupLock;
        synchronized (n) {
            if (this.psctrllogicgroup != null && DataTypeHelper.compare((int)25, (Object)this.getPSCtrlLogicGroupId(), (Object)this.psctrllogicgroup.getPSCtrlLogicGroupId()) != 0L) {
                this.psctrllogicgroup = null;
            }
            if (this.psctrllogicgroup == null) {
                PSCtrlLogicGroup pSCtrlLogicGroup = new PSCtrlLogicGroup();
                pSCtrlLogicGroup.setPSCtrlLogicGroupId(this.getPSCtrlLogicGroupId());
                PSCtrlLogicGroupService pSCtrlLogicGroupService = (PSCtrlLogicGroupService)ServiceGlobal.getService(PSCtrlLogicGroupService.class, (SessionFactory)this.getSessionFactory());
                pSCtrlLogicGroupService.autoGet((IEntity)pSCtrlLogicGroup);
                this.psctrllogicgroup = pSCtrlLogicGroup;
            }
            return this.psctrllogicgroup;
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
    public PSDEUAGroup getNo2PSDEUAGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo2PSDEUAGroup();
        }
        if (this.getNo2PSDEUAGroupId() == null) {
            return null;
        }
        Integer n = this.objNo2PSDEUAGroupLock;
        synchronized (n) {
            if (this.no2psdeuagroup != null && DataTypeHelper.compare((int)25, (Object)this.getNo2PSDEUAGroupId(), (Object)this.no2psdeuagroup.getPSDEUAGroupId()) != 0L) {
                this.no2psdeuagroup = null;
            }
            if (this.no2psdeuagroup == null) {
                PSDEUAGroup pSDEUAGroup = new PSDEUAGroup();
                pSDEUAGroup.setPSDEUAGroupId(this.getNo2PSDEUAGroupId());
                PSDEUAGroupService pSDEUAGroupService = (PSDEUAGroupService)ServiceGlobal.getService(PSDEUAGroupService.class, (SessionFactory)this.getSessionFactory());
                pSDEUAGroupService.autoGet((IEntity)pSDEUAGroup);
                this.no2psdeuagroup = pSDEUAGroup;
            }
            return this.no2psdeuagroup;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEUAGroup getNo3PSDEUAGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo3PSDEUAGroup();
        }
        if (this.getNo3PSDEUAGroupId() == null) {
            return null;
        }
        Integer n = this.objNo3PSDEUAGroupLock;
        synchronized (n) {
            if (this.no3psdeuagroup != null && DataTypeHelper.compare((int)25, (Object)this.getNo3PSDEUAGroupId(), (Object)this.no3psdeuagroup.getPSDEUAGroupId()) != 0L) {
                this.no3psdeuagroup = null;
            }
            if (this.no3psdeuagroup == null) {
                PSDEUAGroup pSDEUAGroup = new PSDEUAGroup();
                pSDEUAGroup.setPSDEUAGroupId(this.getNo3PSDEUAGroupId());
                PSDEUAGroupService pSDEUAGroupService = (PSDEUAGroupService)ServiceGlobal.getService(PSDEUAGroupService.class, (SessionFactory)this.getSessionFactory());
                pSDEUAGroupService.autoGet((IEntity)pSDEUAGroup);
                this.no3psdeuagroup = pSDEUAGroup;
            }
            return this.no3psdeuagroup;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEUAGroup getNo4PSDEUAGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo4PSDEUAGroup();
        }
        if (this.getNo4PSDEUAGroupId() == null) {
            return null;
        }
        Integer n = this.objNo4PSDEUAGroupLock;
        synchronized (n) {
            if (this.no4psdeuagroup != null && DataTypeHelper.compare((int)25, (Object)this.getNo4PSDEUAGroupId(), (Object)this.no4psdeuagroup.getPSDEUAGroupId()) != 0L) {
                this.no4psdeuagroup = null;
            }
            if (this.no4psdeuagroup == null) {
                PSDEUAGroup pSDEUAGroup = new PSDEUAGroup();
                pSDEUAGroup.setPSDEUAGroupId(this.getNo4PSDEUAGroupId());
                PSDEUAGroupService pSDEUAGroupService = (PSDEUAGroupService)ServiceGlobal.getService(PSDEUAGroupService.class, (SessionFactory)this.getSessionFactory());
                pSDEUAGroupService.autoGet((IEntity)pSDEUAGroup);
                this.no4psdeuagroup = pSDEUAGroup;
            }
            return this.no4psdeuagroup;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEUAGroup getNo5PSDEUAGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo5PSDEUAGroup();
        }
        if (this.getNo5PSDEUAGroupId() == null) {
            return null;
        }
        Integer n = this.objNo5PSDEUAGroupLock;
        synchronized (n) {
            if (this.no5psdeuagroup != null && DataTypeHelper.compare((int)25, (Object)this.getNo5PSDEUAGroupId(), (Object)this.no5psdeuagroup.getPSDEUAGroupId()) != 0L) {
                this.no5psdeuagroup = null;
            }
            if (this.no5psdeuagroup == null) {
                PSDEUAGroup pSDEUAGroup = new PSDEUAGroup();
                pSDEUAGroup.setPSDEUAGroupId(this.getNo5PSDEUAGroupId());
                PSDEUAGroupService pSDEUAGroupService = (PSDEUAGroupService)ServiceGlobal.getService(PSDEUAGroupService.class, (SessionFactory)this.getSessionFactory());
                pSDEUAGroupService.autoGet((IEntity)pSDEUAGroup);
                this.no5psdeuagroup = pSDEUAGroup;
            }
            return this.no5psdeuagroup;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEUAGroup getNo6PSDEUAGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo6PSDEUAGroup();
        }
        if (this.getNo6PSDEUAGroupId() == null) {
            return null;
        }
        Integer n = this.objNo6PSDEUAGroupLock;
        synchronized (n) {
            if (this.no6psdeuagroup != null && DataTypeHelper.compare((int)25, (Object)this.getNo6PSDEUAGroupId(), (Object)this.no6psdeuagroup.getPSDEUAGroupId()) != 0L) {
                this.no6psdeuagroup = null;
            }
            if (this.no6psdeuagroup == null) {
                PSDEUAGroup pSDEUAGroup = new PSDEUAGroup();
                pSDEUAGroup.setPSDEUAGroupId(this.getNo6PSDEUAGroupId());
                PSDEUAGroupService pSDEUAGroupService = (PSDEUAGroupService)ServiceGlobal.getService(PSDEUAGroupService.class, (SessionFactory)this.getSessionFactory());
                pSDEUAGroupService.autoGet((IEntity)pSDEUAGroup);
                this.no6psdeuagroup = pSDEUAGroup;
            }
            return this.no6psdeuagroup;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEUAGroup getPSDEUAGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUAGroup();
        }
        if (this.getPSDEUAGroupId() == null) {
            return null;
        }
        Integer n = this.objPSDEUAGroupLock;
        synchronized (n) {
            if (this.psdeuagroup != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEUAGroupId(), (Object)this.psdeuagroup.getPSDEUAGroupId()) != 0L) {
                this.psdeuagroup = null;
            }
            if (this.psdeuagroup == null) {
                PSDEUAGroup pSDEUAGroup = new PSDEUAGroup();
                pSDEUAGroup.setPSDEUAGroupId(this.getPSDEUAGroupId());
                PSDEUAGroupService pSDEUAGroupService = (PSDEUAGroupService)ServiceGlobal.getService(PSDEUAGroupService.class, (SessionFactory)this.getSessionFactory());
                pSDEUAGroupService.autoGet((IEntity)pSDEUAGroup);
                this.psdeuagroup = pSDEUAGroup;
            }
            return this.psdeuagroup;
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
    public PSSysCounter getPSSysCounter() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCounter();
        }
        if (this.getPSSysCounterId() == null) {
            return null;
        }
        Integer n = this.objPSSysCounterLock;
        synchronized (n) {
            if (this.pssyscounter != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysCounterId(), (Object)this.pssyscounter.getPSSysCounterId()) != 0L) {
                this.pssyscounter = null;
            }
            if (this.pssyscounter == null) {
                PSSysCounter pSSysCounter = new PSSysCounter();
                pSSysCounter.setPSSysCounterId(this.getPSSysCounterId());
                PSSysCounterService pSSysCounterService = (PSSysCounterService)ServiceGlobal.getService(PSSysCounterService.class, (SessionFactory)this.getSessionFactory());
                pSSysCounterService.autoGet((IEntity)pSSysCounter);
                this.pssyscounter = pSSysCounter;
            }
            return this.pssyscounter;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysCss getPSSysCss() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCss();
        }
        if (this.getPSSysCssId() == null) {
            return null;
        }
        Integer n = this.objPSSysCssLock;
        synchronized (n) {
            if (this.pssyscss != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysCssId(), (Object)this.pssyscss.getPSSysCssId()) != 0L) {
                this.pssyscss = null;
            }
            if (this.pssyscss == null) {
                PSSysCss pSSysCss = new PSSysCss();
                pSSysCss.setPSSysCssId(this.getPSSysCssId());
                PSSysCssService pSSysCssService = (PSSysCssService)ServiceGlobal.getService(PSSysCssService.class, (SessionFactory)this.getSessionFactory());
                pSSysCssService.autoGet((IEntity)pSSysCss);
                this.pssyscss = pSSysCss;
            }
            return this.pssyscss;
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
    public PSSysToolbar getPSSysToolbar() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysToolbar();
        }
        if (this.getPSSysToolbarId() == null) {
            return null;
        }
        Integer n = this.objPSSysToolbarLock;
        synchronized (n) {
            if (this.pssystoolbar != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysToolbarId(), (Object)this.pssystoolbar.getPSSysToolbarId()) != 0L) {
                this.pssystoolbar = null;
            }
            if (this.pssystoolbar == null) {
                PSSysToolbar pSSysToolbar = new PSSysToolbar();
                pSSysToolbar.setPSSysToolbarId(this.getPSSysToolbarId());
                PSSysToolbarService pSSysToolbarService = (PSSysToolbarService)ServiceGlobal.getService(PSSysToolbarService.class, (SessionFactory)this.getSessionFactory());
                pSSysToolbarService.autoGet((IEntity)pSSysToolbar);
                this.pssystoolbar = pSSysToolbar;
            }
            return this.pssystoolbar;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSViewMsgGroup getPSViewMsgGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewMsgGroup();
        }
        if (this.getPSViewMsgGroupId() == null) {
            return null;
        }
        Integer n = this.objPSViewMsgGroupLock;
        synchronized (n) {
            if (this.psviewmsggroup != null && DataTypeHelper.compare((int)25, (Object)this.getPSViewMsgGroupId(), (Object)this.psviewmsggroup.getPSViewMsgGroupId()) != 0L) {
                this.psviewmsggroup = null;
            }
            if (this.psviewmsggroup == null) {
                PSViewMsgGroup pSViewMsgGroup = new PSViewMsgGroup();
                pSViewMsgGroup.setPSViewMsgGroupId(this.getPSViewMsgGroupId());
                PSViewMsgGroupService pSViewMsgGroupService = (PSViewMsgGroupService)ServiceGlobal.getService(PSViewMsgGroupService.class, (SessionFactory)this.getSessionFactory());
                pSViewMsgGroupService.autoGet((IEntity)pSViewMsgGroup);
                this.psviewmsggroup = pSViewMsgGroup;
            }
            return this.psviewmsggroup;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDETBItem> getPSDETBItems() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETBItems();
        }
        if (this.getPSDEToolbarId() == null) {
            return null;
        }
        PSDEToolbarService pSDEToolbarService = (PSDEToolbarService)ServiceGlobal.getService(PSDEToolbarService.class, (SessionFactory)this.getSessionFactory());
        PSDETBItemService pSDETBItemService = (PSDETBItemService)ServiceGlobal.getService(PSDETBItemService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDETBItemsLock;
        synchronized (n) {
            if (this.psdetbitems == null) {
                this.psdetbitems = pSDEToolbarService.isTempData((IEntity)this) ? pSDETBItemService.selectTempByPSDEToolbar(this) : pSDETBItemService.selectByPSDEToolbar(this);
            }
            return this.psdetbitems;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEToolbarLogic> getPSDEToolbarLogics() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEToolbarLogics();
        }
        if (this.getPSDEToolbarId() == null) {
            return null;
        }
        PSDEToolbarService pSDEToolbarService = (PSDEToolbarService)ServiceGlobal.getService(PSDEToolbarService.class, (SessionFactory)this.getSessionFactory());
        PSDEToolbarLogicService pSDEToolbarLogicService = (PSDEToolbarLogicService)ServiceGlobal.getService(PSDEToolbarLogicService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEToolbarLogicsLock;
        synchronized (n) {
            if (this.psdetoolbarlogics == null) {
                this.psdetoolbarlogics = pSDEToolbarService.isTempData((IEntity)this) ? pSDEToolbarLogicService.selectTempByPSDEToolbar(this) : pSDEToolbarLogicService.selectByPSDEToolbar(this);
            }
            return this.psdetoolbarlogics;
        }
    }

    private PSDEToolbarBase getProxyEntity() {
        return this.proxyPSDEToolbarBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEToolbarBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEToolbarBase) {
            this.proxyPSDEToolbarBase = (PSDEToolbarBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_ICONALIGN, 3);
        fieldIndexMap.put(FIELD_LOCKFLAG, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_MOBFLAG, 6);
        fieldIndexMap.put(FIELD_NO2PSDEUAGROUPID, 7);
        fieldIndexMap.put(FIELD_NO2PSDEUAGROUPNAME, 8);
        fieldIndexMap.put(FIELD_NO3PSDEUAGROUPID, 9);
        fieldIndexMap.put(FIELD_NO3PSDEUAGROUPNAME, 10);
        fieldIndexMap.put(FIELD_NO4PSDEUAGROUPID, 11);
        fieldIndexMap.put(FIELD_NO4PSDEUAGROUPNAME, 12);
        fieldIndexMap.put(FIELD_NO5PSDEUAGROUPID, 13);
        fieldIndexMap.put(FIELD_NO5PSDEUAGROUPNAME, 14);
        fieldIndexMap.put(FIELD_NO6PSDEUAGROUPID, 15);
        fieldIndexMap.put(FIELD_NO6PSDEUAGROUPNAME, 16);
        fieldIndexMap.put(FIELD_PSCTRLLOGICGROUPID, 17);
        fieldIndexMap.put(FIELD_PSCTRLLOGICGROUPNAME, 18);
        fieldIndexMap.put(FIELD_PSDEID, 19);
        fieldIndexMap.put(FIELD_PSDENAME, 20);
        fieldIndexMap.put(FIELD_PSDETOOLBARID, 21);
        fieldIndexMap.put(FIELD_PSDETOOLBARNAME, 22);
        fieldIndexMap.put(FIELD_PSDEUAGROUPID, 23);
        fieldIndexMap.put(FIELD_PSDEUAGROUPNAME, 24);
        fieldIndexMap.put(FIELD_PSMODULEID, 25);
        fieldIndexMap.put(FIELD_PSMODULENAME, 26);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 27);
        fieldIndexMap.put(FIELD_PSSYSAPPNAME, 28);
        fieldIndexMap.put(FIELD_PSSYSCOUNTERID, 29);
        fieldIndexMap.put(FIELD_PSSYSCOUNTERNAME, 30);
        fieldIndexMap.put(FIELD_PSSYSCSSID, 31);
        fieldIndexMap.put(FIELD_PSSYSCSSNAME, 32);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINID, 33);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINNAME, 34);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 35);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 36);
        fieldIndexMap.put(FIELD_PSSYSTOOLBARID, 37);
        fieldIndexMap.put(FIELD_PSSYSTOOLBARNAME, 38);
        fieldIndexMap.put(FIELD_PSVIEWMSGGROUPID, 39);
        fieldIndexMap.put(FIELD_PSVIEWMSGGROUPNAME, 40);
        fieldIndexMap.put(FIELD_SYSAPPFLAG, 41);
        fieldIndexMap.put(FIELD_TBMODEL, 42);
        fieldIndexMap.put(FIELD_TEMPLTOOLBAR, 43);
        fieldIndexMap.put(FIELD_TOOLBARSN, 44);
        fieldIndexMap.put(FIELD_TOOLBARSTYLE, 45);
        fieldIndexMap.put(FIELD_UPDATEDATE, 46);
        fieldIndexMap.put(FIELD_UPDATEMAN, 47);
        fieldIndexMap.put(FIELD_USERPARAMS, 48);
    }
}

