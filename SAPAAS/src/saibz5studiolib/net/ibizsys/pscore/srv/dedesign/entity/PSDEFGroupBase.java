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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFGroupDetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEForm;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGrid;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEVRGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFGroupDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEVRGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEFGroupBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEFGroupBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CODENAME2 = "CODENAME2";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMCODE = "CUSTOMCODE";
    public static final String FIELD_CUSTOMMODE = "CUSTOMMODE";
    public static final String FIELD_DTOCODENAME = "DTOCODENAME";
    public static final String FIELD_GROUPTAG = "GROUPTAG";
    public static final String FIELD_GROUPTAG2 = "GROUPTAG2";
    public static final String FIELD_GROUPTYPE = "GROUPTYPE";
    public static final String FIELD_INITPSSYSDYNAMODELID = "INITPSSYSDYNAMODELID";
    public static final String FIELD_INITPSSYSDYNAMODELNAME = "INITPSSYSDYNAMODELNAME";
    public static final String FIELD_LOGICMODE = "LOGICMODE";
    public static final String FIELD_LOGICPARAM = "LOGICPARAM";
    public static final String FIELD_LOGICPARAM2 = "LOGICPARAM2";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSDEFGROUPID = "PSDEFGROUPID";
    public static final String FIELD_PSDEFGROUPNAME = "PSDEFGROUPNAME";
    public static final String FIELD_PSDEFORMID = "PSDEFORMID";
    public static final String FIELD_PSDEFORMNAME = "PSDEFORMNAME";
    public static final String FIELD_PSDEGRIDID = "PSDEGRIDID";
    public static final String FIELD_PSDEGRIDNAME = "PSDEGRIDNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDEVRGROUPID = "PSDEVRGROUPID";
    public static final String FIELD_PSDEVRGROUPNAME = "PSDEVRGROUPNAME";
    public static final String FIELD_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String FIELD_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String FIELD_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String FIELD_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
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
    private static final int INDEX_CUSTOMCODE = 4;
    private static final int INDEX_CUSTOMMODE = 5;
    private static final int INDEX_DTOCODENAME = 6;
    private static final int INDEX_GROUPTAG = 7;
    private static final int INDEX_GROUPTAG2 = 8;
    private static final int INDEX_GROUPTYPE = 9;
    private static final int INDEX_INITPSSYSDYNAMODELID = 10;
    private static final int INDEX_INITPSSYSDYNAMODELNAME = 11;
    private static final int INDEX_LOGICMODE = 12;
    private static final int INDEX_LOGICPARAM = 13;
    private static final int INDEX_LOGICPARAM2 = 14;
    private static final int INDEX_MEMO = 15;
    private static final int INDEX_ORDERVALUE = 16;
    private static final int INDEX_PSDEFGROUPID = 17;
    private static final int INDEX_PSDEFGROUPNAME = 18;
    private static final int INDEX_PSDEFORMID = 19;
    private static final int INDEX_PSDEFORMNAME = 20;
    private static final int INDEX_PSDEGRIDID = 21;
    private static final int INDEX_PSDEGRIDNAME = 22;
    private static final int INDEX_PSDEID = 23;
    private static final int INDEX_PSDENAME = 24;
    private static final int INDEX_PSDEVRGROUPID = 25;
    private static final int INDEX_PSDEVRGROUPNAME = 26;
    private static final int INDEX_PSSYSDYNAMODELID = 27;
    private static final int INDEX_PSSYSDYNAMODELNAME = 28;
    private static final int INDEX_PSSYSSFPLUGINID = 29;
    private static final int INDEX_PSSYSSFPLUGINNAME = 30;
    private static final int INDEX_UPDATEDATE = 31;
    private static final int INDEX_UPDATEMAN = 32;
    private static final int INDEX_USERCAT = 33;
    private static final int INDEX_USERTAG = 34;
    private static final int INDEX_USERTAG2 = 35;
    private static final int INDEX_USERTAG3 = 36;
    private static final int INDEX_USERTAG4 = 37;
    private static final int INDEX_VALIDFLAG = 38;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEFGroupBase proxyPSDEFGroupBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean codename2DirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customcodeDirtyFlag = false;
    private boolean custommodeDirtyFlag = false;
    private boolean dtocodenameDirtyFlag = false;
    private boolean grouptagDirtyFlag = false;
    private boolean grouptag2DirtyFlag = false;
    private boolean grouptypeDirtyFlag = false;
    private boolean initpssysdynamodelidDirtyFlag = false;
    private boolean initpssysdynamodelnameDirtyFlag = false;
    private boolean logicmodeDirtyFlag = false;
    private boolean logicparamDirtyFlag = false;
    private boolean logicparam2DirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psdefgroupidDirtyFlag = false;
    private boolean psdefgroupnameDirtyFlag = false;
    private boolean psdeformidDirtyFlag = false;
    private boolean psdeformnameDirtyFlag = false;
    private boolean psdegrididDirtyFlag = false;
    private boolean psdegridnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psdevrgroupidDirtyFlag = false;
    private boolean psdevrgroupnameDirtyFlag = false;
    private boolean pssysdynamodelidDirtyFlag = false;
    private boolean pssysdynamodelnameDirtyFlag = false;
    private boolean pssyssfpluginidDirtyFlag = false;
    private boolean pssyssfpluginnameDirtyFlag = false;
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
    @Column(name="customcode")
    private String customcode;
    @Column(name="custommode")
    private Integer custommode;
    @Column(name="dtocodename")
    private String dtocodename;
    @Column(name="grouptag")
    private String grouptag;
    @Column(name="grouptag2")
    private String grouptag2;
    @Column(name="grouptype")
    private String grouptype;
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
    @Column(name="psdefgroupid")
    private String psdefgroupid;
    @Column(name="psdefgroupname")
    private String psdefgroupname;
    @Column(name="psdeformid")
    private String psdeformid;
    @Column(name="psdeformname")
    private String psdeformname;
    @Column(name="psdegridid")
    private String psdegridid;
    @Column(name="psdegridname")
    private String psdegridname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psdevrgroupid")
    private String psdevrgroupid;
    @Column(name="psdevrgroupname")
    private String psdevrgroupname;
    @Column(name="pssysdynamodelid")
    private String pssysdynamodelid;
    @Column(name="pssysdynamodelname")
    private String pssysdynamodelname;
    @Column(name="pssyssfpluginid")
    private String pssyssfpluginid;
    @Column(name="pssyssfpluginname")
    private String pssyssfpluginname;
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
    private Integer objPSDEFormLock = new Integer(1);
    private PSDEForm psdeform = null;
    private Integer objPSDEGridLock = new Integer(1);
    private PSDEGrid psdegrid = null;
    private Integer objPSDEVRGroupLock = new Integer(1);
    private PSDEVRGroup psdevrgroup = null;
    private Integer objInitPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel initpssysdynamodel = null;
    private Integer objPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel pssysdynamodel = null;
    private Integer objPSSysSFPluginLock = new Integer(1);
    private PSSysSFPlugin pssyssfplugin = null;
    private Integer objPSDEFGroupDetailsLock = new Integer(1);
    private ArrayList<PSDEFGroupDetail> psdefgroupdetails = null;

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

    public void setCustomCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.customcode = string;
        this.customcodeDirtyFlag = true;
    }

    public String getCustomCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomCode();
        }
        return this.customcode;
    }

    public boolean isCustomCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomCodeDirty();
        }
        return this.customcodeDirtyFlag;
    }

    public void resetCustomCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomCode();
            return;
        }
        this.customcodeDirtyFlag = false;
        this.customcode = null;
    }

    public void setCustomMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomMode(n);
            return;
        }
        this.custommode = n;
        this.custommodeDirtyFlag = true;
    }

    public Integer getCustomMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomMode();
        }
        return this.custommode;
    }

    public boolean isCustomModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomModeDirty();
        }
        return this.custommodeDirtyFlag;
    }

    public void resetCustomMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomMode();
            return;
        }
        this.custommodeDirtyFlag = false;
        this.custommode = null;
    }

    public void setDTOCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDTOCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dtocodename = string;
        this.dtocodenameDirtyFlag = true;
    }

    public String getDTOCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDTOCodeName();
        }
        return this.dtocodename;
    }

    public boolean isDTOCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDTOCodeNameDirty();
        }
        return this.dtocodenameDirtyFlag;
    }

    public void resetDTOCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDTOCodeName();
            return;
        }
        this.dtocodenameDirtyFlag = false;
        this.dtocodename = null;
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

    public void setGroupType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.grouptype = string;
        this.grouptypeDirtyFlag = true;
    }

    public String getGroupType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupType();
        }
        return this.grouptype;
    }

    public boolean isGroupTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupTypeDirty();
        }
        return this.grouptypeDirtyFlag;
    }

    public void resetGroupType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupType();
            return;
        }
        this.grouptypeDirtyFlag = false;
        this.grouptype = null;
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

    public void setPSDEFGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefgroupid = string;
        this.psdefgroupidDirtyFlag = true;
    }

    public String getPSDEFGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFGroupId();
        }
        return this.psdefgroupid;
    }

    public boolean isPSDEFGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFGroupIdDirty();
        }
        return this.psdefgroupidDirtyFlag;
    }

    public void resetPSDEFGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFGroupId();
            return;
        }
        this.psdefgroupidDirtyFlag = false;
        this.psdefgroupid = null;
    }

    public void setPSDEFGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefgroupname = string;
        this.psdefgroupnameDirtyFlag = true;
    }

    public String getPSDEFGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFGroupName();
        }
        return this.psdefgroupname;
    }

    public boolean isPSDEFGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFGroupNameDirty();
        }
        return this.psdefgroupnameDirtyFlag;
    }

    public void resetPSDEFGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFGroupName();
            return;
        }
        this.psdefgroupnameDirtyFlag = false;
        this.psdefgroupname = null;
    }

    public void setPSDEFormId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFormId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeformid = string;
        this.psdeformidDirtyFlag = true;
    }

    public String getPSDEFormId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFormId();
        }
        return this.psdeformid;
    }

    public boolean isPSDEFormIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFormIdDirty();
        }
        return this.psdeformidDirtyFlag;
    }

    public void resetPSDEFormId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFormId();
            return;
        }
        this.psdeformidDirtyFlag = false;
        this.psdeformid = null;
    }

    public void setPSDEFormName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFormName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeformname = string;
        this.psdeformnameDirtyFlag = true;
    }

    public String getPSDEFormName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFormName();
        }
        return this.psdeformname;
    }

    public boolean isPSDEFormNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFormNameDirty();
        }
        return this.psdeformnameDirtyFlag;
    }

    public void resetPSDEFormName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFormName();
            return;
        }
        this.psdeformnameDirtyFlag = false;
        this.psdeformname = null;
    }

    public void setPSDEGridId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEGridId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdegridid = string;
        this.psdegrididDirtyFlag = true;
    }

    public String getPSDEGridId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGridId();
        }
        return this.psdegridid;
    }

    public boolean isPSDEGridIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEGridIdDirty();
        }
        return this.psdegrididDirtyFlag;
    }

    public void resetPSDEGridId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEGridId();
            return;
        }
        this.psdegrididDirtyFlag = false;
        this.psdegridid = null;
    }

    public void setPSDEGridName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEGridName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdegridname = string;
        this.psdegridnameDirtyFlag = true;
    }

    public String getPSDEGridName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGridName();
        }
        return this.psdegridname;
    }

    public boolean isPSDEGridNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEGridNameDirty();
        }
        return this.psdegridnameDirtyFlag;
    }

    public void resetPSDEGridName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEGridName();
            return;
        }
        this.psdegridnameDirtyFlag = false;
        this.psdegridname = null;
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

    public void setPSDEVRGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEVRGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevrgroupid = string;
        this.psdevrgroupidDirtyFlag = true;
    }

    public String getPSDEVRGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEVRGroupId();
        }
        return this.psdevrgroupid;
    }

    public boolean isPSDEVRGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEVRGroupIdDirty();
        }
        return this.psdevrgroupidDirtyFlag;
    }

    public void resetPSDEVRGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEVRGroupId();
            return;
        }
        this.psdevrgroupidDirtyFlag = false;
        this.psdevrgroupid = null;
    }

    public void setPSDEVRGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEVRGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevrgroupname = string;
        this.psdevrgroupnameDirtyFlag = true;
    }

    public String getPSDEVRGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEVRGroupName();
        }
        return this.psdevrgroupname;
    }

    public boolean isPSDEVRGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEVRGroupNameDirty();
        }
        return this.psdevrgroupnameDirtyFlag;
    }

    public void resetPSDEVRGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEVRGroupName();
            return;
        }
        this.psdevrgroupnameDirtyFlag = false;
        this.psdevrgroupname = null;
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
        PSDEFGroupBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEFGroupBase pSDEFGroupBase) {
        pSDEFGroupBase.resetCodeName();
        pSDEFGroupBase.resetCodeName2();
        pSDEFGroupBase.resetCreateDate();
        pSDEFGroupBase.resetCreateMan();
        pSDEFGroupBase.resetCustomCode();
        pSDEFGroupBase.resetCustomMode();
        pSDEFGroupBase.resetDTOCodeName();
        pSDEFGroupBase.resetGroupTag();
        pSDEFGroupBase.resetGroupTag2();
        pSDEFGroupBase.resetGroupType();
        pSDEFGroupBase.resetInitPSSysDynaModelId();
        pSDEFGroupBase.resetInitPSSysDynaModelName();
        pSDEFGroupBase.resetLogicMode();
        pSDEFGroupBase.resetLogicParam();
        pSDEFGroupBase.resetLogicParam2();
        pSDEFGroupBase.resetMemo();
        pSDEFGroupBase.resetOrderValue();
        pSDEFGroupBase.resetPSDEFGroupId();
        pSDEFGroupBase.resetPSDEFGroupName();
        pSDEFGroupBase.resetPSDEFormId();
        pSDEFGroupBase.resetPSDEFormName();
        pSDEFGroupBase.resetPSDEGridId();
        pSDEFGroupBase.resetPSDEGridName();
        pSDEFGroupBase.resetPSDEId();
        pSDEFGroupBase.resetPSDEName();
        pSDEFGroupBase.resetPSDEVRGroupId();
        pSDEFGroupBase.resetPSDEVRGroupName();
        pSDEFGroupBase.resetPSSysDynaModelId();
        pSDEFGroupBase.resetPSSysDynaModelName();
        pSDEFGroupBase.resetPSSysSFPluginId();
        pSDEFGroupBase.resetPSSysSFPluginName();
        pSDEFGroupBase.resetUpdateDate();
        pSDEFGroupBase.resetUpdateMan();
        pSDEFGroupBase.resetUserCat();
        pSDEFGroupBase.resetUserTag();
        pSDEFGroupBase.resetUserTag2();
        pSDEFGroupBase.resetUserTag3();
        pSDEFGroupBase.resetUserTag4();
        pSDEFGroupBase.resetValidFlag();
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
        if (!bl || this.isCustomCodeDirty()) {
            hashMap.put(FIELD_CUSTOMCODE, this.getCustomCode());
        }
        if (!bl || this.isCustomModeDirty()) {
            hashMap.put(FIELD_CUSTOMMODE, this.getCustomMode());
        }
        if (!bl || this.isDTOCodeNameDirty()) {
            hashMap.put(FIELD_DTOCODENAME, this.getDTOCodeName());
        }
        if (!bl || this.isGroupTagDirty()) {
            hashMap.put(FIELD_GROUPTAG, this.getGroupTag());
        }
        if (!bl || this.isGroupTag2Dirty()) {
            hashMap.put(FIELD_GROUPTAG2, this.getGroupTag2());
        }
        if (!bl || this.isGroupTypeDirty()) {
            hashMap.put(FIELD_GROUPTYPE, this.getGroupType());
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
        if (!bl || this.isPSDEFGroupIdDirty()) {
            hashMap.put(FIELD_PSDEFGROUPID, this.getPSDEFGroupId());
        }
        if (!bl || this.isPSDEFGroupNameDirty()) {
            hashMap.put(FIELD_PSDEFGROUPNAME, this.getPSDEFGroupName());
        }
        if (!bl || this.isPSDEFormIdDirty()) {
            hashMap.put(FIELD_PSDEFORMID, this.getPSDEFormId());
        }
        if (!bl || this.isPSDEFormNameDirty()) {
            hashMap.put(FIELD_PSDEFORMNAME, this.getPSDEFormName());
        }
        if (!bl || this.isPSDEGridIdDirty()) {
            hashMap.put(FIELD_PSDEGRIDID, this.getPSDEGridId());
        }
        if (!bl || this.isPSDEGridNameDirty()) {
            hashMap.put(FIELD_PSDEGRIDNAME, this.getPSDEGridName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSDEVRGroupIdDirty()) {
            hashMap.put(FIELD_PSDEVRGROUPID, this.getPSDEVRGroupId());
        }
        if (!bl || this.isPSDEVRGroupNameDirty()) {
            hashMap.put(FIELD_PSDEVRGROUPNAME, this.getPSDEVRGroupName());
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
        return PSDEFGroupBase.get(this, n);
    }

    private static Object get(PSDEFGroupBase pSDEFGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFGroupBase.getCodeName();
            }
            case 1: {
                return pSDEFGroupBase.getCodeName2();
            }
            case 2: {
                return pSDEFGroupBase.getCreateDate();
            }
            case 3: {
                return pSDEFGroupBase.getCreateMan();
            }
            case 4: {
                return pSDEFGroupBase.getCustomCode();
            }
            case 5: {
                return pSDEFGroupBase.getCustomMode();
            }
            case 6: {
                return pSDEFGroupBase.getDTOCodeName();
            }
            case 7: {
                return pSDEFGroupBase.getGroupTag();
            }
            case 8: {
                return pSDEFGroupBase.getGroupTag2();
            }
            case 9: {
                return pSDEFGroupBase.getGroupType();
            }
            case 10: {
                return pSDEFGroupBase.getInitPSSysDynaModelId();
            }
            case 11: {
                return pSDEFGroupBase.getInitPSSysDynaModelName();
            }
            case 12: {
                return pSDEFGroupBase.getLogicMode();
            }
            case 13: {
                return pSDEFGroupBase.getLogicParam();
            }
            case 14: {
                return pSDEFGroupBase.getLogicParam2();
            }
            case 15: {
                return pSDEFGroupBase.getMemo();
            }
            case 16: {
                return pSDEFGroupBase.getOrderValue();
            }
            case 17: {
                return pSDEFGroupBase.getPSDEFGroupId();
            }
            case 18: {
                return pSDEFGroupBase.getPSDEFGroupName();
            }
            case 19: {
                return pSDEFGroupBase.getPSDEFormId();
            }
            case 20: {
                return pSDEFGroupBase.getPSDEFormName();
            }
            case 21: {
                return pSDEFGroupBase.getPSDEGridId();
            }
            case 22: {
                return pSDEFGroupBase.getPSDEGridName();
            }
            case 23: {
                return pSDEFGroupBase.getPSDEId();
            }
            case 24: {
                return pSDEFGroupBase.getPSDEName();
            }
            case 25: {
                return pSDEFGroupBase.getPSDEVRGroupId();
            }
            case 26: {
                return pSDEFGroupBase.getPSDEVRGroupName();
            }
            case 27: {
                return pSDEFGroupBase.getPSSysDynaModelId();
            }
            case 28: {
                return pSDEFGroupBase.getPSSysDynaModelName();
            }
            case 29: {
                return pSDEFGroupBase.getPSSysSFPluginId();
            }
            case 30: {
                return pSDEFGroupBase.getPSSysSFPluginName();
            }
            case 31: {
                return pSDEFGroupBase.getUpdateDate();
            }
            case 32: {
                return pSDEFGroupBase.getUpdateMan();
            }
            case 33: {
                return pSDEFGroupBase.getUserCat();
            }
            case 34: {
                return pSDEFGroupBase.getUserTag();
            }
            case 35: {
                return pSDEFGroupBase.getUserTag2();
            }
            case 36: {
                return pSDEFGroupBase.getUserTag3();
            }
            case 37: {
                return pSDEFGroupBase.getUserTag4();
            }
            case 38: {
                return pSDEFGroupBase.getValidFlag();
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
        PSDEFGroupBase.set(this, n, object);
    }

    private static void set(PSDEFGroupBase pSDEFGroupBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEFGroupBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDEFGroupBase.setCodeName2(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEFGroupBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSDEFGroupBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEFGroupBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEFGroupBase.setCustomMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSDEFGroupBase.setDTOCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEFGroupBase.setGroupTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEFGroupBase.setGroupTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEFGroupBase.setGroupType(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEFGroupBase.setInitPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEFGroupBase.setInitPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEFGroupBase.setLogicMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEFGroupBase.setLogicParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEFGroupBase.setLogicParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEFGroupBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEFGroupBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 17: {
                pSDEFGroupBase.setPSDEFGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEFGroupBase.setPSDEFGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEFGroupBase.setPSDEFormId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDEFGroupBase.setPSDEFormName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEFGroupBase.setPSDEGridId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDEFGroupBase.setPSDEGridName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDEFGroupBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDEFGroupBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDEFGroupBase.setPSDEVRGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDEFGroupBase.setPSDEVRGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDEFGroupBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDEFGroupBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDEFGroupBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDEFGroupBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDEFGroupBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 32: {
                pSDEFGroupBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDEFGroupBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDEFGroupBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDEFGroupBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDEFGroupBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSDEFGroupBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDEFGroupBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDEFGroupBase.isNull(this, n);
    }

    private static boolean isNull(PSDEFGroupBase pSDEFGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFGroupBase.getCodeName() == null;
            }
            case 1: {
                return pSDEFGroupBase.getCodeName2() == null;
            }
            case 2: {
                return pSDEFGroupBase.getCreateDate() == null;
            }
            case 3: {
                return pSDEFGroupBase.getCreateMan() == null;
            }
            case 4: {
                return pSDEFGroupBase.getCustomCode() == null;
            }
            case 5: {
                return pSDEFGroupBase.getCustomMode() == null;
            }
            case 6: {
                return pSDEFGroupBase.getDTOCodeName() == null;
            }
            case 7: {
                return pSDEFGroupBase.getGroupTag() == null;
            }
            case 8: {
                return pSDEFGroupBase.getGroupTag2() == null;
            }
            case 9: {
                return pSDEFGroupBase.getGroupType() == null;
            }
            case 10: {
                return pSDEFGroupBase.getInitPSSysDynaModelId() == null;
            }
            case 11: {
                return pSDEFGroupBase.getInitPSSysDynaModelName() == null;
            }
            case 12: {
                return pSDEFGroupBase.getLogicMode() == null;
            }
            case 13: {
                return pSDEFGroupBase.getLogicParam() == null;
            }
            case 14: {
                return pSDEFGroupBase.getLogicParam2() == null;
            }
            case 15: {
                return pSDEFGroupBase.getMemo() == null;
            }
            case 16: {
                return pSDEFGroupBase.getOrderValue() == null;
            }
            case 17: {
                return pSDEFGroupBase.getPSDEFGroupId() == null;
            }
            case 18: {
                return pSDEFGroupBase.getPSDEFGroupName() == null;
            }
            case 19: {
                return pSDEFGroupBase.getPSDEFormId() == null;
            }
            case 20: {
                return pSDEFGroupBase.getPSDEFormName() == null;
            }
            case 21: {
                return pSDEFGroupBase.getPSDEGridId() == null;
            }
            case 22: {
                return pSDEFGroupBase.getPSDEGridName() == null;
            }
            case 23: {
                return pSDEFGroupBase.getPSDEId() == null;
            }
            case 24: {
                return pSDEFGroupBase.getPSDEName() == null;
            }
            case 25: {
                return pSDEFGroupBase.getPSDEVRGroupId() == null;
            }
            case 26: {
                return pSDEFGroupBase.getPSDEVRGroupName() == null;
            }
            case 27: {
                return pSDEFGroupBase.getPSSysDynaModelId() == null;
            }
            case 28: {
                return pSDEFGroupBase.getPSSysDynaModelName() == null;
            }
            case 29: {
                return pSDEFGroupBase.getPSSysSFPluginId() == null;
            }
            case 30: {
                return pSDEFGroupBase.getPSSysSFPluginName() == null;
            }
            case 31: {
                return pSDEFGroupBase.getUpdateDate() == null;
            }
            case 32: {
                return pSDEFGroupBase.getUpdateMan() == null;
            }
            case 33: {
                return pSDEFGroupBase.getUserCat() == null;
            }
            case 34: {
                return pSDEFGroupBase.getUserTag() == null;
            }
            case 35: {
                return pSDEFGroupBase.getUserTag2() == null;
            }
            case 36: {
                return pSDEFGroupBase.getUserTag3() == null;
            }
            case 37: {
                return pSDEFGroupBase.getUserTag4() == null;
            }
            case 38: {
                return pSDEFGroupBase.getValidFlag() == null;
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
        return PSDEFGroupBase.contains(this, n);
    }

    private static boolean contains(PSDEFGroupBase pSDEFGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFGroupBase.isCodeNameDirty();
            }
            case 1: {
                return pSDEFGroupBase.isCodeName2Dirty();
            }
            case 2: {
                return pSDEFGroupBase.isCreateDateDirty();
            }
            case 3: {
                return pSDEFGroupBase.isCreateManDirty();
            }
            case 4: {
                return pSDEFGroupBase.isCustomCodeDirty();
            }
            case 5: {
                return pSDEFGroupBase.isCustomModeDirty();
            }
            case 6: {
                return pSDEFGroupBase.isDTOCodeNameDirty();
            }
            case 7: {
                return pSDEFGroupBase.isGroupTagDirty();
            }
            case 8: {
                return pSDEFGroupBase.isGroupTag2Dirty();
            }
            case 9: {
                return pSDEFGroupBase.isGroupTypeDirty();
            }
            case 10: {
                return pSDEFGroupBase.isInitPSSysDynaModelIdDirty();
            }
            case 11: {
                return pSDEFGroupBase.isInitPSSysDynaModelNameDirty();
            }
            case 12: {
                return pSDEFGroupBase.isLogicModeDirty();
            }
            case 13: {
                return pSDEFGroupBase.isLogicParamDirty();
            }
            case 14: {
                return pSDEFGroupBase.isLogicParam2Dirty();
            }
            case 15: {
                return pSDEFGroupBase.isMemoDirty();
            }
            case 16: {
                return pSDEFGroupBase.isOrderValueDirty();
            }
            case 17: {
                return pSDEFGroupBase.isPSDEFGroupIdDirty();
            }
            case 18: {
                return pSDEFGroupBase.isPSDEFGroupNameDirty();
            }
            case 19: {
                return pSDEFGroupBase.isPSDEFormIdDirty();
            }
            case 20: {
                return pSDEFGroupBase.isPSDEFormNameDirty();
            }
            case 21: {
                return pSDEFGroupBase.isPSDEGridIdDirty();
            }
            case 22: {
                return pSDEFGroupBase.isPSDEGridNameDirty();
            }
            case 23: {
                return pSDEFGroupBase.isPSDEIdDirty();
            }
            case 24: {
                return pSDEFGroupBase.isPSDENameDirty();
            }
            case 25: {
                return pSDEFGroupBase.isPSDEVRGroupIdDirty();
            }
            case 26: {
                return pSDEFGroupBase.isPSDEVRGroupNameDirty();
            }
            case 27: {
                return pSDEFGroupBase.isPSSysDynaModelIdDirty();
            }
            case 28: {
                return pSDEFGroupBase.isPSSysDynaModelNameDirty();
            }
            case 29: {
                return pSDEFGroupBase.isPSSysSFPluginIdDirty();
            }
            case 30: {
                return pSDEFGroupBase.isPSSysSFPluginNameDirty();
            }
            case 31: {
                return pSDEFGroupBase.isUpdateDateDirty();
            }
            case 32: {
                return pSDEFGroupBase.isUpdateManDirty();
            }
            case 33: {
                return pSDEFGroupBase.isUserCatDirty();
            }
            case 34: {
                return pSDEFGroupBase.isUserTagDirty();
            }
            case 35: {
                return pSDEFGroupBase.isUserTag2Dirty();
            }
            case 36: {
                return pSDEFGroupBase.isUserTag3Dirty();
            }
            case 37: {
                return pSDEFGroupBase.isUserTag4Dirty();
            }
            case 38: {
                return pSDEFGroupBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEFGroupBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEFGroupBase pSDEFGroupBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEFGroupBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDEFGroupBase.getJSONValue((Object)pSDEFGroupBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDEFGroupBase.getCodeName2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename2", (Object)PSDEFGroupBase.getJSONValue((Object)pSDEFGroupBase.getCodeName2()), (boolean)false);
        }
        if (bl || pSDEFGroupBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEFGroupBase.getJSONValue((Object)pSDEFGroupBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEFGroupBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEFGroupBase.getJSONValue((Object)pSDEFGroupBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEFGroupBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSDEFGroupBase.getJSONValue((Object)pSDEFGroupBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSDEFGroupBase.getCustomMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"custommode", (Object)PSDEFGroupBase.getJSONValue((Object)pSDEFGroupBase.getCustomMode()), (boolean)false);
        }
        if (bl || pSDEFGroupBase.getDTOCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dtocodename", (Object)PSDEFGroupBase.getJSONValue((Object)pSDEFGroupBase.getDTOCodeName()), (boolean)false);
        }
        if (bl || pSDEFGroupBase.getGroupTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouptag", (Object)PSDEFGroupBase.getJSONValue((Object)pSDEFGroupBase.getGroupTag()), (boolean)false);
        }
        if (bl || pSDEFGroupBase.getGroupTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouptag2", (Object)PSDEFGroupBase.getJSONValue((Object)pSDEFGroupBase.getGroupTag2()), (boolean)false);
        }
        if (bl || pSDEFGroupBase.getGroupType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouptype", (Object)PSDEFGroupBase.getJSONValue((Object)pSDEFGroupBase.getGroupType()), (boolean)false);
        }
        if (bl || pSDEFGroupBase.getInitPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"initpssysdynamodelid", (Object)PSDEFGroupBase.getJSONValue((Object)pSDEFGroupBase.getInitPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSDEFGroupBase.getInitPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"initpssysdynamodelname", (Object)PSDEFGroupBase.getJSONValue((Object)pSDEFGroupBase.getInitPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSDEFGroupBase.getLogicMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicmode", (Object)PSDEFGroupBase.getJSONValue((Object)pSDEFGroupBase.getLogicMode()), (boolean)false);
        }
        if (bl || pSDEFGroupBase.getLogicParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicparam", (Object)PSDEFGroupBase.getJSONValue((Object)pSDEFGroupBase.getLogicParam()), (boolean)false);
        }
        if (bl || pSDEFGroupBase.getLogicParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicparam2", (Object)PSDEFGroupBase.getJSONValue((Object)pSDEFGroupBase.getLogicParam2()), (boolean)false);
        }
        if (bl || pSDEFGroupBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEFGroupBase.getJSONValue((Object)pSDEFGroupBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEFGroupBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDEFGroupBase.getJSONValue((Object)pSDEFGroupBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDEFGroupBase.getPSDEFGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefgroupid", (Object)PSDEFGroupBase.getJSONValue((Object)pSDEFGroupBase.getPSDEFGroupId()), (boolean)false);
        }
        if (bl || pSDEFGroupBase.getPSDEFGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefgroupname", (Object)PSDEFGroupBase.getJSONValue((Object)pSDEFGroupBase.getPSDEFGroupName()), (boolean)false);
        }
        if (bl || pSDEFGroupBase.getPSDEFormId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeformid", (Object)PSDEFGroupBase.getJSONValue((Object)pSDEFGroupBase.getPSDEFormId()), (boolean)false);
        }
        if (bl || pSDEFGroupBase.getPSDEFormName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeformname", (Object)PSDEFGroupBase.getJSONValue((Object)pSDEFGroupBase.getPSDEFormName()), (boolean)false);
        }
        if (bl || pSDEFGroupBase.getPSDEGridId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdegridid", (Object)PSDEFGroupBase.getJSONValue((Object)pSDEFGroupBase.getPSDEGridId()), (boolean)false);
        }
        if (bl || pSDEFGroupBase.getPSDEGridName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdegridname", (Object)PSDEFGroupBase.getJSONValue((Object)pSDEFGroupBase.getPSDEGridName()), (boolean)false);
        }
        if (bl || pSDEFGroupBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEFGroupBase.getJSONValue((Object)pSDEFGroupBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEFGroupBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDEFGroupBase.getJSONValue((Object)pSDEFGroupBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDEFGroupBase.getPSDEVRGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevrgroupid", (Object)PSDEFGroupBase.getJSONValue((Object)pSDEFGroupBase.getPSDEVRGroupId()), (boolean)false);
        }
        if (bl || pSDEFGroupBase.getPSDEVRGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevrgroupname", (Object)PSDEFGroupBase.getJSONValue((Object)pSDEFGroupBase.getPSDEVRGroupName()), (boolean)false);
        }
        if (bl || pSDEFGroupBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSDEFGroupBase.getJSONValue((Object)pSDEFGroupBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSDEFGroupBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSDEFGroupBase.getJSONValue((Object)pSDEFGroupBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSDEFGroupBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSDEFGroupBase.getJSONValue((Object)pSDEFGroupBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSDEFGroupBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSDEFGroupBase.getJSONValue((Object)pSDEFGroupBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSDEFGroupBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEFGroupBase.getJSONValue((Object)pSDEFGroupBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEFGroupBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEFGroupBase.getJSONValue((Object)pSDEFGroupBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEFGroupBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEFGroupBase.getJSONValue((Object)pSDEFGroupBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEFGroupBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEFGroupBase.getJSONValue((Object)pSDEFGroupBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEFGroupBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEFGroupBase.getJSONValue((Object)pSDEFGroupBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEFGroupBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEFGroupBase.getJSONValue((Object)pSDEFGroupBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEFGroupBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEFGroupBase.getJSONValue((Object)pSDEFGroupBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDEFGroupBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDEFGroupBase.getJSONValue((Object)pSDEFGroupBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEFGroupBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEFGroupBase pSDEFGroupBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEFGroupBase.getCodeName() != null) {
            object = pSDEFGroupBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, (String)(object == null ? "" : object));
        }
        if (bl || pSDEFGroupBase.getCodeName2() != null) {
            object = pSDEFGroupBase.getCodeName2();
            xmlNode.setAttribute(FIELD_CODENAME2, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGroupBase.getCreateDate() != null) {
            object = pSDEFGroupBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEFGroupBase.getCreateMan() != null) {
            object = pSDEFGroupBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGroupBase.getCustomCode() != null) {
            object = pSDEFGroupBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGroupBase.getCustomMode() != null) {
            object = pSDEFGroupBase.getCustomMode();
            xmlNode.setAttribute(FIELD_CUSTOMMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFGroupBase.getDTOCodeName() != null) {
            object = pSDEFGroupBase.getDTOCodeName();
            xmlNode.setAttribute(FIELD_DTOCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGroupBase.getGroupTag() != null) {
            object = pSDEFGroupBase.getGroupTag();
            xmlNode.setAttribute(FIELD_GROUPTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGroupBase.getGroupTag2() != null) {
            object = pSDEFGroupBase.getGroupTag2();
            xmlNode.setAttribute(FIELD_GROUPTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGroupBase.getGroupType() != null) {
            object = pSDEFGroupBase.getGroupType();
            xmlNode.setAttribute(FIELD_GROUPTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGroupBase.getInitPSSysDynaModelId() != null) {
            object = pSDEFGroupBase.getInitPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_INITPSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGroupBase.getInitPSSysDynaModelName() != null) {
            object = pSDEFGroupBase.getInitPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_INITPSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGroupBase.getLogicMode() != null) {
            object = pSDEFGroupBase.getLogicMode();
            xmlNode.setAttribute(FIELD_LOGICMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGroupBase.getLogicParam() != null) {
            object = pSDEFGroupBase.getLogicParam();
            xmlNode.setAttribute(FIELD_LOGICPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGroupBase.getLogicParam2() != null) {
            object = pSDEFGroupBase.getLogicParam2();
            xmlNode.setAttribute(FIELD_LOGICPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGroupBase.getMemo() != null) {
            object = pSDEFGroupBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGroupBase.getOrderValue() != null) {
            object = pSDEFGroupBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFGroupBase.getPSDEFGroupId() != null) {
            object = pSDEFGroupBase.getPSDEFGroupId();
            xmlNode.setAttribute(FIELD_PSDEFGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGroupBase.getPSDEFGroupName() != null) {
            object = pSDEFGroupBase.getPSDEFGroupName();
            xmlNode.setAttribute(FIELD_PSDEFGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGroupBase.getPSDEFormId() != null) {
            object = pSDEFGroupBase.getPSDEFormId();
            xmlNode.setAttribute(FIELD_PSDEFORMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGroupBase.getPSDEFormName() != null) {
            object = pSDEFGroupBase.getPSDEFormName();
            xmlNode.setAttribute(FIELD_PSDEFORMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGroupBase.getPSDEGridId() != null) {
            object = pSDEFGroupBase.getPSDEGridId();
            xmlNode.setAttribute(FIELD_PSDEGRIDID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGroupBase.getPSDEGridName() != null) {
            object = pSDEFGroupBase.getPSDEGridName();
            xmlNode.setAttribute(FIELD_PSDEGRIDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGroupBase.getPSDEId() != null) {
            object = pSDEFGroupBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGroupBase.getPSDEName() != null) {
            object = pSDEFGroupBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGroupBase.getPSDEVRGroupId() != null) {
            object = pSDEFGroupBase.getPSDEVRGroupId();
            xmlNode.setAttribute(FIELD_PSDEVRGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGroupBase.getPSDEVRGroupName() != null) {
            object = pSDEFGroupBase.getPSDEVRGroupName();
            xmlNode.setAttribute(FIELD_PSDEVRGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGroupBase.getPSSysDynaModelId() != null) {
            object = pSDEFGroupBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGroupBase.getPSSysDynaModelName() != null) {
            object = pSDEFGroupBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGroupBase.getPSSysSFPluginId() != null) {
            object = pSDEFGroupBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGroupBase.getPSSysSFPluginName() != null) {
            object = pSDEFGroupBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGroupBase.getUpdateDate() != null) {
            object = pSDEFGroupBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEFGroupBase.getUpdateMan() != null) {
            object = pSDEFGroupBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGroupBase.getUserCat() != null) {
            object = pSDEFGroupBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGroupBase.getUserTag() != null) {
            object = pSDEFGroupBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGroupBase.getUserTag2() != null) {
            object = pSDEFGroupBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGroupBase.getUserTag3() != null) {
            object = pSDEFGroupBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGroupBase.getUserTag4() != null) {
            object = pSDEFGroupBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGroupBase.getValidFlag() != null) {
            object = pSDEFGroupBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEFGroupBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEFGroupBase pSDEFGroupBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEFGroupBase.isCodeNameDirty() && (bl || pSDEFGroupBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDEFGroupBase.getCodeName());
        }
        if (pSDEFGroupBase.isCodeName2Dirty() && (bl || pSDEFGroupBase.getCodeName2() != null)) {
            iDataObject.set(FIELD_CODENAME2, (Object)pSDEFGroupBase.getCodeName2());
        }
        if (pSDEFGroupBase.isCreateDateDirty() && (bl || pSDEFGroupBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEFGroupBase.getCreateDate());
        }
        if (pSDEFGroupBase.isCreateManDirty() && (bl || pSDEFGroupBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEFGroupBase.getCreateMan());
        }
        if (pSDEFGroupBase.isCustomCodeDirty() && (bl || pSDEFGroupBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSDEFGroupBase.getCustomCode());
        }
        if (pSDEFGroupBase.isCustomModeDirty() && (bl || pSDEFGroupBase.getCustomMode() != null)) {
            iDataObject.set(FIELD_CUSTOMMODE, (Object)pSDEFGroupBase.getCustomMode());
        }
        if (pSDEFGroupBase.isDTOCodeNameDirty() && (bl || pSDEFGroupBase.getDTOCodeName() != null)) {
            iDataObject.set(FIELD_DTOCODENAME, (Object)pSDEFGroupBase.getDTOCodeName());
        }
        if (pSDEFGroupBase.isGroupTagDirty() && (bl || pSDEFGroupBase.getGroupTag() != null)) {
            iDataObject.set(FIELD_GROUPTAG, (Object)pSDEFGroupBase.getGroupTag());
        }
        if (pSDEFGroupBase.isGroupTag2Dirty() && (bl || pSDEFGroupBase.getGroupTag2() != null)) {
            iDataObject.set(FIELD_GROUPTAG2, (Object)pSDEFGroupBase.getGroupTag2());
        }
        if (pSDEFGroupBase.isGroupTypeDirty() && (bl || pSDEFGroupBase.getGroupType() != null)) {
            iDataObject.set(FIELD_GROUPTYPE, (Object)pSDEFGroupBase.getGroupType());
        }
        if (pSDEFGroupBase.isInitPSSysDynaModelIdDirty() && (bl || pSDEFGroupBase.getInitPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_INITPSSYSDYNAMODELID, (Object)pSDEFGroupBase.getInitPSSysDynaModelId());
        }
        if (pSDEFGroupBase.isInitPSSysDynaModelNameDirty() && (bl || pSDEFGroupBase.getInitPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_INITPSSYSDYNAMODELNAME, (Object)pSDEFGroupBase.getInitPSSysDynaModelName());
        }
        if (pSDEFGroupBase.isLogicModeDirty() && (bl || pSDEFGroupBase.getLogicMode() != null)) {
            iDataObject.set(FIELD_LOGICMODE, (Object)pSDEFGroupBase.getLogicMode());
        }
        if (pSDEFGroupBase.isLogicParamDirty() && (bl || pSDEFGroupBase.getLogicParam() != null)) {
            iDataObject.set(FIELD_LOGICPARAM, (Object)pSDEFGroupBase.getLogicParam());
        }
        if (pSDEFGroupBase.isLogicParam2Dirty() && (bl || pSDEFGroupBase.getLogicParam2() != null)) {
            iDataObject.set(FIELD_LOGICPARAM2, (Object)pSDEFGroupBase.getLogicParam2());
        }
        if (pSDEFGroupBase.isMemoDirty() && (bl || pSDEFGroupBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEFGroupBase.getMemo());
        }
        if (pSDEFGroupBase.isOrderValueDirty() && (bl || pSDEFGroupBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDEFGroupBase.getOrderValue());
        }
        if (pSDEFGroupBase.isPSDEFGroupIdDirty() && (bl || pSDEFGroupBase.getPSDEFGroupId() != null)) {
            iDataObject.set(FIELD_PSDEFGROUPID, (Object)pSDEFGroupBase.getPSDEFGroupId());
        }
        if (pSDEFGroupBase.isPSDEFGroupNameDirty() && (bl || pSDEFGroupBase.getPSDEFGroupName() != null)) {
            iDataObject.set(FIELD_PSDEFGROUPNAME, (Object)pSDEFGroupBase.getPSDEFGroupName());
        }
        if (pSDEFGroupBase.isPSDEFormIdDirty() && (bl || pSDEFGroupBase.getPSDEFormId() != null)) {
            iDataObject.set(FIELD_PSDEFORMID, (Object)pSDEFGroupBase.getPSDEFormId());
        }
        if (pSDEFGroupBase.isPSDEFormNameDirty() && (bl || pSDEFGroupBase.getPSDEFormName() != null)) {
            iDataObject.set(FIELD_PSDEFORMNAME, (Object)pSDEFGroupBase.getPSDEFormName());
        }
        if (pSDEFGroupBase.isPSDEGridIdDirty() && (bl || pSDEFGroupBase.getPSDEGridId() != null)) {
            iDataObject.set(FIELD_PSDEGRIDID, (Object)pSDEFGroupBase.getPSDEGridId());
        }
        if (pSDEFGroupBase.isPSDEGridNameDirty() && (bl || pSDEFGroupBase.getPSDEGridName() != null)) {
            iDataObject.set(FIELD_PSDEGRIDNAME, (Object)pSDEFGroupBase.getPSDEGridName());
        }
        if (pSDEFGroupBase.isPSDEIdDirty() && (bl || pSDEFGroupBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEFGroupBase.getPSDEId());
        }
        if (pSDEFGroupBase.isPSDENameDirty() && (bl || pSDEFGroupBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDEFGroupBase.getPSDEName());
        }
        if (pSDEFGroupBase.isPSDEVRGroupIdDirty() && (bl || pSDEFGroupBase.getPSDEVRGroupId() != null)) {
            iDataObject.set(FIELD_PSDEVRGROUPID, (Object)pSDEFGroupBase.getPSDEVRGroupId());
        }
        if (pSDEFGroupBase.isPSDEVRGroupNameDirty() && (bl || pSDEFGroupBase.getPSDEVRGroupName() != null)) {
            iDataObject.set(FIELD_PSDEVRGROUPNAME, (Object)pSDEFGroupBase.getPSDEVRGroupName());
        }
        if (pSDEFGroupBase.isPSSysDynaModelIdDirty() && (bl || pSDEFGroupBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSDEFGroupBase.getPSSysDynaModelId());
        }
        if (pSDEFGroupBase.isPSSysDynaModelNameDirty() && (bl || pSDEFGroupBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSDEFGroupBase.getPSSysDynaModelName());
        }
        if (pSDEFGroupBase.isPSSysSFPluginIdDirty() && (bl || pSDEFGroupBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSDEFGroupBase.getPSSysSFPluginId());
        }
        if (pSDEFGroupBase.isPSSysSFPluginNameDirty() && (bl || pSDEFGroupBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSDEFGroupBase.getPSSysSFPluginName());
        }
        if (pSDEFGroupBase.isUpdateDateDirty() && (bl || pSDEFGroupBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEFGroupBase.getUpdateDate());
        }
        if (pSDEFGroupBase.isUpdateManDirty() && (bl || pSDEFGroupBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEFGroupBase.getUpdateMan());
        }
        if (pSDEFGroupBase.isUserCatDirty() && (bl || pSDEFGroupBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEFGroupBase.getUserCat());
        }
        if (pSDEFGroupBase.isUserTagDirty() && (bl || pSDEFGroupBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEFGroupBase.getUserTag());
        }
        if (pSDEFGroupBase.isUserTag2Dirty() && (bl || pSDEFGroupBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEFGroupBase.getUserTag2());
        }
        if (pSDEFGroupBase.isUserTag3Dirty() && (bl || pSDEFGroupBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEFGroupBase.getUserTag3());
        }
        if (pSDEFGroupBase.isUserTag4Dirty() && (bl || pSDEFGroupBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEFGroupBase.getUserTag4());
        }
        if (pSDEFGroupBase.isValidFlagDirty() && (bl || pSDEFGroupBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDEFGroupBase.getValidFlag());
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
        return PSDEFGroupBase.remove(this, n);
    }

    private static boolean remove(PSDEFGroupBase pSDEFGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEFGroupBase.resetCodeName();
                return true;
            }
            case 1: {
                pSDEFGroupBase.resetCodeName2();
                return true;
            }
            case 2: {
                pSDEFGroupBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSDEFGroupBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSDEFGroupBase.resetCustomCode();
                return true;
            }
            case 5: {
                pSDEFGroupBase.resetCustomMode();
                return true;
            }
            case 6: {
                pSDEFGroupBase.resetDTOCodeName();
                return true;
            }
            case 7: {
                pSDEFGroupBase.resetGroupTag();
                return true;
            }
            case 8: {
                pSDEFGroupBase.resetGroupTag2();
                return true;
            }
            case 9: {
                pSDEFGroupBase.resetGroupType();
                return true;
            }
            case 10: {
                pSDEFGroupBase.resetInitPSSysDynaModelId();
                return true;
            }
            case 11: {
                pSDEFGroupBase.resetInitPSSysDynaModelName();
                return true;
            }
            case 12: {
                pSDEFGroupBase.resetLogicMode();
                return true;
            }
            case 13: {
                pSDEFGroupBase.resetLogicParam();
                return true;
            }
            case 14: {
                pSDEFGroupBase.resetLogicParam2();
                return true;
            }
            case 15: {
                pSDEFGroupBase.resetMemo();
                return true;
            }
            case 16: {
                pSDEFGroupBase.resetOrderValue();
                return true;
            }
            case 17: {
                pSDEFGroupBase.resetPSDEFGroupId();
                return true;
            }
            case 18: {
                pSDEFGroupBase.resetPSDEFGroupName();
                return true;
            }
            case 19: {
                pSDEFGroupBase.resetPSDEFormId();
                return true;
            }
            case 20: {
                pSDEFGroupBase.resetPSDEFormName();
                return true;
            }
            case 21: {
                pSDEFGroupBase.resetPSDEGridId();
                return true;
            }
            case 22: {
                pSDEFGroupBase.resetPSDEGridName();
                return true;
            }
            case 23: {
                pSDEFGroupBase.resetPSDEId();
                return true;
            }
            case 24: {
                pSDEFGroupBase.resetPSDEName();
                return true;
            }
            case 25: {
                pSDEFGroupBase.resetPSDEVRGroupId();
                return true;
            }
            case 26: {
                pSDEFGroupBase.resetPSDEVRGroupName();
                return true;
            }
            case 27: {
                pSDEFGroupBase.resetPSSysDynaModelId();
                return true;
            }
            case 28: {
                pSDEFGroupBase.resetPSSysDynaModelName();
                return true;
            }
            case 29: {
                pSDEFGroupBase.resetPSSysSFPluginId();
                return true;
            }
            case 30: {
                pSDEFGroupBase.resetPSSysSFPluginName();
                return true;
            }
            case 31: {
                pSDEFGroupBase.resetUpdateDate();
                return true;
            }
            case 32: {
                pSDEFGroupBase.resetUpdateMan();
                return true;
            }
            case 33: {
                pSDEFGroupBase.resetUserCat();
                return true;
            }
            case 34: {
                pSDEFGroupBase.resetUserTag();
                return true;
            }
            case 35: {
                pSDEFGroupBase.resetUserTag2();
                return true;
            }
            case 36: {
                pSDEFGroupBase.resetUserTag3();
                return true;
            }
            case 37: {
                pSDEFGroupBase.resetUserTag4();
                return true;
            }
            case 38: {
                pSDEFGroupBase.resetValidFlag();
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
    public PSDEForm getPSDEForm() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEForm();
        }
        if (this.getPSDEFormId() == null) {
            return null;
        }
        Integer n = this.objPSDEFormLock;
        synchronized (n) {
            if (this.psdeform != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEFormId(), (Object)this.psdeform.getPSDEFormId()) != 0L) {
                this.psdeform = null;
            }
            if (this.psdeform == null) {
                PSDEForm pSDEForm = new PSDEForm();
                pSDEForm.setPSDEFormId(this.getPSDEFormId());
                PSDEFormService pSDEFormService = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, (SessionFactory)this.getSessionFactory());
                pSDEFormService.autoGet((IEntity)pSDEForm);
                this.psdeform = pSDEForm;
            }
            return this.psdeform;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEGrid getPSDEGrid() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGrid();
        }
        if (this.getPSDEGridId() == null) {
            return null;
        }
        Integer n = this.objPSDEGridLock;
        synchronized (n) {
            if (this.psdegrid != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEGridId(), (Object)this.psdegrid.getPSDEGridId()) != 0L) {
                this.psdegrid = null;
            }
            if (this.psdegrid == null) {
                PSDEGrid pSDEGrid = new PSDEGrid();
                pSDEGrid.setPSDEGridId(this.getPSDEGridId());
                PSDEGridService pSDEGridService = (PSDEGridService)ServiceGlobal.getService(PSDEGridService.class, (SessionFactory)this.getSessionFactory());
                pSDEGridService.autoGet((IEntity)pSDEGrid);
                this.psdegrid = pSDEGrid;
            }
            return this.psdegrid;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEVRGroup getPSDEVRGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEVRGroup();
        }
        if (this.getPSDEVRGroupId() == null) {
            return null;
        }
        Integer n = this.objPSDEVRGroupLock;
        synchronized (n) {
            if (this.psdevrgroup != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEVRGroupId(), (Object)this.psdevrgroup.getPSDEVRGroupId()) != 0L) {
                this.psdevrgroup = null;
            }
            if (this.psdevrgroup == null) {
                PSDEVRGroup pSDEVRGroup = new PSDEVRGroup();
                pSDEVRGroup.setPSDEVRGroupId(this.getPSDEVRGroupId());
                PSDEVRGroupService pSDEVRGroupService = (PSDEVRGroupService)ServiceGlobal.getService(PSDEVRGroupService.class, (SessionFactory)this.getSessionFactory());
                pSDEVRGroupService.autoGet((IEntity)pSDEVRGroup);
                this.psdevrgroup = pSDEVRGroup;
            }
            return this.psdevrgroup;
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
    public ArrayList<PSDEFGroupDetail> getPSDEFGroupDetails() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFGroupDetails();
        }
        if (this.getPSDEFGroupId() == null) {
            return null;
        }
        PSDEFGroupService pSDEFGroupService = (PSDEFGroupService)ServiceGlobal.getService(PSDEFGroupService.class, (SessionFactory)this.getSessionFactory());
        PSDEFGroupDetailService pSDEFGroupDetailService = (PSDEFGroupDetailService)ServiceGlobal.getService(PSDEFGroupDetailService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEFGroupDetailsLock;
        synchronized (n) {
            if (this.psdefgroupdetails == null) {
                this.psdefgroupdetails = pSDEFGroupService.isTempData((IEntity)this) ? pSDEFGroupDetailService.selectTempByPSDEFGroup(this) : pSDEFGroupDetailService.selectByPSDEFGroup(this);
            }
            return this.psdefgroupdetails;
        }
    }

    private PSDEFGroupBase getProxyEntity() {
        return this.proxyPSDEFGroupBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEFGroupBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEFGroupBase) {
            this.proxyPSDEFGroupBase = (PSDEFGroupBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFGroupService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CODENAME2, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_CUSTOMCODE, 4);
        fieldIndexMap.put(FIELD_CUSTOMMODE, 5);
        fieldIndexMap.put(FIELD_DTOCODENAME, 6);
        fieldIndexMap.put(FIELD_GROUPTAG, 7);
        fieldIndexMap.put(FIELD_GROUPTAG2, 8);
        fieldIndexMap.put(FIELD_GROUPTYPE, 9);
        fieldIndexMap.put(FIELD_INITPSSYSDYNAMODELID, 10);
        fieldIndexMap.put(FIELD_INITPSSYSDYNAMODELNAME, 11);
        fieldIndexMap.put(FIELD_LOGICMODE, 12);
        fieldIndexMap.put(FIELD_LOGICPARAM, 13);
        fieldIndexMap.put(FIELD_LOGICPARAM2, 14);
        fieldIndexMap.put(FIELD_MEMO, 15);
        fieldIndexMap.put(FIELD_ORDERVALUE, 16);
        fieldIndexMap.put(FIELD_PSDEFGROUPID, 17);
        fieldIndexMap.put(FIELD_PSDEFGROUPNAME, 18);
        fieldIndexMap.put(FIELD_PSDEFORMID, 19);
        fieldIndexMap.put(FIELD_PSDEFORMNAME, 20);
        fieldIndexMap.put(FIELD_PSDEGRIDID, 21);
        fieldIndexMap.put(FIELD_PSDEGRIDNAME, 22);
        fieldIndexMap.put(FIELD_PSDEID, 23);
        fieldIndexMap.put(FIELD_PSDENAME, 24);
        fieldIndexMap.put(FIELD_PSDEVRGROUPID, 25);
        fieldIndexMap.put(FIELD_PSDEVRGROUPNAME, 26);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 27);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 28);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 29);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 30);
        fieldIndexMap.put(FIELD_UPDATEDATE, 31);
        fieldIndexMap.put(FIELD_UPDATEMAN, 32);
        fieldIndexMap.put(FIELD_USERCAT, 33);
        fieldIndexMap.put(FIELD_USERTAG, 34);
        fieldIndexMap.put(FIELD_USERTAG2, 35);
        fieldIndexMap.put(FIELD_USERTAG3, 36);
        fieldIndexMap.put(FIELD_USERTAG4, 37);
        fieldIndexMap.put(FIELD_VALIDFLAG, 38);
    }
}

