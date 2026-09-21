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
import net.ibizsys.pscore.srv.appdesign.entity.PSAppLocalDE;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppViewLogic;
import net.ibizsys.pscore.srv.appdesign.service.PSAppLocalDEService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewLogicService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewService;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.service.PSSysPFPluginService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewLogic;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewLogicService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppViewLogicBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSAppViewLogicBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CTRLNAME = "CTRLNAME";
    public static final String FIELD_CUSTOMCODE = "CUSTOMCODE";
    public static final String FIELD_DSTLOGICTYPE = "DSTLOGICTYPE";
    public static final String FIELD_EVENTARG = "EVENTARG";
    public static final String FIELD_EVENTARG2 = "EVENTARG2";
    public static final String FIELD_EVENTNAMES = "EVENTNAMES";
    public static final String FIELD_LOGICPARAM = "LOGICPARAM";
    public static final String FIELD_LOGICPARAM2 = "LOGICPARAM2";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSAPPDEID = "PSAPPDEID";
    public static final String FIELD_PSAPPDENAME = "PSAPPDENAME";
    public static final String FIELD_PSAPPVIEWID = "PSAPPVIEWID";
    public static final String FIELD_PSAPPVIEWLOGICID = "PSAPPVIEWLOGICID";
    public static final String FIELD_PSAPPVIEWLOGICNAME = "PSAPPVIEWLOGICNAME";
    public static final String FIELD_PSAPPVIEWLOGICTYPE = "PSAPPVIEWLOGICTYPE";
    public static final String FIELD_PSAPPVIEWNAME = "PSAPPVIEWNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDELOGICID = "PSDELOGICID";
    public static final String FIELD_PSDELOGICNAME = "PSDELOGICNAME";
    public static final String FIELD_PSDEUIACTIONID = "PSDEUIACTIONID";
    public static final String FIELD_PSDEUIACTIONNAME = "PSDEUIACTIONNAME";
    public static final String FIELD_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String FIELD_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String FIELD_PSSYSVIEWLOGICID = "PSSYSVIEWLOGICID";
    public static final String FIELD_PSSYSVIEWLOGICNAME = "PSSYSVIEWLOGICNAME";
    public static final String FIELD_REFPSAPPVIEWLOGICID = "REFPSAPPVIEWLOGICID";
    public static final String FIELD_REFPSAPPVIEWLOGICNAME = "REFPSAPPVIEWLOGICNAME";
    public static final String FIELD_TIMER = "TIMER";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_CTRLNAME = 2;
    private static final int INDEX_CUSTOMCODE = 3;
    private static final int INDEX_DSTLOGICTYPE = 4;
    private static final int INDEX_EVENTARG = 5;
    private static final int INDEX_EVENTARG2 = 6;
    private static final int INDEX_EVENTNAMES = 7;
    private static final int INDEX_LOGICPARAM = 8;
    private static final int INDEX_LOGICPARAM2 = 9;
    private static final int INDEX_MEMO = 10;
    private static final int INDEX_ORDERVALUE = 11;
    private static final int INDEX_PSAPPDEID = 12;
    private static final int INDEX_PSAPPDENAME = 13;
    private static final int INDEX_PSAPPVIEWID = 14;
    private static final int INDEX_PSAPPVIEWLOGICID = 15;
    private static final int INDEX_PSAPPVIEWLOGICNAME = 16;
    private static final int INDEX_PSAPPVIEWLOGICTYPE = 17;
    private static final int INDEX_PSAPPVIEWNAME = 18;
    private static final int INDEX_PSDEID = 19;
    private static final int INDEX_PSDELOGICID = 20;
    private static final int INDEX_PSDELOGICNAME = 21;
    private static final int INDEX_PSDEUIACTIONID = 22;
    private static final int INDEX_PSDEUIACTIONNAME = 23;
    private static final int INDEX_PSSYSPFPLUGINID = 24;
    private static final int INDEX_PSSYSPFPLUGINNAME = 25;
    private static final int INDEX_PSSYSVIEWLOGICID = 26;
    private static final int INDEX_PSSYSVIEWLOGICNAME = 27;
    private static final int INDEX_REFPSAPPVIEWLOGICID = 28;
    private static final int INDEX_REFPSAPPVIEWLOGICNAME = 29;
    private static final int INDEX_TIMER = 30;
    private static final int INDEX_UPDATEDATE = 31;
    private static final int INDEX_UPDATEMAN = 32;
    private static final int INDEX_USERCAT = 33;
    private static final int INDEX_USERTAG = 34;
    private static final int INDEX_USERTAG2 = 35;
    private static final int INDEX_USERTAG3 = 36;
    private static final int INDEX_USERTAG4 = 37;
    private static final int INDEX_VALIDFLAG = 38;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSAppViewLogicBase proxyPSAppViewLogicBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean ctrlnameDirtyFlag = false;
    private boolean customcodeDirtyFlag = false;
    private boolean dstlogictypeDirtyFlag = false;
    private boolean eventargDirtyFlag = false;
    private boolean eventarg2DirtyFlag = false;
    private boolean eventnamesDirtyFlag = false;
    private boolean logicparamDirtyFlag = false;
    private boolean logicparam2DirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psappdeidDirtyFlag = false;
    private boolean psappdenameDirtyFlag = false;
    private boolean psappviewidDirtyFlag = false;
    private boolean psappviewlogicidDirtyFlag = false;
    private boolean psappviewlogicnameDirtyFlag = false;
    private boolean psappviewlogictypeDirtyFlag = false;
    private boolean psappviewnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdelogicidDirtyFlag = false;
    private boolean psdelogicnameDirtyFlag = false;
    private boolean psdeuiactionidDirtyFlag = false;
    private boolean psdeuiactionnameDirtyFlag = false;
    private boolean pssyspfpluginidDirtyFlag = false;
    private boolean pssyspfpluginnameDirtyFlag = false;
    private boolean pssysviewlogicidDirtyFlag = false;
    private boolean pssysviewlogicnameDirtyFlag = false;
    private boolean refpsappviewlogicidDirtyFlag = false;
    private boolean refpsappviewlogicnameDirtyFlag = false;
    private boolean timerDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="ctrlname")
    private String ctrlname;
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
    @Column(name="psappdeid")
    private String psappdeid;
    @Column(name="psappdename")
    private String psappdename;
    @Column(name="psappviewid")
    private String psappviewid;
    @Column(name="psappviewlogicid")
    private String psappviewlogicid;
    @Column(name="psappviewlogicname")
    private String psappviewlogicname;
    @Column(name="psappviewlogictype")
    private String psappviewlogictype;
    @Column(name="psappviewname")
    private String psappviewname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdelogicid")
    private String psdelogicid;
    @Column(name="psdelogicname")
    private String psdelogicname;
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
    @Column(name="refpsappviewlogicid")
    private String refpsappviewlogicid;
    @Column(name="refpsappviewlogicname")
    private String refpsappviewlogicname;
    @Column(name="timer")
    private Integer timer;
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
    private Integer objPSAppDELock = new Integer(1);
    private PSAppLocalDE psappde = null;
    private Integer objRefPSAppViewLogicLock = new Integer(1);
    private PSAppViewLogic refpsappviewlogic = null;
    private Integer objPSAppViewLock = new Integer(1);
    private PSAppView psappview = null;
    private Integer objPSDELogicLock = new Integer(1);
    private PSDELogic psdelogic = null;
    private Integer objPSDEUIActionLock = new Integer(1);
    private PSDEUIAction psdeuiaction = null;
    private Integer objPSSysPFPluginLock = new Integer(1);
    private PSSysPFPlugin pssyspfplugin = null;
    private Integer objPSSysViewLogicLock = new Integer(1);
    private PSSysViewLogic pssysviewlogic = null;

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

    public void setCtrlName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ctrlname = string;
        this.ctrlnameDirtyFlag = true;
    }

    public String getCtrlName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlName();
        }
        return this.ctrlname;
    }

    public boolean isCtrlNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlNameDirty();
        }
        return this.ctrlnameDirtyFlag;
    }

    public void resetCtrlName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlName();
            return;
        }
        this.ctrlnameDirtyFlag = false;
        this.ctrlname = null;
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

    public void setPSAppDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappdeid = string;
        this.psappdeidDirtyFlag = true;
    }

    public String getPSAppDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppDEId();
        }
        return this.psappdeid;
    }

    public boolean isPSAppDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppDEIdDirty();
        }
        return this.psappdeidDirtyFlag;
    }

    public void resetPSAppDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppDEId();
            return;
        }
        this.psappdeidDirtyFlag = false;
        this.psappdeid = null;
    }

    public void setPSAppDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappdename = string;
        this.psappdenameDirtyFlag = true;
    }

    public String getPSAppDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppDEName();
        }
        return this.psappdename;
    }

    public boolean isPSAppDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppDENameDirty();
        }
        return this.psappdenameDirtyFlag;
    }

    public void resetPSAppDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppDEName();
            return;
        }
        this.psappdenameDirtyFlag = false;
        this.psappdename = null;
    }

    public void setPSAppViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappviewid = string;
        this.psappviewidDirtyFlag = true;
    }

    public String getPSAppViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppViewId();
        }
        return this.psappviewid;
    }

    public boolean isPSAppViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppViewIdDirty();
        }
        return this.psappviewidDirtyFlag;
    }

    public void resetPSAppViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppViewId();
            return;
        }
        this.psappviewidDirtyFlag = false;
        this.psappviewid = null;
    }

    public void setPSAppViewLogicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppViewLogicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappviewlogicid = string;
        this.psappviewlogicidDirtyFlag = true;
    }

    public String getPSAppViewLogicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppViewLogicId();
        }
        return this.psappviewlogicid;
    }

    public boolean isPSAppViewLogicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppViewLogicIdDirty();
        }
        return this.psappviewlogicidDirtyFlag;
    }

    public void resetPSAppViewLogicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppViewLogicId();
            return;
        }
        this.psappviewlogicidDirtyFlag = false;
        this.psappviewlogicid = null;
    }

    public void setPSAppViewLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppViewLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappviewlogicname = string;
        this.psappviewlogicnameDirtyFlag = true;
    }

    public String getPSAppViewLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppViewLogicName();
        }
        return this.psappviewlogicname;
    }

    public boolean isPSAppViewLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppViewLogicNameDirty();
        }
        return this.psappviewlogicnameDirtyFlag;
    }

    public void resetPSAppViewLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppViewLogicName();
            return;
        }
        this.psappviewlogicnameDirtyFlag = false;
        this.psappviewlogicname = null;
    }

    public void setPSAppViewLogicType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppViewLogicType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappviewlogictype = string;
        this.psappviewlogictypeDirtyFlag = true;
    }

    public String getPSAppViewLogicType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppViewLogicType();
        }
        return this.psappviewlogictype;
    }

    public boolean isPSAppViewLogicTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppViewLogicTypeDirty();
        }
        return this.psappviewlogictypeDirtyFlag;
    }

    public void resetPSAppViewLogicType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppViewLogicType();
            return;
        }
        this.psappviewlogictypeDirtyFlag = false;
        this.psappviewlogictype = null;
    }

    public void setPSAppViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappviewname = string;
        this.psappviewnameDirtyFlag = true;
    }

    public String getPSAppViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppViewName();
        }
        return this.psappviewname;
    }

    public boolean isPSAppViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppViewNameDirty();
        }
        return this.psappviewnameDirtyFlag;
    }

    public void resetPSAppViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppViewName();
            return;
        }
        this.psappviewnameDirtyFlag = false;
        this.psappviewname = null;
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

    public void setRefPSAppViewLogicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSAppViewLogicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpsappviewlogicid = string;
        this.refpsappviewlogicidDirtyFlag = true;
    }

    public String getRefPSAppViewLogicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSAppViewLogicId();
        }
        return this.refpsappviewlogicid;
    }

    public boolean isRefPSAppViewLogicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSAppViewLogicIdDirty();
        }
        return this.refpsappviewlogicidDirtyFlag;
    }

    public void resetRefPSAppViewLogicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSAppViewLogicId();
            return;
        }
        this.refpsappviewlogicidDirtyFlag = false;
        this.refpsappviewlogicid = null;
    }

    public void setRefPSAppViewLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSAppViewLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpsappviewlogicname = string;
        this.refpsappviewlogicnameDirtyFlag = true;
    }

    public String getRefPSAppViewLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSAppViewLogicName();
        }
        return this.refpsappviewlogicname;
    }

    public boolean isRefPSAppViewLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSAppViewLogicNameDirty();
        }
        return this.refpsappviewlogicnameDirtyFlag;
    }

    public void resetRefPSAppViewLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSAppViewLogicName();
            return;
        }
        this.refpsappviewlogicnameDirtyFlag = false;
        this.refpsappviewlogicname = null;
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
        PSAppViewLogicBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSAppViewLogicBase pSAppViewLogicBase) {
        pSAppViewLogicBase.resetCreateDate();
        pSAppViewLogicBase.resetCreateMan();
        pSAppViewLogicBase.resetCtrlName();
        pSAppViewLogicBase.resetCustomCode();
        pSAppViewLogicBase.resetDstLogicType();
        pSAppViewLogicBase.resetEventArg();
        pSAppViewLogicBase.resetEventArg2();
        pSAppViewLogicBase.resetEventNames();
        pSAppViewLogicBase.resetLogicParam();
        pSAppViewLogicBase.resetLogicParam2();
        pSAppViewLogicBase.resetMemo();
        pSAppViewLogicBase.resetOrderValue();
        pSAppViewLogicBase.resetPSAppDEId();
        pSAppViewLogicBase.resetPSAppDEName();
        pSAppViewLogicBase.resetPSAppViewId();
        pSAppViewLogicBase.resetPSAppViewLogicId();
        pSAppViewLogicBase.resetPSAppViewLogicName();
        pSAppViewLogicBase.resetPSAppViewLogicType();
        pSAppViewLogicBase.resetPSAppViewName();
        pSAppViewLogicBase.resetPSDEId();
        pSAppViewLogicBase.resetPSDELogicId();
        pSAppViewLogicBase.resetPSDELogicName();
        pSAppViewLogicBase.resetPSDEUIActionId();
        pSAppViewLogicBase.resetPSDEUIActionName();
        pSAppViewLogicBase.resetPSSysPFPluginId();
        pSAppViewLogicBase.resetPSSysPFPluginName();
        pSAppViewLogicBase.resetPSSysViewLogicId();
        pSAppViewLogicBase.resetPSSysViewLogicName();
        pSAppViewLogicBase.resetRefPSAppViewLogicId();
        pSAppViewLogicBase.resetRefPSAppViewLogicName();
        pSAppViewLogicBase.resetTimer();
        pSAppViewLogicBase.resetUpdateDate();
        pSAppViewLogicBase.resetUpdateMan();
        pSAppViewLogicBase.resetUserCat();
        pSAppViewLogicBase.resetUserTag();
        pSAppViewLogicBase.resetUserTag2();
        pSAppViewLogicBase.resetUserTag3();
        pSAppViewLogicBase.resetUserTag4();
        pSAppViewLogicBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCtrlNameDirty()) {
            hashMap.put(FIELD_CTRLNAME, this.getCtrlName());
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
        if (!bl || this.isPSAppDEIdDirty()) {
            hashMap.put(FIELD_PSAPPDEID, this.getPSAppDEId());
        }
        if (!bl || this.isPSAppDENameDirty()) {
            hashMap.put(FIELD_PSAPPDENAME, this.getPSAppDEName());
        }
        if (!bl || this.isPSAppViewIdDirty()) {
            hashMap.put(FIELD_PSAPPVIEWID, this.getPSAppViewId());
        }
        if (!bl || this.isPSAppViewLogicIdDirty()) {
            hashMap.put(FIELD_PSAPPVIEWLOGICID, this.getPSAppViewLogicId());
        }
        if (!bl || this.isPSAppViewLogicNameDirty()) {
            hashMap.put(FIELD_PSAPPVIEWLOGICNAME, this.getPSAppViewLogicName());
        }
        if (!bl || this.isPSAppViewLogicTypeDirty()) {
            hashMap.put(FIELD_PSAPPVIEWLOGICTYPE, this.getPSAppViewLogicType());
        }
        if (!bl || this.isPSAppViewNameDirty()) {
            hashMap.put(FIELD_PSAPPVIEWNAME, this.getPSAppViewName());
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
        if (!bl || this.isRefPSAppViewLogicIdDirty()) {
            hashMap.put(FIELD_REFPSAPPVIEWLOGICID, this.getRefPSAppViewLogicId());
        }
        if (!bl || this.isRefPSAppViewLogicNameDirty()) {
            hashMap.put(FIELD_REFPSAPPVIEWLOGICNAME, this.getRefPSAppViewLogicName());
        }
        if (!bl || this.isTimerDirty()) {
            hashMap.put(FIELD_TIMER, this.getTimer());
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
        return PSAppViewLogicBase.get(this, n);
    }

    private static Object get(PSAppViewLogicBase pSAppViewLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppViewLogicBase.getCreateDate();
            }
            case 1: {
                return pSAppViewLogicBase.getCreateMan();
            }
            case 2: {
                return pSAppViewLogicBase.getCtrlName();
            }
            case 3: {
                return pSAppViewLogicBase.getCustomCode();
            }
            case 4: {
                return pSAppViewLogicBase.getDstLogicType();
            }
            case 5: {
                return pSAppViewLogicBase.getEventArg();
            }
            case 6: {
                return pSAppViewLogicBase.getEventArg2();
            }
            case 7: {
                return pSAppViewLogicBase.getEventNames();
            }
            case 8: {
                return pSAppViewLogicBase.getLogicParam();
            }
            case 9: {
                return pSAppViewLogicBase.getLogicParam2();
            }
            case 10: {
                return pSAppViewLogicBase.getMemo();
            }
            case 11: {
                return pSAppViewLogicBase.getOrderValue();
            }
            case 12: {
                return pSAppViewLogicBase.getPSAppDEId();
            }
            case 13: {
                return pSAppViewLogicBase.getPSAppDEName();
            }
            case 14: {
                return pSAppViewLogicBase.getPSAppViewId();
            }
            case 15: {
                return pSAppViewLogicBase.getPSAppViewLogicId();
            }
            case 16: {
                return pSAppViewLogicBase.getPSAppViewLogicName();
            }
            case 17: {
                return pSAppViewLogicBase.getPSAppViewLogicType();
            }
            case 18: {
                return pSAppViewLogicBase.getPSAppViewName();
            }
            case 19: {
                return pSAppViewLogicBase.getPSDEId();
            }
            case 20: {
                return pSAppViewLogicBase.getPSDELogicId();
            }
            case 21: {
                return pSAppViewLogicBase.getPSDELogicName();
            }
            case 22: {
                return pSAppViewLogicBase.getPSDEUIActionId();
            }
            case 23: {
                return pSAppViewLogicBase.getPSDEUIActionName();
            }
            case 24: {
                return pSAppViewLogicBase.getPSSysPFPluginId();
            }
            case 25: {
                return pSAppViewLogicBase.getPSSysPFPluginName();
            }
            case 26: {
                return pSAppViewLogicBase.getPSSysViewLogicId();
            }
            case 27: {
                return pSAppViewLogicBase.getPSSysViewLogicName();
            }
            case 28: {
                return pSAppViewLogicBase.getRefPSAppViewLogicId();
            }
            case 29: {
                return pSAppViewLogicBase.getRefPSAppViewLogicName();
            }
            case 30: {
                return pSAppViewLogicBase.getTimer();
            }
            case 31: {
                return pSAppViewLogicBase.getUpdateDate();
            }
            case 32: {
                return pSAppViewLogicBase.getUpdateMan();
            }
            case 33: {
                return pSAppViewLogicBase.getUserCat();
            }
            case 34: {
                return pSAppViewLogicBase.getUserTag();
            }
            case 35: {
                return pSAppViewLogicBase.getUserTag2();
            }
            case 36: {
                return pSAppViewLogicBase.getUserTag3();
            }
            case 37: {
                return pSAppViewLogicBase.getUserTag4();
            }
            case 38: {
                return pSAppViewLogicBase.getValidFlag();
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
        PSAppViewLogicBase.set(this, n, object);
    }

    private static void set(PSAppViewLogicBase pSAppViewLogicBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSAppViewLogicBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSAppViewLogicBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSAppViewLogicBase.setCtrlName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSAppViewLogicBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSAppViewLogicBase.setDstLogicType(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSAppViewLogicBase.setEventArg(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSAppViewLogicBase.setEventArg2(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSAppViewLogicBase.setEventNames(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSAppViewLogicBase.setLogicParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSAppViewLogicBase.setLogicParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSAppViewLogicBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSAppViewLogicBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSAppViewLogicBase.setPSAppDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSAppViewLogicBase.setPSAppDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSAppViewLogicBase.setPSAppViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSAppViewLogicBase.setPSAppViewLogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSAppViewLogicBase.setPSAppViewLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSAppViewLogicBase.setPSAppViewLogicType(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSAppViewLogicBase.setPSAppViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSAppViewLogicBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSAppViewLogicBase.setPSDELogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSAppViewLogicBase.setPSDELogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSAppViewLogicBase.setPSDEUIActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSAppViewLogicBase.setPSDEUIActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSAppViewLogicBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSAppViewLogicBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSAppViewLogicBase.setPSSysViewLogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSAppViewLogicBase.setPSSysViewLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSAppViewLogicBase.setRefPSAppViewLogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSAppViewLogicBase.setRefPSAppViewLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSAppViewLogicBase.setTimer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 31: {
                pSAppViewLogicBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 32: {
                pSAppViewLogicBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSAppViewLogicBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSAppViewLogicBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSAppViewLogicBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSAppViewLogicBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSAppViewLogicBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSAppViewLogicBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSAppViewLogicBase.isNull(this, n);
    }

    private static boolean isNull(PSAppViewLogicBase pSAppViewLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppViewLogicBase.getCreateDate() == null;
            }
            case 1: {
                return pSAppViewLogicBase.getCreateMan() == null;
            }
            case 2: {
                return pSAppViewLogicBase.getCtrlName() == null;
            }
            case 3: {
                return pSAppViewLogicBase.getCustomCode() == null;
            }
            case 4: {
                return pSAppViewLogicBase.getDstLogicType() == null;
            }
            case 5: {
                return pSAppViewLogicBase.getEventArg() == null;
            }
            case 6: {
                return pSAppViewLogicBase.getEventArg2() == null;
            }
            case 7: {
                return pSAppViewLogicBase.getEventNames() == null;
            }
            case 8: {
                return pSAppViewLogicBase.getLogicParam() == null;
            }
            case 9: {
                return pSAppViewLogicBase.getLogicParam2() == null;
            }
            case 10: {
                return pSAppViewLogicBase.getMemo() == null;
            }
            case 11: {
                return pSAppViewLogicBase.getOrderValue() == null;
            }
            case 12: {
                return pSAppViewLogicBase.getPSAppDEId() == null;
            }
            case 13: {
                return pSAppViewLogicBase.getPSAppDEName() == null;
            }
            case 14: {
                return pSAppViewLogicBase.getPSAppViewId() == null;
            }
            case 15: {
                return pSAppViewLogicBase.getPSAppViewLogicId() == null;
            }
            case 16: {
                return pSAppViewLogicBase.getPSAppViewLogicName() == null;
            }
            case 17: {
                return pSAppViewLogicBase.getPSAppViewLogicType() == null;
            }
            case 18: {
                return pSAppViewLogicBase.getPSAppViewName() == null;
            }
            case 19: {
                return pSAppViewLogicBase.getPSDEId() == null;
            }
            case 20: {
                return pSAppViewLogicBase.getPSDELogicId() == null;
            }
            case 21: {
                return pSAppViewLogicBase.getPSDELogicName() == null;
            }
            case 22: {
                return pSAppViewLogicBase.getPSDEUIActionId() == null;
            }
            case 23: {
                return pSAppViewLogicBase.getPSDEUIActionName() == null;
            }
            case 24: {
                return pSAppViewLogicBase.getPSSysPFPluginId() == null;
            }
            case 25: {
                return pSAppViewLogicBase.getPSSysPFPluginName() == null;
            }
            case 26: {
                return pSAppViewLogicBase.getPSSysViewLogicId() == null;
            }
            case 27: {
                return pSAppViewLogicBase.getPSSysViewLogicName() == null;
            }
            case 28: {
                return pSAppViewLogicBase.getRefPSAppViewLogicId() == null;
            }
            case 29: {
                return pSAppViewLogicBase.getRefPSAppViewLogicName() == null;
            }
            case 30: {
                return pSAppViewLogicBase.getTimer() == null;
            }
            case 31: {
                return pSAppViewLogicBase.getUpdateDate() == null;
            }
            case 32: {
                return pSAppViewLogicBase.getUpdateMan() == null;
            }
            case 33: {
                return pSAppViewLogicBase.getUserCat() == null;
            }
            case 34: {
                return pSAppViewLogicBase.getUserTag() == null;
            }
            case 35: {
                return pSAppViewLogicBase.getUserTag2() == null;
            }
            case 36: {
                return pSAppViewLogicBase.getUserTag3() == null;
            }
            case 37: {
                return pSAppViewLogicBase.getUserTag4() == null;
            }
            case 38: {
                return pSAppViewLogicBase.getValidFlag() == null;
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
        return PSAppViewLogicBase.contains(this, n);
    }

    private static boolean contains(PSAppViewLogicBase pSAppViewLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppViewLogicBase.isCreateDateDirty();
            }
            case 1: {
                return pSAppViewLogicBase.isCreateManDirty();
            }
            case 2: {
                return pSAppViewLogicBase.isCtrlNameDirty();
            }
            case 3: {
                return pSAppViewLogicBase.isCustomCodeDirty();
            }
            case 4: {
                return pSAppViewLogicBase.isDstLogicTypeDirty();
            }
            case 5: {
                return pSAppViewLogicBase.isEventArgDirty();
            }
            case 6: {
                return pSAppViewLogicBase.isEventArg2Dirty();
            }
            case 7: {
                return pSAppViewLogicBase.isEventNamesDirty();
            }
            case 8: {
                return pSAppViewLogicBase.isLogicParamDirty();
            }
            case 9: {
                return pSAppViewLogicBase.isLogicParam2Dirty();
            }
            case 10: {
                return pSAppViewLogicBase.isMemoDirty();
            }
            case 11: {
                return pSAppViewLogicBase.isOrderValueDirty();
            }
            case 12: {
                return pSAppViewLogicBase.isPSAppDEIdDirty();
            }
            case 13: {
                return pSAppViewLogicBase.isPSAppDENameDirty();
            }
            case 14: {
                return pSAppViewLogicBase.isPSAppViewIdDirty();
            }
            case 15: {
                return pSAppViewLogicBase.isPSAppViewLogicIdDirty();
            }
            case 16: {
                return pSAppViewLogicBase.isPSAppViewLogicNameDirty();
            }
            case 17: {
                return pSAppViewLogicBase.isPSAppViewLogicTypeDirty();
            }
            case 18: {
                return pSAppViewLogicBase.isPSAppViewNameDirty();
            }
            case 19: {
                return pSAppViewLogicBase.isPSDEIdDirty();
            }
            case 20: {
                return pSAppViewLogicBase.isPSDELogicIdDirty();
            }
            case 21: {
                return pSAppViewLogicBase.isPSDELogicNameDirty();
            }
            case 22: {
                return pSAppViewLogicBase.isPSDEUIActionIdDirty();
            }
            case 23: {
                return pSAppViewLogicBase.isPSDEUIActionNameDirty();
            }
            case 24: {
                return pSAppViewLogicBase.isPSSysPFPluginIdDirty();
            }
            case 25: {
                return pSAppViewLogicBase.isPSSysPFPluginNameDirty();
            }
            case 26: {
                return pSAppViewLogicBase.isPSSysViewLogicIdDirty();
            }
            case 27: {
                return pSAppViewLogicBase.isPSSysViewLogicNameDirty();
            }
            case 28: {
                return pSAppViewLogicBase.isRefPSAppViewLogicIdDirty();
            }
            case 29: {
                return pSAppViewLogicBase.isRefPSAppViewLogicNameDirty();
            }
            case 30: {
                return pSAppViewLogicBase.isTimerDirty();
            }
            case 31: {
                return pSAppViewLogicBase.isUpdateDateDirty();
            }
            case 32: {
                return pSAppViewLogicBase.isUpdateManDirty();
            }
            case 33: {
                return pSAppViewLogicBase.isUserCatDirty();
            }
            case 34: {
                return pSAppViewLogicBase.isUserTagDirty();
            }
            case 35: {
                return pSAppViewLogicBase.isUserTag2Dirty();
            }
            case 36: {
                return pSAppViewLogicBase.isUserTag3Dirty();
            }
            case 37: {
                return pSAppViewLogicBase.isUserTag4Dirty();
            }
            case 38: {
                return pSAppViewLogicBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSAppViewLogicBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSAppViewLogicBase pSAppViewLogicBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSAppViewLogicBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSAppViewLogicBase.getJSONValue((Object)pSAppViewLogicBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSAppViewLogicBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSAppViewLogicBase.getJSONValue((Object)pSAppViewLogicBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSAppViewLogicBase.getCtrlName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlname", (Object)PSAppViewLogicBase.getJSONValue((Object)pSAppViewLogicBase.getCtrlName()), (boolean)false);
        }
        if (bl || pSAppViewLogicBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSAppViewLogicBase.getJSONValue((Object)pSAppViewLogicBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSAppViewLogicBase.getDstLogicType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstlogictype", (Object)PSAppViewLogicBase.getJSONValue((Object)pSAppViewLogicBase.getDstLogicType()), (boolean)false);
        }
        if (bl || pSAppViewLogicBase.getEventArg() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eventarg", (Object)PSAppViewLogicBase.getJSONValue((Object)pSAppViewLogicBase.getEventArg()), (boolean)false);
        }
        if (bl || pSAppViewLogicBase.getEventArg2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eventarg2", (Object)PSAppViewLogicBase.getJSONValue((Object)pSAppViewLogicBase.getEventArg2()), (boolean)false);
        }
        if (bl || pSAppViewLogicBase.getEventNames() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eventnames", (Object)PSAppViewLogicBase.getJSONValue((Object)pSAppViewLogicBase.getEventNames()), (boolean)false);
        }
        if (bl || pSAppViewLogicBase.getLogicParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicparam", (Object)PSAppViewLogicBase.getJSONValue((Object)pSAppViewLogicBase.getLogicParam()), (boolean)false);
        }
        if (bl || pSAppViewLogicBase.getLogicParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicparam2", (Object)PSAppViewLogicBase.getJSONValue((Object)pSAppViewLogicBase.getLogicParam2()), (boolean)false);
        }
        if (bl || pSAppViewLogicBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSAppViewLogicBase.getJSONValue((Object)pSAppViewLogicBase.getMemo()), (boolean)false);
        }
        if (bl || pSAppViewLogicBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSAppViewLogicBase.getJSONValue((Object)pSAppViewLogicBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSAppViewLogicBase.getPSAppDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappdeid", (Object)PSAppViewLogicBase.getJSONValue((Object)pSAppViewLogicBase.getPSAppDEId()), (boolean)false);
        }
        if (bl || pSAppViewLogicBase.getPSAppDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappdename", (Object)PSAppViewLogicBase.getJSONValue((Object)pSAppViewLogicBase.getPSAppDEName()), (boolean)false);
        }
        if (bl || pSAppViewLogicBase.getPSAppViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappviewid", (Object)PSAppViewLogicBase.getJSONValue((Object)pSAppViewLogicBase.getPSAppViewId()), (boolean)false);
        }
        if (bl || pSAppViewLogicBase.getPSAppViewLogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappviewlogicid", (Object)PSAppViewLogicBase.getJSONValue((Object)pSAppViewLogicBase.getPSAppViewLogicId()), (boolean)false);
        }
        if (bl || pSAppViewLogicBase.getPSAppViewLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappviewlogicname", (Object)PSAppViewLogicBase.getJSONValue((Object)pSAppViewLogicBase.getPSAppViewLogicName()), (boolean)false);
        }
        if (bl || pSAppViewLogicBase.getPSAppViewLogicType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappviewlogictype", (Object)PSAppViewLogicBase.getJSONValue((Object)pSAppViewLogicBase.getPSAppViewLogicType()), (boolean)false);
        }
        if (bl || pSAppViewLogicBase.getPSAppViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappviewname", (Object)PSAppViewLogicBase.getJSONValue((Object)pSAppViewLogicBase.getPSAppViewName()), (boolean)false);
        }
        if (bl || pSAppViewLogicBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSAppViewLogicBase.getJSONValue((Object)pSAppViewLogicBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSAppViewLogicBase.getPSDELogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicid", (Object)PSAppViewLogicBase.getJSONValue((Object)pSAppViewLogicBase.getPSDELogicId()), (boolean)false);
        }
        if (bl || pSAppViewLogicBase.getPSDELogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicname", (Object)PSAppViewLogicBase.getJSONValue((Object)pSAppViewLogicBase.getPSDELogicName()), (boolean)false);
        }
        if (bl || pSAppViewLogicBase.getPSDEUIActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuiactionid", (Object)PSAppViewLogicBase.getJSONValue((Object)pSAppViewLogicBase.getPSDEUIActionId()), (boolean)false);
        }
        if (bl || pSAppViewLogicBase.getPSDEUIActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuiactionname", (Object)PSAppViewLogicBase.getJSONValue((Object)pSAppViewLogicBase.getPSDEUIActionName()), (boolean)false);
        }
        if (bl || pSAppViewLogicBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSAppViewLogicBase.getJSONValue((Object)pSAppViewLogicBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSAppViewLogicBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSAppViewLogicBase.getJSONValue((Object)pSAppViewLogicBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSAppViewLogicBase.getPSSysViewLogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewlogicid", (Object)PSAppViewLogicBase.getJSONValue((Object)pSAppViewLogicBase.getPSSysViewLogicId()), (boolean)false);
        }
        if (bl || pSAppViewLogicBase.getPSSysViewLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewlogicname", (Object)PSAppViewLogicBase.getJSONValue((Object)pSAppViewLogicBase.getPSSysViewLogicName()), (boolean)false);
        }
        if (bl || pSAppViewLogicBase.getRefPSAppViewLogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsappviewlogicid", (Object)PSAppViewLogicBase.getJSONValue((Object)pSAppViewLogicBase.getRefPSAppViewLogicId()), (boolean)false);
        }
        if (bl || pSAppViewLogicBase.getRefPSAppViewLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsappviewlogicname", (Object)PSAppViewLogicBase.getJSONValue((Object)pSAppViewLogicBase.getRefPSAppViewLogicName()), (boolean)false);
        }
        if (bl || pSAppViewLogicBase.getTimer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"timer", (Object)PSAppViewLogicBase.getJSONValue((Object)pSAppViewLogicBase.getTimer()), (boolean)false);
        }
        if (bl || pSAppViewLogicBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSAppViewLogicBase.getJSONValue((Object)pSAppViewLogicBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSAppViewLogicBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSAppViewLogicBase.getJSONValue((Object)pSAppViewLogicBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSAppViewLogicBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSAppViewLogicBase.getJSONValue((Object)pSAppViewLogicBase.getUserCat()), (boolean)false);
        }
        if (bl || pSAppViewLogicBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSAppViewLogicBase.getJSONValue((Object)pSAppViewLogicBase.getUserTag()), (boolean)false);
        }
        if (bl || pSAppViewLogicBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSAppViewLogicBase.getJSONValue((Object)pSAppViewLogicBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSAppViewLogicBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSAppViewLogicBase.getJSONValue((Object)pSAppViewLogicBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSAppViewLogicBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSAppViewLogicBase.getJSONValue((Object)pSAppViewLogicBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSAppViewLogicBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSAppViewLogicBase.getJSONValue((Object)pSAppViewLogicBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSAppViewLogicBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSAppViewLogicBase pSAppViewLogicBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSAppViewLogicBase.getCreateDate() != null) {
            object = pSAppViewLogicBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppViewLogicBase.getCreateMan() != null) {
            object = pSAppViewLogicBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewLogicBase.getCtrlName() != null) {
            object = pSAppViewLogicBase.getCtrlName();
            xmlNode.setAttribute(FIELD_CTRLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewLogicBase.getCustomCode() != null) {
            object = pSAppViewLogicBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewLogicBase.getDstLogicType() != null) {
            object = pSAppViewLogicBase.getDstLogicType();
            xmlNode.setAttribute(FIELD_DSTLOGICTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewLogicBase.getEventArg() != null) {
            object = pSAppViewLogicBase.getEventArg();
            xmlNode.setAttribute(FIELD_EVENTARG, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewLogicBase.getEventArg2() != null) {
            object = pSAppViewLogicBase.getEventArg2();
            xmlNode.setAttribute(FIELD_EVENTARG2, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewLogicBase.getEventNames() != null) {
            object = pSAppViewLogicBase.getEventNames();
            xmlNode.setAttribute(FIELD_EVENTNAMES, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewLogicBase.getLogicParam() != null) {
            object = pSAppViewLogicBase.getLogicParam();
            xmlNode.setAttribute(FIELD_LOGICPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewLogicBase.getLogicParam2() != null) {
            object = pSAppViewLogicBase.getLogicParam2();
            xmlNode.setAttribute(FIELD_LOGICPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewLogicBase.getMemo() != null) {
            object = pSAppViewLogicBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewLogicBase.getOrderValue() != null) {
            object = pSAppViewLogicBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppViewLogicBase.getPSAppDEId() != null) {
            object = pSAppViewLogicBase.getPSAppDEId();
            xmlNode.setAttribute(FIELD_PSAPPDEID, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewLogicBase.getPSAppDEName() != null) {
            object = pSAppViewLogicBase.getPSAppDEName();
            xmlNode.setAttribute(FIELD_PSAPPDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewLogicBase.getPSAppViewId() != null) {
            object = pSAppViewLogicBase.getPSAppViewId();
            xmlNode.setAttribute(FIELD_PSAPPVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewLogicBase.getPSAppViewLogicId() != null) {
            object = pSAppViewLogicBase.getPSAppViewLogicId();
            xmlNode.setAttribute(FIELD_PSAPPVIEWLOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewLogicBase.getPSAppViewLogicName() != null) {
            object = pSAppViewLogicBase.getPSAppViewLogicName();
            xmlNode.setAttribute(FIELD_PSAPPVIEWLOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewLogicBase.getPSAppViewLogicType() != null) {
            object = pSAppViewLogicBase.getPSAppViewLogicType();
            xmlNode.setAttribute(FIELD_PSAPPVIEWLOGICTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewLogicBase.getPSAppViewName() != null) {
            object = pSAppViewLogicBase.getPSAppViewName();
            xmlNode.setAttribute(FIELD_PSAPPVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewLogicBase.getPSDEId() != null) {
            object = pSAppViewLogicBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewLogicBase.getPSDELogicId() != null) {
            object = pSAppViewLogicBase.getPSDELogicId();
            xmlNode.setAttribute(FIELD_PSDELOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewLogicBase.getPSDELogicName() != null) {
            object = pSAppViewLogicBase.getPSDELogicName();
            xmlNode.setAttribute(FIELD_PSDELOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewLogicBase.getPSDEUIActionId() != null) {
            object = pSAppViewLogicBase.getPSDEUIActionId();
            xmlNode.setAttribute(FIELD_PSDEUIACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewLogicBase.getPSDEUIActionName() != null) {
            object = pSAppViewLogicBase.getPSDEUIActionName();
            xmlNode.setAttribute(FIELD_PSDEUIACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewLogicBase.getPSSysPFPluginId() != null) {
            object = pSAppViewLogicBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewLogicBase.getPSSysPFPluginName() != null) {
            object = pSAppViewLogicBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewLogicBase.getPSSysViewLogicId() != null) {
            object = pSAppViewLogicBase.getPSSysViewLogicId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWLOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewLogicBase.getPSSysViewLogicName() != null) {
            object = pSAppViewLogicBase.getPSSysViewLogicName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWLOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewLogicBase.getRefPSAppViewLogicId() != null) {
            object = pSAppViewLogicBase.getRefPSAppViewLogicId();
            xmlNode.setAttribute(FIELD_REFPSAPPVIEWLOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewLogicBase.getRefPSAppViewLogicName() != null) {
            object = pSAppViewLogicBase.getRefPSAppViewLogicName();
            xmlNode.setAttribute(FIELD_REFPSAPPVIEWLOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewLogicBase.getTimer() != null) {
            object = pSAppViewLogicBase.getTimer();
            xmlNode.setAttribute(FIELD_TIMER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppViewLogicBase.getUpdateDate() != null) {
            object = pSAppViewLogicBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppViewLogicBase.getUpdateMan() != null) {
            object = pSAppViewLogicBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewLogicBase.getUserCat() != null) {
            object = pSAppViewLogicBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewLogicBase.getUserTag() != null) {
            object = pSAppViewLogicBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewLogicBase.getUserTag2() != null) {
            object = pSAppViewLogicBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewLogicBase.getUserTag3() != null) {
            object = pSAppViewLogicBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewLogicBase.getUserTag4() != null) {
            object = pSAppViewLogicBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewLogicBase.getValidFlag() != null) {
            object = pSAppViewLogicBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSAppViewLogicBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSAppViewLogicBase pSAppViewLogicBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSAppViewLogicBase.isCreateDateDirty() && (bl || pSAppViewLogicBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSAppViewLogicBase.getCreateDate());
        }
        if (pSAppViewLogicBase.isCreateManDirty() && (bl || pSAppViewLogicBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSAppViewLogicBase.getCreateMan());
        }
        if (pSAppViewLogicBase.isCtrlNameDirty() && (bl || pSAppViewLogicBase.getCtrlName() != null)) {
            iDataObject.set(FIELD_CTRLNAME, (Object)pSAppViewLogicBase.getCtrlName());
        }
        if (pSAppViewLogicBase.isCustomCodeDirty() && (bl || pSAppViewLogicBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSAppViewLogicBase.getCustomCode());
        }
        if (pSAppViewLogicBase.isDstLogicTypeDirty() && (bl || pSAppViewLogicBase.getDstLogicType() != null)) {
            iDataObject.set(FIELD_DSTLOGICTYPE, (Object)pSAppViewLogicBase.getDstLogicType());
        }
        if (pSAppViewLogicBase.isEventArgDirty() && (bl || pSAppViewLogicBase.getEventArg() != null)) {
            iDataObject.set(FIELD_EVENTARG, (Object)pSAppViewLogicBase.getEventArg());
        }
        if (pSAppViewLogicBase.isEventArg2Dirty() && (bl || pSAppViewLogicBase.getEventArg2() != null)) {
            iDataObject.set(FIELD_EVENTARG2, (Object)pSAppViewLogicBase.getEventArg2());
        }
        if (pSAppViewLogicBase.isEventNamesDirty() && (bl || pSAppViewLogicBase.getEventNames() != null)) {
            iDataObject.set(FIELD_EVENTNAMES, (Object)pSAppViewLogicBase.getEventNames());
        }
        if (pSAppViewLogicBase.isLogicParamDirty() && (bl || pSAppViewLogicBase.getLogicParam() != null)) {
            iDataObject.set(FIELD_LOGICPARAM, (Object)pSAppViewLogicBase.getLogicParam());
        }
        if (pSAppViewLogicBase.isLogicParam2Dirty() && (bl || pSAppViewLogicBase.getLogicParam2() != null)) {
            iDataObject.set(FIELD_LOGICPARAM2, (Object)pSAppViewLogicBase.getLogicParam2());
        }
        if (pSAppViewLogicBase.isMemoDirty() && (bl || pSAppViewLogicBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSAppViewLogicBase.getMemo());
        }
        if (pSAppViewLogicBase.isOrderValueDirty() && (bl || pSAppViewLogicBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSAppViewLogicBase.getOrderValue());
        }
        if (pSAppViewLogicBase.isPSAppDEIdDirty() && (bl || pSAppViewLogicBase.getPSAppDEId() != null)) {
            iDataObject.set(FIELD_PSAPPDEID, (Object)pSAppViewLogicBase.getPSAppDEId());
        }
        if (pSAppViewLogicBase.isPSAppDENameDirty() && (bl || pSAppViewLogicBase.getPSAppDEName() != null)) {
            iDataObject.set(FIELD_PSAPPDENAME, (Object)pSAppViewLogicBase.getPSAppDEName());
        }
        if (pSAppViewLogicBase.isPSAppViewIdDirty() && (bl || pSAppViewLogicBase.getPSAppViewId() != null)) {
            iDataObject.set(FIELD_PSAPPVIEWID, (Object)pSAppViewLogicBase.getPSAppViewId());
        }
        if (pSAppViewLogicBase.isPSAppViewLogicIdDirty() && (bl || pSAppViewLogicBase.getPSAppViewLogicId() != null)) {
            iDataObject.set(FIELD_PSAPPVIEWLOGICID, (Object)pSAppViewLogicBase.getPSAppViewLogicId());
        }
        if (pSAppViewLogicBase.isPSAppViewLogicNameDirty() && (bl || pSAppViewLogicBase.getPSAppViewLogicName() != null)) {
            iDataObject.set(FIELD_PSAPPVIEWLOGICNAME, (Object)pSAppViewLogicBase.getPSAppViewLogicName());
        }
        if (pSAppViewLogicBase.isPSAppViewLogicTypeDirty() && (bl || pSAppViewLogicBase.getPSAppViewLogicType() != null)) {
            iDataObject.set(FIELD_PSAPPVIEWLOGICTYPE, (Object)pSAppViewLogicBase.getPSAppViewLogicType());
        }
        if (pSAppViewLogicBase.isPSAppViewNameDirty() && (bl || pSAppViewLogicBase.getPSAppViewName() != null)) {
            iDataObject.set(FIELD_PSAPPVIEWNAME, (Object)pSAppViewLogicBase.getPSAppViewName());
        }
        if (pSAppViewLogicBase.isPSDEIdDirty() && (bl || pSAppViewLogicBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSAppViewLogicBase.getPSDEId());
        }
        if (pSAppViewLogicBase.isPSDELogicIdDirty() && (bl || pSAppViewLogicBase.getPSDELogicId() != null)) {
            iDataObject.set(FIELD_PSDELOGICID, (Object)pSAppViewLogicBase.getPSDELogicId());
        }
        if (pSAppViewLogicBase.isPSDELogicNameDirty() && (bl || pSAppViewLogicBase.getPSDELogicName() != null)) {
            iDataObject.set(FIELD_PSDELOGICNAME, (Object)pSAppViewLogicBase.getPSDELogicName());
        }
        if (pSAppViewLogicBase.isPSDEUIActionIdDirty() && (bl || pSAppViewLogicBase.getPSDEUIActionId() != null)) {
            iDataObject.set(FIELD_PSDEUIACTIONID, (Object)pSAppViewLogicBase.getPSDEUIActionId());
        }
        if (pSAppViewLogicBase.isPSDEUIActionNameDirty() && (bl || pSAppViewLogicBase.getPSDEUIActionName() != null)) {
            iDataObject.set(FIELD_PSDEUIACTIONNAME, (Object)pSAppViewLogicBase.getPSDEUIActionName());
        }
        if (pSAppViewLogicBase.isPSSysPFPluginIdDirty() && (bl || pSAppViewLogicBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSAppViewLogicBase.getPSSysPFPluginId());
        }
        if (pSAppViewLogicBase.isPSSysPFPluginNameDirty() && (bl || pSAppViewLogicBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSAppViewLogicBase.getPSSysPFPluginName());
        }
        if (pSAppViewLogicBase.isPSSysViewLogicIdDirty() && (bl || pSAppViewLogicBase.getPSSysViewLogicId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWLOGICID, (Object)pSAppViewLogicBase.getPSSysViewLogicId());
        }
        if (pSAppViewLogicBase.isPSSysViewLogicNameDirty() && (bl || pSAppViewLogicBase.getPSSysViewLogicName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWLOGICNAME, (Object)pSAppViewLogicBase.getPSSysViewLogicName());
        }
        if (pSAppViewLogicBase.isRefPSAppViewLogicIdDirty() && (bl || pSAppViewLogicBase.getRefPSAppViewLogicId() != null)) {
            iDataObject.set(FIELD_REFPSAPPVIEWLOGICID, (Object)pSAppViewLogicBase.getRefPSAppViewLogicId());
        }
        if (pSAppViewLogicBase.isRefPSAppViewLogicNameDirty() && (bl || pSAppViewLogicBase.getRefPSAppViewLogicName() != null)) {
            iDataObject.set(FIELD_REFPSAPPVIEWLOGICNAME, (Object)pSAppViewLogicBase.getRefPSAppViewLogicName());
        }
        if (pSAppViewLogicBase.isTimerDirty() && (bl || pSAppViewLogicBase.getTimer() != null)) {
            iDataObject.set(FIELD_TIMER, (Object)pSAppViewLogicBase.getTimer());
        }
        if (pSAppViewLogicBase.isUpdateDateDirty() && (bl || pSAppViewLogicBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSAppViewLogicBase.getUpdateDate());
        }
        if (pSAppViewLogicBase.isUpdateManDirty() && (bl || pSAppViewLogicBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSAppViewLogicBase.getUpdateMan());
        }
        if (pSAppViewLogicBase.isUserCatDirty() && (bl || pSAppViewLogicBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSAppViewLogicBase.getUserCat());
        }
        if (pSAppViewLogicBase.isUserTagDirty() && (bl || pSAppViewLogicBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSAppViewLogicBase.getUserTag());
        }
        if (pSAppViewLogicBase.isUserTag2Dirty() && (bl || pSAppViewLogicBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSAppViewLogicBase.getUserTag2());
        }
        if (pSAppViewLogicBase.isUserTag3Dirty() && (bl || pSAppViewLogicBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSAppViewLogicBase.getUserTag3());
        }
        if (pSAppViewLogicBase.isUserTag4Dirty() && (bl || pSAppViewLogicBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSAppViewLogicBase.getUserTag4());
        }
        if (pSAppViewLogicBase.isValidFlagDirty() && (bl || pSAppViewLogicBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSAppViewLogicBase.getValidFlag());
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
        return PSAppViewLogicBase.remove(this, n);
    }

    private static boolean remove(PSAppViewLogicBase pSAppViewLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSAppViewLogicBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSAppViewLogicBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSAppViewLogicBase.resetCtrlName();
                return true;
            }
            case 3: {
                pSAppViewLogicBase.resetCustomCode();
                return true;
            }
            case 4: {
                pSAppViewLogicBase.resetDstLogicType();
                return true;
            }
            case 5: {
                pSAppViewLogicBase.resetEventArg();
                return true;
            }
            case 6: {
                pSAppViewLogicBase.resetEventArg2();
                return true;
            }
            case 7: {
                pSAppViewLogicBase.resetEventNames();
                return true;
            }
            case 8: {
                pSAppViewLogicBase.resetLogicParam();
                return true;
            }
            case 9: {
                pSAppViewLogicBase.resetLogicParam2();
                return true;
            }
            case 10: {
                pSAppViewLogicBase.resetMemo();
                return true;
            }
            case 11: {
                pSAppViewLogicBase.resetOrderValue();
                return true;
            }
            case 12: {
                pSAppViewLogicBase.resetPSAppDEId();
                return true;
            }
            case 13: {
                pSAppViewLogicBase.resetPSAppDEName();
                return true;
            }
            case 14: {
                pSAppViewLogicBase.resetPSAppViewId();
                return true;
            }
            case 15: {
                pSAppViewLogicBase.resetPSAppViewLogicId();
                return true;
            }
            case 16: {
                pSAppViewLogicBase.resetPSAppViewLogicName();
                return true;
            }
            case 17: {
                pSAppViewLogicBase.resetPSAppViewLogicType();
                return true;
            }
            case 18: {
                pSAppViewLogicBase.resetPSAppViewName();
                return true;
            }
            case 19: {
                pSAppViewLogicBase.resetPSDEId();
                return true;
            }
            case 20: {
                pSAppViewLogicBase.resetPSDELogicId();
                return true;
            }
            case 21: {
                pSAppViewLogicBase.resetPSDELogicName();
                return true;
            }
            case 22: {
                pSAppViewLogicBase.resetPSDEUIActionId();
                return true;
            }
            case 23: {
                pSAppViewLogicBase.resetPSDEUIActionName();
                return true;
            }
            case 24: {
                pSAppViewLogicBase.resetPSSysPFPluginId();
                return true;
            }
            case 25: {
                pSAppViewLogicBase.resetPSSysPFPluginName();
                return true;
            }
            case 26: {
                pSAppViewLogicBase.resetPSSysViewLogicId();
                return true;
            }
            case 27: {
                pSAppViewLogicBase.resetPSSysViewLogicName();
                return true;
            }
            case 28: {
                pSAppViewLogicBase.resetRefPSAppViewLogicId();
                return true;
            }
            case 29: {
                pSAppViewLogicBase.resetRefPSAppViewLogicName();
                return true;
            }
            case 30: {
                pSAppViewLogicBase.resetTimer();
                return true;
            }
            case 31: {
                pSAppViewLogicBase.resetUpdateDate();
                return true;
            }
            case 32: {
                pSAppViewLogicBase.resetUpdateMan();
                return true;
            }
            case 33: {
                pSAppViewLogicBase.resetUserCat();
                return true;
            }
            case 34: {
                pSAppViewLogicBase.resetUserTag();
                return true;
            }
            case 35: {
                pSAppViewLogicBase.resetUserTag2();
                return true;
            }
            case 36: {
                pSAppViewLogicBase.resetUserTag3();
                return true;
            }
            case 37: {
                pSAppViewLogicBase.resetUserTag4();
                return true;
            }
            case 38: {
                pSAppViewLogicBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSAppLocalDE getPSAppDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppDE();
        }
        if (this.getPSAppDEId() == null) {
            return null;
        }
        Integer n = this.objPSAppDELock;
        synchronized (n) {
            if (this.psappde != null && DataTypeHelper.compare((int)25, (Object)this.getPSAppDEId(), (Object)this.psappde.getPSAppLocalDEId()) != 0L) {
                this.psappde = null;
            }
            if (this.psappde == null) {
                PSAppLocalDE pSAppLocalDE = new PSAppLocalDE();
                pSAppLocalDE.setPSAppLocalDEId(this.getPSAppDEId());
                PSAppLocalDEService pSAppLocalDEService = (PSAppLocalDEService)ServiceGlobal.getService(PSAppLocalDEService.class, (SessionFactory)this.getSessionFactory());
                pSAppLocalDEService.autoGet((IEntity)pSAppLocalDE);
                this.psappde = pSAppLocalDE;
            }
            return this.psappde;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSAppViewLogic getRefPSAppViewLogic() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSAppViewLogic();
        }
        if (this.getRefPSAppViewLogicId() == null) {
            return null;
        }
        Integer n = this.objRefPSAppViewLogicLock;
        synchronized (n) {
            if (this.refpsappviewlogic != null && DataTypeHelper.compare((int)25, (Object)this.getRefPSAppViewLogicId(), (Object)this.refpsappviewlogic.getPSAppViewLogicId()) != 0L) {
                this.refpsappviewlogic = null;
            }
            if (this.refpsappviewlogic == null) {
                PSAppViewLogic pSAppViewLogic = new PSAppViewLogic();
                pSAppViewLogic.setPSAppViewLogicId(this.getRefPSAppViewLogicId());
                PSAppViewLogicService pSAppViewLogicService = (PSAppViewLogicService)ServiceGlobal.getService(PSAppViewLogicService.class, (SessionFactory)this.getSessionFactory());
                pSAppViewLogicService.autoGet((IEntity)pSAppViewLogic);
                this.refpsappviewlogic = pSAppViewLogic;
            }
            return this.refpsappviewlogic;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSAppView getPSAppView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppView();
        }
        if (this.getPSAppViewId() == null) {
            return null;
        }
        Integer n = this.objPSAppViewLock;
        synchronized (n) {
            if (this.psappview != null && DataTypeHelper.compare((int)25, (Object)this.getPSAppViewId(), (Object)this.psappview.getPSAppViewId()) != 0L) {
                this.psappview = null;
            }
            if (this.psappview == null) {
                PSAppView pSAppView = new PSAppView();
                pSAppView.setPSAppViewId(this.getPSAppViewId());
                PSAppViewService pSAppViewService = (PSAppViewService)ServiceGlobal.getService(PSAppViewService.class, (SessionFactory)this.getSessionFactory());
                pSAppViewService.autoGet((IEntity)pSAppView);
                this.psappview = pSAppView;
            }
            return this.psappview;
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

    private PSAppViewLogicBase getProxyEntity() {
        return this.proxyPSAppViewLogicBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSAppViewLogicBase = null;
        if (iDataObject != null && iDataObject instanceof PSAppViewLogicBase) {
            this.proxyPSAppViewLogicBase = (PSAppViewLogicBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppViewLogicService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_CTRLNAME, 2);
        fieldIndexMap.put(FIELD_CUSTOMCODE, 3);
        fieldIndexMap.put(FIELD_DSTLOGICTYPE, 4);
        fieldIndexMap.put(FIELD_EVENTARG, 5);
        fieldIndexMap.put(FIELD_EVENTARG2, 6);
        fieldIndexMap.put(FIELD_EVENTNAMES, 7);
        fieldIndexMap.put(FIELD_LOGICPARAM, 8);
        fieldIndexMap.put(FIELD_LOGICPARAM2, 9);
        fieldIndexMap.put(FIELD_MEMO, 10);
        fieldIndexMap.put(FIELD_ORDERVALUE, 11);
        fieldIndexMap.put(FIELD_PSAPPDEID, 12);
        fieldIndexMap.put(FIELD_PSAPPDENAME, 13);
        fieldIndexMap.put(FIELD_PSAPPVIEWID, 14);
        fieldIndexMap.put(FIELD_PSAPPVIEWLOGICID, 15);
        fieldIndexMap.put(FIELD_PSAPPVIEWLOGICNAME, 16);
        fieldIndexMap.put(FIELD_PSAPPVIEWLOGICTYPE, 17);
        fieldIndexMap.put(FIELD_PSAPPVIEWNAME, 18);
        fieldIndexMap.put(FIELD_PSDEID, 19);
        fieldIndexMap.put(FIELD_PSDELOGICID, 20);
        fieldIndexMap.put(FIELD_PSDELOGICNAME, 21);
        fieldIndexMap.put(FIELD_PSDEUIACTIONID, 22);
        fieldIndexMap.put(FIELD_PSDEUIACTIONNAME, 23);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINID, 24);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINNAME, 25);
        fieldIndexMap.put(FIELD_PSSYSVIEWLOGICID, 26);
        fieldIndexMap.put(FIELD_PSSYSVIEWLOGICNAME, 27);
        fieldIndexMap.put(FIELD_REFPSAPPVIEWLOGICID, 28);
        fieldIndexMap.put(FIELD_REFPSAPPVIEWLOGICNAME, 29);
        fieldIndexMap.put(FIELD_TIMER, 30);
        fieldIndexMap.put(FIELD_UPDATEDATE, 31);
        fieldIndexMap.put(FIELD_UPDATEMAN, 32);
        fieldIndexMap.put(FIELD_USERCAT, 33);
        fieldIndexMap.put(FIELD_USERTAG, 34);
        fieldIndexMap.put(FIELD_USERTAG2, 35);
        fieldIndexMap.put(FIELD_USERTAG3, 36);
        fieldIndexMap.put(FIELD_USERTAG4, 37);
        fieldIndexMap.put(FIELD_VALIDFLAG, 38);
    }
}

