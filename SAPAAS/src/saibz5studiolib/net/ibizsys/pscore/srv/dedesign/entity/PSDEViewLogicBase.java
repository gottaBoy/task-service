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
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewCtrl;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewLogic;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewLogicService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewLogic;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanel;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewLogicService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEViewLogicBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEViewLogicBase.class);
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
    public static final String FIELD_PARAMPSDEVIEWCTRLID = "PARAMPSDEVIEWCTRLID";
    public static final String FIELD_PARAMPSDEVIEWCTRLNAME = "PARAMPSDEVIEWCTRLNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDELOGICID = "PSDELOGICID";
    public static final String FIELD_PSDELOGICNAME = "PSDELOGICNAME";
    public static final String FIELD_PSDEUIACTIONID = "PSDEUIACTIONID";
    public static final String FIELD_PSDEUIACTIONNAME = "PSDEUIACTIONNAME";
    public static final String FIELD_PSDEVIEWBASEID = "PSDEVIEWBASEID";
    public static final String FIELD_PSDEVIEWBASENAME = "PSDEVIEWBASENAME";
    public static final String FIELD_PSDEVIEWCTRLID = "PSDEVIEWCTRLID";
    public static final String FIELD_PSDEVIEWCTRLNAME = "PSDEVIEWCTRLNAME";
    public static final String FIELD_PSDEVIEWLOGICID = "PSDEVIEWLOGICID";
    public static final String FIELD_PSDEVIEWLOGICNAME = "PSDEVIEWLOGICNAME";
    public static final String FIELD_PSDEVIEWLOGICTYPE = "PSDEVIEWLOGICTYPE";
    public static final String FIELD_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String FIELD_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String FIELD_PSSYSVIEWLOGICID = "PSSYSVIEWLOGICID";
    public static final String FIELD_PSSYSVIEWLOGICNAME = "PSSYSVIEWLOGICNAME";
    public static final String FIELD_PSSYSVIEWPANELID = "PSSYSVIEWPANELID";
    public static final String FIELD_PSSYSVIEWPANELNAME = "PSSYSVIEWPANELNAME";
    public static final String FIELD_REFPSDEVIEWLOGICID = "REFPSDEVIEWLOGICID";
    public static final String FIELD_REFPSDEVIEWLOGICNAME = "REFPSDEVIEWLOGICNAME";
    public static final String FIELD_TIMER = "TIMER";
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
    private static final int INDEX_PARAMPSDEVIEWCTRLID = 12;
    private static final int INDEX_PARAMPSDEVIEWCTRLNAME = 13;
    private static final int INDEX_PSDEID = 14;
    private static final int INDEX_PSDELOGICID = 15;
    private static final int INDEX_PSDELOGICNAME = 16;
    private static final int INDEX_PSDEUIACTIONID = 17;
    private static final int INDEX_PSDEUIACTIONNAME = 18;
    private static final int INDEX_PSDEVIEWBASEID = 19;
    private static final int INDEX_PSDEVIEWBASENAME = 20;
    private static final int INDEX_PSDEVIEWCTRLID = 21;
    private static final int INDEX_PSDEVIEWCTRLNAME = 22;
    private static final int INDEX_PSDEVIEWLOGICID = 23;
    private static final int INDEX_PSDEVIEWLOGICNAME = 24;
    private static final int INDEX_PSDEVIEWLOGICTYPE = 25;
    private static final int INDEX_PSSYSPFPLUGINID = 26;
    private static final int INDEX_PSSYSPFPLUGINNAME = 27;
    private static final int INDEX_PSSYSVIEWLOGICID = 28;
    private static final int INDEX_PSSYSVIEWLOGICNAME = 29;
    private static final int INDEX_PSSYSVIEWPANELID = 30;
    private static final int INDEX_PSSYSVIEWPANELNAME = 31;
    private static final int INDEX_REFPSDEVIEWLOGICID = 32;
    private static final int INDEX_REFPSDEVIEWLOGICNAME = 33;
    private static final int INDEX_TIMER = 34;
    private static final int INDEX_UPDATEDATE = 35;
    private static final int INDEX_UPDATEMAN = 36;
    private static final int INDEX_USERCAT = 37;
    private static final int INDEX_USERTAG = 38;
    private static final int INDEX_USERTAG2 = 39;
    private static final int INDEX_USERTAG3 = 40;
    private static final int INDEX_USERTAG4 = 41;
    private static final int INDEX_VALIDFLAG = 42;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEViewLogicBase proxyPSDEViewLogicBase = null;
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
    private boolean parampsdeviewctrlidDirtyFlag = false;
    private boolean parampsdeviewctrlnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdelogicidDirtyFlag = false;
    private boolean psdelogicnameDirtyFlag = false;
    private boolean psdeuiactionidDirtyFlag = false;
    private boolean psdeuiactionnameDirtyFlag = false;
    private boolean psdeviewbaseidDirtyFlag = false;
    private boolean psdeviewbasenameDirtyFlag = false;
    private boolean psdeviewctrlidDirtyFlag = false;
    private boolean psdeviewctrlnameDirtyFlag = false;
    private boolean psdeviewlogicidDirtyFlag = false;
    private boolean psdeviewlogicnameDirtyFlag = false;
    private boolean psdeviewlogictypeDirtyFlag = false;
    private boolean pssyspfpluginidDirtyFlag = false;
    private boolean pssyspfpluginnameDirtyFlag = false;
    private boolean pssysviewlogicidDirtyFlag = false;
    private boolean pssysviewlogicnameDirtyFlag = false;
    private boolean pssysviewpanelidDirtyFlag = false;
    private boolean pssysviewpanelnameDirtyFlag = false;
    private boolean refpsdeviewlogicidDirtyFlag = false;
    private boolean refpsdeviewlogicnameDirtyFlag = false;
    private boolean timerDirtyFlag = false;
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
    @Column(name="parampsdeviewctrlid")
    private String parampsdeviewctrlid;
    @Column(name="parampsdeviewctrlname")
    private String parampsdeviewctrlname;
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
    @Column(name="psdeviewbaseid")
    private String psdeviewbaseid;
    @Column(name="psdeviewbasename")
    private String psdeviewbasename;
    @Column(name="psdeviewctrlid")
    private String psdeviewctrlid;
    @Column(name="psdeviewctrlname")
    private String psdeviewctrlname;
    @Column(name="psdeviewlogicid")
    private String psdeviewlogicid;
    @Column(name="psdeviewlogicname")
    private String psdeviewlogicname;
    @Column(name="psdeviewlogictype")
    private String psdeviewlogictype;
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
    @Column(name="refpsdeviewlogicid")
    private String refpsdeviewlogicid;
    @Column(name="refpsdeviewlogicname")
    private String refpsdeviewlogicname;
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
    private Integer objPSDELogicLock = new Integer(1);
    private PSDELogic psdelogic = null;
    private Integer objPSDEUIActionLock = new Integer(1);
    private PSDEUIAction psdeuiaction = null;
    private Integer objPSDEViewBaseLock = new Integer(1);
    private PSDEViewBase psdeviewbase = null;
    private Integer objParamPSDEViewCtrlLock = new Integer(1);
    private PSDEViewCtrl parampsdeviewctrl = null;
    private Integer objPSDEViewCtrlLock = new Integer(1);
    private PSDEViewCtrl psdeviewctrl = null;
    private Integer objRefPSDEViewLogicLock = new Integer(1);
    private PSDEViewLogic refpsdeviewlogic = null;
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

    public void setParamPSDEViewCtrlId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParamPSDEViewCtrlId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.parampsdeviewctrlid = string;
        this.parampsdeviewctrlidDirtyFlag = true;
    }

    public String getParamPSDEViewCtrlId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParamPSDEViewCtrlId();
        }
        return this.parampsdeviewctrlid;
    }

    public boolean isParamPSDEViewCtrlIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParamPSDEViewCtrlIdDirty();
        }
        return this.parampsdeviewctrlidDirtyFlag;
    }

    public void resetParamPSDEViewCtrlId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParamPSDEViewCtrlId();
            return;
        }
        this.parampsdeviewctrlidDirtyFlag = false;
        this.parampsdeviewctrlid = null;
    }

    public void setParamPSDEViewCtrlName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParamPSDEViewCtrlName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.parampsdeviewctrlname = string;
        this.parampsdeviewctrlnameDirtyFlag = true;
    }

    public String getParamPSDEViewCtrlName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParamPSDEViewCtrlName();
        }
        return this.parampsdeviewctrlname;
    }

    public boolean isParamPSDEViewCtrlNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParamPSDEViewCtrlNameDirty();
        }
        return this.parampsdeviewctrlnameDirtyFlag;
    }

    public void resetParamPSDEViewCtrlName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParamPSDEViewCtrlName();
            return;
        }
        this.parampsdeviewctrlnameDirtyFlag = false;
        this.parampsdeviewctrlname = null;
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

    public void setPSDEViewBaseId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewBaseId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewbaseid = string;
        this.psdeviewbaseidDirtyFlag = true;
    }

    public String getPSDEViewBaseId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewBaseId();
        }
        return this.psdeviewbaseid;
    }

    public boolean isPSDEViewBaseIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewBaseIdDirty();
        }
        return this.psdeviewbaseidDirtyFlag;
    }

    public void resetPSDEViewBaseId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewBaseId();
            return;
        }
        this.psdeviewbaseidDirtyFlag = false;
        this.psdeviewbaseid = null;
    }

    public void setPSDEViewBaseName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewBaseName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewbasename = string;
        this.psdeviewbasenameDirtyFlag = true;
    }

    public String getPSDEViewBaseName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewBaseName();
        }
        return this.psdeviewbasename;
    }

    public boolean isPSDEViewBaseNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewBaseNameDirty();
        }
        return this.psdeviewbasenameDirtyFlag;
    }

    public void resetPSDEViewBaseName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewBaseName();
            return;
        }
        this.psdeviewbasenameDirtyFlag = false;
        this.psdeviewbasename = null;
    }

    public void setPSDEViewCtrlId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewCtrlId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewctrlid = string;
        this.psdeviewctrlidDirtyFlag = true;
    }

    public String getPSDEViewCtrlId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewCtrlId();
        }
        return this.psdeviewctrlid;
    }

    public boolean isPSDEViewCtrlIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewCtrlIdDirty();
        }
        return this.psdeviewctrlidDirtyFlag;
    }

    public void resetPSDEViewCtrlId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewCtrlId();
            return;
        }
        this.psdeviewctrlidDirtyFlag = false;
        this.psdeviewctrlid = null;
    }

    public void setPSDEViewCtrlName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewCtrlName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewctrlname = string;
        this.psdeviewctrlnameDirtyFlag = true;
    }

    public String getPSDEViewCtrlName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewCtrlName();
        }
        return this.psdeviewctrlname;
    }

    public boolean isPSDEViewCtrlNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewCtrlNameDirty();
        }
        return this.psdeviewctrlnameDirtyFlag;
    }

    public void resetPSDEViewCtrlName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewCtrlName();
            return;
        }
        this.psdeviewctrlnameDirtyFlag = false;
        this.psdeviewctrlname = null;
    }

    public void setPSDEViewLogicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewLogicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewlogicid = string;
        this.psdeviewlogicidDirtyFlag = true;
    }

    public String getPSDEViewLogicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewLogicId();
        }
        return this.psdeviewlogicid;
    }

    public boolean isPSDEViewLogicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewLogicIdDirty();
        }
        return this.psdeviewlogicidDirtyFlag;
    }

    public void resetPSDEViewLogicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewLogicId();
            return;
        }
        this.psdeviewlogicidDirtyFlag = false;
        this.psdeviewlogicid = null;
    }

    public void setPSDEViewLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        if (string != null) {
            string = string.toUpperCase();
        }
        this.psdeviewlogicname = string;
        this.psdeviewlogicnameDirtyFlag = true;
    }

    public String getPSDEViewLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewLogicName();
        }
        return this.psdeviewlogicname;
    }

    public boolean isPSDEViewLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewLogicNameDirty();
        }
        return this.psdeviewlogicnameDirtyFlag;
    }

    public void resetPSDEViewLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewLogicName();
            return;
        }
        this.psdeviewlogicnameDirtyFlag = false;
        this.psdeviewlogicname = null;
    }

    public void setPSDEViewLogicType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewLogicType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewlogictype = string;
        this.psdeviewlogictypeDirtyFlag = true;
    }

    public String getPSDEViewLogicType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewLogicType();
        }
        return this.psdeviewlogictype;
    }

    public boolean isPSDEViewLogicTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewLogicTypeDirty();
        }
        return this.psdeviewlogictypeDirtyFlag;
    }

    public void resetPSDEViewLogicType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewLogicType();
            return;
        }
        this.psdeviewlogictypeDirtyFlag = false;
        this.psdeviewlogictype = null;
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

    public void setRefPSDEViewLogicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSDEViewLogicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpsdeviewlogicid = string;
        this.refpsdeviewlogicidDirtyFlag = true;
    }

    public String getRefPSDEViewLogicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDEViewLogicId();
        }
        return this.refpsdeviewlogicid;
    }

    public boolean isRefPSDEViewLogicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSDEViewLogicIdDirty();
        }
        return this.refpsdeviewlogicidDirtyFlag;
    }

    public void resetRefPSDEViewLogicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSDEViewLogicId();
            return;
        }
        this.refpsdeviewlogicidDirtyFlag = false;
        this.refpsdeviewlogicid = null;
    }

    public void setRefPSDEViewLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSDEViewLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpsdeviewlogicname = string;
        this.refpsdeviewlogicnameDirtyFlag = true;
    }

    public String getRefPSDEViewLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDEViewLogicName();
        }
        return this.refpsdeviewlogicname;
    }

    public boolean isRefPSDEViewLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSDEViewLogicNameDirty();
        }
        return this.refpsdeviewlogicnameDirtyFlag;
    }

    public void resetRefPSDEViewLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSDEViewLogicName();
            return;
        }
        this.refpsdeviewlogicnameDirtyFlag = false;
        this.refpsdeviewlogicname = null;
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
        PSDEViewLogicBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEViewLogicBase pSDEViewLogicBase) {
        pSDEViewLogicBase.resetAttrName();
        pSDEViewLogicBase.resetCreateDate();
        pSDEViewLogicBase.resetCreateMan();
        pSDEViewLogicBase.resetCustomCode();
        pSDEViewLogicBase.resetDstLogicType();
        pSDEViewLogicBase.resetEventArg();
        pSDEViewLogicBase.resetEventArg2();
        pSDEViewLogicBase.resetEventNames();
        pSDEViewLogicBase.resetLogicParam();
        pSDEViewLogicBase.resetLogicParam2();
        pSDEViewLogicBase.resetMemo();
        pSDEViewLogicBase.resetOrderValue();
        pSDEViewLogicBase.resetParamPSDEViewCtrlId();
        pSDEViewLogicBase.resetParamPSDEViewCtrlName();
        pSDEViewLogicBase.resetPSDEId();
        pSDEViewLogicBase.resetPSDELogicId();
        pSDEViewLogicBase.resetPSDELogicName();
        pSDEViewLogicBase.resetPSDEUIActionId();
        pSDEViewLogicBase.resetPSDEUIActionName();
        pSDEViewLogicBase.resetPSDEViewBaseId();
        pSDEViewLogicBase.resetPSDEViewBaseName();
        pSDEViewLogicBase.resetPSDEViewCtrlId();
        pSDEViewLogicBase.resetPSDEViewCtrlName();
        pSDEViewLogicBase.resetPSDEViewLogicId();
        pSDEViewLogicBase.resetPSDEViewLogicName();
        pSDEViewLogicBase.resetPSDEViewLogicType();
        pSDEViewLogicBase.resetPSSysPFPluginId();
        pSDEViewLogicBase.resetPSSysPFPluginName();
        pSDEViewLogicBase.resetPSSysViewLogicId();
        pSDEViewLogicBase.resetPSSysViewLogicName();
        pSDEViewLogicBase.resetPSSysViewPanelId();
        pSDEViewLogicBase.resetPSSysViewPanelName();
        pSDEViewLogicBase.resetRefPSDEViewLogicId();
        pSDEViewLogicBase.resetRefPSDEViewLogicName();
        pSDEViewLogicBase.resetTimer();
        pSDEViewLogicBase.resetUpdateDate();
        pSDEViewLogicBase.resetUpdateMan();
        pSDEViewLogicBase.resetUserCat();
        pSDEViewLogicBase.resetUserTag();
        pSDEViewLogicBase.resetUserTag2();
        pSDEViewLogicBase.resetUserTag3();
        pSDEViewLogicBase.resetUserTag4();
        pSDEViewLogicBase.resetValidFlag();
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
        if (!bl || this.isParamPSDEViewCtrlIdDirty()) {
            hashMap.put(FIELD_PARAMPSDEVIEWCTRLID, this.getParamPSDEViewCtrlId());
        }
        if (!bl || this.isParamPSDEViewCtrlNameDirty()) {
            hashMap.put(FIELD_PARAMPSDEVIEWCTRLNAME, this.getParamPSDEViewCtrlName());
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
        if (!bl || this.isPSDEViewBaseIdDirty()) {
            hashMap.put(FIELD_PSDEVIEWBASEID, this.getPSDEViewBaseId());
        }
        if (!bl || this.isPSDEViewBaseNameDirty()) {
            hashMap.put(FIELD_PSDEVIEWBASENAME, this.getPSDEViewBaseName());
        }
        if (!bl || this.isPSDEViewCtrlIdDirty()) {
            hashMap.put(FIELD_PSDEVIEWCTRLID, this.getPSDEViewCtrlId());
        }
        if (!bl || this.isPSDEViewCtrlNameDirty()) {
            hashMap.put(FIELD_PSDEVIEWCTRLNAME, this.getPSDEViewCtrlName());
        }
        if (!bl || this.isPSDEViewLogicIdDirty()) {
            hashMap.put(FIELD_PSDEVIEWLOGICID, this.getPSDEViewLogicId());
        }
        if (!bl || this.isPSDEViewLogicNameDirty()) {
            hashMap.put(FIELD_PSDEVIEWLOGICNAME, this.getPSDEViewLogicName());
        }
        if (!bl || this.isPSDEViewLogicTypeDirty()) {
            hashMap.put(FIELD_PSDEVIEWLOGICTYPE, this.getPSDEViewLogicType());
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
        if (!bl || this.isRefPSDEViewLogicIdDirty()) {
            hashMap.put(FIELD_REFPSDEVIEWLOGICID, this.getRefPSDEViewLogicId());
        }
        if (!bl || this.isRefPSDEViewLogicNameDirty()) {
            hashMap.put(FIELD_REFPSDEVIEWLOGICNAME, this.getRefPSDEViewLogicName());
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
        return PSDEViewLogicBase.get(this, n);
    }

    private static Object get(PSDEViewLogicBase pSDEViewLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEViewLogicBase.getAttrName();
            }
            case 1: {
                return pSDEViewLogicBase.getCreateDate();
            }
            case 2: {
                return pSDEViewLogicBase.getCreateMan();
            }
            case 3: {
                return pSDEViewLogicBase.getCustomCode();
            }
            case 4: {
                return pSDEViewLogicBase.getDstLogicType();
            }
            case 5: {
                return pSDEViewLogicBase.getEventArg();
            }
            case 6: {
                return pSDEViewLogicBase.getEventArg2();
            }
            case 7: {
                return pSDEViewLogicBase.getEventNames();
            }
            case 8: {
                return pSDEViewLogicBase.getLogicParam();
            }
            case 9: {
                return pSDEViewLogicBase.getLogicParam2();
            }
            case 10: {
                return pSDEViewLogicBase.getMemo();
            }
            case 11: {
                return pSDEViewLogicBase.getOrderValue();
            }
            case 12: {
                return pSDEViewLogicBase.getParamPSDEViewCtrlId();
            }
            case 13: {
                return pSDEViewLogicBase.getParamPSDEViewCtrlName();
            }
            case 14: {
                return pSDEViewLogicBase.getPSDEId();
            }
            case 15: {
                return pSDEViewLogicBase.getPSDELogicId();
            }
            case 16: {
                return pSDEViewLogicBase.getPSDELogicName();
            }
            case 17: {
                return pSDEViewLogicBase.getPSDEUIActionId();
            }
            case 18: {
                return pSDEViewLogicBase.getPSDEUIActionName();
            }
            case 19: {
                return pSDEViewLogicBase.getPSDEViewBaseId();
            }
            case 20: {
                return pSDEViewLogicBase.getPSDEViewBaseName();
            }
            case 21: {
                return pSDEViewLogicBase.getPSDEViewCtrlId();
            }
            case 22: {
                return pSDEViewLogicBase.getPSDEViewCtrlName();
            }
            case 23: {
                return pSDEViewLogicBase.getPSDEViewLogicId();
            }
            case 24: {
                return pSDEViewLogicBase.getPSDEViewLogicName();
            }
            case 25: {
                return pSDEViewLogicBase.getPSDEViewLogicType();
            }
            case 26: {
                return pSDEViewLogicBase.getPSSysPFPluginId();
            }
            case 27: {
                return pSDEViewLogicBase.getPSSysPFPluginName();
            }
            case 28: {
                return pSDEViewLogicBase.getPSSysViewLogicId();
            }
            case 29: {
                return pSDEViewLogicBase.getPSSysViewLogicName();
            }
            case 30: {
                return pSDEViewLogicBase.getPSSysViewPanelId();
            }
            case 31: {
                return pSDEViewLogicBase.getPSSysViewPanelName();
            }
            case 32: {
                return pSDEViewLogicBase.getRefPSDEViewLogicId();
            }
            case 33: {
                return pSDEViewLogicBase.getRefPSDEViewLogicName();
            }
            case 34: {
                return pSDEViewLogicBase.getTimer();
            }
            case 35: {
                return pSDEViewLogicBase.getUpdateDate();
            }
            case 36: {
                return pSDEViewLogicBase.getUpdateMan();
            }
            case 37: {
                return pSDEViewLogicBase.getUserCat();
            }
            case 38: {
                return pSDEViewLogicBase.getUserTag();
            }
            case 39: {
                return pSDEViewLogicBase.getUserTag2();
            }
            case 40: {
                return pSDEViewLogicBase.getUserTag3();
            }
            case 41: {
                return pSDEViewLogicBase.getUserTag4();
            }
            case 42: {
                return pSDEViewLogicBase.getValidFlag();
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
        PSDEViewLogicBase.set(this, n, object);
    }

    private static void set(PSDEViewLogicBase pSDEViewLogicBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEViewLogicBase.setAttrName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDEViewLogicBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDEViewLogicBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEViewLogicBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEViewLogicBase.setDstLogicType(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEViewLogicBase.setEventArg(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEViewLogicBase.setEventArg2(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEViewLogicBase.setEventNames(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEViewLogicBase.setLogicParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEViewLogicBase.setLogicParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEViewLogicBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEViewLogicBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSDEViewLogicBase.setParamPSDEViewCtrlId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEViewLogicBase.setParamPSDEViewCtrlName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEViewLogicBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEViewLogicBase.setPSDELogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEViewLogicBase.setPSDELogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEViewLogicBase.setPSDEUIActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEViewLogicBase.setPSDEUIActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEViewLogicBase.setPSDEViewBaseId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDEViewLogicBase.setPSDEViewBaseName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEViewLogicBase.setPSDEViewCtrlId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDEViewLogicBase.setPSDEViewCtrlName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDEViewLogicBase.setPSDEViewLogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDEViewLogicBase.setPSDEViewLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDEViewLogicBase.setPSDEViewLogicType(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDEViewLogicBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDEViewLogicBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDEViewLogicBase.setPSSysViewLogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDEViewLogicBase.setPSSysViewLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDEViewLogicBase.setPSSysViewPanelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDEViewLogicBase.setPSSysViewPanelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDEViewLogicBase.setRefPSDEViewLogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDEViewLogicBase.setRefPSDEViewLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDEViewLogicBase.setTimer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 35: {
                pSDEViewLogicBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 36: {
                pSDEViewLogicBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSDEViewLogicBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDEViewLogicBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSDEViewLogicBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSDEViewLogicBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSDEViewLogicBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSDEViewLogicBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDEViewLogicBase.isNull(this, n);
    }

    private static boolean isNull(PSDEViewLogicBase pSDEViewLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEViewLogicBase.getAttrName() == null;
            }
            case 1: {
                return pSDEViewLogicBase.getCreateDate() == null;
            }
            case 2: {
                return pSDEViewLogicBase.getCreateMan() == null;
            }
            case 3: {
                return pSDEViewLogicBase.getCustomCode() == null;
            }
            case 4: {
                return pSDEViewLogicBase.getDstLogicType() == null;
            }
            case 5: {
                return pSDEViewLogicBase.getEventArg() == null;
            }
            case 6: {
                return pSDEViewLogicBase.getEventArg2() == null;
            }
            case 7: {
                return pSDEViewLogicBase.getEventNames() == null;
            }
            case 8: {
                return pSDEViewLogicBase.getLogicParam() == null;
            }
            case 9: {
                return pSDEViewLogicBase.getLogicParam2() == null;
            }
            case 10: {
                return pSDEViewLogicBase.getMemo() == null;
            }
            case 11: {
                return pSDEViewLogicBase.getOrderValue() == null;
            }
            case 12: {
                return pSDEViewLogicBase.getParamPSDEViewCtrlId() == null;
            }
            case 13: {
                return pSDEViewLogicBase.getParamPSDEViewCtrlName() == null;
            }
            case 14: {
                return pSDEViewLogicBase.getPSDEId() == null;
            }
            case 15: {
                return pSDEViewLogicBase.getPSDELogicId() == null;
            }
            case 16: {
                return pSDEViewLogicBase.getPSDELogicName() == null;
            }
            case 17: {
                return pSDEViewLogicBase.getPSDEUIActionId() == null;
            }
            case 18: {
                return pSDEViewLogicBase.getPSDEUIActionName() == null;
            }
            case 19: {
                return pSDEViewLogicBase.getPSDEViewBaseId() == null;
            }
            case 20: {
                return pSDEViewLogicBase.getPSDEViewBaseName() == null;
            }
            case 21: {
                return pSDEViewLogicBase.getPSDEViewCtrlId() == null;
            }
            case 22: {
                return pSDEViewLogicBase.getPSDEViewCtrlName() == null;
            }
            case 23: {
                return pSDEViewLogicBase.getPSDEViewLogicId() == null;
            }
            case 24: {
                return pSDEViewLogicBase.getPSDEViewLogicName() == null;
            }
            case 25: {
                return pSDEViewLogicBase.getPSDEViewLogicType() == null;
            }
            case 26: {
                return pSDEViewLogicBase.getPSSysPFPluginId() == null;
            }
            case 27: {
                return pSDEViewLogicBase.getPSSysPFPluginName() == null;
            }
            case 28: {
                return pSDEViewLogicBase.getPSSysViewLogicId() == null;
            }
            case 29: {
                return pSDEViewLogicBase.getPSSysViewLogicName() == null;
            }
            case 30: {
                return pSDEViewLogicBase.getPSSysViewPanelId() == null;
            }
            case 31: {
                return pSDEViewLogicBase.getPSSysViewPanelName() == null;
            }
            case 32: {
                return pSDEViewLogicBase.getRefPSDEViewLogicId() == null;
            }
            case 33: {
                return pSDEViewLogicBase.getRefPSDEViewLogicName() == null;
            }
            case 34: {
                return pSDEViewLogicBase.getTimer() == null;
            }
            case 35: {
                return pSDEViewLogicBase.getUpdateDate() == null;
            }
            case 36: {
                return pSDEViewLogicBase.getUpdateMan() == null;
            }
            case 37: {
                return pSDEViewLogicBase.getUserCat() == null;
            }
            case 38: {
                return pSDEViewLogicBase.getUserTag() == null;
            }
            case 39: {
                return pSDEViewLogicBase.getUserTag2() == null;
            }
            case 40: {
                return pSDEViewLogicBase.getUserTag3() == null;
            }
            case 41: {
                return pSDEViewLogicBase.getUserTag4() == null;
            }
            case 42: {
                return pSDEViewLogicBase.getValidFlag() == null;
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
        return PSDEViewLogicBase.contains(this, n);
    }

    private static boolean contains(PSDEViewLogicBase pSDEViewLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEViewLogicBase.isAttrNameDirty();
            }
            case 1: {
                return pSDEViewLogicBase.isCreateDateDirty();
            }
            case 2: {
                return pSDEViewLogicBase.isCreateManDirty();
            }
            case 3: {
                return pSDEViewLogicBase.isCustomCodeDirty();
            }
            case 4: {
                return pSDEViewLogicBase.isDstLogicTypeDirty();
            }
            case 5: {
                return pSDEViewLogicBase.isEventArgDirty();
            }
            case 6: {
                return pSDEViewLogicBase.isEventArg2Dirty();
            }
            case 7: {
                return pSDEViewLogicBase.isEventNamesDirty();
            }
            case 8: {
                return pSDEViewLogicBase.isLogicParamDirty();
            }
            case 9: {
                return pSDEViewLogicBase.isLogicParam2Dirty();
            }
            case 10: {
                return pSDEViewLogicBase.isMemoDirty();
            }
            case 11: {
                return pSDEViewLogicBase.isOrderValueDirty();
            }
            case 12: {
                return pSDEViewLogicBase.isParamPSDEViewCtrlIdDirty();
            }
            case 13: {
                return pSDEViewLogicBase.isParamPSDEViewCtrlNameDirty();
            }
            case 14: {
                return pSDEViewLogicBase.isPSDEIdDirty();
            }
            case 15: {
                return pSDEViewLogicBase.isPSDELogicIdDirty();
            }
            case 16: {
                return pSDEViewLogicBase.isPSDELogicNameDirty();
            }
            case 17: {
                return pSDEViewLogicBase.isPSDEUIActionIdDirty();
            }
            case 18: {
                return pSDEViewLogicBase.isPSDEUIActionNameDirty();
            }
            case 19: {
                return pSDEViewLogicBase.isPSDEViewBaseIdDirty();
            }
            case 20: {
                return pSDEViewLogicBase.isPSDEViewBaseNameDirty();
            }
            case 21: {
                return pSDEViewLogicBase.isPSDEViewCtrlIdDirty();
            }
            case 22: {
                return pSDEViewLogicBase.isPSDEViewCtrlNameDirty();
            }
            case 23: {
                return pSDEViewLogicBase.isPSDEViewLogicIdDirty();
            }
            case 24: {
                return pSDEViewLogicBase.isPSDEViewLogicNameDirty();
            }
            case 25: {
                return pSDEViewLogicBase.isPSDEViewLogicTypeDirty();
            }
            case 26: {
                return pSDEViewLogicBase.isPSSysPFPluginIdDirty();
            }
            case 27: {
                return pSDEViewLogicBase.isPSSysPFPluginNameDirty();
            }
            case 28: {
                return pSDEViewLogicBase.isPSSysViewLogicIdDirty();
            }
            case 29: {
                return pSDEViewLogicBase.isPSSysViewLogicNameDirty();
            }
            case 30: {
                return pSDEViewLogicBase.isPSSysViewPanelIdDirty();
            }
            case 31: {
                return pSDEViewLogicBase.isPSSysViewPanelNameDirty();
            }
            case 32: {
                return pSDEViewLogicBase.isRefPSDEViewLogicIdDirty();
            }
            case 33: {
                return pSDEViewLogicBase.isRefPSDEViewLogicNameDirty();
            }
            case 34: {
                return pSDEViewLogicBase.isTimerDirty();
            }
            case 35: {
                return pSDEViewLogicBase.isUpdateDateDirty();
            }
            case 36: {
                return pSDEViewLogicBase.isUpdateManDirty();
            }
            case 37: {
                return pSDEViewLogicBase.isUserCatDirty();
            }
            case 38: {
                return pSDEViewLogicBase.isUserTagDirty();
            }
            case 39: {
                return pSDEViewLogicBase.isUserTag2Dirty();
            }
            case 40: {
                return pSDEViewLogicBase.isUserTag3Dirty();
            }
            case 41: {
                return pSDEViewLogicBase.isUserTag4Dirty();
            }
            case 42: {
                return pSDEViewLogicBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEViewLogicBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEViewLogicBase pSDEViewLogicBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEViewLogicBase.getAttrName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"attrname", (Object)PSDEViewLogicBase.getJSONValue((Object)pSDEViewLogicBase.getAttrName()), (boolean)false);
        }
        if (bl || pSDEViewLogicBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEViewLogicBase.getJSONValue((Object)pSDEViewLogicBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEViewLogicBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEViewLogicBase.getJSONValue((Object)pSDEViewLogicBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEViewLogicBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSDEViewLogicBase.getJSONValue((Object)pSDEViewLogicBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSDEViewLogicBase.getDstLogicType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstlogictype", (Object)PSDEViewLogicBase.getJSONValue((Object)pSDEViewLogicBase.getDstLogicType()), (boolean)false);
        }
        if (bl || pSDEViewLogicBase.getEventArg() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eventarg", (Object)PSDEViewLogicBase.getJSONValue((Object)pSDEViewLogicBase.getEventArg()), (boolean)false);
        }
        if (bl || pSDEViewLogicBase.getEventArg2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eventarg2", (Object)PSDEViewLogicBase.getJSONValue((Object)pSDEViewLogicBase.getEventArg2()), (boolean)false);
        }
        if (bl || pSDEViewLogicBase.getEventNames() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eventnames", (Object)PSDEViewLogicBase.getJSONValue((Object)pSDEViewLogicBase.getEventNames()), (boolean)false);
        }
        if (bl || pSDEViewLogicBase.getLogicParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicparam", (Object)PSDEViewLogicBase.getJSONValue((Object)pSDEViewLogicBase.getLogicParam()), (boolean)false);
        }
        if (bl || pSDEViewLogicBase.getLogicParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicparam2", (Object)PSDEViewLogicBase.getJSONValue((Object)pSDEViewLogicBase.getLogicParam2()), (boolean)false);
        }
        if (bl || pSDEViewLogicBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEViewLogicBase.getJSONValue((Object)pSDEViewLogicBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEViewLogicBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDEViewLogicBase.getJSONValue((Object)pSDEViewLogicBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDEViewLogicBase.getParamPSDEViewCtrlId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"parampsdeviewctrlid", (Object)PSDEViewLogicBase.getJSONValue((Object)pSDEViewLogicBase.getParamPSDEViewCtrlId()), (boolean)false);
        }
        if (bl || pSDEViewLogicBase.getParamPSDEViewCtrlName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"parampsdeviewctrlname", (Object)PSDEViewLogicBase.getJSONValue((Object)pSDEViewLogicBase.getParamPSDEViewCtrlName()), (boolean)false);
        }
        if (bl || pSDEViewLogicBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEViewLogicBase.getJSONValue((Object)pSDEViewLogicBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEViewLogicBase.getPSDELogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicid", (Object)PSDEViewLogicBase.getJSONValue((Object)pSDEViewLogicBase.getPSDELogicId()), (boolean)false);
        }
        if (bl || pSDEViewLogicBase.getPSDELogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicname", (Object)PSDEViewLogicBase.getJSONValue((Object)pSDEViewLogicBase.getPSDELogicName()), (boolean)false);
        }
        if (bl || pSDEViewLogicBase.getPSDEUIActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuiactionid", (Object)PSDEViewLogicBase.getJSONValue((Object)pSDEViewLogicBase.getPSDEUIActionId()), (boolean)false);
        }
        if (bl || pSDEViewLogicBase.getPSDEUIActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuiactionname", (Object)PSDEViewLogicBase.getJSONValue((Object)pSDEViewLogicBase.getPSDEUIActionName()), (boolean)false);
        }
        if (bl || pSDEViewLogicBase.getPSDEViewBaseId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewbaseid", (Object)PSDEViewLogicBase.getJSONValue((Object)pSDEViewLogicBase.getPSDEViewBaseId()), (boolean)false);
        }
        if (bl || pSDEViewLogicBase.getPSDEViewBaseName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewbasename", (Object)PSDEViewLogicBase.getJSONValue((Object)pSDEViewLogicBase.getPSDEViewBaseName()), (boolean)false);
        }
        if (bl || pSDEViewLogicBase.getPSDEViewCtrlId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewctrlid", (Object)PSDEViewLogicBase.getJSONValue((Object)pSDEViewLogicBase.getPSDEViewCtrlId()), (boolean)false);
        }
        if (bl || pSDEViewLogicBase.getPSDEViewCtrlName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewctrlname", (Object)PSDEViewLogicBase.getJSONValue((Object)pSDEViewLogicBase.getPSDEViewCtrlName()), (boolean)false);
        }
        if (bl || pSDEViewLogicBase.getPSDEViewLogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewlogicid", (Object)PSDEViewLogicBase.getJSONValue((Object)pSDEViewLogicBase.getPSDEViewLogicId()), (boolean)false);
        }
        if (bl || pSDEViewLogicBase.getPSDEViewLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewlogicname", (Object)PSDEViewLogicBase.getJSONValue((Object)pSDEViewLogicBase.getPSDEViewLogicName()), (boolean)false);
        }
        if (bl || pSDEViewLogicBase.getPSDEViewLogicType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewlogictype", (Object)PSDEViewLogicBase.getJSONValue((Object)pSDEViewLogicBase.getPSDEViewLogicType()), (boolean)false);
        }
        if (bl || pSDEViewLogicBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSDEViewLogicBase.getJSONValue((Object)pSDEViewLogicBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSDEViewLogicBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSDEViewLogicBase.getJSONValue((Object)pSDEViewLogicBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSDEViewLogicBase.getPSSysViewLogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewlogicid", (Object)PSDEViewLogicBase.getJSONValue((Object)pSDEViewLogicBase.getPSSysViewLogicId()), (boolean)false);
        }
        if (bl || pSDEViewLogicBase.getPSSysViewLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewlogicname", (Object)PSDEViewLogicBase.getJSONValue((Object)pSDEViewLogicBase.getPSSysViewLogicName()), (boolean)false);
        }
        if (bl || pSDEViewLogicBase.getPSSysViewPanelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelid", (Object)PSDEViewLogicBase.getJSONValue((Object)pSDEViewLogicBase.getPSSysViewPanelId()), (boolean)false);
        }
        if (bl || pSDEViewLogicBase.getPSSysViewPanelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelname", (Object)PSDEViewLogicBase.getJSONValue((Object)pSDEViewLogicBase.getPSSysViewPanelName()), (boolean)false);
        }
        if (bl || pSDEViewLogicBase.getRefPSDEViewLogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdeviewlogicid", (Object)PSDEViewLogicBase.getJSONValue((Object)pSDEViewLogicBase.getRefPSDEViewLogicId()), (boolean)false);
        }
        if (bl || pSDEViewLogicBase.getRefPSDEViewLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdeviewlogicname", (Object)PSDEViewLogicBase.getJSONValue((Object)pSDEViewLogicBase.getRefPSDEViewLogicName()), (boolean)false);
        }
        if (bl || pSDEViewLogicBase.getTimer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"timer", (Object)PSDEViewLogicBase.getJSONValue((Object)pSDEViewLogicBase.getTimer()), (boolean)false);
        }
        if (bl || pSDEViewLogicBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEViewLogicBase.getJSONValue((Object)pSDEViewLogicBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEViewLogicBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEViewLogicBase.getJSONValue((Object)pSDEViewLogicBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEViewLogicBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEViewLogicBase.getJSONValue((Object)pSDEViewLogicBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEViewLogicBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEViewLogicBase.getJSONValue((Object)pSDEViewLogicBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEViewLogicBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEViewLogicBase.getJSONValue((Object)pSDEViewLogicBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEViewLogicBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEViewLogicBase.getJSONValue((Object)pSDEViewLogicBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEViewLogicBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEViewLogicBase.getJSONValue((Object)pSDEViewLogicBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDEViewLogicBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDEViewLogicBase.getJSONValue((Object)pSDEViewLogicBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEViewLogicBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEViewLogicBase pSDEViewLogicBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEViewLogicBase.getAttrName() != null) {
            object = pSDEViewLogicBase.getAttrName();
            xmlNode.setAttribute(FIELD_ATTRNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewLogicBase.getCreateDate() != null) {
            object = pSDEViewLogicBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEViewLogicBase.getCreateMan() != null) {
            object = pSDEViewLogicBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewLogicBase.getCustomCode() != null) {
            object = pSDEViewLogicBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewLogicBase.getDstLogicType() != null) {
            object = pSDEViewLogicBase.getDstLogicType();
            xmlNode.setAttribute(FIELD_DSTLOGICTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewLogicBase.getEventArg() != null) {
            object = pSDEViewLogicBase.getEventArg();
            xmlNode.setAttribute(FIELD_EVENTARG, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewLogicBase.getEventArg2() != null) {
            object = pSDEViewLogicBase.getEventArg2();
            xmlNode.setAttribute(FIELD_EVENTARG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewLogicBase.getEventNames() != null) {
            object = pSDEViewLogicBase.getEventNames();
            xmlNode.setAttribute(FIELD_EVENTNAMES, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewLogicBase.getLogicParam() != null) {
            object = pSDEViewLogicBase.getLogicParam();
            xmlNode.setAttribute(FIELD_LOGICPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewLogicBase.getLogicParam2() != null) {
            object = pSDEViewLogicBase.getLogicParam2();
            xmlNode.setAttribute(FIELD_LOGICPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewLogicBase.getMemo() != null) {
            object = pSDEViewLogicBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewLogicBase.getOrderValue() != null) {
            object = pSDEViewLogicBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewLogicBase.getParamPSDEViewCtrlId() != null) {
            object = pSDEViewLogicBase.getParamPSDEViewCtrlId();
            xmlNode.setAttribute(FIELD_PARAMPSDEVIEWCTRLID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewLogicBase.getParamPSDEViewCtrlName() != null) {
            object = pSDEViewLogicBase.getParamPSDEViewCtrlName();
            xmlNode.setAttribute(FIELD_PARAMPSDEVIEWCTRLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewLogicBase.getPSDEId() != null) {
            object = pSDEViewLogicBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewLogicBase.getPSDELogicId() != null) {
            object = pSDEViewLogicBase.getPSDELogicId();
            xmlNode.setAttribute(FIELD_PSDELOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewLogicBase.getPSDELogicName() != null) {
            object = pSDEViewLogicBase.getPSDELogicName();
            xmlNode.setAttribute(FIELD_PSDELOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewLogicBase.getPSDEUIActionId() != null) {
            object = pSDEViewLogicBase.getPSDEUIActionId();
            xmlNode.setAttribute(FIELD_PSDEUIACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewLogicBase.getPSDEUIActionName() != null) {
            object = pSDEViewLogicBase.getPSDEUIActionName();
            xmlNode.setAttribute(FIELD_PSDEUIACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewLogicBase.getPSDEViewBaseId() != null) {
            object = pSDEViewLogicBase.getPSDEViewBaseId();
            xmlNode.setAttribute(FIELD_PSDEVIEWBASEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewLogicBase.getPSDEViewBaseName() != null) {
            object = pSDEViewLogicBase.getPSDEViewBaseName();
            xmlNode.setAttribute(FIELD_PSDEVIEWBASENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewLogicBase.getPSDEViewCtrlId() != null) {
            object = pSDEViewLogicBase.getPSDEViewCtrlId();
            xmlNode.setAttribute(FIELD_PSDEVIEWCTRLID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewLogicBase.getPSDEViewCtrlName() != null) {
            object = pSDEViewLogicBase.getPSDEViewCtrlName();
            xmlNode.setAttribute(FIELD_PSDEVIEWCTRLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewLogicBase.getPSDEViewLogicId() != null) {
            object = pSDEViewLogicBase.getPSDEViewLogicId();
            xmlNode.setAttribute(FIELD_PSDEVIEWLOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewLogicBase.getPSDEViewLogicName() != null) {
            object = pSDEViewLogicBase.getPSDEViewLogicName();
            xmlNode.setAttribute(FIELD_PSDEVIEWLOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewLogicBase.getPSDEViewLogicType() != null) {
            object = pSDEViewLogicBase.getPSDEViewLogicType();
            xmlNode.setAttribute(FIELD_PSDEVIEWLOGICTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewLogicBase.getPSSysPFPluginId() != null) {
            object = pSDEViewLogicBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewLogicBase.getPSSysPFPluginName() != null) {
            object = pSDEViewLogicBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewLogicBase.getPSSysViewLogicId() != null) {
            object = pSDEViewLogicBase.getPSSysViewLogicId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWLOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewLogicBase.getPSSysViewLogicName() != null) {
            object = pSDEViewLogicBase.getPSSysViewLogicName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWLOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewLogicBase.getPSSysViewPanelId() != null) {
            object = pSDEViewLogicBase.getPSSysViewPanelId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewLogicBase.getPSSysViewPanelName() != null) {
            object = pSDEViewLogicBase.getPSSysViewPanelName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewLogicBase.getRefPSDEViewLogicId() != null) {
            object = pSDEViewLogicBase.getRefPSDEViewLogicId();
            xmlNode.setAttribute(FIELD_REFPSDEVIEWLOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewLogicBase.getRefPSDEViewLogicName() != null) {
            object = pSDEViewLogicBase.getRefPSDEViewLogicName();
            xmlNode.setAttribute(FIELD_REFPSDEVIEWLOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewLogicBase.getTimer() != null) {
            object = pSDEViewLogicBase.getTimer();
            xmlNode.setAttribute(FIELD_TIMER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewLogicBase.getUpdateDate() != null) {
            object = pSDEViewLogicBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEViewLogicBase.getUpdateMan() != null) {
            object = pSDEViewLogicBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewLogicBase.getUserCat() != null) {
            object = pSDEViewLogicBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewLogicBase.getUserTag() != null) {
            object = pSDEViewLogicBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewLogicBase.getUserTag2() != null) {
            object = pSDEViewLogicBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewLogicBase.getUserTag3() != null) {
            object = pSDEViewLogicBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewLogicBase.getUserTag4() != null) {
            object = pSDEViewLogicBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewLogicBase.getValidFlag() != null) {
            object = pSDEViewLogicBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEViewLogicBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEViewLogicBase pSDEViewLogicBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEViewLogicBase.isAttrNameDirty() && (bl || pSDEViewLogicBase.getAttrName() != null)) {
            iDataObject.set(FIELD_ATTRNAME, (Object)pSDEViewLogicBase.getAttrName());
        }
        if (pSDEViewLogicBase.isCreateDateDirty() && (bl || pSDEViewLogicBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEViewLogicBase.getCreateDate());
        }
        if (pSDEViewLogicBase.isCreateManDirty() && (bl || pSDEViewLogicBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEViewLogicBase.getCreateMan());
        }
        if (pSDEViewLogicBase.isCustomCodeDirty() && (bl || pSDEViewLogicBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSDEViewLogicBase.getCustomCode());
        }
        if (pSDEViewLogicBase.isDstLogicTypeDirty() && (bl || pSDEViewLogicBase.getDstLogicType() != null)) {
            iDataObject.set(FIELD_DSTLOGICTYPE, (Object)pSDEViewLogicBase.getDstLogicType());
        }
        if (pSDEViewLogicBase.isEventArgDirty() && (bl || pSDEViewLogicBase.getEventArg() != null)) {
            iDataObject.set(FIELD_EVENTARG, (Object)pSDEViewLogicBase.getEventArg());
        }
        if (pSDEViewLogicBase.isEventArg2Dirty() && (bl || pSDEViewLogicBase.getEventArg2() != null)) {
            iDataObject.set(FIELD_EVENTARG2, (Object)pSDEViewLogicBase.getEventArg2());
        }
        if (pSDEViewLogicBase.isEventNamesDirty() && (bl || pSDEViewLogicBase.getEventNames() != null)) {
            iDataObject.set(FIELD_EVENTNAMES, (Object)pSDEViewLogicBase.getEventNames());
        }
        if (pSDEViewLogicBase.isLogicParamDirty() && (bl || pSDEViewLogicBase.getLogicParam() != null)) {
            iDataObject.set(FIELD_LOGICPARAM, (Object)pSDEViewLogicBase.getLogicParam());
        }
        if (pSDEViewLogicBase.isLogicParam2Dirty() && (bl || pSDEViewLogicBase.getLogicParam2() != null)) {
            iDataObject.set(FIELD_LOGICPARAM2, (Object)pSDEViewLogicBase.getLogicParam2());
        }
        if (pSDEViewLogicBase.isMemoDirty() && (bl || pSDEViewLogicBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEViewLogicBase.getMemo());
        }
        if (pSDEViewLogicBase.isOrderValueDirty() && (bl || pSDEViewLogicBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDEViewLogicBase.getOrderValue());
        }
        if (pSDEViewLogicBase.isParamPSDEViewCtrlIdDirty() && (bl || pSDEViewLogicBase.getParamPSDEViewCtrlId() != null)) {
            iDataObject.set(FIELD_PARAMPSDEVIEWCTRLID, (Object)pSDEViewLogicBase.getParamPSDEViewCtrlId());
        }
        if (pSDEViewLogicBase.isParamPSDEViewCtrlNameDirty() && (bl || pSDEViewLogicBase.getParamPSDEViewCtrlName() != null)) {
            iDataObject.set(FIELD_PARAMPSDEVIEWCTRLNAME, (Object)pSDEViewLogicBase.getParamPSDEViewCtrlName());
        }
        if (pSDEViewLogicBase.isPSDEIdDirty() && (bl || pSDEViewLogicBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEViewLogicBase.getPSDEId());
        }
        if (pSDEViewLogicBase.isPSDELogicIdDirty() && (bl || pSDEViewLogicBase.getPSDELogicId() != null)) {
            iDataObject.set(FIELD_PSDELOGICID, (Object)pSDEViewLogicBase.getPSDELogicId());
        }
        if (pSDEViewLogicBase.isPSDELogicNameDirty() && (bl || pSDEViewLogicBase.getPSDELogicName() != null)) {
            iDataObject.set(FIELD_PSDELOGICNAME, (Object)pSDEViewLogicBase.getPSDELogicName());
        }
        if (pSDEViewLogicBase.isPSDEUIActionIdDirty() && (bl || pSDEViewLogicBase.getPSDEUIActionId() != null)) {
            iDataObject.set(FIELD_PSDEUIACTIONID, (Object)pSDEViewLogicBase.getPSDEUIActionId());
        }
        if (pSDEViewLogicBase.isPSDEUIActionNameDirty() && (bl || pSDEViewLogicBase.getPSDEUIActionName() != null)) {
            iDataObject.set(FIELD_PSDEUIACTIONNAME, (Object)pSDEViewLogicBase.getPSDEUIActionName());
        }
        if (pSDEViewLogicBase.isPSDEViewBaseIdDirty() && (bl || pSDEViewLogicBase.getPSDEViewBaseId() != null)) {
            iDataObject.set(FIELD_PSDEVIEWBASEID, (Object)pSDEViewLogicBase.getPSDEViewBaseId());
        }
        if (pSDEViewLogicBase.isPSDEViewBaseNameDirty() && (bl || pSDEViewLogicBase.getPSDEViewBaseName() != null)) {
            iDataObject.set(FIELD_PSDEVIEWBASENAME, (Object)pSDEViewLogicBase.getPSDEViewBaseName());
        }
        if (pSDEViewLogicBase.isPSDEViewCtrlIdDirty() && (bl || pSDEViewLogicBase.getPSDEViewCtrlId() != null)) {
            iDataObject.set(FIELD_PSDEVIEWCTRLID, (Object)pSDEViewLogicBase.getPSDEViewCtrlId());
        }
        if (pSDEViewLogicBase.isPSDEViewCtrlNameDirty() && (bl || pSDEViewLogicBase.getPSDEViewCtrlName() != null)) {
            iDataObject.set(FIELD_PSDEVIEWCTRLNAME, (Object)pSDEViewLogicBase.getPSDEViewCtrlName());
        }
        if (pSDEViewLogicBase.isPSDEViewLogicIdDirty() && (bl || pSDEViewLogicBase.getPSDEViewLogicId() != null)) {
            iDataObject.set(FIELD_PSDEVIEWLOGICID, (Object)pSDEViewLogicBase.getPSDEViewLogicId());
        }
        if (pSDEViewLogicBase.isPSDEViewLogicNameDirty() && (bl || pSDEViewLogicBase.getPSDEViewLogicName() != null)) {
            iDataObject.set(FIELD_PSDEVIEWLOGICNAME, (Object)pSDEViewLogicBase.getPSDEViewLogicName());
        }
        if (pSDEViewLogicBase.isPSDEViewLogicTypeDirty() && (bl || pSDEViewLogicBase.getPSDEViewLogicType() != null)) {
            iDataObject.set(FIELD_PSDEVIEWLOGICTYPE, (Object)pSDEViewLogicBase.getPSDEViewLogicType());
        }
        if (pSDEViewLogicBase.isPSSysPFPluginIdDirty() && (bl || pSDEViewLogicBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSDEViewLogicBase.getPSSysPFPluginId());
        }
        if (pSDEViewLogicBase.isPSSysPFPluginNameDirty() && (bl || pSDEViewLogicBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSDEViewLogicBase.getPSSysPFPluginName());
        }
        if (pSDEViewLogicBase.isPSSysViewLogicIdDirty() && (bl || pSDEViewLogicBase.getPSSysViewLogicId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWLOGICID, (Object)pSDEViewLogicBase.getPSSysViewLogicId());
        }
        if (pSDEViewLogicBase.isPSSysViewLogicNameDirty() && (bl || pSDEViewLogicBase.getPSSysViewLogicName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWLOGICNAME, (Object)pSDEViewLogicBase.getPSSysViewLogicName());
        }
        if (pSDEViewLogicBase.isPSSysViewPanelIdDirty() && (bl || pSDEViewLogicBase.getPSSysViewPanelId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELID, (Object)pSDEViewLogicBase.getPSSysViewPanelId());
        }
        if (pSDEViewLogicBase.isPSSysViewPanelNameDirty() && (bl || pSDEViewLogicBase.getPSSysViewPanelName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELNAME, (Object)pSDEViewLogicBase.getPSSysViewPanelName());
        }
        if (pSDEViewLogicBase.isRefPSDEViewLogicIdDirty() && (bl || pSDEViewLogicBase.getRefPSDEViewLogicId() != null)) {
            iDataObject.set(FIELD_REFPSDEVIEWLOGICID, (Object)pSDEViewLogicBase.getRefPSDEViewLogicId());
        }
        if (pSDEViewLogicBase.isRefPSDEViewLogicNameDirty() && (bl || pSDEViewLogicBase.getRefPSDEViewLogicName() != null)) {
            iDataObject.set(FIELD_REFPSDEVIEWLOGICNAME, (Object)pSDEViewLogicBase.getRefPSDEViewLogicName());
        }
        if (pSDEViewLogicBase.isTimerDirty() && (bl || pSDEViewLogicBase.getTimer() != null)) {
            iDataObject.set(FIELD_TIMER, (Object)pSDEViewLogicBase.getTimer());
        }
        if (pSDEViewLogicBase.isUpdateDateDirty() && (bl || pSDEViewLogicBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEViewLogicBase.getUpdateDate());
        }
        if (pSDEViewLogicBase.isUpdateManDirty() && (bl || pSDEViewLogicBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEViewLogicBase.getUpdateMan());
        }
        if (pSDEViewLogicBase.isUserCatDirty() && (bl || pSDEViewLogicBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEViewLogicBase.getUserCat());
        }
        if (pSDEViewLogicBase.isUserTagDirty() && (bl || pSDEViewLogicBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEViewLogicBase.getUserTag());
        }
        if (pSDEViewLogicBase.isUserTag2Dirty() && (bl || pSDEViewLogicBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEViewLogicBase.getUserTag2());
        }
        if (pSDEViewLogicBase.isUserTag3Dirty() && (bl || pSDEViewLogicBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEViewLogicBase.getUserTag3());
        }
        if (pSDEViewLogicBase.isUserTag4Dirty() && (bl || pSDEViewLogicBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEViewLogicBase.getUserTag4());
        }
        if (pSDEViewLogicBase.isValidFlagDirty() && (bl || pSDEViewLogicBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDEViewLogicBase.getValidFlag());
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
        return PSDEViewLogicBase.remove(this, n);
    }

    private static boolean remove(PSDEViewLogicBase pSDEViewLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEViewLogicBase.resetAttrName();
                return true;
            }
            case 1: {
                pSDEViewLogicBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDEViewLogicBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDEViewLogicBase.resetCustomCode();
                return true;
            }
            case 4: {
                pSDEViewLogicBase.resetDstLogicType();
                return true;
            }
            case 5: {
                pSDEViewLogicBase.resetEventArg();
                return true;
            }
            case 6: {
                pSDEViewLogicBase.resetEventArg2();
                return true;
            }
            case 7: {
                pSDEViewLogicBase.resetEventNames();
                return true;
            }
            case 8: {
                pSDEViewLogicBase.resetLogicParam();
                return true;
            }
            case 9: {
                pSDEViewLogicBase.resetLogicParam2();
                return true;
            }
            case 10: {
                pSDEViewLogicBase.resetMemo();
                return true;
            }
            case 11: {
                pSDEViewLogicBase.resetOrderValue();
                return true;
            }
            case 12: {
                pSDEViewLogicBase.resetParamPSDEViewCtrlId();
                return true;
            }
            case 13: {
                pSDEViewLogicBase.resetParamPSDEViewCtrlName();
                return true;
            }
            case 14: {
                pSDEViewLogicBase.resetPSDEId();
                return true;
            }
            case 15: {
                pSDEViewLogicBase.resetPSDELogicId();
                return true;
            }
            case 16: {
                pSDEViewLogicBase.resetPSDELogicName();
                return true;
            }
            case 17: {
                pSDEViewLogicBase.resetPSDEUIActionId();
                return true;
            }
            case 18: {
                pSDEViewLogicBase.resetPSDEUIActionName();
                return true;
            }
            case 19: {
                pSDEViewLogicBase.resetPSDEViewBaseId();
                return true;
            }
            case 20: {
                pSDEViewLogicBase.resetPSDEViewBaseName();
                return true;
            }
            case 21: {
                pSDEViewLogicBase.resetPSDEViewCtrlId();
                return true;
            }
            case 22: {
                pSDEViewLogicBase.resetPSDEViewCtrlName();
                return true;
            }
            case 23: {
                pSDEViewLogicBase.resetPSDEViewLogicId();
                return true;
            }
            case 24: {
                pSDEViewLogicBase.resetPSDEViewLogicName();
                return true;
            }
            case 25: {
                pSDEViewLogicBase.resetPSDEViewLogicType();
                return true;
            }
            case 26: {
                pSDEViewLogicBase.resetPSSysPFPluginId();
                return true;
            }
            case 27: {
                pSDEViewLogicBase.resetPSSysPFPluginName();
                return true;
            }
            case 28: {
                pSDEViewLogicBase.resetPSSysViewLogicId();
                return true;
            }
            case 29: {
                pSDEViewLogicBase.resetPSSysViewLogicName();
                return true;
            }
            case 30: {
                pSDEViewLogicBase.resetPSSysViewPanelId();
                return true;
            }
            case 31: {
                pSDEViewLogicBase.resetPSSysViewPanelName();
                return true;
            }
            case 32: {
                pSDEViewLogicBase.resetRefPSDEViewLogicId();
                return true;
            }
            case 33: {
                pSDEViewLogicBase.resetRefPSDEViewLogicName();
                return true;
            }
            case 34: {
                pSDEViewLogicBase.resetTimer();
                return true;
            }
            case 35: {
                pSDEViewLogicBase.resetUpdateDate();
                return true;
            }
            case 36: {
                pSDEViewLogicBase.resetUpdateMan();
                return true;
            }
            case 37: {
                pSDEViewLogicBase.resetUserCat();
                return true;
            }
            case 38: {
                pSDEViewLogicBase.resetUserTag();
                return true;
            }
            case 39: {
                pSDEViewLogicBase.resetUserTag2();
                return true;
            }
            case 40: {
                pSDEViewLogicBase.resetUserTag3();
                return true;
            }
            case 41: {
                pSDEViewLogicBase.resetUserTag4();
                return true;
            }
            case 42: {
                pSDEViewLogicBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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
    public PSDEViewBase getPSDEViewBase() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewBase();
        }
        if (this.getPSDEViewBaseId() == null) {
            return null;
        }
        Integer n = this.objPSDEViewBaseLock;
        synchronized (n) {
            if (this.psdeviewbase != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEViewBaseId(), (Object)this.psdeviewbase.getPSDEViewBaseId()) != 0L) {
                this.psdeviewbase = null;
            }
            if (this.psdeviewbase == null) {
                PSDEViewBase pSDEViewBase = new PSDEViewBase();
                pSDEViewBase.setPSDEViewBaseId(this.getPSDEViewBaseId());
                PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
                pSDEViewBaseService.autoGet((IEntity)pSDEViewBase);
                this.psdeviewbase = pSDEViewBase;
            }
            return this.psdeviewbase;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEViewCtrl getParamPSDEViewCtrl() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParamPSDEViewCtrl();
        }
        if (this.getParamPSDEViewCtrlId() == null) {
            return null;
        }
        Integer n = this.objParamPSDEViewCtrlLock;
        synchronized (n) {
            if (this.parampsdeviewctrl != null && DataTypeHelper.compare((int)25, (Object)this.getParamPSDEViewCtrlId(), (Object)this.parampsdeviewctrl.getPSDEViewCtrlId()) != 0L) {
                this.parampsdeviewctrl = null;
            }
            if (this.parampsdeviewctrl == null) {
                PSDEViewCtrl pSDEViewCtrl = new PSDEViewCtrl();
                pSDEViewCtrl.setPSDEViewCtrlId(this.getParamPSDEViewCtrlId());
                PSDEViewCtrlService pSDEViewCtrlService = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, (SessionFactory)this.getSessionFactory());
                pSDEViewCtrlService.autoGet((IEntity)pSDEViewCtrl);
                this.parampsdeviewctrl = pSDEViewCtrl;
            }
            return this.parampsdeviewctrl;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEViewCtrl getPSDEViewCtrl() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewCtrl();
        }
        if (this.getPSDEViewCtrlId() == null) {
            return null;
        }
        Integer n = this.objPSDEViewCtrlLock;
        synchronized (n) {
            if (this.psdeviewctrl != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEViewCtrlId(), (Object)this.psdeviewctrl.getPSDEViewCtrlId()) != 0L) {
                this.psdeviewctrl = null;
            }
            if (this.psdeviewctrl == null) {
                PSDEViewCtrl pSDEViewCtrl = new PSDEViewCtrl();
                pSDEViewCtrl.setPSDEViewCtrlId(this.getPSDEViewCtrlId());
                PSDEViewCtrlService pSDEViewCtrlService = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, (SessionFactory)this.getSessionFactory());
                pSDEViewCtrlService.autoGet((IEntity)pSDEViewCtrl);
                this.psdeviewctrl = pSDEViewCtrl;
            }
            return this.psdeviewctrl;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEViewLogic getRefPSDEViewLogic() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDEViewLogic();
        }
        if (this.getRefPSDEViewLogicId() == null) {
            return null;
        }
        Integer n = this.objRefPSDEViewLogicLock;
        synchronized (n) {
            if (this.refpsdeviewlogic != null && DataTypeHelper.compare((int)25, (Object)this.getRefPSDEViewLogicId(), (Object)this.refpsdeviewlogic.getPSDEViewLogicId()) != 0L) {
                this.refpsdeviewlogic = null;
            }
            if (this.refpsdeviewlogic == null) {
                PSDEViewLogic pSDEViewLogic = new PSDEViewLogic();
                pSDEViewLogic.setPSDEViewLogicId(this.getRefPSDEViewLogicId());
                PSDEViewLogicService pSDEViewLogicService = (PSDEViewLogicService)ServiceGlobal.getService(PSDEViewLogicService.class, (SessionFactory)this.getSessionFactory());
                pSDEViewLogicService.autoGet((IEntity)pSDEViewLogic);
                this.refpsdeviewlogic = pSDEViewLogic;
            }
            return this.refpsdeviewlogic;
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

    private PSDEViewLogicBase getProxyEntity() {
        return this.proxyPSDEViewLogicBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEViewLogicBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEViewLogicBase) {
            this.proxyPSDEViewLogicBase = (PSDEViewLogicBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewLogicService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
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
        fieldIndexMap.put(FIELD_PARAMPSDEVIEWCTRLID, 12);
        fieldIndexMap.put(FIELD_PARAMPSDEVIEWCTRLNAME, 13);
        fieldIndexMap.put(FIELD_PSDEID, 14);
        fieldIndexMap.put(FIELD_PSDELOGICID, 15);
        fieldIndexMap.put(FIELD_PSDELOGICNAME, 16);
        fieldIndexMap.put(FIELD_PSDEUIACTIONID, 17);
        fieldIndexMap.put(FIELD_PSDEUIACTIONNAME, 18);
        fieldIndexMap.put(FIELD_PSDEVIEWBASEID, 19);
        fieldIndexMap.put(FIELD_PSDEVIEWBASENAME, 20);
        fieldIndexMap.put(FIELD_PSDEVIEWCTRLID, 21);
        fieldIndexMap.put(FIELD_PSDEVIEWCTRLNAME, 22);
        fieldIndexMap.put(FIELD_PSDEVIEWLOGICID, 23);
        fieldIndexMap.put(FIELD_PSDEVIEWLOGICNAME, 24);
        fieldIndexMap.put(FIELD_PSDEVIEWLOGICTYPE, 25);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINID, 26);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINNAME, 27);
        fieldIndexMap.put(FIELD_PSSYSVIEWLOGICID, 28);
        fieldIndexMap.put(FIELD_PSSYSVIEWLOGICNAME, 29);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELID, 30);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELNAME, 31);
        fieldIndexMap.put(FIELD_REFPSDEVIEWLOGICID, 32);
        fieldIndexMap.put(FIELD_REFPSDEVIEWLOGICNAME, 33);
        fieldIndexMap.put(FIELD_TIMER, 34);
        fieldIndexMap.put(FIELD_UPDATEDATE, 35);
        fieldIndexMap.put(FIELD_UPDATEMAN, 36);
        fieldIndexMap.put(FIELD_USERCAT, 37);
        fieldIndexMap.put(FIELD_USERTAG, 38);
        fieldIndexMap.put(FIELD_USERTAG2, 39);
        fieldIndexMap.put(FIELD_USERTAG3, 40);
        fieldIndexMap.put(FIELD_USERTAG4, 41);
        fieldIndexMap.put(FIELD_VALIDFLAG, 42);
    }
}

