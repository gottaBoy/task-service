/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
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
package net.ibizsys.pscore.srv.paasmgr.entity;

import java.sql.Timestamp;
import java.util.HashMap;
import javax.persistence.Column;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.paasmgr.entity.PSProduct;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysProductBase
extends PSProduct {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysProductBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_PSSYSPRODUCTID = "PSSYSPRODUCTID";
    public static final String FIELD_PSSYSPRODUCTNAME = "PSSYSPRODUCTNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_PSSYSPRODUCTID = 8;
    private static final int INDEX_PSSYSPRODUCTNAME = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysProductBase proxyPSSysProductBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean pssysproductidDirtyFlag = false;
    private boolean pssysproductnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="pssysproductid")
    private String pssysproductid;
    @Column(name="pssysproductname")
    private String pssysproductname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;

    public PSSysProductBase() {
        try {
            this.set("PSPRODUCTTYPE", "SYSTEM");
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    @Override
    public void setCreateDate(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateDate(timestamp);
            return;
        }
        this.createdate = timestamp;
        this.createdateDirtyFlag = true;
    }

    @Override
    public Timestamp getCreateDate() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreateDate();
        }
        return this.createdate;
    }

    @Override
    public boolean isCreateDateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCreateDateDirty();
        }
        return this.createdateDirtyFlag;
    }

    @Override
    public void resetCreateDate() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCreateDate();
            return;
        }
        this.createdateDirtyFlag = false;
        this.createdate = null;
    }

    @Override
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

    @Override
    public String getCreateMan() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreateMan();
        }
        return this.createman;
    }

    @Override
    public boolean isCreateManDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCreateManDirty();
        }
        return this.createmanDirtyFlag;
    }

    @Override
    public void resetCreateMan() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCreateMan();
            return;
        }
        this.createmanDirtyFlag = false;
        this.createman = null;
    }

    public void setPSSysProductId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysProductId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysproductid = string;
        this.pssysproductidDirtyFlag = true;
        super.setPSProductId(string);
    }

    public String getPSSysProductId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysProductId();
        }
        return this.pssysproductid;
    }

    public boolean isPSSysProductIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysProductIdDirty();
        }
        return this.pssysproductidDirtyFlag;
    }

    public void resetPSSysProductId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysProductId();
            return;
        }
        this.pssysproductidDirtyFlag = false;
        this.pssysproductid = null;
        super.resetPSProductId();
    }

    public void setPSSysProductName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysProductName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysproductname = string;
        this.pssysproductnameDirtyFlag = true;
        super.setPSProductName(string);
    }

    public String getPSSysProductName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysProductName();
        }
        return this.pssysproductname;
    }

    public boolean isPSSysProductNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysProductNameDirty();
        }
        return this.pssysproductnameDirtyFlag;
    }

    public void resetPSSysProductName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysProductName();
            return;
        }
        this.pssysproductnameDirtyFlag = false;
        this.pssysproductname = null;
    }

    @Override
    public void setUpdateDate(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateDate(timestamp);
            return;
        }
        this.updatedate = timestamp;
        this.updatedateDirtyFlag = true;
    }

    @Override
    public Timestamp getUpdateDate() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUpdateDate();
        }
        return this.updatedate;
    }

    @Override
    public boolean isUpdateDateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUpdateDateDirty();
        }
        return this.updatedateDirtyFlag;
    }

    @Override
    public void resetUpdateDate() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUpdateDate();
            return;
        }
        this.updatedateDirtyFlag = false;
        this.updatedate = null;
    }

    @Override
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

    @Override
    public String getUpdateMan() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUpdateMan();
        }
        return this.updateman;
    }

    @Override
    public boolean isUpdateManDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUpdateManDirty();
        }
        return this.updatemanDirtyFlag;
    }

    @Override
    public void resetUpdateMan() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUpdateMan();
            return;
        }
        this.updatemanDirtyFlag = false;
        this.updateman = null;
    }

    @Override
    protected void onReset() {
        PSSysProductBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysProductBase pSSysProductBase) {
        pSSysProductBase.resetCreateDate();
        pSSysProductBase.resetCreateMan();
        pSSysProductBase.resetPSSysProductId();
        pSSysProductBase.resetPSSysProductName();
        pSSysProductBase.resetUpdateDate();
        pSSysProductBase.resetUpdateMan();
    }

    @Override
    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isPSSysProductIdDirty()) {
            hashMap.put(FIELD_PSSYSPRODUCTID, this.getPSSysProductId());
        }
        if (!bl || this.isPSSysProductNameDirty()) {
            hashMap.put(FIELD_PSSYSPRODUCTNAME, this.getPSSysProductName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        super.onFillMap(hashMap, bl);
    }

    @Override
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
        return PSSysProductBase.get(this, n);
    }

    private static Object get(PSSysProductBase pSSysProductBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysProductBase.getCreateDate();
            }
            case 1: {
                return pSSysProductBase.getCreateMan();
            }
            case 8: {
                return pSSysProductBase.getPSSysProductId();
            }
            case 9: {
                return pSSysProductBase.getPSSysProductName();
            }
            case 10: {
                return pSSysProductBase.getUpdateDate();
            }
            case 11: {
                return pSSysProductBase.getUpdateMan();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
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
        PSSysProductBase.set(this, n, object);
    }

    private static void set(PSSysProductBase pSSysProductBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysProductBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSysProductBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysProductBase.setPSSysProductId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysProductBase.setPSSysProductName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysProductBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSSysProductBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
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
        return PSSysProductBase.isNull(this, n);
    }

    private static boolean isNull(PSSysProductBase pSSysProductBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysProductBase.getCreateDate() == null;
            }
            case 1: {
                return pSSysProductBase.getCreateMan() == null;
            }
            case 8: {
                return pSSysProductBase.getPSSysProductId() == null;
            }
            case 9: {
                return pSSysProductBase.getPSSysProductName() == null;
            }
            case 10: {
                return pSSysProductBase.getUpdateDate() == null;
            }
            case 11: {
                return pSSysProductBase.getUpdateMan() == null;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
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
        return PSSysProductBase.contains(this, n);
    }

    private static boolean contains(PSSysProductBase pSSysProductBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysProductBase.isCreateDateDirty();
            }
            case 1: {
                return pSSysProductBase.isCreateManDirty();
            }
            case 8: {
                return pSSysProductBase.isPSSysProductIdDirty();
            }
            case 9: {
                return pSSysProductBase.isPSSysProductNameDirty();
            }
            case 10: {
                return pSSysProductBase.isUpdateDateDirty();
            }
            case 11: {
                return pSSysProductBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysProductBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysProductBase pSSysProductBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysProductBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysProductBase.getJSONValue((Object)pSSysProductBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysProductBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysProductBase.getJSONValue((Object)pSSysProductBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysProductBase.getPSSysProductId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysproductid", (Object)PSSysProductBase.getJSONValue((Object)pSSysProductBase.getPSSysProductId()), (boolean)false);
        }
        if (bl || pSSysProductBase.getPSSysProductName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysproductname", (Object)PSSysProductBase.getJSONValue((Object)pSSysProductBase.getPSSysProductName()), (boolean)false);
        }
        if (bl || pSSysProductBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysProductBase.getJSONValue((Object)pSSysProductBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysProductBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysProductBase.getJSONValue((Object)pSSysProductBase.getUpdateMan()), (boolean)false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysProductBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysProductBase pSSysProductBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysProductBase.getCreateDate() != null) {
            object = pSSysProductBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysProductBase.getCreateMan() != null) {
            object = pSSysProductBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysProductBase.getPSSysProductId() != null) {
            object = pSSysProductBase.getPSSysProductId();
            xmlNode.setAttribute(FIELD_PSSYSPRODUCTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysProductBase.getPSSysProductName() != null) {
            object = pSSysProductBase.getPSSysProductName();
            xmlNode.setAttribute(FIELD_PSSYSPRODUCTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysProductBase.getUpdateDate() != null) {
            object = pSSysProductBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysProductBase.getUpdateMan() != null) {
            object = pSSysProductBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    @Override
    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysProductBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysProductBase pSSysProductBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysProductBase.isCreateDateDirty() && (bl || pSSysProductBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysProductBase.getCreateDate());
        }
        if (pSSysProductBase.isCreateManDirty() && (bl || pSSysProductBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysProductBase.getCreateMan());
        }
        if (pSSysProductBase.isPSSysProductIdDirty() && (bl || pSSysProductBase.getPSSysProductId() != null)) {
            iDataObject.set(FIELD_PSSYSPRODUCTID, (Object)pSSysProductBase.getPSSysProductId());
        }
        if (pSSysProductBase.isPSSysProductNameDirty() && (bl || pSSysProductBase.getPSSysProductName() != null)) {
            iDataObject.set(FIELD_PSSYSPRODUCTNAME, (Object)pSSysProductBase.getPSSysProductName());
        }
        if (pSSysProductBase.isUpdateDateDirty() && (bl || pSSysProductBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysProductBase.getUpdateDate());
        }
        if (pSSysProductBase.isUpdateManDirty() && (bl || pSSysProductBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysProductBase.getUpdateMan());
        }
    }

    @Override
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
        return PSSysProductBase.remove(this, n);
    }

    private static boolean remove(PSSysProductBase pSSysProductBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysProductBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSysProductBase.resetCreateMan();
                return true;
            }
            case 8: {
                pSSysProductBase.resetPSSysProductId();
                return true;
            }
            case 9: {
                pSSysProductBase.resetPSSysProductName();
                return true;
            }
            case 10: {
                pSSysProductBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSSysProductBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSSysProductBase getProxyEntity() {
        return this.proxyPSSysProductBase;
    }

    @Override
    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysProductBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysProductBase) {
            this.proxyPSSysProductBase = (PSSysProductBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSSysProductService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_PSSYSPRODUCTID, 8);
        fieldIndexMap.put(FIELD_PSSYSPRODUCTNAME, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
    }
}

