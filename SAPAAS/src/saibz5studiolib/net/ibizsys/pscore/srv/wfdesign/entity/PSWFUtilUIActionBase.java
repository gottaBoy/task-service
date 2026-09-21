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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService;
import net.ibizsys.pscore.srv.wfdesign.entity.PSSysWFSetting;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFVersion;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWorkflow;
import net.ibizsys.pscore.srv.wfdesign.service.PSSysWFSettingService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFVersionService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWorkflowService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSWFUtilUIActionBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSWFUtilUIActionBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEUIACTIONID = "PSDEUIACTIONID";
    public static final String FIELD_PSDEUIACTIONNAME = "PSDEUIACTIONNAME";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSSYSWFSETTINGID = "PSSYSWFSETTINGID";
    public static final String FIELD_PSSYSWFSETTINGNAME = "PSSYSWFSETTINGNAME";
    public static final String FIELD_PSWFUTILUIACTIONID = "PSWFUTILUIACTIONID";
    public static final String FIELD_PSWFUTILUIACTIONNAME = "PSWFUTILUIACTIONNAME";
    public static final String FIELD_PSWFVERSIONID = "PSWFVERSIONID";
    public static final String FIELD_PSWFVERSIONNAME = "PSWFVERSIONNAME";
    public static final String FIELD_PSWORKFLOWID = "PSWORKFLOWID";
    public static final String FIELD_PSWORKFLOWNAME = "PSWORKFLOWNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_UTILTYPE = "UTILTYPE";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DYNAMODELFLAG = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSDEUIACTIONID = 4;
    private static final int INDEX_PSDEUIACTIONNAME = 5;
    private static final int INDEX_PSDYNAINSTID = 6;
    private static final int INDEX_PSSYSWFSETTINGID = 7;
    private static final int INDEX_PSSYSWFSETTINGNAME = 8;
    private static final int INDEX_PSWFUTILUIACTIONID = 9;
    private static final int INDEX_PSWFUTILUIACTIONNAME = 10;
    private static final int INDEX_PSWFVERSIONID = 11;
    private static final int INDEX_PSWFVERSIONNAME = 12;
    private static final int INDEX_PSWORKFLOWID = 13;
    private static final int INDEX_PSWORKFLOWNAME = 14;
    private static final int INDEX_UPDATEDATE = 15;
    private static final int INDEX_UPDATEMAN = 16;
    private static final int INDEX_UTILTYPE = 17;
    private static final int INDEX_VALIDFLAG = 18;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSWFUtilUIActionBase proxyPSWFUtilUIActionBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdeuiactionidDirtyFlag = false;
    private boolean psdeuiactionnameDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean pssyswfsettingidDirtyFlag = false;
    private boolean pssyswfsettingnameDirtyFlag = false;
    private boolean pswfutiluiactionidDirtyFlag = false;
    private boolean pswfutiluiactionnameDirtyFlag = false;
    private boolean pswfversionidDirtyFlag = false;
    private boolean pswfversionnameDirtyFlag = false;
    private boolean psworkflowidDirtyFlag = false;
    private boolean psworkflownameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean utiltypeDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="memo")
    private String memo;
    @Column(name="psdeuiactionid")
    private String psdeuiactionid;
    @Column(name="psdeuiactionname")
    private String psdeuiactionname;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="pssyswfsettingid")
    private String pssyswfsettingid;
    @Column(name="pssyswfsettingname")
    private String pssyswfsettingname;
    @Column(name="pswfutiluiactionid")
    private String pswfutiluiactionid;
    @Column(name="pswfutiluiactionname")
    private String pswfutiluiactionname;
    @Column(name="pswfversionid")
    private String pswfversionid;
    @Column(name="pswfversionname")
    private String pswfversionname;
    @Column(name="psworkflowid")
    private String psworkflowid;
    @Column(name="psworkflowname")
    private String psworkflowname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="utiltype")
    private String utiltype;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSDEUIActionLock = new Integer(1);
    private PSDEUIAction psdeuiaction = null;
    private Integer objPSSysWFSettingLock = new Integer(1);
    private PSSysWFSetting pssyswfsetting = null;
    private Integer objPSWFVersionLock = new Integer(1);
    private PSWFVersion pswfversion = null;
    private Integer objPSWorkflowLock = new Integer(1);
    private PSWorkflow psworkflow = null;

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

    public void setPSDEUIActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEUIActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeuiactionid = string;
        this.psdeuiactionidDirtyFlag = true;
    }

    public String getPSDEUIActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUIActionId();
        }
        return this.psdeuiactionid;
    }

    public boolean isPSDEUIActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEUIActionIdDirty();
        }
        return this.psdeuiactionidDirtyFlag;
    }

    public void resetPSDEUIActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEUIActionId();
            return;
        }
        this.psdeuiactionidDirtyFlag = false;
        this.psdeuiactionid = null;
    }

    public void setPSDEUIActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEUIActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeuiactionname = string;
        this.psdeuiactionnameDirtyFlag = true;
    }

    public String getPSDEUIActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUIActionName();
        }
        return this.psdeuiactionname;
    }

    public boolean isPSDEUIActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEUIActionNameDirty();
        }
        return this.psdeuiactionnameDirtyFlag;
    }

    public void resetPSDEUIActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEUIActionName();
            return;
        }
        this.psdeuiactionnameDirtyFlag = false;
        this.psdeuiactionname = null;
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

    public void setPSSysWFSettingId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysWFSettingId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyswfsettingid = string;
        this.pssyswfsettingidDirtyFlag = true;
    }

    public String getPSSysWFSettingId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysWFSettingId();
        }
        return this.pssyswfsettingid;
    }

    public boolean isPSSysWFSettingIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysWFSettingIdDirty();
        }
        return this.pssyswfsettingidDirtyFlag;
    }

    public void resetPSSysWFSettingId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysWFSettingId();
            return;
        }
        this.pssyswfsettingidDirtyFlag = false;
        this.pssyswfsettingid = null;
    }

    public void setPSSysWFSettingName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysWFSettingName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyswfsettingname = string;
        this.pssyswfsettingnameDirtyFlag = true;
    }

    public String getPSSysWFSettingName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysWFSettingName();
        }
        return this.pssyswfsettingname;
    }

    public boolean isPSSysWFSettingNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysWFSettingNameDirty();
        }
        return this.pssyswfsettingnameDirtyFlag;
    }

    public void resetPSSysWFSettingName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysWFSettingName();
            return;
        }
        this.pssyswfsettingnameDirtyFlag = false;
        this.pssyswfsettingname = null;
    }

    public void setPSWFUtilUIActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFUtilUIActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfutiluiactionid = string;
        this.pswfutiluiactionidDirtyFlag = true;
    }

    public String getPSWFUtilUIActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFUtilUIActionId();
        }
        return this.pswfutiluiactionid;
    }

    public boolean isPSWFUtilUIActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFUtilUIActionIdDirty();
        }
        return this.pswfutiluiactionidDirtyFlag;
    }

    public void resetPSWFUtilUIActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFUtilUIActionId();
            return;
        }
        this.pswfutiluiactionidDirtyFlag = false;
        this.pswfutiluiactionid = null;
    }

    public void setPSWFUtilUIActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFUtilUIActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfutiluiactionname = string;
        this.pswfutiluiactionnameDirtyFlag = true;
    }

    public String getPSWFUtilUIActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFUtilUIActionName();
        }
        return this.pswfutiluiactionname;
    }

    public boolean isPSWFUtilUIActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFUtilUIActionNameDirty();
        }
        return this.pswfutiluiactionnameDirtyFlag;
    }

    public void resetPSWFUtilUIActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFUtilUIActionName();
            return;
        }
        this.pswfutiluiactionnameDirtyFlag = false;
        this.pswfutiluiactionname = null;
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

    public void setPSWFVersionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFVersionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfversionname = string;
        this.pswfversionnameDirtyFlag = true;
    }

    public String getPSWFVersionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFVersionName();
        }
        return this.pswfversionname;
    }

    public boolean isPSWFVersionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFVersionNameDirty();
        }
        return this.pswfversionnameDirtyFlag;
    }

    public void resetPSWFVersionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFVersionName();
            return;
        }
        this.pswfversionnameDirtyFlag = false;
        this.pswfversionname = null;
    }

    public void setPSWorkflowId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWorkflowId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psworkflowid = string;
        this.psworkflowidDirtyFlag = true;
    }

    public String getPSWorkflowId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWorkflowId();
        }
        return this.psworkflowid;
    }

    public boolean isPSWorkflowIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWorkflowIdDirty();
        }
        return this.psworkflowidDirtyFlag;
    }

    public void resetPSWorkflowId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWorkflowId();
            return;
        }
        this.psworkflowidDirtyFlag = false;
        this.psworkflowid = null;
    }

    public void setPSWorkflowName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWorkflowName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psworkflowname = string;
        this.psworkflownameDirtyFlag = true;
    }

    public String getPSWorkflowName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWorkflowName();
        }
        return this.psworkflowname;
    }

    public boolean isPSWorkflowNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWorkflowNameDirty();
        }
        return this.psworkflownameDirtyFlag;
    }

    public void resetPSWorkflowName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWorkflowName();
            return;
        }
        this.psworkflownameDirtyFlag = false;
        this.psworkflowname = null;
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
        PSWFUtilUIActionBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSWFUtilUIActionBase pSWFUtilUIActionBase) {
        pSWFUtilUIActionBase.resetCreateDate();
        pSWFUtilUIActionBase.resetCreateMan();
        pSWFUtilUIActionBase.resetDynaModelFlag();
        pSWFUtilUIActionBase.resetMemo();
        pSWFUtilUIActionBase.resetPSDEUIActionId();
        pSWFUtilUIActionBase.resetPSDEUIActionName();
        pSWFUtilUIActionBase.resetPSDynaInstId();
        pSWFUtilUIActionBase.resetPSSysWFSettingId();
        pSWFUtilUIActionBase.resetPSSysWFSettingName();
        pSWFUtilUIActionBase.resetPSWFUtilUIActionId();
        pSWFUtilUIActionBase.resetPSWFUtilUIActionName();
        pSWFUtilUIActionBase.resetPSWFVersionId();
        pSWFUtilUIActionBase.resetPSWFVersionName();
        pSWFUtilUIActionBase.resetPSWorkflowId();
        pSWFUtilUIActionBase.resetPSWorkflowName();
        pSWFUtilUIActionBase.resetUpdateDate();
        pSWFUtilUIActionBase.resetUpdateMan();
        pSWFUtilUIActionBase.resetUtilType();
        pSWFUtilUIActionBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDynaModelFlagDirty()) {
            hashMap.put(FIELD_DYNAMODELFLAG, this.getDynaModelFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDEUIActionIdDirty()) {
            hashMap.put(FIELD_PSDEUIACTIONID, this.getPSDEUIActionId());
        }
        if (!bl || this.isPSDEUIActionNameDirty()) {
            hashMap.put(FIELD_PSDEUIACTIONNAME, this.getPSDEUIActionName());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSSysWFSettingIdDirty()) {
            hashMap.put(FIELD_PSSYSWFSETTINGID, this.getPSSysWFSettingId());
        }
        if (!bl || this.isPSSysWFSettingNameDirty()) {
            hashMap.put(FIELD_PSSYSWFSETTINGNAME, this.getPSSysWFSettingName());
        }
        if (!bl || this.isPSWFUtilUIActionIdDirty()) {
            hashMap.put(FIELD_PSWFUTILUIACTIONID, this.getPSWFUtilUIActionId());
        }
        if (!bl || this.isPSWFUtilUIActionNameDirty()) {
            hashMap.put(FIELD_PSWFUTILUIACTIONNAME, this.getPSWFUtilUIActionName());
        }
        if (!bl || this.isPSWFVersionIdDirty()) {
            hashMap.put(FIELD_PSWFVERSIONID, this.getPSWFVersionId());
        }
        if (!bl || this.isPSWFVersionNameDirty()) {
            hashMap.put(FIELD_PSWFVERSIONNAME, this.getPSWFVersionName());
        }
        if (!bl || this.isPSWorkflowIdDirty()) {
            hashMap.put(FIELD_PSWORKFLOWID, this.getPSWorkflowId());
        }
        if (!bl || this.isPSWorkflowNameDirty()) {
            hashMap.put(FIELD_PSWORKFLOWNAME, this.getPSWorkflowName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUtilTypeDirty()) {
            hashMap.put(FIELD_UTILTYPE, this.getUtilType());
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
        return PSWFUtilUIActionBase.get(this, n);
    }

    private static Object get(PSWFUtilUIActionBase pSWFUtilUIActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWFUtilUIActionBase.getCreateDate();
            }
            case 1: {
                return pSWFUtilUIActionBase.getCreateMan();
            }
            case 2: {
                return pSWFUtilUIActionBase.getDynaModelFlag();
            }
            case 3: {
                return pSWFUtilUIActionBase.getMemo();
            }
            case 4: {
                return pSWFUtilUIActionBase.getPSDEUIActionId();
            }
            case 5: {
                return pSWFUtilUIActionBase.getPSDEUIActionName();
            }
            case 6: {
                return pSWFUtilUIActionBase.getPSDynaInstId();
            }
            case 7: {
                return pSWFUtilUIActionBase.getPSSysWFSettingId();
            }
            case 8: {
                return pSWFUtilUIActionBase.getPSSysWFSettingName();
            }
            case 9: {
                return pSWFUtilUIActionBase.getPSWFUtilUIActionId();
            }
            case 10: {
                return pSWFUtilUIActionBase.getPSWFUtilUIActionName();
            }
            case 11: {
                return pSWFUtilUIActionBase.getPSWFVersionId();
            }
            case 12: {
                return pSWFUtilUIActionBase.getPSWFVersionName();
            }
            case 13: {
                return pSWFUtilUIActionBase.getPSWorkflowId();
            }
            case 14: {
                return pSWFUtilUIActionBase.getPSWorkflowName();
            }
            case 15: {
                return pSWFUtilUIActionBase.getUpdateDate();
            }
            case 16: {
                return pSWFUtilUIActionBase.getUpdateMan();
            }
            case 17: {
                return pSWFUtilUIActionBase.getUtilType();
            }
            case 18: {
                return pSWFUtilUIActionBase.getValidFlag();
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
        PSWFUtilUIActionBase.set(this, n, object);
    }

    private static void set(PSWFUtilUIActionBase pSWFUtilUIActionBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSWFUtilUIActionBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSWFUtilUIActionBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSWFUtilUIActionBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSWFUtilUIActionBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSWFUtilUIActionBase.setPSDEUIActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSWFUtilUIActionBase.setPSDEUIActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSWFUtilUIActionBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSWFUtilUIActionBase.setPSSysWFSettingId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSWFUtilUIActionBase.setPSSysWFSettingName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSWFUtilUIActionBase.setPSWFUtilUIActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSWFUtilUIActionBase.setPSWFUtilUIActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSWFUtilUIActionBase.setPSWFVersionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSWFUtilUIActionBase.setPSWFVersionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSWFUtilUIActionBase.setPSWorkflowId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSWFUtilUIActionBase.setPSWorkflowName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSWFUtilUIActionBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 16: {
                pSWFUtilUIActionBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSWFUtilUIActionBase.setUtilType(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSWFUtilUIActionBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSWFUtilUIActionBase.isNull(this, n);
    }

    private static boolean isNull(PSWFUtilUIActionBase pSWFUtilUIActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWFUtilUIActionBase.getCreateDate() == null;
            }
            case 1: {
                return pSWFUtilUIActionBase.getCreateMan() == null;
            }
            case 2: {
                return pSWFUtilUIActionBase.getDynaModelFlag() == null;
            }
            case 3: {
                return pSWFUtilUIActionBase.getMemo() == null;
            }
            case 4: {
                return pSWFUtilUIActionBase.getPSDEUIActionId() == null;
            }
            case 5: {
                return pSWFUtilUIActionBase.getPSDEUIActionName() == null;
            }
            case 6: {
                return pSWFUtilUIActionBase.getPSDynaInstId() == null;
            }
            case 7: {
                return pSWFUtilUIActionBase.getPSSysWFSettingId() == null;
            }
            case 8: {
                return pSWFUtilUIActionBase.getPSSysWFSettingName() == null;
            }
            case 9: {
                return pSWFUtilUIActionBase.getPSWFUtilUIActionId() == null;
            }
            case 10: {
                return pSWFUtilUIActionBase.getPSWFUtilUIActionName() == null;
            }
            case 11: {
                return pSWFUtilUIActionBase.getPSWFVersionId() == null;
            }
            case 12: {
                return pSWFUtilUIActionBase.getPSWFVersionName() == null;
            }
            case 13: {
                return pSWFUtilUIActionBase.getPSWorkflowId() == null;
            }
            case 14: {
                return pSWFUtilUIActionBase.getPSWorkflowName() == null;
            }
            case 15: {
                return pSWFUtilUIActionBase.getUpdateDate() == null;
            }
            case 16: {
                return pSWFUtilUIActionBase.getUpdateMan() == null;
            }
            case 17: {
                return pSWFUtilUIActionBase.getUtilType() == null;
            }
            case 18: {
                return pSWFUtilUIActionBase.getValidFlag() == null;
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
        return PSWFUtilUIActionBase.contains(this, n);
    }

    private static boolean contains(PSWFUtilUIActionBase pSWFUtilUIActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWFUtilUIActionBase.isCreateDateDirty();
            }
            case 1: {
                return pSWFUtilUIActionBase.isCreateManDirty();
            }
            case 2: {
                return pSWFUtilUIActionBase.isDynaModelFlagDirty();
            }
            case 3: {
                return pSWFUtilUIActionBase.isMemoDirty();
            }
            case 4: {
                return pSWFUtilUIActionBase.isPSDEUIActionIdDirty();
            }
            case 5: {
                return pSWFUtilUIActionBase.isPSDEUIActionNameDirty();
            }
            case 6: {
                return pSWFUtilUIActionBase.isPSDynaInstIdDirty();
            }
            case 7: {
                return pSWFUtilUIActionBase.isPSSysWFSettingIdDirty();
            }
            case 8: {
                return pSWFUtilUIActionBase.isPSSysWFSettingNameDirty();
            }
            case 9: {
                return pSWFUtilUIActionBase.isPSWFUtilUIActionIdDirty();
            }
            case 10: {
                return pSWFUtilUIActionBase.isPSWFUtilUIActionNameDirty();
            }
            case 11: {
                return pSWFUtilUIActionBase.isPSWFVersionIdDirty();
            }
            case 12: {
                return pSWFUtilUIActionBase.isPSWFVersionNameDirty();
            }
            case 13: {
                return pSWFUtilUIActionBase.isPSWorkflowIdDirty();
            }
            case 14: {
                return pSWFUtilUIActionBase.isPSWorkflowNameDirty();
            }
            case 15: {
                return pSWFUtilUIActionBase.isUpdateDateDirty();
            }
            case 16: {
                return pSWFUtilUIActionBase.isUpdateManDirty();
            }
            case 17: {
                return pSWFUtilUIActionBase.isUtilTypeDirty();
            }
            case 18: {
                return pSWFUtilUIActionBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSWFUtilUIActionBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSWFUtilUIActionBase pSWFUtilUIActionBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSWFUtilUIActionBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSWFUtilUIActionBase.getJSONValue((Object)pSWFUtilUIActionBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSWFUtilUIActionBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSWFUtilUIActionBase.getJSONValue((Object)pSWFUtilUIActionBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSWFUtilUIActionBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSWFUtilUIActionBase.getJSONValue((Object)pSWFUtilUIActionBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSWFUtilUIActionBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSWFUtilUIActionBase.getJSONValue((Object)pSWFUtilUIActionBase.getMemo()), (boolean)false);
        }
        if (bl || pSWFUtilUIActionBase.getPSDEUIActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuiactionid", (Object)PSWFUtilUIActionBase.getJSONValue((Object)pSWFUtilUIActionBase.getPSDEUIActionId()), (boolean)false);
        }
        if (bl || pSWFUtilUIActionBase.getPSDEUIActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuiactionname", (Object)PSWFUtilUIActionBase.getJSONValue((Object)pSWFUtilUIActionBase.getPSDEUIActionName()), (boolean)false);
        }
        if (bl || pSWFUtilUIActionBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSWFUtilUIActionBase.getJSONValue((Object)pSWFUtilUIActionBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSWFUtilUIActionBase.getPSSysWFSettingId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyswfsettingid", (Object)PSWFUtilUIActionBase.getJSONValue((Object)pSWFUtilUIActionBase.getPSSysWFSettingId()), (boolean)false);
        }
        if (bl || pSWFUtilUIActionBase.getPSSysWFSettingName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyswfsettingname", (Object)PSWFUtilUIActionBase.getJSONValue((Object)pSWFUtilUIActionBase.getPSSysWFSettingName()), (boolean)false);
        }
        if (bl || pSWFUtilUIActionBase.getPSWFUtilUIActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfutiluiactionid", (Object)PSWFUtilUIActionBase.getJSONValue((Object)pSWFUtilUIActionBase.getPSWFUtilUIActionId()), (boolean)false);
        }
        if (bl || pSWFUtilUIActionBase.getPSWFUtilUIActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfutiluiactionname", (Object)PSWFUtilUIActionBase.getJSONValue((Object)pSWFUtilUIActionBase.getPSWFUtilUIActionName()), (boolean)false);
        }
        if (bl || pSWFUtilUIActionBase.getPSWFVersionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfversionid", (Object)PSWFUtilUIActionBase.getJSONValue((Object)pSWFUtilUIActionBase.getPSWFVersionId()), (boolean)false);
        }
        if (bl || pSWFUtilUIActionBase.getPSWFVersionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfversionname", (Object)PSWFUtilUIActionBase.getJSONValue((Object)pSWFUtilUIActionBase.getPSWFVersionName()), (boolean)false);
        }
        if (bl || pSWFUtilUIActionBase.getPSWorkflowId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psworkflowid", (Object)PSWFUtilUIActionBase.getJSONValue((Object)pSWFUtilUIActionBase.getPSWorkflowId()), (boolean)false);
        }
        if (bl || pSWFUtilUIActionBase.getPSWorkflowName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psworkflowname", (Object)PSWFUtilUIActionBase.getJSONValue((Object)pSWFUtilUIActionBase.getPSWorkflowName()), (boolean)false);
        }
        if (bl || pSWFUtilUIActionBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSWFUtilUIActionBase.getJSONValue((Object)pSWFUtilUIActionBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSWFUtilUIActionBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSWFUtilUIActionBase.getJSONValue((Object)pSWFUtilUIActionBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSWFUtilUIActionBase.getUtilType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utiltype", (Object)PSWFUtilUIActionBase.getJSONValue((Object)pSWFUtilUIActionBase.getUtilType()), (boolean)false);
        }
        if (bl || pSWFUtilUIActionBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSWFUtilUIActionBase.getJSONValue((Object)pSWFUtilUIActionBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSWFUtilUIActionBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSWFUtilUIActionBase pSWFUtilUIActionBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSWFUtilUIActionBase.getCreateDate() != null) {
            object = pSWFUtilUIActionBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWFUtilUIActionBase.getCreateMan() != null) {
            object = pSWFUtilUIActionBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSWFUtilUIActionBase.getDynaModelFlag() != null) {
            object = pSWFUtilUIActionBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWFUtilUIActionBase.getMemo() != null) {
            object = pSWFUtilUIActionBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSWFUtilUIActionBase.getPSDEUIActionId() != null) {
            object = pSWFUtilUIActionBase.getPSDEUIActionId();
            xmlNode.setAttribute(FIELD_PSDEUIACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSWFUtilUIActionBase.getPSDEUIActionName() != null) {
            object = pSWFUtilUIActionBase.getPSDEUIActionName();
            xmlNode.setAttribute(FIELD_PSDEUIACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFUtilUIActionBase.getPSDynaInstId() != null) {
            object = pSWFUtilUIActionBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSWFUtilUIActionBase.getPSSysWFSettingId() != null) {
            object = pSWFUtilUIActionBase.getPSSysWFSettingId();
            xmlNode.setAttribute(FIELD_PSSYSWFSETTINGID, object == null ? "" : (String)object);
        }
        if (bl || pSWFUtilUIActionBase.getPSSysWFSettingName() != null) {
            object = pSWFUtilUIActionBase.getPSSysWFSettingName();
            xmlNode.setAttribute(FIELD_PSSYSWFSETTINGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFUtilUIActionBase.getPSWFUtilUIActionId() != null) {
            object = pSWFUtilUIActionBase.getPSWFUtilUIActionId();
            xmlNode.setAttribute(FIELD_PSWFUTILUIACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSWFUtilUIActionBase.getPSWFUtilUIActionName() != null) {
            object = pSWFUtilUIActionBase.getPSWFUtilUIActionName();
            xmlNode.setAttribute(FIELD_PSWFUTILUIACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFUtilUIActionBase.getPSWFVersionId() != null) {
            object = pSWFUtilUIActionBase.getPSWFVersionId();
            xmlNode.setAttribute(FIELD_PSWFVERSIONID, object == null ? "" : (String)object);
        }
        if (bl || pSWFUtilUIActionBase.getPSWFVersionName() != null) {
            object = pSWFUtilUIActionBase.getPSWFVersionName();
            xmlNode.setAttribute(FIELD_PSWFVERSIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFUtilUIActionBase.getPSWorkflowId() != null) {
            object = pSWFUtilUIActionBase.getPSWorkflowId();
            xmlNode.setAttribute(FIELD_PSWORKFLOWID, object == null ? "" : (String)object);
        }
        if (bl || pSWFUtilUIActionBase.getPSWorkflowName() != null) {
            object = pSWFUtilUIActionBase.getPSWorkflowName();
            xmlNode.setAttribute(FIELD_PSWORKFLOWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFUtilUIActionBase.getUpdateDate() != null) {
            object = pSWFUtilUIActionBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWFUtilUIActionBase.getUpdateMan() != null) {
            object = pSWFUtilUIActionBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSWFUtilUIActionBase.getUtilType() != null) {
            object = pSWFUtilUIActionBase.getUtilType();
            xmlNode.setAttribute(FIELD_UTILTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSWFUtilUIActionBase.getValidFlag() != null) {
            object = pSWFUtilUIActionBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSWFUtilUIActionBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSWFUtilUIActionBase pSWFUtilUIActionBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSWFUtilUIActionBase.isCreateDateDirty() && (bl || pSWFUtilUIActionBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSWFUtilUIActionBase.getCreateDate());
        }
        if (pSWFUtilUIActionBase.isCreateManDirty() && (bl || pSWFUtilUIActionBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSWFUtilUIActionBase.getCreateMan());
        }
        if (pSWFUtilUIActionBase.isDynaModelFlagDirty() && (bl || pSWFUtilUIActionBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSWFUtilUIActionBase.getDynaModelFlag());
        }
        if (pSWFUtilUIActionBase.isMemoDirty() && (bl || pSWFUtilUIActionBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSWFUtilUIActionBase.getMemo());
        }
        if (pSWFUtilUIActionBase.isPSDEUIActionIdDirty() && (bl || pSWFUtilUIActionBase.getPSDEUIActionId() != null)) {
            iDataObject.set(FIELD_PSDEUIACTIONID, (Object)pSWFUtilUIActionBase.getPSDEUIActionId());
        }
        if (pSWFUtilUIActionBase.isPSDEUIActionNameDirty() && (bl || pSWFUtilUIActionBase.getPSDEUIActionName() != null)) {
            iDataObject.set(FIELD_PSDEUIACTIONNAME, (Object)pSWFUtilUIActionBase.getPSDEUIActionName());
        }
        if (pSWFUtilUIActionBase.isPSDynaInstIdDirty() && (bl || pSWFUtilUIActionBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSWFUtilUIActionBase.getPSDynaInstId());
        }
        if (pSWFUtilUIActionBase.isPSSysWFSettingIdDirty() && (bl || pSWFUtilUIActionBase.getPSSysWFSettingId() != null)) {
            iDataObject.set(FIELD_PSSYSWFSETTINGID, (Object)pSWFUtilUIActionBase.getPSSysWFSettingId());
        }
        if (pSWFUtilUIActionBase.isPSSysWFSettingNameDirty() && (bl || pSWFUtilUIActionBase.getPSSysWFSettingName() != null)) {
            iDataObject.set(FIELD_PSSYSWFSETTINGNAME, (Object)pSWFUtilUIActionBase.getPSSysWFSettingName());
        }
        if (pSWFUtilUIActionBase.isPSWFUtilUIActionIdDirty() && (bl || pSWFUtilUIActionBase.getPSWFUtilUIActionId() != null)) {
            iDataObject.set(FIELD_PSWFUTILUIACTIONID, (Object)pSWFUtilUIActionBase.getPSWFUtilUIActionId());
        }
        if (pSWFUtilUIActionBase.isPSWFUtilUIActionNameDirty() && (bl || pSWFUtilUIActionBase.getPSWFUtilUIActionName() != null)) {
            iDataObject.set(FIELD_PSWFUTILUIACTIONNAME, (Object)pSWFUtilUIActionBase.getPSWFUtilUIActionName());
        }
        if (pSWFUtilUIActionBase.isPSWFVersionIdDirty() && (bl || pSWFUtilUIActionBase.getPSWFVersionId() != null)) {
            iDataObject.set(FIELD_PSWFVERSIONID, (Object)pSWFUtilUIActionBase.getPSWFVersionId());
        }
        if (pSWFUtilUIActionBase.isPSWFVersionNameDirty() && (bl || pSWFUtilUIActionBase.getPSWFVersionName() != null)) {
            iDataObject.set(FIELD_PSWFVERSIONNAME, (Object)pSWFUtilUIActionBase.getPSWFVersionName());
        }
        if (pSWFUtilUIActionBase.isPSWorkflowIdDirty() && (bl || pSWFUtilUIActionBase.getPSWorkflowId() != null)) {
            iDataObject.set(FIELD_PSWORKFLOWID, (Object)pSWFUtilUIActionBase.getPSWorkflowId());
        }
        if (pSWFUtilUIActionBase.isPSWorkflowNameDirty() && (bl || pSWFUtilUIActionBase.getPSWorkflowName() != null)) {
            iDataObject.set(FIELD_PSWORKFLOWNAME, (Object)pSWFUtilUIActionBase.getPSWorkflowName());
        }
        if (pSWFUtilUIActionBase.isUpdateDateDirty() && (bl || pSWFUtilUIActionBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSWFUtilUIActionBase.getUpdateDate());
        }
        if (pSWFUtilUIActionBase.isUpdateManDirty() && (bl || pSWFUtilUIActionBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSWFUtilUIActionBase.getUpdateMan());
        }
        if (pSWFUtilUIActionBase.isUtilTypeDirty() && (bl || pSWFUtilUIActionBase.getUtilType() != null)) {
            iDataObject.set(FIELD_UTILTYPE, (Object)pSWFUtilUIActionBase.getUtilType());
        }
        if (pSWFUtilUIActionBase.isValidFlagDirty() && (bl || pSWFUtilUIActionBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSWFUtilUIActionBase.getValidFlag());
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
        return PSWFUtilUIActionBase.remove(this, n);
    }

    private static boolean remove(PSWFUtilUIActionBase pSWFUtilUIActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSWFUtilUIActionBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSWFUtilUIActionBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSWFUtilUIActionBase.resetDynaModelFlag();
                return true;
            }
            case 3: {
                pSWFUtilUIActionBase.resetMemo();
                return true;
            }
            case 4: {
                pSWFUtilUIActionBase.resetPSDEUIActionId();
                return true;
            }
            case 5: {
                pSWFUtilUIActionBase.resetPSDEUIActionName();
                return true;
            }
            case 6: {
                pSWFUtilUIActionBase.resetPSDynaInstId();
                return true;
            }
            case 7: {
                pSWFUtilUIActionBase.resetPSSysWFSettingId();
                return true;
            }
            case 8: {
                pSWFUtilUIActionBase.resetPSSysWFSettingName();
                return true;
            }
            case 9: {
                pSWFUtilUIActionBase.resetPSWFUtilUIActionId();
                return true;
            }
            case 10: {
                pSWFUtilUIActionBase.resetPSWFUtilUIActionName();
                return true;
            }
            case 11: {
                pSWFUtilUIActionBase.resetPSWFVersionId();
                return true;
            }
            case 12: {
                pSWFUtilUIActionBase.resetPSWFVersionName();
                return true;
            }
            case 13: {
                pSWFUtilUIActionBase.resetPSWorkflowId();
                return true;
            }
            case 14: {
                pSWFUtilUIActionBase.resetPSWorkflowName();
                return true;
            }
            case 15: {
                pSWFUtilUIActionBase.resetUpdateDate();
                return true;
            }
            case 16: {
                pSWFUtilUIActionBase.resetUpdateMan();
                return true;
            }
            case 17: {
                pSWFUtilUIActionBase.resetUtilType();
                return true;
            }
            case 18: {
                pSWFUtilUIActionBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEUIAction getPSDEUIAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUIAction();
        }
        if (this.getPSDEUIActionId() == null) {
            return null;
        }
        Integer n = this.objPSDEUIActionLock;
        synchronized (n) {
            if (this.psdeuiaction != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEUIActionId(), (Object)this.psdeuiaction.getPSDEUIActionId()) != 0L) {
                this.psdeuiaction = null;
            }
            if (this.psdeuiaction == null) {
                PSDEUIAction pSDEUIAction = new PSDEUIAction();
                pSDEUIAction.setPSDEUIActionId(this.getPSDEUIActionId());
                PSDEUIActionService pSDEUIActionService = (PSDEUIActionService)ServiceGlobal.getService(PSDEUIActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEUIActionService.autoGet((IEntity)pSDEUIAction);
                this.psdeuiaction = pSDEUIAction;
            }
            return this.psdeuiaction;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysWFSetting getPSSysWFSetting() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysWFSetting();
        }
        if (this.getPSSysWFSettingId() == null) {
            return null;
        }
        Integer n = this.objPSSysWFSettingLock;
        synchronized (n) {
            if (this.pssyswfsetting != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysWFSettingId(), (Object)this.pssyswfsetting.getPSSysWFSettingId()) != 0L) {
                this.pssyswfsetting = null;
            }
            if (this.pssyswfsetting == null) {
                PSSysWFSetting pSSysWFSetting = new PSSysWFSetting();
                pSSysWFSetting.setPSSysWFSettingId(this.getPSSysWFSettingId());
                PSSysWFSettingService pSSysWFSettingService = (PSSysWFSettingService)ServiceGlobal.getService(PSSysWFSettingService.class, (SessionFactory)this.getSessionFactory());
                pSSysWFSettingService.autoGet((IEntity)pSSysWFSetting);
                this.pssyswfsetting = pSSysWFSetting;
            }
            return this.pssyswfsetting;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSWFVersion getPSWFVersion() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFVersion();
        }
        if (this.getPSWFVersionId() == null) {
            return null;
        }
        Integer n = this.objPSWFVersionLock;
        synchronized (n) {
            if (this.pswfversion != null && DataTypeHelper.compare((int)25, (Object)this.getPSWFVersionId(), (Object)this.pswfversion.getPSWFVersionId()) != 0L) {
                this.pswfversion = null;
            }
            if (this.pswfversion == null) {
                PSWFVersion pSWFVersion = new PSWFVersion();
                pSWFVersion.setPSWFVersionId(this.getPSWFVersionId());
                PSWFVersionService pSWFVersionService = (PSWFVersionService)ServiceGlobal.getService(PSWFVersionService.class, (SessionFactory)this.getSessionFactory());
                pSWFVersionService.autoGet((IEntity)pSWFVersion);
                this.pswfversion = pSWFVersion;
            }
            return this.pswfversion;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSWorkflow getPSWorkflow() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWorkflow();
        }
        if (this.getPSWorkflowId() == null) {
            return null;
        }
        Integer n = this.objPSWorkflowLock;
        synchronized (n) {
            if (this.psworkflow != null && DataTypeHelper.compare((int)25, (Object)this.getPSWorkflowId(), (Object)this.psworkflow.getPSWorkflowId()) != 0L) {
                this.psworkflow = null;
            }
            if (this.psworkflow == null) {
                PSWorkflow pSWorkflow = new PSWorkflow();
                pSWorkflow.setPSWorkflowId(this.getPSWorkflowId());
                PSWorkflowService pSWorkflowService = (PSWorkflowService)ServiceGlobal.getService(PSWorkflowService.class, (SessionFactory)this.getSessionFactory());
                pSWorkflowService.autoGet((IEntity)pSWorkflow);
                this.psworkflow = pSWorkflow;
            }
            return this.psworkflow;
        }
    }

    private PSWFUtilUIActionBase getProxyEntity() {
        return this.proxyPSWFUtilUIActionBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSWFUtilUIActionBase = null;
        if (iDataObject != null && iDataObject instanceof PSWFUtilUIActionBase) {
            this.proxyPSWFUtilUIActionBase = (PSWFUtilUIActionBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWFUtilUIActionService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSDEUIACTIONID, 4);
        fieldIndexMap.put(FIELD_PSDEUIACTIONNAME, 5);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 6);
        fieldIndexMap.put(FIELD_PSSYSWFSETTINGID, 7);
        fieldIndexMap.put(FIELD_PSSYSWFSETTINGNAME, 8);
        fieldIndexMap.put(FIELD_PSWFUTILUIACTIONID, 9);
        fieldIndexMap.put(FIELD_PSWFUTILUIACTIONNAME, 10);
        fieldIndexMap.put(FIELD_PSWFVERSIONID, 11);
        fieldIndexMap.put(FIELD_PSWFVERSIONNAME, 12);
        fieldIndexMap.put(FIELD_PSWORKFLOWID, 13);
        fieldIndexMap.put(FIELD_PSWORKFLOWNAME, 14);
        fieldIndexMap.put(FIELD_UPDATEDATE, 15);
        fieldIndexMap.put(FIELD_UPDATEMAN, 16);
        fieldIndexMap.put(FIELD_UTILTYPE, 17);
        fieldIndexMap.put(FIELD_VALIDFLAG, 18);
    }
}

