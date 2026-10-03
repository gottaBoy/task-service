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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGrid;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEDataExpBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEDataExpBase.class);
    public static final String FIELD_ACTIONHOLDER = "ACTIONHOLDER";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CONTENTTYPE = "CONTENTTYPE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMCODE = "CUSTOMCODE";
    public static final String FIELD_CUSTOMMODE = "CUSTOMMODE";
    public static final String FIELD_DATAEXPTYPE = "DATAEXPTYPE";
    public static final String FIELD_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_ENABLECUSTOMIZED = "ENABLECUSTOMIZED";
    public static final String FIELD_EXPPARAMS = "EXPPARAMS";
    public static final String FIELD_EXPTAG = "EXPTAG";
    public static final String FIELD_EXPTAG2 = "EXPTAG2";
    public static final String FIELD_EXTENDMODE = "EXTENDMODE";
    public static final String FIELD_FILENAMEFORMAT = "FILENAMEFORMAT";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_MAXROWCNT = "MAXROWCNT";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_POTIME = "POTIME";
    public static final String FIELD_PSDEDATAEXPID = "PSDEDATAEXPID";
    public static final String FIELD_PSDEDATAEXPNAME = "PSDEDATAEXPNAME";
    public static final String FIELD_PSDEDATASETID = "PSDEDATASETID";
    public static final String FIELD_PSDEDATASETNAME = "PSDEDATASETNAME";
    public static final String FIELD_PSDEGRIDID = "PSDEGRIDID";
    public static final String FIELD_PSDEGRIDNAME = "PSDEGRIDNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String FIELD_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String FIELD_PSSYSREQITEMID = "PSSYSREQITEMID";
    public static final String FIELD_PSSYSREQITEMNAME = "PSSYSREQITEMNAME";
    public static final String FIELD_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String FIELD_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String FIELD_TODOTASK = "TODOTASK";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_ACTIONHOLDER = 0;
    private static final int INDEX_CODENAME = 1;
    private static final int INDEX_CONTENTTYPE = 2;
    private static final int INDEX_CREATEDATE = 3;
    private static final int INDEX_CREATEMAN = 4;
    private static final int INDEX_CUSTOMCODE = 5;
    private static final int INDEX_CUSTOMMODE = 6;
    private static final int INDEX_DATAEXPTYPE = 7;
    private static final int INDEX_DEFAULTFLAG = 8;
    private static final int INDEX_DYNAMODELFLAG = 9;
    private static final int INDEX_ENABLECUSTOMIZED = 10;
    private static final int INDEX_EXPPARAMS = 11;
    private static final int INDEX_EXPTAG = 12;
    private static final int INDEX_EXPTAG2 = 13;
    private static final int INDEX_EXTENDMODE = 14;
    private static final int INDEX_FILENAMEFORMAT = 15;
    private static final int INDEX_LOCKFLAG = 16;
    private static final int INDEX_MAXROWCNT = 17;
    private static final int INDEX_MEMO = 18;
    private static final int INDEX_POTIME = 19;
    private static final int INDEX_PSDEDATAEXPID = 20;
    private static final int INDEX_PSDEDATAEXPNAME = 21;
    private static final int INDEX_PSDEDATASETID = 22;
    private static final int INDEX_PSDEDATASETNAME = 23;
    private static final int INDEX_PSDEGRIDID = 24;
    private static final int INDEX_PSDEGRIDNAME = 25;
    private static final int INDEX_PSDEID = 26;
    private static final int INDEX_PSDENAME = 27;
    private static final int INDEX_PSDYNAINSTID = 28;
    private static final int INDEX_PSSYSPFPLUGINID = 29;
    private static final int INDEX_PSSYSPFPLUGINNAME = 30;
    private static final int INDEX_PSSYSREQITEMID = 31;
    private static final int INDEX_PSSYSREQITEMNAME = 32;
    private static final int INDEX_PSSYSSFPLUGINID = 33;
    private static final int INDEX_PSSYSSFPLUGINNAME = 34;
    private static final int INDEX_TODOTASK = 35;
    private static final int INDEX_UPDATEDATE = 36;
    private static final int INDEX_UPDATEMAN = 37;
    private static final int INDEX_USERCAT = 38;
    private static final int INDEX_USERTAG = 39;
    private static final int INDEX_USERTAG2 = 40;
    private static final int INDEX_USERTAG3 = 41;
    private static final int INDEX_USERTAG4 = 42;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEDataExpBase proxyPSDEDataExpBase = null;
    private boolean actionholderDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean contenttypeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customcodeDirtyFlag = false;
    private boolean custommodeDirtyFlag = false;
    private boolean dataexptypeDirtyFlag = false;
    private boolean defaultflagDirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean enablecustomizedDirtyFlag = false;
    private boolean expparamsDirtyFlag = false;
    private boolean exptagDirtyFlag = false;
    private boolean exptag2DirtyFlag = false;
    private boolean extendmodeDirtyFlag = false;
    private boolean filenameformatDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean maxrowcntDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean potimeDirtyFlag = false;
    private boolean psdedataexpidDirtyFlag = false;
    private boolean psdedataexpnameDirtyFlag = false;
    private boolean psdedatasetidDirtyFlag = false;
    private boolean psdedatasetnameDirtyFlag = false;
    private boolean psdegrididDirtyFlag = false;
    private boolean psdegridnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean pssyspfpluginidDirtyFlag = false;
    private boolean pssyspfpluginnameDirtyFlag = false;
    private boolean pssysreqitemidDirtyFlag = false;
    private boolean pssysreqitemnameDirtyFlag = false;
    private boolean pssyssfpluginidDirtyFlag = false;
    private boolean pssyssfpluginnameDirtyFlag = false;
    private boolean todotaskDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="actionholder")
    private Integer actionholder;
    @Column(name="codename")
    private String codename;
    @Column(name="contenttype")
    private String contenttype;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="customcode")
    private String customcode;
    @Column(name="custommode")
    private Integer custommode;
    @Column(name="dataexptype")
    private String dataexptype;
    @Column(name="defaultflag")
    private Integer defaultflag;
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="enablecustomized")
    private Integer enablecustomized;
    @Column(name="expparams")
    private String expparams;
    @Column(name="exptag")
    private String exptag;
    @Column(name="exptag2")
    private String exptag2;
    @Column(name="extendmode")
    private Integer extendmode;
    @Column(name="filenameformat")
    private String filenameformat;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="maxrowcnt")
    private Integer maxrowcnt;
    @Column(name="memo")
    private String memo;
    @Column(name="potime")
    private Integer potime;
    @Column(name="psdedataexpid")
    private String psdedataexpid;
    @Column(name="psdedataexpname")
    private String psdedataexpname;
    @Column(name="psdedatasetid")
    private String psdedatasetid;
    @Column(name="psdedatasetname")
    private String psdedatasetname;
    @Column(name="psdegridid")
    private String psdegridid;
    @Column(name="psdegridname")
    private String psdegridname;
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
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objPSDEDataSetLock = new Integer(1);
    private PSDEDataSet psdedataset = null;
    private Integer objPSDEGridLock = new Integer(1);
    private PSDEGrid psdegrid = null;
    private Integer objPSSysPFPluginLock = new Integer(1);
    private PSSysPFPlugin pssyspfplugin = null;
    private Integer objPSSysReqItemLock = new Integer(1);
    private PSSysReqItem pssysreqitem = null;
    private Integer objPSSysSFPluginLock = new Integer(1);
    private PSSysSFPlugin pssyssfplugin = null;

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

    public void setDataExpType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDataExpType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dataexptype = string;
        this.dataexptypeDirtyFlag = true;
    }

    public String getDataExpType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDataExpType();
        }
        return this.dataexptype;
    }

    public boolean isDataExpTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataExpTypeDirty();
        }
        return this.dataexptypeDirtyFlag;
    }

    public void resetDataExpType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDataExpType();
            return;
        }
        this.dataexptypeDirtyFlag = false;
        this.dataexptype = null;
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

    public void setExpParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExpParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.expparams = string;
        this.expparamsDirtyFlag = true;
    }

    public String getExpParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExpParams();
        }
        return this.expparams;
    }

    public boolean isExpParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExpParamsDirty();
        }
        return this.expparamsDirtyFlag;
    }

    public void resetExpParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExpParams();
            return;
        }
        this.expparamsDirtyFlag = false;
        this.expparams = null;
    }

    public void setExpTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExpTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.exptag = string;
        this.exptagDirtyFlag = true;
    }

    public String getExpTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExpTag();
        }
        return this.exptag;
    }

    public boolean isExpTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExpTagDirty();
        }
        return this.exptagDirtyFlag;
    }

    public void resetExpTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExpTag();
            return;
        }
        this.exptagDirtyFlag = false;
        this.exptag = null;
    }

    public void setExpTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExpTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.exptag2 = string;
        this.exptag2DirtyFlag = true;
    }

    public String getExpTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExpTag2();
        }
        return this.exptag2;
    }

    public boolean isExpTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExpTag2Dirty();
        }
        return this.exptag2DirtyFlag;
    }

    public void resetExpTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExpTag2();
            return;
        }
        this.exptag2DirtyFlag = false;
        this.exptag2 = null;
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

    public void setFileNameFormat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFileNameFormat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.filenameformat = string;
        this.filenameformatDirtyFlag = true;
    }

    public String getFileNameFormat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFileNameFormat();
        }
        return this.filenameformat;
    }

    public boolean isFileNameFormatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFileNameFormatDirty();
        }
        return this.filenameformatDirtyFlag;
    }

    public void resetFileNameFormat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFileNameFormat();
            return;
        }
        this.filenameformatDirtyFlag = false;
        this.filenameformat = null;
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

    public void setMaxRowCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMaxRowCnt(n);
            return;
        }
        this.maxrowcnt = n;
        this.maxrowcntDirtyFlag = true;
    }

    public Integer getMaxRowCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMaxRowCnt();
        }
        return this.maxrowcnt;
    }

    public boolean isMaxRowCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMaxRowCntDirty();
        }
        return this.maxrowcntDirtyFlag;
    }

    public void resetMaxRowCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMaxRowCnt();
            return;
        }
        this.maxrowcntDirtyFlag = false;
        this.maxrowcnt = null;
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

    public void setPSDEDataExpId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataExpId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedataexpid = string;
        this.psdedataexpidDirtyFlag = true;
    }

    public String getPSDEDataExpId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataExpId();
        }
        return this.psdedataexpid;
    }

    public boolean isPSDEDataExpIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataExpIdDirty();
        }
        return this.psdedataexpidDirtyFlag;
    }

    public void resetPSDEDataExpId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataExpId();
            return;
        }
        this.psdedataexpidDirtyFlag = false;
        this.psdedataexpid = null;
    }

    public void setPSDEDataExpName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataExpName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedataexpname = string;
        this.psdedataexpnameDirtyFlag = true;
    }

    public String getPSDEDataExpName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataExpName();
        }
        return this.psdedataexpname;
    }

    public boolean isPSDEDataExpNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataExpNameDirty();
        }
        return this.psdedataexpnameDirtyFlag;
    }

    public void resetPSDEDataExpName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataExpName();
            return;
        }
        this.psdedataexpnameDirtyFlag = false;
        this.psdedataexpname = null;
    }

    public void setPSDEDataSetId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataSetId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedatasetid = string;
        this.psdedatasetidDirtyFlag = true;
    }

    public String getPSDEDataSetId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataSetId();
        }
        return this.psdedatasetid;
    }

    public boolean isPSDEDataSetIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataSetIdDirty();
        }
        return this.psdedatasetidDirtyFlag;
    }

    public void resetPSDEDataSetId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataSetId();
            return;
        }
        this.psdedatasetidDirtyFlag = false;
        this.psdedatasetid = null;
    }

    public void setPSDEDataSetName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataSetName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedatasetname = string;
        this.psdedatasetnameDirtyFlag = true;
    }

    public String getPSDEDataSetName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataSetName();
        }
        return this.psdedatasetname;
    }

    public boolean isPSDEDataSetNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataSetNameDirty();
        }
        return this.psdedatasetnameDirtyFlag;
    }

    public void resetPSDEDataSetName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataSetName();
            return;
        }
        this.psdedatasetnameDirtyFlag = false;
        this.psdedatasetname = null;
    }

    public void setPSDEGridId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEGridId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdegridid = string;
        this.psdegrididDirtyFlag = true;
    }

    public String getPSDEGridId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGridId();
        }
        return this.psdegridid;
    }

    public boolean isPSDEGridIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEGridIdDirty();
        }
        return this.psdegrididDirtyFlag;
    }

    public void resetPSDEGridId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEGridId();
            return;
        }
        this.psdegrididDirtyFlag = false;
        this.psdegridid = null;
    }

    public void setPSDEGridName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEGridName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdegridname = string;
        this.psdegridnameDirtyFlag = true;
    }

    public String getPSDEGridName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGridName();
        }
        return this.psdegridname;
    }

    public boolean isPSDEGridNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEGridNameDirty();
        }
        return this.psdegridnameDirtyFlag;
    }

    public void resetPSDEGridName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEGridName();
            return;
        }
        this.psdegridnameDirtyFlag = false;
        this.psdegridname = null;
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

    protected void onReset() {
        PSDEDataExpBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEDataExpBase pSDEDataExpBase) {
        pSDEDataExpBase.resetActionHolder();
        pSDEDataExpBase.resetCodeName();
        pSDEDataExpBase.resetContentType();
        pSDEDataExpBase.resetCreateDate();
        pSDEDataExpBase.resetCreateMan();
        pSDEDataExpBase.resetCustomCode();
        pSDEDataExpBase.resetCustomMode();
        pSDEDataExpBase.resetDataExpType();
        pSDEDataExpBase.resetDefaultFlag();
        pSDEDataExpBase.resetDynaModelFlag();
        pSDEDataExpBase.resetEnableCustomized();
        pSDEDataExpBase.resetExpParams();
        pSDEDataExpBase.resetExpTag();
        pSDEDataExpBase.resetExpTag2();
        pSDEDataExpBase.resetExtendMode();
        pSDEDataExpBase.resetFileNameFormat();
        pSDEDataExpBase.resetLockFlag();
        pSDEDataExpBase.resetMaxRowCnt();
        pSDEDataExpBase.resetMemo();
        pSDEDataExpBase.resetPOTime();
        pSDEDataExpBase.resetPSDEDataExpId();
        pSDEDataExpBase.resetPSDEDataExpName();
        pSDEDataExpBase.resetPSDEDataSetId();
        pSDEDataExpBase.resetPSDEDataSetName();
        pSDEDataExpBase.resetPSDEGridId();
        pSDEDataExpBase.resetPSDEGridName();
        pSDEDataExpBase.resetPSDEId();
        pSDEDataExpBase.resetPSDEName();
        pSDEDataExpBase.resetPSDynaInstId();
        pSDEDataExpBase.resetPSSysPFPluginId();
        pSDEDataExpBase.resetPSSysPFPluginName();
        pSDEDataExpBase.resetPSSysReqItemId();
        pSDEDataExpBase.resetPSSysReqItemName();
        pSDEDataExpBase.resetPSSysSFPluginId();
        pSDEDataExpBase.resetPSSysSFPluginName();
        pSDEDataExpBase.resetToDoTask();
        pSDEDataExpBase.resetUpdateDate();
        pSDEDataExpBase.resetUpdateMan();
        pSDEDataExpBase.resetUserCat();
        pSDEDataExpBase.resetUserTag();
        pSDEDataExpBase.resetUserTag2();
        pSDEDataExpBase.resetUserTag3();
        pSDEDataExpBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isActionHolderDirty()) {
            hashMap.put(FIELD_ACTIONHOLDER, this.getActionHolder());
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
        if (!bl || this.isCustomCodeDirty()) {
            hashMap.put(FIELD_CUSTOMCODE, this.getCustomCode());
        }
        if (!bl || this.isCustomModeDirty()) {
            hashMap.put(FIELD_CUSTOMMODE, this.getCustomMode());
        }
        if (!bl || this.isDataExpTypeDirty()) {
            hashMap.put(FIELD_DATAEXPTYPE, this.getDataExpType());
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
        if (!bl || this.isExpParamsDirty()) {
            hashMap.put(FIELD_EXPPARAMS, this.getExpParams());
        }
        if (!bl || this.isExpTagDirty()) {
            hashMap.put(FIELD_EXPTAG, this.getExpTag());
        }
        if (!bl || this.isExpTag2Dirty()) {
            hashMap.put(FIELD_EXPTAG2, this.getExpTag2());
        }
        if (!bl || this.isExtendModeDirty()) {
            hashMap.put(FIELD_EXTENDMODE, this.getExtendMode());
        }
        if (!bl || this.isFileNameFormatDirty()) {
            hashMap.put(FIELD_FILENAMEFORMAT, this.getFileNameFormat());
        }
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
        }
        if (!bl || this.isMaxRowCntDirty()) {
            hashMap.put(FIELD_MAXROWCNT, this.getMaxRowCnt());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPOTimeDirty()) {
            hashMap.put(FIELD_POTIME, this.getPOTime());
        }
        if (!bl || this.isPSDEDataExpIdDirty()) {
            hashMap.put(FIELD_PSDEDATAEXPID, this.getPSDEDataExpId());
        }
        if (!bl || this.isPSDEDataExpNameDirty()) {
            hashMap.put(FIELD_PSDEDATAEXPNAME, this.getPSDEDataExpName());
        }
        if (!bl || this.isPSDEDataSetIdDirty()) {
            hashMap.put(FIELD_PSDEDATASETID, this.getPSDEDataSetId());
        }
        if (!bl || this.isPSDEDataSetNameDirty()) {
            hashMap.put(FIELD_PSDEDATASETNAME, this.getPSDEDataSetName());
        }
        if (!bl || this.isPSDEGridIdDirty()) {
            hashMap.put(FIELD_PSDEGRIDID, this.getPSDEGridId());
        }
        if (!bl || this.isPSDEGridNameDirty()) {
            hashMap.put(FIELD_PSDEGRIDNAME, this.getPSDEGridName());
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
        return PSDEDataExpBase.get(this, n);
    }

    private static Object get(PSDEDataExpBase pSDEDataExpBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDataExpBase.getActionHolder();
            }
            case 1: {
                return pSDEDataExpBase.getCodeName();
            }
            case 2: {
                return pSDEDataExpBase.getContentType();
            }
            case 3: {
                return pSDEDataExpBase.getCreateDate();
            }
            case 4: {
                return pSDEDataExpBase.getCreateMan();
            }
            case 5: {
                return pSDEDataExpBase.getCustomCode();
            }
            case 6: {
                return pSDEDataExpBase.getCustomMode();
            }
            case 7: {
                return pSDEDataExpBase.getDataExpType();
            }
            case 8: {
                return pSDEDataExpBase.getDefaultFlag();
            }
            case 9: {
                return pSDEDataExpBase.getDynaModelFlag();
            }
            case 10: {
                return pSDEDataExpBase.getEnableCustomized();
            }
            case 11: {
                return pSDEDataExpBase.getExpParams();
            }
            case 12: {
                return pSDEDataExpBase.getExpTag();
            }
            case 13: {
                return pSDEDataExpBase.getExpTag2();
            }
            case 14: {
                return pSDEDataExpBase.getExtendMode();
            }
            case 15: {
                return pSDEDataExpBase.getFileNameFormat();
            }
            case 16: {
                return pSDEDataExpBase.getLockFlag();
            }
            case 17: {
                return pSDEDataExpBase.getMaxRowCnt();
            }
            case 18: {
                return pSDEDataExpBase.getMemo();
            }
            case 19: {
                return pSDEDataExpBase.getPOTime();
            }
            case 20: {
                return pSDEDataExpBase.getPSDEDataExpId();
            }
            case 21: {
                return pSDEDataExpBase.getPSDEDataExpName();
            }
            case 22: {
                return pSDEDataExpBase.getPSDEDataSetId();
            }
            case 23: {
                return pSDEDataExpBase.getPSDEDataSetName();
            }
            case 24: {
                return pSDEDataExpBase.getPSDEGridId();
            }
            case 25: {
                return pSDEDataExpBase.getPSDEGridName();
            }
            case 26: {
                return pSDEDataExpBase.getPSDEId();
            }
            case 27: {
                return pSDEDataExpBase.getPSDEName();
            }
            case 28: {
                return pSDEDataExpBase.getPSDynaInstId();
            }
            case 29: {
                return pSDEDataExpBase.getPSSysPFPluginId();
            }
            case 30: {
                return pSDEDataExpBase.getPSSysPFPluginName();
            }
            case 31: {
                return pSDEDataExpBase.getPSSysReqItemId();
            }
            case 32: {
                return pSDEDataExpBase.getPSSysReqItemName();
            }
            case 33: {
                return pSDEDataExpBase.getPSSysSFPluginId();
            }
            case 34: {
                return pSDEDataExpBase.getPSSysSFPluginName();
            }
            case 35: {
                return pSDEDataExpBase.getToDoTask();
            }
            case 36: {
                return pSDEDataExpBase.getUpdateDate();
            }
            case 37: {
                return pSDEDataExpBase.getUpdateMan();
            }
            case 38: {
                return pSDEDataExpBase.getUserCat();
            }
            case 39: {
                return pSDEDataExpBase.getUserTag();
            }
            case 40: {
                return pSDEDataExpBase.getUserTag2();
            }
            case 41: {
                return pSDEDataExpBase.getUserTag3();
            }
            case 42: {
                return pSDEDataExpBase.getUserTag4();
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
        PSDEDataExpBase.set(this, n, object);
    }

    private static void set(PSDEDataExpBase pSDEDataExpBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEDataExpBase.setActionHolder(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSDEDataExpBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEDataExpBase.setContentType(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEDataExpBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSDEDataExpBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEDataExpBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEDataExpBase.setCustomMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSDEDataExpBase.setDataExpType(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEDataExpBase.setDefaultFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSDEDataExpBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSDEDataExpBase.setEnableCustomized(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSDEDataExpBase.setExpParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEDataExpBase.setExpTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEDataExpBase.setExpTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEDataExpBase.setExtendMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSDEDataExpBase.setFileNameFormat(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEDataExpBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 17: {
                pSDEDataExpBase.setMaxRowCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 18: {
                pSDEDataExpBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEDataExpBase.setPOTime(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 20: {
                pSDEDataExpBase.setPSDEDataExpId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEDataExpBase.setPSDEDataExpName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDEDataExpBase.setPSDEDataSetId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDEDataExpBase.setPSDEDataSetName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDEDataExpBase.setPSDEGridId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDEDataExpBase.setPSDEGridName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDEDataExpBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDEDataExpBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDEDataExpBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDEDataExpBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDEDataExpBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDEDataExpBase.setPSSysReqItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDEDataExpBase.setPSSysReqItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDEDataExpBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDEDataExpBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDEDataExpBase.setToDoTask(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDEDataExpBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 37: {
                pSDEDataExpBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDEDataExpBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSDEDataExpBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSDEDataExpBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSDEDataExpBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSDEDataExpBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSDEDataExpBase.isNull(this, n);
    }

    private static boolean isNull(PSDEDataExpBase pSDEDataExpBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDataExpBase.getActionHolder() == null;
            }
            case 1: {
                return pSDEDataExpBase.getCodeName() == null;
            }
            case 2: {
                return pSDEDataExpBase.getContentType() == null;
            }
            case 3: {
                return pSDEDataExpBase.getCreateDate() == null;
            }
            case 4: {
                return pSDEDataExpBase.getCreateMan() == null;
            }
            case 5: {
                return pSDEDataExpBase.getCustomCode() == null;
            }
            case 6: {
                return pSDEDataExpBase.getCustomMode() == null;
            }
            case 7: {
                return pSDEDataExpBase.getDataExpType() == null;
            }
            case 8: {
                return pSDEDataExpBase.getDefaultFlag() == null;
            }
            case 9: {
                return pSDEDataExpBase.getDynaModelFlag() == null;
            }
            case 10: {
                return pSDEDataExpBase.getEnableCustomized() == null;
            }
            case 11: {
                return pSDEDataExpBase.getExpParams() == null;
            }
            case 12: {
                return pSDEDataExpBase.getExpTag() == null;
            }
            case 13: {
                return pSDEDataExpBase.getExpTag2() == null;
            }
            case 14: {
                return pSDEDataExpBase.getExtendMode() == null;
            }
            case 15: {
                return pSDEDataExpBase.getFileNameFormat() == null;
            }
            case 16: {
                return pSDEDataExpBase.getLockFlag() == null;
            }
            case 17: {
                return pSDEDataExpBase.getMaxRowCnt() == null;
            }
            case 18: {
                return pSDEDataExpBase.getMemo() == null;
            }
            case 19: {
                return pSDEDataExpBase.getPOTime() == null;
            }
            case 20: {
                return pSDEDataExpBase.getPSDEDataExpId() == null;
            }
            case 21: {
                return pSDEDataExpBase.getPSDEDataExpName() == null;
            }
            case 22: {
                return pSDEDataExpBase.getPSDEDataSetId() == null;
            }
            case 23: {
                return pSDEDataExpBase.getPSDEDataSetName() == null;
            }
            case 24: {
                return pSDEDataExpBase.getPSDEGridId() == null;
            }
            case 25: {
                return pSDEDataExpBase.getPSDEGridName() == null;
            }
            case 26: {
                return pSDEDataExpBase.getPSDEId() == null;
            }
            case 27: {
                return pSDEDataExpBase.getPSDEName() == null;
            }
            case 28: {
                return pSDEDataExpBase.getPSDynaInstId() == null;
            }
            case 29: {
                return pSDEDataExpBase.getPSSysPFPluginId() == null;
            }
            case 30: {
                return pSDEDataExpBase.getPSSysPFPluginName() == null;
            }
            case 31: {
                return pSDEDataExpBase.getPSSysReqItemId() == null;
            }
            case 32: {
                return pSDEDataExpBase.getPSSysReqItemName() == null;
            }
            case 33: {
                return pSDEDataExpBase.getPSSysSFPluginId() == null;
            }
            case 34: {
                return pSDEDataExpBase.getPSSysSFPluginName() == null;
            }
            case 35: {
                return pSDEDataExpBase.getToDoTask() == null;
            }
            case 36: {
                return pSDEDataExpBase.getUpdateDate() == null;
            }
            case 37: {
                return pSDEDataExpBase.getUpdateMan() == null;
            }
            case 38: {
                return pSDEDataExpBase.getUserCat() == null;
            }
            case 39: {
                return pSDEDataExpBase.getUserTag() == null;
            }
            case 40: {
                return pSDEDataExpBase.getUserTag2() == null;
            }
            case 41: {
                return pSDEDataExpBase.getUserTag3() == null;
            }
            case 42: {
                return pSDEDataExpBase.getUserTag4() == null;
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
        return PSDEDataExpBase.contains(this, n);
    }

    private static boolean contains(PSDEDataExpBase pSDEDataExpBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDataExpBase.isActionHolderDirty();
            }
            case 1: {
                return pSDEDataExpBase.isCodeNameDirty();
            }
            case 2: {
                return pSDEDataExpBase.isContentTypeDirty();
            }
            case 3: {
                return pSDEDataExpBase.isCreateDateDirty();
            }
            case 4: {
                return pSDEDataExpBase.isCreateManDirty();
            }
            case 5: {
                return pSDEDataExpBase.isCustomCodeDirty();
            }
            case 6: {
                return pSDEDataExpBase.isCustomModeDirty();
            }
            case 7: {
                return pSDEDataExpBase.isDataExpTypeDirty();
            }
            case 8: {
                return pSDEDataExpBase.isDefaultFlagDirty();
            }
            case 9: {
                return pSDEDataExpBase.isDynaModelFlagDirty();
            }
            case 10: {
                return pSDEDataExpBase.isEnableCustomizedDirty();
            }
            case 11: {
                return pSDEDataExpBase.isExpParamsDirty();
            }
            case 12: {
                return pSDEDataExpBase.isExpTagDirty();
            }
            case 13: {
                return pSDEDataExpBase.isExpTag2Dirty();
            }
            case 14: {
                return pSDEDataExpBase.isExtendModeDirty();
            }
            case 15: {
                return pSDEDataExpBase.isFileNameFormatDirty();
            }
            case 16: {
                return pSDEDataExpBase.isLockFlagDirty();
            }
            case 17: {
                return pSDEDataExpBase.isMaxRowCntDirty();
            }
            case 18: {
                return pSDEDataExpBase.isMemoDirty();
            }
            case 19: {
                return pSDEDataExpBase.isPOTimeDirty();
            }
            case 20: {
                return pSDEDataExpBase.isPSDEDataExpIdDirty();
            }
            case 21: {
                return pSDEDataExpBase.isPSDEDataExpNameDirty();
            }
            case 22: {
                return pSDEDataExpBase.isPSDEDataSetIdDirty();
            }
            case 23: {
                return pSDEDataExpBase.isPSDEDataSetNameDirty();
            }
            case 24: {
                return pSDEDataExpBase.isPSDEGridIdDirty();
            }
            case 25: {
                return pSDEDataExpBase.isPSDEGridNameDirty();
            }
            case 26: {
                return pSDEDataExpBase.isPSDEIdDirty();
            }
            case 27: {
                return pSDEDataExpBase.isPSDENameDirty();
            }
            case 28: {
                return pSDEDataExpBase.isPSDynaInstIdDirty();
            }
            case 29: {
                return pSDEDataExpBase.isPSSysPFPluginIdDirty();
            }
            case 30: {
                return pSDEDataExpBase.isPSSysPFPluginNameDirty();
            }
            case 31: {
                return pSDEDataExpBase.isPSSysReqItemIdDirty();
            }
            case 32: {
                return pSDEDataExpBase.isPSSysReqItemNameDirty();
            }
            case 33: {
                return pSDEDataExpBase.isPSSysSFPluginIdDirty();
            }
            case 34: {
                return pSDEDataExpBase.isPSSysSFPluginNameDirty();
            }
            case 35: {
                return pSDEDataExpBase.isToDoTaskDirty();
            }
            case 36: {
                return pSDEDataExpBase.isUpdateDateDirty();
            }
            case 37: {
                return pSDEDataExpBase.isUpdateManDirty();
            }
            case 38: {
                return pSDEDataExpBase.isUserCatDirty();
            }
            case 39: {
                return pSDEDataExpBase.isUserTagDirty();
            }
            case 40: {
                return pSDEDataExpBase.isUserTag2Dirty();
            }
            case 41: {
                return pSDEDataExpBase.isUserTag3Dirty();
            }
            case 42: {
                return pSDEDataExpBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEDataExpBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEDataExpBase pSDEDataExpBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEDataExpBase.getActionHolder() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionholder", (Object)PSDEDataExpBase.getJSONValue((Object)pSDEDataExpBase.getActionHolder()), (boolean)false);
        }
        if (bl || pSDEDataExpBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDEDataExpBase.getJSONValue((Object)pSDEDataExpBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDEDataExpBase.getContentType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"contenttype", (Object)PSDEDataExpBase.getJSONValue((Object)pSDEDataExpBase.getContentType()), (boolean)false);
        }
        if (bl || pSDEDataExpBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEDataExpBase.getJSONValue((Object)pSDEDataExpBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEDataExpBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEDataExpBase.getJSONValue((Object)pSDEDataExpBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEDataExpBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSDEDataExpBase.getJSONValue((Object)pSDEDataExpBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSDEDataExpBase.getCustomMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"custommode", (Object)PSDEDataExpBase.getJSONValue((Object)pSDEDataExpBase.getCustomMode()), (boolean)false);
        }
        if (bl || pSDEDataExpBase.getDataExpType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dataexptype", (Object)PSDEDataExpBase.getJSONValue((Object)pSDEDataExpBase.getDataExpType()), (boolean)false);
        }
        if (bl || pSDEDataExpBase.getDefaultFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultflag", (Object)PSDEDataExpBase.getJSONValue((Object)pSDEDataExpBase.getDefaultFlag()), (boolean)false);
        }
        if (bl || pSDEDataExpBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSDEDataExpBase.getJSONValue((Object)pSDEDataExpBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSDEDataExpBase.getEnableCustomized() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablecustomized", (Object)PSDEDataExpBase.getJSONValue((Object)pSDEDataExpBase.getEnableCustomized()), (boolean)false);
        }
        if (bl || pSDEDataExpBase.getExpParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"expparams", (Object)PSDEDataExpBase.getJSONValue((Object)pSDEDataExpBase.getExpParams()), (boolean)false);
        }
        if (bl || pSDEDataExpBase.getExpTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"exptag", (Object)PSDEDataExpBase.getJSONValue((Object)pSDEDataExpBase.getExpTag()), (boolean)false);
        }
        if (bl || pSDEDataExpBase.getExpTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"exptag2", (Object)PSDEDataExpBase.getJSONValue((Object)pSDEDataExpBase.getExpTag2()), (boolean)false);
        }
        if (bl || pSDEDataExpBase.getExtendMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"extendmode", (Object)PSDEDataExpBase.getJSONValue((Object)pSDEDataExpBase.getExtendMode()), (boolean)false);
        }
        if (bl || pSDEDataExpBase.getFileNameFormat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"filenameformat", (Object)PSDEDataExpBase.getJSONValue((Object)pSDEDataExpBase.getFileNameFormat()), (boolean)false);
        }
        if (bl || pSDEDataExpBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSDEDataExpBase.getJSONValue((Object)pSDEDataExpBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSDEDataExpBase.getMaxRowCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maxrowcnt", (Object)PSDEDataExpBase.getJSONValue((Object)pSDEDataExpBase.getMaxRowCnt()), (boolean)false);
        }
        if (bl || pSDEDataExpBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEDataExpBase.getJSONValue((Object)pSDEDataExpBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEDataExpBase.getPOTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"potime", (Object)PSDEDataExpBase.getJSONValue((Object)pSDEDataExpBase.getPOTime()), (boolean)false);
        }
        if (bl || pSDEDataExpBase.getPSDEDataExpId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedataexpid", (Object)PSDEDataExpBase.getJSONValue((Object)pSDEDataExpBase.getPSDEDataExpId()), (boolean)false);
        }
        if (bl || pSDEDataExpBase.getPSDEDataExpName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedataexpname", (Object)PSDEDataExpBase.getJSONValue((Object)pSDEDataExpBase.getPSDEDataExpName()), (boolean)false);
        }
        if (bl || pSDEDataExpBase.getPSDEDataSetId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedatasetid", (Object)PSDEDataExpBase.getJSONValue((Object)pSDEDataExpBase.getPSDEDataSetId()), (boolean)false);
        }
        if (bl || pSDEDataExpBase.getPSDEDataSetName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedatasetname", (Object)PSDEDataExpBase.getJSONValue((Object)pSDEDataExpBase.getPSDEDataSetName()), (boolean)false);
        }
        if (bl || pSDEDataExpBase.getPSDEGridId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdegridid", (Object)PSDEDataExpBase.getJSONValue((Object)pSDEDataExpBase.getPSDEGridId()), (boolean)false);
        }
        if (bl || pSDEDataExpBase.getPSDEGridName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdegridname", (Object)PSDEDataExpBase.getJSONValue((Object)pSDEDataExpBase.getPSDEGridName()), (boolean)false);
        }
        if (bl || pSDEDataExpBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEDataExpBase.getJSONValue((Object)pSDEDataExpBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEDataExpBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDEDataExpBase.getJSONValue((Object)pSDEDataExpBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDEDataExpBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSDEDataExpBase.getJSONValue((Object)pSDEDataExpBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSDEDataExpBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSDEDataExpBase.getJSONValue((Object)pSDEDataExpBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSDEDataExpBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSDEDataExpBase.getJSONValue((Object)pSDEDataExpBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSDEDataExpBase.getPSSysReqItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemid", (Object)PSDEDataExpBase.getJSONValue((Object)pSDEDataExpBase.getPSSysReqItemId()), (boolean)false);
        }
        if (bl || pSDEDataExpBase.getPSSysReqItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemname", (Object)PSDEDataExpBase.getJSONValue((Object)pSDEDataExpBase.getPSSysReqItemName()), (boolean)false);
        }
        if (bl || pSDEDataExpBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSDEDataExpBase.getJSONValue((Object)pSDEDataExpBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSDEDataExpBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSDEDataExpBase.getJSONValue((Object)pSDEDataExpBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSDEDataExpBase.getToDoTask() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"todotask", (Object)PSDEDataExpBase.getJSONValue((Object)pSDEDataExpBase.getToDoTask()), (boolean)false);
        }
        if (bl || pSDEDataExpBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEDataExpBase.getJSONValue((Object)pSDEDataExpBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEDataExpBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEDataExpBase.getJSONValue((Object)pSDEDataExpBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEDataExpBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEDataExpBase.getJSONValue((Object)pSDEDataExpBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEDataExpBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEDataExpBase.getJSONValue((Object)pSDEDataExpBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEDataExpBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEDataExpBase.getJSONValue((Object)pSDEDataExpBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEDataExpBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEDataExpBase.getJSONValue((Object)pSDEDataExpBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEDataExpBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEDataExpBase.getJSONValue((Object)pSDEDataExpBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEDataExpBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEDataExpBase pSDEDataExpBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEDataExpBase.getActionHolder() != null) {
            object = pSDEDataExpBase.getActionHolder();
            xmlNode.setAttribute(FIELD_ACTIONHOLDER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataExpBase.getCodeName() != null) {
            object = pSDEDataExpBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataExpBase.getContentType() != null) {
            object = pSDEDataExpBase.getContentType();
            xmlNode.setAttribute(FIELD_CONTENTTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataExpBase.getCreateDate() != null) {
            object = pSDEDataExpBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEDataExpBase.getCreateMan() != null) {
            object = pSDEDataExpBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataExpBase.getCustomCode() != null) {
            object = pSDEDataExpBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataExpBase.getCustomMode() != null) {
            object = pSDEDataExpBase.getCustomMode();
            xmlNode.setAttribute(FIELD_CUSTOMMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataExpBase.getDataExpType() != null) {
            object = pSDEDataExpBase.getDataExpType();
            xmlNode.setAttribute(FIELD_DATAEXPTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataExpBase.getDefaultFlag() != null) {
            object = pSDEDataExpBase.getDefaultFlag();
            xmlNode.setAttribute(FIELD_DEFAULTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataExpBase.getDynaModelFlag() != null) {
            object = pSDEDataExpBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataExpBase.getEnableCustomized() != null) {
            object = pSDEDataExpBase.getEnableCustomized();
            xmlNode.setAttribute(FIELD_ENABLECUSTOMIZED, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataExpBase.getExpParams() != null) {
            object = pSDEDataExpBase.getExpParams();
            xmlNode.setAttribute(FIELD_EXPPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataExpBase.getExpTag() != null) {
            object = pSDEDataExpBase.getExpTag();
            xmlNode.setAttribute(FIELD_EXPTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataExpBase.getExpTag2() != null) {
            object = pSDEDataExpBase.getExpTag2();
            xmlNode.setAttribute(FIELD_EXPTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataExpBase.getExtendMode() != null) {
            object = pSDEDataExpBase.getExtendMode();
            xmlNode.setAttribute(FIELD_EXTENDMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataExpBase.getFileNameFormat() != null) {
            object = pSDEDataExpBase.getFileNameFormat();
            xmlNode.setAttribute(FIELD_FILENAMEFORMAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataExpBase.getLockFlag() != null) {
            object = pSDEDataExpBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataExpBase.getMaxRowCnt() != null) {
            object = pSDEDataExpBase.getMaxRowCnt();
            xmlNode.setAttribute(FIELD_MAXROWCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataExpBase.getMemo() != null) {
            object = pSDEDataExpBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataExpBase.getPOTime() != null) {
            object = pSDEDataExpBase.getPOTime();
            xmlNode.setAttribute(FIELD_POTIME, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataExpBase.getPSDEDataExpId() != null) {
            object = pSDEDataExpBase.getPSDEDataExpId();
            xmlNode.setAttribute(FIELD_PSDEDATAEXPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataExpBase.getPSDEDataExpName() != null) {
            object = pSDEDataExpBase.getPSDEDataExpName();
            xmlNode.setAttribute(FIELD_PSDEDATAEXPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataExpBase.getPSDEDataSetId() != null) {
            object = pSDEDataExpBase.getPSDEDataSetId();
            xmlNode.setAttribute(FIELD_PSDEDATASETID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataExpBase.getPSDEDataSetName() != null) {
            object = pSDEDataExpBase.getPSDEDataSetName();
            xmlNode.setAttribute(FIELD_PSDEDATASETNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataExpBase.getPSDEGridId() != null) {
            object = pSDEDataExpBase.getPSDEGridId();
            xmlNode.setAttribute(FIELD_PSDEGRIDID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataExpBase.getPSDEGridName() != null) {
            object = pSDEDataExpBase.getPSDEGridName();
            xmlNode.setAttribute(FIELD_PSDEGRIDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataExpBase.getPSDEId() != null) {
            object = pSDEDataExpBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataExpBase.getPSDEName() != null) {
            object = pSDEDataExpBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataExpBase.getPSDynaInstId() != null) {
            object = pSDEDataExpBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataExpBase.getPSSysPFPluginId() != null) {
            object = pSDEDataExpBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataExpBase.getPSSysPFPluginName() != null) {
            object = pSDEDataExpBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataExpBase.getPSSysReqItemId() != null) {
            object = pSDEDataExpBase.getPSSysReqItemId();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataExpBase.getPSSysReqItemName() != null) {
            object = pSDEDataExpBase.getPSSysReqItemName();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataExpBase.getPSSysSFPluginId() != null) {
            object = pSDEDataExpBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataExpBase.getPSSysSFPluginName() != null) {
            object = pSDEDataExpBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataExpBase.getToDoTask() != null) {
            object = pSDEDataExpBase.getToDoTask();
            xmlNode.setAttribute(FIELD_TODOTASK, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataExpBase.getUpdateDate() != null) {
            object = pSDEDataExpBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEDataExpBase.getUpdateMan() != null) {
            object = pSDEDataExpBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataExpBase.getUserCat() != null) {
            object = pSDEDataExpBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataExpBase.getUserTag() != null) {
            object = pSDEDataExpBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataExpBase.getUserTag2() != null) {
            object = pSDEDataExpBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataExpBase.getUserTag3() != null) {
            object = pSDEDataExpBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataExpBase.getUserTag4() != null) {
            object = pSDEDataExpBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEDataExpBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEDataExpBase pSDEDataExpBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEDataExpBase.isActionHolderDirty() && (bl || pSDEDataExpBase.getActionHolder() != null)) {
            iDataObject.set(FIELD_ACTIONHOLDER, (Object)pSDEDataExpBase.getActionHolder());
        }
        if (pSDEDataExpBase.isCodeNameDirty() && (bl || pSDEDataExpBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDEDataExpBase.getCodeName());
        }
        if (pSDEDataExpBase.isContentTypeDirty() && (bl || pSDEDataExpBase.getContentType() != null)) {
            iDataObject.set(FIELD_CONTENTTYPE, (Object)pSDEDataExpBase.getContentType());
        }
        if (pSDEDataExpBase.isCreateDateDirty() && (bl || pSDEDataExpBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEDataExpBase.getCreateDate());
        }
        if (pSDEDataExpBase.isCreateManDirty() && (bl || pSDEDataExpBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEDataExpBase.getCreateMan());
        }
        if (pSDEDataExpBase.isCustomCodeDirty() && (bl || pSDEDataExpBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSDEDataExpBase.getCustomCode());
        }
        if (pSDEDataExpBase.isCustomModeDirty() && (bl || pSDEDataExpBase.getCustomMode() != null)) {
            iDataObject.set(FIELD_CUSTOMMODE, (Object)pSDEDataExpBase.getCustomMode());
        }
        if (pSDEDataExpBase.isDataExpTypeDirty() && (bl || pSDEDataExpBase.getDataExpType() != null)) {
            iDataObject.set(FIELD_DATAEXPTYPE, (Object)pSDEDataExpBase.getDataExpType());
        }
        if (pSDEDataExpBase.isDefaultFlagDirty() && (bl || pSDEDataExpBase.getDefaultFlag() != null)) {
            iDataObject.set(FIELD_DEFAULTFLAG, (Object)pSDEDataExpBase.getDefaultFlag());
        }
        if (pSDEDataExpBase.isDynaModelFlagDirty() && (bl || pSDEDataExpBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSDEDataExpBase.getDynaModelFlag());
        }
        if (pSDEDataExpBase.isEnableCustomizedDirty() && (bl || pSDEDataExpBase.getEnableCustomized() != null)) {
            iDataObject.set(FIELD_ENABLECUSTOMIZED, (Object)pSDEDataExpBase.getEnableCustomized());
        }
        if (pSDEDataExpBase.isExpParamsDirty() && (bl || pSDEDataExpBase.getExpParams() != null)) {
            iDataObject.set(FIELD_EXPPARAMS, (Object)pSDEDataExpBase.getExpParams());
        }
        if (pSDEDataExpBase.isExpTagDirty() && (bl || pSDEDataExpBase.getExpTag() != null)) {
            iDataObject.set(FIELD_EXPTAG, (Object)pSDEDataExpBase.getExpTag());
        }
        if (pSDEDataExpBase.isExpTag2Dirty() && (bl || pSDEDataExpBase.getExpTag2() != null)) {
            iDataObject.set(FIELD_EXPTAG2, (Object)pSDEDataExpBase.getExpTag2());
        }
        if (pSDEDataExpBase.isExtendModeDirty() && (bl || pSDEDataExpBase.getExtendMode() != null)) {
            iDataObject.set(FIELD_EXTENDMODE, (Object)pSDEDataExpBase.getExtendMode());
        }
        if (pSDEDataExpBase.isFileNameFormatDirty() && (bl || pSDEDataExpBase.getFileNameFormat() != null)) {
            iDataObject.set(FIELD_FILENAMEFORMAT, (Object)pSDEDataExpBase.getFileNameFormat());
        }
        if (pSDEDataExpBase.isLockFlagDirty() && (bl || pSDEDataExpBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSDEDataExpBase.getLockFlag());
        }
        if (pSDEDataExpBase.isMaxRowCntDirty() && (bl || pSDEDataExpBase.getMaxRowCnt() != null)) {
            iDataObject.set(FIELD_MAXROWCNT, (Object)pSDEDataExpBase.getMaxRowCnt());
        }
        if (pSDEDataExpBase.isMemoDirty() && (bl || pSDEDataExpBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEDataExpBase.getMemo());
        }
        if (pSDEDataExpBase.isPOTimeDirty() && (bl || pSDEDataExpBase.getPOTime() != null)) {
            iDataObject.set(FIELD_POTIME, (Object)pSDEDataExpBase.getPOTime());
        }
        if (pSDEDataExpBase.isPSDEDataExpIdDirty() && (bl || pSDEDataExpBase.getPSDEDataExpId() != null)) {
            iDataObject.set(FIELD_PSDEDATAEXPID, (Object)pSDEDataExpBase.getPSDEDataExpId());
        }
        if (pSDEDataExpBase.isPSDEDataExpNameDirty() && (bl || pSDEDataExpBase.getPSDEDataExpName() != null)) {
            iDataObject.set(FIELD_PSDEDATAEXPNAME, (Object)pSDEDataExpBase.getPSDEDataExpName());
        }
        if (pSDEDataExpBase.isPSDEDataSetIdDirty() && (bl || pSDEDataExpBase.getPSDEDataSetId() != null)) {
            iDataObject.set(FIELD_PSDEDATASETID, (Object)pSDEDataExpBase.getPSDEDataSetId());
        }
        if (pSDEDataExpBase.isPSDEDataSetNameDirty() && (bl || pSDEDataExpBase.getPSDEDataSetName() != null)) {
            iDataObject.set(FIELD_PSDEDATASETNAME, (Object)pSDEDataExpBase.getPSDEDataSetName());
        }
        if (pSDEDataExpBase.isPSDEGridIdDirty() && (bl || pSDEDataExpBase.getPSDEGridId() != null)) {
            iDataObject.set(FIELD_PSDEGRIDID, (Object)pSDEDataExpBase.getPSDEGridId());
        }
        if (pSDEDataExpBase.isPSDEGridNameDirty() && (bl || pSDEDataExpBase.getPSDEGridName() != null)) {
            iDataObject.set(FIELD_PSDEGRIDNAME, (Object)pSDEDataExpBase.getPSDEGridName());
        }
        if (pSDEDataExpBase.isPSDEIdDirty() && (bl || pSDEDataExpBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEDataExpBase.getPSDEId());
        }
        if (pSDEDataExpBase.isPSDENameDirty() && (bl || pSDEDataExpBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDEDataExpBase.getPSDEName());
        }
        if (pSDEDataExpBase.isPSDynaInstIdDirty() && (bl || pSDEDataExpBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSDEDataExpBase.getPSDynaInstId());
        }
        if (pSDEDataExpBase.isPSSysPFPluginIdDirty() && (bl || pSDEDataExpBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSDEDataExpBase.getPSSysPFPluginId());
        }
        if (pSDEDataExpBase.isPSSysPFPluginNameDirty() && (bl || pSDEDataExpBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSDEDataExpBase.getPSSysPFPluginName());
        }
        if (pSDEDataExpBase.isPSSysReqItemIdDirty() && (bl || pSDEDataExpBase.getPSSysReqItemId() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMID, (Object)pSDEDataExpBase.getPSSysReqItemId());
        }
        if (pSDEDataExpBase.isPSSysReqItemNameDirty() && (bl || pSDEDataExpBase.getPSSysReqItemName() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMNAME, (Object)pSDEDataExpBase.getPSSysReqItemName());
        }
        if (pSDEDataExpBase.isPSSysSFPluginIdDirty() && (bl || pSDEDataExpBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSDEDataExpBase.getPSSysSFPluginId());
        }
        if (pSDEDataExpBase.isPSSysSFPluginNameDirty() && (bl || pSDEDataExpBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSDEDataExpBase.getPSSysSFPluginName());
        }
        if (pSDEDataExpBase.isToDoTaskDirty() && (bl || pSDEDataExpBase.getToDoTask() != null)) {
            iDataObject.set(FIELD_TODOTASK, (Object)pSDEDataExpBase.getToDoTask());
        }
        if (pSDEDataExpBase.isUpdateDateDirty() && (bl || pSDEDataExpBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEDataExpBase.getUpdateDate());
        }
        if (pSDEDataExpBase.isUpdateManDirty() && (bl || pSDEDataExpBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEDataExpBase.getUpdateMan());
        }
        if (pSDEDataExpBase.isUserCatDirty() && (bl || pSDEDataExpBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEDataExpBase.getUserCat());
        }
        if (pSDEDataExpBase.isUserTagDirty() && (bl || pSDEDataExpBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEDataExpBase.getUserTag());
        }
        if (pSDEDataExpBase.isUserTag2Dirty() && (bl || pSDEDataExpBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEDataExpBase.getUserTag2());
        }
        if (pSDEDataExpBase.isUserTag3Dirty() && (bl || pSDEDataExpBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEDataExpBase.getUserTag3());
        }
        if (pSDEDataExpBase.isUserTag4Dirty() && (bl || pSDEDataExpBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEDataExpBase.getUserTag4());
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
        return PSDEDataExpBase.remove(this, n);
    }

    private static boolean remove(PSDEDataExpBase pSDEDataExpBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEDataExpBase.resetActionHolder();
                return true;
            }
            case 1: {
                pSDEDataExpBase.resetCodeName();
                return true;
            }
            case 2: {
                pSDEDataExpBase.resetContentType();
                return true;
            }
            case 3: {
                pSDEDataExpBase.resetCreateDate();
                return true;
            }
            case 4: {
                pSDEDataExpBase.resetCreateMan();
                return true;
            }
            case 5: {
                pSDEDataExpBase.resetCustomCode();
                return true;
            }
            case 6: {
                pSDEDataExpBase.resetCustomMode();
                return true;
            }
            case 7: {
                pSDEDataExpBase.resetDataExpType();
                return true;
            }
            case 8: {
                pSDEDataExpBase.resetDefaultFlag();
                return true;
            }
            case 9: {
                pSDEDataExpBase.resetDynaModelFlag();
                return true;
            }
            case 10: {
                pSDEDataExpBase.resetEnableCustomized();
                return true;
            }
            case 11: {
                pSDEDataExpBase.resetExpParams();
                return true;
            }
            case 12: {
                pSDEDataExpBase.resetExpTag();
                return true;
            }
            case 13: {
                pSDEDataExpBase.resetExpTag2();
                return true;
            }
            case 14: {
                pSDEDataExpBase.resetExtendMode();
                return true;
            }
            case 15: {
                pSDEDataExpBase.resetFileNameFormat();
                return true;
            }
            case 16: {
                pSDEDataExpBase.resetLockFlag();
                return true;
            }
            case 17: {
                pSDEDataExpBase.resetMaxRowCnt();
                return true;
            }
            case 18: {
                pSDEDataExpBase.resetMemo();
                return true;
            }
            case 19: {
                pSDEDataExpBase.resetPOTime();
                return true;
            }
            case 20: {
                pSDEDataExpBase.resetPSDEDataExpId();
                return true;
            }
            case 21: {
                pSDEDataExpBase.resetPSDEDataExpName();
                return true;
            }
            case 22: {
                pSDEDataExpBase.resetPSDEDataSetId();
                return true;
            }
            case 23: {
                pSDEDataExpBase.resetPSDEDataSetName();
                return true;
            }
            case 24: {
                pSDEDataExpBase.resetPSDEGridId();
                return true;
            }
            case 25: {
                pSDEDataExpBase.resetPSDEGridName();
                return true;
            }
            case 26: {
                pSDEDataExpBase.resetPSDEId();
                return true;
            }
            case 27: {
                pSDEDataExpBase.resetPSDEName();
                return true;
            }
            case 28: {
                pSDEDataExpBase.resetPSDynaInstId();
                return true;
            }
            case 29: {
                pSDEDataExpBase.resetPSSysPFPluginId();
                return true;
            }
            case 30: {
                pSDEDataExpBase.resetPSSysPFPluginName();
                return true;
            }
            case 31: {
                pSDEDataExpBase.resetPSSysReqItemId();
                return true;
            }
            case 32: {
                pSDEDataExpBase.resetPSSysReqItemName();
                return true;
            }
            case 33: {
                pSDEDataExpBase.resetPSSysSFPluginId();
                return true;
            }
            case 34: {
                pSDEDataExpBase.resetPSSysSFPluginName();
                return true;
            }
            case 35: {
                pSDEDataExpBase.resetToDoTask();
                return true;
            }
            case 36: {
                pSDEDataExpBase.resetUpdateDate();
                return true;
            }
            case 37: {
                pSDEDataExpBase.resetUpdateMan();
                return true;
            }
            case 38: {
                pSDEDataExpBase.resetUserCat();
                return true;
            }
            case 39: {
                pSDEDataExpBase.resetUserTag();
                return true;
            }
            case 40: {
                pSDEDataExpBase.resetUserTag2();
                return true;
            }
            case 41: {
                pSDEDataExpBase.resetUserTag3();
                return true;
            }
            case 42: {
                pSDEDataExpBase.resetUserTag4();
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
    public PSDEDataSet getPSDEDataSet() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataSet();
        }
        if (this.getPSDEDataSetId() == null) {
            return null;
        }
        Integer n = this.objPSDEDataSetLock;
        synchronized (n) {
            if (this.psdedataset != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEDataSetId(), (Object)this.psdedataset.getPSDEDataSetId()) != 0L) {
                this.psdedataset = null;
            }
            if (this.psdedataset == null) {
                PSDEDataSet pSDEDataSet = new PSDEDataSet();
                pSDEDataSet.setPSDEDataSetId(this.getPSDEDataSetId());
                PSDEDataSetService pSDEDataSetService = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataSetService.autoGet(pSDEDataSet);
                this.psdedataset = pSDEDataSet;
            }
            return this.psdedataset;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEGrid getPSDEGrid() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGrid();
        }
        if (this.getPSDEGridId() == null) {
            return null;
        }
        Integer n = this.objPSDEGridLock;
        synchronized (n) {
            if (this.psdegrid != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEGridId(), (Object)this.psdegrid.getPSDEGridId()) != 0L) {
                this.psdegrid = null;
            }
            if (this.psdegrid == null) {
                PSDEGrid pSDEGrid = new PSDEGrid();
                pSDEGrid.setPSDEGridId(this.getPSDEGridId());
                PSDEGridService pSDEGridService = (PSDEGridService)ServiceGlobal.getService(PSDEGridService.class, (SessionFactory)this.getSessionFactory());
                pSDEGridService.autoGet(pSDEGrid);
                this.psdegrid = pSDEGrid;
            }
            return this.psdegrid;
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
                pSSysSFPluginService.autoGet(pSSysSFPlugin);
                this.pssyssfplugin = pSSysSFPlugin;
            }
            return this.pssyssfplugin;
        }
    }

    private PSDEDataExpBase getProxyEntity() {
        return this.proxyPSDEDataExpBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEDataExpBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEDataExpBase) {
            this.proxyPSDEDataExpBase = (PSDEDataExpBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataExpService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ACTIONHOLDER, 0);
        fieldIndexMap.put(FIELD_CODENAME, 1);
        fieldIndexMap.put(FIELD_CONTENTTYPE, 2);
        fieldIndexMap.put(FIELD_CREATEDATE, 3);
        fieldIndexMap.put(FIELD_CREATEMAN, 4);
        fieldIndexMap.put(FIELD_CUSTOMCODE, 5);
        fieldIndexMap.put(FIELD_CUSTOMMODE, 6);
        fieldIndexMap.put(FIELD_DATAEXPTYPE, 7);
        fieldIndexMap.put(FIELD_DEFAULTFLAG, 8);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 9);
        fieldIndexMap.put(FIELD_ENABLECUSTOMIZED, 10);
        fieldIndexMap.put(FIELD_EXPPARAMS, 11);
        fieldIndexMap.put(FIELD_EXPTAG, 12);
        fieldIndexMap.put(FIELD_EXPTAG2, 13);
        fieldIndexMap.put(FIELD_EXTENDMODE, 14);
        fieldIndexMap.put(FIELD_FILENAMEFORMAT, 15);
        fieldIndexMap.put(FIELD_LOCKFLAG, 16);
        fieldIndexMap.put(FIELD_MAXROWCNT, 17);
        fieldIndexMap.put(FIELD_MEMO, 18);
        fieldIndexMap.put(FIELD_POTIME, 19);
        fieldIndexMap.put(FIELD_PSDEDATAEXPID, 20);
        fieldIndexMap.put(FIELD_PSDEDATAEXPNAME, 21);
        fieldIndexMap.put(FIELD_PSDEDATASETID, 22);
        fieldIndexMap.put(FIELD_PSDEDATASETNAME, 23);
        fieldIndexMap.put(FIELD_PSDEGRIDID, 24);
        fieldIndexMap.put(FIELD_PSDEGRIDNAME, 25);
        fieldIndexMap.put(FIELD_PSDEID, 26);
        fieldIndexMap.put(FIELD_PSDENAME, 27);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 28);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINID, 29);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINNAME, 30);
        fieldIndexMap.put(FIELD_PSSYSREQITEMID, 31);
        fieldIndexMap.put(FIELD_PSSYSREQITEMNAME, 32);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 33);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 34);
        fieldIndexMap.put(FIELD_TODOTASK, 35);
        fieldIndexMap.put(FIELD_UPDATEDATE, 36);
        fieldIndexMap.put(FIELD_UPDATEMAN, 37);
        fieldIndexMap.put(FIELD_USERCAT, 38);
        fieldIndexMap.put(FIELD_USERTAG, 39);
        fieldIndexMap.put(FIELD_USERTAG2, 40);
        fieldIndexMap.put(FIELD_USERTAG3, 41);
        fieldIndexMap.put(FIELD_USERTAG4, 42);
    }
}

