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
import net.ibizsys.pscore.srv.appdesign.entity.PSAppView;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysPDTView;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysPDTViewService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppPDTViewBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSAppPDTViewBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSAPPPDTVIEWID = "PSAPPPDTVIEWID";
    public static final String FIELD_PSAPPPDTVIEWNAME = "PSAPPPDTVIEWNAME";
    public static final String FIELD_PSAPPVIEWID = "PSAPPVIEWID";
    public static final String FIELD_PSAPPVIEWNAME = "PSAPPVIEWNAME";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String FIELD_PSSYSPDTVIEWID = "PSSYSPDTVIEWID";
    public static final String FIELD_PSSYSPDTVIEWNAME = "PSSYSPDTVIEWNAME";
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
    private static final int INDEX_PSAPPPDTVIEWID = 3;
    private static final int INDEX_PSAPPPDTVIEWNAME = 4;
    private static final int INDEX_PSAPPVIEWID = 5;
    private static final int INDEX_PSAPPVIEWNAME = 6;
    private static final int INDEX_PSSYSAPPID = 7;
    private static final int INDEX_PSSYSAPPNAME = 8;
    private static final int INDEX_PSSYSPDTVIEWID = 9;
    private static final int INDEX_PSSYSPDTVIEWNAME = 10;
    private static final int INDEX_UPDATEDATE = 11;
    private static final int INDEX_UPDATEMAN = 12;
    private static final int INDEX_USERCAT = 13;
    private static final int INDEX_USERTAG = 14;
    private static final int INDEX_USERTAG2 = 15;
    private static final int INDEX_USERTAG3 = 16;
    private static final int INDEX_USERTAG4 = 17;
    private static final int INDEX_VALIDFLAG = 18;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSAppPDTViewBase proxyPSAppPDTViewBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psapppdtviewidDirtyFlag = false;
    private boolean psapppdtviewnameDirtyFlag = false;
    private boolean psappviewidDirtyFlag = false;
    private boolean psappviewnameDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean pssysappnameDirtyFlag = false;
    private boolean pssyspdtviewidDirtyFlag = false;
    private boolean pssyspdtviewnameDirtyFlag = false;
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
    @Column(name="psapppdtviewid")
    private String psapppdtviewid;
    @Column(name="psapppdtviewname")
    private String psapppdtviewname;
    @Column(name="psappviewid")
    private String psappviewid;
    @Column(name="psappviewname")
    private String psappviewname;
    @Column(name="pssysappid")
    private String pssysappid;
    @Column(name="pssysappname")
    private String pssysappname;
    @Column(name="pssyspdtviewid")
    private String pssyspdtviewid;
    @Column(name="pssyspdtviewname")
    private String pssyspdtviewname;
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
    private Integer objPSAppViewLock = new Integer(1);
    private PSAppView psappview = null;
    private Integer objPSSysAppLock = new Integer(1);
    private PSSysApp pssysapp = null;
    private Integer objPSSysPDTViewLock = new Integer(1);
    private PSSysPDTView pssyspdtview = null;

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

    public void setPSAppPDTViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppPDTViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psapppdtviewid = string;
        this.psapppdtviewidDirtyFlag = true;
    }

    public String getPSAppPDTViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppPDTViewId();
        }
        return this.psapppdtviewid;
    }

    public boolean isPSAppPDTViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppPDTViewIdDirty();
        }
        return this.psapppdtviewidDirtyFlag;
    }

    public void resetPSAppPDTViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppPDTViewId();
            return;
        }
        this.psapppdtviewidDirtyFlag = false;
        this.psapppdtviewid = null;
    }

    public void setPSAppPDTViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppPDTViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psapppdtviewname = string;
        this.psapppdtviewnameDirtyFlag = true;
    }

    public String getPSAppPDTViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppPDTViewName();
        }
        return this.psapppdtviewname;
    }

    public boolean isPSAppPDTViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppPDTViewNameDirty();
        }
        return this.psapppdtviewnameDirtyFlag;
    }

    public void resetPSAppPDTViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppPDTViewName();
            return;
        }
        this.psapppdtviewnameDirtyFlag = false;
        this.psapppdtviewname = null;
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

    public void setPSAppViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappviewname = string;
        this.psappviewnameDirtyFlag = true;
    }

    public String getPSAppViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppViewName();
        }
        return this.psappviewname;
    }

    public boolean isPSAppViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppViewNameDirty();
        }
        return this.psappviewnameDirtyFlag;
    }

    public void resetPSAppViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppViewName();
            return;
        }
        this.psappviewnameDirtyFlag = false;
        this.psappviewname = null;
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

    public void setPSSysPDTViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysPDTViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyspdtviewid = string;
        this.pssyspdtviewidDirtyFlag = true;
    }

    public String getPSSysPDTViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPDTViewId();
        }
        return this.pssyspdtviewid;
    }

    public boolean isPSSysPDTViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysPDTViewIdDirty();
        }
        return this.pssyspdtviewidDirtyFlag;
    }

    public void resetPSSysPDTViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysPDTViewId();
            return;
        }
        this.pssyspdtviewidDirtyFlag = false;
        this.pssyspdtviewid = null;
    }

    public void setPSSysPDTViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysPDTViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyspdtviewname = string;
        this.pssyspdtviewnameDirtyFlag = true;
    }

    public String getPSSysPDTViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPDTViewName();
        }
        return this.pssyspdtviewname;
    }

    public boolean isPSSysPDTViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysPDTViewNameDirty();
        }
        return this.pssyspdtviewnameDirtyFlag;
    }

    public void resetPSSysPDTViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysPDTViewName();
            return;
        }
        this.pssyspdtviewnameDirtyFlag = false;
        this.pssyspdtviewname = null;
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
        PSAppPDTViewBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSAppPDTViewBase pSAppPDTViewBase) {
        pSAppPDTViewBase.resetCreateDate();
        pSAppPDTViewBase.resetCreateMan();
        pSAppPDTViewBase.resetMemo();
        pSAppPDTViewBase.resetPSAppPDTViewId();
        pSAppPDTViewBase.resetPSAppPDTViewName();
        pSAppPDTViewBase.resetPSAppViewId();
        pSAppPDTViewBase.resetPSAppViewName();
        pSAppPDTViewBase.resetPSSysAppId();
        pSAppPDTViewBase.resetPSSysAppName();
        pSAppPDTViewBase.resetPSSysPDTViewId();
        pSAppPDTViewBase.resetPSSysPDTViewName();
        pSAppPDTViewBase.resetUpdateDate();
        pSAppPDTViewBase.resetUpdateMan();
        pSAppPDTViewBase.resetUserCat();
        pSAppPDTViewBase.resetUserTag();
        pSAppPDTViewBase.resetUserTag2();
        pSAppPDTViewBase.resetUserTag3();
        pSAppPDTViewBase.resetUserTag4();
        pSAppPDTViewBase.resetValidFlag();
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
        if (!bl || this.isPSAppPDTViewIdDirty()) {
            hashMap.put(FIELD_PSAPPPDTVIEWID, this.getPSAppPDTViewId());
        }
        if (!bl || this.isPSAppPDTViewNameDirty()) {
            hashMap.put(FIELD_PSAPPPDTVIEWNAME, this.getPSAppPDTViewName());
        }
        if (!bl || this.isPSAppViewIdDirty()) {
            hashMap.put(FIELD_PSAPPVIEWID, this.getPSAppViewId());
        }
        if (!bl || this.isPSAppViewNameDirty()) {
            hashMap.put(FIELD_PSAPPVIEWNAME, this.getPSAppViewName());
        }
        if (!bl || this.isPSSysAppIdDirty()) {
            hashMap.put(FIELD_PSSYSAPPID, this.getPSSysAppId());
        }
        if (!bl || this.isPSSysAppNameDirty()) {
            hashMap.put(FIELD_PSSYSAPPNAME, this.getPSSysAppName());
        }
        if (!bl || this.isPSSysPDTViewIdDirty()) {
            hashMap.put(FIELD_PSSYSPDTVIEWID, this.getPSSysPDTViewId());
        }
        if (!bl || this.isPSSysPDTViewNameDirty()) {
            hashMap.put(FIELD_PSSYSPDTVIEWNAME, this.getPSSysPDTViewName());
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
        return PSAppPDTViewBase.get(this, n);
    }

    private static Object get(PSAppPDTViewBase pSAppPDTViewBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppPDTViewBase.getCreateDate();
            }
            case 1: {
                return pSAppPDTViewBase.getCreateMan();
            }
            case 2: {
                return pSAppPDTViewBase.getMemo();
            }
            case 3: {
                return pSAppPDTViewBase.getPSAppPDTViewId();
            }
            case 4: {
                return pSAppPDTViewBase.getPSAppPDTViewName();
            }
            case 5: {
                return pSAppPDTViewBase.getPSAppViewId();
            }
            case 6: {
                return pSAppPDTViewBase.getPSAppViewName();
            }
            case 7: {
                return pSAppPDTViewBase.getPSSysAppId();
            }
            case 8: {
                return pSAppPDTViewBase.getPSSysAppName();
            }
            case 9: {
                return pSAppPDTViewBase.getPSSysPDTViewId();
            }
            case 10: {
                return pSAppPDTViewBase.getPSSysPDTViewName();
            }
            case 11: {
                return pSAppPDTViewBase.getUpdateDate();
            }
            case 12: {
                return pSAppPDTViewBase.getUpdateMan();
            }
            case 13: {
                return pSAppPDTViewBase.getUserCat();
            }
            case 14: {
                return pSAppPDTViewBase.getUserTag();
            }
            case 15: {
                return pSAppPDTViewBase.getUserTag2();
            }
            case 16: {
                return pSAppPDTViewBase.getUserTag3();
            }
            case 17: {
                return pSAppPDTViewBase.getUserTag4();
            }
            case 18: {
                return pSAppPDTViewBase.getValidFlag();
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
        PSAppPDTViewBase.set(this, n, object);
    }

    private static void set(PSAppPDTViewBase pSAppPDTViewBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSAppPDTViewBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSAppPDTViewBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSAppPDTViewBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSAppPDTViewBase.setPSAppPDTViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSAppPDTViewBase.setPSAppPDTViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSAppPDTViewBase.setPSAppViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSAppPDTViewBase.setPSAppViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSAppPDTViewBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSAppPDTViewBase.setPSSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSAppPDTViewBase.setPSSysPDTViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSAppPDTViewBase.setPSSysPDTViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSAppPDTViewBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSAppPDTViewBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSAppPDTViewBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSAppPDTViewBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSAppPDTViewBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSAppPDTViewBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSAppPDTViewBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSAppPDTViewBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSAppPDTViewBase.isNull(this, n);
    }

    private static boolean isNull(PSAppPDTViewBase pSAppPDTViewBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppPDTViewBase.getCreateDate() == null;
            }
            case 1: {
                return pSAppPDTViewBase.getCreateMan() == null;
            }
            case 2: {
                return pSAppPDTViewBase.getMemo() == null;
            }
            case 3: {
                return pSAppPDTViewBase.getPSAppPDTViewId() == null;
            }
            case 4: {
                return pSAppPDTViewBase.getPSAppPDTViewName() == null;
            }
            case 5: {
                return pSAppPDTViewBase.getPSAppViewId() == null;
            }
            case 6: {
                return pSAppPDTViewBase.getPSAppViewName() == null;
            }
            case 7: {
                return pSAppPDTViewBase.getPSSysAppId() == null;
            }
            case 8: {
                return pSAppPDTViewBase.getPSSysAppName() == null;
            }
            case 9: {
                return pSAppPDTViewBase.getPSSysPDTViewId() == null;
            }
            case 10: {
                return pSAppPDTViewBase.getPSSysPDTViewName() == null;
            }
            case 11: {
                return pSAppPDTViewBase.getUpdateDate() == null;
            }
            case 12: {
                return pSAppPDTViewBase.getUpdateMan() == null;
            }
            case 13: {
                return pSAppPDTViewBase.getUserCat() == null;
            }
            case 14: {
                return pSAppPDTViewBase.getUserTag() == null;
            }
            case 15: {
                return pSAppPDTViewBase.getUserTag2() == null;
            }
            case 16: {
                return pSAppPDTViewBase.getUserTag3() == null;
            }
            case 17: {
                return pSAppPDTViewBase.getUserTag4() == null;
            }
            case 18: {
                return pSAppPDTViewBase.getValidFlag() == null;
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
        return PSAppPDTViewBase.contains(this, n);
    }

    private static boolean contains(PSAppPDTViewBase pSAppPDTViewBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppPDTViewBase.isCreateDateDirty();
            }
            case 1: {
                return pSAppPDTViewBase.isCreateManDirty();
            }
            case 2: {
                return pSAppPDTViewBase.isMemoDirty();
            }
            case 3: {
                return pSAppPDTViewBase.isPSAppPDTViewIdDirty();
            }
            case 4: {
                return pSAppPDTViewBase.isPSAppPDTViewNameDirty();
            }
            case 5: {
                return pSAppPDTViewBase.isPSAppViewIdDirty();
            }
            case 6: {
                return pSAppPDTViewBase.isPSAppViewNameDirty();
            }
            case 7: {
                return pSAppPDTViewBase.isPSSysAppIdDirty();
            }
            case 8: {
                return pSAppPDTViewBase.isPSSysAppNameDirty();
            }
            case 9: {
                return pSAppPDTViewBase.isPSSysPDTViewIdDirty();
            }
            case 10: {
                return pSAppPDTViewBase.isPSSysPDTViewNameDirty();
            }
            case 11: {
                return pSAppPDTViewBase.isUpdateDateDirty();
            }
            case 12: {
                return pSAppPDTViewBase.isUpdateManDirty();
            }
            case 13: {
                return pSAppPDTViewBase.isUserCatDirty();
            }
            case 14: {
                return pSAppPDTViewBase.isUserTagDirty();
            }
            case 15: {
                return pSAppPDTViewBase.isUserTag2Dirty();
            }
            case 16: {
                return pSAppPDTViewBase.isUserTag3Dirty();
            }
            case 17: {
                return pSAppPDTViewBase.isUserTag4Dirty();
            }
            case 18: {
                return pSAppPDTViewBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSAppPDTViewBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSAppPDTViewBase pSAppPDTViewBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSAppPDTViewBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSAppPDTViewBase.getJSONValue((Object)pSAppPDTViewBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSAppPDTViewBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSAppPDTViewBase.getJSONValue((Object)pSAppPDTViewBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSAppPDTViewBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSAppPDTViewBase.getJSONValue((Object)pSAppPDTViewBase.getMemo()), (boolean)false);
        }
        if (bl || pSAppPDTViewBase.getPSAppPDTViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psapppdtviewid", (Object)PSAppPDTViewBase.getJSONValue((Object)pSAppPDTViewBase.getPSAppPDTViewId()), (boolean)false);
        }
        if (bl || pSAppPDTViewBase.getPSAppPDTViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psapppdtviewname", (Object)PSAppPDTViewBase.getJSONValue((Object)pSAppPDTViewBase.getPSAppPDTViewName()), (boolean)false);
        }
        if (bl || pSAppPDTViewBase.getPSAppViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappviewid", (Object)PSAppPDTViewBase.getJSONValue((Object)pSAppPDTViewBase.getPSAppViewId()), (boolean)false);
        }
        if (bl || pSAppPDTViewBase.getPSAppViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappviewname", (Object)PSAppPDTViewBase.getJSONValue((Object)pSAppPDTViewBase.getPSAppViewName()), (boolean)false);
        }
        if (bl || pSAppPDTViewBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSAppPDTViewBase.getJSONValue((Object)pSAppPDTViewBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSAppPDTViewBase.getPSSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappname", (Object)PSAppPDTViewBase.getJSONValue((Object)pSAppPDTViewBase.getPSSysAppName()), (boolean)false);
        }
        if (bl || pSAppPDTViewBase.getPSSysPDTViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspdtviewid", (Object)PSAppPDTViewBase.getJSONValue((Object)pSAppPDTViewBase.getPSSysPDTViewId()), (boolean)false);
        }
        if (bl || pSAppPDTViewBase.getPSSysPDTViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspdtviewname", (Object)PSAppPDTViewBase.getJSONValue((Object)pSAppPDTViewBase.getPSSysPDTViewName()), (boolean)false);
        }
        if (bl || pSAppPDTViewBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSAppPDTViewBase.getJSONValue((Object)pSAppPDTViewBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSAppPDTViewBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSAppPDTViewBase.getJSONValue((Object)pSAppPDTViewBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSAppPDTViewBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSAppPDTViewBase.getJSONValue((Object)pSAppPDTViewBase.getUserCat()), (boolean)false);
        }
        if (bl || pSAppPDTViewBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSAppPDTViewBase.getJSONValue((Object)pSAppPDTViewBase.getUserTag()), (boolean)false);
        }
        if (bl || pSAppPDTViewBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSAppPDTViewBase.getJSONValue((Object)pSAppPDTViewBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSAppPDTViewBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSAppPDTViewBase.getJSONValue((Object)pSAppPDTViewBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSAppPDTViewBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSAppPDTViewBase.getJSONValue((Object)pSAppPDTViewBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSAppPDTViewBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSAppPDTViewBase.getJSONValue((Object)pSAppPDTViewBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSAppPDTViewBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSAppPDTViewBase pSAppPDTViewBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSAppPDTViewBase.getCreateDate() != null) {
            object = pSAppPDTViewBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppPDTViewBase.getCreateMan() != null) {
            object = pSAppPDTViewBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppPDTViewBase.getMemo() != null) {
            object = pSAppPDTViewBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSAppPDTViewBase.getPSAppPDTViewId() != null) {
            object = pSAppPDTViewBase.getPSAppPDTViewId();
            xmlNode.setAttribute(FIELD_PSAPPPDTVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSAppPDTViewBase.getPSAppPDTViewName() != null) {
            object = pSAppPDTViewBase.getPSAppPDTViewName();
            xmlNode.setAttribute(FIELD_PSAPPPDTVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppPDTViewBase.getPSAppViewId() != null) {
            object = pSAppPDTViewBase.getPSAppViewId();
            xmlNode.setAttribute(FIELD_PSAPPVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSAppPDTViewBase.getPSAppViewName() != null) {
            object = pSAppPDTViewBase.getPSAppViewName();
            xmlNode.setAttribute(FIELD_PSAPPVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppPDTViewBase.getPSSysAppId() != null) {
            object = pSAppPDTViewBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSAppPDTViewBase.getPSSysAppName() != null) {
            object = pSAppPDTViewBase.getPSSysAppName();
            xmlNode.setAttribute(FIELD_PSSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppPDTViewBase.getPSSysPDTViewId() != null) {
            object = pSAppPDTViewBase.getPSSysPDTViewId();
            xmlNode.setAttribute(FIELD_PSSYSPDTVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSAppPDTViewBase.getPSSysPDTViewName() != null) {
            object = pSAppPDTViewBase.getPSSysPDTViewName();
            xmlNode.setAttribute(FIELD_PSSYSPDTVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppPDTViewBase.getUpdateDate() != null) {
            object = pSAppPDTViewBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppPDTViewBase.getUpdateMan() != null) {
            object = pSAppPDTViewBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppPDTViewBase.getUserCat() != null) {
            object = pSAppPDTViewBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSAppPDTViewBase.getUserTag() != null) {
            object = pSAppPDTViewBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSAppPDTViewBase.getUserTag2() != null) {
            object = pSAppPDTViewBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSAppPDTViewBase.getUserTag3() != null) {
            object = pSAppPDTViewBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSAppPDTViewBase.getUserTag4() != null) {
            object = pSAppPDTViewBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSAppPDTViewBase.getValidFlag() != null) {
            object = pSAppPDTViewBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSAppPDTViewBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSAppPDTViewBase pSAppPDTViewBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSAppPDTViewBase.isCreateDateDirty() && (bl || pSAppPDTViewBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSAppPDTViewBase.getCreateDate());
        }
        if (pSAppPDTViewBase.isCreateManDirty() && (bl || pSAppPDTViewBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSAppPDTViewBase.getCreateMan());
        }
        if (pSAppPDTViewBase.isMemoDirty() && (bl || pSAppPDTViewBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSAppPDTViewBase.getMemo());
        }
        if (pSAppPDTViewBase.isPSAppPDTViewIdDirty() && (bl || pSAppPDTViewBase.getPSAppPDTViewId() != null)) {
            iDataObject.set(FIELD_PSAPPPDTVIEWID, (Object)pSAppPDTViewBase.getPSAppPDTViewId());
        }
        if (pSAppPDTViewBase.isPSAppPDTViewNameDirty() && (bl || pSAppPDTViewBase.getPSAppPDTViewName() != null)) {
            iDataObject.set(FIELD_PSAPPPDTVIEWNAME, (Object)pSAppPDTViewBase.getPSAppPDTViewName());
        }
        if (pSAppPDTViewBase.isPSAppViewIdDirty() && (bl || pSAppPDTViewBase.getPSAppViewId() != null)) {
            iDataObject.set(FIELD_PSAPPVIEWID, (Object)pSAppPDTViewBase.getPSAppViewId());
        }
        if (pSAppPDTViewBase.isPSAppViewNameDirty() && (bl || pSAppPDTViewBase.getPSAppViewName() != null)) {
            iDataObject.set(FIELD_PSAPPVIEWNAME, (Object)pSAppPDTViewBase.getPSAppViewName());
        }
        if (pSAppPDTViewBase.isPSSysAppIdDirty() && (bl || pSAppPDTViewBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSAppPDTViewBase.getPSSysAppId());
        }
        if (pSAppPDTViewBase.isPSSysAppNameDirty() && (bl || pSAppPDTViewBase.getPSSysAppName() != null)) {
            iDataObject.set(FIELD_PSSYSAPPNAME, (Object)pSAppPDTViewBase.getPSSysAppName());
        }
        if (pSAppPDTViewBase.isPSSysPDTViewIdDirty() && (bl || pSAppPDTViewBase.getPSSysPDTViewId() != null)) {
            iDataObject.set(FIELD_PSSYSPDTVIEWID, (Object)pSAppPDTViewBase.getPSSysPDTViewId());
        }
        if (pSAppPDTViewBase.isPSSysPDTViewNameDirty() && (bl || pSAppPDTViewBase.getPSSysPDTViewName() != null)) {
            iDataObject.set(FIELD_PSSYSPDTVIEWNAME, (Object)pSAppPDTViewBase.getPSSysPDTViewName());
        }
        if (pSAppPDTViewBase.isUpdateDateDirty() && (bl || pSAppPDTViewBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSAppPDTViewBase.getUpdateDate());
        }
        if (pSAppPDTViewBase.isUpdateManDirty() && (bl || pSAppPDTViewBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSAppPDTViewBase.getUpdateMan());
        }
        if (pSAppPDTViewBase.isUserCatDirty() && (bl || pSAppPDTViewBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSAppPDTViewBase.getUserCat());
        }
        if (pSAppPDTViewBase.isUserTagDirty() && (bl || pSAppPDTViewBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSAppPDTViewBase.getUserTag());
        }
        if (pSAppPDTViewBase.isUserTag2Dirty() && (bl || pSAppPDTViewBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSAppPDTViewBase.getUserTag2());
        }
        if (pSAppPDTViewBase.isUserTag3Dirty() && (bl || pSAppPDTViewBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSAppPDTViewBase.getUserTag3());
        }
        if (pSAppPDTViewBase.isUserTag4Dirty() && (bl || pSAppPDTViewBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSAppPDTViewBase.getUserTag4());
        }
        if (pSAppPDTViewBase.isValidFlagDirty() && (bl || pSAppPDTViewBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSAppPDTViewBase.getValidFlag());
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
        return PSAppPDTViewBase.remove(this, n);
    }

    private static boolean remove(PSAppPDTViewBase pSAppPDTViewBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSAppPDTViewBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSAppPDTViewBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSAppPDTViewBase.resetMemo();
                return true;
            }
            case 3: {
                pSAppPDTViewBase.resetPSAppPDTViewId();
                return true;
            }
            case 4: {
                pSAppPDTViewBase.resetPSAppPDTViewName();
                return true;
            }
            case 5: {
                pSAppPDTViewBase.resetPSAppViewId();
                return true;
            }
            case 6: {
                pSAppPDTViewBase.resetPSAppViewName();
                return true;
            }
            case 7: {
                pSAppPDTViewBase.resetPSSysAppId();
                return true;
            }
            case 8: {
                pSAppPDTViewBase.resetPSSysAppName();
                return true;
            }
            case 9: {
                pSAppPDTViewBase.resetPSSysPDTViewId();
                return true;
            }
            case 10: {
                pSAppPDTViewBase.resetPSSysPDTViewName();
                return true;
            }
            case 11: {
                pSAppPDTViewBase.resetUpdateDate();
                return true;
            }
            case 12: {
                pSAppPDTViewBase.resetUpdateMan();
                return true;
            }
            case 13: {
                pSAppPDTViewBase.resetUserCat();
                return true;
            }
            case 14: {
                pSAppPDTViewBase.resetUserTag();
                return true;
            }
            case 15: {
                pSAppPDTViewBase.resetUserTag2();
                return true;
            }
            case 16: {
                pSAppPDTViewBase.resetUserTag3();
                return true;
            }
            case 17: {
                pSAppPDTViewBase.resetUserTag4();
                return true;
            }
            case 18: {
                pSAppPDTViewBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSAppView getPSAppView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppView();
        }
        if (this.getPSAppViewId() == null) {
            return null;
        }
        Integer n = this.objPSAppViewLock;
        synchronized (n) {
            if (this.psappview != null && DataTypeHelper.compare((int)25, (Object)this.getPSAppViewId(), (Object)this.psappview.getPSAppViewId()) != 0L) {
                this.psappview = null;
            }
            if (this.psappview == null) {
                PSAppView pSAppView = new PSAppView();
                pSAppView.setPSAppViewId(this.getPSAppViewId());
                PSAppViewService pSAppViewService = (PSAppViewService)ServiceGlobal.getService(PSAppViewService.class, (SessionFactory)this.getSessionFactory());
                pSAppViewService.autoGet(pSAppView);
                this.psappview = pSAppView;
            }
            return this.psappview;
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
    public PSSysPDTView getPSSysPDTView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPDTView();
        }
        if (this.getPSSysPDTViewId() == null) {
            return null;
        }
        Integer n = this.objPSSysPDTViewLock;
        synchronized (n) {
            if (this.pssyspdtview != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysPDTViewId(), (Object)this.pssyspdtview.getPSSysPDTViewId()) != 0L) {
                this.pssyspdtview = null;
            }
            if (this.pssyspdtview == null) {
                PSSysPDTView pSSysPDTView = new PSSysPDTView();
                pSSysPDTView.setPSSysPDTViewId(this.getPSSysPDTViewId());
                PSSysPDTViewService pSSysPDTViewService = (PSSysPDTViewService)ServiceGlobal.getService(PSSysPDTViewService.class, (SessionFactory)this.getSessionFactory());
                pSSysPDTViewService.autoGet(pSSysPDTView);
                this.pssyspdtview = pSSysPDTView;
            }
            return this.pssyspdtview;
        }
    }

    private PSAppPDTViewBase getProxyEntity() {
        return this.proxyPSAppPDTViewBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSAppPDTViewBase = null;
        if (iDataObject != null && iDataObject instanceof PSAppPDTViewBase) {
            this.proxyPSAppPDTViewBase = (PSAppPDTViewBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppPDTViewService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSAPPPDTVIEWID, 3);
        fieldIndexMap.put(FIELD_PSAPPPDTVIEWNAME, 4);
        fieldIndexMap.put(FIELD_PSAPPVIEWID, 5);
        fieldIndexMap.put(FIELD_PSAPPVIEWNAME, 6);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 7);
        fieldIndexMap.put(FIELD_PSSYSAPPNAME, 8);
        fieldIndexMap.put(FIELD_PSSYSPDTVIEWID, 9);
        fieldIndexMap.put(FIELD_PSSYSPDTVIEWNAME, 10);
        fieldIndexMap.put(FIELD_UPDATEDATE, 11);
        fieldIndexMap.put(FIELD_UPDATEMAN, 12);
        fieldIndexMap.put(FIELD_USERCAT, 13);
        fieldIndexMap.put(FIELD_USERTAG, 14);
        fieldIndexMap.put(FIELD_USERTAG2, 15);
        fieldIndexMap.put(FIELD_USERTAG3, 16);
        fieldIndexMap.put(FIELD_USERTAG4, 17);
        fieldIndexMap.put(FIELD_VALIDFLAG, 18);
    }
}

