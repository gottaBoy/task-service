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

public abstract class TSSDPolicyBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(TSSDPolicyBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_RESERVER = "RESERVER";
    public static final String FIELD_RESERVER2 = "RESERVER2";
    public static final String FIELD_RESERVER3 = "RESERVER3";
    public static final String FIELD_RESERVER4 = "RESERVER4";
    public static final String FIELD_TSSDPOLICYID = "TSSDPOLICYID";
    public static final String FIELD_TSSDPOLICYNAME = "TSSDPOLICYNAME";
    public static final String FIELD_TSSDPOLICYTYPE = "TSSDPOLICYTYPE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_RESERVER = 3;
    private static final int INDEX_RESERVER2 = 4;
    private static final int INDEX_RESERVER3 = 5;
    private static final int INDEX_RESERVER4 = 6;
    private static final int INDEX_TSSDPOLICYID = 7;
    private static final int INDEX_TSSDPOLICYNAME = 8;
    private static final int INDEX_TSSDPOLICYTYPE = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private TSSDPolicyBase proxyTSSDPolicyBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean reserverDirtyFlag = false;
    private boolean reserver2DirtyFlag = false;
    private boolean reserver3DirtyFlag = false;
    private boolean reserver4DirtyFlag = false;
    private boolean tssdpolicyidDirtyFlag = false;
    private boolean tssdpolicynameDirtyFlag = false;
    private boolean tssdpolicytypeDirtyFlag = false;
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
    @Column(name="tssdpolicyid")
    private String tssdpolicyid;
    @Column(name="tssdpolicyname")
    private String tssdpolicyname;
    @Column(name="tssdpolicytype")
    private String tssdpolicytype;
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
        fieldIndexMap.put(FIELD_TSSDPOLICYID, 7);
        fieldIndexMap.put(FIELD_TSSDPOLICYNAME, 8);
        fieldIndexMap.put(FIELD_TSSDPOLICYTYPE, 9);
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

    public void setTSSDPolicyId(String tssdpolicyid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTSSDPolicyId(tssdpolicyid);
            return;
        }
        if (tssdpolicyid != null && (tssdpolicyid = StringHelper.trimRight(tssdpolicyid)).length() == 0) {
            tssdpolicyid = null;
        }
        this.tssdpolicyid = tssdpolicyid;
        this.tssdpolicyidDirtyFlag = true;
    }

    public String getTSSDPolicyId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTSSDPolicyId();
        }
        return this.tssdpolicyid;
    }

    public boolean isTSSDPolicyIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTSSDPolicyIdDirty();
        }
        return this.tssdpolicyidDirtyFlag;
    }

    public void resetTSSDPolicyId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTSSDPolicyId();
            return;
        }
        this.tssdpolicyidDirtyFlag = false;
        this.tssdpolicyid = null;
    }

    public void setTSSDPolicyName(String tssdpolicyname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTSSDPolicyName(tssdpolicyname);
            return;
        }
        if (tssdpolicyname != null && (tssdpolicyname = StringHelper.trimRight(tssdpolicyname)).length() == 0) {
            tssdpolicyname = null;
        }
        this.tssdpolicyname = tssdpolicyname;
        this.tssdpolicynameDirtyFlag = true;
    }

    public String getTSSDPolicyName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTSSDPolicyName();
        }
        return this.tssdpolicyname;
    }

    public boolean isTSSDPolicyNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTSSDPolicyNameDirty();
        }
        return this.tssdpolicynameDirtyFlag;
    }

    public void resetTSSDPolicyName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTSSDPolicyName();
            return;
        }
        this.tssdpolicynameDirtyFlag = false;
        this.tssdpolicyname = null;
    }

    public void setTSSDPolicyType(String tssdpolicytype) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTSSDPolicyType(tssdpolicytype);
            return;
        }
        if (tssdpolicytype != null && (tssdpolicytype = StringHelper.trimRight(tssdpolicytype)).length() == 0) {
            tssdpolicytype = null;
        }
        this.tssdpolicytype = tssdpolicytype;
        this.tssdpolicytypeDirtyFlag = true;
    }

    public String getTSSDPolicyType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTSSDPolicyType();
        }
        return this.tssdpolicytype;
    }

    public boolean isTSSDPolicyTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTSSDPolicyTypeDirty();
        }
        return this.tssdpolicytypeDirtyFlag;
    }

    public void resetTSSDPolicyType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTSSDPolicyType();
            return;
        }
        this.tssdpolicytypeDirtyFlag = false;
        this.tssdpolicytype = null;
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
        TSSDPolicyBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(TSSDPolicyBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetMemo();
        et.resetReserver();
        et.resetReserver2();
        et.resetReserver3();
        et.resetReserver4();
        et.resetTSSDPolicyId();
        et.resetTSSDPolicyName();
        et.resetTSSDPolicyType();
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
        if (!bDirtyOnly || this.isTSSDPolicyIdDirty()) {
            params.put(FIELD_TSSDPOLICYID, this.getTSSDPolicyId());
        }
        if (!bDirtyOnly || this.isTSSDPolicyNameDirty()) {
            params.put(FIELD_TSSDPOLICYNAME, this.getTSSDPolicyName());
        }
        if (!bDirtyOnly || this.isTSSDPolicyTypeDirty()) {
            params.put(FIELD_TSSDPOLICYTYPE, this.getTSSDPolicyType());
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
        return TSSDPolicyBase.get(this, index);
    }

    private static Object get(TSSDPolicyBase et, int index) throws Exception {
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
                return et.getTSSDPolicyId();
            }
            case 8: {
                return et.getTSSDPolicyName();
            }
            case 9: {
                return et.getTSSDPolicyType();
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
        TSSDPolicyBase.set(this, index, objValue);
    }

    private static void set(TSSDPolicyBase et, int index, Object obj) throws Exception {
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
                et.setTSSDPolicyId(DataObject.getStringValue(obj));
                return;
            }
            case 8: {
                et.setTSSDPolicyName(DataObject.getStringValue(obj));
                return;
            }
            case 9: {
                et.setTSSDPolicyType(DataObject.getStringValue(obj));
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
        return TSSDPolicyBase.isNull(this, index);
    }

    private static boolean isNull(TSSDPolicyBase et, int index) throws Exception {
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
                return et.getTSSDPolicyId() == null;
            }
            case 8: {
                return et.getTSSDPolicyName() == null;
            }
            case 9: {
                return et.getTSSDPolicyType() == null;
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
        return TSSDPolicyBase.contains(this, index);
    }

    private static boolean contains(TSSDPolicyBase et, int index) throws Exception {
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
                return et.isTSSDPolicyIdDirty();
            }
            case 8: {
                return et.isTSSDPolicyNameDirty();
            }
            case 9: {
                return et.isTSSDPolicyTypeDirty();
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
        TSSDPolicyBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(TSSDPolicyBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", TSSDPolicyBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", TSSDPolicyBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getMemo() != null) {
            JSONObjectHelper.put(json, "memo", TSSDPolicyBase.getJSONValue(et.getMemo()), false);
        }
        if (bIncEmpty || et.getReserver() != null) {
            JSONObjectHelper.put(json, "reserver", TSSDPolicyBase.getJSONValue(et.getReserver()), false);
        }
        if (bIncEmpty || et.getReserver2() != null) {
            JSONObjectHelper.put(json, "reserver2", TSSDPolicyBase.getJSONValue(et.getReserver2()), false);
        }
        if (bIncEmpty || et.getReserver3() != null) {
            JSONObjectHelper.put(json, "reserver3", TSSDPolicyBase.getJSONValue(et.getReserver3()), false);
        }
        if (bIncEmpty || et.getReserver4() != null) {
            JSONObjectHelper.put(json, "reserver4", TSSDPolicyBase.getJSONValue(et.getReserver4()), false);
        }
        if (bIncEmpty || et.getTSSDPolicyId() != null) {
            JSONObjectHelper.put(json, "tssdpolicyid", TSSDPolicyBase.getJSONValue(et.getTSSDPolicyId()), false);
        }
        if (bIncEmpty || et.getTSSDPolicyName() != null) {
            JSONObjectHelper.put(json, "tssdpolicyname", TSSDPolicyBase.getJSONValue(et.getTSSDPolicyName()), false);
        }
        if (bIncEmpty || et.getTSSDPolicyType() != null) {
            JSONObjectHelper.put(json, "tssdpolicytype", TSSDPolicyBase.getJSONValue(et.getTSSDPolicyType()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", TSSDPolicyBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", TSSDPolicyBase.getJSONValue(et.getUpdateMan()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        TSSDPolicyBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(TSSDPolicyBase et, XmlNode node, boolean bIncEmpty) throws Exception {
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
        if (bIncEmpty || et.getTSSDPolicyId() != null) {
            obj = et.getTSSDPolicyId();
            node.setAttribute(FIELD_TSSDPOLICYID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getTSSDPolicyName() != null) {
            obj = et.getTSSDPolicyName();
            node.setAttribute(FIELD_TSSDPOLICYNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getTSSDPolicyType() != null) {
            obj = et.getTSSDPolicyType();
            node.setAttribute(FIELD_TSSDPOLICYTYPE, obj == null ? "" : (String)obj);
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
        TSSDPolicyBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(TSSDPolicyBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
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
        if (et.isTSSDPolicyIdDirty() && (bIncEmpty || et.getTSSDPolicyId() != null)) {
            dst.set(FIELD_TSSDPOLICYID, et.getTSSDPolicyId());
        }
        if (et.isTSSDPolicyNameDirty() && (bIncEmpty || et.getTSSDPolicyName() != null)) {
            dst.set(FIELD_TSSDPOLICYNAME, et.getTSSDPolicyName());
        }
        if (et.isTSSDPolicyTypeDirty() && (bIncEmpty || et.getTSSDPolicyType() != null)) {
            dst.set(FIELD_TSSDPOLICYTYPE, et.getTSSDPolicyType());
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
        return TSSDPolicyBase.remove(this, index);
    }

    private static boolean remove(TSSDPolicyBase et, int index) throws Exception {
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
                et.resetTSSDPolicyId();
                return true;
            }
            case 8: {
                et.resetTSSDPolicyName();
                return true;
            }
            case 9: {
                et.resetTSSDPolicyType();
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

    private TSSDPolicyBase getProxyEntity() {
        return this.proxyTSSDPolicyBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyTSSDPolicyBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof TSSDPolicyBase) {
            this.proxyTSSDPolicyBase = (TSSDPolicyBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.TSSDPolicyService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

