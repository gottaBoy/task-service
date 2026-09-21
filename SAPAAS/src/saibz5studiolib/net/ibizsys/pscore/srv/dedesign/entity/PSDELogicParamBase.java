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
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSSysResource;
import net.ibizsys.pscore.srv.config.service.PSSysPFPluginService;
import net.ibizsys.pscore.srv.config.service.PSSysResourceService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysTranslator;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysTranslatorService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDELogicParamBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDELogicParamBase.class);
    public static final String FIELD_CLONEPARAMFLAG = "CLONEPARAMFLAG";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEFAULTPARAM = "DEFAULTPARAM";
    public static final String FIELD_DEFAULTVALUE = "DEFAULTVALUE";
    public static final String FIELD_DEFAULTVALUETYPE = "DEFAULTVALUETYPE";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_FILETYPE = "FILETYPE";
    public static final String FIELD_FILEURL = "FILEURL";
    public static final String FIELD_GLOBALPARAM = "GLOBALPARAM";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORIGINENTITYFLAG = "ORIGINENTITYFLAG";
    public static final String FIELD_PARAMPSDEFGROUPID = "PARAMPSDEFGROUPID";
    public static final String FIELD_PARAMPSDEFGROUPNAME = "PARAMPSDEFGROUPNAME";
    public static final String FIELD_PARAMPSDEID = "PARAMPSDEID";
    public static final String FIELD_PARAMPSDENAME = "PARAMPSDENAME";
    public static final String FIELD_PARAMS = "PARAMS";
    public static final String FIELD_PARAMTAG = "PARAMTAG";
    public static final String FIELD_PARAMTAG2 = "PARAMTAG2";
    public static final String FIELD_PSDELOGICID = "PSDELOGICID";
    public static final String FIELD_PSDELOGICNAME = "PSDELOGICNAME";
    public static final String FIELD_PSDELOGICPARAMID = "PSDELOGICPARAMID";
    public static final String FIELD_PSDELOGICPARAMNAME = "PSDELOGICPARAMNAME";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String FIELD_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String FIELD_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String FIELD_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String FIELD_PSSYSRESOURCEID = "PSSYSRESOURCEID";
    public static final String FIELD_PSSYSRESOURCENAME = "PSSYSRESOURCENAME";
    public static final String FIELD_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String FIELD_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTRANSLATORID = "PSSYSTRANSLATORID";
    public static final String FIELD_PSSYSTRANSLATORNAME = "PSSYSTRANSLATORNAME";
    public static final String FIELD_REFFIELDNAME = "REFFIELDNAME";
    public static final String FIELD_REFPARAMNAME = "REFPARAMNAME";
    public static final String FIELD_STDDATATYPE = "STDDATATYPE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERPARAMS = "USERPARAMS";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_CLONEPARAMFLAG = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_DEFAULTPARAM = 3;
    private static final int INDEX_DEFAULTVALUE = 4;
    private static final int INDEX_DEFAULTVALUETYPE = 5;
    private static final int INDEX_DYNAMODELFLAG = 6;
    private static final int INDEX_FILETYPE = 7;
    private static final int INDEX_FILEURL = 8;
    private static final int INDEX_GLOBALPARAM = 9;
    private static final int INDEX_LOGICNAME = 10;
    private static final int INDEX_MEMO = 11;
    private static final int INDEX_ORIGINENTITYFLAG = 12;
    private static final int INDEX_PARAMPSDEFGROUPID = 13;
    private static final int INDEX_PARAMPSDEFGROUPNAME = 14;
    private static final int INDEX_PARAMPSDEID = 15;
    private static final int INDEX_PARAMPSDENAME = 16;
    private static final int INDEX_PARAMS = 17;
    private static final int INDEX_PARAMTAG = 18;
    private static final int INDEX_PARAMTAG2 = 19;
    private static final int INDEX_PSDELOGICID = 20;
    private static final int INDEX_PSDELOGICNAME = 21;
    private static final int INDEX_PSDELOGICPARAMID = 22;
    private static final int INDEX_PSDELOGICPARAMNAME = 23;
    private static final int INDEX_PSDYNAINSTID = 24;
    private static final int INDEX_PSSYSDYNAMODELID = 25;
    private static final int INDEX_PSSYSDYNAMODELNAME = 26;
    private static final int INDEX_PSSYSPFPLUGINID = 27;
    private static final int INDEX_PSSYSPFPLUGINNAME = 28;
    private static final int INDEX_PSSYSRESOURCEID = 29;
    private static final int INDEX_PSSYSRESOURCENAME = 30;
    private static final int INDEX_PSSYSSFPLUGINID = 31;
    private static final int INDEX_PSSYSSFPLUGINNAME = 32;
    private static final int INDEX_PSSYSTEMID = 33;
    private static final int INDEX_PSSYSTRANSLATORID = 34;
    private static final int INDEX_PSSYSTRANSLATORNAME = 35;
    private static final int INDEX_REFFIELDNAME = 36;
    private static final int INDEX_REFPARAMNAME = 37;
    private static final int INDEX_STDDATATYPE = 38;
    private static final int INDEX_UPDATEDATE = 39;
    private static final int INDEX_UPDATEMAN = 40;
    private static final int INDEX_USERCAT = 41;
    private static final int INDEX_USERPARAMS = 42;
    private static final int INDEX_USERTAG = 43;
    private static final int INDEX_USERTAG2 = 44;
    private static final int INDEX_USERTAG3 = 45;
    private static final int INDEX_USERTAG4 = 46;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDELogicParamBase proxyPSDELogicParamBase = null;
    private boolean cloneparamflagDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean defaultparamDirtyFlag = false;
    private boolean defaultvalueDirtyFlag = false;
    private boolean defaultvaluetypeDirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean filetypeDirtyFlag = false;
    private boolean fileurlDirtyFlag = false;
    private boolean globalparamDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean originentityflagDirtyFlag = false;
    private boolean parampsdefgroupidDirtyFlag = false;
    private boolean parampsdefgroupnameDirtyFlag = false;
    private boolean parampsdeidDirtyFlag = false;
    private boolean parampsdenameDirtyFlag = false;
    private boolean paramsDirtyFlag = false;
    private boolean paramtagDirtyFlag = false;
    private boolean paramtag2DirtyFlag = false;
    private boolean psdelogicidDirtyFlag = false;
    private boolean psdelogicnameDirtyFlag = false;
    private boolean psdelogicparamidDirtyFlag = false;
    private boolean psdelogicparamnameDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean pssysdynamodelidDirtyFlag = false;
    private boolean pssysdynamodelnameDirtyFlag = false;
    private boolean pssyspfpluginidDirtyFlag = false;
    private boolean pssyspfpluginnameDirtyFlag = false;
    private boolean pssysresourceidDirtyFlag = false;
    private boolean pssysresourcenameDirtyFlag = false;
    private boolean pssyssfpluginidDirtyFlag = false;
    private boolean pssyssfpluginnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystranslatoridDirtyFlag = false;
    private boolean pssystranslatornameDirtyFlag = false;
    private boolean reffieldnameDirtyFlag = false;
    private boolean refparamnameDirtyFlag = false;
    private boolean stddatatypeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean userparamsDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="cloneparamflag")
    private Integer cloneparamflag;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="defaultparam")
    private Integer defaultparam;
    @Column(name="defaultvalue")
    private String defaultvalue;
    @Column(name="defaultvaluetype")
    private String defaultvaluetype;
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="filetype")
    private String filetype;
    @Column(name="fileurl")
    private String fileurl;
    @Column(name="globalparam")
    private Integer globalparam;
    @Column(name="logicname")
    private String logicname;
    @Column(name="memo")
    private String memo;
    @Column(name="originentityflag")
    private Integer originentityflag;
    @Column(name="parampsdefgroupid")
    private String parampsdefgroupid;
    @Column(name="parampsdefgroupname")
    private String parampsdefgroupname;
    @Column(name="parampsdeid")
    private String parampsdeid;
    @Column(name="parampsdename")
    private String parampsdename;
    @Column(name="params")
    private String params;
    @Column(name="paramtag")
    private String paramtag;
    @Column(name="paramtag2")
    private String paramtag2;
    @Column(name="psdelogicid")
    private String psdelogicid;
    @Column(name="psdelogicname")
    private String psdelogicname;
    @Column(name="psdelogicparamid")
    private String psdelogicparamid;
    @Column(name="psdelogicparamname")
    private String psdelogicparamname;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="pssysdynamodelid")
    private String pssysdynamodelid;
    @Column(name="pssysdynamodelname")
    private String pssysdynamodelname;
    @Column(name="pssyspfpluginid")
    private String pssyspfpluginid;
    @Column(name="pssyspfpluginname")
    private String pssyspfpluginname;
    @Column(name="pssysresourceid")
    private String pssysresourceid;
    @Column(name="pssysresourcename")
    private String pssysresourcename;
    @Column(name="pssyssfpluginid")
    private String pssyssfpluginid;
    @Column(name="pssyssfpluginname")
    private String pssyssfpluginname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystranslatorid")
    private String pssystranslatorid;
    @Column(name="pssystranslatorname")
    private String pssystranslatorname;
    @Column(name="reffieldname")
    private String reffieldname;
    @Column(name="refparamname")
    private String refparamname;
    @Column(name="stddatatype")
    private Integer stddatatype;
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
    private Integer objParamPSDELock = new Integer(1);
    private PSDataEntity parampsde = null;
    private Integer objParamPSDEFGroupLock = new Integer(1);
    private PSDEFGroup parampsdefgroup = null;
    private Integer objPSDELogicLock = new Integer(1);
    private PSDELogic psdelogic = null;
    private Integer objPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel pssysdynamodel = null;
    private Integer objPSSysPFPluginLock = new Integer(1);
    private PSSysPFPlugin pssyspfplugin = null;
    private Integer objPSSysResourceLock = new Integer(1);
    private PSSysResource pssysresource = null;
    private Integer objPSSysSFPluginLock = new Integer(1);
    private PSSysSFPlugin pssyssfplugin = null;
    private Integer objPSSysTranslatorLock = new Integer(1);
    private PSSysTranslator pssystranslator = null;

    public void setCloneParamFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCloneParamFlag(n);
            return;
        }
        this.cloneparamflag = n;
        this.cloneparamflagDirtyFlag = true;
    }

    public Integer getCloneParamFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCloneParamFlag();
        }
        return this.cloneparamflag;
    }

    public boolean isCloneParamFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCloneParamFlagDirty();
        }
        return this.cloneparamflagDirtyFlag;
    }

    public void resetCloneParamFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCloneParamFlag();
            return;
        }
        this.cloneparamflagDirtyFlag = false;
        this.cloneparamflag = null;
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

    public void setDefaultParam(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefaultParam(n);
            return;
        }
        this.defaultparam = n;
        this.defaultparamDirtyFlag = true;
    }

    public Integer getDefaultParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefaultParam();
        }
        return this.defaultparam;
    }

    public boolean isDefaultParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefaultParamDirty();
        }
        return this.defaultparamDirtyFlag;
    }

    public void resetDefaultParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefaultParam();
            return;
        }
        this.defaultparamDirtyFlag = false;
        this.defaultparam = null;
    }

    public void setDefaultValue(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefaultValue(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.defaultvalue = string;
        this.defaultvalueDirtyFlag = true;
    }

    public String getDefaultValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefaultValue();
        }
        return this.defaultvalue;
    }

    public boolean isDefaultValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefaultValueDirty();
        }
        return this.defaultvalueDirtyFlag;
    }

    public void resetDefaultValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefaultValue();
            return;
        }
        this.defaultvalueDirtyFlag = false;
        this.defaultvalue = null;
    }

    public void setDefaultValueType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefaultValueType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.defaultvaluetype = string;
        this.defaultvaluetypeDirtyFlag = true;
    }

    public String getDefaultValueType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefaultValueType();
        }
        return this.defaultvaluetype;
    }

    public boolean isDefaultValueTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefaultValueTypeDirty();
        }
        return this.defaultvaluetypeDirtyFlag;
    }

    public void resetDefaultValueType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefaultValueType();
            return;
        }
        this.defaultvaluetypeDirtyFlag = false;
        this.defaultvaluetype = null;
    }

    public void setDynaModelFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynaModelFlag(n);
            return;
        }
        this.dynamodelflag = n;
        this.dynamodelflagDirtyFlag = true;
    }

    public Integer getDynaModelFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynaModelFlag();
        }
        return this.dynamodelflag;
    }

    public boolean isDynaModelFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynaModelFlagDirty();
        }
        return this.dynamodelflagDirtyFlag;
    }

    public void resetDynaModelFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynaModelFlag();
            return;
        }
        this.dynamodelflagDirtyFlag = false;
        this.dynamodelflag = null;
    }

    public void setFileType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFileType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.filetype = string;
        this.filetypeDirtyFlag = true;
    }

    public String getFileType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFileType();
        }
        return this.filetype;
    }

    public boolean isFileTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFileTypeDirty();
        }
        return this.filetypeDirtyFlag;
    }

    public void resetFileType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFileType();
            return;
        }
        this.filetypeDirtyFlag = false;
        this.filetype = null;
    }

    public void setFileUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFileUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.fileurl = string;
        this.fileurlDirtyFlag = true;
    }

    public String getFileUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFileUrl();
        }
        return this.fileurl;
    }

    public boolean isFileUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFileUrlDirty();
        }
        return this.fileurlDirtyFlag;
    }

    public void resetFileUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFileUrl();
            return;
        }
        this.fileurlDirtyFlag = false;
        this.fileurl = null;
    }

    public void setGlobalParam(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGlobalParam(n);
            return;
        }
        this.globalparam = n;
        this.globalparamDirtyFlag = true;
    }

    public Integer getGlobalParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGlobalParam();
        }
        return this.globalparam;
    }

    public boolean isGlobalParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGlobalParamDirty();
        }
        return this.globalparamDirtyFlag;
    }

    public void resetGlobalParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGlobalParam();
            return;
        }
        this.globalparamDirtyFlag = false;
        this.globalparam = null;
    }

    public void setLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.logicname = string;
        this.logicnameDirtyFlag = true;
    }

    public String getLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogicName();
        }
        return this.logicname;
    }

    public boolean isLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogicNameDirty();
        }
        return this.logicnameDirtyFlag;
    }

    public void resetLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogicName();
            return;
        }
        this.logicnameDirtyFlag = false;
        this.logicname = null;
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

    public void setOriginEntityFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOriginEntityFlag(n);
            return;
        }
        this.originentityflag = n;
        this.originentityflagDirtyFlag = true;
    }

    public Integer getOriginEntityFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOriginEntityFlag();
        }
        return this.originentityflag;
    }

    public boolean isOriginEntityFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOriginEntityFlagDirty();
        }
        return this.originentityflagDirtyFlag;
    }

    public void resetOriginEntityFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOriginEntityFlag();
            return;
        }
        this.originentityflagDirtyFlag = false;
        this.originentityflag = null;
    }

    public void setParamPSDEFGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParamPSDEFGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.parampsdefgroupid = string;
        this.parampsdefgroupidDirtyFlag = true;
    }

    public String getParamPSDEFGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParamPSDEFGroupId();
        }
        return this.parampsdefgroupid;
    }

    public boolean isParamPSDEFGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParamPSDEFGroupIdDirty();
        }
        return this.parampsdefgroupidDirtyFlag;
    }

    public void resetParamPSDEFGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParamPSDEFGroupId();
            return;
        }
        this.parampsdefgroupidDirtyFlag = false;
        this.parampsdefgroupid = null;
    }

    public void setParamPSDEFGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParamPSDEFGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.parampsdefgroupname = string;
        this.parampsdefgroupnameDirtyFlag = true;
    }

    public String getParamPSDEFGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParamPSDEFGroupName();
        }
        return this.parampsdefgroupname;
    }

    public boolean isParamPSDEFGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParamPSDEFGroupNameDirty();
        }
        return this.parampsdefgroupnameDirtyFlag;
    }

    public void resetParamPSDEFGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParamPSDEFGroupName();
            return;
        }
        this.parampsdefgroupnameDirtyFlag = false;
        this.parampsdefgroupname = null;
    }

    public void setParamPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParamPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.parampsdeid = string;
        this.parampsdeidDirtyFlag = true;
    }

    public String getParamPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParamPSDEId();
        }
        return this.parampsdeid;
    }

    public boolean isParamPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParamPSDEIdDirty();
        }
        return this.parampsdeidDirtyFlag;
    }

    public void resetParamPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParamPSDEId();
            return;
        }
        this.parampsdeidDirtyFlag = false;
        this.parampsdeid = null;
    }

    public void setParamPSDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParamPSDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.parampsdename = string;
        this.parampsdenameDirtyFlag = true;
    }

    public String getParamPSDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParamPSDEName();
        }
        return this.parampsdename;
    }

    public boolean isParamPSDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParamPSDENameDirty();
        }
        return this.parampsdenameDirtyFlag;
    }

    public void resetParamPSDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParamPSDEName();
            return;
        }
        this.parampsdenameDirtyFlag = false;
        this.parampsdename = null;
    }

    public void setParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.params = string;
        this.paramsDirtyFlag = true;
    }

    public String getParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParams();
        }
        return this.params;
    }

    public boolean isParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParamsDirty();
        }
        return this.paramsDirtyFlag;
    }

    public void resetParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParams();
            return;
        }
        this.paramsDirtyFlag = false;
        this.params = null;
    }

    public void setParamTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParamTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.paramtag = string;
        this.paramtagDirtyFlag = true;
    }

    public String getParamTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParamTag();
        }
        return this.paramtag;
    }

    public boolean isParamTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParamTagDirty();
        }
        return this.paramtagDirtyFlag;
    }

    public void resetParamTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParamTag();
            return;
        }
        this.paramtagDirtyFlag = false;
        this.paramtag = null;
    }

    public void setParamTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParamTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.paramtag2 = string;
        this.paramtag2DirtyFlag = true;
    }

    public String getParamTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParamTag2();
        }
        return this.paramtag2;
    }

    public boolean isParamTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParamTag2Dirty();
        }
        return this.paramtag2DirtyFlag;
    }

    public void resetParamTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParamTag2();
            return;
        }
        this.paramtag2DirtyFlag = false;
        this.paramtag2 = null;
    }

    public void setPSDELogicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDELogicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdelogicid = string;
        this.psdelogicidDirtyFlag = true;
    }

    public String getPSDELogicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDELogicId();
        }
        return this.psdelogicid;
    }

    public boolean isPSDELogicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDELogicIdDirty();
        }
        return this.psdelogicidDirtyFlag;
    }

    public void resetPSDELogicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDELogicId();
            return;
        }
        this.psdelogicidDirtyFlag = false;
        this.psdelogicid = null;
    }

    public void setPSDELogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDELogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdelogicname = string;
        this.psdelogicnameDirtyFlag = true;
    }

    public String getPSDELogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDELogicName();
        }
        return this.psdelogicname;
    }

    public boolean isPSDELogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDELogicNameDirty();
        }
        return this.psdelogicnameDirtyFlag;
    }

    public void resetPSDELogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDELogicName();
            return;
        }
        this.psdelogicnameDirtyFlag = false;
        this.psdelogicname = null;
    }

    public void setPSDELogicParamId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDELogicParamId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdelogicparamid = string;
        this.psdelogicparamidDirtyFlag = true;
    }

    public String getPSDELogicParamId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDELogicParamId();
        }
        return this.psdelogicparamid;
    }

    public boolean isPSDELogicParamIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDELogicParamIdDirty();
        }
        return this.psdelogicparamidDirtyFlag;
    }

    public void resetPSDELogicParamId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDELogicParamId();
            return;
        }
        this.psdelogicparamidDirtyFlag = false;
        this.psdelogicparamid = null;
    }

    public void setPSDELogicParamName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDELogicParamName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdelogicparamname = string;
        this.psdelogicparamnameDirtyFlag = true;
    }

    public String getPSDELogicParamName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDELogicParamName();
        }
        return this.psdelogicparamname;
    }

    public boolean isPSDELogicParamNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDELogicParamNameDirty();
        }
        return this.psdelogicparamnameDirtyFlag;
    }

    public void resetPSDELogicParamName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDELogicParamName();
            return;
        }
        this.psdelogicparamnameDirtyFlag = false;
        this.psdelogicparamname = null;
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

    public void setPSSysPFPluginId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysPFPluginId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyspfpluginid = string;
        this.pssyspfpluginidDirtyFlag = true;
    }

    public String getPSSysPFPluginId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPFPluginId();
        }
        return this.pssyspfpluginid;
    }

    public boolean isPSSysPFPluginIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysPFPluginIdDirty();
        }
        return this.pssyspfpluginidDirtyFlag;
    }

    public void resetPSSysPFPluginId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysPFPluginId();
            return;
        }
        this.pssyspfpluginidDirtyFlag = false;
        this.pssyspfpluginid = null;
    }

    public void setPSSysPFPluginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysPFPluginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyspfpluginname = string;
        this.pssyspfpluginnameDirtyFlag = true;
    }

    public String getPSSysPFPluginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPFPluginName();
        }
        return this.pssyspfpluginname;
    }

    public boolean isPSSysPFPluginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysPFPluginNameDirty();
        }
        return this.pssyspfpluginnameDirtyFlag;
    }

    public void resetPSSysPFPluginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysPFPluginName();
            return;
        }
        this.pssyspfpluginnameDirtyFlag = false;
        this.pssyspfpluginname = null;
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

    public void setPSSysTranslatorId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysTranslatorId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystranslatorid = string;
        this.pssystranslatoridDirtyFlag = true;
    }

    public String getPSSysTranslatorId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTranslatorId();
        }
        return this.pssystranslatorid;
    }

    public boolean isPSSysTranslatorIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysTranslatorIdDirty();
        }
        return this.pssystranslatoridDirtyFlag;
    }

    public void resetPSSysTranslatorId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysTranslatorId();
            return;
        }
        this.pssystranslatoridDirtyFlag = false;
        this.pssystranslatorid = null;
    }

    public void setPSSysTranslatorName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysTranslatorName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystranslatorname = string;
        this.pssystranslatornameDirtyFlag = true;
    }

    public String getPSSysTranslatorName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTranslatorName();
        }
        return this.pssystranslatorname;
    }

    public boolean isPSSysTranslatorNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysTranslatorNameDirty();
        }
        return this.pssystranslatornameDirtyFlag;
    }

    public void resetPSSysTranslatorName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysTranslatorName();
            return;
        }
        this.pssystranslatornameDirtyFlag = false;
        this.pssystranslatorname = null;
    }

    public void setRefFieldName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefFieldName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.reffieldname = string;
        this.reffieldnameDirtyFlag = true;
    }

    public String getRefFieldName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefFieldName();
        }
        return this.reffieldname;
    }

    public boolean isRefFieldNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefFieldNameDirty();
        }
        return this.reffieldnameDirtyFlag;
    }

    public void resetRefFieldName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefFieldName();
            return;
        }
        this.reffieldnameDirtyFlag = false;
        this.reffieldname = null;
    }

    public void setRefParamName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefParamName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refparamname = string;
        this.refparamnameDirtyFlag = true;
    }

    public String getRefParamName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefParamName();
        }
        return this.refparamname;
    }

    public boolean isRefParamNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefParamNameDirty();
        }
        return this.refparamnameDirtyFlag;
    }

    public void resetRefParamName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefParamName();
            return;
        }
        this.refparamnameDirtyFlag = false;
        this.refparamname = null;
    }

    public void setStdDataType(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStdDataType(n);
            return;
        }
        this.stddatatype = n;
        this.stddatatypeDirtyFlag = true;
    }

    public Integer getStdDataType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStdDataType();
        }
        return this.stddatatype;
    }

    public boolean isStdDataTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStdDataTypeDirty();
        }
        return this.stddatatypeDirtyFlag;
    }

    public void resetStdDataType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStdDataType();
            return;
        }
        this.stddatatypeDirtyFlag = false;
        this.stddatatype = null;
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
        PSDELogicParamBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDELogicParamBase pSDELogicParamBase) {
        pSDELogicParamBase.resetCloneParamFlag();
        pSDELogicParamBase.resetCreateDate();
        pSDELogicParamBase.resetCreateMan();
        pSDELogicParamBase.resetDefaultParam();
        pSDELogicParamBase.resetDefaultValue();
        pSDELogicParamBase.resetDefaultValueType();
        pSDELogicParamBase.resetDynaModelFlag();
        pSDELogicParamBase.resetFileType();
        pSDELogicParamBase.resetFileUrl();
        pSDELogicParamBase.resetGlobalParam();
        pSDELogicParamBase.resetLogicName();
        pSDELogicParamBase.resetMemo();
        pSDELogicParamBase.resetOriginEntityFlag();
        pSDELogicParamBase.resetParamPSDEFGroupId();
        pSDELogicParamBase.resetParamPSDEFGroupName();
        pSDELogicParamBase.resetParamPSDEId();
        pSDELogicParamBase.resetParamPSDEName();
        pSDELogicParamBase.resetParams();
        pSDELogicParamBase.resetParamTag();
        pSDELogicParamBase.resetParamTag2();
        pSDELogicParamBase.resetPSDELogicId();
        pSDELogicParamBase.resetPSDELogicName();
        pSDELogicParamBase.resetPSDELogicParamId();
        pSDELogicParamBase.resetPSDELogicParamName();
        pSDELogicParamBase.resetPSDynaInstId();
        pSDELogicParamBase.resetPSSysDynaModelId();
        pSDELogicParamBase.resetPSSysDynaModelName();
        pSDELogicParamBase.resetPSSysPFPluginId();
        pSDELogicParamBase.resetPSSysPFPluginName();
        pSDELogicParamBase.resetPSSysResourceId();
        pSDELogicParamBase.resetPSSysResourceName();
        pSDELogicParamBase.resetPSSysSFPluginId();
        pSDELogicParamBase.resetPSSysSFPluginName();
        pSDELogicParamBase.resetPSSystemId();
        pSDELogicParamBase.resetPSSysTranslatorId();
        pSDELogicParamBase.resetPSSysTranslatorName();
        pSDELogicParamBase.resetRefFieldName();
        pSDELogicParamBase.resetRefParamName();
        pSDELogicParamBase.resetStdDataType();
        pSDELogicParamBase.resetUpdateDate();
        pSDELogicParamBase.resetUpdateMan();
        pSDELogicParamBase.resetUserCat();
        pSDELogicParamBase.resetUserParams();
        pSDELogicParamBase.resetUserTag();
        pSDELogicParamBase.resetUserTag2();
        pSDELogicParamBase.resetUserTag3();
        pSDELogicParamBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCloneParamFlagDirty()) {
            hashMap.put(FIELD_CLONEPARAMFLAG, this.getCloneParamFlag());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDefaultParamDirty()) {
            hashMap.put(FIELD_DEFAULTPARAM, this.getDefaultParam());
        }
        if (!bl || this.isDefaultValueDirty()) {
            hashMap.put(FIELD_DEFAULTVALUE, this.getDefaultValue());
        }
        if (!bl || this.isDefaultValueTypeDirty()) {
            hashMap.put(FIELD_DEFAULTVALUETYPE, this.getDefaultValueType());
        }
        if (!bl || this.isDynaModelFlagDirty()) {
            hashMap.put(FIELD_DYNAMODELFLAG, this.getDynaModelFlag());
        }
        if (!bl || this.isFileTypeDirty()) {
            hashMap.put(FIELD_FILETYPE, this.getFileType());
        }
        if (!bl || this.isFileUrlDirty()) {
            hashMap.put(FIELD_FILEURL, this.getFileUrl());
        }
        if (!bl || this.isGlobalParamDirty()) {
            hashMap.put(FIELD_GLOBALPARAM, this.getGlobalParam());
        }
        if (!bl || this.isLogicNameDirty()) {
            hashMap.put(FIELD_LOGICNAME, this.getLogicName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOriginEntityFlagDirty()) {
            hashMap.put(FIELD_ORIGINENTITYFLAG, this.getOriginEntityFlag());
        }
        if (!bl || this.isParamPSDEFGroupIdDirty()) {
            hashMap.put(FIELD_PARAMPSDEFGROUPID, this.getParamPSDEFGroupId());
        }
        if (!bl || this.isParamPSDEFGroupNameDirty()) {
            hashMap.put(FIELD_PARAMPSDEFGROUPNAME, this.getParamPSDEFGroupName());
        }
        if (!bl || this.isParamPSDEIdDirty()) {
            hashMap.put(FIELD_PARAMPSDEID, this.getParamPSDEId());
        }
        if (!bl || this.isParamPSDENameDirty()) {
            hashMap.put(FIELD_PARAMPSDENAME, this.getParamPSDEName());
        }
        if (!bl || this.isParamsDirty()) {
            hashMap.put(FIELD_PARAMS, this.getParams());
        }
        if (!bl || this.isParamTagDirty()) {
            hashMap.put(FIELD_PARAMTAG, this.getParamTag());
        }
        if (!bl || this.isParamTag2Dirty()) {
            hashMap.put(FIELD_PARAMTAG2, this.getParamTag2());
        }
        if (!bl || this.isPSDELogicIdDirty()) {
            hashMap.put(FIELD_PSDELOGICID, this.getPSDELogicId());
        }
        if (!bl || this.isPSDELogicNameDirty()) {
            hashMap.put(FIELD_PSDELOGICNAME, this.getPSDELogicName());
        }
        if (!bl || this.isPSDELogicParamIdDirty()) {
            hashMap.put(FIELD_PSDELOGICPARAMID, this.getPSDELogicParamId());
        }
        if (!bl || this.isPSDELogicParamNameDirty()) {
            hashMap.put(FIELD_PSDELOGICPARAMNAME, this.getPSDELogicParamName());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSSysDynaModelIdDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELID, this.getPSSysDynaModelId());
        }
        if (!bl || this.isPSSysDynaModelNameDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELNAME, this.getPSSysDynaModelName());
        }
        if (!bl || this.isPSSysPFPluginIdDirty()) {
            hashMap.put(FIELD_PSSYSPFPLUGINID, this.getPSSysPFPluginId());
        }
        if (!bl || this.isPSSysPFPluginNameDirty()) {
            hashMap.put(FIELD_PSSYSPFPLUGINNAME, this.getPSSysPFPluginName());
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
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSysTranslatorIdDirty()) {
            hashMap.put(FIELD_PSSYSTRANSLATORID, this.getPSSysTranslatorId());
        }
        if (!bl || this.isPSSysTranslatorNameDirty()) {
            hashMap.put(FIELD_PSSYSTRANSLATORNAME, this.getPSSysTranslatorName());
        }
        if (!bl || this.isRefFieldNameDirty()) {
            hashMap.put(FIELD_REFFIELDNAME, this.getRefFieldName());
        }
        if (!bl || this.isRefParamNameDirty()) {
            hashMap.put(FIELD_REFPARAMNAME, this.getRefParamName());
        }
        if (!bl || this.isStdDataTypeDirty()) {
            hashMap.put(FIELD_STDDATATYPE, this.getStdDataType());
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
        return PSDELogicParamBase.get(this, n);
    }

    private static Object get(PSDELogicParamBase pSDELogicParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDELogicParamBase.getCloneParamFlag();
            }
            case 1: {
                return pSDELogicParamBase.getCreateDate();
            }
            case 2: {
                return pSDELogicParamBase.getCreateMan();
            }
            case 3: {
                return pSDELogicParamBase.getDefaultParam();
            }
            case 4: {
                return pSDELogicParamBase.getDefaultValue();
            }
            case 5: {
                return pSDELogicParamBase.getDefaultValueType();
            }
            case 6: {
                return pSDELogicParamBase.getDynaModelFlag();
            }
            case 7: {
                return pSDELogicParamBase.getFileType();
            }
            case 8: {
                return pSDELogicParamBase.getFileUrl();
            }
            case 9: {
                return pSDELogicParamBase.getGlobalParam();
            }
            case 10: {
                return pSDELogicParamBase.getLogicName();
            }
            case 11: {
                return pSDELogicParamBase.getMemo();
            }
            case 12: {
                return pSDELogicParamBase.getOriginEntityFlag();
            }
            case 13: {
                return pSDELogicParamBase.getParamPSDEFGroupId();
            }
            case 14: {
                return pSDELogicParamBase.getParamPSDEFGroupName();
            }
            case 15: {
                return pSDELogicParamBase.getParamPSDEId();
            }
            case 16: {
                return pSDELogicParamBase.getParamPSDEName();
            }
            case 17: {
                return pSDELogicParamBase.getParams();
            }
            case 18: {
                return pSDELogicParamBase.getParamTag();
            }
            case 19: {
                return pSDELogicParamBase.getParamTag2();
            }
            case 20: {
                return pSDELogicParamBase.getPSDELogicId();
            }
            case 21: {
                return pSDELogicParamBase.getPSDELogicName();
            }
            case 22: {
                return pSDELogicParamBase.getPSDELogicParamId();
            }
            case 23: {
                return pSDELogicParamBase.getPSDELogicParamName();
            }
            case 24: {
                return pSDELogicParamBase.getPSDynaInstId();
            }
            case 25: {
                return pSDELogicParamBase.getPSSysDynaModelId();
            }
            case 26: {
                return pSDELogicParamBase.getPSSysDynaModelName();
            }
            case 27: {
                return pSDELogicParamBase.getPSSysPFPluginId();
            }
            case 28: {
                return pSDELogicParamBase.getPSSysPFPluginName();
            }
            case 29: {
                return pSDELogicParamBase.getPSSysResourceId();
            }
            case 30: {
                return pSDELogicParamBase.getPSSysResourceName();
            }
            case 31: {
                return pSDELogicParamBase.getPSSysSFPluginId();
            }
            case 32: {
                return pSDELogicParamBase.getPSSysSFPluginName();
            }
            case 33: {
                return pSDELogicParamBase.getPSSystemId();
            }
            case 34: {
                return pSDELogicParamBase.getPSSysTranslatorId();
            }
            case 35: {
                return pSDELogicParamBase.getPSSysTranslatorName();
            }
            case 36: {
                return pSDELogicParamBase.getRefFieldName();
            }
            case 37: {
                return pSDELogicParamBase.getRefParamName();
            }
            case 38: {
                return pSDELogicParamBase.getStdDataType();
            }
            case 39: {
                return pSDELogicParamBase.getUpdateDate();
            }
            case 40: {
                return pSDELogicParamBase.getUpdateMan();
            }
            case 41: {
                return pSDELogicParamBase.getUserCat();
            }
            case 42: {
                return pSDELogicParamBase.getUserParams();
            }
            case 43: {
                return pSDELogicParamBase.getUserTag();
            }
            case 44: {
                return pSDELogicParamBase.getUserTag2();
            }
            case 45: {
                return pSDELogicParamBase.getUserTag3();
            }
            case 46: {
                return pSDELogicParamBase.getUserTag4();
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
        PSDELogicParamBase.set(this, n, object);
    }

    private static void set(PSDELogicParamBase pSDELogicParamBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDELogicParamBase.setCloneParamFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSDELogicParamBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDELogicParamBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDELogicParamBase.setDefaultParam(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSDELogicParamBase.setDefaultValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDELogicParamBase.setDefaultValueType(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDELogicParamBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSDELogicParamBase.setFileType(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDELogicParamBase.setFileUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDELogicParamBase.setGlobalParam(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSDELogicParamBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDELogicParamBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDELogicParamBase.setOriginEntityFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSDELogicParamBase.setParamPSDEFGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDELogicParamBase.setParamPSDEFGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDELogicParamBase.setParamPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDELogicParamBase.setParamPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDELogicParamBase.setParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDELogicParamBase.setParamTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDELogicParamBase.setParamTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDELogicParamBase.setPSDELogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDELogicParamBase.setPSDELogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDELogicParamBase.setPSDELogicParamId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDELogicParamBase.setPSDELogicParamName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDELogicParamBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDELogicParamBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDELogicParamBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDELogicParamBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDELogicParamBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDELogicParamBase.setPSSysResourceId(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDELogicParamBase.setPSSysResourceName(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDELogicParamBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDELogicParamBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDELogicParamBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDELogicParamBase.setPSSysTranslatorId(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDELogicParamBase.setPSSysTranslatorName(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDELogicParamBase.setRefFieldName(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSDELogicParamBase.setRefParamName(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDELogicParamBase.setStdDataType(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 39: {
                pSDELogicParamBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 40: {
                pSDELogicParamBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSDELogicParamBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSDELogicParamBase.setUserParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSDELogicParamBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSDELogicParamBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSDELogicParamBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSDELogicParamBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSDELogicParamBase.isNull(this, n);
    }

    private static boolean isNull(PSDELogicParamBase pSDELogicParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDELogicParamBase.getCloneParamFlag() == null;
            }
            case 1: {
                return pSDELogicParamBase.getCreateDate() == null;
            }
            case 2: {
                return pSDELogicParamBase.getCreateMan() == null;
            }
            case 3: {
                return pSDELogicParamBase.getDefaultParam() == null;
            }
            case 4: {
                return pSDELogicParamBase.getDefaultValue() == null;
            }
            case 5: {
                return pSDELogicParamBase.getDefaultValueType() == null;
            }
            case 6: {
                return pSDELogicParamBase.getDynaModelFlag() == null;
            }
            case 7: {
                return pSDELogicParamBase.getFileType() == null;
            }
            case 8: {
                return pSDELogicParamBase.getFileUrl() == null;
            }
            case 9: {
                return pSDELogicParamBase.getGlobalParam() == null;
            }
            case 10: {
                return pSDELogicParamBase.getLogicName() == null;
            }
            case 11: {
                return pSDELogicParamBase.getMemo() == null;
            }
            case 12: {
                return pSDELogicParamBase.getOriginEntityFlag() == null;
            }
            case 13: {
                return pSDELogicParamBase.getParamPSDEFGroupId() == null;
            }
            case 14: {
                return pSDELogicParamBase.getParamPSDEFGroupName() == null;
            }
            case 15: {
                return pSDELogicParamBase.getParamPSDEId() == null;
            }
            case 16: {
                return pSDELogicParamBase.getParamPSDEName() == null;
            }
            case 17: {
                return pSDELogicParamBase.getParams() == null;
            }
            case 18: {
                return pSDELogicParamBase.getParamTag() == null;
            }
            case 19: {
                return pSDELogicParamBase.getParamTag2() == null;
            }
            case 20: {
                return pSDELogicParamBase.getPSDELogicId() == null;
            }
            case 21: {
                return pSDELogicParamBase.getPSDELogicName() == null;
            }
            case 22: {
                return pSDELogicParamBase.getPSDELogicParamId() == null;
            }
            case 23: {
                return pSDELogicParamBase.getPSDELogicParamName() == null;
            }
            case 24: {
                return pSDELogicParamBase.getPSDynaInstId() == null;
            }
            case 25: {
                return pSDELogicParamBase.getPSSysDynaModelId() == null;
            }
            case 26: {
                return pSDELogicParamBase.getPSSysDynaModelName() == null;
            }
            case 27: {
                return pSDELogicParamBase.getPSSysPFPluginId() == null;
            }
            case 28: {
                return pSDELogicParamBase.getPSSysPFPluginName() == null;
            }
            case 29: {
                return pSDELogicParamBase.getPSSysResourceId() == null;
            }
            case 30: {
                return pSDELogicParamBase.getPSSysResourceName() == null;
            }
            case 31: {
                return pSDELogicParamBase.getPSSysSFPluginId() == null;
            }
            case 32: {
                return pSDELogicParamBase.getPSSysSFPluginName() == null;
            }
            case 33: {
                return pSDELogicParamBase.getPSSystemId() == null;
            }
            case 34: {
                return pSDELogicParamBase.getPSSysTranslatorId() == null;
            }
            case 35: {
                return pSDELogicParamBase.getPSSysTranslatorName() == null;
            }
            case 36: {
                return pSDELogicParamBase.getRefFieldName() == null;
            }
            case 37: {
                return pSDELogicParamBase.getRefParamName() == null;
            }
            case 38: {
                return pSDELogicParamBase.getStdDataType() == null;
            }
            case 39: {
                return pSDELogicParamBase.getUpdateDate() == null;
            }
            case 40: {
                return pSDELogicParamBase.getUpdateMan() == null;
            }
            case 41: {
                return pSDELogicParamBase.getUserCat() == null;
            }
            case 42: {
                return pSDELogicParamBase.getUserParams() == null;
            }
            case 43: {
                return pSDELogicParamBase.getUserTag() == null;
            }
            case 44: {
                return pSDELogicParamBase.getUserTag2() == null;
            }
            case 45: {
                return pSDELogicParamBase.getUserTag3() == null;
            }
            case 46: {
                return pSDELogicParamBase.getUserTag4() == null;
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
        return PSDELogicParamBase.contains(this, n);
    }

    private static boolean contains(PSDELogicParamBase pSDELogicParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDELogicParamBase.isCloneParamFlagDirty();
            }
            case 1: {
                return pSDELogicParamBase.isCreateDateDirty();
            }
            case 2: {
                return pSDELogicParamBase.isCreateManDirty();
            }
            case 3: {
                return pSDELogicParamBase.isDefaultParamDirty();
            }
            case 4: {
                return pSDELogicParamBase.isDefaultValueDirty();
            }
            case 5: {
                return pSDELogicParamBase.isDefaultValueTypeDirty();
            }
            case 6: {
                return pSDELogicParamBase.isDynaModelFlagDirty();
            }
            case 7: {
                return pSDELogicParamBase.isFileTypeDirty();
            }
            case 8: {
                return pSDELogicParamBase.isFileUrlDirty();
            }
            case 9: {
                return pSDELogicParamBase.isGlobalParamDirty();
            }
            case 10: {
                return pSDELogicParamBase.isLogicNameDirty();
            }
            case 11: {
                return pSDELogicParamBase.isMemoDirty();
            }
            case 12: {
                return pSDELogicParamBase.isOriginEntityFlagDirty();
            }
            case 13: {
                return pSDELogicParamBase.isParamPSDEFGroupIdDirty();
            }
            case 14: {
                return pSDELogicParamBase.isParamPSDEFGroupNameDirty();
            }
            case 15: {
                return pSDELogicParamBase.isParamPSDEIdDirty();
            }
            case 16: {
                return pSDELogicParamBase.isParamPSDENameDirty();
            }
            case 17: {
                return pSDELogicParamBase.isParamsDirty();
            }
            case 18: {
                return pSDELogicParamBase.isParamTagDirty();
            }
            case 19: {
                return pSDELogicParamBase.isParamTag2Dirty();
            }
            case 20: {
                return pSDELogicParamBase.isPSDELogicIdDirty();
            }
            case 21: {
                return pSDELogicParamBase.isPSDELogicNameDirty();
            }
            case 22: {
                return pSDELogicParamBase.isPSDELogicParamIdDirty();
            }
            case 23: {
                return pSDELogicParamBase.isPSDELogicParamNameDirty();
            }
            case 24: {
                return pSDELogicParamBase.isPSDynaInstIdDirty();
            }
            case 25: {
                return pSDELogicParamBase.isPSSysDynaModelIdDirty();
            }
            case 26: {
                return pSDELogicParamBase.isPSSysDynaModelNameDirty();
            }
            case 27: {
                return pSDELogicParamBase.isPSSysPFPluginIdDirty();
            }
            case 28: {
                return pSDELogicParamBase.isPSSysPFPluginNameDirty();
            }
            case 29: {
                return pSDELogicParamBase.isPSSysResourceIdDirty();
            }
            case 30: {
                return pSDELogicParamBase.isPSSysResourceNameDirty();
            }
            case 31: {
                return pSDELogicParamBase.isPSSysSFPluginIdDirty();
            }
            case 32: {
                return pSDELogicParamBase.isPSSysSFPluginNameDirty();
            }
            case 33: {
                return pSDELogicParamBase.isPSSystemIdDirty();
            }
            case 34: {
                return pSDELogicParamBase.isPSSysTranslatorIdDirty();
            }
            case 35: {
                return pSDELogicParamBase.isPSSysTranslatorNameDirty();
            }
            case 36: {
                return pSDELogicParamBase.isRefFieldNameDirty();
            }
            case 37: {
                return pSDELogicParamBase.isRefParamNameDirty();
            }
            case 38: {
                return pSDELogicParamBase.isStdDataTypeDirty();
            }
            case 39: {
                return pSDELogicParamBase.isUpdateDateDirty();
            }
            case 40: {
                return pSDELogicParamBase.isUpdateManDirty();
            }
            case 41: {
                return pSDELogicParamBase.isUserCatDirty();
            }
            case 42: {
                return pSDELogicParamBase.isUserParamsDirty();
            }
            case 43: {
                return pSDELogicParamBase.isUserTagDirty();
            }
            case 44: {
                return pSDELogicParamBase.isUserTag2Dirty();
            }
            case 45: {
                return pSDELogicParamBase.isUserTag3Dirty();
            }
            case 46: {
                return pSDELogicParamBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDELogicParamBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDELogicParamBase pSDELogicParamBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDELogicParamBase.getCloneParamFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cloneparamflag", (Object)PSDELogicParamBase.getJSONValue((Object)pSDELogicParamBase.getCloneParamFlag()), (boolean)false);
        }
        if (bl || pSDELogicParamBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDELogicParamBase.getJSONValue((Object)pSDELogicParamBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDELogicParamBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDELogicParamBase.getJSONValue((Object)pSDELogicParamBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDELogicParamBase.getDefaultParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultparam", (Object)PSDELogicParamBase.getJSONValue((Object)pSDELogicParamBase.getDefaultParam()), (boolean)false);
        }
        if (bl || pSDELogicParamBase.getDefaultValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultvalue", (Object)PSDELogicParamBase.getJSONValue((Object)pSDELogicParamBase.getDefaultValue()), (boolean)false);
        }
        if (bl || pSDELogicParamBase.getDefaultValueType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultvaluetype", (Object)PSDELogicParamBase.getJSONValue((Object)pSDELogicParamBase.getDefaultValueType()), (boolean)false);
        }
        if (bl || pSDELogicParamBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSDELogicParamBase.getJSONValue((Object)pSDELogicParamBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSDELogicParamBase.getFileType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"filetype", (Object)PSDELogicParamBase.getJSONValue((Object)pSDELogicParamBase.getFileType()), (boolean)false);
        }
        if (bl || pSDELogicParamBase.getFileUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fileurl", (Object)PSDELogicParamBase.getJSONValue((Object)pSDELogicParamBase.getFileUrl()), (boolean)false);
        }
        if (bl || pSDELogicParamBase.getGlobalParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"globalparam", (Object)PSDELogicParamBase.getJSONValue((Object)pSDELogicParamBase.getGlobalParam()), (boolean)false);
        }
        if (bl || pSDELogicParamBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSDELogicParamBase.getJSONValue((Object)pSDELogicParamBase.getLogicName()), (boolean)false);
        }
        if (bl || pSDELogicParamBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDELogicParamBase.getJSONValue((Object)pSDELogicParamBase.getMemo()), (boolean)false);
        }
        if (bl || pSDELogicParamBase.getOriginEntityFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"originentityflag", (Object)PSDELogicParamBase.getJSONValue((Object)pSDELogicParamBase.getOriginEntityFlag()), (boolean)false);
        }
        if (bl || pSDELogicParamBase.getParamPSDEFGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"parampsdefgroupid", (Object)PSDELogicParamBase.getJSONValue((Object)pSDELogicParamBase.getParamPSDEFGroupId()), (boolean)false);
        }
        if (bl || pSDELogicParamBase.getParamPSDEFGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"parampsdefgroupname", (Object)PSDELogicParamBase.getJSONValue((Object)pSDELogicParamBase.getParamPSDEFGroupName()), (boolean)false);
        }
        if (bl || pSDELogicParamBase.getParamPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"parampsdeid", (Object)PSDELogicParamBase.getJSONValue((Object)pSDELogicParamBase.getParamPSDEId()), (boolean)false);
        }
        if (bl || pSDELogicParamBase.getParamPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"parampsdename", (Object)PSDELogicParamBase.getJSONValue((Object)pSDELogicParamBase.getParamPSDEName()), (boolean)false);
        }
        if (bl || pSDELogicParamBase.getParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"params", (Object)PSDELogicParamBase.getJSONValue((Object)pSDELogicParamBase.getParams()), (boolean)false);
        }
        if (bl || pSDELogicParamBase.getParamTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"paramtag", (Object)PSDELogicParamBase.getJSONValue((Object)pSDELogicParamBase.getParamTag()), (boolean)false);
        }
        if (bl || pSDELogicParamBase.getParamTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"paramtag2", (Object)PSDELogicParamBase.getJSONValue((Object)pSDELogicParamBase.getParamTag2()), (boolean)false);
        }
        if (bl || pSDELogicParamBase.getPSDELogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicid", (Object)PSDELogicParamBase.getJSONValue((Object)pSDELogicParamBase.getPSDELogicId()), (boolean)false);
        }
        if (bl || pSDELogicParamBase.getPSDELogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicname", (Object)PSDELogicParamBase.getJSONValue((Object)pSDELogicParamBase.getPSDELogicName()), (boolean)false);
        }
        if (bl || pSDELogicParamBase.getPSDELogicParamId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicparamid", (Object)PSDELogicParamBase.getJSONValue((Object)pSDELogicParamBase.getPSDELogicParamId()), (boolean)false);
        }
        if (bl || pSDELogicParamBase.getPSDELogicParamName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicparamname", (Object)PSDELogicParamBase.getJSONValue((Object)pSDELogicParamBase.getPSDELogicParamName()), (boolean)false);
        }
        if (bl || pSDELogicParamBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSDELogicParamBase.getJSONValue((Object)pSDELogicParamBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSDELogicParamBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSDELogicParamBase.getJSONValue((Object)pSDELogicParamBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSDELogicParamBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSDELogicParamBase.getJSONValue((Object)pSDELogicParamBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSDELogicParamBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSDELogicParamBase.getJSONValue((Object)pSDELogicParamBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSDELogicParamBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSDELogicParamBase.getJSONValue((Object)pSDELogicParamBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSDELogicParamBase.getPSSysResourceId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysresourceid", (Object)PSDELogicParamBase.getJSONValue((Object)pSDELogicParamBase.getPSSysResourceId()), (boolean)false);
        }
        if (bl || pSDELogicParamBase.getPSSysResourceName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysresourcename", (Object)PSDELogicParamBase.getJSONValue((Object)pSDELogicParamBase.getPSSysResourceName()), (boolean)false);
        }
        if (bl || pSDELogicParamBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSDELogicParamBase.getJSONValue((Object)pSDELogicParamBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSDELogicParamBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSDELogicParamBase.getJSONValue((Object)pSDELogicParamBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSDELogicParamBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSDELogicParamBase.getJSONValue((Object)pSDELogicParamBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSDELogicParamBase.getPSSysTranslatorId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystranslatorid", (Object)PSDELogicParamBase.getJSONValue((Object)pSDELogicParamBase.getPSSysTranslatorId()), (boolean)false);
        }
        if (bl || pSDELogicParamBase.getPSSysTranslatorName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystranslatorname", (Object)PSDELogicParamBase.getJSONValue((Object)pSDELogicParamBase.getPSSysTranslatorName()), (boolean)false);
        }
        if (bl || pSDELogicParamBase.getRefFieldName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"reffieldname", (Object)PSDELogicParamBase.getJSONValue((Object)pSDELogicParamBase.getRefFieldName()), (boolean)false);
        }
        if (bl || pSDELogicParamBase.getRefParamName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refparamname", (Object)PSDELogicParamBase.getJSONValue((Object)pSDELogicParamBase.getRefParamName()), (boolean)false);
        }
        if (bl || pSDELogicParamBase.getStdDataType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"stddatatype", (Object)PSDELogicParamBase.getJSONValue((Object)pSDELogicParamBase.getStdDataType()), (boolean)false);
        }
        if (bl || pSDELogicParamBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDELogicParamBase.getJSONValue((Object)pSDELogicParamBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDELogicParamBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDELogicParamBase.getJSONValue((Object)pSDELogicParamBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDELogicParamBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDELogicParamBase.getJSONValue((Object)pSDELogicParamBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDELogicParamBase.getUserParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userparams", (Object)PSDELogicParamBase.getJSONValue((Object)pSDELogicParamBase.getUserParams()), (boolean)false);
        }
        if (bl || pSDELogicParamBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDELogicParamBase.getJSONValue((Object)pSDELogicParamBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDELogicParamBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDELogicParamBase.getJSONValue((Object)pSDELogicParamBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDELogicParamBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDELogicParamBase.getJSONValue((Object)pSDELogicParamBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDELogicParamBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDELogicParamBase.getJSONValue((Object)pSDELogicParamBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDELogicParamBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDELogicParamBase pSDELogicParamBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDELogicParamBase.getCloneParamFlag() != null) {
            object = pSDELogicParamBase.getCloneParamFlag();
            xmlNode.setAttribute(FIELD_CLONEPARAMFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDELogicParamBase.getCreateDate() != null) {
            object = pSDELogicParamBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDELogicParamBase.getCreateMan() != null) {
            object = pSDELogicParamBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicParamBase.getDefaultParam() != null) {
            object = pSDELogicParamBase.getDefaultParam();
            xmlNode.setAttribute(FIELD_DEFAULTPARAM, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDELogicParamBase.getDefaultValue() != null) {
            object = pSDELogicParamBase.getDefaultValue();
            xmlNode.setAttribute(FIELD_DEFAULTVALUE, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicParamBase.getDefaultValueType() != null) {
            object = pSDELogicParamBase.getDefaultValueType();
            xmlNode.setAttribute(FIELD_DEFAULTVALUETYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicParamBase.getDynaModelFlag() != null) {
            object = pSDELogicParamBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDELogicParamBase.getFileType() != null) {
            object = pSDELogicParamBase.getFileType();
            xmlNode.setAttribute(FIELD_FILETYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicParamBase.getFileUrl() != null) {
            object = pSDELogicParamBase.getFileUrl();
            xmlNode.setAttribute(FIELD_FILEURL, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicParamBase.getGlobalParam() != null) {
            object = pSDELogicParamBase.getGlobalParam();
            xmlNode.setAttribute(FIELD_GLOBALPARAM, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDELogicParamBase.getLogicName() != null) {
            object = pSDELogicParamBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicParamBase.getMemo() != null) {
            object = pSDELogicParamBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicParamBase.getOriginEntityFlag() != null) {
            object = pSDELogicParamBase.getOriginEntityFlag();
            xmlNode.setAttribute(FIELD_ORIGINENTITYFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDELogicParamBase.getParamPSDEFGroupId() != null) {
            object = pSDELogicParamBase.getParamPSDEFGroupId();
            xmlNode.setAttribute(FIELD_PARAMPSDEFGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicParamBase.getParamPSDEFGroupName() != null) {
            object = pSDELogicParamBase.getParamPSDEFGroupName();
            xmlNode.setAttribute(FIELD_PARAMPSDEFGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicParamBase.getParamPSDEId() != null) {
            object = pSDELogicParamBase.getParamPSDEId();
            xmlNode.setAttribute(FIELD_PARAMPSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicParamBase.getParamPSDEName() != null) {
            object = pSDELogicParamBase.getParamPSDEName();
            xmlNode.setAttribute(FIELD_PARAMPSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicParamBase.getParams() != null) {
            object = pSDELogicParamBase.getParams();
            xmlNode.setAttribute(FIELD_PARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicParamBase.getParamTag() != null) {
            object = pSDELogicParamBase.getParamTag();
            xmlNode.setAttribute(FIELD_PARAMTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicParamBase.getParamTag2() != null) {
            object = pSDELogicParamBase.getParamTag2();
            xmlNode.setAttribute(FIELD_PARAMTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicParamBase.getPSDELogicId() != null) {
            object = pSDELogicParamBase.getPSDELogicId();
            xmlNode.setAttribute(FIELD_PSDELOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicParamBase.getPSDELogicName() != null) {
            object = pSDELogicParamBase.getPSDELogicName();
            xmlNode.setAttribute(FIELD_PSDELOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicParamBase.getPSDELogicParamId() != null) {
            object = pSDELogicParamBase.getPSDELogicParamId();
            xmlNode.setAttribute(FIELD_PSDELOGICPARAMID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicParamBase.getPSDELogicParamName() != null) {
            object = pSDELogicParamBase.getPSDELogicParamName();
            xmlNode.setAttribute(FIELD_PSDELOGICPARAMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicParamBase.getPSDynaInstId() != null) {
            object = pSDELogicParamBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicParamBase.getPSSysDynaModelId() != null) {
            object = pSDELogicParamBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicParamBase.getPSSysDynaModelName() != null) {
            object = pSDELogicParamBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicParamBase.getPSSysPFPluginId() != null) {
            object = pSDELogicParamBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicParamBase.getPSSysPFPluginName() != null) {
            object = pSDELogicParamBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicParamBase.getPSSysResourceId() != null) {
            object = pSDELogicParamBase.getPSSysResourceId();
            xmlNode.setAttribute(FIELD_PSSYSRESOURCEID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicParamBase.getPSSysResourceName() != null) {
            object = pSDELogicParamBase.getPSSysResourceName();
            xmlNode.setAttribute(FIELD_PSSYSRESOURCENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicParamBase.getPSSysSFPluginId() != null) {
            object = pSDELogicParamBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicParamBase.getPSSysSFPluginName() != null) {
            object = pSDELogicParamBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicParamBase.getPSSystemId() != null) {
            object = pSDELogicParamBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicParamBase.getPSSysTranslatorId() != null) {
            object = pSDELogicParamBase.getPSSysTranslatorId();
            xmlNode.setAttribute(FIELD_PSSYSTRANSLATORID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicParamBase.getPSSysTranslatorName() != null) {
            object = pSDELogicParamBase.getPSSysTranslatorName();
            xmlNode.setAttribute(FIELD_PSSYSTRANSLATORNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicParamBase.getRefFieldName() != null) {
            object = pSDELogicParamBase.getRefFieldName();
            xmlNode.setAttribute(FIELD_REFFIELDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicParamBase.getRefParamName() != null) {
            object = pSDELogicParamBase.getRefParamName();
            xmlNode.setAttribute(FIELD_REFPARAMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicParamBase.getStdDataType() != null) {
            object = pSDELogicParamBase.getStdDataType();
            xmlNode.setAttribute(FIELD_STDDATATYPE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDELogicParamBase.getUpdateDate() != null) {
            object = pSDELogicParamBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDELogicParamBase.getUpdateMan() != null) {
            object = pSDELogicParamBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicParamBase.getUserCat() != null) {
            object = pSDELogicParamBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicParamBase.getUserParams() != null) {
            object = pSDELogicParamBase.getUserParams();
            xmlNode.setAttribute(FIELD_USERPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicParamBase.getUserTag() != null) {
            object = pSDELogicParamBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicParamBase.getUserTag2() != null) {
            object = pSDELogicParamBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicParamBase.getUserTag3() != null) {
            object = pSDELogicParamBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicParamBase.getUserTag4() != null) {
            object = pSDELogicParamBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDELogicParamBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDELogicParamBase pSDELogicParamBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDELogicParamBase.isCloneParamFlagDirty() && (bl || pSDELogicParamBase.getCloneParamFlag() != null)) {
            iDataObject.set(FIELD_CLONEPARAMFLAG, (Object)pSDELogicParamBase.getCloneParamFlag());
        }
        if (pSDELogicParamBase.isCreateDateDirty() && (bl || pSDELogicParamBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDELogicParamBase.getCreateDate());
        }
        if (pSDELogicParamBase.isCreateManDirty() && (bl || pSDELogicParamBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDELogicParamBase.getCreateMan());
        }
        if (pSDELogicParamBase.isDefaultParamDirty() && (bl || pSDELogicParamBase.getDefaultParam() != null)) {
            iDataObject.set(FIELD_DEFAULTPARAM, (Object)pSDELogicParamBase.getDefaultParam());
        }
        if (pSDELogicParamBase.isDefaultValueDirty() && (bl || pSDELogicParamBase.getDefaultValue() != null)) {
            iDataObject.set(FIELD_DEFAULTVALUE, (Object)pSDELogicParamBase.getDefaultValue());
        }
        if (pSDELogicParamBase.isDefaultValueTypeDirty() && (bl || pSDELogicParamBase.getDefaultValueType() != null)) {
            iDataObject.set(FIELD_DEFAULTVALUETYPE, (Object)pSDELogicParamBase.getDefaultValueType());
        }
        if (pSDELogicParamBase.isDynaModelFlagDirty() && (bl || pSDELogicParamBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSDELogicParamBase.getDynaModelFlag());
        }
        if (pSDELogicParamBase.isFileTypeDirty() && (bl || pSDELogicParamBase.getFileType() != null)) {
            iDataObject.set(FIELD_FILETYPE, (Object)pSDELogicParamBase.getFileType());
        }
        if (pSDELogicParamBase.isFileUrlDirty() && (bl || pSDELogicParamBase.getFileUrl() != null)) {
            iDataObject.set(FIELD_FILEURL, (Object)pSDELogicParamBase.getFileUrl());
        }
        if (pSDELogicParamBase.isGlobalParamDirty() && (bl || pSDELogicParamBase.getGlobalParam() != null)) {
            iDataObject.set(FIELD_GLOBALPARAM, (Object)pSDELogicParamBase.getGlobalParam());
        }
        if (pSDELogicParamBase.isLogicNameDirty() && (bl || pSDELogicParamBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSDELogicParamBase.getLogicName());
        }
        if (pSDELogicParamBase.isMemoDirty() && (bl || pSDELogicParamBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDELogicParamBase.getMemo());
        }
        if (pSDELogicParamBase.isOriginEntityFlagDirty() && (bl || pSDELogicParamBase.getOriginEntityFlag() != null)) {
            iDataObject.set(FIELD_ORIGINENTITYFLAG, (Object)pSDELogicParamBase.getOriginEntityFlag());
        }
        if (pSDELogicParamBase.isParamPSDEFGroupIdDirty() && (bl || pSDELogicParamBase.getParamPSDEFGroupId() != null)) {
            iDataObject.set(FIELD_PARAMPSDEFGROUPID, (Object)pSDELogicParamBase.getParamPSDEFGroupId());
        }
        if (pSDELogicParamBase.isParamPSDEFGroupNameDirty() && (bl || pSDELogicParamBase.getParamPSDEFGroupName() != null)) {
            iDataObject.set(FIELD_PARAMPSDEFGROUPNAME, (Object)pSDELogicParamBase.getParamPSDEFGroupName());
        }
        if (pSDELogicParamBase.isParamPSDEIdDirty() && (bl || pSDELogicParamBase.getParamPSDEId() != null)) {
            iDataObject.set(FIELD_PARAMPSDEID, (Object)pSDELogicParamBase.getParamPSDEId());
        }
        if (pSDELogicParamBase.isParamPSDENameDirty() && (bl || pSDELogicParamBase.getParamPSDEName() != null)) {
            iDataObject.set(FIELD_PARAMPSDENAME, (Object)pSDELogicParamBase.getParamPSDEName());
        }
        if (pSDELogicParamBase.isParamsDirty() && (bl || pSDELogicParamBase.getParams() != null)) {
            iDataObject.set(FIELD_PARAMS, (Object)pSDELogicParamBase.getParams());
        }
        if (pSDELogicParamBase.isParamTagDirty() && (bl || pSDELogicParamBase.getParamTag() != null)) {
            iDataObject.set(FIELD_PARAMTAG, (Object)pSDELogicParamBase.getParamTag());
        }
        if (pSDELogicParamBase.isParamTag2Dirty() && (bl || pSDELogicParamBase.getParamTag2() != null)) {
            iDataObject.set(FIELD_PARAMTAG2, (Object)pSDELogicParamBase.getParamTag2());
        }
        if (pSDELogicParamBase.isPSDELogicIdDirty() && (bl || pSDELogicParamBase.getPSDELogicId() != null)) {
            iDataObject.set(FIELD_PSDELOGICID, (Object)pSDELogicParamBase.getPSDELogicId());
        }
        if (pSDELogicParamBase.isPSDELogicNameDirty() && (bl || pSDELogicParamBase.getPSDELogicName() != null)) {
            iDataObject.set(FIELD_PSDELOGICNAME, (Object)pSDELogicParamBase.getPSDELogicName());
        }
        if (pSDELogicParamBase.isPSDELogicParamIdDirty() && (bl || pSDELogicParamBase.getPSDELogicParamId() != null)) {
            iDataObject.set(FIELD_PSDELOGICPARAMID, (Object)pSDELogicParamBase.getPSDELogicParamId());
        }
        if (pSDELogicParamBase.isPSDELogicParamNameDirty() && (bl || pSDELogicParamBase.getPSDELogicParamName() != null)) {
            iDataObject.set(FIELD_PSDELOGICPARAMNAME, (Object)pSDELogicParamBase.getPSDELogicParamName());
        }
        if (pSDELogicParamBase.isPSDynaInstIdDirty() && (bl || pSDELogicParamBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSDELogicParamBase.getPSDynaInstId());
        }
        if (pSDELogicParamBase.isPSSysDynaModelIdDirty() && (bl || pSDELogicParamBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSDELogicParamBase.getPSSysDynaModelId());
        }
        if (pSDELogicParamBase.isPSSysDynaModelNameDirty() && (bl || pSDELogicParamBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSDELogicParamBase.getPSSysDynaModelName());
        }
        if (pSDELogicParamBase.isPSSysPFPluginIdDirty() && (bl || pSDELogicParamBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSDELogicParamBase.getPSSysPFPluginId());
        }
        if (pSDELogicParamBase.isPSSysPFPluginNameDirty() && (bl || pSDELogicParamBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSDELogicParamBase.getPSSysPFPluginName());
        }
        if (pSDELogicParamBase.isPSSysResourceIdDirty() && (bl || pSDELogicParamBase.getPSSysResourceId() != null)) {
            iDataObject.set(FIELD_PSSYSRESOURCEID, (Object)pSDELogicParamBase.getPSSysResourceId());
        }
        if (pSDELogicParamBase.isPSSysResourceNameDirty() && (bl || pSDELogicParamBase.getPSSysResourceName() != null)) {
            iDataObject.set(FIELD_PSSYSRESOURCENAME, (Object)pSDELogicParamBase.getPSSysResourceName());
        }
        if (pSDELogicParamBase.isPSSysSFPluginIdDirty() && (bl || pSDELogicParamBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSDELogicParamBase.getPSSysSFPluginId());
        }
        if (pSDELogicParamBase.isPSSysSFPluginNameDirty() && (bl || pSDELogicParamBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSDELogicParamBase.getPSSysSFPluginName());
        }
        if (pSDELogicParamBase.isPSSystemIdDirty() && (bl || pSDELogicParamBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSDELogicParamBase.getPSSystemId());
        }
        if (pSDELogicParamBase.isPSSysTranslatorIdDirty() && (bl || pSDELogicParamBase.getPSSysTranslatorId() != null)) {
            iDataObject.set(FIELD_PSSYSTRANSLATORID, (Object)pSDELogicParamBase.getPSSysTranslatorId());
        }
        if (pSDELogicParamBase.isPSSysTranslatorNameDirty() && (bl || pSDELogicParamBase.getPSSysTranslatorName() != null)) {
            iDataObject.set(FIELD_PSSYSTRANSLATORNAME, (Object)pSDELogicParamBase.getPSSysTranslatorName());
        }
        if (pSDELogicParamBase.isRefFieldNameDirty() && (bl || pSDELogicParamBase.getRefFieldName() != null)) {
            iDataObject.set(FIELD_REFFIELDNAME, (Object)pSDELogicParamBase.getRefFieldName());
        }
        if (pSDELogicParamBase.isRefParamNameDirty() && (bl || pSDELogicParamBase.getRefParamName() != null)) {
            iDataObject.set(FIELD_REFPARAMNAME, (Object)pSDELogicParamBase.getRefParamName());
        }
        if (pSDELogicParamBase.isStdDataTypeDirty() && (bl || pSDELogicParamBase.getStdDataType() != null)) {
            iDataObject.set(FIELD_STDDATATYPE, (Object)pSDELogicParamBase.getStdDataType());
        }
        if (pSDELogicParamBase.isUpdateDateDirty() && (bl || pSDELogicParamBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDELogicParamBase.getUpdateDate());
        }
        if (pSDELogicParamBase.isUpdateManDirty() && (bl || pSDELogicParamBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDELogicParamBase.getUpdateMan());
        }
        if (pSDELogicParamBase.isUserCatDirty() && (bl || pSDELogicParamBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDELogicParamBase.getUserCat());
        }
        if (pSDELogicParamBase.isUserParamsDirty() && (bl || pSDELogicParamBase.getUserParams() != null)) {
            iDataObject.set(FIELD_USERPARAMS, (Object)pSDELogicParamBase.getUserParams());
        }
        if (pSDELogicParamBase.isUserTagDirty() && (bl || pSDELogicParamBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDELogicParamBase.getUserTag());
        }
        if (pSDELogicParamBase.isUserTag2Dirty() && (bl || pSDELogicParamBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDELogicParamBase.getUserTag2());
        }
        if (pSDELogicParamBase.isUserTag3Dirty() && (bl || pSDELogicParamBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDELogicParamBase.getUserTag3());
        }
        if (pSDELogicParamBase.isUserTag4Dirty() && (bl || pSDELogicParamBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDELogicParamBase.getUserTag4());
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
        return PSDELogicParamBase.remove(this, n);
    }

    private static boolean remove(PSDELogicParamBase pSDELogicParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDELogicParamBase.resetCloneParamFlag();
                return true;
            }
            case 1: {
                pSDELogicParamBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDELogicParamBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDELogicParamBase.resetDefaultParam();
                return true;
            }
            case 4: {
                pSDELogicParamBase.resetDefaultValue();
                return true;
            }
            case 5: {
                pSDELogicParamBase.resetDefaultValueType();
                return true;
            }
            case 6: {
                pSDELogicParamBase.resetDynaModelFlag();
                return true;
            }
            case 7: {
                pSDELogicParamBase.resetFileType();
                return true;
            }
            case 8: {
                pSDELogicParamBase.resetFileUrl();
                return true;
            }
            case 9: {
                pSDELogicParamBase.resetGlobalParam();
                return true;
            }
            case 10: {
                pSDELogicParamBase.resetLogicName();
                return true;
            }
            case 11: {
                pSDELogicParamBase.resetMemo();
                return true;
            }
            case 12: {
                pSDELogicParamBase.resetOriginEntityFlag();
                return true;
            }
            case 13: {
                pSDELogicParamBase.resetParamPSDEFGroupId();
                return true;
            }
            case 14: {
                pSDELogicParamBase.resetParamPSDEFGroupName();
                return true;
            }
            case 15: {
                pSDELogicParamBase.resetParamPSDEId();
                return true;
            }
            case 16: {
                pSDELogicParamBase.resetParamPSDEName();
                return true;
            }
            case 17: {
                pSDELogicParamBase.resetParams();
                return true;
            }
            case 18: {
                pSDELogicParamBase.resetParamTag();
                return true;
            }
            case 19: {
                pSDELogicParamBase.resetParamTag2();
                return true;
            }
            case 20: {
                pSDELogicParamBase.resetPSDELogicId();
                return true;
            }
            case 21: {
                pSDELogicParamBase.resetPSDELogicName();
                return true;
            }
            case 22: {
                pSDELogicParamBase.resetPSDELogicParamId();
                return true;
            }
            case 23: {
                pSDELogicParamBase.resetPSDELogicParamName();
                return true;
            }
            case 24: {
                pSDELogicParamBase.resetPSDynaInstId();
                return true;
            }
            case 25: {
                pSDELogicParamBase.resetPSSysDynaModelId();
                return true;
            }
            case 26: {
                pSDELogicParamBase.resetPSSysDynaModelName();
                return true;
            }
            case 27: {
                pSDELogicParamBase.resetPSSysPFPluginId();
                return true;
            }
            case 28: {
                pSDELogicParamBase.resetPSSysPFPluginName();
                return true;
            }
            case 29: {
                pSDELogicParamBase.resetPSSysResourceId();
                return true;
            }
            case 30: {
                pSDELogicParamBase.resetPSSysResourceName();
                return true;
            }
            case 31: {
                pSDELogicParamBase.resetPSSysSFPluginId();
                return true;
            }
            case 32: {
                pSDELogicParamBase.resetPSSysSFPluginName();
                return true;
            }
            case 33: {
                pSDELogicParamBase.resetPSSystemId();
                return true;
            }
            case 34: {
                pSDELogicParamBase.resetPSSysTranslatorId();
                return true;
            }
            case 35: {
                pSDELogicParamBase.resetPSSysTranslatorName();
                return true;
            }
            case 36: {
                pSDELogicParamBase.resetRefFieldName();
                return true;
            }
            case 37: {
                pSDELogicParamBase.resetRefParamName();
                return true;
            }
            case 38: {
                pSDELogicParamBase.resetStdDataType();
                return true;
            }
            case 39: {
                pSDELogicParamBase.resetUpdateDate();
                return true;
            }
            case 40: {
                pSDELogicParamBase.resetUpdateMan();
                return true;
            }
            case 41: {
                pSDELogicParamBase.resetUserCat();
                return true;
            }
            case 42: {
                pSDELogicParamBase.resetUserParams();
                return true;
            }
            case 43: {
                pSDELogicParamBase.resetUserTag();
                return true;
            }
            case 44: {
                pSDELogicParamBase.resetUserTag2();
                return true;
            }
            case 45: {
                pSDELogicParamBase.resetUserTag3();
                return true;
            }
            case 46: {
                pSDELogicParamBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getParamPSDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParamPSDE();
        }
        if (this.getParamPSDEId() == null) {
            return null;
        }
        Integer n = this.objParamPSDELock;
        synchronized (n) {
            if (this.parampsde != null && DataTypeHelper.compare((int)25, (Object)this.getParamPSDEId(), (Object)this.parampsde.getPSDataEntityId()) != 0L) {
                this.parampsde = null;
            }
            if (this.parampsde == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getParamPSDEId());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet((IEntity)pSDataEntity);
                this.parampsde = pSDataEntity;
            }
            return this.parampsde;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEFGroup getParamPSDEFGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParamPSDEFGroup();
        }
        if (this.getParamPSDEFGroupId() == null) {
            return null;
        }
        Integer n = this.objParamPSDEFGroupLock;
        synchronized (n) {
            if (this.parampsdefgroup != null && DataTypeHelper.compare((int)25, (Object)this.getParamPSDEFGroupId(), (Object)this.parampsdefgroup.getPSDEFGroupId()) != 0L) {
                this.parampsdefgroup = null;
            }
            if (this.parampsdefgroup == null) {
                PSDEFGroup pSDEFGroup = new PSDEFGroup();
                pSDEFGroup.setPSDEFGroupId(this.getParamPSDEFGroupId());
                PSDEFGroupService pSDEFGroupService = (PSDEFGroupService)ServiceGlobal.getService(PSDEFGroupService.class, (SessionFactory)this.getSessionFactory());
                pSDEFGroupService.autoGet((IEntity)pSDEFGroup);
                this.parampsdefgroup = pSDEFGroup;
            }
            return this.parampsdefgroup;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDELogic getPSDELogic() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDELogic();
        }
        if (this.getPSDELogicId() == null) {
            return null;
        }
        Integer n = this.objPSDELogicLock;
        synchronized (n) {
            if (this.psdelogic != null && DataTypeHelper.compare((int)25, (Object)this.getPSDELogicId(), (Object)this.psdelogic.getPSDELogicId()) != 0L) {
                this.psdelogic = null;
            }
            if (this.psdelogic == null) {
                PSDELogic pSDELogic = new PSDELogic();
                pSDELogic.setPSDELogicId(this.getPSDELogicId());
                PSDELogicService pSDELogicService = (PSDELogicService)ServiceGlobal.getService(PSDELogicService.class, (SessionFactory)this.getSessionFactory());
                pSDELogicService.autoGet((IEntity)pSDELogic);
                this.psdelogic = pSDELogic;
            }
            return this.psdelogic;
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
    public PSSysPFPlugin getPSSysPFPlugin() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPFPlugin();
        }
        if (this.getPSSysPFPluginId() == null) {
            return null;
        }
        Integer n = this.objPSSysPFPluginLock;
        synchronized (n) {
            if (this.pssyspfplugin != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysPFPluginId(), (Object)this.pssyspfplugin.getPSSysPFPluginId()) != 0L) {
                this.pssyspfplugin = null;
            }
            if (this.pssyspfplugin == null) {
                PSSysPFPlugin pSSysPFPlugin = new PSSysPFPlugin();
                pSSysPFPlugin.setPSSysPFPluginId(this.getPSSysPFPluginId());
                PSSysPFPluginService pSSysPFPluginService = (PSSysPFPluginService)ServiceGlobal.getService(PSSysPFPluginService.class, (SessionFactory)this.getSessionFactory());
                pSSysPFPluginService.autoGet((IEntity)pSSysPFPlugin);
                this.pssyspfplugin = pSSysPFPlugin;
            }
            return this.pssyspfplugin;
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
    public PSSysTranslator getPSSysTranslator() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTranslator();
        }
        if (this.getPSSysTranslatorId() == null) {
            return null;
        }
        Integer n = this.objPSSysTranslatorLock;
        synchronized (n) {
            if (this.pssystranslator != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysTranslatorId(), (Object)this.pssystranslator.getPSSysTranslatorId()) != 0L) {
                this.pssystranslator = null;
            }
            if (this.pssystranslator == null) {
                PSSysTranslator pSSysTranslator = new PSSysTranslator();
                pSSysTranslator.setPSSysTranslatorId(this.getPSSysTranslatorId());
                PSSysTranslatorService pSSysTranslatorService = (PSSysTranslatorService)ServiceGlobal.getService(PSSysTranslatorService.class, (SessionFactory)this.getSessionFactory());
                pSSysTranslatorService.autoGet((IEntity)pSSysTranslator);
                this.pssystranslator = pSSysTranslator;
            }
            return this.pssystranslator;
        }
    }

    private PSDELogicParamBase getProxyEntity() {
        return this.proxyPSDELogicParamBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDELogicParamBase = null;
        if (iDataObject != null && iDataObject instanceof PSDELogicParamBase) {
            this.proxyPSDELogicParamBase = (PSDELogicParamBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELogicParamService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CLONEPARAMFLAG, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_DEFAULTPARAM, 3);
        fieldIndexMap.put(FIELD_DEFAULTVALUE, 4);
        fieldIndexMap.put(FIELD_DEFAULTVALUETYPE, 5);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 6);
        fieldIndexMap.put(FIELD_FILETYPE, 7);
        fieldIndexMap.put(FIELD_FILEURL, 8);
        fieldIndexMap.put(FIELD_GLOBALPARAM, 9);
        fieldIndexMap.put(FIELD_LOGICNAME, 10);
        fieldIndexMap.put(FIELD_MEMO, 11);
        fieldIndexMap.put(FIELD_ORIGINENTITYFLAG, 12);
        fieldIndexMap.put(FIELD_PARAMPSDEFGROUPID, 13);
        fieldIndexMap.put(FIELD_PARAMPSDEFGROUPNAME, 14);
        fieldIndexMap.put(FIELD_PARAMPSDEID, 15);
        fieldIndexMap.put(FIELD_PARAMPSDENAME, 16);
        fieldIndexMap.put(FIELD_PARAMS, 17);
        fieldIndexMap.put(FIELD_PARAMTAG, 18);
        fieldIndexMap.put(FIELD_PARAMTAG2, 19);
        fieldIndexMap.put(FIELD_PSDELOGICID, 20);
        fieldIndexMap.put(FIELD_PSDELOGICNAME, 21);
        fieldIndexMap.put(FIELD_PSDELOGICPARAMID, 22);
        fieldIndexMap.put(FIELD_PSDELOGICPARAMNAME, 23);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 24);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 25);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 26);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINID, 27);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINNAME, 28);
        fieldIndexMap.put(FIELD_PSSYSRESOURCEID, 29);
        fieldIndexMap.put(FIELD_PSSYSRESOURCENAME, 30);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 31);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 32);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 33);
        fieldIndexMap.put(FIELD_PSSYSTRANSLATORID, 34);
        fieldIndexMap.put(FIELD_PSSYSTRANSLATORNAME, 35);
        fieldIndexMap.put(FIELD_REFFIELDNAME, 36);
        fieldIndexMap.put(FIELD_REFPARAMNAME, 37);
        fieldIndexMap.put(FIELD_STDDATATYPE, 38);
        fieldIndexMap.put(FIELD_UPDATEDATE, 39);
        fieldIndexMap.put(FIELD_UPDATEMAN, 40);
        fieldIndexMap.put(FIELD_USERCAT, 41);
        fieldIndexMap.put(FIELD_USERPARAMS, 42);
        fieldIndexMap.put(FIELD_USERTAG, 43);
        fieldIndexMap.put(FIELD_USERTAG2, 44);
        fieldIndexMap.put(FIELD_USERTAG3, 45);
        fieldIndexMap.put(FIELD_USERTAG4, 46);
    }
}

