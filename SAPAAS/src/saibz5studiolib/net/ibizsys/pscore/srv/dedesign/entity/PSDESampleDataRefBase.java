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
import net.ibizsys.pscore.srv.dedesign.entity.PSDESampleData;
import net.ibizsys.pscore.srv.dedesign.service.PSDESampleDataService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDESampleDataRefBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDESampleDataRefBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_PSDESAMPLEDATAID = "PSDESAMPLEDATAID";
    public static final String FIELD_PSDESAMPLEDATANAME = "PSDESAMPLEDATANAME";
    public static final String FIELD_PSDESAMPLEDATAREFID = "PSDESAMPLEDATAREFID";
    public static final String FIELD_PSDESAMPLEDATAREFNAME = "PSDESAMPLEDATAREFNAME";
    public static final String FIELD_REFPSDESAMPLEDATAID = "REFPSDESAMPLEDATAID";
    public static final String FIELD_REFPSDESAMPLEDATANAME = "REFPSDESAMPLEDATANAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_PSDESAMPLEDATAID = 2;
    private static final int INDEX_PSDESAMPLEDATANAME = 3;
    private static final int INDEX_PSDESAMPLEDATAREFID = 4;
    private static final int INDEX_PSDESAMPLEDATAREFNAME = 5;
    private static final int INDEX_REFPSDESAMPLEDATAID = 6;
    private static final int INDEX_REFPSDESAMPLEDATANAME = 7;
    private static final int INDEX_UPDATEDATE = 8;
    private static final int INDEX_UPDATEMAN = 9;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDESampleDataRefBase proxyPSDESampleDataRefBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean psdesampledataidDirtyFlag = false;
    private boolean psdesampledatanameDirtyFlag = false;
    private boolean psdesampledatarefidDirtyFlag = false;
    private boolean psdesampledatarefnameDirtyFlag = false;
    private boolean refpsdesampledataidDirtyFlag = false;
    private boolean refpsdesampledatanameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="psdesampledataid")
    private String psdesampledataid;
    @Column(name="psdesampledataname")
    private String psdesampledataname;
    @Column(name="psdesampledatarefid")
    private String psdesampledatarefid;
    @Column(name="psdesampledatarefname")
    private String psdesampledatarefname;
    @Column(name="refpsdesampledataid")
    private String refpsdesampledataid;
    @Column(name="refpsdesampledataname")
    private String refpsdesampledataname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDESampleDataLock = new Integer(1);
    private PSDESampleData psdesampledata = null;
    private Integer objRefPSDESampleDataLock = new Integer(1);
    private PSDESampleData refpsdesampledata = null;

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

    public void setPSDESampleDataId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDESampleDataId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdesampledataid = string;
        this.psdesampledataidDirtyFlag = true;
    }

    public String getPSDESampleDataId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDESampleDataId();
        }
        return this.psdesampledataid;
    }

    public boolean isPSDESampleDataIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDESampleDataIdDirty();
        }
        return this.psdesampledataidDirtyFlag;
    }

    public void resetPSDESampleDataId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDESampleDataId();
            return;
        }
        this.psdesampledataidDirtyFlag = false;
        this.psdesampledataid = null;
    }

    public void setPSDESampleDataName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDESampleDataName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdesampledataname = string;
        this.psdesampledatanameDirtyFlag = true;
    }

    public String getPSDESampleDataName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDESampleDataName();
        }
        return this.psdesampledataname;
    }

    public boolean isPSDESampleDataNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDESampleDataNameDirty();
        }
        return this.psdesampledatanameDirtyFlag;
    }

    public void resetPSDESampleDataName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDESampleDataName();
            return;
        }
        this.psdesampledatanameDirtyFlag = false;
        this.psdesampledataname = null;
    }

    public void setPSDESampleDataRefId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDESampleDataRefId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdesampledatarefid = string;
        this.psdesampledatarefidDirtyFlag = true;
    }

    public String getPSDESampleDataRefId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDESampleDataRefId();
        }
        return this.psdesampledatarefid;
    }

    public boolean isPSDESampleDataRefIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDESampleDataRefIdDirty();
        }
        return this.psdesampledatarefidDirtyFlag;
    }

    public void resetPSDESampleDataRefId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDESampleDataRefId();
            return;
        }
        this.psdesampledatarefidDirtyFlag = false;
        this.psdesampledatarefid = null;
    }

    public void setPSDESampleDataRefName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDESampleDataRefName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdesampledatarefname = string;
        this.psdesampledatarefnameDirtyFlag = true;
    }

    public String getPSDESampleDataRefName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDESampleDataRefName();
        }
        return this.psdesampledatarefname;
    }

    public boolean isPSDESampleDataRefNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDESampleDataRefNameDirty();
        }
        return this.psdesampledatarefnameDirtyFlag;
    }

    public void resetPSDESampleDataRefName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDESampleDataRefName();
            return;
        }
        this.psdesampledatarefnameDirtyFlag = false;
        this.psdesampledatarefname = null;
    }

    public void setRefPSDESampleDataId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSDESampleDataId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpsdesampledataid = string;
        this.refpsdesampledataidDirtyFlag = true;
    }

    public String getRefPSDESampleDataId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDESampleDataId();
        }
        return this.refpsdesampledataid;
    }

    public boolean isRefPSDESampleDataIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSDESampleDataIdDirty();
        }
        return this.refpsdesampledataidDirtyFlag;
    }

    public void resetRefPSDESampleDataId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSDESampleDataId();
            return;
        }
        this.refpsdesampledataidDirtyFlag = false;
        this.refpsdesampledataid = null;
    }

    public void setRefPSDESampleDataName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSDESampleDataName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpsdesampledataname = string;
        this.refpsdesampledatanameDirtyFlag = true;
    }

    public String getRefPSDESampleDataName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDESampleDataName();
        }
        return this.refpsdesampledataname;
    }

    public boolean isRefPSDESampleDataNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSDESampleDataNameDirty();
        }
        return this.refpsdesampledatanameDirtyFlag;
    }

    public void resetRefPSDESampleDataName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSDESampleDataName();
            return;
        }
        this.refpsdesampledatanameDirtyFlag = false;
        this.refpsdesampledataname = null;
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
        PSDESampleDataRefBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDESampleDataRefBase pSDESampleDataRefBase) {
        pSDESampleDataRefBase.resetCreateDate();
        pSDESampleDataRefBase.resetCreateMan();
        pSDESampleDataRefBase.resetPSDESampleDataId();
        pSDESampleDataRefBase.resetPSDESampleDataName();
        pSDESampleDataRefBase.resetPSDESampleDataRefId();
        pSDESampleDataRefBase.resetPSDESampleDataRefName();
        pSDESampleDataRefBase.resetRefPSDESampleDataId();
        pSDESampleDataRefBase.resetRefPSDESampleDataName();
        pSDESampleDataRefBase.resetUpdateDate();
        pSDESampleDataRefBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isPSDESampleDataIdDirty()) {
            hashMap.put(FIELD_PSDESAMPLEDATAID, this.getPSDESampleDataId());
        }
        if (!bl || this.isPSDESampleDataNameDirty()) {
            hashMap.put(FIELD_PSDESAMPLEDATANAME, this.getPSDESampleDataName());
        }
        if (!bl || this.isPSDESampleDataRefIdDirty()) {
            hashMap.put(FIELD_PSDESAMPLEDATAREFID, this.getPSDESampleDataRefId());
        }
        if (!bl || this.isPSDESampleDataRefNameDirty()) {
            hashMap.put(FIELD_PSDESAMPLEDATAREFNAME, this.getPSDESampleDataRefName());
        }
        if (!bl || this.isRefPSDESampleDataIdDirty()) {
            hashMap.put(FIELD_REFPSDESAMPLEDATAID, this.getRefPSDESampleDataId());
        }
        if (!bl || this.isRefPSDESampleDataNameDirty()) {
            hashMap.put(FIELD_REFPSDESAMPLEDATANAME, this.getRefPSDESampleDataName());
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
        return PSDESampleDataRefBase.get(this, n);
    }

    private static Object get(PSDESampleDataRefBase pSDESampleDataRefBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDESampleDataRefBase.getCreateDate();
            }
            case 1: {
                return pSDESampleDataRefBase.getCreateMan();
            }
            case 2: {
                return pSDESampleDataRefBase.getPSDESampleDataId();
            }
            case 3: {
                return pSDESampleDataRefBase.getPSDESampleDataName();
            }
            case 4: {
                return pSDESampleDataRefBase.getPSDESampleDataRefId();
            }
            case 5: {
                return pSDESampleDataRefBase.getPSDESampleDataRefName();
            }
            case 6: {
                return pSDESampleDataRefBase.getRefPSDESampleDataId();
            }
            case 7: {
                return pSDESampleDataRefBase.getRefPSDESampleDataName();
            }
            case 8: {
                return pSDESampleDataRefBase.getUpdateDate();
            }
            case 9: {
                return pSDESampleDataRefBase.getUpdateMan();
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
        PSDESampleDataRefBase.set(this, n, object);
    }

    private static void set(PSDESampleDataRefBase pSDESampleDataRefBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDESampleDataRefBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDESampleDataRefBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDESampleDataRefBase.setPSDESampleDataId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDESampleDataRefBase.setPSDESampleDataName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDESampleDataRefBase.setPSDESampleDataRefId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDESampleDataRefBase.setPSDESampleDataRefName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDESampleDataRefBase.setRefPSDESampleDataId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDESampleDataRefBase.setRefPSDESampleDataName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDESampleDataRefBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 9: {
                pSDESampleDataRefBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDESampleDataRefBase.isNull(this, n);
    }

    private static boolean isNull(PSDESampleDataRefBase pSDESampleDataRefBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDESampleDataRefBase.getCreateDate() == null;
            }
            case 1: {
                return pSDESampleDataRefBase.getCreateMan() == null;
            }
            case 2: {
                return pSDESampleDataRefBase.getPSDESampleDataId() == null;
            }
            case 3: {
                return pSDESampleDataRefBase.getPSDESampleDataName() == null;
            }
            case 4: {
                return pSDESampleDataRefBase.getPSDESampleDataRefId() == null;
            }
            case 5: {
                return pSDESampleDataRefBase.getPSDESampleDataRefName() == null;
            }
            case 6: {
                return pSDESampleDataRefBase.getRefPSDESampleDataId() == null;
            }
            case 7: {
                return pSDESampleDataRefBase.getRefPSDESampleDataName() == null;
            }
            case 8: {
                return pSDESampleDataRefBase.getUpdateDate() == null;
            }
            case 9: {
                return pSDESampleDataRefBase.getUpdateMan() == null;
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
        return PSDESampleDataRefBase.contains(this, n);
    }

    private static boolean contains(PSDESampleDataRefBase pSDESampleDataRefBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDESampleDataRefBase.isCreateDateDirty();
            }
            case 1: {
                return pSDESampleDataRefBase.isCreateManDirty();
            }
            case 2: {
                return pSDESampleDataRefBase.isPSDESampleDataIdDirty();
            }
            case 3: {
                return pSDESampleDataRefBase.isPSDESampleDataNameDirty();
            }
            case 4: {
                return pSDESampleDataRefBase.isPSDESampleDataRefIdDirty();
            }
            case 5: {
                return pSDESampleDataRefBase.isPSDESampleDataRefNameDirty();
            }
            case 6: {
                return pSDESampleDataRefBase.isRefPSDESampleDataIdDirty();
            }
            case 7: {
                return pSDESampleDataRefBase.isRefPSDESampleDataNameDirty();
            }
            case 8: {
                return pSDESampleDataRefBase.isUpdateDateDirty();
            }
            case 9: {
                return pSDESampleDataRefBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDESampleDataRefBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDESampleDataRefBase pSDESampleDataRefBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDESampleDataRefBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDESampleDataRefBase.getJSONValue((Object)pSDESampleDataRefBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDESampleDataRefBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDESampleDataRefBase.getJSONValue((Object)pSDESampleDataRefBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDESampleDataRefBase.getPSDESampleDataId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdesampledataid", (Object)PSDESampleDataRefBase.getJSONValue((Object)pSDESampleDataRefBase.getPSDESampleDataId()), (boolean)false);
        }
        if (bl || pSDESampleDataRefBase.getPSDESampleDataName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdesampledataname", (Object)PSDESampleDataRefBase.getJSONValue((Object)pSDESampleDataRefBase.getPSDESampleDataName()), (boolean)false);
        }
        if (bl || pSDESampleDataRefBase.getPSDESampleDataRefId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdesampledatarefid", (Object)PSDESampleDataRefBase.getJSONValue((Object)pSDESampleDataRefBase.getPSDESampleDataRefId()), (boolean)false);
        }
        if (bl || pSDESampleDataRefBase.getPSDESampleDataRefName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdesampledatarefname", (Object)PSDESampleDataRefBase.getJSONValue((Object)pSDESampleDataRefBase.getPSDESampleDataRefName()), (boolean)false);
        }
        if (bl || pSDESampleDataRefBase.getRefPSDESampleDataId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdesampledataid", (Object)PSDESampleDataRefBase.getJSONValue((Object)pSDESampleDataRefBase.getRefPSDESampleDataId()), (boolean)false);
        }
        if (bl || pSDESampleDataRefBase.getRefPSDESampleDataName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdesampledataname", (Object)PSDESampleDataRefBase.getJSONValue((Object)pSDESampleDataRefBase.getRefPSDESampleDataName()), (boolean)false);
        }
        if (bl || pSDESampleDataRefBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDESampleDataRefBase.getJSONValue((Object)pSDESampleDataRefBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDESampleDataRefBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDESampleDataRefBase.getJSONValue((Object)pSDESampleDataRefBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDESampleDataRefBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDESampleDataRefBase pSDESampleDataRefBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDESampleDataRefBase.getCreateDate() != null) {
            object = pSDESampleDataRefBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDESampleDataRefBase.getCreateMan() != null) {
            object = pSDESampleDataRefBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDESampleDataRefBase.getPSDESampleDataId() != null) {
            object = pSDESampleDataRefBase.getPSDESampleDataId();
            xmlNode.setAttribute(FIELD_PSDESAMPLEDATAID, object == null ? "" : (String)object);
        }
        if (bl || pSDESampleDataRefBase.getPSDESampleDataName() != null) {
            object = pSDESampleDataRefBase.getPSDESampleDataName();
            xmlNode.setAttribute(FIELD_PSDESAMPLEDATANAME, object == null ? "" : (String)object);
        }
        if (bl || pSDESampleDataRefBase.getPSDESampleDataRefId() != null) {
            object = pSDESampleDataRefBase.getPSDESampleDataRefId();
            xmlNode.setAttribute(FIELD_PSDESAMPLEDATAREFID, object == null ? "" : (String)object);
        }
        if (bl || pSDESampleDataRefBase.getPSDESampleDataRefName() != null) {
            object = pSDESampleDataRefBase.getPSDESampleDataRefName();
            xmlNode.setAttribute(FIELD_PSDESAMPLEDATAREFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDESampleDataRefBase.getRefPSDESampleDataId() != null) {
            object = pSDESampleDataRefBase.getRefPSDESampleDataId();
            xmlNode.setAttribute(FIELD_REFPSDESAMPLEDATAID, object == null ? "" : (String)object);
        }
        if (bl || pSDESampleDataRefBase.getRefPSDESampleDataName() != null) {
            object = pSDESampleDataRefBase.getRefPSDESampleDataName();
            xmlNode.setAttribute(FIELD_REFPSDESAMPLEDATANAME, object == null ? "" : (String)object);
        }
        if (bl || pSDESampleDataRefBase.getUpdateDate() != null) {
            object = pSDESampleDataRefBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDESampleDataRefBase.getUpdateMan() != null) {
            object = pSDESampleDataRefBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDESampleDataRefBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDESampleDataRefBase pSDESampleDataRefBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDESampleDataRefBase.isCreateDateDirty() && (bl || pSDESampleDataRefBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDESampleDataRefBase.getCreateDate());
        }
        if (pSDESampleDataRefBase.isCreateManDirty() && (bl || pSDESampleDataRefBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDESampleDataRefBase.getCreateMan());
        }
        if (pSDESampleDataRefBase.isPSDESampleDataIdDirty() && (bl || pSDESampleDataRefBase.getPSDESampleDataId() != null)) {
            iDataObject.set(FIELD_PSDESAMPLEDATAID, (Object)pSDESampleDataRefBase.getPSDESampleDataId());
        }
        if (pSDESampleDataRefBase.isPSDESampleDataNameDirty() && (bl || pSDESampleDataRefBase.getPSDESampleDataName() != null)) {
            iDataObject.set(FIELD_PSDESAMPLEDATANAME, (Object)pSDESampleDataRefBase.getPSDESampleDataName());
        }
        if (pSDESampleDataRefBase.isPSDESampleDataRefIdDirty() && (bl || pSDESampleDataRefBase.getPSDESampleDataRefId() != null)) {
            iDataObject.set(FIELD_PSDESAMPLEDATAREFID, (Object)pSDESampleDataRefBase.getPSDESampleDataRefId());
        }
        if (pSDESampleDataRefBase.isPSDESampleDataRefNameDirty() && (bl || pSDESampleDataRefBase.getPSDESampleDataRefName() != null)) {
            iDataObject.set(FIELD_PSDESAMPLEDATAREFNAME, (Object)pSDESampleDataRefBase.getPSDESampleDataRefName());
        }
        if (pSDESampleDataRefBase.isRefPSDESampleDataIdDirty() && (bl || pSDESampleDataRefBase.getRefPSDESampleDataId() != null)) {
            iDataObject.set(FIELD_REFPSDESAMPLEDATAID, (Object)pSDESampleDataRefBase.getRefPSDESampleDataId());
        }
        if (pSDESampleDataRefBase.isRefPSDESampleDataNameDirty() && (bl || pSDESampleDataRefBase.getRefPSDESampleDataName() != null)) {
            iDataObject.set(FIELD_REFPSDESAMPLEDATANAME, (Object)pSDESampleDataRefBase.getRefPSDESampleDataName());
        }
        if (pSDESampleDataRefBase.isUpdateDateDirty() && (bl || pSDESampleDataRefBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDESampleDataRefBase.getUpdateDate());
        }
        if (pSDESampleDataRefBase.isUpdateManDirty() && (bl || pSDESampleDataRefBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDESampleDataRefBase.getUpdateMan());
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
        return PSDESampleDataRefBase.remove(this, n);
    }

    private static boolean remove(PSDESampleDataRefBase pSDESampleDataRefBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDESampleDataRefBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDESampleDataRefBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDESampleDataRefBase.resetPSDESampleDataId();
                return true;
            }
            case 3: {
                pSDESampleDataRefBase.resetPSDESampleDataName();
                return true;
            }
            case 4: {
                pSDESampleDataRefBase.resetPSDESampleDataRefId();
                return true;
            }
            case 5: {
                pSDESampleDataRefBase.resetPSDESampleDataRefName();
                return true;
            }
            case 6: {
                pSDESampleDataRefBase.resetRefPSDESampleDataId();
                return true;
            }
            case 7: {
                pSDESampleDataRefBase.resetRefPSDESampleDataName();
                return true;
            }
            case 8: {
                pSDESampleDataRefBase.resetUpdateDate();
                return true;
            }
            case 9: {
                pSDESampleDataRefBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDESampleData getPSDESampleData() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDESampleData();
        }
        if (this.getPSDESampleDataId() == null) {
            return null;
        }
        Integer n = this.objPSDESampleDataLock;
        synchronized (n) {
            if (this.psdesampledata != null && DataTypeHelper.compare((int)25, (Object)this.getPSDESampleDataId(), (Object)this.psdesampledata.getPSDESampleDataId()) != 0L) {
                this.psdesampledata = null;
            }
            if (this.psdesampledata == null) {
                PSDESampleData pSDESampleData = new PSDESampleData();
                pSDESampleData.setPSDESampleDataId(this.getPSDESampleDataId());
                PSDESampleDataService pSDESampleDataService = (PSDESampleDataService)ServiceGlobal.getService(PSDESampleDataService.class, (SessionFactory)this.getSessionFactory());
                pSDESampleDataService.autoGet(pSDESampleData);
                this.psdesampledata = pSDESampleData;
            }
            return this.psdesampledata;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDESampleData getRefPSDESampleData() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDESampleData();
        }
        if (this.getRefPSDESampleDataId() == null) {
            return null;
        }
        Integer n = this.objRefPSDESampleDataLock;
        synchronized (n) {
            if (this.refpsdesampledata != null && DataTypeHelper.compare((int)25, (Object)this.getRefPSDESampleDataId(), (Object)this.refpsdesampledata.getPSDESampleDataId()) != 0L) {
                this.refpsdesampledata = null;
            }
            if (this.refpsdesampledata == null) {
                PSDESampleData pSDESampleData = new PSDESampleData();
                pSDESampleData.setPSDESampleDataId(this.getRefPSDESampleDataId());
                PSDESampleDataService pSDESampleDataService = (PSDESampleDataService)ServiceGlobal.getService(PSDESampleDataService.class, (SessionFactory)this.getSessionFactory());
                pSDESampleDataService.autoGet(pSDESampleData);
                this.refpsdesampledata = pSDESampleData;
            }
            return this.refpsdesampledata;
        }
    }

    private PSDESampleDataRefBase getProxyEntity() {
        return this.proxyPSDESampleDataRefBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDESampleDataRefBase = null;
        if (iDataObject != null && iDataObject instanceof PSDESampleDataRefBase) {
            this.proxyPSDESampleDataRefBase = (PSDESampleDataRefBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDESampleDataRefService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_PSDESAMPLEDATAID, 2);
        fieldIndexMap.put(FIELD_PSDESAMPLEDATANAME, 3);
        fieldIndexMap.put(FIELD_PSDESAMPLEDATAREFID, 4);
        fieldIndexMap.put(FIELD_PSDESAMPLEDATAREFNAME, 5);
        fieldIndexMap.put(FIELD_REFPSDESAMPLEDATAID, 6);
        fieldIndexMap.put(FIELD_REFPSDESAMPLEDATANAME, 7);
        fieldIndexMap.put(FIELD_UPDATEDATE, 8);
        fieldIndexMap.put(FIELD_UPDATEMAN, 9);
    }
}

