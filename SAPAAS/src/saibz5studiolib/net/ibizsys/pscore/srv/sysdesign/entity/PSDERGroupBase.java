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
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDERGroupDetail;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSDERGroupDetailService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDERGroupService;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDERGroupBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDERGroupBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CODENAME2 = "CODENAME2";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_GROUPTAG = "GROUPTAG";
    public static final String FIELD_GROUPTAG2 = "GROUPTAG2";
    public static final String FIELD_INITPSSYSDYNAMODELID = "INITPSSYSDYNAMODELID";
    public static final String FIELD_INITPSSYSDYNAMODELNAME = "INITPSSYSDYNAMODELNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDERGROUPID = "PSDERGROUPID";
    public static final String FIELD_PSDERGROUPNAME = "PSDERGROUPNAME";
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
    private static final int INDEX_GROUPTAG = 4;
    private static final int INDEX_GROUPTAG2 = 5;
    private static final int INDEX_INITPSSYSDYNAMODELID = 6;
    private static final int INDEX_INITPSSYSDYNAMODELNAME = 7;
    private static final int INDEX_MEMO = 8;
    private static final int INDEX_ORDERVALUE = 9;
    private static final int INDEX_PSDEID = 10;
    private static final int INDEX_PSDENAME = 11;
    private static final int INDEX_PSDERGROUPID = 12;
    private static final int INDEX_PSDERGROUPNAME = 13;
    private static final int INDEX_PSMODULEID = 14;
    private static final int INDEX_PSMODULENAME = 15;
    private static final int INDEX_PSSYSDYNAMODELID = 16;
    private static final int INDEX_PSSYSDYNAMODELNAME = 17;
    private static final int INDEX_PSSYSSFPLUGINID = 18;
    private static final int INDEX_PSSYSSFPLUGINNAME = 19;
    private static final int INDEX_PSSYSTEMID = 20;
    private static final int INDEX_PSSYSTEMNAME = 21;
    private static final int INDEX_UPDATEDATE = 22;
    private static final int INDEX_UPDATEMAN = 23;
    private static final int INDEX_USERCAT = 24;
    private static final int INDEX_USERTAG = 25;
    private static final int INDEX_USERTAG2 = 26;
    private static final int INDEX_USERTAG3 = 27;
    private static final int INDEX_USERTAG4 = 28;
    private static final int INDEX_VALIDFLAG = 29;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDERGroupBase proxyPSDERGroupBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean codename2DirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean grouptagDirtyFlag = false;
    private boolean grouptag2DirtyFlag = false;
    private boolean initpssysdynamodelidDirtyFlag = false;
    private boolean initpssysdynamodelnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psdergroupidDirtyFlag = false;
    private boolean psdergroupnameDirtyFlag = false;
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
    @Column(name="grouptag")
    private String grouptag;
    @Column(name="grouptag2")
    private String grouptag2;
    @Column(name="initpssysdynamodelid")
    private String initpssysdynamodelid;
    @Column(name="initpssysdynamodelname")
    private String initpssysdynamodelname;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psdergroupid")
    private String psdergroupid;
    @Column(name="psdergroupname")
    private String psdergroupname;
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
    private Integer objPSDERGroupDetailsLock = new Integer(1);
    private ArrayList<PSDERGroupDetail> psdergroupdetails = null;

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

    public void setPSDERGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDERGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdergroupid = string;
        this.psdergroupidDirtyFlag = true;
    }

    public String getPSDERGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDERGroupId();
        }
        return this.psdergroupid;
    }

    public boolean isPSDERGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDERGroupIdDirty();
        }
        return this.psdergroupidDirtyFlag;
    }

    public void resetPSDERGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDERGroupId();
            return;
        }
        this.psdergroupidDirtyFlag = false;
        this.psdergroupid = null;
    }

    public void setPSDERGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDERGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdergroupname = string;
        this.psdergroupnameDirtyFlag = true;
    }

    public String getPSDERGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDERGroupName();
        }
        return this.psdergroupname;
    }

    public boolean isPSDERGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDERGroupNameDirty();
        }
        return this.psdergroupnameDirtyFlag;
    }

    public void resetPSDERGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDERGroupName();
            return;
        }
        this.psdergroupnameDirtyFlag = false;
        this.psdergroupname = null;
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
        PSDERGroupBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDERGroupBase pSDERGroupBase) {
        pSDERGroupBase.resetCodeName();
        pSDERGroupBase.resetCodeName2();
        pSDERGroupBase.resetCreateDate();
        pSDERGroupBase.resetCreateMan();
        pSDERGroupBase.resetGroupTag();
        pSDERGroupBase.resetGroupTag2();
        pSDERGroupBase.resetInitPSSysDynaModelId();
        pSDERGroupBase.resetInitPSSysDynaModelName();
        pSDERGroupBase.resetMemo();
        pSDERGroupBase.resetOrderValue();
        pSDERGroupBase.resetPSDEId();
        pSDERGroupBase.resetPSDEName();
        pSDERGroupBase.resetPSDERGroupId();
        pSDERGroupBase.resetPSDERGroupName();
        pSDERGroupBase.resetPSModuleId();
        pSDERGroupBase.resetPSModuleName();
        pSDERGroupBase.resetPSSysDynaModelId();
        pSDERGroupBase.resetPSSysDynaModelName();
        pSDERGroupBase.resetPSSysSFPluginId();
        pSDERGroupBase.resetPSSysSFPluginName();
        pSDERGroupBase.resetPSSystemId();
        pSDERGroupBase.resetPSSystemName();
        pSDERGroupBase.resetUpdateDate();
        pSDERGroupBase.resetUpdateMan();
        pSDERGroupBase.resetUserCat();
        pSDERGroupBase.resetUserTag();
        pSDERGroupBase.resetUserTag2();
        pSDERGroupBase.resetUserTag3();
        pSDERGroupBase.resetUserTag4();
        pSDERGroupBase.resetValidFlag();
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
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSDERGroupIdDirty()) {
            hashMap.put(FIELD_PSDERGROUPID, this.getPSDERGroupId());
        }
        if (!bl || this.isPSDERGroupNameDirty()) {
            hashMap.put(FIELD_PSDERGROUPNAME, this.getPSDERGroupName());
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
        return PSDERGroupBase.get(this, n);
    }

    private static Object get(PSDERGroupBase pSDERGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDERGroupBase.getCodeName();
            }
            case 1: {
                return pSDERGroupBase.getCodeName2();
            }
            case 2: {
                return pSDERGroupBase.getCreateDate();
            }
            case 3: {
                return pSDERGroupBase.getCreateMan();
            }
            case 4: {
                return pSDERGroupBase.getGroupTag();
            }
            case 5: {
                return pSDERGroupBase.getGroupTag2();
            }
            case 6: {
                return pSDERGroupBase.getInitPSSysDynaModelId();
            }
            case 7: {
                return pSDERGroupBase.getInitPSSysDynaModelName();
            }
            case 8: {
                return pSDERGroupBase.getMemo();
            }
            case 9: {
                return pSDERGroupBase.getOrderValue();
            }
            case 10: {
                return pSDERGroupBase.getPSDEId();
            }
            case 11: {
                return pSDERGroupBase.getPSDEName();
            }
            case 12: {
                return pSDERGroupBase.getPSDERGroupId();
            }
            case 13: {
                return pSDERGroupBase.getPSDERGroupName();
            }
            case 14: {
                return pSDERGroupBase.getPSModuleId();
            }
            case 15: {
                return pSDERGroupBase.getPSModuleName();
            }
            case 16: {
                return pSDERGroupBase.getPSSysDynaModelId();
            }
            case 17: {
                return pSDERGroupBase.getPSSysDynaModelName();
            }
            case 18: {
                return pSDERGroupBase.getPSSysSFPluginId();
            }
            case 19: {
                return pSDERGroupBase.getPSSysSFPluginName();
            }
            case 20: {
                return pSDERGroupBase.getPSSystemId();
            }
            case 21: {
                return pSDERGroupBase.getPSSystemName();
            }
            case 22: {
                return pSDERGroupBase.getUpdateDate();
            }
            case 23: {
                return pSDERGroupBase.getUpdateMan();
            }
            case 24: {
                return pSDERGroupBase.getUserCat();
            }
            case 25: {
                return pSDERGroupBase.getUserTag();
            }
            case 26: {
                return pSDERGroupBase.getUserTag2();
            }
            case 27: {
                return pSDERGroupBase.getUserTag3();
            }
            case 28: {
                return pSDERGroupBase.getUserTag4();
            }
            case 29: {
                return pSDERGroupBase.getValidFlag();
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
        PSDERGroupBase.set(this, n, object);
    }

    private static void set(PSDERGroupBase pSDERGroupBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDERGroupBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDERGroupBase.setCodeName2(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDERGroupBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSDERGroupBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDERGroupBase.setGroupTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDERGroupBase.setGroupTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDERGroupBase.setInitPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDERGroupBase.setInitPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDERGroupBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDERGroupBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSDERGroupBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDERGroupBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDERGroupBase.setPSDERGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDERGroupBase.setPSDERGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDERGroupBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDERGroupBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDERGroupBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDERGroupBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDERGroupBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDERGroupBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDERGroupBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDERGroupBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDERGroupBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 23: {
                pSDERGroupBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDERGroupBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDERGroupBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDERGroupBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDERGroupBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDERGroupBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDERGroupBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDERGroupBase.isNull(this, n);
    }

    private static boolean isNull(PSDERGroupBase pSDERGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDERGroupBase.getCodeName() == null;
            }
            case 1: {
                return pSDERGroupBase.getCodeName2() == null;
            }
            case 2: {
                return pSDERGroupBase.getCreateDate() == null;
            }
            case 3: {
                return pSDERGroupBase.getCreateMan() == null;
            }
            case 4: {
                return pSDERGroupBase.getGroupTag() == null;
            }
            case 5: {
                return pSDERGroupBase.getGroupTag2() == null;
            }
            case 6: {
                return pSDERGroupBase.getInitPSSysDynaModelId() == null;
            }
            case 7: {
                return pSDERGroupBase.getInitPSSysDynaModelName() == null;
            }
            case 8: {
                return pSDERGroupBase.getMemo() == null;
            }
            case 9: {
                return pSDERGroupBase.getOrderValue() == null;
            }
            case 10: {
                return pSDERGroupBase.getPSDEId() == null;
            }
            case 11: {
                return pSDERGroupBase.getPSDEName() == null;
            }
            case 12: {
                return pSDERGroupBase.getPSDERGroupId() == null;
            }
            case 13: {
                return pSDERGroupBase.getPSDERGroupName() == null;
            }
            case 14: {
                return pSDERGroupBase.getPSModuleId() == null;
            }
            case 15: {
                return pSDERGroupBase.getPSModuleName() == null;
            }
            case 16: {
                return pSDERGroupBase.getPSSysDynaModelId() == null;
            }
            case 17: {
                return pSDERGroupBase.getPSSysDynaModelName() == null;
            }
            case 18: {
                return pSDERGroupBase.getPSSysSFPluginId() == null;
            }
            case 19: {
                return pSDERGroupBase.getPSSysSFPluginName() == null;
            }
            case 20: {
                return pSDERGroupBase.getPSSystemId() == null;
            }
            case 21: {
                return pSDERGroupBase.getPSSystemName() == null;
            }
            case 22: {
                return pSDERGroupBase.getUpdateDate() == null;
            }
            case 23: {
                return pSDERGroupBase.getUpdateMan() == null;
            }
            case 24: {
                return pSDERGroupBase.getUserCat() == null;
            }
            case 25: {
                return pSDERGroupBase.getUserTag() == null;
            }
            case 26: {
                return pSDERGroupBase.getUserTag2() == null;
            }
            case 27: {
                return pSDERGroupBase.getUserTag3() == null;
            }
            case 28: {
                return pSDERGroupBase.getUserTag4() == null;
            }
            case 29: {
                return pSDERGroupBase.getValidFlag() == null;
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
        return PSDERGroupBase.contains(this, n);
    }

    private static boolean contains(PSDERGroupBase pSDERGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDERGroupBase.isCodeNameDirty();
            }
            case 1: {
                return pSDERGroupBase.isCodeName2Dirty();
            }
            case 2: {
                return pSDERGroupBase.isCreateDateDirty();
            }
            case 3: {
                return pSDERGroupBase.isCreateManDirty();
            }
            case 4: {
                return pSDERGroupBase.isGroupTagDirty();
            }
            case 5: {
                return pSDERGroupBase.isGroupTag2Dirty();
            }
            case 6: {
                return pSDERGroupBase.isInitPSSysDynaModelIdDirty();
            }
            case 7: {
                return pSDERGroupBase.isInitPSSysDynaModelNameDirty();
            }
            case 8: {
                return pSDERGroupBase.isMemoDirty();
            }
            case 9: {
                return pSDERGroupBase.isOrderValueDirty();
            }
            case 10: {
                return pSDERGroupBase.isPSDEIdDirty();
            }
            case 11: {
                return pSDERGroupBase.isPSDENameDirty();
            }
            case 12: {
                return pSDERGroupBase.isPSDERGroupIdDirty();
            }
            case 13: {
                return pSDERGroupBase.isPSDERGroupNameDirty();
            }
            case 14: {
                return pSDERGroupBase.isPSModuleIdDirty();
            }
            case 15: {
                return pSDERGroupBase.isPSModuleNameDirty();
            }
            case 16: {
                return pSDERGroupBase.isPSSysDynaModelIdDirty();
            }
            case 17: {
                return pSDERGroupBase.isPSSysDynaModelNameDirty();
            }
            case 18: {
                return pSDERGroupBase.isPSSysSFPluginIdDirty();
            }
            case 19: {
                return pSDERGroupBase.isPSSysSFPluginNameDirty();
            }
            case 20: {
                return pSDERGroupBase.isPSSystemIdDirty();
            }
            case 21: {
                return pSDERGroupBase.isPSSystemNameDirty();
            }
            case 22: {
                return pSDERGroupBase.isUpdateDateDirty();
            }
            case 23: {
                return pSDERGroupBase.isUpdateManDirty();
            }
            case 24: {
                return pSDERGroupBase.isUserCatDirty();
            }
            case 25: {
                return pSDERGroupBase.isUserTagDirty();
            }
            case 26: {
                return pSDERGroupBase.isUserTag2Dirty();
            }
            case 27: {
                return pSDERGroupBase.isUserTag3Dirty();
            }
            case 28: {
                return pSDERGroupBase.isUserTag4Dirty();
            }
            case 29: {
                return pSDERGroupBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDERGroupBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDERGroupBase pSDERGroupBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDERGroupBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDERGroupBase.getJSONValue((Object)pSDERGroupBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDERGroupBase.getCodeName2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename2", (Object)PSDERGroupBase.getJSONValue((Object)pSDERGroupBase.getCodeName2()), (boolean)false);
        }
        if (bl || pSDERGroupBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDERGroupBase.getJSONValue((Object)pSDERGroupBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDERGroupBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDERGroupBase.getJSONValue((Object)pSDERGroupBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDERGroupBase.getGroupTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouptag", (Object)PSDERGroupBase.getJSONValue((Object)pSDERGroupBase.getGroupTag()), (boolean)false);
        }
        if (bl || pSDERGroupBase.getGroupTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouptag2", (Object)PSDERGroupBase.getJSONValue((Object)pSDERGroupBase.getGroupTag2()), (boolean)false);
        }
        if (bl || pSDERGroupBase.getInitPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"initpssysdynamodelid", (Object)PSDERGroupBase.getJSONValue((Object)pSDERGroupBase.getInitPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSDERGroupBase.getInitPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"initpssysdynamodelname", (Object)PSDERGroupBase.getJSONValue((Object)pSDERGroupBase.getInitPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSDERGroupBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDERGroupBase.getJSONValue((Object)pSDERGroupBase.getMemo()), (boolean)false);
        }
        if (bl || pSDERGroupBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDERGroupBase.getJSONValue((Object)pSDERGroupBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDERGroupBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDERGroupBase.getJSONValue((Object)pSDERGroupBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDERGroupBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDERGroupBase.getJSONValue((Object)pSDERGroupBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDERGroupBase.getPSDERGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdergroupid", (Object)PSDERGroupBase.getJSONValue((Object)pSDERGroupBase.getPSDERGroupId()), (boolean)false);
        }
        if (bl || pSDERGroupBase.getPSDERGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdergroupname", (Object)PSDERGroupBase.getJSONValue((Object)pSDERGroupBase.getPSDERGroupName()), (boolean)false);
        }
        if (bl || pSDERGroupBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSDERGroupBase.getJSONValue((Object)pSDERGroupBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSDERGroupBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSDERGroupBase.getJSONValue((Object)pSDERGroupBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSDERGroupBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSDERGroupBase.getJSONValue((Object)pSDERGroupBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSDERGroupBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSDERGroupBase.getJSONValue((Object)pSDERGroupBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSDERGroupBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSDERGroupBase.getJSONValue((Object)pSDERGroupBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSDERGroupBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSDERGroupBase.getJSONValue((Object)pSDERGroupBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSDERGroupBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSDERGroupBase.getJSONValue((Object)pSDERGroupBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSDERGroupBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSDERGroupBase.getJSONValue((Object)pSDERGroupBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSDERGroupBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDERGroupBase.getJSONValue((Object)pSDERGroupBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDERGroupBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDERGroupBase.getJSONValue((Object)pSDERGroupBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDERGroupBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDERGroupBase.getJSONValue((Object)pSDERGroupBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDERGroupBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDERGroupBase.getJSONValue((Object)pSDERGroupBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDERGroupBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDERGroupBase.getJSONValue((Object)pSDERGroupBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDERGroupBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDERGroupBase.getJSONValue((Object)pSDERGroupBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDERGroupBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDERGroupBase.getJSONValue((Object)pSDERGroupBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDERGroupBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDERGroupBase.getJSONValue((Object)pSDERGroupBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDERGroupBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDERGroupBase pSDERGroupBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDERGroupBase.getCodeName() != null) {
            object = pSDERGroupBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, (String)(object == null ? "" : object));
        }
        if (bl || pSDERGroupBase.getCodeName2() != null) {
            object = pSDERGroupBase.getCodeName2();
            xmlNode.setAttribute(FIELD_CODENAME2, object == null ? "" : (String)object);
        }
        if (bl || pSDERGroupBase.getCreateDate() != null) {
            object = pSDERGroupBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDERGroupBase.getCreateMan() != null) {
            object = pSDERGroupBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDERGroupBase.getGroupTag() != null) {
            object = pSDERGroupBase.getGroupTag();
            xmlNode.setAttribute(FIELD_GROUPTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDERGroupBase.getGroupTag2() != null) {
            object = pSDERGroupBase.getGroupTag2();
            xmlNode.setAttribute(FIELD_GROUPTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDERGroupBase.getInitPSSysDynaModelId() != null) {
            object = pSDERGroupBase.getInitPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_INITPSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSDERGroupBase.getInitPSSysDynaModelName() != null) {
            object = pSDERGroupBase.getInitPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_INITPSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDERGroupBase.getMemo() != null) {
            object = pSDERGroupBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDERGroupBase.getOrderValue() != null) {
            object = pSDERGroupBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDERGroupBase.getPSDEId() != null) {
            object = pSDERGroupBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDERGroupBase.getPSDEName() != null) {
            object = pSDERGroupBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDERGroupBase.getPSDERGroupId() != null) {
            object = pSDERGroupBase.getPSDERGroupId();
            xmlNode.setAttribute(FIELD_PSDERGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDERGroupBase.getPSDERGroupName() != null) {
            object = pSDERGroupBase.getPSDERGroupName();
            xmlNode.setAttribute(FIELD_PSDERGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDERGroupBase.getPSModuleId() != null) {
            object = pSDERGroupBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSDERGroupBase.getPSModuleName() != null) {
            object = pSDERGroupBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDERGroupBase.getPSSysDynaModelId() != null) {
            object = pSDERGroupBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSDERGroupBase.getPSSysDynaModelName() != null) {
            object = pSDERGroupBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDERGroupBase.getPSSysSFPluginId() != null) {
            object = pSDERGroupBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDERGroupBase.getPSSysSFPluginName() != null) {
            object = pSDERGroupBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDERGroupBase.getPSSystemId() != null) {
            object = pSDERGroupBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDERGroupBase.getPSSystemName() != null) {
            object = pSDERGroupBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDERGroupBase.getUpdateDate() != null) {
            object = pSDERGroupBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDERGroupBase.getUpdateMan() != null) {
            object = pSDERGroupBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDERGroupBase.getUserCat() != null) {
            object = pSDERGroupBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDERGroupBase.getUserTag() != null) {
            object = pSDERGroupBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDERGroupBase.getUserTag2() != null) {
            object = pSDERGroupBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDERGroupBase.getUserTag3() != null) {
            object = pSDERGroupBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDERGroupBase.getUserTag4() != null) {
            object = pSDERGroupBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDERGroupBase.getValidFlag() != null) {
            object = pSDERGroupBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDERGroupBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDERGroupBase pSDERGroupBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDERGroupBase.isCodeNameDirty() && (bl || pSDERGroupBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDERGroupBase.getCodeName());
        }
        if (pSDERGroupBase.isCodeName2Dirty() && (bl || pSDERGroupBase.getCodeName2() != null)) {
            iDataObject.set(FIELD_CODENAME2, (Object)pSDERGroupBase.getCodeName2());
        }
        if (pSDERGroupBase.isCreateDateDirty() && (bl || pSDERGroupBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDERGroupBase.getCreateDate());
        }
        if (pSDERGroupBase.isCreateManDirty() && (bl || pSDERGroupBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDERGroupBase.getCreateMan());
        }
        if (pSDERGroupBase.isGroupTagDirty() && (bl || pSDERGroupBase.getGroupTag() != null)) {
            iDataObject.set(FIELD_GROUPTAG, (Object)pSDERGroupBase.getGroupTag());
        }
        if (pSDERGroupBase.isGroupTag2Dirty() && (bl || pSDERGroupBase.getGroupTag2() != null)) {
            iDataObject.set(FIELD_GROUPTAG2, (Object)pSDERGroupBase.getGroupTag2());
        }
        if (pSDERGroupBase.isInitPSSysDynaModelIdDirty() && (bl || pSDERGroupBase.getInitPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_INITPSSYSDYNAMODELID, (Object)pSDERGroupBase.getInitPSSysDynaModelId());
        }
        if (pSDERGroupBase.isInitPSSysDynaModelNameDirty() && (bl || pSDERGroupBase.getInitPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_INITPSSYSDYNAMODELNAME, (Object)pSDERGroupBase.getInitPSSysDynaModelName());
        }
        if (pSDERGroupBase.isMemoDirty() && (bl || pSDERGroupBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDERGroupBase.getMemo());
        }
        if (pSDERGroupBase.isOrderValueDirty() && (bl || pSDERGroupBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDERGroupBase.getOrderValue());
        }
        if (pSDERGroupBase.isPSDEIdDirty() && (bl || pSDERGroupBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDERGroupBase.getPSDEId());
        }
        if (pSDERGroupBase.isPSDENameDirty() && (bl || pSDERGroupBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDERGroupBase.getPSDEName());
        }
        if (pSDERGroupBase.isPSDERGroupIdDirty() && (bl || pSDERGroupBase.getPSDERGroupId() != null)) {
            iDataObject.set(FIELD_PSDERGROUPID, (Object)pSDERGroupBase.getPSDERGroupId());
        }
        if (pSDERGroupBase.isPSDERGroupNameDirty() && (bl || pSDERGroupBase.getPSDERGroupName() != null)) {
            iDataObject.set(FIELD_PSDERGROUPNAME, (Object)pSDERGroupBase.getPSDERGroupName());
        }
        if (pSDERGroupBase.isPSModuleIdDirty() && (bl || pSDERGroupBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSDERGroupBase.getPSModuleId());
        }
        if (pSDERGroupBase.isPSModuleNameDirty() && (bl || pSDERGroupBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSDERGroupBase.getPSModuleName());
        }
        if (pSDERGroupBase.isPSSysDynaModelIdDirty() && (bl || pSDERGroupBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSDERGroupBase.getPSSysDynaModelId());
        }
        if (pSDERGroupBase.isPSSysDynaModelNameDirty() && (bl || pSDERGroupBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSDERGroupBase.getPSSysDynaModelName());
        }
        if (pSDERGroupBase.isPSSysSFPluginIdDirty() && (bl || pSDERGroupBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSDERGroupBase.getPSSysSFPluginId());
        }
        if (pSDERGroupBase.isPSSysSFPluginNameDirty() && (bl || pSDERGroupBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSDERGroupBase.getPSSysSFPluginName());
        }
        if (pSDERGroupBase.isPSSystemIdDirty() && (bl || pSDERGroupBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSDERGroupBase.getPSSystemId());
        }
        if (pSDERGroupBase.isPSSystemNameDirty() && (bl || pSDERGroupBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSDERGroupBase.getPSSystemName());
        }
        if (pSDERGroupBase.isUpdateDateDirty() && (bl || pSDERGroupBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDERGroupBase.getUpdateDate());
        }
        if (pSDERGroupBase.isUpdateManDirty() && (bl || pSDERGroupBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDERGroupBase.getUpdateMan());
        }
        if (pSDERGroupBase.isUserCatDirty() && (bl || pSDERGroupBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDERGroupBase.getUserCat());
        }
        if (pSDERGroupBase.isUserTagDirty() && (bl || pSDERGroupBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDERGroupBase.getUserTag());
        }
        if (pSDERGroupBase.isUserTag2Dirty() && (bl || pSDERGroupBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDERGroupBase.getUserTag2());
        }
        if (pSDERGroupBase.isUserTag3Dirty() && (bl || pSDERGroupBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDERGroupBase.getUserTag3());
        }
        if (pSDERGroupBase.isUserTag4Dirty() && (bl || pSDERGroupBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDERGroupBase.getUserTag4());
        }
        if (pSDERGroupBase.isValidFlagDirty() && (bl || pSDERGroupBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDERGroupBase.getValidFlag());
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
        return PSDERGroupBase.remove(this, n);
    }

    private static boolean remove(PSDERGroupBase pSDERGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDERGroupBase.resetCodeName();
                return true;
            }
            case 1: {
                pSDERGroupBase.resetCodeName2();
                return true;
            }
            case 2: {
                pSDERGroupBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSDERGroupBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSDERGroupBase.resetGroupTag();
                return true;
            }
            case 5: {
                pSDERGroupBase.resetGroupTag2();
                return true;
            }
            case 6: {
                pSDERGroupBase.resetInitPSSysDynaModelId();
                return true;
            }
            case 7: {
                pSDERGroupBase.resetInitPSSysDynaModelName();
                return true;
            }
            case 8: {
                pSDERGroupBase.resetMemo();
                return true;
            }
            case 9: {
                pSDERGroupBase.resetOrderValue();
                return true;
            }
            case 10: {
                pSDERGroupBase.resetPSDEId();
                return true;
            }
            case 11: {
                pSDERGroupBase.resetPSDEName();
                return true;
            }
            case 12: {
                pSDERGroupBase.resetPSDERGroupId();
                return true;
            }
            case 13: {
                pSDERGroupBase.resetPSDERGroupName();
                return true;
            }
            case 14: {
                pSDERGroupBase.resetPSModuleId();
                return true;
            }
            case 15: {
                pSDERGroupBase.resetPSModuleName();
                return true;
            }
            case 16: {
                pSDERGroupBase.resetPSSysDynaModelId();
                return true;
            }
            case 17: {
                pSDERGroupBase.resetPSSysDynaModelName();
                return true;
            }
            case 18: {
                pSDERGroupBase.resetPSSysSFPluginId();
                return true;
            }
            case 19: {
                pSDERGroupBase.resetPSSysSFPluginName();
                return true;
            }
            case 20: {
                pSDERGroupBase.resetPSSystemId();
                return true;
            }
            case 21: {
                pSDERGroupBase.resetPSSystemName();
                return true;
            }
            case 22: {
                pSDERGroupBase.resetUpdateDate();
                return true;
            }
            case 23: {
                pSDERGroupBase.resetUpdateMan();
                return true;
            }
            case 24: {
                pSDERGroupBase.resetUserCat();
                return true;
            }
            case 25: {
                pSDERGroupBase.resetUserTag();
                return true;
            }
            case 26: {
                pSDERGroupBase.resetUserTag2();
                return true;
            }
            case 27: {
                pSDERGroupBase.resetUserTag3();
                return true;
            }
            case 28: {
                pSDERGroupBase.resetUserTag4();
                return true;
            }
            case 29: {
                pSDERGroupBase.resetValidFlag();
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
    public ArrayList<PSDERGroupDetail> getPSDERGroupDetails() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDERGroupDetails();
        }
        if (this.getPSDERGroupId() == null) {
            return null;
        }
        PSDERGroupService pSDERGroupService = (PSDERGroupService)ServiceGlobal.getService(PSDERGroupService.class, (SessionFactory)this.getSessionFactory());
        PSDERGroupDetailService pSDERGroupDetailService = (PSDERGroupDetailService)ServiceGlobal.getService(PSDERGroupDetailService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDERGroupDetailsLock;
        synchronized (n) {
            if (this.psdergroupdetails == null) {
                this.psdergroupdetails = pSDERGroupService.isTempData((IEntity)this) ? pSDERGroupDetailService.selectTempByPSDERGroup(this) : pSDERGroupDetailService.selectByPSDERGroup(this);
            }
            return this.psdergroupdetails;
        }
    }

    private PSDERGroupBase getProxyEntity() {
        return this.proxyPSDERGroupBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDERGroupBase = null;
        if (iDataObject != null && iDataObject instanceof PSDERGroupBase) {
            this.proxyPSDERGroupBase = (PSDERGroupBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDERGroupService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CODENAME2, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_GROUPTAG, 4);
        fieldIndexMap.put(FIELD_GROUPTAG2, 5);
        fieldIndexMap.put(FIELD_INITPSSYSDYNAMODELID, 6);
        fieldIndexMap.put(FIELD_INITPSSYSDYNAMODELNAME, 7);
        fieldIndexMap.put(FIELD_MEMO, 8);
        fieldIndexMap.put(FIELD_ORDERVALUE, 9);
        fieldIndexMap.put(FIELD_PSDEID, 10);
        fieldIndexMap.put(FIELD_PSDENAME, 11);
        fieldIndexMap.put(FIELD_PSDERGROUPID, 12);
        fieldIndexMap.put(FIELD_PSDERGROUPNAME, 13);
        fieldIndexMap.put(FIELD_PSMODULEID, 14);
        fieldIndexMap.put(FIELD_PSMODULENAME, 15);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 16);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 17);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 18);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 19);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 20);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 21);
        fieldIndexMap.put(FIELD_UPDATEDATE, 22);
        fieldIndexMap.put(FIELD_UPDATEMAN, 23);
        fieldIndexMap.put(FIELD_USERCAT, 24);
        fieldIndexMap.put(FIELD_USERTAG, 25);
        fieldIndexMap.put(FIELD_USERTAG2, 26);
        fieldIndexMap.put(FIELD_USERTAG3, 27);
        fieldIndexMap.put(FIELD_USERTAG4, 28);
        fieldIndexMap.put(FIELD_VALIDFLAG, 29);
    }
}

