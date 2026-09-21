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
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrdCat;
import net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdCatService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSCorePrdBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSCorePrdBase.class);
    public static final String FIELD_AVATARURL = "AVATARURL";
    public static final String FIELD_CATEGORY = "CATEGORY";
    public static final String FIELD_CHANGELOG = "CHANGELOG";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CURRENTVERSION = "CURRENTVERSION";
    public static final String FIELD_FULLNAME = "FULLNAME";
    public static final String FIELD_FULLPATH = "FULLPATH";
    public static final String FIELD_HTTPURLTOREPO = "HTTPURLTOREPO";
    public static final String FIELD_INFO = "INFO";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PATH = "PATH";
    public static final String FIELD_PKGFOLDER = "PKGFOLDER";
    public static final String FIELD_PRDSN = "PRDSN";
    public static final String FIELD_PRDTAG = "PRDTAG";
    public static final String FIELD_PRDTAG2 = "PRDTAG2";
    public static final String FIELD_PSCOREPRDCATID = "PSCOREPRDCATID";
    public static final String FIELD_PSCOREPRDCATNAME = "PSCOREPRDCATNAME";
    public static final String FIELD_PSCOREPRDCATPATH = "PSCOREPRDCATPATH";
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
    private static final int INDEX_HTTPURLTOREPO = 8;
    private static final int INDEX_INFO = 9;
    private static final int INDEX_MEMO = 10;
    private static final int INDEX_PATH = 11;
    private static final int INDEX_PKGFOLDER = 12;
    private static final int INDEX_PRDSN = 13;
    private static final int INDEX_PRDTAG = 14;
    private static final int INDEX_PRDTAG2 = 15;
    private static final int INDEX_PSCOREPRDCATID = 16;
    private static final int INDEX_PSCOREPRDCATNAME = 17;
    private static final int INDEX_PSCOREPRDCATPATH = 18;
    private static final int INDEX_PSCOREPRDID = 19;
    private static final int INDEX_PSCOREPRDNAME = 20;
    private static final int INDEX_SETTINGS = 21;
    private static final int INDEX_SETTINGURL = 22;
    private static final int INDEX_UPDATEDATE = 23;
    private static final int INDEX_UPDATEMAN = 24;
    private static final int INDEX_VERS = 25;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSCorePrdBase proxyPSCorePrdBase = null;
    private boolean avatarurlDirtyFlag = false;
    private boolean categoryDirtyFlag = false;
    private boolean changelogDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean currentversionDirtyFlag = false;
    private boolean fullnameDirtyFlag = false;
    private boolean fullpathDirtyFlag = false;
    private boolean httpurltorepoDirtyFlag = false;
    private boolean infoDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pathDirtyFlag = false;
    private boolean pkgfolderDirtyFlag = false;
    private boolean prdsnDirtyFlag = false;
    private boolean prdtagDirtyFlag = false;
    private boolean prdtag2DirtyFlag = false;
    private boolean pscoreprdcatidDirtyFlag = false;
    private boolean pscoreprdcatnameDirtyFlag = false;
    private boolean pscoreprdcatpathDirtyFlag = false;
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
    @Column(name="httpurltorepo")
    private String httpurltorepo;
    @Column(name="info")
    private String info;
    @Column(name="memo")
    private String memo;
    @Column(name="path")
    private String path;
    @Column(name="pkgfolder")
    private String pkgfolder;
    @Column(name="prdsn")
    private String prdsn;
    @Column(name="prdtag")
    private String prdtag;
    @Column(name="prdtag2")
    private String prdtag2;
    @Column(name="pscoreprdcatid")
    private String pscoreprdcatid;
    @Column(name="pscoreprdcatname")
    private String pscoreprdcatname;
    @Column(name="pscoreprdcatpath")
    private String pscoreprdcatpath;
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
    private Integer objPSCorePrdCatLock = new Integer(1);
    private PSCorePrdCat pscoreprdcat = null;

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

    public void setPkgFolder(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPkgFolder(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pkgfolder = string;
        this.pkgfolderDirtyFlag = true;
    }

    public String getPkgFolder() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPkgFolder();
        }
        return this.pkgfolder;
    }

    public boolean isPkgFolderDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPkgFolderDirty();
        }
        return this.pkgfolderDirtyFlag;
    }

    public void resetPkgFolder() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPkgFolder();
            return;
        }
        this.pkgfolderDirtyFlag = false;
        this.pkgfolder = null;
    }

    public void setPrdSN(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPrdSN(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.prdsn = string;
        this.prdsnDirtyFlag = true;
    }

    public String getPrdSN() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPrdSN();
        }
        return this.prdsn;
    }

    public boolean isPrdSNDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPrdSNDirty();
        }
        return this.prdsnDirtyFlag;
    }

    public void resetPrdSN() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPrdSN();
            return;
        }
        this.prdsnDirtyFlag = false;
        this.prdsn = null;
    }

    public void setPrdTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPrdTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.prdtag = string;
        this.prdtagDirtyFlag = true;
    }

    public String getPrdTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPrdTag();
        }
        return this.prdtag;
    }

    public boolean isPrdTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPrdTagDirty();
        }
        return this.prdtagDirtyFlag;
    }

    public void resetPrdTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPrdTag();
            return;
        }
        this.prdtagDirtyFlag = false;
        this.prdtag = null;
    }

    public void setPrdTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPrdTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.prdtag2 = string;
        this.prdtag2DirtyFlag = true;
    }

    public String getPrdTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPrdTag2();
        }
        return this.prdtag2;
    }

    public boolean isPrdTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPrdTag2Dirty();
        }
        return this.prdtag2DirtyFlag;
    }

    public void resetPrdTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPrdTag2();
            return;
        }
        this.prdtag2DirtyFlag = false;
        this.prdtag2 = null;
    }

    public void setPSCorePrdCatId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCorePrdCatId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscoreprdcatid = string;
        this.pscoreprdcatidDirtyFlag = true;
    }

    public String getPSCorePrdCatId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCorePrdCatId();
        }
        return this.pscoreprdcatid;
    }

    public boolean isPSCorePrdCatIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCorePrdCatIdDirty();
        }
        return this.pscoreprdcatidDirtyFlag;
    }

    public void resetPSCorePrdCatId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCorePrdCatId();
            return;
        }
        this.pscoreprdcatidDirtyFlag = false;
        this.pscoreprdcatid = null;
    }

    public void setPSCorePrdCatName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCorePrdCatName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscoreprdcatname = string;
        this.pscoreprdcatnameDirtyFlag = true;
    }

    public String getPSCorePrdCatName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCorePrdCatName();
        }
        return this.pscoreprdcatname;
    }

    public boolean isPSCorePrdCatNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCorePrdCatNameDirty();
        }
        return this.pscoreprdcatnameDirtyFlag;
    }

    public void resetPSCorePrdCatName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCorePrdCatName();
            return;
        }
        this.pscoreprdcatnameDirtyFlag = false;
        this.pscoreprdcatname = null;
    }

    public void setPSCorePrdCatPath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCorePrdCatPath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscoreprdcatpath = string;
        this.pscoreprdcatpathDirtyFlag = true;
    }

    public String getPSCorePrdCatPath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCorePrdCatPath();
        }
        return this.pscoreprdcatpath;
    }

    public boolean isPSCorePrdCatPathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCorePrdCatPathDirty();
        }
        return this.pscoreprdcatpathDirtyFlag;
    }

    public void resetPSCorePrdCatPath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCorePrdCatPath();
            return;
        }
        this.pscoreprdcatpathDirtyFlag = false;
        this.pscoreprdcatpath = null;
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
        PSCorePrdBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSCorePrdBase pSCorePrdBase) {
        pSCorePrdBase.resetAvatarUrl();
        pSCorePrdBase.resetCategory();
        pSCorePrdBase.resetChangeLog();
        pSCorePrdBase.resetCreateDate();
        pSCorePrdBase.resetCreateMan();
        pSCorePrdBase.resetCurrentVersion();
        pSCorePrdBase.resetFullName();
        pSCorePrdBase.resetFullPath();
        pSCorePrdBase.resetHttpUrlToRepo();
        pSCorePrdBase.resetInfo();
        pSCorePrdBase.resetMemo();
        pSCorePrdBase.resetPath();
        pSCorePrdBase.resetPkgFolder();
        pSCorePrdBase.resetPrdSN();
        pSCorePrdBase.resetPrdTag();
        pSCorePrdBase.resetPrdTag2();
        pSCorePrdBase.resetPSCorePrdCatId();
        pSCorePrdBase.resetPSCorePrdCatName();
        pSCorePrdBase.resetPSCorePrdCatPath();
        pSCorePrdBase.resetPSCorePrdId();
        pSCorePrdBase.resetPSCorePrdName();
        pSCorePrdBase.resetSettings();
        pSCorePrdBase.resetSettingUrl();
        pSCorePrdBase.resetUpdateDate();
        pSCorePrdBase.resetUpdateMan();
        pSCorePrdBase.resetVers();
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
        if (!bl || this.isHttpUrlToRepoDirty()) {
            hashMap.put(FIELD_HTTPURLTOREPO, this.getHttpUrlToRepo());
        }
        if (!bl || this.isInfoDirty()) {
            hashMap.put(FIELD_INFO, this.getInfo());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPathDirty()) {
            hashMap.put(FIELD_PATH, this.getPath());
        }
        if (!bl || this.isPkgFolderDirty()) {
            hashMap.put(FIELD_PKGFOLDER, this.getPkgFolder());
        }
        if (!bl || this.isPrdSNDirty()) {
            hashMap.put(FIELD_PRDSN, this.getPrdSN());
        }
        if (!bl || this.isPrdTagDirty()) {
            hashMap.put(FIELD_PRDTAG, this.getPrdTag());
        }
        if (!bl || this.isPrdTag2Dirty()) {
            hashMap.put(FIELD_PRDTAG2, this.getPrdTag2());
        }
        if (!bl || this.isPSCorePrdCatIdDirty()) {
            hashMap.put(FIELD_PSCOREPRDCATID, this.getPSCorePrdCatId());
        }
        if (!bl || this.isPSCorePrdCatNameDirty()) {
            hashMap.put(FIELD_PSCOREPRDCATNAME, this.getPSCorePrdCatName());
        }
        if (!bl || this.isPSCorePrdCatPathDirty()) {
            hashMap.put(FIELD_PSCOREPRDCATPATH, this.getPSCorePrdCatPath());
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
        return PSCorePrdBase.get(this, n);
    }

    private static Object get(PSCorePrdBase pSCorePrdBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCorePrdBase.getAvatarUrl();
            }
            case 1: {
                return pSCorePrdBase.getCategory();
            }
            case 2: {
                return pSCorePrdBase.getChangeLog();
            }
            case 3: {
                return pSCorePrdBase.getCreateDate();
            }
            case 4: {
                return pSCorePrdBase.getCreateMan();
            }
            case 5: {
                return pSCorePrdBase.getCurrentVersion();
            }
            case 6: {
                return pSCorePrdBase.getFullName();
            }
            case 7: {
                return pSCorePrdBase.getFullPath();
            }
            case 8: {
                return pSCorePrdBase.getHttpUrlToRepo();
            }
            case 9: {
                return pSCorePrdBase.getInfo();
            }
            case 10: {
                return pSCorePrdBase.getMemo();
            }
            case 11: {
                return pSCorePrdBase.getPath();
            }
            case 12: {
                return pSCorePrdBase.getPkgFolder();
            }
            case 13: {
                return pSCorePrdBase.getPrdSN();
            }
            case 14: {
                return pSCorePrdBase.getPrdTag();
            }
            case 15: {
                return pSCorePrdBase.getPrdTag2();
            }
            case 16: {
                return pSCorePrdBase.getPSCorePrdCatId();
            }
            case 17: {
                return pSCorePrdBase.getPSCorePrdCatName();
            }
            case 18: {
                return pSCorePrdBase.getPSCorePrdCatPath();
            }
            case 19: {
                return pSCorePrdBase.getPSCorePrdId();
            }
            case 20: {
                return pSCorePrdBase.getPSCorePrdName();
            }
            case 21: {
                return pSCorePrdBase.getSettings();
            }
            case 22: {
                return pSCorePrdBase.getSettingUrl();
            }
            case 23: {
                return pSCorePrdBase.getUpdateDate();
            }
            case 24: {
                return pSCorePrdBase.getUpdateMan();
            }
            case 25: {
                return pSCorePrdBase.getVers();
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
        PSCorePrdBase.set(this, n, object);
    }

    private static void set(PSCorePrdBase pSCorePrdBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSCorePrdBase.setAvatarUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSCorePrdBase.setCategory(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSCorePrdBase.setChangeLog(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSCorePrdBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSCorePrdBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSCorePrdBase.setCurrentVersion(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSCorePrdBase.setFullName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSCorePrdBase.setFullPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSCorePrdBase.setHttpUrlToRepo(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSCorePrdBase.setInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSCorePrdBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSCorePrdBase.setPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSCorePrdBase.setPkgFolder(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSCorePrdBase.setPrdSN(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSCorePrdBase.setPrdTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSCorePrdBase.setPrdTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSCorePrdBase.setPSCorePrdCatId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSCorePrdBase.setPSCorePrdCatName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSCorePrdBase.setPSCorePrdCatPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSCorePrdBase.setPSCorePrdId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSCorePrdBase.setPSCorePrdName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSCorePrdBase.setSettings(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSCorePrdBase.setSettingUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSCorePrdBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 24: {
                pSCorePrdBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSCorePrdBase.setVers(DataObject.getStringValue((Object)object));
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
        return PSCorePrdBase.isNull(this, n);
    }

    private static boolean isNull(PSCorePrdBase pSCorePrdBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCorePrdBase.getAvatarUrl() == null;
            }
            case 1: {
                return pSCorePrdBase.getCategory() == null;
            }
            case 2: {
                return pSCorePrdBase.getChangeLog() == null;
            }
            case 3: {
                return pSCorePrdBase.getCreateDate() == null;
            }
            case 4: {
                return pSCorePrdBase.getCreateMan() == null;
            }
            case 5: {
                return pSCorePrdBase.getCurrentVersion() == null;
            }
            case 6: {
                return pSCorePrdBase.getFullName() == null;
            }
            case 7: {
                return pSCorePrdBase.getFullPath() == null;
            }
            case 8: {
                return pSCorePrdBase.getHttpUrlToRepo() == null;
            }
            case 9: {
                return pSCorePrdBase.getInfo() == null;
            }
            case 10: {
                return pSCorePrdBase.getMemo() == null;
            }
            case 11: {
                return pSCorePrdBase.getPath() == null;
            }
            case 12: {
                return pSCorePrdBase.getPkgFolder() == null;
            }
            case 13: {
                return pSCorePrdBase.getPrdSN() == null;
            }
            case 14: {
                return pSCorePrdBase.getPrdTag() == null;
            }
            case 15: {
                return pSCorePrdBase.getPrdTag2() == null;
            }
            case 16: {
                return pSCorePrdBase.getPSCorePrdCatId() == null;
            }
            case 17: {
                return pSCorePrdBase.getPSCorePrdCatName() == null;
            }
            case 18: {
                return pSCorePrdBase.getPSCorePrdCatPath() == null;
            }
            case 19: {
                return pSCorePrdBase.getPSCorePrdId() == null;
            }
            case 20: {
                return pSCorePrdBase.getPSCorePrdName() == null;
            }
            case 21: {
                return pSCorePrdBase.getSettings() == null;
            }
            case 22: {
                return pSCorePrdBase.getSettingUrl() == null;
            }
            case 23: {
                return pSCorePrdBase.getUpdateDate() == null;
            }
            case 24: {
                return pSCorePrdBase.getUpdateMan() == null;
            }
            case 25: {
                return pSCorePrdBase.getVers() == null;
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
        return PSCorePrdBase.contains(this, n);
    }

    private static boolean contains(PSCorePrdBase pSCorePrdBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCorePrdBase.isAvatarUrlDirty();
            }
            case 1: {
                return pSCorePrdBase.isCategoryDirty();
            }
            case 2: {
                return pSCorePrdBase.isChangeLogDirty();
            }
            case 3: {
                return pSCorePrdBase.isCreateDateDirty();
            }
            case 4: {
                return pSCorePrdBase.isCreateManDirty();
            }
            case 5: {
                return pSCorePrdBase.isCurrentVersionDirty();
            }
            case 6: {
                return pSCorePrdBase.isFullNameDirty();
            }
            case 7: {
                return pSCorePrdBase.isFullPathDirty();
            }
            case 8: {
                return pSCorePrdBase.isHttpUrlToRepoDirty();
            }
            case 9: {
                return pSCorePrdBase.isInfoDirty();
            }
            case 10: {
                return pSCorePrdBase.isMemoDirty();
            }
            case 11: {
                return pSCorePrdBase.isPathDirty();
            }
            case 12: {
                return pSCorePrdBase.isPkgFolderDirty();
            }
            case 13: {
                return pSCorePrdBase.isPrdSNDirty();
            }
            case 14: {
                return pSCorePrdBase.isPrdTagDirty();
            }
            case 15: {
                return pSCorePrdBase.isPrdTag2Dirty();
            }
            case 16: {
                return pSCorePrdBase.isPSCorePrdCatIdDirty();
            }
            case 17: {
                return pSCorePrdBase.isPSCorePrdCatNameDirty();
            }
            case 18: {
                return pSCorePrdBase.isPSCorePrdCatPathDirty();
            }
            case 19: {
                return pSCorePrdBase.isPSCorePrdIdDirty();
            }
            case 20: {
                return pSCorePrdBase.isPSCorePrdNameDirty();
            }
            case 21: {
                return pSCorePrdBase.isSettingsDirty();
            }
            case 22: {
                return pSCorePrdBase.isSettingUrlDirty();
            }
            case 23: {
                return pSCorePrdBase.isUpdateDateDirty();
            }
            case 24: {
                return pSCorePrdBase.isUpdateManDirty();
            }
            case 25: {
                return pSCorePrdBase.isVersDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSCorePrdBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSCorePrdBase pSCorePrdBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSCorePrdBase.getAvatarUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"avatarurl", (Object)PSCorePrdBase.getJSONValue((Object)pSCorePrdBase.getAvatarUrl()), (boolean)false);
        }
        if (bl || pSCorePrdBase.getCategory() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"category", (Object)PSCorePrdBase.getJSONValue((Object)pSCorePrdBase.getCategory()), (boolean)false);
        }
        if (bl || pSCorePrdBase.getChangeLog() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"changelog", (Object)PSCorePrdBase.getJSONValue((Object)pSCorePrdBase.getChangeLog()), (boolean)false);
        }
        if (bl || pSCorePrdBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSCorePrdBase.getJSONValue((Object)pSCorePrdBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSCorePrdBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSCorePrdBase.getJSONValue((Object)pSCorePrdBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSCorePrdBase.getCurrentVersion() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"currentversion", (Object)PSCorePrdBase.getJSONValue((Object)pSCorePrdBase.getCurrentVersion()), (boolean)false);
        }
        if (bl || pSCorePrdBase.getFullName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fullname", (Object)PSCorePrdBase.getJSONValue((Object)pSCorePrdBase.getFullName()), (boolean)false);
        }
        if (bl || pSCorePrdBase.getFullPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fullpath", (Object)PSCorePrdBase.getJSONValue((Object)pSCorePrdBase.getFullPath()), (boolean)false);
        }
        if (bl || pSCorePrdBase.getHttpUrlToRepo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"httpurltorepo", (Object)PSCorePrdBase.getJSONValue((Object)pSCorePrdBase.getHttpUrlToRepo()), (boolean)false);
        }
        if (bl || pSCorePrdBase.getInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"info", (Object)PSCorePrdBase.getJSONValue((Object)pSCorePrdBase.getInfo()), (boolean)false);
        }
        if (bl || pSCorePrdBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSCorePrdBase.getJSONValue((Object)pSCorePrdBase.getMemo()), (boolean)false);
        }
        if (bl || pSCorePrdBase.getPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"path", (Object)PSCorePrdBase.getJSONValue((Object)pSCorePrdBase.getPath()), (boolean)false);
        }
        if (bl || pSCorePrdBase.getPkgFolder() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pkgfolder", (Object)PSCorePrdBase.getJSONValue((Object)pSCorePrdBase.getPkgFolder()), (boolean)false);
        }
        if (bl || pSCorePrdBase.getPrdSN() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"prdsn", (Object)PSCorePrdBase.getJSONValue((Object)pSCorePrdBase.getPrdSN()), (boolean)false);
        }
        if (bl || pSCorePrdBase.getPrdTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"prdtag", (Object)PSCorePrdBase.getJSONValue((Object)pSCorePrdBase.getPrdTag()), (boolean)false);
        }
        if (bl || pSCorePrdBase.getPrdTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"prdtag2", (Object)PSCorePrdBase.getJSONValue((Object)pSCorePrdBase.getPrdTag2()), (boolean)false);
        }
        if (bl || pSCorePrdBase.getPSCorePrdCatId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscoreprdcatid", (Object)PSCorePrdBase.getJSONValue((Object)pSCorePrdBase.getPSCorePrdCatId()), (boolean)false);
        }
        if (bl || pSCorePrdBase.getPSCorePrdCatName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscoreprdcatname", (Object)PSCorePrdBase.getJSONValue((Object)pSCorePrdBase.getPSCorePrdCatName()), (boolean)false);
        }
        if (bl || pSCorePrdBase.getPSCorePrdCatPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscoreprdcatpath", (Object)PSCorePrdBase.getJSONValue((Object)pSCorePrdBase.getPSCorePrdCatPath()), (boolean)false);
        }
        if (bl || pSCorePrdBase.getPSCorePrdId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscoreprdid", (Object)PSCorePrdBase.getJSONValue((Object)pSCorePrdBase.getPSCorePrdId()), (boolean)false);
        }
        if (bl || pSCorePrdBase.getPSCorePrdName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscoreprdname", (Object)PSCorePrdBase.getJSONValue((Object)pSCorePrdBase.getPSCorePrdName()), (boolean)false);
        }
        if (bl || pSCorePrdBase.getSettings() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"settings", (Object)PSCorePrdBase.getJSONValue((Object)pSCorePrdBase.getSettings()), (boolean)false);
        }
        if (bl || pSCorePrdBase.getSettingUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"settingurl", (Object)PSCorePrdBase.getJSONValue((Object)pSCorePrdBase.getSettingUrl()), (boolean)false);
        }
        if (bl || pSCorePrdBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSCorePrdBase.getJSONValue((Object)pSCorePrdBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSCorePrdBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSCorePrdBase.getJSONValue((Object)pSCorePrdBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSCorePrdBase.getVers() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"vers", (Object)PSCorePrdBase.getJSONValue((Object)pSCorePrdBase.getVers()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSCorePrdBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSCorePrdBase pSCorePrdBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSCorePrdBase.getAvatarUrl() != null) {
            object = pSCorePrdBase.getAvatarUrl();
            xmlNode.setAttribute(FIELD_AVATARURL, (String)(object == null ? "" : object));
        }
        if (bl || pSCorePrdBase.getCategory() != null) {
            object = pSCorePrdBase.getCategory();
            xmlNode.setAttribute(FIELD_CATEGORY, (String)(object == null ? "" : object));
        }
        if (bl || pSCorePrdBase.getChangeLog() != null) {
            object = pSCorePrdBase.getChangeLog();
            xmlNode.setAttribute(FIELD_CHANGELOG, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdBase.getCreateDate() != null) {
            object = pSCorePrdBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCorePrdBase.getCreateMan() != null) {
            object = pSCorePrdBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdBase.getCurrentVersion() != null) {
            object = pSCorePrdBase.getCurrentVersion();
            xmlNode.setAttribute(FIELD_CURRENTVERSION, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdBase.getFullName() != null) {
            object = pSCorePrdBase.getFullName();
            xmlNode.setAttribute(FIELD_FULLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdBase.getFullPath() != null) {
            object = pSCorePrdBase.getFullPath();
            xmlNode.setAttribute(FIELD_FULLPATH, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdBase.getHttpUrlToRepo() != null) {
            object = pSCorePrdBase.getHttpUrlToRepo();
            xmlNode.setAttribute(FIELD_HTTPURLTOREPO, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdBase.getInfo() != null) {
            object = pSCorePrdBase.getInfo();
            xmlNode.setAttribute(FIELD_INFO, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdBase.getMemo() != null) {
            object = pSCorePrdBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdBase.getPath() != null) {
            object = pSCorePrdBase.getPath();
            xmlNode.setAttribute(FIELD_PATH, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdBase.getPkgFolder() != null) {
            object = pSCorePrdBase.getPkgFolder();
            xmlNode.setAttribute(FIELD_PKGFOLDER, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdBase.getPrdSN() != null) {
            object = pSCorePrdBase.getPrdSN();
            xmlNode.setAttribute(FIELD_PRDSN, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdBase.getPrdTag() != null) {
            object = pSCorePrdBase.getPrdTag();
            xmlNode.setAttribute(FIELD_PRDTAG, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdBase.getPrdTag2() != null) {
            object = pSCorePrdBase.getPrdTag2();
            xmlNode.setAttribute(FIELD_PRDTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdBase.getPSCorePrdCatId() != null) {
            object = pSCorePrdBase.getPSCorePrdCatId();
            xmlNode.setAttribute(FIELD_PSCOREPRDCATID, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdBase.getPSCorePrdCatName() != null) {
            object = pSCorePrdBase.getPSCorePrdCatName();
            xmlNode.setAttribute(FIELD_PSCOREPRDCATNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdBase.getPSCorePrdCatPath() != null) {
            object = pSCorePrdBase.getPSCorePrdCatPath();
            xmlNode.setAttribute(FIELD_PSCOREPRDCATPATH, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdBase.getPSCorePrdId() != null) {
            object = pSCorePrdBase.getPSCorePrdId();
            xmlNode.setAttribute(FIELD_PSCOREPRDID, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdBase.getPSCorePrdName() != null) {
            object = pSCorePrdBase.getPSCorePrdName();
            xmlNode.setAttribute(FIELD_PSCOREPRDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdBase.getSettings() != null) {
            object = pSCorePrdBase.getSettings();
            xmlNode.setAttribute(FIELD_SETTINGS, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdBase.getSettingUrl() != null) {
            object = pSCorePrdBase.getSettingUrl();
            xmlNode.setAttribute(FIELD_SETTINGURL, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdBase.getUpdateDate() != null) {
            object = pSCorePrdBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCorePrdBase.getUpdateMan() != null) {
            object = pSCorePrdBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdBase.getVers() != null) {
            object = pSCorePrdBase.getVers();
            xmlNode.setAttribute(FIELD_VERS, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSCorePrdBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSCorePrdBase pSCorePrdBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSCorePrdBase.isAvatarUrlDirty() && (bl || pSCorePrdBase.getAvatarUrl() != null)) {
            iDataObject.set(FIELD_AVATARURL, (Object)pSCorePrdBase.getAvatarUrl());
        }
        if (pSCorePrdBase.isCategoryDirty() && (bl || pSCorePrdBase.getCategory() != null)) {
            iDataObject.set(FIELD_CATEGORY, (Object)pSCorePrdBase.getCategory());
        }
        if (pSCorePrdBase.isChangeLogDirty() && (bl || pSCorePrdBase.getChangeLog() != null)) {
            iDataObject.set(FIELD_CHANGELOG, (Object)pSCorePrdBase.getChangeLog());
        }
        if (pSCorePrdBase.isCreateDateDirty() && (bl || pSCorePrdBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSCorePrdBase.getCreateDate());
        }
        if (pSCorePrdBase.isCreateManDirty() && (bl || pSCorePrdBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSCorePrdBase.getCreateMan());
        }
        if (pSCorePrdBase.isCurrentVersionDirty() && (bl || pSCorePrdBase.getCurrentVersion() != null)) {
            iDataObject.set(FIELD_CURRENTVERSION, (Object)pSCorePrdBase.getCurrentVersion());
        }
        if (pSCorePrdBase.isFullNameDirty() && (bl || pSCorePrdBase.getFullName() != null)) {
            iDataObject.set(FIELD_FULLNAME, (Object)pSCorePrdBase.getFullName());
        }
        if (pSCorePrdBase.isFullPathDirty() && (bl || pSCorePrdBase.getFullPath() != null)) {
            iDataObject.set(FIELD_FULLPATH, (Object)pSCorePrdBase.getFullPath());
        }
        if (pSCorePrdBase.isHttpUrlToRepoDirty() && (bl || pSCorePrdBase.getHttpUrlToRepo() != null)) {
            iDataObject.set(FIELD_HTTPURLTOREPO, (Object)pSCorePrdBase.getHttpUrlToRepo());
        }
        if (pSCorePrdBase.isInfoDirty() && (bl || pSCorePrdBase.getInfo() != null)) {
            iDataObject.set(FIELD_INFO, (Object)pSCorePrdBase.getInfo());
        }
        if (pSCorePrdBase.isMemoDirty() && (bl || pSCorePrdBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSCorePrdBase.getMemo());
        }
        if (pSCorePrdBase.isPathDirty() && (bl || pSCorePrdBase.getPath() != null)) {
            iDataObject.set(FIELD_PATH, (Object)pSCorePrdBase.getPath());
        }
        if (pSCorePrdBase.isPkgFolderDirty() && (bl || pSCorePrdBase.getPkgFolder() != null)) {
            iDataObject.set(FIELD_PKGFOLDER, (Object)pSCorePrdBase.getPkgFolder());
        }
        if (pSCorePrdBase.isPrdSNDirty() && (bl || pSCorePrdBase.getPrdSN() != null)) {
            iDataObject.set(FIELD_PRDSN, (Object)pSCorePrdBase.getPrdSN());
        }
        if (pSCorePrdBase.isPrdTagDirty() && (bl || pSCorePrdBase.getPrdTag() != null)) {
            iDataObject.set(FIELD_PRDTAG, (Object)pSCorePrdBase.getPrdTag());
        }
        if (pSCorePrdBase.isPrdTag2Dirty() && (bl || pSCorePrdBase.getPrdTag2() != null)) {
            iDataObject.set(FIELD_PRDTAG2, (Object)pSCorePrdBase.getPrdTag2());
        }
        if (pSCorePrdBase.isPSCorePrdCatIdDirty() && (bl || pSCorePrdBase.getPSCorePrdCatId() != null)) {
            iDataObject.set(FIELD_PSCOREPRDCATID, (Object)pSCorePrdBase.getPSCorePrdCatId());
        }
        if (pSCorePrdBase.isPSCorePrdCatNameDirty() && (bl || pSCorePrdBase.getPSCorePrdCatName() != null)) {
            iDataObject.set(FIELD_PSCOREPRDCATNAME, (Object)pSCorePrdBase.getPSCorePrdCatName());
        }
        if (pSCorePrdBase.isPSCorePrdCatPathDirty() && (bl || pSCorePrdBase.getPSCorePrdCatPath() != null)) {
            iDataObject.set(FIELD_PSCOREPRDCATPATH, (Object)pSCorePrdBase.getPSCorePrdCatPath());
        }
        if (pSCorePrdBase.isPSCorePrdIdDirty() && (bl || pSCorePrdBase.getPSCorePrdId() != null)) {
            iDataObject.set(FIELD_PSCOREPRDID, (Object)pSCorePrdBase.getPSCorePrdId());
        }
        if (pSCorePrdBase.isPSCorePrdNameDirty() && (bl || pSCorePrdBase.getPSCorePrdName() != null)) {
            iDataObject.set(FIELD_PSCOREPRDNAME, (Object)pSCorePrdBase.getPSCorePrdName());
        }
        if (pSCorePrdBase.isSettingsDirty() && (bl || pSCorePrdBase.getSettings() != null)) {
            iDataObject.set(FIELD_SETTINGS, (Object)pSCorePrdBase.getSettings());
        }
        if (pSCorePrdBase.isSettingUrlDirty() && (bl || pSCorePrdBase.getSettingUrl() != null)) {
            iDataObject.set(FIELD_SETTINGURL, (Object)pSCorePrdBase.getSettingUrl());
        }
        if (pSCorePrdBase.isUpdateDateDirty() && (bl || pSCorePrdBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSCorePrdBase.getUpdateDate());
        }
        if (pSCorePrdBase.isUpdateManDirty() && (bl || pSCorePrdBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSCorePrdBase.getUpdateMan());
        }
        if (pSCorePrdBase.isVersDirty() && (bl || pSCorePrdBase.getVers() != null)) {
            iDataObject.set(FIELD_VERS, (Object)pSCorePrdBase.getVers());
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
        return PSCorePrdBase.remove(this, n);
    }

    private static boolean remove(PSCorePrdBase pSCorePrdBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSCorePrdBase.resetAvatarUrl();
                return true;
            }
            case 1: {
                pSCorePrdBase.resetCategory();
                return true;
            }
            case 2: {
                pSCorePrdBase.resetChangeLog();
                return true;
            }
            case 3: {
                pSCorePrdBase.resetCreateDate();
                return true;
            }
            case 4: {
                pSCorePrdBase.resetCreateMan();
                return true;
            }
            case 5: {
                pSCorePrdBase.resetCurrentVersion();
                return true;
            }
            case 6: {
                pSCorePrdBase.resetFullName();
                return true;
            }
            case 7: {
                pSCorePrdBase.resetFullPath();
                return true;
            }
            case 8: {
                pSCorePrdBase.resetHttpUrlToRepo();
                return true;
            }
            case 9: {
                pSCorePrdBase.resetInfo();
                return true;
            }
            case 10: {
                pSCorePrdBase.resetMemo();
                return true;
            }
            case 11: {
                pSCorePrdBase.resetPath();
                return true;
            }
            case 12: {
                pSCorePrdBase.resetPkgFolder();
                return true;
            }
            case 13: {
                pSCorePrdBase.resetPrdSN();
                return true;
            }
            case 14: {
                pSCorePrdBase.resetPrdTag();
                return true;
            }
            case 15: {
                pSCorePrdBase.resetPrdTag2();
                return true;
            }
            case 16: {
                pSCorePrdBase.resetPSCorePrdCatId();
                return true;
            }
            case 17: {
                pSCorePrdBase.resetPSCorePrdCatName();
                return true;
            }
            case 18: {
                pSCorePrdBase.resetPSCorePrdCatPath();
                return true;
            }
            case 19: {
                pSCorePrdBase.resetPSCorePrdId();
                return true;
            }
            case 20: {
                pSCorePrdBase.resetPSCorePrdName();
                return true;
            }
            case 21: {
                pSCorePrdBase.resetSettings();
                return true;
            }
            case 22: {
                pSCorePrdBase.resetSettingUrl();
                return true;
            }
            case 23: {
                pSCorePrdBase.resetUpdateDate();
                return true;
            }
            case 24: {
                pSCorePrdBase.resetUpdateMan();
                return true;
            }
            case 25: {
                pSCorePrdBase.resetVers();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCorePrdCat getPSCorePrdCat() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCorePrdCat();
        }
        if (this.getPSCorePrdCatId() == null) {
            return null;
        }
        Integer n = this.objPSCorePrdCatLock;
        synchronized (n) {
            if (this.pscoreprdcat != null && DataTypeHelper.compare((int)25, (Object)this.getPSCorePrdCatId(), (Object)this.pscoreprdcat.getPSCorePrdCatId()) != 0L) {
                this.pscoreprdcat = null;
            }
            if (this.pscoreprdcat == null) {
                PSCorePrdCat pSCorePrdCat = new PSCorePrdCat();
                pSCorePrdCat.setPSCorePrdCatId(this.getPSCorePrdCatId());
                PSCorePrdCatService pSCorePrdCatService = (PSCorePrdCatService)ServiceGlobal.getService(PSCorePrdCatService.class, (SessionFactory)this.getSessionFactory());
                pSCorePrdCatService.autoGet((IEntity)pSCorePrdCat);
                this.pscoreprdcat = pSCorePrdCat;
            }
            return this.pscoreprdcat;
        }
    }

    private PSCorePrdBase getProxyEntity() {
        return this.proxyPSCorePrdBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSCorePrdBase = null;
        if (iDataObject != null && iDataObject instanceof PSCorePrdBase) {
            this.proxyPSCorePrdBase = (PSCorePrdBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
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
        fieldIndexMap.put(FIELD_HTTPURLTOREPO, 8);
        fieldIndexMap.put(FIELD_INFO, 9);
        fieldIndexMap.put(FIELD_MEMO, 10);
        fieldIndexMap.put(FIELD_PATH, 11);
        fieldIndexMap.put(FIELD_PKGFOLDER, 12);
        fieldIndexMap.put(FIELD_PRDSN, 13);
        fieldIndexMap.put(FIELD_PRDTAG, 14);
        fieldIndexMap.put(FIELD_PRDTAG2, 15);
        fieldIndexMap.put(FIELD_PSCOREPRDCATID, 16);
        fieldIndexMap.put(FIELD_PSCOREPRDCATNAME, 17);
        fieldIndexMap.put(FIELD_PSCOREPRDCATPATH, 18);
        fieldIndexMap.put(FIELD_PSCOREPRDID, 19);
        fieldIndexMap.put(FIELD_PSCOREPRDNAME, 20);
        fieldIndexMap.put(FIELD_SETTINGS, 21);
        fieldIndexMap.put(FIELD_SETTINGURL, 22);
        fieldIndexMap.put(FIELD_UPDATEDATE, 23);
        fieldIndexMap.put(FIELD_UPDATEMAN, 24);
        fieldIndexMap.put(FIELD_VERS, 25);
    }
}

