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
package net.ibizsys.pscore.srv.devcenter.entity;

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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCCodeSnippet;
import net.ibizsys.pscore.srv.devcenter.service.PSDCCodeSnippetService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCCodeSnippetRefBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCCodeSnippetRefBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDCCODESNIPPETID = "PSDCCODESNIPPETID";
    public static final String FIELD_PSDCCODESNIPPETNAME = "PSDCCODESNIPPETNAME";
    public static final String FIELD_PSDCCODESNIPPETREFID = "PSDCCODESNIPPETREFID";
    public static final String FIELD_PSDCCODESNIPPETREFNAME = "PSDCCODESNIPPETREFNAME";
    public static final String FIELD_REFPSDCCODESNIPPETID = "REFPSDCCODESNIPPETID";
    public static final String FIELD_REFPSDCCODESNIPPETNAME = "REFPSDCCODESNIPPETNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSDCCODESNIPPETID = 3;
    private static final int INDEX_PSDCCODESNIPPETNAME = 4;
    private static final int INDEX_PSDCCODESNIPPETREFID = 5;
    private static final int INDEX_PSDCCODESNIPPETREFNAME = 6;
    private static final int INDEX_REFPSDCCODESNIPPETID = 7;
    private static final int INDEX_REFPSDCCODESNIPPETNAME = 8;
    private static final int INDEX_UPDATEDATE = 9;
    private static final int INDEX_UPDATEMAN = 10;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCCodeSnippetRefBase proxyPSDCCodeSnippetRefBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdccodesnippetidDirtyFlag = false;
    private boolean psdccodesnippetnameDirtyFlag = false;
    private boolean psdccodesnippetrefidDirtyFlag = false;
    private boolean psdccodesnippetrefnameDirtyFlag = false;
    private boolean refpsdccodesnippetidDirtyFlag = false;
    private boolean refpsdccodesnippetnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psdccodesnippetid")
    private String psdccodesnippetid;
    @Column(name="psdccodesnippetname")
    private String psdccodesnippetname;
    @Column(name="psdccodesnippetrefid")
    private String psdccodesnippetrefid;
    @Column(name="psdccodesnippetrefname")
    private String psdccodesnippetrefname;
    @Column(name="refpsdccodesnippetid")
    private String refpsdccodesnippetid;
    @Column(name="refpsdccodesnippetname")
    private String refpsdccodesnippetname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDCCodeSnippetLock = new Integer(1);
    private PSDCCodeSnippet psdccodesnippet = null;
    private Integer objRefPSDCCodeSnippetLock = new Integer(1);
    private PSDCCodeSnippet refpsdccodesnippet = null;

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

    public void setPSDCCodeSnippetId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCCodeSnippetId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdccodesnippetid = string;
        this.psdccodesnippetidDirtyFlag = true;
    }

    public String getPSDCCodeSnippetId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCCodeSnippetId();
        }
        return this.psdccodesnippetid;
    }

    public boolean isPSDCCodeSnippetIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCCodeSnippetIdDirty();
        }
        return this.psdccodesnippetidDirtyFlag;
    }

    public void resetPSDCCodeSnippetId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCCodeSnippetId();
            return;
        }
        this.psdccodesnippetidDirtyFlag = false;
        this.psdccodesnippetid = null;
    }

    public void setPSDCCodeSnippetName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCCodeSnippetName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdccodesnippetname = string;
        this.psdccodesnippetnameDirtyFlag = true;
    }

    public String getPSDCCodeSnippetName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCCodeSnippetName();
        }
        return this.psdccodesnippetname;
    }

    public boolean isPSDCCodeSnippetNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCCodeSnippetNameDirty();
        }
        return this.psdccodesnippetnameDirtyFlag;
    }

    public void resetPSDCCodeSnippetName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCCodeSnippetName();
            return;
        }
        this.psdccodesnippetnameDirtyFlag = false;
        this.psdccodesnippetname = null;
    }

    public void setPSDCCodeSnippetRefId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCCodeSnippetRefId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdccodesnippetrefid = string;
        this.psdccodesnippetrefidDirtyFlag = true;
    }

    public String getPSDCCodeSnippetRefId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCCodeSnippetRefId();
        }
        return this.psdccodesnippetrefid;
    }

    public boolean isPSDCCodeSnippetRefIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCCodeSnippetRefIdDirty();
        }
        return this.psdccodesnippetrefidDirtyFlag;
    }

    public void resetPSDCCodeSnippetRefId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCCodeSnippetRefId();
            return;
        }
        this.psdccodesnippetrefidDirtyFlag = false;
        this.psdccodesnippetrefid = null;
    }

    public void setPSDCCodeSnippetRefName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCCodeSnippetRefName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdccodesnippetrefname = string;
        this.psdccodesnippetrefnameDirtyFlag = true;
    }

    public String getPSDCCodeSnippetRefName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCCodeSnippetRefName();
        }
        return this.psdccodesnippetrefname;
    }

    public boolean isPSDCCodeSnippetRefNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCCodeSnippetRefNameDirty();
        }
        return this.psdccodesnippetrefnameDirtyFlag;
    }

    public void resetPSDCCodeSnippetRefName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCCodeSnippetRefName();
            return;
        }
        this.psdccodesnippetrefnameDirtyFlag = false;
        this.psdccodesnippetrefname = null;
    }

    public void setRefPSDCCodeSnippetId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSDCCodeSnippetId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpsdccodesnippetid = string;
        this.refpsdccodesnippetidDirtyFlag = true;
    }

    public String getRefPSDCCodeSnippetId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDCCodeSnippetId();
        }
        return this.refpsdccodesnippetid;
    }

    public boolean isRefPSDCCodeSnippetIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSDCCodeSnippetIdDirty();
        }
        return this.refpsdccodesnippetidDirtyFlag;
    }

    public void resetRefPSDCCodeSnippetId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSDCCodeSnippetId();
            return;
        }
        this.refpsdccodesnippetidDirtyFlag = false;
        this.refpsdccodesnippetid = null;
    }

    public void setRefPSDCCodeSnippetName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSDCCodeSnippetName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpsdccodesnippetname = string;
        this.refpsdccodesnippetnameDirtyFlag = true;
    }

    public String getRefPSDCCodeSnippetName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDCCodeSnippetName();
        }
        return this.refpsdccodesnippetname;
    }

    public boolean isRefPSDCCodeSnippetNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSDCCodeSnippetNameDirty();
        }
        return this.refpsdccodesnippetnameDirtyFlag;
    }

    public void resetRefPSDCCodeSnippetName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSDCCodeSnippetName();
            return;
        }
        this.refpsdccodesnippetnameDirtyFlag = false;
        this.refpsdccodesnippetname = null;
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
        PSDCCodeSnippetRefBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCCodeSnippetRefBase pSDCCodeSnippetRefBase) {
        pSDCCodeSnippetRefBase.resetCreateDate();
        pSDCCodeSnippetRefBase.resetCreateMan();
        pSDCCodeSnippetRefBase.resetMemo();
        pSDCCodeSnippetRefBase.resetPSDCCodeSnippetId();
        pSDCCodeSnippetRefBase.resetPSDCCodeSnippetName();
        pSDCCodeSnippetRefBase.resetPSDCCodeSnippetRefId();
        pSDCCodeSnippetRefBase.resetPSDCCodeSnippetRefName();
        pSDCCodeSnippetRefBase.resetRefPSDCCodeSnippetId();
        pSDCCodeSnippetRefBase.resetRefPSDCCodeSnippetName();
        pSDCCodeSnippetRefBase.resetUpdateDate();
        pSDCCodeSnippetRefBase.resetUpdateMan();
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
        if (!bl || this.isPSDCCodeSnippetIdDirty()) {
            hashMap.put(FIELD_PSDCCODESNIPPETID, this.getPSDCCodeSnippetId());
        }
        if (!bl || this.isPSDCCodeSnippetNameDirty()) {
            hashMap.put(FIELD_PSDCCODESNIPPETNAME, this.getPSDCCodeSnippetName());
        }
        if (!bl || this.isPSDCCodeSnippetRefIdDirty()) {
            hashMap.put(FIELD_PSDCCODESNIPPETREFID, this.getPSDCCodeSnippetRefId());
        }
        if (!bl || this.isPSDCCodeSnippetRefNameDirty()) {
            hashMap.put(FIELD_PSDCCODESNIPPETREFNAME, this.getPSDCCodeSnippetRefName());
        }
        if (!bl || this.isRefPSDCCodeSnippetIdDirty()) {
            hashMap.put(FIELD_REFPSDCCODESNIPPETID, this.getRefPSDCCodeSnippetId());
        }
        if (!bl || this.isRefPSDCCodeSnippetNameDirty()) {
            hashMap.put(FIELD_REFPSDCCODESNIPPETNAME, this.getRefPSDCCodeSnippetName());
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
        return PSDCCodeSnippetRefBase.get(this, n);
    }

    private static Object get(PSDCCodeSnippetRefBase pSDCCodeSnippetRefBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCCodeSnippetRefBase.getCreateDate();
            }
            case 1: {
                return pSDCCodeSnippetRefBase.getCreateMan();
            }
            case 2: {
                return pSDCCodeSnippetRefBase.getMemo();
            }
            case 3: {
                return pSDCCodeSnippetRefBase.getPSDCCodeSnippetId();
            }
            case 4: {
                return pSDCCodeSnippetRefBase.getPSDCCodeSnippetName();
            }
            case 5: {
                return pSDCCodeSnippetRefBase.getPSDCCodeSnippetRefId();
            }
            case 6: {
                return pSDCCodeSnippetRefBase.getPSDCCodeSnippetRefName();
            }
            case 7: {
                return pSDCCodeSnippetRefBase.getRefPSDCCodeSnippetId();
            }
            case 8: {
                return pSDCCodeSnippetRefBase.getRefPSDCCodeSnippetName();
            }
            case 9: {
                return pSDCCodeSnippetRefBase.getUpdateDate();
            }
            case 10: {
                return pSDCCodeSnippetRefBase.getUpdateMan();
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
        PSDCCodeSnippetRefBase.set(this, n, object);
    }

    private static void set(PSDCCodeSnippetRefBase pSDCCodeSnippetRefBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCCodeSnippetRefBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDCCodeSnippetRefBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDCCodeSnippetRefBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDCCodeSnippetRefBase.setPSDCCodeSnippetId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDCCodeSnippetRefBase.setPSDCCodeSnippetName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDCCodeSnippetRefBase.setPSDCCodeSnippetRefId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDCCodeSnippetRefBase.setPSDCCodeSnippetRefName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDCCodeSnippetRefBase.setRefPSDCCodeSnippetId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDCCodeSnippetRefBase.setRefPSDCCodeSnippetName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDCCodeSnippetRefBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 10: {
                pSDCCodeSnippetRefBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDCCodeSnippetRefBase.isNull(this, n);
    }

    private static boolean isNull(PSDCCodeSnippetRefBase pSDCCodeSnippetRefBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCCodeSnippetRefBase.getCreateDate() == null;
            }
            case 1: {
                return pSDCCodeSnippetRefBase.getCreateMan() == null;
            }
            case 2: {
                return pSDCCodeSnippetRefBase.getMemo() == null;
            }
            case 3: {
                return pSDCCodeSnippetRefBase.getPSDCCodeSnippetId() == null;
            }
            case 4: {
                return pSDCCodeSnippetRefBase.getPSDCCodeSnippetName() == null;
            }
            case 5: {
                return pSDCCodeSnippetRefBase.getPSDCCodeSnippetRefId() == null;
            }
            case 6: {
                return pSDCCodeSnippetRefBase.getPSDCCodeSnippetRefName() == null;
            }
            case 7: {
                return pSDCCodeSnippetRefBase.getRefPSDCCodeSnippetId() == null;
            }
            case 8: {
                return pSDCCodeSnippetRefBase.getRefPSDCCodeSnippetName() == null;
            }
            case 9: {
                return pSDCCodeSnippetRefBase.getUpdateDate() == null;
            }
            case 10: {
                return pSDCCodeSnippetRefBase.getUpdateMan() == null;
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
        return PSDCCodeSnippetRefBase.contains(this, n);
    }

    private static boolean contains(PSDCCodeSnippetRefBase pSDCCodeSnippetRefBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCCodeSnippetRefBase.isCreateDateDirty();
            }
            case 1: {
                return pSDCCodeSnippetRefBase.isCreateManDirty();
            }
            case 2: {
                return pSDCCodeSnippetRefBase.isMemoDirty();
            }
            case 3: {
                return pSDCCodeSnippetRefBase.isPSDCCodeSnippetIdDirty();
            }
            case 4: {
                return pSDCCodeSnippetRefBase.isPSDCCodeSnippetNameDirty();
            }
            case 5: {
                return pSDCCodeSnippetRefBase.isPSDCCodeSnippetRefIdDirty();
            }
            case 6: {
                return pSDCCodeSnippetRefBase.isPSDCCodeSnippetRefNameDirty();
            }
            case 7: {
                return pSDCCodeSnippetRefBase.isRefPSDCCodeSnippetIdDirty();
            }
            case 8: {
                return pSDCCodeSnippetRefBase.isRefPSDCCodeSnippetNameDirty();
            }
            case 9: {
                return pSDCCodeSnippetRefBase.isUpdateDateDirty();
            }
            case 10: {
                return pSDCCodeSnippetRefBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCCodeSnippetRefBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCCodeSnippetRefBase pSDCCodeSnippetRefBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCCodeSnippetRefBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCCodeSnippetRefBase.getJSONValue((Object)pSDCCodeSnippetRefBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCCodeSnippetRefBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCCodeSnippetRefBase.getJSONValue((Object)pSDCCodeSnippetRefBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCCodeSnippetRefBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDCCodeSnippetRefBase.getJSONValue((Object)pSDCCodeSnippetRefBase.getMemo()), (boolean)false);
        }
        if (bl || pSDCCodeSnippetRefBase.getPSDCCodeSnippetId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdccodesnippetid", (Object)PSDCCodeSnippetRefBase.getJSONValue((Object)pSDCCodeSnippetRefBase.getPSDCCodeSnippetId()), (boolean)false);
        }
        if (bl || pSDCCodeSnippetRefBase.getPSDCCodeSnippetName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdccodesnippetname", (Object)PSDCCodeSnippetRefBase.getJSONValue((Object)pSDCCodeSnippetRefBase.getPSDCCodeSnippetName()), (boolean)false);
        }
        if (bl || pSDCCodeSnippetRefBase.getPSDCCodeSnippetRefId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdccodesnippetrefid", (Object)PSDCCodeSnippetRefBase.getJSONValue((Object)pSDCCodeSnippetRefBase.getPSDCCodeSnippetRefId()), (boolean)false);
        }
        if (bl || pSDCCodeSnippetRefBase.getPSDCCodeSnippetRefName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdccodesnippetrefname", (Object)PSDCCodeSnippetRefBase.getJSONValue((Object)pSDCCodeSnippetRefBase.getPSDCCodeSnippetRefName()), (boolean)false);
        }
        if (bl || pSDCCodeSnippetRefBase.getRefPSDCCodeSnippetId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdccodesnippetid", (Object)PSDCCodeSnippetRefBase.getJSONValue((Object)pSDCCodeSnippetRefBase.getRefPSDCCodeSnippetId()), (boolean)false);
        }
        if (bl || pSDCCodeSnippetRefBase.getRefPSDCCodeSnippetName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdccodesnippetname", (Object)PSDCCodeSnippetRefBase.getJSONValue((Object)pSDCCodeSnippetRefBase.getRefPSDCCodeSnippetName()), (boolean)false);
        }
        if (bl || pSDCCodeSnippetRefBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCCodeSnippetRefBase.getJSONValue((Object)pSDCCodeSnippetRefBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCCodeSnippetRefBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCCodeSnippetRefBase.getJSONValue((Object)pSDCCodeSnippetRefBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCCodeSnippetRefBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCCodeSnippetRefBase pSDCCodeSnippetRefBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCCodeSnippetRefBase.getCreateDate() != null) {
            object = pSDCCodeSnippetRefBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCCodeSnippetRefBase.getCreateMan() != null) {
            object = pSDCCodeSnippetRefBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCCodeSnippetRefBase.getMemo() != null) {
            object = pSDCCodeSnippetRefBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDCCodeSnippetRefBase.getPSDCCodeSnippetId() != null) {
            object = pSDCCodeSnippetRefBase.getPSDCCodeSnippetId();
            xmlNode.setAttribute(FIELD_PSDCCODESNIPPETID, object == null ? "" : (String)object);
        }
        if (bl || pSDCCodeSnippetRefBase.getPSDCCodeSnippetName() != null) {
            object = pSDCCodeSnippetRefBase.getPSDCCodeSnippetName();
            xmlNode.setAttribute(FIELD_PSDCCODESNIPPETNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCCodeSnippetRefBase.getPSDCCodeSnippetRefId() != null) {
            object = pSDCCodeSnippetRefBase.getPSDCCodeSnippetRefId();
            xmlNode.setAttribute(FIELD_PSDCCODESNIPPETREFID, object == null ? "" : (String)object);
        }
        if (bl || pSDCCodeSnippetRefBase.getPSDCCodeSnippetRefName() != null) {
            object = pSDCCodeSnippetRefBase.getPSDCCodeSnippetRefName();
            xmlNode.setAttribute(FIELD_PSDCCODESNIPPETREFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCCodeSnippetRefBase.getRefPSDCCodeSnippetId() != null) {
            object = pSDCCodeSnippetRefBase.getRefPSDCCodeSnippetId();
            xmlNode.setAttribute(FIELD_REFPSDCCODESNIPPETID, object == null ? "" : (String)object);
        }
        if (bl || pSDCCodeSnippetRefBase.getRefPSDCCodeSnippetName() != null) {
            object = pSDCCodeSnippetRefBase.getRefPSDCCodeSnippetName();
            xmlNode.setAttribute(FIELD_REFPSDCCODESNIPPETNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCCodeSnippetRefBase.getUpdateDate() != null) {
            object = pSDCCodeSnippetRefBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCCodeSnippetRefBase.getUpdateMan() != null) {
            object = pSDCCodeSnippetRefBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCCodeSnippetRefBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCCodeSnippetRefBase pSDCCodeSnippetRefBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCCodeSnippetRefBase.isCreateDateDirty() && (bl || pSDCCodeSnippetRefBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCCodeSnippetRefBase.getCreateDate());
        }
        if (pSDCCodeSnippetRefBase.isCreateManDirty() && (bl || pSDCCodeSnippetRefBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCCodeSnippetRefBase.getCreateMan());
        }
        if (pSDCCodeSnippetRefBase.isMemoDirty() && (bl || pSDCCodeSnippetRefBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDCCodeSnippetRefBase.getMemo());
        }
        if (pSDCCodeSnippetRefBase.isPSDCCodeSnippetIdDirty() && (bl || pSDCCodeSnippetRefBase.getPSDCCodeSnippetId() != null)) {
            iDataObject.set(FIELD_PSDCCODESNIPPETID, (Object)pSDCCodeSnippetRefBase.getPSDCCodeSnippetId());
        }
        if (pSDCCodeSnippetRefBase.isPSDCCodeSnippetNameDirty() && (bl || pSDCCodeSnippetRefBase.getPSDCCodeSnippetName() != null)) {
            iDataObject.set(FIELD_PSDCCODESNIPPETNAME, (Object)pSDCCodeSnippetRefBase.getPSDCCodeSnippetName());
        }
        if (pSDCCodeSnippetRefBase.isPSDCCodeSnippetRefIdDirty() && (bl || pSDCCodeSnippetRefBase.getPSDCCodeSnippetRefId() != null)) {
            iDataObject.set(FIELD_PSDCCODESNIPPETREFID, (Object)pSDCCodeSnippetRefBase.getPSDCCodeSnippetRefId());
        }
        if (pSDCCodeSnippetRefBase.isPSDCCodeSnippetRefNameDirty() && (bl || pSDCCodeSnippetRefBase.getPSDCCodeSnippetRefName() != null)) {
            iDataObject.set(FIELD_PSDCCODESNIPPETREFNAME, (Object)pSDCCodeSnippetRefBase.getPSDCCodeSnippetRefName());
        }
        if (pSDCCodeSnippetRefBase.isRefPSDCCodeSnippetIdDirty() && (bl || pSDCCodeSnippetRefBase.getRefPSDCCodeSnippetId() != null)) {
            iDataObject.set(FIELD_REFPSDCCODESNIPPETID, (Object)pSDCCodeSnippetRefBase.getRefPSDCCodeSnippetId());
        }
        if (pSDCCodeSnippetRefBase.isRefPSDCCodeSnippetNameDirty() && (bl || pSDCCodeSnippetRefBase.getRefPSDCCodeSnippetName() != null)) {
            iDataObject.set(FIELD_REFPSDCCODESNIPPETNAME, (Object)pSDCCodeSnippetRefBase.getRefPSDCCodeSnippetName());
        }
        if (pSDCCodeSnippetRefBase.isUpdateDateDirty() && (bl || pSDCCodeSnippetRefBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCCodeSnippetRefBase.getUpdateDate());
        }
        if (pSDCCodeSnippetRefBase.isUpdateManDirty() && (bl || pSDCCodeSnippetRefBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCCodeSnippetRefBase.getUpdateMan());
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
        return PSDCCodeSnippetRefBase.remove(this, n);
    }

    private static boolean remove(PSDCCodeSnippetRefBase pSDCCodeSnippetRefBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCCodeSnippetRefBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDCCodeSnippetRefBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDCCodeSnippetRefBase.resetMemo();
                return true;
            }
            case 3: {
                pSDCCodeSnippetRefBase.resetPSDCCodeSnippetId();
                return true;
            }
            case 4: {
                pSDCCodeSnippetRefBase.resetPSDCCodeSnippetName();
                return true;
            }
            case 5: {
                pSDCCodeSnippetRefBase.resetPSDCCodeSnippetRefId();
                return true;
            }
            case 6: {
                pSDCCodeSnippetRefBase.resetPSDCCodeSnippetRefName();
                return true;
            }
            case 7: {
                pSDCCodeSnippetRefBase.resetRefPSDCCodeSnippetId();
                return true;
            }
            case 8: {
                pSDCCodeSnippetRefBase.resetRefPSDCCodeSnippetName();
                return true;
            }
            case 9: {
                pSDCCodeSnippetRefBase.resetUpdateDate();
                return true;
            }
            case 10: {
                pSDCCodeSnippetRefBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCCodeSnippet getPSDCCodeSnippet() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCCodeSnippet();
        }
        if (this.getPSDCCodeSnippetId() == null) {
            return null;
        }
        Integer n = this.objPSDCCodeSnippetLock;
        synchronized (n) {
            if (this.psdccodesnippet != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCCodeSnippetId(), (Object)this.psdccodesnippet.getPSDCCodeSnippetId()) != 0L) {
                this.psdccodesnippet = null;
            }
            if (this.psdccodesnippet == null) {
                PSDCCodeSnippet pSDCCodeSnippet = new PSDCCodeSnippet();
                pSDCCodeSnippet.setPSDCCodeSnippetId(this.getPSDCCodeSnippetId());
                PSDCCodeSnippetService pSDCCodeSnippetService = (PSDCCodeSnippetService)ServiceGlobal.getService(PSDCCodeSnippetService.class, (SessionFactory)this.getSessionFactory());
                pSDCCodeSnippetService.autoGet((IEntity)pSDCCodeSnippet);
                this.psdccodesnippet = pSDCCodeSnippet;
            }
            return this.psdccodesnippet;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCCodeSnippet getRefPSDCCodeSnippet() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDCCodeSnippet();
        }
        if (this.getRefPSDCCodeSnippetId() == null) {
            return null;
        }
        Integer n = this.objRefPSDCCodeSnippetLock;
        synchronized (n) {
            if (this.refpsdccodesnippet != null && DataTypeHelper.compare((int)25, (Object)this.getRefPSDCCodeSnippetId(), (Object)this.refpsdccodesnippet.getPSDCCodeSnippetId()) != 0L) {
                this.refpsdccodesnippet = null;
            }
            if (this.refpsdccodesnippet == null) {
                PSDCCodeSnippet pSDCCodeSnippet = new PSDCCodeSnippet();
                pSDCCodeSnippet.setPSDCCodeSnippetId(this.getRefPSDCCodeSnippetId());
                PSDCCodeSnippetService pSDCCodeSnippetService = (PSDCCodeSnippetService)ServiceGlobal.getService(PSDCCodeSnippetService.class, (SessionFactory)this.getSessionFactory());
                pSDCCodeSnippetService.autoGet((IEntity)pSDCCodeSnippet);
                this.refpsdccodesnippet = pSDCCodeSnippet;
            }
            return this.refpsdccodesnippet;
        }
    }

    private PSDCCodeSnippetRefBase getProxyEntity() {
        return this.proxyPSDCCodeSnippetRefBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCCodeSnippetRefBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCCodeSnippetRefBase) {
            this.proxyPSDCCodeSnippetRefBase = (PSDCCodeSnippetRefBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCCodeSnippetRefService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSDCCODESNIPPETID, 3);
        fieldIndexMap.put(FIELD_PSDCCODESNIPPETNAME, 4);
        fieldIndexMap.put(FIELD_PSDCCODESNIPPETREFID, 5);
        fieldIndexMap.put(FIELD_PSDCCODESNIPPETREFNAME, 6);
        fieldIndexMap.put(FIELD_REFPSDCCODESNIPPETID, 7);
        fieldIndexMap.put(FIELD_REFPSDCCODESNIPPETNAME, 8);
        fieldIndexMap.put(FIELD_UPDATEDATE, 9);
        fieldIndexMap.put(FIELD_UPDATEMAN, 10);
    }
}

