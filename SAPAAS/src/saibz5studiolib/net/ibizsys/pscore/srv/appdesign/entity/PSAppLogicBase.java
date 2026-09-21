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
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.service.PSSysPFPluginService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewLogic;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewLogicService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppLogicBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSAppLogicBase.class);
    public static final String FIELD_ATTRNAME = "ATTRNAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMCODE = "CUSTOMCODE";
    public static final String FIELD_DSTLOGICTYPE = "DSTLOGICTYPE";
    public static final String FIELD_EVENTARG = "EVENTARG";
    public static final String FIELD_EVENTARG2 = "EVENTARG2";
    public static final String FIELD_EVENTNAMES = "EVENTNAMES";
    public static final String FIELD_ITEMNAME = "ITEMNAME";
    public static final String FIELD_LOGICPARAM = "LOGICPARAM";
    public static final String FIELD_LOGICPARAM2 = "LOGICPARAM2";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSAPPLOGICID = "PSAPPLOGICID";
    public static final String FIELD_PSAPPLOGICNAME = "PSAPPLOGICNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDELOGICID = "PSDELOGICID";
    public static final String FIELD_PSDELOGICNAME = "PSDELOGICNAME";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDEUIACTIONID = "PSDEUIACTIONID";
    public static final String FIELD_PSDEUIACTIONNAME = "PSDEUIACTIONNAME";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String FIELD_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String FIELD_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String FIELD_PSSYSVIEWLOGICID = "PSSYSVIEWLOGICID";
    public static final String FIELD_PSSYSVIEWLOGICNAME = "PSSYSVIEWLOGICNAME";
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
    private static final int INDEX_ITEMNAME = 8;
    private static final int INDEX_LOGICPARAM = 9;
    private static final int INDEX_LOGICPARAM2 = 10;
    private static final int INDEX_MEMO = 11;
    private static final int INDEX_ORDERVALUE = 12;
    private static final int INDEX_PSAPPLOGICID = 13;
    private static final int INDEX_PSAPPLOGICNAME = 14;
    private static final int INDEX_PSDEID = 15;
    private static final int INDEX_PSDELOGICID = 16;
    private static final int INDEX_PSDELOGICNAME = 17;
    private static final int INDEX_PSDENAME = 18;
    private static final int INDEX_PSDEUIACTIONID = 19;
    private static final int INDEX_PSDEUIACTIONNAME = 20;
    private static final int INDEX_PSSYSAPPID = 21;
    private static final int INDEX_PSSYSAPPNAME = 22;
    private static final int INDEX_PSSYSPFPLUGINID = 23;
    private static final int INDEX_PSSYSPFPLUGINNAME = 24;
    private static final int INDEX_PSSYSVIEWLOGICID = 25;
    private static final int INDEX_PSSYSVIEWLOGICNAME = 26;
    private static final int INDEX_TIMER = 27;
    private static final int INDEX_TRIGGERTYPE = 28;
    private static final int INDEX_UPDATEDATE = 29;
    private static final int INDEX_UPDATEMAN = 30;
    private static final int INDEX_USERCAT = 31;
    private static final int INDEX_USERTAG = 32;
    private static final int INDEX_USERTAG2 = 33;
    private static final int INDEX_USERTAG3 = 34;
    private static final int INDEX_USERTAG4 = 35;
    private static final int INDEX_VALIDFLAG = 36;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSAppLogicBase proxyPSAppLogicBase = null;
    private boolean attrnameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customcodeDirtyFlag = false;
    private boolean dstlogictypeDirtyFlag = false;
    private boolean eventargDirtyFlag = false;
    private boolean eventarg2DirtyFlag = false;
    private boolean eventnamesDirtyFlag = false;
    private boolean itemnameDirtyFlag = false;
    private boolean logicparamDirtyFlag = false;
    private boolean logicparam2DirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psapplogicidDirtyFlag = false;
    private boolean psapplogicnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdelogicidDirtyFlag = false;
    private boolean psdelogicnameDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psdeuiactionidDirtyFlag = false;
    private boolean psdeuiactionnameDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean pssysappnameDirtyFlag = false;
    private boolean pssyspfpluginidDirtyFlag = false;
    private boolean pssyspfpluginnameDirtyFlag = false;
    private boolean pssysviewlogicidDirtyFlag = false;
    private boolean pssysviewlogicnameDirtyFlag = false;
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
    @Column(name="itemname")
    private String itemname;
    @Column(name="logicparam")
    private String logicparam;
    @Column(name="logicparam2")
    private String logicparam2;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psapplogicid")
    private String psapplogicid;
    @Column(name="psapplogicname")
    private String psapplogicname;
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
    @Column(name="pssysappid")
    private String pssysappid;
    @Column(name="pssysappname")
    private String pssysappname;
    @Column(name="pssyspfpluginid")
    private String pssyspfpluginid;
    @Column(name="pssyspfpluginname")
    private String pssyspfpluginname;
    @Column(name="pssysviewlogicid")
    private String pssysviewlogicid;
    @Column(name="pssysviewlogicname")
    private String pssysviewlogicname;
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
    private Integer objPSSysAppLock = new Integer(1);
    private PSSysApp pssysapp = null;
    private Integer objPSSysPFPluginLock = new Integer(1);
    private PSSysPFPlugin pssyspfplugin = null;
    private Integer objPSSysViewLogicLock = new Integer(1);
    private PSSysViewLogic pssysviewlogic = null;

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

    public void setItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.itemname = string;
        this.itemnameDirtyFlag = true;
    }

    public String getItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemName();
        }
        return this.itemname;
    }

    public boolean isItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemNameDirty();
        }
        return this.itemnameDirtyFlag;
    }

    public void resetItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemName();
            return;
        }
        this.itemnameDirtyFlag = false;
        this.itemname = null;
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

    public void setPSAppLogicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppLogicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psapplogicid = string;
        this.psapplogicidDirtyFlag = true;
    }

    public String getPSAppLogicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppLogicId();
        }
        return this.psapplogicid;
    }

    public boolean isPSAppLogicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppLogicIdDirty();
        }
        return this.psapplogicidDirtyFlag;
    }

    public void resetPSAppLogicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppLogicId();
            return;
        }
        this.psapplogicidDirtyFlag = false;
        this.psapplogicid = null;
    }

    public void setPSAppLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psapplogicname = string;
        this.psapplogicnameDirtyFlag = true;
    }

    public String getPSAppLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppLogicName();
        }
        return this.psapplogicname;
    }

    public boolean isPSAppLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppLogicNameDirty();
        }
        return this.psapplogicnameDirtyFlag;
    }

    public void resetPSAppLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppLogicName();
            return;
        }
        this.psapplogicnameDirtyFlag = false;
        this.psapplogicname = null;
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
        PSAppLogicBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSAppLogicBase pSAppLogicBase) {
        pSAppLogicBase.resetAttrName();
        pSAppLogicBase.resetCreateDate();
        pSAppLogicBase.resetCreateMan();
        pSAppLogicBase.resetCustomCode();
        pSAppLogicBase.resetDstLogicType();
        pSAppLogicBase.resetEventArg();
        pSAppLogicBase.resetEventArg2();
        pSAppLogicBase.resetEventNames();
        pSAppLogicBase.resetItemName();
        pSAppLogicBase.resetLogicParam();
        pSAppLogicBase.resetLogicParam2();
        pSAppLogicBase.resetMemo();
        pSAppLogicBase.resetOrderValue();
        pSAppLogicBase.resetPSAppLogicId();
        pSAppLogicBase.resetPSAppLogicName();
        pSAppLogicBase.resetPSDEId();
        pSAppLogicBase.resetPSDELogicId();
        pSAppLogicBase.resetPSDELogicName();
        pSAppLogicBase.resetPSDEName();
        pSAppLogicBase.resetPSDEUIActionId();
        pSAppLogicBase.resetPSDEUIActionName();
        pSAppLogicBase.resetPSSysAppId();
        pSAppLogicBase.resetPSSysAppName();
        pSAppLogicBase.resetPSSysPFPluginId();
        pSAppLogicBase.resetPSSysPFPluginName();
        pSAppLogicBase.resetPSSysViewLogicId();
        pSAppLogicBase.resetPSSysViewLogicName();
        pSAppLogicBase.resetTimer();
        pSAppLogicBase.resetTriggerType();
        pSAppLogicBase.resetUpdateDate();
        pSAppLogicBase.resetUpdateMan();
        pSAppLogicBase.resetUserCat();
        pSAppLogicBase.resetUserTag();
        pSAppLogicBase.resetUserTag2();
        pSAppLogicBase.resetUserTag3();
        pSAppLogicBase.resetUserTag4();
        pSAppLogicBase.resetValidFlag();
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
        if (!bl || this.isItemNameDirty()) {
            hashMap.put(FIELD_ITEMNAME, this.getItemName());
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
        if (!bl || this.isPSAppLogicIdDirty()) {
            hashMap.put(FIELD_PSAPPLOGICID, this.getPSAppLogicId());
        }
        if (!bl || this.isPSAppLogicNameDirty()) {
            hashMap.put(FIELD_PSAPPLOGICNAME, this.getPSAppLogicName());
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
        if (!bl || this.isPSSysAppIdDirty()) {
            hashMap.put(FIELD_PSSYSAPPID, this.getPSSysAppId());
        }
        if (!bl || this.isPSSysAppNameDirty()) {
            hashMap.put(FIELD_PSSYSAPPNAME, this.getPSSysAppName());
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
        return PSAppLogicBase.get(this, n);
    }

    private static Object get(PSAppLogicBase pSAppLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppLogicBase.getAttrName();
            }
            case 1: {
                return pSAppLogicBase.getCreateDate();
            }
            case 2: {
                return pSAppLogicBase.getCreateMan();
            }
            case 3: {
                return pSAppLogicBase.getCustomCode();
            }
            case 4: {
                return pSAppLogicBase.getDstLogicType();
            }
            case 5: {
                return pSAppLogicBase.getEventArg();
            }
            case 6: {
                return pSAppLogicBase.getEventArg2();
            }
            case 7: {
                return pSAppLogicBase.getEventNames();
            }
            case 8: {
                return pSAppLogicBase.getItemName();
            }
            case 9: {
                return pSAppLogicBase.getLogicParam();
            }
            case 10: {
                return pSAppLogicBase.getLogicParam2();
            }
            case 11: {
                return pSAppLogicBase.getMemo();
            }
            case 12: {
                return pSAppLogicBase.getOrderValue();
            }
            case 13: {
                return pSAppLogicBase.getPSAppLogicId();
            }
            case 14: {
                return pSAppLogicBase.getPSAppLogicName();
            }
            case 15: {
                return pSAppLogicBase.getPSDEId();
            }
            case 16: {
                return pSAppLogicBase.getPSDELogicId();
            }
            case 17: {
                return pSAppLogicBase.getPSDELogicName();
            }
            case 18: {
                return pSAppLogicBase.getPSDEName();
            }
            case 19: {
                return pSAppLogicBase.getPSDEUIActionId();
            }
            case 20: {
                return pSAppLogicBase.getPSDEUIActionName();
            }
            case 21: {
                return pSAppLogicBase.getPSSysAppId();
            }
            case 22: {
                return pSAppLogicBase.getPSSysAppName();
            }
            case 23: {
                return pSAppLogicBase.getPSSysPFPluginId();
            }
            case 24: {
                return pSAppLogicBase.getPSSysPFPluginName();
            }
            case 25: {
                return pSAppLogicBase.getPSSysViewLogicId();
            }
            case 26: {
                return pSAppLogicBase.getPSSysViewLogicName();
            }
            case 27: {
                return pSAppLogicBase.getTimer();
            }
            case 28: {
                return pSAppLogicBase.getTriggerType();
            }
            case 29: {
                return pSAppLogicBase.getUpdateDate();
            }
            case 30: {
                return pSAppLogicBase.getUpdateMan();
            }
            case 31: {
                return pSAppLogicBase.getUserCat();
            }
            case 32: {
                return pSAppLogicBase.getUserTag();
            }
            case 33: {
                return pSAppLogicBase.getUserTag2();
            }
            case 34: {
                return pSAppLogicBase.getUserTag3();
            }
            case 35: {
                return pSAppLogicBase.getUserTag4();
            }
            case 36: {
                return pSAppLogicBase.getValidFlag();
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
        PSAppLogicBase.set(this, n, object);
    }

    private static void set(PSAppLogicBase pSAppLogicBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSAppLogicBase.setAttrName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSAppLogicBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSAppLogicBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSAppLogicBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSAppLogicBase.setDstLogicType(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSAppLogicBase.setEventArg(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSAppLogicBase.setEventArg2(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSAppLogicBase.setEventNames(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSAppLogicBase.setItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSAppLogicBase.setLogicParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSAppLogicBase.setLogicParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSAppLogicBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSAppLogicBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSAppLogicBase.setPSAppLogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSAppLogicBase.setPSAppLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSAppLogicBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSAppLogicBase.setPSDELogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSAppLogicBase.setPSDELogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSAppLogicBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSAppLogicBase.setPSDEUIActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSAppLogicBase.setPSDEUIActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSAppLogicBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSAppLogicBase.setPSSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSAppLogicBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSAppLogicBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSAppLogicBase.setPSSysViewLogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSAppLogicBase.setPSSysViewLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSAppLogicBase.setTimer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 28: {
                pSAppLogicBase.setTriggerType(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSAppLogicBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 30: {
                pSAppLogicBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSAppLogicBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSAppLogicBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSAppLogicBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSAppLogicBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSAppLogicBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSAppLogicBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSAppLogicBase.isNull(this, n);
    }

    private static boolean isNull(PSAppLogicBase pSAppLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppLogicBase.getAttrName() == null;
            }
            case 1: {
                return pSAppLogicBase.getCreateDate() == null;
            }
            case 2: {
                return pSAppLogicBase.getCreateMan() == null;
            }
            case 3: {
                return pSAppLogicBase.getCustomCode() == null;
            }
            case 4: {
                return pSAppLogicBase.getDstLogicType() == null;
            }
            case 5: {
                return pSAppLogicBase.getEventArg() == null;
            }
            case 6: {
                return pSAppLogicBase.getEventArg2() == null;
            }
            case 7: {
                return pSAppLogicBase.getEventNames() == null;
            }
            case 8: {
                return pSAppLogicBase.getItemName() == null;
            }
            case 9: {
                return pSAppLogicBase.getLogicParam() == null;
            }
            case 10: {
                return pSAppLogicBase.getLogicParam2() == null;
            }
            case 11: {
                return pSAppLogicBase.getMemo() == null;
            }
            case 12: {
                return pSAppLogicBase.getOrderValue() == null;
            }
            case 13: {
                return pSAppLogicBase.getPSAppLogicId() == null;
            }
            case 14: {
                return pSAppLogicBase.getPSAppLogicName() == null;
            }
            case 15: {
                return pSAppLogicBase.getPSDEId() == null;
            }
            case 16: {
                return pSAppLogicBase.getPSDELogicId() == null;
            }
            case 17: {
                return pSAppLogicBase.getPSDELogicName() == null;
            }
            case 18: {
                return pSAppLogicBase.getPSDEName() == null;
            }
            case 19: {
                return pSAppLogicBase.getPSDEUIActionId() == null;
            }
            case 20: {
                return pSAppLogicBase.getPSDEUIActionName() == null;
            }
            case 21: {
                return pSAppLogicBase.getPSSysAppId() == null;
            }
            case 22: {
                return pSAppLogicBase.getPSSysAppName() == null;
            }
            case 23: {
                return pSAppLogicBase.getPSSysPFPluginId() == null;
            }
            case 24: {
                return pSAppLogicBase.getPSSysPFPluginName() == null;
            }
            case 25: {
                return pSAppLogicBase.getPSSysViewLogicId() == null;
            }
            case 26: {
                return pSAppLogicBase.getPSSysViewLogicName() == null;
            }
            case 27: {
                return pSAppLogicBase.getTimer() == null;
            }
            case 28: {
                return pSAppLogicBase.getTriggerType() == null;
            }
            case 29: {
                return pSAppLogicBase.getUpdateDate() == null;
            }
            case 30: {
                return pSAppLogicBase.getUpdateMan() == null;
            }
            case 31: {
                return pSAppLogicBase.getUserCat() == null;
            }
            case 32: {
                return pSAppLogicBase.getUserTag() == null;
            }
            case 33: {
                return pSAppLogicBase.getUserTag2() == null;
            }
            case 34: {
                return pSAppLogicBase.getUserTag3() == null;
            }
            case 35: {
                return pSAppLogicBase.getUserTag4() == null;
            }
            case 36: {
                return pSAppLogicBase.getValidFlag() == null;
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
        return PSAppLogicBase.contains(this, n);
    }

    private static boolean contains(PSAppLogicBase pSAppLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppLogicBase.isAttrNameDirty();
            }
            case 1: {
                return pSAppLogicBase.isCreateDateDirty();
            }
            case 2: {
                return pSAppLogicBase.isCreateManDirty();
            }
            case 3: {
                return pSAppLogicBase.isCustomCodeDirty();
            }
            case 4: {
                return pSAppLogicBase.isDstLogicTypeDirty();
            }
            case 5: {
                return pSAppLogicBase.isEventArgDirty();
            }
            case 6: {
                return pSAppLogicBase.isEventArg2Dirty();
            }
            case 7: {
                return pSAppLogicBase.isEventNamesDirty();
            }
            case 8: {
                return pSAppLogicBase.isItemNameDirty();
            }
            case 9: {
                return pSAppLogicBase.isLogicParamDirty();
            }
            case 10: {
                return pSAppLogicBase.isLogicParam2Dirty();
            }
            case 11: {
                return pSAppLogicBase.isMemoDirty();
            }
            case 12: {
                return pSAppLogicBase.isOrderValueDirty();
            }
            case 13: {
                return pSAppLogicBase.isPSAppLogicIdDirty();
            }
            case 14: {
                return pSAppLogicBase.isPSAppLogicNameDirty();
            }
            case 15: {
                return pSAppLogicBase.isPSDEIdDirty();
            }
            case 16: {
                return pSAppLogicBase.isPSDELogicIdDirty();
            }
            case 17: {
                return pSAppLogicBase.isPSDELogicNameDirty();
            }
            case 18: {
                return pSAppLogicBase.isPSDENameDirty();
            }
            case 19: {
                return pSAppLogicBase.isPSDEUIActionIdDirty();
            }
            case 20: {
                return pSAppLogicBase.isPSDEUIActionNameDirty();
            }
            case 21: {
                return pSAppLogicBase.isPSSysAppIdDirty();
            }
            case 22: {
                return pSAppLogicBase.isPSSysAppNameDirty();
            }
            case 23: {
                return pSAppLogicBase.isPSSysPFPluginIdDirty();
            }
            case 24: {
                return pSAppLogicBase.isPSSysPFPluginNameDirty();
            }
            case 25: {
                return pSAppLogicBase.isPSSysViewLogicIdDirty();
            }
            case 26: {
                return pSAppLogicBase.isPSSysViewLogicNameDirty();
            }
            case 27: {
                return pSAppLogicBase.isTimerDirty();
            }
            case 28: {
                return pSAppLogicBase.isTriggerTypeDirty();
            }
            case 29: {
                return pSAppLogicBase.isUpdateDateDirty();
            }
            case 30: {
                return pSAppLogicBase.isUpdateManDirty();
            }
            case 31: {
                return pSAppLogicBase.isUserCatDirty();
            }
            case 32: {
                return pSAppLogicBase.isUserTagDirty();
            }
            case 33: {
                return pSAppLogicBase.isUserTag2Dirty();
            }
            case 34: {
                return pSAppLogicBase.isUserTag3Dirty();
            }
            case 35: {
                return pSAppLogicBase.isUserTag4Dirty();
            }
            case 36: {
                return pSAppLogicBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSAppLogicBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSAppLogicBase pSAppLogicBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSAppLogicBase.getAttrName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"attrname", (Object)PSAppLogicBase.getJSONValue((Object)pSAppLogicBase.getAttrName()), (boolean)false);
        }
        if (bl || pSAppLogicBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSAppLogicBase.getJSONValue((Object)pSAppLogicBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSAppLogicBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSAppLogicBase.getJSONValue((Object)pSAppLogicBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSAppLogicBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSAppLogicBase.getJSONValue((Object)pSAppLogicBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSAppLogicBase.getDstLogicType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstlogictype", (Object)PSAppLogicBase.getJSONValue((Object)pSAppLogicBase.getDstLogicType()), (boolean)false);
        }
        if (bl || pSAppLogicBase.getEventArg() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eventarg", (Object)PSAppLogicBase.getJSONValue((Object)pSAppLogicBase.getEventArg()), (boolean)false);
        }
        if (bl || pSAppLogicBase.getEventArg2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eventarg2", (Object)PSAppLogicBase.getJSONValue((Object)pSAppLogicBase.getEventArg2()), (boolean)false);
        }
        if (bl || pSAppLogicBase.getEventNames() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eventnames", (Object)PSAppLogicBase.getJSONValue((Object)pSAppLogicBase.getEventNames()), (boolean)false);
        }
        if (bl || pSAppLogicBase.getItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemname", (Object)PSAppLogicBase.getJSONValue((Object)pSAppLogicBase.getItemName()), (boolean)false);
        }
        if (bl || pSAppLogicBase.getLogicParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicparam", (Object)PSAppLogicBase.getJSONValue((Object)pSAppLogicBase.getLogicParam()), (boolean)false);
        }
        if (bl || pSAppLogicBase.getLogicParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicparam2", (Object)PSAppLogicBase.getJSONValue((Object)pSAppLogicBase.getLogicParam2()), (boolean)false);
        }
        if (bl || pSAppLogicBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSAppLogicBase.getJSONValue((Object)pSAppLogicBase.getMemo()), (boolean)false);
        }
        if (bl || pSAppLogicBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSAppLogicBase.getJSONValue((Object)pSAppLogicBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSAppLogicBase.getPSAppLogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psapplogicid", (Object)PSAppLogicBase.getJSONValue((Object)pSAppLogicBase.getPSAppLogicId()), (boolean)false);
        }
        if (bl || pSAppLogicBase.getPSAppLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psapplogicname", (Object)PSAppLogicBase.getJSONValue((Object)pSAppLogicBase.getPSAppLogicName()), (boolean)false);
        }
        if (bl || pSAppLogicBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSAppLogicBase.getJSONValue((Object)pSAppLogicBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSAppLogicBase.getPSDELogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicid", (Object)PSAppLogicBase.getJSONValue((Object)pSAppLogicBase.getPSDELogicId()), (boolean)false);
        }
        if (bl || pSAppLogicBase.getPSDELogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicname", (Object)PSAppLogicBase.getJSONValue((Object)pSAppLogicBase.getPSDELogicName()), (boolean)false);
        }
        if (bl || pSAppLogicBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSAppLogicBase.getJSONValue((Object)pSAppLogicBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSAppLogicBase.getPSDEUIActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuiactionid", (Object)PSAppLogicBase.getJSONValue((Object)pSAppLogicBase.getPSDEUIActionId()), (boolean)false);
        }
        if (bl || pSAppLogicBase.getPSDEUIActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuiactionname", (Object)PSAppLogicBase.getJSONValue((Object)pSAppLogicBase.getPSDEUIActionName()), (boolean)false);
        }
        if (bl || pSAppLogicBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSAppLogicBase.getJSONValue((Object)pSAppLogicBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSAppLogicBase.getPSSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappname", (Object)PSAppLogicBase.getJSONValue((Object)pSAppLogicBase.getPSSysAppName()), (boolean)false);
        }
        if (bl || pSAppLogicBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSAppLogicBase.getJSONValue((Object)pSAppLogicBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSAppLogicBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSAppLogicBase.getJSONValue((Object)pSAppLogicBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSAppLogicBase.getPSSysViewLogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewlogicid", (Object)PSAppLogicBase.getJSONValue((Object)pSAppLogicBase.getPSSysViewLogicId()), (boolean)false);
        }
        if (bl || pSAppLogicBase.getPSSysViewLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewlogicname", (Object)PSAppLogicBase.getJSONValue((Object)pSAppLogicBase.getPSSysViewLogicName()), (boolean)false);
        }
        if (bl || pSAppLogicBase.getTimer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"timer", (Object)PSAppLogicBase.getJSONValue((Object)pSAppLogicBase.getTimer()), (boolean)false);
        }
        if (bl || pSAppLogicBase.getTriggerType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"triggertype", (Object)PSAppLogicBase.getJSONValue((Object)pSAppLogicBase.getTriggerType()), (boolean)false);
        }
        if (bl || pSAppLogicBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSAppLogicBase.getJSONValue((Object)pSAppLogicBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSAppLogicBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSAppLogicBase.getJSONValue((Object)pSAppLogicBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSAppLogicBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSAppLogicBase.getJSONValue((Object)pSAppLogicBase.getUserCat()), (boolean)false);
        }
        if (bl || pSAppLogicBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSAppLogicBase.getJSONValue((Object)pSAppLogicBase.getUserTag()), (boolean)false);
        }
        if (bl || pSAppLogicBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSAppLogicBase.getJSONValue((Object)pSAppLogicBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSAppLogicBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSAppLogicBase.getJSONValue((Object)pSAppLogicBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSAppLogicBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSAppLogicBase.getJSONValue((Object)pSAppLogicBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSAppLogicBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSAppLogicBase.getJSONValue((Object)pSAppLogicBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSAppLogicBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSAppLogicBase pSAppLogicBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSAppLogicBase.getAttrName() != null) {
            object = pSAppLogicBase.getAttrName();
            xmlNode.setAttribute(FIELD_ATTRNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppLogicBase.getCreateDate() != null) {
            object = pSAppLogicBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppLogicBase.getCreateMan() != null) {
            object = pSAppLogicBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppLogicBase.getCustomCode() != null) {
            object = pSAppLogicBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSAppLogicBase.getDstLogicType() != null) {
            object = pSAppLogicBase.getDstLogicType();
            xmlNode.setAttribute(FIELD_DSTLOGICTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSAppLogicBase.getEventArg() != null) {
            object = pSAppLogicBase.getEventArg();
            xmlNode.setAttribute(FIELD_EVENTARG, object == null ? "" : (String)object);
        }
        if (bl || pSAppLogicBase.getEventArg2() != null) {
            object = pSAppLogicBase.getEventArg2();
            xmlNode.setAttribute(FIELD_EVENTARG2, object == null ? "" : (String)object);
        }
        if (bl || pSAppLogicBase.getEventNames() != null) {
            object = pSAppLogicBase.getEventNames();
            xmlNode.setAttribute(FIELD_EVENTNAMES, object == null ? "" : (String)object);
        }
        if (bl || pSAppLogicBase.getItemName() != null) {
            object = pSAppLogicBase.getItemName();
            xmlNode.setAttribute(FIELD_ITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppLogicBase.getLogicParam() != null) {
            object = pSAppLogicBase.getLogicParam();
            xmlNode.setAttribute(FIELD_LOGICPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSAppLogicBase.getLogicParam2() != null) {
            object = pSAppLogicBase.getLogicParam2();
            xmlNode.setAttribute(FIELD_LOGICPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSAppLogicBase.getMemo() != null) {
            object = pSAppLogicBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSAppLogicBase.getOrderValue() != null) {
            object = pSAppLogicBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppLogicBase.getPSAppLogicId() != null) {
            object = pSAppLogicBase.getPSAppLogicId();
            xmlNode.setAttribute(FIELD_PSAPPLOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSAppLogicBase.getPSAppLogicName() != null) {
            object = pSAppLogicBase.getPSAppLogicName();
            xmlNode.setAttribute(FIELD_PSAPPLOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppLogicBase.getPSDEId() != null) {
            object = pSAppLogicBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSAppLogicBase.getPSDELogicId() != null) {
            object = pSAppLogicBase.getPSDELogicId();
            xmlNode.setAttribute(FIELD_PSDELOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSAppLogicBase.getPSDELogicName() != null) {
            object = pSAppLogicBase.getPSDELogicName();
            xmlNode.setAttribute(FIELD_PSDELOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppLogicBase.getPSDEName() != null) {
            object = pSAppLogicBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppLogicBase.getPSDEUIActionId() != null) {
            object = pSAppLogicBase.getPSDEUIActionId();
            xmlNode.setAttribute(FIELD_PSDEUIACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSAppLogicBase.getPSDEUIActionName() != null) {
            object = pSAppLogicBase.getPSDEUIActionName();
            xmlNode.setAttribute(FIELD_PSDEUIACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppLogicBase.getPSSysAppId() != null) {
            object = pSAppLogicBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSAppLogicBase.getPSSysAppName() != null) {
            object = pSAppLogicBase.getPSSysAppName();
            xmlNode.setAttribute(FIELD_PSSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppLogicBase.getPSSysPFPluginId() != null) {
            object = pSAppLogicBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSAppLogicBase.getPSSysPFPluginName() != null) {
            object = pSAppLogicBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppLogicBase.getPSSysViewLogicId() != null) {
            object = pSAppLogicBase.getPSSysViewLogicId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWLOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSAppLogicBase.getPSSysViewLogicName() != null) {
            object = pSAppLogicBase.getPSSysViewLogicName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWLOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppLogicBase.getTimer() != null) {
            object = pSAppLogicBase.getTimer();
            xmlNode.setAttribute(FIELD_TIMER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppLogicBase.getTriggerType() != null) {
            object = pSAppLogicBase.getTriggerType();
            xmlNode.setAttribute(FIELD_TRIGGERTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSAppLogicBase.getUpdateDate() != null) {
            object = pSAppLogicBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppLogicBase.getUpdateMan() != null) {
            object = pSAppLogicBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppLogicBase.getUserCat() != null) {
            object = pSAppLogicBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSAppLogicBase.getUserTag() != null) {
            object = pSAppLogicBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSAppLogicBase.getUserTag2() != null) {
            object = pSAppLogicBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSAppLogicBase.getUserTag3() != null) {
            object = pSAppLogicBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSAppLogicBase.getUserTag4() != null) {
            object = pSAppLogicBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSAppLogicBase.getValidFlag() != null) {
            object = pSAppLogicBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSAppLogicBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSAppLogicBase pSAppLogicBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSAppLogicBase.isAttrNameDirty() && (bl || pSAppLogicBase.getAttrName() != null)) {
            iDataObject.set(FIELD_ATTRNAME, (Object)pSAppLogicBase.getAttrName());
        }
        if (pSAppLogicBase.isCreateDateDirty() && (bl || pSAppLogicBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSAppLogicBase.getCreateDate());
        }
        if (pSAppLogicBase.isCreateManDirty() && (bl || pSAppLogicBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSAppLogicBase.getCreateMan());
        }
        if (pSAppLogicBase.isCustomCodeDirty() && (bl || pSAppLogicBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSAppLogicBase.getCustomCode());
        }
        if (pSAppLogicBase.isDstLogicTypeDirty() && (bl || pSAppLogicBase.getDstLogicType() != null)) {
            iDataObject.set(FIELD_DSTLOGICTYPE, (Object)pSAppLogicBase.getDstLogicType());
        }
        if (pSAppLogicBase.isEventArgDirty() && (bl || pSAppLogicBase.getEventArg() != null)) {
            iDataObject.set(FIELD_EVENTARG, (Object)pSAppLogicBase.getEventArg());
        }
        if (pSAppLogicBase.isEventArg2Dirty() && (bl || pSAppLogicBase.getEventArg2() != null)) {
            iDataObject.set(FIELD_EVENTARG2, (Object)pSAppLogicBase.getEventArg2());
        }
        if (pSAppLogicBase.isEventNamesDirty() && (bl || pSAppLogicBase.getEventNames() != null)) {
            iDataObject.set(FIELD_EVENTNAMES, (Object)pSAppLogicBase.getEventNames());
        }
        if (pSAppLogicBase.isItemNameDirty() && (bl || pSAppLogicBase.getItemName() != null)) {
            iDataObject.set(FIELD_ITEMNAME, (Object)pSAppLogicBase.getItemName());
        }
        if (pSAppLogicBase.isLogicParamDirty() && (bl || pSAppLogicBase.getLogicParam() != null)) {
            iDataObject.set(FIELD_LOGICPARAM, (Object)pSAppLogicBase.getLogicParam());
        }
        if (pSAppLogicBase.isLogicParam2Dirty() && (bl || pSAppLogicBase.getLogicParam2() != null)) {
            iDataObject.set(FIELD_LOGICPARAM2, (Object)pSAppLogicBase.getLogicParam2());
        }
        if (pSAppLogicBase.isMemoDirty() && (bl || pSAppLogicBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSAppLogicBase.getMemo());
        }
        if (pSAppLogicBase.isOrderValueDirty() && (bl || pSAppLogicBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSAppLogicBase.getOrderValue());
        }
        if (pSAppLogicBase.isPSAppLogicIdDirty() && (bl || pSAppLogicBase.getPSAppLogicId() != null)) {
            iDataObject.set(FIELD_PSAPPLOGICID, (Object)pSAppLogicBase.getPSAppLogicId());
        }
        if (pSAppLogicBase.isPSAppLogicNameDirty() && (bl || pSAppLogicBase.getPSAppLogicName() != null)) {
            iDataObject.set(FIELD_PSAPPLOGICNAME, (Object)pSAppLogicBase.getPSAppLogicName());
        }
        if (pSAppLogicBase.isPSDEIdDirty() && (bl || pSAppLogicBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSAppLogicBase.getPSDEId());
        }
        if (pSAppLogicBase.isPSDELogicIdDirty() && (bl || pSAppLogicBase.getPSDELogicId() != null)) {
            iDataObject.set(FIELD_PSDELOGICID, (Object)pSAppLogicBase.getPSDELogicId());
        }
        if (pSAppLogicBase.isPSDELogicNameDirty() && (bl || pSAppLogicBase.getPSDELogicName() != null)) {
            iDataObject.set(FIELD_PSDELOGICNAME, (Object)pSAppLogicBase.getPSDELogicName());
        }
        if (pSAppLogicBase.isPSDENameDirty() && (bl || pSAppLogicBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSAppLogicBase.getPSDEName());
        }
        if (pSAppLogicBase.isPSDEUIActionIdDirty() && (bl || pSAppLogicBase.getPSDEUIActionId() != null)) {
            iDataObject.set(FIELD_PSDEUIACTIONID, (Object)pSAppLogicBase.getPSDEUIActionId());
        }
        if (pSAppLogicBase.isPSDEUIActionNameDirty() && (bl || pSAppLogicBase.getPSDEUIActionName() != null)) {
            iDataObject.set(FIELD_PSDEUIACTIONNAME, (Object)pSAppLogicBase.getPSDEUIActionName());
        }
        if (pSAppLogicBase.isPSSysAppIdDirty() && (bl || pSAppLogicBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSAppLogicBase.getPSSysAppId());
        }
        if (pSAppLogicBase.isPSSysAppNameDirty() && (bl || pSAppLogicBase.getPSSysAppName() != null)) {
            iDataObject.set(FIELD_PSSYSAPPNAME, (Object)pSAppLogicBase.getPSSysAppName());
        }
        if (pSAppLogicBase.isPSSysPFPluginIdDirty() && (bl || pSAppLogicBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSAppLogicBase.getPSSysPFPluginId());
        }
        if (pSAppLogicBase.isPSSysPFPluginNameDirty() && (bl || pSAppLogicBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSAppLogicBase.getPSSysPFPluginName());
        }
        if (pSAppLogicBase.isPSSysViewLogicIdDirty() && (bl || pSAppLogicBase.getPSSysViewLogicId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWLOGICID, (Object)pSAppLogicBase.getPSSysViewLogicId());
        }
        if (pSAppLogicBase.isPSSysViewLogicNameDirty() && (bl || pSAppLogicBase.getPSSysViewLogicName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWLOGICNAME, (Object)pSAppLogicBase.getPSSysViewLogicName());
        }
        if (pSAppLogicBase.isTimerDirty() && (bl || pSAppLogicBase.getTimer() != null)) {
            iDataObject.set(FIELD_TIMER, (Object)pSAppLogicBase.getTimer());
        }
        if (pSAppLogicBase.isTriggerTypeDirty() && (bl || pSAppLogicBase.getTriggerType() != null)) {
            iDataObject.set(FIELD_TRIGGERTYPE, (Object)pSAppLogicBase.getTriggerType());
        }
        if (pSAppLogicBase.isUpdateDateDirty() && (bl || pSAppLogicBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSAppLogicBase.getUpdateDate());
        }
        if (pSAppLogicBase.isUpdateManDirty() && (bl || pSAppLogicBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSAppLogicBase.getUpdateMan());
        }
        if (pSAppLogicBase.isUserCatDirty() && (bl || pSAppLogicBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSAppLogicBase.getUserCat());
        }
        if (pSAppLogicBase.isUserTagDirty() && (bl || pSAppLogicBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSAppLogicBase.getUserTag());
        }
        if (pSAppLogicBase.isUserTag2Dirty() && (bl || pSAppLogicBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSAppLogicBase.getUserTag2());
        }
        if (pSAppLogicBase.isUserTag3Dirty() && (bl || pSAppLogicBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSAppLogicBase.getUserTag3());
        }
        if (pSAppLogicBase.isUserTag4Dirty() && (bl || pSAppLogicBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSAppLogicBase.getUserTag4());
        }
        if (pSAppLogicBase.isValidFlagDirty() && (bl || pSAppLogicBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSAppLogicBase.getValidFlag());
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
        return PSAppLogicBase.remove(this, n);
    }

    private static boolean remove(PSAppLogicBase pSAppLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSAppLogicBase.resetAttrName();
                return true;
            }
            case 1: {
                pSAppLogicBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSAppLogicBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSAppLogicBase.resetCustomCode();
                return true;
            }
            case 4: {
                pSAppLogicBase.resetDstLogicType();
                return true;
            }
            case 5: {
                pSAppLogicBase.resetEventArg();
                return true;
            }
            case 6: {
                pSAppLogicBase.resetEventArg2();
                return true;
            }
            case 7: {
                pSAppLogicBase.resetEventNames();
                return true;
            }
            case 8: {
                pSAppLogicBase.resetItemName();
                return true;
            }
            case 9: {
                pSAppLogicBase.resetLogicParam();
                return true;
            }
            case 10: {
                pSAppLogicBase.resetLogicParam2();
                return true;
            }
            case 11: {
                pSAppLogicBase.resetMemo();
                return true;
            }
            case 12: {
                pSAppLogicBase.resetOrderValue();
                return true;
            }
            case 13: {
                pSAppLogicBase.resetPSAppLogicId();
                return true;
            }
            case 14: {
                pSAppLogicBase.resetPSAppLogicName();
                return true;
            }
            case 15: {
                pSAppLogicBase.resetPSDEId();
                return true;
            }
            case 16: {
                pSAppLogicBase.resetPSDELogicId();
                return true;
            }
            case 17: {
                pSAppLogicBase.resetPSDELogicName();
                return true;
            }
            case 18: {
                pSAppLogicBase.resetPSDEName();
                return true;
            }
            case 19: {
                pSAppLogicBase.resetPSDEUIActionId();
                return true;
            }
            case 20: {
                pSAppLogicBase.resetPSDEUIActionName();
                return true;
            }
            case 21: {
                pSAppLogicBase.resetPSSysAppId();
                return true;
            }
            case 22: {
                pSAppLogicBase.resetPSSysAppName();
                return true;
            }
            case 23: {
                pSAppLogicBase.resetPSSysPFPluginId();
                return true;
            }
            case 24: {
                pSAppLogicBase.resetPSSysPFPluginName();
                return true;
            }
            case 25: {
                pSAppLogicBase.resetPSSysViewLogicId();
                return true;
            }
            case 26: {
                pSAppLogicBase.resetPSSysViewLogicName();
                return true;
            }
            case 27: {
                pSAppLogicBase.resetTimer();
                return true;
            }
            case 28: {
                pSAppLogicBase.resetTriggerType();
                return true;
            }
            case 29: {
                pSAppLogicBase.resetUpdateDate();
                return true;
            }
            case 30: {
                pSAppLogicBase.resetUpdateMan();
                return true;
            }
            case 31: {
                pSAppLogicBase.resetUserCat();
                return true;
            }
            case 32: {
                pSAppLogicBase.resetUserTag();
                return true;
            }
            case 33: {
                pSAppLogicBase.resetUserTag2();
                return true;
            }
            case 34: {
                pSAppLogicBase.resetUserTag3();
                return true;
            }
            case 35: {
                pSAppLogicBase.resetUserTag4();
                return true;
            }
            case 36: {
                pSAppLogicBase.resetValidFlag();
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
                pSSysAppService.autoGet((IEntity)pSSysApp);
                this.pssysapp = pSSysApp;
            }
            return this.pssysapp;
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

    private PSAppLogicBase getProxyEntity() {
        return this.proxyPSAppLogicBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSAppLogicBase = null;
        if (iDataObject != null && iDataObject instanceof PSAppLogicBase) {
            this.proxyPSAppLogicBase = (PSAppLogicBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppLogicService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
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
        fieldIndexMap.put(FIELD_ITEMNAME, 8);
        fieldIndexMap.put(FIELD_LOGICPARAM, 9);
        fieldIndexMap.put(FIELD_LOGICPARAM2, 10);
        fieldIndexMap.put(FIELD_MEMO, 11);
        fieldIndexMap.put(FIELD_ORDERVALUE, 12);
        fieldIndexMap.put(FIELD_PSAPPLOGICID, 13);
        fieldIndexMap.put(FIELD_PSAPPLOGICNAME, 14);
        fieldIndexMap.put(FIELD_PSDEID, 15);
        fieldIndexMap.put(FIELD_PSDELOGICID, 16);
        fieldIndexMap.put(FIELD_PSDELOGICNAME, 17);
        fieldIndexMap.put(FIELD_PSDENAME, 18);
        fieldIndexMap.put(FIELD_PSDEUIACTIONID, 19);
        fieldIndexMap.put(FIELD_PSDEUIACTIONNAME, 20);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 21);
        fieldIndexMap.put(FIELD_PSSYSAPPNAME, 22);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINID, 23);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINNAME, 24);
        fieldIndexMap.put(FIELD_PSSYSVIEWLOGICID, 25);
        fieldIndexMap.put(FIELD_PSSYSVIEWLOGICNAME, 26);
        fieldIndexMap.put(FIELD_TIMER, 27);
        fieldIndexMap.put(FIELD_TRIGGERTYPE, 28);
        fieldIndexMap.put(FIELD_UPDATEDATE, 29);
        fieldIndexMap.put(FIELD_UPDATEMAN, 30);
        fieldIndexMap.put(FIELD_USERCAT, 31);
        fieldIndexMap.put(FIELD_USERTAG, 32);
        fieldIndexMap.put(FIELD_USERTAG2, 33);
        fieldIndexMap.put(FIELD_USERTAG3, 34);
        fieldIndexMap.put(FIELD_USERTAG4, 35);
        fieldIndexMap.put(FIELD_VALIDFLAG, 36);
    }
}

