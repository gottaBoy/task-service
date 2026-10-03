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
import net.ibizsys.pscore.srv.appdesign.entity.PSAppMenu;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppWF;
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppWFService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppModuleBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSAppModuleBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_COLOR = "COLOR";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String FIELD_ENABLEMODULESTYLE = "ENABLEMODULESTYLE";
    public static final String FIELD_FROMOBJID = "FROMOBJID";
    public static final String FIELD_MAINMENUSIDE = "MAINMENUSIDE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MODULESN = "MODULESN";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSAPPMENUID = "PSAPPMENUID";
    public static final String FIELD_PSAPPMENUNAME = "PSAPPMENUNAME";
    public static final String FIELD_PSAPPMODULEID = "PSAPPMODULEID";
    public static final String FIELD_PSAPPMODULENAME = "PSAPPMODULENAME";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERPARAMS = "USERPARAMS";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_COLOR = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_DEFAULTFLAG = 4;
    private static final int INDEX_ENABLEMODULESTYLE = 5;
    private static final int INDEX_FROMOBJID = 6;
    private static final int INDEX_MAINMENUSIDE = 7;
    private static final int INDEX_MEMO = 8;
    private static final int INDEX_MODULESN = 9;
    private static final int INDEX_ORDERVALUE = 10;
    private static final int INDEX_PSAPPMENUID = 11;
    private static final int INDEX_PSAPPMENUNAME = 12;
    private static final int INDEX_PSAPPMODULEID = 13;
    private static final int INDEX_PSAPPMODULENAME = 14;
    private static final int INDEX_PSMODULEID = 15;
    private static final int INDEX_PSMODULENAME = 16;
    private static final int INDEX_PSSYSAPPID = 17;
    private static final int INDEX_PSSYSAPPNAME = 18;
    private static final int INDEX_UPDATEDATE = 19;
    private static final int INDEX_UPDATEMAN = 20;
    private static final int INDEX_USERCAT = 21;
    private static final int INDEX_USERPARAMS = 22;
    private static final int INDEX_USERTAG = 23;
    private static final int INDEX_USERTAG2 = 24;
    private static final int INDEX_USERTAG3 = 25;
    private static final int INDEX_USERTAG4 = 26;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSAppModuleBase proxyPSAppModuleBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean colorDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean defaultflagDirtyFlag = false;
    private boolean enablemodulestyleDirtyFlag = false;
    private boolean fromobjidDirtyFlag = false;
    private boolean mainmenusideDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean modulesnDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psappmenuidDirtyFlag = false;
    private boolean psappmenunameDirtyFlag = false;
    private boolean psappmoduleidDirtyFlag = false;
    private boolean psappmodulenameDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean pssysappnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean userparamsDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="color")
    private String color;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="defaultflag")
    private Integer defaultflag;
    @Column(name="enablemodulestyle")
    private Integer enablemodulestyle;
    @Column(name="fromobjid")
    private String fromobjid;
    @Column(name="mainmenuside")
    private String mainmenuside;
    @Column(name="memo")
    private String memo;
    @Column(name="modulesn")
    private String modulesn;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psappmenuid")
    private String psappmenuid;
    @Column(name="psappmenuname")
    private String psappmenuname;
    @Column(name="psappmoduleid")
    private String psappmoduleid;
    @Column(name="psappmodulename")
    private String psappmodulename;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssysappid")
    private String pssysappid;
    @Column(name="pssysappname")
    private String pssysappname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usercat")
    private String usercat;
    @Column(name="userparams")
    private String userparams;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="usertag3")
    private String usertag3;
    @Column(name="usertag4")
    private String usertag4;
    private Integer objPSAppMenuLock = new Integer(1);
    private PSAppMenu psappmenu = null;
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objPSSysAppLock = new Integer(1);
    private PSSysApp pssysapp = null;
    private Integer objPSAppWFsLock = new Integer(1);
    private ArrayList<PSAppWF> psappwfs = null;

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

    public void setColor(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setColor(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.color = string;
        this.colorDirtyFlag = true;
    }

    public String getColor() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getColor();
        }
        return this.color;
    }

    public boolean isColorDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isColorDirty();
        }
        return this.colorDirtyFlag;
    }

    public void resetColor() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetColor();
            return;
        }
        this.colorDirtyFlag = false;
        this.color = null;
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

    public void setEnableModuleStyle(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableModuleStyle(n);
            return;
        }
        this.enablemodulestyle = n;
        this.enablemodulestyleDirtyFlag = true;
    }

    public Integer getEnableModuleStyle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableModuleStyle();
        }
        return this.enablemodulestyle;
    }

    public boolean isEnableModuleStyleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableModuleStyleDirty();
        }
        return this.enablemodulestyleDirtyFlag;
    }

    public void resetEnableModuleStyle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableModuleStyle();
            return;
        }
        this.enablemodulestyleDirtyFlag = false;
        this.enablemodulestyle = null;
    }

    public void setFromObjId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFromObjId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.fromobjid = string;
        this.fromobjidDirtyFlag = true;
    }

    public String getFromObjId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFromObjId();
        }
        return this.fromobjid;
    }

    public boolean isFromObjIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFromObjIdDirty();
        }
        return this.fromobjidDirtyFlag;
    }

    public void resetFromObjId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFromObjId();
            return;
        }
        this.fromobjidDirtyFlag = false;
        this.fromobjid = null;
    }

    public void setMainMenuSide(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMainMenuSide(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mainmenuside = string;
        this.mainmenusideDirtyFlag = true;
    }

    public String getMainMenuSide() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMainMenuSide();
        }
        return this.mainmenuside;
    }

    public boolean isMainMenuSideDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMainMenuSideDirty();
        }
        return this.mainmenusideDirtyFlag;
    }

    public void resetMainMenuSide() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMainMenuSide();
            return;
        }
        this.mainmenusideDirtyFlag = false;
        this.mainmenuside = null;
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

    public void setModuleSN(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModuleSN(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.modulesn = string;
        this.modulesnDirtyFlag = true;
    }

    public String getModuleSN() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModuleSN();
        }
        return this.modulesn;
    }

    public boolean isModuleSNDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModuleSNDirty();
        }
        return this.modulesnDirtyFlag;
    }

    public void resetModuleSN() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModuleSN();
            return;
        }
        this.modulesnDirtyFlag = false;
        this.modulesn = null;
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

    public void setPSAppMenuId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppMenuId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappmenuid = string;
        this.psappmenuidDirtyFlag = true;
    }

    public String getPSAppMenuId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppMenuId();
        }
        return this.psappmenuid;
    }

    public boolean isPSAppMenuIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppMenuIdDirty();
        }
        return this.psappmenuidDirtyFlag;
    }

    public void resetPSAppMenuId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppMenuId();
            return;
        }
        this.psappmenuidDirtyFlag = false;
        this.psappmenuid = null;
    }

    public void setPSAppMenuName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppMenuName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappmenuname = string;
        this.psappmenunameDirtyFlag = true;
    }

    public String getPSAppMenuName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppMenuName();
        }
        return this.psappmenuname;
    }

    public boolean isPSAppMenuNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppMenuNameDirty();
        }
        return this.psappmenunameDirtyFlag;
    }

    public void resetPSAppMenuName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppMenuName();
            return;
        }
        this.psappmenunameDirtyFlag = false;
        this.psappmenuname = null;
    }

    public void setPSAppModuleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppModuleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappmoduleid = string;
        this.psappmoduleidDirtyFlag = true;
    }

    public String getPSAppModuleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppModuleId();
        }
        return this.psappmoduleid;
    }

    public boolean isPSAppModuleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppModuleIdDirty();
        }
        return this.psappmoduleidDirtyFlag;
    }

    public void resetPSAppModuleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppModuleId();
            return;
        }
        this.psappmoduleidDirtyFlag = false;
        this.psappmoduleid = null;
    }

    public void setPSAppModuleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppModuleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappmodulename = string;
        this.psappmodulenameDirtyFlag = true;
    }

    public String getPSAppModuleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppModuleName();
        }
        return this.psappmodulename;
    }

    public boolean isPSAppModuleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppModuleNameDirty();
        }
        return this.psappmodulenameDirtyFlag;
    }

    public void resetPSAppModuleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppModuleName();
            return;
        }
        this.psappmodulenameDirtyFlag = false;
        this.psappmodulename = null;
    }

    public void setPSModuleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModuleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmoduleid = string;
        this.psmoduleidDirtyFlag = true;
    }

    public String getPSModuleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModuleId();
        }
        return this.psmoduleid;
    }

    public boolean isPSModuleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModuleIdDirty();
        }
        return this.psmoduleidDirtyFlag;
    }

    public void resetPSModuleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModuleId();
            return;
        }
        this.psmoduleidDirtyFlag = false;
        this.psmoduleid = null;
    }

    public void setPSModuleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModuleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodulename = string;
        this.psmodulenameDirtyFlag = true;
    }

    public String getPSModuleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModuleName();
        }
        return this.psmodulename;
    }

    public boolean isPSModuleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModuleNameDirty();
        }
        return this.psmodulenameDirtyFlag;
    }

    public void resetPSModuleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModuleName();
            return;
        }
        this.psmodulenameDirtyFlag = false;
        this.psmodulename = null;
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

    public void setUserParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userparams = string;
        this.userparamsDirtyFlag = true;
    }

    public String getUserParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserParams();
        }
        return this.userparams;
    }

    public boolean isUserParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserParamsDirty();
        }
        return this.userparamsDirtyFlag;
    }

    public void resetUserParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserParams();
            return;
        }
        this.userparamsDirtyFlag = false;
        this.userparams = null;
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

    protected void onReset() {
        PSAppModuleBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSAppModuleBase pSAppModuleBase) {
        pSAppModuleBase.resetCodeName();
        pSAppModuleBase.resetColor();
        pSAppModuleBase.resetCreateDate();
        pSAppModuleBase.resetCreateMan();
        pSAppModuleBase.resetDefaultFlag();
        pSAppModuleBase.resetEnableModuleStyle();
        pSAppModuleBase.resetFromObjId();
        pSAppModuleBase.resetMainMenuSide();
        pSAppModuleBase.resetMemo();
        pSAppModuleBase.resetModuleSN();
        pSAppModuleBase.resetOrderValue();
        pSAppModuleBase.resetPSAppMenuId();
        pSAppModuleBase.resetPSAppMenuName();
        pSAppModuleBase.resetPSAppModuleId();
        pSAppModuleBase.resetPSAppModuleName();
        pSAppModuleBase.resetPSModuleId();
        pSAppModuleBase.resetPSModuleName();
        pSAppModuleBase.resetPSSysAppId();
        pSAppModuleBase.resetPSSysAppName();
        pSAppModuleBase.resetUpdateDate();
        pSAppModuleBase.resetUpdateMan();
        pSAppModuleBase.resetUserCat();
        pSAppModuleBase.resetUserParams();
        pSAppModuleBase.resetUserTag();
        pSAppModuleBase.resetUserTag2();
        pSAppModuleBase.resetUserTag3();
        pSAppModuleBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isColorDirty()) {
            hashMap.put(FIELD_COLOR, this.getColor());
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
        if (!bl || this.isEnableModuleStyleDirty()) {
            hashMap.put(FIELD_ENABLEMODULESTYLE, this.getEnableModuleStyle());
        }
        if (!bl || this.isFromObjIdDirty()) {
            hashMap.put(FIELD_FROMOBJID, this.getFromObjId());
        }
        if (!bl || this.isMainMenuSideDirty()) {
            hashMap.put(FIELD_MAINMENUSIDE, this.getMainMenuSide());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isModuleSNDirty()) {
            hashMap.put(FIELD_MODULESN, this.getModuleSN());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSAppMenuIdDirty()) {
            hashMap.put(FIELD_PSAPPMENUID, this.getPSAppMenuId());
        }
        if (!bl || this.isPSAppMenuNameDirty()) {
            hashMap.put(FIELD_PSAPPMENUNAME, this.getPSAppMenuName());
        }
        if (!bl || this.isPSAppModuleIdDirty()) {
            hashMap.put(FIELD_PSAPPMODULEID, this.getPSAppModuleId());
        }
        if (!bl || this.isPSAppModuleNameDirty()) {
            hashMap.put(FIELD_PSAPPMODULENAME, this.getPSAppModuleName());
        }
        if (!bl || this.isPSModuleIdDirty()) {
            hashMap.put(FIELD_PSMODULEID, this.getPSModuleId());
        }
        if (!bl || this.isPSModuleNameDirty()) {
            hashMap.put(FIELD_PSMODULENAME, this.getPSModuleName());
        }
        if (!bl || this.isPSSysAppIdDirty()) {
            hashMap.put(FIELD_PSSYSAPPID, this.getPSSysAppId());
        }
        if (!bl || this.isPSSysAppNameDirty()) {
            hashMap.put(FIELD_PSSYSAPPNAME, this.getPSSysAppName());
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
        if (!bl || this.isUserParamsDirty()) {
            hashMap.put(FIELD_USERPARAMS, this.getUserParams());
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
        return PSAppModuleBase.get(this, n);
    }

    private static Object get(PSAppModuleBase pSAppModuleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppModuleBase.getCodeName();
            }
            case 1: {
                return pSAppModuleBase.getColor();
            }
            case 2: {
                return pSAppModuleBase.getCreateDate();
            }
            case 3: {
                return pSAppModuleBase.getCreateMan();
            }
            case 4: {
                return pSAppModuleBase.getDefaultFlag();
            }
            case 5: {
                return pSAppModuleBase.getEnableModuleStyle();
            }
            case 6: {
                return pSAppModuleBase.getFromObjId();
            }
            case 7: {
                return pSAppModuleBase.getMainMenuSide();
            }
            case 8: {
                return pSAppModuleBase.getMemo();
            }
            case 9: {
                return pSAppModuleBase.getModuleSN();
            }
            case 10: {
                return pSAppModuleBase.getOrderValue();
            }
            case 11: {
                return pSAppModuleBase.getPSAppMenuId();
            }
            case 12: {
                return pSAppModuleBase.getPSAppMenuName();
            }
            case 13: {
                return pSAppModuleBase.getPSAppModuleId();
            }
            case 14: {
                return pSAppModuleBase.getPSAppModuleName();
            }
            case 15: {
                return pSAppModuleBase.getPSModuleId();
            }
            case 16: {
                return pSAppModuleBase.getPSModuleName();
            }
            case 17: {
                return pSAppModuleBase.getPSSysAppId();
            }
            case 18: {
                return pSAppModuleBase.getPSSysAppName();
            }
            case 19: {
                return pSAppModuleBase.getUpdateDate();
            }
            case 20: {
                return pSAppModuleBase.getUpdateMan();
            }
            case 21: {
                return pSAppModuleBase.getUserCat();
            }
            case 22: {
                return pSAppModuleBase.getUserParams();
            }
            case 23: {
                return pSAppModuleBase.getUserTag();
            }
            case 24: {
                return pSAppModuleBase.getUserTag2();
            }
            case 25: {
                return pSAppModuleBase.getUserTag3();
            }
            case 26: {
                return pSAppModuleBase.getUserTag4();
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
        PSAppModuleBase.set(this, n, object);
    }

    private static void set(PSAppModuleBase pSAppModuleBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSAppModuleBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSAppModuleBase.setColor(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSAppModuleBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSAppModuleBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSAppModuleBase.setDefaultFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSAppModuleBase.setEnableModuleStyle(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSAppModuleBase.setFromObjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSAppModuleBase.setMainMenuSide(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSAppModuleBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSAppModuleBase.setModuleSN(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSAppModuleBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSAppModuleBase.setPSAppMenuId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSAppModuleBase.setPSAppMenuName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSAppModuleBase.setPSAppModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSAppModuleBase.setPSAppModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSAppModuleBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSAppModuleBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSAppModuleBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSAppModuleBase.setPSSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSAppModuleBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 20: {
                pSAppModuleBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSAppModuleBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSAppModuleBase.setUserParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSAppModuleBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSAppModuleBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSAppModuleBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSAppModuleBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSAppModuleBase.isNull(this, n);
    }

    private static boolean isNull(PSAppModuleBase pSAppModuleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppModuleBase.getCodeName() == null;
            }
            case 1: {
                return pSAppModuleBase.getColor() == null;
            }
            case 2: {
                return pSAppModuleBase.getCreateDate() == null;
            }
            case 3: {
                return pSAppModuleBase.getCreateMan() == null;
            }
            case 4: {
                return pSAppModuleBase.getDefaultFlag() == null;
            }
            case 5: {
                return pSAppModuleBase.getEnableModuleStyle() == null;
            }
            case 6: {
                return pSAppModuleBase.getFromObjId() == null;
            }
            case 7: {
                return pSAppModuleBase.getMainMenuSide() == null;
            }
            case 8: {
                return pSAppModuleBase.getMemo() == null;
            }
            case 9: {
                return pSAppModuleBase.getModuleSN() == null;
            }
            case 10: {
                return pSAppModuleBase.getOrderValue() == null;
            }
            case 11: {
                return pSAppModuleBase.getPSAppMenuId() == null;
            }
            case 12: {
                return pSAppModuleBase.getPSAppMenuName() == null;
            }
            case 13: {
                return pSAppModuleBase.getPSAppModuleId() == null;
            }
            case 14: {
                return pSAppModuleBase.getPSAppModuleName() == null;
            }
            case 15: {
                return pSAppModuleBase.getPSModuleId() == null;
            }
            case 16: {
                return pSAppModuleBase.getPSModuleName() == null;
            }
            case 17: {
                return pSAppModuleBase.getPSSysAppId() == null;
            }
            case 18: {
                return pSAppModuleBase.getPSSysAppName() == null;
            }
            case 19: {
                return pSAppModuleBase.getUpdateDate() == null;
            }
            case 20: {
                return pSAppModuleBase.getUpdateMan() == null;
            }
            case 21: {
                return pSAppModuleBase.getUserCat() == null;
            }
            case 22: {
                return pSAppModuleBase.getUserParams() == null;
            }
            case 23: {
                return pSAppModuleBase.getUserTag() == null;
            }
            case 24: {
                return pSAppModuleBase.getUserTag2() == null;
            }
            case 25: {
                return pSAppModuleBase.getUserTag3() == null;
            }
            case 26: {
                return pSAppModuleBase.getUserTag4() == null;
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
        return PSAppModuleBase.contains(this, n);
    }

    private static boolean contains(PSAppModuleBase pSAppModuleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppModuleBase.isCodeNameDirty();
            }
            case 1: {
                return pSAppModuleBase.isColorDirty();
            }
            case 2: {
                return pSAppModuleBase.isCreateDateDirty();
            }
            case 3: {
                return pSAppModuleBase.isCreateManDirty();
            }
            case 4: {
                return pSAppModuleBase.isDefaultFlagDirty();
            }
            case 5: {
                return pSAppModuleBase.isEnableModuleStyleDirty();
            }
            case 6: {
                return pSAppModuleBase.isFromObjIdDirty();
            }
            case 7: {
                return pSAppModuleBase.isMainMenuSideDirty();
            }
            case 8: {
                return pSAppModuleBase.isMemoDirty();
            }
            case 9: {
                return pSAppModuleBase.isModuleSNDirty();
            }
            case 10: {
                return pSAppModuleBase.isOrderValueDirty();
            }
            case 11: {
                return pSAppModuleBase.isPSAppMenuIdDirty();
            }
            case 12: {
                return pSAppModuleBase.isPSAppMenuNameDirty();
            }
            case 13: {
                return pSAppModuleBase.isPSAppModuleIdDirty();
            }
            case 14: {
                return pSAppModuleBase.isPSAppModuleNameDirty();
            }
            case 15: {
                return pSAppModuleBase.isPSModuleIdDirty();
            }
            case 16: {
                return pSAppModuleBase.isPSModuleNameDirty();
            }
            case 17: {
                return pSAppModuleBase.isPSSysAppIdDirty();
            }
            case 18: {
                return pSAppModuleBase.isPSSysAppNameDirty();
            }
            case 19: {
                return pSAppModuleBase.isUpdateDateDirty();
            }
            case 20: {
                return pSAppModuleBase.isUpdateManDirty();
            }
            case 21: {
                return pSAppModuleBase.isUserCatDirty();
            }
            case 22: {
                return pSAppModuleBase.isUserParamsDirty();
            }
            case 23: {
                return pSAppModuleBase.isUserTagDirty();
            }
            case 24: {
                return pSAppModuleBase.isUserTag2Dirty();
            }
            case 25: {
                return pSAppModuleBase.isUserTag3Dirty();
            }
            case 26: {
                return pSAppModuleBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSAppModuleBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSAppModuleBase pSAppModuleBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSAppModuleBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSAppModuleBase.getJSONValue((Object)pSAppModuleBase.getCodeName()), (boolean)false);
        }
        if (bl || pSAppModuleBase.getColor() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"color", (Object)PSAppModuleBase.getJSONValue((Object)pSAppModuleBase.getColor()), (boolean)false);
        }
        if (bl || pSAppModuleBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSAppModuleBase.getJSONValue((Object)pSAppModuleBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSAppModuleBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSAppModuleBase.getJSONValue((Object)pSAppModuleBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSAppModuleBase.getDefaultFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultflag", (Object)PSAppModuleBase.getJSONValue((Object)pSAppModuleBase.getDefaultFlag()), (boolean)false);
        }
        if (bl || pSAppModuleBase.getEnableModuleStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablemodulestyle", (Object)PSAppModuleBase.getJSONValue((Object)pSAppModuleBase.getEnableModuleStyle()), (boolean)false);
        }
        if (bl || pSAppModuleBase.getFromObjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fromobjid", (Object)PSAppModuleBase.getJSONValue((Object)pSAppModuleBase.getFromObjId()), (boolean)false);
        }
        if (bl || pSAppModuleBase.getMainMenuSide() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mainmenuside", (Object)PSAppModuleBase.getJSONValue((Object)pSAppModuleBase.getMainMenuSide()), (boolean)false);
        }
        if (bl || pSAppModuleBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSAppModuleBase.getJSONValue((Object)pSAppModuleBase.getMemo()), (boolean)false);
        }
        if (bl || pSAppModuleBase.getModuleSN() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modulesn", (Object)PSAppModuleBase.getJSONValue((Object)pSAppModuleBase.getModuleSN()), (boolean)false);
        }
        if (bl || pSAppModuleBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSAppModuleBase.getJSONValue((Object)pSAppModuleBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSAppModuleBase.getPSAppMenuId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappmenuid", (Object)PSAppModuleBase.getJSONValue((Object)pSAppModuleBase.getPSAppMenuId()), (boolean)false);
        }
        if (bl || pSAppModuleBase.getPSAppMenuName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappmenuname", (Object)PSAppModuleBase.getJSONValue((Object)pSAppModuleBase.getPSAppMenuName()), (boolean)false);
        }
        if (bl || pSAppModuleBase.getPSAppModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappmoduleid", (Object)PSAppModuleBase.getJSONValue((Object)pSAppModuleBase.getPSAppModuleId()), (boolean)false);
        }
        if (bl || pSAppModuleBase.getPSAppModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappmodulename", (Object)PSAppModuleBase.getJSONValue((Object)pSAppModuleBase.getPSAppModuleName()), (boolean)false);
        }
        if (bl || pSAppModuleBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSAppModuleBase.getJSONValue((Object)pSAppModuleBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSAppModuleBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSAppModuleBase.getJSONValue((Object)pSAppModuleBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSAppModuleBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSAppModuleBase.getJSONValue((Object)pSAppModuleBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSAppModuleBase.getPSSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappname", (Object)PSAppModuleBase.getJSONValue((Object)pSAppModuleBase.getPSSysAppName()), (boolean)false);
        }
        if (bl || pSAppModuleBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSAppModuleBase.getJSONValue((Object)pSAppModuleBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSAppModuleBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSAppModuleBase.getJSONValue((Object)pSAppModuleBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSAppModuleBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSAppModuleBase.getJSONValue((Object)pSAppModuleBase.getUserCat()), (boolean)false);
        }
        if (bl || pSAppModuleBase.getUserParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userparams", (Object)PSAppModuleBase.getJSONValue((Object)pSAppModuleBase.getUserParams()), (boolean)false);
        }
        if (bl || pSAppModuleBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSAppModuleBase.getJSONValue((Object)pSAppModuleBase.getUserTag()), (boolean)false);
        }
        if (bl || pSAppModuleBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSAppModuleBase.getJSONValue((Object)pSAppModuleBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSAppModuleBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSAppModuleBase.getJSONValue((Object)pSAppModuleBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSAppModuleBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSAppModuleBase.getJSONValue((Object)pSAppModuleBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSAppModuleBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSAppModuleBase pSAppModuleBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSAppModuleBase.getCodeName() != null) {
            object = pSAppModuleBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, (String)(object == null ? "" : object));
        }
        if (bl || pSAppModuleBase.getColor() != null) {
            object = pSAppModuleBase.getColor();
            xmlNode.setAttribute(FIELD_COLOR, object == null ? "" : (String)object);
        }
        if (bl || pSAppModuleBase.getCreateDate() != null) {
            object = pSAppModuleBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppModuleBase.getCreateMan() != null) {
            object = pSAppModuleBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppModuleBase.getDefaultFlag() != null) {
            object = pSAppModuleBase.getDefaultFlag();
            xmlNode.setAttribute(FIELD_DEFAULTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppModuleBase.getEnableModuleStyle() != null) {
            object = pSAppModuleBase.getEnableModuleStyle();
            xmlNode.setAttribute(FIELD_ENABLEMODULESTYLE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppModuleBase.getFromObjId() != null) {
            object = pSAppModuleBase.getFromObjId();
            xmlNode.setAttribute(FIELD_FROMOBJID, object == null ? "" : (String)object);
        }
        if (bl || pSAppModuleBase.getMainMenuSide() != null) {
            object = pSAppModuleBase.getMainMenuSide();
            xmlNode.setAttribute(FIELD_MAINMENUSIDE, object == null ? "" : (String)object);
        }
        if (bl || pSAppModuleBase.getMemo() != null) {
            object = pSAppModuleBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSAppModuleBase.getModuleSN() != null) {
            object = pSAppModuleBase.getModuleSN();
            xmlNode.setAttribute(FIELD_MODULESN, object == null ? "" : (String)object);
        }
        if (bl || pSAppModuleBase.getOrderValue() != null) {
            object = pSAppModuleBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppModuleBase.getPSAppMenuId() != null) {
            object = pSAppModuleBase.getPSAppMenuId();
            xmlNode.setAttribute(FIELD_PSAPPMENUID, object == null ? "" : (String)object);
        }
        if (bl || pSAppModuleBase.getPSAppMenuName() != null) {
            object = pSAppModuleBase.getPSAppMenuName();
            xmlNode.setAttribute(FIELD_PSAPPMENUNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppModuleBase.getPSAppModuleId() != null) {
            object = pSAppModuleBase.getPSAppModuleId();
            xmlNode.setAttribute(FIELD_PSAPPMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSAppModuleBase.getPSAppModuleName() != null) {
            object = pSAppModuleBase.getPSAppModuleName();
            xmlNode.setAttribute(FIELD_PSAPPMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppModuleBase.getPSModuleId() != null) {
            object = pSAppModuleBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSAppModuleBase.getPSModuleName() != null) {
            object = pSAppModuleBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppModuleBase.getPSSysAppId() != null) {
            object = pSAppModuleBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSAppModuleBase.getPSSysAppName() != null) {
            object = pSAppModuleBase.getPSSysAppName();
            xmlNode.setAttribute(FIELD_PSSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppModuleBase.getUpdateDate() != null) {
            object = pSAppModuleBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppModuleBase.getUpdateMan() != null) {
            object = pSAppModuleBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppModuleBase.getUserCat() != null) {
            object = pSAppModuleBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSAppModuleBase.getUserParams() != null) {
            object = pSAppModuleBase.getUserParams();
            xmlNode.setAttribute(FIELD_USERPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSAppModuleBase.getUserTag() != null) {
            object = pSAppModuleBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSAppModuleBase.getUserTag2() != null) {
            object = pSAppModuleBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSAppModuleBase.getUserTag3() != null) {
            object = pSAppModuleBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSAppModuleBase.getUserTag4() != null) {
            object = pSAppModuleBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSAppModuleBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSAppModuleBase pSAppModuleBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSAppModuleBase.isCodeNameDirty() && (bl || pSAppModuleBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSAppModuleBase.getCodeName());
        }
        if (pSAppModuleBase.isColorDirty() && (bl || pSAppModuleBase.getColor() != null)) {
            iDataObject.set(FIELD_COLOR, (Object)pSAppModuleBase.getColor());
        }
        if (pSAppModuleBase.isCreateDateDirty() && (bl || pSAppModuleBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSAppModuleBase.getCreateDate());
        }
        if (pSAppModuleBase.isCreateManDirty() && (bl || pSAppModuleBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSAppModuleBase.getCreateMan());
        }
        if (pSAppModuleBase.isDefaultFlagDirty() && (bl || pSAppModuleBase.getDefaultFlag() != null)) {
            iDataObject.set(FIELD_DEFAULTFLAG, (Object)pSAppModuleBase.getDefaultFlag());
        }
        if (pSAppModuleBase.isEnableModuleStyleDirty() && (bl || pSAppModuleBase.getEnableModuleStyle() != null)) {
            iDataObject.set(FIELD_ENABLEMODULESTYLE, (Object)pSAppModuleBase.getEnableModuleStyle());
        }
        if (pSAppModuleBase.isFromObjIdDirty() && (bl || pSAppModuleBase.getFromObjId() != null)) {
            iDataObject.set(FIELD_FROMOBJID, (Object)pSAppModuleBase.getFromObjId());
        }
        if (pSAppModuleBase.isMainMenuSideDirty() && (bl || pSAppModuleBase.getMainMenuSide() != null)) {
            iDataObject.set(FIELD_MAINMENUSIDE, (Object)pSAppModuleBase.getMainMenuSide());
        }
        if (pSAppModuleBase.isMemoDirty() && (bl || pSAppModuleBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSAppModuleBase.getMemo());
        }
        if (pSAppModuleBase.isModuleSNDirty() && (bl || pSAppModuleBase.getModuleSN() != null)) {
            iDataObject.set(FIELD_MODULESN, (Object)pSAppModuleBase.getModuleSN());
        }
        if (pSAppModuleBase.isOrderValueDirty() && (bl || pSAppModuleBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSAppModuleBase.getOrderValue());
        }
        if (pSAppModuleBase.isPSAppMenuIdDirty() && (bl || pSAppModuleBase.getPSAppMenuId() != null)) {
            iDataObject.set(FIELD_PSAPPMENUID, (Object)pSAppModuleBase.getPSAppMenuId());
        }
        if (pSAppModuleBase.isPSAppMenuNameDirty() && (bl || pSAppModuleBase.getPSAppMenuName() != null)) {
            iDataObject.set(FIELD_PSAPPMENUNAME, (Object)pSAppModuleBase.getPSAppMenuName());
        }
        if (pSAppModuleBase.isPSAppModuleIdDirty() && (bl || pSAppModuleBase.getPSAppModuleId() != null)) {
            iDataObject.set(FIELD_PSAPPMODULEID, (Object)pSAppModuleBase.getPSAppModuleId());
        }
        if (pSAppModuleBase.isPSAppModuleNameDirty() && (bl || pSAppModuleBase.getPSAppModuleName() != null)) {
            iDataObject.set(FIELD_PSAPPMODULENAME, (Object)pSAppModuleBase.getPSAppModuleName());
        }
        if (pSAppModuleBase.isPSModuleIdDirty() && (bl || pSAppModuleBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSAppModuleBase.getPSModuleId());
        }
        if (pSAppModuleBase.isPSModuleNameDirty() && (bl || pSAppModuleBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSAppModuleBase.getPSModuleName());
        }
        if (pSAppModuleBase.isPSSysAppIdDirty() && (bl || pSAppModuleBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSAppModuleBase.getPSSysAppId());
        }
        if (pSAppModuleBase.isPSSysAppNameDirty() && (bl || pSAppModuleBase.getPSSysAppName() != null)) {
            iDataObject.set(FIELD_PSSYSAPPNAME, (Object)pSAppModuleBase.getPSSysAppName());
        }
        if (pSAppModuleBase.isUpdateDateDirty() && (bl || pSAppModuleBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSAppModuleBase.getUpdateDate());
        }
        if (pSAppModuleBase.isUpdateManDirty() && (bl || pSAppModuleBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSAppModuleBase.getUpdateMan());
        }
        if (pSAppModuleBase.isUserCatDirty() && (bl || pSAppModuleBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSAppModuleBase.getUserCat());
        }
        if (pSAppModuleBase.isUserParamsDirty() && (bl || pSAppModuleBase.getUserParams() != null)) {
            iDataObject.set(FIELD_USERPARAMS, (Object)pSAppModuleBase.getUserParams());
        }
        if (pSAppModuleBase.isUserTagDirty() && (bl || pSAppModuleBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSAppModuleBase.getUserTag());
        }
        if (pSAppModuleBase.isUserTag2Dirty() && (bl || pSAppModuleBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSAppModuleBase.getUserTag2());
        }
        if (pSAppModuleBase.isUserTag3Dirty() && (bl || pSAppModuleBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSAppModuleBase.getUserTag3());
        }
        if (pSAppModuleBase.isUserTag4Dirty() && (bl || pSAppModuleBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSAppModuleBase.getUserTag4());
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
        return PSAppModuleBase.remove(this, n);
    }

    private static boolean remove(PSAppModuleBase pSAppModuleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSAppModuleBase.resetCodeName();
                return true;
            }
            case 1: {
                pSAppModuleBase.resetColor();
                return true;
            }
            case 2: {
                pSAppModuleBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSAppModuleBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSAppModuleBase.resetDefaultFlag();
                return true;
            }
            case 5: {
                pSAppModuleBase.resetEnableModuleStyle();
                return true;
            }
            case 6: {
                pSAppModuleBase.resetFromObjId();
                return true;
            }
            case 7: {
                pSAppModuleBase.resetMainMenuSide();
                return true;
            }
            case 8: {
                pSAppModuleBase.resetMemo();
                return true;
            }
            case 9: {
                pSAppModuleBase.resetModuleSN();
                return true;
            }
            case 10: {
                pSAppModuleBase.resetOrderValue();
                return true;
            }
            case 11: {
                pSAppModuleBase.resetPSAppMenuId();
                return true;
            }
            case 12: {
                pSAppModuleBase.resetPSAppMenuName();
                return true;
            }
            case 13: {
                pSAppModuleBase.resetPSAppModuleId();
                return true;
            }
            case 14: {
                pSAppModuleBase.resetPSAppModuleName();
                return true;
            }
            case 15: {
                pSAppModuleBase.resetPSModuleId();
                return true;
            }
            case 16: {
                pSAppModuleBase.resetPSModuleName();
                return true;
            }
            case 17: {
                pSAppModuleBase.resetPSSysAppId();
                return true;
            }
            case 18: {
                pSAppModuleBase.resetPSSysAppName();
                return true;
            }
            case 19: {
                pSAppModuleBase.resetUpdateDate();
                return true;
            }
            case 20: {
                pSAppModuleBase.resetUpdateMan();
                return true;
            }
            case 21: {
                pSAppModuleBase.resetUserCat();
                return true;
            }
            case 22: {
                pSAppModuleBase.resetUserParams();
                return true;
            }
            case 23: {
                pSAppModuleBase.resetUserTag();
                return true;
            }
            case 24: {
                pSAppModuleBase.resetUserTag2();
                return true;
            }
            case 25: {
                pSAppModuleBase.resetUserTag3();
                return true;
            }
            case 26: {
                pSAppModuleBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSAppMenu getPSAppMenu() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppMenu();
        }
        if (this.getPSAppMenuId() == null) {
            return null;
        }
        Integer n = this.objPSAppMenuLock;
        synchronized (n) {
            if (this.psappmenu != null && DataTypeHelper.compare((int)25, (Object)this.getPSAppMenuId(), (Object)this.psappmenu.getPSAppMenuId()) != 0L) {
                this.psappmenu = null;
            }
            if (this.psappmenu == null) {
                PSAppMenu pSAppMenu = new PSAppMenu();
                pSAppMenu.setPSAppMenuId(this.getPSAppMenuId());
                PSAppMenuService pSAppMenuService = (PSAppMenuService)ServiceGlobal.getService(PSAppMenuService.class, (SessionFactory)this.getSessionFactory());
                pSAppMenuService.autoGet(pSAppMenu);
                this.psappmenu = pSAppMenu;
            }
            return this.psappmenu;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSModule getPSModule() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModule();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        Integer n = this.objPSModuleLock;
        synchronized (n) {
            if (this.psmodule != null && DataTypeHelper.compare((int)25, (Object)this.getPSModuleId(), (Object)this.psmodule.getPSModuleId()) != 0L) {
                this.psmodule = null;
            }
            if (this.psmodule == null) {
                PSModule pSModule = new PSModule();
                pSModule.setPSModuleId(this.getPSModuleId());
                PSModuleService pSModuleService = (PSModuleService)ServiceGlobal.getService(PSModuleService.class, (SessionFactory)this.getSessionFactory());
                pSModuleService.autoGet(pSModule);
                this.psmodule = pSModule;
            }
            return this.psmodule;
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
    public ArrayList<PSAppWF> getPSAppWFs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppWFs();
        }
        if (this.getPSAppModuleId() == null) {
            return null;
        }
        PSAppWFService pSAppWFService = (PSAppWFService)ServiceGlobal.getService(PSAppWFService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSAppWFsLock;
        synchronized (n) {
            if (this.psappwfs == null) {
                this.psappwfs = pSAppWFService.selectByPSAppModule(this);
            }
            return this.psappwfs;
        }
    }

    private PSAppModuleBase getProxyEntity() {
        return this.proxyPSAppModuleBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSAppModuleBase = null;
        if (iDataObject != null && iDataObject instanceof PSAppModuleBase) {
            this.proxyPSAppModuleBase = (PSAppModuleBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppModuleService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_COLOR, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_DEFAULTFLAG, 4);
        fieldIndexMap.put(FIELD_ENABLEMODULESTYLE, 5);
        fieldIndexMap.put(FIELD_FROMOBJID, 6);
        fieldIndexMap.put(FIELD_MAINMENUSIDE, 7);
        fieldIndexMap.put(FIELD_MEMO, 8);
        fieldIndexMap.put(FIELD_MODULESN, 9);
        fieldIndexMap.put(FIELD_ORDERVALUE, 10);
        fieldIndexMap.put(FIELD_PSAPPMENUID, 11);
        fieldIndexMap.put(FIELD_PSAPPMENUNAME, 12);
        fieldIndexMap.put(FIELD_PSAPPMODULEID, 13);
        fieldIndexMap.put(FIELD_PSAPPMODULENAME, 14);
        fieldIndexMap.put(FIELD_PSMODULEID, 15);
        fieldIndexMap.put(FIELD_PSMODULENAME, 16);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 17);
        fieldIndexMap.put(FIELD_PSSYSAPPNAME, 18);
        fieldIndexMap.put(FIELD_UPDATEDATE, 19);
        fieldIndexMap.put(FIELD_UPDATEMAN, 20);
        fieldIndexMap.put(FIELD_USERCAT, 21);
        fieldIndexMap.put(FIELD_USERPARAMS, 22);
        fieldIndexMap.put(FIELD_USERTAG, 23);
        fieldIndexMap.put(FIELD_USERTAG2, 24);
        fieldIndexMap.put(FIELD_USERTAG3, 25);
        fieldIndexMap.put(FIELD_USERTAG4, 26);
    }
}

