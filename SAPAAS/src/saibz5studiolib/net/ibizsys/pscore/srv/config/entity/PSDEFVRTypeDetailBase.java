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
package net.ibizsys.pscore.srv.config.entity;

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
import net.ibizsys.pscore.srv.config.entity.PSDEFVRType;
import net.ibizsys.pscore.srv.config.service.PSDEFVRTypeService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEFVRTypeDetailBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEFVRTypeDetailBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PROCESSOBJ = "PROCESSOBJ";
    public static final String FIELD_PSDEFVRTYPEDETAILID = "PSDEFVRTYPEDETAILID";
    public static final String FIELD_PSDEFVRTYPEDETAILNAME = "PSDEFVRTYPEDETAILNAME";
    public static final String FIELD_PSDEFVRTYPEID = "PSDEFVRTYPEID";
    public static final String FIELD_PSDEFVRTYPENAME = "PSDEFVRTYPENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PROCESSOBJ = 3;
    private static final int INDEX_PSDEFVRTYPEDETAILID = 4;
    private static final int INDEX_PSDEFVRTYPEDETAILNAME = 5;
    private static final int INDEX_PSDEFVRTYPEID = 6;
    private static final int INDEX_PSDEFVRTYPENAME = 7;
    private static final int INDEX_UPDATEDATE = 8;
    private static final int INDEX_UPDATEMAN = 9;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEFVRTypeDetailBase proxyPSDEFVRTypeDetailBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean processobjDirtyFlag = false;
    private boolean psdefvrtypedetailidDirtyFlag = false;
    private boolean psdefvrtypedetailnameDirtyFlag = false;
    private boolean psdefvrtypeidDirtyFlag = false;
    private boolean psdefvrtypenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="processobj")
    private String processobj;
    @Column(name="psdefvrtypedetailid")
    private String psdefvrtypedetailid;
    @Column(name="psdefvrtypedetailname")
    private String psdefvrtypedetailname;
    @Column(name="psdefvrtypeid")
    private String psdefvrtypeid;
    @Column(name="psdefvrtypename")
    private String psdefvrtypename;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDEFVRTypeLock = new Integer(1);
    private PSDEFVRType psdefvrtype = null;

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

    public void setProcessObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setProcessObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.processobj = string;
        this.processobjDirtyFlag = true;
    }

    public String getProcessObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getProcessObj();
        }
        return this.processobj;
    }

    public boolean isProcessObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isProcessObjDirty();
        }
        return this.processobjDirtyFlag;
    }

    public void resetProcessObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetProcessObj();
            return;
        }
        this.processobjDirtyFlag = false;
        this.processobj = null;
    }

    public void setPSDEFVRTypeDetailId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFVRTypeDetailId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefvrtypedetailid = string;
        this.psdefvrtypedetailidDirtyFlag = true;
    }

    public String getPSDEFVRTypeDetailId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFVRTypeDetailId();
        }
        return this.psdefvrtypedetailid;
    }

    public boolean isPSDEFVRTypeDetailIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFVRTypeDetailIdDirty();
        }
        return this.psdefvrtypedetailidDirtyFlag;
    }

    public void resetPSDEFVRTypeDetailId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFVRTypeDetailId();
            return;
        }
        this.psdefvrtypedetailidDirtyFlag = false;
        this.psdefvrtypedetailid = null;
    }

    public void setPSDEFVRTypeDetailName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFVRTypeDetailName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefvrtypedetailname = string;
        this.psdefvrtypedetailnameDirtyFlag = true;
    }

    public String getPSDEFVRTypeDetailName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFVRTypeDetailName();
        }
        return this.psdefvrtypedetailname;
    }

    public boolean isPSDEFVRTypeDetailNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFVRTypeDetailNameDirty();
        }
        return this.psdefvrtypedetailnameDirtyFlag;
    }

    public void resetPSDEFVRTypeDetailName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFVRTypeDetailName();
            return;
        }
        this.psdefvrtypedetailnameDirtyFlag = false;
        this.psdefvrtypedetailname = null;
    }

    public void setPSDEFVRTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFVRTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefvrtypeid = string;
        this.psdefvrtypeidDirtyFlag = true;
    }

    public String getPSDEFVRTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFVRTypeId();
        }
        return this.psdefvrtypeid;
    }

    public boolean isPSDEFVRTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFVRTypeIdDirty();
        }
        return this.psdefvrtypeidDirtyFlag;
    }

    public void resetPSDEFVRTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFVRTypeId();
            return;
        }
        this.psdefvrtypeidDirtyFlag = false;
        this.psdefvrtypeid = null;
    }

    public void setPSDEFVRTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFVRTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefvrtypename = string;
        this.psdefvrtypenameDirtyFlag = true;
    }

    public String getPSDEFVRTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFVRTypeName();
        }
        return this.psdefvrtypename;
    }

    public boolean isPSDEFVRTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFVRTypeNameDirty();
        }
        return this.psdefvrtypenameDirtyFlag;
    }

    public void resetPSDEFVRTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFVRTypeName();
            return;
        }
        this.psdefvrtypenameDirtyFlag = false;
        this.psdefvrtypename = null;
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
        PSDEFVRTypeDetailBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEFVRTypeDetailBase pSDEFVRTypeDetailBase) {
        pSDEFVRTypeDetailBase.resetCreateDate();
        pSDEFVRTypeDetailBase.resetCreateMan();
        pSDEFVRTypeDetailBase.resetMemo();
        pSDEFVRTypeDetailBase.resetProcessObj();
        pSDEFVRTypeDetailBase.resetPSDEFVRTypeDetailId();
        pSDEFVRTypeDetailBase.resetPSDEFVRTypeDetailName();
        pSDEFVRTypeDetailBase.resetPSDEFVRTypeId();
        pSDEFVRTypeDetailBase.resetPSDEFVRTypeName();
        pSDEFVRTypeDetailBase.resetUpdateDate();
        pSDEFVRTypeDetailBase.resetUpdateMan();
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
        if (!bl || this.isProcessObjDirty()) {
            hashMap.put(FIELD_PROCESSOBJ, this.getProcessObj());
        }
        if (!bl || this.isPSDEFVRTypeDetailIdDirty()) {
            hashMap.put(FIELD_PSDEFVRTYPEDETAILID, this.getPSDEFVRTypeDetailId());
        }
        if (!bl || this.isPSDEFVRTypeDetailNameDirty()) {
            hashMap.put(FIELD_PSDEFVRTYPEDETAILNAME, this.getPSDEFVRTypeDetailName());
        }
        if (!bl || this.isPSDEFVRTypeIdDirty()) {
            hashMap.put(FIELD_PSDEFVRTYPEID, this.getPSDEFVRTypeId());
        }
        if (!bl || this.isPSDEFVRTypeNameDirty()) {
            hashMap.put(FIELD_PSDEFVRTYPENAME, this.getPSDEFVRTypeName());
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
        return PSDEFVRTypeDetailBase.get(this, n);
    }

    private static Object get(PSDEFVRTypeDetailBase pSDEFVRTypeDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFVRTypeDetailBase.getCreateDate();
            }
            case 1: {
                return pSDEFVRTypeDetailBase.getCreateMan();
            }
            case 2: {
                return pSDEFVRTypeDetailBase.getMemo();
            }
            case 3: {
                return pSDEFVRTypeDetailBase.getProcessObj();
            }
            case 4: {
                return pSDEFVRTypeDetailBase.getPSDEFVRTypeDetailId();
            }
            case 5: {
                return pSDEFVRTypeDetailBase.getPSDEFVRTypeDetailName();
            }
            case 6: {
                return pSDEFVRTypeDetailBase.getPSDEFVRTypeId();
            }
            case 7: {
                return pSDEFVRTypeDetailBase.getPSDEFVRTypeName();
            }
            case 8: {
                return pSDEFVRTypeDetailBase.getUpdateDate();
            }
            case 9: {
                return pSDEFVRTypeDetailBase.getUpdateMan();
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
        PSDEFVRTypeDetailBase.set(this, n, object);
    }

    private static void set(PSDEFVRTypeDetailBase pSDEFVRTypeDetailBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEFVRTypeDetailBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDEFVRTypeDetailBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEFVRTypeDetailBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEFVRTypeDetailBase.setProcessObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEFVRTypeDetailBase.setPSDEFVRTypeDetailId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEFVRTypeDetailBase.setPSDEFVRTypeDetailName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEFVRTypeDetailBase.setPSDEFVRTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEFVRTypeDetailBase.setPSDEFVRTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEFVRTypeDetailBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 9: {
                pSDEFVRTypeDetailBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDEFVRTypeDetailBase.isNull(this, n);
    }

    private static boolean isNull(PSDEFVRTypeDetailBase pSDEFVRTypeDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFVRTypeDetailBase.getCreateDate() == null;
            }
            case 1: {
                return pSDEFVRTypeDetailBase.getCreateMan() == null;
            }
            case 2: {
                return pSDEFVRTypeDetailBase.getMemo() == null;
            }
            case 3: {
                return pSDEFVRTypeDetailBase.getProcessObj() == null;
            }
            case 4: {
                return pSDEFVRTypeDetailBase.getPSDEFVRTypeDetailId() == null;
            }
            case 5: {
                return pSDEFVRTypeDetailBase.getPSDEFVRTypeDetailName() == null;
            }
            case 6: {
                return pSDEFVRTypeDetailBase.getPSDEFVRTypeId() == null;
            }
            case 7: {
                return pSDEFVRTypeDetailBase.getPSDEFVRTypeName() == null;
            }
            case 8: {
                return pSDEFVRTypeDetailBase.getUpdateDate() == null;
            }
            case 9: {
                return pSDEFVRTypeDetailBase.getUpdateMan() == null;
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
        return PSDEFVRTypeDetailBase.contains(this, n);
    }

    private static boolean contains(PSDEFVRTypeDetailBase pSDEFVRTypeDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFVRTypeDetailBase.isCreateDateDirty();
            }
            case 1: {
                return pSDEFVRTypeDetailBase.isCreateManDirty();
            }
            case 2: {
                return pSDEFVRTypeDetailBase.isMemoDirty();
            }
            case 3: {
                return pSDEFVRTypeDetailBase.isProcessObjDirty();
            }
            case 4: {
                return pSDEFVRTypeDetailBase.isPSDEFVRTypeDetailIdDirty();
            }
            case 5: {
                return pSDEFVRTypeDetailBase.isPSDEFVRTypeDetailNameDirty();
            }
            case 6: {
                return pSDEFVRTypeDetailBase.isPSDEFVRTypeIdDirty();
            }
            case 7: {
                return pSDEFVRTypeDetailBase.isPSDEFVRTypeNameDirty();
            }
            case 8: {
                return pSDEFVRTypeDetailBase.isUpdateDateDirty();
            }
            case 9: {
                return pSDEFVRTypeDetailBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEFVRTypeDetailBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEFVRTypeDetailBase pSDEFVRTypeDetailBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEFVRTypeDetailBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEFVRTypeDetailBase.getJSONValue((Object)pSDEFVRTypeDetailBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEFVRTypeDetailBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEFVRTypeDetailBase.getJSONValue((Object)pSDEFVRTypeDetailBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEFVRTypeDetailBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEFVRTypeDetailBase.getJSONValue((Object)pSDEFVRTypeDetailBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEFVRTypeDetailBase.getProcessObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"processobj", (Object)PSDEFVRTypeDetailBase.getJSONValue((Object)pSDEFVRTypeDetailBase.getProcessObj()), (boolean)false);
        }
        if (bl || pSDEFVRTypeDetailBase.getPSDEFVRTypeDetailId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefvrtypedetailid", (Object)PSDEFVRTypeDetailBase.getJSONValue((Object)pSDEFVRTypeDetailBase.getPSDEFVRTypeDetailId()), (boolean)false);
        }
        if (bl || pSDEFVRTypeDetailBase.getPSDEFVRTypeDetailName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefvrtypedetailname", (Object)PSDEFVRTypeDetailBase.getJSONValue((Object)pSDEFVRTypeDetailBase.getPSDEFVRTypeDetailName()), (boolean)false);
        }
        if (bl || pSDEFVRTypeDetailBase.getPSDEFVRTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefvrtypeid", (Object)PSDEFVRTypeDetailBase.getJSONValue((Object)pSDEFVRTypeDetailBase.getPSDEFVRTypeId()), (boolean)false);
        }
        if (bl || pSDEFVRTypeDetailBase.getPSDEFVRTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefvrtypename", (Object)PSDEFVRTypeDetailBase.getJSONValue((Object)pSDEFVRTypeDetailBase.getPSDEFVRTypeName()), (boolean)false);
        }
        if (bl || pSDEFVRTypeDetailBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEFVRTypeDetailBase.getJSONValue((Object)pSDEFVRTypeDetailBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEFVRTypeDetailBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEFVRTypeDetailBase.getJSONValue((Object)pSDEFVRTypeDetailBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEFVRTypeDetailBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEFVRTypeDetailBase pSDEFVRTypeDetailBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEFVRTypeDetailBase.getCreateDate() != null) {
            object = pSDEFVRTypeDetailBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEFVRTypeDetailBase.getCreateMan() != null) {
            object = pSDEFVRTypeDetailBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEFVRTypeDetailBase.getMemo() != null) {
            object = pSDEFVRTypeDetailBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEFVRTypeDetailBase.getProcessObj() != null) {
            object = pSDEFVRTypeDetailBase.getProcessObj();
            xmlNode.setAttribute(FIELD_PROCESSOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSDEFVRTypeDetailBase.getPSDEFVRTypeDetailId() != null) {
            object = pSDEFVRTypeDetailBase.getPSDEFVRTypeDetailId();
            xmlNode.setAttribute(FIELD_PSDEFVRTYPEDETAILID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFVRTypeDetailBase.getPSDEFVRTypeDetailName() != null) {
            object = pSDEFVRTypeDetailBase.getPSDEFVRTypeDetailName();
            xmlNode.setAttribute(FIELD_PSDEFVRTYPEDETAILNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFVRTypeDetailBase.getPSDEFVRTypeId() != null) {
            object = pSDEFVRTypeDetailBase.getPSDEFVRTypeId();
            xmlNode.setAttribute(FIELD_PSDEFVRTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFVRTypeDetailBase.getPSDEFVRTypeName() != null) {
            object = pSDEFVRTypeDetailBase.getPSDEFVRTypeName();
            xmlNode.setAttribute(FIELD_PSDEFVRTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFVRTypeDetailBase.getUpdateDate() != null) {
            object = pSDEFVRTypeDetailBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEFVRTypeDetailBase.getUpdateMan() != null) {
            object = pSDEFVRTypeDetailBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEFVRTypeDetailBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEFVRTypeDetailBase pSDEFVRTypeDetailBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEFVRTypeDetailBase.isCreateDateDirty() && (bl || pSDEFVRTypeDetailBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEFVRTypeDetailBase.getCreateDate());
        }
        if (pSDEFVRTypeDetailBase.isCreateManDirty() && (bl || pSDEFVRTypeDetailBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEFVRTypeDetailBase.getCreateMan());
        }
        if (pSDEFVRTypeDetailBase.isMemoDirty() && (bl || pSDEFVRTypeDetailBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEFVRTypeDetailBase.getMemo());
        }
        if (pSDEFVRTypeDetailBase.isProcessObjDirty() && (bl || pSDEFVRTypeDetailBase.getProcessObj() != null)) {
            iDataObject.set(FIELD_PROCESSOBJ, (Object)pSDEFVRTypeDetailBase.getProcessObj());
        }
        if (pSDEFVRTypeDetailBase.isPSDEFVRTypeDetailIdDirty() && (bl || pSDEFVRTypeDetailBase.getPSDEFVRTypeDetailId() != null)) {
            iDataObject.set(FIELD_PSDEFVRTYPEDETAILID, (Object)pSDEFVRTypeDetailBase.getPSDEFVRTypeDetailId());
        }
        if (pSDEFVRTypeDetailBase.isPSDEFVRTypeDetailNameDirty() && (bl || pSDEFVRTypeDetailBase.getPSDEFVRTypeDetailName() != null)) {
            iDataObject.set(FIELD_PSDEFVRTYPEDETAILNAME, (Object)pSDEFVRTypeDetailBase.getPSDEFVRTypeDetailName());
        }
        if (pSDEFVRTypeDetailBase.isPSDEFVRTypeIdDirty() && (bl || pSDEFVRTypeDetailBase.getPSDEFVRTypeId() != null)) {
            iDataObject.set(FIELD_PSDEFVRTYPEID, (Object)pSDEFVRTypeDetailBase.getPSDEFVRTypeId());
        }
        if (pSDEFVRTypeDetailBase.isPSDEFVRTypeNameDirty() && (bl || pSDEFVRTypeDetailBase.getPSDEFVRTypeName() != null)) {
            iDataObject.set(FIELD_PSDEFVRTYPENAME, (Object)pSDEFVRTypeDetailBase.getPSDEFVRTypeName());
        }
        if (pSDEFVRTypeDetailBase.isUpdateDateDirty() && (bl || pSDEFVRTypeDetailBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEFVRTypeDetailBase.getUpdateDate());
        }
        if (pSDEFVRTypeDetailBase.isUpdateManDirty() && (bl || pSDEFVRTypeDetailBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEFVRTypeDetailBase.getUpdateMan());
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
        return PSDEFVRTypeDetailBase.remove(this, n);
    }

    private static boolean remove(PSDEFVRTypeDetailBase pSDEFVRTypeDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEFVRTypeDetailBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDEFVRTypeDetailBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDEFVRTypeDetailBase.resetMemo();
                return true;
            }
            case 3: {
                pSDEFVRTypeDetailBase.resetProcessObj();
                return true;
            }
            case 4: {
                pSDEFVRTypeDetailBase.resetPSDEFVRTypeDetailId();
                return true;
            }
            case 5: {
                pSDEFVRTypeDetailBase.resetPSDEFVRTypeDetailName();
                return true;
            }
            case 6: {
                pSDEFVRTypeDetailBase.resetPSDEFVRTypeId();
                return true;
            }
            case 7: {
                pSDEFVRTypeDetailBase.resetPSDEFVRTypeName();
                return true;
            }
            case 8: {
                pSDEFVRTypeDetailBase.resetUpdateDate();
                return true;
            }
            case 9: {
                pSDEFVRTypeDetailBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEFVRType getPSDEFVRType() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFVRType();
        }
        if (this.getPSDEFVRTypeId() == null) {
            return null;
        }
        Integer n = this.objPSDEFVRTypeLock;
        synchronized (n) {
            if (this.psdefvrtype != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEFVRTypeId(), (Object)this.psdefvrtype.getPSDEFVRTypeId()) != 0L) {
                this.psdefvrtype = null;
            }
            if (this.psdefvrtype == null) {
                PSDEFVRType pSDEFVRType = new PSDEFVRType();
                pSDEFVRType.setPSDEFVRTypeId(this.getPSDEFVRTypeId());
                PSDEFVRTypeService pSDEFVRTypeService = (PSDEFVRTypeService)ServiceGlobal.getService(PSDEFVRTypeService.class, (SessionFactory)this.getSessionFactory());
                pSDEFVRTypeService.autoGet((IEntity)pSDEFVRType);
                this.psdefvrtype = pSDEFVRType;
            }
            return this.psdefvrtype;
        }
    }

    private PSDEFVRTypeDetailBase getProxyEntity() {
        return this.proxyPSDEFVRTypeDetailBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEFVRTypeDetailBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEFVRTypeDetailBase) {
            this.proxyPSDEFVRTypeDetailBase = (PSDEFVRTypeDetailBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSDEFVRTypeDetailService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PROCESSOBJ, 3);
        fieldIndexMap.put(FIELD_PSDEFVRTYPEDETAILID, 4);
        fieldIndexMap.put(FIELD_PSDEFVRTYPEDETAILNAME, 5);
        fieldIndexMap.put(FIELD_PSDEFVRTYPEID, 6);
        fieldIndexMap.put(FIELD_PSDEFVRTYPENAME, 7);
        fieldIndexMap.put(FIELD_UPDATEDATE, 8);
        fieldIndexMap.put(FIELD_UPDATEMAN, 9);
    }
}

