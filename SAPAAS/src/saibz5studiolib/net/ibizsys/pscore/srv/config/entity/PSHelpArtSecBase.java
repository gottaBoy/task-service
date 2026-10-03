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
import net.ibizsys.pscore.srv.config.entity.PSHelpArticleType;
import net.ibizsys.pscore.srv.config.entity.PSHelpSectionType;
import net.ibizsys.pscore.srv.config.service.PSHelpArticleTypeService;
import net.ibizsys.pscore.srv.config.service.PSHelpSectionTypeService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSHelpArtSecBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSHelpArtSecBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSHELPARTICLETYPEID = "PSHELPARTICLETYPEID";
    public static final String FIELD_PSHELPARTICLETYPENAME = "PSHELPARTICLETYPENAME";
    public static final String FIELD_PSHELPARTSECID = "PSHELPARTSECID";
    public static final String FIELD_PSHELPARTSECNAME = "PSHELPARTSECNAME";
    public static final String FIELD_PSHELPSECTIONTYPEID = "PSHELPSECTIONTYPEID";
    public static final String FIELD_PSHELPSECTIONTYPENAME = "PSHELPSECTIONTYPENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_ORDERVALUE = 3;
    private static final int INDEX_PSHELPARTICLETYPEID = 4;
    private static final int INDEX_PSHELPARTICLETYPENAME = 5;
    private static final int INDEX_PSHELPARTSECID = 6;
    private static final int INDEX_PSHELPARTSECNAME = 7;
    private static final int INDEX_PSHELPSECTIONTYPEID = 8;
    private static final int INDEX_PSHELPSECTIONTYPENAME = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final int INDEX_VALIDFLAG = 12;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSHelpArtSecBase proxyPSHelpArtSecBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean pshelparticletypeidDirtyFlag = false;
    private boolean pshelparticletypenameDirtyFlag = false;
    private boolean pshelpartsecidDirtyFlag = false;
    private boolean pshelpartsecnameDirtyFlag = false;
    private boolean pshelpsectiontypeidDirtyFlag = false;
    private boolean pshelpsectiontypenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="pshelparticletypeid")
    private String pshelparticletypeid;
    @Column(name="pshelparticletypename")
    private String pshelparticletypename;
    @Column(name="pshelpartsecid")
    private String pshelpartsecid;
    @Column(name="pshelpartsecname")
    private String pshelpartsecname;
    @Column(name="pshelpsectiontypeid")
    private String pshelpsectiontypeid;
    @Column(name="pshelpsectiontypename")
    private String pshelpsectiontypename;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSHelpArticleTypeLock = new Integer(1);
    private PSHelpArticleType pshelparticletype = null;
    private Integer objPSHelpSectionTypeLock = new Integer(1);
    private PSHelpSectionType pshelpsectiontype = null;

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

    public void setOrderValue(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOrderValue(n);
            return;
        }
        this.ordervalue = n;
        this.ordervalueDirtyFlag = true;
    }

    public Integer getOrderValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOrderValue();
        }
        return this.ordervalue;
    }

    public boolean isOrderValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOrderValueDirty();
        }
        return this.ordervalueDirtyFlag;
    }

    public void resetOrderValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOrderValue();
            return;
        }
        this.ordervalueDirtyFlag = false;
        this.ordervalue = null;
    }

    public void setPSHelpArticleTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSHelpArticleTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pshelparticletypeid = string;
        this.pshelparticletypeidDirtyFlag = true;
    }

    public String getPSHelpArticleTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSHelpArticleTypeId();
        }
        return this.pshelparticletypeid;
    }

    public boolean isPSHelpArticleTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSHelpArticleTypeIdDirty();
        }
        return this.pshelparticletypeidDirtyFlag;
    }

    public void resetPSHelpArticleTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSHelpArticleTypeId();
            return;
        }
        this.pshelparticletypeidDirtyFlag = false;
        this.pshelparticletypeid = null;
    }

    public void setPSHelpArticleTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSHelpArticleTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pshelparticletypename = string;
        this.pshelparticletypenameDirtyFlag = true;
    }

    public String getPSHelpArticleTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSHelpArticleTypeName();
        }
        return this.pshelparticletypename;
    }

    public boolean isPSHelpArticleTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSHelpArticleTypeNameDirty();
        }
        return this.pshelparticletypenameDirtyFlag;
    }

    public void resetPSHelpArticleTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSHelpArticleTypeName();
            return;
        }
        this.pshelparticletypenameDirtyFlag = false;
        this.pshelparticletypename = null;
    }

    public void setPSHelpArtSecId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSHelpArtSecId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pshelpartsecid = string;
        this.pshelpartsecidDirtyFlag = true;
    }

    public String getPSHelpArtSecId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSHelpArtSecId();
        }
        return this.pshelpartsecid;
    }

    public boolean isPSHelpArtSecIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSHelpArtSecIdDirty();
        }
        return this.pshelpartsecidDirtyFlag;
    }

    public void resetPSHelpArtSecId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSHelpArtSecId();
            return;
        }
        this.pshelpartsecidDirtyFlag = false;
        this.pshelpartsecid = null;
    }

    public void setPSHelpArtSecName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSHelpArtSecName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pshelpartsecname = string;
        this.pshelpartsecnameDirtyFlag = true;
    }

    public String getPSHelpArtSecName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSHelpArtSecName();
        }
        return this.pshelpartsecname;
    }

    public boolean isPSHelpArtSecNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSHelpArtSecNameDirty();
        }
        return this.pshelpartsecnameDirtyFlag;
    }

    public void resetPSHelpArtSecName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSHelpArtSecName();
            return;
        }
        this.pshelpartsecnameDirtyFlag = false;
        this.pshelpartsecname = null;
    }

    public void setPSHelpSectionTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSHelpSectionTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pshelpsectiontypeid = string;
        this.pshelpsectiontypeidDirtyFlag = true;
    }

    public String getPSHelpSectionTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSHelpSectionTypeId();
        }
        return this.pshelpsectiontypeid;
    }

    public boolean isPSHelpSectionTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSHelpSectionTypeIdDirty();
        }
        return this.pshelpsectiontypeidDirtyFlag;
    }

    public void resetPSHelpSectionTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSHelpSectionTypeId();
            return;
        }
        this.pshelpsectiontypeidDirtyFlag = false;
        this.pshelpsectiontypeid = null;
    }

    public void setPSHelpSectionTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSHelpSectionTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pshelpsectiontypename = string;
        this.pshelpsectiontypenameDirtyFlag = true;
    }

    public String getPSHelpSectionTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSHelpSectionTypeName();
        }
        return this.pshelpsectiontypename;
    }

    public boolean isPSHelpSectionTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSHelpSectionTypeNameDirty();
        }
        return this.pshelpsectiontypenameDirtyFlag;
    }

    public void resetPSHelpSectionTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSHelpSectionTypeName();
            return;
        }
        this.pshelpsectiontypenameDirtyFlag = false;
        this.pshelpsectiontypename = null;
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

    public void setValidFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValidFlag(n);
            return;
        }
        this.validflag = n;
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

    protected void onReset() {
        PSHelpArtSecBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSHelpArtSecBase pSHelpArtSecBase) {
        pSHelpArtSecBase.resetCreateDate();
        pSHelpArtSecBase.resetCreateMan();
        pSHelpArtSecBase.resetMemo();
        pSHelpArtSecBase.resetOrderValue();
        pSHelpArtSecBase.resetPSHelpArticleTypeId();
        pSHelpArtSecBase.resetPSHelpArticleTypeName();
        pSHelpArtSecBase.resetPSHelpArtSecId();
        pSHelpArtSecBase.resetPSHelpArtSecName();
        pSHelpArtSecBase.resetPSHelpSectionTypeId();
        pSHelpArtSecBase.resetPSHelpSectionTypeName();
        pSHelpArtSecBase.resetUpdateDate();
        pSHelpArtSecBase.resetUpdateMan();
        pSHelpArtSecBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSHelpArticleTypeIdDirty()) {
            hashMap.put(FIELD_PSHELPARTICLETYPEID, this.getPSHelpArticleTypeId());
        }
        if (!bl || this.isPSHelpArticleTypeNameDirty()) {
            hashMap.put(FIELD_PSHELPARTICLETYPENAME, this.getPSHelpArticleTypeName());
        }
        if (!bl || this.isPSHelpArtSecIdDirty()) {
            hashMap.put(FIELD_PSHELPARTSECID, this.getPSHelpArtSecId());
        }
        if (!bl || this.isPSHelpArtSecNameDirty()) {
            hashMap.put(FIELD_PSHELPARTSECNAME, this.getPSHelpArtSecName());
        }
        if (!bl || this.isPSHelpSectionTypeIdDirty()) {
            hashMap.put(FIELD_PSHELPSECTIONTYPEID, this.getPSHelpSectionTypeId());
        }
        if (!bl || this.isPSHelpSectionTypeNameDirty()) {
            hashMap.put(FIELD_PSHELPSECTIONTYPENAME, this.getPSHelpSectionTypeName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isValidFlagDirty()) {
            hashMap.put(FIELD_VALIDFLAG, this.getValidFlag());
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
        return PSHelpArtSecBase.get(this, n);
    }

    private static Object get(PSHelpArtSecBase pSHelpArtSecBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSHelpArtSecBase.getCreateDate();
            }
            case 1: {
                return pSHelpArtSecBase.getCreateMan();
            }
            case 2: {
                return pSHelpArtSecBase.getMemo();
            }
            case 3: {
                return pSHelpArtSecBase.getOrderValue();
            }
            case 4: {
                return pSHelpArtSecBase.getPSHelpArticleTypeId();
            }
            case 5: {
                return pSHelpArtSecBase.getPSHelpArticleTypeName();
            }
            case 6: {
                return pSHelpArtSecBase.getPSHelpArtSecId();
            }
            case 7: {
                return pSHelpArtSecBase.getPSHelpArtSecName();
            }
            case 8: {
                return pSHelpArtSecBase.getPSHelpSectionTypeId();
            }
            case 9: {
                return pSHelpArtSecBase.getPSHelpSectionTypeName();
            }
            case 10: {
                return pSHelpArtSecBase.getUpdateDate();
            }
            case 11: {
                return pSHelpArtSecBase.getUpdateMan();
            }
            case 12: {
                return pSHelpArtSecBase.getValidFlag();
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
        PSHelpArtSecBase.set(this, n, object);
    }

    private static void set(PSHelpArtSecBase pSHelpArtSecBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSHelpArtSecBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSHelpArtSecBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSHelpArtSecBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSHelpArtSecBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSHelpArtSecBase.setPSHelpArticleTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSHelpArtSecBase.setPSHelpArticleTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSHelpArtSecBase.setPSHelpArtSecId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSHelpArtSecBase.setPSHelpArtSecName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSHelpArtSecBase.setPSHelpSectionTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSHelpArtSecBase.setPSHelpSectionTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSHelpArtSecBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSHelpArtSecBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSHelpArtSecBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSHelpArtSecBase.isNull(this, n);
    }

    private static boolean isNull(PSHelpArtSecBase pSHelpArtSecBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSHelpArtSecBase.getCreateDate() == null;
            }
            case 1: {
                return pSHelpArtSecBase.getCreateMan() == null;
            }
            case 2: {
                return pSHelpArtSecBase.getMemo() == null;
            }
            case 3: {
                return pSHelpArtSecBase.getOrderValue() == null;
            }
            case 4: {
                return pSHelpArtSecBase.getPSHelpArticleTypeId() == null;
            }
            case 5: {
                return pSHelpArtSecBase.getPSHelpArticleTypeName() == null;
            }
            case 6: {
                return pSHelpArtSecBase.getPSHelpArtSecId() == null;
            }
            case 7: {
                return pSHelpArtSecBase.getPSHelpArtSecName() == null;
            }
            case 8: {
                return pSHelpArtSecBase.getPSHelpSectionTypeId() == null;
            }
            case 9: {
                return pSHelpArtSecBase.getPSHelpSectionTypeName() == null;
            }
            case 10: {
                return pSHelpArtSecBase.getUpdateDate() == null;
            }
            case 11: {
                return pSHelpArtSecBase.getUpdateMan() == null;
            }
            case 12: {
                return pSHelpArtSecBase.getValidFlag() == null;
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
        return PSHelpArtSecBase.contains(this, n);
    }

    private static boolean contains(PSHelpArtSecBase pSHelpArtSecBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSHelpArtSecBase.isCreateDateDirty();
            }
            case 1: {
                return pSHelpArtSecBase.isCreateManDirty();
            }
            case 2: {
                return pSHelpArtSecBase.isMemoDirty();
            }
            case 3: {
                return pSHelpArtSecBase.isOrderValueDirty();
            }
            case 4: {
                return pSHelpArtSecBase.isPSHelpArticleTypeIdDirty();
            }
            case 5: {
                return pSHelpArtSecBase.isPSHelpArticleTypeNameDirty();
            }
            case 6: {
                return pSHelpArtSecBase.isPSHelpArtSecIdDirty();
            }
            case 7: {
                return pSHelpArtSecBase.isPSHelpArtSecNameDirty();
            }
            case 8: {
                return pSHelpArtSecBase.isPSHelpSectionTypeIdDirty();
            }
            case 9: {
                return pSHelpArtSecBase.isPSHelpSectionTypeNameDirty();
            }
            case 10: {
                return pSHelpArtSecBase.isUpdateDateDirty();
            }
            case 11: {
                return pSHelpArtSecBase.isUpdateManDirty();
            }
            case 12: {
                return pSHelpArtSecBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSHelpArtSecBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSHelpArtSecBase pSHelpArtSecBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSHelpArtSecBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSHelpArtSecBase.getJSONValue((Object)pSHelpArtSecBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSHelpArtSecBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSHelpArtSecBase.getJSONValue((Object)pSHelpArtSecBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSHelpArtSecBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSHelpArtSecBase.getJSONValue((Object)pSHelpArtSecBase.getMemo()), (boolean)false);
        }
        if (bl || pSHelpArtSecBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSHelpArtSecBase.getJSONValue((Object)pSHelpArtSecBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSHelpArtSecBase.getPSHelpArticleTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pshelparticletypeid", (Object)PSHelpArtSecBase.getJSONValue((Object)pSHelpArtSecBase.getPSHelpArticleTypeId()), (boolean)false);
        }
        if (bl || pSHelpArtSecBase.getPSHelpArticleTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pshelparticletypename", (Object)PSHelpArtSecBase.getJSONValue((Object)pSHelpArtSecBase.getPSHelpArticleTypeName()), (boolean)false);
        }
        if (bl || pSHelpArtSecBase.getPSHelpArtSecId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pshelpartsecid", (Object)PSHelpArtSecBase.getJSONValue((Object)pSHelpArtSecBase.getPSHelpArtSecId()), (boolean)false);
        }
        if (bl || pSHelpArtSecBase.getPSHelpArtSecName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pshelpartsecname", (Object)PSHelpArtSecBase.getJSONValue((Object)pSHelpArtSecBase.getPSHelpArtSecName()), (boolean)false);
        }
        if (bl || pSHelpArtSecBase.getPSHelpSectionTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pshelpsectiontypeid", (Object)PSHelpArtSecBase.getJSONValue((Object)pSHelpArtSecBase.getPSHelpSectionTypeId()), (boolean)false);
        }
        if (bl || pSHelpArtSecBase.getPSHelpSectionTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pshelpsectiontypename", (Object)PSHelpArtSecBase.getJSONValue((Object)pSHelpArtSecBase.getPSHelpSectionTypeName()), (boolean)false);
        }
        if (bl || pSHelpArtSecBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSHelpArtSecBase.getJSONValue((Object)pSHelpArtSecBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSHelpArtSecBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSHelpArtSecBase.getJSONValue((Object)pSHelpArtSecBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSHelpArtSecBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSHelpArtSecBase.getJSONValue((Object)pSHelpArtSecBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSHelpArtSecBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSHelpArtSecBase pSHelpArtSecBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSHelpArtSecBase.getCreateDate() != null) {
            object = pSHelpArtSecBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSHelpArtSecBase.getCreateMan() != null) {
            object = pSHelpArtSecBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArtSecBase.getMemo() != null) {
            object = pSHelpArtSecBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArtSecBase.getOrderValue() != null) {
            object = pSHelpArtSecBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSHelpArtSecBase.getPSHelpArticleTypeId() != null) {
            object = pSHelpArtSecBase.getPSHelpArticleTypeId();
            xmlNode.setAttribute(FIELD_PSHELPARTICLETYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArtSecBase.getPSHelpArticleTypeName() != null) {
            object = pSHelpArtSecBase.getPSHelpArticleTypeName();
            xmlNode.setAttribute(FIELD_PSHELPARTICLETYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArtSecBase.getPSHelpArtSecId() != null) {
            object = pSHelpArtSecBase.getPSHelpArtSecId();
            xmlNode.setAttribute(FIELD_PSHELPARTSECID, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArtSecBase.getPSHelpArtSecName() != null) {
            object = pSHelpArtSecBase.getPSHelpArtSecName();
            xmlNode.setAttribute(FIELD_PSHELPARTSECNAME, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArtSecBase.getPSHelpSectionTypeId() != null) {
            object = pSHelpArtSecBase.getPSHelpSectionTypeId();
            xmlNode.setAttribute(FIELD_PSHELPSECTIONTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArtSecBase.getPSHelpSectionTypeName() != null) {
            object = pSHelpArtSecBase.getPSHelpSectionTypeName();
            xmlNode.setAttribute(FIELD_PSHELPSECTIONTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArtSecBase.getUpdateDate() != null) {
            object = pSHelpArtSecBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSHelpArtSecBase.getUpdateMan() != null) {
            object = pSHelpArtSecBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArtSecBase.getValidFlag() != null) {
            object = pSHelpArtSecBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSHelpArtSecBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSHelpArtSecBase pSHelpArtSecBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSHelpArtSecBase.isCreateDateDirty() && (bl || pSHelpArtSecBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSHelpArtSecBase.getCreateDate());
        }
        if (pSHelpArtSecBase.isCreateManDirty() && (bl || pSHelpArtSecBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSHelpArtSecBase.getCreateMan());
        }
        if (pSHelpArtSecBase.isMemoDirty() && (bl || pSHelpArtSecBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSHelpArtSecBase.getMemo());
        }
        if (pSHelpArtSecBase.isOrderValueDirty() && (bl || pSHelpArtSecBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSHelpArtSecBase.getOrderValue());
        }
        if (pSHelpArtSecBase.isPSHelpArticleTypeIdDirty() && (bl || pSHelpArtSecBase.getPSHelpArticleTypeId() != null)) {
            iDataObject.set(FIELD_PSHELPARTICLETYPEID, (Object)pSHelpArtSecBase.getPSHelpArticleTypeId());
        }
        if (pSHelpArtSecBase.isPSHelpArticleTypeNameDirty() && (bl || pSHelpArtSecBase.getPSHelpArticleTypeName() != null)) {
            iDataObject.set(FIELD_PSHELPARTICLETYPENAME, (Object)pSHelpArtSecBase.getPSHelpArticleTypeName());
        }
        if (pSHelpArtSecBase.isPSHelpArtSecIdDirty() && (bl || pSHelpArtSecBase.getPSHelpArtSecId() != null)) {
            iDataObject.set(FIELD_PSHELPARTSECID, (Object)pSHelpArtSecBase.getPSHelpArtSecId());
        }
        if (pSHelpArtSecBase.isPSHelpArtSecNameDirty() && (bl || pSHelpArtSecBase.getPSHelpArtSecName() != null)) {
            iDataObject.set(FIELD_PSHELPARTSECNAME, (Object)pSHelpArtSecBase.getPSHelpArtSecName());
        }
        if (pSHelpArtSecBase.isPSHelpSectionTypeIdDirty() && (bl || pSHelpArtSecBase.getPSHelpSectionTypeId() != null)) {
            iDataObject.set(FIELD_PSHELPSECTIONTYPEID, (Object)pSHelpArtSecBase.getPSHelpSectionTypeId());
        }
        if (pSHelpArtSecBase.isPSHelpSectionTypeNameDirty() && (bl || pSHelpArtSecBase.getPSHelpSectionTypeName() != null)) {
            iDataObject.set(FIELD_PSHELPSECTIONTYPENAME, (Object)pSHelpArtSecBase.getPSHelpSectionTypeName());
        }
        if (pSHelpArtSecBase.isUpdateDateDirty() && (bl || pSHelpArtSecBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSHelpArtSecBase.getUpdateDate());
        }
        if (pSHelpArtSecBase.isUpdateManDirty() && (bl || pSHelpArtSecBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSHelpArtSecBase.getUpdateMan());
        }
        if (pSHelpArtSecBase.isValidFlagDirty() && (bl || pSHelpArtSecBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSHelpArtSecBase.getValidFlag());
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
        return PSHelpArtSecBase.remove(this, n);
    }

    private static boolean remove(PSHelpArtSecBase pSHelpArtSecBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSHelpArtSecBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSHelpArtSecBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSHelpArtSecBase.resetMemo();
                return true;
            }
            case 3: {
                pSHelpArtSecBase.resetOrderValue();
                return true;
            }
            case 4: {
                pSHelpArtSecBase.resetPSHelpArticleTypeId();
                return true;
            }
            case 5: {
                pSHelpArtSecBase.resetPSHelpArticleTypeName();
                return true;
            }
            case 6: {
                pSHelpArtSecBase.resetPSHelpArtSecId();
                return true;
            }
            case 7: {
                pSHelpArtSecBase.resetPSHelpArtSecName();
                return true;
            }
            case 8: {
                pSHelpArtSecBase.resetPSHelpSectionTypeId();
                return true;
            }
            case 9: {
                pSHelpArtSecBase.resetPSHelpSectionTypeName();
                return true;
            }
            case 10: {
                pSHelpArtSecBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSHelpArtSecBase.resetUpdateMan();
                return true;
            }
            case 12: {
                pSHelpArtSecBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSHelpArticleType getPSHelpArticleType() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSHelpArticleType();
        }
        if (this.getPSHelpArticleTypeId() == null) {
            return null;
        }
        Integer n = this.objPSHelpArticleTypeLock;
        synchronized (n) {
            if (this.pshelparticletype != null && DataTypeHelper.compare((int)25, (Object)this.getPSHelpArticleTypeId(), (Object)this.pshelparticletype.getPSHelpArticleTypeId()) != 0L) {
                this.pshelparticletype = null;
            }
            if (this.pshelparticletype == null) {
                PSHelpArticleType pSHelpArticleType = new PSHelpArticleType();
                pSHelpArticleType.setPSHelpArticleTypeId(this.getPSHelpArticleTypeId());
                PSHelpArticleTypeService pSHelpArticleTypeService = (PSHelpArticleTypeService)ServiceGlobal.getService(PSHelpArticleTypeService.class, (SessionFactory)this.getSessionFactory());
                pSHelpArticleTypeService.autoGet(pSHelpArticleType);
                this.pshelparticletype = pSHelpArticleType;
            }
            return this.pshelparticletype;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSHelpSectionType getPSHelpSectionType() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSHelpSectionType();
        }
        if (this.getPSHelpSectionTypeId() == null) {
            return null;
        }
        Integer n = this.objPSHelpSectionTypeLock;
        synchronized (n) {
            if (this.pshelpsectiontype != null && DataTypeHelper.compare((int)25, (Object)this.getPSHelpSectionTypeId(), (Object)this.pshelpsectiontype.getPSHelpSectionTypeId()) != 0L) {
                this.pshelpsectiontype = null;
            }
            if (this.pshelpsectiontype == null) {
                PSHelpSectionType pSHelpSectionType = new PSHelpSectionType();
                pSHelpSectionType.setPSHelpSectionTypeId(this.getPSHelpSectionTypeId());
                PSHelpSectionTypeService pSHelpSectionTypeService = (PSHelpSectionTypeService)ServiceGlobal.getService(PSHelpSectionTypeService.class, (SessionFactory)this.getSessionFactory());
                pSHelpSectionTypeService.autoGet(pSHelpSectionType);
                this.pshelpsectiontype = pSHelpSectionType;
            }
            return this.pshelpsectiontype;
        }
    }

    private PSHelpArtSecBase getProxyEntity() {
        return this.proxyPSHelpArtSecBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSHelpArtSecBase = null;
        if (iDataObject != null && iDataObject instanceof PSHelpArtSecBase) {
            this.proxyPSHelpArtSecBase = (PSHelpArtSecBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSHelpArtSecService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_ORDERVALUE, 3);
        fieldIndexMap.put(FIELD_PSHELPARTICLETYPEID, 4);
        fieldIndexMap.put(FIELD_PSHELPARTICLETYPENAME, 5);
        fieldIndexMap.put(FIELD_PSHELPARTSECID, 6);
        fieldIndexMap.put(FIELD_PSHELPARTSECNAME, 7);
        fieldIndexMap.put(FIELD_PSHELPSECTIONTYPEID, 8);
        fieldIndexMap.put(FIELD_PSHELPSECTIONTYPENAME, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
        fieldIndexMap.put(FIELD_VALIDFLAG, 12);
    }
}

