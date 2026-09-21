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

public abstract class PSSysToolbarBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysToolbarBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSSYSTOOLBARID = "PSSYSTOOLBARID";
    public static final String FIELD_PSSYSTOOLBARNAME = "PSSYSTOOLBARNAME";
    public static final String FIELD_TBMODEL = "TBMODEL";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSSYSTOOLBARID = 3;
    private static final int INDEX_PSSYSTOOLBARNAME = 4;
    private static final int INDEX_TBMODEL = 5;
    private static final int INDEX_UPDATEDATE = 6;
    private static final int INDEX_UPDATEMAN = 7;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysToolbarBase proxyPSSysToolbarBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pssystoolbaridDirtyFlag = false;
    private boolean pssystoolbarnameDirtyFlag = false;
    private boolean tbmodelDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="pssystoolbarid")
    private String pssystoolbarid;
    @Column(name="pssystoolbarname")
    private String pssystoolbarname;
    @Column(name="tbmodel")
    private String tbmodel;
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

    public void setPSSysToolbarId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysToolbarId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystoolbarid = string;
        this.pssystoolbaridDirtyFlag = true;
    }

    public String getPSSysToolbarId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysToolbarId();
        }
        return this.pssystoolbarid;
    }

    public boolean isPSSysToolbarIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysToolbarIdDirty();
        }
        return this.pssystoolbaridDirtyFlag;
    }

    public void resetPSSysToolbarId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysToolbarId();
            return;
        }
        this.pssystoolbaridDirtyFlag = false;
        this.pssystoolbarid = null;
    }

    public void setPSSysToolbarName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysToolbarName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystoolbarname = string;
        this.pssystoolbarnameDirtyFlag = true;
    }

    public String getPSSysToolbarName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysToolbarName();
        }
        return this.pssystoolbarname;
    }

    public boolean isPSSysToolbarNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysToolbarNameDirty();
        }
        return this.pssystoolbarnameDirtyFlag;
    }

    public void resetPSSysToolbarName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysToolbarName();
            return;
        }
        this.pssystoolbarnameDirtyFlag = false;
        this.pssystoolbarname = null;
    }

    public void setTBModel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTBModel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tbmodel = string;
        this.tbmodelDirtyFlag = true;
    }

    public String getTBModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTBModel();
        }
        return this.tbmodel;
    }

    public boolean isTBModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTBModelDirty();
        }
        return this.tbmodelDirtyFlag;
    }

    public void resetTBModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTBModel();
            return;
        }
        this.tbmodelDirtyFlag = false;
        this.tbmodel = null;
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
        PSSysToolbarBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysToolbarBase pSSysToolbarBase) {
        pSSysToolbarBase.resetCreateDate();
        pSSysToolbarBase.resetCreateMan();
        pSSysToolbarBase.resetMemo();
        pSSysToolbarBase.resetPSSysToolbarId();
        pSSysToolbarBase.resetPSSysToolbarName();
        pSSysToolbarBase.resetTBModel();
        pSSysToolbarBase.resetUpdateDate();
        pSSysToolbarBase.resetUpdateMan();
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
        if (!bl || this.isPSSysToolbarIdDirty()) {
            hashMap.put(FIELD_PSSYSTOOLBARID, this.getPSSysToolbarId());
        }
        if (!bl || this.isPSSysToolbarNameDirty()) {
            hashMap.put(FIELD_PSSYSTOOLBARNAME, this.getPSSysToolbarName());
        }
        if (!bl || this.isTBModelDirty()) {
            hashMap.put(FIELD_TBMODEL, this.getTBModel());
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
        return PSSysToolbarBase.get(this, n);
    }

    private static Object get(PSSysToolbarBase pSSysToolbarBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysToolbarBase.getCreateDate();
            }
            case 1: {
                return pSSysToolbarBase.getCreateMan();
            }
            case 2: {
                return pSSysToolbarBase.getMemo();
            }
            case 3: {
                return pSSysToolbarBase.getPSSysToolbarId();
            }
            case 4: {
                return pSSysToolbarBase.getPSSysToolbarName();
            }
            case 5: {
                return pSSysToolbarBase.getTBModel();
            }
            case 6: {
                return pSSysToolbarBase.getUpdateDate();
            }
            case 7: {
                return pSSysToolbarBase.getUpdateMan();
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
        PSSysToolbarBase.set(this, n, object);
    }

    private static void set(PSSysToolbarBase pSSysToolbarBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysToolbarBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSysToolbarBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysToolbarBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysToolbarBase.setPSSysToolbarId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysToolbarBase.setPSSysToolbarName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysToolbarBase.setTBModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysToolbarBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSSysToolbarBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSSysToolbarBase.isNull(this, n);
    }

    private static boolean isNull(PSSysToolbarBase pSSysToolbarBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysToolbarBase.getCreateDate() == null;
            }
            case 1: {
                return pSSysToolbarBase.getCreateMan() == null;
            }
            case 2: {
                return pSSysToolbarBase.getMemo() == null;
            }
            case 3: {
                return pSSysToolbarBase.getPSSysToolbarId() == null;
            }
            case 4: {
                return pSSysToolbarBase.getPSSysToolbarName() == null;
            }
            case 5: {
                return pSSysToolbarBase.getTBModel() == null;
            }
            case 6: {
                return pSSysToolbarBase.getUpdateDate() == null;
            }
            case 7: {
                return pSSysToolbarBase.getUpdateMan() == null;
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
        return PSSysToolbarBase.contains(this, n);
    }

    private static boolean contains(PSSysToolbarBase pSSysToolbarBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysToolbarBase.isCreateDateDirty();
            }
            case 1: {
                return pSSysToolbarBase.isCreateManDirty();
            }
            case 2: {
                return pSSysToolbarBase.isMemoDirty();
            }
            case 3: {
                return pSSysToolbarBase.isPSSysToolbarIdDirty();
            }
            case 4: {
                return pSSysToolbarBase.isPSSysToolbarNameDirty();
            }
            case 5: {
                return pSSysToolbarBase.isTBModelDirty();
            }
            case 6: {
                return pSSysToolbarBase.isUpdateDateDirty();
            }
            case 7: {
                return pSSysToolbarBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysToolbarBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysToolbarBase pSSysToolbarBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysToolbarBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysToolbarBase.getJSONValue((Object)pSSysToolbarBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysToolbarBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysToolbarBase.getJSONValue((Object)pSSysToolbarBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysToolbarBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysToolbarBase.getJSONValue((Object)pSSysToolbarBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysToolbarBase.getPSSysToolbarId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystoolbarid", (Object)PSSysToolbarBase.getJSONValue((Object)pSSysToolbarBase.getPSSysToolbarId()), (boolean)false);
        }
        if (bl || pSSysToolbarBase.getPSSysToolbarName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystoolbarname", (Object)PSSysToolbarBase.getJSONValue((Object)pSSysToolbarBase.getPSSysToolbarName()), (boolean)false);
        }
        if (bl || pSSysToolbarBase.getTBModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tbmodel", (Object)PSSysToolbarBase.getJSONValue((Object)pSSysToolbarBase.getTBModel()), (boolean)false);
        }
        if (bl || pSSysToolbarBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysToolbarBase.getJSONValue((Object)pSSysToolbarBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysToolbarBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysToolbarBase.getJSONValue((Object)pSSysToolbarBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysToolbarBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysToolbarBase pSSysToolbarBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysToolbarBase.getCreateDate() != null) {
            object = pSSysToolbarBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysToolbarBase.getCreateMan() != null) {
            object = pSSysToolbarBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysToolbarBase.getMemo() != null) {
            object = pSSysToolbarBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysToolbarBase.getPSSysToolbarId() != null) {
            object = pSSysToolbarBase.getPSSysToolbarId();
            xmlNode.setAttribute(FIELD_PSSYSTOOLBARID, object == null ? "" : (String)object);
        }
        if (bl || pSSysToolbarBase.getPSSysToolbarName() != null) {
            object = pSSysToolbarBase.getPSSysToolbarName();
            xmlNode.setAttribute(FIELD_PSSYSTOOLBARNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysToolbarBase.getTBModel() != null) {
            object = pSSysToolbarBase.getTBModel();
            xmlNode.setAttribute(FIELD_TBMODEL, object == null ? "" : (String)object);
        }
        if (bl || pSSysToolbarBase.getUpdateDate() != null) {
            object = pSSysToolbarBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysToolbarBase.getUpdateMan() != null) {
            object = pSSysToolbarBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysToolbarBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysToolbarBase pSSysToolbarBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysToolbarBase.isCreateDateDirty() && (bl || pSSysToolbarBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysToolbarBase.getCreateDate());
        }
        if (pSSysToolbarBase.isCreateManDirty() && (bl || pSSysToolbarBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysToolbarBase.getCreateMan());
        }
        if (pSSysToolbarBase.isMemoDirty() && (bl || pSSysToolbarBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysToolbarBase.getMemo());
        }
        if (pSSysToolbarBase.isPSSysToolbarIdDirty() && (bl || pSSysToolbarBase.getPSSysToolbarId() != null)) {
            iDataObject.set(FIELD_PSSYSTOOLBARID, (Object)pSSysToolbarBase.getPSSysToolbarId());
        }
        if (pSSysToolbarBase.isPSSysToolbarNameDirty() && (bl || pSSysToolbarBase.getPSSysToolbarName() != null)) {
            iDataObject.set(FIELD_PSSYSTOOLBARNAME, (Object)pSSysToolbarBase.getPSSysToolbarName());
        }
        if (pSSysToolbarBase.isTBModelDirty() && (bl || pSSysToolbarBase.getTBModel() != null)) {
            iDataObject.set(FIELD_TBMODEL, (Object)pSSysToolbarBase.getTBModel());
        }
        if (pSSysToolbarBase.isUpdateDateDirty() && (bl || pSSysToolbarBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysToolbarBase.getUpdateDate());
        }
        if (pSSysToolbarBase.isUpdateManDirty() && (bl || pSSysToolbarBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysToolbarBase.getUpdateMan());
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
        return PSSysToolbarBase.remove(this, n);
    }

    private static boolean remove(PSSysToolbarBase pSSysToolbarBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysToolbarBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSysToolbarBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSysToolbarBase.resetMemo();
                return true;
            }
            case 3: {
                pSSysToolbarBase.resetPSSysToolbarId();
                return true;
            }
            case 4: {
                pSSysToolbarBase.resetPSSysToolbarName();
                return true;
            }
            case 5: {
                pSSysToolbarBase.resetTBModel();
                return true;
            }
            case 6: {
                pSSysToolbarBase.resetUpdateDate();
                return true;
            }
            case 7: {
                pSSysToolbarBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSSysToolbarBase getProxyEntity() {
        return this.proxyPSSysToolbarBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysToolbarBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysToolbarBase) {
            this.proxyPSSysToolbarBase = (PSSysToolbarBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysToolbarService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSSYSTOOLBARID, 3);
        fieldIndexMap.put(FIELD_PSSYSTOOLBARNAME, 4);
        fieldIndexMap.put(FIELD_TBMODEL, 5);
        fieldIndexMap.put(FIELD_UPDATEDATE, 6);
        fieldIndexMap.put(FIELD_UPDATEMAN, 7);
    }
}

