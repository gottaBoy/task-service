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
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFVersion;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWorkflow;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFVersionService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWorkflowService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSWFSubWFBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSWFSubWFBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_ENABLE = "ENABLE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSWFID = "PSWFID";
    public static final String FIELD_PSWFNAME = "PSWFNAME";
    public static final String FIELD_PSWFSUBWFID = "PSWFSUBWFID";
    public static final String FIELD_PSWFSUBWFNAME = "PSWFSUBWFNAME";
    public static final String FIELD_SUBPSWFID = "SUBPSWFID";
    public static final String FIELD_SUBPSWFNAME = "SUBPSWFNAME";
    public static final String FIELD_SUBPSWFVERID = "SUBPSWFVERID";
    public static final String FIELD_SUBPSWFVERNAME = "SUBPSWFVERNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_DYNAMODELFLAG = 3;
    private static final int INDEX_ENABLE = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_PSDYNAINSTID = 6;
    private static final int INDEX_PSWFID = 7;
    private static final int INDEX_PSWFNAME = 8;
    private static final int INDEX_PSWFSUBWFID = 9;
    private static final int INDEX_PSWFSUBWFNAME = 10;
    private static final int INDEX_SUBPSWFID = 11;
    private static final int INDEX_SUBPSWFNAME = 12;
    private static final int INDEX_SUBPSWFVERID = 13;
    private static final int INDEX_SUBPSWFVERNAME = 14;
    private static final int INDEX_UPDATEDATE = 15;
    private static final int INDEX_UPDATEMAN = 16;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSWFSubWFBase proxyPSWFSubWFBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean enableDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean pswfidDirtyFlag = false;
    private boolean pswfnameDirtyFlag = false;
    private boolean pswfsubwfidDirtyFlag = false;
    private boolean pswfsubwfnameDirtyFlag = false;
    private boolean subpswfidDirtyFlag = false;
    private boolean subpswfnameDirtyFlag = false;
    private boolean subpswfveridDirtyFlag = false;
    private boolean subpswfvernameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="enable")
    private Integer enable;
    @Column(name="memo")
    private String memo;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="pswfid")
    private String pswfid;
    @Column(name="pswfname")
    private String pswfname;
    @Column(name="pswfsubwfid")
    private String pswfsubwfid;
    @Column(name="pswfsubwfname")
    private String pswfsubwfname;
    @Column(name="subpswfid")
    private String subpswfid;
    @Column(name="subpswfname")
    private String subpswfname;
    @Column(name="subpswfverid")
    private String subpswfverid;
    @Column(name="subpswfvername")
    private String subpswfvername;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objSubPSWFVerLock = new Integer(1);
    private PSWFVersion subpswfver = null;
    private Integer objPSWFLock = new Integer(1);
    private PSWorkflow pswf = null;
    private Integer objSubPSWFLock = new Integer(1);
    private PSWorkflow subpswf = null;

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

    public void setEnable(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnable(n);
            return;
        }
        this.enable = n;
        this.enableDirtyFlag = true;
    }

    public Integer getEnable() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnable();
        }
        return this.enable;
    }

    public boolean isEnableDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableDirty();
        }
        return this.enableDirtyFlag;
    }

    public void resetEnable() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnable();
            return;
        }
        this.enableDirtyFlag = false;
        this.enable = null;
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

    public void setPSWFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfid = string;
        this.pswfidDirtyFlag = true;
    }

    public String getPSWFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFId();
        }
        return this.pswfid;
    }

    public boolean isPSWFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFIdDirty();
        }
        return this.pswfidDirtyFlag;
    }

    public void resetPSWFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFId();
            return;
        }
        this.pswfidDirtyFlag = false;
        this.pswfid = null;
    }

    public void setPSWFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfname = string;
        this.pswfnameDirtyFlag = true;
    }

    public String getPSWFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFName();
        }
        return this.pswfname;
    }

    public boolean isPSWFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFNameDirty();
        }
        return this.pswfnameDirtyFlag;
    }

    public void resetPSWFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFName();
            return;
        }
        this.pswfnameDirtyFlag = false;
        this.pswfname = null;
    }

    public void setPSWFSubWFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFSubWFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfsubwfid = string;
        this.pswfsubwfidDirtyFlag = true;
    }

    public String getPSWFSubWFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFSubWFId();
        }
        return this.pswfsubwfid;
    }

    public boolean isPSWFSubWFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFSubWFIdDirty();
        }
        return this.pswfsubwfidDirtyFlag;
    }

    public void resetPSWFSubWFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFSubWFId();
            return;
        }
        this.pswfsubwfidDirtyFlag = false;
        this.pswfsubwfid = null;
    }

    public void setPSWFSubWFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFSubWFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfsubwfname = string;
        this.pswfsubwfnameDirtyFlag = true;
    }

    public String getPSWFSubWFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFSubWFName();
        }
        return this.pswfsubwfname;
    }

    public boolean isPSWFSubWFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFSubWFNameDirty();
        }
        return this.pswfsubwfnameDirtyFlag;
    }

    public void resetPSWFSubWFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFSubWFName();
            return;
        }
        this.pswfsubwfnameDirtyFlag = false;
        this.pswfsubwfname = null;
    }

    public void setSubPSWFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSubPSWFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.subpswfid = string;
        this.subpswfidDirtyFlag = true;
    }

    public String getSubPSWFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSubPSWFId();
        }
        return this.subpswfid;
    }

    public boolean isSubPSWFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSubPSWFIdDirty();
        }
        return this.subpswfidDirtyFlag;
    }

    public void resetSubPSWFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSubPSWFId();
            return;
        }
        this.subpswfidDirtyFlag = false;
        this.subpswfid = null;
    }

    public void setSubPSWFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSubPSWFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.subpswfname = string;
        this.subpswfnameDirtyFlag = true;
    }

    public String getSubPSWFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSubPSWFName();
        }
        return this.subpswfname;
    }

    public boolean isSubPSWFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSubPSWFNameDirty();
        }
        return this.subpswfnameDirtyFlag;
    }

    public void resetSubPSWFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSubPSWFName();
            return;
        }
        this.subpswfnameDirtyFlag = false;
        this.subpswfname = null;
    }

    public void setSubPSWFVerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSubPSWFVerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.subpswfverid = string;
        this.subpswfveridDirtyFlag = true;
    }

    public String getSubPSWFVerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSubPSWFVerId();
        }
        return this.subpswfverid;
    }

    public boolean isSubPSWFVerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSubPSWFVerIdDirty();
        }
        return this.subpswfveridDirtyFlag;
    }

    public void resetSubPSWFVerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSubPSWFVerId();
            return;
        }
        this.subpswfveridDirtyFlag = false;
        this.subpswfverid = null;
    }

    public void setSubPSWFVerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSubPSWFVerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.subpswfvername = string;
        this.subpswfvernameDirtyFlag = true;
    }

    public String getSubPSWFVerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSubPSWFVerName();
        }
        return this.subpswfvername;
    }

    public boolean isSubPSWFVerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSubPSWFVerNameDirty();
        }
        return this.subpswfvernameDirtyFlag;
    }

    public void resetSubPSWFVerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSubPSWFVerName();
            return;
        }
        this.subpswfvernameDirtyFlag = false;
        this.subpswfvername = null;
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

    protected void onReset() {
        PSWFSubWFBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSWFSubWFBase pSWFSubWFBase) {
        pSWFSubWFBase.resetCodeName();
        pSWFSubWFBase.resetCreateDate();
        pSWFSubWFBase.resetCreateMan();
        pSWFSubWFBase.resetDynaModelFlag();
        pSWFSubWFBase.resetEnable();
        pSWFSubWFBase.resetMemo();
        pSWFSubWFBase.resetPSDynaInstId();
        pSWFSubWFBase.resetPSWFId();
        pSWFSubWFBase.resetPSWFName();
        pSWFSubWFBase.resetPSWFSubWFId();
        pSWFSubWFBase.resetPSWFSubWFName();
        pSWFSubWFBase.resetSubPSWFId();
        pSWFSubWFBase.resetSubPSWFName();
        pSWFSubWFBase.resetSubPSWFVerId();
        pSWFSubWFBase.resetSubPSWFVerName();
        pSWFSubWFBase.resetUpdateDate();
        pSWFSubWFBase.resetUpdateMan();
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
        if (!bl || this.isDynaModelFlagDirty()) {
            hashMap.put(FIELD_DYNAMODELFLAG, this.getDynaModelFlag());
        }
        if (!bl || this.isEnableDirty()) {
            hashMap.put(FIELD_ENABLE, this.getEnable());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSWFIdDirty()) {
            hashMap.put(FIELD_PSWFID, this.getPSWFId());
        }
        if (!bl || this.isPSWFNameDirty()) {
            hashMap.put(FIELD_PSWFNAME, this.getPSWFName());
        }
        if (!bl || this.isPSWFSubWFIdDirty()) {
            hashMap.put(FIELD_PSWFSUBWFID, this.getPSWFSubWFId());
        }
        if (!bl || this.isPSWFSubWFNameDirty()) {
            hashMap.put(FIELD_PSWFSUBWFNAME, this.getPSWFSubWFName());
        }
        if (!bl || this.isSubPSWFIdDirty()) {
            hashMap.put(FIELD_SUBPSWFID, this.getSubPSWFId());
        }
        if (!bl || this.isSubPSWFNameDirty()) {
            hashMap.put(FIELD_SUBPSWFNAME, this.getSubPSWFName());
        }
        if (!bl || this.isSubPSWFVerIdDirty()) {
            hashMap.put(FIELD_SUBPSWFVERID, this.getSubPSWFVerId());
        }
        if (!bl || this.isSubPSWFVerNameDirty()) {
            hashMap.put(FIELD_SUBPSWFVERNAME, this.getSubPSWFVerName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
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
        return PSWFSubWFBase.get(this, n);
    }

    private static Object get(PSWFSubWFBase pSWFSubWFBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWFSubWFBase.getCodeName();
            }
            case 1: {
                return pSWFSubWFBase.getCreateDate();
            }
            case 2: {
                return pSWFSubWFBase.getCreateMan();
            }
            case 3: {
                return pSWFSubWFBase.getDynaModelFlag();
            }
            case 4: {
                return pSWFSubWFBase.getEnable();
            }
            case 5: {
                return pSWFSubWFBase.getMemo();
            }
            case 6: {
                return pSWFSubWFBase.getPSDynaInstId();
            }
            case 7: {
                return pSWFSubWFBase.getPSWFId();
            }
            case 8: {
                return pSWFSubWFBase.getPSWFName();
            }
            case 9: {
                return pSWFSubWFBase.getPSWFSubWFId();
            }
            case 10: {
                return pSWFSubWFBase.getPSWFSubWFName();
            }
            case 11: {
                return pSWFSubWFBase.getSubPSWFId();
            }
            case 12: {
                return pSWFSubWFBase.getSubPSWFName();
            }
            case 13: {
                return pSWFSubWFBase.getSubPSWFVerId();
            }
            case 14: {
                return pSWFSubWFBase.getSubPSWFVerName();
            }
            case 15: {
                return pSWFSubWFBase.getUpdateDate();
            }
            case 16: {
                return pSWFSubWFBase.getUpdateMan();
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
        PSWFSubWFBase.set(this, n, object);
    }

    private static void set(PSWFSubWFBase pSWFSubWFBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSWFSubWFBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSWFSubWFBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSWFSubWFBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSWFSubWFBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSWFSubWFBase.setEnable(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSWFSubWFBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSWFSubWFBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSWFSubWFBase.setPSWFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSWFSubWFBase.setPSWFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSWFSubWFBase.setPSWFSubWFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSWFSubWFBase.setPSWFSubWFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSWFSubWFBase.setSubPSWFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSWFSubWFBase.setSubPSWFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSWFSubWFBase.setSubPSWFVerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSWFSubWFBase.setSubPSWFVerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSWFSubWFBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 16: {
                pSWFSubWFBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSWFSubWFBase.isNull(this, n);
    }

    private static boolean isNull(PSWFSubWFBase pSWFSubWFBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWFSubWFBase.getCodeName() == null;
            }
            case 1: {
                return pSWFSubWFBase.getCreateDate() == null;
            }
            case 2: {
                return pSWFSubWFBase.getCreateMan() == null;
            }
            case 3: {
                return pSWFSubWFBase.getDynaModelFlag() == null;
            }
            case 4: {
                return pSWFSubWFBase.getEnable() == null;
            }
            case 5: {
                return pSWFSubWFBase.getMemo() == null;
            }
            case 6: {
                return pSWFSubWFBase.getPSDynaInstId() == null;
            }
            case 7: {
                return pSWFSubWFBase.getPSWFId() == null;
            }
            case 8: {
                return pSWFSubWFBase.getPSWFName() == null;
            }
            case 9: {
                return pSWFSubWFBase.getPSWFSubWFId() == null;
            }
            case 10: {
                return pSWFSubWFBase.getPSWFSubWFName() == null;
            }
            case 11: {
                return pSWFSubWFBase.getSubPSWFId() == null;
            }
            case 12: {
                return pSWFSubWFBase.getSubPSWFName() == null;
            }
            case 13: {
                return pSWFSubWFBase.getSubPSWFVerId() == null;
            }
            case 14: {
                return pSWFSubWFBase.getSubPSWFVerName() == null;
            }
            case 15: {
                return pSWFSubWFBase.getUpdateDate() == null;
            }
            case 16: {
                return pSWFSubWFBase.getUpdateMan() == null;
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
        return PSWFSubWFBase.contains(this, n);
    }

    private static boolean contains(PSWFSubWFBase pSWFSubWFBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWFSubWFBase.isCodeNameDirty();
            }
            case 1: {
                return pSWFSubWFBase.isCreateDateDirty();
            }
            case 2: {
                return pSWFSubWFBase.isCreateManDirty();
            }
            case 3: {
                return pSWFSubWFBase.isDynaModelFlagDirty();
            }
            case 4: {
                return pSWFSubWFBase.isEnableDirty();
            }
            case 5: {
                return pSWFSubWFBase.isMemoDirty();
            }
            case 6: {
                return pSWFSubWFBase.isPSDynaInstIdDirty();
            }
            case 7: {
                return pSWFSubWFBase.isPSWFIdDirty();
            }
            case 8: {
                return pSWFSubWFBase.isPSWFNameDirty();
            }
            case 9: {
                return pSWFSubWFBase.isPSWFSubWFIdDirty();
            }
            case 10: {
                return pSWFSubWFBase.isPSWFSubWFNameDirty();
            }
            case 11: {
                return pSWFSubWFBase.isSubPSWFIdDirty();
            }
            case 12: {
                return pSWFSubWFBase.isSubPSWFNameDirty();
            }
            case 13: {
                return pSWFSubWFBase.isSubPSWFVerIdDirty();
            }
            case 14: {
                return pSWFSubWFBase.isSubPSWFVerNameDirty();
            }
            case 15: {
                return pSWFSubWFBase.isUpdateDateDirty();
            }
            case 16: {
                return pSWFSubWFBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSWFSubWFBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSWFSubWFBase pSWFSubWFBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSWFSubWFBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSWFSubWFBase.getJSONValue((Object)pSWFSubWFBase.getCodeName()), (boolean)false);
        }
        if (bl || pSWFSubWFBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSWFSubWFBase.getJSONValue((Object)pSWFSubWFBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSWFSubWFBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSWFSubWFBase.getJSONValue((Object)pSWFSubWFBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSWFSubWFBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSWFSubWFBase.getJSONValue((Object)pSWFSubWFBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSWFSubWFBase.getEnable() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enable", (Object)PSWFSubWFBase.getJSONValue((Object)pSWFSubWFBase.getEnable()), (boolean)false);
        }
        if (bl || pSWFSubWFBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSWFSubWFBase.getJSONValue((Object)pSWFSubWFBase.getMemo()), (boolean)false);
        }
        if (bl || pSWFSubWFBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSWFSubWFBase.getJSONValue((Object)pSWFSubWFBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSWFSubWFBase.getPSWFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfid", (Object)PSWFSubWFBase.getJSONValue((Object)pSWFSubWFBase.getPSWFId()), (boolean)false);
        }
        if (bl || pSWFSubWFBase.getPSWFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfname", (Object)PSWFSubWFBase.getJSONValue((Object)pSWFSubWFBase.getPSWFName()), (boolean)false);
        }
        if (bl || pSWFSubWFBase.getPSWFSubWFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfsubwfid", (Object)PSWFSubWFBase.getJSONValue((Object)pSWFSubWFBase.getPSWFSubWFId()), (boolean)false);
        }
        if (bl || pSWFSubWFBase.getPSWFSubWFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfsubwfname", (Object)PSWFSubWFBase.getJSONValue((Object)pSWFSubWFBase.getPSWFSubWFName()), (boolean)false);
        }
        if (bl || pSWFSubWFBase.getSubPSWFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"subpswfid", (Object)PSWFSubWFBase.getJSONValue((Object)pSWFSubWFBase.getSubPSWFId()), (boolean)false);
        }
        if (bl || pSWFSubWFBase.getSubPSWFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"subpswfname", (Object)PSWFSubWFBase.getJSONValue((Object)pSWFSubWFBase.getSubPSWFName()), (boolean)false);
        }
        if (bl || pSWFSubWFBase.getSubPSWFVerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"subpswfverid", (Object)PSWFSubWFBase.getJSONValue((Object)pSWFSubWFBase.getSubPSWFVerId()), (boolean)false);
        }
        if (bl || pSWFSubWFBase.getSubPSWFVerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"subpswfvername", (Object)PSWFSubWFBase.getJSONValue((Object)pSWFSubWFBase.getSubPSWFVerName()), (boolean)false);
        }
        if (bl || pSWFSubWFBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSWFSubWFBase.getJSONValue((Object)pSWFSubWFBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSWFSubWFBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSWFSubWFBase.getJSONValue((Object)pSWFSubWFBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSWFSubWFBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSWFSubWFBase pSWFSubWFBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSWFSubWFBase.getCodeName() != null) {
            object = pSWFSubWFBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFSubWFBase.getCreateDate() != null) {
            object = pSWFSubWFBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWFSubWFBase.getCreateMan() != null) {
            object = pSWFSubWFBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSWFSubWFBase.getDynaModelFlag() != null) {
            object = pSWFSubWFBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWFSubWFBase.getEnable() != null) {
            object = pSWFSubWFBase.getEnable();
            xmlNode.setAttribute(FIELD_ENABLE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWFSubWFBase.getMemo() != null) {
            object = pSWFSubWFBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSWFSubWFBase.getPSDynaInstId() != null) {
            object = pSWFSubWFBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSWFSubWFBase.getPSWFId() != null) {
            object = pSWFSubWFBase.getPSWFId();
            xmlNode.setAttribute(FIELD_PSWFID, object == null ? "" : (String)object);
        }
        if (bl || pSWFSubWFBase.getPSWFName() != null) {
            object = pSWFSubWFBase.getPSWFName();
            xmlNode.setAttribute(FIELD_PSWFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFSubWFBase.getPSWFSubWFId() != null) {
            object = pSWFSubWFBase.getPSWFSubWFId();
            xmlNode.setAttribute(FIELD_PSWFSUBWFID, object == null ? "" : (String)object);
        }
        if (bl || pSWFSubWFBase.getPSWFSubWFName() != null) {
            object = pSWFSubWFBase.getPSWFSubWFName();
            xmlNode.setAttribute(FIELD_PSWFSUBWFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFSubWFBase.getSubPSWFId() != null) {
            object = pSWFSubWFBase.getSubPSWFId();
            xmlNode.setAttribute(FIELD_SUBPSWFID, object == null ? "" : (String)object);
        }
        if (bl || pSWFSubWFBase.getSubPSWFName() != null) {
            object = pSWFSubWFBase.getSubPSWFName();
            xmlNode.setAttribute(FIELD_SUBPSWFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFSubWFBase.getSubPSWFVerId() != null) {
            object = pSWFSubWFBase.getSubPSWFVerId();
            xmlNode.setAttribute(FIELD_SUBPSWFVERID, object == null ? "" : (String)object);
        }
        if (bl || pSWFSubWFBase.getSubPSWFVerName() != null) {
            object = pSWFSubWFBase.getSubPSWFVerName();
            xmlNode.setAttribute(FIELD_SUBPSWFVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFSubWFBase.getUpdateDate() != null) {
            object = pSWFSubWFBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWFSubWFBase.getUpdateMan() != null) {
            object = pSWFSubWFBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSWFSubWFBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSWFSubWFBase pSWFSubWFBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSWFSubWFBase.isCodeNameDirty() && (bl || pSWFSubWFBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSWFSubWFBase.getCodeName());
        }
        if (pSWFSubWFBase.isCreateDateDirty() && (bl || pSWFSubWFBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSWFSubWFBase.getCreateDate());
        }
        if (pSWFSubWFBase.isCreateManDirty() && (bl || pSWFSubWFBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSWFSubWFBase.getCreateMan());
        }
        if (pSWFSubWFBase.isDynaModelFlagDirty() && (bl || pSWFSubWFBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSWFSubWFBase.getDynaModelFlag());
        }
        if (pSWFSubWFBase.isEnableDirty() && (bl || pSWFSubWFBase.getEnable() != null)) {
            iDataObject.set(FIELD_ENABLE, (Object)pSWFSubWFBase.getEnable());
        }
        if (pSWFSubWFBase.isMemoDirty() && (bl || pSWFSubWFBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSWFSubWFBase.getMemo());
        }
        if (pSWFSubWFBase.isPSDynaInstIdDirty() && (bl || pSWFSubWFBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSWFSubWFBase.getPSDynaInstId());
        }
        if (pSWFSubWFBase.isPSWFIdDirty() && (bl || pSWFSubWFBase.getPSWFId() != null)) {
            iDataObject.set(FIELD_PSWFID, (Object)pSWFSubWFBase.getPSWFId());
        }
        if (pSWFSubWFBase.isPSWFNameDirty() && (bl || pSWFSubWFBase.getPSWFName() != null)) {
            iDataObject.set(FIELD_PSWFNAME, (Object)pSWFSubWFBase.getPSWFName());
        }
        if (pSWFSubWFBase.isPSWFSubWFIdDirty() && (bl || pSWFSubWFBase.getPSWFSubWFId() != null)) {
            iDataObject.set(FIELD_PSWFSUBWFID, (Object)pSWFSubWFBase.getPSWFSubWFId());
        }
        if (pSWFSubWFBase.isPSWFSubWFNameDirty() && (bl || pSWFSubWFBase.getPSWFSubWFName() != null)) {
            iDataObject.set(FIELD_PSWFSUBWFNAME, (Object)pSWFSubWFBase.getPSWFSubWFName());
        }
        if (pSWFSubWFBase.isSubPSWFIdDirty() && (bl || pSWFSubWFBase.getSubPSWFId() != null)) {
            iDataObject.set(FIELD_SUBPSWFID, (Object)pSWFSubWFBase.getSubPSWFId());
        }
        if (pSWFSubWFBase.isSubPSWFNameDirty() && (bl || pSWFSubWFBase.getSubPSWFName() != null)) {
            iDataObject.set(FIELD_SUBPSWFNAME, (Object)pSWFSubWFBase.getSubPSWFName());
        }
        if (pSWFSubWFBase.isSubPSWFVerIdDirty() && (bl || pSWFSubWFBase.getSubPSWFVerId() != null)) {
            iDataObject.set(FIELD_SUBPSWFVERID, (Object)pSWFSubWFBase.getSubPSWFVerId());
        }
        if (pSWFSubWFBase.isSubPSWFVerNameDirty() && (bl || pSWFSubWFBase.getSubPSWFVerName() != null)) {
            iDataObject.set(FIELD_SUBPSWFVERNAME, (Object)pSWFSubWFBase.getSubPSWFVerName());
        }
        if (pSWFSubWFBase.isUpdateDateDirty() && (bl || pSWFSubWFBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSWFSubWFBase.getUpdateDate());
        }
        if (pSWFSubWFBase.isUpdateManDirty() && (bl || pSWFSubWFBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSWFSubWFBase.getUpdateMan());
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
        return PSWFSubWFBase.remove(this, n);
    }

    private static boolean remove(PSWFSubWFBase pSWFSubWFBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSWFSubWFBase.resetCodeName();
                return true;
            }
            case 1: {
                pSWFSubWFBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSWFSubWFBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSWFSubWFBase.resetDynaModelFlag();
                return true;
            }
            case 4: {
                pSWFSubWFBase.resetEnable();
                return true;
            }
            case 5: {
                pSWFSubWFBase.resetMemo();
                return true;
            }
            case 6: {
                pSWFSubWFBase.resetPSDynaInstId();
                return true;
            }
            case 7: {
                pSWFSubWFBase.resetPSWFId();
                return true;
            }
            case 8: {
                pSWFSubWFBase.resetPSWFName();
                return true;
            }
            case 9: {
                pSWFSubWFBase.resetPSWFSubWFId();
                return true;
            }
            case 10: {
                pSWFSubWFBase.resetPSWFSubWFName();
                return true;
            }
            case 11: {
                pSWFSubWFBase.resetSubPSWFId();
                return true;
            }
            case 12: {
                pSWFSubWFBase.resetSubPSWFName();
                return true;
            }
            case 13: {
                pSWFSubWFBase.resetSubPSWFVerId();
                return true;
            }
            case 14: {
                pSWFSubWFBase.resetSubPSWFVerName();
                return true;
            }
            case 15: {
                pSWFSubWFBase.resetUpdateDate();
                return true;
            }
            case 16: {
                pSWFSubWFBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSWFVersion getSubPSWFVer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSubPSWFVer();
        }
        if (this.getSubPSWFVerId() == null) {
            return null;
        }
        Integer n = this.objSubPSWFVerLock;
        synchronized (n) {
            if (this.subpswfver != null && DataTypeHelper.compare((int)25, (Object)this.getSubPSWFVerId(), (Object)this.subpswfver.getPSWFVersionId()) != 0L) {
                this.subpswfver = null;
            }
            if (this.subpswfver == null) {
                PSWFVersion pSWFVersion = new PSWFVersion();
                pSWFVersion.setPSWFVersionId(this.getSubPSWFVerId());
                PSWFVersionService pSWFVersionService = (PSWFVersionService)ServiceGlobal.getService(PSWFVersionService.class, (SessionFactory)this.getSessionFactory());
                pSWFVersionService.autoGet((IEntity)pSWFVersion);
                this.subpswfver = pSWFVersion;
            }
            return this.subpswfver;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSWorkflow getPSWF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWF();
        }
        if (this.getPSWFId() == null) {
            return null;
        }
        Integer n = this.objPSWFLock;
        synchronized (n) {
            if (this.pswf != null && DataTypeHelper.compare((int)25, (Object)this.getPSWFId(), (Object)this.pswf.getPSWorkflowId()) != 0L) {
                this.pswf = null;
            }
            if (this.pswf == null) {
                PSWorkflow pSWorkflow = new PSWorkflow();
                pSWorkflow.setPSWorkflowId(this.getPSWFId());
                PSWorkflowService pSWorkflowService = (PSWorkflowService)ServiceGlobal.getService(PSWorkflowService.class, (SessionFactory)this.getSessionFactory());
                pSWorkflowService.autoGet((IEntity)pSWorkflow);
                this.pswf = pSWorkflow;
            }
            return this.pswf;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSWorkflow getSubPSWF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSubPSWF();
        }
        if (this.getSubPSWFId() == null) {
            return null;
        }
        Integer n = this.objSubPSWFLock;
        synchronized (n) {
            if (this.subpswf != null && DataTypeHelper.compare((int)25, (Object)this.getSubPSWFId(), (Object)this.subpswf.getPSWorkflowId()) != 0L) {
                this.subpswf = null;
            }
            if (this.subpswf == null) {
                PSWorkflow pSWorkflow = new PSWorkflow();
                pSWorkflow.setPSWorkflowId(this.getSubPSWFId());
                PSWorkflowService pSWorkflowService = (PSWorkflowService)ServiceGlobal.getService(PSWorkflowService.class, (SessionFactory)this.getSessionFactory());
                pSWorkflowService.autoGet((IEntity)pSWorkflow);
                this.subpswf = pSWorkflow;
            }
            return this.subpswf;
        }
    }

    private PSWFSubWFBase getProxyEntity() {
        return this.proxyPSWFSubWFBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSWFSubWFBase = null;
        if (iDataObject != null && iDataObject instanceof PSWFSubWFBase) {
            this.proxyPSWFSubWFBase = (PSWFSubWFBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWFSubWFService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 3);
        fieldIndexMap.put(FIELD_ENABLE, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 6);
        fieldIndexMap.put(FIELD_PSWFID, 7);
        fieldIndexMap.put(FIELD_PSWFNAME, 8);
        fieldIndexMap.put(FIELD_PSWFSUBWFID, 9);
        fieldIndexMap.put(FIELD_PSWFSUBWFNAME, 10);
        fieldIndexMap.put(FIELD_SUBPSWFID, 11);
        fieldIndexMap.put(FIELD_SUBPSWFNAME, 12);
        fieldIndexMap.put(FIELD_SUBPSWFVERID, 13);
        fieldIndexMap.put(FIELD_SUBPSWFVERNAME, 14);
        fieldIndexMap.put(FIELD_UPDATEDATE, 15);
        fieldIndexMap.put(FIELD_UPDATEMAN, 16);
    }
}

