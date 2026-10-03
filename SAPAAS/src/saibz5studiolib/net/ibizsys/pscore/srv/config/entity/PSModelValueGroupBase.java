/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.entity.IEntityActionHelper
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.DataTypeHelper
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
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.config.entity.PSModel;
import net.ibizsys.pscore.srv.config.entity.PSModelField;
import net.ibizsys.pscore.srv.config.service.PSModelFieldService;
import net.ibizsys.pscore.srv.config.service.PSModelService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSModelValueGroupBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSModelValueGroupBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_GROUPDESC = "GROUPDESC";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSCODELISTID = "PSCODELISTID";
    public static final String FIELD_PSCODELISTNAME = "PSCODELISTNAME";
    public static final String FIELD_PSMODELFIELDID = "PSMODELFIELDID";
    public static final String FIELD_PSMODELFIELDNAME = "PSMODELFIELDNAME";
    public static final String FIELD_PSMODELID = "PSMODELID";
    public static final String FIELD_PSMODELNAME = "PSMODELNAME";
    public static final String FIELD_PSMODELVALUEGROUPID = "PSMODELVALUEGROUPID";
    public static final String FIELD_PSMODELVALUEGROUPNAME = "PSMODELVALUEGROUPNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_GROUPDESC = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSCODELISTID = 4;
    private static final int INDEX_PSCODELISTNAME = 5;
    private static final int INDEX_PSMODELFIELDID = 6;
    private static final int INDEX_PSMODELFIELDNAME = 7;
    private static final int INDEX_PSMODELID = 8;
    private static final int INDEX_PSMODELNAME = 9;
    private static final int INDEX_PSMODELVALUEGROUPID = 10;
    private static final int INDEX_PSMODELVALUEGROUPNAME = 11;
    private static final int INDEX_UPDATEDATE = 12;
    private static final int INDEX_UPDATEMAN = 13;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSModelValueGroupBase proxyPSModelValueGroupBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean groupdescDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pscodelistidDirtyFlag = false;
    private boolean pscodelistnameDirtyFlag = false;
    private boolean psmodelfieldidDirtyFlag = false;
    private boolean psmodelfieldnameDirtyFlag = false;
    private boolean psmodelidDirtyFlag = false;
    private boolean psmodelnameDirtyFlag = false;
    private boolean psmodelvaluegroupidDirtyFlag = false;
    private boolean psmodelvaluegroupnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="groupdesc")
    private String groupdesc;
    @Column(name="memo")
    private String memo;
    @Column(name="pscodelistid")
    private String pscodelistid;
    @Column(name="pscodelistname")
    private String pscodelistname;
    @Column(name="psmodelfieldid")
    private String psmodelfieldid;
    @Column(name="psmodelfieldname")
    private String psmodelfieldname;
    @Column(name="psmodelid")
    private String psmodelid;
    @Column(name="psmodelname")
    private String psmodelname;
    @Column(name="psmodelvaluegroupid")
    private String psmodelvaluegroupid;
    @Column(name="psmodelvaluegroupname")
    private String psmodelvaluegroupname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSModelFieldLock = new Integer(1);
    private PSModelField psmodelfield = null;
    private Integer objPsmodelLock = new Integer(1);
    private PSModel psmodel = null;

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

    public void setGroupDesc(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupDesc(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.groupdesc = string;
        this.groupdescDirtyFlag = true;
    }

    public String getGroupDesc() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupDesc();
        }
        return this.groupdesc;
    }

    public boolean isGroupDescDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupDescDirty();
        }
        return this.groupdescDirtyFlag;
    }

    public void resetGroupDesc() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupDesc();
            return;
        }
        this.groupdescDirtyFlag = false;
        this.groupdesc = null;
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

    public void setPSCodeListId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCodeListId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscodelistid = string;
        this.pscodelistidDirtyFlag = true;
    }

    public String getPSCodeListId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCodeListId();
        }
        return this.pscodelistid;
    }

    public boolean isPSCodeListIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCodeListIdDirty();
        }
        return this.pscodelistidDirtyFlag;
    }

    public void resetPSCodeListId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCodeListId();
            return;
        }
        this.pscodelistidDirtyFlag = false;
        this.pscodelistid = null;
    }

    public void setPSCodeListName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCodeListName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscodelistname = string;
        this.pscodelistnameDirtyFlag = true;
    }

    public String getPSCodeListName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCodeListName();
        }
        return this.pscodelistname;
    }

    public boolean isPSCodeListNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCodeListNameDirty();
        }
        return this.pscodelistnameDirtyFlag;
    }

    public void resetPSCodeListName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCodeListName();
            return;
        }
        this.pscodelistnameDirtyFlag = false;
        this.pscodelistname = null;
    }

    public void setPSModelFieldId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelFieldId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelfieldid = string;
        this.psmodelfieldidDirtyFlag = true;
    }

    public String getPSModelFieldId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelFieldId();
        }
        return this.psmodelfieldid;
    }

    public boolean isPSModelFieldIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelFieldIdDirty();
        }
        return this.psmodelfieldidDirtyFlag;
    }

    public void resetPSModelFieldId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelFieldId();
            return;
        }
        this.psmodelfieldidDirtyFlag = false;
        this.psmodelfieldid = null;
    }

    public void setPSModelFieldName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelFieldName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelfieldname = string;
        this.psmodelfieldnameDirtyFlag = true;
    }

    public String getPSModelFieldName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelFieldName();
        }
        return this.psmodelfieldname;
    }

    public boolean isPSModelFieldNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelFieldNameDirty();
        }
        return this.psmodelfieldnameDirtyFlag;
    }

    public void resetPSModelFieldName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelFieldName();
            return;
        }
        this.psmodelfieldnameDirtyFlag = false;
        this.psmodelfieldname = null;
    }

    public void setPSModelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelid = string;
        this.psmodelidDirtyFlag = true;
    }

    public String getPSModelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelId();
        }
        return this.psmodelid;
    }

    public boolean isPSModelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelIdDirty();
        }
        return this.psmodelidDirtyFlag;
    }

    public void resetPSModelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelId();
            return;
        }
        this.psmodelidDirtyFlag = false;
        this.psmodelid = null;
    }

    public void setPSModelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelname = string;
        this.psmodelnameDirtyFlag = true;
    }

    public String getPSModelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelName();
        }
        return this.psmodelname;
    }

    public boolean isPSModelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelNameDirty();
        }
        return this.psmodelnameDirtyFlag;
    }

    public void resetPSModelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelName();
            return;
        }
        this.psmodelnameDirtyFlag = false;
        this.psmodelname = null;
    }

    public void setPSModelValueGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelValueGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelvaluegroupid = string;
        this.psmodelvaluegroupidDirtyFlag = true;
    }

    public String getPSModelValueGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelValueGroupId();
        }
        return this.psmodelvaluegroupid;
    }

    public boolean isPSModelValueGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelValueGroupIdDirty();
        }
        return this.psmodelvaluegroupidDirtyFlag;
    }

    public void resetPSModelValueGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelValueGroupId();
            return;
        }
        this.psmodelvaluegroupidDirtyFlag = false;
        this.psmodelvaluegroupid = null;
    }

    public void setPSModelValueGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelValueGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelvaluegroupname = string;
        this.psmodelvaluegroupnameDirtyFlag = true;
    }

    public String getPSModelValueGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelValueGroupName();
        }
        return this.psmodelvaluegroupname;
    }

    public boolean isPSModelValueGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelValueGroupNameDirty();
        }
        return this.psmodelvaluegroupnameDirtyFlag;
    }

    public void resetPSModelValueGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelValueGroupName();
            return;
        }
        this.psmodelvaluegroupnameDirtyFlag = false;
        this.psmodelvaluegroupname = null;
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

    protected void onReset() {
        PSModelValueGroupBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSModelValueGroupBase pSModelValueGroupBase) {
        pSModelValueGroupBase.resetCreateDate();
        pSModelValueGroupBase.resetCreateMan();
        pSModelValueGroupBase.resetGroupDesc();
        pSModelValueGroupBase.resetMemo();
        pSModelValueGroupBase.resetPSCodeListId();
        pSModelValueGroupBase.resetPSCodeListName();
        pSModelValueGroupBase.resetPSModelFieldId();
        pSModelValueGroupBase.resetPSModelFieldName();
        pSModelValueGroupBase.resetPSModelId();
        pSModelValueGroupBase.resetPSModelName();
        pSModelValueGroupBase.resetPSModelValueGroupId();
        pSModelValueGroupBase.resetPSModelValueGroupName();
        pSModelValueGroupBase.resetUpdateDate();
        pSModelValueGroupBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isGroupDescDirty()) {
            hashMap.put(FIELD_GROUPDESC, this.getGroupDesc());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSCodeListIdDirty()) {
            hashMap.put(FIELD_PSCODELISTID, this.getPSCodeListId());
        }
        if (!bl || this.isPSCodeListNameDirty()) {
            hashMap.put(FIELD_PSCODELISTNAME, this.getPSCodeListName());
        }
        if (!bl || this.isPSModelFieldIdDirty()) {
            hashMap.put(FIELD_PSMODELFIELDID, this.getPSModelFieldId());
        }
        if (!bl || this.isPSModelFieldNameDirty()) {
            hashMap.put(FIELD_PSMODELFIELDNAME, this.getPSModelFieldName());
        }
        if (!bl || this.isPSModelIdDirty()) {
            hashMap.put(FIELD_PSMODELID, this.getPSModelId());
        }
        if (!bl || this.isPSModelNameDirty()) {
            hashMap.put(FIELD_PSMODELNAME, this.getPSModelName());
        }
        if (!bl || this.isPSModelValueGroupIdDirty()) {
            hashMap.put(FIELD_PSMODELVALUEGROUPID, this.getPSModelValueGroupId());
        }
        if (!bl || this.isPSModelValueGroupNameDirty()) {
            hashMap.put(FIELD_PSMODELVALUEGROUPNAME, this.getPSModelValueGroupName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
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
        return PSModelValueGroupBase.get(this, n);
    }

    private static Object get(PSModelValueGroupBase pSModelValueGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelValueGroupBase.getCreateDate();
            }
            case 1: {
                return pSModelValueGroupBase.getCreateMan();
            }
            case 2: {
                return pSModelValueGroupBase.getGroupDesc();
            }
            case 3: {
                return pSModelValueGroupBase.getMemo();
            }
            case 4: {
                return pSModelValueGroupBase.getPSCodeListId();
            }
            case 5: {
                return pSModelValueGroupBase.getPSCodeListName();
            }
            case 6: {
                return pSModelValueGroupBase.getPSModelFieldId();
            }
            case 7: {
                return pSModelValueGroupBase.getPSModelFieldName();
            }
            case 8: {
                return pSModelValueGroupBase.getPSModelId();
            }
            case 9: {
                return pSModelValueGroupBase.getPSModelName();
            }
            case 10: {
                return pSModelValueGroupBase.getPSModelValueGroupId();
            }
            case 11: {
                return pSModelValueGroupBase.getPSModelValueGroupName();
            }
            case 12: {
                return pSModelValueGroupBase.getUpdateDate();
            }
            case 13: {
                return pSModelValueGroupBase.getUpdateMan();
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
        PSModelValueGroupBase.set(this, n, object);
    }

    private static void set(PSModelValueGroupBase pSModelValueGroupBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSModelValueGroupBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSModelValueGroupBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSModelValueGroupBase.setGroupDesc(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSModelValueGroupBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSModelValueGroupBase.setPSCodeListId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSModelValueGroupBase.setPSCodeListName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSModelValueGroupBase.setPSModelFieldId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSModelValueGroupBase.setPSModelFieldName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSModelValueGroupBase.setPSModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSModelValueGroupBase.setPSModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSModelValueGroupBase.setPSModelValueGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSModelValueGroupBase.setPSModelValueGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSModelValueGroupBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 13: {
                pSModelValueGroupBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSModelValueGroupBase.isNull(this, n);
    }

    private static boolean isNull(PSModelValueGroupBase pSModelValueGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelValueGroupBase.getCreateDate() == null;
            }
            case 1: {
                return pSModelValueGroupBase.getCreateMan() == null;
            }
            case 2: {
                return pSModelValueGroupBase.getGroupDesc() == null;
            }
            case 3: {
                return pSModelValueGroupBase.getMemo() == null;
            }
            case 4: {
                return pSModelValueGroupBase.getPSCodeListId() == null;
            }
            case 5: {
                return pSModelValueGroupBase.getPSCodeListName() == null;
            }
            case 6: {
                return pSModelValueGroupBase.getPSModelFieldId() == null;
            }
            case 7: {
                return pSModelValueGroupBase.getPSModelFieldName() == null;
            }
            case 8: {
                return pSModelValueGroupBase.getPSModelId() == null;
            }
            case 9: {
                return pSModelValueGroupBase.getPSModelName() == null;
            }
            case 10: {
                return pSModelValueGroupBase.getPSModelValueGroupId() == null;
            }
            case 11: {
                return pSModelValueGroupBase.getPSModelValueGroupName() == null;
            }
            case 12: {
                return pSModelValueGroupBase.getUpdateDate() == null;
            }
            case 13: {
                return pSModelValueGroupBase.getUpdateMan() == null;
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
        return PSModelValueGroupBase.contains(this, n);
    }

    private static boolean contains(PSModelValueGroupBase pSModelValueGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelValueGroupBase.isCreateDateDirty();
            }
            case 1: {
                return pSModelValueGroupBase.isCreateManDirty();
            }
            case 2: {
                return pSModelValueGroupBase.isGroupDescDirty();
            }
            case 3: {
                return pSModelValueGroupBase.isMemoDirty();
            }
            case 4: {
                return pSModelValueGroupBase.isPSCodeListIdDirty();
            }
            case 5: {
                return pSModelValueGroupBase.isPSCodeListNameDirty();
            }
            case 6: {
                return pSModelValueGroupBase.isPSModelFieldIdDirty();
            }
            case 7: {
                return pSModelValueGroupBase.isPSModelFieldNameDirty();
            }
            case 8: {
                return pSModelValueGroupBase.isPSModelIdDirty();
            }
            case 9: {
                return pSModelValueGroupBase.isPSModelNameDirty();
            }
            case 10: {
                return pSModelValueGroupBase.isPSModelValueGroupIdDirty();
            }
            case 11: {
                return pSModelValueGroupBase.isPSModelValueGroupNameDirty();
            }
            case 12: {
                return pSModelValueGroupBase.isUpdateDateDirty();
            }
            case 13: {
                return pSModelValueGroupBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSModelValueGroupBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSModelValueGroupBase pSModelValueGroupBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSModelValueGroupBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSModelValueGroupBase.getJSONValue((Object)pSModelValueGroupBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSModelValueGroupBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSModelValueGroupBase.getJSONValue((Object)pSModelValueGroupBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSModelValueGroupBase.getGroupDesc() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"groupdesc", (Object)PSModelValueGroupBase.getJSONValue((Object)pSModelValueGroupBase.getGroupDesc()), (boolean)false);
        }
        if (bl || pSModelValueGroupBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSModelValueGroupBase.getJSONValue((Object)pSModelValueGroupBase.getMemo()), (boolean)false);
        }
        if (bl || pSModelValueGroupBase.getPSCodeListId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscodelistid", (Object)PSModelValueGroupBase.getJSONValue((Object)pSModelValueGroupBase.getPSCodeListId()), (boolean)false);
        }
        if (bl || pSModelValueGroupBase.getPSCodeListName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscodelistname", (Object)PSModelValueGroupBase.getJSONValue((Object)pSModelValueGroupBase.getPSCodeListName()), (boolean)false);
        }
        if (bl || pSModelValueGroupBase.getPSModelFieldId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelfieldid", (Object)PSModelValueGroupBase.getJSONValue((Object)pSModelValueGroupBase.getPSModelFieldId()), (boolean)false);
        }
        if (bl || pSModelValueGroupBase.getPSModelFieldName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelfieldname", (Object)PSModelValueGroupBase.getJSONValue((Object)pSModelValueGroupBase.getPSModelFieldName()), (boolean)false);
        }
        if (bl || pSModelValueGroupBase.getPSModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelid", (Object)PSModelValueGroupBase.getJSONValue((Object)pSModelValueGroupBase.getPSModelId()), (boolean)false);
        }
        if (bl || pSModelValueGroupBase.getPSModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelname", (Object)PSModelValueGroupBase.getJSONValue((Object)pSModelValueGroupBase.getPSModelName()), (boolean)false);
        }
        if (bl || pSModelValueGroupBase.getPSModelValueGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelvaluegroupid", (Object)PSModelValueGroupBase.getJSONValue((Object)pSModelValueGroupBase.getPSModelValueGroupId()), (boolean)false);
        }
        if (bl || pSModelValueGroupBase.getPSModelValueGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelvaluegroupname", (Object)PSModelValueGroupBase.getJSONValue((Object)pSModelValueGroupBase.getPSModelValueGroupName()), (boolean)false);
        }
        if (bl || pSModelValueGroupBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSModelValueGroupBase.getJSONValue((Object)pSModelValueGroupBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSModelValueGroupBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSModelValueGroupBase.getJSONValue((Object)pSModelValueGroupBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSModelValueGroupBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSModelValueGroupBase pSModelValueGroupBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSModelValueGroupBase.getCreateDate() != null) {
            object = pSModelValueGroupBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelValueGroupBase.getCreateMan() != null) {
            object = pSModelValueGroupBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSModelValueGroupBase.getGroupDesc() != null) {
            object = pSModelValueGroupBase.getGroupDesc();
            xmlNode.setAttribute(FIELD_GROUPDESC, object == null ? "" : (String)object);
        }
        if (bl || pSModelValueGroupBase.getMemo() != null) {
            object = pSModelValueGroupBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSModelValueGroupBase.getPSCodeListId() != null) {
            object = pSModelValueGroupBase.getPSCodeListId();
            xmlNode.setAttribute(FIELD_PSCODELISTID, object == null ? "" : (String)object);
        }
        if (bl || pSModelValueGroupBase.getPSCodeListName() != null) {
            object = pSModelValueGroupBase.getPSCodeListName();
            xmlNode.setAttribute(FIELD_PSCODELISTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelValueGroupBase.getPSModelFieldId() != null) {
            object = pSModelValueGroupBase.getPSModelFieldId();
            xmlNode.setAttribute(FIELD_PSMODELFIELDID, object == null ? "" : (String)object);
        }
        if (bl || pSModelValueGroupBase.getPSModelFieldName() != null) {
            object = pSModelValueGroupBase.getPSModelFieldName();
            xmlNode.setAttribute(FIELD_PSMODELFIELDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelValueGroupBase.getPSModelId() != null) {
            object = pSModelValueGroupBase.getPSModelId();
            xmlNode.setAttribute(FIELD_PSMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSModelValueGroupBase.getPSModelName() != null) {
            object = pSModelValueGroupBase.getPSModelName();
            xmlNode.setAttribute(FIELD_PSMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelValueGroupBase.getPSModelValueGroupId() != null) {
            object = pSModelValueGroupBase.getPSModelValueGroupId();
            xmlNode.setAttribute(FIELD_PSMODELVALUEGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSModelValueGroupBase.getPSModelValueGroupName() != null) {
            object = pSModelValueGroupBase.getPSModelValueGroupName();
            xmlNode.setAttribute(FIELD_PSMODELVALUEGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelValueGroupBase.getUpdateDate() != null) {
            object = pSModelValueGroupBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelValueGroupBase.getUpdateMan() != null) {
            object = pSModelValueGroupBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSModelValueGroupBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSModelValueGroupBase pSModelValueGroupBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSModelValueGroupBase.isCreateDateDirty() && (bl || pSModelValueGroupBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSModelValueGroupBase.getCreateDate());
        }
        if (pSModelValueGroupBase.isCreateManDirty() && (bl || pSModelValueGroupBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSModelValueGroupBase.getCreateMan());
        }
        if (pSModelValueGroupBase.isGroupDescDirty() && (bl || pSModelValueGroupBase.getGroupDesc() != null)) {
            iDataObject.set(FIELD_GROUPDESC, (Object)pSModelValueGroupBase.getGroupDesc());
        }
        if (pSModelValueGroupBase.isMemoDirty() && (bl || pSModelValueGroupBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSModelValueGroupBase.getMemo());
        }
        if (pSModelValueGroupBase.isPSCodeListIdDirty() && (bl || pSModelValueGroupBase.getPSCodeListId() != null)) {
            iDataObject.set(FIELD_PSCODELISTID, (Object)pSModelValueGroupBase.getPSCodeListId());
        }
        if (pSModelValueGroupBase.isPSCodeListNameDirty() && (bl || pSModelValueGroupBase.getPSCodeListName() != null)) {
            iDataObject.set(FIELD_PSCODELISTNAME, (Object)pSModelValueGroupBase.getPSCodeListName());
        }
        if (pSModelValueGroupBase.isPSModelFieldIdDirty() && (bl || pSModelValueGroupBase.getPSModelFieldId() != null)) {
            iDataObject.set(FIELD_PSMODELFIELDID, (Object)pSModelValueGroupBase.getPSModelFieldId());
        }
        if (pSModelValueGroupBase.isPSModelFieldNameDirty() && (bl || pSModelValueGroupBase.getPSModelFieldName() != null)) {
            iDataObject.set(FIELD_PSMODELFIELDNAME, (Object)pSModelValueGroupBase.getPSModelFieldName());
        }
        if (pSModelValueGroupBase.isPSModelIdDirty() && (bl || pSModelValueGroupBase.getPSModelId() != null)) {
            iDataObject.set(FIELD_PSMODELID, (Object)pSModelValueGroupBase.getPSModelId());
        }
        if (pSModelValueGroupBase.isPSModelNameDirty() && (bl || pSModelValueGroupBase.getPSModelName() != null)) {
            iDataObject.set(FIELD_PSMODELNAME, (Object)pSModelValueGroupBase.getPSModelName());
        }
        if (pSModelValueGroupBase.isPSModelValueGroupIdDirty() && (bl || pSModelValueGroupBase.getPSModelValueGroupId() != null)) {
            iDataObject.set(FIELD_PSMODELVALUEGROUPID, (Object)pSModelValueGroupBase.getPSModelValueGroupId());
        }
        if (pSModelValueGroupBase.isPSModelValueGroupNameDirty() && (bl || pSModelValueGroupBase.getPSModelValueGroupName() != null)) {
            iDataObject.set(FIELD_PSMODELVALUEGROUPNAME, (Object)pSModelValueGroupBase.getPSModelValueGroupName());
        }
        if (pSModelValueGroupBase.isUpdateDateDirty() && (bl || pSModelValueGroupBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSModelValueGroupBase.getUpdateDate());
        }
        if (pSModelValueGroupBase.isUpdateManDirty() && (bl || pSModelValueGroupBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSModelValueGroupBase.getUpdateMan());
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
        return PSModelValueGroupBase.remove(this, n);
    }

    private static boolean remove(PSModelValueGroupBase pSModelValueGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSModelValueGroupBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSModelValueGroupBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSModelValueGroupBase.resetGroupDesc();
                return true;
            }
            case 3: {
                pSModelValueGroupBase.resetMemo();
                return true;
            }
            case 4: {
                pSModelValueGroupBase.resetPSCodeListId();
                return true;
            }
            case 5: {
                pSModelValueGroupBase.resetPSCodeListName();
                return true;
            }
            case 6: {
                pSModelValueGroupBase.resetPSModelFieldId();
                return true;
            }
            case 7: {
                pSModelValueGroupBase.resetPSModelFieldName();
                return true;
            }
            case 8: {
                pSModelValueGroupBase.resetPSModelId();
                return true;
            }
            case 9: {
                pSModelValueGroupBase.resetPSModelName();
                return true;
            }
            case 10: {
                pSModelValueGroupBase.resetPSModelValueGroupId();
                return true;
            }
            case 11: {
                pSModelValueGroupBase.resetPSModelValueGroupName();
                return true;
            }
            case 12: {
                pSModelValueGroupBase.resetUpdateDate();
                return true;
            }
            case 13: {
                pSModelValueGroupBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSModelField getPSModelField() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelField();
        }
        if (this.getPSModelFieldId() == null) {
            return null;
        }
        Integer n = this.objPSModelFieldLock;
        synchronized (n) {
            if (this.psmodelfield != null && DataTypeHelper.compare((int)25, (Object)this.getPSModelFieldId(), (Object)this.psmodelfield.getPSModelFieldId()) != 0L) {
                this.psmodelfield = null;
            }
            if (this.psmodelfield == null) {
                PSModelField pSModelField = new PSModelField();
                pSModelField.setPSModelFieldId(this.getPSModelFieldId());
                PSModelFieldService pSModelFieldService = (PSModelFieldService)ServiceGlobal.getService(PSModelFieldService.class, (SessionFactory)this.getSessionFactory());
                pSModelFieldService.autoGet(pSModelField);
                this.psmodelfield = pSModelField;
            }
            return this.psmodelfield;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSModel getPsmodel() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPsmodel();
        }
        if (this.getPSModelId() == null) {
            return null;
        }
        Integer n = this.objPsmodelLock;
        synchronized (n) {
            if (this.psmodel != null && DataTypeHelper.compare((int)25, (Object)this.getPSModelId(), (Object)this.psmodel.getPSModelId()) != 0L) {
                this.psmodel = null;
            }
            if (this.psmodel == null) {
                PSModel pSModel = new PSModel();
                pSModel.setPSModelId(this.getPSModelId());
                PSModelService pSModelService = (PSModelService)ServiceGlobal.getService(PSModelService.class, (SessionFactory)this.getSessionFactory());
                pSModelService.autoGet(pSModel);
                this.psmodel = pSModel;
            }
            return this.psmodel;
        }
    }

    private PSModelValueGroupBase getProxyEntity() {
        return this.proxyPSModelValueGroupBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSModelValueGroupBase = null;
        if (iDataObject != null && iDataObject instanceof PSModelValueGroupBase) {
            this.proxyPSModelValueGroupBase = (PSModelValueGroupBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSModelValueGroupService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_GROUPDESC, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSCODELISTID, 4);
        fieldIndexMap.put(FIELD_PSCODELISTNAME, 5);
        fieldIndexMap.put(FIELD_PSMODELFIELDID, 6);
        fieldIndexMap.put(FIELD_PSMODELFIELDNAME, 7);
        fieldIndexMap.put(FIELD_PSMODELID, 8);
        fieldIndexMap.put(FIELD_PSMODELNAME, 9);
        fieldIndexMap.put(FIELD_PSMODELVALUEGROUPID, 10);
        fieldIndexMap.put(FIELD_PSMODELVALUEGROUPNAME, 11);
        fieldIndexMap.put(FIELD_UPDATEDATE, 12);
        fieldIndexMap.put(FIELD_UPDATEMAN, 13);
    }
}

