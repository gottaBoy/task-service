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
package net.ibizsys.pscore.srv.appdesign.entity;

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
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppResourceBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSAppResourceBase.class);
    public static final String FIELD_CONTENT = "CONTENT";
    public static final String FIELD_CONTENTPSLANRESID = "CONTENTPSLANRESID";
    public static final String FIELD_CONTENTPSLANRESNAME = "CONTENTPSLANRESNAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSAPPRESOURCEID = "PSAPPRESOURCEID";
    public static final String FIELD_PSAPPRESOURCENAME = "PSAPPRESOURCENAME";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String FIELD_RESOURCETYPE = "RESOURCETYPE";
    public static final String FIELD_RESTAG = "RESTAG";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CONTENT = 0;
    private static final int INDEX_CONTENTPSLANRESID = 1;
    private static final int INDEX_CONTENTPSLANRESNAME = 2;
    private static final int INDEX_CREATEDATE = 3;
    private static final int INDEX_CREATEMAN = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_PSAPPRESOURCEID = 6;
    private static final int INDEX_PSAPPRESOURCENAME = 7;
    private static final int INDEX_PSSYSAPPID = 8;
    private static final int INDEX_PSSYSAPPNAME = 9;
    private static final int INDEX_RESOURCETYPE = 10;
    private static final int INDEX_RESTAG = 11;
    private static final int INDEX_UPDATEDATE = 12;
    private static final int INDEX_UPDATEMAN = 13;
    private static final int INDEX_USERCAT = 14;
    private static final int INDEX_USERTAG = 15;
    private static final int INDEX_USERTAG2 = 16;
    private static final int INDEX_USERTAG3 = 17;
    private static final int INDEX_USERTAG4 = 18;
    private static final int INDEX_VALIDFLAG = 19;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSAppResourceBase proxyPSAppResourceBase = null;
    private boolean contentDirtyFlag = false;
    private boolean contentpslanresidDirtyFlag = false;
    private boolean contentpslanresnameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psappresourceidDirtyFlag = false;
    private boolean psappresourcenameDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean pssysappnameDirtyFlag = false;
    private boolean resourcetypeDirtyFlag = false;
    private boolean restagDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="content")
    private String content;
    @Column(name="contentpslanresid")
    private String contentpslanresid;
    @Column(name="contentpslanresname")
    private String contentpslanresname;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psappresourceid")
    private String psappresourceid;
    @Column(name="psappresourcename")
    private String psappresourcename;
    @Column(name="pssysappid")
    private String pssysappid;
    @Column(name="pssysappname")
    private String pssysappname;
    @Column(name="resourcetype")
    private String resourcetype;
    @Column(name="restag")
    private String restag;
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
    private Integer objContentPSLanResLock = new Integer(1);
    private PSLanguageRes contentpslanres = null;
    private Integer objPSSysAppLock = new Integer(1);
    private PSSysApp pssysapp = null;

    public void setContent(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setContent(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.content = string;
        this.contentDirtyFlag = true;
    }

    public String getContent() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContent();
        }
        return this.content;
    }

    public boolean isContentDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isContentDirty();
        }
        return this.contentDirtyFlag;
    }

    public void resetContent() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetContent();
            return;
        }
        this.contentDirtyFlag = false;
        this.content = null;
    }

    public void setContentPSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setContentPSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.contentpslanresid = string;
        this.contentpslanresidDirtyFlag = true;
    }

    public String getContentPSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContentPSLanResId();
        }
        return this.contentpslanresid;
    }

    public boolean isContentPSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isContentPSLanResIdDirty();
        }
        return this.contentpslanresidDirtyFlag;
    }

    public void resetContentPSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetContentPSLanResId();
            return;
        }
        this.contentpslanresidDirtyFlag = false;
        this.contentpslanresid = null;
    }

    public void setContentPSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setContentPSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.contentpslanresname = string;
        this.contentpslanresnameDirtyFlag = true;
    }

    public String getContentPSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContentPSLanResName();
        }
        return this.contentpslanresname;
    }

    public boolean isContentPSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isContentPSLanResNameDirty();
        }
        return this.contentpslanresnameDirtyFlag;
    }

    public void resetContentPSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetContentPSLanResName();
            return;
        }
        this.contentpslanresnameDirtyFlag = false;
        this.contentpslanresname = null;
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

    public void setPSAppResourceId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppResourceId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappresourceid = string;
        this.psappresourceidDirtyFlag = true;
    }

    public String getPSAppResourceId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppResourceId();
        }
        return this.psappresourceid;
    }

    public boolean isPSAppResourceIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppResourceIdDirty();
        }
        return this.psappresourceidDirtyFlag;
    }

    public void resetPSAppResourceId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppResourceId();
            return;
        }
        this.psappresourceidDirtyFlag = false;
        this.psappresourceid = null;
    }

    public void setPSAppResourceName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppResourceName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappresourcename = string;
        this.psappresourcenameDirtyFlag = true;
    }

    public String getPSAppResourceName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppResourceName();
        }
        return this.psappresourcename;
    }

    public boolean isPSAppResourceNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppResourceNameDirty();
        }
        return this.psappresourcenameDirtyFlag;
    }

    public void resetPSAppResourceName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppResourceName();
            return;
        }
        this.psappresourcenameDirtyFlag = false;
        this.psappresourcename = null;
    }

    public void setPSSysAppId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAppId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysappid = string;
        this.pssysappidDirtyFlag = true;
    }

    public String getPSSysAppId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAppId();
        }
        return this.pssysappid;
    }

    public boolean isPSSysAppIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAppIdDirty();
        }
        return this.pssysappidDirtyFlag;
    }

    public void resetPSSysAppId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAppId();
            return;
        }
        this.pssysappidDirtyFlag = false;
        this.pssysappid = null;
    }

    public void setPSSysAppName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAppName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysappname = string;
        this.pssysappnameDirtyFlag = true;
    }

    public String getPSSysAppName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAppName();
        }
        return this.pssysappname;
    }

    public boolean isPSSysAppNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAppNameDirty();
        }
        return this.pssysappnameDirtyFlag;
    }

    public void resetPSSysAppName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAppName();
            return;
        }
        this.pssysappnameDirtyFlag = false;
        this.pssysappname = null;
    }

    public void setResourceType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResourceType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.resourcetype = string;
        this.resourcetypeDirtyFlag = true;
    }

    public String getResourceType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResourceType();
        }
        return this.resourcetype;
    }

    public boolean isResourceTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResourceTypeDirty();
        }
        return this.resourcetypeDirtyFlag;
    }

    public void resetResourceType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResourceType();
            return;
        }
        this.resourcetypeDirtyFlag = false;
        this.resourcetype = null;
    }

    public void setResTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.restag = string;
        this.restagDirtyFlag = true;
    }

    public String getResTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResTag();
        }
        return this.restag;
    }

    public boolean isResTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResTagDirty();
        }
        return this.restagDirtyFlag;
    }

    public void resetResTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResTag();
            return;
        }
        this.restagDirtyFlag = false;
        this.restag = null;
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

    protected void onReset() {
        PSAppResourceBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSAppResourceBase pSAppResourceBase) {
        pSAppResourceBase.resetContent();
        pSAppResourceBase.resetContentPSLanResId();
        pSAppResourceBase.resetContentPSLanResName();
        pSAppResourceBase.resetCreateDate();
        pSAppResourceBase.resetCreateMan();
        pSAppResourceBase.resetMemo();
        pSAppResourceBase.resetPSAppResourceId();
        pSAppResourceBase.resetPSAppResourceName();
        pSAppResourceBase.resetPSSysAppId();
        pSAppResourceBase.resetPSSysAppName();
        pSAppResourceBase.resetResourceType();
        pSAppResourceBase.resetResTag();
        pSAppResourceBase.resetUpdateDate();
        pSAppResourceBase.resetUpdateMan();
        pSAppResourceBase.resetUserCat();
        pSAppResourceBase.resetUserTag();
        pSAppResourceBase.resetUserTag2();
        pSAppResourceBase.resetUserTag3();
        pSAppResourceBase.resetUserTag4();
        pSAppResourceBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isContentDirty()) {
            hashMap.put(FIELD_CONTENT, this.getContent());
        }
        if (!bl || this.isContentPSLanResIdDirty()) {
            hashMap.put(FIELD_CONTENTPSLANRESID, this.getContentPSLanResId());
        }
        if (!bl || this.isContentPSLanResNameDirty()) {
            hashMap.put(FIELD_CONTENTPSLANRESNAME, this.getContentPSLanResName());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSAppResourceIdDirty()) {
            hashMap.put(FIELD_PSAPPRESOURCEID, this.getPSAppResourceId());
        }
        if (!bl || this.isPSAppResourceNameDirty()) {
            hashMap.put(FIELD_PSAPPRESOURCENAME, this.getPSAppResourceName());
        }
        if (!bl || this.isPSSysAppIdDirty()) {
            hashMap.put(FIELD_PSSYSAPPID, this.getPSSysAppId());
        }
        if (!bl || this.isPSSysAppNameDirty()) {
            hashMap.put(FIELD_PSSYSAPPNAME, this.getPSSysAppName());
        }
        if (!bl || this.isResourceTypeDirty()) {
            hashMap.put(FIELD_RESOURCETYPE, this.getResourceType());
        }
        if (!bl || this.isResTagDirty()) {
            hashMap.put(FIELD_RESTAG, this.getResTag());
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
        return PSAppResourceBase.get(this, n);
    }

    private static Object get(PSAppResourceBase pSAppResourceBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppResourceBase.getContent();
            }
            case 1: {
                return pSAppResourceBase.getContentPSLanResId();
            }
            case 2: {
                return pSAppResourceBase.getContentPSLanResName();
            }
            case 3: {
                return pSAppResourceBase.getCreateDate();
            }
            case 4: {
                return pSAppResourceBase.getCreateMan();
            }
            case 5: {
                return pSAppResourceBase.getMemo();
            }
            case 6: {
                return pSAppResourceBase.getPSAppResourceId();
            }
            case 7: {
                return pSAppResourceBase.getPSAppResourceName();
            }
            case 8: {
                return pSAppResourceBase.getPSSysAppId();
            }
            case 9: {
                return pSAppResourceBase.getPSSysAppName();
            }
            case 10: {
                return pSAppResourceBase.getResourceType();
            }
            case 11: {
                return pSAppResourceBase.getResTag();
            }
            case 12: {
                return pSAppResourceBase.getUpdateDate();
            }
            case 13: {
                return pSAppResourceBase.getUpdateMan();
            }
            case 14: {
                return pSAppResourceBase.getUserCat();
            }
            case 15: {
                return pSAppResourceBase.getUserTag();
            }
            case 16: {
                return pSAppResourceBase.getUserTag2();
            }
            case 17: {
                return pSAppResourceBase.getUserTag3();
            }
            case 18: {
                return pSAppResourceBase.getUserTag4();
            }
            case 19: {
                return pSAppResourceBase.getValidFlag();
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
        PSAppResourceBase.set(this, n, object);
    }

    private static void set(PSAppResourceBase pSAppResourceBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSAppResourceBase.setContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSAppResourceBase.setContentPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSAppResourceBase.setContentPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSAppResourceBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSAppResourceBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSAppResourceBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSAppResourceBase.setPSAppResourceId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSAppResourceBase.setPSAppResourceName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSAppResourceBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSAppResourceBase.setPSSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSAppResourceBase.setResourceType(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSAppResourceBase.setResTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSAppResourceBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 13: {
                pSAppResourceBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSAppResourceBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSAppResourceBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSAppResourceBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSAppResourceBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSAppResourceBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSAppResourceBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSAppResourceBase.isNull(this, n);
    }

    private static boolean isNull(PSAppResourceBase pSAppResourceBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppResourceBase.getContent() == null;
            }
            case 1: {
                return pSAppResourceBase.getContentPSLanResId() == null;
            }
            case 2: {
                return pSAppResourceBase.getContentPSLanResName() == null;
            }
            case 3: {
                return pSAppResourceBase.getCreateDate() == null;
            }
            case 4: {
                return pSAppResourceBase.getCreateMan() == null;
            }
            case 5: {
                return pSAppResourceBase.getMemo() == null;
            }
            case 6: {
                return pSAppResourceBase.getPSAppResourceId() == null;
            }
            case 7: {
                return pSAppResourceBase.getPSAppResourceName() == null;
            }
            case 8: {
                return pSAppResourceBase.getPSSysAppId() == null;
            }
            case 9: {
                return pSAppResourceBase.getPSSysAppName() == null;
            }
            case 10: {
                return pSAppResourceBase.getResourceType() == null;
            }
            case 11: {
                return pSAppResourceBase.getResTag() == null;
            }
            case 12: {
                return pSAppResourceBase.getUpdateDate() == null;
            }
            case 13: {
                return pSAppResourceBase.getUpdateMan() == null;
            }
            case 14: {
                return pSAppResourceBase.getUserCat() == null;
            }
            case 15: {
                return pSAppResourceBase.getUserTag() == null;
            }
            case 16: {
                return pSAppResourceBase.getUserTag2() == null;
            }
            case 17: {
                return pSAppResourceBase.getUserTag3() == null;
            }
            case 18: {
                return pSAppResourceBase.getUserTag4() == null;
            }
            case 19: {
                return pSAppResourceBase.getValidFlag() == null;
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
        return PSAppResourceBase.contains(this, n);
    }

    private static boolean contains(PSAppResourceBase pSAppResourceBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppResourceBase.isContentDirty();
            }
            case 1: {
                return pSAppResourceBase.isContentPSLanResIdDirty();
            }
            case 2: {
                return pSAppResourceBase.isContentPSLanResNameDirty();
            }
            case 3: {
                return pSAppResourceBase.isCreateDateDirty();
            }
            case 4: {
                return pSAppResourceBase.isCreateManDirty();
            }
            case 5: {
                return pSAppResourceBase.isMemoDirty();
            }
            case 6: {
                return pSAppResourceBase.isPSAppResourceIdDirty();
            }
            case 7: {
                return pSAppResourceBase.isPSAppResourceNameDirty();
            }
            case 8: {
                return pSAppResourceBase.isPSSysAppIdDirty();
            }
            case 9: {
                return pSAppResourceBase.isPSSysAppNameDirty();
            }
            case 10: {
                return pSAppResourceBase.isResourceTypeDirty();
            }
            case 11: {
                return pSAppResourceBase.isResTagDirty();
            }
            case 12: {
                return pSAppResourceBase.isUpdateDateDirty();
            }
            case 13: {
                return pSAppResourceBase.isUpdateManDirty();
            }
            case 14: {
                return pSAppResourceBase.isUserCatDirty();
            }
            case 15: {
                return pSAppResourceBase.isUserTagDirty();
            }
            case 16: {
                return pSAppResourceBase.isUserTag2Dirty();
            }
            case 17: {
                return pSAppResourceBase.isUserTag3Dirty();
            }
            case 18: {
                return pSAppResourceBase.isUserTag4Dirty();
            }
            case 19: {
                return pSAppResourceBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSAppResourceBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSAppResourceBase pSAppResourceBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSAppResourceBase.getContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"content", (Object)PSAppResourceBase.getJSONValue((Object)pSAppResourceBase.getContent()), (boolean)false);
        }
        if (bl || pSAppResourceBase.getContentPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"contentpslanresid", (Object)PSAppResourceBase.getJSONValue((Object)pSAppResourceBase.getContentPSLanResId()), (boolean)false);
        }
        if (bl || pSAppResourceBase.getContentPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"contentpslanresname", (Object)PSAppResourceBase.getJSONValue((Object)pSAppResourceBase.getContentPSLanResName()), (boolean)false);
        }
        if (bl || pSAppResourceBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSAppResourceBase.getJSONValue((Object)pSAppResourceBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSAppResourceBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSAppResourceBase.getJSONValue((Object)pSAppResourceBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSAppResourceBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSAppResourceBase.getJSONValue((Object)pSAppResourceBase.getMemo()), (boolean)false);
        }
        if (bl || pSAppResourceBase.getPSAppResourceId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappresourceid", (Object)PSAppResourceBase.getJSONValue((Object)pSAppResourceBase.getPSAppResourceId()), (boolean)false);
        }
        if (bl || pSAppResourceBase.getPSAppResourceName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappresourcename", (Object)PSAppResourceBase.getJSONValue((Object)pSAppResourceBase.getPSAppResourceName()), (boolean)false);
        }
        if (bl || pSAppResourceBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSAppResourceBase.getJSONValue((Object)pSAppResourceBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSAppResourceBase.getPSSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappname", (Object)PSAppResourceBase.getJSONValue((Object)pSAppResourceBase.getPSSysAppName()), (boolean)false);
        }
        if (bl || pSAppResourceBase.getResourceType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resourcetype", (Object)PSAppResourceBase.getJSONValue((Object)pSAppResourceBase.getResourceType()), (boolean)false);
        }
        if (bl || pSAppResourceBase.getResTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"restag", (Object)PSAppResourceBase.getJSONValue((Object)pSAppResourceBase.getResTag()), (boolean)false);
        }
        if (bl || pSAppResourceBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSAppResourceBase.getJSONValue((Object)pSAppResourceBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSAppResourceBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSAppResourceBase.getJSONValue((Object)pSAppResourceBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSAppResourceBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSAppResourceBase.getJSONValue((Object)pSAppResourceBase.getUserCat()), (boolean)false);
        }
        if (bl || pSAppResourceBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSAppResourceBase.getJSONValue((Object)pSAppResourceBase.getUserTag()), (boolean)false);
        }
        if (bl || pSAppResourceBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSAppResourceBase.getJSONValue((Object)pSAppResourceBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSAppResourceBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSAppResourceBase.getJSONValue((Object)pSAppResourceBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSAppResourceBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSAppResourceBase.getJSONValue((Object)pSAppResourceBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSAppResourceBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSAppResourceBase.getJSONValue((Object)pSAppResourceBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSAppResourceBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSAppResourceBase pSAppResourceBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSAppResourceBase.getContent() != null) {
            object = pSAppResourceBase.getContent();
            xmlNode.setAttribute(FIELD_CONTENT, (String)(object == null ? "" : object));
        }
        if (bl || pSAppResourceBase.getContentPSLanResId() != null) {
            object = pSAppResourceBase.getContentPSLanResId();
            xmlNode.setAttribute(FIELD_CONTENTPSLANRESID, (String)(object == null ? "" : object));
        }
        if (bl || pSAppResourceBase.getContentPSLanResName() != null) {
            object = pSAppResourceBase.getContentPSLanResName();
            xmlNode.setAttribute(FIELD_CONTENTPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppResourceBase.getCreateDate() != null) {
            object = pSAppResourceBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppResourceBase.getCreateMan() != null) {
            object = pSAppResourceBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppResourceBase.getMemo() != null) {
            object = pSAppResourceBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSAppResourceBase.getPSAppResourceId() != null) {
            object = pSAppResourceBase.getPSAppResourceId();
            xmlNode.setAttribute(FIELD_PSAPPRESOURCEID, object == null ? "" : (String)object);
        }
        if (bl || pSAppResourceBase.getPSAppResourceName() != null) {
            object = pSAppResourceBase.getPSAppResourceName();
            xmlNode.setAttribute(FIELD_PSAPPRESOURCENAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppResourceBase.getPSSysAppId() != null) {
            object = pSAppResourceBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSAppResourceBase.getPSSysAppName() != null) {
            object = pSAppResourceBase.getPSSysAppName();
            xmlNode.setAttribute(FIELD_PSSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppResourceBase.getResourceType() != null) {
            object = pSAppResourceBase.getResourceType();
            xmlNode.setAttribute(FIELD_RESOURCETYPE, object == null ? "" : (String)object);
        }
        if (bl || pSAppResourceBase.getResTag() != null) {
            object = pSAppResourceBase.getResTag();
            xmlNode.setAttribute(FIELD_RESTAG, object == null ? "" : (String)object);
        }
        if (bl || pSAppResourceBase.getUpdateDate() != null) {
            object = pSAppResourceBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppResourceBase.getUpdateMan() != null) {
            object = pSAppResourceBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppResourceBase.getUserCat() != null) {
            object = pSAppResourceBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSAppResourceBase.getUserTag() != null) {
            object = pSAppResourceBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSAppResourceBase.getUserTag2() != null) {
            object = pSAppResourceBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSAppResourceBase.getUserTag3() != null) {
            object = pSAppResourceBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSAppResourceBase.getUserTag4() != null) {
            object = pSAppResourceBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSAppResourceBase.getValidFlag() != null) {
            object = pSAppResourceBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSAppResourceBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSAppResourceBase pSAppResourceBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSAppResourceBase.isContentDirty() && (bl || pSAppResourceBase.getContent() != null)) {
            iDataObject.set(FIELD_CONTENT, (Object)pSAppResourceBase.getContent());
        }
        if (pSAppResourceBase.isContentPSLanResIdDirty() && (bl || pSAppResourceBase.getContentPSLanResId() != null)) {
            iDataObject.set(FIELD_CONTENTPSLANRESID, (Object)pSAppResourceBase.getContentPSLanResId());
        }
        if (pSAppResourceBase.isContentPSLanResNameDirty() && (bl || pSAppResourceBase.getContentPSLanResName() != null)) {
            iDataObject.set(FIELD_CONTENTPSLANRESNAME, (Object)pSAppResourceBase.getContentPSLanResName());
        }
        if (pSAppResourceBase.isCreateDateDirty() && (bl || pSAppResourceBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSAppResourceBase.getCreateDate());
        }
        if (pSAppResourceBase.isCreateManDirty() && (bl || pSAppResourceBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSAppResourceBase.getCreateMan());
        }
        if (pSAppResourceBase.isMemoDirty() && (bl || pSAppResourceBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSAppResourceBase.getMemo());
        }
        if (pSAppResourceBase.isPSAppResourceIdDirty() && (bl || pSAppResourceBase.getPSAppResourceId() != null)) {
            iDataObject.set(FIELD_PSAPPRESOURCEID, (Object)pSAppResourceBase.getPSAppResourceId());
        }
        if (pSAppResourceBase.isPSAppResourceNameDirty() && (bl || pSAppResourceBase.getPSAppResourceName() != null)) {
            iDataObject.set(FIELD_PSAPPRESOURCENAME, (Object)pSAppResourceBase.getPSAppResourceName());
        }
        if (pSAppResourceBase.isPSSysAppIdDirty() && (bl || pSAppResourceBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSAppResourceBase.getPSSysAppId());
        }
        if (pSAppResourceBase.isPSSysAppNameDirty() && (bl || pSAppResourceBase.getPSSysAppName() != null)) {
            iDataObject.set(FIELD_PSSYSAPPNAME, (Object)pSAppResourceBase.getPSSysAppName());
        }
        if (pSAppResourceBase.isResourceTypeDirty() && (bl || pSAppResourceBase.getResourceType() != null)) {
            iDataObject.set(FIELD_RESOURCETYPE, (Object)pSAppResourceBase.getResourceType());
        }
        if (pSAppResourceBase.isResTagDirty() && (bl || pSAppResourceBase.getResTag() != null)) {
            iDataObject.set(FIELD_RESTAG, (Object)pSAppResourceBase.getResTag());
        }
        if (pSAppResourceBase.isUpdateDateDirty() && (bl || pSAppResourceBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSAppResourceBase.getUpdateDate());
        }
        if (pSAppResourceBase.isUpdateManDirty() && (bl || pSAppResourceBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSAppResourceBase.getUpdateMan());
        }
        if (pSAppResourceBase.isUserCatDirty() && (bl || pSAppResourceBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSAppResourceBase.getUserCat());
        }
        if (pSAppResourceBase.isUserTagDirty() && (bl || pSAppResourceBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSAppResourceBase.getUserTag());
        }
        if (pSAppResourceBase.isUserTag2Dirty() && (bl || pSAppResourceBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSAppResourceBase.getUserTag2());
        }
        if (pSAppResourceBase.isUserTag3Dirty() && (bl || pSAppResourceBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSAppResourceBase.getUserTag3());
        }
        if (pSAppResourceBase.isUserTag4Dirty() && (bl || pSAppResourceBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSAppResourceBase.getUserTag4());
        }
        if (pSAppResourceBase.isValidFlagDirty() && (bl || pSAppResourceBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSAppResourceBase.getValidFlag());
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
        return PSAppResourceBase.remove(this, n);
    }

    private static boolean remove(PSAppResourceBase pSAppResourceBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSAppResourceBase.resetContent();
                return true;
            }
            case 1: {
                pSAppResourceBase.resetContentPSLanResId();
                return true;
            }
            case 2: {
                pSAppResourceBase.resetContentPSLanResName();
                return true;
            }
            case 3: {
                pSAppResourceBase.resetCreateDate();
                return true;
            }
            case 4: {
                pSAppResourceBase.resetCreateMan();
                return true;
            }
            case 5: {
                pSAppResourceBase.resetMemo();
                return true;
            }
            case 6: {
                pSAppResourceBase.resetPSAppResourceId();
                return true;
            }
            case 7: {
                pSAppResourceBase.resetPSAppResourceName();
                return true;
            }
            case 8: {
                pSAppResourceBase.resetPSSysAppId();
                return true;
            }
            case 9: {
                pSAppResourceBase.resetPSSysAppName();
                return true;
            }
            case 10: {
                pSAppResourceBase.resetResourceType();
                return true;
            }
            case 11: {
                pSAppResourceBase.resetResTag();
                return true;
            }
            case 12: {
                pSAppResourceBase.resetUpdateDate();
                return true;
            }
            case 13: {
                pSAppResourceBase.resetUpdateMan();
                return true;
            }
            case 14: {
                pSAppResourceBase.resetUserCat();
                return true;
            }
            case 15: {
                pSAppResourceBase.resetUserTag();
                return true;
            }
            case 16: {
                pSAppResourceBase.resetUserTag2();
                return true;
            }
            case 17: {
                pSAppResourceBase.resetUserTag3();
                return true;
            }
            case 18: {
                pSAppResourceBase.resetUserTag4();
                return true;
            }
            case 19: {
                pSAppResourceBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguageRes getContentPSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContentPSLanRes();
        }
        if (this.getContentPSLanResId() == null) {
            return null;
        }
        Integer n = this.objContentPSLanResLock;
        synchronized (n) {
            if (this.contentpslanres != null && DataTypeHelper.compare((int)25, (Object)this.getContentPSLanResId(), (Object)this.contentpslanres.getPSLanguageResId()) != 0L) {
                this.contentpslanres = null;
            }
            if (this.contentpslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getContentPSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet((IEntity)pSLanguageRes);
                this.contentpslanres = pSLanguageRes;
            }
            return this.contentpslanres;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysApp getPSSysApp() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysApp();
        }
        if (this.getPSSysAppId() == null) {
            return null;
        }
        Integer n = this.objPSSysAppLock;
        synchronized (n) {
            if (this.pssysapp != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysAppId(), (Object)this.pssysapp.getPSSysAppId()) != 0L) {
                this.pssysapp = null;
            }
            if (this.pssysapp == null) {
                PSSysApp pSSysApp = new PSSysApp();
                pSSysApp.setPSSysAppId(this.getPSSysAppId());
                PSSysAppService pSSysAppService = (PSSysAppService)ServiceGlobal.getService(PSSysAppService.class, (SessionFactory)this.getSessionFactory());
                pSSysAppService.autoGet((IEntity)pSSysApp);
                this.pssysapp = pSSysApp;
            }
            return this.pssysapp;
        }
    }

    private PSAppResourceBase getProxyEntity() {
        return this.proxyPSAppResourceBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSAppResourceBase = null;
        if (iDataObject != null && iDataObject instanceof PSAppResourceBase) {
            this.proxyPSAppResourceBase = (PSAppResourceBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppResourceService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CONTENT, 0);
        fieldIndexMap.put(FIELD_CONTENTPSLANRESID, 1);
        fieldIndexMap.put(FIELD_CONTENTPSLANRESNAME, 2);
        fieldIndexMap.put(FIELD_CREATEDATE, 3);
        fieldIndexMap.put(FIELD_CREATEMAN, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_PSAPPRESOURCEID, 6);
        fieldIndexMap.put(FIELD_PSAPPRESOURCENAME, 7);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 8);
        fieldIndexMap.put(FIELD_PSSYSAPPNAME, 9);
        fieldIndexMap.put(FIELD_RESOURCETYPE, 10);
        fieldIndexMap.put(FIELD_RESTAG, 11);
        fieldIndexMap.put(FIELD_UPDATEDATE, 12);
        fieldIndexMap.put(FIELD_UPDATEMAN, 13);
        fieldIndexMap.put(FIELD_USERCAT, 14);
        fieldIndexMap.put(FIELD_USERTAG, 15);
        fieldIndexMap.put(FIELD_USERTAG2, 16);
        fieldIndexMap.put(FIELD_USERTAG3, 17);
        fieldIndexMap.put(FIELD_USERTAG4, 18);
        fieldIndexMap.put(FIELD_VALIDFLAG, 19);
    }
}

