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
import net.ibizsys.pscore.srv.appdesign.entity.PSAppSBItem;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppSBItemRS;
import net.ibizsys.pscore.srv.appdesign.service.PSAppSBItemRSService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppSBItemService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppStoryBoardService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppStoryBoardBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSAppStoryBoardBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSAPPSTORYBOARDID = "PSAPPSTORYBOARDID";
    public static final String FIELD_PSAPPSTORYBOARDNAME = "PSAPPSTORYBOARDNAME";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String FIELD_SBMODEL = "SBMODEL";
    public static final String FIELD_SBTAG = "SBTAG";
    public static final String FIELD_SBTAG2 = "SBTAG2";
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
    private static final int INDEX_DEFAULTFLAG = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PSAPPSTORYBOARDID = 5;
    private static final int INDEX_PSAPPSTORYBOARDNAME = 6;
    private static final int INDEX_PSDYNAINSTID = 7;
    private static final int INDEX_PSSYSAPPID = 8;
    private static final int INDEX_PSSYSAPPNAME = 9;
    private static final int INDEX_SBMODEL = 10;
    private static final int INDEX_SBTAG = 11;
    private static final int INDEX_SBTAG2 = 12;
    private static final int INDEX_UPDATEDATE = 13;
    private static final int INDEX_UPDATEMAN = 14;
    private static final int INDEX_USERCAT = 15;
    private static final int INDEX_USERTAG = 16;
    private static final int INDEX_USERTAG2 = 17;
    private static final int INDEX_USERTAG3 = 18;
    private static final int INDEX_USERTAG4 = 19;
    private static final int INDEX_VALIDFLAG = 20;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSAppStoryBoardBase proxyPSAppStoryBoardBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean defaultflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psappstoryboardidDirtyFlag = false;
    private boolean psappstoryboardnameDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean pssysappnameDirtyFlag = false;
    private boolean sbmodelDirtyFlag = false;
    private boolean sbtagDirtyFlag = false;
    private boolean sbtag2DirtyFlag = false;
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
    @Column(name="defaultflag")
    private Integer defaultflag;
    @Column(name="memo")
    private String memo;
    @Column(name="psappstoryboardid")
    private String psappstoryboardid;
    @Column(name="psappstoryboardname")
    private String psappstoryboardname;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="pssysappid")
    private String pssysappid;
    @Column(name="pssysappname")
    private String pssysappname;
    @Column(name="sbmodel")
    private String sbmodel;
    @Column(name="sbtag")
    private String sbtag;
    @Column(name="sbtag2")
    private String sbtag2;
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
    private Integer objPSSysAppLock = new Integer(1);
    private PSSysApp pssysapp = null;
    private Integer objPSAppSBItemRSsLock = new Integer(1);
    private ArrayList<PSAppSBItemRS> psappsbitemrss = null;
    private Integer objPSAppSBItemsLock = new Integer(1);
    private ArrayList<PSAppSBItem> psappsbitems = null;

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

    public void setDefaultFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefaultFlag(n);
            return;
        }
        this.defaultflag = n;
        this.defaultflagDirtyFlag = true;
    }

    public Integer getDefaultFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefaultFlag();
        }
        return this.defaultflag;
    }

    public boolean isDefaultFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefaultFlagDirty();
        }
        return this.defaultflagDirtyFlag;
    }

    public void resetDefaultFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefaultFlag();
            return;
        }
        this.defaultflagDirtyFlag = false;
        this.defaultflag = null;
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

    public void setPSAppStoryBoardId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppStoryBoardId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappstoryboardid = string;
        this.psappstoryboardidDirtyFlag = true;
    }

    public String getPSAppStoryBoardId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppStoryBoardId();
        }
        return this.psappstoryboardid;
    }

    public boolean isPSAppStoryBoardIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppStoryBoardIdDirty();
        }
        return this.psappstoryboardidDirtyFlag;
    }

    public void resetPSAppStoryBoardId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppStoryBoardId();
            return;
        }
        this.psappstoryboardidDirtyFlag = false;
        this.psappstoryboardid = null;
    }

    public void setPSAppStoryBoardName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppStoryBoardName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappstoryboardname = string;
        this.psappstoryboardnameDirtyFlag = true;
    }

    public String getPSAppStoryBoardName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppStoryBoardName();
        }
        return this.psappstoryboardname;
    }

    public boolean isPSAppStoryBoardNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppStoryBoardNameDirty();
        }
        return this.psappstoryboardnameDirtyFlag;
    }

    public void resetPSAppStoryBoardName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppStoryBoardName();
            return;
        }
        this.psappstoryboardnameDirtyFlag = false;
        this.psappstoryboardname = null;
    }

    public void setPSDynaInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynainstid = string;
        this.psdynainstidDirtyFlag = true;
    }

    public String getPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaInstId();
        }
        return this.psdynainstid;
    }

    public boolean isPSDynaInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaInstIdDirty();
        }
        return this.psdynainstidDirtyFlag;
    }

    public void resetPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaInstId();
            return;
        }
        this.psdynainstidDirtyFlag = false;
        this.psdynainstid = null;
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

    public void setSBModel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSBModel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sbmodel = string;
        this.sbmodelDirtyFlag = true;
    }

    public String getSBModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSBModel();
        }
        return this.sbmodel;
    }

    public boolean isSBModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSBModelDirty();
        }
        return this.sbmodelDirtyFlag;
    }

    public void resetSBModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSBModel();
            return;
        }
        this.sbmodelDirtyFlag = false;
        this.sbmodel = null;
    }

    public void setSBTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSBTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sbtag = string;
        this.sbtagDirtyFlag = true;
    }

    public String getSBTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSBTag();
        }
        return this.sbtag;
    }

    public boolean isSBTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSBTagDirty();
        }
        return this.sbtagDirtyFlag;
    }

    public void resetSBTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSBTag();
            return;
        }
        this.sbtagDirtyFlag = false;
        this.sbtag = null;
    }

    public void setSBTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSBTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sbtag2 = string;
        this.sbtag2DirtyFlag = true;
    }

    public String getSBTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSBTag2();
        }
        return this.sbtag2;
    }

    public boolean isSBTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSBTag2Dirty();
        }
        return this.sbtag2DirtyFlag;
    }

    public void resetSBTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSBTag2();
            return;
        }
        this.sbtag2DirtyFlag = false;
        this.sbtag2 = null;
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
        PSAppStoryBoardBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSAppStoryBoardBase pSAppStoryBoardBase) {
        pSAppStoryBoardBase.resetCodeName();
        pSAppStoryBoardBase.resetCreateDate();
        pSAppStoryBoardBase.resetCreateMan();
        pSAppStoryBoardBase.resetDefaultFlag();
        pSAppStoryBoardBase.resetMemo();
        pSAppStoryBoardBase.resetPSAppStoryBoardId();
        pSAppStoryBoardBase.resetPSAppStoryBoardName();
        pSAppStoryBoardBase.resetPSDynaInstId();
        pSAppStoryBoardBase.resetPSSysAppId();
        pSAppStoryBoardBase.resetPSSysAppName();
        pSAppStoryBoardBase.resetSBModel();
        pSAppStoryBoardBase.resetSBTag();
        pSAppStoryBoardBase.resetSBTag2();
        pSAppStoryBoardBase.resetUpdateDate();
        pSAppStoryBoardBase.resetUpdateMan();
        pSAppStoryBoardBase.resetUserCat();
        pSAppStoryBoardBase.resetUserTag();
        pSAppStoryBoardBase.resetUserTag2();
        pSAppStoryBoardBase.resetUserTag3();
        pSAppStoryBoardBase.resetUserTag4();
        pSAppStoryBoardBase.resetValidFlag();
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
        if (!bl || this.isDefaultFlagDirty()) {
            hashMap.put(FIELD_DEFAULTFLAG, this.getDefaultFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSAppStoryBoardIdDirty()) {
            hashMap.put(FIELD_PSAPPSTORYBOARDID, this.getPSAppStoryBoardId());
        }
        if (!bl || this.isPSAppStoryBoardNameDirty()) {
            hashMap.put(FIELD_PSAPPSTORYBOARDNAME, this.getPSAppStoryBoardName());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSSysAppIdDirty()) {
            hashMap.put(FIELD_PSSYSAPPID, this.getPSSysAppId());
        }
        if (!bl || this.isPSSysAppNameDirty()) {
            hashMap.put(FIELD_PSSYSAPPNAME, this.getPSSysAppName());
        }
        if (!bl || this.isSBModelDirty()) {
            hashMap.put(FIELD_SBMODEL, this.getSBModel());
        }
        if (!bl || this.isSBTagDirty()) {
            hashMap.put(FIELD_SBTAG, this.getSBTag());
        }
        if (!bl || this.isSBTag2Dirty()) {
            hashMap.put(FIELD_SBTAG2, this.getSBTag2());
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
        return PSAppStoryBoardBase.get(this, n);
    }

    private static Object get(PSAppStoryBoardBase pSAppStoryBoardBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppStoryBoardBase.getCodeName();
            }
            case 1: {
                return pSAppStoryBoardBase.getCreateDate();
            }
            case 2: {
                return pSAppStoryBoardBase.getCreateMan();
            }
            case 3: {
                return pSAppStoryBoardBase.getDefaultFlag();
            }
            case 4: {
                return pSAppStoryBoardBase.getMemo();
            }
            case 5: {
                return pSAppStoryBoardBase.getPSAppStoryBoardId();
            }
            case 6: {
                return pSAppStoryBoardBase.getPSAppStoryBoardName();
            }
            case 7: {
                return pSAppStoryBoardBase.getPSDynaInstId();
            }
            case 8: {
                return pSAppStoryBoardBase.getPSSysAppId();
            }
            case 9: {
                return pSAppStoryBoardBase.getPSSysAppName();
            }
            case 10: {
                return pSAppStoryBoardBase.getSBModel();
            }
            case 11: {
                return pSAppStoryBoardBase.getSBTag();
            }
            case 12: {
                return pSAppStoryBoardBase.getSBTag2();
            }
            case 13: {
                return pSAppStoryBoardBase.getUpdateDate();
            }
            case 14: {
                return pSAppStoryBoardBase.getUpdateMan();
            }
            case 15: {
                return pSAppStoryBoardBase.getUserCat();
            }
            case 16: {
                return pSAppStoryBoardBase.getUserTag();
            }
            case 17: {
                return pSAppStoryBoardBase.getUserTag2();
            }
            case 18: {
                return pSAppStoryBoardBase.getUserTag3();
            }
            case 19: {
                return pSAppStoryBoardBase.getUserTag4();
            }
            case 20: {
                return pSAppStoryBoardBase.getValidFlag();
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
        PSAppStoryBoardBase.set(this, n, object);
    }

    private static void set(PSAppStoryBoardBase pSAppStoryBoardBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSAppStoryBoardBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSAppStoryBoardBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSAppStoryBoardBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSAppStoryBoardBase.setDefaultFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSAppStoryBoardBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSAppStoryBoardBase.setPSAppStoryBoardId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSAppStoryBoardBase.setPSAppStoryBoardName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSAppStoryBoardBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSAppStoryBoardBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSAppStoryBoardBase.setPSSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSAppStoryBoardBase.setSBModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSAppStoryBoardBase.setSBTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSAppStoryBoardBase.setSBTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSAppStoryBoardBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 14: {
                pSAppStoryBoardBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSAppStoryBoardBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSAppStoryBoardBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSAppStoryBoardBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSAppStoryBoardBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSAppStoryBoardBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSAppStoryBoardBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSAppStoryBoardBase.isNull(this, n);
    }

    private static boolean isNull(PSAppStoryBoardBase pSAppStoryBoardBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppStoryBoardBase.getCodeName() == null;
            }
            case 1: {
                return pSAppStoryBoardBase.getCreateDate() == null;
            }
            case 2: {
                return pSAppStoryBoardBase.getCreateMan() == null;
            }
            case 3: {
                return pSAppStoryBoardBase.getDefaultFlag() == null;
            }
            case 4: {
                return pSAppStoryBoardBase.getMemo() == null;
            }
            case 5: {
                return pSAppStoryBoardBase.getPSAppStoryBoardId() == null;
            }
            case 6: {
                return pSAppStoryBoardBase.getPSAppStoryBoardName() == null;
            }
            case 7: {
                return pSAppStoryBoardBase.getPSDynaInstId() == null;
            }
            case 8: {
                return pSAppStoryBoardBase.getPSSysAppId() == null;
            }
            case 9: {
                return pSAppStoryBoardBase.getPSSysAppName() == null;
            }
            case 10: {
                return pSAppStoryBoardBase.getSBModel() == null;
            }
            case 11: {
                return pSAppStoryBoardBase.getSBTag() == null;
            }
            case 12: {
                return pSAppStoryBoardBase.getSBTag2() == null;
            }
            case 13: {
                return pSAppStoryBoardBase.getUpdateDate() == null;
            }
            case 14: {
                return pSAppStoryBoardBase.getUpdateMan() == null;
            }
            case 15: {
                return pSAppStoryBoardBase.getUserCat() == null;
            }
            case 16: {
                return pSAppStoryBoardBase.getUserTag() == null;
            }
            case 17: {
                return pSAppStoryBoardBase.getUserTag2() == null;
            }
            case 18: {
                return pSAppStoryBoardBase.getUserTag3() == null;
            }
            case 19: {
                return pSAppStoryBoardBase.getUserTag4() == null;
            }
            case 20: {
                return pSAppStoryBoardBase.getValidFlag() == null;
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
        return PSAppStoryBoardBase.contains(this, n);
    }

    private static boolean contains(PSAppStoryBoardBase pSAppStoryBoardBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppStoryBoardBase.isCodeNameDirty();
            }
            case 1: {
                return pSAppStoryBoardBase.isCreateDateDirty();
            }
            case 2: {
                return pSAppStoryBoardBase.isCreateManDirty();
            }
            case 3: {
                return pSAppStoryBoardBase.isDefaultFlagDirty();
            }
            case 4: {
                return pSAppStoryBoardBase.isMemoDirty();
            }
            case 5: {
                return pSAppStoryBoardBase.isPSAppStoryBoardIdDirty();
            }
            case 6: {
                return pSAppStoryBoardBase.isPSAppStoryBoardNameDirty();
            }
            case 7: {
                return pSAppStoryBoardBase.isPSDynaInstIdDirty();
            }
            case 8: {
                return pSAppStoryBoardBase.isPSSysAppIdDirty();
            }
            case 9: {
                return pSAppStoryBoardBase.isPSSysAppNameDirty();
            }
            case 10: {
                return pSAppStoryBoardBase.isSBModelDirty();
            }
            case 11: {
                return pSAppStoryBoardBase.isSBTagDirty();
            }
            case 12: {
                return pSAppStoryBoardBase.isSBTag2Dirty();
            }
            case 13: {
                return pSAppStoryBoardBase.isUpdateDateDirty();
            }
            case 14: {
                return pSAppStoryBoardBase.isUpdateManDirty();
            }
            case 15: {
                return pSAppStoryBoardBase.isUserCatDirty();
            }
            case 16: {
                return pSAppStoryBoardBase.isUserTagDirty();
            }
            case 17: {
                return pSAppStoryBoardBase.isUserTag2Dirty();
            }
            case 18: {
                return pSAppStoryBoardBase.isUserTag3Dirty();
            }
            case 19: {
                return pSAppStoryBoardBase.isUserTag4Dirty();
            }
            case 20: {
                return pSAppStoryBoardBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSAppStoryBoardBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSAppStoryBoardBase pSAppStoryBoardBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSAppStoryBoardBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSAppStoryBoardBase.getJSONValue((Object)pSAppStoryBoardBase.getCodeName()), (boolean)false);
        }
        if (bl || pSAppStoryBoardBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSAppStoryBoardBase.getJSONValue((Object)pSAppStoryBoardBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSAppStoryBoardBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSAppStoryBoardBase.getJSONValue((Object)pSAppStoryBoardBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSAppStoryBoardBase.getDefaultFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultflag", (Object)PSAppStoryBoardBase.getJSONValue((Object)pSAppStoryBoardBase.getDefaultFlag()), (boolean)false);
        }
        if (bl || pSAppStoryBoardBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSAppStoryBoardBase.getJSONValue((Object)pSAppStoryBoardBase.getMemo()), (boolean)false);
        }
        if (bl || pSAppStoryBoardBase.getPSAppStoryBoardId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappstoryboardid", (Object)PSAppStoryBoardBase.getJSONValue((Object)pSAppStoryBoardBase.getPSAppStoryBoardId()), (boolean)false);
        }
        if (bl || pSAppStoryBoardBase.getPSAppStoryBoardName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappstoryboardname", (Object)PSAppStoryBoardBase.getJSONValue((Object)pSAppStoryBoardBase.getPSAppStoryBoardName()), (boolean)false);
        }
        if (bl || pSAppStoryBoardBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSAppStoryBoardBase.getJSONValue((Object)pSAppStoryBoardBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSAppStoryBoardBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSAppStoryBoardBase.getJSONValue((Object)pSAppStoryBoardBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSAppStoryBoardBase.getPSSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappname", (Object)PSAppStoryBoardBase.getJSONValue((Object)pSAppStoryBoardBase.getPSSysAppName()), (boolean)false);
        }
        if (bl || pSAppStoryBoardBase.getSBModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sbmodel", (Object)PSAppStoryBoardBase.getJSONValue((Object)pSAppStoryBoardBase.getSBModel()), (boolean)false);
        }
        if (bl || pSAppStoryBoardBase.getSBTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sbtag", (Object)PSAppStoryBoardBase.getJSONValue((Object)pSAppStoryBoardBase.getSBTag()), (boolean)false);
        }
        if (bl || pSAppStoryBoardBase.getSBTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sbtag2", (Object)PSAppStoryBoardBase.getJSONValue((Object)pSAppStoryBoardBase.getSBTag2()), (boolean)false);
        }
        if (bl || pSAppStoryBoardBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSAppStoryBoardBase.getJSONValue((Object)pSAppStoryBoardBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSAppStoryBoardBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSAppStoryBoardBase.getJSONValue((Object)pSAppStoryBoardBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSAppStoryBoardBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSAppStoryBoardBase.getJSONValue((Object)pSAppStoryBoardBase.getUserCat()), (boolean)false);
        }
        if (bl || pSAppStoryBoardBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSAppStoryBoardBase.getJSONValue((Object)pSAppStoryBoardBase.getUserTag()), (boolean)false);
        }
        if (bl || pSAppStoryBoardBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSAppStoryBoardBase.getJSONValue((Object)pSAppStoryBoardBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSAppStoryBoardBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSAppStoryBoardBase.getJSONValue((Object)pSAppStoryBoardBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSAppStoryBoardBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSAppStoryBoardBase.getJSONValue((Object)pSAppStoryBoardBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSAppStoryBoardBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSAppStoryBoardBase.getJSONValue((Object)pSAppStoryBoardBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSAppStoryBoardBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSAppStoryBoardBase pSAppStoryBoardBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSAppStoryBoardBase.getCodeName() != null) {
            object = pSAppStoryBoardBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppStoryBoardBase.getCreateDate() != null) {
            object = pSAppStoryBoardBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppStoryBoardBase.getCreateMan() != null) {
            object = pSAppStoryBoardBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppStoryBoardBase.getDefaultFlag() != null) {
            object = pSAppStoryBoardBase.getDefaultFlag();
            xmlNode.setAttribute(FIELD_DEFAULTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppStoryBoardBase.getMemo() != null) {
            object = pSAppStoryBoardBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSAppStoryBoardBase.getPSAppStoryBoardId() != null) {
            object = pSAppStoryBoardBase.getPSAppStoryBoardId();
            xmlNode.setAttribute(FIELD_PSAPPSTORYBOARDID, object == null ? "" : (String)object);
        }
        if (bl || pSAppStoryBoardBase.getPSAppStoryBoardName() != null) {
            object = pSAppStoryBoardBase.getPSAppStoryBoardName();
            xmlNode.setAttribute(FIELD_PSAPPSTORYBOARDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppStoryBoardBase.getPSDynaInstId() != null) {
            object = pSAppStoryBoardBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSAppStoryBoardBase.getPSSysAppId() != null) {
            object = pSAppStoryBoardBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSAppStoryBoardBase.getPSSysAppName() != null) {
            object = pSAppStoryBoardBase.getPSSysAppName();
            xmlNode.setAttribute(FIELD_PSSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppStoryBoardBase.getSBModel() != null) {
            object = pSAppStoryBoardBase.getSBModel();
            xmlNode.setAttribute(FIELD_SBMODEL, object == null ? "" : (String)object);
        }
        if (bl || pSAppStoryBoardBase.getSBTag() != null) {
            object = pSAppStoryBoardBase.getSBTag();
            xmlNode.setAttribute(FIELD_SBTAG, object == null ? "" : (String)object);
        }
        if (bl || pSAppStoryBoardBase.getSBTag2() != null) {
            object = pSAppStoryBoardBase.getSBTag2();
            xmlNode.setAttribute(FIELD_SBTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSAppStoryBoardBase.getUpdateDate() != null) {
            object = pSAppStoryBoardBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppStoryBoardBase.getUpdateMan() != null) {
            object = pSAppStoryBoardBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppStoryBoardBase.getUserCat() != null) {
            object = pSAppStoryBoardBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSAppStoryBoardBase.getUserTag() != null) {
            object = pSAppStoryBoardBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSAppStoryBoardBase.getUserTag2() != null) {
            object = pSAppStoryBoardBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSAppStoryBoardBase.getUserTag3() != null) {
            object = pSAppStoryBoardBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSAppStoryBoardBase.getUserTag4() != null) {
            object = pSAppStoryBoardBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSAppStoryBoardBase.getValidFlag() != null) {
            object = pSAppStoryBoardBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSAppStoryBoardBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSAppStoryBoardBase pSAppStoryBoardBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSAppStoryBoardBase.isCodeNameDirty() && (bl || pSAppStoryBoardBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSAppStoryBoardBase.getCodeName());
        }
        if (pSAppStoryBoardBase.isCreateDateDirty() && (bl || pSAppStoryBoardBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSAppStoryBoardBase.getCreateDate());
        }
        if (pSAppStoryBoardBase.isCreateManDirty() && (bl || pSAppStoryBoardBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSAppStoryBoardBase.getCreateMan());
        }
        if (pSAppStoryBoardBase.isDefaultFlagDirty() && (bl || pSAppStoryBoardBase.getDefaultFlag() != null)) {
            iDataObject.set(FIELD_DEFAULTFLAG, (Object)pSAppStoryBoardBase.getDefaultFlag());
        }
        if (pSAppStoryBoardBase.isMemoDirty() && (bl || pSAppStoryBoardBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSAppStoryBoardBase.getMemo());
        }
        if (pSAppStoryBoardBase.isPSAppStoryBoardIdDirty() && (bl || pSAppStoryBoardBase.getPSAppStoryBoardId() != null)) {
            iDataObject.set(FIELD_PSAPPSTORYBOARDID, (Object)pSAppStoryBoardBase.getPSAppStoryBoardId());
        }
        if (pSAppStoryBoardBase.isPSAppStoryBoardNameDirty() && (bl || pSAppStoryBoardBase.getPSAppStoryBoardName() != null)) {
            iDataObject.set(FIELD_PSAPPSTORYBOARDNAME, (Object)pSAppStoryBoardBase.getPSAppStoryBoardName());
        }
        if (pSAppStoryBoardBase.isPSDynaInstIdDirty() && (bl || pSAppStoryBoardBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSAppStoryBoardBase.getPSDynaInstId());
        }
        if (pSAppStoryBoardBase.isPSSysAppIdDirty() && (bl || pSAppStoryBoardBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSAppStoryBoardBase.getPSSysAppId());
        }
        if (pSAppStoryBoardBase.isPSSysAppNameDirty() && (bl || pSAppStoryBoardBase.getPSSysAppName() != null)) {
            iDataObject.set(FIELD_PSSYSAPPNAME, (Object)pSAppStoryBoardBase.getPSSysAppName());
        }
        if (pSAppStoryBoardBase.isSBModelDirty() && (bl || pSAppStoryBoardBase.getSBModel() != null)) {
            iDataObject.set(FIELD_SBMODEL, (Object)pSAppStoryBoardBase.getSBModel());
        }
        if (pSAppStoryBoardBase.isSBTagDirty() && (bl || pSAppStoryBoardBase.getSBTag() != null)) {
            iDataObject.set(FIELD_SBTAG, (Object)pSAppStoryBoardBase.getSBTag());
        }
        if (pSAppStoryBoardBase.isSBTag2Dirty() && (bl || pSAppStoryBoardBase.getSBTag2() != null)) {
            iDataObject.set(FIELD_SBTAG2, (Object)pSAppStoryBoardBase.getSBTag2());
        }
        if (pSAppStoryBoardBase.isUpdateDateDirty() && (bl || pSAppStoryBoardBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSAppStoryBoardBase.getUpdateDate());
        }
        if (pSAppStoryBoardBase.isUpdateManDirty() && (bl || pSAppStoryBoardBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSAppStoryBoardBase.getUpdateMan());
        }
        if (pSAppStoryBoardBase.isUserCatDirty() && (bl || pSAppStoryBoardBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSAppStoryBoardBase.getUserCat());
        }
        if (pSAppStoryBoardBase.isUserTagDirty() && (bl || pSAppStoryBoardBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSAppStoryBoardBase.getUserTag());
        }
        if (pSAppStoryBoardBase.isUserTag2Dirty() && (bl || pSAppStoryBoardBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSAppStoryBoardBase.getUserTag2());
        }
        if (pSAppStoryBoardBase.isUserTag3Dirty() && (bl || pSAppStoryBoardBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSAppStoryBoardBase.getUserTag3());
        }
        if (pSAppStoryBoardBase.isUserTag4Dirty() && (bl || pSAppStoryBoardBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSAppStoryBoardBase.getUserTag4());
        }
        if (pSAppStoryBoardBase.isValidFlagDirty() && (bl || pSAppStoryBoardBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSAppStoryBoardBase.getValidFlag());
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
        return PSAppStoryBoardBase.remove(this, n);
    }

    private static boolean remove(PSAppStoryBoardBase pSAppStoryBoardBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSAppStoryBoardBase.resetCodeName();
                return true;
            }
            case 1: {
                pSAppStoryBoardBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSAppStoryBoardBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSAppStoryBoardBase.resetDefaultFlag();
                return true;
            }
            case 4: {
                pSAppStoryBoardBase.resetMemo();
                return true;
            }
            case 5: {
                pSAppStoryBoardBase.resetPSAppStoryBoardId();
                return true;
            }
            case 6: {
                pSAppStoryBoardBase.resetPSAppStoryBoardName();
                return true;
            }
            case 7: {
                pSAppStoryBoardBase.resetPSDynaInstId();
                return true;
            }
            case 8: {
                pSAppStoryBoardBase.resetPSSysAppId();
                return true;
            }
            case 9: {
                pSAppStoryBoardBase.resetPSSysAppName();
                return true;
            }
            case 10: {
                pSAppStoryBoardBase.resetSBModel();
                return true;
            }
            case 11: {
                pSAppStoryBoardBase.resetSBTag();
                return true;
            }
            case 12: {
                pSAppStoryBoardBase.resetSBTag2();
                return true;
            }
            case 13: {
                pSAppStoryBoardBase.resetUpdateDate();
                return true;
            }
            case 14: {
                pSAppStoryBoardBase.resetUpdateMan();
                return true;
            }
            case 15: {
                pSAppStoryBoardBase.resetUserCat();
                return true;
            }
            case 16: {
                pSAppStoryBoardBase.resetUserTag();
                return true;
            }
            case 17: {
                pSAppStoryBoardBase.resetUserTag2();
                return true;
            }
            case 18: {
                pSAppStoryBoardBase.resetUserTag3();
                return true;
            }
            case 19: {
                pSAppStoryBoardBase.resetUserTag4();
                return true;
            }
            case 20: {
                pSAppStoryBoardBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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
    public ArrayList<PSAppSBItemRS> getPSAppSBItemRSs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppSBItemRSs();
        }
        if (this.getPSAppStoryBoardId() == null) {
            return null;
        }
        PSAppStoryBoardService pSAppStoryBoardService = (PSAppStoryBoardService)ServiceGlobal.getService(PSAppStoryBoardService.class, (SessionFactory)this.getSessionFactory());
        PSAppSBItemRSService pSAppSBItemRSService = (PSAppSBItemRSService)ServiceGlobal.getService(PSAppSBItemRSService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSAppSBItemRSsLock;
        synchronized (n) {
            if (this.psappsbitemrss == null) {
                this.psappsbitemrss = pSAppStoryBoardService.isTempData(this) ? pSAppSBItemRSService.selectTempByPSAppStoryBoard(this) : pSAppSBItemRSService.selectByPSAppStoryBoard(this);
            }
            return this.psappsbitemrss;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSAppSBItem> getPSAppSBItems() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppSBItems();
        }
        if (this.getPSAppStoryBoardId() == null) {
            return null;
        }
        PSAppStoryBoardService pSAppStoryBoardService = (PSAppStoryBoardService)ServiceGlobal.getService(PSAppStoryBoardService.class, (SessionFactory)this.getSessionFactory());
        PSAppSBItemService pSAppSBItemService = (PSAppSBItemService)ServiceGlobal.getService(PSAppSBItemService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSAppSBItemsLock;
        synchronized (n) {
            if (this.psappsbitems == null) {
                this.psappsbitems = pSAppStoryBoardService.isTempData(this) ? pSAppSBItemService.selectTempByPSAppStoryBoard(this) : pSAppSBItemService.selectByPSAppStoryBoard(this);
            }
            return this.psappsbitems;
        }
    }

    private PSAppStoryBoardBase getProxyEntity() {
        return this.proxyPSAppStoryBoardBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSAppStoryBoardBase = null;
        if (iDataObject != null && iDataObject instanceof PSAppStoryBoardBase) {
            this.proxyPSAppStoryBoardBase = (PSAppStoryBoardBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppStoryBoardService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_DEFAULTFLAG, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PSAPPSTORYBOARDID, 5);
        fieldIndexMap.put(FIELD_PSAPPSTORYBOARDNAME, 6);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 7);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 8);
        fieldIndexMap.put(FIELD_PSSYSAPPNAME, 9);
        fieldIndexMap.put(FIELD_SBMODEL, 10);
        fieldIndexMap.put(FIELD_SBTAG, 11);
        fieldIndexMap.put(FIELD_SBTAG2, 12);
        fieldIndexMap.put(FIELD_UPDATEDATE, 13);
        fieldIndexMap.put(FIELD_UPDATEMAN, 14);
        fieldIndexMap.put(FIELD_USERCAT, 15);
        fieldIndexMap.put(FIELD_USERTAG, 16);
        fieldIndexMap.put(FIELD_USERTAG2, 17);
        fieldIndexMap.put(FIELD_USERTAG3, 18);
        fieldIndexMap.put(FIELD_USERTAG4, 19);
        fieldIndexMap.put(FIELD_VALIDFLAG, 20);
    }
}

