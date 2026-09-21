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
import java.util.ArrayList;
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
import net.ibizsys.pscore.srv.config.entity.PSHelpArtSec;
import net.ibizsys.pscore.srv.config.entity.PSHelpArticleTempl;
import net.ibizsys.pscore.srv.config.service.PSHelpArtSecService;
import net.ibizsys.pscore.srv.config.service.PSHelpArticleTemplService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSHelpArticleTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSHelpArticleTypeBase.class);
    public static final String FIELD_ARTICLEOBJ = "ARTICLEOBJ";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSHELPARTICLETEMPLID = "PSHELPARTICLETEMPLID";
    public static final String FIELD_PSHELPARTICLETEMPLNAME = "PSHELPARTICLETEMPLNAME";
    public static final String FIELD_PSHELPARTICLETYPEID = "PSHELPARTICLETYPEID";
    public static final String FIELD_PSHELPARTICLETYPENAME = "PSHELPARTICLETYPENAME";
    public static final String FIELD_PUBOBJ = "PUBOBJ";
    public static final String FIELD_TYPEOBJ = "TYPEOBJ";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_ARTICLEOBJ = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSHELPARTICLETEMPLID = 4;
    private static final int INDEX_PSHELPARTICLETEMPLNAME = 5;
    private static final int INDEX_PSHELPARTICLETYPEID = 6;
    private static final int INDEX_PSHELPARTICLETYPENAME = 7;
    private static final int INDEX_PUBOBJ = 8;
    private static final int INDEX_TYPEOBJ = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final int INDEX_VALIDFLAG = 12;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSHelpArticleTypeBase proxyPSHelpArticleTypeBase = null;
    private boolean articleobjDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pshelparticletemplidDirtyFlag = false;
    private boolean pshelparticletemplnameDirtyFlag = false;
    private boolean pshelparticletypeidDirtyFlag = false;
    private boolean pshelparticletypenameDirtyFlag = false;
    private boolean pubobjDirtyFlag = false;
    private boolean typeobjDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="articleobj")
    private String articleobj;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="pshelparticletemplid")
    private String pshelparticletemplid;
    @Column(name="pshelparticletemplname")
    private String pshelparticletemplname;
    @Column(name="pshelparticletypeid")
    private String pshelparticletypeid;
    @Column(name="pshelparticletypename")
    private String pshelparticletypename;
    @Column(name="pubobj")
    private String pubobj;
    @Column(name="typeobj")
    private String typeobj;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSHelpArticleTemplLock = new Integer(1);
    private PSHelpArticleTempl pshelparticletempl = null;
    private Integer objPSHelpArtSecsLock = new Integer(1);
    private ArrayList<PSHelpArtSec> pshelpartsecs = null;

    public void setArticleObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setArticleObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.articleobj = string;
        this.articleobjDirtyFlag = true;
    }

    public String getArticleObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getArticleObj();
        }
        return this.articleobj;
    }

    public boolean isArticleObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isArticleObjDirty();
        }
        return this.articleobjDirtyFlag;
    }

    public void resetArticleObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetArticleObj();
            return;
        }
        this.articleobjDirtyFlag = false;
        this.articleobj = null;
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

    public void setPSHelpArticleTemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSHelpArticleTemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pshelparticletemplid = string;
        this.pshelparticletemplidDirtyFlag = true;
    }

    public String getPSHelpArticleTemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSHelpArticleTemplId();
        }
        return this.pshelparticletemplid;
    }

    public boolean isPSHelpArticleTemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSHelpArticleTemplIdDirty();
        }
        return this.pshelparticletemplidDirtyFlag;
    }

    public void resetPSHelpArticleTemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSHelpArticleTemplId();
            return;
        }
        this.pshelparticletemplidDirtyFlag = false;
        this.pshelparticletemplid = null;
    }

    public void setPSHelpArticleTemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSHelpArticleTemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pshelparticletemplname = string;
        this.pshelparticletemplnameDirtyFlag = true;
    }

    public String getPSHelpArticleTemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSHelpArticleTemplName();
        }
        return this.pshelparticletemplname;
    }

    public boolean isPSHelpArticleTemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSHelpArticleTemplNameDirty();
        }
        return this.pshelparticletemplnameDirtyFlag;
    }

    public void resetPSHelpArticleTemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSHelpArticleTemplName();
            return;
        }
        this.pshelparticletemplnameDirtyFlag = false;
        this.pshelparticletemplname = null;
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

    public void setPubObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPubObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pubobj = string;
        this.pubobjDirtyFlag = true;
    }

    public String getPubObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPubObj();
        }
        return this.pubobj;
    }

    public boolean isPubObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPubObjDirty();
        }
        return this.pubobjDirtyFlag;
    }

    public void resetPubObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPubObj();
            return;
        }
        this.pubobjDirtyFlag = false;
        this.pubobj = null;
    }

    public void setTypeObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTypeObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.typeobj = string;
        this.typeobjDirtyFlag = true;
    }

    public String getTypeObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTypeObj();
        }
        return this.typeobj;
    }

    public boolean isTypeObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTypeObjDirty();
        }
        return this.typeobjDirtyFlag;
    }

    public void resetTypeObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTypeObj();
            return;
        }
        this.typeobjDirtyFlag = false;
        this.typeobj = null;
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
        PSHelpArticleTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSHelpArticleTypeBase pSHelpArticleTypeBase) {
        pSHelpArticleTypeBase.resetArticleObj();
        pSHelpArticleTypeBase.resetCreateDate();
        pSHelpArticleTypeBase.resetCreateMan();
        pSHelpArticleTypeBase.resetMemo();
        pSHelpArticleTypeBase.resetPSHelpArticleTemplId();
        pSHelpArticleTypeBase.resetPSHelpArticleTemplName();
        pSHelpArticleTypeBase.resetPSHelpArticleTypeId();
        pSHelpArticleTypeBase.resetPSHelpArticleTypeName();
        pSHelpArticleTypeBase.resetPubObj();
        pSHelpArticleTypeBase.resetTypeObj();
        pSHelpArticleTypeBase.resetUpdateDate();
        pSHelpArticleTypeBase.resetUpdateMan();
        pSHelpArticleTypeBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isArticleObjDirty()) {
            hashMap.put(FIELD_ARTICLEOBJ, this.getArticleObj());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSHelpArticleTemplIdDirty()) {
            hashMap.put(FIELD_PSHELPARTICLETEMPLID, this.getPSHelpArticleTemplId());
        }
        if (!bl || this.isPSHelpArticleTemplNameDirty()) {
            hashMap.put(FIELD_PSHELPARTICLETEMPLNAME, this.getPSHelpArticleTemplName());
        }
        if (!bl || this.isPSHelpArticleTypeIdDirty()) {
            hashMap.put(FIELD_PSHELPARTICLETYPEID, this.getPSHelpArticleTypeId());
        }
        if (!bl || this.isPSHelpArticleTypeNameDirty()) {
            hashMap.put(FIELD_PSHELPARTICLETYPENAME, this.getPSHelpArticleTypeName());
        }
        if (!bl || this.isPubObjDirty()) {
            hashMap.put(FIELD_PUBOBJ, this.getPubObj());
        }
        if (!bl || this.isTypeObjDirty()) {
            hashMap.put(FIELD_TYPEOBJ, this.getTypeObj());
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
        return PSHelpArticleTypeBase.get(this, n);
    }

    private static Object get(PSHelpArticleTypeBase pSHelpArticleTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSHelpArticleTypeBase.getArticleObj();
            }
            case 1: {
                return pSHelpArticleTypeBase.getCreateDate();
            }
            case 2: {
                return pSHelpArticleTypeBase.getCreateMan();
            }
            case 3: {
                return pSHelpArticleTypeBase.getMemo();
            }
            case 4: {
                return pSHelpArticleTypeBase.getPSHelpArticleTemplId();
            }
            case 5: {
                return pSHelpArticleTypeBase.getPSHelpArticleTemplName();
            }
            case 6: {
                return pSHelpArticleTypeBase.getPSHelpArticleTypeId();
            }
            case 7: {
                return pSHelpArticleTypeBase.getPSHelpArticleTypeName();
            }
            case 8: {
                return pSHelpArticleTypeBase.getPubObj();
            }
            case 9: {
                return pSHelpArticleTypeBase.getTypeObj();
            }
            case 10: {
                return pSHelpArticleTypeBase.getUpdateDate();
            }
            case 11: {
                return pSHelpArticleTypeBase.getUpdateMan();
            }
            case 12: {
                return pSHelpArticleTypeBase.getValidFlag();
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
        PSHelpArticleTypeBase.set(this, n, object);
    }

    private static void set(PSHelpArticleTypeBase pSHelpArticleTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSHelpArticleTypeBase.setArticleObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSHelpArticleTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSHelpArticleTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSHelpArticleTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSHelpArticleTypeBase.setPSHelpArticleTemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSHelpArticleTypeBase.setPSHelpArticleTemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSHelpArticleTypeBase.setPSHelpArticleTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSHelpArticleTypeBase.setPSHelpArticleTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSHelpArticleTypeBase.setPubObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSHelpArticleTypeBase.setTypeObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSHelpArticleTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSHelpArticleTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSHelpArticleTypeBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSHelpArticleTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSHelpArticleTypeBase pSHelpArticleTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSHelpArticleTypeBase.getArticleObj() == null;
            }
            case 1: {
                return pSHelpArticleTypeBase.getCreateDate() == null;
            }
            case 2: {
                return pSHelpArticleTypeBase.getCreateMan() == null;
            }
            case 3: {
                return pSHelpArticleTypeBase.getMemo() == null;
            }
            case 4: {
                return pSHelpArticleTypeBase.getPSHelpArticleTemplId() == null;
            }
            case 5: {
                return pSHelpArticleTypeBase.getPSHelpArticleTemplName() == null;
            }
            case 6: {
                return pSHelpArticleTypeBase.getPSHelpArticleTypeId() == null;
            }
            case 7: {
                return pSHelpArticleTypeBase.getPSHelpArticleTypeName() == null;
            }
            case 8: {
                return pSHelpArticleTypeBase.getPubObj() == null;
            }
            case 9: {
                return pSHelpArticleTypeBase.getTypeObj() == null;
            }
            case 10: {
                return pSHelpArticleTypeBase.getUpdateDate() == null;
            }
            case 11: {
                return pSHelpArticleTypeBase.getUpdateMan() == null;
            }
            case 12: {
                return pSHelpArticleTypeBase.getValidFlag() == null;
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
        return PSHelpArticleTypeBase.contains(this, n);
    }

    private static boolean contains(PSHelpArticleTypeBase pSHelpArticleTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSHelpArticleTypeBase.isArticleObjDirty();
            }
            case 1: {
                return pSHelpArticleTypeBase.isCreateDateDirty();
            }
            case 2: {
                return pSHelpArticleTypeBase.isCreateManDirty();
            }
            case 3: {
                return pSHelpArticleTypeBase.isMemoDirty();
            }
            case 4: {
                return pSHelpArticleTypeBase.isPSHelpArticleTemplIdDirty();
            }
            case 5: {
                return pSHelpArticleTypeBase.isPSHelpArticleTemplNameDirty();
            }
            case 6: {
                return pSHelpArticleTypeBase.isPSHelpArticleTypeIdDirty();
            }
            case 7: {
                return pSHelpArticleTypeBase.isPSHelpArticleTypeNameDirty();
            }
            case 8: {
                return pSHelpArticleTypeBase.isPubObjDirty();
            }
            case 9: {
                return pSHelpArticleTypeBase.isTypeObjDirty();
            }
            case 10: {
                return pSHelpArticleTypeBase.isUpdateDateDirty();
            }
            case 11: {
                return pSHelpArticleTypeBase.isUpdateManDirty();
            }
            case 12: {
                return pSHelpArticleTypeBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSHelpArticleTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSHelpArticleTypeBase pSHelpArticleTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSHelpArticleTypeBase.getArticleObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"articleobj", (Object)PSHelpArticleTypeBase.getJSONValue((Object)pSHelpArticleTypeBase.getArticleObj()), (boolean)false);
        }
        if (bl || pSHelpArticleTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSHelpArticleTypeBase.getJSONValue((Object)pSHelpArticleTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSHelpArticleTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSHelpArticleTypeBase.getJSONValue((Object)pSHelpArticleTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSHelpArticleTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSHelpArticleTypeBase.getJSONValue((Object)pSHelpArticleTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSHelpArticleTypeBase.getPSHelpArticleTemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pshelparticletemplid", (Object)PSHelpArticleTypeBase.getJSONValue((Object)pSHelpArticleTypeBase.getPSHelpArticleTemplId()), (boolean)false);
        }
        if (bl || pSHelpArticleTypeBase.getPSHelpArticleTemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pshelparticletemplname", (Object)PSHelpArticleTypeBase.getJSONValue((Object)pSHelpArticleTypeBase.getPSHelpArticleTemplName()), (boolean)false);
        }
        if (bl || pSHelpArticleTypeBase.getPSHelpArticleTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pshelparticletypeid", (Object)PSHelpArticleTypeBase.getJSONValue((Object)pSHelpArticleTypeBase.getPSHelpArticleTypeId()), (boolean)false);
        }
        if (bl || pSHelpArticleTypeBase.getPSHelpArticleTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pshelparticletypename", (Object)PSHelpArticleTypeBase.getJSONValue((Object)pSHelpArticleTypeBase.getPSHelpArticleTypeName()), (boolean)false);
        }
        if (bl || pSHelpArticleTypeBase.getPubObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pubobj", (Object)PSHelpArticleTypeBase.getJSONValue((Object)pSHelpArticleTypeBase.getPubObj()), (boolean)false);
        }
        if (bl || pSHelpArticleTypeBase.getTypeObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typeobj", (Object)PSHelpArticleTypeBase.getJSONValue((Object)pSHelpArticleTypeBase.getTypeObj()), (boolean)false);
        }
        if (bl || pSHelpArticleTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSHelpArticleTypeBase.getJSONValue((Object)pSHelpArticleTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSHelpArticleTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSHelpArticleTypeBase.getJSONValue((Object)pSHelpArticleTypeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSHelpArticleTypeBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSHelpArticleTypeBase.getJSONValue((Object)pSHelpArticleTypeBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSHelpArticleTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSHelpArticleTypeBase pSHelpArticleTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSHelpArticleTypeBase.getArticleObj() != null) {
            object = pSHelpArticleTypeBase.getArticleObj();
            xmlNode.setAttribute(FIELD_ARTICLEOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArticleTypeBase.getCreateDate() != null) {
            object = pSHelpArticleTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSHelpArticleTypeBase.getCreateMan() != null) {
            object = pSHelpArticleTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArticleTypeBase.getMemo() != null) {
            object = pSHelpArticleTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArticleTypeBase.getPSHelpArticleTemplId() != null) {
            object = pSHelpArticleTypeBase.getPSHelpArticleTemplId();
            xmlNode.setAttribute(FIELD_PSHELPARTICLETEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArticleTypeBase.getPSHelpArticleTemplName() != null) {
            object = pSHelpArticleTypeBase.getPSHelpArticleTemplName();
            xmlNode.setAttribute(FIELD_PSHELPARTICLETEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArticleTypeBase.getPSHelpArticleTypeId() != null) {
            object = pSHelpArticleTypeBase.getPSHelpArticleTypeId();
            xmlNode.setAttribute(FIELD_PSHELPARTICLETYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArticleTypeBase.getPSHelpArticleTypeName() != null) {
            object = pSHelpArticleTypeBase.getPSHelpArticleTypeName();
            xmlNode.setAttribute(FIELD_PSHELPARTICLETYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArticleTypeBase.getPubObj() != null) {
            object = pSHelpArticleTypeBase.getPubObj();
            xmlNode.setAttribute(FIELD_PUBOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArticleTypeBase.getTypeObj() != null) {
            object = pSHelpArticleTypeBase.getTypeObj();
            xmlNode.setAttribute(FIELD_TYPEOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArticleTypeBase.getUpdateDate() != null) {
            object = pSHelpArticleTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSHelpArticleTypeBase.getUpdateMan() != null) {
            object = pSHelpArticleTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArticleTypeBase.getValidFlag() != null) {
            object = pSHelpArticleTypeBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSHelpArticleTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSHelpArticleTypeBase pSHelpArticleTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSHelpArticleTypeBase.isArticleObjDirty() && (bl || pSHelpArticleTypeBase.getArticleObj() != null)) {
            iDataObject.set(FIELD_ARTICLEOBJ, (Object)pSHelpArticleTypeBase.getArticleObj());
        }
        if (pSHelpArticleTypeBase.isCreateDateDirty() && (bl || pSHelpArticleTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSHelpArticleTypeBase.getCreateDate());
        }
        if (pSHelpArticleTypeBase.isCreateManDirty() && (bl || pSHelpArticleTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSHelpArticleTypeBase.getCreateMan());
        }
        if (pSHelpArticleTypeBase.isMemoDirty() && (bl || pSHelpArticleTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSHelpArticleTypeBase.getMemo());
        }
        if (pSHelpArticleTypeBase.isPSHelpArticleTemplIdDirty() && (bl || pSHelpArticleTypeBase.getPSHelpArticleTemplId() != null)) {
            iDataObject.set(FIELD_PSHELPARTICLETEMPLID, (Object)pSHelpArticleTypeBase.getPSHelpArticleTemplId());
        }
        if (pSHelpArticleTypeBase.isPSHelpArticleTemplNameDirty() && (bl || pSHelpArticleTypeBase.getPSHelpArticleTemplName() != null)) {
            iDataObject.set(FIELD_PSHELPARTICLETEMPLNAME, (Object)pSHelpArticleTypeBase.getPSHelpArticleTemplName());
        }
        if (pSHelpArticleTypeBase.isPSHelpArticleTypeIdDirty() && (bl || pSHelpArticleTypeBase.getPSHelpArticleTypeId() != null)) {
            iDataObject.set(FIELD_PSHELPARTICLETYPEID, (Object)pSHelpArticleTypeBase.getPSHelpArticleTypeId());
        }
        if (pSHelpArticleTypeBase.isPSHelpArticleTypeNameDirty() && (bl || pSHelpArticleTypeBase.getPSHelpArticleTypeName() != null)) {
            iDataObject.set(FIELD_PSHELPARTICLETYPENAME, (Object)pSHelpArticleTypeBase.getPSHelpArticleTypeName());
        }
        if (pSHelpArticleTypeBase.isPubObjDirty() && (bl || pSHelpArticleTypeBase.getPubObj() != null)) {
            iDataObject.set(FIELD_PUBOBJ, (Object)pSHelpArticleTypeBase.getPubObj());
        }
        if (pSHelpArticleTypeBase.isTypeObjDirty() && (bl || pSHelpArticleTypeBase.getTypeObj() != null)) {
            iDataObject.set(FIELD_TYPEOBJ, (Object)pSHelpArticleTypeBase.getTypeObj());
        }
        if (pSHelpArticleTypeBase.isUpdateDateDirty() && (bl || pSHelpArticleTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSHelpArticleTypeBase.getUpdateDate());
        }
        if (pSHelpArticleTypeBase.isUpdateManDirty() && (bl || pSHelpArticleTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSHelpArticleTypeBase.getUpdateMan());
        }
        if (pSHelpArticleTypeBase.isValidFlagDirty() && (bl || pSHelpArticleTypeBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSHelpArticleTypeBase.getValidFlag());
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
        return PSHelpArticleTypeBase.remove(this, n);
    }

    private static boolean remove(PSHelpArticleTypeBase pSHelpArticleTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSHelpArticleTypeBase.resetArticleObj();
                return true;
            }
            case 1: {
                pSHelpArticleTypeBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSHelpArticleTypeBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSHelpArticleTypeBase.resetMemo();
                return true;
            }
            case 4: {
                pSHelpArticleTypeBase.resetPSHelpArticleTemplId();
                return true;
            }
            case 5: {
                pSHelpArticleTypeBase.resetPSHelpArticleTemplName();
                return true;
            }
            case 6: {
                pSHelpArticleTypeBase.resetPSHelpArticleTypeId();
                return true;
            }
            case 7: {
                pSHelpArticleTypeBase.resetPSHelpArticleTypeName();
                return true;
            }
            case 8: {
                pSHelpArticleTypeBase.resetPubObj();
                return true;
            }
            case 9: {
                pSHelpArticleTypeBase.resetTypeObj();
                return true;
            }
            case 10: {
                pSHelpArticleTypeBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSHelpArticleTypeBase.resetUpdateMan();
                return true;
            }
            case 12: {
                pSHelpArticleTypeBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSHelpArticleTempl getPSHelpArticleTempl() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSHelpArticleTempl();
        }
        if (this.getPSHelpArticleTemplId() == null) {
            return null;
        }
        Integer n = this.objPSHelpArticleTemplLock;
        synchronized (n) {
            if (this.pshelparticletempl != null && DataTypeHelper.compare((int)25, (Object)this.getPSHelpArticleTemplId(), (Object)this.pshelparticletempl.getPSHelpArticleTemplId()) != 0L) {
                this.pshelparticletempl = null;
            }
            if (this.pshelparticletempl == null) {
                PSHelpArticleTempl pSHelpArticleTempl = new PSHelpArticleTempl();
                pSHelpArticleTempl.setPSHelpArticleTemplId(this.getPSHelpArticleTemplId());
                PSHelpArticleTemplService pSHelpArticleTemplService = (PSHelpArticleTemplService)ServiceGlobal.getService(PSHelpArticleTemplService.class, (SessionFactory)this.getSessionFactory());
                pSHelpArticleTemplService.autoGet((IEntity)pSHelpArticleTempl);
                this.pshelparticletempl = pSHelpArticleTempl;
            }
            return this.pshelparticletempl;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSHelpArtSec> getPSHelpArtSecs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSHelpArtSecs();
        }
        if (this.getPSHelpArticleTypeId() == null) {
            return null;
        }
        PSHelpArtSecService pSHelpArtSecService = (PSHelpArtSecService)ServiceGlobal.getService(PSHelpArtSecService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSHelpArtSecsLock;
        synchronized (n) {
            if (this.pshelpartsecs == null) {
                this.pshelpartsecs = pSHelpArtSecService.selectByPSHelpArticleType(this);
            }
            return this.pshelpartsecs;
        }
    }

    private PSHelpArticleTypeBase getProxyEntity() {
        return this.proxyPSHelpArticleTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSHelpArticleTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSHelpArticleTypeBase) {
            this.proxyPSHelpArticleTypeBase = (PSHelpArticleTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSHelpArticleTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ARTICLEOBJ, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSHELPARTICLETEMPLID, 4);
        fieldIndexMap.put(FIELD_PSHELPARTICLETEMPLNAME, 5);
        fieldIndexMap.put(FIELD_PSHELPARTICLETYPEID, 6);
        fieldIndexMap.put(FIELD_PSHELPARTICLETYPENAME, 7);
        fieldIndexMap.put(FIELD_PUBOBJ, 8);
        fieldIndexMap.put(FIELD_TYPEOBJ, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
        fieldIndexMap.put(FIELD_VALIDFLAG, 12);
    }
}

