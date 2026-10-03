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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBPart;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDashboard;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewLogic;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanel;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBPartService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDashboardService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewLogicService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysDashboardLogicBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysDashboardLogicBase.class);
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
    public static final String FIELD_PSSYSDASHBOARDID = "PSSYSDASHBOARDID";
    public static final String FIELD_PSSYSDASHBOARDLOGICID = "PSSYSDASHBOARDLOGICID";
    public static final String FIELD_PSSYSDASHBOARDLOGICNAME = "PSSYSDASHBOARDLOGICNAME";
    public static final String FIELD_PSSYSDASHBOARDNAME = "PSSYSDASHBOARDNAME";
    public static final String FIELD_PSSYSDBPARTID = "PSSYSDBPARTID";
    public static final String FIELD_PSSYSDBPARTNAME = "PSSYSDBPARTNAME";
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
    private static final int INDEX_PSSYSDASHBOARDID = 18;
    private static final int INDEX_PSSYSDASHBOARDLOGICID = 19;
    private static final int INDEX_PSSYSDASHBOARDLOGICNAME = 20;
    private static final int INDEX_PSSYSDASHBOARDNAME = 21;
    private static final int INDEX_PSSYSDBPARTID = 22;
    private static final int INDEX_PSSYSDBPARTNAME = 23;
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
    private PSSysDashboardLogicBase proxyPSSysDashboardLogicBase = null;
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
    private boolean pssysdashboardidDirtyFlag = false;
    private boolean pssysdashboardlogicidDirtyFlag = false;
    private boolean pssysdashboardlogicnameDirtyFlag = false;
    private boolean pssysdashboardnameDirtyFlag = false;
    private boolean pssysdbpartidDirtyFlag = false;
    private boolean pssysdbpartnameDirtyFlag = false;
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
    @Column(name="pssysdashboardid")
    private String pssysdashboardid;
    @Column(name="pssysdashboardlogicid")
    private String pssysdashboardlogicid;
    @Column(name="pssysdashboardlogicname")
    private String pssysdashboardlogicname;
    @Column(name="pssysdashboardname")
    private String pssysdashboardname;
    @Column(name="pssysdbpartid")
    private String pssysdbpartid;
    @Column(name="pssysdbpartname")
    private String pssysdbpartname;
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
    private Integer objPSSysDashboardLock = new Integer(1);
    private PSSysDashboard pssysdashboard = null;
    private Integer objPSSysDBPartLock = new Integer(1);
    private PSSysDBPart pssysdbpart = null;
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

    public void setPSSysDashboardId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDashboardId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdashboardid = string;
        this.pssysdashboardidDirtyFlag = true;
    }

    public String getPSSysDashboardId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDashboardId();
        }
        return this.pssysdashboardid;
    }

    public boolean isPSSysDashboardIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDashboardIdDirty();
        }
        return this.pssysdashboardidDirtyFlag;
    }

    public void resetPSSysDashboardId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDashboardId();
            return;
        }
        this.pssysdashboardidDirtyFlag = false;
        this.pssysdashboardid = null;
    }

    public void setPSSysDashboardLogicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDashboardLogicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdashboardlogicid = string;
        this.pssysdashboardlogicidDirtyFlag = true;
    }

    public String getPSSysDashboardLogicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDashboardLogicId();
        }
        return this.pssysdashboardlogicid;
    }

    public boolean isPSSysDashboardLogicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDashboardLogicIdDirty();
        }
        return this.pssysdashboardlogicidDirtyFlag;
    }

    public void resetPSSysDashboardLogicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDashboardLogicId();
            return;
        }
        this.pssysdashboardlogicidDirtyFlag = false;
        this.pssysdashboardlogicid = null;
    }

    public void setPSSysDashboardLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDashboardLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdashboardlogicname = string;
        this.pssysdashboardlogicnameDirtyFlag = true;
    }

    public String getPSSysDashboardLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDashboardLogicName();
        }
        return this.pssysdashboardlogicname;
    }

    public boolean isPSSysDashboardLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDashboardLogicNameDirty();
        }
        return this.pssysdashboardlogicnameDirtyFlag;
    }

    public void resetPSSysDashboardLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDashboardLogicName();
            return;
        }
        this.pssysdashboardlogicnameDirtyFlag = false;
        this.pssysdashboardlogicname = null;
    }

    public void setPSSysDashboardName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDashboardName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdashboardname = string;
        this.pssysdashboardnameDirtyFlag = true;
    }

    public String getPSSysDashboardName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDashboardName();
        }
        return this.pssysdashboardname;
    }

    public boolean isPSSysDashboardNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDashboardNameDirty();
        }
        return this.pssysdashboardnameDirtyFlag;
    }

    public void resetPSSysDashboardName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDashboardName();
            return;
        }
        this.pssysdashboardnameDirtyFlag = false;
        this.pssysdashboardname = null;
    }

    public void setPSSysDBPartId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDBPartId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdbpartid = string;
        this.pssysdbpartidDirtyFlag = true;
    }

    public String getPSSysDBPartId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBPartId();
        }
        return this.pssysdbpartid;
    }

    public boolean isPSSysDBPartIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDBPartIdDirty();
        }
        return this.pssysdbpartidDirtyFlag;
    }

    public void resetPSSysDBPartId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDBPartId();
            return;
        }
        this.pssysdbpartidDirtyFlag = false;
        this.pssysdbpartid = null;
    }

    public void setPSSysDBPartName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDBPartName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdbpartname = string;
        this.pssysdbpartnameDirtyFlag = true;
    }

    public String getPSSysDBPartName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBPartName();
        }
        return this.pssysdbpartname;
    }

    public boolean isPSSysDBPartNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDBPartNameDirty();
        }
        return this.pssysdbpartnameDirtyFlag;
    }

    public void resetPSSysDBPartName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDBPartName();
            return;
        }
        this.pssysdbpartnameDirtyFlag = false;
        this.pssysdbpartname = null;
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
        PSSysDashboardLogicBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysDashboardLogicBase pSSysDashboardLogicBase) {
        pSSysDashboardLogicBase.resetAttrName();
        pSSysDashboardLogicBase.resetCreateDate();
        pSSysDashboardLogicBase.resetCreateMan();
        pSSysDashboardLogicBase.resetCustomCode();
        pSSysDashboardLogicBase.resetDstLogicType();
        pSSysDashboardLogicBase.resetEventArg();
        pSSysDashboardLogicBase.resetEventArg2();
        pSSysDashboardLogicBase.resetEventNames();
        pSSysDashboardLogicBase.resetLogicParam();
        pSSysDashboardLogicBase.resetLogicParam2();
        pSSysDashboardLogicBase.resetMemo();
        pSSysDashboardLogicBase.resetOrderValue();
        pSSysDashboardLogicBase.resetPSDEId();
        pSSysDashboardLogicBase.resetPSDELogicId();
        pSSysDashboardLogicBase.resetPSDELogicName();
        pSSysDashboardLogicBase.resetPSDEName();
        pSSysDashboardLogicBase.resetPSDEUIActionId();
        pSSysDashboardLogicBase.resetPSDEUIActionName();
        pSSysDashboardLogicBase.resetPSSysDashboardId();
        pSSysDashboardLogicBase.resetPSSysDashboardLogicId();
        pSSysDashboardLogicBase.resetPSSysDashboardLogicName();
        pSSysDashboardLogicBase.resetPSSysDashboardName();
        pSSysDashboardLogicBase.resetPSSysDBPartId();
        pSSysDashboardLogicBase.resetPSSysDBPartName();
        pSSysDashboardLogicBase.resetPSSysPFPluginId();
        pSSysDashboardLogicBase.resetPSSysPFPluginName();
        pSSysDashboardLogicBase.resetPSSysViewLogicId();
        pSSysDashboardLogicBase.resetPSSysViewLogicName();
        pSSysDashboardLogicBase.resetPSSysViewPanelId();
        pSSysDashboardLogicBase.resetPSSysViewPanelName();
        pSSysDashboardLogicBase.resetTimer();
        pSSysDashboardLogicBase.resetTriggerType();
        pSSysDashboardLogicBase.resetUpdateDate();
        pSSysDashboardLogicBase.resetUpdateMan();
        pSSysDashboardLogicBase.resetUserCat();
        pSSysDashboardLogicBase.resetUserTag();
        pSSysDashboardLogicBase.resetUserTag2();
        pSSysDashboardLogicBase.resetUserTag3();
        pSSysDashboardLogicBase.resetUserTag4();
        pSSysDashboardLogicBase.resetValidFlag();
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
        if (!bl || this.isPSSysDashboardIdDirty()) {
            hashMap.put(FIELD_PSSYSDASHBOARDID, this.getPSSysDashboardId());
        }
        if (!bl || this.isPSSysDashboardLogicIdDirty()) {
            hashMap.put(FIELD_PSSYSDASHBOARDLOGICID, this.getPSSysDashboardLogicId());
        }
        if (!bl || this.isPSSysDashboardLogicNameDirty()) {
            hashMap.put(FIELD_PSSYSDASHBOARDLOGICNAME, this.getPSSysDashboardLogicName());
        }
        if (!bl || this.isPSSysDashboardNameDirty()) {
            hashMap.put(FIELD_PSSYSDASHBOARDNAME, this.getPSSysDashboardName());
        }
        if (!bl || this.isPSSysDBPartIdDirty()) {
            hashMap.put(FIELD_PSSYSDBPARTID, this.getPSSysDBPartId());
        }
        if (!bl || this.isPSSysDBPartNameDirty()) {
            hashMap.put(FIELD_PSSYSDBPARTNAME, this.getPSSysDBPartName());
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
        return PSSysDashboardLogicBase.get(this, n);
    }

    private static Object get(PSSysDashboardLogicBase pSSysDashboardLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDashboardLogicBase.getAttrName();
            }
            case 1: {
                return pSSysDashboardLogicBase.getCreateDate();
            }
            case 2: {
                return pSSysDashboardLogicBase.getCreateMan();
            }
            case 3: {
                return pSSysDashboardLogicBase.getCustomCode();
            }
            case 4: {
                return pSSysDashboardLogicBase.getDstLogicType();
            }
            case 5: {
                return pSSysDashboardLogicBase.getEventArg();
            }
            case 6: {
                return pSSysDashboardLogicBase.getEventArg2();
            }
            case 7: {
                return pSSysDashboardLogicBase.getEventNames();
            }
            case 8: {
                return pSSysDashboardLogicBase.getLogicParam();
            }
            case 9: {
                return pSSysDashboardLogicBase.getLogicParam2();
            }
            case 10: {
                return pSSysDashboardLogicBase.getMemo();
            }
            case 11: {
                return pSSysDashboardLogicBase.getOrderValue();
            }
            case 12: {
                return pSSysDashboardLogicBase.getPSDEId();
            }
            case 13: {
                return pSSysDashboardLogicBase.getPSDELogicId();
            }
            case 14: {
                return pSSysDashboardLogicBase.getPSDELogicName();
            }
            case 15: {
                return pSSysDashboardLogicBase.getPSDEName();
            }
            case 16: {
                return pSSysDashboardLogicBase.getPSDEUIActionId();
            }
            case 17: {
                return pSSysDashboardLogicBase.getPSDEUIActionName();
            }
            case 18: {
                return pSSysDashboardLogicBase.getPSSysDashboardId();
            }
            case 19: {
                return pSSysDashboardLogicBase.getPSSysDashboardLogicId();
            }
            case 20: {
                return pSSysDashboardLogicBase.getPSSysDashboardLogicName();
            }
            case 21: {
                return pSSysDashboardLogicBase.getPSSysDashboardName();
            }
            case 22: {
                return pSSysDashboardLogicBase.getPSSysDBPartId();
            }
            case 23: {
                return pSSysDashboardLogicBase.getPSSysDBPartName();
            }
            case 24: {
                return pSSysDashboardLogicBase.getPSSysPFPluginId();
            }
            case 25: {
                return pSSysDashboardLogicBase.getPSSysPFPluginName();
            }
            case 26: {
                return pSSysDashboardLogicBase.getPSSysViewLogicId();
            }
            case 27: {
                return pSSysDashboardLogicBase.getPSSysViewLogicName();
            }
            case 28: {
                return pSSysDashboardLogicBase.getPSSysViewPanelId();
            }
            case 29: {
                return pSSysDashboardLogicBase.getPSSysViewPanelName();
            }
            case 30: {
                return pSSysDashboardLogicBase.getTimer();
            }
            case 31: {
                return pSSysDashboardLogicBase.getTriggerType();
            }
            case 32: {
                return pSSysDashboardLogicBase.getUpdateDate();
            }
            case 33: {
                return pSSysDashboardLogicBase.getUpdateMan();
            }
            case 34: {
                return pSSysDashboardLogicBase.getUserCat();
            }
            case 35: {
                return pSSysDashboardLogicBase.getUserTag();
            }
            case 36: {
                return pSSysDashboardLogicBase.getUserTag2();
            }
            case 37: {
                return pSSysDashboardLogicBase.getUserTag3();
            }
            case 38: {
                return pSSysDashboardLogicBase.getUserTag4();
            }
            case 39: {
                return pSSysDashboardLogicBase.getValidFlag();
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
        PSSysDashboardLogicBase.set(this, n, object);
    }

    private static void set(PSSysDashboardLogicBase pSSysDashboardLogicBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysDashboardLogicBase.setAttrName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysDashboardLogicBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysDashboardLogicBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysDashboardLogicBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysDashboardLogicBase.setDstLogicType(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysDashboardLogicBase.setEventArg(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysDashboardLogicBase.setEventArg2(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysDashboardLogicBase.setEventNames(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysDashboardLogicBase.setLogicParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysDashboardLogicBase.setLogicParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysDashboardLogicBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysDashboardLogicBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSSysDashboardLogicBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysDashboardLogicBase.setPSDELogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysDashboardLogicBase.setPSDELogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysDashboardLogicBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysDashboardLogicBase.setPSDEUIActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysDashboardLogicBase.setPSDEUIActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysDashboardLogicBase.setPSSysDashboardId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysDashboardLogicBase.setPSSysDashboardLogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysDashboardLogicBase.setPSSysDashboardLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysDashboardLogicBase.setPSSysDashboardName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysDashboardLogicBase.setPSSysDBPartId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysDashboardLogicBase.setPSSysDBPartName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysDashboardLogicBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysDashboardLogicBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysDashboardLogicBase.setPSSysViewLogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysDashboardLogicBase.setPSSysViewLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysDashboardLogicBase.setPSSysViewPanelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSysDashboardLogicBase.setPSSysViewPanelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSysDashboardLogicBase.setTimer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 31: {
                pSSysDashboardLogicBase.setTriggerType(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSysDashboardLogicBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 33: {
                pSSysDashboardLogicBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSSysDashboardLogicBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSSysDashboardLogicBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSSysDashboardLogicBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSSysDashboardLogicBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSSysDashboardLogicBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSSysDashboardLogicBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSysDashboardLogicBase.isNull(this, n);
    }

    private static boolean isNull(PSSysDashboardLogicBase pSSysDashboardLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDashboardLogicBase.getAttrName() == null;
            }
            case 1: {
                return pSSysDashboardLogicBase.getCreateDate() == null;
            }
            case 2: {
                return pSSysDashboardLogicBase.getCreateMan() == null;
            }
            case 3: {
                return pSSysDashboardLogicBase.getCustomCode() == null;
            }
            case 4: {
                return pSSysDashboardLogicBase.getDstLogicType() == null;
            }
            case 5: {
                return pSSysDashboardLogicBase.getEventArg() == null;
            }
            case 6: {
                return pSSysDashboardLogicBase.getEventArg2() == null;
            }
            case 7: {
                return pSSysDashboardLogicBase.getEventNames() == null;
            }
            case 8: {
                return pSSysDashboardLogicBase.getLogicParam() == null;
            }
            case 9: {
                return pSSysDashboardLogicBase.getLogicParam2() == null;
            }
            case 10: {
                return pSSysDashboardLogicBase.getMemo() == null;
            }
            case 11: {
                return pSSysDashboardLogicBase.getOrderValue() == null;
            }
            case 12: {
                return pSSysDashboardLogicBase.getPSDEId() == null;
            }
            case 13: {
                return pSSysDashboardLogicBase.getPSDELogicId() == null;
            }
            case 14: {
                return pSSysDashboardLogicBase.getPSDELogicName() == null;
            }
            case 15: {
                return pSSysDashboardLogicBase.getPSDEName() == null;
            }
            case 16: {
                return pSSysDashboardLogicBase.getPSDEUIActionId() == null;
            }
            case 17: {
                return pSSysDashboardLogicBase.getPSDEUIActionName() == null;
            }
            case 18: {
                return pSSysDashboardLogicBase.getPSSysDashboardId() == null;
            }
            case 19: {
                return pSSysDashboardLogicBase.getPSSysDashboardLogicId() == null;
            }
            case 20: {
                return pSSysDashboardLogicBase.getPSSysDashboardLogicName() == null;
            }
            case 21: {
                return pSSysDashboardLogicBase.getPSSysDashboardName() == null;
            }
            case 22: {
                return pSSysDashboardLogicBase.getPSSysDBPartId() == null;
            }
            case 23: {
                return pSSysDashboardLogicBase.getPSSysDBPartName() == null;
            }
            case 24: {
                return pSSysDashboardLogicBase.getPSSysPFPluginId() == null;
            }
            case 25: {
                return pSSysDashboardLogicBase.getPSSysPFPluginName() == null;
            }
            case 26: {
                return pSSysDashboardLogicBase.getPSSysViewLogicId() == null;
            }
            case 27: {
                return pSSysDashboardLogicBase.getPSSysViewLogicName() == null;
            }
            case 28: {
                return pSSysDashboardLogicBase.getPSSysViewPanelId() == null;
            }
            case 29: {
                return pSSysDashboardLogicBase.getPSSysViewPanelName() == null;
            }
            case 30: {
                return pSSysDashboardLogicBase.getTimer() == null;
            }
            case 31: {
                return pSSysDashboardLogicBase.getTriggerType() == null;
            }
            case 32: {
                return pSSysDashboardLogicBase.getUpdateDate() == null;
            }
            case 33: {
                return pSSysDashboardLogicBase.getUpdateMan() == null;
            }
            case 34: {
                return pSSysDashboardLogicBase.getUserCat() == null;
            }
            case 35: {
                return pSSysDashboardLogicBase.getUserTag() == null;
            }
            case 36: {
                return pSSysDashboardLogicBase.getUserTag2() == null;
            }
            case 37: {
                return pSSysDashboardLogicBase.getUserTag3() == null;
            }
            case 38: {
                return pSSysDashboardLogicBase.getUserTag4() == null;
            }
            case 39: {
                return pSSysDashboardLogicBase.getValidFlag() == null;
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
        return PSSysDashboardLogicBase.contains(this, n);
    }

    private static boolean contains(PSSysDashboardLogicBase pSSysDashboardLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDashboardLogicBase.isAttrNameDirty();
            }
            case 1: {
                return pSSysDashboardLogicBase.isCreateDateDirty();
            }
            case 2: {
                return pSSysDashboardLogicBase.isCreateManDirty();
            }
            case 3: {
                return pSSysDashboardLogicBase.isCustomCodeDirty();
            }
            case 4: {
                return pSSysDashboardLogicBase.isDstLogicTypeDirty();
            }
            case 5: {
                return pSSysDashboardLogicBase.isEventArgDirty();
            }
            case 6: {
                return pSSysDashboardLogicBase.isEventArg2Dirty();
            }
            case 7: {
                return pSSysDashboardLogicBase.isEventNamesDirty();
            }
            case 8: {
                return pSSysDashboardLogicBase.isLogicParamDirty();
            }
            case 9: {
                return pSSysDashboardLogicBase.isLogicParam2Dirty();
            }
            case 10: {
                return pSSysDashboardLogicBase.isMemoDirty();
            }
            case 11: {
                return pSSysDashboardLogicBase.isOrderValueDirty();
            }
            case 12: {
                return pSSysDashboardLogicBase.isPSDEIdDirty();
            }
            case 13: {
                return pSSysDashboardLogicBase.isPSDELogicIdDirty();
            }
            case 14: {
                return pSSysDashboardLogicBase.isPSDELogicNameDirty();
            }
            case 15: {
                return pSSysDashboardLogicBase.isPSDENameDirty();
            }
            case 16: {
                return pSSysDashboardLogicBase.isPSDEUIActionIdDirty();
            }
            case 17: {
                return pSSysDashboardLogicBase.isPSDEUIActionNameDirty();
            }
            case 18: {
                return pSSysDashboardLogicBase.isPSSysDashboardIdDirty();
            }
            case 19: {
                return pSSysDashboardLogicBase.isPSSysDashboardLogicIdDirty();
            }
            case 20: {
                return pSSysDashboardLogicBase.isPSSysDashboardLogicNameDirty();
            }
            case 21: {
                return pSSysDashboardLogicBase.isPSSysDashboardNameDirty();
            }
            case 22: {
                return pSSysDashboardLogicBase.isPSSysDBPartIdDirty();
            }
            case 23: {
                return pSSysDashboardLogicBase.isPSSysDBPartNameDirty();
            }
            case 24: {
                return pSSysDashboardLogicBase.isPSSysPFPluginIdDirty();
            }
            case 25: {
                return pSSysDashboardLogicBase.isPSSysPFPluginNameDirty();
            }
            case 26: {
                return pSSysDashboardLogicBase.isPSSysViewLogicIdDirty();
            }
            case 27: {
                return pSSysDashboardLogicBase.isPSSysViewLogicNameDirty();
            }
            case 28: {
                return pSSysDashboardLogicBase.isPSSysViewPanelIdDirty();
            }
            case 29: {
                return pSSysDashboardLogicBase.isPSSysViewPanelNameDirty();
            }
            case 30: {
                return pSSysDashboardLogicBase.isTimerDirty();
            }
            case 31: {
                return pSSysDashboardLogicBase.isTriggerTypeDirty();
            }
            case 32: {
                return pSSysDashboardLogicBase.isUpdateDateDirty();
            }
            case 33: {
                return pSSysDashboardLogicBase.isUpdateManDirty();
            }
            case 34: {
                return pSSysDashboardLogicBase.isUserCatDirty();
            }
            case 35: {
                return pSSysDashboardLogicBase.isUserTagDirty();
            }
            case 36: {
                return pSSysDashboardLogicBase.isUserTag2Dirty();
            }
            case 37: {
                return pSSysDashboardLogicBase.isUserTag3Dirty();
            }
            case 38: {
                return pSSysDashboardLogicBase.isUserTag4Dirty();
            }
            case 39: {
                return pSSysDashboardLogicBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysDashboardLogicBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysDashboardLogicBase pSSysDashboardLogicBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysDashboardLogicBase.getAttrName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"attrname", (Object)PSSysDashboardLogicBase.getJSONValue((Object)pSSysDashboardLogicBase.getAttrName()), (boolean)false);
        }
        if (bl || pSSysDashboardLogicBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysDashboardLogicBase.getJSONValue((Object)pSSysDashboardLogicBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysDashboardLogicBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysDashboardLogicBase.getJSONValue((Object)pSSysDashboardLogicBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysDashboardLogicBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSSysDashboardLogicBase.getJSONValue((Object)pSSysDashboardLogicBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSSysDashboardLogicBase.getDstLogicType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstlogictype", (Object)PSSysDashboardLogicBase.getJSONValue((Object)pSSysDashboardLogicBase.getDstLogicType()), (boolean)false);
        }
        if (bl || pSSysDashboardLogicBase.getEventArg() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eventarg", (Object)PSSysDashboardLogicBase.getJSONValue((Object)pSSysDashboardLogicBase.getEventArg()), (boolean)false);
        }
        if (bl || pSSysDashboardLogicBase.getEventArg2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eventarg2", (Object)PSSysDashboardLogicBase.getJSONValue((Object)pSSysDashboardLogicBase.getEventArg2()), (boolean)false);
        }
        if (bl || pSSysDashboardLogicBase.getEventNames() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eventnames", (Object)PSSysDashboardLogicBase.getJSONValue((Object)pSSysDashboardLogicBase.getEventNames()), (boolean)false);
        }
        if (bl || pSSysDashboardLogicBase.getLogicParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicparam", (Object)PSSysDashboardLogicBase.getJSONValue((Object)pSSysDashboardLogicBase.getLogicParam()), (boolean)false);
        }
        if (bl || pSSysDashboardLogicBase.getLogicParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicparam2", (Object)PSSysDashboardLogicBase.getJSONValue((Object)pSSysDashboardLogicBase.getLogicParam2()), (boolean)false);
        }
        if (bl || pSSysDashboardLogicBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysDashboardLogicBase.getJSONValue((Object)pSSysDashboardLogicBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysDashboardLogicBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSysDashboardLogicBase.getJSONValue((Object)pSSysDashboardLogicBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSysDashboardLogicBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSSysDashboardLogicBase.getJSONValue((Object)pSSysDashboardLogicBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSSysDashboardLogicBase.getPSDELogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicid", (Object)PSSysDashboardLogicBase.getJSONValue((Object)pSSysDashboardLogicBase.getPSDELogicId()), (boolean)false);
        }
        if (bl || pSSysDashboardLogicBase.getPSDELogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicname", (Object)PSSysDashboardLogicBase.getJSONValue((Object)pSSysDashboardLogicBase.getPSDELogicName()), (boolean)false);
        }
        if (bl || pSSysDashboardLogicBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSSysDashboardLogicBase.getJSONValue((Object)pSSysDashboardLogicBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSSysDashboardLogicBase.getPSDEUIActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuiactionid", (Object)PSSysDashboardLogicBase.getJSONValue((Object)pSSysDashboardLogicBase.getPSDEUIActionId()), (boolean)false);
        }
        if (bl || pSSysDashboardLogicBase.getPSDEUIActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuiactionname", (Object)PSSysDashboardLogicBase.getJSONValue((Object)pSSysDashboardLogicBase.getPSDEUIActionName()), (boolean)false);
        }
        if (bl || pSSysDashboardLogicBase.getPSSysDashboardId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdashboardid", (Object)PSSysDashboardLogicBase.getJSONValue((Object)pSSysDashboardLogicBase.getPSSysDashboardId()), (boolean)false);
        }
        if (bl || pSSysDashboardLogicBase.getPSSysDashboardLogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdashboardlogicid", (Object)PSSysDashboardLogicBase.getJSONValue((Object)pSSysDashboardLogicBase.getPSSysDashboardLogicId()), (boolean)false);
        }
        if (bl || pSSysDashboardLogicBase.getPSSysDashboardLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdashboardlogicname", (Object)PSSysDashboardLogicBase.getJSONValue((Object)pSSysDashboardLogicBase.getPSSysDashboardLogicName()), (boolean)false);
        }
        if (bl || pSSysDashboardLogicBase.getPSSysDashboardName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdashboardname", (Object)PSSysDashboardLogicBase.getJSONValue((Object)pSSysDashboardLogicBase.getPSSysDashboardName()), (boolean)false);
        }
        if (bl || pSSysDashboardLogicBase.getPSSysDBPartId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdbpartid", (Object)PSSysDashboardLogicBase.getJSONValue((Object)pSSysDashboardLogicBase.getPSSysDBPartId()), (boolean)false);
        }
        if (bl || pSSysDashboardLogicBase.getPSSysDBPartName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdbpartname", (Object)PSSysDashboardLogicBase.getJSONValue((Object)pSSysDashboardLogicBase.getPSSysDBPartName()), (boolean)false);
        }
        if (bl || pSSysDashboardLogicBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSSysDashboardLogicBase.getJSONValue((Object)pSSysDashboardLogicBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSSysDashboardLogicBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSSysDashboardLogicBase.getJSONValue((Object)pSSysDashboardLogicBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSSysDashboardLogicBase.getPSSysViewLogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewlogicid", (Object)PSSysDashboardLogicBase.getJSONValue((Object)pSSysDashboardLogicBase.getPSSysViewLogicId()), (boolean)false);
        }
        if (bl || pSSysDashboardLogicBase.getPSSysViewLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewlogicname", (Object)PSSysDashboardLogicBase.getJSONValue((Object)pSSysDashboardLogicBase.getPSSysViewLogicName()), (boolean)false);
        }
        if (bl || pSSysDashboardLogicBase.getPSSysViewPanelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelid", (Object)PSSysDashboardLogicBase.getJSONValue((Object)pSSysDashboardLogicBase.getPSSysViewPanelId()), (boolean)false);
        }
        if (bl || pSSysDashboardLogicBase.getPSSysViewPanelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelname", (Object)PSSysDashboardLogicBase.getJSONValue((Object)pSSysDashboardLogicBase.getPSSysViewPanelName()), (boolean)false);
        }
        if (bl || pSSysDashboardLogicBase.getTimer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"timer", (Object)PSSysDashboardLogicBase.getJSONValue((Object)pSSysDashboardLogicBase.getTimer()), (boolean)false);
        }
        if (bl || pSSysDashboardLogicBase.getTriggerType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"triggertype", (Object)PSSysDashboardLogicBase.getJSONValue((Object)pSSysDashboardLogicBase.getTriggerType()), (boolean)false);
        }
        if (bl || pSSysDashboardLogicBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysDashboardLogicBase.getJSONValue((Object)pSSysDashboardLogicBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysDashboardLogicBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysDashboardLogicBase.getJSONValue((Object)pSSysDashboardLogicBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysDashboardLogicBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysDashboardLogicBase.getJSONValue((Object)pSSysDashboardLogicBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysDashboardLogicBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysDashboardLogicBase.getJSONValue((Object)pSSysDashboardLogicBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysDashboardLogicBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysDashboardLogicBase.getJSONValue((Object)pSSysDashboardLogicBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysDashboardLogicBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysDashboardLogicBase.getJSONValue((Object)pSSysDashboardLogicBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysDashboardLogicBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysDashboardLogicBase.getJSONValue((Object)pSSysDashboardLogicBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysDashboardLogicBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysDashboardLogicBase.getJSONValue((Object)pSSysDashboardLogicBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysDashboardLogicBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysDashboardLogicBase pSSysDashboardLogicBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysDashboardLogicBase.getAttrName() != null) {
            object = pSSysDashboardLogicBase.getAttrName();
            xmlNode.setAttribute(FIELD_ATTRNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDashboardLogicBase.getCreateDate() != null) {
            object = pSSysDashboardLogicBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysDashboardLogicBase.getCreateMan() != null) {
            object = pSSysDashboardLogicBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysDashboardLogicBase.getCustomCode() != null) {
            object = pSSysDashboardLogicBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysDashboardLogicBase.getDstLogicType() != null) {
            object = pSSysDashboardLogicBase.getDstLogicType();
            xmlNode.setAttribute(FIELD_DSTLOGICTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysDashboardLogicBase.getEventArg() != null) {
            object = pSSysDashboardLogicBase.getEventArg();
            xmlNode.setAttribute(FIELD_EVENTARG, object == null ? "" : (String)object);
        }
        if (bl || pSSysDashboardLogicBase.getEventArg2() != null) {
            object = pSSysDashboardLogicBase.getEventArg2();
            xmlNode.setAttribute(FIELD_EVENTARG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysDashboardLogicBase.getEventNames() != null) {
            object = pSSysDashboardLogicBase.getEventNames();
            xmlNode.setAttribute(FIELD_EVENTNAMES, object == null ? "" : (String)object);
        }
        if (bl || pSSysDashboardLogicBase.getLogicParam() != null) {
            object = pSSysDashboardLogicBase.getLogicParam();
            xmlNode.setAttribute(FIELD_LOGICPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSSysDashboardLogicBase.getLogicParam2() != null) {
            object = pSSysDashboardLogicBase.getLogicParam2();
            xmlNode.setAttribute(FIELD_LOGICPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSSysDashboardLogicBase.getMemo() != null) {
            object = pSSysDashboardLogicBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysDashboardLogicBase.getOrderValue() != null) {
            object = pSSysDashboardLogicBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDashboardLogicBase.getPSDEId() != null) {
            object = pSSysDashboardLogicBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDashboardLogicBase.getPSDELogicId() != null) {
            object = pSSysDashboardLogicBase.getPSDELogicId();
            xmlNode.setAttribute(FIELD_PSDELOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDashboardLogicBase.getPSDELogicName() != null) {
            object = pSSysDashboardLogicBase.getPSDELogicName();
            xmlNode.setAttribute(FIELD_PSDELOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDashboardLogicBase.getPSDEName() != null) {
            object = pSSysDashboardLogicBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDashboardLogicBase.getPSDEUIActionId() != null) {
            object = pSSysDashboardLogicBase.getPSDEUIActionId();
            xmlNode.setAttribute(FIELD_PSDEUIACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDashboardLogicBase.getPSDEUIActionName() != null) {
            object = pSSysDashboardLogicBase.getPSDEUIActionName();
            xmlNode.setAttribute(FIELD_PSDEUIACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDashboardLogicBase.getPSSysDashboardId() != null) {
            object = pSSysDashboardLogicBase.getPSSysDashboardId();
            xmlNode.setAttribute(FIELD_PSSYSDASHBOARDID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDashboardLogicBase.getPSSysDashboardLogicId() != null) {
            object = pSSysDashboardLogicBase.getPSSysDashboardLogicId();
            xmlNode.setAttribute(FIELD_PSSYSDASHBOARDLOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDashboardLogicBase.getPSSysDashboardLogicName() != null) {
            object = pSSysDashboardLogicBase.getPSSysDashboardLogicName();
            xmlNode.setAttribute(FIELD_PSSYSDASHBOARDLOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDashboardLogicBase.getPSSysDashboardName() != null) {
            object = pSSysDashboardLogicBase.getPSSysDashboardName();
            xmlNode.setAttribute(FIELD_PSSYSDASHBOARDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDashboardLogicBase.getPSSysDBPartId() != null) {
            object = pSSysDashboardLogicBase.getPSSysDBPartId();
            xmlNode.setAttribute(FIELD_PSSYSDBPARTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDashboardLogicBase.getPSSysDBPartName() != null) {
            object = pSSysDashboardLogicBase.getPSSysDBPartName();
            xmlNode.setAttribute(FIELD_PSSYSDBPARTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDashboardLogicBase.getPSSysPFPluginId() != null) {
            object = pSSysDashboardLogicBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDashboardLogicBase.getPSSysPFPluginName() != null) {
            object = pSSysDashboardLogicBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDashboardLogicBase.getPSSysViewLogicId() != null) {
            object = pSSysDashboardLogicBase.getPSSysViewLogicId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWLOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDashboardLogicBase.getPSSysViewLogicName() != null) {
            object = pSSysDashboardLogicBase.getPSSysViewLogicName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWLOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDashboardLogicBase.getPSSysViewPanelId() != null) {
            object = pSSysDashboardLogicBase.getPSSysViewPanelId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDashboardLogicBase.getPSSysViewPanelName() != null) {
            object = pSSysDashboardLogicBase.getPSSysViewPanelName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDashboardLogicBase.getTimer() != null) {
            object = pSSysDashboardLogicBase.getTimer();
            xmlNode.setAttribute(FIELD_TIMER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDashboardLogicBase.getTriggerType() != null) {
            object = pSSysDashboardLogicBase.getTriggerType();
            xmlNode.setAttribute(FIELD_TRIGGERTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysDashboardLogicBase.getUpdateDate() != null) {
            object = pSSysDashboardLogicBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysDashboardLogicBase.getUpdateMan() != null) {
            object = pSSysDashboardLogicBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysDashboardLogicBase.getUserCat() != null) {
            object = pSSysDashboardLogicBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysDashboardLogicBase.getUserTag() != null) {
            object = pSSysDashboardLogicBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysDashboardLogicBase.getUserTag2() != null) {
            object = pSSysDashboardLogicBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysDashboardLogicBase.getUserTag3() != null) {
            object = pSSysDashboardLogicBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysDashboardLogicBase.getUserTag4() != null) {
            object = pSSysDashboardLogicBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysDashboardLogicBase.getValidFlag() != null) {
            object = pSSysDashboardLogicBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysDashboardLogicBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysDashboardLogicBase pSSysDashboardLogicBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysDashboardLogicBase.isAttrNameDirty() && (bl || pSSysDashboardLogicBase.getAttrName() != null)) {
            iDataObject.set(FIELD_ATTRNAME, (Object)pSSysDashboardLogicBase.getAttrName());
        }
        if (pSSysDashboardLogicBase.isCreateDateDirty() && (bl || pSSysDashboardLogicBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysDashboardLogicBase.getCreateDate());
        }
        if (pSSysDashboardLogicBase.isCreateManDirty() && (bl || pSSysDashboardLogicBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysDashboardLogicBase.getCreateMan());
        }
        if (pSSysDashboardLogicBase.isCustomCodeDirty() && (bl || pSSysDashboardLogicBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSSysDashboardLogicBase.getCustomCode());
        }
        if (pSSysDashboardLogicBase.isDstLogicTypeDirty() && (bl || pSSysDashboardLogicBase.getDstLogicType() != null)) {
            iDataObject.set(FIELD_DSTLOGICTYPE, (Object)pSSysDashboardLogicBase.getDstLogicType());
        }
        if (pSSysDashboardLogicBase.isEventArgDirty() && (bl || pSSysDashboardLogicBase.getEventArg() != null)) {
            iDataObject.set(FIELD_EVENTARG, (Object)pSSysDashboardLogicBase.getEventArg());
        }
        if (pSSysDashboardLogicBase.isEventArg2Dirty() && (bl || pSSysDashboardLogicBase.getEventArg2() != null)) {
            iDataObject.set(FIELD_EVENTARG2, (Object)pSSysDashboardLogicBase.getEventArg2());
        }
        if (pSSysDashboardLogicBase.isEventNamesDirty() && (bl || pSSysDashboardLogicBase.getEventNames() != null)) {
            iDataObject.set(FIELD_EVENTNAMES, (Object)pSSysDashboardLogicBase.getEventNames());
        }
        if (pSSysDashboardLogicBase.isLogicParamDirty() && (bl || pSSysDashboardLogicBase.getLogicParam() != null)) {
            iDataObject.set(FIELD_LOGICPARAM, (Object)pSSysDashboardLogicBase.getLogicParam());
        }
        if (pSSysDashboardLogicBase.isLogicParam2Dirty() && (bl || pSSysDashboardLogicBase.getLogicParam2() != null)) {
            iDataObject.set(FIELD_LOGICPARAM2, (Object)pSSysDashboardLogicBase.getLogicParam2());
        }
        if (pSSysDashboardLogicBase.isMemoDirty() && (bl || pSSysDashboardLogicBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysDashboardLogicBase.getMemo());
        }
        if (pSSysDashboardLogicBase.isOrderValueDirty() && (bl || pSSysDashboardLogicBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSysDashboardLogicBase.getOrderValue());
        }
        if (pSSysDashboardLogicBase.isPSDEIdDirty() && (bl || pSSysDashboardLogicBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSSysDashboardLogicBase.getPSDEId());
        }
        if (pSSysDashboardLogicBase.isPSDELogicIdDirty() && (bl || pSSysDashboardLogicBase.getPSDELogicId() != null)) {
            iDataObject.set(FIELD_PSDELOGICID, (Object)pSSysDashboardLogicBase.getPSDELogicId());
        }
        if (pSSysDashboardLogicBase.isPSDELogicNameDirty() && (bl || pSSysDashboardLogicBase.getPSDELogicName() != null)) {
            iDataObject.set(FIELD_PSDELOGICNAME, (Object)pSSysDashboardLogicBase.getPSDELogicName());
        }
        if (pSSysDashboardLogicBase.isPSDENameDirty() && (bl || pSSysDashboardLogicBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSSysDashboardLogicBase.getPSDEName());
        }
        if (pSSysDashboardLogicBase.isPSDEUIActionIdDirty() && (bl || pSSysDashboardLogicBase.getPSDEUIActionId() != null)) {
            iDataObject.set(FIELD_PSDEUIACTIONID, (Object)pSSysDashboardLogicBase.getPSDEUIActionId());
        }
        if (pSSysDashboardLogicBase.isPSDEUIActionNameDirty() && (bl || pSSysDashboardLogicBase.getPSDEUIActionName() != null)) {
            iDataObject.set(FIELD_PSDEUIACTIONNAME, (Object)pSSysDashboardLogicBase.getPSDEUIActionName());
        }
        if (pSSysDashboardLogicBase.isPSSysDashboardIdDirty() && (bl || pSSysDashboardLogicBase.getPSSysDashboardId() != null)) {
            iDataObject.set(FIELD_PSSYSDASHBOARDID, (Object)pSSysDashboardLogicBase.getPSSysDashboardId());
        }
        if (pSSysDashboardLogicBase.isPSSysDashboardLogicIdDirty() && (bl || pSSysDashboardLogicBase.getPSSysDashboardLogicId() != null)) {
            iDataObject.set(FIELD_PSSYSDASHBOARDLOGICID, (Object)pSSysDashboardLogicBase.getPSSysDashboardLogicId());
        }
        if (pSSysDashboardLogicBase.isPSSysDashboardLogicNameDirty() && (bl || pSSysDashboardLogicBase.getPSSysDashboardLogicName() != null)) {
            iDataObject.set(FIELD_PSSYSDASHBOARDLOGICNAME, (Object)pSSysDashboardLogicBase.getPSSysDashboardLogicName());
        }
        if (pSSysDashboardLogicBase.isPSSysDashboardNameDirty() && (bl || pSSysDashboardLogicBase.getPSSysDashboardName() != null)) {
            iDataObject.set(FIELD_PSSYSDASHBOARDNAME, (Object)pSSysDashboardLogicBase.getPSSysDashboardName());
        }
        if (pSSysDashboardLogicBase.isPSSysDBPartIdDirty() && (bl || pSSysDashboardLogicBase.getPSSysDBPartId() != null)) {
            iDataObject.set(FIELD_PSSYSDBPARTID, (Object)pSSysDashboardLogicBase.getPSSysDBPartId());
        }
        if (pSSysDashboardLogicBase.isPSSysDBPartNameDirty() && (bl || pSSysDashboardLogicBase.getPSSysDBPartName() != null)) {
            iDataObject.set(FIELD_PSSYSDBPARTNAME, (Object)pSSysDashboardLogicBase.getPSSysDBPartName());
        }
        if (pSSysDashboardLogicBase.isPSSysPFPluginIdDirty() && (bl || pSSysDashboardLogicBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSSysDashboardLogicBase.getPSSysPFPluginId());
        }
        if (pSSysDashboardLogicBase.isPSSysPFPluginNameDirty() && (bl || pSSysDashboardLogicBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSSysDashboardLogicBase.getPSSysPFPluginName());
        }
        if (pSSysDashboardLogicBase.isPSSysViewLogicIdDirty() && (bl || pSSysDashboardLogicBase.getPSSysViewLogicId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWLOGICID, (Object)pSSysDashboardLogicBase.getPSSysViewLogicId());
        }
        if (pSSysDashboardLogicBase.isPSSysViewLogicNameDirty() && (bl || pSSysDashboardLogicBase.getPSSysViewLogicName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWLOGICNAME, (Object)pSSysDashboardLogicBase.getPSSysViewLogicName());
        }
        if (pSSysDashboardLogicBase.isPSSysViewPanelIdDirty() && (bl || pSSysDashboardLogicBase.getPSSysViewPanelId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELID, (Object)pSSysDashboardLogicBase.getPSSysViewPanelId());
        }
        if (pSSysDashboardLogicBase.isPSSysViewPanelNameDirty() && (bl || pSSysDashboardLogicBase.getPSSysViewPanelName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELNAME, (Object)pSSysDashboardLogicBase.getPSSysViewPanelName());
        }
        if (pSSysDashboardLogicBase.isTimerDirty() && (bl || pSSysDashboardLogicBase.getTimer() != null)) {
            iDataObject.set(FIELD_TIMER, (Object)pSSysDashboardLogicBase.getTimer());
        }
        if (pSSysDashboardLogicBase.isTriggerTypeDirty() && (bl || pSSysDashboardLogicBase.getTriggerType() != null)) {
            iDataObject.set(FIELD_TRIGGERTYPE, (Object)pSSysDashboardLogicBase.getTriggerType());
        }
        if (pSSysDashboardLogicBase.isUpdateDateDirty() && (bl || pSSysDashboardLogicBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysDashboardLogicBase.getUpdateDate());
        }
        if (pSSysDashboardLogicBase.isUpdateManDirty() && (bl || pSSysDashboardLogicBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysDashboardLogicBase.getUpdateMan());
        }
        if (pSSysDashboardLogicBase.isUserCatDirty() && (bl || pSSysDashboardLogicBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysDashboardLogicBase.getUserCat());
        }
        if (pSSysDashboardLogicBase.isUserTagDirty() && (bl || pSSysDashboardLogicBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysDashboardLogicBase.getUserTag());
        }
        if (pSSysDashboardLogicBase.isUserTag2Dirty() && (bl || pSSysDashboardLogicBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysDashboardLogicBase.getUserTag2());
        }
        if (pSSysDashboardLogicBase.isUserTag3Dirty() && (bl || pSSysDashboardLogicBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysDashboardLogicBase.getUserTag3());
        }
        if (pSSysDashboardLogicBase.isUserTag4Dirty() && (bl || pSSysDashboardLogicBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysDashboardLogicBase.getUserTag4());
        }
        if (pSSysDashboardLogicBase.isValidFlagDirty() && (bl || pSSysDashboardLogicBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysDashboardLogicBase.getValidFlag());
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
        return PSSysDashboardLogicBase.remove(this, n);
    }

    private static boolean remove(PSSysDashboardLogicBase pSSysDashboardLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysDashboardLogicBase.resetAttrName();
                return true;
            }
            case 1: {
                pSSysDashboardLogicBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSysDashboardLogicBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSysDashboardLogicBase.resetCustomCode();
                return true;
            }
            case 4: {
                pSSysDashboardLogicBase.resetDstLogicType();
                return true;
            }
            case 5: {
                pSSysDashboardLogicBase.resetEventArg();
                return true;
            }
            case 6: {
                pSSysDashboardLogicBase.resetEventArg2();
                return true;
            }
            case 7: {
                pSSysDashboardLogicBase.resetEventNames();
                return true;
            }
            case 8: {
                pSSysDashboardLogicBase.resetLogicParam();
                return true;
            }
            case 9: {
                pSSysDashboardLogicBase.resetLogicParam2();
                return true;
            }
            case 10: {
                pSSysDashboardLogicBase.resetMemo();
                return true;
            }
            case 11: {
                pSSysDashboardLogicBase.resetOrderValue();
                return true;
            }
            case 12: {
                pSSysDashboardLogicBase.resetPSDEId();
                return true;
            }
            case 13: {
                pSSysDashboardLogicBase.resetPSDELogicId();
                return true;
            }
            case 14: {
                pSSysDashboardLogicBase.resetPSDELogicName();
                return true;
            }
            case 15: {
                pSSysDashboardLogicBase.resetPSDEName();
                return true;
            }
            case 16: {
                pSSysDashboardLogicBase.resetPSDEUIActionId();
                return true;
            }
            case 17: {
                pSSysDashboardLogicBase.resetPSDEUIActionName();
                return true;
            }
            case 18: {
                pSSysDashboardLogicBase.resetPSSysDashboardId();
                return true;
            }
            case 19: {
                pSSysDashboardLogicBase.resetPSSysDashboardLogicId();
                return true;
            }
            case 20: {
                pSSysDashboardLogicBase.resetPSSysDashboardLogicName();
                return true;
            }
            case 21: {
                pSSysDashboardLogicBase.resetPSSysDashboardName();
                return true;
            }
            case 22: {
                pSSysDashboardLogicBase.resetPSSysDBPartId();
                return true;
            }
            case 23: {
                pSSysDashboardLogicBase.resetPSSysDBPartName();
                return true;
            }
            case 24: {
                pSSysDashboardLogicBase.resetPSSysPFPluginId();
                return true;
            }
            case 25: {
                pSSysDashboardLogicBase.resetPSSysPFPluginName();
                return true;
            }
            case 26: {
                pSSysDashboardLogicBase.resetPSSysViewLogicId();
                return true;
            }
            case 27: {
                pSSysDashboardLogicBase.resetPSSysViewLogicName();
                return true;
            }
            case 28: {
                pSSysDashboardLogicBase.resetPSSysViewPanelId();
                return true;
            }
            case 29: {
                pSSysDashboardLogicBase.resetPSSysViewPanelName();
                return true;
            }
            case 30: {
                pSSysDashboardLogicBase.resetTimer();
                return true;
            }
            case 31: {
                pSSysDashboardLogicBase.resetTriggerType();
                return true;
            }
            case 32: {
                pSSysDashboardLogicBase.resetUpdateDate();
                return true;
            }
            case 33: {
                pSSysDashboardLogicBase.resetUpdateMan();
                return true;
            }
            case 34: {
                pSSysDashboardLogicBase.resetUserCat();
                return true;
            }
            case 35: {
                pSSysDashboardLogicBase.resetUserTag();
                return true;
            }
            case 36: {
                pSSysDashboardLogicBase.resetUserTag2();
                return true;
            }
            case 37: {
                pSSysDashboardLogicBase.resetUserTag3();
                return true;
            }
            case 38: {
                pSSysDashboardLogicBase.resetUserTag4();
                return true;
            }
            case 39: {
                pSSysDashboardLogicBase.resetValidFlag();
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
    public PSSysDashboard getPSSysDashboard() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDashboard();
        }
        if (this.getPSSysDashboardId() == null) {
            return null;
        }
        Integer n = this.objPSSysDashboardLock;
        synchronized (n) {
            if (this.pssysdashboard != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysDashboardId(), (Object)this.pssysdashboard.getPSSysDashboardId()) != 0L) {
                this.pssysdashboard = null;
            }
            if (this.pssysdashboard == null) {
                PSSysDashboard pSSysDashboard = new PSSysDashboard();
                pSSysDashboard.setPSSysDashboardId(this.getPSSysDashboardId());
                PSSysDashboardService pSSysDashboardService = (PSSysDashboardService)ServiceGlobal.getService(PSSysDashboardService.class, (SessionFactory)this.getSessionFactory());
                pSSysDashboardService.autoGet(pSSysDashboard);
                this.pssysdashboard = pSSysDashboard;
            }
            return this.pssysdashboard;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysDBPart getPSSysDBPart() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBPart();
        }
        if (this.getPSSysDBPartId() == null) {
            return null;
        }
        Integer n = this.objPSSysDBPartLock;
        synchronized (n) {
            if (this.pssysdbpart != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysDBPartId(), (Object)this.pssysdbpart.getPSSysDBPartId()) != 0L) {
                this.pssysdbpart = null;
            }
            if (this.pssysdbpart == null) {
                PSSysDBPart pSSysDBPart = new PSSysDBPart();
                pSSysDBPart.setPSSysDBPartId(this.getPSSysDBPartId());
                PSSysDBPartService pSSysDBPartService = (PSSysDBPartService)ServiceGlobal.getService(PSSysDBPartService.class, (SessionFactory)this.getSessionFactory());
                pSSysDBPartService.autoGet(pSSysDBPart);
                this.pssysdbpart = pSSysDBPart;
            }
            return this.pssysdbpart;
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

    private PSSysDashboardLogicBase getProxyEntity() {
        return this.proxyPSSysDashboardLogicBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysDashboardLogicBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysDashboardLogicBase) {
            this.proxyPSSysDashboardLogicBase = (PSSysDashboardLogicBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDashboardLogicService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
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
        fieldIndexMap.put(FIELD_PSSYSDASHBOARDID, 18);
        fieldIndexMap.put(FIELD_PSSYSDASHBOARDLOGICID, 19);
        fieldIndexMap.put(FIELD_PSSYSDASHBOARDLOGICNAME, 20);
        fieldIndexMap.put(FIELD_PSSYSDASHBOARDNAME, 21);
        fieldIndexMap.put(FIELD_PSSYSDBPARTID, 22);
        fieldIndexMap.put(FIELD_PSSYSDBPARTNAME, 23);
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

