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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSearchBar;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSearchBarItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewLogic;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanel;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSearchBarItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSearchBarService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewLogicService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysSearchBarLogicBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysSearchBarLogicBase.class);
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
    public static final String FIELD_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String FIELD_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String FIELD_PSSYSSEARCHBARID = "PSSYSSEARCHBARID";
    public static final String FIELD_PSSYSSEARCHBARITEMID = "PSSYSSEARCHBARITEMID";
    public static final String FIELD_PSSYSSEARCHBARITEMNAME = "PSSYSSEARCHBARITEMNAME";
    public static final String FIELD_PSSYSSEARCHBARLOGICID = "PSSYSSEARCHBARLOGICID";
    public static final String FIELD_PSSYSSEARCHBARLOGICNAME = "PSSYSSEARCHBARLOGICNAME";
    public static final String FIELD_PSSYSSEARCHBARNAME = "PSSYSSEARCHBARNAME";
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
    private static final int INDEX_PSSYSPFPLUGINID = 18;
    private static final int INDEX_PSSYSPFPLUGINNAME = 19;
    private static final int INDEX_PSSYSSEARCHBARID = 20;
    private static final int INDEX_PSSYSSEARCHBARITEMID = 21;
    private static final int INDEX_PSSYSSEARCHBARITEMNAME = 22;
    private static final int INDEX_PSSYSSEARCHBARLOGICID = 23;
    private static final int INDEX_PSSYSSEARCHBARLOGICNAME = 24;
    private static final int INDEX_PSSYSSEARCHBARNAME = 25;
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
    private PSSysSearchBarLogicBase proxyPSSysSearchBarLogicBase = null;
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
    private boolean pssyspfpluginidDirtyFlag = false;
    private boolean pssyspfpluginnameDirtyFlag = false;
    private boolean pssyssearchbaridDirtyFlag = false;
    private boolean pssyssearchbaritemidDirtyFlag = false;
    private boolean pssyssearchbaritemnameDirtyFlag = false;
    private boolean pssyssearchbarlogicidDirtyFlag = false;
    private boolean pssyssearchbarlogicnameDirtyFlag = false;
    private boolean pssyssearchbarnameDirtyFlag = false;
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
    @Column(name="pssyspfpluginid")
    private String pssyspfpluginid;
    @Column(name="pssyspfpluginname")
    private String pssyspfpluginname;
    @Column(name="pssyssearchbarid")
    private String pssyssearchbarid;
    @Column(name="pssyssearchbaritemid")
    private String pssyssearchbaritemid;
    @Column(name="pssyssearchbaritemname")
    private String pssyssearchbaritemname;
    @Column(name="pssyssearchbarlogicid")
    private String pssyssearchbarlogicid;
    @Column(name="pssyssearchbarlogicname")
    private String pssyssearchbarlogicname;
    @Column(name="pssyssearchbarname")
    private String pssyssearchbarname;
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
    private Integer objPSSysPFPluginLock = new Integer(1);
    private PSSysPFPlugin pssyspfplugin = null;
    private Integer objPSSysSearchBarItemLock = new Integer(1);
    private PSSysSearchBarItem pssyssearchbaritem = null;
    private Integer objPSSysSearchBarLock = new Integer(1);
    private PSSysSearchBar pssyssearchbar = null;
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

    public void setPSSysSearchBarId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSearchBarId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssearchbarid = string;
        this.pssyssearchbaridDirtyFlag = true;
    }

    public String getPSSysSearchBarId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSearchBarId();
        }
        return this.pssyssearchbarid;
    }

    public boolean isPSSysSearchBarIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSearchBarIdDirty();
        }
        return this.pssyssearchbaridDirtyFlag;
    }

    public void resetPSSysSearchBarId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSearchBarId();
            return;
        }
        this.pssyssearchbaridDirtyFlag = false;
        this.pssyssearchbarid = null;
    }

    public void setPSSysSearchBarItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSearchBarItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssearchbaritemid = string;
        this.pssyssearchbaritemidDirtyFlag = true;
    }

    public String getPSSysSearchBarItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSearchBarItemId();
        }
        return this.pssyssearchbaritemid;
    }

    public boolean isPSSysSearchBarItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSearchBarItemIdDirty();
        }
        return this.pssyssearchbaritemidDirtyFlag;
    }

    public void resetPSSysSearchBarItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSearchBarItemId();
            return;
        }
        this.pssyssearchbaritemidDirtyFlag = false;
        this.pssyssearchbaritemid = null;
    }

    public void setPSSysSearchBarItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSearchBarItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssearchbaritemname = string;
        this.pssyssearchbaritemnameDirtyFlag = true;
    }

    public String getPSSysSearchBarItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSearchBarItemName();
        }
        return this.pssyssearchbaritemname;
    }

    public boolean isPSSysSearchBarItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSearchBarItemNameDirty();
        }
        return this.pssyssearchbaritemnameDirtyFlag;
    }

    public void resetPSSysSearchBarItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSearchBarItemName();
            return;
        }
        this.pssyssearchbaritemnameDirtyFlag = false;
        this.pssyssearchbaritemname = null;
    }

    public void setPSSysSearchBarLogicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSearchBarLogicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssearchbarlogicid = string;
        this.pssyssearchbarlogicidDirtyFlag = true;
    }

    public String getPSSysSearchBarLogicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSearchBarLogicId();
        }
        return this.pssyssearchbarlogicid;
    }

    public boolean isPSSysSearchBarLogicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSearchBarLogicIdDirty();
        }
        return this.pssyssearchbarlogicidDirtyFlag;
    }

    public void resetPSSysSearchBarLogicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSearchBarLogicId();
            return;
        }
        this.pssyssearchbarlogicidDirtyFlag = false;
        this.pssyssearchbarlogicid = null;
    }

    public void setPSSysSearchBarLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSearchBarLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssearchbarlogicname = string;
        this.pssyssearchbarlogicnameDirtyFlag = true;
    }

    public String getPSSysSearchBarLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSearchBarLogicName();
        }
        return this.pssyssearchbarlogicname;
    }

    public boolean isPSSysSearchBarLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSearchBarLogicNameDirty();
        }
        return this.pssyssearchbarlogicnameDirtyFlag;
    }

    public void resetPSSysSearchBarLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSearchBarLogicName();
            return;
        }
        this.pssyssearchbarlogicnameDirtyFlag = false;
        this.pssyssearchbarlogicname = null;
    }

    public void setPSSysSearchBarName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSearchBarName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssearchbarname = string;
        this.pssyssearchbarnameDirtyFlag = true;
    }

    public String getPSSysSearchBarName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSearchBarName();
        }
        return this.pssyssearchbarname;
    }

    public boolean isPSSysSearchBarNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSearchBarNameDirty();
        }
        return this.pssyssearchbarnameDirtyFlag;
    }

    public void resetPSSysSearchBarName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSearchBarName();
            return;
        }
        this.pssyssearchbarnameDirtyFlag = false;
        this.pssyssearchbarname = null;
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
        PSSysSearchBarLogicBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysSearchBarLogicBase pSSysSearchBarLogicBase) {
        pSSysSearchBarLogicBase.resetAttrName();
        pSSysSearchBarLogicBase.resetCreateDate();
        pSSysSearchBarLogicBase.resetCreateMan();
        pSSysSearchBarLogicBase.resetCustomCode();
        pSSysSearchBarLogicBase.resetDstLogicType();
        pSSysSearchBarLogicBase.resetEventArg();
        pSSysSearchBarLogicBase.resetEventArg2();
        pSSysSearchBarLogicBase.resetEventNames();
        pSSysSearchBarLogicBase.resetLogicParam();
        pSSysSearchBarLogicBase.resetLogicParam2();
        pSSysSearchBarLogicBase.resetMemo();
        pSSysSearchBarLogicBase.resetOrderValue();
        pSSysSearchBarLogicBase.resetPSDEId();
        pSSysSearchBarLogicBase.resetPSDELogicId();
        pSSysSearchBarLogicBase.resetPSDELogicName();
        pSSysSearchBarLogicBase.resetPSDEName();
        pSSysSearchBarLogicBase.resetPSDEUIActionId();
        pSSysSearchBarLogicBase.resetPSDEUIActionName();
        pSSysSearchBarLogicBase.resetPSSysPFPluginId();
        pSSysSearchBarLogicBase.resetPSSysPFPluginName();
        pSSysSearchBarLogicBase.resetPSSysSearchBarId();
        pSSysSearchBarLogicBase.resetPSSysSearchBarItemId();
        pSSysSearchBarLogicBase.resetPSSysSearchBarItemName();
        pSSysSearchBarLogicBase.resetPSSysSearchBarLogicId();
        pSSysSearchBarLogicBase.resetPSSysSearchBarLogicName();
        pSSysSearchBarLogicBase.resetPSSysSearchBarName();
        pSSysSearchBarLogicBase.resetPSSysViewLogicId();
        pSSysSearchBarLogicBase.resetPSSysViewLogicName();
        pSSysSearchBarLogicBase.resetPSSysViewPanelId();
        pSSysSearchBarLogicBase.resetPSSysViewPanelName();
        pSSysSearchBarLogicBase.resetTimer();
        pSSysSearchBarLogicBase.resetTriggerType();
        pSSysSearchBarLogicBase.resetUpdateDate();
        pSSysSearchBarLogicBase.resetUpdateMan();
        pSSysSearchBarLogicBase.resetUserCat();
        pSSysSearchBarLogicBase.resetUserTag();
        pSSysSearchBarLogicBase.resetUserTag2();
        pSSysSearchBarLogicBase.resetUserTag3();
        pSSysSearchBarLogicBase.resetUserTag4();
        pSSysSearchBarLogicBase.resetValidFlag();
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
        if (!bl || this.isPSSysPFPluginIdDirty()) {
            hashMap.put(FIELD_PSSYSPFPLUGINID, this.getPSSysPFPluginId());
        }
        if (!bl || this.isPSSysPFPluginNameDirty()) {
            hashMap.put(FIELD_PSSYSPFPLUGINNAME, this.getPSSysPFPluginName());
        }
        if (!bl || this.isPSSysSearchBarIdDirty()) {
            hashMap.put(FIELD_PSSYSSEARCHBARID, this.getPSSysSearchBarId());
        }
        if (!bl || this.isPSSysSearchBarItemIdDirty()) {
            hashMap.put(FIELD_PSSYSSEARCHBARITEMID, this.getPSSysSearchBarItemId());
        }
        if (!bl || this.isPSSysSearchBarItemNameDirty()) {
            hashMap.put(FIELD_PSSYSSEARCHBARITEMNAME, this.getPSSysSearchBarItemName());
        }
        if (!bl || this.isPSSysSearchBarLogicIdDirty()) {
            hashMap.put(FIELD_PSSYSSEARCHBARLOGICID, this.getPSSysSearchBarLogicId());
        }
        if (!bl || this.isPSSysSearchBarLogicNameDirty()) {
            hashMap.put(FIELD_PSSYSSEARCHBARLOGICNAME, this.getPSSysSearchBarLogicName());
        }
        if (!bl || this.isPSSysSearchBarNameDirty()) {
            hashMap.put(FIELD_PSSYSSEARCHBARNAME, this.getPSSysSearchBarName());
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
        return PSSysSearchBarLogicBase.get(this, n);
    }

    private static Object get(PSSysSearchBarLogicBase pSSysSearchBarLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysSearchBarLogicBase.getAttrName();
            }
            case 1: {
                return pSSysSearchBarLogicBase.getCreateDate();
            }
            case 2: {
                return pSSysSearchBarLogicBase.getCreateMan();
            }
            case 3: {
                return pSSysSearchBarLogicBase.getCustomCode();
            }
            case 4: {
                return pSSysSearchBarLogicBase.getDstLogicType();
            }
            case 5: {
                return pSSysSearchBarLogicBase.getEventArg();
            }
            case 6: {
                return pSSysSearchBarLogicBase.getEventArg2();
            }
            case 7: {
                return pSSysSearchBarLogicBase.getEventNames();
            }
            case 8: {
                return pSSysSearchBarLogicBase.getLogicParam();
            }
            case 9: {
                return pSSysSearchBarLogicBase.getLogicParam2();
            }
            case 10: {
                return pSSysSearchBarLogicBase.getMemo();
            }
            case 11: {
                return pSSysSearchBarLogicBase.getOrderValue();
            }
            case 12: {
                return pSSysSearchBarLogicBase.getPSDEId();
            }
            case 13: {
                return pSSysSearchBarLogicBase.getPSDELogicId();
            }
            case 14: {
                return pSSysSearchBarLogicBase.getPSDELogicName();
            }
            case 15: {
                return pSSysSearchBarLogicBase.getPSDEName();
            }
            case 16: {
                return pSSysSearchBarLogicBase.getPSDEUIActionId();
            }
            case 17: {
                return pSSysSearchBarLogicBase.getPSDEUIActionName();
            }
            case 18: {
                return pSSysSearchBarLogicBase.getPSSysPFPluginId();
            }
            case 19: {
                return pSSysSearchBarLogicBase.getPSSysPFPluginName();
            }
            case 20: {
                return pSSysSearchBarLogicBase.getPSSysSearchBarId();
            }
            case 21: {
                return pSSysSearchBarLogicBase.getPSSysSearchBarItemId();
            }
            case 22: {
                return pSSysSearchBarLogicBase.getPSSysSearchBarItemName();
            }
            case 23: {
                return pSSysSearchBarLogicBase.getPSSysSearchBarLogicId();
            }
            case 24: {
                return pSSysSearchBarLogicBase.getPSSysSearchBarLogicName();
            }
            case 25: {
                return pSSysSearchBarLogicBase.getPSSysSearchBarName();
            }
            case 26: {
                return pSSysSearchBarLogicBase.getPSSysViewLogicId();
            }
            case 27: {
                return pSSysSearchBarLogicBase.getPSSysViewLogicName();
            }
            case 28: {
                return pSSysSearchBarLogicBase.getPSSysViewPanelId();
            }
            case 29: {
                return pSSysSearchBarLogicBase.getPSSysViewPanelName();
            }
            case 30: {
                return pSSysSearchBarLogicBase.getTimer();
            }
            case 31: {
                return pSSysSearchBarLogicBase.getTriggerType();
            }
            case 32: {
                return pSSysSearchBarLogicBase.getUpdateDate();
            }
            case 33: {
                return pSSysSearchBarLogicBase.getUpdateMan();
            }
            case 34: {
                return pSSysSearchBarLogicBase.getUserCat();
            }
            case 35: {
                return pSSysSearchBarLogicBase.getUserTag();
            }
            case 36: {
                return pSSysSearchBarLogicBase.getUserTag2();
            }
            case 37: {
                return pSSysSearchBarLogicBase.getUserTag3();
            }
            case 38: {
                return pSSysSearchBarLogicBase.getUserTag4();
            }
            case 39: {
                return pSSysSearchBarLogicBase.getValidFlag();
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
        PSSysSearchBarLogicBase.set(this, n, object);
    }

    private static void set(PSSysSearchBarLogicBase pSSysSearchBarLogicBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysSearchBarLogicBase.setAttrName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysSearchBarLogicBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysSearchBarLogicBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysSearchBarLogicBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysSearchBarLogicBase.setDstLogicType(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysSearchBarLogicBase.setEventArg(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysSearchBarLogicBase.setEventArg2(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysSearchBarLogicBase.setEventNames(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysSearchBarLogicBase.setLogicParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysSearchBarLogicBase.setLogicParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysSearchBarLogicBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysSearchBarLogicBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSSysSearchBarLogicBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysSearchBarLogicBase.setPSDELogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysSearchBarLogicBase.setPSDELogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysSearchBarLogicBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysSearchBarLogicBase.setPSDEUIActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysSearchBarLogicBase.setPSDEUIActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysSearchBarLogicBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysSearchBarLogicBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysSearchBarLogicBase.setPSSysSearchBarId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysSearchBarLogicBase.setPSSysSearchBarItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysSearchBarLogicBase.setPSSysSearchBarItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysSearchBarLogicBase.setPSSysSearchBarLogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysSearchBarLogicBase.setPSSysSearchBarLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysSearchBarLogicBase.setPSSysSearchBarName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysSearchBarLogicBase.setPSSysViewLogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysSearchBarLogicBase.setPSSysViewLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysSearchBarLogicBase.setPSSysViewPanelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSysSearchBarLogicBase.setPSSysViewPanelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSysSearchBarLogicBase.setTimer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 31: {
                pSSysSearchBarLogicBase.setTriggerType(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSysSearchBarLogicBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 33: {
                pSSysSearchBarLogicBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSSysSearchBarLogicBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSSysSearchBarLogicBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSSysSearchBarLogicBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSSysSearchBarLogicBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSSysSearchBarLogicBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSSysSearchBarLogicBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSysSearchBarLogicBase.isNull(this, n);
    }

    private static boolean isNull(PSSysSearchBarLogicBase pSSysSearchBarLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysSearchBarLogicBase.getAttrName() == null;
            }
            case 1: {
                return pSSysSearchBarLogicBase.getCreateDate() == null;
            }
            case 2: {
                return pSSysSearchBarLogicBase.getCreateMan() == null;
            }
            case 3: {
                return pSSysSearchBarLogicBase.getCustomCode() == null;
            }
            case 4: {
                return pSSysSearchBarLogicBase.getDstLogicType() == null;
            }
            case 5: {
                return pSSysSearchBarLogicBase.getEventArg() == null;
            }
            case 6: {
                return pSSysSearchBarLogicBase.getEventArg2() == null;
            }
            case 7: {
                return pSSysSearchBarLogicBase.getEventNames() == null;
            }
            case 8: {
                return pSSysSearchBarLogicBase.getLogicParam() == null;
            }
            case 9: {
                return pSSysSearchBarLogicBase.getLogicParam2() == null;
            }
            case 10: {
                return pSSysSearchBarLogicBase.getMemo() == null;
            }
            case 11: {
                return pSSysSearchBarLogicBase.getOrderValue() == null;
            }
            case 12: {
                return pSSysSearchBarLogicBase.getPSDEId() == null;
            }
            case 13: {
                return pSSysSearchBarLogicBase.getPSDELogicId() == null;
            }
            case 14: {
                return pSSysSearchBarLogicBase.getPSDELogicName() == null;
            }
            case 15: {
                return pSSysSearchBarLogicBase.getPSDEName() == null;
            }
            case 16: {
                return pSSysSearchBarLogicBase.getPSDEUIActionId() == null;
            }
            case 17: {
                return pSSysSearchBarLogicBase.getPSDEUIActionName() == null;
            }
            case 18: {
                return pSSysSearchBarLogicBase.getPSSysPFPluginId() == null;
            }
            case 19: {
                return pSSysSearchBarLogicBase.getPSSysPFPluginName() == null;
            }
            case 20: {
                return pSSysSearchBarLogicBase.getPSSysSearchBarId() == null;
            }
            case 21: {
                return pSSysSearchBarLogicBase.getPSSysSearchBarItemId() == null;
            }
            case 22: {
                return pSSysSearchBarLogicBase.getPSSysSearchBarItemName() == null;
            }
            case 23: {
                return pSSysSearchBarLogicBase.getPSSysSearchBarLogicId() == null;
            }
            case 24: {
                return pSSysSearchBarLogicBase.getPSSysSearchBarLogicName() == null;
            }
            case 25: {
                return pSSysSearchBarLogicBase.getPSSysSearchBarName() == null;
            }
            case 26: {
                return pSSysSearchBarLogicBase.getPSSysViewLogicId() == null;
            }
            case 27: {
                return pSSysSearchBarLogicBase.getPSSysViewLogicName() == null;
            }
            case 28: {
                return pSSysSearchBarLogicBase.getPSSysViewPanelId() == null;
            }
            case 29: {
                return pSSysSearchBarLogicBase.getPSSysViewPanelName() == null;
            }
            case 30: {
                return pSSysSearchBarLogicBase.getTimer() == null;
            }
            case 31: {
                return pSSysSearchBarLogicBase.getTriggerType() == null;
            }
            case 32: {
                return pSSysSearchBarLogicBase.getUpdateDate() == null;
            }
            case 33: {
                return pSSysSearchBarLogicBase.getUpdateMan() == null;
            }
            case 34: {
                return pSSysSearchBarLogicBase.getUserCat() == null;
            }
            case 35: {
                return pSSysSearchBarLogicBase.getUserTag() == null;
            }
            case 36: {
                return pSSysSearchBarLogicBase.getUserTag2() == null;
            }
            case 37: {
                return pSSysSearchBarLogicBase.getUserTag3() == null;
            }
            case 38: {
                return pSSysSearchBarLogicBase.getUserTag4() == null;
            }
            case 39: {
                return pSSysSearchBarLogicBase.getValidFlag() == null;
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
        return PSSysSearchBarLogicBase.contains(this, n);
    }

    private static boolean contains(PSSysSearchBarLogicBase pSSysSearchBarLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysSearchBarLogicBase.isAttrNameDirty();
            }
            case 1: {
                return pSSysSearchBarLogicBase.isCreateDateDirty();
            }
            case 2: {
                return pSSysSearchBarLogicBase.isCreateManDirty();
            }
            case 3: {
                return pSSysSearchBarLogicBase.isCustomCodeDirty();
            }
            case 4: {
                return pSSysSearchBarLogicBase.isDstLogicTypeDirty();
            }
            case 5: {
                return pSSysSearchBarLogicBase.isEventArgDirty();
            }
            case 6: {
                return pSSysSearchBarLogicBase.isEventArg2Dirty();
            }
            case 7: {
                return pSSysSearchBarLogicBase.isEventNamesDirty();
            }
            case 8: {
                return pSSysSearchBarLogicBase.isLogicParamDirty();
            }
            case 9: {
                return pSSysSearchBarLogicBase.isLogicParam2Dirty();
            }
            case 10: {
                return pSSysSearchBarLogicBase.isMemoDirty();
            }
            case 11: {
                return pSSysSearchBarLogicBase.isOrderValueDirty();
            }
            case 12: {
                return pSSysSearchBarLogicBase.isPSDEIdDirty();
            }
            case 13: {
                return pSSysSearchBarLogicBase.isPSDELogicIdDirty();
            }
            case 14: {
                return pSSysSearchBarLogicBase.isPSDELogicNameDirty();
            }
            case 15: {
                return pSSysSearchBarLogicBase.isPSDENameDirty();
            }
            case 16: {
                return pSSysSearchBarLogicBase.isPSDEUIActionIdDirty();
            }
            case 17: {
                return pSSysSearchBarLogicBase.isPSDEUIActionNameDirty();
            }
            case 18: {
                return pSSysSearchBarLogicBase.isPSSysPFPluginIdDirty();
            }
            case 19: {
                return pSSysSearchBarLogicBase.isPSSysPFPluginNameDirty();
            }
            case 20: {
                return pSSysSearchBarLogicBase.isPSSysSearchBarIdDirty();
            }
            case 21: {
                return pSSysSearchBarLogicBase.isPSSysSearchBarItemIdDirty();
            }
            case 22: {
                return pSSysSearchBarLogicBase.isPSSysSearchBarItemNameDirty();
            }
            case 23: {
                return pSSysSearchBarLogicBase.isPSSysSearchBarLogicIdDirty();
            }
            case 24: {
                return pSSysSearchBarLogicBase.isPSSysSearchBarLogicNameDirty();
            }
            case 25: {
                return pSSysSearchBarLogicBase.isPSSysSearchBarNameDirty();
            }
            case 26: {
                return pSSysSearchBarLogicBase.isPSSysViewLogicIdDirty();
            }
            case 27: {
                return pSSysSearchBarLogicBase.isPSSysViewLogicNameDirty();
            }
            case 28: {
                return pSSysSearchBarLogicBase.isPSSysViewPanelIdDirty();
            }
            case 29: {
                return pSSysSearchBarLogicBase.isPSSysViewPanelNameDirty();
            }
            case 30: {
                return pSSysSearchBarLogicBase.isTimerDirty();
            }
            case 31: {
                return pSSysSearchBarLogicBase.isTriggerTypeDirty();
            }
            case 32: {
                return pSSysSearchBarLogicBase.isUpdateDateDirty();
            }
            case 33: {
                return pSSysSearchBarLogicBase.isUpdateManDirty();
            }
            case 34: {
                return pSSysSearchBarLogicBase.isUserCatDirty();
            }
            case 35: {
                return pSSysSearchBarLogicBase.isUserTagDirty();
            }
            case 36: {
                return pSSysSearchBarLogicBase.isUserTag2Dirty();
            }
            case 37: {
                return pSSysSearchBarLogicBase.isUserTag3Dirty();
            }
            case 38: {
                return pSSysSearchBarLogicBase.isUserTag4Dirty();
            }
            case 39: {
                return pSSysSearchBarLogicBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysSearchBarLogicBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysSearchBarLogicBase pSSysSearchBarLogicBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysSearchBarLogicBase.getAttrName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"attrname", (Object)PSSysSearchBarLogicBase.getJSONValue((Object)pSSysSearchBarLogicBase.getAttrName()), (boolean)false);
        }
        if (bl || pSSysSearchBarLogicBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysSearchBarLogicBase.getJSONValue((Object)pSSysSearchBarLogicBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysSearchBarLogicBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysSearchBarLogicBase.getJSONValue((Object)pSSysSearchBarLogicBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysSearchBarLogicBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSSysSearchBarLogicBase.getJSONValue((Object)pSSysSearchBarLogicBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSSysSearchBarLogicBase.getDstLogicType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstlogictype", (Object)PSSysSearchBarLogicBase.getJSONValue((Object)pSSysSearchBarLogicBase.getDstLogicType()), (boolean)false);
        }
        if (bl || pSSysSearchBarLogicBase.getEventArg() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eventarg", (Object)PSSysSearchBarLogicBase.getJSONValue((Object)pSSysSearchBarLogicBase.getEventArg()), (boolean)false);
        }
        if (bl || pSSysSearchBarLogicBase.getEventArg2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eventarg2", (Object)PSSysSearchBarLogicBase.getJSONValue((Object)pSSysSearchBarLogicBase.getEventArg2()), (boolean)false);
        }
        if (bl || pSSysSearchBarLogicBase.getEventNames() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eventnames", (Object)PSSysSearchBarLogicBase.getJSONValue((Object)pSSysSearchBarLogicBase.getEventNames()), (boolean)false);
        }
        if (bl || pSSysSearchBarLogicBase.getLogicParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicparam", (Object)PSSysSearchBarLogicBase.getJSONValue((Object)pSSysSearchBarLogicBase.getLogicParam()), (boolean)false);
        }
        if (bl || pSSysSearchBarLogicBase.getLogicParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicparam2", (Object)PSSysSearchBarLogicBase.getJSONValue((Object)pSSysSearchBarLogicBase.getLogicParam2()), (boolean)false);
        }
        if (bl || pSSysSearchBarLogicBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysSearchBarLogicBase.getJSONValue((Object)pSSysSearchBarLogicBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysSearchBarLogicBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSysSearchBarLogicBase.getJSONValue((Object)pSSysSearchBarLogicBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSysSearchBarLogicBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSSysSearchBarLogicBase.getJSONValue((Object)pSSysSearchBarLogicBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSSysSearchBarLogicBase.getPSDELogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicid", (Object)PSSysSearchBarLogicBase.getJSONValue((Object)pSSysSearchBarLogicBase.getPSDELogicId()), (boolean)false);
        }
        if (bl || pSSysSearchBarLogicBase.getPSDELogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicname", (Object)PSSysSearchBarLogicBase.getJSONValue((Object)pSSysSearchBarLogicBase.getPSDELogicName()), (boolean)false);
        }
        if (bl || pSSysSearchBarLogicBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSSysSearchBarLogicBase.getJSONValue((Object)pSSysSearchBarLogicBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSSysSearchBarLogicBase.getPSDEUIActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuiactionid", (Object)PSSysSearchBarLogicBase.getJSONValue((Object)pSSysSearchBarLogicBase.getPSDEUIActionId()), (boolean)false);
        }
        if (bl || pSSysSearchBarLogicBase.getPSDEUIActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuiactionname", (Object)PSSysSearchBarLogicBase.getJSONValue((Object)pSSysSearchBarLogicBase.getPSDEUIActionName()), (boolean)false);
        }
        if (bl || pSSysSearchBarLogicBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSSysSearchBarLogicBase.getJSONValue((Object)pSSysSearchBarLogicBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSSysSearchBarLogicBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSSysSearchBarLogicBase.getJSONValue((Object)pSSysSearchBarLogicBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSSysSearchBarLogicBase.getPSSysSearchBarId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssearchbarid", (Object)PSSysSearchBarLogicBase.getJSONValue((Object)pSSysSearchBarLogicBase.getPSSysSearchBarId()), (boolean)false);
        }
        if (bl || pSSysSearchBarLogicBase.getPSSysSearchBarItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssearchbaritemid", (Object)PSSysSearchBarLogicBase.getJSONValue((Object)pSSysSearchBarLogicBase.getPSSysSearchBarItemId()), (boolean)false);
        }
        if (bl || pSSysSearchBarLogicBase.getPSSysSearchBarItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssearchbaritemname", (Object)PSSysSearchBarLogicBase.getJSONValue((Object)pSSysSearchBarLogicBase.getPSSysSearchBarItemName()), (boolean)false);
        }
        if (bl || pSSysSearchBarLogicBase.getPSSysSearchBarLogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssearchbarlogicid", (Object)PSSysSearchBarLogicBase.getJSONValue((Object)pSSysSearchBarLogicBase.getPSSysSearchBarLogicId()), (boolean)false);
        }
        if (bl || pSSysSearchBarLogicBase.getPSSysSearchBarLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssearchbarlogicname", (Object)PSSysSearchBarLogicBase.getJSONValue((Object)pSSysSearchBarLogicBase.getPSSysSearchBarLogicName()), (boolean)false);
        }
        if (bl || pSSysSearchBarLogicBase.getPSSysSearchBarName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssearchbarname", (Object)PSSysSearchBarLogicBase.getJSONValue((Object)pSSysSearchBarLogicBase.getPSSysSearchBarName()), (boolean)false);
        }
        if (bl || pSSysSearchBarLogicBase.getPSSysViewLogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewlogicid", (Object)PSSysSearchBarLogicBase.getJSONValue((Object)pSSysSearchBarLogicBase.getPSSysViewLogicId()), (boolean)false);
        }
        if (bl || pSSysSearchBarLogicBase.getPSSysViewLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewlogicname", (Object)PSSysSearchBarLogicBase.getJSONValue((Object)pSSysSearchBarLogicBase.getPSSysViewLogicName()), (boolean)false);
        }
        if (bl || pSSysSearchBarLogicBase.getPSSysViewPanelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelid", (Object)PSSysSearchBarLogicBase.getJSONValue((Object)pSSysSearchBarLogicBase.getPSSysViewPanelId()), (boolean)false);
        }
        if (bl || pSSysSearchBarLogicBase.getPSSysViewPanelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelname", (Object)PSSysSearchBarLogicBase.getJSONValue((Object)pSSysSearchBarLogicBase.getPSSysViewPanelName()), (boolean)false);
        }
        if (bl || pSSysSearchBarLogicBase.getTimer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"timer", (Object)PSSysSearchBarLogicBase.getJSONValue((Object)pSSysSearchBarLogicBase.getTimer()), (boolean)false);
        }
        if (bl || pSSysSearchBarLogicBase.getTriggerType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"triggertype", (Object)PSSysSearchBarLogicBase.getJSONValue((Object)pSSysSearchBarLogicBase.getTriggerType()), (boolean)false);
        }
        if (bl || pSSysSearchBarLogicBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysSearchBarLogicBase.getJSONValue((Object)pSSysSearchBarLogicBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysSearchBarLogicBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysSearchBarLogicBase.getJSONValue((Object)pSSysSearchBarLogicBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysSearchBarLogicBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysSearchBarLogicBase.getJSONValue((Object)pSSysSearchBarLogicBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysSearchBarLogicBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysSearchBarLogicBase.getJSONValue((Object)pSSysSearchBarLogicBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysSearchBarLogicBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysSearchBarLogicBase.getJSONValue((Object)pSSysSearchBarLogicBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysSearchBarLogicBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysSearchBarLogicBase.getJSONValue((Object)pSSysSearchBarLogicBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysSearchBarLogicBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysSearchBarLogicBase.getJSONValue((Object)pSSysSearchBarLogicBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysSearchBarLogicBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysSearchBarLogicBase.getJSONValue((Object)pSSysSearchBarLogicBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysSearchBarLogicBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysSearchBarLogicBase pSSysSearchBarLogicBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysSearchBarLogicBase.getAttrName() != null) {
            object = pSSysSearchBarLogicBase.getAttrName();
            xmlNode.setAttribute(FIELD_ATTRNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarLogicBase.getCreateDate() != null) {
            object = pSSysSearchBarLogicBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysSearchBarLogicBase.getCreateMan() != null) {
            object = pSSysSearchBarLogicBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarLogicBase.getCustomCode() != null) {
            object = pSSysSearchBarLogicBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarLogicBase.getDstLogicType() != null) {
            object = pSSysSearchBarLogicBase.getDstLogicType();
            xmlNode.setAttribute(FIELD_DSTLOGICTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarLogicBase.getEventArg() != null) {
            object = pSSysSearchBarLogicBase.getEventArg();
            xmlNode.setAttribute(FIELD_EVENTARG, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarLogicBase.getEventArg2() != null) {
            object = pSSysSearchBarLogicBase.getEventArg2();
            xmlNode.setAttribute(FIELD_EVENTARG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarLogicBase.getEventNames() != null) {
            object = pSSysSearchBarLogicBase.getEventNames();
            xmlNode.setAttribute(FIELD_EVENTNAMES, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarLogicBase.getLogicParam() != null) {
            object = pSSysSearchBarLogicBase.getLogicParam();
            xmlNode.setAttribute(FIELD_LOGICPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarLogicBase.getLogicParam2() != null) {
            object = pSSysSearchBarLogicBase.getLogicParam2();
            xmlNode.setAttribute(FIELD_LOGICPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarLogicBase.getMemo() != null) {
            object = pSSysSearchBarLogicBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarLogicBase.getOrderValue() != null) {
            object = pSSysSearchBarLogicBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysSearchBarLogicBase.getPSDEId() != null) {
            object = pSSysSearchBarLogicBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarLogicBase.getPSDELogicId() != null) {
            object = pSSysSearchBarLogicBase.getPSDELogicId();
            xmlNode.setAttribute(FIELD_PSDELOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarLogicBase.getPSDELogicName() != null) {
            object = pSSysSearchBarLogicBase.getPSDELogicName();
            xmlNode.setAttribute(FIELD_PSDELOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarLogicBase.getPSDEName() != null) {
            object = pSSysSearchBarLogicBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarLogicBase.getPSDEUIActionId() != null) {
            object = pSSysSearchBarLogicBase.getPSDEUIActionId();
            xmlNode.setAttribute(FIELD_PSDEUIACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarLogicBase.getPSDEUIActionName() != null) {
            object = pSSysSearchBarLogicBase.getPSDEUIActionName();
            xmlNode.setAttribute(FIELD_PSDEUIACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarLogicBase.getPSSysPFPluginId() != null) {
            object = pSSysSearchBarLogicBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarLogicBase.getPSSysPFPluginName() != null) {
            object = pSSysSearchBarLogicBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarLogicBase.getPSSysSearchBarId() != null) {
            object = pSSysSearchBarLogicBase.getPSSysSearchBarId();
            xmlNode.setAttribute(FIELD_PSSYSSEARCHBARID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarLogicBase.getPSSysSearchBarItemId() != null) {
            object = pSSysSearchBarLogicBase.getPSSysSearchBarItemId();
            xmlNode.setAttribute(FIELD_PSSYSSEARCHBARITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarLogicBase.getPSSysSearchBarItemName() != null) {
            object = pSSysSearchBarLogicBase.getPSSysSearchBarItemName();
            xmlNode.setAttribute(FIELD_PSSYSSEARCHBARITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarLogicBase.getPSSysSearchBarLogicId() != null) {
            object = pSSysSearchBarLogicBase.getPSSysSearchBarLogicId();
            xmlNode.setAttribute(FIELD_PSSYSSEARCHBARLOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarLogicBase.getPSSysSearchBarLogicName() != null) {
            object = pSSysSearchBarLogicBase.getPSSysSearchBarLogicName();
            xmlNode.setAttribute(FIELD_PSSYSSEARCHBARLOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarLogicBase.getPSSysSearchBarName() != null) {
            object = pSSysSearchBarLogicBase.getPSSysSearchBarName();
            xmlNode.setAttribute(FIELD_PSSYSSEARCHBARNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarLogicBase.getPSSysViewLogicId() != null) {
            object = pSSysSearchBarLogicBase.getPSSysViewLogicId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWLOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarLogicBase.getPSSysViewLogicName() != null) {
            object = pSSysSearchBarLogicBase.getPSSysViewLogicName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWLOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarLogicBase.getPSSysViewPanelId() != null) {
            object = pSSysSearchBarLogicBase.getPSSysViewPanelId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarLogicBase.getPSSysViewPanelName() != null) {
            object = pSSysSearchBarLogicBase.getPSSysViewPanelName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarLogicBase.getTimer() != null) {
            object = pSSysSearchBarLogicBase.getTimer();
            xmlNode.setAttribute(FIELD_TIMER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysSearchBarLogicBase.getTriggerType() != null) {
            object = pSSysSearchBarLogicBase.getTriggerType();
            xmlNode.setAttribute(FIELD_TRIGGERTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarLogicBase.getUpdateDate() != null) {
            object = pSSysSearchBarLogicBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysSearchBarLogicBase.getUpdateMan() != null) {
            object = pSSysSearchBarLogicBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarLogicBase.getUserCat() != null) {
            object = pSSysSearchBarLogicBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarLogicBase.getUserTag() != null) {
            object = pSSysSearchBarLogicBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarLogicBase.getUserTag2() != null) {
            object = pSSysSearchBarLogicBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarLogicBase.getUserTag3() != null) {
            object = pSSysSearchBarLogicBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarLogicBase.getUserTag4() != null) {
            object = pSSysSearchBarLogicBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchBarLogicBase.getValidFlag() != null) {
            object = pSSysSearchBarLogicBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysSearchBarLogicBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysSearchBarLogicBase pSSysSearchBarLogicBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysSearchBarLogicBase.isAttrNameDirty() && (bl || pSSysSearchBarLogicBase.getAttrName() != null)) {
            iDataObject.set(FIELD_ATTRNAME, (Object)pSSysSearchBarLogicBase.getAttrName());
        }
        if (pSSysSearchBarLogicBase.isCreateDateDirty() && (bl || pSSysSearchBarLogicBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysSearchBarLogicBase.getCreateDate());
        }
        if (pSSysSearchBarLogicBase.isCreateManDirty() && (bl || pSSysSearchBarLogicBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysSearchBarLogicBase.getCreateMan());
        }
        if (pSSysSearchBarLogicBase.isCustomCodeDirty() && (bl || pSSysSearchBarLogicBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSSysSearchBarLogicBase.getCustomCode());
        }
        if (pSSysSearchBarLogicBase.isDstLogicTypeDirty() && (bl || pSSysSearchBarLogicBase.getDstLogicType() != null)) {
            iDataObject.set(FIELD_DSTLOGICTYPE, (Object)pSSysSearchBarLogicBase.getDstLogicType());
        }
        if (pSSysSearchBarLogicBase.isEventArgDirty() && (bl || pSSysSearchBarLogicBase.getEventArg() != null)) {
            iDataObject.set(FIELD_EVENTARG, (Object)pSSysSearchBarLogicBase.getEventArg());
        }
        if (pSSysSearchBarLogicBase.isEventArg2Dirty() && (bl || pSSysSearchBarLogicBase.getEventArg2() != null)) {
            iDataObject.set(FIELD_EVENTARG2, (Object)pSSysSearchBarLogicBase.getEventArg2());
        }
        if (pSSysSearchBarLogicBase.isEventNamesDirty() && (bl || pSSysSearchBarLogicBase.getEventNames() != null)) {
            iDataObject.set(FIELD_EVENTNAMES, (Object)pSSysSearchBarLogicBase.getEventNames());
        }
        if (pSSysSearchBarLogicBase.isLogicParamDirty() && (bl || pSSysSearchBarLogicBase.getLogicParam() != null)) {
            iDataObject.set(FIELD_LOGICPARAM, (Object)pSSysSearchBarLogicBase.getLogicParam());
        }
        if (pSSysSearchBarLogicBase.isLogicParam2Dirty() && (bl || pSSysSearchBarLogicBase.getLogicParam2() != null)) {
            iDataObject.set(FIELD_LOGICPARAM2, (Object)pSSysSearchBarLogicBase.getLogicParam2());
        }
        if (pSSysSearchBarLogicBase.isMemoDirty() && (bl || pSSysSearchBarLogicBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysSearchBarLogicBase.getMemo());
        }
        if (pSSysSearchBarLogicBase.isOrderValueDirty() && (bl || pSSysSearchBarLogicBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSysSearchBarLogicBase.getOrderValue());
        }
        if (pSSysSearchBarLogicBase.isPSDEIdDirty() && (bl || pSSysSearchBarLogicBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSSysSearchBarLogicBase.getPSDEId());
        }
        if (pSSysSearchBarLogicBase.isPSDELogicIdDirty() && (bl || pSSysSearchBarLogicBase.getPSDELogicId() != null)) {
            iDataObject.set(FIELD_PSDELOGICID, (Object)pSSysSearchBarLogicBase.getPSDELogicId());
        }
        if (pSSysSearchBarLogicBase.isPSDELogicNameDirty() && (bl || pSSysSearchBarLogicBase.getPSDELogicName() != null)) {
            iDataObject.set(FIELD_PSDELOGICNAME, (Object)pSSysSearchBarLogicBase.getPSDELogicName());
        }
        if (pSSysSearchBarLogicBase.isPSDENameDirty() && (bl || pSSysSearchBarLogicBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSSysSearchBarLogicBase.getPSDEName());
        }
        if (pSSysSearchBarLogicBase.isPSDEUIActionIdDirty() && (bl || pSSysSearchBarLogicBase.getPSDEUIActionId() != null)) {
            iDataObject.set(FIELD_PSDEUIACTIONID, (Object)pSSysSearchBarLogicBase.getPSDEUIActionId());
        }
        if (pSSysSearchBarLogicBase.isPSDEUIActionNameDirty() && (bl || pSSysSearchBarLogicBase.getPSDEUIActionName() != null)) {
            iDataObject.set(FIELD_PSDEUIACTIONNAME, (Object)pSSysSearchBarLogicBase.getPSDEUIActionName());
        }
        if (pSSysSearchBarLogicBase.isPSSysPFPluginIdDirty() && (bl || pSSysSearchBarLogicBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSSysSearchBarLogicBase.getPSSysPFPluginId());
        }
        if (pSSysSearchBarLogicBase.isPSSysPFPluginNameDirty() && (bl || pSSysSearchBarLogicBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSSysSearchBarLogicBase.getPSSysPFPluginName());
        }
        if (pSSysSearchBarLogicBase.isPSSysSearchBarIdDirty() && (bl || pSSysSearchBarLogicBase.getPSSysSearchBarId() != null)) {
            iDataObject.set(FIELD_PSSYSSEARCHBARID, (Object)pSSysSearchBarLogicBase.getPSSysSearchBarId());
        }
        if (pSSysSearchBarLogicBase.isPSSysSearchBarItemIdDirty() && (bl || pSSysSearchBarLogicBase.getPSSysSearchBarItemId() != null)) {
            iDataObject.set(FIELD_PSSYSSEARCHBARITEMID, (Object)pSSysSearchBarLogicBase.getPSSysSearchBarItemId());
        }
        if (pSSysSearchBarLogicBase.isPSSysSearchBarItemNameDirty() && (bl || pSSysSearchBarLogicBase.getPSSysSearchBarItemName() != null)) {
            iDataObject.set(FIELD_PSSYSSEARCHBARITEMNAME, (Object)pSSysSearchBarLogicBase.getPSSysSearchBarItemName());
        }
        if (pSSysSearchBarLogicBase.isPSSysSearchBarLogicIdDirty() && (bl || pSSysSearchBarLogicBase.getPSSysSearchBarLogicId() != null)) {
            iDataObject.set(FIELD_PSSYSSEARCHBARLOGICID, (Object)pSSysSearchBarLogicBase.getPSSysSearchBarLogicId());
        }
        if (pSSysSearchBarLogicBase.isPSSysSearchBarLogicNameDirty() && (bl || pSSysSearchBarLogicBase.getPSSysSearchBarLogicName() != null)) {
            iDataObject.set(FIELD_PSSYSSEARCHBARLOGICNAME, (Object)pSSysSearchBarLogicBase.getPSSysSearchBarLogicName());
        }
        if (pSSysSearchBarLogicBase.isPSSysSearchBarNameDirty() && (bl || pSSysSearchBarLogicBase.getPSSysSearchBarName() != null)) {
            iDataObject.set(FIELD_PSSYSSEARCHBARNAME, (Object)pSSysSearchBarLogicBase.getPSSysSearchBarName());
        }
        if (pSSysSearchBarLogicBase.isPSSysViewLogicIdDirty() && (bl || pSSysSearchBarLogicBase.getPSSysViewLogicId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWLOGICID, (Object)pSSysSearchBarLogicBase.getPSSysViewLogicId());
        }
        if (pSSysSearchBarLogicBase.isPSSysViewLogicNameDirty() && (bl || pSSysSearchBarLogicBase.getPSSysViewLogicName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWLOGICNAME, (Object)pSSysSearchBarLogicBase.getPSSysViewLogicName());
        }
        if (pSSysSearchBarLogicBase.isPSSysViewPanelIdDirty() && (bl || pSSysSearchBarLogicBase.getPSSysViewPanelId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELID, (Object)pSSysSearchBarLogicBase.getPSSysViewPanelId());
        }
        if (pSSysSearchBarLogicBase.isPSSysViewPanelNameDirty() && (bl || pSSysSearchBarLogicBase.getPSSysViewPanelName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELNAME, (Object)pSSysSearchBarLogicBase.getPSSysViewPanelName());
        }
        if (pSSysSearchBarLogicBase.isTimerDirty() && (bl || pSSysSearchBarLogicBase.getTimer() != null)) {
            iDataObject.set(FIELD_TIMER, (Object)pSSysSearchBarLogicBase.getTimer());
        }
        if (pSSysSearchBarLogicBase.isTriggerTypeDirty() && (bl || pSSysSearchBarLogicBase.getTriggerType() != null)) {
            iDataObject.set(FIELD_TRIGGERTYPE, (Object)pSSysSearchBarLogicBase.getTriggerType());
        }
        if (pSSysSearchBarLogicBase.isUpdateDateDirty() && (bl || pSSysSearchBarLogicBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysSearchBarLogicBase.getUpdateDate());
        }
        if (pSSysSearchBarLogicBase.isUpdateManDirty() && (bl || pSSysSearchBarLogicBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysSearchBarLogicBase.getUpdateMan());
        }
        if (pSSysSearchBarLogicBase.isUserCatDirty() && (bl || pSSysSearchBarLogicBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysSearchBarLogicBase.getUserCat());
        }
        if (pSSysSearchBarLogicBase.isUserTagDirty() && (bl || pSSysSearchBarLogicBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysSearchBarLogicBase.getUserTag());
        }
        if (pSSysSearchBarLogicBase.isUserTag2Dirty() && (bl || pSSysSearchBarLogicBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysSearchBarLogicBase.getUserTag2());
        }
        if (pSSysSearchBarLogicBase.isUserTag3Dirty() && (bl || pSSysSearchBarLogicBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysSearchBarLogicBase.getUserTag3());
        }
        if (pSSysSearchBarLogicBase.isUserTag4Dirty() && (bl || pSSysSearchBarLogicBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysSearchBarLogicBase.getUserTag4());
        }
        if (pSSysSearchBarLogicBase.isValidFlagDirty() && (bl || pSSysSearchBarLogicBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysSearchBarLogicBase.getValidFlag());
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
        return PSSysSearchBarLogicBase.remove(this, n);
    }

    private static boolean remove(PSSysSearchBarLogicBase pSSysSearchBarLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysSearchBarLogicBase.resetAttrName();
                return true;
            }
            case 1: {
                pSSysSearchBarLogicBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSysSearchBarLogicBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSysSearchBarLogicBase.resetCustomCode();
                return true;
            }
            case 4: {
                pSSysSearchBarLogicBase.resetDstLogicType();
                return true;
            }
            case 5: {
                pSSysSearchBarLogicBase.resetEventArg();
                return true;
            }
            case 6: {
                pSSysSearchBarLogicBase.resetEventArg2();
                return true;
            }
            case 7: {
                pSSysSearchBarLogicBase.resetEventNames();
                return true;
            }
            case 8: {
                pSSysSearchBarLogicBase.resetLogicParam();
                return true;
            }
            case 9: {
                pSSysSearchBarLogicBase.resetLogicParam2();
                return true;
            }
            case 10: {
                pSSysSearchBarLogicBase.resetMemo();
                return true;
            }
            case 11: {
                pSSysSearchBarLogicBase.resetOrderValue();
                return true;
            }
            case 12: {
                pSSysSearchBarLogicBase.resetPSDEId();
                return true;
            }
            case 13: {
                pSSysSearchBarLogicBase.resetPSDELogicId();
                return true;
            }
            case 14: {
                pSSysSearchBarLogicBase.resetPSDELogicName();
                return true;
            }
            case 15: {
                pSSysSearchBarLogicBase.resetPSDEName();
                return true;
            }
            case 16: {
                pSSysSearchBarLogicBase.resetPSDEUIActionId();
                return true;
            }
            case 17: {
                pSSysSearchBarLogicBase.resetPSDEUIActionName();
                return true;
            }
            case 18: {
                pSSysSearchBarLogicBase.resetPSSysPFPluginId();
                return true;
            }
            case 19: {
                pSSysSearchBarLogicBase.resetPSSysPFPluginName();
                return true;
            }
            case 20: {
                pSSysSearchBarLogicBase.resetPSSysSearchBarId();
                return true;
            }
            case 21: {
                pSSysSearchBarLogicBase.resetPSSysSearchBarItemId();
                return true;
            }
            case 22: {
                pSSysSearchBarLogicBase.resetPSSysSearchBarItemName();
                return true;
            }
            case 23: {
                pSSysSearchBarLogicBase.resetPSSysSearchBarLogicId();
                return true;
            }
            case 24: {
                pSSysSearchBarLogicBase.resetPSSysSearchBarLogicName();
                return true;
            }
            case 25: {
                pSSysSearchBarLogicBase.resetPSSysSearchBarName();
                return true;
            }
            case 26: {
                pSSysSearchBarLogicBase.resetPSSysViewLogicId();
                return true;
            }
            case 27: {
                pSSysSearchBarLogicBase.resetPSSysViewLogicName();
                return true;
            }
            case 28: {
                pSSysSearchBarLogicBase.resetPSSysViewPanelId();
                return true;
            }
            case 29: {
                pSSysSearchBarLogicBase.resetPSSysViewPanelName();
                return true;
            }
            case 30: {
                pSSysSearchBarLogicBase.resetTimer();
                return true;
            }
            case 31: {
                pSSysSearchBarLogicBase.resetTriggerType();
                return true;
            }
            case 32: {
                pSSysSearchBarLogicBase.resetUpdateDate();
                return true;
            }
            case 33: {
                pSSysSearchBarLogicBase.resetUpdateMan();
                return true;
            }
            case 34: {
                pSSysSearchBarLogicBase.resetUserCat();
                return true;
            }
            case 35: {
                pSSysSearchBarLogicBase.resetUserTag();
                return true;
            }
            case 36: {
                pSSysSearchBarLogicBase.resetUserTag2();
                return true;
            }
            case 37: {
                pSSysSearchBarLogicBase.resetUserTag3();
                return true;
            }
            case 38: {
                pSSysSearchBarLogicBase.resetUserTag4();
                return true;
            }
            case 39: {
                pSSysSearchBarLogicBase.resetValidFlag();
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
    public PSSysSearchBarItem getPSSysSearchBarItem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSearchBarItem();
        }
        if (this.getPSSysSearchBarItemId() == null) {
            return null;
        }
        Integer n = this.objPSSysSearchBarItemLock;
        synchronized (n) {
            if (this.pssyssearchbaritem != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysSearchBarItemId(), (Object)this.pssyssearchbaritem.getPSSysSearchBarItemId()) != 0L) {
                this.pssyssearchbaritem = null;
            }
            if (this.pssyssearchbaritem == null) {
                PSSysSearchBarItem pSSysSearchBarItem = new PSSysSearchBarItem();
                pSSysSearchBarItem.setPSSysSearchBarItemId(this.getPSSysSearchBarItemId());
                PSSysSearchBarItemService pSSysSearchBarItemService = (PSSysSearchBarItemService)ServiceGlobal.getService(PSSysSearchBarItemService.class, (SessionFactory)this.getSessionFactory());
                pSSysSearchBarItemService.autoGet(pSSysSearchBarItem);
                this.pssyssearchbaritem = pSSysSearchBarItem;
            }
            return this.pssyssearchbaritem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysSearchBar getPSSysSearchBar() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSearchBar();
        }
        if (this.getPSSysSearchBarId() == null) {
            return null;
        }
        Integer n = this.objPSSysSearchBarLock;
        synchronized (n) {
            if (this.pssyssearchbar != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysSearchBarId(), (Object)this.pssyssearchbar.getPSSysSearchBarId()) != 0L) {
                this.pssyssearchbar = null;
            }
            if (this.pssyssearchbar == null) {
                PSSysSearchBar pSSysSearchBar = new PSSysSearchBar();
                pSSysSearchBar.setPSSysSearchBarId(this.getPSSysSearchBarId());
                PSSysSearchBarService pSSysSearchBarService = (PSSysSearchBarService)ServiceGlobal.getService(PSSysSearchBarService.class, (SessionFactory)this.getSessionFactory());
                pSSysSearchBarService.autoGet(pSSysSearchBar);
                this.pssyssearchbar = pSSysSearchBar;
            }
            return this.pssyssearchbar;
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

    private PSSysSearchBarLogicBase getProxyEntity() {
        return this.proxyPSSysSearchBarLogicBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysSearchBarLogicBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysSearchBarLogicBase) {
            this.proxyPSSysSearchBarLogicBase = (PSSysSearchBarLogicBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSearchBarLogicService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
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
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINID, 18);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINNAME, 19);
        fieldIndexMap.put(FIELD_PSSYSSEARCHBARID, 20);
        fieldIndexMap.put(FIELD_PSSYSSEARCHBARITEMID, 21);
        fieldIndexMap.put(FIELD_PSSYSSEARCHBARITEMNAME, 22);
        fieldIndexMap.put(FIELD_PSSYSSEARCHBARLOGICID, 23);
        fieldIndexMap.put(FIELD_PSSYSSEARCHBARLOGICNAME, 24);
        fieldIndexMap.put(FIELD_PSSYSSEARCHBARNAME, 25);
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

