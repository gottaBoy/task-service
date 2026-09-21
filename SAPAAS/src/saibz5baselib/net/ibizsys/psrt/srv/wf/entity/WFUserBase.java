/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.psrt.srv.wf.entity;

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

public abstract class WFUserBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(WFUserBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ISRECVWORK = "ISRECVWORK";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_RECVINFORM = "RECVINFORM";
    public static final String FIELD_RESERVER = "RESERVER";
    public static final String FIELD_RESERVER2 = "RESERVER2";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    public static final String FIELD_WFUSERID = "WFUSERID";
    public static final String FIELD_WFUSERNAME = "WFUSERNAME";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_ISRECVWORK = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_RECVINFORM = 4;
    private static final int INDEX_RESERVER = 5;
    private static final int INDEX_RESERVER2 = 6;
    private static final int INDEX_UPDATEDATE = 7;
    private static final int INDEX_UPDATEMAN = 8;
    private static final int INDEX_VALIDFLAG = 9;
    private static final int INDEX_WFUSERID = 10;
    private static final int INDEX_WFUSERNAME = 11;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private WFUserBase proxyWFUserBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean isrecvworkDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean recvinformDirtyFlag = false;
    private boolean reserverDirtyFlag = false;
    private boolean reserver2DirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    private boolean wfuseridDirtyFlag = false;
    private boolean wfusernameDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="isrecvwork")
    private Integer isrecvwork;
    @Column(name="memo")
    private String memo;
    @Column(name="recvinform")
    private Integer recvinform;
    @Column(name="reserver")
    private String reserver;
    @Column(name="reserver2")
    private String reserver2;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    @Column(name="wfuserid")
    private String wfuserid;
    @Column(name="wfusername")
    private String wfusername;

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_ISRECVWORK, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_RECVINFORM, 4);
        fieldIndexMap.put(FIELD_RESERVER, 5);
        fieldIndexMap.put(FIELD_RESERVER2, 6);
        fieldIndexMap.put(FIELD_UPDATEDATE, 7);
        fieldIndexMap.put(FIELD_UPDATEMAN, 8);
        fieldIndexMap.put(FIELD_VALIDFLAG, 9);
        fieldIndexMap.put(FIELD_WFUSERID, 10);
        fieldIndexMap.put(FIELD_WFUSERNAME, 11);
    }

    public void setCreateDate(Timestamp createdate) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateDate(createdate);
            return;
        }
        this.createdate = createdate;
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

    public void setCreateMan(String createman) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateMan(createman);
            return;
        }
        if (createman != null && (createman = StringHelper.trimRight(createman)).length() == 0) {
            createman = null;
        }
        this.createman = createman;
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

    public void setIsRecvWork(Integer isrecvwork) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIsRecvWork(isrecvwork);
            return;
        }
        this.isrecvwork = isrecvwork;
        this.isrecvworkDirtyFlag = true;
    }

    public Integer getIsRecvWork() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIsRecvWork();
        }
        return this.isrecvwork;
    }

    public boolean isIsRecvWorkDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIsRecvWorkDirty();
        }
        return this.isrecvworkDirtyFlag;
    }

    public void resetIsRecvWork() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIsRecvWork();
            return;
        }
        this.isrecvworkDirtyFlag = false;
        this.isrecvwork = null;
    }

    public void setMemo(String memo) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMemo(memo);
            return;
        }
        if (memo != null && (memo = StringHelper.trimRight(memo)).length() == 0) {
            memo = null;
        }
        this.memo = memo;
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

    public void setRecvInform(Integer recvinform) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRecvInform(recvinform);
            return;
        }
        this.recvinform = recvinform;
        this.recvinformDirtyFlag = true;
    }

    public Integer getRecvInform() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRecvInform();
        }
        return this.recvinform;
    }

    public boolean isRecvInformDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRecvInformDirty();
        }
        return this.recvinformDirtyFlag;
    }

    public void resetRecvInform() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRecvInform();
            return;
        }
        this.recvinformDirtyFlag = false;
        this.recvinform = null;
    }

    public void setReserver(String reserver) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver(reserver);
            return;
        }
        if (reserver != null && (reserver = StringHelper.trimRight(reserver)).length() == 0) {
            reserver = null;
        }
        this.reserver = reserver;
        this.reserverDirtyFlag = true;
    }

    public String getReserver() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver();
        }
        return this.reserver;
    }

    public boolean isReserverDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserverDirty();
        }
        return this.reserverDirtyFlag;
    }

    public void resetReserver() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver();
            return;
        }
        this.reserverDirtyFlag = false;
        this.reserver = null;
    }

    public void setReserver2(String reserver2) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver2(reserver2);
            return;
        }
        if (reserver2 != null && (reserver2 = StringHelper.trimRight(reserver2)).length() == 0) {
            reserver2 = null;
        }
        this.reserver2 = reserver2;
        this.reserver2DirtyFlag = true;
    }

    public String getReserver2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver2();
        }
        return this.reserver2;
    }

    public boolean isReserver2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserver2Dirty();
        }
        return this.reserver2DirtyFlag;
    }

    public void resetReserver2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver2();
            return;
        }
        this.reserver2DirtyFlag = false;
        this.reserver2 = null;
    }

    public void setUpdateDate(Timestamp updatedate) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateDate(updatedate);
            return;
        }
        this.updatedate = updatedate;
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

    public void setUpdateMan(String updateman) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateMan(updateman);
            return;
        }
        if (updateman != null && (updateman = StringHelper.trimRight(updateman)).length() == 0) {
            updateman = null;
        }
        this.updateman = updateman;
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

    public void setValidFlag(Integer validflag) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValidFlag(validflag);
            return;
        }
        this.validflag = validflag;
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

    public void setWFUserId(String wfuserid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFUserId(wfuserid);
            return;
        }
        if (wfuserid != null && (wfuserid = StringHelper.trimRight(wfuserid)).length() == 0) {
            wfuserid = null;
        }
        this.wfuserid = wfuserid;
        this.wfuseridDirtyFlag = true;
    }

    public String getWFUserId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFUserId();
        }
        return this.wfuserid;
    }

    public boolean isWFUserIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFUserIdDirty();
        }
        return this.wfuseridDirtyFlag;
    }

    public void resetWFUserId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFUserId();
            return;
        }
        this.wfuseridDirtyFlag = false;
        this.wfuserid = null;
    }

    public void setWFUserName(String wfusername) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFUserName(wfusername);
            return;
        }
        if (wfusername != null && (wfusername = StringHelper.trimRight(wfusername)).length() == 0) {
            wfusername = null;
        }
        this.wfusername = wfusername;
        this.wfusernameDirtyFlag = true;
    }

    public String getWFUserName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFUserName();
        }
        return this.wfusername;
    }

    public boolean isWFUserNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFUserNameDirty();
        }
        return this.wfusernameDirtyFlag;
    }

    public void resetWFUserName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFUserName();
            return;
        }
        this.wfusernameDirtyFlag = false;
        this.wfusername = null;
    }

    @Override
    protected void onReset() {
        WFUserBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(WFUserBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetIsRecvWork();
        et.resetMemo();
        et.resetRecvInform();
        et.resetReserver();
        et.resetReserver2();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetValidFlag();
        et.resetWFUserId();
        et.resetWFUserName();
    }

    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if (!bDirtyOnly || this.isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bDirtyOnly || this.isCreateManDirty()) {
            params.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bDirtyOnly || this.isIsRecvWorkDirty()) {
            params.put(FIELD_ISRECVWORK, this.getIsRecvWork());
        }
        if (!bDirtyOnly || this.isMemoDirty()) {
            params.put(FIELD_MEMO, this.getMemo());
        }
        if (!bDirtyOnly || this.isRecvInformDirty()) {
            params.put(FIELD_RECVINFORM, this.getRecvInform());
        }
        if (!bDirtyOnly || this.isReserverDirty()) {
            params.put(FIELD_RESERVER, this.getReserver());
        }
        if (!bDirtyOnly || this.isReserver2Dirty()) {
            params.put(FIELD_RESERVER2, this.getReserver2());
        }
        if (!bDirtyOnly || this.isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bDirtyOnly || this.isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bDirtyOnly || this.isValidFlagDirty()) {
            params.put(FIELD_VALIDFLAG, this.getValidFlag());
        }
        if (!bDirtyOnly || this.isWFUserIdDirty()) {
            params.put(FIELD_WFUSERID, this.getWFUserId());
        }
        if (!bDirtyOnly || this.isWFUserNameDirty()) {
            params.put(FIELD_WFUSERNAME, this.getWFUserName());
        }
        super.onFillMap(params, bDirtyOnly);
    }

    @Override
    public Object get(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().get(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.get(strParamName);
        }
        return WFUserBase.get(this, index);
    }

    private static Object get(WFUserBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate();
            }
            case 1: {
                return et.getCreateMan();
            }
            case 2: {
                return et.getIsRecvWork();
            }
            case 3: {
                return et.getMemo();
            }
            case 4: {
                return et.getRecvInform();
            }
            case 5: {
                return et.getReserver();
            }
            case 6: {
                return et.getReserver2();
            }
            case 7: {
                return et.getUpdateDate();
            }
            case 8: {
                return et.getUpdateMan();
            }
            case 9: {
                return et.getValidFlag();
            }
            case 10: {
                return et.getWFUserId();
            }
            case 11: {
                return et.getWFUserName();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    public void set(String strParamName, Object objValue) throws Exception {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().set(strParamName, objValue);
            return;
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            super.set(strParamName, objValue);
            return;
        }
        WFUserBase.set(this, index, objValue);
    }

    private static void set(WFUserBase et, int index, Object obj) throws Exception {
        switch (index) {
            case 0: {
                et.setCreateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 1: {
                et.setCreateMan(DataObject.getStringValue(obj));
                return;
            }
            case 2: {
                et.setIsRecvWork(DataObject.getIntegerValue(obj));
                return;
            }
            case 3: {
                et.setMemo(DataObject.getStringValue(obj));
                return;
            }
            case 4: {
                et.setRecvInform(DataObject.getIntegerValue(obj));
                return;
            }
            case 5: {
                et.setReserver(DataObject.getStringValue(obj));
                return;
            }
            case 6: {
                et.setReserver2(DataObject.getStringValue(obj));
                return;
            }
            case 7: {
                et.setUpdateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 8: {
                et.setUpdateMan(DataObject.getStringValue(obj));
                return;
            }
            case 9: {
                et.setValidFlag(DataObject.getIntegerValue(obj));
                return;
            }
            case 10: {
                et.setWFUserId(DataObject.getStringValue(obj));
                return;
            }
            case 11: {
                et.setWFUserName(DataObject.getStringValue(obj));
                return;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    public boolean isNull(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNull(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.isNull(strParamName);
        }
        return WFUserBase.isNull(this, index);
    }

    private static boolean isNull(WFUserBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate() == null;
            }
            case 1: {
                return et.getCreateMan() == null;
            }
            case 2: {
                return et.getIsRecvWork() == null;
            }
            case 3: {
                return et.getMemo() == null;
            }
            case 4: {
                return et.getRecvInform() == null;
            }
            case 5: {
                return et.getReserver() == null;
            }
            case 6: {
                return et.getReserver2() == null;
            }
            case 7: {
                return et.getUpdateDate() == null;
            }
            case 8: {
                return et.getUpdateMan() == null;
            }
            case 9: {
                return et.getValidFlag() == null;
            }
            case 10: {
                return et.getWFUserId() == null;
            }
            case 11: {
                return et.getWFUserName() == null;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    public boolean contains(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().contains(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.contains(strParamName);
        }
        return WFUserBase.contains(this, index);
    }

    private static boolean contains(WFUserBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isCreateDateDirty();
            }
            case 1: {
                return et.isCreateManDirty();
            }
            case 2: {
                return et.isIsRecvWorkDirty();
            }
            case 3: {
                return et.isMemoDirty();
            }
            case 4: {
                return et.isRecvInformDirty();
            }
            case 5: {
                return et.isReserverDirty();
            }
            case 6: {
                return et.isReserver2Dirty();
            }
            case 7: {
                return et.isUpdateDateDirty();
            }
            case 8: {
                return et.isUpdateManDirty();
            }
            case 9: {
                return et.isValidFlagDirty();
            }
            case 10: {
                return et.isWFUserIdDirty();
            }
            case 11: {
                return et.isWFUserNameDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        WFUserBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(WFUserBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", WFUserBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", WFUserBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getIsRecvWork() != null) {
            JSONObjectHelper.put(json, "isrecvwork", WFUserBase.getJSONValue(et.getIsRecvWork()), false);
        }
        if (bIncEmpty || et.getMemo() != null) {
            JSONObjectHelper.put(json, "memo", WFUserBase.getJSONValue(et.getMemo()), false);
        }
        if (bIncEmpty || et.getRecvInform() != null) {
            JSONObjectHelper.put(json, "recvinform", WFUserBase.getJSONValue(et.getRecvInform()), false);
        }
        if (bIncEmpty || et.getReserver() != null) {
            JSONObjectHelper.put(json, "reserver", WFUserBase.getJSONValue(et.getReserver()), false);
        }
        if (bIncEmpty || et.getReserver2() != null) {
            JSONObjectHelper.put(json, "reserver2", WFUserBase.getJSONValue(et.getReserver2()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", WFUserBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", WFUserBase.getJSONValue(et.getUpdateMan()), false);
        }
        if (bIncEmpty || et.getValidFlag() != null) {
            JSONObjectHelper.put(json, "validflag", WFUserBase.getJSONValue(et.getValidFlag()), false);
        }
        if (bIncEmpty || et.getWFUserId() != null) {
            JSONObjectHelper.put(json, "wfuserid", WFUserBase.getJSONValue(et.getWFUserId()), false);
        }
        if (bIncEmpty || et.getWFUserName() != null) {
            JSONObjectHelper.put(json, "wfusername", WFUserBase.getJSONValue(et.getWFUserName()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        WFUserBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(WFUserBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getCreateDate() != null) {
            obj = et.getCreateDate();
            node.setAttribute(FIELD_CREATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            obj = et.getCreateMan();
            node.setAttribute(FIELD_CREATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getIsRecvWork() != null) {
            obj = et.getIsRecvWork();
            node.setAttribute(FIELD_ISRECVWORK, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getMemo() != null) {
            obj = et.getMemo();
            node.setAttribute(FIELD_MEMO, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getRecvInform() != null) {
            obj = et.getRecvInform();
            node.setAttribute(FIELD_RECVINFORM, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getReserver() != null) {
            obj = et.getReserver();
            node.setAttribute(FIELD_RESERVER, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getReserver2() != null) {
            obj = et.getReserver2();
            node.setAttribute(FIELD_RESERVER2, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            obj = et.getUpdateDate();
            node.setAttribute(FIELD_UPDATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            obj = et.getUpdateMan();
            node.setAttribute(FIELD_UPDATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getValidFlag() != null) {
            obj = et.getValidFlag();
            node.setAttribute(FIELD_VALIDFLAG, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getWFUserId() != null) {
            obj = et.getWFUserId();
            node.setAttribute(FIELD_WFUSERID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFUserName() != null) {
            obj = et.getWFUserName();
            node.setAttribute(FIELD_WFUSERNAME, obj == null ? "" : (String)obj);
        }
    }

    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        WFUserBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(WFUserBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isCreateDateDirty() && (bIncEmpty || et.getCreateDate() != null)) {
            dst.set(FIELD_CREATEDATE, et.getCreateDate());
        }
        if (et.isCreateManDirty() && (bIncEmpty || et.getCreateMan() != null)) {
            dst.set(FIELD_CREATEMAN, et.getCreateMan());
        }
        if (et.isIsRecvWorkDirty() && (bIncEmpty || et.getIsRecvWork() != null)) {
            dst.set(FIELD_ISRECVWORK, et.getIsRecvWork());
        }
        if (et.isMemoDirty() && (bIncEmpty || et.getMemo() != null)) {
            dst.set(FIELD_MEMO, et.getMemo());
        }
        if (et.isRecvInformDirty() && (bIncEmpty || et.getRecvInform() != null)) {
            dst.set(FIELD_RECVINFORM, et.getRecvInform());
        }
        if (et.isReserverDirty() && (bIncEmpty || et.getReserver() != null)) {
            dst.set(FIELD_RESERVER, et.getReserver());
        }
        if (et.isReserver2Dirty() && (bIncEmpty || et.getReserver2() != null)) {
            dst.set(FIELD_RESERVER2, et.getReserver2());
        }
        if (et.isUpdateDateDirty() && (bIncEmpty || et.getUpdateDate() != null)) {
            dst.set(FIELD_UPDATEDATE, et.getUpdateDate());
        }
        if (et.isUpdateManDirty() && (bIncEmpty || et.getUpdateMan() != null)) {
            dst.set(FIELD_UPDATEMAN, et.getUpdateMan());
        }
        if (et.isValidFlagDirty() && (bIncEmpty || et.getValidFlag() != null)) {
            dst.set(FIELD_VALIDFLAG, et.getValidFlag());
        }
        if (et.isWFUserIdDirty() && (bIncEmpty || et.getWFUserId() != null)) {
            dst.set(FIELD_WFUSERID, et.getWFUserId());
        }
        if (et.isWFUserNameDirty() && (bIncEmpty || et.getWFUserName() != null)) {
            dst.set(FIELD_WFUSERNAME, et.getWFUserName());
        }
    }

    @Override
    public boolean remove(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().remove(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.remove(strParamName);
        }
        return WFUserBase.remove(this, index);
    }

    private static boolean remove(WFUserBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                et.resetCreateDate();
                return true;
            }
            case 1: {
                et.resetCreateMan();
                return true;
            }
            case 2: {
                et.resetIsRecvWork();
                return true;
            }
            case 3: {
                et.resetMemo();
                return true;
            }
            case 4: {
                et.resetRecvInform();
                return true;
            }
            case 5: {
                et.resetReserver();
                return true;
            }
            case 6: {
                et.resetReserver2();
                return true;
            }
            case 7: {
                et.resetUpdateDate();
                return true;
            }
            case 8: {
                et.resetUpdateMan();
                return true;
            }
            case 9: {
                et.resetValidFlag();
                return true;
            }
            case 10: {
                et.resetWFUserId();
                return true;
            }
            case 11: {
                et.resetWFUserName();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private WFUserBase getProxyEntity() {
        return this.proxyWFUserBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyWFUserBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof WFUserBase) {
            this.proxyWFUserBase = (WFUserBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.wf.service.WFUserService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

