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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEList;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEListItem;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEListItemService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEListService;
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

public abstract class PSDEListLogicBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEListLogicBase.class);
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
    public static final String FIELD_PSDELISTID = "PSDELISTID";
    public static final String FIELD_PSDELISTITEMID = "PSDELISTITEMID";
    public static final String FIELD_PSDELISTITEMNAME = "PSDELISTITEMNAME";
    public static final String FIELD_PSDELISTLOGICID = "PSDELISTLOGICID";
    public static final String FIELD_PSDELISTLOGICNAME = "PSDELISTLOGICNAME";
    public static final String FIELD_PSDELISTNAME = "PSDELISTNAME";
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
    private static final int INDEX_PSDEID = 12;
    private static final int INDEX_PSDELISTID = 13;
    private static final int INDEX_PSDELISTITEMID = 14;
    private static final int INDEX_PSDELISTITEMNAME = 15;
    private static final int INDEX_PSDELISTLOGICID = 16;
    private static final int INDEX_PSDELISTLOGICNAME = 17;
    private static final int INDEX_PSDELISTNAME = 18;
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
    private PSDEListLogicBase proxyPSDEListLogicBase = null;
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
    private boolean psdelistidDirtyFlag = false;
    private boolean psdelistitemidDirtyFlag = false;
    private boolean psdelistitemnameDirtyFlag = false;
    private boolean psdelistlogicidDirtyFlag = false;
    private boolean psdelistlogicnameDirtyFlag = false;
    private boolean psdelistnameDirtyFlag = false;
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
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdelistid")
    private String psdelistid;
    @Column(name="psdelistitemid")
    private String psdelistitemid;
    @Column(name="psdelistitemname")
    private String psdelistitemname;
    @Column(name="psdelistlogicid")
    private String psdelistlogicid;
    @Column(name="psdelistlogicname")
    private String psdelistlogicname;
    @Column(name="psdelistname")
    private String psdelistname;
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
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objPSDEListItemLock = new Integer(1);
    private PSDEListItem psdelistitem = null;
    private Integer objPSDEListLock = new Integer(1);
    private PSDEList psdelist = null;
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

    public void setPSDEListId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEListId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdelistid = string;
        this.psdelistidDirtyFlag = true;
    }

    public String getPSDEListId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEListId();
        }
        return this.psdelistid;
    }

    public boolean isPSDEListIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEListIdDirty();
        }
        return this.psdelistidDirtyFlag;
    }

    public void resetPSDEListId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEListId();
            return;
        }
        this.psdelistidDirtyFlag = false;
        this.psdelistid = null;
    }

    public void setPSDEListItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEListItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdelistitemid = string;
        this.psdelistitemidDirtyFlag = true;
    }

    public String getPSDEListItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEListItemId();
        }
        return this.psdelistitemid;
    }

    public boolean isPSDEListItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEListItemIdDirty();
        }
        return this.psdelistitemidDirtyFlag;
    }

    public void resetPSDEListItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEListItemId();
            return;
        }
        this.psdelistitemidDirtyFlag = false;
        this.psdelistitemid = null;
    }

    public void setPSDEListItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEListItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdelistitemname = string;
        this.psdelistitemnameDirtyFlag = true;
    }

    public String getPSDEListItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEListItemName();
        }
        return this.psdelistitemname;
    }

    public boolean isPSDEListItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEListItemNameDirty();
        }
        return this.psdelistitemnameDirtyFlag;
    }

    public void resetPSDEListItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEListItemName();
            return;
        }
        this.psdelistitemnameDirtyFlag = false;
        this.psdelistitemname = null;
    }

    public void setPSDEListLogicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEListLogicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdelistlogicid = string;
        this.psdelistlogicidDirtyFlag = true;
    }

    public String getPSDEListLogicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEListLogicId();
        }
        return this.psdelistlogicid;
    }

    public boolean isPSDEListLogicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEListLogicIdDirty();
        }
        return this.psdelistlogicidDirtyFlag;
    }

    public void resetPSDEListLogicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEListLogicId();
            return;
        }
        this.psdelistlogicidDirtyFlag = false;
        this.psdelistlogicid = null;
    }

    public void setPSDEListLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEListLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdelistlogicname = string;
        this.psdelistlogicnameDirtyFlag = true;
    }

    public String getPSDEListLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEListLogicName();
        }
        return this.psdelistlogicname;
    }

    public boolean isPSDEListLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEListLogicNameDirty();
        }
        return this.psdelistlogicnameDirtyFlag;
    }

    public void resetPSDEListLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEListLogicName();
            return;
        }
        this.psdelistlogicnameDirtyFlag = false;
        this.psdelistlogicname = null;
    }

    public void setPSDEListName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEListName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdelistname = string;
        this.psdelistnameDirtyFlag = true;
    }

    public String getPSDEListName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEListName();
        }
        return this.psdelistname;
    }

    public boolean isPSDEListNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEListNameDirty();
        }
        return this.psdelistnameDirtyFlag;
    }

    public void resetPSDEListName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEListName();
            return;
        }
        this.psdelistnameDirtyFlag = false;
        this.psdelistname = null;
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
        PSDEListLogicBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEListLogicBase pSDEListLogicBase) {
        pSDEListLogicBase.resetAttrName();
        pSDEListLogicBase.resetCreateDate();
        pSDEListLogicBase.resetCreateMan();
        pSDEListLogicBase.resetCustomCode();
        pSDEListLogicBase.resetDstLogicType();
        pSDEListLogicBase.resetEventArg();
        pSDEListLogicBase.resetEventArg2();
        pSDEListLogicBase.resetEventNames();
        pSDEListLogicBase.resetLogicParam();
        pSDEListLogicBase.resetLogicParam2();
        pSDEListLogicBase.resetMemo();
        pSDEListLogicBase.resetOrderValue();
        pSDEListLogicBase.resetPSDEId();
        pSDEListLogicBase.resetPSDEListId();
        pSDEListLogicBase.resetPSDEListItemId();
        pSDEListLogicBase.resetPSDEListItemName();
        pSDEListLogicBase.resetPSDEListLogicId();
        pSDEListLogicBase.resetPSDEListLogicName();
        pSDEListLogicBase.resetPSDEListName();
        pSDEListLogicBase.resetPSDELogicId();
        pSDEListLogicBase.resetPSDELogicName();
        pSDEListLogicBase.resetPSDEName();
        pSDEListLogicBase.resetPSDEUIActionId();
        pSDEListLogicBase.resetPSDEUIActionName();
        pSDEListLogicBase.resetPSSysPFPluginId();
        pSDEListLogicBase.resetPSSysPFPluginName();
        pSDEListLogicBase.resetPSSysViewLogicId();
        pSDEListLogicBase.resetPSSysViewLogicName();
        pSDEListLogicBase.resetPSSysViewPanelId();
        pSDEListLogicBase.resetPSSysViewPanelName();
        pSDEListLogicBase.resetTimer();
        pSDEListLogicBase.resetTriggerType();
        pSDEListLogicBase.resetUpdateDate();
        pSDEListLogicBase.resetUpdateMan();
        pSDEListLogicBase.resetUserCat();
        pSDEListLogicBase.resetUserTag();
        pSDEListLogicBase.resetUserTag2();
        pSDEListLogicBase.resetUserTag3();
        pSDEListLogicBase.resetUserTag4();
        pSDEListLogicBase.resetValidFlag();
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
        if (!bl || this.isPSDEListIdDirty()) {
            hashMap.put(FIELD_PSDELISTID, this.getPSDEListId());
        }
        if (!bl || this.isPSDEListItemIdDirty()) {
            hashMap.put(FIELD_PSDELISTITEMID, this.getPSDEListItemId());
        }
        if (!bl || this.isPSDEListItemNameDirty()) {
            hashMap.put(FIELD_PSDELISTITEMNAME, this.getPSDEListItemName());
        }
        if (!bl || this.isPSDEListLogicIdDirty()) {
            hashMap.put(FIELD_PSDELISTLOGICID, this.getPSDEListLogicId());
        }
        if (!bl || this.isPSDEListLogicNameDirty()) {
            hashMap.put(FIELD_PSDELISTLOGICNAME, this.getPSDEListLogicName());
        }
        if (!bl || this.isPSDEListNameDirty()) {
            hashMap.put(FIELD_PSDELISTNAME, this.getPSDEListName());
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
        return PSDEListLogicBase.get(this, n);
    }

    private static Object get(PSDEListLogicBase pSDEListLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEListLogicBase.getAttrName();
            }
            case 1: {
                return pSDEListLogicBase.getCreateDate();
            }
            case 2: {
                return pSDEListLogicBase.getCreateMan();
            }
            case 3: {
                return pSDEListLogicBase.getCustomCode();
            }
            case 4: {
                return pSDEListLogicBase.getDstLogicType();
            }
            case 5: {
                return pSDEListLogicBase.getEventArg();
            }
            case 6: {
                return pSDEListLogicBase.getEventArg2();
            }
            case 7: {
                return pSDEListLogicBase.getEventNames();
            }
            case 8: {
                return pSDEListLogicBase.getLogicParam();
            }
            case 9: {
                return pSDEListLogicBase.getLogicParam2();
            }
            case 10: {
                return pSDEListLogicBase.getMemo();
            }
            case 11: {
                return pSDEListLogicBase.getOrderValue();
            }
            case 12: {
                return pSDEListLogicBase.getPSDEId();
            }
            case 13: {
                return pSDEListLogicBase.getPSDEListId();
            }
            case 14: {
                return pSDEListLogicBase.getPSDEListItemId();
            }
            case 15: {
                return pSDEListLogicBase.getPSDEListItemName();
            }
            case 16: {
                return pSDEListLogicBase.getPSDEListLogicId();
            }
            case 17: {
                return pSDEListLogicBase.getPSDEListLogicName();
            }
            case 18: {
                return pSDEListLogicBase.getPSDEListName();
            }
            case 19: {
                return pSDEListLogicBase.getPSDELogicId();
            }
            case 20: {
                return pSDEListLogicBase.getPSDELogicName();
            }
            case 21: {
                return pSDEListLogicBase.getPSDEName();
            }
            case 22: {
                return pSDEListLogicBase.getPSDEUIActionId();
            }
            case 23: {
                return pSDEListLogicBase.getPSDEUIActionName();
            }
            case 24: {
                return pSDEListLogicBase.getPSSysPFPluginId();
            }
            case 25: {
                return pSDEListLogicBase.getPSSysPFPluginName();
            }
            case 26: {
                return pSDEListLogicBase.getPSSysViewLogicId();
            }
            case 27: {
                return pSDEListLogicBase.getPSSysViewLogicName();
            }
            case 28: {
                return pSDEListLogicBase.getPSSysViewPanelId();
            }
            case 29: {
                return pSDEListLogicBase.getPSSysViewPanelName();
            }
            case 30: {
                return pSDEListLogicBase.getTimer();
            }
            case 31: {
                return pSDEListLogicBase.getTriggerType();
            }
            case 32: {
                return pSDEListLogicBase.getUpdateDate();
            }
            case 33: {
                return pSDEListLogicBase.getUpdateMan();
            }
            case 34: {
                return pSDEListLogicBase.getUserCat();
            }
            case 35: {
                return pSDEListLogicBase.getUserTag();
            }
            case 36: {
                return pSDEListLogicBase.getUserTag2();
            }
            case 37: {
                return pSDEListLogicBase.getUserTag3();
            }
            case 38: {
                return pSDEListLogicBase.getUserTag4();
            }
            case 39: {
                return pSDEListLogicBase.getValidFlag();
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
        PSDEListLogicBase.set(this, n, object);
    }

    private static void set(PSDEListLogicBase pSDEListLogicBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEListLogicBase.setAttrName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDEListLogicBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDEListLogicBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEListLogicBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEListLogicBase.setDstLogicType(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEListLogicBase.setEventArg(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEListLogicBase.setEventArg2(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEListLogicBase.setEventNames(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEListLogicBase.setLogicParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEListLogicBase.setLogicParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEListLogicBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEListLogicBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSDEListLogicBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEListLogicBase.setPSDEListId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEListLogicBase.setPSDEListItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEListLogicBase.setPSDEListItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEListLogicBase.setPSDEListLogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEListLogicBase.setPSDEListLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEListLogicBase.setPSDEListName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEListLogicBase.setPSDELogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDEListLogicBase.setPSDELogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEListLogicBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDEListLogicBase.setPSDEUIActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDEListLogicBase.setPSDEUIActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDEListLogicBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDEListLogicBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDEListLogicBase.setPSSysViewLogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDEListLogicBase.setPSSysViewLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDEListLogicBase.setPSSysViewPanelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDEListLogicBase.setPSSysViewPanelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDEListLogicBase.setTimer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 31: {
                pSDEListLogicBase.setTriggerType(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDEListLogicBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 33: {
                pSDEListLogicBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDEListLogicBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDEListLogicBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDEListLogicBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSDEListLogicBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDEListLogicBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSDEListLogicBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDEListLogicBase.isNull(this, n);
    }

    private static boolean isNull(PSDEListLogicBase pSDEListLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEListLogicBase.getAttrName() == null;
            }
            case 1: {
                return pSDEListLogicBase.getCreateDate() == null;
            }
            case 2: {
                return pSDEListLogicBase.getCreateMan() == null;
            }
            case 3: {
                return pSDEListLogicBase.getCustomCode() == null;
            }
            case 4: {
                return pSDEListLogicBase.getDstLogicType() == null;
            }
            case 5: {
                return pSDEListLogicBase.getEventArg() == null;
            }
            case 6: {
                return pSDEListLogicBase.getEventArg2() == null;
            }
            case 7: {
                return pSDEListLogicBase.getEventNames() == null;
            }
            case 8: {
                return pSDEListLogicBase.getLogicParam() == null;
            }
            case 9: {
                return pSDEListLogicBase.getLogicParam2() == null;
            }
            case 10: {
                return pSDEListLogicBase.getMemo() == null;
            }
            case 11: {
                return pSDEListLogicBase.getOrderValue() == null;
            }
            case 12: {
                return pSDEListLogicBase.getPSDEId() == null;
            }
            case 13: {
                return pSDEListLogicBase.getPSDEListId() == null;
            }
            case 14: {
                return pSDEListLogicBase.getPSDEListItemId() == null;
            }
            case 15: {
                return pSDEListLogicBase.getPSDEListItemName() == null;
            }
            case 16: {
                return pSDEListLogicBase.getPSDEListLogicId() == null;
            }
            case 17: {
                return pSDEListLogicBase.getPSDEListLogicName() == null;
            }
            case 18: {
                return pSDEListLogicBase.getPSDEListName() == null;
            }
            case 19: {
                return pSDEListLogicBase.getPSDELogicId() == null;
            }
            case 20: {
                return pSDEListLogicBase.getPSDELogicName() == null;
            }
            case 21: {
                return pSDEListLogicBase.getPSDEName() == null;
            }
            case 22: {
                return pSDEListLogicBase.getPSDEUIActionId() == null;
            }
            case 23: {
                return pSDEListLogicBase.getPSDEUIActionName() == null;
            }
            case 24: {
                return pSDEListLogicBase.getPSSysPFPluginId() == null;
            }
            case 25: {
                return pSDEListLogicBase.getPSSysPFPluginName() == null;
            }
            case 26: {
                return pSDEListLogicBase.getPSSysViewLogicId() == null;
            }
            case 27: {
                return pSDEListLogicBase.getPSSysViewLogicName() == null;
            }
            case 28: {
                return pSDEListLogicBase.getPSSysViewPanelId() == null;
            }
            case 29: {
                return pSDEListLogicBase.getPSSysViewPanelName() == null;
            }
            case 30: {
                return pSDEListLogicBase.getTimer() == null;
            }
            case 31: {
                return pSDEListLogicBase.getTriggerType() == null;
            }
            case 32: {
                return pSDEListLogicBase.getUpdateDate() == null;
            }
            case 33: {
                return pSDEListLogicBase.getUpdateMan() == null;
            }
            case 34: {
                return pSDEListLogicBase.getUserCat() == null;
            }
            case 35: {
                return pSDEListLogicBase.getUserTag() == null;
            }
            case 36: {
                return pSDEListLogicBase.getUserTag2() == null;
            }
            case 37: {
                return pSDEListLogicBase.getUserTag3() == null;
            }
            case 38: {
                return pSDEListLogicBase.getUserTag4() == null;
            }
            case 39: {
                return pSDEListLogicBase.getValidFlag() == null;
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
        return PSDEListLogicBase.contains(this, n);
    }

    private static boolean contains(PSDEListLogicBase pSDEListLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEListLogicBase.isAttrNameDirty();
            }
            case 1: {
                return pSDEListLogicBase.isCreateDateDirty();
            }
            case 2: {
                return pSDEListLogicBase.isCreateManDirty();
            }
            case 3: {
                return pSDEListLogicBase.isCustomCodeDirty();
            }
            case 4: {
                return pSDEListLogicBase.isDstLogicTypeDirty();
            }
            case 5: {
                return pSDEListLogicBase.isEventArgDirty();
            }
            case 6: {
                return pSDEListLogicBase.isEventArg2Dirty();
            }
            case 7: {
                return pSDEListLogicBase.isEventNamesDirty();
            }
            case 8: {
                return pSDEListLogicBase.isLogicParamDirty();
            }
            case 9: {
                return pSDEListLogicBase.isLogicParam2Dirty();
            }
            case 10: {
                return pSDEListLogicBase.isMemoDirty();
            }
            case 11: {
                return pSDEListLogicBase.isOrderValueDirty();
            }
            case 12: {
                return pSDEListLogicBase.isPSDEIdDirty();
            }
            case 13: {
                return pSDEListLogicBase.isPSDEListIdDirty();
            }
            case 14: {
                return pSDEListLogicBase.isPSDEListItemIdDirty();
            }
            case 15: {
                return pSDEListLogicBase.isPSDEListItemNameDirty();
            }
            case 16: {
                return pSDEListLogicBase.isPSDEListLogicIdDirty();
            }
            case 17: {
                return pSDEListLogicBase.isPSDEListLogicNameDirty();
            }
            case 18: {
                return pSDEListLogicBase.isPSDEListNameDirty();
            }
            case 19: {
                return pSDEListLogicBase.isPSDELogicIdDirty();
            }
            case 20: {
                return pSDEListLogicBase.isPSDELogicNameDirty();
            }
            case 21: {
                return pSDEListLogicBase.isPSDENameDirty();
            }
            case 22: {
                return pSDEListLogicBase.isPSDEUIActionIdDirty();
            }
            case 23: {
                return pSDEListLogicBase.isPSDEUIActionNameDirty();
            }
            case 24: {
                return pSDEListLogicBase.isPSSysPFPluginIdDirty();
            }
            case 25: {
                return pSDEListLogicBase.isPSSysPFPluginNameDirty();
            }
            case 26: {
                return pSDEListLogicBase.isPSSysViewLogicIdDirty();
            }
            case 27: {
                return pSDEListLogicBase.isPSSysViewLogicNameDirty();
            }
            case 28: {
                return pSDEListLogicBase.isPSSysViewPanelIdDirty();
            }
            case 29: {
                return pSDEListLogicBase.isPSSysViewPanelNameDirty();
            }
            case 30: {
                return pSDEListLogicBase.isTimerDirty();
            }
            case 31: {
                return pSDEListLogicBase.isTriggerTypeDirty();
            }
            case 32: {
                return pSDEListLogicBase.isUpdateDateDirty();
            }
            case 33: {
                return pSDEListLogicBase.isUpdateManDirty();
            }
            case 34: {
                return pSDEListLogicBase.isUserCatDirty();
            }
            case 35: {
                return pSDEListLogicBase.isUserTagDirty();
            }
            case 36: {
                return pSDEListLogicBase.isUserTag2Dirty();
            }
            case 37: {
                return pSDEListLogicBase.isUserTag3Dirty();
            }
            case 38: {
                return pSDEListLogicBase.isUserTag4Dirty();
            }
            case 39: {
                return pSDEListLogicBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEListLogicBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEListLogicBase pSDEListLogicBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEListLogicBase.getAttrName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"attrname", (Object)PSDEListLogicBase.getJSONValue((Object)pSDEListLogicBase.getAttrName()), (boolean)false);
        }
        if (bl || pSDEListLogicBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEListLogicBase.getJSONValue((Object)pSDEListLogicBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEListLogicBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEListLogicBase.getJSONValue((Object)pSDEListLogicBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEListLogicBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSDEListLogicBase.getJSONValue((Object)pSDEListLogicBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSDEListLogicBase.getDstLogicType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstlogictype", (Object)PSDEListLogicBase.getJSONValue((Object)pSDEListLogicBase.getDstLogicType()), (boolean)false);
        }
        if (bl || pSDEListLogicBase.getEventArg() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eventarg", (Object)PSDEListLogicBase.getJSONValue((Object)pSDEListLogicBase.getEventArg()), (boolean)false);
        }
        if (bl || pSDEListLogicBase.getEventArg2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eventarg2", (Object)PSDEListLogicBase.getJSONValue((Object)pSDEListLogicBase.getEventArg2()), (boolean)false);
        }
        if (bl || pSDEListLogicBase.getEventNames() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eventnames", (Object)PSDEListLogicBase.getJSONValue((Object)pSDEListLogicBase.getEventNames()), (boolean)false);
        }
        if (bl || pSDEListLogicBase.getLogicParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicparam", (Object)PSDEListLogicBase.getJSONValue((Object)pSDEListLogicBase.getLogicParam()), (boolean)false);
        }
        if (bl || pSDEListLogicBase.getLogicParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicparam2", (Object)PSDEListLogicBase.getJSONValue((Object)pSDEListLogicBase.getLogicParam2()), (boolean)false);
        }
        if (bl || pSDEListLogicBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEListLogicBase.getJSONValue((Object)pSDEListLogicBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEListLogicBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDEListLogicBase.getJSONValue((Object)pSDEListLogicBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDEListLogicBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEListLogicBase.getJSONValue((Object)pSDEListLogicBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEListLogicBase.getPSDEListId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelistid", (Object)PSDEListLogicBase.getJSONValue((Object)pSDEListLogicBase.getPSDEListId()), (boolean)false);
        }
        if (bl || pSDEListLogicBase.getPSDEListItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelistitemid", (Object)PSDEListLogicBase.getJSONValue((Object)pSDEListLogicBase.getPSDEListItemId()), (boolean)false);
        }
        if (bl || pSDEListLogicBase.getPSDEListItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelistitemname", (Object)PSDEListLogicBase.getJSONValue((Object)pSDEListLogicBase.getPSDEListItemName()), (boolean)false);
        }
        if (bl || pSDEListLogicBase.getPSDEListLogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelistlogicid", (Object)PSDEListLogicBase.getJSONValue((Object)pSDEListLogicBase.getPSDEListLogicId()), (boolean)false);
        }
        if (bl || pSDEListLogicBase.getPSDEListLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelistlogicname", (Object)PSDEListLogicBase.getJSONValue((Object)pSDEListLogicBase.getPSDEListLogicName()), (boolean)false);
        }
        if (bl || pSDEListLogicBase.getPSDEListName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelistname", (Object)PSDEListLogicBase.getJSONValue((Object)pSDEListLogicBase.getPSDEListName()), (boolean)false);
        }
        if (bl || pSDEListLogicBase.getPSDELogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicid", (Object)PSDEListLogicBase.getJSONValue((Object)pSDEListLogicBase.getPSDELogicId()), (boolean)false);
        }
        if (bl || pSDEListLogicBase.getPSDELogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicname", (Object)PSDEListLogicBase.getJSONValue((Object)pSDEListLogicBase.getPSDELogicName()), (boolean)false);
        }
        if (bl || pSDEListLogicBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDEListLogicBase.getJSONValue((Object)pSDEListLogicBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDEListLogicBase.getPSDEUIActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuiactionid", (Object)PSDEListLogicBase.getJSONValue((Object)pSDEListLogicBase.getPSDEUIActionId()), (boolean)false);
        }
        if (bl || pSDEListLogicBase.getPSDEUIActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuiactionname", (Object)PSDEListLogicBase.getJSONValue((Object)pSDEListLogicBase.getPSDEUIActionName()), (boolean)false);
        }
        if (bl || pSDEListLogicBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSDEListLogicBase.getJSONValue((Object)pSDEListLogicBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSDEListLogicBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSDEListLogicBase.getJSONValue((Object)pSDEListLogicBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSDEListLogicBase.getPSSysViewLogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewlogicid", (Object)PSDEListLogicBase.getJSONValue((Object)pSDEListLogicBase.getPSSysViewLogicId()), (boolean)false);
        }
        if (bl || pSDEListLogicBase.getPSSysViewLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewlogicname", (Object)PSDEListLogicBase.getJSONValue((Object)pSDEListLogicBase.getPSSysViewLogicName()), (boolean)false);
        }
        if (bl || pSDEListLogicBase.getPSSysViewPanelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelid", (Object)PSDEListLogicBase.getJSONValue((Object)pSDEListLogicBase.getPSSysViewPanelId()), (boolean)false);
        }
        if (bl || pSDEListLogicBase.getPSSysViewPanelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelname", (Object)PSDEListLogicBase.getJSONValue((Object)pSDEListLogicBase.getPSSysViewPanelName()), (boolean)false);
        }
        if (bl || pSDEListLogicBase.getTimer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"timer", (Object)PSDEListLogicBase.getJSONValue((Object)pSDEListLogicBase.getTimer()), (boolean)false);
        }
        if (bl || pSDEListLogicBase.getTriggerType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"triggertype", (Object)PSDEListLogicBase.getJSONValue((Object)pSDEListLogicBase.getTriggerType()), (boolean)false);
        }
        if (bl || pSDEListLogicBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEListLogicBase.getJSONValue((Object)pSDEListLogicBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEListLogicBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEListLogicBase.getJSONValue((Object)pSDEListLogicBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEListLogicBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEListLogicBase.getJSONValue((Object)pSDEListLogicBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEListLogicBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEListLogicBase.getJSONValue((Object)pSDEListLogicBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEListLogicBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEListLogicBase.getJSONValue((Object)pSDEListLogicBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEListLogicBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEListLogicBase.getJSONValue((Object)pSDEListLogicBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEListLogicBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEListLogicBase.getJSONValue((Object)pSDEListLogicBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDEListLogicBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDEListLogicBase.getJSONValue((Object)pSDEListLogicBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEListLogicBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEListLogicBase pSDEListLogicBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEListLogicBase.getAttrName() != null) {
            object = pSDEListLogicBase.getAttrName();
            xmlNode.setAttribute(FIELD_ATTRNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEListLogicBase.getCreateDate() != null) {
            object = pSDEListLogicBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEListLogicBase.getCreateMan() != null) {
            object = pSDEListLogicBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEListLogicBase.getCustomCode() != null) {
            object = pSDEListLogicBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEListLogicBase.getDstLogicType() != null) {
            object = pSDEListLogicBase.getDstLogicType();
            xmlNode.setAttribute(FIELD_DSTLOGICTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEListLogicBase.getEventArg() != null) {
            object = pSDEListLogicBase.getEventArg();
            xmlNode.setAttribute(FIELD_EVENTARG, object == null ? "" : (String)object);
        }
        if (bl || pSDEListLogicBase.getEventArg2() != null) {
            object = pSDEListLogicBase.getEventArg2();
            xmlNode.setAttribute(FIELD_EVENTARG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEListLogicBase.getEventNames() != null) {
            object = pSDEListLogicBase.getEventNames();
            xmlNode.setAttribute(FIELD_EVENTNAMES, object == null ? "" : (String)object);
        }
        if (bl || pSDEListLogicBase.getLogicParam() != null) {
            object = pSDEListLogicBase.getLogicParam();
            xmlNode.setAttribute(FIELD_LOGICPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDEListLogicBase.getLogicParam2() != null) {
            object = pSDEListLogicBase.getLogicParam2();
            xmlNode.setAttribute(FIELD_LOGICPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSDEListLogicBase.getMemo() != null) {
            object = pSDEListLogicBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEListLogicBase.getOrderValue() != null) {
            object = pSDEListLogicBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEListLogicBase.getPSDEId() != null) {
            object = pSDEListLogicBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEListLogicBase.getPSDEListId() != null) {
            object = pSDEListLogicBase.getPSDEListId();
            xmlNode.setAttribute(FIELD_PSDELISTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEListLogicBase.getPSDEListItemId() != null) {
            object = pSDEListLogicBase.getPSDEListItemId();
            xmlNode.setAttribute(FIELD_PSDELISTITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEListLogicBase.getPSDEListItemName() != null) {
            object = pSDEListLogicBase.getPSDEListItemName();
            xmlNode.setAttribute(FIELD_PSDELISTITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEListLogicBase.getPSDEListLogicId() != null) {
            object = pSDEListLogicBase.getPSDEListLogicId();
            xmlNode.setAttribute(FIELD_PSDELISTLOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSDEListLogicBase.getPSDEListLogicName() != null) {
            object = pSDEListLogicBase.getPSDEListLogicName();
            xmlNode.setAttribute(FIELD_PSDELISTLOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEListLogicBase.getPSDEListName() != null) {
            object = pSDEListLogicBase.getPSDEListName();
            xmlNode.setAttribute(FIELD_PSDELISTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEListLogicBase.getPSDELogicId() != null) {
            object = pSDEListLogicBase.getPSDELogicId();
            xmlNode.setAttribute(FIELD_PSDELOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSDEListLogicBase.getPSDELogicName() != null) {
            object = pSDEListLogicBase.getPSDELogicName();
            xmlNode.setAttribute(FIELD_PSDELOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEListLogicBase.getPSDEName() != null) {
            object = pSDEListLogicBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEListLogicBase.getPSDEUIActionId() != null) {
            object = pSDEListLogicBase.getPSDEUIActionId();
            xmlNode.setAttribute(FIELD_PSDEUIACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEListLogicBase.getPSDEUIActionName() != null) {
            object = pSDEListLogicBase.getPSDEUIActionName();
            xmlNode.setAttribute(FIELD_PSDEUIACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEListLogicBase.getPSSysPFPluginId() != null) {
            object = pSDEListLogicBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDEListLogicBase.getPSSysPFPluginName() != null) {
            object = pSDEListLogicBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEListLogicBase.getPSSysViewLogicId() != null) {
            object = pSDEListLogicBase.getPSSysViewLogicId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWLOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSDEListLogicBase.getPSSysViewLogicName() != null) {
            object = pSDEListLogicBase.getPSSysViewLogicName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWLOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEListLogicBase.getPSSysViewPanelId() != null) {
            object = pSDEListLogicBase.getPSSysViewPanelId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELID, object == null ? "" : (String)object);
        }
        if (bl || pSDEListLogicBase.getPSSysViewPanelName() != null) {
            object = pSDEListLogicBase.getPSSysViewPanelName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEListLogicBase.getTimer() != null) {
            object = pSDEListLogicBase.getTimer();
            xmlNode.setAttribute(FIELD_TIMER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEListLogicBase.getTriggerType() != null) {
            object = pSDEListLogicBase.getTriggerType();
            xmlNode.setAttribute(FIELD_TRIGGERTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEListLogicBase.getUpdateDate() != null) {
            object = pSDEListLogicBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEListLogicBase.getUpdateMan() != null) {
            object = pSDEListLogicBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEListLogicBase.getUserCat() != null) {
            object = pSDEListLogicBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEListLogicBase.getUserTag() != null) {
            object = pSDEListLogicBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEListLogicBase.getUserTag2() != null) {
            object = pSDEListLogicBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEListLogicBase.getUserTag3() != null) {
            object = pSDEListLogicBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEListLogicBase.getUserTag4() != null) {
            object = pSDEListLogicBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEListLogicBase.getValidFlag() != null) {
            object = pSDEListLogicBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEListLogicBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEListLogicBase pSDEListLogicBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEListLogicBase.isAttrNameDirty() && (bl || pSDEListLogicBase.getAttrName() != null)) {
            iDataObject.set(FIELD_ATTRNAME, (Object)pSDEListLogicBase.getAttrName());
        }
        if (pSDEListLogicBase.isCreateDateDirty() && (bl || pSDEListLogicBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEListLogicBase.getCreateDate());
        }
        if (pSDEListLogicBase.isCreateManDirty() && (bl || pSDEListLogicBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEListLogicBase.getCreateMan());
        }
        if (pSDEListLogicBase.isCustomCodeDirty() && (bl || pSDEListLogicBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSDEListLogicBase.getCustomCode());
        }
        if (pSDEListLogicBase.isDstLogicTypeDirty() && (bl || pSDEListLogicBase.getDstLogicType() != null)) {
            iDataObject.set(FIELD_DSTLOGICTYPE, (Object)pSDEListLogicBase.getDstLogicType());
        }
        if (pSDEListLogicBase.isEventArgDirty() && (bl || pSDEListLogicBase.getEventArg() != null)) {
            iDataObject.set(FIELD_EVENTARG, (Object)pSDEListLogicBase.getEventArg());
        }
        if (pSDEListLogicBase.isEventArg2Dirty() && (bl || pSDEListLogicBase.getEventArg2() != null)) {
            iDataObject.set(FIELD_EVENTARG2, (Object)pSDEListLogicBase.getEventArg2());
        }
        if (pSDEListLogicBase.isEventNamesDirty() && (bl || pSDEListLogicBase.getEventNames() != null)) {
            iDataObject.set(FIELD_EVENTNAMES, (Object)pSDEListLogicBase.getEventNames());
        }
        if (pSDEListLogicBase.isLogicParamDirty() && (bl || pSDEListLogicBase.getLogicParam() != null)) {
            iDataObject.set(FIELD_LOGICPARAM, (Object)pSDEListLogicBase.getLogicParam());
        }
        if (pSDEListLogicBase.isLogicParam2Dirty() && (bl || pSDEListLogicBase.getLogicParam2() != null)) {
            iDataObject.set(FIELD_LOGICPARAM2, (Object)pSDEListLogicBase.getLogicParam2());
        }
        if (pSDEListLogicBase.isMemoDirty() && (bl || pSDEListLogicBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEListLogicBase.getMemo());
        }
        if (pSDEListLogicBase.isOrderValueDirty() && (bl || pSDEListLogicBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDEListLogicBase.getOrderValue());
        }
        if (pSDEListLogicBase.isPSDEIdDirty() && (bl || pSDEListLogicBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEListLogicBase.getPSDEId());
        }
        if (pSDEListLogicBase.isPSDEListIdDirty() && (bl || pSDEListLogicBase.getPSDEListId() != null)) {
            iDataObject.set(FIELD_PSDELISTID, (Object)pSDEListLogicBase.getPSDEListId());
        }
        if (pSDEListLogicBase.isPSDEListItemIdDirty() && (bl || pSDEListLogicBase.getPSDEListItemId() != null)) {
            iDataObject.set(FIELD_PSDELISTITEMID, (Object)pSDEListLogicBase.getPSDEListItemId());
        }
        if (pSDEListLogicBase.isPSDEListItemNameDirty() && (bl || pSDEListLogicBase.getPSDEListItemName() != null)) {
            iDataObject.set(FIELD_PSDELISTITEMNAME, (Object)pSDEListLogicBase.getPSDEListItemName());
        }
        if (pSDEListLogicBase.isPSDEListLogicIdDirty() && (bl || pSDEListLogicBase.getPSDEListLogicId() != null)) {
            iDataObject.set(FIELD_PSDELISTLOGICID, (Object)pSDEListLogicBase.getPSDEListLogicId());
        }
        if (pSDEListLogicBase.isPSDEListLogicNameDirty() && (bl || pSDEListLogicBase.getPSDEListLogicName() != null)) {
            iDataObject.set(FIELD_PSDELISTLOGICNAME, (Object)pSDEListLogicBase.getPSDEListLogicName());
        }
        if (pSDEListLogicBase.isPSDEListNameDirty() && (bl || pSDEListLogicBase.getPSDEListName() != null)) {
            iDataObject.set(FIELD_PSDELISTNAME, (Object)pSDEListLogicBase.getPSDEListName());
        }
        if (pSDEListLogicBase.isPSDELogicIdDirty() && (bl || pSDEListLogicBase.getPSDELogicId() != null)) {
            iDataObject.set(FIELD_PSDELOGICID, (Object)pSDEListLogicBase.getPSDELogicId());
        }
        if (pSDEListLogicBase.isPSDELogicNameDirty() && (bl || pSDEListLogicBase.getPSDELogicName() != null)) {
            iDataObject.set(FIELD_PSDELOGICNAME, (Object)pSDEListLogicBase.getPSDELogicName());
        }
        if (pSDEListLogicBase.isPSDENameDirty() && (bl || pSDEListLogicBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDEListLogicBase.getPSDEName());
        }
        if (pSDEListLogicBase.isPSDEUIActionIdDirty() && (bl || pSDEListLogicBase.getPSDEUIActionId() != null)) {
            iDataObject.set(FIELD_PSDEUIACTIONID, (Object)pSDEListLogicBase.getPSDEUIActionId());
        }
        if (pSDEListLogicBase.isPSDEUIActionNameDirty() && (bl || pSDEListLogicBase.getPSDEUIActionName() != null)) {
            iDataObject.set(FIELD_PSDEUIACTIONNAME, (Object)pSDEListLogicBase.getPSDEUIActionName());
        }
        if (pSDEListLogicBase.isPSSysPFPluginIdDirty() && (bl || pSDEListLogicBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSDEListLogicBase.getPSSysPFPluginId());
        }
        if (pSDEListLogicBase.isPSSysPFPluginNameDirty() && (bl || pSDEListLogicBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSDEListLogicBase.getPSSysPFPluginName());
        }
        if (pSDEListLogicBase.isPSSysViewLogicIdDirty() && (bl || pSDEListLogicBase.getPSSysViewLogicId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWLOGICID, (Object)pSDEListLogicBase.getPSSysViewLogicId());
        }
        if (pSDEListLogicBase.isPSSysViewLogicNameDirty() && (bl || pSDEListLogicBase.getPSSysViewLogicName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWLOGICNAME, (Object)pSDEListLogicBase.getPSSysViewLogicName());
        }
        if (pSDEListLogicBase.isPSSysViewPanelIdDirty() && (bl || pSDEListLogicBase.getPSSysViewPanelId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELID, (Object)pSDEListLogicBase.getPSSysViewPanelId());
        }
        if (pSDEListLogicBase.isPSSysViewPanelNameDirty() && (bl || pSDEListLogicBase.getPSSysViewPanelName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELNAME, (Object)pSDEListLogicBase.getPSSysViewPanelName());
        }
        if (pSDEListLogicBase.isTimerDirty() && (bl || pSDEListLogicBase.getTimer() != null)) {
            iDataObject.set(FIELD_TIMER, (Object)pSDEListLogicBase.getTimer());
        }
        if (pSDEListLogicBase.isTriggerTypeDirty() && (bl || pSDEListLogicBase.getTriggerType() != null)) {
            iDataObject.set(FIELD_TRIGGERTYPE, (Object)pSDEListLogicBase.getTriggerType());
        }
        if (pSDEListLogicBase.isUpdateDateDirty() && (bl || pSDEListLogicBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEListLogicBase.getUpdateDate());
        }
        if (pSDEListLogicBase.isUpdateManDirty() && (bl || pSDEListLogicBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEListLogicBase.getUpdateMan());
        }
        if (pSDEListLogicBase.isUserCatDirty() && (bl || pSDEListLogicBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEListLogicBase.getUserCat());
        }
        if (pSDEListLogicBase.isUserTagDirty() && (bl || pSDEListLogicBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEListLogicBase.getUserTag());
        }
        if (pSDEListLogicBase.isUserTag2Dirty() && (bl || pSDEListLogicBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEListLogicBase.getUserTag2());
        }
        if (pSDEListLogicBase.isUserTag3Dirty() && (bl || pSDEListLogicBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEListLogicBase.getUserTag3());
        }
        if (pSDEListLogicBase.isUserTag4Dirty() && (bl || pSDEListLogicBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEListLogicBase.getUserTag4());
        }
        if (pSDEListLogicBase.isValidFlagDirty() && (bl || pSDEListLogicBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDEListLogicBase.getValidFlag());
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
        return PSDEListLogicBase.remove(this, n);
    }

    private static boolean remove(PSDEListLogicBase pSDEListLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEListLogicBase.resetAttrName();
                return true;
            }
            case 1: {
                pSDEListLogicBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDEListLogicBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDEListLogicBase.resetCustomCode();
                return true;
            }
            case 4: {
                pSDEListLogicBase.resetDstLogicType();
                return true;
            }
            case 5: {
                pSDEListLogicBase.resetEventArg();
                return true;
            }
            case 6: {
                pSDEListLogicBase.resetEventArg2();
                return true;
            }
            case 7: {
                pSDEListLogicBase.resetEventNames();
                return true;
            }
            case 8: {
                pSDEListLogicBase.resetLogicParam();
                return true;
            }
            case 9: {
                pSDEListLogicBase.resetLogicParam2();
                return true;
            }
            case 10: {
                pSDEListLogicBase.resetMemo();
                return true;
            }
            case 11: {
                pSDEListLogicBase.resetOrderValue();
                return true;
            }
            case 12: {
                pSDEListLogicBase.resetPSDEId();
                return true;
            }
            case 13: {
                pSDEListLogicBase.resetPSDEListId();
                return true;
            }
            case 14: {
                pSDEListLogicBase.resetPSDEListItemId();
                return true;
            }
            case 15: {
                pSDEListLogicBase.resetPSDEListItemName();
                return true;
            }
            case 16: {
                pSDEListLogicBase.resetPSDEListLogicId();
                return true;
            }
            case 17: {
                pSDEListLogicBase.resetPSDEListLogicName();
                return true;
            }
            case 18: {
                pSDEListLogicBase.resetPSDEListName();
                return true;
            }
            case 19: {
                pSDEListLogicBase.resetPSDELogicId();
                return true;
            }
            case 20: {
                pSDEListLogicBase.resetPSDELogicName();
                return true;
            }
            case 21: {
                pSDEListLogicBase.resetPSDEName();
                return true;
            }
            case 22: {
                pSDEListLogicBase.resetPSDEUIActionId();
                return true;
            }
            case 23: {
                pSDEListLogicBase.resetPSDEUIActionName();
                return true;
            }
            case 24: {
                pSDEListLogicBase.resetPSSysPFPluginId();
                return true;
            }
            case 25: {
                pSDEListLogicBase.resetPSSysPFPluginName();
                return true;
            }
            case 26: {
                pSDEListLogicBase.resetPSSysViewLogicId();
                return true;
            }
            case 27: {
                pSDEListLogicBase.resetPSSysViewLogicName();
                return true;
            }
            case 28: {
                pSDEListLogicBase.resetPSSysViewPanelId();
                return true;
            }
            case 29: {
                pSDEListLogicBase.resetPSSysViewPanelName();
                return true;
            }
            case 30: {
                pSDEListLogicBase.resetTimer();
                return true;
            }
            case 31: {
                pSDEListLogicBase.resetTriggerType();
                return true;
            }
            case 32: {
                pSDEListLogicBase.resetUpdateDate();
                return true;
            }
            case 33: {
                pSDEListLogicBase.resetUpdateMan();
                return true;
            }
            case 34: {
                pSDEListLogicBase.resetUserCat();
                return true;
            }
            case 35: {
                pSDEListLogicBase.resetUserTag();
                return true;
            }
            case 36: {
                pSDEListLogicBase.resetUserTag2();
                return true;
            }
            case 37: {
                pSDEListLogicBase.resetUserTag3();
                return true;
            }
            case 38: {
                pSDEListLogicBase.resetUserTag4();
                return true;
            }
            case 39: {
                pSDEListLogicBase.resetValidFlag();
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
    public PSDEListItem getPSDEListItem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEListItem();
        }
        if (this.getPSDEListItemId() == null) {
            return null;
        }
        Integer n = this.objPSDEListItemLock;
        synchronized (n) {
            if (this.psdelistitem != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEListItemId(), (Object)this.psdelistitem.getPSDEListItemId()) != 0L) {
                this.psdelistitem = null;
            }
            if (this.psdelistitem == null) {
                PSDEListItem pSDEListItem = new PSDEListItem();
                pSDEListItem.setPSDEListItemId(this.getPSDEListItemId());
                PSDEListItemService pSDEListItemService = (PSDEListItemService)ServiceGlobal.getService(PSDEListItemService.class, (SessionFactory)this.getSessionFactory());
                pSDEListItemService.autoGet(pSDEListItem);
                this.psdelistitem = pSDEListItem;
            }
            return this.psdelistitem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEList getPSDEList() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEList();
        }
        if (this.getPSDEListId() == null) {
            return null;
        }
        Integer n = this.objPSDEListLock;
        synchronized (n) {
            if (this.psdelist != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEListId(), (Object)this.psdelist.getPSDEListId()) != 0L) {
                this.psdelist = null;
            }
            if (this.psdelist == null) {
                PSDEList pSDEList = new PSDEList();
                pSDEList.setPSDEListId(this.getPSDEListId());
                PSDEListService pSDEListService = (PSDEListService)ServiceGlobal.getService(PSDEListService.class, (SessionFactory)this.getSessionFactory());
                pSDEListService.autoGet(pSDEList);
                this.psdelist = pSDEList;
            }
            return this.psdelist;
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

    private PSDEListLogicBase getProxyEntity() {
        return this.proxyPSDEListLogicBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEListLogicBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEListLogicBase) {
            this.proxyPSDEListLogicBase = (PSDEListLogicBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEListLogicService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
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
        fieldIndexMap.put(FIELD_PSDELISTID, 13);
        fieldIndexMap.put(FIELD_PSDELISTITEMID, 14);
        fieldIndexMap.put(FIELD_PSDELISTITEMNAME, 15);
        fieldIndexMap.put(FIELD_PSDELISTLOGICID, 16);
        fieldIndexMap.put(FIELD_PSDELISTLOGICNAME, 17);
        fieldIndexMap.put(FIELD_PSDELISTNAME, 18);
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

