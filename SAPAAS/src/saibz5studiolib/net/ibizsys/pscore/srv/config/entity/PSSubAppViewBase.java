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
import net.ibizsys.pscore.srv.config.entity.PSSubApp;
import net.ibizsys.pscore.srv.config.entity.PSSubDEView;
import net.ibizsys.pscore.srv.config.service.PSSubAppService;
import net.ibizsys.pscore.srv.config.service.PSSubDEViewService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSubAppViewBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSubAppViewBase.class);
    public static final String FIELD_BACKENDURL = "BACKENDURL";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_FULLCODENAME = "FULLCODENAME";
    public static final String FIELD_MODULECODENAME = "MODULECODENAME";
    public static final String FIELD_MODULENAME = "MODULENAME";
    public static final String FIELD_PAGEURL = "PAGEURL";
    public static final String FIELD_PSAPPVIEWID = "PSAPPVIEWID";
    public static final String FIELD_PSDEVIEWBASEID = "PSDEVIEWBASEID";
    public static final String FIELD_PSSUBAPPID = "PSSUBAPPID";
    public static final String FIELD_PSSUBAPPNAME = "PSSUBAPPNAME";
    public static final String FIELD_PSSUBAPPVIEWID = "PSSUBAPPVIEWID";
    public static final String FIELD_PSSUBAPPVIEWNAME = "PSSUBAPPVIEWNAME";
    public static final String FIELD_PSSUBDEVIEWID = "PSSUBDEVIEWID";
    public static final String FIELD_PSSUBDEVIEWNAME = "PSSUBDEVIEWNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_BACKENDURL = 0;
    private static final int INDEX_CODENAME = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_FULLCODENAME = 4;
    private static final int INDEX_MODULECODENAME = 5;
    private static final int INDEX_MODULENAME = 6;
    private static final int INDEX_PAGEURL = 7;
    private static final int INDEX_PSAPPVIEWID = 8;
    private static final int INDEX_PSDEVIEWBASEID = 9;
    private static final int INDEX_PSSUBAPPID = 10;
    private static final int INDEX_PSSUBAPPNAME = 11;
    private static final int INDEX_PSSUBAPPVIEWID = 12;
    private static final int INDEX_PSSUBAPPVIEWNAME = 13;
    private static final int INDEX_PSSUBDEVIEWID = 14;
    private static final int INDEX_PSSUBDEVIEWNAME = 15;
    private static final int INDEX_UPDATEDATE = 16;
    private static final int INDEX_UPDATEMAN = 17;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSubAppViewBase proxyPSSubAppViewBase = null;
    private boolean backendurlDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean fullcodenameDirtyFlag = false;
    private boolean modulecodenameDirtyFlag = false;
    private boolean modulenameDirtyFlag = false;
    private boolean pageurlDirtyFlag = false;
    private boolean psappviewidDirtyFlag = false;
    private boolean psdeviewbaseidDirtyFlag = false;
    private boolean pssubappidDirtyFlag = false;
    private boolean pssubappnameDirtyFlag = false;
    private boolean pssubappviewidDirtyFlag = false;
    private boolean pssubappviewnameDirtyFlag = false;
    private boolean pssubdeviewidDirtyFlag = false;
    private boolean pssubdeviewnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="backendurl")
    private String backendurl;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="fullcodename")
    private String fullcodename;
    @Column(name="modulecodename")
    private String modulecodename;
    @Column(name="modulename")
    private String modulename;
    @Column(name="pageurl")
    private String pageurl;
    @Column(name="psappviewid")
    private String psappviewid;
    @Column(name="psdeviewbaseid")
    private String psdeviewbaseid;
    @Column(name="pssubappid")
    private String pssubappid;
    @Column(name="pssubappname")
    private String pssubappname;
    @Column(name="pssubappviewid")
    private String pssubappviewid;
    @Column(name="pssubappviewname")
    private String pssubappviewname;
    @Column(name="pssubdeviewid")
    private String pssubdeviewid;
    @Column(name="pssubdeviewname")
    private String pssubdeviewname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSSubAppLock = new Integer(1);
    private PSSubApp pssubapp = null;
    private Integer objPSSubDEViewLock = new Integer(1);
    private PSSubDEView pssubdeview = null;

    public void setBackendUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBackendUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.backendurl = string;
        this.backendurlDirtyFlag = true;
    }

    public String getBackendUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBackendUrl();
        }
        return this.backendurl;
    }

    public boolean isBackendUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBackendUrlDirty();
        }
        return this.backendurlDirtyFlag;
    }

    public void resetBackendUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBackendUrl();
            return;
        }
        this.backendurlDirtyFlag = false;
        this.backendurl = null;
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

    public void setFullCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFullCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.fullcodename = string;
        this.fullcodenameDirtyFlag = true;
    }

    public String getFullCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFullCodeName();
        }
        return this.fullcodename;
    }

    public boolean isFullCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFullCodeNameDirty();
        }
        return this.fullcodenameDirtyFlag;
    }

    public void resetFullCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFullCodeName();
            return;
        }
        this.fullcodenameDirtyFlag = false;
        this.fullcodename = null;
    }

    public void setModuleCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModuleCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.modulecodename = string;
        this.modulecodenameDirtyFlag = true;
    }

    public String getModuleCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModuleCodeName();
        }
        return this.modulecodename;
    }

    public boolean isModuleCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModuleCodeNameDirty();
        }
        return this.modulecodenameDirtyFlag;
    }

    public void resetModuleCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModuleCodeName();
            return;
        }
        this.modulecodenameDirtyFlag = false;
        this.modulecodename = null;
    }

    public void setModuleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModuleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.modulename = string;
        this.modulenameDirtyFlag = true;
    }

    public String getModuleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModuleName();
        }
        return this.modulename;
    }

    public boolean isModuleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModuleNameDirty();
        }
        return this.modulenameDirtyFlag;
    }

    public void resetModuleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModuleName();
            return;
        }
        this.modulenameDirtyFlag = false;
        this.modulename = null;
    }

    public void setPageUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPageUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pageurl = string;
        this.pageurlDirtyFlag = true;
    }

    public String getPageUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPageUrl();
        }
        return this.pageurl;
    }

    public boolean isPageUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPageUrlDirty();
        }
        return this.pageurlDirtyFlag;
    }

    public void resetPageUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPageUrl();
            return;
        }
        this.pageurlDirtyFlag = false;
        this.pageurl = null;
    }

    public void setPSAppViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappviewid = string;
        this.psappviewidDirtyFlag = true;
    }

    public String getPSAppViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppViewId();
        }
        return this.psappviewid;
    }

    public boolean isPSAppViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppViewIdDirty();
        }
        return this.psappviewidDirtyFlag;
    }

    public void resetPSAppViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppViewId();
            return;
        }
        this.psappviewidDirtyFlag = false;
        this.psappviewid = null;
    }

    public void setPSDEViewBaseId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewBaseId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewbaseid = string;
        this.psdeviewbaseidDirtyFlag = true;
    }

    public String getPSDEViewBaseId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewBaseId();
        }
        return this.psdeviewbaseid;
    }

    public boolean isPSDEViewBaseIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewBaseIdDirty();
        }
        return this.psdeviewbaseidDirtyFlag;
    }

    public void resetPSDEViewBaseId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewBaseId();
            return;
        }
        this.psdeviewbaseidDirtyFlag = false;
        this.psdeviewbaseid = null;
    }

    public void setPSSubAppId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubAppId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubappid = string;
        this.pssubappidDirtyFlag = true;
    }

    public String getPSSubAppId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubAppId();
        }
        return this.pssubappid;
    }

    public boolean isPSSubAppIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubAppIdDirty();
        }
        return this.pssubappidDirtyFlag;
    }

    public void resetPSSubAppId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubAppId();
            return;
        }
        this.pssubappidDirtyFlag = false;
        this.pssubappid = null;
    }

    public void setPSSubAppName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubAppName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubappname = string;
        this.pssubappnameDirtyFlag = true;
    }

    public String getPSSubAppName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubAppName();
        }
        return this.pssubappname;
    }

    public boolean isPSSubAppNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubAppNameDirty();
        }
        return this.pssubappnameDirtyFlag;
    }

    public void resetPSSubAppName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubAppName();
            return;
        }
        this.pssubappnameDirtyFlag = false;
        this.pssubappname = null;
    }

    public void setPSSubAppViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubAppViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubappviewid = string;
        this.pssubappviewidDirtyFlag = true;
    }

    public String getPSSubAppViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubAppViewId();
        }
        return this.pssubappviewid;
    }

    public boolean isPSSubAppViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubAppViewIdDirty();
        }
        return this.pssubappviewidDirtyFlag;
    }

    public void resetPSSubAppViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubAppViewId();
            return;
        }
        this.pssubappviewidDirtyFlag = false;
        this.pssubappviewid = null;
    }

    public void setPSSubAppViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubAppViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubappviewname = string;
        this.pssubappviewnameDirtyFlag = true;
    }

    public String getPSSubAppViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubAppViewName();
        }
        return this.pssubappviewname;
    }

    public boolean isPSSubAppViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubAppViewNameDirty();
        }
        return this.pssubappviewnameDirtyFlag;
    }

    public void resetPSSubAppViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubAppViewName();
            return;
        }
        this.pssubappviewnameDirtyFlag = false;
        this.pssubappviewname = null;
    }

    public void setPSSubDEViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubDEViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubdeviewid = string;
        this.pssubdeviewidDirtyFlag = true;
    }

    public String getPSSubDEViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubDEViewId();
        }
        return this.pssubdeviewid;
    }

    public boolean isPSSubDEViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubDEViewIdDirty();
        }
        return this.pssubdeviewidDirtyFlag;
    }

    public void resetPSSubDEViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubDEViewId();
            return;
        }
        this.pssubdeviewidDirtyFlag = false;
        this.pssubdeviewid = null;
    }

    public void setPSSubDEViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubDEViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubdeviewname = string;
        this.pssubdeviewnameDirtyFlag = true;
    }

    public String getPSSubDEViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubDEViewName();
        }
        return this.pssubdeviewname;
    }

    public boolean isPSSubDEViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubDEViewNameDirty();
        }
        return this.pssubdeviewnameDirtyFlag;
    }

    public void resetPSSubDEViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubDEViewName();
            return;
        }
        this.pssubdeviewnameDirtyFlag = false;
        this.pssubdeviewname = null;
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

    protected void onReset() {
        PSSubAppViewBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSubAppViewBase pSSubAppViewBase) {
        pSSubAppViewBase.resetBackendUrl();
        pSSubAppViewBase.resetCodeName();
        pSSubAppViewBase.resetCreateDate();
        pSSubAppViewBase.resetCreateMan();
        pSSubAppViewBase.resetFullCodeName();
        pSSubAppViewBase.resetModuleCodeName();
        pSSubAppViewBase.resetModuleName();
        pSSubAppViewBase.resetPageUrl();
        pSSubAppViewBase.resetPSAppViewId();
        pSSubAppViewBase.resetPSDEViewBaseId();
        pSSubAppViewBase.resetPSSubAppId();
        pSSubAppViewBase.resetPSSubAppName();
        pSSubAppViewBase.resetPSSubAppViewId();
        pSSubAppViewBase.resetPSSubAppViewName();
        pSSubAppViewBase.resetPSSubDEViewId();
        pSSubAppViewBase.resetPSSubDEViewName();
        pSSubAppViewBase.resetUpdateDate();
        pSSubAppViewBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isBackendUrlDirty()) {
            hashMap.put(FIELD_BACKENDURL, this.getBackendUrl());
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
        if (!bl || this.isFullCodeNameDirty()) {
            hashMap.put(FIELD_FULLCODENAME, this.getFullCodeName());
        }
        if (!bl || this.isModuleCodeNameDirty()) {
            hashMap.put(FIELD_MODULECODENAME, this.getModuleCodeName());
        }
        if (!bl || this.isModuleNameDirty()) {
            hashMap.put(FIELD_MODULENAME, this.getModuleName());
        }
        if (!bl || this.isPageUrlDirty()) {
            hashMap.put(FIELD_PAGEURL, this.getPageUrl());
        }
        if (!bl || this.isPSAppViewIdDirty()) {
            hashMap.put(FIELD_PSAPPVIEWID, this.getPSAppViewId());
        }
        if (!bl || this.isPSDEViewBaseIdDirty()) {
            hashMap.put(FIELD_PSDEVIEWBASEID, this.getPSDEViewBaseId());
        }
        if (!bl || this.isPSSubAppIdDirty()) {
            hashMap.put(FIELD_PSSUBAPPID, this.getPSSubAppId());
        }
        if (!bl || this.isPSSubAppNameDirty()) {
            hashMap.put(FIELD_PSSUBAPPNAME, this.getPSSubAppName());
        }
        if (!bl || this.isPSSubAppViewIdDirty()) {
            hashMap.put(FIELD_PSSUBAPPVIEWID, this.getPSSubAppViewId());
        }
        if (!bl || this.isPSSubAppViewNameDirty()) {
            hashMap.put(FIELD_PSSUBAPPVIEWNAME, this.getPSSubAppViewName());
        }
        if (!bl || this.isPSSubDEViewIdDirty()) {
            hashMap.put(FIELD_PSSUBDEVIEWID, this.getPSSubDEViewId());
        }
        if (!bl || this.isPSSubDEViewNameDirty()) {
            hashMap.put(FIELD_PSSUBDEVIEWNAME, this.getPSSubDEViewName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
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
        return PSSubAppViewBase.get(this, n);
    }

    private static Object get(PSSubAppViewBase pSSubAppViewBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSubAppViewBase.getBackendUrl();
            }
            case 1: {
                return pSSubAppViewBase.getCodeName();
            }
            case 2: {
                return pSSubAppViewBase.getCreateDate();
            }
            case 3: {
                return pSSubAppViewBase.getCreateMan();
            }
            case 4: {
                return pSSubAppViewBase.getFullCodeName();
            }
            case 5: {
                return pSSubAppViewBase.getModuleCodeName();
            }
            case 6: {
                return pSSubAppViewBase.getModuleName();
            }
            case 7: {
                return pSSubAppViewBase.getPageUrl();
            }
            case 8: {
                return pSSubAppViewBase.getPSAppViewId();
            }
            case 9: {
                return pSSubAppViewBase.getPSDEViewBaseId();
            }
            case 10: {
                return pSSubAppViewBase.getPSSubAppId();
            }
            case 11: {
                return pSSubAppViewBase.getPSSubAppName();
            }
            case 12: {
                return pSSubAppViewBase.getPSSubAppViewId();
            }
            case 13: {
                return pSSubAppViewBase.getPSSubAppViewName();
            }
            case 14: {
                return pSSubAppViewBase.getPSSubDEViewId();
            }
            case 15: {
                return pSSubAppViewBase.getPSSubDEViewName();
            }
            case 16: {
                return pSSubAppViewBase.getUpdateDate();
            }
            case 17: {
                return pSSubAppViewBase.getUpdateMan();
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
        PSSubAppViewBase.set(this, n, object);
    }

    private static void set(PSSubAppViewBase pSSubAppViewBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSubAppViewBase.setBackendUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSubAppViewBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSubAppViewBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSSubAppViewBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSubAppViewBase.setFullCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSubAppViewBase.setModuleCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSubAppViewBase.setModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSubAppViewBase.setPageUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSubAppViewBase.setPSAppViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSubAppViewBase.setPSDEViewBaseId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSubAppViewBase.setPSSubAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSubAppViewBase.setPSSubAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSubAppViewBase.setPSSubAppViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSubAppViewBase.setPSSubAppViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSubAppViewBase.setPSSubDEViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSubAppViewBase.setPSSubDEViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSubAppViewBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 17: {
                pSSubAppViewBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSSubAppViewBase.isNull(this, n);
    }

    private static boolean isNull(PSSubAppViewBase pSSubAppViewBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSubAppViewBase.getBackendUrl() == null;
            }
            case 1: {
                return pSSubAppViewBase.getCodeName() == null;
            }
            case 2: {
                return pSSubAppViewBase.getCreateDate() == null;
            }
            case 3: {
                return pSSubAppViewBase.getCreateMan() == null;
            }
            case 4: {
                return pSSubAppViewBase.getFullCodeName() == null;
            }
            case 5: {
                return pSSubAppViewBase.getModuleCodeName() == null;
            }
            case 6: {
                return pSSubAppViewBase.getModuleName() == null;
            }
            case 7: {
                return pSSubAppViewBase.getPageUrl() == null;
            }
            case 8: {
                return pSSubAppViewBase.getPSAppViewId() == null;
            }
            case 9: {
                return pSSubAppViewBase.getPSDEViewBaseId() == null;
            }
            case 10: {
                return pSSubAppViewBase.getPSSubAppId() == null;
            }
            case 11: {
                return pSSubAppViewBase.getPSSubAppName() == null;
            }
            case 12: {
                return pSSubAppViewBase.getPSSubAppViewId() == null;
            }
            case 13: {
                return pSSubAppViewBase.getPSSubAppViewName() == null;
            }
            case 14: {
                return pSSubAppViewBase.getPSSubDEViewId() == null;
            }
            case 15: {
                return pSSubAppViewBase.getPSSubDEViewName() == null;
            }
            case 16: {
                return pSSubAppViewBase.getUpdateDate() == null;
            }
            case 17: {
                return pSSubAppViewBase.getUpdateMan() == null;
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
        return PSSubAppViewBase.contains(this, n);
    }

    private static boolean contains(PSSubAppViewBase pSSubAppViewBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSubAppViewBase.isBackendUrlDirty();
            }
            case 1: {
                return pSSubAppViewBase.isCodeNameDirty();
            }
            case 2: {
                return pSSubAppViewBase.isCreateDateDirty();
            }
            case 3: {
                return pSSubAppViewBase.isCreateManDirty();
            }
            case 4: {
                return pSSubAppViewBase.isFullCodeNameDirty();
            }
            case 5: {
                return pSSubAppViewBase.isModuleCodeNameDirty();
            }
            case 6: {
                return pSSubAppViewBase.isModuleNameDirty();
            }
            case 7: {
                return pSSubAppViewBase.isPageUrlDirty();
            }
            case 8: {
                return pSSubAppViewBase.isPSAppViewIdDirty();
            }
            case 9: {
                return pSSubAppViewBase.isPSDEViewBaseIdDirty();
            }
            case 10: {
                return pSSubAppViewBase.isPSSubAppIdDirty();
            }
            case 11: {
                return pSSubAppViewBase.isPSSubAppNameDirty();
            }
            case 12: {
                return pSSubAppViewBase.isPSSubAppViewIdDirty();
            }
            case 13: {
                return pSSubAppViewBase.isPSSubAppViewNameDirty();
            }
            case 14: {
                return pSSubAppViewBase.isPSSubDEViewIdDirty();
            }
            case 15: {
                return pSSubAppViewBase.isPSSubDEViewNameDirty();
            }
            case 16: {
                return pSSubAppViewBase.isUpdateDateDirty();
            }
            case 17: {
                return pSSubAppViewBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSubAppViewBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSubAppViewBase pSSubAppViewBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSubAppViewBase.getBackendUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"backendurl", (Object)PSSubAppViewBase.getJSONValue((Object)pSSubAppViewBase.getBackendUrl()), (boolean)false);
        }
        if (bl || pSSubAppViewBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSubAppViewBase.getJSONValue((Object)pSSubAppViewBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSubAppViewBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSubAppViewBase.getJSONValue((Object)pSSubAppViewBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSubAppViewBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSubAppViewBase.getJSONValue((Object)pSSubAppViewBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSubAppViewBase.getFullCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fullcodename", (Object)PSSubAppViewBase.getJSONValue((Object)pSSubAppViewBase.getFullCodeName()), (boolean)false);
        }
        if (bl || pSSubAppViewBase.getModuleCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modulecodename", (Object)PSSubAppViewBase.getJSONValue((Object)pSSubAppViewBase.getModuleCodeName()), (boolean)false);
        }
        if (bl || pSSubAppViewBase.getModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modulename", (Object)PSSubAppViewBase.getJSONValue((Object)pSSubAppViewBase.getModuleName()), (boolean)false);
        }
        if (bl || pSSubAppViewBase.getPageUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pageurl", (Object)PSSubAppViewBase.getJSONValue((Object)pSSubAppViewBase.getPageUrl()), (boolean)false);
        }
        if (bl || pSSubAppViewBase.getPSAppViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappviewid", (Object)PSSubAppViewBase.getJSONValue((Object)pSSubAppViewBase.getPSAppViewId()), (boolean)false);
        }
        if (bl || pSSubAppViewBase.getPSDEViewBaseId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewbaseid", (Object)PSSubAppViewBase.getJSONValue((Object)pSSubAppViewBase.getPSDEViewBaseId()), (boolean)false);
        }
        if (bl || pSSubAppViewBase.getPSSubAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubappid", (Object)PSSubAppViewBase.getJSONValue((Object)pSSubAppViewBase.getPSSubAppId()), (boolean)false);
        }
        if (bl || pSSubAppViewBase.getPSSubAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubappname", (Object)PSSubAppViewBase.getJSONValue((Object)pSSubAppViewBase.getPSSubAppName()), (boolean)false);
        }
        if (bl || pSSubAppViewBase.getPSSubAppViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubappviewid", (Object)PSSubAppViewBase.getJSONValue((Object)pSSubAppViewBase.getPSSubAppViewId()), (boolean)false);
        }
        if (bl || pSSubAppViewBase.getPSSubAppViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubappviewname", (Object)PSSubAppViewBase.getJSONValue((Object)pSSubAppViewBase.getPSSubAppViewName()), (boolean)false);
        }
        if (bl || pSSubAppViewBase.getPSSubDEViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubdeviewid", (Object)PSSubAppViewBase.getJSONValue((Object)pSSubAppViewBase.getPSSubDEViewId()), (boolean)false);
        }
        if (bl || pSSubAppViewBase.getPSSubDEViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubdeviewname", (Object)PSSubAppViewBase.getJSONValue((Object)pSSubAppViewBase.getPSSubDEViewName()), (boolean)false);
        }
        if (bl || pSSubAppViewBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSubAppViewBase.getJSONValue((Object)pSSubAppViewBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSubAppViewBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSubAppViewBase.getJSONValue((Object)pSSubAppViewBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSubAppViewBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSubAppViewBase pSSubAppViewBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSubAppViewBase.getBackendUrl() != null) {
            object = pSSubAppViewBase.getBackendUrl();
            xmlNode.setAttribute(FIELD_BACKENDURL, (String)(object == null ? "" : object));
        }
        if (bl || pSSubAppViewBase.getCodeName() != null) {
            object = pSSubAppViewBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubAppViewBase.getCreateDate() != null) {
            object = pSSubAppViewBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSubAppViewBase.getCreateMan() != null) {
            object = pSSubAppViewBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSubAppViewBase.getFullCodeName() != null) {
            object = pSSubAppViewBase.getFullCodeName();
            xmlNode.setAttribute(FIELD_FULLCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubAppViewBase.getModuleCodeName() != null) {
            object = pSSubAppViewBase.getModuleCodeName();
            xmlNode.setAttribute(FIELD_MODULECODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubAppViewBase.getModuleName() != null) {
            object = pSSubAppViewBase.getModuleName();
            xmlNode.setAttribute(FIELD_MODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubAppViewBase.getPageUrl() != null) {
            object = pSSubAppViewBase.getPageUrl();
            xmlNode.setAttribute(FIELD_PAGEURL, object == null ? "" : (String)object);
        }
        if (bl || pSSubAppViewBase.getPSAppViewId() != null) {
            object = pSSubAppViewBase.getPSAppViewId();
            xmlNode.setAttribute(FIELD_PSAPPVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSSubAppViewBase.getPSDEViewBaseId() != null) {
            object = pSSubAppViewBase.getPSDEViewBaseId();
            xmlNode.setAttribute(FIELD_PSDEVIEWBASEID, object == null ? "" : (String)object);
        }
        if (bl || pSSubAppViewBase.getPSSubAppId() != null) {
            object = pSSubAppViewBase.getPSSubAppId();
            xmlNode.setAttribute(FIELD_PSSUBAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSSubAppViewBase.getPSSubAppName() != null) {
            object = pSSubAppViewBase.getPSSubAppName();
            xmlNode.setAttribute(FIELD_PSSUBAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubAppViewBase.getPSSubAppViewId() != null) {
            object = pSSubAppViewBase.getPSSubAppViewId();
            xmlNode.setAttribute(FIELD_PSSUBAPPVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSSubAppViewBase.getPSSubAppViewName() != null) {
            object = pSSubAppViewBase.getPSSubAppViewName();
            xmlNode.setAttribute(FIELD_PSSUBAPPVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubAppViewBase.getPSSubDEViewId() != null) {
            object = pSSubAppViewBase.getPSSubDEViewId();
            xmlNode.setAttribute(FIELD_PSSUBDEVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSSubAppViewBase.getPSSubDEViewName() != null) {
            object = pSSubAppViewBase.getPSSubDEViewName();
            xmlNode.setAttribute(FIELD_PSSUBDEVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubAppViewBase.getUpdateDate() != null) {
            object = pSSubAppViewBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSubAppViewBase.getUpdateMan() != null) {
            object = pSSubAppViewBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSubAppViewBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSubAppViewBase pSSubAppViewBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSubAppViewBase.isBackendUrlDirty() && (bl || pSSubAppViewBase.getBackendUrl() != null)) {
            iDataObject.set(FIELD_BACKENDURL, (Object)pSSubAppViewBase.getBackendUrl());
        }
        if (pSSubAppViewBase.isCodeNameDirty() && (bl || pSSubAppViewBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSubAppViewBase.getCodeName());
        }
        if (pSSubAppViewBase.isCreateDateDirty() && (bl || pSSubAppViewBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSubAppViewBase.getCreateDate());
        }
        if (pSSubAppViewBase.isCreateManDirty() && (bl || pSSubAppViewBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSubAppViewBase.getCreateMan());
        }
        if (pSSubAppViewBase.isFullCodeNameDirty() && (bl || pSSubAppViewBase.getFullCodeName() != null)) {
            iDataObject.set(FIELD_FULLCODENAME, (Object)pSSubAppViewBase.getFullCodeName());
        }
        if (pSSubAppViewBase.isModuleCodeNameDirty() && (bl || pSSubAppViewBase.getModuleCodeName() != null)) {
            iDataObject.set(FIELD_MODULECODENAME, (Object)pSSubAppViewBase.getModuleCodeName());
        }
        if (pSSubAppViewBase.isModuleNameDirty() && (bl || pSSubAppViewBase.getModuleName() != null)) {
            iDataObject.set(FIELD_MODULENAME, (Object)pSSubAppViewBase.getModuleName());
        }
        if (pSSubAppViewBase.isPageUrlDirty() && (bl || pSSubAppViewBase.getPageUrl() != null)) {
            iDataObject.set(FIELD_PAGEURL, (Object)pSSubAppViewBase.getPageUrl());
        }
        if (pSSubAppViewBase.isPSAppViewIdDirty() && (bl || pSSubAppViewBase.getPSAppViewId() != null)) {
            iDataObject.set(FIELD_PSAPPVIEWID, (Object)pSSubAppViewBase.getPSAppViewId());
        }
        if (pSSubAppViewBase.isPSDEViewBaseIdDirty() && (bl || pSSubAppViewBase.getPSDEViewBaseId() != null)) {
            iDataObject.set(FIELD_PSDEVIEWBASEID, (Object)pSSubAppViewBase.getPSDEViewBaseId());
        }
        if (pSSubAppViewBase.isPSSubAppIdDirty() && (bl || pSSubAppViewBase.getPSSubAppId() != null)) {
            iDataObject.set(FIELD_PSSUBAPPID, (Object)pSSubAppViewBase.getPSSubAppId());
        }
        if (pSSubAppViewBase.isPSSubAppNameDirty() && (bl || pSSubAppViewBase.getPSSubAppName() != null)) {
            iDataObject.set(FIELD_PSSUBAPPNAME, (Object)pSSubAppViewBase.getPSSubAppName());
        }
        if (pSSubAppViewBase.isPSSubAppViewIdDirty() && (bl || pSSubAppViewBase.getPSSubAppViewId() != null)) {
            iDataObject.set(FIELD_PSSUBAPPVIEWID, (Object)pSSubAppViewBase.getPSSubAppViewId());
        }
        if (pSSubAppViewBase.isPSSubAppViewNameDirty() && (bl || pSSubAppViewBase.getPSSubAppViewName() != null)) {
            iDataObject.set(FIELD_PSSUBAPPVIEWNAME, (Object)pSSubAppViewBase.getPSSubAppViewName());
        }
        if (pSSubAppViewBase.isPSSubDEViewIdDirty() && (bl || pSSubAppViewBase.getPSSubDEViewId() != null)) {
            iDataObject.set(FIELD_PSSUBDEVIEWID, (Object)pSSubAppViewBase.getPSSubDEViewId());
        }
        if (pSSubAppViewBase.isPSSubDEViewNameDirty() && (bl || pSSubAppViewBase.getPSSubDEViewName() != null)) {
            iDataObject.set(FIELD_PSSUBDEVIEWNAME, (Object)pSSubAppViewBase.getPSSubDEViewName());
        }
        if (pSSubAppViewBase.isUpdateDateDirty() && (bl || pSSubAppViewBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSubAppViewBase.getUpdateDate());
        }
        if (pSSubAppViewBase.isUpdateManDirty() && (bl || pSSubAppViewBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSubAppViewBase.getUpdateMan());
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
        return PSSubAppViewBase.remove(this, n);
    }

    private static boolean remove(PSSubAppViewBase pSSubAppViewBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSubAppViewBase.resetBackendUrl();
                return true;
            }
            case 1: {
                pSSubAppViewBase.resetCodeName();
                return true;
            }
            case 2: {
                pSSubAppViewBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSSubAppViewBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSSubAppViewBase.resetFullCodeName();
                return true;
            }
            case 5: {
                pSSubAppViewBase.resetModuleCodeName();
                return true;
            }
            case 6: {
                pSSubAppViewBase.resetModuleName();
                return true;
            }
            case 7: {
                pSSubAppViewBase.resetPageUrl();
                return true;
            }
            case 8: {
                pSSubAppViewBase.resetPSAppViewId();
                return true;
            }
            case 9: {
                pSSubAppViewBase.resetPSDEViewBaseId();
                return true;
            }
            case 10: {
                pSSubAppViewBase.resetPSSubAppId();
                return true;
            }
            case 11: {
                pSSubAppViewBase.resetPSSubAppName();
                return true;
            }
            case 12: {
                pSSubAppViewBase.resetPSSubAppViewId();
                return true;
            }
            case 13: {
                pSSubAppViewBase.resetPSSubAppViewName();
                return true;
            }
            case 14: {
                pSSubAppViewBase.resetPSSubDEViewId();
                return true;
            }
            case 15: {
                pSSubAppViewBase.resetPSSubDEViewName();
                return true;
            }
            case 16: {
                pSSubAppViewBase.resetUpdateDate();
                return true;
            }
            case 17: {
                pSSubAppViewBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSubApp getPSSubApp() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubApp();
        }
        if (this.getPSSubAppId() == null) {
            return null;
        }
        Integer n = this.objPSSubAppLock;
        synchronized (n) {
            if (this.pssubapp != null && DataTypeHelper.compare((int)25, (Object)this.getPSSubAppId(), (Object)this.pssubapp.getPSSubAppId()) != 0L) {
                this.pssubapp = null;
            }
            if (this.pssubapp == null) {
                PSSubApp pSSubApp = new PSSubApp();
                pSSubApp.setPSSubAppId(this.getPSSubAppId());
                PSSubAppService pSSubAppService = (PSSubAppService)ServiceGlobal.getService(PSSubAppService.class, (SessionFactory)this.getSessionFactory());
                pSSubAppService.autoGet(pSSubApp);
                this.pssubapp = pSSubApp;
            }
            return this.pssubapp;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSubDEView getPSSubDEView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubDEView();
        }
        if (this.getPSSubDEViewId() == null) {
            return null;
        }
        Integer n = this.objPSSubDEViewLock;
        synchronized (n) {
            if (this.pssubdeview != null && DataTypeHelper.compare((int)25, (Object)this.getPSSubDEViewId(), (Object)this.pssubdeview.getPSSubDEViewId()) != 0L) {
                this.pssubdeview = null;
            }
            if (this.pssubdeview == null) {
                PSSubDEView pSSubDEView = new PSSubDEView();
                pSSubDEView.setPSSubDEViewId(this.getPSSubDEViewId());
                PSSubDEViewService pSSubDEViewService = (PSSubDEViewService)ServiceGlobal.getService(PSSubDEViewService.class, (SessionFactory)this.getSessionFactory());
                pSSubDEViewService.autoGet(pSSubDEView);
                this.pssubdeview = pSSubDEView;
            }
            return this.pssubdeview;
        }
    }

    private PSSubAppViewBase getProxyEntity() {
        return this.proxyPSSubAppViewBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSubAppViewBase = null;
        if (iDataObject != null && iDataObject instanceof PSSubAppViewBase) {
            this.proxyPSSubAppViewBase = (PSSubAppViewBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSubAppViewService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BACKENDURL, 0);
        fieldIndexMap.put(FIELD_CODENAME, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_FULLCODENAME, 4);
        fieldIndexMap.put(FIELD_MODULECODENAME, 5);
        fieldIndexMap.put(FIELD_MODULENAME, 6);
        fieldIndexMap.put(FIELD_PAGEURL, 7);
        fieldIndexMap.put(FIELD_PSAPPVIEWID, 8);
        fieldIndexMap.put(FIELD_PSDEVIEWBASEID, 9);
        fieldIndexMap.put(FIELD_PSSUBAPPID, 10);
        fieldIndexMap.put(FIELD_PSSUBAPPNAME, 11);
        fieldIndexMap.put(FIELD_PSSUBAPPVIEWID, 12);
        fieldIndexMap.put(FIELD_PSSUBAPPVIEWNAME, 13);
        fieldIndexMap.put(FIELD_PSSUBDEVIEWID, 14);
        fieldIndexMap.put(FIELD_PSSUBDEVIEWNAME, 15);
        fieldIndexMap.put(FIELD_UPDATEDATE, 16);
        fieldIndexMap.put(FIELD_UPDATEMAN, 17);
    }
}

