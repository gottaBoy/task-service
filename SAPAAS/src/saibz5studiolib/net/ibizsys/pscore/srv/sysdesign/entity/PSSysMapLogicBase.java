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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysMapItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysMapView;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewLogic;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanel;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMapItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMapViewService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewLogicService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysMapLogicBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysMapLogicBase.class);
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
    public static final String FIELD_PSSYSMAPITEMID = "PSSYSMAPITEMID";
    public static final String FIELD_PSSYSMAPITEMNAME = "PSSYSMAPITEMNAME";
    public static final String FIELD_PSSYSMAPLOGICID = "PSSYSMAPLOGICID";
    public static final String FIELD_PSSYSMAPLOGICNAME = "PSSYSMAPLOGICNAME";
    public static final String FIELD_PSSYSMAPVIEWID = "PSSYSMAPVIEWID";
    public static final String FIELD_PSSYSMAPVIEWNAME = "PSSYSMAPVIEWNAME";
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
    private static final int INDEX_PSSYSMAPITEMID = 18;
    private static final int INDEX_PSSYSMAPITEMNAME = 19;
    private static final int INDEX_PSSYSMAPLOGICID = 20;
    private static final int INDEX_PSSYSMAPLOGICNAME = 21;
    private static final int INDEX_PSSYSMAPVIEWID = 22;
    private static final int INDEX_PSSYSMAPVIEWNAME = 23;
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
    private PSSysMapLogicBase proxyPSSysMapLogicBase = null;
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
    private boolean pssysmapitemidDirtyFlag = false;
    private boolean pssysmapitemnameDirtyFlag = false;
    private boolean pssysmaplogicidDirtyFlag = false;
    private boolean pssysmaplogicnameDirtyFlag = false;
    private boolean pssysmapviewidDirtyFlag = false;
    private boolean pssysmapviewnameDirtyFlag = false;
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
    @Column(name="pssysmapitemid")
    private String pssysmapitemid;
    @Column(name="pssysmapitemname")
    private String pssysmapitemname;
    @Column(name="pssysmaplogicid")
    private String pssysmaplogicid;
    @Column(name="pssysmaplogicname")
    private String pssysmaplogicname;
    @Column(name="pssysmapviewid")
    private String pssysmapviewid;
    @Column(name="pssysmapviewname")
    private String pssysmapviewname;
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
    private Integer objPSSysMapItemLock = new Integer(1);
    private PSSysMapItem pssysmapitem = null;
    private Integer objPSSysMapViewLock = new Integer(1);
    private PSSysMapView pssysmapview = null;
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

    public void setPSSysMapItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysMapItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmapitemid = string;
        this.pssysmapitemidDirtyFlag = true;
    }

    public String getPSSysMapItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysMapItemId();
        }
        return this.pssysmapitemid;
    }

    public boolean isPSSysMapItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysMapItemIdDirty();
        }
        return this.pssysmapitemidDirtyFlag;
    }

    public void resetPSSysMapItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysMapItemId();
            return;
        }
        this.pssysmapitemidDirtyFlag = false;
        this.pssysmapitemid = null;
    }

    public void setPSSysMapItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysMapItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmapitemname = string;
        this.pssysmapitemnameDirtyFlag = true;
    }

    public String getPSSysMapItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysMapItemName();
        }
        return this.pssysmapitemname;
    }

    public boolean isPSSysMapItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysMapItemNameDirty();
        }
        return this.pssysmapitemnameDirtyFlag;
    }

    public void resetPSSysMapItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysMapItemName();
            return;
        }
        this.pssysmapitemnameDirtyFlag = false;
        this.pssysmapitemname = null;
    }

    public void setPSSysMapLogicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysMapLogicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmaplogicid = string;
        this.pssysmaplogicidDirtyFlag = true;
    }

    public String getPSSysMapLogicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysMapLogicId();
        }
        return this.pssysmaplogicid;
    }

    public boolean isPSSysMapLogicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysMapLogicIdDirty();
        }
        return this.pssysmaplogicidDirtyFlag;
    }

    public void resetPSSysMapLogicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysMapLogicId();
            return;
        }
        this.pssysmaplogicidDirtyFlag = false;
        this.pssysmaplogicid = null;
    }

    public void setPSSysMapLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysMapLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmaplogicname = string;
        this.pssysmaplogicnameDirtyFlag = true;
    }

    public String getPSSysMapLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysMapLogicName();
        }
        return this.pssysmaplogicname;
    }

    public boolean isPSSysMapLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysMapLogicNameDirty();
        }
        return this.pssysmaplogicnameDirtyFlag;
    }

    public void resetPSSysMapLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysMapLogicName();
            return;
        }
        this.pssysmaplogicnameDirtyFlag = false;
        this.pssysmaplogicname = null;
    }

    public void setPSSysMapViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysMapViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmapviewid = string;
        this.pssysmapviewidDirtyFlag = true;
    }

    public String getPSSysMapViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysMapViewId();
        }
        return this.pssysmapviewid;
    }

    public boolean isPSSysMapViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysMapViewIdDirty();
        }
        return this.pssysmapviewidDirtyFlag;
    }

    public void resetPSSysMapViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysMapViewId();
            return;
        }
        this.pssysmapviewidDirtyFlag = false;
        this.pssysmapviewid = null;
    }

    public void setPSSysMapViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysMapViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmapviewname = string;
        this.pssysmapviewnameDirtyFlag = true;
    }

    public String getPSSysMapViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysMapViewName();
        }
        return this.pssysmapviewname;
    }

    public boolean isPSSysMapViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysMapViewNameDirty();
        }
        return this.pssysmapviewnameDirtyFlag;
    }

    public void resetPSSysMapViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysMapViewName();
            return;
        }
        this.pssysmapviewnameDirtyFlag = false;
        this.pssysmapviewname = null;
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
        PSSysMapLogicBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysMapLogicBase pSSysMapLogicBase) {
        pSSysMapLogicBase.resetAttrName();
        pSSysMapLogicBase.resetCreateDate();
        pSSysMapLogicBase.resetCreateMan();
        pSSysMapLogicBase.resetCustomCode();
        pSSysMapLogicBase.resetDstLogicType();
        pSSysMapLogicBase.resetEventArg();
        pSSysMapLogicBase.resetEventArg2();
        pSSysMapLogicBase.resetEventNames();
        pSSysMapLogicBase.resetLogicParam();
        pSSysMapLogicBase.resetLogicParam2();
        pSSysMapLogicBase.resetMemo();
        pSSysMapLogicBase.resetOrderValue();
        pSSysMapLogicBase.resetPSDEId();
        pSSysMapLogicBase.resetPSDELogicId();
        pSSysMapLogicBase.resetPSDELogicName();
        pSSysMapLogicBase.resetPSDEName();
        pSSysMapLogicBase.resetPSDEUIActionId();
        pSSysMapLogicBase.resetPSDEUIActionName();
        pSSysMapLogicBase.resetPSSysMapItemId();
        pSSysMapLogicBase.resetPSSysMapItemName();
        pSSysMapLogicBase.resetPSSysMapLogicId();
        pSSysMapLogicBase.resetPSSysMapLogicName();
        pSSysMapLogicBase.resetPSSysMapViewId();
        pSSysMapLogicBase.resetPSSysMapViewName();
        pSSysMapLogicBase.resetPSSysPFPluginId();
        pSSysMapLogicBase.resetPSSysPFPluginName();
        pSSysMapLogicBase.resetPSSysViewLogicId();
        pSSysMapLogicBase.resetPSSysViewLogicName();
        pSSysMapLogicBase.resetPSSysViewPanelId();
        pSSysMapLogicBase.resetPSSysViewPanelName();
        pSSysMapLogicBase.resetTimer();
        pSSysMapLogicBase.resetTriggerType();
        pSSysMapLogicBase.resetUpdateDate();
        pSSysMapLogicBase.resetUpdateMan();
        pSSysMapLogicBase.resetUserCat();
        pSSysMapLogicBase.resetUserTag();
        pSSysMapLogicBase.resetUserTag2();
        pSSysMapLogicBase.resetUserTag3();
        pSSysMapLogicBase.resetUserTag4();
        pSSysMapLogicBase.resetValidFlag();
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
        if (!bl || this.isPSSysMapItemIdDirty()) {
            hashMap.put(FIELD_PSSYSMAPITEMID, this.getPSSysMapItemId());
        }
        if (!bl || this.isPSSysMapItemNameDirty()) {
            hashMap.put(FIELD_PSSYSMAPITEMNAME, this.getPSSysMapItemName());
        }
        if (!bl || this.isPSSysMapLogicIdDirty()) {
            hashMap.put(FIELD_PSSYSMAPLOGICID, this.getPSSysMapLogicId());
        }
        if (!bl || this.isPSSysMapLogicNameDirty()) {
            hashMap.put(FIELD_PSSYSMAPLOGICNAME, this.getPSSysMapLogicName());
        }
        if (!bl || this.isPSSysMapViewIdDirty()) {
            hashMap.put(FIELD_PSSYSMAPVIEWID, this.getPSSysMapViewId());
        }
        if (!bl || this.isPSSysMapViewNameDirty()) {
            hashMap.put(FIELD_PSSYSMAPVIEWNAME, this.getPSSysMapViewName());
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
        return PSSysMapLogicBase.get(this, n);
    }

    private static Object get(PSSysMapLogicBase pSSysMapLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysMapLogicBase.getAttrName();
            }
            case 1: {
                return pSSysMapLogicBase.getCreateDate();
            }
            case 2: {
                return pSSysMapLogicBase.getCreateMan();
            }
            case 3: {
                return pSSysMapLogicBase.getCustomCode();
            }
            case 4: {
                return pSSysMapLogicBase.getDstLogicType();
            }
            case 5: {
                return pSSysMapLogicBase.getEventArg();
            }
            case 6: {
                return pSSysMapLogicBase.getEventArg2();
            }
            case 7: {
                return pSSysMapLogicBase.getEventNames();
            }
            case 8: {
                return pSSysMapLogicBase.getLogicParam();
            }
            case 9: {
                return pSSysMapLogicBase.getLogicParam2();
            }
            case 10: {
                return pSSysMapLogicBase.getMemo();
            }
            case 11: {
                return pSSysMapLogicBase.getOrderValue();
            }
            case 12: {
                return pSSysMapLogicBase.getPSDEId();
            }
            case 13: {
                return pSSysMapLogicBase.getPSDELogicId();
            }
            case 14: {
                return pSSysMapLogicBase.getPSDELogicName();
            }
            case 15: {
                return pSSysMapLogicBase.getPSDEName();
            }
            case 16: {
                return pSSysMapLogicBase.getPSDEUIActionId();
            }
            case 17: {
                return pSSysMapLogicBase.getPSDEUIActionName();
            }
            case 18: {
                return pSSysMapLogicBase.getPSSysMapItemId();
            }
            case 19: {
                return pSSysMapLogicBase.getPSSysMapItemName();
            }
            case 20: {
                return pSSysMapLogicBase.getPSSysMapLogicId();
            }
            case 21: {
                return pSSysMapLogicBase.getPSSysMapLogicName();
            }
            case 22: {
                return pSSysMapLogicBase.getPSSysMapViewId();
            }
            case 23: {
                return pSSysMapLogicBase.getPSSysMapViewName();
            }
            case 24: {
                return pSSysMapLogicBase.getPSSysPFPluginId();
            }
            case 25: {
                return pSSysMapLogicBase.getPSSysPFPluginName();
            }
            case 26: {
                return pSSysMapLogicBase.getPSSysViewLogicId();
            }
            case 27: {
                return pSSysMapLogicBase.getPSSysViewLogicName();
            }
            case 28: {
                return pSSysMapLogicBase.getPSSysViewPanelId();
            }
            case 29: {
                return pSSysMapLogicBase.getPSSysViewPanelName();
            }
            case 30: {
                return pSSysMapLogicBase.getTimer();
            }
            case 31: {
                return pSSysMapLogicBase.getTriggerType();
            }
            case 32: {
                return pSSysMapLogicBase.getUpdateDate();
            }
            case 33: {
                return pSSysMapLogicBase.getUpdateMan();
            }
            case 34: {
                return pSSysMapLogicBase.getUserCat();
            }
            case 35: {
                return pSSysMapLogicBase.getUserTag();
            }
            case 36: {
                return pSSysMapLogicBase.getUserTag2();
            }
            case 37: {
                return pSSysMapLogicBase.getUserTag3();
            }
            case 38: {
                return pSSysMapLogicBase.getUserTag4();
            }
            case 39: {
                return pSSysMapLogicBase.getValidFlag();
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
        PSSysMapLogicBase.set(this, n, object);
    }

    private static void set(PSSysMapLogicBase pSSysMapLogicBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysMapLogicBase.setAttrName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysMapLogicBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysMapLogicBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysMapLogicBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysMapLogicBase.setDstLogicType(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysMapLogicBase.setEventArg(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysMapLogicBase.setEventArg2(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysMapLogicBase.setEventNames(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysMapLogicBase.setLogicParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysMapLogicBase.setLogicParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysMapLogicBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysMapLogicBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSSysMapLogicBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysMapLogicBase.setPSDELogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysMapLogicBase.setPSDELogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysMapLogicBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysMapLogicBase.setPSDEUIActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysMapLogicBase.setPSDEUIActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysMapLogicBase.setPSSysMapItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysMapLogicBase.setPSSysMapItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysMapLogicBase.setPSSysMapLogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysMapLogicBase.setPSSysMapLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysMapLogicBase.setPSSysMapViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysMapLogicBase.setPSSysMapViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysMapLogicBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysMapLogicBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysMapLogicBase.setPSSysViewLogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysMapLogicBase.setPSSysViewLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysMapLogicBase.setPSSysViewPanelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSysMapLogicBase.setPSSysViewPanelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSysMapLogicBase.setTimer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 31: {
                pSSysMapLogicBase.setTriggerType(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSysMapLogicBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 33: {
                pSSysMapLogicBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSSysMapLogicBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSSysMapLogicBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSSysMapLogicBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSSysMapLogicBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSSysMapLogicBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSSysMapLogicBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSysMapLogicBase.isNull(this, n);
    }

    private static boolean isNull(PSSysMapLogicBase pSSysMapLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysMapLogicBase.getAttrName() == null;
            }
            case 1: {
                return pSSysMapLogicBase.getCreateDate() == null;
            }
            case 2: {
                return pSSysMapLogicBase.getCreateMan() == null;
            }
            case 3: {
                return pSSysMapLogicBase.getCustomCode() == null;
            }
            case 4: {
                return pSSysMapLogicBase.getDstLogicType() == null;
            }
            case 5: {
                return pSSysMapLogicBase.getEventArg() == null;
            }
            case 6: {
                return pSSysMapLogicBase.getEventArg2() == null;
            }
            case 7: {
                return pSSysMapLogicBase.getEventNames() == null;
            }
            case 8: {
                return pSSysMapLogicBase.getLogicParam() == null;
            }
            case 9: {
                return pSSysMapLogicBase.getLogicParam2() == null;
            }
            case 10: {
                return pSSysMapLogicBase.getMemo() == null;
            }
            case 11: {
                return pSSysMapLogicBase.getOrderValue() == null;
            }
            case 12: {
                return pSSysMapLogicBase.getPSDEId() == null;
            }
            case 13: {
                return pSSysMapLogicBase.getPSDELogicId() == null;
            }
            case 14: {
                return pSSysMapLogicBase.getPSDELogicName() == null;
            }
            case 15: {
                return pSSysMapLogicBase.getPSDEName() == null;
            }
            case 16: {
                return pSSysMapLogicBase.getPSDEUIActionId() == null;
            }
            case 17: {
                return pSSysMapLogicBase.getPSDEUIActionName() == null;
            }
            case 18: {
                return pSSysMapLogicBase.getPSSysMapItemId() == null;
            }
            case 19: {
                return pSSysMapLogicBase.getPSSysMapItemName() == null;
            }
            case 20: {
                return pSSysMapLogicBase.getPSSysMapLogicId() == null;
            }
            case 21: {
                return pSSysMapLogicBase.getPSSysMapLogicName() == null;
            }
            case 22: {
                return pSSysMapLogicBase.getPSSysMapViewId() == null;
            }
            case 23: {
                return pSSysMapLogicBase.getPSSysMapViewName() == null;
            }
            case 24: {
                return pSSysMapLogicBase.getPSSysPFPluginId() == null;
            }
            case 25: {
                return pSSysMapLogicBase.getPSSysPFPluginName() == null;
            }
            case 26: {
                return pSSysMapLogicBase.getPSSysViewLogicId() == null;
            }
            case 27: {
                return pSSysMapLogicBase.getPSSysViewLogicName() == null;
            }
            case 28: {
                return pSSysMapLogicBase.getPSSysViewPanelId() == null;
            }
            case 29: {
                return pSSysMapLogicBase.getPSSysViewPanelName() == null;
            }
            case 30: {
                return pSSysMapLogicBase.getTimer() == null;
            }
            case 31: {
                return pSSysMapLogicBase.getTriggerType() == null;
            }
            case 32: {
                return pSSysMapLogicBase.getUpdateDate() == null;
            }
            case 33: {
                return pSSysMapLogicBase.getUpdateMan() == null;
            }
            case 34: {
                return pSSysMapLogicBase.getUserCat() == null;
            }
            case 35: {
                return pSSysMapLogicBase.getUserTag() == null;
            }
            case 36: {
                return pSSysMapLogicBase.getUserTag2() == null;
            }
            case 37: {
                return pSSysMapLogicBase.getUserTag3() == null;
            }
            case 38: {
                return pSSysMapLogicBase.getUserTag4() == null;
            }
            case 39: {
                return pSSysMapLogicBase.getValidFlag() == null;
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
        return PSSysMapLogicBase.contains(this, n);
    }

    private static boolean contains(PSSysMapLogicBase pSSysMapLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysMapLogicBase.isAttrNameDirty();
            }
            case 1: {
                return pSSysMapLogicBase.isCreateDateDirty();
            }
            case 2: {
                return pSSysMapLogicBase.isCreateManDirty();
            }
            case 3: {
                return pSSysMapLogicBase.isCustomCodeDirty();
            }
            case 4: {
                return pSSysMapLogicBase.isDstLogicTypeDirty();
            }
            case 5: {
                return pSSysMapLogicBase.isEventArgDirty();
            }
            case 6: {
                return pSSysMapLogicBase.isEventArg2Dirty();
            }
            case 7: {
                return pSSysMapLogicBase.isEventNamesDirty();
            }
            case 8: {
                return pSSysMapLogicBase.isLogicParamDirty();
            }
            case 9: {
                return pSSysMapLogicBase.isLogicParam2Dirty();
            }
            case 10: {
                return pSSysMapLogicBase.isMemoDirty();
            }
            case 11: {
                return pSSysMapLogicBase.isOrderValueDirty();
            }
            case 12: {
                return pSSysMapLogicBase.isPSDEIdDirty();
            }
            case 13: {
                return pSSysMapLogicBase.isPSDELogicIdDirty();
            }
            case 14: {
                return pSSysMapLogicBase.isPSDELogicNameDirty();
            }
            case 15: {
                return pSSysMapLogicBase.isPSDENameDirty();
            }
            case 16: {
                return pSSysMapLogicBase.isPSDEUIActionIdDirty();
            }
            case 17: {
                return pSSysMapLogicBase.isPSDEUIActionNameDirty();
            }
            case 18: {
                return pSSysMapLogicBase.isPSSysMapItemIdDirty();
            }
            case 19: {
                return pSSysMapLogicBase.isPSSysMapItemNameDirty();
            }
            case 20: {
                return pSSysMapLogicBase.isPSSysMapLogicIdDirty();
            }
            case 21: {
                return pSSysMapLogicBase.isPSSysMapLogicNameDirty();
            }
            case 22: {
                return pSSysMapLogicBase.isPSSysMapViewIdDirty();
            }
            case 23: {
                return pSSysMapLogicBase.isPSSysMapViewNameDirty();
            }
            case 24: {
                return pSSysMapLogicBase.isPSSysPFPluginIdDirty();
            }
            case 25: {
                return pSSysMapLogicBase.isPSSysPFPluginNameDirty();
            }
            case 26: {
                return pSSysMapLogicBase.isPSSysViewLogicIdDirty();
            }
            case 27: {
                return pSSysMapLogicBase.isPSSysViewLogicNameDirty();
            }
            case 28: {
                return pSSysMapLogicBase.isPSSysViewPanelIdDirty();
            }
            case 29: {
                return pSSysMapLogicBase.isPSSysViewPanelNameDirty();
            }
            case 30: {
                return pSSysMapLogicBase.isTimerDirty();
            }
            case 31: {
                return pSSysMapLogicBase.isTriggerTypeDirty();
            }
            case 32: {
                return pSSysMapLogicBase.isUpdateDateDirty();
            }
            case 33: {
                return pSSysMapLogicBase.isUpdateManDirty();
            }
            case 34: {
                return pSSysMapLogicBase.isUserCatDirty();
            }
            case 35: {
                return pSSysMapLogicBase.isUserTagDirty();
            }
            case 36: {
                return pSSysMapLogicBase.isUserTag2Dirty();
            }
            case 37: {
                return pSSysMapLogicBase.isUserTag3Dirty();
            }
            case 38: {
                return pSSysMapLogicBase.isUserTag4Dirty();
            }
            case 39: {
                return pSSysMapLogicBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysMapLogicBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysMapLogicBase pSSysMapLogicBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysMapLogicBase.getAttrName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"attrname", (Object)PSSysMapLogicBase.getJSONValue((Object)pSSysMapLogicBase.getAttrName()), (boolean)false);
        }
        if (bl || pSSysMapLogicBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysMapLogicBase.getJSONValue((Object)pSSysMapLogicBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysMapLogicBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysMapLogicBase.getJSONValue((Object)pSSysMapLogicBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysMapLogicBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSSysMapLogicBase.getJSONValue((Object)pSSysMapLogicBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSSysMapLogicBase.getDstLogicType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstlogictype", (Object)PSSysMapLogicBase.getJSONValue((Object)pSSysMapLogicBase.getDstLogicType()), (boolean)false);
        }
        if (bl || pSSysMapLogicBase.getEventArg() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eventarg", (Object)PSSysMapLogicBase.getJSONValue((Object)pSSysMapLogicBase.getEventArg()), (boolean)false);
        }
        if (bl || pSSysMapLogicBase.getEventArg2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eventarg2", (Object)PSSysMapLogicBase.getJSONValue((Object)pSSysMapLogicBase.getEventArg2()), (boolean)false);
        }
        if (bl || pSSysMapLogicBase.getEventNames() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eventnames", (Object)PSSysMapLogicBase.getJSONValue((Object)pSSysMapLogicBase.getEventNames()), (boolean)false);
        }
        if (bl || pSSysMapLogicBase.getLogicParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicparam", (Object)PSSysMapLogicBase.getJSONValue((Object)pSSysMapLogicBase.getLogicParam()), (boolean)false);
        }
        if (bl || pSSysMapLogicBase.getLogicParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicparam2", (Object)PSSysMapLogicBase.getJSONValue((Object)pSSysMapLogicBase.getLogicParam2()), (boolean)false);
        }
        if (bl || pSSysMapLogicBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysMapLogicBase.getJSONValue((Object)pSSysMapLogicBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysMapLogicBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSysMapLogicBase.getJSONValue((Object)pSSysMapLogicBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSysMapLogicBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSSysMapLogicBase.getJSONValue((Object)pSSysMapLogicBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSSysMapLogicBase.getPSDELogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicid", (Object)PSSysMapLogicBase.getJSONValue((Object)pSSysMapLogicBase.getPSDELogicId()), (boolean)false);
        }
        if (bl || pSSysMapLogicBase.getPSDELogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicname", (Object)PSSysMapLogicBase.getJSONValue((Object)pSSysMapLogicBase.getPSDELogicName()), (boolean)false);
        }
        if (bl || pSSysMapLogicBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSSysMapLogicBase.getJSONValue((Object)pSSysMapLogicBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSSysMapLogicBase.getPSDEUIActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuiactionid", (Object)PSSysMapLogicBase.getJSONValue((Object)pSSysMapLogicBase.getPSDEUIActionId()), (boolean)false);
        }
        if (bl || pSSysMapLogicBase.getPSDEUIActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuiactionname", (Object)PSSysMapLogicBase.getJSONValue((Object)pSSysMapLogicBase.getPSDEUIActionName()), (boolean)false);
        }
        if (bl || pSSysMapLogicBase.getPSSysMapItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmapitemid", (Object)PSSysMapLogicBase.getJSONValue((Object)pSSysMapLogicBase.getPSSysMapItemId()), (boolean)false);
        }
        if (bl || pSSysMapLogicBase.getPSSysMapItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmapitemname", (Object)PSSysMapLogicBase.getJSONValue((Object)pSSysMapLogicBase.getPSSysMapItemName()), (boolean)false);
        }
        if (bl || pSSysMapLogicBase.getPSSysMapLogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmaplogicid", (Object)PSSysMapLogicBase.getJSONValue((Object)pSSysMapLogicBase.getPSSysMapLogicId()), (boolean)false);
        }
        if (bl || pSSysMapLogicBase.getPSSysMapLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmaplogicname", (Object)PSSysMapLogicBase.getJSONValue((Object)pSSysMapLogicBase.getPSSysMapLogicName()), (boolean)false);
        }
        if (bl || pSSysMapLogicBase.getPSSysMapViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmapviewid", (Object)PSSysMapLogicBase.getJSONValue((Object)pSSysMapLogicBase.getPSSysMapViewId()), (boolean)false);
        }
        if (bl || pSSysMapLogicBase.getPSSysMapViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmapviewname", (Object)PSSysMapLogicBase.getJSONValue((Object)pSSysMapLogicBase.getPSSysMapViewName()), (boolean)false);
        }
        if (bl || pSSysMapLogicBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSSysMapLogicBase.getJSONValue((Object)pSSysMapLogicBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSSysMapLogicBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSSysMapLogicBase.getJSONValue((Object)pSSysMapLogicBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSSysMapLogicBase.getPSSysViewLogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewlogicid", (Object)PSSysMapLogicBase.getJSONValue((Object)pSSysMapLogicBase.getPSSysViewLogicId()), (boolean)false);
        }
        if (bl || pSSysMapLogicBase.getPSSysViewLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewlogicname", (Object)PSSysMapLogicBase.getJSONValue((Object)pSSysMapLogicBase.getPSSysViewLogicName()), (boolean)false);
        }
        if (bl || pSSysMapLogicBase.getPSSysViewPanelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelid", (Object)PSSysMapLogicBase.getJSONValue((Object)pSSysMapLogicBase.getPSSysViewPanelId()), (boolean)false);
        }
        if (bl || pSSysMapLogicBase.getPSSysViewPanelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelname", (Object)PSSysMapLogicBase.getJSONValue((Object)pSSysMapLogicBase.getPSSysViewPanelName()), (boolean)false);
        }
        if (bl || pSSysMapLogicBase.getTimer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"timer", (Object)PSSysMapLogicBase.getJSONValue((Object)pSSysMapLogicBase.getTimer()), (boolean)false);
        }
        if (bl || pSSysMapLogicBase.getTriggerType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"triggertype", (Object)PSSysMapLogicBase.getJSONValue((Object)pSSysMapLogicBase.getTriggerType()), (boolean)false);
        }
        if (bl || pSSysMapLogicBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysMapLogicBase.getJSONValue((Object)pSSysMapLogicBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysMapLogicBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysMapLogicBase.getJSONValue((Object)pSSysMapLogicBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysMapLogicBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysMapLogicBase.getJSONValue((Object)pSSysMapLogicBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysMapLogicBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysMapLogicBase.getJSONValue((Object)pSSysMapLogicBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysMapLogicBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysMapLogicBase.getJSONValue((Object)pSSysMapLogicBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysMapLogicBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysMapLogicBase.getJSONValue((Object)pSSysMapLogicBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysMapLogicBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysMapLogicBase.getJSONValue((Object)pSSysMapLogicBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysMapLogicBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysMapLogicBase.getJSONValue((Object)pSSysMapLogicBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysMapLogicBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysMapLogicBase pSSysMapLogicBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysMapLogicBase.getAttrName() != null) {
            object = pSSysMapLogicBase.getAttrName();
            xmlNode.setAttribute(FIELD_ATTRNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapLogicBase.getCreateDate() != null) {
            object = pSSysMapLogicBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysMapLogicBase.getCreateMan() != null) {
            object = pSSysMapLogicBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapLogicBase.getCustomCode() != null) {
            object = pSSysMapLogicBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapLogicBase.getDstLogicType() != null) {
            object = pSSysMapLogicBase.getDstLogicType();
            xmlNode.setAttribute(FIELD_DSTLOGICTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapLogicBase.getEventArg() != null) {
            object = pSSysMapLogicBase.getEventArg();
            xmlNode.setAttribute(FIELD_EVENTARG, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapLogicBase.getEventArg2() != null) {
            object = pSSysMapLogicBase.getEventArg2();
            xmlNode.setAttribute(FIELD_EVENTARG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapLogicBase.getEventNames() != null) {
            object = pSSysMapLogicBase.getEventNames();
            xmlNode.setAttribute(FIELD_EVENTNAMES, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapLogicBase.getLogicParam() != null) {
            object = pSSysMapLogicBase.getLogicParam();
            xmlNode.setAttribute(FIELD_LOGICPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapLogicBase.getLogicParam2() != null) {
            object = pSSysMapLogicBase.getLogicParam2();
            xmlNode.setAttribute(FIELD_LOGICPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapLogicBase.getMemo() != null) {
            object = pSSysMapLogicBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapLogicBase.getOrderValue() != null) {
            object = pSSysMapLogicBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysMapLogicBase.getPSDEId() != null) {
            object = pSSysMapLogicBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapLogicBase.getPSDELogicId() != null) {
            object = pSSysMapLogicBase.getPSDELogicId();
            xmlNode.setAttribute(FIELD_PSDELOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapLogicBase.getPSDELogicName() != null) {
            object = pSSysMapLogicBase.getPSDELogicName();
            xmlNode.setAttribute(FIELD_PSDELOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapLogicBase.getPSDEName() != null) {
            object = pSSysMapLogicBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapLogicBase.getPSDEUIActionId() != null) {
            object = pSSysMapLogicBase.getPSDEUIActionId();
            xmlNode.setAttribute(FIELD_PSDEUIACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapLogicBase.getPSDEUIActionName() != null) {
            object = pSSysMapLogicBase.getPSDEUIActionName();
            xmlNode.setAttribute(FIELD_PSDEUIACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapLogicBase.getPSSysMapItemId() != null) {
            object = pSSysMapLogicBase.getPSSysMapItemId();
            xmlNode.setAttribute(FIELD_PSSYSMAPITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapLogicBase.getPSSysMapItemName() != null) {
            object = pSSysMapLogicBase.getPSSysMapItemName();
            xmlNode.setAttribute(FIELD_PSSYSMAPITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapLogicBase.getPSSysMapLogicId() != null) {
            object = pSSysMapLogicBase.getPSSysMapLogicId();
            xmlNode.setAttribute(FIELD_PSSYSMAPLOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapLogicBase.getPSSysMapLogicName() != null) {
            object = pSSysMapLogicBase.getPSSysMapLogicName();
            xmlNode.setAttribute(FIELD_PSSYSMAPLOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapLogicBase.getPSSysMapViewId() != null) {
            object = pSSysMapLogicBase.getPSSysMapViewId();
            xmlNode.setAttribute(FIELD_PSSYSMAPVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapLogicBase.getPSSysMapViewName() != null) {
            object = pSSysMapLogicBase.getPSSysMapViewName();
            xmlNode.setAttribute(FIELD_PSSYSMAPVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapLogicBase.getPSSysPFPluginId() != null) {
            object = pSSysMapLogicBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapLogicBase.getPSSysPFPluginName() != null) {
            object = pSSysMapLogicBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapLogicBase.getPSSysViewLogicId() != null) {
            object = pSSysMapLogicBase.getPSSysViewLogicId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWLOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapLogicBase.getPSSysViewLogicName() != null) {
            object = pSSysMapLogicBase.getPSSysViewLogicName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWLOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapLogicBase.getPSSysViewPanelId() != null) {
            object = pSSysMapLogicBase.getPSSysViewPanelId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapLogicBase.getPSSysViewPanelName() != null) {
            object = pSSysMapLogicBase.getPSSysViewPanelName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapLogicBase.getTimer() != null) {
            object = pSSysMapLogicBase.getTimer();
            xmlNode.setAttribute(FIELD_TIMER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysMapLogicBase.getTriggerType() != null) {
            object = pSSysMapLogicBase.getTriggerType();
            xmlNode.setAttribute(FIELD_TRIGGERTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapLogicBase.getUpdateDate() != null) {
            object = pSSysMapLogicBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysMapLogicBase.getUpdateMan() != null) {
            object = pSSysMapLogicBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapLogicBase.getUserCat() != null) {
            object = pSSysMapLogicBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapLogicBase.getUserTag() != null) {
            object = pSSysMapLogicBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapLogicBase.getUserTag2() != null) {
            object = pSSysMapLogicBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapLogicBase.getUserTag3() != null) {
            object = pSSysMapLogicBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapLogicBase.getUserTag4() != null) {
            object = pSSysMapLogicBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysMapLogicBase.getValidFlag() != null) {
            object = pSSysMapLogicBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysMapLogicBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysMapLogicBase pSSysMapLogicBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysMapLogicBase.isAttrNameDirty() && (bl || pSSysMapLogicBase.getAttrName() != null)) {
            iDataObject.set(FIELD_ATTRNAME, (Object)pSSysMapLogicBase.getAttrName());
        }
        if (pSSysMapLogicBase.isCreateDateDirty() && (bl || pSSysMapLogicBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysMapLogicBase.getCreateDate());
        }
        if (pSSysMapLogicBase.isCreateManDirty() && (bl || pSSysMapLogicBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysMapLogicBase.getCreateMan());
        }
        if (pSSysMapLogicBase.isCustomCodeDirty() && (bl || pSSysMapLogicBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSSysMapLogicBase.getCustomCode());
        }
        if (pSSysMapLogicBase.isDstLogicTypeDirty() && (bl || pSSysMapLogicBase.getDstLogicType() != null)) {
            iDataObject.set(FIELD_DSTLOGICTYPE, (Object)pSSysMapLogicBase.getDstLogicType());
        }
        if (pSSysMapLogicBase.isEventArgDirty() && (bl || pSSysMapLogicBase.getEventArg() != null)) {
            iDataObject.set(FIELD_EVENTARG, (Object)pSSysMapLogicBase.getEventArg());
        }
        if (pSSysMapLogicBase.isEventArg2Dirty() && (bl || pSSysMapLogicBase.getEventArg2() != null)) {
            iDataObject.set(FIELD_EVENTARG2, (Object)pSSysMapLogicBase.getEventArg2());
        }
        if (pSSysMapLogicBase.isEventNamesDirty() && (bl || pSSysMapLogicBase.getEventNames() != null)) {
            iDataObject.set(FIELD_EVENTNAMES, (Object)pSSysMapLogicBase.getEventNames());
        }
        if (pSSysMapLogicBase.isLogicParamDirty() && (bl || pSSysMapLogicBase.getLogicParam() != null)) {
            iDataObject.set(FIELD_LOGICPARAM, (Object)pSSysMapLogicBase.getLogicParam());
        }
        if (pSSysMapLogicBase.isLogicParam2Dirty() && (bl || pSSysMapLogicBase.getLogicParam2() != null)) {
            iDataObject.set(FIELD_LOGICPARAM2, (Object)pSSysMapLogicBase.getLogicParam2());
        }
        if (pSSysMapLogicBase.isMemoDirty() && (bl || pSSysMapLogicBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysMapLogicBase.getMemo());
        }
        if (pSSysMapLogicBase.isOrderValueDirty() && (bl || pSSysMapLogicBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSysMapLogicBase.getOrderValue());
        }
        if (pSSysMapLogicBase.isPSDEIdDirty() && (bl || pSSysMapLogicBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSSysMapLogicBase.getPSDEId());
        }
        if (pSSysMapLogicBase.isPSDELogicIdDirty() && (bl || pSSysMapLogicBase.getPSDELogicId() != null)) {
            iDataObject.set(FIELD_PSDELOGICID, (Object)pSSysMapLogicBase.getPSDELogicId());
        }
        if (pSSysMapLogicBase.isPSDELogicNameDirty() && (bl || pSSysMapLogicBase.getPSDELogicName() != null)) {
            iDataObject.set(FIELD_PSDELOGICNAME, (Object)pSSysMapLogicBase.getPSDELogicName());
        }
        if (pSSysMapLogicBase.isPSDENameDirty() && (bl || pSSysMapLogicBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSSysMapLogicBase.getPSDEName());
        }
        if (pSSysMapLogicBase.isPSDEUIActionIdDirty() && (bl || pSSysMapLogicBase.getPSDEUIActionId() != null)) {
            iDataObject.set(FIELD_PSDEUIACTIONID, (Object)pSSysMapLogicBase.getPSDEUIActionId());
        }
        if (pSSysMapLogicBase.isPSDEUIActionNameDirty() && (bl || pSSysMapLogicBase.getPSDEUIActionName() != null)) {
            iDataObject.set(FIELD_PSDEUIACTIONNAME, (Object)pSSysMapLogicBase.getPSDEUIActionName());
        }
        if (pSSysMapLogicBase.isPSSysMapItemIdDirty() && (bl || pSSysMapLogicBase.getPSSysMapItemId() != null)) {
            iDataObject.set(FIELD_PSSYSMAPITEMID, (Object)pSSysMapLogicBase.getPSSysMapItemId());
        }
        if (pSSysMapLogicBase.isPSSysMapItemNameDirty() && (bl || pSSysMapLogicBase.getPSSysMapItemName() != null)) {
            iDataObject.set(FIELD_PSSYSMAPITEMNAME, (Object)pSSysMapLogicBase.getPSSysMapItemName());
        }
        if (pSSysMapLogicBase.isPSSysMapLogicIdDirty() && (bl || pSSysMapLogicBase.getPSSysMapLogicId() != null)) {
            iDataObject.set(FIELD_PSSYSMAPLOGICID, (Object)pSSysMapLogicBase.getPSSysMapLogicId());
        }
        if (pSSysMapLogicBase.isPSSysMapLogicNameDirty() && (bl || pSSysMapLogicBase.getPSSysMapLogicName() != null)) {
            iDataObject.set(FIELD_PSSYSMAPLOGICNAME, (Object)pSSysMapLogicBase.getPSSysMapLogicName());
        }
        if (pSSysMapLogicBase.isPSSysMapViewIdDirty() && (bl || pSSysMapLogicBase.getPSSysMapViewId() != null)) {
            iDataObject.set(FIELD_PSSYSMAPVIEWID, (Object)pSSysMapLogicBase.getPSSysMapViewId());
        }
        if (pSSysMapLogicBase.isPSSysMapViewNameDirty() && (bl || pSSysMapLogicBase.getPSSysMapViewName() != null)) {
            iDataObject.set(FIELD_PSSYSMAPVIEWNAME, (Object)pSSysMapLogicBase.getPSSysMapViewName());
        }
        if (pSSysMapLogicBase.isPSSysPFPluginIdDirty() && (bl || pSSysMapLogicBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSSysMapLogicBase.getPSSysPFPluginId());
        }
        if (pSSysMapLogicBase.isPSSysPFPluginNameDirty() && (bl || pSSysMapLogicBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSSysMapLogicBase.getPSSysPFPluginName());
        }
        if (pSSysMapLogicBase.isPSSysViewLogicIdDirty() && (bl || pSSysMapLogicBase.getPSSysViewLogicId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWLOGICID, (Object)pSSysMapLogicBase.getPSSysViewLogicId());
        }
        if (pSSysMapLogicBase.isPSSysViewLogicNameDirty() && (bl || pSSysMapLogicBase.getPSSysViewLogicName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWLOGICNAME, (Object)pSSysMapLogicBase.getPSSysViewLogicName());
        }
        if (pSSysMapLogicBase.isPSSysViewPanelIdDirty() && (bl || pSSysMapLogicBase.getPSSysViewPanelId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELID, (Object)pSSysMapLogicBase.getPSSysViewPanelId());
        }
        if (pSSysMapLogicBase.isPSSysViewPanelNameDirty() && (bl || pSSysMapLogicBase.getPSSysViewPanelName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELNAME, (Object)pSSysMapLogicBase.getPSSysViewPanelName());
        }
        if (pSSysMapLogicBase.isTimerDirty() && (bl || pSSysMapLogicBase.getTimer() != null)) {
            iDataObject.set(FIELD_TIMER, (Object)pSSysMapLogicBase.getTimer());
        }
        if (pSSysMapLogicBase.isTriggerTypeDirty() && (bl || pSSysMapLogicBase.getTriggerType() != null)) {
            iDataObject.set(FIELD_TRIGGERTYPE, (Object)pSSysMapLogicBase.getTriggerType());
        }
        if (pSSysMapLogicBase.isUpdateDateDirty() && (bl || pSSysMapLogicBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysMapLogicBase.getUpdateDate());
        }
        if (pSSysMapLogicBase.isUpdateManDirty() && (bl || pSSysMapLogicBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysMapLogicBase.getUpdateMan());
        }
        if (pSSysMapLogicBase.isUserCatDirty() && (bl || pSSysMapLogicBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysMapLogicBase.getUserCat());
        }
        if (pSSysMapLogicBase.isUserTagDirty() && (bl || pSSysMapLogicBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysMapLogicBase.getUserTag());
        }
        if (pSSysMapLogicBase.isUserTag2Dirty() && (bl || pSSysMapLogicBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysMapLogicBase.getUserTag2());
        }
        if (pSSysMapLogicBase.isUserTag3Dirty() && (bl || pSSysMapLogicBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysMapLogicBase.getUserTag3());
        }
        if (pSSysMapLogicBase.isUserTag4Dirty() && (bl || pSSysMapLogicBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysMapLogicBase.getUserTag4());
        }
        if (pSSysMapLogicBase.isValidFlagDirty() && (bl || pSSysMapLogicBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysMapLogicBase.getValidFlag());
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
        return PSSysMapLogicBase.remove(this, n);
    }

    private static boolean remove(PSSysMapLogicBase pSSysMapLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysMapLogicBase.resetAttrName();
                return true;
            }
            case 1: {
                pSSysMapLogicBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSysMapLogicBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSysMapLogicBase.resetCustomCode();
                return true;
            }
            case 4: {
                pSSysMapLogicBase.resetDstLogicType();
                return true;
            }
            case 5: {
                pSSysMapLogicBase.resetEventArg();
                return true;
            }
            case 6: {
                pSSysMapLogicBase.resetEventArg2();
                return true;
            }
            case 7: {
                pSSysMapLogicBase.resetEventNames();
                return true;
            }
            case 8: {
                pSSysMapLogicBase.resetLogicParam();
                return true;
            }
            case 9: {
                pSSysMapLogicBase.resetLogicParam2();
                return true;
            }
            case 10: {
                pSSysMapLogicBase.resetMemo();
                return true;
            }
            case 11: {
                pSSysMapLogicBase.resetOrderValue();
                return true;
            }
            case 12: {
                pSSysMapLogicBase.resetPSDEId();
                return true;
            }
            case 13: {
                pSSysMapLogicBase.resetPSDELogicId();
                return true;
            }
            case 14: {
                pSSysMapLogicBase.resetPSDELogicName();
                return true;
            }
            case 15: {
                pSSysMapLogicBase.resetPSDEName();
                return true;
            }
            case 16: {
                pSSysMapLogicBase.resetPSDEUIActionId();
                return true;
            }
            case 17: {
                pSSysMapLogicBase.resetPSDEUIActionName();
                return true;
            }
            case 18: {
                pSSysMapLogicBase.resetPSSysMapItemId();
                return true;
            }
            case 19: {
                pSSysMapLogicBase.resetPSSysMapItemName();
                return true;
            }
            case 20: {
                pSSysMapLogicBase.resetPSSysMapLogicId();
                return true;
            }
            case 21: {
                pSSysMapLogicBase.resetPSSysMapLogicName();
                return true;
            }
            case 22: {
                pSSysMapLogicBase.resetPSSysMapViewId();
                return true;
            }
            case 23: {
                pSSysMapLogicBase.resetPSSysMapViewName();
                return true;
            }
            case 24: {
                pSSysMapLogicBase.resetPSSysPFPluginId();
                return true;
            }
            case 25: {
                pSSysMapLogicBase.resetPSSysPFPluginName();
                return true;
            }
            case 26: {
                pSSysMapLogicBase.resetPSSysViewLogicId();
                return true;
            }
            case 27: {
                pSSysMapLogicBase.resetPSSysViewLogicName();
                return true;
            }
            case 28: {
                pSSysMapLogicBase.resetPSSysViewPanelId();
                return true;
            }
            case 29: {
                pSSysMapLogicBase.resetPSSysViewPanelName();
                return true;
            }
            case 30: {
                pSSysMapLogicBase.resetTimer();
                return true;
            }
            case 31: {
                pSSysMapLogicBase.resetTriggerType();
                return true;
            }
            case 32: {
                pSSysMapLogicBase.resetUpdateDate();
                return true;
            }
            case 33: {
                pSSysMapLogicBase.resetUpdateMan();
                return true;
            }
            case 34: {
                pSSysMapLogicBase.resetUserCat();
                return true;
            }
            case 35: {
                pSSysMapLogicBase.resetUserTag();
                return true;
            }
            case 36: {
                pSSysMapLogicBase.resetUserTag2();
                return true;
            }
            case 37: {
                pSSysMapLogicBase.resetUserTag3();
                return true;
            }
            case 38: {
                pSSysMapLogicBase.resetUserTag4();
                return true;
            }
            case 39: {
                pSSysMapLogicBase.resetValidFlag();
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
    public PSSysMapItem getPSSysMapItem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysMapItem();
        }
        if (this.getPSSysMapItemId() == null) {
            return null;
        }
        Integer n = this.objPSSysMapItemLock;
        synchronized (n) {
            if (this.pssysmapitem != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysMapItemId(), (Object)this.pssysmapitem.getPSSysMapItemId()) != 0L) {
                this.pssysmapitem = null;
            }
            if (this.pssysmapitem == null) {
                PSSysMapItem pSSysMapItem = new PSSysMapItem();
                pSSysMapItem.setPSSysMapItemId(this.getPSSysMapItemId());
                PSSysMapItemService pSSysMapItemService = (PSSysMapItemService)ServiceGlobal.getService(PSSysMapItemService.class, (SessionFactory)this.getSessionFactory());
                pSSysMapItemService.autoGet(pSSysMapItem);
                this.pssysmapitem = pSSysMapItem;
            }
            return this.pssysmapitem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysMapView getPSSysMapView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysMapView();
        }
        if (this.getPSSysMapViewId() == null) {
            return null;
        }
        Integer n = this.objPSSysMapViewLock;
        synchronized (n) {
            if (this.pssysmapview != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysMapViewId(), (Object)this.pssysmapview.getPSSysMapViewId()) != 0L) {
                this.pssysmapview = null;
            }
            if (this.pssysmapview == null) {
                PSSysMapView pSSysMapView = new PSSysMapView();
                pSSysMapView.setPSSysMapViewId(this.getPSSysMapViewId());
                PSSysMapViewService pSSysMapViewService = (PSSysMapViewService)ServiceGlobal.getService(PSSysMapViewService.class, (SessionFactory)this.getSessionFactory());
                pSSysMapViewService.autoGet(pSSysMapView);
                this.pssysmapview = pSSysMapView;
            }
            return this.pssysmapview;
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

    private PSSysMapLogicBase getProxyEntity() {
        return this.proxyPSSysMapLogicBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysMapLogicBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysMapLogicBase) {
            this.proxyPSSysMapLogicBase = (PSSysMapLogicBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysMapLogicService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
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
        fieldIndexMap.put(FIELD_PSSYSMAPITEMID, 18);
        fieldIndexMap.put(FIELD_PSSYSMAPITEMNAME, 19);
        fieldIndexMap.put(FIELD_PSSYSMAPLOGICID, 20);
        fieldIndexMap.put(FIELD_PSSYSMAPLOGICNAME, 21);
        fieldIndexMap.put(FIELD_PSSYSMAPVIEWID, 22);
        fieldIndexMap.put(FIELD_PSSYSMAPVIEWNAME, 23);
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

