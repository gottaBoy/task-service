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
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCalendar;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCalendarItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewLogic;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanel;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewLogicService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysCalendarLogicBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysCalendarLogicBase.class);
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
    public static final String FIELD_PSDEUIACTIONID = "PSDEUIACTIONID";
    public static final String FIELD_PSDEUIACTIONNAME = "PSDEUIACTIONNAME";
    public static final String FIELD_PSSYSCALENDARID = "PSSYSCALENDARID";
    public static final String FIELD_PSSYSCALENDARITEMID = "PSSYSCALENDARITEMID";
    public static final String FIELD_PSSYSCALENDARITEMNAME = "PSSYSCALENDARITEMNAME";
    public static final String FIELD_PSSYSCALENDARLOGICID = "PSSYSCALENDARLOGICID";
    public static final String FIELD_PSSYSCALENDARLOGICNAME = "PSSYSCALENDARLOGICNAME";
    public static final String FIELD_PSSYSCALENDARNAME = "PSSYSCALENDARNAME";
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
    private static final int INDEX_PSDEUIACTIONID = 16;
    private static final int INDEX_PSDEUIACTIONNAME = 17;
    private static final int INDEX_PSSYSCALENDARID = 18;
    private static final int INDEX_PSSYSCALENDARITEMID = 19;
    private static final int INDEX_PSSYSCALENDARITEMNAME = 20;
    private static final int INDEX_PSSYSCALENDARLOGICID = 21;
    private static final int INDEX_PSSYSCALENDARLOGICNAME = 22;
    private static final int INDEX_PSSYSCALENDARNAME = 23;
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
    private PSSysCalendarLogicBase proxyPSSysCalendarLogicBase = null;
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
    private boolean psdeuiactionidDirtyFlag = false;
    private boolean psdeuiactionnameDirtyFlag = false;
    private boolean pssyscalendaridDirtyFlag = false;
    private boolean pssyscalendaritemidDirtyFlag = false;
    private boolean pssyscalendaritemnameDirtyFlag = false;
    private boolean pssyscalendarlogicidDirtyFlag = false;
    private boolean pssyscalendarlogicnameDirtyFlag = false;
    private boolean pssyscalendarnameDirtyFlag = false;
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
    @Column(name="psdeuiactionid")
    private String psdeuiactionid;
    @Column(name="psdeuiactionname")
    private String psdeuiactionname;
    @Column(name="pssyscalendarid")
    private String pssyscalendarid;
    @Column(name="pssyscalendaritemid")
    private String pssyscalendaritemid;
    @Column(name="pssyscalendaritemname")
    private String pssyscalendaritemname;
    @Column(name="pssyscalendarlogicid")
    private String pssyscalendarlogicid;
    @Column(name="pssyscalendarlogicname")
    private String pssyscalendarlogicname;
    @Column(name="pssyscalendarname")
    private String pssyscalendarname;
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
    private Integer objPSDEUIActionLock = new Integer(1);
    private PSDEUIAction psdeuiaction = null;
    private Integer objPSSysCalendarItemLock = new Integer(1);
    private PSSysCalendarItem pssyscalendaritem = null;
    private Integer objPSSysCalendarLock = new Integer(1);
    private PSSysCalendar pssyscalendar = null;
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

    public void setPSSysCalendarId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCalendarId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscalendarid = string;
        this.pssyscalendaridDirtyFlag = true;
    }

    public String getPSSysCalendarId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCalendarId();
        }
        return this.pssyscalendarid;
    }

    public boolean isPSSysCalendarIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCalendarIdDirty();
        }
        return this.pssyscalendaridDirtyFlag;
    }

    public void resetPSSysCalendarId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCalendarId();
            return;
        }
        this.pssyscalendaridDirtyFlag = false;
        this.pssyscalendarid = null;
    }

    public void setPSSysCalendarItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCalendarItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscalendaritemid = string;
        this.pssyscalendaritemidDirtyFlag = true;
    }

    public String getPSSysCalendarItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCalendarItemId();
        }
        return this.pssyscalendaritemid;
    }

    public boolean isPSSysCalendarItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCalendarItemIdDirty();
        }
        return this.pssyscalendaritemidDirtyFlag;
    }

    public void resetPSSysCalendarItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCalendarItemId();
            return;
        }
        this.pssyscalendaritemidDirtyFlag = false;
        this.pssyscalendaritemid = null;
    }

    public void setPSSysCalendarItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCalendarItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscalendaritemname = string;
        this.pssyscalendaritemnameDirtyFlag = true;
    }

    public String getPSSysCalendarItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCalendarItemName();
        }
        return this.pssyscalendaritemname;
    }

    public boolean isPSSysCalendarItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCalendarItemNameDirty();
        }
        return this.pssyscalendaritemnameDirtyFlag;
    }

    public void resetPSSysCalendarItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCalendarItemName();
            return;
        }
        this.pssyscalendaritemnameDirtyFlag = false;
        this.pssyscalendaritemname = null;
    }

    public void setPSSysCalendarLogicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCalendarLogicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscalendarlogicid = string;
        this.pssyscalendarlogicidDirtyFlag = true;
    }

    public String getPSSysCalendarLogicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCalendarLogicId();
        }
        return this.pssyscalendarlogicid;
    }

    public boolean isPSSysCalendarLogicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCalendarLogicIdDirty();
        }
        return this.pssyscalendarlogicidDirtyFlag;
    }

    public void resetPSSysCalendarLogicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCalendarLogicId();
            return;
        }
        this.pssyscalendarlogicidDirtyFlag = false;
        this.pssyscalendarlogicid = null;
    }

    public void setPSSysCalendarLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCalendarLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscalendarlogicname = string;
        this.pssyscalendarlogicnameDirtyFlag = true;
    }

    public String getPSSysCalendarLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCalendarLogicName();
        }
        return this.pssyscalendarlogicname;
    }

    public boolean isPSSysCalendarLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCalendarLogicNameDirty();
        }
        return this.pssyscalendarlogicnameDirtyFlag;
    }

    public void resetPSSysCalendarLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCalendarLogicName();
            return;
        }
        this.pssyscalendarlogicnameDirtyFlag = false;
        this.pssyscalendarlogicname = null;
    }

    public void setPSSysCalendarName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCalendarName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscalendarname = string;
        this.pssyscalendarnameDirtyFlag = true;
    }

    public String getPSSysCalendarName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCalendarName();
        }
        return this.pssyscalendarname;
    }

    public boolean isPSSysCalendarNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCalendarNameDirty();
        }
        return this.pssyscalendarnameDirtyFlag;
    }

    public void resetPSSysCalendarName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCalendarName();
            return;
        }
        this.pssyscalendarnameDirtyFlag = false;
        this.pssyscalendarname = null;
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
        PSSysCalendarLogicBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysCalendarLogicBase pSSysCalendarLogicBase) {
        pSSysCalendarLogicBase.resetAttrName();
        pSSysCalendarLogicBase.resetCreateDate();
        pSSysCalendarLogicBase.resetCreateMan();
        pSSysCalendarLogicBase.resetCustomCode();
        pSSysCalendarLogicBase.resetDstLogicType();
        pSSysCalendarLogicBase.resetEventArg();
        pSSysCalendarLogicBase.resetEventArg2();
        pSSysCalendarLogicBase.resetEventNames();
        pSSysCalendarLogicBase.resetLogicParam();
        pSSysCalendarLogicBase.resetLogicParam2();
        pSSysCalendarLogicBase.resetMemo();
        pSSysCalendarLogicBase.resetOrderValue();
        pSSysCalendarLogicBase.resetPSDEId();
        pSSysCalendarLogicBase.resetPSDELogicId();
        pSSysCalendarLogicBase.resetPSDELogicName();
        pSSysCalendarLogicBase.resetPSDEName();
        pSSysCalendarLogicBase.resetPSDEUIActionId();
        pSSysCalendarLogicBase.resetPSDEUIActionName();
        pSSysCalendarLogicBase.resetPSSysCalendarId();
        pSSysCalendarLogicBase.resetPSSysCalendarItemId();
        pSSysCalendarLogicBase.resetPSSysCalendarItemName();
        pSSysCalendarLogicBase.resetPSSysCalendarLogicId();
        pSSysCalendarLogicBase.resetPSSysCalendarLogicName();
        pSSysCalendarLogicBase.resetPSSysCalendarName();
        pSSysCalendarLogicBase.resetPSSysPFPluginId();
        pSSysCalendarLogicBase.resetPSSysPFPluginName();
        pSSysCalendarLogicBase.resetPSSysViewLogicId();
        pSSysCalendarLogicBase.resetPSSysViewLogicName();
        pSSysCalendarLogicBase.resetPSSysViewPanelId();
        pSSysCalendarLogicBase.resetPSSysViewPanelName();
        pSSysCalendarLogicBase.resetTimer();
        pSSysCalendarLogicBase.resetTriggerType();
        pSSysCalendarLogicBase.resetUpdateDate();
        pSSysCalendarLogicBase.resetUpdateMan();
        pSSysCalendarLogicBase.resetUserCat();
        pSSysCalendarLogicBase.resetUserTag();
        pSSysCalendarLogicBase.resetUserTag2();
        pSSysCalendarLogicBase.resetUserTag3();
        pSSysCalendarLogicBase.resetUserTag4();
        pSSysCalendarLogicBase.resetValidFlag();
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
        if (!bl || this.isPSDEUIActionIdDirty()) {
            hashMap.put(FIELD_PSDEUIACTIONID, this.getPSDEUIActionId());
        }
        if (!bl || this.isPSDEUIActionNameDirty()) {
            hashMap.put(FIELD_PSDEUIACTIONNAME, this.getPSDEUIActionName());
        }
        if (!bl || this.isPSSysCalendarIdDirty()) {
            hashMap.put(FIELD_PSSYSCALENDARID, this.getPSSysCalendarId());
        }
        if (!bl || this.isPSSysCalendarItemIdDirty()) {
            hashMap.put(FIELD_PSSYSCALENDARITEMID, this.getPSSysCalendarItemId());
        }
        if (!bl || this.isPSSysCalendarItemNameDirty()) {
            hashMap.put(FIELD_PSSYSCALENDARITEMNAME, this.getPSSysCalendarItemName());
        }
        if (!bl || this.isPSSysCalendarLogicIdDirty()) {
            hashMap.put(FIELD_PSSYSCALENDARLOGICID, this.getPSSysCalendarLogicId());
        }
        if (!bl || this.isPSSysCalendarLogicNameDirty()) {
            hashMap.put(FIELD_PSSYSCALENDARLOGICNAME, this.getPSSysCalendarLogicName());
        }
        if (!bl || this.isPSSysCalendarNameDirty()) {
            hashMap.put(FIELD_PSSYSCALENDARNAME, this.getPSSysCalendarName());
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
        return PSSysCalendarLogicBase.get(this, n);
    }

    private static Object get(PSSysCalendarLogicBase pSSysCalendarLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysCalendarLogicBase.getAttrName();
            }
            case 1: {
                return pSSysCalendarLogicBase.getCreateDate();
            }
            case 2: {
                return pSSysCalendarLogicBase.getCreateMan();
            }
            case 3: {
                return pSSysCalendarLogicBase.getCustomCode();
            }
            case 4: {
                return pSSysCalendarLogicBase.getDstLogicType();
            }
            case 5: {
                return pSSysCalendarLogicBase.getEventArg();
            }
            case 6: {
                return pSSysCalendarLogicBase.getEventArg2();
            }
            case 7: {
                return pSSysCalendarLogicBase.getEventNames();
            }
            case 8: {
                return pSSysCalendarLogicBase.getLogicParam();
            }
            case 9: {
                return pSSysCalendarLogicBase.getLogicParam2();
            }
            case 10: {
                return pSSysCalendarLogicBase.getMemo();
            }
            case 11: {
                return pSSysCalendarLogicBase.getOrderValue();
            }
            case 12: {
                return pSSysCalendarLogicBase.getPSDEId();
            }
            case 13: {
                return pSSysCalendarLogicBase.getPSDELogicId();
            }
            case 14: {
                return pSSysCalendarLogicBase.getPSDELogicName();
            }
            case 15: {
                return pSSysCalendarLogicBase.getPSDEName();
            }
            case 16: {
                return pSSysCalendarLogicBase.getPSDEUIActionId();
            }
            case 17: {
                return pSSysCalendarLogicBase.getPSDEUIActionName();
            }
            case 18: {
                return pSSysCalendarLogicBase.getPSSysCalendarId();
            }
            case 19: {
                return pSSysCalendarLogicBase.getPSSysCalendarItemId();
            }
            case 20: {
                return pSSysCalendarLogicBase.getPSSysCalendarItemName();
            }
            case 21: {
                return pSSysCalendarLogicBase.getPSSysCalendarLogicId();
            }
            case 22: {
                return pSSysCalendarLogicBase.getPSSysCalendarLogicName();
            }
            case 23: {
                return pSSysCalendarLogicBase.getPSSysCalendarName();
            }
            case 24: {
                return pSSysCalendarLogicBase.getPSSysPFPluginId();
            }
            case 25: {
                return pSSysCalendarLogicBase.getPSSysPFPluginName();
            }
            case 26: {
                return pSSysCalendarLogicBase.getPSSysViewLogicId();
            }
            case 27: {
                return pSSysCalendarLogicBase.getPSSysViewLogicName();
            }
            case 28: {
                return pSSysCalendarLogicBase.getPSSysViewPanelId();
            }
            case 29: {
                return pSSysCalendarLogicBase.getPSSysViewPanelName();
            }
            case 30: {
                return pSSysCalendarLogicBase.getTimer();
            }
            case 31: {
                return pSSysCalendarLogicBase.getTriggerType();
            }
            case 32: {
                return pSSysCalendarLogicBase.getUpdateDate();
            }
            case 33: {
                return pSSysCalendarLogicBase.getUpdateMan();
            }
            case 34: {
                return pSSysCalendarLogicBase.getUserCat();
            }
            case 35: {
                return pSSysCalendarLogicBase.getUserTag();
            }
            case 36: {
                return pSSysCalendarLogicBase.getUserTag2();
            }
            case 37: {
                return pSSysCalendarLogicBase.getUserTag3();
            }
            case 38: {
                return pSSysCalendarLogicBase.getUserTag4();
            }
            case 39: {
                return pSSysCalendarLogicBase.getValidFlag();
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
        PSSysCalendarLogicBase.set(this, n, object);
    }

    private static void set(PSSysCalendarLogicBase pSSysCalendarLogicBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysCalendarLogicBase.setAttrName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysCalendarLogicBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysCalendarLogicBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysCalendarLogicBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysCalendarLogicBase.setDstLogicType(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysCalendarLogicBase.setEventArg(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysCalendarLogicBase.setEventArg2(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysCalendarLogicBase.setEventNames(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysCalendarLogicBase.setLogicParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysCalendarLogicBase.setLogicParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysCalendarLogicBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysCalendarLogicBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSSysCalendarLogicBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysCalendarLogicBase.setPSDELogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysCalendarLogicBase.setPSDELogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysCalendarLogicBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysCalendarLogicBase.setPSDEUIActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysCalendarLogicBase.setPSDEUIActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysCalendarLogicBase.setPSSysCalendarId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysCalendarLogicBase.setPSSysCalendarItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysCalendarLogicBase.setPSSysCalendarItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysCalendarLogicBase.setPSSysCalendarLogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysCalendarLogicBase.setPSSysCalendarLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysCalendarLogicBase.setPSSysCalendarName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysCalendarLogicBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysCalendarLogicBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysCalendarLogicBase.setPSSysViewLogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysCalendarLogicBase.setPSSysViewLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysCalendarLogicBase.setPSSysViewPanelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSysCalendarLogicBase.setPSSysViewPanelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSysCalendarLogicBase.setTimer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 31: {
                pSSysCalendarLogicBase.setTriggerType(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSysCalendarLogicBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 33: {
                pSSysCalendarLogicBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSSysCalendarLogicBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSSysCalendarLogicBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSSysCalendarLogicBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSSysCalendarLogicBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSSysCalendarLogicBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSSysCalendarLogicBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSysCalendarLogicBase.isNull(this, n);
    }

    private static boolean isNull(PSSysCalendarLogicBase pSSysCalendarLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysCalendarLogicBase.getAttrName() == null;
            }
            case 1: {
                return pSSysCalendarLogicBase.getCreateDate() == null;
            }
            case 2: {
                return pSSysCalendarLogicBase.getCreateMan() == null;
            }
            case 3: {
                return pSSysCalendarLogicBase.getCustomCode() == null;
            }
            case 4: {
                return pSSysCalendarLogicBase.getDstLogicType() == null;
            }
            case 5: {
                return pSSysCalendarLogicBase.getEventArg() == null;
            }
            case 6: {
                return pSSysCalendarLogicBase.getEventArg2() == null;
            }
            case 7: {
                return pSSysCalendarLogicBase.getEventNames() == null;
            }
            case 8: {
                return pSSysCalendarLogicBase.getLogicParam() == null;
            }
            case 9: {
                return pSSysCalendarLogicBase.getLogicParam2() == null;
            }
            case 10: {
                return pSSysCalendarLogicBase.getMemo() == null;
            }
            case 11: {
                return pSSysCalendarLogicBase.getOrderValue() == null;
            }
            case 12: {
                return pSSysCalendarLogicBase.getPSDEId() == null;
            }
            case 13: {
                return pSSysCalendarLogicBase.getPSDELogicId() == null;
            }
            case 14: {
                return pSSysCalendarLogicBase.getPSDELogicName() == null;
            }
            case 15: {
                return pSSysCalendarLogicBase.getPSDEName() == null;
            }
            case 16: {
                return pSSysCalendarLogicBase.getPSDEUIActionId() == null;
            }
            case 17: {
                return pSSysCalendarLogicBase.getPSDEUIActionName() == null;
            }
            case 18: {
                return pSSysCalendarLogicBase.getPSSysCalendarId() == null;
            }
            case 19: {
                return pSSysCalendarLogicBase.getPSSysCalendarItemId() == null;
            }
            case 20: {
                return pSSysCalendarLogicBase.getPSSysCalendarItemName() == null;
            }
            case 21: {
                return pSSysCalendarLogicBase.getPSSysCalendarLogicId() == null;
            }
            case 22: {
                return pSSysCalendarLogicBase.getPSSysCalendarLogicName() == null;
            }
            case 23: {
                return pSSysCalendarLogicBase.getPSSysCalendarName() == null;
            }
            case 24: {
                return pSSysCalendarLogicBase.getPSSysPFPluginId() == null;
            }
            case 25: {
                return pSSysCalendarLogicBase.getPSSysPFPluginName() == null;
            }
            case 26: {
                return pSSysCalendarLogicBase.getPSSysViewLogicId() == null;
            }
            case 27: {
                return pSSysCalendarLogicBase.getPSSysViewLogicName() == null;
            }
            case 28: {
                return pSSysCalendarLogicBase.getPSSysViewPanelId() == null;
            }
            case 29: {
                return pSSysCalendarLogicBase.getPSSysViewPanelName() == null;
            }
            case 30: {
                return pSSysCalendarLogicBase.getTimer() == null;
            }
            case 31: {
                return pSSysCalendarLogicBase.getTriggerType() == null;
            }
            case 32: {
                return pSSysCalendarLogicBase.getUpdateDate() == null;
            }
            case 33: {
                return pSSysCalendarLogicBase.getUpdateMan() == null;
            }
            case 34: {
                return pSSysCalendarLogicBase.getUserCat() == null;
            }
            case 35: {
                return pSSysCalendarLogicBase.getUserTag() == null;
            }
            case 36: {
                return pSSysCalendarLogicBase.getUserTag2() == null;
            }
            case 37: {
                return pSSysCalendarLogicBase.getUserTag3() == null;
            }
            case 38: {
                return pSSysCalendarLogicBase.getUserTag4() == null;
            }
            case 39: {
                return pSSysCalendarLogicBase.getValidFlag() == null;
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
        return PSSysCalendarLogicBase.contains(this, n);
    }

    private static boolean contains(PSSysCalendarLogicBase pSSysCalendarLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysCalendarLogicBase.isAttrNameDirty();
            }
            case 1: {
                return pSSysCalendarLogicBase.isCreateDateDirty();
            }
            case 2: {
                return pSSysCalendarLogicBase.isCreateManDirty();
            }
            case 3: {
                return pSSysCalendarLogicBase.isCustomCodeDirty();
            }
            case 4: {
                return pSSysCalendarLogicBase.isDstLogicTypeDirty();
            }
            case 5: {
                return pSSysCalendarLogicBase.isEventArgDirty();
            }
            case 6: {
                return pSSysCalendarLogicBase.isEventArg2Dirty();
            }
            case 7: {
                return pSSysCalendarLogicBase.isEventNamesDirty();
            }
            case 8: {
                return pSSysCalendarLogicBase.isLogicParamDirty();
            }
            case 9: {
                return pSSysCalendarLogicBase.isLogicParam2Dirty();
            }
            case 10: {
                return pSSysCalendarLogicBase.isMemoDirty();
            }
            case 11: {
                return pSSysCalendarLogicBase.isOrderValueDirty();
            }
            case 12: {
                return pSSysCalendarLogicBase.isPSDEIdDirty();
            }
            case 13: {
                return pSSysCalendarLogicBase.isPSDELogicIdDirty();
            }
            case 14: {
                return pSSysCalendarLogicBase.isPSDELogicNameDirty();
            }
            case 15: {
                return pSSysCalendarLogicBase.isPSDENameDirty();
            }
            case 16: {
                return pSSysCalendarLogicBase.isPSDEUIActionIdDirty();
            }
            case 17: {
                return pSSysCalendarLogicBase.isPSDEUIActionNameDirty();
            }
            case 18: {
                return pSSysCalendarLogicBase.isPSSysCalendarIdDirty();
            }
            case 19: {
                return pSSysCalendarLogicBase.isPSSysCalendarItemIdDirty();
            }
            case 20: {
                return pSSysCalendarLogicBase.isPSSysCalendarItemNameDirty();
            }
            case 21: {
                return pSSysCalendarLogicBase.isPSSysCalendarLogicIdDirty();
            }
            case 22: {
                return pSSysCalendarLogicBase.isPSSysCalendarLogicNameDirty();
            }
            case 23: {
                return pSSysCalendarLogicBase.isPSSysCalendarNameDirty();
            }
            case 24: {
                return pSSysCalendarLogicBase.isPSSysPFPluginIdDirty();
            }
            case 25: {
                return pSSysCalendarLogicBase.isPSSysPFPluginNameDirty();
            }
            case 26: {
                return pSSysCalendarLogicBase.isPSSysViewLogicIdDirty();
            }
            case 27: {
                return pSSysCalendarLogicBase.isPSSysViewLogicNameDirty();
            }
            case 28: {
                return pSSysCalendarLogicBase.isPSSysViewPanelIdDirty();
            }
            case 29: {
                return pSSysCalendarLogicBase.isPSSysViewPanelNameDirty();
            }
            case 30: {
                return pSSysCalendarLogicBase.isTimerDirty();
            }
            case 31: {
                return pSSysCalendarLogicBase.isTriggerTypeDirty();
            }
            case 32: {
                return pSSysCalendarLogicBase.isUpdateDateDirty();
            }
            case 33: {
                return pSSysCalendarLogicBase.isUpdateManDirty();
            }
            case 34: {
                return pSSysCalendarLogicBase.isUserCatDirty();
            }
            case 35: {
                return pSSysCalendarLogicBase.isUserTagDirty();
            }
            case 36: {
                return pSSysCalendarLogicBase.isUserTag2Dirty();
            }
            case 37: {
                return pSSysCalendarLogicBase.isUserTag3Dirty();
            }
            case 38: {
                return pSSysCalendarLogicBase.isUserTag4Dirty();
            }
            case 39: {
                return pSSysCalendarLogicBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysCalendarLogicBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysCalendarLogicBase pSSysCalendarLogicBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysCalendarLogicBase.getAttrName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"attrname", (Object)PSSysCalendarLogicBase.getJSONValue((Object)pSSysCalendarLogicBase.getAttrName()), (boolean)false);
        }
        if (bl || pSSysCalendarLogicBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysCalendarLogicBase.getJSONValue((Object)pSSysCalendarLogicBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysCalendarLogicBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysCalendarLogicBase.getJSONValue((Object)pSSysCalendarLogicBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysCalendarLogicBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSSysCalendarLogicBase.getJSONValue((Object)pSSysCalendarLogicBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSSysCalendarLogicBase.getDstLogicType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstlogictype", (Object)PSSysCalendarLogicBase.getJSONValue((Object)pSSysCalendarLogicBase.getDstLogicType()), (boolean)false);
        }
        if (bl || pSSysCalendarLogicBase.getEventArg() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eventarg", (Object)PSSysCalendarLogicBase.getJSONValue((Object)pSSysCalendarLogicBase.getEventArg()), (boolean)false);
        }
        if (bl || pSSysCalendarLogicBase.getEventArg2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eventarg2", (Object)PSSysCalendarLogicBase.getJSONValue((Object)pSSysCalendarLogicBase.getEventArg2()), (boolean)false);
        }
        if (bl || pSSysCalendarLogicBase.getEventNames() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eventnames", (Object)PSSysCalendarLogicBase.getJSONValue((Object)pSSysCalendarLogicBase.getEventNames()), (boolean)false);
        }
        if (bl || pSSysCalendarLogicBase.getLogicParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicparam", (Object)PSSysCalendarLogicBase.getJSONValue((Object)pSSysCalendarLogicBase.getLogicParam()), (boolean)false);
        }
        if (bl || pSSysCalendarLogicBase.getLogicParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicparam2", (Object)PSSysCalendarLogicBase.getJSONValue((Object)pSSysCalendarLogicBase.getLogicParam2()), (boolean)false);
        }
        if (bl || pSSysCalendarLogicBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysCalendarLogicBase.getJSONValue((Object)pSSysCalendarLogicBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysCalendarLogicBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSysCalendarLogicBase.getJSONValue((Object)pSSysCalendarLogicBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSysCalendarLogicBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSSysCalendarLogicBase.getJSONValue((Object)pSSysCalendarLogicBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSSysCalendarLogicBase.getPSDELogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicid", (Object)PSSysCalendarLogicBase.getJSONValue((Object)pSSysCalendarLogicBase.getPSDELogicId()), (boolean)false);
        }
        if (bl || pSSysCalendarLogicBase.getPSDELogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicname", (Object)PSSysCalendarLogicBase.getJSONValue((Object)pSSysCalendarLogicBase.getPSDELogicName()), (boolean)false);
        }
        if (bl || pSSysCalendarLogicBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSSysCalendarLogicBase.getJSONValue((Object)pSSysCalendarLogicBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSSysCalendarLogicBase.getPSDEUIActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuiactionid", (Object)PSSysCalendarLogicBase.getJSONValue((Object)pSSysCalendarLogicBase.getPSDEUIActionId()), (boolean)false);
        }
        if (bl || pSSysCalendarLogicBase.getPSDEUIActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuiactionname", (Object)PSSysCalendarLogicBase.getJSONValue((Object)pSSysCalendarLogicBase.getPSDEUIActionName()), (boolean)false);
        }
        if (bl || pSSysCalendarLogicBase.getPSSysCalendarId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscalendarid", (Object)PSSysCalendarLogicBase.getJSONValue((Object)pSSysCalendarLogicBase.getPSSysCalendarId()), (boolean)false);
        }
        if (bl || pSSysCalendarLogicBase.getPSSysCalendarItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscalendaritemid", (Object)PSSysCalendarLogicBase.getJSONValue((Object)pSSysCalendarLogicBase.getPSSysCalendarItemId()), (boolean)false);
        }
        if (bl || pSSysCalendarLogicBase.getPSSysCalendarItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscalendaritemname", (Object)PSSysCalendarLogicBase.getJSONValue((Object)pSSysCalendarLogicBase.getPSSysCalendarItemName()), (boolean)false);
        }
        if (bl || pSSysCalendarLogicBase.getPSSysCalendarLogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscalendarlogicid", (Object)PSSysCalendarLogicBase.getJSONValue((Object)pSSysCalendarLogicBase.getPSSysCalendarLogicId()), (boolean)false);
        }
        if (bl || pSSysCalendarLogicBase.getPSSysCalendarLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscalendarlogicname", (Object)PSSysCalendarLogicBase.getJSONValue((Object)pSSysCalendarLogicBase.getPSSysCalendarLogicName()), (boolean)false);
        }
        if (bl || pSSysCalendarLogicBase.getPSSysCalendarName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscalendarname", (Object)PSSysCalendarLogicBase.getJSONValue((Object)pSSysCalendarLogicBase.getPSSysCalendarName()), (boolean)false);
        }
        if (bl || pSSysCalendarLogicBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSSysCalendarLogicBase.getJSONValue((Object)pSSysCalendarLogicBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSSysCalendarLogicBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSSysCalendarLogicBase.getJSONValue((Object)pSSysCalendarLogicBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSSysCalendarLogicBase.getPSSysViewLogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewlogicid", (Object)PSSysCalendarLogicBase.getJSONValue((Object)pSSysCalendarLogicBase.getPSSysViewLogicId()), (boolean)false);
        }
        if (bl || pSSysCalendarLogicBase.getPSSysViewLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewlogicname", (Object)PSSysCalendarLogicBase.getJSONValue((Object)pSSysCalendarLogicBase.getPSSysViewLogicName()), (boolean)false);
        }
        if (bl || pSSysCalendarLogicBase.getPSSysViewPanelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelid", (Object)PSSysCalendarLogicBase.getJSONValue((Object)pSSysCalendarLogicBase.getPSSysViewPanelId()), (boolean)false);
        }
        if (bl || pSSysCalendarLogicBase.getPSSysViewPanelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelname", (Object)PSSysCalendarLogicBase.getJSONValue((Object)pSSysCalendarLogicBase.getPSSysViewPanelName()), (boolean)false);
        }
        if (bl || pSSysCalendarLogicBase.getTimer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"timer", (Object)PSSysCalendarLogicBase.getJSONValue((Object)pSSysCalendarLogicBase.getTimer()), (boolean)false);
        }
        if (bl || pSSysCalendarLogicBase.getTriggerType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"triggertype", (Object)PSSysCalendarLogicBase.getJSONValue((Object)pSSysCalendarLogicBase.getTriggerType()), (boolean)false);
        }
        if (bl || pSSysCalendarLogicBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysCalendarLogicBase.getJSONValue((Object)pSSysCalendarLogicBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysCalendarLogicBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysCalendarLogicBase.getJSONValue((Object)pSSysCalendarLogicBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysCalendarLogicBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysCalendarLogicBase.getJSONValue((Object)pSSysCalendarLogicBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysCalendarLogicBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysCalendarLogicBase.getJSONValue((Object)pSSysCalendarLogicBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysCalendarLogicBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysCalendarLogicBase.getJSONValue((Object)pSSysCalendarLogicBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysCalendarLogicBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysCalendarLogicBase.getJSONValue((Object)pSSysCalendarLogicBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysCalendarLogicBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysCalendarLogicBase.getJSONValue((Object)pSSysCalendarLogicBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysCalendarLogicBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysCalendarLogicBase.getJSONValue((Object)pSSysCalendarLogicBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysCalendarLogicBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysCalendarLogicBase pSSysCalendarLogicBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysCalendarLogicBase.getAttrName() != null) {
            object = pSSysCalendarLogicBase.getAttrName();
            xmlNode.setAttribute(FIELD_ATTRNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarLogicBase.getCreateDate() != null) {
            object = pSSysCalendarLogicBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysCalendarLogicBase.getCreateMan() != null) {
            object = pSSysCalendarLogicBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarLogicBase.getCustomCode() != null) {
            object = pSSysCalendarLogicBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarLogicBase.getDstLogicType() != null) {
            object = pSSysCalendarLogicBase.getDstLogicType();
            xmlNode.setAttribute(FIELD_DSTLOGICTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarLogicBase.getEventArg() != null) {
            object = pSSysCalendarLogicBase.getEventArg();
            xmlNode.setAttribute(FIELD_EVENTARG, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarLogicBase.getEventArg2() != null) {
            object = pSSysCalendarLogicBase.getEventArg2();
            xmlNode.setAttribute(FIELD_EVENTARG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarLogicBase.getEventNames() != null) {
            object = pSSysCalendarLogicBase.getEventNames();
            xmlNode.setAttribute(FIELD_EVENTNAMES, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarLogicBase.getLogicParam() != null) {
            object = pSSysCalendarLogicBase.getLogicParam();
            xmlNode.setAttribute(FIELD_LOGICPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarLogicBase.getLogicParam2() != null) {
            object = pSSysCalendarLogicBase.getLogicParam2();
            xmlNode.setAttribute(FIELD_LOGICPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarLogicBase.getMemo() != null) {
            object = pSSysCalendarLogicBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarLogicBase.getOrderValue() != null) {
            object = pSSysCalendarLogicBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysCalendarLogicBase.getPSDEId() != null) {
            object = pSSysCalendarLogicBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarLogicBase.getPSDELogicId() != null) {
            object = pSSysCalendarLogicBase.getPSDELogicId();
            xmlNode.setAttribute(FIELD_PSDELOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarLogicBase.getPSDELogicName() != null) {
            object = pSSysCalendarLogicBase.getPSDELogicName();
            xmlNode.setAttribute(FIELD_PSDELOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarLogicBase.getPSDEName() != null) {
            object = pSSysCalendarLogicBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarLogicBase.getPSDEUIActionId() != null) {
            object = pSSysCalendarLogicBase.getPSDEUIActionId();
            xmlNode.setAttribute(FIELD_PSDEUIACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarLogicBase.getPSDEUIActionName() != null) {
            object = pSSysCalendarLogicBase.getPSDEUIActionName();
            xmlNode.setAttribute(FIELD_PSDEUIACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarLogicBase.getPSSysCalendarId() != null) {
            object = pSSysCalendarLogicBase.getPSSysCalendarId();
            xmlNode.setAttribute(FIELD_PSSYSCALENDARID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarLogicBase.getPSSysCalendarItemId() != null) {
            object = pSSysCalendarLogicBase.getPSSysCalendarItemId();
            xmlNode.setAttribute(FIELD_PSSYSCALENDARITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarLogicBase.getPSSysCalendarItemName() != null) {
            object = pSSysCalendarLogicBase.getPSSysCalendarItemName();
            xmlNode.setAttribute(FIELD_PSSYSCALENDARITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarLogicBase.getPSSysCalendarLogicId() != null) {
            object = pSSysCalendarLogicBase.getPSSysCalendarLogicId();
            xmlNode.setAttribute(FIELD_PSSYSCALENDARLOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarLogicBase.getPSSysCalendarLogicName() != null) {
            object = pSSysCalendarLogicBase.getPSSysCalendarLogicName();
            xmlNode.setAttribute(FIELD_PSSYSCALENDARLOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarLogicBase.getPSSysCalendarName() != null) {
            object = pSSysCalendarLogicBase.getPSSysCalendarName();
            xmlNode.setAttribute(FIELD_PSSYSCALENDARNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarLogicBase.getPSSysPFPluginId() != null) {
            object = pSSysCalendarLogicBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarLogicBase.getPSSysPFPluginName() != null) {
            object = pSSysCalendarLogicBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarLogicBase.getPSSysViewLogicId() != null) {
            object = pSSysCalendarLogicBase.getPSSysViewLogicId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWLOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarLogicBase.getPSSysViewLogicName() != null) {
            object = pSSysCalendarLogicBase.getPSSysViewLogicName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWLOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarLogicBase.getPSSysViewPanelId() != null) {
            object = pSSysCalendarLogicBase.getPSSysViewPanelId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarLogicBase.getPSSysViewPanelName() != null) {
            object = pSSysCalendarLogicBase.getPSSysViewPanelName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarLogicBase.getTimer() != null) {
            object = pSSysCalendarLogicBase.getTimer();
            xmlNode.setAttribute(FIELD_TIMER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysCalendarLogicBase.getTriggerType() != null) {
            object = pSSysCalendarLogicBase.getTriggerType();
            xmlNode.setAttribute(FIELD_TRIGGERTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarLogicBase.getUpdateDate() != null) {
            object = pSSysCalendarLogicBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysCalendarLogicBase.getUpdateMan() != null) {
            object = pSSysCalendarLogicBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarLogicBase.getUserCat() != null) {
            object = pSSysCalendarLogicBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarLogicBase.getUserTag() != null) {
            object = pSSysCalendarLogicBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarLogicBase.getUserTag2() != null) {
            object = pSSysCalendarLogicBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarLogicBase.getUserTag3() != null) {
            object = pSSysCalendarLogicBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarLogicBase.getUserTag4() != null) {
            object = pSSysCalendarLogicBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarLogicBase.getValidFlag() != null) {
            object = pSSysCalendarLogicBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysCalendarLogicBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysCalendarLogicBase pSSysCalendarLogicBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysCalendarLogicBase.isAttrNameDirty() && (bl || pSSysCalendarLogicBase.getAttrName() != null)) {
            iDataObject.set(FIELD_ATTRNAME, (Object)pSSysCalendarLogicBase.getAttrName());
        }
        if (pSSysCalendarLogicBase.isCreateDateDirty() && (bl || pSSysCalendarLogicBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysCalendarLogicBase.getCreateDate());
        }
        if (pSSysCalendarLogicBase.isCreateManDirty() && (bl || pSSysCalendarLogicBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysCalendarLogicBase.getCreateMan());
        }
        if (pSSysCalendarLogicBase.isCustomCodeDirty() && (bl || pSSysCalendarLogicBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSSysCalendarLogicBase.getCustomCode());
        }
        if (pSSysCalendarLogicBase.isDstLogicTypeDirty() && (bl || pSSysCalendarLogicBase.getDstLogicType() != null)) {
            iDataObject.set(FIELD_DSTLOGICTYPE, (Object)pSSysCalendarLogicBase.getDstLogicType());
        }
        if (pSSysCalendarLogicBase.isEventArgDirty() && (bl || pSSysCalendarLogicBase.getEventArg() != null)) {
            iDataObject.set(FIELD_EVENTARG, (Object)pSSysCalendarLogicBase.getEventArg());
        }
        if (pSSysCalendarLogicBase.isEventArg2Dirty() && (bl || pSSysCalendarLogicBase.getEventArg2() != null)) {
            iDataObject.set(FIELD_EVENTARG2, (Object)pSSysCalendarLogicBase.getEventArg2());
        }
        if (pSSysCalendarLogicBase.isEventNamesDirty() && (bl || pSSysCalendarLogicBase.getEventNames() != null)) {
            iDataObject.set(FIELD_EVENTNAMES, (Object)pSSysCalendarLogicBase.getEventNames());
        }
        if (pSSysCalendarLogicBase.isLogicParamDirty() && (bl || pSSysCalendarLogicBase.getLogicParam() != null)) {
            iDataObject.set(FIELD_LOGICPARAM, (Object)pSSysCalendarLogicBase.getLogicParam());
        }
        if (pSSysCalendarLogicBase.isLogicParam2Dirty() && (bl || pSSysCalendarLogicBase.getLogicParam2() != null)) {
            iDataObject.set(FIELD_LOGICPARAM2, (Object)pSSysCalendarLogicBase.getLogicParam2());
        }
        if (pSSysCalendarLogicBase.isMemoDirty() && (bl || pSSysCalendarLogicBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysCalendarLogicBase.getMemo());
        }
        if (pSSysCalendarLogicBase.isOrderValueDirty() && (bl || pSSysCalendarLogicBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSysCalendarLogicBase.getOrderValue());
        }
        if (pSSysCalendarLogicBase.isPSDEIdDirty() && (bl || pSSysCalendarLogicBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSSysCalendarLogicBase.getPSDEId());
        }
        if (pSSysCalendarLogicBase.isPSDELogicIdDirty() && (bl || pSSysCalendarLogicBase.getPSDELogicId() != null)) {
            iDataObject.set(FIELD_PSDELOGICID, (Object)pSSysCalendarLogicBase.getPSDELogicId());
        }
        if (pSSysCalendarLogicBase.isPSDELogicNameDirty() && (bl || pSSysCalendarLogicBase.getPSDELogicName() != null)) {
            iDataObject.set(FIELD_PSDELOGICNAME, (Object)pSSysCalendarLogicBase.getPSDELogicName());
        }
        if (pSSysCalendarLogicBase.isPSDENameDirty() && (bl || pSSysCalendarLogicBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSSysCalendarLogicBase.getPSDEName());
        }
        if (pSSysCalendarLogicBase.isPSDEUIActionIdDirty() && (bl || pSSysCalendarLogicBase.getPSDEUIActionId() != null)) {
            iDataObject.set(FIELD_PSDEUIACTIONID, (Object)pSSysCalendarLogicBase.getPSDEUIActionId());
        }
        if (pSSysCalendarLogicBase.isPSDEUIActionNameDirty() && (bl || pSSysCalendarLogicBase.getPSDEUIActionName() != null)) {
            iDataObject.set(FIELD_PSDEUIACTIONNAME, (Object)pSSysCalendarLogicBase.getPSDEUIActionName());
        }
        if (pSSysCalendarLogicBase.isPSSysCalendarIdDirty() && (bl || pSSysCalendarLogicBase.getPSSysCalendarId() != null)) {
            iDataObject.set(FIELD_PSSYSCALENDARID, (Object)pSSysCalendarLogicBase.getPSSysCalendarId());
        }
        if (pSSysCalendarLogicBase.isPSSysCalendarItemIdDirty() && (bl || pSSysCalendarLogicBase.getPSSysCalendarItemId() != null)) {
            iDataObject.set(FIELD_PSSYSCALENDARITEMID, (Object)pSSysCalendarLogicBase.getPSSysCalendarItemId());
        }
        if (pSSysCalendarLogicBase.isPSSysCalendarItemNameDirty() && (bl || pSSysCalendarLogicBase.getPSSysCalendarItemName() != null)) {
            iDataObject.set(FIELD_PSSYSCALENDARITEMNAME, (Object)pSSysCalendarLogicBase.getPSSysCalendarItemName());
        }
        if (pSSysCalendarLogicBase.isPSSysCalendarLogicIdDirty() && (bl || pSSysCalendarLogicBase.getPSSysCalendarLogicId() != null)) {
            iDataObject.set(FIELD_PSSYSCALENDARLOGICID, (Object)pSSysCalendarLogicBase.getPSSysCalendarLogicId());
        }
        if (pSSysCalendarLogicBase.isPSSysCalendarLogicNameDirty() && (bl || pSSysCalendarLogicBase.getPSSysCalendarLogicName() != null)) {
            iDataObject.set(FIELD_PSSYSCALENDARLOGICNAME, (Object)pSSysCalendarLogicBase.getPSSysCalendarLogicName());
        }
        if (pSSysCalendarLogicBase.isPSSysCalendarNameDirty() && (bl || pSSysCalendarLogicBase.getPSSysCalendarName() != null)) {
            iDataObject.set(FIELD_PSSYSCALENDARNAME, (Object)pSSysCalendarLogicBase.getPSSysCalendarName());
        }
        if (pSSysCalendarLogicBase.isPSSysPFPluginIdDirty() && (bl || pSSysCalendarLogicBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSSysCalendarLogicBase.getPSSysPFPluginId());
        }
        if (pSSysCalendarLogicBase.isPSSysPFPluginNameDirty() && (bl || pSSysCalendarLogicBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSSysCalendarLogicBase.getPSSysPFPluginName());
        }
        if (pSSysCalendarLogicBase.isPSSysViewLogicIdDirty() && (bl || pSSysCalendarLogicBase.getPSSysViewLogicId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWLOGICID, (Object)pSSysCalendarLogicBase.getPSSysViewLogicId());
        }
        if (pSSysCalendarLogicBase.isPSSysViewLogicNameDirty() && (bl || pSSysCalendarLogicBase.getPSSysViewLogicName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWLOGICNAME, (Object)pSSysCalendarLogicBase.getPSSysViewLogicName());
        }
        if (pSSysCalendarLogicBase.isPSSysViewPanelIdDirty() && (bl || pSSysCalendarLogicBase.getPSSysViewPanelId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELID, (Object)pSSysCalendarLogicBase.getPSSysViewPanelId());
        }
        if (pSSysCalendarLogicBase.isPSSysViewPanelNameDirty() && (bl || pSSysCalendarLogicBase.getPSSysViewPanelName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELNAME, (Object)pSSysCalendarLogicBase.getPSSysViewPanelName());
        }
        if (pSSysCalendarLogicBase.isTimerDirty() && (bl || pSSysCalendarLogicBase.getTimer() != null)) {
            iDataObject.set(FIELD_TIMER, (Object)pSSysCalendarLogicBase.getTimer());
        }
        if (pSSysCalendarLogicBase.isTriggerTypeDirty() && (bl || pSSysCalendarLogicBase.getTriggerType() != null)) {
            iDataObject.set(FIELD_TRIGGERTYPE, (Object)pSSysCalendarLogicBase.getTriggerType());
        }
        if (pSSysCalendarLogicBase.isUpdateDateDirty() && (bl || pSSysCalendarLogicBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysCalendarLogicBase.getUpdateDate());
        }
        if (pSSysCalendarLogicBase.isUpdateManDirty() && (bl || pSSysCalendarLogicBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysCalendarLogicBase.getUpdateMan());
        }
        if (pSSysCalendarLogicBase.isUserCatDirty() && (bl || pSSysCalendarLogicBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysCalendarLogicBase.getUserCat());
        }
        if (pSSysCalendarLogicBase.isUserTagDirty() && (bl || pSSysCalendarLogicBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysCalendarLogicBase.getUserTag());
        }
        if (pSSysCalendarLogicBase.isUserTag2Dirty() && (bl || pSSysCalendarLogicBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysCalendarLogicBase.getUserTag2());
        }
        if (pSSysCalendarLogicBase.isUserTag3Dirty() && (bl || pSSysCalendarLogicBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysCalendarLogicBase.getUserTag3());
        }
        if (pSSysCalendarLogicBase.isUserTag4Dirty() && (bl || pSSysCalendarLogicBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysCalendarLogicBase.getUserTag4());
        }
        if (pSSysCalendarLogicBase.isValidFlagDirty() && (bl || pSSysCalendarLogicBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysCalendarLogicBase.getValidFlag());
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
        return PSSysCalendarLogicBase.remove(this, n);
    }

    private static boolean remove(PSSysCalendarLogicBase pSSysCalendarLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysCalendarLogicBase.resetAttrName();
                return true;
            }
            case 1: {
                pSSysCalendarLogicBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSysCalendarLogicBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSysCalendarLogicBase.resetCustomCode();
                return true;
            }
            case 4: {
                pSSysCalendarLogicBase.resetDstLogicType();
                return true;
            }
            case 5: {
                pSSysCalendarLogicBase.resetEventArg();
                return true;
            }
            case 6: {
                pSSysCalendarLogicBase.resetEventArg2();
                return true;
            }
            case 7: {
                pSSysCalendarLogicBase.resetEventNames();
                return true;
            }
            case 8: {
                pSSysCalendarLogicBase.resetLogicParam();
                return true;
            }
            case 9: {
                pSSysCalendarLogicBase.resetLogicParam2();
                return true;
            }
            case 10: {
                pSSysCalendarLogicBase.resetMemo();
                return true;
            }
            case 11: {
                pSSysCalendarLogicBase.resetOrderValue();
                return true;
            }
            case 12: {
                pSSysCalendarLogicBase.resetPSDEId();
                return true;
            }
            case 13: {
                pSSysCalendarLogicBase.resetPSDELogicId();
                return true;
            }
            case 14: {
                pSSysCalendarLogicBase.resetPSDELogicName();
                return true;
            }
            case 15: {
                pSSysCalendarLogicBase.resetPSDEName();
                return true;
            }
            case 16: {
                pSSysCalendarLogicBase.resetPSDEUIActionId();
                return true;
            }
            case 17: {
                pSSysCalendarLogicBase.resetPSDEUIActionName();
                return true;
            }
            case 18: {
                pSSysCalendarLogicBase.resetPSSysCalendarId();
                return true;
            }
            case 19: {
                pSSysCalendarLogicBase.resetPSSysCalendarItemId();
                return true;
            }
            case 20: {
                pSSysCalendarLogicBase.resetPSSysCalendarItemName();
                return true;
            }
            case 21: {
                pSSysCalendarLogicBase.resetPSSysCalendarLogicId();
                return true;
            }
            case 22: {
                pSSysCalendarLogicBase.resetPSSysCalendarLogicName();
                return true;
            }
            case 23: {
                pSSysCalendarLogicBase.resetPSSysCalendarName();
                return true;
            }
            case 24: {
                pSSysCalendarLogicBase.resetPSSysPFPluginId();
                return true;
            }
            case 25: {
                pSSysCalendarLogicBase.resetPSSysPFPluginName();
                return true;
            }
            case 26: {
                pSSysCalendarLogicBase.resetPSSysViewLogicId();
                return true;
            }
            case 27: {
                pSSysCalendarLogicBase.resetPSSysViewLogicName();
                return true;
            }
            case 28: {
                pSSysCalendarLogicBase.resetPSSysViewPanelId();
                return true;
            }
            case 29: {
                pSSysCalendarLogicBase.resetPSSysViewPanelName();
                return true;
            }
            case 30: {
                pSSysCalendarLogicBase.resetTimer();
                return true;
            }
            case 31: {
                pSSysCalendarLogicBase.resetTriggerType();
                return true;
            }
            case 32: {
                pSSysCalendarLogicBase.resetUpdateDate();
                return true;
            }
            case 33: {
                pSSysCalendarLogicBase.resetUpdateMan();
                return true;
            }
            case 34: {
                pSSysCalendarLogicBase.resetUserCat();
                return true;
            }
            case 35: {
                pSSysCalendarLogicBase.resetUserTag();
                return true;
            }
            case 36: {
                pSSysCalendarLogicBase.resetUserTag2();
                return true;
            }
            case 37: {
                pSSysCalendarLogicBase.resetUserTag3();
                return true;
            }
            case 38: {
                pSSysCalendarLogicBase.resetUserTag4();
                return true;
            }
            case 39: {
                pSSysCalendarLogicBase.resetValidFlag();
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
    public PSSysCalendarItem getPSSysCalendarItem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCalendarItem();
        }
        if (this.getPSSysCalendarItemId() == null) {
            return null;
        }
        Integer n = this.objPSSysCalendarItemLock;
        synchronized (n) {
            if (this.pssyscalendaritem != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysCalendarItemId(), (Object)this.pssyscalendaritem.getPSSysCalendarItemId()) != 0L) {
                this.pssyscalendaritem = null;
            }
            if (this.pssyscalendaritem == null) {
                PSSysCalendarItem pSSysCalendarItem = new PSSysCalendarItem();
                pSSysCalendarItem.setPSSysCalendarItemId(this.getPSSysCalendarItemId());
                PSSysCalendarItemService pSSysCalendarItemService = (PSSysCalendarItemService)ServiceGlobal.getService(PSSysCalendarItemService.class, (SessionFactory)this.getSessionFactory());
                pSSysCalendarItemService.autoGet(pSSysCalendarItem);
                this.pssyscalendaritem = pSSysCalendarItem;
            }
            return this.pssyscalendaritem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysCalendar getPSSysCalendar() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCalendar();
        }
        if (this.getPSSysCalendarId() == null) {
            return null;
        }
        Integer n = this.objPSSysCalendarLock;
        synchronized (n) {
            if (this.pssyscalendar != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysCalendarId(), (Object)this.pssyscalendar.getPSSysCalendarId()) != 0L) {
                this.pssyscalendar = null;
            }
            if (this.pssyscalendar == null) {
                PSSysCalendar pSSysCalendar = new PSSysCalendar();
                pSSysCalendar.setPSSysCalendarId(this.getPSSysCalendarId());
                PSSysCalendarService pSSysCalendarService = (PSSysCalendarService)ServiceGlobal.getService(PSSysCalendarService.class, (SessionFactory)this.getSessionFactory());
                pSSysCalendarService.autoGet(pSSysCalendar);
                this.pssyscalendar = pSSysCalendar;
            }
            return this.pssyscalendar;
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

    private PSSysCalendarLogicBase getProxyEntity() {
        return this.proxyPSSysCalendarLogicBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysCalendarLogicBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysCalendarLogicBase) {
            this.proxyPSSysCalendarLogicBase = (PSSysCalendarLogicBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarLogicService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
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
        fieldIndexMap.put(FIELD_PSDEUIACTIONID, 16);
        fieldIndexMap.put(FIELD_PSDEUIACTIONNAME, 17);
        fieldIndexMap.put(FIELD_PSSYSCALENDARID, 18);
        fieldIndexMap.put(FIELD_PSSYSCALENDARITEMID, 19);
        fieldIndexMap.put(FIELD_PSSYSCALENDARITEMNAME, 20);
        fieldIndexMap.put(FIELD_PSSYSCALENDARLOGICID, 21);
        fieldIndexMap.put(FIELD_PSSYSCALENDARLOGICNAME, 22);
        fieldIndexMap.put(FIELD_PSSYSCALENDARNAME, 23);
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

