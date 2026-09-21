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
package net.ibizsys.pscore.srv.wfplatform.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
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
import net.ibizsys.pscore.srv.wfplatform.entity.PSWPAppEntity;
import net.ibizsys.pscore.srv.wfplatform.entity.PSWPAppInst;
import net.ibizsys.pscore.srv.wfplatform.service.PSWPAppEntityService;
import net.ibizsys.pscore.srv.wfplatform.service.PSWPAppInstService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSWPAppBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSWPAppBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_PSWPAPPID = "PSWPAPPID";
    public static final String FIELD_PSWPAPPNAME = "PSWPAPPNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_PSWPAPPID = 2;
    private static final int INDEX_PSWPAPPNAME = 3;
    private static final int INDEX_UPDATEDATE = 4;
    private static final int INDEX_UPDATEMAN = 5;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSWPAppBase proxyPSWPAppBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean pswpappidDirtyFlag = false;
    private boolean pswpappnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="pswpappid")
    private String pswpappid;
    @Column(name="pswpappname")
    private String pswpappname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSWPAppEntityLock = new Integer(1);
    private ArrayList<PSWPAppEntity> pswpappentity = null;
    private Integer objPSWPAppInstsLock = new Integer(1);
    private ArrayList<PSWPAppInst> pswpappinsts = null;

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

    public void setPSWPAppId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWPAppId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswpappid = string;
        this.pswpappidDirtyFlag = true;
    }

    public String getPSWPAppId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWPAppId();
        }
        return this.pswpappid;
    }

    public boolean isPSWPAppIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWPAppIdDirty();
        }
        return this.pswpappidDirtyFlag;
    }

    public void resetPSWPAppId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWPAppId();
            return;
        }
        this.pswpappidDirtyFlag = false;
        this.pswpappid = null;
    }

    public void setPSWPAppName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWPAppName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswpappname = string;
        this.pswpappnameDirtyFlag = true;
    }

    public String getPSWPAppName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWPAppName();
        }
        return this.pswpappname;
    }

    public boolean isPSWPAppNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWPAppNameDirty();
        }
        return this.pswpappnameDirtyFlag;
    }

    public void resetPSWPAppName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWPAppName();
            return;
        }
        this.pswpappnameDirtyFlag = false;
        this.pswpappname = null;
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
        PSWPAppBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSWPAppBase pSWPAppBase) {
        pSWPAppBase.resetCreateDate();
        pSWPAppBase.resetCreateMan();
        pSWPAppBase.resetPSWPAppId();
        pSWPAppBase.resetPSWPAppName();
        pSWPAppBase.resetUpdateDate();
        pSWPAppBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isPSWPAppIdDirty()) {
            hashMap.put(FIELD_PSWPAPPID, this.getPSWPAppId());
        }
        if (!bl || this.isPSWPAppNameDirty()) {
            hashMap.put(FIELD_PSWPAPPNAME, this.getPSWPAppName());
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
        return PSWPAppBase.get(this, n);
    }

    private static Object get(PSWPAppBase pSWPAppBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWPAppBase.getCreateDate();
            }
            case 1: {
                return pSWPAppBase.getCreateMan();
            }
            case 2: {
                return pSWPAppBase.getPSWPAppId();
            }
            case 3: {
                return pSWPAppBase.getPSWPAppName();
            }
            case 4: {
                return pSWPAppBase.getUpdateDate();
            }
            case 5: {
                return pSWPAppBase.getUpdateMan();
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
        PSWPAppBase.set(this, n, object);
    }

    private static void set(PSWPAppBase pSWPAppBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSWPAppBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSWPAppBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSWPAppBase.setPSWPAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSWPAppBase.setPSWPAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSWPAppBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 5: {
                pSWPAppBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSWPAppBase.isNull(this, n);
    }

    private static boolean isNull(PSWPAppBase pSWPAppBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWPAppBase.getCreateDate() == null;
            }
            case 1: {
                return pSWPAppBase.getCreateMan() == null;
            }
            case 2: {
                return pSWPAppBase.getPSWPAppId() == null;
            }
            case 3: {
                return pSWPAppBase.getPSWPAppName() == null;
            }
            case 4: {
                return pSWPAppBase.getUpdateDate() == null;
            }
            case 5: {
                return pSWPAppBase.getUpdateMan() == null;
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
        return PSWPAppBase.contains(this, n);
    }

    private static boolean contains(PSWPAppBase pSWPAppBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWPAppBase.isCreateDateDirty();
            }
            case 1: {
                return pSWPAppBase.isCreateManDirty();
            }
            case 2: {
                return pSWPAppBase.isPSWPAppIdDirty();
            }
            case 3: {
                return pSWPAppBase.isPSWPAppNameDirty();
            }
            case 4: {
                return pSWPAppBase.isUpdateDateDirty();
            }
            case 5: {
                return pSWPAppBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSWPAppBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSWPAppBase pSWPAppBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSWPAppBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSWPAppBase.getJSONValue((Object)pSWPAppBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSWPAppBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSWPAppBase.getJSONValue((Object)pSWPAppBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSWPAppBase.getPSWPAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswpappid", (Object)PSWPAppBase.getJSONValue((Object)pSWPAppBase.getPSWPAppId()), (boolean)false);
        }
        if (bl || pSWPAppBase.getPSWPAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswpappname", (Object)PSWPAppBase.getJSONValue((Object)pSWPAppBase.getPSWPAppName()), (boolean)false);
        }
        if (bl || pSWPAppBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSWPAppBase.getJSONValue((Object)pSWPAppBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSWPAppBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSWPAppBase.getJSONValue((Object)pSWPAppBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSWPAppBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSWPAppBase pSWPAppBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSWPAppBase.getCreateDate() != null) {
            object = pSWPAppBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWPAppBase.getCreateMan() != null) {
            object = pSWPAppBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSWPAppBase.getPSWPAppId() != null) {
            object = pSWPAppBase.getPSWPAppId();
            xmlNode.setAttribute(FIELD_PSWPAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSWPAppBase.getPSWPAppName() != null) {
            object = pSWPAppBase.getPSWPAppName();
            xmlNode.setAttribute(FIELD_PSWPAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWPAppBase.getUpdateDate() != null) {
            object = pSWPAppBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWPAppBase.getUpdateMan() != null) {
            object = pSWPAppBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSWPAppBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSWPAppBase pSWPAppBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSWPAppBase.isCreateDateDirty() && (bl || pSWPAppBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSWPAppBase.getCreateDate());
        }
        if (pSWPAppBase.isCreateManDirty() && (bl || pSWPAppBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSWPAppBase.getCreateMan());
        }
        if (pSWPAppBase.isPSWPAppIdDirty() && (bl || pSWPAppBase.getPSWPAppId() != null)) {
            iDataObject.set(FIELD_PSWPAPPID, (Object)pSWPAppBase.getPSWPAppId());
        }
        if (pSWPAppBase.isPSWPAppNameDirty() && (bl || pSWPAppBase.getPSWPAppName() != null)) {
            iDataObject.set(FIELD_PSWPAPPNAME, (Object)pSWPAppBase.getPSWPAppName());
        }
        if (pSWPAppBase.isUpdateDateDirty() && (bl || pSWPAppBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSWPAppBase.getUpdateDate());
        }
        if (pSWPAppBase.isUpdateManDirty() && (bl || pSWPAppBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSWPAppBase.getUpdateMan());
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
        return PSWPAppBase.remove(this, n);
    }

    private static boolean remove(PSWPAppBase pSWPAppBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSWPAppBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSWPAppBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSWPAppBase.resetPSWPAppId();
                return true;
            }
            case 3: {
                pSWPAppBase.resetPSWPAppName();
                return true;
            }
            case 4: {
                pSWPAppBase.resetUpdateDate();
                return true;
            }
            case 5: {
                pSWPAppBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSWPAppEntity> getPSWPAppEntity() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWPAppEntity();
        }
        if (this.getPSWPAppId() == null) {
            return null;
        }
        PSWPAppEntityService pSWPAppEntityService = (PSWPAppEntityService)ServiceGlobal.getService(PSWPAppEntityService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSWPAppEntityLock;
        synchronized (n) {
            if (this.pswpappentity == null) {
                this.pswpappentity = pSWPAppEntityService.selectByPSWPApp(this);
            }
            return this.pswpappentity;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSWPAppInst> getPSWPAppInsts() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWPAppInsts();
        }
        if (this.getPSWPAppId() == null) {
            return null;
        }
        PSWPAppInstService pSWPAppInstService = (PSWPAppInstService)ServiceGlobal.getService(PSWPAppInstService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSWPAppInstsLock;
        synchronized (n) {
            if (this.pswpappinsts == null) {
                this.pswpappinsts = pSWPAppInstService.selectByPSWPApp(this);
            }
            return this.pswpappinsts;
        }
    }

    private PSWPAppBase getProxyEntity() {
        return this.proxyPSWPAppBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSWPAppBase = null;
        if (iDataObject != null && iDataObject instanceof PSWPAppBase) {
            this.proxyPSWPAppBase = (PSWPAppBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfplatform.service.PSWPAppService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_PSWPAPPID, 2);
        fieldIndexMap.put(FIELD_PSWPAPPNAME, 3);
        fieldIndexMap.put(FIELD_UPDATEDATE, 4);
        fieldIndexMap.put(FIELD_UPDATEMAN, 5);
    }
}

