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
package net.ibizsys.pscore.srv.sysdevstudio.entity;

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

public abstract class PSUWModelActionBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSUWModelActionBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSUWMODELACTIONID = "PSUWMODELACTIONID";
    public static final String FIELD_PSUWMODELACTIONNAME = "PSUWMODELACTIONNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_PSDYNAINSTID = 2;
    private static final int INDEX_PSUWMODELACTIONID = 3;
    private static final int INDEX_PSUWMODELACTIONNAME = 4;
    private static final int INDEX_UPDATEDATE = 5;
    private static final int INDEX_UPDATEMAN = 6;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSUWModelActionBase proxyPSUWModelActionBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean psuwmodelactionidDirtyFlag = false;
    private boolean psuwmodelactionnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="psuwmodelactionid")
    private String psuwmodelactionid;
    @Column(name="psuwmodelactionname")
    private String psuwmodelactionname;
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

    public void setPSDynaInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynainstid = string;
        this.psdynainstidDirtyFlag = true;
    }

    public String getPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaInstId();
        }
        return this.psdynainstid;
    }

    public boolean isPSDynaInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaInstIdDirty();
        }
        return this.psdynainstidDirtyFlag;
    }

    public void resetPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaInstId();
            return;
        }
        this.psdynainstidDirtyFlag = false;
        this.psdynainstid = null;
    }

    public void setPSUWModelActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUWModelActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psuwmodelactionid = string;
        this.psuwmodelactionidDirtyFlag = true;
    }

    public String getPSUWModelActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUWModelActionId();
        }
        return this.psuwmodelactionid;
    }

    public boolean isPSUWModelActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUWModelActionIdDirty();
        }
        return this.psuwmodelactionidDirtyFlag;
    }

    public void resetPSUWModelActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUWModelActionId();
            return;
        }
        this.psuwmodelactionidDirtyFlag = false;
        this.psuwmodelactionid = null;
    }

    public void setPSUWModelActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUWModelActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psuwmodelactionname = string;
        this.psuwmodelactionnameDirtyFlag = true;
    }

    public String getPSUWModelActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUWModelActionName();
        }
        return this.psuwmodelactionname;
    }

    public boolean isPSUWModelActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUWModelActionNameDirty();
        }
        return this.psuwmodelactionnameDirtyFlag;
    }

    public void resetPSUWModelActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUWModelActionName();
            return;
        }
        this.psuwmodelactionnameDirtyFlag = false;
        this.psuwmodelactionname = null;
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
        PSUWModelActionBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSUWModelActionBase pSUWModelActionBase) {
        pSUWModelActionBase.resetCreateDate();
        pSUWModelActionBase.resetCreateMan();
        pSUWModelActionBase.resetPSDynaInstId();
        pSUWModelActionBase.resetPSUWModelActionId();
        pSUWModelActionBase.resetPSUWModelActionName();
        pSUWModelActionBase.resetUpdateDate();
        pSUWModelActionBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSUWModelActionIdDirty()) {
            hashMap.put(FIELD_PSUWMODELACTIONID, this.getPSUWModelActionId());
        }
        if (!bl || this.isPSUWModelActionNameDirty()) {
            hashMap.put(FIELD_PSUWMODELACTIONNAME, this.getPSUWModelActionName());
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
        return PSUWModelActionBase.get(this, n);
    }

    private static Object get(PSUWModelActionBase pSUWModelActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUWModelActionBase.getCreateDate();
            }
            case 1: {
                return pSUWModelActionBase.getCreateMan();
            }
            case 2: {
                return pSUWModelActionBase.getPSDynaInstId();
            }
            case 3: {
                return pSUWModelActionBase.getPSUWModelActionId();
            }
            case 4: {
                return pSUWModelActionBase.getPSUWModelActionName();
            }
            case 5: {
                return pSUWModelActionBase.getUpdateDate();
            }
            case 6: {
                return pSUWModelActionBase.getUpdateMan();
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
        PSUWModelActionBase.set(this, n, object);
    }

    private static void set(PSUWModelActionBase pSUWModelActionBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSUWModelActionBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSUWModelActionBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSUWModelActionBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSUWModelActionBase.setPSUWModelActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSUWModelActionBase.setPSUWModelActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSUWModelActionBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 6: {
                pSUWModelActionBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSUWModelActionBase.isNull(this, n);
    }

    private static boolean isNull(PSUWModelActionBase pSUWModelActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUWModelActionBase.getCreateDate() == null;
            }
            case 1: {
                return pSUWModelActionBase.getCreateMan() == null;
            }
            case 2: {
                return pSUWModelActionBase.getPSDynaInstId() == null;
            }
            case 3: {
                return pSUWModelActionBase.getPSUWModelActionId() == null;
            }
            case 4: {
                return pSUWModelActionBase.getPSUWModelActionName() == null;
            }
            case 5: {
                return pSUWModelActionBase.getUpdateDate() == null;
            }
            case 6: {
                return pSUWModelActionBase.getUpdateMan() == null;
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
        return PSUWModelActionBase.contains(this, n);
    }

    private static boolean contains(PSUWModelActionBase pSUWModelActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUWModelActionBase.isCreateDateDirty();
            }
            case 1: {
                return pSUWModelActionBase.isCreateManDirty();
            }
            case 2: {
                return pSUWModelActionBase.isPSDynaInstIdDirty();
            }
            case 3: {
                return pSUWModelActionBase.isPSUWModelActionIdDirty();
            }
            case 4: {
                return pSUWModelActionBase.isPSUWModelActionNameDirty();
            }
            case 5: {
                return pSUWModelActionBase.isUpdateDateDirty();
            }
            case 6: {
                return pSUWModelActionBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSUWModelActionBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSUWModelActionBase pSUWModelActionBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSUWModelActionBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSUWModelActionBase.getJSONValue((Object)pSUWModelActionBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSUWModelActionBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSUWModelActionBase.getJSONValue((Object)pSUWModelActionBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSUWModelActionBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSUWModelActionBase.getJSONValue((Object)pSUWModelActionBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSUWModelActionBase.getPSUWModelActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psuwmodelactionid", (Object)PSUWModelActionBase.getJSONValue((Object)pSUWModelActionBase.getPSUWModelActionId()), (boolean)false);
        }
        if (bl || pSUWModelActionBase.getPSUWModelActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psuwmodelactionname", (Object)PSUWModelActionBase.getJSONValue((Object)pSUWModelActionBase.getPSUWModelActionName()), (boolean)false);
        }
        if (bl || pSUWModelActionBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSUWModelActionBase.getJSONValue((Object)pSUWModelActionBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSUWModelActionBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSUWModelActionBase.getJSONValue((Object)pSUWModelActionBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSUWModelActionBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSUWModelActionBase pSUWModelActionBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSUWModelActionBase.getCreateDate() != null) {
            object = pSUWModelActionBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUWModelActionBase.getCreateMan() != null) {
            object = pSUWModelActionBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSUWModelActionBase.getPSDynaInstId() != null) {
            object = pSUWModelActionBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSUWModelActionBase.getPSUWModelActionId() != null) {
            object = pSUWModelActionBase.getPSUWModelActionId();
            xmlNode.setAttribute(FIELD_PSUWMODELACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSUWModelActionBase.getPSUWModelActionName() != null) {
            object = pSUWModelActionBase.getPSUWModelActionName();
            xmlNode.setAttribute(FIELD_PSUWMODELACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWModelActionBase.getUpdateDate() != null) {
            object = pSUWModelActionBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUWModelActionBase.getUpdateMan() != null) {
            object = pSUWModelActionBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSUWModelActionBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSUWModelActionBase pSUWModelActionBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSUWModelActionBase.isCreateDateDirty() && (bl || pSUWModelActionBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSUWModelActionBase.getCreateDate());
        }
        if (pSUWModelActionBase.isCreateManDirty() && (bl || pSUWModelActionBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSUWModelActionBase.getCreateMan());
        }
        if (pSUWModelActionBase.isPSDynaInstIdDirty() && (bl || pSUWModelActionBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSUWModelActionBase.getPSDynaInstId());
        }
        if (pSUWModelActionBase.isPSUWModelActionIdDirty() && (bl || pSUWModelActionBase.getPSUWModelActionId() != null)) {
            iDataObject.set(FIELD_PSUWMODELACTIONID, (Object)pSUWModelActionBase.getPSUWModelActionId());
        }
        if (pSUWModelActionBase.isPSUWModelActionNameDirty() && (bl || pSUWModelActionBase.getPSUWModelActionName() != null)) {
            iDataObject.set(FIELD_PSUWMODELACTIONNAME, (Object)pSUWModelActionBase.getPSUWModelActionName());
        }
        if (pSUWModelActionBase.isUpdateDateDirty() && (bl || pSUWModelActionBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSUWModelActionBase.getUpdateDate());
        }
        if (pSUWModelActionBase.isUpdateManDirty() && (bl || pSUWModelActionBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSUWModelActionBase.getUpdateMan());
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
        return PSUWModelActionBase.remove(this, n);
    }

    private static boolean remove(PSUWModelActionBase pSUWModelActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSUWModelActionBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSUWModelActionBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSUWModelActionBase.resetPSDynaInstId();
                return true;
            }
            case 3: {
                pSUWModelActionBase.resetPSUWModelActionId();
                return true;
            }
            case 4: {
                pSUWModelActionBase.resetPSUWModelActionName();
                return true;
            }
            case 5: {
                pSUWModelActionBase.resetUpdateDate();
                return true;
            }
            case 6: {
                pSUWModelActionBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSUWModelActionBase getProxyEntity() {
        return this.proxyPSUWModelActionBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSUWModelActionBase = null;
        if (iDataObject != null && iDataObject instanceof PSUWModelActionBase) {
            this.proxyPSUWModelActionBase = (PSUWModelActionBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdevstudio.service.PSUWModelActionService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 2);
        fieldIndexMap.put(FIELD_PSUWMODELACTIONID, 3);
        fieldIndexMap.put(FIELD_PSUWMODELACTIONNAME, 4);
        fieldIndexMap.put(FIELD_UPDATEDATE, 5);
        fieldIndexMap.put(FIELD_UPDATEMAN, 6);
    }
}

