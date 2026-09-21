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
import net.ibizsys.pscore.srv.appdesign.entity.PSAppMenuItem;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppMenuLogic;
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuItemService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuLogicService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuService;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.service.PSSysPFPluginService;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaApp;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaAppService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlMsg;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCounter;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewMsgGroup;
import net.ibizsys.pscore.srv.sysdesign.service.PSCtrlMsgService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCounterService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgGroupService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppMenuBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSAppMenuBase.class);
    public static final String FIELD_APPMENUSTYLE = "APPMENUSTYLE";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMIZEDFLAG = "CUSTOMIZEDFLAG";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_FLEXALIGN = "FLEXALIGN";
    public static final String FIELD_FLEXDIR = "FLEXDIR";
    public static final String FIELD_FLEXVALIGN = "FLEXVALIGN";
    public static final String FIELD_FROMOBJID = "FROMOBJID";
    public static final String FIELD_ICONALIGN = "ICONALIGN";
    public static final String FIELD_JSMODEL = "JSMODEL";
    public static final String FIELD_LAYOUTMODE = "LAYOUTMODE";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MENUMODEL = "MENUMODEL";
    public static final String FIELD_MENUSN = "MENUSN";
    public static final String FIELD_OWNERID = "OWNERID";
    public static final String FIELD_OWNERTAG = "OWNERTAG";
    public static final String FIELD_OWNERTYPE = "OWNERTYPE";
    public static final String FIELD_PSAPPMENUID = "PSAPPMENUID";
    public static final String FIELD_PSAPPMENUNAME = "PSAPPMENUNAME";
    public static final String FIELD_PSCTRLMSGID = "PSCTRLMSGID";
    public static final String FIELD_PSCTRLMSGNAME = "PSCTRLMSGNAME";
    public static final String FIELD_PSDYNAAPPID = "PSDYNAAPPID";
    public static final String FIELD_PSDYNAAPPNAME = "PSDYNAAPPNAME";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String FIELD_PSSYSCOUNTERID = "PSSYSCOUNTERID";
    public static final String FIELD_PSSYSCOUNTERNAME = "PSSYSCOUNTERNAME";
    public static final String FIELD_PSSYSCSSID = "PSSYSCSSID";
    public static final String FIELD_PSSYSCSSNAME = "PSSYSCSSNAME";
    public static final String FIELD_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String FIELD_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String FIELD_PSSYSREQITEMID = "PSSYSREQITEMID";
    public static final String FIELD_PSSYSREQITEMNAME = "PSSYSREQITEMNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSVIEWMSGGROUPID = "PSVIEWMSGGROUPID";
    public static final String FIELD_PSVIEWMSGGROUPNAME = "PSVIEWMSGGROUPNAME";
    public static final String FIELD_PUBLICFLAG = "PUBLICFLAG";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERPARAMS = "USERPARAMS";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    private static final int INDEX_APPMENUSTYLE = 0;
    private static final int INDEX_CODENAME = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_CUSTOMIZEDFLAG = 4;
    private static final int INDEX_DYNAMODELFLAG = 5;
    private static final int INDEX_FLEXALIGN = 6;
    private static final int INDEX_FLEXDIR = 7;
    private static final int INDEX_FLEXVALIGN = 8;
    private static final int INDEX_FROMOBJID = 9;
    private static final int INDEX_ICONALIGN = 10;
    private static final int INDEX_JSMODEL = 11;
    private static final int INDEX_LAYOUTMODE = 12;
    private static final int INDEX_LOGICNAME = 13;
    private static final int INDEX_MEMO = 14;
    private static final int INDEX_MENUMODEL = 15;
    private static final int INDEX_MENUSN = 16;
    private static final int INDEX_OWNERID = 17;
    private static final int INDEX_OWNERTAG = 18;
    private static final int INDEX_OWNERTYPE = 19;
    private static final int INDEX_PSAPPMENUID = 20;
    private static final int INDEX_PSAPPMENUNAME = 21;
    private static final int INDEX_PSCTRLMSGID = 22;
    private static final int INDEX_PSCTRLMSGNAME = 23;
    private static final int INDEX_PSDYNAAPPID = 24;
    private static final int INDEX_PSDYNAAPPNAME = 25;
    private static final int INDEX_PSSYSAPPID = 26;
    private static final int INDEX_PSSYSAPPNAME = 27;
    private static final int INDEX_PSSYSCOUNTERID = 28;
    private static final int INDEX_PSSYSCOUNTERNAME = 29;
    private static final int INDEX_PSSYSCSSID = 30;
    private static final int INDEX_PSSYSCSSNAME = 31;
    private static final int INDEX_PSSYSPFPLUGINID = 32;
    private static final int INDEX_PSSYSPFPLUGINNAME = 33;
    private static final int INDEX_PSSYSREQITEMID = 34;
    private static final int INDEX_PSSYSREQITEMNAME = 35;
    private static final int INDEX_PSSYSTEMID = 36;
    private static final int INDEX_PSVIEWMSGGROUPID = 37;
    private static final int INDEX_PSVIEWMSGGROUPNAME = 38;
    private static final int INDEX_PUBLICFLAG = 39;
    private static final int INDEX_UPDATEDATE = 40;
    private static final int INDEX_UPDATEMAN = 41;
    private static final int INDEX_USERPARAMS = 42;
    private static final int INDEX_USERTAG = 43;
    private static final int INDEX_USERTAG2 = 44;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSAppMenuBase proxyPSAppMenuBase = null;
    private boolean appmenustyleDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customizedflagDirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean flexalignDirtyFlag = false;
    private boolean flexdirDirtyFlag = false;
    private boolean flexvalignDirtyFlag = false;
    private boolean fromobjidDirtyFlag = false;
    private boolean iconalignDirtyFlag = false;
    private boolean jsmodelDirtyFlag = false;
    private boolean layoutmodeDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean menumodelDirtyFlag = false;
    private boolean menusnDirtyFlag = false;
    private boolean owneridDirtyFlag = false;
    private boolean ownertagDirtyFlag = false;
    private boolean ownertypeDirtyFlag = false;
    private boolean psappmenuidDirtyFlag = false;
    private boolean psappmenunameDirtyFlag = false;
    private boolean psctrlmsgidDirtyFlag = false;
    private boolean psctrlmsgnameDirtyFlag = false;
    private boolean psdynaappidDirtyFlag = false;
    private boolean psdynaappnameDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean pssysappnameDirtyFlag = false;
    private boolean pssyscounteridDirtyFlag = false;
    private boolean pssyscounternameDirtyFlag = false;
    private boolean pssyscssidDirtyFlag = false;
    private boolean pssyscssnameDirtyFlag = false;
    private boolean pssyspfpluginidDirtyFlag = false;
    private boolean pssyspfpluginnameDirtyFlag = false;
    private boolean pssysreqitemidDirtyFlag = false;
    private boolean pssysreqitemnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean psviewmsggroupidDirtyFlag = false;
    private boolean psviewmsggroupnameDirtyFlag = false;
    private boolean publicflagDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean userparamsDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    @Column(name="appmenustyle")
    private String appmenustyle;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="customizedflag")
    private Integer customizedflag;
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="flexalign")
    private String flexalign;
    @Column(name="flexdir")
    private String flexdir;
    @Column(name="flexvalign")
    private String flexvalign;
    @Column(name="fromobjid")
    private String fromobjid;
    @Column(name="iconalign")
    private String iconalign;
    @Column(name="jsmodel")
    private String jsmodel;
    @Column(name="layoutmode")
    private String layoutmode;
    @Column(name="logicname")
    private String logicname;
    @Column(name="memo")
    private String memo;
    @Column(name="menumodel")
    private String menumodel;
    @Column(name="menusn")
    private String menusn;
    @Column(name="ownerid")
    private String ownerid;
    @Column(name="ownertag")
    private String ownertag;
    @Column(name="ownertype")
    private String ownertype;
    @Column(name="psappmenuid")
    private String psappmenuid;
    @Column(name="psappmenuname")
    private String psappmenuname;
    @Column(name="psctrlmsgid")
    private String psctrlmsgid;
    @Column(name="psctrlmsgname")
    private String psctrlmsgname;
    @Column(name="psdynaappid")
    private String psdynaappid;
    @Column(name="psdynaappname")
    private String psdynaappname;
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
    @Column(name="pssysreqitemid")
    private String pssysreqitemid;
    @Column(name="pssysreqitemname")
    private String pssysreqitemname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="psviewmsggroupid")
    private String psviewmsggroupid;
    @Column(name="psviewmsggroupname")
    private String psviewmsggroupname;
    @Column(name="publicflag")
    private Integer publicflag;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="userparams")
    private String userparams;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    private Integer objPSCtrlMsgLock = new Integer(1);
    private PSCtrlMsg psctrlmsg = null;
    private Integer objPSDynaAppLock = new Integer(1);
    private PSDynaApp psdynaapp = null;
    private Integer objPSSysAppLock = new Integer(1);
    private PSSysApp pssysapp = null;
    private Integer objPSSysCounterLock = new Integer(1);
    private PSSysCounter pssyscounter = null;
    private Integer objPSSysCssLock = new Integer(1);
    private PSSysCss pssyscss = null;
    private Integer objPSSysPFPluginLock = new Integer(1);
    private PSSysPFPlugin pssyspfplugin = null;
    private Integer objPSSysReqItemLock = new Integer(1);
    private PSSysReqItem pssysreqitem = null;
    private Integer objPSViewMsgGroupLock = new Integer(1);
    private PSViewMsgGroup psviewmsggroup = null;
    private Integer objPSAppMenuItemsLock = new Integer(1);
    private ArrayList<PSAppMenuItem> psappmenuitems = null;
    private Integer objPSAppMenuLogicsLock = new Integer(1);
    private ArrayList<PSAppMenuLogic> psappmenulogics = null;

    public void setAppMenuStyle(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAppMenuStyle(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.appmenustyle = string;
        this.appmenustyleDirtyFlag = true;
    }

    public String getAppMenuStyle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAppMenuStyle();
        }
        return this.appmenustyle;
    }

    public boolean isAppMenuStyleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAppMenuStyleDirty();
        }
        return this.appmenustyleDirtyFlag;
    }

    public void resetAppMenuStyle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAppMenuStyle();
            return;
        }
        this.appmenustyleDirtyFlag = false;
        this.appmenustyle = null;
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

    public void setCustomizedFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomizedFlag(n);
            return;
        }
        this.customizedflag = n;
        this.customizedflagDirtyFlag = true;
    }

    public Integer getCustomizedFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomizedFlag();
        }
        return this.customizedflag;
    }

    public boolean isCustomizedFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomizedFlagDirty();
        }
        return this.customizedflagDirtyFlag;
    }

    public void resetCustomizedFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomizedFlag();
            return;
        }
        this.customizedflagDirtyFlag = false;
        this.customizedflag = null;
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

    public void setFlexAlign(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFlexAlign(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.flexalign = string;
        this.flexalignDirtyFlag = true;
    }

    public String getFlexAlign() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFlexAlign();
        }
        return this.flexalign;
    }

    public boolean isFlexAlignDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFlexAlignDirty();
        }
        return this.flexalignDirtyFlag;
    }

    public void resetFlexAlign() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFlexAlign();
            return;
        }
        this.flexalignDirtyFlag = false;
        this.flexalign = null;
    }

    public void setFlexDir(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFlexDir(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.flexdir = string;
        this.flexdirDirtyFlag = true;
    }

    public String getFlexDir() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFlexDir();
        }
        return this.flexdir;
    }

    public boolean isFlexDirDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFlexDirDirty();
        }
        return this.flexdirDirtyFlag;
    }

    public void resetFlexDir() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFlexDir();
            return;
        }
        this.flexdirDirtyFlag = false;
        this.flexdir = null;
    }

    public void setFlexVAlign(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFlexVAlign(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.flexvalign = string;
        this.flexvalignDirtyFlag = true;
    }

    public String getFlexVAlign() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFlexVAlign();
        }
        return this.flexvalign;
    }

    public boolean isFlexVAlignDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFlexVAlignDirty();
        }
        return this.flexvalignDirtyFlag;
    }

    public void resetFlexVAlign() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFlexVAlign();
            return;
        }
        this.flexvalignDirtyFlag = false;
        this.flexvalign = null;
    }

    public void setFromObjId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFromObjId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.fromobjid = string;
        this.fromobjidDirtyFlag = true;
    }

    public String getFromObjId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFromObjId();
        }
        return this.fromobjid;
    }

    public boolean isFromObjIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFromObjIdDirty();
        }
        return this.fromobjidDirtyFlag;
    }

    public void resetFromObjId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFromObjId();
            return;
        }
        this.fromobjidDirtyFlag = false;
        this.fromobjid = null;
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

    public void setJSModel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setJSModel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.jsmodel = string;
        this.jsmodelDirtyFlag = true;
    }

    public String getJSModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getJSModel();
        }
        return this.jsmodel;
    }

    public boolean isJSModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isJSModelDirty();
        }
        return this.jsmodelDirtyFlag;
    }

    public void resetJSModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetJSModel();
            return;
        }
        this.jsmodelDirtyFlag = false;
        this.jsmodel = null;
    }

    public void setLayoutMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLayoutMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.layoutmode = string;
        this.layoutmodeDirtyFlag = true;
    }

    public String getLayoutMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLayoutMode();
        }
        return this.layoutmode;
    }

    public boolean isLayoutModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLayoutModeDirty();
        }
        return this.layoutmodeDirtyFlag;
    }

    public void resetLayoutMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLayoutMode();
            return;
        }
        this.layoutmodeDirtyFlag = false;
        this.layoutmode = null;
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

    public void setMenuModel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMenuModel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.menumodel = string;
        this.menumodelDirtyFlag = true;
    }

    public String getMenuModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMenuModel();
        }
        return this.menumodel;
    }

    public boolean isMenuModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMenuModelDirty();
        }
        return this.menumodelDirtyFlag;
    }

    public void resetMenuModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMenuModel();
            return;
        }
        this.menumodelDirtyFlag = false;
        this.menumodel = null;
    }

    public void setMenuSN(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMenuSN(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.menusn = string;
        this.menusnDirtyFlag = true;
    }

    public String getMenuSN() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMenuSN();
        }
        return this.menusn;
    }

    public boolean isMenuSNDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMenuSNDirty();
        }
        return this.menusnDirtyFlag;
    }

    public void resetMenuSN() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMenuSN();
            return;
        }
        this.menusnDirtyFlag = false;
        this.menusn = null;
    }

    public void setOwnerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOwnerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ownerid = string;
        this.owneridDirtyFlag = true;
    }

    public String getOwnerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOwnerId();
        }
        return this.ownerid;
    }

    public boolean isOwnerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOwnerIdDirty();
        }
        return this.owneridDirtyFlag;
    }

    public void resetOwnerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOwnerId();
            return;
        }
        this.owneridDirtyFlag = false;
        this.ownerid = null;
    }

    public void setOwnerTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOwnerTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ownertag = string;
        this.ownertagDirtyFlag = true;
    }

    public String getOwnerTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOwnerTag();
        }
        return this.ownertag;
    }

    public boolean isOwnerTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOwnerTagDirty();
        }
        return this.ownertagDirtyFlag;
    }

    public void resetOwnerTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOwnerTag();
            return;
        }
        this.ownertagDirtyFlag = false;
        this.ownertag = null;
    }

    public void setOwnerType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOwnerType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ownertype = string;
        this.ownertypeDirtyFlag = true;
    }

    public String getOwnerType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOwnerType();
        }
        return this.ownertype;
    }

    public boolean isOwnerTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOwnerTypeDirty();
        }
        return this.ownertypeDirtyFlag;
    }

    public void resetOwnerType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOwnerType();
            return;
        }
        this.ownertypeDirtyFlag = false;
        this.ownertype = null;
    }

    public void setPSAppMenuId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppMenuId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappmenuid = string;
        this.psappmenuidDirtyFlag = true;
    }

    public String getPSAppMenuId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppMenuId();
        }
        return this.psappmenuid;
    }

    public boolean isPSAppMenuIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppMenuIdDirty();
        }
        return this.psappmenuidDirtyFlag;
    }

    public void resetPSAppMenuId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppMenuId();
            return;
        }
        this.psappmenuidDirtyFlag = false;
        this.psappmenuid = null;
    }

    public void setPSAppMenuName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppMenuName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappmenuname = string;
        this.psappmenunameDirtyFlag = true;
    }

    public String getPSAppMenuName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppMenuName();
        }
        return this.psappmenuname;
    }

    public boolean isPSAppMenuNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppMenuNameDirty();
        }
        return this.psappmenunameDirtyFlag;
    }

    public void resetPSAppMenuName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppMenuName();
            return;
        }
        this.psappmenunameDirtyFlag = false;
        this.psappmenuname = null;
    }

    public void setPSCtrlMsgId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlMsgId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrlmsgid = string;
        this.psctrlmsgidDirtyFlag = true;
    }

    public String getPSCtrlMsgId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlMsgId();
        }
        return this.psctrlmsgid;
    }

    public boolean isPSCtrlMsgIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlMsgIdDirty();
        }
        return this.psctrlmsgidDirtyFlag;
    }

    public void resetPSCtrlMsgId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlMsgId();
            return;
        }
        this.psctrlmsgidDirtyFlag = false;
        this.psctrlmsgid = null;
    }

    public void setPSCtrlMsgName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlMsgName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrlmsgname = string;
        this.psctrlmsgnameDirtyFlag = true;
    }

    public String getPSCtrlMsgName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlMsgName();
        }
        return this.psctrlmsgname;
    }

    public boolean isPSCtrlMsgNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlMsgNameDirty();
        }
        return this.psctrlmsgnameDirtyFlag;
    }

    public void resetPSCtrlMsgName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlMsgName();
            return;
        }
        this.psctrlmsgnameDirtyFlag = false;
        this.psctrlmsgname = null;
    }

    public void setPSDynaAppId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaAppId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynaappid = string;
        this.psdynaappidDirtyFlag = true;
    }

    public String getPSDynaAppId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaAppId();
        }
        return this.psdynaappid;
    }

    public boolean isPSDynaAppIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaAppIdDirty();
        }
        return this.psdynaappidDirtyFlag;
    }

    public void resetPSDynaAppId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaAppId();
            return;
        }
        this.psdynaappidDirtyFlag = false;
        this.psdynaappid = null;
    }

    public void setPSDynaAppName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaAppName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynaappname = string;
        this.psdynaappnameDirtyFlag = true;
    }

    public String getPSDynaAppName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaAppName();
        }
        return this.psdynaappname;
    }

    public boolean isPSDynaAppNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaAppNameDirty();
        }
        return this.psdynaappnameDirtyFlag;
    }

    public void resetPSDynaAppName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaAppName();
            return;
        }
        this.psdynaappnameDirtyFlag = false;
        this.psdynaappname = null;
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

    public void setPublicFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPublicFlag(n);
            return;
        }
        this.publicflag = n;
        this.publicflagDirtyFlag = true;
    }

    public Integer getPublicFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPublicFlag();
        }
        return this.publicflag;
    }

    public boolean isPublicFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPublicFlagDirty();
        }
        return this.publicflagDirtyFlag;
    }

    public void resetPublicFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPublicFlag();
            return;
        }
        this.publicflagDirtyFlag = false;
        this.publicflag = null;
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

    protected void onReset() {
        PSAppMenuBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSAppMenuBase pSAppMenuBase) {
        pSAppMenuBase.resetAppMenuStyle();
        pSAppMenuBase.resetCodeName();
        pSAppMenuBase.resetCreateDate();
        pSAppMenuBase.resetCreateMan();
        pSAppMenuBase.resetCustomizedFlag();
        pSAppMenuBase.resetDynaModelFlag();
        pSAppMenuBase.resetFlexAlign();
        pSAppMenuBase.resetFlexDir();
        pSAppMenuBase.resetFlexVAlign();
        pSAppMenuBase.resetFromObjId();
        pSAppMenuBase.resetIconAlign();
        pSAppMenuBase.resetJSModel();
        pSAppMenuBase.resetLayoutMode();
        pSAppMenuBase.resetLogicName();
        pSAppMenuBase.resetMemo();
        pSAppMenuBase.resetMenuModel();
        pSAppMenuBase.resetMenuSN();
        pSAppMenuBase.resetOwnerId();
        pSAppMenuBase.resetOwnerTag();
        pSAppMenuBase.resetOwnerType();
        pSAppMenuBase.resetPSAppMenuId();
        pSAppMenuBase.resetPSAppMenuName();
        pSAppMenuBase.resetPSCtrlMsgId();
        pSAppMenuBase.resetPSCtrlMsgName();
        pSAppMenuBase.resetPSDynaAppId();
        pSAppMenuBase.resetPSDynaAppName();
        pSAppMenuBase.resetPSSysAppId();
        pSAppMenuBase.resetPSSysAppName();
        pSAppMenuBase.resetPSSysCounterId();
        pSAppMenuBase.resetPSSysCounterName();
        pSAppMenuBase.resetPSSysCssId();
        pSAppMenuBase.resetPSSysCssName();
        pSAppMenuBase.resetPSSysPFPluginId();
        pSAppMenuBase.resetPSSysPFPluginName();
        pSAppMenuBase.resetPSSysReqItemId();
        pSAppMenuBase.resetPSSysReqItemName();
        pSAppMenuBase.resetPSSystemId();
        pSAppMenuBase.resetPSViewMsgGroupId();
        pSAppMenuBase.resetPSViewMsgGroupName();
        pSAppMenuBase.resetPublicFlag();
        pSAppMenuBase.resetUpdateDate();
        pSAppMenuBase.resetUpdateMan();
        pSAppMenuBase.resetUserParams();
        pSAppMenuBase.resetUserTag();
        pSAppMenuBase.resetUserTag2();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAppMenuStyleDirty()) {
            hashMap.put(FIELD_APPMENUSTYLE, this.getAppMenuStyle());
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
        if (!bl || this.isCustomizedFlagDirty()) {
            hashMap.put(FIELD_CUSTOMIZEDFLAG, this.getCustomizedFlag());
        }
        if (!bl || this.isDynaModelFlagDirty()) {
            hashMap.put(FIELD_DYNAMODELFLAG, this.getDynaModelFlag());
        }
        if (!bl || this.isFlexAlignDirty()) {
            hashMap.put(FIELD_FLEXALIGN, this.getFlexAlign());
        }
        if (!bl || this.isFlexDirDirty()) {
            hashMap.put(FIELD_FLEXDIR, this.getFlexDir());
        }
        if (!bl || this.isFlexVAlignDirty()) {
            hashMap.put(FIELD_FLEXVALIGN, this.getFlexVAlign());
        }
        if (!bl || this.isFromObjIdDirty()) {
            hashMap.put(FIELD_FROMOBJID, this.getFromObjId());
        }
        if (!bl || this.isIconAlignDirty()) {
            hashMap.put(FIELD_ICONALIGN, this.getIconAlign());
        }
        if (!bl || this.isJSModelDirty()) {
            hashMap.put(FIELD_JSMODEL, this.getJSModel());
        }
        if (!bl || this.isLayoutModeDirty()) {
            hashMap.put(FIELD_LAYOUTMODE, this.getLayoutMode());
        }
        if (!bl || this.isLogicNameDirty()) {
            hashMap.put(FIELD_LOGICNAME, this.getLogicName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMenuModelDirty()) {
            hashMap.put(FIELD_MENUMODEL, this.getMenuModel());
        }
        if (!bl || this.isMenuSNDirty()) {
            hashMap.put(FIELD_MENUSN, this.getMenuSN());
        }
        if (!bl || this.isOwnerIdDirty()) {
            hashMap.put(FIELD_OWNERID, this.getOwnerId());
        }
        if (!bl || this.isOwnerTagDirty()) {
            hashMap.put(FIELD_OWNERTAG, this.getOwnerTag());
        }
        if (!bl || this.isOwnerTypeDirty()) {
            hashMap.put(FIELD_OWNERTYPE, this.getOwnerType());
        }
        if (!bl || this.isPSAppMenuIdDirty()) {
            hashMap.put(FIELD_PSAPPMENUID, this.getPSAppMenuId());
        }
        if (!bl || this.isPSAppMenuNameDirty()) {
            hashMap.put(FIELD_PSAPPMENUNAME, this.getPSAppMenuName());
        }
        if (!bl || this.isPSCtrlMsgIdDirty()) {
            hashMap.put(FIELD_PSCTRLMSGID, this.getPSCtrlMsgId());
        }
        if (!bl || this.isPSCtrlMsgNameDirty()) {
            hashMap.put(FIELD_PSCTRLMSGNAME, this.getPSCtrlMsgName());
        }
        if (!bl || this.isPSDynaAppIdDirty()) {
            hashMap.put(FIELD_PSDYNAAPPID, this.getPSDynaAppId());
        }
        if (!bl || this.isPSDynaAppNameDirty()) {
            hashMap.put(FIELD_PSDYNAAPPNAME, this.getPSDynaAppName());
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
        if (!bl || this.isPSSysReqItemIdDirty()) {
            hashMap.put(FIELD_PSSYSREQITEMID, this.getPSSysReqItemId());
        }
        if (!bl || this.isPSSysReqItemNameDirty()) {
            hashMap.put(FIELD_PSSYSREQITEMNAME, this.getPSSysReqItemName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSViewMsgGroupIdDirty()) {
            hashMap.put(FIELD_PSVIEWMSGGROUPID, this.getPSViewMsgGroupId());
        }
        if (!bl || this.isPSViewMsgGroupNameDirty()) {
            hashMap.put(FIELD_PSVIEWMSGGROUPNAME, this.getPSViewMsgGroupName());
        }
        if (!bl || this.isPublicFlagDirty()) {
            hashMap.put(FIELD_PUBLICFLAG, this.getPublicFlag());
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
        if (!bl || this.isUserTagDirty()) {
            hashMap.put(FIELD_USERTAG, this.getUserTag());
        }
        if (!bl || this.isUserTag2Dirty()) {
            hashMap.put(FIELD_USERTAG2, this.getUserTag2());
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
        return PSAppMenuBase.get(this, n);
    }

    private static Object get(PSAppMenuBase pSAppMenuBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppMenuBase.getAppMenuStyle();
            }
            case 1: {
                return pSAppMenuBase.getCodeName();
            }
            case 2: {
                return pSAppMenuBase.getCreateDate();
            }
            case 3: {
                return pSAppMenuBase.getCreateMan();
            }
            case 4: {
                return pSAppMenuBase.getCustomizedFlag();
            }
            case 5: {
                return pSAppMenuBase.getDynaModelFlag();
            }
            case 6: {
                return pSAppMenuBase.getFlexAlign();
            }
            case 7: {
                return pSAppMenuBase.getFlexDir();
            }
            case 8: {
                return pSAppMenuBase.getFlexVAlign();
            }
            case 9: {
                return pSAppMenuBase.getFromObjId();
            }
            case 10: {
                return pSAppMenuBase.getIconAlign();
            }
            case 11: {
                return pSAppMenuBase.getJSModel();
            }
            case 12: {
                return pSAppMenuBase.getLayoutMode();
            }
            case 13: {
                return pSAppMenuBase.getLogicName();
            }
            case 14: {
                return pSAppMenuBase.getMemo();
            }
            case 15: {
                return pSAppMenuBase.getMenuModel();
            }
            case 16: {
                return pSAppMenuBase.getMenuSN();
            }
            case 17: {
                return pSAppMenuBase.getOwnerId();
            }
            case 18: {
                return pSAppMenuBase.getOwnerTag();
            }
            case 19: {
                return pSAppMenuBase.getOwnerType();
            }
            case 20: {
                return pSAppMenuBase.getPSAppMenuId();
            }
            case 21: {
                return pSAppMenuBase.getPSAppMenuName();
            }
            case 22: {
                return pSAppMenuBase.getPSCtrlMsgId();
            }
            case 23: {
                return pSAppMenuBase.getPSCtrlMsgName();
            }
            case 24: {
                return pSAppMenuBase.getPSDynaAppId();
            }
            case 25: {
                return pSAppMenuBase.getPSDynaAppName();
            }
            case 26: {
                return pSAppMenuBase.getPSSysAppId();
            }
            case 27: {
                return pSAppMenuBase.getPSSysAppName();
            }
            case 28: {
                return pSAppMenuBase.getPSSysCounterId();
            }
            case 29: {
                return pSAppMenuBase.getPSSysCounterName();
            }
            case 30: {
                return pSAppMenuBase.getPSSysCssId();
            }
            case 31: {
                return pSAppMenuBase.getPSSysCssName();
            }
            case 32: {
                return pSAppMenuBase.getPSSysPFPluginId();
            }
            case 33: {
                return pSAppMenuBase.getPSSysPFPluginName();
            }
            case 34: {
                return pSAppMenuBase.getPSSysReqItemId();
            }
            case 35: {
                return pSAppMenuBase.getPSSysReqItemName();
            }
            case 36: {
                return pSAppMenuBase.getPSSystemId();
            }
            case 37: {
                return pSAppMenuBase.getPSViewMsgGroupId();
            }
            case 38: {
                return pSAppMenuBase.getPSViewMsgGroupName();
            }
            case 39: {
                return pSAppMenuBase.getPublicFlag();
            }
            case 40: {
                return pSAppMenuBase.getUpdateDate();
            }
            case 41: {
                return pSAppMenuBase.getUpdateMan();
            }
            case 42: {
                return pSAppMenuBase.getUserParams();
            }
            case 43: {
                return pSAppMenuBase.getUserTag();
            }
            case 44: {
                return pSAppMenuBase.getUserTag2();
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
        PSAppMenuBase.set(this, n, object);
    }

    private static void set(PSAppMenuBase pSAppMenuBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSAppMenuBase.setAppMenuStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSAppMenuBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSAppMenuBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSAppMenuBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSAppMenuBase.setCustomizedFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSAppMenuBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSAppMenuBase.setFlexAlign(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSAppMenuBase.setFlexDir(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSAppMenuBase.setFlexVAlign(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSAppMenuBase.setFromObjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSAppMenuBase.setIconAlign(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSAppMenuBase.setJSModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSAppMenuBase.setLayoutMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSAppMenuBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSAppMenuBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSAppMenuBase.setMenuModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSAppMenuBase.setMenuSN(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSAppMenuBase.setOwnerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSAppMenuBase.setOwnerTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSAppMenuBase.setOwnerType(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSAppMenuBase.setPSAppMenuId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSAppMenuBase.setPSAppMenuName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSAppMenuBase.setPSCtrlMsgId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSAppMenuBase.setPSCtrlMsgName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSAppMenuBase.setPSDynaAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSAppMenuBase.setPSDynaAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSAppMenuBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSAppMenuBase.setPSSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSAppMenuBase.setPSSysCounterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSAppMenuBase.setPSSysCounterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSAppMenuBase.setPSSysCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSAppMenuBase.setPSSysCssName(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSAppMenuBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSAppMenuBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSAppMenuBase.setPSSysReqItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSAppMenuBase.setPSSysReqItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSAppMenuBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSAppMenuBase.setPSViewMsgGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSAppMenuBase.setPSViewMsgGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSAppMenuBase.setPublicFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 40: {
                pSAppMenuBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 41: {
                pSAppMenuBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSAppMenuBase.setUserParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSAppMenuBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSAppMenuBase.setUserTag2(DataObject.getStringValue((Object)object));
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
        return PSAppMenuBase.isNull(this, n);
    }

    private static boolean isNull(PSAppMenuBase pSAppMenuBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppMenuBase.getAppMenuStyle() == null;
            }
            case 1: {
                return pSAppMenuBase.getCodeName() == null;
            }
            case 2: {
                return pSAppMenuBase.getCreateDate() == null;
            }
            case 3: {
                return pSAppMenuBase.getCreateMan() == null;
            }
            case 4: {
                return pSAppMenuBase.getCustomizedFlag() == null;
            }
            case 5: {
                return pSAppMenuBase.getDynaModelFlag() == null;
            }
            case 6: {
                return pSAppMenuBase.getFlexAlign() == null;
            }
            case 7: {
                return pSAppMenuBase.getFlexDir() == null;
            }
            case 8: {
                return pSAppMenuBase.getFlexVAlign() == null;
            }
            case 9: {
                return pSAppMenuBase.getFromObjId() == null;
            }
            case 10: {
                return pSAppMenuBase.getIconAlign() == null;
            }
            case 11: {
                return pSAppMenuBase.getJSModel() == null;
            }
            case 12: {
                return pSAppMenuBase.getLayoutMode() == null;
            }
            case 13: {
                return pSAppMenuBase.getLogicName() == null;
            }
            case 14: {
                return pSAppMenuBase.getMemo() == null;
            }
            case 15: {
                return pSAppMenuBase.getMenuModel() == null;
            }
            case 16: {
                return pSAppMenuBase.getMenuSN() == null;
            }
            case 17: {
                return pSAppMenuBase.getOwnerId() == null;
            }
            case 18: {
                return pSAppMenuBase.getOwnerTag() == null;
            }
            case 19: {
                return pSAppMenuBase.getOwnerType() == null;
            }
            case 20: {
                return pSAppMenuBase.getPSAppMenuId() == null;
            }
            case 21: {
                return pSAppMenuBase.getPSAppMenuName() == null;
            }
            case 22: {
                return pSAppMenuBase.getPSCtrlMsgId() == null;
            }
            case 23: {
                return pSAppMenuBase.getPSCtrlMsgName() == null;
            }
            case 24: {
                return pSAppMenuBase.getPSDynaAppId() == null;
            }
            case 25: {
                return pSAppMenuBase.getPSDynaAppName() == null;
            }
            case 26: {
                return pSAppMenuBase.getPSSysAppId() == null;
            }
            case 27: {
                return pSAppMenuBase.getPSSysAppName() == null;
            }
            case 28: {
                return pSAppMenuBase.getPSSysCounterId() == null;
            }
            case 29: {
                return pSAppMenuBase.getPSSysCounterName() == null;
            }
            case 30: {
                return pSAppMenuBase.getPSSysCssId() == null;
            }
            case 31: {
                return pSAppMenuBase.getPSSysCssName() == null;
            }
            case 32: {
                return pSAppMenuBase.getPSSysPFPluginId() == null;
            }
            case 33: {
                return pSAppMenuBase.getPSSysPFPluginName() == null;
            }
            case 34: {
                return pSAppMenuBase.getPSSysReqItemId() == null;
            }
            case 35: {
                return pSAppMenuBase.getPSSysReqItemName() == null;
            }
            case 36: {
                return pSAppMenuBase.getPSSystemId() == null;
            }
            case 37: {
                return pSAppMenuBase.getPSViewMsgGroupId() == null;
            }
            case 38: {
                return pSAppMenuBase.getPSViewMsgGroupName() == null;
            }
            case 39: {
                return pSAppMenuBase.getPublicFlag() == null;
            }
            case 40: {
                return pSAppMenuBase.getUpdateDate() == null;
            }
            case 41: {
                return pSAppMenuBase.getUpdateMan() == null;
            }
            case 42: {
                return pSAppMenuBase.getUserParams() == null;
            }
            case 43: {
                return pSAppMenuBase.getUserTag() == null;
            }
            case 44: {
                return pSAppMenuBase.getUserTag2() == null;
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
        return PSAppMenuBase.contains(this, n);
    }

    private static boolean contains(PSAppMenuBase pSAppMenuBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppMenuBase.isAppMenuStyleDirty();
            }
            case 1: {
                return pSAppMenuBase.isCodeNameDirty();
            }
            case 2: {
                return pSAppMenuBase.isCreateDateDirty();
            }
            case 3: {
                return pSAppMenuBase.isCreateManDirty();
            }
            case 4: {
                return pSAppMenuBase.isCustomizedFlagDirty();
            }
            case 5: {
                return pSAppMenuBase.isDynaModelFlagDirty();
            }
            case 6: {
                return pSAppMenuBase.isFlexAlignDirty();
            }
            case 7: {
                return pSAppMenuBase.isFlexDirDirty();
            }
            case 8: {
                return pSAppMenuBase.isFlexVAlignDirty();
            }
            case 9: {
                return pSAppMenuBase.isFromObjIdDirty();
            }
            case 10: {
                return pSAppMenuBase.isIconAlignDirty();
            }
            case 11: {
                return pSAppMenuBase.isJSModelDirty();
            }
            case 12: {
                return pSAppMenuBase.isLayoutModeDirty();
            }
            case 13: {
                return pSAppMenuBase.isLogicNameDirty();
            }
            case 14: {
                return pSAppMenuBase.isMemoDirty();
            }
            case 15: {
                return pSAppMenuBase.isMenuModelDirty();
            }
            case 16: {
                return pSAppMenuBase.isMenuSNDirty();
            }
            case 17: {
                return pSAppMenuBase.isOwnerIdDirty();
            }
            case 18: {
                return pSAppMenuBase.isOwnerTagDirty();
            }
            case 19: {
                return pSAppMenuBase.isOwnerTypeDirty();
            }
            case 20: {
                return pSAppMenuBase.isPSAppMenuIdDirty();
            }
            case 21: {
                return pSAppMenuBase.isPSAppMenuNameDirty();
            }
            case 22: {
                return pSAppMenuBase.isPSCtrlMsgIdDirty();
            }
            case 23: {
                return pSAppMenuBase.isPSCtrlMsgNameDirty();
            }
            case 24: {
                return pSAppMenuBase.isPSDynaAppIdDirty();
            }
            case 25: {
                return pSAppMenuBase.isPSDynaAppNameDirty();
            }
            case 26: {
                return pSAppMenuBase.isPSSysAppIdDirty();
            }
            case 27: {
                return pSAppMenuBase.isPSSysAppNameDirty();
            }
            case 28: {
                return pSAppMenuBase.isPSSysCounterIdDirty();
            }
            case 29: {
                return pSAppMenuBase.isPSSysCounterNameDirty();
            }
            case 30: {
                return pSAppMenuBase.isPSSysCssIdDirty();
            }
            case 31: {
                return pSAppMenuBase.isPSSysCssNameDirty();
            }
            case 32: {
                return pSAppMenuBase.isPSSysPFPluginIdDirty();
            }
            case 33: {
                return pSAppMenuBase.isPSSysPFPluginNameDirty();
            }
            case 34: {
                return pSAppMenuBase.isPSSysReqItemIdDirty();
            }
            case 35: {
                return pSAppMenuBase.isPSSysReqItemNameDirty();
            }
            case 36: {
                return pSAppMenuBase.isPSSystemIdDirty();
            }
            case 37: {
                return pSAppMenuBase.isPSViewMsgGroupIdDirty();
            }
            case 38: {
                return pSAppMenuBase.isPSViewMsgGroupNameDirty();
            }
            case 39: {
                return pSAppMenuBase.isPublicFlagDirty();
            }
            case 40: {
                return pSAppMenuBase.isUpdateDateDirty();
            }
            case 41: {
                return pSAppMenuBase.isUpdateManDirty();
            }
            case 42: {
                return pSAppMenuBase.isUserParamsDirty();
            }
            case 43: {
                return pSAppMenuBase.isUserTagDirty();
            }
            case 44: {
                return pSAppMenuBase.isUserTag2Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSAppMenuBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSAppMenuBase pSAppMenuBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSAppMenuBase.getAppMenuStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"appmenustyle", (Object)PSAppMenuBase.getJSONValue((Object)pSAppMenuBase.getAppMenuStyle()), (boolean)false);
        }
        if (bl || pSAppMenuBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSAppMenuBase.getJSONValue((Object)pSAppMenuBase.getCodeName()), (boolean)false);
        }
        if (bl || pSAppMenuBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSAppMenuBase.getJSONValue((Object)pSAppMenuBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSAppMenuBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSAppMenuBase.getJSONValue((Object)pSAppMenuBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSAppMenuBase.getCustomizedFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customizedflag", (Object)PSAppMenuBase.getJSONValue((Object)pSAppMenuBase.getCustomizedFlag()), (boolean)false);
        }
        if (bl || pSAppMenuBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSAppMenuBase.getJSONValue((Object)pSAppMenuBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSAppMenuBase.getFlexAlign() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"flexalign", (Object)PSAppMenuBase.getJSONValue((Object)pSAppMenuBase.getFlexAlign()), (boolean)false);
        }
        if (bl || pSAppMenuBase.getFlexDir() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"flexdir", (Object)PSAppMenuBase.getJSONValue((Object)pSAppMenuBase.getFlexDir()), (boolean)false);
        }
        if (bl || pSAppMenuBase.getFlexVAlign() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"flexvalign", (Object)PSAppMenuBase.getJSONValue((Object)pSAppMenuBase.getFlexVAlign()), (boolean)false);
        }
        if (bl || pSAppMenuBase.getFromObjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fromobjid", (Object)PSAppMenuBase.getJSONValue((Object)pSAppMenuBase.getFromObjId()), (boolean)false);
        }
        if (bl || pSAppMenuBase.getIconAlign() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"iconalign", (Object)PSAppMenuBase.getJSONValue((Object)pSAppMenuBase.getIconAlign()), (boolean)false);
        }
        if (bl || pSAppMenuBase.getJSModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"jsmodel", (Object)PSAppMenuBase.getJSONValue((Object)pSAppMenuBase.getJSModel()), (boolean)false);
        }
        if (bl || pSAppMenuBase.getLayoutMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"layoutmode", (Object)PSAppMenuBase.getJSONValue((Object)pSAppMenuBase.getLayoutMode()), (boolean)false);
        }
        if (bl || pSAppMenuBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSAppMenuBase.getJSONValue((Object)pSAppMenuBase.getLogicName()), (boolean)false);
        }
        if (bl || pSAppMenuBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSAppMenuBase.getJSONValue((Object)pSAppMenuBase.getMemo()), (boolean)false);
        }
        if (bl || pSAppMenuBase.getMenuModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"menumodel", (Object)PSAppMenuBase.getJSONValue((Object)pSAppMenuBase.getMenuModel()), (boolean)false);
        }
        if (bl || pSAppMenuBase.getMenuSN() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"menusn", (Object)PSAppMenuBase.getJSONValue((Object)pSAppMenuBase.getMenuSN()), (boolean)false);
        }
        if (bl || pSAppMenuBase.getOwnerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ownerid", (Object)PSAppMenuBase.getJSONValue((Object)pSAppMenuBase.getOwnerId()), (boolean)false);
        }
        if (bl || pSAppMenuBase.getOwnerTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ownertag", (Object)PSAppMenuBase.getJSONValue((Object)pSAppMenuBase.getOwnerTag()), (boolean)false);
        }
        if (bl || pSAppMenuBase.getOwnerType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ownertype", (Object)PSAppMenuBase.getJSONValue((Object)pSAppMenuBase.getOwnerType()), (boolean)false);
        }
        if (bl || pSAppMenuBase.getPSAppMenuId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappmenuid", (Object)PSAppMenuBase.getJSONValue((Object)pSAppMenuBase.getPSAppMenuId()), (boolean)false);
        }
        if (bl || pSAppMenuBase.getPSAppMenuName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappmenuname", (Object)PSAppMenuBase.getJSONValue((Object)pSAppMenuBase.getPSAppMenuName()), (boolean)false);
        }
        if (bl || pSAppMenuBase.getPSCtrlMsgId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrlmsgid", (Object)PSAppMenuBase.getJSONValue((Object)pSAppMenuBase.getPSCtrlMsgId()), (boolean)false);
        }
        if (bl || pSAppMenuBase.getPSCtrlMsgName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrlmsgname", (Object)PSAppMenuBase.getJSONValue((Object)pSAppMenuBase.getPSCtrlMsgName()), (boolean)false);
        }
        if (bl || pSAppMenuBase.getPSDynaAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynaappid", (Object)PSAppMenuBase.getJSONValue((Object)pSAppMenuBase.getPSDynaAppId()), (boolean)false);
        }
        if (bl || pSAppMenuBase.getPSDynaAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynaappname", (Object)PSAppMenuBase.getJSONValue((Object)pSAppMenuBase.getPSDynaAppName()), (boolean)false);
        }
        if (bl || pSAppMenuBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSAppMenuBase.getJSONValue((Object)pSAppMenuBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSAppMenuBase.getPSSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappname", (Object)PSAppMenuBase.getJSONValue((Object)pSAppMenuBase.getPSSysAppName()), (boolean)false);
        }
        if (bl || pSAppMenuBase.getPSSysCounterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscounterid", (Object)PSAppMenuBase.getJSONValue((Object)pSAppMenuBase.getPSSysCounterId()), (boolean)false);
        }
        if (bl || pSAppMenuBase.getPSSysCounterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscountername", (Object)PSAppMenuBase.getJSONValue((Object)pSAppMenuBase.getPSSysCounterName()), (boolean)false);
        }
        if (bl || pSAppMenuBase.getPSSysCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssid", (Object)PSAppMenuBase.getJSONValue((Object)pSAppMenuBase.getPSSysCssId()), (boolean)false);
        }
        if (bl || pSAppMenuBase.getPSSysCssName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssname", (Object)PSAppMenuBase.getJSONValue((Object)pSAppMenuBase.getPSSysCssName()), (boolean)false);
        }
        if (bl || pSAppMenuBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSAppMenuBase.getJSONValue((Object)pSAppMenuBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSAppMenuBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSAppMenuBase.getJSONValue((Object)pSAppMenuBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSAppMenuBase.getPSSysReqItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemid", (Object)PSAppMenuBase.getJSONValue((Object)pSAppMenuBase.getPSSysReqItemId()), (boolean)false);
        }
        if (bl || pSAppMenuBase.getPSSysReqItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemname", (Object)PSAppMenuBase.getJSONValue((Object)pSAppMenuBase.getPSSysReqItemName()), (boolean)false);
        }
        if (bl || pSAppMenuBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSAppMenuBase.getJSONValue((Object)pSAppMenuBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSAppMenuBase.getPSViewMsgGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewmsggroupid", (Object)PSAppMenuBase.getJSONValue((Object)pSAppMenuBase.getPSViewMsgGroupId()), (boolean)false);
        }
        if (bl || pSAppMenuBase.getPSViewMsgGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewmsggroupname", (Object)PSAppMenuBase.getJSONValue((Object)pSAppMenuBase.getPSViewMsgGroupName()), (boolean)false);
        }
        if (bl || pSAppMenuBase.getPublicFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"publicflag", (Object)PSAppMenuBase.getJSONValue((Object)pSAppMenuBase.getPublicFlag()), (boolean)false);
        }
        if (bl || pSAppMenuBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSAppMenuBase.getJSONValue((Object)pSAppMenuBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSAppMenuBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSAppMenuBase.getJSONValue((Object)pSAppMenuBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSAppMenuBase.getUserParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userparams", (Object)PSAppMenuBase.getJSONValue((Object)pSAppMenuBase.getUserParams()), (boolean)false);
        }
        if (bl || pSAppMenuBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSAppMenuBase.getJSONValue((Object)pSAppMenuBase.getUserTag()), (boolean)false);
        }
        if (bl || pSAppMenuBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSAppMenuBase.getJSONValue((Object)pSAppMenuBase.getUserTag2()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSAppMenuBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSAppMenuBase pSAppMenuBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSAppMenuBase.getAppMenuStyle() != null) {
            object = pSAppMenuBase.getAppMenuStyle();
            xmlNode.setAttribute(FIELD_APPMENUSTYLE, (String)(object == null ? "" : object));
        }
        if (bl || pSAppMenuBase.getCodeName() != null) {
            object = pSAppMenuBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuBase.getCreateDate() != null) {
            object = pSAppMenuBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppMenuBase.getCreateMan() != null) {
            object = pSAppMenuBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuBase.getCustomizedFlag() != null) {
            object = pSAppMenuBase.getCustomizedFlag();
            xmlNode.setAttribute(FIELD_CUSTOMIZEDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppMenuBase.getDynaModelFlag() != null) {
            object = pSAppMenuBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppMenuBase.getFlexAlign() != null) {
            object = pSAppMenuBase.getFlexAlign();
            xmlNode.setAttribute(FIELD_FLEXALIGN, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuBase.getFlexDir() != null) {
            object = pSAppMenuBase.getFlexDir();
            xmlNode.setAttribute(FIELD_FLEXDIR, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuBase.getFlexVAlign() != null) {
            object = pSAppMenuBase.getFlexVAlign();
            xmlNode.setAttribute(FIELD_FLEXVALIGN, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuBase.getFromObjId() != null) {
            object = pSAppMenuBase.getFromObjId();
            xmlNode.setAttribute(FIELD_FROMOBJID, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuBase.getIconAlign() != null) {
            object = pSAppMenuBase.getIconAlign();
            xmlNode.setAttribute(FIELD_ICONALIGN, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuBase.getJSModel() != null) {
            object = pSAppMenuBase.getJSModel();
            xmlNode.setAttribute(FIELD_JSMODEL, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuBase.getLayoutMode() != null) {
            object = pSAppMenuBase.getLayoutMode();
            xmlNode.setAttribute(FIELD_LAYOUTMODE, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuBase.getLogicName() != null) {
            object = pSAppMenuBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuBase.getMemo() != null) {
            object = pSAppMenuBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuBase.getMenuModel() != null) {
            object = pSAppMenuBase.getMenuModel();
            xmlNode.setAttribute(FIELD_MENUMODEL, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuBase.getMenuSN() != null) {
            object = pSAppMenuBase.getMenuSN();
            xmlNode.setAttribute(FIELD_MENUSN, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuBase.getOwnerId() != null) {
            object = pSAppMenuBase.getOwnerId();
            xmlNode.setAttribute(FIELD_OWNERID, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuBase.getOwnerTag() != null) {
            object = pSAppMenuBase.getOwnerTag();
            xmlNode.setAttribute(FIELD_OWNERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuBase.getOwnerType() != null) {
            object = pSAppMenuBase.getOwnerType();
            xmlNode.setAttribute(FIELD_OWNERTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuBase.getPSAppMenuId() != null) {
            object = pSAppMenuBase.getPSAppMenuId();
            xmlNode.setAttribute(FIELD_PSAPPMENUID, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuBase.getPSAppMenuName() != null) {
            object = pSAppMenuBase.getPSAppMenuName();
            xmlNode.setAttribute(FIELD_PSAPPMENUNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuBase.getPSCtrlMsgId() != null) {
            object = pSAppMenuBase.getPSCtrlMsgId();
            xmlNode.setAttribute(FIELD_PSCTRLMSGID, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuBase.getPSCtrlMsgName() != null) {
            object = pSAppMenuBase.getPSCtrlMsgName();
            xmlNode.setAttribute(FIELD_PSCTRLMSGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuBase.getPSDynaAppId() != null) {
            object = pSAppMenuBase.getPSDynaAppId();
            xmlNode.setAttribute(FIELD_PSDYNAAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuBase.getPSDynaAppName() != null) {
            object = pSAppMenuBase.getPSDynaAppName();
            xmlNode.setAttribute(FIELD_PSDYNAAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuBase.getPSSysAppId() != null) {
            object = pSAppMenuBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuBase.getPSSysAppName() != null) {
            object = pSAppMenuBase.getPSSysAppName();
            xmlNode.setAttribute(FIELD_PSSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuBase.getPSSysCounterId() != null) {
            object = pSAppMenuBase.getPSSysCounterId();
            xmlNode.setAttribute(FIELD_PSSYSCOUNTERID, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuBase.getPSSysCounterName() != null) {
            object = pSAppMenuBase.getPSSysCounterName();
            xmlNode.setAttribute(FIELD_PSSYSCOUNTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuBase.getPSSysCssId() != null) {
            object = pSAppMenuBase.getPSSysCssId();
            xmlNode.setAttribute(FIELD_PSSYSCSSID, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuBase.getPSSysCssName() != null) {
            object = pSAppMenuBase.getPSSysCssName();
            xmlNode.setAttribute(FIELD_PSSYSCSSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuBase.getPSSysPFPluginId() != null) {
            object = pSAppMenuBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuBase.getPSSysPFPluginName() != null) {
            object = pSAppMenuBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuBase.getPSSysReqItemId() != null) {
            object = pSAppMenuBase.getPSSysReqItemId();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuBase.getPSSysReqItemName() != null) {
            object = pSAppMenuBase.getPSSysReqItemName();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuBase.getPSSystemId() != null) {
            object = pSAppMenuBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuBase.getPSViewMsgGroupId() != null) {
            object = pSAppMenuBase.getPSViewMsgGroupId();
            xmlNode.setAttribute(FIELD_PSVIEWMSGGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuBase.getPSViewMsgGroupName() != null) {
            object = pSAppMenuBase.getPSViewMsgGroupName();
            xmlNode.setAttribute(FIELD_PSVIEWMSGGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuBase.getPublicFlag() != null) {
            object = pSAppMenuBase.getPublicFlag();
            xmlNode.setAttribute(FIELD_PUBLICFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppMenuBase.getUpdateDate() != null) {
            object = pSAppMenuBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppMenuBase.getUpdateMan() != null) {
            object = pSAppMenuBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuBase.getUserParams() != null) {
            object = pSAppMenuBase.getUserParams();
            xmlNode.setAttribute(FIELD_USERPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuBase.getUserTag() != null) {
            object = pSAppMenuBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuBase.getUserTag2() != null) {
            object = pSAppMenuBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSAppMenuBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSAppMenuBase pSAppMenuBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSAppMenuBase.isAppMenuStyleDirty() && (bl || pSAppMenuBase.getAppMenuStyle() != null)) {
            iDataObject.set(FIELD_APPMENUSTYLE, (Object)pSAppMenuBase.getAppMenuStyle());
        }
        if (pSAppMenuBase.isCodeNameDirty() && (bl || pSAppMenuBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSAppMenuBase.getCodeName());
        }
        if (pSAppMenuBase.isCreateDateDirty() && (bl || pSAppMenuBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSAppMenuBase.getCreateDate());
        }
        if (pSAppMenuBase.isCreateManDirty() && (bl || pSAppMenuBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSAppMenuBase.getCreateMan());
        }
        if (pSAppMenuBase.isCustomizedFlagDirty() && (bl || pSAppMenuBase.getCustomizedFlag() != null)) {
            iDataObject.set(FIELD_CUSTOMIZEDFLAG, (Object)pSAppMenuBase.getCustomizedFlag());
        }
        if (pSAppMenuBase.isDynaModelFlagDirty() && (bl || pSAppMenuBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSAppMenuBase.getDynaModelFlag());
        }
        if (pSAppMenuBase.isFlexAlignDirty() && (bl || pSAppMenuBase.getFlexAlign() != null)) {
            iDataObject.set(FIELD_FLEXALIGN, (Object)pSAppMenuBase.getFlexAlign());
        }
        if (pSAppMenuBase.isFlexDirDirty() && (bl || pSAppMenuBase.getFlexDir() != null)) {
            iDataObject.set(FIELD_FLEXDIR, (Object)pSAppMenuBase.getFlexDir());
        }
        if (pSAppMenuBase.isFlexVAlignDirty() && (bl || pSAppMenuBase.getFlexVAlign() != null)) {
            iDataObject.set(FIELD_FLEXVALIGN, (Object)pSAppMenuBase.getFlexVAlign());
        }
        if (pSAppMenuBase.isFromObjIdDirty() && (bl || pSAppMenuBase.getFromObjId() != null)) {
            iDataObject.set(FIELD_FROMOBJID, (Object)pSAppMenuBase.getFromObjId());
        }
        if (pSAppMenuBase.isIconAlignDirty() && (bl || pSAppMenuBase.getIconAlign() != null)) {
            iDataObject.set(FIELD_ICONALIGN, (Object)pSAppMenuBase.getIconAlign());
        }
        if (pSAppMenuBase.isJSModelDirty() && (bl || pSAppMenuBase.getJSModel() != null)) {
            iDataObject.set(FIELD_JSMODEL, (Object)pSAppMenuBase.getJSModel());
        }
        if (pSAppMenuBase.isLayoutModeDirty() && (bl || pSAppMenuBase.getLayoutMode() != null)) {
            iDataObject.set(FIELD_LAYOUTMODE, (Object)pSAppMenuBase.getLayoutMode());
        }
        if (pSAppMenuBase.isLogicNameDirty() && (bl || pSAppMenuBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSAppMenuBase.getLogicName());
        }
        if (pSAppMenuBase.isMemoDirty() && (bl || pSAppMenuBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSAppMenuBase.getMemo());
        }
        if (pSAppMenuBase.isMenuModelDirty() && (bl || pSAppMenuBase.getMenuModel() != null)) {
            iDataObject.set(FIELD_MENUMODEL, (Object)pSAppMenuBase.getMenuModel());
        }
        if (pSAppMenuBase.isMenuSNDirty() && (bl || pSAppMenuBase.getMenuSN() != null)) {
            iDataObject.set(FIELD_MENUSN, (Object)pSAppMenuBase.getMenuSN());
        }
        if (pSAppMenuBase.isOwnerIdDirty() && (bl || pSAppMenuBase.getOwnerId() != null)) {
            iDataObject.set(FIELD_OWNERID, (Object)pSAppMenuBase.getOwnerId());
        }
        if (pSAppMenuBase.isOwnerTagDirty() && (bl || pSAppMenuBase.getOwnerTag() != null)) {
            iDataObject.set(FIELD_OWNERTAG, (Object)pSAppMenuBase.getOwnerTag());
        }
        if (pSAppMenuBase.isOwnerTypeDirty() && (bl || pSAppMenuBase.getOwnerType() != null)) {
            iDataObject.set(FIELD_OWNERTYPE, (Object)pSAppMenuBase.getOwnerType());
        }
        if (pSAppMenuBase.isPSAppMenuIdDirty() && (bl || pSAppMenuBase.getPSAppMenuId() != null)) {
            iDataObject.set(FIELD_PSAPPMENUID, (Object)pSAppMenuBase.getPSAppMenuId());
        }
        if (pSAppMenuBase.isPSAppMenuNameDirty() && (bl || pSAppMenuBase.getPSAppMenuName() != null)) {
            iDataObject.set(FIELD_PSAPPMENUNAME, (Object)pSAppMenuBase.getPSAppMenuName());
        }
        if (pSAppMenuBase.isPSCtrlMsgIdDirty() && (bl || pSAppMenuBase.getPSCtrlMsgId() != null)) {
            iDataObject.set(FIELD_PSCTRLMSGID, (Object)pSAppMenuBase.getPSCtrlMsgId());
        }
        if (pSAppMenuBase.isPSCtrlMsgNameDirty() && (bl || pSAppMenuBase.getPSCtrlMsgName() != null)) {
            iDataObject.set(FIELD_PSCTRLMSGNAME, (Object)pSAppMenuBase.getPSCtrlMsgName());
        }
        if (pSAppMenuBase.isPSDynaAppIdDirty() && (bl || pSAppMenuBase.getPSDynaAppId() != null)) {
            iDataObject.set(FIELD_PSDYNAAPPID, (Object)pSAppMenuBase.getPSDynaAppId());
        }
        if (pSAppMenuBase.isPSDynaAppNameDirty() && (bl || pSAppMenuBase.getPSDynaAppName() != null)) {
            iDataObject.set(FIELD_PSDYNAAPPNAME, (Object)pSAppMenuBase.getPSDynaAppName());
        }
        if (pSAppMenuBase.isPSSysAppIdDirty() && (bl || pSAppMenuBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSAppMenuBase.getPSSysAppId());
        }
        if (pSAppMenuBase.isPSSysAppNameDirty() && (bl || pSAppMenuBase.getPSSysAppName() != null)) {
            iDataObject.set(FIELD_PSSYSAPPNAME, (Object)pSAppMenuBase.getPSSysAppName());
        }
        if (pSAppMenuBase.isPSSysCounterIdDirty() && (bl || pSAppMenuBase.getPSSysCounterId() != null)) {
            iDataObject.set(FIELD_PSSYSCOUNTERID, (Object)pSAppMenuBase.getPSSysCounterId());
        }
        if (pSAppMenuBase.isPSSysCounterNameDirty() && (bl || pSAppMenuBase.getPSSysCounterName() != null)) {
            iDataObject.set(FIELD_PSSYSCOUNTERNAME, (Object)pSAppMenuBase.getPSSysCounterName());
        }
        if (pSAppMenuBase.isPSSysCssIdDirty() && (bl || pSAppMenuBase.getPSSysCssId() != null)) {
            iDataObject.set(FIELD_PSSYSCSSID, (Object)pSAppMenuBase.getPSSysCssId());
        }
        if (pSAppMenuBase.isPSSysCssNameDirty() && (bl || pSAppMenuBase.getPSSysCssName() != null)) {
            iDataObject.set(FIELD_PSSYSCSSNAME, (Object)pSAppMenuBase.getPSSysCssName());
        }
        if (pSAppMenuBase.isPSSysPFPluginIdDirty() && (bl || pSAppMenuBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSAppMenuBase.getPSSysPFPluginId());
        }
        if (pSAppMenuBase.isPSSysPFPluginNameDirty() && (bl || pSAppMenuBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSAppMenuBase.getPSSysPFPluginName());
        }
        if (pSAppMenuBase.isPSSysReqItemIdDirty() && (bl || pSAppMenuBase.getPSSysReqItemId() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMID, (Object)pSAppMenuBase.getPSSysReqItemId());
        }
        if (pSAppMenuBase.isPSSysReqItemNameDirty() && (bl || pSAppMenuBase.getPSSysReqItemName() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMNAME, (Object)pSAppMenuBase.getPSSysReqItemName());
        }
        if (pSAppMenuBase.isPSSystemIdDirty() && (bl || pSAppMenuBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSAppMenuBase.getPSSystemId());
        }
        if (pSAppMenuBase.isPSViewMsgGroupIdDirty() && (bl || pSAppMenuBase.getPSViewMsgGroupId() != null)) {
            iDataObject.set(FIELD_PSVIEWMSGGROUPID, (Object)pSAppMenuBase.getPSViewMsgGroupId());
        }
        if (pSAppMenuBase.isPSViewMsgGroupNameDirty() && (bl || pSAppMenuBase.getPSViewMsgGroupName() != null)) {
            iDataObject.set(FIELD_PSVIEWMSGGROUPNAME, (Object)pSAppMenuBase.getPSViewMsgGroupName());
        }
        if (pSAppMenuBase.isPublicFlagDirty() && (bl || pSAppMenuBase.getPublicFlag() != null)) {
            iDataObject.set(FIELD_PUBLICFLAG, (Object)pSAppMenuBase.getPublicFlag());
        }
        if (pSAppMenuBase.isUpdateDateDirty() && (bl || pSAppMenuBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSAppMenuBase.getUpdateDate());
        }
        if (pSAppMenuBase.isUpdateManDirty() && (bl || pSAppMenuBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSAppMenuBase.getUpdateMan());
        }
        if (pSAppMenuBase.isUserParamsDirty() && (bl || pSAppMenuBase.getUserParams() != null)) {
            iDataObject.set(FIELD_USERPARAMS, (Object)pSAppMenuBase.getUserParams());
        }
        if (pSAppMenuBase.isUserTagDirty() && (bl || pSAppMenuBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSAppMenuBase.getUserTag());
        }
        if (pSAppMenuBase.isUserTag2Dirty() && (bl || pSAppMenuBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSAppMenuBase.getUserTag2());
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
        return PSAppMenuBase.remove(this, n);
    }

    private static boolean remove(PSAppMenuBase pSAppMenuBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSAppMenuBase.resetAppMenuStyle();
                return true;
            }
            case 1: {
                pSAppMenuBase.resetCodeName();
                return true;
            }
            case 2: {
                pSAppMenuBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSAppMenuBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSAppMenuBase.resetCustomizedFlag();
                return true;
            }
            case 5: {
                pSAppMenuBase.resetDynaModelFlag();
                return true;
            }
            case 6: {
                pSAppMenuBase.resetFlexAlign();
                return true;
            }
            case 7: {
                pSAppMenuBase.resetFlexDir();
                return true;
            }
            case 8: {
                pSAppMenuBase.resetFlexVAlign();
                return true;
            }
            case 9: {
                pSAppMenuBase.resetFromObjId();
                return true;
            }
            case 10: {
                pSAppMenuBase.resetIconAlign();
                return true;
            }
            case 11: {
                pSAppMenuBase.resetJSModel();
                return true;
            }
            case 12: {
                pSAppMenuBase.resetLayoutMode();
                return true;
            }
            case 13: {
                pSAppMenuBase.resetLogicName();
                return true;
            }
            case 14: {
                pSAppMenuBase.resetMemo();
                return true;
            }
            case 15: {
                pSAppMenuBase.resetMenuModel();
                return true;
            }
            case 16: {
                pSAppMenuBase.resetMenuSN();
                return true;
            }
            case 17: {
                pSAppMenuBase.resetOwnerId();
                return true;
            }
            case 18: {
                pSAppMenuBase.resetOwnerTag();
                return true;
            }
            case 19: {
                pSAppMenuBase.resetOwnerType();
                return true;
            }
            case 20: {
                pSAppMenuBase.resetPSAppMenuId();
                return true;
            }
            case 21: {
                pSAppMenuBase.resetPSAppMenuName();
                return true;
            }
            case 22: {
                pSAppMenuBase.resetPSCtrlMsgId();
                return true;
            }
            case 23: {
                pSAppMenuBase.resetPSCtrlMsgName();
                return true;
            }
            case 24: {
                pSAppMenuBase.resetPSDynaAppId();
                return true;
            }
            case 25: {
                pSAppMenuBase.resetPSDynaAppName();
                return true;
            }
            case 26: {
                pSAppMenuBase.resetPSSysAppId();
                return true;
            }
            case 27: {
                pSAppMenuBase.resetPSSysAppName();
                return true;
            }
            case 28: {
                pSAppMenuBase.resetPSSysCounterId();
                return true;
            }
            case 29: {
                pSAppMenuBase.resetPSSysCounterName();
                return true;
            }
            case 30: {
                pSAppMenuBase.resetPSSysCssId();
                return true;
            }
            case 31: {
                pSAppMenuBase.resetPSSysCssName();
                return true;
            }
            case 32: {
                pSAppMenuBase.resetPSSysPFPluginId();
                return true;
            }
            case 33: {
                pSAppMenuBase.resetPSSysPFPluginName();
                return true;
            }
            case 34: {
                pSAppMenuBase.resetPSSysReqItemId();
                return true;
            }
            case 35: {
                pSAppMenuBase.resetPSSysReqItemName();
                return true;
            }
            case 36: {
                pSAppMenuBase.resetPSSystemId();
                return true;
            }
            case 37: {
                pSAppMenuBase.resetPSViewMsgGroupId();
                return true;
            }
            case 38: {
                pSAppMenuBase.resetPSViewMsgGroupName();
                return true;
            }
            case 39: {
                pSAppMenuBase.resetPublicFlag();
                return true;
            }
            case 40: {
                pSAppMenuBase.resetUpdateDate();
                return true;
            }
            case 41: {
                pSAppMenuBase.resetUpdateMan();
                return true;
            }
            case 42: {
                pSAppMenuBase.resetUserParams();
                return true;
            }
            case 43: {
                pSAppMenuBase.resetUserTag();
                return true;
            }
            case 44: {
                pSAppMenuBase.resetUserTag2();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCtrlMsg getPSCtrlMsg() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlMsg();
        }
        if (this.getPSCtrlMsgId() == null) {
            return null;
        }
        Integer n = this.objPSCtrlMsgLock;
        synchronized (n) {
            if (this.psctrlmsg != null && DataTypeHelper.compare((int)25, (Object)this.getPSCtrlMsgId(), (Object)this.psctrlmsg.getPSCtrlMsgId()) != 0L) {
                this.psctrlmsg = null;
            }
            if (this.psctrlmsg == null) {
                PSCtrlMsg pSCtrlMsg = new PSCtrlMsg();
                pSCtrlMsg.setPSCtrlMsgId(this.getPSCtrlMsgId());
                PSCtrlMsgService pSCtrlMsgService = (PSCtrlMsgService)ServiceGlobal.getService(PSCtrlMsgService.class, (SessionFactory)this.getSessionFactory());
                pSCtrlMsgService.autoGet((IEntity)pSCtrlMsg);
                this.psctrlmsg = pSCtrlMsg;
            }
            return this.psctrlmsg;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDynaApp getPSDynaApp() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaApp();
        }
        if (this.getPSDynaAppId() == null) {
            return null;
        }
        Integer n = this.objPSDynaAppLock;
        synchronized (n) {
            if (this.psdynaapp != null && DataTypeHelper.compare((int)25, (Object)this.getPSDynaAppId(), (Object)this.psdynaapp.getPSDynaAppId()) != 0L) {
                this.psdynaapp = null;
            }
            if (this.psdynaapp == null) {
                PSDynaApp pSDynaApp = new PSDynaApp();
                pSDynaApp.setPSDynaAppId(this.getPSDynaAppId());
                PSDynaAppService pSDynaAppService = (PSDynaAppService)ServiceGlobal.getService(PSDynaAppService.class, (SessionFactory)this.getSessionFactory());
                pSDynaAppService.autoGet((IEntity)pSDynaApp);
                this.psdynaapp = pSDynaApp;
            }
            return this.psdynaapp;
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
    public ArrayList<PSAppMenuItem> getPSAppMenuItems() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppMenuItems();
        }
        if (this.getPSAppMenuId() == null) {
            return null;
        }
        PSAppMenuService pSAppMenuService = (PSAppMenuService)ServiceGlobal.getService(PSAppMenuService.class, (SessionFactory)this.getSessionFactory());
        PSAppMenuItemService pSAppMenuItemService = (PSAppMenuItemService)ServiceGlobal.getService(PSAppMenuItemService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSAppMenuItemsLock;
        synchronized (n) {
            if (this.psappmenuitems == null) {
                this.psappmenuitems = pSAppMenuService.isTempData((IEntity)this) ? pSAppMenuItemService.selectTempByPSAppMenu(this) : pSAppMenuItemService.selectByPSAppMenu(this);
            }
            return this.psappmenuitems;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSAppMenuLogic> getPSAppMenuLogics() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppMenuLogics();
        }
        if (this.getPSAppMenuId() == null) {
            return null;
        }
        PSAppMenuService pSAppMenuService = (PSAppMenuService)ServiceGlobal.getService(PSAppMenuService.class, (SessionFactory)this.getSessionFactory());
        PSAppMenuLogicService pSAppMenuLogicService = (PSAppMenuLogicService)ServiceGlobal.getService(PSAppMenuLogicService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSAppMenuLogicsLock;
        synchronized (n) {
            if (this.psappmenulogics == null) {
                this.psappmenulogics = pSAppMenuService.isTempData((IEntity)this) ? pSAppMenuLogicService.selectTempByPSAppMenu(this) : pSAppMenuLogicService.selectByPSAppMenu(this);
            }
            return this.psappmenulogics;
        }
    }

    private PSAppMenuBase getProxyEntity() {
        return this.proxyPSAppMenuBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSAppMenuBase = null;
        if (iDataObject != null && iDataObject instanceof PSAppMenuBase) {
            this.proxyPSAppMenuBase = (PSAppMenuBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppMenuService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_APPMENUSTYLE, 0);
        fieldIndexMap.put(FIELD_CODENAME, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_CUSTOMIZEDFLAG, 4);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 5);
        fieldIndexMap.put(FIELD_FLEXALIGN, 6);
        fieldIndexMap.put(FIELD_FLEXDIR, 7);
        fieldIndexMap.put(FIELD_FLEXVALIGN, 8);
        fieldIndexMap.put(FIELD_FROMOBJID, 9);
        fieldIndexMap.put(FIELD_ICONALIGN, 10);
        fieldIndexMap.put(FIELD_JSMODEL, 11);
        fieldIndexMap.put(FIELD_LAYOUTMODE, 12);
        fieldIndexMap.put(FIELD_LOGICNAME, 13);
        fieldIndexMap.put(FIELD_MEMO, 14);
        fieldIndexMap.put(FIELD_MENUMODEL, 15);
        fieldIndexMap.put(FIELD_MENUSN, 16);
        fieldIndexMap.put(FIELD_OWNERID, 17);
        fieldIndexMap.put(FIELD_OWNERTAG, 18);
        fieldIndexMap.put(FIELD_OWNERTYPE, 19);
        fieldIndexMap.put(FIELD_PSAPPMENUID, 20);
        fieldIndexMap.put(FIELD_PSAPPMENUNAME, 21);
        fieldIndexMap.put(FIELD_PSCTRLMSGID, 22);
        fieldIndexMap.put(FIELD_PSCTRLMSGNAME, 23);
        fieldIndexMap.put(FIELD_PSDYNAAPPID, 24);
        fieldIndexMap.put(FIELD_PSDYNAAPPNAME, 25);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 26);
        fieldIndexMap.put(FIELD_PSSYSAPPNAME, 27);
        fieldIndexMap.put(FIELD_PSSYSCOUNTERID, 28);
        fieldIndexMap.put(FIELD_PSSYSCOUNTERNAME, 29);
        fieldIndexMap.put(FIELD_PSSYSCSSID, 30);
        fieldIndexMap.put(FIELD_PSSYSCSSNAME, 31);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINID, 32);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINNAME, 33);
        fieldIndexMap.put(FIELD_PSSYSREQITEMID, 34);
        fieldIndexMap.put(FIELD_PSSYSREQITEMNAME, 35);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 36);
        fieldIndexMap.put(FIELD_PSVIEWMSGGROUPID, 37);
        fieldIndexMap.put(FIELD_PSVIEWMSGGROUPNAME, 38);
        fieldIndexMap.put(FIELD_PUBLICFLAG, 39);
        fieldIndexMap.put(FIELD_UPDATEDATE, 40);
        fieldIndexMap.put(FIELD_UPDATEMAN, 41);
        fieldIndexMap.put(FIELD_USERPARAMS, 42);
        fieldIndexMap.put(FIELD_USERTAG, 43);
        fieldIndexMap.put(FIELD_USERTAG2, 44);
    }
}

