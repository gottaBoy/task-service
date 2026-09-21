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
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnSysSrcBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevSlnSysSrcBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEVSLNID = "PSDEVSLNID";
    public static final String FIELD_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String FIELD_PSDEVSLNSYSNAME = "PSDEVSLNSYSNAME";
    public static final String FIELD_PSDEVSLNSYSSRCID = "PSDEVSLNSYSSRCID";
    public static final String FIELD_PSDEVSLNSYSSRCNAME = "PSDEVSLNSYSSRCNAME";
    public static final String FIELD_SOURCEID = "SOURCEID";
    public static final String FIELD_SRCPSDEVSLNSYSID = "SRCPSDEVSLNSYSID";
    public static final String FIELD_SRCPSDEVSLNSYSNAME = "SRCPSDEVSLNSYSNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSDEVSLNID = 3;
    private static final int INDEX_PSDEVSLNSYSID = 4;
    private static final int INDEX_PSDEVSLNSYSNAME = 5;
    private static final int INDEX_PSDEVSLNSYSSRCID = 6;
    private static final int INDEX_PSDEVSLNSYSSRCNAME = 7;
    private static final int INDEX_SOURCEID = 8;
    private static final int INDEX_SRCPSDEVSLNSYSID = 9;
    private static final int INDEX_SRCPSDEVSLNSYSNAME = 10;
    private static final int INDEX_UPDATEDATE = 11;
    private static final int INDEX_UPDATEMAN = 12;
    private static final int INDEX_VALIDFLAG = 13;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevSlnSysSrcBase proxyPSDevSlnSysSrcBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdevslnidDirtyFlag = false;
    private boolean psdevslnsysidDirtyFlag = false;
    private boolean psdevslnsysnameDirtyFlag = false;
    private boolean psdevslnsyssrcidDirtyFlag = false;
    private boolean psdevslnsyssrcnameDirtyFlag = false;
    private boolean sourceidDirtyFlag = false;
    private boolean srcpsdevslnsysidDirtyFlag = false;
    private boolean srcpsdevslnsysnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psdevslnid")
    private String psdevslnid;
    @Column(name="psdevslnsysid")
    private String psdevslnsysid;
    @Column(name="psdevslnsysname")
    private String psdevslnsysname;
    @Column(name="psdevslnsyssrcid")
    private String psdevslnsyssrcid;
    @Column(name="psdevslnsyssrcname")
    private String psdevslnsyssrcname;
    @Column(name="sourceid")
    private String sourceid;
    @Column(name="srcpsdevslnsysid")
    private String srcpsdevslnsysid;
    @Column(name="srcpsdevslnsysname")
    private String srcpsdevslnsysname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSDevSlnSysLock = new Integer(1);
    private PSDevSlnSys psdevslnsys = null;
    private Integer objSrcPSDevSlnSysLock = new Integer(1);
    private PSDevSlnSys srcpsdevslnsys = null;

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

    public void setPSDevSlnSysId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysid = string;
        this.psdevslnsysidDirtyFlag = true;
    }

    public String getPSDevSlnSysId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysId();
        }
        return this.psdevslnsysid;
    }

    public boolean isPSDevSlnSysIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysIdDirty();
        }
        return this.psdevslnsysidDirtyFlag;
    }

    public void resetPSDevSlnSysId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysId();
            return;
        }
        this.psdevslnsysidDirtyFlag = false;
        this.psdevslnsysid = null;
    }

    public void setPSDevSlnSysName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysname = string;
        this.psdevslnsysnameDirtyFlag = true;
    }

    public String getPSDevSlnSysName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysName();
        }
        return this.psdevslnsysname;
    }

    public boolean isPSDevSlnSysNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysNameDirty();
        }
        return this.psdevslnsysnameDirtyFlag;
    }

    public void resetPSDevSlnSysName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysName();
            return;
        }
        this.psdevslnsysnameDirtyFlag = false;
        this.psdevslnsysname = null;
    }

    public void setPSDevSlnSysSrcId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysSrcId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsyssrcid = string;
        this.psdevslnsyssrcidDirtyFlag = true;
    }

    public String getPSDevSlnSysSrcId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysSrcId();
        }
        return this.psdevslnsyssrcid;
    }

    public boolean isPSDevSlnSysSrcIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysSrcIdDirty();
        }
        return this.psdevslnsyssrcidDirtyFlag;
    }

    public void resetPSDevSlnSysSrcId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysSrcId();
            return;
        }
        this.psdevslnsyssrcidDirtyFlag = false;
        this.psdevslnsyssrcid = null;
    }

    public void setPSDevSlnSysSrcName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysSrcName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsyssrcname = string;
        this.psdevslnsyssrcnameDirtyFlag = true;
    }

    public String getPSDevSlnSysSrcName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysSrcName();
        }
        return this.psdevslnsyssrcname;
    }

    public boolean isPSDevSlnSysSrcNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysSrcNameDirty();
        }
        return this.psdevslnsyssrcnameDirtyFlag;
    }

    public void resetPSDevSlnSysSrcName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysSrcName();
            return;
        }
        this.psdevslnsyssrcnameDirtyFlag = false;
        this.psdevslnsyssrcname = null;
    }

    public void setSourceId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSourceId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sourceid = string;
        this.sourceidDirtyFlag = true;
    }

    public String getSourceId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSourceId();
        }
        return this.sourceid;
    }

    public boolean isSourceIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSourceIdDirty();
        }
        return this.sourceidDirtyFlag;
    }

    public void resetSourceId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSourceId();
            return;
        }
        this.sourceidDirtyFlag = false;
        this.sourceid = null;
    }

    public void setSrcPSDevSlnSysId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSrcPSDevSlnSysId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.srcpsdevslnsysid = string;
        this.srcpsdevslnsysidDirtyFlag = true;
    }

    public String getSrcPSDevSlnSysId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSrcPSDevSlnSysId();
        }
        return this.srcpsdevslnsysid;
    }

    public boolean isSrcPSDevSlnSysIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSrcPSDevSlnSysIdDirty();
        }
        return this.srcpsdevslnsysidDirtyFlag;
    }

    public void resetSrcPSDevSlnSysId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSrcPSDevSlnSysId();
            return;
        }
        this.srcpsdevslnsysidDirtyFlag = false;
        this.srcpsdevslnsysid = null;
    }

    public void setSrcPSDevSlnSysName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSrcPSDevSlnSysName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.srcpsdevslnsysname = string;
        this.srcpsdevslnsysnameDirtyFlag = true;
    }

    public String getSrcPSDevSlnSysName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSrcPSDevSlnSysName();
        }
        return this.srcpsdevslnsysname;
    }

    public boolean isSrcPSDevSlnSysNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSrcPSDevSlnSysNameDirty();
        }
        return this.srcpsdevslnsysnameDirtyFlag;
    }

    public void resetSrcPSDevSlnSysName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSrcPSDevSlnSysName();
            return;
        }
        this.srcpsdevslnsysnameDirtyFlag = false;
        this.srcpsdevslnsysname = null;
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
        PSDevSlnSysSrcBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevSlnSysSrcBase pSDevSlnSysSrcBase) {
        pSDevSlnSysSrcBase.resetCreateDate();
        pSDevSlnSysSrcBase.resetCreateMan();
        pSDevSlnSysSrcBase.resetMemo();
        pSDevSlnSysSrcBase.resetPSDevSlnId();
        pSDevSlnSysSrcBase.resetPSDevSlnSysId();
        pSDevSlnSysSrcBase.resetPSDevSlnSysName();
        pSDevSlnSysSrcBase.resetPSDevSlnSysSrcId();
        pSDevSlnSysSrcBase.resetPSDevSlnSysSrcName();
        pSDevSlnSysSrcBase.resetSourceId();
        pSDevSlnSysSrcBase.resetSrcPSDevSlnSysId();
        pSDevSlnSysSrcBase.resetSrcPSDevSlnSysName();
        pSDevSlnSysSrcBase.resetUpdateDate();
        pSDevSlnSysSrcBase.resetUpdateMan();
        pSDevSlnSysSrcBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDevSlnIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNID, this.getPSDevSlnId());
        }
        if (!bl || this.isPSDevSlnSysIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSID, this.getPSDevSlnSysId());
        }
        if (!bl || this.isPSDevSlnSysNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSNAME, this.getPSDevSlnSysName());
        }
        if (!bl || this.isPSDevSlnSysSrcIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSSRCID, this.getPSDevSlnSysSrcId());
        }
        if (!bl || this.isPSDevSlnSysSrcNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSSRCNAME, this.getPSDevSlnSysSrcName());
        }
        if (!bl || this.isSourceIdDirty()) {
            hashMap.put(FIELD_SOURCEID, this.getSourceId());
        }
        if (!bl || this.isSrcPSDevSlnSysIdDirty()) {
            hashMap.put(FIELD_SRCPSDEVSLNSYSID, this.getSrcPSDevSlnSysId());
        }
        if (!bl || this.isSrcPSDevSlnSysNameDirty()) {
            hashMap.put(FIELD_SRCPSDEVSLNSYSNAME, this.getSrcPSDevSlnSysName());
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
        return PSDevSlnSysSrcBase.get(this, n);
    }

    private static Object get(PSDevSlnSysSrcBase pSDevSlnSysSrcBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnSysSrcBase.getCreateDate();
            }
            case 1: {
                return pSDevSlnSysSrcBase.getCreateMan();
            }
            case 2: {
                return pSDevSlnSysSrcBase.getMemo();
            }
            case 3: {
                return pSDevSlnSysSrcBase.getPSDevSlnId();
            }
            case 4: {
                return pSDevSlnSysSrcBase.getPSDevSlnSysId();
            }
            case 5: {
                return pSDevSlnSysSrcBase.getPSDevSlnSysName();
            }
            case 6: {
                return pSDevSlnSysSrcBase.getPSDevSlnSysSrcId();
            }
            case 7: {
                return pSDevSlnSysSrcBase.getPSDevSlnSysSrcName();
            }
            case 8: {
                return pSDevSlnSysSrcBase.getSourceId();
            }
            case 9: {
                return pSDevSlnSysSrcBase.getSrcPSDevSlnSysId();
            }
            case 10: {
                return pSDevSlnSysSrcBase.getSrcPSDevSlnSysName();
            }
            case 11: {
                return pSDevSlnSysSrcBase.getUpdateDate();
            }
            case 12: {
                return pSDevSlnSysSrcBase.getUpdateMan();
            }
            case 13: {
                return pSDevSlnSysSrcBase.getValidFlag();
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
        PSDevSlnSysSrcBase.set(this, n, object);
    }

    private static void set(PSDevSlnSysSrcBase pSDevSlnSysSrcBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnSysSrcBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDevSlnSysSrcBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDevSlnSysSrcBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDevSlnSysSrcBase.setPSDevSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDevSlnSysSrcBase.setPSDevSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDevSlnSysSrcBase.setPSDevSlnSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDevSlnSysSrcBase.setPSDevSlnSysSrcId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDevSlnSysSrcBase.setPSDevSlnSysSrcName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDevSlnSysSrcBase.setSourceId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDevSlnSysSrcBase.setSrcPSDevSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDevSlnSysSrcBase.setSrcPSDevSlnSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDevSlnSysSrcBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSDevSlnSysSrcBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDevSlnSysSrcBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDevSlnSysSrcBase.isNull(this, n);
    }

    private static boolean isNull(PSDevSlnSysSrcBase pSDevSlnSysSrcBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnSysSrcBase.getCreateDate() == null;
            }
            case 1: {
                return pSDevSlnSysSrcBase.getCreateMan() == null;
            }
            case 2: {
                return pSDevSlnSysSrcBase.getMemo() == null;
            }
            case 3: {
                return pSDevSlnSysSrcBase.getPSDevSlnId() == null;
            }
            case 4: {
                return pSDevSlnSysSrcBase.getPSDevSlnSysId() == null;
            }
            case 5: {
                return pSDevSlnSysSrcBase.getPSDevSlnSysName() == null;
            }
            case 6: {
                return pSDevSlnSysSrcBase.getPSDevSlnSysSrcId() == null;
            }
            case 7: {
                return pSDevSlnSysSrcBase.getPSDevSlnSysSrcName() == null;
            }
            case 8: {
                return pSDevSlnSysSrcBase.getSourceId() == null;
            }
            case 9: {
                return pSDevSlnSysSrcBase.getSrcPSDevSlnSysId() == null;
            }
            case 10: {
                return pSDevSlnSysSrcBase.getSrcPSDevSlnSysName() == null;
            }
            case 11: {
                return pSDevSlnSysSrcBase.getUpdateDate() == null;
            }
            case 12: {
                return pSDevSlnSysSrcBase.getUpdateMan() == null;
            }
            case 13: {
                return pSDevSlnSysSrcBase.getValidFlag() == null;
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
        return PSDevSlnSysSrcBase.contains(this, n);
    }

    private static boolean contains(PSDevSlnSysSrcBase pSDevSlnSysSrcBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnSysSrcBase.isCreateDateDirty();
            }
            case 1: {
                return pSDevSlnSysSrcBase.isCreateManDirty();
            }
            case 2: {
                return pSDevSlnSysSrcBase.isMemoDirty();
            }
            case 3: {
                return pSDevSlnSysSrcBase.isPSDevSlnIdDirty();
            }
            case 4: {
                return pSDevSlnSysSrcBase.isPSDevSlnSysIdDirty();
            }
            case 5: {
                return pSDevSlnSysSrcBase.isPSDevSlnSysNameDirty();
            }
            case 6: {
                return pSDevSlnSysSrcBase.isPSDevSlnSysSrcIdDirty();
            }
            case 7: {
                return pSDevSlnSysSrcBase.isPSDevSlnSysSrcNameDirty();
            }
            case 8: {
                return pSDevSlnSysSrcBase.isSourceIdDirty();
            }
            case 9: {
                return pSDevSlnSysSrcBase.isSrcPSDevSlnSysIdDirty();
            }
            case 10: {
                return pSDevSlnSysSrcBase.isSrcPSDevSlnSysNameDirty();
            }
            case 11: {
                return pSDevSlnSysSrcBase.isUpdateDateDirty();
            }
            case 12: {
                return pSDevSlnSysSrcBase.isUpdateManDirty();
            }
            case 13: {
                return pSDevSlnSysSrcBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevSlnSysSrcBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevSlnSysSrcBase pSDevSlnSysSrcBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevSlnSysSrcBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevSlnSysSrcBase.getJSONValue((Object)pSDevSlnSysSrcBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevSlnSysSrcBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevSlnSysSrcBase.getJSONValue((Object)pSDevSlnSysSrcBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevSlnSysSrcBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDevSlnSysSrcBase.getJSONValue((Object)pSDevSlnSysSrcBase.getMemo()), (boolean)false);
        }
        if (bl || pSDevSlnSysSrcBase.getPSDevSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnid", (Object)PSDevSlnSysSrcBase.getJSONValue((Object)pSDevSlnSysSrcBase.getPSDevSlnId()), (boolean)false);
        }
        if (bl || pSDevSlnSysSrcBase.getPSDevSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysid", (Object)PSDevSlnSysSrcBase.getJSONValue((Object)pSDevSlnSysSrcBase.getPSDevSlnSysId()), (boolean)false);
        }
        if (bl || pSDevSlnSysSrcBase.getPSDevSlnSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysname", (Object)PSDevSlnSysSrcBase.getJSONValue((Object)pSDevSlnSysSrcBase.getPSDevSlnSysName()), (boolean)false);
        }
        if (bl || pSDevSlnSysSrcBase.getPSDevSlnSysSrcId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsyssrcid", (Object)PSDevSlnSysSrcBase.getJSONValue((Object)pSDevSlnSysSrcBase.getPSDevSlnSysSrcId()), (boolean)false);
        }
        if (bl || pSDevSlnSysSrcBase.getPSDevSlnSysSrcName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsyssrcname", (Object)PSDevSlnSysSrcBase.getJSONValue((Object)pSDevSlnSysSrcBase.getPSDevSlnSysSrcName()), (boolean)false);
        }
        if (bl || pSDevSlnSysSrcBase.getSourceId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sourceid", (Object)PSDevSlnSysSrcBase.getJSONValue((Object)pSDevSlnSysSrcBase.getSourceId()), (boolean)false);
        }
        if (bl || pSDevSlnSysSrcBase.getSrcPSDevSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srcpsdevslnsysid", (Object)PSDevSlnSysSrcBase.getJSONValue((Object)pSDevSlnSysSrcBase.getSrcPSDevSlnSysId()), (boolean)false);
        }
        if (bl || pSDevSlnSysSrcBase.getSrcPSDevSlnSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srcpsdevslnsysname", (Object)PSDevSlnSysSrcBase.getJSONValue((Object)pSDevSlnSysSrcBase.getSrcPSDevSlnSysName()), (boolean)false);
        }
        if (bl || pSDevSlnSysSrcBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevSlnSysSrcBase.getJSONValue((Object)pSDevSlnSysSrcBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevSlnSysSrcBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevSlnSysSrcBase.getJSONValue((Object)pSDevSlnSysSrcBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDevSlnSysSrcBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDevSlnSysSrcBase.getJSONValue((Object)pSDevSlnSysSrcBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevSlnSysSrcBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevSlnSysSrcBase pSDevSlnSysSrcBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevSlnSysSrcBase.getCreateDate() != null) {
            object = pSDevSlnSysSrcBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysSrcBase.getCreateMan() != null) {
            object = pSDevSlnSysSrcBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysSrcBase.getMemo() != null) {
            object = pSDevSlnSysSrcBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysSrcBase.getPSDevSlnId() != null) {
            object = pSDevSlnSysSrcBase.getPSDevSlnId();
            xmlNode.setAttribute(FIELD_PSDEVSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysSrcBase.getPSDevSlnSysId() != null) {
            object = pSDevSlnSysSrcBase.getPSDevSlnSysId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysSrcBase.getPSDevSlnSysName() != null) {
            object = pSDevSlnSysSrcBase.getPSDevSlnSysName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysSrcBase.getPSDevSlnSysSrcId() != null) {
            object = pSDevSlnSysSrcBase.getPSDevSlnSysSrcId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSSRCID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysSrcBase.getPSDevSlnSysSrcName() != null) {
            object = pSDevSlnSysSrcBase.getPSDevSlnSysSrcName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSSRCNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysSrcBase.getSourceId() != null) {
            object = pSDevSlnSysSrcBase.getSourceId();
            xmlNode.setAttribute(FIELD_SOURCEID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysSrcBase.getSrcPSDevSlnSysId() != null) {
            object = pSDevSlnSysSrcBase.getSrcPSDevSlnSysId();
            xmlNode.setAttribute(FIELD_SRCPSDEVSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysSrcBase.getSrcPSDevSlnSysName() != null) {
            object = pSDevSlnSysSrcBase.getSrcPSDevSlnSysName();
            xmlNode.setAttribute(FIELD_SRCPSDEVSLNSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysSrcBase.getUpdateDate() != null) {
            object = pSDevSlnSysSrcBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysSrcBase.getUpdateMan() != null) {
            object = pSDevSlnSysSrcBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysSrcBase.getValidFlag() != null) {
            object = pSDevSlnSysSrcBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevSlnSysSrcBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevSlnSysSrcBase pSDevSlnSysSrcBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevSlnSysSrcBase.isCreateDateDirty() && (bl || pSDevSlnSysSrcBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevSlnSysSrcBase.getCreateDate());
        }
        if (pSDevSlnSysSrcBase.isCreateManDirty() && (bl || pSDevSlnSysSrcBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevSlnSysSrcBase.getCreateMan());
        }
        if (pSDevSlnSysSrcBase.isMemoDirty() && (bl || pSDevSlnSysSrcBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDevSlnSysSrcBase.getMemo());
        }
        if (pSDevSlnSysSrcBase.isPSDevSlnIdDirty() && (bl || pSDevSlnSysSrcBase.getPSDevSlnId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNID, (Object)pSDevSlnSysSrcBase.getPSDevSlnId());
        }
        if (pSDevSlnSysSrcBase.isPSDevSlnSysIdDirty() && (bl || pSDevSlnSysSrcBase.getPSDevSlnSysId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSID, (Object)pSDevSlnSysSrcBase.getPSDevSlnSysId());
        }
        if (pSDevSlnSysSrcBase.isPSDevSlnSysNameDirty() && (bl || pSDevSlnSysSrcBase.getPSDevSlnSysName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSNAME, (Object)pSDevSlnSysSrcBase.getPSDevSlnSysName());
        }
        if (pSDevSlnSysSrcBase.isPSDevSlnSysSrcIdDirty() && (bl || pSDevSlnSysSrcBase.getPSDevSlnSysSrcId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSSRCID, (Object)pSDevSlnSysSrcBase.getPSDevSlnSysSrcId());
        }
        if (pSDevSlnSysSrcBase.isPSDevSlnSysSrcNameDirty() && (bl || pSDevSlnSysSrcBase.getPSDevSlnSysSrcName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSSRCNAME, (Object)pSDevSlnSysSrcBase.getPSDevSlnSysSrcName());
        }
        if (pSDevSlnSysSrcBase.isSourceIdDirty() && (bl || pSDevSlnSysSrcBase.getSourceId() != null)) {
            iDataObject.set(FIELD_SOURCEID, (Object)pSDevSlnSysSrcBase.getSourceId());
        }
        if (pSDevSlnSysSrcBase.isSrcPSDevSlnSysIdDirty() && (bl || pSDevSlnSysSrcBase.getSrcPSDevSlnSysId() != null)) {
            iDataObject.set(FIELD_SRCPSDEVSLNSYSID, (Object)pSDevSlnSysSrcBase.getSrcPSDevSlnSysId());
        }
        if (pSDevSlnSysSrcBase.isSrcPSDevSlnSysNameDirty() && (bl || pSDevSlnSysSrcBase.getSrcPSDevSlnSysName() != null)) {
            iDataObject.set(FIELD_SRCPSDEVSLNSYSNAME, (Object)pSDevSlnSysSrcBase.getSrcPSDevSlnSysName());
        }
        if (pSDevSlnSysSrcBase.isUpdateDateDirty() && (bl || pSDevSlnSysSrcBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevSlnSysSrcBase.getUpdateDate());
        }
        if (pSDevSlnSysSrcBase.isUpdateManDirty() && (bl || pSDevSlnSysSrcBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevSlnSysSrcBase.getUpdateMan());
        }
        if (pSDevSlnSysSrcBase.isValidFlagDirty() && (bl || pSDevSlnSysSrcBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDevSlnSysSrcBase.getValidFlag());
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
        return PSDevSlnSysSrcBase.remove(this, n);
    }

    private static boolean remove(PSDevSlnSysSrcBase pSDevSlnSysSrcBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnSysSrcBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDevSlnSysSrcBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDevSlnSysSrcBase.resetMemo();
                return true;
            }
            case 3: {
                pSDevSlnSysSrcBase.resetPSDevSlnId();
                return true;
            }
            case 4: {
                pSDevSlnSysSrcBase.resetPSDevSlnSysId();
                return true;
            }
            case 5: {
                pSDevSlnSysSrcBase.resetPSDevSlnSysName();
                return true;
            }
            case 6: {
                pSDevSlnSysSrcBase.resetPSDevSlnSysSrcId();
                return true;
            }
            case 7: {
                pSDevSlnSysSrcBase.resetPSDevSlnSysSrcName();
                return true;
            }
            case 8: {
                pSDevSlnSysSrcBase.resetSourceId();
                return true;
            }
            case 9: {
                pSDevSlnSysSrcBase.resetSrcPSDevSlnSysId();
                return true;
            }
            case 10: {
                pSDevSlnSysSrcBase.resetSrcPSDevSlnSysName();
                return true;
            }
            case 11: {
                pSDevSlnSysSrcBase.resetUpdateDate();
                return true;
            }
            case 12: {
                pSDevSlnSysSrcBase.resetUpdateMan();
                return true;
            }
            case 13: {
                pSDevSlnSysSrcBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnSys getPSDevSlnSys() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSys();
        }
        if (this.getPSDevSlnSysId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnSysLock;
        synchronized (n) {
            if (this.psdevslnsys != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnSysId(), (Object)this.psdevslnsys.getPSDevSlnSysId()) != 0L) {
                this.psdevslnsys = null;
            }
            if (this.psdevslnsys == null) {
                PSDevSlnSys pSDevSlnSys = new PSDevSlnSys();
                pSDevSlnSys.setPSDevSlnSysId(this.getPSDevSlnSysId());
                PSDevSlnSysService pSDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnSysService.autoGet((IEntity)pSDevSlnSys);
                this.psdevslnsys = pSDevSlnSys;
            }
            return this.psdevslnsys;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnSys getSrcPSDevSlnSys() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSrcPSDevSlnSys();
        }
        if (this.getSrcPSDevSlnSysId() == null) {
            return null;
        }
        Integer n = this.objSrcPSDevSlnSysLock;
        synchronized (n) {
            if (this.srcpsdevslnsys != null && DataTypeHelper.compare((int)25, (Object)this.getSrcPSDevSlnSysId(), (Object)this.srcpsdevslnsys.getPSDevSlnSysId()) != 0L) {
                this.srcpsdevslnsys = null;
            }
            if (this.srcpsdevslnsys == null) {
                PSDevSlnSys pSDevSlnSys = new PSDevSlnSys();
                pSDevSlnSys.setPSDevSlnSysId(this.getSrcPSDevSlnSysId());
                PSDevSlnSysService pSDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnSysService.autoGet((IEntity)pSDevSlnSys);
                this.srcpsdevslnsys = pSDevSlnSys;
            }
            return this.srcpsdevslnsys;
        }
    }

    private PSDevSlnSysSrcBase getProxyEntity() {
        return this.proxyPSDevSlnSysSrcBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevSlnSysSrcBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevSlnSysSrcBase) {
            this.proxyPSDevSlnSysSrcBase = (PSDevSlnSysSrcBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysSrcService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSDEVSLNID, 3);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSID, 4);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSNAME, 5);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSSRCID, 6);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSSRCNAME, 7);
        fieldIndexMap.put(FIELD_SOURCEID, 8);
        fieldIndexMap.put(FIELD_SRCPSDEVSLNSYSID, 9);
        fieldIndexMap.put(FIELD_SRCPSDEVSLNSYSNAME, 10);
        fieldIndexMap.put(FIELD_UPDATEDATE, 11);
        fieldIndexMap.put(FIELD_UPDATEMAN, 12);
        fieldIndexMap.put(FIELD_VALIDFLAG, 13);
    }
}

