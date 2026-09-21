/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.psrt.srv.common.entity;

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

public abstract class DEDataChgDispBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(DEDataChgDispBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEDATACHGDISPID = "DEDATACHGDISPID";
    public static final String FIELD_DEDATACHGDISPNAME = "DEDATACHGDISPNAME";
    public static final String FIELD_ENGINEOBJECT = "ENGINEOBJECT";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERFLAG = "ORDERFLAG";
    public static final String FIELD_RESERVER = "RESERVER";
    public static final String FIELD_RESERVER2 = "RESERVER2";
    public static final String FIELD_RESERVER3 = "RESERVER3";
    public static final String FIELD_RESERVER4 = "RESERVER4";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DEDATACHGDISPID = 2;
    private static final int INDEX_DEDATACHGDISPNAME = 3;
    private static final int INDEX_ENGINEOBJECT = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_ORDERFLAG = 6;
    private static final int INDEX_RESERVER = 7;
    private static final int INDEX_RESERVER2 = 8;
    private static final int INDEX_RESERVER3 = 9;
    private static final int INDEX_RESERVER4 = 10;
    private static final int INDEX_UPDATEDATE = 11;
    private static final int INDEX_UPDATEMAN = 12;
    private static final int INDEX_VALIDFLAG = 13;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private DEDataChgDispBase proxyDEDataChgDispBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dedatachgdispidDirtyFlag = false;
    private boolean dedatachgdispnameDirtyFlag = false;
    private boolean engineobjectDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean orderflagDirtyFlag = false;
    private boolean reserverDirtyFlag = false;
    private boolean reserver2DirtyFlag = false;
    private boolean reserver3DirtyFlag = false;
    private boolean reserver4DirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dedatachgdispid")
    private String dedatachgdispid;
    @Column(name="dedatachgdispname")
    private String dedatachgdispname;
    @Column(name="engineobject")
    private String engineobject;
    @Column(name="memo")
    private String memo;
    @Column(name="orderflag")
    private Integer orderflag;
    @Column(name="reserver")
    private String reserver;
    @Column(name="reserver2")
    private String reserver2;
    @Column(name="reserver3")
    private String reserver3;
    @Column(name="reserver4")
    private String reserver4;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DEDATACHGDISPID, 2);
        fieldIndexMap.put(FIELD_DEDATACHGDISPNAME, 3);
        fieldIndexMap.put(FIELD_ENGINEOBJECT, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_ORDERFLAG, 6);
        fieldIndexMap.put(FIELD_RESERVER, 7);
        fieldIndexMap.put(FIELD_RESERVER2, 8);
        fieldIndexMap.put(FIELD_RESERVER3, 9);
        fieldIndexMap.put(FIELD_RESERVER4, 10);
        fieldIndexMap.put(FIELD_UPDATEDATE, 11);
        fieldIndexMap.put(FIELD_UPDATEMAN, 12);
        fieldIndexMap.put(FIELD_VALIDFLAG, 13);
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

    public void setDEDataChgDispId(String dedatachgdispid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEDataChgDispId(dedatachgdispid);
            return;
        }
        if (dedatachgdispid != null && (dedatachgdispid = StringHelper.trimRight(dedatachgdispid)).length() == 0) {
            dedatachgdispid = null;
        }
        this.dedatachgdispid = dedatachgdispid;
        this.dedatachgdispidDirtyFlag = true;
    }

    public String getDEDataChgDispId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEDataChgDispId();
        }
        return this.dedatachgdispid;
    }

    public boolean isDEDataChgDispIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEDataChgDispIdDirty();
        }
        return this.dedatachgdispidDirtyFlag;
    }

    public void resetDEDataChgDispId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEDataChgDispId();
            return;
        }
        this.dedatachgdispidDirtyFlag = false;
        this.dedatachgdispid = null;
    }

    public void setDEDataChgDispName(String dedatachgdispname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEDataChgDispName(dedatachgdispname);
            return;
        }
        if (dedatachgdispname != null && (dedatachgdispname = StringHelper.trimRight(dedatachgdispname)).length() == 0) {
            dedatachgdispname = null;
        }
        this.dedatachgdispname = dedatachgdispname;
        this.dedatachgdispnameDirtyFlag = true;
    }

    public String getDEDataChgDispName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEDataChgDispName();
        }
        return this.dedatachgdispname;
    }

    public boolean isDEDataChgDispNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEDataChgDispNameDirty();
        }
        return this.dedatachgdispnameDirtyFlag;
    }

    public void resetDEDataChgDispName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEDataChgDispName();
            return;
        }
        this.dedatachgdispnameDirtyFlag = false;
        this.dedatachgdispname = null;
    }

    public void setEngineObject(String engineobject) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEngineObject(engineobject);
            return;
        }
        if (engineobject != null && (engineobject = StringHelper.trimRight(engineobject)).length() == 0) {
            engineobject = null;
        }
        this.engineobject = engineobject;
        this.engineobjectDirtyFlag = true;
    }

    public String getEngineObject() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEngineObject();
        }
        return this.engineobject;
    }

    public boolean isEngineObjectDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEngineObjectDirty();
        }
        return this.engineobjectDirtyFlag;
    }

    public void resetEngineObject() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEngineObject();
            return;
        }
        this.engineobjectDirtyFlag = false;
        this.engineobject = null;
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

    public void setOrderFlag(Integer orderflag) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOrderFlag(orderflag);
            return;
        }
        this.orderflag = orderflag;
        this.orderflagDirtyFlag = true;
    }

    public Integer getOrderFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOrderFlag();
        }
        return this.orderflag;
    }

    public boolean isOrderFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOrderFlagDirty();
        }
        return this.orderflagDirtyFlag;
    }

    public void resetOrderFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOrderFlag();
            return;
        }
        this.orderflagDirtyFlag = false;
        this.orderflag = null;
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

    public void setReserver3(String reserver3) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver3(reserver3);
            return;
        }
        if (reserver3 != null && (reserver3 = StringHelper.trimRight(reserver3)).length() == 0) {
            reserver3 = null;
        }
        this.reserver3 = reserver3;
        this.reserver3DirtyFlag = true;
    }

    public String getReserver3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver3();
        }
        return this.reserver3;
    }

    public boolean isReserver3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserver3Dirty();
        }
        return this.reserver3DirtyFlag;
    }

    public void resetReserver3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver3();
            return;
        }
        this.reserver3DirtyFlag = false;
        this.reserver3 = null;
    }

    public void setReserver4(String reserver4) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver4(reserver4);
            return;
        }
        if (reserver4 != null && (reserver4 = StringHelper.trimRight(reserver4)).length() == 0) {
            reserver4 = null;
        }
        this.reserver4 = reserver4;
        this.reserver4DirtyFlag = true;
    }

    public String getReserver4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver4();
        }
        return this.reserver4;
    }

    public boolean isReserver4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserver4Dirty();
        }
        return this.reserver4DirtyFlag;
    }

    public void resetReserver4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver4();
            return;
        }
        this.reserver4DirtyFlag = false;
        this.reserver4 = null;
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

    @Override
    protected void onReset() {
        DEDataChgDispBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(DEDataChgDispBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetDEDataChgDispId();
        et.resetDEDataChgDispName();
        et.resetEngineObject();
        et.resetMemo();
        et.resetOrderFlag();
        et.resetReserver();
        et.resetReserver2();
        et.resetReserver3();
        et.resetReserver4();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetValidFlag();
    }

    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if (!bDirtyOnly || this.isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bDirtyOnly || this.isCreateManDirty()) {
            params.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bDirtyOnly || this.isDEDataChgDispIdDirty()) {
            params.put(FIELD_DEDATACHGDISPID, this.getDEDataChgDispId());
        }
        if (!bDirtyOnly || this.isDEDataChgDispNameDirty()) {
            params.put(FIELD_DEDATACHGDISPNAME, this.getDEDataChgDispName());
        }
        if (!bDirtyOnly || this.isEngineObjectDirty()) {
            params.put(FIELD_ENGINEOBJECT, this.getEngineObject());
        }
        if (!bDirtyOnly || this.isMemoDirty()) {
            params.put(FIELD_MEMO, this.getMemo());
        }
        if (!bDirtyOnly || this.isOrderFlagDirty()) {
            params.put(FIELD_ORDERFLAG, this.getOrderFlag());
        }
        if (!bDirtyOnly || this.isReserverDirty()) {
            params.put(FIELD_RESERVER, this.getReserver());
        }
        if (!bDirtyOnly || this.isReserver2Dirty()) {
            params.put(FIELD_RESERVER2, this.getReserver2());
        }
        if (!bDirtyOnly || this.isReserver3Dirty()) {
            params.put(FIELD_RESERVER3, this.getReserver3());
        }
        if (!bDirtyOnly || this.isReserver4Dirty()) {
            params.put(FIELD_RESERVER4, this.getReserver4());
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
        return DEDataChgDispBase.get(this, index);
    }

    private static Object get(DEDataChgDispBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate();
            }
            case 1: {
                return et.getCreateMan();
            }
            case 2: {
                return et.getDEDataChgDispId();
            }
            case 3: {
                return et.getDEDataChgDispName();
            }
            case 4: {
                return et.getEngineObject();
            }
            case 5: {
                return et.getMemo();
            }
            case 6: {
                return et.getOrderFlag();
            }
            case 7: {
                return et.getReserver();
            }
            case 8: {
                return et.getReserver2();
            }
            case 9: {
                return et.getReserver3();
            }
            case 10: {
                return et.getReserver4();
            }
            case 11: {
                return et.getUpdateDate();
            }
            case 12: {
                return et.getUpdateMan();
            }
            case 13: {
                return et.getValidFlag();
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
        DEDataChgDispBase.set(this, index, objValue);
    }

    private static void set(DEDataChgDispBase et, int index, Object obj) throws Exception {
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
                et.setDEDataChgDispId(DataObject.getStringValue(obj));
                return;
            }
            case 3: {
                et.setDEDataChgDispName(DataObject.getStringValue(obj));
                return;
            }
            case 4: {
                et.setEngineObject(DataObject.getStringValue(obj));
                return;
            }
            case 5: {
                et.setMemo(DataObject.getStringValue(obj));
                return;
            }
            case 6: {
                et.setOrderFlag(DataObject.getIntegerValue(obj));
                return;
            }
            case 7: {
                et.setReserver(DataObject.getStringValue(obj));
                return;
            }
            case 8: {
                et.setReserver2(DataObject.getStringValue(obj));
                return;
            }
            case 9: {
                et.setReserver3(DataObject.getStringValue(obj));
                return;
            }
            case 10: {
                et.setReserver4(DataObject.getStringValue(obj));
                return;
            }
            case 11: {
                et.setUpdateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 12: {
                et.setUpdateMan(DataObject.getStringValue(obj));
                return;
            }
            case 13: {
                et.setValidFlag(DataObject.getIntegerValue(obj));
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
        return DEDataChgDispBase.isNull(this, index);
    }

    private static boolean isNull(DEDataChgDispBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate() == null;
            }
            case 1: {
                return et.getCreateMan() == null;
            }
            case 2: {
                return et.getDEDataChgDispId() == null;
            }
            case 3: {
                return et.getDEDataChgDispName() == null;
            }
            case 4: {
                return et.getEngineObject() == null;
            }
            case 5: {
                return et.getMemo() == null;
            }
            case 6: {
                return et.getOrderFlag() == null;
            }
            case 7: {
                return et.getReserver() == null;
            }
            case 8: {
                return et.getReserver2() == null;
            }
            case 9: {
                return et.getReserver3() == null;
            }
            case 10: {
                return et.getReserver4() == null;
            }
            case 11: {
                return et.getUpdateDate() == null;
            }
            case 12: {
                return et.getUpdateMan() == null;
            }
            case 13: {
                return et.getValidFlag() == null;
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
        return DEDataChgDispBase.contains(this, index);
    }

    private static boolean contains(DEDataChgDispBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isCreateDateDirty();
            }
            case 1: {
                return et.isCreateManDirty();
            }
            case 2: {
                return et.isDEDataChgDispIdDirty();
            }
            case 3: {
                return et.isDEDataChgDispNameDirty();
            }
            case 4: {
                return et.isEngineObjectDirty();
            }
            case 5: {
                return et.isMemoDirty();
            }
            case 6: {
                return et.isOrderFlagDirty();
            }
            case 7: {
                return et.isReserverDirty();
            }
            case 8: {
                return et.isReserver2Dirty();
            }
            case 9: {
                return et.isReserver3Dirty();
            }
            case 10: {
                return et.isReserver4Dirty();
            }
            case 11: {
                return et.isUpdateDateDirty();
            }
            case 12: {
                return et.isUpdateManDirty();
            }
            case 13: {
                return et.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        DEDataChgDispBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(DEDataChgDispBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", DEDataChgDispBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", DEDataChgDispBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getDEDataChgDispId() != null) {
            JSONObjectHelper.put(json, "dedatachgdispid", DEDataChgDispBase.getJSONValue(et.getDEDataChgDispId()), false);
        }
        if (bIncEmpty || et.getDEDataChgDispName() != null) {
            JSONObjectHelper.put(json, "dedatachgdispname", DEDataChgDispBase.getJSONValue(et.getDEDataChgDispName()), false);
        }
        if (bIncEmpty || et.getEngineObject() != null) {
            JSONObjectHelper.put(json, "engineobject", DEDataChgDispBase.getJSONValue(et.getEngineObject()), false);
        }
        if (bIncEmpty || et.getMemo() != null) {
            JSONObjectHelper.put(json, "memo", DEDataChgDispBase.getJSONValue(et.getMemo()), false);
        }
        if (bIncEmpty || et.getOrderFlag() != null) {
            JSONObjectHelper.put(json, "orderflag", DEDataChgDispBase.getJSONValue(et.getOrderFlag()), false);
        }
        if (bIncEmpty || et.getReserver() != null) {
            JSONObjectHelper.put(json, "reserver", DEDataChgDispBase.getJSONValue(et.getReserver()), false);
        }
        if (bIncEmpty || et.getReserver2() != null) {
            JSONObjectHelper.put(json, "reserver2", DEDataChgDispBase.getJSONValue(et.getReserver2()), false);
        }
        if (bIncEmpty || et.getReserver3() != null) {
            JSONObjectHelper.put(json, "reserver3", DEDataChgDispBase.getJSONValue(et.getReserver3()), false);
        }
        if (bIncEmpty || et.getReserver4() != null) {
            JSONObjectHelper.put(json, "reserver4", DEDataChgDispBase.getJSONValue(et.getReserver4()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", DEDataChgDispBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", DEDataChgDispBase.getJSONValue(et.getUpdateMan()), false);
        }
        if (bIncEmpty || et.getValidFlag() != null) {
            JSONObjectHelper.put(json, "validflag", DEDataChgDispBase.getJSONValue(et.getValidFlag()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        DEDataChgDispBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(DEDataChgDispBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getCreateDate() != null) {
            obj = et.getCreateDate();
            node.setAttribute(FIELD_CREATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            obj = et.getCreateMan();
            node.setAttribute(FIELD_CREATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDEDataChgDispId() != null) {
            obj = et.getDEDataChgDispId();
            node.setAttribute(FIELD_DEDATACHGDISPID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDEDataChgDispName() != null) {
            obj = et.getDEDataChgDispName();
            node.setAttribute(FIELD_DEDATACHGDISPNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getEngineObject() != null) {
            obj = et.getEngineObject();
            node.setAttribute(FIELD_ENGINEOBJECT, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getMemo() != null) {
            obj = et.getMemo();
            node.setAttribute(FIELD_MEMO, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getOrderFlag() != null) {
            obj = et.getOrderFlag();
            node.setAttribute(FIELD_ORDERFLAG, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getReserver() != null) {
            obj = et.getReserver();
            node.setAttribute(FIELD_RESERVER, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getReserver2() != null) {
            obj = et.getReserver2();
            node.setAttribute(FIELD_RESERVER2, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getReserver3() != null) {
            obj = et.getReserver3();
            node.setAttribute(FIELD_RESERVER3, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getReserver4() != null) {
            obj = et.getReserver4();
            node.setAttribute(FIELD_RESERVER4, obj == null ? "" : (String)obj);
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
    }

    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        DEDataChgDispBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(DEDataChgDispBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isCreateDateDirty() && (bIncEmpty || et.getCreateDate() != null)) {
            dst.set(FIELD_CREATEDATE, et.getCreateDate());
        }
        if (et.isCreateManDirty() && (bIncEmpty || et.getCreateMan() != null)) {
            dst.set(FIELD_CREATEMAN, et.getCreateMan());
        }
        if (et.isDEDataChgDispIdDirty() && (bIncEmpty || et.getDEDataChgDispId() != null)) {
            dst.set(FIELD_DEDATACHGDISPID, et.getDEDataChgDispId());
        }
        if (et.isDEDataChgDispNameDirty() && (bIncEmpty || et.getDEDataChgDispName() != null)) {
            dst.set(FIELD_DEDATACHGDISPNAME, et.getDEDataChgDispName());
        }
        if (et.isEngineObjectDirty() && (bIncEmpty || et.getEngineObject() != null)) {
            dst.set(FIELD_ENGINEOBJECT, et.getEngineObject());
        }
        if (et.isMemoDirty() && (bIncEmpty || et.getMemo() != null)) {
            dst.set(FIELD_MEMO, et.getMemo());
        }
        if (et.isOrderFlagDirty() && (bIncEmpty || et.getOrderFlag() != null)) {
            dst.set(FIELD_ORDERFLAG, et.getOrderFlag());
        }
        if (et.isReserverDirty() && (bIncEmpty || et.getReserver() != null)) {
            dst.set(FIELD_RESERVER, et.getReserver());
        }
        if (et.isReserver2Dirty() && (bIncEmpty || et.getReserver2() != null)) {
            dst.set(FIELD_RESERVER2, et.getReserver2());
        }
        if (et.isReserver3Dirty() && (bIncEmpty || et.getReserver3() != null)) {
            dst.set(FIELD_RESERVER3, et.getReserver3());
        }
        if (et.isReserver4Dirty() && (bIncEmpty || et.getReserver4() != null)) {
            dst.set(FIELD_RESERVER4, et.getReserver4());
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
        return DEDataChgDispBase.remove(this, index);
    }

    private static boolean remove(DEDataChgDispBase et, int index) throws Exception {
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
                et.resetDEDataChgDispId();
                return true;
            }
            case 3: {
                et.resetDEDataChgDispName();
                return true;
            }
            case 4: {
                et.resetEngineObject();
                return true;
            }
            case 5: {
                et.resetMemo();
                return true;
            }
            case 6: {
                et.resetOrderFlag();
                return true;
            }
            case 7: {
                et.resetReserver();
                return true;
            }
            case 8: {
                et.resetReserver2();
                return true;
            }
            case 9: {
                et.resetReserver3();
                return true;
            }
            case 10: {
                et.resetReserver4();
                return true;
            }
            case 11: {
                et.resetUpdateDate();
                return true;
            }
            case 12: {
                et.resetUpdateMan();
                return true;
            }
            case 13: {
                et.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private DEDataChgDispBase getProxyEntity() {
        return this.proxyDEDataChgDispBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyDEDataChgDispBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof DEDataChgDispBase) {
            this.proxyDEDataChgDispBase = (DEDataChgDispBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.DEDataChgDispService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

