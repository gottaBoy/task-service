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
import java.util.ArrayList;
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
import net.ibizsys.pscore.srv.appdesign.entity.PSAppFunc;
import net.ibizsys.pscore.srv.appdesign.service.PSAppFuncService;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.service.PSSysPFPluginService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelLogicLink;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelLogicNode;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelLogicParam;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewLogic;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelModel;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelLogicLinkService;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelLogicNodeService;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelLogicParamService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewLogicService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelLogicService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysViewPanelLogicBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysViewPanelLogicBase.class);
    public static final String FIELD_ATTRNAME = "ATTRNAME";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CTRLEVENT = "CTRLEVENT";
    public static final String FIELD_CTRLEVENTARG = "CTRLEVENTARG";
    public static final String FIELD_CTRLEVENTARG2 = "CTRLEVENTARG2";
    public static final String FIELD_CTRLEVENTNAME = "CTRLEVENTNAME";
    public static final String FIELD_CUSTOMCODE = "CUSTOMCODE";
    public static final String FIELD_DSTLOGICTYPE = "DSTLOGICTYPE";
    public static final String FIELD_LAYOUTPSSYSVIEWPANELID = "LAYOUTPSSYSVIEWPANELID";
    public static final String FIELD_LAYOUTPSSYSVIEWPANELNAME = "LAYOUTPSSYSVIEWPANELNAME";
    public static final String FIELD_LOGICMODEL = "LOGICMODEL";
    public static final String FIELD_LOGICPARAM = "LOGICPARAM";
    public static final String FIELD_LOGICPARAM2 = "LOGICPARAM2";
    public static final String FIELD_LOGICTYPE = "LOGICTYPE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PARAMPSPANELITEMID = "PARAMPSPANELITEMID";
    public static final String FIELD_PARAMPSPANELITEMNAME = "PARAMPSPANELITEMNAME";
    public static final String FIELD_PSAPPFUNCID = "PSAPPFUNCID";
    public static final String FIELD_PSAPPFUNCNAME = "PSAPPFUNCNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDELOGICID = "PSDELOGICID";
    public static final String FIELD_PSDELOGICNAME = "PSDELOGICNAME";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDEUIACTIONID = "PSDEUIACTIONID";
    public static final String FIELD_PSDEUIACTIONNAME = "PSDEUIACTIONNAME";
    public static final String FIELD_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String FIELD_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSVIEWLOGICID = "PSSYSVIEWLOGICID";
    public static final String FIELD_PSSYSVIEWLOGICNAME = "PSSYSVIEWLOGICNAME";
    public static final String FIELD_PSSYSVIEWPANELID = "PSSYSVIEWPANELID";
    public static final String FIELD_PSSYSVIEWPANELITEMID = "PSSYSVIEWPANELITEMID";
    public static final String FIELD_PSSYSVIEWPANELITEMNAME = "PSSYSVIEWPANELITEMNAME";
    public static final String FIELD_PSSYSVIEWPANELLOGICID = "PSSYSVIEWPANELLOGICID";
    public static final String FIELD_PSSYSVIEWPANELLOGICNAME = "PSSYSVIEWPANELLOGICNAME";
    public static final String FIELD_PSSYSVIEWPANELMODELID = "PSSYSVIEWPANELMODELID";
    public static final String FIELD_PSSYSVIEWPANELMODELNAME = "PSSYSVIEWPANELMODELNAME";
    public static final String FIELD_PSSYSVIEWPANELNAME = "PSSYSVIEWPANELNAME";
    public static final String FIELD_TIMER = "TIMER";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_ATTRNAME = 0;
    private static final int INDEX_CODENAME = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_CTRLEVENT = 4;
    private static final int INDEX_CTRLEVENTARG = 5;
    private static final int INDEX_CTRLEVENTARG2 = 6;
    private static final int INDEX_CTRLEVENTNAME = 7;
    private static final int INDEX_CUSTOMCODE = 8;
    private static final int INDEX_DSTLOGICTYPE = 9;
    private static final int INDEX_LAYOUTPSSYSVIEWPANELID = 10;
    private static final int INDEX_LAYOUTPSSYSVIEWPANELNAME = 11;
    private static final int INDEX_LOGICMODEL = 12;
    private static final int INDEX_LOGICPARAM = 13;
    private static final int INDEX_LOGICPARAM2 = 14;
    private static final int INDEX_LOGICTYPE = 15;
    private static final int INDEX_MEMO = 16;
    private static final int INDEX_ORDERVALUE = 17;
    private static final int INDEX_PARAMPSPANELITEMID = 18;
    private static final int INDEX_PARAMPSPANELITEMNAME = 19;
    private static final int INDEX_PSAPPFUNCID = 20;
    private static final int INDEX_PSAPPFUNCNAME = 21;
    private static final int INDEX_PSDEID = 22;
    private static final int INDEX_PSDELOGICID = 23;
    private static final int INDEX_PSDELOGICNAME = 24;
    private static final int INDEX_PSDENAME = 25;
    private static final int INDEX_PSDEUIACTIONID = 26;
    private static final int INDEX_PSDEUIACTIONNAME = 27;
    private static final int INDEX_PSSYSPFPLUGINID = 28;
    private static final int INDEX_PSSYSPFPLUGINNAME = 29;
    private static final int INDEX_PSSYSTEMID = 30;
    private static final int INDEX_PSSYSVIEWLOGICID = 31;
    private static final int INDEX_PSSYSVIEWLOGICNAME = 32;
    private static final int INDEX_PSSYSVIEWPANELID = 33;
    private static final int INDEX_PSSYSVIEWPANELITEMID = 34;
    private static final int INDEX_PSSYSVIEWPANELITEMNAME = 35;
    private static final int INDEX_PSSYSVIEWPANELLOGICID = 36;
    private static final int INDEX_PSSYSVIEWPANELLOGICNAME = 37;
    private static final int INDEX_PSSYSVIEWPANELMODELID = 38;
    private static final int INDEX_PSSYSVIEWPANELMODELNAME = 39;
    private static final int INDEX_PSSYSVIEWPANELNAME = 40;
    private static final int INDEX_TIMER = 41;
    private static final int INDEX_UPDATEDATE = 42;
    private static final int INDEX_UPDATEMAN = 43;
    private static final int INDEX_VALIDFLAG = 44;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysViewPanelLogicBase proxyPSSysViewPanelLogicBase = null;
    private boolean attrnameDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean ctrleventDirtyFlag = false;
    private boolean ctrleventargDirtyFlag = false;
    private boolean ctrleventarg2DirtyFlag = false;
    private boolean ctrleventnameDirtyFlag = false;
    private boolean customcodeDirtyFlag = false;
    private boolean dstlogictypeDirtyFlag = false;
    private boolean layoutpssysviewpanelidDirtyFlag = false;
    private boolean layoutpssysviewpanelnameDirtyFlag = false;
    private boolean logicmodelDirtyFlag = false;
    private boolean logicparamDirtyFlag = false;
    private boolean logicparam2DirtyFlag = false;
    private boolean logictypeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean parampspanelitemidDirtyFlag = false;
    private boolean parampspanelitemnameDirtyFlag = false;
    private boolean psappfuncidDirtyFlag = false;
    private boolean psappfuncnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdelogicidDirtyFlag = false;
    private boolean psdelogicnameDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psdeuiactionidDirtyFlag = false;
    private boolean psdeuiactionnameDirtyFlag = false;
    private boolean pssyspfpluginidDirtyFlag = false;
    private boolean pssyspfpluginnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssysviewlogicidDirtyFlag = false;
    private boolean pssysviewlogicnameDirtyFlag = false;
    private boolean pssysviewpanelidDirtyFlag = false;
    private boolean pssysviewpanelitemidDirtyFlag = false;
    private boolean pssysviewpanelitemnameDirtyFlag = false;
    private boolean pssysviewpanellogicidDirtyFlag = false;
    private boolean pssysviewpanellogicnameDirtyFlag = false;
    private boolean pssysviewpanelmodelidDirtyFlag = false;
    private boolean pssysviewpanelmodelnameDirtyFlag = false;
    private boolean pssysviewpanelnameDirtyFlag = false;
    private boolean timerDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="attrname")
    private String attrname;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="ctrlevent")
    private String ctrlevent;
    @Column(name="ctrleventarg")
    private String ctrleventarg;
    @Column(name="ctrleventarg2")
    private String ctrleventarg2;
    @Column(name="ctrleventname")
    private String ctrleventname;
    @Column(name="customcode")
    private String customcode;
    @Column(name="dstlogictype")
    private String dstlogictype;
    @Column(name="layoutpssysviewpanelid")
    private String layoutpssysviewpanelid;
    @Column(name="layoutpssysviewpanelname")
    private String layoutpssysviewpanelname;
    @Column(name="logicmodel")
    private String logicmodel;
    @Column(name="logicparam")
    private String logicparam;
    @Column(name="logicparam2")
    private String logicparam2;
    @Column(name="logictype")
    private String logictype;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="parampspanelitemid")
    private String parampspanelitemid;
    @Column(name="parampspanelitemname")
    private String parampspanelitemname;
    @Column(name="psappfuncid")
    private String psappfuncid;
    @Column(name="psappfuncname")
    private String psappfuncname;
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
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssysviewlogicid")
    private String pssysviewlogicid;
    @Column(name="pssysviewlogicname")
    private String pssysviewlogicname;
    @Column(name="pssysviewpanelid")
    private String pssysviewpanelid;
    @Column(name="pssysviewpanelitemid")
    private String pssysviewpanelitemid;
    @Column(name="pssysviewpanelitemname")
    private String pssysviewpanelitemname;
    @Column(name="pssysviewpanellogicid")
    private String pssysviewpanellogicid;
    @Column(name="pssysviewpanellogicname")
    private String pssysviewpanellogicname;
    @Column(name="pssysviewpanelmodelid")
    private String pssysviewpanelmodelid;
    @Column(name="pssysviewpanelmodelname")
    private String pssysviewpanelmodelname;
    @Column(name="pssysviewpanelname")
    private String pssysviewpanelname;
    @Column(name="timer")
    private Integer timer;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSAppFuncLock = new Integer(1);
    private PSAppFunc psappfunc = null;
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
    private Integer objParamPSPanelItemLock = new Integer(1);
    private PSSysViewPanelItem parampspanelitem = null;
    private Integer objPSSysViewPanelItemLock = new Integer(1);
    private PSSysViewPanelItem pssysviewpanelitem = null;
    private Integer objPSSysViewPanelModelLock = new Integer(1);
    private PSSysViewPanelModel pssysviewpanelmodel = null;
    private Integer objLayoutPSSysViewPanelLock = new Integer(1);
    private PSSysViewPanel layoutpssysviewpanel = null;
    private Integer objPSSysViewPanelLock = new Integer(1);
    private PSSysViewPanel pssysviewpanel = null;
    private Integer objPSPanelLogicLinksLock = new Integer(1);
    private ArrayList<PSPanelLogicLink> pspanellogiclinks = null;
    private Integer objPSPanelLogicNodesLock = new Integer(1);
    private ArrayList<PSPanelLogicNode> pspanellogicnodes = null;
    private Integer objPSPanelLogicParamsLock = new Integer(1);
    private ArrayList<PSPanelLogicParam> pspanellogicparams = null;

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

    public void setCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.codename = string;
        this.codenameDirtyFlag = true;
    }

    public String getCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeName();
        }
        return this.codename;
    }

    public boolean isCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeNameDirty();
        }
        return this.codenameDirtyFlag;
    }

    public void resetCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeName();
            return;
        }
        this.codenameDirtyFlag = false;
        this.codename = null;
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

    public void setCtrlEvent(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlEvent(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ctrlevent = string;
        this.ctrleventDirtyFlag = true;
    }

    public String getCtrlEvent() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlEvent();
        }
        return this.ctrlevent;
    }

    public boolean isCtrlEventDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlEventDirty();
        }
        return this.ctrleventDirtyFlag;
    }

    public void resetCtrlEvent() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlEvent();
            return;
        }
        this.ctrleventDirtyFlag = false;
        this.ctrlevent = null;
    }

    public void setCtrlEventArg(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlEventArg(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ctrleventarg = string;
        this.ctrleventargDirtyFlag = true;
    }

    public String getCtrlEventArg() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlEventArg();
        }
        return this.ctrleventarg;
    }

    public boolean isCtrlEventArgDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlEventArgDirty();
        }
        return this.ctrleventargDirtyFlag;
    }

    public void resetCtrlEventArg() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlEventArg();
            return;
        }
        this.ctrleventargDirtyFlag = false;
        this.ctrleventarg = null;
    }

    public void setCtrlEventArg2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlEventArg2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ctrleventarg2 = string;
        this.ctrleventarg2DirtyFlag = true;
    }

    public String getCtrlEventArg2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlEventArg2();
        }
        return this.ctrleventarg2;
    }

    public boolean isCtrlEventArg2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlEventArg2Dirty();
        }
        return this.ctrleventarg2DirtyFlag;
    }

    public void resetCtrlEventArg2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlEventArg2();
            return;
        }
        this.ctrleventarg2DirtyFlag = false;
        this.ctrleventarg2 = null;
    }

    public void setCtrlEventName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlEventName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ctrleventname = string;
        this.ctrleventnameDirtyFlag = true;
    }

    public String getCtrlEventName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlEventName();
        }
        return this.ctrleventname;
    }

    public boolean isCtrlEventNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlEventNameDirty();
        }
        return this.ctrleventnameDirtyFlag;
    }

    public void resetCtrlEventName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlEventName();
            return;
        }
        this.ctrleventnameDirtyFlag = false;
        this.ctrleventname = null;
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

    public void setLayoutPSSysViewPanelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLayoutPSSysViewPanelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.layoutpssysviewpanelid = string;
        this.layoutpssysviewpanelidDirtyFlag = true;
    }

    public String getLayoutPSSysViewPanelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLayoutPSSysViewPanelId();
        }
        return this.layoutpssysviewpanelid;
    }

    public boolean isLayoutPSSysViewPanelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLayoutPSSysViewPanelIdDirty();
        }
        return this.layoutpssysviewpanelidDirtyFlag;
    }

    public void resetLayoutPSSysViewPanelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLayoutPSSysViewPanelId();
            return;
        }
        this.layoutpssysviewpanelidDirtyFlag = false;
        this.layoutpssysviewpanelid = null;
    }

    public void setLayoutPSSysViewPanelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLayoutPSSysViewPanelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.layoutpssysviewpanelname = string;
        this.layoutpssysviewpanelnameDirtyFlag = true;
    }

    public String getLayoutPSSysViewPanelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLayoutPSSysViewPanelName();
        }
        return this.layoutpssysviewpanelname;
    }

    public boolean isLayoutPSSysViewPanelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLayoutPSSysViewPanelNameDirty();
        }
        return this.layoutpssysviewpanelnameDirtyFlag;
    }

    public void resetLayoutPSSysViewPanelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLayoutPSSysViewPanelName();
            return;
        }
        this.layoutpssysviewpanelnameDirtyFlag = false;
        this.layoutpssysviewpanelname = null;
    }

    public void setLogicModel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogicModel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.logicmodel = string;
        this.logicmodelDirtyFlag = true;
    }

    public String getLogicModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogicModel();
        }
        return this.logicmodel;
    }

    public boolean isLogicModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogicModelDirty();
        }
        return this.logicmodelDirtyFlag;
    }

    public void resetLogicModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogicModel();
            return;
        }
        this.logicmodelDirtyFlag = false;
        this.logicmodel = null;
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

    public void setLogicType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogicType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.logictype = string;
        this.logictypeDirtyFlag = true;
    }

    public String getLogicType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogicType();
        }
        return this.logictype;
    }

    public boolean isLogicTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogicTypeDirty();
        }
        return this.logictypeDirtyFlag;
    }

    public void resetLogicType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogicType();
            return;
        }
        this.logictypeDirtyFlag = false;
        this.logictype = null;
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

    public void setParamPSPanelItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParamPSPanelItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.parampspanelitemid = string;
        this.parampspanelitemidDirtyFlag = true;
    }

    public String getParamPSPanelItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParamPSPanelItemId();
        }
        return this.parampspanelitemid;
    }

    public boolean isParamPSPanelItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParamPSPanelItemIdDirty();
        }
        return this.parampspanelitemidDirtyFlag;
    }

    public void resetParamPSPanelItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParamPSPanelItemId();
            return;
        }
        this.parampspanelitemidDirtyFlag = false;
        this.parampspanelitemid = null;
    }

    public void setParamPSPanelItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParamPSPanelItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.parampspanelitemname = string;
        this.parampspanelitemnameDirtyFlag = true;
    }

    public String getParamPSPanelItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParamPSPanelItemName();
        }
        return this.parampspanelitemname;
    }

    public boolean isParamPSPanelItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParamPSPanelItemNameDirty();
        }
        return this.parampspanelitemnameDirtyFlag;
    }

    public void resetParamPSPanelItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParamPSPanelItemName();
            return;
        }
        this.parampspanelitemnameDirtyFlag = false;
        this.parampspanelitemname = null;
    }

    public void setPSAppFuncId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppFuncId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappfuncid = string;
        this.psappfuncidDirtyFlag = true;
    }

    public String getPSAppFuncId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppFuncId();
        }
        return this.psappfuncid;
    }

    public boolean isPSAppFuncIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppFuncIdDirty();
        }
        return this.psappfuncidDirtyFlag;
    }

    public void resetPSAppFuncId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppFuncId();
            return;
        }
        this.psappfuncidDirtyFlag = false;
        this.psappfuncid = null;
    }

    public void setPSAppFuncName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppFuncName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappfuncname = string;
        this.psappfuncnameDirtyFlag = true;
    }

    public String getPSAppFuncName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppFuncName();
        }
        return this.psappfuncname;
    }

    public boolean isPSAppFuncNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppFuncNameDirty();
        }
        return this.psappfuncnameDirtyFlag;
    }

    public void resetPSAppFuncName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppFuncName();
            return;
        }
        this.psappfuncnameDirtyFlag = false;
        this.psappfuncname = null;
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

    public void setPSSystemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemid = string;
        this.pssystemidDirtyFlag = true;
    }

    public String getPSSystemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemId();
        }
        return this.pssystemid;
    }

    public boolean isPSSystemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemIdDirty();
        }
        return this.pssystemidDirtyFlag;
    }

    public void resetPSSystemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemId();
            return;
        }
        this.pssystemidDirtyFlag = false;
        this.pssystemid = null;
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

    public void setPSSysViewPanelItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysViewPanelItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysviewpanelitemid = string;
        this.pssysviewpanelitemidDirtyFlag = true;
    }

    public String getPSSysViewPanelItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewPanelItemId();
        }
        return this.pssysviewpanelitemid;
    }

    public boolean isPSSysViewPanelItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysViewPanelItemIdDirty();
        }
        return this.pssysviewpanelitemidDirtyFlag;
    }

    public void resetPSSysViewPanelItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysViewPanelItemId();
            return;
        }
        this.pssysviewpanelitemidDirtyFlag = false;
        this.pssysviewpanelitemid = null;
    }

    public void setPSSysViewPanelItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysViewPanelItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysviewpanelitemname = string;
        this.pssysviewpanelitemnameDirtyFlag = true;
    }

    public String getPSSysViewPanelItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewPanelItemName();
        }
        return this.pssysviewpanelitemname;
    }

    public boolean isPSSysViewPanelItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysViewPanelItemNameDirty();
        }
        return this.pssysviewpanelitemnameDirtyFlag;
    }

    public void resetPSSysViewPanelItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysViewPanelItemName();
            return;
        }
        this.pssysviewpanelitemnameDirtyFlag = false;
        this.pssysviewpanelitemname = null;
    }

    public void setPSSysViewPanelLogicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysViewPanelLogicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysviewpanellogicid = string;
        this.pssysviewpanellogicidDirtyFlag = true;
    }

    public String getPSSysViewPanelLogicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewPanelLogicId();
        }
        return this.pssysviewpanellogicid;
    }

    public boolean isPSSysViewPanelLogicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysViewPanelLogicIdDirty();
        }
        return this.pssysviewpanellogicidDirtyFlag;
    }

    public void resetPSSysViewPanelLogicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysViewPanelLogicId();
            return;
        }
        this.pssysviewpanellogicidDirtyFlag = false;
        this.pssysviewpanellogicid = null;
    }

    public void setPSSysViewPanelLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysViewPanelLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysviewpanellogicname = string;
        this.pssysviewpanellogicnameDirtyFlag = true;
    }

    public String getPSSysViewPanelLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewPanelLogicName();
        }
        return this.pssysviewpanellogicname;
    }

    public boolean isPSSysViewPanelLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysViewPanelLogicNameDirty();
        }
        return this.pssysviewpanellogicnameDirtyFlag;
    }

    public void resetPSSysViewPanelLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysViewPanelLogicName();
            return;
        }
        this.pssysviewpanellogicnameDirtyFlag = false;
        this.pssysviewpanellogicname = null;
    }

    public void setPSSysViewPanelModelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysViewPanelModelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysviewpanelmodelid = string;
        this.pssysviewpanelmodelidDirtyFlag = true;
    }

    public String getPSSysViewPanelModelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewPanelModelId();
        }
        return this.pssysviewpanelmodelid;
    }

    public boolean isPSSysViewPanelModelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysViewPanelModelIdDirty();
        }
        return this.pssysviewpanelmodelidDirtyFlag;
    }

    public void resetPSSysViewPanelModelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysViewPanelModelId();
            return;
        }
        this.pssysviewpanelmodelidDirtyFlag = false;
        this.pssysviewpanelmodelid = null;
    }

    public void setPSSysViewPanelModelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysViewPanelModelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysviewpanelmodelname = string;
        this.pssysviewpanelmodelnameDirtyFlag = true;
    }

    public String getPSSysViewPanelModelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewPanelModelName();
        }
        return this.pssysviewpanelmodelname;
    }

    public boolean isPSSysViewPanelModelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysViewPanelModelNameDirty();
        }
        return this.pssysviewpanelmodelnameDirtyFlag;
    }

    public void resetPSSysViewPanelModelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysViewPanelModelName();
            return;
        }
        this.pssysviewpanelmodelnameDirtyFlag = false;
        this.pssysviewpanelmodelname = null;
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
        PSSysViewPanelLogicBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysViewPanelLogicBase pSSysViewPanelLogicBase) {
        pSSysViewPanelLogicBase.resetAttrName();
        pSSysViewPanelLogicBase.resetCodeName();
        pSSysViewPanelLogicBase.resetCreateDate();
        pSSysViewPanelLogicBase.resetCreateMan();
        pSSysViewPanelLogicBase.resetCtrlEvent();
        pSSysViewPanelLogicBase.resetCtrlEventArg();
        pSSysViewPanelLogicBase.resetCtrlEventArg2();
        pSSysViewPanelLogicBase.resetCtrlEventName();
        pSSysViewPanelLogicBase.resetCustomCode();
        pSSysViewPanelLogicBase.resetDstLogicType();
        pSSysViewPanelLogicBase.resetLayoutPSSysViewPanelId();
        pSSysViewPanelLogicBase.resetLayoutPSSysViewPanelName();
        pSSysViewPanelLogicBase.resetLogicModel();
        pSSysViewPanelLogicBase.resetLogicParam();
        pSSysViewPanelLogicBase.resetLogicParam2();
        pSSysViewPanelLogicBase.resetLogicType();
        pSSysViewPanelLogicBase.resetMemo();
        pSSysViewPanelLogicBase.resetOrderValue();
        pSSysViewPanelLogicBase.resetParamPSPanelItemId();
        pSSysViewPanelLogicBase.resetParamPSPanelItemName();
        pSSysViewPanelLogicBase.resetPSAppFuncId();
        pSSysViewPanelLogicBase.resetPSAppFuncName();
        pSSysViewPanelLogicBase.resetPSDEId();
        pSSysViewPanelLogicBase.resetPSDELogicId();
        pSSysViewPanelLogicBase.resetPSDELogicName();
        pSSysViewPanelLogicBase.resetPSDEName();
        pSSysViewPanelLogicBase.resetPSDEUIActionId();
        pSSysViewPanelLogicBase.resetPSDEUIActionName();
        pSSysViewPanelLogicBase.resetPSSysPFPluginId();
        pSSysViewPanelLogicBase.resetPSSysPFPluginName();
        pSSysViewPanelLogicBase.resetPSSystemId();
        pSSysViewPanelLogicBase.resetPSSysViewLogicId();
        pSSysViewPanelLogicBase.resetPSSysViewLogicName();
        pSSysViewPanelLogicBase.resetPSSysViewPanelId();
        pSSysViewPanelLogicBase.resetPSSysViewPanelItemId();
        pSSysViewPanelLogicBase.resetPSSysViewPanelItemName();
        pSSysViewPanelLogicBase.resetPSSysViewPanelLogicId();
        pSSysViewPanelLogicBase.resetPSSysViewPanelLogicName();
        pSSysViewPanelLogicBase.resetPSSysViewPanelModelId();
        pSSysViewPanelLogicBase.resetPSSysViewPanelModelName();
        pSSysViewPanelLogicBase.resetPSSysViewPanelName();
        pSSysViewPanelLogicBase.resetTimer();
        pSSysViewPanelLogicBase.resetUpdateDate();
        pSSysViewPanelLogicBase.resetUpdateMan();
        pSSysViewPanelLogicBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAttrNameDirty()) {
            hashMap.put(FIELD_ATTRNAME, this.getAttrName());
        }
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCtrlEventDirty()) {
            hashMap.put(FIELD_CTRLEVENT, this.getCtrlEvent());
        }
        if (!bl || this.isCtrlEventArgDirty()) {
            hashMap.put(FIELD_CTRLEVENTARG, this.getCtrlEventArg());
        }
        if (!bl || this.isCtrlEventArg2Dirty()) {
            hashMap.put(FIELD_CTRLEVENTARG2, this.getCtrlEventArg2());
        }
        if (!bl || this.isCtrlEventNameDirty()) {
            hashMap.put(FIELD_CTRLEVENTNAME, this.getCtrlEventName());
        }
        if (!bl || this.isCustomCodeDirty()) {
            hashMap.put(FIELD_CUSTOMCODE, this.getCustomCode());
        }
        if (!bl || this.isDstLogicTypeDirty()) {
            hashMap.put(FIELD_DSTLOGICTYPE, this.getDstLogicType());
        }
        if (!bl || this.isLayoutPSSysViewPanelIdDirty()) {
            hashMap.put(FIELD_LAYOUTPSSYSVIEWPANELID, this.getLayoutPSSysViewPanelId());
        }
        if (!bl || this.isLayoutPSSysViewPanelNameDirty()) {
            hashMap.put(FIELD_LAYOUTPSSYSVIEWPANELNAME, this.getLayoutPSSysViewPanelName());
        }
        if (!bl || this.isLogicModelDirty()) {
            hashMap.put(FIELD_LOGICMODEL, this.getLogicModel());
        }
        if (!bl || this.isLogicParamDirty()) {
            hashMap.put(FIELD_LOGICPARAM, this.getLogicParam());
        }
        if (!bl || this.isLogicParam2Dirty()) {
            hashMap.put(FIELD_LOGICPARAM2, this.getLogicParam2());
        }
        if (!bl || this.isLogicTypeDirty()) {
            hashMap.put(FIELD_LOGICTYPE, this.getLogicType());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isParamPSPanelItemIdDirty()) {
            hashMap.put(FIELD_PARAMPSPANELITEMID, this.getParamPSPanelItemId());
        }
        if (!bl || this.isParamPSPanelItemNameDirty()) {
            hashMap.put(FIELD_PARAMPSPANELITEMNAME, this.getParamPSPanelItemName());
        }
        if (!bl || this.isPSAppFuncIdDirty()) {
            hashMap.put(FIELD_PSAPPFUNCID, this.getPSAppFuncId());
        }
        if (!bl || this.isPSAppFuncNameDirty()) {
            hashMap.put(FIELD_PSAPPFUNCNAME, this.getPSAppFuncName());
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
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
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
        if (!bl || this.isPSSysViewPanelItemIdDirty()) {
            hashMap.put(FIELD_PSSYSVIEWPANELITEMID, this.getPSSysViewPanelItemId());
        }
        if (!bl || this.isPSSysViewPanelItemNameDirty()) {
            hashMap.put(FIELD_PSSYSVIEWPANELITEMNAME, this.getPSSysViewPanelItemName());
        }
        if (!bl || this.isPSSysViewPanelLogicIdDirty()) {
            hashMap.put(FIELD_PSSYSVIEWPANELLOGICID, this.getPSSysViewPanelLogicId());
        }
        if (!bl || this.isPSSysViewPanelLogicNameDirty()) {
            hashMap.put(FIELD_PSSYSVIEWPANELLOGICNAME, this.getPSSysViewPanelLogicName());
        }
        if (!bl || this.isPSSysViewPanelModelIdDirty()) {
            hashMap.put(FIELD_PSSYSVIEWPANELMODELID, this.getPSSysViewPanelModelId());
        }
        if (!bl || this.isPSSysViewPanelModelNameDirty()) {
            hashMap.put(FIELD_PSSYSVIEWPANELMODELNAME, this.getPSSysViewPanelModelName());
        }
        if (!bl || this.isPSSysViewPanelNameDirty()) {
            hashMap.put(FIELD_PSSYSVIEWPANELNAME, this.getPSSysViewPanelName());
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
        return PSSysViewPanelLogicBase.get(this, n);
    }

    private static Object get(PSSysViewPanelLogicBase pSSysViewPanelLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysViewPanelLogicBase.getAttrName();
            }
            case 1: {
                return pSSysViewPanelLogicBase.getCodeName();
            }
            case 2: {
                return pSSysViewPanelLogicBase.getCreateDate();
            }
            case 3: {
                return pSSysViewPanelLogicBase.getCreateMan();
            }
            case 4: {
                return pSSysViewPanelLogicBase.getCtrlEvent();
            }
            case 5: {
                return pSSysViewPanelLogicBase.getCtrlEventArg();
            }
            case 6: {
                return pSSysViewPanelLogicBase.getCtrlEventArg2();
            }
            case 7: {
                return pSSysViewPanelLogicBase.getCtrlEventName();
            }
            case 8: {
                return pSSysViewPanelLogicBase.getCustomCode();
            }
            case 9: {
                return pSSysViewPanelLogicBase.getDstLogicType();
            }
            case 10: {
                return pSSysViewPanelLogicBase.getLayoutPSSysViewPanelId();
            }
            case 11: {
                return pSSysViewPanelLogicBase.getLayoutPSSysViewPanelName();
            }
            case 12: {
                return pSSysViewPanelLogicBase.getLogicModel();
            }
            case 13: {
                return pSSysViewPanelLogicBase.getLogicParam();
            }
            case 14: {
                return pSSysViewPanelLogicBase.getLogicParam2();
            }
            case 15: {
                return pSSysViewPanelLogicBase.getLogicType();
            }
            case 16: {
                return pSSysViewPanelLogicBase.getMemo();
            }
            case 17: {
                return pSSysViewPanelLogicBase.getOrderValue();
            }
            case 18: {
                return pSSysViewPanelLogicBase.getParamPSPanelItemId();
            }
            case 19: {
                return pSSysViewPanelLogicBase.getParamPSPanelItemName();
            }
            case 20: {
                return pSSysViewPanelLogicBase.getPSAppFuncId();
            }
            case 21: {
                return pSSysViewPanelLogicBase.getPSAppFuncName();
            }
            case 22: {
                return pSSysViewPanelLogicBase.getPSDEId();
            }
            case 23: {
                return pSSysViewPanelLogicBase.getPSDELogicId();
            }
            case 24: {
                return pSSysViewPanelLogicBase.getPSDELogicName();
            }
            case 25: {
                return pSSysViewPanelLogicBase.getPSDEName();
            }
            case 26: {
                return pSSysViewPanelLogicBase.getPSDEUIActionId();
            }
            case 27: {
                return pSSysViewPanelLogicBase.getPSDEUIActionName();
            }
            case 28: {
                return pSSysViewPanelLogicBase.getPSSysPFPluginId();
            }
            case 29: {
                return pSSysViewPanelLogicBase.getPSSysPFPluginName();
            }
            case 30: {
                return pSSysViewPanelLogicBase.getPSSystemId();
            }
            case 31: {
                return pSSysViewPanelLogicBase.getPSSysViewLogicId();
            }
            case 32: {
                return pSSysViewPanelLogicBase.getPSSysViewLogicName();
            }
            case 33: {
                return pSSysViewPanelLogicBase.getPSSysViewPanelId();
            }
            case 34: {
                return pSSysViewPanelLogicBase.getPSSysViewPanelItemId();
            }
            case 35: {
                return pSSysViewPanelLogicBase.getPSSysViewPanelItemName();
            }
            case 36: {
                return pSSysViewPanelLogicBase.getPSSysViewPanelLogicId();
            }
            case 37: {
                return pSSysViewPanelLogicBase.getPSSysViewPanelLogicName();
            }
            case 38: {
                return pSSysViewPanelLogicBase.getPSSysViewPanelModelId();
            }
            case 39: {
                return pSSysViewPanelLogicBase.getPSSysViewPanelModelName();
            }
            case 40: {
                return pSSysViewPanelLogicBase.getPSSysViewPanelName();
            }
            case 41: {
                return pSSysViewPanelLogicBase.getTimer();
            }
            case 42: {
                return pSSysViewPanelLogicBase.getUpdateDate();
            }
            case 43: {
                return pSSysViewPanelLogicBase.getUpdateMan();
            }
            case 44: {
                return pSSysViewPanelLogicBase.getValidFlag();
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
        PSSysViewPanelLogicBase.set(this, n, object);
    }

    private static void set(PSSysViewPanelLogicBase pSSysViewPanelLogicBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysViewPanelLogicBase.setAttrName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysViewPanelLogicBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysViewPanelLogicBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSSysViewPanelLogicBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysViewPanelLogicBase.setCtrlEvent(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysViewPanelLogicBase.setCtrlEventArg(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysViewPanelLogicBase.setCtrlEventArg2(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysViewPanelLogicBase.setCtrlEventName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysViewPanelLogicBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysViewPanelLogicBase.setDstLogicType(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysViewPanelLogicBase.setLayoutPSSysViewPanelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysViewPanelLogicBase.setLayoutPSSysViewPanelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysViewPanelLogicBase.setLogicModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysViewPanelLogicBase.setLogicParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysViewPanelLogicBase.setLogicParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysViewPanelLogicBase.setLogicType(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysViewPanelLogicBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysViewPanelLogicBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 18: {
                pSSysViewPanelLogicBase.setParamPSPanelItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysViewPanelLogicBase.setParamPSPanelItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysViewPanelLogicBase.setPSAppFuncId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysViewPanelLogicBase.setPSAppFuncName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysViewPanelLogicBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysViewPanelLogicBase.setPSDELogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysViewPanelLogicBase.setPSDELogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysViewPanelLogicBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysViewPanelLogicBase.setPSDEUIActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysViewPanelLogicBase.setPSDEUIActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysViewPanelLogicBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSysViewPanelLogicBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSysViewPanelLogicBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSSysViewPanelLogicBase.setPSSysViewLogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSysViewPanelLogicBase.setPSSysViewLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSSysViewPanelLogicBase.setPSSysViewPanelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSSysViewPanelLogicBase.setPSSysViewPanelItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSSysViewPanelLogicBase.setPSSysViewPanelItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSSysViewPanelLogicBase.setPSSysViewPanelLogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSSysViewPanelLogicBase.setPSSysViewPanelLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSSysViewPanelLogicBase.setPSSysViewPanelModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSSysViewPanelLogicBase.setPSSysViewPanelModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSSysViewPanelLogicBase.setPSSysViewPanelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSSysViewPanelLogicBase.setTimer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 42: {
                pSSysViewPanelLogicBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 43: {
                pSSysViewPanelLogicBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSSysViewPanelLogicBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSysViewPanelLogicBase.isNull(this, n);
    }

    private static boolean isNull(PSSysViewPanelLogicBase pSSysViewPanelLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysViewPanelLogicBase.getAttrName() == null;
            }
            case 1: {
                return pSSysViewPanelLogicBase.getCodeName() == null;
            }
            case 2: {
                return pSSysViewPanelLogicBase.getCreateDate() == null;
            }
            case 3: {
                return pSSysViewPanelLogicBase.getCreateMan() == null;
            }
            case 4: {
                return pSSysViewPanelLogicBase.getCtrlEvent() == null;
            }
            case 5: {
                return pSSysViewPanelLogicBase.getCtrlEventArg() == null;
            }
            case 6: {
                return pSSysViewPanelLogicBase.getCtrlEventArg2() == null;
            }
            case 7: {
                return pSSysViewPanelLogicBase.getCtrlEventName() == null;
            }
            case 8: {
                return pSSysViewPanelLogicBase.getCustomCode() == null;
            }
            case 9: {
                return pSSysViewPanelLogicBase.getDstLogicType() == null;
            }
            case 10: {
                return pSSysViewPanelLogicBase.getLayoutPSSysViewPanelId() == null;
            }
            case 11: {
                return pSSysViewPanelLogicBase.getLayoutPSSysViewPanelName() == null;
            }
            case 12: {
                return pSSysViewPanelLogicBase.getLogicModel() == null;
            }
            case 13: {
                return pSSysViewPanelLogicBase.getLogicParam() == null;
            }
            case 14: {
                return pSSysViewPanelLogicBase.getLogicParam2() == null;
            }
            case 15: {
                return pSSysViewPanelLogicBase.getLogicType() == null;
            }
            case 16: {
                return pSSysViewPanelLogicBase.getMemo() == null;
            }
            case 17: {
                return pSSysViewPanelLogicBase.getOrderValue() == null;
            }
            case 18: {
                return pSSysViewPanelLogicBase.getParamPSPanelItemId() == null;
            }
            case 19: {
                return pSSysViewPanelLogicBase.getParamPSPanelItemName() == null;
            }
            case 20: {
                return pSSysViewPanelLogicBase.getPSAppFuncId() == null;
            }
            case 21: {
                return pSSysViewPanelLogicBase.getPSAppFuncName() == null;
            }
            case 22: {
                return pSSysViewPanelLogicBase.getPSDEId() == null;
            }
            case 23: {
                return pSSysViewPanelLogicBase.getPSDELogicId() == null;
            }
            case 24: {
                return pSSysViewPanelLogicBase.getPSDELogicName() == null;
            }
            case 25: {
                return pSSysViewPanelLogicBase.getPSDEName() == null;
            }
            case 26: {
                return pSSysViewPanelLogicBase.getPSDEUIActionId() == null;
            }
            case 27: {
                return pSSysViewPanelLogicBase.getPSDEUIActionName() == null;
            }
            case 28: {
                return pSSysViewPanelLogicBase.getPSSysPFPluginId() == null;
            }
            case 29: {
                return pSSysViewPanelLogicBase.getPSSysPFPluginName() == null;
            }
            case 30: {
                return pSSysViewPanelLogicBase.getPSSystemId() == null;
            }
            case 31: {
                return pSSysViewPanelLogicBase.getPSSysViewLogicId() == null;
            }
            case 32: {
                return pSSysViewPanelLogicBase.getPSSysViewLogicName() == null;
            }
            case 33: {
                return pSSysViewPanelLogicBase.getPSSysViewPanelId() == null;
            }
            case 34: {
                return pSSysViewPanelLogicBase.getPSSysViewPanelItemId() == null;
            }
            case 35: {
                return pSSysViewPanelLogicBase.getPSSysViewPanelItemName() == null;
            }
            case 36: {
                return pSSysViewPanelLogicBase.getPSSysViewPanelLogicId() == null;
            }
            case 37: {
                return pSSysViewPanelLogicBase.getPSSysViewPanelLogicName() == null;
            }
            case 38: {
                return pSSysViewPanelLogicBase.getPSSysViewPanelModelId() == null;
            }
            case 39: {
                return pSSysViewPanelLogicBase.getPSSysViewPanelModelName() == null;
            }
            case 40: {
                return pSSysViewPanelLogicBase.getPSSysViewPanelName() == null;
            }
            case 41: {
                return pSSysViewPanelLogicBase.getTimer() == null;
            }
            case 42: {
                return pSSysViewPanelLogicBase.getUpdateDate() == null;
            }
            case 43: {
                return pSSysViewPanelLogicBase.getUpdateMan() == null;
            }
            case 44: {
                return pSSysViewPanelLogicBase.getValidFlag() == null;
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
        return PSSysViewPanelLogicBase.contains(this, n);
    }

    private static boolean contains(PSSysViewPanelLogicBase pSSysViewPanelLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysViewPanelLogicBase.isAttrNameDirty();
            }
            case 1: {
                return pSSysViewPanelLogicBase.isCodeNameDirty();
            }
            case 2: {
                return pSSysViewPanelLogicBase.isCreateDateDirty();
            }
            case 3: {
                return pSSysViewPanelLogicBase.isCreateManDirty();
            }
            case 4: {
                return pSSysViewPanelLogicBase.isCtrlEventDirty();
            }
            case 5: {
                return pSSysViewPanelLogicBase.isCtrlEventArgDirty();
            }
            case 6: {
                return pSSysViewPanelLogicBase.isCtrlEventArg2Dirty();
            }
            case 7: {
                return pSSysViewPanelLogicBase.isCtrlEventNameDirty();
            }
            case 8: {
                return pSSysViewPanelLogicBase.isCustomCodeDirty();
            }
            case 9: {
                return pSSysViewPanelLogicBase.isDstLogicTypeDirty();
            }
            case 10: {
                return pSSysViewPanelLogicBase.isLayoutPSSysViewPanelIdDirty();
            }
            case 11: {
                return pSSysViewPanelLogicBase.isLayoutPSSysViewPanelNameDirty();
            }
            case 12: {
                return pSSysViewPanelLogicBase.isLogicModelDirty();
            }
            case 13: {
                return pSSysViewPanelLogicBase.isLogicParamDirty();
            }
            case 14: {
                return pSSysViewPanelLogicBase.isLogicParam2Dirty();
            }
            case 15: {
                return pSSysViewPanelLogicBase.isLogicTypeDirty();
            }
            case 16: {
                return pSSysViewPanelLogicBase.isMemoDirty();
            }
            case 17: {
                return pSSysViewPanelLogicBase.isOrderValueDirty();
            }
            case 18: {
                return pSSysViewPanelLogicBase.isParamPSPanelItemIdDirty();
            }
            case 19: {
                return pSSysViewPanelLogicBase.isParamPSPanelItemNameDirty();
            }
            case 20: {
                return pSSysViewPanelLogicBase.isPSAppFuncIdDirty();
            }
            case 21: {
                return pSSysViewPanelLogicBase.isPSAppFuncNameDirty();
            }
            case 22: {
                return pSSysViewPanelLogicBase.isPSDEIdDirty();
            }
            case 23: {
                return pSSysViewPanelLogicBase.isPSDELogicIdDirty();
            }
            case 24: {
                return pSSysViewPanelLogicBase.isPSDELogicNameDirty();
            }
            case 25: {
                return pSSysViewPanelLogicBase.isPSDENameDirty();
            }
            case 26: {
                return pSSysViewPanelLogicBase.isPSDEUIActionIdDirty();
            }
            case 27: {
                return pSSysViewPanelLogicBase.isPSDEUIActionNameDirty();
            }
            case 28: {
                return pSSysViewPanelLogicBase.isPSSysPFPluginIdDirty();
            }
            case 29: {
                return pSSysViewPanelLogicBase.isPSSysPFPluginNameDirty();
            }
            case 30: {
                return pSSysViewPanelLogicBase.isPSSystemIdDirty();
            }
            case 31: {
                return pSSysViewPanelLogicBase.isPSSysViewLogicIdDirty();
            }
            case 32: {
                return pSSysViewPanelLogicBase.isPSSysViewLogicNameDirty();
            }
            case 33: {
                return pSSysViewPanelLogicBase.isPSSysViewPanelIdDirty();
            }
            case 34: {
                return pSSysViewPanelLogicBase.isPSSysViewPanelItemIdDirty();
            }
            case 35: {
                return pSSysViewPanelLogicBase.isPSSysViewPanelItemNameDirty();
            }
            case 36: {
                return pSSysViewPanelLogicBase.isPSSysViewPanelLogicIdDirty();
            }
            case 37: {
                return pSSysViewPanelLogicBase.isPSSysViewPanelLogicNameDirty();
            }
            case 38: {
                return pSSysViewPanelLogicBase.isPSSysViewPanelModelIdDirty();
            }
            case 39: {
                return pSSysViewPanelLogicBase.isPSSysViewPanelModelNameDirty();
            }
            case 40: {
                return pSSysViewPanelLogicBase.isPSSysViewPanelNameDirty();
            }
            case 41: {
                return pSSysViewPanelLogicBase.isTimerDirty();
            }
            case 42: {
                return pSSysViewPanelLogicBase.isUpdateDateDirty();
            }
            case 43: {
                return pSSysViewPanelLogicBase.isUpdateManDirty();
            }
            case 44: {
                return pSSysViewPanelLogicBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysViewPanelLogicBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysViewPanelLogicBase pSSysViewPanelLogicBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysViewPanelLogicBase.getAttrName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"attrname", (Object)PSSysViewPanelLogicBase.getJSONValue((Object)pSSysViewPanelLogicBase.getAttrName()), (boolean)false);
        }
        if (bl || pSSysViewPanelLogicBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysViewPanelLogicBase.getJSONValue((Object)pSSysViewPanelLogicBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysViewPanelLogicBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysViewPanelLogicBase.getJSONValue((Object)pSSysViewPanelLogicBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysViewPanelLogicBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysViewPanelLogicBase.getJSONValue((Object)pSSysViewPanelLogicBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysViewPanelLogicBase.getCtrlEvent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlevent", (Object)PSSysViewPanelLogicBase.getJSONValue((Object)pSSysViewPanelLogicBase.getCtrlEvent()), (boolean)false);
        }
        if (bl || pSSysViewPanelLogicBase.getCtrlEventArg() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrleventarg", (Object)PSSysViewPanelLogicBase.getJSONValue((Object)pSSysViewPanelLogicBase.getCtrlEventArg()), (boolean)false);
        }
        if (bl || pSSysViewPanelLogicBase.getCtrlEventArg2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrleventarg2", (Object)PSSysViewPanelLogicBase.getJSONValue((Object)pSSysViewPanelLogicBase.getCtrlEventArg2()), (boolean)false);
        }
        if (bl || pSSysViewPanelLogicBase.getCtrlEventName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrleventname", (Object)PSSysViewPanelLogicBase.getJSONValue((Object)pSSysViewPanelLogicBase.getCtrlEventName()), (boolean)false);
        }
        if (bl || pSSysViewPanelLogicBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSSysViewPanelLogicBase.getJSONValue((Object)pSSysViewPanelLogicBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSSysViewPanelLogicBase.getDstLogicType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstlogictype", (Object)PSSysViewPanelLogicBase.getJSONValue((Object)pSSysViewPanelLogicBase.getDstLogicType()), (boolean)false);
        }
        if (bl || pSSysViewPanelLogicBase.getLayoutPSSysViewPanelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"layoutpssysviewpanelid", (Object)PSSysViewPanelLogicBase.getJSONValue((Object)pSSysViewPanelLogicBase.getLayoutPSSysViewPanelId()), (boolean)false);
        }
        if (bl || pSSysViewPanelLogicBase.getLayoutPSSysViewPanelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"layoutpssysviewpanelname", (Object)PSSysViewPanelLogicBase.getJSONValue((Object)pSSysViewPanelLogicBase.getLayoutPSSysViewPanelName()), (boolean)false);
        }
        if (bl || pSSysViewPanelLogicBase.getLogicModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicmodel", (Object)PSSysViewPanelLogicBase.getJSONValue((Object)pSSysViewPanelLogicBase.getLogicModel()), (boolean)false);
        }
        if (bl || pSSysViewPanelLogicBase.getLogicParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicparam", (Object)PSSysViewPanelLogicBase.getJSONValue((Object)pSSysViewPanelLogicBase.getLogicParam()), (boolean)false);
        }
        if (bl || pSSysViewPanelLogicBase.getLogicParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicparam2", (Object)PSSysViewPanelLogicBase.getJSONValue((Object)pSSysViewPanelLogicBase.getLogicParam2()), (boolean)false);
        }
        if (bl || pSSysViewPanelLogicBase.getLogicType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logictype", (Object)PSSysViewPanelLogicBase.getJSONValue((Object)pSSysViewPanelLogicBase.getLogicType()), (boolean)false);
        }
        if (bl || pSSysViewPanelLogicBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysViewPanelLogicBase.getJSONValue((Object)pSSysViewPanelLogicBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysViewPanelLogicBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSysViewPanelLogicBase.getJSONValue((Object)pSSysViewPanelLogicBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSysViewPanelLogicBase.getParamPSPanelItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"parampspanelitemid", (Object)PSSysViewPanelLogicBase.getJSONValue((Object)pSSysViewPanelLogicBase.getParamPSPanelItemId()), (boolean)false);
        }
        if (bl || pSSysViewPanelLogicBase.getParamPSPanelItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"parampspanelitemname", (Object)PSSysViewPanelLogicBase.getJSONValue((Object)pSSysViewPanelLogicBase.getParamPSPanelItemName()), (boolean)false);
        }
        if (bl || pSSysViewPanelLogicBase.getPSAppFuncId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappfuncid", (Object)PSSysViewPanelLogicBase.getJSONValue((Object)pSSysViewPanelLogicBase.getPSAppFuncId()), (boolean)false);
        }
        if (bl || pSSysViewPanelLogicBase.getPSAppFuncName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappfuncname", (Object)PSSysViewPanelLogicBase.getJSONValue((Object)pSSysViewPanelLogicBase.getPSAppFuncName()), (boolean)false);
        }
        if (bl || pSSysViewPanelLogicBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSSysViewPanelLogicBase.getJSONValue((Object)pSSysViewPanelLogicBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSSysViewPanelLogicBase.getPSDELogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicid", (Object)PSSysViewPanelLogicBase.getJSONValue((Object)pSSysViewPanelLogicBase.getPSDELogicId()), (boolean)false);
        }
        if (bl || pSSysViewPanelLogicBase.getPSDELogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicname", (Object)PSSysViewPanelLogicBase.getJSONValue((Object)pSSysViewPanelLogicBase.getPSDELogicName()), (boolean)false);
        }
        if (bl || pSSysViewPanelLogicBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSSysViewPanelLogicBase.getJSONValue((Object)pSSysViewPanelLogicBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSSysViewPanelLogicBase.getPSDEUIActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuiactionid", (Object)PSSysViewPanelLogicBase.getJSONValue((Object)pSSysViewPanelLogicBase.getPSDEUIActionId()), (boolean)false);
        }
        if (bl || pSSysViewPanelLogicBase.getPSDEUIActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuiactionname", (Object)PSSysViewPanelLogicBase.getJSONValue((Object)pSSysViewPanelLogicBase.getPSDEUIActionName()), (boolean)false);
        }
        if (bl || pSSysViewPanelLogicBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSSysViewPanelLogicBase.getJSONValue((Object)pSSysViewPanelLogicBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSSysViewPanelLogicBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSSysViewPanelLogicBase.getJSONValue((Object)pSSysViewPanelLogicBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSSysViewPanelLogicBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysViewPanelLogicBase.getJSONValue((Object)pSSysViewPanelLogicBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysViewPanelLogicBase.getPSSysViewLogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewlogicid", (Object)PSSysViewPanelLogicBase.getJSONValue((Object)pSSysViewPanelLogicBase.getPSSysViewLogicId()), (boolean)false);
        }
        if (bl || pSSysViewPanelLogicBase.getPSSysViewLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewlogicname", (Object)PSSysViewPanelLogicBase.getJSONValue((Object)pSSysViewPanelLogicBase.getPSSysViewLogicName()), (boolean)false);
        }
        if (bl || pSSysViewPanelLogicBase.getPSSysViewPanelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelid", (Object)PSSysViewPanelLogicBase.getJSONValue((Object)pSSysViewPanelLogicBase.getPSSysViewPanelId()), (boolean)false);
        }
        if (bl || pSSysViewPanelLogicBase.getPSSysViewPanelItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelitemid", (Object)PSSysViewPanelLogicBase.getJSONValue((Object)pSSysViewPanelLogicBase.getPSSysViewPanelItemId()), (boolean)false);
        }
        if (bl || pSSysViewPanelLogicBase.getPSSysViewPanelItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelitemname", (Object)PSSysViewPanelLogicBase.getJSONValue((Object)pSSysViewPanelLogicBase.getPSSysViewPanelItemName()), (boolean)false);
        }
        if (bl || pSSysViewPanelLogicBase.getPSSysViewPanelLogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanellogicid", (Object)PSSysViewPanelLogicBase.getJSONValue((Object)pSSysViewPanelLogicBase.getPSSysViewPanelLogicId()), (boolean)false);
        }
        if (bl || pSSysViewPanelLogicBase.getPSSysViewPanelLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanellogicname", (Object)PSSysViewPanelLogicBase.getJSONValue((Object)pSSysViewPanelLogicBase.getPSSysViewPanelLogicName()), (boolean)false);
        }
        if (bl || pSSysViewPanelLogicBase.getPSSysViewPanelModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelmodelid", (Object)PSSysViewPanelLogicBase.getJSONValue((Object)pSSysViewPanelLogicBase.getPSSysViewPanelModelId()), (boolean)false);
        }
        if (bl || pSSysViewPanelLogicBase.getPSSysViewPanelModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelmodelname", (Object)PSSysViewPanelLogicBase.getJSONValue((Object)pSSysViewPanelLogicBase.getPSSysViewPanelModelName()), (boolean)false);
        }
        if (bl || pSSysViewPanelLogicBase.getPSSysViewPanelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelname", (Object)PSSysViewPanelLogicBase.getJSONValue((Object)pSSysViewPanelLogicBase.getPSSysViewPanelName()), (boolean)false);
        }
        if (bl || pSSysViewPanelLogicBase.getTimer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"timer", (Object)PSSysViewPanelLogicBase.getJSONValue((Object)pSSysViewPanelLogicBase.getTimer()), (boolean)false);
        }
        if (bl || pSSysViewPanelLogicBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysViewPanelLogicBase.getJSONValue((Object)pSSysViewPanelLogicBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysViewPanelLogicBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysViewPanelLogicBase.getJSONValue((Object)pSSysViewPanelLogicBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysViewPanelLogicBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysViewPanelLogicBase.getJSONValue((Object)pSSysViewPanelLogicBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysViewPanelLogicBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysViewPanelLogicBase pSSysViewPanelLogicBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysViewPanelLogicBase.getAttrName() != null) {
            object = pSSysViewPanelLogicBase.getAttrName();
            xmlNode.setAttribute(FIELD_ATTRNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSSysViewPanelLogicBase.getCodeName() != null) {
            object = pSSysViewPanelLogicBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelLogicBase.getCreateDate() != null) {
            object = pSSysViewPanelLogicBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysViewPanelLogicBase.getCreateMan() != null) {
            object = pSSysViewPanelLogicBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelLogicBase.getCtrlEvent() != null) {
            object = pSSysViewPanelLogicBase.getCtrlEvent();
            xmlNode.setAttribute(FIELD_CTRLEVENT, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelLogicBase.getCtrlEventArg() != null) {
            object = pSSysViewPanelLogicBase.getCtrlEventArg();
            xmlNode.setAttribute(FIELD_CTRLEVENTARG, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelLogicBase.getCtrlEventArg2() != null) {
            object = pSSysViewPanelLogicBase.getCtrlEventArg2();
            xmlNode.setAttribute(FIELD_CTRLEVENTARG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelLogicBase.getCtrlEventName() != null) {
            object = pSSysViewPanelLogicBase.getCtrlEventName();
            xmlNode.setAttribute(FIELD_CTRLEVENTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelLogicBase.getCustomCode() != null) {
            object = pSSysViewPanelLogicBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelLogicBase.getDstLogicType() != null) {
            object = pSSysViewPanelLogicBase.getDstLogicType();
            xmlNode.setAttribute(FIELD_DSTLOGICTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelLogicBase.getLayoutPSSysViewPanelId() != null) {
            object = pSSysViewPanelLogicBase.getLayoutPSSysViewPanelId();
            xmlNode.setAttribute(FIELD_LAYOUTPSSYSVIEWPANELID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelLogicBase.getLayoutPSSysViewPanelName() != null) {
            object = pSSysViewPanelLogicBase.getLayoutPSSysViewPanelName();
            xmlNode.setAttribute(FIELD_LAYOUTPSSYSVIEWPANELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelLogicBase.getLogicModel() != null) {
            object = pSSysViewPanelLogicBase.getLogicModel();
            xmlNode.setAttribute(FIELD_LOGICMODEL, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelLogicBase.getLogicParam() != null) {
            object = pSSysViewPanelLogicBase.getLogicParam();
            xmlNode.setAttribute(FIELD_LOGICPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelLogicBase.getLogicParam2() != null) {
            object = pSSysViewPanelLogicBase.getLogicParam2();
            xmlNode.setAttribute(FIELD_LOGICPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelLogicBase.getLogicType() != null) {
            object = pSSysViewPanelLogicBase.getLogicType();
            xmlNode.setAttribute(FIELD_LOGICTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelLogicBase.getMemo() != null) {
            object = pSSysViewPanelLogicBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelLogicBase.getOrderValue() != null) {
            object = pSSysViewPanelLogicBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelLogicBase.getParamPSPanelItemId() != null) {
            object = pSSysViewPanelLogicBase.getParamPSPanelItemId();
            xmlNode.setAttribute(FIELD_PARAMPSPANELITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelLogicBase.getParamPSPanelItemName() != null) {
            object = pSSysViewPanelLogicBase.getParamPSPanelItemName();
            xmlNode.setAttribute(FIELD_PARAMPSPANELITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelLogicBase.getPSAppFuncId() != null) {
            object = pSSysViewPanelLogicBase.getPSAppFuncId();
            xmlNode.setAttribute(FIELD_PSAPPFUNCID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelLogicBase.getPSAppFuncName() != null) {
            object = pSSysViewPanelLogicBase.getPSAppFuncName();
            xmlNode.setAttribute(FIELD_PSAPPFUNCNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelLogicBase.getPSDEId() != null) {
            object = pSSysViewPanelLogicBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelLogicBase.getPSDELogicId() != null) {
            object = pSSysViewPanelLogicBase.getPSDELogicId();
            xmlNode.setAttribute(FIELD_PSDELOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelLogicBase.getPSDELogicName() != null) {
            object = pSSysViewPanelLogicBase.getPSDELogicName();
            xmlNode.setAttribute(FIELD_PSDELOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelLogicBase.getPSDEName() != null) {
            object = pSSysViewPanelLogicBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelLogicBase.getPSDEUIActionId() != null) {
            object = pSSysViewPanelLogicBase.getPSDEUIActionId();
            xmlNode.setAttribute(FIELD_PSDEUIACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelLogicBase.getPSDEUIActionName() != null) {
            object = pSSysViewPanelLogicBase.getPSDEUIActionName();
            xmlNode.setAttribute(FIELD_PSDEUIACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelLogicBase.getPSSysPFPluginId() != null) {
            object = pSSysViewPanelLogicBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelLogicBase.getPSSysPFPluginName() != null) {
            object = pSSysViewPanelLogicBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelLogicBase.getPSSystemId() != null) {
            object = pSSysViewPanelLogicBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelLogicBase.getPSSysViewLogicId() != null) {
            object = pSSysViewPanelLogicBase.getPSSysViewLogicId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWLOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelLogicBase.getPSSysViewLogicName() != null) {
            object = pSSysViewPanelLogicBase.getPSSysViewLogicName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWLOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelLogicBase.getPSSysViewPanelId() != null) {
            object = pSSysViewPanelLogicBase.getPSSysViewPanelId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelLogicBase.getPSSysViewPanelItemId() != null) {
            object = pSSysViewPanelLogicBase.getPSSysViewPanelItemId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelLogicBase.getPSSysViewPanelItemName() != null) {
            object = pSSysViewPanelLogicBase.getPSSysViewPanelItemName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelLogicBase.getPSSysViewPanelLogicId() != null) {
            object = pSSysViewPanelLogicBase.getPSSysViewPanelLogicId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELLOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelLogicBase.getPSSysViewPanelLogicName() != null) {
            object = pSSysViewPanelLogicBase.getPSSysViewPanelLogicName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELLOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelLogicBase.getPSSysViewPanelModelId() != null) {
            object = pSSysViewPanelLogicBase.getPSSysViewPanelModelId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelLogicBase.getPSSysViewPanelModelName() != null) {
            object = pSSysViewPanelLogicBase.getPSSysViewPanelModelName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelLogicBase.getPSSysViewPanelName() != null) {
            object = pSSysViewPanelLogicBase.getPSSysViewPanelName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelLogicBase.getTimer() != null) {
            object = pSSysViewPanelLogicBase.getTimer();
            xmlNode.setAttribute(FIELD_TIMER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelLogicBase.getUpdateDate() != null) {
            object = pSSysViewPanelLogicBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysViewPanelLogicBase.getUpdateMan() != null) {
            object = pSSysViewPanelLogicBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelLogicBase.getValidFlag() != null) {
            object = pSSysViewPanelLogicBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysViewPanelLogicBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysViewPanelLogicBase pSSysViewPanelLogicBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysViewPanelLogicBase.isAttrNameDirty() && (bl || pSSysViewPanelLogicBase.getAttrName() != null)) {
            iDataObject.set(FIELD_ATTRNAME, (Object)pSSysViewPanelLogicBase.getAttrName());
        }
        if (pSSysViewPanelLogicBase.isCodeNameDirty() && (bl || pSSysViewPanelLogicBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysViewPanelLogicBase.getCodeName());
        }
        if (pSSysViewPanelLogicBase.isCreateDateDirty() && (bl || pSSysViewPanelLogicBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysViewPanelLogicBase.getCreateDate());
        }
        if (pSSysViewPanelLogicBase.isCreateManDirty() && (bl || pSSysViewPanelLogicBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysViewPanelLogicBase.getCreateMan());
        }
        if (pSSysViewPanelLogicBase.isCtrlEventDirty() && (bl || pSSysViewPanelLogicBase.getCtrlEvent() != null)) {
            iDataObject.set(FIELD_CTRLEVENT, (Object)pSSysViewPanelLogicBase.getCtrlEvent());
        }
        if (pSSysViewPanelLogicBase.isCtrlEventArgDirty() && (bl || pSSysViewPanelLogicBase.getCtrlEventArg() != null)) {
            iDataObject.set(FIELD_CTRLEVENTARG, (Object)pSSysViewPanelLogicBase.getCtrlEventArg());
        }
        if (pSSysViewPanelLogicBase.isCtrlEventArg2Dirty() && (bl || pSSysViewPanelLogicBase.getCtrlEventArg2() != null)) {
            iDataObject.set(FIELD_CTRLEVENTARG2, (Object)pSSysViewPanelLogicBase.getCtrlEventArg2());
        }
        if (pSSysViewPanelLogicBase.isCtrlEventNameDirty() && (bl || pSSysViewPanelLogicBase.getCtrlEventName() != null)) {
            iDataObject.set(FIELD_CTRLEVENTNAME, (Object)pSSysViewPanelLogicBase.getCtrlEventName());
        }
        if (pSSysViewPanelLogicBase.isCustomCodeDirty() && (bl || pSSysViewPanelLogicBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSSysViewPanelLogicBase.getCustomCode());
        }
        if (pSSysViewPanelLogicBase.isDstLogicTypeDirty() && (bl || pSSysViewPanelLogicBase.getDstLogicType() != null)) {
            iDataObject.set(FIELD_DSTLOGICTYPE, (Object)pSSysViewPanelLogicBase.getDstLogicType());
        }
        if (pSSysViewPanelLogicBase.isLayoutPSSysViewPanelIdDirty() && (bl || pSSysViewPanelLogicBase.getLayoutPSSysViewPanelId() != null)) {
            iDataObject.set(FIELD_LAYOUTPSSYSVIEWPANELID, (Object)pSSysViewPanelLogicBase.getLayoutPSSysViewPanelId());
        }
        if (pSSysViewPanelLogicBase.isLayoutPSSysViewPanelNameDirty() && (bl || pSSysViewPanelLogicBase.getLayoutPSSysViewPanelName() != null)) {
            iDataObject.set(FIELD_LAYOUTPSSYSVIEWPANELNAME, (Object)pSSysViewPanelLogicBase.getLayoutPSSysViewPanelName());
        }
        if (pSSysViewPanelLogicBase.isLogicModelDirty() && (bl || pSSysViewPanelLogicBase.getLogicModel() != null)) {
            iDataObject.set(FIELD_LOGICMODEL, (Object)pSSysViewPanelLogicBase.getLogicModel());
        }
        if (pSSysViewPanelLogicBase.isLogicParamDirty() && (bl || pSSysViewPanelLogicBase.getLogicParam() != null)) {
            iDataObject.set(FIELD_LOGICPARAM, (Object)pSSysViewPanelLogicBase.getLogicParam());
        }
        if (pSSysViewPanelLogicBase.isLogicParam2Dirty() && (bl || pSSysViewPanelLogicBase.getLogicParam2() != null)) {
            iDataObject.set(FIELD_LOGICPARAM2, (Object)pSSysViewPanelLogicBase.getLogicParam2());
        }
        if (pSSysViewPanelLogicBase.isLogicTypeDirty() && (bl || pSSysViewPanelLogicBase.getLogicType() != null)) {
            iDataObject.set(FIELD_LOGICTYPE, (Object)pSSysViewPanelLogicBase.getLogicType());
        }
        if (pSSysViewPanelLogicBase.isMemoDirty() && (bl || pSSysViewPanelLogicBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysViewPanelLogicBase.getMemo());
        }
        if (pSSysViewPanelLogicBase.isOrderValueDirty() && (bl || pSSysViewPanelLogicBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSysViewPanelLogicBase.getOrderValue());
        }
        if (pSSysViewPanelLogicBase.isParamPSPanelItemIdDirty() && (bl || pSSysViewPanelLogicBase.getParamPSPanelItemId() != null)) {
            iDataObject.set(FIELD_PARAMPSPANELITEMID, (Object)pSSysViewPanelLogicBase.getParamPSPanelItemId());
        }
        if (pSSysViewPanelLogicBase.isParamPSPanelItemNameDirty() && (bl || pSSysViewPanelLogicBase.getParamPSPanelItemName() != null)) {
            iDataObject.set(FIELD_PARAMPSPANELITEMNAME, (Object)pSSysViewPanelLogicBase.getParamPSPanelItemName());
        }
        if (pSSysViewPanelLogicBase.isPSAppFuncIdDirty() && (bl || pSSysViewPanelLogicBase.getPSAppFuncId() != null)) {
            iDataObject.set(FIELD_PSAPPFUNCID, (Object)pSSysViewPanelLogicBase.getPSAppFuncId());
        }
        if (pSSysViewPanelLogicBase.isPSAppFuncNameDirty() && (bl || pSSysViewPanelLogicBase.getPSAppFuncName() != null)) {
            iDataObject.set(FIELD_PSAPPFUNCNAME, (Object)pSSysViewPanelLogicBase.getPSAppFuncName());
        }
        if (pSSysViewPanelLogicBase.isPSDEIdDirty() && (bl || pSSysViewPanelLogicBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSSysViewPanelLogicBase.getPSDEId());
        }
        if (pSSysViewPanelLogicBase.isPSDELogicIdDirty() && (bl || pSSysViewPanelLogicBase.getPSDELogicId() != null)) {
            iDataObject.set(FIELD_PSDELOGICID, (Object)pSSysViewPanelLogicBase.getPSDELogicId());
        }
        if (pSSysViewPanelLogicBase.isPSDELogicNameDirty() && (bl || pSSysViewPanelLogicBase.getPSDELogicName() != null)) {
            iDataObject.set(FIELD_PSDELOGICNAME, (Object)pSSysViewPanelLogicBase.getPSDELogicName());
        }
        if (pSSysViewPanelLogicBase.isPSDENameDirty() && (bl || pSSysViewPanelLogicBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSSysViewPanelLogicBase.getPSDEName());
        }
        if (pSSysViewPanelLogicBase.isPSDEUIActionIdDirty() && (bl || pSSysViewPanelLogicBase.getPSDEUIActionId() != null)) {
            iDataObject.set(FIELD_PSDEUIACTIONID, (Object)pSSysViewPanelLogicBase.getPSDEUIActionId());
        }
        if (pSSysViewPanelLogicBase.isPSDEUIActionNameDirty() && (bl || pSSysViewPanelLogicBase.getPSDEUIActionName() != null)) {
            iDataObject.set(FIELD_PSDEUIACTIONNAME, (Object)pSSysViewPanelLogicBase.getPSDEUIActionName());
        }
        if (pSSysViewPanelLogicBase.isPSSysPFPluginIdDirty() && (bl || pSSysViewPanelLogicBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSSysViewPanelLogicBase.getPSSysPFPluginId());
        }
        if (pSSysViewPanelLogicBase.isPSSysPFPluginNameDirty() && (bl || pSSysViewPanelLogicBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSSysViewPanelLogicBase.getPSSysPFPluginName());
        }
        if (pSSysViewPanelLogicBase.isPSSystemIdDirty() && (bl || pSSysViewPanelLogicBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysViewPanelLogicBase.getPSSystemId());
        }
        if (pSSysViewPanelLogicBase.isPSSysViewLogicIdDirty() && (bl || pSSysViewPanelLogicBase.getPSSysViewLogicId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWLOGICID, (Object)pSSysViewPanelLogicBase.getPSSysViewLogicId());
        }
        if (pSSysViewPanelLogicBase.isPSSysViewLogicNameDirty() && (bl || pSSysViewPanelLogicBase.getPSSysViewLogicName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWLOGICNAME, (Object)pSSysViewPanelLogicBase.getPSSysViewLogicName());
        }
        if (pSSysViewPanelLogicBase.isPSSysViewPanelIdDirty() && (bl || pSSysViewPanelLogicBase.getPSSysViewPanelId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELID, (Object)pSSysViewPanelLogicBase.getPSSysViewPanelId());
        }
        if (pSSysViewPanelLogicBase.isPSSysViewPanelItemIdDirty() && (bl || pSSysViewPanelLogicBase.getPSSysViewPanelItemId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELITEMID, (Object)pSSysViewPanelLogicBase.getPSSysViewPanelItemId());
        }
        if (pSSysViewPanelLogicBase.isPSSysViewPanelItemNameDirty() && (bl || pSSysViewPanelLogicBase.getPSSysViewPanelItemName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELITEMNAME, (Object)pSSysViewPanelLogicBase.getPSSysViewPanelItemName());
        }
        if (pSSysViewPanelLogicBase.isPSSysViewPanelLogicIdDirty() && (bl || pSSysViewPanelLogicBase.getPSSysViewPanelLogicId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELLOGICID, (Object)pSSysViewPanelLogicBase.getPSSysViewPanelLogicId());
        }
        if (pSSysViewPanelLogicBase.isPSSysViewPanelLogicNameDirty() && (bl || pSSysViewPanelLogicBase.getPSSysViewPanelLogicName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELLOGICNAME, (Object)pSSysViewPanelLogicBase.getPSSysViewPanelLogicName());
        }
        if (pSSysViewPanelLogicBase.isPSSysViewPanelModelIdDirty() && (bl || pSSysViewPanelLogicBase.getPSSysViewPanelModelId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELMODELID, (Object)pSSysViewPanelLogicBase.getPSSysViewPanelModelId());
        }
        if (pSSysViewPanelLogicBase.isPSSysViewPanelModelNameDirty() && (bl || pSSysViewPanelLogicBase.getPSSysViewPanelModelName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELMODELNAME, (Object)pSSysViewPanelLogicBase.getPSSysViewPanelModelName());
        }
        if (pSSysViewPanelLogicBase.isPSSysViewPanelNameDirty() && (bl || pSSysViewPanelLogicBase.getPSSysViewPanelName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELNAME, (Object)pSSysViewPanelLogicBase.getPSSysViewPanelName());
        }
        if (pSSysViewPanelLogicBase.isTimerDirty() && (bl || pSSysViewPanelLogicBase.getTimer() != null)) {
            iDataObject.set(FIELD_TIMER, (Object)pSSysViewPanelLogicBase.getTimer());
        }
        if (pSSysViewPanelLogicBase.isUpdateDateDirty() && (bl || pSSysViewPanelLogicBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysViewPanelLogicBase.getUpdateDate());
        }
        if (pSSysViewPanelLogicBase.isUpdateManDirty() && (bl || pSSysViewPanelLogicBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysViewPanelLogicBase.getUpdateMan());
        }
        if (pSSysViewPanelLogicBase.isValidFlagDirty() && (bl || pSSysViewPanelLogicBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysViewPanelLogicBase.getValidFlag());
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
        return PSSysViewPanelLogicBase.remove(this, n);
    }

    private static boolean remove(PSSysViewPanelLogicBase pSSysViewPanelLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysViewPanelLogicBase.resetAttrName();
                return true;
            }
            case 1: {
                pSSysViewPanelLogicBase.resetCodeName();
                return true;
            }
            case 2: {
                pSSysViewPanelLogicBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSSysViewPanelLogicBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSSysViewPanelLogicBase.resetCtrlEvent();
                return true;
            }
            case 5: {
                pSSysViewPanelLogicBase.resetCtrlEventArg();
                return true;
            }
            case 6: {
                pSSysViewPanelLogicBase.resetCtrlEventArg2();
                return true;
            }
            case 7: {
                pSSysViewPanelLogicBase.resetCtrlEventName();
                return true;
            }
            case 8: {
                pSSysViewPanelLogicBase.resetCustomCode();
                return true;
            }
            case 9: {
                pSSysViewPanelLogicBase.resetDstLogicType();
                return true;
            }
            case 10: {
                pSSysViewPanelLogicBase.resetLayoutPSSysViewPanelId();
                return true;
            }
            case 11: {
                pSSysViewPanelLogicBase.resetLayoutPSSysViewPanelName();
                return true;
            }
            case 12: {
                pSSysViewPanelLogicBase.resetLogicModel();
                return true;
            }
            case 13: {
                pSSysViewPanelLogicBase.resetLogicParam();
                return true;
            }
            case 14: {
                pSSysViewPanelLogicBase.resetLogicParam2();
                return true;
            }
            case 15: {
                pSSysViewPanelLogicBase.resetLogicType();
                return true;
            }
            case 16: {
                pSSysViewPanelLogicBase.resetMemo();
                return true;
            }
            case 17: {
                pSSysViewPanelLogicBase.resetOrderValue();
                return true;
            }
            case 18: {
                pSSysViewPanelLogicBase.resetParamPSPanelItemId();
                return true;
            }
            case 19: {
                pSSysViewPanelLogicBase.resetParamPSPanelItemName();
                return true;
            }
            case 20: {
                pSSysViewPanelLogicBase.resetPSAppFuncId();
                return true;
            }
            case 21: {
                pSSysViewPanelLogicBase.resetPSAppFuncName();
                return true;
            }
            case 22: {
                pSSysViewPanelLogicBase.resetPSDEId();
                return true;
            }
            case 23: {
                pSSysViewPanelLogicBase.resetPSDELogicId();
                return true;
            }
            case 24: {
                pSSysViewPanelLogicBase.resetPSDELogicName();
                return true;
            }
            case 25: {
                pSSysViewPanelLogicBase.resetPSDEName();
                return true;
            }
            case 26: {
                pSSysViewPanelLogicBase.resetPSDEUIActionId();
                return true;
            }
            case 27: {
                pSSysViewPanelLogicBase.resetPSDEUIActionName();
                return true;
            }
            case 28: {
                pSSysViewPanelLogicBase.resetPSSysPFPluginId();
                return true;
            }
            case 29: {
                pSSysViewPanelLogicBase.resetPSSysPFPluginName();
                return true;
            }
            case 30: {
                pSSysViewPanelLogicBase.resetPSSystemId();
                return true;
            }
            case 31: {
                pSSysViewPanelLogicBase.resetPSSysViewLogicId();
                return true;
            }
            case 32: {
                pSSysViewPanelLogicBase.resetPSSysViewLogicName();
                return true;
            }
            case 33: {
                pSSysViewPanelLogicBase.resetPSSysViewPanelId();
                return true;
            }
            case 34: {
                pSSysViewPanelLogicBase.resetPSSysViewPanelItemId();
                return true;
            }
            case 35: {
                pSSysViewPanelLogicBase.resetPSSysViewPanelItemName();
                return true;
            }
            case 36: {
                pSSysViewPanelLogicBase.resetPSSysViewPanelLogicId();
                return true;
            }
            case 37: {
                pSSysViewPanelLogicBase.resetPSSysViewPanelLogicName();
                return true;
            }
            case 38: {
                pSSysViewPanelLogicBase.resetPSSysViewPanelModelId();
                return true;
            }
            case 39: {
                pSSysViewPanelLogicBase.resetPSSysViewPanelModelName();
                return true;
            }
            case 40: {
                pSSysViewPanelLogicBase.resetPSSysViewPanelName();
                return true;
            }
            case 41: {
                pSSysViewPanelLogicBase.resetTimer();
                return true;
            }
            case 42: {
                pSSysViewPanelLogicBase.resetUpdateDate();
                return true;
            }
            case 43: {
                pSSysViewPanelLogicBase.resetUpdateMan();
                return true;
            }
            case 44: {
                pSSysViewPanelLogicBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSAppFunc getPSAppFunc() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppFunc();
        }
        if (this.getPSAppFuncId() == null) {
            return null;
        }
        Integer n = this.objPSAppFuncLock;
        synchronized (n) {
            if (this.psappfunc != null && DataTypeHelper.compare((int)25, (Object)this.getPSAppFuncId(), (Object)this.psappfunc.getPSAppFuncId()) != 0L) {
                this.psappfunc = null;
            }
            if (this.psappfunc == null) {
                PSAppFunc pSAppFunc = new PSAppFunc();
                pSAppFunc.setPSAppFuncId(this.getPSAppFuncId());
                PSAppFuncService pSAppFuncService = (PSAppFuncService)ServiceGlobal.getService(PSAppFuncService.class, (SessionFactory)this.getSessionFactory());
                pSAppFuncService.autoGet((IEntity)pSAppFunc);
                this.psappfunc = pSAppFunc;
            }
            return this.psappfunc;
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
    public PSSysViewPanelItem getParamPSPanelItem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParamPSPanelItem();
        }
        if (this.getParamPSPanelItemId() == null) {
            return null;
        }
        Integer n = this.objParamPSPanelItemLock;
        synchronized (n) {
            if (this.parampspanelitem != null && DataTypeHelper.compare((int)25, (Object)this.getParamPSPanelItemId(), (Object)this.parampspanelitem.getPSSysViewPanelItemId()) != 0L) {
                this.parampspanelitem = null;
            }
            if (this.parampspanelitem == null) {
                PSSysViewPanelItem pSSysViewPanelItem = new PSSysViewPanelItem();
                pSSysViewPanelItem.setPSSysViewPanelItemId(this.getParamPSPanelItemId());
                PSSysViewPanelItemService pSSysViewPanelItemService = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
                pSSysViewPanelItemService.autoGet((IEntity)pSSysViewPanelItem);
                this.parampspanelitem = pSSysViewPanelItem;
            }
            return this.parampspanelitem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysViewPanelItem getPSSysViewPanelItem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewPanelItem();
        }
        if (this.getPSSysViewPanelItemId() == null) {
            return null;
        }
        Integer n = this.objPSSysViewPanelItemLock;
        synchronized (n) {
            if (this.pssysviewpanelitem != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysViewPanelItemId(), (Object)this.pssysviewpanelitem.getPSSysViewPanelItemId()) != 0L) {
                this.pssysviewpanelitem = null;
            }
            if (this.pssysviewpanelitem == null) {
                PSSysViewPanelItem pSSysViewPanelItem = new PSSysViewPanelItem();
                pSSysViewPanelItem.setPSSysViewPanelItemId(this.getPSSysViewPanelItemId());
                PSSysViewPanelItemService pSSysViewPanelItemService = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
                pSSysViewPanelItemService.autoGet((IEntity)pSSysViewPanelItem);
                this.pssysviewpanelitem = pSSysViewPanelItem;
            }
            return this.pssysviewpanelitem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysViewPanelModel getPSSysViewPanelModel() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewPanelModel();
        }
        if (this.getPSSysViewPanelModelId() == null) {
            return null;
        }
        Integer n = this.objPSSysViewPanelModelLock;
        synchronized (n) {
            if (this.pssysviewpanelmodel != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysViewPanelModelId(), (Object)this.pssysviewpanelmodel.getPSSysViewPanelModelId()) != 0L) {
                this.pssysviewpanelmodel = null;
            }
            if (this.pssysviewpanelmodel == null) {
                PSSysViewPanelModel pSSysViewPanelModel = new PSSysViewPanelModel();
                pSSysViewPanelModel.setPSSysViewPanelModelId(this.getPSSysViewPanelModelId());
                PSSysViewPanelModelService pSSysViewPanelModelService = (PSSysViewPanelModelService)ServiceGlobal.getService(PSSysViewPanelModelService.class, (SessionFactory)this.getSessionFactory());
                pSSysViewPanelModelService.autoGet((IEntity)pSSysViewPanelModel);
                this.pssysviewpanelmodel = pSSysViewPanelModel;
            }
            return this.pssysviewpanelmodel;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysViewPanel getLayoutPSSysViewPanel() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLayoutPSSysViewPanel();
        }
        if (this.getLayoutPSSysViewPanelId() == null) {
            return null;
        }
        Integer n = this.objLayoutPSSysViewPanelLock;
        synchronized (n) {
            if (this.layoutpssysviewpanel != null && DataTypeHelper.compare((int)25, (Object)this.getLayoutPSSysViewPanelId(), (Object)this.layoutpssysviewpanel.getPSSysViewPanelId()) != 0L) {
                this.layoutpssysviewpanel = null;
            }
            if (this.layoutpssysviewpanel == null) {
                PSSysViewPanel pSSysViewPanel = new PSSysViewPanel();
                pSSysViewPanel.setPSSysViewPanelId(this.getLayoutPSSysViewPanelId());
                PSSysViewPanelService pSSysViewPanelService = (PSSysViewPanelService)ServiceGlobal.getService(PSSysViewPanelService.class, (SessionFactory)this.getSessionFactory());
                pSSysViewPanelService.autoGet((IEntity)pSSysViewPanel);
                this.layoutpssysviewpanel = pSSysViewPanel;
            }
            return this.layoutpssysviewpanel;
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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSPanelLogicLink> getPSPanelLogicLinks() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPanelLogicLinks();
        }
        if (this.getPSSysViewPanelLogicId() == null) {
            return null;
        }
        PSSysViewPanelLogicService pSSysViewPanelLogicService = (PSSysViewPanelLogicService)ServiceGlobal.getService(PSSysViewPanelLogicService.class, (SessionFactory)this.getSessionFactory());
        PSPanelLogicLinkService pSPanelLogicLinkService = (PSPanelLogicLinkService)ServiceGlobal.getService(PSPanelLogicLinkService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSPanelLogicLinksLock;
        synchronized (n) {
            if (this.pspanellogiclinks == null) {
                this.pspanellogiclinks = pSSysViewPanelLogicService.isTempData((IEntity)this) ? pSPanelLogicLinkService.selectTempByPSSysViewPanelLogic(this) : pSPanelLogicLinkService.selectByPSSysViewPanelLogic(this);
            }
            return this.pspanellogiclinks;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSPanelLogicNode> getPSPanelLogicNodes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPanelLogicNodes();
        }
        if (this.getPSSysViewPanelLogicId() == null) {
            return null;
        }
        PSSysViewPanelLogicService pSSysViewPanelLogicService = (PSSysViewPanelLogicService)ServiceGlobal.getService(PSSysViewPanelLogicService.class, (SessionFactory)this.getSessionFactory());
        PSPanelLogicNodeService pSPanelLogicNodeService = (PSPanelLogicNodeService)ServiceGlobal.getService(PSPanelLogicNodeService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSPanelLogicNodesLock;
        synchronized (n) {
            if (this.pspanellogicnodes == null) {
                this.pspanellogicnodes = pSSysViewPanelLogicService.isTempData((IEntity)this) ? pSPanelLogicNodeService.selectTempByPSSysViewPanelLogic(this) : pSPanelLogicNodeService.selectByPSSysViewPanelLogic(this);
            }
            return this.pspanellogicnodes;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSPanelLogicParam> getPSPanelLogicParams() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPanelLogicParams();
        }
        if (this.getPSSysViewPanelLogicId() == null) {
            return null;
        }
        PSSysViewPanelLogicService pSSysViewPanelLogicService = (PSSysViewPanelLogicService)ServiceGlobal.getService(PSSysViewPanelLogicService.class, (SessionFactory)this.getSessionFactory());
        PSPanelLogicParamService pSPanelLogicParamService = (PSPanelLogicParamService)ServiceGlobal.getService(PSPanelLogicParamService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSPanelLogicParamsLock;
        synchronized (n) {
            if (this.pspanellogicparams == null) {
                this.pspanellogicparams = pSSysViewPanelLogicService.isTempData((IEntity)this) ? pSPanelLogicParamService.selectTempByPSSysViewPanelLogic(this) : pSPanelLogicParamService.selectByPSSysViewPanelLogic(this);
            }
            return this.pspanellogicparams;
        }
    }

    private PSSysViewPanelLogicBase getProxyEntity() {
        return this.proxyPSSysViewPanelLogicBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysViewPanelLogicBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysViewPanelLogicBase) {
            this.proxyPSSysViewPanelLogicBase = (PSSysViewPanelLogicBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelLogicService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ATTRNAME, 0);
        fieldIndexMap.put(FIELD_CODENAME, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_CTRLEVENT, 4);
        fieldIndexMap.put(FIELD_CTRLEVENTARG, 5);
        fieldIndexMap.put(FIELD_CTRLEVENTARG2, 6);
        fieldIndexMap.put(FIELD_CTRLEVENTNAME, 7);
        fieldIndexMap.put(FIELD_CUSTOMCODE, 8);
        fieldIndexMap.put(FIELD_DSTLOGICTYPE, 9);
        fieldIndexMap.put(FIELD_LAYOUTPSSYSVIEWPANELID, 10);
        fieldIndexMap.put(FIELD_LAYOUTPSSYSVIEWPANELNAME, 11);
        fieldIndexMap.put(FIELD_LOGICMODEL, 12);
        fieldIndexMap.put(FIELD_LOGICPARAM, 13);
        fieldIndexMap.put(FIELD_LOGICPARAM2, 14);
        fieldIndexMap.put(FIELD_LOGICTYPE, 15);
        fieldIndexMap.put(FIELD_MEMO, 16);
        fieldIndexMap.put(FIELD_ORDERVALUE, 17);
        fieldIndexMap.put(FIELD_PARAMPSPANELITEMID, 18);
        fieldIndexMap.put(FIELD_PARAMPSPANELITEMNAME, 19);
        fieldIndexMap.put(FIELD_PSAPPFUNCID, 20);
        fieldIndexMap.put(FIELD_PSAPPFUNCNAME, 21);
        fieldIndexMap.put(FIELD_PSDEID, 22);
        fieldIndexMap.put(FIELD_PSDELOGICID, 23);
        fieldIndexMap.put(FIELD_PSDELOGICNAME, 24);
        fieldIndexMap.put(FIELD_PSDENAME, 25);
        fieldIndexMap.put(FIELD_PSDEUIACTIONID, 26);
        fieldIndexMap.put(FIELD_PSDEUIACTIONNAME, 27);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINID, 28);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINNAME, 29);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 30);
        fieldIndexMap.put(FIELD_PSSYSVIEWLOGICID, 31);
        fieldIndexMap.put(FIELD_PSSYSVIEWLOGICNAME, 32);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELID, 33);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELITEMID, 34);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELITEMNAME, 35);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELLOGICID, 36);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELLOGICNAME, 37);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELMODELID, 38);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELMODELNAME, 39);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELNAME, 40);
        fieldIndexMap.put(FIELD_TIMER, 41);
        fieldIndexMap.put(FIELD_UPDATEDATE, 42);
        fieldIndexMap.put(FIELD_UPDATEMAN, 43);
        fieldIndexMap.put(FIELD_VALIDFLAG, 44);
    }
}

