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
import net.ibizsys.pscore.srv.config.entity.PSSFPlugin;
import net.ibizsys.pscore.srv.config.service.PSSFPluginService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPITempl;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPITemplService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysSFPluginBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysSFPluginBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_KEYWORDS = "KEYWORDS";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PARAMDESC = "PARAMDESC";
    public static final String FIELD_PLUGINMODEL = "PLUGINMODEL";
    public static final String FIELD_PLUGINPARAMS = "PLUGINPARAMS";
    public static final String FIELD_PLUGINTAG = "PLUGINTAG";
    public static final String FIELD_PLUGINTAG2 = "PLUGINTAG2";
    public static final String FIELD_PLUGINTYPE = "PLUGINTYPE";
    public static final String FIELD_PREVIEWHTML = "PREVIEWHTML";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSFPLUGINID = "PSSFPLUGINID";
    public static final String FIELD_PSSFPLUGINNAME = "PSSFPLUGINNAME";
    public static final String FIELD_PSSYSSFPITEMPLSCNT = "PSSYSSFPITEMPLSCNT";
    public static final String FIELD_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String FIELD_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_REPDEFAULT = "REPDEFAULT";
    public static final String FIELD_RTOBJECTMODE = "RTOBJECTMODE";
    public static final String FIELD_RTOBJECTNAME = "RTOBJECTNAME";
    public static final String FIELD_RTOBJECTREPO = "RTOBJECTREPO";
    public static final String FIELD_SINGLEINSTMODE = "SINGLEINSTMODE";
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
    private static final int INDEX_KEYWORDS = 3;
    private static final int INDEX_LOCKFLAG = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_ORDERVALUE = 6;
    private static final int INDEX_PARAMDESC = 7;
    private static final int INDEX_PLUGINMODEL = 8;
    private static final int INDEX_PLUGINPARAMS = 9;
    private static final int INDEX_PLUGINTAG = 10;
    private static final int INDEX_PLUGINTAG2 = 11;
    private static final int INDEX_PLUGINTYPE = 12;
    private static final int INDEX_PREVIEWHTML = 13;
    private static final int INDEX_PSMODULEID = 14;
    private static final int INDEX_PSMODULENAME = 15;
    private static final int INDEX_PSSFPLUGINID = 16;
    private static final int INDEX_PSSFPLUGINNAME = 17;
    private static final int INDEX_PSSYSSFPITEMPLSCNT = 18;
    private static final int INDEX_PSSYSSFPLUGINID = 19;
    private static final int INDEX_PSSYSSFPLUGINNAME = 20;
    private static final int INDEX_PSSYSTEMID = 21;
    private static final int INDEX_PSSYSTEMNAME = 22;
    private static final int INDEX_REPDEFAULT = 23;
    private static final int INDEX_RTOBJECTMODE = 24;
    private static final int INDEX_RTOBJECTNAME = 25;
    private static final int INDEX_RTOBJECTREPO = 26;
    private static final int INDEX_SINGLEINSTMODE = 27;
    private static final int INDEX_STUDIOICON = 28;
    private static final int INDEX_TEMPALTEFUNC = 29;
    private static final int INDEX_TEMPLATEMODE = 30;
    private static final int INDEX_UPDATEDATE = 31;
    private static final int INDEX_UPDATEMAN = 32;
    private static final int INDEX_USERCAT = 33;
    private static final int INDEX_USERTAG = 34;
    private static final int INDEX_USERTAG2 = 35;
    private static final int INDEX_USERTAG3 = 36;
    private static final int INDEX_USERTAG4 = 37;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysSFPluginBase proxyPSSysSFPluginBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean keywordsDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean paramdescDirtyFlag = false;
    private boolean pluginmodelDirtyFlag = false;
    private boolean pluginparamsDirtyFlag = false;
    private boolean plugintagDirtyFlag = false;
    private boolean plugintag2DirtyFlag = false;
    private boolean plugintypeDirtyFlag = false;
    private boolean previewhtmlDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssfpluginidDirtyFlag = false;
    private boolean pssfpluginnameDirtyFlag = false;
    private boolean pssyssfpitemplscntDirtyFlag = false;
    private boolean pssyssfpluginidDirtyFlag = false;
    private boolean pssyssfpluginnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean repdefaultDirtyFlag = false;
    private boolean rtobjectmodeDirtyFlag = false;
    private boolean rtobjectnameDirtyFlag = false;
    private boolean rtobjectrepoDirtyFlag = false;
    private boolean singleinstmodeDirtyFlag = false;
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
    @Column(name="keywords")
    private String keywords;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="paramdesc")
    private String paramdesc;
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
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssfpluginid")
    private String pssfpluginid;
    @Column(name="pssfpluginname")
    private String pssfpluginname;
    @Column(name="pssyssfpitemplscnt")
    private Integer pssyssfpitemplscnt;
    @Column(name="pssyssfpluginid")
    private String pssyssfpluginid;
    @Column(name="pssyssfpluginname")
    private String pssyssfpluginname;
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
    @Column(name="singleinstmode")
    private Integer singleinstmode;
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
    private Integer objPSSFPluginLock = new Integer(1);
    private PSSFPlugin pssfplugin = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSSysSFPITemplsLock = new Integer(1);
    private ArrayList<PSSysSFPITempl> pssyssfpitempls = null;

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

    public void setParamDesc(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParamDesc(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.paramdesc = string;
        this.paramdescDirtyFlag = true;
    }

    public String getParamDesc() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParamDesc();
        }
        return this.paramdesc;
    }

    public boolean isParamDescDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParamDescDirty();
        }
        return this.paramdescDirtyFlag;
    }

    public void resetParamDesc() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParamDesc();
            return;
        }
        this.paramdescDirtyFlag = false;
        this.paramdesc = null;
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

    public void setPSSFPluginId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFPluginId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfpluginid = string;
        this.pssfpluginidDirtyFlag = true;
    }

    public String getPSSFPluginId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFPluginId();
        }
        return this.pssfpluginid;
    }

    public boolean isPSSFPluginIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFPluginIdDirty();
        }
        return this.pssfpluginidDirtyFlag;
    }

    public void resetPSSFPluginId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFPluginId();
            return;
        }
        this.pssfpluginidDirtyFlag = false;
        this.pssfpluginid = null;
    }

    public void setPSSFPluginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFPluginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfpluginname = string;
        this.pssfpluginnameDirtyFlag = true;
    }

    public String getPSSFPluginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFPluginName();
        }
        return this.pssfpluginname;
    }

    public boolean isPSSFPluginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFPluginNameDirty();
        }
        return this.pssfpluginnameDirtyFlag;
    }

    public void resetPSSFPluginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFPluginName();
            return;
        }
        this.pssfpluginnameDirtyFlag = false;
        this.pssfpluginname = null;
    }

    public void setPSSysSFPITemplsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSFPITemplsCnt(n);
            return;
        }
        this.pssyssfpitemplscnt = n;
        this.pssyssfpitemplscntDirtyFlag = true;
    }

    public Integer getPSSysSFPITemplsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPITemplsCnt();
        }
        return this.pssyssfpitemplscnt;
    }

    public boolean isPSSysSFPITemplsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSFPITemplsCntDirty();
        }
        return this.pssyssfpitemplscntDirtyFlag;
    }

    public void resetPSSysSFPITemplsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSFPITemplsCnt();
            return;
        }
        this.pssyssfpitemplscntDirtyFlag = false;
        this.pssyssfpitemplscnt = null;
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

    public void setSingleInstMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSingleInstMode(n);
            return;
        }
        this.singleinstmode = n;
        this.singleinstmodeDirtyFlag = true;
    }

    public Integer getSingleInstMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSingleInstMode();
        }
        return this.singleinstmode;
    }

    public boolean isSingleInstModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSingleInstModeDirty();
        }
        return this.singleinstmodeDirtyFlag;
    }

    public void resetSingleInstMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSingleInstMode();
            return;
        }
        this.singleinstmodeDirtyFlag = false;
        this.singleinstmode = null;
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
        PSSysSFPluginBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysSFPluginBase pSSysSFPluginBase) {
        pSSysSFPluginBase.resetCodeName();
        pSSysSFPluginBase.resetCreateDate();
        pSSysSFPluginBase.resetCreateMan();
        pSSysSFPluginBase.resetKeywords();
        pSSysSFPluginBase.resetLockFlag();
        pSSysSFPluginBase.resetMemo();
        pSSysSFPluginBase.resetOrderValue();
        pSSysSFPluginBase.resetParamDesc();
        pSSysSFPluginBase.resetPluginModel();
        pSSysSFPluginBase.resetPluginParams();
        pSSysSFPluginBase.resetPluginTag();
        pSSysSFPluginBase.resetPluginTag2();
        pSSysSFPluginBase.resetPluginType();
        pSSysSFPluginBase.resetPreviewHtml();
        pSSysSFPluginBase.resetPSModuleId();
        pSSysSFPluginBase.resetPSModuleName();
        pSSysSFPluginBase.resetPSSFPluginId();
        pSSysSFPluginBase.resetPSSFPluginName();
        pSSysSFPluginBase.resetPSSysSFPITemplsCnt();
        pSSysSFPluginBase.resetPSSysSFPluginId();
        pSSysSFPluginBase.resetPSSysSFPluginName();
        pSSysSFPluginBase.resetPSSystemId();
        pSSysSFPluginBase.resetPSSystemName();
        pSSysSFPluginBase.resetRepDefault();
        pSSysSFPluginBase.resetRTObjectMode();
        pSSysSFPluginBase.resetRTObjectName();
        pSSysSFPluginBase.resetRTObjectRepo();
        pSSysSFPluginBase.resetSingleInstMode();
        pSSysSFPluginBase.resetStudioIcon();
        pSSysSFPluginBase.resetTempalteFunc();
        pSSysSFPluginBase.resetTemplateMode();
        pSSysSFPluginBase.resetUpdateDate();
        pSSysSFPluginBase.resetUpdateMan();
        pSSysSFPluginBase.resetUserCat();
        pSSysSFPluginBase.resetUserTag();
        pSSysSFPluginBase.resetUserTag2();
        pSSysSFPluginBase.resetUserTag3();
        pSSysSFPluginBase.resetUserTag4();
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
        if (!bl || this.isParamDescDirty()) {
            hashMap.put(FIELD_PARAMDESC, this.getParamDesc());
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
        if (!bl || this.isPSModuleIdDirty()) {
            hashMap.put(FIELD_PSMODULEID, this.getPSModuleId());
        }
        if (!bl || this.isPSModuleNameDirty()) {
            hashMap.put(FIELD_PSMODULENAME, this.getPSModuleName());
        }
        if (!bl || this.isPSSFPluginIdDirty()) {
            hashMap.put(FIELD_PSSFPLUGINID, this.getPSSFPluginId());
        }
        if (!bl || this.isPSSFPluginNameDirty()) {
            hashMap.put(FIELD_PSSFPLUGINNAME, this.getPSSFPluginName());
        }
        if (!bl || this.isPSSysSFPITemplsCntDirty()) {
            hashMap.put(FIELD_PSSYSSFPITEMPLSCNT, this.getPSSysSFPITemplsCnt());
        }
        if (!bl || this.isPSSysSFPluginIdDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINID, this.getPSSysSFPluginId());
        }
        if (!bl || this.isPSSysSFPluginNameDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINNAME, this.getPSSysSFPluginName());
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
        if (!bl || this.isSingleInstModeDirty()) {
            hashMap.put(FIELD_SINGLEINSTMODE, this.getSingleInstMode());
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
        return PSSysSFPluginBase.get(this, n);
    }

    private static Object get(PSSysSFPluginBase pSSysSFPluginBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysSFPluginBase.getCodeName();
            }
            case 1: {
                return pSSysSFPluginBase.getCreateDate();
            }
            case 2: {
                return pSSysSFPluginBase.getCreateMan();
            }
            case 3: {
                return pSSysSFPluginBase.getKeywords();
            }
            case 4: {
                return pSSysSFPluginBase.getLockFlag();
            }
            case 5: {
                return pSSysSFPluginBase.getMemo();
            }
            case 6: {
                return pSSysSFPluginBase.getOrderValue();
            }
            case 7: {
                return pSSysSFPluginBase.getParamDesc();
            }
            case 8: {
                return pSSysSFPluginBase.getPluginModel();
            }
            case 9: {
                return pSSysSFPluginBase.getPluginParams();
            }
            case 10: {
                return pSSysSFPluginBase.getPluginTag();
            }
            case 11: {
                return pSSysSFPluginBase.getPluginTag2();
            }
            case 12: {
                return pSSysSFPluginBase.getPluginType();
            }
            case 13: {
                return pSSysSFPluginBase.getPreviewHtml();
            }
            case 14: {
                return pSSysSFPluginBase.getPSModuleId();
            }
            case 15: {
                return pSSysSFPluginBase.getPSModuleName();
            }
            case 16: {
                return pSSysSFPluginBase.getPSSFPluginId();
            }
            case 17: {
                return pSSysSFPluginBase.getPSSFPluginName();
            }
            case 18: {
                return pSSysSFPluginBase.getPSSysSFPITemplsCnt();
            }
            case 19: {
                return pSSysSFPluginBase.getPSSysSFPluginId();
            }
            case 20: {
                return pSSysSFPluginBase.getPSSysSFPluginName();
            }
            case 21: {
                return pSSysSFPluginBase.getPSSystemId();
            }
            case 22: {
                return pSSysSFPluginBase.getPSSystemName();
            }
            case 23: {
                return pSSysSFPluginBase.getRepDefault();
            }
            case 24: {
                return pSSysSFPluginBase.getRTObjectMode();
            }
            case 25: {
                return pSSysSFPluginBase.getRTObjectName();
            }
            case 26: {
                return pSSysSFPluginBase.getRTObjectRepo();
            }
            case 27: {
                return pSSysSFPluginBase.getSingleInstMode();
            }
            case 28: {
                return pSSysSFPluginBase.getStudioIcon();
            }
            case 29: {
                return pSSysSFPluginBase.getTempalteFunc();
            }
            case 30: {
                return pSSysSFPluginBase.getTemplateMode();
            }
            case 31: {
                return pSSysSFPluginBase.getUpdateDate();
            }
            case 32: {
                return pSSysSFPluginBase.getUpdateMan();
            }
            case 33: {
                return pSSysSFPluginBase.getUserCat();
            }
            case 34: {
                return pSSysSFPluginBase.getUserTag();
            }
            case 35: {
                return pSSysSFPluginBase.getUserTag2();
            }
            case 36: {
                return pSSysSFPluginBase.getUserTag3();
            }
            case 37: {
                return pSSysSFPluginBase.getUserTag4();
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
        PSSysSFPluginBase.set(this, n, object);
    }

    private static void set(PSSysSFPluginBase pSSysSFPluginBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysSFPluginBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysSFPluginBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysSFPluginBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysSFPluginBase.setKeywords(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysSFPluginBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSSysSFPluginBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysSFPluginBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSSysSFPluginBase.setParamDesc(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysSFPluginBase.setPluginModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysSFPluginBase.setPluginParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysSFPluginBase.setPluginTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysSFPluginBase.setPluginTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysSFPluginBase.setPluginType(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysSFPluginBase.setPreviewHtml(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysSFPluginBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysSFPluginBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysSFPluginBase.setPSSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysSFPluginBase.setPSSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysSFPluginBase.setPSSysSFPITemplsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 19: {
                pSSysSFPluginBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysSFPluginBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysSFPluginBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysSFPluginBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysSFPluginBase.setRepDefault(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 24: {
                pSSysSFPluginBase.setRTObjectMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 25: {
                pSSysSFPluginBase.setRTObjectName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysSFPluginBase.setRTObjectRepo(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysSFPluginBase.setSingleInstMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 28: {
                pSSysSFPluginBase.setStudioIcon(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSysSFPluginBase.setTempalteFunc(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSysSFPluginBase.setTemplateMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 31: {
                pSSysSFPluginBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 32: {
                pSSysSFPluginBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSSysSFPluginBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSSysSFPluginBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSSysSFPluginBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSSysSFPluginBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSSysSFPluginBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSSysSFPluginBase.isNull(this, n);
    }

    private static boolean isNull(PSSysSFPluginBase pSSysSFPluginBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysSFPluginBase.getCodeName() == null;
            }
            case 1: {
                return pSSysSFPluginBase.getCreateDate() == null;
            }
            case 2: {
                return pSSysSFPluginBase.getCreateMan() == null;
            }
            case 3: {
                return pSSysSFPluginBase.getKeywords() == null;
            }
            case 4: {
                return pSSysSFPluginBase.getLockFlag() == null;
            }
            case 5: {
                return pSSysSFPluginBase.getMemo() == null;
            }
            case 6: {
                return pSSysSFPluginBase.getOrderValue() == null;
            }
            case 7: {
                return pSSysSFPluginBase.getParamDesc() == null;
            }
            case 8: {
                return pSSysSFPluginBase.getPluginModel() == null;
            }
            case 9: {
                return pSSysSFPluginBase.getPluginParams() == null;
            }
            case 10: {
                return pSSysSFPluginBase.getPluginTag() == null;
            }
            case 11: {
                return pSSysSFPluginBase.getPluginTag2() == null;
            }
            case 12: {
                return pSSysSFPluginBase.getPluginType() == null;
            }
            case 13: {
                return pSSysSFPluginBase.getPreviewHtml() == null;
            }
            case 14: {
                return pSSysSFPluginBase.getPSModuleId() == null;
            }
            case 15: {
                return pSSysSFPluginBase.getPSModuleName() == null;
            }
            case 16: {
                return pSSysSFPluginBase.getPSSFPluginId() == null;
            }
            case 17: {
                return pSSysSFPluginBase.getPSSFPluginName() == null;
            }
            case 18: {
                return pSSysSFPluginBase.getPSSysSFPITemplsCnt() == null;
            }
            case 19: {
                return pSSysSFPluginBase.getPSSysSFPluginId() == null;
            }
            case 20: {
                return pSSysSFPluginBase.getPSSysSFPluginName() == null;
            }
            case 21: {
                return pSSysSFPluginBase.getPSSystemId() == null;
            }
            case 22: {
                return pSSysSFPluginBase.getPSSystemName() == null;
            }
            case 23: {
                return pSSysSFPluginBase.getRepDefault() == null;
            }
            case 24: {
                return pSSysSFPluginBase.getRTObjectMode() == null;
            }
            case 25: {
                return pSSysSFPluginBase.getRTObjectName() == null;
            }
            case 26: {
                return pSSysSFPluginBase.getRTObjectRepo() == null;
            }
            case 27: {
                return pSSysSFPluginBase.getSingleInstMode() == null;
            }
            case 28: {
                return pSSysSFPluginBase.getStudioIcon() == null;
            }
            case 29: {
                return pSSysSFPluginBase.getTempalteFunc() == null;
            }
            case 30: {
                return pSSysSFPluginBase.getTemplateMode() == null;
            }
            case 31: {
                return pSSysSFPluginBase.getUpdateDate() == null;
            }
            case 32: {
                return pSSysSFPluginBase.getUpdateMan() == null;
            }
            case 33: {
                return pSSysSFPluginBase.getUserCat() == null;
            }
            case 34: {
                return pSSysSFPluginBase.getUserTag() == null;
            }
            case 35: {
                return pSSysSFPluginBase.getUserTag2() == null;
            }
            case 36: {
                return pSSysSFPluginBase.getUserTag3() == null;
            }
            case 37: {
                return pSSysSFPluginBase.getUserTag4() == null;
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
        return PSSysSFPluginBase.contains(this, n);
    }

    private static boolean contains(PSSysSFPluginBase pSSysSFPluginBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysSFPluginBase.isCodeNameDirty();
            }
            case 1: {
                return pSSysSFPluginBase.isCreateDateDirty();
            }
            case 2: {
                return pSSysSFPluginBase.isCreateManDirty();
            }
            case 3: {
                return pSSysSFPluginBase.isKeywordsDirty();
            }
            case 4: {
                return pSSysSFPluginBase.isLockFlagDirty();
            }
            case 5: {
                return pSSysSFPluginBase.isMemoDirty();
            }
            case 6: {
                return pSSysSFPluginBase.isOrderValueDirty();
            }
            case 7: {
                return pSSysSFPluginBase.isParamDescDirty();
            }
            case 8: {
                return pSSysSFPluginBase.isPluginModelDirty();
            }
            case 9: {
                return pSSysSFPluginBase.isPluginParamsDirty();
            }
            case 10: {
                return pSSysSFPluginBase.isPluginTagDirty();
            }
            case 11: {
                return pSSysSFPluginBase.isPluginTag2Dirty();
            }
            case 12: {
                return pSSysSFPluginBase.isPluginTypeDirty();
            }
            case 13: {
                return pSSysSFPluginBase.isPreviewHtmlDirty();
            }
            case 14: {
                return pSSysSFPluginBase.isPSModuleIdDirty();
            }
            case 15: {
                return pSSysSFPluginBase.isPSModuleNameDirty();
            }
            case 16: {
                return pSSysSFPluginBase.isPSSFPluginIdDirty();
            }
            case 17: {
                return pSSysSFPluginBase.isPSSFPluginNameDirty();
            }
            case 18: {
                return pSSysSFPluginBase.isPSSysSFPITemplsCntDirty();
            }
            case 19: {
                return pSSysSFPluginBase.isPSSysSFPluginIdDirty();
            }
            case 20: {
                return pSSysSFPluginBase.isPSSysSFPluginNameDirty();
            }
            case 21: {
                return pSSysSFPluginBase.isPSSystemIdDirty();
            }
            case 22: {
                return pSSysSFPluginBase.isPSSystemNameDirty();
            }
            case 23: {
                return pSSysSFPluginBase.isRepDefaultDirty();
            }
            case 24: {
                return pSSysSFPluginBase.isRTObjectModeDirty();
            }
            case 25: {
                return pSSysSFPluginBase.isRTObjectNameDirty();
            }
            case 26: {
                return pSSysSFPluginBase.isRTObjectRepoDirty();
            }
            case 27: {
                return pSSysSFPluginBase.isSingleInstModeDirty();
            }
            case 28: {
                return pSSysSFPluginBase.isStudioIconDirty();
            }
            case 29: {
                return pSSysSFPluginBase.isTempalteFuncDirty();
            }
            case 30: {
                return pSSysSFPluginBase.isTemplateModeDirty();
            }
            case 31: {
                return pSSysSFPluginBase.isUpdateDateDirty();
            }
            case 32: {
                return pSSysSFPluginBase.isUpdateManDirty();
            }
            case 33: {
                return pSSysSFPluginBase.isUserCatDirty();
            }
            case 34: {
                return pSSysSFPluginBase.isUserTagDirty();
            }
            case 35: {
                return pSSysSFPluginBase.isUserTag2Dirty();
            }
            case 36: {
                return pSSysSFPluginBase.isUserTag3Dirty();
            }
            case 37: {
                return pSSysSFPluginBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysSFPluginBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysSFPluginBase pSSysSFPluginBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysSFPluginBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysSFPluginBase.getJSONValue((Object)pSSysSFPluginBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysSFPluginBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysSFPluginBase.getJSONValue((Object)pSSysSFPluginBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysSFPluginBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysSFPluginBase.getJSONValue((Object)pSSysSFPluginBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysSFPluginBase.getKeywords() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"keywords", (Object)PSSysSFPluginBase.getJSONValue((Object)pSSysSFPluginBase.getKeywords()), (boolean)false);
        }
        if (bl || pSSysSFPluginBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSSysSFPluginBase.getJSONValue((Object)pSSysSFPluginBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSSysSFPluginBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysSFPluginBase.getJSONValue((Object)pSSysSFPluginBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysSFPluginBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSysSFPluginBase.getJSONValue((Object)pSSysSFPluginBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSysSFPluginBase.getParamDesc() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"paramdesc", (Object)PSSysSFPluginBase.getJSONValue((Object)pSSysSFPluginBase.getParamDesc()), (boolean)false);
        }
        if (bl || pSSysSFPluginBase.getPluginModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pluginmodel", (Object)PSSysSFPluginBase.getJSONValue((Object)pSSysSFPluginBase.getPluginModel()), (boolean)false);
        }
        if (bl || pSSysSFPluginBase.getPluginParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pluginparams", (Object)PSSysSFPluginBase.getJSONValue((Object)pSSysSFPluginBase.getPluginParams()), (boolean)false);
        }
        if (bl || pSSysSFPluginBase.getPluginTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"plugintag", (Object)PSSysSFPluginBase.getJSONValue((Object)pSSysSFPluginBase.getPluginTag()), (boolean)false);
        }
        if (bl || pSSysSFPluginBase.getPluginTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"plugintag2", (Object)PSSysSFPluginBase.getJSONValue((Object)pSSysSFPluginBase.getPluginTag2()), (boolean)false);
        }
        if (bl || pSSysSFPluginBase.getPluginType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"plugintype", (Object)PSSysSFPluginBase.getJSONValue((Object)pSSysSFPluginBase.getPluginType()), (boolean)false);
        }
        if (bl || pSSysSFPluginBase.getPreviewHtml() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"previewhtml", (Object)PSSysSFPluginBase.getJSONValue((Object)pSSysSFPluginBase.getPreviewHtml()), (boolean)false);
        }
        if (bl || pSSysSFPluginBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSSysSFPluginBase.getJSONValue((Object)pSSysSFPluginBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSSysSFPluginBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSSysSFPluginBase.getJSONValue((Object)pSSysSFPluginBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSSysSFPluginBase.getPSSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfpluginid", (Object)PSSysSFPluginBase.getJSONValue((Object)pSSysSFPluginBase.getPSSFPluginId()), (boolean)false);
        }
        if (bl || pSSysSFPluginBase.getPSSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfpluginname", (Object)PSSysSFPluginBase.getJSONValue((Object)pSSysSFPluginBase.getPSSFPluginName()), (boolean)false);
        }
        if (bl || pSSysSFPluginBase.getPSSysSFPITemplsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpitemplscnt", (Object)PSSysSFPluginBase.getJSONValue((Object)pSSysSFPluginBase.getPSSysSFPITemplsCnt()), (boolean)false);
        }
        if (bl || pSSysSFPluginBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSSysSFPluginBase.getJSONValue((Object)pSSysSFPluginBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSSysSFPluginBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSSysSFPluginBase.getJSONValue((Object)pSSysSFPluginBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSSysSFPluginBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysSFPluginBase.getJSONValue((Object)pSSysSFPluginBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysSFPluginBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysSFPluginBase.getJSONValue((Object)pSSysSFPluginBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysSFPluginBase.getRepDefault() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"repdefault", (Object)PSSysSFPluginBase.getJSONValue((Object)pSSysSFPluginBase.getRepDefault()), (boolean)false);
        }
        if (bl || pSSysSFPluginBase.getRTObjectMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rtobjectmode", (Object)PSSysSFPluginBase.getJSONValue((Object)pSSysSFPluginBase.getRTObjectMode()), (boolean)false);
        }
        if (bl || pSSysSFPluginBase.getRTObjectName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rtobjectname", (Object)PSSysSFPluginBase.getJSONValue((Object)pSSysSFPluginBase.getRTObjectName()), (boolean)false);
        }
        if (bl || pSSysSFPluginBase.getRTObjectRepo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rtobjectrepo", (Object)PSSysSFPluginBase.getJSONValue((Object)pSSysSFPluginBase.getRTObjectRepo()), (boolean)false);
        }
        if (bl || pSSysSFPluginBase.getSingleInstMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"singleinstmode", (Object)PSSysSFPluginBase.getJSONValue((Object)pSSysSFPluginBase.getSingleInstMode()), (boolean)false);
        }
        if (bl || pSSysSFPluginBase.getStudioIcon() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"studioicon", (Object)PSSysSFPluginBase.getJSONValue((Object)pSSysSFPluginBase.getStudioIcon()), (boolean)false);
        }
        if (bl || pSSysSFPluginBase.getTempalteFunc() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templatefunc", (Object)PSSysSFPluginBase.getJSONValue((Object)pSSysSFPluginBase.getTempalteFunc()), (boolean)false);
        }
        if (bl || pSSysSFPluginBase.getTemplateMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templatemode", (Object)PSSysSFPluginBase.getJSONValue((Object)pSSysSFPluginBase.getTemplateMode()), (boolean)false);
        }
        if (bl || pSSysSFPluginBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysSFPluginBase.getJSONValue((Object)pSSysSFPluginBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysSFPluginBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysSFPluginBase.getJSONValue((Object)pSSysSFPluginBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysSFPluginBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysSFPluginBase.getJSONValue((Object)pSSysSFPluginBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysSFPluginBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysSFPluginBase.getJSONValue((Object)pSSysSFPluginBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysSFPluginBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysSFPluginBase.getJSONValue((Object)pSSysSFPluginBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysSFPluginBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysSFPluginBase.getJSONValue((Object)pSSysSFPluginBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysSFPluginBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysSFPluginBase.getJSONValue((Object)pSSysSFPluginBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysSFPluginBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysSFPluginBase pSSysSFPluginBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysSFPluginBase.getCodeName() != null) {
            object = pSSysSFPluginBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPluginBase.getCreateDate() != null) {
            object = pSSysSFPluginBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysSFPluginBase.getCreateMan() != null) {
            object = pSSysSFPluginBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPluginBase.getKeywords() != null) {
            object = pSSysSFPluginBase.getKeywords();
            xmlNode.setAttribute(FIELD_KEYWORDS, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPluginBase.getLockFlag() != null) {
            object = pSSysSFPluginBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysSFPluginBase.getMemo() != null) {
            object = pSSysSFPluginBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPluginBase.getOrderValue() != null) {
            object = pSSysSFPluginBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysSFPluginBase.getParamDesc() != null) {
            object = pSSysSFPluginBase.getParamDesc();
            xmlNode.setAttribute(FIELD_PARAMDESC, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPluginBase.getPluginModel() != null) {
            object = pSSysSFPluginBase.getPluginModel();
            xmlNode.setAttribute(FIELD_PLUGINMODEL, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPluginBase.getPluginParams() != null) {
            object = pSSysSFPluginBase.getPluginParams();
            xmlNode.setAttribute(FIELD_PLUGINPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPluginBase.getPluginTag() != null) {
            object = pSSysSFPluginBase.getPluginTag();
            xmlNode.setAttribute(FIELD_PLUGINTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPluginBase.getPluginTag2() != null) {
            object = pSSysSFPluginBase.getPluginTag2();
            xmlNode.setAttribute(FIELD_PLUGINTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPluginBase.getPluginType() != null) {
            object = pSSysSFPluginBase.getPluginType();
            xmlNode.setAttribute(FIELD_PLUGINTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPluginBase.getPreviewHtml() != null) {
            object = pSSysSFPluginBase.getPreviewHtml();
            xmlNode.setAttribute(FIELD_PREVIEWHTML, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPluginBase.getPSModuleId() != null) {
            object = pSSysSFPluginBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPluginBase.getPSModuleName() != null) {
            object = pSSysSFPluginBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPluginBase.getPSSFPluginId() != null) {
            object = pSSysSFPluginBase.getPSSFPluginId();
            xmlNode.setAttribute(FIELD_PSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPluginBase.getPSSFPluginName() != null) {
            object = pSSysSFPluginBase.getPSSFPluginName();
            xmlNode.setAttribute(FIELD_PSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPluginBase.getPSSysSFPITemplsCnt() != null) {
            object = pSSysSFPluginBase.getPSSysSFPITemplsCnt();
            xmlNode.setAttribute(FIELD_PSSYSSFPITEMPLSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysSFPluginBase.getPSSysSFPluginId() != null) {
            object = pSSysSFPluginBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPluginBase.getPSSysSFPluginName() != null) {
            object = pSSysSFPluginBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPluginBase.getPSSystemId() != null) {
            object = pSSysSFPluginBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPluginBase.getPSSystemName() != null) {
            object = pSSysSFPluginBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPluginBase.getRepDefault() != null) {
            object = pSSysSFPluginBase.getRepDefault();
            xmlNode.setAttribute(FIELD_REPDEFAULT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysSFPluginBase.getRTObjectMode() != null) {
            object = pSSysSFPluginBase.getRTObjectMode();
            xmlNode.setAttribute(FIELD_RTOBJECTMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysSFPluginBase.getRTObjectName() != null) {
            object = pSSysSFPluginBase.getRTObjectName();
            xmlNode.setAttribute(FIELD_RTOBJECTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPluginBase.getRTObjectRepo() != null) {
            object = pSSysSFPluginBase.getRTObjectRepo();
            xmlNode.setAttribute(FIELD_RTOBJECTREPO, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPluginBase.getSingleInstMode() != null) {
            object = pSSysSFPluginBase.getSingleInstMode();
            xmlNode.setAttribute(FIELD_SINGLEINSTMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysSFPluginBase.getStudioIcon() != null) {
            object = pSSysSFPluginBase.getStudioIcon();
            xmlNode.setAttribute(FIELD_STUDIOICON, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPluginBase.getTempalteFunc() != null) {
            object = pSSysSFPluginBase.getTempalteFunc();
            xmlNode.setAttribute("TEMPALTEFUNC", object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPluginBase.getTemplateMode() != null) {
            object = pSSysSFPluginBase.getTemplateMode();
            xmlNode.setAttribute(FIELD_TEMPLATEMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysSFPluginBase.getUpdateDate() != null) {
            object = pSSysSFPluginBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysSFPluginBase.getUpdateMan() != null) {
            object = pSSysSFPluginBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPluginBase.getUserCat() != null) {
            object = pSSysSFPluginBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPluginBase.getUserTag() != null) {
            object = pSSysSFPluginBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPluginBase.getUserTag2() != null) {
            object = pSSysSFPluginBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPluginBase.getUserTag3() != null) {
            object = pSSysSFPluginBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPluginBase.getUserTag4() != null) {
            object = pSSysSFPluginBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysSFPluginBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysSFPluginBase pSSysSFPluginBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysSFPluginBase.isCodeNameDirty() && (bl || pSSysSFPluginBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysSFPluginBase.getCodeName());
        }
        if (pSSysSFPluginBase.isCreateDateDirty() && (bl || pSSysSFPluginBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysSFPluginBase.getCreateDate());
        }
        if (pSSysSFPluginBase.isCreateManDirty() && (bl || pSSysSFPluginBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysSFPluginBase.getCreateMan());
        }
        if (pSSysSFPluginBase.isKeywordsDirty() && (bl || pSSysSFPluginBase.getKeywords() != null)) {
            iDataObject.set(FIELD_KEYWORDS, (Object)pSSysSFPluginBase.getKeywords());
        }
        if (pSSysSFPluginBase.isLockFlagDirty() && (bl || pSSysSFPluginBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSSysSFPluginBase.getLockFlag());
        }
        if (pSSysSFPluginBase.isMemoDirty() && (bl || pSSysSFPluginBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysSFPluginBase.getMemo());
        }
        if (pSSysSFPluginBase.isOrderValueDirty() && (bl || pSSysSFPluginBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSysSFPluginBase.getOrderValue());
        }
        if (pSSysSFPluginBase.isParamDescDirty() && (bl || pSSysSFPluginBase.getParamDesc() != null)) {
            iDataObject.set(FIELD_PARAMDESC, (Object)pSSysSFPluginBase.getParamDesc());
        }
        if (pSSysSFPluginBase.isPluginModelDirty() && (bl || pSSysSFPluginBase.getPluginModel() != null)) {
            iDataObject.set(FIELD_PLUGINMODEL, (Object)pSSysSFPluginBase.getPluginModel());
        }
        if (pSSysSFPluginBase.isPluginParamsDirty() && (bl || pSSysSFPluginBase.getPluginParams() != null)) {
            iDataObject.set(FIELD_PLUGINPARAMS, (Object)pSSysSFPluginBase.getPluginParams());
        }
        if (pSSysSFPluginBase.isPluginTagDirty() && (bl || pSSysSFPluginBase.getPluginTag() != null)) {
            iDataObject.set(FIELD_PLUGINTAG, (Object)pSSysSFPluginBase.getPluginTag());
        }
        if (pSSysSFPluginBase.isPluginTag2Dirty() && (bl || pSSysSFPluginBase.getPluginTag2() != null)) {
            iDataObject.set(FIELD_PLUGINTAG2, (Object)pSSysSFPluginBase.getPluginTag2());
        }
        if (pSSysSFPluginBase.isPluginTypeDirty() && (bl || pSSysSFPluginBase.getPluginType() != null)) {
            iDataObject.set(FIELD_PLUGINTYPE, (Object)pSSysSFPluginBase.getPluginType());
        }
        if (pSSysSFPluginBase.isPreviewHtmlDirty() && (bl || pSSysSFPluginBase.getPreviewHtml() != null)) {
            iDataObject.set(FIELD_PREVIEWHTML, (Object)pSSysSFPluginBase.getPreviewHtml());
        }
        if (pSSysSFPluginBase.isPSModuleIdDirty() && (bl || pSSysSFPluginBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSSysSFPluginBase.getPSModuleId());
        }
        if (pSSysSFPluginBase.isPSModuleNameDirty() && (bl || pSSysSFPluginBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSSysSFPluginBase.getPSModuleName());
        }
        if (pSSysSFPluginBase.isPSSFPluginIdDirty() && (bl || pSSysSFPluginBase.getPSSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSFPLUGINID, (Object)pSSysSFPluginBase.getPSSFPluginId());
        }
        if (pSSysSFPluginBase.isPSSFPluginNameDirty() && (bl || pSSysSFPluginBase.getPSSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSFPLUGINNAME, (Object)pSSysSFPluginBase.getPSSFPluginName());
        }
        if (pSSysSFPluginBase.isPSSysSFPITemplsCntDirty() && (bl || pSSysSFPluginBase.getPSSysSFPITemplsCnt() != null)) {
            iDataObject.set(FIELD_PSSYSSFPITEMPLSCNT, (Object)pSSysSFPluginBase.getPSSysSFPITemplsCnt());
        }
        if (pSSysSFPluginBase.isPSSysSFPluginIdDirty() && (bl || pSSysSFPluginBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSSysSFPluginBase.getPSSysSFPluginId());
        }
        if (pSSysSFPluginBase.isPSSysSFPluginNameDirty() && (bl || pSSysSFPluginBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSSysSFPluginBase.getPSSysSFPluginName());
        }
        if (pSSysSFPluginBase.isPSSystemIdDirty() && (bl || pSSysSFPluginBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysSFPluginBase.getPSSystemId());
        }
        if (pSSysSFPluginBase.isPSSystemNameDirty() && (bl || pSSysSFPluginBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysSFPluginBase.getPSSystemName());
        }
        if (pSSysSFPluginBase.isRepDefaultDirty() && (bl || pSSysSFPluginBase.getRepDefault() != null)) {
            iDataObject.set(FIELD_REPDEFAULT, (Object)pSSysSFPluginBase.getRepDefault());
        }
        if (pSSysSFPluginBase.isRTObjectModeDirty() && (bl || pSSysSFPluginBase.getRTObjectMode() != null)) {
            iDataObject.set(FIELD_RTOBJECTMODE, (Object)pSSysSFPluginBase.getRTObjectMode());
        }
        if (pSSysSFPluginBase.isRTObjectNameDirty() && (bl || pSSysSFPluginBase.getRTObjectName() != null)) {
            iDataObject.set(FIELD_RTOBJECTNAME, (Object)pSSysSFPluginBase.getRTObjectName());
        }
        if (pSSysSFPluginBase.isRTObjectRepoDirty() && (bl || pSSysSFPluginBase.getRTObjectRepo() != null)) {
            iDataObject.set(FIELD_RTOBJECTREPO, (Object)pSSysSFPluginBase.getRTObjectRepo());
        }
        if (pSSysSFPluginBase.isSingleInstModeDirty() && (bl || pSSysSFPluginBase.getSingleInstMode() != null)) {
            iDataObject.set(FIELD_SINGLEINSTMODE, (Object)pSSysSFPluginBase.getSingleInstMode());
        }
        if (pSSysSFPluginBase.isStudioIconDirty() && (bl || pSSysSFPluginBase.getStudioIcon() != null)) {
            iDataObject.set(FIELD_STUDIOICON, (Object)pSSysSFPluginBase.getStudioIcon());
        }
        if (pSSysSFPluginBase.isTempalteFuncDirty() && (bl || pSSysSFPluginBase.getTempalteFunc() != null)) {
            iDataObject.set(FIELD_TEMPALTEFUNC, (Object)pSSysSFPluginBase.getTempalteFunc());
        }
        if (pSSysSFPluginBase.isTemplateModeDirty() && (bl || pSSysSFPluginBase.getTemplateMode() != null)) {
            iDataObject.set(FIELD_TEMPLATEMODE, (Object)pSSysSFPluginBase.getTemplateMode());
        }
        if (pSSysSFPluginBase.isUpdateDateDirty() && (bl || pSSysSFPluginBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysSFPluginBase.getUpdateDate());
        }
        if (pSSysSFPluginBase.isUpdateManDirty() && (bl || pSSysSFPluginBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysSFPluginBase.getUpdateMan());
        }
        if (pSSysSFPluginBase.isUserCatDirty() && (bl || pSSysSFPluginBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysSFPluginBase.getUserCat());
        }
        if (pSSysSFPluginBase.isUserTagDirty() && (bl || pSSysSFPluginBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysSFPluginBase.getUserTag());
        }
        if (pSSysSFPluginBase.isUserTag2Dirty() && (bl || pSSysSFPluginBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysSFPluginBase.getUserTag2());
        }
        if (pSSysSFPluginBase.isUserTag3Dirty() && (bl || pSSysSFPluginBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysSFPluginBase.getUserTag3());
        }
        if (pSSysSFPluginBase.isUserTag4Dirty() && (bl || pSSysSFPluginBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysSFPluginBase.getUserTag4());
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
        return PSSysSFPluginBase.remove(this, n);
    }

    private static boolean remove(PSSysSFPluginBase pSSysSFPluginBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysSFPluginBase.resetCodeName();
                return true;
            }
            case 1: {
                pSSysSFPluginBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSysSFPluginBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSysSFPluginBase.resetKeywords();
                return true;
            }
            case 4: {
                pSSysSFPluginBase.resetLockFlag();
                return true;
            }
            case 5: {
                pSSysSFPluginBase.resetMemo();
                return true;
            }
            case 6: {
                pSSysSFPluginBase.resetOrderValue();
                return true;
            }
            case 7: {
                pSSysSFPluginBase.resetParamDesc();
                return true;
            }
            case 8: {
                pSSysSFPluginBase.resetPluginModel();
                return true;
            }
            case 9: {
                pSSysSFPluginBase.resetPluginParams();
                return true;
            }
            case 10: {
                pSSysSFPluginBase.resetPluginTag();
                return true;
            }
            case 11: {
                pSSysSFPluginBase.resetPluginTag2();
                return true;
            }
            case 12: {
                pSSysSFPluginBase.resetPluginType();
                return true;
            }
            case 13: {
                pSSysSFPluginBase.resetPreviewHtml();
                return true;
            }
            case 14: {
                pSSysSFPluginBase.resetPSModuleId();
                return true;
            }
            case 15: {
                pSSysSFPluginBase.resetPSModuleName();
                return true;
            }
            case 16: {
                pSSysSFPluginBase.resetPSSFPluginId();
                return true;
            }
            case 17: {
                pSSysSFPluginBase.resetPSSFPluginName();
                return true;
            }
            case 18: {
                pSSysSFPluginBase.resetPSSysSFPITemplsCnt();
                return true;
            }
            case 19: {
                pSSysSFPluginBase.resetPSSysSFPluginId();
                return true;
            }
            case 20: {
                pSSysSFPluginBase.resetPSSysSFPluginName();
                return true;
            }
            case 21: {
                pSSysSFPluginBase.resetPSSystemId();
                return true;
            }
            case 22: {
                pSSysSFPluginBase.resetPSSystemName();
                return true;
            }
            case 23: {
                pSSysSFPluginBase.resetRepDefault();
                return true;
            }
            case 24: {
                pSSysSFPluginBase.resetRTObjectMode();
                return true;
            }
            case 25: {
                pSSysSFPluginBase.resetRTObjectName();
                return true;
            }
            case 26: {
                pSSysSFPluginBase.resetRTObjectRepo();
                return true;
            }
            case 27: {
                pSSysSFPluginBase.resetSingleInstMode();
                return true;
            }
            case 28: {
                pSSysSFPluginBase.resetStudioIcon();
                return true;
            }
            case 29: {
                pSSysSFPluginBase.resetTempalteFunc();
                return true;
            }
            case 30: {
                pSSysSFPluginBase.resetTemplateMode();
                return true;
            }
            case 31: {
                pSSysSFPluginBase.resetUpdateDate();
                return true;
            }
            case 32: {
                pSSysSFPluginBase.resetUpdateMan();
                return true;
            }
            case 33: {
                pSSysSFPluginBase.resetUserCat();
                return true;
            }
            case 34: {
                pSSysSFPluginBase.resetUserTag();
                return true;
            }
            case 35: {
                pSSysSFPluginBase.resetUserTag2();
                return true;
            }
            case 36: {
                pSSysSFPluginBase.resetUserTag3();
                return true;
            }
            case 37: {
                pSSysSFPluginBase.resetUserTag4();
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
                pSModuleService.autoGet(pSModule);
                this.psmodule = pSModule;
            }
            return this.psmodule;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSFPlugin getPSSFPlugin() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFPlugin();
        }
        if (this.getPSSFPluginId() == null) {
            return null;
        }
        Integer n = this.objPSSFPluginLock;
        synchronized (n) {
            if (this.pssfplugin != null && DataTypeHelper.compare((int)25, (Object)this.getPSSFPluginId(), (Object)this.pssfplugin.getPSSFPluginId()) != 0L) {
                this.pssfplugin = null;
            }
            if (this.pssfplugin == null) {
                PSSFPlugin pSSFPlugin = new PSSFPlugin();
                pSSFPlugin.setPSSFPluginId(this.getPSSFPluginId());
                PSSFPluginService pSSFPluginService = (PSSFPluginService)ServiceGlobal.getService(PSSFPluginService.class, (SessionFactory)this.getSessionFactory());
                pSSFPluginService.autoGet(pSSFPlugin);
                this.pssfplugin = pSSFPlugin;
            }
            return this.pssfplugin;
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
                pSSystemService.autoGet(pSSystem);
                this.pssystem = pSSystem;
            }
            return this.pssystem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysSFPITempl> getPSSysSFPITempls() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPITempls();
        }
        if (this.getPSSysSFPluginId() == null) {
            return null;
        }
        PSSysSFPITemplService pSSysSFPITemplService = (PSSysSFPITemplService)ServiceGlobal.getService(PSSysSFPITemplService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysSFPITemplsLock;
        synchronized (n) {
            if (this.pssyssfpitempls == null) {
                this.pssyssfpitempls = pSSysSFPITemplService.selectByPSSysSFPlugin(this);
            }
            return this.pssyssfpitempls;
        }
    }

    private PSSysSFPluginBase getProxyEntity() {
        return this.proxyPSSysSFPluginBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysSFPluginBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysSFPluginBase) {
            this.proxyPSSysSFPluginBase = (PSSysSFPluginBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_KEYWORDS, 3);
        fieldIndexMap.put(FIELD_LOCKFLAG, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_ORDERVALUE, 6);
        fieldIndexMap.put(FIELD_PARAMDESC, 7);
        fieldIndexMap.put(FIELD_PLUGINMODEL, 8);
        fieldIndexMap.put(FIELD_PLUGINPARAMS, 9);
        fieldIndexMap.put(FIELD_PLUGINTAG, 10);
        fieldIndexMap.put(FIELD_PLUGINTAG2, 11);
        fieldIndexMap.put(FIELD_PLUGINTYPE, 12);
        fieldIndexMap.put(FIELD_PREVIEWHTML, 13);
        fieldIndexMap.put(FIELD_PSMODULEID, 14);
        fieldIndexMap.put(FIELD_PSMODULENAME, 15);
        fieldIndexMap.put(FIELD_PSSFPLUGINID, 16);
        fieldIndexMap.put(FIELD_PSSFPLUGINNAME, 17);
        fieldIndexMap.put(FIELD_PSSYSSFPITEMPLSCNT, 18);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 19);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 20);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 21);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 22);
        fieldIndexMap.put(FIELD_REPDEFAULT, 23);
        fieldIndexMap.put(FIELD_RTOBJECTMODE, 24);
        fieldIndexMap.put(FIELD_RTOBJECTNAME, 25);
        fieldIndexMap.put(FIELD_RTOBJECTREPO, 26);
        fieldIndexMap.put(FIELD_SINGLEINSTMODE, 27);
        fieldIndexMap.put(FIELD_STUDIOICON, 28);
        fieldIndexMap.put(FIELD_TEMPALTEFUNC, 29);
        fieldIndexMap.put(FIELD_TEMPLATEMODE, 30);
        fieldIndexMap.put(FIELD_UPDATEDATE, 31);
        fieldIndexMap.put(FIELD_UPDATEMAN, 32);
        fieldIndexMap.put(FIELD_USERCAT, 33);
        fieldIndexMap.put(FIELD_USERTAG, 34);
        fieldIndexMap.put(FIELD_USERTAG2, 35);
        fieldIndexMap.put(FIELD_USERTAG3, 36);
        fieldIndexMap.put(FIELD_USERTAG4, 37);
    }
}

