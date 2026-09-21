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
package net.ibizsys.pscore.srv.dedesign.entity;

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

public abstract class PSDEDBObjSqlBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEDBObjSqlBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_PSDEDBOBJSQLID = "PSDEDBOBJSQLID";
    public static final String FIELD_PSDEDBOBJSQLNAME = "PSDEDBOBJSQLNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_PSDEDBOBJSQLID = 2;
    private static final int INDEX_PSDEDBOBJSQLNAME = 3;
    private static final int INDEX_UPDATEDATE = 4;
    private static final int INDEX_UPDATEMAN = 5;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEDBObjSqlBase proxyPSDEDBObjSqlBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean psdedbobjsqlidDirtyFlag = false;
    private boolean psdedbobjsqlnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="psdedbobjsqlid")
    private String psdedbobjsqlid;
    @Column(name="psdedbobjsqlname")
    private String psdedbobjsqlname;
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

    public void setPSDEDBObjSqlId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDBObjSqlId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedbobjsqlid = string;
        this.psdedbobjsqlidDirtyFlag = true;
    }

    public String getPSDEDBObjSqlId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDBObjSqlId();
        }
        return this.psdedbobjsqlid;
    }

    public boolean isPSDEDBObjSqlIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDBObjSqlIdDirty();
        }
        return this.psdedbobjsqlidDirtyFlag;
    }

    public void resetPSDEDBObjSqlId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDBObjSqlId();
            return;
        }
        this.psdedbobjsqlidDirtyFlag = false;
        this.psdedbobjsqlid = null;
    }

    public void setPSDEDBObjSqlName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDBObjSqlName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedbobjsqlname = string;
        this.psdedbobjsqlnameDirtyFlag = true;
    }

    public String getPSDEDBObjSqlName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDBObjSqlName();
        }
        return this.psdedbobjsqlname;
    }

    public boolean isPSDEDBObjSqlNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDBObjSqlNameDirty();
        }
        return this.psdedbobjsqlnameDirtyFlag;
    }

    public void resetPSDEDBObjSqlName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDBObjSqlName();
            return;
        }
        this.psdedbobjsqlnameDirtyFlag = false;
        this.psdedbobjsqlname = null;
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
        PSDEDBObjSqlBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEDBObjSqlBase pSDEDBObjSqlBase) {
        pSDEDBObjSqlBase.resetCreateDate();
        pSDEDBObjSqlBase.resetCreateMan();
        pSDEDBObjSqlBase.resetPSDEDBObjSqlId();
        pSDEDBObjSqlBase.resetPSDEDBObjSqlName();
        pSDEDBObjSqlBase.resetUpdateDate();
        pSDEDBObjSqlBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isPSDEDBObjSqlIdDirty()) {
            hashMap.put(FIELD_PSDEDBOBJSQLID, this.getPSDEDBObjSqlId());
        }
        if (!bl || this.isPSDEDBObjSqlNameDirty()) {
            hashMap.put(FIELD_PSDEDBOBJSQLNAME, this.getPSDEDBObjSqlName());
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
        return PSDEDBObjSqlBase.get(this, n);
    }

    private static Object get(PSDEDBObjSqlBase pSDEDBObjSqlBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDBObjSqlBase.getCreateDate();
            }
            case 1: {
                return pSDEDBObjSqlBase.getCreateMan();
            }
            case 2: {
                return pSDEDBObjSqlBase.getPSDEDBObjSqlId();
            }
            case 3: {
                return pSDEDBObjSqlBase.getPSDEDBObjSqlName();
            }
            case 4: {
                return pSDEDBObjSqlBase.getUpdateDate();
            }
            case 5: {
                return pSDEDBObjSqlBase.getUpdateMan();
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
        PSDEDBObjSqlBase.set(this, n, object);
    }

    private static void set(PSDEDBObjSqlBase pSDEDBObjSqlBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEDBObjSqlBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDEDBObjSqlBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEDBObjSqlBase.setPSDEDBObjSqlId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEDBObjSqlBase.setPSDEDBObjSqlName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEDBObjSqlBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 5: {
                pSDEDBObjSqlBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDEDBObjSqlBase.isNull(this, n);
    }

    private static boolean isNull(PSDEDBObjSqlBase pSDEDBObjSqlBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDBObjSqlBase.getCreateDate() == null;
            }
            case 1: {
                return pSDEDBObjSqlBase.getCreateMan() == null;
            }
            case 2: {
                return pSDEDBObjSqlBase.getPSDEDBObjSqlId() == null;
            }
            case 3: {
                return pSDEDBObjSqlBase.getPSDEDBObjSqlName() == null;
            }
            case 4: {
                return pSDEDBObjSqlBase.getUpdateDate() == null;
            }
            case 5: {
                return pSDEDBObjSqlBase.getUpdateMan() == null;
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
        return PSDEDBObjSqlBase.contains(this, n);
    }

    private static boolean contains(PSDEDBObjSqlBase pSDEDBObjSqlBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDBObjSqlBase.isCreateDateDirty();
            }
            case 1: {
                return pSDEDBObjSqlBase.isCreateManDirty();
            }
            case 2: {
                return pSDEDBObjSqlBase.isPSDEDBObjSqlIdDirty();
            }
            case 3: {
                return pSDEDBObjSqlBase.isPSDEDBObjSqlNameDirty();
            }
            case 4: {
                return pSDEDBObjSqlBase.isUpdateDateDirty();
            }
            case 5: {
                return pSDEDBObjSqlBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEDBObjSqlBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEDBObjSqlBase pSDEDBObjSqlBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEDBObjSqlBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEDBObjSqlBase.getJSONValue((Object)pSDEDBObjSqlBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEDBObjSqlBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEDBObjSqlBase.getJSONValue((Object)pSDEDBObjSqlBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEDBObjSqlBase.getPSDEDBObjSqlId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedbobjsqlid", (Object)PSDEDBObjSqlBase.getJSONValue((Object)pSDEDBObjSqlBase.getPSDEDBObjSqlId()), (boolean)false);
        }
        if (bl || pSDEDBObjSqlBase.getPSDEDBObjSqlName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedbobjsqlname", (Object)PSDEDBObjSqlBase.getJSONValue((Object)pSDEDBObjSqlBase.getPSDEDBObjSqlName()), (boolean)false);
        }
        if (bl || pSDEDBObjSqlBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEDBObjSqlBase.getJSONValue((Object)pSDEDBObjSqlBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEDBObjSqlBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEDBObjSqlBase.getJSONValue((Object)pSDEDBObjSqlBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEDBObjSqlBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEDBObjSqlBase pSDEDBObjSqlBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEDBObjSqlBase.getCreateDate() != null) {
            object = pSDEDBObjSqlBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEDBObjSqlBase.getCreateMan() != null) {
            object = pSDEDBObjSqlBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEDBObjSqlBase.getPSDEDBObjSqlId() != null) {
            object = pSDEDBObjSqlBase.getPSDEDBObjSqlId();
            xmlNode.setAttribute(FIELD_PSDEDBOBJSQLID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDBObjSqlBase.getPSDEDBObjSqlName() != null) {
            object = pSDEDBObjSqlBase.getPSDEDBObjSqlName();
            xmlNode.setAttribute(FIELD_PSDEDBOBJSQLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDBObjSqlBase.getUpdateDate() != null) {
            object = pSDEDBObjSqlBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEDBObjSqlBase.getUpdateMan() != null) {
            object = pSDEDBObjSqlBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEDBObjSqlBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEDBObjSqlBase pSDEDBObjSqlBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEDBObjSqlBase.isCreateDateDirty() && (bl || pSDEDBObjSqlBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEDBObjSqlBase.getCreateDate());
        }
        if (pSDEDBObjSqlBase.isCreateManDirty() && (bl || pSDEDBObjSqlBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEDBObjSqlBase.getCreateMan());
        }
        if (pSDEDBObjSqlBase.isPSDEDBObjSqlIdDirty() && (bl || pSDEDBObjSqlBase.getPSDEDBObjSqlId() != null)) {
            iDataObject.set(FIELD_PSDEDBOBJSQLID, (Object)pSDEDBObjSqlBase.getPSDEDBObjSqlId());
        }
        if (pSDEDBObjSqlBase.isPSDEDBObjSqlNameDirty() && (bl || pSDEDBObjSqlBase.getPSDEDBObjSqlName() != null)) {
            iDataObject.set(FIELD_PSDEDBOBJSQLNAME, (Object)pSDEDBObjSqlBase.getPSDEDBObjSqlName());
        }
        if (pSDEDBObjSqlBase.isUpdateDateDirty() && (bl || pSDEDBObjSqlBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEDBObjSqlBase.getUpdateDate());
        }
        if (pSDEDBObjSqlBase.isUpdateManDirty() && (bl || pSDEDBObjSqlBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEDBObjSqlBase.getUpdateMan());
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
        return PSDEDBObjSqlBase.remove(this, n);
    }

    private static boolean remove(PSDEDBObjSqlBase pSDEDBObjSqlBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEDBObjSqlBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDEDBObjSqlBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDEDBObjSqlBase.resetPSDEDBObjSqlId();
                return true;
            }
            case 3: {
                pSDEDBObjSqlBase.resetPSDEDBObjSqlName();
                return true;
            }
            case 4: {
                pSDEDBObjSqlBase.resetUpdateDate();
                return true;
            }
            case 5: {
                pSDEDBObjSqlBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSDEDBObjSqlBase getProxyEntity() {
        return this.proxyPSDEDBObjSqlBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEDBObjSqlBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEDBObjSqlBase) {
            this.proxyPSDEDBObjSqlBase = (PSDEDBObjSqlBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDBObjSqlService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_PSDEDBOBJSQLID, 2);
        fieldIndexMap.put(FIELD_PSDEDBOBJSQLNAME, 3);
        fieldIndexMap.put(FIELD_UPDATEDATE, 4);
        fieldIndexMap.put(FIELD_UPDATEMAN, 5);
    }
}

