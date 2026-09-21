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

public abstract class TSSDPolicyOwnerBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(TSSDPolicyOwnerBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_RESERVER = "RESERVER";
    public static final String FIELD_RESERVER2 = "RESERVER2";
    public static final String FIELD_RESERVER3 = "RESERVER3";
    public static final String FIELD_RESERVER4 = "RESERVER4";
    public static final String FIELD_TSSDPOLICYOWNERID = "TSSDPOLICYOWNERID";
    public static final String FIELD_TSSDPOLICYOWNERID2 = "TSSDPOLICYOWNERID2";
    public static final String FIELD_TSSDPOLICYOWNERNAME = "TSSDPOLICYOWNERNAME";
    public static final String FIELD_TSSDPOLICYOWNERTYPE = "TSSDPOLICYOWNERTYPE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_RESERVER = 2;
    private static final int INDEX_RESERVER2 = 3;
    private static final int INDEX_RESERVER3 = 4;
    private static final int INDEX_RESERVER4 = 5;
    private static final int INDEX_TSSDPOLICYOWNERID = 6;
    private static final int INDEX_TSSDPOLICYOWNERID2 = 7;
    private static final int INDEX_TSSDPOLICYOWNERNAME = 8;
    private static final int INDEX_TSSDPOLICYOWNERTYPE = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private TSSDPolicyOwnerBase proxyTSSDPolicyOwnerBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean reserverDirtyFlag = false;
    private boolean reserver2DirtyFlag = false;
    private boolean reserver3DirtyFlag = false;
    private boolean reserver4DirtyFlag = false;
    private boolean tssdpolicyowneridDirtyFlag = false;
    private boolean tssdpolicyownerid2DirtyFlag = false;
    private boolean tssdpolicyownernameDirtyFlag = false;
    private boolean tssdpolicyownertypeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="reserver")
    private String reserver;
    @Column(name="reserver2")
    private String reserver2;
    @Column(name="reserver3")
    private String reserver3;
    @Column(name="reserver4")
    private String reserver4;
    @Column(name="tssdpolicyownerid")
    private String tssdpolicyownerid;
    @Column(name="tssdpolicyownerid2")
    private String tssdpolicyownerid2;
    @Column(name="tssdpolicyownername")
    private String tssdpolicyownername;
    @Column(name="tssdpolicyownertype")
    private String tssdpolicyownertype;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_RESERVER, 2);
        fieldIndexMap.put(FIELD_RESERVER2, 3);
        fieldIndexMap.put(FIELD_RESERVER3, 4);
        fieldIndexMap.put(FIELD_RESERVER4, 5);
        fieldIndexMap.put(FIELD_TSSDPOLICYOWNERID, 6);
        fieldIndexMap.put(FIELD_TSSDPOLICYOWNERID2, 7);
        fieldIndexMap.put(FIELD_TSSDPOLICYOWNERNAME, 8);
        fieldIndexMap.put(FIELD_TSSDPOLICYOWNERTYPE, 9);
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

    public void setTSSDPolicyOwnerId(String tssdpolicyownerid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTSSDPolicyOwnerId(tssdpolicyownerid);
            return;
        }
        if (tssdpolicyownerid != null && (tssdpolicyownerid = StringHelper.trimRight(tssdpolicyownerid)).length() == 0) {
            tssdpolicyownerid = null;
        }
        this.tssdpolicyownerid = tssdpolicyownerid;
        this.tssdpolicyowneridDirtyFlag = true;
    }

    public String getTSSDPolicyOwnerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTSSDPolicyOwnerId();
        }
        return this.tssdpolicyownerid;
    }

    public boolean isTSSDPolicyOwnerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTSSDPolicyOwnerIdDirty();
        }
        return this.tssdpolicyowneridDirtyFlag;
    }

    public void resetTSSDPolicyOwnerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTSSDPolicyOwnerId();
            return;
        }
        this.tssdpolicyowneridDirtyFlag = false;
        this.tssdpolicyownerid = null;
    }

    public void setTSSDPolicyOwnerId2(String tssdpolicyownerid2) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTSSDPolicyOwnerId2(tssdpolicyownerid2);
            return;
        }
        if (tssdpolicyownerid2 != null && (tssdpolicyownerid2 = StringHelper.trimRight(tssdpolicyownerid2)).length() == 0) {
            tssdpolicyownerid2 = null;
        }
        this.tssdpolicyownerid2 = tssdpolicyownerid2;
        this.tssdpolicyownerid2DirtyFlag = true;
    }

    public String getTSSDPolicyOwnerId2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTSSDPolicyOwnerId2();
        }
        return this.tssdpolicyownerid2;
    }

    public boolean isTSSDPolicyOwnerId2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTSSDPolicyOwnerId2Dirty();
        }
        return this.tssdpolicyownerid2DirtyFlag;
    }

    public void resetTSSDPolicyOwnerId2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTSSDPolicyOwnerId2();
            return;
        }
        this.tssdpolicyownerid2DirtyFlag = false;
        this.tssdpolicyownerid2 = null;
    }

    public void setTSSDPolicyOwnerName(String tssdpolicyownername) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTSSDPolicyOwnerName(tssdpolicyownername);
            return;
        }
        if (tssdpolicyownername != null && (tssdpolicyownername = StringHelper.trimRight(tssdpolicyownername)).length() == 0) {
            tssdpolicyownername = null;
        }
        this.tssdpolicyownername = tssdpolicyownername;
        this.tssdpolicyownernameDirtyFlag = true;
    }

    public String getTSSDPolicyOwnerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTSSDPolicyOwnerName();
        }
        return this.tssdpolicyownername;
    }

    public boolean isTSSDPolicyOwnerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTSSDPolicyOwnerNameDirty();
        }
        return this.tssdpolicyownernameDirtyFlag;
    }

    public void resetTSSDPolicyOwnerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTSSDPolicyOwnerName();
            return;
        }
        this.tssdpolicyownernameDirtyFlag = false;
        this.tssdpolicyownername = null;
    }

    public void setTSSDPolicyOwnerType(String tssdpolicyownertype) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTSSDPolicyOwnerType(tssdpolicyownertype);
            return;
        }
        if (tssdpolicyownertype != null && (tssdpolicyownertype = StringHelper.trimRight(tssdpolicyownertype)).length() == 0) {
            tssdpolicyownertype = null;
        }
        this.tssdpolicyownertype = tssdpolicyownertype;
        this.tssdpolicyownertypeDirtyFlag = true;
    }

    public String getTSSDPolicyOwnerType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTSSDPolicyOwnerType();
        }
        return this.tssdpolicyownertype;
    }

    public boolean isTSSDPolicyOwnerTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTSSDPolicyOwnerTypeDirty();
        }
        return this.tssdpolicyownertypeDirtyFlag;
    }

    public void resetTSSDPolicyOwnerType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTSSDPolicyOwnerType();
            return;
        }
        this.tssdpolicyownertypeDirtyFlag = false;
        this.tssdpolicyownertype = null;
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
        TSSDPolicyOwnerBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(TSSDPolicyOwnerBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetReserver();
        et.resetReserver2();
        et.resetReserver3();
        et.resetReserver4();
        et.resetTSSDPolicyOwnerId();
        et.resetTSSDPolicyOwnerId2();
        et.resetTSSDPolicyOwnerName();
        et.resetTSSDPolicyOwnerType();
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
        if (!bDirtyOnly || this.isTSSDPolicyOwnerIdDirty()) {
            params.put(FIELD_TSSDPOLICYOWNERID, this.getTSSDPolicyOwnerId());
        }
        if (!bDirtyOnly || this.isTSSDPolicyOwnerId2Dirty()) {
            params.put(FIELD_TSSDPOLICYOWNERID2, this.getTSSDPolicyOwnerId2());
        }
        if (!bDirtyOnly || this.isTSSDPolicyOwnerNameDirty()) {
            params.put(FIELD_TSSDPOLICYOWNERNAME, this.getTSSDPolicyOwnerName());
        }
        if (!bDirtyOnly || this.isTSSDPolicyOwnerTypeDirty()) {
            params.put(FIELD_TSSDPOLICYOWNERTYPE, this.getTSSDPolicyOwnerType());
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
        return TSSDPolicyOwnerBase.get(this, index);
    }

    private static Object get(TSSDPolicyOwnerBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate();
            }
            case 1: {
                return et.getCreateMan();
            }
            case 2: {
                return et.getReserver();
            }
            case 3: {
                return et.getReserver2();
            }
            case 4: {
                return et.getReserver3();
            }
            case 5: {
                return et.getReserver4();
            }
            case 6: {
                return et.getTSSDPolicyOwnerId();
            }
            case 7: {
                return et.getTSSDPolicyOwnerId2();
            }
            case 8: {
                return et.getTSSDPolicyOwnerName();
            }
            case 9: {
                return et.getTSSDPolicyOwnerType();
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
        TSSDPolicyOwnerBase.set(this, index, objValue);
    }

    private static void set(TSSDPolicyOwnerBase et, int index, Object obj) throws Exception {
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
                et.setReserver(DataObject.getStringValue(obj));
                return;
            }
            case 3: {
                et.setReserver2(DataObject.getStringValue(obj));
                return;
            }
            case 4: {
                et.setReserver3(DataObject.getStringValue(obj));
                return;
            }
            case 5: {
                et.setReserver4(DataObject.getStringValue(obj));
                return;
            }
            case 6: {
                et.setTSSDPolicyOwnerId(DataObject.getStringValue(obj));
                return;
            }
            case 7: {
                et.setTSSDPolicyOwnerId2(DataObject.getStringValue(obj));
                return;
            }
            case 8: {
                et.setTSSDPolicyOwnerName(DataObject.getStringValue(obj));
                return;
            }
            case 9: {
                et.setTSSDPolicyOwnerType(DataObject.getStringValue(obj));
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
        return TSSDPolicyOwnerBase.isNull(this, index);
    }

    private static boolean isNull(TSSDPolicyOwnerBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate() == null;
            }
            case 1: {
                return et.getCreateMan() == null;
            }
            case 2: {
                return et.getReserver() == null;
            }
            case 3: {
                return et.getReserver2() == null;
            }
            case 4: {
                return et.getReserver3() == null;
            }
            case 5: {
                return et.getReserver4() == null;
            }
            case 6: {
                return et.getTSSDPolicyOwnerId() == null;
            }
            case 7: {
                return et.getTSSDPolicyOwnerId2() == null;
            }
            case 8: {
                return et.getTSSDPolicyOwnerName() == null;
            }
            case 9: {
                return et.getTSSDPolicyOwnerType() == null;
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
        return TSSDPolicyOwnerBase.contains(this, index);
    }

    private static boolean contains(TSSDPolicyOwnerBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isCreateDateDirty();
            }
            case 1: {
                return et.isCreateManDirty();
            }
            case 2: {
                return et.isReserverDirty();
            }
            case 3: {
                return et.isReserver2Dirty();
            }
            case 4: {
                return et.isReserver3Dirty();
            }
            case 5: {
                return et.isReserver4Dirty();
            }
            case 6: {
                return et.isTSSDPolicyOwnerIdDirty();
            }
            case 7: {
                return et.isTSSDPolicyOwnerId2Dirty();
            }
            case 8: {
                return et.isTSSDPolicyOwnerNameDirty();
            }
            case 9: {
                return et.isTSSDPolicyOwnerTypeDirty();
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
        TSSDPolicyOwnerBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(TSSDPolicyOwnerBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", TSSDPolicyOwnerBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", TSSDPolicyOwnerBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getReserver() != null) {
            JSONObjectHelper.put(json, "reserver", TSSDPolicyOwnerBase.getJSONValue(et.getReserver()), false);
        }
        if (bIncEmpty || et.getReserver2() != null) {
            JSONObjectHelper.put(json, "reserver2", TSSDPolicyOwnerBase.getJSONValue(et.getReserver2()), false);
        }
        if (bIncEmpty || et.getReserver3() != null) {
            JSONObjectHelper.put(json, "reserver3", TSSDPolicyOwnerBase.getJSONValue(et.getReserver3()), false);
        }
        if (bIncEmpty || et.getReserver4() != null) {
            JSONObjectHelper.put(json, "reserver4", TSSDPolicyOwnerBase.getJSONValue(et.getReserver4()), false);
        }
        if (bIncEmpty || et.getTSSDPolicyOwnerId() != null) {
            JSONObjectHelper.put(json, "tssdpolicyownerid", TSSDPolicyOwnerBase.getJSONValue(et.getTSSDPolicyOwnerId()), false);
        }
        if (bIncEmpty || et.getTSSDPolicyOwnerId2() != null) {
            JSONObjectHelper.put(json, "tssdpolicyownerid2", TSSDPolicyOwnerBase.getJSONValue(et.getTSSDPolicyOwnerId2()), false);
        }
        if (bIncEmpty || et.getTSSDPolicyOwnerName() != null) {
            JSONObjectHelper.put(json, "tssdpolicyownername", TSSDPolicyOwnerBase.getJSONValue(et.getTSSDPolicyOwnerName()), false);
        }
        if (bIncEmpty || et.getTSSDPolicyOwnerType() != null) {
            JSONObjectHelper.put(json, "tssdpolicyownertype", TSSDPolicyOwnerBase.getJSONValue(et.getTSSDPolicyOwnerType()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", TSSDPolicyOwnerBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", TSSDPolicyOwnerBase.getJSONValue(et.getUpdateMan()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        TSSDPolicyOwnerBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(TSSDPolicyOwnerBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getCreateDate() != null) {
            obj = et.getCreateDate();
            node.setAttribute(FIELD_CREATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            obj = et.getCreateMan();
            node.setAttribute(FIELD_CREATEMAN, obj == null ? "" : (String)obj);
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
        if (bIncEmpty || et.getTSSDPolicyOwnerId() != null) {
            obj = et.getTSSDPolicyOwnerId();
            node.setAttribute(FIELD_TSSDPOLICYOWNERID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getTSSDPolicyOwnerId2() != null) {
            obj = et.getTSSDPolicyOwnerId2();
            node.setAttribute(FIELD_TSSDPOLICYOWNERID2, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getTSSDPolicyOwnerName() != null) {
            obj = et.getTSSDPolicyOwnerName();
            node.setAttribute(FIELD_TSSDPOLICYOWNERNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getTSSDPolicyOwnerType() != null) {
            obj = et.getTSSDPolicyOwnerType();
            node.setAttribute(FIELD_TSSDPOLICYOWNERTYPE, obj == null ? "" : (String)obj);
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
        TSSDPolicyOwnerBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(TSSDPolicyOwnerBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isCreateDateDirty() && (bIncEmpty || et.getCreateDate() != null)) {
            dst.set(FIELD_CREATEDATE, et.getCreateDate());
        }
        if (et.isCreateManDirty() && (bIncEmpty || et.getCreateMan() != null)) {
            dst.set(FIELD_CREATEMAN, et.getCreateMan());
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
        if (et.isTSSDPolicyOwnerIdDirty() && (bIncEmpty || et.getTSSDPolicyOwnerId() != null)) {
            dst.set(FIELD_TSSDPOLICYOWNERID, et.getTSSDPolicyOwnerId());
        }
        if (et.isTSSDPolicyOwnerId2Dirty() && (bIncEmpty || et.getTSSDPolicyOwnerId2() != null)) {
            dst.set(FIELD_TSSDPOLICYOWNERID2, et.getTSSDPolicyOwnerId2());
        }
        if (et.isTSSDPolicyOwnerNameDirty() && (bIncEmpty || et.getTSSDPolicyOwnerName() != null)) {
            dst.set(FIELD_TSSDPOLICYOWNERNAME, et.getTSSDPolicyOwnerName());
        }
        if (et.isTSSDPolicyOwnerTypeDirty() && (bIncEmpty || et.getTSSDPolicyOwnerType() != null)) {
            dst.set(FIELD_TSSDPOLICYOWNERTYPE, et.getTSSDPolicyOwnerType());
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
        return TSSDPolicyOwnerBase.remove(this, index);
    }

    private static boolean remove(TSSDPolicyOwnerBase et, int index) throws Exception {
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
                et.resetReserver();
                return true;
            }
            case 3: {
                et.resetReserver2();
                return true;
            }
            case 4: {
                et.resetReserver3();
                return true;
            }
            case 5: {
                et.resetReserver4();
                return true;
            }
            case 6: {
                et.resetTSSDPolicyOwnerId();
                return true;
            }
            case 7: {
                et.resetTSSDPolicyOwnerId2();
                return true;
            }
            case 8: {
                et.resetTSSDPolicyOwnerName();
                return true;
            }
            case 9: {
                et.resetTSSDPolicyOwnerType();
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

    private TSSDPolicyOwnerBase getProxyEntity() {
        return this.proxyTSSDPolicyOwnerBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyTSSDPolicyOwnerBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof TSSDPolicyOwnerBase) {
            this.proxyTSSDPolicyOwnerBase = (TSSDPolicyOwnerBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.TSSDPolicyOwnerService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

