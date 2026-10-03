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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSPFPluginBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSPFPluginBase.class);
    public static final String FIELD_ALLDCFLAG = "ALLDCFLAG";
    public static final String FIELD_BASECLSPARAMS = "BASECLSPARAMS";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_KEYWORDS = "KEYWORDS";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PLUGINDESC = "PLUGINDESC";
    public static final String FIELD_PLUGINTYPE = "PLUGINTYPE";
    public static final String FIELD_PREVIEWHTML = "PREVIEWHTML";
    public static final String FIELD_PREVIEWPSNDFILEID = "PREVIEWPSNDFILEID";
    public static final String FIELD_PREVIEWURL = "PREVIEWURL";
    public static final String FIELD_PSDCID = "PSDCID";
    public static final String FIELD_PSDCNAME = "PSDCNAME";
    public static final String FIELD_PSPFPLUGINID = "PSPFPLUGINID";
    public static final String FIELD_PSPFPLUGINNAME = "PSPFPLUGINNAME";
    public static final String FIELD_RTOBJECTMODE = "RTOBJECTMODE";
    public static final String FIELD_RTOBJECTNAME = "RTOBJECTNAME";
    public static final String FIELD_RTOBJECTREPO = "RTOBJECTREPO";
    public static final String FIELD_STUDIOICON = "STUDIOICON";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_ALLDCFLAG = 0;
    private static final int INDEX_BASECLSPARAMS = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_KEYWORDS = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_PLUGINDESC = 6;
    private static final int INDEX_PLUGINTYPE = 7;
    private static final int INDEX_PREVIEWHTML = 8;
    private static final int INDEX_PREVIEWPSNDFILEID = 9;
    private static final int INDEX_PREVIEWURL = 10;
    private static final int INDEX_PSDCID = 11;
    private static final int INDEX_PSDCNAME = 12;
    private static final int INDEX_PSPFPLUGINID = 13;
    private static final int INDEX_PSPFPLUGINNAME = 14;
    private static final int INDEX_RTOBJECTMODE = 15;
    private static final int INDEX_RTOBJECTNAME = 16;
    private static final int INDEX_RTOBJECTREPO = 17;
    private static final int INDEX_STUDIOICON = 18;
    private static final int INDEX_UPDATEDATE = 19;
    private static final int INDEX_UPDATEMAN = 20;
    private static final int INDEX_VALIDFLAG = 21;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSPFPluginBase proxyPSPFPluginBase = null;
    private boolean alldcflagDirtyFlag = false;
    private boolean baseclsparamsDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean keywordsDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean plugindescDirtyFlag = false;
    private boolean plugintypeDirtyFlag = false;
    private boolean previewhtmlDirtyFlag = false;
    private boolean previewpsndfileidDirtyFlag = false;
    private boolean previewurlDirtyFlag = false;
    private boolean psdcidDirtyFlag = false;
    private boolean psdcnameDirtyFlag = false;
    private boolean pspfpluginidDirtyFlag = false;
    private boolean pspfpluginnameDirtyFlag = false;
    private boolean rtobjectmodeDirtyFlag = false;
    private boolean rtobjectnameDirtyFlag = false;
    private boolean rtobjectrepoDirtyFlag = false;
    private boolean studioiconDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="alldcflag")
    private Integer alldcflag;
    @Column(name="baseclsparams")
    private String baseclsparams;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="keywords")
    private String keywords;
    @Column(name="memo")
    private String memo;
    @Column(name="plugindesc")
    private String plugindesc;
    @Column(name="plugintype")
    private String plugintype;
    @Column(name="previewhtml")
    private String previewhtml;
    @Column(name="previewpsndfileid")
    private String previewpsndfileid;
    @Column(name="previewurl")
    private String previewurl;
    @Column(name="psdcid")
    private String psdcid;
    @Column(name="psdcname")
    private String psdcname;
    @Column(name="pspfpluginid")
    private String pspfpluginid;
    @Column(name="pspfpluginname")
    private String pspfpluginname;
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

    public void setBaseClsParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBaseClsParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.baseclsparams = string;
        this.baseclsparamsDirtyFlag = true;
    }

    public String getBaseClsParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBaseClsParams();
        }
        return this.baseclsparams;
    }

    public boolean isBaseClsParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBaseClsParamsDirty();
        }
        return this.baseclsparamsDirtyFlag;
    }

    public void resetBaseClsParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBaseClsParams();
            return;
        }
        this.baseclsparamsDirtyFlag = false;
        this.baseclsparams = null;
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
        PSPFPluginBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSPFPluginBase pSPFPluginBase) {
        pSPFPluginBase.resetAllDCFlag();
        pSPFPluginBase.resetBaseClsParams();
        pSPFPluginBase.resetCreateDate();
        pSPFPluginBase.resetCreateMan();
        pSPFPluginBase.resetKeywords();
        pSPFPluginBase.resetMemo();
        pSPFPluginBase.resetPluginDesc();
        pSPFPluginBase.resetPluginType();
        pSPFPluginBase.resetPreviewHtml();
        pSPFPluginBase.resetPreviewPSNDFileId();
        pSPFPluginBase.resetPreviewUrl();
        pSPFPluginBase.resetPSDCId();
        pSPFPluginBase.resetPSDCName();
        pSPFPluginBase.resetPSPFPluginId();
        pSPFPluginBase.resetPSPFPluginName();
        pSPFPluginBase.resetRTObjectMode();
        pSPFPluginBase.resetRTObjectName();
        pSPFPluginBase.resetRTObjectRepo();
        pSPFPluginBase.resetStudioIcon();
        pSPFPluginBase.resetUpdateDate();
        pSPFPluginBase.resetUpdateMan();
        pSPFPluginBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAllDCFlagDirty()) {
            hashMap.put(FIELD_ALLDCFLAG, this.getAllDCFlag());
        }
        if (!bl || this.isBaseClsParamsDirty()) {
            hashMap.put(FIELD_BASECLSPARAMS, this.getBaseClsParams());
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
        if (!bl || this.isPluginDescDirty()) {
            hashMap.put(FIELD_PLUGINDESC, this.getPluginDesc());
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
        if (!bl || this.isPSDCIdDirty()) {
            hashMap.put(FIELD_PSDCID, this.getPSDCId());
        }
        if (!bl || this.isPSDCNameDirty()) {
            hashMap.put(FIELD_PSDCNAME, this.getPSDCName());
        }
        if (!bl || this.isPSPFPluginIdDirty()) {
            hashMap.put(FIELD_PSPFPLUGINID, this.getPSPFPluginId());
        }
        if (!bl || this.isPSPFPluginNameDirty()) {
            hashMap.put(FIELD_PSPFPLUGINNAME, this.getPSPFPluginName());
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
        return PSPFPluginBase.get(this, n);
    }

    private static Object get(PSPFPluginBase pSPFPluginBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFPluginBase.getAllDCFlag();
            }
            case 1: {
                return pSPFPluginBase.getBaseClsParams();
            }
            case 2: {
                return pSPFPluginBase.getCreateDate();
            }
            case 3: {
                return pSPFPluginBase.getCreateMan();
            }
            case 4: {
                return pSPFPluginBase.getKeywords();
            }
            case 5: {
                return pSPFPluginBase.getMemo();
            }
            case 6: {
                return pSPFPluginBase.getPluginDesc();
            }
            case 7: {
                return pSPFPluginBase.getPluginType();
            }
            case 8: {
                return pSPFPluginBase.getPreviewHtml();
            }
            case 9: {
                return pSPFPluginBase.getPreviewPSNDFileId();
            }
            case 10: {
                return pSPFPluginBase.getPreviewUrl();
            }
            case 11: {
                return pSPFPluginBase.getPSDCId();
            }
            case 12: {
                return pSPFPluginBase.getPSDCName();
            }
            case 13: {
                return pSPFPluginBase.getPSPFPluginId();
            }
            case 14: {
                return pSPFPluginBase.getPSPFPluginName();
            }
            case 15: {
                return pSPFPluginBase.getRTObjectMode();
            }
            case 16: {
                return pSPFPluginBase.getRTObjectName();
            }
            case 17: {
                return pSPFPluginBase.getRTObjectRepo();
            }
            case 18: {
                return pSPFPluginBase.getStudioIcon();
            }
            case 19: {
                return pSPFPluginBase.getUpdateDate();
            }
            case 20: {
                return pSPFPluginBase.getUpdateMan();
            }
            case 21: {
                return pSPFPluginBase.getValidFlag();
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
        PSPFPluginBase.set(this, n, object);
    }

    private static void set(PSPFPluginBase pSPFPluginBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSPFPluginBase.setAllDCFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSPFPluginBase.setBaseClsParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSPFPluginBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSPFPluginBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSPFPluginBase.setKeywords(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSPFPluginBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSPFPluginBase.setPluginDesc(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSPFPluginBase.setPluginType(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSPFPluginBase.setPreviewHtml(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSPFPluginBase.setPreviewPSNDFileId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSPFPluginBase.setPreviewUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSPFPluginBase.setPSDCId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSPFPluginBase.setPSDCName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSPFPluginBase.setPSPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSPFPluginBase.setPSPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSPFPluginBase.setRTObjectMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSPFPluginBase.setRTObjectName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSPFPluginBase.setRTObjectRepo(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSPFPluginBase.setStudioIcon(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSPFPluginBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 20: {
                pSPFPluginBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSPFPluginBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSPFPluginBase.isNull(this, n);
    }

    private static boolean isNull(PSPFPluginBase pSPFPluginBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFPluginBase.getAllDCFlag() == null;
            }
            case 1: {
                return pSPFPluginBase.getBaseClsParams() == null;
            }
            case 2: {
                return pSPFPluginBase.getCreateDate() == null;
            }
            case 3: {
                return pSPFPluginBase.getCreateMan() == null;
            }
            case 4: {
                return pSPFPluginBase.getKeywords() == null;
            }
            case 5: {
                return pSPFPluginBase.getMemo() == null;
            }
            case 6: {
                return pSPFPluginBase.getPluginDesc() == null;
            }
            case 7: {
                return pSPFPluginBase.getPluginType() == null;
            }
            case 8: {
                return pSPFPluginBase.getPreviewHtml() == null;
            }
            case 9: {
                return pSPFPluginBase.getPreviewPSNDFileId() == null;
            }
            case 10: {
                return pSPFPluginBase.getPreviewUrl() == null;
            }
            case 11: {
                return pSPFPluginBase.getPSDCId() == null;
            }
            case 12: {
                return pSPFPluginBase.getPSDCName() == null;
            }
            case 13: {
                return pSPFPluginBase.getPSPFPluginId() == null;
            }
            case 14: {
                return pSPFPluginBase.getPSPFPluginName() == null;
            }
            case 15: {
                return pSPFPluginBase.getRTObjectMode() == null;
            }
            case 16: {
                return pSPFPluginBase.getRTObjectName() == null;
            }
            case 17: {
                return pSPFPluginBase.getRTObjectRepo() == null;
            }
            case 18: {
                return pSPFPluginBase.getStudioIcon() == null;
            }
            case 19: {
                return pSPFPluginBase.getUpdateDate() == null;
            }
            case 20: {
                return pSPFPluginBase.getUpdateMan() == null;
            }
            case 21: {
                return pSPFPluginBase.getValidFlag() == null;
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
        return PSPFPluginBase.contains(this, n);
    }

    private static boolean contains(PSPFPluginBase pSPFPluginBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFPluginBase.isAllDCFlagDirty();
            }
            case 1: {
                return pSPFPluginBase.isBaseClsParamsDirty();
            }
            case 2: {
                return pSPFPluginBase.isCreateDateDirty();
            }
            case 3: {
                return pSPFPluginBase.isCreateManDirty();
            }
            case 4: {
                return pSPFPluginBase.isKeywordsDirty();
            }
            case 5: {
                return pSPFPluginBase.isMemoDirty();
            }
            case 6: {
                return pSPFPluginBase.isPluginDescDirty();
            }
            case 7: {
                return pSPFPluginBase.isPluginTypeDirty();
            }
            case 8: {
                return pSPFPluginBase.isPreviewHtmlDirty();
            }
            case 9: {
                return pSPFPluginBase.isPreviewPSNDFileIdDirty();
            }
            case 10: {
                return pSPFPluginBase.isPreviewUrlDirty();
            }
            case 11: {
                return pSPFPluginBase.isPSDCIdDirty();
            }
            case 12: {
                return pSPFPluginBase.isPSDCNameDirty();
            }
            case 13: {
                return pSPFPluginBase.isPSPFPluginIdDirty();
            }
            case 14: {
                return pSPFPluginBase.isPSPFPluginNameDirty();
            }
            case 15: {
                return pSPFPluginBase.isRTObjectModeDirty();
            }
            case 16: {
                return pSPFPluginBase.isRTObjectNameDirty();
            }
            case 17: {
                return pSPFPluginBase.isRTObjectRepoDirty();
            }
            case 18: {
                return pSPFPluginBase.isStudioIconDirty();
            }
            case 19: {
                return pSPFPluginBase.isUpdateDateDirty();
            }
            case 20: {
                return pSPFPluginBase.isUpdateManDirty();
            }
            case 21: {
                return pSPFPluginBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSPFPluginBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSPFPluginBase pSPFPluginBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSPFPluginBase.getAllDCFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"alldcflag", (Object)PSPFPluginBase.getJSONValue((Object)pSPFPluginBase.getAllDCFlag()), (boolean)false);
        }
        if (bl || pSPFPluginBase.getBaseClsParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"baseclsparams", (Object)PSPFPluginBase.getJSONValue((Object)pSPFPluginBase.getBaseClsParams()), (boolean)false);
        }
        if (bl || pSPFPluginBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSPFPluginBase.getJSONValue((Object)pSPFPluginBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSPFPluginBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSPFPluginBase.getJSONValue((Object)pSPFPluginBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSPFPluginBase.getKeywords() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"keywords", (Object)PSPFPluginBase.getJSONValue((Object)pSPFPluginBase.getKeywords()), (boolean)false);
        }
        if (bl || pSPFPluginBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSPFPluginBase.getJSONValue((Object)pSPFPluginBase.getMemo()), (boolean)false);
        }
        if (bl || pSPFPluginBase.getPluginDesc() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"plugindesc", (Object)PSPFPluginBase.getJSONValue((Object)pSPFPluginBase.getPluginDesc()), (boolean)false);
        }
        if (bl || pSPFPluginBase.getPluginType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"plugintype", (Object)PSPFPluginBase.getJSONValue((Object)pSPFPluginBase.getPluginType()), (boolean)false);
        }
        if (bl || pSPFPluginBase.getPreviewHtml() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"previewhtml", (Object)PSPFPluginBase.getJSONValue((Object)pSPFPluginBase.getPreviewHtml()), (boolean)false);
        }
        if (bl || pSPFPluginBase.getPreviewPSNDFileId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"previewpsndfileid", (Object)PSPFPluginBase.getJSONValue((Object)pSPFPluginBase.getPreviewPSNDFileId()), (boolean)false);
        }
        if (bl || pSPFPluginBase.getPreviewUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"previewurl", (Object)PSPFPluginBase.getJSONValue((Object)pSPFPluginBase.getPreviewUrl()), (boolean)false);
        }
        if (bl || pSPFPluginBase.getPSDCId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcid", (Object)PSPFPluginBase.getJSONValue((Object)pSPFPluginBase.getPSDCId()), (boolean)false);
        }
        if (bl || pSPFPluginBase.getPSDCName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcname", (Object)PSPFPluginBase.getJSONValue((Object)pSPFPluginBase.getPSDCName()), (boolean)false);
        }
        if (bl || pSPFPluginBase.getPSPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpluginid", (Object)PSPFPluginBase.getJSONValue((Object)pSPFPluginBase.getPSPFPluginId()), (boolean)false);
        }
        if (bl || pSPFPluginBase.getPSPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpluginname", (Object)PSPFPluginBase.getJSONValue((Object)pSPFPluginBase.getPSPFPluginName()), (boolean)false);
        }
        if (bl || pSPFPluginBase.getRTObjectMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rtobjectmode", (Object)PSPFPluginBase.getJSONValue((Object)pSPFPluginBase.getRTObjectMode()), (boolean)false);
        }
        if (bl || pSPFPluginBase.getRTObjectName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rtobjectname", (Object)PSPFPluginBase.getJSONValue((Object)pSPFPluginBase.getRTObjectName()), (boolean)false);
        }
        if (bl || pSPFPluginBase.getRTObjectRepo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rtobjectrepo", (Object)PSPFPluginBase.getJSONValue((Object)pSPFPluginBase.getRTObjectRepo()), (boolean)false);
        }
        if (bl || pSPFPluginBase.getStudioIcon() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"studioicon", (Object)PSPFPluginBase.getJSONValue((Object)pSPFPluginBase.getStudioIcon()), (boolean)false);
        }
        if (bl || pSPFPluginBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSPFPluginBase.getJSONValue((Object)pSPFPluginBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSPFPluginBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSPFPluginBase.getJSONValue((Object)pSPFPluginBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSPFPluginBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSPFPluginBase.getJSONValue((Object)pSPFPluginBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSPFPluginBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSPFPluginBase pSPFPluginBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSPFPluginBase.getAllDCFlag() != null) {
            object = pSPFPluginBase.getAllDCFlag();
            xmlNode.setAttribute(FIELD_ALLDCFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPFPluginBase.getBaseClsParams() != null) {
            object = pSPFPluginBase.getBaseClsParams();
            xmlNode.setAttribute(FIELD_BASECLSPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSPFPluginBase.getCreateDate() != null) {
            object = pSPFPluginBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPFPluginBase.getCreateMan() != null) {
            object = pSPFPluginBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSPFPluginBase.getKeywords() != null) {
            object = pSPFPluginBase.getKeywords();
            xmlNode.setAttribute(FIELD_KEYWORDS, object == null ? "" : (String)object);
        }
        if (bl || pSPFPluginBase.getMemo() != null) {
            object = pSPFPluginBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSPFPluginBase.getPluginDesc() != null) {
            object = pSPFPluginBase.getPluginDesc();
            xmlNode.setAttribute(FIELD_PLUGINDESC, object == null ? "" : (String)object);
        }
        if (bl || pSPFPluginBase.getPluginType() != null) {
            object = pSPFPluginBase.getPluginType();
            xmlNode.setAttribute(FIELD_PLUGINTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSPFPluginBase.getPreviewHtml() != null) {
            object = pSPFPluginBase.getPreviewHtml();
            xmlNode.setAttribute(FIELD_PREVIEWHTML, object == null ? "" : (String)object);
        }
        if (bl || pSPFPluginBase.getPreviewPSNDFileId() != null) {
            object = pSPFPluginBase.getPreviewPSNDFileId();
            xmlNode.setAttribute(FIELD_PREVIEWPSNDFILEID, object == null ? "" : (String)object);
        }
        if (bl || pSPFPluginBase.getPreviewUrl() != null) {
            object = pSPFPluginBase.getPreviewUrl();
            xmlNode.setAttribute(FIELD_PREVIEWURL, object == null ? "" : (String)object);
        }
        if (bl || pSPFPluginBase.getPSDCId() != null) {
            object = pSPFPluginBase.getPSDCId();
            xmlNode.setAttribute(FIELD_PSDCID, object == null ? "" : (String)object);
        }
        if (bl || pSPFPluginBase.getPSDCName() != null) {
            object = pSPFPluginBase.getPSDCName();
            xmlNode.setAttribute(FIELD_PSDCNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFPluginBase.getPSPFPluginId() != null) {
            object = pSPFPluginBase.getPSPFPluginId();
            xmlNode.setAttribute(FIELD_PSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSPFPluginBase.getPSPFPluginName() != null) {
            object = pSPFPluginBase.getPSPFPluginName();
            xmlNode.setAttribute(FIELD_PSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFPluginBase.getRTObjectMode() != null) {
            object = pSPFPluginBase.getRTObjectMode();
            xmlNode.setAttribute(FIELD_RTOBJECTMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPFPluginBase.getRTObjectName() != null) {
            object = pSPFPluginBase.getRTObjectName();
            xmlNode.setAttribute(FIELD_RTOBJECTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFPluginBase.getRTObjectRepo() != null) {
            object = pSPFPluginBase.getRTObjectRepo();
            xmlNode.setAttribute(FIELD_RTOBJECTREPO, object == null ? "" : (String)object);
        }
        if (bl || pSPFPluginBase.getStudioIcon() != null) {
            object = pSPFPluginBase.getStudioIcon();
            xmlNode.setAttribute(FIELD_STUDIOICON, object == null ? "" : (String)object);
        }
        if (bl || pSPFPluginBase.getUpdateDate() != null) {
            object = pSPFPluginBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPFPluginBase.getUpdateMan() != null) {
            object = pSPFPluginBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSPFPluginBase.getValidFlag() != null) {
            object = pSPFPluginBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSPFPluginBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSPFPluginBase pSPFPluginBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSPFPluginBase.isAllDCFlagDirty() && (bl || pSPFPluginBase.getAllDCFlag() != null)) {
            iDataObject.set(FIELD_ALLDCFLAG, (Object)pSPFPluginBase.getAllDCFlag());
        }
        if (pSPFPluginBase.isBaseClsParamsDirty() && (bl || pSPFPluginBase.getBaseClsParams() != null)) {
            iDataObject.set(FIELD_BASECLSPARAMS, (Object)pSPFPluginBase.getBaseClsParams());
        }
        if (pSPFPluginBase.isCreateDateDirty() && (bl || pSPFPluginBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSPFPluginBase.getCreateDate());
        }
        if (pSPFPluginBase.isCreateManDirty() && (bl || pSPFPluginBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSPFPluginBase.getCreateMan());
        }
        if (pSPFPluginBase.isKeywordsDirty() && (bl || pSPFPluginBase.getKeywords() != null)) {
            iDataObject.set(FIELD_KEYWORDS, (Object)pSPFPluginBase.getKeywords());
        }
        if (pSPFPluginBase.isMemoDirty() && (bl || pSPFPluginBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSPFPluginBase.getMemo());
        }
        if (pSPFPluginBase.isPluginDescDirty() && (bl || pSPFPluginBase.getPluginDesc() != null)) {
            iDataObject.set(FIELD_PLUGINDESC, (Object)pSPFPluginBase.getPluginDesc());
        }
        if (pSPFPluginBase.isPluginTypeDirty() && (bl || pSPFPluginBase.getPluginType() != null)) {
            iDataObject.set(FIELD_PLUGINTYPE, (Object)pSPFPluginBase.getPluginType());
        }
        if (pSPFPluginBase.isPreviewHtmlDirty() && (bl || pSPFPluginBase.getPreviewHtml() != null)) {
            iDataObject.set(FIELD_PREVIEWHTML, (Object)pSPFPluginBase.getPreviewHtml());
        }
        if (pSPFPluginBase.isPreviewPSNDFileIdDirty() && (bl || pSPFPluginBase.getPreviewPSNDFileId() != null)) {
            iDataObject.set(FIELD_PREVIEWPSNDFILEID, (Object)pSPFPluginBase.getPreviewPSNDFileId());
        }
        if (pSPFPluginBase.isPreviewUrlDirty() && (bl || pSPFPluginBase.getPreviewUrl() != null)) {
            iDataObject.set(FIELD_PREVIEWURL, (Object)pSPFPluginBase.getPreviewUrl());
        }
        if (pSPFPluginBase.isPSDCIdDirty() && (bl || pSPFPluginBase.getPSDCId() != null)) {
            iDataObject.set(FIELD_PSDCID, (Object)pSPFPluginBase.getPSDCId());
        }
        if (pSPFPluginBase.isPSDCNameDirty() && (bl || pSPFPluginBase.getPSDCName() != null)) {
            iDataObject.set(FIELD_PSDCNAME, (Object)pSPFPluginBase.getPSDCName());
        }
        if (pSPFPluginBase.isPSPFPluginIdDirty() && (bl || pSPFPluginBase.getPSPFPluginId() != null)) {
            iDataObject.set(FIELD_PSPFPLUGINID, (Object)pSPFPluginBase.getPSPFPluginId());
        }
        if (pSPFPluginBase.isPSPFPluginNameDirty() && (bl || pSPFPluginBase.getPSPFPluginName() != null)) {
            iDataObject.set(FIELD_PSPFPLUGINNAME, (Object)pSPFPluginBase.getPSPFPluginName());
        }
        if (pSPFPluginBase.isRTObjectModeDirty() && (bl || pSPFPluginBase.getRTObjectMode() != null)) {
            iDataObject.set(FIELD_RTOBJECTMODE, (Object)pSPFPluginBase.getRTObjectMode());
        }
        if (pSPFPluginBase.isRTObjectNameDirty() && (bl || pSPFPluginBase.getRTObjectName() != null)) {
            iDataObject.set(FIELD_RTOBJECTNAME, (Object)pSPFPluginBase.getRTObjectName());
        }
        if (pSPFPluginBase.isRTObjectRepoDirty() && (bl || pSPFPluginBase.getRTObjectRepo() != null)) {
            iDataObject.set(FIELD_RTOBJECTREPO, (Object)pSPFPluginBase.getRTObjectRepo());
        }
        if (pSPFPluginBase.isStudioIconDirty() && (bl || pSPFPluginBase.getStudioIcon() != null)) {
            iDataObject.set(FIELD_STUDIOICON, (Object)pSPFPluginBase.getStudioIcon());
        }
        if (pSPFPluginBase.isUpdateDateDirty() && (bl || pSPFPluginBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSPFPluginBase.getUpdateDate());
        }
        if (pSPFPluginBase.isUpdateManDirty() && (bl || pSPFPluginBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSPFPluginBase.getUpdateMan());
        }
        if (pSPFPluginBase.isValidFlagDirty() && (bl || pSPFPluginBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSPFPluginBase.getValidFlag());
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
        return PSPFPluginBase.remove(this, n);
    }

    private static boolean remove(PSPFPluginBase pSPFPluginBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSPFPluginBase.resetAllDCFlag();
                return true;
            }
            case 1: {
                pSPFPluginBase.resetBaseClsParams();
                return true;
            }
            case 2: {
                pSPFPluginBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSPFPluginBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSPFPluginBase.resetKeywords();
                return true;
            }
            case 5: {
                pSPFPluginBase.resetMemo();
                return true;
            }
            case 6: {
                pSPFPluginBase.resetPluginDesc();
                return true;
            }
            case 7: {
                pSPFPluginBase.resetPluginType();
                return true;
            }
            case 8: {
                pSPFPluginBase.resetPreviewHtml();
                return true;
            }
            case 9: {
                pSPFPluginBase.resetPreviewPSNDFileId();
                return true;
            }
            case 10: {
                pSPFPluginBase.resetPreviewUrl();
                return true;
            }
            case 11: {
                pSPFPluginBase.resetPSDCId();
                return true;
            }
            case 12: {
                pSPFPluginBase.resetPSDCName();
                return true;
            }
            case 13: {
                pSPFPluginBase.resetPSPFPluginId();
                return true;
            }
            case 14: {
                pSPFPluginBase.resetPSPFPluginName();
                return true;
            }
            case 15: {
                pSPFPluginBase.resetRTObjectMode();
                return true;
            }
            case 16: {
                pSPFPluginBase.resetRTObjectName();
                return true;
            }
            case 17: {
                pSPFPluginBase.resetRTObjectRepo();
                return true;
            }
            case 18: {
                pSPFPluginBase.resetStudioIcon();
                return true;
            }
            case 19: {
                pSPFPluginBase.resetUpdateDate();
                return true;
            }
            case 20: {
                pSPFPluginBase.resetUpdateMan();
                return true;
            }
            case 21: {
                pSPFPluginBase.resetValidFlag();
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
                pSDevCenterService.autoGet(pSDevCenter);
                this.psdc = pSDevCenter;
            }
            return this.psdc;
        }
    }

    private PSPFPluginBase getProxyEntity() {
        return this.proxyPSPFPluginBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSPFPluginBase = null;
        if (iDataObject != null && iDataObject instanceof PSPFPluginBase) {
            this.proxyPSPFPluginBase = (PSPFPluginBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFPluginService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ALLDCFLAG, 0);
        fieldIndexMap.put(FIELD_BASECLSPARAMS, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_KEYWORDS, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_PLUGINDESC, 6);
        fieldIndexMap.put(FIELD_PLUGINTYPE, 7);
        fieldIndexMap.put(FIELD_PREVIEWHTML, 8);
        fieldIndexMap.put(FIELD_PREVIEWPSNDFILEID, 9);
        fieldIndexMap.put(FIELD_PREVIEWURL, 10);
        fieldIndexMap.put(FIELD_PSDCID, 11);
        fieldIndexMap.put(FIELD_PSDCNAME, 12);
        fieldIndexMap.put(FIELD_PSPFPLUGINID, 13);
        fieldIndexMap.put(FIELD_PSPFPLUGINNAME, 14);
        fieldIndexMap.put(FIELD_RTOBJECTMODE, 15);
        fieldIndexMap.put(FIELD_RTOBJECTNAME, 16);
        fieldIndexMap.put(FIELD_RTOBJECTREPO, 17);
        fieldIndexMap.put(FIELD_STUDIOICON, 18);
        fieldIndexMap.put(FIELD_UPDATEDATE, 19);
        fieldIndexMap.put(FIELD_UPDATEMAN, 20);
        fieldIndexMap.put(FIELD_VALIDFLAG, 21);
    }
}

