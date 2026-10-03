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
package net.ibizsys.pscore.srv.sysdesign.entity;

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
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysChartThemeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysChartThemeBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSCHARTTHEMEID = "PSSYSCHARTTHEMEID";
    public static final String FIELD_PSSYSCHARTTHEMENAME = "PSSYSCHARTTHEMENAME";
    public static final String FIELD_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String FIELD_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_THEMEDESC = "THEMEDESC";
    public static final String FIELD_THEMEPARAMS = "THEMEPARAMS";
    public static final String FIELD_THEMETAG = "THEMETAG";
    public static final String FIELD_THEMETAG2 = "THEMETAG2";
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
    private static final int INDEX_ORDERVALUE = 5;
    private static final int INDEX_PSMODULEID = 6;
    private static final int INDEX_PSMODULENAME = 7;
    private static final int INDEX_PSSYSCHARTTHEMEID = 8;
    private static final int INDEX_PSSYSCHARTTHEMENAME = 9;
    private static final int INDEX_PSSYSDYNAMODELID = 10;
    private static final int INDEX_PSSYSDYNAMODELNAME = 11;
    private static final int INDEX_PSSYSTEMID = 12;
    private static final int INDEX_PSSYSTEMNAME = 13;
    private static final int INDEX_THEMEDESC = 14;
    private static final int INDEX_THEMEPARAMS = 15;
    private static final int INDEX_THEMETAG = 16;
    private static final int INDEX_THEMETAG2 = 17;
    private static final int INDEX_UPDATEDATE = 18;
    private static final int INDEX_UPDATEMAN = 19;
    private static final int INDEX_USERCAT = 20;
    private static final int INDEX_USERTAG = 21;
    private static final int INDEX_USERTAG2 = 22;
    private static final int INDEX_USERTAG3 = 23;
    private static final int INDEX_USERTAG4 = 24;
    private static final int INDEX_VALIDFLAG = 25;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysChartThemeBase proxyPSSysChartThemeBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean defaultflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssyschartthemeidDirtyFlag = false;
    private boolean pssyschartthemenameDirtyFlag = false;
    private boolean pssysdynamodelidDirtyFlag = false;
    private boolean pssysdynamodelnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean themedescDirtyFlag = false;
    private boolean themeparamsDirtyFlag = false;
    private boolean themetagDirtyFlag = false;
    private boolean themetag2DirtyFlag = false;
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
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssyschartthemeid")
    private String pssyschartthemeid;
    @Column(name="pssyschartthemename")
    private String pssyschartthemename;
    @Column(name="pssysdynamodelid")
    private String pssysdynamodelid;
    @Column(name="pssysdynamodelname")
    private String pssysdynamodelname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="themedesc")
    private String themedesc;
    @Column(name="themeparams")
    private String themeparams;
    @Column(name="themetag")
    private String themetag;
    @Column(name="themetag2")
    private String themetag2;
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
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel pssysdynamodel = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;

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

    public void setPSSysChartThemeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysChartThemeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyschartthemeid = string;
        this.pssyschartthemeidDirtyFlag = true;
    }

    public String getPSSysChartThemeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysChartThemeId();
        }
        return this.pssyschartthemeid;
    }

    public boolean isPSSysChartThemeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysChartThemeIdDirty();
        }
        return this.pssyschartthemeidDirtyFlag;
    }

    public void resetPSSysChartThemeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysChartThemeId();
            return;
        }
        this.pssyschartthemeidDirtyFlag = false;
        this.pssyschartthemeid = null;
    }

    public void setPSSysChartThemeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysChartThemeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyschartthemename = string;
        this.pssyschartthemenameDirtyFlag = true;
    }

    public String getPSSysChartThemeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysChartThemeName();
        }
        return this.pssyschartthemename;
    }

    public boolean isPSSysChartThemeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysChartThemeNameDirty();
        }
        return this.pssyschartthemenameDirtyFlag;
    }

    public void resetPSSysChartThemeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysChartThemeName();
            return;
        }
        this.pssyschartthemenameDirtyFlag = false;
        this.pssyschartthemename = null;
    }

    public void setPSSysDynaModelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDynaModelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdynamodelid = string;
        this.pssysdynamodelidDirtyFlag = true;
    }

    public String getPSSysDynaModelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModelId();
        }
        return this.pssysdynamodelid;
    }

    public boolean isPSSysDynaModelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDynaModelIdDirty();
        }
        return this.pssysdynamodelidDirtyFlag;
    }

    public void resetPSSysDynaModelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDynaModelId();
            return;
        }
        this.pssysdynamodelidDirtyFlag = false;
        this.pssysdynamodelid = null;
    }

    public void setPSSysDynaModelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDynaModelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdynamodelname = string;
        this.pssysdynamodelnameDirtyFlag = true;
    }

    public String getPSSysDynaModelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModelName();
        }
        return this.pssysdynamodelname;
    }

    public boolean isPSSysDynaModelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDynaModelNameDirty();
        }
        return this.pssysdynamodelnameDirtyFlag;
    }

    public void resetPSSysDynaModelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDynaModelName();
            return;
        }
        this.pssysdynamodelnameDirtyFlag = false;
        this.pssysdynamodelname = null;
    }

    public void setPSSystemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemid = string;
        this.pssystemidDirtyFlag = true;
    }

    public String getPSSystemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemId();
        }
        return this.pssystemid;
    }

    public boolean isPSSystemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemIdDirty();
        }
        return this.pssystemidDirtyFlag;
    }

    public void resetPSSystemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemId();
            return;
        }
        this.pssystemidDirtyFlag = false;
        this.pssystemid = null;
    }

    public void setPSSystemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemname = string;
        this.pssystemnameDirtyFlag = true;
    }

    public String getPSSystemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemName();
        }
        return this.pssystemname;
    }

    public boolean isPSSystemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemNameDirty();
        }
        return this.pssystemnameDirtyFlag;
    }

    public void resetPSSystemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemName();
            return;
        }
        this.pssystemnameDirtyFlag = false;
        this.pssystemname = null;
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

    public void setThemeTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setThemeTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.themetag2 = string;
        this.themetag2DirtyFlag = true;
    }

    public String getThemeTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getThemeTag2();
        }
        return this.themetag2;
    }

    public boolean isThemeTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isThemeTag2Dirty();
        }
        return this.themetag2DirtyFlag;
    }

    public void resetThemeTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetThemeTag2();
            return;
        }
        this.themetag2DirtyFlag = false;
        this.themetag2 = null;
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
        PSSysChartThemeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysChartThemeBase pSSysChartThemeBase) {
        pSSysChartThemeBase.resetCodeName();
        pSSysChartThemeBase.resetCreateDate();
        pSSysChartThemeBase.resetCreateMan();
        pSSysChartThemeBase.resetDefaultFlag();
        pSSysChartThemeBase.resetMemo();
        pSSysChartThemeBase.resetOrderValue();
        pSSysChartThemeBase.resetPSModuleId();
        pSSysChartThemeBase.resetPSModuleName();
        pSSysChartThemeBase.resetPSSysChartThemeId();
        pSSysChartThemeBase.resetPSSysChartThemeName();
        pSSysChartThemeBase.resetPSSysDynaModelId();
        pSSysChartThemeBase.resetPSSysDynaModelName();
        pSSysChartThemeBase.resetPSSystemId();
        pSSysChartThemeBase.resetPSSystemName();
        pSSysChartThemeBase.resetThemeDesc();
        pSSysChartThemeBase.resetThemeParams();
        pSSysChartThemeBase.resetThemeTag();
        pSSysChartThemeBase.resetThemeTag2();
        pSSysChartThemeBase.resetUpdateDate();
        pSSysChartThemeBase.resetUpdateMan();
        pSSysChartThemeBase.resetUserCat();
        pSSysChartThemeBase.resetUserTag();
        pSSysChartThemeBase.resetUserTag2();
        pSSysChartThemeBase.resetUserTag3();
        pSSysChartThemeBase.resetUserTag4();
        pSSysChartThemeBase.resetValidFlag();
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
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSModuleIdDirty()) {
            hashMap.put(FIELD_PSMODULEID, this.getPSModuleId());
        }
        if (!bl || this.isPSModuleNameDirty()) {
            hashMap.put(FIELD_PSMODULENAME, this.getPSModuleName());
        }
        if (!bl || this.isPSSysChartThemeIdDirty()) {
            hashMap.put(FIELD_PSSYSCHARTTHEMEID, this.getPSSysChartThemeId());
        }
        if (!bl || this.isPSSysChartThemeNameDirty()) {
            hashMap.put(FIELD_PSSYSCHARTTHEMENAME, this.getPSSysChartThemeName());
        }
        if (!bl || this.isPSSysDynaModelIdDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELID, this.getPSSysDynaModelId());
        }
        if (!bl || this.isPSSysDynaModelNameDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELNAME, this.getPSSysDynaModelName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
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
        if (!bl || this.isThemeTag2Dirty()) {
            hashMap.put(FIELD_THEMETAG2, this.getThemeTag2());
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
        return PSSysChartThemeBase.get(this, n);
    }

    private static Object get(PSSysChartThemeBase pSSysChartThemeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysChartThemeBase.getCodeName();
            }
            case 1: {
                return pSSysChartThemeBase.getCreateDate();
            }
            case 2: {
                return pSSysChartThemeBase.getCreateMan();
            }
            case 3: {
                return pSSysChartThemeBase.getDefaultFlag();
            }
            case 4: {
                return pSSysChartThemeBase.getMemo();
            }
            case 5: {
                return pSSysChartThemeBase.getOrderValue();
            }
            case 6: {
                return pSSysChartThemeBase.getPSModuleId();
            }
            case 7: {
                return pSSysChartThemeBase.getPSModuleName();
            }
            case 8: {
                return pSSysChartThemeBase.getPSSysChartThemeId();
            }
            case 9: {
                return pSSysChartThemeBase.getPSSysChartThemeName();
            }
            case 10: {
                return pSSysChartThemeBase.getPSSysDynaModelId();
            }
            case 11: {
                return pSSysChartThemeBase.getPSSysDynaModelName();
            }
            case 12: {
                return pSSysChartThemeBase.getPSSystemId();
            }
            case 13: {
                return pSSysChartThemeBase.getPSSystemName();
            }
            case 14: {
                return pSSysChartThemeBase.getThemeDesc();
            }
            case 15: {
                return pSSysChartThemeBase.getThemeParams();
            }
            case 16: {
                return pSSysChartThemeBase.getThemeTag();
            }
            case 17: {
                return pSSysChartThemeBase.getThemeTag2();
            }
            case 18: {
                return pSSysChartThemeBase.getUpdateDate();
            }
            case 19: {
                return pSSysChartThemeBase.getUpdateMan();
            }
            case 20: {
                return pSSysChartThemeBase.getUserCat();
            }
            case 21: {
                return pSSysChartThemeBase.getUserTag();
            }
            case 22: {
                return pSSysChartThemeBase.getUserTag2();
            }
            case 23: {
                return pSSysChartThemeBase.getUserTag3();
            }
            case 24: {
                return pSSysChartThemeBase.getUserTag4();
            }
            case 25: {
                return pSSysChartThemeBase.getValidFlag();
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
        PSSysChartThemeBase.set(this, n, object);
    }

    private static void set(PSSysChartThemeBase pSSysChartThemeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysChartThemeBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysChartThemeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysChartThemeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysChartThemeBase.setDefaultFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSSysChartThemeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysChartThemeBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSSysChartThemeBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysChartThemeBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysChartThemeBase.setPSSysChartThemeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysChartThemeBase.setPSSysChartThemeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysChartThemeBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysChartThemeBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysChartThemeBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysChartThemeBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysChartThemeBase.setThemeDesc(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysChartThemeBase.setThemeParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysChartThemeBase.setThemeTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysChartThemeBase.setThemeTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysChartThemeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 19: {
                pSSysChartThemeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysChartThemeBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysChartThemeBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysChartThemeBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysChartThemeBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysChartThemeBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysChartThemeBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSysChartThemeBase.isNull(this, n);
    }

    private static boolean isNull(PSSysChartThemeBase pSSysChartThemeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysChartThemeBase.getCodeName() == null;
            }
            case 1: {
                return pSSysChartThemeBase.getCreateDate() == null;
            }
            case 2: {
                return pSSysChartThemeBase.getCreateMan() == null;
            }
            case 3: {
                return pSSysChartThemeBase.getDefaultFlag() == null;
            }
            case 4: {
                return pSSysChartThemeBase.getMemo() == null;
            }
            case 5: {
                return pSSysChartThemeBase.getOrderValue() == null;
            }
            case 6: {
                return pSSysChartThemeBase.getPSModuleId() == null;
            }
            case 7: {
                return pSSysChartThemeBase.getPSModuleName() == null;
            }
            case 8: {
                return pSSysChartThemeBase.getPSSysChartThemeId() == null;
            }
            case 9: {
                return pSSysChartThemeBase.getPSSysChartThemeName() == null;
            }
            case 10: {
                return pSSysChartThemeBase.getPSSysDynaModelId() == null;
            }
            case 11: {
                return pSSysChartThemeBase.getPSSysDynaModelName() == null;
            }
            case 12: {
                return pSSysChartThemeBase.getPSSystemId() == null;
            }
            case 13: {
                return pSSysChartThemeBase.getPSSystemName() == null;
            }
            case 14: {
                return pSSysChartThemeBase.getThemeDesc() == null;
            }
            case 15: {
                return pSSysChartThemeBase.getThemeParams() == null;
            }
            case 16: {
                return pSSysChartThemeBase.getThemeTag() == null;
            }
            case 17: {
                return pSSysChartThemeBase.getThemeTag2() == null;
            }
            case 18: {
                return pSSysChartThemeBase.getUpdateDate() == null;
            }
            case 19: {
                return pSSysChartThemeBase.getUpdateMan() == null;
            }
            case 20: {
                return pSSysChartThemeBase.getUserCat() == null;
            }
            case 21: {
                return pSSysChartThemeBase.getUserTag() == null;
            }
            case 22: {
                return pSSysChartThemeBase.getUserTag2() == null;
            }
            case 23: {
                return pSSysChartThemeBase.getUserTag3() == null;
            }
            case 24: {
                return pSSysChartThemeBase.getUserTag4() == null;
            }
            case 25: {
                return pSSysChartThemeBase.getValidFlag() == null;
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
        return PSSysChartThemeBase.contains(this, n);
    }

    private static boolean contains(PSSysChartThemeBase pSSysChartThemeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysChartThemeBase.isCodeNameDirty();
            }
            case 1: {
                return pSSysChartThemeBase.isCreateDateDirty();
            }
            case 2: {
                return pSSysChartThemeBase.isCreateManDirty();
            }
            case 3: {
                return pSSysChartThemeBase.isDefaultFlagDirty();
            }
            case 4: {
                return pSSysChartThemeBase.isMemoDirty();
            }
            case 5: {
                return pSSysChartThemeBase.isOrderValueDirty();
            }
            case 6: {
                return pSSysChartThemeBase.isPSModuleIdDirty();
            }
            case 7: {
                return pSSysChartThemeBase.isPSModuleNameDirty();
            }
            case 8: {
                return pSSysChartThemeBase.isPSSysChartThemeIdDirty();
            }
            case 9: {
                return pSSysChartThemeBase.isPSSysChartThemeNameDirty();
            }
            case 10: {
                return pSSysChartThemeBase.isPSSysDynaModelIdDirty();
            }
            case 11: {
                return pSSysChartThemeBase.isPSSysDynaModelNameDirty();
            }
            case 12: {
                return pSSysChartThemeBase.isPSSystemIdDirty();
            }
            case 13: {
                return pSSysChartThemeBase.isPSSystemNameDirty();
            }
            case 14: {
                return pSSysChartThemeBase.isThemeDescDirty();
            }
            case 15: {
                return pSSysChartThemeBase.isThemeParamsDirty();
            }
            case 16: {
                return pSSysChartThemeBase.isThemeTagDirty();
            }
            case 17: {
                return pSSysChartThemeBase.isThemeTag2Dirty();
            }
            case 18: {
                return pSSysChartThemeBase.isUpdateDateDirty();
            }
            case 19: {
                return pSSysChartThemeBase.isUpdateManDirty();
            }
            case 20: {
                return pSSysChartThemeBase.isUserCatDirty();
            }
            case 21: {
                return pSSysChartThemeBase.isUserTagDirty();
            }
            case 22: {
                return pSSysChartThemeBase.isUserTag2Dirty();
            }
            case 23: {
                return pSSysChartThemeBase.isUserTag3Dirty();
            }
            case 24: {
                return pSSysChartThemeBase.isUserTag4Dirty();
            }
            case 25: {
                return pSSysChartThemeBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysChartThemeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysChartThemeBase pSSysChartThemeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysChartThemeBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysChartThemeBase.getJSONValue((Object)pSSysChartThemeBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysChartThemeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysChartThemeBase.getJSONValue((Object)pSSysChartThemeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysChartThemeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysChartThemeBase.getJSONValue((Object)pSSysChartThemeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysChartThemeBase.getDefaultFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultflag", (Object)PSSysChartThemeBase.getJSONValue((Object)pSSysChartThemeBase.getDefaultFlag()), (boolean)false);
        }
        if (bl || pSSysChartThemeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysChartThemeBase.getJSONValue((Object)pSSysChartThemeBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysChartThemeBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSysChartThemeBase.getJSONValue((Object)pSSysChartThemeBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSysChartThemeBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSSysChartThemeBase.getJSONValue((Object)pSSysChartThemeBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSSysChartThemeBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSSysChartThemeBase.getJSONValue((Object)pSSysChartThemeBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSSysChartThemeBase.getPSSysChartThemeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyschartthemeid", (Object)PSSysChartThemeBase.getJSONValue((Object)pSSysChartThemeBase.getPSSysChartThemeId()), (boolean)false);
        }
        if (bl || pSSysChartThemeBase.getPSSysChartThemeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyschartthemename", (Object)PSSysChartThemeBase.getJSONValue((Object)pSSysChartThemeBase.getPSSysChartThemeName()), (boolean)false);
        }
        if (bl || pSSysChartThemeBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSSysChartThemeBase.getJSONValue((Object)pSSysChartThemeBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSSysChartThemeBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSSysChartThemeBase.getJSONValue((Object)pSSysChartThemeBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSSysChartThemeBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysChartThemeBase.getJSONValue((Object)pSSysChartThemeBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysChartThemeBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysChartThemeBase.getJSONValue((Object)pSSysChartThemeBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysChartThemeBase.getThemeDesc() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"themedesc", (Object)PSSysChartThemeBase.getJSONValue((Object)pSSysChartThemeBase.getThemeDesc()), (boolean)false);
        }
        if (bl || pSSysChartThemeBase.getThemeParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"themeparams", (Object)PSSysChartThemeBase.getJSONValue((Object)pSSysChartThemeBase.getThemeParams()), (boolean)false);
        }
        if (bl || pSSysChartThemeBase.getThemeTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"themetag", (Object)PSSysChartThemeBase.getJSONValue((Object)pSSysChartThemeBase.getThemeTag()), (boolean)false);
        }
        if (bl || pSSysChartThemeBase.getThemeTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"themetag2", (Object)PSSysChartThemeBase.getJSONValue((Object)pSSysChartThemeBase.getThemeTag2()), (boolean)false);
        }
        if (bl || pSSysChartThemeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysChartThemeBase.getJSONValue((Object)pSSysChartThemeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysChartThemeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysChartThemeBase.getJSONValue((Object)pSSysChartThemeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysChartThemeBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysChartThemeBase.getJSONValue((Object)pSSysChartThemeBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysChartThemeBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysChartThemeBase.getJSONValue((Object)pSSysChartThemeBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysChartThemeBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysChartThemeBase.getJSONValue((Object)pSSysChartThemeBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysChartThemeBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysChartThemeBase.getJSONValue((Object)pSSysChartThemeBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysChartThemeBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysChartThemeBase.getJSONValue((Object)pSSysChartThemeBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysChartThemeBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysChartThemeBase.getJSONValue((Object)pSSysChartThemeBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysChartThemeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysChartThemeBase pSSysChartThemeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysChartThemeBase.getCodeName() != null) {
            object = pSSysChartThemeBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysChartThemeBase.getCreateDate() != null) {
            object = pSSysChartThemeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysChartThemeBase.getCreateMan() != null) {
            object = pSSysChartThemeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysChartThemeBase.getDefaultFlag() != null) {
            object = pSSysChartThemeBase.getDefaultFlag();
            xmlNode.setAttribute(FIELD_DEFAULTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysChartThemeBase.getMemo() != null) {
            object = pSSysChartThemeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysChartThemeBase.getOrderValue() != null) {
            object = pSSysChartThemeBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysChartThemeBase.getPSModuleId() != null) {
            object = pSSysChartThemeBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysChartThemeBase.getPSModuleName() != null) {
            object = pSSysChartThemeBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysChartThemeBase.getPSSysChartThemeId() != null) {
            object = pSSysChartThemeBase.getPSSysChartThemeId();
            xmlNode.setAttribute(FIELD_PSSYSCHARTTHEMEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysChartThemeBase.getPSSysChartThemeName() != null) {
            object = pSSysChartThemeBase.getPSSysChartThemeName();
            xmlNode.setAttribute(FIELD_PSSYSCHARTTHEMENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysChartThemeBase.getPSSysDynaModelId() != null) {
            object = pSSysChartThemeBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSSysChartThemeBase.getPSSysDynaModelName() != null) {
            object = pSSysChartThemeBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysChartThemeBase.getPSSystemId() != null) {
            object = pSSysChartThemeBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysChartThemeBase.getPSSystemName() != null) {
            object = pSSysChartThemeBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysChartThemeBase.getThemeDesc() != null) {
            object = pSSysChartThemeBase.getThemeDesc();
            xmlNode.setAttribute(FIELD_THEMEDESC, object == null ? "" : (String)object);
        }
        if (bl || pSSysChartThemeBase.getThemeParams() != null) {
            object = pSSysChartThemeBase.getThemeParams();
            xmlNode.setAttribute(FIELD_THEMEPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSSysChartThemeBase.getThemeTag() != null) {
            object = pSSysChartThemeBase.getThemeTag();
            xmlNode.setAttribute(FIELD_THEMETAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysChartThemeBase.getThemeTag2() != null) {
            object = pSSysChartThemeBase.getThemeTag2();
            xmlNode.setAttribute(FIELD_THEMETAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysChartThemeBase.getUpdateDate() != null) {
            object = pSSysChartThemeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysChartThemeBase.getUpdateMan() != null) {
            object = pSSysChartThemeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysChartThemeBase.getUserCat() != null) {
            object = pSSysChartThemeBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysChartThemeBase.getUserTag() != null) {
            object = pSSysChartThemeBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysChartThemeBase.getUserTag2() != null) {
            object = pSSysChartThemeBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysChartThemeBase.getUserTag3() != null) {
            object = pSSysChartThemeBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysChartThemeBase.getUserTag4() != null) {
            object = pSSysChartThemeBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysChartThemeBase.getValidFlag() != null) {
            object = pSSysChartThemeBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysChartThemeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysChartThemeBase pSSysChartThemeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysChartThemeBase.isCodeNameDirty() && (bl || pSSysChartThemeBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysChartThemeBase.getCodeName());
        }
        if (pSSysChartThemeBase.isCreateDateDirty() && (bl || pSSysChartThemeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysChartThemeBase.getCreateDate());
        }
        if (pSSysChartThemeBase.isCreateManDirty() && (bl || pSSysChartThemeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysChartThemeBase.getCreateMan());
        }
        if (pSSysChartThemeBase.isDefaultFlagDirty() && (bl || pSSysChartThemeBase.getDefaultFlag() != null)) {
            iDataObject.set(FIELD_DEFAULTFLAG, (Object)pSSysChartThemeBase.getDefaultFlag());
        }
        if (pSSysChartThemeBase.isMemoDirty() && (bl || pSSysChartThemeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysChartThemeBase.getMemo());
        }
        if (pSSysChartThemeBase.isOrderValueDirty() && (bl || pSSysChartThemeBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSysChartThemeBase.getOrderValue());
        }
        if (pSSysChartThemeBase.isPSModuleIdDirty() && (bl || pSSysChartThemeBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSSysChartThemeBase.getPSModuleId());
        }
        if (pSSysChartThemeBase.isPSModuleNameDirty() && (bl || pSSysChartThemeBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSSysChartThemeBase.getPSModuleName());
        }
        if (pSSysChartThemeBase.isPSSysChartThemeIdDirty() && (bl || pSSysChartThemeBase.getPSSysChartThemeId() != null)) {
            iDataObject.set(FIELD_PSSYSCHARTTHEMEID, (Object)pSSysChartThemeBase.getPSSysChartThemeId());
        }
        if (pSSysChartThemeBase.isPSSysChartThemeNameDirty() && (bl || pSSysChartThemeBase.getPSSysChartThemeName() != null)) {
            iDataObject.set(FIELD_PSSYSCHARTTHEMENAME, (Object)pSSysChartThemeBase.getPSSysChartThemeName());
        }
        if (pSSysChartThemeBase.isPSSysDynaModelIdDirty() && (bl || pSSysChartThemeBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSSysChartThemeBase.getPSSysDynaModelId());
        }
        if (pSSysChartThemeBase.isPSSysDynaModelNameDirty() && (bl || pSSysChartThemeBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSSysChartThemeBase.getPSSysDynaModelName());
        }
        if (pSSysChartThemeBase.isPSSystemIdDirty() && (bl || pSSysChartThemeBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysChartThemeBase.getPSSystemId());
        }
        if (pSSysChartThemeBase.isPSSystemNameDirty() && (bl || pSSysChartThemeBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysChartThemeBase.getPSSystemName());
        }
        if (pSSysChartThemeBase.isThemeDescDirty() && (bl || pSSysChartThemeBase.getThemeDesc() != null)) {
            iDataObject.set(FIELD_THEMEDESC, (Object)pSSysChartThemeBase.getThemeDesc());
        }
        if (pSSysChartThemeBase.isThemeParamsDirty() && (bl || pSSysChartThemeBase.getThemeParams() != null)) {
            iDataObject.set(FIELD_THEMEPARAMS, (Object)pSSysChartThemeBase.getThemeParams());
        }
        if (pSSysChartThemeBase.isThemeTagDirty() && (bl || pSSysChartThemeBase.getThemeTag() != null)) {
            iDataObject.set(FIELD_THEMETAG, (Object)pSSysChartThemeBase.getThemeTag());
        }
        if (pSSysChartThemeBase.isThemeTag2Dirty() && (bl || pSSysChartThemeBase.getThemeTag2() != null)) {
            iDataObject.set(FIELD_THEMETAG2, (Object)pSSysChartThemeBase.getThemeTag2());
        }
        if (pSSysChartThemeBase.isUpdateDateDirty() && (bl || pSSysChartThemeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysChartThemeBase.getUpdateDate());
        }
        if (pSSysChartThemeBase.isUpdateManDirty() && (bl || pSSysChartThemeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysChartThemeBase.getUpdateMan());
        }
        if (pSSysChartThemeBase.isUserCatDirty() && (bl || pSSysChartThemeBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysChartThemeBase.getUserCat());
        }
        if (pSSysChartThemeBase.isUserTagDirty() && (bl || pSSysChartThemeBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysChartThemeBase.getUserTag());
        }
        if (pSSysChartThemeBase.isUserTag2Dirty() && (bl || pSSysChartThemeBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysChartThemeBase.getUserTag2());
        }
        if (pSSysChartThemeBase.isUserTag3Dirty() && (bl || pSSysChartThemeBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysChartThemeBase.getUserTag3());
        }
        if (pSSysChartThemeBase.isUserTag4Dirty() && (bl || pSSysChartThemeBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysChartThemeBase.getUserTag4());
        }
        if (pSSysChartThemeBase.isValidFlagDirty() && (bl || pSSysChartThemeBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysChartThemeBase.getValidFlag());
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
        return PSSysChartThemeBase.remove(this, n);
    }

    private static boolean remove(PSSysChartThemeBase pSSysChartThemeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysChartThemeBase.resetCodeName();
                return true;
            }
            case 1: {
                pSSysChartThemeBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSysChartThemeBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSysChartThemeBase.resetDefaultFlag();
                return true;
            }
            case 4: {
                pSSysChartThemeBase.resetMemo();
                return true;
            }
            case 5: {
                pSSysChartThemeBase.resetOrderValue();
                return true;
            }
            case 6: {
                pSSysChartThemeBase.resetPSModuleId();
                return true;
            }
            case 7: {
                pSSysChartThemeBase.resetPSModuleName();
                return true;
            }
            case 8: {
                pSSysChartThemeBase.resetPSSysChartThemeId();
                return true;
            }
            case 9: {
                pSSysChartThemeBase.resetPSSysChartThemeName();
                return true;
            }
            case 10: {
                pSSysChartThemeBase.resetPSSysDynaModelId();
                return true;
            }
            case 11: {
                pSSysChartThemeBase.resetPSSysDynaModelName();
                return true;
            }
            case 12: {
                pSSysChartThemeBase.resetPSSystemId();
                return true;
            }
            case 13: {
                pSSysChartThemeBase.resetPSSystemName();
                return true;
            }
            case 14: {
                pSSysChartThemeBase.resetThemeDesc();
                return true;
            }
            case 15: {
                pSSysChartThemeBase.resetThemeParams();
                return true;
            }
            case 16: {
                pSSysChartThemeBase.resetThemeTag();
                return true;
            }
            case 17: {
                pSSysChartThemeBase.resetThemeTag2();
                return true;
            }
            case 18: {
                pSSysChartThemeBase.resetUpdateDate();
                return true;
            }
            case 19: {
                pSSysChartThemeBase.resetUpdateMan();
                return true;
            }
            case 20: {
                pSSysChartThemeBase.resetUserCat();
                return true;
            }
            case 21: {
                pSSysChartThemeBase.resetUserTag();
                return true;
            }
            case 22: {
                pSSysChartThemeBase.resetUserTag2();
                return true;
            }
            case 23: {
                pSSysChartThemeBase.resetUserTag3();
                return true;
            }
            case 24: {
                pSSysChartThemeBase.resetUserTag4();
                return true;
            }
            case 25: {
                pSSysChartThemeBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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
    public PSSysDynaModel getPSSysDynaModel() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModel();
        }
        if (this.getPSSysDynaModelId() == null) {
            return null;
        }
        Integer n = this.objPSSysDynaModelLock;
        synchronized (n) {
            if (this.pssysdynamodel != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysDynaModelId(), (Object)this.pssysdynamodel.getPSSysDynaModelId()) != 0L) {
                this.pssysdynamodel = null;
            }
            if (this.pssysdynamodel == null) {
                PSSysDynaModel pSSysDynaModel = new PSSysDynaModel();
                pSSysDynaModel.setPSSysDynaModelId(this.getPSSysDynaModelId());
                PSSysDynaModelService pSSysDynaModelService = (PSSysDynaModelService)ServiceGlobal.getService(PSSysDynaModelService.class, (SessionFactory)this.getSessionFactory());
                pSSysDynaModelService.autoGet(pSSysDynaModel);
                this.pssysdynamodel = pSSysDynaModel;
            }
            return this.pssysdynamodel;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSystem getPSSystem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystem();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        Integer n = this.objPSSystemLock;
        synchronized (n) {
            if (this.pssystem != null && DataTypeHelper.compare((int)25, (Object)this.getPSSystemId(), (Object)this.pssystem.getPSSystemId()) != 0L) {
                this.pssystem = null;
            }
            if (this.pssystem == null) {
                PSSystem pSSystem = new PSSystem();
                pSSystem.setPSSystemId(this.getPSSystemId());
                PSSystemService pSSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)this.getSessionFactory());
                pSSystemService.autoGet(pSSystem);
                this.pssystem = pSSystem;
            }
            return this.pssystem;
        }
    }

    private PSSysChartThemeBase getProxyEntity() {
        return this.proxyPSSysChartThemeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysChartThemeBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysChartThemeBase) {
            this.proxyPSSysChartThemeBase = (PSSysChartThemeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysChartThemeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_DEFAULTFLAG, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_ORDERVALUE, 5);
        fieldIndexMap.put(FIELD_PSMODULEID, 6);
        fieldIndexMap.put(FIELD_PSMODULENAME, 7);
        fieldIndexMap.put(FIELD_PSSYSCHARTTHEMEID, 8);
        fieldIndexMap.put(FIELD_PSSYSCHARTTHEMENAME, 9);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 10);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 11);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 12);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 13);
        fieldIndexMap.put(FIELD_THEMEDESC, 14);
        fieldIndexMap.put(FIELD_THEMEPARAMS, 15);
        fieldIndexMap.put(FIELD_THEMETAG, 16);
        fieldIndexMap.put(FIELD_THEMETAG2, 17);
        fieldIndexMap.put(FIELD_UPDATEDATE, 18);
        fieldIndexMap.put(FIELD_UPDATEMAN, 19);
        fieldIndexMap.put(FIELD_USERCAT, 20);
        fieldIndexMap.put(FIELD_USERTAG, 21);
        fieldIndexMap.put(FIELD_USERTAG2, 22);
        fieldIndexMap.put(FIELD_USERTAG3, 23);
        fieldIndexMap.put(FIELD_USERTAG4, 24);
        fieldIndexMap.put(FIELD_VALIDFLAG, 25);
    }
}

