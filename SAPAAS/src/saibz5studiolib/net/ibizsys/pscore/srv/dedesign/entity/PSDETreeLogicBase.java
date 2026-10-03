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
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeCol;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeNode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeView;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeColService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeViewService;
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

public abstract class PSDETreeLogicBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDETreeLogicBase.class);
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
    public static final String FIELD_PSDETREECOLID = "PSDETREECOLID";
    public static final String FIELD_PSDETREECOLNAME = "PSDETREECOLNAME";
    public static final String FIELD_PSDETREELOGICID = "PSDETREELOGICID";
    public static final String FIELD_PSDETREELOGICNAME = "PSDETREELOGICNAME";
    public static final String FIELD_PSDETREENODEID = "PSDETREENODEID";
    public static final String FIELD_PSDETREENODENAME = "PSDETREENODENAME";
    public static final String FIELD_PSDETREEVIEWID = "PSDETREEVIEWID";
    public static final String FIELD_PSDETREEVIEWNAME = "PSDETREEVIEWNAME";
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
    private static final int INDEX_PSDEID = 12;
    private static final int INDEX_PSDELOGICID = 13;
    private static final int INDEX_PSDELOGICNAME = 14;
    private static final int INDEX_PSDENAME = 15;
    private static final int INDEX_PSDETREECOLID = 16;
    private static final int INDEX_PSDETREECOLNAME = 17;
    private static final int INDEX_PSDETREELOGICID = 18;
    private static final int INDEX_PSDETREELOGICNAME = 19;
    private static final int INDEX_PSDETREENODEID = 20;
    private static final int INDEX_PSDETREENODENAME = 21;
    private static final int INDEX_PSDETREEVIEWID = 22;
    private static final int INDEX_PSDETREEVIEWNAME = 23;
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
    private PSDETreeLogicBase proxyPSDETreeLogicBase = null;
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
    private boolean psdetreecolidDirtyFlag = false;
    private boolean psdetreecolnameDirtyFlag = false;
    private boolean psdetreelogicidDirtyFlag = false;
    private boolean psdetreelogicnameDirtyFlag = false;
    private boolean psdetreenodeidDirtyFlag = false;
    private boolean psdetreenodenameDirtyFlag = false;
    private boolean psdetreeviewidDirtyFlag = false;
    private boolean psdetreeviewnameDirtyFlag = false;
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
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdelogicid")
    private String psdelogicid;
    @Column(name="psdelogicname")
    private String psdelogicname;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psdetreecolid")
    private String psdetreecolid;
    @Column(name="psdetreecolname")
    private String psdetreecolname;
    @Column(name="psdetreelogicid")
    private String psdetreelogicid;
    @Column(name="psdetreelogicname")
    private String psdetreelogicname;
    @Column(name="psdetreenodeid")
    private String psdetreenodeid;
    @Column(name="psdetreenodename")
    private String psdetreenodename;
    @Column(name="psdetreeviewid")
    private String psdetreeviewid;
    @Column(name="psdetreeviewname")
    private String psdetreeviewname;
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
    private Integer objPSDELogicLock = new Integer(1);
    private PSDELogic psdelogic = null;
    private Integer objPSDETreeColLock = new Integer(1);
    private PSDETreeCol psdetreecol = null;
    private Integer objPSDETreeNodeLock = new Integer(1);
    private PSDETreeNode psdetreenode = null;
    private Integer objPSDETreeViewLock = new Integer(1);
    private PSDETreeView psdetreeview = null;
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

    public void setPSDETreeColId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDETreeColId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdetreecolid = string;
        this.psdetreecolidDirtyFlag = true;
    }

    public String getPSDETreeColId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETreeColId();
        }
        return this.psdetreecolid;
    }

    public boolean isPSDETreeColIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDETreeColIdDirty();
        }
        return this.psdetreecolidDirtyFlag;
    }

    public void resetPSDETreeColId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDETreeColId();
            return;
        }
        this.psdetreecolidDirtyFlag = false;
        this.psdetreecolid = null;
    }

    public void setPSDETreeColName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDETreeColName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdetreecolname = string;
        this.psdetreecolnameDirtyFlag = true;
    }

    public String getPSDETreeColName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETreeColName();
        }
        return this.psdetreecolname;
    }

    public boolean isPSDETreeColNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDETreeColNameDirty();
        }
        return this.psdetreecolnameDirtyFlag;
    }

    public void resetPSDETreeColName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDETreeColName();
            return;
        }
        this.psdetreecolnameDirtyFlag = false;
        this.psdetreecolname = null;
    }

    public void setPSDETreeLogicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDETreeLogicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdetreelogicid = string;
        this.psdetreelogicidDirtyFlag = true;
    }

    public String getPSDETreeLogicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETreeLogicId();
        }
        return this.psdetreelogicid;
    }

    public boolean isPSDETreeLogicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDETreeLogicIdDirty();
        }
        return this.psdetreelogicidDirtyFlag;
    }

    public void resetPSDETreeLogicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDETreeLogicId();
            return;
        }
        this.psdetreelogicidDirtyFlag = false;
        this.psdetreelogicid = null;
    }

    public void setPSDETreeLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDETreeLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdetreelogicname = string;
        this.psdetreelogicnameDirtyFlag = true;
    }

    public String getPSDETreeLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETreeLogicName();
        }
        return this.psdetreelogicname;
    }

    public boolean isPSDETreeLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDETreeLogicNameDirty();
        }
        return this.psdetreelogicnameDirtyFlag;
    }

    public void resetPSDETreeLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDETreeLogicName();
            return;
        }
        this.psdetreelogicnameDirtyFlag = false;
        this.psdetreelogicname = null;
    }

    public void setPSDETreeNodeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDETreeNodeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdetreenodeid = string;
        this.psdetreenodeidDirtyFlag = true;
    }

    public String getPSDETreeNodeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETreeNodeId();
        }
        return this.psdetreenodeid;
    }

    public boolean isPSDETreeNodeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDETreeNodeIdDirty();
        }
        return this.psdetreenodeidDirtyFlag;
    }

    public void resetPSDETreeNodeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDETreeNodeId();
            return;
        }
        this.psdetreenodeidDirtyFlag = false;
        this.psdetreenodeid = null;
    }

    public void setPSDETreeNodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDETreeNodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdetreenodename = string;
        this.psdetreenodenameDirtyFlag = true;
    }

    public String getPSDETreeNodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETreeNodeName();
        }
        return this.psdetreenodename;
    }

    public boolean isPSDETreeNodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDETreeNodeNameDirty();
        }
        return this.psdetreenodenameDirtyFlag;
    }

    public void resetPSDETreeNodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDETreeNodeName();
            return;
        }
        this.psdetreenodenameDirtyFlag = false;
        this.psdetreenodename = null;
    }

    public void setPSDETreeViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDETreeViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdetreeviewid = string;
        this.psdetreeviewidDirtyFlag = true;
    }

    public String getPSDETreeViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETreeViewId();
        }
        return this.psdetreeviewid;
    }

    public boolean isPSDETreeViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDETreeViewIdDirty();
        }
        return this.psdetreeviewidDirtyFlag;
    }

    public void resetPSDETreeViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDETreeViewId();
            return;
        }
        this.psdetreeviewidDirtyFlag = false;
        this.psdetreeviewid = null;
    }

    public void setPSDETreeViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDETreeViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdetreeviewname = string;
        this.psdetreeviewnameDirtyFlag = true;
    }

    public String getPSDETreeViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETreeViewName();
        }
        return this.psdetreeviewname;
    }

    public boolean isPSDETreeViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDETreeViewNameDirty();
        }
        return this.psdetreeviewnameDirtyFlag;
    }

    public void resetPSDETreeViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDETreeViewName();
            return;
        }
        this.psdetreeviewnameDirtyFlag = false;
        this.psdetreeviewname = null;
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
        PSDETreeLogicBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDETreeLogicBase pSDETreeLogicBase) {
        pSDETreeLogicBase.resetAttrName();
        pSDETreeLogicBase.resetCreateDate();
        pSDETreeLogicBase.resetCreateMan();
        pSDETreeLogicBase.resetCustomCode();
        pSDETreeLogicBase.resetDstLogicType();
        pSDETreeLogicBase.resetEventArg();
        pSDETreeLogicBase.resetEventArg2();
        pSDETreeLogicBase.resetEventNames();
        pSDETreeLogicBase.resetLogicParam();
        pSDETreeLogicBase.resetLogicParam2();
        pSDETreeLogicBase.resetMemo();
        pSDETreeLogicBase.resetOrderValue();
        pSDETreeLogicBase.resetPSDEId();
        pSDETreeLogicBase.resetPSDELogicId();
        pSDETreeLogicBase.resetPSDELogicName();
        pSDETreeLogicBase.resetPSDEName();
        pSDETreeLogicBase.resetPSDETreeColId();
        pSDETreeLogicBase.resetPSDETreeColName();
        pSDETreeLogicBase.resetPSDETreeLogicId();
        pSDETreeLogicBase.resetPSDETreeLogicName();
        pSDETreeLogicBase.resetPSDETreeNodeId();
        pSDETreeLogicBase.resetPSDETreeNodeName();
        pSDETreeLogicBase.resetPSDETreeViewId();
        pSDETreeLogicBase.resetPSDETreeViewName();
        pSDETreeLogicBase.resetPSDEUIActionId();
        pSDETreeLogicBase.resetPSDEUIActionName();
        pSDETreeLogicBase.resetPSSysPFPluginId();
        pSDETreeLogicBase.resetPSSysPFPluginName();
        pSDETreeLogicBase.resetPSSysViewLogicId();
        pSDETreeLogicBase.resetPSSysViewLogicName();
        pSDETreeLogicBase.resetPSSysViewPanelId();
        pSDETreeLogicBase.resetPSSysViewPanelName();
        pSDETreeLogicBase.resetTimer();
        pSDETreeLogicBase.resetTriggerType();
        pSDETreeLogicBase.resetUpdateDate();
        pSDETreeLogicBase.resetUpdateMan();
        pSDETreeLogicBase.resetUserCat();
        pSDETreeLogicBase.resetUserTag();
        pSDETreeLogicBase.resetUserTag2();
        pSDETreeLogicBase.resetUserTag3();
        pSDETreeLogicBase.resetUserTag4();
        pSDETreeLogicBase.resetValidFlag();
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
        if (!bl || this.isPSDETreeColIdDirty()) {
            hashMap.put(FIELD_PSDETREECOLID, this.getPSDETreeColId());
        }
        if (!bl || this.isPSDETreeColNameDirty()) {
            hashMap.put(FIELD_PSDETREECOLNAME, this.getPSDETreeColName());
        }
        if (!bl || this.isPSDETreeLogicIdDirty()) {
            hashMap.put(FIELD_PSDETREELOGICID, this.getPSDETreeLogicId());
        }
        if (!bl || this.isPSDETreeLogicNameDirty()) {
            hashMap.put(FIELD_PSDETREELOGICNAME, this.getPSDETreeLogicName());
        }
        if (!bl || this.isPSDETreeNodeIdDirty()) {
            hashMap.put(FIELD_PSDETREENODEID, this.getPSDETreeNodeId());
        }
        if (!bl || this.isPSDETreeNodeNameDirty()) {
            hashMap.put(FIELD_PSDETREENODENAME, this.getPSDETreeNodeName());
        }
        if (!bl || this.isPSDETreeViewIdDirty()) {
            hashMap.put(FIELD_PSDETREEVIEWID, this.getPSDETreeViewId());
        }
        if (!bl || this.isPSDETreeViewNameDirty()) {
            hashMap.put(FIELD_PSDETREEVIEWNAME, this.getPSDETreeViewName());
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
        return PSDETreeLogicBase.get(this, n);
    }

    private static Object get(PSDETreeLogicBase pSDETreeLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDETreeLogicBase.getAttrName();
            }
            case 1: {
                return pSDETreeLogicBase.getCreateDate();
            }
            case 2: {
                return pSDETreeLogicBase.getCreateMan();
            }
            case 3: {
                return pSDETreeLogicBase.getCustomCode();
            }
            case 4: {
                return pSDETreeLogicBase.getDstLogicType();
            }
            case 5: {
                return pSDETreeLogicBase.getEventArg();
            }
            case 6: {
                return pSDETreeLogicBase.getEventArg2();
            }
            case 7: {
                return pSDETreeLogicBase.getEventNames();
            }
            case 8: {
                return pSDETreeLogicBase.getLogicParam();
            }
            case 9: {
                return pSDETreeLogicBase.getLogicParam2();
            }
            case 10: {
                return pSDETreeLogicBase.getMemo();
            }
            case 11: {
                return pSDETreeLogicBase.getOrderValue();
            }
            case 12: {
                return pSDETreeLogicBase.getPSDEId();
            }
            case 13: {
                return pSDETreeLogicBase.getPSDELogicId();
            }
            case 14: {
                return pSDETreeLogicBase.getPSDELogicName();
            }
            case 15: {
                return pSDETreeLogicBase.getPSDEName();
            }
            case 16: {
                return pSDETreeLogicBase.getPSDETreeColId();
            }
            case 17: {
                return pSDETreeLogicBase.getPSDETreeColName();
            }
            case 18: {
                return pSDETreeLogicBase.getPSDETreeLogicId();
            }
            case 19: {
                return pSDETreeLogicBase.getPSDETreeLogicName();
            }
            case 20: {
                return pSDETreeLogicBase.getPSDETreeNodeId();
            }
            case 21: {
                return pSDETreeLogicBase.getPSDETreeNodeName();
            }
            case 22: {
                return pSDETreeLogicBase.getPSDETreeViewId();
            }
            case 23: {
                return pSDETreeLogicBase.getPSDETreeViewName();
            }
            case 24: {
                return pSDETreeLogicBase.getPSDEUIActionId();
            }
            case 25: {
                return pSDETreeLogicBase.getPSDEUIActionName();
            }
            case 26: {
                return pSDETreeLogicBase.getPSSysPFPluginId();
            }
            case 27: {
                return pSDETreeLogicBase.getPSSysPFPluginName();
            }
            case 28: {
                return pSDETreeLogicBase.getPSSysViewLogicId();
            }
            case 29: {
                return pSDETreeLogicBase.getPSSysViewLogicName();
            }
            case 30: {
                return pSDETreeLogicBase.getPSSysViewPanelId();
            }
            case 31: {
                return pSDETreeLogicBase.getPSSysViewPanelName();
            }
            case 32: {
                return pSDETreeLogicBase.getTimer();
            }
            case 33: {
                return pSDETreeLogicBase.getTriggerType();
            }
            case 34: {
                return pSDETreeLogicBase.getUpdateDate();
            }
            case 35: {
                return pSDETreeLogicBase.getUpdateMan();
            }
            case 36: {
                return pSDETreeLogicBase.getUserCat();
            }
            case 37: {
                return pSDETreeLogicBase.getUserTag();
            }
            case 38: {
                return pSDETreeLogicBase.getUserTag2();
            }
            case 39: {
                return pSDETreeLogicBase.getUserTag3();
            }
            case 40: {
                return pSDETreeLogicBase.getUserTag4();
            }
            case 41: {
                return pSDETreeLogicBase.getValidFlag();
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
        PSDETreeLogicBase.set(this, n, object);
    }

    private static void set(PSDETreeLogicBase pSDETreeLogicBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDETreeLogicBase.setAttrName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDETreeLogicBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDETreeLogicBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDETreeLogicBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDETreeLogicBase.setDstLogicType(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDETreeLogicBase.setEventArg(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDETreeLogicBase.setEventArg2(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDETreeLogicBase.setEventNames(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDETreeLogicBase.setLogicParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDETreeLogicBase.setLogicParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDETreeLogicBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDETreeLogicBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSDETreeLogicBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDETreeLogicBase.setPSDELogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDETreeLogicBase.setPSDELogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDETreeLogicBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDETreeLogicBase.setPSDETreeColId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDETreeLogicBase.setPSDETreeColName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDETreeLogicBase.setPSDETreeLogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDETreeLogicBase.setPSDETreeLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDETreeLogicBase.setPSDETreeNodeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDETreeLogicBase.setPSDETreeNodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDETreeLogicBase.setPSDETreeViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDETreeLogicBase.setPSDETreeViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDETreeLogicBase.setPSDEUIActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDETreeLogicBase.setPSDEUIActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDETreeLogicBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDETreeLogicBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDETreeLogicBase.setPSSysViewLogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDETreeLogicBase.setPSSysViewLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDETreeLogicBase.setPSSysViewPanelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDETreeLogicBase.setPSSysViewPanelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDETreeLogicBase.setTimer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 33: {
                pSDETreeLogicBase.setTriggerType(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDETreeLogicBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 35: {
                pSDETreeLogicBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDETreeLogicBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSDETreeLogicBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDETreeLogicBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSDETreeLogicBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSDETreeLogicBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSDETreeLogicBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDETreeLogicBase.isNull(this, n);
    }

    private static boolean isNull(PSDETreeLogicBase pSDETreeLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDETreeLogicBase.getAttrName() == null;
            }
            case 1: {
                return pSDETreeLogicBase.getCreateDate() == null;
            }
            case 2: {
                return pSDETreeLogicBase.getCreateMan() == null;
            }
            case 3: {
                return pSDETreeLogicBase.getCustomCode() == null;
            }
            case 4: {
                return pSDETreeLogicBase.getDstLogicType() == null;
            }
            case 5: {
                return pSDETreeLogicBase.getEventArg() == null;
            }
            case 6: {
                return pSDETreeLogicBase.getEventArg2() == null;
            }
            case 7: {
                return pSDETreeLogicBase.getEventNames() == null;
            }
            case 8: {
                return pSDETreeLogicBase.getLogicParam() == null;
            }
            case 9: {
                return pSDETreeLogicBase.getLogicParam2() == null;
            }
            case 10: {
                return pSDETreeLogicBase.getMemo() == null;
            }
            case 11: {
                return pSDETreeLogicBase.getOrderValue() == null;
            }
            case 12: {
                return pSDETreeLogicBase.getPSDEId() == null;
            }
            case 13: {
                return pSDETreeLogicBase.getPSDELogicId() == null;
            }
            case 14: {
                return pSDETreeLogicBase.getPSDELogicName() == null;
            }
            case 15: {
                return pSDETreeLogicBase.getPSDEName() == null;
            }
            case 16: {
                return pSDETreeLogicBase.getPSDETreeColId() == null;
            }
            case 17: {
                return pSDETreeLogicBase.getPSDETreeColName() == null;
            }
            case 18: {
                return pSDETreeLogicBase.getPSDETreeLogicId() == null;
            }
            case 19: {
                return pSDETreeLogicBase.getPSDETreeLogicName() == null;
            }
            case 20: {
                return pSDETreeLogicBase.getPSDETreeNodeId() == null;
            }
            case 21: {
                return pSDETreeLogicBase.getPSDETreeNodeName() == null;
            }
            case 22: {
                return pSDETreeLogicBase.getPSDETreeViewId() == null;
            }
            case 23: {
                return pSDETreeLogicBase.getPSDETreeViewName() == null;
            }
            case 24: {
                return pSDETreeLogicBase.getPSDEUIActionId() == null;
            }
            case 25: {
                return pSDETreeLogicBase.getPSDEUIActionName() == null;
            }
            case 26: {
                return pSDETreeLogicBase.getPSSysPFPluginId() == null;
            }
            case 27: {
                return pSDETreeLogicBase.getPSSysPFPluginName() == null;
            }
            case 28: {
                return pSDETreeLogicBase.getPSSysViewLogicId() == null;
            }
            case 29: {
                return pSDETreeLogicBase.getPSSysViewLogicName() == null;
            }
            case 30: {
                return pSDETreeLogicBase.getPSSysViewPanelId() == null;
            }
            case 31: {
                return pSDETreeLogicBase.getPSSysViewPanelName() == null;
            }
            case 32: {
                return pSDETreeLogicBase.getTimer() == null;
            }
            case 33: {
                return pSDETreeLogicBase.getTriggerType() == null;
            }
            case 34: {
                return pSDETreeLogicBase.getUpdateDate() == null;
            }
            case 35: {
                return pSDETreeLogicBase.getUpdateMan() == null;
            }
            case 36: {
                return pSDETreeLogicBase.getUserCat() == null;
            }
            case 37: {
                return pSDETreeLogicBase.getUserTag() == null;
            }
            case 38: {
                return pSDETreeLogicBase.getUserTag2() == null;
            }
            case 39: {
                return pSDETreeLogicBase.getUserTag3() == null;
            }
            case 40: {
                return pSDETreeLogicBase.getUserTag4() == null;
            }
            case 41: {
                return pSDETreeLogicBase.getValidFlag() == null;
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
        return PSDETreeLogicBase.contains(this, n);
    }

    private static boolean contains(PSDETreeLogicBase pSDETreeLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDETreeLogicBase.isAttrNameDirty();
            }
            case 1: {
                return pSDETreeLogicBase.isCreateDateDirty();
            }
            case 2: {
                return pSDETreeLogicBase.isCreateManDirty();
            }
            case 3: {
                return pSDETreeLogicBase.isCustomCodeDirty();
            }
            case 4: {
                return pSDETreeLogicBase.isDstLogicTypeDirty();
            }
            case 5: {
                return pSDETreeLogicBase.isEventArgDirty();
            }
            case 6: {
                return pSDETreeLogicBase.isEventArg2Dirty();
            }
            case 7: {
                return pSDETreeLogicBase.isEventNamesDirty();
            }
            case 8: {
                return pSDETreeLogicBase.isLogicParamDirty();
            }
            case 9: {
                return pSDETreeLogicBase.isLogicParam2Dirty();
            }
            case 10: {
                return pSDETreeLogicBase.isMemoDirty();
            }
            case 11: {
                return pSDETreeLogicBase.isOrderValueDirty();
            }
            case 12: {
                return pSDETreeLogicBase.isPSDEIdDirty();
            }
            case 13: {
                return pSDETreeLogicBase.isPSDELogicIdDirty();
            }
            case 14: {
                return pSDETreeLogicBase.isPSDELogicNameDirty();
            }
            case 15: {
                return pSDETreeLogicBase.isPSDENameDirty();
            }
            case 16: {
                return pSDETreeLogicBase.isPSDETreeColIdDirty();
            }
            case 17: {
                return pSDETreeLogicBase.isPSDETreeColNameDirty();
            }
            case 18: {
                return pSDETreeLogicBase.isPSDETreeLogicIdDirty();
            }
            case 19: {
                return pSDETreeLogicBase.isPSDETreeLogicNameDirty();
            }
            case 20: {
                return pSDETreeLogicBase.isPSDETreeNodeIdDirty();
            }
            case 21: {
                return pSDETreeLogicBase.isPSDETreeNodeNameDirty();
            }
            case 22: {
                return pSDETreeLogicBase.isPSDETreeViewIdDirty();
            }
            case 23: {
                return pSDETreeLogicBase.isPSDETreeViewNameDirty();
            }
            case 24: {
                return pSDETreeLogicBase.isPSDEUIActionIdDirty();
            }
            case 25: {
                return pSDETreeLogicBase.isPSDEUIActionNameDirty();
            }
            case 26: {
                return pSDETreeLogicBase.isPSSysPFPluginIdDirty();
            }
            case 27: {
                return pSDETreeLogicBase.isPSSysPFPluginNameDirty();
            }
            case 28: {
                return pSDETreeLogicBase.isPSSysViewLogicIdDirty();
            }
            case 29: {
                return pSDETreeLogicBase.isPSSysViewLogicNameDirty();
            }
            case 30: {
                return pSDETreeLogicBase.isPSSysViewPanelIdDirty();
            }
            case 31: {
                return pSDETreeLogicBase.isPSSysViewPanelNameDirty();
            }
            case 32: {
                return pSDETreeLogicBase.isTimerDirty();
            }
            case 33: {
                return pSDETreeLogicBase.isTriggerTypeDirty();
            }
            case 34: {
                return pSDETreeLogicBase.isUpdateDateDirty();
            }
            case 35: {
                return pSDETreeLogicBase.isUpdateManDirty();
            }
            case 36: {
                return pSDETreeLogicBase.isUserCatDirty();
            }
            case 37: {
                return pSDETreeLogicBase.isUserTagDirty();
            }
            case 38: {
                return pSDETreeLogicBase.isUserTag2Dirty();
            }
            case 39: {
                return pSDETreeLogicBase.isUserTag3Dirty();
            }
            case 40: {
                return pSDETreeLogicBase.isUserTag4Dirty();
            }
            case 41: {
                return pSDETreeLogicBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDETreeLogicBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDETreeLogicBase pSDETreeLogicBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDETreeLogicBase.getAttrName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"attrname", (Object)PSDETreeLogicBase.getJSONValue((Object)pSDETreeLogicBase.getAttrName()), (boolean)false);
        }
        if (bl || pSDETreeLogicBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDETreeLogicBase.getJSONValue((Object)pSDETreeLogicBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDETreeLogicBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDETreeLogicBase.getJSONValue((Object)pSDETreeLogicBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDETreeLogicBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSDETreeLogicBase.getJSONValue((Object)pSDETreeLogicBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSDETreeLogicBase.getDstLogicType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstlogictype", (Object)PSDETreeLogicBase.getJSONValue((Object)pSDETreeLogicBase.getDstLogicType()), (boolean)false);
        }
        if (bl || pSDETreeLogicBase.getEventArg() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eventarg", (Object)PSDETreeLogicBase.getJSONValue((Object)pSDETreeLogicBase.getEventArg()), (boolean)false);
        }
        if (bl || pSDETreeLogicBase.getEventArg2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eventarg2", (Object)PSDETreeLogicBase.getJSONValue((Object)pSDETreeLogicBase.getEventArg2()), (boolean)false);
        }
        if (bl || pSDETreeLogicBase.getEventNames() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eventnames", (Object)PSDETreeLogicBase.getJSONValue((Object)pSDETreeLogicBase.getEventNames()), (boolean)false);
        }
        if (bl || pSDETreeLogicBase.getLogicParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicparam", (Object)PSDETreeLogicBase.getJSONValue((Object)pSDETreeLogicBase.getLogicParam()), (boolean)false);
        }
        if (bl || pSDETreeLogicBase.getLogicParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicparam2", (Object)PSDETreeLogicBase.getJSONValue((Object)pSDETreeLogicBase.getLogicParam2()), (boolean)false);
        }
        if (bl || pSDETreeLogicBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDETreeLogicBase.getJSONValue((Object)pSDETreeLogicBase.getMemo()), (boolean)false);
        }
        if (bl || pSDETreeLogicBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDETreeLogicBase.getJSONValue((Object)pSDETreeLogicBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDETreeLogicBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDETreeLogicBase.getJSONValue((Object)pSDETreeLogicBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDETreeLogicBase.getPSDELogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicid", (Object)PSDETreeLogicBase.getJSONValue((Object)pSDETreeLogicBase.getPSDELogicId()), (boolean)false);
        }
        if (bl || pSDETreeLogicBase.getPSDELogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicname", (Object)PSDETreeLogicBase.getJSONValue((Object)pSDETreeLogicBase.getPSDELogicName()), (boolean)false);
        }
        if (bl || pSDETreeLogicBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDETreeLogicBase.getJSONValue((Object)pSDETreeLogicBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDETreeLogicBase.getPSDETreeColId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetreecolid", (Object)PSDETreeLogicBase.getJSONValue((Object)pSDETreeLogicBase.getPSDETreeColId()), (boolean)false);
        }
        if (bl || pSDETreeLogicBase.getPSDETreeColName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetreecolname", (Object)PSDETreeLogicBase.getJSONValue((Object)pSDETreeLogicBase.getPSDETreeColName()), (boolean)false);
        }
        if (bl || pSDETreeLogicBase.getPSDETreeLogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetreelogicid", (Object)PSDETreeLogicBase.getJSONValue((Object)pSDETreeLogicBase.getPSDETreeLogicId()), (boolean)false);
        }
        if (bl || pSDETreeLogicBase.getPSDETreeLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetreelogicname", (Object)PSDETreeLogicBase.getJSONValue((Object)pSDETreeLogicBase.getPSDETreeLogicName()), (boolean)false);
        }
        if (bl || pSDETreeLogicBase.getPSDETreeNodeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetreenodeid", (Object)PSDETreeLogicBase.getJSONValue((Object)pSDETreeLogicBase.getPSDETreeNodeId()), (boolean)false);
        }
        if (bl || pSDETreeLogicBase.getPSDETreeNodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetreenodename", (Object)PSDETreeLogicBase.getJSONValue((Object)pSDETreeLogicBase.getPSDETreeNodeName()), (boolean)false);
        }
        if (bl || pSDETreeLogicBase.getPSDETreeViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetreeviewid", (Object)PSDETreeLogicBase.getJSONValue((Object)pSDETreeLogicBase.getPSDETreeViewId()), (boolean)false);
        }
        if (bl || pSDETreeLogicBase.getPSDETreeViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetreeviewname", (Object)PSDETreeLogicBase.getJSONValue((Object)pSDETreeLogicBase.getPSDETreeViewName()), (boolean)false);
        }
        if (bl || pSDETreeLogicBase.getPSDEUIActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuiactionid", (Object)PSDETreeLogicBase.getJSONValue((Object)pSDETreeLogicBase.getPSDEUIActionId()), (boolean)false);
        }
        if (bl || pSDETreeLogicBase.getPSDEUIActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuiactionname", (Object)PSDETreeLogicBase.getJSONValue((Object)pSDETreeLogicBase.getPSDEUIActionName()), (boolean)false);
        }
        if (bl || pSDETreeLogicBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSDETreeLogicBase.getJSONValue((Object)pSDETreeLogicBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSDETreeLogicBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSDETreeLogicBase.getJSONValue((Object)pSDETreeLogicBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSDETreeLogicBase.getPSSysViewLogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewlogicid", (Object)PSDETreeLogicBase.getJSONValue((Object)pSDETreeLogicBase.getPSSysViewLogicId()), (boolean)false);
        }
        if (bl || pSDETreeLogicBase.getPSSysViewLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewlogicname", (Object)PSDETreeLogicBase.getJSONValue((Object)pSDETreeLogicBase.getPSSysViewLogicName()), (boolean)false);
        }
        if (bl || pSDETreeLogicBase.getPSSysViewPanelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelid", (Object)PSDETreeLogicBase.getJSONValue((Object)pSDETreeLogicBase.getPSSysViewPanelId()), (boolean)false);
        }
        if (bl || pSDETreeLogicBase.getPSSysViewPanelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelname", (Object)PSDETreeLogicBase.getJSONValue((Object)pSDETreeLogicBase.getPSSysViewPanelName()), (boolean)false);
        }
        if (bl || pSDETreeLogicBase.getTimer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"timer", (Object)PSDETreeLogicBase.getJSONValue((Object)pSDETreeLogicBase.getTimer()), (boolean)false);
        }
        if (bl || pSDETreeLogicBase.getTriggerType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"triggertype", (Object)PSDETreeLogicBase.getJSONValue((Object)pSDETreeLogicBase.getTriggerType()), (boolean)false);
        }
        if (bl || pSDETreeLogicBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDETreeLogicBase.getJSONValue((Object)pSDETreeLogicBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDETreeLogicBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDETreeLogicBase.getJSONValue((Object)pSDETreeLogicBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDETreeLogicBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDETreeLogicBase.getJSONValue((Object)pSDETreeLogicBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDETreeLogicBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDETreeLogicBase.getJSONValue((Object)pSDETreeLogicBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDETreeLogicBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDETreeLogicBase.getJSONValue((Object)pSDETreeLogicBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDETreeLogicBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDETreeLogicBase.getJSONValue((Object)pSDETreeLogicBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDETreeLogicBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDETreeLogicBase.getJSONValue((Object)pSDETreeLogicBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDETreeLogicBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDETreeLogicBase.getJSONValue((Object)pSDETreeLogicBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDETreeLogicBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDETreeLogicBase pSDETreeLogicBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDETreeLogicBase.getAttrName() != null) {
            object = pSDETreeLogicBase.getAttrName();
            xmlNode.setAttribute(FIELD_ATTRNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeLogicBase.getCreateDate() != null) {
            object = pSDETreeLogicBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDETreeLogicBase.getCreateMan() != null) {
            object = pSDETreeLogicBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeLogicBase.getCustomCode() != null) {
            object = pSDETreeLogicBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeLogicBase.getDstLogicType() != null) {
            object = pSDETreeLogicBase.getDstLogicType();
            xmlNode.setAttribute(FIELD_DSTLOGICTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeLogicBase.getEventArg() != null) {
            object = pSDETreeLogicBase.getEventArg();
            xmlNode.setAttribute(FIELD_EVENTARG, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeLogicBase.getEventArg2() != null) {
            object = pSDETreeLogicBase.getEventArg2();
            xmlNode.setAttribute(FIELD_EVENTARG2, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeLogicBase.getEventNames() != null) {
            object = pSDETreeLogicBase.getEventNames();
            xmlNode.setAttribute(FIELD_EVENTNAMES, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeLogicBase.getLogicParam() != null) {
            object = pSDETreeLogicBase.getLogicParam();
            xmlNode.setAttribute(FIELD_LOGICPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeLogicBase.getLogicParam2() != null) {
            object = pSDETreeLogicBase.getLogicParam2();
            xmlNode.setAttribute(FIELD_LOGICPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeLogicBase.getMemo() != null) {
            object = pSDETreeLogicBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeLogicBase.getOrderValue() != null) {
            object = pSDETreeLogicBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETreeLogicBase.getPSDEId() != null) {
            object = pSDETreeLogicBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeLogicBase.getPSDELogicId() != null) {
            object = pSDETreeLogicBase.getPSDELogicId();
            xmlNode.setAttribute(FIELD_PSDELOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeLogicBase.getPSDELogicName() != null) {
            object = pSDETreeLogicBase.getPSDELogicName();
            xmlNode.setAttribute(FIELD_PSDELOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeLogicBase.getPSDEName() != null) {
            object = pSDETreeLogicBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeLogicBase.getPSDETreeColId() != null) {
            object = pSDETreeLogicBase.getPSDETreeColId();
            xmlNode.setAttribute(FIELD_PSDETREECOLID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeLogicBase.getPSDETreeColName() != null) {
            object = pSDETreeLogicBase.getPSDETreeColName();
            xmlNode.setAttribute(FIELD_PSDETREECOLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeLogicBase.getPSDETreeLogicId() != null) {
            object = pSDETreeLogicBase.getPSDETreeLogicId();
            xmlNode.setAttribute(FIELD_PSDETREELOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeLogicBase.getPSDETreeLogicName() != null) {
            object = pSDETreeLogicBase.getPSDETreeLogicName();
            xmlNode.setAttribute(FIELD_PSDETREELOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeLogicBase.getPSDETreeNodeId() != null) {
            object = pSDETreeLogicBase.getPSDETreeNodeId();
            xmlNode.setAttribute(FIELD_PSDETREENODEID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeLogicBase.getPSDETreeNodeName() != null) {
            object = pSDETreeLogicBase.getPSDETreeNodeName();
            xmlNode.setAttribute(FIELD_PSDETREENODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeLogicBase.getPSDETreeViewId() != null) {
            object = pSDETreeLogicBase.getPSDETreeViewId();
            xmlNode.setAttribute(FIELD_PSDETREEVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeLogicBase.getPSDETreeViewName() != null) {
            object = pSDETreeLogicBase.getPSDETreeViewName();
            xmlNode.setAttribute(FIELD_PSDETREEVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeLogicBase.getPSDEUIActionId() != null) {
            object = pSDETreeLogicBase.getPSDEUIActionId();
            xmlNode.setAttribute(FIELD_PSDEUIACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeLogicBase.getPSDEUIActionName() != null) {
            object = pSDETreeLogicBase.getPSDEUIActionName();
            xmlNode.setAttribute(FIELD_PSDEUIACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeLogicBase.getPSSysPFPluginId() != null) {
            object = pSDETreeLogicBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeLogicBase.getPSSysPFPluginName() != null) {
            object = pSDETreeLogicBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeLogicBase.getPSSysViewLogicId() != null) {
            object = pSDETreeLogicBase.getPSSysViewLogicId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWLOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeLogicBase.getPSSysViewLogicName() != null) {
            object = pSDETreeLogicBase.getPSSysViewLogicName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWLOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeLogicBase.getPSSysViewPanelId() != null) {
            object = pSDETreeLogicBase.getPSSysViewPanelId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeLogicBase.getPSSysViewPanelName() != null) {
            object = pSDETreeLogicBase.getPSSysViewPanelName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeLogicBase.getTimer() != null) {
            object = pSDETreeLogicBase.getTimer();
            xmlNode.setAttribute(FIELD_TIMER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETreeLogicBase.getTriggerType() != null) {
            object = pSDETreeLogicBase.getTriggerType();
            xmlNode.setAttribute(FIELD_TRIGGERTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeLogicBase.getUpdateDate() != null) {
            object = pSDETreeLogicBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDETreeLogicBase.getUpdateMan() != null) {
            object = pSDETreeLogicBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeLogicBase.getUserCat() != null) {
            object = pSDETreeLogicBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeLogicBase.getUserTag() != null) {
            object = pSDETreeLogicBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeLogicBase.getUserTag2() != null) {
            object = pSDETreeLogicBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeLogicBase.getUserTag3() != null) {
            object = pSDETreeLogicBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeLogicBase.getUserTag4() != null) {
            object = pSDETreeLogicBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeLogicBase.getValidFlag() != null) {
            object = pSDETreeLogicBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDETreeLogicBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDETreeLogicBase pSDETreeLogicBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDETreeLogicBase.isAttrNameDirty() && (bl || pSDETreeLogicBase.getAttrName() != null)) {
            iDataObject.set(FIELD_ATTRNAME, (Object)pSDETreeLogicBase.getAttrName());
        }
        if (pSDETreeLogicBase.isCreateDateDirty() && (bl || pSDETreeLogicBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDETreeLogicBase.getCreateDate());
        }
        if (pSDETreeLogicBase.isCreateManDirty() && (bl || pSDETreeLogicBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDETreeLogicBase.getCreateMan());
        }
        if (pSDETreeLogicBase.isCustomCodeDirty() && (bl || pSDETreeLogicBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSDETreeLogicBase.getCustomCode());
        }
        if (pSDETreeLogicBase.isDstLogicTypeDirty() && (bl || pSDETreeLogicBase.getDstLogicType() != null)) {
            iDataObject.set(FIELD_DSTLOGICTYPE, (Object)pSDETreeLogicBase.getDstLogicType());
        }
        if (pSDETreeLogicBase.isEventArgDirty() && (bl || pSDETreeLogicBase.getEventArg() != null)) {
            iDataObject.set(FIELD_EVENTARG, (Object)pSDETreeLogicBase.getEventArg());
        }
        if (pSDETreeLogicBase.isEventArg2Dirty() && (bl || pSDETreeLogicBase.getEventArg2() != null)) {
            iDataObject.set(FIELD_EVENTARG2, (Object)pSDETreeLogicBase.getEventArg2());
        }
        if (pSDETreeLogicBase.isEventNamesDirty() && (bl || pSDETreeLogicBase.getEventNames() != null)) {
            iDataObject.set(FIELD_EVENTNAMES, (Object)pSDETreeLogicBase.getEventNames());
        }
        if (pSDETreeLogicBase.isLogicParamDirty() && (bl || pSDETreeLogicBase.getLogicParam() != null)) {
            iDataObject.set(FIELD_LOGICPARAM, (Object)pSDETreeLogicBase.getLogicParam());
        }
        if (pSDETreeLogicBase.isLogicParam2Dirty() && (bl || pSDETreeLogicBase.getLogicParam2() != null)) {
            iDataObject.set(FIELD_LOGICPARAM2, (Object)pSDETreeLogicBase.getLogicParam2());
        }
        if (pSDETreeLogicBase.isMemoDirty() && (bl || pSDETreeLogicBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDETreeLogicBase.getMemo());
        }
        if (pSDETreeLogicBase.isOrderValueDirty() && (bl || pSDETreeLogicBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDETreeLogicBase.getOrderValue());
        }
        if (pSDETreeLogicBase.isPSDEIdDirty() && (bl || pSDETreeLogicBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDETreeLogicBase.getPSDEId());
        }
        if (pSDETreeLogicBase.isPSDELogicIdDirty() && (bl || pSDETreeLogicBase.getPSDELogicId() != null)) {
            iDataObject.set(FIELD_PSDELOGICID, (Object)pSDETreeLogicBase.getPSDELogicId());
        }
        if (pSDETreeLogicBase.isPSDELogicNameDirty() && (bl || pSDETreeLogicBase.getPSDELogicName() != null)) {
            iDataObject.set(FIELD_PSDELOGICNAME, (Object)pSDETreeLogicBase.getPSDELogicName());
        }
        if (pSDETreeLogicBase.isPSDENameDirty() && (bl || pSDETreeLogicBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDETreeLogicBase.getPSDEName());
        }
        if (pSDETreeLogicBase.isPSDETreeColIdDirty() && (bl || pSDETreeLogicBase.getPSDETreeColId() != null)) {
            iDataObject.set(FIELD_PSDETREECOLID, (Object)pSDETreeLogicBase.getPSDETreeColId());
        }
        if (pSDETreeLogicBase.isPSDETreeColNameDirty() && (bl || pSDETreeLogicBase.getPSDETreeColName() != null)) {
            iDataObject.set(FIELD_PSDETREECOLNAME, (Object)pSDETreeLogicBase.getPSDETreeColName());
        }
        if (pSDETreeLogicBase.isPSDETreeLogicIdDirty() && (bl || pSDETreeLogicBase.getPSDETreeLogicId() != null)) {
            iDataObject.set(FIELD_PSDETREELOGICID, (Object)pSDETreeLogicBase.getPSDETreeLogicId());
        }
        if (pSDETreeLogicBase.isPSDETreeLogicNameDirty() && (bl || pSDETreeLogicBase.getPSDETreeLogicName() != null)) {
            iDataObject.set(FIELD_PSDETREELOGICNAME, (Object)pSDETreeLogicBase.getPSDETreeLogicName());
        }
        if (pSDETreeLogicBase.isPSDETreeNodeIdDirty() && (bl || pSDETreeLogicBase.getPSDETreeNodeId() != null)) {
            iDataObject.set(FIELD_PSDETREENODEID, (Object)pSDETreeLogicBase.getPSDETreeNodeId());
        }
        if (pSDETreeLogicBase.isPSDETreeNodeNameDirty() && (bl || pSDETreeLogicBase.getPSDETreeNodeName() != null)) {
            iDataObject.set(FIELD_PSDETREENODENAME, (Object)pSDETreeLogicBase.getPSDETreeNodeName());
        }
        if (pSDETreeLogicBase.isPSDETreeViewIdDirty() && (bl || pSDETreeLogicBase.getPSDETreeViewId() != null)) {
            iDataObject.set(FIELD_PSDETREEVIEWID, (Object)pSDETreeLogicBase.getPSDETreeViewId());
        }
        if (pSDETreeLogicBase.isPSDETreeViewNameDirty() && (bl || pSDETreeLogicBase.getPSDETreeViewName() != null)) {
            iDataObject.set(FIELD_PSDETREEVIEWNAME, (Object)pSDETreeLogicBase.getPSDETreeViewName());
        }
        if (pSDETreeLogicBase.isPSDEUIActionIdDirty() && (bl || pSDETreeLogicBase.getPSDEUIActionId() != null)) {
            iDataObject.set(FIELD_PSDEUIACTIONID, (Object)pSDETreeLogicBase.getPSDEUIActionId());
        }
        if (pSDETreeLogicBase.isPSDEUIActionNameDirty() && (bl || pSDETreeLogicBase.getPSDEUIActionName() != null)) {
            iDataObject.set(FIELD_PSDEUIACTIONNAME, (Object)pSDETreeLogicBase.getPSDEUIActionName());
        }
        if (pSDETreeLogicBase.isPSSysPFPluginIdDirty() && (bl || pSDETreeLogicBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSDETreeLogicBase.getPSSysPFPluginId());
        }
        if (pSDETreeLogicBase.isPSSysPFPluginNameDirty() && (bl || pSDETreeLogicBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSDETreeLogicBase.getPSSysPFPluginName());
        }
        if (pSDETreeLogicBase.isPSSysViewLogicIdDirty() && (bl || pSDETreeLogicBase.getPSSysViewLogicId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWLOGICID, (Object)pSDETreeLogicBase.getPSSysViewLogicId());
        }
        if (pSDETreeLogicBase.isPSSysViewLogicNameDirty() && (bl || pSDETreeLogicBase.getPSSysViewLogicName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWLOGICNAME, (Object)pSDETreeLogicBase.getPSSysViewLogicName());
        }
        if (pSDETreeLogicBase.isPSSysViewPanelIdDirty() && (bl || pSDETreeLogicBase.getPSSysViewPanelId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELID, (Object)pSDETreeLogicBase.getPSSysViewPanelId());
        }
        if (pSDETreeLogicBase.isPSSysViewPanelNameDirty() && (bl || pSDETreeLogicBase.getPSSysViewPanelName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELNAME, (Object)pSDETreeLogicBase.getPSSysViewPanelName());
        }
        if (pSDETreeLogicBase.isTimerDirty() && (bl || pSDETreeLogicBase.getTimer() != null)) {
            iDataObject.set(FIELD_TIMER, (Object)pSDETreeLogicBase.getTimer());
        }
        if (pSDETreeLogicBase.isTriggerTypeDirty() && (bl || pSDETreeLogicBase.getTriggerType() != null)) {
            iDataObject.set(FIELD_TRIGGERTYPE, (Object)pSDETreeLogicBase.getTriggerType());
        }
        if (pSDETreeLogicBase.isUpdateDateDirty() && (bl || pSDETreeLogicBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDETreeLogicBase.getUpdateDate());
        }
        if (pSDETreeLogicBase.isUpdateManDirty() && (bl || pSDETreeLogicBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDETreeLogicBase.getUpdateMan());
        }
        if (pSDETreeLogicBase.isUserCatDirty() && (bl || pSDETreeLogicBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDETreeLogicBase.getUserCat());
        }
        if (pSDETreeLogicBase.isUserTagDirty() && (bl || pSDETreeLogicBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDETreeLogicBase.getUserTag());
        }
        if (pSDETreeLogicBase.isUserTag2Dirty() && (bl || pSDETreeLogicBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDETreeLogicBase.getUserTag2());
        }
        if (pSDETreeLogicBase.isUserTag3Dirty() && (bl || pSDETreeLogicBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDETreeLogicBase.getUserTag3());
        }
        if (pSDETreeLogicBase.isUserTag4Dirty() && (bl || pSDETreeLogicBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDETreeLogicBase.getUserTag4());
        }
        if (pSDETreeLogicBase.isValidFlagDirty() && (bl || pSDETreeLogicBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDETreeLogicBase.getValidFlag());
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
        return PSDETreeLogicBase.remove(this, n);
    }

    private static boolean remove(PSDETreeLogicBase pSDETreeLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDETreeLogicBase.resetAttrName();
                return true;
            }
            case 1: {
                pSDETreeLogicBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDETreeLogicBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDETreeLogicBase.resetCustomCode();
                return true;
            }
            case 4: {
                pSDETreeLogicBase.resetDstLogicType();
                return true;
            }
            case 5: {
                pSDETreeLogicBase.resetEventArg();
                return true;
            }
            case 6: {
                pSDETreeLogicBase.resetEventArg2();
                return true;
            }
            case 7: {
                pSDETreeLogicBase.resetEventNames();
                return true;
            }
            case 8: {
                pSDETreeLogicBase.resetLogicParam();
                return true;
            }
            case 9: {
                pSDETreeLogicBase.resetLogicParam2();
                return true;
            }
            case 10: {
                pSDETreeLogicBase.resetMemo();
                return true;
            }
            case 11: {
                pSDETreeLogicBase.resetOrderValue();
                return true;
            }
            case 12: {
                pSDETreeLogicBase.resetPSDEId();
                return true;
            }
            case 13: {
                pSDETreeLogicBase.resetPSDELogicId();
                return true;
            }
            case 14: {
                pSDETreeLogicBase.resetPSDELogicName();
                return true;
            }
            case 15: {
                pSDETreeLogicBase.resetPSDEName();
                return true;
            }
            case 16: {
                pSDETreeLogicBase.resetPSDETreeColId();
                return true;
            }
            case 17: {
                pSDETreeLogicBase.resetPSDETreeColName();
                return true;
            }
            case 18: {
                pSDETreeLogicBase.resetPSDETreeLogicId();
                return true;
            }
            case 19: {
                pSDETreeLogicBase.resetPSDETreeLogicName();
                return true;
            }
            case 20: {
                pSDETreeLogicBase.resetPSDETreeNodeId();
                return true;
            }
            case 21: {
                pSDETreeLogicBase.resetPSDETreeNodeName();
                return true;
            }
            case 22: {
                pSDETreeLogicBase.resetPSDETreeViewId();
                return true;
            }
            case 23: {
                pSDETreeLogicBase.resetPSDETreeViewName();
                return true;
            }
            case 24: {
                pSDETreeLogicBase.resetPSDEUIActionId();
                return true;
            }
            case 25: {
                pSDETreeLogicBase.resetPSDEUIActionName();
                return true;
            }
            case 26: {
                pSDETreeLogicBase.resetPSSysPFPluginId();
                return true;
            }
            case 27: {
                pSDETreeLogicBase.resetPSSysPFPluginName();
                return true;
            }
            case 28: {
                pSDETreeLogicBase.resetPSSysViewLogicId();
                return true;
            }
            case 29: {
                pSDETreeLogicBase.resetPSSysViewLogicName();
                return true;
            }
            case 30: {
                pSDETreeLogicBase.resetPSSysViewPanelId();
                return true;
            }
            case 31: {
                pSDETreeLogicBase.resetPSSysViewPanelName();
                return true;
            }
            case 32: {
                pSDETreeLogicBase.resetTimer();
                return true;
            }
            case 33: {
                pSDETreeLogicBase.resetTriggerType();
                return true;
            }
            case 34: {
                pSDETreeLogicBase.resetUpdateDate();
                return true;
            }
            case 35: {
                pSDETreeLogicBase.resetUpdateMan();
                return true;
            }
            case 36: {
                pSDETreeLogicBase.resetUserCat();
                return true;
            }
            case 37: {
                pSDETreeLogicBase.resetUserTag();
                return true;
            }
            case 38: {
                pSDETreeLogicBase.resetUserTag2();
                return true;
            }
            case 39: {
                pSDETreeLogicBase.resetUserTag3();
                return true;
            }
            case 40: {
                pSDETreeLogicBase.resetUserTag4();
                return true;
            }
            case 41: {
                pSDETreeLogicBase.resetValidFlag();
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
    public PSDETreeCol getPSDETreeCol() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETreeCol();
        }
        if (this.getPSDETreeColId() == null) {
            return null;
        }
        Integer n = this.objPSDETreeColLock;
        synchronized (n) {
            if (this.psdetreecol != null && DataTypeHelper.compare((int)25, (Object)this.getPSDETreeColId(), (Object)this.psdetreecol.getPSDETreeColId()) != 0L) {
                this.psdetreecol = null;
            }
            if (this.psdetreecol == null) {
                PSDETreeCol pSDETreeCol = new PSDETreeCol();
                pSDETreeCol.setPSDETreeColId(this.getPSDETreeColId());
                PSDETreeColService pSDETreeColService = (PSDETreeColService)ServiceGlobal.getService(PSDETreeColService.class, (SessionFactory)this.getSessionFactory());
                pSDETreeColService.autoGet(pSDETreeCol);
                this.psdetreecol = pSDETreeCol;
            }
            return this.psdetreecol;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDETreeNode getPSDETreeNode() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETreeNode();
        }
        if (this.getPSDETreeNodeId() == null) {
            return null;
        }
        Integer n = this.objPSDETreeNodeLock;
        synchronized (n) {
            if (this.psdetreenode != null && DataTypeHelper.compare((int)25, (Object)this.getPSDETreeNodeId(), (Object)this.psdetreenode.getPSDETreeNodeId()) != 0L) {
                this.psdetreenode = null;
            }
            if (this.psdetreenode == null) {
                PSDETreeNode pSDETreeNode = new PSDETreeNode();
                pSDETreeNode.setPSDETreeNodeId(this.getPSDETreeNodeId());
                PSDETreeNodeService pSDETreeNodeService = (PSDETreeNodeService)ServiceGlobal.getService(PSDETreeNodeService.class, (SessionFactory)this.getSessionFactory());
                pSDETreeNodeService.autoGet(pSDETreeNode);
                this.psdetreenode = pSDETreeNode;
            }
            return this.psdetreenode;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDETreeView getPSDETreeView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETreeView();
        }
        if (this.getPSDETreeViewId() == null) {
            return null;
        }
        Integer n = this.objPSDETreeViewLock;
        synchronized (n) {
            if (this.psdetreeview != null && DataTypeHelper.compare((int)25, (Object)this.getPSDETreeViewId(), (Object)this.psdetreeview.getPSDETreeViewId()) != 0L) {
                this.psdetreeview = null;
            }
            if (this.psdetreeview == null) {
                PSDETreeView pSDETreeView = new PSDETreeView();
                pSDETreeView.setPSDETreeViewId(this.getPSDETreeViewId());
                PSDETreeViewService pSDETreeViewService = (PSDETreeViewService)ServiceGlobal.getService(PSDETreeViewService.class, (SessionFactory)this.getSessionFactory());
                pSDETreeViewService.autoGet(pSDETreeView);
                this.psdetreeview = pSDETreeView;
            }
            return this.psdetreeview;
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

    private PSDETreeLogicBase getProxyEntity() {
        return this.proxyPSDETreeLogicBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDETreeLogicBase = null;
        if (iDataObject != null && iDataObject instanceof PSDETreeLogicBase) {
            this.proxyPSDETreeLogicBase = (PSDETreeLogicBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDETreeLogicService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
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
        fieldIndexMap.put(FIELD_PSDETREECOLID, 16);
        fieldIndexMap.put(FIELD_PSDETREECOLNAME, 17);
        fieldIndexMap.put(FIELD_PSDETREELOGICID, 18);
        fieldIndexMap.put(FIELD_PSDETREELOGICNAME, 19);
        fieldIndexMap.put(FIELD_PSDETREENODEID, 20);
        fieldIndexMap.put(FIELD_PSDETREENODENAME, 21);
        fieldIndexMap.put(FIELD_PSDETREEVIEWID, 22);
        fieldIndexMap.put(FIELD_PSDETREEVIEWNAME, 23);
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

