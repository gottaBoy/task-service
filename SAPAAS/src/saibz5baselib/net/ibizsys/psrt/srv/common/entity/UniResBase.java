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

public abstract class UniResBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(UniResBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_RESERVER = "RESERVER";
    public static final String FIELD_RESERVER2 = "RESERVER2";
    public static final String FIELD_RESERVER3 = "RESERVER3";
    public static final String FIELD_RESERVER4 = "RESERVER4";
    public static final String FIELD_RESOURCEID = "RESOURCEID";
    public static final String FIELD_UNIRESID = "UNIRESID";
    public static final String FIELD_UNIRESNAME = "UNIRESNAME";
    public static final String FIELD_UNIRESTYPE = "UNIRESTYPE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_RESERVER = 3;
    private static final int INDEX_RESERVER2 = 4;
    private static final int INDEX_RESERVER3 = 5;
    private static final int INDEX_RESERVER4 = 6;
    private static final int INDEX_RESOURCEID = 7;
    private static final int INDEX_UNIRESID = 8;
    private static final int INDEX_UNIRESNAME = 9;
    private static final int INDEX_UNIRESTYPE = 10;
    private static final int INDEX_UPDATEDATE = 11;
    private static final int INDEX_UPDATEMAN = 12;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private UniResBase proxyUniResBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean reserverDirtyFlag = false;
    private boolean reserver2DirtyFlag = false;
    private boolean reserver3DirtyFlag = false;
    private boolean reserver4DirtyFlag = false;
    private boolean resourceidDirtyFlag = false;
    private boolean uniresidDirtyFlag = false;
    private boolean uniresnameDirtyFlag = false;
    private boolean unirestypeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="reserver")
    private String reserver;
    @Column(name="reserver2")
    private String reserver2;
    @Column(name="reserver3")
    private String reserver3;
    @Column(name="reserver4")
    private String reserver4;
    @Column(name="resourceid")
    private String resourceid;
    @Column(name="uniresid")
    private String uniresid;
    @Column(name="uniresname")
    private String uniresname;
    @Column(name="unirestype")
    private String unirestype;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_RESERVER, 3);
        fieldIndexMap.put(FIELD_RESERVER2, 4);
        fieldIndexMap.put(FIELD_RESERVER3, 5);
        fieldIndexMap.put(FIELD_RESERVER4, 6);
        fieldIndexMap.put(FIELD_RESOURCEID, 7);
        fieldIndexMap.put(FIELD_UNIRESID, 8);
        fieldIndexMap.put(FIELD_UNIRESNAME, 9);
        fieldIndexMap.put(FIELD_UNIRESTYPE, 10);
        fieldIndexMap.put(FIELD_UPDATEDATE, 11);
        fieldIndexMap.put(FIELD_UPDATEMAN, 12);
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

    public void setResourceId(String resourceid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResourceId(resourceid);
            return;
        }
        if (resourceid != null && (resourceid = StringHelper.trimRight(resourceid)).length() == 0) {
            resourceid = null;
        }
        this.resourceid = resourceid;
        this.resourceidDirtyFlag = true;
    }

    public String getResourceId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResourceId();
        }
        return this.resourceid;
    }

    public boolean isResourceIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResourceIdDirty();
        }
        return this.resourceidDirtyFlag;
    }

    public void resetResourceId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResourceId();
            return;
        }
        this.resourceidDirtyFlag = false;
        this.resourceid = null;
    }

    public void setUniResId(String uniresid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUniResId(uniresid);
            return;
        }
        if (uniresid != null && (uniresid = StringHelper.trimRight(uniresid)).length() == 0) {
            uniresid = null;
        }
        this.uniresid = uniresid;
        this.uniresidDirtyFlag = true;
    }

    public String getUniResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUniResId();
        }
        return this.uniresid;
    }

    public boolean isUniResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUniResIdDirty();
        }
        return this.uniresidDirtyFlag;
    }

    public void resetUniResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUniResId();
            return;
        }
        this.uniresidDirtyFlag = false;
        this.uniresid = null;
    }

    public void setUniResName(String uniresname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUniResName(uniresname);
            return;
        }
        if (uniresname != null && (uniresname = StringHelper.trimRight(uniresname)).length() == 0) {
            uniresname = null;
        }
        this.uniresname = uniresname;
        this.uniresnameDirtyFlag = true;
    }

    public String getUniResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUniResName();
        }
        return this.uniresname;
    }

    public boolean isUniResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUniResNameDirty();
        }
        return this.uniresnameDirtyFlag;
    }

    public void resetUniResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUniResName();
            return;
        }
        this.uniresnameDirtyFlag = false;
        this.uniresname = null;
    }

    public void setUniResType(String unirestype) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUniResType(unirestype);
            return;
        }
        if (unirestype != null && (unirestype = StringHelper.trimRight(unirestype)).length() == 0) {
            unirestype = null;
        }
        this.unirestype = unirestype;
        this.unirestypeDirtyFlag = true;
    }

    public String getUniResType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUniResType();
        }
        return this.unirestype;
    }

    public boolean isUniResTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUniResTypeDirty();
        }
        return this.unirestypeDirtyFlag;
    }

    public void resetUniResType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUniResType();
            return;
        }
        this.unirestypeDirtyFlag = false;
        this.unirestype = null;
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
        UniResBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(UniResBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetMemo();
        et.resetReserver();
        et.resetReserver2();
        et.resetReserver3();
        et.resetReserver4();
        et.resetResourceId();
        et.resetUniResId();
        et.resetUniResName();
        et.resetUniResType();
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
        if (!bDirtyOnly || this.isMemoDirty()) {
            params.put(FIELD_MEMO, this.getMemo());
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
        if (!bDirtyOnly || this.isResourceIdDirty()) {
            params.put(FIELD_RESOURCEID, this.getResourceId());
        }
        if (!bDirtyOnly || this.isUniResIdDirty()) {
            params.put(FIELD_UNIRESID, this.getUniResId());
        }
        if (!bDirtyOnly || this.isUniResNameDirty()) {
            params.put(FIELD_UNIRESNAME, this.getUniResName());
        }
        if (!bDirtyOnly || this.isUniResTypeDirty()) {
            params.put(FIELD_UNIRESTYPE, this.getUniResType());
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
        return UniResBase.get(this, index);
    }

    private static Object get(UniResBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate();
            }
            case 1: {
                return et.getCreateMan();
            }
            case 2: {
                return et.getMemo();
            }
            case 3: {
                return et.getReserver();
            }
            case 4: {
                return et.getReserver2();
            }
            case 5: {
                return et.getReserver3();
            }
            case 6: {
                return et.getReserver4();
            }
            case 7: {
                return et.getResourceId();
            }
            case 8: {
                return et.getUniResId();
            }
            case 9: {
                return et.getUniResName();
            }
            case 10: {
                return et.getUniResType();
            }
            case 11: {
                return et.getUpdateDate();
            }
            case 12: {
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
        UniResBase.set(this, index, objValue);
    }

    private static void set(UniResBase et, int index, Object obj) throws Exception {
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
                et.setMemo(DataObject.getStringValue(obj));
                return;
            }
            case 3: {
                et.setReserver(DataObject.getStringValue(obj));
                return;
            }
            case 4: {
                et.setReserver2(DataObject.getStringValue(obj));
                return;
            }
            case 5: {
                et.setReserver3(DataObject.getStringValue(obj));
                return;
            }
            case 6: {
                et.setReserver4(DataObject.getStringValue(obj));
                return;
            }
            case 7: {
                et.setResourceId(DataObject.getStringValue(obj));
                return;
            }
            case 8: {
                et.setUniResId(DataObject.getStringValue(obj));
                return;
            }
            case 9: {
                et.setUniResName(DataObject.getStringValue(obj));
                return;
            }
            case 10: {
                et.setUniResType(DataObject.getStringValue(obj));
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
        return UniResBase.isNull(this, index);
    }

    private static boolean isNull(UniResBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate() == null;
            }
            case 1: {
                return et.getCreateMan() == null;
            }
            case 2: {
                return et.getMemo() == null;
            }
            case 3: {
                return et.getReserver() == null;
            }
            case 4: {
                return et.getReserver2() == null;
            }
            case 5: {
                return et.getReserver3() == null;
            }
            case 6: {
                return et.getReserver4() == null;
            }
            case 7: {
                return et.getResourceId() == null;
            }
            case 8: {
                return et.getUniResId() == null;
            }
            case 9: {
                return et.getUniResName() == null;
            }
            case 10: {
                return et.getUniResType() == null;
            }
            case 11: {
                return et.getUpdateDate() == null;
            }
            case 12: {
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
        return UniResBase.contains(this, index);
    }

    private static boolean contains(UniResBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isCreateDateDirty();
            }
            case 1: {
                return et.isCreateManDirty();
            }
            case 2: {
                return et.isMemoDirty();
            }
            case 3: {
                return et.isReserverDirty();
            }
            case 4: {
                return et.isReserver2Dirty();
            }
            case 5: {
                return et.isReserver3Dirty();
            }
            case 6: {
                return et.isReserver4Dirty();
            }
            case 7: {
                return et.isResourceIdDirty();
            }
            case 8: {
                return et.isUniResIdDirty();
            }
            case 9: {
                return et.isUniResNameDirty();
            }
            case 10: {
                return et.isUniResTypeDirty();
            }
            case 11: {
                return et.isUpdateDateDirty();
            }
            case 12: {
                return et.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        UniResBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(UniResBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", UniResBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", UniResBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getMemo() != null) {
            JSONObjectHelper.put(json, "memo", UniResBase.getJSONValue(et.getMemo()), false);
        }
        if (bIncEmpty || et.getReserver() != null) {
            JSONObjectHelper.put(json, "reserver", UniResBase.getJSONValue(et.getReserver()), false);
        }
        if (bIncEmpty || et.getReserver2() != null) {
            JSONObjectHelper.put(json, "reserver2", UniResBase.getJSONValue(et.getReserver2()), false);
        }
        if (bIncEmpty || et.getReserver3() != null) {
            JSONObjectHelper.put(json, "reserver3", UniResBase.getJSONValue(et.getReserver3()), false);
        }
        if (bIncEmpty || et.getReserver4() != null) {
            JSONObjectHelper.put(json, "reserver4", UniResBase.getJSONValue(et.getReserver4()), false);
        }
        if (bIncEmpty || et.getResourceId() != null) {
            JSONObjectHelper.put(json, "resourceid", UniResBase.getJSONValue(et.getResourceId()), false);
        }
        if (bIncEmpty || et.getUniResId() != null) {
            JSONObjectHelper.put(json, "uniresid", UniResBase.getJSONValue(et.getUniResId()), false);
        }
        if (bIncEmpty || et.getUniResName() != null) {
            JSONObjectHelper.put(json, "uniresname", UniResBase.getJSONValue(et.getUniResName()), false);
        }
        if (bIncEmpty || et.getUniResType() != null) {
            JSONObjectHelper.put(json, "unirestype", UniResBase.getJSONValue(et.getUniResType()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", UniResBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", UniResBase.getJSONValue(et.getUpdateMan()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        UniResBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(UniResBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getCreateDate() != null) {
            obj = et.getCreateDate();
            node.setAttribute(FIELD_CREATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            obj = et.getCreateMan();
            node.setAttribute(FIELD_CREATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getMemo() != null) {
            obj = et.getMemo();
            node.setAttribute(FIELD_MEMO, obj == null ? "" : (String)obj);
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
        if (bIncEmpty || et.getResourceId() != null) {
            obj = et.getResourceId();
            node.setAttribute(FIELD_RESOURCEID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUniResId() != null) {
            obj = et.getUniResId();
            node.setAttribute(FIELD_UNIRESID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUniResName() != null) {
            obj = et.getUniResName();
            node.setAttribute(FIELD_UNIRESNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUniResType() != null) {
            obj = et.getUniResType();
            node.setAttribute(FIELD_UNIRESTYPE, obj == null ? "" : (String)obj);
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
        UniResBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(UniResBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isCreateDateDirty() && (bIncEmpty || et.getCreateDate() != null)) {
            dst.set(FIELD_CREATEDATE, et.getCreateDate());
        }
        if (et.isCreateManDirty() && (bIncEmpty || et.getCreateMan() != null)) {
            dst.set(FIELD_CREATEMAN, et.getCreateMan());
        }
        if (et.isMemoDirty() && (bIncEmpty || et.getMemo() != null)) {
            dst.set(FIELD_MEMO, et.getMemo());
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
        if (et.isResourceIdDirty() && (bIncEmpty || et.getResourceId() != null)) {
            dst.set(FIELD_RESOURCEID, et.getResourceId());
        }
        if (et.isUniResIdDirty() && (bIncEmpty || et.getUniResId() != null)) {
            dst.set(FIELD_UNIRESID, et.getUniResId());
        }
        if (et.isUniResNameDirty() && (bIncEmpty || et.getUniResName() != null)) {
            dst.set(FIELD_UNIRESNAME, et.getUniResName());
        }
        if (et.isUniResTypeDirty() && (bIncEmpty || et.getUniResType() != null)) {
            dst.set(FIELD_UNIRESTYPE, et.getUniResType());
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
        return UniResBase.remove(this, index);
    }

    private static boolean remove(UniResBase et, int index) throws Exception {
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
                et.resetMemo();
                return true;
            }
            case 3: {
                et.resetReserver();
                return true;
            }
            case 4: {
                et.resetReserver2();
                return true;
            }
            case 5: {
                et.resetReserver3();
                return true;
            }
            case 6: {
                et.resetReserver4();
                return true;
            }
            case 7: {
                et.resetResourceId();
                return true;
            }
            case 8: {
                et.resetUniResId();
                return true;
            }
            case 9: {
                et.resetUniResName();
                return true;
            }
            case 10: {
                et.resetUniResType();
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
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private UniResBase getProxyEntity() {
        return this.proxyUniResBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyUniResBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof UniResBase) {
            this.proxyUniResBase = (UniResBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.UniResService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

