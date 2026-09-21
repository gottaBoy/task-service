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
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.psrt.srv.common.entity.TSSDGroup;
import net.ibizsys.psrt.srv.common.entity.TSSDItem;
import net.ibizsys.psrt.srv.common.service.TSSDGroupService;
import net.ibizsys.psrt.srv.common.service.TSSDItemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class TSSDGroupDetailBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(TSSDGroupDetailBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_TSSDGROUPDETAILID = "TSSDGROUPDETAILID";
    public static final String FIELD_TSSDGROUPDETAILNAME = "TSSDGROUPDETAILNAME";
    public static final String FIELD_TSSDGROUPID = "TSSDGROUPID";
    public static final String FIELD_TSSDGROUPNAME = "TSSDGROUPNAME";
    public static final String FIELD_TSSDITEMID = "TSSDITEMID";
    public static final String FIELD_TSSDITEMNAME = "TSSDITEMNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_TSSDGROUPDETAILID = 2;
    private static final int INDEX_TSSDGROUPDETAILNAME = 3;
    private static final int INDEX_TSSDGROUPID = 4;
    private static final int INDEX_TSSDGROUPNAME = 5;
    private static final int INDEX_TSSDITEMID = 6;
    private static final int INDEX_TSSDITEMNAME = 7;
    private static final int INDEX_UPDATEDATE = 8;
    private static final int INDEX_UPDATEMAN = 9;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private TSSDGroupDetailBase proxyTSSDGroupDetailBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean tssdgroupdetailidDirtyFlag = false;
    private boolean tssdgroupdetailnameDirtyFlag = false;
    private boolean tssdgroupidDirtyFlag = false;
    private boolean tssdgroupnameDirtyFlag = false;
    private boolean tssditemidDirtyFlag = false;
    private boolean tssditemnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="tssdgroupdetailid")
    private String tssdgroupdetailid;
    @Column(name="tssdgroupdetailname")
    private String tssdgroupdetailname;
    @Column(name="tssdgroupid")
    private String tssdgroupid;
    @Column(name="tssdgroupname")
    private String tssdgroupname;
    @Column(name="tssditemid")
    private String tssditemid;
    @Column(name="tssditemname")
    private String tssditemname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objTSSDGroupLock = new Integer(1);
    private TSSDGroup tssdgroup = null;
    private Integer objTSSDItemLock = new Integer(1);
    private TSSDItem tssditem = null;

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_TSSDGROUPDETAILID, 2);
        fieldIndexMap.put(FIELD_TSSDGROUPDETAILNAME, 3);
        fieldIndexMap.put(FIELD_TSSDGROUPID, 4);
        fieldIndexMap.put(FIELD_TSSDGROUPNAME, 5);
        fieldIndexMap.put(FIELD_TSSDITEMID, 6);
        fieldIndexMap.put(FIELD_TSSDITEMNAME, 7);
        fieldIndexMap.put(FIELD_UPDATEDATE, 8);
        fieldIndexMap.put(FIELD_UPDATEMAN, 9);
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

    public void setTSSDGroupDetailId(String tssdgroupdetailid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTSSDGroupDetailId(tssdgroupdetailid);
            return;
        }
        if (tssdgroupdetailid != null && (tssdgroupdetailid = StringHelper.trimRight(tssdgroupdetailid)).length() == 0) {
            tssdgroupdetailid = null;
        }
        this.tssdgroupdetailid = tssdgroupdetailid;
        this.tssdgroupdetailidDirtyFlag = true;
    }

    public String getTSSDGroupDetailId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTSSDGroupDetailId();
        }
        return this.tssdgroupdetailid;
    }

    public boolean isTSSDGroupDetailIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTSSDGroupDetailIdDirty();
        }
        return this.tssdgroupdetailidDirtyFlag;
    }

    public void resetTSSDGroupDetailId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTSSDGroupDetailId();
            return;
        }
        this.tssdgroupdetailidDirtyFlag = false;
        this.tssdgroupdetailid = null;
    }

    public void setTSSDGroupDetailName(String tssdgroupdetailname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTSSDGroupDetailName(tssdgroupdetailname);
            return;
        }
        if (tssdgroupdetailname != null && (tssdgroupdetailname = StringHelper.trimRight(tssdgroupdetailname)).length() == 0) {
            tssdgroupdetailname = null;
        }
        this.tssdgroupdetailname = tssdgroupdetailname;
        this.tssdgroupdetailnameDirtyFlag = true;
    }

    public String getTSSDGroupDetailName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTSSDGroupDetailName();
        }
        return this.tssdgroupdetailname;
    }

    public boolean isTSSDGroupDetailNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTSSDGroupDetailNameDirty();
        }
        return this.tssdgroupdetailnameDirtyFlag;
    }

    public void resetTSSDGroupDetailName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTSSDGroupDetailName();
            return;
        }
        this.tssdgroupdetailnameDirtyFlag = false;
        this.tssdgroupdetailname = null;
    }

    public void setTSSDGroupId(String tssdgroupid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTSSDGroupId(tssdgroupid);
            return;
        }
        if (tssdgroupid != null && (tssdgroupid = StringHelper.trimRight(tssdgroupid)).length() == 0) {
            tssdgroupid = null;
        }
        this.tssdgroupid = tssdgroupid;
        this.tssdgroupidDirtyFlag = true;
    }

    public String getTSSDGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTSSDGroupId();
        }
        return this.tssdgroupid;
    }

    public boolean isTSSDGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTSSDGroupIdDirty();
        }
        return this.tssdgroupidDirtyFlag;
    }

    public void resetTSSDGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTSSDGroupId();
            return;
        }
        this.tssdgroupidDirtyFlag = false;
        this.tssdgroupid = null;
    }

    public void setTSSDGroupName(String tssdgroupname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTSSDGroupName(tssdgroupname);
            return;
        }
        if (tssdgroupname != null && (tssdgroupname = StringHelper.trimRight(tssdgroupname)).length() == 0) {
            tssdgroupname = null;
        }
        this.tssdgroupname = tssdgroupname;
        this.tssdgroupnameDirtyFlag = true;
    }

    public String getTSSDGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTSSDGroupName();
        }
        return this.tssdgroupname;
    }

    public boolean isTSSDGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTSSDGroupNameDirty();
        }
        return this.tssdgroupnameDirtyFlag;
    }

    public void resetTSSDGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTSSDGroupName();
            return;
        }
        this.tssdgroupnameDirtyFlag = false;
        this.tssdgroupname = null;
    }

    public void setTSSDItemId(String tssditemid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTSSDItemId(tssditemid);
            return;
        }
        if (tssditemid != null && (tssditemid = StringHelper.trimRight(tssditemid)).length() == 0) {
            tssditemid = null;
        }
        this.tssditemid = tssditemid;
        this.tssditemidDirtyFlag = true;
    }

    public String getTSSDItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTSSDItemId();
        }
        return this.tssditemid;
    }

    public boolean isTSSDItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTSSDItemIdDirty();
        }
        return this.tssditemidDirtyFlag;
    }

    public void resetTSSDItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTSSDItemId();
            return;
        }
        this.tssditemidDirtyFlag = false;
        this.tssditemid = null;
    }

    public void setTSSDItemName(String tssditemname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTSSDItemName(tssditemname);
            return;
        }
        if (tssditemname != null && (tssditemname = StringHelper.trimRight(tssditemname)).length() == 0) {
            tssditemname = null;
        }
        this.tssditemname = tssditemname;
        this.tssditemnameDirtyFlag = true;
    }

    public String getTSSDItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTSSDItemName();
        }
        return this.tssditemname;
    }

    public boolean isTSSDItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTSSDItemNameDirty();
        }
        return this.tssditemnameDirtyFlag;
    }

    public void resetTSSDItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTSSDItemName();
            return;
        }
        this.tssditemnameDirtyFlag = false;
        this.tssditemname = null;
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
        TSSDGroupDetailBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(TSSDGroupDetailBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetTSSDGroupDetailId();
        et.resetTSSDGroupDetailName();
        et.resetTSSDGroupId();
        et.resetTSSDGroupName();
        et.resetTSSDItemId();
        et.resetTSSDItemName();
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
        if (!bDirtyOnly || this.isTSSDGroupDetailIdDirty()) {
            params.put(FIELD_TSSDGROUPDETAILID, this.getTSSDGroupDetailId());
        }
        if (!bDirtyOnly || this.isTSSDGroupDetailNameDirty()) {
            params.put(FIELD_TSSDGROUPDETAILNAME, this.getTSSDGroupDetailName());
        }
        if (!bDirtyOnly || this.isTSSDGroupIdDirty()) {
            params.put(FIELD_TSSDGROUPID, this.getTSSDGroupId());
        }
        if (!bDirtyOnly || this.isTSSDGroupNameDirty()) {
            params.put(FIELD_TSSDGROUPNAME, this.getTSSDGroupName());
        }
        if (!bDirtyOnly || this.isTSSDItemIdDirty()) {
            params.put(FIELD_TSSDITEMID, this.getTSSDItemId());
        }
        if (!bDirtyOnly || this.isTSSDItemNameDirty()) {
            params.put(FIELD_TSSDITEMNAME, this.getTSSDItemName());
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
        return TSSDGroupDetailBase.get(this, index);
    }

    private static Object get(TSSDGroupDetailBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate();
            }
            case 1: {
                return et.getCreateMan();
            }
            case 2: {
                return et.getTSSDGroupDetailId();
            }
            case 3: {
                return et.getTSSDGroupDetailName();
            }
            case 4: {
                return et.getTSSDGroupId();
            }
            case 5: {
                return et.getTSSDGroupName();
            }
            case 6: {
                return et.getTSSDItemId();
            }
            case 7: {
                return et.getTSSDItemName();
            }
            case 8: {
                return et.getUpdateDate();
            }
            case 9: {
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
        TSSDGroupDetailBase.set(this, index, objValue);
    }

    private static void set(TSSDGroupDetailBase et, int index, Object obj) throws Exception {
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
                et.setTSSDGroupDetailId(DataObject.getStringValue(obj));
                return;
            }
            case 3: {
                et.setTSSDGroupDetailName(DataObject.getStringValue(obj));
                return;
            }
            case 4: {
                et.setTSSDGroupId(DataObject.getStringValue(obj));
                return;
            }
            case 5: {
                et.setTSSDGroupName(DataObject.getStringValue(obj));
                return;
            }
            case 6: {
                et.setTSSDItemId(DataObject.getStringValue(obj));
                return;
            }
            case 7: {
                et.setTSSDItemName(DataObject.getStringValue(obj));
                return;
            }
            case 8: {
                et.setUpdateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 9: {
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
        return TSSDGroupDetailBase.isNull(this, index);
    }

    private static boolean isNull(TSSDGroupDetailBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate() == null;
            }
            case 1: {
                return et.getCreateMan() == null;
            }
            case 2: {
                return et.getTSSDGroupDetailId() == null;
            }
            case 3: {
                return et.getTSSDGroupDetailName() == null;
            }
            case 4: {
                return et.getTSSDGroupId() == null;
            }
            case 5: {
                return et.getTSSDGroupName() == null;
            }
            case 6: {
                return et.getTSSDItemId() == null;
            }
            case 7: {
                return et.getTSSDItemName() == null;
            }
            case 8: {
                return et.getUpdateDate() == null;
            }
            case 9: {
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
        return TSSDGroupDetailBase.contains(this, index);
    }

    private static boolean contains(TSSDGroupDetailBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isCreateDateDirty();
            }
            case 1: {
                return et.isCreateManDirty();
            }
            case 2: {
                return et.isTSSDGroupDetailIdDirty();
            }
            case 3: {
                return et.isTSSDGroupDetailNameDirty();
            }
            case 4: {
                return et.isTSSDGroupIdDirty();
            }
            case 5: {
                return et.isTSSDGroupNameDirty();
            }
            case 6: {
                return et.isTSSDItemIdDirty();
            }
            case 7: {
                return et.isTSSDItemNameDirty();
            }
            case 8: {
                return et.isUpdateDateDirty();
            }
            case 9: {
                return et.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        TSSDGroupDetailBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(TSSDGroupDetailBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", TSSDGroupDetailBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", TSSDGroupDetailBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getTSSDGroupDetailId() != null) {
            JSONObjectHelper.put(json, "tssdgroupdetailid", TSSDGroupDetailBase.getJSONValue(et.getTSSDGroupDetailId()), false);
        }
        if (bIncEmpty || et.getTSSDGroupDetailName() != null) {
            JSONObjectHelper.put(json, "tssdgroupdetailname", TSSDGroupDetailBase.getJSONValue(et.getTSSDGroupDetailName()), false);
        }
        if (bIncEmpty || et.getTSSDGroupId() != null) {
            JSONObjectHelper.put(json, "tssdgroupid", TSSDGroupDetailBase.getJSONValue(et.getTSSDGroupId()), false);
        }
        if (bIncEmpty || et.getTSSDGroupName() != null) {
            JSONObjectHelper.put(json, "tssdgroupname", TSSDGroupDetailBase.getJSONValue(et.getTSSDGroupName()), false);
        }
        if (bIncEmpty || et.getTSSDItemId() != null) {
            JSONObjectHelper.put(json, "tssditemid", TSSDGroupDetailBase.getJSONValue(et.getTSSDItemId()), false);
        }
        if (bIncEmpty || et.getTSSDItemName() != null) {
            JSONObjectHelper.put(json, "tssditemname", TSSDGroupDetailBase.getJSONValue(et.getTSSDItemName()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", TSSDGroupDetailBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", TSSDGroupDetailBase.getJSONValue(et.getUpdateMan()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        TSSDGroupDetailBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(TSSDGroupDetailBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getCreateDate() != null) {
            obj = et.getCreateDate();
            node.setAttribute(FIELD_CREATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            obj = et.getCreateMan();
            node.setAttribute(FIELD_CREATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getTSSDGroupDetailId() != null) {
            obj = et.getTSSDGroupDetailId();
            node.setAttribute(FIELD_TSSDGROUPDETAILID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getTSSDGroupDetailName() != null) {
            obj = et.getTSSDGroupDetailName();
            node.setAttribute(FIELD_TSSDGROUPDETAILNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getTSSDGroupId() != null) {
            obj = et.getTSSDGroupId();
            node.setAttribute(FIELD_TSSDGROUPID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getTSSDGroupName() != null) {
            obj = et.getTSSDGroupName();
            node.setAttribute(FIELD_TSSDGROUPNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getTSSDItemId() != null) {
            obj = et.getTSSDItemId();
            node.setAttribute(FIELD_TSSDITEMID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getTSSDItemName() != null) {
            obj = et.getTSSDItemName();
            node.setAttribute(FIELD_TSSDITEMNAME, obj == null ? "" : (String)obj);
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
        TSSDGroupDetailBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(TSSDGroupDetailBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isCreateDateDirty() && (bIncEmpty || et.getCreateDate() != null)) {
            dst.set(FIELD_CREATEDATE, et.getCreateDate());
        }
        if (et.isCreateManDirty() && (bIncEmpty || et.getCreateMan() != null)) {
            dst.set(FIELD_CREATEMAN, et.getCreateMan());
        }
        if (et.isTSSDGroupDetailIdDirty() && (bIncEmpty || et.getTSSDGroupDetailId() != null)) {
            dst.set(FIELD_TSSDGROUPDETAILID, et.getTSSDGroupDetailId());
        }
        if (et.isTSSDGroupDetailNameDirty() && (bIncEmpty || et.getTSSDGroupDetailName() != null)) {
            dst.set(FIELD_TSSDGROUPDETAILNAME, et.getTSSDGroupDetailName());
        }
        if (et.isTSSDGroupIdDirty() && (bIncEmpty || et.getTSSDGroupId() != null)) {
            dst.set(FIELD_TSSDGROUPID, et.getTSSDGroupId());
        }
        if (et.isTSSDGroupNameDirty() && (bIncEmpty || et.getTSSDGroupName() != null)) {
            dst.set(FIELD_TSSDGROUPNAME, et.getTSSDGroupName());
        }
        if (et.isTSSDItemIdDirty() && (bIncEmpty || et.getTSSDItemId() != null)) {
            dst.set(FIELD_TSSDITEMID, et.getTSSDItemId());
        }
        if (et.isTSSDItemNameDirty() && (bIncEmpty || et.getTSSDItemName() != null)) {
            dst.set(FIELD_TSSDITEMNAME, et.getTSSDItemName());
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
        return TSSDGroupDetailBase.remove(this, index);
    }

    private static boolean remove(TSSDGroupDetailBase et, int index) throws Exception {
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
                et.resetTSSDGroupDetailId();
                return true;
            }
            case 3: {
                et.resetTSSDGroupDetailName();
                return true;
            }
            case 4: {
                et.resetTSSDGroupId();
                return true;
            }
            case 5: {
                et.resetTSSDGroupName();
                return true;
            }
            case 6: {
                et.resetTSSDItemId();
                return true;
            }
            case 7: {
                et.resetTSSDItemName();
                return true;
            }
            case 8: {
                et.resetUpdateDate();
                return true;
            }
            case 9: {
                et.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public TSSDGroup getTSSDGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTSSDGroup();
        }
        if (this.getTSSDGroupId() == null) {
            return null;
        }
        Integer n = this.objTSSDGroupLock;
        synchronized (n) {
            if (this.tssdgroup != null && DataTypeHelper.compare(25, (Object)this.getTSSDGroupId(), (Object)this.tssdgroup.getTSSDGroupId()) != 0L) {
                this.tssdgroup = null;
            }
            if (this.tssdgroup == null) {
                TSSDGroup tssdgroup = new TSSDGroup();
                tssdgroup.setTSSDGroupId(this.getTSSDGroupId());
                TSSDGroupService service = (TSSDGroupService)ServiceGlobal.getService(TSSDGroupService.class, this.getSessionFactory());
                service.autoGet(tssdgroup);
                this.tssdgroup = tssdgroup;
            }
            return this.tssdgroup;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public TSSDItem getTSSDItem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTSSDItem();
        }
        if (this.getTSSDItemId() == null) {
            return null;
        }
        Integer n = this.objTSSDItemLock;
        synchronized (n) {
            if (this.tssditem != null && DataTypeHelper.compare(25, (Object)this.getTSSDItemId(), (Object)this.tssditem.getTSSDItemId()) != 0L) {
                this.tssditem = null;
            }
            if (this.tssditem == null) {
                TSSDItem tssditem = new TSSDItem();
                tssditem.setTSSDItemId(this.getTSSDItemId());
                TSSDItemService service = (TSSDItemService)ServiceGlobal.getService(TSSDItemService.class, this.getSessionFactory());
                service.autoGet(tssditem);
                this.tssditem = tssditem;
            }
            return this.tssditem;
        }
    }

    private TSSDGroupDetailBase getProxyEntity() {
        return this.proxyTSSDGroupDetailBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyTSSDGroupDetailBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof TSSDGroupDetailBase) {
            this.proxyTSSDGroupDetailBase = (TSSDGroupDetailBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.TSSDGroupDetailService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

