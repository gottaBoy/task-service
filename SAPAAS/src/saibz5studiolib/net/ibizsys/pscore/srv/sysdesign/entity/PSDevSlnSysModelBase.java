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

public abstract class PSDevSlnSysModelBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevSlnSysModelBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CURCNT = "CURCNT";
    public static final String FIELD_MAXCNT = "MAXCNT";
    public static final String FIELD_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String FIELD_PSDEVSLNSYSMODELID = "PSDEVSLNSYSMODELID";
    public static final String FIELD_PSDEVSLNSYSMODELNAME = "PSDEVSLNSYSMODELNAME";
    public static final String FIELD_PSDEVSLNSYSNAME = "PSDEVSLNSYSNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_CURCNT = 2;
    private static final int INDEX_MAXCNT = 3;
    private static final int INDEX_PSDEVSLNSYSID = 4;
    private static final int INDEX_PSDEVSLNSYSMODELID = 5;
    private static final int INDEX_PSDEVSLNSYSMODELNAME = 6;
    private static final int INDEX_PSDEVSLNSYSNAME = 7;
    private static final int INDEX_UPDATEDATE = 8;
    private static final int INDEX_UPDATEMAN = 9;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevSlnSysModelBase proxyPSDevSlnSysModelBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean curcntDirtyFlag = false;
    private boolean maxcntDirtyFlag = false;
    private boolean psdevslnsysidDirtyFlag = false;
    private boolean psdevslnsysmodelidDirtyFlag = false;
    private boolean psdevslnsysmodelnameDirtyFlag = false;
    private boolean psdevslnsysnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="curcnt")
    private Integer curcnt;
    @Column(name="maxcnt")
    private Integer maxcnt;
    @Column(name="psdevslnsysid")
    private String psdevslnsysid;
    @Column(name="psdevslnsysmodelid")
    private String psdevslnsysmodelid;
    @Column(name="psdevslnsysmodelname")
    private String psdevslnsysmodelname;
    @Column(name="psdevslnsysname")
    private String psdevslnsysname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
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

    public void setCurCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCurCnt(n);
            return;
        }
        this.curcnt = n;
        this.curcntDirtyFlag = true;
    }

    public Integer getCurCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCurCnt();
        }
        return this.curcnt;
    }

    public boolean isCurCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCurCntDirty();
        }
        return this.curcntDirtyFlag;
    }

    public void resetCurCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCurCnt();
            return;
        }
        this.curcntDirtyFlag = false;
        this.curcnt = null;
    }

    public void setMaxCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMaxCnt(n);
            return;
        }
        this.maxcnt = n;
        this.maxcntDirtyFlag = true;
    }

    public Integer getMaxCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMaxCnt();
        }
        return this.maxcnt;
    }

    public boolean isMaxCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMaxCntDirty();
        }
        return this.maxcntDirtyFlag;
    }

    public void resetMaxCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMaxCnt();
            return;
        }
        this.maxcntDirtyFlag = false;
        this.maxcnt = null;
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

    public void setPSDevSlnSysModelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysModelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysmodelid = string;
        this.psdevslnsysmodelidDirtyFlag = true;
    }

    public String getPSDevSlnSysModelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysModelId();
        }
        return this.psdevslnsysmodelid;
    }

    public boolean isPSDevSlnSysModelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysModelIdDirty();
        }
        return this.psdevslnsysmodelidDirtyFlag;
    }

    public void resetPSDevSlnSysModelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysModelId();
            return;
        }
        this.psdevslnsysmodelidDirtyFlag = false;
        this.psdevslnsysmodelid = null;
    }

    public void setPSDevSlnSysModelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysModelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysmodelname = string;
        this.psdevslnsysmodelnameDirtyFlag = true;
    }

    public String getPSDevSlnSysModelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysModelName();
        }
        return this.psdevslnsysmodelname;
    }

    public boolean isPSDevSlnSysModelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysModelNameDirty();
        }
        return this.psdevslnsysmodelnameDirtyFlag;
    }

    public void resetPSDevSlnSysModelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysModelName();
            return;
        }
        this.psdevslnsysmodelnameDirtyFlag = false;
        this.psdevslnsysmodelname = null;
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
        PSDevSlnSysModelBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevSlnSysModelBase pSDevSlnSysModelBase) {
        pSDevSlnSysModelBase.resetCreateDate();
        pSDevSlnSysModelBase.resetCreateMan();
        pSDevSlnSysModelBase.resetCurCnt();
        pSDevSlnSysModelBase.resetMaxCnt();
        pSDevSlnSysModelBase.resetPSDevSlnSysId();
        pSDevSlnSysModelBase.resetPSDevSlnSysModelId();
        pSDevSlnSysModelBase.resetPSDevSlnSysModelName();
        pSDevSlnSysModelBase.resetPSDevSlnSysName();
        pSDevSlnSysModelBase.resetUpdateDate();
        pSDevSlnSysModelBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCurCntDirty()) {
            hashMap.put(FIELD_CURCNT, this.getCurCnt());
        }
        if (!bl || this.isMaxCntDirty()) {
            hashMap.put(FIELD_MAXCNT, this.getMaxCnt());
        }
        if (!bl || this.isPSDevSlnSysIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSID, this.getPSDevSlnSysId());
        }
        if (!bl || this.isPSDevSlnSysModelIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSMODELID, this.getPSDevSlnSysModelId());
        }
        if (!bl || this.isPSDevSlnSysModelNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSMODELNAME, this.getPSDevSlnSysModelName());
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
        return PSDevSlnSysModelBase.get(this, n);
    }

    private static Object get(PSDevSlnSysModelBase pSDevSlnSysModelBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnSysModelBase.getCreateDate();
            }
            case 1: {
                return pSDevSlnSysModelBase.getCreateMan();
            }
            case 2: {
                return pSDevSlnSysModelBase.getCurCnt();
            }
            case 3: {
                return pSDevSlnSysModelBase.getMaxCnt();
            }
            case 4: {
                return pSDevSlnSysModelBase.getPSDevSlnSysId();
            }
            case 5: {
                return pSDevSlnSysModelBase.getPSDevSlnSysModelId();
            }
            case 6: {
                return pSDevSlnSysModelBase.getPSDevSlnSysModelName();
            }
            case 7: {
                return pSDevSlnSysModelBase.getPSDevSlnSysName();
            }
            case 8: {
                return pSDevSlnSysModelBase.getUpdateDate();
            }
            case 9: {
                return pSDevSlnSysModelBase.getUpdateMan();
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
        PSDevSlnSysModelBase.set(this, n, object);
    }

    private static void set(PSDevSlnSysModelBase pSDevSlnSysModelBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnSysModelBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDevSlnSysModelBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDevSlnSysModelBase.setCurCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSDevSlnSysModelBase.setMaxCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSDevSlnSysModelBase.setPSDevSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDevSlnSysModelBase.setPSDevSlnSysModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDevSlnSysModelBase.setPSDevSlnSysModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDevSlnSysModelBase.setPSDevSlnSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDevSlnSysModelBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 9: {
                pSDevSlnSysModelBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDevSlnSysModelBase.isNull(this, n);
    }

    private static boolean isNull(PSDevSlnSysModelBase pSDevSlnSysModelBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnSysModelBase.getCreateDate() == null;
            }
            case 1: {
                return pSDevSlnSysModelBase.getCreateMan() == null;
            }
            case 2: {
                return pSDevSlnSysModelBase.getCurCnt() == null;
            }
            case 3: {
                return pSDevSlnSysModelBase.getMaxCnt() == null;
            }
            case 4: {
                return pSDevSlnSysModelBase.getPSDevSlnSysId() == null;
            }
            case 5: {
                return pSDevSlnSysModelBase.getPSDevSlnSysModelId() == null;
            }
            case 6: {
                return pSDevSlnSysModelBase.getPSDevSlnSysModelName() == null;
            }
            case 7: {
                return pSDevSlnSysModelBase.getPSDevSlnSysName() == null;
            }
            case 8: {
                return pSDevSlnSysModelBase.getUpdateDate() == null;
            }
            case 9: {
                return pSDevSlnSysModelBase.getUpdateMan() == null;
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
        return PSDevSlnSysModelBase.contains(this, n);
    }

    private static boolean contains(PSDevSlnSysModelBase pSDevSlnSysModelBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnSysModelBase.isCreateDateDirty();
            }
            case 1: {
                return pSDevSlnSysModelBase.isCreateManDirty();
            }
            case 2: {
                return pSDevSlnSysModelBase.isCurCntDirty();
            }
            case 3: {
                return pSDevSlnSysModelBase.isMaxCntDirty();
            }
            case 4: {
                return pSDevSlnSysModelBase.isPSDevSlnSysIdDirty();
            }
            case 5: {
                return pSDevSlnSysModelBase.isPSDevSlnSysModelIdDirty();
            }
            case 6: {
                return pSDevSlnSysModelBase.isPSDevSlnSysModelNameDirty();
            }
            case 7: {
                return pSDevSlnSysModelBase.isPSDevSlnSysNameDirty();
            }
            case 8: {
                return pSDevSlnSysModelBase.isUpdateDateDirty();
            }
            case 9: {
                return pSDevSlnSysModelBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevSlnSysModelBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevSlnSysModelBase pSDevSlnSysModelBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevSlnSysModelBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevSlnSysModelBase.getJSONValue((Object)pSDevSlnSysModelBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevSlnSysModelBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevSlnSysModelBase.getJSONValue((Object)pSDevSlnSysModelBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevSlnSysModelBase.getCurCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"curcnt", (Object)PSDevSlnSysModelBase.getJSONValue((Object)pSDevSlnSysModelBase.getCurCnt()), (boolean)false);
        }
        if (bl || pSDevSlnSysModelBase.getMaxCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maxcnt", (Object)PSDevSlnSysModelBase.getJSONValue((Object)pSDevSlnSysModelBase.getMaxCnt()), (boolean)false);
        }
        if (bl || pSDevSlnSysModelBase.getPSDevSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysid", (Object)PSDevSlnSysModelBase.getJSONValue((Object)pSDevSlnSysModelBase.getPSDevSlnSysId()), (boolean)false);
        }
        if (bl || pSDevSlnSysModelBase.getPSDevSlnSysModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysmodelid", (Object)PSDevSlnSysModelBase.getJSONValue((Object)pSDevSlnSysModelBase.getPSDevSlnSysModelId()), (boolean)false);
        }
        if (bl || pSDevSlnSysModelBase.getPSDevSlnSysModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysmodelname", (Object)PSDevSlnSysModelBase.getJSONValue((Object)pSDevSlnSysModelBase.getPSDevSlnSysModelName()), (boolean)false);
        }
        if (bl || pSDevSlnSysModelBase.getPSDevSlnSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysname", (Object)PSDevSlnSysModelBase.getJSONValue((Object)pSDevSlnSysModelBase.getPSDevSlnSysName()), (boolean)false);
        }
        if (bl || pSDevSlnSysModelBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevSlnSysModelBase.getJSONValue((Object)pSDevSlnSysModelBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevSlnSysModelBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevSlnSysModelBase.getJSONValue((Object)pSDevSlnSysModelBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevSlnSysModelBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevSlnSysModelBase pSDevSlnSysModelBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevSlnSysModelBase.getCreateDate() != null) {
            object = pSDevSlnSysModelBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysModelBase.getCreateMan() != null) {
            object = pSDevSlnSysModelBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysModelBase.getCurCnt() != null) {
            object = pSDevSlnSysModelBase.getCurCnt();
            xmlNode.setAttribute(FIELD_CURCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnSysModelBase.getMaxCnt() != null) {
            object = pSDevSlnSysModelBase.getMaxCnt();
            xmlNode.setAttribute(FIELD_MAXCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnSysModelBase.getPSDevSlnSysId() != null) {
            object = pSDevSlnSysModelBase.getPSDevSlnSysId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysModelBase.getPSDevSlnSysModelId() != null) {
            object = pSDevSlnSysModelBase.getPSDevSlnSysModelId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysModelBase.getPSDevSlnSysModelName() != null) {
            object = pSDevSlnSysModelBase.getPSDevSlnSysModelName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysModelBase.getPSDevSlnSysName() != null) {
            object = pSDevSlnSysModelBase.getPSDevSlnSysName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysModelBase.getUpdateDate() != null) {
            object = pSDevSlnSysModelBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysModelBase.getUpdateMan() != null) {
            object = pSDevSlnSysModelBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevSlnSysModelBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevSlnSysModelBase pSDevSlnSysModelBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevSlnSysModelBase.isCreateDateDirty() && (bl || pSDevSlnSysModelBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevSlnSysModelBase.getCreateDate());
        }
        if (pSDevSlnSysModelBase.isCreateManDirty() && (bl || pSDevSlnSysModelBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevSlnSysModelBase.getCreateMan());
        }
        if (pSDevSlnSysModelBase.isCurCntDirty() && (bl || pSDevSlnSysModelBase.getCurCnt() != null)) {
            iDataObject.set(FIELD_CURCNT, (Object)pSDevSlnSysModelBase.getCurCnt());
        }
        if (pSDevSlnSysModelBase.isMaxCntDirty() && (bl || pSDevSlnSysModelBase.getMaxCnt() != null)) {
            iDataObject.set(FIELD_MAXCNT, (Object)pSDevSlnSysModelBase.getMaxCnt());
        }
        if (pSDevSlnSysModelBase.isPSDevSlnSysIdDirty() && (bl || pSDevSlnSysModelBase.getPSDevSlnSysId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSID, (Object)pSDevSlnSysModelBase.getPSDevSlnSysId());
        }
        if (pSDevSlnSysModelBase.isPSDevSlnSysModelIdDirty() && (bl || pSDevSlnSysModelBase.getPSDevSlnSysModelId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSMODELID, (Object)pSDevSlnSysModelBase.getPSDevSlnSysModelId());
        }
        if (pSDevSlnSysModelBase.isPSDevSlnSysModelNameDirty() && (bl || pSDevSlnSysModelBase.getPSDevSlnSysModelName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSMODELNAME, (Object)pSDevSlnSysModelBase.getPSDevSlnSysModelName());
        }
        if (pSDevSlnSysModelBase.isPSDevSlnSysNameDirty() && (bl || pSDevSlnSysModelBase.getPSDevSlnSysName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSNAME, (Object)pSDevSlnSysModelBase.getPSDevSlnSysName());
        }
        if (pSDevSlnSysModelBase.isUpdateDateDirty() && (bl || pSDevSlnSysModelBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevSlnSysModelBase.getUpdateDate());
        }
        if (pSDevSlnSysModelBase.isUpdateManDirty() && (bl || pSDevSlnSysModelBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevSlnSysModelBase.getUpdateMan());
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
        return PSDevSlnSysModelBase.remove(this, n);
    }

    private static boolean remove(PSDevSlnSysModelBase pSDevSlnSysModelBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnSysModelBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDevSlnSysModelBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDevSlnSysModelBase.resetCurCnt();
                return true;
            }
            case 3: {
                pSDevSlnSysModelBase.resetMaxCnt();
                return true;
            }
            case 4: {
                pSDevSlnSysModelBase.resetPSDevSlnSysId();
                return true;
            }
            case 5: {
                pSDevSlnSysModelBase.resetPSDevSlnSysModelId();
                return true;
            }
            case 6: {
                pSDevSlnSysModelBase.resetPSDevSlnSysModelName();
                return true;
            }
            case 7: {
                pSDevSlnSysModelBase.resetPSDevSlnSysName();
                return true;
            }
            case 8: {
                pSDevSlnSysModelBase.resetUpdateDate();
                return true;
            }
            case 9: {
                pSDevSlnSysModelBase.resetUpdateMan();
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
                pSDevSlnSysService.autoGet(pSDevSlnSys);
                this.psdevslnsys = pSDevSlnSys;
            }
            return this.psdevslnsys;
        }
    }

    private PSDevSlnSysModelBase getProxyEntity() {
        return this.proxyPSDevSlnSysModelBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevSlnSysModelBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevSlnSysModelBase) {
            this.proxyPSDevSlnSysModelBase = (PSDevSlnSysModelBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysModelService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_CURCNT, 2);
        fieldIndexMap.put(FIELD_MAXCNT, 3);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSID, 4);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSMODELID, 5);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSMODELNAME, 6);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSNAME, 7);
        fieldIndexMap.put(FIELD_UPDATEDATE, 8);
        fieldIndexMap.put(FIELD_UPDATEMAN, 9);
    }
}

