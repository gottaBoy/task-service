/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntityActionHelper
 *  net.ibizsys.paas.service.ServiceGlobal
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
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevPrdSepcPlanXXXXBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevPrdSepcPlanXXXXBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PLANSTATE = "PLANSTATE";
    public static final String FIELD_PSDEVPRDSEPCPLANID = "PSDEVPRDSEPCPLANID";
    public static final String FIELD_PSDEVPRDSEPCPLANNAME = "PSDEVPRDSEPCPLANNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_ORDERVALUE = 3;
    private static final int INDEX_PLANSTATE = 4;
    private static final int INDEX_PSDEVPRDSEPCPLANID = 5;
    private static final int INDEX_PSDEVPRDSEPCPLANNAME = 6;
    private static final int INDEX_UPDATEDATE = 7;
    private static final int INDEX_UPDATEMAN = 8;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevPrdSepcPlanXXXXBase proxyPSDevPrdSepcPlanXXXXBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean planstateDirtyFlag = false;
    private boolean psdevprdsepcplanidDirtyFlag = false;
    private boolean psdevprdsepcplannameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="planstate")
    private Integer planstate;
    @Column(name="psdevprdsepcplanid")
    private String psdevprdsepcplanid;
    @Column(name="psdevprdsepcplanname")
    private String psdevprdsepcplanname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;

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

    public void setOrderValue(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOrderValue(n);
            return;
        }
        this.ordervalue = n;
        this.ordervalueDirtyFlag = true;
    }

    public Integer getOrderValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOrderValue();
        }
        return this.ordervalue;
    }

    public boolean isOrderValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOrderValueDirty();
        }
        return this.ordervalueDirtyFlag;
    }

    public void resetOrderValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOrderValue();
            return;
        }
        this.ordervalueDirtyFlag = false;
        this.ordervalue = null;
    }

    public void setPlanState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPlanState(n);
            return;
        }
        this.planstate = n;
        this.planstateDirtyFlag = true;
    }

    public Integer getPlanState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPlanState();
        }
        return this.planstate;
    }

    public boolean isPlanStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPlanStateDirty();
        }
        return this.planstateDirtyFlag;
    }

    public void resetPlanState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPlanState();
            return;
        }
        this.planstateDirtyFlag = false;
        this.planstate = null;
    }

    public void setPSDevPrdSepcPlanId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevPrdSepcPlanId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevprdsepcplanid = string;
        this.psdevprdsepcplanidDirtyFlag = true;
    }

    public String getPSDevPrdSepcPlanId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdSepcPlanId();
        }
        return this.psdevprdsepcplanid;
    }

    public boolean isPSDevPrdSepcPlanIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevPrdSepcPlanIdDirty();
        }
        return this.psdevprdsepcplanidDirtyFlag;
    }

    public void resetPSDevPrdSepcPlanId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevPrdSepcPlanId();
            return;
        }
        this.psdevprdsepcplanidDirtyFlag = false;
        this.psdevprdsepcplanid = null;
    }

    public void setPSDevPrdSepcPlanName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevPrdSepcPlanName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevprdsepcplanname = string;
        this.psdevprdsepcplannameDirtyFlag = true;
    }

    public String getPSDevPrdSepcPlanName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdSepcPlanName();
        }
        return this.psdevprdsepcplanname;
    }

    public boolean isPSDevPrdSepcPlanNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevPrdSepcPlanNameDirty();
        }
        return this.psdevprdsepcplannameDirtyFlag;
    }

    public void resetPSDevPrdSepcPlanName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevPrdSepcPlanName();
            return;
        }
        this.psdevprdsepcplannameDirtyFlag = false;
        this.psdevprdsepcplanname = null;
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
        PSDevPrdSepcPlanXXXXBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevPrdSepcPlanXXXXBase pSDevPrdSepcPlanXXXXBase) {
        pSDevPrdSepcPlanXXXXBase.resetCreateDate();
        pSDevPrdSepcPlanXXXXBase.resetCreateMan();
        pSDevPrdSepcPlanXXXXBase.resetMemo();
        pSDevPrdSepcPlanXXXXBase.resetOrderValue();
        pSDevPrdSepcPlanXXXXBase.resetPlanState();
        pSDevPrdSepcPlanXXXXBase.resetPSDevPrdSepcPlanId();
        pSDevPrdSepcPlanXXXXBase.resetPSDevPrdSepcPlanName();
        pSDevPrdSepcPlanXXXXBase.resetUpdateDate();
        pSDevPrdSepcPlanXXXXBase.resetUpdateMan();
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
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPlanStateDirty()) {
            hashMap.put(FIELD_PLANSTATE, this.getPlanState());
        }
        if (!bl || this.isPSDevPrdSepcPlanIdDirty()) {
            hashMap.put(FIELD_PSDEVPRDSEPCPLANID, this.getPSDevPrdSepcPlanId());
        }
        if (!bl || this.isPSDevPrdSepcPlanNameDirty()) {
            hashMap.put(FIELD_PSDEVPRDSEPCPLANNAME, this.getPSDevPrdSepcPlanName());
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
        return PSDevPrdSepcPlanXXXXBase.get(this, n);
    }

    private static Object get(PSDevPrdSepcPlanXXXXBase pSDevPrdSepcPlanXXXXBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevPrdSepcPlanXXXXBase.getCreateDate();
            }
            case 1: {
                return pSDevPrdSepcPlanXXXXBase.getCreateMan();
            }
            case 2: {
                return pSDevPrdSepcPlanXXXXBase.getMemo();
            }
            case 3: {
                return pSDevPrdSepcPlanXXXXBase.getOrderValue();
            }
            case 4: {
                return pSDevPrdSepcPlanXXXXBase.getPlanState();
            }
            case 5: {
                return pSDevPrdSepcPlanXXXXBase.getPSDevPrdSepcPlanId();
            }
            case 6: {
                return pSDevPrdSepcPlanXXXXBase.getPSDevPrdSepcPlanName();
            }
            case 7: {
                return pSDevPrdSepcPlanXXXXBase.getUpdateDate();
            }
            case 8: {
                return pSDevPrdSepcPlanXXXXBase.getUpdateMan();
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
        PSDevPrdSepcPlanXXXXBase.set(this, n, object);
    }

    private static void set(PSDevPrdSepcPlanXXXXBase pSDevPrdSepcPlanXXXXBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevPrdSepcPlanXXXXBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDevPrdSepcPlanXXXXBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDevPrdSepcPlanXXXXBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDevPrdSepcPlanXXXXBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSDevPrdSepcPlanXXXXBase.setPlanState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSDevPrdSepcPlanXXXXBase.setPSDevPrdSepcPlanId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDevPrdSepcPlanXXXXBase.setPSDevPrdSepcPlanName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDevPrdSepcPlanXXXXBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 8: {
                pSDevPrdSepcPlanXXXXBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDevPrdSepcPlanXXXXBase.isNull(this, n);
    }

    private static boolean isNull(PSDevPrdSepcPlanXXXXBase pSDevPrdSepcPlanXXXXBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevPrdSepcPlanXXXXBase.getCreateDate() == null;
            }
            case 1: {
                return pSDevPrdSepcPlanXXXXBase.getCreateMan() == null;
            }
            case 2: {
                return pSDevPrdSepcPlanXXXXBase.getMemo() == null;
            }
            case 3: {
                return pSDevPrdSepcPlanXXXXBase.getOrderValue() == null;
            }
            case 4: {
                return pSDevPrdSepcPlanXXXXBase.getPlanState() == null;
            }
            case 5: {
                return pSDevPrdSepcPlanXXXXBase.getPSDevPrdSepcPlanId() == null;
            }
            case 6: {
                return pSDevPrdSepcPlanXXXXBase.getPSDevPrdSepcPlanName() == null;
            }
            case 7: {
                return pSDevPrdSepcPlanXXXXBase.getUpdateDate() == null;
            }
            case 8: {
                return pSDevPrdSepcPlanXXXXBase.getUpdateMan() == null;
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
        return PSDevPrdSepcPlanXXXXBase.contains(this, n);
    }

    private static boolean contains(PSDevPrdSepcPlanXXXXBase pSDevPrdSepcPlanXXXXBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevPrdSepcPlanXXXXBase.isCreateDateDirty();
            }
            case 1: {
                return pSDevPrdSepcPlanXXXXBase.isCreateManDirty();
            }
            case 2: {
                return pSDevPrdSepcPlanXXXXBase.isMemoDirty();
            }
            case 3: {
                return pSDevPrdSepcPlanXXXXBase.isOrderValueDirty();
            }
            case 4: {
                return pSDevPrdSepcPlanXXXXBase.isPlanStateDirty();
            }
            case 5: {
                return pSDevPrdSepcPlanXXXXBase.isPSDevPrdSepcPlanIdDirty();
            }
            case 6: {
                return pSDevPrdSepcPlanXXXXBase.isPSDevPrdSepcPlanNameDirty();
            }
            case 7: {
                return pSDevPrdSepcPlanXXXXBase.isUpdateDateDirty();
            }
            case 8: {
                return pSDevPrdSepcPlanXXXXBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevPrdSepcPlanXXXXBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevPrdSepcPlanXXXXBase pSDevPrdSepcPlanXXXXBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevPrdSepcPlanXXXXBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevPrdSepcPlanXXXXBase.getJSONValue((Object)pSDevPrdSepcPlanXXXXBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevPrdSepcPlanXXXXBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevPrdSepcPlanXXXXBase.getJSONValue((Object)pSDevPrdSepcPlanXXXXBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevPrdSepcPlanXXXXBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDevPrdSepcPlanXXXXBase.getJSONValue((Object)pSDevPrdSepcPlanXXXXBase.getMemo()), (boolean)false);
        }
        if (bl || pSDevPrdSepcPlanXXXXBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDevPrdSepcPlanXXXXBase.getJSONValue((Object)pSDevPrdSepcPlanXXXXBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDevPrdSepcPlanXXXXBase.getPlanState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"planstate", (Object)PSDevPrdSepcPlanXXXXBase.getJSONValue((Object)pSDevPrdSepcPlanXXXXBase.getPlanState()), (boolean)false);
        }
        if (bl || pSDevPrdSepcPlanXXXXBase.getPSDevPrdSepcPlanId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevprdsepcplanid", (Object)PSDevPrdSepcPlanXXXXBase.getJSONValue((Object)pSDevPrdSepcPlanXXXXBase.getPSDevPrdSepcPlanId()), (boolean)false);
        }
        if (bl || pSDevPrdSepcPlanXXXXBase.getPSDevPrdSepcPlanName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevprdsepcplanname", (Object)PSDevPrdSepcPlanXXXXBase.getJSONValue((Object)pSDevPrdSepcPlanXXXXBase.getPSDevPrdSepcPlanName()), (boolean)false);
        }
        if (bl || pSDevPrdSepcPlanXXXXBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevPrdSepcPlanXXXXBase.getJSONValue((Object)pSDevPrdSepcPlanXXXXBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevPrdSepcPlanXXXXBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevPrdSepcPlanXXXXBase.getJSONValue((Object)pSDevPrdSepcPlanXXXXBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevPrdSepcPlanXXXXBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevPrdSepcPlanXXXXBase pSDevPrdSepcPlanXXXXBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevPrdSepcPlanXXXXBase.getCreateDate() != null) {
            object = pSDevPrdSepcPlanXXXXBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevPrdSepcPlanXXXXBase.getCreateMan() != null) {
            object = pSDevPrdSepcPlanXXXXBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdSepcPlanXXXXBase.getMemo() != null) {
            object = pSDevPrdSepcPlanXXXXBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdSepcPlanXXXXBase.getOrderValue() != null) {
            object = pSDevPrdSepcPlanXXXXBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevPrdSepcPlanXXXXBase.getPlanState() != null) {
            object = pSDevPrdSepcPlanXXXXBase.getPlanState();
            xmlNode.setAttribute(FIELD_PLANSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevPrdSepcPlanXXXXBase.getPSDevPrdSepcPlanId() != null) {
            object = pSDevPrdSepcPlanXXXXBase.getPSDevPrdSepcPlanId();
            xmlNode.setAttribute(FIELD_PSDEVPRDSEPCPLANID, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdSepcPlanXXXXBase.getPSDevPrdSepcPlanName() != null) {
            object = pSDevPrdSepcPlanXXXXBase.getPSDevPrdSepcPlanName();
            xmlNode.setAttribute(FIELD_PSDEVPRDSEPCPLANNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdSepcPlanXXXXBase.getUpdateDate() != null) {
            object = pSDevPrdSepcPlanXXXXBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevPrdSepcPlanXXXXBase.getUpdateMan() != null) {
            object = pSDevPrdSepcPlanXXXXBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevPrdSepcPlanXXXXBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevPrdSepcPlanXXXXBase pSDevPrdSepcPlanXXXXBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevPrdSepcPlanXXXXBase.isCreateDateDirty() && (bl || pSDevPrdSepcPlanXXXXBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevPrdSepcPlanXXXXBase.getCreateDate());
        }
        if (pSDevPrdSepcPlanXXXXBase.isCreateManDirty() && (bl || pSDevPrdSepcPlanXXXXBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevPrdSepcPlanXXXXBase.getCreateMan());
        }
        if (pSDevPrdSepcPlanXXXXBase.isMemoDirty() && (bl || pSDevPrdSepcPlanXXXXBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDevPrdSepcPlanXXXXBase.getMemo());
        }
        if (pSDevPrdSepcPlanXXXXBase.isOrderValueDirty() && (bl || pSDevPrdSepcPlanXXXXBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDevPrdSepcPlanXXXXBase.getOrderValue());
        }
        if (pSDevPrdSepcPlanXXXXBase.isPlanStateDirty() && (bl || pSDevPrdSepcPlanXXXXBase.getPlanState() != null)) {
            iDataObject.set(FIELD_PLANSTATE, (Object)pSDevPrdSepcPlanXXXXBase.getPlanState());
        }
        if (pSDevPrdSepcPlanXXXXBase.isPSDevPrdSepcPlanIdDirty() && (bl || pSDevPrdSepcPlanXXXXBase.getPSDevPrdSepcPlanId() != null)) {
            iDataObject.set(FIELD_PSDEVPRDSEPCPLANID, (Object)pSDevPrdSepcPlanXXXXBase.getPSDevPrdSepcPlanId());
        }
        if (pSDevPrdSepcPlanXXXXBase.isPSDevPrdSepcPlanNameDirty() && (bl || pSDevPrdSepcPlanXXXXBase.getPSDevPrdSepcPlanName() != null)) {
            iDataObject.set(FIELD_PSDEVPRDSEPCPLANNAME, (Object)pSDevPrdSepcPlanXXXXBase.getPSDevPrdSepcPlanName());
        }
        if (pSDevPrdSepcPlanXXXXBase.isUpdateDateDirty() && (bl || pSDevPrdSepcPlanXXXXBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevPrdSepcPlanXXXXBase.getUpdateDate());
        }
        if (pSDevPrdSepcPlanXXXXBase.isUpdateManDirty() && (bl || pSDevPrdSepcPlanXXXXBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevPrdSepcPlanXXXXBase.getUpdateMan());
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
        return PSDevPrdSepcPlanXXXXBase.remove(this, n);
    }

    private static boolean remove(PSDevPrdSepcPlanXXXXBase pSDevPrdSepcPlanXXXXBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevPrdSepcPlanXXXXBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDevPrdSepcPlanXXXXBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDevPrdSepcPlanXXXXBase.resetMemo();
                return true;
            }
            case 3: {
                pSDevPrdSepcPlanXXXXBase.resetOrderValue();
                return true;
            }
            case 4: {
                pSDevPrdSepcPlanXXXXBase.resetPlanState();
                return true;
            }
            case 5: {
                pSDevPrdSepcPlanXXXXBase.resetPSDevPrdSepcPlanId();
                return true;
            }
            case 6: {
                pSDevPrdSepcPlanXXXXBase.resetPSDevPrdSepcPlanName();
                return true;
            }
            case 7: {
                pSDevPrdSepcPlanXXXXBase.resetUpdateDate();
                return true;
            }
            case 8: {
                pSDevPrdSepcPlanXXXXBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSDevPrdSepcPlanXXXXBase getProxyEntity() {
        return this.proxyPSDevPrdSepcPlanXXXXBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevPrdSepcPlanXXXXBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevPrdSepcPlanXXXXBase) {
            this.proxyPSDevPrdSepcPlanXXXXBase = (PSDevPrdSepcPlanXXXXBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdSepcPlanXXXXService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_ORDERVALUE, 3);
        fieldIndexMap.put(FIELD_PLANSTATE, 4);
        fieldIndexMap.put(FIELD_PSDEVPRDSEPCPLANID, 5);
        fieldIndexMap.put(FIELD_PSDEVPRDSEPCPLANNAME, 6);
        fieldIndexMap.put(FIELD_UPDATEDATE, 7);
        fieldIndexMap.put(FIELD_UPDATEMAN, 8);
    }
}

