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
import net.ibizsys.pscore.srv.appdesign.entity.PSAppLocalDE;
import net.ibizsys.pscore.srv.appdesign.service.PSAppLocalDEService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysPortlet;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysPortletService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppPortletBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSAppPortletBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSAPPLOCALDEID = "PSAPPLOCALDEID";
    public static final String FIELD_PSAPPLOCALDENAME = "PSAPPLOCALDENAME";
    public static final String FIELD_PSAPPPORTLETID = "PSAPPPORTLETID";
    public static final String FIELD_PSAPPPORTLETNAME = "PSAPPPORTLETNAME";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String FIELD_PSSYSPORTLETID = "PSSYSPORTLETID";
    public static final String FIELD_PSSYSPORTLETNAME = "PSSYSPORTLETNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSAPPLOCALDEID = 4;
    private static final int INDEX_PSAPPLOCALDENAME = 5;
    private static final int INDEX_PSAPPPORTLETID = 6;
    private static final int INDEX_PSAPPPORTLETNAME = 7;
    private static final int INDEX_PSSYSAPPID = 8;
    private static final int INDEX_PSSYSAPPNAME = 9;
    private static final int INDEX_PSSYSPORTLETID = 10;
    private static final int INDEX_PSSYSPORTLETNAME = 11;
    private static final int INDEX_UPDATEDATE = 12;
    private static final int INDEX_UPDATEMAN = 13;
    private static final int INDEX_USERCAT = 14;
    private static final int INDEX_USERTAG = 15;
    private static final int INDEX_USERTAG2 = 16;
    private static final int INDEX_USERTAG3 = 17;
    private static final int INDEX_USERTAG4 = 18;
    private static final int INDEX_VALIDFLAG = 19;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSAppPortletBase proxyPSAppPortletBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psapplocaldeidDirtyFlag = false;
    private boolean psapplocaldenameDirtyFlag = false;
    private boolean psappportletidDirtyFlag = false;
    private boolean psappportletnameDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean pssysappnameDirtyFlag = false;
    private boolean pssysportletidDirtyFlag = false;
    private boolean pssysportletnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psapplocaldeid")
    private String psapplocaldeid;
    @Column(name="psapplocaldename")
    private String psapplocaldename;
    @Column(name="psappportletid")
    private String psappportletid;
    @Column(name="psappportletname")
    private String psappportletname;
    @Column(name="pssysappid")
    private String pssysappid;
    @Column(name="pssysappname")
    private String pssysappname;
    @Column(name="pssysportletid")
    private String pssysportletid;
    @Column(name="pssysportletname")
    private String pssysportletname;
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
    private Integer objPSAppLocalDELock = new Integer(1);
    private PSAppLocalDE psapplocalde = null;
    private Integer objPSSysAppLock = new Integer(1);
    private PSSysApp pssysapp = null;
    private Integer objPSSysPortletLock = new Integer(1);
    private PSSysPortlet pssysportlet = null;

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

    public void setPSAppLocalDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppLocalDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psapplocaldeid = string;
        this.psapplocaldeidDirtyFlag = true;
    }

    public String getPSAppLocalDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppLocalDEId();
        }
        return this.psapplocaldeid;
    }

    public boolean isPSAppLocalDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppLocalDEIdDirty();
        }
        return this.psapplocaldeidDirtyFlag;
    }

    public void resetPSAppLocalDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppLocalDEId();
            return;
        }
        this.psapplocaldeidDirtyFlag = false;
        this.psapplocaldeid = null;
    }

    public void setPSAppLocalDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppLocalDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psapplocaldename = string;
        this.psapplocaldenameDirtyFlag = true;
    }

    public String getPSAppLocalDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppLocalDEName();
        }
        return this.psapplocaldename;
    }

    public boolean isPSAppLocalDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppLocalDENameDirty();
        }
        return this.psapplocaldenameDirtyFlag;
    }

    public void resetPSAppLocalDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppLocalDEName();
            return;
        }
        this.psapplocaldenameDirtyFlag = false;
        this.psapplocaldename = null;
    }

    public void setPSAppPortletId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppPortletId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappportletid = string;
        this.psappportletidDirtyFlag = true;
    }

    public String getPSAppPortletId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppPortletId();
        }
        return this.psappportletid;
    }

    public boolean isPSAppPortletIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppPortletIdDirty();
        }
        return this.psappportletidDirtyFlag;
    }

    public void resetPSAppPortletId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppPortletId();
            return;
        }
        this.psappportletidDirtyFlag = false;
        this.psappportletid = null;
    }

    public void setPSAppPortletName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppPortletName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappportletname = string;
        this.psappportletnameDirtyFlag = true;
    }

    public String getPSAppPortletName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppPortletName();
        }
        return this.psappportletname;
    }

    public boolean isPSAppPortletNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppPortletNameDirty();
        }
        return this.psappportletnameDirtyFlag;
    }

    public void resetPSAppPortletName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppPortletName();
            return;
        }
        this.psappportletnameDirtyFlag = false;
        this.psappportletname = null;
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

    public void setPSSysPortletId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysPortletId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysportletid = string;
        this.pssysportletidDirtyFlag = true;
    }

    public String getPSSysPortletId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPortletId();
        }
        return this.pssysportletid;
    }

    public boolean isPSSysPortletIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysPortletIdDirty();
        }
        return this.pssysportletidDirtyFlag;
    }

    public void resetPSSysPortletId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysPortletId();
            return;
        }
        this.pssysportletidDirtyFlag = false;
        this.pssysportletid = null;
    }

    public void setPSSysPortletName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysPortletName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysportletname = string;
        this.pssysportletnameDirtyFlag = true;
    }

    public String getPSSysPortletName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPortletName();
        }
        return this.pssysportletname;
    }

    public boolean isPSSysPortletNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysPortletNameDirty();
        }
        return this.pssysportletnameDirtyFlag;
    }

    public void resetPSSysPortletName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysPortletName();
            return;
        }
        this.pssysportletnameDirtyFlag = false;
        this.pssysportletname = null;
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
        PSAppPortletBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSAppPortletBase pSAppPortletBase) {
        pSAppPortletBase.resetCodeName();
        pSAppPortletBase.resetCreateDate();
        pSAppPortletBase.resetCreateMan();
        pSAppPortletBase.resetMemo();
        pSAppPortletBase.resetPSAppLocalDEId();
        pSAppPortletBase.resetPSAppLocalDEName();
        pSAppPortletBase.resetPSAppPortletId();
        pSAppPortletBase.resetPSAppPortletName();
        pSAppPortletBase.resetPSSysAppId();
        pSAppPortletBase.resetPSSysAppName();
        pSAppPortletBase.resetPSSysPortletId();
        pSAppPortletBase.resetPSSysPortletName();
        pSAppPortletBase.resetUpdateDate();
        pSAppPortletBase.resetUpdateMan();
        pSAppPortletBase.resetUserCat();
        pSAppPortletBase.resetUserTag();
        pSAppPortletBase.resetUserTag2();
        pSAppPortletBase.resetUserTag3();
        pSAppPortletBase.resetUserTag4();
        pSAppPortletBase.resetValidFlag();
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
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSAppLocalDEIdDirty()) {
            hashMap.put(FIELD_PSAPPLOCALDEID, this.getPSAppLocalDEId());
        }
        if (!bl || this.isPSAppLocalDENameDirty()) {
            hashMap.put(FIELD_PSAPPLOCALDENAME, this.getPSAppLocalDEName());
        }
        if (!bl || this.isPSAppPortletIdDirty()) {
            hashMap.put(FIELD_PSAPPPORTLETID, this.getPSAppPortletId());
        }
        if (!bl || this.isPSAppPortletNameDirty()) {
            hashMap.put(FIELD_PSAPPPORTLETNAME, this.getPSAppPortletName());
        }
        if (!bl || this.isPSSysAppIdDirty()) {
            hashMap.put(FIELD_PSSYSAPPID, this.getPSSysAppId());
        }
        if (!bl || this.isPSSysAppNameDirty()) {
            hashMap.put(FIELD_PSSYSAPPNAME, this.getPSSysAppName());
        }
        if (!bl || this.isPSSysPortletIdDirty()) {
            hashMap.put(FIELD_PSSYSPORTLETID, this.getPSSysPortletId());
        }
        if (!bl || this.isPSSysPortletNameDirty()) {
            hashMap.put(FIELD_PSSYSPORTLETNAME, this.getPSSysPortletName());
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
        return PSAppPortletBase.get(this, n);
    }

    private static Object get(PSAppPortletBase pSAppPortletBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppPortletBase.getCodeName();
            }
            case 1: {
                return pSAppPortletBase.getCreateDate();
            }
            case 2: {
                return pSAppPortletBase.getCreateMan();
            }
            case 3: {
                return pSAppPortletBase.getMemo();
            }
            case 4: {
                return pSAppPortletBase.getPSAppLocalDEId();
            }
            case 5: {
                return pSAppPortletBase.getPSAppLocalDEName();
            }
            case 6: {
                return pSAppPortletBase.getPSAppPortletId();
            }
            case 7: {
                return pSAppPortletBase.getPSAppPortletName();
            }
            case 8: {
                return pSAppPortletBase.getPSSysAppId();
            }
            case 9: {
                return pSAppPortletBase.getPSSysAppName();
            }
            case 10: {
                return pSAppPortletBase.getPSSysPortletId();
            }
            case 11: {
                return pSAppPortletBase.getPSSysPortletName();
            }
            case 12: {
                return pSAppPortletBase.getUpdateDate();
            }
            case 13: {
                return pSAppPortletBase.getUpdateMan();
            }
            case 14: {
                return pSAppPortletBase.getUserCat();
            }
            case 15: {
                return pSAppPortletBase.getUserTag();
            }
            case 16: {
                return pSAppPortletBase.getUserTag2();
            }
            case 17: {
                return pSAppPortletBase.getUserTag3();
            }
            case 18: {
                return pSAppPortletBase.getUserTag4();
            }
            case 19: {
                return pSAppPortletBase.getValidFlag();
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
        PSAppPortletBase.set(this, n, object);
    }

    private static void set(PSAppPortletBase pSAppPortletBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSAppPortletBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSAppPortletBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSAppPortletBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSAppPortletBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSAppPortletBase.setPSAppLocalDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSAppPortletBase.setPSAppLocalDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSAppPortletBase.setPSAppPortletId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSAppPortletBase.setPSAppPortletName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSAppPortletBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSAppPortletBase.setPSSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSAppPortletBase.setPSSysPortletId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSAppPortletBase.setPSSysPortletName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSAppPortletBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 13: {
                pSAppPortletBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSAppPortletBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSAppPortletBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSAppPortletBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSAppPortletBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSAppPortletBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSAppPortletBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSAppPortletBase.isNull(this, n);
    }

    private static boolean isNull(PSAppPortletBase pSAppPortletBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppPortletBase.getCodeName() == null;
            }
            case 1: {
                return pSAppPortletBase.getCreateDate() == null;
            }
            case 2: {
                return pSAppPortletBase.getCreateMan() == null;
            }
            case 3: {
                return pSAppPortletBase.getMemo() == null;
            }
            case 4: {
                return pSAppPortletBase.getPSAppLocalDEId() == null;
            }
            case 5: {
                return pSAppPortletBase.getPSAppLocalDEName() == null;
            }
            case 6: {
                return pSAppPortletBase.getPSAppPortletId() == null;
            }
            case 7: {
                return pSAppPortletBase.getPSAppPortletName() == null;
            }
            case 8: {
                return pSAppPortletBase.getPSSysAppId() == null;
            }
            case 9: {
                return pSAppPortletBase.getPSSysAppName() == null;
            }
            case 10: {
                return pSAppPortletBase.getPSSysPortletId() == null;
            }
            case 11: {
                return pSAppPortletBase.getPSSysPortletName() == null;
            }
            case 12: {
                return pSAppPortletBase.getUpdateDate() == null;
            }
            case 13: {
                return pSAppPortletBase.getUpdateMan() == null;
            }
            case 14: {
                return pSAppPortletBase.getUserCat() == null;
            }
            case 15: {
                return pSAppPortletBase.getUserTag() == null;
            }
            case 16: {
                return pSAppPortletBase.getUserTag2() == null;
            }
            case 17: {
                return pSAppPortletBase.getUserTag3() == null;
            }
            case 18: {
                return pSAppPortletBase.getUserTag4() == null;
            }
            case 19: {
                return pSAppPortletBase.getValidFlag() == null;
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
        return PSAppPortletBase.contains(this, n);
    }

    private static boolean contains(PSAppPortletBase pSAppPortletBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppPortletBase.isCodeNameDirty();
            }
            case 1: {
                return pSAppPortletBase.isCreateDateDirty();
            }
            case 2: {
                return pSAppPortletBase.isCreateManDirty();
            }
            case 3: {
                return pSAppPortletBase.isMemoDirty();
            }
            case 4: {
                return pSAppPortletBase.isPSAppLocalDEIdDirty();
            }
            case 5: {
                return pSAppPortletBase.isPSAppLocalDENameDirty();
            }
            case 6: {
                return pSAppPortletBase.isPSAppPortletIdDirty();
            }
            case 7: {
                return pSAppPortletBase.isPSAppPortletNameDirty();
            }
            case 8: {
                return pSAppPortletBase.isPSSysAppIdDirty();
            }
            case 9: {
                return pSAppPortletBase.isPSSysAppNameDirty();
            }
            case 10: {
                return pSAppPortletBase.isPSSysPortletIdDirty();
            }
            case 11: {
                return pSAppPortletBase.isPSSysPortletNameDirty();
            }
            case 12: {
                return pSAppPortletBase.isUpdateDateDirty();
            }
            case 13: {
                return pSAppPortletBase.isUpdateManDirty();
            }
            case 14: {
                return pSAppPortletBase.isUserCatDirty();
            }
            case 15: {
                return pSAppPortletBase.isUserTagDirty();
            }
            case 16: {
                return pSAppPortletBase.isUserTag2Dirty();
            }
            case 17: {
                return pSAppPortletBase.isUserTag3Dirty();
            }
            case 18: {
                return pSAppPortletBase.isUserTag4Dirty();
            }
            case 19: {
                return pSAppPortletBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSAppPortletBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSAppPortletBase pSAppPortletBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSAppPortletBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSAppPortletBase.getJSONValue((Object)pSAppPortletBase.getCodeName()), (boolean)false);
        }
        if (bl || pSAppPortletBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSAppPortletBase.getJSONValue((Object)pSAppPortletBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSAppPortletBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSAppPortletBase.getJSONValue((Object)pSAppPortletBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSAppPortletBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSAppPortletBase.getJSONValue((Object)pSAppPortletBase.getMemo()), (boolean)false);
        }
        if (bl || pSAppPortletBase.getPSAppLocalDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psapplocaldeid", (Object)PSAppPortletBase.getJSONValue((Object)pSAppPortletBase.getPSAppLocalDEId()), (boolean)false);
        }
        if (bl || pSAppPortletBase.getPSAppLocalDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psapplocaldename", (Object)PSAppPortletBase.getJSONValue((Object)pSAppPortletBase.getPSAppLocalDEName()), (boolean)false);
        }
        if (bl || pSAppPortletBase.getPSAppPortletId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappportletid", (Object)PSAppPortletBase.getJSONValue((Object)pSAppPortletBase.getPSAppPortletId()), (boolean)false);
        }
        if (bl || pSAppPortletBase.getPSAppPortletName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappportletname", (Object)PSAppPortletBase.getJSONValue((Object)pSAppPortletBase.getPSAppPortletName()), (boolean)false);
        }
        if (bl || pSAppPortletBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSAppPortletBase.getJSONValue((Object)pSAppPortletBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSAppPortletBase.getPSSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappname", (Object)PSAppPortletBase.getJSONValue((Object)pSAppPortletBase.getPSSysAppName()), (boolean)false);
        }
        if (bl || pSAppPortletBase.getPSSysPortletId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysportletid", (Object)PSAppPortletBase.getJSONValue((Object)pSAppPortletBase.getPSSysPortletId()), (boolean)false);
        }
        if (bl || pSAppPortletBase.getPSSysPortletName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysportletname", (Object)PSAppPortletBase.getJSONValue((Object)pSAppPortletBase.getPSSysPortletName()), (boolean)false);
        }
        if (bl || pSAppPortletBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSAppPortletBase.getJSONValue((Object)pSAppPortletBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSAppPortletBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSAppPortletBase.getJSONValue((Object)pSAppPortletBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSAppPortletBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSAppPortletBase.getJSONValue((Object)pSAppPortletBase.getUserCat()), (boolean)false);
        }
        if (bl || pSAppPortletBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSAppPortletBase.getJSONValue((Object)pSAppPortletBase.getUserTag()), (boolean)false);
        }
        if (bl || pSAppPortletBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSAppPortletBase.getJSONValue((Object)pSAppPortletBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSAppPortletBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSAppPortletBase.getJSONValue((Object)pSAppPortletBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSAppPortletBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSAppPortletBase.getJSONValue((Object)pSAppPortletBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSAppPortletBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSAppPortletBase.getJSONValue((Object)pSAppPortletBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSAppPortletBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSAppPortletBase pSAppPortletBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSAppPortletBase.getCodeName() != null) {
            object = pSAppPortletBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppPortletBase.getCreateDate() != null) {
            object = pSAppPortletBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppPortletBase.getCreateMan() != null) {
            object = pSAppPortletBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppPortletBase.getMemo() != null) {
            object = pSAppPortletBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSAppPortletBase.getPSAppLocalDEId() != null) {
            object = pSAppPortletBase.getPSAppLocalDEId();
            xmlNode.setAttribute(FIELD_PSAPPLOCALDEID, object == null ? "" : (String)object);
        }
        if (bl || pSAppPortletBase.getPSAppLocalDEName() != null) {
            object = pSAppPortletBase.getPSAppLocalDEName();
            xmlNode.setAttribute(FIELD_PSAPPLOCALDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppPortletBase.getPSAppPortletId() != null) {
            object = pSAppPortletBase.getPSAppPortletId();
            xmlNode.setAttribute(FIELD_PSAPPPORTLETID, object == null ? "" : (String)object);
        }
        if (bl || pSAppPortletBase.getPSAppPortletName() != null) {
            object = pSAppPortletBase.getPSAppPortletName();
            xmlNode.setAttribute(FIELD_PSAPPPORTLETNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppPortletBase.getPSSysAppId() != null) {
            object = pSAppPortletBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSAppPortletBase.getPSSysAppName() != null) {
            object = pSAppPortletBase.getPSSysAppName();
            xmlNode.setAttribute(FIELD_PSSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppPortletBase.getPSSysPortletId() != null) {
            object = pSAppPortletBase.getPSSysPortletId();
            xmlNode.setAttribute(FIELD_PSSYSPORTLETID, object == null ? "" : (String)object);
        }
        if (bl || pSAppPortletBase.getPSSysPortletName() != null) {
            object = pSAppPortletBase.getPSSysPortletName();
            xmlNode.setAttribute(FIELD_PSSYSPORTLETNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppPortletBase.getUpdateDate() != null) {
            object = pSAppPortletBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppPortletBase.getUpdateMan() != null) {
            object = pSAppPortletBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppPortletBase.getUserCat() != null) {
            object = pSAppPortletBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSAppPortletBase.getUserTag() != null) {
            object = pSAppPortletBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSAppPortletBase.getUserTag2() != null) {
            object = pSAppPortletBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSAppPortletBase.getUserTag3() != null) {
            object = pSAppPortletBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSAppPortletBase.getUserTag4() != null) {
            object = pSAppPortletBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSAppPortletBase.getValidFlag() != null) {
            object = pSAppPortletBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSAppPortletBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSAppPortletBase pSAppPortletBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSAppPortletBase.isCodeNameDirty() && (bl || pSAppPortletBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSAppPortletBase.getCodeName());
        }
        if (pSAppPortletBase.isCreateDateDirty() && (bl || pSAppPortletBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSAppPortletBase.getCreateDate());
        }
        if (pSAppPortletBase.isCreateManDirty() && (bl || pSAppPortletBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSAppPortletBase.getCreateMan());
        }
        if (pSAppPortletBase.isMemoDirty() && (bl || pSAppPortletBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSAppPortletBase.getMemo());
        }
        if (pSAppPortletBase.isPSAppLocalDEIdDirty() && (bl || pSAppPortletBase.getPSAppLocalDEId() != null)) {
            iDataObject.set(FIELD_PSAPPLOCALDEID, (Object)pSAppPortletBase.getPSAppLocalDEId());
        }
        if (pSAppPortletBase.isPSAppLocalDENameDirty() && (bl || pSAppPortletBase.getPSAppLocalDEName() != null)) {
            iDataObject.set(FIELD_PSAPPLOCALDENAME, (Object)pSAppPortletBase.getPSAppLocalDEName());
        }
        if (pSAppPortletBase.isPSAppPortletIdDirty() && (bl || pSAppPortletBase.getPSAppPortletId() != null)) {
            iDataObject.set(FIELD_PSAPPPORTLETID, (Object)pSAppPortletBase.getPSAppPortletId());
        }
        if (pSAppPortletBase.isPSAppPortletNameDirty() && (bl || pSAppPortletBase.getPSAppPortletName() != null)) {
            iDataObject.set(FIELD_PSAPPPORTLETNAME, (Object)pSAppPortletBase.getPSAppPortletName());
        }
        if (pSAppPortletBase.isPSSysAppIdDirty() && (bl || pSAppPortletBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSAppPortletBase.getPSSysAppId());
        }
        if (pSAppPortletBase.isPSSysAppNameDirty() && (bl || pSAppPortletBase.getPSSysAppName() != null)) {
            iDataObject.set(FIELD_PSSYSAPPNAME, (Object)pSAppPortletBase.getPSSysAppName());
        }
        if (pSAppPortletBase.isPSSysPortletIdDirty() && (bl || pSAppPortletBase.getPSSysPortletId() != null)) {
            iDataObject.set(FIELD_PSSYSPORTLETID, (Object)pSAppPortletBase.getPSSysPortletId());
        }
        if (pSAppPortletBase.isPSSysPortletNameDirty() && (bl || pSAppPortletBase.getPSSysPortletName() != null)) {
            iDataObject.set(FIELD_PSSYSPORTLETNAME, (Object)pSAppPortletBase.getPSSysPortletName());
        }
        if (pSAppPortletBase.isUpdateDateDirty() && (bl || pSAppPortletBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSAppPortletBase.getUpdateDate());
        }
        if (pSAppPortletBase.isUpdateManDirty() && (bl || pSAppPortletBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSAppPortletBase.getUpdateMan());
        }
        if (pSAppPortletBase.isUserCatDirty() && (bl || pSAppPortletBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSAppPortletBase.getUserCat());
        }
        if (pSAppPortletBase.isUserTagDirty() && (bl || pSAppPortletBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSAppPortletBase.getUserTag());
        }
        if (pSAppPortletBase.isUserTag2Dirty() && (bl || pSAppPortletBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSAppPortletBase.getUserTag2());
        }
        if (pSAppPortletBase.isUserTag3Dirty() && (bl || pSAppPortletBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSAppPortletBase.getUserTag3());
        }
        if (pSAppPortletBase.isUserTag4Dirty() && (bl || pSAppPortletBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSAppPortletBase.getUserTag4());
        }
        if (pSAppPortletBase.isValidFlagDirty() && (bl || pSAppPortletBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSAppPortletBase.getValidFlag());
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
        return PSAppPortletBase.remove(this, n);
    }

    private static boolean remove(PSAppPortletBase pSAppPortletBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSAppPortletBase.resetCodeName();
                return true;
            }
            case 1: {
                pSAppPortletBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSAppPortletBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSAppPortletBase.resetMemo();
                return true;
            }
            case 4: {
                pSAppPortletBase.resetPSAppLocalDEId();
                return true;
            }
            case 5: {
                pSAppPortletBase.resetPSAppLocalDEName();
                return true;
            }
            case 6: {
                pSAppPortletBase.resetPSAppPortletId();
                return true;
            }
            case 7: {
                pSAppPortletBase.resetPSAppPortletName();
                return true;
            }
            case 8: {
                pSAppPortletBase.resetPSSysAppId();
                return true;
            }
            case 9: {
                pSAppPortletBase.resetPSSysAppName();
                return true;
            }
            case 10: {
                pSAppPortletBase.resetPSSysPortletId();
                return true;
            }
            case 11: {
                pSAppPortletBase.resetPSSysPortletName();
                return true;
            }
            case 12: {
                pSAppPortletBase.resetUpdateDate();
                return true;
            }
            case 13: {
                pSAppPortletBase.resetUpdateMan();
                return true;
            }
            case 14: {
                pSAppPortletBase.resetUserCat();
                return true;
            }
            case 15: {
                pSAppPortletBase.resetUserTag();
                return true;
            }
            case 16: {
                pSAppPortletBase.resetUserTag2();
                return true;
            }
            case 17: {
                pSAppPortletBase.resetUserTag3();
                return true;
            }
            case 18: {
                pSAppPortletBase.resetUserTag4();
                return true;
            }
            case 19: {
                pSAppPortletBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSAppLocalDE getPSAppLocalDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppLocalDE();
        }
        if (this.getPSAppLocalDEId() == null) {
            return null;
        }
        Integer n = this.objPSAppLocalDELock;
        synchronized (n) {
            if (this.psapplocalde != null && DataTypeHelper.compare((int)25, (Object)this.getPSAppLocalDEId(), (Object)this.psapplocalde.getPSAppLocalDEId()) != 0L) {
                this.psapplocalde = null;
            }
            if (this.psapplocalde == null) {
                PSAppLocalDE pSAppLocalDE = new PSAppLocalDE();
                pSAppLocalDE.setPSAppLocalDEId(this.getPSAppLocalDEId());
                PSAppLocalDEService pSAppLocalDEService = (PSAppLocalDEService)ServiceGlobal.getService(PSAppLocalDEService.class, (SessionFactory)this.getSessionFactory());
                pSAppLocalDEService.autoGet(pSAppLocalDE);
                this.psapplocalde = pSAppLocalDE;
            }
            return this.psapplocalde;
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
                pSSysAppService.autoGet(pSSysApp);
                this.pssysapp = pSSysApp;
            }
            return this.pssysapp;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysPortlet getPSSysPortlet() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPortlet();
        }
        if (this.getPSSysPortletId() == null) {
            return null;
        }
        Integer n = this.objPSSysPortletLock;
        synchronized (n) {
            if (this.pssysportlet != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysPortletId(), (Object)this.pssysportlet.getPSSysPortletId()) != 0L) {
                this.pssysportlet = null;
            }
            if (this.pssysportlet == null) {
                PSSysPortlet pSSysPortlet = new PSSysPortlet();
                pSSysPortlet.setPSSysPortletId(this.getPSSysPortletId());
                PSSysPortletService pSSysPortletService = (PSSysPortletService)ServiceGlobal.getService(PSSysPortletService.class, (SessionFactory)this.getSessionFactory());
                pSSysPortletService.autoGet(pSSysPortlet);
                this.pssysportlet = pSSysPortlet;
            }
            return this.pssysportlet;
        }
    }

    private PSAppPortletBase getProxyEntity() {
        return this.proxyPSAppPortletBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSAppPortletBase = null;
        if (iDataObject != null && iDataObject instanceof PSAppPortletBase) {
            this.proxyPSAppPortletBase = (PSAppPortletBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppPortletService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSAPPLOCALDEID, 4);
        fieldIndexMap.put(FIELD_PSAPPLOCALDENAME, 5);
        fieldIndexMap.put(FIELD_PSAPPPORTLETID, 6);
        fieldIndexMap.put(FIELD_PSAPPPORTLETNAME, 7);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 8);
        fieldIndexMap.put(FIELD_PSSYSAPPNAME, 9);
        fieldIndexMap.put(FIELD_PSSYSPORTLETID, 10);
        fieldIndexMap.put(FIELD_PSSYSPORTLETNAME, 11);
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

