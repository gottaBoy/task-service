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
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.service.PSSysPFPluginService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataImpItem;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPriv;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataImpItemService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataImpService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEDataImpBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEDataImpBase.class);
    public static final String FIELD_ACTIONHOLDER = "ACTIONHOLDER";
    public static final String FIELD_BATCHSIZE = "BATCHSIZE";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CONTENTTYPE = "CONTENTTYPE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CREATEPSDEACTIONID = "CREATEPSDEACTIONID";
    public static final String FIELD_CREATEPSDEACTIONNAME = "CREATEPSDEACTIONNAME";
    public static final String FIELD_CREATEPSDEOPPRIVID = "CREATEPSDEOPPRIVID";
    public static final String FIELD_CREATEPSDEOPPRIVINAME = "CREATEPSDEOPPRIVINAME";
    public static final String FIELD_CUSTOMCODE = "CUSTOMCODE";
    public static final String FIELD_CUSTOMMODE = "CUSTOMMODE";
    public static final String FIELD_DATAIMPTYPE = "DATAIMPTYPE";
    public static final String FIELD_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_ENABLECUSTOMIZED = "ENABLECUSTOMIZED";
    public static final String FIELD_EXTENDMODE = "EXTENDMODE";
    public static final String FIELD_IMPPARAMS = "IMPPARAMS";
    public static final String FIELD_IMPTAG = "IMPTAG";
    public static final String FIELD_IMPTAG2 = "IMPTAG2";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_POTIME = "POTIME";
    public static final String FIELD_PSDEDATAIMPID = "PSDEDATAIMPID";
    public static final String FIELD_PSDEDATAIMPNAME = "PSDEDATAIMPNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String FIELD_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String FIELD_PSSYSREQITEMID = "PSSYSREQITEMID";
    public static final String FIELD_PSSYSREQITEMNAME = "PSSYSREQITEMNAME";
    public static final String FIELD_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String FIELD_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String FIELD_STOPWHENERROR = "STOPWHENERROR";
    public static final String FIELD_TODOTASK = "TODOTASK";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_UPDATEPSDEACTIONID = "UPDATEPSDEACTIONID";
    public static final String FIELD_UPDATEPSDEACTIONNAME = "UPDATEPSDEACTIONNAME";
    public static final String FIELD_UPDATEPSDEOPPRIVID = "UPDATEPSDEOPPRIVID";
    public static final String FIELD_UPDATEPSDEOPPRIVNAME = "UPDATEPSDEOPPRIVNAME";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_ACTIONHOLDER = 0;
    private static final int INDEX_BATCHSIZE = 1;
    private static final int INDEX_CODENAME = 2;
    private static final int INDEX_CONTENTTYPE = 3;
    private static final int INDEX_CREATEDATE = 4;
    private static final int INDEX_CREATEMAN = 5;
    private static final int INDEX_CREATEPSDEACTIONID = 6;
    private static final int INDEX_CREATEPSDEACTIONNAME = 7;
    private static final int INDEX_CREATEPSDEOPPRIVID = 8;
    private static final int INDEX_CREATEPSDEOPPRIVINAME = 9;
    private static final int INDEX_CUSTOMCODE = 10;
    private static final int INDEX_CUSTOMMODE = 11;
    private static final int INDEX_DATAIMPTYPE = 12;
    private static final int INDEX_DEFAULTFLAG = 13;
    private static final int INDEX_DYNAMODELFLAG = 14;
    private static final int INDEX_ENABLECUSTOMIZED = 15;
    private static final int INDEX_EXTENDMODE = 16;
    private static final int INDEX_IMPPARAMS = 17;
    private static final int INDEX_IMPTAG = 18;
    private static final int INDEX_IMPTAG2 = 19;
    private static final int INDEX_LOCKFLAG = 20;
    private static final int INDEX_MEMO = 21;
    private static final int INDEX_POTIME = 22;
    private static final int INDEX_PSDEDATAIMPID = 23;
    private static final int INDEX_PSDEDATAIMPNAME = 24;
    private static final int INDEX_PSDEID = 25;
    private static final int INDEX_PSDENAME = 26;
    private static final int INDEX_PSDYNAINSTID = 27;
    private static final int INDEX_PSSYSPFPLUGINID = 28;
    private static final int INDEX_PSSYSPFPLUGINNAME = 29;
    private static final int INDEX_PSSYSREQITEMID = 30;
    private static final int INDEX_PSSYSREQITEMNAME = 31;
    private static final int INDEX_PSSYSSFPLUGINID = 32;
    private static final int INDEX_PSSYSSFPLUGINNAME = 33;
    private static final int INDEX_STOPWHENERROR = 34;
    private static final int INDEX_TODOTASK = 35;
    private static final int INDEX_UPDATEDATE = 36;
    private static final int INDEX_UPDATEMAN = 37;
    private static final int INDEX_UPDATEPSDEACTIONID = 38;
    private static final int INDEX_UPDATEPSDEACTIONNAME = 39;
    private static final int INDEX_UPDATEPSDEOPPRIVID = 40;
    private static final int INDEX_UPDATEPSDEOPPRIVNAME = 41;
    private static final int INDEX_USERCAT = 42;
    private static final int INDEX_USERTAG = 43;
    private static final int INDEX_USERTAG2 = 44;
    private static final int INDEX_USERTAG3 = 45;
    private static final int INDEX_USERTAG4 = 46;
    private static final int INDEX_VALIDFLAG = 47;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEDataImpBase proxyPSDEDataImpBase = null;
    private boolean actionholderDirtyFlag = false;
    private boolean batchsizeDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean contenttypeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean createpsdeactionidDirtyFlag = false;
    private boolean createpsdeactionnameDirtyFlag = false;
    private boolean createpsdeopprividDirtyFlag = false;
    private boolean createpsdeopprivinameDirtyFlag = false;
    private boolean customcodeDirtyFlag = false;
    private boolean custommodeDirtyFlag = false;
    private boolean dataimptypeDirtyFlag = false;
    private boolean defaultflagDirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean enablecustomizedDirtyFlag = false;
    private boolean extendmodeDirtyFlag = false;
    private boolean impparamsDirtyFlag = false;
    private boolean imptagDirtyFlag = false;
    private boolean imptag2DirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean potimeDirtyFlag = false;
    private boolean psdedataimpidDirtyFlag = false;
    private boolean psdedataimpnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean pssyspfpluginidDirtyFlag = false;
    private boolean pssyspfpluginnameDirtyFlag = false;
    private boolean pssysreqitemidDirtyFlag = false;
    private boolean pssysreqitemnameDirtyFlag = false;
    private boolean pssyssfpluginidDirtyFlag = false;
    private boolean pssyssfpluginnameDirtyFlag = false;
    private boolean stopwhenerrorDirtyFlag = false;
    private boolean todotaskDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean updatepsdeactionidDirtyFlag = false;
    private boolean updatepsdeactionnameDirtyFlag = false;
    private boolean updatepsdeopprividDirtyFlag = false;
    private boolean updatepsdeopprivnameDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="actionholder")
    private Integer actionholder;
    @Column(name="batchsize")
    private Integer batchsize;
    @Column(name="codename")
    private String codename;
    @Column(name="contenttype")
    private String contenttype;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="createpsdeactionid")
    private String createpsdeactionid;
    @Column(name="createpsdeactionname")
    private String createpsdeactionname;
    @Column(name="createpsdeopprivid")
    private String createpsdeopprivid;
    @Column(name="createpsdeoppriviname")
    private String createpsdeoppriviname;
    @Column(name="customcode")
    private String customcode;
    @Column(name="custommode")
    private Integer custommode;
    @Column(name="dataimptype")
    private String dataimptype;
    @Column(name="defaultflag")
    private Integer defaultflag;
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="enablecustomized")
    private Integer enablecustomized;
    @Column(name="extendmode")
    private Integer extendmode;
    @Column(name="impparams")
    private String impparams;
    @Column(name="imptag")
    private String imptag;
    @Column(name="imptag2")
    private String imptag2;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="memo")
    private String memo;
    @Column(name="potime")
    private Integer potime;
    @Column(name="psdedataimpid")
    private String psdedataimpid;
    @Column(name="psdedataimpname")
    private String psdedataimpname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="pssyspfpluginid")
    private String pssyspfpluginid;
    @Column(name="pssyspfpluginname")
    private String pssyspfpluginname;
    @Column(name="pssysreqitemid")
    private String pssysreqitemid;
    @Column(name="pssysreqitemname")
    private String pssysreqitemname;
    @Column(name="pssyssfpluginid")
    private String pssyssfpluginid;
    @Column(name="pssyssfpluginname")
    private String pssyssfpluginname;
    @Column(name="stopwhenerror")
    private Integer stopwhenerror;
    @Column(name="todotask")
    private String todotask;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="updatepsdeactionid")
    private String updatepsdeactionid;
    @Column(name="updatepsdeactionname")
    private String updatepsdeactionname;
    @Column(name="updatepsdeopprivid")
    private String updatepsdeopprivid;
    @Column(name="updatepsdeopprivname")
    private String updatepsdeopprivname;
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
    private Integer objCreatePSDEActionLock = new Integer(1);
    private PSDEAction createpsdeaction = null;
    private Integer objUpdatePSDEActionLock = new Integer(1);
    private PSDEAction updatepsdeaction = null;
    private Integer objCreatePSDEOPPrivLock = new Integer(1);
    private PSDEOPPriv createpsdeoppriv = null;
    private Integer objUpdatePSDEOPPrivLock = new Integer(1);
    private PSDEOPPriv updatepsdeoppriv = null;
    private Integer objPSSysPFPluginLock = new Integer(1);
    private PSSysPFPlugin pssyspfplugin = null;
    private Integer objPSSysReqItemLock = new Integer(1);
    private PSSysReqItem pssysreqitem = null;
    private Integer objPSSysSFPluginLock = new Integer(1);
    private PSSysSFPlugin pssyssfplugin = null;
    private Integer objPSDEDataImpItemsLock = new Integer(1);
    private ArrayList<PSDEDataImpItem> psdedataimpitems = null;

    public void setActionHolder(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionHolder(n);
            return;
        }
        this.actionholder = n;
        this.actionholderDirtyFlag = true;
    }

    public Integer getActionHolder() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionHolder();
        }
        return this.actionholder;
    }

    public boolean isActionHolderDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionHolderDirty();
        }
        return this.actionholderDirtyFlag;
    }

    public void resetActionHolder() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionHolder();
            return;
        }
        this.actionholderDirtyFlag = false;
        this.actionholder = null;
    }

    public void setBatchSize(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBatchSize(n);
            return;
        }
        this.batchsize = n;
        this.batchsizeDirtyFlag = true;
    }

    public Integer getBatchSize() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBatchSize();
        }
        return this.batchsize;
    }

    public boolean isBatchSizeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBatchSizeDirty();
        }
        return this.batchsizeDirtyFlag;
    }

    public void resetBatchSize() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBatchSize();
            return;
        }
        this.batchsizeDirtyFlag = false;
        this.batchsize = null;
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

    public void setContentType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setContentType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.contenttype = string;
        this.contenttypeDirtyFlag = true;
    }

    public String getContentType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContentType();
        }
        return this.contenttype;
    }

    public boolean isContentTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isContentTypeDirty();
        }
        return this.contenttypeDirtyFlag;
    }

    public void resetContentType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetContentType();
            return;
        }
        this.contenttypeDirtyFlag = false;
        this.contenttype = null;
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

    public void setCreatePSDEActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreatePSDEActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.createpsdeactionid = string;
        this.createpsdeactionidDirtyFlag = true;
    }

    public String getCreatePSDEActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreatePSDEActionId();
        }
        return this.createpsdeactionid;
    }

    public boolean isCreatePSDEActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCreatePSDEActionIdDirty();
        }
        return this.createpsdeactionidDirtyFlag;
    }

    public void resetCreatePSDEActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCreatePSDEActionId();
            return;
        }
        this.createpsdeactionidDirtyFlag = false;
        this.createpsdeactionid = null;
    }

    public void setCreatePSDEActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreatePSDEActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.createpsdeactionname = string;
        this.createpsdeactionnameDirtyFlag = true;
    }

    public String getCreatePSDEActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreatePSDEActionName();
        }
        return this.createpsdeactionname;
    }

    public boolean isCreatePSDEActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCreatePSDEActionNameDirty();
        }
        return this.createpsdeactionnameDirtyFlag;
    }

    public void resetCreatePSDEActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCreatePSDEActionName();
            return;
        }
        this.createpsdeactionnameDirtyFlag = false;
        this.createpsdeactionname = null;
    }

    public void setCreatePSDEOPPrivId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreatePSDEOPPrivId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.createpsdeopprivid = string;
        this.createpsdeopprividDirtyFlag = true;
    }

    public String getCreatePSDEOPPrivId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreatePSDEOPPrivId();
        }
        return this.createpsdeopprivid;
    }

    public boolean isCreatePSDEOPPrivIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCreatePSDEOPPrivIdDirty();
        }
        return this.createpsdeopprividDirtyFlag;
    }

    public void resetCreatePSDEOPPrivId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCreatePSDEOPPrivId();
            return;
        }
        this.createpsdeopprividDirtyFlag = false;
        this.createpsdeopprivid = null;
    }

    public void setCreatePSDEOPPrivIName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreatePSDEOPPrivIName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.createpsdeoppriviname = string;
        this.createpsdeopprivinameDirtyFlag = true;
    }

    public String getCreatePSDEOPPrivIName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreatePSDEOPPrivIName();
        }
        return this.createpsdeoppriviname;
    }

    public boolean isCreatePSDEOPPrivINameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCreatePSDEOPPrivINameDirty();
        }
        return this.createpsdeopprivinameDirtyFlag;
    }

    public void resetCreatePSDEOPPrivIName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCreatePSDEOPPrivIName();
            return;
        }
        this.createpsdeopprivinameDirtyFlag = false;
        this.createpsdeoppriviname = null;
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

    public void setCustomMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomMode(n);
            return;
        }
        this.custommode = n;
        this.custommodeDirtyFlag = true;
    }

    public Integer getCustomMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomMode();
        }
        return this.custommode;
    }

    public boolean isCustomModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomModeDirty();
        }
        return this.custommodeDirtyFlag;
    }

    public void resetCustomMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomMode();
            return;
        }
        this.custommodeDirtyFlag = false;
        this.custommode = null;
    }

    public void setDataImpType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDataImpType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dataimptype = string;
        this.dataimptypeDirtyFlag = true;
    }

    public String getDataImpType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDataImpType();
        }
        return this.dataimptype;
    }

    public boolean isDataImpTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataImpTypeDirty();
        }
        return this.dataimptypeDirtyFlag;
    }

    public void resetDataImpType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDataImpType();
            return;
        }
        this.dataimptypeDirtyFlag = false;
        this.dataimptype = null;
    }

    public void setDefaultFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefaultFlag(n);
            return;
        }
        this.defaultflag = n;
        this.defaultflagDirtyFlag = true;
    }

    public Integer getDefaultFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefaultFlag();
        }
        return this.defaultflag;
    }

    public boolean isDefaultFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefaultFlagDirty();
        }
        return this.defaultflagDirtyFlag;
    }

    public void resetDefaultFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefaultFlag();
            return;
        }
        this.defaultflagDirtyFlag = false;
        this.defaultflag = null;
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

    public void setEnableCustomized(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableCustomized(n);
            return;
        }
        this.enablecustomized = n;
        this.enablecustomizedDirtyFlag = true;
    }

    public Integer getEnableCustomized() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableCustomized();
        }
        return this.enablecustomized;
    }

    public boolean isEnableCustomizedDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableCustomizedDirty();
        }
        return this.enablecustomizedDirtyFlag;
    }

    public void resetEnableCustomized() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableCustomized();
            return;
        }
        this.enablecustomizedDirtyFlag = false;
        this.enablecustomized = null;
    }

    public void setExtendMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExtendMode(n);
            return;
        }
        this.extendmode = n;
        this.extendmodeDirtyFlag = true;
    }

    public Integer getExtendMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExtendMode();
        }
        return this.extendmode;
    }

    public boolean isExtendModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExtendModeDirty();
        }
        return this.extendmodeDirtyFlag;
    }

    public void resetExtendMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExtendMode();
            return;
        }
        this.extendmodeDirtyFlag = false;
        this.extendmode = null;
    }

    public void setImpParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setImpParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.impparams = string;
        this.impparamsDirtyFlag = true;
    }

    public String getImpParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getImpParams();
        }
        return this.impparams;
    }

    public boolean isImpParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isImpParamsDirty();
        }
        return this.impparamsDirtyFlag;
    }

    public void resetImpParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetImpParams();
            return;
        }
        this.impparamsDirtyFlag = false;
        this.impparams = null;
    }

    public void setImpTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setImpTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.imptag = string;
        this.imptagDirtyFlag = true;
    }

    public String getImpTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getImpTag();
        }
        return this.imptag;
    }

    public boolean isImpTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isImpTagDirty();
        }
        return this.imptagDirtyFlag;
    }

    public void resetImpTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetImpTag();
            return;
        }
        this.imptagDirtyFlag = false;
        this.imptag = null;
    }

    public void setImpTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setImpTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.imptag2 = string;
        this.imptag2DirtyFlag = true;
    }

    public String getImpTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getImpTag2();
        }
        return this.imptag2;
    }

    public boolean isImpTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isImpTag2Dirty();
        }
        return this.imptag2DirtyFlag;
    }

    public void resetImpTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetImpTag2();
            return;
        }
        this.imptag2DirtyFlag = false;
        this.imptag2 = null;
    }

    public void setLockFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLockFlag(n);
            return;
        }
        this.lockflag = n;
        this.lockflagDirtyFlag = true;
    }

    public Integer getLockFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLockFlag();
        }
        return this.lockflag;
    }

    public boolean isLockFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLockFlagDirty();
        }
        return this.lockflagDirtyFlag;
    }

    public void resetLockFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLockFlag();
            return;
        }
        this.lockflagDirtyFlag = false;
        this.lockflag = null;
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

    public void setPOTime(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPOTime(n);
            return;
        }
        this.potime = n;
        this.potimeDirtyFlag = true;
    }

    public Integer getPOTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPOTime();
        }
        return this.potime;
    }

    public boolean isPOTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPOTimeDirty();
        }
        return this.potimeDirtyFlag;
    }

    public void resetPOTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPOTime();
            return;
        }
        this.potimeDirtyFlag = false;
        this.potime = null;
    }

    public void setPSDEDataImpId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataImpId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedataimpid = string;
        this.psdedataimpidDirtyFlag = true;
    }

    public String getPSDEDataImpId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataImpId();
        }
        return this.psdedataimpid;
    }

    public boolean isPSDEDataImpIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataImpIdDirty();
        }
        return this.psdedataimpidDirtyFlag;
    }

    public void resetPSDEDataImpId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataImpId();
            return;
        }
        this.psdedataimpidDirtyFlag = false;
        this.psdedataimpid = null;
    }

    public void setPSDEDataImpName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataImpName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedataimpname = string;
        this.psdedataimpnameDirtyFlag = true;
    }

    public String getPSDEDataImpName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataImpName();
        }
        return this.psdedataimpname;
    }

    public boolean isPSDEDataImpNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataImpNameDirty();
        }
        return this.psdedataimpnameDirtyFlag;
    }

    public void resetPSDEDataImpName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataImpName();
            return;
        }
        this.psdedataimpnameDirtyFlag = false;
        this.psdedataimpname = null;
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

    public void setPSSysSFPluginId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSFPluginId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssfpluginid = string;
        this.pssyssfpluginidDirtyFlag = true;
    }

    public String getPSSysSFPluginId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPluginId();
        }
        return this.pssyssfpluginid;
    }

    public boolean isPSSysSFPluginIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSFPluginIdDirty();
        }
        return this.pssyssfpluginidDirtyFlag;
    }

    public void resetPSSysSFPluginId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSFPluginId();
            return;
        }
        this.pssyssfpluginidDirtyFlag = false;
        this.pssyssfpluginid = null;
    }

    public void setPSSysSFPluginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSFPluginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssfpluginname = string;
        this.pssyssfpluginnameDirtyFlag = true;
    }

    public String getPSSysSFPluginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPluginName();
        }
        return this.pssyssfpluginname;
    }

    public boolean isPSSysSFPluginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSFPluginNameDirty();
        }
        return this.pssyssfpluginnameDirtyFlag;
    }

    public void resetPSSysSFPluginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSFPluginName();
            return;
        }
        this.pssyssfpluginnameDirtyFlag = false;
        this.pssyssfpluginname = null;
    }

    public void setStopWhenError(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStopWhenError(n);
            return;
        }
        this.stopwhenerror = n;
        this.stopwhenerrorDirtyFlag = true;
    }

    public Integer getStopWhenError() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStopWhenError();
        }
        return this.stopwhenerror;
    }

    public boolean isStopWhenErrorDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStopWhenErrorDirty();
        }
        return this.stopwhenerrorDirtyFlag;
    }

    public void resetStopWhenError() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStopWhenError();
            return;
        }
        this.stopwhenerrorDirtyFlag = false;
        this.stopwhenerror = null;
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

    public void setUpdatePSDEActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdatePSDEActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.updatepsdeactionid = string;
        this.updatepsdeactionidDirtyFlag = true;
    }

    public String getUpdatePSDEActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUpdatePSDEActionId();
        }
        return this.updatepsdeactionid;
    }

    public boolean isUpdatePSDEActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUpdatePSDEActionIdDirty();
        }
        return this.updatepsdeactionidDirtyFlag;
    }

    public void resetUpdatePSDEActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUpdatePSDEActionId();
            return;
        }
        this.updatepsdeactionidDirtyFlag = false;
        this.updatepsdeactionid = null;
    }

    public void setUpdatePSDEActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdatePSDEActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.updatepsdeactionname = string;
        this.updatepsdeactionnameDirtyFlag = true;
    }

    public String getUpdatePSDEActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUpdatePSDEActionName();
        }
        return this.updatepsdeactionname;
    }

    public boolean isUpdatePSDEActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUpdatePSDEActionNameDirty();
        }
        return this.updatepsdeactionnameDirtyFlag;
    }

    public void resetUpdatePSDEActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUpdatePSDEActionName();
            return;
        }
        this.updatepsdeactionnameDirtyFlag = false;
        this.updatepsdeactionname = null;
    }

    public void setUpdatePSDEOPPrivId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdatePSDEOPPrivId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.updatepsdeopprivid = string;
        this.updatepsdeopprividDirtyFlag = true;
    }

    public String getUpdatePSDEOPPrivId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUpdatePSDEOPPrivId();
        }
        return this.updatepsdeopprivid;
    }

    public boolean isUpdatePSDEOPPrivIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUpdatePSDEOPPrivIdDirty();
        }
        return this.updatepsdeopprividDirtyFlag;
    }

    public void resetUpdatePSDEOPPrivId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUpdatePSDEOPPrivId();
            return;
        }
        this.updatepsdeopprividDirtyFlag = false;
        this.updatepsdeopprivid = null;
    }

    public void setUpdatePSDEOPPrivName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdatePSDEOPPrivName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.updatepsdeopprivname = string;
        this.updatepsdeopprivnameDirtyFlag = true;
    }

    public String getUpdatePSDEOPPrivName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUpdatePSDEOPPrivName();
        }
        return this.updatepsdeopprivname;
    }

    public boolean isUpdatePSDEOPPrivNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUpdatePSDEOPPrivNameDirty();
        }
        return this.updatepsdeopprivnameDirtyFlag;
    }

    public void resetUpdatePSDEOPPrivName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUpdatePSDEOPPrivName();
            return;
        }
        this.updatepsdeopprivnameDirtyFlag = false;
        this.updatepsdeopprivname = null;
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
        PSDEDataImpBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEDataImpBase pSDEDataImpBase) {
        pSDEDataImpBase.resetActionHolder();
        pSDEDataImpBase.resetBatchSize();
        pSDEDataImpBase.resetCodeName();
        pSDEDataImpBase.resetContentType();
        pSDEDataImpBase.resetCreateDate();
        pSDEDataImpBase.resetCreateMan();
        pSDEDataImpBase.resetCreatePSDEActionId();
        pSDEDataImpBase.resetCreatePSDEActionName();
        pSDEDataImpBase.resetCreatePSDEOPPrivId();
        pSDEDataImpBase.resetCreatePSDEOPPrivIName();
        pSDEDataImpBase.resetCustomCode();
        pSDEDataImpBase.resetCustomMode();
        pSDEDataImpBase.resetDataImpType();
        pSDEDataImpBase.resetDefaultFlag();
        pSDEDataImpBase.resetDynaModelFlag();
        pSDEDataImpBase.resetEnableCustomized();
        pSDEDataImpBase.resetExtendMode();
        pSDEDataImpBase.resetImpParams();
        pSDEDataImpBase.resetImpTag();
        pSDEDataImpBase.resetImpTag2();
        pSDEDataImpBase.resetLockFlag();
        pSDEDataImpBase.resetMemo();
        pSDEDataImpBase.resetPOTime();
        pSDEDataImpBase.resetPSDEDataImpId();
        pSDEDataImpBase.resetPSDEDataImpName();
        pSDEDataImpBase.resetPSDEId();
        pSDEDataImpBase.resetPSDEName();
        pSDEDataImpBase.resetPSDynaInstId();
        pSDEDataImpBase.resetPSSysPFPluginId();
        pSDEDataImpBase.resetPSSysPFPluginName();
        pSDEDataImpBase.resetPSSysReqItemId();
        pSDEDataImpBase.resetPSSysReqItemName();
        pSDEDataImpBase.resetPSSysSFPluginId();
        pSDEDataImpBase.resetPSSysSFPluginName();
        pSDEDataImpBase.resetStopWhenError();
        pSDEDataImpBase.resetToDoTask();
        pSDEDataImpBase.resetUpdateDate();
        pSDEDataImpBase.resetUpdateMan();
        pSDEDataImpBase.resetUpdatePSDEActionId();
        pSDEDataImpBase.resetUpdatePSDEActionName();
        pSDEDataImpBase.resetUpdatePSDEOPPrivId();
        pSDEDataImpBase.resetUpdatePSDEOPPrivName();
        pSDEDataImpBase.resetUserCat();
        pSDEDataImpBase.resetUserTag();
        pSDEDataImpBase.resetUserTag2();
        pSDEDataImpBase.resetUserTag3();
        pSDEDataImpBase.resetUserTag4();
        pSDEDataImpBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isActionHolderDirty()) {
            hashMap.put(FIELD_ACTIONHOLDER, this.getActionHolder());
        }
        if (!bl || this.isBatchSizeDirty()) {
            hashMap.put(FIELD_BATCHSIZE, this.getBatchSize());
        }
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isContentTypeDirty()) {
            hashMap.put(FIELD_CONTENTTYPE, this.getContentType());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCreatePSDEActionIdDirty()) {
            hashMap.put(FIELD_CREATEPSDEACTIONID, this.getCreatePSDEActionId());
        }
        if (!bl || this.isCreatePSDEActionNameDirty()) {
            hashMap.put(FIELD_CREATEPSDEACTIONNAME, this.getCreatePSDEActionName());
        }
        if (!bl || this.isCreatePSDEOPPrivIdDirty()) {
            hashMap.put(FIELD_CREATEPSDEOPPRIVID, this.getCreatePSDEOPPrivId());
        }
        if (!bl || this.isCreatePSDEOPPrivINameDirty()) {
            hashMap.put(FIELD_CREATEPSDEOPPRIVINAME, this.getCreatePSDEOPPrivIName());
        }
        if (!bl || this.isCustomCodeDirty()) {
            hashMap.put(FIELD_CUSTOMCODE, this.getCustomCode());
        }
        if (!bl || this.isCustomModeDirty()) {
            hashMap.put(FIELD_CUSTOMMODE, this.getCustomMode());
        }
        if (!bl || this.isDataImpTypeDirty()) {
            hashMap.put(FIELD_DATAIMPTYPE, this.getDataImpType());
        }
        if (!bl || this.isDefaultFlagDirty()) {
            hashMap.put(FIELD_DEFAULTFLAG, this.getDefaultFlag());
        }
        if (!bl || this.isDynaModelFlagDirty()) {
            hashMap.put(FIELD_DYNAMODELFLAG, this.getDynaModelFlag());
        }
        if (!bl || this.isEnableCustomizedDirty()) {
            hashMap.put(FIELD_ENABLECUSTOMIZED, this.getEnableCustomized());
        }
        if (!bl || this.isExtendModeDirty()) {
            hashMap.put(FIELD_EXTENDMODE, this.getExtendMode());
        }
        if (!bl || this.isImpParamsDirty()) {
            hashMap.put(FIELD_IMPPARAMS, this.getImpParams());
        }
        if (!bl || this.isImpTagDirty()) {
            hashMap.put(FIELD_IMPTAG, this.getImpTag());
        }
        if (!bl || this.isImpTag2Dirty()) {
            hashMap.put(FIELD_IMPTAG2, this.getImpTag2());
        }
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPOTimeDirty()) {
            hashMap.put(FIELD_POTIME, this.getPOTime());
        }
        if (!bl || this.isPSDEDataImpIdDirty()) {
            hashMap.put(FIELD_PSDEDATAIMPID, this.getPSDEDataImpId());
        }
        if (!bl || this.isPSDEDataImpNameDirty()) {
            hashMap.put(FIELD_PSDEDATAIMPNAME, this.getPSDEDataImpName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSSysPFPluginIdDirty()) {
            hashMap.put(FIELD_PSSYSPFPLUGINID, this.getPSSysPFPluginId());
        }
        if (!bl || this.isPSSysPFPluginNameDirty()) {
            hashMap.put(FIELD_PSSYSPFPLUGINNAME, this.getPSSysPFPluginName());
        }
        if (!bl || this.isPSSysReqItemIdDirty()) {
            hashMap.put(FIELD_PSSYSREQITEMID, this.getPSSysReqItemId());
        }
        if (!bl || this.isPSSysReqItemNameDirty()) {
            hashMap.put(FIELD_PSSYSREQITEMNAME, this.getPSSysReqItemName());
        }
        if (!bl || this.isPSSysSFPluginIdDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINID, this.getPSSysSFPluginId());
        }
        if (!bl || this.isPSSysSFPluginNameDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINNAME, this.getPSSysSFPluginName());
        }
        if (!bl || this.isStopWhenErrorDirty()) {
            hashMap.put(FIELD_STOPWHENERROR, this.getStopWhenError());
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
        if (!bl || this.isUpdatePSDEActionIdDirty()) {
            hashMap.put(FIELD_UPDATEPSDEACTIONID, this.getUpdatePSDEActionId());
        }
        if (!bl || this.isUpdatePSDEActionNameDirty()) {
            hashMap.put(FIELD_UPDATEPSDEACTIONNAME, this.getUpdatePSDEActionName());
        }
        if (!bl || this.isUpdatePSDEOPPrivIdDirty()) {
            hashMap.put(FIELD_UPDATEPSDEOPPRIVID, this.getUpdatePSDEOPPrivId());
        }
        if (!bl || this.isUpdatePSDEOPPrivNameDirty()) {
            hashMap.put(FIELD_UPDATEPSDEOPPRIVNAME, this.getUpdatePSDEOPPrivName());
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
        return PSDEDataImpBase.get(this, n);
    }

    private static Object get(PSDEDataImpBase pSDEDataImpBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDataImpBase.getActionHolder();
            }
            case 1: {
                return pSDEDataImpBase.getBatchSize();
            }
            case 2: {
                return pSDEDataImpBase.getCodeName();
            }
            case 3: {
                return pSDEDataImpBase.getContentType();
            }
            case 4: {
                return pSDEDataImpBase.getCreateDate();
            }
            case 5: {
                return pSDEDataImpBase.getCreateMan();
            }
            case 6: {
                return pSDEDataImpBase.getCreatePSDEActionId();
            }
            case 7: {
                return pSDEDataImpBase.getCreatePSDEActionName();
            }
            case 8: {
                return pSDEDataImpBase.getCreatePSDEOPPrivId();
            }
            case 9: {
                return pSDEDataImpBase.getCreatePSDEOPPrivIName();
            }
            case 10: {
                return pSDEDataImpBase.getCustomCode();
            }
            case 11: {
                return pSDEDataImpBase.getCustomMode();
            }
            case 12: {
                return pSDEDataImpBase.getDataImpType();
            }
            case 13: {
                return pSDEDataImpBase.getDefaultFlag();
            }
            case 14: {
                return pSDEDataImpBase.getDynaModelFlag();
            }
            case 15: {
                return pSDEDataImpBase.getEnableCustomized();
            }
            case 16: {
                return pSDEDataImpBase.getExtendMode();
            }
            case 17: {
                return pSDEDataImpBase.getImpParams();
            }
            case 18: {
                return pSDEDataImpBase.getImpTag();
            }
            case 19: {
                return pSDEDataImpBase.getImpTag2();
            }
            case 20: {
                return pSDEDataImpBase.getLockFlag();
            }
            case 21: {
                return pSDEDataImpBase.getMemo();
            }
            case 22: {
                return pSDEDataImpBase.getPOTime();
            }
            case 23: {
                return pSDEDataImpBase.getPSDEDataImpId();
            }
            case 24: {
                return pSDEDataImpBase.getPSDEDataImpName();
            }
            case 25: {
                return pSDEDataImpBase.getPSDEId();
            }
            case 26: {
                return pSDEDataImpBase.getPSDEName();
            }
            case 27: {
                return pSDEDataImpBase.getPSDynaInstId();
            }
            case 28: {
                return pSDEDataImpBase.getPSSysPFPluginId();
            }
            case 29: {
                return pSDEDataImpBase.getPSSysPFPluginName();
            }
            case 30: {
                return pSDEDataImpBase.getPSSysReqItemId();
            }
            case 31: {
                return pSDEDataImpBase.getPSSysReqItemName();
            }
            case 32: {
                return pSDEDataImpBase.getPSSysSFPluginId();
            }
            case 33: {
                return pSDEDataImpBase.getPSSysSFPluginName();
            }
            case 34: {
                return pSDEDataImpBase.getStopWhenError();
            }
            case 35: {
                return pSDEDataImpBase.getToDoTask();
            }
            case 36: {
                return pSDEDataImpBase.getUpdateDate();
            }
            case 37: {
                return pSDEDataImpBase.getUpdateMan();
            }
            case 38: {
                return pSDEDataImpBase.getUpdatePSDEActionId();
            }
            case 39: {
                return pSDEDataImpBase.getUpdatePSDEActionName();
            }
            case 40: {
                return pSDEDataImpBase.getUpdatePSDEOPPrivId();
            }
            case 41: {
                return pSDEDataImpBase.getUpdatePSDEOPPrivName();
            }
            case 42: {
                return pSDEDataImpBase.getUserCat();
            }
            case 43: {
                return pSDEDataImpBase.getUserTag();
            }
            case 44: {
                return pSDEDataImpBase.getUserTag2();
            }
            case 45: {
                return pSDEDataImpBase.getUserTag3();
            }
            case 46: {
                return pSDEDataImpBase.getUserTag4();
            }
            case 47: {
                return pSDEDataImpBase.getValidFlag();
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
        PSDEDataImpBase.set(this, n, object);
    }

    private static void set(PSDEDataImpBase pSDEDataImpBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEDataImpBase.setActionHolder(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSDEDataImpBase.setBatchSize(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 2: {
                pSDEDataImpBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEDataImpBase.setContentType(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEDataImpBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 5: {
                pSDEDataImpBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEDataImpBase.setCreatePSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEDataImpBase.setCreatePSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEDataImpBase.setCreatePSDEOPPrivId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEDataImpBase.setCreatePSDEOPPrivIName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEDataImpBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEDataImpBase.setCustomMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSDEDataImpBase.setDataImpType(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEDataImpBase.setDefaultFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSDEDataImpBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSDEDataImpBase.setEnableCustomized(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSDEDataImpBase.setExtendMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 17: {
                pSDEDataImpBase.setImpParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEDataImpBase.setImpTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEDataImpBase.setImpTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDEDataImpBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 21: {
                pSDEDataImpBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDEDataImpBase.setPOTime(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 23: {
                pSDEDataImpBase.setPSDEDataImpId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDEDataImpBase.setPSDEDataImpName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDEDataImpBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDEDataImpBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDEDataImpBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDEDataImpBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDEDataImpBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDEDataImpBase.setPSSysReqItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDEDataImpBase.setPSSysReqItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDEDataImpBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDEDataImpBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDEDataImpBase.setStopWhenError(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 35: {
                pSDEDataImpBase.setToDoTask(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDEDataImpBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 37: {
                pSDEDataImpBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDEDataImpBase.setUpdatePSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSDEDataImpBase.setUpdatePSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSDEDataImpBase.setUpdatePSDEOPPrivId(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSDEDataImpBase.setUpdatePSDEOPPrivName(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSDEDataImpBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSDEDataImpBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSDEDataImpBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSDEDataImpBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSDEDataImpBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSDEDataImpBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDEDataImpBase.isNull(this, n);
    }

    private static boolean isNull(PSDEDataImpBase pSDEDataImpBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDataImpBase.getActionHolder() == null;
            }
            case 1: {
                return pSDEDataImpBase.getBatchSize() == null;
            }
            case 2: {
                return pSDEDataImpBase.getCodeName() == null;
            }
            case 3: {
                return pSDEDataImpBase.getContentType() == null;
            }
            case 4: {
                return pSDEDataImpBase.getCreateDate() == null;
            }
            case 5: {
                return pSDEDataImpBase.getCreateMan() == null;
            }
            case 6: {
                return pSDEDataImpBase.getCreatePSDEActionId() == null;
            }
            case 7: {
                return pSDEDataImpBase.getCreatePSDEActionName() == null;
            }
            case 8: {
                return pSDEDataImpBase.getCreatePSDEOPPrivId() == null;
            }
            case 9: {
                return pSDEDataImpBase.getCreatePSDEOPPrivIName() == null;
            }
            case 10: {
                return pSDEDataImpBase.getCustomCode() == null;
            }
            case 11: {
                return pSDEDataImpBase.getCustomMode() == null;
            }
            case 12: {
                return pSDEDataImpBase.getDataImpType() == null;
            }
            case 13: {
                return pSDEDataImpBase.getDefaultFlag() == null;
            }
            case 14: {
                return pSDEDataImpBase.getDynaModelFlag() == null;
            }
            case 15: {
                return pSDEDataImpBase.getEnableCustomized() == null;
            }
            case 16: {
                return pSDEDataImpBase.getExtendMode() == null;
            }
            case 17: {
                return pSDEDataImpBase.getImpParams() == null;
            }
            case 18: {
                return pSDEDataImpBase.getImpTag() == null;
            }
            case 19: {
                return pSDEDataImpBase.getImpTag2() == null;
            }
            case 20: {
                return pSDEDataImpBase.getLockFlag() == null;
            }
            case 21: {
                return pSDEDataImpBase.getMemo() == null;
            }
            case 22: {
                return pSDEDataImpBase.getPOTime() == null;
            }
            case 23: {
                return pSDEDataImpBase.getPSDEDataImpId() == null;
            }
            case 24: {
                return pSDEDataImpBase.getPSDEDataImpName() == null;
            }
            case 25: {
                return pSDEDataImpBase.getPSDEId() == null;
            }
            case 26: {
                return pSDEDataImpBase.getPSDEName() == null;
            }
            case 27: {
                return pSDEDataImpBase.getPSDynaInstId() == null;
            }
            case 28: {
                return pSDEDataImpBase.getPSSysPFPluginId() == null;
            }
            case 29: {
                return pSDEDataImpBase.getPSSysPFPluginName() == null;
            }
            case 30: {
                return pSDEDataImpBase.getPSSysReqItemId() == null;
            }
            case 31: {
                return pSDEDataImpBase.getPSSysReqItemName() == null;
            }
            case 32: {
                return pSDEDataImpBase.getPSSysSFPluginId() == null;
            }
            case 33: {
                return pSDEDataImpBase.getPSSysSFPluginName() == null;
            }
            case 34: {
                return pSDEDataImpBase.getStopWhenError() == null;
            }
            case 35: {
                return pSDEDataImpBase.getToDoTask() == null;
            }
            case 36: {
                return pSDEDataImpBase.getUpdateDate() == null;
            }
            case 37: {
                return pSDEDataImpBase.getUpdateMan() == null;
            }
            case 38: {
                return pSDEDataImpBase.getUpdatePSDEActionId() == null;
            }
            case 39: {
                return pSDEDataImpBase.getUpdatePSDEActionName() == null;
            }
            case 40: {
                return pSDEDataImpBase.getUpdatePSDEOPPrivId() == null;
            }
            case 41: {
                return pSDEDataImpBase.getUpdatePSDEOPPrivName() == null;
            }
            case 42: {
                return pSDEDataImpBase.getUserCat() == null;
            }
            case 43: {
                return pSDEDataImpBase.getUserTag() == null;
            }
            case 44: {
                return pSDEDataImpBase.getUserTag2() == null;
            }
            case 45: {
                return pSDEDataImpBase.getUserTag3() == null;
            }
            case 46: {
                return pSDEDataImpBase.getUserTag4() == null;
            }
            case 47: {
                return pSDEDataImpBase.getValidFlag() == null;
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
        return PSDEDataImpBase.contains(this, n);
    }

    private static boolean contains(PSDEDataImpBase pSDEDataImpBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDataImpBase.isActionHolderDirty();
            }
            case 1: {
                return pSDEDataImpBase.isBatchSizeDirty();
            }
            case 2: {
                return pSDEDataImpBase.isCodeNameDirty();
            }
            case 3: {
                return pSDEDataImpBase.isContentTypeDirty();
            }
            case 4: {
                return pSDEDataImpBase.isCreateDateDirty();
            }
            case 5: {
                return pSDEDataImpBase.isCreateManDirty();
            }
            case 6: {
                return pSDEDataImpBase.isCreatePSDEActionIdDirty();
            }
            case 7: {
                return pSDEDataImpBase.isCreatePSDEActionNameDirty();
            }
            case 8: {
                return pSDEDataImpBase.isCreatePSDEOPPrivIdDirty();
            }
            case 9: {
                return pSDEDataImpBase.isCreatePSDEOPPrivINameDirty();
            }
            case 10: {
                return pSDEDataImpBase.isCustomCodeDirty();
            }
            case 11: {
                return pSDEDataImpBase.isCustomModeDirty();
            }
            case 12: {
                return pSDEDataImpBase.isDataImpTypeDirty();
            }
            case 13: {
                return pSDEDataImpBase.isDefaultFlagDirty();
            }
            case 14: {
                return pSDEDataImpBase.isDynaModelFlagDirty();
            }
            case 15: {
                return pSDEDataImpBase.isEnableCustomizedDirty();
            }
            case 16: {
                return pSDEDataImpBase.isExtendModeDirty();
            }
            case 17: {
                return pSDEDataImpBase.isImpParamsDirty();
            }
            case 18: {
                return pSDEDataImpBase.isImpTagDirty();
            }
            case 19: {
                return pSDEDataImpBase.isImpTag2Dirty();
            }
            case 20: {
                return pSDEDataImpBase.isLockFlagDirty();
            }
            case 21: {
                return pSDEDataImpBase.isMemoDirty();
            }
            case 22: {
                return pSDEDataImpBase.isPOTimeDirty();
            }
            case 23: {
                return pSDEDataImpBase.isPSDEDataImpIdDirty();
            }
            case 24: {
                return pSDEDataImpBase.isPSDEDataImpNameDirty();
            }
            case 25: {
                return pSDEDataImpBase.isPSDEIdDirty();
            }
            case 26: {
                return pSDEDataImpBase.isPSDENameDirty();
            }
            case 27: {
                return pSDEDataImpBase.isPSDynaInstIdDirty();
            }
            case 28: {
                return pSDEDataImpBase.isPSSysPFPluginIdDirty();
            }
            case 29: {
                return pSDEDataImpBase.isPSSysPFPluginNameDirty();
            }
            case 30: {
                return pSDEDataImpBase.isPSSysReqItemIdDirty();
            }
            case 31: {
                return pSDEDataImpBase.isPSSysReqItemNameDirty();
            }
            case 32: {
                return pSDEDataImpBase.isPSSysSFPluginIdDirty();
            }
            case 33: {
                return pSDEDataImpBase.isPSSysSFPluginNameDirty();
            }
            case 34: {
                return pSDEDataImpBase.isStopWhenErrorDirty();
            }
            case 35: {
                return pSDEDataImpBase.isToDoTaskDirty();
            }
            case 36: {
                return pSDEDataImpBase.isUpdateDateDirty();
            }
            case 37: {
                return pSDEDataImpBase.isUpdateManDirty();
            }
            case 38: {
                return pSDEDataImpBase.isUpdatePSDEActionIdDirty();
            }
            case 39: {
                return pSDEDataImpBase.isUpdatePSDEActionNameDirty();
            }
            case 40: {
                return pSDEDataImpBase.isUpdatePSDEOPPrivIdDirty();
            }
            case 41: {
                return pSDEDataImpBase.isUpdatePSDEOPPrivNameDirty();
            }
            case 42: {
                return pSDEDataImpBase.isUserCatDirty();
            }
            case 43: {
                return pSDEDataImpBase.isUserTagDirty();
            }
            case 44: {
                return pSDEDataImpBase.isUserTag2Dirty();
            }
            case 45: {
                return pSDEDataImpBase.isUserTag3Dirty();
            }
            case 46: {
                return pSDEDataImpBase.isUserTag4Dirty();
            }
            case 47: {
                return pSDEDataImpBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEDataImpBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEDataImpBase pSDEDataImpBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEDataImpBase.getActionHolder() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionholder", (Object)PSDEDataImpBase.getJSONValue((Object)pSDEDataImpBase.getActionHolder()), (boolean)false);
        }
        if (bl || pSDEDataImpBase.getBatchSize() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"batchsize", (Object)PSDEDataImpBase.getJSONValue((Object)pSDEDataImpBase.getBatchSize()), (boolean)false);
        }
        if (bl || pSDEDataImpBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDEDataImpBase.getJSONValue((Object)pSDEDataImpBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDEDataImpBase.getContentType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"contenttype", (Object)PSDEDataImpBase.getJSONValue((Object)pSDEDataImpBase.getContentType()), (boolean)false);
        }
        if (bl || pSDEDataImpBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEDataImpBase.getJSONValue((Object)pSDEDataImpBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEDataImpBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEDataImpBase.getJSONValue((Object)pSDEDataImpBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEDataImpBase.getCreatePSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createpsdeactionid", (Object)PSDEDataImpBase.getJSONValue((Object)pSDEDataImpBase.getCreatePSDEActionId()), (boolean)false);
        }
        if (bl || pSDEDataImpBase.getCreatePSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createpsdeactionname", (Object)PSDEDataImpBase.getJSONValue((Object)pSDEDataImpBase.getCreatePSDEActionName()), (boolean)false);
        }
        if (bl || pSDEDataImpBase.getCreatePSDEOPPrivId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createpsdeopprivid", (Object)PSDEDataImpBase.getJSONValue((Object)pSDEDataImpBase.getCreatePSDEOPPrivId()), (boolean)false);
        }
        if (bl || pSDEDataImpBase.getCreatePSDEOPPrivIName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createpsdeoppriviname", (Object)PSDEDataImpBase.getJSONValue((Object)pSDEDataImpBase.getCreatePSDEOPPrivIName()), (boolean)false);
        }
        if (bl || pSDEDataImpBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSDEDataImpBase.getJSONValue((Object)pSDEDataImpBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSDEDataImpBase.getCustomMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"custommode", (Object)PSDEDataImpBase.getJSONValue((Object)pSDEDataImpBase.getCustomMode()), (boolean)false);
        }
        if (bl || pSDEDataImpBase.getDataImpType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dataimptype", (Object)PSDEDataImpBase.getJSONValue((Object)pSDEDataImpBase.getDataImpType()), (boolean)false);
        }
        if (bl || pSDEDataImpBase.getDefaultFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultflag", (Object)PSDEDataImpBase.getJSONValue((Object)pSDEDataImpBase.getDefaultFlag()), (boolean)false);
        }
        if (bl || pSDEDataImpBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSDEDataImpBase.getJSONValue((Object)pSDEDataImpBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSDEDataImpBase.getEnableCustomized() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablecustomized", (Object)PSDEDataImpBase.getJSONValue((Object)pSDEDataImpBase.getEnableCustomized()), (boolean)false);
        }
        if (bl || pSDEDataImpBase.getExtendMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"extendmode", (Object)PSDEDataImpBase.getJSONValue((Object)pSDEDataImpBase.getExtendMode()), (boolean)false);
        }
        if (bl || pSDEDataImpBase.getImpParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"impparams", (Object)PSDEDataImpBase.getJSONValue((Object)pSDEDataImpBase.getImpParams()), (boolean)false);
        }
        if (bl || pSDEDataImpBase.getImpTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"imptag", (Object)PSDEDataImpBase.getJSONValue((Object)pSDEDataImpBase.getImpTag()), (boolean)false);
        }
        if (bl || pSDEDataImpBase.getImpTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"imptag2", (Object)PSDEDataImpBase.getJSONValue((Object)pSDEDataImpBase.getImpTag2()), (boolean)false);
        }
        if (bl || pSDEDataImpBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSDEDataImpBase.getJSONValue((Object)pSDEDataImpBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSDEDataImpBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEDataImpBase.getJSONValue((Object)pSDEDataImpBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEDataImpBase.getPOTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"potime", (Object)PSDEDataImpBase.getJSONValue((Object)pSDEDataImpBase.getPOTime()), (boolean)false);
        }
        if (bl || pSDEDataImpBase.getPSDEDataImpId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedataimpid", (Object)PSDEDataImpBase.getJSONValue((Object)pSDEDataImpBase.getPSDEDataImpId()), (boolean)false);
        }
        if (bl || pSDEDataImpBase.getPSDEDataImpName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedataimpname", (Object)PSDEDataImpBase.getJSONValue((Object)pSDEDataImpBase.getPSDEDataImpName()), (boolean)false);
        }
        if (bl || pSDEDataImpBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEDataImpBase.getJSONValue((Object)pSDEDataImpBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEDataImpBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDEDataImpBase.getJSONValue((Object)pSDEDataImpBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDEDataImpBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSDEDataImpBase.getJSONValue((Object)pSDEDataImpBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSDEDataImpBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSDEDataImpBase.getJSONValue((Object)pSDEDataImpBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSDEDataImpBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSDEDataImpBase.getJSONValue((Object)pSDEDataImpBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSDEDataImpBase.getPSSysReqItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemid", (Object)PSDEDataImpBase.getJSONValue((Object)pSDEDataImpBase.getPSSysReqItemId()), (boolean)false);
        }
        if (bl || pSDEDataImpBase.getPSSysReqItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemname", (Object)PSDEDataImpBase.getJSONValue((Object)pSDEDataImpBase.getPSSysReqItemName()), (boolean)false);
        }
        if (bl || pSDEDataImpBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSDEDataImpBase.getJSONValue((Object)pSDEDataImpBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSDEDataImpBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSDEDataImpBase.getJSONValue((Object)pSDEDataImpBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSDEDataImpBase.getStopWhenError() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"stopwhenerror", (Object)PSDEDataImpBase.getJSONValue((Object)pSDEDataImpBase.getStopWhenError()), (boolean)false);
        }
        if (bl || pSDEDataImpBase.getToDoTask() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"todotask", (Object)PSDEDataImpBase.getJSONValue((Object)pSDEDataImpBase.getToDoTask()), (boolean)false);
        }
        if (bl || pSDEDataImpBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEDataImpBase.getJSONValue((Object)pSDEDataImpBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEDataImpBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEDataImpBase.getJSONValue((Object)pSDEDataImpBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEDataImpBase.getUpdatePSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatepsdeactionid", (Object)PSDEDataImpBase.getJSONValue((Object)pSDEDataImpBase.getUpdatePSDEActionId()), (boolean)false);
        }
        if (bl || pSDEDataImpBase.getUpdatePSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatepsdeactionname", (Object)PSDEDataImpBase.getJSONValue((Object)pSDEDataImpBase.getUpdatePSDEActionName()), (boolean)false);
        }
        if (bl || pSDEDataImpBase.getUpdatePSDEOPPrivId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatepsdeopprivid", (Object)PSDEDataImpBase.getJSONValue((Object)pSDEDataImpBase.getUpdatePSDEOPPrivId()), (boolean)false);
        }
        if (bl || pSDEDataImpBase.getUpdatePSDEOPPrivName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatepsdeopprivname", (Object)PSDEDataImpBase.getJSONValue((Object)pSDEDataImpBase.getUpdatePSDEOPPrivName()), (boolean)false);
        }
        if (bl || pSDEDataImpBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEDataImpBase.getJSONValue((Object)pSDEDataImpBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEDataImpBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEDataImpBase.getJSONValue((Object)pSDEDataImpBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEDataImpBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEDataImpBase.getJSONValue((Object)pSDEDataImpBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEDataImpBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEDataImpBase.getJSONValue((Object)pSDEDataImpBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEDataImpBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEDataImpBase.getJSONValue((Object)pSDEDataImpBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDEDataImpBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDEDataImpBase.getJSONValue((Object)pSDEDataImpBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEDataImpBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEDataImpBase pSDEDataImpBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEDataImpBase.getActionHolder() != null) {
            object = pSDEDataImpBase.getActionHolder();
            xmlNode.setAttribute(FIELD_ACTIONHOLDER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataImpBase.getBatchSize() != null) {
            object = pSDEDataImpBase.getBatchSize();
            xmlNode.setAttribute(FIELD_BATCHSIZE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataImpBase.getCodeName() != null) {
            object = pSDEDataImpBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataImpBase.getContentType() != null) {
            object = pSDEDataImpBase.getContentType();
            xmlNode.setAttribute(FIELD_CONTENTTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataImpBase.getCreateDate() != null) {
            object = pSDEDataImpBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEDataImpBase.getCreateMan() != null) {
            object = pSDEDataImpBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataImpBase.getCreatePSDEActionId() != null) {
            object = pSDEDataImpBase.getCreatePSDEActionId();
            xmlNode.setAttribute(FIELD_CREATEPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataImpBase.getCreatePSDEActionName() != null) {
            object = pSDEDataImpBase.getCreatePSDEActionName();
            xmlNode.setAttribute(FIELD_CREATEPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataImpBase.getCreatePSDEOPPrivId() != null) {
            object = pSDEDataImpBase.getCreatePSDEOPPrivId();
            xmlNode.setAttribute(FIELD_CREATEPSDEOPPRIVID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataImpBase.getCreatePSDEOPPrivIName() != null) {
            object = pSDEDataImpBase.getCreatePSDEOPPrivIName();
            xmlNode.setAttribute(FIELD_CREATEPSDEOPPRIVINAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataImpBase.getCustomCode() != null) {
            object = pSDEDataImpBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataImpBase.getCustomMode() != null) {
            object = pSDEDataImpBase.getCustomMode();
            xmlNode.setAttribute(FIELD_CUSTOMMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataImpBase.getDataImpType() != null) {
            object = pSDEDataImpBase.getDataImpType();
            xmlNode.setAttribute(FIELD_DATAIMPTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataImpBase.getDefaultFlag() != null) {
            object = pSDEDataImpBase.getDefaultFlag();
            xmlNode.setAttribute(FIELD_DEFAULTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataImpBase.getDynaModelFlag() != null) {
            object = pSDEDataImpBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataImpBase.getEnableCustomized() != null) {
            object = pSDEDataImpBase.getEnableCustomized();
            xmlNode.setAttribute(FIELD_ENABLECUSTOMIZED, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataImpBase.getExtendMode() != null) {
            object = pSDEDataImpBase.getExtendMode();
            xmlNode.setAttribute(FIELD_EXTENDMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataImpBase.getImpParams() != null) {
            object = pSDEDataImpBase.getImpParams();
            xmlNode.setAttribute(FIELD_IMPPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataImpBase.getImpTag() != null) {
            object = pSDEDataImpBase.getImpTag();
            xmlNode.setAttribute(FIELD_IMPTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataImpBase.getImpTag2() != null) {
            object = pSDEDataImpBase.getImpTag2();
            xmlNode.setAttribute(FIELD_IMPTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataImpBase.getLockFlag() != null) {
            object = pSDEDataImpBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataImpBase.getMemo() != null) {
            object = pSDEDataImpBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataImpBase.getPOTime() != null) {
            object = pSDEDataImpBase.getPOTime();
            xmlNode.setAttribute(FIELD_POTIME, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataImpBase.getPSDEDataImpId() != null) {
            object = pSDEDataImpBase.getPSDEDataImpId();
            xmlNode.setAttribute(FIELD_PSDEDATAIMPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataImpBase.getPSDEDataImpName() != null) {
            object = pSDEDataImpBase.getPSDEDataImpName();
            xmlNode.setAttribute(FIELD_PSDEDATAIMPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataImpBase.getPSDEId() != null) {
            object = pSDEDataImpBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataImpBase.getPSDEName() != null) {
            object = pSDEDataImpBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataImpBase.getPSDynaInstId() != null) {
            object = pSDEDataImpBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataImpBase.getPSSysPFPluginId() != null) {
            object = pSDEDataImpBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataImpBase.getPSSysPFPluginName() != null) {
            object = pSDEDataImpBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataImpBase.getPSSysReqItemId() != null) {
            object = pSDEDataImpBase.getPSSysReqItemId();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataImpBase.getPSSysReqItemName() != null) {
            object = pSDEDataImpBase.getPSSysReqItemName();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataImpBase.getPSSysSFPluginId() != null) {
            object = pSDEDataImpBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataImpBase.getPSSysSFPluginName() != null) {
            object = pSDEDataImpBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataImpBase.getStopWhenError() != null) {
            object = pSDEDataImpBase.getStopWhenError();
            xmlNode.setAttribute(FIELD_STOPWHENERROR, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataImpBase.getToDoTask() != null) {
            object = pSDEDataImpBase.getToDoTask();
            xmlNode.setAttribute(FIELD_TODOTASK, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataImpBase.getUpdateDate() != null) {
            object = pSDEDataImpBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEDataImpBase.getUpdateMan() != null) {
            object = pSDEDataImpBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataImpBase.getUpdatePSDEActionId() != null) {
            object = pSDEDataImpBase.getUpdatePSDEActionId();
            xmlNode.setAttribute(FIELD_UPDATEPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataImpBase.getUpdatePSDEActionName() != null) {
            object = pSDEDataImpBase.getUpdatePSDEActionName();
            xmlNode.setAttribute(FIELD_UPDATEPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataImpBase.getUpdatePSDEOPPrivId() != null) {
            object = pSDEDataImpBase.getUpdatePSDEOPPrivId();
            xmlNode.setAttribute(FIELD_UPDATEPSDEOPPRIVID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataImpBase.getUpdatePSDEOPPrivName() != null) {
            object = pSDEDataImpBase.getUpdatePSDEOPPrivName();
            xmlNode.setAttribute(FIELD_UPDATEPSDEOPPRIVNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataImpBase.getUserCat() != null) {
            object = pSDEDataImpBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataImpBase.getUserTag() != null) {
            object = pSDEDataImpBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataImpBase.getUserTag2() != null) {
            object = pSDEDataImpBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataImpBase.getUserTag3() != null) {
            object = pSDEDataImpBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataImpBase.getUserTag4() != null) {
            object = pSDEDataImpBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataImpBase.getValidFlag() != null) {
            object = pSDEDataImpBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEDataImpBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEDataImpBase pSDEDataImpBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEDataImpBase.isActionHolderDirty() && (bl || pSDEDataImpBase.getActionHolder() != null)) {
            iDataObject.set(FIELD_ACTIONHOLDER, (Object)pSDEDataImpBase.getActionHolder());
        }
        if (pSDEDataImpBase.isBatchSizeDirty() && (bl || pSDEDataImpBase.getBatchSize() != null)) {
            iDataObject.set(FIELD_BATCHSIZE, (Object)pSDEDataImpBase.getBatchSize());
        }
        if (pSDEDataImpBase.isCodeNameDirty() && (bl || pSDEDataImpBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDEDataImpBase.getCodeName());
        }
        if (pSDEDataImpBase.isContentTypeDirty() && (bl || pSDEDataImpBase.getContentType() != null)) {
            iDataObject.set(FIELD_CONTENTTYPE, (Object)pSDEDataImpBase.getContentType());
        }
        if (pSDEDataImpBase.isCreateDateDirty() && (bl || pSDEDataImpBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEDataImpBase.getCreateDate());
        }
        if (pSDEDataImpBase.isCreateManDirty() && (bl || pSDEDataImpBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEDataImpBase.getCreateMan());
        }
        if (pSDEDataImpBase.isCreatePSDEActionIdDirty() && (bl || pSDEDataImpBase.getCreatePSDEActionId() != null)) {
            iDataObject.set(FIELD_CREATEPSDEACTIONID, (Object)pSDEDataImpBase.getCreatePSDEActionId());
        }
        if (pSDEDataImpBase.isCreatePSDEActionNameDirty() && (bl || pSDEDataImpBase.getCreatePSDEActionName() != null)) {
            iDataObject.set(FIELD_CREATEPSDEACTIONNAME, (Object)pSDEDataImpBase.getCreatePSDEActionName());
        }
        if (pSDEDataImpBase.isCreatePSDEOPPrivIdDirty() && (bl || pSDEDataImpBase.getCreatePSDEOPPrivId() != null)) {
            iDataObject.set(FIELD_CREATEPSDEOPPRIVID, (Object)pSDEDataImpBase.getCreatePSDEOPPrivId());
        }
        if (pSDEDataImpBase.isCreatePSDEOPPrivINameDirty() && (bl || pSDEDataImpBase.getCreatePSDEOPPrivIName() != null)) {
            iDataObject.set(FIELD_CREATEPSDEOPPRIVINAME, (Object)pSDEDataImpBase.getCreatePSDEOPPrivIName());
        }
        if (pSDEDataImpBase.isCustomCodeDirty() && (bl || pSDEDataImpBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSDEDataImpBase.getCustomCode());
        }
        if (pSDEDataImpBase.isCustomModeDirty() && (bl || pSDEDataImpBase.getCustomMode() != null)) {
            iDataObject.set(FIELD_CUSTOMMODE, (Object)pSDEDataImpBase.getCustomMode());
        }
        if (pSDEDataImpBase.isDataImpTypeDirty() && (bl || pSDEDataImpBase.getDataImpType() != null)) {
            iDataObject.set(FIELD_DATAIMPTYPE, (Object)pSDEDataImpBase.getDataImpType());
        }
        if (pSDEDataImpBase.isDefaultFlagDirty() && (bl || pSDEDataImpBase.getDefaultFlag() != null)) {
            iDataObject.set(FIELD_DEFAULTFLAG, (Object)pSDEDataImpBase.getDefaultFlag());
        }
        if (pSDEDataImpBase.isDynaModelFlagDirty() && (bl || pSDEDataImpBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSDEDataImpBase.getDynaModelFlag());
        }
        if (pSDEDataImpBase.isEnableCustomizedDirty() && (bl || pSDEDataImpBase.getEnableCustomized() != null)) {
            iDataObject.set(FIELD_ENABLECUSTOMIZED, (Object)pSDEDataImpBase.getEnableCustomized());
        }
        if (pSDEDataImpBase.isExtendModeDirty() && (bl || pSDEDataImpBase.getExtendMode() != null)) {
            iDataObject.set(FIELD_EXTENDMODE, (Object)pSDEDataImpBase.getExtendMode());
        }
        if (pSDEDataImpBase.isImpParamsDirty() && (bl || pSDEDataImpBase.getImpParams() != null)) {
            iDataObject.set(FIELD_IMPPARAMS, (Object)pSDEDataImpBase.getImpParams());
        }
        if (pSDEDataImpBase.isImpTagDirty() && (bl || pSDEDataImpBase.getImpTag() != null)) {
            iDataObject.set(FIELD_IMPTAG, (Object)pSDEDataImpBase.getImpTag());
        }
        if (pSDEDataImpBase.isImpTag2Dirty() && (bl || pSDEDataImpBase.getImpTag2() != null)) {
            iDataObject.set(FIELD_IMPTAG2, (Object)pSDEDataImpBase.getImpTag2());
        }
        if (pSDEDataImpBase.isLockFlagDirty() && (bl || pSDEDataImpBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSDEDataImpBase.getLockFlag());
        }
        if (pSDEDataImpBase.isMemoDirty() && (bl || pSDEDataImpBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEDataImpBase.getMemo());
        }
        if (pSDEDataImpBase.isPOTimeDirty() && (bl || pSDEDataImpBase.getPOTime() != null)) {
            iDataObject.set(FIELD_POTIME, (Object)pSDEDataImpBase.getPOTime());
        }
        if (pSDEDataImpBase.isPSDEDataImpIdDirty() && (bl || pSDEDataImpBase.getPSDEDataImpId() != null)) {
            iDataObject.set(FIELD_PSDEDATAIMPID, (Object)pSDEDataImpBase.getPSDEDataImpId());
        }
        if (pSDEDataImpBase.isPSDEDataImpNameDirty() && (bl || pSDEDataImpBase.getPSDEDataImpName() != null)) {
            iDataObject.set(FIELD_PSDEDATAIMPNAME, (Object)pSDEDataImpBase.getPSDEDataImpName());
        }
        if (pSDEDataImpBase.isPSDEIdDirty() && (bl || pSDEDataImpBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEDataImpBase.getPSDEId());
        }
        if (pSDEDataImpBase.isPSDENameDirty() && (bl || pSDEDataImpBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDEDataImpBase.getPSDEName());
        }
        if (pSDEDataImpBase.isPSDynaInstIdDirty() && (bl || pSDEDataImpBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSDEDataImpBase.getPSDynaInstId());
        }
        if (pSDEDataImpBase.isPSSysPFPluginIdDirty() && (bl || pSDEDataImpBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSDEDataImpBase.getPSSysPFPluginId());
        }
        if (pSDEDataImpBase.isPSSysPFPluginNameDirty() && (bl || pSDEDataImpBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSDEDataImpBase.getPSSysPFPluginName());
        }
        if (pSDEDataImpBase.isPSSysReqItemIdDirty() && (bl || pSDEDataImpBase.getPSSysReqItemId() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMID, (Object)pSDEDataImpBase.getPSSysReqItemId());
        }
        if (pSDEDataImpBase.isPSSysReqItemNameDirty() && (bl || pSDEDataImpBase.getPSSysReqItemName() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMNAME, (Object)pSDEDataImpBase.getPSSysReqItemName());
        }
        if (pSDEDataImpBase.isPSSysSFPluginIdDirty() && (bl || pSDEDataImpBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSDEDataImpBase.getPSSysSFPluginId());
        }
        if (pSDEDataImpBase.isPSSysSFPluginNameDirty() && (bl || pSDEDataImpBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSDEDataImpBase.getPSSysSFPluginName());
        }
        if (pSDEDataImpBase.isStopWhenErrorDirty() && (bl || pSDEDataImpBase.getStopWhenError() != null)) {
            iDataObject.set(FIELD_STOPWHENERROR, (Object)pSDEDataImpBase.getStopWhenError());
        }
        if (pSDEDataImpBase.isToDoTaskDirty() && (bl || pSDEDataImpBase.getToDoTask() != null)) {
            iDataObject.set(FIELD_TODOTASK, (Object)pSDEDataImpBase.getToDoTask());
        }
        if (pSDEDataImpBase.isUpdateDateDirty() && (bl || pSDEDataImpBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEDataImpBase.getUpdateDate());
        }
        if (pSDEDataImpBase.isUpdateManDirty() && (bl || pSDEDataImpBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEDataImpBase.getUpdateMan());
        }
        if (pSDEDataImpBase.isUpdatePSDEActionIdDirty() && (bl || pSDEDataImpBase.getUpdatePSDEActionId() != null)) {
            iDataObject.set(FIELD_UPDATEPSDEACTIONID, (Object)pSDEDataImpBase.getUpdatePSDEActionId());
        }
        if (pSDEDataImpBase.isUpdatePSDEActionNameDirty() && (bl || pSDEDataImpBase.getUpdatePSDEActionName() != null)) {
            iDataObject.set(FIELD_UPDATEPSDEACTIONNAME, (Object)pSDEDataImpBase.getUpdatePSDEActionName());
        }
        if (pSDEDataImpBase.isUpdatePSDEOPPrivIdDirty() && (bl || pSDEDataImpBase.getUpdatePSDEOPPrivId() != null)) {
            iDataObject.set(FIELD_UPDATEPSDEOPPRIVID, (Object)pSDEDataImpBase.getUpdatePSDEOPPrivId());
        }
        if (pSDEDataImpBase.isUpdatePSDEOPPrivNameDirty() && (bl || pSDEDataImpBase.getUpdatePSDEOPPrivName() != null)) {
            iDataObject.set(FIELD_UPDATEPSDEOPPRIVNAME, (Object)pSDEDataImpBase.getUpdatePSDEOPPrivName());
        }
        if (pSDEDataImpBase.isUserCatDirty() && (bl || pSDEDataImpBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEDataImpBase.getUserCat());
        }
        if (pSDEDataImpBase.isUserTagDirty() && (bl || pSDEDataImpBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEDataImpBase.getUserTag());
        }
        if (pSDEDataImpBase.isUserTag2Dirty() && (bl || pSDEDataImpBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEDataImpBase.getUserTag2());
        }
        if (pSDEDataImpBase.isUserTag3Dirty() && (bl || pSDEDataImpBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEDataImpBase.getUserTag3());
        }
        if (pSDEDataImpBase.isUserTag4Dirty() && (bl || pSDEDataImpBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEDataImpBase.getUserTag4());
        }
        if (pSDEDataImpBase.isValidFlagDirty() && (bl || pSDEDataImpBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDEDataImpBase.getValidFlag());
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
        return PSDEDataImpBase.remove(this, n);
    }

    private static boolean remove(PSDEDataImpBase pSDEDataImpBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEDataImpBase.resetActionHolder();
                return true;
            }
            case 1: {
                pSDEDataImpBase.resetBatchSize();
                return true;
            }
            case 2: {
                pSDEDataImpBase.resetCodeName();
                return true;
            }
            case 3: {
                pSDEDataImpBase.resetContentType();
                return true;
            }
            case 4: {
                pSDEDataImpBase.resetCreateDate();
                return true;
            }
            case 5: {
                pSDEDataImpBase.resetCreateMan();
                return true;
            }
            case 6: {
                pSDEDataImpBase.resetCreatePSDEActionId();
                return true;
            }
            case 7: {
                pSDEDataImpBase.resetCreatePSDEActionName();
                return true;
            }
            case 8: {
                pSDEDataImpBase.resetCreatePSDEOPPrivId();
                return true;
            }
            case 9: {
                pSDEDataImpBase.resetCreatePSDEOPPrivIName();
                return true;
            }
            case 10: {
                pSDEDataImpBase.resetCustomCode();
                return true;
            }
            case 11: {
                pSDEDataImpBase.resetCustomMode();
                return true;
            }
            case 12: {
                pSDEDataImpBase.resetDataImpType();
                return true;
            }
            case 13: {
                pSDEDataImpBase.resetDefaultFlag();
                return true;
            }
            case 14: {
                pSDEDataImpBase.resetDynaModelFlag();
                return true;
            }
            case 15: {
                pSDEDataImpBase.resetEnableCustomized();
                return true;
            }
            case 16: {
                pSDEDataImpBase.resetExtendMode();
                return true;
            }
            case 17: {
                pSDEDataImpBase.resetImpParams();
                return true;
            }
            case 18: {
                pSDEDataImpBase.resetImpTag();
                return true;
            }
            case 19: {
                pSDEDataImpBase.resetImpTag2();
                return true;
            }
            case 20: {
                pSDEDataImpBase.resetLockFlag();
                return true;
            }
            case 21: {
                pSDEDataImpBase.resetMemo();
                return true;
            }
            case 22: {
                pSDEDataImpBase.resetPOTime();
                return true;
            }
            case 23: {
                pSDEDataImpBase.resetPSDEDataImpId();
                return true;
            }
            case 24: {
                pSDEDataImpBase.resetPSDEDataImpName();
                return true;
            }
            case 25: {
                pSDEDataImpBase.resetPSDEId();
                return true;
            }
            case 26: {
                pSDEDataImpBase.resetPSDEName();
                return true;
            }
            case 27: {
                pSDEDataImpBase.resetPSDynaInstId();
                return true;
            }
            case 28: {
                pSDEDataImpBase.resetPSSysPFPluginId();
                return true;
            }
            case 29: {
                pSDEDataImpBase.resetPSSysPFPluginName();
                return true;
            }
            case 30: {
                pSDEDataImpBase.resetPSSysReqItemId();
                return true;
            }
            case 31: {
                pSDEDataImpBase.resetPSSysReqItemName();
                return true;
            }
            case 32: {
                pSDEDataImpBase.resetPSSysSFPluginId();
                return true;
            }
            case 33: {
                pSDEDataImpBase.resetPSSysSFPluginName();
                return true;
            }
            case 34: {
                pSDEDataImpBase.resetStopWhenError();
                return true;
            }
            case 35: {
                pSDEDataImpBase.resetToDoTask();
                return true;
            }
            case 36: {
                pSDEDataImpBase.resetUpdateDate();
                return true;
            }
            case 37: {
                pSDEDataImpBase.resetUpdateMan();
                return true;
            }
            case 38: {
                pSDEDataImpBase.resetUpdatePSDEActionId();
                return true;
            }
            case 39: {
                pSDEDataImpBase.resetUpdatePSDEActionName();
                return true;
            }
            case 40: {
                pSDEDataImpBase.resetUpdatePSDEOPPrivId();
                return true;
            }
            case 41: {
                pSDEDataImpBase.resetUpdatePSDEOPPrivName();
                return true;
            }
            case 42: {
                pSDEDataImpBase.resetUserCat();
                return true;
            }
            case 43: {
                pSDEDataImpBase.resetUserTag();
                return true;
            }
            case 44: {
                pSDEDataImpBase.resetUserTag2();
                return true;
            }
            case 45: {
                pSDEDataImpBase.resetUserTag3();
                return true;
            }
            case 46: {
                pSDEDataImpBase.resetUserTag4();
                return true;
            }
            case 47: {
                pSDEDataImpBase.resetValidFlag();
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
    public PSDEAction getCreatePSDEAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreatePSDEAction();
        }
        if (this.getCreatePSDEActionId() == null) {
            return null;
        }
        Integer n = this.objCreatePSDEActionLock;
        synchronized (n) {
            if (this.createpsdeaction != null && DataTypeHelper.compare((int)25, (Object)this.getCreatePSDEActionId(), (Object)this.createpsdeaction.getPSDEActionId()) != 0L) {
                this.createpsdeaction = null;
            }
            if (this.createpsdeaction == null) {
                PSDEAction pSDEAction = new PSDEAction();
                pSDEAction.setPSDEActionId(this.getCreatePSDEActionId());
                PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEActionService.autoGet((IEntity)pSDEAction);
                this.createpsdeaction = pSDEAction;
            }
            return this.createpsdeaction;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEAction getUpdatePSDEAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUpdatePSDEAction();
        }
        if (this.getUpdatePSDEActionId() == null) {
            return null;
        }
        Integer n = this.objUpdatePSDEActionLock;
        synchronized (n) {
            if (this.updatepsdeaction != null && DataTypeHelper.compare((int)25, (Object)this.getUpdatePSDEActionId(), (Object)this.updatepsdeaction.getPSDEActionId()) != 0L) {
                this.updatepsdeaction = null;
            }
            if (this.updatepsdeaction == null) {
                PSDEAction pSDEAction = new PSDEAction();
                pSDEAction.setPSDEActionId(this.getUpdatePSDEActionId());
                PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEActionService.autoGet((IEntity)pSDEAction);
                this.updatepsdeaction = pSDEAction;
            }
            return this.updatepsdeaction;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEOPPriv getCreatePSDEOPPriv() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreatePSDEOPPriv();
        }
        if (this.getCreatePSDEOPPrivId() == null) {
            return null;
        }
        Integer n = this.objCreatePSDEOPPrivLock;
        synchronized (n) {
            if (this.createpsdeoppriv != null && DataTypeHelper.compare((int)25, (Object)this.getCreatePSDEOPPrivId(), (Object)this.createpsdeoppriv.getPSDEOPPrivId()) != 0L) {
                this.createpsdeoppriv = null;
            }
            if (this.createpsdeoppriv == null) {
                PSDEOPPriv pSDEOPPriv = new PSDEOPPriv();
                pSDEOPPriv.setPSDEOPPrivId(this.getCreatePSDEOPPrivId());
                PSDEOPPrivService pSDEOPPrivService = (PSDEOPPrivService)ServiceGlobal.getService(PSDEOPPrivService.class, (SessionFactory)this.getSessionFactory());
                pSDEOPPrivService.autoGet((IEntity)pSDEOPPriv);
                this.createpsdeoppriv = pSDEOPPriv;
            }
            return this.createpsdeoppriv;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEOPPriv getUpdatePSDEOPPriv() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUpdatePSDEOPPriv();
        }
        if (this.getUpdatePSDEOPPrivId() == null) {
            return null;
        }
        Integer n = this.objUpdatePSDEOPPrivLock;
        synchronized (n) {
            if (this.updatepsdeoppriv != null && DataTypeHelper.compare((int)25, (Object)this.getUpdatePSDEOPPrivId(), (Object)this.updatepsdeoppriv.getPSDEOPPrivId()) != 0L) {
                this.updatepsdeoppriv = null;
            }
            if (this.updatepsdeoppriv == null) {
                PSDEOPPriv pSDEOPPriv = new PSDEOPPriv();
                pSDEOPPriv.setPSDEOPPrivId(this.getUpdatePSDEOPPrivId());
                PSDEOPPrivService pSDEOPPrivService = (PSDEOPPrivService)ServiceGlobal.getService(PSDEOPPrivService.class, (SessionFactory)this.getSessionFactory());
                pSDEOPPrivService.autoGet((IEntity)pSDEOPPriv);
                this.updatepsdeoppriv = pSDEOPPriv;
            }
            return this.updatepsdeoppriv;
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
                pSSysReqItemService.autoGet((IEntity)pSSysReqItem);
                this.pssysreqitem = pSSysReqItem;
            }
            return this.pssysreqitem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysSFPlugin getPSSysSFPlugin() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPlugin();
        }
        if (this.getPSSysSFPluginId() == null) {
            return null;
        }
        Integer n = this.objPSSysSFPluginLock;
        synchronized (n) {
            if (this.pssyssfplugin != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysSFPluginId(), (Object)this.pssyssfplugin.getPSSysSFPluginId()) != 0L) {
                this.pssyssfplugin = null;
            }
            if (this.pssyssfplugin == null) {
                PSSysSFPlugin pSSysSFPlugin = new PSSysSFPlugin();
                pSSysSFPlugin.setPSSysSFPluginId(this.getPSSysSFPluginId());
                PSSysSFPluginService pSSysSFPluginService = (PSSysSFPluginService)ServiceGlobal.getService(PSSysSFPluginService.class, (SessionFactory)this.getSessionFactory());
                pSSysSFPluginService.autoGet((IEntity)pSSysSFPlugin);
                this.pssyssfplugin = pSSysSFPlugin;
            }
            return this.pssyssfplugin;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEDataImpItem> getPSDEDataImpItems() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataImpItems();
        }
        if (this.getPSDEDataImpId() == null) {
            return null;
        }
        PSDEDataImpService pSDEDataImpService = (PSDEDataImpService)ServiceGlobal.getService(PSDEDataImpService.class, (SessionFactory)this.getSessionFactory());
        PSDEDataImpItemService pSDEDataImpItemService = (PSDEDataImpItemService)ServiceGlobal.getService(PSDEDataImpItemService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEDataImpItemsLock;
        synchronized (n) {
            if (this.psdedataimpitems == null) {
                this.psdedataimpitems = pSDEDataImpService.isTempData((IEntity)this) ? pSDEDataImpItemService.selectTempByPSDEDataImp(this) : pSDEDataImpItemService.selectByPSDEDataImp(this);
            }
            return this.psdedataimpitems;
        }
    }

    private PSDEDataImpBase getProxyEntity() {
        return this.proxyPSDEDataImpBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEDataImpBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEDataImpBase) {
            this.proxyPSDEDataImpBase = (PSDEDataImpBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataImpService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ACTIONHOLDER, 0);
        fieldIndexMap.put(FIELD_BATCHSIZE, 1);
        fieldIndexMap.put(FIELD_CODENAME, 2);
        fieldIndexMap.put(FIELD_CONTENTTYPE, 3);
        fieldIndexMap.put(FIELD_CREATEDATE, 4);
        fieldIndexMap.put(FIELD_CREATEMAN, 5);
        fieldIndexMap.put(FIELD_CREATEPSDEACTIONID, 6);
        fieldIndexMap.put(FIELD_CREATEPSDEACTIONNAME, 7);
        fieldIndexMap.put(FIELD_CREATEPSDEOPPRIVID, 8);
        fieldIndexMap.put(FIELD_CREATEPSDEOPPRIVINAME, 9);
        fieldIndexMap.put(FIELD_CUSTOMCODE, 10);
        fieldIndexMap.put(FIELD_CUSTOMMODE, 11);
        fieldIndexMap.put(FIELD_DATAIMPTYPE, 12);
        fieldIndexMap.put(FIELD_DEFAULTFLAG, 13);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 14);
        fieldIndexMap.put(FIELD_ENABLECUSTOMIZED, 15);
        fieldIndexMap.put(FIELD_EXTENDMODE, 16);
        fieldIndexMap.put(FIELD_IMPPARAMS, 17);
        fieldIndexMap.put(FIELD_IMPTAG, 18);
        fieldIndexMap.put(FIELD_IMPTAG2, 19);
        fieldIndexMap.put(FIELD_LOCKFLAG, 20);
        fieldIndexMap.put(FIELD_MEMO, 21);
        fieldIndexMap.put(FIELD_POTIME, 22);
        fieldIndexMap.put(FIELD_PSDEDATAIMPID, 23);
        fieldIndexMap.put(FIELD_PSDEDATAIMPNAME, 24);
        fieldIndexMap.put(FIELD_PSDEID, 25);
        fieldIndexMap.put(FIELD_PSDENAME, 26);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 27);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINID, 28);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINNAME, 29);
        fieldIndexMap.put(FIELD_PSSYSREQITEMID, 30);
        fieldIndexMap.put(FIELD_PSSYSREQITEMNAME, 31);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 32);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 33);
        fieldIndexMap.put(FIELD_STOPWHENERROR, 34);
        fieldIndexMap.put(FIELD_TODOTASK, 35);
        fieldIndexMap.put(FIELD_UPDATEDATE, 36);
        fieldIndexMap.put(FIELD_UPDATEMAN, 37);
        fieldIndexMap.put(FIELD_UPDATEPSDEACTIONID, 38);
        fieldIndexMap.put(FIELD_UPDATEPSDEACTIONNAME, 39);
        fieldIndexMap.put(FIELD_UPDATEPSDEOPPRIVID, 40);
        fieldIndexMap.put(FIELD_UPDATEPSDEOPPRIVNAME, 41);
        fieldIndexMap.put(FIELD_USERCAT, 42);
        fieldIndexMap.put(FIELD_USERTAG, 43);
        fieldIndexMap.put(FIELD_USERTAG2, 44);
        fieldIndexMap.put(FIELD_USERTAG3, 45);
        fieldIndexMap.put(FIELD_USERTAG4, 46);
        fieldIndexMap.put(FIELD_VALIDFLAG, 47);
    }
}

