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
package net.ibizsys.pscore.srv.config.entity;

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
import net.ibizsys.pscore.srv.config.entity.PSSF;
import net.ibizsys.pscore.srv.config.entity.PSSFPubOjb;
import net.ibizsys.pscore.srv.config.entity.PSSFStyle;
import net.ibizsys.pscore.srv.config.service.PSSFPubOjbService;
import net.ibizsys.pscore.srv.config.service.PSSFService;
import net.ibizsys.pscore.srv.config.service.PSSFStyleService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSFPubOjbBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSFPubOjbBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MACROPARAMS = "MACROPARAMS";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PPSSFPUBOBJID = "PPSSFPUBOBJID";
    public static final String FIELD_PPSSFPUBOBJNAME = "PPSSFPUBOBJNAME";
    public static final String FIELD_PSSFID = "PSSFID";
    public static final String FIELD_PSSFNAME = "PSSFNAME";
    public static final String FIELD_PSSFPUBOBJID = "PSSFPUBOBJID";
    public static final String FIELD_PSSFPUBOBJNAME = "PSSFPUBOBJNAME";
    public static final String FIELD_PSSFSTYLEID = "PSSFSTYLEID";
    public static final String FIELD_PSSFSTYLENAME = "PSSFSTYLENAME";
    public static final String FIELD_PUBOBJ = "PUBOBJ";
    public static final String FIELD_PUBOBJTAG = "PUBOBJTAG";
    public static final String FIELD_PUBOBJTAG2 = "PUBOBJTAG2";
    public static final String FIELD_TARGET = "TARGET";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MACROPARAMS = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PPSSFPUBOBJID = 4;
    private static final int INDEX_PPSSFPUBOBJNAME = 5;
    private static final int INDEX_PSSFID = 6;
    private static final int INDEX_PSSFNAME = 7;
    private static final int INDEX_PSSFPUBOBJID = 8;
    private static final int INDEX_PSSFPUBOBJNAME = 9;
    private static final int INDEX_PSSFSTYLEID = 10;
    private static final int INDEX_PSSFSTYLENAME = 11;
    private static final int INDEX_PUBOBJ = 12;
    private static final int INDEX_PUBOBJTAG = 13;
    private static final int INDEX_PUBOBJTAG2 = 14;
    private static final int INDEX_TARGET = 15;
    private static final int INDEX_UPDATEDATE = 16;
    private static final int INDEX_UPDATEMAN = 17;
    private static final int INDEX_VALIDFLAG = 18;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSFPubOjbBase proxyPSSFPubOjbBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean macroparamsDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ppssfpubobjidDirtyFlag = false;
    private boolean ppssfpubobjnameDirtyFlag = false;
    private boolean pssfidDirtyFlag = false;
    private boolean pssfnameDirtyFlag = false;
    private boolean pssfpubobjidDirtyFlag = false;
    private boolean pssfpubobjnameDirtyFlag = false;
    private boolean pssfstyleidDirtyFlag = false;
    private boolean pssfstylenameDirtyFlag = false;
    private boolean pubobjDirtyFlag = false;
    private boolean pubobjtagDirtyFlag = false;
    private boolean pubobjtag2DirtyFlag = false;
    private boolean targetDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="macroparams")
    private String macroparams;
    @Column(name="memo")
    private String memo;
    @Column(name="ppssfpubobjid")
    private String ppssfpubobjid;
    @Column(name="ppssfpubobjname")
    private String ppssfpubobjname;
    @Column(name="pssfid")
    private String pssfid;
    @Column(name="pssfname")
    private String pssfname;
    @Column(name="pssfpubobjid")
    private String pssfpubobjid;
    @Column(name="pssfpubobjname")
    private String pssfpubobjname;
    @Column(name="pssfstyleid")
    private String pssfstyleid;
    @Column(name="pssfstylename")
    private String pssfstylename;
    @Column(name="pubobj")
    private String pubobj;
    @Column(name="pubobjtag")
    private String pubobjtag;
    @Column(name="pubobjtag2")
    private String pubobjtag2;
    @Column(name="target")
    private String target;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPpssfpubobjLock = new Integer(1);
    private PSSFPubOjb ppssfpubobj = null;
    private Integer objPSSFStyleLock = new Integer(1);
    private PSSFStyle pssfstyle = null;
    private Integer objPssfLock = new Integer(1);
    private PSSF pssf = null;

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

    public void setMacroParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMacroParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.macroparams = string;
        this.macroparamsDirtyFlag = true;
    }

    public String getMacroParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMacroParams();
        }
        return this.macroparams;
    }

    public boolean isMacroParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMacroParamsDirty();
        }
        return this.macroparamsDirtyFlag;
    }

    public void resetMacroParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMacroParams();
            return;
        }
        this.macroparamsDirtyFlag = false;
        this.macroparams = null;
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

    public void setPPSSFPubObjId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSSFPubObjId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppssfpubobjid = string;
        this.ppssfpubobjidDirtyFlag = true;
    }

    public String getPPSSFPubObjId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSSFPubObjId();
        }
        return this.ppssfpubobjid;
    }

    public boolean isPPSSFPubObjIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSSFPubObjIdDirty();
        }
        return this.ppssfpubobjidDirtyFlag;
    }

    public void resetPPSSFPubObjId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSSFPubObjId();
            return;
        }
        this.ppssfpubobjidDirtyFlag = false;
        this.ppssfpubobjid = null;
    }

    public void setPPSSFPubObjName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSSFPubObjName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppssfpubobjname = string;
        this.ppssfpubobjnameDirtyFlag = true;
    }

    public String getPPSSFPubObjName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSSFPubObjName();
        }
        return this.ppssfpubobjname;
    }

    public boolean isPPSSFPubObjNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSSFPubObjNameDirty();
        }
        return this.ppssfpubobjnameDirtyFlag;
    }

    public void resetPPSSFPubObjName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSSFPubObjName();
            return;
        }
        this.ppssfpubobjnameDirtyFlag = false;
        this.ppssfpubobjname = null;
    }

    public void setPSSFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfid = string;
        this.pssfidDirtyFlag = true;
    }

    public String getPSSFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFId();
        }
        return this.pssfid;
    }

    public boolean isPSSFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFIdDirty();
        }
        return this.pssfidDirtyFlag;
    }

    public void resetPSSFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFId();
            return;
        }
        this.pssfidDirtyFlag = false;
        this.pssfid = null;
    }

    public void setPSSFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfname = string;
        this.pssfnameDirtyFlag = true;
    }

    public String getPSSFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFName();
        }
        return this.pssfname;
    }

    public boolean isPSSFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFNameDirty();
        }
        return this.pssfnameDirtyFlag;
    }

    public void resetPSSFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFName();
            return;
        }
        this.pssfnameDirtyFlag = false;
        this.pssfname = null;
    }

    public void setPSSFPubObjId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFPubObjId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfpubobjid = string;
        this.pssfpubobjidDirtyFlag = true;
    }

    public String getPSSFPubObjId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFPubObjId();
        }
        return this.pssfpubobjid;
    }

    public boolean isPSSFPubObjIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFPubObjIdDirty();
        }
        return this.pssfpubobjidDirtyFlag;
    }

    public void resetPSSFPubObjId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFPubObjId();
            return;
        }
        this.pssfpubobjidDirtyFlag = false;
        this.pssfpubobjid = null;
    }

    public void setPSSFPubObjName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFPubObjName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfpubobjname = string;
        this.pssfpubobjnameDirtyFlag = true;
    }

    public String getPSSFPubObjName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFPubObjName();
        }
        return this.pssfpubobjname;
    }

    public boolean isPSSFPubObjNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFPubObjNameDirty();
        }
        return this.pssfpubobjnameDirtyFlag;
    }

    public void resetPSSFPubObjName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFPubObjName();
            return;
        }
        this.pssfpubobjnameDirtyFlag = false;
        this.pssfpubobjname = null;
    }

    public void setPSSFStyleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFStyleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfstyleid = string;
        this.pssfstyleidDirtyFlag = true;
    }

    public String getPSSFStyleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStyleId();
        }
        return this.pssfstyleid;
    }

    public boolean isPSSFStyleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFStyleIdDirty();
        }
        return this.pssfstyleidDirtyFlag;
    }

    public void resetPSSFStyleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFStyleId();
            return;
        }
        this.pssfstyleidDirtyFlag = false;
        this.pssfstyleid = null;
    }

    public void setPSSFStyleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFStyleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfstylename = string;
        this.pssfstylenameDirtyFlag = true;
    }

    public String getPSSFStyleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStyleName();
        }
        return this.pssfstylename;
    }

    public boolean isPSSFStyleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFStyleNameDirty();
        }
        return this.pssfstylenameDirtyFlag;
    }

    public void resetPSSFStyleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFStyleName();
            return;
        }
        this.pssfstylenameDirtyFlag = false;
        this.pssfstylename = null;
    }

    public void setPubObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPubObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pubobj = string;
        this.pubobjDirtyFlag = true;
    }

    public String getPubObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPubObj();
        }
        return this.pubobj;
    }

    public boolean isPubObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPubObjDirty();
        }
        return this.pubobjDirtyFlag;
    }

    public void resetPubObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPubObj();
            return;
        }
        this.pubobjDirtyFlag = false;
        this.pubobj = null;
    }

    public void setPubObjTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPubObjTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pubobjtag = string;
        this.pubobjtagDirtyFlag = true;
    }

    public String getPubObjTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPubObjTag();
        }
        return this.pubobjtag;
    }

    public boolean isPubObjTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPubObjTagDirty();
        }
        return this.pubobjtagDirtyFlag;
    }

    public void resetPubObjTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPubObjTag();
            return;
        }
        this.pubobjtagDirtyFlag = false;
        this.pubobjtag = null;
    }

    public void setPubObjTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPubObjTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pubobjtag2 = string;
        this.pubobjtag2DirtyFlag = true;
    }

    public String getPubObjTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPubObjTag2();
        }
        return this.pubobjtag2;
    }

    public boolean isPubObjTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPubObjTag2Dirty();
        }
        return this.pubobjtag2DirtyFlag;
    }

    public void resetPubObjTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPubObjTag2();
            return;
        }
        this.pubobjtag2DirtyFlag = false;
        this.pubobjtag2 = null;
    }

    public void setTarget(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTarget(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.target = string;
        this.targetDirtyFlag = true;
    }

    public String getTarget() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTarget();
        }
        return this.target;
    }

    public boolean isTargetDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTargetDirty();
        }
        return this.targetDirtyFlag;
    }

    public void resetTarget() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTarget();
            return;
        }
        this.targetDirtyFlag = false;
        this.target = null;
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
        PSSFPubOjbBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSFPubOjbBase pSSFPubOjbBase) {
        pSSFPubOjbBase.resetCreateDate();
        pSSFPubOjbBase.resetCreateMan();
        pSSFPubOjbBase.resetMacroParams();
        pSSFPubOjbBase.resetMemo();
        pSSFPubOjbBase.resetPPSSFPubObjId();
        pSSFPubOjbBase.resetPPSSFPubObjName();
        pSSFPubOjbBase.resetPSSFId();
        pSSFPubOjbBase.resetPSSFName();
        pSSFPubOjbBase.resetPSSFPubObjId();
        pSSFPubOjbBase.resetPSSFPubObjName();
        pSSFPubOjbBase.resetPSSFStyleId();
        pSSFPubOjbBase.resetPSSFStyleName();
        pSSFPubOjbBase.resetPubObj();
        pSSFPubOjbBase.resetPubObjTag();
        pSSFPubOjbBase.resetPubObjTag2();
        pSSFPubOjbBase.resetTarget();
        pSSFPubOjbBase.resetUpdateDate();
        pSSFPubOjbBase.resetUpdateMan();
        pSSFPubOjbBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isMacroParamsDirty()) {
            hashMap.put(FIELD_MACROPARAMS, this.getMacroParams());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPPSSFPubObjIdDirty()) {
            hashMap.put(FIELD_PPSSFPUBOBJID, this.getPPSSFPubObjId());
        }
        if (!bl || this.isPPSSFPubObjNameDirty()) {
            hashMap.put(FIELD_PPSSFPUBOBJNAME, this.getPPSSFPubObjName());
        }
        if (!bl || this.isPSSFIdDirty()) {
            hashMap.put(FIELD_PSSFID, this.getPSSFId());
        }
        if (!bl || this.isPSSFNameDirty()) {
            hashMap.put(FIELD_PSSFNAME, this.getPSSFName());
        }
        if (!bl || this.isPSSFPubObjIdDirty()) {
            hashMap.put(FIELD_PSSFPUBOBJID, this.getPSSFPubObjId());
        }
        if (!bl || this.isPSSFPubObjNameDirty()) {
            hashMap.put(FIELD_PSSFPUBOBJNAME, this.getPSSFPubObjName());
        }
        if (!bl || this.isPSSFStyleIdDirty()) {
            hashMap.put(FIELD_PSSFSTYLEID, this.getPSSFStyleId());
        }
        if (!bl || this.isPSSFStyleNameDirty()) {
            hashMap.put(FIELD_PSSFSTYLENAME, this.getPSSFStyleName());
        }
        if (!bl || this.isPubObjDirty()) {
            hashMap.put(FIELD_PUBOBJ, this.getPubObj());
        }
        if (!bl || this.isPubObjTagDirty()) {
            hashMap.put(FIELD_PUBOBJTAG, this.getPubObjTag());
        }
        if (!bl || this.isPubObjTag2Dirty()) {
            hashMap.put(FIELD_PUBOBJTAG2, this.getPubObjTag2());
        }
        if (!bl || this.isTargetDirty()) {
            hashMap.put(FIELD_TARGET, this.getTarget());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
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
        return PSSFPubOjbBase.get(this, n);
    }

    private static Object get(PSSFPubOjbBase pSSFPubOjbBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFPubOjbBase.getCreateDate();
            }
            case 1: {
                return pSSFPubOjbBase.getCreateMan();
            }
            case 2: {
                return pSSFPubOjbBase.getMacroParams();
            }
            case 3: {
                return pSSFPubOjbBase.getMemo();
            }
            case 4: {
                return pSSFPubOjbBase.getPPSSFPubObjId();
            }
            case 5: {
                return pSSFPubOjbBase.getPPSSFPubObjName();
            }
            case 6: {
                return pSSFPubOjbBase.getPSSFId();
            }
            case 7: {
                return pSSFPubOjbBase.getPSSFName();
            }
            case 8: {
                return pSSFPubOjbBase.getPSSFPubObjId();
            }
            case 9: {
                return pSSFPubOjbBase.getPSSFPubObjName();
            }
            case 10: {
                return pSSFPubOjbBase.getPSSFStyleId();
            }
            case 11: {
                return pSSFPubOjbBase.getPSSFStyleName();
            }
            case 12: {
                return pSSFPubOjbBase.getPubObj();
            }
            case 13: {
                return pSSFPubOjbBase.getPubObjTag();
            }
            case 14: {
                return pSSFPubOjbBase.getPubObjTag2();
            }
            case 15: {
                return pSSFPubOjbBase.getTarget();
            }
            case 16: {
                return pSSFPubOjbBase.getUpdateDate();
            }
            case 17: {
                return pSSFPubOjbBase.getUpdateMan();
            }
            case 18: {
                return pSSFPubOjbBase.getValidFlag();
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
        PSSFPubOjbBase.set(this, n, object);
    }

    private static void set(PSSFPubOjbBase pSSFPubOjbBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSFPubOjbBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSFPubOjbBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSFPubOjbBase.setMacroParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSFPubOjbBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSFPubOjbBase.setPPSSFPubObjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSFPubOjbBase.setPPSSFPubObjName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSFPubOjbBase.setPSSFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSFPubOjbBase.setPSSFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSFPubOjbBase.setPSSFPubObjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSFPubOjbBase.setPSSFPubObjName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSFPubOjbBase.setPSSFStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSFPubOjbBase.setPSSFStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSFPubOjbBase.setPubObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSFPubOjbBase.setPubObjTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSFPubOjbBase.setPubObjTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSFPubOjbBase.setTarget(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSFPubOjbBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 17: {
                pSSFPubOjbBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSFPubOjbBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSFPubOjbBase.isNull(this, n);
    }

    private static boolean isNull(PSSFPubOjbBase pSSFPubOjbBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFPubOjbBase.getCreateDate() == null;
            }
            case 1: {
                return pSSFPubOjbBase.getCreateMan() == null;
            }
            case 2: {
                return pSSFPubOjbBase.getMacroParams() == null;
            }
            case 3: {
                return pSSFPubOjbBase.getMemo() == null;
            }
            case 4: {
                return pSSFPubOjbBase.getPPSSFPubObjId() == null;
            }
            case 5: {
                return pSSFPubOjbBase.getPPSSFPubObjName() == null;
            }
            case 6: {
                return pSSFPubOjbBase.getPSSFId() == null;
            }
            case 7: {
                return pSSFPubOjbBase.getPSSFName() == null;
            }
            case 8: {
                return pSSFPubOjbBase.getPSSFPubObjId() == null;
            }
            case 9: {
                return pSSFPubOjbBase.getPSSFPubObjName() == null;
            }
            case 10: {
                return pSSFPubOjbBase.getPSSFStyleId() == null;
            }
            case 11: {
                return pSSFPubOjbBase.getPSSFStyleName() == null;
            }
            case 12: {
                return pSSFPubOjbBase.getPubObj() == null;
            }
            case 13: {
                return pSSFPubOjbBase.getPubObjTag() == null;
            }
            case 14: {
                return pSSFPubOjbBase.getPubObjTag2() == null;
            }
            case 15: {
                return pSSFPubOjbBase.getTarget() == null;
            }
            case 16: {
                return pSSFPubOjbBase.getUpdateDate() == null;
            }
            case 17: {
                return pSSFPubOjbBase.getUpdateMan() == null;
            }
            case 18: {
                return pSSFPubOjbBase.getValidFlag() == null;
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
        return PSSFPubOjbBase.contains(this, n);
    }

    private static boolean contains(PSSFPubOjbBase pSSFPubOjbBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFPubOjbBase.isCreateDateDirty();
            }
            case 1: {
                return pSSFPubOjbBase.isCreateManDirty();
            }
            case 2: {
                return pSSFPubOjbBase.isMacroParamsDirty();
            }
            case 3: {
                return pSSFPubOjbBase.isMemoDirty();
            }
            case 4: {
                return pSSFPubOjbBase.isPPSSFPubObjIdDirty();
            }
            case 5: {
                return pSSFPubOjbBase.isPPSSFPubObjNameDirty();
            }
            case 6: {
                return pSSFPubOjbBase.isPSSFIdDirty();
            }
            case 7: {
                return pSSFPubOjbBase.isPSSFNameDirty();
            }
            case 8: {
                return pSSFPubOjbBase.isPSSFPubObjIdDirty();
            }
            case 9: {
                return pSSFPubOjbBase.isPSSFPubObjNameDirty();
            }
            case 10: {
                return pSSFPubOjbBase.isPSSFStyleIdDirty();
            }
            case 11: {
                return pSSFPubOjbBase.isPSSFStyleNameDirty();
            }
            case 12: {
                return pSSFPubOjbBase.isPubObjDirty();
            }
            case 13: {
                return pSSFPubOjbBase.isPubObjTagDirty();
            }
            case 14: {
                return pSSFPubOjbBase.isPubObjTag2Dirty();
            }
            case 15: {
                return pSSFPubOjbBase.isTargetDirty();
            }
            case 16: {
                return pSSFPubOjbBase.isUpdateDateDirty();
            }
            case 17: {
                return pSSFPubOjbBase.isUpdateManDirty();
            }
            case 18: {
                return pSSFPubOjbBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSFPubOjbBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSFPubOjbBase pSSFPubOjbBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSFPubOjbBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSFPubOjbBase.getJSONValue((Object)pSSFPubOjbBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSFPubOjbBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSFPubOjbBase.getJSONValue((Object)pSSFPubOjbBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSFPubOjbBase.getMacroParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"macroparams", (Object)PSSFPubOjbBase.getJSONValue((Object)pSSFPubOjbBase.getMacroParams()), (boolean)false);
        }
        if (bl || pSSFPubOjbBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSFPubOjbBase.getJSONValue((Object)pSSFPubOjbBase.getMemo()), (boolean)false);
        }
        if (bl || pSSFPubOjbBase.getPPSSFPubObjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppssfpubobjid", (Object)PSSFPubOjbBase.getJSONValue((Object)pSSFPubOjbBase.getPPSSFPubObjId()), (boolean)false);
        }
        if (bl || pSSFPubOjbBase.getPPSSFPubObjName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppssfpubobjname", (Object)PSSFPubOjbBase.getJSONValue((Object)pSSFPubOjbBase.getPPSSFPubObjName()), (boolean)false);
        }
        if (bl || pSSFPubOjbBase.getPSSFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfid", (Object)PSSFPubOjbBase.getJSONValue((Object)pSSFPubOjbBase.getPSSFId()), (boolean)false);
        }
        if (bl || pSSFPubOjbBase.getPSSFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfname", (Object)PSSFPubOjbBase.getJSONValue((Object)pSSFPubOjbBase.getPSSFName()), (boolean)false);
        }
        if (bl || pSSFPubOjbBase.getPSSFPubObjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfpubobjid", (Object)PSSFPubOjbBase.getJSONValue((Object)pSSFPubOjbBase.getPSSFPubObjId()), (boolean)false);
        }
        if (bl || pSSFPubOjbBase.getPSSFPubObjName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfpubobjname", (Object)PSSFPubOjbBase.getJSONValue((Object)pSSFPubOjbBase.getPSSFPubObjName()), (boolean)false);
        }
        if (bl || pSSFPubOjbBase.getPSSFStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfstyleid", (Object)PSSFPubOjbBase.getJSONValue((Object)pSSFPubOjbBase.getPSSFStyleId()), (boolean)false);
        }
        if (bl || pSSFPubOjbBase.getPSSFStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfstylename", (Object)PSSFPubOjbBase.getJSONValue((Object)pSSFPubOjbBase.getPSSFStyleName()), (boolean)false);
        }
        if (bl || pSSFPubOjbBase.getPubObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pubobj", (Object)PSSFPubOjbBase.getJSONValue((Object)pSSFPubOjbBase.getPubObj()), (boolean)false);
        }
        if (bl || pSSFPubOjbBase.getPubObjTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pubobjtag", (Object)PSSFPubOjbBase.getJSONValue((Object)pSSFPubOjbBase.getPubObjTag()), (boolean)false);
        }
        if (bl || pSSFPubOjbBase.getPubObjTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pubobjtag2", (Object)PSSFPubOjbBase.getJSONValue((Object)pSSFPubOjbBase.getPubObjTag2()), (boolean)false);
        }
        if (bl || pSSFPubOjbBase.getTarget() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"target", (Object)PSSFPubOjbBase.getJSONValue((Object)pSSFPubOjbBase.getTarget()), (boolean)false);
        }
        if (bl || pSSFPubOjbBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSFPubOjbBase.getJSONValue((Object)pSSFPubOjbBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSFPubOjbBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSFPubOjbBase.getJSONValue((Object)pSSFPubOjbBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSFPubOjbBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSFPubOjbBase.getJSONValue((Object)pSSFPubOjbBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSFPubOjbBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSFPubOjbBase pSSFPubOjbBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSFPubOjbBase.getCreateDate() != null) {
            object = pSSFPubOjbBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSFPubOjbBase.getCreateMan() != null) {
            object = pSSFPubOjbBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSFPubOjbBase.getMacroParams() != null) {
            object = pSSFPubOjbBase.getMacroParams();
            xmlNode.setAttribute(FIELD_MACROPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSSFPubOjbBase.getMemo() != null) {
            object = pSSFPubOjbBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSFPubOjbBase.getPPSSFPubObjId() != null) {
            object = pSSFPubOjbBase.getPPSSFPubObjId();
            xmlNode.setAttribute(FIELD_PPSSFPUBOBJID, object == null ? "" : (String)object);
        }
        if (bl || pSSFPubOjbBase.getPPSSFPubObjName() != null) {
            object = pSSFPubOjbBase.getPPSSFPubObjName();
            xmlNode.setAttribute(FIELD_PPSSFPUBOBJNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFPubOjbBase.getPSSFId() != null) {
            object = pSSFPubOjbBase.getPSSFId();
            xmlNode.setAttribute(FIELD_PSSFID, object == null ? "" : (String)object);
        }
        if (bl || pSSFPubOjbBase.getPSSFName() != null) {
            object = pSSFPubOjbBase.getPSSFName();
            xmlNode.setAttribute(FIELD_PSSFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFPubOjbBase.getPSSFPubObjId() != null) {
            object = pSSFPubOjbBase.getPSSFPubObjId();
            xmlNode.setAttribute(FIELD_PSSFPUBOBJID, object == null ? "" : (String)object);
        }
        if (bl || pSSFPubOjbBase.getPSSFPubObjName() != null) {
            object = pSSFPubOjbBase.getPSSFPubObjName();
            xmlNode.setAttribute(FIELD_PSSFPUBOBJNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFPubOjbBase.getPSSFStyleId() != null) {
            object = pSSFPubOjbBase.getPSSFStyleId();
            xmlNode.setAttribute(FIELD_PSSFSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSSFPubOjbBase.getPSSFStyleName() != null) {
            object = pSSFPubOjbBase.getPSSFStyleName();
            xmlNode.setAttribute(FIELD_PSSFSTYLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFPubOjbBase.getPubObj() != null) {
            object = pSSFPubOjbBase.getPubObj();
            xmlNode.setAttribute(FIELD_PUBOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSSFPubOjbBase.getPubObjTag() != null) {
            object = pSSFPubOjbBase.getPubObjTag();
            xmlNode.setAttribute(FIELD_PUBOBJTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSFPubOjbBase.getPubObjTag2() != null) {
            object = pSSFPubOjbBase.getPubObjTag2();
            xmlNode.setAttribute(FIELD_PUBOBJTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSFPubOjbBase.getTarget() != null) {
            object = pSSFPubOjbBase.getTarget();
            xmlNode.setAttribute(FIELD_TARGET, object == null ? "" : (String)object);
        }
        if (bl || pSSFPubOjbBase.getUpdateDate() != null) {
            object = pSSFPubOjbBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSFPubOjbBase.getUpdateMan() != null) {
            object = pSSFPubOjbBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSFPubOjbBase.getValidFlag() != null) {
            object = pSSFPubOjbBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSFPubOjbBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSFPubOjbBase pSSFPubOjbBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSFPubOjbBase.isCreateDateDirty() && (bl || pSSFPubOjbBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSFPubOjbBase.getCreateDate());
        }
        if (pSSFPubOjbBase.isCreateManDirty() && (bl || pSSFPubOjbBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSFPubOjbBase.getCreateMan());
        }
        if (pSSFPubOjbBase.isMacroParamsDirty() && (bl || pSSFPubOjbBase.getMacroParams() != null)) {
            iDataObject.set(FIELD_MACROPARAMS, (Object)pSSFPubOjbBase.getMacroParams());
        }
        if (pSSFPubOjbBase.isMemoDirty() && (bl || pSSFPubOjbBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSFPubOjbBase.getMemo());
        }
        if (pSSFPubOjbBase.isPPSSFPubObjIdDirty() && (bl || pSSFPubOjbBase.getPPSSFPubObjId() != null)) {
            iDataObject.set(FIELD_PPSSFPUBOBJID, (Object)pSSFPubOjbBase.getPPSSFPubObjId());
        }
        if (pSSFPubOjbBase.isPPSSFPubObjNameDirty() && (bl || pSSFPubOjbBase.getPPSSFPubObjName() != null)) {
            iDataObject.set(FIELD_PPSSFPUBOBJNAME, (Object)pSSFPubOjbBase.getPPSSFPubObjName());
        }
        if (pSSFPubOjbBase.isPSSFIdDirty() && (bl || pSSFPubOjbBase.getPSSFId() != null)) {
            iDataObject.set(FIELD_PSSFID, (Object)pSSFPubOjbBase.getPSSFId());
        }
        if (pSSFPubOjbBase.isPSSFNameDirty() && (bl || pSSFPubOjbBase.getPSSFName() != null)) {
            iDataObject.set(FIELD_PSSFNAME, (Object)pSSFPubOjbBase.getPSSFName());
        }
        if (pSSFPubOjbBase.isPSSFPubObjIdDirty() && (bl || pSSFPubOjbBase.getPSSFPubObjId() != null)) {
            iDataObject.set(FIELD_PSSFPUBOBJID, (Object)pSSFPubOjbBase.getPSSFPubObjId());
        }
        if (pSSFPubOjbBase.isPSSFPubObjNameDirty() && (bl || pSSFPubOjbBase.getPSSFPubObjName() != null)) {
            iDataObject.set(FIELD_PSSFPUBOBJNAME, (Object)pSSFPubOjbBase.getPSSFPubObjName());
        }
        if (pSSFPubOjbBase.isPSSFStyleIdDirty() && (bl || pSSFPubOjbBase.getPSSFStyleId() != null)) {
            iDataObject.set(FIELD_PSSFSTYLEID, (Object)pSSFPubOjbBase.getPSSFStyleId());
        }
        if (pSSFPubOjbBase.isPSSFStyleNameDirty() && (bl || pSSFPubOjbBase.getPSSFStyleName() != null)) {
            iDataObject.set(FIELD_PSSFSTYLENAME, (Object)pSSFPubOjbBase.getPSSFStyleName());
        }
        if (pSSFPubOjbBase.isPubObjDirty() && (bl || pSSFPubOjbBase.getPubObj() != null)) {
            iDataObject.set(FIELD_PUBOBJ, (Object)pSSFPubOjbBase.getPubObj());
        }
        if (pSSFPubOjbBase.isPubObjTagDirty() && (bl || pSSFPubOjbBase.getPubObjTag() != null)) {
            iDataObject.set(FIELD_PUBOBJTAG, (Object)pSSFPubOjbBase.getPubObjTag());
        }
        if (pSSFPubOjbBase.isPubObjTag2Dirty() && (bl || pSSFPubOjbBase.getPubObjTag2() != null)) {
            iDataObject.set(FIELD_PUBOBJTAG2, (Object)pSSFPubOjbBase.getPubObjTag2());
        }
        if (pSSFPubOjbBase.isTargetDirty() && (bl || pSSFPubOjbBase.getTarget() != null)) {
            iDataObject.set(FIELD_TARGET, (Object)pSSFPubOjbBase.getTarget());
        }
        if (pSSFPubOjbBase.isUpdateDateDirty() && (bl || pSSFPubOjbBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSFPubOjbBase.getUpdateDate());
        }
        if (pSSFPubOjbBase.isUpdateManDirty() && (bl || pSSFPubOjbBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSFPubOjbBase.getUpdateMan());
        }
        if (pSSFPubOjbBase.isValidFlagDirty() && (bl || pSSFPubOjbBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSFPubOjbBase.getValidFlag());
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
        return PSSFPubOjbBase.remove(this, n);
    }

    private static boolean remove(PSSFPubOjbBase pSSFPubOjbBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSFPubOjbBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSFPubOjbBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSFPubOjbBase.resetMacroParams();
                return true;
            }
            case 3: {
                pSSFPubOjbBase.resetMemo();
                return true;
            }
            case 4: {
                pSSFPubOjbBase.resetPPSSFPubObjId();
                return true;
            }
            case 5: {
                pSSFPubOjbBase.resetPPSSFPubObjName();
                return true;
            }
            case 6: {
                pSSFPubOjbBase.resetPSSFId();
                return true;
            }
            case 7: {
                pSSFPubOjbBase.resetPSSFName();
                return true;
            }
            case 8: {
                pSSFPubOjbBase.resetPSSFPubObjId();
                return true;
            }
            case 9: {
                pSSFPubOjbBase.resetPSSFPubObjName();
                return true;
            }
            case 10: {
                pSSFPubOjbBase.resetPSSFStyleId();
                return true;
            }
            case 11: {
                pSSFPubOjbBase.resetPSSFStyleName();
                return true;
            }
            case 12: {
                pSSFPubOjbBase.resetPubObj();
                return true;
            }
            case 13: {
                pSSFPubOjbBase.resetPubObjTag();
                return true;
            }
            case 14: {
                pSSFPubOjbBase.resetPubObjTag2();
                return true;
            }
            case 15: {
                pSSFPubOjbBase.resetTarget();
                return true;
            }
            case 16: {
                pSSFPubOjbBase.resetUpdateDate();
                return true;
            }
            case 17: {
                pSSFPubOjbBase.resetUpdateMan();
                return true;
            }
            case 18: {
                pSSFPubOjbBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSFPubOjb getPpssfpubobj() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPpssfpubobj();
        }
        if (this.getPPSSFPubObjId() == null) {
            return null;
        }
        Integer n = this.objPpssfpubobjLock;
        synchronized (n) {
            if (this.ppssfpubobj != null && DataTypeHelper.compare((int)25, (Object)this.getPPSSFPubObjId(), (Object)this.ppssfpubobj.getPSSFPubObjId()) != 0L) {
                this.ppssfpubobj = null;
            }
            if (this.ppssfpubobj == null) {
                PSSFPubOjb pSSFPubOjb = new PSSFPubOjb();
                pSSFPubOjb.setPSSFPubObjId(this.getPPSSFPubObjId());
                PSSFPubOjbService pSSFPubOjbService = (PSSFPubOjbService)ServiceGlobal.getService(PSSFPubOjbService.class, (SessionFactory)this.getSessionFactory());
                pSSFPubOjbService.autoGet((IEntity)pSSFPubOjb);
                this.ppssfpubobj = pSSFPubOjb;
            }
            return this.ppssfpubobj;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSFStyle getPSSFStyle() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStyle();
        }
        if (this.getPSSFStyleId() == null) {
            return null;
        }
        Integer n = this.objPSSFStyleLock;
        synchronized (n) {
            if (this.pssfstyle != null && DataTypeHelper.compare((int)25, (Object)this.getPSSFStyleId(), (Object)this.pssfstyle.getPSSFStyleId()) != 0L) {
                this.pssfstyle = null;
            }
            if (this.pssfstyle == null) {
                PSSFStyle pSSFStyle = new PSSFStyle();
                pSSFStyle.setPSSFStyleId(this.getPSSFStyleId());
                PSSFStyleService pSSFStyleService = (PSSFStyleService)ServiceGlobal.getService(PSSFStyleService.class, (SessionFactory)this.getSessionFactory());
                pSSFStyleService.autoGet((IEntity)pSSFStyle);
                this.pssfstyle = pSSFStyle;
            }
            return this.pssfstyle;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSF getPssf() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPssf();
        }
        if (this.getPSSFId() == null) {
            return null;
        }
        Integer n = this.objPssfLock;
        synchronized (n) {
            if (this.pssf != null && DataTypeHelper.compare((int)25, (Object)this.getPSSFId(), (Object)this.pssf.getPSSFId()) != 0L) {
                this.pssf = null;
            }
            if (this.pssf == null) {
                PSSF pSSF = new PSSF();
                pSSF.setPSSFId(this.getPSSFId());
                PSSFService pSSFService = (PSSFService)ServiceGlobal.getService(PSSFService.class, (SessionFactory)this.getSessionFactory());
                pSSFService.autoGet((IEntity)pSSF);
                this.pssf = pSSF;
            }
            return this.pssf;
        }
    }

    private PSSFPubOjbBase getProxyEntity() {
        return this.proxyPSSFPubOjbBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSFPubOjbBase = null;
        if (iDataObject != null && iDataObject instanceof PSSFPubOjbBase) {
            this.proxyPSSFPubOjbBase = (PSSFPubOjbBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFPubOjbService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MACROPARAMS, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PPSSFPUBOBJID, 4);
        fieldIndexMap.put(FIELD_PPSSFPUBOBJNAME, 5);
        fieldIndexMap.put(FIELD_PSSFID, 6);
        fieldIndexMap.put(FIELD_PSSFNAME, 7);
        fieldIndexMap.put(FIELD_PSSFPUBOBJID, 8);
        fieldIndexMap.put(FIELD_PSSFPUBOBJNAME, 9);
        fieldIndexMap.put(FIELD_PSSFSTYLEID, 10);
        fieldIndexMap.put(FIELD_PSSFSTYLENAME, 11);
        fieldIndexMap.put(FIELD_PUBOBJ, 12);
        fieldIndexMap.put(FIELD_PUBOBJTAG, 13);
        fieldIndexMap.put(FIELD_PUBOBJTAG2, 14);
        fieldIndexMap.put(FIELD_TARGET, 15);
        fieldIndexMap.put(FIELD_UPDATEDATE, 16);
        fieldIndexMap.put(FIELD_UPDATEMAN, 17);
        fieldIndexMap.put(FIELD_VALIDFLAG, 18);
    }
}

