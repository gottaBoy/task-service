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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataView;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataViewService;
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

public abstract class PSDEDataViewLogicBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEDataViewLogicBase.class);
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
    public static final String FIELD_PSDEDATAVIEWID = "PSDEDATAVIEWID";
    public static final String FIELD_PSDEDATAVIEWLOGICID = "PSDEDATAVIEWLOGICID";
    public static final String FIELD_PSDEDATAVIEWLOGICNAME = "PSDEDATAVIEWLOGICNAME";
    public static final String FIELD_PSDEDATAVIEWNAME = "PSDEDATAVIEWNAME";
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
    private static final int INDEX_PSDEDATAVIEWID = 12;
    private static final int INDEX_PSDEDATAVIEWLOGICID = 13;
    private static final int INDEX_PSDEDATAVIEWLOGICNAME = 14;
    private static final int INDEX_PSDEDATAVIEWNAME = 15;
    private static final int INDEX_PSDEID = 16;
    private static final int INDEX_PSDELOGICID = 17;
    private static final int INDEX_PSDELOGICNAME = 18;
    private static final int INDEX_PSDENAME = 19;
    private static final int INDEX_PSDEUIACTIONID = 20;
    private static final int INDEX_PSDEUIACTIONNAME = 21;
    private static final int INDEX_PSSYSPFPLUGINID = 22;
    private static final int INDEX_PSSYSPFPLUGINNAME = 23;
    private static final int INDEX_PSSYSVIEWLOGICID = 24;
    private static final int INDEX_PSSYSVIEWLOGICNAME = 25;
    private static final int INDEX_PSSYSVIEWPANELID = 26;
    private static final int INDEX_PSSYSVIEWPANELNAME = 27;
    private static final int INDEX_TIMER = 28;
    private static final int INDEX_TRIGGERTYPE = 29;
    private static final int INDEX_UPDATEDATE = 30;
    private static final int INDEX_UPDATEMAN = 31;
    private static final int INDEX_USERCAT = 32;
    private static final int INDEX_USERTAG = 33;
    private static final int INDEX_USERTAG2 = 34;
    private static final int INDEX_USERTAG3 = 35;
    private static final int INDEX_USERTAG4 = 36;
    private static final int INDEX_VALIDFLAG = 37;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEDataViewLogicBase proxyPSDEDataViewLogicBase = null;
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
    private boolean psdedataviewidDirtyFlag = false;
    private boolean psdedataviewlogicidDirtyFlag = false;
    private boolean psdedataviewlogicnameDirtyFlag = false;
    private boolean psdedataviewnameDirtyFlag = false;
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
    @Column(name="psdedataviewid")
    private String psdedataviewid;
    @Column(name="psdedataviewlogicid")
    private String psdedataviewlogicid;
    @Column(name="psdedataviewlogicname")
    private String psdedataviewlogicname;
    @Column(name="psdedataviewname")
    private String psdedataviewname;
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
    private Integer objPSDEDataViewLock = new Integer(1);
    private PSDEDataView psdedataview = null;
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

    public void setPSDEDataViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedataviewid = string;
        this.psdedataviewidDirtyFlag = true;
    }

    public String getPSDEDataViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataViewId();
        }
        return this.psdedataviewid;
    }

    public boolean isPSDEDataViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataViewIdDirty();
        }
        return this.psdedataviewidDirtyFlag;
    }

    public void resetPSDEDataViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataViewId();
            return;
        }
        this.psdedataviewidDirtyFlag = false;
        this.psdedataviewid = null;
    }

    public void setPSDEDataViewLogicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataViewLogicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedataviewlogicid = string;
        this.psdedataviewlogicidDirtyFlag = true;
    }

    public String getPSDEDataViewLogicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataViewLogicId();
        }
        return this.psdedataviewlogicid;
    }

    public boolean isPSDEDataViewLogicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataViewLogicIdDirty();
        }
        return this.psdedataviewlogicidDirtyFlag;
    }

    public void resetPSDEDataViewLogicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataViewLogicId();
            return;
        }
        this.psdedataviewlogicidDirtyFlag = false;
        this.psdedataviewlogicid = null;
    }

    public void setPSDEDataViewLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataViewLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedataviewlogicname = string;
        this.psdedataviewlogicnameDirtyFlag = true;
    }

    public String getPSDEDataViewLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataViewLogicName();
        }
        return this.psdedataviewlogicname;
    }

    public boolean isPSDEDataViewLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataViewLogicNameDirty();
        }
        return this.psdedataviewlogicnameDirtyFlag;
    }

    public void resetPSDEDataViewLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataViewLogicName();
            return;
        }
        this.psdedataviewlogicnameDirtyFlag = false;
        this.psdedataviewlogicname = null;
    }

    public void setPSDEDataViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedataviewname = string;
        this.psdedataviewnameDirtyFlag = true;
    }

    public String getPSDEDataViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataViewName();
        }
        return this.psdedataviewname;
    }

    public boolean isPSDEDataViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataViewNameDirty();
        }
        return this.psdedataviewnameDirtyFlag;
    }

    public void resetPSDEDataViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataViewName();
            return;
        }
        this.psdedataviewnameDirtyFlag = false;
        this.psdedataviewname = null;
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
        PSDEDataViewLogicBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEDataViewLogicBase pSDEDataViewLogicBase) {
        pSDEDataViewLogicBase.resetAttrName();
        pSDEDataViewLogicBase.resetCreateDate();
        pSDEDataViewLogicBase.resetCreateMan();
        pSDEDataViewLogicBase.resetCustomCode();
        pSDEDataViewLogicBase.resetDstLogicType();
        pSDEDataViewLogicBase.resetEventArg();
        pSDEDataViewLogicBase.resetEventArg2();
        pSDEDataViewLogicBase.resetEventNames();
        pSDEDataViewLogicBase.resetLogicParam();
        pSDEDataViewLogicBase.resetLogicParam2();
        pSDEDataViewLogicBase.resetMemo();
        pSDEDataViewLogicBase.resetOrderValue();
        pSDEDataViewLogicBase.resetPSDEDataViewId();
        pSDEDataViewLogicBase.resetPSDEDataViewLogicId();
        pSDEDataViewLogicBase.resetPSDEDataViewLogicName();
        pSDEDataViewLogicBase.resetPSDEDataViewName();
        pSDEDataViewLogicBase.resetPSDEId();
        pSDEDataViewLogicBase.resetPSDELogicId();
        pSDEDataViewLogicBase.resetPSDELogicName();
        pSDEDataViewLogicBase.resetPSDEName();
        pSDEDataViewLogicBase.resetPSDEUIActionId();
        pSDEDataViewLogicBase.resetPSDEUIActionName();
        pSDEDataViewLogicBase.resetPSSysPFPluginId();
        pSDEDataViewLogicBase.resetPSSysPFPluginName();
        pSDEDataViewLogicBase.resetPSSysViewLogicId();
        pSDEDataViewLogicBase.resetPSSysViewLogicName();
        pSDEDataViewLogicBase.resetPSSysViewPanelId();
        pSDEDataViewLogicBase.resetPSSysViewPanelName();
        pSDEDataViewLogicBase.resetTimer();
        pSDEDataViewLogicBase.resetTriggerType();
        pSDEDataViewLogicBase.resetUpdateDate();
        pSDEDataViewLogicBase.resetUpdateMan();
        pSDEDataViewLogicBase.resetUserCat();
        pSDEDataViewLogicBase.resetUserTag();
        pSDEDataViewLogicBase.resetUserTag2();
        pSDEDataViewLogicBase.resetUserTag3();
        pSDEDataViewLogicBase.resetUserTag4();
        pSDEDataViewLogicBase.resetValidFlag();
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
        if (!bl || this.isPSDEDataViewIdDirty()) {
            hashMap.put(FIELD_PSDEDATAVIEWID, this.getPSDEDataViewId());
        }
        if (!bl || this.isPSDEDataViewLogicIdDirty()) {
            hashMap.put(FIELD_PSDEDATAVIEWLOGICID, this.getPSDEDataViewLogicId());
        }
        if (!bl || this.isPSDEDataViewLogicNameDirty()) {
            hashMap.put(FIELD_PSDEDATAVIEWLOGICNAME, this.getPSDEDataViewLogicName());
        }
        if (!bl || this.isPSDEDataViewNameDirty()) {
            hashMap.put(FIELD_PSDEDATAVIEWNAME, this.getPSDEDataViewName());
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
        return PSDEDataViewLogicBase.get(this, n);
    }

    private static Object get(PSDEDataViewLogicBase pSDEDataViewLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDataViewLogicBase.getAttrName();
            }
            case 1: {
                return pSDEDataViewLogicBase.getCreateDate();
            }
            case 2: {
                return pSDEDataViewLogicBase.getCreateMan();
            }
            case 3: {
                return pSDEDataViewLogicBase.getCustomCode();
            }
            case 4: {
                return pSDEDataViewLogicBase.getDstLogicType();
            }
            case 5: {
                return pSDEDataViewLogicBase.getEventArg();
            }
            case 6: {
                return pSDEDataViewLogicBase.getEventArg2();
            }
            case 7: {
                return pSDEDataViewLogicBase.getEventNames();
            }
            case 8: {
                return pSDEDataViewLogicBase.getLogicParam();
            }
            case 9: {
                return pSDEDataViewLogicBase.getLogicParam2();
            }
            case 10: {
                return pSDEDataViewLogicBase.getMemo();
            }
            case 11: {
                return pSDEDataViewLogicBase.getOrderValue();
            }
            case 12: {
                return pSDEDataViewLogicBase.getPSDEDataViewId();
            }
            case 13: {
                return pSDEDataViewLogicBase.getPSDEDataViewLogicId();
            }
            case 14: {
                return pSDEDataViewLogicBase.getPSDEDataViewLogicName();
            }
            case 15: {
                return pSDEDataViewLogicBase.getPSDEDataViewName();
            }
            case 16: {
                return pSDEDataViewLogicBase.getPSDEId();
            }
            case 17: {
                return pSDEDataViewLogicBase.getPSDELogicId();
            }
            case 18: {
                return pSDEDataViewLogicBase.getPSDELogicName();
            }
            case 19: {
                return pSDEDataViewLogicBase.getPSDEName();
            }
            case 20: {
                return pSDEDataViewLogicBase.getPSDEUIActionId();
            }
            case 21: {
                return pSDEDataViewLogicBase.getPSDEUIActionName();
            }
            case 22: {
                return pSDEDataViewLogicBase.getPSSysPFPluginId();
            }
            case 23: {
                return pSDEDataViewLogicBase.getPSSysPFPluginName();
            }
            case 24: {
                return pSDEDataViewLogicBase.getPSSysViewLogicId();
            }
            case 25: {
                return pSDEDataViewLogicBase.getPSSysViewLogicName();
            }
            case 26: {
                return pSDEDataViewLogicBase.getPSSysViewPanelId();
            }
            case 27: {
                return pSDEDataViewLogicBase.getPSSysViewPanelName();
            }
            case 28: {
                return pSDEDataViewLogicBase.getTimer();
            }
            case 29: {
                return pSDEDataViewLogicBase.getTriggerType();
            }
            case 30: {
                return pSDEDataViewLogicBase.getUpdateDate();
            }
            case 31: {
                return pSDEDataViewLogicBase.getUpdateMan();
            }
            case 32: {
                return pSDEDataViewLogicBase.getUserCat();
            }
            case 33: {
                return pSDEDataViewLogicBase.getUserTag();
            }
            case 34: {
                return pSDEDataViewLogicBase.getUserTag2();
            }
            case 35: {
                return pSDEDataViewLogicBase.getUserTag3();
            }
            case 36: {
                return pSDEDataViewLogicBase.getUserTag4();
            }
            case 37: {
                return pSDEDataViewLogicBase.getValidFlag();
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
        PSDEDataViewLogicBase.set(this, n, object);
    }

    private static void set(PSDEDataViewLogicBase pSDEDataViewLogicBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEDataViewLogicBase.setAttrName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDEDataViewLogicBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDEDataViewLogicBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEDataViewLogicBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEDataViewLogicBase.setDstLogicType(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEDataViewLogicBase.setEventArg(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEDataViewLogicBase.setEventArg2(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEDataViewLogicBase.setEventNames(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEDataViewLogicBase.setLogicParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEDataViewLogicBase.setLogicParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEDataViewLogicBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEDataViewLogicBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSDEDataViewLogicBase.setPSDEDataViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEDataViewLogicBase.setPSDEDataViewLogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEDataViewLogicBase.setPSDEDataViewLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEDataViewLogicBase.setPSDEDataViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEDataViewLogicBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEDataViewLogicBase.setPSDELogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEDataViewLogicBase.setPSDELogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEDataViewLogicBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDEDataViewLogicBase.setPSDEUIActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEDataViewLogicBase.setPSDEUIActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDEDataViewLogicBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDEDataViewLogicBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDEDataViewLogicBase.setPSSysViewLogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDEDataViewLogicBase.setPSSysViewLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDEDataViewLogicBase.setPSSysViewPanelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDEDataViewLogicBase.setPSSysViewPanelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDEDataViewLogicBase.setTimer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 29: {
                pSDEDataViewLogicBase.setTriggerType(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDEDataViewLogicBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 31: {
                pSDEDataViewLogicBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDEDataViewLogicBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDEDataViewLogicBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDEDataViewLogicBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDEDataViewLogicBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDEDataViewLogicBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSDEDataViewLogicBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDEDataViewLogicBase.isNull(this, n);
    }

    private static boolean isNull(PSDEDataViewLogicBase pSDEDataViewLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDataViewLogicBase.getAttrName() == null;
            }
            case 1: {
                return pSDEDataViewLogicBase.getCreateDate() == null;
            }
            case 2: {
                return pSDEDataViewLogicBase.getCreateMan() == null;
            }
            case 3: {
                return pSDEDataViewLogicBase.getCustomCode() == null;
            }
            case 4: {
                return pSDEDataViewLogicBase.getDstLogicType() == null;
            }
            case 5: {
                return pSDEDataViewLogicBase.getEventArg() == null;
            }
            case 6: {
                return pSDEDataViewLogicBase.getEventArg2() == null;
            }
            case 7: {
                return pSDEDataViewLogicBase.getEventNames() == null;
            }
            case 8: {
                return pSDEDataViewLogicBase.getLogicParam() == null;
            }
            case 9: {
                return pSDEDataViewLogicBase.getLogicParam2() == null;
            }
            case 10: {
                return pSDEDataViewLogicBase.getMemo() == null;
            }
            case 11: {
                return pSDEDataViewLogicBase.getOrderValue() == null;
            }
            case 12: {
                return pSDEDataViewLogicBase.getPSDEDataViewId() == null;
            }
            case 13: {
                return pSDEDataViewLogicBase.getPSDEDataViewLogicId() == null;
            }
            case 14: {
                return pSDEDataViewLogicBase.getPSDEDataViewLogicName() == null;
            }
            case 15: {
                return pSDEDataViewLogicBase.getPSDEDataViewName() == null;
            }
            case 16: {
                return pSDEDataViewLogicBase.getPSDEId() == null;
            }
            case 17: {
                return pSDEDataViewLogicBase.getPSDELogicId() == null;
            }
            case 18: {
                return pSDEDataViewLogicBase.getPSDELogicName() == null;
            }
            case 19: {
                return pSDEDataViewLogicBase.getPSDEName() == null;
            }
            case 20: {
                return pSDEDataViewLogicBase.getPSDEUIActionId() == null;
            }
            case 21: {
                return pSDEDataViewLogicBase.getPSDEUIActionName() == null;
            }
            case 22: {
                return pSDEDataViewLogicBase.getPSSysPFPluginId() == null;
            }
            case 23: {
                return pSDEDataViewLogicBase.getPSSysPFPluginName() == null;
            }
            case 24: {
                return pSDEDataViewLogicBase.getPSSysViewLogicId() == null;
            }
            case 25: {
                return pSDEDataViewLogicBase.getPSSysViewLogicName() == null;
            }
            case 26: {
                return pSDEDataViewLogicBase.getPSSysViewPanelId() == null;
            }
            case 27: {
                return pSDEDataViewLogicBase.getPSSysViewPanelName() == null;
            }
            case 28: {
                return pSDEDataViewLogicBase.getTimer() == null;
            }
            case 29: {
                return pSDEDataViewLogicBase.getTriggerType() == null;
            }
            case 30: {
                return pSDEDataViewLogicBase.getUpdateDate() == null;
            }
            case 31: {
                return pSDEDataViewLogicBase.getUpdateMan() == null;
            }
            case 32: {
                return pSDEDataViewLogicBase.getUserCat() == null;
            }
            case 33: {
                return pSDEDataViewLogicBase.getUserTag() == null;
            }
            case 34: {
                return pSDEDataViewLogicBase.getUserTag2() == null;
            }
            case 35: {
                return pSDEDataViewLogicBase.getUserTag3() == null;
            }
            case 36: {
                return pSDEDataViewLogicBase.getUserTag4() == null;
            }
            case 37: {
                return pSDEDataViewLogicBase.getValidFlag() == null;
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
        return PSDEDataViewLogicBase.contains(this, n);
    }

    private static boolean contains(PSDEDataViewLogicBase pSDEDataViewLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDataViewLogicBase.isAttrNameDirty();
            }
            case 1: {
                return pSDEDataViewLogicBase.isCreateDateDirty();
            }
            case 2: {
                return pSDEDataViewLogicBase.isCreateManDirty();
            }
            case 3: {
                return pSDEDataViewLogicBase.isCustomCodeDirty();
            }
            case 4: {
                return pSDEDataViewLogicBase.isDstLogicTypeDirty();
            }
            case 5: {
                return pSDEDataViewLogicBase.isEventArgDirty();
            }
            case 6: {
                return pSDEDataViewLogicBase.isEventArg2Dirty();
            }
            case 7: {
                return pSDEDataViewLogicBase.isEventNamesDirty();
            }
            case 8: {
                return pSDEDataViewLogicBase.isLogicParamDirty();
            }
            case 9: {
                return pSDEDataViewLogicBase.isLogicParam2Dirty();
            }
            case 10: {
                return pSDEDataViewLogicBase.isMemoDirty();
            }
            case 11: {
                return pSDEDataViewLogicBase.isOrderValueDirty();
            }
            case 12: {
                return pSDEDataViewLogicBase.isPSDEDataViewIdDirty();
            }
            case 13: {
                return pSDEDataViewLogicBase.isPSDEDataViewLogicIdDirty();
            }
            case 14: {
                return pSDEDataViewLogicBase.isPSDEDataViewLogicNameDirty();
            }
            case 15: {
                return pSDEDataViewLogicBase.isPSDEDataViewNameDirty();
            }
            case 16: {
                return pSDEDataViewLogicBase.isPSDEIdDirty();
            }
            case 17: {
                return pSDEDataViewLogicBase.isPSDELogicIdDirty();
            }
            case 18: {
                return pSDEDataViewLogicBase.isPSDELogicNameDirty();
            }
            case 19: {
                return pSDEDataViewLogicBase.isPSDENameDirty();
            }
            case 20: {
                return pSDEDataViewLogicBase.isPSDEUIActionIdDirty();
            }
            case 21: {
                return pSDEDataViewLogicBase.isPSDEUIActionNameDirty();
            }
            case 22: {
                return pSDEDataViewLogicBase.isPSSysPFPluginIdDirty();
            }
            case 23: {
                return pSDEDataViewLogicBase.isPSSysPFPluginNameDirty();
            }
            case 24: {
                return pSDEDataViewLogicBase.isPSSysViewLogicIdDirty();
            }
            case 25: {
                return pSDEDataViewLogicBase.isPSSysViewLogicNameDirty();
            }
            case 26: {
                return pSDEDataViewLogicBase.isPSSysViewPanelIdDirty();
            }
            case 27: {
                return pSDEDataViewLogicBase.isPSSysViewPanelNameDirty();
            }
            case 28: {
                return pSDEDataViewLogicBase.isTimerDirty();
            }
            case 29: {
                return pSDEDataViewLogicBase.isTriggerTypeDirty();
            }
            case 30: {
                return pSDEDataViewLogicBase.isUpdateDateDirty();
            }
            case 31: {
                return pSDEDataViewLogicBase.isUpdateManDirty();
            }
            case 32: {
                return pSDEDataViewLogicBase.isUserCatDirty();
            }
            case 33: {
                return pSDEDataViewLogicBase.isUserTagDirty();
            }
            case 34: {
                return pSDEDataViewLogicBase.isUserTag2Dirty();
            }
            case 35: {
                return pSDEDataViewLogicBase.isUserTag3Dirty();
            }
            case 36: {
                return pSDEDataViewLogicBase.isUserTag4Dirty();
            }
            case 37: {
                return pSDEDataViewLogicBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEDataViewLogicBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEDataViewLogicBase pSDEDataViewLogicBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEDataViewLogicBase.getAttrName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"attrname", (Object)PSDEDataViewLogicBase.getJSONValue((Object)pSDEDataViewLogicBase.getAttrName()), (boolean)false);
        }
        if (bl || pSDEDataViewLogicBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEDataViewLogicBase.getJSONValue((Object)pSDEDataViewLogicBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEDataViewLogicBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEDataViewLogicBase.getJSONValue((Object)pSDEDataViewLogicBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEDataViewLogicBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSDEDataViewLogicBase.getJSONValue((Object)pSDEDataViewLogicBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSDEDataViewLogicBase.getDstLogicType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstlogictype", (Object)PSDEDataViewLogicBase.getJSONValue((Object)pSDEDataViewLogicBase.getDstLogicType()), (boolean)false);
        }
        if (bl || pSDEDataViewLogicBase.getEventArg() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eventarg", (Object)PSDEDataViewLogicBase.getJSONValue((Object)pSDEDataViewLogicBase.getEventArg()), (boolean)false);
        }
        if (bl || pSDEDataViewLogicBase.getEventArg2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eventarg2", (Object)PSDEDataViewLogicBase.getJSONValue((Object)pSDEDataViewLogicBase.getEventArg2()), (boolean)false);
        }
        if (bl || pSDEDataViewLogicBase.getEventNames() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eventnames", (Object)PSDEDataViewLogicBase.getJSONValue((Object)pSDEDataViewLogicBase.getEventNames()), (boolean)false);
        }
        if (bl || pSDEDataViewLogicBase.getLogicParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicparam", (Object)PSDEDataViewLogicBase.getJSONValue((Object)pSDEDataViewLogicBase.getLogicParam()), (boolean)false);
        }
        if (bl || pSDEDataViewLogicBase.getLogicParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicparam2", (Object)PSDEDataViewLogicBase.getJSONValue((Object)pSDEDataViewLogicBase.getLogicParam2()), (boolean)false);
        }
        if (bl || pSDEDataViewLogicBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEDataViewLogicBase.getJSONValue((Object)pSDEDataViewLogicBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEDataViewLogicBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDEDataViewLogicBase.getJSONValue((Object)pSDEDataViewLogicBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDEDataViewLogicBase.getPSDEDataViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedataviewid", (Object)PSDEDataViewLogicBase.getJSONValue((Object)pSDEDataViewLogicBase.getPSDEDataViewId()), (boolean)false);
        }
        if (bl || pSDEDataViewLogicBase.getPSDEDataViewLogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedataviewlogicid", (Object)PSDEDataViewLogicBase.getJSONValue((Object)pSDEDataViewLogicBase.getPSDEDataViewLogicId()), (boolean)false);
        }
        if (bl || pSDEDataViewLogicBase.getPSDEDataViewLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedataviewlogicname", (Object)PSDEDataViewLogicBase.getJSONValue((Object)pSDEDataViewLogicBase.getPSDEDataViewLogicName()), (boolean)false);
        }
        if (bl || pSDEDataViewLogicBase.getPSDEDataViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedataviewname", (Object)PSDEDataViewLogicBase.getJSONValue((Object)pSDEDataViewLogicBase.getPSDEDataViewName()), (boolean)false);
        }
        if (bl || pSDEDataViewLogicBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEDataViewLogicBase.getJSONValue((Object)pSDEDataViewLogicBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEDataViewLogicBase.getPSDELogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicid", (Object)PSDEDataViewLogicBase.getJSONValue((Object)pSDEDataViewLogicBase.getPSDELogicId()), (boolean)false);
        }
        if (bl || pSDEDataViewLogicBase.getPSDELogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicname", (Object)PSDEDataViewLogicBase.getJSONValue((Object)pSDEDataViewLogicBase.getPSDELogicName()), (boolean)false);
        }
        if (bl || pSDEDataViewLogicBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDEDataViewLogicBase.getJSONValue((Object)pSDEDataViewLogicBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDEDataViewLogicBase.getPSDEUIActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuiactionid", (Object)PSDEDataViewLogicBase.getJSONValue((Object)pSDEDataViewLogicBase.getPSDEUIActionId()), (boolean)false);
        }
        if (bl || pSDEDataViewLogicBase.getPSDEUIActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuiactionname", (Object)PSDEDataViewLogicBase.getJSONValue((Object)pSDEDataViewLogicBase.getPSDEUIActionName()), (boolean)false);
        }
        if (bl || pSDEDataViewLogicBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSDEDataViewLogicBase.getJSONValue((Object)pSDEDataViewLogicBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSDEDataViewLogicBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSDEDataViewLogicBase.getJSONValue((Object)pSDEDataViewLogicBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSDEDataViewLogicBase.getPSSysViewLogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewlogicid", (Object)PSDEDataViewLogicBase.getJSONValue((Object)pSDEDataViewLogicBase.getPSSysViewLogicId()), (boolean)false);
        }
        if (bl || pSDEDataViewLogicBase.getPSSysViewLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewlogicname", (Object)PSDEDataViewLogicBase.getJSONValue((Object)pSDEDataViewLogicBase.getPSSysViewLogicName()), (boolean)false);
        }
        if (bl || pSDEDataViewLogicBase.getPSSysViewPanelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelid", (Object)PSDEDataViewLogicBase.getJSONValue((Object)pSDEDataViewLogicBase.getPSSysViewPanelId()), (boolean)false);
        }
        if (bl || pSDEDataViewLogicBase.getPSSysViewPanelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelname", (Object)PSDEDataViewLogicBase.getJSONValue((Object)pSDEDataViewLogicBase.getPSSysViewPanelName()), (boolean)false);
        }
        if (bl || pSDEDataViewLogicBase.getTimer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"timer", (Object)PSDEDataViewLogicBase.getJSONValue((Object)pSDEDataViewLogicBase.getTimer()), (boolean)false);
        }
        if (bl || pSDEDataViewLogicBase.getTriggerType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"triggertype", (Object)PSDEDataViewLogicBase.getJSONValue((Object)pSDEDataViewLogicBase.getTriggerType()), (boolean)false);
        }
        if (bl || pSDEDataViewLogicBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEDataViewLogicBase.getJSONValue((Object)pSDEDataViewLogicBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEDataViewLogicBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEDataViewLogicBase.getJSONValue((Object)pSDEDataViewLogicBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEDataViewLogicBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEDataViewLogicBase.getJSONValue((Object)pSDEDataViewLogicBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEDataViewLogicBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEDataViewLogicBase.getJSONValue((Object)pSDEDataViewLogicBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEDataViewLogicBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEDataViewLogicBase.getJSONValue((Object)pSDEDataViewLogicBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEDataViewLogicBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEDataViewLogicBase.getJSONValue((Object)pSDEDataViewLogicBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEDataViewLogicBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEDataViewLogicBase.getJSONValue((Object)pSDEDataViewLogicBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDEDataViewLogicBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDEDataViewLogicBase.getJSONValue((Object)pSDEDataViewLogicBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEDataViewLogicBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEDataViewLogicBase pSDEDataViewLogicBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEDataViewLogicBase.getAttrName() != null) {
            object = pSDEDataViewLogicBase.getAttrName();
            xmlNode.setAttribute(FIELD_ATTRNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewLogicBase.getCreateDate() != null) {
            object = pSDEDataViewLogicBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEDataViewLogicBase.getCreateMan() != null) {
            object = pSDEDataViewLogicBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewLogicBase.getCustomCode() != null) {
            object = pSDEDataViewLogicBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewLogicBase.getDstLogicType() != null) {
            object = pSDEDataViewLogicBase.getDstLogicType();
            xmlNode.setAttribute(FIELD_DSTLOGICTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewLogicBase.getEventArg() != null) {
            object = pSDEDataViewLogicBase.getEventArg();
            xmlNode.setAttribute(FIELD_EVENTARG, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewLogicBase.getEventArg2() != null) {
            object = pSDEDataViewLogicBase.getEventArg2();
            xmlNode.setAttribute(FIELD_EVENTARG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewLogicBase.getEventNames() != null) {
            object = pSDEDataViewLogicBase.getEventNames();
            xmlNode.setAttribute(FIELD_EVENTNAMES, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewLogicBase.getLogicParam() != null) {
            object = pSDEDataViewLogicBase.getLogicParam();
            xmlNode.setAttribute(FIELD_LOGICPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewLogicBase.getLogicParam2() != null) {
            object = pSDEDataViewLogicBase.getLogicParam2();
            xmlNode.setAttribute(FIELD_LOGICPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewLogicBase.getMemo() != null) {
            object = pSDEDataViewLogicBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewLogicBase.getOrderValue() != null) {
            object = pSDEDataViewLogicBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataViewLogicBase.getPSDEDataViewId() != null) {
            object = pSDEDataViewLogicBase.getPSDEDataViewId();
            xmlNode.setAttribute(FIELD_PSDEDATAVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewLogicBase.getPSDEDataViewLogicId() != null) {
            object = pSDEDataViewLogicBase.getPSDEDataViewLogicId();
            xmlNode.setAttribute(FIELD_PSDEDATAVIEWLOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewLogicBase.getPSDEDataViewLogicName() != null) {
            object = pSDEDataViewLogicBase.getPSDEDataViewLogicName();
            xmlNode.setAttribute(FIELD_PSDEDATAVIEWLOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewLogicBase.getPSDEDataViewName() != null) {
            object = pSDEDataViewLogicBase.getPSDEDataViewName();
            xmlNode.setAttribute(FIELD_PSDEDATAVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewLogicBase.getPSDEId() != null) {
            object = pSDEDataViewLogicBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewLogicBase.getPSDELogicId() != null) {
            object = pSDEDataViewLogicBase.getPSDELogicId();
            xmlNode.setAttribute(FIELD_PSDELOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewLogicBase.getPSDELogicName() != null) {
            object = pSDEDataViewLogicBase.getPSDELogicName();
            xmlNode.setAttribute(FIELD_PSDELOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewLogicBase.getPSDEName() != null) {
            object = pSDEDataViewLogicBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewLogicBase.getPSDEUIActionId() != null) {
            object = pSDEDataViewLogicBase.getPSDEUIActionId();
            xmlNode.setAttribute(FIELD_PSDEUIACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewLogicBase.getPSDEUIActionName() != null) {
            object = pSDEDataViewLogicBase.getPSDEUIActionName();
            xmlNode.setAttribute(FIELD_PSDEUIACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewLogicBase.getPSSysPFPluginId() != null) {
            object = pSDEDataViewLogicBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewLogicBase.getPSSysPFPluginName() != null) {
            object = pSDEDataViewLogicBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewLogicBase.getPSSysViewLogicId() != null) {
            object = pSDEDataViewLogicBase.getPSSysViewLogicId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWLOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewLogicBase.getPSSysViewLogicName() != null) {
            object = pSDEDataViewLogicBase.getPSSysViewLogicName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWLOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewLogicBase.getPSSysViewPanelId() != null) {
            object = pSDEDataViewLogicBase.getPSSysViewPanelId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewLogicBase.getPSSysViewPanelName() != null) {
            object = pSDEDataViewLogicBase.getPSSysViewPanelName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewLogicBase.getTimer() != null) {
            object = pSDEDataViewLogicBase.getTimer();
            xmlNode.setAttribute(FIELD_TIMER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataViewLogicBase.getTriggerType() != null) {
            object = pSDEDataViewLogicBase.getTriggerType();
            xmlNode.setAttribute(FIELD_TRIGGERTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewLogicBase.getUpdateDate() != null) {
            object = pSDEDataViewLogicBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEDataViewLogicBase.getUpdateMan() != null) {
            object = pSDEDataViewLogicBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewLogicBase.getUserCat() != null) {
            object = pSDEDataViewLogicBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewLogicBase.getUserTag() != null) {
            object = pSDEDataViewLogicBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewLogicBase.getUserTag2() != null) {
            object = pSDEDataViewLogicBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewLogicBase.getUserTag3() != null) {
            object = pSDEDataViewLogicBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewLogicBase.getUserTag4() != null) {
            object = pSDEDataViewLogicBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewLogicBase.getValidFlag() != null) {
            object = pSDEDataViewLogicBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEDataViewLogicBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEDataViewLogicBase pSDEDataViewLogicBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEDataViewLogicBase.isAttrNameDirty() && (bl || pSDEDataViewLogicBase.getAttrName() != null)) {
            iDataObject.set(FIELD_ATTRNAME, (Object)pSDEDataViewLogicBase.getAttrName());
        }
        if (pSDEDataViewLogicBase.isCreateDateDirty() && (bl || pSDEDataViewLogicBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEDataViewLogicBase.getCreateDate());
        }
        if (pSDEDataViewLogicBase.isCreateManDirty() && (bl || pSDEDataViewLogicBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEDataViewLogicBase.getCreateMan());
        }
        if (pSDEDataViewLogicBase.isCustomCodeDirty() && (bl || pSDEDataViewLogicBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSDEDataViewLogicBase.getCustomCode());
        }
        if (pSDEDataViewLogicBase.isDstLogicTypeDirty() && (bl || pSDEDataViewLogicBase.getDstLogicType() != null)) {
            iDataObject.set(FIELD_DSTLOGICTYPE, (Object)pSDEDataViewLogicBase.getDstLogicType());
        }
        if (pSDEDataViewLogicBase.isEventArgDirty() && (bl || pSDEDataViewLogicBase.getEventArg() != null)) {
            iDataObject.set(FIELD_EVENTARG, (Object)pSDEDataViewLogicBase.getEventArg());
        }
        if (pSDEDataViewLogicBase.isEventArg2Dirty() && (bl || pSDEDataViewLogicBase.getEventArg2() != null)) {
            iDataObject.set(FIELD_EVENTARG2, (Object)pSDEDataViewLogicBase.getEventArg2());
        }
        if (pSDEDataViewLogicBase.isEventNamesDirty() && (bl || pSDEDataViewLogicBase.getEventNames() != null)) {
            iDataObject.set(FIELD_EVENTNAMES, (Object)pSDEDataViewLogicBase.getEventNames());
        }
        if (pSDEDataViewLogicBase.isLogicParamDirty() && (bl || pSDEDataViewLogicBase.getLogicParam() != null)) {
            iDataObject.set(FIELD_LOGICPARAM, (Object)pSDEDataViewLogicBase.getLogicParam());
        }
        if (pSDEDataViewLogicBase.isLogicParam2Dirty() && (bl || pSDEDataViewLogicBase.getLogicParam2() != null)) {
            iDataObject.set(FIELD_LOGICPARAM2, (Object)pSDEDataViewLogicBase.getLogicParam2());
        }
        if (pSDEDataViewLogicBase.isMemoDirty() && (bl || pSDEDataViewLogicBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEDataViewLogicBase.getMemo());
        }
        if (pSDEDataViewLogicBase.isOrderValueDirty() && (bl || pSDEDataViewLogicBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDEDataViewLogicBase.getOrderValue());
        }
        if (pSDEDataViewLogicBase.isPSDEDataViewIdDirty() && (bl || pSDEDataViewLogicBase.getPSDEDataViewId() != null)) {
            iDataObject.set(FIELD_PSDEDATAVIEWID, (Object)pSDEDataViewLogicBase.getPSDEDataViewId());
        }
        if (pSDEDataViewLogicBase.isPSDEDataViewLogicIdDirty() && (bl || pSDEDataViewLogicBase.getPSDEDataViewLogicId() != null)) {
            iDataObject.set(FIELD_PSDEDATAVIEWLOGICID, (Object)pSDEDataViewLogicBase.getPSDEDataViewLogicId());
        }
        if (pSDEDataViewLogicBase.isPSDEDataViewLogicNameDirty() && (bl || pSDEDataViewLogicBase.getPSDEDataViewLogicName() != null)) {
            iDataObject.set(FIELD_PSDEDATAVIEWLOGICNAME, (Object)pSDEDataViewLogicBase.getPSDEDataViewLogicName());
        }
        if (pSDEDataViewLogicBase.isPSDEDataViewNameDirty() && (bl || pSDEDataViewLogicBase.getPSDEDataViewName() != null)) {
            iDataObject.set(FIELD_PSDEDATAVIEWNAME, (Object)pSDEDataViewLogicBase.getPSDEDataViewName());
        }
        if (pSDEDataViewLogicBase.isPSDEIdDirty() && (bl || pSDEDataViewLogicBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEDataViewLogicBase.getPSDEId());
        }
        if (pSDEDataViewLogicBase.isPSDELogicIdDirty() && (bl || pSDEDataViewLogicBase.getPSDELogicId() != null)) {
            iDataObject.set(FIELD_PSDELOGICID, (Object)pSDEDataViewLogicBase.getPSDELogicId());
        }
        if (pSDEDataViewLogicBase.isPSDELogicNameDirty() && (bl || pSDEDataViewLogicBase.getPSDELogicName() != null)) {
            iDataObject.set(FIELD_PSDELOGICNAME, (Object)pSDEDataViewLogicBase.getPSDELogicName());
        }
        if (pSDEDataViewLogicBase.isPSDENameDirty() && (bl || pSDEDataViewLogicBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDEDataViewLogicBase.getPSDEName());
        }
        if (pSDEDataViewLogicBase.isPSDEUIActionIdDirty() && (bl || pSDEDataViewLogicBase.getPSDEUIActionId() != null)) {
            iDataObject.set(FIELD_PSDEUIACTIONID, (Object)pSDEDataViewLogicBase.getPSDEUIActionId());
        }
        if (pSDEDataViewLogicBase.isPSDEUIActionNameDirty() && (bl || pSDEDataViewLogicBase.getPSDEUIActionName() != null)) {
            iDataObject.set(FIELD_PSDEUIACTIONNAME, (Object)pSDEDataViewLogicBase.getPSDEUIActionName());
        }
        if (pSDEDataViewLogicBase.isPSSysPFPluginIdDirty() && (bl || pSDEDataViewLogicBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSDEDataViewLogicBase.getPSSysPFPluginId());
        }
        if (pSDEDataViewLogicBase.isPSSysPFPluginNameDirty() && (bl || pSDEDataViewLogicBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSDEDataViewLogicBase.getPSSysPFPluginName());
        }
        if (pSDEDataViewLogicBase.isPSSysViewLogicIdDirty() && (bl || pSDEDataViewLogicBase.getPSSysViewLogicId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWLOGICID, (Object)pSDEDataViewLogicBase.getPSSysViewLogicId());
        }
        if (pSDEDataViewLogicBase.isPSSysViewLogicNameDirty() && (bl || pSDEDataViewLogicBase.getPSSysViewLogicName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWLOGICNAME, (Object)pSDEDataViewLogicBase.getPSSysViewLogicName());
        }
        if (pSDEDataViewLogicBase.isPSSysViewPanelIdDirty() && (bl || pSDEDataViewLogicBase.getPSSysViewPanelId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELID, (Object)pSDEDataViewLogicBase.getPSSysViewPanelId());
        }
        if (pSDEDataViewLogicBase.isPSSysViewPanelNameDirty() && (bl || pSDEDataViewLogicBase.getPSSysViewPanelName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELNAME, (Object)pSDEDataViewLogicBase.getPSSysViewPanelName());
        }
        if (pSDEDataViewLogicBase.isTimerDirty() && (bl || pSDEDataViewLogicBase.getTimer() != null)) {
            iDataObject.set(FIELD_TIMER, (Object)pSDEDataViewLogicBase.getTimer());
        }
        if (pSDEDataViewLogicBase.isTriggerTypeDirty() && (bl || pSDEDataViewLogicBase.getTriggerType() != null)) {
            iDataObject.set(FIELD_TRIGGERTYPE, (Object)pSDEDataViewLogicBase.getTriggerType());
        }
        if (pSDEDataViewLogicBase.isUpdateDateDirty() && (bl || pSDEDataViewLogicBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEDataViewLogicBase.getUpdateDate());
        }
        if (pSDEDataViewLogicBase.isUpdateManDirty() && (bl || pSDEDataViewLogicBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEDataViewLogicBase.getUpdateMan());
        }
        if (pSDEDataViewLogicBase.isUserCatDirty() && (bl || pSDEDataViewLogicBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEDataViewLogicBase.getUserCat());
        }
        if (pSDEDataViewLogicBase.isUserTagDirty() && (bl || pSDEDataViewLogicBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEDataViewLogicBase.getUserTag());
        }
        if (pSDEDataViewLogicBase.isUserTag2Dirty() && (bl || pSDEDataViewLogicBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEDataViewLogicBase.getUserTag2());
        }
        if (pSDEDataViewLogicBase.isUserTag3Dirty() && (bl || pSDEDataViewLogicBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEDataViewLogicBase.getUserTag3());
        }
        if (pSDEDataViewLogicBase.isUserTag4Dirty() && (bl || pSDEDataViewLogicBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEDataViewLogicBase.getUserTag4());
        }
        if (pSDEDataViewLogicBase.isValidFlagDirty() && (bl || pSDEDataViewLogicBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDEDataViewLogicBase.getValidFlag());
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
        return PSDEDataViewLogicBase.remove(this, n);
    }

    private static boolean remove(PSDEDataViewLogicBase pSDEDataViewLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEDataViewLogicBase.resetAttrName();
                return true;
            }
            case 1: {
                pSDEDataViewLogicBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDEDataViewLogicBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDEDataViewLogicBase.resetCustomCode();
                return true;
            }
            case 4: {
                pSDEDataViewLogicBase.resetDstLogicType();
                return true;
            }
            case 5: {
                pSDEDataViewLogicBase.resetEventArg();
                return true;
            }
            case 6: {
                pSDEDataViewLogicBase.resetEventArg2();
                return true;
            }
            case 7: {
                pSDEDataViewLogicBase.resetEventNames();
                return true;
            }
            case 8: {
                pSDEDataViewLogicBase.resetLogicParam();
                return true;
            }
            case 9: {
                pSDEDataViewLogicBase.resetLogicParam2();
                return true;
            }
            case 10: {
                pSDEDataViewLogicBase.resetMemo();
                return true;
            }
            case 11: {
                pSDEDataViewLogicBase.resetOrderValue();
                return true;
            }
            case 12: {
                pSDEDataViewLogicBase.resetPSDEDataViewId();
                return true;
            }
            case 13: {
                pSDEDataViewLogicBase.resetPSDEDataViewLogicId();
                return true;
            }
            case 14: {
                pSDEDataViewLogicBase.resetPSDEDataViewLogicName();
                return true;
            }
            case 15: {
                pSDEDataViewLogicBase.resetPSDEDataViewName();
                return true;
            }
            case 16: {
                pSDEDataViewLogicBase.resetPSDEId();
                return true;
            }
            case 17: {
                pSDEDataViewLogicBase.resetPSDELogicId();
                return true;
            }
            case 18: {
                pSDEDataViewLogicBase.resetPSDELogicName();
                return true;
            }
            case 19: {
                pSDEDataViewLogicBase.resetPSDEName();
                return true;
            }
            case 20: {
                pSDEDataViewLogicBase.resetPSDEUIActionId();
                return true;
            }
            case 21: {
                pSDEDataViewLogicBase.resetPSDEUIActionName();
                return true;
            }
            case 22: {
                pSDEDataViewLogicBase.resetPSSysPFPluginId();
                return true;
            }
            case 23: {
                pSDEDataViewLogicBase.resetPSSysPFPluginName();
                return true;
            }
            case 24: {
                pSDEDataViewLogicBase.resetPSSysViewLogicId();
                return true;
            }
            case 25: {
                pSDEDataViewLogicBase.resetPSSysViewLogicName();
                return true;
            }
            case 26: {
                pSDEDataViewLogicBase.resetPSSysViewPanelId();
                return true;
            }
            case 27: {
                pSDEDataViewLogicBase.resetPSSysViewPanelName();
                return true;
            }
            case 28: {
                pSDEDataViewLogicBase.resetTimer();
                return true;
            }
            case 29: {
                pSDEDataViewLogicBase.resetTriggerType();
                return true;
            }
            case 30: {
                pSDEDataViewLogicBase.resetUpdateDate();
                return true;
            }
            case 31: {
                pSDEDataViewLogicBase.resetUpdateMan();
                return true;
            }
            case 32: {
                pSDEDataViewLogicBase.resetUserCat();
                return true;
            }
            case 33: {
                pSDEDataViewLogicBase.resetUserTag();
                return true;
            }
            case 34: {
                pSDEDataViewLogicBase.resetUserTag2();
                return true;
            }
            case 35: {
                pSDEDataViewLogicBase.resetUserTag3();
                return true;
            }
            case 36: {
                pSDEDataViewLogicBase.resetUserTag4();
                return true;
            }
            case 37: {
                pSDEDataViewLogicBase.resetValidFlag();
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
    public PSDEDataView getPSDEDataView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataView();
        }
        if (this.getPSDEDataViewId() == null) {
            return null;
        }
        Integer n = this.objPSDEDataViewLock;
        synchronized (n) {
            if (this.psdedataview != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEDataViewId(), (Object)this.psdedataview.getPSDEDataViewId()) != 0L) {
                this.psdedataview = null;
            }
            if (this.psdedataview == null) {
                PSDEDataView pSDEDataView = new PSDEDataView();
                pSDEDataView.setPSDEDataViewId(this.getPSDEDataViewId());
                PSDEDataViewService pSDEDataViewService = (PSDEDataViewService)ServiceGlobal.getService(PSDEDataViewService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataViewService.autoGet(pSDEDataView);
                this.psdedataview = pSDEDataView;
            }
            return this.psdedataview;
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

    private PSDEDataViewLogicBase getProxyEntity() {
        return this.proxyPSDEDataViewLogicBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEDataViewLogicBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEDataViewLogicBase) {
            this.proxyPSDEDataViewLogicBase = (PSDEDataViewLogicBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataViewLogicService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
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
        fieldIndexMap.put(FIELD_PSDEDATAVIEWID, 12);
        fieldIndexMap.put(FIELD_PSDEDATAVIEWLOGICID, 13);
        fieldIndexMap.put(FIELD_PSDEDATAVIEWLOGICNAME, 14);
        fieldIndexMap.put(FIELD_PSDEDATAVIEWNAME, 15);
        fieldIndexMap.put(FIELD_PSDEID, 16);
        fieldIndexMap.put(FIELD_PSDELOGICID, 17);
        fieldIndexMap.put(FIELD_PSDELOGICNAME, 18);
        fieldIndexMap.put(FIELD_PSDENAME, 19);
        fieldIndexMap.put(FIELD_PSDEUIACTIONID, 20);
        fieldIndexMap.put(FIELD_PSDEUIACTIONNAME, 21);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINID, 22);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINNAME, 23);
        fieldIndexMap.put(FIELD_PSSYSVIEWLOGICID, 24);
        fieldIndexMap.put(FIELD_PSSYSVIEWLOGICNAME, 25);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELID, 26);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELNAME, 27);
        fieldIndexMap.put(FIELD_TIMER, 28);
        fieldIndexMap.put(FIELD_TRIGGERTYPE, 29);
        fieldIndexMap.put(FIELD_UPDATEDATE, 30);
        fieldIndexMap.put(FIELD_UPDATEMAN, 31);
        fieldIndexMap.put(FIELD_USERCAT, 32);
        fieldIndexMap.put(FIELD_USERTAG, 33);
        fieldIndexMap.put(FIELD_USERTAG2, 34);
        fieldIndexMap.put(FIELD_USERTAG3, 35);
        fieldIndexMap.put(FIELD_USERTAG4, 36);
        fieldIndexMap.put(FIELD_VALIDFLAG, 37);
    }
}

