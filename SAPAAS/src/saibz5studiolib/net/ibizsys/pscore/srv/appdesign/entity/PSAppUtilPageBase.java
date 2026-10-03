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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanel;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppUtilPageBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSAppUtilPageBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PAGEURL = "PAGEURL";
    public static final String FIELD_PSAPPUTILPAGEID = "PSAPPUTILPAGEID";
    public static final String FIELD_PSAPPUTILPAGENAME = "PSAPPUTILPAGENAME";
    public static final String FIELD_PSAPPVIEWID = "PSAPPVIEWID";
    public static final String FIELD_PSAPPVIEWNAME = "PSAPPVIEWNAME";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String FIELD_PSSYSVIEWPANELID = "PSSYSVIEWPANELID";
    public static final String FIELD_PSSYSVIEWPANELNAME = "PSSYSVIEWPANELNAME";
    public static final String FIELD_TARGETTYPE = "TARGETTYPE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_UTILPARAMS = "UTILPARAMS";
    public static final String FIELD_UTILTAG = "UTILTAG";
    public static final String FIELD_UTILTYPE = "UTILTYPE";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PAGEURL = 4;
    private static final int INDEX_PSAPPUTILPAGEID = 5;
    private static final int INDEX_PSAPPUTILPAGENAME = 6;
    private static final int INDEX_PSAPPVIEWID = 7;
    private static final int INDEX_PSAPPVIEWNAME = 8;
    private static final int INDEX_PSSYSAPPID = 9;
    private static final int INDEX_PSSYSAPPNAME = 10;
    private static final int INDEX_PSSYSVIEWPANELID = 11;
    private static final int INDEX_PSSYSVIEWPANELNAME = 12;
    private static final int INDEX_TARGETTYPE = 13;
    private static final int INDEX_UPDATEDATE = 14;
    private static final int INDEX_UPDATEMAN = 15;
    private static final int INDEX_USERCAT = 16;
    private static final int INDEX_USERTAG = 17;
    private static final int INDEX_USERTAG2 = 18;
    private static final int INDEX_USERTAG3 = 19;
    private static final int INDEX_USERTAG4 = 20;
    private static final int INDEX_UTILPARAMS = 21;
    private static final int INDEX_UTILTAG = 22;
    private static final int INDEX_UTILTYPE = 23;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSAppUtilPageBase proxyPSAppUtilPageBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pageurlDirtyFlag = false;
    private boolean psapputilpageidDirtyFlag = false;
    private boolean psapputilpagenameDirtyFlag = false;
    private boolean psappviewidDirtyFlag = false;
    private boolean psappviewnameDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean pssysappnameDirtyFlag = false;
    private boolean pssysviewpanelidDirtyFlag = false;
    private boolean pssysviewpanelnameDirtyFlag = false;
    private boolean targettypeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean utilparamsDirtyFlag = false;
    private boolean utiltagDirtyFlag = false;
    private boolean utiltypeDirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="pageurl")
    private String pageurl;
    @Column(name="psapputilpageid")
    private String psapputilpageid;
    @Column(name="psapputilpagename")
    private String psapputilpagename;
    @Column(name="psappviewid")
    private String psappviewid;
    @Column(name="psappviewname")
    private String psappviewname;
    @Column(name="pssysappid")
    private String pssysappid;
    @Column(name="pssysappname")
    private String pssysappname;
    @Column(name="pssysviewpanelid")
    private String pssysviewpanelid;
    @Column(name="pssysviewpanelname")
    private String pssysviewpanelname;
    @Column(name="targettype")
    private String targettype;
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
    @Column(name="utilparams")
    private String utilparams;
    @Column(name="utiltag")
    private String utiltag;
    @Column(name="utiltype")
    private String utiltype;
    private Integer objPSAppViewLock = new Integer(1);
    private PSAppView psappview = null;
    private Integer objPSSysAppLock = new Integer(1);
    private PSSysApp pssysapp = null;
    private Integer objPSSysViewPanelLock = new Integer(1);
    private PSSysViewPanel pssysviewpanel = null;

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

    public void setPSAppUtilPageId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppUtilPageId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psapputilpageid = string;
        this.psapputilpageidDirtyFlag = true;
    }

    public String getPSAppUtilPageId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppUtilPageId();
        }
        return this.psapputilpageid;
    }

    public boolean isPSAppUtilPageIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppUtilPageIdDirty();
        }
        return this.psapputilpageidDirtyFlag;
    }

    public void resetPSAppUtilPageId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppUtilPageId();
            return;
        }
        this.psapputilpageidDirtyFlag = false;
        this.psapputilpageid = null;
    }

    public void setPSAppUtilPageName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppUtilPageName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psapputilpagename = string;
        this.psapputilpagenameDirtyFlag = true;
    }

    public String getPSAppUtilPageName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppUtilPageName();
        }
        return this.psapputilpagename;
    }

    public boolean isPSAppUtilPageNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppUtilPageNameDirty();
        }
        return this.psapputilpagenameDirtyFlag;
    }

    public void resetPSAppUtilPageName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppUtilPageName();
            return;
        }
        this.psapputilpagenameDirtyFlag = false;
        this.psapputilpagename = null;
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

    public void setPSSysViewPanelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysViewPanelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysviewpanelid = string;
        this.pssysviewpanelidDirtyFlag = true;
    }

    public String getPSSysViewPanelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewPanelId();
        }
        return this.pssysviewpanelid;
    }

    public boolean isPSSysViewPanelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysViewPanelIdDirty();
        }
        return this.pssysviewpanelidDirtyFlag;
    }

    public void resetPSSysViewPanelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysViewPanelId();
            return;
        }
        this.pssysviewpanelidDirtyFlag = false;
        this.pssysviewpanelid = null;
    }

    public void setPSSysViewPanelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysViewPanelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysviewpanelname = string;
        this.pssysviewpanelnameDirtyFlag = true;
    }

    public String getPSSysViewPanelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewPanelName();
        }
        return this.pssysviewpanelname;
    }

    public boolean isPSSysViewPanelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysViewPanelNameDirty();
        }
        return this.pssysviewpanelnameDirtyFlag;
    }

    public void resetPSSysViewPanelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysViewPanelName();
            return;
        }
        this.pssysviewpanelnameDirtyFlag = false;
        this.pssysviewpanelname = null;
    }

    public void setTargetType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTargetType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.targettype = string;
        this.targettypeDirtyFlag = true;
    }

    public String getTargetType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTargetType();
        }
        return this.targettype;
    }

    public boolean isTargetTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTargetTypeDirty();
        }
        return this.targettypeDirtyFlag;
    }

    public void resetTargetType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTargetType();
            return;
        }
        this.targettypeDirtyFlag = false;
        this.targettype = null;
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

    public void setUtilParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilparams = string;
        this.utilparamsDirtyFlag = true;
    }

    public String getUtilParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilParams();
        }
        return this.utilparams;
    }

    public boolean isUtilParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilParamsDirty();
        }
        return this.utilparamsDirtyFlag;
    }

    public void resetUtilParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilParams();
            return;
        }
        this.utilparamsDirtyFlag = false;
        this.utilparams = null;
    }

    public void setUtilTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utiltag = string;
        this.utiltagDirtyFlag = true;
    }

    public String getUtilTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilTag();
        }
        return this.utiltag;
    }

    public boolean isUtilTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilTagDirty();
        }
        return this.utiltagDirtyFlag;
    }

    public void resetUtilTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilTag();
            return;
        }
        this.utiltagDirtyFlag = false;
        this.utiltag = null;
    }

    public void setUtilType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utiltype = string;
        this.utiltypeDirtyFlag = true;
    }

    public String getUtilType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilType();
        }
        return this.utiltype;
    }

    public boolean isUtilTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilTypeDirty();
        }
        return this.utiltypeDirtyFlag;
    }

    public void resetUtilType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilType();
            return;
        }
        this.utiltypeDirtyFlag = false;
        this.utiltype = null;
    }

    protected void onReset() {
        PSAppUtilPageBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSAppUtilPageBase pSAppUtilPageBase) {
        pSAppUtilPageBase.resetCodeName();
        pSAppUtilPageBase.resetCreateDate();
        pSAppUtilPageBase.resetCreateMan();
        pSAppUtilPageBase.resetMemo();
        pSAppUtilPageBase.resetPageUrl();
        pSAppUtilPageBase.resetPSAppUtilPageId();
        pSAppUtilPageBase.resetPSAppUtilPageName();
        pSAppUtilPageBase.resetPSAppViewId();
        pSAppUtilPageBase.resetPSAppViewName();
        pSAppUtilPageBase.resetPSSysAppId();
        pSAppUtilPageBase.resetPSSysAppName();
        pSAppUtilPageBase.resetPSSysViewPanelId();
        pSAppUtilPageBase.resetPSSysViewPanelName();
        pSAppUtilPageBase.resetTargetType();
        pSAppUtilPageBase.resetUpdateDate();
        pSAppUtilPageBase.resetUpdateMan();
        pSAppUtilPageBase.resetUserCat();
        pSAppUtilPageBase.resetUserTag();
        pSAppUtilPageBase.resetUserTag2();
        pSAppUtilPageBase.resetUserTag3();
        pSAppUtilPageBase.resetUserTag4();
        pSAppUtilPageBase.resetUtilParams();
        pSAppUtilPageBase.resetUtilTag();
        pSAppUtilPageBase.resetUtilType();
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
        if (!bl || this.isPageUrlDirty()) {
            hashMap.put(FIELD_PAGEURL, this.getPageUrl());
        }
        if (!bl || this.isPSAppUtilPageIdDirty()) {
            hashMap.put(FIELD_PSAPPUTILPAGEID, this.getPSAppUtilPageId());
        }
        if (!bl || this.isPSAppUtilPageNameDirty()) {
            hashMap.put(FIELD_PSAPPUTILPAGENAME, this.getPSAppUtilPageName());
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
        if (!bl || this.isPSSysViewPanelIdDirty()) {
            hashMap.put(FIELD_PSSYSVIEWPANELID, this.getPSSysViewPanelId());
        }
        if (!bl || this.isPSSysViewPanelNameDirty()) {
            hashMap.put(FIELD_PSSYSVIEWPANELNAME, this.getPSSysViewPanelName());
        }
        if (!bl || this.isTargetTypeDirty()) {
            hashMap.put(FIELD_TARGETTYPE, this.getTargetType());
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
        if (!bl || this.isUtilParamsDirty()) {
            hashMap.put(FIELD_UTILPARAMS, this.getUtilParams());
        }
        if (!bl || this.isUtilTagDirty()) {
            hashMap.put(FIELD_UTILTAG, this.getUtilTag());
        }
        if (!bl || this.isUtilTypeDirty()) {
            hashMap.put(FIELD_UTILTYPE, this.getUtilType());
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
        return PSAppUtilPageBase.get(this, n);
    }

    private static Object get(PSAppUtilPageBase pSAppUtilPageBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppUtilPageBase.getCodeName();
            }
            case 1: {
                return pSAppUtilPageBase.getCreateDate();
            }
            case 2: {
                return pSAppUtilPageBase.getCreateMan();
            }
            case 3: {
                return pSAppUtilPageBase.getMemo();
            }
            case 4: {
                return pSAppUtilPageBase.getPageUrl();
            }
            case 5: {
                return pSAppUtilPageBase.getPSAppUtilPageId();
            }
            case 6: {
                return pSAppUtilPageBase.getPSAppUtilPageName();
            }
            case 7: {
                return pSAppUtilPageBase.getPSAppViewId();
            }
            case 8: {
                return pSAppUtilPageBase.getPSAppViewName();
            }
            case 9: {
                return pSAppUtilPageBase.getPSSysAppId();
            }
            case 10: {
                return pSAppUtilPageBase.getPSSysAppName();
            }
            case 11: {
                return pSAppUtilPageBase.getPSSysViewPanelId();
            }
            case 12: {
                return pSAppUtilPageBase.getPSSysViewPanelName();
            }
            case 13: {
                return pSAppUtilPageBase.getTargetType();
            }
            case 14: {
                return pSAppUtilPageBase.getUpdateDate();
            }
            case 15: {
                return pSAppUtilPageBase.getUpdateMan();
            }
            case 16: {
                return pSAppUtilPageBase.getUserCat();
            }
            case 17: {
                return pSAppUtilPageBase.getUserTag();
            }
            case 18: {
                return pSAppUtilPageBase.getUserTag2();
            }
            case 19: {
                return pSAppUtilPageBase.getUserTag3();
            }
            case 20: {
                return pSAppUtilPageBase.getUserTag4();
            }
            case 21: {
                return pSAppUtilPageBase.getUtilParams();
            }
            case 22: {
                return pSAppUtilPageBase.getUtilTag();
            }
            case 23: {
                return pSAppUtilPageBase.getUtilType();
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
        PSAppUtilPageBase.set(this, n, object);
    }

    private static void set(PSAppUtilPageBase pSAppUtilPageBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSAppUtilPageBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSAppUtilPageBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSAppUtilPageBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSAppUtilPageBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSAppUtilPageBase.setPageUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSAppUtilPageBase.setPSAppUtilPageId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSAppUtilPageBase.setPSAppUtilPageName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSAppUtilPageBase.setPSAppViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSAppUtilPageBase.setPSAppViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSAppUtilPageBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSAppUtilPageBase.setPSSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSAppUtilPageBase.setPSSysViewPanelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSAppUtilPageBase.setPSSysViewPanelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSAppUtilPageBase.setTargetType(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSAppUtilPageBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 15: {
                pSAppUtilPageBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSAppUtilPageBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSAppUtilPageBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSAppUtilPageBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSAppUtilPageBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSAppUtilPageBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSAppUtilPageBase.setUtilParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSAppUtilPageBase.setUtilTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSAppUtilPageBase.setUtilType(DataObject.getStringValue((Object)object));
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
        return PSAppUtilPageBase.isNull(this, n);
    }

    private static boolean isNull(PSAppUtilPageBase pSAppUtilPageBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppUtilPageBase.getCodeName() == null;
            }
            case 1: {
                return pSAppUtilPageBase.getCreateDate() == null;
            }
            case 2: {
                return pSAppUtilPageBase.getCreateMan() == null;
            }
            case 3: {
                return pSAppUtilPageBase.getMemo() == null;
            }
            case 4: {
                return pSAppUtilPageBase.getPageUrl() == null;
            }
            case 5: {
                return pSAppUtilPageBase.getPSAppUtilPageId() == null;
            }
            case 6: {
                return pSAppUtilPageBase.getPSAppUtilPageName() == null;
            }
            case 7: {
                return pSAppUtilPageBase.getPSAppViewId() == null;
            }
            case 8: {
                return pSAppUtilPageBase.getPSAppViewName() == null;
            }
            case 9: {
                return pSAppUtilPageBase.getPSSysAppId() == null;
            }
            case 10: {
                return pSAppUtilPageBase.getPSSysAppName() == null;
            }
            case 11: {
                return pSAppUtilPageBase.getPSSysViewPanelId() == null;
            }
            case 12: {
                return pSAppUtilPageBase.getPSSysViewPanelName() == null;
            }
            case 13: {
                return pSAppUtilPageBase.getTargetType() == null;
            }
            case 14: {
                return pSAppUtilPageBase.getUpdateDate() == null;
            }
            case 15: {
                return pSAppUtilPageBase.getUpdateMan() == null;
            }
            case 16: {
                return pSAppUtilPageBase.getUserCat() == null;
            }
            case 17: {
                return pSAppUtilPageBase.getUserTag() == null;
            }
            case 18: {
                return pSAppUtilPageBase.getUserTag2() == null;
            }
            case 19: {
                return pSAppUtilPageBase.getUserTag3() == null;
            }
            case 20: {
                return pSAppUtilPageBase.getUserTag4() == null;
            }
            case 21: {
                return pSAppUtilPageBase.getUtilParams() == null;
            }
            case 22: {
                return pSAppUtilPageBase.getUtilTag() == null;
            }
            case 23: {
                return pSAppUtilPageBase.getUtilType() == null;
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
        return PSAppUtilPageBase.contains(this, n);
    }

    private static boolean contains(PSAppUtilPageBase pSAppUtilPageBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppUtilPageBase.isCodeNameDirty();
            }
            case 1: {
                return pSAppUtilPageBase.isCreateDateDirty();
            }
            case 2: {
                return pSAppUtilPageBase.isCreateManDirty();
            }
            case 3: {
                return pSAppUtilPageBase.isMemoDirty();
            }
            case 4: {
                return pSAppUtilPageBase.isPageUrlDirty();
            }
            case 5: {
                return pSAppUtilPageBase.isPSAppUtilPageIdDirty();
            }
            case 6: {
                return pSAppUtilPageBase.isPSAppUtilPageNameDirty();
            }
            case 7: {
                return pSAppUtilPageBase.isPSAppViewIdDirty();
            }
            case 8: {
                return pSAppUtilPageBase.isPSAppViewNameDirty();
            }
            case 9: {
                return pSAppUtilPageBase.isPSSysAppIdDirty();
            }
            case 10: {
                return pSAppUtilPageBase.isPSSysAppNameDirty();
            }
            case 11: {
                return pSAppUtilPageBase.isPSSysViewPanelIdDirty();
            }
            case 12: {
                return pSAppUtilPageBase.isPSSysViewPanelNameDirty();
            }
            case 13: {
                return pSAppUtilPageBase.isTargetTypeDirty();
            }
            case 14: {
                return pSAppUtilPageBase.isUpdateDateDirty();
            }
            case 15: {
                return pSAppUtilPageBase.isUpdateManDirty();
            }
            case 16: {
                return pSAppUtilPageBase.isUserCatDirty();
            }
            case 17: {
                return pSAppUtilPageBase.isUserTagDirty();
            }
            case 18: {
                return pSAppUtilPageBase.isUserTag2Dirty();
            }
            case 19: {
                return pSAppUtilPageBase.isUserTag3Dirty();
            }
            case 20: {
                return pSAppUtilPageBase.isUserTag4Dirty();
            }
            case 21: {
                return pSAppUtilPageBase.isUtilParamsDirty();
            }
            case 22: {
                return pSAppUtilPageBase.isUtilTagDirty();
            }
            case 23: {
                return pSAppUtilPageBase.isUtilTypeDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSAppUtilPageBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSAppUtilPageBase pSAppUtilPageBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSAppUtilPageBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSAppUtilPageBase.getJSONValue((Object)pSAppUtilPageBase.getCodeName()), (boolean)false);
        }
        if (bl || pSAppUtilPageBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSAppUtilPageBase.getJSONValue((Object)pSAppUtilPageBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSAppUtilPageBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSAppUtilPageBase.getJSONValue((Object)pSAppUtilPageBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSAppUtilPageBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSAppUtilPageBase.getJSONValue((Object)pSAppUtilPageBase.getMemo()), (boolean)false);
        }
        if (bl || pSAppUtilPageBase.getPageUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pageurl", (Object)PSAppUtilPageBase.getJSONValue((Object)pSAppUtilPageBase.getPageUrl()), (boolean)false);
        }
        if (bl || pSAppUtilPageBase.getPSAppUtilPageId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psapputilpageid", (Object)PSAppUtilPageBase.getJSONValue((Object)pSAppUtilPageBase.getPSAppUtilPageId()), (boolean)false);
        }
        if (bl || pSAppUtilPageBase.getPSAppUtilPageName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psapputilpagename", (Object)PSAppUtilPageBase.getJSONValue((Object)pSAppUtilPageBase.getPSAppUtilPageName()), (boolean)false);
        }
        if (bl || pSAppUtilPageBase.getPSAppViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappviewid", (Object)PSAppUtilPageBase.getJSONValue((Object)pSAppUtilPageBase.getPSAppViewId()), (boolean)false);
        }
        if (bl || pSAppUtilPageBase.getPSAppViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappviewname", (Object)PSAppUtilPageBase.getJSONValue((Object)pSAppUtilPageBase.getPSAppViewName()), (boolean)false);
        }
        if (bl || pSAppUtilPageBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSAppUtilPageBase.getJSONValue((Object)pSAppUtilPageBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSAppUtilPageBase.getPSSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappname", (Object)PSAppUtilPageBase.getJSONValue((Object)pSAppUtilPageBase.getPSSysAppName()), (boolean)false);
        }
        if (bl || pSAppUtilPageBase.getPSSysViewPanelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelid", (Object)PSAppUtilPageBase.getJSONValue((Object)pSAppUtilPageBase.getPSSysViewPanelId()), (boolean)false);
        }
        if (bl || pSAppUtilPageBase.getPSSysViewPanelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelname", (Object)PSAppUtilPageBase.getJSONValue((Object)pSAppUtilPageBase.getPSSysViewPanelName()), (boolean)false);
        }
        if (bl || pSAppUtilPageBase.getTargetType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"targettype", (Object)PSAppUtilPageBase.getJSONValue((Object)pSAppUtilPageBase.getTargetType()), (boolean)false);
        }
        if (bl || pSAppUtilPageBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSAppUtilPageBase.getJSONValue((Object)pSAppUtilPageBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSAppUtilPageBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSAppUtilPageBase.getJSONValue((Object)pSAppUtilPageBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSAppUtilPageBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSAppUtilPageBase.getJSONValue((Object)pSAppUtilPageBase.getUserCat()), (boolean)false);
        }
        if (bl || pSAppUtilPageBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSAppUtilPageBase.getJSONValue((Object)pSAppUtilPageBase.getUserTag()), (boolean)false);
        }
        if (bl || pSAppUtilPageBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSAppUtilPageBase.getJSONValue((Object)pSAppUtilPageBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSAppUtilPageBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSAppUtilPageBase.getJSONValue((Object)pSAppUtilPageBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSAppUtilPageBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSAppUtilPageBase.getJSONValue((Object)pSAppUtilPageBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSAppUtilPageBase.getUtilParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilparams", (Object)PSAppUtilPageBase.getJSONValue((Object)pSAppUtilPageBase.getUtilParams()), (boolean)false);
        }
        if (bl || pSAppUtilPageBase.getUtilTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utiltag", (Object)PSAppUtilPageBase.getJSONValue((Object)pSAppUtilPageBase.getUtilTag()), (boolean)false);
        }
        if (bl || pSAppUtilPageBase.getUtilType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utiltype", (Object)PSAppUtilPageBase.getJSONValue((Object)pSAppUtilPageBase.getUtilType()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSAppUtilPageBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSAppUtilPageBase pSAppUtilPageBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSAppUtilPageBase.getCodeName() != null) {
            object = pSAppUtilPageBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilPageBase.getCreateDate() != null) {
            object = pSAppUtilPageBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppUtilPageBase.getCreateMan() != null) {
            object = pSAppUtilPageBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilPageBase.getMemo() != null) {
            object = pSAppUtilPageBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilPageBase.getPageUrl() != null) {
            object = pSAppUtilPageBase.getPageUrl();
            xmlNode.setAttribute(FIELD_PAGEURL, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilPageBase.getPSAppUtilPageId() != null) {
            object = pSAppUtilPageBase.getPSAppUtilPageId();
            xmlNode.setAttribute(FIELD_PSAPPUTILPAGEID, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilPageBase.getPSAppUtilPageName() != null) {
            object = pSAppUtilPageBase.getPSAppUtilPageName();
            xmlNode.setAttribute(FIELD_PSAPPUTILPAGENAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilPageBase.getPSAppViewId() != null) {
            object = pSAppUtilPageBase.getPSAppViewId();
            xmlNode.setAttribute(FIELD_PSAPPVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilPageBase.getPSAppViewName() != null) {
            object = pSAppUtilPageBase.getPSAppViewName();
            xmlNode.setAttribute(FIELD_PSAPPVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilPageBase.getPSSysAppId() != null) {
            object = pSAppUtilPageBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilPageBase.getPSSysAppName() != null) {
            object = pSAppUtilPageBase.getPSSysAppName();
            xmlNode.setAttribute(FIELD_PSSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilPageBase.getPSSysViewPanelId() != null) {
            object = pSAppUtilPageBase.getPSSysViewPanelId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELID, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilPageBase.getPSSysViewPanelName() != null) {
            object = pSAppUtilPageBase.getPSSysViewPanelName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilPageBase.getTargetType() != null) {
            object = pSAppUtilPageBase.getTargetType();
            xmlNode.setAttribute(FIELD_TARGETTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilPageBase.getUpdateDate() != null) {
            object = pSAppUtilPageBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppUtilPageBase.getUpdateMan() != null) {
            object = pSAppUtilPageBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilPageBase.getUserCat() != null) {
            object = pSAppUtilPageBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilPageBase.getUserTag() != null) {
            object = pSAppUtilPageBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilPageBase.getUserTag2() != null) {
            object = pSAppUtilPageBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilPageBase.getUserTag3() != null) {
            object = pSAppUtilPageBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilPageBase.getUserTag4() != null) {
            object = pSAppUtilPageBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilPageBase.getUtilParams() != null) {
            object = pSAppUtilPageBase.getUtilParams();
            xmlNode.setAttribute(FIELD_UTILPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilPageBase.getUtilTag() != null) {
            object = pSAppUtilPageBase.getUtilTag();
            xmlNode.setAttribute(FIELD_UTILTAG, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilPageBase.getUtilType() != null) {
            object = pSAppUtilPageBase.getUtilType();
            xmlNode.setAttribute(FIELD_UTILTYPE, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSAppUtilPageBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSAppUtilPageBase pSAppUtilPageBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSAppUtilPageBase.isCodeNameDirty() && (bl || pSAppUtilPageBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSAppUtilPageBase.getCodeName());
        }
        if (pSAppUtilPageBase.isCreateDateDirty() && (bl || pSAppUtilPageBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSAppUtilPageBase.getCreateDate());
        }
        if (pSAppUtilPageBase.isCreateManDirty() && (bl || pSAppUtilPageBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSAppUtilPageBase.getCreateMan());
        }
        if (pSAppUtilPageBase.isMemoDirty() && (bl || pSAppUtilPageBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSAppUtilPageBase.getMemo());
        }
        if (pSAppUtilPageBase.isPageUrlDirty() && (bl || pSAppUtilPageBase.getPageUrl() != null)) {
            iDataObject.set(FIELD_PAGEURL, (Object)pSAppUtilPageBase.getPageUrl());
        }
        if (pSAppUtilPageBase.isPSAppUtilPageIdDirty() && (bl || pSAppUtilPageBase.getPSAppUtilPageId() != null)) {
            iDataObject.set(FIELD_PSAPPUTILPAGEID, (Object)pSAppUtilPageBase.getPSAppUtilPageId());
        }
        if (pSAppUtilPageBase.isPSAppUtilPageNameDirty() && (bl || pSAppUtilPageBase.getPSAppUtilPageName() != null)) {
            iDataObject.set(FIELD_PSAPPUTILPAGENAME, (Object)pSAppUtilPageBase.getPSAppUtilPageName());
        }
        if (pSAppUtilPageBase.isPSAppViewIdDirty() && (bl || pSAppUtilPageBase.getPSAppViewId() != null)) {
            iDataObject.set(FIELD_PSAPPVIEWID, (Object)pSAppUtilPageBase.getPSAppViewId());
        }
        if (pSAppUtilPageBase.isPSAppViewNameDirty() && (bl || pSAppUtilPageBase.getPSAppViewName() != null)) {
            iDataObject.set(FIELD_PSAPPVIEWNAME, (Object)pSAppUtilPageBase.getPSAppViewName());
        }
        if (pSAppUtilPageBase.isPSSysAppIdDirty() && (bl || pSAppUtilPageBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSAppUtilPageBase.getPSSysAppId());
        }
        if (pSAppUtilPageBase.isPSSysAppNameDirty() && (bl || pSAppUtilPageBase.getPSSysAppName() != null)) {
            iDataObject.set(FIELD_PSSYSAPPNAME, (Object)pSAppUtilPageBase.getPSSysAppName());
        }
        if (pSAppUtilPageBase.isPSSysViewPanelIdDirty() && (bl || pSAppUtilPageBase.getPSSysViewPanelId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELID, (Object)pSAppUtilPageBase.getPSSysViewPanelId());
        }
        if (pSAppUtilPageBase.isPSSysViewPanelNameDirty() && (bl || pSAppUtilPageBase.getPSSysViewPanelName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELNAME, (Object)pSAppUtilPageBase.getPSSysViewPanelName());
        }
        if (pSAppUtilPageBase.isTargetTypeDirty() && (bl || pSAppUtilPageBase.getTargetType() != null)) {
            iDataObject.set(FIELD_TARGETTYPE, (Object)pSAppUtilPageBase.getTargetType());
        }
        if (pSAppUtilPageBase.isUpdateDateDirty() && (bl || pSAppUtilPageBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSAppUtilPageBase.getUpdateDate());
        }
        if (pSAppUtilPageBase.isUpdateManDirty() && (bl || pSAppUtilPageBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSAppUtilPageBase.getUpdateMan());
        }
        if (pSAppUtilPageBase.isUserCatDirty() && (bl || pSAppUtilPageBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSAppUtilPageBase.getUserCat());
        }
        if (pSAppUtilPageBase.isUserTagDirty() && (bl || pSAppUtilPageBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSAppUtilPageBase.getUserTag());
        }
        if (pSAppUtilPageBase.isUserTag2Dirty() && (bl || pSAppUtilPageBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSAppUtilPageBase.getUserTag2());
        }
        if (pSAppUtilPageBase.isUserTag3Dirty() && (bl || pSAppUtilPageBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSAppUtilPageBase.getUserTag3());
        }
        if (pSAppUtilPageBase.isUserTag4Dirty() && (bl || pSAppUtilPageBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSAppUtilPageBase.getUserTag4());
        }
        if (pSAppUtilPageBase.isUtilParamsDirty() && (bl || pSAppUtilPageBase.getUtilParams() != null)) {
            iDataObject.set(FIELD_UTILPARAMS, (Object)pSAppUtilPageBase.getUtilParams());
        }
        if (pSAppUtilPageBase.isUtilTagDirty() && (bl || pSAppUtilPageBase.getUtilTag() != null)) {
            iDataObject.set(FIELD_UTILTAG, (Object)pSAppUtilPageBase.getUtilTag());
        }
        if (pSAppUtilPageBase.isUtilTypeDirty() && (bl || pSAppUtilPageBase.getUtilType() != null)) {
            iDataObject.set(FIELD_UTILTYPE, (Object)pSAppUtilPageBase.getUtilType());
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
        return PSAppUtilPageBase.remove(this, n);
    }

    private static boolean remove(PSAppUtilPageBase pSAppUtilPageBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSAppUtilPageBase.resetCodeName();
                return true;
            }
            case 1: {
                pSAppUtilPageBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSAppUtilPageBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSAppUtilPageBase.resetMemo();
                return true;
            }
            case 4: {
                pSAppUtilPageBase.resetPageUrl();
                return true;
            }
            case 5: {
                pSAppUtilPageBase.resetPSAppUtilPageId();
                return true;
            }
            case 6: {
                pSAppUtilPageBase.resetPSAppUtilPageName();
                return true;
            }
            case 7: {
                pSAppUtilPageBase.resetPSAppViewId();
                return true;
            }
            case 8: {
                pSAppUtilPageBase.resetPSAppViewName();
                return true;
            }
            case 9: {
                pSAppUtilPageBase.resetPSSysAppId();
                return true;
            }
            case 10: {
                pSAppUtilPageBase.resetPSSysAppName();
                return true;
            }
            case 11: {
                pSAppUtilPageBase.resetPSSysViewPanelId();
                return true;
            }
            case 12: {
                pSAppUtilPageBase.resetPSSysViewPanelName();
                return true;
            }
            case 13: {
                pSAppUtilPageBase.resetTargetType();
                return true;
            }
            case 14: {
                pSAppUtilPageBase.resetUpdateDate();
                return true;
            }
            case 15: {
                pSAppUtilPageBase.resetUpdateMan();
                return true;
            }
            case 16: {
                pSAppUtilPageBase.resetUserCat();
                return true;
            }
            case 17: {
                pSAppUtilPageBase.resetUserTag();
                return true;
            }
            case 18: {
                pSAppUtilPageBase.resetUserTag2();
                return true;
            }
            case 19: {
                pSAppUtilPageBase.resetUserTag3();
                return true;
            }
            case 20: {
                pSAppUtilPageBase.resetUserTag4();
                return true;
            }
            case 21: {
                pSAppUtilPageBase.resetUtilParams();
                return true;
            }
            case 22: {
                pSAppUtilPageBase.resetUtilTag();
                return true;
            }
            case 23: {
                pSAppUtilPageBase.resetUtilType();
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
    public PSSysViewPanel getPSSysViewPanel() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewPanel();
        }
        if (this.getPSSysViewPanelId() == null) {
            return null;
        }
        Integer n = this.objPSSysViewPanelLock;
        synchronized (n) {
            if (this.pssysviewpanel != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysViewPanelId(), (Object)this.pssysviewpanel.getPSSysViewPanelId()) != 0L) {
                this.pssysviewpanel = null;
            }
            if (this.pssysviewpanel == null) {
                PSSysViewPanel pSSysViewPanel = new PSSysViewPanel();
                pSSysViewPanel.setPSSysViewPanelId(this.getPSSysViewPanelId());
                PSSysViewPanelService pSSysViewPanelService = (PSSysViewPanelService)ServiceGlobal.getService(PSSysViewPanelService.class, (SessionFactory)this.getSessionFactory());
                pSSysViewPanelService.autoGet(pSSysViewPanel);
                this.pssysviewpanel = pSSysViewPanel;
            }
            return this.pssysviewpanel;
        }
    }

    private PSAppUtilPageBase getProxyEntity() {
        return this.proxyPSAppUtilPageBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSAppUtilPageBase = null;
        if (iDataObject != null && iDataObject instanceof PSAppUtilPageBase) {
            this.proxyPSAppUtilPageBase = (PSAppUtilPageBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppUtilPageService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PAGEURL, 4);
        fieldIndexMap.put(FIELD_PSAPPUTILPAGEID, 5);
        fieldIndexMap.put(FIELD_PSAPPUTILPAGENAME, 6);
        fieldIndexMap.put(FIELD_PSAPPVIEWID, 7);
        fieldIndexMap.put(FIELD_PSAPPVIEWNAME, 8);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 9);
        fieldIndexMap.put(FIELD_PSSYSAPPNAME, 10);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELID, 11);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELNAME, 12);
        fieldIndexMap.put(FIELD_TARGETTYPE, 13);
        fieldIndexMap.put(FIELD_UPDATEDATE, 14);
        fieldIndexMap.put(FIELD_UPDATEMAN, 15);
        fieldIndexMap.put(FIELD_USERCAT, 16);
        fieldIndexMap.put(FIELD_USERTAG, 17);
        fieldIndexMap.put(FIELD_USERTAG2, 18);
        fieldIndexMap.put(FIELD_USERTAG3, 19);
        fieldIndexMap.put(FIELD_USERTAG4, 20);
        fieldIndexMap.put(FIELD_UTILPARAMS, 21);
        fieldIndexMap.put(FIELD_UTILTAG, 22);
        fieldIndexMap.put(FIELD_UTILTYPE, 23);
    }
}

