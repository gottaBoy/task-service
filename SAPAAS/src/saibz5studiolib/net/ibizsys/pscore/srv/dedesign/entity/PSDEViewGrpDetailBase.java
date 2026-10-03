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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewGroup;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewGroupService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEViewGrpDetailBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEViewGrpDetailBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEVIEWBASEID = "PSDEVIEWBASEID";
    public static final String FIELD_PSDEVIEWBASENAME = "PSDEVIEWBASENAME";
    public static final String FIELD_PSDEVIEWGROUPID = "PSDEVIEWGROUPID";
    public static final String FIELD_PSDEVIEWGROUPNAME = "PSDEVIEWGROUPNAME";
    public static final String FIELD_PSDEVIEWGRPDETAILID = "PSDEVIEWGRPDETAILID";
    public static final String FIELD_PSDEVIEWGRPDETAILNAME = "PSDEVIEWGRPDETAILNAME";
    public static final String FIELD_REFMODE = "REFMODE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSDEVIEWBASEID = 3;
    private static final int INDEX_PSDEVIEWBASENAME = 4;
    private static final int INDEX_PSDEVIEWGROUPID = 5;
    private static final int INDEX_PSDEVIEWGROUPNAME = 6;
    private static final int INDEX_PSDEVIEWGRPDETAILID = 7;
    private static final int INDEX_PSDEVIEWGRPDETAILNAME = 8;
    private static final int INDEX_REFMODE = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final int INDEX_VALIDFLAG = 12;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEViewGrpDetailBase proxyPSDEViewGrpDetailBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdeviewbaseidDirtyFlag = false;
    private boolean psdeviewbasenameDirtyFlag = false;
    private boolean psdeviewgroupidDirtyFlag = false;
    private boolean psdeviewgroupnameDirtyFlag = false;
    private boolean psdeviewgrpdetailidDirtyFlag = false;
    private boolean psdeviewgrpdetailnameDirtyFlag = false;
    private boolean refmodeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psdeviewbaseid")
    private String psdeviewbaseid;
    @Column(name="psdeviewbasename")
    private String psdeviewbasename;
    @Column(name="psdeviewgroupid")
    private String psdeviewgroupid;
    @Column(name="psdeviewgroupname")
    private String psdeviewgroupname;
    @Column(name="psdeviewgrpdetailid")
    private String psdeviewgrpdetailid;
    @Column(name="psdeviewgrpdetailname")
    private String psdeviewgrpdetailname;
    @Column(name="refmode")
    private String refmode;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSDEViewBaseLock = new Integer(1);
    private PSDEViewBase psdeviewbase = null;
    private Integer objPSDEViewGroupLock = new Integer(1);
    private PSDEViewGroup psdeviewgroup = null;

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

    public void setPSDEViewBaseId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewBaseId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewbaseid = string;
        this.psdeviewbaseidDirtyFlag = true;
    }

    public String getPSDEViewBaseId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewBaseId();
        }
        return this.psdeviewbaseid;
    }

    public boolean isPSDEViewBaseIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewBaseIdDirty();
        }
        return this.psdeviewbaseidDirtyFlag;
    }

    public void resetPSDEViewBaseId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewBaseId();
            return;
        }
        this.psdeviewbaseidDirtyFlag = false;
        this.psdeviewbaseid = null;
    }

    public void setPSDEViewBaseName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewBaseName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewbasename = string;
        this.psdeviewbasenameDirtyFlag = true;
    }

    public String getPSDEViewBaseName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewBaseName();
        }
        return this.psdeviewbasename;
    }

    public boolean isPSDEViewBaseNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewBaseNameDirty();
        }
        return this.psdeviewbasenameDirtyFlag;
    }

    public void resetPSDEViewBaseName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewBaseName();
            return;
        }
        this.psdeviewbasenameDirtyFlag = false;
        this.psdeviewbasename = null;
    }

    public void setPSDEViewGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewgroupid = string;
        this.psdeviewgroupidDirtyFlag = true;
    }

    public String getPSDEViewGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewGroupId();
        }
        return this.psdeviewgroupid;
    }

    public boolean isPSDEViewGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewGroupIdDirty();
        }
        return this.psdeviewgroupidDirtyFlag;
    }

    public void resetPSDEViewGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewGroupId();
            return;
        }
        this.psdeviewgroupidDirtyFlag = false;
        this.psdeviewgroupid = null;
    }

    public void setPSDEViewGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewgroupname = string;
        this.psdeviewgroupnameDirtyFlag = true;
    }

    public String getPSDEViewGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewGroupName();
        }
        return this.psdeviewgroupname;
    }

    public boolean isPSDEViewGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewGroupNameDirty();
        }
        return this.psdeviewgroupnameDirtyFlag;
    }

    public void resetPSDEViewGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewGroupName();
            return;
        }
        this.psdeviewgroupnameDirtyFlag = false;
        this.psdeviewgroupname = null;
    }

    public void setPSDEViewGrpDetailId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewGrpDetailId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewgrpdetailid = string;
        this.psdeviewgrpdetailidDirtyFlag = true;
    }

    public String getPSDEViewGrpDetailId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewGrpDetailId();
        }
        return this.psdeviewgrpdetailid;
    }

    public boolean isPSDEViewGrpDetailIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewGrpDetailIdDirty();
        }
        return this.psdeviewgrpdetailidDirtyFlag;
    }

    public void resetPSDEViewGrpDetailId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewGrpDetailId();
            return;
        }
        this.psdeviewgrpdetailidDirtyFlag = false;
        this.psdeviewgrpdetailid = null;
    }

    public void setPSDEViewGrpDetailName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewGrpDetailName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewgrpdetailname = string;
        this.psdeviewgrpdetailnameDirtyFlag = true;
    }

    public String getPSDEViewGrpDetailName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewGrpDetailName();
        }
        return this.psdeviewgrpdetailname;
    }

    public boolean isPSDEViewGrpDetailNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewGrpDetailNameDirty();
        }
        return this.psdeviewgrpdetailnameDirtyFlag;
    }

    public void resetPSDEViewGrpDetailName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewGrpDetailName();
            return;
        }
        this.psdeviewgrpdetailnameDirtyFlag = false;
        this.psdeviewgrpdetailname = null;
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
        PSDEViewGrpDetailBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEViewGrpDetailBase pSDEViewGrpDetailBase) {
        pSDEViewGrpDetailBase.resetCreateDate();
        pSDEViewGrpDetailBase.resetCreateMan();
        pSDEViewGrpDetailBase.resetMemo();
        pSDEViewGrpDetailBase.resetPSDEViewBaseId();
        pSDEViewGrpDetailBase.resetPSDEViewBaseName();
        pSDEViewGrpDetailBase.resetPSDEViewGroupId();
        pSDEViewGrpDetailBase.resetPSDEViewGroupName();
        pSDEViewGrpDetailBase.resetPSDEViewGrpDetailId();
        pSDEViewGrpDetailBase.resetPSDEViewGrpDetailName();
        pSDEViewGrpDetailBase.resetRefMode();
        pSDEViewGrpDetailBase.resetUpdateDate();
        pSDEViewGrpDetailBase.resetUpdateMan();
        pSDEViewGrpDetailBase.resetValidFlag();
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
        if (!bl || this.isPSDEViewBaseIdDirty()) {
            hashMap.put(FIELD_PSDEVIEWBASEID, this.getPSDEViewBaseId());
        }
        if (!bl || this.isPSDEViewBaseNameDirty()) {
            hashMap.put(FIELD_PSDEVIEWBASENAME, this.getPSDEViewBaseName());
        }
        if (!bl || this.isPSDEViewGroupIdDirty()) {
            hashMap.put(FIELD_PSDEVIEWGROUPID, this.getPSDEViewGroupId());
        }
        if (!bl || this.isPSDEViewGroupNameDirty()) {
            hashMap.put(FIELD_PSDEVIEWGROUPNAME, this.getPSDEViewGroupName());
        }
        if (!bl || this.isPSDEViewGrpDetailIdDirty()) {
            hashMap.put(FIELD_PSDEVIEWGRPDETAILID, this.getPSDEViewGrpDetailId());
        }
        if (!bl || this.isPSDEViewGrpDetailNameDirty()) {
            hashMap.put(FIELD_PSDEVIEWGRPDETAILNAME, this.getPSDEViewGrpDetailName());
        }
        if (!bl || this.isRefModeDirty()) {
            hashMap.put(FIELD_REFMODE, this.getRefMode());
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
        return PSDEViewGrpDetailBase.get(this, n);
    }

    private static Object get(PSDEViewGrpDetailBase pSDEViewGrpDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEViewGrpDetailBase.getCreateDate();
            }
            case 1: {
                return pSDEViewGrpDetailBase.getCreateMan();
            }
            case 2: {
                return pSDEViewGrpDetailBase.getMemo();
            }
            case 3: {
                return pSDEViewGrpDetailBase.getPSDEViewBaseId();
            }
            case 4: {
                return pSDEViewGrpDetailBase.getPSDEViewBaseName();
            }
            case 5: {
                return pSDEViewGrpDetailBase.getPSDEViewGroupId();
            }
            case 6: {
                return pSDEViewGrpDetailBase.getPSDEViewGroupName();
            }
            case 7: {
                return pSDEViewGrpDetailBase.getPSDEViewGrpDetailId();
            }
            case 8: {
                return pSDEViewGrpDetailBase.getPSDEViewGrpDetailName();
            }
            case 9: {
                return pSDEViewGrpDetailBase.getRefMode();
            }
            case 10: {
                return pSDEViewGrpDetailBase.getUpdateDate();
            }
            case 11: {
                return pSDEViewGrpDetailBase.getUpdateMan();
            }
            case 12: {
                return pSDEViewGrpDetailBase.getValidFlag();
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
        PSDEViewGrpDetailBase.set(this, n, object);
    }

    private static void set(PSDEViewGrpDetailBase pSDEViewGrpDetailBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEViewGrpDetailBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDEViewGrpDetailBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEViewGrpDetailBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEViewGrpDetailBase.setPSDEViewBaseId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEViewGrpDetailBase.setPSDEViewBaseName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEViewGrpDetailBase.setPSDEViewGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEViewGrpDetailBase.setPSDEViewGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEViewGrpDetailBase.setPSDEViewGrpDetailId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEViewGrpDetailBase.setPSDEViewGrpDetailName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEViewGrpDetailBase.setRefMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEViewGrpDetailBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSDEViewGrpDetailBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEViewGrpDetailBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDEViewGrpDetailBase.isNull(this, n);
    }

    private static boolean isNull(PSDEViewGrpDetailBase pSDEViewGrpDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEViewGrpDetailBase.getCreateDate() == null;
            }
            case 1: {
                return pSDEViewGrpDetailBase.getCreateMan() == null;
            }
            case 2: {
                return pSDEViewGrpDetailBase.getMemo() == null;
            }
            case 3: {
                return pSDEViewGrpDetailBase.getPSDEViewBaseId() == null;
            }
            case 4: {
                return pSDEViewGrpDetailBase.getPSDEViewBaseName() == null;
            }
            case 5: {
                return pSDEViewGrpDetailBase.getPSDEViewGroupId() == null;
            }
            case 6: {
                return pSDEViewGrpDetailBase.getPSDEViewGroupName() == null;
            }
            case 7: {
                return pSDEViewGrpDetailBase.getPSDEViewGrpDetailId() == null;
            }
            case 8: {
                return pSDEViewGrpDetailBase.getPSDEViewGrpDetailName() == null;
            }
            case 9: {
                return pSDEViewGrpDetailBase.getRefMode() == null;
            }
            case 10: {
                return pSDEViewGrpDetailBase.getUpdateDate() == null;
            }
            case 11: {
                return pSDEViewGrpDetailBase.getUpdateMan() == null;
            }
            case 12: {
                return pSDEViewGrpDetailBase.getValidFlag() == null;
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
        return PSDEViewGrpDetailBase.contains(this, n);
    }

    private static boolean contains(PSDEViewGrpDetailBase pSDEViewGrpDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEViewGrpDetailBase.isCreateDateDirty();
            }
            case 1: {
                return pSDEViewGrpDetailBase.isCreateManDirty();
            }
            case 2: {
                return pSDEViewGrpDetailBase.isMemoDirty();
            }
            case 3: {
                return pSDEViewGrpDetailBase.isPSDEViewBaseIdDirty();
            }
            case 4: {
                return pSDEViewGrpDetailBase.isPSDEViewBaseNameDirty();
            }
            case 5: {
                return pSDEViewGrpDetailBase.isPSDEViewGroupIdDirty();
            }
            case 6: {
                return pSDEViewGrpDetailBase.isPSDEViewGroupNameDirty();
            }
            case 7: {
                return pSDEViewGrpDetailBase.isPSDEViewGrpDetailIdDirty();
            }
            case 8: {
                return pSDEViewGrpDetailBase.isPSDEViewGrpDetailNameDirty();
            }
            case 9: {
                return pSDEViewGrpDetailBase.isRefModeDirty();
            }
            case 10: {
                return pSDEViewGrpDetailBase.isUpdateDateDirty();
            }
            case 11: {
                return pSDEViewGrpDetailBase.isUpdateManDirty();
            }
            case 12: {
                return pSDEViewGrpDetailBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEViewGrpDetailBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEViewGrpDetailBase pSDEViewGrpDetailBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEViewGrpDetailBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEViewGrpDetailBase.getJSONValue((Object)pSDEViewGrpDetailBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEViewGrpDetailBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEViewGrpDetailBase.getJSONValue((Object)pSDEViewGrpDetailBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEViewGrpDetailBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEViewGrpDetailBase.getJSONValue((Object)pSDEViewGrpDetailBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEViewGrpDetailBase.getPSDEViewBaseId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewbaseid", (Object)PSDEViewGrpDetailBase.getJSONValue((Object)pSDEViewGrpDetailBase.getPSDEViewBaseId()), (boolean)false);
        }
        if (bl || pSDEViewGrpDetailBase.getPSDEViewBaseName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewbasename", (Object)PSDEViewGrpDetailBase.getJSONValue((Object)pSDEViewGrpDetailBase.getPSDEViewBaseName()), (boolean)false);
        }
        if (bl || pSDEViewGrpDetailBase.getPSDEViewGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewgroupid", (Object)PSDEViewGrpDetailBase.getJSONValue((Object)pSDEViewGrpDetailBase.getPSDEViewGroupId()), (boolean)false);
        }
        if (bl || pSDEViewGrpDetailBase.getPSDEViewGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewgroupname", (Object)PSDEViewGrpDetailBase.getJSONValue((Object)pSDEViewGrpDetailBase.getPSDEViewGroupName()), (boolean)false);
        }
        if (bl || pSDEViewGrpDetailBase.getPSDEViewGrpDetailId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewgrpdetailid", (Object)PSDEViewGrpDetailBase.getJSONValue((Object)pSDEViewGrpDetailBase.getPSDEViewGrpDetailId()), (boolean)false);
        }
        if (bl || pSDEViewGrpDetailBase.getPSDEViewGrpDetailName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewgrpdetailname", (Object)PSDEViewGrpDetailBase.getJSONValue((Object)pSDEViewGrpDetailBase.getPSDEViewGrpDetailName()), (boolean)false);
        }
        if (bl || pSDEViewGrpDetailBase.getRefMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refmode", (Object)PSDEViewGrpDetailBase.getJSONValue((Object)pSDEViewGrpDetailBase.getRefMode()), (boolean)false);
        }
        if (bl || pSDEViewGrpDetailBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEViewGrpDetailBase.getJSONValue((Object)pSDEViewGrpDetailBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEViewGrpDetailBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEViewGrpDetailBase.getJSONValue((Object)pSDEViewGrpDetailBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEViewGrpDetailBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDEViewGrpDetailBase.getJSONValue((Object)pSDEViewGrpDetailBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEViewGrpDetailBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEViewGrpDetailBase pSDEViewGrpDetailBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEViewGrpDetailBase.getCreateDate() != null) {
            object = pSDEViewGrpDetailBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEViewGrpDetailBase.getCreateMan() != null) {
            object = pSDEViewGrpDetailBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewGrpDetailBase.getMemo() != null) {
            object = pSDEViewGrpDetailBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewGrpDetailBase.getPSDEViewBaseId() != null) {
            object = pSDEViewGrpDetailBase.getPSDEViewBaseId();
            xmlNode.setAttribute(FIELD_PSDEVIEWBASEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewGrpDetailBase.getPSDEViewBaseName() != null) {
            object = pSDEViewGrpDetailBase.getPSDEViewBaseName();
            xmlNode.setAttribute(FIELD_PSDEVIEWBASENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewGrpDetailBase.getPSDEViewGroupId() != null) {
            object = pSDEViewGrpDetailBase.getPSDEViewGroupId();
            xmlNode.setAttribute(FIELD_PSDEVIEWGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewGrpDetailBase.getPSDEViewGroupName() != null) {
            object = pSDEViewGrpDetailBase.getPSDEViewGroupName();
            xmlNode.setAttribute(FIELD_PSDEVIEWGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewGrpDetailBase.getPSDEViewGrpDetailId() != null) {
            object = pSDEViewGrpDetailBase.getPSDEViewGrpDetailId();
            xmlNode.setAttribute(FIELD_PSDEVIEWGRPDETAILID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewGrpDetailBase.getPSDEViewGrpDetailName() != null) {
            object = pSDEViewGrpDetailBase.getPSDEViewGrpDetailName();
            xmlNode.setAttribute(FIELD_PSDEVIEWGRPDETAILNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewGrpDetailBase.getRefMode() != null) {
            object = pSDEViewGrpDetailBase.getRefMode();
            xmlNode.setAttribute(FIELD_REFMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewGrpDetailBase.getUpdateDate() != null) {
            object = pSDEViewGrpDetailBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEViewGrpDetailBase.getUpdateMan() != null) {
            object = pSDEViewGrpDetailBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewGrpDetailBase.getValidFlag() != null) {
            object = pSDEViewGrpDetailBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEViewGrpDetailBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEViewGrpDetailBase pSDEViewGrpDetailBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEViewGrpDetailBase.isCreateDateDirty() && (bl || pSDEViewGrpDetailBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEViewGrpDetailBase.getCreateDate());
        }
        if (pSDEViewGrpDetailBase.isCreateManDirty() && (bl || pSDEViewGrpDetailBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEViewGrpDetailBase.getCreateMan());
        }
        if (pSDEViewGrpDetailBase.isMemoDirty() && (bl || pSDEViewGrpDetailBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEViewGrpDetailBase.getMemo());
        }
        if (pSDEViewGrpDetailBase.isPSDEViewBaseIdDirty() && (bl || pSDEViewGrpDetailBase.getPSDEViewBaseId() != null)) {
            iDataObject.set(FIELD_PSDEVIEWBASEID, (Object)pSDEViewGrpDetailBase.getPSDEViewBaseId());
        }
        if (pSDEViewGrpDetailBase.isPSDEViewBaseNameDirty() && (bl || pSDEViewGrpDetailBase.getPSDEViewBaseName() != null)) {
            iDataObject.set(FIELD_PSDEVIEWBASENAME, (Object)pSDEViewGrpDetailBase.getPSDEViewBaseName());
        }
        if (pSDEViewGrpDetailBase.isPSDEViewGroupIdDirty() && (bl || pSDEViewGrpDetailBase.getPSDEViewGroupId() != null)) {
            iDataObject.set(FIELD_PSDEVIEWGROUPID, (Object)pSDEViewGrpDetailBase.getPSDEViewGroupId());
        }
        if (pSDEViewGrpDetailBase.isPSDEViewGroupNameDirty() && (bl || pSDEViewGrpDetailBase.getPSDEViewGroupName() != null)) {
            iDataObject.set(FIELD_PSDEVIEWGROUPNAME, (Object)pSDEViewGrpDetailBase.getPSDEViewGroupName());
        }
        if (pSDEViewGrpDetailBase.isPSDEViewGrpDetailIdDirty() && (bl || pSDEViewGrpDetailBase.getPSDEViewGrpDetailId() != null)) {
            iDataObject.set(FIELD_PSDEVIEWGRPDETAILID, (Object)pSDEViewGrpDetailBase.getPSDEViewGrpDetailId());
        }
        if (pSDEViewGrpDetailBase.isPSDEViewGrpDetailNameDirty() && (bl || pSDEViewGrpDetailBase.getPSDEViewGrpDetailName() != null)) {
            iDataObject.set(FIELD_PSDEVIEWGRPDETAILNAME, (Object)pSDEViewGrpDetailBase.getPSDEViewGrpDetailName());
        }
        if (pSDEViewGrpDetailBase.isRefModeDirty() && (bl || pSDEViewGrpDetailBase.getRefMode() != null)) {
            iDataObject.set(FIELD_REFMODE, (Object)pSDEViewGrpDetailBase.getRefMode());
        }
        if (pSDEViewGrpDetailBase.isUpdateDateDirty() && (bl || pSDEViewGrpDetailBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEViewGrpDetailBase.getUpdateDate());
        }
        if (pSDEViewGrpDetailBase.isUpdateManDirty() && (bl || pSDEViewGrpDetailBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEViewGrpDetailBase.getUpdateMan());
        }
        if (pSDEViewGrpDetailBase.isValidFlagDirty() && (bl || pSDEViewGrpDetailBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDEViewGrpDetailBase.getValidFlag());
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
        return PSDEViewGrpDetailBase.remove(this, n);
    }

    private static boolean remove(PSDEViewGrpDetailBase pSDEViewGrpDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEViewGrpDetailBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDEViewGrpDetailBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDEViewGrpDetailBase.resetMemo();
                return true;
            }
            case 3: {
                pSDEViewGrpDetailBase.resetPSDEViewBaseId();
                return true;
            }
            case 4: {
                pSDEViewGrpDetailBase.resetPSDEViewBaseName();
                return true;
            }
            case 5: {
                pSDEViewGrpDetailBase.resetPSDEViewGroupId();
                return true;
            }
            case 6: {
                pSDEViewGrpDetailBase.resetPSDEViewGroupName();
                return true;
            }
            case 7: {
                pSDEViewGrpDetailBase.resetPSDEViewGrpDetailId();
                return true;
            }
            case 8: {
                pSDEViewGrpDetailBase.resetPSDEViewGrpDetailName();
                return true;
            }
            case 9: {
                pSDEViewGrpDetailBase.resetRefMode();
                return true;
            }
            case 10: {
                pSDEViewGrpDetailBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSDEViewGrpDetailBase.resetUpdateMan();
                return true;
            }
            case 12: {
                pSDEViewGrpDetailBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEViewBase getPSDEViewBase() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewBase();
        }
        if (this.getPSDEViewBaseId() == null) {
            return null;
        }
        Integer n = this.objPSDEViewBaseLock;
        synchronized (n) {
            if (this.psdeviewbase != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEViewBaseId(), (Object)this.psdeviewbase.getPSDEViewBaseId()) != 0L) {
                this.psdeviewbase = null;
            }
            if (this.psdeviewbase == null) {
                PSDEViewBase pSDEViewBase = new PSDEViewBase();
                pSDEViewBase.setPSDEViewBaseId(this.getPSDEViewBaseId());
                PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
                pSDEViewBaseService.autoGet(pSDEViewBase);
                this.psdeviewbase = pSDEViewBase;
            }
            return this.psdeviewbase;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEViewGroup getPSDEViewGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewGroup();
        }
        if (this.getPSDEViewGroupId() == null) {
            return null;
        }
        Integer n = this.objPSDEViewGroupLock;
        synchronized (n) {
            if (this.psdeviewgroup != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEViewGroupId(), (Object)this.psdeviewgroup.getPSDEViewGroupId()) != 0L) {
                this.psdeviewgroup = null;
            }
            if (this.psdeviewgroup == null) {
                PSDEViewGroup pSDEViewGroup = new PSDEViewGroup();
                pSDEViewGroup.setPSDEViewGroupId(this.getPSDEViewGroupId());
                PSDEViewGroupService pSDEViewGroupService = (PSDEViewGroupService)ServiceGlobal.getService(PSDEViewGroupService.class, (SessionFactory)this.getSessionFactory());
                pSDEViewGroupService.autoGet(pSDEViewGroup);
                this.psdeviewgroup = pSDEViewGroup;
            }
            return this.psdeviewgroup;
        }
    }

    private PSDEViewGrpDetailBase getProxyEntity() {
        return this.proxyPSDEViewGrpDetailBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEViewGrpDetailBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEViewGrpDetailBase) {
            this.proxyPSDEViewGrpDetailBase = (PSDEViewGrpDetailBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewGrpDetailService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSDEVIEWBASEID, 3);
        fieldIndexMap.put(FIELD_PSDEVIEWBASENAME, 4);
        fieldIndexMap.put(FIELD_PSDEVIEWGROUPID, 5);
        fieldIndexMap.put(FIELD_PSDEVIEWGROUPNAME, 6);
        fieldIndexMap.put(FIELD_PSDEVIEWGRPDETAILID, 7);
        fieldIndexMap.put(FIELD_PSDEVIEWGRPDETAILNAME, 8);
        fieldIndexMap.put(FIELD_REFMODE, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
        fieldIndexMap.put(FIELD_VALIDFLAG, 12);
    }
}

