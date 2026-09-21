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

public abstract class TSSDEngineBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(TSSDEngineBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ENGINEOBJECT = "ENGINEOBJECT";
    public static final String FIELD_ENGINEPARAM = "ENGINEPARAM";
    public static final String FIELD_RESERVER = "RESERVER";
    public static final String FIELD_RESERVER2 = "RESERVER2";
    public static final String FIELD_RESERVER3 = "RESERVER3";
    public static final String FIELD_RESERVER4 = "RESERVER4";
    public static final String FIELD_TSSDENGINEID = "TSSDENGINEID";
    public static final String FIELD_TSSDENGINENAME = "TSSDENGINENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_ENGINEOBJECT = 2;
    private static final int INDEX_ENGINEPARAM = 3;
    private static final int INDEX_RESERVER = 4;
    private static final int INDEX_RESERVER2 = 5;
    private static final int INDEX_RESERVER3 = 6;
    private static final int INDEX_RESERVER4 = 7;
    private static final int INDEX_TSSDENGINEID = 8;
    private static final int INDEX_TSSDENGINENAME = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private TSSDEngineBase proxyTSSDEngineBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean engineobjectDirtyFlag = false;
    private boolean engineparamDirtyFlag = false;
    private boolean reserverDirtyFlag = false;
    private boolean reserver2DirtyFlag = false;
    private boolean reserver3DirtyFlag = false;
    private boolean reserver4DirtyFlag = false;
    private boolean tssdengineidDirtyFlag = false;
    private boolean tssdenginenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="engineobject")
    private String engineobject;
    @Column(name="engineparam")
    private String engineparam;
    @Column(name="reserver")
    private String reserver;
    @Column(name="reserver2")
    private String reserver2;
    @Column(name="reserver3")
    private String reserver3;
    @Column(name="reserver4")
    private String reserver4;
    @Column(name="tssdengineid")
    private String tssdengineid;
    @Column(name="tssdenginename")
    private String tssdenginename;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_ENGINEOBJECT, 2);
        fieldIndexMap.put(FIELD_ENGINEPARAM, 3);
        fieldIndexMap.put(FIELD_RESERVER, 4);
        fieldIndexMap.put(FIELD_RESERVER2, 5);
        fieldIndexMap.put(FIELD_RESERVER3, 6);
        fieldIndexMap.put(FIELD_RESERVER4, 7);
        fieldIndexMap.put(FIELD_TSSDENGINEID, 8);
        fieldIndexMap.put(FIELD_TSSDENGINENAME, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
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

    public void setEngineParam(String engineparam) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEngineParam(engineparam);
            return;
        }
        if (engineparam != null && (engineparam = StringHelper.trimRight(engineparam)).length() == 0) {
            engineparam = null;
        }
        this.engineparam = engineparam;
        this.engineparamDirtyFlag = true;
    }

    public String getEngineParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEngineParam();
        }
        return this.engineparam;
    }

    public boolean isEngineParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEngineParamDirty();
        }
        return this.engineparamDirtyFlag;
    }

    public void resetEngineParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEngineParam();
            return;
        }
        this.engineparamDirtyFlag = false;
        this.engineparam = null;
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

    public void setTSSDEngineId(String tssdengineid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTSSDEngineId(tssdengineid);
            return;
        }
        if (tssdengineid != null && (tssdengineid = StringHelper.trimRight(tssdengineid)).length() == 0) {
            tssdengineid = null;
        }
        this.tssdengineid = tssdengineid;
        this.tssdengineidDirtyFlag = true;
    }

    public String getTSSDEngineId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTSSDEngineId();
        }
        return this.tssdengineid;
    }

    public boolean isTSSDEngineIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTSSDEngineIdDirty();
        }
        return this.tssdengineidDirtyFlag;
    }

    public void resetTSSDEngineId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTSSDEngineId();
            return;
        }
        this.tssdengineidDirtyFlag = false;
        this.tssdengineid = null;
    }

    public void setTSSDEngineName(String tssdenginename) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTSSDEngineName(tssdenginename);
            return;
        }
        if (tssdenginename != null && (tssdenginename = StringHelper.trimRight(tssdenginename)).length() == 0) {
            tssdenginename = null;
        }
        this.tssdenginename = tssdenginename;
        this.tssdenginenameDirtyFlag = true;
    }

    public String getTSSDEngineName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTSSDEngineName();
        }
        return this.tssdenginename;
    }

    public boolean isTSSDEngineNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTSSDEngineNameDirty();
        }
        return this.tssdenginenameDirtyFlag;
    }

    public void resetTSSDEngineName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTSSDEngineName();
            return;
        }
        this.tssdenginenameDirtyFlag = false;
        this.tssdenginename = null;
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

    @Override
    protected void onReset() {
        TSSDEngineBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(TSSDEngineBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetEngineObject();
        et.resetEngineParam();
        et.resetReserver();
        et.resetReserver2();
        et.resetReserver3();
        et.resetReserver4();
        et.resetTSSDEngineId();
        et.resetTSSDEngineName();
        et.resetUpdateDate();
        et.resetUpdateMan();
    }

    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if (!bDirtyOnly || this.isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bDirtyOnly || this.isCreateManDirty()) {
            params.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bDirtyOnly || this.isEngineObjectDirty()) {
            params.put(FIELD_ENGINEOBJECT, this.getEngineObject());
        }
        if (!bDirtyOnly || this.isEngineParamDirty()) {
            params.put(FIELD_ENGINEPARAM, this.getEngineParam());
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
        if (!bDirtyOnly || this.isTSSDEngineIdDirty()) {
            params.put(FIELD_TSSDENGINEID, this.getTSSDEngineId());
        }
        if (!bDirtyOnly || this.isTSSDEngineNameDirty()) {
            params.put(FIELD_TSSDENGINENAME, this.getTSSDEngineName());
        }
        if (!bDirtyOnly || this.isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bDirtyOnly || this.isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN, this.getUpdateMan());
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
        return TSSDEngineBase.get(this, index);
    }

    private static Object get(TSSDEngineBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate();
            }
            case 1: {
                return et.getCreateMan();
            }
            case 2: {
                return et.getEngineObject();
            }
            case 3: {
                return et.getEngineParam();
            }
            case 4: {
                return et.getReserver();
            }
            case 5: {
                return et.getReserver2();
            }
            case 6: {
                return et.getReserver3();
            }
            case 7: {
                return et.getReserver4();
            }
            case 8: {
                return et.getTSSDEngineId();
            }
            case 9: {
                return et.getTSSDEngineName();
            }
            case 10: {
                return et.getUpdateDate();
            }
            case 11: {
                return et.getUpdateMan();
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
        TSSDEngineBase.set(this, index, objValue);
    }

    private static void set(TSSDEngineBase et, int index, Object obj) throws Exception {
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
                et.setEngineObject(DataObject.getStringValue(obj));
                return;
            }
            case 3: {
                et.setEngineParam(DataObject.getStringValue(obj));
                return;
            }
            case 4: {
                et.setReserver(DataObject.getStringValue(obj));
                return;
            }
            case 5: {
                et.setReserver2(DataObject.getStringValue(obj));
                return;
            }
            case 6: {
                et.setReserver3(DataObject.getStringValue(obj));
                return;
            }
            case 7: {
                et.setReserver4(DataObject.getStringValue(obj));
                return;
            }
            case 8: {
                et.setTSSDEngineId(DataObject.getStringValue(obj));
                return;
            }
            case 9: {
                et.setTSSDEngineName(DataObject.getStringValue(obj));
                return;
            }
            case 10: {
                et.setUpdateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 11: {
                et.setUpdateMan(DataObject.getStringValue(obj));
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
        return TSSDEngineBase.isNull(this, index);
    }

    private static boolean isNull(TSSDEngineBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate() == null;
            }
            case 1: {
                return et.getCreateMan() == null;
            }
            case 2: {
                return et.getEngineObject() == null;
            }
            case 3: {
                return et.getEngineParam() == null;
            }
            case 4: {
                return et.getReserver() == null;
            }
            case 5: {
                return et.getReserver2() == null;
            }
            case 6: {
                return et.getReserver3() == null;
            }
            case 7: {
                return et.getReserver4() == null;
            }
            case 8: {
                return et.getTSSDEngineId() == null;
            }
            case 9: {
                return et.getTSSDEngineName() == null;
            }
            case 10: {
                return et.getUpdateDate() == null;
            }
            case 11: {
                return et.getUpdateMan() == null;
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
        return TSSDEngineBase.contains(this, index);
    }

    private static boolean contains(TSSDEngineBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isCreateDateDirty();
            }
            case 1: {
                return et.isCreateManDirty();
            }
            case 2: {
                return et.isEngineObjectDirty();
            }
            case 3: {
                return et.isEngineParamDirty();
            }
            case 4: {
                return et.isReserverDirty();
            }
            case 5: {
                return et.isReserver2Dirty();
            }
            case 6: {
                return et.isReserver3Dirty();
            }
            case 7: {
                return et.isReserver4Dirty();
            }
            case 8: {
                return et.isTSSDEngineIdDirty();
            }
            case 9: {
                return et.isTSSDEngineNameDirty();
            }
            case 10: {
                return et.isUpdateDateDirty();
            }
            case 11: {
                return et.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        TSSDEngineBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(TSSDEngineBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", TSSDEngineBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", TSSDEngineBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getEngineObject() != null) {
            JSONObjectHelper.put(json, "engineobject", TSSDEngineBase.getJSONValue(et.getEngineObject()), false);
        }
        if (bIncEmpty || et.getEngineParam() != null) {
            JSONObjectHelper.put(json, "engineparam", TSSDEngineBase.getJSONValue(et.getEngineParam()), false);
        }
        if (bIncEmpty || et.getReserver() != null) {
            JSONObjectHelper.put(json, "reserver", TSSDEngineBase.getJSONValue(et.getReserver()), false);
        }
        if (bIncEmpty || et.getReserver2() != null) {
            JSONObjectHelper.put(json, "reserver2", TSSDEngineBase.getJSONValue(et.getReserver2()), false);
        }
        if (bIncEmpty || et.getReserver3() != null) {
            JSONObjectHelper.put(json, "reserver3", TSSDEngineBase.getJSONValue(et.getReserver3()), false);
        }
        if (bIncEmpty || et.getReserver4() != null) {
            JSONObjectHelper.put(json, "reserver4", TSSDEngineBase.getJSONValue(et.getReserver4()), false);
        }
        if (bIncEmpty || et.getTSSDEngineId() != null) {
            JSONObjectHelper.put(json, "tssdengineid", TSSDEngineBase.getJSONValue(et.getTSSDEngineId()), false);
        }
        if (bIncEmpty || et.getTSSDEngineName() != null) {
            JSONObjectHelper.put(json, "tssdenginename", TSSDEngineBase.getJSONValue(et.getTSSDEngineName()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", TSSDEngineBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", TSSDEngineBase.getJSONValue(et.getUpdateMan()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        TSSDEngineBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(TSSDEngineBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getCreateDate() != null) {
            obj = et.getCreateDate();
            node.setAttribute(FIELD_CREATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            obj = et.getCreateMan();
            node.setAttribute(FIELD_CREATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getEngineObject() != null) {
            obj = et.getEngineObject();
            node.setAttribute(FIELD_ENGINEOBJECT, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getEngineParam() != null) {
            obj = et.getEngineParam();
            node.setAttribute(FIELD_ENGINEPARAM, obj == null ? "" : (String)obj);
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
        if (bIncEmpty || et.getTSSDEngineId() != null) {
            obj = et.getTSSDEngineId();
            node.setAttribute(FIELD_TSSDENGINEID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getTSSDEngineName() != null) {
            obj = et.getTSSDEngineName();
            node.setAttribute(FIELD_TSSDENGINENAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            obj = et.getUpdateDate();
            node.setAttribute(FIELD_UPDATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            obj = et.getUpdateMan();
            node.setAttribute(FIELD_UPDATEMAN, obj == null ? "" : (String)obj);
        }
    }

    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        TSSDEngineBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(TSSDEngineBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isCreateDateDirty() && (bIncEmpty || et.getCreateDate() != null)) {
            dst.set(FIELD_CREATEDATE, et.getCreateDate());
        }
        if (et.isCreateManDirty() && (bIncEmpty || et.getCreateMan() != null)) {
            dst.set(FIELD_CREATEMAN, et.getCreateMan());
        }
        if (et.isEngineObjectDirty() && (bIncEmpty || et.getEngineObject() != null)) {
            dst.set(FIELD_ENGINEOBJECT, et.getEngineObject());
        }
        if (et.isEngineParamDirty() && (bIncEmpty || et.getEngineParam() != null)) {
            dst.set(FIELD_ENGINEPARAM, et.getEngineParam());
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
        if (et.isTSSDEngineIdDirty() && (bIncEmpty || et.getTSSDEngineId() != null)) {
            dst.set(FIELD_TSSDENGINEID, et.getTSSDEngineId());
        }
        if (et.isTSSDEngineNameDirty() && (bIncEmpty || et.getTSSDEngineName() != null)) {
            dst.set(FIELD_TSSDENGINENAME, et.getTSSDEngineName());
        }
        if (et.isUpdateDateDirty() && (bIncEmpty || et.getUpdateDate() != null)) {
            dst.set(FIELD_UPDATEDATE, et.getUpdateDate());
        }
        if (et.isUpdateManDirty() && (bIncEmpty || et.getUpdateMan() != null)) {
            dst.set(FIELD_UPDATEMAN, et.getUpdateMan());
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
        return TSSDEngineBase.remove(this, index);
    }

    private static boolean remove(TSSDEngineBase et, int index) throws Exception {
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
                et.resetEngineObject();
                return true;
            }
            case 3: {
                et.resetEngineParam();
                return true;
            }
            case 4: {
                et.resetReserver();
                return true;
            }
            case 5: {
                et.resetReserver2();
                return true;
            }
            case 6: {
                et.resetReserver3();
                return true;
            }
            case 7: {
                et.resetReserver4();
                return true;
            }
            case 8: {
                et.resetTSSDEngineId();
                return true;
            }
            case 9: {
                et.resetTSSDEngineName();
                return true;
            }
            case 10: {
                et.resetUpdateDate();
                return true;
            }
            case 11: {
                et.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private TSSDEngineBase getProxyEntity() {
        return this.proxyTSSDEngineBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyTSSDEngineBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof TSSDEngineBase) {
            this.proxyTSSDEngineBase = (TSSDEngineBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.TSSDEngineService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

