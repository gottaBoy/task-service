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
import net.ibizsys.pscore.srv.config.entity.PSLanguage;
import net.ibizsys.pscore.srv.config.entity.PSSysLanRes;
import net.ibizsys.pscore.srv.config.service.PSLanguageService;
import net.ibizsys.pscore.srv.config.service.PSSysLanResService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysLanItemBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysLanItemBase.class);
    public static final String FIELD_CONTENT = "CONTENT";
    public static final String FIELD_CONTENT2 = "CONTENT2";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSLANGUAGEID = "PSLANGUAGEID";
    public static final String FIELD_PSLANGUAGENAME = "PSLANGUAGENAME";
    public static final String FIELD_PSSYSLANITEMID = "PSSYSLANITEMID";
    public static final String FIELD_PSSYSLANITEMNAME = "PSSYSLANITEMNAME";
    public static final String FIELD_PSSYSLANRESID = "PSSYSLANRESID";
    public static final String FIELD_PSSYSLANRESNAME = "PSSYSLANRESNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CONTENT = 0;
    private static final int INDEX_CONTENT2 = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PSLANGUAGEID = 5;
    private static final int INDEX_PSLANGUAGENAME = 6;
    private static final int INDEX_PSSYSLANITEMID = 7;
    private static final int INDEX_PSSYSLANITEMNAME = 8;
    private static final int INDEX_PSSYSLANRESID = 9;
    private static final int INDEX_PSSYSLANRESNAME = 10;
    private static final int INDEX_UPDATEDATE = 11;
    private static final int INDEX_UPDATEMAN = 12;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysLanItemBase proxyPSSysLanItemBase = null;
    private boolean contentDirtyFlag = false;
    private boolean content2DirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pslanguageidDirtyFlag = false;
    private boolean pslanguagenameDirtyFlag = false;
    private boolean pssyslanitemidDirtyFlag = false;
    private boolean pssyslanitemnameDirtyFlag = false;
    private boolean pssyslanresidDirtyFlag = false;
    private boolean pssyslanresnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="content")
    private String content;
    @Column(name="content2")
    private String content2;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="pslanguageid")
    private String pslanguageid;
    @Column(name="pslanguagename")
    private String pslanguagename;
    @Column(name="pssyslanitemid")
    private String pssyslanitemid;
    @Column(name="pssyslanitemname")
    private String pssyslanitemname;
    @Column(name="pssyslanresid")
    private String pssyslanresid;
    @Column(name="pssyslanresname")
    private String pssyslanresname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSLanguageLock = new Integer(1);
    private PSLanguage pslanguage = null;
    private Integer objPSSysLanResLock = new Integer(1);
    private PSSysLanRes pssyslanres = null;

    public void setContent(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setContent(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.content = string;
        this.contentDirtyFlag = true;
    }

    public String getContent() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContent();
        }
        return this.content;
    }

    public boolean isContentDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isContentDirty();
        }
        return this.contentDirtyFlag;
    }

    public void resetContent() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetContent();
            return;
        }
        this.contentDirtyFlag = false;
        this.content = null;
    }

    public void setContent2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setContent2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.content2 = string;
        this.content2DirtyFlag = true;
    }

    public String getContent2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContent2();
        }
        return this.content2;
    }

    public boolean isContent2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isContent2Dirty();
        }
        return this.content2DirtyFlag;
    }

    public void resetContent2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetContent2();
            return;
        }
        this.content2DirtyFlag = false;
        this.content2 = null;
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

    public void setPSLanguageId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSLanguageId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pslanguageid = string;
        this.pslanguageidDirtyFlag = true;
    }

    public String getPSLanguageId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSLanguageId();
        }
        return this.pslanguageid;
    }

    public boolean isPSLanguageIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSLanguageIdDirty();
        }
        return this.pslanguageidDirtyFlag;
    }

    public void resetPSLanguageId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSLanguageId();
            return;
        }
        this.pslanguageidDirtyFlag = false;
        this.pslanguageid = null;
    }

    public void setPSLanguageName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSLanguageName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pslanguagename = string;
        this.pslanguagenameDirtyFlag = true;
    }

    public String getPSLanguageName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSLanguageName();
        }
        return this.pslanguagename;
    }

    public boolean isPSLanguageNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSLanguageNameDirty();
        }
        return this.pslanguagenameDirtyFlag;
    }

    public void resetPSLanguageName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSLanguageName();
            return;
        }
        this.pslanguagenameDirtyFlag = false;
        this.pslanguagename = null;
    }

    public void setPSSysLanItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysLanItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyslanitemid = string;
        this.pssyslanitemidDirtyFlag = true;
    }

    public String getPSSysLanItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysLanItemId();
        }
        return this.pssyslanitemid;
    }

    public boolean isPSSysLanItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysLanItemIdDirty();
        }
        return this.pssyslanitemidDirtyFlag;
    }

    public void resetPSSysLanItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysLanItemId();
            return;
        }
        this.pssyslanitemidDirtyFlag = false;
        this.pssyslanitemid = null;
    }

    public void setPSSysLanItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysLanItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyslanitemname = string;
        this.pssyslanitemnameDirtyFlag = true;
    }

    public String getPSSysLanItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysLanItemName();
        }
        return this.pssyslanitemname;
    }

    public boolean isPSSysLanItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysLanItemNameDirty();
        }
        return this.pssyslanitemnameDirtyFlag;
    }

    public void resetPSSysLanItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysLanItemName();
            return;
        }
        this.pssyslanitemnameDirtyFlag = false;
        this.pssyslanitemname = null;
    }

    public void setPSSysLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyslanresid = string;
        this.pssyslanresidDirtyFlag = true;
    }

    public String getPSSysLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysLanResId();
        }
        return this.pssyslanresid;
    }

    public boolean isPSSysLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysLanResIdDirty();
        }
        return this.pssyslanresidDirtyFlag;
    }

    public void resetPSSysLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysLanResId();
            return;
        }
        this.pssyslanresidDirtyFlag = false;
        this.pssyslanresid = null;
    }

    public void setPSSysLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyslanresname = string;
        this.pssyslanresnameDirtyFlag = true;
    }

    public String getPSSysLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysLanResName();
        }
        return this.pssyslanresname;
    }

    public boolean isPSSysLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysLanResNameDirty();
        }
        return this.pssyslanresnameDirtyFlag;
    }

    public void resetPSSysLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysLanResName();
            return;
        }
        this.pssyslanresnameDirtyFlag = false;
        this.pssyslanresname = null;
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
        PSSysLanItemBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysLanItemBase pSSysLanItemBase) {
        pSSysLanItemBase.resetContent();
        pSSysLanItemBase.resetContent2();
        pSSysLanItemBase.resetCreateDate();
        pSSysLanItemBase.resetCreateMan();
        pSSysLanItemBase.resetMemo();
        pSSysLanItemBase.resetPSLanguageId();
        pSSysLanItemBase.resetPSLanguageName();
        pSSysLanItemBase.resetPSSysLanItemId();
        pSSysLanItemBase.resetPSSysLanItemName();
        pSSysLanItemBase.resetPSSysLanResId();
        pSSysLanItemBase.resetPSSysLanResName();
        pSSysLanItemBase.resetUpdateDate();
        pSSysLanItemBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isContentDirty()) {
            hashMap.put(FIELD_CONTENT, this.getContent());
        }
        if (!bl || this.isContent2Dirty()) {
            hashMap.put(FIELD_CONTENT2, this.getContent2());
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
        if (!bl || this.isPSLanguageIdDirty()) {
            hashMap.put(FIELD_PSLANGUAGEID, this.getPSLanguageId());
        }
        if (!bl || this.isPSLanguageNameDirty()) {
            hashMap.put(FIELD_PSLANGUAGENAME, this.getPSLanguageName());
        }
        if (!bl || this.isPSSysLanItemIdDirty()) {
            hashMap.put(FIELD_PSSYSLANITEMID, this.getPSSysLanItemId());
        }
        if (!bl || this.isPSSysLanItemNameDirty()) {
            hashMap.put(FIELD_PSSYSLANITEMNAME, this.getPSSysLanItemName());
        }
        if (!bl || this.isPSSysLanResIdDirty()) {
            hashMap.put(FIELD_PSSYSLANRESID, this.getPSSysLanResId());
        }
        if (!bl || this.isPSSysLanResNameDirty()) {
            hashMap.put(FIELD_PSSYSLANRESNAME, this.getPSSysLanResName());
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
        return PSSysLanItemBase.get(this, n);
    }

    private static Object get(PSSysLanItemBase pSSysLanItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysLanItemBase.getContent();
            }
            case 1: {
                return pSSysLanItemBase.getContent2();
            }
            case 2: {
                return pSSysLanItemBase.getCreateDate();
            }
            case 3: {
                return pSSysLanItemBase.getCreateMan();
            }
            case 4: {
                return pSSysLanItemBase.getMemo();
            }
            case 5: {
                return pSSysLanItemBase.getPSLanguageId();
            }
            case 6: {
                return pSSysLanItemBase.getPSLanguageName();
            }
            case 7: {
                return pSSysLanItemBase.getPSSysLanItemId();
            }
            case 8: {
                return pSSysLanItemBase.getPSSysLanItemName();
            }
            case 9: {
                return pSSysLanItemBase.getPSSysLanResId();
            }
            case 10: {
                return pSSysLanItemBase.getPSSysLanResName();
            }
            case 11: {
                return pSSysLanItemBase.getUpdateDate();
            }
            case 12: {
                return pSSysLanItemBase.getUpdateMan();
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
        PSSysLanItemBase.set(this, n, object);
    }

    private static void set(PSSysLanItemBase pSSysLanItemBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysLanItemBase.setContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysLanItemBase.setContent2(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysLanItemBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSSysLanItemBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysLanItemBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysLanItemBase.setPSLanguageId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysLanItemBase.setPSLanguageName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysLanItemBase.setPSSysLanItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysLanItemBase.setPSSysLanItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysLanItemBase.setPSSysLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysLanItemBase.setPSSysLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysLanItemBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSSysLanItemBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSSysLanItemBase.isNull(this, n);
    }

    private static boolean isNull(PSSysLanItemBase pSSysLanItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysLanItemBase.getContent() == null;
            }
            case 1: {
                return pSSysLanItemBase.getContent2() == null;
            }
            case 2: {
                return pSSysLanItemBase.getCreateDate() == null;
            }
            case 3: {
                return pSSysLanItemBase.getCreateMan() == null;
            }
            case 4: {
                return pSSysLanItemBase.getMemo() == null;
            }
            case 5: {
                return pSSysLanItemBase.getPSLanguageId() == null;
            }
            case 6: {
                return pSSysLanItemBase.getPSLanguageName() == null;
            }
            case 7: {
                return pSSysLanItemBase.getPSSysLanItemId() == null;
            }
            case 8: {
                return pSSysLanItemBase.getPSSysLanItemName() == null;
            }
            case 9: {
                return pSSysLanItemBase.getPSSysLanResId() == null;
            }
            case 10: {
                return pSSysLanItemBase.getPSSysLanResName() == null;
            }
            case 11: {
                return pSSysLanItemBase.getUpdateDate() == null;
            }
            case 12: {
                return pSSysLanItemBase.getUpdateMan() == null;
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
        return PSSysLanItemBase.contains(this, n);
    }

    private static boolean contains(PSSysLanItemBase pSSysLanItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysLanItemBase.isContentDirty();
            }
            case 1: {
                return pSSysLanItemBase.isContent2Dirty();
            }
            case 2: {
                return pSSysLanItemBase.isCreateDateDirty();
            }
            case 3: {
                return pSSysLanItemBase.isCreateManDirty();
            }
            case 4: {
                return pSSysLanItemBase.isMemoDirty();
            }
            case 5: {
                return pSSysLanItemBase.isPSLanguageIdDirty();
            }
            case 6: {
                return pSSysLanItemBase.isPSLanguageNameDirty();
            }
            case 7: {
                return pSSysLanItemBase.isPSSysLanItemIdDirty();
            }
            case 8: {
                return pSSysLanItemBase.isPSSysLanItemNameDirty();
            }
            case 9: {
                return pSSysLanItemBase.isPSSysLanResIdDirty();
            }
            case 10: {
                return pSSysLanItemBase.isPSSysLanResNameDirty();
            }
            case 11: {
                return pSSysLanItemBase.isUpdateDateDirty();
            }
            case 12: {
                return pSSysLanItemBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysLanItemBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysLanItemBase pSSysLanItemBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysLanItemBase.getContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"content", (Object)PSSysLanItemBase.getJSONValue((Object)pSSysLanItemBase.getContent()), (boolean)false);
        }
        if (bl || pSSysLanItemBase.getContent2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"content2", (Object)PSSysLanItemBase.getJSONValue((Object)pSSysLanItemBase.getContent2()), (boolean)false);
        }
        if (bl || pSSysLanItemBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysLanItemBase.getJSONValue((Object)pSSysLanItemBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysLanItemBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysLanItemBase.getJSONValue((Object)pSSysLanItemBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysLanItemBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysLanItemBase.getJSONValue((Object)pSSysLanItemBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysLanItemBase.getPSLanguageId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pslanguageid", (Object)PSSysLanItemBase.getJSONValue((Object)pSSysLanItemBase.getPSLanguageId()), (boolean)false);
        }
        if (bl || pSSysLanItemBase.getPSLanguageName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pslanguagename", (Object)PSSysLanItemBase.getJSONValue((Object)pSSysLanItemBase.getPSLanguageName()), (boolean)false);
        }
        if (bl || pSSysLanItemBase.getPSSysLanItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyslanitemid", (Object)PSSysLanItemBase.getJSONValue((Object)pSSysLanItemBase.getPSSysLanItemId()), (boolean)false);
        }
        if (bl || pSSysLanItemBase.getPSSysLanItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyslanitemname", (Object)PSSysLanItemBase.getJSONValue((Object)pSSysLanItemBase.getPSSysLanItemName()), (boolean)false);
        }
        if (bl || pSSysLanItemBase.getPSSysLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyslanresid", (Object)PSSysLanItemBase.getJSONValue((Object)pSSysLanItemBase.getPSSysLanResId()), (boolean)false);
        }
        if (bl || pSSysLanItemBase.getPSSysLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyslanresname", (Object)PSSysLanItemBase.getJSONValue((Object)pSSysLanItemBase.getPSSysLanResName()), (boolean)false);
        }
        if (bl || pSSysLanItemBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysLanItemBase.getJSONValue((Object)pSSysLanItemBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysLanItemBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysLanItemBase.getJSONValue((Object)pSSysLanItemBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysLanItemBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysLanItemBase pSSysLanItemBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysLanItemBase.getContent() != null) {
            object = pSSysLanItemBase.getContent();
            xmlNode.setAttribute(FIELD_CONTENT, (String)(object == null ? "" : object));
        }
        if (bl || pSSysLanItemBase.getContent2() != null) {
            object = pSSysLanItemBase.getContent2();
            xmlNode.setAttribute(FIELD_CONTENT2, object == null ? "" : (String)object);
        }
        if (bl || pSSysLanItemBase.getCreateDate() != null) {
            object = pSSysLanItemBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysLanItemBase.getCreateMan() != null) {
            object = pSSysLanItemBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysLanItemBase.getMemo() != null) {
            object = pSSysLanItemBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysLanItemBase.getPSLanguageId() != null) {
            object = pSSysLanItemBase.getPSLanguageId();
            xmlNode.setAttribute(FIELD_PSLANGUAGEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysLanItemBase.getPSLanguageName() != null) {
            object = pSSysLanItemBase.getPSLanguageName();
            xmlNode.setAttribute(FIELD_PSLANGUAGENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysLanItemBase.getPSSysLanItemId() != null) {
            object = pSSysLanItemBase.getPSSysLanItemId();
            xmlNode.setAttribute(FIELD_PSSYSLANITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysLanItemBase.getPSSysLanItemName() != null) {
            object = pSSysLanItemBase.getPSSysLanItemName();
            xmlNode.setAttribute(FIELD_PSSYSLANITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysLanItemBase.getPSSysLanResId() != null) {
            object = pSSysLanItemBase.getPSSysLanResId();
            xmlNode.setAttribute(FIELD_PSSYSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSSysLanItemBase.getPSSysLanResName() != null) {
            object = pSSysLanItemBase.getPSSysLanResName();
            xmlNode.setAttribute(FIELD_PSSYSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysLanItemBase.getUpdateDate() != null) {
            object = pSSysLanItemBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysLanItemBase.getUpdateMan() != null) {
            object = pSSysLanItemBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysLanItemBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysLanItemBase pSSysLanItemBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysLanItemBase.isContentDirty() && (bl || pSSysLanItemBase.getContent() != null)) {
            iDataObject.set(FIELD_CONTENT, (Object)pSSysLanItemBase.getContent());
        }
        if (pSSysLanItemBase.isContent2Dirty() && (bl || pSSysLanItemBase.getContent2() != null)) {
            iDataObject.set(FIELD_CONTENT2, (Object)pSSysLanItemBase.getContent2());
        }
        if (pSSysLanItemBase.isCreateDateDirty() && (bl || pSSysLanItemBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysLanItemBase.getCreateDate());
        }
        if (pSSysLanItemBase.isCreateManDirty() && (bl || pSSysLanItemBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysLanItemBase.getCreateMan());
        }
        if (pSSysLanItemBase.isMemoDirty() && (bl || pSSysLanItemBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysLanItemBase.getMemo());
        }
        if (pSSysLanItemBase.isPSLanguageIdDirty() && (bl || pSSysLanItemBase.getPSLanguageId() != null)) {
            iDataObject.set(FIELD_PSLANGUAGEID, (Object)pSSysLanItemBase.getPSLanguageId());
        }
        if (pSSysLanItemBase.isPSLanguageNameDirty() && (bl || pSSysLanItemBase.getPSLanguageName() != null)) {
            iDataObject.set(FIELD_PSLANGUAGENAME, (Object)pSSysLanItemBase.getPSLanguageName());
        }
        if (pSSysLanItemBase.isPSSysLanItemIdDirty() && (bl || pSSysLanItemBase.getPSSysLanItemId() != null)) {
            iDataObject.set(FIELD_PSSYSLANITEMID, (Object)pSSysLanItemBase.getPSSysLanItemId());
        }
        if (pSSysLanItemBase.isPSSysLanItemNameDirty() && (bl || pSSysLanItemBase.getPSSysLanItemName() != null)) {
            iDataObject.set(FIELD_PSSYSLANITEMNAME, (Object)pSSysLanItemBase.getPSSysLanItemName());
        }
        if (pSSysLanItemBase.isPSSysLanResIdDirty() && (bl || pSSysLanItemBase.getPSSysLanResId() != null)) {
            iDataObject.set(FIELD_PSSYSLANRESID, (Object)pSSysLanItemBase.getPSSysLanResId());
        }
        if (pSSysLanItemBase.isPSSysLanResNameDirty() && (bl || pSSysLanItemBase.getPSSysLanResName() != null)) {
            iDataObject.set(FIELD_PSSYSLANRESNAME, (Object)pSSysLanItemBase.getPSSysLanResName());
        }
        if (pSSysLanItemBase.isUpdateDateDirty() && (bl || pSSysLanItemBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysLanItemBase.getUpdateDate());
        }
        if (pSSysLanItemBase.isUpdateManDirty() && (bl || pSSysLanItemBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysLanItemBase.getUpdateMan());
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
        return PSSysLanItemBase.remove(this, n);
    }

    private static boolean remove(PSSysLanItemBase pSSysLanItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysLanItemBase.resetContent();
                return true;
            }
            case 1: {
                pSSysLanItemBase.resetContent2();
                return true;
            }
            case 2: {
                pSSysLanItemBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSSysLanItemBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSSysLanItemBase.resetMemo();
                return true;
            }
            case 5: {
                pSSysLanItemBase.resetPSLanguageId();
                return true;
            }
            case 6: {
                pSSysLanItemBase.resetPSLanguageName();
                return true;
            }
            case 7: {
                pSSysLanItemBase.resetPSSysLanItemId();
                return true;
            }
            case 8: {
                pSSysLanItemBase.resetPSSysLanItemName();
                return true;
            }
            case 9: {
                pSSysLanItemBase.resetPSSysLanResId();
                return true;
            }
            case 10: {
                pSSysLanItemBase.resetPSSysLanResName();
                return true;
            }
            case 11: {
                pSSysLanItemBase.resetUpdateDate();
                return true;
            }
            case 12: {
                pSSysLanItemBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguage getPSLanguage() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSLanguage();
        }
        if (this.getPSLanguageId() == null) {
            return null;
        }
        Integer n = this.objPSLanguageLock;
        synchronized (n) {
            if (this.pslanguage != null && DataTypeHelper.compare((int)25, (Object)this.getPSLanguageId(), (Object)this.pslanguage.getPSLanguageId()) != 0L) {
                this.pslanguage = null;
            }
            if (this.pslanguage == null) {
                PSLanguage pSLanguage = new PSLanguage();
                pSLanguage.setPSLanguageId(this.getPSLanguageId());
                PSLanguageService pSLanguageService = (PSLanguageService)ServiceGlobal.getService(PSLanguageService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageService.autoGet((IEntity)pSLanguage);
                this.pslanguage = pSLanguage;
            }
            return this.pslanguage;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysLanRes getPSSysLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysLanRes();
        }
        if (this.getPSSysLanResId() == null) {
            return null;
        }
        Integer n = this.objPSSysLanResLock;
        synchronized (n) {
            if (this.pssyslanres != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysLanResId(), (Object)this.pssyslanres.getPSSysLanResId()) != 0L) {
                this.pssyslanres = null;
            }
            if (this.pssyslanres == null) {
                PSSysLanRes pSSysLanRes = new PSSysLanRes();
                pSSysLanRes.setPSSysLanResId(this.getPSSysLanResId());
                PSSysLanResService pSSysLanResService = (PSSysLanResService)ServiceGlobal.getService(PSSysLanResService.class, (SessionFactory)this.getSessionFactory());
                pSSysLanResService.autoGet((IEntity)pSSysLanRes);
                this.pssyslanres = pSSysLanRes;
            }
            return this.pssyslanres;
        }
    }

    private PSSysLanItemBase getProxyEntity() {
        return this.proxyPSSysLanItemBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysLanItemBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysLanItemBase) {
            this.proxyPSSysLanItemBase = (PSSysLanItemBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysLanItemService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CONTENT, 0);
        fieldIndexMap.put(FIELD_CONTENT2, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PSLANGUAGEID, 5);
        fieldIndexMap.put(FIELD_PSLANGUAGENAME, 6);
        fieldIndexMap.put(FIELD_PSSYSLANITEMID, 7);
        fieldIndexMap.put(FIELD_PSSYSLANITEMNAME, 8);
        fieldIndexMap.put(FIELD_PSSYSLANRESID, 9);
        fieldIndexMap.put(FIELD_PSSYSLANRESNAME, 10);
        fieldIndexMap.put(FIELD_UPDATEDATE, 11);
        fieldIndexMap.put(FIELD_UPDATEMAN, 12);
    }
}

