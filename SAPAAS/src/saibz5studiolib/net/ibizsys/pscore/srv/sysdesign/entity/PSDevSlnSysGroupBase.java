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
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysGD;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysGDService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnSysGroupBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevSlnSysGroupBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEVSLNID = "PSDEVSLNID";
    public static final String FIELD_PSDEVSLNNAME = "PSDEVSLNNAME";
    public static final String FIELD_PSDEVSLNSYSGROUPID = "PSDEVSLNSYSGROUPID";
    public static final String FIELD_PSDEVSLNSYSGROUPNAME = "PSDEVSLNSYSGROUPNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSDEVSLNID = 3;
    private static final int INDEX_PSDEVSLNNAME = 4;
    private static final int INDEX_PSDEVSLNSYSGROUPID = 5;
    private static final int INDEX_PSDEVSLNSYSGROUPNAME = 6;
    private static final int INDEX_UPDATEDATE = 7;
    private static final int INDEX_UPDATEMAN = 8;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevSlnSysGroupBase proxyPSDevSlnSysGroupBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdevslnidDirtyFlag = false;
    private boolean psdevslnnameDirtyFlag = false;
    private boolean psdevslnsysgroupidDirtyFlag = false;
    private boolean psdevslnsysgroupnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psdevslnid")
    private String psdevslnid;
    @Column(name="psdevslnname")
    private String psdevslnname;
    @Column(name="psdevslnsysgroupid")
    private String psdevslnsysgroupid;
    @Column(name="psdevslnsysgroupname")
    private String psdevslnsysgroupname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDevSlnLock = new Integer(1);
    private PSDevSln psdevsln = null;
    private Integer objPSDevSlnSysGroupDetailsLock = new Integer(1);
    private ArrayList<PSDevSlnSysGD> psdevslnsysgroupdetails = null;

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
        PSDevSlnSysGroupBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevSlnSysGroupBase pSDevSlnSysGroupBase) {
        pSDevSlnSysGroupBase.resetCreateDate();
        pSDevSlnSysGroupBase.resetCreateMan();
        pSDevSlnSysGroupBase.resetMemo();
        pSDevSlnSysGroupBase.resetPSDevSlnId();
        pSDevSlnSysGroupBase.resetPSDevSlnName();
        pSDevSlnSysGroupBase.resetPSDevSlnSysGroupId();
        pSDevSlnSysGroupBase.resetPSDevSlnSysGroupName();
        pSDevSlnSysGroupBase.resetUpdateDate();
        pSDevSlnSysGroupBase.resetUpdateMan();
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
        if (!bl || this.isPSDevSlnNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNNAME, this.getPSDevSlnName());
        }
        if (!bl || this.isPSDevSlnSysGroupIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSGROUPID, this.getPSDevSlnSysGroupId());
        }
        if (!bl || this.isPSDevSlnSysGroupNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSGROUPNAME, this.getPSDevSlnSysGroupName());
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
        return PSDevSlnSysGroupBase.get(this, n);
    }

    private static Object get(PSDevSlnSysGroupBase pSDevSlnSysGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnSysGroupBase.getCreateDate();
            }
            case 1: {
                return pSDevSlnSysGroupBase.getCreateMan();
            }
            case 2: {
                return pSDevSlnSysGroupBase.getMemo();
            }
            case 3: {
                return pSDevSlnSysGroupBase.getPSDevSlnId();
            }
            case 4: {
                return pSDevSlnSysGroupBase.getPSDevSlnName();
            }
            case 5: {
                return pSDevSlnSysGroupBase.getPSDevSlnSysGroupId();
            }
            case 6: {
                return pSDevSlnSysGroupBase.getPSDevSlnSysGroupName();
            }
            case 7: {
                return pSDevSlnSysGroupBase.getUpdateDate();
            }
            case 8: {
                return pSDevSlnSysGroupBase.getUpdateMan();
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
        PSDevSlnSysGroupBase.set(this, n, object);
    }

    private static void set(PSDevSlnSysGroupBase pSDevSlnSysGroupBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnSysGroupBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDevSlnSysGroupBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDevSlnSysGroupBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDevSlnSysGroupBase.setPSDevSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDevSlnSysGroupBase.setPSDevSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDevSlnSysGroupBase.setPSDevSlnSysGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDevSlnSysGroupBase.setPSDevSlnSysGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDevSlnSysGroupBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 8: {
                pSDevSlnSysGroupBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDevSlnSysGroupBase.isNull(this, n);
    }

    private static boolean isNull(PSDevSlnSysGroupBase pSDevSlnSysGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnSysGroupBase.getCreateDate() == null;
            }
            case 1: {
                return pSDevSlnSysGroupBase.getCreateMan() == null;
            }
            case 2: {
                return pSDevSlnSysGroupBase.getMemo() == null;
            }
            case 3: {
                return pSDevSlnSysGroupBase.getPSDevSlnId() == null;
            }
            case 4: {
                return pSDevSlnSysGroupBase.getPSDevSlnName() == null;
            }
            case 5: {
                return pSDevSlnSysGroupBase.getPSDevSlnSysGroupId() == null;
            }
            case 6: {
                return pSDevSlnSysGroupBase.getPSDevSlnSysGroupName() == null;
            }
            case 7: {
                return pSDevSlnSysGroupBase.getUpdateDate() == null;
            }
            case 8: {
                return pSDevSlnSysGroupBase.getUpdateMan() == null;
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
        return PSDevSlnSysGroupBase.contains(this, n);
    }

    private static boolean contains(PSDevSlnSysGroupBase pSDevSlnSysGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnSysGroupBase.isCreateDateDirty();
            }
            case 1: {
                return pSDevSlnSysGroupBase.isCreateManDirty();
            }
            case 2: {
                return pSDevSlnSysGroupBase.isMemoDirty();
            }
            case 3: {
                return pSDevSlnSysGroupBase.isPSDevSlnIdDirty();
            }
            case 4: {
                return pSDevSlnSysGroupBase.isPSDevSlnNameDirty();
            }
            case 5: {
                return pSDevSlnSysGroupBase.isPSDevSlnSysGroupIdDirty();
            }
            case 6: {
                return pSDevSlnSysGroupBase.isPSDevSlnSysGroupNameDirty();
            }
            case 7: {
                return pSDevSlnSysGroupBase.isUpdateDateDirty();
            }
            case 8: {
                return pSDevSlnSysGroupBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevSlnSysGroupBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevSlnSysGroupBase pSDevSlnSysGroupBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevSlnSysGroupBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevSlnSysGroupBase.getJSONValue((Object)pSDevSlnSysGroupBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevSlnSysGroupBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevSlnSysGroupBase.getJSONValue((Object)pSDevSlnSysGroupBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevSlnSysGroupBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDevSlnSysGroupBase.getJSONValue((Object)pSDevSlnSysGroupBase.getMemo()), (boolean)false);
        }
        if (bl || pSDevSlnSysGroupBase.getPSDevSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnid", (Object)PSDevSlnSysGroupBase.getJSONValue((Object)pSDevSlnSysGroupBase.getPSDevSlnId()), (boolean)false);
        }
        if (bl || pSDevSlnSysGroupBase.getPSDevSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnname", (Object)PSDevSlnSysGroupBase.getJSONValue((Object)pSDevSlnSysGroupBase.getPSDevSlnName()), (boolean)false);
        }
        if (bl || pSDevSlnSysGroupBase.getPSDevSlnSysGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysgroupid", (Object)PSDevSlnSysGroupBase.getJSONValue((Object)pSDevSlnSysGroupBase.getPSDevSlnSysGroupId()), (boolean)false);
        }
        if (bl || pSDevSlnSysGroupBase.getPSDevSlnSysGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysgroupname", (Object)PSDevSlnSysGroupBase.getJSONValue((Object)pSDevSlnSysGroupBase.getPSDevSlnSysGroupName()), (boolean)false);
        }
        if (bl || pSDevSlnSysGroupBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevSlnSysGroupBase.getJSONValue((Object)pSDevSlnSysGroupBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevSlnSysGroupBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevSlnSysGroupBase.getJSONValue((Object)pSDevSlnSysGroupBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevSlnSysGroupBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevSlnSysGroupBase pSDevSlnSysGroupBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevSlnSysGroupBase.getCreateDate() != null) {
            object = pSDevSlnSysGroupBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysGroupBase.getCreateMan() != null) {
            object = pSDevSlnSysGroupBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysGroupBase.getMemo() != null) {
            object = pSDevSlnSysGroupBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysGroupBase.getPSDevSlnId() != null) {
            object = pSDevSlnSysGroupBase.getPSDevSlnId();
            xmlNode.setAttribute(FIELD_PSDEVSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysGroupBase.getPSDevSlnName() != null) {
            object = pSDevSlnSysGroupBase.getPSDevSlnName();
            xmlNode.setAttribute(FIELD_PSDEVSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysGroupBase.getPSDevSlnSysGroupId() != null) {
            object = pSDevSlnSysGroupBase.getPSDevSlnSysGroupId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysGroupBase.getPSDevSlnSysGroupName() != null) {
            object = pSDevSlnSysGroupBase.getPSDevSlnSysGroupName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysGroupBase.getUpdateDate() != null) {
            object = pSDevSlnSysGroupBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysGroupBase.getUpdateMan() != null) {
            object = pSDevSlnSysGroupBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevSlnSysGroupBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevSlnSysGroupBase pSDevSlnSysGroupBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevSlnSysGroupBase.isCreateDateDirty() && (bl || pSDevSlnSysGroupBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevSlnSysGroupBase.getCreateDate());
        }
        if (pSDevSlnSysGroupBase.isCreateManDirty() && (bl || pSDevSlnSysGroupBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevSlnSysGroupBase.getCreateMan());
        }
        if (pSDevSlnSysGroupBase.isMemoDirty() && (bl || pSDevSlnSysGroupBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDevSlnSysGroupBase.getMemo());
        }
        if (pSDevSlnSysGroupBase.isPSDevSlnIdDirty() && (bl || pSDevSlnSysGroupBase.getPSDevSlnId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNID, (Object)pSDevSlnSysGroupBase.getPSDevSlnId());
        }
        if (pSDevSlnSysGroupBase.isPSDevSlnNameDirty() && (bl || pSDevSlnSysGroupBase.getPSDevSlnName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNNAME, (Object)pSDevSlnSysGroupBase.getPSDevSlnName());
        }
        if (pSDevSlnSysGroupBase.isPSDevSlnSysGroupIdDirty() && (bl || pSDevSlnSysGroupBase.getPSDevSlnSysGroupId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSGROUPID, (Object)pSDevSlnSysGroupBase.getPSDevSlnSysGroupId());
        }
        if (pSDevSlnSysGroupBase.isPSDevSlnSysGroupNameDirty() && (bl || pSDevSlnSysGroupBase.getPSDevSlnSysGroupName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSGROUPNAME, (Object)pSDevSlnSysGroupBase.getPSDevSlnSysGroupName());
        }
        if (pSDevSlnSysGroupBase.isUpdateDateDirty() && (bl || pSDevSlnSysGroupBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevSlnSysGroupBase.getUpdateDate());
        }
        if (pSDevSlnSysGroupBase.isUpdateManDirty() && (bl || pSDevSlnSysGroupBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevSlnSysGroupBase.getUpdateMan());
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
        return PSDevSlnSysGroupBase.remove(this, n);
    }

    private static boolean remove(PSDevSlnSysGroupBase pSDevSlnSysGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnSysGroupBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDevSlnSysGroupBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDevSlnSysGroupBase.resetMemo();
                return true;
            }
            case 3: {
                pSDevSlnSysGroupBase.resetPSDevSlnId();
                return true;
            }
            case 4: {
                pSDevSlnSysGroupBase.resetPSDevSlnName();
                return true;
            }
            case 5: {
                pSDevSlnSysGroupBase.resetPSDevSlnSysGroupId();
                return true;
            }
            case 6: {
                pSDevSlnSysGroupBase.resetPSDevSlnSysGroupName();
                return true;
            }
            case 7: {
                pSDevSlnSysGroupBase.resetUpdateDate();
                return true;
            }
            case 8: {
                pSDevSlnSysGroupBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDevSlnSysGD> getPSDevSlnSysGroupDetails() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysGroupDetails();
        }
        if (this.getPSDevSlnSysGroupId() == null) {
            return null;
        }
        PSDevSlnSysGDService pSDevSlnSysGDService = (PSDevSlnSysGDService)ServiceGlobal.getService(PSDevSlnSysGDService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDevSlnSysGroupDetailsLock;
        synchronized (n) {
            if (this.psdevslnsysgroupdetails == null) {
                this.psdevslnsysgroupdetails = pSDevSlnSysGDService.selectByPSDevSlnSysGroup(this);
            }
            return this.psdevslnsysgroupdetails;
        }
    }

    private PSDevSlnSysGroupBase getProxyEntity() {
        return this.proxyPSDevSlnSysGroupBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevSlnSysGroupBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevSlnSysGroupBase) {
            this.proxyPSDevSlnSysGroupBase = (PSDevSlnSysGroupBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysGroupService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSDEVSLNID, 3);
        fieldIndexMap.put(FIELD_PSDEVSLNNAME, 4);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSGROUPID, 5);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSGROUPNAME, 6);
        fieldIndexMap.put(FIELD_UPDATEDATE, 7);
        fieldIndexMap.put(FIELD_UPDATEMAN, 8);
    }
}

