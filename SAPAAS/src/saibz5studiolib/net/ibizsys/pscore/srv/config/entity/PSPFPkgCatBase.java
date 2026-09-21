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

public abstract class PSPFPkgCatBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSPFPkgCatBase.class);
    public static final String FIELD_CATTAG = "CATTAG";
    public static final String FIELD_CATTAG2 = "CATTAG2";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSPFID = "PSPFID";
    public static final String FIELD_PSPFNAME = "PSPFNAME";
    public static final String FIELD_PSPFPKGCATID = "PSPFPKGCATID";
    public static final String FIELD_PSPFPKGCATNAME = "PSPFPKGCATNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CATTAG = 0;
    private static final int INDEX_CATTAG2 = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PSPFID = 5;
    private static final int INDEX_PSPFNAME = 6;
    private static final int INDEX_PSPFPKGCATID = 7;
    private static final int INDEX_PSPFPKGCATNAME = 8;
    private static final int INDEX_UPDATEDATE = 9;
    private static final int INDEX_UPDATEMAN = 10;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSPFPkgCatBase proxyPSPFPkgCatBase = null;
    private boolean cattagDirtyFlag = false;
    private boolean cattag2DirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pspfidDirtyFlag = false;
    private boolean pspfnameDirtyFlag = false;
    private boolean pspfpkgcatidDirtyFlag = false;
    private boolean pspfpkgcatnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="cattag")
    private String cattag;
    @Column(name="cattag2")
    private String cattag2;
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
    @Column(name="pspfpkgcatid")
    private String pspfpkgcatid;
    @Column(name="pspfpkgcatname")
    private String pspfpkgcatname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSPFLock = new Integer(1);
    private PSPF pspf = null;

    public void setCatTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCatTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cattag = string;
        this.cattagDirtyFlag = true;
    }

    public String getCatTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCatTag();
        }
        return this.cattag;
    }

    public boolean isCatTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCatTagDirty();
        }
        return this.cattagDirtyFlag;
    }

    public void resetCatTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCatTag();
            return;
        }
        this.cattagDirtyFlag = false;
        this.cattag = null;
    }

    public void setCatTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCatTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cattag2 = string;
        this.cattag2DirtyFlag = true;
    }

    public String getCatTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCatTag2();
        }
        return this.cattag2;
    }

    public boolean isCatTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCatTag2Dirty();
        }
        return this.cattag2DirtyFlag;
    }

    public void resetCatTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCatTag2();
            return;
        }
        this.cattag2DirtyFlag = false;
        this.cattag2 = null;
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

    public void setPSPFPkgCatId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFPkgCatId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfpkgcatid = string;
        this.pspfpkgcatidDirtyFlag = true;
    }

    public String getPSPFPkgCatId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFPkgCatId();
        }
        return this.pspfpkgcatid;
    }

    public boolean isPSPFPkgCatIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFPkgCatIdDirty();
        }
        return this.pspfpkgcatidDirtyFlag;
    }

    public void resetPSPFPkgCatId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFPkgCatId();
            return;
        }
        this.pspfpkgcatidDirtyFlag = false;
        this.pspfpkgcatid = null;
    }

    public void setPSPFPkgCatName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFPkgCatName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfpkgcatname = string;
        this.pspfpkgcatnameDirtyFlag = true;
    }

    public String getPSPFPkgCatName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFPkgCatName();
        }
        return this.pspfpkgcatname;
    }

    public boolean isPSPFPkgCatNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFPkgCatNameDirty();
        }
        return this.pspfpkgcatnameDirtyFlag;
    }

    public void resetPSPFPkgCatName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFPkgCatName();
            return;
        }
        this.pspfpkgcatnameDirtyFlag = false;
        this.pspfpkgcatname = null;
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
        PSPFPkgCatBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSPFPkgCatBase pSPFPkgCatBase) {
        pSPFPkgCatBase.resetCatTag();
        pSPFPkgCatBase.resetCatTag2();
        pSPFPkgCatBase.resetCreateDate();
        pSPFPkgCatBase.resetCreateMan();
        pSPFPkgCatBase.resetMemo();
        pSPFPkgCatBase.resetPSPFId();
        pSPFPkgCatBase.resetPSPFName();
        pSPFPkgCatBase.resetPSPFPkgCatId();
        pSPFPkgCatBase.resetPSPFPkgCatName();
        pSPFPkgCatBase.resetUpdateDate();
        pSPFPkgCatBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCatTagDirty()) {
            hashMap.put(FIELD_CATTAG, this.getCatTag());
        }
        if (!bl || this.isCatTag2Dirty()) {
            hashMap.put(FIELD_CATTAG2, this.getCatTag2());
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
        if (!bl || this.isPSPFIdDirty()) {
            hashMap.put(FIELD_PSPFID, this.getPSPFId());
        }
        if (!bl || this.isPSPFNameDirty()) {
            hashMap.put(FIELD_PSPFNAME, this.getPSPFName());
        }
        if (!bl || this.isPSPFPkgCatIdDirty()) {
            hashMap.put(FIELD_PSPFPKGCATID, this.getPSPFPkgCatId());
        }
        if (!bl || this.isPSPFPkgCatNameDirty()) {
            hashMap.put(FIELD_PSPFPKGCATNAME, this.getPSPFPkgCatName());
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
        return PSPFPkgCatBase.get(this, n);
    }

    private static Object get(PSPFPkgCatBase pSPFPkgCatBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFPkgCatBase.getCatTag();
            }
            case 1: {
                return pSPFPkgCatBase.getCatTag2();
            }
            case 2: {
                return pSPFPkgCatBase.getCreateDate();
            }
            case 3: {
                return pSPFPkgCatBase.getCreateMan();
            }
            case 4: {
                return pSPFPkgCatBase.getMemo();
            }
            case 5: {
                return pSPFPkgCatBase.getPSPFId();
            }
            case 6: {
                return pSPFPkgCatBase.getPSPFName();
            }
            case 7: {
                return pSPFPkgCatBase.getPSPFPkgCatId();
            }
            case 8: {
                return pSPFPkgCatBase.getPSPFPkgCatName();
            }
            case 9: {
                return pSPFPkgCatBase.getUpdateDate();
            }
            case 10: {
                return pSPFPkgCatBase.getUpdateMan();
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
        PSPFPkgCatBase.set(this, n, object);
    }

    private static void set(PSPFPkgCatBase pSPFPkgCatBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSPFPkgCatBase.setCatTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSPFPkgCatBase.setCatTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSPFPkgCatBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSPFPkgCatBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSPFPkgCatBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSPFPkgCatBase.setPSPFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSPFPkgCatBase.setPSPFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSPFPkgCatBase.setPSPFPkgCatId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSPFPkgCatBase.setPSPFPkgCatName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSPFPkgCatBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 10: {
                pSPFPkgCatBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSPFPkgCatBase.isNull(this, n);
    }

    private static boolean isNull(PSPFPkgCatBase pSPFPkgCatBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFPkgCatBase.getCatTag() == null;
            }
            case 1: {
                return pSPFPkgCatBase.getCatTag2() == null;
            }
            case 2: {
                return pSPFPkgCatBase.getCreateDate() == null;
            }
            case 3: {
                return pSPFPkgCatBase.getCreateMan() == null;
            }
            case 4: {
                return pSPFPkgCatBase.getMemo() == null;
            }
            case 5: {
                return pSPFPkgCatBase.getPSPFId() == null;
            }
            case 6: {
                return pSPFPkgCatBase.getPSPFName() == null;
            }
            case 7: {
                return pSPFPkgCatBase.getPSPFPkgCatId() == null;
            }
            case 8: {
                return pSPFPkgCatBase.getPSPFPkgCatName() == null;
            }
            case 9: {
                return pSPFPkgCatBase.getUpdateDate() == null;
            }
            case 10: {
                return pSPFPkgCatBase.getUpdateMan() == null;
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
        return PSPFPkgCatBase.contains(this, n);
    }

    private static boolean contains(PSPFPkgCatBase pSPFPkgCatBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFPkgCatBase.isCatTagDirty();
            }
            case 1: {
                return pSPFPkgCatBase.isCatTag2Dirty();
            }
            case 2: {
                return pSPFPkgCatBase.isCreateDateDirty();
            }
            case 3: {
                return pSPFPkgCatBase.isCreateManDirty();
            }
            case 4: {
                return pSPFPkgCatBase.isMemoDirty();
            }
            case 5: {
                return pSPFPkgCatBase.isPSPFIdDirty();
            }
            case 6: {
                return pSPFPkgCatBase.isPSPFNameDirty();
            }
            case 7: {
                return pSPFPkgCatBase.isPSPFPkgCatIdDirty();
            }
            case 8: {
                return pSPFPkgCatBase.isPSPFPkgCatNameDirty();
            }
            case 9: {
                return pSPFPkgCatBase.isUpdateDateDirty();
            }
            case 10: {
                return pSPFPkgCatBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSPFPkgCatBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSPFPkgCatBase pSPFPkgCatBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSPFPkgCatBase.getCatTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cattag", (Object)PSPFPkgCatBase.getJSONValue((Object)pSPFPkgCatBase.getCatTag()), (boolean)false);
        }
        if (bl || pSPFPkgCatBase.getCatTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cattag2", (Object)PSPFPkgCatBase.getJSONValue((Object)pSPFPkgCatBase.getCatTag2()), (boolean)false);
        }
        if (bl || pSPFPkgCatBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSPFPkgCatBase.getJSONValue((Object)pSPFPkgCatBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSPFPkgCatBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSPFPkgCatBase.getJSONValue((Object)pSPFPkgCatBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSPFPkgCatBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSPFPkgCatBase.getJSONValue((Object)pSPFPkgCatBase.getMemo()), (boolean)false);
        }
        if (bl || pSPFPkgCatBase.getPSPFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfid", (Object)PSPFPkgCatBase.getJSONValue((Object)pSPFPkgCatBase.getPSPFId()), (boolean)false);
        }
        if (bl || pSPFPkgCatBase.getPSPFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfname", (Object)PSPFPkgCatBase.getJSONValue((Object)pSPFPkgCatBase.getPSPFName()), (boolean)false);
        }
        if (bl || pSPFPkgCatBase.getPSPFPkgCatId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpkgcatid", (Object)PSPFPkgCatBase.getJSONValue((Object)pSPFPkgCatBase.getPSPFPkgCatId()), (boolean)false);
        }
        if (bl || pSPFPkgCatBase.getPSPFPkgCatName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpkgcatname", (Object)PSPFPkgCatBase.getJSONValue((Object)pSPFPkgCatBase.getPSPFPkgCatName()), (boolean)false);
        }
        if (bl || pSPFPkgCatBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSPFPkgCatBase.getJSONValue((Object)pSPFPkgCatBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSPFPkgCatBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSPFPkgCatBase.getJSONValue((Object)pSPFPkgCatBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSPFPkgCatBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSPFPkgCatBase pSPFPkgCatBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSPFPkgCatBase.getCatTag() != null) {
            object = pSPFPkgCatBase.getCatTag();
            xmlNode.setAttribute(FIELD_CATTAG, (String)(object == null ? "" : object));
        }
        if (bl || pSPFPkgCatBase.getCatTag2() != null) {
            object = pSPFPkgCatBase.getCatTag2();
            xmlNode.setAttribute(FIELD_CATTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSPFPkgCatBase.getCreateDate() != null) {
            object = pSPFPkgCatBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPFPkgCatBase.getCreateMan() != null) {
            object = pSPFPkgCatBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSPFPkgCatBase.getMemo() != null) {
            object = pSPFPkgCatBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSPFPkgCatBase.getPSPFId() != null) {
            object = pSPFPkgCatBase.getPSPFId();
            xmlNode.setAttribute(FIELD_PSPFID, object == null ? "" : (String)object);
        }
        if (bl || pSPFPkgCatBase.getPSPFName() != null) {
            object = pSPFPkgCatBase.getPSPFName();
            xmlNode.setAttribute(FIELD_PSPFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFPkgCatBase.getPSPFPkgCatId() != null) {
            object = pSPFPkgCatBase.getPSPFPkgCatId();
            xmlNode.setAttribute(FIELD_PSPFPKGCATID, object == null ? "" : (String)object);
        }
        if (bl || pSPFPkgCatBase.getPSPFPkgCatName() != null) {
            object = pSPFPkgCatBase.getPSPFPkgCatName();
            xmlNode.setAttribute(FIELD_PSPFPKGCATNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFPkgCatBase.getUpdateDate() != null) {
            object = pSPFPkgCatBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPFPkgCatBase.getUpdateMan() != null) {
            object = pSPFPkgCatBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSPFPkgCatBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSPFPkgCatBase pSPFPkgCatBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSPFPkgCatBase.isCatTagDirty() && (bl || pSPFPkgCatBase.getCatTag() != null)) {
            iDataObject.set(FIELD_CATTAG, (Object)pSPFPkgCatBase.getCatTag());
        }
        if (pSPFPkgCatBase.isCatTag2Dirty() && (bl || pSPFPkgCatBase.getCatTag2() != null)) {
            iDataObject.set(FIELD_CATTAG2, (Object)pSPFPkgCatBase.getCatTag2());
        }
        if (pSPFPkgCatBase.isCreateDateDirty() && (bl || pSPFPkgCatBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSPFPkgCatBase.getCreateDate());
        }
        if (pSPFPkgCatBase.isCreateManDirty() && (bl || pSPFPkgCatBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSPFPkgCatBase.getCreateMan());
        }
        if (pSPFPkgCatBase.isMemoDirty() && (bl || pSPFPkgCatBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSPFPkgCatBase.getMemo());
        }
        if (pSPFPkgCatBase.isPSPFIdDirty() && (bl || pSPFPkgCatBase.getPSPFId() != null)) {
            iDataObject.set(FIELD_PSPFID, (Object)pSPFPkgCatBase.getPSPFId());
        }
        if (pSPFPkgCatBase.isPSPFNameDirty() && (bl || pSPFPkgCatBase.getPSPFName() != null)) {
            iDataObject.set(FIELD_PSPFNAME, (Object)pSPFPkgCatBase.getPSPFName());
        }
        if (pSPFPkgCatBase.isPSPFPkgCatIdDirty() && (bl || pSPFPkgCatBase.getPSPFPkgCatId() != null)) {
            iDataObject.set(FIELD_PSPFPKGCATID, (Object)pSPFPkgCatBase.getPSPFPkgCatId());
        }
        if (pSPFPkgCatBase.isPSPFPkgCatNameDirty() && (bl || pSPFPkgCatBase.getPSPFPkgCatName() != null)) {
            iDataObject.set(FIELD_PSPFPKGCATNAME, (Object)pSPFPkgCatBase.getPSPFPkgCatName());
        }
        if (pSPFPkgCatBase.isUpdateDateDirty() && (bl || pSPFPkgCatBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSPFPkgCatBase.getUpdateDate());
        }
        if (pSPFPkgCatBase.isUpdateManDirty() && (bl || pSPFPkgCatBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSPFPkgCatBase.getUpdateMan());
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
        return PSPFPkgCatBase.remove(this, n);
    }

    private static boolean remove(PSPFPkgCatBase pSPFPkgCatBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSPFPkgCatBase.resetCatTag();
                return true;
            }
            case 1: {
                pSPFPkgCatBase.resetCatTag2();
                return true;
            }
            case 2: {
                pSPFPkgCatBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSPFPkgCatBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSPFPkgCatBase.resetMemo();
                return true;
            }
            case 5: {
                pSPFPkgCatBase.resetPSPFId();
                return true;
            }
            case 6: {
                pSPFPkgCatBase.resetPSPFName();
                return true;
            }
            case 7: {
                pSPFPkgCatBase.resetPSPFPkgCatId();
                return true;
            }
            case 8: {
                pSPFPkgCatBase.resetPSPFPkgCatName();
                return true;
            }
            case 9: {
                pSPFPkgCatBase.resetUpdateDate();
                return true;
            }
            case 10: {
                pSPFPkgCatBase.resetUpdateMan();
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

    private PSPFPkgCatBase getProxyEntity() {
        return this.proxyPSPFPkgCatBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSPFPkgCatBase = null;
        if (iDataObject != null && iDataObject instanceof PSPFPkgCatBase) {
            this.proxyPSPFPkgCatBase = (PSPFPkgCatBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFPkgCatService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CATTAG, 0);
        fieldIndexMap.put(FIELD_CATTAG2, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PSPFID, 5);
        fieldIndexMap.put(FIELD_PSPFNAME, 6);
        fieldIndexMap.put(FIELD_PSPFPKGCATID, 7);
        fieldIndexMap.put(FIELD_PSPFPKGCATNAME, 8);
        fieldIndexMap.put(FIELD_UPDATEDATE, 9);
        fieldIndexMap.put(FIELD_UPDATEMAN, 10);
    }
}

