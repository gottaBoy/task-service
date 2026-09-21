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
import net.ibizsys.pscore.srv.config.entity.PSPF;
import net.ibizsys.pscore.srv.config.entity.PSPFPubObj;
import net.ibizsys.pscore.srv.config.entity.PSPFStyle;
import net.ibizsys.pscore.srv.config.service.PSPFPubObjService;
import net.ibizsys.pscore.srv.config.service.PSPFService;
import net.ibizsys.pscore.srv.config.service.PSPFStyleService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSPFPubObjBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSPFPubObjBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MACROPARAMS = "MACROPARAMS";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PPSPFPUBOBJID = "PPSPFPUBOBJID";
    public static final String FIELD_PPSPFPUBOBJNAME = "PPSPFPUBOBJNAME";
    public static final String FIELD_PSPFID = "PSPFID";
    public static final String FIELD_PSPFNAME = "PSPFNAME";
    public static final String FIELD_PSPFPUBOBJID = "PSPFPUBOBJID";
    public static final String FIELD_PSPFPUBOBJNAME = "PSPFPUBOBJNAME";
    public static final String FIELD_PSPFSTYLEID = "PSPFSTYLEID";
    public static final String FIELD_PSPFSTYLENAME = "PSPFSTYLENAME";
    public static final String FIELD_PUBOBJ = "PUBOBJ";
    public static final String FIELD_PUBOBJTAG = "PUBOBJTAG";
    public static final String FIELD_PUBOBJTAG2 = "PUBOBJTAG2";
    public static final String FIELD_TARGET = "TARGET";
    public static final String FIELD_TARGETTYPE = "TARGETTYPE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MACROPARAMS = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PPSPFPUBOBJID = 4;
    private static final int INDEX_PPSPFPUBOBJNAME = 5;
    private static final int INDEX_PSPFID = 6;
    private static final int INDEX_PSPFNAME = 7;
    private static final int INDEX_PSPFPUBOBJID = 8;
    private static final int INDEX_PSPFPUBOBJNAME = 9;
    private static final int INDEX_PSPFSTYLEID = 10;
    private static final int INDEX_PSPFSTYLENAME = 11;
    private static final int INDEX_PUBOBJ = 12;
    private static final int INDEX_PUBOBJTAG = 13;
    private static final int INDEX_PUBOBJTAG2 = 14;
    private static final int INDEX_TARGET = 15;
    private static final int INDEX_TARGETTYPE = 16;
    private static final int INDEX_UPDATEDATE = 17;
    private static final int INDEX_UPDATEMAN = 18;
    private static final int INDEX_VALIDFLAG = 19;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSPFPubObjBase proxyPSPFPubObjBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean macroparamsDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ppspfpubobjidDirtyFlag = false;
    private boolean ppspfpubobjnameDirtyFlag = false;
    private boolean pspfidDirtyFlag = false;
    private boolean pspfnameDirtyFlag = false;
    private boolean pspfpubobjidDirtyFlag = false;
    private boolean pspfpubobjnameDirtyFlag = false;
    private boolean pspfstyleidDirtyFlag = false;
    private boolean pspfstylenameDirtyFlag = false;
    private boolean pubobjDirtyFlag = false;
    private boolean pubobjtagDirtyFlag = false;
    private boolean pubobjtag2DirtyFlag = false;
    private boolean targetDirtyFlag = false;
    private boolean targettypeDirtyFlag = false;
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
    @Column(name="ppspfpubobjid")
    private String ppspfpubobjid;
    @Column(name="ppspfpubobjname")
    private String ppspfpubobjname;
    @Column(name="pspfid")
    private String pspfid;
    @Column(name="pspfname")
    private String pspfname;
    @Column(name="pspfpubobjid")
    private String pspfpubobjid;
    @Column(name="pspfpubobjname")
    private String pspfpubobjname;
    @Column(name="pspfstyleid")
    private String pspfstyleid;
    @Column(name="pspfstylename")
    private String pspfstylename;
    @Column(name="pubobj")
    private String pubobj;
    @Column(name="pubobjtag")
    private String pubobjtag;
    @Column(name="pubobjtag2")
    private String pubobjtag2;
    @Column(name="target")
    private String target;
    @Column(name="targettype")
    private String targettype;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPpspfpubobjLock = new Integer(1);
    private PSPFPubObj ppspfpubobj = null;
    private Integer objPSPFStyleLock = new Integer(1);
    private PSPFStyle pspfstyle = null;
    private Integer objPspfLock = new Integer(1);
    private PSPF pspf = null;

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

    public void setPPSPFPubObjId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSPFPubObjId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppspfpubobjid = string;
        this.ppspfpubobjidDirtyFlag = true;
    }

    public String getPPSPFPubObjId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSPFPubObjId();
        }
        return this.ppspfpubobjid;
    }

    public boolean isPPSPFPubObjIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSPFPubObjIdDirty();
        }
        return this.ppspfpubobjidDirtyFlag;
    }

    public void resetPPSPFPubObjId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSPFPubObjId();
            return;
        }
        this.ppspfpubobjidDirtyFlag = false;
        this.ppspfpubobjid = null;
    }

    public void setPPSPFPubObjName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSPFPubObjName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppspfpubobjname = string;
        this.ppspfpubobjnameDirtyFlag = true;
    }

    public String getPPSPFPubObjName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSPFPubObjName();
        }
        return this.ppspfpubobjname;
    }

    public boolean isPPSPFPubObjNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSPFPubObjNameDirty();
        }
        return this.ppspfpubobjnameDirtyFlag;
    }

    public void resetPPSPFPubObjName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSPFPubObjName();
            return;
        }
        this.ppspfpubobjnameDirtyFlag = false;
        this.ppspfpubobjname = null;
    }

    public void setPSPFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfid = string;
        this.pspfidDirtyFlag = true;
    }

    public String getPSPFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFId();
        }
        return this.pspfid;
    }

    public boolean isPSPFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFIdDirty();
        }
        return this.pspfidDirtyFlag;
    }

    public void resetPSPFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFId();
            return;
        }
        this.pspfidDirtyFlag = false;
        this.pspfid = null;
    }

    public void setPSPFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfname = string;
        this.pspfnameDirtyFlag = true;
    }

    public String getPSPFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFName();
        }
        return this.pspfname;
    }

    public boolean isPSPFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFNameDirty();
        }
        return this.pspfnameDirtyFlag;
    }

    public void resetPSPFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFName();
            return;
        }
        this.pspfnameDirtyFlag = false;
        this.pspfname = null;
    }

    public void setPSPFPubObjId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFPubObjId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfpubobjid = string;
        this.pspfpubobjidDirtyFlag = true;
    }

    public String getPSPFPubObjId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFPubObjId();
        }
        return this.pspfpubobjid;
    }

    public boolean isPSPFPubObjIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFPubObjIdDirty();
        }
        return this.pspfpubobjidDirtyFlag;
    }

    public void resetPSPFPubObjId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFPubObjId();
            return;
        }
        this.pspfpubobjidDirtyFlag = false;
        this.pspfpubobjid = null;
    }

    public void setPSPFPubObjName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFPubObjName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfpubobjname = string;
        this.pspfpubobjnameDirtyFlag = true;
    }

    public String getPSPFPubObjName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFPubObjName();
        }
        return this.pspfpubobjname;
    }

    public boolean isPSPFPubObjNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFPubObjNameDirty();
        }
        return this.pspfpubobjnameDirtyFlag;
    }

    public void resetPSPFPubObjName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFPubObjName();
            return;
        }
        this.pspfpubobjnameDirtyFlag = false;
        this.pspfpubobjname = null;
    }

    public void setPSPFStyleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFStyleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfstyleid = string;
        this.pspfstyleidDirtyFlag = true;
    }

    public String getPSPFStyleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFStyleId();
        }
        return this.pspfstyleid;
    }

    public boolean isPSPFStyleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFStyleIdDirty();
        }
        return this.pspfstyleidDirtyFlag;
    }

    public void resetPSPFStyleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFStyleId();
            return;
        }
        this.pspfstyleidDirtyFlag = false;
        this.pspfstyleid = null;
    }

    public void setPSPFStyleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFStyleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfstylename = string;
        this.pspfstylenameDirtyFlag = true;
    }

    public String getPSPFStyleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFStyleName();
        }
        return this.pspfstylename;
    }

    public boolean isPSPFStyleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFStyleNameDirty();
        }
        return this.pspfstylenameDirtyFlag;
    }

    public void resetPSPFStyleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFStyleName();
            return;
        }
        this.pspfstylenameDirtyFlag = false;
        this.pspfstylename = null;
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

    public void setTargetType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTargetType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.targettype = string;
        this.targettypeDirtyFlag = true;
    }

    public String getTargetType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTargetType();
        }
        return this.targettype;
    }

    public boolean isTargetTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTargetTypeDirty();
        }
        return this.targettypeDirtyFlag;
    }

    public void resetTargetType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTargetType();
            return;
        }
        this.targettypeDirtyFlag = false;
        this.targettype = null;
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
        PSPFPubObjBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSPFPubObjBase pSPFPubObjBase) {
        pSPFPubObjBase.resetCreateDate();
        pSPFPubObjBase.resetCreateMan();
        pSPFPubObjBase.resetMacroParams();
        pSPFPubObjBase.resetMemo();
        pSPFPubObjBase.resetPPSPFPubObjId();
        pSPFPubObjBase.resetPPSPFPubObjName();
        pSPFPubObjBase.resetPSPFId();
        pSPFPubObjBase.resetPSPFName();
        pSPFPubObjBase.resetPSPFPubObjId();
        pSPFPubObjBase.resetPSPFPubObjName();
        pSPFPubObjBase.resetPSPFStyleId();
        pSPFPubObjBase.resetPSPFStyleName();
        pSPFPubObjBase.resetPubObj();
        pSPFPubObjBase.resetPubObjTag();
        pSPFPubObjBase.resetPubObjTag2();
        pSPFPubObjBase.resetTarget();
        pSPFPubObjBase.resetTargetType();
        pSPFPubObjBase.resetUpdateDate();
        pSPFPubObjBase.resetUpdateMan();
        pSPFPubObjBase.resetValidFlag();
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
        if (!bl || this.isPPSPFPubObjIdDirty()) {
            hashMap.put(FIELD_PPSPFPUBOBJID, this.getPPSPFPubObjId());
        }
        if (!bl || this.isPPSPFPubObjNameDirty()) {
            hashMap.put(FIELD_PPSPFPUBOBJNAME, this.getPPSPFPubObjName());
        }
        if (!bl || this.isPSPFIdDirty()) {
            hashMap.put(FIELD_PSPFID, this.getPSPFId());
        }
        if (!bl || this.isPSPFNameDirty()) {
            hashMap.put(FIELD_PSPFNAME, this.getPSPFName());
        }
        if (!bl || this.isPSPFPubObjIdDirty()) {
            hashMap.put(FIELD_PSPFPUBOBJID, this.getPSPFPubObjId());
        }
        if (!bl || this.isPSPFPubObjNameDirty()) {
            hashMap.put(FIELD_PSPFPUBOBJNAME, this.getPSPFPubObjName());
        }
        if (!bl || this.isPSPFStyleIdDirty()) {
            hashMap.put(FIELD_PSPFSTYLEID, this.getPSPFStyleId());
        }
        if (!bl || this.isPSPFStyleNameDirty()) {
            hashMap.put(FIELD_PSPFSTYLENAME, this.getPSPFStyleName());
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
        if (!bl || this.isTargetTypeDirty()) {
            hashMap.put(FIELD_TARGETTYPE, this.getTargetType());
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
        return PSPFPubObjBase.get(this, n);
    }

    private static Object get(PSPFPubObjBase pSPFPubObjBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFPubObjBase.getCreateDate();
            }
            case 1: {
                return pSPFPubObjBase.getCreateMan();
            }
            case 2: {
                return pSPFPubObjBase.getMacroParams();
            }
            case 3: {
                return pSPFPubObjBase.getMemo();
            }
            case 4: {
                return pSPFPubObjBase.getPPSPFPubObjId();
            }
            case 5: {
                return pSPFPubObjBase.getPPSPFPubObjName();
            }
            case 6: {
                return pSPFPubObjBase.getPSPFId();
            }
            case 7: {
                return pSPFPubObjBase.getPSPFName();
            }
            case 8: {
                return pSPFPubObjBase.getPSPFPubObjId();
            }
            case 9: {
                return pSPFPubObjBase.getPSPFPubObjName();
            }
            case 10: {
                return pSPFPubObjBase.getPSPFStyleId();
            }
            case 11: {
                return pSPFPubObjBase.getPSPFStyleName();
            }
            case 12: {
                return pSPFPubObjBase.getPubObj();
            }
            case 13: {
                return pSPFPubObjBase.getPubObjTag();
            }
            case 14: {
                return pSPFPubObjBase.getPubObjTag2();
            }
            case 15: {
                return pSPFPubObjBase.getTarget();
            }
            case 16: {
                return pSPFPubObjBase.getTargetType();
            }
            case 17: {
                return pSPFPubObjBase.getUpdateDate();
            }
            case 18: {
                return pSPFPubObjBase.getUpdateMan();
            }
            case 19: {
                return pSPFPubObjBase.getValidFlag();
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
        PSPFPubObjBase.set(this, n, object);
    }

    private static void set(PSPFPubObjBase pSPFPubObjBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSPFPubObjBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSPFPubObjBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSPFPubObjBase.setMacroParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSPFPubObjBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSPFPubObjBase.setPPSPFPubObjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSPFPubObjBase.setPPSPFPubObjName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSPFPubObjBase.setPSPFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSPFPubObjBase.setPSPFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSPFPubObjBase.setPSPFPubObjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSPFPubObjBase.setPSPFPubObjName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSPFPubObjBase.setPSPFStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSPFPubObjBase.setPSPFStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSPFPubObjBase.setPubObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSPFPubObjBase.setPubObjTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSPFPubObjBase.setPubObjTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSPFPubObjBase.setTarget(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSPFPubObjBase.setTargetType(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSPFPubObjBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 18: {
                pSPFPubObjBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSPFPubObjBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSPFPubObjBase.isNull(this, n);
    }

    private static boolean isNull(PSPFPubObjBase pSPFPubObjBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFPubObjBase.getCreateDate() == null;
            }
            case 1: {
                return pSPFPubObjBase.getCreateMan() == null;
            }
            case 2: {
                return pSPFPubObjBase.getMacroParams() == null;
            }
            case 3: {
                return pSPFPubObjBase.getMemo() == null;
            }
            case 4: {
                return pSPFPubObjBase.getPPSPFPubObjId() == null;
            }
            case 5: {
                return pSPFPubObjBase.getPPSPFPubObjName() == null;
            }
            case 6: {
                return pSPFPubObjBase.getPSPFId() == null;
            }
            case 7: {
                return pSPFPubObjBase.getPSPFName() == null;
            }
            case 8: {
                return pSPFPubObjBase.getPSPFPubObjId() == null;
            }
            case 9: {
                return pSPFPubObjBase.getPSPFPubObjName() == null;
            }
            case 10: {
                return pSPFPubObjBase.getPSPFStyleId() == null;
            }
            case 11: {
                return pSPFPubObjBase.getPSPFStyleName() == null;
            }
            case 12: {
                return pSPFPubObjBase.getPubObj() == null;
            }
            case 13: {
                return pSPFPubObjBase.getPubObjTag() == null;
            }
            case 14: {
                return pSPFPubObjBase.getPubObjTag2() == null;
            }
            case 15: {
                return pSPFPubObjBase.getTarget() == null;
            }
            case 16: {
                return pSPFPubObjBase.getTargetType() == null;
            }
            case 17: {
                return pSPFPubObjBase.getUpdateDate() == null;
            }
            case 18: {
                return pSPFPubObjBase.getUpdateMan() == null;
            }
            case 19: {
                return pSPFPubObjBase.getValidFlag() == null;
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
        return PSPFPubObjBase.contains(this, n);
    }

    private static boolean contains(PSPFPubObjBase pSPFPubObjBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFPubObjBase.isCreateDateDirty();
            }
            case 1: {
                return pSPFPubObjBase.isCreateManDirty();
            }
            case 2: {
                return pSPFPubObjBase.isMacroParamsDirty();
            }
            case 3: {
                return pSPFPubObjBase.isMemoDirty();
            }
            case 4: {
                return pSPFPubObjBase.isPPSPFPubObjIdDirty();
            }
            case 5: {
                return pSPFPubObjBase.isPPSPFPubObjNameDirty();
            }
            case 6: {
                return pSPFPubObjBase.isPSPFIdDirty();
            }
            case 7: {
                return pSPFPubObjBase.isPSPFNameDirty();
            }
            case 8: {
                return pSPFPubObjBase.isPSPFPubObjIdDirty();
            }
            case 9: {
                return pSPFPubObjBase.isPSPFPubObjNameDirty();
            }
            case 10: {
                return pSPFPubObjBase.isPSPFStyleIdDirty();
            }
            case 11: {
                return pSPFPubObjBase.isPSPFStyleNameDirty();
            }
            case 12: {
                return pSPFPubObjBase.isPubObjDirty();
            }
            case 13: {
                return pSPFPubObjBase.isPubObjTagDirty();
            }
            case 14: {
                return pSPFPubObjBase.isPubObjTag2Dirty();
            }
            case 15: {
                return pSPFPubObjBase.isTargetDirty();
            }
            case 16: {
                return pSPFPubObjBase.isTargetTypeDirty();
            }
            case 17: {
                return pSPFPubObjBase.isUpdateDateDirty();
            }
            case 18: {
                return pSPFPubObjBase.isUpdateManDirty();
            }
            case 19: {
                return pSPFPubObjBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSPFPubObjBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSPFPubObjBase pSPFPubObjBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSPFPubObjBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSPFPubObjBase.getJSONValue((Object)pSPFPubObjBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSPFPubObjBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSPFPubObjBase.getJSONValue((Object)pSPFPubObjBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSPFPubObjBase.getMacroParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"macroparams", (Object)PSPFPubObjBase.getJSONValue((Object)pSPFPubObjBase.getMacroParams()), (boolean)false);
        }
        if (bl || pSPFPubObjBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSPFPubObjBase.getJSONValue((Object)pSPFPubObjBase.getMemo()), (boolean)false);
        }
        if (bl || pSPFPubObjBase.getPPSPFPubObjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppspfpubobjid", (Object)PSPFPubObjBase.getJSONValue((Object)pSPFPubObjBase.getPPSPFPubObjId()), (boolean)false);
        }
        if (bl || pSPFPubObjBase.getPPSPFPubObjName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppspfpubobjname", (Object)PSPFPubObjBase.getJSONValue((Object)pSPFPubObjBase.getPPSPFPubObjName()), (boolean)false);
        }
        if (bl || pSPFPubObjBase.getPSPFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfid", (Object)PSPFPubObjBase.getJSONValue((Object)pSPFPubObjBase.getPSPFId()), (boolean)false);
        }
        if (bl || pSPFPubObjBase.getPSPFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfname", (Object)PSPFPubObjBase.getJSONValue((Object)pSPFPubObjBase.getPSPFName()), (boolean)false);
        }
        if (bl || pSPFPubObjBase.getPSPFPubObjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpubobjid", (Object)PSPFPubObjBase.getJSONValue((Object)pSPFPubObjBase.getPSPFPubObjId()), (boolean)false);
        }
        if (bl || pSPFPubObjBase.getPSPFPubObjName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpubobjname", (Object)PSPFPubObjBase.getJSONValue((Object)pSPFPubObjBase.getPSPFPubObjName()), (boolean)false);
        }
        if (bl || pSPFPubObjBase.getPSPFStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfstyleid", (Object)PSPFPubObjBase.getJSONValue((Object)pSPFPubObjBase.getPSPFStyleId()), (boolean)false);
        }
        if (bl || pSPFPubObjBase.getPSPFStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfstylename", (Object)PSPFPubObjBase.getJSONValue((Object)pSPFPubObjBase.getPSPFStyleName()), (boolean)false);
        }
        if (bl || pSPFPubObjBase.getPubObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pubobj", (Object)PSPFPubObjBase.getJSONValue((Object)pSPFPubObjBase.getPubObj()), (boolean)false);
        }
        if (bl || pSPFPubObjBase.getPubObjTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pubobjtag", (Object)PSPFPubObjBase.getJSONValue((Object)pSPFPubObjBase.getPubObjTag()), (boolean)false);
        }
        if (bl || pSPFPubObjBase.getPubObjTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pubobjtag2", (Object)PSPFPubObjBase.getJSONValue((Object)pSPFPubObjBase.getPubObjTag2()), (boolean)false);
        }
        if (bl || pSPFPubObjBase.getTarget() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"target", (Object)PSPFPubObjBase.getJSONValue((Object)pSPFPubObjBase.getTarget()), (boolean)false);
        }
        if (bl || pSPFPubObjBase.getTargetType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"targettype", (Object)PSPFPubObjBase.getJSONValue((Object)pSPFPubObjBase.getTargetType()), (boolean)false);
        }
        if (bl || pSPFPubObjBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSPFPubObjBase.getJSONValue((Object)pSPFPubObjBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSPFPubObjBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSPFPubObjBase.getJSONValue((Object)pSPFPubObjBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSPFPubObjBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSPFPubObjBase.getJSONValue((Object)pSPFPubObjBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSPFPubObjBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSPFPubObjBase pSPFPubObjBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSPFPubObjBase.getCreateDate() != null) {
            object = pSPFPubObjBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPFPubObjBase.getCreateMan() != null) {
            object = pSPFPubObjBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSPFPubObjBase.getMacroParams() != null) {
            object = pSPFPubObjBase.getMacroParams();
            xmlNode.setAttribute(FIELD_MACROPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSPFPubObjBase.getMemo() != null) {
            object = pSPFPubObjBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSPFPubObjBase.getPPSPFPubObjId() != null) {
            object = pSPFPubObjBase.getPPSPFPubObjId();
            xmlNode.setAttribute(FIELD_PPSPFPUBOBJID, object == null ? "" : (String)object);
        }
        if (bl || pSPFPubObjBase.getPPSPFPubObjName() != null) {
            object = pSPFPubObjBase.getPPSPFPubObjName();
            xmlNode.setAttribute(FIELD_PPSPFPUBOBJNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFPubObjBase.getPSPFId() != null) {
            object = pSPFPubObjBase.getPSPFId();
            xmlNode.setAttribute(FIELD_PSPFID, object == null ? "" : (String)object);
        }
        if (bl || pSPFPubObjBase.getPSPFName() != null) {
            object = pSPFPubObjBase.getPSPFName();
            xmlNode.setAttribute(FIELD_PSPFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFPubObjBase.getPSPFPubObjId() != null) {
            object = pSPFPubObjBase.getPSPFPubObjId();
            xmlNode.setAttribute(FIELD_PSPFPUBOBJID, object == null ? "" : (String)object);
        }
        if (bl || pSPFPubObjBase.getPSPFPubObjName() != null) {
            object = pSPFPubObjBase.getPSPFPubObjName();
            xmlNode.setAttribute(FIELD_PSPFPUBOBJNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFPubObjBase.getPSPFStyleId() != null) {
            object = pSPFPubObjBase.getPSPFStyleId();
            xmlNode.setAttribute(FIELD_PSPFSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSPFPubObjBase.getPSPFStyleName() != null) {
            object = pSPFPubObjBase.getPSPFStyleName();
            xmlNode.setAttribute(FIELD_PSPFSTYLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFPubObjBase.getPubObj() != null) {
            object = pSPFPubObjBase.getPubObj();
            xmlNode.setAttribute(FIELD_PUBOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSPFPubObjBase.getPubObjTag() != null) {
            object = pSPFPubObjBase.getPubObjTag();
            xmlNode.setAttribute(FIELD_PUBOBJTAG, object == null ? "" : (String)object);
        }
        if (bl || pSPFPubObjBase.getPubObjTag2() != null) {
            object = pSPFPubObjBase.getPubObjTag2();
            xmlNode.setAttribute(FIELD_PUBOBJTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSPFPubObjBase.getTarget() != null) {
            object = pSPFPubObjBase.getTarget();
            xmlNode.setAttribute(FIELD_TARGET, object == null ? "" : (String)object);
        }
        if (bl || pSPFPubObjBase.getTargetType() != null) {
            object = pSPFPubObjBase.getTargetType();
            xmlNode.setAttribute(FIELD_TARGETTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSPFPubObjBase.getUpdateDate() != null) {
            object = pSPFPubObjBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPFPubObjBase.getUpdateMan() != null) {
            object = pSPFPubObjBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSPFPubObjBase.getValidFlag() != null) {
            object = pSPFPubObjBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSPFPubObjBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSPFPubObjBase pSPFPubObjBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSPFPubObjBase.isCreateDateDirty() && (bl || pSPFPubObjBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSPFPubObjBase.getCreateDate());
        }
        if (pSPFPubObjBase.isCreateManDirty() && (bl || pSPFPubObjBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSPFPubObjBase.getCreateMan());
        }
        if (pSPFPubObjBase.isMacroParamsDirty() && (bl || pSPFPubObjBase.getMacroParams() != null)) {
            iDataObject.set(FIELD_MACROPARAMS, (Object)pSPFPubObjBase.getMacroParams());
        }
        if (pSPFPubObjBase.isMemoDirty() && (bl || pSPFPubObjBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSPFPubObjBase.getMemo());
        }
        if (pSPFPubObjBase.isPPSPFPubObjIdDirty() && (bl || pSPFPubObjBase.getPPSPFPubObjId() != null)) {
            iDataObject.set(FIELD_PPSPFPUBOBJID, (Object)pSPFPubObjBase.getPPSPFPubObjId());
        }
        if (pSPFPubObjBase.isPPSPFPubObjNameDirty() && (bl || pSPFPubObjBase.getPPSPFPubObjName() != null)) {
            iDataObject.set(FIELD_PPSPFPUBOBJNAME, (Object)pSPFPubObjBase.getPPSPFPubObjName());
        }
        if (pSPFPubObjBase.isPSPFIdDirty() && (bl || pSPFPubObjBase.getPSPFId() != null)) {
            iDataObject.set(FIELD_PSPFID, (Object)pSPFPubObjBase.getPSPFId());
        }
        if (pSPFPubObjBase.isPSPFNameDirty() && (bl || pSPFPubObjBase.getPSPFName() != null)) {
            iDataObject.set(FIELD_PSPFNAME, (Object)pSPFPubObjBase.getPSPFName());
        }
        if (pSPFPubObjBase.isPSPFPubObjIdDirty() && (bl || pSPFPubObjBase.getPSPFPubObjId() != null)) {
            iDataObject.set(FIELD_PSPFPUBOBJID, (Object)pSPFPubObjBase.getPSPFPubObjId());
        }
        if (pSPFPubObjBase.isPSPFPubObjNameDirty() && (bl || pSPFPubObjBase.getPSPFPubObjName() != null)) {
            iDataObject.set(FIELD_PSPFPUBOBJNAME, (Object)pSPFPubObjBase.getPSPFPubObjName());
        }
        if (pSPFPubObjBase.isPSPFStyleIdDirty() && (bl || pSPFPubObjBase.getPSPFStyleId() != null)) {
            iDataObject.set(FIELD_PSPFSTYLEID, (Object)pSPFPubObjBase.getPSPFStyleId());
        }
        if (pSPFPubObjBase.isPSPFStyleNameDirty() && (bl || pSPFPubObjBase.getPSPFStyleName() != null)) {
            iDataObject.set(FIELD_PSPFSTYLENAME, (Object)pSPFPubObjBase.getPSPFStyleName());
        }
        if (pSPFPubObjBase.isPubObjDirty() && (bl || pSPFPubObjBase.getPubObj() != null)) {
            iDataObject.set(FIELD_PUBOBJ, (Object)pSPFPubObjBase.getPubObj());
        }
        if (pSPFPubObjBase.isPubObjTagDirty() && (bl || pSPFPubObjBase.getPubObjTag() != null)) {
            iDataObject.set(FIELD_PUBOBJTAG, (Object)pSPFPubObjBase.getPubObjTag());
        }
        if (pSPFPubObjBase.isPubObjTag2Dirty() && (bl || pSPFPubObjBase.getPubObjTag2() != null)) {
            iDataObject.set(FIELD_PUBOBJTAG2, (Object)pSPFPubObjBase.getPubObjTag2());
        }
        if (pSPFPubObjBase.isTargetDirty() && (bl || pSPFPubObjBase.getTarget() != null)) {
            iDataObject.set(FIELD_TARGET, (Object)pSPFPubObjBase.getTarget());
        }
        if (pSPFPubObjBase.isTargetTypeDirty() && (bl || pSPFPubObjBase.getTargetType() != null)) {
            iDataObject.set(FIELD_TARGETTYPE, (Object)pSPFPubObjBase.getTargetType());
        }
        if (pSPFPubObjBase.isUpdateDateDirty() && (bl || pSPFPubObjBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSPFPubObjBase.getUpdateDate());
        }
        if (pSPFPubObjBase.isUpdateManDirty() && (bl || pSPFPubObjBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSPFPubObjBase.getUpdateMan());
        }
        if (pSPFPubObjBase.isValidFlagDirty() && (bl || pSPFPubObjBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSPFPubObjBase.getValidFlag());
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
        return PSPFPubObjBase.remove(this, n);
    }

    private static boolean remove(PSPFPubObjBase pSPFPubObjBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSPFPubObjBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSPFPubObjBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSPFPubObjBase.resetMacroParams();
                return true;
            }
            case 3: {
                pSPFPubObjBase.resetMemo();
                return true;
            }
            case 4: {
                pSPFPubObjBase.resetPPSPFPubObjId();
                return true;
            }
            case 5: {
                pSPFPubObjBase.resetPPSPFPubObjName();
                return true;
            }
            case 6: {
                pSPFPubObjBase.resetPSPFId();
                return true;
            }
            case 7: {
                pSPFPubObjBase.resetPSPFName();
                return true;
            }
            case 8: {
                pSPFPubObjBase.resetPSPFPubObjId();
                return true;
            }
            case 9: {
                pSPFPubObjBase.resetPSPFPubObjName();
                return true;
            }
            case 10: {
                pSPFPubObjBase.resetPSPFStyleId();
                return true;
            }
            case 11: {
                pSPFPubObjBase.resetPSPFStyleName();
                return true;
            }
            case 12: {
                pSPFPubObjBase.resetPubObj();
                return true;
            }
            case 13: {
                pSPFPubObjBase.resetPubObjTag();
                return true;
            }
            case 14: {
                pSPFPubObjBase.resetPubObjTag2();
                return true;
            }
            case 15: {
                pSPFPubObjBase.resetTarget();
                return true;
            }
            case 16: {
                pSPFPubObjBase.resetTargetType();
                return true;
            }
            case 17: {
                pSPFPubObjBase.resetUpdateDate();
                return true;
            }
            case 18: {
                pSPFPubObjBase.resetUpdateMan();
                return true;
            }
            case 19: {
                pSPFPubObjBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSPFPubObj getPpspfpubobj() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPpspfpubobj();
        }
        if (this.getPPSPFPubObjId() == null) {
            return null;
        }
        Integer n = this.objPpspfpubobjLock;
        synchronized (n) {
            if (this.ppspfpubobj != null && DataTypeHelper.compare((int)25, (Object)this.getPPSPFPubObjId(), (Object)this.ppspfpubobj.getPSPFPubObjId()) != 0L) {
                this.ppspfpubobj = null;
            }
            if (this.ppspfpubobj == null) {
                PSPFPubObj pSPFPubObj = new PSPFPubObj();
                pSPFPubObj.setPSPFPubObjId(this.getPPSPFPubObjId());
                PSPFPubObjService pSPFPubObjService = (PSPFPubObjService)ServiceGlobal.getService(PSPFPubObjService.class, (SessionFactory)this.getSessionFactory());
                pSPFPubObjService.autoGet((IEntity)pSPFPubObj);
                this.ppspfpubobj = pSPFPubObj;
            }
            return this.ppspfpubobj;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSPFStyle getPSPFStyle() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFStyle();
        }
        if (this.getPSPFStyleId() == null) {
            return null;
        }
        Integer n = this.objPSPFStyleLock;
        synchronized (n) {
            if (this.pspfstyle != null && DataTypeHelper.compare((int)25, (Object)this.getPSPFStyleId(), (Object)this.pspfstyle.getPSPFStyleId()) != 0L) {
                this.pspfstyle = null;
            }
            if (this.pspfstyle == null) {
                PSPFStyle pSPFStyle = new PSPFStyle();
                pSPFStyle.setPSPFStyleId(this.getPSPFStyleId());
                PSPFStyleService pSPFStyleService = (PSPFStyleService)ServiceGlobal.getService(PSPFStyleService.class, (SessionFactory)this.getSessionFactory());
                pSPFStyleService.autoGet((IEntity)pSPFStyle);
                this.pspfstyle = pSPFStyle;
            }
            return this.pspfstyle;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSPF getPspf() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPspf();
        }
        if (this.getPSPFId() == null) {
            return null;
        }
        Integer n = this.objPspfLock;
        synchronized (n) {
            if (this.pspf != null && DataTypeHelper.compare((int)25, (Object)this.getPSPFId(), (Object)this.pspf.getPSPFId()) != 0L) {
                this.pspf = null;
            }
            if (this.pspf == null) {
                PSPF pSPF = new PSPF();
                pSPF.setPSPFId(this.getPSPFId());
                PSPFService pSPFService = (PSPFService)ServiceGlobal.getService(PSPFService.class, (SessionFactory)this.getSessionFactory());
                pSPFService.autoGet((IEntity)pSPF);
                this.pspf = pSPF;
            }
            return this.pspf;
        }
    }

    private PSPFPubObjBase getProxyEntity() {
        return this.proxyPSPFPubObjBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSPFPubObjBase = null;
        if (iDataObject != null && iDataObject instanceof PSPFPubObjBase) {
            this.proxyPSPFPubObjBase = (PSPFPubObjBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFPubObjService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MACROPARAMS, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PPSPFPUBOBJID, 4);
        fieldIndexMap.put(FIELD_PPSPFPUBOBJNAME, 5);
        fieldIndexMap.put(FIELD_PSPFID, 6);
        fieldIndexMap.put(FIELD_PSPFNAME, 7);
        fieldIndexMap.put(FIELD_PSPFPUBOBJID, 8);
        fieldIndexMap.put(FIELD_PSPFPUBOBJNAME, 9);
        fieldIndexMap.put(FIELD_PSPFSTYLEID, 10);
        fieldIndexMap.put(FIELD_PSPFSTYLENAME, 11);
        fieldIndexMap.put(FIELD_PUBOBJ, 12);
        fieldIndexMap.put(FIELD_PUBOBJTAG, 13);
        fieldIndexMap.put(FIELD_PUBOBJTAG2, 14);
        fieldIndexMap.put(FIELD_TARGET, 15);
        fieldIndexMap.put(FIELD_TARGETTYPE, 16);
        fieldIndexMap.put(FIELD_UPDATEDATE, 17);
        fieldIndexMap.put(FIELD_UPDATEMAN, 18);
        fieldIndexMap.put(FIELD_VALIDFLAG, 19);
    }
}

