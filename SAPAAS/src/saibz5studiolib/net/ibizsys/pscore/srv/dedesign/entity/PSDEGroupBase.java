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
package net.ibizsys.pscore.srv.dedesign.entity;

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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGroupDetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGroupDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEGroupBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEGroupBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CODENAME2 = "CODENAME2";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_GROUPCAT = "GROUPCAT";
    public static final String FIELD_GROUPTAG = "GROUPTAG";
    public static final String FIELD_GROUPTAG2 = "GROUPTAG2";
    public static final String FIELD_INITPSSYSDYNAMODELID = "INITPSSYSDYNAMODELID";
    public static final String FIELD_INITPSSYSDYNAMODELNAME = "INITPSSYSDYNAMODELNAME";
    public static final String FIELD_LOGICMODE = "LOGICMODE";
    public static final String FIELD_LOGICPARAM = "LOGICPARAM";
    public static final String FIELD_LOGICPARAM2 = "LOGICPARAM2";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSDEGROUPID = "PSDEGROUPID";
    public static final String FIELD_PSDEGROUPNAME = "PSDEGROUPNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String FIELD_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String FIELD_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String FIELD_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CODENAME2 = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_GROUPCAT = 4;
    private static final int INDEX_GROUPTAG = 5;
    private static final int INDEX_GROUPTAG2 = 6;
    private static final int INDEX_INITPSSYSDYNAMODELID = 7;
    private static final int INDEX_INITPSSYSDYNAMODELNAME = 8;
    private static final int INDEX_LOGICMODE = 9;
    private static final int INDEX_LOGICPARAM = 10;
    private static final int INDEX_LOGICPARAM2 = 11;
    private static final int INDEX_MEMO = 12;
    private static final int INDEX_ORDERVALUE = 13;
    private static final int INDEX_PSDEGROUPID = 14;
    private static final int INDEX_PSDEGROUPNAME = 15;
    private static final int INDEX_PSDEID = 16;
    private static final int INDEX_PSDENAME = 17;
    private static final int INDEX_PSMODULEID = 18;
    private static final int INDEX_PSMODULENAME = 19;
    private static final int INDEX_PSSYSDYNAMODELID = 20;
    private static final int INDEX_PSSYSDYNAMODELNAME = 21;
    private static final int INDEX_PSSYSSFPLUGINID = 22;
    private static final int INDEX_PSSYSSFPLUGINNAME = 23;
    private static final int INDEX_PSSYSTEMID = 24;
    private static final int INDEX_PSSYSTEMNAME = 25;
    private static final int INDEX_UPDATEDATE = 26;
    private static final int INDEX_UPDATEMAN = 27;
    private static final int INDEX_USERCAT = 28;
    private static final int INDEX_USERTAG = 29;
    private static final int INDEX_USERTAG2 = 30;
    private static final int INDEX_USERTAG3 = 31;
    private static final int INDEX_USERTAG4 = 32;
    private static final int INDEX_VALIDFLAG = 33;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEGroupBase proxyPSDEGroupBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean codename2DirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean groupcatDirtyFlag = false;
    private boolean grouptagDirtyFlag = false;
    private boolean grouptag2DirtyFlag = false;
    private boolean initpssysdynamodelidDirtyFlag = false;
    private boolean initpssysdynamodelnameDirtyFlag = false;
    private boolean logicmodeDirtyFlag = false;
    private boolean logicparamDirtyFlag = false;
    private boolean logicparam2DirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psdegroupidDirtyFlag = false;
    private boolean psdegroupnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssysdynamodelidDirtyFlag = false;
    private boolean pssysdynamodelnameDirtyFlag = false;
    private boolean pssyssfpluginidDirtyFlag = false;
    private boolean pssyssfpluginnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
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
    @Column(name="codename2")
    private String codename2;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="groupcat")
    private String groupcat;
    @Column(name="grouptag")
    private String grouptag;
    @Column(name="grouptag2")
    private String grouptag2;
    @Column(name="initpssysdynamodelid")
    private String initpssysdynamodelid;
    @Column(name="initpssysdynamodelname")
    private String initpssysdynamodelname;
    @Column(name="logicmode")
    private String logicmode;
    @Column(name="logicparam")
    private String logicparam;
    @Column(name="logicparam2")
    private String logicparam2;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psdegroupid")
    private String psdegroupid;
    @Column(name="psdegroupname")
    private String psdegroupname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssysdynamodelid")
    private String pssysdynamodelid;
    @Column(name="pssysdynamodelname")
    private String pssysdynamodelname;
    @Column(name="pssyssfpluginid")
    private String pssyssfpluginid;
    @Column(name="pssyssfpluginname")
    private String pssyssfpluginname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
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
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objInitPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel initpssysdynamodel = null;
    private Integer objPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel pssysdynamodel = null;
    private Integer objPSSysSFPluginLock = new Integer(1);
    private PSSysSFPlugin pssyssfplugin = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSDEGroupDetailsLock = new Integer(1);
    private ArrayList<PSDEGroupDetail> psdegroupdetails = null;

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

    public void setCodeName2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeName2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.codename2 = string;
        this.codename2DirtyFlag = true;
    }

    public String getCodeName2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeName2();
        }
        return this.codename2;
    }

    public boolean isCodeName2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeName2Dirty();
        }
        return this.codename2DirtyFlag;
    }

    public void resetCodeName2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeName2();
            return;
        }
        this.codename2DirtyFlag = false;
        this.codename2 = null;
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

    public void setGroupCat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupCat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.groupcat = string;
        this.groupcatDirtyFlag = true;
    }

    public String getGroupCat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupCat();
        }
        return this.groupcat;
    }

    public boolean isGroupCatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupCatDirty();
        }
        return this.groupcatDirtyFlag;
    }

    public void resetGroupCat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupCat();
            return;
        }
        this.groupcatDirtyFlag = false;
        this.groupcat = null;
    }

    public void setGroupTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.grouptag = string;
        this.grouptagDirtyFlag = true;
    }

    public String getGroupTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupTag();
        }
        return this.grouptag;
    }

    public boolean isGroupTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupTagDirty();
        }
        return this.grouptagDirtyFlag;
    }

    public void resetGroupTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupTag();
            return;
        }
        this.grouptagDirtyFlag = false;
        this.grouptag = null;
    }

    public void setGroupTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.grouptag2 = string;
        this.grouptag2DirtyFlag = true;
    }

    public String getGroupTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupTag2();
        }
        return this.grouptag2;
    }

    public boolean isGroupTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupTag2Dirty();
        }
        return this.grouptag2DirtyFlag;
    }

    public void resetGroupTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupTag2();
            return;
        }
        this.grouptag2DirtyFlag = false;
        this.grouptag2 = null;
    }

    public void setInitPSSysDynaModelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInitPSSysDynaModelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.initpssysdynamodelid = string;
        this.initpssysdynamodelidDirtyFlag = true;
    }

    public String getInitPSSysDynaModelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInitPSSysDynaModelId();
        }
        return this.initpssysdynamodelid;
    }

    public boolean isInitPSSysDynaModelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInitPSSysDynaModelIdDirty();
        }
        return this.initpssysdynamodelidDirtyFlag;
    }

    public void resetInitPSSysDynaModelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInitPSSysDynaModelId();
            return;
        }
        this.initpssysdynamodelidDirtyFlag = false;
        this.initpssysdynamodelid = null;
    }

    public void setInitPSSysDynaModelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInitPSSysDynaModelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.initpssysdynamodelname = string;
        this.initpssysdynamodelnameDirtyFlag = true;
    }

    public String getInitPSSysDynaModelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInitPSSysDynaModelName();
        }
        return this.initpssysdynamodelname;
    }

    public boolean isInitPSSysDynaModelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInitPSSysDynaModelNameDirty();
        }
        return this.initpssysdynamodelnameDirtyFlag;
    }

    public void resetInitPSSysDynaModelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInitPSSysDynaModelName();
            return;
        }
        this.initpssysdynamodelnameDirtyFlag = false;
        this.initpssysdynamodelname = null;
    }

    public void setLogicMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogicMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.logicmode = string;
        this.logicmodeDirtyFlag = true;
    }

    public String getLogicMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogicMode();
        }
        return this.logicmode;
    }

    public boolean isLogicModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogicModeDirty();
        }
        return this.logicmodeDirtyFlag;
    }

    public void resetLogicMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogicMode();
            return;
        }
        this.logicmodeDirtyFlag = false;
        this.logicmode = null;
    }

    public void setLogicParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogicParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.logicparam = string;
        this.logicparamDirtyFlag = true;
    }

    public String getLogicParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogicParam();
        }
        return this.logicparam;
    }

    public boolean isLogicParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogicParamDirty();
        }
        return this.logicparamDirtyFlag;
    }

    public void resetLogicParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogicParam();
            return;
        }
        this.logicparamDirtyFlag = false;
        this.logicparam = null;
    }

    public void setLogicParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogicParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.logicparam2 = string;
        this.logicparam2DirtyFlag = true;
    }

    public String getLogicParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogicParam2();
        }
        return this.logicparam2;
    }

    public boolean isLogicParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogicParam2Dirty();
        }
        return this.logicparam2DirtyFlag;
    }

    public void resetLogicParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogicParam2();
            return;
        }
        this.logicparam2DirtyFlag = false;
        this.logicparam2 = null;
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

    public void setPSDEGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdegroupid = string;
        this.psdegroupidDirtyFlag = true;
    }

    public String getPSDEGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGroupId();
        }
        return this.psdegroupid;
    }

    public boolean isPSDEGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEGroupIdDirty();
        }
        return this.psdegroupidDirtyFlag;
    }

    public void resetPSDEGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEGroupId();
            return;
        }
        this.psdegroupidDirtyFlag = false;
        this.psdegroupid = null;
    }

    public void setPSDEGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdegroupname = string;
        this.psdegroupnameDirtyFlag = true;
    }

    public String getPSDEGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGroupName();
        }
        return this.psdegroupname;
    }

    public boolean isPSDEGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEGroupNameDirty();
        }
        return this.psdegroupnameDirtyFlag;
    }

    public void resetPSDEGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEGroupName();
            return;
        }
        this.psdegroupnameDirtyFlag = false;
        this.psdegroupname = null;
    }

    public void setPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeid = string;
        this.psdeidDirtyFlag = true;
    }

    public String getPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEId();
        }
        return this.psdeid;
    }

    public boolean isPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEIdDirty();
        }
        return this.psdeidDirtyFlag;
    }

    public void resetPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEId();
            return;
        }
        this.psdeidDirtyFlag = false;
        this.psdeid = null;
    }

    public void setPSDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdename = string;
        this.psdenameDirtyFlag = true;
    }

    public String getPSDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEName();
        }
        return this.psdename;
    }

    public boolean isPSDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDENameDirty();
        }
        return this.psdenameDirtyFlag;
    }

    public void resetPSDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEName();
            return;
        }
        this.psdenameDirtyFlag = false;
        this.psdename = null;
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
        PSDEGroupBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEGroupBase pSDEGroupBase) {
        pSDEGroupBase.resetCodeName();
        pSDEGroupBase.resetCodeName2();
        pSDEGroupBase.resetCreateDate();
        pSDEGroupBase.resetCreateMan();
        pSDEGroupBase.resetGroupCat();
        pSDEGroupBase.resetGroupTag();
        pSDEGroupBase.resetGroupTag2();
        pSDEGroupBase.resetInitPSSysDynaModelId();
        pSDEGroupBase.resetInitPSSysDynaModelName();
        pSDEGroupBase.resetLogicMode();
        pSDEGroupBase.resetLogicParam();
        pSDEGroupBase.resetLogicParam2();
        pSDEGroupBase.resetMemo();
        pSDEGroupBase.resetOrderValue();
        pSDEGroupBase.resetPSDEGroupId();
        pSDEGroupBase.resetPSDEGroupName();
        pSDEGroupBase.resetPSDEId();
        pSDEGroupBase.resetPSDEName();
        pSDEGroupBase.resetPSModuleId();
        pSDEGroupBase.resetPSModuleName();
        pSDEGroupBase.resetPSSysDynaModelId();
        pSDEGroupBase.resetPSSysDynaModelName();
        pSDEGroupBase.resetPSSysSFPluginId();
        pSDEGroupBase.resetPSSysSFPluginName();
        pSDEGroupBase.resetPSSystemId();
        pSDEGroupBase.resetPSSystemName();
        pSDEGroupBase.resetUpdateDate();
        pSDEGroupBase.resetUpdateMan();
        pSDEGroupBase.resetUserCat();
        pSDEGroupBase.resetUserTag();
        pSDEGroupBase.resetUserTag2();
        pSDEGroupBase.resetUserTag3();
        pSDEGroupBase.resetUserTag4();
        pSDEGroupBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isCodeName2Dirty()) {
            hashMap.put(FIELD_CODENAME2, this.getCodeName2());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isGroupCatDirty()) {
            hashMap.put(FIELD_GROUPCAT, this.getGroupCat());
        }
        if (!bl || this.isGroupTagDirty()) {
            hashMap.put(FIELD_GROUPTAG, this.getGroupTag());
        }
        if (!bl || this.isGroupTag2Dirty()) {
            hashMap.put(FIELD_GROUPTAG2, this.getGroupTag2());
        }
        if (!bl || this.isInitPSSysDynaModelIdDirty()) {
            hashMap.put(FIELD_INITPSSYSDYNAMODELID, this.getInitPSSysDynaModelId());
        }
        if (!bl || this.isInitPSSysDynaModelNameDirty()) {
            hashMap.put(FIELD_INITPSSYSDYNAMODELNAME, this.getInitPSSysDynaModelName());
        }
        if (!bl || this.isLogicModeDirty()) {
            hashMap.put(FIELD_LOGICMODE, this.getLogicMode());
        }
        if (!bl || this.isLogicParamDirty()) {
            hashMap.put(FIELD_LOGICPARAM, this.getLogicParam());
        }
        if (!bl || this.isLogicParam2Dirty()) {
            hashMap.put(FIELD_LOGICPARAM2, this.getLogicParam2());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSDEGroupIdDirty()) {
            hashMap.put(FIELD_PSDEGROUPID, this.getPSDEGroupId());
        }
        if (!bl || this.isPSDEGroupNameDirty()) {
            hashMap.put(FIELD_PSDEGROUPNAME, this.getPSDEGroupName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSModuleIdDirty()) {
            hashMap.put(FIELD_PSMODULEID, this.getPSModuleId());
        }
        if (!bl || this.isPSModuleNameDirty()) {
            hashMap.put(FIELD_PSMODULENAME, this.getPSModuleName());
        }
        if (!bl || this.isPSSysDynaModelIdDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELID, this.getPSSysDynaModelId());
        }
        if (!bl || this.isPSSysDynaModelNameDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELNAME, this.getPSSysDynaModelName());
        }
        if (!bl || this.isPSSysSFPluginIdDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINID, this.getPSSysSFPluginId());
        }
        if (!bl || this.isPSSysSFPluginNameDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINNAME, this.getPSSysSFPluginName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
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
        return PSDEGroupBase.get(this, n);
    }

    private static Object get(PSDEGroupBase pSDEGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEGroupBase.getCodeName();
            }
            case 1: {
                return pSDEGroupBase.getCodeName2();
            }
            case 2: {
                return pSDEGroupBase.getCreateDate();
            }
            case 3: {
                return pSDEGroupBase.getCreateMan();
            }
            case 4: {
                return pSDEGroupBase.getGroupCat();
            }
            case 5: {
                return pSDEGroupBase.getGroupTag();
            }
            case 6: {
                return pSDEGroupBase.getGroupTag2();
            }
            case 7: {
                return pSDEGroupBase.getInitPSSysDynaModelId();
            }
            case 8: {
                return pSDEGroupBase.getInitPSSysDynaModelName();
            }
            case 9: {
                return pSDEGroupBase.getLogicMode();
            }
            case 10: {
                return pSDEGroupBase.getLogicParam();
            }
            case 11: {
                return pSDEGroupBase.getLogicParam2();
            }
            case 12: {
                return pSDEGroupBase.getMemo();
            }
            case 13: {
                return pSDEGroupBase.getOrderValue();
            }
            case 14: {
                return pSDEGroupBase.getPSDEGroupId();
            }
            case 15: {
                return pSDEGroupBase.getPSDEGroupName();
            }
            case 16: {
                return pSDEGroupBase.getPSDEId();
            }
            case 17: {
                return pSDEGroupBase.getPSDEName();
            }
            case 18: {
                return pSDEGroupBase.getPSModuleId();
            }
            case 19: {
                return pSDEGroupBase.getPSModuleName();
            }
            case 20: {
                return pSDEGroupBase.getPSSysDynaModelId();
            }
            case 21: {
                return pSDEGroupBase.getPSSysDynaModelName();
            }
            case 22: {
                return pSDEGroupBase.getPSSysSFPluginId();
            }
            case 23: {
                return pSDEGroupBase.getPSSysSFPluginName();
            }
            case 24: {
                return pSDEGroupBase.getPSSystemId();
            }
            case 25: {
                return pSDEGroupBase.getPSSystemName();
            }
            case 26: {
                return pSDEGroupBase.getUpdateDate();
            }
            case 27: {
                return pSDEGroupBase.getUpdateMan();
            }
            case 28: {
                return pSDEGroupBase.getUserCat();
            }
            case 29: {
                return pSDEGroupBase.getUserTag();
            }
            case 30: {
                return pSDEGroupBase.getUserTag2();
            }
            case 31: {
                return pSDEGroupBase.getUserTag3();
            }
            case 32: {
                return pSDEGroupBase.getUserTag4();
            }
            case 33: {
                return pSDEGroupBase.getValidFlag();
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
        PSDEGroupBase.set(this, n, object);
    }

    private static void set(PSDEGroupBase pSDEGroupBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEGroupBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDEGroupBase.setCodeName2(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEGroupBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSDEGroupBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEGroupBase.setGroupCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEGroupBase.setGroupTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEGroupBase.setGroupTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEGroupBase.setInitPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEGroupBase.setInitPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEGroupBase.setLogicMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEGroupBase.setLogicParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEGroupBase.setLogicParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEGroupBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEGroupBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSDEGroupBase.setPSDEGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEGroupBase.setPSDEGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEGroupBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEGroupBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEGroupBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEGroupBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDEGroupBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEGroupBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDEGroupBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDEGroupBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDEGroupBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDEGroupBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDEGroupBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 27: {
                pSDEGroupBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDEGroupBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDEGroupBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDEGroupBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDEGroupBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDEGroupBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDEGroupBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDEGroupBase.isNull(this, n);
    }

    private static boolean isNull(PSDEGroupBase pSDEGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEGroupBase.getCodeName() == null;
            }
            case 1: {
                return pSDEGroupBase.getCodeName2() == null;
            }
            case 2: {
                return pSDEGroupBase.getCreateDate() == null;
            }
            case 3: {
                return pSDEGroupBase.getCreateMan() == null;
            }
            case 4: {
                return pSDEGroupBase.getGroupCat() == null;
            }
            case 5: {
                return pSDEGroupBase.getGroupTag() == null;
            }
            case 6: {
                return pSDEGroupBase.getGroupTag2() == null;
            }
            case 7: {
                return pSDEGroupBase.getInitPSSysDynaModelId() == null;
            }
            case 8: {
                return pSDEGroupBase.getInitPSSysDynaModelName() == null;
            }
            case 9: {
                return pSDEGroupBase.getLogicMode() == null;
            }
            case 10: {
                return pSDEGroupBase.getLogicParam() == null;
            }
            case 11: {
                return pSDEGroupBase.getLogicParam2() == null;
            }
            case 12: {
                return pSDEGroupBase.getMemo() == null;
            }
            case 13: {
                return pSDEGroupBase.getOrderValue() == null;
            }
            case 14: {
                return pSDEGroupBase.getPSDEGroupId() == null;
            }
            case 15: {
                return pSDEGroupBase.getPSDEGroupName() == null;
            }
            case 16: {
                return pSDEGroupBase.getPSDEId() == null;
            }
            case 17: {
                return pSDEGroupBase.getPSDEName() == null;
            }
            case 18: {
                return pSDEGroupBase.getPSModuleId() == null;
            }
            case 19: {
                return pSDEGroupBase.getPSModuleName() == null;
            }
            case 20: {
                return pSDEGroupBase.getPSSysDynaModelId() == null;
            }
            case 21: {
                return pSDEGroupBase.getPSSysDynaModelName() == null;
            }
            case 22: {
                return pSDEGroupBase.getPSSysSFPluginId() == null;
            }
            case 23: {
                return pSDEGroupBase.getPSSysSFPluginName() == null;
            }
            case 24: {
                return pSDEGroupBase.getPSSystemId() == null;
            }
            case 25: {
                return pSDEGroupBase.getPSSystemName() == null;
            }
            case 26: {
                return pSDEGroupBase.getUpdateDate() == null;
            }
            case 27: {
                return pSDEGroupBase.getUpdateMan() == null;
            }
            case 28: {
                return pSDEGroupBase.getUserCat() == null;
            }
            case 29: {
                return pSDEGroupBase.getUserTag() == null;
            }
            case 30: {
                return pSDEGroupBase.getUserTag2() == null;
            }
            case 31: {
                return pSDEGroupBase.getUserTag3() == null;
            }
            case 32: {
                return pSDEGroupBase.getUserTag4() == null;
            }
            case 33: {
                return pSDEGroupBase.getValidFlag() == null;
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
        return PSDEGroupBase.contains(this, n);
    }

    private static boolean contains(PSDEGroupBase pSDEGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEGroupBase.isCodeNameDirty();
            }
            case 1: {
                return pSDEGroupBase.isCodeName2Dirty();
            }
            case 2: {
                return pSDEGroupBase.isCreateDateDirty();
            }
            case 3: {
                return pSDEGroupBase.isCreateManDirty();
            }
            case 4: {
                return pSDEGroupBase.isGroupCatDirty();
            }
            case 5: {
                return pSDEGroupBase.isGroupTagDirty();
            }
            case 6: {
                return pSDEGroupBase.isGroupTag2Dirty();
            }
            case 7: {
                return pSDEGroupBase.isInitPSSysDynaModelIdDirty();
            }
            case 8: {
                return pSDEGroupBase.isInitPSSysDynaModelNameDirty();
            }
            case 9: {
                return pSDEGroupBase.isLogicModeDirty();
            }
            case 10: {
                return pSDEGroupBase.isLogicParamDirty();
            }
            case 11: {
                return pSDEGroupBase.isLogicParam2Dirty();
            }
            case 12: {
                return pSDEGroupBase.isMemoDirty();
            }
            case 13: {
                return pSDEGroupBase.isOrderValueDirty();
            }
            case 14: {
                return pSDEGroupBase.isPSDEGroupIdDirty();
            }
            case 15: {
                return pSDEGroupBase.isPSDEGroupNameDirty();
            }
            case 16: {
                return pSDEGroupBase.isPSDEIdDirty();
            }
            case 17: {
                return pSDEGroupBase.isPSDENameDirty();
            }
            case 18: {
                return pSDEGroupBase.isPSModuleIdDirty();
            }
            case 19: {
                return pSDEGroupBase.isPSModuleNameDirty();
            }
            case 20: {
                return pSDEGroupBase.isPSSysDynaModelIdDirty();
            }
            case 21: {
                return pSDEGroupBase.isPSSysDynaModelNameDirty();
            }
            case 22: {
                return pSDEGroupBase.isPSSysSFPluginIdDirty();
            }
            case 23: {
                return pSDEGroupBase.isPSSysSFPluginNameDirty();
            }
            case 24: {
                return pSDEGroupBase.isPSSystemIdDirty();
            }
            case 25: {
                return pSDEGroupBase.isPSSystemNameDirty();
            }
            case 26: {
                return pSDEGroupBase.isUpdateDateDirty();
            }
            case 27: {
                return pSDEGroupBase.isUpdateManDirty();
            }
            case 28: {
                return pSDEGroupBase.isUserCatDirty();
            }
            case 29: {
                return pSDEGroupBase.isUserTagDirty();
            }
            case 30: {
                return pSDEGroupBase.isUserTag2Dirty();
            }
            case 31: {
                return pSDEGroupBase.isUserTag3Dirty();
            }
            case 32: {
                return pSDEGroupBase.isUserTag4Dirty();
            }
            case 33: {
                return pSDEGroupBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEGroupBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEGroupBase pSDEGroupBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEGroupBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDEGroupBase.getJSONValue((Object)pSDEGroupBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDEGroupBase.getCodeName2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename2", (Object)PSDEGroupBase.getJSONValue((Object)pSDEGroupBase.getCodeName2()), (boolean)false);
        }
        if (bl || pSDEGroupBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEGroupBase.getJSONValue((Object)pSDEGroupBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEGroupBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEGroupBase.getJSONValue((Object)pSDEGroupBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEGroupBase.getGroupCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"groupcat", (Object)PSDEGroupBase.getJSONValue((Object)pSDEGroupBase.getGroupCat()), (boolean)false);
        }
        if (bl || pSDEGroupBase.getGroupTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouptag", (Object)PSDEGroupBase.getJSONValue((Object)pSDEGroupBase.getGroupTag()), (boolean)false);
        }
        if (bl || pSDEGroupBase.getGroupTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouptag2", (Object)PSDEGroupBase.getJSONValue((Object)pSDEGroupBase.getGroupTag2()), (boolean)false);
        }
        if (bl || pSDEGroupBase.getInitPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"initpssysdynamodelid", (Object)PSDEGroupBase.getJSONValue((Object)pSDEGroupBase.getInitPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSDEGroupBase.getInitPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"initpssysdynamodelname", (Object)PSDEGroupBase.getJSONValue((Object)pSDEGroupBase.getInitPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSDEGroupBase.getLogicMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicmode", (Object)PSDEGroupBase.getJSONValue((Object)pSDEGroupBase.getLogicMode()), (boolean)false);
        }
        if (bl || pSDEGroupBase.getLogicParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicparam", (Object)PSDEGroupBase.getJSONValue((Object)pSDEGroupBase.getLogicParam()), (boolean)false);
        }
        if (bl || pSDEGroupBase.getLogicParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicparam2", (Object)PSDEGroupBase.getJSONValue((Object)pSDEGroupBase.getLogicParam2()), (boolean)false);
        }
        if (bl || pSDEGroupBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEGroupBase.getJSONValue((Object)pSDEGroupBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEGroupBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDEGroupBase.getJSONValue((Object)pSDEGroupBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDEGroupBase.getPSDEGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdegroupid", (Object)PSDEGroupBase.getJSONValue((Object)pSDEGroupBase.getPSDEGroupId()), (boolean)false);
        }
        if (bl || pSDEGroupBase.getPSDEGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdegroupname", (Object)PSDEGroupBase.getJSONValue((Object)pSDEGroupBase.getPSDEGroupName()), (boolean)false);
        }
        if (bl || pSDEGroupBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEGroupBase.getJSONValue((Object)pSDEGroupBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEGroupBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDEGroupBase.getJSONValue((Object)pSDEGroupBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDEGroupBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSDEGroupBase.getJSONValue((Object)pSDEGroupBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSDEGroupBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSDEGroupBase.getJSONValue((Object)pSDEGroupBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSDEGroupBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSDEGroupBase.getJSONValue((Object)pSDEGroupBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSDEGroupBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSDEGroupBase.getJSONValue((Object)pSDEGroupBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSDEGroupBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSDEGroupBase.getJSONValue((Object)pSDEGroupBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSDEGroupBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSDEGroupBase.getJSONValue((Object)pSDEGroupBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSDEGroupBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSDEGroupBase.getJSONValue((Object)pSDEGroupBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSDEGroupBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSDEGroupBase.getJSONValue((Object)pSDEGroupBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSDEGroupBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEGroupBase.getJSONValue((Object)pSDEGroupBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEGroupBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEGroupBase.getJSONValue((Object)pSDEGroupBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEGroupBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEGroupBase.getJSONValue((Object)pSDEGroupBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEGroupBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEGroupBase.getJSONValue((Object)pSDEGroupBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEGroupBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEGroupBase.getJSONValue((Object)pSDEGroupBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEGroupBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEGroupBase.getJSONValue((Object)pSDEGroupBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEGroupBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEGroupBase.getJSONValue((Object)pSDEGroupBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDEGroupBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDEGroupBase.getJSONValue((Object)pSDEGroupBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEGroupBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEGroupBase pSDEGroupBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEGroupBase.getCodeName() != null) {
            object = pSDEGroupBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, (String)(object == null ? "" : object));
        }
        if (bl || pSDEGroupBase.getCodeName2() != null) {
            object = pSDEGroupBase.getCodeName2();
            xmlNode.setAttribute(FIELD_CODENAME2, object == null ? "" : (String)object);
        }
        if (bl || pSDEGroupBase.getCreateDate() != null) {
            object = pSDEGroupBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEGroupBase.getCreateMan() != null) {
            object = pSDEGroupBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEGroupBase.getGroupCat() != null) {
            object = pSDEGroupBase.getGroupCat();
            xmlNode.setAttribute(FIELD_GROUPCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEGroupBase.getGroupTag() != null) {
            object = pSDEGroupBase.getGroupTag();
            xmlNode.setAttribute(FIELD_GROUPTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEGroupBase.getGroupTag2() != null) {
            object = pSDEGroupBase.getGroupTag2();
            xmlNode.setAttribute(FIELD_GROUPTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEGroupBase.getInitPSSysDynaModelId() != null) {
            object = pSDEGroupBase.getInitPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_INITPSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGroupBase.getInitPSSysDynaModelName() != null) {
            object = pSDEGroupBase.getInitPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_INITPSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGroupBase.getLogicMode() != null) {
            object = pSDEGroupBase.getLogicMode();
            xmlNode.setAttribute(FIELD_LOGICMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEGroupBase.getLogicParam() != null) {
            object = pSDEGroupBase.getLogicParam();
            xmlNode.setAttribute(FIELD_LOGICPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDEGroupBase.getLogicParam2() != null) {
            object = pSDEGroupBase.getLogicParam2();
            xmlNode.setAttribute(FIELD_LOGICPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSDEGroupBase.getMemo() != null) {
            object = pSDEGroupBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEGroupBase.getOrderValue() != null) {
            object = pSDEGroupBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEGroupBase.getPSDEGroupId() != null) {
            object = pSDEGroupBase.getPSDEGroupId();
            xmlNode.setAttribute(FIELD_PSDEGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGroupBase.getPSDEGroupName() != null) {
            object = pSDEGroupBase.getPSDEGroupName();
            xmlNode.setAttribute(FIELD_PSDEGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGroupBase.getPSDEId() != null) {
            object = pSDEGroupBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGroupBase.getPSDEName() != null) {
            object = pSDEGroupBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGroupBase.getPSModuleId() != null) {
            object = pSDEGroupBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGroupBase.getPSModuleName() != null) {
            object = pSDEGroupBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGroupBase.getPSSysDynaModelId() != null) {
            object = pSDEGroupBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGroupBase.getPSSysDynaModelName() != null) {
            object = pSDEGroupBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGroupBase.getPSSysSFPluginId() != null) {
            object = pSDEGroupBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGroupBase.getPSSysSFPluginName() != null) {
            object = pSDEGroupBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGroupBase.getPSSystemId() != null) {
            object = pSDEGroupBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGroupBase.getPSSystemName() != null) {
            object = pSDEGroupBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGroupBase.getUpdateDate() != null) {
            object = pSDEGroupBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEGroupBase.getUpdateMan() != null) {
            object = pSDEGroupBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEGroupBase.getUserCat() != null) {
            object = pSDEGroupBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEGroupBase.getUserTag() != null) {
            object = pSDEGroupBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEGroupBase.getUserTag2() != null) {
            object = pSDEGroupBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEGroupBase.getUserTag3() != null) {
            object = pSDEGroupBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEGroupBase.getUserTag4() != null) {
            object = pSDEGroupBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEGroupBase.getValidFlag() != null) {
            object = pSDEGroupBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEGroupBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEGroupBase pSDEGroupBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEGroupBase.isCodeNameDirty() && (bl || pSDEGroupBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDEGroupBase.getCodeName());
        }
        if (pSDEGroupBase.isCodeName2Dirty() && (bl || pSDEGroupBase.getCodeName2() != null)) {
            iDataObject.set(FIELD_CODENAME2, (Object)pSDEGroupBase.getCodeName2());
        }
        if (pSDEGroupBase.isCreateDateDirty() && (bl || pSDEGroupBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEGroupBase.getCreateDate());
        }
        if (pSDEGroupBase.isCreateManDirty() && (bl || pSDEGroupBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEGroupBase.getCreateMan());
        }
        if (pSDEGroupBase.isGroupCatDirty() && (bl || pSDEGroupBase.getGroupCat() != null)) {
            iDataObject.set(FIELD_GROUPCAT, (Object)pSDEGroupBase.getGroupCat());
        }
        if (pSDEGroupBase.isGroupTagDirty() && (bl || pSDEGroupBase.getGroupTag() != null)) {
            iDataObject.set(FIELD_GROUPTAG, (Object)pSDEGroupBase.getGroupTag());
        }
        if (pSDEGroupBase.isGroupTag2Dirty() && (bl || pSDEGroupBase.getGroupTag2() != null)) {
            iDataObject.set(FIELD_GROUPTAG2, (Object)pSDEGroupBase.getGroupTag2());
        }
        if (pSDEGroupBase.isInitPSSysDynaModelIdDirty() && (bl || pSDEGroupBase.getInitPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_INITPSSYSDYNAMODELID, (Object)pSDEGroupBase.getInitPSSysDynaModelId());
        }
        if (pSDEGroupBase.isInitPSSysDynaModelNameDirty() && (bl || pSDEGroupBase.getInitPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_INITPSSYSDYNAMODELNAME, (Object)pSDEGroupBase.getInitPSSysDynaModelName());
        }
        if (pSDEGroupBase.isLogicModeDirty() && (bl || pSDEGroupBase.getLogicMode() != null)) {
            iDataObject.set(FIELD_LOGICMODE, (Object)pSDEGroupBase.getLogicMode());
        }
        if (pSDEGroupBase.isLogicParamDirty() && (bl || pSDEGroupBase.getLogicParam() != null)) {
            iDataObject.set(FIELD_LOGICPARAM, (Object)pSDEGroupBase.getLogicParam());
        }
        if (pSDEGroupBase.isLogicParam2Dirty() && (bl || pSDEGroupBase.getLogicParam2() != null)) {
            iDataObject.set(FIELD_LOGICPARAM2, (Object)pSDEGroupBase.getLogicParam2());
        }
        if (pSDEGroupBase.isMemoDirty() && (bl || pSDEGroupBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEGroupBase.getMemo());
        }
        if (pSDEGroupBase.isOrderValueDirty() && (bl || pSDEGroupBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDEGroupBase.getOrderValue());
        }
        if (pSDEGroupBase.isPSDEGroupIdDirty() && (bl || pSDEGroupBase.getPSDEGroupId() != null)) {
            iDataObject.set(FIELD_PSDEGROUPID, (Object)pSDEGroupBase.getPSDEGroupId());
        }
        if (pSDEGroupBase.isPSDEGroupNameDirty() && (bl || pSDEGroupBase.getPSDEGroupName() != null)) {
            iDataObject.set(FIELD_PSDEGROUPNAME, (Object)pSDEGroupBase.getPSDEGroupName());
        }
        if (pSDEGroupBase.isPSDEIdDirty() && (bl || pSDEGroupBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEGroupBase.getPSDEId());
        }
        if (pSDEGroupBase.isPSDENameDirty() && (bl || pSDEGroupBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDEGroupBase.getPSDEName());
        }
        if (pSDEGroupBase.isPSModuleIdDirty() && (bl || pSDEGroupBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSDEGroupBase.getPSModuleId());
        }
        if (pSDEGroupBase.isPSModuleNameDirty() && (bl || pSDEGroupBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSDEGroupBase.getPSModuleName());
        }
        if (pSDEGroupBase.isPSSysDynaModelIdDirty() && (bl || pSDEGroupBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSDEGroupBase.getPSSysDynaModelId());
        }
        if (pSDEGroupBase.isPSSysDynaModelNameDirty() && (bl || pSDEGroupBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSDEGroupBase.getPSSysDynaModelName());
        }
        if (pSDEGroupBase.isPSSysSFPluginIdDirty() && (bl || pSDEGroupBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSDEGroupBase.getPSSysSFPluginId());
        }
        if (pSDEGroupBase.isPSSysSFPluginNameDirty() && (bl || pSDEGroupBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSDEGroupBase.getPSSysSFPluginName());
        }
        if (pSDEGroupBase.isPSSystemIdDirty() && (bl || pSDEGroupBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSDEGroupBase.getPSSystemId());
        }
        if (pSDEGroupBase.isPSSystemNameDirty() && (bl || pSDEGroupBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSDEGroupBase.getPSSystemName());
        }
        if (pSDEGroupBase.isUpdateDateDirty() && (bl || pSDEGroupBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEGroupBase.getUpdateDate());
        }
        if (pSDEGroupBase.isUpdateManDirty() && (bl || pSDEGroupBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEGroupBase.getUpdateMan());
        }
        if (pSDEGroupBase.isUserCatDirty() && (bl || pSDEGroupBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEGroupBase.getUserCat());
        }
        if (pSDEGroupBase.isUserTagDirty() && (bl || pSDEGroupBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEGroupBase.getUserTag());
        }
        if (pSDEGroupBase.isUserTag2Dirty() && (bl || pSDEGroupBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEGroupBase.getUserTag2());
        }
        if (pSDEGroupBase.isUserTag3Dirty() && (bl || pSDEGroupBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEGroupBase.getUserTag3());
        }
        if (pSDEGroupBase.isUserTag4Dirty() && (bl || pSDEGroupBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEGroupBase.getUserTag4());
        }
        if (pSDEGroupBase.isValidFlagDirty() && (bl || pSDEGroupBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDEGroupBase.getValidFlag());
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
        return PSDEGroupBase.remove(this, n);
    }

    private static boolean remove(PSDEGroupBase pSDEGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEGroupBase.resetCodeName();
                return true;
            }
            case 1: {
                pSDEGroupBase.resetCodeName2();
                return true;
            }
            case 2: {
                pSDEGroupBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSDEGroupBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSDEGroupBase.resetGroupCat();
                return true;
            }
            case 5: {
                pSDEGroupBase.resetGroupTag();
                return true;
            }
            case 6: {
                pSDEGroupBase.resetGroupTag2();
                return true;
            }
            case 7: {
                pSDEGroupBase.resetInitPSSysDynaModelId();
                return true;
            }
            case 8: {
                pSDEGroupBase.resetInitPSSysDynaModelName();
                return true;
            }
            case 9: {
                pSDEGroupBase.resetLogicMode();
                return true;
            }
            case 10: {
                pSDEGroupBase.resetLogicParam();
                return true;
            }
            case 11: {
                pSDEGroupBase.resetLogicParam2();
                return true;
            }
            case 12: {
                pSDEGroupBase.resetMemo();
                return true;
            }
            case 13: {
                pSDEGroupBase.resetOrderValue();
                return true;
            }
            case 14: {
                pSDEGroupBase.resetPSDEGroupId();
                return true;
            }
            case 15: {
                pSDEGroupBase.resetPSDEGroupName();
                return true;
            }
            case 16: {
                pSDEGroupBase.resetPSDEId();
                return true;
            }
            case 17: {
                pSDEGroupBase.resetPSDEName();
                return true;
            }
            case 18: {
                pSDEGroupBase.resetPSModuleId();
                return true;
            }
            case 19: {
                pSDEGroupBase.resetPSModuleName();
                return true;
            }
            case 20: {
                pSDEGroupBase.resetPSSysDynaModelId();
                return true;
            }
            case 21: {
                pSDEGroupBase.resetPSSysDynaModelName();
                return true;
            }
            case 22: {
                pSDEGroupBase.resetPSSysSFPluginId();
                return true;
            }
            case 23: {
                pSDEGroupBase.resetPSSysSFPluginName();
                return true;
            }
            case 24: {
                pSDEGroupBase.resetPSSystemId();
                return true;
            }
            case 25: {
                pSDEGroupBase.resetPSSystemName();
                return true;
            }
            case 26: {
                pSDEGroupBase.resetUpdateDate();
                return true;
            }
            case 27: {
                pSDEGroupBase.resetUpdateMan();
                return true;
            }
            case 28: {
                pSDEGroupBase.resetUserCat();
                return true;
            }
            case 29: {
                pSDEGroupBase.resetUserTag();
                return true;
            }
            case 30: {
                pSDEGroupBase.resetUserTag2();
                return true;
            }
            case 31: {
                pSDEGroupBase.resetUserTag3();
                return true;
            }
            case 32: {
                pSDEGroupBase.resetUserTag4();
                return true;
            }
            case 33: {
                pSDEGroupBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getPSDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDE();
        }
        if (this.getPSDEId() == null) {
            return null;
        }
        Integer n = this.objPSDELock;
        synchronized (n) {
            if (this.psde != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEId(), (Object)this.psde.getPSDataEntityId()) != 0L) {
                this.psde = null;
            }
            if (this.psde == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getPSDEId());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet((IEntity)pSDataEntity);
                this.psde = pSDataEntity;
            }
            return this.psde;
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
                pSModuleService.autoGet((IEntity)pSModule);
                this.psmodule = pSModule;
            }
            return this.psmodule;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysDynaModel getInitPSSysDynaModel() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInitPSSysDynaModel();
        }
        if (this.getInitPSSysDynaModelId() == null) {
            return null;
        }
        Integer n = this.objInitPSSysDynaModelLock;
        synchronized (n) {
            if (this.initpssysdynamodel != null && DataTypeHelper.compare((int)25, (Object)this.getInitPSSysDynaModelId(), (Object)this.initpssysdynamodel.getPSSysDynaModelId()) != 0L) {
                this.initpssysdynamodel = null;
            }
            if (this.initpssysdynamodel == null) {
                PSSysDynaModel pSSysDynaModel = new PSSysDynaModel();
                pSSysDynaModel.setPSSysDynaModelId(this.getInitPSSysDynaModelId());
                PSSysDynaModelService pSSysDynaModelService = (PSSysDynaModelService)ServiceGlobal.getService(PSSysDynaModelService.class, (SessionFactory)this.getSessionFactory());
                pSSysDynaModelService.autoGet((IEntity)pSSysDynaModel);
                this.initpssysdynamodel = pSSysDynaModel;
            }
            return this.initpssysdynamodel;
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
                pSSysDynaModelService.autoGet((IEntity)pSSysDynaModel);
                this.pssysdynamodel = pSSysDynaModel;
            }
            return this.pssysdynamodel;
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
                pSSystemService.autoGet((IEntity)pSSystem);
                this.pssystem = pSSystem;
            }
            return this.pssystem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEGroupDetail> getPSDEGroupDetails() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGroupDetails();
        }
        if (this.getPSDEGroupId() == null) {
            return null;
        }
        PSDEGroupService pSDEGroupService = (PSDEGroupService)ServiceGlobal.getService(PSDEGroupService.class, (SessionFactory)this.getSessionFactory());
        PSDEGroupDetailService pSDEGroupDetailService = (PSDEGroupDetailService)ServiceGlobal.getService(PSDEGroupDetailService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEGroupDetailsLock;
        synchronized (n) {
            if (this.psdegroupdetails == null) {
                this.psdegroupdetails = pSDEGroupService.isTempData((IEntity)this) ? pSDEGroupDetailService.selectTempByPSDEGroup(this) : pSDEGroupDetailService.selectByPSDEGroup(this);
            }
            return this.psdegroupdetails;
        }
    }

    private PSDEGroupBase getProxyEntity() {
        return this.proxyPSDEGroupBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEGroupBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEGroupBase) {
            this.proxyPSDEGroupBase = (PSDEGroupBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEGroupService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CODENAME2, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_GROUPCAT, 4);
        fieldIndexMap.put(FIELD_GROUPTAG, 5);
        fieldIndexMap.put(FIELD_GROUPTAG2, 6);
        fieldIndexMap.put(FIELD_INITPSSYSDYNAMODELID, 7);
        fieldIndexMap.put(FIELD_INITPSSYSDYNAMODELNAME, 8);
        fieldIndexMap.put(FIELD_LOGICMODE, 9);
        fieldIndexMap.put(FIELD_LOGICPARAM, 10);
        fieldIndexMap.put(FIELD_LOGICPARAM2, 11);
        fieldIndexMap.put(FIELD_MEMO, 12);
        fieldIndexMap.put(FIELD_ORDERVALUE, 13);
        fieldIndexMap.put(FIELD_PSDEGROUPID, 14);
        fieldIndexMap.put(FIELD_PSDEGROUPNAME, 15);
        fieldIndexMap.put(FIELD_PSDEID, 16);
        fieldIndexMap.put(FIELD_PSDENAME, 17);
        fieldIndexMap.put(FIELD_PSMODULEID, 18);
        fieldIndexMap.put(FIELD_PSMODULENAME, 19);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 20);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 21);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 22);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 23);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 24);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 25);
        fieldIndexMap.put(FIELD_UPDATEDATE, 26);
        fieldIndexMap.put(FIELD_UPDATEMAN, 27);
        fieldIndexMap.put(FIELD_USERCAT, 28);
        fieldIndexMap.put(FIELD_USERTAG, 29);
        fieldIndexMap.put(FIELD_USERTAG2, 30);
        fieldIndexMap.put(FIELD_USERTAG3, 31);
        fieldIndexMap.put(FIELD_USERTAG4, 32);
        fieldIndexMap.put(FIELD_VALIDFLAG, 33);
    }
}

