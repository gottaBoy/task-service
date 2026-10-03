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
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSSysDevStudio;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSSysDevStudioService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysDSActionBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysDSActionBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_PSSYSDEVSTUDIOID = "PSSYSDEVSTUDIOID";
    public static final String FIELD_PSSYSDEVSTUDIONAME = "PSSYSDEVSTUDIONAME";
    public static final String FIELD_PSSYSDSACTIONID = "PSSYSDSACTIONID";
    public static final String FIELD_PSSYSDSACTIONNAME = "PSSYSDSACTIONNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_PSSYSDEVSTUDIOID = 2;
    private static final int INDEX_PSSYSDEVSTUDIONAME = 3;
    private static final int INDEX_PSSYSDSACTIONID = 4;
    private static final int INDEX_PSSYSDSACTIONNAME = 5;
    private static final int INDEX_UPDATEDATE = 6;
    private static final int INDEX_UPDATEMAN = 7;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysDSActionBase proxyPSSysDSActionBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean pssysdevstudioidDirtyFlag = false;
    private boolean pssysdevstudionameDirtyFlag = false;
    private boolean pssysdsactionidDirtyFlag = false;
    private boolean pssysdsactionnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="pssysdevstudioid")
    private String pssysdevstudioid;
    @Column(name="pssysdevstudioname")
    private String pssysdevstudioname;
    @Column(name="pssysdsactionid")
    private String pssysdsactionid;
    @Column(name="pssysdsactionname")
    private String pssysdsactionname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPssysdevstudioLock = new Integer(1);
    private PSSysDevStudio pssysdevstudio = null;

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

    public void setPSSysDSActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDSActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdsactionid = string;
        this.pssysdsactionidDirtyFlag = true;
    }

    public String getPSSysDSActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDSActionId();
        }
        return this.pssysdsactionid;
    }

    public boolean isPSSysDSActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDSActionIdDirty();
        }
        return this.pssysdsactionidDirtyFlag;
    }

    public void resetPSSysDSActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDSActionId();
            return;
        }
        this.pssysdsactionidDirtyFlag = false;
        this.pssysdsactionid = null;
    }

    public void setPSSysDSActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDSActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdsactionname = string;
        this.pssysdsactionnameDirtyFlag = true;
    }

    public String getPSSysDSActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDSActionName();
        }
        return this.pssysdsactionname;
    }

    public boolean isPSSysDSActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDSActionNameDirty();
        }
        return this.pssysdsactionnameDirtyFlag;
    }

    public void resetPSSysDSActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDSActionName();
            return;
        }
        this.pssysdsactionnameDirtyFlag = false;
        this.pssysdsactionname = null;
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
        PSSysDSActionBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysDSActionBase pSSysDSActionBase) {
        pSSysDSActionBase.resetCreateDate();
        pSSysDSActionBase.resetCreateMan();
        pSSysDSActionBase.resetPSSysDevStudioId();
        pSSysDSActionBase.resetPSSysDevStudioName();
        pSSysDSActionBase.resetPSSysDSActionId();
        pSSysDSActionBase.resetPSSysDSActionName();
        pSSysDSActionBase.resetUpdateDate();
        pSSysDSActionBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isPSSysDevStudioIdDirty()) {
            hashMap.put(FIELD_PSSYSDEVSTUDIOID, this.getPSSysDevStudioId());
        }
        if (!bl || this.isPSSysDevStudioNameDirty()) {
            hashMap.put(FIELD_PSSYSDEVSTUDIONAME, this.getPSSysDevStudioName());
        }
        if (!bl || this.isPSSysDSActionIdDirty()) {
            hashMap.put(FIELD_PSSYSDSACTIONID, this.getPSSysDSActionId());
        }
        if (!bl || this.isPSSysDSActionNameDirty()) {
            hashMap.put(FIELD_PSSYSDSACTIONNAME, this.getPSSysDSActionName());
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
        return PSSysDSActionBase.get(this, n);
    }

    private static Object get(PSSysDSActionBase pSSysDSActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDSActionBase.getCreateDate();
            }
            case 1: {
                return pSSysDSActionBase.getCreateMan();
            }
            case 2: {
                return pSSysDSActionBase.getPSSysDevStudioId();
            }
            case 3: {
                return pSSysDSActionBase.getPSSysDevStudioName();
            }
            case 4: {
                return pSSysDSActionBase.getPSSysDSActionId();
            }
            case 5: {
                return pSSysDSActionBase.getPSSysDSActionName();
            }
            case 6: {
                return pSSysDSActionBase.getUpdateDate();
            }
            case 7: {
                return pSSysDSActionBase.getUpdateMan();
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
        PSSysDSActionBase.set(this, n, object);
    }

    private static void set(PSSysDSActionBase pSSysDSActionBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysDSActionBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSysDSActionBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysDSActionBase.setPSSysDevStudioId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysDSActionBase.setPSSysDevStudioName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysDSActionBase.setPSSysDSActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysDSActionBase.setPSSysDSActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysDSActionBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSSysDSActionBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSSysDSActionBase.isNull(this, n);
    }

    private static boolean isNull(PSSysDSActionBase pSSysDSActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDSActionBase.getCreateDate() == null;
            }
            case 1: {
                return pSSysDSActionBase.getCreateMan() == null;
            }
            case 2: {
                return pSSysDSActionBase.getPSSysDevStudioId() == null;
            }
            case 3: {
                return pSSysDSActionBase.getPSSysDevStudioName() == null;
            }
            case 4: {
                return pSSysDSActionBase.getPSSysDSActionId() == null;
            }
            case 5: {
                return pSSysDSActionBase.getPSSysDSActionName() == null;
            }
            case 6: {
                return pSSysDSActionBase.getUpdateDate() == null;
            }
            case 7: {
                return pSSysDSActionBase.getUpdateMan() == null;
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
        return PSSysDSActionBase.contains(this, n);
    }

    private static boolean contains(PSSysDSActionBase pSSysDSActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDSActionBase.isCreateDateDirty();
            }
            case 1: {
                return pSSysDSActionBase.isCreateManDirty();
            }
            case 2: {
                return pSSysDSActionBase.isPSSysDevStudioIdDirty();
            }
            case 3: {
                return pSSysDSActionBase.isPSSysDevStudioNameDirty();
            }
            case 4: {
                return pSSysDSActionBase.isPSSysDSActionIdDirty();
            }
            case 5: {
                return pSSysDSActionBase.isPSSysDSActionNameDirty();
            }
            case 6: {
                return pSSysDSActionBase.isUpdateDateDirty();
            }
            case 7: {
                return pSSysDSActionBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysDSActionBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysDSActionBase pSSysDSActionBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysDSActionBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysDSActionBase.getJSONValue((Object)pSSysDSActionBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysDSActionBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysDSActionBase.getJSONValue((Object)pSSysDSActionBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysDSActionBase.getPSSysDevStudioId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdevstudioid", (Object)PSSysDSActionBase.getJSONValue((Object)pSSysDSActionBase.getPSSysDevStudioId()), (boolean)false);
        }
        if (bl || pSSysDSActionBase.getPSSysDevStudioName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdevstudioname", (Object)PSSysDSActionBase.getJSONValue((Object)pSSysDSActionBase.getPSSysDevStudioName()), (boolean)false);
        }
        if (bl || pSSysDSActionBase.getPSSysDSActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdsactionid", (Object)PSSysDSActionBase.getJSONValue((Object)pSSysDSActionBase.getPSSysDSActionId()), (boolean)false);
        }
        if (bl || pSSysDSActionBase.getPSSysDSActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdsactionname", (Object)PSSysDSActionBase.getJSONValue((Object)pSSysDSActionBase.getPSSysDSActionName()), (boolean)false);
        }
        if (bl || pSSysDSActionBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysDSActionBase.getJSONValue((Object)pSSysDSActionBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysDSActionBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysDSActionBase.getJSONValue((Object)pSSysDSActionBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysDSActionBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysDSActionBase pSSysDSActionBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysDSActionBase.getCreateDate() != null) {
            object = pSSysDSActionBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysDSActionBase.getCreateMan() != null) {
            object = pSSysDSActionBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysDSActionBase.getPSSysDevStudioId() != null) {
            object = pSSysDSActionBase.getPSSysDevStudioId();
            xmlNode.setAttribute(FIELD_PSSYSDEVSTUDIOID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDSActionBase.getPSSysDevStudioName() != null) {
            object = pSSysDSActionBase.getPSSysDevStudioName();
            xmlNode.setAttribute(FIELD_PSSYSDEVSTUDIONAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDSActionBase.getPSSysDSActionId() != null) {
            object = pSSysDSActionBase.getPSSysDSActionId();
            xmlNode.setAttribute(FIELD_PSSYSDSACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDSActionBase.getPSSysDSActionName() != null) {
            object = pSSysDSActionBase.getPSSysDSActionName();
            xmlNode.setAttribute(FIELD_PSSYSDSACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDSActionBase.getUpdateDate() != null) {
            object = pSSysDSActionBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysDSActionBase.getUpdateMan() != null) {
            object = pSSysDSActionBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysDSActionBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysDSActionBase pSSysDSActionBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysDSActionBase.isCreateDateDirty() && (bl || pSSysDSActionBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysDSActionBase.getCreateDate());
        }
        if (pSSysDSActionBase.isCreateManDirty() && (bl || pSSysDSActionBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysDSActionBase.getCreateMan());
        }
        if (pSSysDSActionBase.isPSSysDevStudioIdDirty() && (bl || pSSysDSActionBase.getPSSysDevStudioId() != null)) {
            iDataObject.set(FIELD_PSSYSDEVSTUDIOID, (Object)pSSysDSActionBase.getPSSysDevStudioId());
        }
        if (pSSysDSActionBase.isPSSysDevStudioNameDirty() && (bl || pSSysDSActionBase.getPSSysDevStudioName() != null)) {
            iDataObject.set(FIELD_PSSYSDEVSTUDIONAME, (Object)pSSysDSActionBase.getPSSysDevStudioName());
        }
        if (pSSysDSActionBase.isPSSysDSActionIdDirty() && (bl || pSSysDSActionBase.getPSSysDSActionId() != null)) {
            iDataObject.set(FIELD_PSSYSDSACTIONID, (Object)pSSysDSActionBase.getPSSysDSActionId());
        }
        if (pSSysDSActionBase.isPSSysDSActionNameDirty() && (bl || pSSysDSActionBase.getPSSysDSActionName() != null)) {
            iDataObject.set(FIELD_PSSYSDSACTIONNAME, (Object)pSSysDSActionBase.getPSSysDSActionName());
        }
        if (pSSysDSActionBase.isUpdateDateDirty() && (bl || pSSysDSActionBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysDSActionBase.getUpdateDate());
        }
        if (pSSysDSActionBase.isUpdateManDirty() && (bl || pSSysDSActionBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysDSActionBase.getUpdateMan());
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
        return PSSysDSActionBase.remove(this, n);
    }

    private static boolean remove(PSSysDSActionBase pSSysDSActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysDSActionBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSysDSActionBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSysDSActionBase.resetPSSysDevStudioId();
                return true;
            }
            case 3: {
                pSSysDSActionBase.resetPSSysDevStudioName();
                return true;
            }
            case 4: {
                pSSysDSActionBase.resetPSSysDSActionId();
                return true;
            }
            case 5: {
                pSSysDSActionBase.resetPSSysDSActionName();
                return true;
            }
            case 6: {
                pSSysDSActionBase.resetUpdateDate();
                return true;
            }
            case 7: {
                pSSysDSActionBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysDevStudio getPssysdevstudio() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPssysdevstudio();
        }
        if (this.getPSSysDevStudioId() == null) {
            return null;
        }
        Integer n = this.objPssysdevstudioLock;
        synchronized (n) {
            if (this.pssysdevstudio != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysDevStudioId(), (Object)this.pssysdevstudio.getPSSysDevStudioId()) != 0L) {
                this.pssysdevstudio = null;
            }
            if (this.pssysdevstudio == null) {
                PSSysDevStudio pSSysDevStudio = new PSSysDevStudio();
                pSSysDevStudio.setPSSysDevStudioId(this.getPSSysDevStudioId());
                PSSysDevStudioService pSSysDevStudioService = (PSSysDevStudioService)ServiceGlobal.getService(PSSysDevStudioService.class, (SessionFactory)this.getSessionFactory());
                pSSysDevStudioService.autoGet(pSSysDevStudio);
                this.pssysdevstudio = pSSysDevStudio;
            }
            return this.pssysdevstudio;
        }
    }

    private PSSysDSActionBase getProxyEntity() {
        return this.proxyPSSysDSActionBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysDSActionBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysDSActionBase) {
            this.proxyPSSysDSActionBase = (PSSysDSActionBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdevstudio.service.PSSysDSActionService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_PSSYSDEVSTUDIOID, 2);
        fieldIndexMap.put(FIELD_PSSYSDEVSTUDIONAME, 3);
        fieldIndexMap.put(FIELD_PSSYSDSACTIONID, 4);
        fieldIndexMap.put(FIELD_PSSYSDSACTIONNAME, 5);
        fieldIndexMap.put(FIELD_UPDATEDATE, 6);
        fieldIndexMap.put(FIELD_UPDATEMAN, 7);
    }
}

