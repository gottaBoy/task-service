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
package net.ibizsys.pscore.srv.sysdeploy.entity;

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
import net.ibizsys.pscore.srv.devcenter.entity.PSSaaSSysApp;
import net.ibizsys.pscore.srv.devcenter.service.PSSaaSSysAppService;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSysVer;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSysVerService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysApp;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysAppService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDepSysAppBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDepSysAppBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEPSYSAPPID = "PSDEPSYSAPPID";
    public static final String FIELD_PSDEPSYSAPPNAME = "PSDEPSYSAPPNAME";
    public static final String FIELD_PSDEPSYSAPPTYPE = "PSDEPSYSAPPTYPE";
    public static final String FIELD_PSDEPSYSVERID = "PSDEPSYSVERID";
    public static final String FIELD_PSDEPSYSVERNAME = "PSDEPSYSVERNAME";
    public static final String FIELD_PSDEVSLNSYSAPPID = "PSDEVSLNSYSAPPID";
    public static final String FIELD_PSDEVSLNSYSAPPNAME = "PSDEVSLNSYSAPPNAME";
    public static final String FIELD_PSSAASSYSAPPID = "PSSAASSYSAPPID";
    public static final String FIELD_PSSAASSYSAPPNAME = "PSSAASSYSAPPNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSDEPSYSAPPID = 3;
    private static final int INDEX_PSDEPSYSAPPNAME = 4;
    private static final int INDEX_PSDEPSYSAPPTYPE = 5;
    private static final int INDEX_PSDEPSYSVERID = 6;
    private static final int INDEX_PSDEPSYSVERNAME = 7;
    private static final int INDEX_PSDEVSLNSYSAPPID = 8;
    private static final int INDEX_PSDEVSLNSYSAPPNAME = 9;
    private static final int INDEX_PSSAASSYSAPPID = 10;
    private static final int INDEX_PSSAASSYSAPPNAME = 11;
    private static final int INDEX_UPDATEDATE = 12;
    private static final int INDEX_UPDATEMAN = 13;
    private static final int INDEX_USERCAT = 14;
    private static final int INDEX_USERTAG = 15;
    private static final int INDEX_USERTAG2 = 16;
    private static final int INDEX_USERTAG3 = 17;
    private static final int INDEX_USERTAG4 = 18;
    private static final int INDEX_VALIDFLAG = 19;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDepSysAppBase proxyPSDepSysAppBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdepsysappidDirtyFlag = false;
    private boolean psdepsysappnameDirtyFlag = false;
    private boolean psdepsysapptypeDirtyFlag = false;
    private boolean psdepsysveridDirtyFlag = false;
    private boolean psdepsysvernameDirtyFlag = false;
    private boolean psdevslnsysappidDirtyFlag = false;
    private boolean psdevslnsysappnameDirtyFlag = false;
    private boolean pssaassysappidDirtyFlag = false;
    private boolean pssaassysappnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psdepsysappid")
    private String psdepsysappid;
    @Column(name="psdepsysappname")
    private String psdepsysappname;
    @Column(name="psdepsysapptype")
    private String psdepsysapptype;
    @Column(name="psdepsysverid")
    private String psdepsysverid;
    @Column(name="psdepsysvername")
    private String psdepsysvername;
    @Column(name="psdevslnsysappid")
    private String psdevslnsysappid;
    @Column(name="psdevslnsysappname")
    private String psdevslnsysappname;
    @Column(name="pssaassysappid")
    private String pssaassysappid;
    @Column(name="pssaassysappname")
    private String pssaassysappname;
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
    private Integer objPSDepSysVerLock = new Integer(1);
    private PSDepSysVer psdepsysver = null;
    private Integer objPSDevSlnSysAppLock = new Integer(1);
    private PSDevSlnSysApp psdevslnsysapp = null;
    private Integer objPSSaaSSysAppLock = new Integer(1);
    private PSSaaSSysApp pssaassysapp = null;

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

    public void setPSDepSysAppId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSysAppId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepsysappid = string;
        this.psdepsysappidDirtyFlag = true;
    }

    public String getPSDepSysAppId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSysAppId();
        }
        return this.psdepsysappid;
    }

    public boolean isPSDepSysAppIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSysAppIdDirty();
        }
        return this.psdepsysappidDirtyFlag;
    }

    public void resetPSDepSysAppId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSysAppId();
            return;
        }
        this.psdepsysappidDirtyFlag = false;
        this.psdepsysappid = null;
    }

    public void setPSDepSysAppName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSysAppName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepsysappname = string;
        this.psdepsysappnameDirtyFlag = true;
    }

    public String getPSDepSysAppName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSysAppName();
        }
        return this.psdepsysappname;
    }

    public boolean isPSDepSysAppNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSysAppNameDirty();
        }
        return this.psdepsysappnameDirtyFlag;
    }

    public void resetPSDepSysAppName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSysAppName();
            return;
        }
        this.psdepsysappnameDirtyFlag = false;
        this.psdepsysappname = null;
    }

    public void setPSDepSysAppType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSysAppType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepsysapptype = string;
        this.psdepsysapptypeDirtyFlag = true;
    }

    public String getPSDepSysAppType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSysAppType();
        }
        return this.psdepsysapptype;
    }

    public boolean isPSDepSysAppTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSysAppTypeDirty();
        }
        return this.psdepsysapptypeDirtyFlag;
    }

    public void resetPSDepSysAppType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSysAppType();
            return;
        }
        this.psdepsysapptypeDirtyFlag = false;
        this.psdepsysapptype = null;
    }

    public void setPSDepSysVerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSysVerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepsysverid = string;
        this.psdepsysveridDirtyFlag = true;
    }

    public String getPSDepSysVerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSysVerId();
        }
        return this.psdepsysverid;
    }

    public boolean isPSDepSysVerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSysVerIdDirty();
        }
        return this.psdepsysveridDirtyFlag;
    }

    public void resetPSDepSysVerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSysVerId();
            return;
        }
        this.psdepsysveridDirtyFlag = false;
        this.psdepsysverid = null;
    }

    public void setPSDepSysVerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSysVerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepsysvername = string;
        this.psdepsysvernameDirtyFlag = true;
    }

    public String getPSDepSysVerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSysVerName();
        }
        return this.psdepsysvername;
    }

    public boolean isPSDepSysVerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSysVerNameDirty();
        }
        return this.psdepsysvernameDirtyFlag;
    }

    public void resetPSDepSysVerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSysVerName();
            return;
        }
        this.psdepsysvernameDirtyFlag = false;
        this.psdepsysvername = null;
    }

    public void setPSDevSlnSysAppId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysAppId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysappid = string;
        this.psdevslnsysappidDirtyFlag = true;
    }

    public String getPSDevSlnSysAppId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysAppId();
        }
        return this.psdevslnsysappid;
    }

    public boolean isPSDevSlnSysAppIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysAppIdDirty();
        }
        return this.psdevslnsysappidDirtyFlag;
    }

    public void resetPSDevSlnSysAppId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysAppId();
            return;
        }
        this.psdevslnsysappidDirtyFlag = false;
        this.psdevslnsysappid = null;
    }

    public void setPSDevSlnSysAppName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysAppName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysappname = string;
        this.psdevslnsysappnameDirtyFlag = true;
    }

    public String getPSDevSlnSysAppName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysAppName();
        }
        return this.psdevslnsysappname;
    }

    public boolean isPSDevSlnSysAppNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysAppNameDirty();
        }
        return this.psdevslnsysappnameDirtyFlag;
    }

    public void resetPSDevSlnSysAppName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysAppName();
            return;
        }
        this.psdevslnsysappnameDirtyFlag = false;
        this.psdevslnsysappname = null;
    }

    public void setPSSaaSSysAppId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSaaSSysAppId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssaassysappid = string;
        this.pssaassysappidDirtyFlag = true;
    }

    public String getPSSaaSSysAppId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSaaSSysAppId();
        }
        return this.pssaassysappid;
    }

    public boolean isPSSaaSSysAppIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSaaSSysAppIdDirty();
        }
        return this.pssaassysappidDirtyFlag;
    }

    public void resetPSSaaSSysAppId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSaaSSysAppId();
            return;
        }
        this.pssaassysappidDirtyFlag = false;
        this.pssaassysappid = null;
    }

    public void setPSSaaSSysAppName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSaaSSysAppName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssaassysappname = string;
        this.pssaassysappnameDirtyFlag = true;
    }

    public String getPSSaaSSysAppName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSaaSSysAppName();
        }
        return this.pssaassysappname;
    }

    public boolean isPSSaaSSysAppNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSaaSSysAppNameDirty();
        }
        return this.pssaassysappnameDirtyFlag;
    }

    public void resetPSSaaSSysAppName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSaaSSysAppName();
            return;
        }
        this.pssaassysappnameDirtyFlag = false;
        this.pssaassysappname = null;
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
        PSDepSysAppBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDepSysAppBase pSDepSysAppBase) {
        pSDepSysAppBase.resetCreateDate();
        pSDepSysAppBase.resetCreateMan();
        pSDepSysAppBase.resetMemo();
        pSDepSysAppBase.resetPSDepSysAppId();
        pSDepSysAppBase.resetPSDepSysAppName();
        pSDepSysAppBase.resetPSDepSysAppType();
        pSDepSysAppBase.resetPSDepSysVerId();
        pSDepSysAppBase.resetPSDepSysVerName();
        pSDepSysAppBase.resetPSDevSlnSysAppId();
        pSDepSysAppBase.resetPSDevSlnSysAppName();
        pSDepSysAppBase.resetPSSaaSSysAppId();
        pSDepSysAppBase.resetPSSaaSSysAppName();
        pSDepSysAppBase.resetUpdateDate();
        pSDepSysAppBase.resetUpdateMan();
        pSDepSysAppBase.resetUserCat();
        pSDepSysAppBase.resetUserTag();
        pSDepSysAppBase.resetUserTag2();
        pSDepSysAppBase.resetUserTag3();
        pSDepSysAppBase.resetUserTag4();
        pSDepSysAppBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDepSysAppIdDirty()) {
            hashMap.put(FIELD_PSDEPSYSAPPID, this.getPSDepSysAppId());
        }
        if (!bl || this.isPSDepSysAppNameDirty()) {
            hashMap.put(FIELD_PSDEPSYSAPPNAME, this.getPSDepSysAppName());
        }
        if (!bl || this.isPSDepSysAppTypeDirty()) {
            hashMap.put(FIELD_PSDEPSYSAPPTYPE, this.getPSDepSysAppType());
        }
        if (!bl || this.isPSDepSysVerIdDirty()) {
            hashMap.put(FIELD_PSDEPSYSVERID, this.getPSDepSysVerId());
        }
        if (!bl || this.isPSDepSysVerNameDirty()) {
            hashMap.put(FIELD_PSDEPSYSVERNAME, this.getPSDepSysVerName());
        }
        if (!bl || this.isPSDevSlnSysAppIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSAPPID, this.getPSDevSlnSysAppId());
        }
        if (!bl || this.isPSDevSlnSysAppNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSAPPNAME, this.getPSDevSlnSysAppName());
        }
        if (!bl || this.isPSSaaSSysAppIdDirty()) {
            hashMap.put(FIELD_PSSAASSYSAPPID, this.getPSSaaSSysAppId());
        }
        if (!bl || this.isPSSaaSSysAppNameDirty()) {
            hashMap.put(FIELD_PSSAASSYSAPPNAME, this.getPSSaaSSysAppName());
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
        return PSDepSysAppBase.get(this, n);
    }

    private static Object get(PSDepSysAppBase pSDepSysAppBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSysAppBase.getCreateDate();
            }
            case 1: {
                return pSDepSysAppBase.getCreateMan();
            }
            case 2: {
                return pSDepSysAppBase.getMemo();
            }
            case 3: {
                return pSDepSysAppBase.getPSDepSysAppId();
            }
            case 4: {
                return pSDepSysAppBase.getPSDepSysAppName();
            }
            case 5: {
                return pSDepSysAppBase.getPSDepSysAppType();
            }
            case 6: {
                return pSDepSysAppBase.getPSDepSysVerId();
            }
            case 7: {
                return pSDepSysAppBase.getPSDepSysVerName();
            }
            case 8: {
                return pSDepSysAppBase.getPSDevSlnSysAppId();
            }
            case 9: {
                return pSDepSysAppBase.getPSDevSlnSysAppName();
            }
            case 10: {
                return pSDepSysAppBase.getPSSaaSSysAppId();
            }
            case 11: {
                return pSDepSysAppBase.getPSSaaSSysAppName();
            }
            case 12: {
                return pSDepSysAppBase.getUpdateDate();
            }
            case 13: {
                return pSDepSysAppBase.getUpdateMan();
            }
            case 14: {
                return pSDepSysAppBase.getUserCat();
            }
            case 15: {
                return pSDepSysAppBase.getUserTag();
            }
            case 16: {
                return pSDepSysAppBase.getUserTag2();
            }
            case 17: {
                return pSDepSysAppBase.getUserTag3();
            }
            case 18: {
                return pSDepSysAppBase.getUserTag4();
            }
            case 19: {
                return pSDepSysAppBase.getValidFlag();
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
        PSDepSysAppBase.set(this, n, object);
    }

    private static void set(PSDepSysAppBase pSDepSysAppBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDepSysAppBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDepSysAppBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDepSysAppBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDepSysAppBase.setPSDepSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDepSysAppBase.setPSDepSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDepSysAppBase.setPSDepSysAppType(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDepSysAppBase.setPSDepSysVerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDepSysAppBase.setPSDepSysVerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDepSysAppBase.setPSDevSlnSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDepSysAppBase.setPSDevSlnSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDepSysAppBase.setPSSaaSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDepSysAppBase.setPSSaaSSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDepSysAppBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 13: {
                pSDepSysAppBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDepSysAppBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDepSysAppBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDepSysAppBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDepSysAppBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDepSysAppBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDepSysAppBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDepSysAppBase.isNull(this, n);
    }

    private static boolean isNull(PSDepSysAppBase pSDepSysAppBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSysAppBase.getCreateDate() == null;
            }
            case 1: {
                return pSDepSysAppBase.getCreateMan() == null;
            }
            case 2: {
                return pSDepSysAppBase.getMemo() == null;
            }
            case 3: {
                return pSDepSysAppBase.getPSDepSysAppId() == null;
            }
            case 4: {
                return pSDepSysAppBase.getPSDepSysAppName() == null;
            }
            case 5: {
                return pSDepSysAppBase.getPSDepSysAppType() == null;
            }
            case 6: {
                return pSDepSysAppBase.getPSDepSysVerId() == null;
            }
            case 7: {
                return pSDepSysAppBase.getPSDepSysVerName() == null;
            }
            case 8: {
                return pSDepSysAppBase.getPSDevSlnSysAppId() == null;
            }
            case 9: {
                return pSDepSysAppBase.getPSDevSlnSysAppName() == null;
            }
            case 10: {
                return pSDepSysAppBase.getPSSaaSSysAppId() == null;
            }
            case 11: {
                return pSDepSysAppBase.getPSSaaSSysAppName() == null;
            }
            case 12: {
                return pSDepSysAppBase.getUpdateDate() == null;
            }
            case 13: {
                return pSDepSysAppBase.getUpdateMan() == null;
            }
            case 14: {
                return pSDepSysAppBase.getUserCat() == null;
            }
            case 15: {
                return pSDepSysAppBase.getUserTag() == null;
            }
            case 16: {
                return pSDepSysAppBase.getUserTag2() == null;
            }
            case 17: {
                return pSDepSysAppBase.getUserTag3() == null;
            }
            case 18: {
                return pSDepSysAppBase.getUserTag4() == null;
            }
            case 19: {
                return pSDepSysAppBase.getValidFlag() == null;
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
        return PSDepSysAppBase.contains(this, n);
    }

    private static boolean contains(PSDepSysAppBase pSDepSysAppBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSysAppBase.isCreateDateDirty();
            }
            case 1: {
                return pSDepSysAppBase.isCreateManDirty();
            }
            case 2: {
                return pSDepSysAppBase.isMemoDirty();
            }
            case 3: {
                return pSDepSysAppBase.isPSDepSysAppIdDirty();
            }
            case 4: {
                return pSDepSysAppBase.isPSDepSysAppNameDirty();
            }
            case 5: {
                return pSDepSysAppBase.isPSDepSysAppTypeDirty();
            }
            case 6: {
                return pSDepSysAppBase.isPSDepSysVerIdDirty();
            }
            case 7: {
                return pSDepSysAppBase.isPSDepSysVerNameDirty();
            }
            case 8: {
                return pSDepSysAppBase.isPSDevSlnSysAppIdDirty();
            }
            case 9: {
                return pSDepSysAppBase.isPSDevSlnSysAppNameDirty();
            }
            case 10: {
                return pSDepSysAppBase.isPSSaaSSysAppIdDirty();
            }
            case 11: {
                return pSDepSysAppBase.isPSSaaSSysAppNameDirty();
            }
            case 12: {
                return pSDepSysAppBase.isUpdateDateDirty();
            }
            case 13: {
                return pSDepSysAppBase.isUpdateManDirty();
            }
            case 14: {
                return pSDepSysAppBase.isUserCatDirty();
            }
            case 15: {
                return pSDepSysAppBase.isUserTagDirty();
            }
            case 16: {
                return pSDepSysAppBase.isUserTag2Dirty();
            }
            case 17: {
                return pSDepSysAppBase.isUserTag3Dirty();
            }
            case 18: {
                return pSDepSysAppBase.isUserTag4Dirty();
            }
            case 19: {
                return pSDepSysAppBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDepSysAppBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDepSysAppBase pSDepSysAppBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDepSysAppBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDepSysAppBase.getJSONValue((Object)pSDepSysAppBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDepSysAppBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDepSysAppBase.getJSONValue((Object)pSDepSysAppBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDepSysAppBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDepSysAppBase.getJSONValue((Object)pSDepSysAppBase.getMemo()), (boolean)false);
        }
        if (bl || pSDepSysAppBase.getPSDepSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepsysappid", (Object)PSDepSysAppBase.getJSONValue((Object)pSDepSysAppBase.getPSDepSysAppId()), (boolean)false);
        }
        if (bl || pSDepSysAppBase.getPSDepSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepsysappname", (Object)PSDepSysAppBase.getJSONValue((Object)pSDepSysAppBase.getPSDepSysAppName()), (boolean)false);
        }
        if (bl || pSDepSysAppBase.getPSDepSysAppType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepsysapptype", (Object)PSDepSysAppBase.getJSONValue((Object)pSDepSysAppBase.getPSDepSysAppType()), (boolean)false);
        }
        if (bl || pSDepSysAppBase.getPSDepSysVerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepsysverid", (Object)PSDepSysAppBase.getJSONValue((Object)pSDepSysAppBase.getPSDepSysVerId()), (boolean)false);
        }
        if (bl || pSDepSysAppBase.getPSDepSysVerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepsysvername", (Object)PSDepSysAppBase.getJSONValue((Object)pSDepSysAppBase.getPSDepSysVerName()), (boolean)false);
        }
        if (bl || pSDepSysAppBase.getPSDevSlnSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysappid", (Object)PSDepSysAppBase.getJSONValue((Object)pSDepSysAppBase.getPSDevSlnSysAppId()), (boolean)false);
        }
        if (bl || pSDepSysAppBase.getPSDevSlnSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysappname", (Object)PSDepSysAppBase.getJSONValue((Object)pSDepSysAppBase.getPSDevSlnSysAppName()), (boolean)false);
        }
        if (bl || pSDepSysAppBase.getPSSaaSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssaassysappid", (Object)PSDepSysAppBase.getJSONValue((Object)pSDepSysAppBase.getPSSaaSSysAppId()), (boolean)false);
        }
        if (bl || pSDepSysAppBase.getPSSaaSSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssaassysappname", (Object)PSDepSysAppBase.getJSONValue((Object)pSDepSysAppBase.getPSSaaSSysAppName()), (boolean)false);
        }
        if (bl || pSDepSysAppBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDepSysAppBase.getJSONValue((Object)pSDepSysAppBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDepSysAppBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDepSysAppBase.getJSONValue((Object)pSDepSysAppBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDepSysAppBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDepSysAppBase.getJSONValue((Object)pSDepSysAppBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDepSysAppBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDepSysAppBase.getJSONValue((Object)pSDepSysAppBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDepSysAppBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDepSysAppBase.getJSONValue((Object)pSDepSysAppBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDepSysAppBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDepSysAppBase.getJSONValue((Object)pSDepSysAppBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDepSysAppBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDepSysAppBase.getJSONValue((Object)pSDepSysAppBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDepSysAppBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDepSysAppBase.getJSONValue((Object)pSDepSysAppBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDepSysAppBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDepSysAppBase pSDepSysAppBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDepSysAppBase.getCreateDate() != null) {
            object = pSDepSysAppBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSysAppBase.getCreateMan() != null) {
            object = pSDepSysAppBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysAppBase.getMemo() != null) {
            object = pSDepSysAppBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysAppBase.getPSDepSysAppId() != null) {
            object = pSDepSysAppBase.getPSDepSysAppId();
            xmlNode.setAttribute(FIELD_PSDEPSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysAppBase.getPSDepSysAppName() != null) {
            object = pSDepSysAppBase.getPSDepSysAppName();
            xmlNode.setAttribute(FIELD_PSDEPSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysAppBase.getPSDepSysAppType() != null) {
            object = pSDepSysAppBase.getPSDepSysAppType();
            xmlNode.setAttribute(FIELD_PSDEPSYSAPPTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysAppBase.getPSDepSysVerId() != null) {
            object = pSDepSysAppBase.getPSDepSysVerId();
            xmlNode.setAttribute(FIELD_PSDEPSYSVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysAppBase.getPSDepSysVerName() != null) {
            object = pSDepSysAppBase.getPSDepSysVerName();
            xmlNode.setAttribute(FIELD_PSDEPSYSVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysAppBase.getPSDevSlnSysAppId() != null) {
            object = pSDepSysAppBase.getPSDevSlnSysAppId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysAppBase.getPSDevSlnSysAppName() != null) {
            object = pSDepSysAppBase.getPSDevSlnSysAppName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysAppBase.getPSSaaSSysAppId() != null) {
            object = pSDepSysAppBase.getPSSaaSSysAppId();
            xmlNode.setAttribute(FIELD_PSSAASSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysAppBase.getPSSaaSSysAppName() != null) {
            object = pSDepSysAppBase.getPSSaaSSysAppName();
            xmlNode.setAttribute(FIELD_PSSAASSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysAppBase.getUpdateDate() != null) {
            object = pSDepSysAppBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSysAppBase.getUpdateMan() != null) {
            object = pSDepSysAppBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysAppBase.getUserCat() != null) {
            object = pSDepSysAppBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysAppBase.getUserTag() != null) {
            object = pSDepSysAppBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysAppBase.getUserTag2() != null) {
            object = pSDepSysAppBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysAppBase.getUserTag3() != null) {
            object = pSDepSysAppBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysAppBase.getUserTag4() != null) {
            object = pSDepSysAppBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysAppBase.getValidFlag() != null) {
            object = pSDepSysAppBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDepSysAppBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDepSysAppBase pSDepSysAppBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDepSysAppBase.isCreateDateDirty() && (bl || pSDepSysAppBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDepSysAppBase.getCreateDate());
        }
        if (pSDepSysAppBase.isCreateManDirty() && (bl || pSDepSysAppBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDepSysAppBase.getCreateMan());
        }
        if (pSDepSysAppBase.isMemoDirty() && (bl || pSDepSysAppBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDepSysAppBase.getMemo());
        }
        if (pSDepSysAppBase.isPSDepSysAppIdDirty() && (bl || pSDepSysAppBase.getPSDepSysAppId() != null)) {
            iDataObject.set(FIELD_PSDEPSYSAPPID, (Object)pSDepSysAppBase.getPSDepSysAppId());
        }
        if (pSDepSysAppBase.isPSDepSysAppNameDirty() && (bl || pSDepSysAppBase.getPSDepSysAppName() != null)) {
            iDataObject.set(FIELD_PSDEPSYSAPPNAME, (Object)pSDepSysAppBase.getPSDepSysAppName());
        }
        if (pSDepSysAppBase.isPSDepSysAppTypeDirty() && (bl || pSDepSysAppBase.getPSDepSysAppType() != null)) {
            iDataObject.set(FIELD_PSDEPSYSAPPTYPE, (Object)pSDepSysAppBase.getPSDepSysAppType());
        }
        if (pSDepSysAppBase.isPSDepSysVerIdDirty() && (bl || pSDepSysAppBase.getPSDepSysVerId() != null)) {
            iDataObject.set(FIELD_PSDEPSYSVERID, (Object)pSDepSysAppBase.getPSDepSysVerId());
        }
        if (pSDepSysAppBase.isPSDepSysVerNameDirty() && (bl || pSDepSysAppBase.getPSDepSysVerName() != null)) {
            iDataObject.set(FIELD_PSDEPSYSVERNAME, (Object)pSDepSysAppBase.getPSDepSysVerName());
        }
        if (pSDepSysAppBase.isPSDevSlnSysAppIdDirty() && (bl || pSDepSysAppBase.getPSDevSlnSysAppId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSAPPID, (Object)pSDepSysAppBase.getPSDevSlnSysAppId());
        }
        if (pSDepSysAppBase.isPSDevSlnSysAppNameDirty() && (bl || pSDepSysAppBase.getPSDevSlnSysAppName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSAPPNAME, (Object)pSDepSysAppBase.getPSDevSlnSysAppName());
        }
        if (pSDepSysAppBase.isPSSaaSSysAppIdDirty() && (bl || pSDepSysAppBase.getPSSaaSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSAASSYSAPPID, (Object)pSDepSysAppBase.getPSSaaSSysAppId());
        }
        if (pSDepSysAppBase.isPSSaaSSysAppNameDirty() && (bl || pSDepSysAppBase.getPSSaaSSysAppName() != null)) {
            iDataObject.set(FIELD_PSSAASSYSAPPNAME, (Object)pSDepSysAppBase.getPSSaaSSysAppName());
        }
        if (pSDepSysAppBase.isUpdateDateDirty() && (bl || pSDepSysAppBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDepSysAppBase.getUpdateDate());
        }
        if (pSDepSysAppBase.isUpdateManDirty() && (bl || pSDepSysAppBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDepSysAppBase.getUpdateMan());
        }
        if (pSDepSysAppBase.isUserCatDirty() && (bl || pSDepSysAppBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDepSysAppBase.getUserCat());
        }
        if (pSDepSysAppBase.isUserTagDirty() && (bl || pSDepSysAppBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDepSysAppBase.getUserTag());
        }
        if (pSDepSysAppBase.isUserTag2Dirty() && (bl || pSDepSysAppBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDepSysAppBase.getUserTag2());
        }
        if (pSDepSysAppBase.isUserTag3Dirty() && (bl || pSDepSysAppBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDepSysAppBase.getUserTag3());
        }
        if (pSDepSysAppBase.isUserTag4Dirty() && (bl || pSDepSysAppBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDepSysAppBase.getUserTag4());
        }
        if (pSDepSysAppBase.isValidFlagDirty() && (bl || pSDepSysAppBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDepSysAppBase.getValidFlag());
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
        return PSDepSysAppBase.remove(this, n);
    }

    private static boolean remove(PSDepSysAppBase pSDepSysAppBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDepSysAppBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDepSysAppBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDepSysAppBase.resetMemo();
                return true;
            }
            case 3: {
                pSDepSysAppBase.resetPSDepSysAppId();
                return true;
            }
            case 4: {
                pSDepSysAppBase.resetPSDepSysAppName();
                return true;
            }
            case 5: {
                pSDepSysAppBase.resetPSDepSysAppType();
                return true;
            }
            case 6: {
                pSDepSysAppBase.resetPSDepSysVerId();
                return true;
            }
            case 7: {
                pSDepSysAppBase.resetPSDepSysVerName();
                return true;
            }
            case 8: {
                pSDepSysAppBase.resetPSDevSlnSysAppId();
                return true;
            }
            case 9: {
                pSDepSysAppBase.resetPSDevSlnSysAppName();
                return true;
            }
            case 10: {
                pSDepSysAppBase.resetPSSaaSSysAppId();
                return true;
            }
            case 11: {
                pSDepSysAppBase.resetPSSaaSSysAppName();
                return true;
            }
            case 12: {
                pSDepSysAppBase.resetUpdateDate();
                return true;
            }
            case 13: {
                pSDepSysAppBase.resetUpdateMan();
                return true;
            }
            case 14: {
                pSDepSysAppBase.resetUserCat();
                return true;
            }
            case 15: {
                pSDepSysAppBase.resetUserTag();
                return true;
            }
            case 16: {
                pSDepSysAppBase.resetUserTag2();
                return true;
            }
            case 17: {
                pSDepSysAppBase.resetUserTag3();
                return true;
            }
            case 18: {
                pSDepSysAppBase.resetUserTag4();
                return true;
            }
            case 19: {
                pSDepSysAppBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDepSysVer getPSDepSysVer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSysVer();
        }
        if (this.getPSDepSysVerId() == null) {
            return null;
        }
        Integer n = this.objPSDepSysVerLock;
        synchronized (n) {
            if (this.psdepsysver != null && DataTypeHelper.compare((int)25, (Object)this.getPSDepSysVerId(), (Object)this.psdepsysver.getPSDepSysVerId()) != 0L) {
                this.psdepsysver = null;
            }
            if (this.psdepsysver == null) {
                PSDepSysVer pSDepSysVer = new PSDepSysVer();
                pSDepSysVer.setPSDepSysVerId(this.getPSDepSysVerId());
                PSDepSysVerService pSDepSysVerService = (PSDepSysVerService)ServiceGlobal.getService(PSDepSysVerService.class, (SessionFactory)this.getSessionFactory());
                pSDepSysVerService.autoGet((IEntity)pSDepSysVer);
                this.psdepsysver = pSDepSysVer;
            }
            return this.psdepsysver;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnSysApp getPSDevSlnSysApp() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysApp();
        }
        if (this.getPSDevSlnSysAppId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnSysAppLock;
        synchronized (n) {
            if (this.psdevslnsysapp != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnSysAppId(), (Object)this.psdevslnsysapp.getPSDevSlnSysAppId()) != 0L) {
                this.psdevslnsysapp = null;
            }
            if (this.psdevslnsysapp == null) {
                PSDevSlnSysApp pSDevSlnSysApp = new PSDevSlnSysApp();
                pSDevSlnSysApp.setPSDevSlnSysAppId(this.getPSDevSlnSysAppId());
                PSDevSlnSysAppService pSDevSlnSysAppService = (PSDevSlnSysAppService)ServiceGlobal.getService(PSDevSlnSysAppService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnSysAppService.autoGet((IEntity)pSDevSlnSysApp);
                this.psdevslnsysapp = pSDevSlnSysApp;
            }
            return this.psdevslnsysapp;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSaaSSysApp getPSSaaSSysApp() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSaaSSysApp();
        }
        if (this.getPSSaaSSysAppId() == null) {
            return null;
        }
        Integer n = this.objPSSaaSSysAppLock;
        synchronized (n) {
            if (this.pssaassysapp != null && DataTypeHelper.compare((int)25, (Object)this.getPSSaaSSysAppId(), (Object)this.pssaassysapp.getPSSaaSSysAppId()) != 0L) {
                this.pssaassysapp = null;
            }
            if (this.pssaassysapp == null) {
                PSSaaSSysApp pSSaaSSysApp = new PSSaaSSysApp();
                pSSaaSSysApp.setPSSaaSSysAppId(this.getPSSaaSSysAppId());
                PSSaaSSysAppService pSSaaSSysAppService = (PSSaaSSysAppService)ServiceGlobal.getService(PSSaaSSysAppService.class, (SessionFactory)this.getSessionFactory());
                pSSaaSSysAppService.autoGet((IEntity)pSSaaSSysApp);
                this.pssaassysapp = pSSaaSSysApp;
            }
            return this.pssaassysapp;
        }
    }

    private PSDepSysAppBase getProxyEntity() {
        return this.proxyPSDepSysAppBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDepSysAppBase = null;
        if (iDataObject != null && iDataObject instanceof PSDepSysAppBase) {
            this.proxyPSDepSysAppBase = (PSDepSysAppBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSysAppService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSDEPSYSAPPID, 3);
        fieldIndexMap.put(FIELD_PSDEPSYSAPPNAME, 4);
        fieldIndexMap.put(FIELD_PSDEPSYSAPPTYPE, 5);
        fieldIndexMap.put(FIELD_PSDEPSYSVERID, 6);
        fieldIndexMap.put(FIELD_PSDEPSYSVERNAME, 7);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSAPPID, 8);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSAPPNAME, 9);
        fieldIndexMap.put(FIELD_PSSAASSYSAPPID, 10);
        fieldIndexMap.put(FIELD_PSSAASSYSAPPNAME, 11);
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

