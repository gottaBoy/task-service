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
import net.ibizsys.pscore.srv.config.entity.PSPF;
import net.ibizsys.pscore.srv.config.service.PSPFService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSPFQuickTemplBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSPFQuickTemplBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSPFID = "PSPFID";
    public static final String FIELD_PSPFNAME = "PSPFNAME";
    public static final String FIELD_PSPFQUICKTEMPLID = "PSPFQUICKTEMPLID";
    public static final String FIELD_PSPFQUICKTEMPLNAME = "PSPFQUICKTEMPLNAME";
    public static final String FIELD_STYLECODE = "STYLECODE";
    public static final String FIELD_TEMPLCODE = "TEMPLCODE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSPFID = 3;
    private static final int INDEX_PSPFNAME = 4;
    private static final int INDEX_PSPFQUICKTEMPLID = 5;
    private static final int INDEX_PSPFQUICKTEMPLNAME = 6;
    private static final int INDEX_STYLECODE = 7;
    private static final int INDEX_TEMPLCODE = 8;
    private static final int INDEX_UPDATEDATE = 9;
    private static final int INDEX_UPDATEMAN = 10;
    private static final int INDEX_VALIDFLAG = 11;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSPFQuickTemplBase proxyPSPFQuickTemplBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pspfidDirtyFlag = false;
    private boolean pspfnameDirtyFlag = false;
    private boolean pspfquicktemplidDirtyFlag = false;
    private boolean pspfquicktemplnameDirtyFlag = false;
    private boolean stylecodeDirtyFlag = false;
    private boolean templcodeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="pspfid")
    private String pspfid;
    @Column(name="pspfname")
    private String pspfname;
    @Column(name="pspfquicktemplid")
    private String pspfquicktemplid;
    @Column(name="pspfquicktemplname")
    private String pspfquicktemplname;
    @Column(name="stylecode")
    private String stylecode;
    @Column(name="templcode")
    private String templcode;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSPFLock = new Integer(1);
    private PSPF pspf = null;

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

    public void setPSPFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfid = string;
        this.pspfidDirtyFlag = true;
    }

    public String getPSPFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFId();
        }
        return this.pspfid;
    }

    public boolean isPSPFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFIdDirty();
        }
        return this.pspfidDirtyFlag;
    }

    public void resetPSPFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFId();
            return;
        }
        this.pspfidDirtyFlag = false;
        this.pspfid = null;
    }

    public void setPSPFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfname = string;
        this.pspfnameDirtyFlag = true;
    }

    public String getPSPFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFName();
        }
        return this.pspfname;
    }

    public boolean isPSPFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFNameDirty();
        }
        return this.pspfnameDirtyFlag;
    }

    public void resetPSPFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFName();
            return;
        }
        this.pspfnameDirtyFlag = false;
        this.pspfname = null;
    }

    public void setPSPFQuickTemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFQuickTemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfquicktemplid = string;
        this.pspfquicktemplidDirtyFlag = true;
    }

    public String getPSPFQuickTemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFQuickTemplId();
        }
        return this.pspfquicktemplid;
    }

    public boolean isPSPFQuickTemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFQuickTemplIdDirty();
        }
        return this.pspfquicktemplidDirtyFlag;
    }

    public void resetPSPFQuickTemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFQuickTemplId();
            return;
        }
        this.pspfquicktemplidDirtyFlag = false;
        this.pspfquicktemplid = null;
    }

    public void setPSPFQuickTemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFQuickTemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfquicktemplname = string;
        this.pspfquicktemplnameDirtyFlag = true;
    }

    public String getPSPFQuickTemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFQuickTemplName();
        }
        return this.pspfquicktemplname;
    }

    public boolean isPSPFQuickTemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFQuickTemplNameDirty();
        }
        return this.pspfquicktemplnameDirtyFlag;
    }

    public void resetPSPFQuickTemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFQuickTemplName();
            return;
        }
        this.pspfquicktemplnameDirtyFlag = false;
        this.pspfquicktemplname = null;
    }

    public void setStyleCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStyleCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.stylecode = string;
        this.stylecodeDirtyFlag = true;
    }

    public String getStyleCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStyleCode();
        }
        return this.stylecode;
    }

    public boolean isStyleCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStyleCodeDirty();
        }
        return this.stylecodeDirtyFlag;
    }

    public void resetStyleCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStyleCode();
            return;
        }
        this.stylecodeDirtyFlag = false;
        this.stylecode = null;
    }

    public void setTemplCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.templcode = string;
        this.templcodeDirtyFlag = true;
    }

    public String getTemplCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplCode();
        }
        return this.templcode;
    }

    public boolean isTemplCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplCodeDirty();
        }
        return this.templcodeDirtyFlag;
    }

    public void resetTemplCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplCode();
            return;
        }
        this.templcodeDirtyFlag = false;
        this.templcode = null;
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
        PSPFQuickTemplBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSPFQuickTemplBase pSPFQuickTemplBase) {
        pSPFQuickTemplBase.resetCreateDate();
        pSPFQuickTemplBase.resetCreateMan();
        pSPFQuickTemplBase.resetMemo();
        pSPFQuickTemplBase.resetPSPFId();
        pSPFQuickTemplBase.resetPSPFName();
        pSPFQuickTemplBase.resetPSPFQuickTemplId();
        pSPFQuickTemplBase.resetPSPFQuickTemplName();
        pSPFQuickTemplBase.resetStyleCode();
        pSPFQuickTemplBase.resetTemplCode();
        pSPFQuickTemplBase.resetUpdateDate();
        pSPFQuickTemplBase.resetUpdateMan();
        pSPFQuickTemplBase.resetValidFlag();
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
        if (!bl || this.isPSPFIdDirty()) {
            hashMap.put(FIELD_PSPFID, this.getPSPFId());
        }
        if (!bl || this.isPSPFNameDirty()) {
            hashMap.put(FIELD_PSPFNAME, this.getPSPFName());
        }
        if (!bl || this.isPSPFQuickTemplIdDirty()) {
            hashMap.put(FIELD_PSPFQUICKTEMPLID, this.getPSPFQuickTemplId());
        }
        if (!bl || this.isPSPFQuickTemplNameDirty()) {
            hashMap.put(FIELD_PSPFQUICKTEMPLNAME, this.getPSPFQuickTemplName());
        }
        if (!bl || this.isStyleCodeDirty()) {
            hashMap.put(FIELD_STYLECODE, this.getStyleCode());
        }
        if (!bl || this.isTemplCodeDirty()) {
            hashMap.put(FIELD_TEMPLCODE, this.getTemplCode());
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
        return PSPFQuickTemplBase.get(this, n);
    }

    private static Object get(PSPFQuickTemplBase pSPFQuickTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFQuickTemplBase.getCreateDate();
            }
            case 1: {
                return pSPFQuickTemplBase.getCreateMan();
            }
            case 2: {
                return pSPFQuickTemplBase.getMemo();
            }
            case 3: {
                return pSPFQuickTemplBase.getPSPFId();
            }
            case 4: {
                return pSPFQuickTemplBase.getPSPFName();
            }
            case 5: {
                return pSPFQuickTemplBase.getPSPFQuickTemplId();
            }
            case 6: {
                return pSPFQuickTemplBase.getPSPFQuickTemplName();
            }
            case 7: {
                return pSPFQuickTemplBase.getStyleCode();
            }
            case 8: {
                return pSPFQuickTemplBase.getTemplCode();
            }
            case 9: {
                return pSPFQuickTemplBase.getUpdateDate();
            }
            case 10: {
                return pSPFQuickTemplBase.getUpdateMan();
            }
            case 11: {
                return pSPFQuickTemplBase.getValidFlag();
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
        PSPFQuickTemplBase.set(this, n, object);
    }

    private static void set(PSPFQuickTemplBase pSPFQuickTemplBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSPFQuickTemplBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSPFQuickTemplBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSPFQuickTemplBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSPFQuickTemplBase.setPSPFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSPFQuickTemplBase.setPSPFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSPFQuickTemplBase.setPSPFQuickTemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSPFQuickTemplBase.setPSPFQuickTemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSPFQuickTemplBase.setStyleCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSPFQuickTemplBase.setTemplCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSPFQuickTemplBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 10: {
                pSPFQuickTemplBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSPFQuickTemplBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSPFQuickTemplBase.isNull(this, n);
    }

    private static boolean isNull(PSPFQuickTemplBase pSPFQuickTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFQuickTemplBase.getCreateDate() == null;
            }
            case 1: {
                return pSPFQuickTemplBase.getCreateMan() == null;
            }
            case 2: {
                return pSPFQuickTemplBase.getMemo() == null;
            }
            case 3: {
                return pSPFQuickTemplBase.getPSPFId() == null;
            }
            case 4: {
                return pSPFQuickTemplBase.getPSPFName() == null;
            }
            case 5: {
                return pSPFQuickTemplBase.getPSPFQuickTemplId() == null;
            }
            case 6: {
                return pSPFQuickTemplBase.getPSPFQuickTemplName() == null;
            }
            case 7: {
                return pSPFQuickTemplBase.getStyleCode() == null;
            }
            case 8: {
                return pSPFQuickTemplBase.getTemplCode() == null;
            }
            case 9: {
                return pSPFQuickTemplBase.getUpdateDate() == null;
            }
            case 10: {
                return pSPFQuickTemplBase.getUpdateMan() == null;
            }
            case 11: {
                return pSPFQuickTemplBase.getValidFlag() == null;
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
        return PSPFQuickTemplBase.contains(this, n);
    }

    private static boolean contains(PSPFQuickTemplBase pSPFQuickTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFQuickTemplBase.isCreateDateDirty();
            }
            case 1: {
                return pSPFQuickTemplBase.isCreateManDirty();
            }
            case 2: {
                return pSPFQuickTemplBase.isMemoDirty();
            }
            case 3: {
                return pSPFQuickTemplBase.isPSPFIdDirty();
            }
            case 4: {
                return pSPFQuickTemplBase.isPSPFNameDirty();
            }
            case 5: {
                return pSPFQuickTemplBase.isPSPFQuickTemplIdDirty();
            }
            case 6: {
                return pSPFQuickTemplBase.isPSPFQuickTemplNameDirty();
            }
            case 7: {
                return pSPFQuickTemplBase.isStyleCodeDirty();
            }
            case 8: {
                return pSPFQuickTemplBase.isTemplCodeDirty();
            }
            case 9: {
                return pSPFQuickTemplBase.isUpdateDateDirty();
            }
            case 10: {
                return pSPFQuickTemplBase.isUpdateManDirty();
            }
            case 11: {
                return pSPFQuickTemplBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSPFQuickTemplBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSPFQuickTemplBase pSPFQuickTemplBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSPFQuickTemplBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSPFQuickTemplBase.getJSONValue((Object)pSPFQuickTemplBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSPFQuickTemplBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSPFQuickTemplBase.getJSONValue((Object)pSPFQuickTemplBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSPFQuickTemplBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSPFQuickTemplBase.getJSONValue((Object)pSPFQuickTemplBase.getMemo()), (boolean)false);
        }
        if (bl || pSPFQuickTemplBase.getPSPFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfid", (Object)PSPFQuickTemplBase.getJSONValue((Object)pSPFQuickTemplBase.getPSPFId()), (boolean)false);
        }
        if (bl || pSPFQuickTemplBase.getPSPFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfname", (Object)PSPFQuickTemplBase.getJSONValue((Object)pSPFQuickTemplBase.getPSPFName()), (boolean)false);
        }
        if (bl || pSPFQuickTemplBase.getPSPFQuickTemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfquicktemplid", (Object)PSPFQuickTemplBase.getJSONValue((Object)pSPFQuickTemplBase.getPSPFQuickTemplId()), (boolean)false);
        }
        if (bl || pSPFQuickTemplBase.getPSPFQuickTemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfquicktemplname", (Object)PSPFQuickTemplBase.getJSONValue((Object)pSPFQuickTemplBase.getPSPFQuickTemplName()), (boolean)false);
        }
        if (bl || pSPFQuickTemplBase.getStyleCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"stylecode", (Object)PSPFQuickTemplBase.getJSONValue((Object)pSPFQuickTemplBase.getStyleCode()), (boolean)false);
        }
        if (bl || pSPFQuickTemplBase.getTemplCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode", (Object)PSPFQuickTemplBase.getJSONValue((Object)pSPFQuickTemplBase.getTemplCode()), (boolean)false);
        }
        if (bl || pSPFQuickTemplBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSPFQuickTemplBase.getJSONValue((Object)pSPFQuickTemplBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSPFQuickTemplBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSPFQuickTemplBase.getJSONValue((Object)pSPFQuickTemplBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSPFQuickTemplBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSPFQuickTemplBase.getJSONValue((Object)pSPFQuickTemplBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSPFQuickTemplBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSPFQuickTemplBase pSPFQuickTemplBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSPFQuickTemplBase.getCreateDate() != null) {
            object = pSPFQuickTemplBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPFQuickTemplBase.getCreateMan() != null) {
            object = pSPFQuickTemplBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSPFQuickTemplBase.getMemo() != null) {
            object = pSPFQuickTemplBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSPFQuickTemplBase.getPSPFId() != null) {
            object = pSPFQuickTemplBase.getPSPFId();
            xmlNode.setAttribute(FIELD_PSPFID, object == null ? "" : (String)object);
        }
        if (bl || pSPFQuickTemplBase.getPSPFName() != null) {
            object = pSPFQuickTemplBase.getPSPFName();
            xmlNode.setAttribute(FIELD_PSPFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFQuickTemplBase.getPSPFQuickTemplId() != null) {
            object = pSPFQuickTemplBase.getPSPFQuickTemplId();
            xmlNode.setAttribute(FIELD_PSPFQUICKTEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSPFQuickTemplBase.getPSPFQuickTemplName() != null) {
            object = pSPFQuickTemplBase.getPSPFQuickTemplName();
            xmlNode.setAttribute(FIELD_PSPFQUICKTEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFQuickTemplBase.getStyleCode() != null) {
            object = pSPFQuickTemplBase.getStyleCode();
            xmlNode.setAttribute(FIELD_STYLECODE, object == null ? "" : (String)object);
        }
        if (bl || pSPFQuickTemplBase.getTemplCode() != null) {
            object = pSPFQuickTemplBase.getTemplCode();
            xmlNode.setAttribute(FIELD_TEMPLCODE, object == null ? "" : (String)object);
        }
        if (bl || pSPFQuickTemplBase.getUpdateDate() != null) {
            object = pSPFQuickTemplBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPFQuickTemplBase.getUpdateMan() != null) {
            object = pSPFQuickTemplBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSPFQuickTemplBase.getValidFlag() != null) {
            object = pSPFQuickTemplBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSPFQuickTemplBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSPFQuickTemplBase pSPFQuickTemplBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSPFQuickTemplBase.isCreateDateDirty() && (bl || pSPFQuickTemplBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSPFQuickTemplBase.getCreateDate());
        }
        if (pSPFQuickTemplBase.isCreateManDirty() && (bl || pSPFQuickTemplBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSPFQuickTemplBase.getCreateMan());
        }
        if (pSPFQuickTemplBase.isMemoDirty() && (bl || pSPFQuickTemplBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSPFQuickTemplBase.getMemo());
        }
        if (pSPFQuickTemplBase.isPSPFIdDirty() && (bl || pSPFQuickTemplBase.getPSPFId() != null)) {
            iDataObject.set(FIELD_PSPFID, (Object)pSPFQuickTemplBase.getPSPFId());
        }
        if (pSPFQuickTemplBase.isPSPFNameDirty() && (bl || pSPFQuickTemplBase.getPSPFName() != null)) {
            iDataObject.set(FIELD_PSPFNAME, (Object)pSPFQuickTemplBase.getPSPFName());
        }
        if (pSPFQuickTemplBase.isPSPFQuickTemplIdDirty() && (bl || pSPFQuickTemplBase.getPSPFQuickTemplId() != null)) {
            iDataObject.set(FIELD_PSPFQUICKTEMPLID, (Object)pSPFQuickTemplBase.getPSPFQuickTemplId());
        }
        if (pSPFQuickTemplBase.isPSPFQuickTemplNameDirty() && (bl || pSPFQuickTemplBase.getPSPFQuickTemplName() != null)) {
            iDataObject.set(FIELD_PSPFQUICKTEMPLNAME, (Object)pSPFQuickTemplBase.getPSPFQuickTemplName());
        }
        if (pSPFQuickTemplBase.isStyleCodeDirty() && (bl || pSPFQuickTemplBase.getStyleCode() != null)) {
            iDataObject.set(FIELD_STYLECODE, (Object)pSPFQuickTemplBase.getStyleCode());
        }
        if (pSPFQuickTemplBase.isTemplCodeDirty() && (bl || pSPFQuickTemplBase.getTemplCode() != null)) {
            iDataObject.set(FIELD_TEMPLCODE, (Object)pSPFQuickTemplBase.getTemplCode());
        }
        if (pSPFQuickTemplBase.isUpdateDateDirty() && (bl || pSPFQuickTemplBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSPFQuickTemplBase.getUpdateDate());
        }
        if (pSPFQuickTemplBase.isUpdateManDirty() && (bl || pSPFQuickTemplBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSPFQuickTemplBase.getUpdateMan());
        }
        if (pSPFQuickTemplBase.isValidFlagDirty() && (bl || pSPFQuickTemplBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSPFQuickTemplBase.getValidFlag());
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
        return PSPFQuickTemplBase.remove(this, n);
    }

    private static boolean remove(PSPFQuickTemplBase pSPFQuickTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSPFQuickTemplBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSPFQuickTemplBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSPFQuickTemplBase.resetMemo();
                return true;
            }
            case 3: {
                pSPFQuickTemplBase.resetPSPFId();
                return true;
            }
            case 4: {
                pSPFQuickTemplBase.resetPSPFName();
                return true;
            }
            case 5: {
                pSPFQuickTemplBase.resetPSPFQuickTemplId();
                return true;
            }
            case 6: {
                pSPFQuickTemplBase.resetPSPFQuickTemplName();
                return true;
            }
            case 7: {
                pSPFQuickTemplBase.resetStyleCode();
                return true;
            }
            case 8: {
                pSPFQuickTemplBase.resetTemplCode();
                return true;
            }
            case 9: {
                pSPFQuickTemplBase.resetUpdateDate();
                return true;
            }
            case 10: {
                pSPFQuickTemplBase.resetUpdateMan();
                return true;
            }
            case 11: {
                pSPFQuickTemplBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSPF getPSPF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPF();
        }
        if (this.getPSPFId() == null) {
            return null;
        }
        Integer n = this.objPSPFLock;
        synchronized (n) {
            if (this.pspf != null && DataTypeHelper.compare((int)25, (Object)this.getPSPFId(), (Object)this.pspf.getPSPFId()) != 0L) {
                this.pspf = null;
            }
            if (this.pspf == null) {
                PSPF pSPF = new PSPF();
                pSPF.setPSPFId(this.getPSPFId());
                PSPFService pSPFService = (PSPFService)ServiceGlobal.getService(PSPFService.class, (SessionFactory)this.getSessionFactory());
                pSPFService.autoGet((IEntity)pSPF);
                this.pspf = pSPF;
            }
            return this.pspf;
        }
    }

    private PSPFQuickTemplBase getProxyEntity() {
        return this.proxyPSPFQuickTemplBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSPFQuickTemplBase = null;
        if (iDataObject != null && iDataObject instanceof PSPFQuickTemplBase) {
            this.proxyPSPFQuickTemplBase = (PSPFQuickTemplBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFQuickTemplService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSPFID, 3);
        fieldIndexMap.put(FIELD_PSPFNAME, 4);
        fieldIndexMap.put(FIELD_PSPFQUICKTEMPLID, 5);
        fieldIndexMap.put(FIELD_PSPFQUICKTEMPLNAME, 6);
        fieldIndexMap.put(FIELD_STYLECODE, 7);
        fieldIndexMap.put(FIELD_TEMPLCODE, 8);
        fieldIndexMap.put(FIELD_UPDATEDATE, 9);
        fieldIndexMap.put(FIELD_UPDATEMAN, 10);
        fieldIndexMap.put(FIELD_VALIDFLAG, 11);
    }
}

