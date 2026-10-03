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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEForm;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFormDetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormService;
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

public abstract class PSDEFormLogicBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEFormLogicBase.class);
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
    public static final String FIELD_PSDEFORMDETAILID = "PSDEFORMDETAILID";
    public static final String FIELD_PSDEFORMDETAILNAME = "PSDEFORMDETAILNAME";
    public static final String FIELD_PSDEFORMID = "PSDEFORMID";
    public static final String FIELD_PSDEFORMLOGICID = "PSDEFORMLOGICID";
    public static final String FIELD_PSDEFORMLOGICNAME = "PSDEFORMLOGICNAME";
    public static final String FIELD_PSDEFORMNAME = "PSDEFORMNAME";
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
    private static final int INDEX_PSDEFORMDETAILID = 12;
    private static final int INDEX_PSDEFORMDETAILNAME = 13;
    private static final int INDEX_PSDEFORMID = 14;
    private static final int INDEX_PSDEFORMLOGICID = 15;
    private static final int INDEX_PSDEFORMLOGICNAME = 16;
    private static final int INDEX_PSDEFORMNAME = 17;
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
    private PSDEFormLogicBase proxyPSDEFormLogicBase = null;
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
    private boolean psdeformdetailidDirtyFlag = false;
    private boolean psdeformdetailnameDirtyFlag = false;
    private boolean psdeformidDirtyFlag = false;
    private boolean psdeformlogicidDirtyFlag = false;
    private boolean psdeformlogicnameDirtyFlag = false;
    private boolean psdeformnameDirtyFlag = false;
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
    @Column(name="psdeformdetailid")
    private String psdeformdetailid;
    @Column(name="psdeformdetailname")
    private String psdeformdetailname;
    @Column(name="psdeformid")
    private String psdeformid;
    @Column(name="psdeformlogicid")
    private String psdeformlogicid;
    @Column(name="psdeformlogicname")
    private String psdeformlogicname;
    @Column(name="psdeformname")
    private String psdeformname;
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
    private Integer objPSDEFormDetailLock = new Integer(1);
    private PSDEFormDetail psdeformdetail = null;
    private Integer objPSDEFormLock = new Integer(1);
    private PSDEForm psdeform = null;
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

    public void setPSDEFormDetailId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFormDetailId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeformdetailid = string;
        this.psdeformdetailidDirtyFlag = true;
    }

    public String getPSDEFormDetailId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFormDetailId();
        }
        return this.psdeformdetailid;
    }

    public boolean isPSDEFormDetailIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFormDetailIdDirty();
        }
        return this.psdeformdetailidDirtyFlag;
    }

    public void resetPSDEFormDetailId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFormDetailId();
            return;
        }
        this.psdeformdetailidDirtyFlag = false;
        this.psdeformdetailid = null;
    }

    public void setPSDEFormDetailName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFormDetailName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeformdetailname = string;
        this.psdeformdetailnameDirtyFlag = true;
    }

    public String getPSDEFormDetailName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFormDetailName();
        }
        return this.psdeformdetailname;
    }

    public boolean isPSDEFormDetailNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFormDetailNameDirty();
        }
        return this.psdeformdetailnameDirtyFlag;
    }

    public void resetPSDEFormDetailName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFormDetailName();
            return;
        }
        this.psdeformdetailnameDirtyFlag = false;
        this.psdeformdetailname = null;
    }

    public void setPSDEFormId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFormId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeformid = string;
        this.psdeformidDirtyFlag = true;
    }

    public String getPSDEFormId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFormId();
        }
        return this.psdeformid;
    }

    public boolean isPSDEFormIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFormIdDirty();
        }
        return this.psdeformidDirtyFlag;
    }

    public void resetPSDEFormId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFormId();
            return;
        }
        this.psdeformidDirtyFlag = false;
        this.psdeformid = null;
    }

    public void setPSDEFormLogicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFormLogicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeformlogicid = string;
        this.psdeformlogicidDirtyFlag = true;
    }

    public String getPSDEFormLogicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFormLogicId();
        }
        return this.psdeformlogicid;
    }

    public boolean isPSDEFormLogicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFormLogicIdDirty();
        }
        return this.psdeformlogicidDirtyFlag;
    }

    public void resetPSDEFormLogicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFormLogicId();
            return;
        }
        this.psdeformlogicidDirtyFlag = false;
        this.psdeformlogicid = null;
    }

    public void setPSDEFormLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFormLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeformlogicname = string;
        this.psdeformlogicnameDirtyFlag = true;
    }

    public String getPSDEFormLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFormLogicName();
        }
        return this.psdeformlogicname;
    }

    public boolean isPSDEFormLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFormLogicNameDirty();
        }
        return this.psdeformlogicnameDirtyFlag;
    }

    public void resetPSDEFormLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFormLogicName();
            return;
        }
        this.psdeformlogicnameDirtyFlag = false;
        this.psdeformlogicname = null;
    }

    public void setPSDEFormName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFormName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeformname = string;
        this.psdeformnameDirtyFlag = true;
    }

    public String getPSDEFormName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFormName();
        }
        return this.psdeformname;
    }

    public boolean isPSDEFormNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFormNameDirty();
        }
        return this.psdeformnameDirtyFlag;
    }

    public void resetPSDEFormName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFormName();
            return;
        }
        this.psdeformnameDirtyFlag = false;
        this.psdeformname = null;
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
        PSDEFormLogicBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEFormLogicBase pSDEFormLogicBase) {
        pSDEFormLogicBase.resetAttrName();
        pSDEFormLogicBase.resetCreateDate();
        pSDEFormLogicBase.resetCreateMan();
        pSDEFormLogicBase.resetCustomCode();
        pSDEFormLogicBase.resetDstLogicType();
        pSDEFormLogicBase.resetEventArg();
        pSDEFormLogicBase.resetEventArg2();
        pSDEFormLogicBase.resetEventNames();
        pSDEFormLogicBase.resetLogicParam();
        pSDEFormLogicBase.resetLogicParam2();
        pSDEFormLogicBase.resetMemo();
        pSDEFormLogicBase.resetOrderValue();
        pSDEFormLogicBase.resetPSDEFormDetailId();
        pSDEFormLogicBase.resetPSDEFormDetailName();
        pSDEFormLogicBase.resetPSDEFormId();
        pSDEFormLogicBase.resetPSDEFormLogicId();
        pSDEFormLogicBase.resetPSDEFormLogicName();
        pSDEFormLogicBase.resetPSDEFormName();
        pSDEFormLogicBase.resetPSDEId();
        pSDEFormLogicBase.resetPSDELogicId();
        pSDEFormLogicBase.resetPSDELogicName();
        pSDEFormLogicBase.resetPSDEName();
        pSDEFormLogicBase.resetPSDEUIActionId();
        pSDEFormLogicBase.resetPSDEUIActionName();
        pSDEFormLogicBase.resetPSSysPFPluginId();
        pSDEFormLogicBase.resetPSSysPFPluginName();
        pSDEFormLogicBase.resetPSSysViewLogicId();
        pSDEFormLogicBase.resetPSSysViewLogicName();
        pSDEFormLogicBase.resetPSSysViewPanelId();
        pSDEFormLogicBase.resetPSSysViewPanelName();
        pSDEFormLogicBase.resetTimer();
        pSDEFormLogicBase.resetTriggerType();
        pSDEFormLogicBase.resetUpdateDate();
        pSDEFormLogicBase.resetUpdateMan();
        pSDEFormLogicBase.resetUserCat();
        pSDEFormLogicBase.resetUserTag();
        pSDEFormLogicBase.resetUserTag2();
        pSDEFormLogicBase.resetUserTag3();
        pSDEFormLogicBase.resetUserTag4();
        pSDEFormLogicBase.resetValidFlag();
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
        if (!bl || this.isPSDEFormDetailIdDirty()) {
            hashMap.put(FIELD_PSDEFORMDETAILID, this.getPSDEFormDetailId());
        }
        if (!bl || this.isPSDEFormDetailNameDirty()) {
            hashMap.put(FIELD_PSDEFORMDETAILNAME, this.getPSDEFormDetailName());
        }
        if (!bl || this.isPSDEFormIdDirty()) {
            hashMap.put(FIELD_PSDEFORMID, this.getPSDEFormId());
        }
        if (!bl || this.isPSDEFormLogicIdDirty()) {
            hashMap.put(FIELD_PSDEFORMLOGICID, this.getPSDEFormLogicId());
        }
        if (!bl || this.isPSDEFormLogicNameDirty()) {
            hashMap.put(FIELD_PSDEFORMLOGICNAME, this.getPSDEFormLogicName());
        }
        if (!bl || this.isPSDEFormNameDirty()) {
            hashMap.put(FIELD_PSDEFORMNAME, this.getPSDEFormName());
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
        return PSDEFormLogicBase.get(this, n);
    }

    private static Object get(PSDEFormLogicBase pSDEFormLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFormLogicBase.getAttrName();
            }
            case 1: {
                return pSDEFormLogicBase.getCreateDate();
            }
            case 2: {
                return pSDEFormLogicBase.getCreateMan();
            }
            case 3: {
                return pSDEFormLogicBase.getCustomCode();
            }
            case 4: {
                return pSDEFormLogicBase.getDstLogicType();
            }
            case 5: {
                return pSDEFormLogicBase.getEventArg();
            }
            case 6: {
                return pSDEFormLogicBase.getEventArg2();
            }
            case 7: {
                return pSDEFormLogicBase.getEventNames();
            }
            case 8: {
                return pSDEFormLogicBase.getLogicParam();
            }
            case 9: {
                return pSDEFormLogicBase.getLogicParam2();
            }
            case 10: {
                return pSDEFormLogicBase.getMemo();
            }
            case 11: {
                return pSDEFormLogicBase.getOrderValue();
            }
            case 12: {
                return pSDEFormLogicBase.getPSDEFormDetailId();
            }
            case 13: {
                return pSDEFormLogicBase.getPSDEFormDetailName();
            }
            case 14: {
                return pSDEFormLogicBase.getPSDEFormId();
            }
            case 15: {
                return pSDEFormLogicBase.getPSDEFormLogicId();
            }
            case 16: {
                return pSDEFormLogicBase.getPSDEFormLogicName();
            }
            case 17: {
                return pSDEFormLogicBase.getPSDEFormName();
            }
            case 18: {
                return pSDEFormLogicBase.getPSDEId();
            }
            case 19: {
                return pSDEFormLogicBase.getPSDELogicId();
            }
            case 20: {
                return pSDEFormLogicBase.getPSDELogicName();
            }
            case 21: {
                return pSDEFormLogicBase.getPSDEName();
            }
            case 22: {
                return pSDEFormLogicBase.getPSDEUIActionId();
            }
            case 23: {
                return pSDEFormLogicBase.getPSDEUIActionName();
            }
            case 24: {
                return pSDEFormLogicBase.getPSSysPFPluginId();
            }
            case 25: {
                return pSDEFormLogicBase.getPSSysPFPluginName();
            }
            case 26: {
                return pSDEFormLogicBase.getPSSysViewLogicId();
            }
            case 27: {
                return pSDEFormLogicBase.getPSSysViewLogicName();
            }
            case 28: {
                return pSDEFormLogicBase.getPSSysViewPanelId();
            }
            case 29: {
                return pSDEFormLogicBase.getPSSysViewPanelName();
            }
            case 30: {
                return pSDEFormLogicBase.getTimer();
            }
            case 31: {
                return pSDEFormLogicBase.getTriggerType();
            }
            case 32: {
                return pSDEFormLogicBase.getUpdateDate();
            }
            case 33: {
                return pSDEFormLogicBase.getUpdateMan();
            }
            case 34: {
                return pSDEFormLogicBase.getUserCat();
            }
            case 35: {
                return pSDEFormLogicBase.getUserTag();
            }
            case 36: {
                return pSDEFormLogicBase.getUserTag2();
            }
            case 37: {
                return pSDEFormLogicBase.getUserTag3();
            }
            case 38: {
                return pSDEFormLogicBase.getUserTag4();
            }
            case 39: {
                return pSDEFormLogicBase.getValidFlag();
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
        PSDEFormLogicBase.set(this, n, object);
    }

    private static void set(PSDEFormLogicBase pSDEFormLogicBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEFormLogicBase.setAttrName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDEFormLogicBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDEFormLogicBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEFormLogicBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEFormLogicBase.setDstLogicType(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEFormLogicBase.setEventArg(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEFormLogicBase.setEventArg2(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEFormLogicBase.setEventNames(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEFormLogicBase.setLogicParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEFormLogicBase.setLogicParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEFormLogicBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEFormLogicBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSDEFormLogicBase.setPSDEFormDetailId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEFormLogicBase.setPSDEFormDetailName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEFormLogicBase.setPSDEFormId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEFormLogicBase.setPSDEFormLogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEFormLogicBase.setPSDEFormLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEFormLogicBase.setPSDEFormName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEFormLogicBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEFormLogicBase.setPSDELogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDEFormLogicBase.setPSDELogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEFormLogicBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDEFormLogicBase.setPSDEUIActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDEFormLogicBase.setPSDEUIActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDEFormLogicBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDEFormLogicBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDEFormLogicBase.setPSSysViewLogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDEFormLogicBase.setPSSysViewLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDEFormLogicBase.setPSSysViewPanelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDEFormLogicBase.setPSSysViewPanelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDEFormLogicBase.setTimer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 31: {
                pSDEFormLogicBase.setTriggerType(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDEFormLogicBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 33: {
                pSDEFormLogicBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDEFormLogicBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDEFormLogicBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDEFormLogicBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSDEFormLogicBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDEFormLogicBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSDEFormLogicBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDEFormLogicBase.isNull(this, n);
    }

    private static boolean isNull(PSDEFormLogicBase pSDEFormLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFormLogicBase.getAttrName() == null;
            }
            case 1: {
                return pSDEFormLogicBase.getCreateDate() == null;
            }
            case 2: {
                return pSDEFormLogicBase.getCreateMan() == null;
            }
            case 3: {
                return pSDEFormLogicBase.getCustomCode() == null;
            }
            case 4: {
                return pSDEFormLogicBase.getDstLogicType() == null;
            }
            case 5: {
                return pSDEFormLogicBase.getEventArg() == null;
            }
            case 6: {
                return pSDEFormLogicBase.getEventArg2() == null;
            }
            case 7: {
                return pSDEFormLogicBase.getEventNames() == null;
            }
            case 8: {
                return pSDEFormLogicBase.getLogicParam() == null;
            }
            case 9: {
                return pSDEFormLogicBase.getLogicParam2() == null;
            }
            case 10: {
                return pSDEFormLogicBase.getMemo() == null;
            }
            case 11: {
                return pSDEFormLogicBase.getOrderValue() == null;
            }
            case 12: {
                return pSDEFormLogicBase.getPSDEFormDetailId() == null;
            }
            case 13: {
                return pSDEFormLogicBase.getPSDEFormDetailName() == null;
            }
            case 14: {
                return pSDEFormLogicBase.getPSDEFormId() == null;
            }
            case 15: {
                return pSDEFormLogicBase.getPSDEFormLogicId() == null;
            }
            case 16: {
                return pSDEFormLogicBase.getPSDEFormLogicName() == null;
            }
            case 17: {
                return pSDEFormLogicBase.getPSDEFormName() == null;
            }
            case 18: {
                return pSDEFormLogicBase.getPSDEId() == null;
            }
            case 19: {
                return pSDEFormLogicBase.getPSDELogicId() == null;
            }
            case 20: {
                return pSDEFormLogicBase.getPSDELogicName() == null;
            }
            case 21: {
                return pSDEFormLogicBase.getPSDEName() == null;
            }
            case 22: {
                return pSDEFormLogicBase.getPSDEUIActionId() == null;
            }
            case 23: {
                return pSDEFormLogicBase.getPSDEUIActionName() == null;
            }
            case 24: {
                return pSDEFormLogicBase.getPSSysPFPluginId() == null;
            }
            case 25: {
                return pSDEFormLogicBase.getPSSysPFPluginName() == null;
            }
            case 26: {
                return pSDEFormLogicBase.getPSSysViewLogicId() == null;
            }
            case 27: {
                return pSDEFormLogicBase.getPSSysViewLogicName() == null;
            }
            case 28: {
                return pSDEFormLogicBase.getPSSysViewPanelId() == null;
            }
            case 29: {
                return pSDEFormLogicBase.getPSSysViewPanelName() == null;
            }
            case 30: {
                return pSDEFormLogicBase.getTimer() == null;
            }
            case 31: {
                return pSDEFormLogicBase.getTriggerType() == null;
            }
            case 32: {
                return pSDEFormLogicBase.getUpdateDate() == null;
            }
            case 33: {
                return pSDEFormLogicBase.getUpdateMan() == null;
            }
            case 34: {
                return pSDEFormLogicBase.getUserCat() == null;
            }
            case 35: {
                return pSDEFormLogicBase.getUserTag() == null;
            }
            case 36: {
                return pSDEFormLogicBase.getUserTag2() == null;
            }
            case 37: {
                return pSDEFormLogicBase.getUserTag3() == null;
            }
            case 38: {
                return pSDEFormLogicBase.getUserTag4() == null;
            }
            case 39: {
                return pSDEFormLogicBase.getValidFlag() == null;
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
        return PSDEFormLogicBase.contains(this, n);
    }

    private static boolean contains(PSDEFormLogicBase pSDEFormLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFormLogicBase.isAttrNameDirty();
            }
            case 1: {
                return pSDEFormLogicBase.isCreateDateDirty();
            }
            case 2: {
                return pSDEFormLogicBase.isCreateManDirty();
            }
            case 3: {
                return pSDEFormLogicBase.isCustomCodeDirty();
            }
            case 4: {
                return pSDEFormLogicBase.isDstLogicTypeDirty();
            }
            case 5: {
                return pSDEFormLogicBase.isEventArgDirty();
            }
            case 6: {
                return pSDEFormLogicBase.isEventArg2Dirty();
            }
            case 7: {
                return pSDEFormLogicBase.isEventNamesDirty();
            }
            case 8: {
                return pSDEFormLogicBase.isLogicParamDirty();
            }
            case 9: {
                return pSDEFormLogicBase.isLogicParam2Dirty();
            }
            case 10: {
                return pSDEFormLogicBase.isMemoDirty();
            }
            case 11: {
                return pSDEFormLogicBase.isOrderValueDirty();
            }
            case 12: {
                return pSDEFormLogicBase.isPSDEFormDetailIdDirty();
            }
            case 13: {
                return pSDEFormLogicBase.isPSDEFormDetailNameDirty();
            }
            case 14: {
                return pSDEFormLogicBase.isPSDEFormIdDirty();
            }
            case 15: {
                return pSDEFormLogicBase.isPSDEFormLogicIdDirty();
            }
            case 16: {
                return pSDEFormLogicBase.isPSDEFormLogicNameDirty();
            }
            case 17: {
                return pSDEFormLogicBase.isPSDEFormNameDirty();
            }
            case 18: {
                return pSDEFormLogicBase.isPSDEIdDirty();
            }
            case 19: {
                return pSDEFormLogicBase.isPSDELogicIdDirty();
            }
            case 20: {
                return pSDEFormLogicBase.isPSDELogicNameDirty();
            }
            case 21: {
                return pSDEFormLogicBase.isPSDENameDirty();
            }
            case 22: {
                return pSDEFormLogicBase.isPSDEUIActionIdDirty();
            }
            case 23: {
                return pSDEFormLogicBase.isPSDEUIActionNameDirty();
            }
            case 24: {
                return pSDEFormLogicBase.isPSSysPFPluginIdDirty();
            }
            case 25: {
                return pSDEFormLogicBase.isPSSysPFPluginNameDirty();
            }
            case 26: {
                return pSDEFormLogicBase.isPSSysViewLogicIdDirty();
            }
            case 27: {
                return pSDEFormLogicBase.isPSSysViewLogicNameDirty();
            }
            case 28: {
                return pSDEFormLogicBase.isPSSysViewPanelIdDirty();
            }
            case 29: {
                return pSDEFormLogicBase.isPSSysViewPanelNameDirty();
            }
            case 30: {
                return pSDEFormLogicBase.isTimerDirty();
            }
            case 31: {
                return pSDEFormLogicBase.isTriggerTypeDirty();
            }
            case 32: {
                return pSDEFormLogicBase.isUpdateDateDirty();
            }
            case 33: {
                return pSDEFormLogicBase.isUpdateManDirty();
            }
            case 34: {
                return pSDEFormLogicBase.isUserCatDirty();
            }
            case 35: {
                return pSDEFormLogicBase.isUserTagDirty();
            }
            case 36: {
                return pSDEFormLogicBase.isUserTag2Dirty();
            }
            case 37: {
                return pSDEFormLogicBase.isUserTag3Dirty();
            }
            case 38: {
                return pSDEFormLogicBase.isUserTag4Dirty();
            }
            case 39: {
                return pSDEFormLogicBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEFormLogicBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEFormLogicBase pSDEFormLogicBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEFormLogicBase.getAttrName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"attrname", (Object)PSDEFormLogicBase.getJSONValue((Object)pSDEFormLogicBase.getAttrName()), (boolean)false);
        }
        if (bl || pSDEFormLogicBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEFormLogicBase.getJSONValue((Object)pSDEFormLogicBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEFormLogicBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEFormLogicBase.getJSONValue((Object)pSDEFormLogicBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEFormLogicBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSDEFormLogicBase.getJSONValue((Object)pSDEFormLogicBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSDEFormLogicBase.getDstLogicType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstlogictype", (Object)PSDEFormLogicBase.getJSONValue((Object)pSDEFormLogicBase.getDstLogicType()), (boolean)false);
        }
        if (bl || pSDEFormLogicBase.getEventArg() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eventarg", (Object)PSDEFormLogicBase.getJSONValue((Object)pSDEFormLogicBase.getEventArg()), (boolean)false);
        }
        if (bl || pSDEFormLogicBase.getEventArg2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eventarg2", (Object)PSDEFormLogicBase.getJSONValue((Object)pSDEFormLogicBase.getEventArg2()), (boolean)false);
        }
        if (bl || pSDEFormLogicBase.getEventNames() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eventnames", (Object)PSDEFormLogicBase.getJSONValue((Object)pSDEFormLogicBase.getEventNames()), (boolean)false);
        }
        if (bl || pSDEFormLogicBase.getLogicParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicparam", (Object)PSDEFormLogicBase.getJSONValue((Object)pSDEFormLogicBase.getLogicParam()), (boolean)false);
        }
        if (bl || pSDEFormLogicBase.getLogicParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicparam2", (Object)PSDEFormLogicBase.getJSONValue((Object)pSDEFormLogicBase.getLogicParam2()), (boolean)false);
        }
        if (bl || pSDEFormLogicBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEFormLogicBase.getJSONValue((Object)pSDEFormLogicBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEFormLogicBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDEFormLogicBase.getJSONValue((Object)pSDEFormLogicBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDEFormLogicBase.getPSDEFormDetailId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeformdetailid", (Object)PSDEFormLogicBase.getJSONValue((Object)pSDEFormLogicBase.getPSDEFormDetailId()), (boolean)false);
        }
        if (bl || pSDEFormLogicBase.getPSDEFormDetailName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeformdetailname", (Object)PSDEFormLogicBase.getJSONValue((Object)pSDEFormLogicBase.getPSDEFormDetailName()), (boolean)false);
        }
        if (bl || pSDEFormLogicBase.getPSDEFormId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeformid", (Object)PSDEFormLogicBase.getJSONValue((Object)pSDEFormLogicBase.getPSDEFormId()), (boolean)false);
        }
        if (bl || pSDEFormLogicBase.getPSDEFormLogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeformlogicid", (Object)PSDEFormLogicBase.getJSONValue((Object)pSDEFormLogicBase.getPSDEFormLogicId()), (boolean)false);
        }
        if (bl || pSDEFormLogicBase.getPSDEFormLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeformlogicname", (Object)PSDEFormLogicBase.getJSONValue((Object)pSDEFormLogicBase.getPSDEFormLogicName()), (boolean)false);
        }
        if (bl || pSDEFormLogicBase.getPSDEFormName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeformname", (Object)PSDEFormLogicBase.getJSONValue((Object)pSDEFormLogicBase.getPSDEFormName()), (boolean)false);
        }
        if (bl || pSDEFormLogicBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEFormLogicBase.getJSONValue((Object)pSDEFormLogicBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEFormLogicBase.getPSDELogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicid", (Object)PSDEFormLogicBase.getJSONValue((Object)pSDEFormLogicBase.getPSDELogicId()), (boolean)false);
        }
        if (bl || pSDEFormLogicBase.getPSDELogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicname", (Object)PSDEFormLogicBase.getJSONValue((Object)pSDEFormLogicBase.getPSDELogicName()), (boolean)false);
        }
        if (bl || pSDEFormLogicBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDEFormLogicBase.getJSONValue((Object)pSDEFormLogicBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDEFormLogicBase.getPSDEUIActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuiactionid", (Object)PSDEFormLogicBase.getJSONValue((Object)pSDEFormLogicBase.getPSDEUIActionId()), (boolean)false);
        }
        if (bl || pSDEFormLogicBase.getPSDEUIActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuiactionname", (Object)PSDEFormLogicBase.getJSONValue((Object)pSDEFormLogicBase.getPSDEUIActionName()), (boolean)false);
        }
        if (bl || pSDEFormLogicBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSDEFormLogicBase.getJSONValue((Object)pSDEFormLogicBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSDEFormLogicBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSDEFormLogicBase.getJSONValue((Object)pSDEFormLogicBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSDEFormLogicBase.getPSSysViewLogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewlogicid", (Object)PSDEFormLogicBase.getJSONValue((Object)pSDEFormLogicBase.getPSSysViewLogicId()), (boolean)false);
        }
        if (bl || pSDEFormLogicBase.getPSSysViewLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewlogicname", (Object)PSDEFormLogicBase.getJSONValue((Object)pSDEFormLogicBase.getPSSysViewLogicName()), (boolean)false);
        }
        if (bl || pSDEFormLogicBase.getPSSysViewPanelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelid", (Object)PSDEFormLogicBase.getJSONValue((Object)pSDEFormLogicBase.getPSSysViewPanelId()), (boolean)false);
        }
        if (bl || pSDEFormLogicBase.getPSSysViewPanelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelname", (Object)PSDEFormLogicBase.getJSONValue((Object)pSDEFormLogicBase.getPSSysViewPanelName()), (boolean)false);
        }
        if (bl || pSDEFormLogicBase.getTimer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"timer", (Object)PSDEFormLogicBase.getJSONValue((Object)pSDEFormLogicBase.getTimer()), (boolean)false);
        }
        if (bl || pSDEFormLogicBase.getTriggerType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"triggertype", (Object)PSDEFormLogicBase.getJSONValue((Object)pSDEFormLogicBase.getTriggerType()), (boolean)false);
        }
        if (bl || pSDEFormLogicBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEFormLogicBase.getJSONValue((Object)pSDEFormLogicBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEFormLogicBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEFormLogicBase.getJSONValue((Object)pSDEFormLogicBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEFormLogicBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEFormLogicBase.getJSONValue((Object)pSDEFormLogicBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEFormLogicBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEFormLogicBase.getJSONValue((Object)pSDEFormLogicBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEFormLogicBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEFormLogicBase.getJSONValue((Object)pSDEFormLogicBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEFormLogicBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEFormLogicBase.getJSONValue((Object)pSDEFormLogicBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEFormLogicBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEFormLogicBase.getJSONValue((Object)pSDEFormLogicBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDEFormLogicBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDEFormLogicBase.getJSONValue((Object)pSDEFormLogicBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEFormLogicBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEFormLogicBase pSDEFormLogicBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEFormLogicBase.getAttrName() != null) {
            object = pSDEFormLogicBase.getAttrName();
            xmlNode.setAttribute(FIELD_ATTRNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormLogicBase.getCreateDate() != null) {
            object = pSDEFormLogicBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEFormLogicBase.getCreateMan() != null) {
            object = pSDEFormLogicBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormLogicBase.getCustomCode() != null) {
            object = pSDEFormLogicBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormLogicBase.getDstLogicType() != null) {
            object = pSDEFormLogicBase.getDstLogicType();
            xmlNode.setAttribute(FIELD_DSTLOGICTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormLogicBase.getEventArg() != null) {
            object = pSDEFormLogicBase.getEventArg();
            xmlNode.setAttribute(FIELD_EVENTARG, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormLogicBase.getEventArg2() != null) {
            object = pSDEFormLogicBase.getEventArg2();
            xmlNode.setAttribute(FIELD_EVENTARG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormLogicBase.getEventNames() != null) {
            object = pSDEFormLogicBase.getEventNames();
            xmlNode.setAttribute(FIELD_EVENTNAMES, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormLogicBase.getLogicParam() != null) {
            object = pSDEFormLogicBase.getLogicParam();
            xmlNode.setAttribute(FIELD_LOGICPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormLogicBase.getLogicParam2() != null) {
            object = pSDEFormLogicBase.getLogicParam2();
            xmlNode.setAttribute(FIELD_LOGICPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormLogicBase.getMemo() != null) {
            object = pSDEFormLogicBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormLogicBase.getOrderValue() != null) {
            object = pSDEFormLogicBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormLogicBase.getPSDEFormDetailId() != null) {
            object = pSDEFormLogicBase.getPSDEFormDetailId();
            xmlNode.setAttribute(FIELD_PSDEFORMDETAILID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormLogicBase.getPSDEFormDetailName() != null) {
            object = pSDEFormLogicBase.getPSDEFormDetailName();
            xmlNode.setAttribute(FIELD_PSDEFORMDETAILNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormLogicBase.getPSDEFormId() != null) {
            object = pSDEFormLogicBase.getPSDEFormId();
            xmlNode.setAttribute(FIELD_PSDEFORMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormLogicBase.getPSDEFormLogicId() != null) {
            object = pSDEFormLogicBase.getPSDEFormLogicId();
            xmlNode.setAttribute(FIELD_PSDEFORMLOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormLogicBase.getPSDEFormLogicName() != null) {
            object = pSDEFormLogicBase.getPSDEFormLogicName();
            xmlNode.setAttribute(FIELD_PSDEFORMLOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormLogicBase.getPSDEFormName() != null) {
            object = pSDEFormLogicBase.getPSDEFormName();
            xmlNode.setAttribute(FIELD_PSDEFORMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormLogicBase.getPSDEId() != null) {
            object = pSDEFormLogicBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormLogicBase.getPSDELogicId() != null) {
            object = pSDEFormLogicBase.getPSDELogicId();
            xmlNode.setAttribute(FIELD_PSDELOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormLogicBase.getPSDELogicName() != null) {
            object = pSDEFormLogicBase.getPSDELogicName();
            xmlNode.setAttribute(FIELD_PSDELOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormLogicBase.getPSDEName() != null) {
            object = pSDEFormLogicBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormLogicBase.getPSDEUIActionId() != null) {
            object = pSDEFormLogicBase.getPSDEUIActionId();
            xmlNode.setAttribute(FIELD_PSDEUIACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormLogicBase.getPSDEUIActionName() != null) {
            object = pSDEFormLogicBase.getPSDEUIActionName();
            xmlNode.setAttribute(FIELD_PSDEUIACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormLogicBase.getPSSysPFPluginId() != null) {
            object = pSDEFormLogicBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormLogicBase.getPSSysPFPluginName() != null) {
            object = pSDEFormLogicBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormLogicBase.getPSSysViewLogicId() != null) {
            object = pSDEFormLogicBase.getPSSysViewLogicId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWLOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormLogicBase.getPSSysViewLogicName() != null) {
            object = pSDEFormLogicBase.getPSSysViewLogicName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWLOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormLogicBase.getPSSysViewPanelId() != null) {
            object = pSDEFormLogicBase.getPSSysViewPanelId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormLogicBase.getPSSysViewPanelName() != null) {
            object = pSDEFormLogicBase.getPSSysViewPanelName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormLogicBase.getTimer() != null) {
            object = pSDEFormLogicBase.getTimer();
            xmlNode.setAttribute(FIELD_TIMER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormLogicBase.getTriggerType() != null) {
            object = pSDEFormLogicBase.getTriggerType();
            xmlNode.setAttribute(FIELD_TRIGGERTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormLogicBase.getUpdateDate() != null) {
            object = pSDEFormLogicBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEFormLogicBase.getUpdateMan() != null) {
            object = pSDEFormLogicBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormLogicBase.getUserCat() != null) {
            object = pSDEFormLogicBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormLogicBase.getUserTag() != null) {
            object = pSDEFormLogicBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormLogicBase.getUserTag2() != null) {
            object = pSDEFormLogicBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormLogicBase.getUserTag3() != null) {
            object = pSDEFormLogicBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormLogicBase.getUserTag4() != null) {
            object = pSDEFormLogicBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormLogicBase.getValidFlag() != null) {
            object = pSDEFormLogicBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEFormLogicBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEFormLogicBase pSDEFormLogicBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEFormLogicBase.isAttrNameDirty() && (bl || pSDEFormLogicBase.getAttrName() != null)) {
            iDataObject.set(FIELD_ATTRNAME, (Object)pSDEFormLogicBase.getAttrName());
        }
        if (pSDEFormLogicBase.isCreateDateDirty() && (bl || pSDEFormLogicBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEFormLogicBase.getCreateDate());
        }
        if (pSDEFormLogicBase.isCreateManDirty() && (bl || pSDEFormLogicBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEFormLogicBase.getCreateMan());
        }
        if (pSDEFormLogicBase.isCustomCodeDirty() && (bl || pSDEFormLogicBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSDEFormLogicBase.getCustomCode());
        }
        if (pSDEFormLogicBase.isDstLogicTypeDirty() && (bl || pSDEFormLogicBase.getDstLogicType() != null)) {
            iDataObject.set(FIELD_DSTLOGICTYPE, (Object)pSDEFormLogicBase.getDstLogicType());
        }
        if (pSDEFormLogicBase.isEventArgDirty() && (bl || pSDEFormLogicBase.getEventArg() != null)) {
            iDataObject.set(FIELD_EVENTARG, (Object)pSDEFormLogicBase.getEventArg());
        }
        if (pSDEFormLogicBase.isEventArg2Dirty() && (bl || pSDEFormLogicBase.getEventArg2() != null)) {
            iDataObject.set(FIELD_EVENTARG2, (Object)pSDEFormLogicBase.getEventArg2());
        }
        if (pSDEFormLogicBase.isEventNamesDirty() && (bl || pSDEFormLogicBase.getEventNames() != null)) {
            iDataObject.set(FIELD_EVENTNAMES, (Object)pSDEFormLogicBase.getEventNames());
        }
        if (pSDEFormLogicBase.isLogicParamDirty() && (bl || pSDEFormLogicBase.getLogicParam() != null)) {
            iDataObject.set(FIELD_LOGICPARAM, (Object)pSDEFormLogicBase.getLogicParam());
        }
        if (pSDEFormLogicBase.isLogicParam2Dirty() && (bl || pSDEFormLogicBase.getLogicParam2() != null)) {
            iDataObject.set(FIELD_LOGICPARAM2, (Object)pSDEFormLogicBase.getLogicParam2());
        }
        if (pSDEFormLogicBase.isMemoDirty() && (bl || pSDEFormLogicBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEFormLogicBase.getMemo());
        }
        if (pSDEFormLogicBase.isOrderValueDirty() && (bl || pSDEFormLogicBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDEFormLogicBase.getOrderValue());
        }
        if (pSDEFormLogicBase.isPSDEFormDetailIdDirty() && (bl || pSDEFormLogicBase.getPSDEFormDetailId() != null)) {
            iDataObject.set(FIELD_PSDEFORMDETAILID, (Object)pSDEFormLogicBase.getPSDEFormDetailId());
        }
        if (pSDEFormLogicBase.isPSDEFormDetailNameDirty() && (bl || pSDEFormLogicBase.getPSDEFormDetailName() != null)) {
            iDataObject.set(FIELD_PSDEFORMDETAILNAME, (Object)pSDEFormLogicBase.getPSDEFormDetailName());
        }
        if (pSDEFormLogicBase.isPSDEFormIdDirty() && (bl || pSDEFormLogicBase.getPSDEFormId() != null)) {
            iDataObject.set(FIELD_PSDEFORMID, (Object)pSDEFormLogicBase.getPSDEFormId());
        }
        if (pSDEFormLogicBase.isPSDEFormLogicIdDirty() && (bl || pSDEFormLogicBase.getPSDEFormLogicId() != null)) {
            iDataObject.set(FIELD_PSDEFORMLOGICID, (Object)pSDEFormLogicBase.getPSDEFormLogicId());
        }
        if (pSDEFormLogicBase.isPSDEFormLogicNameDirty() && (bl || pSDEFormLogicBase.getPSDEFormLogicName() != null)) {
            iDataObject.set(FIELD_PSDEFORMLOGICNAME, (Object)pSDEFormLogicBase.getPSDEFormLogicName());
        }
        if (pSDEFormLogicBase.isPSDEFormNameDirty() && (bl || pSDEFormLogicBase.getPSDEFormName() != null)) {
            iDataObject.set(FIELD_PSDEFORMNAME, (Object)pSDEFormLogicBase.getPSDEFormName());
        }
        if (pSDEFormLogicBase.isPSDEIdDirty() && (bl || pSDEFormLogicBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEFormLogicBase.getPSDEId());
        }
        if (pSDEFormLogicBase.isPSDELogicIdDirty() && (bl || pSDEFormLogicBase.getPSDELogicId() != null)) {
            iDataObject.set(FIELD_PSDELOGICID, (Object)pSDEFormLogicBase.getPSDELogicId());
        }
        if (pSDEFormLogicBase.isPSDELogicNameDirty() && (bl || pSDEFormLogicBase.getPSDELogicName() != null)) {
            iDataObject.set(FIELD_PSDELOGICNAME, (Object)pSDEFormLogicBase.getPSDELogicName());
        }
        if (pSDEFormLogicBase.isPSDENameDirty() && (bl || pSDEFormLogicBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDEFormLogicBase.getPSDEName());
        }
        if (pSDEFormLogicBase.isPSDEUIActionIdDirty() && (bl || pSDEFormLogicBase.getPSDEUIActionId() != null)) {
            iDataObject.set(FIELD_PSDEUIACTIONID, (Object)pSDEFormLogicBase.getPSDEUIActionId());
        }
        if (pSDEFormLogicBase.isPSDEUIActionNameDirty() && (bl || pSDEFormLogicBase.getPSDEUIActionName() != null)) {
            iDataObject.set(FIELD_PSDEUIACTIONNAME, (Object)pSDEFormLogicBase.getPSDEUIActionName());
        }
        if (pSDEFormLogicBase.isPSSysPFPluginIdDirty() && (bl || pSDEFormLogicBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSDEFormLogicBase.getPSSysPFPluginId());
        }
        if (pSDEFormLogicBase.isPSSysPFPluginNameDirty() && (bl || pSDEFormLogicBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSDEFormLogicBase.getPSSysPFPluginName());
        }
        if (pSDEFormLogicBase.isPSSysViewLogicIdDirty() && (bl || pSDEFormLogicBase.getPSSysViewLogicId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWLOGICID, (Object)pSDEFormLogicBase.getPSSysViewLogicId());
        }
        if (pSDEFormLogicBase.isPSSysViewLogicNameDirty() && (bl || pSDEFormLogicBase.getPSSysViewLogicName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWLOGICNAME, (Object)pSDEFormLogicBase.getPSSysViewLogicName());
        }
        if (pSDEFormLogicBase.isPSSysViewPanelIdDirty() && (bl || pSDEFormLogicBase.getPSSysViewPanelId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELID, (Object)pSDEFormLogicBase.getPSSysViewPanelId());
        }
        if (pSDEFormLogicBase.isPSSysViewPanelNameDirty() && (bl || pSDEFormLogicBase.getPSSysViewPanelName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELNAME, (Object)pSDEFormLogicBase.getPSSysViewPanelName());
        }
        if (pSDEFormLogicBase.isTimerDirty() && (bl || pSDEFormLogicBase.getTimer() != null)) {
            iDataObject.set(FIELD_TIMER, (Object)pSDEFormLogicBase.getTimer());
        }
        if (pSDEFormLogicBase.isTriggerTypeDirty() && (bl || pSDEFormLogicBase.getTriggerType() != null)) {
            iDataObject.set(FIELD_TRIGGERTYPE, (Object)pSDEFormLogicBase.getTriggerType());
        }
        if (pSDEFormLogicBase.isUpdateDateDirty() && (bl || pSDEFormLogicBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEFormLogicBase.getUpdateDate());
        }
        if (pSDEFormLogicBase.isUpdateManDirty() && (bl || pSDEFormLogicBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEFormLogicBase.getUpdateMan());
        }
        if (pSDEFormLogicBase.isUserCatDirty() && (bl || pSDEFormLogicBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEFormLogicBase.getUserCat());
        }
        if (pSDEFormLogicBase.isUserTagDirty() && (bl || pSDEFormLogicBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEFormLogicBase.getUserTag());
        }
        if (pSDEFormLogicBase.isUserTag2Dirty() && (bl || pSDEFormLogicBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEFormLogicBase.getUserTag2());
        }
        if (pSDEFormLogicBase.isUserTag3Dirty() && (bl || pSDEFormLogicBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEFormLogicBase.getUserTag3());
        }
        if (pSDEFormLogicBase.isUserTag4Dirty() && (bl || pSDEFormLogicBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEFormLogicBase.getUserTag4());
        }
        if (pSDEFormLogicBase.isValidFlagDirty() && (bl || pSDEFormLogicBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDEFormLogicBase.getValidFlag());
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
        return PSDEFormLogicBase.remove(this, n);
    }

    private static boolean remove(PSDEFormLogicBase pSDEFormLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEFormLogicBase.resetAttrName();
                return true;
            }
            case 1: {
                pSDEFormLogicBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDEFormLogicBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDEFormLogicBase.resetCustomCode();
                return true;
            }
            case 4: {
                pSDEFormLogicBase.resetDstLogicType();
                return true;
            }
            case 5: {
                pSDEFormLogicBase.resetEventArg();
                return true;
            }
            case 6: {
                pSDEFormLogicBase.resetEventArg2();
                return true;
            }
            case 7: {
                pSDEFormLogicBase.resetEventNames();
                return true;
            }
            case 8: {
                pSDEFormLogicBase.resetLogicParam();
                return true;
            }
            case 9: {
                pSDEFormLogicBase.resetLogicParam2();
                return true;
            }
            case 10: {
                pSDEFormLogicBase.resetMemo();
                return true;
            }
            case 11: {
                pSDEFormLogicBase.resetOrderValue();
                return true;
            }
            case 12: {
                pSDEFormLogicBase.resetPSDEFormDetailId();
                return true;
            }
            case 13: {
                pSDEFormLogicBase.resetPSDEFormDetailName();
                return true;
            }
            case 14: {
                pSDEFormLogicBase.resetPSDEFormId();
                return true;
            }
            case 15: {
                pSDEFormLogicBase.resetPSDEFormLogicId();
                return true;
            }
            case 16: {
                pSDEFormLogicBase.resetPSDEFormLogicName();
                return true;
            }
            case 17: {
                pSDEFormLogicBase.resetPSDEFormName();
                return true;
            }
            case 18: {
                pSDEFormLogicBase.resetPSDEId();
                return true;
            }
            case 19: {
                pSDEFormLogicBase.resetPSDELogicId();
                return true;
            }
            case 20: {
                pSDEFormLogicBase.resetPSDELogicName();
                return true;
            }
            case 21: {
                pSDEFormLogicBase.resetPSDEName();
                return true;
            }
            case 22: {
                pSDEFormLogicBase.resetPSDEUIActionId();
                return true;
            }
            case 23: {
                pSDEFormLogicBase.resetPSDEUIActionName();
                return true;
            }
            case 24: {
                pSDEFormLogicBase.resetPSSysPFPluginId();
                return true;
            }
            case 25: {
                pSDEFormLogicBase.resetPSSysPFPluginName();
                return true;
            }
            case 26: {
                pSDEFormLogicBase.resetPSSysViewLogicId();
                return true;
            }
            case 27: {
                pSDEFormLogicBase.resetPSSysViewLogicName();
                return true;
            }
            case 28: {
                pSDEFormLogicBase.resetPSSysViewPanelId();
                return true;
            }
            case 29: {
                pSDEFormLogicBase.resetPSSysViewPanelName();
                return true;
            }
            case 30: {
                pSDEFormLogicBase.resetTimer();
                return true;
            }
            case 31: {
                pSDEFormLogicBase.resetTriggerType();
                return true;
            }
            case 32: {
                pSDEFormLogicBase.resetUpdateDate();
                return true;
            }
            case 33: {
                pSDEFormLogicBase.resetUpdateMan();
                return true;
            }
            case 34: {
                pSDEFormLogicBase.resetUserCat();
                return true;
            }
            case 35: {
                pSDEFormLogicBase.resetUserTag();
                return true;
            }
            case 36: {
                pSDEFormLogicBase.resetUserTag2();
                return true;
            }
            case 37: {
                pSDEFormLogicBase.resetUserTag3();
                return true;
            }
            case 38: {
                pSDEFormLogicBase.resetUserTag4();
                return true;
            }
            case 39: {
                pSDEFormLogicBase.resetValidFlag();
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
    public PSDEFormDetail getPSDEFormDetail() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFormDetail();
        }
        if (this.getPSDEFormDetailId() == null) {
            return null;
        }
        Integer n = this.objPSDEFormDetailLock;
        synchronized (n) {
            if (this.psdeformdetail != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEFormDetailId(), (Object)this.psdeformdetail.getPSDEFormDetailId()) != 0L) {
                this.psdeformdetail = null;
            }
            if (this.psdeformdetail == null) {
                PSDEFormDetail pSDEFormDetail = new PSDEFormDetail();
                pSDEFormDetail.setPSDEFormDetailId(this.getPSDEFormDetailId());
                PSDEFormDetailService pSDEFormDetailService = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
                pSDEFormDetailService.autoGet(pSDEFormDetail);
                this.psdeformdetail = pSDEFormDetail;
            }
            return this.psdeformdetail;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEForm getPSDEForm() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEForm();
        }
        if (this.getPSDEFormId() == null) {
            return null;
        }
        Integer n = this.objPSDEFormLock;
        synchronized (n) {
            if (this.psdeform != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEFormId(), (Object)this.psdeform.getPSDEFormId()) != 0L) {
                this.psdeform = null;
            }
            if (this.psdeform == null) {
                PSDEForm pSDEForm = new PSDEForm();
                pSDEForm.setPSDEFormId(this.getPSDEFormId());
                PSDEFormService pSDEFormService = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, (SessionFactory)this.getSessionFactory());
                pSDEFormService.autoGet(pSDEForm);
                this.psdeform = pSDEForm;
            }
            return this.psdeform;
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

    private PSDEFormLogicBase getProxyEntity() {
        return this.proxyPSDEFormLogicBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEFormLogicBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEFormLogicBase) {
            this.proxyPSDEFormLogicBase = (PSDEFormLogicBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFormLogicService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
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
        fieldIndexMap.put(FIELD_PSDEFORMDETAILID, 12);
        fieldIndexMap.put(FIELD_PSDEFORMDETAILNAME, 13);
        fieldIndexMap.put(FIELD_PSDEFORMID, 14);
        fieldIndexMap.put(FIELD_PSDEFORMLOGICID, 15);
        fieldIndexMap.put(FIELD_PSDEFORMLOGICNAME, 16);
        fieldIndexMap.put(FIELD_PSDEFORMNAME, 17);
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

