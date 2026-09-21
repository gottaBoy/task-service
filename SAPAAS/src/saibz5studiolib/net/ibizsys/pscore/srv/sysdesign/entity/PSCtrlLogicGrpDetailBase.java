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
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlLogicGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewLogic;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanel;
import net.ibizsys.pscore.srv.sysdesign.service.PSCtrlLogicGroupService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewLogicService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSCtrlLogicGrpDetailBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSCtrlLogicGrpDetailBase.class);
    public static final String FIELD_ATTRNAME = "ATTRNAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CTRLNAME = "CTRLNAME";
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
    public static final String FIELD_PSCTRLLOGICGROUPID = "PSCTRLLOGICGROUPID";
    public static final String FIELD_PSCTRLLOGICGROUPNAME = "PSCTRLLOGICGROUPNAME";
    public static final String FIELD_PSCTRLLOGICGRPDETAILID = "PSCTRLLOGICGRPDETAILID";
    public static final String FIELD_PSCTRLLOGICGRPDETAILNAME = "PSCTRLLOGICGRPDETAILNAME";
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
    private static final int INDEX_CTRLNAME = 3;
    private static final int INDEX_CUSTOMCODE = 4;
    private static final int INDEX_DSTLOGICTYPE = 5;
    private static final int INDEX_EVENTARG = 6;
    private static final int INDEX_EVENTARG2 = 7;
    private static final int INDEX_EVENTNAMES = 8;
    private static final int INDEX_ITEMNAME = 9;
    private static final int INDEX_LOGICPARAM = 10;
    private static final int INDEX_LOGICPARAM2 = 11;
    private static final int INDEX_MEMO = 12;
    private static final int INDEX_ORDERVALUE = 13;
    private static final int INDEX_PSCTRLLOGICGROUPID = 14;
    private static final int INDEX_PSCTRLLOGICGROUPNAME = 15;
    private static final int INDEX_PSCTRLLOGICGRPDETAILID = 16;
    private static final int INDEX_PSCTRLLOGICGRPDETAILNAME = 17;
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
    private PSCtrlLogicGrpDetailBase proxyPSCtrlLogicGrpDetailBase = null;
    private boolean attrnameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean ctrlnameDirtyFlag = false;
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
    private boolean psctrllogicgroupidDirtyFlag = false;
    private boolean psctrllogicgroupnameDirtyFlag = false;
    private boolean psctrllogicgrpdetailidDirtyFlag = false;
    private boolean psctrllogicgrpdetailnameDirtyFlag = false;
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
    @Column(name="psctrllogicgroupid")
    private String psctrllogicgroupid;
    @Column(name="psctrllogicgroupname")
    private String psctrllogicgroupname;
    @Column(name="psctrllogicgrpdetailid")
    private String psctrllogicgrpdetailid;
    @Column(name="psctrllogicgrpdetailname")
    private String psctrllogicgrpdetailname;
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
    private Integer objPSCtrlLogicGroupLock = new Integer(1);
    private PSCtrlLogicGroup psctrllogicgroup = null;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
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

    public void setPSCtrlLogicGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlLogicGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrllogicgroupid = string;
        this.psctrllogicgroupidDirtyFlag = true;
    }

    public String getPSCtrlLogicGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlLogicGroupId();
        }
        return this.psctrllogicgroupid;
    }

    public boolean isPSCtrlLogicGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlLogicGroupIdDirty();
        }
        return this.psctrllogicgroupidDirtyFlag;
    }

    public void resetPSCtrlLogicGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlLogicGroupId();
            return;
        }
        this.psctrllogicgroupidDirtyFlag = false;
        this.psctrllogicgroupid = null;
    }

    public void setPSCtrlLogicGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlLogicGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrllogicgroupname = string;
        this.psctrllogicgroupnameDirtyFlag = true;
    }

    public String getPSCtrlLogicGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlLogicGroupName();
        }
        return this.psctrllogicgroupname;
    }

    public boolean isPSCtrlLogicGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlLogicGroupNameDirty();
        }
        return this.psctrllogicgroupnameDirtyFlag;
    }

    public void resetPSCtrlLogicGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlLogicGroupName();
            return;
        }
        this.psctrllogicgroupnameDirtyFlag = false;
        this.psctrllogicgroupname = null;
    }

    public void setPSCtrlLogicGrpDetailId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlLogicGrpDetailId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrllogicgrpdetailid = string;
        this.psctrllogicgrpdetailidDirtyFlag = true;
    }

    public String getPSCtrlLogicGrpDetailId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlLogicGrpDetailId();
        }
        return this.psctrllogicgrpdetailid;
    }

    public boolean isPSCtrlLogicGrpDetailIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlLogicGrpDetailIdDirty();
        }
        return this.psctrllogicgrpdetailidDirtyFlag;
    }

    public void resetPSCtrlLogicGrpDetailId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlLogicGrpDetailId();
            return;
        }
        this.psctrllogicgrpdetailidDirtyFlag = false;
        this.psctrllogicgrpdetailid = null;
    }

    public void setPSCtrlLogicGrpDetailName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlLogicGrpDetailName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrllogicgrpdetailname = string;
        this.psctrllogicgrpdetailnameDirtyFlag = true;
    }

    public String getPSCtrlLogicGrpDetailName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlLogicGrpDetailName();
        }
        return this.psctrllogicgrpdetailname;
    }

    public boolean isPSCtrlLogicGrpDetailNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlLogicGrpDetailNameDirty();
        }
        return this.psctrllogicgrpdetailnameDirtyFlag;
    }

    public void resetPSCtrlLogicGrpDetailName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlLogicGrpDetailName();
            return;
        }
        this.psctrllogicgrpdetailnameDirtyFlag = false;
        this.psctrllogicgrpdetailname = null;
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
        PSCtrlLogicGrpDetailBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSCtrlLogicGrpDetailBase pSCtrlLogicGrpDetailBase) {
        pSCtrlLogicGrpDetailBase.resetAttrName();
        pSCtrlLogicGrpDetailBase.resetCreateDate();
        pSCtrlLogicGrpDetailBase.resetCreateMan();
        pSCtrlLogicGrpDetailBase.resetCtrlName();
        pSCtrlLogicGrpDetailBase.resetCustomCode();
        pSCtrlLogicGrpDetailBase.resetDstLogicType();
        pSCtrlLogicGrpDetailBase.resetEventArg();
        pSCtrlLogicGrpDetailBase.resetEventArg2();
        pSCtrlLogicGrpDetailBase.resetEventNames();
        pSCtrlLogicGrpDetailBase.resetItemName();
        pSCtrlLogicGrpDetailBase.resetLogicParam();
        pSCtrlLogicGrpDetailBase.resetLogicParam2();
        pSCtrlLogicGrpDetailBase.resetMemo();
        pSCtrlLogicGrpDetailBase.resetOrderValue();
        pSCtrlLogicGrpDetailBase.resetPSCtrlLogicGroupId();
        pSCtrlLogicGrpDetailBase.resetPSCtrlLogicGroupName();
        pSCtrlLogicGrpDetailBase.resetPSCtrlLogicGrpDetailId();
        pSCtrlLogicGrpDetailBase.resetPSCtrlLogicGrpDetailName();
        pSCtrlLogicGrpDetailBase.resetPSDEId();
        pSCtrlLogicGrpDetailBase.resetPSDELogicId();
        pSCtrlLogicGrpDetailBase.resetPSDELogicName();
        pSCtrlLogicGrpDetailBase.resetPSDEName();
        pSCtrlLogicGrpDetailBase.resetPSDEUIActionId();
        pSCtrlLogicGrpDetailBase.resetPSDEUIActionName();
        pSCtrlLogicGrpDetailBase.resetPSSysPFPluginId();
        pSCtrlLogicGrpDetailBase.resetPSSysPFPluginName();
        pSCtrlLogicGrpDetailBase.resetPSSysViewLogicId();
        pSCtrlLogicGrpDetailBase.resetPSSysViewLogicName();
        pSCtrlLogicGrpDetailBase.resetPSSysViewPanelId();
        pSCtrlLogicGrpDetailBase.resetPSSysViewPanelName();
        pSCtrlLogicGrpDetailBase.resetTimer();
        pSCtrlLogicGrpDetailBase.resetTriggerType();
        pSCtrlLogicGrpDetailBase.resetUpdateDate();
        pSCtrlLogicGrpDetailBase.resetUpdateMan();
        pSCtrlLogicGrpDetailBase.resetUserCat();
        pSCtrlLogicGrpDetailBase.resetUserTag();
        pSCtrlLogicGrpDetailBase.resetUserTag2();
        pSCtrlLogicGrpDetailBase.resetUserTag3();
        pSCtrlLogicGrpDetailBase.resetUserTag4();
        pSCtrlLogicGrpDetailBase.resetValidFlag();
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
        if (!bl || this.isPSCtrlLogicGroupIdDirty()) {
            hashMap.put(FIELD_PSCTRLLOGICGROUPID, this.getPSCtrlLogicGroupId());
        }
        if (!bl || this.isPSCtrlLogicGroupNameDirty()) {
            hashMap.put(FIELD_PSCTRLLOGICGROUPNAME, this.getPSCtrlLogicGroupName());
        }
        if (!bl || this.isPSCtrlLogicGrpDetailIdDirty()) {
            hashMap.put(FIELD_PSCTRLLOGICGRPDETAILID, this.getPSCtrlLogicGrpDetailId());
        }
        if (!bl || this.isPSCtrlLogicGrpDetailNameDirty()) {
            hashMap.put(FIELD_PSCTRLLOGICGRPDETAILNAME, this.getPSCtrlLogicGrpDetailName());
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
        return PSCtrlLogicGrpDetailBase.get(this, n);
    }

    private static Object get(PSCtrlLogicGrpDetailBase pSCtrlLogicGrpDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCtrlLogicGrpDetailBase.getAttrName();
            }
            case 1: {
                return pSCtrlLogicGrpDetailBase.getCreateDate();
            }
            case 2: {
                return pSCtrlLogicGrpDetailBase.getCreateMan();
            }
            case 3: {
                return pSCtrlLogicGrpDetailBase.getCtrlName();
            }
            case 4: {
                return pSCtrlLogicGrpDetailBase.getCustomCode();
            }
            case 5: {
                return pSCtrlLogicGrpDetailBase.getDstLogicType();
            }
            case 6: {
                return pSCtrlLogicGrpDetailBase.getEventArg();
            }
            case 7: {
                return pSCtrlLogicGrpDetailBase.getEventArg2();
            }
            case 8: {
                return pSCtrlLogicGrpDetailBase.getEventNames();
            }
            case 9: {
                return pSCtrlLogicGrpDetailBase.getItemName();
            }
            case 10: {
                return pSCtrlLogicGrpDetailBase.getLogicParam();
            }
            case 11: {
                return pSCtrlLogicGrpDetailBase.getLogicParam2();
            }
            case 12: {
                return pSCtrlLogicGrpDetailBase.getMemo();
            }
            case 13: {
                return pSCtrlLogicGrpDetailBase.getOrderValue();
            }
            case 14: {
                return pSCtrlLogicGrpDetailBase.getPSCtrlLogicGroupId();
            }
            case 15: {
                return pSCtrlLogicGrpDetailBase.getPSCtrlLogicGroupName();
            }
            case 16: {
                return pSCtrlLogicGrpDetailBase.getPSCtrlLogicGrpDetailId();
            }
            case 17: {
                return pSCtrlLogicGrpDetailBase.getPSCtrlLogicGrpDetailName();
            }
            case 18: {
                return pSCtrlLogicGrpDetailBase.getPSDEId();
            }
            case 19: {
                return pSCtrlLogicGrpDetailBase.getPSDELogicId();
            }
            case 20: {
                return pSCtrlLogicGrpDetailBase.getPSDELogicName();
            }
            case 21: {
                return pSCtrlLogicGrpDetailBase.getPSDEName();
            }
            case 22: {
                return pSCtrlLogicGrpDetailBase.getPSDEUIActionId();
            }
            case 23: {
                return pSCtrlLogicGrpDetailBase.getPSDEUIActionName();
            }
            case 24: {
                return pSCtrlLogicGrpDetailBase.getPSSysPFPluginId();
            }
            case 25: {
                return pSCtrlLogicGrpDetailBase.getPSSysPFPluginName();
            }
            case 26: {
                return pSCtrlLogicGrpDetailBase.getPSSysViewLogicId();
            }
            case 27: {
                return pSCtrlLogicGrpDetailBase.getPSSysViewLogicName();
            }
            case 28: {
                return pSCtrlLogicGrpDetailBase.getPSSysViewPanelId();
            }
            case 29: {
                return pSCtrlLogicGrpDetailBase.getPSSysViewPanelName();
            }
            case 30: {
                return pSCtrlLogicGrpDetailBase.getTimer();
            }
            case 31: {
                return pSCtrlLogicGrpDetailBase.getTriggerType();
            }
            case 32: {
                return pSCtrlLogicGrpDetailBase.getUpdateDate();
            }
            case 33: {
                return pSCtrlLogicGrpDetailBase.getUpdateMan();
            }
            case 34: {
                return pSCtrlLogicGrpDetailBase.getUserCat();
            }
            case 35: {
                return pSCtrlLogicGrpDetailBase.getUserTag();
            }
            case 36: {
                return pSCtrlLogicGrpDetailBase.getUserTag2();
            }
            case 37: {
                return pSCtrlLogicGrpDetailBase.getUserTag3();
            }
            case 38: {
                return pSCtrlLogicGrpDetailBase.getUserTag4();
            }
            case 39: {
                return pSCtrlLogicGrpDetailBase.getValidFlag();
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
        PSCtrlLogicGrpDetailBase.set(this, n, object);
    }

    private static void set(PSCtrlLogicGrpDetailBase pSCtrlLogicGrpDetailBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSCtrlLogicGrpDetailBase.setAttrName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSCtrlLogicGrpDetailBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSCtrlLogicGrpDetailBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSCtrlLogicGrpDetailBase.setCtrlName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSCtrlLogicGrpDetailBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSCtrlLogicGrpDetailBase.setDstLogicType(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSCtrlLogicGrpDetailBase.setEventArg(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSCtrlLogicGrpDetailBase.setEventArg2(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSCtrlLogicGrpDetailBase.setEventNames(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSCtrlLogicGrpDetailBase.setItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSCtrlLogicGrpDetailBase.setLogicParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSCtrlLogicGrpDetailBase.setLogicParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSCtrlLogicGrpDetailBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSCtrlLogicGrpDetailBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSCtrlLogicGrpDetailBase.setPSCtrlLogicGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSCtrlLogicGrpDetailBase.setPSCtrlLogicGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSCtrlLogicGrpDetailBase.setPSCtrlLogicGrpDetailId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSCtrlLogicGrpDetailBase.setPSCtrlLogicGrpDetailName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSCtrlLogicGrpDetailBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSCtrlLogicGrpDetailBase.setPSDELogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSCtrlLogicGrpDetailBase.setPSDELogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSCtrlLogicGrpDetailBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSCtrlLogicGrpDetailBase.setPSDEUIActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSCtrlLogicGrpDetailBase.setPSDEUIActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSCtrlLogicGrpDetailBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSCtrlLogicGrpDetailBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSCtrlLogicGrpDetailBase.setPSSysViewLogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSCtrlLogicGrpDetailBase.setPSSysViewLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSCtrlLogicGrpDetailBase.setPSSysViewPanelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSCtrlLogicGrpDetailBase.setPSSysViewPanelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSCtrlLogicGrpDetailBase.setTimer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 31: {
                pSCtrlLogicGrpDetailBase.setTriggerType(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSCtrlLogicGrpDetailBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 33: {
                pSCtrlLogicGrpDetailBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSCtrlLogicGrpDetailBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSCtrlLogicGrpDetailBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSCtrlLogicGrpDetailBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSCtrlLogicGrpDetailBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSCtrlLogicGrpDetailBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSCtrlLogicGrpDetailBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSCtrlLogicGrpDetailBase.isNull(this, n);
    }

    private static boolean isNull(PSCtrlLogicGrpDetailBase pSCtrlLogicGrpDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCtrlLogicGrpDetailBase.getAttrName() == null;
            }
            case 1: {
                return pSCtrlLogicGrpDetailBase.getCreateDate() == null;
            }
            case 2: {
                return pSCtrlLogicGrpDetailBase.getCreateMan() == null;
            }
            case 3: {
                return pSCtrlLogicGrpDetailBase.getCtrlName() == null;
            }
            case 4: {
                return pSCtrlLogicGrpDetailBase.getCustomCode() == null;
            }
            case 5: {
                return pSCtrlLogicGrpDetailBase.getDstLogicType() == null;
            }
            case 6: {
                return pSCtrlLogicGrpDetailBase.getEventArg() == null;
            }
            case 7: {
                return pSCtrlLogicGrpDetailBase.getEventArg2() == null;
            }
            case 8: {
                return pSCtrlLogicGrpDetailBase.getEventNames() == null;
            }
            case 9: {
                return pSCtrlLogicGrpDetailBase.getItemName() == null;
            }
            case 10: {
                return pSCtrlLogicGrpDetailBase.getLogicParam() == null;
            }
            case 11: {
                return pSCtrlLogicGrpDetailBase.getLogicParam2() == null;
            }
            case 12: {
                return pSCtrlLogicGrpDetailBase.getMemo() == null;
            }
            case 13: {
                return pSCtrlLogicGrpDetailBase.getOrderValue() == null;
            }
            case 14: {
                return pSCtrlLogicGrpDetailBase.getPSCtrlLogicGroupId() == null;
            }
            case 15: {
                return pSCtrlLogicGrpDetailBase.getPSCtrlLogicGroupName() == null;
            }
            case 16: {
                return pSCtrlLogicGrpDetailBase.getPSCtrlLogicGrpDetailId() == null;
            }
            case 17: {
                return pSCtrlLogicGrpDetailBase.getPSCtrlLogicGrpDetailName() == null;
            }
            case 18: {
                return pSCtrlLogicGrpDetailBase.getPSDEId() == null;
            }
            case 19: {
                return pSCtrlLogicGrpDetailBase.getPSDELogicId() == null;
            }
            case 20: {
                return pSCtrlLogicGrpDetailBase.getPSDELogicName() == null;
            }
            case 21: {
                return pSCtrlLogicGrpDetailBase.getPSDEName() == null;
            }
            case 22: {
                return pSCtrlLogicGrpDetailBase.getPSDEUIActionId() == null;
            }
            case 23: {
                return pSCtrlLogicGrpDetailBase.getPSDEUIActionName() == null;
            }
            case 24: {
                return pSCtrlLogicGrpDetailBase.getPSSysPFPluginId() == null;
            }
            case 25: {
                return pSCtrlLogicGrpDetailBase.getPSSysPFPluginName() == null;
            }
            case 26: {
                return pSCtrlLogicGrpDetailBase.getPSSysViewLogicId() == null;
            }
            case 27: {
                return pSCtrlLogicGrpDetailBase.getPSSysViewLogicName() == null;
            }
            case 28: {
                return pSCtrlLogicGrpDetailBase.getPSSysViewPanelId() == null;
            }
            case 29: {
                return pSCtrlLogicGrpDetailBase.getPSSysViewPanelName() == null;
            }
            case 30: {
                return pSCtrlLogicGrpDetailBase.getTimer() == null;
            }
            case 31: {
                return pSCtrlLogicGrpDetailBase.getTriggerType() == null;
            }
            case 32: {
                return pSCtrlLogicGrpDetailBase.getUpdateDate() == null;
            }
            case 33: {
                return pSCtrlLogicGrpDetailBase.getUpdateMan() == null;
            }
            case 34: {
                return pSCtrlLogicGrpDetailBase.getUserCat() == null;
            }
            case 35: {
                return pSCtrlLogicGrpDetailBase.getUserTag() == null;
            }
            case 36: {
                return pSCtrlLogicGrpDetailBase.getUserTag2() == null;
            }
            case 37: {
                return pSCtrlLogicGrpDetailBase.getUserTag3() == null;
            }
            case 38: {
                return pSCtrlLogicGrpDetailBase.getUserTag4() == null;
            }
            case 39: {
                return pSCtrlLogicGrpDetailBase.getValidFlag() == null;
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
        return PSCtrlLogicGrpDetailBase.contains(this, n);
    }

    private static boolean contains(PSCtrlLogicGrpDetailBase pSCtrlLogicGrpDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCtrlLogicGrpDetailBase.isAttrNameDirty();
            }
            case 1: {
                return pSCtrlLogicGrpDetailBase.isCreateDateDirty();
            }
            case 2: {
                return pSCtrlLogicGrpDetailBase.isCreateManDirty();
            }
            case 3: {
                return pSCtrlLogicGrpDetailBase.isCtrlNameDirty();
            }
            case 4: {
                return pSCtrlLogicGrpDetailBase.isCustomCodeDirty();
            }
            case 5: {
                return pSCtrlLogicGrpDetailBase.isDstLogicTypeDirty();
            }
            case 6: {
                return pSCtrlLogicGrpDetailBase.isEventArgDirty();
            }
            case 7: {
                return pSCtrlLogicGrpDetailBase.isEventArg2Dirty();
            }
            case 8: {
                return pSCtrlLogicGrpDetailBase.isEventNamesDirty();
            }
            case 9: {
                return pSCtrlLogicGrpDetailBase.isItemNameDirty();
            }
            case 10: {
                return pSCtrlLogicGrpDetailBase.isLogicParamDirty();
            }
            case 11: {
                return pSCtrlLogicGrpDetailBase.isLogicParam2Dirty();
            }
            case 12: {
                return pSCtrlLogicGrpDetailBase.isMemoDirty();
            }
            case 13: {
                return pSCtrlLogicGrpDetailBase.isOrderValueDirty();
            }
            case 14: {
                return pSCtrlLogicGrpDetailBase.isPSCtrlLogicGroupIdDirty();
            }
            case 15: {
                return pSCtrlLogicGrpDetailBase.isPSCtrlLogicGroupNameDirty();
            }
            case 16: {
                return pSCtrlLogicGrpDetailBase.isPSCtrlLogicGrpDetailIdDirty();
            }
            case 17: {
                return pSCtrlLogicGrpDetailBase.isPSCtrlLogicGrpDetailNameDirty();
            }
            case 18: {
                return pSCtrlLogicGrpDetailBase.isPSDEIdDirty();
            }
            case 19: {
                return pSCtrlLogicGrpDetailBase.isPSDELogicIdDirty();
            }
            case 20: {
                return pSCtrlLogicGrpDetailBase.isPSDELogicNameDirty();
            }
            case 21: {
                return pSCtrlLogicGrpDetailBase.isPSDENameDirty();
            }
            case 22: {
                return pSCtrlLogicGrpDetailBase.isPSDEUIActionIdDirty();
            }
            case 23: {
                return pSCtrlLogicGrpDetailBase.isPSDEUIActionNameDirty();
            }
            case 24: {
                return pSCtrlLogicGrpDetailBase.isPSSysPFPluginIdDirty();
            }
            case 25: {
                return pSCtrlLogicGrpDetailBase.isPSSysPFPluginNameDirty();
            }
            case 26: {
                return pSCtrlLogicGrpDetailBase.isPSSysViewLogicIdDirty();
            }
            case 27: {
                return pSCtrlLogicGrpDetailBase.isPSSysViewLogicNameDirty();
            }
            case 28: {
                return pSCtrlLogicGrpDetailBase.isPSSysViewPanelIdDirty();
            }
            case 29: {
                return pSCtrlLogicGrpDetailBase.isPSSysViewPanelNameDirty();
            }
            case 30: {
                return pSCtrlLogicGrpDetailBase.isTimerDirty();
            }
            case 31: {
                return pSCtrlLogicGrpDetailBase.isTriggerTypeDirty();
            }
            case 32: {
                return pSCtrlLogicGrpDetailBase.isUpdateDateDirty();
            }
            case 33: {
                return pSCtrlLogicGrpDetailBase.isUpdateManDirty();
            }
            case 34: {
                return pSCtrlLogicGrpDetailBase.isUserCatDirty();
            }
            case 35: {
                return pSCtrlLogicGrpDetailBase.isUserTagDirty();
            }
            case 36: {
                return pSCtrlLogicGrpDetailBase.isUserTag2Dirty();
            }
            case 37: {
                return pSCtrlLogicGrpDetailBase.isUserTag3Dirty();
            }
            case 38: {
                return pSCtrlLogicGrpDetailBase.isUserTag4Dirty();
            }
            case 39: {
                return pSCtrlLogicGrpDetailBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSCtrlLogicGrpDetailBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSCtrlLogicGrpDetailBase pSCtrlLogicGrpDetailBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSCtrlLogicGrpDetailBase.getAttrName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"attrname", (Object)PSCtrlLogicGrpDetailBase.getJSONValue((Object)pSCtrlLogicGrpDetailBase.getAttrName()), (boolean)false);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSCtrlLogicGrpDetailBase.getJSONValue((Object)pSCtrlLogicGrpDetailBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSCtrlLogicGrpDetailBase.getJSONValue((Object)pSCtrlLogicGrpDetailBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getCtrlName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlname", (Object)PSCtrlLogicGrpDetailBase.getJSONValue((Object)pSCtrlLogicGrpDetailBase.getCtrlName()), (boolean)false);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSCtrlLogicGrpDetailBase.getJSONValue((Object)pSCtrlLogicGrpDetailBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getDstLogicType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstlogictype", (Object)PSCtrlLogicGrpDetailBase.getJSONValue((Object)pSCtrlLogicGrpDetailBase.getDstLogicType()), (boolean)false);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getEventArg() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eventarg", (Object)PSCtrlLogicGrpDetailBase.getJSONValue((Object)pSCtrlLogicGrpDetailBase.getEventArg()), (boolean)false);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getEventArg2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eventarg2", (Object)PSCtrlLogicGrpDetailBase.getJSONValue((Object)pSCtrlLogicGrpDetailBase.getEventArg2()), (boolean)false);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getEventNames() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eventnames", (Object)PSCtrlLogicGrpDetailBase.getJSONValue((Object)pSCtrlLogicGrpDetailBase.getEventNames()), (boolean)false);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemname", (Object)PSCtrlLogicGrpDetailBase.getJSONValue((Object)pSCtrlLogicGrpDetailBase.getItemName()), (boolean)false);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getLogicParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicparam", (Object)PSCtrlLogicGrpDetailBase.getJSONValue((Object)pSCtrlLogicGrpDetailBase.getLogicParam()), (boolean)false);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getLogicParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicparam2", (Object)PSCtrlLogicGrpDetailBase.getJSONValue((Object)pSCtrlLogicGrpDetailBase.getLogicParam2()), (boolean)false);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSCtrlLogicGrpDetailBase.getJSONValue((Object)pSCtrlLogicGrpDetailBase.getMemo()), (boolean)false);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSCtrlLogicGrpDetailBase.getJSONValue((Object)pSCtrlLogicGrpDetailBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getPSCtrlLogicGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrllogicgroupid", (Object)PSCtrlLogicGrpDetailBase.getJSONValue((Object)pSCtrlLogicGrpDetailBase.getPSCtrlLogicGroupId()), (boolean)false);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getPSCtrlLogicGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrllogicgroupname", (Object)PSCtrlLogicGrpDetailBase.getJSONValue((Object)pSCtrlLogicGrpDetailBase.getPSCtrlLogicGroupName()), (boolean)false);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getPSCtrlLogicGrpDetailId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrllogicgrpdetailid", (Object)PSCtrlLogicGrpDetailBase.getJSONValue((Object)pSCtrlLogicGrpDetailBase.getPSCtrlLogicGrpDetailId()), (boolean)false);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getPSCtrlLogicGrpDetailName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrllogicgrpdetailname", (Object)PSCtrlLogicGrpDetailBase.getJSONValue((Object)pSCtrlLogicGrpDetailBase.getPSCtrlLogicGrpDetailName()), (boolean)false);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSCtrlLogicGrpDetailBase.getJSONValue((Object)pSCtrlLogicGrpDetailBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getPSDELogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicid", (Object)PSCtrlLogicGrpDetailBase.getJSONValue((Object)pSCtrlLogicGrpDetailBase.getPSDELogicId()), (boolean)false);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getPSDELogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicname", (Object)PSCtrlLogicGrpDetailBase.getJSONValue((Object)pSCtrlLogicGrpDetailBase.getPSDELogicName()), (boolean)false);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSCtrlLogicGrpDetailBase.getJSONValue((Object)pSCtrlLogicGrpDetailBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getPSDEUIActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuiactionid", (Object)PSCtrlLogicGrpDetailBase.getJSONValue((Object)pSCtrlLogicGrpDetailBase.getPSDEUIActionId()), (boolean)false);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getPSDEUIActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuiactionname", (Object)PSCtrlLogicGrpDetailBase.getJSONValue((Object)pSCtrlLogicGrpDetailBase.getPSDEUIActionName()), (boolean)false);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSCtrlLogicGrpDetailBase.getJSONValue((Object)pSCtrlLogicGrpDetailBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSCtrlLogicGrpDetailBase.getJSONValue((Object)pSCtrlLogicGrpDetailBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getPSSysViewLogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewlogicid", (Object)PSCtrlLogicGrpDetailBase.getJSONValue((Object)pSCtrlLogicGrpDetailBase.getPSSysViewLogicId()), (boolean)false);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getPSSysViewLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewlogicname", (Object)PSCtrlLogicGrpDetailBase.getJSONValue((Object)pSCtrlLogicGrpDetailBase.getPSSysViewLogicName()), (boolean)false);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getPSSysViewPanelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelid", (Object)PSCtrlLogicGrpDetailBase.getJSONValue((Object)pSCtrlLogicGrpDetailBase.getPSSysViewPanelId()), (boolean)false);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getPSSysViewPanelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelname", (Object)PSCtrlLogicGrpDetailBase.getJSONValue((Object)pSCtrlLogicGrpDetailBase.getPSSysViewPanelName()), (boolean)false);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getTimer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"timer", (Object)PSCtrlLogicGrpDetailBase.getJSONValue((Object)pSCtrlLogicGrpDetailBase.getTimer()), (boolean)false);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getTriggerType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"triggertype", (Object)PSCtrlLogicGrpDetailBase.getJSONValue((Object)pSCtrlLogicGrpDetailBase.getTriggerType()), (boolean)false);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSCtrlLogicGrpDetailBase.getJSONValue((Object)pSCtrlLogicGrpDetailBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSCtrlLogicGrpDetailBase.getJSONValue((Object)pSCtrlLogicGrpDetailBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSCtrlLogicGrpDetailBase.getJSONValue((Object)pSCtrlLogicGrpDetailBase.getUserCat()), (boolean)false);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSCtrlLogicGrpDetailBase.getJSONValue((Object)pSCtrlLogicGrpDetailBase.getUserTag()), (boolean)false);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSCtrlLogicGrpDetailBase.getJSONValue((Object)pSCtrlLogicGrpDetailBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSCtrlLogicGrpDetailBase.getJSONValue((Object)pSCtrlLogicGrpDetailBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSCtrlLogicGrpDetailBase.getJSONValue((Object)pSCtrlLogicGrpDetailBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSCtrlLogicGrpDetailBase.getJSONValue((Object)pSCtrlLogicGrpDetailBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSCtrlLogicGrpDetailBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSCtrlLogicGrpDetailBase pSCtrlLogicGrpDetailBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSCtrlLogicGrpDetailBase.getAttrName() != null) {
            object = pSCtrlLogicGrpDetailBase.getAttrName();
            xmlNode.setAttribute(FIELD_ATTRNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getCreateDate() != null) {
            object = pSCtrlLogicGrpDetailBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCtrlLogicGrpDetailBase.getCreateMan() != null) {
            object = pSCtrlLogicGrpDetailBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getCtrlName() != null) {
            object = pSCtrlLogicGrpDetailBase.getCtrlName();
            xmlNode.setAttribute(FIELD_CTRLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getCustomCode() != null) {
            object = pSCtrlLogicGrpDetailBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getDstLogicType() != null) {
            object = pSCtrlLogicGrpDetailBase.getDstLogicType();
            xmlNode.setAttribute(FIELD_DSTLOGICTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getEventArg() != null) {
            object = pSCtrlLogicGrpDetailBase.getEventArg();
            xmlNode.setAttribute(FIELD_EVENTARG, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getEventArg2() != null) {
            object = pSCtrlLogicGrpDetailBase.getEventArg2();
            xmlNode.setAttribute(FIELD_EVENTARG2, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getEventNames() != null) {
            object = pSCtrlLogicGrpDetailBase.getEventNames();
            xmlNode.setAttribute(FIELD_EVENTNAMES, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getItemName() != null) {
            object = pSCtrlLogicGrpDetailBase.getItemName();
            xmlNode.setAttribute(FIELD_ITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getLogicParam() != null) {
            object = pSCtrlLogicGrpDetailBase.getLogicParam();
            xmlNode.setAttribute(FIELD_LOGICPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getLogicParam2() != null) {
            object = pSCtrlLogicGrpDetailBase.getLogicParam2();
            xmlNode.setAttribute(FIELD_LOGICPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getMemo() != null) {
            object = pSCtrlLogicGrpDetailBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getOrderValue() != null) {
            object = pSCtrlLogicGrpDetailBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSCtrlLogicGrpDetailBase.getPSCtrlLogicGroupId() != null) {
            object = pSCtrlLogicGrpDetailBase.getPSCtrlLogicGroupId();
            xmlNode.setAttribute(FIELD_PSCTRLLOGICGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getPSCtrlLogicGroupName() != null) {
            object = pSCtrlLogicGrpDetailBase.getPSCtrlLogicGroupName();
            xmlNode.setAttribute(FIELD_PSCTRLLOGICGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getPSCtrlLogicGrpDetailId() != null) {
            object = pSCtrlLogicGrpDetailBase.getPSCtrlLogicGrpDetailId();
            xmlNode.setAttribute(FIELD_PSCTRLLOGICGRPDETAILID, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getPSCtrlLogicGrpDetailName() != null) {
            object = pSCtrlLogicGrpDetailBase.getPSCtrlLogicGrpDetailName();
            xmlNode.setAttribute(FIELD_PSCTRLLOGICGRPDETAILNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getPSDEId() != null) {
            object = pSCtrlLogicGrpDetailBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getPSDELogicId() != null) {
            object = pSCtrlLogicGrpDetailBase.getPSDELogicId();
            xmlNode.setAttribute(FIELD_PSDELOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getPSDELogicName() != null) {
            object = pSCtrlLogicGrpDetailBase.getPSDELogicName();
            xmlNode.setAttribute(FIELD_PSDELOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getPSDEName() != null) {
            object = pSCtrlLogicGrpDetailBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getPSDEUIActionId() != null) {
            object = pSCtrlLogicGrpDetailBase.getPSDEUIActionId();
            xmlNode.setAttribute(FIELD_PSDEUIACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getPSDEUIActionName() != null) {
            object = pSCtrlLogicGrpDetailBase.getPSDEUIActionName();
            xmlNode.setAttribute(FIELD_PSDEUIACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getPSSysPFPluginId() != null) {
            object = pSCtrlLogicGrpDetailBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getPSSysPFPluginName() != null) {
            object = pSCtrlLogicGrpDetailBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getPSSysViewLogicId() != null) {
            object = pSCtrlLogicGrpDetailBase.getPSSysViewLogicId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWLOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getPSSysViewLogicName() != null) {
            object = pSCtrlLogicGrpDetailBase.getPSSysViewLogicName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWLOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getPSSysViewPanelId() != null) {
            object = pSCtrlLogicGrpDetailBase.getPSSysViewPanelId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELID, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getPSSysViewPanelName() != null) {
            object = pSCtrlLogicGrpDetailBase.getPSSysViewPanelName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getTimer() != null) {
            object = pSCtrlLogicGrpDetailBase.getTimer();
            xmlNode.setAttribute(FIELD_TIMER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSCtrlLogicGrpDetailBase.getTriggerType() != null) {
            object = pSCtrlLogicGrpDetailBase.getTriggerType();
            xmlNode.setAttribute(FIELD_TRIGGERTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getUpdateDate() != null) {
            object = pSCtrlLogicGrpDetailBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCtrlLogicGrpDetailBase.getUpdateMan() != null) {
            object = pSCtrlLogicGrpDetailBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getUserCat() != null) {
            object = pSCtrlLogicGrpDetailBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getUserTag() != null) {
            object = pSCtrlLogicGrpDetailBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getUserTag2() != null) {
            object = pSCtrlLogicGrpDetailBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getUserTag3() != null) {
            object = pSCtrlLogicGrpDetailBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getUserTag4() != null) {
            object = pSCtrlLogicGrpDetailBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlLogicGrpDetailBase.getValidFlag() != null) {
            object = pSCtrlLogicGrpDetailBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSCtrlLogicGrpDetailBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSCtrlLogicGrpDetailBase pSCtrlLogicGrpDetailBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSCtrlLogicGrpDetailBase.isAttrNameDirty() && (bl || pSCtrlLogicGrpDetailBase.getAttrName() != null)) {
            iDataObject.set(FIELD_ATTRNAME, (Object)pSCtrlLogicGrpDetailBase.getAttrName());
        }
        if (pSCtrlLogicGrpDetailBase.isCreateDateDirty() && (bl || pSCtrlLogicGrpDetailBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSCtrlLogicGrpDetailBase.getCreateDate());
        }
        if (pSCtrlLogicGrpDetailBase.isCreateManDirty() && (bl || pSCtrlLogicGrpDetailBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSCtrlLogicGrpDetailBase.getCreateMan());
        }
        if (pSCtrlLogicGrpDetailBase.isCtrlNameDirty() && (bl || pSCtrlLogicGrpDetailBase.getCtrlName() != null)) {
            iDataObject.set(FIELD_CTRLNAME, (Object)pSCtrlLogicGrpDetailBase.getCtrlName());
        }
        if (pSCtrlLogicGrpDetailBase.isCustomCodeDirty() && (bl || pSCtrlLogicGrpDetailBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSCtrlLogicGrpDetailBase.getCustomCode());
        }
        if (pSCtrlLogicGrpDetailBase.isDstLogicTypeDirty() && (bl || pSCtrlLogicGrpDetailBase.getDstLogicType() != null)) {
            iDataObject.set(FIELD_DSTLOGICTYPE, (Object)pSCtrlLogicGrpDetailBase.getDstLogicType());
        }
        if (pSCtrlLogicGrpDetailBase.isEventArgDirty() && (bl || pSCtrlLogicGrpDetailBase.getEventArg() != null)) {
            iDataObject.set(FIELD_EVENTARG, (Object)pSCtrlLogicGrpDetailBase.getEventArg());
        }
        if (pSCtrlLogicGrpDetailBase.isEventArg2Dirty() && (bl || pSCtrlLogicGrpDetailBase.getEventArg2() != null)) {
            iDataObject.set(FIELD_EVENTARG2, (Object)pSCtrlLogicGrpDetailBase.getEventArg2());
        }
        if (pSCtrlLogicGrpDetailBase.isEventNamesDirty() && (bl || pSCtrlLogicGrpDetailBase.getEventNames() != null)) {
            iDataObject.set(FIELD_EVENTNAMES, (Object)pSCtrlLogicGrpDetailBase.getEventNames());
        }
        if (pSCtrlLogicGrpDetailBase.isItemNameDirty() && (bl || pSCtrlLogicGrpDetailBase.getItemName() != null)) {
            iDataObject.set(FIELD_ITEMNAME, (Object)pSCtrlLogicGrpDetailBase.getItemName());
        }
        if (pSCtrlLogicGrpDetailBase.isLogicParamDirty() && (bl || pSCtrlLogicGrpDetailBase.getLogicParam() != null)) {
            iDataObject.set(FIELD_LOGICPARAM, (Object)pSCtrlLogicGrpDetailBase.getLogicParam());
        }
        if (pSCtrlLogicGrpDetailBase.isLogicParam2Dirty() && (bl || pSCtrlLogicGrpDetailBase.getLogicParam2() != null)) {
            iDataObject.set(FIELD_LOGICPARAM2, (Object)pSCtrlLogicGrpDetailBase.getLogicParam2());
        }
        if (pSCtrlLogicGrpDetailBase.isMemoDirty() && (bl || pSCtrlLogicGrpDetailBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSCtrlLogicGrpDetailBase.getMemo());
        }
        if (pSCtrlLogicGrpDetailBase.isOrderValueDirty() && (bl || pSCtrlLogicGrpDetailBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSCtrlLogicGrpDetailBase.getOrderValue());
        }
        if (pSCtrlLogicGrpDetailBase.isPSCtrlLogicGroupIdDirty() && (bl || pSCtrlLogicGrpDetailBase.getPSCtrlLogicGroupId() != null)) {
            iDataObject.set(FIELD_PSCTRLLOGICGROUPID, (Object)pSCtrlLogicGrpDetailBase.getPSCtrlLogicGroupId());
        }
        if (pSCtrlLogicGrpDetailBase.isPSCtrlLogicGroupNameDirty() && (bl || pSCtrlLogicGrpDetailBase.getPSCtrlLogicGroupName() != null)) {
            iDataObject.set(FIELD_PSCTRLLOGICGROUPNAME, (Object)pSCtrlLogicGrpDetailBase.getPSCtrlLogicGroupName());
        }
        if (pSCtrlLogicGrpDetailBase.isPSCtrlLogicGrpDetailIdDirty() && (bl || pSCtrlLogicGrpDetailBase.getPSCtrlLogicGrpDetailId() != null)) {
            iDataObject.set(FIELD_PSCTRLLOGICGRPDETAILID, (Object)pSCtrlLogicGrpDetailBase.getPSCtrlLogicGrpDetailId());
        }
        if (pSCtrlLogicGrpDetailBase.isPSCtrlLogicGrpDetailNameDirty() && (bl || pSCtrlLogicGrpDetailBase.getPSCtrlLogicGrpDetailName() != null)) {
            iDataObject.set(FIELD_PSCTRLLOGICGRPDETAILNAME, (Object)pSCtrlLogicGrpDetailBase.getPSCtrlLogicGrpDetailName());
        }
        if (pSCtrlLogicGrpDetailBase.isPSDEIdDirty() && (bl || pSCtrlLogicGrpDetailBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSCtrlLogicGrpDetailBase.getPSDEId());
        }
        if (pSCtrlLogicGrpDetailBase.isPSDELogicIdDirty() && (bl || pSCtrlLogicGrpDetailBase.getPSDELogicId() != null)) {
            iDataObject.set(FIELD_PSDELOGICID, (Object)pSCtrlLogicGrpDetailBase.getPSDELogicId());
        }
        if (pSCtrlLogicGrpDetailBase.isPSDELogicNameDirty() && (bl || pSCtrlLogicGrpDetailBase.getPSDELogicName() != null)) {
            iDataObject.set(FIELD_PSDELOGICNAME, (Object)pSCtrlLogicGrpDetailBase.getPSDELogicName());
        }
        if (pSCtrlLogicGrpDetailBase.isPSDENameDirty() && (bl || pSCtrlLogicGrpDetailBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSCtrlLogicGrpDetailBase.getPSDEName());
        }
        if (pSCtrlLogicGrpDetailBase.isPSDEUIActionIdDirty() && (bl || pSCtrlLogicGrpDetailBase.getPSDEUIActionId() != null)) {
            iDataObject.set(FIELD_PSDEUIACTIONID, (Object)pSCtrlLogicGrpDetailBase.getPSDEUIActionId());
        }
        if (pSCtrlLogicGrpDetailBase.isPSDEUIActionNameDirty() && (bl || pSCtrlLogicGrpDetailBase.getPSDEUIActionName() != null)) {
            iDataObject.set(FIELD_PSDEUIACTIONNAME, (Object)pSCtrlLogicGrpDetailBase.getPSDEUIActionName());
        }
        if (pSCtrlLogicGrpDetailBase.isPSSysPFPluginIdDirty() && (bl || pSCtrlLogicGrpDetailBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSCtrlLogicGrpDetailBase.getPSSysPFPluginId());
        }
        if (pSCtrlLogicGrpDetailBase.isPSSysPFPluginNameDirty() && (bl || pSCtrlLogicGrpDetailBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSCtrlLogicGrpDetailBase.getPSSysPFPluginName());
        }
        if (pSCtrlLogicGrpDetailBase.isPSSysViewLogicIdDirty() && (bl || pSCtrlLogicGrpDetailBase.getPSSysViewLogicId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWLOGICID, (Object)pSCtrlLogicGrpDetailBase.getPSSysViewLogicId());
        }
        if (pSCtrlLogicGrpDetailBase.isPSSysViewLogicNameDirty() && (bl || pSCtrlLogicGrpDetailBase.getPSSysViewLogicName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWLOGICNAME, (Object)pSCtrlLogicGrpDetailBase.getPSSysViewLogicName());
        }
        if (pSCtrlLogicGrpDetailBase.isPSSysViewPanelIdDirty() && (bl || pSCtrlLogicGrpDetailBase.getPSSysViewPanelId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELID, (Object)pSCtrlLogicGrpDetailBase.getPSSysViewPanelId());
        }
        if (pSCtrlLogicGrpDetailBase.isPSSysViewPanelNameDirty() && (bl || pSCtrlLogicGrpDetailBase.getPSSysViewPanelName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELNAME, (Object)pSCtrlLogicGrpDetailBase.getPSSysViewPanelName());
        }
        if (pSCtrlLogicGrpDetailBase.isTimerDirty() && (bl || pSCtrlLogicGrpDetailBase.getTimer() != null)) {
            iDataObject.set(FIELD_TIMER, (Object)pSCtrlLogicGrpDetailBase.getTimer());
        }
        if (pSCtrlLogicGrpDetailBase.isTriggerTypeDirty() && (bl || pSCtrlLogicGrpDetailBase.getTriggerType() != null)) {
            iDataObject.set(FIELD_TRIGGERTYPE, (Object)pSCtrlLogicGrpDetailBase.getTriggerType());
        }
        if (pSCtrlLogicGrpDetailBase.isUpdateDateDirty() && (bl || pSCtrlLogicGrpDetailBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSCtrlLogicGrpDetailBase.getUpdateDate());
        }
        if (pSCtrlLogicGrpDetailBase.isUpdateManDirty() && (bl || pSCtrlLogicGrpDetailBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSCtrlLogicGrpDetailBase.getUpdateMan());
        }
        if (pSCtrlLogicGrpDetailBase.isUserCatDirty() && (bl || pSCtrlLogicGrpDetailBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSCtrlLogicGrpDetailBase.getUserCat());
        }
        if (pSCtrlLogicGrpDetailBase.isUserTagDirty() && (bl || pSCtrlLogicGrpDetailBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSCtrlLogicGrpDetailBase.getUserTag());
        }
        if (pSCtrlLogicGrpDetailBase.isUserTag2Dirty() && (bl || pSCtrlLogicGrpDetailBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSCtrlLogicGrpDetailBase.getUserTag2());
        }
        if (pSCtrlLogicGrpDetailBase.isUserTag3Dirty() && (bl || pSCtrlLogicGrpDetailBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSCtrlLogicGrpDetailBase.getUserTag3());
        }
        if (pSCtrlLogicGrpDetailBase.isUserTag4Dirty() && (bl || pSCtrlLogicGrpDetailBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSCtrlLogicGrpDetailBase.getUserTag4());
        }
        if (pSCtrlLogicGrpDetailBase.isValidFlagDirty() && (bl || pSCtrlLogicGrpDetailBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSCtrlLogicGrpDetailBase.getValidFlag());
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
        return PSCtrlLogicGrpDetailBase.remove(this, n);
    }

    private static boolean remove(PSCtrlLogicGrpDetailBase pSCtrlLogicGrpDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSCtrlLogicGrpDetailBase.resetAttrName();
                return true;
            }
            case 1: {
                pSCtrlLogicGrpDetailBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSCtrlLogicGrpDetailBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSCtrlLogicGrpDetailBase.resetCtrlName();
                return true;
            }
            case 4: {
                pSCtrlLogicGrpDetailBase.resetCustomCode();
                return true;
            }
            case 5: {
                pSCtrlLogicGrpDetailBase.resetDstLogicType();
                return true;
            }
            case 6: {
                pSCtrlLogicGrpDetailBase.resetEventArg();
                return true;
            }
            case 7: {
                pSCtrlLogicGrpDetailBase.resetEventArg2();
                return true;
            }
            case 8: {
                pSCtrlLogicGrpDetailBase.resetEventNames();
                return true;
            }
            case 9: {
                pSCtrlLogicGrpDetailBase.resetItemName();
                return true;
            }
            case 10: {
                pSCtrlLogicGrpDetailBase.resetLogicParam();
                return true;
            }
            case 11: {
                pSCtrlLogicGrpDetailBase.resetLogicParam2();
                return true;
            }
            case 12: {
                pSCtrlLogicGrpDetailBase.resetMemo();
                return true;
            }
            case 13: {
                pSCtrlLogicGrpDetailBase.resetOrderValue();
                return true;
            }
            case 14: {
                pSCtrlLogicGrpDetailBase.resetPSCtrlLogicGroupId();
                return true;
            }
            case 15: {
                pSCtrlLogicGrpDetailBase.resetPSCtrlLogicGroupName();
                return true;
            }
            case 16: {
                pSCtrlLogicGrpDetailBase.resetPSCtrlLogicGrpDetailId();
                return true;
            }
            case 17: {
                pSCtrlLogicGrpDetailBase.resetPSCtrlLogicGrpDetailName();
                return true;
            }
            case 18: {
                pSCtrlLogicGrpDetailBase.resetPSDEId();
                return true;
            }
            case 19: {
                pSCtrlLogicGrpDetailBase.resetPSDELogicId();
                return true;
            }
            case 20: {
                pSCtrlLogicGrpDetailBase.resetPSDELogicName();
                return true;
            }
            case 21: {
                pSCtrlLogicGrpDetailBase.resetPSDEName();
                return true;
            }
            case 22: {
                pSCtrlLogicGrpDetailBase.resetPSDEUIActionId();
                return true;
            }
            case 23: {
                pSCtrlLogicGrpDetailBase.resetPSDEUIActionName();
                return true;
            }
            case 24: {
                pSCtrlLogicGrpDetailBase.resetPSSysPFPluginId();
                return true;
            }
            case 25: {
                pSCtrlLogicGrpDetailBase.resetPSSysPFPluginName();
                return true;
            }
            case 26: {
                pSCtrlLogicGrpDetailBase.resetPSSysViewLogicId();
                return true;
            }
            case 27: {
                pSCtrlLogicGrpDetailBase.resetPSSysViewLogicName();
                return true;
            }
            case 28: {
                pSCtrlLogicGrpDetailBase.resetPSSysViewPanelId();
                return true;
            }
            case 29: {
                pSCtrlLogicGrpDetailBase.resetPSSysViewPanelName();
                return true;
            }
            case 30: {
                pSCtrlLogicGrpDetailBase.resetTimer();
                return true;
            }
            case 31: {
                pSCtrlLogicGrpDetailBase.resetTriggerType();
                return true;
            }
            case 32: {
                pSCtrlLogicGrpDetailBase.resetUpdateDate();
                return true;
            }
            case 33: {
                pSCtrlLogicGrpDetailBase.resetUpdateMan();
                return true;
            }
            case 34: {
                pSCtrlLogicGrpDetailBase.resetUserCat();
                return true;
            }
            case 35: {
                pSCtrlLogicGrpDetailBase.resetUserTag();
                return true;
            }
            case 36: {
                pSCtrlLogicGrpDetailBase.resetUserTag2();
                return true;
            }
            case 37: {
                pSCtrlLogicGrpDetailBase.resetUserTag3();
                return true;
            }
            case 38: {
                pSCtrlLogicGrpDetailBase.resetUserTag4();
                return true;
            }
            case 39: {
                pSCtrlLogicGrpDetailBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCtrlLogicGroup getPSCtrlLogicGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlLogicGroup();
        }
        if (this.getPSCtrlLogicGroupId() == null) {
            return null;
        }
        Integer n = this.objPSCtrlLogicGroupLock;
        synchronized (n) {
            if (this.psctrllogicgroup != null && DataTypeHelper.compare((int)25, (Object)this.getPSCtrlLogicGroupId(), (Object)this.psctrllogicgroup.getPSCtrlLogicGroupId()) != 0L) {
                this.psctrllogicgroup = null;
            }
            if (this.psctrllogicgroup == null) {
                PSCtrlLogicGroup pSCtrlLogicGroup = new PSCtrlLogicGroup();
                pSCtrlLogicGroup.setPSCtrlLogicGroupId(this.getPSCtrlLogicGroupId());
                PSCtrlLogicGroupService pSCtrlLogicGroupService = (PSCtrlLogicGroupService)ServiceGlobal.getService(PSCtrlLogicGroupService.class, (SessionFactory)this.getSessionFactory());
                pSCtrlLogicGroupService.autoGet((IEntity)pSCtrlLogicGroup);
                this.psctrllogicgroup = pSCtrlLogicGroup;
            }
            return this.psctrllogicgroup;
        }
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

    private PSCtrlLogicGrpDetailBase getProxyEntity() {
        return this.proxyPSCtrlLogicGrpDetailBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSCtrlLogicGrpDetailBase = null;
        if (iDataObject != null && iDataObject instanceof PSCtrlLogicGrpDetailBase) {
            this.proxyPSCtrlLogicGrpDetailBase = (PSCtrlLogicGrpDetailBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCtrlLogicGrpDetailService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ATTRNAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_CTRLNAME, 3);
        fieldIndexMap.put(FIELD_CUSTOMCODE, 4);
        fieldIndexMap.put(FIELD_DSTLOGICTYPE, 5);
        fieldIndexMap.put(FIELD_EVENTARG, 6);
        fieldIndexMap.put(FIELD_EVENTARG2, 7);
        fieldIndexMap.put(FIELD_EVENTNAMES, 8);
        fieldIndexMap.put(FIELD_ITEMNAME, 9);
        fieldIndexMap.put(FIELD_LOGICPARAM, 10);
        fieldIndexMap.put(FIELD_LOGICPARAM2, 11);
        fieldIndexMap.put(FIELD_MEMO, 12);
        fieldIndexMap.put(FIELD_ORDERVALUE, 13);
        fieldIndexMap.put(FIELD_PSCTRLLOGICGROUPID, 14);
        fieldIndexMap.put(FIELD_PSCTRLLOGICGROUPNAME, 15);
        fieldIndexMap.put(FIELD_PSCTRLLOGICGRPDETAILID, 16);
        fieldIndexMap.put(FIELD_PSCTRLLOGICGRPDETAILNAME, 17);
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

