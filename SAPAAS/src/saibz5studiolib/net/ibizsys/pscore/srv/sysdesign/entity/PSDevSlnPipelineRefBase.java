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
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnPipeline;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnPipelineRefBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevSlnPipelineRefBase.class);
    public static final String FIELD_CONDMODEL = "CONDMODEL";
    public static final String FIELD_CONDMODELFLAG = "CONDMODELFLAG";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVSLNID = "PSDEVSLNID";
    public static final String FIELD_PSDEVSLNNAME = "PSDEVSLNNAME";
    public static final String FIELD_PSDEVSLNPIPELINEID = "PSDEVSLNPIPELINEID";
    public static final String FIELD_PSDEVSLNPIPELINENAME = "PSDEVSLNPIPELINENAME";
    public static final String FIELD_PSDEVSLNPIPELINEREFID = "PSDEVSLNPIPELINEREFID";
    public static final String FIELD_PSDEVSLNPIPELINEREFNAME = "PSDEVSLNPIPELINEREFNAME";
    public static final String FIELD_REFMODE = "REFMODE";
    public static final String FIELD_REFPARAMS = "REFPARAMS";
    public static final String FIELD_REFPSDEVSLNPIPELINEID = "REFPSDEVSLNPIPELINEID";
    public static final String FIELD_REFPSDEVSLNPIPELINENAME = "REFPSDEVSLNPIPELINENAME";
    public static final String FIELD_REFTAG = "REFTAG";
    public static final String FIELD_REFTAG2 = "REFTAG2";
    public static final String FIELD_REFTAG3 = "REFTAG3";
    public static final String FIELD_REFTAG4 = "REFTAG4";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CONDMODEL = 0;
    private static final int INDEX_CONDMODELFLAG = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_ORDERVALUE = 5;
    private static final int INDEX_PSDEVCENTERID = 6;
    private static final int INDEX_PSDEVSLNID = 7;
    private static final int INDEX_PSDEVSLNNAME = 8;
    private static final int INDEX_PSDEVSLNPIPELINEID = 9;
    private static final int INDEX_PSDEVSLNPIPELINENAME = 10;
    private static final int INDEX_PSDEVSLNPIPELINEREFID = 11;
    private static final int INDEX_PSDEVSLNPIPELINEREFNAME = 12;
    private static final int INDEX_REFMODE = 13;
    private static final int INDEX_REFPARAMS = 14;
    private static final int INDEX_REFPSDEVSLNPIPELINEID = 15;
    private static final int INDEX_REFPSDEVSLNPIPELINENAME = 16;
    private static final int INDEX_REFTAG = 17;
    private static final int INDEX_REFTAG2 = 18;
    private static final int INDEX_REFTAG3 = 19;
    private static final int INDEX_REFTAG4 = 20;
    private static final int INDEX_UPDATEDATE = 21;
    private static final int INDEX_UPDATEMAN = 22;
    private static final int INDEX_USERCAT = 23;
    private static final int INDEX_USERTAG = 24;
    private static final int INDEX_USERTAG2 = 25;
    private static final int INDEX_USERTAG3 = 26;
    private static final int INDEX_USERTAG4 = 27;
    private static final int INDEX_VALIDFLAG = 28;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevSlnPipelineRefBase proxyPSDevSlnPipelineRefBase = null;
    private boolean condmodelDirtyFlag = false;
    private boolean condmodelflagDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevslnidDirtyFlag = false;
    private boolean psdevslnnameDirtyFlag = false;
    private boolean psdevslnpipelineidDirtyFlag = false;
    private boolean psdevslnpipelinenameDirtyFlag = false;
    private boolean psdevslnpipelinerefidDirtyFlag = false;
    private boolean psdevslnpipelinerefnameDirtyFlag = false;
    private boolean refmodeDirtyFlag = false;
    private boolean refparamsDirtyFlag = false;
    private boolean refpsdevslnpipelineidDirtyFlag = false;
    private boolean refpsdevslnpipelinenameDirtyFlag = false;
    private boolean reftagDirtyFlag = false;
    private boolean reftag2DirtyFlag = false;
    private boolean reftag3DirtyFlag = false;
    private boolean reftag4DirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="condmodel")
    private String condmodel;
    @Column(name="condmodelflag")
    private Integer condmodelflag;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevslnid")
    private String psdevslnid;
    @Column(name="psdevslnname")
    private String psdevslnname;
    @Column(name="psdevslnpipelineid")
    private String psdevslnpipelineid;
    @Column(name="psdevslnpipelinename")
    private String psdevslnpipelinename;
    @Column(name="psdevslnpipelinerefid")
    private String psdevslnpipelinerefid;
    @Column(name="psdevslnpipelinerefname")
    private String psdevslnpipelinerefname;
    @Column(name="refmode")
    private String refmode;
    @Column(name="refparams")
    private String refparams;
    @Column(name="refpsdevslnpipelineid")
    private String refpsdevslnpipelineid;
    @Column(name="refpsdevslnpipelinename")
    private String refpsdevslnpipelinename;
    @Column(name="reftag")
    private String reftag;
    @Column(name="reftag2")
    private String reftag2;
    @Column(name="reftag3")
    private String reftag3;
    @Column(name="reftag4")
    private String reftag4;
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
    private Integer objPSDevSlnPipelineLock = new Integer(1);
    private PSDevSlnPipeline psdevslnpipeline = null;
    private Integer objRefPSDevSlnPipelineLock = new Integer(1);
    private PSDevSlnPipeline refpsdevslnpipeline = null;
    private Integer objPSDevSlnLock = new Integer(1);
    private PSDevSln psdevsln = null;

    public void setCondModel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCondModel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.condmodel = string;
        this.condmodelDirtyFlag = true;
    }

    public String getCondModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCondModel();
        }
        return this.condmodel;
    }

    public boolean isCondModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCondModelDirty();
        }
        return this.condmodelDirtyFlag;
    }

    public void resetCondModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCondModel();
            return;
        }
        this.condmodelDirtyFlag = false;
        this.condmodel = null;
    }

    public void setCondModelFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCondModelFlag(n);
            return;
        }
        this.condmodelflag = n;
        this.condmodelflagDirtyFlag = true;
    }

    public Integer getCondModelFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCondModelFlag();
        }
        return this.condmodelflag;
    }

    public boolean isCondModelFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCondModelFlagDirty();
        }
        return this.condmodelflagDirtyFlag;
    }

    public void resetCondModelFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCondModelFlag();
            return;
        }
        this.condmodelflagDirtyFlag = false;
        this.condmodelflag = null;
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

    public void setPSDevCenterId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterid = string;
        this.psdevcenteridDirtyFlag = true;
    }

    public String getPSDevCenterId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterId();
        }
        return this.psdevcenterid;
    }

    public boolean isPSDevCenterIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterIdDirty();
        }
        return this.psdevcenteridDirtyFlag;
    }

    public void resetPSDevCenterId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterId();
            return;
        }
        this.psdevcenteridDirtyFlag = false;
        this.psdevcenterid = null;
    }

    public void setPSDevSlnId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnid = string;
        this.psdevslnidDirtyFlag = true;
    }

    public String getPSDevSlnId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnId();
        }
        return this.psdevslnid;
    }

    public boolean isPSDevSlnIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnIdDirty();
        }
        return this.psdevslnidDirtyFlag;
    }

    public void resetPSDevSlnId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnId();
            return;
        }
        this.psdevslnidDirtyFlag = false;
        this.psdevslnid = null;
    }

    public void setPSDevSlnName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnname = string;
        this.psdevslnnameDirtyFlag = true;
    }

    public String getPSDevSlnName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnName();
        }
        return this.psdevslnname;
    }

    public boolean isPSDevSlnNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnNameDirty();
        }
        return this.psdevslnnameDirtyFlag;
    }

    public void resetPSDevSlnName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnName();
            return;
        }
        this.psdevslnnameDirtyFlag = false;
        this.psdevslnname = null;
    }

    public void setPSDevSlnPipelineId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnPipelineId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnpipelineid = string;
        this.psdevslnpipelineidDirtyFlag = true;
    }

    public String getPSDevSlnPipelineId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnPipelineId();
        }
        return this.psdevslnpipelineid;
    }

    public boolean isPSDevSlnPipelineIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnPipelineIdDirty();
        }
        return this.psdevslnpipelineidDirtyFlag;
    }

    public void resetPSDevSlnPipelineId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnPipelineId();
            return;
        }
        this.psdevslnpipelineidDirtyFlag = false;
        this.psdevslnpipelineid = null;
    }

    public void setPSDevSlnPipelineName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnPipelineName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnpipelinename = string;
        this.psdevslnpipelinenameDirtyFlag = true;
    }

    public String getPSDevSlnPipelineName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnPipelineName();
        }
        return this.psdevslnpipelinename;
    }

    public boolean isPSDevSlnPipelineNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnPipelineNameDirty();
        }
        return this.psdevslnpipelinenameDirtyFlag;
    }

    public void resetPSDevSlnPipelineName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnPipelineName();
            return;
        }
        this.psdevslnpipelinenameDirtyFlag = false;
        this.psdevslnpipelinename = null;
    }

    public void setPSDevSlnPipelineRefId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnPipelineRefId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnpipelinerefid = string;
        this.psdevslnpipelinerefidDirtyFlag = true;
    }

    public String getPSDevSlnPipelineRefId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnPipelineRefId();
        }
        return this.psdevslnpipelinerefid;
    }

    public boolean isPSDevSlnPipelineRefIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnPipelineRefIdDirty();
        }
        return this.psdevslnpipelinerefidDirtyFlag;
    }

    public void resetPSDevSlnPipelineRefId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnPipelineRefId();
            return;
        }
        this.psdevslnpipelinerefidDirtyFlag = false;
        this.psdevslnpipelinerefid = null;
    }

    public void setPSDevSlnPipelineRefName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnPipelineRefName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnpipelinerefname = string;
        this.psdevslnpipelinerefnameDirtyFlag = true;
    }

    public String getPSDevSlnPipelineRefName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnPipelineRefName();
        }
        return this.psdevslnpipelinerefname;
    }

    public boolean isPSDevSlnPipelineRefNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnPipelineRefNameDirty();
        }
        return this.psdevslnpipelinerefnameDirtyFlag;
    }

    public void resetPSDevSlnPipelineRefName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnPipelineRefName();
            return;
        }
        this.psdevslnpipelinerefnameDirtyFlag = false;
        this.psdevslnpipelinerefname = null;
    }

    public void setRefMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refmode = string;
        this.refmodeDirtyFlag = true;
    }

    public String getRefMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefMode();
        }
        return this.refmode;
    }

    public boolean isRefModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefModeDirty();
        }
        return this.refmodeDirtyFlag;
    }

    public void resetRefMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefMode();
            return;
        }
        this.refmodeDirtyFlag = false;
        this.refmode = null;
    }

    public void setRefParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refparams = string;
        this.refparamsDirtyFlag = true;
    }

    public String getRefParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefParams();
        }
        return this.refparams;
    }

    public boolean isRefParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefParamsDirty();
        }
        return this.refparamsDirtyFlag;
    }

    public void resetRefParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefParams();
            return;
        }
        this.refparamsDirtyFlag = false;
        this.refparams = null;
    }

    public void setRefPSDevSlnPipelineId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSDevSlnPipelineId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpsdevslnpipelineid = string;
        this.refpsdevslnpipelineidDirtyFlag = true;
    }

    public String getRefPSDevSlnPipelineId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDevSlnPipelineId();
        }
        return this.refpsdevslnpipelineid;
    }

    public boolean isRefPSDevSlnPipelineIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSDevSlnPipelineIdDirty();
        }
        return this.refpsdevslnpipelineidDirtyFlag;
    }

    public void resetRefPSDevSlnPipelineId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSDevSlnPipelineId();
            return;
        }
        this.refpsdevslnpipelineidDirtyFlag = false;
        this.refpsdevslnpipelineid = null;
    }

    public void setRefPSDevSlnPipelineName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSDevSlnPipelineName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpsdevslnpipelinename = string;
        this.refpsdevslnpipelinenameDirtyFlag = true;
    }

    public String getRefPSDevSlnPipelineName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDevSlnPipelineName();
        }
        return this.refpsdevslnpipelinename;
    }

    public boolean isRefPSDevSlnPipelineNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSDevSlnPipelineNameDirty();
        }
        return this.refpsdevslnpipelinenameDirtyFlag;
    }

    public void resetRefPSDevSlnPipelineName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSDevSlnPipelineName();
            return;
        }
        this.refpsdevslnpipelinenameDirtyFlag = false;
        this.refpsdevslnpipelinename = null;
    }

    public void setRefTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.reftag = string;
        this.reftagDirtyFlag = true;
    }

    public String getRefTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefTag();
        }
        return this.reftag;
    }

    public boolean isRefTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefTagDirty();
        }
        return this.reftagDirtyFlag;
    }

    public void resetRefTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefTag();
            return;
        }
        this.reftagDirtyFlag = false;
        this.reftag = null;
    }

    public void setRefTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.reftag2 = string;
        this.reftag2DirtyFlag = true;
    }

    public String getRefTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefTag2();
        }
        return this.reftag2;
    }

    public boolean isRefTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefTag2Dirty();
        }
        return this.reftag2DirtyFlag;
    }

    public void resetRefTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefTag2();
            return;
        }
        this.reftag2DirtyFlag = false;
        this.reftag2 = null;
    }

    public void setRefTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.reftag3 = string;
        this.reftag3DirtyFlag = true;
    }

    public String getRefTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefTag3();
        }
        return this.reftag3;
    }

    public boolean isRefTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefTag3Dirty();
        }
        return this.reftag3DirtyFlag;
    }

    public void resetRefTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefTag3();
            return;
        }
        this.reftag3DirtyFlag = false;
        this.reftag3 = null;
    }

    public void setRefTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.reftag4 = string;
        this.reftag4DirtyFlag = true;
    }

    public String getRefTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefTag4();
        }
        return this.reftag4;
    }

    public boolean isRefTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefTag4Dirty();
        }
        return this.reftag4DirtyFlag;
    }

    public void resetRefTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefTag4();
            return;
        }
        this.reftag4DirtyFlag = false;
        this.reftag4 = null;
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
        PSDevSlnPipelineRefBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevSlnPipelineRefBase pSDevSlnPipelineRefBase) {
        pSDevSlnPipelineRefBase.resetCondModel();
        pSDevSlnPipelineRefBase.resetCondModelFlag();
        pSDevSlnPipelineRefBase.resetCreateDate();
        pSDevSlnPipelineRefBase.resetCreateMan();
        pSDevSlnPipelineRefBase.resetMemo();
        pSDevSlnPipelineRefBase.resetOrderValue();
        pSDevSlnPipelineRefBase.resetPSDevCenterId();
        pSDevSlnPipelineRefBase.resetPSDevSlnId();
        pSDevSlnPipelineRefBase.resetPSDevSlnName();
        pSDevSlnPipelineRefBase.resetPSDevSlnPipelineId();
        pSDevSlnPipelineRefBase.resetPSDevSlnPipelineName();
        pSDevSlnPipelineRefBase.resetPSDevSlnPipelineRefId();
        pSDevSlnPipelineRefBase.resetPSDevSlnPipelineRefName();
        pSDevSlnPipelineRefBase.resetRefMode();
        pSDevSlnPipelineRefBase.resetRefParams();
        pSDevSlnPipelineRefBase.resetRefPSDevSlnPipelineId();
        pSDevSlnPipelineRefBase.resetRefPSDevSlnPipelineName();
        pSDevSlnPipelineRefBase.resetRefTag();
        pSDevSlnPipelineRefBase.resetRefTag2();
        pSDevSlnPipelineRefBase.resetRefTag3();
        pSDevSlnPipelineRefBase.resetRefTag4();
        pSDevSlnPipelineRefBase.resetUpdateDate();
        pSDevSlnPipelineRefBase.resetUpdateMan();
        pSDevSlnPipelineRefBase.resetUserCat();
        pSDevSlnPipelineRefBase.resetUserTag();
        pSDevSlnPipelineRefBase.resetUserTag2();
        pSDevSlnPipelineRefBase.resetUserTag3();
        pSDevSlnPipelineRefBase.resetUserTag4();
        pSDevSlnPipelineRefBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCondModelDirty()) {
            hashMap.put(FIELD_CONDMODEL, this.getCondModel());
        }
        if (!bl || this.isCondModelFlagDirty()) {
            hashMap.put(FIELD_CONDMODELFLAG, this.getCondModelFlag());
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
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevSlnIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNID, this.getPSDevSlnId());
        }
        if (!bl || this.isPSDevSlnNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNNAME, this.getPSDevSlnName());
        }
        if (!bl || this.isPSDevSlnPipelineIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNPIPELINEID, this.getPSDevSlnPipelineId());
        }
        if (!bl || this.isPSDevSlnPipelineNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNPIPELINENAME, this.getPSDevSlnPipelineName());
        }
        if (!bl || this.isPSDevSlnPipelineRefIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNPIPELINEREFID, this.getPSDevSlnPipelineRefId());
        }
        if (!bl || this.isPSDevSlnPipelineRefNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNPIPELINEREFNAME, this.getPSDevSlnPipelineRefName());
        }
        if (!bl || this.isRefModeDirty()) {
            hashMap.put(FIELD_REFMODE, this.getRefMode());
        }
        if (!bl || this.isRefParamsDirty()) {
            hashMap.put(FIELD_REFPARAMS, this.getRefParams());
        }
        if (!bl || this.isRefPSDevSlnPipelineIdDirty()) {
            hashMap.put(FIELD_REFPSDEVSLNPIPELINEID, this.getRefPSDevSlnPipelineId());
        }
        if (!bl || this.isRefPSDevSlnPipelineNameDirty()) {
            hashMap.put(FIELD_REFPSDEVSLNPIPELINENAME, this.getRefPSDevSlnPipelineName());
        }
        if (!bl || this.isRefTagDirty()) {
            hashMap.put(FIELD_REFTAG, this.getRefTag());
        }
        if (!bl || this.isRefTag2Dirty()) {
            hashMap.put(FIELD_REFTAG2, this.getRefTag2());
        }
        if (!bl || this.isRefTag3Dirty()) {
            hashMap.put(FIELD_REFTAG3, this.getRefTag3());
        }
        if (!bl || this.isRefTag4Dirty()) {
            hashMap.put(FIELD_REFTAG4, this.getRefTag4());
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
        return PSDevSlnPipelineRefBase.get(this, n);
    }

    private static Object get(PSDevSlnPipelineRefBase pSDevSlnPipelineRefBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnPipelineRefBase.getCondModel();
            }
            case 1: {
                return pSDevSlnPipelineRefBase.getCondModelFlag();
            }
            case 2: {
                return pSDevSlnPipelineRefBase.getCreateDate();
            }
            case 3: {
                return pSDevSlnPipelineRefBase.getCreateMan();
            }
            case 4: {
                return pSDevSlnPipelineRefBase.getMemo();
            }
            case 5: {
                return pSDevSlnPipelineRefBase.getOrderValue();
            }
            case 6: {
                return pSDevSlnPipelineRefBase.getPSDevCenterId();
            }
            case 7: {
                return pSDevSlnPipelineRefBase.getPSDevSlnId();
            }
            case 8: {
                return pSDevSlnPipelineRefBase.getPSDevSlnName();
            }
            case 9: {
                return pSDevSlnPipelineRefBase.getPSDevSlnPipelineId();
            }
            case 10: {
                return pSDevSlnPipelineRefBase.getPSDevSlnPipelineName();
            }
            case 11: {
                return pSDevSlnPipelineRefBase.getPSDevSlnPipelineRefId();
            }
            case 12: {
                return pSDevSlnPipelineRefBase.getPSDevSlnPipelineRefName();
            }
            case 13: {
                return pSDevSlnPipelineRefBase.getRefMode();
            }
            case 14: {
                return pSDevSlnPipelineRefBase.getRefParams();
            }
            case 15: {
                return pSDevSlnPipelineRefBase.getRefPSDevSlnPipelineId();
            }
            case 16: {
                return pSDevSlnPipelineRefBase.getRefPSDevSlnPipelineName();
            }
            case 17: {
                return pSDevSlnPipelineRefBase.getRefTag();
            }
            case 18: {
                return pSDevSlnPipelineRefBase.getRefTag2();
            }
            case 19: {
                return pSDevSlnPipelineRefBase.getRefTag3();
            }
            case 20: {
                return pSDevSlnPipelineRefBase.getRefTag4();
            }
            case 21: {
                return pSDevSlnPipelineRefBase.getUpdateDate();
            }
            case 22: {
                return pSDevSlnPipelineRefBase.getUpdateMan();
            }
            case 23: {
                return pSDevSlnPipelineRefBase.getUserCat();
            }
            case 24: {
                return pSDevSlnPipelineRefBase.getUserTag();
            }
            case 25: {
                return pSDevSlnPipelineRefBase.getUserTag2();
            }
            case 26: {
                return pSDevSlnPipelineRefBase.getUserTag3();
            }
            case 27: {
                return pSDevSlnPipelineRefBase.getUserTag4();
            }
            case 28: {
                return pSDevSlnPipelineRefBase.getValidFlag();
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
        PSDevSlnPipelineRefBase.set(this, n, object);
    }

    private static void set(PSDevSlnPipelineRefBase pSDevSlnPipelineRefBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnPipelineRefBase.setCondModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDevSlnPipelineRefBase.setCondModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 2: {
                pSDevSlnPipelineRefBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSDevSlnPipelineRefBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDevSlnPipelineRefBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDevSlnPipelineRefBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSDevSlnPipelineRefBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDevSlnPipelineRefBase.setPSDevSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDevSlnPipelineRefBase.setPSDevSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDevSlnPipelineRefBase.setPSDevSlnPipelineId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDevSlnPipelineRefBase.setPSDevSlnPipelineName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDevSlnPipelineRefBase.setPSDevSlnPipelineRefId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDevSlnPipelineRefBase.setPSDevSlnPipelineRefName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDevSlnPipelineRefBase.setRefMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDevSlnPipelineRefBase.setRefParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDevSlnPipelineRefBase.setRefPSDevSlnPipelineId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDevSlnPipelineRefBase.setRefPSDevSlnPipelineName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDevSlnPipelineRefBase.setRefTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDevSlnPipelineRefBase.setRefTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDevSlnPipelineRefBase.setRefTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDevSlnPipelineRefBase.setRefTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDevSlnPipelineRefBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 22: {
                pSDevSlnPipelineRefBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDevSlnPipelineRefBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDevSlnPipelineRefBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDevSlnPipelineRefBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDevSlnPipelineRefBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDevSlnPipelineRefBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDevSlnPipelineRefBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDevSlnPipelineRefBase.isNull(this, n);
    }

    private static boolean isNull(PSDevSlnPipelineRefBase pSDevSlnPipelineRefBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnPipelineRefBase.getCondModel() == null;
            }
            case 1: {
                return pSDevSlnPipelineRefBase.getCondModelFlag() == null;
            }
            case 2: {
                return pSDevSlnPipelineRefBase.getCreateDate() == null;
            }
            case 3: {
                return pSDevSlnPipelineRefBase.getCreateMan() == null;
            }
            case 4: {
                return pSDevSlnPipelineRefBase.getMemo() == null;
            }
            case 5: {
                return pSDevSlnPipelineRefBase.getOrderValue() == null;
            }
            case 6: {
                return pSDevSlnPipelineRefBase.getPSDevCenterId() == null;
            }
            case 7: {
                return pSDevSlnPipelineRefBase.getPSDevSlnId() == null;
            }
            case 8: {
                return pSDevSlnPipelineRefBase.getPSDevSlnName() == null;
            }
            case 9: {
                return pSDevSlnPipelineRefBase.getPSDevSlnPipelineId() == null;
            }
            case 10: {
                return pSDevSlnPipelineRefBase.getPSDevSlnPipelineName() == null;
            }
            case 11: {
                return pSDevSlnPipelineRefBase.getPSDevSlnPipelineRefId() == null;
            }
            case 12: {
                return pSDevSlnPipelineRefBase.getPSDevSlnPipelineRefName() == null;
            }
            case 13: {
                return pSDevSlnPipelineRefBase.getRefMode() == null;
            }
            case 14: {
                return pSDevSlnPipelineRefBase.getRefParams() == null;
            }
            case 15: {
                return pSDevSlnPipelineRefBase.getRefPSDevSlnPipelineId() == null;
            }
            case 16: {
                return pSDevSlnPipelineRefBase.getRefPSDevSlnPipelineName() == null;
            }
            case 17: {
                return pSDevSlnPipelineRefBase.getRefTag() == null;
            }
            case 18: {
                return pSDevSlnPipelineRefBase.getRefTag2() == null;
            }
            case 19: {
                return pSDevSlnPipelineRefBase.getRefTag3() == null;
            }
            case 20: {
                return pSDevSlnPipelineRefBase.getRefTag4() == null;
            }
            case 21: {
                return pSDevSlnPipelineRefBase.getUpdateDate() == null;
            }
            case 22: {
                return pSDevSlnPipelineRefBase.getUpdateMan() == null;
            }
            case 23: {
                return pSDevSlnPipelineRefBase.getUserCat() == null;
            }
            case 24: {
                return pSDevSlnPipelineRefBase.getUserTag() == null;
            }
            case 25: {
                return pSDevSlnPipelineRefBase.getUserTag2() == null;
            }
            case 26: {
                return pSDevSlnPipelineRefBase.getUserTag3() == null;
            }
            case 27: {
                return pSDevSlnPipelineRefBase.getUserTag4() == null;
            }
            case 28: {
                return pSDevSlnPipelineRefBase.getValidFlag() == null;
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
        return PSDevSlnPipelineRefBase.contains(this, n);
    }

    private static boolean contains(PSDevSlnPipelineRefBase pSDevSlnPipelineRefBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnPipelineRefBase.isCondModelDirty();
            }
            case 1: {
                return pSDevSlnPipelineRefBase.isCondModelFlagDirty();
            }
            case 2: {
                return pSDevSlnPipelineRefBase.isCreateDateDirty();
            }
            case 3: {
                return pSDevSlnPipelineRefBase.isCreateManDirty();
            }
            case 4: {
                return pSDevSlnPipelineRefBase.isMemoDirty();
            }
            case 5: {
                return pSDevSlnPipelineRefBase.isOrderValueDirty();
            }
            case 6: {
                return pSDevSlnPipelineRefBase.isPSDevCenterIdDirty();
            }
            case 7: {
                return pSDevSlnPipelineRefBase.isPSDevSlnIdDirty();
            }
            case 8: {
                return pSDevSlnPipelineRefBase.isPSDevSlnNameDirty();
            }
            case 9: {
                return pSDevSlnPipelineRefBase.isPSDevSlnPipelineIdDirty();
            }
            case 10: {
                return pSDevSlnPipelineRefBase.isPSDevSlnPipelineNameDirty();
            }
            case 11: {
                return pSDevSlnPipelineRefBase.isPSDevSlnPipelineRefIdDirty();
            }
            case 12: {
                return pSDevSlnPipelineRefBase.isPSDevSlnPipelineRefNameDirty();
            }
            case 13: {
                return pSDevSlnPipelineRefBase.isRefModeDirty();
            }
            case 14: {
                return pSDevSlnPipelineRefBase.isRefParamsDirty();
            }
            case 15: {
                return pSDevSlnPipelineRefBase.isRefPSDevSlnPipelineIdDirty();
            }
            case 16: {
                return pSDevSlnPipelineRefBase.isRefPSDevSlnPipelineNameDirty();
            }
            case 17: {
                return pSDevSlnPipelineRefBase.isRefTagDirty();
            }
            case 18: {
                return pSDevSlnPipelineRefBase.isRefTag2Dirty();
            }
            case 19: {
                return pSDevSlnPipelineRefBase.isRefTag3Dirty();
            }
            case 20: {
                return pSDevSlnPipelineRefBase.isRefTag4Dirty();
            }
            case 21: {
                return pSDevSlnPipelineRefBase.isUpdateDateDirty();
            }
            case 22: {
                return pSDevSlnPipelineRefBase.isUpdateManDirty();
            }
            case 23: {
                return pSDevSlnPipelineRefBase.isUserCatDirty();
            }
            case 24: {
                return pSDevSlnPipelineRefBase.isUserTagDirty();
            }
            case 25: {
                return pSDevSlnPipelineRefBase.isUserTag2Dirty();
            }
            case 26: {
                return pSDevSlnPipelineRefBase.isUserTag3Dirty();
            }
            case 27: {
                return pSDevSlnPipelineRefBase.isUserTag4Dirty();
            }
            case 28: {
                return pSDevSlnPipelineRefBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevSlnPipelineRefBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevSlnPipelineRefBase pSDevSlnPipelineRefBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevSlnPipelineRefBase.getCondModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"condmodel", (Object)PSDevSlnPipelineRefBase.getJSONValue((Object)pSDevSlnPipelineRefBase.getCondModel()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineRefBase.getCondModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"condmodelflag", (Object)PSDevSlnPipelineRefBase.getJSONValue((Object)pSDevSlnPipelineRefBase.getCondModelFlag()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineRefBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevSlnPipelineRefBase.getJSONValue((Object)pSDevSlnPipelineRefBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineRefBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevSlnPipelineRefBase.getJSONValue((Object)pSDevSlnPipelineRefBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineRefBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDevSlnPipelineRefBase.getJSONValue((Object)pSDevSlnPipelineRefBase.getMemo()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineRefBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDevSlnPipelineRefBase.getJSONValue((Object)pSDevSlnPipelineRefBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineRefBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDevSlnPipelineRefBase.getJSONValue((Object)pSDevSlnPipelineRefBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineRefBase.getPSDevSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnid", (Object)PSDevSlnPipelineRefBase.getJSONValue((Object)pSDevSlnPipelineRefBase.getPSDevSlnId()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineRefBase.getPSDevSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnname", (Object)PSDevSlnPipelineRefBase.getJSONValue((Object)pSDevSlnPipelineRefBase.getPSDevSlnName()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineRefBase.getPSDevSlnPipelineId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnpipelineid", (Object)PSDevSlnPipelineRefBase.getJSONValue((Object)pSDevSlnPipelineRefBase.getPSDevSlnPipelineId()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineRefBase.getPSDevSlnPipelineName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnpipelinename", (Object)PSDevSlnPipelineRefBase.getJSONValue((Object)pSDevSlnPipelineRefBase.getPSDevSlnPipelineName()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineRefBase.getPSDevSlnPipelineRefId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnpipelinerefid", (Object)PSDevSlnPipelineRefBase.getJSONValue((Object)pSDevSlnPipelineRefBase.getPSDevSlnPipelineRefId()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineRefBase.getPSDevSlnPipelineRefName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnpipelinerefname", (Object)PSDevSlnPipelineRefBase.getJSONValue((Object)pSDevSlnPipelineRefBase.getPSDevSlnPipelineRefName()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineRefBase.getRefMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refmode", (Object)PSDevSlnPipelineRefBase.getJSONValue((Object)pSDevSlnPipelineRefBase.getRefMode()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineRefBase.getRefParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refparams", (Object)PSDevSlnPipelineRefBase.getJSONValue((Object)pSDevSlnPipelineRefBase.getRefParams()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineRefBase.getRefPSDevSlnPipelineId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdevslnpipelineid", (Object)PSDevSlnPipelineRefBase.getJSONValue((Object)pSDevSlnPipelineRefBase.getRefPSDevSlnPipelineId()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineRefBase.getRefPSDevSlnPipelineName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdevslnpipelinename", (Object)PSDevSlnPipelineRefBase.getJSONValue((Object)pSDevSlnPipelineRefBase.getRefPSDevSlnPipelineName()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineRefBase.getRefTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"reftag", (Object)PSDevSlnPipelineRefBase.getJSONValue((Object)pSDevSlnPipelineRefBase.getRefTag()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineRefBase.getRefTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"reftag2", (Object)PSDevSlnPipelineRefBase.getJSONValue((Object)pSDevSlnPipelineRefBase.getRefTag2()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineRefBase.getRefTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"reftag3", (Object)PSDevSlnPipelineRefBase.getJSONValue((Object)pSDevSlnPipelineRefBase.getRefTag3()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineRefBase.getRefTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"reftag4", (Object)PSDevSlnPipelineRefBase.getJSONValue((Object)pSDevSlnPipelineRefBase.getRefTag4()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineRefBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevSlnPipelineRefBase.getJSONValue((Object)pSDevSlnPipelineRefBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineRefBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevSlnPipelineRefBase.getJSONValue((Object)pSDevSlnPipelineRefBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineRefBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDevSlnPipelineRefBase.getJSONValue((Object)pSDevSlnPipelineRefBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineRefBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDevSlnPipelineRefBase.getJSONValue((Object)pSDevSlnPipelineRefBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineRefBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDevSlnPipelineRefBase.getJSONValue((Object)pSDevSlnPipelineRefBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineRefBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDevSlnPipelineRefBase.getJSONValue((Object)pSDevSlnPipelineRefBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineRefBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDevSlnPipelineRefBase.getJSONValue((Object)pSDevSlnPipelineRefBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineRefBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDevSlnPipelineRefBase.getJSONValue((Object)pSDevSlnPipelineRefBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevSlnPipelineRefBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevSlnPipelineRefBase pSDevSlnPipelineRefBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevSlnPipelineRefBase.getCondModel() != null) {
            object = pSDevSlnPipelineRefBase.getCondModel();
            xmlNode.setAttribute(FIELD_CONDMODEL, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineRefBase.getCondModelFlag() != null) {
            object = pSDevSlnPipelineRefBase.getCondModelFlag();
            xmlNode.setAttribute(FIELD_CONDMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnPipelineRefBase.getCreateDate() != null) {
            object = pSDevSlnPipelineRefBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnPipelineRefBase.getCreateMan() != null) {
            object = pSDevSlnPipelineRefBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineRefBase.getMemo() != null) {
            object = pSDevSlnPipelineRefBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineRefBase.getOrderValue() != null) {
            object = pSDevSlnPipelineRefBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnPipelineRefBase.getPSDevCenterId() != null) {
            object = pSDevSlnPipelineRefBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineRefBase.getPSDevSlnId() != null) {
            object = pSDevSlnPipelineRefBase.getPSDevSlnId();
            xmlNode.setAttribute(FIELD_PSDEVSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineRefBase.getPSDevSlnName() != null) {
            object = pSDevSlnPipelineRefBase.getPSDevSlnName();
            xmlNode.setAttribute(FIELD_PSDEVSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineRefBase.getPSDevSlnPipelineId() != null) {
            object = pSDevSlnPipelineRefBase.getPSDevSlnPipelineId();
            xmlNode.setAttribute(FIELD_PSDEVSLNPIPELINEID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineRefBase.getPSDevSlnPipelineName() != null) {
            object = pSDevSlnPipelineRefBase.getPSDevSlnPipelineName();
            xmlNode.setAttribute(FIELD_PSDEVSLNPIPELINENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineRefBase.getPSDevSlnPipelineRefId() != null) {
            object = pSDevSlnPipelineRefBase.getPSDevSlnPipelineRefId();
            xmlNode.setAttribute(FIELD_PSDEVSLNPIPELINEREFID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineRefBase.getPSDevSlnPipelineRefName() != null) {
            object = pSDevSlnPipelineRefBase.getPSDevSlnPipelineRefName();
            xmlNode.setAttribute(FIELD_PSDEVSLNPIPELINEREFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineRefBase.getRefMode() != null) {
            object = pSDevSlnPipelineRefBase.getRefMode();
            xmlNode.setAttribute(FIELD_REFMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineRefBase.getRefParams() != null) {
            object = pSDevSlnPipelineRefBase.getRefParams();
            xmlNode.setAttribute(FIELD_REFPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineRefBase.getRefPSDevSlnPipelineId() != null) {
            object = pSDevSlnPipelineRefBase.getRefPSDevSlnPipelineId();
            xmlNode.setAttribute(FIELD_REFPSDEVSLNPIPELINEID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineRefBase.getRefPSDevSlnPipelineName() != null) {
            object = pSDevSlnPipelineRefBase.getRefPSDevSlnPipelineName();
            xmlNode.setAttribute(FIELD_REFPSDEVSLNPIPELINENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineRefBase.getRefTag() != null) {
            object = pSDevSlnPipelineRefBase.getRefTag();
            xmlNode.setAttribute(FIELD_REFTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineRefBase.getRefTag2() != null) {
            object = pSDevSlnPipelineRefBase.getRefTag2();
            xmlNode.setAttribute(FIELD_REFTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineRefBase.getRefTag3() != null) {
            object = pSDevSlnPipelineRefBase.getRefTag3();
            xmlNode.setAttribute(FIELD_REFTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineRefBase.getRefTag4() != null) {
            object = pSDevSlnPipelineRefBase.getRefTag4();
            xmlNode.setAttribute(FIELD_REFTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineRefBase.getUpdateDate() != null) {
            object = pSDevSlnPipelineRefBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnPipelineRefBase.getUpdateMan() != null) {
            object = pSDevSlnPipelineRefBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineRefBase.getUserCat() != null) {
            object = pSDevSlnPipelineRefBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineRefBase.getUserTag() != null) {
            object = pSDevSlnPipelineRefBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineRefBase.getUserTag2() != null) {
            object = pSDevSlnPipelineRefBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineRefBase.getUserTag3() != null) {
            object = pSDevSlnPipelineRefBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineRefBase.getUserTag4() != null) {
            object = pSDevSlnPipelineRefBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineRefBase.getValidFlag() != null) {
            object = pSDevSlnPipelineRefBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevSlnPipelineRefBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevSlnPipelineRefBase pSDevSlnPipelineRefBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevSlnPipelineRefBase.isCondModelDirty() && (bl || pSDevSlnPipelineRefBase.getCondModel() != null)) {
            iDataObject.set(FIELD_CONDMODEL, (Object)pSDevSlnPipelineRefBase.getCondModel());
        }
        if (pSDevSlnPipelineRefBase.isCondModelFlagDirty() && (bl || pSDevSlnPipelineRefBase.getCondModelFlag() != null)) {
            iDataObject.set(FIELD_CONDMODELFLAG, (Object)pSDevSlnPipelineRefBase.getCondModelFlag());
        }
        if (pSDevSlnPipelineRefBase.isCreateDateDirty() && (bl || pSDevSlnPipelineRefBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevSlnPipelineRefBase.getCreateDate());
        }
        if (pSDevSlnPipelineRefBase.isCreateManDirty() && (bl || pSDevSlnPipelineRefBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevSlnPipelineRefBase.getCreateMan());
        }
        if (pSDevSlnPipelineRefBase.isMemoDirty() && (bl || pSDevSlnPipelineRefBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDevSlnPipelineRefBase.getMemo());
        }
        if (pSDevSlnPipelineRefBase.isOrderValueDirty() && (bl || pSDevSlnPipelineRefBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDevSlnPipelineRefBase.getOrderValue());
        }
        if (pSDevSlnPipelineRefBase.isPSDevCenterIdDirty() && (bl || pSDevSlnPipelineRefBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDevSlnPipelineRefBase.getPSDevCenterId());
        }
        if (pSDevSlnPipelineRefBase.isPSDevSlnIdDirty() && (bl || pSDevSlnPipelineRefBase.getPSDevSlnId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNID, (Object)pSDevSlnPipelineRefBase.getPSDevSlnId());
        }
        if (pSDevSlnPipelineRefBase.isPSDevSlnNameDirty() && (bl || pSDevSlnPipelineRefBase.getPSDevSlnName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNNAME, (Object)pSDevSlnPipelineRefBase.getPSDevSlnName());
        }
        if (pSDevSlnPipelineRefBase.isPSDevSlnPipelineIdDirty() && (bl || pSDevSlnPipelineRefBase.getPSDevSlnPipelineId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNPIPELINEID, (Object)pSDevSlnPipelineRefBase.getPSDevSlnPipelineId());
        }
        if (pSDevSlnPipelineRefBase.isPSDevSlnPipelineNameDirty() && (bl || pSDevSlnPipelineRefBase.getPSDevSlnPipelineName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNPIPELINENAME, (Object)pSDevSlnPipelineRefBase.getPSDevSlnPipelineName());
        }
        if (pSDevSlnPipelineRefBase.isPSDevSlnPipelineRefIdDirty() && (bl || pSDevSlnPipelineRefBase.getPSDevSlnPipelineRefId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNPIPELINEREFID, (Object)pSDevSlnPipelineRefBase.getPSDevSlnPipelineRefId());
        }
        if (pSDevSlnPipelineRefBase.isPSDevSlnPipelineRefNameDirty() && (bl || pSDevSlnPipelineRefBase.getPSDevSlnPipelineRefName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNPIPELINEREFNAME, (Object)pSDevSlnPipelineRefBase.getPSDevSlnPipelineRefName());
        }
        if (pSDevSlnPipelineRefBase.isRefModeDirty() && (bl || pSDevSlnPipelineRefBase.getRefMode() != null)) {
            iDataObject.set(FIELD_REFMODE, (Object)pSDevSlnPipelineRefBase.getRefMode());
        }
        if (pSDevSlnPipelineRefBase.isRefParamsDirty() && (bl || pSDevSlnPipelineRefBase.getRefParams() != null)) {
            iDataObject.set(FIELD_REFPARAMS, (Object)pSDevSlnPipelineRefBase.getRefParams());
        }
        if (pSDevSlnPipelineRefBase.isRefPSDevSlnPipelineIdDirty() && (bl || pSDevSlnPipelineRefBase.getRefPSDevSlnPipelineId() != null)) {
            iDataObject.set(FIELD_REFPSDEVSLNPIPELINEID, (Object)pSDevSlnPipelineRefBase.getRefPSDevSlnPipelineId());
        }
        if (pSDevSlnPipelineRefBase.isRefPSDevSlnPipelineNameDirty() && (bl || pSDevSlnPipelineRefBase.getRefPSDevSlnPipelineName() != null)) {
            iDataObject.set(FIELD_REFPSDEVSLNPIPELINENAME, (Object)pSDevSlnPipelineRefBase.getRefPSDevSlnPipelineName());
        }
        if (pSDevSlnPipelineRefBase.isRefTagDirty() && (bl || pSDevSlnPipelineRefBase.getRefTag() != null)) {
            iDataObject.set(FIELD_REFTAG, (Object)pSDevSlnPipelineRefBase.getRefTag());
        }
        if (pSDevSlnPipelineRefBase.isRefTag2Dirty() && (bl || pSDevSlnPipelineRefBase.getRefTag2() != null)) {
            iDataObject.set(FIELD_REFTAG2, (Object)pSDevSlnPipelineRefBase.getRefTag2());
        }
        if (pSDevSlnPipelineRefBase.isRefTag3Dirty() && (bl || pSDevSlnPipelineRefBase.getRefTag3() != null)) {
            iDataObject.set(FIELD_REFTAG3, (Object)pSDevSlnPipelineRefBase.getRefTag3());
        }
        if (pSDevSlnPipelineRefBase.isRefTag4Dirty() && (bl || pSDevSlnPipelineRefBase.getRefTag4() != null)) {
            iDataObject.set(FIELD_REFTAG4, (Object)pSDevSlnPipelineRefBase.getRefTag4());
        }
        if (pSDevSlnPipelineRefBase.isUpdateDateDirty() && (bl || pSDevSlnPipelineRefBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevSlnPipelineRefBase.getUpdateDate());
        }
        if (pSDevSlnPipelineRefBase.isUpdateManDirty() && (bl || pSDevSlnPipelineRefBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevSlnPipelineRefBase.getUpdateMan());
        }
        if (pSDevSlnPipelineRefBase.isUserCatDirty() && (bl || pSDevSlnPipelineRefBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDevSlnPipelineRefBase.getUserCat());
        }
        if (pSDevSlnPipelineRefBase.isUserTagDirty() && (bl || pSDevSlnPipelineRefBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDevSlnPipelineRefBase.getUserTag());
        }
        if (pSDevSlnPipelineRefBase.isUserTag2Dirty() && (bl || pSDevSlnPipelineRefBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDevSlnPipelineRefBase.getUserTag2());
        }
        if (pSDevSlnPipelineRefBase.isUserTag3Dirty() && (bl || pSDevSlnPipelineRefBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDevSlnPipelineRefBase.getUserTag3());
        }
        if (pSDevSlnPipelineRefBase.isUserTag4Dirty() && (bl || pSDevSlnPipelineRefBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDevSlnPipelineRefBase.getUserTag4());
        }
        if (pSDevSlnPipelineRefBase.isValidFlagDirty() && (bl || pSDevSlnPipelineRefBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDevSlnPipelineRefBase.getValidFlag());
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
        return PSDevSlnPipelineRefBase.remove(this, n);
    }

    private static boolean remove(PSDevSlnPipelineRefBase pSDevSlnPipelineRefBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnPipelineRefBase.resetCondModel();
                return true;
            }
            case 1: {
                pSDevSlnPipelineRefBase.resetCondModelFlag();
                return true;
            }
            case 2: {
                pSDevSlnPipelineRefBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSDevSlnPipelineRefBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSDevSlnPipelineRefBase.resetMemo();
                return true;
            }
            case 5: {
                pSDevSlnPipelineRefBase.resetOrderValue();
                return true;
            }
            case 6: {
                pSDevSlnPipelineRefBase.resetPSDevCenterId();
                return true;
            }
            case 7: {
                pSDevSlnPipelineRefBase.resetPSDevSlnId();
                return true;
            }
            case 8: {
                pSDevSlnPipelineRefBase.resetPSDevSlnName();
                return true;
            }
            case 9: {
                pSDevSlnPipelineRefBase.resetPSDevSlnPipelineId();
                return true;
            }
            case 10: {
                pSDevSlnPipelineRefBase.resetPSDevSlnPipelineName();
                return true;
            }
            case 11: {
                pSDevSlnPipelineRefBase.resetPSDevSlnPipelineRefId();
                return true;
            }
            case 12: {
                pSDevSlnPipelineRefBase.resetPSDevSlnPipelineRefName();
                return true;
            }
            case 13: {
                pSDevSlnPipelineRefBase.resetRefMode();
                return true;
            }
            case 14: {
                pSDevSlnPipelineRefBase.resetRefParams();
                return true;
            }
            case 15: {
                pSDevSlnPipelineRefBase.resetRefPSDevSlnPipelineId();
                return true;
            }
            case 16: {
                pSDevSlnPipelineRefBase.resetRefPSDevSlnPipelineName();
                return true;
            }
            case 17: {
                pSDevSlnPipelineRefBase.resetRefTag();
                return true;
            }
            case 18: {
                pSDevSlnPipelineRefBase.resetRefTag2();
                return true;
            }
            case 19: {
                pSDevSlnPipelineRefBase.resetRefTag3();
                return true;
            }
            case 20: {
                pSDevSlnPipelineRefBase.resetRefTag4();
                return true;
            }
            case 21: {
                pSDevSlnPipelineRefBase.resetUpdateDate();
                return true;
            }
            case 22: {
                pSDevSlnPipelineRefBase.resetUpdateMan();
                return true;
            }
            case 23: {
                pSDevSlnPipelineRefBase.resetUserCat();
                return true;
            }
            case 24: {
                pSDevSlnPipelineRefBase.resetUserTag();
                return true;
            }
            case 25: {
                pSDevSlnPipelineRefBase.resetUserTag2();
                return true;
            }
            case 26: {
                pSDevSlnPipelineRefBase.resetUserTag3();
                return true;
            }
            case 27: {
                pSDevSlnPipelineRefBase.resetUserTag4();
                return true;
            }
            case 28: {
                pSDevSlnPipelineRefBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnPipeline getPSDevSlnPipeline() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnPipeline();
        }
        if (this.getPSDevSlnPipelineId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnPipelineLock;
        synchronized (n) {
            if (this.psdevslnpipeline != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnPipelineId(), (Object)this.psdevslnpipeline.getPSDevSlnPipelineId()) != 0L) {
                this.psdevslnpipeline = null;
            }
            if (this.psdevslnpipeline == null) {
                PSDevSlnPipeline pSDevSlnPipeline = new PSDevSlnPipeline();
                pSDevSlnPipeline.setPSDevSlnPipelineId(this.getPSDevSlnPipelineId());
                PSDevSlnPipelineService pSDevSlnPipelineService = (PSDevSlnPipelineService)ServiceGlobal.getService(PSDevSlnPipelineService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnPipelineService.autoGet((IEntity)pSDevSlnPipeline);
                this.psdevslnpipeline = pSDevSlnPipeline;
            }
            return this.psdevslnpipeline;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnPipeline getRefPSDevSlnPipeline() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDevSlnPipeline();
        }
        if (this.getRefPSDevSlnPipelineId() == null) {
            return null;
        }
        Integer n = this.objRefPSDevSlnPipelineLock;
        synchronized (n) {
            if (this.refpsdevslnpipeline != null && DataTypeHelper.compare((int)25, (Object)this.getRefPSDevSlnPipelineId(), (Object)this.refpsdevslnpipeline.getPSDevSlnPipelineId()) != 0L) {
                this.refpsdevslnpipeline = null;
            }
            if (this.refpsdevslnpipeline == null) {
                PSDevSlnPipeline pSDevSlnPipeline = new PSDevSlnPipeline();
                pSDevSlnPipeline.setPSDevSlnPipelineId(this.getRefPSDevSlnPipelineId());
                PSDevSlnPipelineService pSDevSlnPipelineService = (PSDevSlnPipelineService)ServiceGlobal.getService(PSDevSlnPipelineService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnPipelineService.autoGet((IEntity)pSDevSlnPipeline);
                this.refpsdevslnpipeline = pSDevSlnPipeline;
            }
            return this.refpsdevslnpipeline;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSln getPSDevSln() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSln();
        }
        if (this.getPSDevSlnId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnLock;
        synchronized (n) {
            if (this.psdevsln != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnId(), (Object)this.psdevsln.getPSDevSlnId()) != 0L) {
                this.psdevsln = null;
            }
            if (this.psdevsln == null) {
                PSDevSln pSDevSln = new PSDevSln();
                pSDevSln.setPSDevSlnId(this.getPSDevSlnId());
                PSDevSlnService pSDevSlnService = (PSDevSlnService)ServiceGlobal.getService(PSDevSlnService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnService.autoGet((IEntity)pSDevSln);
                this.psdevsln = pSDevSln;
            }
            return this.psdevsln;
        }
    }

    private PSDevSlnPipelineRefBase getProxyEntity() {
        return this.proxyPSDevSlnPipelineRefBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevSlnPipelineRefBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevSlnPipelineRefBase) {
            this.proxyPSDevSlnPipelineRefBase = (PSDevSlnPipelineRefBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineRefService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CONDMODEL, 0);
        fieldIndexMap.put(FIELD_CONDMODELFLAG, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_ORDERVALUE, 5);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 6);
        fieldIndexMap.put(FIELD_PSDEVSLNID, 7);
        fieldIndexMap.put(FIELD_PSDEVSLNNAME, 8);
        fieldIndexMap.put(FIELD_PSDEVSLNPIPELINEID, 9);
        fieldIndexMap.put(FIELD_PSDEVSLNPIPELINENAME, 10);
        fieldIndexMap.put(FIELD_PSDEVSLNPIPELINEREFID, 11);
        fieldIndexMap.put(FIELD_PSDEVSLNPIPELINEREFNAME, 12);
        fieldIndexMap.put(FIELD_REFMODE, 13);
        fieldIndexMap.put(FIELD_REFPARAMS, 14);
        fieldIndexMap.put(FIELD_REFPSDEVSLNPIPELINEID, 15);
        fieldIndexMap.put(FIELD_REFPSDEVSLNPIPELINENAME, 16);
        fieldIndexMap.put(FIELD_REFTAG, 17);
        fieldIndexMap.put(FIELD_REFTAG2, 18);
        fieldIndexMap.put(FIELD_REFTAG3, 19);
        fieldIndexMap.put(FIELD_REFTAG4, 20);
        fieldIndexMap.put(FIELD_UPDATEDATE, 21);
        fieldIndexMap.put(FIELD_UPDATEMAN, 22);
        fieldIndexMap.put(FIELD_USERCAT, 23);
        fieldIndexMap.put(FIELD_USERTAG, 24);
        fieldIndexMap.put(FIELD_USERTAG2, 25);
        fieldIndexMap.put(FIELD_USERTAG3, 26);
        fieldIndexMap.put(FIELD_USERTAG4, 27);
        fieldIndexMap.put(FIELD_VALIDFLAG, 28);
    }
}

