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
package net.ibizsys.pscore.srv.wfdesign.entity;

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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFProcess;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFProcessService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSWFProcParamBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSWFProcParamBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMDSTDEFNAME = "CUSTOMDSTDEFNAME";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEFID = "PSDEFID";
    public static final String FIELD_PSDEFNAME = "PSDEFNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSWFPROCESSID = "PSWFPROCESSID";
    public static final String FIELD_PSWFPROCESSNAME = "PSWFPROCESSNAME";
    public static final String FIELD_PSWFPROCPARAMID = "PSWFPROCPARAMID";
    public static final String FIELD_PSWFPROCPARAMNAME = "PSWFPROCPARAMNAME";
    public static final String FIELD_PSWFVERSIONID = "PSWFVERSIONID";
    public static final String FIELD_SRCVALUE = "SRCVALUE";
    public static final String FIELD_SRCVALUETYPE = "SRCVALUETYPE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERDATA = "USERDATA";
    public static final String FIELD_USERDATA2 = "USERDATA2";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_CUSTOMDSTDEFNAME = 2;
    private static final int INDEX_DYNAMODELFLAG = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PSDEFID = 5;
    private static final int INDEX_PSDEFNAME = 6;
    private static final int INDEX_PSDEID = 7;
    private static final int INDEX_PSDYNAINSTID = 8;
    private static final int INDEX_PSWFPROCESSID = 9;
    private static final int INDEX_PSWFPROCESSNAME = 10;
    private static final int INDEX_PSWFPROCPARAMID = 11;
    private static final int INDEX_PSWFPROCPARAMNAME = 12;
    private static final int INDEX_PSWFVERSIONID = 13;
    private static final int INDEX_SRCVALUE = 14;
    private static final int INDEX_SRCVALUETYPE = 15;
    private static final int INDEX_UPDATEDATE = 16;
    private static final int INDEX_UPDATEMAN = 17;
    private static final int INDEX_USERCAT = 18;
    private static final int INDEX_USERDATA = 19;
    private static final int INDEX_USERDATA2 = 20;
    private static final int INDEX_USERTAG = 21;
    private static final int INDEX_USERTAG2 = 22;
    private static final int INDEX_USERTAG3 = 23;
    private static final int INDEX_USERTAG4 = 24;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSWFProcParamBase proxyPSWFProcParamBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customdstdefnameDirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdefidDirtyFlag = false;
    private boolean psdefnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean pswfprocessidDirtyFlag = false;
    private boolean pswfprocessnameDirtyFlag = false;
    private boolean pswfprocparamidDirtyFlag = false;
    private boolean pswfprocparamnameDirtyFlag = false;
    private boolean pswfversionidDirtyFlag = false;
    private boolean srcvalueDirtyFlag = false;
    private boolean srcvaluetypeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean userdataDirtyFlag = false;
    private boolean userdata2DirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="customdstdefname")
    private String customdstdefname;
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="memo")
    private String memo;
    @Column(name="psdefid")
    private String psdefid;
    @Column(name="psdefname")
    private String psdefname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="pswfprocessid")
    private String pswfprocessid;
    @Column(name="pswfprocessname")
    private String pswfprocessname;
    @Column(name="pswfprocparamid")
    private String pswfprocparamid;
    @Column(name="pswfprocparamname")
    private String pswfprocparamname;
    @Column(name="pswfversionid")
    private String pswfversionid;
    @Column(name="srcvalue")
    private String srcvalue;
    @Column(name="srcvaluetype")
    private String srcvaluetype;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usercat")
    private String usercat;
    @Column(name="userdata")
    private String userdata;
    @Column(name="userdata2")
    private String userdata2;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="usertag3")
    private String usertag3;
    @Column(name="usertag4")
    private String usertag4;
    private Integer objPSDEFLock = new Integer(1);
    private PSDEField psdef = null;
    private Integer objPSWFProcessLock = new Integer(1);
    private PSWFProcess pswfprocess = null;

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

    public void setCustomDstDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomDstDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.customdstdefname = string;
        this.customdstdefnameDirtyFlag = true;
    }

    public String getCustomDstDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomDstDEFName();
        }
        return this.customdstdefname;
    }

    public boolean isCustomDstDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomDstDEFNameDirty();
        }
        return this.customdstdefnameDirtyFlag;
    }

    public void resetCustomDstDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomDstDEFName();
            return;
        }
        this.customdstdefnameDirtyFlag = false;
        this.customdstdefname = null;
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

    public void setPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefid = string;
        this.psdefidDirtyFlag = true;
    }

    public String getPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFId();
        }
        return this.psdefid;
    }

    public boolean isPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFIdDirty();
        }
        return this.psdefidDirtyFlag;
    }

    public void resetPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFId();
            return;
        }
        this.psdefidDirtyFlag = false;
        this.psdefid = null;
    }

    public void setPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefname = string;
        this.psdefnameDirtyFlag = true;
    }

    public String getPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFName();
        }
        return this.psdefname;
    }

    public boolean isPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFNameDirty();
        }
        return this.psdefnameDirtyFlag;
    }

    public void resetPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFName();
            return;
        }
        this.psdefnameDirtyFlag = false;
        this.psdefname = null;
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

    public void setPSWFProcessId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFProcessId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfprocessid = string;
        this.pswfprocessidDirtyFlag = true;
    }

    public String getPSWFProcessId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFProcessId();
        }
        return this.pswfprocessid;
    }

    public boolean isPSWFProcessIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFProcessIdDirty();
        }
        return this.pswfprocessidDirtyFlag;
    }

    public void resetPSWFProcessId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFProcessId();
            return;
        }
        this.pswfprocessidDirtyFlag = false;
        this.pswfprocessid = null;
    }

    public void setPSWFProcessName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFProcessName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfprocessname = string;
        this.pswfprocessnameDirtyFlag = true;
    }

    public String getPSWFProcessName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFProcessName();
        }
        return this.pswfprocessname;
    }

    public boolean isPSWFProcessNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFProcessNameDirty();
        }
        return this.pswfprocessnameDirtyFlag;
    }

    public void resetPSWFProcessName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFProcessName();
            return;
        }
        this.pswfprocessnameDirtyFlag = false;
        this.pswfprocessname = null;
    }

    public void setPSWFProcParamId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFProcParamId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfprocparamid = string;
        this.pswfprocparamidDirtyFlag = true;
    }

    public String getPSWFProcParamId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFProcParamId();
        }
        return this.pswfprocparamid;
    }

    public boolean isPSWFProcParamIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFProcParamIdDirty();
        }
        return this.pswfprocparamidDirtyFlag;
    }

    public void resetPSWFProcParamId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFProcParamId();
            return;
        }
        this.pswfprocparamidDirtyFlag = false;
        this.pswfprocparamid = null;
    }

    public void setPSWFProcParamName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFProcParamName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfprocparamname = string;
        this.pswfprocparamnameDirtyFlag = true;
    }

    public String getPSWFProcParamName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFProcParamName();
        }
        return this.pswfprocparamname;
    }

    public boolean isPSWFProcParamNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFProcParamNameDirty();
        }
        return this.pswfprocparamnameDirtyFlag;
    }

    public void resetPSWFProcParamName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFProcParamName();
            return;
        }
        this.pswfprocparamnameDirtyFlag = false;
        this.pswfprocparamname = null;
    }

    public void setPSWFVersionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFVersionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfversionid = string;
        this.pswfversionidDirtyFlag = true;
    }

    public String getPSWFVersionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFVersionId();
        }
        return this.pswfversionid;
    }

    public boolean isPSWFVersionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFVersionIdDirty();
        }
        return this.pswfversionidDirtyFlag;
    }

    public void resetPSWFVersionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFVersionId();
            return;
        }
        this.pswfversionidDirtyFlag = false;
        this.pswfversionid = null;
    }

    public void setSrcValue(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSrcValue(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.srcvalue = string;
        this.srcvalueDirtyFlag = true;
    }

    public String getSrcValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSrcValue();
        }
        return this.srcvalue;
    }

    public boolean isSrcValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSrcValueDirty();
        }
        return this.srcvalueDirtyFlag;
    }

    public void resetSrcValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSrcValue();
            return;
        }
        this.srcvalueDirtyFlag = false;
        this.srcvalue = null;
    }

    public void setSrcValueType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSrcValueType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.srcvaluetype = string;
        this.srcvaluetypeDirtyFlag = true;
    }

    public String getSrcValueType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSrcValueType();
        }
        return this.srcvaluetype;
    }

    public boolean isSrcValueTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSrcValueTypeDirty();
        }
        return this.srcvaluetypeDirtyFlag;
    }

    public void resetSrcValueType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSrcValueType();
            return;
        }
        this.srcvaluetypeDirtyFlag = false;
        this.srcvaluetype = null;
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

    public void setUserData(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserData(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userdata = string;
        this.userdataDirtyFlag = true;
    }

    public String getUserData() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserData();
        }
        return this.userdata;
    }

    public boolean isUserDataDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserDataDirty();
        }
        return this.userdataDirtyFlag;
    }

    public void resetUserData() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserData();
            return;
        }
        this.userdataDirtyFlag = false;
        this.userdata = null;
    }

    public void setUserData2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserData2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userdata2 = string;
        this.userdata2DirtyFlag = true;
    }

    public String getUserData2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserData2();
        }
        return this.userdata2;
    }

    public boolean isUserData2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserData2Dirty();
        }
        return this.userdata2DirtyFlag;
    }

    public void resetUserData2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserData2();
            return;
        }
        this.userdata2DirtyFlag = false;
        this.userdata2 = null;
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
        PSWFProcParamBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSWFProcParamBase pSWFProcParamBase) {
        pSWFProcParamBase.resetCreateDate();
        pSWFProcParamBase.resetCreateMan();
        pSWFProcParamBase.resetCustomDstDEFName();
        pSWFProcParamBase.resetDynaModelFlag();
        pSWFProcParamBase.resetMemo();
        pSWFProcParamBase.resetPSDEFId();
        pSWFProcParamBase.resetPSDEFName();
        pSWFProcParamBase.resetPSDEId();
        pSWFProcParamBase.resetPSDynaInstId();
        pSWFProcParamBase.resetPSWFProcessId();
        pSWFProcParamBase.resetPSWFProcessName();
        pSWFProcParamBase.resetPSWFProcParamId();
        pSWFProcParamBase.resetPSWFProcParamName();
        pSWFProcParamBase.resetPSWFVersionId();
        pSWFProcParamBase.resetSrcValue();
        pSWFProcParamBase.resetSrcValueType();
        pSWFProcParamBase.resetUpdateDate();
        pSWFProcParamBase.resetUpdateMan();
        pSWFProcParamBase.resetUserCat();
        pSWFProcParamBase.resetUserData();
        pSWFProcParamBase.resetUserData2();
        pSWFProcParamBase.resetUserTag();
        pSWFProcParamBase.resetUserTag2();
        pSWFProcParamBase.resetUserTag3();
        pSWFProcParamBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCustomDstDEFNameDirty()) {
            hashMap.put(FIELD_CUSTOMDSTDEFNAME, this.getCustomDstDEFName());
        }
        if (!bl || this.isDynaModelFlagDirty()) {
            hashMap.put(FIELD_DYNAMODELFLAG, this.getDynaModelFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDEFIdDirty()) {
            hashMap.put(FIELD_PSDEFID, this.getPSDEFId());
        }
        if (!bl || this.isPSDEFNameDirty()) {
            hashMap.put(FIELD_PSDEFNAME, this.getPSDEFName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSWFProcessIdDirty()) {
            hashMap.put(FIELD_PSWFPROCESSID, this.getPSWFProcessId());
        }
        if (!bl || this.isPSWFProcessNameDirty()) {
            hashMap.put(FIELD_PSWFPROCESSNAME, this.getPSWFProcessName());
        }
        if (!bl || this.isPSWFProcParamIdDirty()) {
            hashMap.put(FIELD_PSWFPROCPARAMID, this.getPSWFProcParamId());
        }
        if (!bl || this.isPSWFProcParamNameDirty()) {
            hashMap.put(FIELD_PSWFPROCPARAMNAME, this.getPSWFProcParamName());
        }
        if (!bl || this.isPSWFVersionIdDirty()) {
            hashMap.put(FIELD_PSWFVERSIONID, this.getPSWFVersionId());
        }
        if (!bl || this.isSrcValueDirty()) {
            hashMap.put(FIELD_SRCVALUE, this.getSrcValue());
        }
        if (!bl || this.isSrcValueTypeDirty()) {
            hashMap.put(FIELD_SRCVALUETYPE, this.getSrcValueType());
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
        if (!bl || this.isUserDataDirty()) {
            hashMap.put(FIELD_USERDATA, this.getUserData());
        }
        if (!bl || this.isUserData2Dirty()) {
            hashMap.put(FIELD_USERDATA2, this.getUserData2());
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
        return PSWFProcParamBase.get(this, n);
    }

    private static Object get(PSWFProcParamBase pSWFProcParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWFProcParamBase.getCreateDate();
            }
            case 1: {
                return pSWFProcParamBase.getCreateMan();
            }
            case 2: {
                return pSWFProcParamBase.getCustomDstDEFName();
            }
            case 3: {
                return pSWFProcParamBase.getDynaModelFlag();
            }
            case 4: {
                return pSWFProcParamBase.getMemo();
            }
            case 5: {
                return pSWFProcParamBase.getPSDEFId();
            }
            case 6: {
                return pSWFProcParamBase.getPSDEFName();
            }
            case 7: {
                return pSWFProcParamBase.getPSDEId();
            }
            case 8: {
                return pSWFProcParamBase.getPSDynaInstId();
            }
            case 9: {
                return pSWFProcParamBase.getPSWFProcessId();
            }
            case 10: {
                return pSWFProcParamBase.getPSWFProcessName();
            }
            case 11: {
                return pSWFProcParamBase.getPSWFProcParamId();
            }
            case 12: {
                return pSWFProcParamBase.getPSWFProcParamName();
            }
            case 13: {
                return pSWFProcParamBase.getPSWFVersionId();
            }
            case 14: {
                return pSWFProcParamBase.getSrcValue();
            }
            case 15: {
                return pSWFProcParamBase.getSrcValueType();
            }
            case 16: {
                return pSWFProcParamBase.getUpdateDate();
            }
            case 17: {
                return pSWFProcParamBase.getUpdateMan();
            }
            case 18: {
                return pSWFProcParamBase.getUserCat();
            }
            case 19: {
                return pSWFProcParamBase.getUserData();
            }
            case 20: {
                return pSWFProcParamBase.getUserData2();
            }
            case 21: {
                return pSWFProcParamBase.getUserTag();
            }
            case 22: {
                return pSWFProcParamBase.getUserTag2();
            }
            case 23: {
                return pSWFProcParamBase.getUserTag3();
            }
            case 24: {
                return pSWFProcParamBase.getUserTag4();
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
        PSWFProcParamBase.set(this, n, object);
    }

    private static void set(PSWFProcParamBase pSWFProcParamBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSWFProcParamBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSWFProcParamBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSWFProcParamBase.setCustomDstDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSWFProcParamBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSWFProcParamBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSWFProcParamBase.setPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSWFProcParamBase.setPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSWFProcParamBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSWFProcParamBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSWFProcParamBase.setPSWFProcessId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSWFProcParamBase.setPSWFProcessName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSWFProcParamBase.setPSWFProcParamId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSWFProcParamBase.setPSWFProcParamName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSWFProcParamBase.setPSWFVersionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSWFProcParamBase.setSrcValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSWFProcParamBase.setSrcValueType(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSWFProcParamBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 17: {
                pSWFProcParamBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSWFProcParamBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSWFProcParamBase.setUserData(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSWFProcParamBase.setUserData2(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSWFProcParamBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSWFProcParamBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSWFProcParamBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSWFProcParamBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSWFProcParamBase.isNull(this, n);
    }

    private static boolean isNull(PSWFProcParamBase pSWFProcParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWFProcParamBase.getCreateDate() == null;
            }
            case 1: {
                return pSWFProcParamBase.getCreateMan() == null;
            }
            case 2: {
                return pSWFProcParamBase.getCustomDstDEFName() == null;
            }
            case 3: {
                return pSWFProcParamBase.getDynaModelFlag() == null;
            }
            case 4: {
                return pSWFProcParamBase.getMemo() == null;
            }
            case 5: {
                return pSWFProcParamBase.getPSDEFId() == null;
            }
            case 6: {
                return pSWFProcParamBase.getPSDEFName() == null;
            }
            case 7: {
                return pSWFProcParamBase.getPSDEId() == null;
            }
            case 8: {
                return pSWFProcParamBase.getPSDynaInstId() == null;
            }
            case 9: {
                return pSWFProcParamBase.getPSWFProcessId() == null;
            }
            case 10: {
                return pSWFProcParamBase.getPSWFProcessName() == null;
            }
            case 11: {
                return pSWFProcParamBase.getPSWFProcParamId() == null;
            }
            case 12: {
                return pSWFProcParamBase.getPSWFProcParamName() == null;
            }
            case 13: {
                return pSWFProcParamBase.getPSWFVersionId() == null;
            }
            case 14: {
                return pSWFProcParamBase.getSrcValue() == null;
            }
            case 15: {
                return pSWFProcParamBase.getSrcValueType() == null;
            }
            case 16: {
                return pSWFProcParamBase.getUpdateDate() == null;
            }
            case 17: {
                return pSWFProcParamBase.getUpdateMan() == null;
            }
            case 18: {
                return pSWFProcParamBase.getUserCat() == null;
            }
            case 19: {
                return pSWFProcParamBase.getUserData() == null;
            }
            case 20: {
                return pSWFProcParamBase.getUserData2() == null;
            }
            case 21: {
                return pSWFProcParamBase.getUserTag() == null;
            }
            case 22: {
                return pSWFProcParamBase.getUserTag2() == null;
            }
            case 23: {
                return pSWFProcParamBase.getUserTag3() == null;
            }
            case 24: {
                return pSWFProcParamBase.getUserTag4() == null;
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
        return PSWFProcParamBase.contains(this, n);
    }

    private static boolean contains(PSWFProcParamBase pSWFProcParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWFProcParamBase.isCreateDateDirty();
            }
            case 1: {
                return pSWFProcParamBase.isCreateManDirty();
            }
            case 2: {
                return pSWFProcParamBase.isCustomDstDEFNameDirty();
            }
            case 3: {
                return pSWFProcParamBase.isDynaModelFlagDirty();
            }
            case 4: {
                return pSWFProcParamBase.isMemoDirty();
            }
            case 5: {
                return pSWFProcParamBase.isPSDEFIdDirty();
            }
            case 6: {
                return pSWFProcParamBase.isPSDEFNameDirty();
            }
            case 7: {
                return pSWFProcParamBase.isPSDEIdDirty();
            }
            case 8: {
                return pSWFProcParamBase.isPSDynaInstIdDirty();
            }
            case 9: {
                return pSWFProcParamBase.isPSWFProcessIdDirty();
            }
            case 10: {
                return pSWFProcParamBase.isPSWFProcessNameDirty();
            }
            case 11: {
                return pSWFProcParamBase.isPSWFProcParamIdDirty();
            }
            case 12: {
                return pSWFProcParamBase.isPSWFProcParamNameDirty();
            }
            case 13: {
                return pSWFProcParamBase.isPSWFVersionIdDirty();
            }
            case 14: {
                return pSWFProcParamBase.isSrcValueDirty();
            }
            case 15: {
                return pSWFProcParamBase.isSrcValueTypeDirty();
            }
            case 16: {
                return pSWFProcParamBase.isUpdateDateDirty();
            }
            case 17: {
                return pSWFProcParamBase.isUpdateManDirty();
            }
            case 18: {
                return pSWFProcParamBase.isUserCatDirty();
            }
            case 19: {
                return pSWFProcParamBase.isUserDataDirty();
            }
            case 20: {
                return pSWFProcParamBase.isUserData2Dirty();
            }
            case 21: {
                return pSWFProcParamBase.isUserTagDirty();
            }
            case 22: {
                return pSWFProcParamBase.isUserTag2Dirty();
            }
            case 23: {
                return pSWFProcParamBase.isUserTag3Dirty();
            }
            case 24: {
                return pSWFProcParamBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSWFProcParamBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSWFProcParamBase pSWFProcParamBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSWFProcParamBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSWFProcParamBase.getJSONValue((Object)pSWFProcParamBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSWFProcParamBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSWFProcParamBase.getJSONValue((Object)pSWFProcParamBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSWFProcParamBase.getCustomDstDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customdstdefname", (Object)PSWFProcParamBase.getJSONValue((Object)pSWFProcParamBase.getCustomDstDEFName()), (boolean)false);
        }
        if (bl || pSWFProcParamBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSWFProcParamBase.getJSONValue((Object)pSWFProcParamBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSWFProcParamBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSWFProcParamBase.getJSONValue((Object)pSWFProcParamBase.getMemo()), (boolean)false);
        }
        if (bl || pSWFProcParamBase.getPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefid", (Object)PSWFProcParamBase.getJSONValue((Object)pSWFProcParamBase.getPSDEFId()), (boolean)false);
        }
        if (bl || pSWFProcParamBase.getPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefname", (Object)PSWFProcParamBase.getJSONValue((Object)pSWFProcParamBase.getPSDEFName()), (boolean)false);
        }
        if (bl || pSWFProcParamBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSWFProcParamBase.getJSONValue((Object)pSWFProcParamBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSWFProcParamBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSWFProcParamBase.getJSONValue((Object)pSWFProcParamBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSWFProcParamBase.getPSWFProcessId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfprocessid", (Object)PSWFProcParamBase.getJSONValue((Object)pSWFProcParamBase.getPSWFProcessId()), (boolean)false);
        }
        if (bl || pSWFProcParamBase.getPSWFProcessName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfprocessname", (Object)PSWFProcParamBase.getJSONValue((Object)pSWFProcParamBase.getPSWFProcessName()), (boolean)false);
        }
        if (bl || pSWFProcParamBase.getPSWFProcParamId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfprocparamid", (Object)PSWFProcParamBase.getJSONValue((Object)pSWFProcParamBase.getPSWFProcParamId()), (boolean)false);
        }
        if (bl || pSWFProcParamBase.getPSWFProcParamName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfprocparamname", (Object)PSWFProcParamBase.getJSONValue((Object)pSWFProcParamBase.getPSWFProcParamName()), (boolean)false);
        }
        if (bl || pSWFProcParamBase.getPSWFVersionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfversionid", (Object)PSWFProcParamBase.getJSONValue((Object)pSWFProcParamBase.getPSWFVersionId()), (boolean)false);
        }
        if (bl || pSWFProcParamBase.getSrcValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srcvalue", (Object)PSWFProcParamBase.getJSONValue((Object)pSWFProcParamBase.getSrcValue()), (boolean)false);
        }
        if (bl || pSWFProcParamBase.getSrcValueType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srcvaluetype", (Object)PSWFProcParamBase.getJSONValue((Object)pSWFProcParamBase.getSrcValueType()), (boolean)false);
        }
        if (bl || pSWFProcParamBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSWFProcParamBase.getJSONValue((Object)pSWFProcParamBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSWFProcParamBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSWFProcParamBase.getJSONValue((Object)pSWFProcParamBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSWFProcParamBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSWFProcParamBase.getJSONValue((Object)pSWFProcParamBase.getUserCat()), (boolean)false);
        }
        if (bl || pSWFProcParamBase.getUserData() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userdata", (Object)PSWFProcParamBase.getJSONValue((Object)pSWFProcParamBase.getUserData()), (boolean)false);
        }
        if (bl || pSWFProcParamBase.getUserData2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userdata2", (Object)PSWFProcParamBase.getJSONValue((Object)pSWFProcParamBase.getUserData2()), (boolean)false);
        }
        if (bl || pSWFProcParamBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSWFProcParamBase.getJSONValue((Object)pSWFProcParamBase.getUserTag()), (boolean)false);
        }
        if (bl || pSWFProcParamBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSWFProcParamBase.getJSONValue((Object)pSWFProcParamBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSWFProcParamBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSWFProcParamBase.getJSONValue((Object)pSWFProcParamBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSWFProcParamBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSWFProcParamBase.getJSONValue((Object)pSWFProcParamBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSWFProcParamBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSWFProcParamBase pSWFProcParamBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSWFProcParamBase.getCreateDate() != null) {
            object = pSWFProcParamBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWFProcParamBase.getCreateMan() != null) {
            object = pSWFProcParamBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcParamBase.getCustomDstDEFName() != null) {
            object = pSWFProcParamBase.getCustomDstDEFName();
            xmlNode.setAttribute(FIELD_CUSTOMDSTDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcParamBase.getDynaModelFlag() != null) {
            object = pSWFProcParamBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWFProcParamBase.getMemo() != null) {
            object = pSWFProcParamBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcParamBase.getPSDEFId() != null) {
            object = pSWFProcParamBase.getPSDEFId();
            xmlNode.setAttribute(FIELD_PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcParamBase.getPSDEFName() != null) {
            object = pSWFProcParamBase.getPSDEFName();
            xmlNode.setAttribute(FIELD_PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcParamBase.getPSDEId() != null) {
            object = pSWFProcParamBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcParamBase.getPSDynaInstId() != null) {
            object = pSWFProcParamBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcParamBase.getPSWFProcessId() != null) {
            object = pSWFProcParamBase.getPSWFProcessId();
            xmlNode.setAttribute(FIELD_PSWFPROCESSID, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcParamBase.getPSWFProcessName() != null) {
            object = pSWFProcParamBase.getPSWFProcessName();
            xmlNode.setAttribute(FIELD_PSWFPROCESSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcParamBase.getPSWFProcParamId() != null) {
            object = pSWFProcParamBase.getPSWFProcParamId();
            xmlNode.setAttribute(FIELD_PSWFPROCPARAMID, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcParamBase.getPSWFProcParamName() != null) {
            object = pSWFProcParamBase.getPSWFProcParamName();
            xmlNode.setAttribute(FIELD_PSWFPROCPARAMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcParamBase.getPSWFVersionId() != null) {
            object = pSWFProcParamBase.getPSWFVersionId();
            xmlNode.setAttribute(FIELD_PSWFVERSIONID, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcParamBase.getSrcValue() != null) {
            object = pSWFProcParamBase.getSrcValue();
            xmlNode.setAttribute(FIELD_SRCVALUE, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcParamBase.getSrcValueType() != null) {
            object = pSWFProcParamBase.getSrcValueType();
            xmlNode.setAttribute(FIELD_SRCVALUETYPE, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcParamBase.getUpdateDate() != null) {
            object = pSWFProcParamBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWFProcParamBase.getUpdateMan() != null) {
            object = pSWFProcParamBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcParamBase.getUserCat() != null) {
            object = pSWFProcParamBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcParamBase.getUserData() != null) {
            object = pSWFProcParamBase.getUserData();
            xmlNode.setAttribute(FIELD_USERDATA, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcParamBase.getUserData2() != null) {
            object = pSWFProcParamBase.getUserData2();
            xmlNode.setAttribute(FIELD_USERDATA2, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcParamBase.getUserTag() != null) {
            object = pSWFProcParamBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcParamBase.getUserTag2() != null) {
            object = pSWFProcParamBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcParamBase.getUserTag3() != null) {
            object = pSWFProcParamBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcParamBase.getUserTag4() != null) {
            object = pSWFProcParamBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSWFProcParamBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSWFProcParamBase pSWFProcParamBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSWFProcParamBase.isCreateDateDirty() && (bl || pSWFProcParamBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSWFProcParamBase.getCreateDate());
        }
        if (pSWFProcParamBase.isCreateManDirty() && (bl || pSWFProcParamBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSWFProcParamBase.getCreateMan());
        }
        if (pSWFProcParamBase.isCustomDstDEFNameDirty() && (bl || pSWFProcParamBase.getCustomDstDEFName() != null)) {
            iDataObject.set(FIELD_CUSTOMDSTDEFNAME, (Object)pSWFProcParamBase.getCustomDstDEFName());
        }
        if (pSWFProcParamBase.isDynaModelFlagDirty() && (bl || pSWFProcParamBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSWFProcParamBase.getDynaModelFlag());
        }
        if (pSWFProcParamBase.isMemoDirty() && (bl || pSWFProcParamBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSWFProcParamBase.getMemo());
        }
        if (pSWFProcParamBase.isPSDEFIdDirty() && (bl || pSWFProcParamBase.getPSDEFId() != null)) {
            iDataObject.set(FIELD_PSDEFID, (Object)pSWFProcParamBase.getPSDEFId());
        }
        if (pSWFProcParamBase.isPSDEFNameDirty() && (bl || pSWFProcParamBase.getPSDEFName() != null)) {
            iDataObject.set(FIELD_PSDEFNAME, (Object)pSWFProcParamBase.getPSDEFName());
        }
        if (pSWFProcParamBase.isPSDEIdDirty() && (bl || pSWFProcParamBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSWFProcParamBase.getPSDEId());
        }
        if (pSWFProcParamBase.isPSDynaInstIdDirty() && (bl || pSWFProcParamBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSWFProcParamBase.getPSDynaInstId());
        }
        if (pSWFProcParamBase.isPSWFProcessIdDirty() && (bl || pSWFProcParamBase.getPSWFProcessId() != null)) {
            iDataObject.set(FIELD_PSWFPROCESSID, (Object)pSWFProcParamBase.getPSWFProcessId());
        }
        if (pSWFProcParamBase.isPSWFProcessNameDirty() && (bl || pSWFProcParamBase.getPSWFProcessName() != null)) {
            iDataObject.set(FIELD_PSWFPROCESSNAME, (Object)pSWFProcParamBase.getPSWFProcessName());
        }
        if (pSWFProcParamBase.isPSWFProcParamIdDirty() && (bl || pSWFProcParamBase.getPSWFProcParamId() != null)) {
            iDataObject.set(FIELD_PSWFPROCPARAMID, (Object)pSWFProcParamBase.getPSWFProcParamId());
        }
        if (pSWFProcParamBase.isPSWFProcParamNameDirty() && (bl || pSWFProcParamBase.getPSWFProcParamName() != null)) {
            iDataObject.set(FIELD_PSWFPROCPARAMNAME, (Object)pSWFProcParamBase.getPSWFProcParamName());
        }
        if (pSWFProcParamBase.isPSWFVersionIdDirty() && (bl || pSWFProcParamBase.getPSWFVersionId() != null)) {
            iDataObject.set(FIELD_PSWFVERSIONID, (Object)pSWFProcParamBase.getPSWFVersionId());
        }
        if (pSWFProcParamBase.isSrcValueDirty() && (bl || pSWFProcParamBase.getSrcValue() != null)) {
            iDataObject.set(FIELD_SRCVALUE, (Object)pSWFProcParamBase.getSrcValue());
        }
        if (pSWFProcParamBase.isSrcValueTypeDirty() && (bl || pSWFProcParamBase.getSrcValueType() != null)) {
            iDataObject.set(FIELD_SRCVALUETYPE, (Object)pSWFProcParamBase.getSrcValueType());
        }
        if (pSWFProcParamBase.isUpdateDateDirty() && (bl || pSWFProcParamBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSWFProcParamBase.getUpdateDate());
        }
        if (pSWFProcParamBase.isUpdateManDirty() && (bl || pSWFProcParamBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSWFProcParamBase.getUpdateMan());
        }
        if (pSWFProcParamBase.isUserCatDirty() && (bl || pSWFProcParamBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSWFProcParamBase.getUserCat());
        }
        if (pSWFProcParamBase.isUserDataDirty() && (bl || pSWFProcParamBase.getUserData() != null)) {
            iDataObject.set(FIELD_USERDATA, (Object)pSWFProcParamBase.getUserData());
        }
        if (pSWFProcParamBase.isUserData2Dirty() && (bl || pSWFProcParamBase.getUserData2() != null)) {
            iDataObject.set(FIELD_USERDATA2, (Object)pSWFProcParamBase.getUserData2());
        }
        if (pSWFProcParamBase.isUserTagDirty() && (bl || pSWFProcParamBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSWFProcParamBase.getUserTag());
        }
        if (pSWFProcParamBase.isUserTag2Dirty() && (bl || pSWFProcParamBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSWFProcParamBase.getUserTag2());
        }
        if (pSWFProcParamBase.isUserTag3Dirty() && (bl || pSWFProcParamBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSWFProcParamBase.getUserTag3());
        }
        if (pSWFProcParamBase.isUserTag4Dirty() && (bl || pSWFProcParamBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSWFProcParamBase.getUserTag4());
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
        return PSWFProcParamBase.remove(this, n);
    }

    private static boolean remove(PSWFProcParamBase pSWFProcParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSWFProcParamBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSWFProcParamBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSWFProcParamBase.resetCustomDstDEFName();
                return true;
            }
            case 3: {
                pSWFProcParamBase.resetDynaModelFlag();
                return true;
            }
            case 4: {
                pSWFProcParamBase.resetMemo();
                return true;
            }
            case 5: {
                pSWFProcParamBase.resetPSDEFId();
                return true;
            }
            case 6: {
                pSWFProcParamBase.resetPSDEFName();
                return true;
            }
            case 7: {
                pSWFProcParamBase.resetPSDEId();
                return true;
            }
            case 8: {
                pSWFProcParamBase.resetPSDynaInstId();
                return true;
            }
            case 9: {
                pSWFProcParamBase.resetPSWFProcessId();
                return true;
            }
            case 10: {
                pSWFProcParamBase.resetPSWFProcessName();
                return true;
            }
            case 11: {
                pSWFProcParamBase.resetPSWFProcParamId();
                return true;
            }
            case 12: {
                pSWFProcParamBase.resetPSWFProcParamName();
                return true;
            }
            case 13: {
                pSWFProcParamBase.resetPSWFVersionId();
                return true;
            }
            case 14: {
                pSWFProcParamBase.resetSrcValue();
                return true;
            }
            case 15: {
                pSWFProcParamBase.resetSrcValueType();
                return true;
            }
            case 16: {
                pSWFProcParamBase.resetUpdateDate();
                return true;
            }
            case 17: {
                pSWFProcParamBase.resetUpdateMan();
                return true;
            }
            case 18: {
                pSWFProcParamBase.resetUserCat();
                return true;
            }
            case 19: {
                pSWFProcParamBase.resetUserData();
                return true;
            }
            case 20: {
                pSWFProcParamBase.resetUserData2();
                return true;
            }
            case 21: {
                pSWFProcParamBase.resetUserTag();
                return true;
            }
            case 22: {
                pSWFProcParamBase.resetUserTag2();
                return true;
            }
            case 23: {
                pSWFProcParamBase.resetUserTag3();
                return true;
            }
            case 24: {
                pSWFProcParamBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEF();
        }
        if (this.getPSDEFId() == null) {
            return null;
        }
        Integer n = this.objPSDEFLock;
        synchronized (n) {
            if (this.psdef != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEFId(), (Object)this.psdef.getPSDEFieldId()) != 0L) {
                this.psdef = null;
            }
            if (this.psdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.psdef = pSDEField;
            }
            return this.psdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSWFProcess getPSWFProcess() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFProcess();
        }
        if (this.getPSWFProcessId() == null) {
            return null;
        }
        Integer n = this.objPSWFProcessLock;
        synchronized (n) {
            if (this.pswfprocess != null && DataTypeHelper.compare((int)25, (Object)this.getPSWFProcessId(), (Object)this.pswfprocess.getPSWFProcessId()) != 0L) {
                this.pswfprocess = null;
            }
            if (this.pswfprocess == null) {
                PSWFProcess pSWFProcess = new PSWFProcess();
                pSWFProcess.setPSWFProcessId(this.getPSWFProcessId());
                PSWFProcessService pSWFProcessService = (PSWFProcessService)ServiceGlobal.getService(PSWFProcessService.class, (SessionFactory)this.getSessionFactory());
                pSWFProcessService.autoGet(pSWFProcess);
                this.pswfprocess = pSWFProcess;
            }
            return this.pswfprocess;
        }
    }

    private PSWFProcParamBase getProxyEntity() {
        return this.proxyPSWFProcParamBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSWFProcParamBase = null;
        if (iDataObject != null && iDataObject instanceof PSWFProcParamBase) {
            this.proxyPSWFProcParamBase = (PSWFProcParamBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWFProcParamService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_CUSTOMDSTDEFNAME, 2);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PSDEFID, 5);
        fieldIndexMap.put(FIELD_PSDEFNAME, 6);
        fieldIndexMap.put(FIELD_PSDEID, 7);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 8);
        fieldIndexMap.put(FIELD_PSWFPROCESSID, 9);
        fieldIndexMap.put(FIELD_PSWFPROCESSNAME, 10);
        fieldIndexMap.put(FIELD_PSWFPROCPARAMID, 11);
        fieldIndexMap.put(FIELD_PSWFPROCPARAMNAME, 12);
        fieldIndexMap.put(FIELD_PSWFVERSIONID, 13);
        fieldIndexMap.put(FIELD_SRCVALUE, 14);
        fieldIndexMap.put(FIELD_SRCVALUETYPE, 15);
        fieldIndexMap.put(FIELD_UPDATEDATE, 16);
        fieldIndexMap.put(FIELD_UPDATEMAN, 17);
        fieldIndexMap.put(FIELD_USERCAT, 18);
        fieldIndexMap.put(FIELD_USERDATA, 19);
        fieldIndexMap.put(FIELD_USERDATA2, 20);
        fieldIndexMap.put(FIELD_USERTAG, 21);
        fieldIndexMap.put(FIELD_USERTAG2, 22);
        fieldIndexMap.put(FIELD_USERTAG3, 23);
        fieldIndexMap.put(FIELD_USERTAG4, 24);
    }
}

