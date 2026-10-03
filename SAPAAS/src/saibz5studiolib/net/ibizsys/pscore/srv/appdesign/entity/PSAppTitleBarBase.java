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
import net.ibizsys.pscore.srv.appdesign.entity.PSAppMenu;
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuService;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.service.PSSysPFPluginService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlLogicGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImage;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewMsgGroup;
import net.ibizsys.pscore.srv.sysdesign.service.PSCtrlLogicGroupService;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysImageService;
import net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgGroupService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppTitleBarBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSAppTitleBarBase.class);
    public static final String FIELD_CAPPSLANRESID = "CAPPSLANRESID";
    public static final String FIELD_CAPPSLANRESNAME = "CAPPSLANRESNAME";
    public static final String FIELD_CAPTION = "CAPTION";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_LEFTPSAPPMENUID = "LEFTPSAPPMENUID";
    public static final String FIELD_LEFTPSAPPMENUNAME = "LEFTPSAPPMENUNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSAPPTITLEBARID = "PSAPPTITLEBARID";
    public static final String FIELD_PSAPPTITLEBARNAME = "PSAPPTITLEBARNAME";
    public static final String FIELD_PSCTRLLOGICGROUPID = "PSCTRLLOGICGROUPID";
    public static final String FIELD_PSCTRLLOGICGROUPNAME = "PSCTRLLOGICGROUPNAME";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String FIELD_PSSYSCSSID = "PSSYSCSSID";
    public static final String FIELD_PSSYSCSSNAME = "PSSYSCSSNAME";
    public static final String FIELD_PSSYSIMAGEID = "PSSYSIMAGEID";
    public static final String FIELD_PSSYSIMAGENAME = "PSSYSIMAGENAME";
    public static final String FIELD_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String FIELD_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String FIELD_PSVIEWMSGGROUPID = "PSVIEWMSGGROUPID";
    public static final String FIELD_PSVIEWMSGGROUPNAME = "PSVIEWMSGGROUPNAME";
    public static final String FIELD_RIGHTPSAPPMENUID = "RIGHTPSAPPMENUID";
    public static final String FIELD_RIGHTPSAPPMENUNAME = "RIGHTPSAPPMENUNAME";
    public static final String FIELD_TITLEBARSTYLE = "TITLEBARSTYLE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    private static final int INDEX_CAPPSLANRESID = 0;
    private static final int INDEX_CAPPSLANRESNAME = 1;
    private static final int INDEX_CAPTION = 2;
    private static final int INDEX_CODENAME = 3;
    private static final int INDEX_CREATEDATE = 4;
    private static final int INDEX_CREATEMAN = 5;
    private static final int INDEX_LEFTPSAPPMENUID = 6;
    private static final int INDEX_LEFTPSAPPMENUNAME = 7;
    private static final int INDEX_MEMO = 8;
    private static final int INDEX_PSAPPTITLEBARID = 9;
    private static final int INDEX_PSAPPTITLEBARNAME = 10;
    private static final int INDEX_PSCTRLLOGICGROUPID = 11;
    private static final int INDEX_PSCTRLLOGICGROUPNAME = 12;
    private static final int INDEX_PSSYSAPPID = 13;
    private static final int INDEX_PSSYSAPPNAME = 14;
    private static final int INDEX_PSSYSCSSID = 15;
    private static final int INDEX_PSSYSCSSNAME = 16;
    private static final int INDEX_PSSYSIMAGEID = 17;
    private static final int INDEX_PSSYSIMAGENAME = 18;
    private static final int INDEX_PSSYSPFPLUGINID = 19;
    private static final int INDEX_PSSYSPFPLUGINNAME = 20;
    private static final int INDEX_PSVIEWMSGGROUPID = 21;
    private static final int INDEX_PSVIEWMSGGROUPNAME = 22;
    private static final int INDEX_RIGHTPSAPPMENUID = 23;
    private static final int INDEX_RIGHTPSAPPMENUNAME = 24;
    private static final int INDEX_TITLEBARSTYLE = 25;
    private static final int INDEX_UPDATEDATE = 26;
    private static final int INDEX_UPDATEMAN = 27;
    private static final int INDEX_USERTAG = 28;
    private static final int INDEX_USERTAG2 = 29;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSAppTitleBarBase proxyPSAppTitleBarBase = null;
    private boolean cappslanresidDirtyFlag = false;
    private boolean cappslanresnameDirtyFlag = false;
    private boolean captionDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean leftpsappmenuidDirtyFlag = false;
    private boolean leftpsappmenunameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psapptitlebaridDirtyFlag = false;
    private boolean psapptitlebarnameDirtyFlag = false;
    private boolean psctrllogicgroupidDirtyFlag = false;
    private boolean psctrllogicgroupnameDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean pssysappnameDirtyFlag = false;
    private boolean pssyscssidDirtyFlag = false;
    private boolean pssyscssnameDirtyFlag = false;
    private boolean pssysimageidDirtyFlag = false;
    private boolean pssysimagenameDirtyFlag = false;
    private boolean pssyspfpluginidDirtyFlag = false;
    private boolean pssyspfpluginnameDirtyFlag = false;
    private boolean psviewmsggroupidDirtyFlag = false;
    private boolean psviewmsggroupnameDirtyFlag = false;
    private boolean rightpsappmenuidDirtyFlag = false;
    private boolean rightpsappmenunameDirtyFlag = false;
    private boolean titlebarstyleDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    @Column(name="cappslanresid")
    private String cappslanresid;
    @Column(name="cappslanresname")
    private String cappslanresname;
    @Column(name="caption")
    private String caption;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="leftpsappmenuid")
    private String leftpsappmenuid;
    @Column(name="leftpsappmenuname")
    private String leftpsappmenuname;
    @Column(name="memo")
    private String memo;
    @Column(name="psapptitlebarid")
    private String psapptitlebarid;
    @Column(name="psapptitlebarname")
    private String psapptitlebarname;
    @Column(name="psctrllogicgroupid")
    private String psctrllogicgroupid;
    @Column(name="psctrllogicgroupname")
    private String psctrllogicgroupname;
    @Column(name="pssysappid")
    private String pssysappid;
    @Column(name="pssysappname")
    private String pssysappname;
    @Column(name="pssyscssid")
    private String pssyscssid;
    @Column(name="pssyscssname")
    private String pssyscssname;
    @Column(name="pssysimageid")
    private String pssysimageid;
    @Column(name="pssysimagename")
    private String pssysimagename;
    @Column(name="pssyspfpluginid")
    private String pssyspfpluginid;
    @Column(name="pssyspfpluginname")
    private String pssyspfpluginname;
    @Column(name="psviewmsggroupid")
    private String psviewmsggroupid;
    @Column(name="psviewmsggroupname")
    private String psviewmsggroupname;
    @Column(name="rightpsappmenuid")
    private String rightpsappmenuid;
    @Column(name="rightpsappmenuname")
    private String rightpsappmenuname;
    @Column(name="titlebarstyle")
    private String titlebarstyle;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    private Integer objLeftPSAppMenuLock = new Integer(1);
    private PSAppMenu leftpsappmenu = null;
    private Integer objRightPSAppMenuLock = new Integer(1);
    private PSAppMenu rightpsappmenu = null;
    private Integer objPSCtrlLogicGroupLock = new Integer(1);
    private PSCtrlLogicGroup psctrllogicgroup = null;
    private Integer objCapPSLanResLock = new Integer(1);
    private PSLanguageRes cappslanres = null;
    private Integer objPSSysAppLock = new Integer(1);
    private PSSysApp pssysapp = null;
    private Integer objPSSysCssLock = new Integer(1);
    private PSSysCss pssyscss = null;
    private Integer objPSSysImageLock = new Integer(1);
    private PSSysImage pssysimage = null;
    private Integer objPSSysPFPluginLock = new Integer(1);
    private PSSysPFPlugin pssyspfplugin = null;
    private Integer objPSViewMsgGroupLock = new Integer(1);
    private PSViewMsgGroup psviewmsggroup = null;

    public void setCapPSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCapPSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cappslanresid = string;
        this.cappslanresidDirtyFlag = true;
    }

    public String getCapPSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCapPSLanResId();
        }
        return this.cappslanresid;
    }

    public boolean isCapPSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCapPSLanResIdDirty();
        }
        return this.cappslanresidDirtyFlag;
    }

    public void resetCapPSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCapPSLanResId();
            return;
        }
        this.cappslanresidDirtyFlag = false;
        this.cappslanresid = null;
    }

    public void setCapPSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCapPSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cappslanresname = string;
        this.cappslanresnameDirtyFlag = true;
    }

    public String getCapPSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCapPSLanResName();
        }
        return this.cappslanresname;
    }

    public boolean isCapPSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCapPSLanResNameDirty();
        }
        return this.cappslanresnameDirtyFlag;
    }

    public void resetCapPSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCapPSLanResName();
            return;
        }
        this.cappslanresnameDirtyFlag = false;
        this.cappslanresname = null;
    }

    public void setCaption(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCaption(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.caption = string;
        this.captionDirtyFlag = true;
    }

    public String getCaption() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCaption();
        }
        return this.caption;
    }

    public boolean isCaptionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCaptionDirty();
        }
        return this.captionDirtyFlag;
    }

    public void resetCaption() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCaption();
            return;
        }
        this.captionDirtyFlag = false;
        this.caption = null;
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

    public void setLeftPSAppMenuId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLeftPSAppMenuId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.leftpsappmenuid = string;
        this.leftpsappmenuidDirtyFlag = true;
    }

    public String getLeftPSAppMenuId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLeftPSAppMenuId();
        }
        return this.leftpsappmenuid;
    }

    public boolean isLeftPSAppMenuIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLeftPSAppMenuIdDirty();
        }
        return this.leftpsappmenuidDirtyFlag;
    }

    public void resetLeftPSAppMenuId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLeftPSAppMenuId();
            return;
        }
        this.leftpsappmenuidDirtyFlag = false;
        this.leftpsappmenuid = null;
    }

    public void setLeftPSAppMenuName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLeftPSAppMenuName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.leftpsappmenuname = string;
        this.leftpsappmenunameDirtyFlag = true;
    }

    public String getLeftPSAppMenuName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLeftPSAppMenuName();
        }
        return this.leftpsappmenuname;
    }

    public boolean isLeftPSAppMenuNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLeftPSAppMenuNameDirty();
        }
        return this.leftpsappmenunameDirtyFlag;
    }

    public void resetLeftPSAppMenuName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLeftPSAppMenuName();
            return;
        }
        this.leftpsappmenunameDirtyFlag = false;
        this.leftpsappmenuname = null;
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

    public void setPSAppTitleBarId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppTitleBarId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psapptitlebarid = string;
        this.psapptitlebaridDirtyFlag = true;
    }

    public String getPSAppTitleBarId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppTitleBarId();
        }
        return this.psapptitlebarid;
    }

    public boolean isPSAppTitleBarIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppTitleBarIdDirty();
        }
        return this.psapptitlebaridDirtyFlag;
    }

    public void resetPSAppTitleBarId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppTitleBarId();
            return;
        }
        this.psapptitlebaridDirtyFlag = false;
        this.psapptitlebarid = null;
    }

    public void setPSAppTitleBarName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppTitleBarName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psapptitlebarname = string;
        this.psapptitlebarnameDirtyFlag = true;
    }

    public String getPSAppTitleBarName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppTitleBarName();
        }
        return this.psapptitlebarname;
    }

    public boolean isPSAppTitleBarNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppTitleBarNameDirty();
        }
        return this.psapptitlebarnameDirtyFlag;
    }

    public void resetPSAppTitleBarName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppTitleBarName();
            return;
        }
        this.psapptitlebarnameDirtyFlag = false;
        this.psapptitlebarname = null;
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

    public void setPSSysImageId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysImageId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysimageid = string;
        this.pssysimageidDirtyFlag = true;
    }

    public String getPSSysImageId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysImageId();
        }
        return this.pssysimageid;
    }

    public boolean isPSSysImageIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysImageIdDirty();
        }
        return this.pssysimageidDirtyFlag;
    }

    public void resetPSSysImageId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysImageId();
            return;
        }
        this.pssysimageidDirtyFlag = false;
        this.pssysimageid = null;
    }

    public void setPSSysImageName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysImageName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysimagename = string;
        this.pssysimagenameDirtyFlag = true;
    }

    public String getPSSysImageName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysImageName();
        }
        return this.pssysimagename;
    }

    public boolean isPSSysImageNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysImageNameDirty();
        }
        return this.pssysimagenameDirtyFlag;
    }

    public void resetPSSysImageName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysImageName();
            return;
        }
        this.pssysimagenameDirtyFlag = false;
        this.pssysimagename = null;
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

    public void setRightPSAppMenuId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRightPSAppMenuId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.rightpsappmenuid = string;
        this.rightpsappmenuidDirtyFlag = true;
    }

    public String getRightPSAppMenuId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRightPSAppMenuId();
        }
        return this.rightpsappmenuid;
    }

    public boolean isRightPSAppMenuIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRightPSAppMenuIdDirty();
        }
        return this.rightpsappmenuidDirtyFlag;
    }

    public void resetRightPSAppMenuId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRightPSAppMenuId();
            return;
        }
        this.rightpsappmenuidDirtyFlag = false;
        this.rightpsappmenuid = null;
    }

    public void setRightPSAppMenuName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRightPSAppMenuName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.rightpsappmenuname = string;
        this.rightpsappmenunameDirtyFlag = true;
    }

    public String getRightPSAppMenuName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRightPSAppMenuName();
        }
        return this.rightpsappmenuname;
    }

    public boolean isRightPSAppMenuNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRightPSAppMenuNameDirty();
        }
        return this.rightpsappmenunameDirtyFlag;
    }

    public void resetRightPSAppMenuName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRightPSAppMenuName();
            return;
        }
        this.rightpsappmenunameDirtyFlag = false;
        this.rightpsappmenuname = null;
    }

    public void setTitleBarStyle(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTitleBarStyle(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.titlebarstyle = string;
        this.titlebarstyleDirtyFlag = true;
    }

    public String getTitleBarStyle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTitleBarStyle();
        }
        return this.titlebarstyle;
    }

    public boolean isTitleBarStyleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTitleBarStyleDirty();
        }
        return this.titlebarstyleDirtyFlag;
    }

    public void resetTitleBarStyle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTitleBarStyle();
            return;
        }
        this.titlebarstyleDirtyFlag = false;
        this.titlebarstyle = null;
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
        PSAppTitleBarBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSAppTitleBarBase pSAppTitleBarBase) {
        pSAppTitleBarBase.resetCapPSLanResId();
        pSAppTitleBarBase.resetCapPSLanResName();
        pSAppTitleBarBase.resetCaption();
        pSAppTitleBarBase.resetCodeName();
        pSAppTitleBarBase.resetCreateDate();
        pSAppTitleBarBase.resetCreateMan();
        pSAppTitleBarBase.resetLeftPSAppMenuId();
        pSAppTitleBarBase.resetLeftPSAppMenuName();
        pSAppTitleBarBase.resetMemo();
        pSAppTitleBarBase.resetPSAppTitleBarId();
        pSAppTitleBarBase.resetPSAppTitleBarName();
        pSAppTitleBarBase.resetPSCtrlLogicGroupId();
        pSAppTitleBarBase.resetPSCtrlLogicGroupName();
        pSAppTitleBarBase.resetPSSysAppId();
        pSAppTitleBarBase.resetPSSysAppName();
        pSAppTitleBarBase.resetPSSysCssId();
        pSAppTitleBarBase.resetPSSysCssName();
        pSAppTitleBarBase.resetPSSysImageId();
        pSAppTitleBarBase.resetPSSysImageName();
        pSAppTitleBarBase.resetPSSysPFPluginId();
        pSAppTitleBarBase.resetPSSysPFPluginName();
        pSAppTitleBarBase.resetPSViewMsgGroupId();
        pSAppTitleBarBase.resetPSViewMsgGroupName();
        pSAppTitleBarBase.resetRightPSAppMenuId();
        pSAppTitleBarBase.resetRightPSAppMenuName();
        pSAppTitleBarBase.resetTitleBarStyle();
        pSAppTitleBarBase.resetUpdateDate();
        pSAppTitleBarBase.resetUpdateMan();
        pSAppTitleBarBase.resetUserTag();
        pSAppTitleBarBase.resetUserTag2();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCapPSLanResIdDirty()) {
            hashMap.put(FIELD_CAPPSLANRESID, this.getCapPSLanResId());
        }
        if (!bl || this.isCapPSLanResNameDirty()) {
            hashMap.put(FIELD_CAPPSLANRESNAME, this.getCapPSLanResName());
        }
        if (!bl || this.isCaptionDirty()) {
            hashMap.put(FIELD_CAPTION, this.getCaption());
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
        if (!bl || this.isLeftPSAppMenuIdDirty()) {
            hashMap.put(FIELD_LEFTPSAPPMENUID, this.getLeftPSAppMenuId());
        }
        if (!bl || this.isLeftPSAppMenuNameDirty()) {
            hashMap.put(FIELD_LEFTPSAPPMENUNAME, this.getLeftPSAppMenuName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSAppTitleBarIdDirty()) {
            hashMap.put(FIELD_PSAPPTITLEBARID, this.getPSAppTitleBarId());
        }
        if (!bl || this.isPSAppTitleBarNameDirty()) {
            hashMap.put(FIELD_PSAPPTITLEBARNAME, this.getPSAppTitleBarName());
        }
        if (!bl || this.isPSCtrlLogicGroupIdDirty()) {
            hashMap.put(FIELD_PSCTRLLOGICGROUPID, this.getPSCtrlLogicGroupId());
        }
        if (!bl || this.isPSCtrlLogicGroupNameDirty()) {
            hashMap.put(FIELD_PSCTRLLOGICGROUPNAME, this.getPSCtrlLogicGroupName());
        }
        if (!bl || this.isPSSysAppIdDirty()) {
            hashMap.put(FIELD_PSSYSAPPID, this.getPSSysAppId());
        }
        if (!bl || this.isPSSysAppNameDirty()) {
            hashMap.put(FIELD_PSSYSAPPNAME, this.getPSSysAppName());
        }
        if (!bl || this.isPSSysCssIdDirty()) {
            hashMap.put(FIELD_PSSYSCSSID, this.getPSSysCssId());
        }
        if (!bl || this.isPSSysCssNameDirty()) {
            hashMap.put(FIELD_PSSYSCSSNAME, this.getPSSysCssName());
        }
        if (!bl || this.isPSSysImageIdDirty()) {
            hashMap.put(FIELD_PSSYSIMAGEID, this.getPSSysImageId());
        }
        if (!bl || this.isPSSysImageNameDirty()) {
            hashMap.put(FIELD_PSSYSIMAGENAME, this.getPSSysImageName());
        }
        if (!bl || this.isPSSysPFPluginIdDirty()) {
            hashMap.put(FIELD_PSSYSPFPLUGINID, this.getPSSysPFPluginId());
        }
        if (!bl || this.isPSSysPFPluginNameDirty()) {
            hashMap.put(FIELD_PSSYSPFPLUGINNAME, this.getPSSysPFPluginName());
        }
        if (!bl || this.isPSViewMsgGroupIdDirty()) {
            hashMap.put(FIELD_PSVIEWMSGGROUPID, this.getPSViewMsgGroupId());
        }
        if (!bl || this.isPSViewMsgGroupNameDirty()) {
            hashMap.put(FIELD_PSVIEWMSGGROUPNAME, this.getPSViewMsgGroupName());
        }
        if (!bl || this.isRightPSAppMenuIdDirty()) {
            hashMap.put(FIELD_RIGHTPSAPPMENUID, this.getRightPSAppMenuId());
        }
        if (!bl || this.isRightPSAppMenuNameDirty()) {
            hashMap.put(FIELD_RIGHTPSAPPMENUNAME, this.getRightPSAppMenuName());
        }
        if (!bl || this.isTitleBarStyleDirty()) {
            hashMap.put(FIELD_TITLEBARSTYLE, this.getTitleBarStyle());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
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
        return PSAppTitleBarBase.get(this, n);
    }

    private static Object get(PSAppTitleBarBase pSAppTitleBarBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppTitleBarBase.getCapPSLanResId();
            }
            case 1: {
                return pSAppTitleBarBase.getCapPSLanResName();
            }
            case 2: {
                return pSAppTitleBarBase.getCaption();
            }
            case 3: {
                return pSAppTitleBarBase.getCodeName();
            }
            case 4: {
                return pSAppTitleBarBase.getCreateDate();
            }
            case 5: {
                return pSAppTitleBarBase.getCreateMan();
            }
            case 6: {
                return pSAppTitleBarBase.getLeftPSAppMenuId();
            }
            case 7: {
                return pSAppTitleBarBase.getLeftPSAppMenuName();
            }
            case 8: {
                return pSAppTitleBarBase.getMemo();
            }
            case 9: {
                return pSAppTitleBarBase.getPSAppTitleBarId();
            }
            case 10: {
                return pSAppTitleBarBase.getPSAppTitleBarName();
            }
            case 11: {
                return pSAppTitleBarBase.getPSCtrlLogicGroupId();
            }
            case 12: {
                return pSAppTitleBarBase.getPSCtrlLogicGroupName();
            }
            case 13: {
                return pSAppTitleBarBase.getPSSysAppId();
            }
            case 14: {
                return pSAppTitleBarBase.getPSSysAppName();
            }
            case 15: {
                return pSAppTitleBarBase.getPSSysCssId();
            }
            case 16: {
                return pSAppTitleBarBase.getPSSysCssName();
            }
            case 17: {
                return pSAppTitleBarBase.getPSSysImageId();
            }
            case 18: {
                return pSAppTitleBarBase.getPSSysImageName();
            }
            case 19: {
                return pSAppTitleBarBase.getPSSysPFPluginId();
            }
            case 20: {
                return pSAppTitleBarBase.getPSSysPFPluginName();
            }
            case 21: {
                return pSAppTitleBarBase.getPSViewMsgGroupId();
            }
            case 22: {
                return pSAppTitleBarBase.getPSViewMsgGroupName();
            }
            case 23: {
                return pSAppTitleBarBase.getRightPSAppMenuId();
            }
            case 24: {
                return pSAppTitleBarBase.getRightPSAppMenuName();
            }
            case 25: {
                return pSAppTitleBarBase.getTitleBarStyle();
            }
            case 26: {
                return pSAppTitleBarBase.getUpdateDate();
            }
            case 27: {
                return pSAppTitleBarBase.getUpdateMan();
            }
            case 28: {
                return pSAppTitleBarBase.getUserTag();
            }
            case 29: {
                return pSAppTitleBarBase.getUserTag2();
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
        PSAppTitleBarBase.set(this, n, object);
    }

    private static void set(PSAppTitleBarBase pSAppTitleBarBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSAppTitleBarBase.setCapPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSAppTitleBarBase.setCapPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSAppTitleBarBase.setCaption(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSAppTitleBarBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSAppTitleBarBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 5: {
                pSAppTitleBarBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSAppTitleBarBase.setLeftPSAppMenuId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSAppTitleBarBase.setLeftPSAppMenuName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSAppTitleBarBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSAppTitleBarBase.setPSAppTitleBarId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSAppTitleBarBase.setPSAppTitleBarName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSAppTitleBarBase.setPSCtrlLogicGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSAppTitleBarBase.setPSCtrlLogicGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSAppTitleBarBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSAppTitleBarBase.setPSSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSAppTitleBarBase.setPSSysCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSAppTitleBarBase.setPSSysCssName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSAppTitleBarBase.setPSSysImageId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSAppTitleBarBase.setPSSysImageName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSAppTitleBarBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSAppTitleBarBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSAppTitleBarBase.setPSViewMsgGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSAppTitleBarBase.setPSViewMsgGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSAppTitleBarBase.setRightPSAppMenuId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSAppTitleBarBase.setRightPSAppMenuName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSAppTitleBarBase.setTitleBarStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSAppTitleBarBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 27: {
                pSAppTitleBarBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSAppTitleBarBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSAppTitleBarBase.setUserTag2(DataObject.getStringValue((Object)object));
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
        return PSAppTitleBarBase.isNull(this, n);
    }

    private static boolean isNull(PSAppTitleBarBase pSAppTitleBarBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppTitleBarBase.getCapPSLanResId() == null;
            }
            case 1: {
                return pSAppTitleBarBase.getCapPSLanResName() == null;
            }
            case 2: {
                return pSAppTitleBarBase.getCaption() == null;
            }
            case 3: {
                return pSAppTitleBarBase.getCodeName() == null;
            }
            case 4: {
                return pSAppTitleBarBase.getCreateDate() == null;
            }
            case 5: {
                return pSAppTitleBarBase.getCreateMan() == null;
            }
            case 6: {
                return pSAppTitleBarBase.getLeftPSAppMenuId() == null;
            }
            case 7: {
                return pSAppTitleBarBase.getLeftPSAppMenuName() == null;
            }
            case 8: {
                return pSAppTitleBarBase.getMemo() == null;
            }
            case 9: {
                return pSAppTitleBarBase.getPSAppTitleBarId() == null;
            }
            case 10: {
                return pSAppTitleBarBase.getPSAppTitleBarName() == null;
            }
            case 11: {
                return pSAppTitleBarBase.getPSCtrlLogicGroupId() == null;
            }
            case 12: {
                return pSAppTitleBarBase.getPSCtrlLogicGroupName() == null;
            }
            case 13: {
                return pSAppTitleBarBase.getPSSysAppId() == null;
            }
            case 14: {
                return pSAppTitleBarBase.getPSSysAppName() == null;
            }
            case 15: {
                return pSAppTitleBarBase.getPSSysCssId() == null;
            }
            case 16: {
                return pSAppTitleBarBase.getPSSysCssName() == null;
            }
            case 17: {
                return pSAppTitleBarBase.getPSSysImageId() == null;
            }
            case 18: {
                return pSAppTitleBarBase.getPSSysImageName() == null;
            }
            case 19: {
                return pSAppTitleBarBase.getPSSysPFPluginId() == null;
            }
            case 20: {
                return pSAppTitleBarBase.getPSSysPFPluginName() == null;
            }
            case 21: {
                return pSAppTitleBarBase.getPSViewMsgGroupId() == null;
            }
            case 22: {
                return pSAppTitleBarBase.getPSViewMsgGroupName() == null;
            }
            case 23: {
                return pSAppTitleBarBase.getRightPSAppMenuId() == null;
            }
            case 24: {
                return pSAppTitleBarBase.getRightPSAppMenuName() == null;
            }
            case 25: {
                return pSAppTitleBarBase.getTitleBarStyle() == null;
            }
            case 26: {
                return pSAppTitleBarBase.getUpdateDate() == null;
            }
            case 27: {
                return pSAppTitleBarBase.getUpdateMan() == null;
            }
            case 28: {
                return pSAppTitleBarBase.getUserTag() == null;
            }
            case 29: {
                return pSAppTitleBarBase.getUserTag2() == null;
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
        return PSAppTitleBarBase.contains(this, n);
    }

    private static boolean contains(PSAppTitleBarBase pSAppTitleBarBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppTitleBarBase.isCapPSLanResIdDirty();
            }
            case 1: {
                return pSAppTitleBarBase.isCapPSLanResNameDirty();
            }
            case 2: {
                return pSAppTitleBarBase.isCaptionDirty();
            }
            case 3: {
                return pSAppTitleBarBase.isCodeNameDirty();
            }
            case 4: {
                return pSAppTitleBarBase.isCreateDateDirty();
            }
            case 5: {
                return pSAppTitleBarBase.isCreateManDirty();
            }
            case 6: {
                return pSAppTitleBarBase.isLeftPSAppMenuIdDirty();
            }
            case 7: {
                return pSAppTitleBarBase.isLeftPSAppMenuNameDirty();
            }
            case 8: {
                return pSAppTitleBarBase.isMemoDirty();
            }
            case 9: {
                return pSAppTitleBarBase.isPSAppTitleBarIdDirty();
            }
            case 10: {
                return pSAppTitleBarBase.isPSAppTitleBarNameDirty();
            }
            case 11: {
                return pSAppTitleBarBase.isPSCtrlLogicGroupIdDirty();
            }
            case 12: {
                return pSAppTitleBarBase.isPSCtrlLogicGroupNameDirty();
            }
            case 13: {
                return pSAppTitleBarBase.isPSSysAppIdDirty();
            }
            case 14: {
                return pSAppTitleBarBase.isPSSysAppNameDirty();
            }
            case 15: {
                return pSAppTitleBarBase.isPSSysCssIdDirty();
            }
            case 16: {
                return pSAppTitleBarBase.isPSSysCssNameDirty();
            }
            case 17: {
                return pSAppTitleBarBase.isPSSysImageIdDirty();
            }
            case 18: {
                return pSAppTitleBarBase.isPSSysImageNameDirty();
            }
            case 19: {
                return pSAppTitleBarBase.isPSSysPFPluginIdDirty();
            }
            case 20: {
                return pSAppTitleBarBase.isPSSysPFPluginNameDirty();
            }
            case 21: {
                return pSAppTitleBarBase.isPSViewMsgGroupIdDirty();
            }
            case 22: {
                return pSAppTitleBarBase.isPSViewMsgGroupNameDirty();
            }
            case 23: {
                return pSAppTitleBarBase.isRightPSAppMenuIdDirty();
            }
            case 24: {
                return pSAppTitleBarBase.isRightPSAppMenuNameDirty();
            }
            case 25: {
                return pSAppTitleBarBase.isTitleBarStyleDirty();
            }
            case 26: {
                return pSAppTitleBarBase.isUpdateDateDirty();
            }
            case 27: {
                return pSAppTitleBarBase.isUpdateManDirty();
            }
            case 28: {
                return pSAppTitleBarBase.isUserTagDirty();
            }
            case 29: {
                return pSAppTitleBarBase.isUserTag2Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSAppTitleBarBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSAppTitleBarBase pSAppTitleBarBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSAppTitleBarBase.getCapPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cappslanresid", (Object)PSAppTitleBarBase.getJSONValue((Object)pSAppTitleBarBase.getCapPSLanResId()), (boolean)false);
        }
        if (bl || pSAppTitleBarBase.getCapPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cappslanresname", (Object)PSAppTitleBarBase.getJSONValue((Object)pSAppTitleBarBase.getCapPSLanResName()), (boolean)false);
        }
        if (bl || pSAppTitleBarBase.getCaption() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"caption", (Object)PSAppTitleBarBase.getJSONValue((Object)pSAppTitleBarBase.getCaption()), (boolean)false);
        }
        if (bl || pSAppTitleBarBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSAppTitleBarBase.getJSONValue((Object)pSAppTitleBarBase.getCodeName()), (boolean)false);
        }
        if (bl || pSAppTitleBarBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSAppTitleBarBase.getJSONValue((Object)pSAppTitleBarBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSAppTitleBarBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSAppTitleBarBase.getJSONValue((Object)pSAppTitleBarBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSAppTitleBarBase.getLeftPSAppMenuId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"leftpsappmenuid", (Object)PSAppTitleBarBase.getJSONValue((Object)pSAppTitleBarBase.getLeftPSAppMenuId()), (boolean)false);
        }
        if (bl || pSAppTitleBarBase.getLeftPSAppMenuName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"leftpsappmenuname", (Object)PSAppTitleBarBase.getJSONValue((Object)pSAppTitleBarBase.getLeftPSAppMenuName()), (boolean)false);
        }
        if (bl || pSAppTitleBarBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSAppTitleBarBase.getJSONValue((Object)pSAppTitleBarBase.getMemo()), (boolean)false);
        }
        if (bl || pSAppTitleBarBase.getPSAppTitleBarId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psapptitlebarid", (Object)PSAppTitleBarBase.getJSONValue((Object)pSAppTitleBarBase.getPSAppTitleBarId()), (boolean)false);
        }
        if (bl || pSAppTitleBarBase.getPSAppTitleBarName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psapptitlebarname", (Object)PSAppTitleBarBase.getJSONValue((Object)pSAppTitleBarBase.getPSAppTitleBarName()), (boolean)false);
        }
        if (bl || pSAppTitleBarBase.getPSCtrlLogicGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrllogicgroupid", (Object)PSAppTitleBarBase.getJSONValue((Object)pSAppTitleBarBase.getPSCtrlLogicGroupId()), (boolean)false);
        }
        if (bl || pSAppTitleBarBase.getPSCtrlLogicGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrllogicgroupname", (Object)PSAppTitleBarBase.getJSONValue((Object)pSAppTitleBarBase.getPSCtrlLogicGroupName()), (boolean)false);
        }
        if (bl || pSAppTitleBarBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSAppTitleBarBase.getJSONValue((Object)pSAppTitleBarBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSAppTitleBarBase.getPSSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappname", (Object)PSAppTitleBarBase.getJSONValue((Object)pSAppTitleBarBase.getPSSysAppName()), (boolean)false);
        }
        if (bl || pSAppTitleBarBase.getPSSysCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssid", (Object)PSAppTitleBarBase.getJSONValue((Object)pSAppTitleBarBase.getPSSysCssId()), (boolean)false);
        }
        if (bl || pSAppTitleBarBase.getPSSysCssName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssname", (Object)PSAppTitleBarBase.getJSONValue((Object)pSAppTitleBarBase.getPSSysCssName()), (boolean)false);
        }
        if (bl || pSAppTitleBarBase.getPSSysImageId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysimageid", (Object)PSAppTitleBarBase.getJSONValue((Object)pSAppTitleBarBase.getPSSysImageId()), (boolean)false);
        }
        if (bl || pSAppTitleBarBase.getPSSysImageName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysimagename", (Object)PSAppTitleBarBase.getJSONValue((Object)pSAppTitleBarBase.getPSSysImageName()), (boolean)false);
        }
        if (bl || pSAppTitleBarBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSAppTitleBarBase.getJSONValue((Object)pSAppTitleBarBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSAppTitleBarBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSAppTitleBarBase.getJSONValue((Object)pSAppTitleBarBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSAppTitleBarBase.getPSViewMsgGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewmsggroupid", (Object)PSAppTitleBarBase.getJSONValue((Object)pSAppTitleBarBase.getPSViewMsgGroupId()), (boolean)false);
        }
        if (bl || pSAppTitleBarBase.getPSViewMsgGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewmsggroupname", (Object)PSAppTitleBarBase.getJSONValue((Object)pSAppTitleBarBase.getPSViewMsgGroupName()), (boolean)false);
        }
        if (bl || pSAppTitleBarBase.getRightPSAppMenuId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rightpsappmenuid", (Object)PSAppTitleBarBase.getJSONValue((Object)pSAppTitleBarBase.getRightPSAppMenuId()), (boolean)false);
        }
        if (bl || pSAppTitleBarBase.getRightPSAppMenuName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rightpsappmenuname", (Object)PSAppTitleBarBase.getJSONValue((Object)pSAppTitleBarBase.getRightPSAppMenuName()), (boolean)false);
        }
        if (bl || pSAppTitleBarBase.getTitleBarStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"titlebarstyle", (Object)PSAppTitleBarBase.getJSONValue((Object)pSAppTitleBarBase.getTitleBarStyle()), (boolean)false);
        }
        if (bl || pSAppTitleBarBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSAppTitleBarBase.getJSONValue((Object)pSAppTitleBarBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSAppTitleBarBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSAppTitleBarBase.getJSONValue((Object)pSAppTitleBarBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSAppTitleBarBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSAppTitleBarBase.getJSONValue((Object)pSAppTitleBarBase.getUserTag()), (boolean)false);
        }
        if (bl || pSAppTitleBarBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSAppTitleBarBase.getJSONValue((Object)pSAppTitleBarBase.getUserTag2()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSAppTitleBarBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSAppTitleBarBase pSAppTitleBarBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSAppTitleBarBase.getCapPSLanResId() != null) {
            object = pSAppTitleBarBase.getCapPSLanResId();
            xmlNode.setAttribute(FIELD_CAPPSLANRESID, (String)(object == null ? "" : object));
        }
        if (bl || pSAppTitleBarBase.getCapPSLanResName() != null) {
            object = pSAppTitleBarBase.getCapPSLanResName();
            xmlNode.setAttribute(FIELD_CAPPSLANRESNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSAppTitleBarBase.getCaption() != null) {
            object = pSAppTitleBarBase.getCaption();
            xmlNode.setAttribute(FIELD_CAPTION, (String)(object == null ? "" : object));
        }
        if (bl || pSAppTitleBarBase.getCodeName() != null) {
            object = pSAppTitleBarBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppTitleBarBase.getCreateDate() != null) {
            object = pSAppTitleBarBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppTitleBarBase.getCreateMan() != null) {
            object = pSAppTitleBarBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppTitleBarBase.getLeftPSAppMenuId() != null) {
            object = pSAppTitleBarBase.getLeftPSAppMenuId();
            xmlNode.setAttribute(FIELD_LEFTPSAPPMENUID, object == null ? "" : (String)object);
        }
        if (bl || pSAppTitleBarBase.getLeftPSAppMenuName() != null) {
            object = pSAppTitleBarBase.getLeftPSAppMenuName();
            xmlNode.setAttribute(FIELD_LEFTPSAPPMENUNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppTitleBarBase.getMemo() != null) {
            object = pSAppTitleBarBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSAppTitleBarBase.getPSAppTitleBarId() != null) {
            object = pSAppTitleBarBase.getPSAppTitleBarId();
            xmlNode.setAttribute(FIELD_PSAPPTITLEBARID, object == null ? "" : (String)object);
        }
        if (bl || pSAppTitleBarBase.getPSAppTitleBarName() != null) {
            object = pSAppTitleBarBase.getPSAppTitleBarName();
            xmlNode.setAttribute(FIELD_PSAPPTITLEBARNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppTitleBarBase.getPSCtrlLogicGroupId() != null) {
            object = pSAppTitleBarBase.getPSCtrlLogicGroupId();
            xmlNode.setAttribute(FIELD_PSCTRLLOGICGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSAppTitleBarBase.getPSCtrlLogicGroupName() != null) {
            object = pSAppTitleBarBase.getPSCtrlLogicGroupName();
            xmlNode.setAttribute(FIELD_PSCTRLLOGICGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppTitleBarBase.getPSSysAppId() != null) {
            object = pSAppTitleBarBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSAppTitleBarBase.getPSSysAppName() != null) {
            object = pSAppTitleBarBase.getPSSysAppName();
            xmlNode.setAttribute(FIELD_PSSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppTitleBarBase.getPSSysCssId() != null) {
            object = pSAppTitleBarBase.getPSSysCssId();
            xmlNode.setAttribute(FIELD_PSSYSCSSID, object == null ? "" : (String)object);
        }
        if (bl || pSAppTitleBarBase.getPSSysCssName() != null) {
            object = pSAppTitleBarBase.getPSSysCssName();
            xmlNode.setAttribute(FIELD_PSSYSCSSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppTitleBarBase.getPSSysImageId() != null) {
            object = pSAppTitleBarBase.getPSSysImageId();
            xmlNode.setAttribute(FIELD_PSSYSIMAGEID, object == null ? "" : (String)object);
        }
        if (bl || pSAppTitleBarBase.getPSSysImageName() != null) {
            object = pSAppTitleBarBase.getPSSysImageName();
            xmlNode.setAttribute(FIELD_PSSYSIMAGENAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppTitleBarBase.getPSSysPFPluginId() != null) {
            object = pSAppTitleBarBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSAppTitleBarBase.getPSSysPFPluginName() != null) {
            object = pSAppTitleBarBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppTitleBarBase.getPSViewMsgGroupId() != null) {
            object = pSAppTitleBarBase.getPSViewMsgGroupId();
            xmlNode.setAttribute(FIELD_PSVIEWMSGGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSAppTitleBarBase.getPSViewMsgGroupName() != null) {
            object = pSAppTitleBarBase.getPSViewMsgGroupName();
            xmlNode.setAttribute(FIELD_PSVIEWMSGGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppTitleBarBase.getRightPSAppMenuId() != null) {
            object = pSAppTitleBarBase.getRightPSAppMenuId();
            xmlNode.setAttribute(FIELD_RIGHTPSAPPMENUID, object == null ? "" : (String)object);
        }
        if (bl || pSAppTitleBarBase.getRightPSAppMenuName() != null) {
            object = pSAppTitleBarBase.getRightPSAppMenuName();
            xmlNode.setAttribute(FIELD_RIGHTPSAPPMENUNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppTitleBarBase.getTitleBarStyle() != null) {
            object = pSAppTitleBarBase.getTitleBarStyle();
            xmlNode.setAttribute(FIELD_TITLEBARSTYLE, object == null ? "" : (String)object);
        }
        if (bl || pSAppTitleBarBase.getUpdateDate() != null) {
            object = pSAppTitleBarBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppTitleBarBase.getUpdateMan() != null) {
            object = pSAppTitleBarBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppTitleBarBase.getUserTag() != null) {
            object = pSAppTitleBarBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSAppTitleBarBase.getUserTag2() != null) {
            object = pSAppTitleBarBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSAppTitleBarBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSAppTitleBarBase pSAppTitleBarBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSAppTitleBarBase.isCapPSLanResIdDirty() && (bl || pSAppTitleBarBase.getCapPSLanResId() != null)) {
            iDataObject.set(FIELD_CAPPSLANRESID, (Object)pSAppTitleBarBase.getCapPSLanResId());
        }
        if (pSAppTitleBarBase.isCapPSLanResNameDirty() && (bl || pSAppTitleBarBase.getCapPSLanResName() != null)) {
            iDataObject.set(FIELD_CAPPSLANRESNAME, (Object)pSAppTitleBarBase.getCapPSLanResName());
        }
        if (pSAppTitleBarBase.isCaptionDirty() && (bl || pSAppTitleBarBase.getCaption() != null)) {
            iDataObject.set(FIELD_CAPTION, (Object)pSAppTitleBarBase.getCaption());
        }
        if (pSAppTitleBarBase.isCodeNameDirty() && (bl || pSAppTitleBarBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSAppTitleBarBase.getCodeName());
        }
        if (pSAppTitleBarBase.isCreateDateDirty() && (bl || pSAppTitleBarBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSAppTitleBarBase.getCreateDate());
        }
        if (pSAppTitleBarBase.isCreateManDirty() && (bl || pSAppTitleBarBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSAppTitleBarBase.getCreateMan());
        }
        if (pSAppTitleBarBase.isLeftPSAppMenuIdDirty() && (bl || pSAppTitleBarBase.getLeftPSAppMenuId() != null)) {
            iDataObject.set(FIELD_LEFTPSAPPMENUID, (Object)pSAppTitleBarBase.getLeftPSAppMenuId());
        }
        if (pSAppTitleBarBase.isLeftPSAppMenuNameDirty() && (bl || pSAppTitleBarBase.getLeftPSAppMenuName() != null)) {
            iDataObject.set(FIELD_LEFTPSAPPMENUNAME, (Object)pSAppTitleBarBase.getLeftPSAppMenuName());
        }
        if (pSAppTitleBarBase.isMemoDirty() && (bl || pSAppTitleBarBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSAppTitleBarBase.getMemo());
        }
        if (pSAppTitleBarBase.isPSAppTitleBarIdDirty() && (bl || pSAppTitleBarBase.getPSAppTitleBarId() != null)) {
            iDataObject.set(FIELD_PSAPPTITLEBARID, (Object)pSAppTitleBarBase.getPSAppTitleBarId());
        }
        if (pSAppTitleBarBase.isPSAppTitleBarNameDirty() && (bl || pSAppTitleBarBase.getPSAppTitleBarName() != null)) {
            iDataObject.set(FIELD_PSAPPTITLEBARNAME, (Object)pSAppTitleBarBase.getPSAppTitleBarName());
        }
        if (pSAppTitleBarBase.isPSCtrlLogicGroupIdDirty() && (bl || pSAppTitleBarBase.getPSCtrlLogicGroupId() != null)) {
            iDataObject.set(FIELD_PSCTRLLOGICGROUPID, (Object)pSAppTitleBarBase.getPSCtrlLogicGroupId());
        }
        if (pSAppTitleBarBase.isPSCtrlLogicGroupNameDirty() && (bl || pSAppTitleBarBase.getPSCtrlLogicGroupName() != null)) {
            iDataObject.set(FIELD_PSCTRLLOGICGROUPNAME, (Object)pSAppTitleBarBase.getPSCtrlLogicGroupName());
        }
        if (pSAppTitleBarBase.isPSSysAppIdDirty() && (bl || pSAppTitleBarBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSAppTitleBarBase.getPSSysAppId());
        }
        if (pSAppTitleBarBase.isPSSysAppNameDirty() && (bl || pSAppTitleBarBase.getPSSysAppName() != null)) {
            iDataObject.set(FIELD_PSSYSAPPNAME, (Object)pSAppTitleBarBase.getPSSysAppName());
        }
        if (pSAppTitleBarBase.isPSSysCssIdDirty() && (bl || pSAppTitleBarBase.getPSSysCssId() != null)) {
            iDataObject.set(FIELD_PSSYSCSSID, (Object)pSAppTitleBarBase.getPSSysCssId());
        }
        if (pSAppTitleBarBase.isPSSysCssNameDirty() && (bl || pSAppTitleBarBase.getPSSysCssName() != null)) {
            iDataObject.set(FIELD_PSSYSCSSNAME, (Object)pSAppTitleBarBase.getPSSysCssName());
        }
        if (pSAppTitleBarBase.isPSSysImageIdDirty() && (bl || pSAppTitleBarBase.getPSSysImageId() != null)) {
            iDataObject.set(FIELD_PSSYSIMAGEID, (Object)pSAppTitleBarBase.getPSSysImageId());
        }
        if (pSAppTitleBarBase.isPSSysImageNameDirty() && (bl || pSAppTitleBarBase.getPSSysImageName() != null)) {
            iDataObject.set(FIELD_PSSYSIMAGENAME, (Object)pSAppTitleBarBase.getPSSysImageName());
        }
        if (pSAppTitleBarBase.isPSSysPFPluginIdDirty() && (bl || pSAppTitleBarBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSAppTitleBarBase.getPSSysPFPluginId());
        }
        if (pSAppTitleBarBase.isPSSysPFPluginNameDirty() && (bl || pSAppTitleBarBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSAppTitleBarBase.getPSSysPFPluginName());
        }
        if (pSAppTitleBarBase.isPSViewMsgGroupIdDirty() && (bl || pSAppTitleBarBase.getPSViewMsgGroupId() != null)) {
            iDataObject.set(FIELD_PSVIEWMSGGROUPID, (Object)pSAppTitleBarBase.getPSViewMsgGroupId());
        }
        if (pSAppTitleBarBase.isPSViewMsgGroupNameDirty() && (bl || pSAppTitleBarBase.getPSViewMsgGroupName() != null)) {
            iDataObject.set(FIELD_PSVIEWMSGGROUPNAME, (Object)pSAppTitleBarBase.getPSViewMsgGroupName());
        }
        if (pSAppTitleBarBase.isRightPSAppMenuIdDirty() && (bl || pSAppTitleBarBase.getRightPSAppMenuId() != null)) {
            iDataObject.set(FIELD_RIGHTPSAPPMENUID, (Object)pSAppTitleBarBase.getRightPSAppMenuId());
        }
        if (pSAppTitleBarBase.isRightPSAppMenuNameDirty() && (bl || pSAppTitleBarBase.getRightPSAppMenuName() != null)) {
            iDataObject.set(FIELD_RIGHTPSAPPMENUNAME, (Object)pSAppTitleBarBase.getRightPSAppMenuName());
        }
        if (pSAppTitleBarBase.isTitleBarStyleDirty() && (bl || pSAppTitleBarBase.getTitleBarStyle() != null)) {
            iDataObject.set(FIELD_TITLEBARSTYLE, (Object)pSAppTitleBarBase.getTitleBarStyle());
        }
        if (pSAppTitleBarBase.isUpdateDateDirty() && (bl || pSAppTitleBarBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSAppTitleBarBase.getUpdateDate());
        }
        if (pSAppTitleBarBase.isUpdateManDirty() && (bl || pSAppTitleBarBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSAppTitleBarBase.getUpdateMan());
        }
        if (pSAppTitleBarBase.isUserTagDirty() && (bl || pSAppTitleBarBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSAppTitleBarBase.getUserTag());
        }
        if (pSAppTitleBarBase.isUserTag2Dirty() && (bl || pSAppTitleBarBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSAppTitleBarBase.getUserTag2());
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
        return PSAppTitleBarBase.remove(this, n);
    }

    private static boolean remove(PSAppTitleBarBase pSAppTitleBarBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSAppTitleBarBase.resetCapPSLanResId();
                return true;
            }
            case 1: {
                pSAppTitleBarBase.resetCapPSLanResName();
                return true;
            }
            case 2: {
                pSAppTitleBarBase.resetCaption();
                return true;
            }
            case 3: {
                pSAppTitleBarBase.resetCodeName();
                return true;
            }
            case 4: {
                pSAppTitleBarBase.resetCreateDate();
                return true;
            }
            case 5: {
                pSAppTitleBarBase.resetCreateMan();
                return true;
            }
            case 6: {
                pSAppTitleBarBase.resetLeftPSAppMenuId();
                return true;
            }
            case 7: {
                pSAppTitleBarBase.resetLeftPSAppMenuName();
                return true;
            }
            case 8: {
                pSAppTitleBarBase.resetMemo();
                return true;
            }
            case 9: {
                pSAppTitleBarBase.resetPSAppTitleBarId();
                return true;
            }
            case 10: {
                pSAppTitleBarBase.resetPSAppTitleBarName();
                return true;
            }
            case 11: {
                pSAppTitleBarBase.resetPSCtrlLogicGroupId();
                return true;
            }
            case 12: {
                pSAppTitleBarBase.resetPSCtrlLogicGroupName();
                return true;
            }
            case 13: {
                pSAppTitleBarBase.resetPSSysAppId();
                return true;
            }
            case 14: {
                pSAppTitleBarBase.resetPSSysAppName();
                return true;
            }
            case 15: {
                pSAppTitleBarBase.resetPSSysCssId();
                return true;
            }
            case 16: {
                pSAppTitleBarBase.resetPSSysCssName();
                return true;
            }
            case 17: {
                pSAppTitleBarBase.resetPSSysImageId();
                return true;
            }
            case 18: {
                pSAppTitleBarBase.resetPSSysImageName();
                return true;
            }
            case 19: {
                pSAppTitleBarBase.resetPSSysPFPluginId();
                return true;
            }
            case 20: {
                pSAppTitleBarBase.resetPSSysPFPluginName();
                return true;
            }
            case 21: {
                pSAppTitleBarBase.resetPSViewMsgGroupId();
                return true;
            }
            case 22: {
                pSAppTitleBarBase.resetPSViewMsgGroupName();
                return true;
            }
            case 23: {
                pSAppTitleBarBase.resetRightPSAppMenuId();
                return true;
            }
            case 24: {
                pSAppTitleBarBase.resetRightPSAppMenuName();
                return true;
            }
            case 25: {
                pSAppTitleBarBase.resetTitleBarStyle();
                return true;
            }
            case 26: {
                pSAppTitleBarBase.resetUpdateDate();
                return true;
            }
            case 27: {
                pSAppTitleBarBase.resetUpdateMan();
                return true;
            }
            case 28: {
                pSAppTitleBarBase.resetUserTag();
                return true;
            }
            case 29: {
                pSAppTitleBarBase.resetUserTag2();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSAppMenu getLeftPSAppMenu() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLeftPSAppMenu();
        }
        if (this.getLeftPSAppMenuId() == null) {
            return null;
        }
        Integer n = this.objLeftPSAppMenuLock;
        synchronized (n) {
            if (this.leftpsappmenu != null && DataTypeHelper.compare((int)25, (Object)this.getLeftPSAppMenuId(), (Object)this.leftpsappmenu.getPSAppMenuId()) != 0L) {
                this.leftpsappmenu = null;
            }
            if (this.leftpsappmenu == null) {
                PSAppMenu pSAppMenu = new PSAppMenu();
                pSAppMenu.setPSAppMenuId(this.getLeftPSAppMenuId());
                PSAppMenuService pSAppMenuService = (PSAppMenuService)ServiceGlobal.getService(PSAppMenuService.class, (SessionFactory)this.getSessionFactory());
                pSAppMenuService.autoGet(pSAppMenu);
                this.leftpsappmenu = pSAppMenu;
            }
            return this.leftpsappmenu;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSAppMenu getRightPSAppMenu() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRightPSAppMenu();
        }
        if (this.getRightPSAppMenuId() == null) {
            return null;
        }
        Integer n = this.objRightPSAppMenuLock;
        synchronized (n) {
            if (this.rightpsappmenu != null && DataTypeHelper.compare((int)25, (Object)this.getRightPSAppMenuId(), (Object)this.rightpsappmenu.getPSAppMenuId()) != 0L) {
                this.rightpsappmenu = null;
            }
            if (this.rightpsappmenu == null) {
                PSAppMenu pSAppMenu = new PSAppMenu();
                pSAppMenu.setPSAppMenuId(this.getRightPSAppMenuId());
                PSAppMenuService pSAppMenuService = (PSAppMenuService)ServiceGlobal.getService(PSAppMenuService.class, (SessionFactory)this.getSessionFactory());
                pSAppMenuService.autoGet(pSAppMenu);
                this.rightpsappmenu = pSAppMenu;
            }
            return this.rightpsappmenu;
        }
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
                pSCtrlLogicGroupService.autoGet(pSCtrlLogicGroup);
                this.psctrllogicgroup = pSCtrlLogicGroup;
            }
            return this.psctrllogicgroup;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguageRes getCapPSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCapPSLanRes();
        }
        if (this.getCapPSLanResId() == null) {
            return null;
        }
        Integer n = this.objCapPSLanResLock;
        synchronized (n) {
            if (this.cappslanres != null && DataTypeHelper.compare((int)25, (Object)this.getCapPSLanResId(), (Object)this.cappslanres.getPSLanguageResId()) != 0L) {
                this.cappslanres = null;
            }
            if (this.cappslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getCapPSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet(pSLanguageRes);
                this.cappslanres = pSLanguageRes;
            }
            return this.cappslanres;
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
                pSSysCssService.autoGet(pSSysCss);
                this.pssyscss = pSSysCss;
            }
            return this.pssyscss;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysImage getPSSysImage() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysImage();
        }
        if (this.getPSSysImageId() == null) {
            return null;
        }
        Integer n = this.objPSSysImageLock;
        synchronized (n) {
            if (this.pssysimage != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysImageId(), (Object)this.pssysimage.getPSSysImageId()) != 0L) {
                this.pssysimage = null;
            }
            if (this.pssysimage == null) {
                PSSysImage pSSysImage = new PSSysImage();
                pSSysImage.setPSSysImageId(this.getPSSysImageId());
                PSSysImageService pSSysImageService = (PSSysImageService)ServiceGlobal.getService(PSSysImageService.class, (SessionFactory)this.getSessionFactory());
                pSSysImageService.autoGet(pSSysImage);
                this.pssysimage = pSSysImage;
            }
            return this.pssysimage;
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
                pSSysPFPluginService.autoGet(pSSysPFPlugin);
                this.pssyspfplugin = pSSysPFPlugin;
            }
            return this.pssyspfplugin;
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
                pSViewMsgGroupService.autoGet(pSViewMsgGroup);
                this.psviewmsggroup = pSViewMsgGroup;
            }
            return this.psviewmsggroup;
        }
    }

    private PSAppTitleBarBase getProxyEntity() {
        return this.proxyPSAppTitleBarBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSAppTitleBarBase = null;
        if (iDataObject != null && iDataObject instanceof PSAppTitleBarBase) {
            this.proxyPSAppTitleBarBase = (PSAppTitleBarBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppTitleBarService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CAPPSLANRESID, 0);
        fieldIndexMap.put(FIELD_CAPPSLANRESNAME, 1);
        fieldIndexMap.put(FIELD_CAPTION, 2);
        fieldIndexMap.put(FIELD_CODENAME, 3);
        fieldIndexMap.put(FIELD_CREATEDATE, 4);
        fieldIndexMap.put(FIELD_CREATEMAN, 5);
        fieldIndexMap.put(FIELD_LEFTPSAPPMENUID, 6);
        fieldIndexMap.put(FIELD_LEFTPSAPPMENUNAME, 7);
        fieldIndexMap.put(FIELD_MEMO, 8);
        fieldIndexMap.put(FIELD_PSAPPTITLEBARID, 9);
        fieldIndexMap.put(FIELD_PSAPPTITLEBARNAME, 10);
        fieldIndexMap.put(FIELD_PSCTRLLOGICGROUPID, 11);
        fieldIndexMap.put(FIELD_PSCTRLLOGICGROUPNAME, 12);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 13);
        fieldIndexMap.put(FIELD_PSSYSAPPNAME, 14);
        fieldIndexMap.put(FIELD_PSSYSCSSID, 15);
        fieldIndexMap.put(FIELD_PSSYSCSSNAME, 16);
        fieldIndexMap.put(FIELD_PSSYSIMAGEID, 17);
        fieldIndexMap.put(FIELD_PSSYSIMAGENAME, 18);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINID, 19);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINNAME, 20);
        fieldIndexMap.put(FIELD_PSVIEWMSGGROUPID, 21);
        fieldIndexMap.put(FIELD_PSVIEWMSGGROUPNAME, 22);
        fieldIndexMap.put(FIELD_RIGHTPSAPPMENUID, 23);
        fieldIndexMap.put(FIELD_RIGHTPSAPPMENUNAME, 24);
        fieldIndexMap.put(FIELD_TITLEBARSTYLE, 25);
        fieldIndexMap.put(FIELD_UPDATEDATE, 26);
        fieldIndexMap.put(FIELD_UPDATEMAN, 27);
        fieldIndexMap.put(FIELD_USERTAG, 28);
        fieldIndexMap.put(FIELD_USERTAG2, 29);
    }
}

