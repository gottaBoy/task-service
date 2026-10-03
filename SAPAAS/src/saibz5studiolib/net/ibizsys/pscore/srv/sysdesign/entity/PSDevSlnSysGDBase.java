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
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysGroup;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysGroupService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnSysGDBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevSlnSysGDBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEVSLNSYSGDID = "PSDEVSLNSYSGDID";
    public static final String FIELD_PSDEVSLNSYSGDNAME = "PSDEVSLNSYSGDNAME";
    public static final String FIELD_PSDEVSLNSYSGROUPID = "PSDEVSLNSYSGROUPID";
    public static final String FIELD_PSDEVSLNSYSGROUPNAME = "PSDEVSLNSYSGROUPNAME";
    public static final String FIELD_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String FIELD_PSDEVSLNSYSNAME = "PSDEVSLNSYSNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSDEVSLNSYSGDID = 3;
    private static final int INDEX_PSDEVSLNSYSGDNAME = 4;
    private static final int INDEX_PSDEVSLNSYSGROUPID = 5;
    private static final int INDEX_PSDEVSLNSYSGROUPNAME = 6;
    private static final int INDEX_PSDEVSLNSYSID = 7;
    private static final int INDEX_PSDEVSLNSYSNAME = 8;
    private static final int INDEX_UPDATEDATE = 9;
    private static final int INDEX_UPDATEMAN = 10;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevSlnSysGDBase proxyPSDevSlnSysGDBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdevslnsysgdidDirtyFlag = false;
    private boolean psdevslnsysgdnameDirtyFlag = false;
    private boolean psdevslnsysgroupidDirtyFlag = false;
    private boolean psdevslnsysgroupnameDirtyFlag = false;
    private boolean psdevslnsysidDirtyFlag = false;
    private boolean psdevslnsysnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psdevslnsysgdid")
    private String psdevslnsysgdid;
    @Column(name="psdevslnsysgdname")
    private String psdevslnsysgdname;
    @Column(name="psdevslnsysgroupid")
    private String psdevslnsysgroupid;
    @Column(name="psdevslnsysgroupname")
    private String psdevslnsysgroupname;
    @Column(name="psdevslnsysid")
    private String psdevslnsysid;
    @Column(name="psdevslnsysname")
    private String psdevslnsysname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDevSlnSysGroupLock = new Integer(1);
    private PSDevSlnSysGroup psdevslnsysgroup = null;
    private Integer objPSDevSlnSysLock = new Integer(1);
    private PSDevSlnSys psdevslnsys = null;

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

    public void setPSDevSlnSysGDId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysGDId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysgdid = string;
        this.psdevslnsysgdidDirtyFlag = true;
    }

    public String getPSDevSlnSysGDId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysGDId();
        }
        return this.psdevslnsysgdid;
    }

    public boolean isPSDevSlnSysGDIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysGDIdDirty();
        }
        return this.psdevslnsysgdidDirtyFlag;
    }

    public void resetPSDevSlnSysGDId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysGDId();
            return;
        }
        this.psdevslnsysgdidDirtyFlag = false;
        this.psdevslnsysgdid = null;
    }

    public void setPSDevSlnSysGDName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysGDName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysgdname = string;
        this.psdevslnsysgdnameDirtyFlag = true;
    }

    public String getPSDevSlnSysGDName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysGDName();
        }
        return this.psdevslnsysgdname;
    }

    public boolean isPSDevSlnSysGDNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysGDNameDirty();
        }
        return this.psdevslnsysgdnameDirtyFlag;
    }

    public void resetPSDevSlnSysGDName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysGDName();
            return;
        }
        this.psdevslnsysgdnameDirtyFlag = false;
        this.psdevslnsysgdname = null;
    }

    public void setPSDevSlnSysGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysgroupid = string;
        this.psdevslnsysgroupidDirtyFlag = true;
    }

    public String getPSDevSlnSysGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysGroupId();
        }
        return this.psdevslnsysgroupid;
    }

    public boolean isPSDevSlnSysGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysGroupIdDirty();
        }
        return this.psdevslnsysgroupidDirtyFlag;
    }

    public void resetPSDevSlnSysGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysGroupId();
            return;
        }
        this.psdevslnsysgroupidDirtyFlag = false;
        this.psdevslnsysgroupid = null;
    }

    public void setPSDevSlnSysGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysgroupname = string;
        this.psdevslnsysgroupnameDirtyFlag = true;
    }

    public String getPSDevSlnSysGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysGroupName();
        }
        return this.psdevslnsysgroupname;
    }

    public boolean isPSDevSlnSysGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysGroupNameDirty();
        }
        return this.psdevslnsysgroupnameDirtyFlag;
    }

    public void resetPSDevSlnSysGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysGroupName();
            return;
        }
        this.psdevslnsysgroupnameDirtyFlag = false;
        this.psdevslnsysgroupname = null;
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
        PSDevSlnSysGDBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevSlnSysGDBase pSDevSlnSysGDBase) {
        pSDevSlnSysGDBase.resetCreateDate();
        pSDevSlnSysGDBase.resetCreateMan();
        pSDevSlnSysGDBase.resetMemo();
        pSDevSlnSysGDBase.resetPSDevSlnSysGDId();
        pSDevSlnSysGDBase.resetPSDevSlnSysGDName();
        pSDevSlnSysGDBase.resetPSDevSlnSysGroupId();
        pSDevSlnSysGDBase.resetPSDevSlnSysGroupName();
        pSDevSlnSysGDBase.resetPSDevSlnSysId();
        pSDevSlnSysGDBase.resetPSDevSlnSysName();
        pSDevSlnSysGDBase.resetUpdateDate();
        pSDevSlnSysGDBase.resetUpdateMan();
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
        if (!bl || this.isPSDevSlnSysGDIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSGDID, this.getPSDevSlnSysGDId());
        }
        if (!bl || this.isPSDevSlnSysGDNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSGDNAME, this.getPSDevSlnSysGDName());
        }
        if (!bl || this.isPSDevSlnSysGroupIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSGROUPID, this.getPSDevSlnSysGroupId());
        }
        if (!bl || this.isPSDevSlnSysGroupNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSGROUPNAME, this.getPSDevSlnSysGroupName());
        }
        if (!bl || this.isPSDevSlnSysIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSID, this.getPSDevSlnSysId());
        }
        if (!bl || this.isPSDevSlnSysNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSNAME, this.getPSDevSlnSysName());
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
        return PSDevSlnSysGDBase.get(this, n);
    }

    private static Object get(PSDevSlnSysGDBase pSDevSlnSysGDBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnSysGDBase.getCreateDate();
            }
            case 1: {
                return pSDevSlnSysGDBase.getCreateMan();
            }
            case 2: {
                return pSDevSlnSysGDBase.getMemo();
            }
            case 3: {
                return pSDevSlnSysGDBase.getPSDevSlnSysGDId();
            }
            case 4: {
                return pSDevSlnSysGDBase.getPSDevSlnSysGDName();
            }
            case 5: {
                return pSDevSlnSysGDBase.getPSDevSlnSysGroupId();
            }
            case 6: {
                return pSDevSlnSysGDBase.getPSDevSlnSysGroupName();
            }
            case 7: {
                return pSDevSlnSysGDBase.getPSDevSlnSysId();
            }
            case 8: {
                return pSDevSlnSysGDBase.getPSDevSlnSysName();
            }
            case 9: {
                return pSDevSlnSysGDBase.getUpdateDate();
            }
            case 10: {
                return pSDevSlnSysGDBase.getUpdateMan();
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
        PSDevSlnSysGDBase.set(this, n, object);
    }

    private static void set(PSDevSlnSysGDBase pSDevSlnSysGDBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnSysGDBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDevSlnSysGDBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDevSlnSysGDBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDevSlnSysGDBase.setPSDevSlnSysGDId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDevSlnSysGDBase.setPSDevSlnSysGDName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDevSlnSysGDBase.setPSDevSlnSysGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDevSlnSysGDBase.setPSDevSlnSysGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDevSlnSysGDBase.setPSDevSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDevSlnSysGDBase.setPSDevSlnSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDevSlnSysGDBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 10: {
                pSDevSlnSysGDBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDevSlnSysGDBase.isNull(this, n);
    }

    private static boolean isNull(PSDevSlnSysGDBase pSDevSlnSysGDBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnSysGDBase.getCreateDate() == null;
            }
            case 1: {
                return pSDevSlnSysGDBase.getCreateMan() == null;
            }
            case 2: {
                return pSDevSlnSysGDBase.getMemo() == null;
            }
            case 3: {
                return pSDevSlnSysGDBase.getPSDevSlnSysGDId() == null;
            }
            case 4: {
                return pSDevSlnSysGDBase.getPSDevSlnSysGDName() == null;
            }
            case 5: {
                return pSDevSlnSysGDBase.getPSDevSlnSysGroupId() == null;
            }
            case 6: {
                return pSDevSlnSysGDBase.getPSDevSlnSysGroupName() == null;
            }
            case 7: {
                return pSDevSlnSysGDBase.getPSDevSlnSysId() == null;
            }
            case 8: {
                return pSDevSlnSysGDBase.getPSDevSlnSysName() == null;
            }
            case 9: {
                return pSDevSlnSysGDBase.getUpdateDate() == null;
            }
            case 10: {
                return pSDevSlnSysGDBase.getUpdateMan() == null;
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
        return PSDevSlnSysGDBase.contains(this, n);
    }

    private static boolean contains(PSDevSlnSysGDBase pSDevSlnSysGDBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnSysGDBase.isCreateDateDirty();
            }
            case 1: {
                return pSDevSlnSysGDBase.isCreateManDirty();
            }
            case 2: {
                return pSDevSlnSysGDBase.isMemoDirty();
            }
            case 3: {
                return pSDevSlnSysGDBase.isPSDevSlnSysGDIdDirty();
            }
            case 4: {
                return pSDevSlnSysGDBase.isPSDevSlnSysGDNameDirty();
            }
            case 5: {
                return pSDevSlnSysGDBase.isPSDevSlnSysGroupIdDirty();
            }
            case 6: {
                return pSDevSlnSysGDBase.isPSDevSlnSysGroupNameDirty();
            }
            case 7: {
                return pSDevSlnSysGDBase.isPSDevSlnSysIdDirty();
            }
            case 8: {
                return pSDevSlnSysGDBase.isPSDevSlnSysNameDirty();
            }
            case 9: {
                return pSDevSlnSysGDBase.isUpdateDateDirty();
            }
            case 10: {
                return pSDevSlnSysGDBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevSlnSysGDBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevSlnSysGDBase pSDevSlnSysGDBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevSlnSysGDBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevSlnSysGDBase.getJSONValue((Object)pSDevSlnSysGDBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevSlnSysGDBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevSlnSysGDBase.getJSONValue((Object)pSDevSlnSysGDBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevSlnSysGDBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDevSlnSysGDBase.getJSONValue((Object)pSDevSlnSysGDBase.getMemo()), (boolean)false);
        }
        if (bl || pSDevSlnSysGDBase.getPSDevSlnSysGDId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysgdid", (Object)PSDevSlnSysGDBase.getJSONValue((Object)pSDevSlnSysGDBase.getPSDevSlnSysGDId()), (boolean)false);
        }
        if (bl || pSDevSlnSysGDBase.getPSDevSlnSysGDName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysgdname", (Object)PSDevSlnSysGDBase.getJSONValue((Object)pSDevSlnSysGDBase.getPSDevSlnSysGDName()), (boolean)false);
        }
        if (bl || pSDevSlnSysGDBase.getPSDevSlnSysGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysgroupid", (Object)PSDevSlnSysGDBase.getJSONValue((Object)pSDevSlnSysGDBase.getPSDevSlnSysGroupId()), (boolean)false);
        }
        if (bl || pSDevSlnSysGDBase.getPSDevSlnSysGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysgroupname", (Object)PSDevSlnSysGDBase.getJSONValue((Object)pSDevSlnSysGDBase.getPSDevSlnSysGroupName()), (boolean)false);
        }
        if (bl || pSDevSlnSysGDBase.getPSDevSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysid", (Object)PSDevSlnSysGDBase.getJSONValue((Object)pSDevSlnSysGDBase.getPSDevSlnSysId()), (boolean)false);
        }
        if (bl || pSDevSlnSysGDBase.getPSDevSlnSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysname", (Object)PSDevSlnSysGDBase.getJSONValue((Object)pSDevSlnSysGDBase.getPSDevSlnSysName()), (boolean)false);
        }
        if (bl || pSDevSlnSysGDBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevSlnSysGDBase.getJSONValue((Object)pSDevSlnSysGDBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevSlnSysGDBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevSlnSysGDBase.getJSONValue((Object)pSDevSlnSysGDBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevSlnSysGDBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevSlnSysGDBase pSDevSlnSysGDBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevSlnSysGDBase.getCreateDate() != null) {
            object = pSDevSlnSysGDBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysGDBase.getCreateMan() != null) {
            object = pSDevSlnSysGDBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysGDBase.getMemo() != null) {
            object = pSDevSlnSysGDBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysGDBase.getPSDevSlnSysGDId() != null) {
            object = pSDevSlnSysGDBase.getPSDevSlnSysGDId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSGDID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysGDBase.getPSDevSlnSysGDName() != null) {
            object = pSDevSlnSysGDBase.getPSDevSlnSysGDName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSGDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysGDBase.getPSDevSlnSysGroupId() != null) {
            object = pSDevSlnSysGDBase.getPSDevSlnSysGroupId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysGDBase.getPSDevSlnSysGroupName() != null) {
            object = pSDevSlnSysGDBase.getPSDevSlnSysGroupName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysGDBase.getPSDevSlnSysId() != null) {
            object = pSDevSlnSysGDBase.getPSDevSlnSysId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysGDBase.getPSDevSlnSysName() != null) {
            object = pSDevSlnSysGDBase.getPSDevSlnSysName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysGDBase.getUpdateDate() != null) {
            object = pSDevSlnSysGDBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysGDBase.getUpdateMan() != null) {
            object = pSDevSlnSysGDBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevSlnSysGDBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevSlnSysGDBase pSDevSlnSysGDBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevSlnSysGDBase.isCreateDateDirty() && (bl || pSDevSlnSysGDBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevSlnSysGDBase.getCreateDate());
        }
        if (pSDevSlnSysGDBase.isCreateManDirty() && (bl || pSDevSlnSysGDBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevSlnSysGDBase.getCreateMan());
        }
        if (pSDevSlnSysGDBase.isMemoDirty() && (bl || pSDevSlnSysGDBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDevSlnSysGDBase.getMemo());
        }
        if (pSDevSlnSysGDBase.isPSDevSlnSysGDIdDirty() && (bl || pSDevSlnSysGDBase.getPSDevSlnSysGDId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSGDID, (Object)pSDevSlnSysGDBase.getPSDevSlnSysGDId());
        }
        if (pSDevSlnSysGDBase.isPSDevSlnSysGDNameDirty() && (bl || pSDevSlnSysGDBase.getPSDevSlnSysGDName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSGDNAME, (Object)pSDevSlnSysGDBase.getPSDevSlnSysGDName());
        }
        if (pSDevSlnSysGDBase.isPSDevSlnSysGroupIdDirty() && (bl || pSDevSlnSysGDBase.getPSDevSlnSysGroupId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSGROUPID, (Object)pSDevSlnSysGDBase.getPSDevSlnSysGroupId());
        }
        if (pSDevSlnSysGDBase.isPSDevSlnSysGroupNameDirty() && (bl || pSDevSlnSysGDBase.getPSDevSlnSysGroupName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSGROUPNAME, (Object)pSDevSlnSysGDBase.getPSDevSlnSysGroupName());
        }
        if (pSDevSlnSysGDBase.isPSDevSlnSysIdDirty() && (bl || pSDevSlnSysGDBase.getPSDevSlnSysId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSID, (Object)pSDevSlnSysGDBase.getPSDevSlnSysId());
        }
        if (pSDevSlnSysGDBase.isPSDevSlnSysNameDirty() && (bl || pSDevSlnSysGDBase.getPSDevSlnSysName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSNAME, (Object)pSDevSlnSysGDBase.getPSDevSlnSysName());
        }
        if (pSDevSlnSysGDBase.isUpdateDateDirty() && (bl || pSDevSlnSysGDBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevSlnSysGDBase.getUpdateDate());
        }
        if (pSDevSlnSysGDBase.isUpdateManDirty() && (bl || pSDevSlnSysGDBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevSlnSysGDBase.getUpdateMan());
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
        return PSDevSlnSysGDBase.remove(this, n);
    }

    private static boolean remove(PSDevSlnSysGDBase pSDevSlnSysGDBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnSysGDBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDevSlnSysGDBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDevSlnSysGDBase.resetMemo();
                return true;
            }
            case 3: {
                pSDevSlnSysGDBase.resetPSDevSlnSysGDId();
                return true;
            }
            case 4: {
                pSDevSlnSysGDBase.resetPSDevSlnSysGDName();
                return true;
            }
            case 5: {
                pSDevSlnSysGDBase.resetPSDevSlnSysGroupId();
                return true;
            }
            case 6: {
                pSDevSlnSysGDBase.resetPSDevSlnSysGroupName();
                return true;
            }
            case 7: {
                pSDevSlnSysGDBase.resetPSDevSlnSysId();
                return true;
            }
            case 8: {
                pSDevSlnSysGDBase.resetPSDevSlnSysName();
                return true;
            }
            case 9: {
                pSDevSlnSysGDBase.resetUpdateDate();
                return true;
            }
            case 10: {
                pSDevSlnSysGDBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnSysGroup getPSDevSlnSysGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysGroup();
        }
        if (this.getPSDevSlnSysGroupId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnSysGroupLock;
        synchronized (n) {
            if (this.psdevslnsysgroup != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnSysGroupId(), (Object)this.psdevslnsysgroup.getPSDevSlnSysGroupId()) != 0L) {
                this.psdevslnsysgroup = null;
            }
            if (this.psdevslnsysgroup == null) {
                PSDevSlnSysGroup pSDevSlnSysGroup = new PSDevSlnSysGroup();
                pSDevSlnSysGroup.setPSDevSlnSysGroupId(this.getPSDevSlnSysGroupId());
                PSDevSlnSysGroupService pSDevSlnSysGroupService = (PSDevSlnSysGroupService)ServiceGlobal.getService(PSDevSlnSysGroupService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnSysGroupService.autoGet(pSDevSlnSysGroup);
                this.psdevslnsysgroup = pSDevSlnSysGroup;
            }
            return this.psdevslnsysgroup;
        }
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
                pSDevSlnSysService.autoGet(pSDevSlnSys);
                this.psdevslnsys = pSDevSlnSys;
            }
            return this.psdevslnsys;
        }
    }

    private PSDevSlnSysGDBase getProxyEntity() {
        return this.proxyPSDevSlnSysGDBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevSlnSysGDBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevSlnSysGDBase) {
            this.proxyPSDevSlnSysGDBase = (PSDevSlnSysGDBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysGDService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSGDID, 3);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSGDNAME, 4);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSGROUPID, 5);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSGROUPNAME, 6);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSID, 7);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSNAME, 8);
        fieldIndexMap.put(FIELD_UPDATEDATE, 9);
        fieldIndexMap.put(FIELD_UPDATEMAN, 10);
    }
}

