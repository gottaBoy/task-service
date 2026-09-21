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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppUIThemeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSAppUIThemeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CSSSTYLE = "CSSSTYLE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSAPPUITHEMEID = "PSAPPUITHEMEID";
    public static final String FIELD_PSAPPUITHEMENAME = "PSAPPUITHEMENAME";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String FIELD_THEMEDESC = "THEMEDESC";
    public static final String FIELD_THEMEPARAMS = "THEMEPARAMS";
    public static final String FIELD_THEMETAG = "THEMETAG";
    public static final String FIELD_THEMEURL = "THEMEURL";
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
    private static final int INDEX_CSSSTYLE = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_ORDERVALUE = 4;
    private static final int INDEX_PSAPPUITHEMEID = 5;
    private static final int INDEX_PSAPPUITHEMENAME = 6;
    private static final int INDEX_PSSYSAPPID = 7;
    private static final int INDEX_PSSYSAPPNAME = 8;
    private static final int INDEX_THEMEDESC = 9;
    private static final int INDEX_THEMEPARAMS = 10;
    private static final int INDEX_THEMETAG = 11;
    private static final int INDEX_THEMEURL = 12;
    private static final int INDEX_UPDATEDATE = 13;
    private static final int INDEX_UPDATEMAN = 14;
    private static final int INDEX_USERCAT = 15;
    private static final int INDEX_USERTAG = 16;
    private static final int INDEX_USERTAG2 = 17;
    private static final int INDEX_USERTAG3 = 18;
    private static final int INDEX_USERTAG4 = 19;
    private static final int INDEX_VALIDFLAG = 20;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSAppUIThemeBase proxyPSAppUIThemeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean cssstyleDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psappuithemeidDirtyFlag = false;
    private boolean psappuithemenameDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean pssysappnameDirtyFlag = false;
    private boolean themedescDirtyFlag = false;
    private boolean themeparamsDirtyFlag = false;
    private boolean themetagDirtyFlag = false;
    private boolean themeurlDirtyFlag = false;
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
    @Column(name="cssstyle")
    private String cssstyle;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psappuithemeid")
    private String psappuithemeid;
    @Column(name="psappuithemename")
    private String psappuithemename;
    @Column(name="pssysappid")
    private String pssysappid;
    @Column(name="pssysappname")
    private String pssysappname;
    @Column(name="themedesc")
    private String themedesc;
    @Column(name="themeparams")
    private String themeparams;
    @Column(name="themetag")
    private String themetag;
    @Column(name="themeurl")
    private String themeurl;
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

    public void setCSSStyle(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCSSStyle(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cssstyle = string;
        this.cssstyleDirtyFlag = true;
    }

    public String getCSSStyle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCSSStyle();
        }
        return this.cssstyle;
    }

    public boolean isCSSStyleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCSSStyleDirty();
        }
        return this.cssstyleDirtyFlag;
    }

    public void resetCSSStyle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCSSStyle();
            return;
        }
        this.cssstyleDirtyFlag = false;
        this.cssstyle = null;
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

    public void setPSAppUIThemeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppUIThemeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappuithemeid = string;
        this.psappuithemeidDirtyFlag = true;
    }

    public String getPSAppUIThemeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppUIThemeId();
        }
        return this.psappuithemeid;
    }

    public boolean isPSAppUIThemeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppUIThemeIdDirty();
        }
        return this.psappuithemeidDirtyFlag;
    }

    public void resetPSAppUIThemeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppUIThemeId();
            return;
        }
        this.psappuithemeidDirtyFlag = false;
        this.psappuithemeid = null;
    }

    public void setPSAppUIThemeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppUIThemeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappuithemename = string;
        this.psappuithemenameDirtyFlag = true;
    }

    public String getPSAppUIThemeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppUIThemeName();
        }
        return this.psappuithemename;
    }

    public boolean isPSAppUIThemeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppUIThemeNameDirty();
        }
        return this.psappuithemenameDirtyFlag;
    }

    public void resetPSAppUIThemeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppUIThemeName();
            return;
        }
        this.psappuithemenameDirtyFlag = false;
        this.psappuithemename = null;
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

    public void setThemeDesc(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setThemeDesc(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.themedesc = string;
        this.themedescDirtyFlag = true;
    }

    public String getThemeDesc() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getThemeDesc();
        }
        return this.themedesc;
    }

    public boolean isThemeDescDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isThemeDescDirty();
        }
        return this.themedescDirtyFlag;
    }

    public void resetThemeDesc() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetThemeDesc();
            return;
        }
        this.themedescDirtyFlag = false;
        this.themedesc = null;
    }

    public void setThemeParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setThemeParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.themeparams = string;
        this.themeparamsDirtyFlag = true;
    }

    public String getThemeParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getThemeParams();
        }
        return this.themeparams;
    }

    public boolean isThemeParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isThemeParamsDirty();
        }
        return this.themeparamsDirtyFlag;
    }

    public void resetThemeParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetThemeParams();
            return;
        }
        this.themeparamsDirtyFlag = false;
        this.themeparams = null;
    }

    public void setThemeTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setThemeTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.themetag = string;
        this.themetagDirtyFlag = true;
    }

    public String getThemeTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getThemeTag();
        }
        return this.themetag;
    }

    public boolean isThemeTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isThemeTagDirty();
        }
        return this.themetagDirtyFlag;
    }

    public void resetThemeTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetThemeTag();
            return;
        }
        this.themetagDirtyFlag = false;
        this.themetag = null;
    }

    public void setThemeUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setThemeUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.themeurl = string;
        this.themeurlDirtyFlag = true;
    }

    public String getThemeUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getThemeUrl();
        }
        return this.themeurl;
    }

    public boolean isThemeUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isThemeUrlDirty();
        }
        return this.themeurlDirtyFlag;
    }

    public void resetThemeUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetThemeUrl();
            return;
        }
        this.themeurlDirtyFlag = false;
        this.themeurl = null;
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
        PSAppUIThemeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSAppUIThemeBase pSAppUIThemeBase) {
        pSAppUIThemeBase.resetCreateDate();
        pSAppUIThemeBase.resetCreateMan();
        pSAppUIThemeBase.resetCSSStyle();
        pSAppUIThemeBase.resetMemo();
        pSAppUIThemeBase.resetOrderValue();
        pSAppUIThemeBase.resetPSAppUIThemeId();
        pSAppUIThemeBase.resetPSAppUIThemeName();
        pSAppUIThemeBase.resetPSSysAppId();
        pSAppUIThemeBase.resetPSSysAppName();
        pSAppUIThemeBase.resetThemeDesc();
        pSAppUIThemeBase.resetThemeParams();
        pSAppUIThemeBase.resetThemeTag();
        pSAppUIThemeBase.resetThemeUrl();
        pSAppUIThemeBase.resetUpdateDate();
        pSAppUIThemeBase.resetUpdateMan();
        pSAppUIThemeBase.resetUserCat();
        pSAppUIThemeBase.resetUserTag();
        pSAppUIThemeBase.resetUserTag2();
        pSAppUIThemeBase.resetUserTag3();
        pSAppUIThemeBase.resetUserTag4();
        pSAppUIThemeBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCSSStyleDirty()) {
            hashMap.put(FIELD_CSSSTYLE, this.getCSSStyle());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSAppUIThemeIdDirty()) {
            hashMap.put(FIELD_PSAPPUITHEMEID, this.getPSAppUIThemeId());
        }
        if (!bl || this.isPSAppUIThemeNameDirty()) {
            hashMap.put(FIELD_PSAPPUITHEMENAME, this.getPSAppUIThemeName());
        }
        if (!bl || this.isPSSysAppIdDirty()) {
            hashMap.put(FIELD_PSSYSAPPID, this.getPSSysAppId());
        }
        if (!bl || this.isPSSysAppNameDirty()) {
            hashMap.put(FIELD_PSSYSAPPNAME, this.getPSSysAppName());
        }
        if (!bl || this.isThemeDescDirty()) {
            hashMap.put(FIELD_THEMEDESC, this.getThemeDesc());
        }
        if (!bl || this.isThemeParamsDirty()) {
            hashMap.put(FIELD_THEMEPARAMS, this.getThemeParams());
        }
        if (!bl || this.isThemeTagDirty()) {
            hashMap.put(FIELD_THEMETAG, this.getThemeTag());
        }
        if (!bl || this.isThemeUrlDirty()) {
            hashMap.put(FIELD_THEMEURL, this.getThemeUrl());
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
        return PSAppUIThemeBase.get(this, n);
    }

    private static Object get(PSAppUIThemeBase pSAppUIThemeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppUIThemeBase.getCreateDate();
            }
            case 1: {
                return pSAppUIThemeBase.getCreateMan();
            }
            case 2: {
                return pSAppUIThemeBase.getCSSStyle();
            }
            case 3: {
                return pSAppUIThemeBase.getMemo();
            }
            case 4: {
                return pSAppUIThemeBase.getOrderValue();
            }
            case 5: {
                return pSAppUIThemeBase.getPSAppUIThemeId();
            }
            case 6: {
                return pSAppUIThemeBase.getPSAppUIThemeName();
            }
            case 7: {
                return pSAppUIThemeBase.getPSSysAppId();
            }
            case 8: {
                return pSAppUIThemeBase.getPSSysAppName();
            }
            case 9: {
                return pSAppUIThemeBase.getThemeDesc();
            }
            case 10: {
                return pSAppUIThemeBase.getThemeParams();
            }
            case 11: {
                return pSAppUIThemeBase.getThemeTag();
            }
            case 12: {
                return pSAppUIThemeBase.getThemeUrl();
            }
            case 13: {
                return pSAppUIThemeBase.getUpdateDate();
            }
            case 14: {
                return pSAppUIThemeBase.getUpdateMan();
            }
            case 15: {
                return pSAppUIThemeBase.getUserCat();
            }
            case 16: {
                return pSAppUIThemeBase.getUserTag();
            }
            case 17: {
                return pSAppUIThemeBase.getUserTag2();
            }
            case 18: {
                return pSAppUIThemeBase.getUserTag3();
            }
            case 19: {
                return pSAppUIThemeBase.getUserTag4();
            }
            case 20: {
                return pSAppUIThemeBase.getValidFlag();
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
        PSAppUIThemeBase.set(this, n, object);
    }

    private static void set(PSAppUIThemeBase pSAppUIThemeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSAppUIThemeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSAppUIThemeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSAppUIThemeBase.setCSSStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSAppUIThemeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSAppUIThemeBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSAppUIThemeBase.setPSAppUIThemeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSAppUIThemeBase.setPSAppUIThemeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSAppUIThemeBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSAppUIThemeBase.setPSSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSAppUIThemeBase.setThemeDesc(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSAppUIThemeBase.setThemeParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSAppUIThemeBase.setThemeTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSAppUIThemeBase.setThemeUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSAppUIThemeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 14: {
                pSAppUIThemeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSAppUIThemeBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSAppUIThemeBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSAppUIThemeBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSAppUIThemeBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSAppUIThemeBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSAppUIThemeBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSAppUIThemeBase.isNull(this, n);
    }

    private static boolean isNull(PSAppUIThemeBase pSAppUIThemeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppUIThemeBase.getCreateDate() == null;
            }
            case 1: {
                return pSAppUIThemeBase.getCreateMan() == null;
            }
            case 2: {
                return pSAppUIThemeBase.getCSSStyle() == null;
            }
            case 3: {
                return pSAppUIThemeBase.getMemo() == null;
            }
            case 4: {
                return pSAppUIThemeBase.getOrderValue() == null;
            }
            case 5: {
                return pSAppUIThemeBase.getPSAppUIThemeId() == null;
            }
            case 6: {
                return pSAppUIThemeBase.getPSAppUIThemeName() == null;
            }
            case 7: {
                return pSAppUIThemeBase.getPSSysAppId() == null;
            }
            case 8: {
                return pSAppUIThemeBase.getPSSysAppName() == null;
            }
            case 9: {
                return pSAppUIThemeBase.getThemeDesc() == null;
            }
            case 10: {
                return pSAppUIThemeBase.getThemeParams() == null;
            }
            case 11: {
                return pSAppUIThemeBase.getThemeTag() == null;
            }
            case 12: {
                return pSAppUIThemeBase.getThemeUrl() == null;
            }
            case 13: {
                return pSAppUIThemeBase.getUpdateDate() == null;
            }
            case 14: {
                return pSAppUIThemeBase.getUpdateMan() == null;
            }
            case 15: {
                return pSAppUIThemeBase.getUserCat() == null;
            }
            case 16: {
                return pSAppUIThemeBase.getUserTag() == null;
            }
            case 17: {
                return pSAppUIThemeBase.getUserTag2() == null;
            }
            case 18: {
                return pSAppUIThemeBase.getUserTag3() == null;
            }
            case 19: {
                return pSAppUIThemeBase.getUserTag4() == null;
            }
            case 20: {
                return pSAppUIThemeBase.getValidFlag() == null;
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
        return PSAppUIThemeBase.contains(this, n);
    }

    private static boolean contains(PSAppUIThemeBase pSAppUIThemeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppUIThemeBase.isCreateDateDirty();
            }
            case 1: {
                return pSAppUIThemeBase.isCreateManDirty();
            }
            case 2: {
                return pSAppUIThemeBase.isCSSStyleDirty();
            }
            case 3: {
                return pSAppUIThemeBase.isMemoDirty();
            }
            case 4: {
                return pSAppUIThemeBase.isOrderValueDirty();
            }
            case 5: {
                return pSAppUIThemeBase.isPSAppUIThemeIdDirty();
            }
            case 6: {
                return pSAppUIThemeBase.isPSAppUIThemeNameDirty();
            }
            case 7: {
                return pSAppUIThemeBase.isPSSysAppIdDirty();
            }
            case 8: {
                return pSAppUIThemeBase.isPSSysAppNameDirty();
            }
            case 9: {
                return pSAppUIThemeBase.isThemeDescDirty();
            }
            case 10: {
                return pSAppUIThemeBase.isThemeParamsDirty();
            }
            case 11: {
                return pSAppUIThemeBase.isThemeTagDirty();
            }
            case 12: {
                return pSAppUIThemeBase.isThemeUrlDirty();
            }
            case 13: {
                return pSAppUIThemeBase.isUpdateDateDirty();
            }
            case 14: {
                return pSAppUIThemeBase.isUpdateManDirty();
            }
            case 15: {
                return pSAppUIThemeBase.isUserCatDirty();
            }
            case 16: {
                return pSAppUIThemeBase.isUserTagDirty();
            }
            case 17: {
                return pSAppUIThemeBase.isUserTag2Dirty();
            }
            case 18: {
                return pSAppUIThemeBase.isUserTag3Dirty();
            }
            case 19: {
                return pSAppUIThemeBase.isUserTag4Dirty();
            }
            case 20: {
                return pSAppUIThemeBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSAppUIThemeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSAppUIThemeBase pSAppUIThemeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSAppUIThemeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSAppUIThemeBase.getJSONValue((Object)pSAppUIThemeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSAppUIThemeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSAppUIThemeBase.getJSONValue((Object)pSAppUIThemeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSAppUIThemeBase.getCSSStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cssstyle", (Object)PSAppUIThemeBase.getJSONValue((Object)pSAppUIThemeBase.getCSSStyle()), (boolean)false);
        }
        if (bl || pSAppUIThemeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSAppUIThemeBase.getJSONValue((Object)pSAppUIThemeBase.getMemo()), (boolean)false);
        }
        if (bl || pSAppUIThemeBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSAppUIThemeBase.getJSONValue((Object)pSAppUIThemeBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSAppUIThemeBase.getPSAppUIThemeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappuithemeid", (Object)PSAppUIThemeBase.getJSONValue((Object)pSAppUIThemeBase.getPSAppUIThemeId()), (boolean)false);
        }
        if (bl || pSAppUIThemeBase.getPSAppUIThemeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappuithemename", (Object)PSAppUIThemeBase.getJSONValue((Object)pSAppUIThemeBase.getPSAppUIThemeName()), (boolean)false);
        }
        if (bl || pSAppUIThemeBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSAppUIThemeBase.getJSONValue((Object)pSAppUIThemeBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSAppUIThemeBase.getPSSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappname", (Object)PSAppUIThemeBase.getJSONValue((Object)pSAppUIThemeBase.getPSSysAppName()), (boolean)false);
        }
        if (bl || pSAppUIThemeBase.getThemeDesc() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"themedesc", (Object)PSAppUIThemeBase.getJSONValue((Object)pSAppUIThemeBase.getThemeDesc()), (boolean)false);
        }
        if (bl || pSAppUIThemeBase.getThemeParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"themeparams", (Object)PSAppUIThemeBase.getJSONValue((Object)pSAppUIThemeBase.getThemeParams()), (boolean)false);
        }
        if (bl || pSAppUIThemeBase.getThemeTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"themetag", (Object)PSAppUIThemeBase.getJSONValue((Object)pSAppUIThemeBase.getThemeTag()), (boolean)false);
        }
        if (bl || pSAppUIThemeBase.getThemeUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"themeurl", (Object)PSAppUIThemeBase.getJSONValue((Object)pSAppUIThemeBase.getThemeUrl()), (boolean)false);
        }
        if (bl || pSAppUIThemeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSAppUIThemeBase.getJSONValue((Object)pSAppUIThemeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSAppUIThemeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSAppUIThemeBase.getJSONValue((Object)pSAppUIThemeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSAppUIThemeBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSAppUIThemeBase.getJSONValue((Object)pSAppUIThemeBase.getUserCat()), (boolean)false);
        }
        if (bl || pSAppUIThemeBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSAppUIThemeBase.getJSONValue((Object)pSAppUIThemeBase.getUserTag()), (boolean)false);
        }
        if (bl || pSAppUIThemeBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSAppUIThemeBase.getJSONValue((Object)pSAppUIThemeBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSAppUIThemeBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSAppUIThemeBase.getJSONValue((Object)pSAppUIThemeBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSAppUIThemeBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSAppUIThemeBase.getJSONValue((Object)pSAppUIThemeBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSAppUIThemeBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSAppUIThemeBase.getJSONValue((Object)pSAppUIThemeBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSAppUIThemeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSAppUIThemeBase pSAppUIThemeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSAppUIThemeBase.getCreateDate() != null) {
            object = pSAppUIThemeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppUIThemeBase.getCreateMan() != null) {
            object = pSAppUIThemeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppUIThemeBase.getCSSStyle() != null) {
            object = pSAppUIThemeBase.getCSSStyle();
            xmlNode.setAttribute(FIELD_CSSSTYLE, object == null ? "" : (String)object);
        }
        if (bl || pSAppUIThemeBase.getMemo() != null) {
            object = pSAppUIThemeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSAppUIThemeBase.getOrderValue() != null) {
            object = pSAppUIThemeBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppUIThemeBase.getPSAppUIThemeId() != null) {
            object = pSAppUIThemeBase.getPSAppUIThemeId();
            xmlNode.setAttribute(FIELD_PSAPPUITHEMEID, object == null ? "" : (String)object);
        }
        if (bl || pSAppUIThemeBase.getPSAppUIThemeName() != null) {
            object = pSAppUIThemeBase.getPSAppUIThemeName();
            xmlNode.setAttribute(FIELD_PSAPPUITHEMENAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppUIThemeBase.getPSSysAppId() != null) {
            object = pSAppUIThemeBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSAppUIThemeBase.getPSSysAppName() != null) {
            object = pSAppUIThemeBase.getPSSysAppName();
            xmlNode.setAttribute(FIELD_PSSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppUIThemeBase.getThemeDesc() != null) {
            object = pSAppUIThemeBase.getThemeDesc();
            xmlNode.setAttribute(FIELD_THEMEDESC, object == null ? "" : (String)object);
        }
        if (bl || pSAppUIThemeBase.getThemeParams() != null) {
            object = pSAppUIThemeBase.getThemeParams();
            xmlNode.setAttribute(FIELD_THEMEPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSAppUIThemeBase.getThemeTag() != null) {
            object = pSAppUIThemeBase.getThemeTag();
            xmlNode.setAttribute(FIELD_THEMETAG, object == null ? "" : (String)object);
        }
        if (bl || pSAppUIThemeBase.getThemeUrl() != null) {
            object = pSAppUIThemeBase.getThemeUrl();
            xmlNode.setAttribute(FIELD_THEMEURL, object == null ? "" : (String)object);
        }
        if (bl || pSAppUIThemeBase.getUpdateDate() != null) {
            object = pSAppUIThemeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppUIThemeBase.getUpdateMan() != null) {
            object = pSAppUIThemeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppUIThemeBase.getUserCat() != null) {
            object = pSAppUIThemeBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSAppUIThemeBase.getUserTag() != null) {
            object = pSAppUIThemeBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSAppUIThemeBase.getUserTag2() != null) {
            object = pSAppUIThemeBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSAppUIThemeBase.getUserTag3() != null) {
            object = pSAppUIThemeBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSAppUIThemeBase.getUserTag4() != null) {
            object = pSAppUIThemeBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSAppUIThemeBase.getValidFlag() != null) {
            object = pSAppUIThemeBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSAppUIThemeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSAppUIThemeBase pSAppUIThemeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSAppUIThemeBase.isCreateDateDirty() && (bl || pSAppUIThemeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSAppUIThemeBase.getCreateDate());
        }
        if (pSAppUIThemeBase.isCreateManDirty() && (bl || pSAppUIThemeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSAppUIThemeBase.getCreateMan());
        }
        if (pSAppUIThemeBase.isCSSStyleDirty() && (bl || pSAppUIThemeBase.getCSSStyle() != null)) {
            iDataObject.set(FIELD_CSSSTYLE, (Object)pSAppUIThemeBase.getCSSStyle());
        }
        if (pSAppUIThemeBase.isMemoDirty() && (bl || pSAppUIThemeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSAppUIThemeBase.getMemo());
        }
        if (pSAppUIThemeBase.isOrderValueDirty() && (bl || pSAppUIThemeBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSAppUIThemeBase.getOrderValue());
        }
        if (pSAppUIThemeBase.isPSAppUIThemeIdDirty() && (bl || pSAppUIThemeBase.getPSAppUIThemeId() != null)) {
            iDataObject.set(FIELD_PSAPPUITHEMEID, (Object)pSAppUIThemeBase.getPSAppUIThemeId());
        }
        if (pSAppUIThemeBase.isPSAppUIThemeNameDirty() && (bl || pSAppUIThemeBase.getPSAppUIThemeName() != null)) {
            iDataObject.set(FIELD_PSAPPUITHEMENAME, (Object)pSAppUIThemeBase.getPSAppUIThemeName());
        }
        if (pSAppUIThemeBase.isPSSysAppIdDirty() && (bl || pSAppUIThemeBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSAppUIThemeBase.getPSSysAppId());
        }
        if (pSAppUIThemeBase.isPSSysAppNameDirty() && (bl || pSAppUIThemeBase.getPSSysAppName() != null)) {
            iDataObject.set(FIELD_PSSYSAPPNAME, (Object)pSAppUIThemeBase.getPSSysAppName());
        }
        if (pSAppUIThemeBase.isThemeDescDirty() && (bl || pSAppUIThemeBase.getThemeDesc() != null)) {
            iDataObject.set(FIELD_THEMEDESC, (Object)pSAppUIThemeBase.getThemeDesc());
        }
        if (pSAppUIThemeBase.isThemeParamsDirty() && (bl || pSAppUIThemeBase.getThemeParams() != null)) {
            iDataObject.set(FIELD_THEMEPARAMS, (Object)pSAppUIThemeBase.getThemeParams());
        }
        if (pSAppUIThemeBase.isThemeTagDirty() && (bl || pSAppUIThemeBase.getThemeTag() != null)) {
            iDataObject.set(FIELD_THEMETAG, (Object)pSAppUIThemeBase.getThemeTag());
        }
        if (pSAppUIThemeBase.isThemeUrlDirty() && (bl || pSAppUIThemeBase.getThemeUrl() != null)) {
            iDataObject.set(FIELD_THEMEURL, (Object)pSAppUIThemeBase.getThemeUrl());
        }
        if (pSAppUIThemeBase.isUpdateDateDirty() && (bl || pSAppUIThemeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSAppUIThemeBase.getUpdateDate());
        }
        if (pSAppUIThemeBase.isUpdateManDirty() && (bl || pSAppUIThemeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSAppUIThemeBase.getUpdateMan());
        }
        if (pSAppUIThemeBase.isUserCatDirty() && (bl || pSAppUIThemeBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSAppUIThemeBase.getUserCat());
        }
        if (pSAppUIThemeBase.isUserTagDirty() && (bl || pSAppUIThemeBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSAppUIThemeBase.getUserTag());
        }
        if (pSAppUIThemeBase.isUserTag2Dirty() && (bl || pSAppUIThemeBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSAppUIThemeBase.getUserTag2());
        }
        if (pSAppUIThemeBase.isUserTag3Dirty() && (bl || pSAppUIThemeBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSAppUIThemeBase.getUserTag3());
        }
        if (pSAppUIThemeBase.isUserTag4Dirty() && (bl || pSAppUIThemeBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSAppUIThemeBase.getUserTag4());
        }
        if (pSAppUIThemeBase.isValidFlagDirty() && (bl || pSAppUIThemeBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSAppUIThemeBase.getValidFlag());
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
        return PSAppUIThemeBase.remove(this, n);
    }

    private static boolean remove(PSAppUIThemeBase pSAppUIThemeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSAppUIThemeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSAppUIThemeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSAppUIThemeBase.resetCSSStyle();
                return true;
            }
            case 3: {
                pSAppUIThemeBase.resetMemo();
                return true;
            }
            case 4: {
                pSAppUIThemeBase.resetOrderValue();
                return true;
            }
            case 5: {
                pSAppUIThemeBase.resetPSAppUIThemeId();
                return true;
            }
            case 6: {
                pSAppUIThemeBase.resetPSAppUIThemeName();
                return true;
            }
            case 7: {
                pSAppUIThemeBase.resetPSSysAppId();
                return true;
            }
            case 8: {
                pSAppUIThemeBase.resetPSSysAppName();
                return true;
            }
            case 9: {
                pSAppUIThemeBase.resetThemeDesc();
                return true;
            }
            case 10: {
                pSAppUIThemeBase.resetThemeParams();
                return true;
            }
            case 11: {
                pSAppUIThemeBase.resetThemeTag();
                return true;
            }
            case 12: {
                pSAppUIThemeBase.resetThemeUrl();
                return true;
            }
            case 13: {
                pSAppUIThemeBase.resetUpdateDate();
                return true;
            }
            case 14: {
                pSAppUIThemeBase.resetUpdateMan();
                return true;
            }
            case 15: {
                pSAppUIThemeBase.resetUserCat();
                return true;
            }
            case 16: {
                pSAppUIThemeBase.resetUserTag();
                return true;
            }
            case 17: {
                pSAppUIThemeBase.resetUserTag2();
                return true;
            }
            case 18: {
                pSAppUIThemeBase.resetUserTag3();
                return true;
            }
            case 19: {
                pSAppUIThemeBase.resetUserTag4();
                return true;
            }
            case 20: {
                pSAppUIThemeBase.resetValidFlag();
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
                pSSysAppService.autoGet((IEntity)pSSysApp);
                this.pssysapp = pSSysApp;
            }
            return this.pssysapp;
        }
    }

    private PSAppUIThemeBase getProxyEntity() {
        return this.proxyPSAppUIThemeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSAppUIThemeBase = null;
        if (iDataObject != null && iDataObject instanceof PSAppUIThemeBase) {
            this.proxyPSAppUIThemeBase = (PSAppUIThemeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppUIThemeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_CSSSTYLE, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_ORDERVALUE, 4);
        fieldIndexMap.put(FIELD_PSAPPUITHEMEID, 5);
        fieldIndexMap.put(FIELD_PSAPPUITHEMENAME, 6);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 7);
        fieldIndexMap.put(FIELD_PSSYSAPPNAME, 8);
        fieldIndexMap.put(FIELD_THEMEDESC, 9);
        fieldIndexMap.put(FIELD_THEMEPARAMS, 10);
        fieldIndexMap.put(FIELD_THEMETAG, 11);
        fieldIndexMap.put(FIELD_THEMEURL, 12);
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

