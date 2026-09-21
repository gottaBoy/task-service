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
package net.ibizsys.pscore.srv.devcenter.entity;

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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCProduct;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCSysProductBase
extends PSDCProduct {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCSysProductBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_PSDCSYSPRODUCTID = "PSDCSYSPRODUCTID";
    public static final String FIELD_PSDCSYSPRODUCTNAME = "PSDCSYSPRODUCTNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_PSDCSYSPRODUCTID = 6;
    private static final int INDEX_PSDCSYSPRODUCTNAME = 7;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCSysProductBase proxyPSDCSysProductBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean psdcsysproductidDirtyFlag = false;
    private boolean psdcsysproductnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="psdcsysproductid")
    private String psdcsysproductid;
    @Column(name="psdcsysproductname")
    private String psdcsysproductname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;

    public PSDCSysProductBase() {
        try {
            this.set("PSDCPRODUCTTYPE", "SYSTEM");
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

    public void setPSDCSysProductId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCSysProductId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcsysproductid = string;
        this.psdcsysproductidDirtyFlag = true;
        super.setPSDCProductId(string);
    }

    public String getPSDCSysProductId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCSysProductId();
        }
        return this.psdcsysproductid;
    }

    public boolean isPSDCSysProductIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCSysProductIdDirty();
        }
        return this.psdcsysproductidDirtyFlag;
    }

    public void resetPSDCSysProductId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCSysProductId();
            return;
        }
        this.psdcsysproductidDirtyFlag = false;
        this.psdcsysproductid = null;
        super.resetPSDCProductId();
    }

    public void setPSDCSysProductName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCSysProductName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcsysproductname = string;
        this.psdcsysproductnameDirtyFlag = true;
        super.setPSDCProductName(string);
    }

    public String getPSDCSysProductName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCSysProductName();
        }
        return this.psdcsysproductname;
    }

    public boolean isPSDCSysProductNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCSysProductNameDirty();
        }
        return this.psdcsysproductnameDirtyFlag;
    }

    public void resetPSDCSysProductName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCSysProductName();
            return;
        }
        this.psdcsysproductnameDirtyFlag = false;
        this.psdcsysproductname = null;
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
        PSDCSysProductBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCSysProductBase pSDCSysProductBase) {
        pSDCSysProductBase.resetCreateDate();
        pSDCSysProductBase.resetCreateMan();
        pSDCSysProductBase.resetPSDCSysProductId();
        pSDCSysProductBase.resetPSDCSysProductName();
        pSDCSysProductBase.resetUpdateDate();
        pSDCSysProductBase.resetUpdateMan();
    }

    @Override
    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isPSDCSysProductIdDirty()) {
            hashMap.put(FIELD_PSDCSYSPRODUCTID, this.getPSDCSysProductId());
        }
        if (!bl || this.isPSDCSysProductNameDirty()) {
            hashMap.put(FIELD_PSDCSYSPRODUCTNAME, this.getPSDCSysProductName());
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
        return PSDCSysProductBase.get(this, n);
    }

    private static Object get(PSDCSysProductBase pSDCSysProductBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCSysProductBase.getCreateDate();
            }
            case 1: {
                return pSDCSysProductBase.getCreateMan();
            }
            case 6: {
                return pSDCSysProductBase.getPSDCSysProductId();
            }
            case 7: {
                return pSDCSysProductBase.getPSDCSysProductName();
            }
            case 10: {
                return pSDCSysProductBase.getUpdateDate();
            }
            case 11: {
                return pSDCSysProductBase.getUpdateMan();
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
        PSDCSysProductBase.set(this, n, object);
    }

    private static void set(PSDCSysProductBase pSDCSysProductBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCSysProductBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDCSysProductBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDCSysProductBase.setPSDCSysProductId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDCSysProductBase.setPSDCSysProductName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDCSysProductBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSDCSysProductBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDCSysProductBase.isNull(this, n);
    }

    private static boolean isNull(PSDCSysProductBase pSDCSysProductBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCSysProductBase.getCreateDate() == null;
            }
            case 1: {
                return pSDCSysProductBase.getCreateMan() == null;
            }
            case 6: {
                return pSDCSysProductBase.getPSDCSysProductId() == null;
            }
            case 7: {
                return pSDCSysProductBase.getPSDCSysProductName() == null;
            }
            case 10: {
                return pSDCSysProductBase.getUpdateDate() == null;
            }
            case 11: {
                return pSDCSysProductBase.getUpdateMan() == null;
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
        return PSDCSysProductBase.contains(this, n);
    }

    private static boolean contains(PSDCSysProductBase pSDCSysProductBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCSysProductBase.isCreateDateDirty();
            }
            case 1: {
                return pSDCSysProductBase.isCreateManDirty();
            }
            case 6: {
                return pSDCSysProductBase.isPSDCSysProductIdDirty();
            }
            case 7: {
                return pSDCSysProductBase.isPSDCSysProductNameDirty();
            }
            case 10: {
                return pSDCSysProductBase.isUpdateDateDirty();
            }
            case 11: {
                return pSDCSysProductBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCSysProductBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCSysProductBase pSDCSysProductBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCSysProductBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCSysProductBase.getJSONValue((Object)pSDCSysProductBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCSysProductBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCSysProductBase.getJSONValue((Object)pSDCSysProductBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCSysProductBase.getPSDCSysProductId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcsysproductid", (Object)PSDCSysProductBase.getJSONValue((Object)pSDCSysProductBase.getPSDCSysProductId()), (boolean)false);
        }
        if (bl || pSDCSysProductBase.getPSDCSysProductName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcsysproductname", (Object)PSDCSysProductBase.getJSONValue((Object)pSDCSysProductBase.getPSDCSysProductName()), (boolean)false);
        }
        if (bl || pSDCSysProductBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCSysProductBase.getJSONValue((Object)pSDCSysProductBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCSysProductBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCSysProductBase.getJSONValue((Object)pSDCSysProductBase.getUpdateMan()), (boolean)false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCSysProductBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCSysProductBase pSDCSysProductBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCSysProductBase.getCreateDate() != null) {
            object = pSDCSysProductBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCSysProductBase.getCreateMan() != null) {
            object = pSDCSysProductBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysProductBase.getPSDCSysProductId() != null) {
            object = pSDCSysProductBase.getPSDCSysProductId();
            xmlNode.setAttribute(FIELD_PSDCSYSPRODUCTID, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysProductBase.getPSDCSysProductName() != null) {
            object = pSDCSysProductBase.getPSDCSysProductName();
            xmlNode.setAttribute(FIELD_PSDCSYSPRODUCTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysProductBase.getUpdateDate() != null) {
            object = pSDCSysProductBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCSysProductBase.getUpdateMan() != null) {
            object = pSDCSysProductBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    @Override
    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCSysProductBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCSysProductBase pSDCSysProductBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCSysProductBase.isCreateDateDirty() && (bl || pSDCSysProductBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCSysProductBase.getCreateDate());
        }
        if (pSDCSysProductBase.isCreateManDirty() && (bl || pSDCSysProductBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCSysProductBase.getCreateMan());
        }
        if (pSDCSysProductBase.isPSDCSysProductIdDirty() && (bl || pSDCSysProductBase.getPSDCSysProductId() != null)) {
            iDataObject.set(FIELD_PSDCSYSPRODUCTID, (Object)pSDCSysProductBase.getPSDCSysProductId());
        }
        if (pSDCSysProductBase.isPSDCSysProductNameDirty() && (bl || pSDCSysProductBase.getPSDCSysProductName() != null)) {
            iDataObject.set(FIELD_PSDCSYSPRODUCTNAME, (Object)pSDCSysProductBase.getPSDCSysProductName());
        }
        if (pSDCSysProductBase.isUpdateDateDirty() && (bl || pSDCSysProductBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCSysProductBase.getUpdateDate());
        }
        if (pSDCSysProductBase.isUpdateManDirty() && (bl || pSDCSysProductBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCSysProductBase.getUpdateMan());
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
        return PSDCSysProductBase.remove(this, n);
    }

    private static boolean remove(PSDCSysProductBase pSDCSysProductBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCSysProductBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDCSysProductBase.resetCreateMan();
                return true;
            }
            case 6: {
                pSDCSysProductBase.resetPSDCSysProductId();
                return true;
            }
            case 7: {
                pSDCSysProductBase.resetPSDCSysProductName();
                return true;
            }
            case 10: {
                pSDCSysProductBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSDCSysProductBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSDCSysProductBase getProxyEntity() {
        return this.proxyPSDCSysProductBase;
    }

    @Override
    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCSysProductBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCSysProductBase) {
            this.proxyPSDCSysProductBase = (PSDCSysProductBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCSysProductService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_PSDCSYSPRODUCTID, 6);
        fieldIndexMap.put(FIELD_PSDCSYSPRODUCTNAME, 7);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
    }
}

