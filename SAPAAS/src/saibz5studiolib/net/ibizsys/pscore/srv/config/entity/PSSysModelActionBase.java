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
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInst;
import net.ibizsys.pscore.srv.paasmgr.service.PSSysModelInstService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysModelActionBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysModelActionBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_PSSYSMODELACTIONID = "PSSYSMODELACTIONID";
    public static final String FIELD_PSSYSMODELACTIONNAME = "PSSYSMODELACTIONNAME";
    public static final String FIELD_PSSYSMODELINSTID = "PSSYSMODELINSTID";
    public static final String FIELD_PSSYSMODELINSTNAME = "PSSYSMODELINSTNAME";
    public static final String FIELD_SRCPSSYSMODELINSTID = "SRCPSSYSMODELINSTID";
    public static final String FIELD_SRCPSSYSMODELINSTNAME = "SRCPSSYSMODELINSTNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_PSSYSMODELACTIONID = 2;
    private static final int INDEX_PSSYSMODELACTIONNAME = 3;
    private static final int INDEX_PSSYSMODELINSTID = 4;
    private static final int INDEX_PSSYSMODELINSTNAME = 5;
    private static final int INDEX_SRCPSSYSMODELINSTID = 6;
    private static final int INDEX_SRCPSSYSMODELINSTNAME = 7;
    private static final int INDEX_UPDATEDATE = 8;
    private static final int INDEX_UPDATEMAN = 9;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysModelActionBase proxyPSSysModelActionBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean pssysmodelactionidDirtyFlag = false;
    private boolean pssysmodelactionnameDirtyFlag = false;
    private boolean pssysmodelinstidDirtyFlag = false;
    private boolean pssysmodelinstnameDirtyFlag = false;
    private boolean srcpssysmodelinstidDirtyFlag = false;
    private boolean srcpssysmodelinstnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="pssysmodelactionid")
    private String pssysmodelactionid;
    @Column(name="pssysmodelactionname")
    private String pssysmodelactionname;
    @Column(name="pssysmodelinstid")
    private String pssysmodelinstid;
    @Column(name="pssysmodelinstname")
    private String pssysmodelinstname;
    @Column(name="srcpssysmodelinstid")
    private String srcpssysmodelinstid;
    @Column(name="srcpssysmodelinstname")
    private String srcpssysmodelinstname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSSysModelInstLock = new Integer(1);
    private PSSysModelInst pssysmodelinst = null;
    private Integer objSrcPSSysModelInstLock = new Integer(1);
    private PSSysModelInst srcpssysmodelinst = null;

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

    public void setPSSysModelActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysModelActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmodelactionid = string;
        this.pssysmodelactionidDirtyFlag = true;
    }

    public String getPSSysModelActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelActionId();
        }
        return this.pssysmodelactionid;
    }

    public boolean isPSSysModelActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysModelActionIdDirty();
        }
        return this.pssysmodelactionidDirtyFlag;
    }

    public void resetPSSysModelActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysModelActionId();
            return;
        }
        this.pssysmodelactionidDirtyFlag = false;
        this.pssysmodelactionid = null;
    }

    public void setPSSysModelActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysModelActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmodelactionname = string;
        this.pssysmodelactionnameDirtyFlag = true;
    }

    public String getPSSysModelActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelActionName();
        }
        return this.pssysmodelactionname;
    }

    public boolean isPSSysModelActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysModelActionNameDirty();
        }
        return this.pssysmodelactionnameDirtyFlag;
    }

    public void resetPSSysModelActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysModelActionName();
            return;
        }
        this.pssysmodelactionnameDirtyFlag = false;
        this.pssysmodelactionname = null;
    }

    public void setPSSysModelInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysModelInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmodelinstid = string;
        this.pssysmodelinstidDirtyFlag = true;
    }

    public String getPSSysModelInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelInstId();
        }
        return this.pssysmodelinstid;
    }

    public boolean isPSSysModelInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysModelInstIdDirty();
        }
        return this.pssysmodelinstidDirtyFlag;
    }

    public void resetPSSysModelInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysModelInstId();
            return;
        }
        this.pssysmodelinstidDirtyFlag = false;
        this.pssysmodelinstid = null;
    }

    public void setPSSysModelInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysModelInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmodelinstname = string;
        this.pssysmodelinstnameDirtyFlag = true;
    }

    public String getPSSysModelInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelInstName();
        }
        return this.pssysmodelinstname;
    }

    public boolean isPSSysModelInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysModelInstNameDirty();
        }
        return this.pssysmodelinstnameDirtyFlag;
    }

    public void resetPSSysModelInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysModelInstName();
            return;
        }
        this.pssysmodelinstnameDirtyFlag = false;
        this.pssysmodelinstname = null;
    }

    public void setSrcPSSysModelInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSrcPSSysModelInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.srcpssysmodelinstid = string;
        this.srcpssysmodelinstidDirtyFlag = true;
    }

    public String getSrcPSSysModelInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSrcPSSysModelInstId();
        }
        return this.srcpssysmodelinstid;
    }

    public boolean isSrcPSSysModelInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSrcPSSysModelInstIdDirty();
        }
        return this.srcpssysmodelinstidDirtyFlag;
    }

    public void resetSrcPSSysModelInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSrcPSSysModelInstId();
            return;
        }
        this.srcpssysmodelinstidDirtyFlag = false;
        this.srcpssysmodelinstid = null;
    }

    public void setSrcPSSysModelInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSrcPSSysModelInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.srcpssysmodelinstname = string;
        this.srcpssysmodelinstnameDirtyFlag = true;
    }

    public String getSrcPSSysModelInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSrcPSSysModelInstName();
        }
        return this.srcpssysmodelinstname;
    }

    public boolean isSrcPSSysModelInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSrcPSSysModelInstNameDirty();
        }
        return this.srcpssysmodelinstnameDirtyFlag;
    }

    public void resetSrcPSSysModelInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSrcPSSysModelInstName();
            return;
        }
        this.srcpssysmodelinstnameDirtyFlag = false;
        this.srcpssysmodelinstname = null;
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
        PSSysModelActionBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysModelActionBase pSSysModelActionBase) {
        pSSysModelActionBase.resetCreateDate();
        pSSysModelActionBase.resetCreateMan();
        pSSysModelActionBase.resetPSSysModelActionId();
        pSSysModelActionBase.resetPSSysModelActionName();
        pSSysModelActionBase.resetPSSysModelInstId();
        pSSysModelActionBase.resetPSSysModelInstName();
        pSSysModelActionBase.resetSrcPSSysModelInstId();
        pSSysModelActionBase.resetSrcPSSysModelInstName();
        pSSysModelActionBase.resetUpdateDate();
        pSSysModelActionBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isPSSysModelActionIdDirty()) {
            hashMap.put(FIELD_PSSYSMODELACTIONID, this.getPSSysModelActionId());
        }
        if (!bl || this.isPSSysModelActionNameDirty()) {
            hashMap.put(FIELD_PSSYSMODELACTIONNAME, this.getPSSysModelActionName());
        }
        if (!bl || this.isPSSysModelInstIdDirty()) {
            hashMap.put(FIELD_PSSYSMODELINSTID, this.getPSSysModelInstId());
        }
        if (!bl || this.isPSSysModelInstNameDirty()) {
            hashMap.put(FIELD_PSSYSMODELINSTNAME, this.getPSSysModelInstName());
        }
        if (!bl || this.isSrcPSSysModelInstIdDirty()) {
            hashMap.put(FIELD_SRCPSSYSMODELINSTID, this.getSrcPSSysModelInstId());
        }
        if (!bl || this.isSrcPSSysModelInstNameDirty()) {
            hashMap.put(FIELD_SRCPSSYSMODELINSTNAME, this.getSrcPSSysModelInstName());
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
        return PSSysModelActionBase.get(this, n);
    }

    private static Object get(PSSysModelActionBase pSSysModelActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysModelActionBase.getCreateDate();
            }
            case 1: {
                return pSSysModelActionBase.getCreateMan();
            }
            case 2: {
                return pSSysModelActionBase.getPSSysModelActionId();
            }
            case 3: {
                return pSSysModelActionBase.getPSSysModelActionName();
            }
            case 4: {
                return pSSysModelActionBase.getPSSysModelInstId();
            }
            case 5: {
                return pSSysModelActionBase.getPSSysModelInstName();
            }
            case 6: {
                return pSSysModelActionBase.getSrcPSSysModelInstId();
            }
            case 7: {
                return pSSysModelActionBase.getSrcPSSysModelInstName();
            }
            case 8: {
                return pSSysModelActionBase.getUpdateDate();
            }
            case 9: {
                return pSSysModelActionBase.getUpdateMan();
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
        PSSysModelActionBase.set(this, n, object);
    }

    private static void set(PSSysModelActionBase pSSysModelActionBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysModelActionBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSysModelActionBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysModelActionBase.setPSSysModelActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysModelActionBase.setPSSysModelActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysModelActionBase.setPSSysModelInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysModelActionBase.setPSSysModelInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysModelActionBase.setSrcPSSysModelInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysModelActionBase.setSrcPSSysModelInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysModelActionBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 9: {
                pSSysModelActionBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSSysModelActionBase.isNull(this, n);
    }

    private static boolean isNull(PSSysModelActionBase pSSysModelActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysModelActionBase.getCreateDate() == null;
            }
            case 1: {
                return pSSysModelActionBase.getCreateMan() == null;
            }
            case 2: {
                return pSSysModelActionBase.getPSSysModelActionId() == null;
            }
            case 3: {
                return pSSysModelActionBase.getPSSysModelActionName() == null;
            }
            case 4: {
                return pSSysModelActionBase.getPSSysModelInstId() == null;
            }
            case 5: {
                return pSSysModelActionBase.getPSSysModelInstName() == null;
            }
            case 6: {
                return pSSysModelActionBase.getSrcPSSysModelInstId() == null;
            }
            case 7: {
                return pSSysModelActionBase.getSrcPSSysModelInstName() == null;
            }
            case 8: {
                return pSSysModelActionBase.getUpdateDate() == null;
            }
            case 9: {
                return pSSysModelActionBase.getUpdateMan() == null;
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
        return PSSysModelActionBase.contains(this, n);
    }

    private static boolean contains(PSSysModelActionBase pSSysModelActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysModelActionBase.isCreateDateDirty();
            }
            case 1: {
                return pSSysModelActionBase.isCreateManDirty();
            }
            case 2: {
                return pSSysModelActionBase.isPSSysModelActionIdDirty();
            }
            case 3: {
                return pSSysModelActionBase.isPSSysModelActionNameDirty();
            }
            case 4: {
                return pSSysModelActionBase.isPSSysModelInstIdDirty();
            }
            case 5: {
                return pSSysModelActionBase.isPSSysModelInstNameDirty();
            }
            case 6: {
                return pSSysModelActionBase.isSrcPSSysModelInstIdDirty();
            }
            case 7: {
                return pSSysModelActionBase.isSrcPSSysModelInstNameDirty();
            }
            case 8: {
                return pSSysModelActionBase.isUpdateDateDirty();
            }
            case 9: {
                return pSSysModelActionBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysModelActionBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysModelActionBase pSSysModelActionBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysModelActionBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysModelActionBase.getJSONValue((Object)pSSysModelActionBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysModelActionBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysModelActionBase.getJSONValue((Object)pSSysModelActionBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysModelActionBase.getPSSysModelActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelactionid", (Object)PSSysModelActionBase.getJSONValue((Object)pSSysModelActionBase.getPSSysModelActionId()), (boolean)false);
        }
        if (bl || pSSysModelActionBase.getPSSysModelActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelactionname", (Object)PSSysModelActionBase.getJSONValue((Object)pSSysModelActionBase.getPSSysModelActionName()), (boolean)false);
        }
        if (bl || pSSysModelActionBase.getPSSysModelInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelinstid", (Object)PSSysModelActionBase.getJSONValue((Object)pSSysModelActionBase.getPSSysModelInstId()), (boolean)false);
        }
        if (bl || pSSysModelActionBase.getPSSysModelInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelinstname", (Object)PSSysModelActionBase.getJSONValue((Object)pSSysModelActionBase.getPSSysModelInstName()), (boolean)false);
        }
        if (bl || pSSysModelActionBase.getSrcPSSysModelInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srcpssysmodelinstid", (Object)PSSysModelActionBase.getJSONValue((Object)pSSysModelActionBase.getSrcPSSysModelInstId()), (boolean)false);
        }
        if (bl || pSSysModelActionBase.getSrcPSSysModelInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srcpssysmodelinstname", (Object)PSSysModelActionBase.getJSONValue((Object)pSSysModelActionBase.getSrcPSSysModelInstName()), (boolean)false);
        }
        if (bl || pSSysModelActionBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysModelActionBase.getJSONValue((Object)pSSysModelActionBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysModelActionBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysModelActionBase.getJSONValue((Object)pSSysModelActionBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysModelActionBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysModelActionBase pSSysModelActionBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysModelActionBase.getCreateDate() != null) {
            object = pSSysModelActionBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysModelActionBase.getCreateMan() != null) {
            object = pSSysModelActionBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelActionBase.getPSSysModelActionId() != null) {
            object = pSSysModelActionBase.getPSSysModelActionId();
            xmlNode.setAttribute(FIELD_PSSYSMODELACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelActionBase.getPSSysModelActionName() != null) {
            object = pSSysModelActionBase.getPSSysModelActionName();
            xmlNode.setAttribute(FIELD_PSSYSMODELACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelActionBase.getPSSysModelInstId() != null) {
            object = pSSysModelActionBase.getPSSysModelInstId();
            xmlNode.setAttribute(FIELD_PSSYSMODELINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelActionBase.getPSSysModelInstName() != null) {
            object = pSSysModelActionBase.getPSSysModelInstName();
            xmlNode.setAttribute(FIELD_PSSYSMODELINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelActionBase.getSrcPSSysModelInstId() != null) {
            object = pSSysModelActionBase.getSrcPSSysModelInstId();
            xmlNode.setAttribute(FIELD_SRCPSSYSMODELINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelActionBase.getSrcPSSysModelInstName() != null) {
            object = pSSysModelActionBase.getSrcPSSysModelInstName();
            xmlNode.setAttribute(FIELD_SRCPSSYSMODELINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelActionBase.getUpdateDate() != null) {
            object = pSSysModelActionBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysModelActionBase.getUpdateMan() != null) {
            object = pSSysModelActionBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysModelActionBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysModelActionBase pSSysModelActionBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysModelActionBase.isCreateDateDirty() && (bl || pSSysModelActionBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysModelActionBase.getCreateDate());
        }
        if (pSSysModelActionBase.isCreateManDirty() && (bl || pSSysModelActionBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysModelActionBase.getCreateMan());
        }
        if (pSSysModelActionBase.isPSSysModelActionIdDirty() && (bl || pSSysModelActionBase.getPSSysModelActionId() != null)) {
            iDataObject.set(FIELD_PSSYSMODELACTIONID, (Object)pSSysModelActionBase.getPSSysModelActionId());
        }
        if (pSSysModelActionBase.isPSSysModelActionNameDirty() && (bl || pSSysModelActionBase.getPSSysModelActionName() != null)) {
            iDataObject.set(FIELD_PSSYSMODELACTIONNAME, (Object)pSSysModelActionBase.getPSSysModelActionName());
        }
        if (pSSysModelActionBase.isPSSysModelInstIdDirty() && (bl || pSSysModelActionBase.getPSSysModelInstId() != null)) {
            iDataObject.set(FIELD_PSSYSMODELINSTID, (Object)pSSysModelActionBase.getPSSysModelInstId());
        }
        if (pSSysModelActionBase.isPSSysModelInstNameDirty() && (bl || pSSysModelActionBase.getPSSysModelInstName() != null)) {
            iDataObject.set(FIELD_PSSYSMODELINSTNAME, (Object)pSSysModelActionBase.getPSSysModelInstName());
        }
        if (pSSysModelActionBase.isSrcPSSysModelInstIdDirty() && (bl || pSSysModelActionBase.getSrcPSSysModelInstId() != null)) {
            iDataObject.set(FIELD_SRCPSSYSMODELINSTID, (Object)pSSysModelActionBase.getSrcPSSysModelInstId());
        }
        if (pSSysModelActionBase.isSrcPSSysModelInstNameDirty() && (bl || pSSysModelActionBase.getSrcPSSysModelInstName() != null)) {
            iDataObject.set(FIELD_SRCPSSYSMODELINSTNAME, (Object)pSSysModelActionBase.getSrcPSSysModelInstName());
        }
        if (pSSysModelActionBase.isUpdateDateDirty() && (bl || pSSysModelActionBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysModelActionBase.getUpdateDate());
        }
        if (pSSysModelActionBase.isUpdateManDirty() && (bl || pSSysModelActionBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysModelActionBase.getUpdateMan());
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
        return PSSysModelActionBase.remove(this, n);
    }

    private static boolean remove(PSSysModelActionBase pSSysModelActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysModelActionBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSysModelActionBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSysModelActionBase.resetPSSysModelActionId();
                return true;
            }
            case 3: {
                pSSysModelActionBase.resetPSSysModelActionName();
                return true;
            }
            case 4: {
                pSSysModelActionBase.resetPSSysModelInstId();
                return true;
            }
            case 5: {
                pSSysModelActionBase.resetPSSysModelInstName();
                return true;
            }
            case 6: {
                pSSysModelActionBase.resetSrcPSSysModelInstId();
                return true;
            }
            case 7: {
                pSSysModelActionBase.resetSrcPSSysModelInstName();
                return true;
            }
            case 8: {
                pSSysModelActionBase.resetUpdateDate();
                return true;
            }
            case 9: {
                pSSysModelActionBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysModelInst getPSSysModelInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelInst();
        }
        if (this.getPSSysModelInstId() == null) {
            return null;
        }
        Integer n = this.objPSSysModelInstLock;
        synchronized (n) {
            if (this.pssysmodelinst != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysModelInstId(), (Object)this.pssysmodelinst.getPSSysModelInstId()) != 0L) {
                this.pssysmodelinst = null;
            }
            if (this.pssysmodelinst == null) {
                PSSysModelInst pSSysModelInst = new PSSysModelInst();
                pSSysModelInst.setPSSysModelInstId(this.getPSSysModelInstId());
                PSSysModelInstService pSSysModelInstService = (PSSysModelInstService)ServiceGlobal.getService(PSSysModelInstService.class, (SessionFactory)this.getSessionFactory());
                pSSysModelInstService.autoGet(pSSysModelInst);
                this.pssysmodelinst = pSSysModelInst;
            }
            return this.pssysmodelinst;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysModelInst getSrcPSSysModelInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSrcPSSysModelInst();
        }
        if (this.getSrcPSSysModelInstId() == null) {
            return null;
        }
        Integer n = this.objSrcPSSysModelInstLock;
        synchronized (n) {
            if (this.srcpssysmodelinst != null && DataTypeHelper.compare((int)25, (Object)this.getSrcPSSysModelInstId(), (Object)this.srcpssysmodelinst.getPSSysModelInstId()) != 0L) {
                this.srcpssysmodelinst = null;
            }
            if (this.srcpssysmodelinst == null) {
                PSSysModelInst pSSysModelInst = new PSSysModelInst();
                pSSysModelInst.setPSSysModelInstId(this.getSrcPSSysModelInstId());
                PSSysModelInstService pSSysModelInstService = (PSSysModelInstService)ServiceGlobal.getService(PSSysModelInstService.class, (SessionFactory)this.getSessionFactory());
                pSSysModelInstService.autoGet(pSSysModelInst);
                this.srcpssysmodelinst = pSSysModelInst;
            }
            return this.srcpssysmodelinst;
        }
    }

    private PSSysModelActionBase getProxyEntity() {
        return this.proxyPSSysModelActionBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysModelActionBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysModelActionBase) {
            this.proxyPSSysModelActionBase = (PSSysModelActionBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysModelActionService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_PSSYSMODELACTIONID, 2);
        fieldIndexMap.put(FIELD_PSSYSMODELACTIONNAME, 3);
        fieldIndexMap.put(FIELD_PSSYSMODELINSTID, 4);
        fieldIndexMap.put(FIELD_PSSYSMODELINSTNAME, 5);
        fieldIndexMap.put(FIELD_SRCPSSYSMODELINSTID, 6);
        fieldIndexMap.put(FIELD_SRCPSSYSMODELINSTNAME, 7);
        fieldIndexMap.put(FIELD_UPDATEDATE, 8);
        fieldIndexMap.put(FIELD_UPDATEMAN, 9);
    }
}

