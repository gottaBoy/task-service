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
import net.ibizsys.psrt.srv.common.entity.DataAudit;
import net.ibizsys.psrt.srv.common.service.DataAuditService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class DataAuditDetailBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(DataAuditDetailBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DATAAUDITDETAILID = "DATAAUDITDETAILID";
    public static final String FIELD_DATAAUDITDETAILNAME = "DATAAUDITDETAILNAME";
    public static final String FIELD_DATAAUDITID = "DATAAUDITID";
    public static final String FIELD_DATAAUDITNAME = "DATAAUDITNAME";
    public static final String FIELD_NEWTEXT = "NEWTEXT";
    public static final String FIELD_NEWVALUE = "NEWVALUE";
    public static final String FIELD_OLDTEXT = "OLDTEXT";
    public static final String FIELD_OLDVALUE = "OLDVALUE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DATAAUDITDETAILID = 2;
    private static final int INDEX_DATAAUDITDETAILNAME = 3;
    private static final int INDEX_DATAAUDITID = 4;
    private static final int INDEX_DATAAUDITNAME = 5;
    private static final int INDEX_NEWTEXT = 6;
    private static final int INDEX_NEWVALUE = 7;
    private static final int INDEX_OLDTEXT = 8;
    private static final int INDEX_OLDVALUE = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private DataAuditDetailBase proxyDataAuditDetailBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dataauditdetailidDirtyFlag = false;
    private boolean dataauditdetailnameDirtyFlag = false;
    private boolean dataauditidDirtyFlag = false;
    private boolean dataauditnameDirtyFlag = false;
    private boolean newtextDirtyFlag = false;
    private boolean newvalueDirtyFlag = false;
    private boolean oldtextDirtyFlag = false;
    private boolean oldvalueDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dataauditdetailid")
    private String dataauditdetailid;
    @Column(name="dataauditdetailname")
    private String dataauditdetailname;
    @Column(name="dataauditid")
    private String dataauditid;
    @Column(name="dataauditname")
    private String dataauditname;
    @Column(name="newtext")
    private String newtext;
    @Column(name="newvalue")
    private String newvalue;
    @Column(name="oldtext")
    private String oldtext;
    @Column(name="oldvalue")
    private String oldvalue;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objDataAuditLock = new Integer(1);
    private DataAudit dataaudit = null;

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DATAAUDITDETAILID, 2);
        fieldIndexMap.put(FIELD_DATAAUDITDETAILNAME, 3);
        fieldIndexMap.put(FIELD_DATAAUDITID, 4);
        fieldIndexMap.put(FIELD_DATAAUDITNAME, 5);
        fieldIndexMap.put(FIELD_NEWTEXT, 6);
        fieldIndexMap.put(FIELD_NEWVALUE, 7);
        fieldIndexMap.put(FIELD_OLDTEXT, 8);
        fieldIndexMap.put(FIELD_OLDVALUE, 9);
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

    public void setDataAuditDetailId(String dataauditdetailid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDataAuditDetailId(dataauditdetailid);
            return;
        }
        if (dataauditdetailid != null && (dataauditdetailid = StringHelper.trimRight(dataauditdetailid)).length() == 0) {
            dataauditdetailid = null;
        }
        this.dataauditdetailid = dataauditdetailid;
        this.dataauditdetailidDirtyFlag = true;
    }

    public String getDataAuditDetailId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDataAuditDetailId();
        }
        return this.dataauditdetailid;
    }

    public boolean isDataAuditDetailIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataAuditDetailIdDirty();
        }
        return this.dataauditdetailidDirtyFlag;
    }

    public void resetDataAuditDetailId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDataAuditDetailId();
            return;
        }
        this.dataauditdetailidDirtyFlag = false;
        this.dataauditdetailid = null;
    }

    public void setDataAuditDetailName(String dataauditdetailname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDataAuditDetailName(dataauditdetailname);
            return;
        }
        if (dataauditdetailname != null && (dataauditdetailname = StringHelper.trimRight(dataauditdetailname)).length() == 0) {
            dataauditdetailname = null;
        }
        this.dataauditdetailname = dataauditdetailname;
        this.dataauditdetailnameDirtyFlag = true;
    }

    public String getDataAuditDetailName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDataAuditDetailName();
        }
        return this.dataauditdetailname;
    }

    public boolean isDataAuditDetailNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataAuditDetailNameDirty();
        }
        return this.dataauditdetailnameDirtyFlag;
    }

    public void resetDataAuditDetailName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDataAuditDetailName();
            return;
        }
        this.dataauditdetailnameDirtyFlag = false;
        this.dataauditdetailname = null;
    }

    public void setDataAuditId(String dataauditid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDataAuditId(dataauditid);
            return;
        }
        if (dataauditid != null && (dataauditid = StringHelper.trimRight(dataauditid)).length() == 0) {
            dataauditid = null;
        }
        this.dataauditid = dataauditid;
        this.dataauditidDirtyFlag = true;
    }

    public String getDataAuditId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDataAuditId();
        }
        return this.dataauditid;
    }

    public boolean isDataAuditIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataAuditIdDirty();
        }
        return this.dataauditidDirtyFlag;
    }

    public void resetDataAuditId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDataAuditId();
            return;
        }
        this.dataauditidDirtyFlag = false;
        this.dataauditid = null;
    }

    public void setDataAuditName(String dataauditname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDataAuditName(dataauditname);
            return;
        }
        if (dataauditname != null && (dataauditname = StringHelper.trimRight(dataauditname)).length() == 0) {
            dataauditname = null;
        }
        this.dataauditname = dataauditname;
        this.dataauditnameDirtyFlag = true;
    }

    public String getDataAuditName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDataAuditName();
        }
        return this.dataauditname;
    }

    public boolean isDataAuditNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataAuditNameDirty();
        }
        return this.dataauditnameDirtyFlag;
    }

    public void resetDataAuditName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDataAuditName();
            return;
        }
        this.dataauditnameDirtyFlag = false;
        this.dataauditname = null;
    }

    public void setNewText(String newtext) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNewText(newtext);
            return;
        }
        if (newtext != null && (newtext = StringHelper.trimRight(newtext)).length() == 0) {
            newtext = null;
        }
        this.newtext = newtext;
        this.newtextDirtyFlag = true;
    }

    public String getNewText() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNewText();
        }
        return this.newtext;
    }

    public boolean isNewTextDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNewTextDirty();
        }
        return this.newtextDirtyFlag;
    }

    public void resetNewText() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNewText();
            return;
        }
        this.newtextDirtyFlag = false;
        this.newtext = null;
    }

    public void setNewValue(String newvalue) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNewValue(newvalue);
            return;
        }
        if (newvalue != null && (newvalue = StringHelper.trimRight(newvalue)).length() == 0) {
            newvalue = null;
        }
        this.newvalue = newvalue;
        this.newvalueDirtyFlag = true;
    }

    public String getNewValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNewValue();
        }
        return this.newvalue;
    }

    public boolean isNewValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNewValueDirty();
        }
        return this.newvalueDirtyFlag;
    }

    public void resetNewValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNewValue();
            return;
        }
        this.newvalueDirtyFlag = false;
        this.newvalue = null;
    }

    public void setOldText(String oldtext) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOldText(oldtext);
            return;
        }
        if (oldtext != null && (oldtext = StringHelper.trimRight(oldtext)).length() == 0) {
            oldtext = null;
        }
        this.oldtext = oldtext;
        this.oldtextDirtyFlag = true;
    }

    public String getOldText() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOldText();
        }
        return this.oldtext;
    }

    public boolean isOldTextDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOldTextDirty();
        }
        return this.oldtextDirtyFlag;
    }

    public void resetOldText() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOldText();
            return;
        }
        this.oldtextDirtyFlag = false;
        this.oldtext = null;
    }

    public void setOldValue(String oldvalue) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOldValue(oldvalue);
            return;
        }
        if (oldvalue != null && (oldvalue = StringHelper.trimRight(oldvalue)).length() == 0) {
            oldvalue = null;
        }
        this.oldvalue = oldvalue;
        this.oldvalueDirtyFlag = true;
    }

    public String getOldValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOldValue();
        }
        return this.oldvalue;
    }

    public boolean isOldValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOldValueDirty();
        }
        return this.oldvalueDirtyFlag;
    }

    public void resetOldValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOldValue();
            return;
        }
        this.oldvalueDirtyFlag = false;
        this.oldvalue = null;
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
        DataAuditDetailBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(DataAuditDetailBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetDataAuditDetailId();
        et.resetDataAuditDetailName();
        et.resetDataAuditId();
        et.resetDataAuditName();
        et.resetNewText();
        et.resetNewValue();
        et.resetOldText();
        et.resetOldValue();
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
        if (!bDirtyOnly || this.isDataAuditDetailIdDirty()) {
            params.put(FIELD_DATAAUDITDETAILID, this.getDataAuditDetailId());
        }
        if (!bDirtyOnly || this.isDataAuditDetailNameDirty()) {
            params.put(FIELD_DATAAUDITDETAILNAME, this.getDataAuditDetailName());
        }
        if (!bDirtyOnly || this.isDataAuditIdDirty()) {
            params.put(FIELD_DATAAUDITID, this.getDataAuditId());
        }
        if (!bDirtyOnly || this.isDataAuditNameDirty()) {
            params.put(FIELD_DATAAUDITNAME, this.getDataAuditName());
        }
        if (!bDirtyOnly || this.isNewTextDirty()) {
            params.put(FIELD_NEWTEXT, this.getNewText());
        }
        if (!bDirtyOnly || this.isNewValueDirty()) {
            params.put(FIELD_NEWVALUE, this.getNewValue());
        }
        if (!bDirtyOnly || this.isOldTextDirty()) {
            params.put(FIELD_OLDTEXT, this.getOldText());
        }
        if (!bDirtyOnly || this.isOldValueDirty()) {
            params.put(FIELD_OLDVALUE, this.getOldValue());
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
        return DataAuditDetailBase.get(this, index);
    }

    private static Object get(DataAuditDetailBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate();
            }
            case 1: {
                return et.getCreateMan();
            }
            case 2: {
                return et.getDataAuditDetailId();
            }
            case 3: {
                return et.getDataAuditDetailName();
            }
            case 4: {
                return et.getDataAuditId();
            }
            case 5: {
                return et.getDataAuditName();
            }
            case 6: {
                return et.getNewText();
            }
            case 7: {
                return et.getNewValue();
            }
            case 8: {
                return et.getOldText();
            }
            case 9: {
                return et.getOldValue();
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
        DataAuditDetailBase.set(this, index, objValue);
    }

    private static void set(DataAuditDetailBase et, int index, Object obj) throws Exception {
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
                et.setDataAuditDetailId(DataObject.getStringValue(obj));
                return;
            }
            case 3: {
                et.setDataAuditDetailName(DataObject.getStringValue(obj));
                return;
            }
            case 4: {
                et.setDataAuditId(DataObject.getStringValue(obj));
                return;
            }
            case 5: {
                et.setDataAuditName(DataObject.getStringValue(obj));
                return;
            }
            case 6: {
                et.setNewText(DataObject.getStringValue(obj));
                return;
            }
            case 7: {
                et.setNewValue(DataObject.getStringValue(obj));
                return;
            }
            case 8: {
                et.setOldText(DataObject.getStringValue(obj));
                return;
            }
            case 9: {
                et.setOldValue(DataObject.getStringValue(obj));
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
        return DataAuditDetailBase.isNull(this, index);
    }

    private static boolean isNull(DataAuditDetailBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate() == null;
            }
            case 1: {
                return et.getCreateMan() == null;
            }
            case 2: {
                return et.getDataAuditDetailId() == null;
            }
            case 3: {
                return et.getDataAuditDetailName() == null;
            }
            case 4: {
                return et.getDataAuditId() == null;
            }
            case 5: {
                return et.getDataAuditName() == null;
            }
            case 6: {
                return et.getNewText() == null;
            }
            case 7: {
                return et.getNewValue() == null;
            }
            case 8: {
                return et.getOldText() == null;
            }
            case 9: {
                return et.getOldValue() == null;
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
        return DataAuditDetailBase.contains(this, index);
    }

    private static boolean contains(DataAuditDetailBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isCreateDateDirty();
            }
            case 1: {
                return et.isCreateManDirty();
            }
            case 2: {
                return et.isDataAuditDetailIdDirty();
            }
            case 3: {
                return et.isDataAuditDetailNameDirty();
            }
            case 4: {
                return et.isDataAuditIdDirty();
            }
            case 5: {
                return et.isDataAuditNameDirty();
            }
            case 6: {
                return et.isNewTextDirty();
            }
            case 7: {
                return et.isNewValueDirty();
            }
            case 8: {
                return et.isOldTextDirty();
            }
            case 9: {
                return et.isOldValueDirty();
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
        DataAuditDetailBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(DataAuditDetailBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", DataAuditDetailBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", DataAuditDetailBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getDataAuditDetailId() != null) {
            JSONObjectHelper.put(json, "dataauditdetailid", DataAuditDetailBase.getJSONValue(et.getDataAuditDetailId()), false);
        }
        if (bIncEmpty || et.getDataAuditDetailName() != null) {
            JSONObjectHelper.put(json, "dataauditdetailname", DataAuditDetailBase.getJSONValue(et.getDataAuditDetailName()), false);
        }
        if (bIncEmpty || et.getDataAuditId() != null) {
            JSONObjectHelper.put(json, "dataauditid", DataAuditDetailBase.getJSONValue(et.getDataAuditId()), false);
        }
        if (bIncEmpty || et.getDataAuditName() != null) {
            JSONObjectHelper.put(json, "dataauditname", DataAuditDetailBase.getJSONValue(et.getDataAuditName()), false);
        }
        if (bIncEmpty || et.getNewText() != null) {
            JSONObjectHelper.put(json, "newtext", DataAuditDetailBase.getJSONValue(et.getNewText()), false);
        }
        if (bIncEmpty || et.getNewValue() != null) {
            JSONObjectHelper.put(json, "newvalue", DataAuditDetailBase.getJSONValue(et.getNewValue()), false);
        }
        if (bIncEmpty || et.getOldText() != null) {
            JSONObjectHelper.put(json, "oldtext", DataAuditDetailBase.getJSONValue(et.getOldText()), false);
        }
        if (bIncEmpty || et.getOldValue() != null) {
            JSONObjectHelper.put(json, "oldvalue", DataAuditDetailBase.getJSONValue(et.getOldValue()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", DataAuditDetailBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", DataAuditDetailBase.getJSONValue(et.getUpdateMan()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        DataAuditDetailBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(DataAuditDetailBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getCreateDate() != null) {
            obj = et.getCreateDate();
            node.setAttribute(FIELD_CREATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            obj = et.getCreateMan();
            node.setAttribute(FIELD_CREATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDataAuditDetailId() != null) {
            obj = et.getDataAuditDetailId();
            node.setAttribute(FIELD_DATAAUDITDETAILID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDataAuditDetailName() != null) {
            obj = et.getDataAuditDetailName();
            node.setAttribute(FIELD_DATAAUDITDETAILNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDataAuditId() != null) {
            obj = et.getDataAuditId();
            node.setAttribute(FIELD_DATAAUDITID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDataAuditName() != null) {
            obj = et.getDataAuditName();
            node.setAttribute(FIELD_DATAAUDITNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getNewText() != null) {
            obj = et.getNewText();
            node.setAttribute(FIELD_NEWTEXT, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getNewValue() != null) {
            obj = et.getNewValue();
            node.setAttribute(FIELD_NEWVALUE, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getOldText() != null) {
            obj = et.getOldText();
            node.setAttribute(FIELD_OLDTEXT, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getOldValue() != null) {
            obj = et.getOldValue();
            node.setAttribute(FIELD_OLDVALUE, obj == null ? "" : (String)obj);
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
        DataAuditDetailBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(DataAuditDetailBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isCreateDateDirty() && (bIncEmpty || et.getCreateDate() != null)) {
            dst.set(FIELD_CREATEDATE, et.getCreateDate());
        }
        if (et.isCreateManDirty() && (bIncEmpty || et.getCreateMan() != null)) {
            dst.set(FIELD_CREATEMAN, et.getCreateMan());
        }
        if (et.isDataAuditDetailIdDirty() && (bIncEmpty || et.getDataAuditDetailId() != null)) {
            dst.set(FIELD_DATAAUDITDETAILID, et.getDataAuditDetailId());
        }
        if (et.isDataAuditDetailNameDirty() && (bIncEmpty || et.getDataAuditDetailName() != null)) {
            dst.set(FIELD_DATAAUDITDETAILNAME, et.getDataAuditDetailName());
        }
        if (et.isDataAuditIdDirty() && (bIncEmpty || et.getDataAuditId() != null)) {
            dst.set(FIELD_DATAAUDITID, et.getDataAuditId());
        }
        if (et.isDataAuditNameDirty() && (bIncEmpty || et.getDataAuditName() != null)) {
            dst.set(FIELD_DATAAUDITNAME, et.getDataAuditName());
        }
        if (et.isNewTextDirty() && (bIncEmpty || et.getNewText() != null)) {
            dst.set(FIELD_NEWTEXT, et.getNewText());
        }
        if (et.isNewValueDirty() && (bIncEmpty || et.getNewValue() != null)) {
            dst.set(FIELD_NEWVALUE, et.getNewValue());
        }
        if (et.isOldTextDirty() && (bIncEmpty || et.getOldText() != null)) {
            dst.set(FIELD_OLDTEXT, et.getOldText());
        }
        if (et.isOldValueDirty() && (bIncEmpty || et.getOldValue() != null)) {
            dst.set(FIELD_OLDVALUE, et.getOldValue());
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
        return DataAuditDetailBase.remove(this, index);
    }

    private static boolean remove(DataAuditDetailBase et, int index) throws Exception {
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
                et.resetDataAuditDetailId();
                return true;
            }
            case 3: {
                et.resetDataAuditDetailName();
                return true;
            }
            case 4: {
                et.resetDataAuditId();
                return true;
            }
            case 5: {
                et.resetDataAuditName();
                return true;
            }
            case 6: {
                et.resetNewText();
                return true;
            }
            case 7: {
                et.resetNewValue();
                return true;
            }
            case 8: {
                et.resetOldText();
                return true;
            }
            case 9: {
                et.resetOldValue();
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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public DataAudit getDataAudit() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDataAudit();
        }
        if (this.getDataAuditId() == null) {
            return null;
        }
        Integer n = this.objDataAuditLock;
        synchronized (n) {
            if (this.dataaudit != null && DataTypeHelper.compare(25, (Object)this.getDataAuditId(), (Object)this.dataaudit.getDataAuditId()) != 0L) {
                this.dataaudit = null;
            }
            if (this.dataaudit == null) {
                DataAudit dataaudit = new DataAudit();
                dataaudit.setDataAuditId(this.getDataAuditId());
                DataAuditService service = (DataAuditService)ServiceGlobal.getService(DataAuditService.class, this.getSessionFactory());
                service.autoGet(dataaudit);
                this.dataaudit = dataaudit;
            }
            return this.dataaudit;
        }
    }

    private DataAuditDetailBase getProxyEntity() {
        return this.proxyDataAuditDetailBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyDataAuditDetailBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof DataAuditDetailBase) {
            this.proxyDataAuditDetailBase = (DataAuditDetailBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.DataAuditDetailService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

