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
import net.ibizsys.pscore.srv.config.service.PSSysPFPluginService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSubViewTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSubViewTypeBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_EXTENDCTRL = "EXTENDCTRL";
    public static final String FIELD_EXTENDENGINE = "EXTENDENGINE";
    public static final String FIELD_EXTENDSTYLEONLY = "EXTENDSTYLEONLY";
    public static final String FIELD_EXTENDVIEW = "EXTENDVIEW";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_NAMEMODE = "NAMEMODE";
    public static final String FIELD_PREVIEWHTML = "PREVIEWHTML";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSUBVIEWTYPEID = "PSSUBVIEWTYPEID";
    public static final String FIELD_PSSUBVIEWTYPENAME = "PSSUBVIEWTYPENAME";
    public static final String FIELD_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String FIELD_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_PSSYSVIEWPANELID = "PSSYSVIEWPANELID";
    public static final String FIELD_PSSYSVIEWPANELNAME = "PSSYSVIEWPANELNAME";
    public static final String FIELD_PSVIEWTYPEID = "PSVIEWTYPEID";
    public static final String FIELD_PSVIEWTYPENAME = "PSVIEWTYPENAME";
    public static final String FIELD_REPDEFAULT = "REPDEFAULT";
    public static final String FIELD_STUDIOICON = "STUDIOICON";
    public static final String FIELD_TYPECODE = "TYPECODE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_UTILPARAMS = "UTILPARAMS";
    public static final String FIELD_VIEWMODEL = "VIEWMODEL";
    public static final String FIELD_VIEWPARAMS = "VIEWPARAMS";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_EXTENDCTRL = 3;
    private static final int INDEX_EXTENDENGINE = 4;
    private static final int INDEX_EXTENDSTYLEONLY = 5;
    private static final int INDEX_EXTENDVIEW = 6;
    private static final int INDEX_LOCKFLAG = 7;
    private static final int INDEX_MEMO = 8;
    private static final int INDEX_NAMEMODE = 9;
    private static final int INDEX_PREVIEWHTML = 10;
    private static final int INDEX_PSMODULEID = 11;
    private static final int INDEX_PSMODULENAME = 12;
    private static final int INDEX_PSSUBVIEWTYPEID = 13;
    private static final int INDEX_PSSUBVIEWTYPENAME = 14;
    private static final int INDEX_PSSYSPFPLUGINID = 15;
    private static final int INDEX_PSSYSPFPLUGINNAME = 16;
    private static final int INDEX_PSSYSTEMID = 17;
    private static final int INDEX_PSSYSTEMNAME = 18;
    private static final int INDEX_PSSYSVIEWPANELID = 19;
    private static final int INDEX_PSSYSVIEWPANELNAME = 20;
    private static final int INDEX_PSVIEWTYPEID = 21;
    private static final int INDEX_PSVIEWTYPENAME = 22;
    private static final int INDEX_REPDEFAULT = 23;
    private static final int INDEX_STUDIOICON = 24;
    private static final int INDEX_TYPECODE = 25;
    private static final int INDEX_UPDATEDATE = 26;
    private static final int INDEX_UPDATEMAN = 27;
    private static final int INDEX_USERCAT = 28;
    private static final int INDEX_USERTAG = 29;
    private static final int INDEX_USERTAG2 = 30;
    private static final int INDEX_USERTAG3 = 31;
    private static final int INDEX_USERTAG4 = 32;
    private static final int INDEX_UTILPARAMS = 33;
    private static final int INDEX_VIEWMODEL = 34;
    private static final int INDEX_VIEWPARAMS = 35;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSubViewTypeBase proxyPSSubViewTypeBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean extendctrlDirtyFlag = false;
    private boolean extendengineDirtyFlag = false;
    private boolean extendstyleonlyDirtyFlag = false;
    private boolean extendviewDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean namemodeDirtyFlag = false;
    private boolean previewhtmlDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssubviewtypeidDirtyFlag = false;
    private boolean pssubviewtypenameDirtyFlag = false;
    private boolean pssyspfpluginidDirtyFlag = false;
    private boolean pssyspfpluginnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean pssysviewpanelidDirtyFlag = false;
    private boolean pssysviewpanelnameDirtyFlag = false;
    private boolean psviewtypeidDirtyFlag = false;
    private boolean psviewtypenameDirtyFlag = false;
    private boolean repdefaultDirtyFlag = false;
    private boolean studioiconDirtyFlag = false;
    private boolean typecodeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean utilparamsDirtyFlag = false;
    private boolean viewmodelDirtyFlag = false;
    private boolean viewparamsDirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="extendctrl")
    private Integer extendctrl;
    @Column(name="extendengine")
    private Integer extendengine;
    @Column(name="extendstyleonly")
    private Integer extendstyleonly;
    @Column(name="extendview")
    private Integer extendview;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="memo")
    private String memo;
    @Column(name="namemode")
    private String namemode;
    @Column(name="previewhtml")
    private String previewhtml;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssubviewtypeid")
    private String pssubviewtypeid;
    @Column(name="pssubviewtypename")
    private String pssubviewtypename;
    @Column(name="pssyspfpluginid")
    private String pssyspfpluginid;
    @Column(name="pssyspfpluginname")
    private String pssyspfpluginname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="pssysviewpanelid")
    private String pssysviewpanelid;
    @Column(name="pssysviewpanelname")
    private String pssysviewpanelname;
    @Column(name="psviewtypeid")
    private String psviewtypeid;
    @Column(name="psviewtypename")
    private String psviewtypename;
    @Column(name="repdefault")
    private Integer repdefault;
    @Column(name="studioicon")
    private String studioicon;
    @Column(name="typecode")
    private String typecode;
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
    @Column(name="utilparams")
    private String utilparams;
    @Column(name="viewmodel")
    private String viewmodel;
    @Column(name="viewparams")
    private String viewparams;
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objPSSysPFPluginLock = new Integer(1);
    private PSSysPFPlugin pssyspfplugin = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSSysViewPanelLock = new Integer(1);
    private PSSysViewPanel pssysviewpanel = null;

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

    public void setExtendCtrl(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExtendCtrl(n);
            return;
        }
        this.extendctrl = n;
        this.extendctrlDirtyFlag = true;
    }

    public Integer getExtendCtrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExtendCtrl();
        }
        return this.extendctrl;
    }

    public boolean isExtendCtrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExtendCtrlDirty();
        }
        return this.extendctrlDirtyFlag;
    }

    public void resetExtendCtrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExtendCtrl();
            return;
        }
        this.extendctrlDirtyFlag = false;
        this.extendctrl = null;
    }

    public void setExtendEngine(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExtendEngine(n);
            return;
        }
        this.extendengine = n;
        this.extendengineDirtyFlag = true;
    }

    public Integer getExtendEngine() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExtendEngine();
        }
        return this.extendengine;
    }

    public boolean isExtendEngineDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExtendEngineDirty();
        }
        return this.extendengineDirtyFlag;
    }

    public void resetExtendEngine() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExtendEngine();
            return;
        }
        this.extendengineDirtyFlag = false;
        this.extendengine = null;
    }

    public void setExtendStyleOnly(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExtendStyleOnly(n);
            return;
        }
        this.extendstyleonly = n;
        this.extendstyleonlyDirtyFlag = true;
    }

    public Integer getExtendStyleOnly() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExtendStyleOnly();
        }
        return this.extendstyleonly;
    }

    public boolean isExtendStyleOnlyDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExtendStyleOnlyDirty();
        }
        return this.extendstyleonlyDirtyFlag;
    }

    public void resetExtendStyleOnly() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExtendStyleOnly();
            return;
        }
        this.extendstyleonlyDirtyFlag = false;
        this.extendstyleonly = null;
    }

    public void setExtendView(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExtendView(n);
            return;
        }
        this.extendview = n;
        this.extendviewDirtyFlag = true;
    }

    public Integer getExtendView() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExtendView();
        }
        return this.extendview;
    }

    public boolean isExtendViewDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExtendViewDirty();
        }
        return this.extendviewDirtyFlag;
    }

    public void resetExtendView() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExtendView();
            return;
        }
        this.extendviewDirtyFlag = false;
        this.extendview = null;
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

    public void setNameMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNameMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.namemode = string;
        this.namemodeDirtyFlag = true;
    }

    public String getNameMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNameMode();
        }
        return this.namemode;
    }

    public boolean isNameModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNameModeDirty();
        }
        return this.namemodeDirtyFlag;
    }

    public void resetNameMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNameMode();
            return;
        }
        this.namemodeDirtyFlag = false;
        this.namemode = null;
    }

    public void setPreviewHtml(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPreviewHtml(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.previewhtml = string;
        this.previewhtmlDirtyFlag = true;
    }

    public String getPreviewHtml() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPreviewHtml();
        }
        return this.previewhtml;
    }

    public boolean isPreviewHtmlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPreviewHtmlDirty();
        }
        return this.previewhtmlDirtyFlag;
    }

    public void resetPreviewHtml() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPreviewHtml();
            return;
        }
        this.previewhtmlDirtyFlag = false;
        this.previewhtml = null;
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

    public void setPSSubViewTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubViewTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubviewtypeid = string;
        this.pssubviewtypeidDirtyFlag = true;
    }

    public String getPSSubViewTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubViewTypeId();
        }
        return this.pssubviewtypeid;
    }

    public boolean isPSSubViewTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubViewTypeIdDirty();
        }
        return this.pssubviewtypeidDirtyFlag;
    }

    public void resetPSSubViewTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubViewTypeId();
            return;
        }
        this.pssubviewtypeidDirtyFlag = false;
        this.pssubviewtypeid = null;
    }

    public void setPSSubViewTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubViewTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubviewtypename = string;
        this.pssubviewtypenameDirtyFlag = true;
    }

    public String getPSSubViewTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubViewTypeName();
        }
        return this.pssubviewtypename;
    }

    public boolean isPSSubViewTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubViewTypeNameDirty();
        }
        return this.pssubviewtypenameDirtyFlag;
    }

    public void resetPSSubViewTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubViewTypeName();
            return;
        }
        this.pssubviewtypenameDirtyFlag = false;
        this.pssubviewtypename = null;
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

    public void setPSSysViewPanelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysViewPanelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysviewpanelid = string;
        this.pssysviewpanelidDirtyFlag = true;
    }

    public String getPSSysViewPanelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewPanelId();
        }
        return this.pssysviewpanelid;
    }

    public boolean isPSSysViewPanelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysViewPanelIdDirty();
        }
        return this.pssysviewpanelidDirtyFlag;
    }

    public void resetPSSysViewPanelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysViewPanelId();
            return;
        }
        this.pssysviewpanelidDirtyFlag = false;
        this.pssysviewpanelid = null;
    }

    public void setPSSysViewPanelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysViewPanelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysviewpanelname = string;
        this.pssysviewpanelnameDirtyFlag = true;
    }

    public String getPSSysViewPanelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewPanelName();
        }
        return this.pssysviewpanelname;
    }

    public boolean isPSSysViewPanelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysViewPanelNameDirty();
        }
        return this.pssysviewpanelnameDirtyFlag;
    }

    public void resetPSSysViewPanelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysViewPanelName();
            return;
        }
        this.pssysviewpanelnameDirtyFlag = false;
        this.pssysviewpanelname = null;
    }

    public void setPSViewTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewtypeid = string;
        this.psviewtypeidDirtyFlag = true;
    }

    public String getPSViewTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewTypeId();
        }
        return this.psviewtypeid;
    }

    public boolean isPSViewTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewTypeIdDirty();
        }
        return this.psviewtypeidDirtyFlag;
    }

    public void resetPSViewTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewTypeId();
            return;
        }
        this.psviewtypeidDirtyFlag = false;
        this.psviewtypeid = null;
    }

    public void setPSViewTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewtypename = string;
        this.psviewtypenameDirtyFlag = true;
    }

    public String getPSViewTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewTypeName();
        }
        return this.psviewtypename;
    }

    public boolean isPSViewTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewTypeNameDirty();
        }
        return this.psviewtypenameDirtyFlag;
    }

    public void resetPSViewTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewTypeName();
            return;
        }
        this.psviewtypenameDirtyFlag = false;
        this.psviewtypename = null;
    }

    public void setRepDefault(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRepDefault(n);
            return;
        }
        this.repdefault = n;
        this.repdefaultDirtyFlag = true;
    }

    public Integer getRepDefault() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRepDefault();
        }
        return this.repdefault;
    }

    public boolean isRepDefaultDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRepDefaultDirty();
        }
        return this.repdefaultDirtyFlag;
    }

    public void resetRepDefault() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRepDefault();
            return;
        }
        this.repdefaultDirtyFlag = false;
        this.repdefault = null;
    }

    public void setStudioIcon(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStudioIcon(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.studioicon = string;
        this.studioiconDirtyFlag = true;
    }

    public String getStudioIcon() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStudioIcon();
        }
        return this.studioicon;
    }

    public boolean isStudioIconDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStudioIconDirty();
        }
        return this.studioiconDirtyFlag;
    }

    public void resetStudioIcon() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStudioIcon();
            return;
        }
        this.studioiconDirtyFlag = false;
        this.studioicon = null;
    }

    public void setTypeCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTypeCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.typecode = string;
        this.typecodeDirtyFlag = true;
    }

    public String getTypeCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTypeCode();
        }
        return this.typecode;
    }

    public boolean isTypeCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTypeCodeDirty();
        }
        return this.typecodeDirtyFlag;
    }

    public void resetTypeCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTypeCode();
            return;
        }
        this.typecodeDirtyFlag = false;
        this.typecode = null;
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

    public void setUtilParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilparams = string;
        this.utilparamsDirtyFlag = true;
    }

    public String getUtilParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilParams();
        }
        return this.utilparams;
    }

    public boolean isUtilParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilParamsDirty();
        }
        return this.utilparamsDirtyFlag;
    }

    public void resetUtilParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilParams();
            return;
        }
        this.utilparamsDirtyFlag = false;
        this.utilparams = null;
    }

    public void setViewModel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewModel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.viewmodel = string;
        this.viewmodelDirtyFlag = true;
    }

    public String getViewModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewModel();
        }
        return this.viewmodel;
    }

    public boolean isViewModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewModelDirty();
        }
        return this.viewmodelDirtyFlag;
    }

    public void resetViewModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewModel();
            return;
        }
        this.viewmodelDirtyFlag = false;
        this.viewmodel = null;
    }

    public void setViewParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.viewparams = string;
        this.viewparamsDirtyFlag = true;
    }

    public String getViewParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewParams();
        }
        return this.viewparams;
    }

    public boolean isViewParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewParamsDirty();
        }
        return this.viewparamsDirtyFlag;
    }

    public void resetViewParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewParams();
            return;
        }
        this.viewparamsDirtyFlag = false;
        this.viewparams = null;
    }

    protected void onReset() {
        PSSubViewTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSubViewTypeBase pSSubViewTypeBase) {
        pSSubViewTypeBase.resetCodeName();
        pSSubViewTypeBase.resetCreateDate();
        pSSubViewTypeBase.resetCreateMan();
        pSSubViewTypeBase.resetExtendCtrl();
        pSSubViewTypeBase.resetExtendEngine();
        pSSubViewTypeBase.resetExtendStyleOnly();
        pSSubViewTypeBase.resetExtendView();
        pSSubViewTypeBase.resetLockFlag();
        pSSubViewTypeBase.resetMemo();
        pSSubViewTypeBase.resetNameMode();
        pSSubViewTypeBase.resetPreviewHtml();
        pSSubViewTypeBase.resetPSModuleId();
        pSSubViewTypeBase.resetPSModuleName();
        pSSubViewTypeBase.resetPSSubViewTypeId();
        pSSubViewTypeBase.resetPSSubViewTypeName();
        pSSubViewTypeBase.resetPSSysPFPluginId();
        pSSubViewTypeBase.resetPSSysPFPluginName();
        pSSubViewTypeBase.resetPSSystemId();
        pSSubViewTypeBase.resetPSSystemName();
        pSSubViewTypeBase.resetPSSysViewPanelId();
        pSSubViewTypeBase.resetPSSysViewPanelName();
        pSSubViewTypeBase.resetPSViewTypeId();
        pSSubViewTypeBase.resetPSViewTypeName();
        pSSubViewTypeBase.resetRepDefault();
        pSSubViewTypeBase.resetStudioIcon();
        pSSubViewTypeBase.resetTypeCode();
        pSSubViewTypeBase.resetUpdateDate();
        pSSubViewTypeBase.resetUpdateMan();
        pSSubViewTypeBase.resetUserCat();
        pSSubViewTypeBase.resetUserTag();
        pSSubViewTypeBase.resetUserTag2();
        pSSubViewTypeBase.resetUserTag3();
        pSSubViewTypeBase.resetUserTag4();
        pSSubViewTypeBase.resetUtilParams();
        pSSubViewTypeBase.resetViewModel();
        pSSubViewTypeBase.resetViewParams();
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
        if (!bl || this.isExtendCtrlDirty()) {
            hashMap.put(FIELD_EXTENDCTRL, this.getExtendCtrl());
        }
        if (!bl || this.isExtendEngineDirty()) {
            hashMap.put(FIELD_EXTENDENGINE, this.getExtendEngine());
        }
        if (!bl || this.isExtendStyleOnlyDirty()) {
            hashMap.put(FIELD_EXTENDSTYLEONLY, this.getExtendStyleOnly());
        }
        if (!bl || this.isExtendViewDirty()) {
            hashMap.put(FIELD_EXTENDVIEW, this.getExtendView());
        }
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isNameModeDirty()) {
            hashMap.put(FIELD_NAMEMODE, this.getNameMode());
        }
        if (!bl || this.isPreviewHtmlDirty()) {
            hashMap.put(FIELD_PREVIEWHTML, this.getPreviewHtml());
        }
        if (!bl || this.isPSModuleIdDirty()) {
            hashMap.put(FIELD_PSMODULEID, this.getPSModuleId());
        }
        if (!bl || this.isPSModuleNameDirty()) {
            hashMap.put(FIELD_PSMODULENAME, this.getPSModuleName());
        }
        if (!bl || this.isPSSubViewTypeIdDirty()) {
            hashMap.put(FIELD_PSSUBVIEWTYPEID, this.getPSSubViewTypeId());
        }
        if (!bl || this.isPSSubViewTypeNameDirty()) {
            hashMap.put(FIELD_PSSUBVIEWTYPENAME, this.getPSSubViewTypeName());
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
        if (!bl || this.isPSSysViewPanelIdDirty()) {
            hashMap.put(FIELD_PSSYSVIEWPANELID, this.getPSSysViewPanelId());
        }
        if (!bl || this.isPSSysViewPanelNameDirty()) {
            hashMap.put(FIELD_PSSYSVIEWPANELNAME, this.getPSSysViewPanelName());
        }
        if (!bl || this.isPSViewTypeIdDirty()) {
            hashMap.put(FIELD_PSVIEWTYPEID, this.getPSViewTypeId());
        }
        if (!bl || this.isPSViewTypeNameDirty()) {
            hashMap.put(FIELD_PSVIEWTYPENAME, this.getPSViewTypeName());
        }
        if (!bl || this.isRepDefaultDirty()) {
            hashMap.put(FIELD_REPDEFAULT, this.getRepDefault());
        }
        if (!bl || this.isStudioIconDirty()) {
            hashMap.put(FIELD_STUDIOICON, this.getStudioIcon());
        }
        if (!bl || this.isTypeCodeDirty()) {
            hashMap.put(FIELD_TYPECODE, this.getTypeCode());
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
        if (!bl || this.isUtilParamsDirty()) {
            hashMap.put(FIELD_UTILPARAMS, this.getUtilParams());
        }
        if (!bl || this.isViewModelDirty()) {
            hashMap.put(FIELD_VIEWMODEL, this.getViewModel());
        }
        if (!bl || this.isViewParamsDirty()) {
            hashMap.put(FIELD_VIEWPARAMS, this.getViewParams());
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
        return PSSubViewTypeBase.get(this, n);
    }

    private static Object get(PSSubViewTypeBase pSSubViewTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSubViewTypeBase.getCodeName();
            }
            case 1: {
                return pSSubViewTypeBase.getCreateDate();
            }
            case 2: {
                return pSSubViewTypeBase.getCreateMan();
            }
            case 3: {
                return pSSubViewTypeBase.getExtendCtrl();
            }
            case 4: {
                return pSSubViewTypeBase.getExtendEngine();
            }
            case 5: {
                return pSSubViewTypeBase.getExtendStyleOnly();
            }
            case 6: {
                return pSSubViewTypeBase.getExtendView();
            }
            case 7: {
                return pSSubViewTypeBase.getLockFlag();
            }
            case 8: {
                return pSSubViewTypeBase.getMemo();
            }
            case 9: {
                return pSSubViewTypeBase.getNameMode();
            }
            case 10: {
                return pSSubViewTypeBase.getPreviewHtml();
            }
            case 11: {
                return pSSubViewTypeBase.getPSModuleId();
            }
            case 12: {
                return pSSubViewTypeBase.getPSModuleName();
            }
            case 13: {
                return pSSubViewTypeBase.getPSSubViewTypeId();
            }
            case 14: {
                return pSSubViewTypeBase.getPSSubViewTypeName();
            }
            case 15: {
                return pSSubViewTypeBase.getPSSysPFPluginId();
            }
            case 16: {
                return pSSubViewTypeBase.getPSSysPFPluginName();
            }
            case 17: {
                return pSSubViewTypeBase.getPSSystemId();
            }
            case 18: {
                return pSSubViewTypeBase.getPSSystemName();
            }
            case 19: {
                return pSSubViewTypeBase.getPSSysViewPanelId();
            }
            case 20: {
                return pSSubViewTypeBase.getPSSysViewPanelName();
            }
            case 21: {
                return pSSubViewTypeBase.getPSViewTypeId();
            }
            case 22: {
                return pSSubViewTypeBase.getPSViewTypeName();
            }
            case 23: {
                return pSSubViewTypeBase.getRepDefault();
            }
            case 24: {
                return pSSubViewTypeBase.getStudioIcon();
            }
            case 25: {
                return pSSubViewTypeBase.getTypeCode();
            }
            case 26: {
                return pSSubViewTypeBase.getUpdateDate();
            }
            case 27: {
                return pSSubViewTypeBase.getUpdateMan();
            }
            case 28: {
                return pSSubViewTypeBase.getUserCat();
            }
            case 29: {
                return pSSubViewTypeBase.getUserTag();
            }
            case 30: {
                return pSSubViewTypeBase.getUserTag2();
            }
            case 31: {
                return pSSubViewTypeBase.getUserTag3();
            }
            case 32: {
                return pSSubViewTypeBase.getUserTag4();
            }
            case 33: {
                return pSSubViewTypeBase.getUtilParams();
            }
            case 34: {
                return pSSubViewTypeBase.getViewModel();
            }
            case 35: {
                return pSSubViewTypeBase.getViewParams();
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
        PSSubViewTypeBase.set(this, n, object);
    }

    private static void set(PSSubViewTypeBase pSSubViewTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSubViewTypeBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSubViewTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSubViewTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSubViewTypeBase.setExtendCtrl(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSSubViewTypeBase.setExtendEngine(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSSubViewTypeBase.setExtendStyleOnly(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSSubViewTypeBase.setExtendView(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSSubViewTypeBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSSubViewTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSubViewTypeBase.setNameMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSubViewTypeBase.setPreviewHtml(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSubViewTypeBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSubViewTypeBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSubViewTypeBase.setPSSubViewTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSubViewTypeBase.setPSSubViewTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSubViewTypeBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSubViewTypeBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSubViewTypeBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSubViewTypeBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSubViewTypeBase.setPSSysViewPanelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSubViewTypeBase.setPSSysViewPanelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSubViewTypeBase.setPSViewTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSubViewTypeBase.setPSViewTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSubViewTypeBase.setRepDefault(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 24: {
                pSSubViewTypeBase.setStudioIcon(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSubViewTypeBase.setTypeCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSubViewTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 27: {
                pSSubViewTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSubViewTypeBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSubViewTypeBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSubViewTypeBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSSubViewTypeBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSubViewTypeBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSSubViewTypeBase.setUtilParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSSubViewTypeBase.setViewModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSSubViewTypeBase.setViewParams(DataObject.getStringValue((Object)object));
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
        return PSSubViewTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSSubViewTypeBase pSSubViewTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSubViewTypeBase.getCodeName() == null;
            }
            case 1: {
                return pSSubViewTypeBase.getCreateDate() == null;
            }
            case 2: {
                return pSSubViewTypeBase.getCreateMan() == null;
            }
            case 3: {
                return pSSubViewTypeBase.getExtendCtrl() == null;
            }
            case 4: {
                return pSSubViewTypeBase.getExtendEngine() == null;
            }
            case 5: {
                return pSSubViewTypeBase.getExtendStyleOnly() == null;
            }
            case 6: {
                return pSSubViewTypeBase.getExtendView() == null;
            }
            case 7: {
                return pSSubViewTypeBase.getLockFlag() == null;
            }
            case 8: {
                return pSSubViewTypeBase.getMemo() == null;
            }
            case 9: {
                return pSSubViewTypeBase.getNameMode() == null;
            }
            case 10: {
                return pSSubViewTypeBase.getPreviewHtml() == null;
            }
            case 11: {
                return pSSubViewTypeBase.getPSModuleId() == null;
            }
            case 12: {
                return pSSubViewTypeBase.getPSModuleName() == null;
            }
            case 13: {
                return pSSubViewTypeBase.getPSSubViewTypeId() == null;
            }
            case 14: {
                return pSSubViewTypeBase.getPSSubViewTypeName() == null;
            }
            case 15: {
                return pSSubViewTypeBase.getPSSysPFPluginId() == null;
            }
            case 16: {
                return pSSubViewTypeBase.getPSSysPFPluginName() == null;
            }
            case 17: {
                return pSSubViewTypeBase.getPSSystemId() == null;
            }
            case 18: {
                return pSSubViewTypeBase.getPSSystemName() == null;
            }
            case 19: {
                return pSSubViewTypeBase.getPSSysViewPanelId() == null;
            }
            case 20: {
                return pSSubViewTypeBase.getPSSysViewPanelName() == null;
            }
            case 21: {
                return pSSubViewTypeBase.getPSViewTypeId() == null;
            }
            case 22: {
                return pSSubViewTypeBase.getPSViewTypeName() == null;
            }
            case 23: {
                return pSSubViewTypeBase.getRepDefault() == null;
            }
            case 24: {
                return pSSubViewTypeBase.getStudioIcon() == null;
            }
            case 25: {
                return pSSubViewTypeBase.getTypeCode() == null;
            }
            case 26: {
                return pSSubViewTypeBase.getUpdateDate() == null;
            }
            case 27: {
                return pSSubViewTypeBase.getUpdateMan() == null;
            }
            case 28: {
                return pSSubViewTypeBase.getUserCat() == null;
            }
            case 29: {
                return pSSubViewTypeBase.getUserTag() == null;
            }
            case 30: {
                return pSSubViewTypeBase.getUserTag2() == null;
            }
            case 31: {
                return pSSubViewTypeBase.getUserTag3() == null;
            }
            case 32: {
                return pSSubViewTypeBase.getUserTag4() == null;
            }
            case 33: {
                return pSSubViewTypeBase.getUtilParams() == null;
            }
            case 34: {
                return pSSubViewTypeBase.getViewModel() == null;
            }
            case 35: {
                return pSSubViewTypeBase.getViewParams() == null;
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
        return PSSubViewTypeBase.contains(this, n);
    }

    private static boolean contains(PSSubViewTypeBase pSSubViewTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSubViewTypeBase.isCodeNameDirty();
            }
            case 1: {
                return pSSubViewTypeBase.isCreateDateDirty();
            }
            case 2: {
                return pSSubViewTypeBase.isCreateManDirty();
            }
            case 3: {
                return pSSubViewTypeBase.isExtendCtrlDirty();
            }
            case 4: {
                return pSSubViewTypeBase.isExtendEngineDirty();
            }
            case 5: {
                return pSSubViewTypeBase.isExtendStyleOnlyDirty();
            }
            case 6: {
                return pSSubViewTypeBase.isExtendViewDirty();
            }
            case 7: {
                return pSSubViewTypeBase.isLockFlagDirty();
            }
            case 8: {
                return pSSubViewTypeBase.isMemoDirty();
            }
            case 9: {
                return pSSubViewTypeBase.isNameModeDirty();
            }
            case 10: {
                return pSSubViewTypeBase.isPreviewHtmlDirty();
            }
            case 11: {
                return pSSubViewTypeBase.isPSModuleIdDirty();
            }
            case 12: {
                return pSSubViewTypeBase.isPSModuleNameDirty();
            }
            case 13: {
                return pSSubViewTypeBase.isPSSubViewTypeIdDirty();
            }
            case 14: {
                return pSSubViewTypeBase.isPSSubViewTypeNameDirty();
            }
            case 15: {
                return pSSubViewTypeBase.isPSSysPFPluginIdDirty();
            }
            case 16: {
                return pSSubViewTypeBase.isPSSysPFPluginNameDirty();
            }
            case 17: {
                return pSSubViewTypeBase.isPSSystemIdDirty();
            }
            case 18: {
                return pSSubViewTypeBase.isPSSystemNameDirty();
            }
            case 19: {
                return pSSubViewTypeBase.isPSSysViewPanelIdDirty();
            }
            case 20: {
                return pSSubViewTypeBase.isPSSysViewPanelNameDirty();
            }
            case 21: {
                return pSSubViewTypeBase.isPSViewTypeIdDirty();
            }
            case 22: {
                return pSSubViewTypeBase.isPSViewTypeNameDirty();
            }
            case 23: {
                return pSSubViewTypeBase.isRepDefaultDirty();
            }
            case 24: {
                return pSSubViewTypeBase.isStudioIconDirty();
            }
            case 25: {
                return pSSubViewTypeBase.isTypeCodeDirty();
            }
            case 26: {
                return pSSubViewTypeBase.isUpdateDateDirty();
            }
            case 27: {
                return pSSubViewTypeBase.isUpdateManDirty();
            }
            case 28: {
                return pSSubViewTypeBase.isUserCatDirty();
            }
            case 29: {
                return pSSubViewTypeBase.isUserTagDirty();
            }
            case 30: {
                return pSSubViewTypeBase.isUserTag2Dirty();
            }
            case 31: {
                return pSSubViewTypeBase.isUserTag3Dirty();
            }
            case 32: {
                return pSSubViewTypeBase.isUserTag4Dirty();
            }
            case 33: {
                return pSSubViewTypeBase.isUtilParamsDirty();
            }
            case 34: {
                return pSSubViewTypeBase.isViewModelDirty();
            }
            case 35: {
                return pSSubViewTypeBase.isViewParamsDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSubViewTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSubViewTypeBase pSSubViewTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSubViewTypeBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSubViewTypeBase.getJSONValue((Object)pSSubViewTypeBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSubViewTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSubViewTypeBase.getJSONValue((Object)pSSubViewTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSubViewTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSubViewTypeBase.getJSONValue((Object)pSSubViewTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSubViewTypeBase.getExtendCtrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"extendctrl", (Object)PSSubViewTypeBase.getJSONValue((Object)pSSubViewTypeBase.getExtendCtrl()), (boolean)false);
        }
        if (bl || pSSubViewTypeBase.getExtendEngine() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"extendengine", (Object)PSSubViewTypeBase.getJSONValue((Object)pSSubViewTypeBase.getExtendEngine()), (boolean)false);
        }
        if (bl || pSSubViewTypeBase.getExtendStyleOnly() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"extendstyleonly", (Object)PSSubViewTypeBase.getJSONValue((Object)pSSubViewTypeBase.getExtendStyleOnly()), (boolean)false);
        }
        if (bl || pSSubViewTypeBase.getExtendView() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"extendview", (Object)PSSubViewTypeBase.getJSONValue((Object)pSSubViewTypeBase.getExtendView()), (boolean)false);
        }
        if (bl || pSSubViewTypeBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSSubViewTypeBase.getJSONValue((Object)pSSubViewTypeBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSSubViewTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSubViewTypeBase.getJSONValue((Object)pSSubViewTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSSubViewTypeBase.getNameMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"namemode", (Object)PSSubViewTypeBase.getJSONValue((Object)pSSubViewTypeBase.getNameMode()), (boolean)false);
        }
        if (bl || pSSubViewTypeBase.getPreviewHtml() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"previewhtml", (Object)PSSubViewTypeBase.getJSONValue((Object)pSSubViewTypeBase.getPreviewHtml()), (boolean)false);
        }
        if (bl || pSSubViewTypeBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSSubViewTypeBase.getJSONValue((Object)pSSubViewTypeBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSSubViewTypeBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSSubViewTypeBase.getJSONValue((Object)pSSubViewTypeBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSSubViewTypeBase.getPSSubViewTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubviewtypeid", (Object)PSSubViewTypeBase.getJSONValue((Object)pSSubViewTypeBase.getPSSubViewTypeId()), (boolean)false);
        }
        if (bl || pSSubViewTypeBase.getPSSubViewTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubviewtypename", (Object)PSSubViewTypeBase.getJSONValue((Object)pSSubViewTypeBase.getPSSubViewTypeName()), (boolean)false);
        }
        if (bl || pSSubViewTypeBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSSubViewTypeBase.getJSONValue((Object)pSSubViewTypeBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSSubViewTypeBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSSubViewTypeBase.getJSONValue((Object)pSSubViewTypeBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSSubViewTypeBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSubViewTypeBase.getJSONValue((Object)pSSubViewTypeBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSubViewTypeBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSubViewTypeBase.getJSONValue((Object)pSSubViewTypeBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSubViewTypeBase.getPSSysViewPanelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelid", (Object)PSSubViewTypeBase.getJSONValue((Object)pSSubViewTypeBase.getPSSysViewPanelId()), (boolean)false);
        }
        if (bl || pSSubViewTypeBase.getPSSysViewPanelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelname", (Object)PSSubViewTypeBase.getJSONValue((Object)pSSubViewTypeBase.getPSSysViewPanelName()), (boolean)false);
        }
        if (bl || pSSubViewTypeBase.getPSViewTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewtypeid", (Object)PSSubViewTypeBase.getJSONValue((Object)pSSubViewTypeBase.getPSViewTypeId()), (boolean)false);
        }
        if (bl || pSSubViewTypeBase.getPSViewTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewtypename", (Object)PSSubViewTypeBase.getJSONValue((Object)pSSubViewTypeBase.getPSViewTypeName()), (boolean)false);
        }
        if (bl || pSSubViewTypeBase.getRepDefault() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"repdefault", (Object)PSSubViewTypeBase.getJSONValue((Object)pSSubViewTypeBase.getRepDefault()), (boolean)false);
        }
        if (bl || pSSubViewTypeBase.getStudioIcon() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"studioicon", (Object)PSSubViewTypeBase.getJSONValue((Object)pSSubViewTypeBase.getStudioIcon()), (boolean)false);
        }
        if (bl || pSSubViewTypeBase.getTypeCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typecode", (Object)PSSubViewTypeBase.getJSONValue((Object)pSSubViewTypeBase.getTypeCode()), (boolean)false);
        }
        if (bl || pSSubViewTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSubViewTypeBase.getJSONValue((Object)pSSubViewTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSubViewTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSubViewTypeBase.getJSONValue((Object)pSSubViewTypeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSubViewTypeBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSubViewTypeBase.getJSONValue((Object)pSSubViewTypeBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSubViewTypeBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSubViewTypeBase.getJSONValue((Object)pSSubViewTypeBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSubViewTypeBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSubViewTypeBase.getJSONValue((Object)pSSubViewTypeBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSubViewTypeBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSubViewTypeBase.getJSONValue((Object)pSSubViewTypeBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSubViewTypeBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSubViewTypeBase.getJSONValue((Object)pSSubViewTypeBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSubViewTypeBase.getUtilParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilparams", (Object)PSSubViewTypeBase.getJSONValue((Object)pSSubViewTypeBase.getUtilParams()), (boolean)false);
        }
        if (bl || pSSubViewTypeBase.getViewModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewmodel", (Object)PSSubViewTypeBase.getJSONValue((Object)pSSubViewTypeBase.getViewModel()), (boolean)false);
        }
        if (bl || pSSubViewTypeBase.getViewParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewparams", (Object)PSSubViewTypeBase.getJSONValue((Object)pSSubViewTypeBase.getViewParams()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSubViewTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSubViewTypeBase pSSubViewTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSubViewTypeBase.getCodeName() != null) {
            object = pSSubViewTypeBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubViewTypeBase.getCreateDate() != null) {
            object = pSSubViewTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSubViewTypeBase.getCreateMan() != null) {
            object = pSSubViewTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSubViewTypeBase.getExtendCtrl() != null) {
            object = pSSubViewTypeBase.getExtendCtrl();
            xmlNode.setAttribute(FIELD_EXTENDCTRL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSubViewTypeBase.getExtendEngine() != null) {
            object = pSSubViewTypeBase.getExtendEngine();
            xmlNode.setAttribute(FIELD_EXTENDENGINE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSubViewTypeBase.getExtendStyleOnly() != null) {
            object = pSSubViewTypeBase.getExtendStyleOnly();
            xmlNode.setAttribute(FIELD_EXTENDSTYLEONLY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSubViewTypeBase.getExtendView() != null) {
            object = pSSubViewTypeBase.getExtendView();
            xmlNode.setAttribute(FIELD_EXTENDVIEW, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSubViewTypeBase.getLockFlag() != null) {
            object = pSSubViewTypeBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSubViewTypeBase.getMemo() != null) {
            object = pSSubViewTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSubViewTypeBase.getNameMode() != null) {
            object = pSSubViewTypeBase.getNameMode();
            xmlNode.setAttribute(FIELD_NAMEMODE, object == null ? "" : (String)object);
        }
        if (bl || pSSubViewTypeBase.getPreviewHtml() != null) {
            object = pSSubViewTypeBase.getPreviewHtml();
            xmlNode.setAttribute(FIELD_PREVIEWHTML, object == null ? "" : (String)object);
        }
        if (bl || pSSubViewTypeBase.getPSModuleId() != null) {
            object = pSSubViewTypeBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSubViewTypeBase.getPSModuleName() != null) {
            object = pSSubViewTypeBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubViewTypeBase.getPSSubViewTypeId() != null) {
            object = pSSubViewTypeBase.getPSSubViewTypeId();
            xmlNode.setAttribute(FIELD_PSSUBVIEWTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSSubViewTypeBase.getPSSubViewTypeName() != null) {
            object = pSSubViewTypeBase.getPSSubViewTypeName();
            xmlNode.setAttribute(FIELD_PSSUBVIEWTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubViewTypeBase.getPSSysPFPluginId() != null) {
            object = pSSubViewTypeBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSubViewTypeBase.getPSSysPFPluginName() != null) {
            object = pSSubViewTypeBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubViewTypeBase.getPSSystemId() != null) {
            object = pSSubViewTypeBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSubViewTypeBase.getPSSystemName() != null) {
            object = pSSubViewTypeBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubViewTypeBase.getPSSysViewPanelId() != null) {
            object = pSSubViewTypeBase.getPSSysViewPanelId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELID, object == null ? "" : (String)object);
        }
        if (bl || pSSubViewTypeBase.getPSSysViewPanelName() != null) {
            object = pSSubViewTypeBase.getPSSysViewPanelName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubViewTypeBase.getPSViewTypeId() != null) {
            object = pSSubViewTypeBase.getPSViewTypeId();
            xmlNode.setAttribute(FIELD_PSVIEWTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSSubViewTypeBase.getPSViewTypeName() != null) {
            object = pSSubViewTypeBase.getPSViewTypeName();
            xmlNode.setAttribute(FIELD_PSVIEWTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubViewTypeBase.getRepDefault() != null) {
            object = pSSubViewTypeBase.getRepDefault();
            xmlNode.setAttribute(FIELD_REPDEFAULT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSubViewTypeBase.getStudioIcon() != null) {
            object = pSSubViewTypeBase.getStudioIcon();
            xmlNode.setAttribute(FIELD_STUDIOICON, object == null ? "" : (String)object);
        }
        if (bl || pSSubViewTypeBase.getTypeCode() != null) {
            object = pSSubViewTypeBase.getTypeCode();
            xmlNode.setAttribute(FIELD_TYPECODE, object == null ? "" : (String)object);
        }
        if (bl || pSSubViewTypeBase.getUpdateDate() != null) {
            object = pSSubViewTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSubViewTypeBase.getUpdateMan() != null) {
            object = pSSubViewTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSubViewTypeBase.getUserCat() != null) {
            object = pSSubViewTypeBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSubViewTypeBase.getUserTag() != null) {
            object = pSSubViewTypeBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSubViewTypeBase.getUserTag2() != null) {
            object = pSSubViewTypeBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSubViewTypeBase.getUserTag3() != null) {
            object = pSSubViewTypeBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSubViewTypeBase.getUserTag4() != null) {
            object = pSSubViewTypeBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSubViewTypeBase.getUtilParams() != null) {
            object = pSSubViewTypeBase.getUtilParams();
            xmlNode.setAttribute(FIELD_UTILPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSSubViewTypeBase.getViewModel() != null) {
            object = pSSubViewTypeBase.getViewModel();
            xmlNode.setAttribute(FIELD_VIEWMODEL, object == null ? "" : (String)object);
        }
        if (bl || pSSubViewTypeBase.getViewParams() != null) {
            object = pSSubViewTypeBase.getViewParams();
            xmlNode.setAttribute(FIELD_VIEWPARAMS, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSubViewTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSubViewTypeBase pSSubViewTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSubViewTypeBase.isCodeNameDirty() && (bl || pSSubViewTypeBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSubViewTypeBase.getCodeName());
        }
        if (pSSubViewTypeBase.isCreateDateDirty() && (bl || pSSubViewTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSubViewTypeBase.getCreateDate());
        }
        if (pSSubViewTypeBase.isCreateManDirty() && (bl || pSSubViewTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSubViewTypeBase.getCreateMan());
        }
        if (pSSubViewTypeBase.isExtendCtrlDirty() && (bl || pSSubViewTypeBase.getExtendCtrl() != null)) {
            iDataObject.set(FIELD_EXTENDCTRL, (Object)pSSubViewTypeBase.getExtendCtrl());
        }
        if (pSSubViewTypeBase.isExtendEngineDirty() && (bl || pSSubViewTypeBase.getExtendEngine() != null)) {
            iDataObject.set(FIELD_EXTENDENGINE, (Object)pSSubViewTypeBase.getExtendEngine());
        }
        if (pSSubViewTypeBase.isExtendStyleOnlyDirty() && (bl || pSSubViewTypeBase.getExtendStyleOnly() != null)) {
            iDataObject.set(FIELD_EXTENDSTYLEONLY, (Object)pSSubViewTypeBase.getExtendStyleOnly());
        }
        if (pSSubViewTypeBase.isExtendViewDirty() && (bl || pSSubViewTypeBase.getExtendView() != null)) {
            iDataObject.set(FIELD_EXTENDVIEW, (Object)pSSubViewTypeBase.getExtendView());
        }
        if (pSSubViewTypeBase.isLockFlagDirty() && (bl || pSSubViewTypeBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSSubViewTypeBase.getLockFlag());
        }
        if (pSSubViewTypeBase.isMemoDirty() && (bl || pSSubViewTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSubViewTypeBase.getMemo());
        }
        if (pSSubViewTypeBase.isNameModeDirty() && (bl || pSSubViewTypeBase.getNameMode() != null)) {
            iDataObject.set(FIELD_NAMEMODE, (Object)pSSubViewTypeBase.getNameMode());
        }
        if (pSSubViewTypeBase.isPreviewHtmlDirty() && (bl || pSSubViewTypeBase.getPreviewHtml() != null)) {
            iDataObject.set(FIELD_PREVIEWHTML, (Object)pSSubViewTypeBase.getPreviewHtml());
        }
        if (pSSubViewTypeBase.isPSModuleIdDirty() && (bl || pSSubViewTypeBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSSubViewTypeBase.getPSModuleId());
        }
        if (pSSubViewTypeBase.isPSModuleNameDirty() && (bl || pSSubViewTypeBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSSubViewTypeBase.getPSModuleName());
        }
        if (pSSubViewTypeBase.isPSSubViewTypeIdDirty() && (bl || pSSubViewTypeBase.getPSSubViewTypeId() != null)) {
            iDataObject.set(FIELD_PSSUBVIEWTYPEID, (Object)pSSubViewTypeBase.getPSSubViewTypeId());
        }
        if (pSSubViewTypeBase.isPSSubViewTypeNameDirty() && (bl || pSSubViewTypeBase.getPSSubViewTypeName() != null)) {
            iDataObject.set(FIELD_PSSUBVIEWTYPENAME, (Object)pSSubViewTypeBase.getPSSubViewTypeName());
        }
        if (pSSubViewTypeBase.isPSSysPFPluginIdDirty() && (bl || pSSubViewTypeBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSSubViewTypeBase.getPSSysPFPluginId());
        }
        if (pSSubViewTypeBase.isPSSysPFPluginNameDirty() && (bl || pSSubViewTypeBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSSubViewTypeBase.getPSSysPFPluginName());
        }
        if (pSSubViewTypeBase.isPSSystemIdDirty() && (bl || pSSubViewTypeBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSubViewTypeBase.getPSSystemId());
        }
        if (pSSubViewTypeBase.isPSSystemNameDirty() && (bl || pSSubViewTypeBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSubViewTypeBase.getPSSystemName());
        }
        if (pSSubViewTypeBase.isPSSysViewPanelIdDirty() && (bl || pSSubViewTypeBase.getPSSysViewPanelId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELID, (Object)pSSubViewTypeBase.getPSSysViewPanelId());
        }
        if (pSSubViewTypeBase.isPSSysViewPanelNameDirty() && (bl || pSSubViewTypeBase.getPSSysViewPanelName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELNAME, (Object)pSSubViewTypeBase.getPSSysViewPanelName());
        }
        if (pSSubViewTypeBase.isPSViewTypeIdDirty() && (bl || pSSubViewTypeBase.getPSViewTypeId() != null)) {
            iDataObject.set(FIELD_PSVIEWTYPEID, (Object)pSSubViewTypeBase.getPSViewTypeId());
        }
        if (pSSubViewTypeBase.isPSViewTypeNameDirty() && (bl || pSSubViewTypeBase.getPSViewTypeName() != null)) {
            iDataObject.set(FIELD_PSVIEWTYPENAME, (Object)pSSubViewTypeBase.getPSViewTypeName());
        }
        if (pSSubViewTypeBase.isRepDefaultDirty() && (bl || pSSubViewTypeBase.getRepDefault() != null)) {
            iDataObject.set(FIELD_REPDEFAULT, (Object)pSSubViewTypeBase.getRepDefault());
        }
        if (pSSubViewTypeBase.isStudioIconDirty() && (bl || pSSubViewTypeBase.getStudioIcon() != null)) {
            iDataObject.set(FIELD_STUDIOICON, (Object)pSSubViewTypeBase.getStudioIcon());
        }
        if (pSSubViewTypeBase.isTypeCodeDirty() && (bl || pSSubViewTypeBase.getTypeCode() != null)) {
            iDataObject.set(FIELD_TYPECODE, (Object)pSSubViewTypeBase.getTypeCode());
        }
        if (pSSubViewTypeBase.isUpdateDateDirty() && (bl || pSSubViewTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSubViewTypeBase.getUpdateDate());
        }
        if (pSSubViewTypeBase.isUpdateManDirty() && (bl || pSSubViewTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSubViewTypeBase.getUpdateMan());
        }
        if (pSSubViewTypeBase.isUserCatDirty() && (bl || pSSubViewTypeBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSubViewTypeBase.getUserCat());
        }
        if (pSSubViewTypeBase.isUserTagDirty() && (bl || pSSubViewTypeBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSubViewTypeBase.getUserTag());
        }
        if (pSSubViewTypeBase.isUserTag2Dirty() && (bl || pSSubViewTypeBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSubViewTypeBase.getUserTag2());
        }
        if (pSSubViewTypeBase.isUserTag3Dirty() && (bl || pSSubViewTypeBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSubViewTypeBase.getUserTag3());
        }
        if (pSSubViewTypeBase.isUserTag4Dirty() && (bl || pSSubViewTypeBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSubViewTypeBase.getUserTag4());
        }
        if (pSSubViewTypeBase.isUtilParamsDirty() && (bl || pSSubViewTypeBase.getUtilParams() != null)) {
            iDataObject.set(FIELD_UTILPARAMS, (Object)pSSubViewTypeBase.getUtilParams());
        }
        if (pSSubViewTypeBase.isViewModelDirty() && (bl || pSSubViewTypeBase.getViewModel() != null)) {
            iDataObject.set(FIELD_VIEWMODEL, (Object)pSSubViewTypeBase.getViewModel());
        }
        if (pSSubViewTypeBase.isViewParamsDirty() && (bl || pSSubViewTypeBase.getViewParams() != null)) {
            iDataObject.set(FIELD_VIEWPARAMS, (Object)pSSubViewTypeBase.getViewParams());
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
        return PSSubViewTypeBase.remove(this, n);
    }

    private static boolean remove(PSSubViewTypeBase pSSubViewTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSubViewTypeBase.resetCodeName();
                return true;
            }
            case 1: {
                pSSubViewTypeBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSubViewTypeBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSubViewTypeBase.resetExtendCtrl();
                return true;
            }
            case 4: {
                pSSubViewTypeBase.resetExtendEngine();
                return true;
            }
            case 5: {
                pSSubViewTypeBase.resetExtendStyleOnly();
                return true;
            }
            case 6: {
                pSSubViewTypeBase.resetExtendView();
                return true;
            }
            case 7: {
                pSSubViewTypeBase.resetLockFlag();
                return true;
            }
            case 8: {
                pSSubViewTypeBase.resetMemo();
                return true;
            }
            case 9: {
                pSSubViewTypeBase.resetNameMode();
                return true;
            }
            case 10: {
                pSSubViewTypeBase.resetPreviewHtml();
                return true;
            }
            case 11: {
                pSSubViewTypeBase.resetPSModuleId();
                return true;
            }
            case 12: {
                pSSubViewTypeBase.resetPSModuleName();
                return true;
            }
            case 13: {
                pSSubViewTypeBase.resetPSSubViewTypeId();
                return true;
            }
            case 14: {
                pSSubViewTypeBase.resetPSSubViewTypeName();
                return true;
            }
            case 15: {
                pSSubViewTypeBase.resetPSSysPFPluginId();
                return true;
            }
            case 16: {
                pSSubViewTypeBase.resetPSSysPFPluginName();
                return true;
            }
            case 17: {
                pSSubViewTypeBase.resetPSSystemId();
                return true;
            }
            case 18: {
                pSSubViewTypeBase.resetPSSystemName();
                return true;
            }
            case 19: {
                pSSubViewTypeBase.resetPSSysViewPanelId();
                return true;
            }
            case 20: {
                pSSubViewTypeBase.resetPSSysViewPanelName();
                return true;
            }
            case 21: {
                pSSubViewTypeBase.resetPSViewTypeId();
                return true;
            }
            case 22: {
                pSSubViewTypeBase.resetPSViewTypeName();
                return true;
            }
            case 23: {
                pSSubViewTypeBase.resetRepDefault();
                return true;
            }
            case 24: {
                pSSubViewTypeBase.resetStudioIcon();
                return true;
            }
            case 25: {
                pSSubViewTypeBase.resetTypeCode();
                return true;
            }
            case 26: {
                pSSubViewTypeBase.resetUpdateDate();
                return true;
            }
            case 27: {
                pSSubViewTypeBase.resetUpdateMan();
                return true;
            }
            case 28: {
                pSSubViewTypeBase.resetUserCat();
                return true;
            }
            case 29: {
                pSSubViewTypeBase.resetUserTag();
                return true;
            }
            case 30: {
                pSSubViewTypeBase.resetUserTag2();
                return true;
            }
            case 31: {
                pSSubViewTypeBase.resetUserTag3();
                return true;
            }
            case 32: {
                pSSubViewTypeBase.resetUserTag4();
                return true;
            }
            case 33: {
                pSSubViewTypeBase.resetUtilParams();
                return true;
            }
            case 34: {
                pSSubViewTypeBase.resetViewModel();
                return true;
            }
            case 35: {
                pSSubViewTypeBase.resetViewParams();
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
    public PSSysViewPanel getPSSysViewPanel() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewPanel();
        }
        if (this.getPSSysViewPanelId() == null) {
            return null;
        }
        Integer n = this.objPSSysViewPanelLock;
        synchronized (n) {
            if (this.pssysviewpanel != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysViewPanelId(), (Object)this.pssysviewpanel.getPSSysViewPanelId()) != 0L) {
                this.pssysviewpanel = null;
            }
            if (this.pssysviewpanel == null) {
                PSSysViewPanel pSSysViewPanel = new PSSysViewPanel();
                pSSysViewPanel.setPSSysViewPanelId(this.getPSSysViewPanelId());
                PSSysViewPanelService pSSysViewPanelService = (PSSysViewPanelService)ServiceGlobal.getService(PSSysViewPanelService.class, (SessionFactory)this.getSessionFactory());
                pSSysViewPanelService.autoGet((IEntity)pSSysViewPanel);
                this.pssysviewpanel = pSSysViewPanel;
            }
            return this.pssysviewpanel;
        }
    }

    private PSSubViewTypeBase getProxyEntity() {
        return this.proxyPSSubViewTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSubViewTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSSubViewTypeBase) {
            this.proxyPSSubViewTypeBase = (PSSubViewTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSubViewTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_EXTENDCTRL, 3);
        fieldIndexMap.put(FIELD_EXTENDENGINE, 4);
        fieldIndexMap.put(FIELD_EXTENDSTYLEONLY, 5);
        fieldIndexMap.put(FIELD_EXTENDVIEW, 6);
        fieldIndexMap.put(FIELD_LOCKFLAG, 7);
        fieldIndexMap.put(FIELD_MEMO, 8);
        fieldIndexMap.put(FIELD_NAMEMODE, 9);
        fieldIndexMap.put(FIELD_PREVIEWHTML, 10);
        fieldIndexMap.put(FIELD_PSMODULEID, 11);
        fieldIndexMap.put(FIELD_PSMODULENAME, 12);
        fieldIndexMap.put(FIELD_PSSUBVIEWTYPEID, 13);
        fieldIndexMap.put(FIELD_PSSUBVIEWTYPENAME, 14);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINID, 15);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINNAME, 16);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 17);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 18);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELID, 19);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELNAME, 20);
        fieldIndexMap.put(FIELD_PSVIEWTYPEID, 21);
        fieldIndexMap.put(FIELD_PSVIEWTYPENAME, 22);
        fieldIndexMap.put(FIELD_REPDEFAULT, 23);
        fieldIndexMap.put(FIELD_STUDIOICON, 24);
        fieldIndexMap.put(FIELD_TYPECODE, 25);
        fieldIndexMap.put(FIELD_UPDATEDATE, 26);
        fieldIndexMap.put(FIELD_UPDATEMAN, 27);
        fieldIndexMap.put(FIELD_USERCAT, 28);
        fieldIndexMap.put(FIELD_USERTAG, 29);
        fieldIndexMap.put(FIELD_USERTAG2, 30);
        fieldIndexMap.put(FIELD_USERTAG3, 31);
        fieldIndexMap.put(FIELD_USERTAG4, 32);
        fieldIndexMap.put(FIELD_UTILPARAMS, 33);
        fieldIndexMap.put(FIELD_VIEWMODEL, 34);
        fieldIndexMap.put(FIELD_VIEWPARAMS, 35);
    }
}

