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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEWizard;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEWizardForm;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEWizardStep;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEWizardFormService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEWizardService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEWizardStepService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewLogic;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewLogicService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEWizardLogicBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEWizardLogicBase.class);
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
    public static final String FIELD_PSDEWIZARDFORMID = "PSDEWIZARDFORMID";
    public static final String FIELD_PSDEWIZARDFORMNAME = "PSDEWIZARDFORMNAME";
    public static final String FIELD_PSDEWIZARDID = "PSDEWIZARDID";
    public static final String FIELD_PSDEWIZARDLOGICID = "PSDEWIZARDLOGICID";
    public static final String FIELD_PSDEWIZARDLOGICNAME = "PSDEWIZARDLOGICNAME";
    public static final String FIELD_PSDEWIZARDNAME = "PSDEWIZARDNAME";
    public static final String FIELD_PSDEWIZARDSTEPID = "PSDEWIZARDSTEPID";
    public static final String FIELD_PSDEWIZARDSTEPNAME = "PSDEWIZARDSTEPNAME";
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
    private static final int INDEX_PSDEWIZARDFORMID = 18;
    private static final int INDEX_PSDEWIZARDFORMNAME = 19;
    private static final int INDEX_PSDEWIZARDID = 20;
    private static final int INDEX_PSDEWIZARDLOGICID = 21;
    private static final int INDEX_PSDEWIZARDLOGICNAME = 22;
    private static final int INDEX_PSDEWIZARDNAME = 23;
    private static final int INDEX_PSDEWIZARDSTEPID = 24;
    private static final int INDEX_PSDEWIZARDSTEPNAME = 25;
    private static final int INDEX_PSSYSPFPLUGINID = 26;
    private static final int INDEX_PSSYSPFPLUGINNAME = 27;
    private static final int INDEX_PSSYSVIEWLOGICID = 28;
    private static final int INDEX_PSSYSVIEWLOGICNAME = 29;
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
    private PSDEWizardLogicBase proxyPSDEWizardLogicBase = null;
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
    private boolean psdewizardformidDirtyFlag = false;
    private boolean psdewizardformnameDirtyFlag = false;
    private boolean psdewizardidDirtyFlag = false;
    private boolean psdewizardlogicidDirtyFlag = false;
    private boolean psdewizardlogicnameDirtyFlag = false;
    private boolean psdewizardnameDirtyFlag = false;
    private boolean psdewizardstepidDirtyFlag = false;
    private boolean psdewizardstepnameDirtyFlag = false;
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
    @Column(name="psdewizardformid")
    private String psdewizardformid;
    @Column(name="psdewizardformname")
    private String psdewizardformname;
    @Column(name="psdewizardid")
    private String psdewizardid;
    @Column(name="psdewizardlogicid")
    private String psdewizardlogicid;
    @Column(name="psdewizardlogicname")
    private String psdewizardlogicname;
    @Column(name="psdewizardname")
    private String psdewizardname;
    @Column(name="psdewizardstepid")
    private String psdewizardstepid;
    @Column(name="psdewizardstepname")
    private String psdewizardstepname;
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
    private Integer objPSDEWizardFormLock = new Integer(1);
    private PSDEWizardForm psdewizardform = null;
    private Integer objPSDEWizardStepLock = new Integer(1);
    private PSDEWizardStep psdewizardstep = null;
    private Integer objPSDEWizardLock = new Integer(1);
    private PSDEWizard psdewizard = null;
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

    public void setPSDEWizardFormId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEWizardFormId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdewizardformid = string;
        this.psdewizardformidDirtyFlag = true;
    }

    public String getPSDEWizardFormId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEWizardFormId();
        }
        return this.psdewizardformid;
    }

    public boolean isPSDEWizardFormIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEWizardFormIdDirty();
        }
        return this.psdewizardformidDirtyFlag;
    }

    public void resetPSDEWizardFormId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEWizardFormId();
            return;
        }
        this.psdewizardformidDirtyFlag = false;
        this.psdewizardformid = null;
    }

    public void setPSDEWizardFormName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEWizardFormName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdewizardformname = string;
        this.psdewizardformnameDirtyFlag = true;
    }

    public String getPSDEWizardFormName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEWizardFormName();
        }
        return this.psdewizardformname;
    }

    public boolean isPSDEWizardFormNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEWizardFormNameDirty();
        }
        return this.psdewizardformnameDirtyFlag;
    }

    public void resetPSDEWizardFormName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEWizardFormName();
            return;
        }
        this.psdewizardformnameDirtyFlag = false;
        this.psdewizardformname = null;
    }

    public void setPSDEWizardId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEWizardId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdewizardid = string;
        this.psdewizardidDirtyFlag = true;
    }

    public String getPSDEWizardId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEWizardId();
        }
        return this.psdewizardid;
    }

    public boolean isPSDEWizardIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEWizardIdDirty();
        }
        return this.psdewizardidDirtyFlag;
    }

    public void resetPSDEWizardId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEWizardId();
            return;
        }
        this.psdewizardidDirtyFlag = false;
        this.psdewizardid = null;
    }

    public void setPSDEWizardLogicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEWizardLogicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdewizardlogicid = string;
        this.psdewizardlogicidDirtyFlag = true;
    }

    public String getPSDEWizardLogicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEWizardLogicId();
        }
        return this.psdewizardlogicid;
    }

    public boolean isPSDEWizardLogicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEWizardLogicIdDirty();
        }
        return this.psdewizardlogicidDirtyFlag;
    }

    public void resetPSDEWizardLogicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEWizardLogicId();
            return;
        }
        this.psdewizardlogicidDirtyFlag = false;
        this.psdewizardlogicid = null;
    }

    public void setPSDEWizardLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEWizardLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdewizardlogicname = string;
        this.psdewizardlogicnameDirtyFlag = true;
    }

    public String getPSDEWizardLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEWizardLogicName();
        }
        return this.psdewizardlogicname;
    }

    public boolean isPSDEWizardLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEWizardLogicNameDirty();
        }
        return this.psdewizardlogicnameDirtyFlag;
    }

    public void resetPSDEWizardLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEWizardLogicName();
            return;
        }
        this.psdewizardlogicnameDirtyFlag = false;
        this.psdewizardlogicname = null;
    }

    public void setPSDEWizardName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEWizardName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdewizardname = string;
        this.psdewizardnameDirtyFlag = true;
    }

    public String getPSDEWizardName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEWizardName();
        }
        return this.psdewizardname;
    }

    public boolean isPSDEWizardNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEWizardNameDirty();
        }
        return this.psdewizardnameDirtyFlag;
    }

    public void resetPSDEWizardName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEWizardName();
            return;
        }
        this.psdewizardnameDirtyFlag = false;
        this.psdewizardname = null;
    }

    public void setPSDEWizardStepId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEWizardStepId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdewizardstepid = string;
        this.psdewizardstepidDirtyFlag = true;
    }

    public String getPSDEWizardStepId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEWizardStepId();
        }
        return this.psdewizardstepid;
    }

    public boolean isPSDEWizardStepIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEWizardStepIdDirty();
        }
        return this.psdewizardstepidDirtyFlag;
    }

    public void resetPSDEWizardStepId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEWizardStepId();
            return;
        }
        this.psdewizardstepidDirtyFlag = false;
        this.psdewizardstepid = null;
    }

    public void setPSDEWizardStepName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEWizardStepName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdewizardstepname = string;
        this.psdewizardstepnameDirtyFlag = true;
    }

    public String getPSDEWizardStepName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEWizardStepName();
        }
        return this.psdewizardstepname;
    }

    public boolean isPSDEWizardStepNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEWizardStepNameDirty();
        }
        return this.psdewizardstepnameDirtyFlag;
    }

    public void resetPSDEWizardStepName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEWizardStepName();
            return;
        }
        this.psdewizardstepnameDirtyFlag = false;
        this.psdewizardstepname = null;
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
        PSDEWizardLogicBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEWizardLogicBase pSDEWizardLogicBase) {
        pSDEWizardLogicBase.resetAttrName();
        pSDEWizardLogicBase.resetCreateDate();
        pSDEWizardLogicBase.resetCreateMan();
        pSDEWizardLogicBase.resetCustomCode();
        pSDEWizardLogicBase.resetDstLogicType();
        pSDEWizardLogicBase.resetEventArg();
        pSDEWizardLogicBase.resetEventArg2();
        pSDEWizardLogicBase.resetEventNames();
        pSDEWizardLogicBase.resetLogicParam();
        pSDEWizardLogicBase.resetLogicParam2();
        pSDEWizardLogicBase.resetMemo();
        pSDEWizardLogicBase.resetOrderValue();
        pSDEWizardLogicBase.resetPSDEId();
        pSDEWizardLogicBase.resetPSDELogicId();
        pSDEWizardLogicBase.resetPSDELogicName();
        pSDEWizardLogicBase.resetPSDEName();
        pSDEWizardLogicBase.resetPSDEUIActionId();
        pSDEWizardLogicBase.resetPSDEUIActionName();
        pSDEWizardLogicBase.resetPSDEWizardFormId();
        pSDEWizardLogicBase.resetPSDEWizardFormName();
        pSDEWizardLogicBase.resetPSDEWizardId();
        pSDEWizardLogicBase.resetPSDEWizardLogicId();
        pSDEWizardLogicBase.resetPSDEWizardLogicName();
        pSDEWizardLogicBase.resetPSDEWizardName();
        pSDEWizardLogicBase.resetPSDEWizardStepId();
        pSDEWizardLogicBase.resetPSDEWizardStepName();
        pSDEWizardLogicBase.resetPSSysPFPluginId();
        pSDEWizardLogicBase.resetPSSysPFPluginName();
        pSDEWizardLogicBase.resetPSSysViewLogicId();
        pSDEWizardLogicBase.resetPSSysViewLogicName();
        pSDEWizardLogicBase.resetTimer();
        pSDEWizardLogicBase.resetTriggerType();
        pSDEWizardLogicBase.resetUpdateDate();
        pSDEWizardLogicBase.resetUpdateMan();
        pSDEWizardLogicBase.resetUserCat();
        pSDEWizardLogicBase.resetUserTag();
        pSDEWizardLogicBase.resetUserTag2();
        pSDEWizardLogicBase.resetUserTag3();
        pSDEWizardLogicBase.resetUserTag4();
        pSDEWizardLogicBase.resetValidFlag();
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
        if (!bl || this.isPSDEWizardFormIdDirty()) {
            hashMap.put(FIELD_PSDEWIZARDFORMID, this.getPSDEWizardFormId());
        }
        if (!bl || this.isPSDEWizardFormNameDirty()) {
            hashMap.put(FIELD_PSDEWIZARDFORMNAME, this.getPSDEWizardFormName());
        }
        if (!bl || this.isPSDEWizardIdDirty()) {
            hashMap.put(FIELD_PSDEWIZARDID, this.getPSDEWizardId());
        }
        if (!bl || this.isPSDEWizardLogicIdDirty()) {
            hashMap.put(FIELD_PSDEWIZARDLOGICID, this.getPSDEWizardLogicId());
        }
        if (!bl || this.isPSDEWizardLogicNameDirty()) {
            hashMap.put(FIELD_PSDEWIZARDLOGICNAME, this.getPSDEWizardLogicName());
        }
        if (!bl || this.isPSDEWizardNameDirty()) {
            hashMap.put(FIELD_PSDEWIZARDNAME, this.getPSDEWizardName());
        }
        if (!bl || this.isPSDEWizardStepIdDirty()) {
            hashMap.put(FIELD_PSDEWIZARDSTEPID, this.getPSDEWizardStepId());
        }
        if (!bl || this.isPSDEWizardStepNameDirty()) {
            hashMap.put(FIELD_PSDEWIZARDSTEPNAME, this.getPSDEWizardStepName());
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
        return PSDEWizardLogicBase.get(this, n);
    }

    private static Object get(PSDEWizardLogicBase pSDEWizardLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEWizardLogicBase.getAttrName();
            }
            case 1: {
                return pSDEWizardLogicBase.getCreateDate();
            }
            case 2: {
                return pSDEWizardLogicBase.getCreateMan();
            }
            case 3: {
                return pSDEWizardLogicBase.getCustomCode();
            }
            case 4: {
                return pSDEWizardLogicBase.getDstLogicType();
            }
            case 5: {
                return pSDEWizardLogicBase.getEventArg();
            }
            case 6: {
                return pSDEWizardLogicBase.getEventArg2();
            }
            case 7: {
                return pSDEWizardLogicBase.getEventNames();
            }
            case 8: {
                return pSDEWizardLogicBase.getLogicParam();
            }
            case 9: {
                return pSDEWizardLogicBase.getLogicParam2();
            }
            case 10: {
                return pSDEWizardLogicBase.getMemo();
            }
            case 11: {
                return pSDEWizardLogicBase.getOrderValue();
            }
            case 12: {
                return pSDEWizardLogicBase.getPSDEId();
            }
            case 13: {
                return pSDEWizardLogicBase.getPSDELogicId();
            }
            case 14: {
                return pSDEWizardLogicBase.getPSDELogicName();
            }
            case 15: {
                return pSDEWizardLogicBase.getPSDEName();
            }
            case 16: {
                return pSDEWizardLogicBase.getPSDEUIActionId();
            }
            case 17: {
                return pSDEWizardLogicBase.getPSDEUIActionName();
            }
            case 18: {
                return pSDEWizardLogicBase.getPSDEWizardFormId();
            }
            case 19: {
                return pSDEWizardLogicBase.getPSDEWizardFormName();
            }
            case 20: {
                return pSDEWizardLogicBase.getPSDEWizardId();
            }
            case 21: {
                return pSDEWizardLogicBase.getPSDEWizardLogicId();
            }
            case 22: {
                return pSDEWizardLogicBase.getPSDEWizardLogicName();
            }
            case 23: {
                return pSDEWizardLogicBase.getPSDEWizardName();
            }
            case 24: {
                return pSDEWizardLogicBase.getPSDEWizardStepId();
            }
            case 25: {
                return pSDEWizardLogicBase.getPSDEWizardStepName();
            }
            case 26: {
                return pSDEWizardLogicBase.getPSSysPFPluginId();
            }
            case 27: {
                return pSDEWizardLogicBase.getPSSysPFPluginName();
            }
            case 28: {
                return pSDEWizardLogicBase.getPSSysViewLogicId();
            }
            case 29: {
                return pSDEWizardLogicBase.getPSSysViewLogicName();
            }
            case 30: {
                return pSDEWizardLogicBase.getTimer();
            }
            case 31: {
                return pSDEWizardLogicBase.getTriggerType();
            }
            case 32: {
                return pSDEWizardLogicBase.getUpdateDate();
            }
            case 33: {
                return pSDEWizardLogicBase.getUpdateMan();
            }
            case 34: {
                return pSDEWizardLogicBase.getUserCat();
            }
            case 35: {
                return pSDEWizardLogicBase.getUserTag();
            }
            case 36: {
                return pSDEWizardLogicBase.getUserTag2();
            }
            case 37: {
                return pSDEWizardLogicBase.getUserTag3();
            }
            case 38: {
                return pSDEWizardLogicBase.getUserTag4();
            }
            case 39: {
                return pSDEWizardLogicBase.getValidFlag();
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
        PSDEWizardLogicBase.set(this, n, object);
    }

    private static void set(PSDEWizardLogicBase pSDEWizardLogicBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEWizardLogicBase.setAttrName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDEWizardLogicBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDEWizardLogicBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEWizardLogicBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEWizardLogicBase.setDstLogicType(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEWizardLogicBase.setEventArg(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEWizardLogicBase.setEventArg2(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEWizardLogicBase.setEventNames(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEWizardLogicBase.setLogicParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEWizardLogicBase.setLogicParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEWizardLogicBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEWizardLogicBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSDEWizardLogicBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEWizardLogicBase.setPSDELogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEWizardLogicBase.setPSDELogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEWizardLogicBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEWizardLogicBase.setPSDEUIActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEWizardLogicBase.setPSDEUIActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEWizardLogicBase.setPSDEWizardFormId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEWizardLogicBase.setPSDEWizardFormName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDEWizardLogicBase.setPSDEWizardId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEWizardLogicBase.setPSDEWizardLogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDEWizardLogicBase.setPSDEWizardLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDEWizardLogicBase.setPSDEWizardName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDEWizardLogicBase.setPSDEWizardStepId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDEWizardLogicBase.setPSDEWizardStepName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDEWizardLogicBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDEWizardLogicBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDEWizardLogicBase.setPSSysViewLogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDEWizardLogicBase.setPSSysViewLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDEWizardLogicBase.setTimer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 31: {
                pSDEWizardLogicBase.setTriggerType(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDEWizardLogicBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 33: {
                pSDEWizardLogicBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDEWizardLogicBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDEWizardLogicBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDEWizardLogicBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSDEWizardLogicBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDEWizardLogicBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSDEWizardLogicBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDEWizardLogicBase.isNull(this, n);
    }

    private static boolean isNull(PSDEWizardLogicBase pSDEWizardLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEWizardLogicBase.getAttrName() == null;
            }
            case 1: {
                return pSDEWizardLogicBase.getCreateDate() == null;
            }
            case 2: {
                return pSDEWizardLogicBase.getCreateMan() == null;
            }
            case 3: {
                return pSDEWizardLogicBase.getCustomCode() == null;
            }
            case 4: {
                return pSDEWizardLogicBase.getDstLogicType() == null;
            }
            case 5: {
                return pSDEWizardLogicBase.getEventArg() == null;
            }
            case 6: {
                return pSDEWizardLogicBase.getEventArg2() == null;
            }
            case 7: {
                return pSDEWizardLogicBase.getEventNames() == null;
            }
            case 8: {
                return pSDEWizardLogicBase.getLogicParam() == null;
            }
            case 9: {
                return pSDEWizardLogicBase.getLogicParam2() == null;
            }
            case 10: {
                return pSDEWizardLogicBase.getMemo() == null;
            }
            case 11: {
                return pSDEWizardLogicBase.getOrderValue() == null;
            }
            case 12: {
                return pSDEWizardLogicBase.getPSDEId() == null;
            }
            case 13: {
                return pSDEWizardLogicBase.getPSDELogicId() == null;
            }
            case 14: {
                return pSDEWizardLogicBase.getPSDELogicName() == null;
            }
            case 15: {
                return pSDEWizardLogicBase.getPSDEName() == null;
            }
            case 16: {
                return pSDEWizardLogicBase.getPSDEUIActionId() == null;
            }
            case 17: {
                return pSDEWizardLogicBase.getPSDEUIActionName() == null;
            }
            case 18: {
                return pSDEWizardLogicBase.getPSDEWizardFormId() == null;
            }
            case 19: {
                return pSDEWizardLogicBase.getPSDEWizardFormName() == null;
            }
            case 20: {
                return pSDEWizardLogicBase.getPSDEWizardId() == null;
            }
            case 21: {
                return pSDEWizardLogicBase.getPSDEWizardLogicId() == null;
            }
            case 22: {
                return pSDEWizardLogicBase.getPSDEWizardLogicName() == null;
            }
            case 23: {
                return pSDEWizardLogicBase.getPSDEWizardName() == null;
            }
            case 24: {
                return pSDEWizardLogicBase.getPSDEWizardStepId() == null;
            }
            case 25: {
                return pSDEWizardLogicBase.getPSDEWizardStepName() == null;
            }
            case 26: {
                return pSDEWizardLogicBase.getPSSysPFPluginId() == null;
            }
            case 27: {
                return pSDEWizardLogicBase.getPSSysPFPluginName() == null;
            }
            case 28: {
                return pSDEWizardLogicBase.getPSSysViewLogicId() == null;
            }
            case 29: {
                return pSDEWizardLogicBase.getPSSysViewLogicName() == null;
            }
            case 30: {
                return pSDEWizardLogicBase.getTimer() == null;
            }
            case 31: {
                return pSDEWizardLogicBase.getTriggerType() == null;
            }
            case 32: {
                return pSDEWizardLogicBase.getUpdateDate() == null;
            }
            case 33: {
                return pSDEWizardLogicBase.getUpdateMan() == null;
            }
            case 34: {
                return pSDEWizardLogicBase.getUserCat() == null;
            }
            case 35: {
                return pSDEWizardLogicBase.getUserTag() == null;
            }
            case 36: {
                return pSDEWizardLogicBase.getUserTag2() == null;
            }
            case 37: {
                return pSDEWizardLogicBase.getUserTag3() == null;
            }
            case 38: {
                return pSDEWizardLogicBase.getUserTag4() == null;
            }
            case 39: {
                return pSDEWizardLogicBase.getValidFlag() == null;
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
        return PSDEWizardLogicBase.contains(this, n);
    }

    private static boolean contains(PSDEWizardLogicBase pSDEWizardLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEWizardLogicBase.isAttrNameDirty();
            }
            case 1: {
                return pSDEWizardLogicBase.isCreateDateDirty();
            }
            case 2: {
                return pSDEWizardLogicBase.isCreateManDirty();
            }
            case 3: {
                return pSDEWizardLogicBase.isCustomCodeDirty();
            }
            case 4: {
                return pSDEWizardLogicBase.isDstLogicTypeDirty();
            }
            case 5: {
                return pSDEWizardLogicBase.isEventArgDirty();
            }
            case 6: {
                return pSDEWizardLogicBase.isEventArg2Dirty();
            }
            case 7: {
                return pSDEWizardLogicBase.isEventNamesDirty();
            }
            case 8: {
                return pSDEWizardLogicBase.isLogicParamDirty();
            }
            case 9: {
                return pSDEWizardLogicBase.isLogicParam2Dirty();
            }
            case 10: {
                return pSDEWizardLogicBase.isMemoDirty();
            }
            case 11: {
                return pSDEWizardLogicBase.isOrderValueDirty();
            }
            case 12: {
                return pSDEWizardLogicBase.isPSDEIdDirty();
            }
            case 13: {
                return pSDEWizardLogicBase.isPSDELogicIdDirty();
            }
            case 14: {
                return pSDEWizardLogicBase.isPSDELogicNameDirty();
            }
            case 15: {
                return pSDEWizardLogicBase.isPSDENameDirty();
            }
            case 16: {
                return pSDEWizardLogicBase.isPSDEUIActionIdDirty();
            }
            case 17: {
                return pSDEWizardLogicBase.isPSDEUIActionNameDirty();
            }
            case 18: {
                return pSDEWizardLogicBase.isPSDEWizardFormIdDirty();
            }
            case 19: {
                return pSDEWizardLogicBase.isPSDEWizardFormNameDirty();
            }
            case 20: {
                return pSDEWizardLogicBase.isPSDEWizardIdDirty();
            }
            case 21: {
                return pSDEWizardLogicBase.isPSDEWizardLogicIdDirty();
            }
            case 22: {
                return pSDEWizardLogicBase.isPSDEWizardLogicNameDirty();
            }
            case 23: {
                return pSDEWizardLogicBase.isPSDEWizardNameDirty();
            }
            case 24: {
                return pSDEWizardLogicBase.isPSDEWizardStepIdDirty();
            }
            case 25: {
                return pSDEWizardLogicBase.isPSDEWizardStepNameDirty();
            }
            case 26: {
                return pSDEWizardLogicBase.isPSSysPFPluginIdDirty();
            }
            case 27: {
                return pSDEWizardLogicBase.isPSSysPFPluginNameDirty();
            }
            case 28: {
                return pSDEWizardLogicBase.isPSSysViewLogicIdDirty();
            }
            case 29: {
                return pSDEWizardLogicBase.isPSSysViewLogicNameDirty();
            }
            case 30: {
                return pSDEWizardLogicBase.isTimerDirty();
            }
            case 31: {
                return pSDEWizardLogicBase.isTriggerTypeDirty();
            }
            case 32: {
                return pSDEWizardLogicBase.isUpdateDateDirty();
            }
            case 33: {
                return pSDEWizardLogicBase.isUpdateManDirty();
            }
            case 34: {
                return pSDEWizardLogicBase.isUserCatDirty();
            }
            case 35: {
                return pSDEWizardLogicBase.isUserTagDirty();
            }
            case 36: {
                return pSDEWizardLogicBase.isUserTag2Dirty();
            }
            case 37: {
                return pSDEWizardLogicBase.isUserTag3Dirty();
            }
            case 38: {
                return pSDEWizardLogicBase.isUserTag4Dirty();
            }
            case 39: {
                return pSDEWizardLogicBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEWizardLogicBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEWizardLogicBase pSDEWizardLogicBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEWizardLogicBase.getAttrName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"attrname", (Object)PSDEWizardLogicBase.getJSONValue((Object)pSDEWizardLogicBase.getAttrName()), (boolean)false);
        }
        if (bl || pSDEWizardLogicBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEWizardLogicBase.getJSONValue((Object)pSDEWizardLogicBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEWizardLogicBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEWizardLogicBase.getJSONValue((Object)pSDEWizardLogicBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEWizardLogicBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSDEWizardLogicBase.getJSONValue((Object)pSDEWizardLogicBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSDEWizardLogicBase.getDstLogicType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstlogictype", (Object)PSDEWizardLogicBase.getJSONValue((Object)pSDEWizardLogicBase.getDstLogicType()), (boolean)false);
        }
        if (bl || pSDEWizardLogicBase.getEventArg() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eventarg", (Object)PSDEWizardLogicBase.getJSONValue((Object)pSDEWizardLogicBase.getEventArg()), (boolean)false);
        }
        if (bl || pSDEWizardLogicBase.getEventArg2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eventarg2", (Object)PSDEWizardLogicBase.getJSONValue((Object)pSDEWizardLogicBase.getEventArg2()), (boolean)false);
        }
        if (bl || pSDEWizardLogicBase.getEventNames() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eventnames", (Object)PSDEWizardLogicBase.getJSONValue((Object)pSDEWizardLogicBase.getEventNames()), (boolean)false);
        }
        if (bl || pSDEWizardLogicBase.getLogicParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicparam", (Object)PSDEWizardLogicBase.getJSONValue((Object)pSDEWizardLogicBase.getLogicParam()), (boolean)false);
        }
        if (bl || pSDEWizardLogicBase.getLogicParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicparam2", (Object)PSDEWizardLogicBase.getJSONValue((Object)pSDEWizardLogicBase.getLogicParam2()), (boolean)false);
        }
        if (bl || pSDEWizardLogicBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEWizardLogicBase.getJSONValue((Object)pSDEWizardLogicBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEWizardLogicBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDEWizardLogicBase.getJSONValue((Object)pSDEWizardLogicBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDEWizardLogicBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEWizardLogicBase.getJSONValue((Object)pSDEWizardLogicBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEWizardLogicBase.getPSDELogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicid", (Object)PSDEWizardLogicBase.getJSONValue((Object)pSDEWizardLogicBase.getPSDELogicId()), (boolean)false);
        }
        if (bl || pSDEWizardLogicBase.getPSDELogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicname", (Object)PSDEWizardLogicBase.getJSONValue((Object)pSDEWizardLogicBase.getPSDELogicName()), (boolean)false);
        }
        if (bl || pSDEWizardLogicBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDEWizardLogicBase.getJSONValue((Object)pSDEWizardLogicBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDEWizardLogicBase.getPSDEUIActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuiactionid", (Object)PSDEWizardLogicBase.getJSONValue((Object)pSDEWizardLogicBase.getPSDEUIActionId()), (boolean)false);
        }
        if (bl || pSDEWizardLogicBase.getPSDEUIActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuiactionname", (Object)PSDEWizardLogicBase.getJSONValue((Object)pSDEWizardLogicBase.getPSDEUIActionName()), (boolean)false);
        }
        if (bl || pSDEWizardLogicBase.getPSDEWizardFormId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdewizardformid", (Object)PSDEWizardLogicBase.getJSONValue((Object)pSDEWizardLogicBase.getPSDEWizardFormId()), (boolean)false);
        }
        if (bl || pSDEWizardLogicBase.getPSDEWizardFormName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdewizardformname", (Object)PSDEWizardLogicBase.getJSONValue((Object)pSDEWizardLogicBase.getPSDEWizardFormName()), (boolean)false);
        }
        if (bl || pSDEWizardLogicBase.getPSDEWizardId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdewizardid", (Object)PSDEWizardLogicBase.getJSONValue((Object)pSDEWizardLogicBase.getPSDEWizardId()), (boolean)false);
        }
        if (bl || pSDEWizardLogicBase.getPSDEWizardLogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdewizardlogicid", (Object)PSDEWizardLogicBase.getJSONValue((Object)pSDEWizardLogicBase.getPSDEWizardLogicId()), (boolean)false);
        }
        if (bl || pSDEWizardLogicBase.getPSDEWizardLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdewizardlogicname", (Object)PSDEWizardLogicBase.getJSONValue((Object)pSDEWizardLogicBase.getPSDEWizardLogicName()), (boolean)false);
        }
        if (bl || pSDEWizardLogicBase.getPSDEWizardName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdewizardname", (Object)PSDEWizardLogicBase.getJSONValue((Object)pSDEWizardLogicBase.getPSDEWizardName()), (boolean)false);
        }
        if (bl || pSDEWizardLogicBase.getPSDEWizardStepId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdewizardstepid", (Object)PSDEWizardLogicBase.getJSONValue((Object)pSDEWizardLogicBase.getPSDEWizardStepId()), (boolean)false);
        }
        if (bl || pSDEWizardLogicBase.getPSDEWizardStepName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdewizardstepname", (Object)PSDEWizardLogicBase.getJSONValue((Object)pSDEWizardLogicBase.getPSDEWizardStepName()), (boolean)false);
        }
        if (bl || pSDEWizardLogicBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSDEWizardLogicBase.getJSONValue((Object)pSDEWizardLogicBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSDEWizardLogicBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSDEWizardLogicBase.getJSONValue((Object)pSDEWizardLogicBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSDEWizardLogicBase.getPSSysViewLogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewlogicid", (Object)PSDEWizardLogicBase.getJSONValue((Object)pSDEWizardLogicBase.getPSSysViewLogicId()), (boolean)false);
        }
        if (bl || pSDEWizardLogicBase.getPSSysViewLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewlogicname", (Object)PSDEWizardLogicBase.getJSONValue((Object)pSDEWizardLogicBase.getPSSysViewLogicName()), (boolean)false);
        }
        if (bl || pSDEWizardLogicBase.getTimer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"timer", (Object)PSDEWizardLogicBase.getJSONValue((Object)pSDEWizardLogicBase.getTimer()), (boolean)false);
        }
        if (bl || pSDEWizardLogicBase.getTriggerType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"triggertype", (Object)PSDEWizardLogicBase.getJSONValue((Object)pSDEWizardLogicBase.getTriggerType()), (boolean)false);
        }
        if (bl || pSDEWizardLogicBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEWizardLogicBase.getJSONValue((Object)pSDEWizardLogicBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEWizardLogicBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEWizardLogicBase.getJSONValue((Object)pSDEWizardLogicBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEWizardLogicBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEWizardLogicBase.getJSONValue((Object)pSDEWizardLogicBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEWizardLogicBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEWizardLogicBase.getJSONValue((Object)pSDEWizardLogicBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEWizardLogicBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEWizardLogicBase.getJSONValue((Object)pSDEWizardLogicBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEWizardLogicBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEWizardLogicBase.getJSONValue((Object)pSDEWizardLogicBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEWizardLogicBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEWizardLogicBase.getJSONValue((Object)pSDEWizardLogicBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDEWizardLogicBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDEWizardLogicBase.getJSONValue((Object)pSDEWizardLogicBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEWizardLogicBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEWizardLogicBase pSDEWizardLogicBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEWizardLogicBase.getAttrName() != null) {
            object = pSDEWizardLogicBase.getAttrName();
            xmlNode.setAttribute(FIELD_ATTRNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardLogicBase.getCreateDate() != null) {
            object = pSDEWizardLogicBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEWizardLogicBase.getCreateMan() != null) {
            object = pSDEWizardLogicBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardLogicBase.getCustomCode() != null) {
            object = pSDEWizardLogicBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardLogicBase.getDstLogicType() != null) {
            object = pSDEWizardLogicBase.getDstLogicType();
            xmlNode.setAttribute(FIELD_DSTLOGICTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardLogicBase.getEventArg() != null) {
            object = pSDEWizardLogicBase.getEventArg();
            xmlNode.setAttribute(FIELD_EVENTARG, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardLogicBase.getEventArg2() != null) {
            object = pSDEWizardLogicBase.getEventArg2();
            xmlNode.setAttribute(FIELD_EVENTARG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardLogicBase.getEventNames() != null) {
            object = pSDEWizardLogicBase.getEventNames();
            xmlNode.setAttribute(FIELD_EVENTNAMES, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardLogicBase.getLogicParam() != null) {
            object = pSDEWizardLogicBase.getLogicParam();
            xmlNode.setAttribute(FIELD_LOGICPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardLogicBase.getLogicParam2() != null) {
            object = pSDEWizardLogicBase.getLogicParam2();
            xmlNode.setAttribute(FIELD_LOGICPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardLogicBase.getMemo() != null) {
            object = pSDEWizardLogicBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardLogicBase.getOrderValue() != null) {
            object = pSDEWizardLogicBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEWizardLogicBase.getPSDEId() != null) {
            object = pSDEWizardLogicBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardLogicBase.getPSDELogicId() != null) {
            object = pSDEWizardLogicBase.getPSDELogicId();
            xmlNode.setAttribute(FIELD_PSDELOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardLogicBase.getPSDELogicName() != null) {
            object = pSDEWizardLogicBase.getPSDELogicName();
            xmlNode.setAttribute(FIELD_PSDELOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardLogicBase.getPSDEName() != null) {
            object = pSDEWizardLogicBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardLogicBase.getPSDEUIActionId() != null) {
            object = pSDEWizardLogicBase.getPSDEUIActionId();
            xmlNode.setAttribute(FIELD_PSDEUIACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardLogicBase.getPSDEUIActionName() != null) {
            object = pSDEWizardLogicBase.getPSDEUIActionName();
            xmlNode.setAttribute(FIELD_PSDEUIACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardLogicBase.getPSDEWizardFormId() != null) {
            object = pSDEWizardLogicBase.getPSDEWizardFormId();
            xmlNode.setAttribute(FIELD_PSDEWIZARDFORMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardLogicBase.getPSDEWizardFormName() != null) {
            object = pSDEWizardLogicBase.getPSDEWizardFormName();
            xmlNode.setAttribute(FIELD_PSDEWIZARDFORMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardLogicBase.getPSDEWizardId() != null) {
            object = pSDEWizardLogicBase.getPSDEWizardId();
            xmlNode.setAttribute(FIELD_PSDEWIZARDID, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardLogicBase.getPSDEWizardLogicId() != null) {
            object = pSDEWizardLogicBase.getPSDEWizardLogicId();
            xmlNode.setAttribute(FIELD_PSDEWIZARDLOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardLogicBase.getPSDEWizardLogicName() != null) {
            object = pSDEWizardLogicBase.getPSDEWizardLogicName();
            xmlNode.setAttribute(FIELD_PSDEWIZARDLOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardLogicBase.getPSDEWizardName() != null) {
            object = pSDEWizardLogicBase.getPSDEWizardName();
            xmlNode.setAttribute(FIELD_PSDEWIZARDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardLogicBase.getPSDEWizardStepId() != null) {
            object = pSDEWizardLogicBase.getPSDEWizardStepId();
            xmlNode.setAttribute(FIELD_PSDEWIZARDSTEPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardLogicBase.getPSDEWizardStepName() != null) {
            object = pSDEWizardLogicBase.getPSDEWizardStepName();
            xmlNode.setAttribute(FIELD_PSDEWIZARDSTEPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardLogicBase.getPSSysPFPluginId() != null) {
            object = pSDEWizardLogicBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardLogicBase.getPSSysPFPluginName() != null) {
            object = pSDEWizardLogicBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardLogicBase.getPSSysViewLogicId() != null) {
            object = pSDEWizardLogicBase.getPSSysViewLogicId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWLOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardLogicBase.getPSSysViewLogicName() != null) {
            object = pSDEWizardLogicBase.getPSSysViewLogicName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWLOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardLogicBase.getTimer() != null) {
            object = pSDEWizardLogicBase.getTimer();
            xmlNode.setAttribute(FIELD_TIMER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEWizardLogicBase.getTriggerType() != null) {
            object = pSDEWizardLogicBase.getTriggerType();
            xmlNode.setAttribute(FIELD_TRIGGERTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardLogicBase.getUpdateDate() != null) {
            object = pSDEWizardLogicBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEWizardLogicBase.getUpdateMan() != null) {
            object = pSDEWizardLogicBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardLogicBase.getUserCat() != null) {
            object = pSDEWizardLogicBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardLogicBase.getUserTag() != null) {
            object = pSDEWizardLogicBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardLogicBase.getUserTag2() != null) {
            object = pSDEWizardLogicBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardLogicBase.getUserTag3() != null) {
            object = pSDEWizardLogicBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardLogicBase.getUserTag4() != null) {
            object = pSDEWizardLogicBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardLogicBase.getValidFlag() != null) {
            object = pSDEWizardLogicBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEWizardLogicBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEWizardLogicBase pSDEWizardLogicBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEWizardLogicBase.isAttrNameDirty() && (bl || pSDEWizardLogicBase.getAttrName() != null)) {
            iDataObject.set(FIELD_ATTRNAME, (Object)pSDEWizardLogicBase.getAttrName());
        }
        if (pSDEWizardLogicBase.isCreateDateDirty() && (bl || pSDEWizardLogicBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEWizardLogicBase.getCreateDate());
        }
        if (pSDEWizardLogicBase.isCreateManDirty() && (bl || pSDEWizardLogicBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEWizardLogicBase.getCreateMan());
        }
        if (pSDEWizardLogicBase.isCustomCodeDirty() && (bl || pSDEWizardLogicBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSDEWizardLogicBase.getCustomCode());
        }
        if (pSDEWizardLogicBase.isDstLogicTypeDirty() && (bl || pSDEWizardLogicBase.getDstLogicType() != null)) {
            iDataObject.set(FIELD_DSTLOGICTYPE, (Object)pSDEWizardLogicBase.getDstLogicType());
        }
        if (pSDEWizardLogicBase.isEventArgDirty() && (bl || pSDEWizardLogicBase.getEventArg() != null)) {
            iDataObject.set(FIELD_EVENTARG, (Object)pSDEWizardLogicBase.getEventArg());
        }
        if (pSDEWizardLogicBase.isEventArg2Dirty() && (bl || pSDEWizardLogicBase.getEventArg2() != null)) {
            iDataObject.set(FIELD_EVENTARG2, (Object)pSDEWizardLogicBase.getEventArg2());
        }
        if (pSDEWizardLogicBase.isEventNamesDirty() && (bl || pSDEWizardLogicBase.getEventNames() != null)) {
            iDataObject.set(FIELD_EVENTNAMES, (Object)pSDEWizardLogicBase.getEventNames());
        }
        if (pSDEWizardLogicBase.isLogicParamDirty() && (bl || pSDEWizardLogicBase.getLogicParam() != null)) {
            iDataObject.set(FIELD_LOGICPARAM, (Object)pSDEWizardLogicBase.getLogicParam());
        }
        if (pSDEWizardLogicBase.isLogicParam2Dirty() && (bl || pSDEWizardLogicBase.getLogicParam2() != null)) {
            iDataObject.set(FIELD_LOGICPARAM2, (Object)pSDEWizardLogicBase.getLogicParam2());
        }
        if (pSDEWizardLogicBase.isMemoDirty() && (bl || pSDEWizardLogicBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEWizardLogicBase.getMemo());
        }
        if (pSDEWizardLogicBase.isOrderValueDirty() && (bl || pSDEWizardLogicBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDEWizardLogicBase.getOrderValue());
        }
        if (pSDEWizardLogicBase.isPSDEIdDirty() && (bl || pSDEWizardLogicBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEWizardLogicBase.getPSDEId());
        }
        if (pSDEWizardLogicBase.isPSDELogicIdDirty() && (bl || pSDEWizardLogicBase.getPSDELogicId() != null)) {
            iDataObject.set(FIELD_PSDELOGICID, (Object)pSDEWizardLogicBase.getPSDELogicId());
        }
        if (pSDEWizardLogicBase.isPSDELogicNameDirty() && (bl || pSDEWizardLogicBase.getPSDELogicName() != null)) {
            iDataObject.set(FIELD_PSDELOGICNAME, (Object)pSDEWizardLogicBase.getPSDELogicName());
        }
        if (pSDEWizardLogicBase.isPSDENameDirty() && (bl || pSDEWizardLogicBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDEWizardLogicBase.getPSDEName());
        }
        if (pSDEWizardLogicBase.isPSDEUIActionIdDirty() && (bl || pSDEWizardLogicBase.getPSDEUIActionId() != null)) {
            iDataObject.set(FIELD_PSDEUIACTIONID, (Object)pSDEWizardLogicBase.getPSDEUIActionId());
        }
        if (pSDEWizardLogicBase.isPSDEUIActionNameDirty() && (bl || pSDEWizardLogicBase.getPSDEUIActionName() != null)) {
            iDataObject.set(FIELD_PSDEUIACTIONNAME, (Object)pSDEWizardLogicBase.getPSDEUIActionName());
        }
        if (pSDEWizardLogicBase.isPSDEWizardFormIdDirty() && (bl || pSDEWizardLogicBase.getPSDEWizardFormId() != null)) {
            iDataObject.set(FIELD_PSDEWIZARDFORMID, (Object)pSDEWizardLogicBase.getPSDEWizardFormId());
        }
        if (pSDEWizardLogicBase.isPSDEWizardFormNameDirty() && (bl || pSDEWizardLogicBase.getPSDEWizardFormName() != null)) {
            iDataObject.set(FIELD_PSDEWIZARDFORMNAME, (Object)pSDEWizardLogicBase.getPSDEWizardFormName());
        }
        if (pSDEWizardLogicBase.isPSDEWizardIdDirty() && (bl || pSDEWizardLogicBase.getPSDEWizardId() != null)) {
            iDataObject.set(FIELD_PSDEWIZARDID, (Object)pSDEWizardLogicBase.getPSDEWizardId());
        }
        if (pSDEWizardLogicBase.isPSDEWizardLogicIdDirty() && (bl || pSDEWizardLogicBase.getPSDEWizardLogicId() != null)) {
            iDataObject.set(FIELD_PSDEWIZARDLOGICID, (Object)pSDEWizardLogicBase.getPSDEWizardLogicId());
        }
        if (pSDEWizardLogicBase.isPSDEWizardLogicNameDirty() && (bl || pSDEWizardLogicBase.getPSDEWizardLogicName() != null)) {
            iDataObject.set(FIELD_PSDEWIZARDLOGICNAME, (Object)pSDEWizardLogicBase.getPSDEWizardLogicName());
        }
        if (pSDEWizardLogicBase.isPSDEWizardNameDirty() && (bl || pSDEWizardLogicBase.getPSDEWizardName() != null)) {
            iDataObject.set(FIELD_PSDEWIZARDNAME, (Object)pSDEWizardLogicBase.getPSDEWizardName());
        }
        if (pSDEWizardLogicBase.isPSDEWizardStepIdDirty() && (bl || pSDEWizardLogicBase.getPSDEWizardStepId() != null)) {
            iDataObject.set(FIELD_PSDEWIZARDSTEPID, (Object)pSDEWizardLogicBase.getPSDEWizardStepId());
        }
        if (pSDEWizardLogicBase.isPSDEWizardStepNameDirty() && (bl || pSDEWizardLogicBase.getPSDEWizardStepName() != null)) {
            iDataObject.set(FIELD_PSDEWIZARDSTEPNAME, (Object)pSDEWizardLogicBase.getPSDEWizardStepName());
        }
        if (pSDEWizardLogicBase.isPSSysPFPluginIdDirty() && (bl || pSDEWizardLogicBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSDEWizardLogicBase.getPSSysPFPluginId());
        }
        if (pSDEWizardLogicBase.isPSSysPFPluginNameDirty() && (bl || pSDEWizardLogicBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSDEWizardLogicBase.getPSSysPFPluginName());
        }
        if (pSDEWizardLogicBase.isPSSysViewLogicIdDirty() && (bl || pSDEWizardLogicBase.getPSSysViewLogicId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWLOGICID, (Object)pSDEWizardLogicBase.getPSSysViewLogicId());
        }
        if (pSDEWizardLogicBase.isPSSysViewLogicNameDirty() && (bl || pSDEWizardLogicBase.getPSSysViewLogicName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWLOGICNAME, (Object)pSDEWizardLogicBase.getPSSysViewLogicName());
        }
        if (pSDEWizardLogicBase.isTimerDirty() && (bl || pSDEWizardLogicBase.getTimer() != null)) {
            iDataObject.set(FIELD_TIMER, (Object)pSDEWizardLogicBase.getTimer());
        }
        if (pSDEWizardLogicBase.isTriggerTypeDirty() && (bl || pSDEWizardLogicBase.getTriggerType() != null)) {
            iDataObject.set(FIELD_TRIGGERTYPE, (Object)pSDEWizardLogicBase.getTriggerType());
        }
        if (pSDEWizardLogicBase.isUpdateDateDirty() && (bl || pSDEWizardLogicBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEWizardLogicBase.getUpdateDate());
        }
        if (pSDEWizardLogicBase.isUpdateManDirty() && (bl || pSDEWizardLogicBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEWizardLogicBase.getUpdateMan());
        }
        if (pSDEWizardLogicBase.isUserCatDirty() && (bl || pSDEWizardLogicBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEWizardLogicBase.getUserCat());
        }
        if (pSDEWizardLogicBase.isUserTagDirty() && (bl || pSDEWizardLogicBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEWizardLogicBase.getUserTag());
        }
        if (pSDEWizardLogicBase.isUserTag2Dirty() && (bl || pSDEWizardLogicBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEWizardLogicBase.getUserTag2());
        }
        if (pSDEWizardLogicBase.isUserTag3Dirty() && (bl || pSDEWizardLogicBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEWizardLogicBase.getUserTag3());
        }
        if (pSDEWizardLogicBase.isUserTag4Dirty() && (bl || pSDEWizardLogicBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEWizardLogicBase.getUserTag4());
        }
        if (pSDEWizardLogicBase.isValidFlagDirty() && (bl || pSDEWizardLogicBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDEWizardLogicBase.getValidFlag());
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
        return PSDEWizardLogicBase.remove(this, n);
    }

    private static boolean remove(PSDEWizardLogicBase pSDEWizardLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEWizardLogicBase.resetAttrName();
                return true;
            }
            case 1: {
                pSDEWizardLogicBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDEWizardLogicBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDEWizardLogicBase.resetCustomCode();
                return true;
            }
            case 4: {
                pSDEWizardLogicBase.resetDstLogicType();
                return true;
            }
            case 5: {
                pSDEWizardLogicBase.resetEventArg();
                return true;
            }
            case 6: {
                pSDEWizardLogicBase.resetEventArg2();
                return true;
            }
            case 7: {
                pSDEWizardLogicBase.resetEventNames();
                return true;
            }
            case 8: {
                pSDEWizardLogicBase.resetLogicParam();
                return true;
            }
            case 9: {
                pSDEWizardLogicBase.resetLogicParam2();
                return true;
            }
            case 10: {
                pSDEWizardLogicBase.resetMemo();
                return true;
            }
            case 11: {
                pSDEWizardLogicBase.resetOrderValue();
                return true;
            }
            case 12: {
                pSDEWizardLogicBase.resetPSDEId();
                return true;
            }
            case 13: {
                pSDEWizardLogicBase.resetPSDELogicId();
                return true;
            }
            case 14: {
                pSDEWizardLogicBase.resetPSDELogicName();
                return true;
            }
            case 15: {
                pSDEWizardLogicBase.resetPSDEName();
                return true;
            }
            case 16: {
                pSDEWizardLogicBase.resetPSDEUIActionId();
                return true;
            }
            case 17: {
                pSDEWizardLogicBase.resetPSDEUIActionName();
                return true;
            }
            case 18: {
                pSDEWizardLogicBase.resetPSDEWizardFormId();
                return true;
            }
            case 19: {
                pSDEWizardLogicBase.resetPSDEWizardFormName();
                return true;
            }
            case 20: {
                pSDEWizardLogicBase.resetPSDEWizardId();
                return true;
            }
            case 21: {
                pSDEWizardLogicBase.resetPSDEWizardLogicId();
                return true;
            }
            case 22: {
                pSDEWizardLogicBase.resetPSDEWizardLogicName();
                return true;
            }
            case 23: {
                pSDEWizardLogicBase.resetPSDEWizardName();
                return true;
            }
            case 24: {
                pSDEWizardLogicBase.resetPSDEWizardStepId();
                return true;
            }
            case 25: {
                pSDEWizardLogicBase.resetPSDEWizardStepName();
                return true;
            }
            case 26: {
                pSDEWizardLogicBase.resetPSSysPFPluginId();
                return true;
            }
            case 27: {
                pSDEWizardLogicBase.resetPSSysPFPluginName();
                return true;
            }
            case 28: {
                pSDEWizardLogicBase.resetPSSysViewLogicId();
                return true;
            }
            case 29: {
                pSDEWizardLogicBase.resetPSSysViewLogicName();
                return true;
            }
            case 30: {
                pSDEWizardLogicBase.resetTimer();
                return true;
            }
            case 31: {
                pSDEWizardLogicBase.resetTriggerType();
                return true;
            }
            case 32: {
                pSDEWizardLogicBase.resetUpdateDate();
                return true;
            }
            case 33: {
                pSDEWizardLogicBase.resetUpdateMan();
                return true;
            }
            case 34: {
                pSDEWizardLogicBase.resetUserCat();
                return true;
            }
            case 35: {
                pSDEWizardLogicBase.resetUserTag();
                return true;
            }
            case 36: {
                pSDEWizardLogicBase.resetUserTag2();
                return true;
            }
            case 37: {
                pSDEWizardLogicBase.resetUserTag3();
                return true;
            }
            case 38: {
                pSDEWizardLogicBase.resetUserTag4();
                return true;
            }
            case 39: {
                pSDEWizardLogicBase.resetValidFlag();
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
    public PSDEWizardForm getPSDEWizardForm() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEWizardForm();
        }
        if (this.getPSDEWizardFormId() == null) {
            return null;
        }
        Integer n = this.objPSDEWizardFormLock;
        synchronized (n) {
            if (this.psdewizardform != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEWizardFormId(), (Object)this.psdewizardform.getPSDEWizardFormId()) != 0L) {
                this.psdewizardform = null;
            }
            if (this.psdewizardform == null) {
                PSDEWizardForm pSDEWizardForm = new PSDEWizardForm();
                pSDEWizardForm.setPSDEWizardFormId(this.getPSDEWizardFormId());
                PSDEWizardFormService pSDEWizardFormService = (PSDEWizardFormService)ServiceGlobal.getService(PSDEWizardFormService.class, (SessionFactory)this.getSessionFactory());
                pSDEWizardFormService.autoGet((IEntity)pSDEWizardForm);
                this.psdewizardform = pSDEWizardForm;
            }
            return this.psdewizardform;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEWizardStep getPSDEWizardStep() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEWizardStep();
        }
        if (this.getPSDEWizardStepId() == null) {
            return null;
        }
        Integer n = this.objPSDEWizardStepLock;
        synchronized (n) {
            if (this.psdewizardstep != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEWizardStepId(), (Object)this.psdewizardstep.getPSDEWizardStepId()) != 0L) {
                this.psdewizardstep = null;
            }
            if (this.psdewizardstep == null) {
                PSDEWizardStep pSDEWizardStep = new PSDEWizardStep();
                pSDEWizardStep.setPSDEWizardStepId(this.getPSDEWizardStepId());
                PSDEWizardStepService pSDEWizardStepService = (PSDEWizardStepService)ServiceGlobal.getService(PSDEWizardStepService.class, (SessionFactory)this.getSessionFactory());
                pSDEWizardStepService.autoGet((IEntity)pSDEWizardStep);
                this.psdewizardstep = pSDEWizardStep;
            }
            return this.psdewizardstep;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEWizard getPSDEWizard() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEWizard();
        }
        if (this.getPSDEWizardId() == null) {
            return null;
        }
        Integer n = this.objPSDEWizardLock;
        synchronized (n) {
            if (this.psdewizard != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEWizardId(), (Object)this.psdewizard.getPSDEWizardId()) != 0L) {
                this.psdewizard = null;
            }
            if (this.psdewizard == null) {
                PSDEWizard pSDEWizard = new PSDEWizard();
                pSDEWizard.setPSDEWizardId(this.getPSDEWizardId());
                PSDEWizardService pSDEWizardService = (PSDEWizardService)ServiceGlobal.getService(PSDEWizardService.class, (SessionFactory)this.getSessionFactory());
                pSDEWizardService.autoGet((IEntity)pSDEWizard);
                this.psdewizard = pSDEWizard;
            }
            return this.psdewizard;
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

    private PSDEWizardLogicBase getProxyEntity() {
        return this.proxyPSDEWizardLogicBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEWizardLogicBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEWizardLogicBase) {
            this.proxyPSDEWizardLogicBase = (PSDEWizardLogicBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEWizardLogicService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
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
        fieldIndexMap.put(FIELD_PSDEWIZARDFORMID, 18);
        fieldIndexMap.put(FIELD_PSDEWIZARDFORMNAME, 19);
        fieldIndexMap.put(FIELD_PSDEWIZARDID, 20);
        fieldIndexMap.put(FIELD_PSDEWIZARDLOGICID, 21);
        fieldIndexMap.put(FIELD_PSDEWIZARDLOGICNAME, 22);
        fieldIndexMap.put(FIELD_PSDEWIZARDNAME, 23);
        fieldIndexMap.put(FIELD_PSDEWIZARDSTEPID, 24);
        fieldIndexMap.put(FIELD_PSDEWIZARDSTEPNAME, 25);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINID, 26);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINNAME, 27);
        fieldIndexMap.put(FIELD_PSSYSVIEWLOGICID, 28);
        fieldIndexMap.put(FIELD_PSSYSVIEWLOGICNAME, 29);
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

