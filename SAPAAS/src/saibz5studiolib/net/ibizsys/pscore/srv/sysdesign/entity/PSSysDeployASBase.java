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
package net.ibizsys.pscore.srv.sysdesign.entity;

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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDeploy;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDeployService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysDeployASBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysDeployASBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_PSSYSDEPLOYASID = "PSSYSDEPLOYASID";
    public static final String FIELD_PSSYSDEPLOYASNAME = "PSSYSDEPLOYASNAME";
    public static final String FIELD_PSSYSDEPLOYID = "PSSYSDEPLOYID";
    public static final String FIELD_PSSYSDEPLOYNAME = "PSSYSDEPLOYNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_PSSYSDEPLOYASID = 2;
    private static final int INDEX_PSSYSDEPLOYASNAME = 3;
    private static final int INDEX_PSSYSDEPLOYID = 4;
    private static final int INDEX_PSSYSDEPLOYNAME = 5;
    private static final int INDEX_UPDATEDATE = 6;
    private static final int INDEX_UPDATEMAN = 7;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysDeployASBase proxyPSSysDeployASBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean pssysdeployasidDirtyFlag = false;
    private boolean pssysdeployasnameDirtyFlag = false;
    private boolean pssysdeployidDirtyFlag = false;
    private boolean pssysdeploynameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="pssysdeployasid")
    private String pssysdeployasid;
    @Column(name="pssysdeployasname")
    private String pssysdeployasname;
    @Column(name="pssysdeployid")
    private String pssysdeployid;
    @Column(name="pssysdeployname")
    private String pssysdeployname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPssysdeployLock = new Integer(1);
    private PSSysDeploy pssysdeploy = null;

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

    public void setPSSysDeployASId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDeployASId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdeployasid = string;
        this.pssysdeployasidDirtyFlag = true;
    }

    public String getPSSysDeployASId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDeployASId();
        }
        return this.pssysdeployasid;
    }

    public boolean isPSSysDeployASIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDeployASIdDirty();
        }
        return this.pssysdeployasidDirtyFlag;
    }

    public void resetPSSysDeployASId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDeployASId();
            return;
        }
        this.pssysdeployasidDirtyFlag = false;
        this.pssysdeployasid = null;
    }

    public void setPSSysDeployASName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDeployASName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdeployasname = string;
        this.pssysdeployasnameDirtyFlag = true;
    }

    public String getPSSysDeployASName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDeployASName();
        }
        return this.pssysdeployasname;
    }

    public boolean isPSSysDeployASNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDeployASNameDirty();
        }
        return this.pssysdeployasnameDirtyFlag;
    }

    public void resetPSSysDeployASName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDeployASName();
            return;
        }
        this.pssysdeployasnameDirtyFlag = false;
        this.pssysdeployasname = null;
    }

    public void setPSSysDeployId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDeployId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdeployid = string;
        this.pssysdeployidDirtyFlag = true;
    }

    public String getPSSysDeployId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDeployId();
        }
        return this.pssysdeployid;
    }

    public boolean isPSSysDeployIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDeployIdDirty();
        }
        return this.pssysdeployidDirtyFlag;
    }

    public void resetPSSysDeployId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDeployId();
            return;
        }
        this.pssysdeployidDirtyFlag = false;
        this.pssysdeployid = null;
    }

    public void setPSSysDeployName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDeployName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdeployname = string;
        this.pssysdeploynameDirtyFlag = true;
    }

    public String getPSSysDeployName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDeployName();
        }
        return this.pssysdeployname;
    }

    public boolean isPSSysDeployNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDeployNameDirty();
        }
        return this.pssysdeploynameDirtyFlag;
    }

    public void resetPSSysDeployName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDeployName();
            return;
        }
        this.pssysdeploynameDirtyFlag = false;
        this.pssysdeployname = null;
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
        PSSysDeployASBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysDeployASBase pSSysDeployASBase) {
        pSSysDeployASBase.resetCreateDate();
        pSSysDeployASBase.resetCreateMan();
        pSSysDeployASBase.resetPSSysDeployASId();
        pSSysDeployASBase.resetPSSysDeployASName();
        pSSysDeployASBase.resetPSSysDeployId();
        pSSysDeployASBase.resetPSSysDeployName();
        pSSysDeployASBase.resetUpdateDate();
        pSSysDeployASBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isPSSysDeployASIdDirty()) {
            hashMap.put(FIELD_PSSYSDEPLOYASID, this.getPSSysDeployASId());
        }
        if (!bl || this.isPSSysDeployASNameDirty()) {
            hashMap.put(FIELD_PSSYSDEPLOYASNAME, this.getPSSysDeployASName());
        }
        if (!bl || this.isPSSysDeployIdDirty()) {
            hashMap.put(FIELD_PSSYSDEPLOYID, this.getPSSysDeployId());
        }
        if (!bl || this.isPSSysDeployNameDirty()) {
            hashMap.put(FIELD_PSSYSDEPLOYNAME, this.getPSSysDeployName());
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
        return PSSysDeployASBase.get(this, n);
    }

    private static Object get(PSSysDeployASBase pSSysDeployASBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDeployASBase.getCreateDate();
            }
            case 1: {
                return pSSysDeployASBase.getCreateMan();
            }
            case 2: {
                return pSSysDeployASBase.getPSSysDeployASId();
            }
            case 3: {
                return pSSysDeployASBase.getPSSysDeployASName();
            }
            case 4: {
                return pSSysDeployASBase.getPSSysDeployId();
            }
            case 5: {
                return pSSysDeployASBase.getPSSysDeployName();
            }
            case 6: {
                return pSSysDeployASBase.getUpdateDate();
            }
            case 7: {
                return pSSysDeployASBase.getUpdateMan();
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
        PSSysDeployASBase.set(this, n, object);
    }

    private static void set(PSSysDeployASBase pSSysDeployASBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysDeployASBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSysDeployASBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysDeployASBase.setPSSysDeployASId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysDeployASBase.setPSSysDeployASName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysDeployASBase.setPSSysDeployId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysDeployASBase.setPSSysDeployName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysDeployASBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSSysDeployASBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSSysDeployASBase.isNull(this, n);
    }

    private static boolean isNull(PSSysDeployASBase pSSysDeployASBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDeployASBase.getCreateDate() == null;
            }
            case 1: {
                return pSSysDeployASBase.getCreateMan() == null;
            }
            case 2: {
                return pSSysDeployASBase.getPSSysDeployASId() == null;
            }
            case 3: {
                return pSSysDeployASBase.getPSSysDeployASName() == null;
            }
            case 4: {
                return pSSysDeployASBase.getPSSysDeployId() == null;
            }
            case 5: {
                return pSSysDeployASBase.getPSSysDeployName() == null;
            }
            case 6: {
                return pSSysDeployASBase.getUpdateDate() == null;
            }
            case 7: {
                return pSSysDeployASBase.getUpdateMan() == null;
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
        return PSSysDeployASBase.contains(this, n);
    }

    private static boolean contains(PSSysDeployASBase pSSysDeployASBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDeployASBase.isCreateDateDirty();
            }
            case 1: {
                return pSSysDeployASBase.isCreateManDirty();
            }
            case 2: {
                return pSSysDeployASBase.isPSSysDeployASIdDirty();
            }
            case 3: {
                return pSSysDeployASBase.isPSSysDeployASNameDirty();
            }
            case 4: {
                return pSSysDeployASBase.isPSSysDeployIdDirty();
            }
            case 5: {
                return pSSysDeployASBase.isPSSysDeployNameDirty();
            }
            case 6: {
                return pSSysDeployASBase.isUpdateDateDirty();
            }
            case 7: {
                return pSSysDeployASBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysDeployASBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysDeployASBase pSSysDeployASBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysDeployASBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysDeployASBase.getJSONValue((Object)pSSysDeployASBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysDeployASBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysDeployASBase.getJSONValue((Object)pSSysDeployASBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysDeployASBase.getPSSysDeployASId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdeployasid", (Object)PSSysDeployASBase.getJSONValue((Object)pSSysDeployASBase.getPSSysDeployASId()), (boolean)false);
        }
        if (bl || pSSysDeployASBase.getPSSysDeployASName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdeployasname", (Object)PSSysDeployASBase.getJSONValue((Object)pSSysDeployASBase.getPSSysDeployASName()), (boolean)false);
        }
        if (bl || pSSysDeployASBase.getPSSysDeployId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdeployid", (Object)PSSysDeployASBase.getJSONValue((Object)pSSysDeployASBase.getPSSysDeployId()), (boolean)false);
        }
        if (bl || pSSysDeployASBase.getPSSysDeployName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdeployname", (Object)PSSysDeployASBase.getJSONValue((Object)pSSysDeployASBase.getPSSysDeployName()), (boolean)false);
        }
        if (bl || pSSysDeployASBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysDeployASBase.getJSONValue((Object)pSSysDeployASBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysDeployASBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysDeployASBase.getJSONValue((Object)pSSysDeployASBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysDeployASBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysDeployASBase pSSysDeployASBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysDeployASBase.getCreateDate() != null) {
            object = pSSysDeployASBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysDeployASBase.getCreateMan() != null) {
            object = pSSysDeployASBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysDeployASBase.getPSSysDeployASId() != null) {
            object = pSSysDeployASBase.getPSSysDeployASId();
            xmlNode.setAttribute(FIELD_PSSYSDEPLOYASID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDeployASBase.getPSSysDeployASName() != null) {
            object = pSSysDeployASBase.getPSSysDeployASName();
            xmlNode.setAttribute(FIELD_PSSYSDEPLOYASNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDeployASBase.getPSSysDeployId() != null) {
            object = pSSysDeployASBase.getPSSysDeployId();
            xmlNode.setAttribute(FIELD_PSSYSDEPLOYID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDeployASBase.getPSSysDeployName() != null) {
            object = pSSysDeployASBase.getPSSysDeployName();
            xmlNode.setAttribute(FIELD_PSSYSDEPLOYNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDeployASBase.getUpdateDate() != null) {
            object = pSSysDeployASBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysDeployASBase.getUpdateMan() != null) {
            object = pSSysDeployASBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysDeployASBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysDeployASBase pSSysDeployASBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysDeployASBase.isCreateDateDirty() && (bl || pSSysDeployASBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysDeployASBase.getCreateDate());
        }
        if (pSSysDeployASBase.isCreateManDirty() && (bl || pSSysDeployASBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysDeployASBase.getCreateMan());
        }
        if (pSSysDeployASBase.isPSSysDeployASIdDirty() && (bl || pSSysDeployASBase.getPSSysDeployASId() != null)) {
            iDataObject.set(FIELD_PSSYSDEPLOYASID, (Object)pSSysDeployASBase.getPSSysDeployASId());
        }
        if (pSSysDeployASBase.isPSSysDeployASNameDirty() && (bl || pSSysDeployASBase.getPSSysDeployASName() != null)) {
            iDataObject.set(FIELD_PSSYSDEPLOYASNAME, (Object)pSSysDeployASBase.getPSSysDeployASName());
        }
        if (pSSysDeployASBase.isPSSysDeployIdDirty() && (bl || pSSysDeployASBase.getPSSysDeployId() != null)) {
            iDataObject.set(FIELD_PSSYSDEPLOYID, (Object)pSSysDeployASBase.getPSSysDeployId());
        }
        if (pSSysDeployASBase.isPSSysDeployNameDirty() && (bl || pSSysDeployASBase.getPSSysDeployName() != null)) {
            iDataObject.set(FIELD_PSSYSDEPLOYNAME, (Object)pSSysDeployASBase.getPSSysDeployName());
        }
        if (pSSysDeployASBase.isUpdateDateDirty() && (bl || pSSysDeployASBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysDeployASBase.getUpdateDate());
        }
        if (pSSysDeployASBase.isUpdateManDirty() && (bl || pSSysDeployASBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysDeployASBase.getUpdateMan());
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
        return PSSysDeployASBase.remove(this, n);
    }

    private static boolean remove(PSSysDeployASBase pSSysDeployASBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysDeployASBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSysDeployASBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSysDeployASBase.resetPSSysDeployASId();
                return true;
            }
            case 3: {
                pSSysDeployASBase.resetPSSysDeployASName();
                return true;
            }
            case 4: {
                pSSysDeployASBase.resetPSSysDeployId();
                return true;
            }
            case 5: {
                pSSysDeployASBase.resetPSSysDeployName();
                return true;
            }
            case 6: {
                pSSysDeployASBase.resetUpdateDate();
                return true;
            }
            case 7: {
                pSSysDeployASBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysDeploy getPssysdeploy() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPssysdeploy();
        }
        if (this.getPSSysDeployId() == null) {
            return null;
        }
        Integer n = this.objPssysdeployLock;
        synchronized (n) {
            if (this.pssysdeploy != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysDeployId(), (Object)this.pssysdeploy.getPSSysDeployId()) != 0L) {
                this.pssysdeploy = null;
            }
            if (this.pssysdeploy == null) {
                PSSysDeploy pSSysDeploy = new PSSysDeploy();
                pSSysDeploy.setPSSysDeployId(this.getPSSysDeployId());
                PSSysDeployService pSSysDeployService = (PSSysDeployService)ServiceGlobal.getService(PSSysDeployService.class, (SessionFactory)this.getSessionFactory());
                pSSysDeployService.autoGet((IEntity)pSSysDeploy);
                this.pssysdeploy = pSSysDeploy;
            }
            return this.pssysdeploy;
        }
    }

    private PSSysDeployASBase getProxyEntity() {
        return this.proxyPSSysDeployASBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysDeployASBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysDeployASBase) {
            this.proxyPSSysDeployASBase = (PSSysDeployASBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDeployASService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_PSSYSDEPLOYASID, 2);
        fieldIndexMap.put(FIELD_PSSYSDEPLOYASNAME, 3);
        fieldIndexMap.put(FIELD_PSSYSDEPLOYID, 4);
        fieldIndexMap.put(FIELD_PSSYSDEPLOYNAME, 5);
        fieldIndexMap.put(FIELD_UPDATEDATE, 6);
        fieldIndexMap.put(FIELD_UPDATEMAN, 7);
    }
}

