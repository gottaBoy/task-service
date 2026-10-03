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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDRDetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataRelation;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDRDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataRelationService;
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

public abstract class PSDEDRLogicBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEDRLogicBase.class);
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
    public static final String FIELD_PSDEDRDETAILID = "PSDEDRDETAILID";
    public static final String FIELD_PSDEDRDETAILNAME = "PSDEDRDETAILNAME";
    public static final String FIELD_PSDEDRID = "PSDEDRID";
    public static final String FIELD_PSDEDRLOGICID = "PSDEDRLOGICID";
    public static final String FIELD_PSDEDRLOGICNAME = "PSDEDRLOGICNAME";
    public static final String FIELD_PSDEDRNAME = "PSDEDRNAME";
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
    private static final int INDEX_PSDEDRDETAILID = 12;
    private static final int INDEX_PSDEDRDETAILNAME = 13;
    private static final int INDEX_PSDEDRID = 14;
    private static final int INDEX_PSDEDRLOGICID = 15;
    private static final int INDEX_PSDEDRLOGICNAME = 16;
    private static final int INDEX_PSDEDRNAME = 17;
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
    private PSDEDRLogicBase proxyPSDEDRLogicBase = null;
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
    private boolean psdedrdetailidDirtyFlag = false;
    private boolean psdedrdetailnameDirtyFlag = false;
    private boolean psdedridDirtyFlag = false;
    private boolean psdedrlogicidDirtyFlag = false;
    private boolean psdedrlogicnameDirtyFlag = false;
    private boolean psdedrnameDirtyFlag = false;
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
    @Column(name="psdedrdetailid")
    private String psdedrdetailid;
    @Column(name="psdedrdetailname")
    private String psdedrdetailname;
    @Column(name="psdedrid")
    private String psdedrid;
    @Column(name="psdedrlogicid")
    private String psdedrlogicid;
    @Column(name="psdedrlogicname")
    private String psdedrlogicname;
    @Column(name="psdedrname")
    private String psdedrname;
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
    private Integer objPSDEDRLock = new Integer(1);
    private PSDEDataRelation psdedr = null;
    private Integer objPSDEDRDetailLock = new Integer(1);
    private PSDEDRDetail psdedrdetail = null;
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

    public void setPSDEDRDetailId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDRDetailId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedrdetailid = string;
        this.psdedrdetailidDirtyFlag = true;
    }

    public String getPSDEDRDetailId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDRDetailId();
        }
        return this.psdedrdetailid;
    }

    public boolean isPSDEDRDetailIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDRDetailIdDirty();
        }
        return this.psdedrdetailidDirtyFlag;
    }

    public void resetPSDEDRDetailId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDRDetailId();
            return;
        }
        this.psdedrdetailidDirtyFlag = false;
        this.psdedrdetailid = null;
    }

    public void setPSDEDRDetailName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDRDetailName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedrdetailname = string;
        this.psdedrdetailnameDirtyFlag = true;
    }

    public String getPSDEDRDetailName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDRDetailName();
        }
        return this.psdedrdetailname;
    }

    public boolean isPSDEDRDetailNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDRDetailNameDirty();
        }
        return this.psdedrdetailnameDirtyFlag;
    }

    public void resetPSDEDRDetailName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDRDetailName();
            return;
        }
        this.psdedrdetailnameDirtyFlag = false;
        this.psdedrdetailname = null;
    }

    public void setPSDEDRId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDRId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedrid = string;
        this.psdedridDirtyFlag = true;
    }

    public String getPSDEDRId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDRId();
        }
        return this.psdedrid;
    }

    public boolean isPSDEDRIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDRIdDirty();
        }
        return this.psdedridDirtyFlag;
    }

    public void resetPSDEDRId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDRId();
            return;
        }
        this.psdedridDirtyFlag = false;
        this.psdedrid = null;
    }

    public void setPSDEDRLogicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDRLogicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedrlogicid = string;
        this.psdedrlogicidDirtyFlag = true;
    }

    public String getPSDEDRLogicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDRLogicId();
        }
        return this.psdedrlogicid;
    }

    public boolean isPSDEDRLogicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDRLogicIdDirty();
        }
        return this.psdedrlogicidDirtyFlag;
    }

    public void resetPSDEDRLogicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDRLogicId();
            return;
        }
        this.psdedrlogicidDirtyFlag = false;
        this.psdedrlogicid = null;
    }

    public void setPSDEDRLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDRLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedrlogicname = string;
        this.psdedrlogicnameDirtyFlag = true;
    }

    public String getPSDEDRLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDRLogicName();
        }
        return this.psdedrlogicname;
    }

    public boolean isPSDEDRLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDRLogicNameDirty();
        }
        return this.psdedrlogicnameDirtyFlag;
    }

    public void resetPSDEDRLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDRLogicName();
            return;
        }
        this.psdedrlogicnameDirtyFlag = false;
        this.psdedrlogicname = null;
    }

    public void setPSDEDRName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDRName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedrname = string;
        this.psdedrnameDirtyFlag = true;
    }

    public String getPSDEDRName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDRName();
        }
        return this.psdedrname;
    }

    public boolean isPSDEDRNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDRNameDirty();
        }
        return this.psdedrnameDirtyFlag;
    }

    public void resetPSDEDRName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDRName();
            return;
        }
        this.psdedrnameDirtyFlag = false;
        this.psdedrname = null;
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
        PSDEDRLogicBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEDRLogicBase pSDEDRLogicBase) {
        pSDEDRLogicBase.resetAttrName();
        pSDEDRLogicBase.resetCreateDate();
        pSDEDRLogicBase.resetCreateMan();
        pSDEDRLogicBase.resetCustomCode();
        pSDEDRLogicBase.resetDstLogicType();
        pSDEDRLogicBase.resetEventArg();
        pSDEDRLogicBase.resetEventArg2();
        pSDEDRLogicBase.resetEventNames();
        pSDEDRLogicBase.resetLogicParam();
        pSDEDRLogicBase.resetLogicParam2();
        pSDEDRLogicBase.resetMemo();
        pSDEDRLogicBase.resetOrderValue();
        pSDEDRLogicBase.resetPSDEDRDetailId();
        pSDEDRLogicBase.resetPSDEDRDetailName();
        pSDEDRLogicBase.resetPSDEDRId();
        pSDEDRLogicBase.resetPSDEDRLogicId();
        pSDEDRLogicBase.resetPSDEDRLogicName();
        pSDEDRLogicBase.resetPSDEDRName();
        pSDEDRLogicBase.resetPSDEId();
        pSDEDRLogicBase.resetPSDELogicId();
        pSDEDRLogicBase.resetPSDELogicName();
        pSDEDRLogicBase.resetPSDEName();
        pSDEDRLogicBase.resetPSDEUIActionId();
        pSDEDRLogicBase.resetPSDEUIActionName();
        pSDEDRLogicBase.resetPSSysPFPluginId();
        pSDEDRLogicBase.resetPSSysPFPluginName();
        pSDEDRLogicBase.resetPSSysViewLogicId();
        pSDEDRLogicBase.resetPSSysViewLogicName();
        pSDEDRLogicBase.resetPSSysViewPanelId();
        pSDEDRLogicBase.resetPSSysViewPanelName();
        pSDEDRLogicBase.resetTimer();
        pSDEDRLogicBase.resetTriggerType();
        pSDEDRLogicBase.resetUpdateDate();
        pSDEDRLogicBase.resetUpdateMan();
        pSDEDRLogicBase.resetUserCat();
        pSDEDRLogicBase.resetUserTag();
        pSDEDRLogicBase.resetUserTag2();
        pSDEDRLogicBase.resetUserTag3();
        pSDEDRLogicBase.resetUserTag4();
        pSDEDRLogicBase.resetValidFlag();
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
        if (!bl || this.isPSDEDRDetailIdDirty()) {
            hashMap.put(FIELD_PSDEDRDETAILID, this.getPSDEDRDetailId());
        }
        if (!bl || this.isPSDEDRDetailNameDirty()) {
            hashMap.put(FIELD_PSDEDRDETAILNAME, this.getPSDEDRDetailName());
        }
        if (!bl || this.isPSDEDRIdDirty()) {
            hashMap.put(FIELD_PSDEDRID, this.getPSDEDRId());
        }
        if (!bl || this.isPSDEDRLogicIdDirty()) {
            hashMap.put(FIELD_PSDEDRLOGICID, this.getPSDEDRLogicId());
        }
        if (!bl || this.isPSDEDRLogicNameDirty()) {
            hashMap.put(FIELD_PSDEDRLOGICNAME, this.getPSDEDRLogicName());
        }
        if (!bl || this.isPSDEDRNameDirty()) {
            hashMap.put(FIELD_PSDEDRNAME, this.getPSDEDRName());
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
        return PSDEDRLogicBase.get(this, n);
    }

    private static Object get(PSDEDRLogicBase pSDEDRLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDRLogicBase.getAttrName();
            }
            case 1: {
                return pSDEDRLogicBase.getCreateDate();
            }
            case 2: {
                return pSDEDRLogicBase.getCreateMan();
            }
            case 3: {
                return pSDEDRLogicBase.getCustomCode();
            }
            case 4: {
                return pSDEDRLogicBase.getDstLogicType();
            }
            case 5: {
                return pSDEDRLogicBase.getEventArg();
            }
            case 6: {
                return pSDEDRLogicBase.getEventArg2();
            }
            case 7: {
                return pSDEDRLogicBase.getEventNames();
            }
            case 8: {
                return pSDEDRLogicBase.getLogicParam();
            }
            case 9: {
                return pSDEDRLogicBase.getLogicParam2();
            }
            case 10: {
                return pSDEDRLogicBase.getMemo();
            }
            case 11: {
                return pSDEDRLogicBase.getOrderValue();
            }
            case 12: {
                return pSDEDRLogicBase.getPSDEDRDetailId();
            }
            case 13: {
                return pSDEDRLogicBase.getPSDEDRDetailName();
            }
            case 14: {
                return pSDEDRLogicBase.getPSDEDRId();
            }
            case 15: {
                return pSDEDRLogicBase.getPSDEDRLogicId();
            }
            case 16: {
                return pSDEDRLogicBase.getPSDEDRLogicName();
            }
            case 17: {
                return pSDEDRLogicBase.getPSDEDRName();
            }
            case 18: {
                return pSDEDRLogicBase.getPSDEId();
            }
            case 19: {
                return pSDEDRLogicBase.getPSDELogicId();
            }
            case 20: {
                return pSDEDRLogicBase.getPSDELogicName();
            }
            case 21: {
                return pSDEDRLogicBase.getPSDEName();
            }
            case 22: {
                return pSDEDRLogicBase.getPSDEUIActionId();
            }
            case 23: {
                return pSDEDRLogicBase.getPSDEUIActionName();
            }
            case 24: {
                return pSDEDRLogicBase.getPSSysPFPluginId();
            }
            case 25: {
                return pSDEDRLogicBase.getPSSysPFPluginName();
            }
            case 26: {
                return pSDEDRLogicBase.getPSSysViewLogicId();
            }
            case 27: {
                return pSDEDRLogicBase.getPSSysViewLogicName();
            }
            case 28: {
                return pSDEDRLogicBase.getPSSysViewPanelId();
            }
            case 29: {
                return pSDEDRLogicBase.getPSSysViewPanelName();
            }
            case 30: {
                return pSDEDRLogicBase.getTimer();
            }
            case 31: {
                return pSDEDRLogicBase.getTriggerType();
            }
            case 32: {
                return pSDEDRLogicBase.getUpdateDate();
            }
            case 33: {
                return pSDEDRLogicBase.getUpdateMan();
            }
            case 34: {
                return pSDEDRLogicBase.getUserCat();
            }
            case 35: {
                return pSDEDRLogicBase.getUserTag();
            }
            case 36: {
                return pSDEDRLogicBase.getUserTag2();
            }
            case 37: {
                return pSDEDRLogicBase.getUserTag3();
            }
            case 38: {
                return pSDEDRLogicBase.getUserTag4();
            }
            case 39: {
                return pSDEDRLogicBase.getValidFlag();
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
        PSDEDRLogicBase.set(this, n, object);
    }

    private static void set(PSDEDRLogicBase pSDEDRLogicBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEDRLogicBase.setAttrName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDEDRLogicBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDEDRLogicBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEDRLogicBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEDRLogicBase.setDstLogicType(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEDRLogicBase.setEventArg(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEDRLogicBase.setEventArg2(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEDRLogicBase.setEventNames(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEDRLogicBase.setLogicParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEDRLogicBase.setLogicParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEDRLogicBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEDRLogicBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSDEDRLogicBase.setPSDEDRDetailId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEDRLogicBase.setPSDEDRDetailName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEDRLogicBase.setPSDEDRId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEDRLogicBase.setPSDEDRLogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEDRLogicBase.setPSDEDRLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEDRLogicBase.setPSDEDRName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEDRLogicBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEDRLogicBase.setPSDELogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDEDRLogicBase.setPSDELogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEDRLogicBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDEDRLogicBase.setPSDEUIActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDEDRLogicBase.setPSDEUIActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDEDRLogicBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDEDRLogicBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDEDRLogicBase.setPSSysViewLogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDEDRLogicBase.setPSSysViewLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDEDRLogicBase.setPSSysViewPanelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDEDRLogicBase.setPSSysViewPanelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDEDRLogicBase.setTimer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 31: {
                pSDEDRLogicBase.setTriggerType(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDEDRLogicBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 33: {
                pSDEDRLogicBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDEDRLogicBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDEDRLogicBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDEDRLogicBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSDEDRLogicBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDEDRLogicBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSDEDRLogicBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDEDRLogicBase.isNull(this, n);
    }

    private static boolean isNull(PSDEDRLogicBase pSDEDRLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDRLogicBase.getAttrName() == null;
            }
            case 1: {
                return pSDEDRLogicBase.getCreateDate() == null;
            }
            case 2: {
                return pSDEDRLogicBase.getCreateMan() == null;
            }
            case 3: {
                return pSDEDRLogicBase.getCustomCode() == null;
            }
            case 4: {
                return pSDEDRLogicBase.getDstLogicType() == null;
            }
            case 5: {
                return pSDEDRLogicBase.getEventArg() == null;
            }
            case 6: {
                return pSDEDRLogicBase.getEventArg2() == null;
            }
            case 7: {
                return pSDEDRLogicBase.getEventNames() == null;
            }
            case 8: {
                return pSDEDRLogicBase.getLogicParam() == null;
            }
            case 9: {
                return pSDEDRLogicBase.getLogicParam2() == null;
            }
            case 10: {
                return pSDEDRLogicBase.getMemo() == null;
            }
            case 11: {
                return pSDEDRLogicBase.getOrderValue() == null;
            }
            case 12: {
                return pSDEDRLogicBase.getPSDEDRDetailId() == null;
            }
            case 13: {
                return pSDEDRLogicBase.getPSDEDRDetailName() == null;
            }
            case 14: {
                return pSDEDRLogicBase.getPSDEDRId() == null;
            }
            case 15: {
                return pSDEDRLogicBase.getPSDEDRLogicId() == null;
            }
            case 16: {
                return pSDEDRLogicBase.getPSDEDRLogicName() == null;
            }
            case 17: {
                return pSDEDRLogicBase.getPSDEDRName() == null;
            }
            case 18: {
                return pSDEDRLogicBase.getPSDEId() == null;
            }
            case 19: {
                return pSDEDRLogicBase.getPSDELogicId() == null;
            }
            case 20: {
                return pSDEDRLogicBase.getPSDELogicName() == null;
            }
            case 21: {
                return pSDEDRLogicBase.getPSDEName() == null;
            }
            case 22: {
                return pSDEDRLogicBase.getPSDEUIActionId() == null;
            }
            case 23: {
                return pSDEDRLogicBase.getPSDEUIActionName() == null;
            }
            case 24: {
                return pSDEDRLogicBase.getPSSysPFPluginId() == null;
            }
            case 25: {
                return pSDEDRLogicBase.getPSSysPFPluginName() == null;
            }
            case 26: {
                return pSDEDRLogicBase.getPSSysViewLogicId() == null;
            }
            case 27: {
                return pSDEDRLogicBase.getPSSysViewLogicName() == null;
            }
            case 28: {
                return pSDEDRLogicBase.getPSSysViewPanelId() == null;
            }
            case 29: {
                return pSDEDRLogicBase.getPSSysViewPanelName() == null;
            }
            case 30: {
                return pSDEDRLogicBase.getTimer() == null;
            }
            case 31: {
                return pSDEDRLogicBase.getTriggerType() == null;
            }
            case 32: {
                return pSDEDRLogicBase.getUpdateDate() == null;
            }
            case 33: {
                return pSDEDRLogicBase.getUpdateMan() == null;
            }
            case 34: {
                return pSDEDRLogicBase.getUserCat() == null;
            }
            case 35: {
                return pSDEDRLogicBase.getUserTag() == null;
            }
            case 36: {
                return pSDEDRLogicBase.getUserTag2() == null;
            }
            case 37: {
                return pSDEDRLogicBase.getUserTag3() == null;
            }
            case 38: {
                return pSDEDRLogicBase.getUserTag4() == null;
            }
            case 39: {
                return pSDEDRLogicBase.getValidFlag() == null;
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
        return PSDEDRLogicBase.contains(this, n);
    }

    private static boolean contains(PSDEDRLogicBase pSDEDRLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDRLogicBase.isAttrNameDirty();
            }
            case 1: {
                return pSDEDRLogicBase.isCreateDateDirty();
            }
            case 2: {
                return pSDEDRLogicBase.isCreateManDirty();
            }
            case 3: {
                return pSDEDRLogicBase.isCustomCodeDirty();
            }
            case 4: {
                return pSDEDRLogicBase.isDstLogicTypeDirty();
            }
            case 5: {
                return pSDEDRLogicBase.isEventArgDirty();
            }
            case 6: {
                return pSDEDRLogicBase.isEventArg2Dirty();
            }
            case 7: {
                return pSDEDRLogicBase.isEventNamesDirty();
            }
            case 8: {
                return pSDEDRLogicBase.isLogicParamDirty();
            }
            case 9: {
                return pSDEDRLogicBase.isLogicParam2Dirty();
            }
            case 10: {
                return pSDEDRLogicBase.isMemoDirty();
            }
            case 11: {
                return pSDEDRLogicBase.isOrderValueDirty();
            }
            case 12: {
                return pSDEDRLogicBase.isPSDEDRDetailIdDirty();
            }
            case 13: {
                return pSDEDRLogicBase.isPSDEDRDetailNameDirty();
            }
            case 14: {
                return pSDEDRLogicBase.isPSDEDRIdDirty();
            }
            case 15: {
                return pSDEDRLogicBase.isPSDEDRLogicIdDirty();
            }
            case 16: {
                return pSDEDRLogicBase.isPSDEDRLogicNameDirty();
            }
            case 17: {
                return pSDEDRLogicBase.isPSDEDRNameDirty();
            }
            case 18: {
                return pSDEDRLogicBase.isPSDEIdDirty();
            }
            case 19: {
                return pSDEDRLogicBase.isPSDELogicIdDirty();
            }
            case 20: {
                return pSDEDRLogicBase.isPSDELogicNameDirty();
            }
            case 21: {
                return pSDEDRLogicBase.isPSDENameDirty();
            }
            case 22: {
                return pSDEDRLogicBase.isPSDEUIActionIdDirty();
            }
            case 23: {
                return pSDEDRLogicBase.isPSDEUIActionNameDirty();
            }
            case 24: {
                return pSDEDRLogicBase.isPSSysPFPluginIdDirty();
            }
            case 25: {
                return pSDEDRLogicBase.isPSSysPFPluginNameDirty();
            }
            case 26: {
                return pSDEDRLogicBase.isPSSysViewLogicIdDirty();
            }
            case 27: {
                return pSDEDRLogicBase.isPSSysViewLogicNameDirty();
            }
            case 28: {
                return pSDEDRLogicBase.isPSSysViewPanelIdDirty();
            }
            case 29: {
                return pSDEDRLogicBase.isPSSysViewPanelNameDirty();
            }
            case 30: {
                return pSDEDRLogicBase.isTimerDirty();
            }
            case 31: {
                return pSDEDRLogicBase.isTriggerTypeDirty();
            }
            case 32: {
                return pSDEDRLogicBase.isUpdateDateDirty();
            }
            case 33: {
                return pSDEDRLogicBase.isUpdateManDirty();
            }
            case 34: {
                return pSDEDRLogicBase.isUserCatDirty();
            }
            case 35: {
                return pSDEDRLogicBase.isUserTagDirty();
            }
            case 36: {
                return pSDEDRLogicBase.isUserTag2Dirty();
            }
            case 37: {
                return pSDEDRLogicBase.isUserTag3Dirty();
            }
            case 38: {
                return pSDEDRLogicBase.isUserTag4Dirty();
            }
            case 39: {
                return pSDEDRLogicBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEDRLogicBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEDRLogicBase pSDEDRLogicBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEDRLogicBase.getAttrName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"attrname", (Object)PSDEDRLogicBase.getJSONValue((Object)pSDEDRLogicBase.getAttrName()), (boolean)false);
        }
        if (bl || pSDEDRLogicBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEDRLogicBase.getJSONValue((Object)pSDEDRLogicBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEDRLogicBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEDRLogicBase.getJSONValue((Object)pSDEDRLogicBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEDRLogicBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSDEDRLogicBase.getJSONValue((Object)pSDEDRLogicBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSDEDRLogicBase.getDstLogicType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstlogictype", (Object)PSDEDRLogicBase.getJSONValue((Object)pSDEDRLogicBase.getDstLogicType()), (boolean)false);
        }
        if (bl || pSDEDRLogicBase.getEventArg() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eventarg", (Object)PSDEDRLogicBase.getJSONValue((Object)pSDEDRLogicBase.getEventArg()), (boolean)false);
        }
        if (bl || pSDEDRLogicBase.getEventArg2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eventarg2", (Object)PSDEDRLogicBase.getJSONValue((Object)pSDEDRLogicBase.getEventArg2()), (boolean)false);
        }
        if (bl || pSDEDRLogicBase.getEventNames() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eventnames", (Object)PSDEDRLogicBase.getJSONValue((Object)pSDEDRLogicBase.getEventNames()), (boolean)false);
        }
        if (bl || pSDEDRLogicBase.getLogicParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicparam", (Object)PSDEDRLogicBase.getJSONValue((Object)pSDEDRLogicBase.getLogicParam()), (boolean)false);
        }
        if (bl || pSDEDRLogicBase.getLogicParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicparam2", (Object)PSDEDRLogicBase.getJSONValue((Object)pSDEDRLogicBase.getLogicParam2()), (boolean)false);
        }
        if (bl || pSDEDRLogicBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEDRLogicBase.getJSONValue((Object)pSDEDRLogicBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEDRLogicBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDEDRLogicBase.getJSONValue((Object)pSDEDRLogicBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDEDRLogicBase.getPSDEDRDetailId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedrdetailid", (Object)PSDEDRLogicBase.getJSONValue((Object)pSDEDRLogicBase.getPSDEDRDetailId()), (boolean)false);
        }
        if (bl || pSDEDRLogicBase.getPSDEDRDetailName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedrdetailname", (Object)PSDEDRLogicBase.getJSONValue((Object)pSDEDRLogicBase.getPSDEDRDetailName()), (boolean)false);
        }
        if (bl || pSDEDRLogicBase.getPSDEDRId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedrid", (Object)PSDEDRLogicBase.getJSONValue((Object)pSDEDRLogicBase.getPSDEDRId()), (boolean)false);
        }
        if (bl || pSDEDRLogicBase.getPSDEDRLogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedrlogicid", (Object)PSDEDRLogicBase.getJSONValue((Object)pSDEDRLogicBase.getPSDEDRLogicId()), (boolean)false);
        }
        if (bl || pSDEDRLogicBase.getPSDEDRLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedrlogicname", (Object)PSDEDRLogicBase.getJSONValue((Object)pSDEDRLogicBase.getPSDEDRLogicName()), (boolean)false);
        }
        if (bl || pSDEDRLogicBase.getPSDEDRName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedrname", (Object)PSDEDRLogicBase.getJSONValue((Object)pSDEDRLogicBase.getPSDEDRName()), (boolean)false);
        }
        if (bl || pSDEDRLogicBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEDRLogicBase.getJSONValue((Object)pSDEDRLogicBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEDRLogicBase.getPSDELogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicid", (Object)PSDEDRLogicBase.getJSONValue((Object)pSDEDRLogicBase.getPSDELogicId()), (boolean)false);
        }
        if (bl || pSDEDRLogicBase.getPSDELogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicname", (Object)PSDEDRLogicBase.getJSONValue((Object)pSDEDRLogicBase.getPSDELogicName()), (boolean)false);
        }
        if (bl || pSDEDRLogicBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDEDRLogicBase.getJSONValue((Object)pSDEDRLogicBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDEDRLogicBase.getPSDEUIActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuiactionid", (Object)PSDEDRLogicBase.getJSONValue((Object)pSDEDRLogicBase.getPSDEUIActionId()), (boolean)false);
        }
        if (bl || pSDEDRLogicBase.getPSDEUIActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuiactionname", (Object)PSDEDRLogicBase.getJSONValue((Object)pSDEDRLogicBase.getPSDEUIActionName()), (boolean)false);
        }
        if (bl || pSDEDRLogicBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSDEDRLogicBase.getJSONValue((Object)pSDEDRLogicBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSDEDRLogicBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSDEDRLogicBase.getJSONValue((Object)pSDEDRLogicBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSDEDRLogicBase.getPSSysViewLogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewlogicid", (Object)PSDEDRLogicBase.getJSONValue((Object)pSDEDRLogicBase.getPSSysViewLogicId()), (boolean)false);
        }
        if (bl || pSDEDRLogicBase.getPSSysViewLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewlogicname", (Object)PSDEDRLogicBase.getJSONValue((Object)pSDEDRLogicBase.getPSSysViewLogicName()), (boolean)false);
        }
        if (bl || pSDEDRLogicBase.getPSSysViewPanelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelid", (Object)PSDEDRLogicBase.getJSONValue((Object)pSDEDRLogicBase.getPSSysViewPanelId()), (boolean)false);
        }
        if (bl || pSDEDRLogicBase.getPSSysViewPanelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelname", (Object)PSDEDRLogicBase.getJSONValue((Object)pSDEDRLogicBase.getPSSysViewPanelName()), (boolean)false);
        }
        if (bl || pSDEDRLogicBase.getTimer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"timer", (Object)PSDEDRLogicBase.getJSONValue((Object)pSDEDRLogicBase.getTimer()), (boolean)false);
        }
        if (bl || pSDEDRLogicBase.getTriggerType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"triggertype", (Object)PSDEDRLogicBase.getJSONValue((Object)pSDEDRLogicBase.getTriggerType()), (boolean)false);
        }
        if (bl || pSDEDRLogicBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEDRLogicBase.getJSONValue((Object)pSDEDRLogicBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEDRLogicBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEDRLogicBase.getJSONValue((Object)pSDEDRLogicBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEDRLogicBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEDRLogicBase.getJSONValue((Object)pSDEDRLogicBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEDRLogicBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEDRLogicBase.getJSONValue((Object)pSDEDRLogicBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEDRLogicBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEDRLogicBase.getJSONValue((Object)pSDEDRLogicBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEDRLogicBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEDRLogicBase.getJSONValue((Object)pSDEDRLogicBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEDRLogicBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEDRLogicBase.getJSONValue((Object)pSDEDRLogicBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDEDRLogicBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDEDRLogicBase.getJSONValue((Object)pSDEDRLogicBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEDRLogicBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEDRLogicBase pSDEDRLogicBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEDRLogicBase.getAttrName() != null) {
            object = pSDEDRLogicBase.getAttrName();
            xmlNode.setAttribute(FIELD_ATTRNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRLogicBase.getCreateDate() != null) {
            object = pSDEDRLogicBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEDRLogicBase.getCreateMan() != null) {
            object = pSDEDRLogicBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRLogicBase.getCustomCode() != null) {
            object = pSDEDRLogicBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRLogicBase.getDstLogicType() != null) {
            object = pSDEDRLogicBase.getDstLogicType();
            xmlNode.setAttribute(FIELD_DSTLOGICTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRLogicBase.getEventArg() != null) {
            object = pSDEDRLogicBase.getEventArg();
            xmlNode.setAttribute(FIELD_EVENTARG, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRLogicBase.getEventArg2() != null) {
            object = pSDEDRLogicBase.getEventArg2();
            xmlNode.setAttribute(FIELD_EVENTARG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRLogicBase.getEventNames() != null) {
            object = pSDEDRLogicBase.getEventNames();
            xmlNode.setAttribute(FIELD_EVENTNAMES, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRLogicBase.getLogicParam() != null) {
            object = pSDEDRLogicBase.getLogicParam();
            xmlNode.setAttribute(FIELD_LOGICPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRLogicBase.getLogicParam2() != null) {
            object = pSDEDRLogicBase.getLogicParam2();
            xmlNode.setAttribute(FIELD_LOGICPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRLogicBase.getMemo() != null) {
            object = pSDEDRLogicBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRLogicBase.getOrderValue() != null) {
            object = pSDEDRLogicBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDRLogicBase.getPSDEDRDetailId() != null) {
            object = pSDEDRLogicBase.getPSDEDRDetailId();
            xmlNode.setAttribute(FIELD_PSDEDRDETAILID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRLogicBase.getPSDEDRDetailName() != null) {
            object = pSDEDRLogicBase.getPSDEDRDetailName();
            xmlNode.setAttribute(FIELD_PSDEDRDETAILNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRLogicBase.getPSDEDRId() != null) {
            object = pSDEDRLogicBase.getPSDEDRId();
            xmlNode.setAttribute(FIELD_PSDEDRID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRLogicBase.getPSDEDRLogicId() != null) {
            object = pSDEDRLogicBase.getPSDEDRLogicId();
            xmlNode.setAttribute(FIELD_PSDEDRLOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRLogicBase.getPSDEDRLogicName() != null) {
            object = pSDEDRLogicBase.getPSDEDRLogicName();
            xmlNode.setAttribute(FIELD_PSDEDRLOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRLogicBase.getPSDEDRName() != null) {
            object = pSDEDRLogicBase.getPSDEDRName();
            xmlNode.setAttribute(FIELD_PSDEDRNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRLogicBase.getPSDEId() != null) {
            object = pSDEDRLogicBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRLogicBase.getPSDELogicId() != null) {
            object = pSDEDRLogicBase.getPSDELogicId();
            xmlNode.setAttribute(FIELD_PSDELOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRLogicBase.getPSDELogicName() != null) {
            object = pSDEDRLogicBase.getPSDELogicName();
            xmlNode.setAttribute(FIELD_PSDELOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRLogicBase.getPSDEName() != null) {
            object = pSDEDRLogicBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRLogicBase.getPSDEUIActionId() != null) {
            object = pSDEDRLogicBase.getPSDEUIActionId();
            xmlNode.setAttribute(FIELD_PSDEUIACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRLogicBase.getPSDEUIActionName() != null) {
            object = pSDEDRLogicBase.getPSDEUIActionName();
            xmlNode.setAttribute(FIELD_PSDEUIACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRLogicBase.getPSSysPFPluginId() != null) {
            object = pSDEDRLogicBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRLogicBase.getPSSysPFPluginName() != null) {
            object = pSDEDRLogicBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRLogicBase.getPSSysViewLogicId() != null) {
            object = pSDEDRLogicBase.getPSSysViewLogicId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWLOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRLogicBase.getPSSysViewLogicName() != null) {
            object = pSDEDRLogicBase.getPSSysViewLogicName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWLOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRLogicBase.getPSSysViewPanelId() != null) {
            object = pSDEDRLogicBase.getPSSysViewPanelId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRLogicBase.getPSSysViewPanelName() != null) {
            object = pSDEDRLogicBase.getPSSysViewPanelName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRLogicBase.getTimer() != null) {
            object = pSDEDRLogicBase.getTimer();
            xmlNode.setAttribute(FIELD_TIMER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDRLogicBase.getTriggerType() != null) {
            object = pSDEDRLogicBase.getTriggerType();
            xmlNode.setAttribute(FIELD_TRIGGERTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRLogicBase.getUpdateDate() != null) {
            object = pSDEDRLogicBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEDRLogicBase.getUpdateMan() != null) {
            object = pSDEDRLogicBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRLogicBase.getUserCat() != null) {
            object = pSDEDRLogicBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRLogicBase.getUserTag() != null) {
            object = pSDEDRLogicBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRLogicBase.getUserTag2() != null) {
            object = pSDEDRLogicBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRLogicBase.getUserTag3() != null) {
            object = pSDEDRLogicBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRLogicBase.getUserTag4() != null) {
            object = pSDEDRLogicBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRLogicBase.getValidFlag() != null) {
            object = pSDEDRLogicBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEDRLogicBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEDRLogicBase pSDEDRLogicBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEDRLogicBase.isAttrNameDirty() && (bl || pSDEDRLogicBase.getAttrName() != null)) {
            iDataObject.set(FIELD_ATTRNAME, (Object)pSDEDRLogicBase.getAttrName());
        }
        if (pSDEDRLogicBase.isCreateDateDirty() && (bl || pSDEDRLogicBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEDRLogicBase.getCreateDate());
        }
        if (pSDEDRLogicBase.isCreateManDirty() && (bl || pSDEDRLogicBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEDRLogicBase.getCreateMan());
        }
        if (pSDEDRLogicBase.isCustomCodeDirty() && (bl || pSDEDRLogicBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSDEDRLogicBase.getCustomCode());
        }
        if (pSDEDRLogicBase.isDstLogicTypeDirty() && (bl || pSDEDRLogicBase.getDstLogicType() != null)) {
            iDataObject.set(FIELD_DSTLOGICTYPE, (Object)pSDEDRLogicBase.getDstLogicType());
        }
        if (pSDEDRLogicBase.isEventArgDirty() && (bl || pSDEDRLogicBase.getEventArg() != null)) {
            iDataObject.set(FIELD_EVENTARG, (Object)pSDEDRLogicBase.getEventArg());
        }
        if (pSDEDRLogicBase.isEventArg2Dirty() && (bl || pSDEDRLogicBase.getEventArg2() != null)) {
            iDataObject.set(FIELD_EVENTARG2, (Object)pSDEDRLogicBase.getEventArg2());
        }
        if (pSDEDRLogicBase.isEventNamesDirty() && (bl || pSDEDRLogicBase.getEventNames() != null)) {
            iDataObject.set(FIELD_EVENTNAMES, (Object)pSDEDRLogicBase.getEventNames());
        }
        if (pSDEDRLogicBase.isLogicParamDirty() && (bl || pSDEDRLogicBase.getLogicParam() != null)) {
            iDataObject.set(FIELD_LOGICPARAM, (Object)pSDEDRLogicBase.getLogicParam());
        }
        if (pSDEDRLogicBase.isLogicParam2Dirty() && (bl || pSDEDRLogicBase.getLogicParam2() != null)) {
            iDataObject.set(FIELD_LOGICPARAM2, (Object)pSDEDRLogicBase.getLogicParam2());
        }
        if (pSDEDRLogicBase.isMemoDirty() && (bl || pSDEDRLogicBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEDRLogicBase.getMemo());
        }
        if (pSDEDRLogicBase.isOrderValueDirty() && (bl || pSDEDRLogicBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDEDRLogicBase.getOrderValue());
        }
        if (pSDEDRLogicBase.isPSDEDRDetailIdDirty() && (bl || pSDEDRLogicBase.getPSDEDRDetailId() != null)) {
            iDataObject.set(FIELD_PSDEDRDETAILID, (Object)pSDEDRLogicBase.getPSDEDRDetailId());
        }
        if (pSDEDRLogicBase.isPSDEDRDetailNameDirty() && (bl || pSDEDRLogicBase.getPSDEDRDetailName() != null)) {
            iDataObject.set(FIELD_PSDEDRDETAILNAME, (Object)pSDEDRLogicBase.getPSDEDRDetailName());
        }
        if (pSDEDRLogicBase.isPSDEDRIdDirty() && (bl || pSDEDRLogicBase.getPSDEDRId() != null)) {
            iDataObject.set(FIELD_PSDEDRID, (Object)pSDEDRLogicBase.getPSDEDRId());
        }
        if (pSDEDRLogicBase.isPSDEDRLogicIdDirty() && (bl || pSDEDRLogicBase.getPSDEDRLogicId() != null)) {
            iDataObject.set(FIELD_PSDEDRLOGICID, (Object)pSDEDRLogicBase.getPSDEDRLogicId());
        }
        if (pSDEDRLogicBase.isPSDEDRLogicNameDirty() && (bl || pSDEDRLogicBase.getPSDEDRLogicName() != null)) {
            iDataObject.set(FIELD_PSDEDRLOGICNAME, (Object)pSDEDRLogicBase.getPSDEDRLogicName());
        }
        if (pSDEDRLogicBase.isPSDEDRNameDirty() && (bl || pSDEDRLogicBase.getPSDEDRName() != null)) {
            iDataObject.set(FIELD_PSDEDRNAME, (Object)pSDEDRLogicBase.getPSDEDRName());
        }
        if (pSDEDRLogicBase.isPSDEIdDirty() && (bl || pSDEDRLogicBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEDRLogicBase.getPSDEId());
        }
        if (pSDEDRLogicBase.isPSDELogicIdDirty() && (bl || pSDEDRLogicBase.getPSDELogicId() != null)) {
            iDataObject.set(FIELD_PSDELOGICID, (Object)pSDEDRLogicBase.getPSDELogicId());
        }
        if (pSDEDRLogicBase.isPSDELogicNameDirty() && (bl || pSDEDRLogicBase.getPSDELogicName() != null)) {
            iDataObject.set(FIELD_PSDELOGICNAME, (Object)pSDEDRLogicBase.getPSDELogicName());
        }
        if (pSDEDRLogicBase.isPSDENameDirty() && (bl || pSDEDRLogicBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDEDRLogicBase.getPSDEName());
        }
        if (pSDEDRLogicBase.isPSDEUIActionIdDirty() && (bl || pSDEDRLogicBase.getPSDEUIActionId() != null)) {
            iDataObject.set(FIELD_PSDEUIACTIONID, (Object)pSDEDRLogicBase.getPSDEUIActionId());
        }
        if (pSDEDRLogicBase.isPSDEUIActionNameDirty() && (bl || pSDEDRLogicBase.getPSDEUIActionName() != null)) {
            iDataObject.set(FIELD_PSDEUIACTIONNAME, (Object)pSDEDRLogicBase.getPSDEUIActionName());
        }
        if (pSDEDRLogicBase.isPSSysPFPluginIdDirty() && (bl || pSDEDRLogicBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSDEDRLogicBase.getPSSysPFPluginId());
        }
        if (pSDEDRLogicBase.isPSSysPFPluginNameDirty() && (bl || pSDEDRLogicBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSDEDRLogicBase.getPSSysPFPluginName());
        }
        if (pSDEDRLogicBase.isPSSysViewLogicIdDirty() && (bl || pSDEDRLogicBase.getPSSysViewLogicId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWLOGICID, (Object)pSDEDRLogicBase.getPSSysViewLogicId());
        }
        if (pSDEDRLogicBase.isPSSysViewLogicNameDirty() && (bl || pSDEDRLogicBase.getPSSysViewLogicName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWLOGICNAME, (Object)pSDEDRLogicBase.getPSSysViewLogicName());
        }
        if (pSDEDRLogicBase.isPSSysViewPanelIdDirty() && (bl || pSDEDRLogicBase.getPSSysViewPanelId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELID, (Object)pSDEDRLogicBase.getPSSysViewPanelId());
        }
        if (pSDEDRLogicBase.isPSSysViewPanelNameDirty() && (bl || pSDEDRLogicBase.getPSSysViewPanelName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELNAME, (Object)pSDEDRLogicBase.getPSSysViewPanelName());
        }
        if (pSDEDRLogicBase.isTimerDirty() && (bl || pSDEDRLogicBase.getTimer() != null)) {
            iDataObject.set(FIELD_TIMER, (Object)pSDEDRLogicBase.getTimer());
        }
        if (pSDEDRLogicBase.isTriggerTypeDirty() && (bl || pSDEDRLogicBase.getTriggerType() != null)) {
            iDataObject.set(FIELD_TRIGGERTYPE, (Object)pSDEDRLogicBase.getTriggerType());
        }
        if (pSDEDRLogicBase.isUpdateDateDirty() && (bl || pSDEDRLogicBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEDRLogicBase.getUpdateDate());
        }
        if (pSDEDRLogicBase.isUpdateManDirty() && (bl || pSDEDRLogicBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEDRLogicBase.getUpdateMan());
        }
        if (pSDEDRLogicBase.isUserCatDirty() && (bl || pSDEDRLogicBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEDRLogicBase.getUserCat());
        }
        if (pSDEDRLogicBase.isUserTagDirty() && (bl || pSDEDRLogicBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEDRLogicBase.getUserTag());
        }
        if (pSDEDRLogicBase.isUserTag2Dirty() && (bl || pSDEDRLogicBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEDRLogicBase.getUserTag2());
        }
        if (pSDEDRLogicBase.isUserTag3Dirty() && (bl || pSDEDRLogicBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEDRLogicBase.getUserTag3());
        }
        if (pSDEDRLogicBase.isUserTag4Dirty() && (bl || pSDEDRLogicBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEDRLogicBase.getUserTag4());
        }
        if (pSDEDRLogicBase.isValidFlagDirty() && (bl || pSDEDRLogicBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDEDRLogicBase.getValidFlag());
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
        return PSDEDRLogicBase.remove(this, n);
    }

    private static boolean remove(PSDEDRLogicBase pSDEDRLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEDRLogicBase.resetAttrName();
                return true;
            }
            case 1: {
                pSDEDRLogicBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDEDRLogicBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDEDRLogicBase.resetCustomCode();
                return true;
            }
            case 4: {
                pSDEDRLogicBase.resetDstLogicType();
                return true;
            }
            case 5: {
                pSDEDRLogicBase.resetEventArg();
                return true;
            }
            case 6: {
                pSDEDRLogicBase.resetEventArg2();
                return true;
            }
            case 7: {
                pSDEDRLogicBase.resetEventNames();
                return true;
            }
            case 8: {
                pSDEDRLogicBase.resetLogicParam();
                return true;
            }
            case 9: {
                pSDEDRLogicBase.resetLogicParam2();
                return true;
            }
            case 10: {
                pSDEDRLogicBase.resetMemo();
                return true;
            }
            case 11: {
                pSDEDRLogicBase.resetOrderValue();
                return true;
            }
            case 12: {
                pSDEDRLogicBase.resetPSDEDRDetailId();
                return true;
            }
            case 13: {
                pSDEDRLogicBase.resetPSDEDRDetailName();
                return true;
            }
            case 14: {
                pSDEDRLogicBase.resetPSDEDRId();
                return true;
            }
            case 15: {
                pSDEDRLogicBase.resetPSDEDRLogicId();
                return true;
            }
            case 16: {
                pSDEDRLogicBase.resetPSDEDRLogicName();
                return true;
            }
            case 17: {
                pSDEDRLogicBase.resetPSDEDRName();
                return true;
            }
            case 18: {
                pSDEDRLogicBase.resetPSDEId();
                return true;
            }
            case 19: {
                pSDEDRLogicBase.resetPSDELogicId();
                return true;
            }
            case 20: {
                pSDEDRLogicBase.resetPSDELogicName();
                return true;
            }
            case 21: {
                pSDEDRLogicBase.resetPSDEName();
                return true;
            }
            case 22: {
                pSDEDRLogicBase.resetPSDEUIActionId();
                return true;
            }
            case 23: {
                pSDEDRLogicBase.resetPSDEUIActionName();
                return true;
            }
            case 24: {
                pSDEDRLogicBase.resetPSSysPFPluginId();
                return true;
            }
            case 25: {
                pSDEDRLogicBase.resetPSSysPFPluginName();
                return true;
            }
            case 26: {
                pSDEDRLogicBase.resetPSSysViewLogicId();
                return true;
            }
            case 27: {
                pSDEDRLogicBase.resetPSSysViewLogicName();
                return true;
            }
            case 28: {
                pSDEDRLogicBase.resetPSSysViewPanelId();
                return true;
            }
            case 29: {
                pSDEDRLogicBase.resetPSSysViewPanelName();
                return true;
            }
            case 30: {
                pSDEDRLogicBase.resetTimer();
                return true;
            }
            case 31: {
                pSDEDRLogicBase.resetTriggerType();
                return true;
            }
            case 32: {
                pSDEDRLogicBase.resetUpdateDate();
                return true;
            }
            case 33: {
                pSDEDRLogicBase.resetUpdateMan();
                return true;
            }
            case 34: {
                pSDEDRLogicBase.resetUserCat();
                return true;
            }
            case 35: {
                pSDEDRLogicBase.resetUserTag();
                return true;
            }
            case 36: {
                pSDEDRLogicBase.resetUserTag2();
                return true;
            }
            case 37: {
                pSDEDRLogicBase.resetUserTag3();
                return true;
            }
            case 38: {
                pSDEDRLogicBase.resetUserTag4();
                return true;
            }
            case 39: {
                pSDEDRLogicBase.resetValidFlag();
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
    public PSDEDataRelation getPSDEDR() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDR();
        }
        if (this.getPSDEDRId() == null) {
            return null;
        }
        Integer n = this.objPSDEDRLock;
        synchronized (n) {
            if (this.psdedr != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEDRId(), (Object)this.psdedr.getPSDEDataRelationId()) != 0L) {
                this.psdedr = null;
            }
            if (this.psdedr == null) {
                PSDEDataRelation pSDEDataRelation = new PSDEDataRelation();
                pSDEDataRelation.setPSDEDataRelationId(this.getPSDEDRId());
                PSDEDataRelationService pSDEDataRelationService = (PSDEDataRelationService)ServiceGlobal.getService(PSDEDataRelationService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataRelationService.autoGet(pSDEDataRelation);
                this.psdedr = pSDEDataRelation;
            }
            return this.psdedr;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDRDetail getPSDEDRDetail() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDRDetail();
        }
        if (this.getPSDEDRDetailId() == null) {
            return null;
        }
        Integer n = this.objPSDEDRDetailLock;
        synchronized (n) {
            if (this.psdedrdetail != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEDRDetailId(), (Object)this.psdedrdetail.getPSDEDRDetailId()) != 0L) {
                this.psdedrdetail = null;
            }
            if (this.psdedrdetail == null) {
                PSDEDRDetail pSDEDRDetail = new PSDEDRDetail();
                pSDEDRDetail.setPSDEDRDetailId(this.getPSDEDRDetailId());
                PSDEDRDetailService pSDEDRDetailService = (PSDEDRDetailService)ServiceGlobal.getService(PSDEDRDetailService.class, (SessionFactory)this.getSessionFactory());
                pSDEDRDetailService.autoGet(pSDEDRDetail);
                this.psdedrdetail = pSDEDRDetail;
            }
            return this.psdedrdetail;
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

    private PSDEDRLogicBase getProxyEntity() {
        return this.proxyPSDEDRLogicBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEDRLogicBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEDRLogicBase) {
            this.proxyPSDEDRLogicBase = (PSDEDRLogicBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDRLogicService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
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
        fieldIndexMap.put(FIELD_PSDEDRDETAILID, 12);
        fieldIndexMap.put(FIELD_PSDEDRDETAILNAME, 13);
        fieldIndexMap.put(FIELD_PSDEDRID, 14);
        fieldIndexMap.put(FIELD_PSDEDRLOGICID, 15);
        fieldIndexMap.put(FIELD_PSDEDRLOGICNAME, 16);
        fieldIndexMap.put(FIELD_PSDEDRNAME, 17);
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

