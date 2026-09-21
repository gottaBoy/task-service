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

public abstract class PSDCOrgSecUserTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCOrgSecUserTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDCORGSECUSERTYPEID = "PSDCORGSECUSERTYPEID";
    public static final String FIELD_PSDCORGSECUSERTYPENAME = "PSDCORGSECUSERTYPENAME";
    public static final String FIELD_REALID = "REALID";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERDATA = "USERDATA";
    public static final String FIELD_USERDATA2 = "USERDATA2";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSDCORGSECUSERTYPEID = 3;
    private static final int INDEX_PSDCORGSECUSERTYPENAME = 4;
    private static final int INDEX_REALID = 5;
    private static final int INDEX_UPDATEDATE = 6;
    private static final int INDEX_UPDATEMAN = 7;
    private static final int INDEX_USERDATA = 8;
    private static final int INDEX_USERDATA2 = 9;
    private static final int INDEX_VALIDFLAG = 10;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCOrgSecUserTypeBase proxyPSDCOrgSecUserTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdcorgsecusertypeidDirtyFlag = false;
    private boolean psdcorgsecusertypenameDirtyFlag = false;
    private boolean realidDirtyFlag = false;
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
    @Column(name="psdcorgsecusertypeid")
    private String psdcorgsecusertypeid;
    @Column(name="psdcorgsecusertypename")
    private String psdcorgsecusertypename;
    @Column(name="realid")
    private String realid;
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

    public void setPSDCOrgSecUserTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCOrgSecUserTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcorgsecusertypeid = string;
        this.psdcorgsecusertypeidDirtyFlag = true;
    }

    public String getPSDCOrgSecUserTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCOrgSecUserTypeId();
        }
        return this.psdcorgsecusertypeid;
    }

    public boolean isPSDCOrgSecUserTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCOrgSecUserTypeIdDirty();
        }
        return this.psdcorgsecusertypeidDirtyFlag;
    }

    public void resetPSDCOrgSecUserTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCOrgSecUserTypeId();
            return;
        }
        this.psdcorgsecusertypeidDirtyFlag = false;
        this.psdcorgsecusertypeid = null;
    }

    public void setPSDCOrgSecUserTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCOrgSecUserTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcorgsecusertypename = string;
        this.psdcorgsecusertypenameDirtyFlag = true;
    }

    public String getPSDCOrgSecUserTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCOrgSecUserTypeName();
        }
        return this.psdcorgsecusertypename;
    }

    public boolean isPSDCOrgSecUserTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCOrgSecUserTypeNameDirty();
        }
        return this.psdcorgsecusertypenameDirtyFlag;
    }

    public void resetPSDCOrgSecUserTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCOrgSecUserTypeName();
            return;
        }
        this.psdcorgsecusertypenameDirtyFlag = false;
        this.psdcorgsecusertypename = null;
    }

    public void setRealId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRealId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.realid = string;
        this.realidDirtyFlag = true;
    }

    public String getRealId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRealId();
        }
        return this.realid;
    }

    public boolean isRealIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRealIdDirty();
        }
        return this.realidDirtyFlag;
    }

    public void resetRealId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRealId();
            return;
        }
        this.realidDirtyFlag = false;
        this.realid = null;
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
        PSDCOrgSecUserTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCOrgSecUserTypeBase pSDCOrgSecUserTypeBase) {
        pSDCOrgSecUserTypeBase.resetCreateDate();
        pSDCOrgSecUserTypeBase.resetCreateMan();
        pSDCOrgSecUserTypeBase.resetMemo();
        pSDCOrgSecUserTypeBase.resetPSDCOrgSecUserTypeId();
        pSDCOrgSecUserTypeBase.resetPSDCOrgSecUserTypeName();
        pSDCOrgSecUserTypeBase.resetRealId();
        pSDCOrgSecUserTypeBase.resetUpdateDate();
        pSDCOrgSecUserTypeBase.resetUpdateMan();
        pSDCOrgSecUserTypeBase.resetUserData();
        pSDCOrgSecUserTypeBase.resetUserData2();
        pSDCOrgSecUserTypeBase.resetValidFlag();
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
        if (!bl || this.isPSDCOrgSecUserTypeIdDirty()) {
            hashMap.put(FIELD_PSDCORGSECUSERTYPEID, this.getPSDCOrgSecUserTypeId());
        }
        if (!bl || this.isPSDCOrgSecUserTypeNameDirty()) {
            hashMap.put(FIELD_PSDCORGSECUSERTYPENAME, this.getPSDCOrgSecUserTypeName());
        }
        if (!bl || this.isRealIdDirty()) {
            hashMap.put(FIELD_REALID, this.getRealId());
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
        return PSDCOrgSecUserTypeBase.get(this, n);
    }

    private static Object get(PSDCOrgSecUserTypeBase pSDCOrgSecUserTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCOrgSecUserTypeBase.getCreateDate();
            }
            case 1: {
                return pSDCOrgSecUserTypeBase.getCreateMan();
            }
            case 2: {
                return pSDCOrgSecUserTypeBase.getMemo();
            }
            case 3: {
                return pSDCOrgSecUserTypeBase.getPSDCOrgSecUserTypeId();
            }
            case 4: {
                return pSDCOrgSecUserTypeBase.getPSDCOrgSecUserTypeName();
            }
            case 5: {
                return pSDCOrgSecUserTypeBase.getRealId();
            }
            case 6: {
                return pSDCOrgSecUserTypeBase.getUpdateDate();
            }
            case 7: {
                return pSDCOrgSecUserTypeBase.getUpdateMan();
            }
            case 8: {
                return pSDCOrgSecUserTypeBase.getUserData();
            }
            case 9: {
                return pSDCOrgSecUserTypeBase.getUserData2();
            }
            case 10: {
                return pSDCOrgSecUserTypeBase.getValidFlag();
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
        PSDCOrgSecUserTypeBase.set(this, n, object);
    }

    private static void set(PSDCOrgSecUserTypeBase pSDCOrgSecUserTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCOrgSecUserTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDCOrgSecUserTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDCOrgSecUserTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDCOrgSecUserTypeBase.setPSDCOrgSecUserTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDCOrgSecUserTypeBase.setPSDCOrgSecUserTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDCOrgSecUserTypeBase.setRealId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDCOrgSecUserTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSDCOrgSecUserTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDCOrgSecUserTypeBase.setUserData(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDCOrgSecUserTypeBase.setUserData2(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDCOrgSecUserTypeBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDCOrgSecUserTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSDCOrgSecUserTypeBase pSDCOrgSecUserTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCOrgSecUserTypeBase.getCreateDate() == null;
            }
            case 1: {
                return pSDCOrgSecUserTypeBase.getCreateMan() == null;
            }
            case 2: {
                return pSDCOrgSecUserTypeBase.getMemo() == null;
            }
            case 3: {
                return pSDCOrgSecUserTypeBase.getPSDCOrgSecUserTypeId() == null;
            }
            case 4: {
                return pSDCOrgSecUserTypeBase.getPSDCOrgSecUserTypeName() == null;
            }
            case 5: {
                return pSDCOrgSecUserTypeBase.getRealId() == null;
            }
            case 6: {
                return pSDCOrgSecUserTypeBase.getUpdateDate() == null;
            }
            case 7: {
                return pSDCOrgSecUserTypeBase.getUpdateMan() == null;
            }
            case 8: {
                return pSDCOrgSecUserTypeBase.getUserData() == null;
            }
            case 9: {
                return pSDCOrgSecUserTypeBase.getUserData2() == null;
            }
            case 10: {
                return pSDCOrgSecUserTypeBase.getValidFlag() == null;
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
        return PSDCOrgSecUserTypeBase.contains(this, n);
    }

    private static boolean contains(PSDCOrgSecUserTypeBase pSDCOrgSecUserTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCOrgSecUserTypeBase.isCreateDateDirty();
            }
            case 1: {
                return pSDCOrgSecUserTypeBase.isCreateManDirty();
            }
            case 2: {
                return pSDCOrgSecUserTypeBase.isMemoDirty();
            }
            case 3: {
                return pSDCOrgSecUserTypeBase.isPSDCOrgSecUserTypeIdDirty();
            }
            case 4: {
                return pSDCOrgSecUserTypeBase.isPSDCOrgSecUserTypeNameDirty();
            }
            case 5: {
                return pSDCOrgSecUserTypeBase.isRealIdDirty();
            }
            case 6: {
                return pSDCOrgSecUserTypeBase.isUpdateDateDirty();
            }
            case 7: {
                return pSDCOrgSecUserTypeBase.isUpdateManDirty();
            }
            case 8: {
                return pSDCOrgSecUserTypeBase.isUserDataDirty();
            }
            case 9: {
                return pSDCOrgSecUserTypeBase.isUserData2Dirty();
            }
            case 10: {
                return pSDCOrgSecUserTypeBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCOrgSecUserTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCOrgSecUserTypeBase pSDCOrgSecUserTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCOrgSecUserTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCOrgSecUserTypeBase.getJSONValue((Object)pSDCOrgSecUserTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCOrgSecUserTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCOrgSecUserTypeBase.getJSONValue((Object)pSDCOrgSecUserTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCOrgSecUserTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDCOrgSecUserTypeBase.getJSONValue((Object)pSDCOrgSecUserTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSDCOrgSecUserTypeBase.getPSDCOrgSecUserTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcorgsecusertypeid", (Object)PSDCOrgSecUserTypeBase.getJSONValue((Object)pSDCOrgSecUserTypeBase.getPSDCOrgSecUserTypeId()), (boolean)false);
        }
        if (bl || pSDCOrgSecUserTypeBase.getPSDCOrgSecUserTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcorgsecusertypename", (Object)PSDCOrgSecUserTypeBase.getJSONValue((Object)pSDCOrgSecUserTypeBase.getPSDCOrgSecUserTypeName()), (boolean)false);
        }
        if (bl || pSDCOrgSecUserTypeBase.getRealId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"realid", (Object)PSDCOrgSecUserTypeBase.getJSONValue((Object)pSDCOrgSecUserTypeBase.getRealId()), (boolean)false);
        }
        if (bl || pSDCOrgSecUserTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCOrgSecUserTypeBase.getJSONValue((Object)pSDCOrgSecUserTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCOrgSecUserTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCOrgSecUserTypeBase.getJSONValue((Object)pSDCOrgSecUserTypeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDCOrgSecUserTypeBase.getUserData() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userdata", (Object)PSDCOrgSecUserTypeBase.getJSONValue((Object)pSDCOrgSecUserTypeBase.getUserData()), (boolean)false);
        }
        if (bl || pSDCOrgSecUserTypeBase.getUserData2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userdata2", (Object)PSDCOrgSecUserTypeBase.getJSONValue((Object)pSDCOrgSecUserTypeBase.getUserData2()), (boolean)false);
        }
        if (bl || pSDCOrgSecUserTypeBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDCOrgSecUserTypeBase.getJSONValue((Object)pSDCOrgSecUserTypeBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCOrgSecUserTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCOrgSecUserTypeBase pSDCOrgSecUserTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCOrgSecUserTypeBase.getCreateDate() != null) {
            object = pSDCOrgSecUserTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCOrgSecUserTypeBase.getCreateMan() != null) {
            object = pSDCOrgSecUserTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCOrgSecUserTypeBase.getMemo() != null) {
            object = pSDCOrgSecUserTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDCOrgSecUserTypeBase.getPSDCOrgSecUserTypeId() != null) {
            object = pSDCOrgSecUserTypeBase.getPSDCOrgSecUserTypeId();
            xmlNode.setAttribute(FIELD_PSDCORGSECUSERTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSDCOrgSecUserTypeBase.getPSDCOrgSecUserTypeName() != null) {
            object = pSDCOrgSecUserTypeBase.getPSDCOrgSecUserTypeName();
            xmlNode.setAttribute(FIELD_PSDCORGSECUSERTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCOrgSecUserTypeBase.getRealId() != null) {
            object = pSDCOrgSecUserTypeBase.getRealId();
            xmlNode.setAttribute(FIELD_REALID, object == null ? "" : (String)object);
        }
        if (bl || pSDCOrgSecUserTypeBase.getUpdateDate() != null) {
            object = pSDCOrgSecUserTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCOrgSecUserTypeBase.getUpdateMan() != null) {
            object = pSDCOrgSecUserTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCOrgSecUserTypeBase.getUserData() != null) {
            object = pSDCOrgSecUserTypeBase.getUserData();
            xmlNode.setAttribute(FIELD_USERDATA, object == null ? "" : (String)object);
        }
        if (bl || pSDCOrgSecUserTypeBase.getUserData2() != null) {
            object = pSDCOrgSecUserTypeBase.getUserData2();
            xmlNode.setAttribute(FIELD_USERDATA2, object == null ? "" : (String)object);
        }
        if (bl || pSDCOrgSecUserTypeBase.getValidFlag() != null) {
            object = pSDCOrgSecUserTypeBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCOrgSecUserTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCOrgSecUserTypeBase pSDCOrgSecUserTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCOrgSecUserTypeBase.isCreateDateDirty() && (bl || pSDCOrgSecUserTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCOrgSecUserTypeBase.getCreateDate());
        }
        if (pSDCOrgSecUserTypeBase.isCreateManDirty() && (bl || pSDCOrgSecUserTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCOrgSecUserTypeBase.getCreateMan());
        }
        if (pSDCOrgSecUserTypeBase.isMemoDirty() && (bl || pSDCOrgSecUserTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDCOrgSecUserTypeBase.getMemo());
        }
        if (pSDCOrgSecUserTypeBase.isPSDCOrgSecUserTypeIdDirty() && (bl || pSDCOrgSecUserTypeBase.getPSDCOrgSecUserTypeId() != null)) {
            iDataObject.set(FIELD_PSDCORGSECUSERTYPEID, (Object)pSDCOrgSecUserTypeBase.getPSDCOrgSecUserTypeId());
        }
        if (pSDCOrgSecUserTypeBase.isPSDCOrgSecUserTypeNameDirty() && (bl || pSDCOrgSecUserTypeBase.getPSDCOrgSecUserTypeName() != null)) {
            iDataObject.set(FIELD_PSDCORGSECUSERTYPENAME, (Object)pSDCOrgSecUserTypeBase.getPSDCOrgSecUserTypeName());
        }
        if (pSDCOrgSecUserTypeBase.isRealIdDirty() && (bl || pSDCOrgSecUserTypeBase.getRealId() != null)) {
            iDataObject.set(FIELD_REALID, (Object)pSDCOrgSecUserTypeBase.getRealId());
        }
        if (pSDCOrgSecUserTypeBase.isUpdateDateDirty() && (bl || pSDCOrgSecUserTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCOrgSecUserTypeBase.getUpdateDate());
        }
        if (pSDCOrgSecUserTypeBase.isUpdateManDirty() && (bl || pSDCOrgSecUserTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCOrgSecUserTypeBase.getUpdateMan());
        }
        if (pSDCOrgSecUserTypeBase.isUserDataDirty() && (bl || pSDCOrgSecUserTypeBase.getUserData() != null)) {
            iDataObject.set(FIELD_USERDATA, (Object)pSDCOrgSecUserTypeBase.getUserData());
        }
        if (pSDCOrgSecUserTypeBase.isUserData2Dirty() && (bl || pSDCOrgSecUserTypeBase.getUserData2() != null)) {
            iDataObject.set(FIELD_USERDATA2, (Object)pSDCOrgSecUserTypeBase.getUserData2());
        }
        if (pSDCOrgSecUserTypeBase.isValidFlagDirty() && (bl || pSDCOrgSecUserTypeBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDCOrgSecUserTypeBase.getValidFlag());
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
        return PSDCOrgSecUserTypeBase.remove(this, n);
    }

    private static boolean remove(PSDCOrgSecUserTypeBase pSDCOrgSecUserTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCOrgSecUserTypeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDCOrgSecUserTypeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDCOrgSecUserTypeBase.resetMemo();
                return true;
            }
            case 3: {
                pSDCOrgSecUserTypeBase.resetPSDCOrgSecUserTypeId();
                return true;
            }
            case 4: {
                pSDCOrgSecUserTypeBase.resetPSDCOrgSecUserTypeName();
                return true;
            }
            case 5: {
                pSDCOrgSecUserTypeBase.resetRealId();
                return true;
            }
            case 6: {
                pSDCOrgSecUserTypeBase.resetUpdateDate();
                return true;
            }
            case 7: {
                pSDCOrgSecUserTypeBase.resetUpdateMan();
                return true;
            }
            case 8: {
                pSDCOrgSecUserTypeBase.resetUserData();
                return true;
            }
            case 9: {
                pSDCOrgSecUserTypeBase.resetUserData2();
                return true;
            }
            case 10: {
                pSDCOrgSecUserTypeBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSDCOrgSecUserTypeBase getProxyEntity() {
        return this.proxyPSDCOrgSecUserTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCOrgSecUserTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCOrgSecUserTypeBase) {
            this.proxyPSDCOrgSecUserTypeBase = (PSDCOrgSecUserTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSDCOrgSecUserTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSDCORGSECUSERTYPEID, 3);
        fieldIndexMap.put(FIELD_PSDCORGSECUSERTYPENAME, 4);
        fieldIndexMap.put(FIELD_REALID, 5);
        fieldIndexMap.put(FIELD_UPDATEDATE, 6);
        fieldIndexMap.put(FIELD_UPDATEMAN, 7);
        fieldIndexMap.put(FIELD_USERDATA, 8);
        fieldIndexMap.put(FIELD_USERDATA2, 9);
        fieldIndexMap.put(FIELD_VALIDFLAG, 10);
    }
}

