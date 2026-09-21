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

public abstract class PSDCOrgTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCOrgTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDCORGTYPEID = "PSDCORGTYPEID";
    public static final String FIELD_PSDCORGTYPENAME = "PSDCORGTYPENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERDATA = "USERDATA";
    public static final String FIELD_USERDATA2 = "USERDATA2";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSDCORGTYPEID = 3;
    private static final int INDEX_PSDCORGTYPENAME = 4;
    private static final int INDEX_UPDATEDATE = 5;
    private static final int INDEX_UPDATEMAN = 6;
    private static final int INDEX_USERDATA = 7;
    private static final int INDEX_USERDATA2 = 8;
    private static final int INDEX_VALIDFLAG = 9;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCOrgTypeBase proxyPSDCOrgTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdcorgtypeidDirtyFlag = false;
    private boolean psdcorgtypenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean userdataDirtyFlag = false;
    private boolean userdata2DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psdcorgtypeid")
    private String psdcorgtypeid;
    @Column(name="psdcorgtypename")
    private String psdcorgtypename;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="userdata")
    private String userdata;
    @Column(name="userdata2")
    private String userdata2;
    @Column(name="validflag")
    private Integer validflag;

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

    public void setPSDCOrgTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCOrgTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcorgtypeid = string;
        this.psdcorgtypeidDirtyFlag = true;
    }

    public String getPSDCOrgTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCOrgTypeId();
        }
        return this.psdcorgtypeid;
    }

    public boolean isPSDCOrgTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCOrgTypeIdDirty();
        }
        return this.psdcorgtypeidDirtyFlag;
    }

    public void resetPSDCOrgTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCOrgTypeId();
            return;
        }
        this.psdcorgtypeidDirtyFlag = false;
        this.psdcorgtypeid = null;
    }

    public void setPSDCOrgTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCOrgTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcorgtypename = string;
        this.psdcorgtypenameDirtyFlag = true;
    }

    public String getPSDCOrgTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCOrgTypeName();
        }
        return this.psdcorgtypename;
    }

    public boolean isPSDCOrgTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCOrgTypeNameDirty();
        }
        return this.psdcorgtypenameDirtyFlag;
    }

    public void resetPSDCOrgTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCOrgTypeName();
            return;
        }
        this.psdcorgtypenameDirtyFlag = false;
        this.psdcorgtypename = null;
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

    public void setUserData(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserData(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userdata = string;
        this.userdataDirtyFlag = true;
    }

    public String getUserData() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserData();
        }
        return this.userdata;
    }

    public boolean isUserDataDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserDataDirty();
        }
        return this.userdataDirtyFlag;
    }

    public void resetUserData() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserData();
            return;
        }
        this.userdataDirtyFlag = false;
        this.userdata = null;
    }

    public void setUserData2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserData2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userdata2 = string;
        this.userdata2DirtyFlag = true;
    }

    public String getUserData2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserData2();
        }
        return this.userdata2;
    }

    public boolean isUserData2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserData2Dirty();
        }
        return this.userdata2DirtyFlag;
    }

    public void resetUserData2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserData2();
            return;
        }
        this.userdata2DirtyFlag = false;
        this.userdata2 = null;
    }

    public void setValidFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValidFlag(n);
            return;
        }
        this.validflag = n;
        this.validflagDirtyFlag = true;
    }

    public Integer getValidFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValidFlag();
        }
        return this.validflag;
    }

    public boolean isValidFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValidFlagDirty();
        }
        return this.validflagDirtyFlag;
    }

    public void resetValidFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValidFlag();
            return;
        }
        this.validflagDirtyFlag = false;
        this.validflag = null;
    }

    protected void onReset() {
        PSDCOrgTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCOrgTypeBase pSDCOrgTypeBase) {
        pSDCOrgTypeBase.resetCreateDate();
        pSDCOrgTypeBase.resetCreateMan();
        pSDCOrgTypeBase.resetMemo();
        pSDCOrgTypeBase.resetPSDCOrgTypeId();
        pSDCOrgTypeBase.resetPSDCOrgTypeName();
        pSDCOrgTypeBase.resetUpdateDate();
        pSDCOrgTypeBase.resetUpdateMan();
        pSDCOrgTypeBase.resetUserData();
        pSDCOrgTypeBase.resetUserData2();
        pSDCOrgTypeBase.resetValidFlag();
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
        if (!bl || this.isPSDCOrgTypeIdDirty()) {
            hashMap.put(FIELD_PSDCORGTYPEID, this.getPSDCOrgTypeId());
        }
        if (!bl || this.isPSDCOrgTypeNameDirty()) {
            hashMap.put(FIELD_PSDCORGTYPENAME, this.getPSDCOrgTypeName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserDataDirty()) {
            hashMap.put(FIELD_USERDATA, this.getUserData());
        }
        if (!bl || this.isUserData2Dirty()) {
            hashMap.put(FIELD_USERDATA2, this.getUserData2());
        }
        if (!bl || this.isValidFlagDirty()) {
            hashMap.put(FIELD_VALIDFLAG, this.getValidFlag());
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
        return PSDCOrgTypeBase.get(this, n);
    }

    private static Object get(PSDCOrgTypeBase pSDCOrgTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCOrgTypeBase.getCreateDate();
            }
            case 1: {
                return pSDCOrgTypeBase.getCreateMan();
            }
            case 2: {
                return pSDCOrgTypeBase.getMemo();
            }
            case 3: {
                return pSDCOrgTypeBase.getPSDCOrgTypeId();
            }
            case 4: {
                return pSDCOrgTypeBase.getPSDCOrgTypeName();
            }
            case 5: {
                return pSDCOrgTypeBase.getUpdateDate();
            }
            case 6: {
                return pSDCOrgTypeBase.getUpdateMan();
            }
            case 7: {
                return pSDCOrgTypeBase.getUserData();
            }
            case 8: {
                return pSDCOrgTypeBase.getUserData2();
            }
            case 9: {
                return pSDCOrgTypeBase.getValidFlag();
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
        PSDCOrgTypeBase.set(this, n, object);
    }

    private static void set(PSDCOrgTypeBase pSDCOrgTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCOrgTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDCOrgTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDCOrgTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDCOrgTypeBase.setPSDCOrgTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDCOrgTypeBase.setPSDCOrgTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDCOrgTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 6: {
                pSDCOrgTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDCOrgTypeBase.setUserData(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDCOrgTypeBase.setUserData2(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDCOrgTypeBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDCOrgTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSDCOrgTypeBase pSDCOrgTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCOrgTypeBase.getCreateDate() == null;
            }
            case 1: {
                return pSDCOrgTypeBase.getCreateMan() == null;
            }
            case 2: {
                return pSDCOrgTypeBase.getMemo() == null;
            }
            case 3: {
                return pSDCOrgTypeBase.getPSDCOrgTypeId() == null;
            }
            case 4: {
                return pSDCOrgTypeBase.getPSDCOrgTypeName() == null;
            }
            case 5: {
                return pSDCOrgTypeBase.getUpdateDate() == null;
            }
            case 6: {
                return pSDCOrgTypeBase.getUpdateMan() == null;
            }
            case 7: {
                return pSDCOrgTypeBase.getUserData() == null;
            }
            case 8: {
                return pSDCOrgTypeBase.getUserData2() == null;
            }
            case 9: {
                return pSDCOrgTypeBase.getValidFlag() == null;
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
        return PSDCOrgTypeBase.contains(this, n);
    }

    private static boolean contains(PSDCOrgTypeBase pSDCOrgTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCOrgTypeBase.isCreateDateDirty();
            }
            case 1: {
                return pSDCOrgTypeBase.isCreateManDirty();
            }
            case 2: {
                return pSDCOrgTypeBase.isMemoDirty();
            }
            case 3: {
                return pSDCOrgTypeBase.isPSDCOrgTypeIdDirty();
            }
            case 4: {
                return pSDCOrgTypeBase.isPSDCOrgTypeNameDirty();
            }
            case 5: {
                return pSDCOrgTypeBase.isUpdateDateDirty();
            }
            case 6: {
                return pSDCOrgTypeBase.isUpdateManDirty();
            }
            case 7: {
                return pSDCOrgTypeBase.isUserDataDirty();
            }
            case 8: {
                return pSDCOrgTypeBase.isUserData2Dirty();
            }
            case 9: {
                return pSDCOrgTypeBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCOrgTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCOrgTypeBase pSDCOrgTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCOrgTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCOrgTypeBase.getJSONValue((Object)pSDCOrgTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCOrgTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCOrgTypeBase.getJSONValue((Object)pSDCOrgTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCOrgTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDCOrgTypeBase.getJSONValue((Object)pSDCOrgTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSDCOrgTypeBase.getPSDCOrgTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcorgtypeid", (Object)PSDCOrgTypeBase.getJSONValue((Object)pSDCOrgTypeBase.getPSDCOrgTypeId()), (boolean)false);
        }
        if (bl || pSDCOrgTypeBase.getPSDCOrgTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcorgtypename", (Object)PSDCOrgTypeBase.getJSONValue((Object)pSDCOrgTypeBase.getPSDCOrgTypeName()), (boolean)false);
        }
        if (bl || pSDCOrgTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCOrgTypeBase.getJSONValue((Object)pSDCOrgTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCOrgTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCOrgTypeBase.getJSONValue((Object)pSDCOrgTypeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDCOrgTypeBase.getUserData() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userdata", (Object)PSDCOrgTypeBase.getJSONValue((Object)pSDCOrgTypeBase.getUserData()), (boolean)false);
        }
        if (bl || pSDCOrgTypeBase.getUserData2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userdata2", (Object)PSDCOrgTypeBase.getJSONValue((Object)pSDCOrgTypeBase.getUserData2()), (boolean)false);
        }
        if (bl || pSDCOrgTypeBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDCOrgTypeBase.getJSONValue((Object)pSDCOrgTypeBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCOrgTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCOrgTypeBase pSDCOrgTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCOrgTypeBase.getCreateDate() != null) {
            object = pSDCOrgTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCOrgTypeBase.getCreateMan() != null) {
            object = pSDCOrgTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCOrgTypeBase.getMemo() != null) {
            object = pSDCOrgTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDCOrgTypeBase.getPSDCOrgTypeId() != null) {
            object = pSDCOrgTypeBase.getPSDCOrgTypeId();
            xmlNode.setAttribute(FIELD_PSDCORGTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSDCOrgTypeBase.getPSDCOrgTypeName() != null) {
            object = pSDCOrgTypeBase.getPSDCOrgTypeName();
            xmlNode.setAttribute(FIELD_PSDCORGTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCOrgTypeBase.getUpdateDate() != null) {
            object = pSDCOrgTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCOrgTypeBase.getUpdateMan() != null) {
            object = pSDCOrgTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCOrgTypeBase.getUserData() != null) {
            object = pSDCOrgTypeBase.getUserData();
            xmlNode.setAttribute(FIELD_USERDATA, object == null ? "" : (String)object);
        }
        if (bl || pSDCOrgTypeBase.getUserData2() != null) {
            object = pSDCOrgTypeBase.getUserData2();
            xmlNode.setAttribute(FIELD_USERDATA2, object == null ? "" : (String)object);
        }
        if (bl || pSDCOrgTypeBase.getValidFlag() != null) {
            object = pSDCOrgTypeBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCOrgTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCOrgTypeBase pSDCOrgTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCOrgTypeBase.isCreateDateDirty() && (bl || pSDCOrgTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCOrgTypeBase.getCreateDate());
        }
        if (pSDCOrgTypeBase.isCreateManDirty() && (bl || pSDCOrgTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCOrgTypeBase.getCreateMan());
        }
        if (pSDCOrgTypeBase.isMemoDirty() && (bl || pSDCOrgTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDCOrgTypeBase.getMemo());
        }
        if (pSDCOrgTypeBase.isPSDCOrgTypeIdDirty() && (bl || pSDCOrgTypeBase.getPSDCOrgTypeId() != null)) {
            iDataObject.set(FIELD_PSDCORGTYPEID, (Object)pSDCOrgTypeBase.getPSDCOrgTypeId());
        }
        if (pSDCOrgTypeBase.isPSDCOrgTypeNameDirty() && (bl || pSDCOrgTypeBase.getPSDCOrgTypeName() != null)) {
            iDataObject.set(FIELD_PSDCORGTYPENAME, (Object)pSDCOrgTypeBase.getPSDCOrgTypeName());
        }
        if (pSDCOrgTypeBase.isUpdateDateDirty() && (bl || pSDCOrgTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCOrgTypeBase.getUpdateDate());
        }
        if (pSDCOrgTypeBase.isUpdateManDirty() && (bl || pSDCOrgTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCOrgTypeBase.getUpdateMan());
        }
        if (pSDCOrgTypeBase.isUserDataDirty() && (bl || pSDCOrgTypeBase.getUserData() != null)) {
            iDataObject.set(FIELD_USERDATA, (Object)pSDCOrgTypeBase.getUserData());
        }
        if (pSDCOrgTypeBase.isUserData2Dirty() && (bl || pSDCOrgTypeBase.getUserData2() != null)) {
            iDataObject.set(FIELD_USERDATA2, (Object)pSDCOrgTypeBase.getUserData2());
        }
        if (pSDCOrgTypeBase.isValidFlagDirty() && (bl || pSDCOrgTypeBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDCOrgTypeBase.getValidFlag());
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
        return PSDCOrgTypeBase.remove(this, n);
    }

    private static boolean remove(PSDCOrgTypeBase pSDCOrgTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCOrgTypeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDCOrgTypeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDCOrgTypeBase.resetMemo();
                return true;
            }
            case 3: {
                pSDCOrgTypeBase.resetPSDCOrgTypeId();
                return true;
            }
            case 4: {
                pSDCOrgTypeBase.resetPSDCOrgTypeName();
                return true;
            }
            case 5: {
                pSDCOrgTypeBase.resetUpdateDate();
                return true;
            }
            case 6: {
                pSDCOrgTypeBase.resetUpdateMan();
                return true;
            }
            case 7: {
                pSDCOrgTypeBase.resetUserData();
                return true;
            }
            case 8: {
                pSDCOrgTypeBase.resetUserData2();
                return true;
            }
            case 9: {
                pSDCOrgTypeBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSDCOrgTypeBase getProxyEntity() {
        return this.proxyPSDCOrgTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCOrgTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCOrgTypeBase) {
            this.proxyPSDCOrgTypeBase = (PSDCOrgTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSDCOrgTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSDCORGTYPEID, 3);
        fieldIndexMap.put(FIELD_PSDCORGTYPENAME, 4);
        fieldIndexMap.put(FIELD_UPDATEDATE, 5);
        fieldIndexMap.put(FIELD_UPDATEMAN, 6);
        fieldIndexMap.put(FIELD_USERDATA, 7);
        fieldIndexMap.put(FIELD_USERDATA2, 8);
        fieldIndexMap.put(FIELD_VALIDFLAG, 9);
    }
}

