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
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETBItem;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEToolbar;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETBItemService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarService;
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

public abstract class PSDEToolbarLogicBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEToolbarLogicBase.class);
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
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDELOGICID = "PSDELOGICID";
    public static final String FIELD_PSDELOGICNAME = "PSDELOGICNAME";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDETBITEMID = "PSDETBITEMID";
    public static final String FIELD_PSDETBITEMNAME = "PSDETBITEMNAME";
    public static final String FIELD_PSDETOOLBARID = "PSDETOOLBARID";
    public static final String FIELD_PSDETOOLBARLOGICID = "PSDETOOLBARLOGICID";
    public static final String FIELD_PSDETOOLBARLOGICNAME = "PSDETOOLBARLOGICNAME";
    public static final String FIELD_PSDETOOLBARNAME = "PSDETOOLBARNAME";
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
    private static final int INDEX_PSDEID = 12;
    private static final int INDEX_PSDELOGICID = 13;
    private static final int INDEX_PSDELOGICNAME = 14;
    private static final int INDEX_PSDENAME = 15;
    private static final int INDEX_PSDETBITEMID = 16;
    private static final int INDEX_PSDETBITEMNAME = 17;
    private static final int INDEX_PSDETOOLBARID = 18;
    private static final int INDEX_PSDETOOLBARLOGICID = 19;
    private static final int INDEX_PSDETOOLBARLOGICNAME = 20;
    private static final int INDEX_PSDETOOLBARNAME = 21;
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
    private PSDEToolbarLogicBase proxyPSDEToolbarLogicBase = null;
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
    private boolean psdeidDirtyFlag = false;
    private boolean psdelogicidDirtyFlag = false;
    private boolean psdelogicnameDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psdetbitemidDirtyFlag = false;
    private boolean psdetbitemnameDirtyFlag = false;
    private boolean psdetoolbaridDirtyFlag = false;
    private boolean psdetoolbarlogicidDirtyFlag = false;
    private boolean psdetoolbarlogicnameDirtyFlag = false;
    private boolean psdetoolbarnameDirtyFlag = false;
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
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdelogicid")
    private String psdelogicid;
    @Column(name="psdelogicname")
    private String psdelogicname;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psdetbitemid")
    private String psdetbitemid;
    @Column(name="psdetbitemname")
    private String psdetbitemname;
    @Column(name="psdetoolbarid")
    private String psdetoolbarid;
    @Column(name="psdetoolbarlogicid")
    private String psdetoolbarlogicid;
    @Column(name="psdetoolbarlogicname")
    private String psdetoolbarlogicname;
    @Column(name="psdetoolbarname")
    private String psdetoolbarname;
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
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objPSDELogicLock = new Integer(1);
    private PSDELogic psdelogic = null;
    private Integer objPSDETBItemLock = new Integer(1);
    private PSDETBItem psdetbitem = null;
    private Integer objPSDEToolbarLock = new Integer(1);
    private PSDEToolbar psdetoolbar = null;
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

    public void setPSDETBItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDETBItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdetbitemid = string;
        this.psdetbitemidDirtyFlag = true;
    }

    public String getPSDETBItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETBItemId();
        }
        return this.psdetbitemid;
    }

    public boolean isPSDETBItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDETBItemIdDirty();
        }
        return this.psdetbitemidDirtyFlag;
    }

    public void resetPSDETBItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDETBItemId();
            return;
        }
        this.psdetbitemidDirtyFlag = false;
        this.psdetbitemid = null;
    }

    public void setPSDETBItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDETBItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdetbitemname = string;
        this.psdetbitemnameDirtyFlag = true;
    }

    public String getPSDETBItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETBItemName();
        }
        return this.psdetbitemname;
    }

    public boolean isPSDETBItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDETBItemNameDirty();
        }
        return this.psdetbitemnameDirtyFlag;
    }

    public void resetPSDETBItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDETBItemName();
            return;
        }
        this.psdetbitemnameDirtyFlag = false;
        this.psdetbitemname = null;
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

    public void setPSDEToolbarLogicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEToolbarLogicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdetoolbarlogicid = string;
        this.psdetoolbarlogicidDirtyFlag = true;
    }

    public String getPSDEToolbarLogicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEToolbarLogicId();
        }
        return this.psdetoolbarlogicid;
    }

    public boolean isPSDEToolbarLogicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEToolbarLogicIdDirty();
        }
        return this.psdetoolbarlogicidDirtyFlag;
    }

    public void resetPSDEToolbarLogicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEToolbarLogicId();
            return;
        }
        this.psdetoolbarlogicidDirtyFlag = false;
        this.psdetoolbarlogicid = null;
    }

    public void setPSDEToolbarLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEToolbarLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdetoolbarlogicname = string;
        this.psdetoolbarlogicnameDirtyFlag = true;
    }

    public String getPSDEToolbarLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEToolbarLogicName();
        }
        return this.psdetoolbarlogicname;
    }

    public boolean isPSDEToolbarLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEToolbarLogicNameDirty();
        }
        return this.psdetoolbarlogicnameDirtyFlag;
    }

    public void resetPSDEToolbarLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEToolbarLogicName();
            return;
        }
        this.psdetoolbarlogicnameDirtyFlag = false;
        this.psdetoolbarlogicname = null;
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
        PSDEToolbarLogicBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEToolbarLogicBase pSDEToolbarLogicBase) {
        pSDEToolbarLogicBase.resetAttrName();
        pSDEToolbarLogicBase.resetCreateDate();
        pSDEToolbarLogicBase.resetCreateMan();
        pSDEToolbarLogicBase.resetCustomCode();
        pSDEToolbarLogicBase.resetDstLogicType();
        pSDEToolbarLogicBase.resetEventArg();
        pSDEToolbarLogicBase.resetEventArg2();
        pSDEToolbarLogicBase.resetEventNames();
        pSDEToolbarLogicBase.resetLogicParam();
        pSDEToolbarLogicBase.resetLogicParam2();
        pSDEToolbarLogicBase.resetMemo();
        pSDEToolbarLogicBase.resetOrderValue();
        pSDEToolbarLogicBase.resetPSDEId();
        pSDEToolbarLogicBase.resetPSDELogicId();
        pSDEToolbarLogicBase.resetPSDELogicName();
        pSDEToolbarLogicBase.resetPSDEName();
        pSDEToolbarLogicBase.resetPSDETBItemId();
        pSDEToolbarLogicBase.resetPSDETBItemName();
        pSDEToolbarLogicBase.resetPSDEToolbarId();
        pSDEToolbarLogicBase.resetPSDEToolbarLogicId();
        pSDEToolbarLogicBase.resetPSDEToolbarLogicName();
        pSDEToolbarLogicBase.resetPSDEToolbarName();
        pSDEToolbarLogicBase.resetPSDEUIActionId();
        pSDEToolbarLogicBase.resetPSDEUIActionName();
        pSDEToolbarLogicBase.resetPSSysPFPluginId();
        pSDEToolbarLogicBase.resetPSSysPFPluginName();
        pSDEToolbarLogicBase.resetPSSysViewLogicId();
        pSDEToolbarLogicBase.resetPSSysViewLogicName();
        pSDEToolbarLogicBase.resetPSSysViewPanelId();
        pSDEToolbarLogicBase.resetPSSysViewPanelName();
        pSDEToolbarLogicBase.resetTimer();
        pSDEToolbarLogicBase.resetTriggerType();
        pSDEToolbarLogicBase.resetUpdateDate();
        pSDEToolbarLogicBase.resetUpdateMan();
        pSDEToolbarLogicBase.resetUserCat();
        pSDEToolbarLogicBase.resetUserTag();
        pSDEToolbarLogicBase.resetUserTag2();
        pSDEToolbarLogicBase.resetUserTag3();
        pSDEToolbarLogicBase.resetUserTag4();
        pSDEToolbarLogicBase.resetValidFlag();
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
        if (!bl || this.isPSDETBItemIdDirty()) {
            hashMap.put(FIELD_PSDETBITEMID, this.getPSDETBItemId());
        }
        if (!bl || this.isPSDETBItemNameDirty()) {
            hashMap.put(FIELD_PSDETBITEMNAME, this.getPSDETBItemName());
        }
        if (!bl || this.isPSDEToolbarIdDirty()) {
            hashMap.put(FIELD_PSDETOOLBARID, this.getPSDEToolbarId());
        }
        if (!bl || this.isPSDEToolbarLogicIdDirty()) {
            hashMap.put(FIELD_PSDETOOLBARLOGICID, this.getPSDEToolbarLogicId());
        }
        if (!bl || this.isPSDEToolbarLogicNameDirty()) {
            hashMap.put(FIELD_PSDETOOLBARLOGICNAME, this.getPSDEToolbarLogicName());
        }
        if (!bl || this.isPSDEToolbarNameDirty()) {
            hashMap.put(FIELD_PSDETOOLBARNAME, this.getPSDEToolbarName());
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
        return PSDEToolbarLogicBase.get(this, n);
    }

    private static Object get(PSDEToolbarLogicBase pSDEToolbarLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEToolbarLogicBase.getAttrName();
            }
            case 1: {
                return pSDEToolbarLogicBase.getCreateDate();
            }
            case 2: {
                return pSDEToolbarLogicBase.getCreateMan();
            }
            case 3: {
                return pSDEToolbarLogicBase.getCustomCode();
            }
            case 4: {
                return pSDEToolbarLogicBase.getDstLogicType();
            }
            case 5: {
                return pSDEToolbarLogicBase.getEventArg();
            }
            case 6: {
                return pSDEToolbarLogicBase.getEventArg2();
            }
            case 7: {
                return pSDEToolbarLogicBase.getEventNames();
            }
            case 8: {
                return pSDEToolbarLogicBase.getLogicParam();
            }
            case 9: {
                return pSDEToolbarLogicBase.getLogicParam2();
            }
            case 10: {
                return pSDEToolbarLogicBase.getMemo();
            }
            case 11: {
                return pSDEToolbarLogicBase.getOrderValue();
            }
            case 12: {
                return pSDEToolbarLogicBase.getPSDEId();
            }
            case 13: {
                return pSDEToolbarLogicBase.getPSDELogicId();
            }
            case 14: {
                return pSDEToolbarLogicBase.getPSDELogicName();
            }
            case 15: {
                return pSDEToolbarLogicBase.getPSDEName();
            }
            case 16: {
                return pSDEToolbarLogicBase.getPSDETBItemId();
            }
            case 17: {
                return pSDEToolbarLogicBase.getPSDETBItemName();
            }
            case 18: {
                return pSDEToolbarLogicBase.getPSDEToolbarId();
            }
            case 19: {
                return pSDEToolbarLogicBase.getPSDEToolbarLogicId();
            }
            case 20: {
                return pSDEToolbarLogicBase.getPSDEToolbarLogicName();
            }
            case 21: {
                return pSDEToolbarLogicBase.getPSDEToolbarName();
            }
            case 22: {
                return pSDEToolbarLogicBase.getPSDEUIActionId();
            }
            case 23: {
                return pSDEToolbarLogicBase.getPSDEUIActionName();
            }
            case 24: {
                return pSDEToolbarLogicBase.getPSSysPFPluginId();
            }
            case 25: {
                return pSDEToolbarLogicBase.getPSSysPFPluginName();
            }
            case 26: {
                return pSDEToolbarLogicBase.getPSSysViewLogicId();
            }
            case 27: {
                return pSDEToolbarLogicBase.getPSSysViewLogicName();
            }
            case 28: {
                return pSDEToolbarLogicBase.getPSSysViewPanelId();
            }
            case 29: {
                return pSDEToolbarLogicBase.getPSSysViewPanelName();
            }
            case 30: {
                return pSDEToolbarLogicBase.getTimer();
            }
            case 31: {
                return pSDEToolbarLogicBase.getTriggerType();
            }
            case 32: {
                return pSDEToolbarLogicBase.getUpdateDate();
            }
            case 33: {
                return pSDEToolbarLogicBase.getUpdateMan();
            }
            case 34: {
                return pSDEToolbarLogicBase.getUserCat();
            }
            case 35: {
                return pSDEToolbarLogicBase.getUserTag();
            }
            case 36: {
                return pSDEToolbarLogicBase.getUserTag2();
            }
            case 37: {
                return pSDEToolbarLogicBase.getUserTag3();
            }
            case 38: {
                return pSDEToolbarLogicBase.getUserTag4();
            }
            case 39: {
                return pSDEToolbarLogicBase.getValidFlag();
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
        PSDEToolbarLogicBase.set(this, n, object);
    }

    private static void set(PSDEToolbarLogicBase pSDEToolbarLogicBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEToolbarLogicBase.setAttrName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDEToolbarLogicBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDEToolbarLogicBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEToolbarLogicBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEToolbarLogicBase.setDstLogicType(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEToolbarLogicBase.setEventArg(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEToolbarLogicBase.setEventArg2(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEToolbarLogicBase.setEventNames(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEToolbarLogicBase.setLogicParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEToolbarLogicBase.setLogicParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEToolbarLogicBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEToolbarLogicBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSDEToolbarLogicBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEToolbarLogicBase.setPSDELogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEToolbarLogicBase.setPSDELogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEToolbarLogicBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEToolbarLogicBase.setPSDETBItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEToolbarLogicBase.setPSDETBItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEToolbarLogicBase.setPSDEToolbarId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEToolbarLogicBase.setPSDEToolbarLogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDEToolbarLogicBase.setPSDEToolbarLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEToolbarLogicBase.setPSDEToolbarName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDEToolbarLogicBase.setPSDEUIActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDEToolbarLogicBase.setPSDEUIActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDEToolbarLogicBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDEToolbarLogicBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDEToolbarLogicBase.setPSSysViewLogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDEToolbarLogicBase.setPSSysViewLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDEToolbarLogicBase.setPSSysViewPanelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDEToolbarLogicBase.setPSSysViewPanelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDEToolbarLogicBase.setTimer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 31: {
                pSDEToolbarLogicBase.setTriggerType(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDEToolbarLogicBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 33: {
                pSDEToolbarLogicBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDEToolbarLogicBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDEToolbarLogicBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDEToolbarLogicBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSDEToolbarLogicBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDEToolbarLogicBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSDEToolbarLogicBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDEToolbarLogicBase.isNull(this, n);
    }

    private static boolean isNull(PSDEToolbarLogicBase pSDEToolbarLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEToolbarLogicBase.getAttrName() == null;
            }
            case 1: {
                return pSDEToolbarLogicBase.getCreateDate() == null;
            }
            case 2: {
                return pSDEToolbarLogicBase.getCreateMan() == null;
            }
            case 3: {
                return pSDEToolbarLogicBase.getCustomCode() == null;
            }
            case 4: {
                return pSDEToolbarLogicBase.getDstLogicType() == null;
            }
            case 5: {
                return pSDEToolbarLogicBase.getEventArg() == null;
            }
            case 6: {
                return pSDEToolbarLogicBase.getEventArg2() == null;
            }
            case 7: {
                return pSDEToolbarLogicBase.getEventNames() == null;
            }
            case 8: {
                return pSDEToolbarLogicBase.getLogicParam() == null;
            }
            case 9: {
                return pSDEToolbarLogicBase.getLogicParam2() == null;
            }
            case 10: {
                return pSDEToolbarLogicBase.getMemo() == null;
            }
            case 11: {
                return pSDEToolbarLogicBase.getOrderValue() == null;
            }
            case 12: {
                return pSDEToolbarLogicBase.getPSDEId() == null;
            }
            case 13: {
                return pSDEToolbarLogicBase.getPSDELogicId() == null;
            }
            case 14: {
                return pSDEToolbarLogicBase.getPSDELogicName() == null;
            }
            case 15: {
                return pSDEToolbarLogicBase.getPSDEName() == null;
            }
            case 16: {
                return pSDEToolbarLogicBase.getPSDETBItemId() == null;
            }
            case 17: {
                return pSDEToolbarLogicBase.getPSDETBItemName() == null;
            }
            case 18: {
                return pSDEToolbarLogicBase.getPSDEToolbarId() == null;
            }
            case 19: {
                return pSDEToolbarLogicBase.getPSDEToolbarLogicId() == null;
            }
            case 20: {
                return pSDEToolbarLogicBase.getPSDEToolbarLogicName() == null;
            }
            case 21: {
                return pSDEToolbarLogicBase.getPSDEToolbarName() == null;
            }
            case 22: {
                return pSDEToolbarLogicBase.getPSDEUIActionId() == null;
            }
            case 23: {
                return pSDEToolbarLogicBase.getPSDEUIActionName() == null;
            }
            case 24: {
                return pSDEToolbarLogicBase.getPSSysPFPluginId() == null;
            }
            case 25: {
                return pSDEToolbarLogicBase.getPSSysPFPluginName() == null;
            }
            case 26: {
                return pSDEToolbarLogicBase.getPSSysViewLogicId() == null;
            }
            case 27: {
                return pSDEToolbarLogicBase.getPSSysViewLogicName() == null;
            }
            case 28: {
                return pSDEToolbarLogicBase.getPSSysViewPanelId() == null;
            }
            case 29: {
                return pSDEToolbarLogicBase.getPSSysViewPanelName() == null;
            }
            case 30: {
                return pSDEToolbarLogicBase.getTimer() == null;
            }
            case 31: {
                return pSDEToolbarLogicBase.getTriggerType() == null;
            }
            case 32: {
                return pSDEToolbarLogicBase.getUpdateDate() == null;
            }
            case 33: {
                return pSDEToolbarLogicBase.getUpdateMan() == null;
            }
            case 34: {
                return pSDEToolbarLogicBase.getUserCat() == null;
            }
            case 35: {
                return pSDEToolbarLogicBase.getUserTag() == null;
            }
            case 36: {
                return pSDEToolbarLogicBase.getUserTag2() == null;
            }
            case 37: {
                return pSDEToolbarLogicBase.getUserTag3() == null;
            }
            case 38: {
                return pSDEToolbarLogicBase.getUserTag4() == null;
            }
            case 39: {
                return pSDEToolbarLogicBase.getValidFlag() == null;
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
        return PSDEToolbarLogicBase.contains(this, n);
    }

    private static boolean contains(PSDEToolbarLogicBase pSDEToolbarLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEToolbarLogicBase.isAttrNameDirty();
            }
            case 1: {
                return pSDEToolbarLogicBase.isCreateDateDirty();
            }
            case 2: {
                return pSDEToolbarLogicBase.isCreateManDirty();
            }
            case 3: {
                return pSDEToolbarLogicBase.isCustomCodeDirty();
            }
            case 4: {
                return pSDEToolbarLogicBase.isDstLogicTypeDirty();
            }
            case 5: {
                return pSDEToolbarLogicBase.isEventArgDirty();
            }
            case 6: {
                return pSDEToolbarLogicBase.isEventArg2Dirty();
            }
            case 7: {
                return pSDEToolbarLogicBase.isEventNamesDirty();
            }
            case 8: {
                return pSDEToolbarLogicBase.isLogicParamDirty();
            }
            case 9: {
                return pSDEToolbarLogicBase.isLogicParam2Dirty();
            }
            case 10: {
                return pSDEToolbarLogicBase.isMemoDirty();
            }
            case 11: {
                return pSDEToolbarLogicBase.isOrderValueDirty();
            }
            case 12: {
                return pSDEToolbarLogicBase.isPSDEIdDirty();
            }
            case 13: {
                return pSDEToolbarLogicBase.isPSDELogicIdDirty();
            }
            case 14: {
                return pSDEToolbarLogicBase.isPSDELogicNameDirty();
            }
            case 15: {
                return pSDEToolbarLogicBase.isPSDENameDirty();
            }
            case 16: {
                return pSDEToolbarLogicBase.isPSDETBItemIdDirty();
            }
            case 17: {
                return pSDEToolbarLogicBase.isPSDETBItemNameDirty();
            }
            case 18: {
                return pSDEToolbarLogicBase.isPSDEToolbarIdDirty();
            }
            case 19: {
                return pSDEToolbarLogicBase.isPSDEToolbarLogicIdDirty();
            }
            case 20: {
                return pSDEToolbarLogicBase.isPSDEToolbarLogicNameDirty();
            }
            case 21: {
                return pSDEToolbarLogicBase.isPSDEToolbarNameDirty();
            }
            case 22: {
                return pSDEToolbarLogicBase.isPSDEUIActionIdDirty();
            }
            case 23: {
                return pSDEToolbarLogicBase.isPSDEUIActionNameDirty();
            }
            case 24: {
                return pSDEToolbarLogicBase.isPSSysPFPluginIdDirty();
            }
            case 25: {
                return pSDEToolbarLogicBase.isPSSysPFPluginNameDirty();
            }
            case 26: {
                return pSDEToolbarLogicBase.isPSSysViewLogicIdDirty();
            }
            case 27: {
                return pSDEToolbarLogicBase.isPSSysViewLogicNameDirty();
            }
            case 28: {
                return pSDEToolbarLogicBase.isPSSysViewPanelIdDirty();
            }
            case 29: {
                return pSDEToolbarLogicBase.isPSSysViewPanelNameDirty();
            }
            case 30: {
                return pSDEToolbarLogicBase.isTimerDirty();
            }
            case 31: {
                return pSDEToolbarLogicBase.isTriggerTypeDirty();
            }
            case 32: {
                return pSDEToolbarLogicBase.isUpdateDateDirty();
            }
            case 33: {
                return pSDEToolbarLogicBase.isUpdateManDirty();
            }
            case 34: {
                return pSDEToolbarLogicBase.isUserCatDirty();
            }
            case 35: {
                return pSDEToolbarLogicBase.isUserTagDirty();
            }
            case 36: {
                return pSDEToolbarLogicBase.isUserTag2Dirty();
            }
            case 37: {
                return pSDEToolbarLogicBase.isUserTag3Dirty();
            }
            case 38: {
                return pSDEToolbarLogicBase.isUserTag4Dirty();
            }
            case 39: {
                return pSDEToolbarLogicBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEToolbarLogicBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEToolbarLogicBase pSDEToolbarLogicBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEToolbarLogicBase.getAttrName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"attrname", (Object)PSDEToolbarLogicBase.getJSONValue((Object)pSDEToolbarLogicBase.getAttrName()), (boolean)false);
        }
        if (bl || pSDEToolbarLogicBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEToolbarLogicBase.getJSONValue((Object)pSDEToolbarLogicBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEToolbarLogicBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEToolbarLogicBase.getJSONValue((Object)pSDEToolbarLogicBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEToolbarLogicBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSDEToolbarLogicBase.getJSONValue((Object)pSDEToolbarLogicBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSDEToolbarLogicBase.getDstLogicType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstlogictype", (Object)PSDEToolbarLogicBase.getJSONValue((Object)pSDEToolbarLogicBase.getDstLogicType()), (boolean)false);
        }
        if (bl || pSDEToolbarLogicBase.getEventArg() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eventarg", (Object)PSDEToolbarLogicBase.getJSONValue((Object)pSDEToolbarLogicBase.getEventArg()), (boolean)false);
        }
        if (bl || pSDEToolbarLogicBase.getEventArg2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eventarg2", (Object)PSDEToolbarLogicBase.getJSONValue((Object)pSDEToolbarLogicBase.getEventArg2()), (boolean)false);
        }
        if (bl || pSDEToolbarLogicBase.getEventNames() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eventnames", (Object)PSDEToolbarLogicBase.getJSONValue((Object)pSDEToolbarLogicBase.getEventNames()), (boolean)false);
        }
        if (bl || pSDEToolbarLogicBase.getLogicParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicparam", (Object)PSDEToolbarLogicBase.getJSONValue((Object)pSDEToolbarLogicBase.getLogicParam()), (boolean)false);
        }
        if (bl || pSDEToolbarLogicBase.getLogicParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicparam2", (Object)PSDEToolbarLogicBase.getJSONValue((Object)pSDEToolbarLogicBase.getLogicParam2()), (boolean)false);
        }
        if (bl || pSDEToolbarLogicBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEToolbarLogicBase.getJSONValue((Object)pSDEToolbarLogicBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEToolbarLogicBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDEToolbarLogicBase.getJSONValue((Object)pSDEToolbarLogicBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDEToolbarLogicBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEToolbarLogicBase.getJSONValue((Object)pSDEToolbarLogicBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEToolbarLogicBase.getPSDELogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicid", (Object)PSDEToolbarLogicBase.getJSONValue((Object)pSDEToolbarLogicBase.getPSDELogicId()), (boolean)false);
        }
        if (bl || pSDEToolbarLogicBase.getPSDELogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicname", (Object)PSDEToolbarLogicBase.getJSONValue((Object)pSDEToolbarLogicBase.getPSDELogicName()), (boolean)false);
        }
        if (bl || pSDEToolbarLogicBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDEToolbarLogicBase.getJSONValue((Object)pSDEToolbarLogicBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDEToolbarLogicBase.getPSDETBItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetbitemid", (Object)PSDEToolbarLogicBase.getJSONValue((Object)pSDEToolbarLogicBase.getPSDETBItemId()), (boolean)false);
        }
        if (bl || pSDEToolbarLogicBase.getPSDETBItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetbitemname", (Object)PSDEToolbarLogicBase.getJSONValue((Object)pSDEToolbarLogicBase.getPSDETBItemName()), (boolean)false);
        }
        if (bl || pSDEToolbarLogicBase.getPSDEToolbarId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetoolbarid", (Object)PSDEToolbarLogicBase.getJSONValue((Object)pSDEToolbarLogicBase.getPSDEToolbarId()), (boolean)false);
        }
        if (bl || pSDEToolbarLogicBase.getPSDEToolbarLogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetoolbarlogicid", (Object)PSDEToolbarLogicBase.getJSONValue((Object)pSDEToolbarLogicBase.getPSDEToolbarLogicId()), (boolean)false);
        }
        if (bl || pSDEToolbarLogicBase.getPSDEToolbarLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetoolbarlogicname", (Object)PSDEToolbarLogicBase.getJSONValue((Object)pSDEToolbarLogicBase.getPSDEToolbarLogicName()), (boolean)false);
        }
        if (bl || pSDEToolbarLogicBase.getPSDEToolbarName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetoolbarname", (Object)PSDEToolbarLogicBase.getJSONValue((Object)pSDEToolbarLogicBase.getPSDEToolbarName()), (boolean)false);
        }
        if (bl || pSDEToolbarLogicBase.getPSDEUIActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuiactionid", (Object)PSDEToolbarLogicBase.getJSONValue((Object)pSDEToolbarLogicBase.getPSDEUIActionId()), (boolean)false);
        }
        if (bl || pSDEToolbarLogicBase.getPSDEUIActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuiactionname", (Object)PSDEToolbarLogicBase.getJSONValue((Object)pSDEToolbarLogicBase.getPSDEUIActionName()), (boolean)false);
        }
        if (bl || pSDEToolbarLogicBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSDEToolbarLogicBase.getJSONValue((Object)pSDEToolbarLogicBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSDEToolbarLogicBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSDEToolbarLogicBase.getJSONValue((Object)pSDEToolbarLogicBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSDEToolbarLogicBase.getPSSysViewLogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewlogicid", (Object)PSDEToolbarLogicBase.getJSONValue((Object)pSDEToolbarLogicBase.getPSSysViewLogicId()), (boolean)false);
        }
        if (bl || pSDEToolbarLogicBase.getPSSysViewLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewlogicname", (Object)PSDEToolbarLogicBase.getJSONValue((Object)pSDEToolbarLogicBase.getPSSysViewLogicName()), (boolean)false);
        }
        if (bl || pSDEToolbarLogicBase.getPSSysViewPanelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelid", (Object)PSDEToolbarLogicBase.getJSONValue((Object)pSDEToolbarLogicBase.getPSSysViewPanelId()), (boolean)false);
        }
        if (bl || pSDEToolbarLogicBase.getPSSysViewPanelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelname", (Object)PSDEToolbarLogicBase.getJSONValue((Object)pSDEToolbarLogicBase.getPSSysViewPanelName()), (boolean)false);
        }
        if (bl || pSDEToolbarLogicBase.getTimer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"timer", (Object)PSDEToolbarLogicBase.getJSONValue((Object)pSDEToolbarLogicBase.getTimer()), (boolean)false);
        }
        if (bl || pSDEToolbarLogicBase.getTriggerType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"triggertype", (Object)PSDEToolbarLogicBase.getJSONValue((Object)pSDEToolbarLogicBase.getTriggerType()), (boolean)false);
        }
        if (bl || pSDEToolbarLogicBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEToolbarLogicBase.getJSONValue((Object)pSDEToolbarLogicBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEToolbarLogicBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEToolbarLogicBase.getJSONValue((Object)pSDEToolbarLogicBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEToolbarLogicBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEToolbarLogicBase.getJSONValue((Object)pSDEToolbarLogicBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEToolbarLogicBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEToolbarLogicBase.getJSONValue((Object)pSDEToolbarLogicBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEToolbarLogicBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEToolbarLogicBase.getJSONValue((Object)pSDEToolbarLogicBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEToolbarLogicBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEToolbarLogicBase.getJSONValue((Object)pSDEToolbarLogicBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEToolbarLogicBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEToolbarLogicBase.getJSONValue((Object)pSDEToolbarLogicBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDEToolbarLogicBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDEToolbarLogicBase.getJSONValue((Object)pSDEToolbarLogicBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEToolbarLogicBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEToolbarLogicBase pSDEToolbarLogicBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEToolbarLogicBase.getAttrName() != null) {
            object = pSDEToolbarLogicBase.getAttrName();
            xmlNode.setAttribute(FIELD_ATTRNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarLogicBase.getCreateDate() != null) {
            object = pSDEToolbarLogicBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEToolbarLogicBase.getCreateMan() != null) {
            object = pSDEToolbarLogicBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarLogicBase.getCustomCode() != null) {
            object = pSDEToolbarLogicBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarLogicBase.getDstLogicType() != null) {
            object = pSDEToolbarLogicBase.getDstLogicType();
            xmlNode.setAttribute(FIELD_DSTLOGICTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarLogicBase.getEventArg() != null) {
            object = pSDEToolbarLogicBase.getEventArg();
            xmlNode.setAttribute(FIELD_EVENTARG, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarLogicBase.getEventArg2() != null) {
            object = pSDEToolbarLogicBase.getEventArg2();
            xmlNode.setAttribute(FIELD_EVENTARG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarLogicBase.getEventNames() != null) {
            object = pSDEToolbarLogicBase.getEventNames();
            xmlNode.setAttribute(FIELD_EVENTNAMES, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarLogicBase.getLogicParam() != null) {
            object = pSDEToolbarLogicBase.getLogicParam();
            xmlNode.setAttribute(FIELD_LOGICPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarLogicBase.getLogicParam2() != null) {
            object = pSDEToolbarLogicBase.getLogicParam2();
            xmlNode.setAttribute(FIELD_LOGICPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarLogicBase.getMemo() != null) {
            object = pSDEToolbarLogicBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarLogicBase.getOrderValue() != null) {
            object = pSDEToolbarLogicBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEToolbarLogicBase.getPSDEId() != null) {
            object = pSDEToolbarLogicBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarLogicBase.getPSDELogicId() != null) {
            object = pSDEToolbarLogicBase.getPSDELogicId();
            xmlNode.setAttribute(FIELD_PSDELOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarLogicBase.getPSDELogicName() != null) {
            object = pSDEToolbarLogicBase.getPSDELogicName();
            xmlNode.setAttribute(FIELD_PSDELOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarLogicBase.getPSDEName() != null) {
            object = pSDEToolbarLogicBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarLogicBase.getPSDETBItemId() != null) {
            object = pSDEToolbarLogicBase.getPSDETBItemId();
            xmlNode.setAttribute(FIELD_PSDETBITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarLogicBase.getPSDETBItemName() != null) {
            object = pSDEToolbarLogicBase.getPSDETBItemName();
            xmlNode.setAttribute(FIELD_PSDETBITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarLogicBase.getPSDEToolbarId() != null) {
            object = pSDEToolbarLogicBase.getPSDEToolbarId();
            xmlNode.setAttribute(FIELD_PSDETOOLBARID, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarLogicBase.getPSDEToolbarLogicId() != null) {
            object = pSDEToolbarLogicBase.getPSDEToolbarLogicId();
            xmlNode.setAttribute(FIELD_PSDETOOLBARLOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarLogicBase.getPSDEToolbarLogicName() != null) {
            object = pSDEToolbarLogicBase.getPSDEToolbarLogicName();
            xmlNode.setAttribute(FIELD_PSDETOOLBARLOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarLogicBase.getPSDEToolbarName() != null) {
            object = pSDEToolbarLogicBase.getPSDEToolbarName();
            xmlNode.setAttribute(FIELD_PSDETOOLBARNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarLogicBase.getPSDEUIActionId() != null) {
            object = pSDEToolbarLogicBase.getPSDEUIActionId();
            xmlNode.setAttribute(FIELD_PSDEUIACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarLogicBase.getPSDEUIActionName() != null) {
            object = pSDEToolbarLogicBase.getPSDEUIActionName();
            xmlNode.setAttribute(FIELD_PSDEUIACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarLogicBase.getPSSysPFPluginId() != null) {
            object = pSDEToolbarLogicBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarLogicBase.getPSSysPFPluginName() != null) {
            object = pSDEToolbarLogicBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarLogicBase.getPSSysViewLogicId() != null) {
            object = pSDEToolbarLogicBase.getPSSysViewLogicId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWLOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarLogicBase.getPSSysViewLogicName() != null) {
            object = pSDEToolbarLogicBase.getPSSysViewLogicName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWLOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarLogicBase.getPSSysViewPanelId() != null) {
            object = pSDEToolbarLogicBase.getPSSysViewPanelId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELID, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarLogicBase.getPSSysViewPanelName() != null) {
            object = pSDEToolbarLogicBase.getPSSysViewPanelName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarLogicBase.getTimer() != null) {
            object = pSDEToolbarLogicBase.getTimer();
            xmlNode.setAttribute(FIELD_TIMER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEToolbarLogicBase.getTriggerType() != null) {
            object = pSDEToolbarLogicBase.getTriggerType();
            xmlNode.setAttribute(FIELD_TRIGGERTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarLogicBase.getUpdateDate() != null) {
            object = pSDEToolbarLogicBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEToolbarLogicBase.getUpdateMan() != null) {
            object = pSDEToolbarLogicBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarLogicBase.getUserCat() != null) {
            object = pSDEToolbarLogicBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarLogicBase.getUserTag() != null) {
            object = pSDEToolbarLogicBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarLogicBase.getUserTag2() != null) {
            object = pSDEToolbarLogicBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarLogicBase.getUserTag3() != null) {
            object = pSDEToolbarLogicBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarLogicBase.getUserTag4() != null) {
            object = pSDEToolbarLogicBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEToolbarLogicBase.getValidFlag() != null) {
            object = pSDEToolbarLogicBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEToolbarLogicBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEToolbarLogicBase pSDEToolbarLogicBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEToolbarLogicBase.isAttrNameDirty() && (bl || pSDEToolbarLogicBase.getAttrName() != null)) {
            iDataObject.set(FIELD_ATTRNAME, (Object)pSDEToolbarLogicBase.getAttrName());
        }
        if (pSDEToolbarLogicBase.isCreateDateDirty() && (bl || pSDEToolbarLogicBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEToolbarLogicBase.getCreateDate());
        }
        if (pSDEToolbarLogicBase.isCreateManDirty() && (bl || pSDEToolbarLogicBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEToolbarLogicBase.getCreateMan());
        }
        if (pSDEToolbarLogicBase.isCustomCodeDirty() && (bl || pSDEToolbarLogicBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSDEToolbarLogicBase.getCustomCode());
        }
        if (pSDEToolbarLogicBase.isDstLogicTypeDirty() && (bl || pSDEToolbarLogicBase.getDstLogicType() != null)) {
            iDataObject.set(FIELD_DSTLOGICTYPE, (Object)pSDEToolbarLogicBase.getDstLogicType());
        }
        if (pSDEToolbarLogicBase.isEventArgDirty() && (bl || pSDEToolbarLogicBase.getEventArg() != null)) {
            iDataObject.set(FIELD_EVENTARG, (Object)pSDEToolbarLogicBase.getEventArg());
        }
        if (pSDEToolbarLogicBase.isEventArg2Dirty() && (bl || pSDEToolbarLogicBase.getEventArg2() != null)) {
            iDataObject.set(FIELD_EVENTARG2, (Object)pSDEToolbarLogicBase.getEventArg2());
        }
        if (pSDEToolbarLogicBase.isEventNamesDirty() && (bl || pSDEToolbarLogicBase.getEventNames() != null)) {
            iDataObject.set(FIELD_EVENTNAMES, (Object)pSDEToolbarLogicBase.getEventNames());
        }
        if (pSDEToolbarLogicBase.isLogicParamDirty() && (bl || pSDEToolbarLogicBase.getLogicParam() != null)) {
            iDataObject.set(FIELD_LOGICPARAM, (Object)pSDEToolbarLogicBase.getLogicParam());
        }
        if (pSDEToolbarLogicBase.isLogicParam2Dirty() && (bl || pSDEToolbarLogicBase.getLogicParam2() != null)) {
            iDataObject.set(FIELD_LOGICPARAM2, (Object)pSDEToolbarLogicBase.getLogicParam2());
        }
        if (pSDEToolbarLogicBase.isMemoDirty() && (bl || pSDEToolbarLogicBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEToolbarLogicBase.getMemo());
        }
        if (pSDEToolbarLogicBase.isOrderValueDirty() && (bl || pSDEToolbarLogicBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDEToolbarLogicBase.getOrderValue());
        }
        if (pSDEToolbarLogicBase.isPSDEIdDirty() && (bl || pSDEToolbarLogicBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEToolbarLogicBase.getPSDEId());
        }
        if (pSDEToolbarLogicBase.isPSDELogicIdDirty() && (bl || pSDEToolbarLogicBase.getPSDELogicId() != null)) {
            iDataObject.set(FIELD_PSDELOGICID, (Object)pSDEToolbarLogicBase.getPSDELogicId());
        }
        if (pSDEToolbarLogicBase.isPSDELogicNameDirty() && (bl || pSDEToolbarLogicBase.getPSDELogicName() != null)) {
            iDataObject.set(FIELD_PSDELOGICNAME, (Object)pSDEToolbarLogicBase.getPSDELogicName());
        }
        if (pSDEToolbarLogicBase.isPSDENameDirty() && (bl || pSDEToolbarLogicBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDEToolbarLogicBase.getPSDEName());
        }
        if (pSDEToolbarLogicBase.isPSDETBItemIdDirty() && (bl || pSDEToolbarLogicBase.getPSDETBItemId() != null)) {
            iDataObject.set(FIELD_PSDETBITEMID, (Object)pSDEToolbarLogicBase.getPSDETBItemId());
        }
        if (pSDEToolbarLogicBase.isPSDETBItemNameDirty() && (bl || pSDEToolbarLogicBase.getPSDETBItemName() != null)) {
            iDataObject.set(FIELD_PSDETBITEMNAME, (Object)pSDEToolbarLogicBase.getPSDETBItemName());
        }
        if (pSDEToolbarLogicBase.isPSDEToolbarIdDirty() && (bl || pSDEToolbarLogicBase.getPSDEToolbarId() != null)) {
            iDataObject.set(FIELD_PSDETOOLBARID, (Object)pSDEToolbarLogicBase.getPSDEToolbarId());
        }
        if (pSDEToolbarLogicBase.isPSDEToolbarLogicIdDirty() && (bl || pSDEToolbarLogicBase.getPSDEToolbarLogicId() != null)) {
            iDataObject.set(FIELD_PSDETOOLBARLOGICID, (Object)pSDEToolbarLogicBase.getPSDEToolbarLogicId());
        }
        if (pSDEToolbarLogicBase.isPSDEToolbarLogicNameDirty() && (bl || pSDEToolbarLogicBase.getPSDEToolbarLogicName() != null)) {
            iDataObject.set(FIELD_PSDETOOLBARLOGICNAME, (Object)pSDEToolbarLogicBase.getPSDEToolbarLogicName());
        }
        if (pSDEToolbarLogicBase.isPSDEToolbarNameDirty() && (bl || pSDEToolbarLogicBase.getPSDEToolbarName() != null)) {
            iDataObject.set(FIELD_PSDETOOLBARNAME, (Object)pSDEToolbarLogicBase.getPSDEToolbarName());
        }
        if (pSDEToolbarLogicBase.isPSDEUIActionIdDirty() && (bl || pSDEToolbarLogicBase.getPSDEUIActionId() != null)) {
            iDataObject.set(FIELD_PSDEUIACTIONID, (Object)pSDEToolbarLogicBase.getPSDEUIActionId());
        }
        if (pSDEToolbarLogicBase.isPSDEUIActionNameDirty() && (bl || pSDEToolbarLogicBase.getPSDEUIActionName() != null)) {
            iDataObject.set(FIELD_PSDEUIACTIONNAME, (Object)pSDEToolbarLogicBase.getPSDEUIActionName());
        }
        if (pSDEToolbarLogicBase.isPSSysPFPluginIdDirty() && (bl || pSDEToolbarLogicBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSDEToolbarLogicBase.getPSSysPFPluginId());
        }
        if (pSDEToolbarLogicBase.isPSSysPFPluginNameDirty() && (bl || pSDEToolbarLogicBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSDEToolbarLogicBase.getPSSysPFPluginName());
        }
        if (pSDEToolbarLogicBase.isPSSysViewLogicIdDirty() && (bl || pSDEToolbarLogicBase.getPSSysViewLogicId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWLOGICID, (Object)pSDEToolbarLogicBase.getPSSysViewLogicId());
        }
        if (pSDEToolbarLogicBase.isPSSysViewLogicNameDirty() && (bl || pSDEToolbarLogicBase.getPSSysViewLogicName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWLOGICNAME, (Object)pSDEToolbarLogicBase.getPSSysViewLogicName());
        }
        if (pSDEToolbarLogicBase.isPSSysViewPanelIdDirty() && (bl || pSDEToolbarLogicBase.getPSSysViewPanelId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELID, (Object)pSDEToolbarLogicBase.getPSSysViewPanelId());
        }
        if (pSDEToolbarLogicBase.isPSSysViewPanelNameDirty() && (bl || pSDEToolbarLogicBase.getPSSysViewPanelName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELNAME, (Object)pSDEToolbarLogicBase.getPSSysViewPanelName());
        }
        if (pSDEToolbarLogicBase.isTimerDirty() && (bl || pSDEToolbarLogicBase.getTimer() != null)) {
            iDataObject.set(FIELD_TIMER, (Object)pSDEToolbarLogicBase.getTimer());
        }
        if (pSDEToolbarLogicBase.isTriggerTypeDirty() && (bl || pSDEToolbarLogicBase.getTriggerType() != null)) {
            iDataObject.set(FIELD_TRIGGERTYPE, (Object)pSDEToolbarLogicBase.getTriggerType());
        }
        if (pSDEToolbarLogicBase.isUpdateDateDirty() && (bl || pSDEToolbarLogicBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEToolbarLogicBase.getUpdateDate());
        }
        if (pSDEToolbarLogicBase.isUpdateManDirty() && (bl || pSDEToolbarLogicBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEToolbarLogicBase.getUpdateMan());
        }
        if (pSDEToolbarLogicBase.isUserCatDirty() && (bl || pSDEToolbarLogicBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEToolbarLogicBase.getUserCat());
        }
        if (pSDEToolbarLogicBase.isUserTagDirty() && (bl || pSDEToolbarLogicBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEToolbarLogicBase.getUserTag());
        }
        if (pSDEToolbarLogicBase.isUserTag2Dirty() && (bl || pSDEToolbarLogicBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEToolbarLogicBase.getUserTag2());
        }
        if (pSDEToolbarLogicBase.isUserTag3Dirty() && (bl || pSDEToolbarLogicBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEToolbarLogicBase.getUserTag3());
        }
        if (pSDEToolbarLogicBase.isUserTag4Dirty() && (bl || pSDEToolbarLogicBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEToolbarLogicBase.getUserTag4());
        }
        if (pSDEToolbarLogicBase.isValidFlagDirty() && (bl || pSDEToolbarLogicBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDEToolbarLogicBase.getValidFlag());
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
        return PSDEToolbarLogicBase.remove(this, n);
    }

    private static boolean remove(PSDEToolbarLogicBase pSDEToolbarLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEToolbarLogicBase.resetAttrName();
                return true;
            }
            case 1: {
                pSDEToolbarLogicBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDEToolbarLogicBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDEToolbarLogicBase.resetCustomCode();
                return true;
            }
            case 4: {
                pSDEToolbarLogicBase.resetDstLogicType();
                return true;
            }
            case 5: {
                pSDEToolbarLogicBase.resetEventArg();
                return true;
            }
            case 6: {
                pSDEToolbarLogicBase.resetEventArg2();
                return true;
            }
            case 7: {
                pSDEToolbarLogicBase.resetEventNames();
                return true;
            }
            case 8: {
                pSDEToolbarLogicBase.resetLogicParam();
                return true;
            }
            case 9: {
                pSDEToolbarLogicBase.resetLogicParam2();
                return true;
            }
            case 10: {
                pSDEToolbarLogicBase.resetMemo();
                return true;
            }
            case 11: {
                pSDEToolbarLogicBase.resetOrderValue();
                return true;
            }
            case 12: {
                pSDEToolbarLogicBase.resetPSDEId();
                return true;
            }
            case 13: {
                pSDEToolbarLogicBase.resetPSDELogicId();
                return true;
            }
            case 14: {
                pSDEToolbarLogicBase.resetPSDELogicName();
                return true;
            }
            case 15: {
                pSDEToolbarLogicBase.resetPSDEName();
                return true;
            }
            case 16: {
                pSDEToolbarLogicBase.resetPSDETBItemId();
                return true;
            }
            case 17: {
                pSDEToolbarLogicBase.resetPSDETBItemName();
                return true;
            }
            case 18: {
                pSDEToolbarLogicBase.resetPSDEToolbarId();
                return true;
            }
            case 19: {
                pSDEToolbarLogicBase.resetPSDEToolbarLogicId();
                return true;
            }
            case 20: {
                pSDEToolbarLogicBase.resetPSDEToolbarLogicName();
                return true;
            }
            case 21: {
                pSDEToolbarLogicBase.resetPSDEToolbarName();
                return true;
            }
            case 22: {
                pSDEToolbarLogicBase.resetPSDEUIActionId();
                return true;
            }
            case 23: {
                pSDEToolbarLogicBase.resetPSDEUIActionName();
                return true;
            }
            case 24: {
                pSDEToolbarLogicBase.resetPSSysPFPluginId();
                return true;
            }
            case 25: {
                pSDEToolbarLogicBase.resetPSSysPFPluginName();
                return true;
            }
            case 26: {
                pSDEToolbarLogicBase.resetPSSysViewLogicId();
                return true;
            }
            case 27: {
                pSDEToolbarLogicBase.resetPSSysViewLogicName();
                return true;
            }
            case 28: {
                pSDEToolbarLogicBase.resetPSSysViewPanelId();
                return true;
            }
            case 29: {
                pSDEToolbarLogicBase.resetPSSysViewPanelName();
                return true;
            }
            case 30: {
                pSDEToolbarLogicBase.resetTimer();
                return true;
            }
            case 31: {
                pSDEToolbarLogicBase.resetTriggerType();
                return true;
            }
            case 32: {
                pSDEToolbarLogicBase.resetUpdateDate();
                return true;
            }
            case 33: {
                pSDEToolbarLogicBase.resetUpdateMan();
                return true;
            }
            case 34: {
                pSDEToolbarLogicBase.resetUserCat();
                return true;
            }
            case 35: {
                pSDEToolbarLogicBase.resetUserTag();
                return true;
            }
            case 36: {
                pSDEToolbarLogicBase.resetUserTag2();
                return true;
            }
            case 37: {
                pSDEToolbarLogicBase.resetUserTag3();
                return true;
            }
            case 38: {
                pSDEToolbarLogicBase.resetUserTag4();
                return true;
            }
            case 39: {
                pSDEToolbarLogicBase.resetValidFlag();
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
    public PSDETBItem getPSDETBItem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETBItem();
        }
        if (this.getPSDETBItemId() == null) {
            return null;
        }
        Integer n = this.objPSDETBItemLock;
        synchronized (n) {
            if (this.psdetbitem != null && DataTypeHelper.compare((int)25, (Object)this.getPSDETBItemId(), (Object)this.psdetbitem.getPSDETBItemId()) != 0L) {
                this.psdetbitem = null;
            }
            if (this.psdetbitem == null) {
                PSDETBItem pSDETBItem = new PSDETBItem();
                pSDETBItem.setPSDETBItemId(this.getPSDETBItemId());
                PSDETBItemService pSDETBItemService = (PSDETBItemService)ServiceGlobal.getService(PSDETBItemService.class, (SessionFactory)this.getSessionFactory());
                pSDETBItemService.autoGet(pSDETBItem);
                this.psdetbitem = pSDETBItem;
            }
            return this.psdetbitem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEToolbar getPSDEToolbar() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEToolbar();
        }
        if (this.getPSDEToolbarId() == null) {
            return null;
        }
        Integer n = this.objPSDEToolbarLock;
        synchronized (n) {
            if (this.psdetoolbar != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEToolbarId(), (Object)this.psdetoolbar.getPSDEToolbarId()) != 0L) {
                this.psdetoolbar = null;
            }
            if (this.psdetoolbar == null) {
                PSDEToolbar pSDEToolbar = new PSDEToolbar();
                pSDEToolbar.setPSDEToolbarId(this.getPSDEToolbarId());
                PSDEToolbarService pSDEToolbarService = (PSDEToolbarService)ServiceGlobal.getService(PSDEToolbarService.class, (SessionFactory)this.getSessionFactory());
                pSDEToolbarService.autoGet(pSDEToolbar);
                this.psdetoolbar = pSDEToolbar;
            }
            return this.psdetoolbar;
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

    private PSDEToolbarLogicBase getProxyEntity() {
        return this.proxyPSDEToolbarLogicBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEToolbarLogicBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEToolbarLogicBase) {
            this.proxyPSDEToolbarLogicBase = (PSDEToolbarLogicBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarLogicService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
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
        fieldIndexMap.put(FIELD_PSDEID, 12);
        fieldIndexMap.put(FIELD_PSDELOGICID, 13);
        fieldIndexMap.put(FIELD_PSDELOGICNAME, 14);
        fieldIndexMap.put(FIELD_PSDENAME, 15);
        fieldIndexMap.put(FIELD_PSDETBITEMID, 16);
        fieldIndexMap.put(FIELD_PSDETBITEMNAME, 17);
        fieldIndexMap.put(FIELD_PSDETOOLBARID, 18);
        fieldIndexMap.put(FIELD_PSDETOOLBARLOGICID, 19);
        fieldIndexMap.put(FIELD_PSDETOOLBARLOGICNAME, 20);
        fieldIndexMap.put(FIELD_PSDETOOLBARNAME, 21);
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

