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
package net.ibizsys.pscore.srv.config.entity;

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

public abstract class PSCssCatTemplBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSCssCatTemplBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSCSSCATTEMPLID = "PSCSSCATTEMPLID";
    public static final String FIELD_PSCSSCATTEMPLNAME = "PSCSSCATTEMPLNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSCSSCATTEMPLID = 3;
    private static final int INDEX_PSCSSCATTEMPLNAME = 4;
    private static final int INDEX_UPDATEDATE = 5;
    private static final int INDEX_UPDATEMAN = 6;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSCssCatTemplBase proxyPSCssCatTemplBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pscsscattemplidDirtyFlag = false;
    private boolean pscsscattemplnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="pscsscattemplid")
    private String pscsscattemplid;
    @Column(name="pscsscattemplname")
    private String pscsscattemplname;
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

    public void setPSCssCatTemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCssCatTemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscsscattemplid = string;
        this.pscsscattemplidDirtyFlag = true;
    }

    public String getPSCssCatTemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCssCatTemplId();
        }
        return this.pscsscattemplid;
    }

    public boolean isPSCssCatTemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCssCatTemplIdDirty();
        }
        return this.pscsscattemplidDirtyFlag;
    }

    public void resetPSCssCatTemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCssCatTemplId();
            return;
        }
        this.pscsscattemplidDirtyFlag = false;
        this.pscsscattemplid = null;
    }

    public void setPSCssCatTemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCssCatTemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscsscattemplname = string;
        this.pscsscattemplnameDirtyFlag = true;
    }

    public String getPSCssCatTemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCssCatTemplName();
        }
        return this.pscsscattemplname;
    }

    public boolean isPSCssCatTemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCssCatTemplNameDirty();
        }
        return this.pscsscattemplnameDirtyFlag;
    }

    public void resetPSCssCatTemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCssCatTemplName();
            return;
        }
        this.pscsscattemplnameDirtyFlag = false;
        this.pscsscattemplname = null;
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
        PSCssCatTemplBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSCssCatTemplBase pSCssCatTemplBase) {
        pSCssCatTemplBase.resetCreateDate();
        pSCssCatTemplBase.resetCreateMan();
        pSCssCatTemplBase.resetMemo();
        pSCssCatTemplBase.resetPSCssCatTemplId();
        pSCssCatTemplBase.resetPSCssCatTemplName();
        pSCssCatTemplBase.resetUpdateDate();
        pSCssCatTemplBase.resetUpdateMan();
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
        if (!bl || this.isPSCssCatTemplIdDirty()) {
            hashMap.put(FIELD_PSCSSCATTEMPLID, this.getPSCssCatTemplId());
        }
        if (!bl || this.isPSCssCatTemplNameDirty()) {
            hashMap.put(FIELD_PSCSSCATTEMPLNAME, this.getPSCssCatTemplName());
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
        return PSCssCatTemplBase.get(this, n);
    }

    private static Object get(PSCssCatTemplBase pSCssCatTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCssCatTemplBase.getCreateDate();
            }
            case 1: {
                return pSCssCatTemplBase.getCreateMan();
            }
            case 2: {
                return pSCssCatTemplBase.getMemo();
            }
            case 3: {
                return pSCssCatTemplBase.getPSCssCatTemplId();
            }
            case 4: {
                return pSCssCatTemplBase.getPSCssCatTemplName();
            }
            case 5: {
                return pSCssCatTemplBase.getUpdateDate();
            }
            case 6: {
                return pSCssCatTemplBase.getUpdateMan();
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
        PSCssCatTemplBase.set(this, n, object);
    }

    private static void set(PSCssCatTemplBase pSCssCatTemplBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSCssCatTemplBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSCssCatTemplBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSCssCatTemplBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSCssCatTemplBase.setPSCssCatTemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSCssCatTemplBase.setPSCssCatTemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSCssCatTemplBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 6: {
                pSCssCatTemplBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSCssCatTemplBase.isNull(this, n);
    }

    private static boolean isNull(PSCssCatTemplBase pSCssCatTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCssCatTemplBase.getCreateDate() == null;
            }
            case 1: {
                return pSCssCatTemplBase.getCreateMan() == null;
            }
            case 2: {
                return pSCssCatTemplBase.getMemo() == null;
            }
            case 3: {
                return pSCssCatTemplBase.getPSCssCatTemplId() == null;
            }
            case 4: {
                return pSCssCatTemplBase.getPSCssCatTemplName() == null;
            }
            case 5: {
                return pSCssCatTemplBase.getUpdateDate() == null;
            }
            case 6: {
                return pSCssCatTemplBase.getUpdateMan() == null;
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
        return PSCssCatTemplBase.contains(this, n);
    }

    private static boolean contains(PSCssCatTemplBase pSCssCatTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCssCatTemplBase.isCreateDateDirty();
            }
            case 1: {
                return pSCssCatTemplBase.isCreateManDirty();
            }
            case 2: {
                return pSCssCatTemplBase.isMemoDirty();
            }
            case 3: {
                return pSCssCatTemplBase.isPSCssCatTemplIdDirty();
            }
            case 4: {
                return pSCssCatTemplBase.isPSCssCatTemplNameDirty();
            }
            case 5: {
                return pSCssCatTemplBase.isUpdateDateDirty();
            }
            case 6: {
                return pSCssCatTemplBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSCssCatTemplBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSCssCatTemplBase pSCssCatTemplBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSCssCatTemplBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSCssCatTemplBase.getJSONValue((Object)pSCssCatTemplBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSCssCatTemplBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSCssCatTemplBase.getJSONValue((Object)pSCssCatTemplBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSCssCatTemplBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSCssCatTemplBase.getJSONValue((Object)pSCssCatTemplBase.getMemo()), (boolean)false);
        }
        if (bl || pSCssCatTemplBase.getPSCssCatTemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscsscattemplid", (Object)PSCssCatTemplBase.getJSONValue((Object)pSCssCatTemplBase.getPSCssCatTemplId()), (boolean)false);
        }
        if (bl || pSCssCatTemplBase.getPSCssCatTemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscsscattemplname", (Object)PSCssCatTemplBase.getJSONValue((Object)pSCssCatTemplBase.getPSCssCatTemplName()), (boolean)false);
        }
        if (bl || pSCssCatTemplBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSCssCatTemplBase.getJSONValue((Object)pSCssCatTemplBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSCssCatTemplBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSCssCatTemplBase.getJSONValue((Object)pSCssCatTemplBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSCssCatTemplBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSCssCatTemplBase pSCssCatTemplBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSCssCatTemplBase.getCreateDate() != null) {
            object = pSCssCatTemplBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCssCatTemplBase.getCreateMan() != null) {
            object = pSCssCatTemplBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSCssCatTemplBase.getMemo() != null) {
            object = pSCssCatTemplBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSCssCatTemplBase.getPSCssCatTemplId() != null) {
            object = pSCssCatTemplBase.getPSCssCatTemplId();
            xmlNode.setAttribute(FIELD_PSCSSCATTEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSCssCatTemplBase.getPSCssCatTemplName() != null) {
            object = pSCssCatTemplBase.getPSCssCatTemplName();
            xmlNode.setAttribute(FIELD_PSCSSCATTEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCssCatTemplBase.getUpdateDate() != null) {
            object = pSCssCatTemplBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCssCatTemplBase.getUpdateMan() != null) {
            object = pSCssCatTemplBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSCssCatTemplBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSCssCatTemplBase pSCssCatTemplBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSCssCatTemplBase.isCreateDateDirty() && (bl || pSCssCatTemplBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSCssCatTemplBase.getCreateDate());
        }
        if (pSCssCatTemplBase.isCreateManDirty() && (bl || pSCssCatTemplBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSCssCatTemplBase.getCreateMan());
        }
        if (pSCssCatTemplBase.isMemoDirty() && (bl || pSCssCatTemplBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSCssCatTemplBase.getMemo());
        }
        if (pSCssCatTemplBase.isPSCssCatTemplIdDirty() && (bl || pSCssCatTemplBase.getPSCssCatTemplId() != null)) {
            iDataObject.set(FIELD_PSCSSCATTEMPLID, (Object)pSCssCatTemplBase.getPSCssCatTemplId());
        }
        if (pSCssCatTemplBase.isPSCssCatTemplNameDirty() && (bl || pSCssCatTemplBase.getPSCssCatTemplName() != null)) {
            iDataObject.set(FIELD_PSCSSCATTEMPLNAME, (Object)pSCssCatTemplBase.getPSCssCatTemplName());
        }
        if (pSCssCatTemplBase.isUpdateDateDirty() && (bl || pSCssCatTemplBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSCssCatTemplBase.getUpdateDate());
        }
        if (pSCssCatTemplBase.isUpdateManDirty() && (bl || pSCssCatTemplBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSCssCatTemplBase.getUpdateMan());
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
        return PSCssCatTemplBase.remove(this, n);
    }

    private static boolean remove(PSCssCatTemplBase pSCssCatTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSCssCatTemplBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSCssCatTemplBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSCssCatTemplBase.resetMemo();
                return true;
            }
            case 3: {
                pSCssCatTemplBase.resetPSCssCatTemplId();
                return true;
            }
            case 4: {
                pSCssCatTemplBase.resetPSCssCatTemplName();
                return true;
            }
            case 5: {
                pSCssCatTemplBase.resetUpdateDate();
                return true;
            }
            case 6: {
                pSCssCatTemplBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSCssCatTemplBase getProxyEntity() {
        return this.proxyPSCssCatTemplBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSCssCatTemplBase = null;
        if (iDataObject != null && iDataObject instanceof PSCssCatTemplBase) {
            this.proxyPSCssCatTemplBase = (PSCssCatTemplBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSCssCatTemplService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSCSSCATTEMPLID, 3);
        fieldIndexMap.put(FIELD_PSCSSCATTEMPLNAME, 4);
        fieldIndexMap.put(FIELD_UPDATEDATE, 5);
        fieldIndexMap.put(FIELD_UPDATEMAN, 6);
    }
}

