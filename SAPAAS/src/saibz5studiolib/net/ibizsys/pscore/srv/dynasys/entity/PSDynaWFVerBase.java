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
package net.ibizsys.pscore.srv.dynasys.entity;

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
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaSys;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaWF;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaSysService;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaWFService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDynaWFVerBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDynaWFVerBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDYNASYSID = "PSDYNASYSID";
    public static final String FIELD_PSDYNASYSNAME = "PSDYNASYSNAME";
    public static final String FIELD_PSDYNAWFID = "PSDYNAWFID";
    public static final String FIELD_PSDYNAWFNAME = "PSDYNAWFNAME";
    public static final String FIELD_PSDYNAWFVERID = "PSDYNAWFVERID";
    public static final String FIELD_PSDYNAWFVERNAME = "PSDYNAWFVERNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSDYNASYSID = 3;
    private static final int INDEX_PSDYNASYSNAME = 4;
    private static final int INDEX_PSDYNAWFID = 5;
    private static final int INDEX_PSDYNAWFNAME = 6;
    private static final int INDEX_PSDYNAWFVERID = 7;
    private static final int INDEX_PSDYNAWFVERNAME = 8;
    private static final int INDEX_UPDATEDATE = 9;
    private static final int INDEX_UPDATEMAN = 10;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDynaWFVerBase proxyPSDynaWFVerBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdynasysidDirtyFlag = false;
    private boolean psdynasysnameDirtyFlag = false;
    private boolean psdynawfidDirtyFlag = false;
    private boolean psdynawfnameDirtyFlag = false;
    private boolean psdynawfveridDirtyFlag = false;
    private boolean psdynawfvernameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psdynasysid")
    private String psdynasysid;
    @Column(name="psdynasysname")
    private String psdynasysname;
    @Column(name="psdynawfid")
    private String psdynawfid;
    @Column(name="psdynawfname")
    private String psdynawfname;
    @Column(name="psdynawfverid")
    private String psdynawfverid;
    @Column(name="psdynawfvername")
    private String psdynawfvername;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDynaSysLock = new Integer(1);
    private PSDynaSys psdynasys = null;
    private Integer objPSDynaWFLock = new Integer(1);
    private PSDynaWF psdynawf = null;

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

    public void setPSDynaSysId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaSysId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynasysid = string;
        this.psdynasysidDirtyFlag = true;
    }

    public String getPSDynaSysId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaSysId();
        }
        return this.psdynasysid;
    }

    public boolean isPSDynaSysIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaSysIdDirty();
        }
        return this.psdynasysidDirtyFlag;
    }

    public void resetPSDynaSysId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaSysId();
            return;
        }
        this.psdynasysidDirtyFlag = false;
        this.psdynasysid = null;
    }

    public void setPSDynaSysName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaSysName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynasysname = string;
        this.psdynasysnameDirtyFlag = true;
    }

    public String getPSDynaSysName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaSysName();
        }
        return this.psdynasysname;
    }

    public boolean isPSDynaSysNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaSysNameDirty();
        }
        return this.psdynasysnameDirtyFlag;
    }

    public void resetPSDynaSysName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaSysName();
            return;
        }
        this.psdynasysnameDirtyFlag = false;
        this.psdynasysname = null;
    }

    public void setPSDynaWFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaWFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynawfid = string;
        this.psdynawfidDirtyFlag = true;
    }

    public String getPSDynaWFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaWFId();
        }
        return this.psdynawfid;
    }

    public boolean isPSDynaWFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaWFIdDirty();
        }
        return this.psdynawfidDirtyFlag;
    }

    public void resetPSDynaWFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaWFId();
            return;
        }
        this.psdynawfidDirtyFlag = false;
        this.psdynawfid = null;
    }

    public void setPSDynaWFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaWFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynawfname = string;
        this.psdynawfnameDirtyFlag = true;
    }

    public String getPSDynaWFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaWFName();
        }
        return this.psdynawfname;
    }

    public boolean isPSDynaWFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaWFNameDirty();
        }
        return this.psdynawfnameDirtyFlag;
    }

    public void resetPSDynaWFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaWFName();
            return;
        }
        this.psdynawfnameDirtyFlag = false;
        this.psdynawfname = null;
    }

    public void setPSDynaWFVerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaWFVerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynawfverid = string;
        this.psdynawfveridDirtyFlag = true;
    }

    public String getPSDynaWFVerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaWFVerId();
        }
        return this.psdynawfverid;
    }

    public boolean isPSDynaWFVerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaWFVerIdDirty();
        }
        return this.psdynawfveridDirtyFlag;
    }

    public void resetPSDynaWFVerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaWFVerId();
            return;
        }
        this.psdynawfveridDirtyFlag = false;
        this.psdynawfverid = null;
    }

    public void setPSDynaWFVerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaWFVerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynawfvername = string;
        this.psdynawfvernameDirtyFlag = true;
    }

    public String getPSDynaWFVerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaWFVerName();
        }
        return this.psdynawfvername;
    }

    public boolean isPSDynaWFVerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaWFVerNameDirty();
        }
        return this.psdynawfvernameDirtyFlag;
    }

    public void resetPSDynaWFVerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaWFVerName();
            return;
        }
        this.psdynawfvernameDirtyFlag = false;
        this.psdynawfvername = null;
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
        PSDynaWFVerBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDynaWFVerBase pSDynaWFVerBase) {
        pSDynaWFVerBase.resetCreateDate();
        pSDynaWFVerBase.resetCreateMan();
        pSDynaWFVerBase.resetMemo();
        pSDynaWFVerBase.resetPSDynaSysId();
        pSDynaWFVerBase.resetPSDynaSysName();
        pSDynaWFVerBase.resetPSDynaWFId();
        pSDynaWFVerBase.resetPSDynaWFName();
        pSDynaWFVerBase.resetPSDynaWFVerId();
        pSDynaWFVerBase.resetPSDynaWFVerName();
        pSDynaWFVerBase.resetUpdateDate();
        pSDynaWFVerBase.resetUpdateMan();
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
        if (!bl || this.isPSDynaSysIdDirty()) {
            hashMap.put(FIELD_PSDYNASYSID, this.getPSDynaSysId());
        }
        if (!bl || this.isPSDynaSysNameDirty()) {
            hashMap.put(FIELD_PSDYNASYSNAME, this.getPSDynaSysName());
        }
        if (!bl || this.isPSDynaWFIdDirty()) {
            hashMap.put(FIELD_PSDYNAWFID, this.getPSDynaWFId());
        }
        if (!bl || this.isPSDynaWFNameDirty()) {
            hashMap.put(FIELD_PSDYNAWFNAME, this.getPSDynaWFName());
        }
        if (!bl || this.isPSDynaWFVerIdDirty()) {
            hashMap.put(FIELD_PSDYNAWFVERID, this.getPSDynaWFVerId());
        }
        if (!bl || this.isPSDynaWFVerNameDirty()) {
            hashMap.put(FIELD_PSDYNAWFVERNAME, this.getPSDynaWFVerName());
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
        return PSDynaWFVerBase.get(this, n);
    }

    private static Object get(PSDynaWFVerBase pSDynaWFVerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDynaWFVerBase.getCreateDate();
            }
            case 1: {
                return pSDynaWFVerBase.getCreateMan();
            }
            case 2: {
                return pSDynaWFVerBase.getMemo();
            }
            case 3: {
                return pSDynaWFVerBase.getPSDynaSysId();
            }
            case 4: {
                return pSDynaWFVerBase.getPSDynaSysName();
            }
            case 5: {
                return pSDynaWFVerBase.getPSDynaWFId();
            }
            case 6: {
                return pSDynaWFVerBase.getPSDynaWFName();
            }
            case 7: {
                return pSDynaWFVerBase.getPSDynaWFVerId();
            }
            case 8: {
                return pSDynaWFVerBase.getPSDynaWFVerName();
            }
            case 9: {
                return pSDynaWFVerBase.getUpdateDate();
            }
            case 10: {
                return pSDynaWFVerBase.getUpdateMan();
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
        PSDynaWFVerBase.set(this, n, object);
    }

    private static void set(PSDynaWFVerBase pSDynaWFVerBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDynaWFVerBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDynaWFVerBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDynaWFVerBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDynaWFVerBase.setPSDynaSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDynaWFVerBase.setPSDynaSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDynaWFVerBase.setPSDynaWFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDynaWFVerBase.setPSDynaWFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDynaWFVerBase.setPSDynaWFVerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDynaWFVerBase.setPSDynaWFVerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDynaWFVerBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 10: {
                pSDynaWFVerBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDynaWFVerBase.isNull(this, n);
    }

    private static boolean isNull(PSDynaWFVerBase pSDynaWFVerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDynaWFVerBase.getCreateDate() == null;
            }
            case 1: {
                return pSDynaWFVerBase.getCreateMan() == null;
            }
            case 2: {
                return pSDynaWFVerBase.getMemo() == null;
            }
            case 3: {
                return pSDynaWFVerBase.getPSDynaSysId() == null;
            }
            case 4: {
                return pSDynaWFVerBase.getPSDynaSysName() == null;
            }
            case 5: {
                return pSDynaWFVerBase.getPSDynaWFId() == null;
            }
            case 6: {
                return pSDynaWFVerBase.getPSDynaWFName() == null;
            }
            case 7: {
                return pSDynaWFVerBase.getPSDynaWFVerId() == null;
            }
            case 8: {
                return pSDynaWFVerBase.getPSDynaWFVerName() == null;
            }
            case 9: {
                return pSDynaWFVerBase.getUpdateDate() == null;
            }
            case 10: {
                return pSDynaWFVerBase.getUpdateMan() == null;
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
        return PSDynaWFVerBase.contains(this, n);
    }

    private static boolean contains(PSDynaWFVerBase pSDynaWFVerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDynaWFVerBase.isCreateDateDirty();
            }
            case 1: {
                return pSDynaWFVerBase.isCreateManDirty();
            }
            case 2: {
                return pSDynaWFVerBase.isMemoDirty();
            }
            case 3: {
                return pSDynaWFVerBase.isPSDynaSysIdDirty();
            }
            case 4: {
                return pSDynaWFVerBase.isPSDynaSysNameDirty();
            }
            case 5: {
                return pSDynaWFVerBase.isPSDynaWFIdDirty();
            }
            case 6: {
                return pSDynaWFVerBase.isPSDynaWFNameDirty();
            }
            case 7: {
                return pSDynaWFVerBase.isPSDynaWFVerIdDirty();
            }
            case 8: {
                return pSDynaWFVerBase.isPSDynaWFVerNameDirty();
            }
            case 9: {
                return pSDynaWFVerBase.isUpdateDateDirty();
            }
            case 10: {
                return pSDynaWFVerBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDynaWFVerBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDynaWFVerBase pSDynaWFVerBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDynaWFVerBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDynaWFVerBase.getJSONValue((Object)pSDynaWFVerBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDynaWFVerBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDynaWFVerBase.getJSONValue((Object)pSDynaWFVerBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDynaWFVerBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDynaWFVerBase.getJSONValue((Object)pSDynaWFVerBase.getMemo()), (boolean)false);
        }
        if (bl || pSDynaWFVerBase.getPSDynaSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynasysid", (Object)PSDynaWFVerBase.getJSONValue((Object)pSDynaWFVerBase.getPSDynaSysId()), (boolean)false);
        }
        if (bl || pSDynaWFVerBase.getPSDynaSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynasysname", (Object)PSDynaWFVerBase.getJSONValue((Object)pSDynaWFVerBase.getPSDynaSysName()), (boolean)false);
        }
        if (bl || pSDynaWFVerBase.getPSDynaWFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynawfid", (Object)PSDynaWFVerBase.getJSONValue((Object)pSDynaWFVerBase.getPSDynaWFId()), (boolean)false);
        }
        if (bl || pSDynaWFVerBase.getPSDynaWFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynawfname", (Object)PSDynaWFVerBase.getJSONValue((Object)pSDynaWFVerBase.getPSDynaWFName()), (boolean)false);
        }
        if (bl || pSDynaWFVerBase.getPSDynaWFVerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynawfverid", (Object)PSDynaWFVerBase.getJSONValue((Object)pSDynaWFVerBase.getPSDynaWFVerId()), (boolean)false);
        }
        if (bl || pSDynaWFVerBase.getPSDynaWFVerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynawfvername", (Object)PSDynaWFVerBase.getJSONValue((Object)pSDynaWFVerBase.getPSDynaWFVerName()), (boolean)false);
        }
        if (bl || pSDynaWFVerBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDynaWFVerBase.getJSONValue((Object)pSDynaWFVerBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDynaWFVerBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDynaWFVerBase.getJSONValue((Object)pSDynaWFVerBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDynaWFVerBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDynaWFVerBase pSDynaWFVerBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDynaWFVerBase.getCreateDate() != null) {
            object = pSDynaWFVerBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDynaWFVerBase.getCreateMan() != null) {
            object = pSDynaWFVerBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDynaWFVerBase.getMemo() != null) {
            object = pSDynaWFVerBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDynaWFVerBase.getPSDynaSysId() != null) {
            object = pSDynaWFVerBase.getPSDynaSysId();
            xmlNode.setAttribute(FIELD_PSDYNASYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDynaWFVerBase.getPSDynaSysName() != null) {
            object = pSDynaWFVerBase.getPSDynaSysName();
            xmlNode.setAttribute(FIELD_PSDYNASYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDynaWFVerBase.getPSDynaWFId() != null) {
            object = pSDynaWFVerBase.getPSDynaWFId();
            xmlNode.setAttribute(FIELD_PSDYNAWFID, object == null ? "" : (String)object);
        }
        if (bl || pSDynaWFVerBase.getPSDynaWFName() != null) {
            object = pSDynaWFVerBase.getPSDynaWFName();
            xmlNode.setAttribute(FIELD_PSDYNAWFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDynaWFVerBase.getPSDynaWFVerId() != null) {
            object = pSDynaWFVerBase.getPSDynaWFVerId();
            xmlNode.setAttribute(FIELD_PSDYNAWFVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDynaWFVerBase.getPSDynaWFVerName() != null) {
            object = pSDynaWFVerBase.getPSDynaWFVerName();
            xmlNode.setAttribute(FIELD_PSDYNAWFVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDynaWFVerBase.getUpdateDate() != null) {
            object = pSDynaWFVerBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDynaWFVerBase.getUpdateMan() != null) {
            object = pSDynaWFVerBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDynaWFVerBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDynaWFVerBase pSDynaWFVerBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDynaWFVerBase.isCreateDateDirty() && (bl || pSDynaWFVerBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDynaWFVerBase.getCreateDate());
        }
        if (pSDynaWFVerBase.isCreateManDirty() && (bl || pSDynaWFVerBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDynaWFVerBase.getCreateMan());
        }
        if (pSDynaWFVerBase.isMemoDirty() && (bl || pSDynaWFVerBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDynaWFVerBase.getMemo());
        }
        if (pSDynaWFVerBase.isPSDynaSysIdDirty() && (bl || pSDynaWFVerBase.getPSDynaSysId() != null)) {
            iDataObject.set(FIELD_PSDYNASYSID, (Object)pSDynaWFVerBase.getPSDynaSysId());
        }
        if (pSDynaWFVerBase.isPSDynaSysNameDirty() && (bl || pSDynaWFVerBase.getPSDynaSysName() != null)) {
            iDataObject.set(FIELD_PSDYNASYSNAME, (Object)pSDynaWFVerBase.getPSDynaSysName());
        }
        if (pSDynaWFVerBase.isPSDynaWFIdDirty() && (bl || pSDynaWFVerBase.getPSDynaWFId() != null)) {
            iDataObject.set(FIELD_PSDYNAWFID, (Object)pSDynaWFVerBase.getPSDynaWFId());
        }
        if (pSDynaWFVerBase.isPSDynaWFNameDirty() && (bl || pSDynaWFVerBase.getPSDynaWFName() != null)) {
            iDataObject.set(FIELD_PSDYNAWFNAME, (Object)pSDynaWFVerBase.getPSDynaWFName());
        }
        if (pSDynaWFVerBase.isPSDynaWFVerIdDirty() && (bl || pSDynaWFVerBase.getPSDynaWFVerId() != null)) {
            iDataObject.set(FIELD_PSDYNAWFVERID, (Object)pSDynaWFVerBase.getPSDynaWFVerId());
        }
        if (pSDynaWFVerBase.isPSDynaWFVerNameDirty() && (bl || pSDynaWFVerBase.getPSDynaWFVerName() != null)) {
            iDataObject.set(FIELD_PSDYNAWFVERNAME, (Object)pSDynaWFVerBase.getPSDynaWFVerName());
        }
        if (pSDynaWFVerBase.isUpdateDateDirty() && (bl || pSDynaWFVerBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDynaWFVerBase.getUpdateDate());
        }
        if (pSDynaWFVerBase.isUpdateManDirty() && (bl || pSDynaWFVerBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDynaWFVerBase.getUpdateMan());
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
        return PSDynaWFVerBase.remove(this, n);
    }

    private static boolean remove(PSDynaWFVerBase pSDynaWFVerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDynaWFVerBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDynaWFVerBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDynaWFVerBase.resetMemo();
                return true;
            }
            case 3: {
                pSDynaWFVerBase.resetPSDynaSysId();
                return true;
            }
            case 4: {
                pSDynaWFVerBase.resetPSDynaSysName();
                return true;
            }
            case 5: {
                pSDynaWFVerBase.resetPSDynaWFId();
                return true;
            }
            case 6: {
                pSDynaWFVerBase.resetPSDynaWFName();
                return true;
            }
            case 7: {
                pSDynaWFVerBase.resetPSDynaWFVerId();
                return true;
            }
            case 8: {
                pSDynaWFVerBase.resetPSDynaWFVerName();
                return true;
            }
            case 9: {
                pSDynaWFVerBase.resetUpdateDate();
                return true;
            }
            case 10: {
                pSDynaWFVerBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDynaSys getPSDynaSys() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaSys();
        }
        if (this.getPSDynaSysId() == null) {
            return null;
        }
        Integer n = this.objPSDynaSysLock;
        synchronized (n) {
            if (this.psdynasys != null && DataTypeHelper.compare((int)25, (Object)this.getPSDynaSysId(), (Object)this.psdynasys.getPSDynaSysId()) != 0L) {
                this.psdynasys = null;
            }
            if (this.psdynasys == null) {
                PSDynaSys pSDynaSys = new PSDynaSys();
                pSDynaSys.setPSDynaSysId(this.getPSDynaSysId());
                PSDynaSysService pSDynaSysService = (PSDynaSysService)ServiceGlobal.getService(PSDynaSysService.class, (SessionFactory)this.getSessionFactory());
                pSDynaSysService.autoGet((IEntity)pSDynaSys);
                this.psdynasys = pSDynaSys;
            }
            return this.psdynasys;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDynaWF getPSDynaWF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaWF();
        }
        if (this.getPSDynaWFId() == null) {
            return null;
        }
        Integer n = this.objPSDynaWFLock;
        synchronized (n) {
            if (this.psdynawf != null && DataTypeHelper.compare((int)25, (Object)this.getPSDynaWFId(), (Object)this.psdynawf.getPSDynaWFId()) != 0L) {
                this.psdynawf = null;
            }
            if (this.psdynawf == null) {
                PSDynaWF pSDynaWF = new PSDynaWF();
                pSDynaWF.setPSDynaWFId(this.getPSDynaWFId());
                PSDynaWFService pSDynaWFService = (PSDynaWFService)ServiceGlobal.getService(PSDynaWFService.class, (SessionFactory)this.getSessionFactory());
                pSDynaWFService.autoGet((IEntity)pSDynaWF);
                this.psdynawf = pSDynaWF;
            }
            return this.psdynawf;
        }
    }

    private PSDynaWFVerBase getProxyEntity() {
        return this.proxyPSDynaWFVerBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDynaWFVerBase = null;
        if (iDataObject != null && iDataObject instanceof PSDynaWFVerBase) {
            this.proxyPSDynaWFVerBase = (PSDynaWFVerBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dynasys.service.PSDynaWFVerService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSDYNASYSID, 3);
        fieldIndexMap.put(FIELD_PSDYNASYSNAME, 4);
        fieldIndexMap.put(FIELD_PSDYNAWFID, 5);
        fieldIndexMap.put(FIELD_PSDYNAWFNAME, 6);
        fieldIndexMap.put(FIELD_PSDYNAWFVERID, 7);
        fieldIndexMap.put(FIELD_PSDYNAWFVERNAME, 8);
        fieldIndexMap.put(FIELD_UPDATEDATE, 9);
        fieldIndexMap.put(FIELD_UPDATEMAN, 10);
    }
}

