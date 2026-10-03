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
package net.ibizsys.pscore.srv.wfdesign.entity;

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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaInst;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaWFVer;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaInstService;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaWFVerService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService;
import net.ibizsys.pscore.srv.wfdesign.entity.PSSysWFMode;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFLink;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFProcess;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWorkflow;
import net.ibizsys.pscore.srv.wfdesign.service.PSSysWFModeService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFLinkService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFProcessService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFVersionService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWorkflowService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSWFVersionBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSWFVersionBase.class);
    public static final String FIELD_ACTIVITIMODEL = "ACTIVITIMODEL";
    public static final String FIELD_BPMNMODEL = "BPMNMODEL";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_DYNASYSREFMODE = "DYNASYSREFMODE";
    public static final String FIELD_DYNAWFVER = "DYNAWFVER";
    public static final String FIELD_ENABLE = "ENABLE";
    public static final String FIELD_ENABLEDYNASYS = "ENABLEDYNASYS";
    public static final String FIELD_ENABLELOG = "ENABLELOG";
    public static final String FIELD_LASTBACKDATATAG = "LASTBACKDATATAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEUAGROUPSCNT = "PSDEUAGROUPSCNT";
    public static final String FIELD_PSDEUIACTIONSCNT = "PSDEUIACTIONSCNT";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSDYNAINSTNAME = "PSDYNAINSTNAME";
    public static final String FIELD_PSDYNAWFVERID = "PSDYNAWFVERID";
    public static final String FIELD_PSDYNAWFVERINSTID = "PSDYNAWFVERINSTID";
    public static final String FIELD_PSDYNAWFVERINSTNAME = "PSDYNAWFVERINSTNAME";
    public static final String FIELD_PSDYNAWFVERNAME = "PSDYNAWFVERNAME";
    public static final String FIELD_PSSYSREQITEMID = "PSSYSREQITEMID";
    public static final String FIELD_PSSYSREQITEMNAME = "PSSYSREQITEMNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSWFMODEID = "PSSYSWFMODEID";
    public static final String FIELD_PSSYSWFMODENAME = "PSSYSWFMODENAME";
    public static final String FIELD_PSWFID = "PSWFID";
    public static final String FIELD_PSWFNAME = "PSWFNAME";
    public static final String FIELD_PSWFVERSIONID = "PSWFVERSIONID";
    public static final String FIELD_PSWFVERSIONNAME = "PSWFVERSIONNAME";
    public static final String FIELD_REMOVEFLAG = "REMOVEFLAG";
    public static final String FIELD_TODOTASK = "TODOTASK";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    public static final String FIELD_VERTAG = "VERTAG";
    public static final String FIELD_VERTAG2 = "VERTAG2";
    public static final String FIELD_WFENGINETYPE = "WFENGINETYPE";
    public static final String FIELD_WFMODE = "WFMODE";
    public static final String FIELD_WFMODEL = "WFMODEL";
    public static final String FIELD_WFSTEPPSCODELISTID = "WFSTEPPSCODELISTID";
    public static final String FIELD_WFSTEPPSCODELISTNAME = "WFSTEPPSCODELISTNAME";
    public static final String FIELD_WFVERMODE = "WFVERMODE";
    public static final String FIELD_WFVERSION = "WFVERSION";
    private static final int INDEX_ACTIVITIMODEL = 0;
    private static final int INDEX_BPMNMODEL = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_DYNAMODELFLAG = 4;
    private static final int INDEX_DYNASYSREFMODE = 5;
    private static final int INDEX_DYNAWFVER = 6;
    private static final int INDEX_ENABLE = 7;
    private static final int INDEX_ENABLEDYNASYS = 8;
    private static final int INDEX_ENABLELOG = 9;
    private static final int INDEX_LASTBACKDATATAG = 10;
    private static final int INDEX_MEMO = 11;
    private static final int INDEX_PSDEUAGROUPSCNT = 12;
    private static final int INDEX_PSDEUIACTIONSCNT = 13;
    private static final int INDEX_PSDYNAINSTID = 14;
    private static final int INDEX_PSDYNAINSTNAME = 15;
    private static final int INDEX_PSDYNAWFVERID = 16;
    private static final int INDEX_PSDYNAWFVERINSTID = 17;
    private static final int INDEX_PSDYNAWFVERINSTNAME = 18;
    private static final int INDEX_PSDYNAWFVERNAME = 19;
    private static final int INDEX_PSSYSREQITEMID = 20;
    private static final int INDEX_PSSYSREQITEMNAME = 21;
    private static final int INDEX_PSSYSTEMID = 22;
    private static final int INDEX_PSSYSWFMODEID = 23;
    private static final int INDEX_PSSYSWFMODENAME = 24;
    private static final int INDEX_PSWFID = 25;
    private static final int INDEX_PSWFNAME = 26;
    private static final int INDEX_PSWFVERSIONID = 27;
    private static final int INDEX_PSWFVERSIONNAME = 28;
    private static final int INDEX_REMOVEFLAG = 29;
    private static final int INDEX_TODOTASK = 30;
    private static final int INDEX_UPDATEDATE = 31;
    private static final int INDEX_UPDATEMAN = 32;
    private static final int INDEX_USERCAT = 33;
    private static final int INDEX_USERTAG = 34;
    private static final int INDEX_USERTAG2 = 35;
    private static final int INDEX_USERTAG3 = 36;
    private static final int INDEX_USERTAG4 = 37;
    private static final int INDEX_VALIDFLAG = 38;
    private static final int INDEX_VERTAG = 39;
    private static final int INDEX_VERTAG2 = 40;
    private static final int INDEX_WFENGINETYPE = 41;
    private static final int INDEX_WFMODE = 42;
    private static final int INDEX_WFMODEL = 43;
    private static final int INDEX_WFSTEPPSCODELISTID = 44;
    private static final int INDEX_WFSTEPPSCODELISTNAME = 45;
    private static final int INDEX_WFVERMODE = 46;
    private static final int INDEX_WFVERSION = 47;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSWFVersionBase proxyPSWFVersionBase = null;
    private boolean activitimodelDirtyFlag = false;
    private boolean bpmnmodelDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean dynasysrefmodeDirtyFlag = false;
    private boolean dynawfverDirtyFlag = false;
    private boolean enableDirtyFlag = false;
    private boolean enabledynasysDirtyFlag = false;
    private boolean enablelogDirtyFlag = false;
    private boolean lastbackdatatagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdeuagroupscntDirtyFlag = false;
    private boolean psdeuiactionscntDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean psdynainstnameDirtyFlag = false;
    private boolean psdynawfveridDirtyFlag = false;
    private boolean psdynawfverinstidDirtyFlag = false;
    private boolean psdynawfverinstnameDirtyFlag = false;
    private boolean psdynawfvernameDirtyFlag = false;
    private boolean pssysreqitemidDirtyFlag = false;
    private boolean pssysreqitemnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssyswfmodeidDirtyFlag = false;
    private boolean pssyswfmodenameDirtyFlag = false;
    private boolean pswfidDirtyFlag = false;
    private boolean pswfnameDirtyFlag = false;
    private boolean pswfversionidDirtyFlag = false;
    private boolean pswfversionnameDirtyFlag = false;
    private boolean removeflagDirtyFlag = false;
    private boolean todotaskDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    private boolean vertagDirtyFlag = false;
    private boolean vertag2DirtyFlag = false;
    private boolean wfenginetypeDirtyFlag = false;
    private boolean wfmodeDirtyFlag = false;
    private boolean wfmodelDirtyFlag = false;
    private boolean wfsteppscodelistidDirtyFlag = false;
    private boolean wfsteppscodelistnameDirtyFlag = false;
    private boolean wfvermodeDirtyFlag = false;
    private boolean wfversionDirtyFlag = false;
    @Column(name="activitimodel")
    private String activitimodel;
    @Column(name="bpmnmodel")
    private String bpmnmodel;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="dynasysrefmode")
    private Integer dynasysrefmode;
    @Column(name="dynawfver")
    private Integer dynawfver;
    @Column(name="enable")
    private Integer enable;
    @Column(name="enabledynasys")
    private Integer enabledynasys;
    @Column(name="enablelog")
    private Integer enablelog;
    @Column(name="lastbackdatatag")
    private String lastbackdatatag;
    @Column(name="memo")
    private String memo;
    @Column(name="psdeuagroupscnt")
    private Integer psdeuagroupscnt;
    @Column(name="psdeuiactionscnt")
    private Integer psdeuiactionscnt;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="psdynainstname")
    private String psdynainstname;
    @Column(name="psdynawfverid")
    private String psdynawfverid;
    @Column(name="psdynawfverinstid")
    private String psdynawfverinstid;
    @Column(name="psdynawfverinstname")
    private String psdynawfverinstname;
    @Column(name="psdynawfvername")
    private String psdynawfvername;
    @Column(name="pssysreqitemid")
    private String pssysreqitemid;
    @Column(name="pssysreqitemname")
    private String pssysreqitemname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssyswfmodeid")
    private String pssyswfmodeid;
    @Column(name="pssyswfmodename")
    private String pssyswfmodename;
    @Column(name="pswfid")
    private String pswfid;
    @Column(name="pswfname")
    private String pswfname;
    @Column(name="pswfversionid")
    private String pswfversionid;
    @Column(name="pswfversionname")
    private String pswfversionname;
    @Column(name="removeflag")
    private Integer removeflag;
    @Column(name="todotask")
    private String todotask;
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
    @Column(name="vertag")
    private String vertag;
    @Column(name="vertag2")
    private String vertag2;
    @Column(name="wfenginetype")
    private String wfenginetype;
    @Column(name="wfmode")
    private String wfmode;
    @Column(name="wfmodel")
    private String wfmodel;
    @Column(name="wfsteppscodelistid")
    private String wfsteppscodelistid;
    @Column(name="wfsteppscodelistname")
    private String wfsteppscodelistname;
    @Column(name="wfvermode")
    private String wfvermode;
    @Column(name="wfversion")
    private Integer wfversion;
    private Integer objWFStepPSCodeListLock = new Integer(1);
    private PSCodeList wfsteppscodelist = null;
    private Integer objPSDynaInstLock = new Integer(1);
    private PSDynaInst psdynainst = null;
    private Integer objPSDynaWFVerLock = new Integer(1);
    private PSDynaWFVer psdynawfver = null;
    private Integer objPSSysReqItemLock = new Integer(1);
    private PSSysReqItem pssysreqitem = null;
    private Integer objPSSysWFModeLock = new Integer(1);
    private PSSysWFMode pssyswfmode = null;
    private Integer objPSWFLock = new Integer(1);
    private PSWorkflow pswf = null;
    private Integer objPSDEUAGroupsLock = new Integer(1);
    private ArrayList<PSDEUAGroup> psdeuagroups = null;
    private Integer objPSDEUIActionsLock = new Integer(1);
    private ArrayList<PSDEUIAction> psdeuiactions = null;
    private Integer objPSWFLinksLock = new Integer(1);
    private ArrayList<PSWFLink> pswflinks = null;
    private Integer objPSWFProcessesLock = new Integer(1);
    private ArrayList<PSWFProcess> pswfprocesses = null;

    public void setActivitiModel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActivitiModel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.activitimodel = string;
        this.activitimodelDirtyFlag = true;
    }

    public String getActivitiModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActivitiModel();
        }
        return this.activitimodel;
    }

    public boolean isActivitiModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActivitiModelDirty();
        }
        return this.activitimodelDirtyFlag;
    }

    public void resetActivitiModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActivitiModel();
            return;
        }
        this.activitimodelDirtyFlag = false;
        this.activitimodel = null;
    }

    public void setBPMNModel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBPMNModel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bpmnmodel = string;
        this.bpmnmodelDirtyFlag = true;
    }

    public String getBPMNModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBPMNModel();
        }
        return this.bpmnmodel;
    }

    public boolean isBPMNModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBPMNModelDirty();
        }
        return this.bpmnmodelDirtyFlag;
    }

    public void resetBPMNModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBPMNModel();
            return;
        }
        this.bpmnmodelDirtyFlag = false;
        this.bpmnmodel = null;
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

    public void setDynaModelFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynaModelFlag(n);
            return;
        }
        this.dynamodelflag = n;
        this.dynamodelflagDirtyFlag = true;
    }

    public Integer getDynaModelFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynaModelFlag();
        }
        return this.dynamodelflag;
    }

    public boolean isDynaModelFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynaModelFlagDirty();
        }
        return this.dynamodelflagDirtyFlag;
    }

    public void resetDynaModelFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynaModelFlag();
            return;
        }
        this.dynamodelflagDirtyFlag = false;
        this.dynamodelflag = null;
    }

    public void setDynaSysRefMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynaSysRefMode(n);
            return;
        }
        this.dynasysrefmode = n;
        this.dynasysrefmodeDirtyFlag = true;
    }

    public Integer getDynaSysRefMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynaSysRefMode();
        }
        return this.dynasysrefmode;
    }

    public boolean isDynaSysRefModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynaSysRefModeDirty();
        }
        return this.dynasysrefmodeDirtyFlag;
    }

    public void resetDynaSysRefMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynaSysRefMode();
            return;
        }
        this.dynasysrefmodeDirtyFlag = false;
        this.dynasysrefmode = null;
    }

    public void setDynaWFVer(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynaWFVer(n);
            return;
        }
        this.dynawfver = n;
        this.dynawfverDirtyFlag = true;
    }

    public Integer getDynaWFVer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynaWFVer();
        }
        return this.dynawfver;
    }

    public boolean isDynaWFVerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynaWFVerDirty();
        }
        return this.dynawfverDirtyFlag;
    }

    public void resetDynaWFVer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynaWFVer();
            return;
        }
        this.dynawfverDirtyFlag = false;
        this.dynawfver = null;
    }

    public void setEnable(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnable(n);
            return;
        }
        this.enable = n;
        this.enableDirtyFlag = true;
    }

    public Integer getEnable() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnable();
        }
        return this.enable;
    }

    public boolean isEnableDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableDirty();
        }
        return this.enableDirtyFlag;
    }

    public void resetEnable() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnable();
            return;
        }
        this.enableDirtyFlag = false;
        this.enable = null;
    }

    public void setEnableDynaSys(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableDynaSys(n);
            return;
        }
        this.enabledynasys = n;
        this.enabledynasysDirtyFlag = true;
    }

    public Integer getEnableDynaSys() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableDynaSys();
        }
        return this.enabledynasys;
    }

    public boolean isEnableDynaSysDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableDynaSysDirty();
        }
        return this.enabledynasysDirtyFlag;
    }

    public void resetEnableDynaSys() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableDynaSys();
            return;
        }
        this.enabledynasysDirtyFlag = false;
        this.enabledynasys = null;
    }

    public void setEnableLog(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableLog(n);
            return;
        }
        this.enablelog = n;
        this.enablelogDirtyFlag = true;
    }

    public Integer getEnableLog() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableLog();
        }
        return this.enablelog;
    }

    public boolean isEnableLogDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableLogDirty();
        }
        return this.enablelogDirtyFlag;
    }

    public void resetEnableLog() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableLog();
            return;
        }
        this.enablelogDirtyFlag = false;
        this.enablelog = null;
    }

    public void setLastBackDataTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLastBackDataTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.lastbackdatatag = string;
        this.lastbackdatatagDirtyFlag = true;
    }

    public String getLastBackDataTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLastBackDataTag();
        }
        return this.lastbackdatatag;
    }

    public boolean isLastBackDataTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLastBackDataTagDirty();
        }
        return this.lastbackdatatagDirtyFlag;
    }

    public void resetLastBackDataTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLastBackDataTag();
            return;
        }
        this.lastbackdatatagDirtyFlag = false;
        this.lastbackdatatag = null;
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

    public void setPSDEUAGroupsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEUAGroupsCnt(n);
            return;
        }
        this.psdeuagroupscnt = n;
        this.psdeuagroupscntDirtyFlag = true;
    }

    public Integer getPSDEUAGroupsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUAGroupsCnt();
        }
        return this.psdeuagroupscnt;
    }

    public boolean isPSDEUAGroupsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEUAGroupsCntDirty();
        }
        return this.psdeuagroupscntDirtyFlag;
    }

    public void resetPSDEUAGroupsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEUAGroupsCnt();
            return;
        }
        this.psdeuagroupscntDirtyFlag = false;
        this.psdeuagroupscnt = null;
    }

    public void setPSDEUIActionsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEUIActionsCnt(n);
            return;
        }
        this.psdeuiactionscnt = n;
        this.psdeuiactionscntDirtyFlag = true;
    }

    public Integer getPSDEUIActionsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUIActionsCnt();
        }
        return this.psdeuiactionscnt;
    }

    public boolean isPSDEUIActionsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEUIActionsCntDirty();
        }
        return this.psdeuiactionscntDirtyFlag;
    }

    public void resetPSDEUIActionsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEUIActionsCnt();
            return;
        }
        this.psdeuiactionscntDirtyFlag = false;
        this.psdeuiactionscnt = null;
    }

    public void setPSDynaInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynainstid = string;
        this.psdynainstidDirtyFlag = true;
    }

    public String getPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaInstId();
        }
        return this.psdynainstid;
    }

    public boolean isPSDynaInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaInstIdDirty();
        }
        return this.psdynainstidDirtyFlag;
    }

    public void resetPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaInstId();
            return;
        }
        this.psdynainstidDirtyFlag = false;
        this.psdynainstid = null;
    }

    public void setPSDynaInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynainstname = string;
        this.psdynainstnameDirtyFlag = true;
    }

    public String getPSDynaInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaInstName();
        }
        return this.psdynainstname;
    }

    public boolean isPSDynaInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaInstNameDirty();
        }
        return this.psdynainstnameDirtyFlag;
    }

    public void resetPSDynaInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaInstName();
            return;
        }
        this.psdynainstnameDirtyFlag = false;
        this.psdynainstname = null;
    }

    public void setPSDynaWFVerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaWFVerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynawfverid = string;
        this.psdynawfveridDirtyFlag = true;
    }

    public String getPSDynaWFVerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaWFVerId();
        }
        return this.psdynawfverid;
    }

    public boolean isPSDynaWFVerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaWFVerIdDirty();
        }
        return this.psdynawfveridDirtyFlag;
    }

    public void resetPSDynaWFVerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaWFVerId();
            return;
        }
        this.psdynawfveridDirtyFlag = false;
        this.psdynawfverid = null;
    }

    public void setPSDynaWFVerInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaWFVerInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynawfverinstid = string;
        this.psdynawfverinstidDirtyFlag = true;
    }

    public String getPSDynaWFVerInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaWFVerInstId();
        }
        return this.psdynawfverinstid;
    }

    public boolean isPSDynaWFVerInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaWFVerInstIdDirty();
        }
        return this.psdynawfverinstidDirtyFlag;
    }

    public void resetPSDynaWFVerInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaWFVerInstId();
            return;
        }
        this.psdynawfverinstidDirtyFlag = false;
        this.psdynawfverinstid = null;
    }

    public void setPSDynaWFVerInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaWFVerInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynawfverinstname = string;
        this.psdynawfverinstnameDirtyFlag = true;
    }

    public String getPSDynaWFVerInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaWFVerInstName();
        }
        return this.psdynawfverinstname;
    }

    public boolean isPSDynaWFVerInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaWFVerInstNameDirty();
        }
        return this.psdynawfverinstnameDirtyFlag;
    }

    public void resetPSDynaWFVerInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaWFVerInstName();
            return;
        }
        this.psdynawfverinstnameDirtyFlag = false;
        this.psdynawfverinstname = null;
    }

    public void setPSDynaWFVerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaWFVerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynawfvername = string;
        this.psdynawfvernameDirtyFlag = true;
    }

    public String getPSDynaWFVerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaWFVerName();
        }
        return this.psdynawfvername;
    }

    public boolean isPSDynaWFVerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaWFVerNameDirty();
        }
        return this.psdynawfvernameDirtyFlag;
    }

    public void resetPSDynaWFVerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaWFVerName();
            return;
        }
        this.psdynawfvernameDirtyFlag = false;
        this.psdynawfvername = null;
    }

    public void setPSSysReqItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysReqItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysreqitemid = string;
        this.pssysreqitemidDirtyFlag = true;
    }

    public String getPSSysReqItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysReqItemId();
        }
        return this.pssysreqitemid;
    }

    public boolean isPSSysReqItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysReqItemIdDirty();
        }
        return this.pssysreqitemidDirtyFlag;
    }

    public void resetPSSysReqItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysReqItemId();
            return;
        }
        this.pssysreqitemidDirtyFlag = false;
        this.pssysreqitemid = null;
    }

    public void setPSSysReqItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysReqItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysreqitemname = string;
        this.pssysreqitemnameDirtyFlag = true;
    }

    public String getPSSysReqItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysReqItemName();
        }
        return this.pssysreqitemname;
    }

    public boolean isPSSysReqItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysReqItemNameDirty();
        }
        return this.pssysreqitemnameDirtyFlag;
    }

    public void resetPSSysReqItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysReqItemName();
            return;
        }
        this.pssysreqitemnameDirtyFlag = false;
        this.pssysreqitemname = null;
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

    public void setPSSysWFModeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysWFModeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyswfmodeid = string;
        this.pssyswfmodeidDirtyFlag = true;
    }

    public String getPSSysWFModeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysWFModeId();
        }
        return this.pssyswfmodeid;
    }

    public boolean isPSSysWFModeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysWFModeIdDirty();
        }
        return this.pssyswfmodeidDirtyFlag;
    }

    public void resetPSSysWFModeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysWFModeId();
            return;
        }
        this.pssyswfmodeidDirtyFlag = false;
        this.pssyswfmodeid = null;
    }

    public void setPSSysWFModeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysWFModeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyswfmodename = string;
        this.pssyswfmodenameDirtyFlag = true;
    }

    public String getPSSysWFModeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysWFModeName();
        }
        return this.pssyswfmodename;
    }

    public boolean isPSSysWFModeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysWFModeNameDirty();
        }
        return this.pssyswfmodenameDirtyFlag;
    }

    public void resetPSSysWFModeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysWFModeName();
            return;
        }
        this.pssyswfmodenameDirtyFlag = false;
        this.pssyswfmodename = null;
    }

    public void setPSWFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfid = string;
        this.pswfidDirtyFlag = true;
    }

    public String getPSWFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFId();
        }
        return this.pswfid;
    }

    public boolean isPSWFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFIdDirty();
        }
        return this.pswfidDirtyFlag;
    }

    public void resetPSWFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFId();
            return;
        }
        this.pswfidDirtyFlag = false;
        this.pswfid = null;
    }

    public void setPSWFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfname = string;
        this.pswfnameDirtyFlag = true;
    }

    public String getPSWFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFName();
        }
        return this.pswfname;
    }

    public boolean isPSWFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFNameDirty();
        }
        return this.pswfnameDirtyFlag;
    }

    public void resetPSWFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFName();
            return;
        }
        this.pswfnameDirtyFlag = false;
        this.pswfname = null;
    }

    public void setPSWFVersionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFVersionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfversionid = string;
        this.pswfversionidDirtyFlag = true;
    }

    public String getPSWFVersionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFVersionId();
        }
        return this.pswfversionid;
    }

    public boolean isPSWFVersionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFVersionIdDirty();
        }
        return this.pswfversionidDirtyFlag;
    }

    public void resetPSWFVersionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFVersionId();
            return;
        }
        this.pswfversionidDirtyFlag = false;
        this.pswfversionid = null;
    }

    public void setPSWFVersionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFVersionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfversionname = string;
        this.pswfversionnameDirtyFlag = true;
    }

    public String getPSWFVersionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFVersionName();
        }
        return this.pswfversionname;
    }

    public boolean isPSWFVersionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFVersionNameDirty();
        }
        return this.pswfversionnameDirtyFlag;
    }

    public void resetPSWFVersionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFVersionName();
            return;
        }
        this.pswfversionnameDirtyFlag = false;
        this.pswfversionname = null;
    }

    public void setRemoveFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRemoveFlag(n);
            return;
        }
        this.removeflag = n;
        this.removeflagDirtyFlag = true;
    }

    public Integer getRemoveFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRemoveFlag();
        }
        return this.removeflag;
    }

    public boolean isRemoveFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRemoveFlagDirty();
        }
        return this.removeflagDirtyFlag;
    }

    public void resetRemoveFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRemoveFlag();
            return;
        }
        this.removeflagDirtyFlag = false;
        this.removeflag = null;
    }

    public void setToDoTask(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setToDoTask(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.todotask = string;
        this.todotaskDirtyFlag = true;
    }

    public String getToDoTask() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getToDoTask();
        }
        return this.todotask;
    }

    public boolean isToDoTaskDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isToDoTaskDirty();
        }
        return this.todotaskDirtyFlag;
    }

    public void resetToDoTask() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetToDoTask();
            return;
        }
        this.todotaskDirtyFlag = false;
        this.todotask = null;
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

    public void setVerTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVerTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.vertag = string;
        this.vertagDirtyFlag = true;
    }

    public String getVerTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVerTag();
        }
        return this.vertag;
    }

    public boolean isVerTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVerTagDirty();
        }
        return this.vertagDirtyFlag;
    }

    public void resetVerTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVerTag();
            return;
        }
        this.vertagDirtyFlag = false;
        this.vertag = null;
    }

    public void setVerTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVerTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.vertag2 = string;
        this.vertag2DirtyFlag = true;
    }

    public String getVerTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVerTag2();
        }
        return this.vertag2;
    }

    public boolean isVerTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVerTag2Dirty();
        }
        return this.vertag2DirtyFlag;
    }

    public void resetVerTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVerTag2();
            return;
        }
        this.vertag2DirtyFlag = false;
        this.vertag2 = null;
    }

    public void setWFEngineType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFEngineType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wfenginetype = string;
        this.wfenginetypeDirtyFlag = true;
    }

    public String getWFEngineType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFEngineType();
        }
        return this.wfenginetype;
    }

    public boolean isWFEngineTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFEngineTypeDirty();
        }
        return this.wfenginetypeDirtyFlag;
    }

    public void resetWFEngineType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFEngineType();
            return;
        }
        this.wfenginetypeDirtyFlag = false;
        this.wfenginetype = null;
    }

    public void setWFMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wfmode = string;
        this.wfmodeDirtyFlag = true;
    }

    public String getWFMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFMode();
        }
        return this.wfmode;
    }

    public boolean isWFModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFModeDirty();
        }
        return this.wfmodeDirtyFlag;
    }

    public void resetWFMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFMode();
            return;
        }
        this.wfmodeDirtyFlag = false;
        this.wfmode = null;
    }

    public void setWFModel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFModel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wfmodel = string;
        this.wfmodelDirtyFlag = true;
    }

    public String getWFModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFModel();
        }
        return this.wfmodel;
    }

    public boolean isWFModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFModelDirty();
        }
        return this.wfmodelDirtyFlag;
    }

    public void resetWFModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFModel();
            return;
        }
        this.wfmodelDirtyFlag = false;
        this.wfmodel = null;
    }

    public void setWFStepPSCodeListId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFStepPSCodeListId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wfsteppscodelistid = string;
        this.wfsteppscodelistidDirtyFlag = true;
    }

    public String getWFStepPSCodeListId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFStepPSCodeListId();
        }
        return this.wfsteppscodelistid;
    }

    public boolean isWFStepPSCodeListIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFStepPSCodeListIdDirty();
        }
        return this.wfsteppscodelistidDirtyFlag;
    }

    public void resetWFStepPSCodeListId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFStepPSCodeListId();
            return;
        }
        this.wfsteppscodelistidDirtyFlag = false;
        this.wfsteppscodelistid = null;
    }

    public void setWFStepPSCodeListName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFStepPSCodeListName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wfsteppscodelistname = string;
        this.wfsteppscodelistnameDirtyFlag = true;
    }

    public String getWFStepPSCodeListName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFStepPSCodeListName();
        }
        return this.wfsteppscodelistname;
    }

    public boolean isWFStepPSCodeListNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFStepPSCodeListNameDirty();
        }
        return this.wfsteppscodelistnameDirtyFlag;
    }

    public void resetWFStepPSCodeListName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFStepPSCodeListName();
            return;
        }
        this.wfsteppscodelistnameDirtyFlag = false;
        this.wfsteppscodelistname = null;
    }

    public void setWFVerMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFVerMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wfvermode = string;
        this.wfvermodeDirtyFlag = true;
    }

    public String getWFVerMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFVerMode();
        }
        return this.wfvermode;
    }

    public boolean isWFVerModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFVerModeDirty();
        }
        return this.wfvermodeDirtyFlag;
    }

    public void resetWFVerMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFVerMode();
            return;
        }
        this.wfvermodeDirtyFlag = false;
        this.wfvermode = null;
    }

    public void setWFVersion(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFVersion(n);
            return;
        }
        this.wfversion = n;
        this.wfversionDirtyFlag = true;
    }

    public Integer getWFVersion() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFVersion();
        }
        return this.wfversion;
    }

    public boolean isWFVersionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFVersionDirty();
        }
        return this.wfversionDirtyFlag;
    }

    public void resetWFVersion() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFVersion();
            return;
        }
        this.wfversionDirtyFlag = false;
        this.wfversion = null;
    }

    protected void onReset() {
        PSWFVersionBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSWFVersionBase pSWFVersionBase) {
        pSWFVersionBase.resetActivitiModel();
        pSWFVersionBase.resetBPMNModel();
        pSWFVersionBase.resetCreateDate();
        pSWFVersionBase.resetCreateMan();
        pSWFVersionBase.resetDynaModelFlag();
        pSWFVersionBase.resetDynaSysRefMode();
        pSWFVersionBase.resetDynaWFVer();
        pSWFVersionBase.resetEnable();
        pSWFVersionBase.resetEnableDynaSys();
        pSWFVersionBase.resetEnableLog();
        pSWFVersionBase.resetLastBackDataTag();
        pSWFVersionBase.resetMemo();
        pSWFVersionBase.resetPSDEUAGroupsCnt();
        pSWFVersionBase.resetPSDEUIActionsCnt();
        pSWFVersionBase.resetPSDynaInstId();
        pSWFVersionBase.resetPSDynaInstName();
        pSWFVersionBase.resetPSDynaWFVerId();
        pSWFVersionBase.resetPSDynaWFVerInstId();
        pSWFVersionBase.resetPSDynaWFVerInstName();
        pSWFVersionBase.resetPSDynaWFVerName();
        pSWFVersionBase.resetPSSysReqItemId();
        pSWFVersionBase.resetPSSysReqItemName();
        pSWFVersionBase.resetPSSystemId();
        pSWFVersionBase.resetPSSysWFModeId();
        pSWFVersionBase.resetPSSysWFModeName();
        pSWFVersionBase.resetPSWFId();
        pSWFVersionBase.resetPSWFName();
        pSWFVersionBase.resetPSWFVersionId();
        pSWFVersionBase.resetPSWFVersionName();
        pSWFVersionBase.resetRemoveFlag();
        pSWFVersionBase.resetToDoTask();
        pSWFVersionBase.resetUpdateDate();
        pSWFVersionBase.resetUpdateMan();
        pSWFVersionBase.resetUserCat();
        pSWFVersionBase.resetUserTag();
        pSWFVersionBase.resetUserTag2();
        pSWFVersionBase.resetUserTag3();
        pSWFVersionBase.resetUserTag4();
        pSWFVersionBase.resetValidFlag();
        pSWFVersionBase.resetVerTag();
        pSWFVersionBase.resetVerTag2();
        pSWFVersionBase.resetWFEngineType();
        pSWFVersionBase.resetWFMode();
        pSWFVersionBase.resetWFModel();
        pSWFVersionBase.resetWFStepPSCodeListId();
        pSWFVersionBase.resetWFStepPSCodeListName();
        pSWFVersionBase.resetWFVerMode();
        pSWFVersionBase.resetWFVersion();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isActivitiModelDirty()) {
            hashMap.put(FIELD_ACTIVITIMODEL, this.getActivitiModel());
        }
        if (!bl || this.isBPMNModelDirty()) {
            hashMap.put(FIELD_BPMNMODEL, this.getBPMNModel());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDynaModelFlagDirty()) {
            hashMap.put(FIELD_DYNAMODELFLAG, this.getDynaModelFlag());
        }
        if (!bl || this.isDynaSysRefModeDirty()) {
            hashMap.put(FIELD_DYNASYSREFMODE, this.getDynaSysRefMode());
        }
        if (!bl || this.isDynaWFVerDirty()) {
            hashMap.put(FIELD_DYNAWFVER, this.getDynaWFVer());
        }
        if (!bl || this.isEnableDirty()) {
            hashMap.put(FIELD_ENABLE, this.getEnable());
        }
        if (!bl || this.isEnableDynaSysDirty()) {
            hashMap.put(FIELD_ENABLEDYNASYS, this.getEnableDynaSys());
        }
        if (!bl || this.isEnableLogDirty()) {
            hashMap.put(FIELD_ENABLELOG, this.getEnableLog());
        }
        if (!bl || this.isLastBackDataTagDirty()) {
            hashMap.put(FIELD_LASTBACKDATATAG, this.getLastBackDataTag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDEUAGroupsCntDirty()) {
            hashMap.put(FIELD_PSDEUAGROUPSCNT, this.getPSDEUAGroupsCnt());
        }
        if (!bl || this.isPSDEUIActionsCntDirty()) {
            hashMap.put(FIELD_PSDEUIACTIONSCNT, this.getPSDEUIActionsCnt());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSDynaInstNameDirty()) {
            hashMap.put(FIELD_PSDYNAINSTNAME, this.getPSDynaInstName());
        }
        if (!bl || this.isPSDynaWFVerIdDirty()) {
            hashMap.put(FIELD_PSDYNAWFVERID, this.getPSDynaWFVerId());
        }
        if (!bl || this.isPSDynaWFVerInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAWFVERINSTID, this.getPSDynaWFVerInstId());
        }
        if (!bl || this.isPSDynaWFVerInstNameDirty()) {
            hashMap.put(FIELD_PSDYNAWFVERINSTNAME, this.getPSDynaWFVerInstName());
        }
        if (!bl || this.isPSDynaWFVerNameDirty()) {
            hashMap.put(FIELD_PSDYNAWFVERNAME, this.getPSDynaWFVerName());
        }
        if (!bl || this.isPSSysReqItemIdDirty()) {
            hashMap.put(FIELD_PSSYSREQITEMID, this.getPSSysReqItemId());
        }
        if (!bl || this.isPSSysReqItemNameDirty()) {
            hashMap.put(FIELD_PSSYSREQITEMNAME, this.getPSSysReqItemName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSysWFModeIdDirty()) {
            hashMap.put(FIELD_PSSYSWFMODEID, this.getPSSysWFModeId());
        }
        if (!bl || this.isPSSysWFModeNameDirty()) {
            hashMap.put(FIELD_PSSYSWFMODENAME, this.getPSSysWFModeName());
        }
        if (!bl || this.isPSWFIdDirty()) {
            hashMap.put(FIELD_PSWFID, this.getPSWFId());
        }
        if (!bl || this.isPSWFNameDirty()) {
            hashMap.put(FIELD_PSWFNAME, this.getPSWFName());
        }
        if (!bl || this.isPSWFVersionIdDirty()) {
            hashMap.put(FIELD_PSWFVERSIONID, this.getPSWFVersionId());
        }
        if (!bl || this.isPSWFVersionNameDirty()) {
            hashMap.put(FIELD_PSWFVERSIONNAME, this.getPSWFVersionName());
        }
        if (!bl || this.isRemoveFlagDirty()) {
            hashMap.put(FIELD_REMOVEFLAG, this.getRemoveFlag());
        }
        if (!bl || this.isToDoTaskDirty()) {
            hashMap.put(FIELD_TODOTASK, this.getToDoTask());
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
        if (!bl || this.isVerTagDirty()) {
            hashMap.put(FIELD_VERTAG, this.getVerTag());
        }
        if (!bl || this.isVerTag2Dirty()) {
            hashMap.put(FIELD_VERTAG2, this.getVerTag2());
        }
        if (!bl || this.isWFEngineTypeDirty()) {
            hashMap.put(FIELD_WFENGINETYPE, this.getWFEngineType());
        }
        if (!bl || this.isWFModeDirty()) {
            hashMap.put(FIELD_WFMODE, this.getWFMode());
        }
        if (!bl || this.isWFModelDirty()) {
            hashMap.put(FIELD_WFMODEL, this.getWFModel());
        }
        if (!bl || this.isWFStepPSCodeListIdDirty()) {
            hashMap.put(FIELD_WFSTEPPSCODELISTID, this.getWFStepPSCodeListId());
        }
        if (!bl || this.isWFStepPSCodeListNameDirty()) {
            hashMap.put(FIELD_WFSTEPPSCODELISTNAME, this.getWFStepPSCodeListName());
        }
        if (!bl || this.isWFVerModeDirty()) {
            hashMap.put(FIELD_WFVERMODE, this.getWFVerMode());
        }
        if (!bl || this.isWFVersionDirty()) {
            hashMap.put(FIELD_WFVERSION, this.getWFVersion());
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
        return PSWFVersionBase.get(this, n);
    }

    private static Object get(PSWFVersionBase pSWFVersionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWFVersionBase.getActivitiModel();
            }
            case 1: {
                return pSWFVersionBase.getBPMNModel();
            }
            case 2: {
                return pSWFVersionBase.getCreateDate();
            }
            case 3: {
                return pSWFVersionBase.getCreateMan();
            }
            case 4: {
                return pSWFVersionBase.getDynaModelFlag();
            }
            case 5: {
                return pSWFVersionBase.getDynaSysRefMode();
            }
            case 6: {
                return pSWFVersionBase.getDynaWFVer();
            }
            case 7: {
                return pSWFVersionBase.getEnable();
            }
            case 8: {
                return pSWFVersionBase.getEnableDynaSys();
            }
            case 9: {
                return pSWFVersionBase.getEnableLog();
            }
            case 10: {
                return pSWFVersionBase.getLastBackDataTag();
            }
            case 11: {
                return pSWFVersionBase.getMemo();
            }
            case 12: {
                return pSWFVersionBase.getPSDEUAGroupsCnt();
            }
            case 13: {
                return pSWFVersionBase.getPSDEUIActionsCnt();
            }
            case 14: {
                return pSWFVersionBase.getPSDynaInstId();
            }
            case 15: {
                return pSWFVersionBase.getPSDynaInstName();
            }
            case 16: {
                return pSWFVersionBase.getPSDynaWFVerId();
            }
            case 17: {
                return pSWFVersionBase.getPSDynaWFVerInstId();
            }
            case 18: {
                return pSWFVersionBase.getPSDynaWFVerInstName();
            }
            case 19: {
                return pSWFVersionBase.getPSDynaWFVerName();
            }
            case 20: {
                return pSWFVersionBase.getPSSysReqItemId();
            }
            case 21: {
                return pSWFVersionBase.getPSSysReqItemName();
            }
            case 22: {
                return pSWFVersionBase.getPSSystemId();
            }
            case 23: {
                return pSWFVersionBase.getPSSysWFModeId();
            }
            case 24: {
                return pSWFVersionBase.getPSSysWFModeName();
            }
            case 25: {
                return pSWFVersionBase.getPSWFId();
            }
            case 26: {
                return pSWFVersionBase.getPSWFName();
            }
            case 27: {
                return pSWFVersionBase.getPSWFVersionId();
            }
            case 28: {
                return pSWFVersionBase.getPSWFVersionName();
            }
            case 29: {
                return pSWFVersionBase.getRemoveFlag();
            }
            case 30: {
                return pSWFVersionBase.getToDoTask();
            }
            case 31: {
                return pSWFVersionBase.getUpdateDate();
            }
            case 32: {
                return pSWFVersionBase.getUpdateMan();
            }
            case 33: {
                return pSWFVersionBase.getUserCat();
            }
            case 34: {
                return pSWFVersionBase.getUserTag();
            }
            case 35: {
                return pSWFVersionBase.getUserTag2();
            }
            case 36: {
                return pSWFVersionBase.getUserTag3();
            }
            case 37: {
                return pSWFVersionBase.getUserTag4();
            }
            case 38: {
                return pSWFVersionBase.getValidFlag();
            }
            case 39: {
                return pSWFVersionBase.getVerTag();
            }
            case 40: {
                return pSWFVersionBase.getVerTag2();
            }
            case 41: {
                return pSWFVersionBase.getWFEngineType();
            }
            case 42: {
                return pSWFVersionBase.getWFMode();
            }
            case 43: {
                return pSWFVersionBase.getWFModel();
            }
            case 44: {
                return pSWFVersionBase.getWFStepPSCodeListId();
            }
            case 45: {
                return pSWFVersionBase.getWFStepPSCodeListName();
            }
            case 46: {
                return pSWFVersionBase.getWFVerMode();
            }
            case 47: {
                return pSWFVersionBase.getWFVersion();
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
        PSWFVersionBase.set(this, n, object);
    }

    private static void set(PSWFVersionBase pSWFVersionBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSWFVersionBase.setActivitiModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSWFVersionBase.setBPMNModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSWFVersionBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSWFVersionBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSWFVersionBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSWFVersionBase.setDynaSysRefMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSWFVersionBase.setDynaWFVer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSWFVersionBase.setEnable(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSWFVersionBase.setEnableDynaSys(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSWFVersionBase.setEnableLog(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSWFVersionBase.setLastBackDataTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSWFVersionBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSWFVersionBase.setPSDEUAGroupsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSWFVersionBase.setPSDEUIActionsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSWFVersionBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSWFVersionBase.setPSDynaInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSWFVersionBase.setPSDynaWFVerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSWFVersionBase.setPSDynaWFVerInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSWFVersionBase.setPSDynaWFVerInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSWFVersionBase.setPSDynaWFVerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSWFVersionBase.setPSSysReqItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSWFVersionBase.setPSSysReqItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSWFVersionBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSWFVersionBase.setPSSysWFModeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSWFVersionBase.setPSSysWFModeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSWFVersionBase.setPSWFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSWFVersionBase.setPSWFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSWFVersionBase.setPSWFVersionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSWFVersionBase.setPSWFVersionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSWFVersionBase.setRemoveFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 30: {
                pSWFVersionBase.setToDoTask(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSWFVersionBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 32: {
                pSWFVersionBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSWFVersionBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSWFVersionBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSWFVersionBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSWFVersionBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSWFVersionBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSWFVersionBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 39: {
                pSWFVersionBase.setVerTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSWFVersionBase.setVerTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSWFVersionBase.setWFEngineType(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSWFVersionBase.setWFMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSWFVersionBase.setWFModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSWFVersionBase.setWFStepPSCodeListId(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSWFVersionBase.setWFStepPSCodeListName(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSWFVersionBase.setWFVerMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSWFVersionBase.setWFVersion(DataObject.getIntegerValue((Object)object));
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
        return PSWFVersionBase.isNull(this, n);
    }

    private static boolean isNull(PSWFVersionBase pSWFVersionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWFVersionBase.getActivitiModel() == null;
            }
            case 1: {
                return pSWFVersionBase.getBPMNModel() == null;
            }
            case 2: {
                return pSWFVersionBase.getCreateDate() == null;
            }
            case 3: {
                return pSWFVersionBase.getCreateMan() == null;
            }
            case 4: {
                return pSWFVersionBase.getDynaModelFlag() == null;
            }
            case 5: {
                return pSWFVersionBase.getDynaSysRefMode() == null;
            }
            case 6: {
                return pSWFVersionBase.getDynaWFVer() == null;
            }
            case 7: {
                return pSWFVersionBase.getEnable() == null;
            }
            case 8: {
                return pSWFVersionBase.getEnableDynaSys() == null;
            }
            case 9: {
                return pSWFVersionBase.getEnableLog() == null;
            }
            case 10: {
                return pSWFVersionBase.getLastBackDataTag() == null;
            }
            case 11: {
                return pSWFVersionBase.getMemo() == null;
            }
            case 12: {
                return pSWFVersionBase.getPSDEUAGroupsCnt() == null;
            }
            case 13: {
                return pSWFVersionBase.getPSDEUIActionsCnt() == null;
            }
            case 14: {
                return pSWFVersionBase.getPSDynaInstId() == null;
            }
            case 15: {
                return pSWFVersionBase.getPSDynaInstName() == null;
            }
            case 16: {
                return pSWFVersionBase.getPSDynaWFVerId() == null;
            }
            case 17: {
                return pSWFVersionBase.getPSDynaWFVerInstId() == null;
            }
            case 18: {
                return pSWFVersionBase.getPSDynaWFVerInstName() == null;
            }
            case 19: {
                return pSWFVersionBase.getPSDynaWFVerName() == null;
            }
            case 20: {
                return pSWFVersionBase.getPSSysReqItemId() == null;
            }
            case 21: {
                return pSWFVersionBase.getPSSysReqItemName() == null;
            }
            case 22: {
                return pSWFVersionBase.getPSSystemId() == null;
            }
            case 23: {
                return pSWFVersionBase.getPSSysWFModeId() == null;
            }
            case 24: {
                return pSWFVersionBase.getPSSysWFModeName() == null;
            }
            case 25: {
                return pSWFVersionBase.getPSWFId() == null;
            }
            case 26: {
                return pSWFVersionBase.getPSWFName() == null;
            }
            case 27: {
                return pSWFVersionBase.getPSWFVersionId() == null;
            }
            case 28: {
                return pSWFVersionBase.getPSWFVersionName() == null;
            }
            case 29: {
                return pSWFVersionBase.getRemoveFlag() == null;
            }
            case 30: {
                return pSWFVersionBase.getToDoTask() == null;
            }
            case 31: {
                return pSWFVersionBase.getUpdateDate() == null;
            }
            case 32: {
                return pSWFVersionBase.getUpdateMan() == null;
            }
            case 33: {
                return pSWFVersionBase.getUserCat() == null;
            }
            case 34: {
                return pSWFVersionBase.getUserTag() == null;
            }
            case 35: {
                return pSWFVersionBase.getUserTag2() == null;
            }
            case 36: {
                return pSWFVersionBase.getUserTag3() == null;
            }
            case 37: {
                return pSWFVersionBase.getUserTag4() == null;
            }
            case 38: {
                return pSWFVersionBase.getValidFlag() == null;
            }
            case 39: {
                return pSWFVersionBase.getVerTag() == null;
            }
            case 40: {
                return pSWFVersionBase.getVerTag2() == null;
            }
            case 41: {
                return pSWFVersionBase.getWFEngineType() == null;
            }
            case 42: {
                return pSWFVersionBase.getWFMode() == null;
            }
            case 43: {
                return pSWFVersionBase.getWFModel() == null;
            }
            case 44: {
                return pSWFVersionBase.getWFStepPSCodeListId() == null;
            }
            case 45: {
                return pSWFVersionBase.getWFStepPSCodeListName() == null;
            }
            case 46: {
                return pSWFVersionBase.getWFVerMode() == null;
            }
            case 47: {
                return pSWFVersionBase.getWFVersion() == null;
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
        return PSWFVersionBase.contains(this, n);
    }

    private static boolean contains(PSWFVersionBase pSWFVersionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWFVersionBase.isActivitiModelDirty();
            }
            case 1: {
                return pSWFVersionBase.isBPMNModelDirty();
            }
            case 2: {
                return pSWFVersionBase.isCreateDateDirty();
            }
            case 3: {
                return pSWFVersionBase.isCreateManDirty();
            }
            case 4: {
                return pSWFVersionBase.isDynaModelFlagDirty();
            }
            case 5: {
                return pSWFVersionBase.isDynaSysRefModeDirty();
            }
            case 6: {
                return pSWFVersionBase.isDynaWFVerDirty();
            }
            case 7: {
                return pSWFVersionBase.isEnableDirty();
            }
            case 8: {
                return pSWFVersionBase.isEnableDynaSysDirty();
            }
            case 9: {
                return pSWFVersionBase.isEnableLogDirty();
            }
            case 10: {
                return pSWFVersionBase.isLastBackDataTagDirty();
            }
            case 11: {
                return pSWFVersionBase.isMemoDirty();
            }
            case 12: {
                return pSWFVersionBase.isPSDEUAGroupsCntDirty();
            }
            case 13: {
                return pSWFVersionBase.isPSDEUIActionsCntDirty();
            }
            case 14: {
                return pSWFVersionBase.isPSDynaInstIdDirty();
            }
            case 15: {
                return pSWFVersionBase.isPSDynaInstNameDirty();
            }
            case 16: {
                return pSWFVersionBase.isPSDynaWFVerIdDirty();
            }
            case 17: {
                return pSWFVersionBase.isPSDynaWFVerInstIdDirty();
            }
            case 18: {
                return pSWFVersionBase.isPSDynaWFVerInstNameDirty();
            }
            case 19: {
                return pSWFVersionBase.isPSDynaWFVerNameDirty();
            }
            case 20: {
                return pSWFVersionBase.isPSSysReqItemIdDirty();
            }
            case 21: {
                return pSWFVersionBase.isPSSysReqItemNameDirty();
            }
            case 22: {
                return pSWFVersionBase.isPSSystemIdDirty();
            }
            case 23: {
                return pSWFVersionBase.isPSSysWFModeIdDirty();
            }
            case 24: {
                return pSWFVersionBase.isPSSysWFModeNameDirty();
            }
            case 25: {
                return pSWFVersionBase.isPSWFIdDirty();
            }
            case 26: {
                return pSWFVersionBase.isPSWFNameDirty();
            }
            case 27: {
                return pSWFVersionBase.isPSWFVersionIdDirty();
            }
            case 28: {
                return pSWFVersionBase.isPSWFVersionNameDirty();
            }
            case 29: {
                return pSWFVersionBase.isRemoveFlagDirty();
            }
            case 30: {
                return pSWFVersionBase.isToDoTaskDirty();
            }
            case 31: {
                return pSWFVersionBase.isUpdateDateDirty();
            }
            case 32: {
                return pSWFVersionBase.isUpdateManDirty();
            }
            case 33: {
                return pSWFVersionBase.isUserCatDirty();
            }
            case 34: {
                return pSWFVersionBase.isUserTagDirty();
            }
            case 35: {
                return pSWFVersionBase.isUserTag2Dirty();
            }
            case 36: {
                return pSWFVersionBase.isUserTag3Dirty();
            }
            case 37: {
                return pSWFVersionBase.isUserTag4Dirty();
            }
            case 38: {
                return pSWFVersionBase.isValidFlagDirty();
            }
            case 39: {
                return pSWFVersionBase.isVerTagDirty();
            }
            case 40: {
                return pSWFVersionBase.isVerTag2Dirty();
            }
            case 41: {
                return pSWFVersionBase.isWFEngineTypeDirty();
            }
            case 42: {
                return pSWFVersionBase.isWFModeDirty();
            }
            case 43: {
                return pSWFVersionBase.isWFModelDirty();
            }
            case 44: {
                return pSWFVersionBase.isWFStepPSCodeListIdDirty();
            }
            case 45: {
                return pSWFVersionBase.isWFStepPSCodeListNameDirty();
            }
            case 46: {
                return pSWFVersionBase.isWFVerModeDirty();
            }
            case 47: {
                return pSWFVersionBase.isWFVersionDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSWFVersionBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSWFVersionBase pSWFVersionBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSWFVersionBase.getActivitiModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"activitimodel", (Object)PSWFVersionBase.getJSONValue((Object)pSWFVersionBase.getActivitiModel()), (boolean)false);
        }
        if (bl || pSWFVersionBase.getBPMNModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bpmnmodel", (Object)PSWFVersionBase.getJSONValue((Object)pSWFVersionBase.getBPMNModel()), (boolean)false);
        }
        if (bl || pSWFVersionBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSWFVersionBase.getJSONValue((Object)pSWFVersionBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSWFVersionBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSWFVersionBase.getJSONValue((Object)pSWFVersionBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSWFVersionBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSWFVersionBase.getJSONValue((Object)pSWFVersionBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSWFVersionBase.getDynaSysRefMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynasysrefmode", (Object)PSWFVersionBase.getJSONValue((Object)pSWFVersionBase.getDynaSysRefMode()), (boolean)false);
        }
        if (bl || pSWFVersionBase.getDynaWFVer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynawfver", (Object)PSWFVersionBase.getJSONValue((Object)pSWFVersionBase.getDynaWFVer()), (boolean)false);
        }
        if (bl || pSWFVersionBase.getEnable() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enable", (Object)PSWFVersionBase.getJSONValue((Object)pSWFVersionBase.getEnable()), (boolean)false);
        }
        if (bl || pSWFVersionBase.getEnableDynaSys() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enabledynasys", (Object)PSWFVersionBase.getJSONValue((Object)pSWFVersionBase.getEnableDynaSys()), (boolean)false);
        }
        if (bl || pSWFVersionBase.getEnableLog() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablelog", (Object)PSWFVersionBase.getJSONValue((Object)pSWFVersionBase.getEnableLog()), (boolean)false);
        }
        if (bl || pSWFVersionBase.getLastBackDataTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lastbackdatatag", (Object)PSWFVersionBase.getJSONValue((Object)pSWFVersionBase.getLastBackDataTag()), (boolean)false);
        }
        if (bl || pSWFVersionBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSWFVersionBase.getJSONValue((Object)pSWFVersionBase.getMemo()), (boolean)false);
        }
        if (bl || pSWFVersionBase.getPSDEUAGroupsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuagroupscnt", (Object)PSWFVersionBase.getJSONValue((Object)pSWFVersionBase.getPSDEUAGroupsCnt()), (boolean)false);
        }
        if (bl || pSWFVersionBase.getPSDEUIActionsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuiactionscnt", (Object)PSWFVersionBase.getJSONValue((Object)pSWFVersionBase.getPSDEUIActionsCnt()), (boolean)false);
        }
        if (bl || pSWFVersionBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSWFVersionBase.getJSONValue((Object)pSWFVersionBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSWFVersionBase.getPSDynaInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstname", (Object)PSWFVersionBase.getJSONValue((Object)pSWFVersionBase.getPSDynaInstName()), (boolean)false);
        }
        if (bl || pSWFVersionBase.getPSDynaWFVerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynawfverid", (Object)PSWFVersionBase.getJSONValue((Object)pSWFVersionBase.getPSDynaWFVerId()), (boolean)false);
        }
        if (bl || pSWFVersionBase.getPSDynaWFVerInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynawfverinstid", (Object)PSWFVersionBase.getJSONValue((Object)pSWFVersionBase.getPSDynaWFVerInstId()), (boolean)false);
        }
        if (bl || pSWFVersionBase.getPSDynaWFVerInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynawfverinstname", (Object)PSWFVersionBase.getJSONValue((Object)pSWFVersionBase.getPSDynaWFVerInstName()), (boolean)false);
        }
        if (bl || pSWFVersionBase.getPSDynaWFVerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynawfvername", (Object)PSWFVersionBase.getJSONValue((Object)pSWFVersionBase.getPSDynaWFVerName()), (boolean)false);
        }
        if (bl || pSWFVersionBase.getPSSysReqItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemid", (Object)PSWFVersionBase.getJSONValue((Object)pSWFVersionBase.getPSSysReqItemId()), (boolean)false);
        }
        if (bl || pSWFVersionBase.getPSSysReqItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemname", (Object)PSWFVersionBase.getJSONValue((Object)pSWFVersionBase.getPSSysReqItemName()), (boolean)false);
        }
        if (bl || pSWFVersionBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSWFVersionBase.getJSONValue((Object)pSWFVersionBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSWFVersionBase.getPSSysWFModeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyswfmodeid", (Object)PSWFVersionBase.getJSONValue((Object)pSWFVersionBase.getPSSysWFModeId()), (boolean)false);
        }
        if (bl || pSWFVersionBase.getPSSysWFModeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyswfmodename", (Object)PSWFVersionBase.getJSONValue((Object)pSWFVersionBase.getPSSysWFModeName()), (boolean)false);
        }
        if (bl || pSWFVersionBase.getPSWFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfid", (Object)PSWFVersionBase.getJSONValue((Object)pSWFVersionBase.getPSWFId()), (boolean)false);
        }
        if (bl || pSWFVersionBase.getPSWFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfname", (Object)PSWFVersionBase.getJSONValue((Object)pSWFVersionBase.getPSWFName()), (boolean)false);
        }
        if (bl || pSWFVersionBase.getPSWFVersionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfversionid", (Object)PSWFVersionBase.getJSONValue((Object)pSWFVersionBase.getPSWFVersionId()), (boolean)false);
        }
        if (bl || pSWFVersionBase.getPSWFVersionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfversionname", (Object)PSWFVersionBase.getJSONValue((Object)pSWFVersionBase.getPSWFVersionName()), (boolean)false);
        }
        if (bl || pSWFVersionBase.getRemoveFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"removeflag", (Object)PSWFVersionBase.getJSONValue((Object)pSWFVersionBase.getRemoveFlag()), (boolean)false);
        }
        if (bl || pSWFVersionBase.getToDoTask() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"todotask", (Object)PSWFVersionBase.getJSONValue((Object)pSWFVersionBase.getToDoTask()), (boolean)false);
        }
        if (bl || pSWFVersionBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSWFVersionBase.getJSONValue((Object)pSWFVersionBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSWFVersionBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSWFVersionBase.getJSONValue((Object)pSWFVersionBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSWFVersionBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSWFVersionBase.getJSONValue((Object)pSWFVersionBase.getUserCat()), (boolean)false);
        }
        if (bl || pSWFVersionBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSWFVersionBase.getJSONValue((Object)pSWFVersionBase.getUserTag()), (boolean)false);
        }
        if (bl || pSWFVersionBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSWFVersionBase.getJSONValue((Object)pSWFVersionBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSWFVersionBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSWFVersionBase.getJSONValue((Object)pSWFVersionBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSWFVersionBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSWFVersionBase.getJSONValue((Object)pSWFVersionBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSWFVersionBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSWFVersionBase.getJSONValue((Object)pSWFVersionBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSWFVersionBase.getVerTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"vertag", (Object)PSWFVersionBase.getJSONValue((Object)pSWFVersionBase.getVerTag()), (boolean)false);
        }
        if (bl || pSWFVersionBase.getVerTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"vertag2", (Object)PSWFVersionBase.getJSONValue((Object)pSWFVersionBase.getVerTag2()), (boolean)false);
        }
        if (bl || pSWFVersionBase.getWFEngineType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wfenginetype", (Object)PSWFVersionBase.getJSONValue((Object)pSWFVersionBase.getWFEngineType()), (boolean)false);
        }
        if (bl || pSWFVersionBase.getWFMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wfmode", (Object)PSWFVersionBase.getJSONValue((Object)pSWFVersionBase.getWFMode()), (boolean)false);
        }
        if (bl || pSWFVersionBase.getWFModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wfmodel", (Object)PSWFVersionBase.getJSONValue((Object)pSWFVersionBase.getWFModel()), (boolean)false);
        }
        if (bl || pSWFVersionBase.getWFStepPSCodeListId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wfsteppscodelistid", (Object)PSWFVersionBase.getJSONValue((Object)pSWFVersionBase.getWFStepPSCodeListId()), (boolean)false);
        }
        if (bl || pSWFVersionBase.getWFStepPSCodeListName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wfsteppscodelistname", (Object)PSWFVersionBase.getJSONValue((Object)pSWFVersionBase.getWFStepPSCodeListName()), (boolean)false);
        }
        if (bl || pSWFVersionBase.getWFVerMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wfvermode", (Object)PSWFVersionBase.getJSONValue((Object)pSWFVersionBase.getWFVerMode()), (boolean)false);
        }
        if (bl || pSWFVersionBase.getWFVersion() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wfversion", (Object)PSWFVersionBase.getJSONValue((Object)pSWFVersionBase.getWFVersion()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSWFVersionBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSWFVersionBase pSWFVersionBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSWFVersionBase.getActivitiModel() != null) {
            object = pSWFVersionBase.getActivitiModel();
            xmlNode.setAttribute(FIELD_ACTIVITIMODEL, (String)(object == null ? "" : object));
        }
        if (bl || pSWFVersionBase.getBPMNModel() != null) {
            object = pSWFVersionBase.getBPMNModel();
            xmlNode.setAttribute(FIELD_BPMNMODEL, object == null ? "" : (String)object);
        }
        if (bl || pSWFVersionBase.getCreateDate() != null) {
            object = pSWFVersionBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWFVersionBase.getCreateMan() != null) {
            object = pSWFVersionBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSWFVersionBase.getDynaModelFlag() != null) {
            object = pSWFVersionBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWFVersionBase.getDynaSysRefMode() != null) {
            object = pSWFVersionBase.getDynaSysRefMode();
            xmlNode.setAttribute(FIELD_DYNASYSREFMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWFVersionBase.getDynaWFVer() != null) {
            object = pSWFVersionBase.getDynaWFVer();
            xmlNode.setAttribute(FIELD_DYNAWFVER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWFVersionBase.getEnable() != null) {
            object = pSWFVersionBase.getEnable();
            xmlNode.setAttribute(FIELD_ENABLE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWFVersionBase.getEnableDynaSys() != null) {
            object = pSWFVersionBase.getEnableDynaSys();
            xmlNode.setAttribute(FIELD_ENABLEDYNASYS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWFVersionBase.getEnableLog() != null) {
            object = pSWFVersionBase.getEnableLog();
            xmlNode.setAttribute(FIELD_ENABLELOG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWFVersionBase.getLastBackDataTag() != null) {
            object = pSWFVersionBase.getLastBackDataTag();
            xmlNode.setAttribute(FIELD_LASTBACKDATATAG, object == null ? "" : (String)object);
        }
        if (bl || pSWFVersionBase.getMemo() != null) {
            object = pSWFVersionBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSWFVersionBase.getPSDEUAGroupsCnt() != null) {
            object = pSWFVersionBase.getPSDEUAGroupsCnt();
            xmlNode.setAttribute(FIELD_PSDEUAGROUPSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWFVersionBase.getPSDEUIActionsCnt() != null) {
            object = pSWFVersionBase.getPSDEUIActionsCnt();
            xmlNode.setAttribute(FIELD_PSDEUIACTIONSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWFVersionBase.getPSDynaInstId() != null) {
            object = pSWFVersionBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSWFVersionBase.getPSDynaInstName() != null) {
            object = pSWFVersionBase.getPSDynaInstName();
            xmlNode.setAttribute(FIELD_PSDYNAINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFVersionBase.getPSDynaWFVerId() != null) {
            object = pSWFVersionBase.getPSDynaWFVerId();
            xmlNode.setAttribute(FIELD_PSDYNAWFVERID, object == null ? "" : (String)object);
        }
        if (bl || pSWFVersionBase.getPSDynaWFVerInstId() != null) {
            object = pSWFVersionBase.getPSDynaWFVerInstId();
            xmlNode.setAttribute(FIELD_PSDYNAWFVERINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSWFVersionBase.getPSDynaWFVerInstName() != null) {
            object = pSWFVersionBase.getPSDynaWFVerInstName();
            xmlNode.setAttribute(FIELD_PSDYNAWFVERINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFVersionBase.getPSDynaWFVerName() != null) {
            object = pSWFVersionBase.getPSDynaWFVerName();
            xmlNode.setAttribute(FIELD_PSDYNAWFVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFVersionBase.getPSSysReqItemId() != null) {
            object = pSWFVersionBase.getPSSysReqItemId();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSWFVersionBase.getPSSysReqItemName() != null) {
            object = pSWFVersionBase.getPSSysReqItemName();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFVersionBase.getPSSystemId() != null) {
            object = pSWFVersionBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSWFVersionBase.getPSSysWFModeId() != null) {
            object = pSWFVersionBase.getPSSysWFModeId();
            xmlNode.setAttribute(FIELD_PSSYSWFMODEID, object == null ? "" : (String)object);
        }
        if (bl || pSWFVersionBase.getPSSysWFModeName() != null) {
            object = pSWFVersionBase.getPSSysWFModeName();
            xmlNode.setAttribute(FIELD_PSSYSWFMODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFVersionBase.getPSWFId() != null) {
            object = pSWFVersionBase.getPSWFId();
            xmlNode.setAttribute(FIELD_PSWFID, object == null ? "" : (String)object);
        }
        if (bl || pSWFVersionBase.getPSWFName() != null) {
            object = pSWFVersionBase.getPSWFName();
            xmlNode.setAttribute(FIELD_PSWFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFVersionBase.getPSWFVersionId() != null) {
            object = pSWFVersionBase.getPSWFVersionId();
            xmlNode.setAttribute(FIELD_PSWFVERSIONID, object == null ? "" : (String)object);
        }
        if (bl || pSWFVersionBase.getPSWFVersionName() != null) {
            object = pSWFVersionBase.getPSWFVersionName();
            xmlNode.setAttribute(FIELD_PSWFVERSIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFVersionBase.getRemoveFlag() != null) {
            object = pSWFVersionBase.getRemoveFlag();
            xmlNode.setAttribute(FIELD_REMOVEFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWFVersionBase.getToDoTask() != null) {
            object = pSWFVersionBase.getToDoTask();
            xmlNode.setAttribute(FIELD_TODOTASK, object == null ? "" : (String)object);
        }
        if (bl || pSWFVersionBase.getUpdateDate() != null) {
            object = pSWFVersionBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWFVersionBase.getUpdateMan() != null) {
            object = pSWFVersionBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSWFVersionBase.getUserCat() != null) {
            object = pSWFVersionBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSWFVersionBase.getUserTag() != null) {
            object = pSWFVersionBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSWFVersionBase.getUserTag2() != null) {
            object = pSWFVersionBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSWFVersionBase.getUserTag3() != null) {
            object = pSWFVersionBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSWFVersionBase.getUserTag4() != null) {
            object = pSWFVersionBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSWFVersionBase.getValidFlag() != null) {
            object = pSWFVersionBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWFVersionBase.getVerTag() != null) {
            object = pSWFVersionBase.getVerTag();
            xmlNode.setAttribute(FIELD_VERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSWFVersionBase.getVerTag2() != null) {
            object = pSWFVersionBase.getVerTag2();
            xmlNode.setAttribute(FIELD_VERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSWFVersionBase.getWFEngineType() != null) {
            object = pSWFVersionBase.getWFEngineType();
            xmlNode.setAttribute(FIELD_WFENGINETYPE, object == null ? "" : (String)object);
        }
        if (bl || pSWFVersionBase.getWFMode() != null) {
            object = pSWFVersionBase.getWFMode();
            xmlNode.setAttribute(FIELD_WFMODE, object == null ? "" : (String)object);
        }
        if (bl || pSWFVersionBase.getWFModel() != null) {
            object = pSWFVersionBase.getWFModel();
            xmlNode.setAttribute(FIELD_WFMODEL, object == null ? "" : (String)object);
        }
        if (bl || pSWFVersionBase.getWFStepPSCodeListId() != null) {
            object = pSWFVersionBase.getWFStepPSCodeListId();
            xmlNode.setAttribute(FIELD_WFSTEPPSCODELISTID, object == null ? "" : (String)object);
        }
        if (bl || pSWFVersionBase.getWFStepPSCodeListName() != null) {
            object = pSWFVersionBase.getWFStepPSCodeListName();
            xmlNode.setAttribute(FIELD_WFSTEPPSCODELISTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFVersionBase.getWFVerMode() != null) {
            object = pSWFVersionBase.getWFVerMode();
            xmlNode.setAttribute(FIELD_WFVERMODE, object == null ? "" : (String)object);
        }
        if (bl || pSWFVersionBase.getWFVersion() != null) {
            object = pSWFVersionBase.getWFVersion();
            xmlNode.setAttribute(FIELD_WFVERSION, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSWFVersionBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSWFVersionBase pSWFVersionBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSWFVersionBase.isActivitiModelDirty() && (bl || pSWFVersionBase.getActivitiModel() != null)) {
            iDataObject.set(FIELD_ACTIVITIMODEL, (Object)pSWFVersionBase.getActivitiModel());
        }
        if (pSWFVersionBase.isBPMNModelDirty() && (bl || pSWFVersionBase.getBPMNModel() != null)) {
            iDataObject.set(FIELD_BPMNMODEL, (Object)pSWFVersionBase.getBPMNModel());
        }
        if (pSWFVersionBase.isCreateDateDirty() && (bl || pSWFVersionBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSWFVersionBase.getCreateDate());
        }
        if (pSWFVersionBase.isCreateManDirty() && (bl || pSWFVersionBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSWFVersionBase.getCreateMan());
        }
        if (pSWFVersionBase.isDynaModelFlagDirty() && (bl || pSWFVersionBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSWFVersionBase.getDynaModelFlag());
        }
        if (pSWFVersionBase.isDynaSysRefModeDirty() && (bl || pSWFVersionBase.getDynaSysRefMode() != null)) {
            iDataObject.set(FIELD_DYNASYSREFMODE, (Object)pSWFVersionBase.getDynaSysRefMode());
        }
        if (pSWFVersionBase.isDynaWFVerDirty() && (bl || pSWFVersionBase.getDynaWFVer() != null)) {
            iDataObject.set(FIELD_DYNAWFVER, (Object)pSWFVersionBase.getDynaWFVer());
        }
        if (pSWFVersionBase.isEnableDirty() && (bl || pSWFVersionBase.getEnable() != null)) {
            iDataObject.set(FIELD_ENABLE, (Object)pSWFVersionBase.getEnable());
        }
        if (pSWFVersionBase.isEnableDynaSysDirty() && (bl || pSWFVersionBase.getEnableDynaSys() != null)) {
            iDataObject.set(FIELD_ENABLEDYNASYS, (Object)pSWFVersionBase.getEnableDynaSys());
        }
        if (pSWFVersionBase.isEnableLogDirty() && (bl || pSWFVersionBase.getEnableLog() != null)) {
            iDataObject.set(FIELD_ENABLELOG, (Object)pSWFVersionBase.getEnableLog());
        }
        if (pSWFVersionBase.isLastBackDataTagDirty() && (bl || pSWFVersionBase.getLastBackDataTag() != null)) {
            iDataObject.set(FIELD_LASTBACKDATATAG, (Object)pSWFVersionBase.getLastBackDataTag());
        }
        if (pSWFVersionBase.isMemoDirty() && (bl || pSWFVersionBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSWFVersionBase.getMemo());
        }
        if (pSWFVersionBase.isPSDEUAGroupsCntDirty() && (bl || pSWFVersionBase.getPSDEUAGroupsCnt() != null)) {
            iDataObject.set(FIELD_PSDEUAGROUPSCNT, (Object)pSWFVersionBase.getPSDEUAGroupsCnt());
        }
        if (pSWFVersionBase.isPSDEUIActionsCntDirty() && (bl || pSWFVersionBase.getPSDEUIActionsCnt() != null)) {
            iDataObject.set(FIELD_PSDEUIACTIONSCNT, (Object)pSWFVersionBase.getPSDEUIActionsCnt());
        }
        if (pSWFVersionBase.isPSDynaInstIdDirty() && (bl || pSWFVersionBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSWFVersionBase.getPSDynaInstId());
        }
        if (pSWFVersionBase.isPSDynaInstNameDirty() && (bl || pSWFVersionBase.getPSDynaInstName() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTNAME, (Object)pSWFVersionBase.getPSDynaInstName());
        }
        if (pSWFVersionBase.isPSDynaWFVerIdDirty() && (bl || pSWFVersionBase.getPSDynaWFVerId() != null)) {
            iDataObject.set(FIELD_PSDYNAWFVERID, (Object)pSWFVersionBase.getPSDynaWFVerId());
        }
        if (pSWFVersionBase.isPSDynaWFVerInstIdDirty() && (bl || pSWFVersionBase.getPSDynaWFVerInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAWFVERINSTID, (Object)pSWFVersionBase.getPSDynaWFVerInstId());
        }
        if (pSWFVersionBase.isPSDynaWFVerInstNameDirty() && (bl || pSWFVersionBase.getPSDynaWFVerInstName() != null)) {
            iDataObject.set(FIELD_PSDYNAWFVERINSTNAME, (Object)pSWFVersionBase.getPSDynaWFVerInstName());
        }
        if (pSWFVersionBase.isPSDynaWFVerNameDirty() && (bl || pSWFVersionBase.getPSDynaWFVerName() != null)) {
            iDataObject.set(FIELD_PSDYNAWFVERNAME, (Object)pSWFVersionBase.getPSDynaWFVerName());
        }
        if (pSWFVersionBase.isPSSysReqItemIdDirty() && (bl || pSWFVersionBase.getPSSysReqItemId() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMID, (Object)pSWFVersionBase.getPSSysReqItemId());
        }
        if (pSWFVersionBase.isPSSysReqItemNameDirty() && (bl || pSWFVersionBase.getPSSysReqItemName() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMNAME, (Object)pSWFVersionBase.getPSSysReqItemName());
        }
        if (pSWFVersionBase.isPSSystemIdDirty() && (bl || pSWFVersionBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSWFVersionBase.getPSSystemId());
        }
        if (pSWFVersionBase.isPSSysWFModeIdDirty() && (bl || pSWFVersionBase.getPSSysWFModeId() != null)) {
            iDataObject.set(FIELD_PSSYSWFMODEID, (Object)pSWFVersionBase.getPSSysWFModeId());
        }
        if (pSWFVersionBase.isPSSysWFModeNameDirty() && (bl || pSWFVersionBase.getPSSysWFModeName() != null)) {
            iDataObject.set(FIELD_PSSYSWFMODENAME, (Object)pSWFVersionBase.getPSSysWFModeName());
        }
        if (pSWFVersionBase.isPSWFIdDirty() && (bl || pSWFVersionBase.getPSWFId() != null)) {
            iDataObject.set(FIELD_PSWFID, (Object)pSWFVersionBase.getPSWFId());
        }
        if (pSWFVersionBase.isPSWFNameDirty() && (bl || pSWFVersionBase.getPSWFName() != null)) {
            iDataObject.set(FIELD_PSWFNAME, (Object)pSWFVersionBase.getPSWFName());
        }
        if (pSWFVersionBase.isPSWFVersionIdDirty() && (bl || pSWFVersionBase.getPSWFVersionId() != null)) {
            iDataObject.set(FIELD_PSWFVERSIONID, (Object)pSWFVersionBase.getPSWFVersionId());
        }
        if (pSWFVersionBase.isPSWFVersionNameDirty() && (bl || pSWFVersionBase.getPSWFVersionName() != null)) {
            iDataObject.set(FIELD_PSWFVERSIONNAME, (Object)pSWFVersionBase.getPSWFVersionName());
        }
        if (pSWFVersionBase.isRemoveFlagDirty() && (bl || pSWFVersionBase.getRemoveFlag() != null)) {
            iDataObject.set(FIELD_REMOVEFLAG, (Object)pSWFVersionBase.getRemoveFlag());
        }
        if (pSWFVersionBase.isToDoTaskDirty() && (bl || pSWFVersionBase.getToDoTask() != null)) {
            iDataObject.set(FIELD_TODOTASK, (Object)pSWFVersionBase.getToDoTask());
        }
        if (pSWFVersionBase.isUpdateDateDirty() && (bl || pSWFVersionBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSWFVersionBase.getUpdateDate());
        }
        if (pSWFVersionBase.isUpdateManDirty() && (bl || pSWFVersionBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSWFVersionBase.getUpdateMan());
        }
        if (pSWFVersionBase.isUserCatDirty() && (bl || pSWFVersionBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSWFVersionBase.getUserCat());
        }
        if (pSWFVersionBase.isUserTagDirty() && (bl || pSWFVersionBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSWFVersionBase.getUserTag());
        }
        if (pSWFVersionBase.isUserTag2Dirty() && (bl || pSWFVersionBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSWFVersionBase.getUserTag2());
        }
        if (pSWFVersionBase.isUserTag3Dirty() && (bl || pSWFVersionBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSWFVersionBase.getUserTag3());
        }
        if (pSWFVersionBase.isUserTag4Dirty() && (bl || pSWFVersionBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSWFVersionBase.getUserTag4());
        }
        if (pSWFVersionBase.isValidFlagDirty() && (bl || pSWFVersionBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSWFVersionBase.getValidFlag());
        }
        if (pSWFVersionBase.isVerTagDirty() && (bl || pSWFVersionBase.getVerTag() != null)) {
            iDataObject.set(FIELD_VERTAG, (Object)pSWFVersionBase.getVerTag());
        }
        if (pSWFVersionBase.isVerTag2Dirty() && (bl || pSWFVersionBase.getVerTag2() != null)) {
            iDataObject.set(FIELD_VERTAG2, (Object)pSWFVersionBase.getVerTag2());
        }
        if (pSWFVersionBase.isWFEngineTypeDirty() && (bl || pSWFVersionBase.getWFEngineType() != null)) {
            iDataObject.set(FIELD_WFENGINETYPE, (Object)pSWFVersionBase.getWFEngineType());
        }
        if (pSWFVersionBase.isWFModeDirty() && (bl || pSWFVersionBase.getWFMode() != null)) {
            iDataObject.set(FIELD_WFMODE, (Object)pSWFVersionBase.getWFMode());
        }
        if (pSWFVersionBase.isWFModelDirty() && (bl || pSWFVersionBase.getWFModel() != null)) {
            iDataObject.set(FIELD_WFMODEL, (Object)pSWFVersionBase.getWFModel());
        }
        if (pSWFVersionBase.isWFStepPSCodeListIdDirty() && (bl || pSWFVersionBase.getWFStepPSCodeListId() != null)) {
            iDataObject.set(FIELD_WFSTEPPSCODELISTID, (Object)pSWFVersionBase.getWFStepPSCodeListId());
        }
        if (pSWFVersionBase.isWFStepPSCodeListNameDirty() && (bl || pSWFVersionBase.getWFStepPSCodeListName() != null)) {
            iDataObject.set(FIELD_WFSTEPPSCODELISTNAME, (Object)pSWFVersionBase.getWFStepPSCodeListName());
        }
        if (pSWFVersionBase.isWFVerModeDirty() && (bl || pSWFVersionBase.getWFVerMode() != null)) {
            iDataObject.set(FIELD_WFVERMODE, (Object)pSWFVersionBase.getWFVerMode());
        }
        if (pSWFVersionBase.isWFVersionDirty() && (bl || pSWFVersionBase.getWFVersion() != null)) {
            iDataObject.set(FIELD_WFVERSION, (Object)pSWFVersionBase.getWFVersion());
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
        return PSWFVersionBase.remove(this, n);
    }

    private static boolean remove(PSWFVersionBase pSWFVersionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSWFVersionBase.resetActivitiModel();
                return true;
            }
            case 1: {
                pSWFVersionBase.resetBPMNModel();
                return true;
            }
            case 2: {
                pSWFVersionBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSWFVersionBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSWFVersionBase.resetDynaModelFlag();
                return true;
            }
            case 5: {
                pSWFVersionBase.resetDynaSysRefMode();
                return true;
            }
            case 6: {
                pSWFVersionBase.resetDynaWFVer();
                return true;
            }
            case 7: {
                pSWFVersionBase.resetEnable();
                return true;
            }
            case 8: {
                pSWFVersionBase.resetEnableDynaSys();
                return true;
            }
            case 9: {
                pSWFVersionBase.resetEnableLog();
                return true;
            }
            case 10: {
                pSWFVersionBase.resetLastBackDataTag();
                return true;
            }
            case 11: {
                pSWFVersionBase.resetMemo();
                return true;
            }
            case 12: {
                pSWFVersionBase.resetPSDEUAGroupsCnt();
                return true;
            }
            case 13: {
                pSWFVersionBase.resetPSDEUIActionsCnt();
                return true;
            }
            case 14: {
                pSWFVersionBase.resetPSDynaInstId();
                return true;
            }
            case 15: {
                pSWFVersionBase.resetPSDynaInstName();
                return true;
            }
            case 16: {
                pSWFVersionBase.resetPSDynaWFVerId();
                return true;
            }
            case 17: {
                pSWFVersionBase.resetPSDynaWFVerInstId();
                return true;
            }
            case 18: {
                pSWFVersionBase.resetPSDynaWFVerInstName();
                return true;
            }
            case 19: {
                pSWFVersionBase.resetPSDynaWFVerName();
                return true;
            }
            case 20: {
                pSWFVersionBase.resetPSSysReqItemId();
                return true;
            }
            case 21: {
                pSWFVersionBase.resetPSSysReqItemName();
                return true;
            }
            case 22: {
                pSWFVersionBase.resetPSSystemId();
                return true;
            }
            case 23: {
                pSWFVersionBase.resetPSSysWFModeId();
                return true;
            }
            case 24: {
                pSWFVersionBase.resetPSSysWFModeName();
                return true;
            }
            case 25: {
                pSWFVersionBase.resetPSWFId();
                return true;
            }
            case 26: {
                pSWFVersionBase.resetPSWFName();
                return true;
            }
            case 27: {
                pSWFVersionBase.resetPSWFVersionId();
                return true;
            }
            case 28: {
                pSWFVersionBase.resetPSWFVersionName();
                return true;
            }
            case 29: {
                pSWFVersionBase.resetRemoveFlag();
                return true;
            }
            case 30: {
                pSWFVersionBase.resetToDoTask();
                return true;
            }
            case 31: {
                pSWFVersionBase.resetUpdateDate();
                return true;
            }
            case 32: {
                pSWFVersionBase.resetUpdateMan();
                return true;
            }
            case 33: {
                pSWFVersionBase.resetUserCat();
                return true;
            }
            case 34: {
                pSWFVersionBase.resetUserTag();
                return true;
            }
            case 35: {
                pSWFVersionBase.resetUserTag2();
                return true;
            }
            case 36: {
                pSWFVersionBase.resetUserTag3();
                return true;
            }
            case 37: {
                pSWFVersionBase.resetUserTag4();
                return true;
            }
            case 38: {
                pSWFVersionBase.resetValidFlag();
                return true;
            }
            case 39: {
                pSWFVersionBase.resetVerTag();
                return true;
            }
            case 40: {
                pSWFVersionBase.resetVerTag2();
                return true;
            }
            case 41: {
                pSWFVersionBase.resetWFEngineType();
                return true;
            }
            case 42: {
                pSWFVersionBase.resetWFMode();
                return true;
            }
            case 43: {
                pSWFVersionBase.resetWFModel();
                return true;
            }
            case 44: {
                pSWFVersionBase.resetWFStepPSCodeListId();
                return true;
            }
            case 45: {
                pSWFVersionBase.resetWFStepPSCodeListName();
                return true;
            }
            case 46: {
                pSWFVersionBase.resetWFVerMode();
                return true;
            }
            case 47: {
                pSWFVersionBase.resetWFVersion();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCodeList getWFStepPSCodeList() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFStepPSCodeList();
        }
        if (this.getWFStepPSCodeListId() == null) {
            return null;
        }
        Integer n = this.objWFStepPSCodeListLock;
        synchronized (n) {
            if (this.wfsteppscodelist != null && DataTypeHelper.compare((int)25, (Object)this.getWFStepPSCodeListId(), (Object)this.wfsteppscodelist.getPSCodeListId()) != 0L) {
                this.wfsteppscodelist = null;
            }
            if (this.wfsteppscodelist == null) {
                PSCodeList pSCodeList = new PSCodeList();
                pSCodeList.setPSCodeListId(this.getWFStepPSCodeListId());
                PSCodeListService pSCodeListService = (PSCodeListService)ServiceGlobal.getService(PSCodeListService.class, (SessionFactory)this.getSessionFactory());
                pSCodeListService.autoGet(pSCodeList);
                this.wfsteppscodelist = pSCodeList;
            }
            return this.wfsteppscodelist;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDynaInst getPSDynaInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaInst();
        }
        if (this.getPSDynaInstId() == null) {
            return null;
        }
        Integer n = this.objPSDynaInstLock;
        synchronized (n) {
            if (this.psdynainst != null && DataTypeHelper.compare((int)25, (Object)this.getPSDynaInstId(), (Object)this.psdynainst.getPSDynaInstId()) != 0L) {
                this.psdynainst = null;
            }
            if (this.psdynainst == null) {
                PSDynaInst pSDynaInst = new PSDynaInst();
                pSDynaInst.setPSDynaInstId(this.getPSDynaInstId());
                PSDynaInstService pSDynaInstService = (PSDynaInstService)ServiceGlobal.getService(PSDynaInstService.class, (SessionFactory)this.getSessionFactory());
                pSDynaInstService.autoGet(pSDynaInst);
                this.psdynainst = pSDynaInst;
            }
            return this.psdynainst;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDynaWFVer getPSDynaWFVer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaWFVer();
        }
        if (this.getPSDynaWFVerId() == null) {
            return null;
        }
        Integer n = this.objPSDynaWFVerLock;
        synchronized (n) {
            if (this.psdynawfver != null && DataTypeHelper.compare((int)25, (Object)this.getPSDynaWFVerId(), (Object)this.psdynawfver.getPSDynaWFVerId()) != 0L) {
                this.psdynawfver = null;
            }
            if (this.psdynawfver == null) {
                PSDynaWFVer pSDynaWFVer = new PSDynaWFVer();
                pSDynaWFVer.setPSDynaWFVerId(this.getPSDynaWFVerId());
                PSDynaWFVerService pSDynaWFVerService = (PSDynaWFVerService)ServiceGlobal.getService(PSDynaWFVerService.class, (SessionFactory)this.getSessionFactory());
                pSDynaWFVerService.autoGet(pSDynaWFVer);
                this.psdynawfver = pSDynaWFVer;
            }
            return this.psdynawfver;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysReqItem getPSSysReqItem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysReqItem();
        }
        if (this.getPSSysReqItemId() == null) {
            return null;
        }
        Integer n = this.objPSSysReqItemLock;
        synchronized (n) {
            if (this.pssysreqitem != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysReqItemId(), (Object)this.pssysreqitem.getPSSysReqItemId()) != 0L) {
                this.pssysreqitem = null;
            }
            if (this.pssysreqitem == null) {
                PSSysReqItem pSSysReqItem = new PSSysReqItem();
                pSSysReqItem.setPSSysReqItemId(this.getPSSysReqItemId());
                PSSysReqItemService pSSysReqItemService = (PSSysReqItemService)ServiceGlobal.getService(PSSysReqItemService.class, (SessionFactory)this.getSessionFactory());
                pSSysReqItemService.autoGet(pSSysReqItem);
                this.pssysreqitem = pSSysReqItem;
            }
            return this.pssysreqitem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysWFMode getPSSysWFMode() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysWFMode();
        }
        if (this.getPSSysWFModeId() == null) {
            return null;
        }
        Integer n = this.objPSSysWFModeLock;
        synchronized (n) {
            if (this.pssyswfmode != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysWFModeId(), (Object)this.pssyswfmode.getPSSysWFModeId()) != 0L) {
                this.pssyswfmode = null;
            }
            if (this.pssyswfmode == null) {
                PSSysWFMode pSSysWFMode = new PSSysWFMode();
                pSSysWFMode.setPSSysWFModeId(this.getPSSysWFModeId());
                PSSysWFModeService pSSysWFModeService = (PSSysWFModeService)ServiceGlobal.getService(PSSysWFModeService.class, (SessionFactory)this.getSessionFactory());
                pSSysWFModeService.autoGet(pSSysWFMode);
                this.pssyswfmode = pSSysWFMode;
            }
            return this.pssyswfmode;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSWorkflow getPSWF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWF();
        }
        if (this.getPSWFId() == null) {
            return null;
        }
        Integer n = this.objPSWFLock;
        synchronized (n) {
            if (this.pswf != null && DataTypeHelper.compare((int)25, (Object)this.getPSWFId(), (Object)this.pswf.getPSWorkflowId()) != 0L) {
                this.pswf = null;
            }
            if (this.pswf == null) {
                PSWorkflow pSWorkflow = new PSWorkflow();
                pSWorkflow.setPSWorkflowId(this.getPSWFId());
                PSWorkflowService pSWorkflowService = (PSWorkflowService)ServiceGlobal.getService(PSWorkflowService.class, (SessionFactory)this.getSessionFactory());
                pSWorkflowService.autoGet(pSWorkflow);
                this.pswf = pSWorkflow;
            }
            return this.pswf;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEUAGroup> getPSDEUAGroups() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUAGroups();
        }
        if (this.getPSWFVersionId() == null) {
            return null;
        }
        PSDEUAGroupService pSDEUAGroupService = (PSDEUAGroupService)ServiceGlobal.getService(PSDEUAGroupService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEUAGroupsLock;
        synchronized (n) {
            if (this.psdeuagroups == null) {
                this.psdeuagroups = pSDEUAGroupService.selectByPSWFVersion(this);
            }
            return this.psdeuagroups;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEUIAction> getPSDEUIActions() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUIActions();
        }
        if (this.getPSWFVersionId() == null) {
            return null;
        }
        PSDEUIActionService pSDEUIActionService = (PSDEUIActionService)ServiceGlobal.getService(PSDEUIActionService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEUIActionsLock;
        synchronized (n) {
            if (this.psdeuiactions == null) {
                this.psdeuiactions = pSDEUIActionService.selectByPSWFVersion(this);
            }
            return this.psdeuiactions;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSWFLink> getPSWFLinks() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFLinks();
        }
        if (this.getPSWFVersionId() == null) {
            return null;
        }
        PSWFVersionService pSWFVersionService = (PSWFVersionService)ServiceGlobal.getService(PSWFVersionService.class, (SessionFactory)this.getSessionFactory());
        PSWFLinkService pSWFLinkService = (PSWFLinkService)ServiceGlobal.getService(PSWFLinkService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSWFLinksLock;
        synchronized (n) {
            if (this.pswflinks == null) {
                this.pswflinks = pSWFVersionService.isTempData(this) ? pSWFLinkService.selectTempByPSWFVersion(this) : pSWFLinkService.selectByPSWFVersion(this);
            }
            return this.pswflinks;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSWFProcess> getPSWFProcesses() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFProcesses();
        }
        if (this.getPSWFVersionId() == null) {
            return null;
        }
        PSWFVersionService pSWFVersionService = (PSWFVersionService)ServiceGlobal.getService(PSWFVersionService.class, (SessionFactory)this.getSessionFactory());
        PSWFProcessService pSWFProcessService = (PSWFProcessService)ServiceGlobal.getService(PSWFProcessService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSWFProcessesLock;
        synchronized (n) {
            if (this.pswfprocesses == null) {
                this.pswfprocesses = pSWFVersionService.isTempData(this) ? pSWFProcessService.selectTempByPSWFVersion(this) : pSWFProcessService.selectByPSWFVersion(this);
            }
            return this.pswfprocesses;
        }
    }

    private PSWFVersionBase getProxyEntity() {
        return this.proxyPSWFVersionBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSWFVersionBase = null;
        if (iDataObject != null && iDataObject instanceof PSWFVersionBase) {
            this.proxyPSWFVersionBase = (PSWFVersionBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWFVersionService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ACTIVITIMODEL, 0);
        fieldIndexMap.put(FIELD_BPMNMODEL, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 4);
        fieldIndexMap.put(FIELD_DYNASYSREFMODE, 5);
        fieldIndexMap.put(FIELD_DYNAWFVER, 6);
        fieldIndexMap.put(FIELD_ENABLE, 7);
        fieldIndexMap.put(FIELD_ENABLEDYNASYS, 8);
        fieldIndexMap.put(FIELD_ENABLELOG, 9);
        fieldIndexMap.put(FIELD_LASTBACKDATATAG, 10);
        fieldIndexMap.put(FIELD_MEMO, 11);
        fieldIndexMap.put(FIELD_PSDEUAGROUPSCNT, 12);
        fieldIndexMap.put(FIELD_PSDEUIACTIONSCNT, 13);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 14);
        fieldIndexMap.put(FIELD_PSDYNAINSTNAME, 15);
        fieldIndexMap.put(FIELD_PSDYNAWFVERID, 16);
        fieldIndexMap.put(FIELD_PSDYNAWFVERINSTID, 17);
        fieldIndexMap.put(FIELD_PSDYNAWFVERINSTNAME, 18);
        fieldIndexMap.put(FIELD_PSDYNAWFVERNAME, 19);
        fieldIndexMap.put(FIELD_PSSYSREQITEMID, 20);
        fieldIndexMap.put(FIELD_PSSYSREQITEMNAME, 21);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 22);
        fieldIndexMap.put(FIELD_PSSYSWFMODEID, 23);
        fieldIndexMap.put(FIELD_PSSYSWFMODENAME, 24);
        fieldIndexMap.put(FIELD_PSWFID, 25);
        fieldIndexMap.put(FIELD_PSWFNAME, 26);
        fieldIndexMap.put(FIELD_PSWFVERSIONID, 27);
        fieldIndexMap.put(FIELD_PSWFVERSIONNAME, 28);
        fieldIndexMap.put(FIELD_REMOVEFLAG, 29);
        fieldIndexMap.put(FIELD_TODOTASK, 30);
        fieldIndexMap.put(FIELD_UPDATEDATE, 31);
        fieldIndexMap.put(FIELD_UPDATEMAN, 32);
        fieldIndexMap.put(FIELD_USERCAT, 33);
        fieldIndexMap.put(FIELD_USERTAG, 34);
        fieldIndexMap.put(FIELD_USERTAG2, 35);
        fieldIndexMap.put(FIELD_USERTAG3, 36);
        fieldIndexMap.put(FIELD_USERTAG4, 37);
        fieldIndexMap.put(FIELD_VALIDFLAG, 38);
        fieldIndexMap.put(FIELD_VERTAG, 39);
        fieldIndexMap.put(FIELD_VERTAG2, 40);
        fieldIndexMap.put(FIELD_WFENGINETYPE, 41);
        fieldIndexMap.put(FIELD_WFMODE, 42);
        fieldIndexMap.put(FIELD_WFMODEL, 43);
        fieldIndexMap.put(FIELD_WFSTEPPSCODELISTID, 44);
        fieldIndexMap.put(FIELD_WFSTEPPSCODELISTNAME, 45);
        fieldIndexMap.put(FIELD_WFVERMODE, 46);
        fieldIndexMap.put(FIELD_WFVERSION, 47);
    }
}

