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

public abstract class PSAppDynaDEViewBase
extends PSAppView {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSAppDynaDEViewBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_PSAPPDYNADEVIEWID = "PSAPPDYNADEVIEWID";
    public static final String FIELD_PSAPPDYNADEVIEWNAME = "PSAPPDYNADEVIEWNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 7;
    private static final int INDEX_CREATEMAN = 8;
    private static final int INDEX_PSAPPDYNADEVIEWID = 18;
    private static final int INDEX_PSAPPDYNADEVIEWNAME = 19;
    private static final int INDEX_UPDATEDATE = 76;
    private static final int INDEX_UPDATEMAN = 77;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSAppDynaDEViewBase proxyPSAppDynaDEViewBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean psappdynadeviewidDirtyFlag = false;
    private boolean psappdynadeviewnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="psappdynadeviewid")
    private String psappdynadeviewid;
    @Column(name="psappdynadeviewname")
    private String psappdynadeviewname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;

    public PSAppDynaDEViewBase() {
        try {
            this.set("PSAPPVIEWTYPE", "APPDYNADEVIEW");
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

    public void setPSAppDynaDEViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppDynaDEViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappdynadeviewid = string;
        this.psappdynadeviewidDirtyFlag = true;
        super.setPSAppViewId(string);
    }

    public String getPSAppDynaDEViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppDynaDEViewId();
        }
        return this.psappdynadeviewid;
    }

    public boolean isPSAppDynaDEViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppDynaDEViewIdDirty();
        }
        return this.psappdynadeviewidDirtyFlag;
    }

    public void resetPSAppDynaDEViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppDynaDEViewId();
            return;
        }
        this.psappdynadeviewidDirtyFlag = false;
        this.psappdynadeviewid = null;
        super.resetPSAppViewId();
    }

    public void setPSAppDynaDEViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppDynaDEViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappdynadeviewname = string;
        this.psappdynadeviewnameDirtyFlag = true;
        super.setPSAppViewName(string);
    }

    public String getPSAppDynaDEViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppDynaDEViewName();
        }
        return this.psappdynadeviewname;
    }

    public boolean isPSAppDynaDEViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppDynaDEViewNameDirty();
        }
        return this.psappdynadeviewnameDirtyFlag;
    }

    public void resetPSAppDynaDEViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppDynaDEViewName();
            return;
        }
        this.psappdynadeviewnameDirtyFlag = false;
        this.psappdynadeviewname = null;
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
        PSAppDynaDEViewBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSAppDynaDEViewBase pSAppDynaDEViewBase) {
        pSAppDynaDEViewBase.resetCreateDate();
        pSAppDynaDEViewBase.resetCreateMan();
        pSAppDynaDEViewBase.resetPSAppDynaDEViewId();
        pSAppDynaDEViewBase.resetPSAppDynaDEViewName();
        pSAppDynaDEViewBase.resetUpdateDate();
        pSAppDynaDEViewBase.resetUpdateMan();
    }

    @Override
    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isPSAppDynaDEViewIdDirty()) {
            hashMap.put(FIELD_PSAPPDYNADEVIEWID, this.getPSAppDynaDEViewId());
        }
        if (!bl || this.isPSAppDynaDEViewNameDirty()) {
            hashMap.put(FIELD_PSAPPDYNADEVIEWNAME, this.getPSAppDynaDEViewName());
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
        return PSAppDynaDEViewBase.get(this, n);
    }

    private static Object get(PSAppDynaDEViewBase pSAppDynaDEViewBase, int n) throws Exception {
        switch (n) {
            case 7: {
                return pSAppDynaDEViewBase.getCreateDate();
            }
            case 8: {
                return pSAppDynaDEViewBase.getCreateMan();
            }
            case 18: {
                return pSAppDynaDEViewBase.getPSAppDynaDEViewId();
            }
            case 19: {
                return pSAppDynaDEViewBase.getPSAppDynaDEViewName();
            }
            case 76: {
                return pSAppDynaDEViewBase.getUpdateDate();
            }
            case 77: {
                return pSAppDynaDEViewBase.getUpdateMan();
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
        PSAppDynaDEViewBase.set(this, n, object);
    }

    private static void set(PSAppDynaDEViewBase pSAppDynaDEViewBase, int n, Object object) throws Exception {
        switch (n) {
            case 7: {
                pSAppDynaDEViewBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 8: {
                pSAppDynaDEViewBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSAppDynaDEViewBase.setPSAppDynaDEViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSAppDynaDEViewBase.setPSAppDynaDEViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 76: {
                pSAppDynaDEViewBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 77: {
                pSAppDynaDEViewBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSAppDynaDEViewBase.isNull(this, n);
    }

    private static boolean isNull(PSAppDynaDEViewBase pSAppDynaDEViewBase, int n) throws Exception {
        switch (n) {
            case 7: {
                return pSAppDynaDEViewBase.getCreateDate() == null;
            }
            case 8: {
                return pSAppDynaDEViewBase.getCreateMan() == null;
            }
            case 18: {
                return pSAppDynaDEViewBase.getPSAppDynaDEViewId() == null;
            }
            case 19: {
                return pSAppDynaDEViewBase.getPSAppDynaDEViewName() == null;
            }
            case 76: {
                return pSAppDynaDEViewBase.getUpdateDate() == null;
            }
            case 77: {
                return pSAppDynaDEViewBase.getUpdateMan() == null;
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
        return PSAppDynaDEViewBase.contains(this, n);
    }

    private static boolean contains(PSAppDynaDEViewBase pSAppDynaDEViewBase, int n) throws Exception {
        switch (n) {
            case 7: {
                return pSAppDynaDEViewBase.isCreateDateDirty();
            }
            case 8: {
                return pSAppDynaDEViewBase.isCreateManDirty();
            }
            case 18: {
                return pSAppDynaDEViewBase.isPSAppDynaDEViewIdDirty();
            }
            case 19: {
                return pSAppDynaDEViewBase.isPSAppDynaDEViewNameDirty();
            }
            case 76: {
                return pSAppDynaDEViewBase.isUpdateDateDirty();
            }
            case 77: {
                return pSAppDynaDEViewBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSAppDynaDEViewBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSAppDynaDEViewBase pSAppDynaDEViewBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSAppDynaDEViewBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSAppDynaDEViewBase.getJSONValue((Object)pSAppDynaDEViewBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSAppDynaDEViewBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSAppDynaDEViewBase.getJSONValue((Object)pSAppDynaDEViewBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSAppDynaDEViewBase.getPSAppDynaDEViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappdynadeviewid", (Object)PSAppDynaDEViewBase.getJSONValue((Object)pSAppDynaDEViewBase.getPSAppDynaDEViewId()), (boolean)false);
        }
        if (bl || pSAppDynaDEViewBase.getPSAppDynaDEViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappdynadeviewname", (Object)PSAppDynaDEViewBase.getJSONValue((Object)pSAppDynaDEViewBase.getPSAppDynaDEViewName()), (boolean)false);
        }
        if (bl || pSAppDynaDEViewBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSAppDynaDEViewBase.getJSONValue((Object)pSAppDynaDEViewBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSAppDynaDEViewBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSAppDynaDEViewBase.getJSONValue((Object)pSAppDynaDEViewBase.getUpdateMan()), (boolean)false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSAppDynaDEViewBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSAppDynaDEViewBase pSAppDynaDEViewBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSAppDynaDEViewBase.getCreateDate() != null) {
            object = pSAppDynaDEViewBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppDynaDEViewBase.getCreateMan() != null) {
            object = pSAppDynaDEViewBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppDynaDEViewBase.getPSAppDynaDEViewId() != null) {
            object = pSAppDynaDEViewBase.getPSAppDynaDEViewId();
            xmlNode.setAttribute(FIELD_PSAPPDYNADEVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSAppDynaDEViewBase.getPSAppDynaDEViewName() != null) {
            object = pSAppDynaDEViewBase.getPSAppDynaDEViewName();
            xmlNode.setAttribute(FIELD_PSAPPDYNADEVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppDynaDEViewBase.getUpdateDate() != null) {
            object = pSAppDynaDEViewBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppDynaDEViewBase.getUpdateMan() != null) {
            object = pSAppDynaDEViewBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    @Override
    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSAppDynaDEViewBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSAppDynaDEViewBase pSAppDynaDEViewBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSAppDynaDEViewBase.isCreateDateDirty() && (bl || pSAppDynaDEViewBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSAppDynaDEViewBase.getCreateDate());
        }
        if (pSAppDynaDEViewBase.isCreateManDirty() && (bl || pSAppDynaDEViewBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSAppDynaDEViewBase.getCreateMan());
        }
        if (pSAppDynaDEViewBase.isPSAppDynaDEViewIdDirty() && (bl || pSAppDynaDEViewBase.getPSAppDynaDEViewId() != null)) {
            iDataObject.set(FIELD_PSAPPDYNADEVIEWID, (Object)pSAppDynaDEViewBase.getPSAppDynaDEViewId());
        }
        if (pSAppDynaDEViewBase.isPSAppDynaDEViewNameDirty() && (bl || pSAppDynaDEViewBase.getPSAppDynaDEViewName() != null)) {
            iDataObject.set(FIELD_PSAPPDYNADEVIEWNAME, (Object)pSAppDynaDEViewBase.getPSAppDynaDEViewName());
        }
        if (pSAppDynaDEViewBase.isUpdateDateDirty() && (bl || pSAppDynaDEViewBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSAppDynaDEViewBase.getUpdateDate());
        }
        if (pSAppDynaDEViewBase.isUpdateManDirty() && (bl || pSAppDynaDEViewBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSAppDynaDEViewBase.getUpdateMan());
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
        return PSAppDynaDEViewBase.remove(this, n);
    }

    private static boolean remove(PSAppDynaDEViewBase pSAppDynaDEViewBase, int n) throws Exception {
        switch (n) {
            case 7: {
                pSAppDynaDEViewBase.resetCreateDate();
                return true;
            }
            case 8: {
                pSAppDynaDEViewBase.resetCreateMan();
                return true;
            }
            case 18: {
                pSAppDynaDEViewBase.resetPSAppDynaDEViewId();
                return true;
            }
            case 19: {
                pSAppDynaDEViewBase.resetPSAppDynaDEViewName();
                return true;
            }
            case 76: {
                pSAppDynaDEViewBase.resetUpdateDate();
                return true;
            }
            case 77: {
                pSAppDynaDEViewBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSAppDynaDEViewBase getProxyEntity() {
        return this.proxyPSAppDynaDEViewBase;
    }

    @Override
    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSAppDynaDEViewBase = null;
        if (iDataObject != null && iDataObject instanceof PSAppDynaDEViewBase) {
            this.proxyPSAppDynaDEViewBase = (PSAppDynaDEViewBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppDynaDEViewService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 7);
        fieldIndexMap.put(FIELD_CREATEMAN, 8);
        fieldIndexMap.put(FIELD_PSAPPDYNADEVIEWID, 18);
        fieldIndexMap.put(FIELD_PSAPPDYNADEVIEWNAME, 19);
        fieldIndexMap.put(FIELD_UPDATEDATE, 76);
        fieldIndexMap.put(FIELD_UPDATEMAN, 77);
    }
}

