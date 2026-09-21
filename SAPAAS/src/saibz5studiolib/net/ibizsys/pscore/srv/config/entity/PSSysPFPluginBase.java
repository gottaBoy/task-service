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
package net.ibizsys.pscore.srv.config.entity;

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
import net.ibizsys.pscore.srv.config.entity.PSPFPlugin;
import net.ibizsys.pscore.srv.config.service.PSPFPluginService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysPFPITempl;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysPFPITemplService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysPFPluginBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysPFPluginBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_EXTENDSTYLEONLY = "EXTENDSTYLEONLY";
    public static final String FIELD_KEYWORDS = "KEYWORDS";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PLUGINDESC = "PLUGINDESC";
    public static final String FIELD_PLUGINMODEL = "PLUGINMODEL";
    public static final String FIELD_PLUGINPARAMS = "PLUGINPARAMS";
    public static final String FIELD_PLUGINTAG = "PLUGINTAG";
    public static final String FIELD_PLUGINTAG2 = "PLUGINTAG2";
    public static final String FIELD_PLUGINTYPE = "PLUGINTYPE";
    public static final String FIELD_PREVIEWHTML = "PREVIEWHTML";
    public static final String FIELD_PREVIEWPSNDFILEID = "PREVIEWPSNDFILEID";
    public static final String FIELD_PREVIEWURL = "PREVIEWURL";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSPFPLUGINID = "PSPFPLUGINID";
    public static final String FIELD_PSPFPLUGINNAME = "PSPFPLUGINNAME";
    public static final String FIELD_PSSYSFILEID = "PSSYSFILEID";
    public static final String FIELD_PSSYSPFPITEMPLSCNT = "PSSYSPFPITEMPLSCNT";
    public static final String FIELD_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String FIELD_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_REPDEFAULT = "REPDEFAULT";
    public static final String FIELD_RTOBJECTMODE = "RTOBJECTMODE";
    public static final String FIELD_RTOBJECTNAME = "RTOBJECTNAME";
    public static final String FIELD_RTOBJECTREPO = "RTOBJECTREPO";
    public static final String FIELD_STUDIOICON = "STUDIOICON";
    public static final String FIELD_TEMPALTEFUNC = "TEMPLATEFUNC";
    public static final String FIELD_TEMPLATEMODE = "TEMPLATEMODE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_DYNAMODELFLAG = 3;
    private static final int INDEX_EXTENDSTYLEONLY = 4;
    private static final int INDEX_KEYWORDS = 5;
    private static final int INDEX_LOCKFLAG = 6;
    private static final int INDEX_MEMO = 7;
    private static final int INDEX_ORDERVALUE = 8;
    private static final int INDEX_PLUGINDESC = 9;
    private static final int INDEX_PLUGINMODEL = 10;
    private static final int INDEX_PLUGINPARAMS = 11;
    private static final int INDEX_PLUGINTAG = 12;
    private static final int INDEX_PLUGINTAG2 = 13;
    private static final int INDEX_PLUGINTYPE = 14;
    private static final int INDEX_PREVIEWHTML = 15;
    private static final int INDEX_PREVIEWPSNDFILEID = 16;
    private static final int INDEX_PREVIEWURL = 17;
    private static final int INDEX_PSDYNAINSTID = 18;
    private static final int INDEX_PSMODULEID = 19;
    private static final int INDEX_PSMODULENAME = 20;
    private static final int INDEX_PSPFPLUGINID = 21;
    private static final int INDEX_PSPFPLUGINNAME = 22;
    private static final int INDEX_PSSYSFILEID = 23;
    private static final int INDEX_PSSYSPFPITEMPLSCNT = 24;
    private static final int INDEX_PSSYSPFPLUGINID = 25;
    private static final int INDEX_PSSYSPFPLUGINNAME = 26;
    private static final int INDEX_PSSYSTEMID = 27;
    private static final int INDEX_PSSYSTEMNAME = 28;
    private static final int INDEX_REPDEFAULT = 29;
    private static final int INDEX_RTOBJECTMODE = 30;
    private static final int INDEX_RTOBJECTNAME = 31;
    private static final int INDEX_RTOBJECTREPO = 32;
    private static final int INDEX_STUDIOICON = 33;
    private static final int INDEX_TEMPALTEFUNC = 34;
    private static final int INDEX_TEMPLATEMODE = 35;
    private static final int INDEX_UPDATEDATE = 36;
    private static final int INDEX_UPDATEMAN = 37;
    private static final int INDEX_USERCAT = 38;
    private static final int INDEX_USERTAG = 39;
    private static final int INDEX_USERTAG2 = 40;
    private static final int INDEX_USERTAG3 = 41;
    private static final int INDEX_USERTAG4 = 42;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysPFPluginBase proxyPSSysPFPluginBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean extendstyleonlyDirtyFlag = false;
    private boolean keywordsDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean plugindescDirtyFlag = false;
    private boolean pluginmodelDirtyFlag = false;
    private boolean pluginparamsDirtyFlag = false;
    private boolean plugintagDirtyFlag = false;
    private boolean plugintag2DirtyFlag = false;
    private boolean plugintypeDirtyFlag = false;
    private boolean previewhtmlDirtyFlag = false;
    private boolean previewpsndfileidDirtyFlag = false;
    private boolean previewurlDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pspfpluginidDirtyFlag = false;
    private boolean pspfpluginnameDirtyFlag = false;
    private boolean pssysfileidDirtyFlag = false;
    private boolean pssyspfpitemplscntDirtyFlag = false;
    private boolean pssyspfpluginidDirtyFlag = false;
    private boolean pssyspfpluginnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean repdefaultDirtyFlag = false;
    private boolean rtobjectmodeDirtyFlag = false;
    private boolean rtobjectnameDirtyFlag = false;
    private boolean rtobjectrepoDirtyFlag = false;
    private boolean studioiconDirtyFlag = false;
    private boolean tempaltefuncDirtyFlag = false;
    private boolean templatemodeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="extendstyleonly")
    private Integer extendstyleonly;
    @Column(name="keywords")
    private String keywords;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="plugindesc")
    private String plugindesc;
    @Column(name="pluginmodel")
    private String pluginmodel;
    @Column(name="pluginparams")
    private String pluginparams;
    @Column(name="plugintag")
    private String plugintag;
    @Column(name="plugintag2")
    private String plugintag2;
    @Column(name="plugintype")
    private String plugintype;
    @Column(name="previewhtml")
    private String previewhtml;
    @Column(name="previewpsndfileid")
    private String previewpsndfileid;
    @Column(name="previewurl")
    private String previewurl;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pspfpluginid")
    private String pspfpluginid;
    @Column(name="pspfpluginname")
    private String pspfpluginname;
    @Column(name="pssysfileid")
    private String pssysfileid;
    @Column(name="pssyspfpitemplscnt")
    private Integer pssyspfpitemplscnt;
    @Column(name="pssyspfpluginid")
    private String pssyspfpluginid;
    @Column(name="pssyspfpluginname")
    private String pssyspfpluginname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="repdefault")
    private Integer repdefault;
    @Column(name="rtobjectmode")
    private Integer rtobjectmode;
    @Column(name="rtobjectname")
    private String rtobjectname;
    @Column(name="rtobjectrepo")
    private String rtobjectrepo;
    @Column(name="studioicon")
    private String studioicon;
    @Column(name="tempaltefunc")
    private String tempaltefunc;
    @Column(name="templatemode")
    private Integer templatemode;
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
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objPSPFPluginLock = new Integer(1);
    private PSPFPlugin pspfplugin = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSSysPFPITemplsLock = new Integer(1);
    private ArrayList<PSSysPFPITempl> pssyspfpitempls = null;

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

    public void setExtendStyleOnly(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExtendStyleOnly(n);
            return;
        }
        this.extendstyleonly = n;
        this.extendstyleonlyDirtyFlag = true;
    }

    public Integer getExtendStyleOnly() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExtendStyleOnly();
        }
        return this.extendstyleonly;
    }

    public boolean isExtendStyleOnlyDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExtendStyleOnlyDirty();
        }
        return this.extendstyleonlyDirtyFlag;
    }

    public void resetExtendStyleOnly() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExtendStyleOnly();
            return;
        }
        this.extendstyleonlyDirtyFlag = false;
        this.extendstyleonly = null;
    }

    public void setKeywords(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setKeywords(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.keywords = string;
        this.keywordsDirtyFlag = true;
    }

    public String getKeywords() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getKeywords();
        }
        return this.keywords;
    }

    public boolean isKeywordsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isKeywordsDirty();
        }
        return this.keywordsDirtyFlag;
    }

    public void resetKeywords() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetKeywords();
            return;
        }
        this.keywordsDirtyFlag = false;
        this.keywords = null;
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

    public void setPluginDesc(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPluginDesc(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.plugindesc = string;
        this.plugindescDirtyFlag = true;
    }

    public String getPluginDesc() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPluginDesc();
        }
        return this.plugindesc;
    }

    public boolean isPluginDescDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPluginDescDirty();
        }
        return this.plugindescDirtyFlag;
    }

    public void resetPluginDesc() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPluginDesc();
            return;
        }
        this.plugindescDirtyFlag = false;
        this.plugindesc = null;
    }

    public void setPluginModel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPluginModel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pluginmodel = string;
        this.pluginmodelDirtyFlag = true;
    }

    public String getPluginModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPluginModel();
        }
        return this.pluginmodel;
    }

    public boolean isPluginModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPluginModelDirty();
        }
        return this.pluginmodelDirtyFlag;
    }

    public void resetPluginModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPluginModel();
            return;
        }
        this.pluginmodelDirtyFlag = false;
        this.pluginmodel = null;
    }

    public void setPluginParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPluginParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pluginparams = string;
        this.pluginparamsDirtyFlag = true;
    }

    public String getPluginParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPluginParams();
        }
        return this.pluginparams;
    }

    public boolean isPluginParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPluginParamsDirty();
        }
        return this.pluginparamsDirtyFlag;
    }

    public void resetPluginParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPluginParams();
            return;
        }
        this.pluginparamsDirtyFlag = false;
        this.pluginparams = null;
    }

    public void setPluginTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPluginTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.plugintag = string;
        this.plugintagDirtyFlag = true;
    }

    public String getPluginTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPluginTag();
        }
        return this.plugintag;
    }

    public boolean isPluginTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPluginTagDirty();
        }
        return this.plugintagDirtyFlag;
    }

    public void resetPluginTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPluginTag();
            return;
        }
        this.plugintagDirtyFlag = false;
        this.plugintag = null;
    }

    public void setPluginTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPluginTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.plugintag2 = string;
        this.plugintag2DirtyFlag = true;
    }

    public String getPluginTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPluginTag2();
        }
        return this.plugintag2;
    }

    public boolean isPluginTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPluginTag2Dirty();
        }
        return this.plugintag2DirtyFlag;
    }

    public void resetPluginTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPluginTag2();
            return;
        }
        this.plugintag2DirtyFlag = false;
        this.plugintag2 = null;
    }

    public void setPluginType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPluginType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.plugintype = string;
        this.plugintypeDirtyFlag = true;
    }

    public String getPluginType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPluginType();
        }
        return this.plugintype;
    }

    public boolean isPluginTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPluginTypeDirty();
        }
        return this.plugintypeDirtyFlag;
    }

    public void resetPluginType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPluginType();
            return;
        }
        this.plugintypeDirtyFlag = false;
        this.plugintype = null;
    }

    public void setPreviewHtml(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPreviewHtml(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.previewhtml = string;
        this.previewhtmlDirtyFlag = true;
    }

    public String getPreviewHtml() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPreviewHtml();
        }
        return this.previewhtml;
    }

    public boolean isPreviewHtmlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPreviewHtmlDirty();
        }
        return this.previewhtmlDirtyFlag;
    }

    public void resetPreviewHtml() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPreviewHtml();
            return;
        }
        this.previewhtmlDirtyFlag = false;
        this.previewhtml = null;
    }

    public void setPreviewPSNDFileId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPreviewPSNDFileId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.previewpsndfileid = string;
        this.previewpsndfileidDirtyFlag = true;
    }

    public String getPreviewPSNDFileId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPreviewPSNDFileId();
        }
        return this.previewpsndfileid;
    }

    public boolean isPreviewPSNDFileIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPreviewPSNDFileIdDirty();
        }
        return this.previewpsndfileidDirtyFlag;
    }

    public void resetPreviewPSNDFileId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPreviewPSNDFileId();
            return;
        }
        this.previewpsndfileidDirtyFlag = false;
        this.previewpsndfileid = null;
    }

    public void setPreviewUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPreviewUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.previewurl = string;
        this.previewurlDirtyFlag = true;
    }

    public String getPreviewUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPreviewUrl();
        }
        return this.previewurl;
    }

    public boolean isPreviewUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPreviewUrlDirty();
        }
        return this.previewurlDirtyFlag;
    }

    public void resetPreviewUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPreviewUrl();
            return;
        }
        this.previewurlDirtyFlag = false;
        this.previewurl = null;
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

    public void setPSModuleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModuleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmoduleid = string;
        this.psmoduleidDirtyFlag = true;
    }

    public String getPSModuleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModuleId();
        }
        return this.psmoduleid;
    }

    public boolean isPSModuleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModuleIdDirty();
        }
        return this.psmoduleidDirtyFlag;
    }

    public void resetPSModuleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModuleId();
            return;
        }
        this.psmoduleidDirtyFlag = false;
        this.psmoduleid = null;
    }

    public void setPSModuleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModuleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodulename = string;
        this.psmodulenameDirtyFlag = true;
    }

    public String getPSModuleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModuleName();
        }
        return this.psmodulename;
    }

    public boolean isPSModuleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModuleNameDirty();
        }
        return this.psmodulenameDirtyFlag;
    }

    public void resetPSModuleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModuleName();
            return;
        }
        this.psmodulenameDirtyFlag = false;
        this.psmodulename = null;
    }

    public void setPSPFPluginId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFPluginId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfpluginid = string;
        this.pspfpluginidDirtyFlag = true;
    }

    public String getPSPFPluginId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFPluginId();
        }
        return this.pspfpluginid;
    }

    public boolean isPSPFPluginIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFPluginIdDirty();
        }
        return this.pspfpluginidDirtyFlag;
    }

    public void resetPSPFPluginId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFPluginId();
            return;
        }
        this.pspfpluginidDirtyFlag = false;
        this.pspfpluginid = null;
    }

    public void setPSPFPluginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFPluginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfpluginname = string;
        this.pspfpluginnameDirtyFlag = true;
    }

    public String getPSPFPluginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFPluginName();
        }
        return this.pspfpluginname;
    }

    public boolean isPSPFPluginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFPluginNameDirty();
        }
        return this.pspfpluginnameDirtyFlag;
    }

    public void resetPSPFPluginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFPluginName();
            return;
        }
        this.pspfpluginnameDirtyFlag = false;
        this.pspfpluginname = null;
    }

    public void setPSSysFileId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysFileId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysfileid = string;
        this.pssysfileidDirtyFlag = true;
    }

    public String getPSSysFileId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysFileId();
        }
        return this.pssysfileid;
    }

    public boolean isPSSysFileIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysFileIdDirty();
        }
        return this.pssysfileidDirtyFlag;
    }

    public void resetPSSysFileId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysFileId();
            return;
        }
        this.pssysfileidDirtyFlag = false;
        this.pssysfileid = null;
    }

    public void setPSSysPFPITemplsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysPFPITemplsCnt(n);
            return;
        }
        this.pssyspfpitemplscnt = n;
        this.pssyspfpitemplscntDirtyFlag = true;
    }

    public Integer getPSSysPFPITemplsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPFPITemplsCnt();
        }
        return this.pssyspfpitemplscnt;
    }

    public boolean isPSSysPFPITemplsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysPFPITemplsCntDirty();
        }
        return this.pssyspfpitemplscntDirtyFlag;
    }

    public void resetPSSysPFPITemplsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysPFPITemplsCnt();
            return;
        }
        this.pssyspfpitemplscntDirtyFlag = false;
        this.pssyspfpitemplscnt = null;
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

    public void setPSSystemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemname = string;
        this.pssystemnameDirtyFlag = true;
    }

    public String getPSSystemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemName();
        }
        return this.pssystemname;
    }

    public boolean isPSSystemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemNameDirty();
        }
        return this.pssystemnameDirtyFlag;
    }

    public void resetPSSystemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemName();
            return;
        }
        this.pssystemnameDirtyFlag = false;
        this.pssystemname = null;
    }

    public void setRepDefault(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRepDefault(n);
            return;
        }
        this.repdefault = n;
        this.repdefaultDirtyFlag = true;
    }

    public Integer getRepDefault() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRepDefault();
        }
        return this.repdefault;
    }

    public boolean isRepDefaultDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRepDefaultDirty();
        }
        return this.repdefaultDirtyFlag;
    }

    public void resetRepDefault() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRepDefault();
            return;
        }
        this.repdefaultDirtyFlag = false;
        this.repdefault = null;
    }

    public void setRTObjectMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRTObjectMode(n);
            return;
        }
        this.rtobjectmode = n;
        this.rtobjectmodeDirtyFlag = true;
    }

    public Integer getRTObjectMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRTObjectMode();
        }
        return this.rtobjectmode;
    }

    public boolean isRTObjectModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRTObjectModeDirty();
        }
        return this.rtobjectmodeDirtyFlag;
    }

    public void resetRTObjectMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRTObjectMode();
            return;
        }
        this.rtobjectmodeDirtyFlag = false;
        this.rtobjectmode = null;
    }

    public void setRTObjectName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRTObjectName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.rtobjectname = string;
        this.rtobjectnameDirtyFlag = true;
    }

    public String getRTObjectName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRTObjectName();
        }
        return this.rtobjectname;
    }

    public boolean isRTObjectNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRTObjectNameDirty();
        }
        return this.rtobjectnameDirtyFlag;
    }

    public void resetRTObjectName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRTObjectName();
            return;
        }
        this.rtobjectnameDirtyFlag = false;
        this.rtobjectname = null;
    }

    public void setRTObjectRepo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRTObjectRepo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.rtobjectrepo = string;
        this.rtobjectrepoDirtyFlag = true;
    }

    public String getRTObjectRepo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRTObjectRepo();
        }
        return this.rtobjectrepo;
    }

    public boolean isRTObjectRepoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRTObjectRepoDirty();
        }
        return this.rtobjectrepoDirtyFlag;
    }

    public void resetRTObjectRepo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRTObjectRepo();
            return;
        }
        this.rtobjectrepoDirtyFlag = false;
        this.rtobjectrepo = null;
    }

    public void setStudioIcon(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStudioIcon(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.studioicon = string;
        this.studioiconDirtyFlag = true;
    }

    public String getStudioIcon() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStudioIcon();
        }
        return this.studioicon;
    }

    public boolean isStudioIconDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStudioIconDirty();
        }
        return this.studioiconDirtyFlag;
    }

    public void resetStudioIcon() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStudioIcon();
            return;
        }
        this.studioiconDirtyFlag = false;
        this.studioicon = null;
    }

    public void setTempalteFunc(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTempalteFunc(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tempaltefunc = string;
        this.tempaltefuncDirtyFlag = true;
    }

    public String getTempalteFunc() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTempalteFunc();
        }
        return this.tempaltefunc;
    }

    public boolean isTempalteFuncDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTempalteFuncDirty();
        }
        return this.tempaltefuncDirtyFlag;
    }

    public void resetTempalteFunc() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTempalteFunc();
            return;
        }
        this.tempaltefuncDirtyFlag = false;
        this.tempaltefunc = null;
    }

    public void setTemplateMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplateMode(n);
            return;
        }
        this.templatemode = n;
        this.templatemodeDirtyFlag = true;
    }

    public Integer getTemplateMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplateMode();
        }
        return this.templatemode;
    }

    public boolean isTemplateModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplateModeDirty();
        }
        return this.templatemodeDirtyFlag;
    }

    public void resetTemplateMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplateMode();
            return;
        }
        this.templatemodeDirtyFlag = false;
        this.templatemode = null;
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
        PSSysPFPluginBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysPFPluginBase pSSysPFPluginBase) {
        pSSysPFPluginBase.resetCodeName();
        pSSysPFPluginBase.resetCreateDate();
        pSSysPFPluginBase.resetCreateMan();
        pSSysPFPluginBase.resetDynaModelFlag();
        pSSysPFPluginBase.resetExtendStyleOnly();
        pSSysPFPluginBase.resetKeywords();
        pSSysPFPluginBase.resetLockFlag();
        pSSysPFPluginBase.resetMemo();
        pSSysPFPluginBase.resetOrderValue();
        pSSysPFPluginBase.resetPluginDesc();
        pSSysPFPluginBase.resetPluginModel();
        pSSysPFPluginBase.resetPluginParams();
        pSSysPFPluginBase.resetPluginTag();
        pSSysPFPluginBase.resetPluginTag2();
        pSSysPFPluginBase.resetPluginType();
        pSSysPFPluginBase.resetPreviewHtml();
        pSSysPFPluginBase.resetPreviewPSNDFileId();
        pSSysPFPluginBase.resetPreviewUrl();
        pSSysPFPluginBase.resetPSDynaInstId();
        pSSysPFPluginBase.resetPSModuleId();
        pSSysPFPluginBase.resetPSModuleName();
        pSSysPFPluginBase.resetPSPFPluginId();
        pSSysPFPluginBase.resetPSPFPluginName();
        pSSysPFPluginBase.resetPSSysFileId();
        pSSysPFPluginBase.resetPSSysPFPITemplsCnt();
        pSSysPFPluginBase.resetPSSysPFPluginId();
        pSSysPFPluginBase.resetPSSysPFPluginName();
        pSSysPFPluginBase.resetPSSystemId();
        pSSysPFPluginBase.resetPSSystemName();
        pSSysPFPluginBase.resetRepDefault();
        pSSysPFPluginBase.resetRTObjectMode();
        pSSysPFPluginBase.resetRTObjectName();
        pSSysPFPluginBase.resetRTObjectRepo();
        pSSysPFPluginBase.resetStudioIcon();
        pSSysPFPluginBase.resetTempalteFunc();
        pSSysPFPluginBase.resetTemplateMode();
        pSSysPFPluginBase.resetUpdateDate();
        pSSysPFPluginBase.resetUpdateMan();
        pSSysPFPluginBase.resetUserCat();
        pSSysPFPluginBase.resetUserTag();
        pSSysPFPluginBase.resetUserTag2();
        pSSysPFPluginBase.resetUserTag3();
        pSSysPFPluginBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
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
        if (!bl || this.isExtendStyleOnlyDirty()) {
            hashMap.put(FIELD_EXTENDSTYLEONLY, this.getExtendStyleOnly());
        }
        if (!bl || this.isKeywordsDirty()) {
            hashMap.put(FIELD_KEYWORDS, this.getKeywords());
        }
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPluginDescDirty()) {
            hashMap.put(FIELD_PLUGINDESC, this.getPluginDesc());
        }
        if (!bl || this.isPluginModelDirty()) {
            hashMap.put(FIELD_PLUGINMODEL, this.getPluginModel());
        }
        if (!bl || this.isPluginParamsDirty()) {
            hashMap.put(FIELD_PLUGINPARAMS, this.getPluginParams());
        }
        if (!bl || this.isPluginTagDirty()) {
            hashMap.put(FIELD_PLUGINTAG, this.getPluginTag());
        }
        if (!bl || this.isPluginTag2Dirty()) {
            hashMap.put(FIELD_PLUGINTAG2, this.getPluginTag2());
        }
        if (!bl || this.isPluginTypeDirty()) {
            hashMap.put(FIELD_PLUGINTYPE, this.getPluginType());
        }
        if (!bl || this.isPreviewHtmlDirty()) {
            hashMap.put(FIELD_PREVIEWHTML, this.getPreviewHtml());
        }
        if (!bl || this.isPreviewPSNDFileIdDirty()) {
            hashMap.put(FIELD_PREVIEWPSNDFILEID, this.getPreviewPSNDFileId());
        }
        if (!bl || this.isPreviewUrlDirty()) {
            hashMap.put(FIELD_PREVIEWURL, this.getPreviewUrl());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSModuleIdDirty()) {
            hashMap.put(FIELD_PSMODULEID, this.getPSModuleId());
        }
        if (!bl || this.isPSModuleNameDirty()) {
            hashMap.put(FIELD_PSMODULENAME, this.getPSModuleName());
        }
        if (!bl || this.isPSPFPluginIdDirty()) {
            hashMap.put(FIELD_PSPFPLUGINID, this.getPSPFPluginId());
        }
        if (!bl || this.isPSPFPluginNameDirty()) {
            hashMap.put(FIELD_PSPFPLUGINNAME, this.getPSPFPluginName());
        }
        if (!bl || this.isPSSysFileIdDirty()) {
            hashMap.put(FIELD_PSSYSFILEID, this.getPSSysFileId());
        }
        if (!bl || this.isPSSysPFPITemplsCntDirty()) {
            hashMap.put(FIELD_PSSYSPFPITEMPLSCNT, this.getPSSysPFPITemplsCnt());
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
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
        }
        if (!bl || this.isRepDefaultDirty()) {
            hashMap.put(FIELD_REPDEFAULT, this.getRepDefault());
        }
        if (!bl || this.isRTObjectModeDirty()) {
            hashMap.put(FIELD_RTOBJECTMODE, this.getRTObjectMode());
        }
        if (!bl || this.isRTObjectNameDirty()) {
            hashMap.put(FIELD_RTOBJECTNAME, this.getRTObjectName());
        }
        if (!bl || this.isRTObjectRepoDirty()) {
            hashMap.put(FIELD_RTOBJECTREPO, this.getRTObjectRepo());
        }
        if (!bl || this.isStudioIconDirty()) {
            hashMap.put(FIELD_STUDIOICON, this.getStudioIcon());
        }
        if (!bl || this.isTempalteFuncDirty()) {
            hashMap.put(FIELD_TEMPALTEFUNC, this.getTempalteFunc());
        }
        if (!bl || this.isTemplateModeDirty()) {
            hashMap.put(FIELD_TEMPLATEMODE, this.getTemplateMode());
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
        return PSSysPFPluginBase.get(this, n);
    }

    private static Object get(PSSysPFPluginBase pSSysPFPluginBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysPFPluginBase.getCodeName();
            }
            case 1: {
                return pSSysPFPluginBase.getCreateDate();
            }
            case 2: {
                return pSSysPFPluginBase.getCreateMan();
            }
            case 3: {
                return pSSysPFPluginBase.getDynaModelFlag();
            }
            case 4: {
                return pSSysPFPluginBase.getExtendStyleOnly();
            }
            case 5: {
                return pSSysPFPluginBase.getKeywords();
            }
            case 6: {
                return pSSysPFPluginBase.getLockFlag();
            }
            case 7: {
                return pSSysPFPluginBase.getMemo();
            }
            case 8: {
                return pSSysPFPluginBase.getOrderValue();
            }
            case 9: {
                return pSSysPFPluginBase.getPluginDesc();
            }
            case 10: {
                return pSSysPFPluginBase.getPluginModel();
            }
            case 11: {
                return pSSysPFPluginBase.getPluginParams();
            }
            case 12: {
                return pSSysPFPluginBase.getPluginTag();
            }
            case 13: {
                return pSSysPFPluginBase.getPluginTag2();
            }
            case 14: {
                return pSSysPFPluginBase.getPluginType();
            }
            case 15: {
                return pSSysPFPluginBase.getPreviewHtml();
            }
            case 16: {
                return pSSysPFPluginBase.getPreviewPSNDFileId();
            }
            case 17: {
                return pSSysPFPluginBase.getPreviewUrl();
            }
            case 18: {
                return pSSysPFPluginBase.getPSDynaInstId();
            }
            case 19: {
                return pSSysPFPluginBase.getPSModuleId();
            }
            case 20: {
                return pSSysPFPluginBase.getPSModuleName();
            }
            case 21: {
                return pSSysPFPluginBase.getPSPFPluginId();
            }
            case 22: {
                return pSSysPFPluginBase.getPSPFPluginName();
            }
            case 23: {
                return pSSysPFPluginBase.getPSSysFileId();
            }
            case 24: {
                return pSSysPFPluginBase.getPSSysPFPITemplsCnt();
            }
            case 25: {
                return pSSysPFPluginBase.getPSSysPFPluginId();
            }
            case 26: {
                return pSSysPFPluginBase.getPSSysPFPluginName();
            }
            case 27: {
                return pSSysPFPluginBase.getPSSystemId();
            }
            case 28: {
                return pSSysPFPluginBase.getPSSystemName();
            }
            case 29: {
                return pSSysPFPluginBase.getRepDefault();
            }
            case 30: {
                return pSSysPFPluginBase.getRTObjectMode();
            }
            case 31: {
                return pSSysPFPluginBase.getRTObjectName();
            }
            case 32: {
                return pSSysPFPluginBase.getRTObjectRepo();
            }
            case 33: {
                return pSSysPFPluginBase.getStudioIcon();
            }
            case 34: {
                return pSSysPFPluginBase.getTempalteFunc();
            }
            case 35: {
                return pSSysPFPluginBase.getTemplateMode();
            }
            case 36: {
                return pSSysPFPluginBase.getUpdateDate();
            }
            case 37: {
                return pSSysPFPluginBase.getUpdateMan();
            }
            case 38: {
                return pSSysPFPluginBase.getUserCat();
            }
            case 39: {
                return pSSysPFPluginBase.getUserTag();
            }
            case 40: {
                return pSSysPFPluginBase.getUserTag2();
            }
            case 41: {
                return pSSysPFPluginBase.getUserTag3();
            }
            case 42: {
                return pSSysPFPluginBase.getUserTag4();
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
        PSSysPFPluginBase.set(this, n, object);
    }

    private static void set(PSSysPFPluginBase pSSysPFPluginBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysPFPluginBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysPFPluginBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysPFPluginBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysPFPluginBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSSysPFPluginBase.setExtendStyleOnly(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSSysPFPluginBase.setKeywords(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysPFPluginBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSSysPFPluginBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysPFPluginBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSSysPFPluginBase.setPluginDesc(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysPFPluginBase.setPluginModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysPFPluginBase.setPluginParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysPFPluginBase.setPluginTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysPFPluginBase.setPluginTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysPFPluginBase.setPluginType(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysPFPluginBase.setPreviewHtml(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysPFPluginBase.setPreviewPSNDFileId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysPFPluginBase.setPreviewUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysPFPluginBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysPFPluginBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysPFPluginBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysPFPluginBase.setPSPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysPFPluginBase.setPSPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysPFPluginBase.setPSSysFileId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysPFPluginBase.setPSSysPFPITemplsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 25: {
                pSSysPFPluginBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysPFPluginBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysPFPluginBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysPFPluginBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSysPFPluginBase.setRepDefault(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 30: {
                pSSysPFPluginBase.setRTObjectMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 31: {
                pSSysPFPluginBase.setRTObjectName(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSysPFPluginBase.setRTObjectRepo(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSSysPFPluginBase.setStudioIcon(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSSysPFPluginBase.setTempalteFunc(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSSysPFPluginBase.setTemplateMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 36: {
                pSSysPFPluginBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 37: {
                pSSysPFPluginBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSSysPFPluginBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSSysPFPluginBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSSysPFPluginBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSSysPFPluginBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSSysPFPluginBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSSysPFPluginBase.isNull(this, n);
    }

    private static boolean isNull(PSSysPFPluginBase pSSysPFPluginBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysPFPluginBase.getCodeName() == null;
            }
            case 1: {
                return pSSysPFPluginBase.getCreateDate() == null;
            }
            case 2: {
                return pSSysPFPluginBase.getCreateMan() == null;
            }
            case 3: {
                return pSSysPFPluginBase.getDynaModelFlag() == null;
            }
            case 4: {
                return pSSysPFPluginBase.getExtendStyleOnly() == null;
            }
            case 5: {
                return pSSysPFPluginBase.getKeywords() == null;
            }
            case 6: {
                return pSSysPFPluginBase.getLockFlag() == null;
            }
            case 7: {
                return pSSysPFPluginBase.getMemo() == null;
            }
            case 8: {
                return pSSysPFPluginBase.getOrderValue() == null;
            }
            case 9: {
                return pSSysPFPluginBase.getPluginDesc() == null;
            }
            case 10: {
                return pSSysPFPluginBase.getPluginModel() == null;
            }
            case 11: {
                return pSSysPFPluginBase.getPluginParams() == null;
            }
            case 12: {
                return pSSysPFPluginBase.getPluginTag() == null;
            }
            case 13: {
                return pSSysPFPluginBase.getPluginTag2() == null;
            }
            case 14: {
                return pSSysPFPluginBase.getPluginType() == null;
            }
            case 15: {
                return pSSysPFPluginBase.getPreviewHtml() == null;
            }
            case 16: {
                return pSSysPFPluginBase.getPreviewPSNDFileId() == null;
            }
            case 17: {
                return pSSysPFPluginBase.getPreviewUrl() == null;
            }
            case 18: {
                return pSSysPFPluginBase.getPSDynaInstId() == null;
            }
            case 19: {
                return pSSysPFPluginBase.getPSModuleId() == null;
            }
            case 20: {
                return pSSysPFPluginBase.getPSModuleName() == null;
            }
            case 21: {
                return pSSysPFPluginBase.getPSPFPluginId() == null;
            }
            case 22: {
                return pSSysPFPluginBase.getPSPFPluginName() == null;
            }
            case 23: {
                return pSSysPFPluginBase.getPSSysFileId() == null;
            }
            case 24: {
                return pSSysPFPluginBase.getPSSysPFPITemplsCnt() == null;
            }
            case 25: {
                return pSSysPFPluginBase.getPSSysPFPluginId() == null;
            }
            case 26: {
                return pSSysPFPluginBase.getPSSysPFPluginName() == null;
            }
            case 27: {
                return pSSysPFPluginBase.getPSSystemId() == null;
            }
            case 28: {
                return pSSysPFPluginBase.getPSSystemName() == null;
            }
            case 29: {
                return pSSysPFPluginBase.getRepDefault() == null;
            }
            case 30: {
                return pSSysPFPluginBase.getRTObjectMode() == null;
            }
            case 31: {
                return pSSysPFPluginBase.getRTObjectName() == null;
            }
            case 32: {
                return pSSysPFPluginBase.getRTObjectRepo() == null;
            }
            case 33: {
                return pSSysPFPluginBase.getStudioIcon() == null;
            }
            case 34: {
                return pSSysPFPluginBase.getTempalteFunc() == null;
            }
            case 35: {
                return pSSysPFPluginBase.getTemplateMode() == null;
            }
            case 36: {
                return pSSysPFPluginBase.getUpdateDate() == null;
            }
            case 37: {
                return pSSysPFPluginBase.getUpdateMan() == null;
            }
            case 38: {
                return pSSysPFPluginBase.getUserCat() == null;
            }
            case 39: {
                return pSSysPFPluginBase.getUserTag() == null;
            }
            case 40: {
                return pSSysPFPluginBase.getUserTag2() == null;
            }
            case 41: {
                return pSSysPFPluginBase.getUserTag3() == null;
            }
            case 42: {
                return pSSysPFPluginBase.getUserTag4() == null;
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
        return PSSysPFPluginBase.contains(this, n);
    }

    private static boolean contains(PSSysPFPluginBase pSSysPFPluginBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysPFPluginBase.isCodeNameDirty();
            }
            case 1: {
                return pSSysPFPluginBase.isCreateDateDirty();
            }
            case 2: {
                return pSSysPFPluginBase.isCreateManDirty();
            }
            case 3: {
                return pSSysPFPluginBase.isDynaModelFlagDirty();
            }
            case 4: {
                return pSSysPFPluginBase.isExtendStyleOnlyDirty();
            }
            case 5: {
                return pSSysPFPluginBase.isKeywordsDirty();
            }
            case 6: {
                return pSSysPFPluginBase.isLockFlagDirty();
            }
            case 7: {
                return pSSysPFPluginBase.isMemoDirty();
            }
            case 8: {
                return pSSysPFPluginBase.isOrderValueDirty();
            }
            case 9: {
                return pSSysPFPluginBase.isPluginDescDirty();
            }
            case 10: {
                return pSSysPFPluginBase.isPluginModelDirty();
            }
            case 11: {
                return pSSysPFPluginBase.isPluginParamsDirty();
            }
            case 12: {
                return pSSysPFPluginBase.isPluginTagDirty();
            }
            case 13: {
                return pSSysPFPluginBase.isPluginTag2Dirty();
            }
            case 14: {
                return pSSysPFPluginBase.isPluginTypeDirty();
            }
            case 15: {
                return pSSysPFPluginBase.isPreviewHtmlDirty();
            }
            case 16: {
                return pSSysPFPluginBase.isPreviewPSNDFileIdDirty();
            }
            case 17: {
                return pSSysPFPluginBase.isPreviewUrlDirty();
            }
            case 18: {
                return pSSysPFPluginBase.isPSDynaInstIdDirty();
            }
            case 19: {
                return pSSysPFPluginBase.isPSModuleIdDirty();
            }
            case 20: {
                return pSSysPFPluginBase.isPSModuleNameDirty();
            }
            case 21: {
                return pSSysPFPluginBase.isPSPFPluginIdDirty();
            }
            case 22: {
                return pSSysPFPluginBase.isPSPFPluginNameDirty();
            }
            case 23: {
                return pSSysPFPluginBase.isPSSysFileIdDirty();
            }
            case 24: {
                return pSSysPFPluginBase.isPSSysPFPITemplsCntDirty();
            }
            case 25: {
                return pSSysPFPluginBase.isPSSysPFPluginIdDirty();
            }
            case 26: {
                return pSSysPFPluginBase.isPSSysPFPluginNameDirty();
            }
            case 27: {
                return pSSysPFPluginBase.isPSSystemIdDirty();
            }
            case 28: {
                return pSSysPFPluginBase.isPSSystemNameDirty();
            }
            case 29: {
                return pSSysPFPluginBase.isRepDefaultDirty();
            }
            case 30: {
                return pSSysPFPluginBase.isRTObjectModeDirty();
            }
            case 31: {
                return pSSysPFPluginBase.isRTObjectNameDirty();
            }
            case 32: {
                return pSSysPFPluginBase.isRTObjectRepoDirty();
            }
            case 33: {
                return pSSysPFPluginBase.isStudioIconDirty();
            }
            case 34: {
                return pSSysPFPluginBase.isTempalteFuncDirty();
            }
            case 35: {
                return pSSysPFPluginBase.isTemplateModeDirty();
            }
            case 36: {
                return pSSysPFPluginBase.isUpdateDateDirty();
            }
            case 37: {
                return pSSysPFPluginBase.isUpdateManDirty();
            }
            case 38: {
                return pSSysPFPluginBase.isUserCatDirty();
            }
            case 39: {
                return pSSysPFPluginBase.isUserTagDirty();
            }
            case 40: {
                return pSSysPFPluginBase.isUserTag2Dirty();
            }
            case 41: {
                return pSSysPFPluginBase.isUserTag3Dirty();
            }
            case 42: {
                return pSSysPFPluginBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysPFPluginBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysPFPluginBase pSSysPFPluginBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysPFPluginBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysPFPluginBase.getJSONValue((Object)pSSysPFPluginBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysPFPluginBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysPFPluginBase.getJSONValue((Object)pSSysPFPluginBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysPFPluginBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysPFPluginBase.getJSONValue((Object)pSSysPFPluginBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysPFPluginBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSSysPFPluginBase.getJSONValue((Object)pSSysPFPluginBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSSysPFPluginBase.getExtendStyleOnly() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"extendstyleonly", (Object)PSSysPFPluginBase.getJSONValue((Object)pSSysPFPluginBase.getExtendStyleOnly()), (boolean)false);
        }
        if (bl || pSSysPFPluginBase.getKeywords() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"keywords", (Object)PSSysPFPluginBase.getJSONValue((Object)pSSysPFPluginBase.getKeywords()), (boolean)false);
        }
        if (bl || pSSysPFPluginBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSSysPFPluginBase.getJSONValue((Object)pSSysPFPluginBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSSysPFPluginBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysPFPluginBase.getJSONValue((Object)pSSysPFPluginBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysPFPluginBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSysPFPluginBase.getJSONValue((Object)pSSysPFPluginBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSysPFPluginBase.getPluginDesc() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"plugindesc", (Object)PSSysPFPluginBase.getJSONValue((Object)pSSysPFPluginBase.getPluginDesc()), (boolean)false);
        }
        if (bl || pSSysPFPluginBase.getPluginModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pluginmodel", (Object)PSSysPFPluginBase.getJSONValue((Object)pSSysPFPluginBase.getPluginModel()), (boolean)false);
        }
        if (bl || pSSysPFPluginBase.getPluginParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pluginparams", (Object)PSSysPFPluginBase.getJSONValue((Object)pSSysPFPluginBase.getPluginParams()), (boolean)false);
        }
        if (bl || pSSysPFPluginBase.getPluginTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"plugintag", (Object)PSSysPFPluginBase.getJSONValue((Object)pSSysPFPluginBase.getPluginTag()), (boolean)false);
        }
        if (bl || pSSysPFPluginBase.getPluginTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"plugintag2", (Object)PSSysPFPluginBase.getJSONValue((Object)pSSysPFPluginBase.getPluginTag2()), (boolean)false);
        }
        if (bl || pSSysPFPluginBase.getPluginType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"plugintype", (Object)PSSysPFPluginBase.getJSONValue((Object)pSSysPFPluginBase.getPluginType()), (boolean)false);
        }
        if (bl || pSSysPFPluginBase.getPreviewHtml() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"previewhtml", (Object)PSSysPFPluginBase.getJSONValue((Object)pSSysPFPluginBase.getPreviewHtml()), (boolean)false);
        }
        if (bl || pSSysPFPluginBase.getPreviewPSNDFileId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"previewpsndfileid", (Object)PSSysPFPluginBase.getJSONValue((Object)pSSysPFPluginBase.getPreviewPSNDFileId()), (boolean)false);
        }
        if (bl || pSSysPFPluginBase.getPreviewUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"previewurl", (Object)PSSysPFPluginBase.getJSONValue((Object)pSSysPFPluginBase.getPreviewUrl()), (boolean)false);
        }
        if (bl || pSSysPFPluginBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSSysPFPluginBase.getJSONValue((Object)pSSysPFPluginBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSSysPFPluginBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSSysPFPluginBase.getJSONValue((Object)pSSysPFPluginBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSSysPFPluginBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSSysPFPluginBase.getJSONValue((Object)pSSysPFPluginBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSSysPFPluginBase.getPSPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpluginid", (Object)PSSysPFPluginBase.getJSONValue((Object)pSSysPFPluginBase.getPSPFPluginId()), (boolean)false);
        }
        if (bl || pSSysPFPluginBase.getPSPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpluginname", (Object)PSSysPFPluginBase.getJSONValue((Object)pSSysPFPluginBase.getPSPFPluginName()), (boolean)false);
        }
        if (bl || pSSysPFPluginBase.getPSSysFileId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysfileid", (Object)PSSysPFPluginBase.getJSONValue((Object)pSSysPFPluginBase.getPSSysFileId()), (boolean)false);
        }
        if (bl || pSSysPFPluginBase.getPSSysPFPITemplsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpitemplscnt", (Object)PSSysPFPluginBase.getJSONValue((Object)pSSysPFPluginBase.getPSSysPFPITemplsCnt()), (boolean)false);
        }
        if (bl || pSSysPFPluginBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSSysPFPluginBase.getJSONValue((Object)pSSysPFPluginBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSSysPFPluginBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSSysPFPluginBase.getJSONValue((Object)pSSysPFPluginBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSSysPFPluginBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysPFPluginBase.getJSONValue((Object)pSSysPFPluginBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysPFPluginBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysPFPluginBase.getJSONValue((Object)pSSysPFPluginBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysPFPluginBase.getRepDefault() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"repdefault", (Object)PSSysPFPluginBase.getJSONValue((Object)pSSysPFPluginBase.getRepDefault()), (boolean)false);
        }
        if (bl || pSSysPFPluginBase.getRTObjectMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rtobjectmode", (Object)PSSysPFPluginBase.getJSONValue((Object)pSSysPFPluginBase.getRTObjectMode()), (boolean)false);
        }
        if (bl || pSSysPFPluginBase.getRTObjectName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rtobjectname", (Object)PSSysPFPluginBase.getJSONValue((Object)pSSysPFPluginBase.getRTObjectName()), (boolean)false);
        }
        if (bl || pSSysPFPluginBase.getRTObjectRepo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rtobjectrepo", (Object)PSSysPFPluginBase.getJSONValue((Object)pSSysPFPluginBase.getRTObjectRepo()), (boolean)false);
        }
        if (bl || pSSysPFPluginBase.getStudioIcon() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"studioicon", (Object)PSSysPFPluginBase.getJSONValue((Object)pSSysPFPluginBase.getStudioIcon()), (boolean)false);
        }
        if (bl || pSSysPFPluginBase.getTempalteFunc() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templatefunc", (Object)PSSysPFPluginBase.getJSONValue((Object)pSSysPFPluginBase.getTempalteFunc()), (boolean)false);
        }
        if (bl || pSSysPFPluginBase.getTemplateMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templatemode", (Object)PSSysPFPluginBase.getJSONValue((Object)pSSysPFPluginBase.getTemplateMode()), (boolean)false);
        }
        if (bl || pSSysPFPluginBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysPFPluginBase.getJSONValue((Object)pSSysPFPluginBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysPFPluginBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysPFPluginBase.getJSONValue((Object)pSSysPFPluginBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysPFPluginBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysPFPluginBase.getJSONValue((Object)pSSysPFPluginBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysPFPluginBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysPFPluginBase.getJSONValue((Object)pSSysPFPluginBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysPFPluginBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysPFPluginBase.getJSONValue((Object)pSSysPFPluginBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysPFPluginBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysPFPluginBase.getJSONValue((Object)pSSysPFPluginBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysPFPluginBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysPFPluginBase.getJSONValue((Object)pSSysPFPluginBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysPFPluginBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysPFPluginBase pSSysPFPluginBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysPFPluginBase.getCodeName() != null) {
            object = pSSysPFPluginBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysPFPluginBase.getCreateDate() != null) {
            object = pSSysPFPluginBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysPFPluginBase.getCreateMan() != null) {
            object = pSSysPFPluginBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysPFPluginBase.getDynaModelFlag() != null) {
            object = pSSysPFPluginBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysPFPluginBase.getExtendStyleOnly() != null) {
            object = pSSysPFPluginBase.getExtendStyleOnly();
            xmlNode.setAttribute(FIELD_EXTENDSTYLEONLY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysPFPluginBase.getKeywords() != null) {
            object = pSSysPFPluginBase.getKeywords();
            xmlNode.setAttribute(FIELD_KEYWORDS, object == null ? "" : (String)object);
        }
        if (bl || pSSysPFPluginBase.getLockFlag() != null) {
            object = pSSysPFPluginBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysPFPluginBase.getMemo() != null) {
            object = pSSysPFPluginBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysPFPluginBase.getOrderValue() != null) {
            object = pSSysPFPluginBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysPFPluginBase.getPluginDesc() != null) {
            object = pSSysPFPluginBase.getPluginDesc();
            xmlNode.setAttribute(FIELD_PLUGINDESC, object == null ? "" : (String)object);
        }
        if (bl || pSSysPFPluginBase.getPluginModel() != null) {
            object = pSSysPFPluginBase.getPluginModel();
            xmlNode.setAttribute(FIELD_PLUGINMODEL, object == null ? "" : (String)object);
        }
        if (bl || pSSysPFPluginBase.getPluginParams() != null) {
            object = pSSysPFPluginBase.getPluginParams();
            xmlNode.setAttribute(FIELD_PLUGINPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSSysPFPluginBase.getPluginTag() != null) {
            object = pSSysPFPluginBase.getPluginTag();
            xmlNode.setAttribute(FIELD_PLUGINTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysPFPluginBase.getPluginTag2() != null) {
            object = pSSysPFPluginBase.getPluginTag2();
            xmlNode.setAttribute(FIELD_PLUGINTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysPFPluginBase.getPluginType() != null) {
            object = pSSysPFPluginBase.getPluginType();
            xmlNode.setAttribute(FIELD_PLUGINTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysPFPluginBase.getPreviewHtml() != null) {
            object = pSSysPFPluginBase.getPreviewHtml();
            xmlNode.setAttribute(FIELD_PREVIEWHTML, object == null ? "" : (String)object);
        }
        if (bl || pSSysPFPluginBase.getPreviewPSNDFileId() != null) {
            object = pSSysPFPluginBase.getPreviewPSNDFileId();
            xmlNode.setAttribute(FIELD_PREVIEWPSNDFILEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysPFPluginBase.getPreviewUrl() != null) {
            object = pSSysPFPluginBase.getPreviewUrl();
            xmlNode.setAttribute(FIELD_PREVIEWURL, object == null ? "" : (String)object);
        }
        if (bl || pSSysPFPluginBase.getPSDynaInstId() != null) {
            object = pSSysPFPluginBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysPFPluginBase.getPSModuleId() != null) {
            object = pSSysPFPluginBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysPFPluginBase.getPSModuleName() != null) {
            object = pSSysPFPluginBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysPFPluginBase.getPSPFPluginId() != null) {
            object = pSSysPFPluginBase.getPSPFPluginId();
            xmlNode.setAttribute(FIELD_PSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSysPFPluginBase.getPSPFPluginName() != null) {
            object = pSSysPFPluginBase.getPSPFPluginName();
            xmlNode.setAttribute(FIELD_PSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysPFPluginBase.getPSSysFileId() != null) {
            object = pSSysPFPluginBase.getPSSysFileId();
            xmlNode.setAttribute(FIELD_PSSYSFILEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysPFPluginBase.getPSSysPFPITemplsCnt() != null) {
            object = pSSysPFPluginBase.getPSSysPFPITemplsCnt();
            xmlNode.setAttribute(FIELD_PSSYSPFPITEMPLSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysPFPluginBase.getPSSysPFPluginId() != null) {
            object = pSSysPFPluginBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSysPFPluginBase.getPSSysPFPluginName() != null) {
            object = pSSysPFPluginBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysPFPluginBase.getPSSystemId() != null) {
            object = pSSysPFPluginBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysPFPluginBase.getPSSystemName() != null) {
            object = pSSysPFPluginBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysPFPluginBase.getRepDefault() != null) {
            object = pSSysPFPluginBase.getRepDefault();
            xmlNode.setAttribute(FIELD_REPDEFAULT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysPFPluginBase.getRTObjectMode() != null) {
            object = pSSysPFPluginBase.getRTObjectMode();
            xmlNode.setAttribute(FIELD_RTOBJECTMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysPFPluginBase.getRTObjectName() != null) {
            object = pSSysPFPluginBase.getRTObjectName();
            xmlNode.setAttribute(FIELD_RTOBJECTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysPFPluginBase.getRTObjectRepo() != null) {
            object = pSSysPFPluginBase.getRTObjectRepo();
            xmlNode.setAttribute(FIELD_RTOBJECTREPO, object == null ? "" : (String)object);
        }
        if (bl || pSSysPFPluginBase.getStudioIcon() != null) {
            object = pSSysPFPluginBase.getStudioIcon();
            xmlNode.setAttribute(FIELD_STUDIOICON, object == null ? "" : (String)object);
        }
        if (bl || pSSysPFPluginBase.getTempalteFunc() != null) {
            object = pSSysPFPluginBase.getTempalteFunc();
            xmlNode.setAttribute("TEMPALTEFUNC", object == null ? "" : (String)object);
        }
        if (bl || pSSysPFPluginBase.getTemplateMode() != null) {
            object = pSSysPFPluginBase.getTemplateMode();
            xmlNode.setAttribute(FIELD_TEMPLATEMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysPFPluginBase.getUpdateDate() != null) {
            object = pSSysPFPluginBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysPFPluginBase.getUpdateMan() != null) {
            object = pSSysPFPluginBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysPFPluginBase.getUserCat() != null) {
            object = pSSysPFPluginBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysPFPluginBase.getUserTag() != null) {
            object = pSSysPFPluginBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysPFPluginBase.getUserTag2() != null) {
            object = pSSysPFPluginBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysPFPluginBase.getUserTag3() != null) {
            object = pSSysPFPluginBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysPFPluginBase.getUserTag4() != null) {
            object = pSSysPFPluginBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysPFPluginBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysPFPluginBase pSSysPFPluginBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysPFPluginBase.isCodeNameDirty() && (bl || pSSysPFPluginBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysPFPluginBase.getCodeName());
        }
        if (pSSysPFPluginBase.isCreateDateDirty() && (bl || pSSysPFPluginBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysPFPluginBase.getCreateDate());
        }
        if (pSSysPFPluginBase.isCreateManDirty() && (bl || pSSysPFPluginBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysPFPluginBase.getCreateMan());
        }
        if (pSSysPFPluginBase.isDynaModelFlagDirty() && (bl || pSSysPFPluginBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSSysPFPluginBase.getDynaModelFlag());
        }
        if (pSSysPFPluginBase.isExtendStyleOnlyDirty() && (bl || pSSysPFPluginBase.getExtendStyleOnly() != null)) {
            iDataObject.set(FIELD_EXTENDSTYLEONLY, (Object)pSSysPFPluginBase.getExtendStyleOnly());
        }
        if (pSSysPFPluginBase.isKeywordsDirty() && (bl || pSSysPFPluginBase.getKeywords() != null)) {
            iDataObject.set(FIELD_KEYWORDS, (Object)pSSysPFPluginBase.getKeywords());
        }
        if (pSSysPFPluginBase.isLockFlagDirty() && (bl || pSSysPFPluginBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSSysPFPluginBase.getLockFlag());
        }
        if (pSSysPFPluginBase.isMemoDirty() && (bl || pSSysPFPluginBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysPFPluginBase.getMemo());
        }
        if (pSSysPFPluginBase.isOrderValueDirty() && (bl || pSSysPFPluginBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSysPFPluginBase.getOrderValue());
        }
        if (pSSysPFPluginBase.isPluginDescDirty() && (bl || pSSysPFPluginBase.getPluginDesc() != null)) {
            iDataObject.set(FIELD_PLUGINDESC, (Object)pSSysPFPluginBase.getPluginDesc());
        }
        if (pSSysPFPluginBase.isPluginModelDirty() && (bl || pSSysPFPluginBase.getPluginModel() != null)) {
            iDataObject.set(FIELD_PLUGINMODEL, (Object)pSSysPFPluginBase.getPluginModel());
        }
        if (pSSysPFPluginBase.isPluginParamsDirty() && (bl || pSSysPFPluginBase.getPluginParams() != null)) {
            iDataObject.set(FIELD_PLUGINPARAMS, (Object)pSSysPFPluginBase.getPluginParams());
        }
        if (pSSysPFPluginBase.isPluginTagDirty() && (bl || pSSysPFPluginBase.getPluginTag() != null)) {
            iDataObject.set(FIELD_PLUGINTAG, (Object)pSSysPFPluginBase.getPluginTag());
        }
        if (pSSysPFPluginBase.isPluginTag2Dirty() && (bl || pSSysPFPluginBase.getPluginTag2() != null)) {
            iDataObject.set(FIELD_PLUGINTAG2, (Object)pSSysPFPluginBase.getPluginTag2());
        }
        if (pSSysPFPluginBase.isPluginTypeDirty() && (bl || pSSysPFPluginBase.getPluginType() != null)) {
            iDataObject.set(FIELD_PLUGINTYPE, (Object)pSSysPFPluginBase.getPluginType());
        }
        if (pSSysPFPluginBase.isPreviewHtmlDirty() && (bl || pSSysPFPluginBase.getPreviewHtml() != null)) {
            iDataObject.set(FIELD_PREVIEWHTML, (Object)pSSysPFPluginBase.getPreviewHtml());
        }
        if (pSSysPFPluginBase.isPreviewPSNDFileIdDirty() && (bl || pSSysPFPluginBase.getPreviewPSNDFileId() != null)) {
            iDataObject.set(FIELD_PREVIEWPSNDFILEID, (Object)pSSysPFPluginBase.getPreviewPSNDFileId());
        }
        if (pSSysPFPluginBase.isPreviewUrlDirty() && (bl || pSSysPFPluginBase.getPreviewUrl() != null)) {
            iDataObject.set(FIELD_PREVIEWURL, (Object)pSSysPFPluginBase.getPreviewUrl());
        }
        if (pSSysPFPluginBase.isPSDynaInstIdDirty() && (bl || pSSysPFPluginBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSSysPFPluginBase.getPSDynaInstId());
        }
        if (pSSysPFPluginBase.isPSModuleIdDirty() && (bl || pSSysPFPluginBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSSysPFPluginBase.getPSModuleId());
        }
        if (pSSysPFPluginBase.isPSModuleNameDirty() && (bl || pSSysPFPluginBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSSysPFPluginBase.getPSModuleName());
        }
        if (pSSysPFPluginBase.isPSPFPluginIdDirty() && (bl || pSSysPFPluginBase.getPSPFPluginId() != null)) {
            iDataObject.set(FIELD_PSPFPLUGINID, (Object)pSSysPFPluginBase.getPSPFPluginId());
        }
        if (pSSysPFPluginBase.isPSPFPluginNameDirty() && (bl || pSSysPFPluginBase.getPSPFPluginName() != null)) {
            iDataObject.set(FIELD_PSPFPLUGINNAME, (Object)pSSysPFPluginBase.getPSPFPluginName());
        }
        if (pSSysPFPluginBase.isPSSysFileIdDirty() && (bl || pSSysPFPluginBase.getPSSysFileId() != null)) {
            iDataObject.set(FIELD_PSSYSFILEID, (Object)pSSysPFPluginBase.getPSSysFileId());
        }
        if (pSSysPFPluginBase.isPSSysPFPITemplsCntDirty() && (bl || pSSysPFPluginBase.getPSSysPFPITemplsCnt() != null)) {
            iDataObject.set(FIELD_PSSYSPFPITEMPLSCNT, (Object)pSSysPFPluginBase.getPSSysPFPITemplsCnt());
        }
        if (pSSysPFPluginBase.isPSSysPFPluginIdDirty() && (bl || pSSysPFPluginBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSSysPFPluginBase.getPSSysPFPluginId());
        }
        if (pSSysPFPluginBase.isPSSysPFPluginNameDirty() && (bl || pSSysPFPluginBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSSysPFPluginBase.getPSSysPFPluginName());
        }
        if (pSSysPFPluginBase.isPSSystemIdDirty() && (bl || pSSysPFPluginBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysPFPluginBase.getPSSystemId());
        }
        if (pSSysPFPluginBase.isPSSystemNameDirty() && (bl || pSSysPFPluginBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysPFPluginBase.getPSSystemName());
        }
        if (pSSysPFPluginBase.isRepDefaultDirty() && (bl || pSSysPFPluginBase.getRepDefault() != null)) {
            iDataObject.set(FIELD_REPDEFAULT, (Object)pSSysPFPluginBase.getRepDefault());
        }
        if (pSSysPFPluginBase.isRTObjectModeDirty() && (bl || pSSysPFPluginBase.getRTObjectMode() != null)) {
            iDataObject.set(FIELD_RTOBJECTMODE, (Object)pSSysPFPluginBase.getRTObjectMode());
        }
        if (pSSysPFPluginBase.isRTObjectNameDirty() && (bl || pSSysPFPluginBase.getRTObjectName() != null)) {
            iDataObject.set(FIELD_RTOBJECTNAME, (Object)pSSysPFPluginBase.getRTObjectName());
        }
        if (pSSysPFPluginBase.isRTObjectRepoDirty() && (bl || pSSysPFPluginBase.getRTObjectRepo() != null)) {
            iDataObject.set(FIELD_RTOBJECTREPO, (Object)pSSysPFPluginBase.getRTObjectRepo());
        }
        if (pSSysPFPluginBase.isStudioIconDirty() && (bl || pSSysPFPluginBase.getStudioIcon() != null)) {
            iDataObject.set(FIELD_STUDIOICON, (Object)pSSysPFPluginBase.getStudioIcon());
        }
        if (pSSysPFPluginBase.isTempalteFuncDirty() && (bl || pSSysPFPluginBase.getTempalteFunc() != null)) {
            iDataObject.set(FIELD_TEMPALTEFUNC, (Object)pSSysPFPluginBase.getTempalteFunc());
        }
        if (pSSysPFPluginBase.isTemplateModeDirty() && (bl || pSSysPFPluginBase.getTemplateMode() != null)) {
            iDataObject.set(FIELD_TEMPLATEMODE, (Object)pSSysPFPluginBase.getTemplateMode());
        }
        if (pSSysPFPluginBase.isUpdateDateDirty() && (bl || pSSysPFPluginBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysPFPluginBase.getUpdateDate());
        }
        if (pSSysPFPluginBase.isUpdateManDirty() && (bl || pSSysPFPluginBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysPFPluginBase.getUpdateMan());
        }
        if (pSSysPFPluginBase.isUserCatDirty() && (bl || pSSysPFPluginBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysPFPluginBase.getUserCat());
        }
        if (pSSysPFPluginBase.isUserTagDirty() && (bl || pSSysPFPluginBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysPFPluginBase.getUserTag());
        }
        if (pSSysPFPluginBase.isUserTag2Dirty() && (bl || pSSysPFPluginBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysPFPluginBase.getUserTag2());
        }
        if (pSSysPFPluginBase.isUserTag3Dirty() && (bl || pSSysPFPluginBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysPFPluginBase.getUserTag3());
        }
        if (pSSysPFPluginBase.isUserTag4Dirty() && (bl || pSSysPFPluginBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysPFPluginBase.getUserTag4());
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
        return PSSysPFPluginBase.remove(this, n);
    }

    private static boolean remove(PSSysPFPluginBase pSSysPFPluginBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysPFPluginBase.resetCodeName();
                return true;
            }
            case 1: {
                pSSysPFPluginBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSysPFPluginBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSysPFPluginBase.resetDynaModelFlag();
                return true;
            }
            case 4: {
                pSSysPFPluginBase.resetExtendStyleOnly();
                return true;
            }
            case 5: {
                pSSysPFPluginBase.resetKeywords();
                return true;
            }
            case 6: {
                pSSysPFPluginBase.resetLockFlag();
                return true;
            }
            case 7: {
                pSSysPFPluginBase.resetMemo();
                return true;
            }
            case 8: {
                pSSysPFPluginBase.resetOrderValue();
                return true;
            }
            case 9: {
                pSSysPFPluginBase.resetPluginDesc();
                return true;
            }
            case 10: {
                pSSysPFPluginBase.resetPluginModel();
                return true;
            }
            case 11: {
                pSSysPFPluginBase.resetPluginParams();
                return true;
            }
            case 12: {
                pSSysPFPluginBase.resetPluginTag();
                return true;
            }
            case 13: {
                pSSysPFPluginBase.resetPluginTag2();
                return true;
            }
            case 14: {
                pSSysPFPluginBase.resetPluginType();
                return true;
            }
            case 15: {
                pSSysPFPluginBase.resetPreviewHtml();
                return true;
            }
            case 16: {
                pSSysPFPluginBase.resetPreviewPSNDFileId();
                return true;
            }
            case 17: {
                pSSysPFPluginBase.resetPreviewUrl();
                return true;
            }
            case 18: {
                pSSysPFPluginBase.resetPSDynaInstId();
                return true;
            }
            case 19: {
                pSSysPFPluginBase.resetPSModuleId();
                return true;
            }
            case 20: {
                pSSysPFPluginBase.resetPSModuleName();
                return true;
            }
            case 21: {
                pSSysPFPluginBase.resetPSPFPluginId();
                return true;
            }
            case 22: {
                pSSysPFPluginBase.resetPSPFPluginName();
                return true;
            }
            case 23: {
                pSSysPFPluginBase.resetPSSysFileId();
                return true;
            }
            case 24: {
                pSSysPFPluginBase.resetPSSysPFPITemplsCnt();
                return true;
            }
            case 25: {
                pSSysPFPluginBase.resetPSSysPFPluginId();
                return true;
            }
            case 26: {
                pSSysPFPluginBase.resetPSSysPFPluginName();
                return true;
            }
            case 27: {
                pSSysPFPluginBase.resetPSSystemId();
                return true;
            }
            case 28: {
                pSSysPFPluginBase.resetPSSystemName();
                return true;
            }
            case 29: {
                pSSysPFPluginBase.resetRepDefault();
                return true;
            }
            case 30: {
                pSSysPFPluginBase.resetRTObjectMode();
                return true;
            }
            case 31: {
                pSSysPFPluginBase.resetRTObjectName();
                return true;
            }
            case 32: {
                pSSysPFPluginBase.resetRTObjectRepo();
                return true;
            }
            case 33: {
                pSSysPFPluginBase.resetStudioIcon();
                return true;
            }
            case 34: {
                pSSysPFPluginBase.resetTempalteFunc();
                return true;
            }
            case 35: {
                pSSysPFPluginBase.resetTemplateMode();
                return true;
            }
            case 36: {
                pSSysPFPluginBase.resetUpdateDate();
                return true;
            }
            case 37: {
                pSSysPFPluginBase.resetUpdateMan();
                return true;
            }
            case 38: {
                pSSysPFPluginBase.resetUserCat();
                return true;
            }
            case 39: {
                pSSysPFPluginBase.resetUserTag();
                return true;
            }
            case 40: {
                pSSysPFPluginBase.resetUserTag2();
                return true;
            }
            case 41: {
                pSSysPFPluginBase.resetUserTag3();
                return true;
            }
            case 42: {
                pSSysPFPluginBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSModule getPSModule() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModule();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        Integer n = this.objPSModuleLock;
        synchronized (n) {
            if (this.psmodule != null && DataTypeHelper.compare((int)25, (Object)this.getPSModuleId(), (Object)this.psmodule.getPSModuleId()) != 0L) {
                this.psmodule = null;
            }
            if (this.psmodule == null) {
                PSModule pSModule = new PSModule();
                pSModule.setPSModuleId(this.getPSModuleId());
                PSModuleService pSModuleService = (PSModuleService)ServiceGlobal.getService(PSModuleService.class, (SessionFactory)this.getSessionFactory());
                pSModuleService.autoGet((IEntity)pSModule);
                this.psmodule = pSModule;
            }
            return this.psmodule;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSPFPlugin getPSPFPlugin() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFPlugin();
        }
        if (this.getPSPFPluginId() == null) {
            return null;
        }
        Integer n = this.objPSPFPluginLock;
        synchronized (n) {
            if (this.pspfplugin != null && DataTypeHelper.compare((int)25, (Object)this.getPSPFPluginId(), (Object)this.pspfplugin.getPSPFPluginId()) != 0L) {
                this.pspfplugin = null;
            }
            if (this.pspfplugin == null) {
                PSPFPlugin pSPFPlugin = new PSPFPlugin();
                pSPFPlugin.setPSPFPluginId(this.getPSPFPluginId());
                PSPFPluginService pSPFPluginService = (PSPFPluginService)ServiceGlobal.getService(PSPFPluginService.class, (SessionFactory)this.getSessionFactory());
                pSPFPluginService.autoGet((IEntity)pSPFPlugin);
                this.pspfplugin = pSPFPlugin;
            }
            return this.pspfplugin;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSystem getPSSystem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystem();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        Integer n = this.objPSSystemLock;
        synchronized (n) {
            if (this.pssystem != null && DataTypeHelper.compare((int)25, (Object)this.getPSSystemId(), (Object)this.pssystem.getPSSystemId()) != 0L) {
                this.pssystem = null;
            }
            if (this.pssystem == null) {
                PSSystem pSSystem = new PSSystem();
                pSSystem.setPSSystemId(this.getPSSystemId());
                PSSystemService pSSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)this.getSessionFactory());
                pSSystemService.autoGet((IEntity)pSSystem);
                this.pssystem = pSSystem;
            }
            return this.pssystem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysPFPITempl> getPSSysPFPITempls() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPFPITempls();
        }
        if (this.getPSSysPFPluginId() == null) {
            return null;
        }
        PSSysPFPITemplService pSSysPFPITemplService = (PSSysPFPITemplService)ServiceGlobal.getService(PSSysPFPITemplService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysPFPITemplsLock;
        synchronized (n) {
            if (this.pssyspfpitempls == null) {
                this.pssyspfpitempls = pSSysPFPITemplService.selectByPSSysPFPlugin(this);
            }
            return this.pssyspfpitempls;
        }
    }

    private PSSysPFPluginBase getProxyEntity() {
        return this.proxyPSSysPFPluginBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysPFPluginBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysPFPluginBase) {
            this.proxyPSSysPFPluginBase = (PSSysPFPluginBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPFPluginService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 3);
        fieldIndexMap.put(FIELD_EXTENDSTYLEONLY, 4);
        fieldIndexMap.put(FIELD_KEYWORDS, 5);
        fieldIndexMap.put(FIELD_LOCKFLAG, 6);
        fieldIndexMap.put(FIELD_MEMO, 7);
        fieldIndexMap.put(FIELD_ORDERVALUE, 8);
        fieldIndexMap.put(FIELD_PLUGINDESC, 9);
        fieldIndexMap.put(FIELD_PLUGINMODEL, 10);
        fieldIndexMap.put(FIELD_PLUGINPARAMS, 11);
        fieldIndexMap.put(FIELD_PLUGINTAG, 12);
        fieldIndexMap.put(FIELD_PLUGINTAG2, 13);
        fieldIndexMap.put(FIELD_PLUGINTYPE, 14);
        fieldIndexMap.put(FIELD_PREVIEWHTML, 15);
        fieldIndexMap.put(FIELD_PREVIEWPSNDFILEID, 16);
        fieldIndexMap.put(FIELD_PREVIEWURL, 17);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 18);
        fieldIndexMap.put(FIELD_PSMODULEID, 19);
        fieldIndexMap.put(FIELD_PSMODULENAME, 20);
        fieldIndexMap.put(FIELD_PSPFPLUGINID, 21);
        fieldIndexMap.put(FIELD_PSPFPLUGINNAME, 22);
        fieldIndexMap.put(FIELD_PSSYSFILEID, 23);
        fieldIndexMap.put(FIELD_PSSYSPFPITEMPLSCNT, 24);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINID, 25);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINNAME, 26);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 27);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 28);
        fieldIndexMap.put(FIELD_REPDEFAULT, 29);
        fieldIndexMap.put(FIELD_RTOBJECTMODE, 30);
        fieldIndexMap.put(FIELD_RTOBJECTNAME, 31);
        fieldIndexMap.put(FIELD_RTOBJECTREPO, 32);
        fieldIndexMap.put(FIELD_STUDIOICON, 33);
        fieldIndexMap.put(FIELD_TEMPALTEFUNC, 34);
        fieldIndexMap.put(FIELD_TEMPLATEMODE, 35);
        fieldIndexMap.put(FIELD_UPDATEDATE, 36);
        fieldIndexMap.put(FIELD_UPDATEMAN, 37);
        fieldIndexMap.put(FIELD_USERCAT, 38);
        fieldIndexMap.put(FIELD_USERTAG, 39);
        fieldIndexMap.put(FIELD_USERTAG2, 40);
        fieldIndexMap.put(FIELD_USERTAG3, 41);
        fieldIndexMap.put(FIELD_USERTAG4, 42);
    }
}

