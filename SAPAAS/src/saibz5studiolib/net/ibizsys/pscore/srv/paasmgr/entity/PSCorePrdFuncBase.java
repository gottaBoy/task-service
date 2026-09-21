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
package net.ibizsys.pscore.srv.paasmgr.entity;

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
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrd;
import net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSCorePrdFuncBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSCorePrdFuncBase.class);
    public static final String FIELD_AVATARURL = "AVATARURL";
    public static final String FIELD_CATEGORY = "CATEGORY";
    public static final String FIELD_CHANGELOG = "CHANGELOG";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CURRENTVERSION = "CURRENTVERSION";
    public static final String FIELD_FULLNAME = "FULLNAME";
    public static final String FIELD_FULLPATH = "FULLPATH";
    public static final String FIELD_FUNCPARAMS = "FUNCPARAMS";
    public static final String FIELD_FUNCSN = "FUNCSN";
    public static final String FIELD_FUNCSTATE = "FUNCSTATE";
    public static final String FIELD_FUNCTAG = "FUNCTAG";
    public static final String FIELD_FUNCTAG2 = "FUNCTAG2";
    public static final String FIELD_FUNCTYPE = "FUNCTYPE";
    public static final String FIELD_FUNCURL = "FUNCURL";
    public static final String FIELD_HTTPURLTOREPO = "HTTPURLTOREPO";
    public static final String FIELD_INFO = "INFO";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PATH = "PATH";
    public static final String FIELD_PSCOREPRDFUNCID = "PSCOREPRDFUNCID";
    public static final String FIELD_PSCOREPRDFUNCNAME = "PSCOREPRDFUNCNAME";
    public static final String FIELD_PSCOREPRDID = "PSCOREPRDID";
    public static final String FIELD_PSCOREPRDNAME = "PSCOREPRDNAME";
    public static final String FIELD_SETTINGS = "SETTINGS";
    public static final String FIELD_SETTINGURL = "SETTINGURL";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VERS = "VERS";
    private static final int INDEX_AVATARURL = 0;
    private static final int INDEX_CATEGORY = 1;
    private static final int INDEX_CHANGELOG = 2;
    private static final int INDEX_CREATEDATE = 3;
    private static final int INDEX_CREATEMAN = 4;
    private static final int INDEX_CURRENTVERSION = 5;
    private static final int INDEX_FULLNAME = 6;
    private static final int INDEX_FULLPATH = 7;
    private static final int INDEX_FUNCPARAMS = 8;
    private static final int INDEX_FUNCSN = 9;
    private static final int INDEX_FUNCSTATE = 10;
    private static final int INDEX_FUNCTAG = 11;
    private static final int INDEX_FUNCTAG2 = 12;
    private static final int INDEX_FUNCTYPE = 13;
    private static final int INDEX_FUNCURL = 14;
    private static final int INDEX_HTTPURLTOREPO = 15;
    private static final int INDEX_INFO = 16;
    private static final int INDEX_MEMO = 17;
    private static final int INDEX_ORDERVALUE = 18;
    private static final int INDEX_PATH = 19;
    private static final int INDEX_PSCOREPRDFUNCID = 20;
    private static final int INDEX_PSCOREPRDFUNCNAME = 21;
    private static final int INDEX_PSCOREPRDID = 22;
    private static final int INDEX_PSCOREPRDNAME = 23;
    private static final int INDEX_SETTINGS = 24;
    private static final int INDEX_SETTINGURL = 25;
    private static final int INDEX_UPDATEDATE = 26;
    private static final int INDEX_UPDATEMAN = 27;
    private static final int INDEX_VERS = 28;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSCorePrdFuncBase proxyPSCorePrdFuncBase = null;
    private boolean avatarurlDirtyFlag = false;
    private boolean categoryDirtyFlag = false;
    private boolean changelogDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean currentversionDirtyFlag = false;
    private boolean fullnameDirtyFlag = false;
    private boolean fullpathDirtyFlag = false;
    private boolean funcparamsDirtyFlag = false;
    private boolean funcsnDirtyFlag = false;
    private boolean funcstateDirtyFlag = false;
    private boolean functagDirtyFlag = false;
    private boolean functag2DirtyFlag = false;
    private boolean functypeDirtyFlag = false;
    private boolean funcurlDirtyFlag = false;
    private boolean httpurltorepoDirtyFlag = false;
    private boolean infoDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean pathDirtyFlag = false;
    private boolean pscoreprdfuncidDirtyFlag = false;
    private boolean pscoreprdfuncnameDirtyFlag = false;
    private boolean pscoreprdidDirtyFlag = false;
    private boolean pscoreprdnameDirtyFlag = false;
    private boolean settingsDirtyFlag = false;
    private boolean settingurlDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean versDirtyFlag = false;
    @Column(name="avatarurl")
    private String avatarurl;
    @Column(name="category")
    private String category;
    @Column(name="changelog")
    private String changelog;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="currentversion")
    private String currentversion;
    @Column(name="fullname")
    private String fullname;
    @Column(name="fullpath")
    private String fullpath;
    @Column(name="funcparams")
    private String funcparams;
    @Column(name="funcsn")
    private String funcsn;
    @Column(name="funcstate")
    private Integer funcstate;
    @Column(name="functag")
    private String functag;
    @Column(name="functag2")
    private String functag2;
    @Column(name="functype")
    private String functype;
    @Column(name="funcurl")
    private String funcurl;
    @Column(name="httpurltorepo")
    private String httpurltorepo;
    @Column(name="info")
    private String info;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="path")
    private String path;
    @Column(name="pscoreprdfuncid")
    private String pscoreprdfuncid;
    @Column(name="pscoreprdfuncname")
    private String pscoreprdfuncname;
    @Column(name="pscoreprdid")
    private String pscoreprdid;
    @Column(name="pscoreprdname")
    private String pscoreprdname;
    @Column(name="settings")
    private String settings;
    @Column(name="settingurl")
    private String settingurl;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="vers")
    private String vers;
    private Integer objPSCorePrdLock = new Integer(1);
    private PSCorePrd pscoreprd = null;

    public void setAvatarUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAvatarUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.avatarurl = string;
        this.avatarurlDirtyFlag = true;
    }

    public String getAvatarUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAvatarUrl();
        }
        return this.avatarurl;
    }

    public boolean isAvatarUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAvatarUrlDirty();
        }
        return this.avatarurlDirtyFlag;
    }

    public void resetAvatarUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAvatarUrl();
            return;
        }
        this.avatarurlDirtyFlag = false;
        this.avatarurl = null;
    }

    public void setCategory(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCategory(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.category = string;
        this.categoryDirtyFlag = true;
    }

    public String getCategory() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCategory();
        }
        return this.category;
    }

    public boolean isCategoryDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCategoryDirty();
        }
        return this.categoryDirtyFlag;
    }

    public void resetCategory() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCategory();
            return;
        }
        this.categoryDirtyFlag = false;
        this.category = null;
    }

    public void setChangeLog(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setChangeLog(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.changelog = string;
        this.changelogDirtyFlag = true;
    }

    public String getChangeLog() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getChangeLog();
        }
        return this.changelog;
    }

    public boolean isChangeLogDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isChangeLogDirty();
        }
        return this.changelogDirtyFlag;
    }

    public void resetChangeLog() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetChangeLog();
            return;
        }
        this.changelogDirtyFlag = false;
        this.changelog = null;
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

    public void setCurrentVersion(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCurrentVersion(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.currentversion = string;
        this.currentversionDirtyFlag = true;
    }

    public String getCurrentVersion() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCurrentVersion();
        }
        return this.currentversion;
    }

    public boolean isCurrentVersionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCurrentVersionDirty();
        }
        return this.currentversionDirtyFlag;
    }

    public void resetCurrentVersion() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCurrentVersion();
            return;
        }
        this.currentversionDirtyFlag = false;
        this.currentversion = null;
    }

    public void setFullName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFullName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.fullname = string;
        this.fullnameDirtyFlag = true;
    }

    public String getFullName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFullName();
        }
        return this.fullname;
    }

    public boolean isFullNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFullNameDirty();
        }
        return this.fullnameDirtyFlag;
    }

    public void resetFullName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFullName();
            return;
        }
        this.fullnameDirtyFlag = false;
        this.fullname = null;
    }

    public void setFullPath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFullPath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.fullpath = string;
        this.fullpathDirtyFlag = true;
    }

    public String getFullPath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFullPath();
        }
        return this.fullpath;
    }

    public boolean isFullPathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFullPathDirty();
        }
        return this.fullpathDirtyFlag;
    }

    public void resetFullPath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFullPath();
            return;
        }
        this.fullpathDirtyFlag = false;
        this.fullpath = null;
    }

    public void setFuncParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFuncParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.funcparams = string;
        this.funcparamsDirtyFlag = true;
    }

    public String getFuncParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFuncParams();
        }
        return this.funcparams;
    }

    public boolean isFuncParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFuncParamsDirty();
        }
        return this.funcparamsDirtyFlag;
    }

    public void resetFuncParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFuncParams();
            return;
        }
        this.funcparamsDirtyFlag = false;
        this.funcparams = null;
    }

    public void setFuncSN(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFuncSN(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.funcsn = string;
        this.funcsnDirtyFlag = true;
    }

    public String getFuncSN() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFuncSN();
        }
        return this.funcsn;
    }

    public boolean isFuncSNDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFuncSNDirty();
        }
        return this.funcsnDirtyFlag;
    }

    public void resetFuncSN() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFuncSN();
            return;
        }
        this.funcsnDirtyFlag = false;
        this.funcsn = null;
    }

    public void setFuncState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFuncState(n);
            return;
        }
        this.funcstate = n;
        this.funcstateDirtyFlag = true;
    }

    public Integer getFuncState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFuncState();
        }
        return this.funcstate;
    }

    public boolean isFuncStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFuncStateDirty();
        }
        return this.funcstateDirtyFlag;
    }

    public void resetFuncState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFuncState();
            return;
        }
        this.funcstateDirtyFlag = false;
        this.funcstate = null;
    }

    public void setFuncTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFuncTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.functag = string;
        this.functagDirtyFlag = true;
    }

    public String getFuncTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFuncTag();
        }
        return this.functag;
    }

    public boolean isFuncTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFuncTagDirty();
        }
        return this.functagDirtyFlag;
    }

    public void resetFuncTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFuncTag();
            return;
        }
        this.functagDirtyFlag = false;
        this.functag = null;
    }

    public void setFuncTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFuncTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.functag2 = string;
        this.functag2DirtyFlag = true;
    }

    public String getFuncTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFuncTag2();
        }
        return this.functag2;
    }

    public boolean isFuncTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFuncTag2Dirty();
        }
        return this.functag2DirtyFlag;
    }

    public void resetFuncTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFuncTag2();
            return;
        }
        this.functag2DirtyFlag = false;
        this.functag2 = null;
    }

    public void setFuncType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFuncType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.functype = string;
        this.functypeDirtyFlag = true;
    }

    public String getFuncType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFuncType();
        }
        return this.functype;
    }

    public boolean isFuncTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFuncTypeDirty();
        }
        return this.functypeDirtyFlag;
    }

    public void resetFuncType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFuncType();
            return;
        }
        this.functypeDirtyFlag = false;
        this.functype = null;
    }

    public void setFuncUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFuncUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.funcurl = string;
        this.funcurlDirtyFlag = true;
    }

    public String getFuncUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFuncUrl();
        }
        return this.funcurl;
    }

    public boolean isFuncUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFuncUrlDirty();
        }
        return this.funcurlDirtyFlag;
    }

    public void resetFuncUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFuncUrl();
            return;
        }
        this.funcurlDirtyFlag = false;
        this.funcurl = null;
    }

    public void setHttpUrlToRepo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHttpUrlToRepo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.httpurltorepo = string;
        this.httpurltorepoDirtyFlag = true;
    }

    public String getHttpUrlToRepo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHttpUrlToRepo();
        }
        return this.httpurltorepo;
    }

    public boolean isHttpUrlToRepoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHttpUrlToRepoDirty();
        }
        return this.httpurltorepoDirtyFlag;
    }

    public void resetHttpUrlToRepo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHttpUrlToRepo();
            return;
        }
        this.httpurltorepoDirtyFlag = false;
        this.httpurltorepo = null;
    }

    public void setInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.info = string;
        this.infoDirtyFlag = true;
    }

    public String getInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInfo();
        }
        return this.info;
    }

    public boolean isInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInfoDirty();
        }
        return this.infoDirtyFlag;
    }

    public void resetInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInfo();
            return;
        }
        this.infoDirtyFlag = false;
        this.info = null;
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

    public void setPath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.path = string;
        this.pathDirtyFlag = true;
    }

    public String getPath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPath();
        }
        return this.path;
    }

    public boolean isPathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPathDirty();
        }
        return this.pathDirtyFlag;
    }

    public void resetPath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPath();
            return;
        }
        this.pathDirtyFlag = false;
        this.path = null;
    }

    public void setPSCorePrdFuncId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCorePrdFuncId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscoreprdfuncid = string;
        this.pscoreprdfuncidDirtyFlag = true;
    }

    public String getPSCorePrdFuncId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCorePrdFuncId();
        }
        return this.pscoreprdfuncid;
    }

    public boolean isPSCorePrdFuncIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCorePrdFuncIdDirty();
        }
        return this.pscoreprdfuncidDirtyFlag;
    }

    public void resetPSCorePrdFuncId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCorePrdFuncId();
            return;
        }
        this.pscoreprdfuncidDirtyFlag = false;
        this.pscoreprdfuncid = null;
    }

    public void setPSCorePrdFuncName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCorePrdFuncName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscoreprdfuncname = string;
        this.pscoreprdfuncnameDirtyFlag = true;
    }

    public String getPSCorePrdFuncName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCorePrdFuncName();
        }
        return this.pscoreprdfuncname;
    }

    public boolean isPSCorePrdFuncNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCorePrdFuncNameDirty();
        }
        return this.pscoreprdfuncnameDirtyFlag;
    }

    public void resetPSCorePrdFuncName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCorePrdFuncName();
            return;
        }
        this.pscoreprdfuncnameDirtyFlag = false;
        this.pscoreprdfuncname = null;
    }

    public void setPSCorePrdId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCorePrdId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscoreprdid = string;
        this.pscoreprdidDirtyFlag = true;
    }

    public String getPSCorePrdId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCorePrdId();
        }
        return this.pscoreprdid;
    }

    public boolean isPSCorePrdIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCorePrdIdDirty();
        }
        return this.pscoreprdidDirtyFlag;
    }

    public void resetPSCorePrdId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCorePrdId();
            return;
        }
        this.pscoreprdidDirtyFlag = false;
        this.pscoreprdid = null;
    }

    public void setPSCorePrdName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCorePrdName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscoreprdname = string;
        this.pscoreprdnameDirtyFlag = true;
    }

    public String getPSCorePrdName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCorePrdName();
        }
        return this.pscoreprdname;
    }

    public boolean isPSCorePrdNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCorePrdNameDirty();
        }
        return this.pscoreprdnameDirtyFlag;
    }

    public void resetPSCorePrdName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCorePrdName();
            return;
        }
        this.pscoreprdnameDirtyFlag = false;
        this.pscoreprdname = null;
    }

    public void setSettings(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSettings(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.settings = string;
        this.settingsDirtyFlag = true;
    }

    public String getSettings() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSettings();
        }
        return this.settings;
    }

    public boolean isSettingsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSettingsDirty();
        }
        return this.settingsDirtyFlag;
    }

    public void resetSettings() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSettings();
            return;
        }
        this.settingsDirtyFlag = false;
        this.settings = null;
    }

    public void setSettingUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSettingUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.settingurl = string;
        this.settingurlDirtyFlag = true;
    }

    public String getSettingUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSettingUrl();
        }
        return this.settingurl;
    }

    public boolean isSettingUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSettingUrlDirty();
        }
        return this.settingurlDirtyFlag;
    }

    public void resetSettingUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSettingUrl();
            return;
        }
        this.settingurlDirtyFlag = false;
        this.settingurl = null;
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

    public void setVers(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVers(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.vers = string;
        this.versDirtyFlag = true;
    }

    public String getVers() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVers();
        }
        return this.vers;
    }

    public boolean isVersDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVersDirty();
        }
        return this.versDirtyFlag;
    }

    public void resetVers() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVers();
            return;
        }
        this.versDirtyFlag = false;
        this.vers = null;
    }

    protected void onReset() {
        PSCorePrdFuncBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSCorePrdFuncBase pSCorePrdFuncBase) {
        pSCorePrdFuncBase.resetAvatarUrl();
        pSCorePrdFuncBase.resetCategory();
        pSCorePrdFuncBase.resetChangeLog();
        pSCorePrdFuncBase.resetCreateDate();
        pSCorePrdFuncBase.resetCreateMan();
        pSCorePrdFuncBase.resetCurrentVersion();
        pSCorePrdFuncBase.resetFullName();
        pSCorePrdFuncBase.resetFullPath();
        pSCorePrdFuncBase.resetFuncParams();
        pSCorePrdFuncBase.resetFuncSN();
        pSCorePrdFuncBase.resetFuncState();
        pSCorePrdFuncBase.resetFuncTag();
        pSCorePrdFuncBase.resetFuncTag2();
        pSCorePrdFuncBase.resetFuncType();
        pSCorePrdFuncBase.resetFuncUrl();
        pSCorePrdFuncBase.resetHttpUrlToRepo();
        pSCorePrdFuncBase.resetInfo();
        pSCorePrdFuncBase.resetMemo();
        pSCorePrdFuncBase.resetOrderValue();
        pSCorePrdFuncBase.resetPath();
        pSCorePrdFuncBase.resetPSCorePrdFuncId();
        pSCorePrdFuncBase.resetPSCorePrdFuncName();
        pSCorePrdFuncBase.resetPSCorePrdId();
        pSCorePrdFuncBase.resetPSCorePrdName();
        pSCorePrdFuncBase.resetSettings();
        pSCorePrdFuncBase.resetSettingUrl();
        pSCorePrdFuncBase.resetUpdateDate();
        pSCorePrdFuncBase.resetUpdateMan();
        pSCorePrdFuncBase.resetVers();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAvatarUrlDirty()) {
            hashMap.put(FIELD_AVATARURL, this.getAvatarUrl());
        }
        if (!bl || this.isCategoryDirty()) {
            hashMap.put(FIELD_CATEGORY, this.getCategory());
        }
        if (!bl || this.isChangeLogDirty()) {
            hashMap.put(FIELD_CHANGELOG, this.getChangeLog());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCurrentVersionDirty()) {
            hashMap.put(FIELD_CURRENTVERSION, this.getCurrentVersion());
        }
        if (!bl || this.isFullNameDirty()) {
            hashMap.put(FIELD_FULLNAME, this.getFullName());
        }
        if (!bl || this.isFullPathDirty()) {
            hashMap.put(FIELD_FULLPATH, this.getFullPath());
        }
        if (!bl || this.isFuncParamsDirty()) {
            hashMap.put(FIELD_FUNCPARAMS, this.getFuncParams());
        }
        if (!bl || this.isFuncSNDirty()) {
            hashMap.put(FIELD_FUNCSN, this.getFuncSN());
        }
        if (!bl || this.isFuncStateDirty()) {
            hashMap.put(FIELD_FUNCSTATE, this.getFuncState());
        }
        if (!bl || this.isFuncTagDirty()) {
            hashMap.put(FIELD_FUNCTAG, this.getFuncTag());
        }
        if (!bl || this.isFuncTag2Dirty()) {
            hashMap.put(FIELD_FUNCTAG2, this.getFuncTag2());
        }
        if (!bl || this.isFuncTypeDirty()) {
            hashMap.put(FIELD_FUNCTYPE, this.getFuncType());
        }
        if (!bl || this.isFuncUrlDirty()) {
            hashMap.put(FIELD_FUNCURL, this.getFuncUrl());
        }
        if (!bl || this.isHttpUrlToRepoDirty()) {
            hashMap.put(FIELD_HTTPURLTOREPO, this.getHttpUrlToRepo());
        }
        if (!bl || this.isInfoDirty()) {
            hashMap.put(FIELD_INFO, this.getInfo());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPathDirty()) {
            hashMap.put(FIELD_PATH, this.getPath());
        }
        if (!bl || this.isPSCorePrdFuncIdDirty()) {
            hashMap.put(FIELD_PSCOREPRDFUNCID, this.getPSCorePrdFuncId());
        }
        if (!bl || this.isPSCorePrdFuncNameDirty()) {
            hashMap.put(FIELD_PSCOREPRDFUNCNAME, this.getPSCorePrdFuncName());
        }
        if (!bl || this.isPSCorePrdIdDirty()) {
            hashMap.put(FIELD_PSCOREPRDID, this.getPSCorePrdId());
        }
        if (!bl || this.isPSCorePrdNameDirty()) {
            hashMap.put(FIELD_PSCOREPRDNAME, this.getPSCorePrdName());
        }
        if (!bl || this.isSettingsDirty()) {
            hashMap.put(FIELD_SETTINGS, this.getSettings());
        }
        if (!bl || this.isSettingUrlDirty()) {
            hashMap.put(FIELD_SETTINGURL, this.getSettingUrl());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isVersDirty()) {
            hashMap.put(FIELD_VERS, this.getVers());
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
        return PSCorePrdFuncBase.get(this, n);
    }

    private static Object get(PSCorePrdFuncBase pSCorePrdFuncBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCorePrdFuncBase.getAvatarUrl();
            }
            case 1: {
                return pSCorePrdFuncBase.getCategory();
            }
            case 2: {
                return pSCorePrdFuncBase.getChangeLog();
            }
            case 3: {
                return pSCorePrdFuncBase.getCreateDate();
            }
            case 4: {
                return pSCorePrdFuncBase.getCreateMan();
            }
            case 5: {
                return pSCorePrdFuncBase.getCurrentVersion();
            }
            case 6: {
                return pSCorePrdFuncBase.getFullName();
            }
            case 7: {
                return pSCorePrdFuncBase.getFullPath();
            }
            case 8: {
                return pSCorePrdFuncBase.getFuncParams();
            }
            case 9: {
                return pSCorePrdFuncBase.getFuncSN();
            }
            case 10: {
                return pSCorePrdFuncBase.getFuncState();
            }
            case 11: {
                return pSCorePrdFuncBase.getFuncTag();
            }
            case 12: {
                return pSCorePrdFuncBase.getFuncTag2();
            }
            case 13: {
                return pSCorePrdFuncBase.getFuncType();
            }
            case 14: {
                return pSCorePrdFuncBase.getFuncUrl();
            }
            case 15: {
                return pSCorePrdFuncBase.getHttpUrlToRepo();
            }
            case 16: {
                return pSCorePrdFuncBase.getInfo();
            }
            case 17: {
                return pSCorePrdFuncBase.getMemo();
            }
            case 18: {
                return pSCorePrdFuncBase.getOrderValue();
            }
            case 19: {
                return pSCorePrdFuncBase.getPath();
            }
            case 20: {
                return pSCorePrdFuncBase.getPSCorePrdFuncId();
            }
            case 21: {
                return pSCorePrdFuncBase.getPSCorePrdFuncName();
            }
            case 22: {
                return pSCorePrdFuncBase.getPSCorePrdId();
            }
            case 23: {
                return pSCorePrdFuncBase.getPSCorePrdName();
            }
            case 24: {
                return pSCorePrdFuncBase.getSettings();
            }
            case 25: {
                return pSCorePrdFuncBase.getSettingUrl();
            }
            case 26: {
                return pSCorePrdFuncBase.getUpdateDate();
            }
            case 27: {
                return pSCorePrdFuncBase.getUpdateMan();
            }
            case 28: {
                return pSCorePrdFuncBase.getVers();
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
        PSCorePrdFuncBase.set(this, n, object);
    }

    private static void set(PSCorePrdFuncBase pSCorePrdFuncBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSCorePrdFuncBase.setAvatarUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSCorePrdFuncBase.setCategory(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSCorePrdFuncBase.setChangeLog(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSCorePrdFuncBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSCorePrdFuncBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSCorePrdFuncBase.setCurrentVersion(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSCorePrdFuncBase.setFullName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSCorePrdFuncBase.setFullPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSCorePrdFuncBase.setFuncParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSCorePrdFuncBase.setFuncSN(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSCorePrdFuncBase.setFuncState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSCorePrdFuncBase.setFuncTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSCorePrdFuncBase.setFuncTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSCorePrdFuncBase.setFuncType(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSCorePrdFuncBase.setFuncUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSCorePrdFuncBase.setHttpUrlToRepo(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSCorePrdFuncBase.setInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSCorePrdFuncBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSCorePrdFuncBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 19: {
                pSCorePrdFuncBase.setPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSCorePrdFuncBase.setPSCorePrdFuncId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSCorePrdFuncBase.setPSCorePrdFuncName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSCorePrdFuncBase.setPSCorePrdId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSCorePrdFuncBase.setPSCorePrdName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSCorePrdFuncBase.setSettings(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSCorePrdFuncBase.setSettingUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSCorePrdFuncBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 27: {
                pSCorePrdFuncBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSCorePrdFuncBase.setVers(DataObject.getStringValue((Object)object));
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
        return PSCorePrdFuncBase.isNull(this, n);
    }

    private static boolean isNull(PSCorePrdFuncBase pSCorePrdFuncBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCorePrdFuncBase.getAvatarUrl() == null;
            }
            case 1: {
                return pSCorePrdFuncBase.getCategory() == null;
            }
            case 2: {
                return pSCorePrdFuncBase.getChangeLog() == null;
            }
            case 3: {
                return pSCorePrdFuncBase.getCreateDate() == null;
            }
            case 4: {
                return pSCorePrdFuncBase.getCreateMan() == null;
            }
            case 5: {
                return pSCorePrdFuncBase.getCurrentVersion() == null;
            }
            case 6: {
                return pSCorePrdFuncBase.getFullName() == null;
            }
            case 7: {
                return pSCorePrdFuncBase.getFullPath() == null;
            }
            case 8: {
                return pSCorePrdFuncBase.getFuncParams() == null;
            }
            case 9: {
                return pSCorePrdFuncBase.getFuncSN() == null;
            }
            case 10: {
                return pSCorePrdFuncBase.getFuncState() == null;
            }
            case 11: {
                return pSCorePrdFuncBase.getFuncTag() == null;
            }
            case 12: {
                return pSCorePrdFuncBase.getFuncTag2() == null;
            }
            case 13: {
                return pSCorePrdFuncBase.getFuncType() == null;
            }
            case 14: {
                return pSCorePrdFuncBase.getFuncUrl() == null;
            }
            case 15: {
                return pSCorePrdFuncBase.getHttpUrlToRepo() == null;
            }
            case 16: {
                return pSCorePrdFuncBase.getInfo() == null;
            }
            case 17: {
                return pSCorePrdFuncBase.getMemo() == null;
            }
            case 18: {
                return pSCorePrdFuncBase.getOrderValue() == null;
            }
            case 19: {
                return pSCorePrdFuncBase.getPath() == null;
            }
            case 20: {
                return pSCorePrdFuncBase.getPSCorePrdFuncId() == null;
            }
            case 21: {
                return pSCorePrdFuncBase.getPSCorePrdFuncName() == null;
            }
            case 22: {
                return pSCorePrdFuncBase.getPSCorePrdId() == null;
            }
            case 23: {
                return pSCorePrdFuncBase.getPSCorePrdName() == null;
            }
            case 24: {
                return pSCorePrdFuncBase.getSettings() == null;
            }
            case 25: {
                return pSCorePrdFuncBase.getSettingUrl() == null;
            }
            case 26: {
                return pSCorePrdFuncBase.getUpdateDate() == null;
            }
            case 27: {
                return pSCorePrdFuncBase.getUpdateMan() == null;
            }
            case 28: {
                return pSCorePrdFuncBase.getVers() == null;
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
        return PSCorePrdFuncBase.contains(this, n);
    }

    private static boolean contains(PSCorePrdFuncBase pSCorePrdFuncBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCorePrdFuncBase.isAvatarUrlDirty();
            }
            case 1: {
                return pSCorePrdFuncBase.isCategoryDirty();
            }
            case 2: {
                return pSCorePrdFuncBase.isChangeLogDirty();
            }
            case 3: {
                return pSCorePrdFuncBase.isCreateDateDirty();
            }
            case 4: {
                return pSCorePrdFuncBase.isCreateManDirty();
            }
            case 5: {
                return pSCorePrdFuncBase.isCurrentVersionDirty();
            }
            case 6: {
                return pSCorePrdFuncBase.isFullNameDirty();
            }
            case 7: {
                return pSCorePrdFuncBase.isFullPathDirty();
            }
            case 8: {
                return pSCorePrdFuncBase.isFuncParamsDirty();
            }
            case 9: {
                return pSCorePrdFuncBase.isFuncSNDirty();
            }
            case 10: {
                return pSCorePrdFuncBase.isFuncStateDirty();
            }
            case 11: {
                return pSCorePrdFuncBase.isFuncTagDirty();
            }
            case 12: {
                return pSCorePrdFuncBase.isFuncTag2Dirty();
            }
            case 13: {
                return pSCorePrdFuncBase.isFuncTypeDirty();
            }
            case 14: {
                return pSCorePrdFuncBase.isFuncUrlDirty();
            }
            case 15: {
                return pSCorePrdFuncBase.isHttpUrlToRepoDirty();
            }
            case 16: {
                return pSCorePrdFuncBase.isInfoDirty();
            }
            case 17: {
                return pSCorePrdFuncBase.isMemoDirty();
            }
            case 18: {
                return pSCorePrdFuncBase.isOrderValueDirty();
            }
            case 19: {
                return pSCorePrdFuncBase.isPathDirty();
            }
            case 20: {
                return pSCorePrdFuncBase.isPSCorePrdFuncIdDirty();
            }
            case 21: {
                return pSCorePrdFuncBase.isPSCorePrdFuncNameDirty();
            }
            case 22: {
                return pSCorePrdFuncBase.isPSCorePrdIdDirty();
            }
            case 23: {
                return pSCorePrdFuncBase.isPSCorePrdNameDirty();
            }
            case 24: {
                return pSCorePrdFuncBase.isSettingsDirty();
            }
            case 25: {
                return pSCorePrdFuncBase.isSettingUrlDirty();
            }
            case 26: {
                return pSCorePrdFuncBase.isUpdateDateDirty();
            }
            case 27: {
                return pSCorePrdFuncBase.isUpdateManDirty();
            }
            case 28: {
                return pSCorePrdFuncBase.isVersDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSCorePrdFuncBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSCorePrdFuncBase pSCorePrdFuncBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSCorePrdFuncBase.getAvatarUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"avatarurl", (Object)PSCorePrdFuncBase.getJSONValue((Object)pSCorePrdFuncBase.getAvatarUrl()), (boolean)false);
        }
        if (bl || pSCorePrdFuncBase.getCategory() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"category", (Object)PSCorePrdFuncBase.getJSONValue((Object)pSCorePrdFuncBase.getCategory()), (boolean)false);
        }
        if (bl || pSCorePrdFuncBase.getChangeLog() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"changelog", (Object)PSCorePrdFuncBase.getJSONValue((Object)pSCorePrdFuncBase.getChangeLog()), (boolean)false);
        }
        if (bl || pSCorePrdFuncBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSCorePrdFuncBase.getJSONValue((Object)pSCorePrdFuncBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSCorePrdFuncBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSCorePrdFuncBase.getJSONValue((Object)pSCorePrdFuncBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSCorePrdFuncBase.getCurrentVersion() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"currentversion", (Object)PSCorePrdFuncBase.getJSONValue((Object)pSCorePrdFuncBase.getCurrentVersion()), (boolean)false);
        }
        if (bl || pSCorePrdFuncBase.getFullName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fullname", (Object)PSCorePrdFuncBase.getJSONValue((Object)pSCorePrdFuncBase.getFullName()), (boolean)false);
        }
        if (bl || pSCorePrdFuncBase.getFullPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fullpath", (Object)PSCorePrdFuncBase.getJSONValue((Object)pSCorePrdFuncBase.getFullPath()), (boolean)false);
        }
        if (bl || pSCorePrdFuncBase.getFuncParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"funcparams", (Object)PSCorePrdFuncBase.getJSONValue((Object)pSCorePrdFuncBase.getFuncParams()), (boolean)false);
        }
        if (bl || pSCorePrdFuncBase.getFuncSN() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"funcsn", (Object)PSCorePrdFuncBase.getJSONValue((Object)pSCorePrdFuncBase.getFuncSN()), (boolean)false);
        }
        if (bl || pSCorePrdFuncBase.getFuncState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"funcstate", (Object)PSCorePrdFuncBase.getJSONValue((Object)pSCorePrdFuncBase.getFuncState()), (boolean)false);
        }
        if (bl || pSCorePrdFuncBase.getFuncTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"functag", (Object)PSCorePrdFuncBase.getJSONValue((Object)pSCorePrdFuncBase.getFuncTag()), (boolean)false);
        }
        if (bl || pSCorePrdFuncBase.getFuncTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"functag2", (Object)PSCorePrdFuncBase.getJSONValue((Object)pSCorePrdFuncBase.getFuncTag2()), (boolean)false);
        }
        if (bl || pSCorePrdFuncBase.getFuncType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"functype", (Object)PSCorePrdFuncBase.getJSONValue((Object)pSCorePrdFuncBase.getFuncType()), (boolean)false);
        }
        if (bl || pSCorePrdFuncBase.getFuncUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"funcurl", (Object)PSCorePrdFuncBase.getJSONValue((Object)pSCorePrdFuncBase.getFuncUrl()), (boolean)false);
        }
        if (bl || pSCorePrdFuncBase.getHttpUrlToRepo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"httpurltorepo", (Object)PSCorePrdFuncBase.getJSONValue((Object)pSCorePrdFuncBase.getHttpUrlToRepo()), (boolean)false);
        }
        if (bl || pSCorePrdFuncBase.getInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"info", (Object)PSCorePrdFuncBase.getJSONValue((Object)pSCorePrdFuncBase.getInfo()), (boolean)false);
        }
        if (bl || pSCorePrdFuncBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSCorePrdFuncBase.getJSONValue((Object)pSCorePrdFuncBase.getMemo()), (boolean)false);
        }
        if (bl || pSCorePrdFuncBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSCorePrdFuncBase.getJSONValue((Object)pSCorePrdFuncBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSCorePrdFuncBase.getPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"path", (Object)PSCorePrdFuncBase.getJSONValue((Object)pSCorePrdFuncBase.getPath()), (boolean)false);
        }
        if (bl || pSCorePrdFuncBase.getPSCorePrdFuncId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscoreprdfuncid", (Object)PSCorePrdFuncBase.getJSONValue((Object)pSCorePrdFuncBase.getPSCorePrdFuncId()), (boolean)false);
        }
        if (bl || pSCorePrdFuncBase.getPSCorePrdFuncName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscoreprdfuncname", (Object)PSCorePrdFuncBase.getJSONValue((Object)pSCorePrdFuncBase.getPSCorePrdFuncName()), (boolean)false);
        }
        if (bl || pSCorePrdFuncBase.getPSCorePrdId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscoreprdid", (Object)PSCorePrdFuncBase.getJSONValue((Object)pSCorePrdFuncBase.getPSCorePrdId()), (boolean)false);
        }
        if (bl || pSCorePrdFuncBase.getPSCorePrdName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscoreprdname", (Object)PSCorePrdFuncBase.getJSONValue((Object)pSCorePrdFuncBase.getPSCorePrdName()), (boolean)false);
        }
        if (bl || pSCorePrdFuncBase.getSettings() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"settings", (Object)PSCorePrdFuncBase.getJSONValue((Object)pSCorePrdFuncBase.getSettings()), (boolean)false);
        }
        if (bl || pSCorePrdFuncBase.getSettingUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"settingurl", (Object)PSCorePrdFuncBase.getJSONValue((Object)pSCorePrdFuncBase.getSettingUrl()), (boolean)false);
        }
        if (bl || pSCorePrdFuncBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSCorePrdFuncBase.getJSONValue((Object)pSCorePrdFuncBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSCorePrdFuncBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSCorePrdFuncBase.getJSONValue((Object)pSCorePrdFuncBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSCorePrdFuncBase.getVers() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"vers", (Object)PSCorePrdFuncBase.getJSONValue((Object)pSCorePrdFuncBase.getVers()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSCorePrdFuncBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSCorePrdFuncBase pSCorePrdFuncBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSCorePrdFuncBase.getAvatarUrl() != null) {
            object = pSCorePrdFuncBase.getAvatarUrl();
            xmlNode.setAttribute(FIELD_AVATARURL, (String)(object == null ? "" : object));
        }
        if (bl || pSCorePrdFuncBase.getCategory() != null) {
            object = pSCorePrdFuncBase.getCategory();
            xmlNode.setAttribute(FIELD_CATEGORY, (String)(object == null ? "" : object));
        }
        if (bl || pSCorePrdFuncBase.getChangeLog() != null) {
            object = pSCorePrdFuncBase.getChangeLog();
            xmlNode.setAttribute(FIELD_CHANGELOG, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdFuncBase.getCreateDate() != null) {
            object = pSCorePrdFuncBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCorePrdFuncBase.getCreateMan() != null) {
            object = pSCorePrdFuncBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdFuncBase.getCurrentVersion() != null) {
            object = pSCorePrdFuncBase.getCurrentVersion();
            xmlNode.setAttribute(FIELD_CURRENTVERSION, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdFuncBase.getFullName() != null) {
            object = pSCorePrdFuncBase.getFullName();
            xmlNode.setAttribute(FIELD_FULLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdFuncBase.getFullPath() != null) {
            object = pSCorePrdFuncBase.getFullPath();
            xmlNode.setAttribute(FIELD_FULLPATH, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdFuncBase.getFuncParams() != null) {
            object = pSCorePrdFuncBase.getFuncParams();
            xmlNode.setAttribute(FIELD_FUNCPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdFuncBase.getFuncSN() != null) {
            object = pSCorePrdFuncBase.getFuncSN();
            xmlNode.setAttribute(FIELD_FUNCSN, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdFuncBase.getFuncState() != null) {
            object = pSCorePrdFuncBase.getFuncState();
            xmlNode.setAttribute(FIELD_FUNCSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSCorePrdFuncBase.getFuncTag() != null) {
            object = pSCorePrdFuncBase.getFuncTag();
            xmlNode.setAttribute(FIELD_FUNCTAG, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdFuncBase.getFuncTag2() != null) {
            object = pSCorePrdFuncBase.getFuncTag2();
            xmlNode.setAttribute(FIELD_FUNCTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdFuncBase.getFuncType() != null) {
            object = pSCorePrdFuncBase.getFuncType();
            xmlNode.setAttribute(FIELD_FUNCTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdFuncBase.getFuncUrl() != null) {
            object = pSCorePrdFuncBase.getFuncUrl();
            xmlNode.setAttribute(FIELD_FUNCURL, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdFuncBase.getHttpUrlToRepo() != null) {
            object = pSCorePrdFuncBase.getHttpUrlToRepo();
            xmlNode.setAttribute(FIELD_HTTPURLTOREPO, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdFuncBase.getInfo() != null) {
            object = pSCorePrdFuncBase.getInfo();
            xmlNode.setAttribute(FIELD_INFO, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdFuncBase.getMemo() != null) {
            object = pSCorePrdFuncBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdFuncBase.getOrderValue() != null) {
            object = pSCorePrdFuncBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSCorePrdFuncBase.getPath() != null) {
            object = pSCorePrdFuncBase.getPath();
            xmlNode.setAttribute(FIELD_PATH, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdFuncBase.getPSCorePrdFuncId() != null) {
            object = pSCorePrdFuncBase.getPSCorePrdFuncId();
            xmlNode.setAttribute(FIELD_PSCOREPRDFUNCID, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdFuncBase.getPSCorePrdFuncName() != null) {
            object = pSCorePrdFuncBase.getPSCorePrdFuncName();
            xmlNode.setAttribute(FIELD_PSCOREPRDFUNCNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdFuncBase.getPSCorePrdId() != null) {
            object = pSCorePrdFuncBase.getPSCorePrdId();
            xmlNode.setAttribute(FIELD_PSCOREPRDID, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdFuncBase.getPSCorePrdName() != null) {
            object = pSCorePrdFuncBase.getPSCorePrdName();
            xmlNode.setAttribute(FIELD_PSCOREPRDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdFuncBase.getSettings() != null) {
            object = pSCorePrdFuncBase.getSettings();
            xmlNode.setAttribute(FIELD_SETTINGS, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdFuncBase.getSettingUrl() != null) {
            object = pSCorePrdFuncBase.getSettingUrl();
            xmlNode.setAttribute(FIELD_SETTINGURL, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdFuncBase.getUpdateDate() != null) {
            object = pSCorePrdFuncBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCorePrdFuncBase.getUpdateMan() != null) {
            object = pSCorePrdFuncBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdFuncBase.getVers() != null) {
            object = pSCorePrdFuncBase.getVers();
            xmlNode.setAttribute(FIELD_VERS, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSCorePrdFuncBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSCorePrdFuncBase pSCorePrdFuncBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSCorePrdFuncBase.isAvatarUrlDirty() && (bl || pSCorePrdFuncBase.getAvatarUrl() != null)) {
            iDataObject.set(FIELD_AVATARURL, (Object)pSCorePrdFuncBase.getAvatarUrl());
        }
        if (pSCorePrdFuncBase.isCategoryDirty() && (bl || pSCorePrdFuncBase.getCategory() != null)) {
            iDataObject.set(FIELD_CATEGORY, (Object)pSCorePrdFuncBase.getCategory());
        }
        if (pSCorePrdFuncBase.isChangeLogDirty() && (bl || pSCorePrdFuncBase.getChangeLog() != null)) {
            iDataObject.set(FIELD_CHANGELOG, (Object)pSCorePrdFuncBase.getChangeLog());
        }
        if (pSCorePrdFuncBase.isCreateDateDirty() && (bl || pSCorePrdFuncBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSCorePrdFuncBase.getCreateDate());
        }
        if (pSCorePrdFuncBase.isCreateManDirty() && (bl || pSCorePrdFuncBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSCorePrdFuncBase.getCreateMan());
        }
        if (pSCorePrdFuncBase.isCurrentVersionDirty() && (bl || pSCorePrdFuncBase.getCurrentVersion() != null)) {
            iDataObject.set(FIELD_CURRENTVERSION, (Object)pSCorePrdFuncBase.getCurrentVersion());
        }
        if (pSCorePrdFuncBase.isFullNameDirty() && (bl || pSCorePrdFuncBase.getFullName() != null)) {
            iDataObject.set(FIELD_FULLNAME, (Object)pSCorePrdFuncBase.getFullName());
        }
        if (pSCorePrdFuncBase.isFullPathDirty() && (bl || pSCorePrdFuncBase.getFullPath() != null)) {
            iDataObject.set(FIELD_FULLPATH, (Object)pSCorePrdFuncBase.getFullPath());
        }
        if (pSCorePrdFuncBase.isFuncParamsDirty() && (bl || pSCorePrdFuncBase.getFuncParams() != null)) {
            iDataObject.set(FIELD_FUNCPARAMS, (Object)pSCorePrdFuncBase.getFuncParams());
        }
        if (pSCorePrdFuncBase.isFuncSNDirty() && (bl || pSCorePrdFuncBase.getFuncSN() != null)) {
            iDataObject.set(FIELD_FUNCSN, (Object)pSCorePrdFuncBase.getFuncSN());
        }
        if (pSCorePrdFuncBase.isFuncStateDirty() && (bl || pSCorePrdFuncBase.getFuncState() != null)) {
            iDataObject.set(FIELD_FUNCSTATE, (Object)pSCorePrdFuncBase.getFuncState());
        }
        if (pSCorePrdFuncBase.isFuncTagDirty() && (bl || pSCorePrdFuncBase.getFuncTag() != null)) {
            iDataObject.set(FIELD_FUNCTAG, (Object)pSCorePrdFuncBase.getFuncTag());
        }
        if (pSCorePrdFuncBase.isFuncTag2Dirty() && (bl || pSCorePrdFuncBase.getFuncTag2() != null)) {
            iDataObject.set(FIELD_FUNCTAG2, (Object)pSCorePrdFuncBase.getFuncTag2());
        }
        if (pSCorePrdFuncBase.isFuncTypeDirty() && (bl || pSCorePrdFuncBase.getFuncType() != null)) {
            iDataObject.set(FIELD_FUNCTYPE, (Object)pSCorePrdFuncBase.getFuncType());
        }
        if (pSCorePrdFuncBase.isFuncUrlDirty() && (bl || pSCorePrdFuncBase.getFuncUrl() != null)) {
            iDataObject.set(FIELD_FUNCURL, (Object)pSCorePrdFuncBase.getFuncUrl());
        }
        if (pSCorePrdFuncBase.isHttpUrlToRepoDirty() && (bl || pSCorePrdFuncBase.getHttpUrlToRepo() != null)) {
            iDataObject.set(FIELD_HTTPURLTOREPO, (Object)pSCorePrdFuncBase.getHttpUrlToRepo());
        }
        if (pSCorePrdFuncBase.isInfoDirty() && (bl || pSCorePrdFuncBase.getInfo() != null)) {
            iDataObject.set(FIELD_INFO, (Object)pSCorePrdFuncBase.getInfo());
        }
        if (pSCorePrdFuncBase.isMemoDirty() && (bl || pSCorePrdFuncBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSCorePrdFuncBase.getMemo());
        }
        if (pSCorePrdFuncBase.isOrderValueDirty() && (bl || pSCorePrdFuncBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSCorePrdFuncBase.getOrderValue());
        }
        if (pSCorePrdFuncBase.isPathDirty() && (bl || pSCorePrdFuncBase.getPath() != null)) {
            iDataObject.set(FIELD_PATH, (Object)pSCorePrdFuncBase.getPath());
        }
        if (pSCorePrdFuncBase.isPSCorePrdFuncIdDirty() && (bl || pSCorePrdFuncBase.getPSCorePrdFuncId() != null)) {
            iDataObject.set(FIELD_PSCOREPRDFUNCID, (Object)pSCorePrdFuncBase.getPSCorePrdFuncId());
        }
        if (pSCorePrdFuncBase.isPSCorePrdFuncNameDirty() && (bl || pSCorePrdFuncBase.getPSCorePrdFuncName() != null)) {
            iDataObject.set(FIELD_PSCOREPRDFUNCNAME, (Object)pSCorePrdFuncBase.getPSCorePrdFuncName());
        }
        if (pSCorePrdFuncBase.isPSCorePrdIdDirty() && (bl || pSCorePrdFuncBase.getPSCorePrdId() != null)) {
            iDataObject.set(FIELD_PSCOREPRDID, (Object)pSCorePrdFuncBase.getPSCorePrdId());
        }
        if (pSCorePrdFuncBase.isPSCorePrdNameDirty() && (bl || pSCorePrdFuncBase.getPSCorePrdName() != null)) {
            iDataObject.set(FIELD_PSCOREPRDNAME, (Object)pSCorePrdFuncBase.getPSCorePrdName());
        }
        if (pSCorePrdFuncBase.isSettingsDirty() && (bl || pSCorePrdFuncBase.getSettings() != null)) {
            iDataObject.set(FIELD_SETTINGS, (Object)pSCorePrdFuncBase.getSettings());
        }
        if (pSCorePrdFuncBase.isSettingUrlDirty() && (bl || pSCorePrdFuncBase.getSettingUrl() != null)) {
            iDataObject.set(FIELD_SETTINGURL, (Object)pSCorePrdFuncBase.getSettingUrl());
        }
        if (pSCorePrdFuncBase.isUpdateDateDirty() && (bl || pSCorePrdFuncBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSCorePrdFuncBase.getUpdateDate());
        }
        if (pSCorePrdFuncBase.isUpdateManDirty() && (bl || pSCorePrdFuncBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSCorePrdFuncBase.getUpdateMan());
        }
        if (pSCorePrdFuncBase.isVersDirty() && (bl || pSCorePrdFuncBase.getVers() != null)) {
            iDataObject.set(FIELD_VERS, (Object)pSCorePrdFuncBase.getVers());
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
        return PSCorePrdFuncBase.remove(this, n);
    }

    private static boolean remove(PSCorePrdFuncBase pSCorePrdFuncBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSCorePrdFuncBase.resetAvatarUrl();
                return true;
            }
            case 1: {
                pSCorePrdFuncBase.resetCategory();
                return true;
            }
            case 2: {
                pSCorePrdFuncBase.resetChangeLog();
                return true;
            }
            case 3: {
                pSCorePrdFuncBase.resetCreateDate();
                return true;
            }
            case 4: {
                pSCorePrdFuncBase.resetCreateMan();
                return true;
            }
            case 5: {
                pSCorePrdFuncBase.resetCurrentVersion();
                return true;
            }
            case 6: {
                pSCorePrdFuncBase.resetFullName();
                return true;
            }
            case 7: {
                pSCorePrdFuncBase.resetFullPath();
                return true;
            }
            case 8: {
                pSCorePrdFuncBase.resetFuncParams();
                return true;
            }
            case 9: {
                pSCorePrdFuncBase.resetFuncSN();
                return true;
            }
            case 10: {
                pSCorePrdFuncBase.resetFuncState();
                return true;
            }
            case 11: {
                pSCorePrdFuncBase.resetFuncTag();
                return true;
            }
            case 12: {
                pSCorePrdFuncBase.resetFuncTag2();
                return true;
            }
            case 13: {
                pSCorePrdFuncBase.resetFuncType();
                return true;
            }
            case 14: {
                pSCorePrdFuncBase.resetFuncUrl();
                return true;
            }
            case 15: {
                pSCorePrdFuncBase.resetHttpUrlToRepo();
                return true;
            }
            case 16: {
                pSCorePrdFuncBase.resetInfo();
                return true;
            }
            case 17: {
                pSCorePrdFuncBase.resetMemo();
                return true;
            }
            case 18: {
                pSCorePrdFuncBase.resetOrderValue();
                return true;
            }
            case 19: {
                pSCorePrdFuncBase.resetPath();
                return true;
            }
            case 20: {
                pSCorePrdFuncBase.resetPSCorePrdFuncId();
                return true;
            }
            case 21: {
                pSCorePrdFuncBase.resetPSCorePrdFuncName();
                return true;
            }
            case 22: {
                pSCorePrdFuncBase.resetPSCorePrdId();
                return true;
            }
            case 23: {
                pSCorePrdFuncBase.resetPSCorePrdName();
                return true;
            }
            case 24: {
                pSCorePrdFuncBase.resetSettings();
                return true;
            }
            case 25: {
                pSCorePrdFuncBase.resetSettingUrl();
                return true;
            }
            case 26: {
                pSCorePrdFuncBase.resetUpdateDate();
                return true;
            }
            case 27: {
                pSCorePrdFuncBase.resetUpdateMan();
                return true;
            }
            case 28: {
                pSCorePrdFuncBase.resetVers();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCorePrd getPSCorePrd() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCorePrd();
        }
        if (this.getPSCorePrdId() == null) {
            return null;
        }
        Integer n = this.objPSCorePrdLock;
        synchronized (n) {
            if (this.pscoreprd != null && DataTypeHelper.compare((int)25, (Object)this.getPSCorePrdId(), (Object)this.pscoreprd.getPSCorePrdId()) != 0L) {
                this.pscoreprd = null;
            }
            if (this.pscoreprd == null) {
                PSCorePrd pSCorePrd = new PSCorePrd();
                pSCorePrd.setPSCorePrdId(this.getPSCorePrdId());
                PSCorePrdService pSCorePrdService = (PSCorePrdService)ServiceGlobal.getService(PSCorePrdService.class, (SessionFactory)this.getSessionFactory());
                pSCorePrdService.autoGet((IEntity)pSCorePrd);
                this.pscoreprd = pSCorePrd;
            }
            return this.pscoreprd;
        }
    }

    private PSCorePrdFuncBase getProxyEntity() {
        return this.proxyPSCorePrdFuncBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSCorePrdFuncBase = null;
        if (iDataObject != null && iDataObject instanceof PSCorePrdFuncBase) {
            this.proxyPSCorePrdFuncBase = (PSCorePrdFuncBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdFuncService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_AVATARURL, 0);
        fieldIndexMap.put(FIELD_CATEGORY, 1);
        fieldIndexMap.put(FIELD_CHANGELOG, 2);
        fieldIndexMap.put(FIELD_CREATEDATE, 3);
        fieldIndexMap.put(FIELD_CREATEMAN, 4);
        fieldIndexMap.put(FIELD_CURRENTVERSION, 5);
        fieldIndexMap.put(FIELD_FULLNAME, 6);
        fieldIndexMap.put(FIELD_FULLPATH, 7);
        fieldIndexMap.put(FIELD_FUNCPARAMS, 8);
        fieldIndexMap.put(FIELD_FUNCSN, 9);
        fieldIndexMap.put(FIELD_FUNCSTATE, 10);
        fieldIndexMap.put(FIELD_FUNCTAG, 11);
        fieldIndexMap.put(FIELD_FUNCTAG2, 12);
        fieldIndexMap.put(FIELD_FUNCTYPE, 13);
        fieldIndexMap.put(FIELD_FUNCURL, 14);
        fieldIndexMap.put(FIELD_HTTPURLTOREPO, 15);
        fieldIndexMap.put(FIELD_INFO, 16);
        fieldIndexMap.put(FIELD_MEMO, 17);
        fieldIndexMap.put(FIELD_ORDERVALUE, 18);
        fieldIndexMap.put(FIELD_PATH, 19);
        fieldIndexMap.put(FIELD_PSCOREPRDFUNCID, 20);
        fieldIndexMap.put(FIELD_PSCOREPRDFUNCNAME, 21);
        fieldIndexMap.put(FIELD_PSCOREPRDID, 22);
        fieldIndexMap.put(FIELD_PSCOREPRDNAME, 23);
        fieldIndexMap.put(FIELD_SETTINGS, 24);
        fieldIndexMap.put(FIELD_SETTINGURL, 25);
        fieldIndexMap.put(FIELD_UPDATEDATE, 26);
        fieldIndexMap.put(FIELD_UPDATEMAN, 27);
        fieldIndexMap.put(FIELD_VERS, 28);
    }
}

