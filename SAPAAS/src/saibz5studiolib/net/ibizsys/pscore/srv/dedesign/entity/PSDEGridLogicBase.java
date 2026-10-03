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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGrid;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGridCol;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridColService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridService;
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

public abstract class PSDEGridLogicBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEGridLogicBase.class);
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
    public static final String FIELD_PSDEGRIDCOLID = "PSDEGRIDCOLID";
    public static final String FIELD_PSDEGRIDCOLNAME = "PSDEGRIDCOLNAME";
    public static final String FIELD_PSDEGRIDID = "PSDEGRIDID";
    public static final String FIELD_PSDEGRIDCOLLOGICID = "PSDEGRIDLOGICID";
    public static final String FIELD_PSDEGRIDCOLLOGICNAME = "PSDEGRIDLOGICNAME";
    public static final String FIELD_PSDEGRIDNAME = "PSDEGRIDNAME";
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
    private static final int INDEX_PSDEGRIDCOLID = 12;
    private static final int INDEX_PSDEGRIDCOLNAME = 13;
    private static final int INDEX_PSDEGRIDID = 14;
    private static final int INDEX_PSDEGRIDCOLLOGICID = 15;
    private static final int INDEX_PSDEGRIDCOLLOGICNAME = 16;
    private static final int INDEX_PSDEGRIDNAME = 17;
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
    private PSDEGridLogicBase proxyPSDEGridLogicBase = null;
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
    private boolean psdegridcolidDirtyFlag = false;
    private boolean psdegridcolnameDirtyFlag = false;
    private boolean psdegrididDirtyFlag = false;
    private boolean psdegridcollogicidDirtyFlag = false;
    private boolean psdegridcollogicnameDirtyFlag = false;
    private boolean psdegridnameDirtyFlag = false;
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
    @Column(name="psdegridcolid")
    private String psdegridcolid;
    @Column(name="psdegridcolname")
    private String psdegridcolname;
    @Column(name="psdegridid")
    private String psdegridid;
    @Column(name="psdegridcollogicid")
    private String psdegridcollogicid;
    @Column(name="psdegridcollogicname")
    private String psdegridcollogicname;
    @Column(name="psdegridname")
    private String psdegridname;
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
    private Integer objPSDEGridColLock = new Integer(1);
    private PSDEGridCol psdegridcol = null;
    private Integer objPSDEGridLock = new Integer(1);
    private PSDEGrid psdegrid = null;
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

    public void setPSDEGridColId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEGridColId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdegridcolid = string;
        this.psdegridcolidDirtyFlag = true;
    }

    public String getPSDEGridColId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGridColId();
        }
        return this.psdegridcolid;
    }

    public boolean isPSDEGridColIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEGridColIdDirty();
        }
        return this.psdegridcolidDirtyFlag;
    }

    public void resetPSDEGridColId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEGridColId();
            return;
        }
        this.psdegridcolidDirtyFlag = false;
        this.psdegridcolid = null;
    }

    public void setPSDEGridColName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEGridColName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdegridcolname = string;
        this.psdegridcolnameDirtyFlag = true;
    }

    public String getPSDEGridColName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGridColName();
        }
        return this.psdegridcolname;
    }

    public boolean isPSDEGridColNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEGridColNameDirty();
        }
        return this.psdegridcolnameDirtyFlag;
    }

    public void resetPSDEGridColName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEGridColName();
            return;
        }
        this.psdegridcolnameDirtyFlag = false;
        this.psdegridcolname = null;
    }

    public void setPSDEGridId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEGridId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdegridid = string;
        this.psdegrididDirtyFlag = true;
    }

    public String getPSDEGridId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGridId();
        }
        return this.psdegridid;
    }

    public boolean isPSDEGridIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEGridIdDirty();
        }
        return this.psdegrididDirtyFlag;
    }

    public void resetPSDEGridId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEGridId();
            return;
        }
        this.psdegrididDirtyFlag = false;
        this.psdegridid = null;
    }

    public void setPSDEGridColLogicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEGridColLogicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdegridcollogicid = string;
        this.psdegridcollogicidDirtyFlag = true;
    }

    public String getPSDEGridColLogicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGridColLogicId();
        }
        return this.psdegridcollogicid;
    }

    public boolean isPSDEGridColLogicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEGridColLogicIdDirty();
        }
        return this.psdegridcollogicidDirtyFlag;
    }

    public void resetPSDEGridColLogicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEGridColLogicId();
            return;
        }
        this.psdegridcollogicidDirtyFlag = false;
        this.psdegridcollogicid = null;
    }

    public void setPSDEGridColLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEGridColLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdegridcollogicname = string;
        this.psdegridcollogicnameDirtyFlag = true;
    }

    public String getPSDEGridColLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGridColLogicName();
        }
        return this.psdegridcollogicname;
    }

    public boolean isPSDEGridColLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEGridColLogicNameDirty();
        }
        return this.psdegridcollogicnameDirtyFlag;
    }

    public void resetPSDEGridColLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEGridColLogicName();
            return;
        }
        this.psdegridcollogicnameDirtyFlag = false;
        this.psdegridcollogicname = null;
    }

    public void setPSDEGridName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEGridName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdegridname = string;
        this.psdegridnameDirtyFlag = true;
    }

    public String getPSDEGridName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGridName();
        }
        return this.psdegridname;
    }

    public boolean isPSDEGridNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEGridNameDirty();
        }
        return this.psdegridnameDirtyFlag;
    }

    public void resetPSDEGridName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEGridName();
            return;
        }
        this.psdegridnameDirtyFlag = false;
        this.psdegridname = null;
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
        PSDEGridLogicBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEGridLogicBase pSDEGridLogicBase) {
        pSDEGridLogicBase.resetAttrName();
        pSDEGridLogicBase.resetCreateDate();
        pSDEGridLogicBase.resetCreateMan();
        pSDEGridLogicBase.resetCustomCode();
        pSDEGridLogicBase.resetDstLogicType();
        pSDEGridLogicBase.resetEventArg();
        pSDEGridLogicBase.resetEventArg2();
        pSDEGridLogicBase.resetEventNames();
        pSDEGridLogicBase.resetLogicParam();
        pSDEGridLogicBase.resetLogicParam2();
        pSDEGridLogicBase.resetMemo();
        pSDEGridLogicBase.resetOrderValue();
        pSDEGridLogicBase.resetPSDEGridColId();
        pSDEGridLogicBase.resetPSDEGridColName();
        pSDEGridLogicBase.resetPSDEGridId();
        pSDEGridLogicBase.resetPSDEGridColLogicId();
        pSDEGridLogicBase.resetPSDEGridColLogicName();
        pSDEGridLogicBase.resetPSDEGridName();
        pSDEGridLogicBase.resetPSDEId();
        pSDEGridLogicBase.resetPSDELogicId();
        pSDEGridLogicBase.resetPSDELogicName();
        pSDEGridLogicBase.resetPSDEName();
        pSDEGridLogicBase.resetPSDEUIActionId();
        pSDEGridLogicBase.resetPSDEUIActionName();
        pSDEGridLogicBase.resetPSSysPFPluginId();
        pSDEGridLogicBase.resetPSSysPFPluginName();
        pSDEGridLogicBase.resetPSSysViewLogicId();
        pSDEGridLogicBase.resetPSSysViewLogicName();
        pSDEGridLogicBase.resetPSSysViewPanelId();
        pSDEGridLogicBase.resetPSSysViewPanelName();
        pSDEGridLogicBase.resetTimer();
        pSDEGridLogicBase.resetTriggerType();
        pSDEGridLogicBase.resetUpdateDate();
        pSDEGridLogicBase.resetUpdateMan();
        pSDEGridLogicBase.resetUserCat();
        pSDEGridLogicBase.resetUserTag();
        pSDEGridLogicBase.resetUserTag2();
        pSDEGridLogicBase.resetUserTag3();
        pSDEGridLogicBase.resetUserTag4();
        pSDEGridLogicBase.resetValidFlag();
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
        if (!bl || this.isPSDEGridColIdDirty()) {
            hashMap.put(FIELD_PSDEGRIDCOLID, this.getPSDEGridColId());
        }
        if (!bl || this.isPSDEGridColNameDirty()) {
            hashMap.put(FIELD_PSDEGRIDCOLNAME, this.getPSDEGridColName());
        }
        if (!bl || this.isPSDEGridIdDirty()) {
            hashMap.put(FIELD_PSDEGRIDID, this.getPSDEGridId());
        }
        if (!bl || this.isPSDEGridColLogicIdDirty()) {
            hashMap.put(FIELD_PSDEGRIDCOLLOGICID, this.getPSDEGridColLogicId());
        }
        if (!bl || this.isPSDEGridColLogicNameDirty()) {
            hashMap.put(FIELD_PSDEGRIDCOLLOGICNAME, this.getPSDEGridColLogicName());
        }
        if (!bl || this.isPSDEGridNameDirty()) {
            hashMap.put(FIELD_PSDEGRIDNAME, this.getPSDEGridName());
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
        return PSDEGridLogicBase.get(this, n);
    }

    private static Object get(PSDEGridLogicBase pSDEGridLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEGridLogicBase.getAttrName();
            }
            case 1: {
                return pSDEGridLogicBase.getCreateDate();
            }
            case 2: {
                return pSDEGridLogicBase.getCreateMan();
            }
            case 3: {
                return pSDEGridLogicBase.getCustomCode();
            }
            case 4: {
                return pSDEGridLogicBase.getDstLogicType();
            }
            case 5: {
                return pSDEGridLogicBase.getEventArg();
            }
            case 6: {
                return pSDEGridLogicBase.getEventArg2();
            }
            case 7: {
                return pSDEGridLogicBase.getEventNames();
            }
            case 8: {
                return pSDEGridLogicBase.getLogicParam();
            }
            case 9: {
                return pSDEGridLogicBase.getLogicParam2();
            }
            case 10: {
                return pSDEGridLogicBase.getMemo();
            }
            case 11: {
                return pSDEGridLogicBase.getOrderValue();
            }
            case 12: {
                return pSDEGridLogicBase.getPSDEGridColId();
            }
            case 13: {
                return pSDEGridLogicBase.getPSDEGridColName();
            }
            case 14: {
                return pSDEGridLogicBase.getPSDEGridId();
            }
            case 15: {
                return pSDEGridLogicBase.getPSDEGridColLogicId();
            }
            case 16: {
                return pSDEGridLogicBase.getPSDEGridColLogicName();
            }
            case 17: {
                return pSDEGridLogicBase.getPSDEGridName();
            }
            case 18: {
                return pSDEGridLogicBase.getPSDEId();
            }
            case 19: {
                return pSDEGridLogicBase.getPSDELogicId();
            }
            case 20: {
                return pSDEGridLogicBase.getPSDELogicName();
            }
            case 21: {
                return pSDEGridLogicBase.getPSDEName();
            }
            case 22: {
                return pSDEGridLogicBase.getPSDEUIActionId();
            }
            case 23: {
                return pSDEGridLogicBase.getPSDEUIActionName();
            }
            case 24: {
                return pSDEGridLogicBase.getPSSysPFPluginId();
            }
            case 25: {
                return pSDEGridLogicBase.getPSSysPFPluginName();
            }
            case 26: {
                return pSDEGridLogicBase.getPSSysViewLogicId();
            }
            case 27: {
                return pSDEGridLogicBase.getPSSysViewLogicName();
            }
            case 28: {
                return pSDEGridLogicBase.getPSSysViewPanelId();
            }
            case 29: {
                return pSDEGridLogicBase.getPSSysViewPanelName();
            }
            case 30: {
                return pSDEGridLogicBase.getTimer();
            }
            case 31: {
                return pSDEGridLogicBase.getTriggerType();
            }
            case 32: {
                return pSDEGridLogicBase.getUpdateDate();
            }
            case 33: {
                return pSDEGridLogicBase.getUpdateMan();
            }
            case 34: {
                return pSDEGridLogicBase.getUserCat();
            }
            case 35: {
                return pSDEGridLogicBase.getUserTag();
            }
            case 36: {
                return pSDEGridLogicBase.getUserTag2();
            }
            case 37: {
                return pSDEGridLogicBase.getUserTag3();
            }
            case 38: {
                return pSDEGridLogicBase.getUserTag4();
            }
            case 39: {
                return pSDEGridLogicBase.getValidFlag();
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
        PSDEGridLogicBase.set(this, n, object);
    }

    private static void set(PSDEGridLogicBase pSDEGridLogicBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEGridLogicBase.setAttrName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDEGridLogicBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDEGridLogicBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEGridLogicBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEGridLogicBase.setDstLogicType(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEGridLogicBase.setEventArg(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEGridLogicBase.setEventArg2(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEGridLogicBase.setEventNames(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEGridLogicBase.setLogicParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEGridLogicBase.setLogicParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEGridLogicBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEGridLogicBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSDEGridLogicBase.setPSDEGridColId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEGridLogicBase.setPSDEGridColName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEGridLogicBase.setPSDEGridId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEGridLogicBase.setPSDEGridColLogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEGridLogicBase.setPSDEGridColLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEGridLogicBase.setPSDEGridName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEGridLogicBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEGridLogicBase.setPSDELogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDEGridLogicBase.setPSDELogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEGridLogicBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDEGridLogicBase.setPSDEUIActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDEGridLogicBase.setPSDEUIActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDEGridLogicBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDEGridLogicBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDEGridLogicBase.setPSSysViewLogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDEGridLogicBase.setPSSysViewLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDEGridLogicBase.setPSSysViewPanelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDEGridLogicBase.setPSSysViewPanelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDEGridLogicBase.setTimer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 31: {
                pSDEGridLogicBase.setTriggerType(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDEGridLogicBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 33: {
                pSDEGridLogicBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDEGridLogicBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDEGridLogicBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDEGridLogicBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSDEGridLogicBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDEGridLogicBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSDEGridLogicBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDEGridLogicBase.isNull(this, n);
    }

    private static boolean isNull(PSDEGridLogicBase pSDEGridLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEGridLogicBase.getAttrName() == null;
            }
            case 1: {
                return pSDEGridLogicBase.getCreateDate() == null;
            }
            case 2: {
                return pSDEGridLogicBase.getCreateMan() == null;
            }
            case 3: {
                return pSDEGridLogicBase.getCustomCode() == null;
            }
            case 4: {
                return pSDEGridLogicBase.getDstLogicType() == null;
            }
            case 5: {
                return pSDEGridLogicBase.getEventArg() == null;
            }
            case 6: {
                return pSDEGridLogicBase.getEventArg2() == null;
            }
            case 7: {
                return pSDEGridLogicBase.getEventNames() == null;
            }
            case 8: {
                return pSDEGridLogicBase.getLogicParam() == null;
            }
            case 9: {
                return pSDEGridLogicBase.getLogicParam2() == null;
            }
            case 10: {
                return pSDEGridLogicBase.getMemo() == null;
            }
            case 11: {
                return pSDEGridLogicBase.getOrderValue() == null;
            }
            case 12: {
                return pSDEGridLogicBase.getPSDEGridColId() == null;
            }
            case 13: {
                return pSDEGridLogicBase.getPSDEGridColName() == null;
            }
            case 14: {
                return pSDEGridLogicBase.getPSDEGridId() == null;
            }
            case 15: {
                return pSDEGridLogicBase.getPSDEGridColLogicId() == null;
            }
            case 16: {
                return pSDEGridLogicBase.getPSDEGridColLogicName() == null;
            }
            case 17: {
                return pSDEGridLogicBase.getPSDEGridName() == null;
            }
            case 18: {
                return pSDEGridLogicBase.getPSDEId() == null;
            }
            case 19: {
                return pSDEGridLogicBase.getPSDELogicId() == null;
            }
            case 20: {
                return pSDEGridLogicBase.getPSDELogicName() == null;
            }
            case 21: {
                return pSDEGridLogicBase.getPSDEName() == null;
            }
            case 22: {
                return pSDEGridLogicBase.getPSDEUIActionId() == null;
            }
            case 23: {
                return pSDEGridLogicBase.getPSDEUIActionName() == null;
            }
            case 24: {
                return pSDEGridLogicBase.getPSSysPFPluginId() == null;
            }
            case 25: {
                return pSDEGridLogicBase.getPSSysPFPluginName() == null;
            }
            case 26: {
                return pSDEGridLogicBase.getPSSysViewLogicId() == null;
            }
            case 27: {
                return pSDEGridLogicBase.getPSSysViewLogicName() == null;
            }
            case 28: {
                return pSDEGridLogicBase.getPSSysViewPanelId() == null;
            }
            case 29: {
                return pSDEGridLogicBase.getPSSysViewPanelName() == null;
            }
            case 30: {
                return pSDEGridLogicBase.getTimer() == null;
            }
            case 31: {
                return pSDEGridLogicBase.getTriggerType() == null;
            }
            case 32: {
                return pSDEGridLogicBase.getUpdateDate() == null;
            }
            case 33: {
                return pSDEGridLogicBase.getUpdateMan() == null;
            }
            case 34: {
                return pSDEGridLogicBase.getUserCat() == null;
            }
            case 35: {
                return pSDEGridLogicBase.getUserTag() == null;
            }
            case 36: {
                return pSDEGridLogicBase.getUserTag2() == null;
            }
            case 37: {
                return pSDEGridLogicBase.getUserTag3() == null;
            }
            case 38: {
                return pSDEGridLogicBase.getUserTag4() == null;
            }
            case 39: {
                return pSDEGridLogicBase.getValidFlag() == null;
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
        return PSDEGridLogicBase.contains(this, n);
    }

    private static boolean contains(PSDEGridLogicBase pSDEGridLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEGridLogicBase.isAttrNameDirty();
            }
            case 1: {
                return pSDEGridLogicBase.isCreateDateDirty();
            }
            case 2: {
                return pSDEGridLogicBase.isCreateManDirty();
            }
            case 3: {
                return pSDEGridLogicBase.isCustomCodeDirty();
            }
            case 4: {
                return pSDEGridLogicBase.isDstLogicTypeDirty();
            }
            case 5: {
                return pSDEGridLogicBase.isEventArgDirty();
            }
            case 6: {
                return pSDEGridLogicBase.isEventArg2Dirty();
            }
            case 7: {
                return pSDEGridLogicBase.isEventNamesDirty();
            }
            case 8: {
                return pSDEGridLogicBase.isLogicParamDirty();
            }
            case 9: {
                return pSDEGridLogicBase.isLogicParam2Dirty();
            }
            case 10: {
                return pSDEGridLogicBase.isMemoDirty();
            }
            case 11: {
                return pSDEGridLogicBase.isOrderValueDirty();
            }
            case 12: {
                return pSDEGridLogicBase.isPSDEGridColIdDirty();
            }
            case 13: {
                return pSDEGridLogicBase.isPSDEGridColNameDirty();
            }
            case 14: {
                return pSDEGridLogicBase.isPSDEGridIdDirty();
            }
            case 15: {
                return pSDEGridLogicBase.isPSDEGridColLogicIdDirty();
            }
            case 16: {
                return pSDEGridLogicBase.isPSDEGridColLogicNameDirty();
            }
            case 17: {
                return pSDEGridLogicBase.isPSDEGridNameDirty();
            }
            case 18: {
                return pSDEGridLogicBase.isPSDEIdDirty();
            }
            case 19: {
                return pSDEGridLogicBase.isPSDELogicIdDirty();
            }
            case 20: {
                return pSDEGridLogicBase.isPSDELogicNameDirty();
            }
            case 21: {
                return pSDEGridLogicBase.isPSDENameDirty();
            }
            case 22: {
                return pSDEGridLogicBase.isPSDEUIActionIdDirty();
            }
            case 23: {
                return pSDEGridLogicBase.isPSDEUIActionNameDirty();
            }
            case 24: {
                return pSDEGridLogicBase.isPSSysPFPluginIdDirty();
            }
            case 25: {
                return pSDEGridLogicBase.isPSSysPFPluginNameDirty();
            }
            case 26: {
                return pSDEGridLogicBase.isPSSysViewLogicIdDirty();
            }
            case 27: {
                return pSDEGridLogicBase.isPSSysViewLogicNameDirty();
            }
            case 28: {
                return pSDEGridLogicBase.isPSSysViewPanelIdDirty();
            }
            case 29: {
                return pSDEGridLogicBase.isPSSysViewPanelNameDirty();
            }
            case 30: {
                return pSDEGridLogicBase.isTimerDirty();
            }
            case 31: {
                return pSDEGridLogicBase.isTriggerTypeDirty();
            }
            case 32: {
                return pSDEGridLogicBase.isUpdateDateDirty();
            }
            case 33: {
                return pSDEGridLogicBase.isUpdateManDirty();
            }
            case 34: {
                return pSDEGridLogicBase.isUserCatDirty();
            }
            case 35: {
                return pSDEGridLogicBase.isUserTagDirty();
            }
            case 36: {
                return pSDEGridLogicBase.isUserTag2Dirty();
            }
            case 37: {
                return pSDEGridLogicBase.isUserTag3Dirty();
            }
            case 38: {
                return pSDEGridLogicBase.isUserTag4Dirty();
            }
            case 39: {
                return pSDEGridLogicBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEGridLogicBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEGridLogicBase pSDEGridLogicBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEGridLogicBase.getAttrName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"attrname", (Object)PSDEGridLogicBase.getJSONValue((Object)pSDEGridLogicBase.getAttrName()), (boolean)false);
        }
        if (bl || pSDEGridLogicBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEGridLogicBase.getJSONValue((Object)pSDEGridLogicBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEGridLogicBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEGridLogicBase.getJSONValue((Object)pSDEGridLogicBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEGridLogicBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSDEGridLogicBase.getJSONValue((Object)pSDEGridLogicBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSDEGridLogicBase.getDstLogicType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstlogictype", (Object)PSDEGridLogicBase.getJSONValue((Object)pSDEGridLogicBase.getDstLogicType()), (boolean)false);
        }
        if (bl || pSDEGridLogicBase.getEventArg() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eventarg", (Object)PSDEGridLogicBase.getJSONValue((Object)pSDEGridLogicBase.getEventArg()), (boolean)false);
        }
        if (bl || pSDEGridLogicBase.getEventArg2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eventarg2", (Object)PSDEGridLogicBase.getJSONValue((Object)pSDEGridLogicBase.getEventArg2()), (boolean)false);
        }
        if (bl || pSDEGridLogicBase.getEventNames() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eventnames", (Object)PSDEGridLogicBase.getJSONValue((Object)pSDEGridLogicBase.getEventNames()), (boolean)false);
        }
        if (bl || pSDEGridLogicBase.getLogicParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicparam", (Object)PSDEGridLogicBase.getJSONValue((Object)pSDEGridLogicBase.getLogicParam()), (boolean)false);
        }
        if (bl || pSDEGridLogicBase.getLogicParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicparam2", (Object)PSDEGridLogicBase.getJSONValue((Object)pSDEGridLogicBase.getLogicParam2()), (boolean)false);
        }
        if (bl || pSDEGridLogicBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEGridLogicBase.getJSONValue((Object)pSDEGridLogicBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEGridLogicBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDEGridLogicBase.getJSONValue((Object)pSDEGridLogicBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDEGridLogicBase.getPSDEGridColId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdegridcolid", (Object)PSDEGridLogicBase.getJSONValue((Object)pSDEGridLogicBase.getPSDEGridColId()), (boolean)false);
        }
        if (bl || pSDEGridLogicBase.getPSDEGridColName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdegridcolname", (Object)PSDEGridLogicBase.getJSONValue((Object)pSDEGridLogicBase.getPSDEGridColName()), (boolean)false);
        }
        if (bl || pSDEGridLogicBase.getPSDEGridId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdegridid", (Object)PSDEGridLogicBase.getJSONValue((Object)pSDEGridLogicBase.getPSDEGridId()), (boolean)false);
        }
        if (bl || pSDEGridLogicBase.getPSDEGridColLogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdegridlogicid", (Object)PSDEGridLogicBase.getJSONValue((Object)pSDEGridLogicBase.getPSDEGridColLogicId()), (boolean)false);
        }
        if (bl || pSDEGridLogicBase.getPSDEGridColLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdegridlogicname", (Object)PSDEGridLogicBase.getJSONValue((Object)pSDEGridLogicBase.getPSDEGridColLogicName()), (boolean)false);
        }
        if (bl || pSDEGridLogicBase.getPSDEGridName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdegridname", (Object)PSDEGridLogicBase.getJSONValue((Object)pSDEGridLogicBase.getPSDEGridName()), (boolean)false);
        }
        if (bl || pSDEGridLogicBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEGridLogicBase.getJSONValue((Object)pSDEGridLogicBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEGridLogicBase.getPSDELogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicid", (Object)PSDEGridLogicBase.getJSONValue((Object)pSDEGridLogicBase.getPSDELogicId()), (boolean)false);
        }
        if (bl || pSDEGridLogicBase.getPSDELogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicname", (Object)PSDEGridLogicBase.getJSONValue((Object)pSDEGridLogicBase.getPSDELogicName()), (boolean)false);
        }
        if (bl || pSDEGridLogicBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDEGridLogicBase.getJSONValue((Object)pSDEGridLogicBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDEGridLogicBase.getPSDEUIActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuiactionid", (Object)PSDEGridLogicBase.getJSONValue((Object)pSDEGridLogicBase.getPSDEUIActionId()), (boolean)false);
        }
        if (bl || pSDEGridLogicBase.getPSDEUIActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuiactionname", (Object)PSDEGridLogicBase.getJSONValue((Object)pSDEGridLogicBase.getPSDEUIActionName()), (boolean)false);
        }
        if (bl || pSDEGridLogicBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSDEGridLogicBase.getJSONValue((Object)pSDEGridLogicBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSDEGridLogicBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSDEGridLogicBase.getJSONValue((Object)pSDEGridLogicBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSDEGridLogicBase.getPSSysViewLogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewlogicid", (Object)PSDEGridLogicBase.getJSONValue((Object)pSDEGridLogicBase.getPSSysViewLogicId()), (boolean)false);
        }
        if (bl || pSDEGridLogicBase.getPSSysViewLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewlogicname", (Object)PSDEGridLogicBase.getJSONValue((Object)pSDEGridLogicBase.getPSSysViewLogicName()), (boolean)false);
        }
        if (bl || pSDEGridLogicBase.getPSSysViewPanelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelid", (Object)PSDEGridLogicBase.getJSONValue((Object)pSDEGridLogicBase.getPSSysViewPanelId()), (boolean)false);
        }
        if (bl || pSDEGridLogicBase.getPSSysViewPanelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelname", (Object)PSDEGridLogicBase.getJSONValue((Object)pSDEGridLogicBase.getPSSysViewPanelName()), (boolean)false);
        }
        if (bl || pSDEGridLogicBase.getTimer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"timer", (Object)PSDEGridLogicBase.getJSONValue((Object)pSDEGridLogicBase.getTimer()), (boolean)false);
        }
        if (bl || pSDEGridLogicBase.getTriggerType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"triggertype", (Object)PSDEGridLogicBase.getJSONValue((Object)pSDEGridLogicBase.getTriggerType()), (boolean)false);
        }
        if (bl || pSDEGridLogicBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEGridLogicBase.getJSONValue((Object)pSDEGridLogicBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEGridLogicBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEGridLogicBase.getJSONValue((Object)pSDEGridLogicBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEGridLogicBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEGridLogicBase.getJSONValue((Object)pSDEGridLogicBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEGridLogicBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEGridLogicBase.getJSONValue((Object)pSDEGridLogicBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEGridLogicBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEGridLogicBase.getJSONValue((Object)pSDEGridLogicBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEGridLogicBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEGridLogicBase.getJSONValue((Object)pSDEGridLogicBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEGridLogicBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEGridLogicBase.getJSONValue((Object)pSDEGridLogicBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDEGridLogicBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDEGridLogicBase.getJSONValue((Object)pSDEGridLogicBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEGridLogicBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEGridLogicBase pSDEGridLogicBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEGridLogicBase.getAttrName() != null) {
            object = pSDEGridLogicBase.getAttrName();
            xmlNode.setAttribute(FIELD_ATTRNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridLogicBase.getCreateDate() != null) {
            object = pSDEGridLogicBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEGridLogicBase.getCreateMan() != null) {
            object = pSDEGridLogicBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridLogicBase.getCustomCode() != null) {
            object = pSDEGridLogicBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridLogicBase.getDstLogicType() != null) {
            object = pSDEGridLogicBase.getDstLogicType();
            xmlNode.setAttribute(FIELD_DSTLOGICTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridLogicBase.getEventArg() != null) {
            object = pSDEGridLogicBase.getEventArg();
            xmlNode.setAttribute(FIELD_EVENTARG, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridLogicBase.getEventArg2() != null) {
            object = pSDEGridLogicBase.getEventArg2();
            xmlNode.setAttribute(FIELD_EVENTARG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridLogicBase.getEventNames() != null) {
            object = pSDEGridLogicBase.getEventNames();
            xmlNode.setAttribute(FIELD_EVENTNAMES, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridLogicBase.getLogicParam() != null) {
            object = pSDEGridLogicBase.getLogicParam();
            xmlNode.setAttribute(FIELD_LOGICPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridLogicBase.getLogicParam2() != null) {
            object = pSDEGridLogicBase.getLogicParam2();
            xmlNode.setAttribute(FIELD_LOGICPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridLogicBase.getMemo() != null) {
            object = pSDEGridLogicBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridLogicBase.getOrderValue() != null) {
            object = pSDEGridLogicBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEGridLogicBase.getPSDEGridColId() != null) {
            object = pSDEGridLogicBase.getPSDEGridColId();
            xmlNode.setAttribute(FIELD_PSDEGRIDCOLID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridLogicBase.getPSDEGridColName() != null) {
            object = pSDEGridLogicBase.getPSDEGridColName();
            xmlNode.setAttribute(FIELD_PSDEGRIDCOLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridLogicBase.getPSDEGridId() != null) {
            object = pSDEGridLogicBase.getPSDEGridId();
            xmlNode.setAttribute(FIELD_PSDEGRIDID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridLogicBase.getPSDEGridColLogicId() != null) {
            object = pSDEGridLogicBase.getPSDEGridColLogicId();
            xmlNode.setAttribute("PSDEGRIDCOLLOGICID", object == null ? "" : (String)object);
        }
        if (bl || pSDEGridLogicBase.getPSDEGridColLogicName() != null) {
            object = pSDEGridLogicBase.getPSDEGridColLogicName();
            xmlNode.setAttribute("PSDEGRIDCOLLOGICNAME", object == null ? "" : (String)object);
        }
        if (bl || pSDEGridLogicBase.getPSDEGridName() != null) {
            object = pSDEGridLogicBase.getPSDEGridName();
            xmlNode.setAttribute(FIELD_PSDEGRIDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridLogicBase.getPSDEId() != null) {
            object = pSDEGridLogicBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridLogicBase.getPSDELogicId() != null) {
            object = pSDEGridLogicBase.getPSDELogicId();
            xmlNode.setAttribute(FIELD_PSDELOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridLogicBase.getPSDELogicName() != null) {
            object = pSDEGridLogicBase.getPSDELogicName();
            xmlNode.setAttribute(FIELD_PSDELOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridLogicBase.getPSDEName() != null) {
            object = pSDEGridLogicBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridLogicBase.getPSDEUIActionId() != null) {
            object = pSDEGridLogicBase.getPSDEUIActionId();
            xmlNode.setAttribute(FIELD_PSDEUIACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridLogicBase.getPSDEUIActionName() != null) {
            object = pSDEGridLogicBase.getPSDEUIActionName();
            xmlNode.setAttribute(FIELD_PSDEUIACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridLogicBase.getPSSysPFPluginId() != null) {
            object = pSDEGridLogicBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridLogicBase.getPSSysPFPluginName() != null) {
            object = pSDEGridLogicBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridLogicBase.getPSSysViewLogicId() != null) {
            object = pSDEGridLogicBase.getPSSysViewLogicId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWLOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridLogicBase.getPSSysViewLogicName() != null) {
            object = pSDEGridLogicBase.getPSSysViewLogicName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWLOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridLogicBase.getPSSysViewPanelId() != null) {
            object = pSDEGridLogicBase.getPSSysViewPanelId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridLogicBase.getPSSysViewPanelName() != null) {
            object = pSDEGridLogicBase.getPSSysViewPanelName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridLogicBase.getTimer() != null) {
            object = pSDEGridLogicBase.getTimer();
            xmlNode.setAttribute(FIELD_TIMER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEGridLogicBase.getTriggerType() != null) {
            object = pSDEGridLogicBase.getTriggerType();
            xmlNode.setAttribute(FIELD_TRIGGERTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridLogicBase.getUpdateDate() != null) {
            object = pSDEGridLogicBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEGridLogicBase.getUpdateMan() != null) {
            object = pSDEGridLogicBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridLogicBase.getUserCat() != null) {
            object = pSDEGridLogicBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridLogicBase.getUserTag() != null) {
            object = pSDEGridLogicBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridLogicBase.getUserTag2() != null) {
            object = pSDEGridLogicBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridLogicBase.getUserTag3() != null) {
            object = pSDEGridLogicBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridLogicBase.getUserTag4() != null) {
            object = pSDEGridLogicBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridLogicBase.getValidFlag() != null) {
            object = pSDEGridLogicBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEGridLogicBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEGridLogicBase pSDEGridLogicBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEGridLogicBase.isAttrNameDirty() && (bl || pSDEGridLogicBase.getAttrName() != null)) {
            iDataObject.set(FIELD_ATTRNAME, (Object)pSDEGridLogicBase.getAttrName());
        }
        if (pSDEGridLogicBase.isCreateDateDirty() && (bl || pSDEGridLogicBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEGridLogicBase.getCreateDate());
        }
        if (pSDEGridLogicBase.isCreateManDirty() && (bl || pSDEGridLogicBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEGridLogicBase.getCreateMan());
        }
        if (pSDEGridLogicBase.isCustomCodeDirty() && (bl || pSDEGridLogicBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSDEGridLogicBase.getCustomCode());
        }
        if (pSDEGridLogicBase.isDstLogicTypeDirty() && (bl || pSDEGridLogicBase.getDstLogicType() != null)) {
            iDataObject.set(FIELD_DSTLOGICTYPE, (Object)pSDEGridLogicBase.getDstLogicType());
        }
        if (pSDEGridLogicBase.isEventArgDirty() && (bl || pSDEGridLogicBase.getEventArg() != null)) {
            iDataObject.set(FIELD_EVENTARG, (Object)pSDEGridLogicBase.getEventArg());
        }
        if (pSDEGridLogicBase.isEventArg2Dirty() && (bl || pSDEGridLogicBase.getEventArg2() != null)) {
            iDataObject.set(FIELD_EVENTARG2, (Object)pSDEGridLogicBase.getEventArg2());
        }
        if (pSDEGridLogicBase.isEventNamesDirty() && (bl || pSDEGridLogicBase.getEventNames() != null)) {
            iDataObject.set(FIELD_EVENTNAMES, (Object)pSDEGridLogicBase.getEventNames());
        }
        if (pSDEGridLogicBase.isLogicParamDirty() && (bl || pSDEGridLogicBase.getLogicParam() != null)) {
            iDataObject.set(FIELD_LOGICPARAM, (Object)pSDEGridLogicBase.getLogicParam());
        }
        if (pSDEGridLogicBase.isLogicParam2Dirty() && (bl || pSDEGridLogicBase.getLogicParam2() != null)) {
            iDataObject.set(FIELD_LOGICPARAM2, (Object)pSDEGridLogicBase.getLogicParam2());
        }
        if (pSDEGridLogicBase.isMemoDirty() && (bl || pSDEGridLogicBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEGridLogicBase.getMemo());
        }
        if (pSDEGridLogicBase.isOrderValueDirty() && (bl || pSDEGridLogicBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDEGridLogicBase.getOrderValue());
        }
        if (pSDEGridLogicBase.isPSDEGridColIdDirty() && (bl || pSDEGridLogicBase.getPSDEGridColId() != null)) {
            iDataObject.set(FIELD_PSDEGRIDCOLID, (Object)pSDEGridLogicBase.getPSDEGridColId());
        }
        if (pSDEGridLogicBase.isPSDEGridColNameDirty() && (bl || pSDEGridLogicBase.getPSDEGridColName() != null)) {
            iDataObject.set(FIELD_PSDEGRIDCOLNAME, (Object)pSDEGridLogicBase.getPSDEGridColName());
        }
        if (pSDEGridLogicBase.isPSDEGridIdDirty() && (bl || pSDEGridLogicBase.getPSDEGridId() != null)) {
            iDataObject.set(FIELD_PSDEGRIDID, (Object)pSDEGridLogicBase.getPSDEGridId());
        }
        if (pSDEGridLogicBase.isPSDEGridColLogicIdDirty() && (bl || pSDEGridLogicBase.getPSDEGridColLogicId() != null)) {
            iDataObject.set(FIELD_PSDEGRIDCOLLOGICID, (Object)pSDEGridLogicBase.getPSDEGridColLogicId());
        }
        if (pSDEGridLogicBase.isPSDEGridColLogicNameDirty() && (bl || pSDEGridLogicBase.getPSDEGridColLogicName() != null)) {
            iDataObject.set(FIELD_PSDEGRIDCOLLOGICNAME, (Object)pSDEGridLogicBase.getPSDEGridColLogicName());
        }
        if (pSDEGridLogicBase.isPSDEGridNameDirty() && (bl || pSDEGridLogicBase.getPSDEGridName() != null)) {
            iDataObject.set(FIELD_PSDEGRIDNAME, (Object)pSDEGridLogicBase.getPSDEGridName());
        }
        if (pSDEGridLogicBase.isPSDEIdDirty() && (bl || pSDEGridLogicBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEGridLogicBase.getPSDEId());
        }
        if (pSDEGridLogicBase.isPSDELogicIdDirty() && (bl || pSDEGridLogicBase.getPSDELogicId() != null)) {
            iDataObject.set(FIELD_PSDELOGICID, (Object)pSDEGridLogicBase.getPSDELogicId());
        }
        if (pSDEGridLogicBase.isPSDELogicNameDirty() && (bl || pSDEGridLogicBase.getPSDELogicName() != null)) {
            iDataObject.set(FIELD_PSDELOGICNAME, (Object)pSDEGridLogicBase.getPSDELogicName());
        }
        if (pSDEGridLogicBase.isPSDENameDirty() && (bl || pSDEGridLogicBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDEGridLogicBase.getPSDEName());
        }
        if (pSDEGridLogicBase.isPSDEUIActionIdDirty() && (bl || pSDEGridLogicBase.getPSDEUIActionId() != null)) {
            iDataObject.set(FIELD_PSDEUIACTIONID, (Object)pSDEGridLogicBase.getPSDEUIActionId());
        }
        if (pSDEGridLogicBase.isPSDEUIActionNameDirty() && (bl || pSDEGridLogicBase.getPSDEUIActionName() != null)) {
            iDataObject.set(FIELD_PSDEUIACTIONNAME, (Object)pSDEGridLogicBase.getPSDEUIActionName());
        }
        if (pSDEGridLogicBase.isPSSysPFPluginIdDirty() && (bl || pSDEGridLogicBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSDEGridLogicBase.getPSSysPFPluginId());
        }
        if (pSDEGridLogicBase.isPSSysPFPluginNameDirty() && (bl || pSDEGridLogicBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSDEGridLogicBase.getPSSysPFPluginName());
        }
        if (pSDEGridLogicBase.isPSSysViewLogicIdDirty() && (bl || pSDEGridLogicBase.getPSSysViewLogicId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWLOGICID, (Object)pSDEGridLogicBase.getPSSysViewLogicId());
        }
        if (pSDEGridLogicBase.isPSSysViewLogicNameDirty() && (bl || pSDEGridLogicBase.getPSSysViewLogicName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWLOGICNAME, (Object)pSDEGridLogicBase.getPSSysViewLogicName());
        }
        if (pSDEGridLogicBase.isPSSysViewPanelIdDirty() && (bl || pSDEGridLogicBase.getPSSysViewPanelId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELID, (Object)pSDEGridLogicBase.getPSSysViewPanelId());
        }
        if (pSDEGridLogicBase.isPSSysViewPanelNameDirty() && (bl || pSDEGridLogicBase.getPSSysViewPanelName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELNAME, (Object)pSDEGridLogicBase.getPSSysViewPanelName());
        }
        if (pSDEGridLogicBase.isTimerDirty() && (bl || pSDEGridLogicBase.getTimer() != null)) {
            iDataObject.set(FIELD_TIMER, (Object)pSDEGridLogicBase.getTimer());
        }
        if (pSDEGridLogicBase.isTriggerTypeDirty() && (bl || pSDEGridLogicBase.getTriggerType() != null)) {
            iDataObject.set(FIELD_TRIGGERTYPE, (Object)pSDEGridLogicBase.getTriggerType());
        }
        if (pSDEGridLogicBase.isUpdateDateDirty() && (bl || pSDEGridLogicBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEGridLogicBase.getUpdateDate());
        }
        if (pSDEGridLogicBase.isUpdateManDirty() && (bl || pSDEGridLogicBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEGridLogicBase.getUpdateMan());
        }
        if (pSDEGridLogicBase.isUserCatDirty() && (bl || pSDEGridLogicBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEGridLogicBase.getUserCat());
        }
        if (pSDEGridLogicBase.isUserTagDirty() && (bl || pSDEGridLogicBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEGridLogicBase.getUserTag());
        }
        if (pSDEGridLogicBase.isUserTag2Dirty() && (bl || pSDEGridLogicBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEGridLogicBase.getUserTag2());
        }
        if (pSDEGridLogicBase.isUserTag3Dirty() && (bl || pSDEGridLogicBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEGridLogicBase.getUserTag3());
        }
        if (pSDEGridLogicBase.isUserTag4Dirty() && (bl || pSDEGridLogicBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEGridLogicBase.getUserTag4());
        }
        if (pSDEGridLogicBase.isValidFlagDirty() && (bl || pSDEGridLogicBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDEGridLogicBase.getValidFlag());
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
        return PSDEGridLogicBase.remove(this, n);
    }

    private static boolean remove(PSDEGridLogicBase pSDEGridLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEGridLogicBase.resetAttrName();
                return true;
            }
            case 1: {
                pSDEGridLogicBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDEGridLogicBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDEGridLogicBase.resetCustomCode();
                return true;
            }
            case 4: {
                pSDEGridLogicBase.resetDstLogicType();
                return true;
            }
            case 5: {
                pSDEGridLogicBase.resetEventArg();
                return true;
            }
            case 6: {
                pSDEGridLogicBase.resetEventArg2();
                return true;
            }
            case 7: {
                pSDEGridLogicBase.resetEventNames();
                return true;
            }
            case 8: {
                pSDEGridLogicBase.resetLogicParam();
                return true;
            }
            case 9: {
                pSDEGridLogicBase.resetLogicParam2();
                return true;
            }
            case 10: {
                pSDEGridLogicBase.resetMemo();
                return true;
            }
            case 11: {
                pSDEGridLogicBase.resetOrderValue();
                return true;
            }
            case 12: {
                pSDEGridLogicBase.resetPSDEGridColId();
                return true;
            }
            case 13: {
                pSDEGridLogicBase.resetPSDEGridColName();
                return true;
            }
            case 14: {
                pSDEGridLogicBase.resetPSDEGridId();
                return true;
            }
            case 15: {
                pSDEGridLogicBase.resetPSDEGridColLogicId();
                return true;
            }
            case 16: {
                pSDEGridLogicBase.resetPSDEGridColLogicName();
                return true;
            }
            case 17: {
                pSDEGridLogicBase.resetPSDEGridName();
                return true;
            }
            case 18: {
                pSDEGridLogicBase.resetPSDEId();
                return true;
            }
            case 19: {
                pSDEGridLogicBase.resetPSDELogicId();
                return true;
            }
            case 20: {
                pSDEGridLogicBase.resetPSDELogicName();
                return true;
            }
            case 21: {
                pSDEGridLogicBase.resetPSDEName();
                return true;
            }
            case 22: {
                pSDEGridLogicBase.resetPSDEUIActionId();
                return true;
            }
            case 23: {
                pSDEGridLogicBase.resetPSDEUIActionName();
                return true;
            }
            case 24: {
                pSDEGridLogicBase.resetPSSysPFPluginId();
                return true;
            }
            case 25: {
                pSDEGridLogicBase.resetPSSysPFPluginName();
                return true;
            }
            case 26: {
                pSDEGridLogicBase.resetPSSysViewLogicId();
                return true;
            }
            case 27: {
                pSDEGridLogicBase.resetPSSysViewLogicName();
                return true;
            }
            case 28: {
                pSDEGridLogicBase.resetPSSysViewPanelId();
                return true;
            }
            case 29: {
                pSDEGridLogicBase.resetPSSysViewPanelName();
                return true;
            }
            case 30: {
                pSDEGridLogicBase.resetTimer();
                return true;
            }
            case 31: {
                pSDEGridLogicBase.resetTriggerType();
                return true;
            }
            case 32: {
                pSDEGridLogicBase.resetUpdateDate();
                return true;
            }
            case 33: {
                pSDEGridLogicBase.resetUpdateMan();
                return true;
            }
            case 34: {
                pSDEGridLogicBase.resetUserCat();
                return true;
            }
            case 35: {
                pSDEGridLogicBase.resetUserTag();
                return true;
            }
            case 36: {
                pSDEGridLogicBase.resetUserTag2();
                return true;
            }
            case 37: {
                pSDEGridLogicBase.resetUserTag3();
                return true;
            }
            case 38: {
                pSDEGridLogicBase.resetUserTag4();
                return true;
            }
            case 39: {
                pSDEGridLogicBase.resetValidFlag();
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
    public PSDEGridCol getPSDEGridCol() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGridCol();
        }
        if (this.getPSDEGridColId() == null) {
            return null;
        }
        Integer n = this.objPSDEGridColLock;
        synchronized (n) {
            if (this.psdegridcol != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEGridColId(), (Object)this.psdegridcol.getPSDEGridColId()) != 0L) {
                this.psdegridcol = null;
            }
            if (this.psdegridcol == null) {
                PSDEGridCol pSDEGridCol = new PSDEGridCol();
                pSDEGridCol.setPSDEGridColId(this.getPSDEGridColId());
                PSDEGridColService pSDEGridColService = (PSDEGridColService)ServiceGlobal.getService(PSDEGridColService.class, (SessionFactory)this.getSessionFactory());
                pSDEGridColService.autoGet(pSDEGridCol);
                this.psdegridcol = pSDEGridCol;
            }
            return this.psdegridcol;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEGrid getPSDEGrid() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGrid();
        }
        if (this.getPSDEGridId() == null) {
            return null;
        }
        Integer n = this.objPSDEGridLock;
        synchronized (n) {
            if (this.psdegrid != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEGridId(), (Object)this.psdegrid.getPSDEGridId()) != 0L) {
                this.psdegrid = null;
            }
            if (this.psdegrid == null) {
                PSDEGrid pSDEGrid = new PSDEGrid();
                pSDEGrid.setPSDEGridId(this.getPSDEGridId());
                PSDEGridService pSDEGridService = (PSDEGridService)ServiceGlobal.getService(PSDEGridService.class, (SessionFactory)this.getSessionFactory());
                pSDEGridService.autoGet(pSDEGrid);
                this.psdegrid = pSDEGrid;
            }
            return this.psdegrid;
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

    private PSDEGridLogicBase getProxyEntity() {
        return this.proxyPSDEGridLogicBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEGridLogicBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEGridLogicBase) {
            this.proxyPSDEGridLogicBase = (PSDEGridLogicBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEGridLogicService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
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
        fieldIndexMap.put(FIELD_PSDEGRIDCOLID, 12);
        fieldIndexMap.put(FIELD_PSDEGRIDCOLNAME, 13);
        fieldIndexMap.put(FIELD_PSDEGRIDID, 14);
        fieldIndexMap.put(FIELD_PSDEGRIDCOLLOGICID, 15);
        fieldIndexMap.put(FIELD_PSDEGRIDCOLLOGICNAME, 16);
        fieldIndexMap.put(FIELD_PSDEGRIDNAME, 17);
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

