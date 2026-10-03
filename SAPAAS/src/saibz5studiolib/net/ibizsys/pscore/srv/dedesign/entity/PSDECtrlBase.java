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
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDECtrlBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDECtrlBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDECTRLID = "PSDECTRLID";
    public static final String FIELD_PSDECTRLNAME = "PSDECTRLNAME";
    public static final String FIELD_PSDECTRLTYPE = "PSDECTRLTYPE";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSDECTRLID = 3;
    private static final int INDEX_PSDECTRLNAME = 4;
    private static final int INDEX_PSDECTRLTYPE = 5;
    private static final int INDEX_PSDEID = 6;
    private static final int INDEX_PSDENAME = 7;
    private static final int INDEX_UPDATEDATE = 8;
    private static final int INDEX_UPDATEMAN = 9;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDECtrlBase proxyPSDECtrlBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdectrlidDirtyFlag = false;
    private boolean psdectrlnameDirtyFlag = false;
    private boolean psdectrltypeDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psdectrlid")
    private String psdectrlid;
    @Column(name="psdectrlname")
    private String psdectrlname;
    @Column(name="psdectrltype")
    private String psdectrltype;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;

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

    public void setPSDECtrlId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDECtrlId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdectrlid = string;
        this.psdectrlidDirtyFlag = true;
    }

    public String getPSDECtrlId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDECtrlId();
        }
        return this.psdectrlid;
    }

    public boolean isPSDECtrlIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDECtrlIdDirty();
        }
        return this.psdectrlidDirtyFlag;
    }

    public void resetPSDECtrlId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDECtrlId();
            return;
        }
        this.psdectrlidDirtyFlag = false;
        this.psdectrlid = null;
    }

    public void setPSDECtrlName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDECtrlName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdectrlname = string;
        this.psdectrlnameDirtyFlag = true;
    }

    public String getPSDECtrlName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDECtrlName();
        }
        return this.psdectrlname;
    }

    public boolean isPSDECtrlNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDECtrlNameDirty();
        }
        return this.psdectrlnameDirtyFlag;
    }

    public void resetPSDECtrlName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDECtrlName();
            return;
        }
        this.psdectrlnameDirtyFlag = false;
        this.psdectrlname = null;
    }

    public void setPSDECtrlType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDECtrlType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdectrltype = string;
        this.psdectrltypeDirtyFlag = true;
    }

    public String getPSDECtrlType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDECtrlType();
        }
        return this.psdectrltype;
    }

    public boolean isPSDECtrlTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDECtrlTypeDirty();
        }
        return this.psdectrltypeDirtyFlag;
    }

    public void resetPSDECtrlType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDECtrlType();
            return;
        }
        this.psdectrltypeDirtyFlag = false;
        this.psdectrltype = null;
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

    protected void onReset() {
        PSDECtrlBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDECtrlBase pSDECtrlBase) {
        pSDECtrlBase.resetCreateDate();
        pSDECtrlBase.resetCreateMan();
        pSDECtrlBase.resetMemo();
        pSDECtrlBase.resetPSDECtrlId();
        pSDECtrlBase.resetPSDECtrlName();
        pSDECtrlBase.resetPSDECtrlType();
        pSDECtrlBase.resetPSDEId();
        pSDECtrlBase.resetPSDEName();
        pSDECtrlBase.resetUpdateDate();
        pSDECtrlBase.resetUpdateMan();
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
        if (!bl || this.isPSDECtrlIdDirty()) {
            hashMap.put(FIELD_PSDECTRLID, this.getPSDECtrlId());
        }
        if (!bl || this.isPSDECtrlNameDirty()) {
            hashMap.put(FIELD_PSDECTRLNAME, this.getPSDECtrlName());
        }
        if (!bl || this.isPSDECtrlTypeDirty()) {
            hashMap.put(FIELD_PSDECTRLTYPE, this.getPSDECtrlType());
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
        return PSDECtrlBase.get(this, n);
    }

    private static Object get(PSDECtrlBase pSDECtrlBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDECtrlBase.getCreateDate();
            }
            case 1: {
                return pSDECtrlBase.getCreateMan();
            }
            case 2: {
                return pSDECtrlBase.getMemo();
            }
            case 3: {
                return pSDECtrlBase.getPSDECtrlId();
            }
            case 4: {
                return pSDECtrlBase.getPSDECtrlName();
            }
            case 5: {
                return pSDECtrlBase.getPSDECtrlType();
            }
            case 6: {
                return pSDECtrlBase.getPSDEId();
            }
            case 7: {
                return pSDECtrlBase.getPSDEName();
            }
            case 8: {
                return pSDECtrlBase.getUpdateDate();
            }
            case 9: {
                return pSDECtrlBase.getUpdateMan();
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
        PSDECtrlBase.set(this, n, object);
    }

    private static void set(PSDECtrlBase pSDECtrlBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDECtrlBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDECtrlBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDECtrlBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDECtrlBase.setPSDECtrlId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDECtrlBase.setPSDECtrlName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDECtrlBase.setPSDECtrlType(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDECtrlBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDECtrlBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDECtrlBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 9: {
                pSDECtrlBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDECtrlBase.isNull(this, n);
    }

    private static boolean isNull(PSDECtrlBase pSDECtrlBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDECtrlBase.getCreateDate() == null;
            }
            case 1: {
                return pSDECtrlBase.getCreateMan() == null;
            }
            case 2: {
                return pSDECtrlBase.getMemo() == null;
            }
            case 3: {
                return pSDECtrlBase.getPSDECtrlId() == null;
            }
            case 4: {
                return pSDECtrlBase.getPSDECtrlName() == null;
            }
            case 5: {
                return pSDECtrlBase.getPSDECtrlType() == null;
            }
            case 6: {
                return pSDECtrlBase.getPSDEId() == null;
            }
            case 7: {
                return pSDECtrlBase.getPSDEName() == null;
            }
            case 8: {
                return pSDECtrlBase.getUpdateDate() == null;
            }
            case 9: {
                return pSDECtrlBase.getUpdateMan() == null;
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
        return PSDECtrlBase.contains(this, n);
    }

    private static boolean contains(PSDECtrlBase pSDECtrlBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDECtrlBase.isCreateDateDirty();
            }
            case 1: {
                return pSDECtrlBase.isCreateManDirty();
            }
            case 2: {
                return pSDECtrlBase.isMemoDirty();
            }
            case 3: {
                return pSDECtrlBase.isPSDECtrlIdDirty();
            }
            case 4: {
                return pSDECtrlBase.isPSDECtrlNameDirty();
            }
            case 5: {
                return pSDECtrlBase.isPSDECtrlTypeDirty();
            }
            case 6: {
                return pSDECtrlBase.isPSDEIdDirty();
            }
            case 7: {
                return pSDECtrlBase.isPSDENameDirty();
            }
            case 8: {
                return pSDECtrlBase.isUpdateDateDirty();
            }
            case 9: {
                return pSDECtrlBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDECtrlBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDECtrlBase pSDECtrlBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDECtrlBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDECtrlBase.getJSONValue((Object)pSDECtrlBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDECtrlBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDECtrlBase.getJSONValue((Object)pSDECtrlBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDECtrlBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDECtrlBase.getJSONValue((Object)pSDECtrlBase.getMemo()), (boolean)false);
        }
        if (bl || pSDECtrlBase.getPSDECtrlId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdectrlid", (Object)PSDECtrlBase.getJSONValue((Object)pSDECtrlBase.getPSDECtrlId()), (boolean)false);
        }
        if (bl || pSDECtrlBase.getPSDECtrlName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdectrlname", (Object)PSDECtrlBase.getJSONValue((Object)pSDECtrlBase.getPSDECtrlName()), (boolean)false);
        }
        if (bl || pSDECtrlBase.getPSDECtrlType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdectrltype", (Object)PSDECtrlBase.getJSONValue((Object)pSDECtrlBase.getPSDECtrlType()), (boolean)false);
        }
        if (bl || pSDECtrlBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDECtrlBase.getJSONValue((Object)pSDECtrlBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDECtrlBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDECtrlBase.getJSONValue((Object)pSDECtrlBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDECtrlBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDECtrlBase.getJSONValue((Object)pSDECtrlBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDECtrlBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDECtrlBase.getJSONValue((Object)pSDECtrlBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDECtrlBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDECtrlBase pSDECtrlBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDECtrlBase.getCreateDate() != null) {
            object = pSDECtrlBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDECtrlBase.getCreateMan() != null) {
            object = pSDECtrlBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDECtrlBase.getMemo() != null) {
            object = pSDECtrlBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDECtrlBase.getPSDECtrlId() != null) {
            object = pSDECtrlBase.getPSDECtrlId();
            xmlNode.setAttribute(FIELD_PSDECTRLID, object == null ? "" : (String)object);
        }
        if (bl || pSDECtrlBase.getPSDECtrlName() != null) {
            object = pSDECtrlBase.getPSDECtrlName();
            xmlNode.setAttribute(FIELD_PSDECTRLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDECtrlBase.getPSDECtrlType() != null) {
            object = pSDECtrlBase.getPSDECtrlType();
            xmlNode.setAttribute(FIELD_PSDECTRLTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDECtrlBase.getPSDEId() != null) {
            object = pSDECtrlBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDECtrlBase.getPSDEName() != null) {
            object = pSDECtrlBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDECtrlBase.getUpdateDate() != null) {
            object = pSDECtrlBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDECtrlBase.getUpdateMan() != null) {
            object = pSDECtrlBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDECtrlBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDECtrlBase pSDECtrlBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDECtrlBase.isCreateDateDirty() && (bl || pSDECtrlBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDECtrlBase.getCreateDate());
        }
        if (pSDECtrlBase.isCreateManDirty() && (bl || pSDECtrlBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDECtrlBase.getCreateMan());
        }
        if (pSDECtrlBase.isMemoDirty() && (bl || pSDECtrlBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDECtrlBase.getMemo());
        }
        if (pSDECtrlBase.isPSDECtrlIdDirty() && (bl || pSDECtrlBase.getPSDECtrlId() != null)) {
            iDataObject.set(FIELD_PSDECTRLID, (Object)pSDECtrlBase.getPSDECtrlId());
        }
        if (pSDECtrlBase.isPSDECtrlNameDirty() && (bl || pSDECtrlBase.getPSDECtrlName() != null)) {
            iDataObject.set(FIELD_PSDECTRLNAME, (Object)pSDECtrlBase.getPSDECtrlName());
        }
        if (pSDECtrlBase.isPSDECtrlTypeDirty() && (bl || pSDECtrlBase.getPSDECtrlType() != null)) {
            iDataObject.set(FIELD_PSDECTRLTYPE, (Object)pSDECtrlBase.getPSDECtrlType());
        }
        if (pSDECtrlBase.isPSDEIdDirty() && (bl || pSDECtrlBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDECtrlBase.getPSDEId());
        }
        if (pSDECtrlBase.isPSDENameDirty() && (bl || pSDECtrlBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDECtrlBase.getPSDEName());
        }
        if (pSDECtrlBase.isUpdateDateDirty() && (bl || pSDECtrlBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDECtrlBase.getUpdateDate());
        }
        if (pSDECtrlBase.isUpdateManDirty() && (bl || pSDECtrlBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDECtrlBase.getUpdateMan());
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
        return PSDECtrlBase.remove(this, n);
    }

    private static boolean remove(PSDECtrlBase pSDECtrlBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDECtrlBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDECtrlBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDECtrlBase.resetMemo();
                return true;
            }
            case 3: {
                pSDECtrlBase.resetPSDECtrlId();
                return true;
            }
            case 4: {
                pSDECtrlBase.resetPSDECtrlName();
                return true;
            }
            case 5: {
                pSDECtrlBase.resetPSDECtrlType();
                return true;
            }
            case 6: {
                pSDECtrlBase.resetPSDEId();
                return true;
            }
            case 7: {
                pSDECtrlBase.resetPSDEName();
                return true;
            }
            case 8: {
                pSDECtrlBase.resetUpdateDate();
                return true;
            }
            case 9: {
                pSDECtrlBase.resetUpdateMan();
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

    private PSDECtrlBase getProxyEntity() {
        return this.proxyPSDECtrlBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDECtrlBase = null;
        if (iDataObject != null && iDataObject instanceof PSDECtrlBase) {
            this.proxyPSDECtrlBase = (PSDECtrlBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDECtrlService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSDECTRLID, 3);
        fieldIndexMap.put(FIELD_PSDECTRLNAME, 4);
        fieldIndexMap.put(FIELD_PSDECTRLTYPE, 5);
        fieldIndexMap.put(FIELD_PSDEID, 6);
        fieldIndexMap.put(FIELD_PSDENAME, 7);
        fieldIndexMap.put(FIELD_UPDATEDATE, 8);
        fieldIndexMap.put(FIELD_UPDATEMAN, 9);
    }
}

