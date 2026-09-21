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
import net.ibizsys.pscore.srv.config.entity.PSSFPluginTempl;
import net.ibizsys.pscore.srv.config.service.PSSFPluginTemplService;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSFPluginBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSFPluginBase.class);
    public static final String FIELD_ALLDCFLAG = "ALLDCFLAG";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_KEYWORDS = "KEYWORDS";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PARAMDESC = "PARAMDESC";
    public static final String FIELD_PLUGINTYPE = "PLUGINTYPE";
    public static final String FIELD_PREVIEWHTML = "PREVIEWHTML";
    public static final String FIELD_PSDCID = "PSDCID";
    public static final String FIELD_PSDCNAME = "PSDCNAME";
    public static final String FIELD_PSSFPLUGINID = "PSSFPLUGINID";
    public static final String FIELD_PSSFPLUGINNAME = "PSSFPLUGINNAME";
    public static final String FIELD_RTOBJECTMODE = "RTOBJECTMODE";
    public static final String FIELD_RTOBJECTNAME = "RTOBJECTNAME";
    public static final String FIELD_RTOBJECTREPO = "RTOBJECTREPO";
    public static final String FIELD_STUDIOICON = "STUDIOICON";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_ALLDCFLAG = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_KEYWORDS = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PARAMDESC = 5;
    private static final int INDEX_PLUGINTYPE = 6;
    private static final int INDEX_PREVIEWHTML = 7;
    private static final int INDEX_PSDCID = 8;
    private static final int INDEX_PSDCNAME = 9;
    private static final int INDEX_PSSFPLUGINID = 10;
    private static final int INDEX_PSSFPLUGINNAME = 11;
    private static final int INDEX_RTOBJECTMODE = 12;
    private static final int INDEX_RTOBJECTNAME = 13;
    private static final int INDEX_RTOBJECTREPO = 14;
    private static final int INDEX_STUDIOICON = 15;
    private static final int INDEX_UPDATEDATE = 16;
    private static final int INDEX_UPDATEMAN = 17;
    private static final int INDEX_VALIDFLAG = 18;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSFPluginBase proxyPSSFPluginBase = null;
    private boolean alldcflagDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean keywordsDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean paramdescDirtyFlag = false;
    private boolean plugintypeDirtyFlag = false;
    private boolean previewhtmlDirtyFlag = false;
    private boolean psdcidDirtyFlag = false;
    private boolean psdcnameDirtyFlag = false;
    private boolean pssfpluginidDirtyFlag = false;
    private boolean pssfpluginnameDirtyFlag = false;
    private boolean rtobjectmodeDirtyFlag = false;
    private boolean rtobjectnameDirtyFlag = false;
    private boolean rtobjectrepoDirtyFlag = false;
    private boolean studioiconDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="alldcflag")
    private Integer alldcflag;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="keywords")
    private String keywords;
    @Column(name="memo")
    private String memo;
    @Column(name="paramdesc")
    private String paramdesc;
    @Column(name="plugintype")
    private String plugintype;
    @Column(name="previewhtml")
    private String previewhtml;
    @Column(name="psdcid")
    private String psdcid;
    @Column(name="psdcname")
    private String psdcname;
    @Column(name="pssfpluginid")
    private String pssfpluginid;
    @Column(name="pssfpluginname")
    private String pssfpluginname;
    @Column(name="rtobjectmode")
    private Integer rtobjectmode;
    @Column(name="rtobjectname")
    private String rtobjectname;
    @Column(name="rtobjectrepo")
    private String rtobjectrepo;
    @Column(name="studioicon")
    private String studioicon;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSDCLock = new Integer(1);
    private PSDevCenter psdc = null;
    private Integer objPSSFPluginTemplsLock = new Integer(1);
    private ArrayList<PSSFPluginTempl> pssfplugintempls = null;

    public void setAllDCFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAllDCFlag(n);
            return;
        }
        this.alldcflag = n;
        this.alldcflagDirtyFlag = true;
    }

    public Integer getAllDCFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAllDCFlag();
        }
        return this.alldcflag;
    }

    public boolean isAllDCFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAllDCFlagDirty();
        }
        return this.alldcflagDirtyFlag;
    }

    public void resetAllDCFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAllDCFlag();
            return;
        }
        this.alldcflagDirtyFlag = false;
        this.alldcflag = null;
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

    public void setPSDCId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcid = string;
        this.psdcidDirtyFlag = true;
    }

    public String getPSDCId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCId();
        }
        return this.psdcid;
    }

    public boolean isPSDCIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCIdDirty();
        }
        return this.psdcidDirtyFlag;
    }

    public void resetPSDCId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCId();
            return;
        }
        this.psdcidDirtyFlag = false;
        this.psdcid = null;
    }

    public void setPSDCName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcname = string;
        this.psdcnameDirtyFlag = true;
    }

    public String getPSDCName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCName();
        }
        return this.psdcname;
    }

    public boolean isPSDCNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCNameDirty();
        }
        return this.psdcnameDirtyFlag;
    }

    public void resetPSDCName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCName();
            return;
        }
        this.psdcnameDirtyFlag = false;
        this.psdcname = null;
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
        PSSFPluginBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSFPluginBase pSSFPluginBase) {
        pSSFPluginBase.resetAllDCFlag();
        pSSFPluginBase.resetCreateDate();
        pSSFPluginBase.resetCreateMan();
        pSSFPluginBase.resetKeywords();
        pSSFPluginBase.resetMemo();
        pSSFPluginBase.resetParamDesc();
        pSSFPluginBase.resetPluginType();
        pSSFPluginBase.resetPreviewHtml();
        pSSFPluginBase.resetPSDCId();
        pSSFPluginBase.resetPSDCName();
        pSSFPluginBase.resetPSSFPluginId();
        pSSFPluginBase.resetPSSFPluginName();
        pSSFPluginBase.resetRTObjectMode();
        pSSFPluginBase.resetRTObjectName();
        pSSFPluginBase.resetRTObjectRepo();
        pSSFPluginBase.resetStudioIcon();
        pSSFPluginBase.resetUpdateDate();
        pSSFPluginBase.resetUpdateMan();
        pSSFPluginBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAllDCFlagDirty()) {
            hashMap.put(FIELD_ALLDCFLAG, this.getAllDCFlag());
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
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isParamDescDirty()) {
            hashMap.put(FIELD_PARAMDESC, this.getParamDesc());
        }
        if (!bl || this.isPluginTypeDirty()) {
            hashMap.put(FIELD_PLUGINTYPE, this.getPluginType());
        }
        if (!bl || this.isPreviewHtmlDirty()) {
            hashMap.put(FIELD_PREVIEWHTML, this.getPreviewHtml());
        }
        if (!bl || this.isPSDCIdDirty()) {
            hashMap.put(FIELD_PSDCID, this.getPSDCId());
        }
        if (!bl || this.isPSDCNameDirty()) {
            hashMap.put(FIELD_PSDCNAME, this.getPSDCName());
        }
        if (!bl || this.isPSSFPluginIdDirty()) {
            hashMap.put(FIELD_PSSFPLUGINID, this.getPSSFPluginId());
        }
        if (!bl || this.isPSSFPluginNameDirty()) {
            hashMap.put(FIELD_PSSFPLUGINNAME, this.getPSSFPluginName());
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
        return PSSFPluginBase.get(this, n);
    }

    private static Object get(PSSFPluginBase pSSFPluginBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFPluginBase.getAllDCFlag();
            }
            case 1: {
                return pSSFPluginBase.getCreateDate();
            }
            case 2: {
                return pSSFPluginBase.getCreateMan();
            }
            case 3: {
                return pSSFPluginBase.getKeywords();
            }
            case 4: {
                return pSSFPluginBase.getMemo();
            }
            case 5: {
                return pSSFPluginBase.getParamDesc();
            }
            case 6: {
                return pSSFPluginBase.getPluginType();
            }
            case 7: {
                return pSSFPluginBase.getPreviewHtml();
            }
            case 8: {
                return pSSFPluginBase.getPSDCId();
            }
            case 9: {
                return pSSFPluginBase.getPSDCName();
            }
            case 10: {
                return pSSFPluginBase.getPSSFPluginId();
            }
            case 11: {
                return pSSFPluginBase.getPSSFPluginName();
            }
            case 12: {
                return pSSFPluginBase.getRTObjectMode();
            }
            case 13: {
                return pSSFPluginBase.getRTObjectName();
            }
            case 14: {
                return pSSFPluginBase.getRTObjectRepo();
            }
            case 15: {
                return pSSFPluginBase.getStudioIcon();
            }
            case 16: {
                return pSSFPluginBase.getUpdateDate();
            }
            case 17: {
                return pSSFPluginBase.getUpdateMan();
            }
            case 18: {
                return pSSFPluginBase.getValidFlag();
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
        PSSFPluginBase.set(this, n, object);
    }

    private static void set(PSSFPluginBase pSSFPluginBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSFPluginBase.setAllDCFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSSFPluginBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSFPluginBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSFPluginBase.setKeywords(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSFPluginBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSFPluginBase.setParamDesc(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSFPluginBase.setPluginType(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSFPluginBase.setPreviewHtml(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSFPluginBase.setPSDCId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSFPluginBase.setPSDCName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSFPluginBase.setPSSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSFPluginBase.setPSSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSFPluginBase.setRTObjectMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSSFPluginBase.setRTObjectName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSFPluginBase.setRTObjectRepo(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSFPluginBase.setStudioIcon(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSFPluginBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 17: {
                pSSFPluginBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSFPluginBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSFPluginBase.isNull(this, n);
    }

    private static boolean isNull(PSSFPluginBase pSSFPluginBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFPluginBase.getAllDCFlag() == null;
            }
            case 1: {
                return pSSFPluginBase.getCreateDate() == null;
            }
            case 2: {
                return pSSFPluginBase.getCreateMan() == null;
            }
            case 3: {
                return pSSFPluginBase.getKeywords() == null;
            }
            case 4: {
                return pSSFPluginBase.getMemo() == null;
            }
            case 5: {
                return pSSFPluginBase.getParamDesc() == null;
            }
            case 6: {
                return pSSFPluginBase.getPluginType() == null;
            }
            case 7: {
                return pSSFPluginBase.getPreviewHtml() == null;
            }
            case 8: {
                return pSSFPluginBase.getPSDCId() == null;
            }
            case 9: {
                return pSSFPluginBase.getPSDCName() == null;
            }
            case 10: {
                return pSSFPluginBase.getPSSFPluginId() == null;
            }
            case 11: {
                return pSSFPluginBase.getPSSFPluginName() == null;
            }
            case 12: {
                return pSSFPluginBase.getRTObjectMode() == null;
            }
            case 13: {
                return pSSFPluginBase.getRTObjectName() == null;
            }
            case 14: {
                return pSSFPluginBase.getRTObjectRepo() == null;
            }
            case 15: {
                return pSSFPluginBase.getStudioIcon() == null;
            }
            case 16: {
                return pSSFPluginBase.getUpdateDate() == null;
            }
            case 17: {
                return pSSFPluginBase.getUpdateMan() == null;
            }
            case 18: {
                return pSSFPluginBase.getValidFlag() == null;
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
        return PSSFPluginBase.contains(this, n);
    }

    private static boolean contains(PSSFPluginBase pSSFPluginBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFPluginBase.isAllDCFlagDirty();
            }
            case 1: {
                return pSSFPluginBase.isCreateDateDirty();
            }
            case 2: {
                return pSSFPluginBase.isCreateManDirty();
            }
            case 3: {
                return pSSFPluginBase.isKeywordsDirty();
            }
            case 4: {
                return pSSFPluginBase.isMemoDirty();
            }
            case 5: {
                return pSSFPluginBase.isParamDescDirty();
            }
            case 6: {
                return pSSFPluginBase.isPluginTypeDirty();
            }
            case 7: {
                return pSSFPluginBase.isPreviewHtmlDirty();
            }
            case 8: {
                return pSSFPluginBase.isPSDCIdDirty();
            }
            case 9: {
                return pSSFPluginBase.isPSDCNameDirty();
            }
            case 10: {
                return pSSFPluginBase.isPSSFPluginIdDirty();
            }
            case 11: {
                return pSSFPluginBase.isPSSFPluginNameDirty();
            }
            case 12: {
                return pSSFPluginBase.isRTObjectModeDirty();
            }
            case 13: {
                return pSSFPluginBase.isRTObjectNameDirty();
            }
            case 14: {
                return pSSFPluginBase.isRTObjectRepoDirty();
            }
            case 15: {
                return pSSFPluginBase.isStudioIconDirty();
            }
            case 16: {
                return pSSFPluginBase.isUpdateDateDirty();
            }
            case 17: {
                return pSSFPluginBase.isUpdateManDirty();
            }
            case 18: {
                return pSSFPluginBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSFPluginBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSFPluginBase pSSFPluginBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSFPluginBase.getAllDCFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"alldcflag", (Object)PSSFPluginBase.getJSONValue((Object)pSSFPluginBase.getAllDCFlag()), (boolean)false);
        }
        if (bl || pSSFPluginBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSFPluginBase.getJSONValue((Object)pSSFPluginBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSFPluginBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSFPluginBase.getJSONValue((Object)pSSFPluginBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSFPluginBase.getKeywords() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"keywords", (Object)PSSFPluginBase.getJSONValue((Object)pSSFPluginBase.getKeywords()), (boolean)false);
        }
        if (bl || pSSFPluginBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSFPluginBase.getJSONValue((Object)pSSFPluginBase.getMemo()), (boolean)false);
        }
        if (bl || pSSFPluginBase.getParamDesc() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"paramdesc", (Object)PSSFPluginBase.getJSONValue((Object)pSSFPluginBase.getParamDesc()), (boolean)false);
        }
        if (bl || pSSFPluginBase.getPluginType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"plugintype", (Object)PSSFPluginBase.getJSONValue((Object)pSSFPluginBase.getPluginType()), (boolean)false);
        }
        if (bl || pSSFPluginBase.getPreviewHtml() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"previewhtml", (Object)PSSFPluginBase.getJSONValue((Object)pSSFPluginBase.getPreviewHtml()), (boolean)false);
        }
        if (bl || pSSFPluginBase.getPSDCId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcid", (Object)PSSFPluginBase.getJSONValue((Object)pSSFPluginBase.getPSDCId()), (boolean)false);
        }
        if (bl || pSSFPluginBase.getPSDCName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcname", (Object)PSSFPluginBase.getJSONValue((Object)pSSFPluginBase.getPSDCName()), (boolean)false);
        }
        if (bl || pSSFPluginBase.getPSSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfpluginid", (Object)PSSFPluginBase.getJSONValue((Object)pSSFPluginBase.getPSSFPluginId()), (boolean)false);
        }
        if (bl || pSSFPluginBase.getPSSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfpluginname", (Object)PSSFPluginBase.getJSONValue((Object)pSSFPluginBase.getPSSFPluginName()), (boolean)false);
        }
        if (bl || pSSFPluginBase.getRTObjectMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rtobjectmode", (Object)PSSFPluginBase.getJSONValue((Object)pSSFPluginBase.getRTObjectMode()), (boolean)false);
        }
        if (bl || pSSFPluginBase.getRTObjectName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rtobjectname", (Object)PSSFPluginBase.getJSONValue((Object)pSSFPluginBase.getRTObjectName()), (boolean)false);
        }
        if (bl || pSSFPluginBase.getRTObjectRepo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rtobjectrepo", (Object)PSSFPluginBase.getJSONValue((Object)pSSFPluginBase.getRTObjectRepo()), (boolean)false);
        }
        if (bl || pSSFPluginBase.getStudioIcon() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"studioicon", (Object)PSSFPluginBase.getJSONValue((Object)pSSFPluginBase.getStudioIcon()), (boolean)false);
        }
        if (bl || pSSFPluginBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSFPluginBase.getJSONValue((Object)pSSFPluginBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSFPluginBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSFPluginBase.getJSONValue((Object)pSSFPluginBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSFPluginBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSFPluginBase.getJSONValue((Object)pSSFPluginBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSFPluginBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSFPluginBase pSSFPluginBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSFPluginBase.getAllDCFlag() != null) {
            object = pSSFPluginBase.getAllDCFlag();
            xmlNode.setAttribute(FIELD_ALLDCFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSFPluginBase.getCreateDate() != null) {
            object = pSSFPluginBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSFPluginBase.getCreateMan() != null) {
            object = pSSFPluginBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSFPluginBase.getKeywords() != null) {
            object = pSSFPluginBase.getKeywords();
            xmlNode.setAttribute(FIELD_KEYWORDS, object == null ? "" : (String)object);
        }
        if (bl || pSSFPluginBase.getMemo() != null) {
            object = pSSFPluginBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSFPluginBase.getParamDesc() != null) {
            object = pSSFPluginBase.getParamDesc();
            xmlNode.setAttribute(FIELD_PARAMDESC, object == null ? "" : (String)object);
        }
        if (bl || pSSFPluginBase.getPluginType() != null) {
            object = pSSFPluginBase.getPluginType();
            xmlNode.setAttribute(FIELD_PLUGINTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSFPluginBase.getPreviewHtml() != null) {
            object = pSSFPluginBase.getPreviewHtml();
            xmlNode.setAttribute(FIELD_PREVIEWHTML, object == null ? "" : (String)object);
        }
        if (bl || pSSFPluginBase.getPSDCId() != null) {
            object = pSSFPluginBase.getPSDCId();
            xmlNode.setAttribute(FIELD_PSDCID, object == null ? "" : (String)object);
        }
        if (bl || pSSFPluginBase.getPSDCName() != null) {
            object = pSSFPluginBase.getPSDCName();
            xmlNode.setAttribute(FIELD_PSDCNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFPluginBase.getPSSFPluginId() != null) {
            object = pSSFPluginBase.getPSSFPluginId();
            xmlNode.setAttribute(FIELD_PSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSFPluginBase.getPSSFPluginName() != null) {
            object = pSSFPluginBase.getPSSFPluginName();
            xmlNode.setAttribute(FIELD_PSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFPluginBase.getRTObjectMode() != null) {
            object = pSSFPluginBase.getRTObjectMode();
            xmlNode.setAttribute(FIELD_RTOBJECTMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSFPluginBase.getRTObjectName() != null) {
            object = pSSFPluginBase.getRTObjectName();
            xmlNode.setAttribute(FIELD_RTOBJECTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFPluginBase.getRTObjectRepo() != null) {
            object = pSSFPluginBase.getRTObjectRepo();
            xmlNode.setAttribute(FIELD_RTOBJECTREPO, object == null ? "" : (String)object);
        }
        if (bl || pSSFPluginBase.getStudioIcon() != null) {
            object = pSSFPluginBase.getStudioIcon();
            xmlNode.setAttribute(FIELD_STUDIOICON, object == null ? "" : (String)object);
        }
        if (bl || pSSFPluginBase.getUpdateDate() != null) {
            object = pSSFPluginBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSFPluginBase.getUpdateMan() != null) {
            object = pSSFPluginBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSFPluginBase.getValidFlag() != null) {
            object = pSSFPluginBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSFPluginBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSFPluginBase pSSFPluginBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSFPluginBase.isAllDCFlagDirty() && (bl || pSSFPluginBase.getAllDCFlag() != null)) {
            iDataObject.set(FIELD_ALLDCFLAG, (Object)pSSFPluginBase.getAllDCFlag());
        }
        if (pSSFPluginBase.isCreateDateDirty() && (bl || pSSFPluginBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSFPluginBase.getCreateDate());
        }
        if (pSSFPluginBase.isCreateManDirty() && (bl || pSSFPluginBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSFPluginBase.getCreateMan());
        }
        if (pSSFPluginBase.isKeywordsDirty() && (bl || pSSFPluginBase.getKeywords() != null)) {
            iDataObject.set(FIELD_KEYWORDS, (Object)pSSFPluginBase.getKeywords());
        }
        if (pSSFPluginBase.isMemoDirty() && (bl || pSSFPluginBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSFPluginBase.getMemo());
        }
        if (pSSFPluginBase.isParamDescDirty() && (bl || pSSFPluginBase.getParamDesc() != null)) {
            iDataObject.set(FIELD_PARAMDESC, (Object)pSSFPluginBase.getParamDesc());
        }
        if (pSSFPluginBase.isPluginTypeDirty() && (bl || pSSFPluginBase.getPluginType() != null)) {
            iDataObject.set(FIELD_PLUGINTYPE, (Object)pSSFPluginBase.getPluginType());
        }
        if (pSSFPluginBase.isPreviewHtmlDirty() && (bl || pSSFPluginBase.getPreviewHtml() != null)) {
            iDataObject.set(FIELD_PREVIEWHTML, (Object)pSSFPluginBase.getPreviewHtml());
        }
        if (pSSFPluginBase.isPSDCIdDirty() && (bl || pSSFPluginBase.getPSDCId() != null)) {
            iDataObject.set(FIELD_PSDCID, (Object)pSSFPluginBase.getPSDCId());
        }
        if (pSSFPluginBase.isPSDCNameDirty() && (bl || pSSFPluginBase.getPSDCName() != null)) {
            iDataObject.set(FIELD_PSDCNAME, (Object)pSSFPluginBase.getPSDCName());
        }
        if (pSSFPluginBase.isPSSFPluginIdDirty() && (bl || pSSFPluginBase.getPSSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSFPLUGINID, (Object)pSSFPluginBase.getPSSFPluginId());
        }
        if (pSSFPluginBase.isPSSFPluginNameDirty() && (bl || pSSFPluginBase.getPSSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSFPLUGINNAME, (Object)pSSFPluginBase.getPSSFPluginName());
        }
        if (pSSFPluginBase.isRTObjectModeDirty() && (bl || pSSFPluginBase.getRTObjectMode() != null)) {
            iDataObject.set(FIELD_RTOBJECTMODE, (Object)pSSFPluginBase.getRTObjectMode());
        }
        if (pSSFPluginBase.isRTObjectNameDirty() && (bl || pSSFPluginBase.getRTObjectName() != null)) {
            iDataObject.set(FIELD_RTOBJECTNAME, (Object)pSSFPluginBase.getRTObjectName());
        }
        if (pSSFPluginBase.isRTObjectRepoDirty() && (bl || pSSFPluginBase.getRTObjectRepo() != null)) {
            iDataObject.set(FIELD_RTOBJECTREPO, (Object)pSSFPluginBase.getRTObjectRepo());
        }
        if (pSSFPluginBase.isStudioIconDirty() && (bl || pSSFPluginBase.getStudioIcon() != null)) {
            iDataObject.set(FIELD_STUDIOICON, (Object)pSSFPluginBase.getStudioIcon());
        }
        if (pSSFPluginBase.isUpdateDateDirty() && (bl || pSSFPluginBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSFPluginBase.getUpdateDate());
        }
        if (pSSFPluginBase.isUpdateManDirty() && (bl || pSSFPluginBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSFPluginBase.getUpdateMan());
        }
        if (pSSFPluginBase.isValidFlagDirty() && (bl || pSSFPluginBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSFPluginBase.getValidFlag());
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
        return PSSFPluginBase.remove(this, n);
    }

    private static boolean remove(PSSFPluginBase pSSFPluginBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSFPluginBase.resetAllDCFlag();
                return true;
            }
            case 1: {
                pSSFPluginBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSFPluginBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSFPluginBase.resetKeywords();
                return true;
            }
            case 4: {
                pSSFPluginBase.resetMemo();
                return true;
            }
            case 5: {
                pSSFPluginBase.resetParamDesc();
                return true;
            }
            case 6: {
                pSSFPluginBase.resetPluginType();
                return true;
            }
            case 7: {
                pSSFPluginBase.resetPreviewHtml();
                return true;
            }
            case 8: {
                pSSFPluginBase.resetPSDCId();
                return true;
            }
            case 9: {
                pSSFPluginBase.resetPSDCName();
                return true;
            }
            case 10: {
                pSSFPluginBase.resetPSSFPluginId();
                return true;
            }
            case 11: {
                pSSFPluginBase.resetPSSFPluginName();
                return true;
            }
            case 12: {
                pSSFPluginBase.resetRTObjectMode();
                return true;
            }
            case 13: {
                pSSFPluginBase.resetRTObjectName();
                return true;
            }
            case 14: {
                pSSFPluginBase.resetRTObjectRepo();
                return true;
            }
            case 15: {
                pSSFPluginBase.resetStudioIcon();
                return true;
            }
            case 16: {
                pSSFPluginBase.resetUpdateDate();
                return true;
            }
            case 17: {
                pSSFPluginBase.resetUpdateMan();
                return true;
            }
            case 18: {
                pSSFPluginBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenter getPSDC() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDC();
        }
        if (this.getPSDCId() == null) {
            return null;
        }
        Integer n = this.objPSDCLock;
        synchronized (n) {
            if (this.psdc != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCId(), (Object)this.psdc.getPSDevCenterId()) != 0L) {
                this.psdc = null;
            }
            if (this.psdc == null) {
                PSDevCenter pSDevCenter = new PSDevCenter();
                pSDevCenter.setPSDevCenterId(this.getPSDCId());
                PSDevCenterService pSDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterService.autoGet((IEntity)pSDevCenter);
                this.psdc = pSDevCenter;
            }
            return this.psdc;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSFPluginTempl> getPSSFPluginTempls() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFPluginTempls();
        }
        if (this.getPSSFPluginId() == null) {
            return null;
        }
        PSSFPluginTemplService pSSFPluginTemplService = (PSSFPluginTemplService)ServiceGlobal.getService(PSSFPluginTemplService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSFPluginTemplsLock;
        synchronized (n) {
            if (this.pssfplugintempls == null) {
                this.pssfplugintempls = pSSFPluginTemplService.selectByPSSFPlugin(this);
            }
            return this.pssfplugintempls;
        }
    }

    private PSSFPluginBase getProxyEntity() {
        return this.proxyPSSFPluginBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSFPluginBase = null;
        if (iDataObject != null && iDataObject instanceof PSSFPluginBase) {
            this.proxyPSSFPluginBase = (PSSFPluginBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFPluginService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ALLDCFLAG, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_KEYWORDS, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PARAMDESC, 5);
        fieldIndexMap.put(FIELD_PLUGINTYPE, 6);
        fieldIndexMap.put(FIELD_PREVIEWHTML, 7);
        fieldIndexMap.put(FIELD_PSDCID, 8);
        fieldIndexMap.put(FIELD_PSDCNAME, 9);
        fieldIndexMap.put(FIELD_PSSFPLUGINID, 10);
        fieldIndexMap.put(FIELD_PSSFPLUGINNAME, 11);
        fieldIndexMap.put(FIELD_RTOBJECTMODE, 12);
        fieldIndexMap.put(FIELD_RTOBJECTNAME, 13);
        fieldIndexMap.put(FIELD_RTOBJECTREPO, 14);
        fieldIndexMap.put(FIELD_STUDIOICON, 15);
        fieldIndexMap.put(FIELD_UPDATEDATE, 16);
        fieldIndexMap.put(FIELD_UPDATEMAN, 17);
        fieldIndexMap.put(FIELD_VALIDFLAG, 18);
    }
}

