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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAWGrpDetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEAWGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEAWGrpDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEAWGroupBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEAWGroupBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEAWGROUPID = "PSDEAWGROUPID";
    public static final String FIELD_PSDEAWGROUPNAME = "PSDEAWGROUPNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_LOCKFLAG = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PSDEAWGROUPID = 5;
    private static final int INDEX_PSDEAWGROUPNAME = 6;
    private static final int INDEX_PSDEID = 7;
    private static final int INDEX_PSDENAME = 8;
    private static final int INDEX_UPDATEDATE = 9;
    private static final int INDEX_UPDATEMAN = 10;
    private static final int INDEX_USERTAG = 11;
    private static final int INDEX_USERTAG2 = 12;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEAWGroupBase proxyPSDEAWGroupBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdeawgroupidDirtyFlag = false;
    private boolean psdeawgroupnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="memo")
    private String memo;
    @Column(name="psdeawgroupid")
    private String psdeawgroupid;
    @Column(name="psdeawgroupname")
    private String psdeawgroupname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objPSDEAWGrpDetailsLock = new Integer(1);
    private ArrayList<PSDEAWGrpDetail> psdeawgrpdetails = null;

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

    public void setLockFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLockFlag(n);
            return;
        }
        this.lockflag = n;
        this.lockflagDirtyFlag = true;
    }

    public Integer getLockFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLockFlag();
        }
        return this.lockflag;
    }

    public boolean isLockFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLockFlagDirty();
        }
        return this.lockflagDirtyFlag;
    }

    public void resetLockFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLockFlag();
            return;
        }
        this.lockflagDirtyFlag = false;
        this.lockflag = null;
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

    public void setPSDEAWGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEAWGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeawgroupid = string;
        this.psdeawgroupidDirtyFlag = true;
    }

    public String getPSDEAWGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEAWGroupId();
        }
        return this.psdeawgroupid;
    }

    public boolean isPSDEAWGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEAWGroupIdDirty();
        }
        return this.psdeawgroupidDirtyFlag;
    }

    public void resetPSDEAWGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEAWGroupId();
            return;
        }
        this.psdeawgroupidDirtyFlag = false;
        this.psdeawgroupid = null;
    }

    public void setPSDEAWGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEAWGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeawgroupname = string;
        this.psdeawgroupnameDirtyFlag = true;
    }

    public String getPSDEAWGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEAWGroupName();
        }
        return this.psdeawgroupname;
    }

    public boolean isPSDEAWGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEAWGroupNameDirty();
        }
        return this.psdeawgroupnameDirtyFlag;
    }

    public void resetPSDEAWGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEAWGroupName();
            return;
        }
        this.psdeawgroupnameDirtyFlag = false;
        this.psdeawgroupname = null;
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

    protected void onReset() {
        PSDEAWGroupBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEAWGroupBase pSDEAWGroupBase) {
        pSDEAWGroupBase.resetCodeName();
        pSDEAWGroupBase.resetCreateDate();
        pSDEAWGroupBase.resetCreateMan();
        pSDEAWGroupBase.resetLockFlag();
        pSDEAWGroupBase.resetMemo();
        pSDEAWGroupBase.resetPSDEAWGroupId();
        pSDEAWGroupBase.resetPSDEAWGroupName();
        pSDEAWGroupBase.resetPSDEId();
        pSDEAWGroupBase.resetPSDEName();
        pSDEAWGroupBase.resetUpdateDate();
        pSDEAWGroupBase.resetUpdateMan();
        pSDEAWGroupBase.resetUserTag();
        pSDEAWGroupBase.resetUserTag2();
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
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDEAWGroupIdDirty()) {
            hashMap.put(FIELD_PSDEAWGROUPID, this.getPSDEAWGroupId());
        }
        if (!bl || this.isPSDEAWGroupNameDirty()) {
            hashMap.put(FIELD_PSDEAWGROUPNAME, this.getPSDEAWGroupName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserTagDirty()) {
            hashMap.put(FIELD_USERTAG, this.getUserTag());
        }
        if (!bl || this.isUserTag2Dirty()) {
            hashMap.put(FIELD_USERTAG2, this.getUserTag2());
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
        return PSDEAWGroupBase.get(this, n);
    }

    private static Object get(PSDEAWGroupBase pSDEAWGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEAWGroupBase.getCodeName();
            }
            case 1: {
                return pSDEAWGroupBase.getCreateDate();
            }
            case 2: {
                return pSDEAWGroupBase.getCreateMan();
            }
            case 3: {
                return pSDEAWGroupBase.getLockFlag();
            }
            case 4: {
                return pSDEAWGroupBase.getMemo();
            }
            case 5: {
                return pSDEAWGroupBase.getPSDEAWGroupId();
            }
            case 6: {
                return pSDEAWGroupBase.getPSDEAWGroupName();
            }
            case 7: {
                return pSDEAWGroupBase.getPSDEId();
            }
            case 8: {
                return pSDEAWGroupBase.getPSDEName();
            }
            case 9: {
                return pSDEAWGroupBase.getUpdateDate();
            }
            case 10: {
                return pSDEAWGroupBase.getUpdateMan();
            }
            case 11: {
                return pSDEAWGroupBase.getUserTag();
            }
            case 12: {
                return pSDEAWGroupBase.getUserTag2();
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
        PSDEAWGroupBase.set(this, n, object);
    }

    private static void set(PSDEAWGroupBase pSDEAWGroupBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEAWGroupBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDEAWGroupBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDEAWGroupBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEAWGroupBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSDEAWGroupBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEAWGroupBase.setPSDEAWGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEAWGroupBase.setPSDEAWGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEAWGroupBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEAWGroupBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEAWGroupBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 10: {
                pSDEAWGroupBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEAWGroupBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEAWGroupBase.setUserTag2(DataObject.getStringValue((Object)object));
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
        return PSDEAWGroupBase.isNull(this, n);
    }

    private static boolean isNull(PSDEAWGroupBase pSDEAWGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEAWGroupBase.getCodeName() == null;
            }
            case 1: {
                return pSDEAWGroupBase.getCreateDate() == null;
            }
            case 2: {
                return pSDEAWGroupBase.getCreateMan() == null;
            }
            case 3: {
                return pSDEAWGroupBase.getLockFlag() == null;
            }
            case 4: {
                return pSDEAWGroupBase.getMemo() == null;
            }
            case 5: {
                return pSDEAWGroupBase.getPSDEAWGroupId() == null;
            }
            case 6: {
                return pSDEAWGroupBase.getPSDEAWGroupName() == null;
            }
            case 7: {
                return pSDEAWGroupBase.getPSDEId() == null;
            }
            case 8: {
                return pSDEAWGroupBase.getPSDEName() == null;
            }
            case 9: {
                return pSDEAWGroupBase.getUpdateDate() == null;
            }
            case 10: {
                return pSDEAWGroupBase.getUpdateMan() == null;
            }
            case 11: {
                return pSDEAWGroupBase.getUserTag() == null;
            }
            case 12: {
                return pSDEAWGroupBase.getUserTag2() == null;
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
        return PSDEAWGroupBase.contains(this, n);
    }

    private static boolean contains(PSDEAWGroupBase pSDEAWGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEAWGroupBase.isCodeNameDirty();
            }
            case 1: {
                return pSDEAWGroupBase.isCreateDateDirty();
            }
            case 2: {
                return pSDEAWGroupBase.isCreateManDirty();
            }
            case 3: {
                return pSDEAWGroupBase.isLockFlagDirty();
            }
            case 4: {
                return pSDEAWGroupBase.isMemoDirty();
            }
            case 5: {
                return pSDEAWGroupBase.isPSDEAWGroupIdDirty();
            }
            case 6: {
                return pSDEAWGroupBase.isPSDEAWGroupNameDirty();
            }
            case 7: {
                return pSDEAWGroupBase.isPSDEIdDirty();
            }
            case 8: {
                return pSDEAWGroupBase.isPSDENameDirty();
            }
            case 9: {
                return pSDEAWGroupBase.isUpdateDateDirty();
            }
            case 10: {
                return pSDEAWGroupBase.isUpdateManDirty();
            }
            case 11: {
                return pSDEAWGroupBase.isUserTagDirty();
            }
            case 12: {
                return pSDEAWGroupBase.isUserTag2Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEAWGroupBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEAWGroupBase pSDEAWGroupBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEAWGroupBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDEAWGroupBase.getJSONValue((Object)pSDEAWGroupBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDEAWGroupBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEAWGroupBase.getJSONValue((Object)pSDEAWGroupBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEAWGroupBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEAWGroupBase.getJSONValue((Object)pSDEAWGroupBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEAWGroupBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSDEAWGroupBase.getJSONValue((Object)pSDEAWGroupBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSDEAWGroupBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEAWGroupBase.getJSONValue((Object)pSDEAWGroupBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEAWGroupBase.getPSDEAWGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeawgroupid", (Object)PSDEAWGroupBase.getJSONValue((Object)pSDEAWGroupBase.getPSDEAWGroupId()), (boolean)false);
        }
        if (bl || pSDEAWGroupBase.getPSDEAWGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeawgroupname", (Object)PSDEAWGroupBase.getJSONValue((Object)pSDEAWGroupBase.getPSDEAWGroupName()), (boolean)false);
        }
        if (bl || pSDEAWGroupBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEAWGroupBase.getJSONValue((Object)pSDEAWGroupBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEAWGroupBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDEAWGroupBase.getJSONValue((Object)pSDEAWGroupBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDEAWGroupBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEAWGroupBase.getJSONValue((Object)pSDEAWGroupBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEAWGroupBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEAWGroupBase.getJSONValue((Object)pSDEAWGroupBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEAWGroupBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEAWGroupBase.getJSONValue((Object)pSDEAWGroupBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEAWGroupBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEAWGroupBase.getJSONValue((Object)pSDEAWGroupBase.getUserTag2()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEAWGroupBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEAWGroupBase pSDEAWGroupBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEAWGroupBase.getCodeName() != null) {
            object = pSDEAWGroupBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEAWGroupBase.getCreateDate() != null) {
            object = pSDEAWGroupBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEAWGroupBase.getCreateMan() != null) {
            object = pSDEAWGroupBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEAWGroupBase.getLockFlag() != null) {
            object = pSDEAWGroupBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEAWGroupBase.getMemo() != null) {
            object = pSDEAWGroupBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEAWGroupBase.getPSDEAWGroupId() != null) {
            object = pSDEAWGroupBase.getPSDEAWGroupId();
            xmlNode.setAttribute(FIELD_PSDEAWGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEAWGroupBase.getPSDEAWGroupName() != null) {
            object = pSDEAWGroupBase.getPSDEAWGroupName();
            xmlNode.setAttribute(FIELD_PSDEAWGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEAWGroupBase.getPSDEId() != null) {
            object = pSDEAWGroupBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEAWGroupBase.getPSDEName() != null) {
            object = pSDEAWGroupBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEAWGroupBase.getUpdateDate() != null) {
            object = pSDEAWGroupBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEAWGroupBase.getUpdateMan() != null) {
            object = pSDEAWGroupBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEAWGroupBase.getUserTag() != null) {
            object = pSDEAWGroupBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEAWGroupBase.getUserTag2() != null) {
            object = pSDEAWGroupBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEAWGroupBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEAWGroupBase pSDEAWGroupBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEAWGroupBase.isCodeNameDirty() && (bl || pSDEAWGroupBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDEAWGroupBase.getCodeName());
        }
        if (pSDEAWGroupBase.isCreateDateDirty() && (bl || pSDEAWGroupBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEAWGroupBase.getCreateDate());
        }
        if (pSDEAWGroupBase.isCreateManDirty() && (bl || pSDEAWGroupBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEAWGroupBase.getCreateMan());
        }
        if (pSDEAWGroupBase.isLockFlagDirty() && (bl || pSDEAWGroupBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSDEAWGroupBase.getLockFlag());
        }
        if (pSDEAWGroupBase.isMemoDirty() && (bl || pSDEAWGroupBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEAWGroupBase.getMemo());
        }
        if (pSDEAWGroupBase.isPSDEAWGroupIdDirty() && (bl || pSDEAWGroupBase.getPSDEAWGroupId() != null)) {
            iDataObject.set(FIELD_PSDEAWGROUPID, (Object)pSDEAWGroupBase.getPSDEAWGroupId());
        }
        if (pSDEAWGroupBase.isPSDEAWGroupNameDirty() && (bl || pSDEAWGroupBase.getPSDEAWGroupName() != null)) {
            iDataObject.set(FIELD_PSDEAWGROUPNAME, (Object)pSDEAWGroupBase.getPSDEAWGroupName());
        }
        if (pSDEAWGroupBase.isPSDEIdDirty() && (bl || pSDEAWGroupBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEAWGroupBase.getPSDEId());
        }
        if (pSDEAWGroupBase.isPSDENameDirty() && (bl || pSDEAWGroupBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDEAWGroupBase.getPSDEName());
        }
        if (pSDEAWGroupBase.isUpdateDateDirty() && (bl || pSDEAWGroupBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEAWGroupBase.getUpdateDate());
        }
        if (pSDEAWGroupBase.isUpdateManDirty() && (bl || pSDEAWGroupBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEAWGroupBase.getUpdateMan());
        }
        if (pSDEAWGroupBase.isUserTagDirty() && (bl || pSDEAWGroupBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEAWGroupBase.getUserTag());
        }
        if (pSDEAWGroupBase.isUserTag2Dirty() && (bl || pSDEAWGroupBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEAWGroupBase.getUserTag2());
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
        return PSDEAWGroupBase.remove(this, n);
    }

    private static boolean remove(PSDEAWGroupBase pSDEAWGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEAWGroupBase.resetCodeName();
                return true;
            }
            case 1: {
                pSDEAWGroupBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDEAWGroupBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDEAWGroupBase.resetLockFlag();
                return true;
            }
            case 4: {
                pSDEAWGroupBase.resetMemo();
                return true;
            }
            case 5: {
                pSDEAWGroupBase.resetPSDEAWGroupId();
                return true;
            }
            case 6: {
                pSDEAWGroupBase.resetPSDEAWGroupName();
                return true;
            }
            case 7: {
                pSDEAWGroupBase.resetPSDEId();
                return true;
            }
            case 8: {
                pSDEAWGroupBase.resetPSDEName();
                return true;
            }
            case 9: {
                pSDEAWGroupBase.resetUpdateDate();
                return true;
            }
            case 10: {
                pSDEAWGroupBase.resetUpdateMan();
                return true;
            }
            case 11: {
                pSDEAWGroupBase.resetUserTag();
                return true;
            }
            case 12: {
                pSDEAWGroupBase.resetUserTag2();
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
                pSDataEntityService.autoGet(pSDataEntity);
                this.psde = pSDataEntity;
            }
            return this.psde;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEAWGrpDetail> getPSDEAWGrpDetails() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEAWGrpDetails();
        }
        if (this.getPSDEAWGroupId() == null) {
            return null;
        }
        PSDEAWGroupService pSDEAWGroupService = (PSDEAWGroupService)ServiceGlobal.getService(PSDEAWGroupService.class, (SessionFactory)this.getSessionFactory());
        PSDEAWGrpDetailService pSDEAWGrpDetailService = (PSDEAWGrpDetailService)ServiceGlobal.getService(PSDEAWGrpDetailService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEAWGrpDetailsLock;
        synchronized (n) {
            if (this.psdeawgrpdetails == null) {
                this.psdeawgrpdetails = pSDEAWGroupService.isTempData(this) ? pSDEAWGrpDetailService.selectTempByPSDEAWGroup(this) : pSDEAWGrpDetailService.selectByPSDEAWGroup(this);
            }
            return this.psdeawgrpdetails;
        }
    }

    private PSDEAWGroupBase getProxyEntity() {
        return this.proxyPSDEAWGroupBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEAWGroupBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEAWGroupBase) {
            this.proxyPSDEAWGroupBase = (PSDEAWGroupBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEAWGroupService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_LOCKFLAG, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PSDEAWGROUPID, 5);
        fieldIndexMap.put(FIELD_PSDEAWGROUPNAME, 6);
        fieldIndexMap.put(FIELD_PSDEID, 7);
        fieldIndexMap.put(FIELD_PSDENAME, 8);
        fieldIndexMap.put(FIELD_UPDATEDATE, 9);
        fieldIndexMap.put(FIELD_UPDATEMAN, 10);
        fieldIndexMap.put(FIELD_USERTAG, 11);
        fieldIndexMap.put(FIELD_USERTAG2, 12);
    }
}

