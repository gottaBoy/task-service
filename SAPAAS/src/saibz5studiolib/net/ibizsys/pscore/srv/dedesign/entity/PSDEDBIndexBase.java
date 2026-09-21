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
package net.ibizsys.pscore.srv.dedesign.entity;

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
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEDBIndexBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEDBIndexBase.class);
    public static final String FIELD_ALLOWREVERSE = "ALLOWREVERSE";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_INCFIELDS = "INCFIELDS";
    public static final String FIELD_INDEXFIELDS = "INDEXFIELDS";
    public static final String FIELD_INDEXTYPE = "INDEXTYPE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEDBINDEXID = "PSDEDBINDEXID";
    public static final String FIELD_PSDEDBINDEXNAME = "PSDEDBINDEXNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_REMOVEFLAG = "REMOVEFLAG";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERPARAMS = "USERPARAMS";
    private static final int INDEX_ALLOWREVERSE = 0;
    private static final int INDEX_CODENAME = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_INCFIELDS = 4;
    private static final int INDEX_INDEXFIELDS = 5;
    private static final int INDEX_INDEXTYPE = 6;
    private static final int INDEX_MEMO = 7;
    private static final int INDEX_PSDEDBINDEXID = 8;
    private static final int INDEX_PSDEDBINDEXNAME = 9;
    private static final int INDEX_PSDEID = 10;
    private static final int INDEX_PSDENAME = 11;
    private static final int INDEX_REMOVEFLAG = 12;
    private static final int INDEX_UPDATEDATE = 13;
    private static final int INDEX_UPDATEMAN = 14;
    private static final int INDEX_USERPARAMS = 15;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEDBIndexBase proxyPSDEDBIndexBase = null;
    private boolean allowreverseDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean incfieldsDirtyFlag = false;
    private boolean indexfieldsDirtyFlag = false;
    private boolean indextypeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdedbindexidDirtyFlag = false;
    private boolean psdedbindexnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean removeflagDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean userparamsDirtyFlag = false;
    @Column(name="allowreverse")
    private Integer allowreverse;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="incfields")
    private String incfields;
    @Column(name="indexfields")
    private String indexfields;
    @Column(name="indextype")
    private String indextype;
    @Column(name="memo")
    private String memo;
    @Column(name="psdedbindexid")
    private String psdedbindexid;
    @Column(name="psdedbindexname")
    private String psdedbindexname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="removeflag")
    private Integer removeflag;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="userparams")
    private String userparams;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;

    public void setAllowReverse(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAllowReverse(n);
            return;
        }
        this.allowreverse = n;
        this.allowreverseDirtyFlag = true;
    }

    public Integer getAllowReverse() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAllowReverse();
        }
        return this.allowreverse;
    }

    public boolean isAllowReverseDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAllowReverseDirty();
        }
        return this.allowreverseDirtyFlag;
    }

    public void resetAllowReverse() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAllowReverse();
            return;
        }
        this.allowreverseDirtyFlag = false;
        this.allowreverse = null;
    }

    public void setCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.codename = string;
        this.codenameDirtyFlag = true;
    }

    public String getCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeName();
        }
        return this.codename;
    }

    public boolean isCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeNameDirty();
        }
        return this.codenameDirtyFlag;
    }

    public void resetCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeName();
            return;
        }
        this.codenameDirtyFlag = false;
        this.codename = null;
    }

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

    public void setIncFields(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIncFields(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.incfields = string;
        this.incfieldsDirtyFlag = true;
    }

    public String getIncFields() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIncFields();
        }
        return this.incfields;
    }

    public boolean isIncFieldsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIncFieldsDirty();
        }
        return this.incfieldsDirtyFlag;
    }

    public void resetIncFields() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIncFields();
            return;
        }
        this.incfieldsDirtyFlag = false;
        this.incfields = null;
    }

    public void setIndexFields(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIndexFields(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.indexfields = string;
        this.indexfieldsDirtyFlag = true;
    }

    public String getIndexFields() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIndexFields();
        }
        return this.indexfields;
    }

    public boolean isIndexFieldsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIndexFieldsDirty();
        }
        return this.indexfieldsDirtyFlag;
    }

    public void resetIndexFields() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIndexFields();
            return;
        }
        this.indexfieldsDirtyFlag = false;
        this.indexfields = null;
    }

    public void setIndexType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIndexType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.indextype = string;
        this.indextypeDirtyFlag = true;
    }

    public String getIndexType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIndexType();
        }
        return this.indextype;
    }

    public boolean isIndexTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIndexTypeDirty();
        }
        return this.indextypeDirtyFlag;
    }

    public void resetIndexType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIndexType();
            return;
        }
        this.indextypeDirtyFlag = false;
        this.indextype = null;
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

    public void setPSDEDBIndexId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDBIndexId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedbindexid = string;
        this.psdedbindexidDirtyFlag = true;
    }

    public String getPSDEDBIndexId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDBIndexId();
        }
        return this.psdedbindexid;
    }

    public boolean isPSDEDBIndexIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDBIndexIdDirty();
        }
        return this.psdedbindexidDirtyFlag;
    }

    public void resetPSDEDBIndexId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDBIndexId();
            return;
        }
        this.psdedbindexidDirtyFlag = false;
        this.psdedbindexid = null;
    }

    public void setPSDEDBIndexName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDBIndexName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        if (string != null) {
            string = string.toUpperCase();
        }
        this.psdedbindexname = string;
        this.psdedbindexnameDirtyFlag = true;
    }

    public String getPSDEDBIndexName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDBIndexName();
        }
        return this.psdedbindexname;
    }

    public boolean isPSDEDBIndexNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDBIndexNameDirty();
        }
        return this.psdedbindexnameDirtyFlag;
    }

    public void resetPSDEDBIndexName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDBIndexName();
            return;
        }
        this.psdedbindexnameDirtyFlag = false;
        this.psdedbindexname = null;
    }

    public void setPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeid = string;
        this.psdeidDirtyFlag = true;
    }

    public String getPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEId();
        }
        return this.psdeid;
    }

    public boolean isPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEIdDirty();
        }
        return this.psdeidDirtyFlag;
    }

    public void resetPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEId();
            return;
        }
        this.psdeidDirtyFlag = false;
        this.psdeid = null;
    }

    public void setPSDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdename = string;
        this.psdenameDirtyFlag = true;
    }

    public String getPSDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEName();
        }
        return this.psdename;
    }

    public boolean isPSDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDENameDirty();
        }
        return this.psdenameDirtyFlag;
    }

    public void resetPSDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEName();
            return;
        }
        this.psdenameDirtyFlag = false;
        this.psdename = null;
    }

    public void setRemoveFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRemoveFlag(n);
            return;
        }
        this.removeflag = n;
        this.removeflagDirtyFlag = true;
    }

    public Integer getRemoveFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRemoveFlag();
        }
        return this.removeflag;
    }

    public boolean isRemoveFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRemoveFlagDirty();
        }
        return this.removeflagDirtyFlag;
    }

    public void resetRemoveFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRemoveFlag();
            return;
        }
        this.removeflagDirtyFlag = false;
        this.removeflag = null;
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

    public void setUserParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userparams = string;
        this.userparamsDirtyFlag = true;
    }

    public String getUserParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserParams();
        }
        return this.userparams;
    }

    public boolean isUserParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserParamsDirty();
        }
        return this.userparamsDirtyFlag;
    }

    public void resetUserParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserParams();
            return;
        }
        this.userparamsDirtyFlag = false;
        this.userparams = null;
    }

    protected void onReset() {
        PSDEDBIndexBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEDBIndexBase pSDEDBIndexBase) {
        pSDEDBIndexBase.resetAllowReverse();
        pSDEDBIndexBase.resetCodeName();
        pSDEDBIndexBase.resetCreateDate();
        pSDEDBIndexBase.resetCreateMan();
        pSDEDBIndexBase.resetIncFields();
        pSDEDBIndexBase.resetIndexFields();
        pSDEDBIndexBase.resetIndexType();
        pSDEDBIndexBase.resetMemo();
        pSDEDBIndexBase.resetPSDEDBIndexId();
        pSDEDBIndexBase.resetPSDEDBIndexName();
        pSDEDBIndexBase.resetPSDEId();
        pSDEDBIndexBase.resetPSDEName();
        pSDEDBIndexBase.resetRemoveFlag();
        pSDEDBIndexBase.resetUpdateDate();
        pSDEDBIndexBase.resetUpdateMan();
        pSDEDBIndexBase.resetUserParams();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAllowReverseDirty()) {
            hashMap.put(FIELD_ALLOWREVERSE, this.getAllowReverse());
        }
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isIncFieldsDirty()) {
            hashMap.put(FIELD_INCFIELDS, this.getIncFields());
        }
        if (!bl || this.isIndexFieldsDirty()) {
            hashMap.put(FIELD_INDEXFIELDS, this.getIndexFields());
        }
        if (!bl || this.isIndexTypeDirty()) {
            hashMap.put(FIELD_INDEXTYPE, this.getIndexType());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDEDBIndexIdDirty()) {
            hashMap.put(FIELD_PSDEDBINDEXID, this.getPSDEDBIndexId());
        }
        if (!bl || this.isPSDEDBIndexNameDirty()) {
            hashMap.put(FIELD_PSDEDBINDEXNAME, this.getPSDEDBIndexName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isRemoveFlagDirty()) {
            hashMap.put(FIELD_REMOVEFLAG, this.getRemoveFlag());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserParamsDirty()) {
            hashMap.put(FIELD_USERPARAMS, this.getUserParams());
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
        return PSDEDBIndexBase.get(this, n);
    }

    private static Object get(PSDEDBIndexBase pSDEDBIndexBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDBIndexBase.getAllowReverse();
            }
            case 1: {
                return pSDEDBIndexBase.getCodeName();
            }
            case 2: {
                return pSDEDBIndexBase.getCreateDate();
            }
            case 3: {
                return pSDEDBIndexBase.getCreateMan();
            }
            case 4: {
                return pSDEDBIndexBase.getIncFields();
            }
            case 5: {
                return pSDEDBIndexBase.getIndexFields();
            }
            case 6: {
                return pSDEDBIndexBase.getIndexType();
            }
            case 7: {
                return pSDEDBIndexBase.getMemo();
            }
            case 8: {
                return pSDEDBIndexBase.getPSDEDBIndexId();
            }
            case 9: {
                return pSDEDBIndexBase.getPSDEDBIndexName();
            }
            case 10: {
                return pSDEDBIndexBase.getPSDEId();
            }
            case 11: {
                return pSDEDBIndexBase.getPSDEName();
            }
            case 12: {
                return pSDEDBIndexBase.getRemoveFlag();
            }
            case 13: {
                return pSDEDBIndexBase.getUpdateDate();
            }
            case 14: {
                return pSDEDBIndexBase.getUpdateMan();
            }
            case 15: {
                return pSDEDBIndexBase.getUserParams();
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
        PSDEDBIndexBase.set(this, n, object);
    }

    private static void set(PSDEDBIndexBase pSDEDBIndexBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEDBIndexBase.setAllowReverse(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSDEDBIndexBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEDBIndexBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSDEDBIndexBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEDBIndexBase.setIncFields(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEDBIndexBase.setIndexFields(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEDBIndexBase.setIndexType(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEDBIndexBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEDBIndexBase.setPSDEDBIndexId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEDBIndexBase.setPSDEDBIndexName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEDBIndexBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEDBIndexBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEDBIndexBase.setRemoveFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSDEDBIndexBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 14: {
                pSDEDBIndexBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEDBIndexBase.setUserParams(DataObject.getStringValue((Object)object));
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
        return PSDEDBIndexBase.isNull(this, n);
    }

    private static boolean isNull(PSDEDBIndexBase pSDEDBIndexBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDBIndexBase.getAllowReverse() == null;
            }
            case 1: {
                return pSDEDBIndexBase.getCodeName() == null;
            }
            case 2: {
                return pSDEDBIndexBase.getCreateDate() == null;
            }
            case 3: {
                return pSDEDBIndexBase.getCreateMan() == null;
            }
            case 4: {
                return pSDEDBIndexBase.getIncFields() == null;
            }
            case 5: {
                return pSDEDBIndexBase.getIndexFields() == null;
            }
            case 6: {
                return pSDEDBIndexBase.getIndexType() == null;
            }
            case 7: {
                return pSDEDBIndexBase.getMemo() == null;
            }
            case 8: {
                return pSDEDBIndexBase.getPSDEDBIndexId() == null;
            }
            case 9: {
                return pSDEDBIndexBase.getPSDEDBIndexName() == null;
            }
            case 10: {
                return pSDEDBIndexBase.getPSDEId() == null;
            }
            case 11: {
                return pSDEDBIndexBase.getPSDEName() == null;
            }
            case 12: {
                return pSDEDBIndexBase.getRemoveFlag() == null;
            }
            case 13: {
                return pSDEDBIndexBase.getUpdateDate() == null;
            }
            case 14: {
                return pSDEDBIndexBase.getUpdateMan() == null;
            }
            case 15: {
                return pSDEDBIndexBase.getUserParams() == null;
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
        return PSDEDBIndexBase.contains(this, n);
    }

    private static boolean contains(PSDEDBIndexBase pSDEDBIndexBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDBIndexBase.isAllowReverseDirty();
            }
            case 1: {
                return pSDEDBIndexBase.isCodeNameDirty();
            }
            case 2: {
                return pSDEDBIndexBase.isCreateDateDirty();
            }
            case 3: {
                return pSDEDBIndexBase.isCreateManDirty();
            }
            case 4: {
                return pSDEDBIndexBase.isIncFieldsDirty();
            }
            case 5: {
                return pSDEDBIndexBase.isIndexFieldsDirty();
            }
            case 6: {
                return pSDEDBIndexBase.isIndexTypeDirty();
            }
            case 7: {
                return pSDEDBIndexBase.isMemoDirty();
            }
            case 8: {
                return pSDEDBIndexBase.isPSDEDBIndexIdDirty();
            }
            case 9: {
                return pSDEDBIndexBase.isPSDEDBIndexNameDirty();
            }
            case 10: {
                return pSDEDBIndexBase.isPSDEIdDirty();
            }
            case 11: {
                return pSDEDBIndexBase.isPSDENameDirty();
            }
            case 12: {
                return pSDEDBIndexBase.isRemoveFlagDirty();
            }
            case 13: {
                return pSDEDBIndexBase.isUpdateDateDirty();
            }
            case 14: {
                return pSDEDBIndexBase.isUpdateManDirty();
            }
            case 15: {
                return pSDEDBIndexBase.isUserParamsDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEDBIndexBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEDBIndexBase pSDEDBIndexBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEDBIndexBase.getAllowReverse() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"allowreverse", (Object)PSDEDBIndexBase.getJSONValue((Object)pSDEDBIndexBase.getAllowReverse()), (boolean)false);
        }
        if (bl || pSDEDBIndexBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDEDBIndexBase.getJSONValue((Object)pSDEDBIndexBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDEDBIndexBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEDBIndexBase.getJSONValue((Object)pSDEDBIndexBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEDBIndexBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEDBIndexBase.getJSONValue((Object)pSDEDBIndexBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEDBIndexBase.getIncFields() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"incfields", (Object)PSDEDBIndexBase.getJSONValue((Object)pSDEDBIndexBase.getIncFields()), (boolean)false);
        }
        if (bl || pSDEDBIndexBase.getIndexFields() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"indexfields", (Object)PSDEDBIndexBase.getJSONValue((Object)pSDEDBIndexBase.getIndexFields()), (boolean)false);
        }
        if (bl || pSDEDBIndexBase.getIndexType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"indextype", (Object)PSDEDBIndexBase.getJSONValue((Object)pSDEDBIndexBase.getIndexType()), (boolean)false);
        }
        if (bl || pSDEDBIndexBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEDBIndexBase.getJSONValue((Object)pSDEDBIndexBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEDBIndexBase.getPSDEDBIndexId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedbindexid", (Object)PSDEDBIndexBase.getJSONValue((Object)pSDEDBIndexBase.getPSDEDBIndexId()), (boolean)false);
        }
        if (bl || pSDEDBIndexBase.getPSDEDBIndexName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedbindexname", (Object)PSDEDBIndexBase.getJSONValue((Object)pSDEDBIndexBase.getPSDEDBIndexName()), (boolean)false);
        }
        if (bl || pSDEDBIndexBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEDBIndexBase.getJSONValue((Object)pSDEDBIndexBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEDBIndexBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDEDBIndexBase.getJSONValue((Object)pSDEDBIndexBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDEDBIndexBase.getRemoveFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"removeflag", (Object)PSDEDBIndexBase.getJSONValue((Object)pSDEDBIndexBase.getRemoveFlag()), (boolean)false);
        }
        if (bl || pSDEDBIndexBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEDBIndexBase.getJSONValue((Object)pSDEDBIndexBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEDBIndexBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEDBIndexBase.getJSONValue((Object)pSDEDBIndexBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEDBIndexBase.getUserParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userparams", (Object)PSDEDBIndexBase.getJSONValue((Object)pSDEDBIndexBase.getUserParams()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEDBIndexBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEDBIndexBase pSDEDBIndexBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEDBIndexBase.getAllowReverse() != null) {
            object = pSDEDBIndexBase.getAllowReverse();
            xmlNode.setAttribute(FIELD_ALLOWREVERSE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDBIndexBase.getCodeName() != null) {
            object = pSDEDBIndexBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDBIndexBase.getCreateDate() != null) {
            object = pSDEDBIndexBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEDBIndexBase.getCreateMan() != null) {
            object = pSDEDBIndexBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEDBIndexBase.getIncFields() != null) {
            object = pSDEDBIndexBase.getIncFields();
            xmlNode.setAttribute(FIELD_INCFIELDS, object == null ? "" : (String)object);
        }
        if (bl || pSDEDBIndexBase.getIndexFields() != null) {
            object = pSDEDBIndexBase.getIndexFields();
            xmlNode.setAttribute(FIELD_INDEXFIELDS, object == null ? "" : (String)object);
        }
        if (bl || pSDEDBIndexBase.getIndexType() != null) {
            object = pSDEDBIndexBase.getIndexType();
            xmlNode.setAttribute(FIELD_INDEXTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEDBIndexBase.getMemo() != null) {
            object = pSDEDBIndexBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEDBIndexBase.getPSDEDBIndexId() != null) {
            object = pSDEDBIndexBase.getPSDEDBIndexId();
            xmlNode.setAttribute(FIELD_PSDEDBINDEXID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDBIndexBase.getPSDEDBIndexName() != null) {
            object = pSDEDBIndexBase.getPSDEDBIndexName();
            xmlNode.setAttribute(FIELD_PSDEDBINDEXNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDBIndexBase.getPSDEId() != null) {
            object = pSDEDBIndexBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDBIndexBase.getPSDEName() != null) {
            object = pSDEDBIndexBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDBIndexBase.getRemoveFlag() != null) {
            object = pSDEDBIndexBase.getRemoveFlag();
            xmlNode.setAttribute(FIELD_REMOVEFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDBIndexBase.getUpdateDate() != null) {
            object = pSDEDBIndexBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEDBIndexBase.getUpdateMan() != null) {
            object = pSDEDBIndexBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEDBIndexBase.getUserParams() != null) {
            object = pSDEDBIndexBase.getUserParams();
            xmlNode.setAttribute(FIELD_USERPARAMS, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEDBIndexBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEDBIndexBase pSDEDBIndexBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEDBIndexBase.isAllowReverseDirty() && (bl || pSDEDBIndexBase.getAllowReverse() != null)) {
            iDataObject.set(FIELD_ALLOWREVERSE, (Object)pSDEDBIndexBase.getAllowReverse());
        }
        if (pSDEDBIndexBase.isCodeNameDirty() && (bl || pSDEDBIndexBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDEDBIndexBase.getCodeName());
        }
        if (pSDEDBIndexBase.isCreateDateDirty() && (bl || pSDEDBIndexBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEDBIndexBase.getCreateDate());
        }
        if (pSDEDBIndexBase.isCreateManDirty() && (bl || pSDEDBIndexBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEDBIndexBase.getCreateMan());
        }
        if (pSDEDBIndexBase.isIncFieldsDirty() && (bl || pSDEDBIndexBase.getIncFields() != null)) {
            iDataObject.set(FIELD_INCFIELDS, (Object)pSDEDBIndexBase.getIncFields());
        }
        if (pSDEDBIndexBase.isIndexFieldsDirty() && (bl || pSDEDBIndexBase.getIndexFields() != null)) {
            iDataObject.set(FIELD_INDEXFIELDS, (Object)pSDEDBIndexBase.getIndexFields());
        }
        if (pSDEDBIndexBase.isIndexTypeDirty() && (bl || pSDEDBIndexBase.getIndexType() != null)) {
            iDataObject.set(FIELD_INDEXTYPE, (Object)pSDEDBIndexBase.getIndexType());
        }
        if (pSDEDBIndexBase.isMemoDirty() && (bl || pSDEDBIndexBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEDBIndexBase.getMemo());
        }
        if (pSDEDBIndexBase.isPSDEDBIndexIdDirty() && (bl || pSDEDBIndexBase.getPSDEDBIndexId() != null)) {
            iDataObject.set(FIELD_PSDEDBINDEXID, (Object)pSDEDBIndexBase.getPSDEDBIndexId());
        }
        if (pSDEDBIndexBase.isPSDEDBIndexNameDirty() && (bl || pSDEDBIndexBase.getPSDEDBIndexName() != null)) {
            iDataObject.set(FIELD_PSDEDBINDEXNAME, (Object)pSDEDBIndexBase.getPSDEDBIndexName());
        }
        if (pSDEDBIndexBase.isPSDEIdDirty() && (bl || pSDEDBIndexBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEDBIndexBase.getPSDEId());
        }
        if (pSDEDBIndexBase.isPSDENameDirty() && (bl || pSDEDBIndexBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDEDBIndexBase.getPSDEName());
        }
        if (pSDEDBIndexBase.isRemoveFlagDirty() && (bl || pSDEDBIndexBase.getRemoveFlag() != null)) {
            iDataObject.set(FIELD_REMOVEFLAG, (Object)pSDEDBIndexBase.getRemoveFlag());
        }
        if (pSDEDBIndexBase.isUpdateDateDirty() && (bl || pSDEDBIndexBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEDBIndexBase.getUpdateDate());
        }
        if (pSDEDBIndexBase.isUpdateManDirty() && (bl || pSDEDBIndexBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEDBIndexBase.getUpdateMan());
        }
        if (pSDEDBIndexBase.isUserParamsDirty() && (bl || pSDEDBIndexBase.getUserParams() != null)) {
            iDataObject.set(FIELD_USERPARAMS, (Object)pSDEDBIndexBase.getUserParams());
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
        return PSDEDBIndexBase.remove(this, n);
    }

    private static boolean remove(PSDEDBIndexBase pSDEDBIndexBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEDBIndexBase.resetAllowReverse();
                return true;
            }
            case 1: {
                pSDEDBIndexBase.resetCodeName();
                return true;
            }
            case 2: {
                pSDEDBIndexBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSDEDBIndexBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSDEDBIndexBase.resetIncFields();
                return true;
            }
            case 5: {
                pSDEDBIndexBase.resetIndexFields();
                return true;
            }
            case 6: {
                pSDEDBIndexBase.resetIndexType();
                return true;
            }
            case 7: {
                pSDEDBIndexBase.resetMemo();
                return true;
            }
            case 8: {
                pSDEDBIndexBase.resetPSDEDBIndexId();
                return true;
            }
            case 9: {
                pSDEDBIndexBase.resetPSDEDBIndexName();
                return true;
            }
            case 10: {
                pSDEDBIndexBase.resetPSDEId();
                return true;
            }
            case 11: {
                pSDEDBIndexBase.resetPSDEName();
                return true;
            }
            case 12: {
                pSDEDBIndexBase.resetRemoveFlag();
                return true;
            }
            case 13: {
                pSDEDBIndexBase.resetUpdateDate();
                return true;
            }
            case 14: {
                pSDEDBIndexBase.resetUpdateMan();
                return true;
            }
            case 15: {
                pSDEDBIndexBase.resetUserParams();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getPSDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDE();
        }
        if (this.getPSDEId() == null) {
            return null;
        }
        Integer n = this.objPSDELock;
        synchronized (n) {
            if (this.psde != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEId(), (Object)this.psde.getPSDataEntityId()) != 0L) {
                this.psde = null;
            }
            if (this.psde == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getPSDEId());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet((IEntity)pSDataEntity);
                this.psde = pSDataEntity;
            }
            return this.psde;
        }
    }

    private PSDEDBIndexBase getProxyEntity() {
        return this.proxyPSDEDBIndexBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEDBIndexBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEDBIndexBase) {
            this.proxyPSDEDBIndexBase = (PSDEDBIndexBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDBIndexService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ALLOWREVERSE, 0);
        fieldIndexMap.put(FIELD_CODENAME, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_INCFIELDS, 4);
        fieldIndexMap.put(FIELD_INDEXFIELDS, 5);
        fieldIndexMap.put(FIELD_INDEXTYPE, 6);
        fieldIndexMap.put(FIELD_MEMO, 7);
        fieldIndexMap.put(FIELD_PSDEDBINDEXID, 8);
        fieldIndexMap.put(FIELD_PSDEDBINDEXNAME, 9);
        fieldIndexMap.put(FIELD_PSDEID, 10);
        fieldIndexMap.put(FIELD_PSDENAME, 11);
        fieldIndexMap.put(FIELD_REMOVEFLAG, 12);
        fieldIndexMap.put(FIELD_UPDATEDATE, 13);
        fieldIndexMap.put(FIELD_UPDATEMAN, 14);
        fieldIndexMap.put(FIELD_USERPARAMS, 15);
    }
}

