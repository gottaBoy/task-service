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
package net.ibizsys.pscore.srv.wxdesign.entity;

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
import net.ibizsys.pscore.srv.config.entity.PSSysResource;
import net.ibizsys.pscore.srv.config.service.PSSysResourceService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService;
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXAccount;
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXLogic;
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXMenu;
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXMenuFunc;
import net.ibizsys.pscore.srv.wxdesign.service.PSWXAccountService;
import net.ibizsys.pscore.srv.wxdesign.service.PSWXLogicService;
import net.ibizsys.pscore.srv.wxdesign.service.PSWXMenuFuncService;
import net.ibizsys.pscore.srv.wxdesign.service.PSWXMenuService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSWXEntAppBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSWXEntAppBase.class);
    public static final String FIELD_APPTYPE = "APPTYPE";
    public static final String FIELD_APPURL = "APPURL";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String FIELD_PSSYSRESOURCEID = "PSSYSRESOURCEID";
    public static final String FIELD_PSSYSRESOURCENAME = "PSSYSRESOURCENAME";
    public static final String FIELD_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String FIELD_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String FIELD_PSWXACCOUNTID = "PSWXACCOUNTID";
    public static final String FIELD_PSWXACCOUNTNAME = "PSWXACCOUNTNAME";
    public static final String FIELD_PSWXENTAPPID = "PSWXENTAPPID";
    public static final String FIELD_PSWXENTAPPNAME = "PSWXENTAPPNAME";
    public static final String FIELD_PSWXLOGICSCNT = "PSWXLOGICSCNT";
    public static final String FIELD_PSWXMENUFUNCSCNT = "PSWXMENUFUNCSCNT";
    public static final String FIELD_PSWXMENUSCNT = "PSWXMENUSCNT";
    public static final String FIELD_REPENTERFLAG = "REPENTERFLAG";
    public static final String FIELD_REPLOCATIONFLAG = "REPLOCATIONFLAG";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    public static final String FIELD_WXENTAPPPARAMS = "WXENTAPPPARAMS";
    private static final int INDEX_APPTYPE = 0;
    private static final int INDEX_APPURL = 1;
    private static final int INDEX_CODENAME = 2;
    private static final int INDEX_CREATEDATE = 3;
    private static final int INDEX_CREATEMAN = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_ORDERVALUE = 6;
    private static final int INDEX_PSSYSAPPID = 7;
    private static final int INDEX_PSSYSAPPNAME = 8;
    private static final int INDEX_PSSYSRESOURCEID = 9;
    private static final int INDEX_PSSYSRESOURCENAME = 10;
    private static final int INDEX_PSSYSSFPLUGINID = 11;
    private static final int INDEX_PSSYSSFPLUGINNAME = 12;
    private static final int INDEX_PSWXACCOUNTID = 13;
    private static final int INDEX_PSWXACCOUNTNAME = 14;
    private static final int INDEX_PSWXENTAPPID = 15;
    private static final int INDEX_PSWXENTAPPNAME = 16;
    private static final int INDEX_PSWXLOGICSCNT = 17;
    private static final int INDEX_PSWXMENUFUNCSCNT = 18;
    private static final int INDEX_PSWXMENUSCNT = 19;
    private static final int INDEX_REPENTERFLAG = 20;
    private static final int INDEX_REPLOCATIONFLAG = 21;
    private static final int INDEX_UPDATEDATE = 22;
    private static final int INDEX_UPDATEMAN = 23;
    private static final int INDEX_USERCAT = 24;
    private static final int INDEX_USERTAG = 25;
    private static final int INDEX_USERTAG2 = 26;
    private static final int INDEX_USERTAG3 = 27;
    private static final int INDEX_USERTAG4 = 28;
    private static final int INDEX_VALIDFLAG = 29;
    private static final int INDEX_WXENTAPPPARAMS = 30;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSWXEntAppBase proxyPSWXEntAppBase = null;
    private boolean apptypeDirtyFlag = false;
    private boolean appurlDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean pssysappnameDirtyFlag = false;
    private boolean pssysresourceidDirtyFlag = false;
    private boolean pssysresourcenameDirtyFlag = false;
    private boolean pssyssfpluginidDirtyFlag = false;
    private boolean pssyssfpluginnameDirtyFlag = false;
    private boolean pswxaccountidDirtyFlag = false;
    private boolean pswxaccountnameDirtyFlag = false;
    private boolean pswxentappidDirtyFlag = false;
    private boolean pswxentappnameDirtyFlag = false;
    private boolean pswxlogicscntDirtyFlag = false;
    private boolean pswxmenufuncscntDirtyFlag = false;
    private boolean pswxmenuscntDirtyFlag = false;
    private boolean repenterflagDirtyFlag = false;
    private boolean replocationflagDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    private boolean wxentappparamsDirtyFlag = false;
    @Column(name="apptype")
    private String apptype;
    @Column(name="appurl")
    private String appurl;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="pssysappid")
    private String pssysappid;
    @Column(name="pssysappname")
    private String pssysappname;
    @Column(name="pssysresourceid")
    private String pssysresourceid;
    @Column(name="pssysresourcename")
    private String pssysresourcename;
    @Column(name="pssyssfpluginid")
    private String pssyssfpluginid;
    @Column(name="pssyssfpluginname")
    private String pssyssfpluginname;
    @Column(name="pswxaccountid")
    private String pswxaccountid;
    @Column(name="pswxaccountname")
    private String pswxaccountname;
    @Column(name="pswxentappid")
    private String pswxentappid;
    @Column(name="pswxentappname")
    private String pswxentappname;
    @Column(name="pswxlogicscnt")
    private Integer pswxlogicscnt;
    @Column(name="pswxmenufuncscnt")
    private Integer pswxmenufuncscnt;
    @Column(name="pswxmenuscnt")
    private Integer pswxmenuscnt;
    @Column(name="repenterflag")
    private Integer repenterflag;
    @Column(name="replocationflag")
    private Integer replocationflag;
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
    @Column(name="wxentappparams")
    private String wxentappparams;
    private Integer objPSSysAppLock = new Integer(1);
    private PSSysApp pssysapp = null;
    private Integer objPSSysResourceLock = new Integer(1);
    private PSSysResource pssysresource = null;
    private Integer objPSSysSFPluginLock = new Integer(1);
    private PSSysSFPlugin pssyssfplugin = null;
    private Integer objPSWXAccountLock = new Integer(1);
    private PSWXAccount pswxaccount = null;
    private Integer objPSWXLogicsLock = new Integer(1);
    private ArrayList<PSWXLogic> pswxlogics = null;
    private Integer objPSWXMenuFuncsLock = new Integer(1);
    private ArrayList<PSWXMenuFunc> pswxmenufuncs = null;
    private Integer objPSWXMenusLock = new Integer(1);
    private ArrayList<PSWXMenu> pswxmenus = null;

    public void setAppType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAppType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.apptype = string;
        this.apptypeDirtyFlag = true;
    }

    public String getAppType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAppType();
        }
        return this.apptype;
    }

    public boolean isAppTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAppTypeDirty();
        }
        return this.apptypeDirtyFlag;
    }

    public void resetAppType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAppType();
            return;
        }
        this.apptypeDirtyFlag = false;
        this.apptype = null;
    }

    public void setAppUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAppUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.appurl = string;
        this.appurlDirtyFlag = true;
    }

    public String getAppUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAppUrl();
        }
        return this.appurl;
    }

    public boolean isAppUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAppUrlDirty();
        }
        return this.appurlDirtyFlag;
    }

    public void resetAppUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAppUrl();
            return;
        }
        this.appurlDirtyFlag = false;
        this.appurl = null;
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

    public void setPSSysResourceId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysResourceId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysresourceid = string;
        this.pssysresourceidDirtyFlag = true;
    }

    public String getPSSysResourceId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysResourceId();
        }
        return this.pssysresourceid;
    }

    public boolean isPSSysResourceIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysResourceIdDirty();
        }
        return this.pssysresourceidDirtyFlag;
    }

    public void resetPSSysResourceId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysResourceId();
            return;
        }
        this.pssysresourceidDirtyFlag = false;
        this.pssysresourceid = null;
    }

    public void setPSSysResourceName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysResourceName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysresourcename = string;
        this.pssysresourcenameDirtyFlag = true;
    }

    public String getPSSysResourceName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysResourceName();
        }
        return this.pssysresourcename;
    }

    public boolean isPSSysResourceNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysResourceNameDirty();
        }
        return this.pssysresourcenameDirtyFlag;
    }

    public void resetPSSysResourceName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysResourceName();
            return;
        }
        this.pssysresourcenameDirtyFlag = false;
        this.pssysresourcename = null;
    }

    public void setPSSysSFPluginId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSFPluginId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssfpluginid = string;
        this.pssyssfpluginidDirtyFlag = true;
    }

    public String getPSSysSFPluginId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPluginId();
        }
        return this.pssyssfpluginid;
    }

    public boolean isPSSysSFPluginIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSFPluginIdDirty();
        }
        return this.pssyssfpluginidDirtyFlag;
    }

    public void resetPSSysSFPluginId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSFPluginId();
            return;
        }
        this.pssyssfpluginidDirtyFlag = false;
        this.pssyssfpluginid = null;
    }

    public void setPSSysSFPluginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSFPluginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssfpluginname = string;
        this.pssyssfpluginnameDirtyFlag = true;
    }

    public String getPSSysSFPluginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPluginName();
        }
        return this.pssyssfpluginname;
    }

    public boolean isPSSysSFPluginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSFPluginNameDirty();
        }
        return this.pssyssfpluginnameDirtyFlag;
    }

    public void resetPSSysSFPluginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSFPluginName();
            return;
        }
        this.pssyssfpluginnameDirtyFlag = false;
        this.pssyssfpluginname = null;
    }

    public void setPSWXAccountId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWXAccountId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswxaccountid = string;
        this.pswxaccountidDirtyFlag = true;
    }

    public String getPSWXAccountId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWXAccountId();
        }
        return this.pswxaccountid;
    }

    public boolean isPSWXAccountIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWXAccountIdDirty();
        }
        return this.pswxaccountidDirtyFlag;
    }

    public void resetPSWXAccountId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWXAccountId();
            return;
        }
        this.pswxaccountidDirtyFlag = false;
        this.pswxaccountid = null;
    }

    public void setPSWXAccountName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWXAccountName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswxaccountname = string;
        this.pswxaccountnameDirtyFlag = true;
    }

    public String getPSWXAccountName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWXAccountName();
        }
        return this.pswxaccountname;
    }

    public boolean isPSWXAccountNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWXAccountNameDirty();
        }
        return this.pswxaccountnameDirtyFlag;
    }

    public void resetPSWXAccountName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWXAccountName();
            return;
        }
        this.pswxaccountnameDirtyFlag = false;
        this.pswxaccountname = null;
    }

    public void setPSWXEntAppId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWXEntAppId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswxentappid = string;
        this.pswxentappidDirtyFlag = true;
    }

    public String getPSWXEntAppId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWXEntAppId();
        }
        return this.pswxentappid;
    }

    public boolean isPSWXEntAppIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWXEntAppIdDirty();
        }
        return this.pswxentappidDirtyFlag;
    }

    public void resetPSWXEntAppId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWXEntAppId();
            return;
        }
        this.pswxentappidDirtyFlag = false;
        this.pswxentappid = null;
    }

    public void setPSWXEntAppName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWXEntAppName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswxentappname = string;
        this.pswxentappnameDirtyFlag = true;
    }

    public String getPSWXEntAppName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWXEntAppName();
        }
        return this.pswxentappname;
    }

    public boolean isPSWXEntAppNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWXEntAppNameDirty();
        }
        return this.pswxentappnameDirtyFlag;
    }

    public void resetPSWXEntAppName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWXEntAppName();
            return;
        }
        this.pswxentappnameDirtyFlag = false;
        this.pswxentappname = null;
    }

    public void setPSWXLogicsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWXLogicsCnt(n);
            return;
        }
        this.pswxlogicscnt = n;
        this.pswxlogicscntDirtyFlag = true;
    }

    public Integer getPSWXLogicsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWXLogicsCnt();
        }
        return this.pswxlogicscnt;
    }

    public boolean isPSWXLogicsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWXLogicsCntDirty();
        }
        return this.pswxlogicscntDirtyFlag;
    }

    public void resetPSWXLogicsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWXLogicsCnt();
            return;
        }
        this.pswxlogicscntDirtyFlag = false;
        this.pswxlogicscnt = null;
    }

    public void setPSWXMenuFuncsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWXMenuFuncsCnt(n);
            return;
        }
        this.pswxmenufuncscnt = n;
        this.pswxmenufuncscntDirtyFlag = true;
    }

    public Integer getPSWXMenuFuncsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWXMenuFuncsCnt();
        }
        return this.pswxmenufuncscnt;
    }

    public boolean isPSWXMenuFuncsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWXMenuFuncsCntDirty();
        }
        return this.pswxmenufuncscntDirtyFlag;
    }

    public void resetPSWXMenuFuncsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWXMenuFuncsCnt();
            return;
        }
        this.pswxmenufuncscntDirtyFlag = false;
        this.pswxmenufuncscnt = null;
    }

    public void setPSWXMenusCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWXMenusCnt(n);
            return;
        }
        this.pswxmenuscnt = n;
        this.pswxmenuscntDirtyFlag = true;
    }

    public Integer getPSWXMenusCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWXMenusCnt();
        }
        return this.pswxmenuscnt;
    }

    public boolean isPSWXMenusCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWXMenusCntDirty();
        }
        return this.pswxmenuscntDirtyFlag;
    }

    public void resetPSWXMenusCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWXMenusCnt();
            return;
        }
        this.pswxmenuscntDirtyFlag = false;
        this.pswxmenuscnt = null;
    }

    public void setRepEnterFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRepEnterFlag(n);
            return;
        }
        this.repenterflag = n;
        this.repenterflagDirtyFlag = true;
    }

    public Integer getRepEnterFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRepEnterFlag();
        }
        return this.repenterflag;
    }

    public boolean isRepEnterFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRepEnterFlagDirty();
        }
        return this.repenterflagDirtyFlag;
    }

    public void resetRepEnterFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRepEnterFlag();
            return;
        }
        this.repenterflagDirtyFlag = false;
        this.repenterflag = null;
    }

    public void setRepLocationFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRepLocationFlag(n);
            return;
        }
        this.replocationflag = n;
        this.replocationflagDirtyFlag = true;
    }

    public Integer getRepLocationFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRepLocationFlag();
        }
        return this.replocationflag;
    }

    public boolean isRepLocationFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRepLocationFlagDirty();
        }
        return this.replocationflagDirtyFlag;
    }

    public void resetRepLocationFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRepLocationFlag();
            return;
        }
        this.replocationflagDirtyFlag = false;
        this.replocationflag = null;
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

    public void setWXEntAppParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWXEntAppParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wxentappparams = string;
        this.wxentappparamsDirtyFlag = true;
    }

    public String getWXEntAppParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWXEntAppParams();
        }
        return this.wxentappparams;
    }

    public boolean isWXEntAppParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWXEntAppParamsDirty();
        }
        return this.wxentappparamsDirtyFlag;
    }

    public void resetWXEntAppParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWXEntAppParams();
            return;
        }
        this.wxentappparamsDirtyFlag = false;
        this.wxentappparams = null;
    }

    protected void onReset() {
        PSWXEntAppBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSWXEntAppBase pSWXEntAppBase) {
        pSWXEntAppBase.resetAppType();
        pSWXEntAppBase.resetAppUrl();
        pSWXEntAppBase.resetCodeName();
        pSWXEntAppBase.resetCreateDate();
        pSWXEntAppBase.resetCreateMan();
        pSWXEntAppBase.resetMemo();
        pSWXEntAppBase.resetOrderValue();
        pSWXEntAppBase.resetPSSysAppId();
        pSWXEntAppBase.resetPSSysAppName();
        pSWXEntAppBase.resetPSSysResourceId();
        pSWXEntAppBase.resetPSSysResourceName();
        pSWXEntAppBase.resetPSSysSFPluginId();
        pSWXEntAppBase.resetPSSysSFPluginName();
        pSWXEntAppBase.resetPSWXAccountId();
        pSWXEntAppBase.resetPSWXAccountName();
        pSWXEntAppBase.resetPSWXEntAppId();
        pSWXEntAppBase.resetPSWXEntAppName();
        pSWXEntAppBase.resetPSWXLogicsCnt();
        pSWXEntAppBase.resetPSWXMenuFuncsCnt();
        pSWXEntAppBase.resetPSWXMenusCnt();
        pSWXEntAppBase.resetRepEnterFlag();
        pSWXEntAppBase.resetRepLocationFlag();
        pSWXEntAppBase.resetUpdateDate();
        pSWXEntAppBase.resetUpdateMan();
        pSWXEntAppBase.resetUserCat();
        pSWXEntAppBase.resetUserTag();
        pSWXEntAppBase.resetUserTag2();
        pSWXEntAppBase.resetUserTag3();
        pSWXEntAppBase.resetUserTag4();
        pSWXEntAppBase.resetValidFlag();
        pSWXEntAppBase.resetWXEntAppParams();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAppTypeDirty()) {
            hashMap.put(FIELD_APPTYPE, this.getAppType());
        }
        if (!bl || this.isAppUrlDirty()) {
            hashMap.put(FIELD_APPURL, this.getAppUrl());
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
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSSysAppIdDirty()) {
            hashMap.put(FIELD_PSSYSAPPID, this.getPSSysAppId());
        }
        if (!bl || this.isPSSysAppNameDirty()) {
            hashMap.put(FIELD_PSSYSAPPNAME, this.getPSSysAppName());
        }
        if (!bl || this.isPSSysResourceIdDirty()) {
            hashMap.put(FIELD_PSSYSRESOURCEID, this.getPSSysResourceId());
        }
        if (!bl || this.isPSSysResourceNameDirty()) {
            hashMap.put(FIELD_PSSYSRESOURCENAME, this.getPSSysResourceName());
        }
        if (!bl || this.isPSSysSFPluginIdDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINID, this.getPSSysSFPluginId());
        }
        if (!bl || this.isPSSysSFPluginNameDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINNAME, this.getPSSysSFPluginName());
        }
        if (!bl || this.isPSWXAccountIdDirty()) {
            hashMap.put(FIELD_PSWXACCOUNTID, this.getPSWXAccountId());
        }
        if (!bl || this.isPSWXAccountNameDirty()) {
            hashMap.put(FIELD_PSWXACCOUNTNAME, this.getPSWXAccountName());
        }
        if (!bl || this.isPSWXEntAppIdDirty()) {
            hashMap.put(FIELD_PSWXENTAPPID, this.getPSWXEntAppId());
        }
        if (!bl || this.isPSWXEntAppNameDirty()) {
            hashMap.put(FIELD_PSWXENTAPPNAME, this.getPSWXEntAppName());
        }
        if (!bl || this.isPSWXLogicsCntDirty()) {
            hashMap.put(FIELD_PSWXLOGICSCNT, this.getPSWXLogicsCnt());
        }
        if (!bl || this.isPSWXMenuFuncsCntDirty()) {
            hashMap.put(FIELD_PSWXMENUFUNCSCNT, this.getPSWXMenuFuncsCnt());
        }
        if (!bl || this.isPSWXMenusCntDirty()) {
            hashMap.put(FIELD_PSWXMENUSCNT, this.getPSWXMenusCnt());
        }
        if (!bl || this.isRepEnterFlagDirty()) {
            hashMap.put(FIELD_REPENTERFLAG, this.getRepEnterFlag());
        }
        if (!bl || this.isRepLocationFlagDirty()) {
            hashMap.put(FIELD_REPLOCATIONFLAG, this.getRepLocationFlag());
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
        if (!bl || this.isWXEntAppParamsDirty()) {
            hashMap.put(FIELD_WXENTAPPPARAMS, this.getWXEntAppParams());
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
        return PSWXEntAppBase.get(this, n);
    }

    private static Object get(PSWXEntAppBase pSWXEntAppBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWXEntAppBase.getAppType();
            }
            case 1: {
                return pSWXEntAppBase.getAppUrl();
            }
            case 2: {
                return pSWXEntAppBase.getCodeName();
            }
            case 3: {
                return pSWXEntAppBase.getCreateDate();
            }
            case 4: {
                return pSWXEntAppBase.getCreateMan();
            }
            case 5: {
                return pSWXEntAppBase.getMemo();
            }
            case 6: {
                return pSWXEntAppBase.getOrderValue();
            }
            case 7: {
                return pSWXEntAppBase.getPSSysAppId();
            }
            case 8: {
                return pSWXEntAppBase.getPSSysAppName();
            }
            case 9: {
                return pSWXEntAppBase.getPSSysResourceId();
            }
            case 10: {
                return pSWXEntAppBase.getPSSysResourceName();
            }
            case 11: {
                return pSWXEntAppBase.getPSSysSFPluginId();
            }
            case 12: {
                return pSWXEntAppBase.getPSSysSFPluginName();
            }
            case 13: {
                return pSWXEntAppBase.getPSWXAccountId();
            }
            case 14: {
                return pSWXEntAppBase.getPSWXAccountName();
            }
            case 15: {
                return pSWXEntAppBase.getPSWXEntAppId();
            }
            case 16: {
                return pSWXEntAppBase.getPSWXEntAppName();
            }
            case 17: {
                return pSWXEntAppBase.getPSWXLogicsCnt();
            }
            case 18: {
                return pSWXEntAppBase.getPSWXMenuFuncsCnt();
            }
            case 19: {
                return pSWXEntAppBase.getPSWXMenusCnt();
            }
            case 20: {
                return pSWXEntAppBase.getRepEnterFlag();
            }
            case 21: {
                return pSWXEntAppBase.getRepLocationFlag();
            }
            case 22: {
                return pSWXEntAppBase.getUpdateDate();
            }
            case 23: {
                return pSWXEntAppBase.getUpdateMan();
            }
            case 24: {
                return pSWXEntAppBase.getUserCat();
            }
            case 25: {
                return pSWXEntAppBase.getUserTag();
            }
            case 26: {
                return pSWXEntAppBase.getUserTag2();
            }
            case 27: {
                return pSWXEntAppBase.getUserTag3();
            }
            case 28: {
                return pSWXEntAppBase.getUserTag4();
            }
            case 29: {
                return pSWXEntAppBase.getValidFlag();
            }
            case 30: {
                return pSWXEntAppBase.getWXEntAppParams();
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
        PSWXEntAppBase.set(this, n, object);
    }

    private static void set(PSWXEntAppBase pSWXEntAppBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSWXEntAppBase.setAppType(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSWXEntAppBase.setAppUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSWXEntAppBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSWXEntAppBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSWXEntAppBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSWXEntAppBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSWXEntAppBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSWXEntAppBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSWXEntAppBase.setPSSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSWXEntAppBase.setPSSysResourceId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSWXEntAppBase.setPSSysResourceName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSWXEntAppBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSWXEntAppBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSWXEntAppBase.setPSWXAccountId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSWXEntAppBase.setPSWXAccountName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSWXEntAppBase.setPSWXEntAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSWXEntAppBase.setPSWXEntAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSWXEntAppBase.setPSWXLogicsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 18: {
                pSWXEntAppBase.setPSWXMenuFuncsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 19: {
                pSWXEntAppBase.setPSWXMenusCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 20: {
                pSWXEntAppBase.setRepEnterFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 21: {
                pSWXEntAppBase.setRepLocationFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 22: {
                pSWXEntAppBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 23: {
                pSWXEntAppBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSWXEntAppBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSWXEntAppBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSWXEntAppBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSWXEntAppBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSWXEntAppBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSWXEntAppBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 30: {
                pSWXEntAppBase.setWXEntAppParams(DataObject.getStringValue((Object)object));
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
        return PSWXEntAppBase.isNull(this, n);
    }

    private static boolean isNull(PSWXEntAppBase pSWXEntAppBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWXEntAppBase.getAppType() == null;
            }
            case 1: {
                return pSWXEntAppBase.getAppUrl() == null;
            }
            case 2: {
                return pSWXEntAppBase.getCodeName() == null;
            }
            case 3: {
                return pSWXEntAppBase.getCreateDate() == null;
            }
            case 4: {
                return pSWXEntAppBase.getCreateMan() == null;
            }
            case 5: {
                return pSWXEntAppBase.getMemo() == null;
            }
            case 6: {
                return pSWXEntAppBase.getOrderValue() == null;
            }
            case 7: {
                return pSWXEntAppBase.getPSSysAppId() == null;
            }
            case 8: {
                return pSWXEntAppBase.getPSSysAppName() == null;
            }
            case 9: {
                return pSWXEntAppBase.getPSSysResourceId() == null;
            }
            case 10: {
                return pSWXEntAppBase.getPSSysResourceName() == null;
            }
            case 11: {
                return pSWXEntAppBase.getPSSysSFPluginId() == null;
            }
            case 12: {
                return pSWXEntAppBase.getPSSysSFPluginName() == null;
            }
            case 13: {
                return pSWXEntAppBase.getPSWXAccountId() == null;
            }
            case 14: {
                return pSWXEntAppBase.getPSWXAccountName() == null;
            }
            case 15: {
                return pSWXEntAppBase.getPSWXEntAppId() == null;
            }
            case 16: {
                return pSWXEntAppBase.getPSWXEntAppName() == null;
            }
            case 17: {
                return pSWXEntAppBase.getPSWXLogicsCnt() == null;
            }
            case 18: {
                return pSWXEntAppBase.getPSWXMenuFuncsCnt() == null;
            }
            case 19: {
                return pSWXEntAppBase.getPSWXMenusCnt() == null;
            }
            case 20: {
                return pSWXEntAppBase.getRepEnterFlag() == null;
            }
            case 21: {
                return pSWXEntAppBase.getRepLocationFlag() == null;
            }
            case 22: {
                return pSWXEntAppBase.getUpdateDate() == null;
            }
            case 23: {
                return pSWXEntAppBase.getUpdateMan() == null;
            }
            case 24: {
                return pSWXEntAppBase.getUserCat() == null;
            }
            case 25: {
                return pSWXEntAppBase.getUserTag() == null;
            }
            case 26: {
                return pSWXEntAppBase.getUserTag2() == null;
            }
            case 27: {
                return pSWXEntAppBase.getUserTag3() == null;
            }
            case 28: {
                return pSWXEntAppBase.getUserTag4() == null;
            }
            case 29: {
                return pSWXEntAppBase.getValidFlag() == null;
            }
            case 30: {
                return pSWXEntAppBase.getWXEntAppParams() == null;
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
        return PSWXEntAppBase.contains(this, n);
    }

    private static boolean contains(PSWXEntAppBase pSWXEntAppBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWXEntAppBase.isAppTypeDirty();
            }
            case 1: {
                return pSWXEntAppBase.isAppUrlDirty();
            }
            case 2: {
                return pSWXEntAppBase.isCodeNameDirty();
            }
            case 3: {
                return pSWXEntAppBase.isCreateDateDirty();
            }
            case 4: {
                return pSWXEntAppBase.isCreateManDirty();
            }
            case 5: {
                return pSWXEntAppBase.isMemoDirty();
            }
            case 6: {
                return pSWXEntAppBase.isOrderValueDirty();
            }
            case 7: {
                return pSWXEntAppBase.isPSSysAppIdDirty();
            }
            case 8: {
                return pSWXEntAppBase.isPSSysAppNameDirty();
            }
            case 9: {
                return pSWXEntAppBase.isPSSysResourceIdDirty();
            }
            case 10: {
                return pSWXEntAppBase.isPSSysResourceNameDirty();
            }
            case 11: {
                return pSWXEntAppBase.isPSSysSFPluginIdDirty();
            }
            case 12: {
                return pSWXEntAppBase.isPSSysSFPluginNameDirty();
            }
            case 13: {
                return pSWXEntAppBase.isPSWXAccountIdDirty();
            }
            case 14: {
                return pSWXEntAppBase.isPSWXAccountNameDirty();
            }
            case 15: {
                return pSWXEntAppBase.isPSWXEntAppIdDirty();
            }
            case 16: {
                return pSWXEntAppBase.isPSWXEntAppNameDirty();
            }
            case 17: {
                return pSWXEntAppBase.isPSWXLogicsCntDirty();
            }
            case 18: {
                return pSWXEntAppBase.isPSWXMenuFuncsCntDirty();
            }
            case 19: {
                return pSWXEntAppBase.isPSWXMenusCntDirty();
            }
            case 20: {
                return pSWXEntAppBase.isRepEnterFlagDirty();
            }
            case 21: {
                return pSWXEntAppBase.isRepLocationFlagDirty();
            }
            case 22: {
                return pSWXEntAppBase.isUpdateDateDirty();
            }
            case 23: {
                return pSWXEntAppBase.isUpdateManDirty();
            }
            case 24: {
                return pSWXEntAppBase.isUserCatDirty();
            }
            case 25: {
                return pSWXEntAppBase.isUserTagDirty();
            }
            case 26: {
                return pSWXEntAppBase.isUserTag2Dirty();
            }
            case 27: {
                return pSWXEntAppBase.isUserTag3Dirty();
            }
            case 28: {
                return pSWXEntAppBase.isUserTag4Dirty();
            }
            case 29: {
                return pSWXEntAppBase.isValidFlagDirty();
            }
            case 30: {
                return pSWXEntAppBase.isWXEntAppParamsDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSWXEntAppBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSWXEntAppBase pSWXEntAppBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSWXEntAppBase.getAppType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"apptype", (Object)PSWXEntAppBase.getJSONValue((Object)pSWXEntAppBase.getAppType()), (boolean)false);
        }
        if (bl || pSWXEntAppBase.getAppUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"appurl", (Object)PSWXEntAppBase.getJSONValue((Object)pSWXEntAppBase.getAppUrl()), (boolean)false);
        }
        if (bl || pSWXEntAppBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSWXEntAppBase.getJSONValue((Object)pSWXEntAppBase.getCodeName()), (boolean)false);
        }
        if (bl || pSWXEntAppBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSWXEntAppBase.getJSONValue((Object)pSWXEntAppBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSWXEntAppBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSWXEntAppBase.getJSONValue((Object)pSWXEntAppBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSWXEntAppBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSWXEntAppBase.getJSONValue((Object)pSWXEntAppBase.getMemo()), (boolean)false);
        }
        if (bl || pSWXEntAppBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSWXEntAppBase.getJSONValue((Object)pSWXEntAppBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSWXEntAppBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSWXEntAppBase.getJSONValue((Object)pSWXEntAppBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSWXEntAppBase.getPSSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappname", (Object)PSWXEntAppBase.getJSONValue((Object)pSWXEntAppBase.getPSSysAppName()), (boolean)false);
        }
        if (bl || pSWXEntAppBase.getPSSysResourceId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysresourceid", (Object)PSWXEntAppBase.getJSONValue((Object)pSWXEntAppBase.getPSSysResourceId()), (boolean)false);
        }
        if (bl || pSWXEntAppBase.getPSSysResourceName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysresourcename", (Object)PSWXEntAppBase.getJSONValue((Object)pSWXEntAppBase.getPSSysResourceName()), (boolean)false);
        }
        if (bl || pSWXEntAppBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSWXEntAppBase.getJSONValue((Object)pSWXEntAppBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSWXEntAppBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSWXEntAppBase.getJSONValue((Object)pSWXEntAppBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSWXEntAppBase.getPSWXAccountId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswxaccountid", (Object)PSWXEntAppBase.getJSONValue((Object)pSWXEntAppBase.getPSWXAccountId()), (boolean)false);
        }
        if (bl || pSWXEntAppBase.getPSWXAccountName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswxaccountname", (Object)PSWXEntAppBase.getJSONValue((Object)pSWXEntAppBase.getPSWXAccountName()), (boolean)false);
        }
        if (bl || pSWXEntAppBase.getPSWXEntAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswxentappid", (Object)PSWXEntAppBase.getJSONValue((Object)pSWXEntAppBase.getPSWXEntAppId()), (boolean)false);
        }
        if (bl || pSWXEntAppBase.getPSWXEntAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswxentappname", (Object)PSWXEntAppBase.getJSONValue((Object)pSWXEntAppBase.getPSWXEntAppName()), (boolean)false);
        }
        if (bl || pSWXEntAppBase.getPSWXLogicsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswxlogicscnt", (Object)PSWXEntAppBase.getJSONValue((Object)pSWXEntAppBase.getPSWXLogicsCnt()), (boolean)false);
        }
        if (bl || pSWXEntAppBase.getPSWXMenuFuncsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswxmenufuncscnt", (Object)PSWXEntAppBase.getJSONValue((Object)pSWXEntAppBase.getPSWXMenuFuncsCnt()), (boolean)false);
        }
        if (bl || pSWXEntAppBase.getPSWXMenusCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswxmenuscnt", (Object)PSWXEntAppBase.getJSONValue((Object)pSWXEntAppBase.getPSWXMenusCnt()), (boolean)false);
        }
        if (bl || pSWXEntAppBase.getRepEnterFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"repenterflag", (Object)PSWXEntAppBase.getJSONValue((Object)pSWXEntAppBase.getRepEnterFlag()), (boolean)false);
        }
        if (bl || pSWXEntAppBase.getRepLocationFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"replocationflag", (Object)PSWXEntAppBase.getJSONValue((Object)pSWXEntAppBase.getRepLocationFlag()), (boolean)false);
        }
        if (bl || pSWXEntAppBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSWXEntAppBase.getJSONValue((Object)pSWXEntAppBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSWXEntAppBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSWXEntAppBase.getJSONValue((Object)pSWXEntAppBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSWXEntAppBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSWXEntAppBase.getJSONValue((Object)pSWXEntAppBase.getUserCat()), (boolean)false);
        }
        if (bl || pSWXEntAppBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSWXEntAppBase.getJSONValue((Object)pSWXEntAppBase.getUserTag()), (boolean)false);
        }
        if (bl || pSWXEntAppBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSWXEntAppBase.getJSONValue((Object)pSWXEntAppBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSWXEntAppBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSWXEntAppBase.getJSONValue((Object)pSWXEntAppBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSWXEntAppBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSWXEntAppBase.getJSONValue((Object)pSWXEntAppBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSWXEntAppBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSWXEntAppBase.getJSONValue((Object)pSWXEntAppBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSWXEntAppBase.getWXEntAppParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wxentappparams", (Object)PSWXEntAppBase.getJSONValue((Object)pSWXEntAppBase.getWXEntAppParams()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSWXEntAppBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSWXEntAppBase pSWXEntAppBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSWXEntAppBase.getAppType() != null) {
            object = pSWXEntAppBase.getAppType();
            xmlNode.setAttribute(FIELD_APPTYPE, (String)(object == null ? "" : object));
        }
        if (bl || pSWXEntAppBase.getAppUrl() != null) {
            object = pSWXEntAppBase.getAppUrl();
            xmlNode.setAttribute(FIELD_APPURL, (String)(object == null ? "" : object));
        }
        if (bl || pSWXEntAppBase.getCodeName() != null) {
            object = pSWXEntAppBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSWXEntAppBase.getCreateDate() != null) {
            object = pSWXEntAppBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWXEntAppBase.getCreateMan() != null) {
            object = pSWXEntAppBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSWXEntAppBase.getMemo() != null) {
            object = pSWXEntAppBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSWXEntAppBase.getOrderValue() != null) {
            object = pSWXEntAppBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWXEntAppBase.getPSSysAppId() != null) {
            object = pSWXEntAppBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSWXEntAppBase.getPSSysAppName() != null) {
            object = pSWXEntAppBase.getPSSysAppName();
            xmlNode.setAttribute(FIELD_PSSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWXEntAppBase.getPSSysResourceId() != null) {
            object = pSWXEntAppBase.getPSSysResourceId();
            xmlNode.setAttribute(FIELD_PSSYSRESOURCEID, object == null ? "" : (String)object);
        }
        if (bl || pSWXEntAppBase.getPSSysResourceName() != null) {
            object = pSWXEntAppBase.getPSSysResourceName();
            xmlNode.setAttribute(FIELD_PSSYSRESOURCENAME, object == null ? "" : (String)object);
        }
        if (bl || pSWXEntAppBase.getPSSysSFPluginId() != null) {
            object = pSWXEntAppBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSWXEntAppBase.getPSSysSFPluginName() != null) {
            object = pSWXEntAppBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWXEntAppBase.getPSWXAccountId() != null) {
            object = pSWXEntAppBase.getPSWXAccountId();
            xmlNode.setAttribute(FIELD_PSWXACCOUNTID, object == null ? "" : (String)object);
        }
        if (bl || pSWXEntAppBase.getPSWXAccountName() != null) {
            object = pSWXEntAppBase.getPSWXAccountName();
            xmlNode.setAttribute(FIELD_PSWXACCOUNTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWXEntAppBase.getPSWXEntAppId() != null) {
            object = pSWXEntAppBase.getPSWXEntAppId();
            xmlNode.setAttribute(FIELD_PSWXENTAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSWXEntAppBase.getPSWXEntAppName() != null) {
            object = pSWXEntAppBase.getPSWXEntAppName();
            xmlNode.setAttribute(FIELD_PSWXENTAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWXEntAppBase.getPSWXLogicsCnt() != null) {
            object = pSWXEntAppBase.getPSWXLogicsCnt();
            xmlNode.setAttribute(FIELD_PSWXLOGICSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWXEntAppBase.getPSWXMenuFuncsCnt() != null) {
            object = pSWXEntAppBase.getPSWXMenuFuncsCnt();
            xmlNode.setAttribute(FIELD_PSWXMENUFUNCSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWXEntAppBase.getPSWXMenusCnt() != null) {
            object = pSWXEntAppBase.getPSWXMenusCnt();
            xmlNode.setAttribute(FIELD_PSWXMENUSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWXEntAppBase.getRepEnterFlag() != null) {
            object = pSWXEntAppBase.getRepEnterFlag();
            xmlNode.setAttribute(FIELD_REPENTERFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWXEntAppBase.getRepLocationFlag() != null) {
            object = pSWXEntAppBase.getRepLocationFlag();
            xmlNode.setAttribute(FIELD_REPLOCATIONFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWXEntAppBase.getUpdateDate() != null) {
            object = pSWXEntAppBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWXEntAppBase.getUpdateMan() != null) {
            object = pSWXEntAppBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSWXEntAppBase.getUserCat() != null) {
            object = pSWXEntAppBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSWXEntAppBase.getUserTag() != null) {
            object = pSWXEntAppBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSWXEntAppBase.getUserTag2() != null) {
            object = pSWXEntAppBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSWXEntAppBase.getUserTag3() != null) {
            object = pSWXEntAppBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSWXEntAppBase.getUserTag4() != null) {
            object = pSWXEntAppBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSWXEntAppBase.getValidFlag() != null) {
            object = pSWXEntAppBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWXEntAppBase.getWXEntAppParams() != null) {
            object = pSWXEntAppBase.getWXEntAppParams();
            xmlNode.setAttribute(FIELD_WXENTAPPPARAMS, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSWXEntAppBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSWXEntAppBase pSWXEntAppBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSWXEntAppBase.isAppTypeDirty() && (bl || pSWXEntAppBase.getAppType() != null)) {
            iDataObject.set(FIELD_APPTYPE, (Object)pSWXEntAppBase.getAppType());
        }
        if (pSWXEntAppBase.isAppUrlDirty() && (bl || pSWXEntAppBase.getAppUrl() != null)) {
            iDataObject.set(FIELD_APPURL, (Object)pSWXEntAppBase.getAppUrl());
        }
        if (pSWXEntAppBase.isCodeNameDirty() && (bl || pSWXEntAppBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSWXEntAppBase.getCodeName());
        }
        if (pSWXEntAppBase.isCreateDateDirty() && (bl || pSWXEntAppBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSWXEntAppBase.getCreateDate());
        }
        if (pSWXEntAppBase.isCreateManDirty() && (bl || pSWXEntAppBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSWXEntAppBase.getCreateMan());
        }
        if (pSWXEntAppBase.isMemoDirty() && (bl || pSWXEntAppBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSWXEntAppBase.getMemo());
        }
        if (pSWXEntAppBase.isOrderValueDirty() && (bl || pSWXEntAppBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSWXEntAppBase.getOrderValue());
        }
        if (pSWXEntAppBase.isPSSysAppIdDirty() && (bl || pSWXEntAppBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSWXEntAppBase.getPSSysAppId());
        }
        if (pSWXEntAppBase.isPSSysAppNameDirty() && (bl || pSWXEntAppBase.getPSSysAppName() != null)) {
            iDataObject.set(FIELD_PSSYSAPPNAME, (Object)pSWXEntAppBase.getPSSysAppName());
        }
        if (pSWXEntAppBase.isPSSysResourceIdDirty() && (bl || pSWXEntAppBase.getPSSysResourceId() != null)) {
            iDataObject.set(FIELD_PSSYSRESOURCEID, (Object)pSWXEntAppBase.getPSSysResourceId());
        }
        if (pSWXEntAppBase.isPSSysResourceNameDirty() && (bl || pSWXEntAppBase.getPSSysResourceName() != null)) {
            iDataObject.set(FIELD_PSSYSRESOURCENAME, (Object)pSWXEntAppBase.getPSSysResourceName());
        }
        if (pSWXEntAppBase.isPSSysSFPluginIdDirty() && (bl || pSWXEntAppBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSWXEntAppBase.getPSSysSFPluginId());
        }
        if (pSWXEntAppBase.isPSSysSFPluginNameDirty() && (bl || pSWXEntAppBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSWXEntAppBase.getPSSysSFPluginName());
        }
        if (pSWXEntAppBase.isPSWXAccountIdDirty() && (bl || pSWXEntAppBase.getPSWXAccountId() != null)) {
            iDataObject.set(FIELD_PSWXACCOUNTID, (Object)pSWXEntAppBase.getPSWXAccountId());
        }
        if (pSWXEntAppBase.isPSWXAccountNameDirty() && (bl || pSWXEntAppBase.getPSWXAccountName() != null)) {
            iDataObject.set(FIELD_PSWXACCOUNTNAME, (Object)pSWXEntAppBase.getPSWXAccountName());
        }
        if (pSWXEntAppBase.isPSWXEntAppIdDirty() && (bl || pSWXEntAppBase.getPSWXEntAppId() != null)) {
            iDataObject.set(FIELD_PSWXENTAPPID, (Object)pSWXEntAppBase.getPSWXEntAppId());
        }
        if (pSWXEntAppBase.isPSWXEntAppNameDirty() && (bl || pSWXEntAppBase.getPSWXEntAppName() != null)) {
            iDataObject.set(FIELD_PSWXENTAPPNAME, (Object)pSWXEntAppBase.getPSWXEntAppName());
        }
        if (pSWXEntAppBase.isPSWXLogicsCntDirty() && (bl || pSWXEntAppBase.getPSWXLogicsCnt() != null)) {
            iDataObject.set(FIELD_PSWXLOGICSCNT, (Object)pSWXEntAppBase.getPSWXLogicsCnt());
        }
        if (pSWXEntAppBase.isPSWXMenuFuncsCntDirty() && (bl || pSWXEntAppBase.getPSWXMenuFuncsCnt() != null)) {
            iDataObject.set(FIELD_PSWXMENUFUNCSCNT, (Object)pSWXEntAppBase.getPSWXMenuFuncsCnt());
        }
        if (pSWXEntAppBase.isPSWXMenusCntDirty() && (bl || pSWXEntAppBase.getPSWXMenusCnt() != null)) {
            iDataObject.set(FIELD_PSWXMENUSCNT, (Object)pSWXEntAppBase.getPSWXMenusCnt());
        }
        if (pSWXEntAppBase.isRepEnterFlagDirty() && (bl || pSWXEntAppBase.getRepEnterFlag() != null)) {
            iDataObject.set(FIELD_REPENTERFLAG, (Object)pSWXEntAppBase.getRepEnterFlag());
        }
        if (pSWXEntAppBase.isRepLocationFlagDirty() && (bl || pSWXEntAppBase.getRepLocationFlag() != null)) {
            iDataObject.set(FIELD_REPLOCATIONFLAG, (Object)pSWXEntAppBase.getRepLocationFlag());
        }
        if (pSWXEntAppBase.isUpdateDateDirty() && (bl || pSWXEntAppBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSWXEntAppBase.getUpdateDate());
        }
        if (pSWXEntAppBase.isUpdateManDirty() && (bl || pSWXEntAppBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSWXEntAppBase.getUpdateMan());
        }
        if (pSWXEntAppBase.isUserCatDirty() && (bl || pSWXEntAppBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSWXEntAppBase.getUserCat());
        }
        if (pSWXEntAppBase.isUserTagDirty() && (bl || pSWXEntAppBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSWXEntAppBase.getUserTag());
        }
        if (pSWXEntAppBase.isUserTag2Dirty() && (bl || pSWXEntAppBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSWXEntAppBase.getUserTag2());
        }
        if (pSWXEntAppBase.isUserTag3Dirty() && (bl || pSWXEntAppBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSWXEntAppBase.getUserTag3());
        }
        if (pSWXEntAppBase.isUserTag4Dirty() && (bl || pSWXEntAppBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSWXEntAppBase.getUserTag4());
        }
        if (pSWXEntAppBase.isValidFlagDirty() && (bl || pSWXEntAppBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSWXEntAppBase.getValidFlag());
        }
        if (pSWXEntAppBase.isWXEntAppParamsDirty() && (bl || pSWXEntAppBase.getWXEntAppParams() != null)) {
            iDataObject.set(FIELD_WXENTAPPPARAMS, (Object)pSWXEntAppBase.getWXEntAppParams());
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
        return PSWXEntAppBase.remove(this, n);
    }

    private static boolean remove(PSWXEntAppBase pSWXEntAppBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSWXEntAppBase.resetAppType();
                return true;
            }
            case 1: {
                pSWXEntAppBase.resetAppUrl();
                return true;
            }
            case 2: {
                pSWXEntAppBase.resetCodeName();
                return true;
            }
            case 3: {
                pSWXEntAppBase.resetCreateDate();
                return true;
            }
            case 4: {
                pSWXEntAppBase.resetCreateMan();
                return true;
            }
            case 5: {
                pSWXEntAppBase.resetMemo();
                return true;
            }
            case 6: {
                pSWXEntAppBase.resetOrderValue();
                return true;
            }
            case 7: {
                pSWXEntAppBase.resetPSSysAppId();
                return true;
            }
            case 8: {
                pSWXEntAppBase.resetPSSysAppName();
                return true;
            }
            case 9: {
                pSWXEntAppBase.resetPSSysResourceId();
                return true;
            }
            case 10: {
                pSWXEntAppBase.resetPSSysResourceName();
                return true;
            }
            case 11: {
                pSWXEntAppBase.resetPSSysSFPluginId();
                return true;
            }
            case 12: {
                pSWXEntAppBase.resetPSSysSFPluginName();
                return true;
            }
            case 13: {
                pSWXEntAppBase.resetPSWXAccountId();
                return true;
            }
            case 14: {
                pSWXEntAppBase.resetPSWXAccountName();
                return true;
            }
            case 15: {
                pSWXEntAppBase.resetPSWXEntAppId();
                return true;
            }
            case 16: {
                pSWXEntAppBase.resetPSWXEntAppName();
                return true;
            }
            case 17: {
                pSWXEntAppBase.resetPSWXLogicsCnt();
                return true;
            }
            case 18: {
                pSWXEntAppBase.resetPSWXMenuFuncsCnt();
                return true;
            }
            case 19: {
                pSWXEntAppBase.resetPSWXMenusCnt();
                return true;
            }
            case 20: {
                pSWXEntAppBase.resetRepEnterFlag();
                return true;
            }
            case 21: {
                pSWXEntAppBase.resetRepLocationFlag();
                return true;
            }
            case 22: {
                pSWXEntAppBase.resetUpdateDate();
                return true;
            }
            case 23: {
                pSWXEntAppBase.resetUpdateMan();
                return true;
            }
            case 24: {
                pSWXEntAppBase.resetUserCat();
                return true;
            }
            case 25: {
                pSWXEntAppBase.resetUserTag();
                return true;
            }
            case 26: {
                pSWXEntAppBase.resetUserTag2();
                return true;
            }
            case 27: {
                pSWXEntAppBase.resetUserTag3();
                return true;
            }
            case 28: {
                pSWXEntAppBase.resetUserTag4();
                return true;
            }
            case 29: {
                pSWXEntAppBase.resetValidFlag();
                return true;
            }
            case 30: {
                pSWXEntAppBase.resetWXEntAppParams();
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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysResource getPSSysResource() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysResource();
        }
        if (this.getPSSysResourceId() == null) {
            return null;
        }
        Integer n = this.objPSSysResourceLock;
        synchronized (n) {
            if (this.pssysresource != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysResourceId(), (Object)this.pssysresource.getPSSysResourceId()) != 0L) {
                this.pssysresource = null;
            }
            if (this.pssysresource == null) {
                PSSysResource pSSysResource = new PSSysResource();
                pSSysResource.setPSSysResourceId(this.getPSSysResourceId());
                PSSysResourceService pSSysResourceService = (PSSysResourceService)ServiceGlobal.getService(PSSysResourceService.class, (SessionFactory)this.getSessionFactory());
                pSSysResourceService.autoGet((IEntity)pSSysResource);
                this.pssysresource = pSSysResource;
            }
            return this.pssysresource;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysSFPlugin getPSSysSFPlugin() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPlugin();
        }
        if (this.getPSSysSFPluginId() == null) {
            return null;
        }
        Integer n = this.objPSSysSFPluginLock;
        synchronized (n) {
            if (this.pssyssfplugin != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysSFPluginId(), (Object)this.pssyssfplugin.getPSSysSFPluginId()) != 0L) {
                this.pssyssfplugin = null;
            }
            if (this.pssyssfplugin == null) {
                PSSysSFPlugin pSSysSFPlugin = new PSSysSFPlugin();
                pSSysSFPlugin.setPSSysSFPluginId(this.getPSSysSFPluginId());
                PSSysSFPluginService pSSysSFPluginService = (PSSysSFPluginService)ServiceGlobal.getService(PSSysSFPluginService.class, (SessionFactory)this.getSessionFactory());
                pSSysSFPluginService.autoGet((IEntity)pSSysSFPlugin);
                this.pssyssfplugin = pSSysSFPlugin;
            }
            return this.pssyssfplugin;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSWXAccount getPSWXAccount() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWXAccount();
        }
        if (this.getPSWXAccountId() == null) {
            return null;
        }
        Integer n = this.objPSWXAccountLock;
        synchronized (n) {
            if (this.pswxaccount != null && DataTypeHelper.compare((int)25, (Object)this.getPSWXAccountId(), (Object)this.pswxaccount.getPSWXAccountId()) != 0L) {
                this.pswxaccount = null;
            }
            if (this.pswxaccount == null) {
                PSWXAccount pSWXAccount = new PSWXAccount();
                pSWXAccount.setPSWXAccountId(this.getPSWXAccountId());
                PSWXAccountService pSWXAccountService = (PSWXAccountService)ServiceGlobal.getService(PSWXAccountService.class, (SessionFactory)this.getSessionFactory());
                pSWXAccountService.autoGet((IEntity)pSWXAccount);
                this.pswxaccount = pSWXAccount;
            }
            return this.pswxaccount;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSWXLogic> getPSWXLogics() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWXLogics();
        }
        if (this.getPSWXEntAppId() == null) {
            return null;
        }
        PSWXLogicService pSWXLogicService = (PSWXLogicService)ServiceGlobal.getService(PSWXLogicService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSWXLogicsLock;
        synchronized (n) {
            if (this.pswxlogics == null) {
                this.pswxlogics = pSWXLogicService.selectByPSWXEntApp(this);
            }
            return this.pswxlogics;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSWXMenuFunc> getPSWXMenuFuncs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWXMenuFuncs();
        }
        if (this.getPSWXEntAppId() == null) {
            return null;
        }
        PSWXMenuFuncService pSWXMenuFuncService = (PSWXMenuFuncService)ServiceGlobal.getService(PSWXMenuFuncService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSWXMenuFuncsLock;
        synchronized (n) {
            if (this.pswxmenufuncs == null) {
                this.pswxmenufuncs = pSWXMenuFuncService.selectByPSWXEntApp(this);
            }
            return this.pswxmenufuncs;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSWXMenu> getPSWXMenus() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWXMenus();
        }
        if (this.getPSWXEntAppId() == null) {
            return null;
        }
        PSWXMenuService pSWXMenuService = (PSWXMenuService)ServiceGlobal.getService(PSWXMenuService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSWXMenusLock;
        synchronized (n) {
            if (this.pswxmenus == null) {
                this.pswxmenus = pSWXMenuService.selectByPSWXEntApp(this);
            }
            return this.pswxmenus;
        }
    }

    private PSWXEntAppBase getProxyEntity() {
        return this.proxyPSWXEntAppBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSWXEntAppBase = null;
        if (iDataObject != null && iDataObject instanceof PSWXEntAppBase) {
            this.proxyPSWXEntAppBase = (PSWXEntAppBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wxdesign.service.PSWXEntAppService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_APPTYPE, 0);
        fieldIndexMap.put(FIELD_APPURL, 1);
        fieldIndexMap.put(FIELD_CODENAME, 2);
        fieldIndexMap.put(FIELD_CREATEDATE, 3);
        fieldIndexMap.put(FIELD_CREATEMAN, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_ORDERVALUE, 6);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 7);
        fieldIndexMap.put(FIELD_PSSYSAPPNAME, 8);
        fieldIndexMap.put(FIELD_PSSYSRESOURCEID, 9);
        fieldIndexMap.put(FIELD_PSSYSRESOURCENAME, 10);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 11);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 12);
        fieldIndexMap.put(FIELD_PSWXACCOUNTID, 13);
        fieldIndexMap.put(FIELD_PSWXACCOUNTNAME, 14);
        fieldIndexMap.put(FIELD_PSWXENTAPPID, 15);
        fieldIndexMap.put(FIELD_PSWXENTAPPNAME, 16);
        fieldIndexMap.put(FIELD_PSWXLOGICSCNT, 17);
        fieldIndexMap.put(FIELD_PSWXMENUFUNCSCNT, 18);
        fieldIndexMap.put(FIELD_PSWXMENUSCNT, 19);
        fieldIndexMap.put(FIELD_REPENTERFLAG, 20);
        fieldIndexMap.put(FIELD_REPLOCATIONFLAG, 21);
        fieldIndexMap.put(FIELD_UPDATEDATE, 22);
        fieldIndexMap.put(FIELD_UPDATEMAN, 23);
        fieldIndexMap.put(FIELD_USERCAT, 24);
        fieldIndexMap.put(FIELD_USERTAG, 25);
        fieldIndexMap.put(FIELD_USERTAG2, 26);
        fieldIndexMap.put(FIELD_USERTAG3, 27);
        fieldIndexMap.put(FIELD_USERTAG4, 28);
        fieldIndexMap.put(FIELD_VALIDFLAG, 29);
        fieldIndexMap.put(FIELD_WXENTAPPPARAMS, 30);
    }
}

