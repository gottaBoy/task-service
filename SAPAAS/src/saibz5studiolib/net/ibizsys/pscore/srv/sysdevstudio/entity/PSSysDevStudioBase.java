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
package net.ibizsys.pscore.srv.sysdevstudio.entity;

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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevUser;
import net.ibizsys.pscore.srv.devcenter.service.PSDevUserService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysDevStudioBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysDevStudioBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_PSDEVUSERID = "PSDEVUSERID";
    public static final String FIELD_PSDEVUSERNAME = "PSDEVUSERNAME";
    public static final String FIELD_PSSYSDEVSTUDIOID = "PSSYSDEVSTUDIOID";
    public static final String FIELD_PSSYSDEVSTUDIONAME = "PSSYSDEVSTUDIONAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_PSDEVUSERID = 2;
    private static final int INDEX_PSDEVUSERNAME = 3;
    private static final int INDEX_PSSYSDEVSTUDIOID = 4;
    private static final int INDEX_PSSYSDEVSTUDIONAME = 5;
    private static final int INDEX_PSSYSTEMID = 6;
    private static final int INDEX_PSSYSTEMNAME = 7;
    private static final int INDEX_UPDATEDATE = 8;
    private static final int INDEX_UPDATEMAN = 9;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysDevStudioBase proxyPSSysDevStudioBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean psdevuseridDirtyFlag = false;
    private boolean psdevusernameDirtyFlag = false;
    private boolean pssysdevstudioidDirtyFlag = false;
    private boolean pssysdevstudionameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="psdevuserid")
    private String psdevuserid;
    @Column(name="psdevusername")
    private String psdevusername;
    @Column(name="pssysdevstudioid")
    private String pssysdevstudioid;
    @Column(name="pssysdevstudioname")
    private String pssysdevstudioname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDevUserLock = new Integer(1);
    private PSDevUser psdevuser = null;
    private Integer objPssystemLock = new Integer(1);
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

    public void setPSDevUserId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevUserId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevuserid = string;
        this.psdevuseridDirtyFlag = true;
    }

    public String getPSDevUserId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevUserId();
        }
        return this.psdevuserid;
    }

    public boolean isPSDevUserIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevUserIdDirty();
        }
        return this.psdevuseridDirtyFlag;
    }

    public void resetPSDevUserId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevUserId();
            return;
        }
        this.psdevuseridDirtyFlag = false;
        this.psdevuserid = null;
    }

    public void setPSDevUserName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevUserName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevusername = string;
        this.psdevusernameDirtyFlag = true;
    }

    public String getPSDevUserName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevUserName();
        }
        return this.psdevusername;
    }

    public boolean isPSDevUserNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevUserNameDirty();
        }
        return this.psdevusernameDirtyFlag;
    }

    public void resetPSDevUserName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevUserName();
            return;
        }
        this.psdevusernameDirtyFlag = false;
        this.psdevusername = null;
    }

    public void setPSSysDevStudioId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDevStudioId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdevstudioid = string;
        this.pssysdevstudioidDirtyFlag = true;
    }

    public String getPSSysDevStudioId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDevStudioId();
        }
        return this.pssysdevstudioid;
    }

    public boolean isPSSysDevStudioIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDevStudioIdDirty();
        }
        return this.pssysdevstudioidDirtyFlag;
    }

    public void resetPSSysDevStudioId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDevStudioId();
            return;
        }
        this.pssysdevstudioidDirtyFlag = false;
        this.pssysdevstudioid = null;
    }

    public void setPSSysDevStudioName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDevStudioName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdevstudioname = string;
        this.pssysdevstudionameDirtyFlag = true;
    }

    public String getPSSysDevStudioName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDevStudioName();
        }
        return this.pssysdevstudioname;
    }

    public boolean isPSSysDevStudioNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDevStudioNameDirty();
        }
        return this.pssysdevstudionameDirtyFlag;
    }

    public void resetPSSysDevStudioName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDevStudioName();
            return;
        }
        this.pssysdevstudionameDirtyFlag = false;
        this.pssysdevstudioname = null;
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
        PSSysDevStudioBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysDevStudioBase pSSysDevStudioBase) {
        pSSysDevStudioBase.resetCreateDate();
        pSSysDevStudioBase.resetCreateMan();
        pSSysDevStudioBase.resetPSDevUserId();
        pSSysDevStudioBase.resetPSDevUserName();
        pSSysDevStudioBase.resetPSSysDevStudioId();
        pSSysDevStudioBase.resetPSSysDevStudioName();
        pSSysDevStudioBase.resetPSSystemId();
        pSSysDevStudioBase.resetPSSystemName();
        pSSysDevStudioBase.resetUpdateDate();
        pSSysDevStudioBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isPSDevUserIdDirty()) {
            hashMap.put(FIELD_PSDEVUSERID, this.getPSDevUserId());
        }
        if (!bl || this.isPSDevUserNameDirty()) {
            hashMap.put(FIELD_PSDEVUSERNAME, this.getPSDevUserName());
        }
        if (!bl || this.isPSSysDevStudioIdDirty()) {
            hashMap.put(FIELD_PSSYSDEVSTUDIOID, this.getPSSysDevStudioId());
        }
        if (!bl || this.isPSSysDevStudioNameDirty()) {
            hashMap.put(FIELD_PSSYSDEVSTUDIONAME, this.getPSSysDevStudioName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
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
        return PSSysDevStudioBase.get(this, n);
    }

    private static Object get(PSSysDevStudioBase pSSysDevStudioBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDevStudioBase.getCreateDate();
            }
            case 1: {
                return pSSysDevStudioBase.getCreateMan();
            }
            case 2: {
                return pSSysDevStudioBase.getPSDevUserId();
            }
            case 3: {
                return pSSysDevStudioBase.getPSDevUserName();
            }
            case 4: {
                return pSSysDevStudioBase.getPSSysDevStudioId();
            }
            case 5: {
                return pSSysDevStudioBase.getPSSysDevStudioName();
            }
            case 6: {
                return pSSysDevStudioBase.getPSSystemId();
            }
            case 7: {
                return pSSysDevStudioBase.getPSSystemName();
            }
            case 8: {
                return pSSysDevStudioBase.getUpdateDate();
            }
            case 9: {
                return pSSysDevStudioBase.getUpdateMan();
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
        PSSysDevStudioBase.set(this, n, object);
    }

    private static void set(PSSysDevStudioBase pSSysDevStudioBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysDevStudioBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSysDevStudioBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysDevStudioBase.setPSDevUserId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysDevStudioBase.setPSDevUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysDevStudioBase.setPSSysDevStudioId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysDevStudioBase.setPSSysDevStudioName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysDevStudioBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysDevStudioBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysDevStudioBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 9: {
                pSSysDevStudioBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSSysDevStudioBase.isNull(this, n);
    }

    private static boolean isNull(PSSysDevStudioBase pSSysDevStudioBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDevStudioBase.getCreateDate() == null;
            }
            case 1: {
                return pSSysDevStudioBase.getCreateMan() == null;
            }
            case 2: {
                return pSSysDevStudioBase.getPSDevUserId() == null;
            }
            case 3: {
                return pSSysDevStudioBase.getPSDevUserName() == null;
            }
            case 4: {
                return pSSysDevStudioBase.getPSSysDevStudioId() == null;
            }
            case 5: {
                return pSSysDevStudioBase.getPSSysDevStudioName() == null;
            }
            case 6: {
                return pSSysDevStudioBase.getPSSystemId() == null;
            }
            case 7: {
                return pSSysDevStudioBase.getPSSystemName() == null;
            }
            case 8: {
                return pSSysDevStudioBase.getUpdateDate() == null;
            }
            case 9: {
                return pSSysDevStudioBase.getUpdateMan() == null;
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
        return PSSysDevStudioBase.contains(this, n);
    }

    private static boolean contains(PSSysDevStudioBase pSSysDevStudioBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDevStudioBase.isCreateDateDirty();
            }
            case 1: {
                return pSSysDevStudioBase.isCreateManDirty();
            }
            case 2: {
                return pSSysDevStudioBase.isPSDevUserIdDirty();
            }
            case 3: {
                return pSSysDevStudioBase.isPSDevUserNameDirty();
            }
            case 4: {
                return pSSysDevStudioBase.isPSSysDevStudioIdDirty();
            }
            case 5: {
                return pSSysDevStudioBase.isPSSysDevStudioNameDirty();
            }
            case 6: {
                return pSSysDevStudioBase.isPSSystemIdDirty();
            }
            case 7: {
                return pSSysDevStudioBase.isPSSystemNameDirty();
            }
            case 8: {
                return pSSysDevStudioBase.isUpdateDateDirty();
            }
            case 9: {
                return pSSysDevStudioBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysDevStudioBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysDevStudioBase pSSysDevStudioBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysDevStudioBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysDevStudioBase.getJSONValue((Object)pSSysDevStudioBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysDevStudioBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysDevStudioBase.getJSONValue((Object)pSSysDevStudioBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysDevStudioBase.getPSDevUserId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevuserid", (Object)PSSysDevStudioBase.getJSONValue((Object)pSSysDevStudioBase.getPSDevUserId()), (boolean)false);
        }
        if (bl || pSSysDevStudioBase.getPSDevUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevusername", (Object)PSSysDevStudioBase.getJSONValue((Object)pSSysDevStudioBase.getPSDevUserName()), (boolean)false);
        }
        if (bl || pSSysDevStudioBase.getPSSysDevStudioId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdevstudioid", (Object)PSSysDevStudioBase.getJSONValue((Object)pSSysDevStudioBase.getPSSysDevStudioId()), (boolean)false);
        }
        if (bl || pSSysDevStudioBase.getPSSysDevStudioName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdevstudioname", (Object)PSSysDevStudioBase.getJSONValue((Object)pSSysDevStudioBase.getPSSysDevStudioName()), (boolean)false);
        }
        if (bl || pSSysDevStudioBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysDevStudioBase.getJSONValue((Object)pSSysDevStudioBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysDevStudioBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysDevStudioBase.getJSONValue((Object)pSSysDevStudioBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysDevStudioBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysDevStudioBase.getJSONValue((Object)pSSysDevStudioBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysDevStudioBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysDevStudioBase.getJSONValue((Object)pSSysDevStudioBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysDevStudioBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysDevStudioBase pSSysDevStudioBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysDevStudioBase.getCreateDate() != null) {
            object = pSSysDevStudioBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysDevStudioBase.getCreateMan() != null) {
            object = pSSysDevStudioBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysDevStudioBase.getPSDevUserId() != null) {
            object = pSSysDevStudioBase.getPSDevUserId();
            xmlNode.setAttribute(FIELD_PSDEVUSERID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDevStudioBase.getPSDevUserName() != null) {
            object = pSSysDevStudioBase.getPSDevUserName();
            xmlNode.setAttribute(FIELD_PSDEVUSERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDevStudioBase.getPSSysDevStudioId() != null) {
            object = pSSysDevStudioBase.getPSSysDevStudioId();
            xmlNode.setAttribute(FIELD_PSSYSDEVSTUDIOID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDevStudioBase.getPSSysDevStudioName() != null) {
            object = pSSysDevStudioBase.getPSSysDevStudioName();
            xmlNode.setAttribute(FIELD_PSSYSDEVSTUDIONAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDevStudioBase.getPSSystemId() != null) {
            object = pSSysDevStudioBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDevStudioBase.getPSSystemName() != null) {
            object = pSSysDevStudioBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDevStudioBase.getUpdateDate() != null) {
            object = pSSysDevStudioBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysDevStudioBase.getUpdateMan() != null) {
            object = pSSysDevStudioBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysDevStudioBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysDevStudioBase pSSysDevStudioBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysDevStudioBase.isCreateDateDirty() && (bl || pSSysDevStudioBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysDevStudioBase.getCreateDate());
        }
        if (pSSysDevStudioBase.isCreateManDirty() && (bl || pSSysDevStudioBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysDevStudioBase.getCreateMan());
        }
        if (pSSysDevStudioBase.isPSDevUserIdDirty() && (bl || pSSysDevStudioBase.getPSDevUserId() != null)) {
            iDataObject.set(FIELD_PSDEVUSERID, (Object)pSSysDevStudioBase.getPSDevUserId());
        }
        if (pSSysDevStudioBase.isPSDevUserNameDirty() && (bl || pSSysDevStudioBase.getPSDevUserName() != null)) {
            iDataObject.set(FIELD_PSDEVUSERNAME, (Object)pSSysDevStudioBase.getPSDevUserName());
        }
        if (pSSysDevStudioBase.isPSSysDevStudioIdDirty() && (bl || pSSysDevStudioBase.getPSSysDevStudioId() != null)) {
            iDataObject.set(FIELD_PSSYSDEVSTUDIOID, (Object)pSSysDevStudioBase.getPSSysDevStudioId());
        }
        if (pSSysDevStudioBase.isPSSysDevStudioNameDirty() && (bl || pSSysDevStudioBase.getPSSysDevStudioName() != null)) {
            iDataObject.set(FIELD_PSSYSDEVSTUDIONAME, (Object)pSSysDevStudioBase.getPSSysDevStudioName());
        }
        if (pSSysDevStudioBase.isPSSystemIdDirty() && (bl || pSSysDevStudioBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysDevStudioBase.getPSSystemId());
        }
        if (pSSysDevStudioBase.isPSSystemNameDirty() && (bl || pSSysDevStudioBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysDevStudioBase.getPSSystemName());
        }
        if (pSSysDevStudioBase.isUpdateDateDirty() && (bl || pSSysDevStudioBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysDevStudioBase.getUpdateDate());
        }
        if (pSSysDevStudioBase.isUpdateManDirty() && (bl || pSSysDevStudioBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysDevStudioBase.getUpdateMan());
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
        return PSSysDevStudioBase.remove(this, n);
    }

    private static boolean remove(PSSysDevStudioBase pSSysDevStudioBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysDevStudioBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSysDevStudioBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSysDevStudioBase.resetPSDevUserId();
                return true;
            }
            case 3: {
                pSSysDevStudioBase.resetPSDevUserName();
                return true;
            }
            case 4: {
                pSSysDevStudioBase.resetPSSysDevStudioId();
                return true;
            }
            case 5: {
                pSSysDevStudioBase.resetPSSysDevStudioName();
                return true;
            }
            case 6: {
                pSSysDevStudioBase.resetPSSystemId();
                return true;
            }
            case 7: {
                pSSysDevStudioBase.resetPSSystemName();
                return true;
            }
            case 8: {
                pSSysDevStudioBase.resetUpdateDate();
                return true;
            }
            case 9: {
                pSSysDevStudioBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevUser getPSDevUser() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevUser();
        }
        if (this.getPSDevUserId() == null) {
            return null;
        }
        Integer n = this.objPSDevUserLock;
        synchronized (n) {
            if (this.psdevuser != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevUserId(), (Object)this.psdevuser.getPSDevUserId()) != 0L) {
                this.psdevuser = null;
            }
            if (this.psdevuser == null) {
                PSDevUser pSDevUser = new PSDevUser();
                pSDevUser.setPSDevUserId(this.getPSDevUserId());
                PSDevUserService pSDevUserService = (PSDevUserService)ServiceGlobal.getService(PSDevUserService.class, (SessionFactory)this.getSessionFactory());
                pSDevUserService.autoGet((IEntity)pSDevUser);
                this.psdevuser = pSDevUser;
            }
            return this.psdevuser;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSystem getPssystem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPssystem();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        Integer n = this.objPssystemLock;
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

    private PSSysDevStudioBase getProxyEntity() {
        return this.proxyPSSysDevStudioBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysDevStudioBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysDevStudioBase) {
            this.proxyPSSysDevStudioBase = (PSSysDevStudioBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdevstudio.service.PSSysDevStudioService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_PSDEVUSERID, 2);
        fieldIndexMap.put(FIELD_PSDEVUSERNAME, 3);
        fieldIndexMap.put(FIELD_PSSYSDEVSTUDIOID, 4);
        fieldIndexMap.put(FIELD_PSSYSDEVSTUDIONAME, 5);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 6);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 7);
        fieldIndexMap.put(FIELD_UPDATEDATE, 8);
        fieldIndexMap.put(FIELD_UPDATEMAN, 9);
    }
}

