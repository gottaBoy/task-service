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
package net.ibizsys.pscore.srv.sysdesign.entity;

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

public abstract class PSModelObjRefBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSModelObjRefBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_PSMODELOBJID = "PSMODELOBJID";
    public static final String FIELD_PSMODELOBJREFID = "PSMODELOBJREFID";
    public static final String FIELD_PSMODELOBJREFNAME = "PSMODELOBJREFNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_REFPSMODELOBJID = "REFPSMODELOBJID";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_PSMODELOBJID = 2;
    private static final int INDEX_PSMODELOBJREFID = 3;
    private static final int INDEX_PSMODELOBJREFNAME = 4;
    private static final int INDEX_PSSYSTEMID = 5;
    private static final int INDEX_REFPSMODELOBJID = 6;
    private static final int INDEX_UPDATEDATE = 7;
    private static final int INDEX_UPDATEMAN = 8;
    private static final int INDEX_USERTAG = 9;
    private static final int INDEX_USERTAG2 = 10;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSModelObjRefBase proxyPSModelObjRefBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean psmodelobjidDirtyFlag = false;
    private boolean psmodelobjrefidDirtyFlag = false;
    private boolean psmodelobjrefnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean refpsmodelobjidDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="psmodelobjid")
    private String psmodelobjid;
    @Column(name="psmodelobjrefid")
    private String psmodelobjrefid;
    @Column(name="psmodelobjrefname")
    private String psmodelobjrefname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="refpsmodelobjid")
    private String refpsmodelobjid;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;

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

    public void setPSModelObjId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelObjId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelobjid = string;
        this.psmodelobjidDirtyFlag = true;
    }

    public String getPSModelObjId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelObjId();
        }
        return this.psmodelobjid;
    }

    public boolean isPSModelObjIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelObjIdDirty();
        }
        return this.psmodelobjidDirtyFlag;
    }

    public void resetPSModelObjId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelObjId();
            return;
        }
        this.psmodelobjidDirtyFlag = false;
        this.psmodelobjid = null;
    }

    public void setPSModelObjRefId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelObjRefId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelobjrefid = string;
        this.psmodelobjrefidDirtyFlag = true;
    }

    public String getPSModelObjRefId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelObjRefId();
        }
        return this.psmodelobjrefid;
    }

    public boolean isPSModelObjRefIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelObjRefIdDirty();
        }
        return this.psmodelobjrefidDirtyFlag;
    }

    public void resetPSModelObjRefId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelObjRefId();
            return;
        }
        this.psmodelobjrefidDirtyFlag = false;
        this.psmodelobjrefid = null;
    }

    public void setPSModelObjRefName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelObjRefName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelobjrefname = string;
        this.psmodelobjrefnameDirtyFlag = true;
    }

    public String getPSModelObjRefName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelObjRefName();
        }
        return this.psmodelobjrefname;
    }

    public boolean isPSModelObjRefNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelObjRefNameDirty();
        }
        return this.psmodelobjrefnameDirtyFlag;
    }

    public void resetPSModelObjRefName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelObjRefName();
            return;
        }
        this.psmodelobjrefnameDirtyFlag = false;
        this.psmodelobjrefname = null;
    }

    public void setPSSystemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemid = string;
        this.pssystemidDirtyFlag = true;
    }

    public String getPSSystemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemId();
        }
        return this.pssystemid;
    }

    public boolean isPSSystemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemIdDirty();
        }
        return this.pssystemidDirtyFlag;
    }

    public void resetPSSystemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemId();
            return;
        }
        this.pssystemidDirtyFlag = false;
        this.pssystemid = null;
    }

    public void setRefPSModelObjId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSModelObjId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpsmodelobjid = string;
        this.refpsmodelobjidDirtyFlag = true;
    }

    public String getRefPSModelObjId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSModelObjId();
        }
        return this.refpsmodelobjid;
    }

    public boolean isRefPSModelObjIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSModelObjIdDirty();
        }
        return this.refpsmodelobjidDirtyFlag;
    }

    public void resetRefPSModelObjId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSModelObjId();
            return;
        }
        this.refpsmodelobjidDirtyFlag = false;
        this.refpsmodelobjid = null;
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

    public void setUserTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag = string;
        this.usertagDirtyFlag = true;
    }

    public String getUserTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag();
        }
        return this.usertag;
    }

    public boolean isUserTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTagDirty();
        }
        return this.usertagDirtyFlag;
    }

    public void resetUserTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag();
            return;
        }
        this.usertagDirtyFlag = false;
        this.usertag = null;
    }

    public void setUserTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag2 = string;
        this.usertag2DirtyFlag = true;
    }

    public String getUserTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag2();
        }
        return this.usertag2;
    }

    public boolean isUserTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag2Dirty();
        }
        return this.usertag2DirtyFlag;
    }

    public void resetUserTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag2();
            return;
        }
        this.usertag2DirtyFlag = false;
        this.usertag2 = null;
    }

    protected void onReset() {
        PSModelObjRefBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSModelObjRefBase pSModelObjRefBase) {
        pSModelObjRefBase.resetCreateDate();
        pSModelObjRefBase.resetCreateMan();
        pSModelObjRefBase.resetPSModelObjId();
        pSModelObjRefBase.resetPSModelObjRefId();
        pSModelObjRefBase.resetPSModelObjRefName();
        pSModelObjRefBase.resetPSSystemId();
        pSModelObjRefBase.resetRefPSModelObjId();
        pSModelObjRefBase.resetUpdateDate();
        pSModelObjRefBase.resetUpdateMan();
        pSModelObjRefBase.resetUserTag();
        pSModelObjRefBase.resetUserTag2();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isPSModelObjIdDirty()) {
            hashMap.put(FIELD_PSMODELOBJID, this.getPSModelObjId());
        }
        if (!bl || this.isPSModelObjRefIdDirty()) {
            hashMap.put(FIELD_PSMODELOBJREFID, this.getPSModelObjRefId());
        }
        if (!bl || this.isPSModelObjRefNameDirty()) {
            hashMap.put(FIELD_PSMODELOBJREFNAME, this.getPSModelObjRefName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isRefPSModelObjIdDirty()) {
            hashMap.put(FIELD_REFPSMODELOBJID, this.getRefPSModelObjId());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserTagDirty()) {
            hashMap.put(FIELD_USERTAG, this.getUserTag());
        }
        if (!bl || this.isUserTag2Dirty()) {
            hashMap.put(FIELD_USERTAG2, this.getUserTag2());
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
        return PSModelObjRefBase.get(this, n);
    }

    private static Object get(PSModelObjRefBase pSModelObjRefBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelObjRefBase.getCreateDate();
            }
            case 1: {
                return pSModelObjRefBase.getCreateMan();
            }
            case 2: {
                return pSModelObjRefBase.getPSModelObjId();
            }
            case 3: {
                return pSModelObjRefBase.getPSModelObjRefId();
            }
            case 4: {
                return pSModelObjRefBase.getPSModelObjRefName();
            }
            case 5: {
                return pSModelObjRefBase.getPSSystemId();
            }
            case 6: {
                return pSModelObjRefBase.getRefPSModelObjId();
            }
            case 7: {
                return pSModelObjRefBase.getUpdateDate();
            }
            case 8: {
                return pSModelObjRefBase.getUpdateMan();
            }
            case 9: {
                return pSModelObjRefBase.getUserTag();
            }
            case 10: {
                return pSModelObjRefBase.getUserTag2();
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
        PSModelObjRefBase.set(this, n, object);
    }

    private static void set(PSModelObjRefBase pSModelObjRefBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSModelObjRefBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSModelObjRefBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSModelObjRefBase.setPSModelObjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSModelObjRefBase.setPSModelObjRefId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSModelObjRefBase.setPSModelObjRefName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSModelObjRefBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSModelObjRefBase.setRefPSModelObjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSModelObjRefBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 8: {
                pSModelObjRefBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSModelObjRefBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSModelObjRefBase.setUserTag2(DataObject.getStringValue((Object)object));
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
        return PSModelObjRefBase.isNull(this, n);
    }

    private static boolean isNull(PSModelObjRefBase pSModelObjRefBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelObjRefBase.getCreateDate() == null;
            }
            case 1: {
                return pSModelObjRefBase.getCreateMan() == null;
            }
            case 2: {
                return pSModelObjRefBase.getPSModelObjId() == null;
            }
            case 3: {
                return pSModelObjRefBase.getPSModelObjRefId() == null;
            }
            case 4: {
                return pSModelObjRefBase.getPSModelObjRefName() == null;
            }
            case 5: {
                return pSModelObjRefBase.getPSSystemId() == null;
            }
            case 6: {
                return pSModelObjRefBase.getRefPSModelObjId() == null;
            }
            case 7: {
                return pSModelObjRefBase.getUpdateDate() == null;
            }
            case 8: {
                return pSModelObjRefBase.getUpdateMan() == null;
            }
            case 9: {
                return pSModelObjRefBase.getUserTag() == null;
            }
            case 10: {
                return pSModelObjRefBase.getUserTag2() == null;
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
        return PSModelObjRefBase.contains(this, n);
    }

    private static boolean contains(PSModelObjRefBase pSModelObjRefBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelObjRefBase.isCreateDateDirty();
            }
            case 1: {
                return pSModelObjRefBase.isCreateManDirty();
            }
            case 2: {
                return pSModelObjRefBase.isPSModelObjIdDirty();
            }
            case 3: {
                return pSModelObjRefBase.isPSModelObjRefIdDirty();
            }
            case 4: {
                return pSModelObjRefBase.isPSModelObjRefNameDirty();
            }
            case 5: {
                return pSModelObjRefBase.isPSSystemIdDirty();
            }
            case 6: {
                return pSModelObjRefBase.isRefPSModelObjIdDirty();
            }
            case 7: {
                return pSModelObjRefBase.isUpdateDateDirty();
            }
            case 8: {
                return pSModelObjRefBase.isUpdateManDirty();
            }
            case 9: {
                return pSModelObjRefBase.isUserTagDirty();
            }
            case 10: {
                return pSModelObjRefBase.isUserTag2Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSModelObjRefBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSModelObjRefBase pSModelObjRefBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSModelObjRefBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSModelObjRefBase.getJSONValue((Object)pSModelObjRefBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSModelObjRefBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSModelObjRefBase.getJSONValue((Object)pSModelObjRefBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSModelObjRefBase.getPSModelObjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelobjid", (Object)PSModelObjRefBase.getJSONValue((Object)pSModelObjRefBase.getPSModelObjId()), (boolean)false);
        }
        if (bl || pSModelObjRefBase.getPSModelObjRefId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelobjrefid", (Object)PSModelObjRefBase.getJSONValue((Object)pSModelObjRefBase.getPSModelObjRefId()), (boolean)false);
        }
        if (bl || pSModelObjRefBase.getPSModelObjRefName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelobjrefname", (Object)PSModelObjRefBase.getJSONValue((Object)pSModelObjRefBase.getPSModelObjRefName()), (boolean)false);
        }
        if (bl || pSModelObjRefBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSModelObjRefBase.getJSONValue((Object)pSModelObjRefBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSModelObjRefBase.getRefPSModelObjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsmodelobjid", (Object)PSModelObjRefBase.getJSONValue((Object)pSModelObjRefBase.getRefPSModelObjId()), (boolean)false);
        }
        if (bl || pSModelObjRefBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSModelObjRefBase.getJSONValue((Object)pSModelObjRefBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSModelObjRefBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSModelObjRefBase.getJSONValue((Object)pSModelObjRefBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSModelObjRefBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSModelObjRefBase.getJSONValue((Object)pSModelObjRefBase.getUserTag()), (boolean)false);
        }
        if (bl || pSModelObjRefBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSModelObjRefBase.getJSONValue((Object)pSModelObjRefBase.getUserTag2()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSModelObjRefBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSModelObjRefBase pSModelObjRefBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSModelObjRefBase.getCreateDate() != null) {
            object = pSModelObjRefBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelObjRefBase.getCreateMan() != null) {
            object = pSModelObjRefBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSModelObjRefBase.getPSModelObjId() != null) {
            object = pSModelObjRefBase.getPSModelObjId();
            xmlNode.setAttribute(FIELD_PSMODELOBJID, object == null ? "" : (String)object);
        }
        if (bl || pSModelObjRefBase.getPSModelObjRefId() != null) {
            object = pSModelObjRefBase.getPSModelObjRefId();
            xmlNode.setAttribute(FIELD_PSMODELOBJREFID, object == null ? "" : (String)object);
        }
        if (bl || pSModelObjRefBase.getPSModelObjRefName() != null) {
            object = pSModelObjRefBase.getPSModelObjRefName();
            xmlNode.setAttribute(FIELD_PSMODELOBJREFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelObjRefBase.getPSSystemId() != null) {
            object = pSModelObjRefBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSModelObjRefBase.getRefPSModelObjId() != null) {
            object = pSModelObjRefBase.getRefPSModelObjId();
            xmlNode.setAttribute(FIELD_REFPSMODELOBJID, object == null ? "" : (String)object);
        }
        if (bl || pSModelObjRefBase.getUpdateDate() != null) {
            object = pSModelObjRefBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelObjRefBase.getUpdateMan() != null) {
            object = pSModelObjRefBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSModelObjRefBase.getUserTag() != null) {
            object = pSModelObjRefBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSModelObjRefBase.getUserTag2() != null) {
            object = pSModelObjRefBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSModelObjRefBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSModelObjRefBase pSModelObjRefBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSModelObjRefBase.isCreateDateDirty() && (bl || pSModelObjRefBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSModelObjRefBase.getCreateDate());
        }
        if (pSModelObjRefBase.isCreateManDirty() && (bl || pSModelObjRefBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSModelObjRefBase.getCreateMan());
        }
        if (pSModelObjRefBase.isPSModelObjIdDirty() && (bl || pSModelObjRefBase.getPSModelObjId() != null)) {
            iDataObject.set(FIELD_PSMODELOBJID, (Object)pSModelObjRefBase.getPSModelObjId());
        }
        if (pSModelObjRefBase.isPSModelObjRefIdDirty() && (bl || pSModelObjRefBase.getPSModelObjRefId() != null)) {
            iDataObject.set(FIELD_PSMODELOBJREFID, (Object)pSModelObjRefBase.getPSModelObjRefId());
        }
        if (pSModelObjRefBase.isPSModelObjRefNameDirty() && (bl || pSModelObjRefBase.getPSModelObjRefName() != null)) {
            iDataObject.set(FIELD_PSMODELOBJREFNAME, (Object)pSModelObjRefBase.getPSModelObjRefName());
        }
        if (pSModelObjRefBase.isPSSystemIdDirty() && (bl || pSModelObjRefBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSModelObjRefBase.getPSSystemId());
        }
        if (pSModelObjRefBase.isRefPSModelObjIdDirty() && (bl || pSModelObjRefBase.getRefPSModelObjId() != null)) {
            iDataObject.set(FIELD_REFPSMODELOBJID, (Object)pSModelObjRefBase.getRefPSModelObjId());
        }
        if (pSModelObjRefBase.isUpdateDateDirty() && (bl || pSModelObjRefBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSModelObjRefBase.getUpdateDate());
        }
        if (pSModelObjRefBase.isUpdateManDirty() && (bl || pSModelObjRefBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSModelObjRefBase.getUpdateMan());
        }
        if (pSModelObjRefBase.isUserTagDirty() && (bl || pSModelObjRefBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSModelObjRefBase.getUserTag());
        }
        if (pSModelObjRefBase.isUserTag2Dirty() && (bl || pSModelObjRefBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSModelObjRefBase.getUserTag2());
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
        return PSModelObjRefBase.remove(this, n);
    }

    private static boolean remove(PSModelObjRefBase pSModelObjRefBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSModelObjRefBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSModelObjRefBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSModelObjRefBase.resetPSModelObjId();
                return true;
            }
            case 3: {
                pSModelObjRefBase.resetPSModelObjRefId();
                return true;
            }
            case 4: {
                pSModelObjRefBase.resetPSModelObjRefName();
                return true;
            }
            case 5: {
                pSModelObjRefBase.resetPSSystemId();
                return true;
            }
            case 6: {
                pSModelObjRefBase.resetRefPSModelObjId();
                return true;
            }
            case 7: {
                pSModelObjRefBase.resetUpdateDate();
                return true;
            }
            case 8: {
                pSModelObjRefBase.resetUpdateMan();
                return true;
            }
            case 9: {
                pSModelObjRefBase.resetUserTag();
                return true;
            }
            case 10: {
                pSModelObjRefBase.resetUserTag2();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSModelObjRefBase getProxyEntity() {
        return this.proxyPSModelObjRefBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSModelObjRefBase = null;
        if (iDataObject != null && iDataObject instanceof PSModelObjRefBase) {
            this.proxyPSModelObjRefBase = (PSModelObjRefBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSModelObjRefService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_PSMODELOBJID, 2);
        fieldIndexMap.put(FIELD_PSMODELOBJREFID, 3);
        fieldIndexMap.put(FIELD_PSMODELOBJREFNAME, 4);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 5);
        fieldIndexMap.put(FIELD_REFPSMODELOBJID, 6);
        fieldIndexMap.put(FIELD_UPDATEDATE, 7);
        fieldIndexMap.put(FIELD_UPDATEMAN, 8);
        fieldIndexMap.put(FIELD_USERTAG, 9);
        fieldIndexMap.put(FIELD_USERTAG2, 10);
    }
}

