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
package net.ibizsys.pscore.srv.appdesign.entity;

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
import net.ibizsys.pscore.srv.appdesign.entity.PSAppView;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppDEViewBase
extends PSAppView {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSAppDEViewBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_PSAPPDEVIEWID = "PSAPPDEVIEWID";
    public static final String FIELD_PSAPPDEVIEWNAME = "PSAPPDEVIEWNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 7;
    private static final int INDEX_CREATEMAN = 8;
    private static final int INDEX_PSAPPDEVIEWID = 18;
    private static final int INDEX_PSAPPDEVIEWNAME = 19;
    private static final int INDEX_UPDATEDATE = 78;
    private static final int INDEX_UPDATEMAN = 79;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSAppDEViewBase proxyPSAppDEViewBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean psappdeviewidDirtyFlag = false;
    private boolean psappdeviewnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="psappdeviewid")
    private String psappdeviewid;
    @Column(name="psappdeviewname")
    private String psappdeviewname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;

    public PSAppDEViewBase() {
        try {
            this.set("PSAPPVIEWTYPE", "APPDEVIEW");
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

    public void setPSAppDEViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppDEViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappdeviewid = string;
        this.psappdeviewidDirtyFlag = true;
        super.setPSAppViewId(string);
    }

    public String getPSAppDEViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppDEViewId();
        }
        return this.psappdeviewid;
    }

    public boolean isPSAppDEViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppDEViewIdDirty();
        }
        return this.psappdeviewidDirtyFlag;
    }

    public void resetPSAppDEViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppDEViewId();
            return;
        }
        this.psappdeviewidDirtyFlag = false;
        this.psappdeviewid = null;
        super.resetPSAppViewId();
    }

    public void setPSAppDEViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppDEViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappdeviewname = string;
        this.psappdeviewnameDirtyFlag = true;
        super.setPSAppViewName(string);
    }

    public String getPSAppDEViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppDEViewName();
        }
        return this.psappdeviewname;
    }

    public boolean isPSAppDEViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppDEViewNameDirty();
        }
        return this.psappdeviewnameDirtyFlag;
    }

    public void resetPSAppDEViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppDEViewName();
            return;
        }
        this.psappdeviewnameDirtyFlag = false;
        this.psappdeviewname = null;
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
        PSAppDEViewBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSAppDEViewBase pSAppDEViewBase) {
        pSAppDEViewBase.resetCreateDate();
        pSAppDEViewBase.resetCreateMan();
        pSAppDEViewBase.resetPSAppDEViewId();
        pSAppDEViewBase.resetPSAppDEViewName();
        pSAppDEViewBase.resetUpdateDate();
        pSAppDEViewBase.resetUpdateMan();
    }

    @Override
    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isPSAppDEViewIdDirty()) {
            hashMap.put(FIELD_PSAPPDEVIEWID, this.getPSAppDEViewId());
        }
        if (!bl || this.isPSAppDEViewNameDirty()) {
            hashMap.put(FIELD_PSAPPDEVIEWNAME, this.getPSAppDEViewName());
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
        return PSAppDEViewBase.get(this, n);
    }

    private static Object get(PSAppDEViewBase pSAppDEViewBase, int n) throws Exception {
        switch (n) {
            case 7: {
                return pSAppDEViewBase.getCreateDate();
            }
            case 8: {
                return pSAppDEViewBase.getCreateMan();
            }
            case 18: {
                return pSAppDEViewBase.getPSAppDEViewId();
            }
            case 19: {
                return pSAppDEViewBase.getPSAppDEViewName();
            }
            case 78: {
                return pSAppDEViewBase.getUpdateDate();
            }
            case 79: {
                return pSAppDEViewBase.getUpdateMan();
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
        PSAppDEViewBase.set(this, n, object);
    }

    private static void set(PSAppDEViewBase pSAppDEViewBase, int n, Object object) throws Exception {
        switch (n) {
            case 7: {
                pSAppDEViewBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 8: {
                pSAppDEViewBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSAppDEViewBase.setPSAppDEViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSAppDEViewBase.setPSAppDEViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 78: {
                pSAppDEViewBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 79: {
                pSAppDEViewBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSAppDEViewBase.isNull(this, n);
    }

    private static boolean isNull(PSAppDEViewBase pSAppDEViewBase, int n) throws Exception {
        switch (n) {
            case 7: {
                return pSAppDEViewBase.getCreateDate() == null;
            }
            case 8: {
                return pSAppDEViewBase.getCreateMan() == null;
            }
            case 18: {
                return pSAppDEViewBase.getPSAppDEViewId() == null;
            }
            case 19: {
                return pSAppDEViewBase.getPSAppDEViewName() == null;
            }
            case 78: {
                return pSAppDEViewBase.getUpdateDate() == null;
            }
            case 79: {
                return pSAppDEViewBase.getUpdateMan() == null;
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
        return PSAppDEViewBase.contains(this, n);
    }

    private static boolean contains(PSAppDEViewBase pSAppDEViewBase, int n) throws Exception {
        switch (n) {
            case 7: {
                return pSAppDEViewBase.isCreateDateDirty();
            }
            case 8: {
                return pSAppDEViewBase.isCreateManDirty();
            }
            case 18: {
                return pSAppDEViewBase.isPSAppDEViewIdDirty();
            }
            case 19: {
                return pSAppDEViewBase.isPSAppDEViewNameDirty();
            }
            case 78: {
                return pSAppDEViewBase.isUpdateDateDirty();
            }
            case 79: {
                return pSAppDEViewBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSAppDEViewBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSAppDEViewBase pSAppDEViewBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSAppDEViewBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSAppDEViewBase.getJSONValue((Object)pSAppDEViewBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSAppDEViewBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSAppDEViewBase.getJSONValue((Object)pSAppDEViewBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSAppDEViewBase.getPSAppDEViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappdeviewid", (Object)PSAppDEViewBase.getJSONValue((Object)pSAppDEViewBase.getPSAppDEViewId()), (boolean)false);
        }
        if (bl || pSAppDEViewBase.getPSAppDEViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappdeviewname", (Object)PSAppDEViewBase.getJSONValue((Object)pSAppDEViewBase.getPSAppDEViewName()), (boolean)false);
        }
        if (bl || pSAppDEViewBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSAppDEViewBase.getJSONValue((Object)pSAppDEViewBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSAppDEViewBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSAppDEViewBase.getJSONValue((Object)pSAppDEViewBase.getUpdateMan()), (boolean)false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSAppDEViewBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSAppDEViewBase pSAppDEViewBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSAppDEViewBase.getCreateDate() != null) {
            object = pSAppDEViewBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppDEViewBase.getCreateMan() != null) {
            object = pSAppDEViewBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppDEViewBase.getPSAppDEViewId() != null) {
            object = pSAppDEViewBase.getPSAppDEViewId();
            xmlNode.setAttribute(FIELD_PSAPPDEVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSAppDEViewBase.getPSAppDEViewName() != null) {
            object = pSAppDEViewBase.getPSAppDEViewName();
            xmlNode.setAttribute(FIELD_PSAPPDEVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppDEViewBase.getUpdateDate() != null) {
            object = pSAppDEViewBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppDEViewBase.getUpdateMan() != null) {
            object = pSAppDEViewBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    @Override
    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSAppDEViewBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSAppDEViewBase pSAppDEViewBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSAppDEViewBase.isCreateDateDirty() && (bl || pSAppDEViewBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSAppDEViewBase.getCreateDate());
        }
        if (pSAppDEViewBase.isCreateManDirty() && (bl || pSAppDEViewBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSAppDEViewBase.getCreateMan());
        }
        if (pSAppDEViewBase.isPSAppDEViewIdDirty() && (bl || pSAppDEViewBase.getPSAppDEViewId() != null)) {
            iDataObject.set(FIELD_PSAPPDEVIEWID, (Object)pSAppDEViewBase.getPSAppDEViewId());
        }
        if (pSAppDEViewBase.isPSAppDEViewNameDirty() && (bl || pSAppDEViewBase.getPSAppDEViewName() != null)) {
            iDataObject.set(FIELD_PSAPPDEVIEWNAME, (Object)pSAppDEViewBase.getPSAppDEViewName());
        }
        if (pSAppDEViewBase.isUpdateDateDirty() && (bl || pSAppDEViewBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSAppDEViewBase.getUpdateDate());
        }
        if (pSAppDEViewBase.isUpdateManDirty() && (bl || pSAppDEViewBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSAppDEViewBase.getUpdateMan());
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
        return PSAppDEViewBase.remove(this, n);
    }

    private static boolean remove(PSAppDEViewBase pSAppDEViewBase, int n) throws Exception {
        switch (n) {
            case 7: {
                pSAppDEViewBase.resetCreateDate();
                return true;
            }
            case 8: {
                pSAppDEViewBase.resetCreateMan();
                return true;
            }
            case 18: {
                pSAppDEViewBase.resetPSAppDEViewId();
                return true;
            }
            case 19: {
                pSAppDEViewBase.resetPSAppDEViewName();
                return true;
            }
            case 78: {
                pSAppDEViewBase.resetUpdateDate();
                return true;
            }
            case 79: {
                pSAppDEViewBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSAppDEViewBase getProxyEntity() {
        return this.proxyPSAppDEViewBase;
    }

    @Override
    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSAppDEViewBase = null;
        if (iDataObject != null && iDataObject instanceof PSAppDEViewBase) {
            this.proxyPSAppDEViewBase = (PSAppDEViewBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppDEViewService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 7);
        fieldIndexMap.put(FIELD_CREATEMAN, 8);
        fieldIndexMap.put(FIELD_PSAPPDEVIEWID, 18);
        fieldIndexMap.put(FIELD_PSAPPDEVIEWNAME, 19);
        fieldIndexMap.put(FIELD_UPDATEDATE, 78);
        fieldIndexMap.put(FIELD_UPDATEMAN, 79);
    }
}

