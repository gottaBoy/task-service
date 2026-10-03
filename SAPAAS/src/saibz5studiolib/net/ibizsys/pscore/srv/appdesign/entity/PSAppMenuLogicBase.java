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
import net.ibizsys.pscore.srv.appdesign.entity.PSAppMenuItem;
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuItemService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuService;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.service.PSSysPFPluginService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewLogic;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanel;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewLogicService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppMenuLogicBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSAppMenuLogicBase.class);
    public static final String FIELD_ATTRNAME = "ATTRNAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMCODE = "CUSTOMCODE";
    public static final String FIELD_DSTLOGICTYPE = "DSTLOGICTYPE";
    public static final String FIELD_EVENTARG = "EVENTARG";
    public static final String FIELD_EVENTARG2 = "EVENTARG2";
    public static final String FIELD_EVENTNAMES = "EVENTNAMES";
    public static final String FIELD_LOGICPARAM = "LOGICPARAM";
    public static final String FIELD_LOGICPARAM2 = "LOGICPARAM2";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSAPPMENUID = "PSAPPMENUID";
    public static final String FIELD_PSAPPMENUITEMID = "PSAPPMENUITEMID";
    public static final String FIELD_PSAPPMENUITEMNAME = "PSAPPMENUITEMNAME";
    public static final String FIELD_PSAPPMENULOGICID = "PSAPPMENULOGICID";
    public static final String FIELD_PSAPPMENULOGICNAME = "PSAPPMENULOGICNAME";
    public static final String FIELD_PSAPPMENUNAME = "PSAPPMENUNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDELOGICID = "PSDELOGICID";
    public static final String FIELD_PSDELOGICNAME = "PSDELOGICNAME";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDEUIACTIONID = "PSDEUIACTIONID";
    public static final String FIELD_PSDEUIACTIONNAME = "PSDEUIACTIONNAME";
    public static final String FIELD_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String FIELD_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String FIELD_PSSYSVIEWLOGICID = "PSSYSVIEWLOGICID";
    public static final String FIELD_PSSYSVIEWLOGICNAME = "PSSYSVIEWLOGICNAME";
    public static final String FIELD_PSSYSVIEWPANELID = "PSSYSVIEWPANELID";
    public static final String FIELD_PSSYSVIEWPANELNAME = "PSSYSVIEWPANELNAME";
    public static final String FIELD_TIMER = "TIMER";
    public static final String FIELD_TRIGGERTYPE = "TRIGGERTYPE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_ATTRNAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_CUSTOMCODE = 3;
    private static final int INDEX_DSTLOGICTYPE = 4;
    private static final int INDEX_EVENTARG = 5;
    private static final int INDEX_EVENTARG2 = 6;
    private static final int INDEX_EVENTNAMES = 7;
    private static final int INDEX_LOGICPARAM = 8;
    private static final int INDEX_LOGICPARAM2 = 9;
    private static final int INDEX_MEMO = 10;
    private static final int INDEX_ORDERVALUE = 11;
    private static final int INDEX_PSAPPMENUID = 12;
    private static final int INDEX_PSAPPMENUITEMID = 13;
    private static final int INDEX_PSAPPMENUITEMNAME = 14;
    private static final int INDEX_PSAPPMENULOGICID = 15;
    private static final int INDEX_PSAPPMENULOGICNAME = 16;
    private static final int INDEX_PSAPPMENUNAME = 17;
    private static final int INDEX_PSDEID = 18;
    private static final int INDEX_PSDELOGICID = 19;
    private static final int INDEX_PSDELOGICNAME = 20;
    private static final int INDEX_PSDENAME = 21;
    private static final int INDEX_PSDEUIACTIONID = 22;
    private static final int INDEX_PSDEUIACTIONNAME = 23;
    private static final int INDEX_PSSYSPFPLUGINID = 24;
    private static final int INDEX_PSSYSPFPLUGINNAME = 25;
    private static final int INDEX_PSSYSVIEWLOGICID = 26;
    private static final int INDEX_PSSYSVIEWLOGICNAME = 27;
    private static final int INDEX_PSSYSVIEWPANELID = 28;
    private static final int INDEX_PSSYSVIEWPANELNAME = 29;
    private static final int INDEX_TIMER = 30;
    private static final int INDEX_TRIGGERTYPE = 31;
    private static final int INDEX_UPDATEDATE = 32;
    private static final int INDEX_UPDATEMAN = 33;
    private static final int INDEX_USERCAT = 34;
    private static final int INDEX_USERTAG = 35;
    private static final int INDEX_USERTAG2 = 36;
    private static final int INDEX_USERTAG3 = 37;
    private static final int INDEX_USERTAG4 = 38;
    private static final int INDEX_VALIDFLAG = 39;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSAppMenuLogicBase proxyPSAppMenuLogicBase = null;
    private boolean attrnameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customcodeDirtyFlag = false;
    private boolean dstlogictypeDirtyFlag = false;
    private boolean eventargDirtyFlag = false;
    private boolean eventarg2DirtyFlag = false;
    private boolean eventnamesDirtyFlag = false;
    private boolean logicparamDirtyFlag = false;
    private boolean logicparam2DirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psappmenuidDirtyFlag = false;
    private boolean psappmenuitemidDirtyFlag = false;
    private boolean psappmenuitemnameDirtyFlag = false;
    private boolean psappmenulogicidDirtyFlag = false;
    private boolean psappmenulogicnameDirtyFlag = false;
    private boolean psappmenunameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdelogicidDirtyFlag = false;
    private boolean psdelogicnameDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psdeuiactionidDirtyFlag = false;
    private boolean psdeuiactionnameDirtyFlag = false;
    private boolean pssyspfpluginidDirtyFlag = false;
    private boolean pssyspfpluginnameDirtyFlag = false;
    private boolean pssysviewlogicidDirtyFlag = false;
    private boolean pssysviewlogicnameDirtyFlag = false;
    private boolean pssysviewpanelidDirtyFlag = false;
    private boolean pssysviewpanelnameDirtyFlag = false;
    private boolean timerDirtyFlag = false;
    private boolean triggertypeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="attrname")
    private String attrname;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="customcode")
    private String customcode;
    @Column(name="dstlogictype")
    private String dstlogictype;
    @Column(name="eventarg")
    private String eventarg;
    @Column(name="eventarg2")
    private String eventarg2;
    @Column(name="eventnames")
    private String eventnames;
    @Column(name="logicparam")
    private String logicparam;
    @Column(name="logicparam2")
    private String logicparam2;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psappmenuid")
    private String psappmenuid;
    @Column(name="psappmenuitemid")
    private String psappmenuitemid;
    @Column(name="psappmenuitemname")
    private String psappmenuitemname;
    @Column(name="psappmenulogicid")
    private String psappmenulogicid;
    @Column(name="psappmenulogicname")
    private String psappmenulogicname;
    @Column(name="psappmenuname")
    private String psappmenuname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdelogicid")
    private String psdelogicid;
    @Column(name="psdelogicname")
    private String psdelogicname;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psdeuiactionid")
    private String psdeuiactionid;
    @Column(name="psdeuiactionname")
    private String psdeuiactionname;
    @Column(name="pssyspfpluginid")
    private String pssyspfpluginid;
    @Column(name="pssyspfpluginname")
    private String pssyspfpluginname;
    @Column(name="pssysviewlogicid")
    private String pssysviewlogicid;
    @Column(name="pssysviewlogicname")
    private String pssysviewlogicname;
    @Column(name="pssysviewpanelid")
    private String pssysviewpanelid;
    @Column(name="pssysviewpanelname")
    private String pssysviewpanelname;
    @Column(name="timer")
    private Integer timer;
    @Column(name="triggertype")
    private String triggertype;
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
    private Integer objPSAppMenuItemLock = new Integer(1);
    private PSAppMenuItem psappmenuitem = null;
    private Integer objPSAppMenuLock = new Integer(1);
    private PSAppMenu psappmenu = null;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objPSDELogicLock = new Integer(1);
    private PSDELogic psdelogic = null;
    private Integer objPSDEUIActionLock = new Integer(1);
    private PSDEUIAction psdeuiaction = null;
    private Integer objPSSysPFPluginLock = new Integer(1);
    private PSSysPFPlugin pssyspfplugin = null;
    private Integer objPSSysViewLogicLock = new Integer(1);
    private PSSysViewLogic pssysviewlogic = null;
    private Integer objPSSysViewPanelLock = new Integer(1);
    private PSSysViewPanel pssysviewpanel = null;

    public void setAttrName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAttrName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.attrname = string;
        this.attrnameDirtyFlag = true;
    }

    public String getAttrName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAttrName();
        }
        return this.attrname;
    }

    public boolean isAttrNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAttrNameDirty();
        }
        return this.attrnameDirtyFlag;
    }

    public void resetAttrName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAttrName();
            return;
        }
        this.attrnameDirtyFlag = false;
        this.attrname = null;
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

    public void setDstLogicType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstLogicType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstlogictype = string;
        this.dstlogictypeDirtyFlag = true;
    }

    public String getDstLogicType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstLogicType();
        }
        return this.dstlogictype;
    }

    public boolean isDstLogicTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstLogicTypeDirty();
        }
        return this.dstlogictypeDirtyFlag;
    }

    public void resetDstLogicType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstLogicType();
            return;
        }
        this.dstlogictypeDirtyFlag = false;
        this.dstlogictype = null;
    }

    public void setEventArg(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEventArg(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.eventarg = string;
        this.eventargDirtyFlag = true;
    }

    public String getEventArg() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEventArg();
        }
        return this.eventarg;
    }

    public boolean isEventArgDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEventArgDirty();
        }
        return this.eventargDirtyFlag;
    }

    public void resetEventArg() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEventArg();
            return;
        }
        this.eventargDirtyFlag = false;
        this.eventarg = null;
    }

    public void setEventArg2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEventArg2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.eventarg2 = string;
        this.eventarg2DirtyFlag = true;
    }

    public String getEventArg2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEventArg2();
        }
        return this.eventarg2;
    }

    public boolean isEventArg2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEventArg2Dirty();
        }
        return this.eventarg2DirtyFlag;
    }

    public void resetEventArg2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEventArg2();
            return;
        }
        this.eventarg2DirtyFlag = false;
        this.eventarg2 = null;
    }

    public void setEventNames(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEventNames(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.eventnames = string;
        this.eventnamesDirtyFlag = true;
    }

    public String getEventNames() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEventNames();
        }
        return this.eventnames;
    }

    public boolean isEventNamesDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEventNamesDirty();
        }
        return this.eventnamesDirtyFlag;
    }

    public void resetEventNames() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEventNames();
            return;
        }
        this.eventnamesDirtyFlag = false;
        this.eventnames = null;
    }

    public void setLogicParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogicParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.logicparam = string;
        this.logicparamDirtyFlag = true;
    }

    public String getLogicParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogicParam();
        }
        return this.logicparam;
    }

    public boolean isLogicParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogicParamDirty();
        }
        return this.logicparamDirtyFlag;
    }

    public void resetLogicParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogicParam();
            return;
        }
        this.logicparamDirtyFlag = false;
        this.logicparam = null;
    }

    public void setLogicParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogicParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.logicparam2 = string;
        this.logicparam2DirtyFlag = true;
    }

    public String getLogicParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogicParam2();
        }
        return this.logicparam2;
    }

    public boolean isLogicParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogicParam2Dirty();
        }
        return this.logicparam2DirtyFlag;
    }

    public void resetLogicParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogicParam2();
            return;
        }
        this.logicparam2DirtyFlag = false;
        this.logicparam2 = null;
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

    public void setPSAppMenuItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppMenuItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappmenuitemid = string;
        this.psappmenuitemidDirtyFlag = true;
    }

    public String getPSAppMenuItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppMenuItemId();
        }
        return this.psappmenuitemid;
    }

    public boolean isPSAppMenuItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppMenuItemIdDirty();
        }
        return this.psappmenuitemidDirtyFlag;
    }

    public void resetPSAppMenuItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppMenuItemId();
            return;
        }
        this.psappmenuitemidDirtyFlag = false;
        this.psappmenuitemid = null;
    }

    public void setPSAppMenuItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppMenuItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappmenuitemname = string;
        this.psappmenuitemnameDirtyFlag = true;
    }

    public String getPSAppMenuItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppMenuItemName();
        }
        return this.psappmenuitemname;
    }

    public boolean isPSAppMenuItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppMenuItemNameDirty();
        }
        return this.psappmenuitemnameDirtyFlag;
    }

    public void resetPSAppMenuItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppMenuItemName();
            return;
        }
        this.psappmenuitemnameDirtyFlag = false;
        this.psappmenuitemname = null;
    }

    public void setPSAppMenuLogicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppMenuLogicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappmenulogicid = string;
        this.psappmenulogicidDirtyFlag = true;
    }

    public String getPSAppMenuLogicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppMenuLogicId();
        }
        return this.psappmenulogicid;
    }

    public boolean isPSAppMenuLogicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppMenuLogicIdDirty();
        }
        return this.psappmenulogicidDirtyFlag;
    }

    public void resetPSAppMenuLogicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppMenuLogicId();
            return;
        }
        this.psappmenulogicidDirtyFlag = false;
        this.psappmenulogicid = null;
    }

    public void setPSAppMenuLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppMenuLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappmenulogicname = string;
        this.psappmenulogicnameDirtyFlag = true;
    }

    public String getPSAppMenuLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppMenuLogicName();
        }
        return this.psappmenulogicname;
    }

    public boolean isPSAppMenuLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppMenuLogicNameDirty();
        }
        return this.psappmenulogicnameDirtyFlag;
    }

    public void resetPSAppMenuLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppMenuLogicName();
            return;
        }
        this.psappmenulogicnameDirtyFlag = false;
        this.psappmenulogicname = null;
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

    public void setPSDEUIActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEUIActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeuiactionid = string;
        this.psdeuiactionidDirtyFlag = true;
    }

    public String getPSDEUIActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUIActionId();
        }
        return this.psdeuiactionid;
    }

    public boolean isPSDEUIActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEUIActionIdDirty();
        }
        return this.psdeuiactionidDirtyFlag;
    }

    public void resetPSDEUIActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEUIActionId();
            return;
        }
        this.psdeuiactionidDirtyFlag = false;
        this.psdeuiactionid = null;
    }

    public void setPSDEUIActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEUIActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeuiactionname = string;
        this.psdeuiactionnameDirtyFlag = true;
    }

    public String getPSDEUIActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUIActionName();
        }
        return this.psdeuiactionname;
    }

    public boolean isPSDEUIActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEUIActionNameDirty();
        }
        return this.psdeuiactionnameDirtyFlag;
    }

    public void resetPSDEUIActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEUIActionName();
            return;
        }
        this.psdeuiactionnameDirtyFlag = false;
        this.psdeuiactionname = null;
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

    public void setPSSysViewLogicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysViewLogicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysviewlogicid = string;
        this.pssysviewlogicidDirtyFlag = true;
    }

    public String getPSSysViewLogicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewLogicId();
        }
        return this.pssysviewlogicid;
    }

    public boolean isPSSysViewLogicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysViewLogicIdDirty();
        }
        return this.pssysviewlogicidDirtyFlag;
    }

    public void resetPSSysViewLogicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysViewLogicId();
            return;
        }
        this.pssysviewlogicidDirtyFlag = false;
        this.pssysviewlogicid = null;
    }

    public void setPSSysViewLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysViewLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysviewlogicname = string;
        this.pssysviewlogicnameDirtyFlag = true;
    }

    public String getPSSysViewLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewLogicName();
        }
        return this.pssysviewlogicname;
    }

    public boolean isPSSysViewLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysViewLogicNameDirty();
        }
        return this.pssysviewlogicnameDirtyFlag;
    }

    public void resetPSSysViewLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysViewLogicName();
            return;
        }
        this.pssysviewlogicnameDirtyFlag = false;
        this.pssysviewlogicname = null;
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

    public void setTimer(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTimer(n);
            return;
        }
        this.timer = n;
        this.timerDirtyFlag = true;
    }

    public Integer getTimer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTimer();
        }
        return this.timer;
    }

    public boolean isTimerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTimerDirty();
        }
        return this.timerDirtyFlag;
    }

    public void resetTimer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTimer();
            return;
        }
        this.timerDirtyFlag = false;
        this.timer = null;
    }

    public void setTriggerType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTriggerType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.triggertype = string;
        this.triggertypeDirtyFlag = true;
    }

    public String getTriggerType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTriggerType();
        }
        return this.triggertype;
    }

    public boolean isTriggerTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTriggerTypeDirty();
        }
        return this.triggertypeDirtyFlag;
    }

    public void resetTriggerType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTriggerType();
            return;
        }
        this.triggertypeDirtyFlag = false;
        this.triggertype = null;
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
        PSAppMenuLogicBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSAppMenuLogicBase pSAppMenuLogicBase) {
        pSAppMenuLogicBase.resetAttrName();
        pSAppMenuLogicBase.resetCreateDate();
        pSAppMenuLogicBase.resetCreateMan();
        pSAppMenuLogicBase.resetCustomCode();
        pSAppMenuLogicBase.resetDstLogicType();
        pSAppMenuLogicBase.resetEventArg();
        pSAppMenuLogicBase.resetEventArg2();
        pSAppMenuLogicBase.resetEventNames();
        pSAppMenuLogicBase.resetLogicParam();
        pSAppMenuLogicBase.resetLogicParam2();
        pSAppMenuLogicBase.resetMemo();
        pSAppMenuLogicBase.resetOrderValue();
        pSAppMenuLogicBase.resetPSAppMenuId();
        pSAppMenuLogicBase.resetPSAppMenuItemId();
        pSAppMenuLogicBase.resetPSAppMenuItemName();
        pSAppMenuLogicBase.resetPSAppMenuLogicId();
        pSAppMenuLogicBase.resetPSAppMenuLogicName();
        pSAppMenuLogicBase.resetPSAppMenuName();
        pSAppMenuLogicBase.resetPSDEId();
        pSAppMenuLogicBase.resetPSDELogicId();
        pSAppMenuLogicBase.resetPSDELogicName();
        pSAppMenuLogicBase.resetPSDEName();
        pSAppMenuLogicBase.resetPSDEUIActionId();
        pSAppMenuLogicBase.resetPSDEUIActionName();
        pSAppMenuLogicBase.resetPSSysPFPluginId();
        pSAppMenuLogicBase.resetPSSysPFPluginName();
        pSAppMenuLogicBase.resetPSSysViewLogicId();
        pSAppMenuLogicBase.resetPSSysViewLogicName();
        pSAppMenuLogicBase.resetPSSysViewPanelId();
        pSAppMenuLogicBase.resetPSSysViewPanelName();
        pSAppMenuLogicBase.resetTimer();
        pSAppMenuLogicBase.resetTriggerType();
        pSAppMenuLogicBase.resetUpdateDate();
        pSAppMenuLogicBase.resetUpdateMan();
        pSAppMenuLogicBase.resetUserCat();
        pSAppMenuLogicBase.resetUserTag();
        pSAppMenuLogicBase.resetUserTag2();
        pSAppMenuLogicBase.resetUserTag3();
        pSAppMenuLogicBase.resetUserTag4();
        pSAppMenuLogicBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAttrNameDirty()) {
            hashMap.put(FIELD_ATTRNAME, this.getAttrName());
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
        if (!bl || this.isDstLogicTypeDirty()) {
            hashMap.put(FIELD_DSTLOGICTYPE, this.getDstLogicType());
        }
        if (!bl || this.isEventArgDirty()) {
            hashMap.put(FIELD_EVENTARG, this.getEventArg());
        }
        if (!bl || this.isEventArg2Dirty()) {
            hashMap.put(FIELD_EVENTARG2, this.getEventArg2());
        }
        if (!bl || this.isEventNamesDirty()) {
            hashMap.put(FIELD_EVENTNAMES, this.getEventNames());
        }
        if (!bl || this.isLogicParamDirty()) {
            hashMap.put(FIELD_LOGICPARAM, this.getLogicParam());
        }
        if (!bl || this.isLogicParam2Dirty()) {
            hashMap.put(FIELD_LOGICPARAM2, this.getLogicParam2());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSAppMenuIdDirty()) {
            hashMap.put(FIELD_PSAPPMENUID, this.getPSAppMenuId());
        }
        if (!bl || this.isPSAppMenuItemIdDirty()) {
            hashMap.put(FIELD_PSAPPMENUITEMID, this.getPSAppMenuItemId());
        }
        if (!bl || this.isPSAppMenuItemNameDirty()) {
            hashMap.put(FIELD_PSAPPMENUITEMNAME, this.getPSAppMenuItemName());
        }
        if (!bl || this.isPSAppMenuLogicIdDirty()) {
            hashMap.put(FIELD_PSAPPMENULOGICID, this.getPSAppMenuLogicId());
        }
        if (!bl || this.isPSAppMenuLogicNameDirty()) {
            hashMap.put(FIELD_PSAPPMENULOGICNAME, this.getPSAppMenuLogicName());
        }
        if (!bl || this.isPSAppMenuNameDirty()) {
            hashMap.put(FIELD_PSAPPMENUNAME, this.getPSAppMenuName());
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
        if (!bl || this.isPSDEUIActionIdDirty()) {
            hashMap.put(FIELD_PSDEUIACTIONID, this.getPSDEUIActionId());
        }
        if (!bl || this.isPSDEUIActionNameDirty()) {
            hashMap.put(FIELD_PSDEUIACTIONNAME, this.getPSDEUIActionName());
        }
        if (!bl || this.isPSSysPFPluginIdDirty()) {
            hashMap.put(FIELD_PSSYSPFPLUGINID, this.getPSSysPFPluginId());
        }
        if (!bl || this.isPSSysPFPluginNameDirty()) {
            hashMap.put(FIELD_PSSYSPFPLUGINNAME, this.getPSSysPFPluginName());
        }
        if (!bl || this.isPSSysViewLogicIdDirty()) {
            hashMap.put(FIELD_PSSYSVIEWLOGICID, this.getPSSysViewLogicId());
        }
        if (!bl || this.isPSSysViewLogicNameDirty()) {
            hashMap.put(FIELD_PSSYSVIEWLOGICNAME, this.getPSSysViewLogicName());
        }
        if (!bl || this.isPSSysViewPanelIdDirty()) {
            hashMap.put(FIELD_PSSYSVIEWPANELID, this.getPSSysViewPanelId());
        }
        if (!bl || this.isPSSysViewPanelNameDirty()) {
            hashMap.put(FIELD_PSSYSVIEWPANELNAME, this.getPSSysViewPanelName());
        }
        if (!bl || this.isTimerDirty()) {
            hashMap.put(FIELD_TIMER, this.getTimer());
        }
        if (!bl || this.isTriggerTypeDirty()) {
            hashMap.put(FIELD_TRIGGERTYPE, this.getTriggerType());
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
        return PSAppMenuLogicBase.get(this, n);
    }

    private static Object get(PSAppMenuLogicBase pSAppMenuLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppMenuLogicBase.getAttrName();
            }
            case 1: {
                return pSAppMenuLogicBase.getCreateDate();
            }
            case 2: {
                return pSAppMenuLogicBase.getCreateMan();
            }
            case 3: {
                return pSAppMenuLogicBase.getCustomCode();
            }
            case 4: {
                return pSAppMenuLogicBase.getDstLogicType();
            }
            case 5: {
                return pSAppMenuLogicBase.getEventArg();
            }
            case 6: {
                return pSAppMenuLogicBase.getEventArg2();
            }
            case 7: {
                return pSAppMenuLogicBase.getEventNames();
            }
            case 8: {
                return pSAppMenuLogicBase.getLogicParam();
            }
            case 9: {
                return pSAppMenuLogicBase.getLogicParam2();
            }
            case 10: {
                return pSAppMenuLogicBase.getMemo();
            }
            case 11: {
                return pSAppMenuLogicBase.getOrderValue();
            }
            case 12: {
                return pSAppMenuLogicBase.getPSAppMenuId();
            }
            case 13: {
                return pSAppMenuLogicBase.getPSAppMenuItemId();
            }
            case 14: {
                return pSAppMenuLogicBase.getPSAppMenuItemName();
            }
            case 15: {
                return pSAppMenuLogicBase.getPSAppMenuLogicId();
            }
            case 16: {
                return pSAppMenuLogicBase.getPSAppMenuLogicName();
            }
            case 17: {
                return pSAppMenuLogicBase.getPSAppMenuName();
            }
            case 18: {
                return pSAppMenuLogicBase.getPSDEId();
            }
            case 19: {
                return pSAppMenuLogicBase.getPSDELogicId();
            }
            case 20: {
                return pSAppMenuLogicBase.getPSDELogicName();
            }
            case 21: {
                return pSAppMenuLogicBase.getPSDEName();
            }
            case 22: {
                return pSAppMenuLogicBase.getPSDEUIActionId();
            }
            case 23: {
                return pSAppMenuLogicBase.getPSDEUIActionName();
            }
            case 24: {
                return pSAppMenuLogicBase.getPSSysPFPluginId();
            }
            case 25: {
                return pSAppMenuLogicBase.getPSSysPFPluginName();
            }
            case 26: {
                return pSAppMenuLogicBase.getPSSysViewLogicId();
            }
            case 27: {
                return pSAppMenuLogicBase.getPSSysViewLogicName();
            }
            case 28: {
                return pSAppMenuLogicBase.getPSSysViewPanelId();
            }
            case 29: {
                return pSAppMenuLogicBase.getPSSysViewPanelName();
            }
            case 30: {
                return pSAppMenuLogicBase.getTimer();
            }
            case 31: {
                return pSAppMenuLogicBase.getTriggerType();
            }
            case 32: {
                return pSAppMenuLogicBase.getUpdateDate();
            }
            case 33: {
                return pSAppMenuLogicBase.getUpdateMan();
            }
            case 34: {
                return pSAppMenuLogicBase.getUserCat();
            }
            case 35: {
                return pSAppMenuLogicBase.getUserTag();
            }
            case 36: {
                return pSAppMenuLogicBase.getUserTag2();
            }
            case 37: {
                return pSAppMenuLogicBase.getUserTag3();
            }
            case 38: {
                return pSAppMenuLogicBase.getUserTag4();
            }
            case 39: {
                return pSAppMenuLogicBase.getValidFlag();
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
        PSAppMenuLogicBase.set(this, n, object);
    }

    private static void set(PSAppMenuLogicBase pSAppMenuLogicBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSAppMenuLogicBase.setAttrName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSAppMenuLogicBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSAppMenuLogicBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSAppMenuLogicBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSAppMenuLogicBase.setDstLogicType(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSAppMenuLogicBase.setEventArg(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSAppMenuLogicBase.setEventArg2(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSAppMenuLogicBase.setEventNames(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSAppMenuLogicBase.setLogicParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSAppMenuLogicBase.setLogicParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSAppMenuLogicBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSAppMenuLogicBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSAppMenuLogicBase.setPSAppMenuId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSAppMenuLogicBase.setPSAppMenuItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSAppMenuLogicBase.setPSAppMenuItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSAppMenuLogicBase.setPSAppMenuLogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSAppMenuLogicBase.setPSAppMenuLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSAppMenuLogicBase.setPSAppMenuName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSAppMenuLogicBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSAppMenuLogicBase.setPSDELogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSAppMenuLogicBase.setPSDELogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSAppMenuLogicBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSAppMenuLogicBase.setPSDEUIActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSAppMenuLogicBase.setPSDEUIActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSAppMenuLogicBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSAppMenuLogicBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSAppMenuLogicBase.setPSSysViewLogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSAppMenuLogicBase.setPSSysViewLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSAppMenuLogicBase.setPSSysViewPanelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSAppMenuLogicBase.setPSSysViewPanelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSAppMenuLogicBase.setTimer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 31: {
                pSAppMenuLogicBase.setTriggerType(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSAppMenuLogicBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 33: {
                pSAppMenuLogicBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSAppMenuLogicBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSAppMenuLogicBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSAppMenuLogicBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSAppMenuLogicBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSAppMenuLogicBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSAppMenuLogicBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSAppMenuLogicBase.isNull(this, n);
    }

    private static boolean isNull(PSAppMenuLogicBase pSAppMenuLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppMenuLogicBase.getAttrName() == null;
            }
            case 1: {
                return pSAppMenuLogicBase.getCreateDate() == null;
            }
            case 2: {
                return pSAppMenuLogicBase.getCreateMan() == null;
            }
            case 3: {
                return pSAppMenuLogicBase.getCustomCode() == null;
            }
            case 4: {
                return pSAppMenuLogicBase.getDstLogicType() == null;
            }
            case 5: {
                return pSAppMenuLogicBase.getEventArg() == null;
            }
            case 6: {
                return pSAppMenuLogicBase.getEventArg2() == null;
            }
            case 7: {
                return pSAppMenuLogicBase.getEventNames() == null;
            }
            case 8: {
                return pSAppMenuLogicBase.getLogicParam() == null;
            }
            case 9: {
                return pSAppMenuLogicBase.getLogicParam2() == null;
            }
            case 10: {
                return pSAppMenuLogicBase.getMemo() == null;
            }
            case 11: {
                return pSAppMenuLogicBase.getOrderValue() == null;
            }
            case 12: {
                return pSAppMenuLogicBase.getPSAppMenuId() == null;
            }
            case 13: {
                return pSAppMenuLogicBase.getPSAppMenuItemId() == null;
            }
            case 14: {
                return pSAppMenuLogicBase.getPSAppMenuItemName() == null;
            }
            case 15: {
                return pSAppMenuLogicBase.getPSAppMenuLogicId() == null;
            }
            case 16: {
                return pSAppMenuLogicBase.getPSAppMenuLogicName() == null;
            }
            case 17: {
                return pSAppMenuLogicBase.getPSAppMenuName() == null;
            }
            case 18: {
                return pSAppMenuLogicBase.getPSDEId() == null;
            }
            case 19: {
                return pSAppMenuLogicBase.getPSDELogicId() == null;
            }
            case 20: {
                return pSAppMenuLogicBase.getPSDELogicName() == null;
            }
            case 21: {
                return pSAppMenuLogicBase.getPSDEName() == null;
            }
            case 22: {
                return pSAppMenuLogicBase.getPSDEUIActionId() == null;
            }
            case 23: {
                return pSAppMenuLogicBase.getPSDEUIActionName() == null;
            }
            case 24: {
                return pSAppMenuLogicBase.getPSSysPFPluginId() == null;
            }
            case 25: {
                return pSAppMenuLogicBase.getPSSysPFPluginName() == null;
            }
            case 26: {
                return pSAppMenuLogicBase.getPSSysViewLogicId() == null;
            }
            case 27: {
                return pSAppMenuLogicBase.getPSSysViewLogicName() == null;
            }
            case 28: {
                return pSAppMenuLogicBase.getPSSysViewPanelId() == null;
            }
            case 29: {
                return pSAppMenuLogicBase.getPSSysViewPanelName() == null;
            }
            case 30: {
                return pSAppMenuLogicBase.getTimer() == null;
            }
            case 31: {
                return pSAppMenuLogicBase.getTriggerType() == null;
            }
            case 32: {
                return pSAppMenuLogicBase.getUpdateDate() == null;
            }
            case 33: {
                return pSAppMenuLogicBase.getUpdateMan() == null;
            }
            case 34: {
                return pSAppMenuLogicBase.getUserCat() == null;
            }
            case 35: {
                return pSAppMenuLogicBase.getUserTag() == null;
            }
            case 36: {
                return pSAppMenuLogicBase.getUserTag2() == null;
            }
            case 37: {
                return pSAppMenuLogicBase.getUserTag3() == null;
            }
            case 38: {
                return pSAppMenuLogicBase.getUserTag4() == null;
            }
            case 39: {
                return pSAppMenuLogicBase.getValidFlag() == null;
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
        return PSAppMenuLogicBase.contains(this, n);
    }

    private static boolean contains(PSAppMenuLogicBase pSAppMenuLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppMenuLogicBase.isAttrNameDirty();
            }
            case 1: {
                return pSAppMenuLogicBase.isCreateDateDirty();
            }
            case 2: {
                return pSAppMenuLogicBase.isCreateManDirty();
            }
            case 3: {
                return pSAppMenuLogicBase.isCustomCodeDirty();
            }
            case 4: {
                return pSAppMenuLogicBase.isDstLogicTypeDirty();
            }
            case 5: {
                return pSAppMenuLogicBase.isEventArgDirty();
            }
            case 6: {
                return pSAppMenuLogicBase.isEventArg2Dirty();
            }
            case 7: {
                return pSAppMenuLogicBase.isEventNamesDirty();
            }
            case 8: {
                return pSAppMenuLogicBase.isLogicParamDirty();
            }
            case 9: {
                return pSAppMenuLogicBase.isLogicParam2Dirty();
            }
            case 10: {
                return pSAppMenuLogicBase.isMemoDirty();
            }
            case 11: {
                return pSAppMenuLogicBase.isOrderValueDirty();
            }
            case 12: {
                return pSAppMenuLogicBase.isPSAppMenuIdDirty();
            }
            case 13: {
                return pSAppMenuLogicBase.isPSAppMenuItemIdDirty();
            }
            case 14: {
                return pSAppMenuLogicBase.isPSAppMenuItemNameDirty();
            }
            case 15: {
                return pSAppMenuLogicBase.isPSAppMenuLogicIdDirty();
            }
            case 16: {
                return pSAppMenuLogicBase.isPSAppMenuLogicNameDirty();
            }
            case 17: {
                return pSAppMenuLogicBase.isPSAppMenuNameDirty();
            }
            case 18: {
                return pSAppMenuLogicBase.isPSDEIdDirty();
            }
            case 19: {
                return pSAppMenuLogicBase.isPSDELogicIdDirty();
            }
            case 20: {
                return pSAppMenuLogicBase.isPSDELogicNameDirty();
            }
            case 21: {
                return pSAppMenuLogicBase.isPSDENameDirty();
            }
            case 22: {
                return pSAppMenuLogicBase.isPSDEUIActionIdDirty();
            }
            case 23: {
                return pSAppMenuLogicBase.isPSDEUIActionNameDirty();
            }
            case 24: {
                return pSAppMenuLogicBase.isPSSysPFPluginIdDirty();
            }
            case 25: {
                return pSAppMenuLogicBase.isPSSysPFPluginNameDirty();
            }
            case 26: {
                return pSAppMenuLogicBase.isPSSysViewLogicIdDirty();
            }
            case 27: {
                return pSAppMenuLogicBase.isPSSysViewLogicNameDirty();
            }
            case 28: {
                return pSAppMenuLogicBase.isPSSysViewPanelIdDirty();
            }
            case 29: {
                return pSAppMenuLogicBase.isPSSysViewPanelNameDirty();
            }
            case 30: {
                return pSAppMenuLogicBase.isTimerDirty();
            }
            case 31: {
                return pSAppMenuLogicBase.isTriggerTypeDirty();
            }
            case 32: {
                return pSAppMenuLogicBase.isUpdateDateDirty();
            }
            case 33: {
                return pSAppMenuLogicBase.isUpdateManDirty();
            }
            case 34: {
                return pSAppMenuLogicBase.isUserCatDirty();
            }
            case 35: {
                return pSAppMenuLogicBase.isUserTagDirty();
            }
            case 36: {
                return pSAppMenuLogicBase.isUserTag2Dirty();
            }
            case 37: {
                return pSAppMenuLogicBase.isUserTag3Dirty();
            }
            case 38: {
                return pSAppMenuLogicBase.isUserTag4Dirty();
            }
            case 39: {
                return pSAppMenuLogicBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSAppMenuLogicBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSAppMenuLogicBase pSAppMenuLogicBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSAppMenuLogicBase.getAttrName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"attrname", (Object)PSAppMenuLogicBase.getJSONValue((Object)pSAppMenuLogicBase.getAttrName()), (boolean)false);
        }
        if (bl || pSAppMenuLogicBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSAppMenuLogicBase.getJSONValue((Object)pSAppMenuLogicBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSAppMenuLogicBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSAppMenuLogicBase.getJSONValue((Object)pSAppMenuLogicBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSAppMenuLogicBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSAppMenuLogicBase.getJSONValue((Object)pSAppMenuLogicBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSAppMenuLogicBase.getDstLogicType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstlogictype", (Object)PSAppMenuLogicBase.getJSONValue((Object)pSAppMenuLogicBase.getDstLogicType()), (boolean)false);
        }
        if (bl || pSAppMenuLogicBase.getEventArg() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eventarg", (Object)PSAppMenuLogicBase.getJSONValue((Object)pSAppMenuLogicBase.getEventArg()), (boolean)false);
        }
        if (bl || pSAppMenuLogicBase.getEventArg2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eventarg2", (Object)PSAppMenuLogicBase.getJSONValue((Object)pSAppMenuLogicBase.getEventArg2()), (boolean)false);
        }
        if (bl || pSAppMenuLogicBase.getEventNames() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eventnames", (Object)PSAppMenuLogicBase.getJSONValue((Object)pSAppMenuLogicBase.getEventNames()), (boolean)false);
        }
        if (bl || pSAppMenuLogicBase.getLogicParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicparam", (Object)PSAppMenuLogicBase.getJSONValue((Object)pSAppMenuLogicBase.getLogicParam()), (boolean)false);
        }
        if (bl || pSAppMenuLogicBase.getLogicParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicparam2", (Object)PSAppMenuLogicBase.getJSONValue((Object)pSAppMenuLogicBase.getLogicParam2()), (boolean)false);
        }
        if (bl || pSAppMenuLogicBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSAppMenuLogicBase.getJSONValue((Object)pSAppMenuLogicBase.getMemo()), (boolean)false);
        }
        if (bl || pSAppMenuLogicBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSAppMenuLogicBase.getJSONValue((Object)pSAppMenuLogicBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSAppMenuLogicBase.getPSAppMenuId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappmenuid", (Object)PSAppMenuLogicBase.getJSONValue((Object)pSAppMenuLogicBase.getPSAppMenuId()), (boolean)false);
        }
        if (bl || pSAppMenuLogicBase.getPSAppMenuItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappmenuitemid", (Object)PSAppMenuLogicBase.getJSONValue((Object)pSAppMenuLogicBase.getPSAppMenuItemId()), (boolean)false);
        }
        if (bl || pSAppMenuLogicBase.getPSAppMenuItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappmenuitemname", (Object)PSAppMenuLogicBase.getJSONValue((Object)pSAppMenuLogicBase.getPSAppMenuItemName()), (boolean)false);
        }
        if (bl || pSAppMenuLogicBase.getPSAppMenuLogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappmenulogicid", (Object)PSAppMenuLogicBase.getJSONValue((Object)pSAppMenuLogicBase.getPSAppMenuLogicId()), (boolean)false);
        }
        if (bl || pSAppMenuLogicBase.getPSAppMenuLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappmenulogicname", (Object)PSAppMenuLogicBase.getJSONValue((Object)pSAppMenuLogicBase.getPSAppMenuLogicName()), (boolean)false);
        }
        if (bl || pSAppMenuLogicBase.getPSAppMenuName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappmenuname", (Object)PSAppMenuLogicBase.getJSONValue((Object)pSAppMenuLogicBase.getPSAppMenuName()), (boolean)false);
        }
        if (bl || pSAppMenuLogicBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSAppMenuLogicBase.getJSONValue((Object)pSAppMenuLogicBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSAppMenuLogicBase.getPSDELogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicid", (Object)PSAppMenuLogicBase.getJSONValue((Object)pSAppMenuLogicBase.getPSDELogicId()), (boolean)false);
        }
        if (bl || pSAppMenuLogicBase.getPSDELogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicname", (Object)PSAppMenuLogicBase.getJSONValue((Object)pSAppMenuLogicBase.getPSDELogicName()), (boolean)false);
        }
        if (bl || pSAppMenuLogicBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSAppMenuLogicBase.getJSONValue((Object)pSAppMenuLogicBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSAppMenuLogicBase.getPSDEUIActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuiactionid", (Object)PSAppMenuLogicBase.getJSONValue((Object)pSAppMenuLogicBase.getPSDEUIActionId()), (boolean)false);
        }
        if (bl || pSAppMenuLogicBase.getPSDEUIActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuiactionname", (Object)PSAppMenuLogicBase.getJSONValue((Object)pSAppMenuLogicBase.getPSDEUIActionName()), (boolean)false);
        }
        if (bl || pSAppMenuLogicBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSAppMenuLogicBase.getJSONValue((Object)pSAppMenuLogicBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSAppMenuLogicBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSAppMenuLogicBase.getJSONValue((Object)pSAppMenuLogicBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSAppMenuLogicBase.getPSSysViewLogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewlogicid", (Object)PSAppMenuLogicBase.getJSONValue((Object)pSAppMenuLogicBase.getPSSysViewLogicId()), (boolean)false);
        }
        if (bl || pSAppMenuLogicBase.getPSSysViewLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewlogicname", (Object)PSAppMenuLogicBase.getJSONValue((Object)pSAppMenuLogicBase.getPSSysViewLogicName()), (boolean)false);
        }
        if (bl || pSAppMenuLogicBase.getPSSysViewPanelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelid", (Object)PSAppMenuLogicBase.getJSONValue((Object)pSAppMenuLogicBase.getPSSysViewPanelId()), (boolean)false);
        }
        if (bl || pSAppMenuLogicBase.getPSSysViewPanelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelname", (Object)PSAppMenuLogicBase.getJSONValue((Object)pSAppMenuLogicBase.getPSSysViewPanelName()), (boolean)false);
        }
        if (bl || pSAppMenuLogicBase.getTimer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"timer", (Object)PSAppMenuLogicBase.getJSONValue((Object)pSAppMenuLogicBase.getTimer()), (boolean)false);
        }
        if (bl || pSAppMenuLogicBase.getTriggerType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"triggertype", (Object)PSAppMenuLogicBase.getJSONValue((Object)pSAppMenuLogicBase.getTriggerType()), (boolean)false);
        }
        if (bl || pSAppMenuLogicBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSAppMenuLogicBase.getJSONValue((Object)pSAppMenuLogicBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSAppMenuLogicBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSAppMenuLogicBase.getJSONValue((Object)pSAppMenuLogicBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSAppMenuLogicBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSAppMenuLogicBase.getJSONValue((Object)pSAppMenuLogicBase.getUserCat()), (boolean)false);
        }
        if (bl || pSAppMenuLogicBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSAppMenuLogicBase.getJSONValue((Object)pSAppMenuLogicBase.getUserTag()), (boolean)false);
        }
        if (bl || pSAppMenuLogicBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSAppMenuLogicBase.getJSONValue((Object)pSAppMenuLogicBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSAppMenuLogicBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSAppMenuLogicBase.getJSONValue((Object)pSAppMenuLogicBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSAppMenuLogicBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSAppMenuLogicBase.getJSONValue((Object)pSAppMenuLogicBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSAppMenuLogicBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSAppMenuLogicBase.getJSONValue((Object)pSAppMenuLogicBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSAppMenuLogicBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSAppMenuLogicBase pSAppMenuLogicBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSAppMenuLogicBase.getAttrName() != null) {
            object = pSAppMenuLogicBase.getAttrName();
            xmlNode.setAttribute(FIELD_ATTRNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuLogicBase.getCreateDate() != null) {
            object = pSAppMenuLogicBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppMenuLogicBase.getCreateMan() != null) {
            object = pSAppMenuLogicBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuLogicBase.getCustomCode() != null) {
            object = pSAppMenuLogicBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuLogicBase.getDstLogicType() != null) {
            object = pSAppMenuLogicBase.getDstLogicType();
            xmlNode.setAttribute(FIELD_DSTLOGICTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuLogicBase.getEventArg() != null) {
            object = pSAppMenuLogicBase.getEventArg();
            xmlNode.setAttribute(FIELD_EVENTARG, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuLogicBase.getEventArg2() != null) {
            object = pSAppMenuLogicBase.getEventArg2();
            xmlNode.setAttribute(FIELD_EVENTARG2, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuLogicBase.getEventNames() != null) {
            object = pSAppMenuLogicBase.getEventNames();
            xmlNode.setAttribute(FIELD_EVENTNAMES, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuLogicBase.getLogicParam() != null) {
            object = pSAppMenuLogicBase.getLogicParam();
            xmlNode.setAttribute(FIELD_LOGICPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuLogicBase.getLogicParam2() != null) {
            object = pSAppMenuLogicBase.getLogicParam2();
            xmlNode.setAttribute(FIELD_LOGICPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuLogicBase.getMemo() != null) {
            object = pSAppMenuLogicBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuLogicBase.getOrderValue() != null) {
            object = pSAppMenuLogicBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppMenuLogicBase.getPSAppMenuId() != null) {
            object = pSAppMenuLogicBase.getPSAppMenuId();
            xmlNode.setAttribute(FIELD_PSAPPMENUID, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuLogicBase.getPSAppMenuItemId() != null) {
            object = pSAppMenuLogicBase.getPSAppMenuItemId();
            xmlNode.setAttribute(FIELD_PSAPPMENUITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuLogicBase.getPSAppMenuItemName() != null) {
            object = pSAppMenuLogicBase.getPSAppMenuItemName();
            xmlNode.setAttribute(FIELD_PSAPPMENUITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuLogicBase.getPSAppMenuLogicId() != null) {
            object = pSAppMenuLogicBase.getPSAppMenuLogicId();
            xmlNode.setAttribute(FIELD_PSAPPMENULOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuLogicBase.getPSAppMenuLogicName() != null) {
            object = pSAppMenuLogicBase.getPSAppMenuLogicName();
            xmlNode.setAttribute(FIELD_PSAPPMENULOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuLogicBase.getPSAppMenuName() != null) {
            object = pSAppMenuLogicBase.getPSAppMenuName();
            xmlNode.setAttribute(FIELD_PSAPPMENUNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuLogicBase.getPSDEId() != null) {
            object = pSAppMenuLogicBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuLogicBase.getPSDELogicId() != null) {
            object = pSAppMenuLogicBase.getPSDELogicId();
            xmlNode.setAttribute(FIELD_PSDELOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuLogicBase.getPSDELogicName() != null) {
            object = pSAppMenuLogicBase.getPSDELogicName();
            xmlNode.setAttribute(FIELD_PSDELOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuLogicBase.getPSDEName() != null) {
            object = pSAppMenuLogicBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuLogicBase.getPSDEUIActionId() != null) {
            object = pSAppMenuLogicBase.getPSDEUIActionId();
            xmlNode.setAttribute(FIELD_PSDEUIACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuLogicBase.getPSDEUIActionName() != null) {
            object = pSAppMenuLogicBase.getPSDEUIActionName();
            xmlNode.setAttribute(FIELD_PSDEUIACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuLogicBase.getPSSysPFPluginId() != null) {
            object = pSAppMenuLogicBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuLogicBase.getPSSysPFPluginName() != null) {
            object = pSAppMenuLogicBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuLogicBase.getPSSysViewLogicId() != null) {
            object = pSAppMenuLogicBase.getPSSysViewLogicId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWLOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuLogicBase.getPSSysViewLogicName() != null) {
            object = pSAppMenuLogicBase.getPSSysViewLogicName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWLOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuLogicBase.getPSSysViewPanelId() != null) {
            object = pSAppMenuLogicBase.getPSSysViewPanelId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELID, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuLogicBase.getPSSysViewPanelName() != null) {
            object = pSAppMenuLogicBase.getPSSysViewPanelName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuLogicBase.getTimer() != null) {
            object = pSAppMenuLogicBase.getTimer();
            xmlNode.setAttribute(FIELD_TIMER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppMenuLogicBase.getTriggerType() != null) {
            object = pSAppMenuLogicBase.getTriggerType();
            xmlNode.setAttribute(FIELD_TRIGGERTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuLogicBase.getUpdateDate() != null) {
            object = pSAppMenuLogicBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppMenuLogicBase.getUpdateMan() != null) {
            object = pSAppMenuLogicBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuLogicBase.getUserCat() != null) {
            object = pSAppMenuLogicBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuLogicBase.getUserTag() != null) {
            object = pSAppMenuLogicBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuLogicBase.getUserTag2() != null) {
            object = pSAppMenuLogicBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuLogicBase.getUserTag3() != null) {
            object = pSAppMenuLogicBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuLogicBase.getUserTag4() != null) {
            object = pSAppMenuLogicBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSAppMenuLogicBase.getValidFlag() != null) {
            object = pSAppMenuLogicBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSAppMenuLogicBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSAppMenuLogicBase pSAppMenuLogicBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSAppMenuLogicBase.isAttrNameDirty() && (bl || pSAppMenuLogicBase.getAttrName() != null)) {
            iDataObject.set(FIELD_ATTRNAME, (Object)pSAppMenuLogicBase.getAttrName());
        }
        if (pSAppMenuLogicBase.isCreateDateDirty() && (bl || pSAppMenuLogicBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSAppMenuLogicBase.getCreateDate());
        }
        if (pSAppMenuLogicBase.isCreateManDirty() && (bl || pSAppMenuLogicBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSAppMenuLogicBase.getCreateMan());
        }
        if (pSAppMenuLogicBase.isCustomCodeDirty() && (bl || pSAppMenuLogicBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSAppMenuLogicBase.getCustomCode());
        }
        if (pSAppMenuLogicBase.isDstLogicTypeDirty() && (bl || pSAppMenuLogicBase.getDstLogicType() != null)) {
            iDataObject.set(FIELD_DSTLOGICTYPE, (Object)pSAppMenuLogicBase.getDstLogicType());
        }
        if (pSAppMenuLogicBase.isEventArgDirty() && (bl || pSAppMenuLogicBase.getEventArg() != null)) {
            iDataObject.set(FIELD_EVENTARG, (Object)pSAppMenuLogicBase.getEventArg());
        }
        if (pSAppMenuLogicBase.isEventArg2Dirty() && (bl || pSAppMenuLogicBase.getEventArg2() != null)) {
            iDataObject.set(FIELD_EVENTARG2, (Object)pSAppMenuLogicBase.getEventArg2());
        }
        if (pSAppMenuLogicBase.isEventNamesDirty() && (bl || pSAppMenuLogicBase.getEventNames() != null)) {
            iDataObject.set(FIELD_EVENTNAMES, (Object)pSAppMenuLogicBase.getEventNames());
        }
        if (pSAppMenuLogicBase.isLogicParamDirty() && (bl || pSAppMenuLogicBase.getLogicParam() != null)) {
            iDataObject.set(FIELD_LOGICPARAM, (Object)pSAppMenuLogicBase.getLogicParam());
        }
        if (pSAppMenuLogicBase.isLogicParam2Dirty() && (bl || pSAppMenuLogicBase.getLogicParam2() != null)) {
            iDataObject.set(FIELD_LOGICPARAM2, (Object)pSAppMenuLogicBase.getLogicParam2());
        }
        if (pSAppMenuLogicBase.isMemoDirty() && (bl || pSAppMenuLogicBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSAppMenuLogicBase.getMemo());
        }
        if (pSAppMenuLogicBase.isOrderValueDirty() && (bl || pSAppMenuLogicBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSAppMenuLogicBase.getOrderValue());
        }
        if (pSAppMenuLogicBase.isPSAppMenuIdDirty() && (bl || pSAppMenuLogicBase.getPSAppMenuId() != null)) {
            iDataObject.set(FIELD_PSAPPMENUID, (Object)pSAppMenuLogicBase.getPSAppMenuId());
        }
        if (pSAppMenuLogicBase.isPSAppMenuItemIdDirty() && (bl || pSAppMenuLogicBase.getPSAppMenuItemId() != null)) {
            iDataObject.set(FIELD_PSAPPMENUITEMID, (Object)pSAppMenuLogicBase.getPSAppMenuItemId());
        }
        if (pSAppMenuLogicBase.isPSAppMenuItemNameDirty() && (bl || pSAppMenuLogicBase.getPSAppMenuItemName() != null)) {
            iDataObject.set(FIELD_PSAPPMENUITEMNAME, (Object)pSAppMenuLogicBase.getPSAppMenuItemName());
        }
        if (pSAppMenuLogicBase.isPSAppMenuLogicIdDirty() && (bl || pSAppMenuLogicBase.getPSAppMenuLogicId() != null)) {
            iDataObject.set(FIELD_PSAPPMENULOGICID, (Object)pSAppMenuLogicBase.getPSAppMenuLogicId());
        }
        if (pSAppMenuLogicBase.isPSAppMenuLogicNameDirty() && (bl || pSAppMenuLogicBase.getPSAppMenuLogicName() != null)) {
            iDataObject.set(FIELD_PSAPPMENULOGICNAME, (Object)pSAppMenuLogicBase.getPSAppMenuLogicName());
        }
        if (pSAppMenuLogicBase.isPSAppMenuNameDirty() && (bl || pSAppMenuLogicBase.getPSAppMenuName() != null)) {
            iDataObject.set(FIELD_PSAPPMENUNAME, (Object)pSAppMenuLogicBase.getPSAppMenuName());
        }
        if (pSAppMenuLogicBase.isPSDEIdDirty() && (bl || pSAppMenuLogicBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSAppMenuLogicBase.getPSDEId());
        }
        if (pSAppMenuLogicBase.isPSDELogicIdDirty() && (bl || pSAppMenuLogicBase.getPSDELogicId() != null)) {
            iDataObject.set(FIELD_PSDELOGICID, (Object)pSAppMenuLogicBase.getPSDELogicId());
        }
        if (pSAppMenuLogicBase.isPSDELogicNameDirty() && (bl || pSAppMenuLogicBase.getPSDELogicName() != null)) {
            iDataObject.set(FIELD_PSDELOGICNAME, (Object)pSAppMenuLogicBase.getPSDELogicName());
        }
        if (pSAppMenuLogicBase.isPSDENameDirty() && (bl || pSAppMenuLogicBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSAppMenuLogicBase.getPSDEName());
        }
        if (pSAppMenuLogicBase.isPSDEUIActionIdDirty() && (bl || pSAppMenuLogicBase.getPSDEUIActionId() != null)) {
            iDataObject.set(FIELD_PSDEUIACTIONID, (Object)pSAppMenuLogicBase.getPSDEUIActionId());
        }
        if (pSAppMenuLogicBase.isPSDEUIActionNameDirty() && (bl || pSAppMenuLogicBase.getPSDEUIActionName() != null)) {
            iDataObject.set(FIELD_PSDEUIACTIONNAME, (Object)pSAppMenuLogicBase.getPSDEUIActionName());
        }
        if (pSAppMenuLogicBase.isPSSysPFPluginIdDirty() && (bl || pSAppMenuLogicBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSAppMenuLogicBase.getPSSysPFPluginId());
        }
        if (pSAppMenuLogicBase.isPSSysPFPluginNameDirty() && (bl || pSAppMenuLogicBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSAppMenuLogicBase.getPSSysPFPluginName());
        }
        if (pSAppMenuLogicBase.isPSSysViewLogicIdDirty() && (bl || pSAppMenuLogicBase.getPSSysViewLogicId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWLOGICID, (Object)pSAppMenuLogicBase.getPSSysViewLogicId());
        }
        if (pSAppMenuLogicBase.isPSSysViewLogicNameDirty() && (bl || pSAppMenuLogicBase.getPSSysViewLogicName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWLOGICNAME, (Object)pSAppMenuLogicBase.getPSSysViewLogicName());
        }
        if (pSAppMenuLogicBase.isPSSysViewPanelIdDirty() && (bl || pSAppMenuLogicBase.getPSSysViewPanelId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELID, (Object)pSAppMenuLogicBase.getPSSysViewPanelId());
        }
        if (pSAppMenuLogicBase.isPSSysViewPanelNameDirty() && (bl || pSAppMenuLogicBase.getPSSysViewPanelName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELNAME, (Object)pSAppMenuLogicBase.getPSSysViewPanelName());
        }
        if (pSAppMenuLogicBase.isTimerDirty() && (bl || pSAppMenuLogicBase.getTimer() != null)) {
            iDataObject.set(FIELD_TIMER, (Object)pSAppMenuLogicBase.getTimer());
        }
        if (pSAppMenuLogicBase.isTriggerTypeDirty() && (bl || pSAppMenuLogicBase.getTriggerType() != null)) {
            iDataObject.set(FIELD_TRIGGERTYPE, (Object)pSAppMenuLogicBase.getTriggerType());
        }
        if (pSAppMenuLogicBase.isUpdateDateDirty() && (bl || pSAppMenuLogicBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSAppMenuLogicBase.getUpdateDate());
        }
        if (pSAppMenuLogicBase.isUpdateManDirty() && (bl || pSAppMenuLogicBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSAppMenuLogicBase.getUpdateMan());
        }
        if (pSAppMenuLogicBase.isUserCatDirty() && (bl || pSAppMenuLogicBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSAppMenuLogicBase.getUserCat());
        }
        if (pSAppMenuLogicBase.isUserTagDirty() && (bl || pSAppMenuLogicBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSAppMenuLogicBase.getUserTag());
        }
        if (pSAppMenuLogicBase.isUserTag2Dirty() && (bl || pSAppMenuLogicBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSAppMenuLogicBase.getUserTag2());
        }
        if (pSAppMenuLogicBase.isUserTag3Dirty() && (bl || pSAppMenuLogicBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSAppMenuLogicBase.getUserTag3());
        }
        if (pSAppMenuLogicBase.isUserTag4Dirty() && (bl || pSAppMenuLogicBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSAppMenuLogicBase.getUserTag4());
        }
        if (pSAppMenuLogicBase.isValidFlagDirty() && (bl || pSAppMenuLogicBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSAppMenuLogicBase.getValidFlag());
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
        return PSAppMenuLogicBase.remove(this, n);
    }

    private static boolean remove(PSAppMenuLogicBase pSAppMenuLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSAppMenuLogicBase.resetAttrName();
                return true;
            }
            case 1: {
                pSAppMenuLogicBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSAppMenuLogicBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSAppMenuLogicBase.resetCustomCode();
                return true;
            }
            case 4: {
                pSAppMenuLogicBase.resetDstLogicType();
                return true;
            }
            case 5: {
                pSAppMenuLogicBase.resetEventArg();
                return true;
            }
            case 6: {
                pSAppMenuLogicBase.resetEventArg2();
                return true;
            }
            case 7: {
                pSAppMenuLogicBase.resetEventNames();
                return true;
            }
            case 8: {
                pSAppMenuLogicBase.resetLogicParam();
                return true;
            }
            case 9: {
                pSAppMenuLogicBase.resetLogicParam2();
                return true;
            }
            case 10: {
                pSAppMenuLogicBase.resetMemo();
                return true;
            }
            case 11: {
                pSAppMenuLogicBase.resetOrderValue();
                return true;
            }
            case 12: {
                pSAppMenuLogicBase.resetPSAppMenuId();
                return true;
            }
            case 13: {
                pSAppMenuLogicBase.resetPSAppMenuItemId();
                return true;
            }
            case 14: {
                pSAppMenuLogicBase.resetPSAppMenuItemName();
                return true;
            }
            case 15: {
                pSAppMenuLogicBase.resetPSAppMenuLogicId();
                return true;
            }
            case 16: {
                pSAppMenuLogicBase.resetPSAppMenuLogicName();
                return true;
            }
            case 17: {
                pSAppMenuLogicBase.resetPSAppMenuName();
                return true;
            }
            case 18: {
                pSAppMenuLogicBase.resetPSDEId();
                return true;
            }
            case 19: {
                pSAppMenuLogicBase.resetPSDELogicId();
                return true;
            }
            case 20: {
                pSAppMenuLogicBase.resetPSDELogicName();
                return true;
            }
            case 21: {
                pSAppMenuLogicBase.resetPSDEName();
                return true;
            }
            case 22: {
                pSAppMenuLogicBase.resetPSDEUIActionId();
                return true;
            }
            case 23: {
                pSAppMenuLogicBase.resetPSDEUIActionName();
                return true;
            }
            case 24: {
                pSAppMenuLogicBase.resetPSSysPFPluginId();
                return true;
            }
            case 25: {
                pSAppMenuLogicBase.resetPSSysPFPluginName();
                return true;
            }
            case 26: {
                pSAppMenuLogicBase.resetPSSysViewLogicId();
                return true;
            }
            case 27: {
                pSAppMenuLogicBase.resetPSSysViewLogicName();
                return true;
            }
            case 28: {
                pSAppMenuLogicBase.resetPSSysViewPanelId();
                return true;
            }
            case 29: {
                pSAppMenuLogicBase.resetPSSysViewPanelName();
                return true;
            }
            case 30: {
                pSAppMenuLogicBase.resetTimer();
                return true;
            }
            case 31: {
                pSAppMenuLogicBase.resetTriggerType();
                return true;
            }
            case 32: {
                pSAppMenuLogicBase.resetUpdateDate();
                return true;
            }
            case 33: {
                pSAppMenuLogicBase.resetUpdateMan();
                return true;
            }
            case 34: {
                pSAppMenuLogicBase.resetUserCat();
                return true;
            }
            case 35: {
                pSAppMenuLogicBase.resetUserTag();
                return true;
            }
            case 36: {
                pSAppMenuLogicBase.resetUserTag2();
                return true;
            }
            case 37: {
                pSAppMenuLogicBase.resetUserTag3();
                return true;
            }
            case 38: {
                pSAppMenuLogicBase.resetUserTag4();
                return true;
            }
            case 39: {
                pSAppMenuLogicBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSAppMenuItem getPSAppMenuItem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppMenuItem();
        }
        if (this.getPSAppMenuItemId() == null) {
            return null;
        }
        Integer n = this.objPSAppMenuItemLock;
        synchronized (n) {
            if (this.psappmenuitem != null && DataTypeHelper.compare((int)25, (Object)this.getPSAppMenuItemId(), (Object)this.psappmenuitem.getPSAppMenuItemId()) != 0L) {
                this.psappmenuitem = null;
            }
            if (this.psappmenuitem == null) {
                PSAppMenuItem pSAppMenuItem = new PSAppMenuItem();
                pSAppMenuItem.setPSAppMenuItemId(this.getPSAppMenuItemId());
                PSAppMenuItemService pSAppMenuItemService = (PSAppMenuItemService)ServiceGlobal.getService(PSAppMenuItemService.class, (SessionFactory)this.getSessionFactory());
                pSAppMenuItemService.autoGet(pSAppMenuItem);
                this.psappmenuitem = pSAppMenuItem;
            }
            return this.psappmenuitem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSAppMenu getPSAppMenu() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppMenu();
        }
        if (this.getPSAppMenuId() == null) {
            return null;
        }
        Integer n = this.objPSAppMenuLock;
        synchronized (n) {
            if (this.psappmenu != null && DataTypeHelper.compare((int)25, (Object)this.getPSAppMenuId(), (Object)this.psappmenu.getPSAppMenuId()) != 0L) {
                this.psappmenu = null;
            }
            if (this.psappmenu == null) {
                PSAppMenu pSAppMenu = new PSAppMenu();
                pSAppMenu.setPSAppMenuId(this.getPSAppMenuId());
                PSAppMenuService pSAppMenuService = (PSAppMenuService)ServiceGlobal.getService(PSAppMenuService.class, (SessionFactory)this.getSessionFactory());
                pSAppMenuService.autoGet(pSAppMenu);
                this.psappmenu = pSAppMenu;
            }
            return this.psappmenu;
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
                pSDELogicService.autoGet(pSDELogic);
                this.psdelogic = pSDELogic;
            }
            return this.psdelogic;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEUIAction getPSDEUIAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUIAction();
        }
        if (this.getPSDEUIActionId() == null) {
            return null;
        }
        Integer n = this.objPSDEUIActionLock;
        synchronized (n) {
            if (this.psdeuiaction != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEUIActionId(), (Object)this.psdeuiaction.getPSDEUIActionId()) != 0L) {
                this.psdeuiaction = null;
            }
            if (this.psdeuiaction == null) {
                PSDEUIAction pSDEUIAction = new PSDEUIAction();
                pSDEUIAction.setPSDEUIActionId(this.getPSDEUIActionId());
                PSDEUIActionService pSDEUIActionService = (PSDEUIActionService)ServiceGlobal.getService(PSDEUIActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEUIActionService.autoGet(pSDEUIAction);
                this.psdeuiaction = pSDEUIAction;
            }
            return this.psdeuiaction;
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
    public PSSysViewLogic getPSSysViewLogic() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewLogic();
        }
        if (this.getPSSysViewLogicId() == null) {
            return null;
        }
        Integer n = this.objPSSysViewLogicLock;
        synchronized (n) {
            if (this.pssysviewlogic != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysViewLogicId(), (Object)this.pssysviewlogic.getPSSysViewLogicId()) != 0L) {
                this.pssysviewlogic = null;
            }
            if (this.pssysviewlogic == null) {
                PSSysViewLogic pSSysViewLogic = new PSSysViewLogic();
                pSSysViewLogic.setPSSysViewLogicId(this.getPSSysViewLogicId());
                PSSysViewLogicService pSSysViewLogicService = (PSSysViewLogicService)ServiceGlobal.getService(PSSysViewLogicService.class, (SessionFactory)this.getSessionFactory());
                pSSysViewLogicService.autoGet(pSSysViewLogic);
                this.pssysviewlogic = pSSysViewLogic;
            }
            return this.pssysviewlogic;
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
                pSSysViewPanelService.autoGet(pSSysViewPanel);
                this.pssysviewpanel = pSSysViewPanel;
            }
            return this.pssysviewpanel;
        }
    }

    private PSAppMenuLogicBase getProxyEntity() {
        return this.proxyPSAppMenuLogicBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSAppMenuLogicBase = null;
        if (iDataObject != null && iDataObject instanceof PSAppMenuLogicBase) {
            this.proxyPSAppMenuLogicBase = (PSAppMenuLogicBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppMenuLogicService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ATTRNAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_CUSTOMCODE, 3);
        fieldIndexMap.put(FIELD_DSTLOGICTYPE, 4);
        fieldIndexMap.put(FIELD_EVENTARG, 5);
        fieldIndexMap.put(FIELD_EVENTARG2, 6);
        fieldIndexMap.put(FIELD_EVENTNAMES, 7);
        fieldIndexMap.put(FIELD_LOGICPARAM, 8);
        fieldIndexMap.put(FIELD_LOGICPARAM2, 9);
        fieldIndexMap.put(FIELD_MEMO, 10);
        fieldIndexMap.put(FIELD_ORDERVALUE, 11);
        fieldIndexMap.put(FIELD_PSAPPMENUID, 12);
        fieldIndexMap.put(FIELD_PSAPPMENUITEMID, 13);
        fieldIndexMap.put(FIELD_PSAPPMENUITEMNAME, 14);
        fieldIndexMap.put(FIELD_PSAPPMENULOGICID, 15);
        fieldIndexMap.put(FIELD_PSAPPMENULOGICNAME, 16);
        fieldIndexMap.put(FIELD_PSAPPMENUNAME, 17);
        fieldIndexMap.put(FIELD_PSDEID, 18);
        fieldIndexMap.put(FIELD_PSDELOGICID, 19);
        fieldIndexMap.put(FIELD_PSDELOGICNAME, 20);
        fieldIndexMap.put(FIELD_PSDENAME, 21);
        fieldIndexMap.put(FIELD_PSDEUIACTIONID, 22);
        fieldIndexMap.put(FIELD_PSDEUIACTIONNAME, 23);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINID, 24);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINNAME, 25);
        fieldIndexMap.put(FIELD_PSSYSVIEWLOGICID, 26);
        fieldIndexMap.put(FIELD_PSSYSVIEWLOGICNAME, 27);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELID, 28);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELNAME, 29);
        fieldIndexMap.put(FIELD_TIMER, 30);
        fieldIndexMap.put(FIELD_TRIGGERTYPE, 31);
        fieldIndexMap.put(FIELD_UPDATEDATE, 32);
        fieldIndexMap.put(FIELD_UPDATEMAN, 33);
        fieldIndexMap.put(FIELD_USERCAT, 34);
        fieldIndexMap.put(FIELD_USERTAG, 35);
        fieldIndexMap.put(FIELD_USERTAG2, 36);
        fieldIndexMap.put(FIELD_USERTAG3, 37);
        fieldIndexMap.put(FIELD_USERTAG4, 38);
        fieldIndexMap.put(FIELD_VALIDFLAG, 39);
    }
}

