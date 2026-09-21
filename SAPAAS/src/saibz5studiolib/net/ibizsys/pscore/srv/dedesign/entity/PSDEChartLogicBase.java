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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEChart;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEChartAxes;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEChartParam;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEChartAxesService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEChartParamService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEChartService;
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

public abstract class PSDEChartLogicBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEChartLogicBase.class);
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
    public static final String FIELD_PSDECHARTAXESID = "PSDECHARTAXESID";
    public static final String FIELD_PSDECHARTAXESNAME = "PSDECHARTAXESNAME";
    public static final String FIELD_PSDECHARTID = "PSDECHARTID";
    public static final String FIELD_PSDECHARTLOGICID = "PSDECHARTLOGICID";
    public static final String FIELD_PSDECHARTLOGICNAME = "PSDECHARTLOGICNAME";
    public static final String FIELD_PSDECHARTNAME = "PSDECHARTNAME";
    public static final String FIELD_PSDECHARTPARAMID = "PSDECHARTPARAMID";
    public static final String FIELD_PSDECHARTPARAMNAME = "PSDECHARTPARAMNAME";
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
    private static final int INDEX_PSDECHARTAXESID = 12;
    private static final int INDEX_PSDECHARTAXESNAME = 13;
    private static final int INDEX_PSDECHARTID = 14;
    private static final int INDEX_PSDECHARTLOGICID = 15;
    private static final int INDEX_PSDECHARTLOGICNAME = 16;
    private static final int INDEX_PSDECHARTNAME = 17;
    private static final int INDEX_PSDECHARTPARAMID = 18;
    private static final int INDEX_PSDECHARTPARAMNAME = 19;
    private static final int INDEX_PSDEID = 20;
    private static final int INDEX_PSDELOGICID = 21;
    private static final int INDEX_PSDELOGICNAME = 22;
    private static final int INDEX_PSDENAME = 23;
    private static final int INDEX_PSDEUIACTIONID = 24;
    private static final int INDEX_PSDEUIACTIONNAME = 25;
    private static final int INDEX_PSSYSPFPLUGINID = 26;
    private static final int INDEX_PSSYSPFPLUGINNAME = 27;
    private static final int INDEX_PSSYSVIEWLOGICID = 28;
    private static final int INDEX_PSSYSVIEWLOGICNAME = 29;
    private static final int INDEX_PSSYSVIEWPANELID = 30;
    private static final int INDEX_PSSYSVIEWPANELNAME = 31;
    private static final int INDEX_TIMER = 32;
    private static final int INDEX_TRIGGERTYPE = 33;
    private static final int INDEX_UPDATEDATE = 34;
    private static final int INDEX_UPDATEMAN = 35;
    private static final int INDEX_USERCAT = 36;
    private static final int INDEX_USERTAG = 37;
    private static final int INDEX_USERTAG2 = 38;
    private static final int INDEX_USERTAG3 = 39;
    private static final int INDEX_USERTAG4 = 40;
    private static final int INDEX_VALIDFLAG = 41;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEChartLogicBase proxyPSDEChartLogicBase = null;
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
    private boolean psdechartaxesidDirtyFlag = false;
    private boolean psdechartaxesnameDirtyFlag = false;
    private boolean psdechartidDirtyFlag = false;
    private boolean psdechartlogicidDirtyFlag = false;
    private boolean psdechartlogicnameDirtyFlag = false;
    private boolean psdechartnameDirtyFlag = false;
    private boolean psdechartparamidDirtyFlag = false;
    private boolean psdechartparamnameDirtyFlag = false;
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
    @Column(name="psdechartaxesid")
    private String psdechartaxesid;
    @Column(name="psdechartaxesname")
    private String psdechartaxesname;
    @Column(name="psdechartid")
    private String psdechartid;
    @Column(name="psdechartlogicid")
    private String psdechartlogicid;
    @Column(name="psdechartlogicname")
    private String psdechartlogicname;
    @Column(name="psdechartname")
    private String psdechartname;
    @Column(name="psdechartparamid")
    private String psdechartparamid;
    @Column(name="psdechartparamname")
    private String psdechartparamname;
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
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objPSDEChartAxesLock = new Integer(1);
    private PSDEChartAxes psdechartaxes = null;
    private Integer objPSDEChartParamLock = new Integer(1);
    private PSDEChartParam psdechartparam = null;
    private Integer objPSDEChartLock = new Integer(1);
    private PSDEChart psdechart = null;
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

    public void setPSDEChartAxesId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEChartAxesId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdechartaxesid = string;
        this.psdechartaxesidDirtyFlag = true;
    }

    public String getPSDEChartAxesId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEChartAxesId();
        }
        return this.psdechartaxesid;
    }

    public boolean isPSDEChartAxesIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEChartAxesIdDirty();
        }
        return this.psdechartaxesidDirtyFlag;
    }

    public void resetPSDEChartAxesId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEChartAxesId();
            return;
        }
        this.psdechartaxesidDirtyFlag = false;
        this.psdechartaxesid = null;
    }

    public void setPSDEChartAxesName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEChartAxesName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdechartaxesname = string;
        this.psdechartaxesnameDirtyFlag = true;
    }

    public String getPSDEChartAxesName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEChartAxesName();
        }
        return this.psdechartaxesname;
    }

    public boolean isPSDEChartAxesNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEChartAxesNameDirty();
        }
        return this.psdechartaxesnameDirtyFlag;
    }

    public void resetPSDEChartAxesName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEChartAxesName();
            return;
        }
        this.psdechartaxesnameDirtyFlag = false;
        this.psdechartaxesname = null;
    }

    public void setPSDEChartId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEChartId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdechartid = string;
        this.psdechartidDirtyFlag = true;
    }

    public String getPSDEChartId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEChartId();
        }
        return this.psdechartid;
    }

    public boolean isPSDEChartIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEChartIdDirty();
        }
        return this.psdechartidDirtyFlag;
    }

    public void resetPSDEChartId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEChartId();
            return;
        }
        this.psdechartidDirtyFlag = false;
        this.psdechartid = null;
    }

    public void setPSDEChartLogicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEChartLogicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdechartlogicid = string;
        this.psdechartlogicidDirtyFlag = true;
    }

    public String getPSDEChartLogicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEChartLogicId();
        }
        return this.psdechartlogicid;
    }

    public boolean isPSDEChartLogicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEChartLogicIdDirty();
        }
        return this.psdechartlogicidDirtyFlag;
    }

    public void resetPSDEChartLogicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEChartLogicId();
            return;
        }
        this.psdechartlogicidDirtyFlag = false;
        this.psdechartlogicid = null;
    }

    public void setPSDEChartLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEChartLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdechartlogicname = string;
        this.psdechartlogicnameDirtyFlag = true;
    }

    public String getPSDEChartLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEChartLogicName();
        }
        return this.psdechartlogicname;
    }

    public boolean isPSDEChartLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEChartLogicNameDirty();
        }
        return this.psdechartlogicnameDirtyFlag;
    }

    public void resetPSDEChartLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEChartLogicName();
            return;
        }
        this.psdechartlogicnameDirtyFlag = false;
        this.psdechartlogicname = null;
    }

    public void setPSDEChartName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEChartName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdechartname = string;
        this.psdechartnameDirtyFlag = true;
    }

    public String getPSDEChartName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEChartName();
        }
        return this.psdechartname;
    }

    public boolean isPSDEChartNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEChartNameDirty();
        }
        return this.psdechartnameDirtyFlag;
    }

    public void resetPSDEChartName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEChartName();
            return;
        }
        this.psdechartnameDirtyFlag = false;
        this.psdechartname = null;
    }

    public void setPSDEChartParamId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEChartParamId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdechartparamid = string;
        this.psdechartparamidDirtyFlag = true;
    }

    public String getPSDEChartParamId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEChartParamId();
        }
        return this.psdechartparamid;
    }

    public boolean isPSDEChartParamIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEChartParamIdDirty();
        }
        return this.psdechartparamidDirtyFlag;
    }

    public void resetPSDEChartParamId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEChartParamId();
            return;
        }
        this.psdechartparamidDirtyFlag = false;
        this.psdechartparamid = null;
    }

    public void setPSDEChartParamName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEChartParamName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdechartparamname = string;
        this.psdechartparamnameDirtyFlag = true;
    }

    public String getPSDEChartParamName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEChartParamName();
        }
        return this.psdechartparamname;
    }

    public boolean isPSDEChartParamNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEChartParamNameDirty();
        }
        return this.psdechartparamnameDirtyFlag;
    }

    public void resetPSDEChartParamName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEChartParamName();
            return;
        }
        this.psdechartparamnameDirtyFlag = false;
        this.psdechartparamname = null;
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
        PSDEChartLogicBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEChartLogicBase pSDEChartLogicBase) {
        pSDEChartLogicBase.resetAttrName();
        pSDEChartLogicBase.resetCreateDate();
        pSDEChartLogicBase.resetCreateMan();
        pSDEChartLogicBase.resetCustomCode();
        pSDEChartLogicBase.resetDstLogicType();
        pSDEChartLogicBase.resetEventArg();
        pSDEChartLogicBase.resetEventArg2();
        pSDEChartLogicBase.resetEventNames();
        pSDEChartLogicBase.resetLogicParam();
        pSDEChartLogicBase.resetLogicParam2();
        pSDEChartLogicBase.resetMemo();
        pSDEChartLogicBase.resetOrderValue();
        pSDEChartLogicBase.resetPSDEChartAxesId();
        pSDEChartLogicBase.resetPSDEChartAxesName();
        pSDEChartLogicBase.resetPSDEChartId();
        pSDEChartLogicBase.resetPSDEChartLogicId();
        pSDEChartLogicBase.resetPSDEChartLogicName();
        pSDEChartLogicBase.resetPSDEChartName();
        pSDEChartLogicBase.resetPSDEChartParamId();
        pSDEChartLogicBase.resetPSDEChartParamName();
        pSDEChartLogicBase.resetPSDEId();
        pSDEChartLogicBase.resetPSDELogicId();
        pSDEChartLogicBase.resetPSDELogicName();
        pSDEChartLogicBase.resetPSDEName();
        pSDEChartLogicBase.resetPSDEUIActionId();
        pSDEChartLogicBase.resetPSDEUIActionName();
        pSDEChartLogicBase.resetPSSysPFPluginId();
        pSDEChartLogicBase.resetPSSysPFPluginName();
        pSDEChartLogicBase.resetPSSysViewLogicId();
        pSDEChartLogicBase.resetPSSysViewLogicName();
        pSDEChartLogicBase.resetPSSysViewPanelId();
        pSDEChartLogicBase.resetPSSysViewPanelName();
        pSDEChartLogicBase.resetTimer();
        pSDEChartLogicBase.resetTriggerType();
        pSDEChartLogicBase.resetUpdateDate();
        pSDEChartLogicBase.resetUpdateMan();
        pSDEChartLogicBase.resetUserCat();
        pSDEChartLogicBase.resetUserTag();
        pSDEChartLogicBase.resetUserTag2();
        pSDEChartLogicBase.resetUserTag3();
        pSDEChartLogicBase.resetUserTag4();
        pSDEChartLogicBase.resetValidFlag();
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
        if (!bl || this.isPSDEChartAxesIdDirty()) {
            hashMap.put(FIELD_PSDECHARTAXESID, this.getPSDEChartAxesId());
        }
        if (!bl || this.isPSDEChartAxesNameDirty()) {
            hashMap.put(FIELD_PSDECHARTAXESNAME, this.getPSDEChartAxesName());
        }
        if (!bl || this.isPSDEChartIdDirty()) {
            hashMap.put(FIELD_PSDECHARTID, this.getPSDEChartId());
        }
        if (!bl || this.isPSDEChartLogicIdDirty()) {
            hashMap.put(FIELD_PSDECHARTLOGICID, this.getPSDEChartLogicId());
        }
        if (!bl || this.isPSDEChartLogicNameDirty()) {
            hashMap.put(FIELD_PSDECHARTLOGICNAME, this.getPSDEChartLogicName());
        }
        if (!bl || this.isPSDEChartNameDirty()) {
            hashMap.put(FIELD_PSDECHARTNAME, this.getPSDEChartName());
        }
        if (!bl || this.isPSDEChartParamIdDirty()) {
            hashMap.put(FIELD_PSDECHARTPARAMID, this.getPSDEChartParamId());
        }
        if (!bl || this.isPSDEChartParamNameDirty()) {
            hashMap.put(FIELD_PSDECHARTPARAMNAME, this.getPSDEChartParamName());
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
        return PSDEChartLogicBase.get(this, n);
    }

    private static Object get(PSDEChartLogicBase pSDEChartLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEChartLogicBase.getAttrName();
            }
            case 1: {
                return pSDEChartLogicBase.getCreateDate();
            }
            case 2: {
                return pSDEChartLogicBase.getCreateMan();
            }
            case 3: {
                return pSDEChartLogicBase.getCustomCode();
            }
            case 4: {
                return pSDEChartLogicBase.getDstLogicType();
            }
            case 5: {
                return pSDEChartLogicBase.getEventArg();
            }
            case 6: {
                return pSDEChartLogicBase.getEventArg2();
            }
            case 7: {
                return pSDEChartLogicBase.getEventNames();
            }
            case 8: {
                return pSDEChartLogicBase.getLogicParam();
            }
            case 9: {
                return pSDEChartLogicBase.getLogicParam2();
            }
            case 10: {
                return pSDEChartLogicBase.getMemo();
            }
            case 11: {
                return pSDEChartLogicBase.getOrderValue();
            }
            case 12: {
                return pSDEChartLogicBase.getPSDEChartAxesId();
            }
            case 13: {
                return pSDEChartLogicBase.getPSDEChartAxesName();
            }
            case 14: {
                return pSDEChartLogicBase.getPSDEChartId();
            }
            case 15: {
                return pSDEChartLogicBase.getPSDEChartLogicId();
            }
            case 16: {
                return pSDEChartLogicBase.getPSDEChartLogicName();
            }
            case 17: {
                return pSDEChartLogicBase.getPSDEChartName();
            }
            case 18: {
                return pSDEChartLogicBase.getPSDEChartParamId();
            }
            case 19: {
                return pSDEChartLogicBase.getPSDEChartParamName();
            }
            case 20: {
                return pSDEChartLogicBase.getPSDEId();
            }
            case 21: {
                return pSDEChartLogicBase.getPSDELogicId();
            }
            case 22: {
                return pSDEChartLogicBase.getPSDELogicName();
            }
            case 23: {
                return pSDEChartLogicBase.getPSDEName();
            }
            case 24: {
                return pSDEChartLogicBase.getPSDEUIActionId();
            }
            case 25: {
                return pSDEChartLogicBase.getPSDEUIActionName();
            }
            case 26: {
                return pSDEChartLogicBase.getPSSysPFPluginId();
            }
            case 27: {
                return pSDEChartLogicBase.getPSSysPFPluginName();
            }
            case 28: {
                return pSDEChartLogicBase.getPSSysViewLogicId();
            }
            case 29: {
                return pSDEChartLogicBase.getPSSysViewLogicName();
            }
            case 30: {
                return pSDEChartLogicBase.getPSSysViewPanelId();
            }
            case 31: {
                return pSDEChartLogicBase.getPSSysViewPanelName();
            }
            case 32: {
                return pSDEChartLogicBase.getTimer();
            }
            case 33: {
                return pSDEChartLogicBase.getTriggerType();
            }
            case 34: {
                return pSDEChartLogicBase.getUpdateDate();
            }
            case 35: {
                return pSDEChartLogicBase.getUpdateMan();
            }
            case 36: {
                return pSDEChartLogicBase.getUserCat();
            }
            case 37: {
                return pSDEChartLogicBase.getUserTag();
            }
            case 38: {
                return pSDEChartLogicBase.getUserTag2();
            }
            case 39: {
                return pSDEChartLogicBase.getUserTag3();
            }
            case 40: {
                return pSDEChartLogicBase.getUserTag4();
            }
            case 41: {
                return pSDEChartLogicBase.getValidFlag();
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
        PSDEChartLogicBase.set(this, n, object);
    }

    private static void set(PSDEChartLogicBase pSDEChartLogicBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEChartLogicBase.setAttrName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDEChartLogicBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDEChartLogicBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEChartLogicBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEChartLogicBase.setDstLogicType(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEChartLogicBase.setEventArg(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEChartLogicBase.setEventArg2(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEChartLogicBase.setEventNames(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEChartLogicBase.setLogicParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEChartLogicBase.setLogicParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEChartLogicBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEChartLogicBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSDEChartLogicBase.setPSDEChartAxesId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEChartLogicBase.setPSDEChartAxesName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEChartLogicBase.setPSDEChartId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEChartLogicBase.setPSDEChartLogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEChartLogicBase.setPSDEChartLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEChartLogicBase.setPSDEChartName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEChartLogicBase.setPSDEChartParamId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEChartLogicBase.setPSDEChartParamName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDEChartLogicBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEChartLogicBase.setPSDELogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDEChartLogicBase.setPSDELogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDEChartLogicBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDEChartLogicBase.setPSDEUIActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDEChartLogicBase.setPSDEUIActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDEChartLogicBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDEChartLogicBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDEChartLogicBase.setPSSysViewLogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDEChartLogicBase.setPSSysViewLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDEChartLogicBase.setPSSysViewPanelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDEChartLogicBase.setPSSysViewPanelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDEChartLogicBase.setTimer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 33: {
                pSDEChartLogicBase.setTriggerType(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDEChartLogicBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 35: {
                pSDEChartLogicBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDEChartLogicBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSDEChartLogicBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDEChartLogicBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSDEChartLogicBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSDEChartLogicBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSDEChartLogicBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDEChartLogicBase.isNull(this, n);
    }

    private static boolean isNull(PSDEChartLogicBase pSDEChartLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEChartLogicBase.getAttrName() == null;
            }
            case 1: {
                return pSDEChartLogicBase.getCreateDate() == null;
            }
            case 2: {
                return pSDEChartLogicBase.getCreateMan() == null;
            }
            case 3: {
                return pSDEChartLogicBase.getCustomCode() == null;
            }
            case 4: {
                return pSDEChartLogicBase.getDstLogicType() == null;
            }
            case 5: {
                return pSDEChartLogicBase.getEventArg() == null;
            }
            case 6: {
                return pSDEChartLogicBase.getEventArg2() == null;
            }
            case 7: {
                return pSDEChartLogicBase.getEventNames() == null;
            }
            case 8: {
                return pSDEChartLogicBase.getLogicParam() == null;
            }
            case 9: {
                return pSDEChartLogicBase.getLogicParam2() == null;
            }
            case 10: {
                return pSDEChartLogicBase.getMemo() == null;
            }
            case 11: {
                return pSDEChartLogicBase.getOrderValue() == null;
            }
            case 12: {
                return pSDEChartLogicBase.getPSDEChartAxesId() == null;
            }
            case 13: {
                return pSDEChartLogicBase.getPSDEChartAxesName() == null;
            }
            case 14: {
                return pSDEChartLogicBase.getPSDEChartId() == null;
            }
            case 15: {
                return pSDEChartLogicBase.getPSDEChartLogicId() == null;
            }
            case 16: {
                return pSDEChartLogicBase.getPSDEChartLogicName() == null;
            }
            case 17: {
                return pSDEChartLogicBase.getPSDEChartName() == null;
            }
            case 18: {
                return pSDEChartLogicBase.getPSDEChartParamId() == null;
            }
            case 19: {
                return pSDEChartLogicBase.getPSDEChartParamName() == null;
            }
            case 20: {
                return pSDEChartLogicBase.getPSDEId() == null;
            }
            case 21: {
                return pSDEChartLogicBase.getPSDELogicId() == null;
            }
            case 22: {
                return pSDEChartLogicBase.getPSDELogicName() == null;
            }
            case 23: {
                return pSDEChartLogicBase.getPSDEName() == null;
            }
            case 24: {
                return pSDEChartLogicBase.getPSDEUIActionId() == null;
            }
            case 25: {
                return pSDEChartLogicBase.getPSDEUIActionName() == null;
            }
            case 26: {
                return pSDEChartLogicBase.getPSSysPFPluginId() == null;
            }
            case 27: {
                return pSDEChartLogicBase.getPSSysPFPluginName() == null;
            }
            case 28: {
                return pSDEChartLogicBase.getPSSysViewLogicId() == null;
            }
            case 29: {
                return pSDEChartLogicBase.getPSSysViewLogicName() == null;
            }
            case 30: {
                return pSDEChartLogicBase.getPSSysViewPanelId() == null;
            }
            case 31: {
                return pSDEChartLogicBase.getPSSysViewPanelName() == null;
            }
            case 32: {
                return pSDEChartLogicBase.getTimer() == null;
            }
            case 33: {
                return pSDEChartLogicBase.getTriggerType() == null;
            }
            case 34: {
                return pSDEChartLogicBase.getUpdateDate() == null;
            }
            case 35: {
                return pSDEChartLogicBase.getUpdateMan() == null;
            }
            case 36: {
                return pSDEChartLogicBase.getUserCat() == null;
            }
            case 37: {
                return pSDEChartLogicBase.getUserTag() == null;
            }
            case 38: {
                return pSDEChartLogicBase.getUserTag2() == null;
            }
            case 39: {
                return pSDEChartLogicBase.getUserTag3() == null;
            }
            case 40: {
                return pSDEChartLogicBase.getUserTag4() == null;
            }
            case 41: {
                return pSDEChartLogicBase.getValidFlag() == null;
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
        return PSDEChartLogicBase.contains(this, n);
    }

    private static boolean contains(PSDEChartLogicBase pSDEChartLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEChartLogicBase.isAttrNameDirty();
            }
            case 1: {
                return pSDEChartLogicBase.isCreateDateDirty();
            }
            case 2: {
                return pSDEChartLogicBase.isCreateManDirty();
            }
            case 3: {
                return pSDEChartLogicBase.isCustomCodeDirty();
            }
            case 4: {
                return pSDEChartLogicBase.isDstLogicTypeDirty();
            }
            case 5: {
                return pSDEChartLogicBase.isEventArgDirty();
            }
            case 6: {
                return pSDEChartLogicBase.isEventArg2Dirty();
            }
            case 7: {
                return pSDEChartLogicBase.isEventNamesDirty();
            }
            case 8: {
                return pSDEChartLogicBase.isLogicParamDirty();
            }
            case 9: {
                return pSDEChartLogicBase.isLogicParam2Dirty();
            }
            case 10: {
                return pSDEChartLogicBase.isMemoDirty();
            }
            case 11: {
                return pSDEChartLogicBase.isOrderValueDirty();
            }
            case 12: {
                return pSDEChartLogicBase.isPSDEChartAxesIdDirty();
            }
            case 13: {
                return pSDEChartLogicBase.isPSDEChartAxesNameDirty();
            }
            case 14: {
                return pSDEChartLogicBase.isPSDEChartIdDirty();
            }
            case 15: {
                return pSDEChartLogicBase.isPSDEChartLogicIdDirty();
            }
            case 16: {
                return pSDEChartLogicBase.isPSDEChartLogicNameDirty();
            }
            case 17: {
                return pSDEChartLogicBase.isPSDEChartNameDirty();
            }
            case 18: {
                return pSDEChartLogicBase.isPSDEChartParamIdDirty();
            }
            case 19: {
                return pSDEChartLogicBase.isPSDEChartParamNameDirty();
            }
            case 20: {
                return pSDEChartLogicBase.isPSDEIdDirty();
            }
            case 21: {
                return pSDEChartLogicBase.isPSDELogicIdDirty();
            }
            case 22: {
                return pSDEChartLogicBase.isPSDELogicNameDirty();
            }
            case 23: {
                return pSDEChartLogicBase.isPSDENameDirty();
            }
            case 24: {
                return pSDEChartLogicBase.isPSDEUIActionIdDirty();
            }
            case 25: {
                return pSDEChartLogicBase.isPSDEUIActionNameDirty();
            }
            case 26: {
                return pSDEChartLogicBase.isPSSysPFPluginIdDirty();
            }
            case 27: {
                return pSDEChartLogicBase.isPSSysPFPluginNameDirty();
            }
            case 28: {
                return pSDEChartLogicBase.isPSSysViewLogicIdDirty();
            }
            case 29: {
                return pSDEChartLogicBase.isPSSysViewLogicNameDirty();
            }
            case 30: {
                return pSDEChartLogicBase.isPSSysViewPanelIdDirty();
            }
            case 31: {
                return pSDEChartLogicBase.isPSSysViewPanelNameDirty();
            }
            case 32: {
                return pSDEChartLogicBase.isTimerDirty();
            }
            case 33: {
                return pSDEChartLogicBase.isTriggerTypeDirty();
            }
            case 34: {
                return pSDEChartLogicBase.isUpdateDateDirty();
            }
            case 35: {
                return pSDEChartLogicBase.isUpdateManDirty();
            }
            case 36: {
                return pSDEChartLogicBase.isUserCatDirty();
            }
            case 37: {
                return pSDEChartLogicBase.isUserTagDirty();
            }
            case 38: {
                return pSDEChartLogicBase.isUserTag2Dirty();
            }
            case 39: {
                return pSDEChartLogicBase.isUserTag3Dirty();
            }
            case 40: {
                return pSDEChartLogicBase.isUserTag4Dirty();
            }
            case 41: {
                return pSDEChartLogicBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEChartLogicBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEChartLogicBase pSDEChartLogicBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEChartLogicBase.getAttrName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"attrname", (Object)PSDEChartLogicBase.getJSONValue((Object)pSDEChartLogicBase.getAttrName()), (boolean)false);
        }
        if (bl || pSDEChartLogicBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEChartLogicBase.getJSONValue((Object)pSDEChartLogicBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEChartLogicBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEChartLogicBase.getJSONValue((Object)pSDEChartLogicBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEChartLogicBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSDEChartLogicBase.getJSONValue((Object)pSDEChartLogicBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSDEChartLogicBase.getDstLogicType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstlogictype", (Object)PSDEChartLogicBase.getJSONValue((Object)pSDEChartLogicBase.getDstLogicType()), (boolean)false);
        }
        if (bl || pSDEChartLogicBase.getEventArg() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eventarg", (Object)PSDEChartLogicBase.getJSONValue((Object)pSDEChartLogicBase.getEventArg()), (boolean)false);
        }
        if (bl || pSDEChartLogicBase.getEventArg2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eventarg2", (Object)PSDEChartLogicBase.getJSONValue((Object)pSDEChartLogicBase.getEventArg2()), (boolean)false);
        }
        if (bl || pSDEChartLogicBase.getEventNames() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eventnames", (Object)PSDEChartLogicBase.getJSONValue((Object)pSDEChartLogicBase.getEventNames()), (boolean)false);
        }
        if (bl || pSDEChartLogicBase.getLogicParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicparam", (Object)PSDEChartLogicBase.getJSONValue((Object)pSDEChartLogicBase.getLogicParam()), (boolean)false);
        }
        if (bl || pSDEChartLogicBase.getLogicParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicparam2", (Object)PSDEChartLogicBase.getJSONValue((Object)pSDEChartLogicBase.getLogicParam2()), (boolean)false);
        }
        if (bl || pSDEChartLogicBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEChartLogicBase.getJSONValue((Object)pSDEChartLogicBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEChartLogicBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDEChartLogicBase.getJSONValue((Object)pSDEChartLogicBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDEChartLogicBase.getPSDEChartAxesId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdechartaxesid", (Object)PSDEChartLogicBase.getJSONValue((Object)pSDEChartLogicBase.getPSDEChartAxesId()), (boolean)false);
        }
        if (bl || pSDEChartLogicBase.getPSDEChartAxesName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdechartaxesname", (Object)PSDEChartLogicBase.getJSONValue((Object)pSDEChartLogicBase.getPSDEChartAxesName()), (boolean)false);
        }
        if (bl || pSDEChartLogicBase.getPSDEChartId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdechartid", (Object)PSDEChartLogicBase.getJSONValue((Object)pSDEChartLogicBase.getPSDEChartId()), (boolean)false);
        }
        if (bl || pSDEChartLogicBase.getPSDEChartLogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdechartlogicid", (Object)PSDEChartLogicBase.getJSONValue((Object)pSDEChartLogicBase.getPSDEChartLogicId()), (boolean)false);
        }
        if (bl || pSDEChartLogicBase.getPSDEChartLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdechartlogicname", (Object)PSDEChartLogicBase.getJSONValue((Object)pSDEChartLogicBase.getPSDEChartLogicName()), (boolean)false);
        }
        if (bl || pSDEChartLogicBase.getPSDEChartName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdechartname", (Object)PSDEChartLogicBase.getJSONValue((Object)pSDEChartLogicBase.getPSDEChartName()), (boolean)false);
        }
        if (bl || pSDEChartLogicBase.getPSDEChartParamId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdechartparamid", (Object)PSDEChartLogicBase.getJSONValue((Object)pSDEChartLogicBase.getPSDEChartParamId()), (boolean)false);
        }
        if (bl || pSDEChartLogicBase.getPSDEChartParamName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdechartparamname", (Object)PSDEChartLogicBase.getJSONValue((Object)pSDEChartLogicBase.getPSDEChartParamName()), (boolean)false);
        }
        if (bl || pSDEChartLogicBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEChartLogicBase.getJSONValue((Object)pSDEChartLogicBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEChartLogicBase.getPSDELogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicid", (Object)PSDEChartLogicBase.getJSONValue((Object)pSDEChartLogicBase.getPSDELogicId()), (boolean)false);
        }
        if (bl || pSDEChartLogicBase.getPSDELogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicname", (Object)PSDEChartLogicBase.getJSONValue((Object)pSDEChartLogicBase.getPSDELogicName()), (boolean)false);
        }
        if (bl || pSDEChartLogicBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDEChartLogicBase.getJSONValue((Object)pSDEChartLogicBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDEChartLogicBase.getPSDEUIActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuiactionid", (Object)PSDEChartLogicBase.getJSONValue((Object)pSDEChartLogicBase.getPSDEUIActionId()), (boolean)false);
        }
        if (bl || pSDEChartLogicBase.getPSDEUIActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuiactionname", (Object)PSDEChartLogicBase.getJSONValue((Object)pSDEChartLogicBase.getPSDEUIActionName()), (boolean)false);
        }
        if (bl || pSDEChartLogicBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSDEChartLogicBase.getJSONValue((Object)pSDEChartLogicBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSDEChartLogicBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSDEChartLogicBase.getJSONValue((Object)pSDEChartLogicBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSDEChartLogicBase.getPSSysViewLogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewlogicid", (Object)PSDEChartLogicBase.getJSONValue((Object)pSDEChartLogicBase.getPSSysViewLogicId()), (boolean)false);
        }
        if (bl || pSDEChartLogicBase.getPSSysViewLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewlogicname", (Object)PSDEChartLogicBase.getJSONValue((Object)pSDEChartLogicBase.getPSSysViewLogicName()), (boolean)false);
        }
        if (bl || pSDEChartLogicBase.getPSSysViewPanelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelid", (Object)PSDEChartLogicBase.getJSONValue((Object)pSDEChartLogicBase.getPSSysViewPanelId()), (boolean)false);
        }
        if (bl || pSDEChartLogicBase.getPSSysViewPanelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelname", (Object)PSDEChartLogicBase.getJSONValue((Object)pSDEChartLogicBase.getPSSysViewPanelName()), (boolean)false);
        }
        if (bl || pSDEChartLogicBase.getTimer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"timer", (Object)PSDEChartLogicBase.getJSONValue((Object)pSDEChartLogicBase.getTimer()), (boolean)false);
        }
        if (bl || pSDEChartLogicBase.getTriggerType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"triggertype", (Object)PSDEChartLogicBase.getJSONValue((Object)pSDEChartLogicBase.getTriggerType()), (boolean)false);
        }
        if (bl || pSDEChartLogicBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEChartLogicBase.getJSONValue((Object)pSDEChartLogicBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEChartLogicBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEChartLogicBase.getJSONValue((Object)pSDEChartLogicBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEChartLogicBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEChartLogicBase.getJSONValue((Object)pSDEChartLogicBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEChartLogicBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEChartLogicBase.getJSONValue((Object)pSDEChartLogicBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEChartLogicBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEChartLogicBase.getJSONValue((Object)pSDEChartLogicBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEChartLogicBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEChartLogicBase.getJSONValue((Object)pSDEChartLogicBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEChartLogicBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEChartLogicBase.getJSONValue((Object)pSDEChartLogicBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDEChartLogicBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDEChartLogicBase.getJSONValue((Object)pSDEChartLogicBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEChartLogicBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEChartLogicBase pSDEChartLogicBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEChartLogicBase.getAttrName() != null) {
            object = pSDEChartLogicBase.getAttrName();
            xmlNode.setAttribute(FIELD_ATTRNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartLogicBase.getCreateDate() != null) {
            object = pSDEChartLogicBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEChartLogicBase.getCreateMan() != null) {
            object = pSDEChartLogicBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartLogicBase.getCustomCode() != null) {
            object = pSDEChartLogicBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartLogicBase.getDstLogicType() != null) {
            object = pSDEChartLogicBase.getDstLogicType();
            xmlNode.setAttribute(FIELD_DSTLOGICTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartLogicBase.getEventArg() != null) {
            object = pSDEChartLogicBase.getEventArg();
            xmlNode.setAttribute(FIELD_EVENTARG, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartLogicBase.getEventArg2() != null) {
            object = pSDEChartLogicBase.getEventArg2();
            xmlNode.setAttribute(FIELD_EVENTARG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartLogicBase.getEventNames() != null) {
            object = pSDEChartLogicBase.getEventNames();
            xmlNode.setAttribute(FIELD_EVENTNAMES, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartLogicBase.getLogicParam() != null) {
            object = pSDEChartLogicBase.getLogicParam();
            xmlNode.setAttribute(FIELD_LOGICPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartLogicBase.getLogicParam2() != null) {
            object = pSDEChartLogicBase.getLogicParam2();
            xmlNode.setAttribute(FIELD_LOGICPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartLogicBase.getMemo() != null) {
            object = pSDEChartLogicBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartLogicBase.getOrderValue() != null) {
            object = pSDEChartLogicBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEChartLogicBase.getPSDEChartAxesId() != null) {
            object = pSDEChartLogicBase.getPSDEChartAxesId();
            xmlNode.setAttribute(FIELD_PSDECHARTAXESID, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartLogicBase.getPSDEChartAxesName() != null) {
            object = pSDEChartLogicBase.getPSDEChartAxesName();
            xmlNode.setAttribute(FIELD_PSDECHARTAXESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartLogicBase.getPSDEChartId() != null) {
            object = pSDEChartLogicBase.getPSDEChartId();
            xmlNode.setAttribute(FIELD_PSDECHARTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartLogicBase.getPSDEChartLogicId() != null) {
            object = pSDEChartLogicBase.getPSDEChartLogicId();
            xmlNode.setAttribute(FIELD_PSDECHARTLOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartLogicBase.getPSDEChartLogicName() != null) {
            object = pSDEChartLogicBase.getPSDEChartLogicName();
            xmlNode.setAttribute(FIELD_PSDECHARTLOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartLogicBase.getPSDEChartName() != null) {
            object = pSDEChartLogicBase.getPSDEChartName();
            xmlNode.setAttribute(FIELD_PSDECHARTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartLogicBase.getPSDEChartParamId() != null) {
            object = pSDEChartLogicBase.getPSDEChartParamId();
            xmlNode.setAttribute(FIELD_PSDECHARTPARAMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartLogicBase.getPSDEChartParamName() != null) {
            object = pSDEChartLogicBase.getPSDEChartParamName();
            xmlNode.setAttribute(FIELD_PSDECHARTPARAMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartLogicBase.getPSDEId() != null) {
            object = pSDEChartLogicBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartLogicBase.getPSDELogicId() != null) {
            object = pSDEChartLogicBase.getPSDELogicId();
            xmlNode.setAttribute(FIELD_PSDELOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartLogicBase.getPSDELogicName() != null) {
            object = pSDEChartLogicBase.getPSDELogicName();
            xmlNode.setAttribute(FIELD_PSDELOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartLogicBase.getPSDEName() != null) {
            object = pSDEChartLogicBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartLogicBase.getPSDEUIActionId() != null) {
            object = pSDEChartLogicBase.getPSDEUIActionId();
            xmlNode.setAttribute(FIELD_PSDEUIACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartLogicBase.getPSDEUIActionName() != null) {
            object = pSDEChartLogicBase.getPSDEUIActionName();
            xmlNode.setAttribute(FIELD_PSDEUIACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartLogicBase.getPSSysPFPluginId() != null) {
            object = pSDEChartLogicBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartLogicBase.getPSSysPFPluginName() != null) {
            object = pSDEChartLogicBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartLogicBase.getPSSysViewLogicId() != null) {
            object = pSDEChartLogicBase.getPSSysViewLogicId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWLOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartLogicBase.getPSSysViewLogicName() != null) {
            object = pSDEChartLogicBase.getPSSysViewLogicName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWLOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartLogicBase.getPSSysViewPanelId() != null) {
            object = pSDEChartLogicBase.getPSSysViewPanelId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELID, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartLogicBase.getPSSysViewPanelName() != null) {
            object = pSDEChartLogicBase.getPSSysViewPanelName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartLogicBase.getTimer() != null) {
            object = pSDEChartLogicBase.getTimer();
            xmlNode.setAttribute(FIELD_TIMER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEChartLogicBase.getTriggerType() != null) {
            object = pSDEChartLogicBase.getTriggerType();
            xmlNode.setAttribute(FIELD_TRIGGERTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartLogicBase.getUpdateDate() != null) {
            object = pSDEChartLogicBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEChartLogicBase.getUpdateMan() != null) {
            object = pSDEChartLogicBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartLogicBase.getUserCat() != null) {
            object = pSDEChartLogicBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartLogicBase.getUserTag() != null) {
            object = pSDEChartLogicBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartLogicBase.getUserTag2() != null) {
            object = pSDEChartLogicBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartLogicBase.getUserTag3() != null) {
            object = pSDEChartLogicBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartLogicBase.getUserTag4() != null) {
            object = pSDEChartLogicBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartLogicBase.getValidFlag() != null) {
            object = pSDEChartLogicBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEChartLogicBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEChartLogicBase pSDEChartLogicBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEChartLogicBase.isAttrNameDirty() && (bl || pSDEChartLogicBase.getAttrName() != null)) {
            iDataObject.set(FIELD_ATTRNAME, (Object)pSDEChartLogicBase.getAttrName());
        }
        if (pSDEChartLogicBase.isCreateDateDirty() && (bl || pSDEChartLogicBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEChartLogicBase.getCreateDate());
        }
        if (pSDEChartLogicBase.isCreateManDirty() && (bl || pSDEChartLogicBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEChartLogicBase.getCreateMan());
        }
        if (pSDEChartLogicBase.isCustomCodeDirty() && (bl || pSDEChartLogicBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSDEChartLogicBase.getCustomCode());
        }
        if (pSDEChartLogicBase.isDstLogicTypeDirty() && (bl || pSDEChartLogicBase.getDstLogicType() != null)) {
            iDataObject.set(FIELD_DSTLOGICTYPE, (Object)pSDEChartLogicBase.getDstLogicType());
        }
        if (pSDEChartLogicBase.isEventArgDirty() && (bl || pSDEChartLogicBase.getEventArg() != null)) {
            iDataObject.set(FIELD_EVENTARG, (Object)pSDEChartLogicBase.getEventArg());
        }
        if (pSDEChartLogicBase.isEventArg2Dirty() && (bl || pSDEChartLogicBase.getEventArg2() != null)) {
            iDataObject.set(FIELD_EVENTARG2, (Object)pSDEChartLogicBase.getEventArg2());
        }
        if (pSDEChartLogicBase.isEventNamesDirty() && (bl || pSDEChartLogicBase.getEventNames() != null)) {
            iDataObject.set(FIELD_EVENTNAMES, (Object)pSDEChartLogicBase.getEventNames());
        }
        if (pSDEChartLogicBase.isLogicParamDirty() && (bl || pSDEChartLogicBase.getLogicParam() != null)) {
            iDataObject.set(FIELD_LOGICPARAM, (Object)pSDEChartLogicBase.getLogicParam());
        }
        if (pSDEChartLogicBase.isLogicParam2Dirty() && (bl || pSDEChartLogicBase.getLogicParam2() != null)) {
            iDataObject.set(FIELD_LOGICPARAM2, (Object)pSDEChartLogicBase.getLogicParam2());
        }
        if (pSDEChartLogicBase.isMemoDirty() && (bl || pSDEChartLogicBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEChartLogicBase.getMemo());
        }
        if (pSDEChartLogicBase.isOrderValueDirty() && (bl || pSDEChartLogicBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDEChartLogicBase.getOrderValue());
        }
        if (pSDEChartLogicBase.isPSDEChartAxesIdDirty() && (bl || pSDEChartLogicBase.getPSDEChartAxesId() != null)) {
            iDataObject.set(FIELD_PSDECHARTAXESID, (Object)pSDEChartLogicBase.getPSDEChartAxesId());
        }
        if (pSDEChartLogicBase.isPSDEChartAxesNameDirty() && (bl || pSDEChartLogicBase.getPSDEChartAxesName() != null)) {
            iDataObject.set(FIELD_PSDECHARTAXESNAME, (Object)pSDEChartLogicBase.getPSDEChartAxesName());
        }
        if (pSDEChartLogicBase.isPSDEChartIdDirty() && (bl || pSDEChartLogicBase.getPSDEChartId() != null)) {
            iDataObject.set(FIELD_PSDECHARTID, (Object)pSDEChartLogicBase.getPSDEChartId());
        }
        if (pSDEChartLogicBase.isPSDEChartLogicIdDirty() && (bl || pSDEChartLogicBase.getPSDEChartLogicId() != null)) {
            iDataObject.set(FIELD_PSDECHARTLOGICID, (Object)pSDEChartLogicBase.getPSDEChartLogicId());
        }
        if (pSDEChartLogicBase.isPSDEChartLogicNameDirty() && (bl || pSDEChartLogicBase.getPSDEChartLogicName() != null)) {
            iDataObject.set(FIELD_PSDECHARTLOGICNAME, (Object)pSDEChartLogicBase.getPSDEChartLogicName());
        }
        if (pSDEChartLogicBase.isPSDEChartNameDirty() && (bl || pSDEChartLogicBase.getPSDEChartName() != null)) {
            iDataObject.set(FIELD_PSDECHARTNAME, (Object)pSDEChartLogicBase.getPSDEChartName());
        }
        if (pSDEChartLogicBase.isPSDEChartParamIdDirty() && (bl || pSDEChartLogicBase.getPSDEChartParamId() != null)) {
            iDataObject.set(FIELD_PSDECHARTPARAMID, (Object)pSDEChartLogicBase.getPSDEChartParamId());
        }
        if (pSDEChartLogicBase.isPSDEChartParamNameDirty() && (bl || pSDEChartLogicBase.getPSDEChartParamName() != null)) {
            iDataObject.set(FIELD_PSDECHARTPARAMNAME, (Object)pSDEChartLogicBase.getPSDEChartParamName());
        }
        if (pSDEChartLogicBase.isPSDEIdDirty() && (bl || pSDEChartLogicBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEChartLogicBase.getPSDEId());
        }
        if (pSDEChartLogicBase.isPSDELogicIdDirty() && (bl || pSDEChartLogicBase.getPSDELogicId() != null)) {
            iDataObject.set(FIELD_PSDELOGICID, (Object)pSDEChartLogicBase.getPSDELogicId());
        }
        if (pSDEChartLogicBase.isPSDELogicNameDirty() && (bl || pSDEChartLogicBase.getPSDELogicName() != null)) {
            iDataObject.set(FIELD_PSDELOGICNAME, (Object)pSDEChartLogicBase.getPSDELogicName());
        }
        if (pSDEChartLogicBase.isPSDENameDirty() && (bl || pSDEChartLogicBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDEChartLogicBase.getPSDEName());
        }
        if (pSDEChartLogicBase.isPSDEUIActionIdDirty() && (bl || pSDEChartLogicBase.getPSDEUIActionId() != null)) {
            iDataObject.set(FIELD_PSDEUIACTIONID, (Object)pSDEChartLogicBase.getPSDEUIActionId());
        }
        if (pSDEChartLogicBase.isPSDEUIActionNameDirty() && (bl || pSDEChartLogicBase.getPSDEUIActionName() != null)) {
            iDataObject.set(FIELD_PSDEUIACTIONNAME, (Object)pSDEChartLogicBase.getPSDEUIActionName());
        }
        if (pSDEChartLogicBase.isPSSysPFPluginIdDirty() && (bl || pSDEChartLogicBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSDEChartLogicBase.getPSSysPFPluginId());
        }
        if (pSDEChartLogicBase.isPSSysPFPluginNameDirty() && (bl || pSDEChartLogicBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSDEChartLogicBase.getPSSysPFPluginName());
        }
        if (pSDEChartLogicBase.isPSSysViewLogicIdDirty() && (bl || pSDEChartLogicBase.getPSSysViewLogicId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWLOGICID, (Object)pSDEChartLogicBase.getPSSysViewLogicId());
        }
        if (pSDEChartLogicBase.isPSSysViewLogicNameDirty() && (bl || pSDEChartLogicBase.getPSSysViewLogicName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWLOGICNAME, (Object)pSDEChartLogicBase.getPSSysViewLogicName());
        }
        if (pSDEChartLogicBase.isPSSysViewPanelIdDirty() && (bl || pSDEChartLogicBase.getPSSysViewPanelId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELID, (Object)pSDEChartLogicBase.getPSSysViewPanelId());
        }
        if (pSDEChartLogicBase.isPSSysViewPanelNameDirty() && (bl || pSDEChartLogicBase.getPSSysViewPanelName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELNAME, (Object)pSDEChartLogicBase.getPSSysViewPanelName());
        }
        if (pSDEChartLogicBase.isTimerDirty() && (bl || pSDEChartLogicBase.getTimer() != null)) {
            iDataObject.set(FIELD_TIMER, (Object)pSDEChartLogicBase.getTimer());
        }
        if (pSDEChartLogicBase.isTriggerTypeDirty() && (bl || pSDEChartLogicBase.getTriggerType() != null)) {
            iDataObject.set(FIELD_TRIGGERTYPE, (Object)pSDEChartLogicBase.getTriggerType());
        }
        if (pSDEChartLogicBase.isUpdateDateDirty() && (bl || pSDEChartLogicBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEChartLogicBase.getUpdateDate());
        }
        if (pSDEChartLogicBase.isUpdateManDirty() && (bl || pSDEChartLogicBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEChartLogicBase.getUpdateMan());
        }
        if (pSDEChartLogicBase.isUserCatDirty() && (bl || pSDEChartLogicBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEChartLogicBase.getUserCat());
        }
        if (pSDEChartLogicBase.isUserTagDirty() && (bl || pSDEChartLogicBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEChartLogicBase.getUserTag());
        }
        if (pSDEChartLogicBase.isUserTag2Dirty() && (bl || pSDEChartLogicBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEChartLogicBase.getUserTag2());
        }
        if (pSDEChartLogicBase.isUserTag3Dirty() && (bl || pSDEChartLogicBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEChartLogicBase.getUserTag3());
        }
        if (pSDEChartLogicBase.isUserTag4Dirty() && (bl || pSDEChartLogicBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEChartLogicBase.getUserTag4());
        }
        if (pSDEChartLogicBase.isValidFlagDirty() && (bl || pSDEChartLogicBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDEChartLogicBase.getValidFlag());
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
        return PSDEChartLogicBase.remove(this, n);
    }

    private static boolean remove(PSDEChartLogicBase pSDEChartLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEChartLogicBase.resetAttrName();
                return true;
            }
            case 1: {
                pSDEChartLogicBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDEChartLogicBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDEChartLogicBase.resetCustomCode();
                return true;
            }
            case 4: {
                pSDEChartLogicBase.resetDstLogicType();
                return true;
            }
            case 5: {
                pSDEChartLogicBase.resetEventArg();
                return true;
            }
            case 6: {
                pSDEChartLogicBase.resetEventArg2();
                return true;
            }
            case 7: {
                pSDEChartLogicBase.resetEventNames();
                return true;
            }
            case 8: {
                pSDEChartLogicBase.resetLogicParam();
                return true;
            }
            case 9: {
                pSDEChartLogicBase.resetLogicParam2();
                return true;
            }
            case 10: {
                pSDEChartLogicBase.resetMemo();
                return true;
            }
            case 11: {
                pSDEChartLogicBase.resetOrderValue();
                return true;
            }
            case 12: {
                pSDEChartLogicBase.resetPSDEChartAxesId();
                return true;
            }
            case 13: {
                pSDEChartLogicBase.resetPSDEChartAxesName();
                return true;
            }
            case 14: {
                pSDEChartLogicBase.resetPSDEChartId();
                return true;
            }
            case 15: {
                pSDEChartLogicBase.resetPSDEChartLogicId();
                return true;
            }
            case 16: {
                pSDEChartLogicBase.resetPSDEChartLogicName();
                return true;
            }
            case 17: {
                pSDEChartLogicBase.resetPSDEChartName();
                return true;
            }
            case 18: {
                pSDEChartLogicBase.resetPSDEChartParamId();
                return true;
            }
            case 19: {
                pSDEChartLogicBase.resetPSDEChartParamName();
                return true;
            }
            case 20: {
                pSDEChartLogicBase.resetPSDEId();
                return true;
            }
            case 21: {
                pSDEChartLogicBase.resetPSDELogicId();
                return true;
            }
            case 22: {
                pSDEChartLogicBase.resetPSDELogicName();
                return true;
            }
            case 23: {
                pSDEChartLogicBase.resetPSDEName();
                return true;
            }
            case 24: {
                pSDEChartLogicBase.resetPSDEUIActionId();
                return true;
            }
            case 25: {
                pSDEChartLogicBase.resetPSDEUIActionName();
                return true;
            }
            case 26: {
                pSDEChartLogicBase.resetPSSysPFPluginId();
                return true;
            }
            case 27: {
                pSDEChartLogicBase.resetPSSysPFPluginName();
                return true;
            }
            case 28: {
                pSDEChartLogicBase.resetPSSysViewLogicId();
                return true;
            }
            case 29: {
                pSDEChartLogicBase.resetPSSysViewLogicName();
                return true;
            }
            case 30: {
                pSDEChartLogicBase.resetPSSysViewPanelId();
                return true;
            }
            case 31: {
                pSDEChartLogicBase.resetPSSysViewPanelName();
                return true;
            }
            case 32: {
                pSDEChartLogicBase.resetTimer();
                return true;
            }
            case 33: {
                pSDEChartLogicBase.resetTriggerType();
                return true;
            }
            case 34: {
                pSDEChartLogicBase.resetUpdateDate();
                return true;
            }
            case 35: {
                pSDEChartLogicBase.resetUpdateMan();
                return true;
            }
            case 36: {
                pSDEChartLogicBase.resetUserCat();
                return true;
            }
            case 37: {
                pSDEChartLogicBase.resetUserTag();
                return true;
            }
            case 38: {
                pSDEChartLogicBase.resetUserTag2();
                return true;
            }
            case 39: {
                pSDEChartLogicBase.resetUserTag3();
                return true;
            }
            case 40: {
                pSDEChartLogicBase.resetUserTag4();
                return true;
            }
            case 41: {
                pSDEChartLogicBase.resetValidFlag();
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
                pSDataEntityService.autoGet((IEntity)pSDataEntity);
                this.psde = pSDataEntity;
            }
            return this.psde;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEChartAxes getPSDEChartAxes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEChartAxes();
        }
        if (this.getPSDEChartAxesId() == null) {
            return null;
        }
        Integer n = this.objPSDEChartAxesLock;
        synchronized (n) {
            if (this.psdechartaxes != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEChartAxesId(), (Object)this.psdechartaxes.getPSDEChartAxesId()) != 0L) {
                this.psdechartaxes = null;
            }
            if (this.psdechartaxes == null) {
                PSDEChartAxes pSDEChartAxes = new PSDEChartAxes();
                pSDEChartAxes.setPSDEChartAxesId(this.getPSDEChartAxesId());
                PSDEChartAxesService pSDEChartAxesService = (PSDEChartAxesService)ServiceGlobal.getService(PSDEChartAxesService.class, (SessionFactory)this.getSessionFactory());
                pSDEChartAxesService.autoGet((IEntity)pSDEChartAxes);
                this.psdechartaxes = pSDEChartAxes;
            }
            return this.psdechartaxes;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEChartParam getPSDEChartParam() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEChartParam();
        }
        if (this.getPSDEChartParamId() == null) {
            return null;
        }
        Integer n = this.objPSDEChartParamLock;
        synchronized (n) {
            if (this.psdechartparam != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEChartParamId(), (Object)this.psdechartparam.getPSDEChartParamId()) != 0L) {
                this.psdechartparam = null;
            }
            if (this.psdechartparam == null) {
                PSDEChartParam pSDEChartParam = new PSDEChartParam();
                pSDEChartParam.setPSDEChartParamId(this.getPSDEChartParamId());
                PSDEChartParamService pSDEChartParamService = (PSDEChartParamService)ServiceGlobal.getService(PSDEChartParamService.class, (SessionFactory)this.getSessionFactory());
                pSDEChartParamService.autoGet((IEntity)pSDEChartParam);
                this.psdechartparam = pSDEChartParam;
            }
            return this.psdechartparam;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEChart getPSDEChart() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEChart();
        }
        if (this.getPSDEChartId() == null) {
            return null;
        }
        Integer n = this.objPSDEChartLock;
        synchronized (n) {
            if (this.psdechart != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEChartId(), (Object)this.psdechart.getPSDEChartId()) != 0L) {
                this.psdechart = null;
            }
            if (this.psdechart == null) {
                PSDEChart pSDEChart = new PSDEChart();
                pSDEChart.setPSDEChartId(this.getPSDEChartId());
                PSDEChartService pSDEChartService = (PSDEChartService)ServiceGlobal.getService(PSDEChartService.class, (SessionFactory)this.getSessionFactory());
                pSDEChartService.autoGet((IEntity)pSDEChart);
                this.psdechart = pSDEChart;
            }
            return this.psdechart;
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
                pSDELogicService.autoGet((IEntity)pSDELogic);
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
                pSDEUIActionService.autoGet((IEntity)pSDEUIAction);
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
                pSSysPFPluginService.autoGet((IEntity)pSSysPFPlugin);
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
                pSSysViewLogicService.autoGet((IEntity)pSSysViewLogic);
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
                pSSysViewPanelService.autoGet((IEntity)pSSysViewPanel);
                this.pssysviewpanel = pSSysViewPanel;
            }
            return this.pssysviewpanel;
        }
    }

    private PSDEChartLogicBase getProxyEntity() {
        return this.proxyPSDEChartLogicBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEChartLogicBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEChartLogicBase) {
            this.proxyPSDEChartLogicBase = (PSDEChartLogicBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEChartLogicService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
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
        fieldIndexMap.put(FIELD_PSDECHARTAXESID, 12);
        fieldIndexMap.put(FIELD_PSDECHARTAXESNAME, 13);
        fieldIndexMap.put(FIELD_PSDECHARTID, 14);
        fieldIndexMap.put(FIELD_PSDECHARTLOGICID, 15);
        fieldIndexMap.put(FIELD_PSDECHARTLOGICNAME, 16);
        fieldIndexMap.put(FIELD_PSDECHARTNAME, 17);
        fieldIndexMap.put(FIELD_PSDECHARTPARAMID, 18);
        fieldIndexMap.put(FIELD_PSDECHARTPARAMNAME, 19);
        fieldIndexMap.put(FIELD_PSDEID, 20);
        fieldIndexMap.put(FIELD_PSDELOGICID, 21);
        fieldIndexMap.put(FIELD_PSDELOGICNAME, 22);
        fieldIndexMap.put(FIELD_PSDENAME, 23);
        fieldIndexMap.put(FIELD_PSDEUIACTIONID, 24);
        fieldIndexMap.put(FIELD_PSDEUIACTIONNAME, 25);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINID, 26);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINNAME, 27);
        fieldIndexMap.put(FIELD_PSSYSVIEWLOGICID, 28);
        fieldIndexMap.put(FIELD_PSSYSVIEWLOGICNAME, 29);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELID, 30);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELNAME, 31);
        fieldIndexMap.put(FIELD_TIMER, 32);
        fieldIndexMap.put(FIELD_TRIGGERTYPE, 33);
        fieldIndexMap.put(FIELD_UPDATEDATE, 34);
        fieldIndexMap.put(FIELD_UPDATEMAN, 35);
        fieldIndexMap.put(FIELD_USERCAT, 36);
        fieldIndexMap.put(FIELD_USERTAG, 37);
        fieldIndexMap.put(FIELD_USERTAG2, 38);
        fieldIndexMap.put(FIELD_USERTAG3, 39);
        fieldIndexMap.put(FIELD_USERTAG4, 40);
        fieldIndexMap.put(FIELD_VALIDFLAG, 41);
    }
}

