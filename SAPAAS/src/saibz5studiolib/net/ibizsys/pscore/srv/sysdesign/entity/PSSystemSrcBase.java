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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSystemSrcBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSystemSrcBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_PSSYSTEMSRCID = "PSSYSTEMSRCID";
    public static final String FIELD_PSSYSTEMSRCNAME = "PSSYSTEMSRCNAME";
    public static final String FIELD_SOURCEID = "SOURCEID";
    public static final String FIELD_SRCPSDEVSLNSYSID = "SRCPSDEVSLNSYSID";
    public static final String FIELD_SRCPSDEVSLNSYSNAME = "SRCPSDEVSLNSYSNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSSYSTEMID = 3;
    private static final int INDEX_PSSYSTEMNAME = 4;
    private static final int INDEX_PSSYSTEMSRCID = 5;
    private static final int INDEX_PSSYSTEMSRCNAME = 6;
    private static final int INDEX_SOURCEID = 7;
    private static final int INDEX_SRCPSDEVSLNSYSID = 8;
    private static final int INDEX_SRCPSDEVSLNSYSNAME = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final int INDEX_VALIDFLAG = 12;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSystemSrcBase proxyPSSystemSrcBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean pssystemsrcidDirtyFlag = false;
    private boolean pssystemsrcnameDirtyFlag = false;
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
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="pssystemsrcid")
    private String pssystemsrcid;
    @Column(name="pssystemsrcname")
    private String pssystemsrcname;
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
    private Integer objSrcPSDevSlnSysLock = new Integer(1);
    private PSDevSlnSys srcpsdevslnsys = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;

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

    public void setPSSystemSrcId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemSrcId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemsrcid = string;
        this.pssystemsrcidDirtyFlag = true;
    }

    public String getPSSystemSrcId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemSrcId();
        }
        return this.pssystemsrcid;
    }

    public boolean isPSSystemSrcIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemSrcIdDirty();
        }
        return this.pssystemsrcidDirtyFlag;
    }

    public void resetPSSystemSrcId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemSrcId();
            return;
        }
        this.pssystemsrcidDirtyFlag = false;
        this.pssystemsrcid = null;
    }

    public void setPSSystemSrcName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemSrcName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemsrcname = string;
        this.pssystemsrcnameDirtyFlag = true;
    }

    public String getPSSystemSrcName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemSrcName();
        }
        return this.pssystemsrcname;
    }

    public boolean isPSSystemSrcNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemSrcNameDirty();
        }
        return this.pssystemsrcnameDirtyFlag;
    }

    public void resetPSSystemSrcName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemSrcName();
            return;
        }
        this.pssystemsrcnameDirtyFlag = false;
        this.pssystemsrcname = null;
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
        PSSystemSrcBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSystemSrcBase pSSystemSrcBase) {
        pSSystemSrcBase.resetCreateDate();
        pSSystemSrcBase.resetCreateMan();
        pSSystemSrcBase.resetMemo();
        pSSystemSrcBase.resetPSSystemId();
        pSSystemSrcBase.resetPSSystemName();
        pSSystemSrcBase.resetPSSystemSrcId();
        pSSystemSrcBase.resetPSSystemSrcName();
        pSSystemSrcBase.resetSourceId();
        pSSystemSrcBase.resetSrcPSDevSlnSysId();
        pSSystemSrcBase.resetSrcPSDevSlnSysName();
        pSSystemSrcBase.resetUpdateDate();
        pSSystemSrcBase.resetUpdateMan();
        pSSystemSrcBase.resetValidFlag();
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
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
        }
        if (!bl || this.isPSSystemSrcIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMSRCID, this.getPSSystemSrcId());
        }
        if (!bl || this.isPSSystemSrcNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMSRCNAME, this.getPSSystemSrcName());
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
        return PSSystemSrcBase.get(this, n);
    }

    private static Object get(PSSystemSrcBase pSSystemSrcBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSystemSrcBase.getCreateDate();
            }
            case 1: {
                return pSSystemSrcBase.getCreateMan();
            }
            case 2: {
                return pSSystemSrcBase.getMemo();
            }
            case 3: {
                return pSSystemSrcBase.getPSSystemId();
            }
            case 4: {
                return pSSystemSrcBase.getPSSystemName();
            }
            case 5: {
                return pSSystemSrcBase.getPSSystemSrcId();
            }
            case 6: {
                return pSSystemSrcBase.getPSSystemSrcName();
            }
            case 7: {
                return pSSystemSrcBase.getSourceId();
            }
            case 8: {
                return pSSystemSrcBase.getSrcPSDevSlnSysId();
            }
            case 9: {
                return pSSystemSrcBase.getSrcPSDevSlnSysName();
            }
            case 10: {
                return pSSystemSrcBase.getUpdateDate();
            }
            case 11: {
                return pSSystemSrcBase.getUpdateMan();
            }
            case 12: {
                return pSSystemSrcBase.getValidFlag();
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
        PSSystemSrcBase.set(this, n, object);
    }

    private static void set(PSSystemSrcBase pSSystemSrcBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSystemSrcBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSystemSrcBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSystemSrcBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSystemSrcBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSystemSrcBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSystemSrcBase.setPSSystemSrcId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSystemSrcBase.setPSSystemSrcName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSystemSrcBase.setSourceId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSystemSrcBase.setSrcPSDevSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSystemSrcBase.setSrcPSDevSlnSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSystemSrcBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSSystemSrcBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSystemSrcBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSystemSrcBase.isNull(this, n);
    }

    private static boolean isNull(PSSystemSrcBase pSSystemSrcBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSystemSrcBase.getCreateDate() == null;
            }
            case 1: {
                return pSSystemSrcBase.getCreateMan() == null;
            }
            case 2: {
                return pSSystemSrcBase.getMemo() == null;
            }
            case 3: {
                return pSSystemSrcBase.getPSSystemId() == null;
            }
            case 4: {
                return pSSystemSrcBase.getPSSystemName() == null;
            }
            case 5: {
                return pSSystemSrcBase.getPSSystemSrcId() == null;
            }
            case 6: {
                return pSSystemSrcBase.getPSSystemSrcName() == null;
            }
            case 7: {
                return pSSystemSrcBase.getSourceId() == null;
            }
            case 8: {
                return pSSystemSrcBase.getSrcPSDevSlnSysId() == null;
            }
            case 9: {
                return pSSystemSrcBase.getSrcPSDevSlnSysName() == null;
            }
            case 10: {
                return pSSystemSrcBase.getUpdateDate() == null;
            }
            case 11: {
                return pSSystemSrcBase.getUpdateMan() == null;
            }
            case 12: {
                return pSSystemSrcBase.getValidFlag() == null;
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
        return PSSystemSrcBase.contains(this, n);
    }

    private static boolean contains(PSSystemSrcBase pSSystemSrcBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSystemSrcBase.isCreateDateDirty();
            }
            case 1: {
                return pSSystemSrcBase.isCreateManDirty();
            }
            case 2: {
                return pSSystemSrcBase.isMemoDirty();
            }
            case 3: {
                return pSSystemSrcBase.isPSSystemIdDirty();
            }
            case 4: {
                return pSSystemSrcBase.isPSSystemNameDirty();
            }
            case 5: {
                return pSSystemSrcBase.isPSSystemSrcIdDirty();
            }
            case 6: {
                return pSSystemSrcBase.isPSSystemSrcNameDirty();
            }
            case 7: {
                return pSSystemSrcBase.isSourceIdDirty();
            }
            case 8: {
                return pSSystemSrcBase.isSrcPSDevSlnSysIdDirty();
            }
            case 9: {
                return pSSystemSrcBase.isSrcPSDevSlnSysNameDirty();
            }
            case 10: {
                return pSSystemSrcBase.isUpdateDateDirty();
            }
            case 11: {
                return pSSystemSrcBase.isUpdateManDirty();
            }
            case 12: {
                return pSSystemSrcBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSystemSrcBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSystemSrcBase pSSystemSrcBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSystemSrcBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSystemSrcBase.getJSONValue((Object)pSSystemSrcBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSystemSrcBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSystemSrcBase.getJSONValue((Object)pSSystemSrcBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSystemSrcBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSystemSrcBase.getJSONValue((Object)pSSystemSrcBase.getMemo()), (boolean)false);
        }
        if (bl || pSSystemSrcBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSystemSrcBase.getJSONValue((Object)pSSystemSrcBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSystemSrcBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSystemSrcBase.getJSONValue((Object)pSSystemSrcBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSystemSrcBase.getPSSystemSrcId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemsrcid", (Object)PSSystemSrcBase.getJSONValue((Object)pSSystemSrcBase.getPSSystemSrcId()), (boolean)false);
        }
        if (bl || pSSystemSrcBase.getPSSystemSrcName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemsrcname", (Object)PSSystemSrcBase.getJSONValue((Object)pSSystemSrcBase.getPSSystemSrcName()), (boolean)false);
        }
        if (bl || pSSystemSrcBase.getSourceId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sourceid", (Object)PSSystemSrcBase.getJSONValue((Object)pSSystemSrcBase.getSourceId()), (boolean)false);
        }
        if (bl || pSSystemSrcBase.getSrcPSDevSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srcpsdevslnsysid", (Object)PSSystemSrcBase.getJSONValue((Object)pSSystemSrcBase.getSrcPSDevSlnSysId()), (boolean)false);
        }
        if (bl || pSSystemSrcBase.getSrcPSDevSlnSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srcpsdevslnsysname", (Object)PSSystemSrcBase.getJSONValue((Object)pSSystemSrcBase.getSrcPSDevSlnSysName()), (boolean)false);
        }
        if (bl || pSSystemSrcBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSystemSrcBase.getJSONValue((Object)pSSystemSrcBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSystemSrcBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSystemSrcBase.getJSONValue((Object)pSSystemSrcBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSystemSrcBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSystemSrcBase.getJSONValue((Object)pSSystemSrcBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSystemSrcBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSystemSrcBase pSSystemSrcBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSystemSrcBase.getCreateDate() != null) {
            object = pSSystemSrcBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSystemSrcBase.getCreateMan() != null) {
            object = pSSystemSrcBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSystemSrcBase.getMemo() != null) {
            object = pSSystemSrcBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSystemSrcBase.getPSSystemId() != null) {
            object = pSSystemSrcBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSystemSrcBase.getPSSystemName() != null) {
            object = pSSystemSrcBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSystemSrcBase.getPSSystemSrcId() != null) {
            object = pSSystemSrcBase.getPSSystemSrcId();
            xmlNode.setAttribute(FIELD_PSSYSTEMSRCID, object == null ? "" : (String)object);
        }
        if (bl || pSSystemSrcBase.getPSSystemSrcName() != null) {
            object = pSSystemSrcBase.getPSSystemSrcName();
            xmlNode.setAttribute(FIELD_PSSYSTEMSRCNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSystemSrcBase.getSourceId() != null) {
            object = pSSystemSrcBase.getSourceId();
            xmlNode.setAttribute(FIELD_SOURCEID, object == null ? "" : (String)object);
        }
        if (bl || pSSystemSrcBase.getSrcPSDevSlnSysId() != null) {
            object = pSSystemSrcBase.getSrcPSDevSlnSysId();
            xmlNode.setAttribute(FIELD_SRCPSDEVSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSSystemSrcBase.getSrcPSDevSlnSysName() != null) {
            object = pSSystemSrcBase.getSrcPSDevSlnSysName();
            xmlNode.setAttribute(FIELD_SRCPSDEVSLNSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSystemSrcBase.getUpdateDate() != null) {
            object = pSSystemSrcBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSystemSrcBase.getUpdateMan() != null) {
            object = pSSystemSrcBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSystemSrcBase.getValidFlag() != null) {
            object = pSSystemSrcBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSystemSrcBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSystemSrcBase pSSystemSrcBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSystemSrcBase.isCreateDateDirty() && (bl || pSSystemSrcBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSystemSrcBase.getCreateDate());
        }
        if (pSSystemSrcBase.isCreateManDirty() && (bl || pSSystemSrcBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSystemSrcBase.getCreateMan());
        }
        if (pSSystemSrcBase.isMemoDirty() && (bl || pSSystemSrcBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSystemSrcBase.getMemo());
        }
        if (pSSystemSrcBase.isPSSystemIdDirty() && (bl || pSSystemSrcBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSystemSrcBase.getPSSystemId());
        }
        if (pSSystemSrcBase.isPSSystemNameDirty() && (bl || pSSystemSrcBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSystemSrcBase.getPSSystemName());
        }
        if (pSSystemSrcBase.isPSSystemSrcIdDirty() && (bl || pSSystemSrcBase.getPSSystemSrcId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMSRCID, (Object)pSSystemSrcBase.getPSSystemSrcId());
        }
        if (pSSystemSrcBase.isPSSystemSrcNameDirty() && (bl || pSSystemSrcBase.getPSSystemSrcName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMSRCNAME, (Object)pSSystemSrcBase.getPSSystemSrcName());
        }
        if (pSSystemSrcBase.isSourceIdDirty() && (bl || pSSystemSrcBase.getSourceId() != null)) {
            iDataObject.set(FIELD_SOURCEID, (Object)pSSystemSrcBase.getSourceId());
        }
        if (pSSystemSrcBase.isSrcPSDevSlnSysIdDirty() && (bl || pSSystemSrcBase.getSrcPSDevSlnSysId() != null)) {
            iDataObject.set(FIELD_SRCPSDEVSLNSYSID, (Object)pSSystemSrcBase.getSrcPSDevSlnSysId());
        }
        if (pSSystemSrcBase.isSrcPSDevSlnSysNameDirty() && (bl || pSSystemSrcBase.getSrcPSDevSlnSysName() != null)) {
            iDataObject.set(FIELD_SRCPSDEVSLNSYSNAME, (Object)pSSystemSrcBase.getSrcPSDevSlnSysName());
        }
        if (pSSystemSrcBase.isUpdateDateDirty() && (bl || pSSystemSrcBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSystemSrcBase.getUpdateDate());
        }
        if (pSSystemSrcBase.isUpdateManDirty() && (bl || pSSystemSrcBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSystemSrcBase.getUpdateMan());
        }
        if (pSSystemSrcBase.isValidFlagDirty() && (bl || pSSystemSrcBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSystemSrcBase.getValidFlag());
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
        return PSSystemSrcBase.remove(this, n);
    }

    private static boolean remove(PSSystemSrcBase pSSystemSrcBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSystemSrcBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSystemSrcBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSystemSrcBase.resetMemo();
                return true;
            }
            case 3: {
                pSSystemSrcBase.resetPSSystemId();
                return true;
            }
            case 4: {
                pSSystemSrcBase.resetPSSystemName();
                return true;
            }
            case 5: {
                pSSystemSrcBase.resetPSSystemSrcId();
                return true;
            }
            case 6: {
                pSSystemSrcBase.resetPSSystemSrcName();
                return true;
            }
            case 7: {
                pSSystemSrcBase.resetSourceId();
                return true;
            }
            case 8: {
                pSSystemSrcBase.resetSrcPSDevSlnSysId();
                return true;
            }
            case 9: {
                pSSystemSrcBase.resetSrcPSDevSlnSysName();
                return true;
            }
            case 10: {
                pSSystemSrcBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSSystemSrcBase.resetUpdateMan();
                return true;
            }
            case 12: {
                pSSystemSrcBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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

    private PSSystemSrcBase getProxyEntity() {
        return this.proxyPSSystemSrcBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSystemSrcBase = null;
        if (iDataObject != null && iDataObject instanceof PSSystemSrcBase) {
            this.proxyPSSystemSrcBase = (PSSystemSrcBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemSrcService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 3);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 4);
        fieldIndexMap.put(FIELD_PSSYSTEMSRCID, 5);
        fieldIndexMap.put(FIELD_PSSYSTEMSRCNAME, 6);
        fieldIndexMap.put(FIELD_SOURCEID, 7);
        fieldIndexMap.put(FIELD_SRCPSDEVSLNSYSID, 8);
        fieldIndexMap.put(FIELD_SRCPSDEVSLNSYSNAME, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
        fieldIndexMap.put(FIELD_VALIDFLAG, 12);
    }
}

