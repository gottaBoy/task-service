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
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaCodeList;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaInst;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaCodeListService;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaInstService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDynaCodeListInstBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDynaCodeListInstBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DYNAMODEL = "DYNAMODEL";
    public static final String FIELD_INSTVER = "INSTVER";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDYNACODELISTID = "PSDYNACODELISTID";
    public static final String FIELD_PSDYNACODELISTINSTID = "PSDYNACODELISTINSTID";
    public static final String FIELD_PSDYNACODELISTINSTNAME = "PSDYNACODELISTINSTNAME";
    public static final String FIELD_PSDYNACODELISTNAME = "PSDYNACODELISTNAME";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSDYNAINSTNAME = "PSDYNAINSTNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DYNAMODEL = 2;
    private static final int INDEX_INSTVER = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PSDYNACODELISTID = 5;
    private static final int INDEX_PSDYNACODELISTINSTID = 6;
    private static final int INDEX_PSDYNACODELISTINSTNAME = 7;
    private static final int INDEX_PSDYNACODELISTNAME = 8;
    private static final int INDEX_PSDYNAINSTID = 9;
    private static final int INDEX_PSDYNAINSTNAME = 10;
    private static final int INDEX_UPDATEDATE = 11;
    private static final int INDEX_UPDATEMAN = 12;
    private static final int INDEX_VALIDFLAG = 13;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDynaCodeListInstBase proxyPSDynaCodeListInstBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dynamodelDirtyFlag = false;
    private boolean instverDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdynacodelistidDirtyFlag = false;
    private boolean psdynacodelistinstidDirtyFlag = false;
    private boolean psdynacodelistinstnameDirtyFlag = false;
    private boolean psdynacodelistnameDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean psdynainstnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dynamodel")
    private String dynamodel;
    @Column(name="instver")
    private Integer instver;
    @Column(name="memo")
    private String memo;
    @Column(name="psdynacodelistid")
    private String psdynacodelistid;
    @Column(name="psdynacodelistinstid")
    private String psdynacodelistinstid;
    @Column(name="psdynacodelistinstname")
    private String psdynacodelistinstname;
    @Column(name="psdynacodelistname")
    private String psdynacodelistname;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="psdynainstname")
    private String psdynainstname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSDynaCodeListLock = new Integer(1);
    private PSDynaCodeList psdynacodelist = null;
    private Integer objPSDynaInstLock = new Integer(1);
    private PSDynaInst psdynainst = null;

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

    public void setDynaModel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynaModel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dynamodel = string;
        this.dynamodelDirtyFlag = true;
    }

    public String getDynaModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynaModel();
        }
        return this.dynamodel;
    }

    public boolean isDynaModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynaModelDirty();
        }
        return this.dynamodelDirtyFlag;
    }

    public void resetDynaModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynaModel();
            return;
        }
        this.dynamodelDirtyFlag = false;
        this.dynamodel = null;
    }

    public void setInstVer(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInstVer(n);
            return;
        }
        this.instver = n;
        this.instverDirtyFlag = true;
    }

    public Integer getInstVer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInstVer();
        }
        return this.instver;
    }

    public boolean isInstVerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInstVerDirty();
        }
        return this.instverDirtyFlag;
    }

    public void resetInstVer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInstVer();
            return;
        }
        this.instverDirtyFlag = false;
        this.instver = null;
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

    public void setPSDynaCodeListId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaCodeListId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynacodelistid = string;
        this.psdynacodelistidDirtyFlag = true;
    }

    public String getPSDynaCodeListId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaCodeListId();
        }
        return this.psdynacodelistid;
    }

    public boolean isPSDynaCodeListIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaCodeListIdDirty();
        }
        return this.psdynacodelistidDirtyFlag;
    }

    public void resetPSDynaCodeListId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaCodeListId();
            return;
        }
        this.psdynacodelistidDirtyFlag = false;
        this.psdynacodelistid = null;
    }

    public void setPSDynaCodeListInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaCodeListInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynacodelistinstid = string;
        this.psdynacodelistinstidDirtyFlag = true;
    }

    public String getPSDynaCodeListInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaCodeListInstId();
        }
        return this.psdynacodelistinstid;
    }

    public boolean isPSDynaCodeListInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaCodeListInstIdDirty();
        }
        return this.psdynacodelistinstidDirtyFlag;
    }

    public void resetPSDynaCodeListInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaCodeListInstId();
            return;
        }
        this.psdynacodelistinstidDirtyFlag = false;
        this.psdynacodelistinstid = null;
    }

    public void setPSDynaCodeListInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaCodeListInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynacodelistinstname = string;
        this.psdynacodelistinstnameDirtyFlag = true;
    }

    public String getPSDynaCodeListInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaCodeListInstName();
        }
        return this.psdynacodelistinstname;
    }

    public boolean isPSDynaCodeListInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaCodeListInstNameDirty();
        }
        return this.psdynacodelistinstnameDirtyFlag;
    }

    public void resetPSDynaCodeListInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaCodeListInstName();
            return;
        }
        this.psdynacodelistinstnameDirtyFlag = false;
        this.psdynacodelistinstname = null;
    }

    public void setPSDynaCodeListName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaCodeListName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynacodelistname = string;
        this.psdynacodelistnameDirtyFlag = true;
    }

    public String getPSDynaCodeListName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaCodeListName();
        }
        return this.psdynacodelistname;
    }

    public boolean isPSDynaCodeListNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaCodeListNameDirty();
        }
        return this.psdynacodelistnameDirtyFlag;
    }

    public void resetPSDynaCodeListName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaCodeListName();
            return;
        }
        this.psdynacodelistnameDirtyFlag = false;
        this.psdynacodelistname = null;
    }

    public void setPSDynaInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynainstid = string;
        this.psdynainstidDirtyFlag = true;
    }

    public String getPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaInstId();
        }
        return this.psdynainstid;
    }

    public boolean isPSDynaInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaInstIdDirty();
        }
        return this.psdynainstidDirtyFlag;
    }

    public void resetPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaInstId();
            return;
        }
        this.psdynainstidDirtyFlag = false;
        this.psdynainstid = null;
    }

    public void setPSDynaInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynainstname = string;
        this.psdynainstnameDirtyFlag = true;
    }

    public String getPSDynaInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaInstName();
        }
        return this.psdynainstname;
    }

    public boolean isPSDynaInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaInstNameDirty();
        }
        return this.psdynainstnameDirtyFlag;
    }

    public void resetPSDynaInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaInstName();
            return;
        }
        this.psdynainstnameDirtyFlag = false;
        this.psdynainstname = null;
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
        PSDynaCodeListInstBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDynaCodeListInstBase pSDynaCodeListInstBase) {
        pSDynaCodeListInstBase.resetCreateDate();
        pSDynaCodeListInstBase.resetCreateMan();
        pSDynaCodeListInstBase.resetDynaModel();
        pSDynaCodeListInstBase.resetInstVer();
        pSDynaCodeListInstBase.resetMemo();
        pSDynaCodeListInstBase.resetPSDynaCodeListId();
        pSDynaCodeListInstBase.resetPSDynaCodeListInstId();
        pSDynaCodeListInstBase.resetPSDynaCodeListInstName();
        pSDynaCodeListInstBase.resetPSDynaCodeListName();
        pSDynaCodeListInstBase.resetPSDynaInstId();
        pSDynaCodeListInstBase.resetPSDynaInstName();
        pSDynaCodeListInstBase.resetUpdateDate();
        pSDynaCodeListInstBase.resetUpdateMan();
        pSDynaCodeListInstBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDynaModelDirty()) {
            hashMap.put(FIELD_DYNAMODEL, this.getDynaModel());
        }
        if (!bl || this.isInstVerDirty()) {
            hashMap.put(FIELD_INSTVER, this.getInstVer());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDynaCodeListIdDirty()) {
            hashMap.put(FIELD_PSDYNACODELISTID, this.getPSDynaCodeListId());
        }
        if (!bl || this.isPSDynaCodeListInstIdDirty()) {
            hashMap.put(FIELD_PSDYNACODELISTINSTID, this.getPSDynaCodeListInstId());
        }
        if (!bl || this.isPSDynaCodeListInstNameDirty()) {
            hashMap.put(FIELD_PSDYNACODELISTINSTNAME, this.getPSDynaCodeListInstName());
        }
        if (!bl || this.isPSDynaCodeListNameDirty()) {
            hashMap.put(FIELD_PSDYNACODELISTNAME, this.getPSDynaCodeListName());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSDynaInstNameDirty()) {
            hashMap.put(FIELD_PSDYNAINSTNAME, this.getPSDynaInstName());
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
        return PSDynaCodeListInstBase.get(this, n);
    }

    private static Object get(PSDynaCodeListInstBase pSDynaCodeListInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDynaCodeListInstBase.getCreateDate();
            }
            case 1: {
                return pSDynaCodeListInstBase.getCreateMan();
            }
            case 2: {
                return pSDynaCodeListInstBase.getDynaModel();
            }
            case 3: {
                return pSDynaCodeListInstBase.getInstVer();
            }
            case 4: {
                return pSDynaCodeListInstBase.getMemo();
            }
            case 5: {
                return pSDynaCodeListInstBase.getPSDynaCodeListId();
            }
            case 6: {
                return pSDynaCodeListInstBase.getPSDynaCodeListInstId();
            }
            case 7: {
                return pSDynaCodeListInstBase.getPSDynaCodeListInstName();
            }
            case 8: {
                return pSDynaCodeListInstBase.getPSDynaCodeListName();
            }
            case 9: {
                return pSDynaCodeListInstBase.getPSDynaInstId();
            }
            case 10: {
                return pSDynaCodeListInstBase.getPSDynaInstName();
            }
            case 11: {
                return pSDynaCodeListInstBase.getUpdateDate();
            }
            case 12: {
                return pSDynaCodeListInstBase.getUpdateMan();
            }
            case 13: {
                return pSDynaCodeListInstBase.getValidFlag();
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
        PSDynaCodeListInstBase.set(this, n, object);
    }

    private static void set(PSDynaCodeListInstBase pSDynaCodeListInstBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDynaCodeListInstBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDynaCodeListInstBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDynaCodeListInstBase.setDynaModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDynaCodeListInstBase.setInstVer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSDynaCodeListInstBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDynaCodeListInstBase.setPSDynaCodeListId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDynaCodeListInstBase.setPSDynaCodeListInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDynaCodeListInstBase.setPSDynaCodeListInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDynaCodeListInstBase.setPSDynaCodeListName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDynaCodeListInstBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDynaCodeListInstBase.setPSDynaInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDynaCodeListInstBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSDynaCodeListInstBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDynaCodeListInstBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDynaCodeListInstBase.isNull(this, n);
    }

    private static boolean isNull(PSDynaCodeListInstBase pSDynaCodeListInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDynaCodeListInstBase.getCreateDate() == null;
            }
            case 1: {
                return pSDynaCodeListInstBase.getCreateMan() == null;
            }
            case 2: {
                return pSDynaCodeListInstBase.getDynaModel() == null;
            }
            case 3: {
                return pSDynaCodeListInstBase.getInstVer() == null;
            }
            case 4: {
                return pSDynaCodeListInstBase.getMemo() == null;
            }
            case 5: {
                return pSDynaCodeListInstBase.getPSDynaCodeListId() == null;
            }
            case 6: {
                return pSDynaCodeListInstBase.getPSDynaCodeListInstId() == null;
            }
            case 7: {
                return pSDynaCodeListInstBase.getPSDynaCodeListInstName() == null;
            }
            case 8: {
                return pSDynaCodeListInstBase.getPSDynaCodeListName() == null;
            }
            case 9: {
                return pSDynaCodeListInstBase.getPSDynaInstId() == null;
            }
            case 10: {
                return pSDynaCodeListInstBase.getPSDynaInstName() == null;
            }
            case 11: {
                return pSDynaCodeListInstBase.getUpdateDate() == null;
            }
            case 12: {
                return pSDynaCodeListInstBase.getUpdateMan() == null;
            }
            case 13: {
                return pSDynaCodeListInstBase.getValidFlag() == null;
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
        return PSDynaCodeListInstBase.contains(this, n);
    }

    private static boolean contains(PSDynaCodeListInstBase pSDynaCodeListInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDynaCodeListInstBase.isCreateDateDirty();
            }
            case 1: {
                return pSDynaCodeListInstBase.isCreateManDirty();
            }
            case 2: {
                return pSDynaCodeListInstBase.isDynaModelDirty();
            }
            case 3: {
                return pSDynaCodeListInstBase.isInstVerDirty();
            }
            case 4: {
                return pSDynaCodeListInstBase.isMemoDirty();
            }
            case 5: {
                return pSDynaCodeListInstBase.isPSDynaCodeListIdDirty();
            }
            case 6: {
                return pSDynaCodeListInstBase.isPSDynaCodeListInstIdDirty();
            }
            case 7: {
                return pSDynaCodeListInstBase.isPSDynaCodeListInstNameDirty();
            }
            case 8: {
                return pSDynaCodeListInstBase.isPSDynaCodeListNameDirty();
            }
            case 9: {
                return pSDynaCodeListInstBase.isPSDynaInstIdDirty();
            }
            case 10: {
                return pSDynaCodeListInstBase.isPSDynaInstNameDirty();
            }
            case 11: {
                return pSDynaCodeListInstBase.isUpdateDateDirty();
            }
            case 12: {
                return pSDynaCodeListInstBase.isUpdateManDirty();
            }
            case 13: {
                return pSDynaCodeListInstBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDynaCodeListInstBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDynaCodeListInstBase pSDynaCodeListInstBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDynaCodeListInstBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDynaCodeListInstBase.getJSONValue((Object)pSDynaCodeListInstBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDynaCodeListInstBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDynaCodeListInstBase.getJSONValue((Object)pSDynaCodeListInstBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDynaCodeListInstBase.getDynaModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodel", (Object)PSDynaCodeListInstBase.getJSONValue((Object)pSDynaCodeListInstBase.getDynaModel()), (boolean)false);
        }
        if (bl || pSDynaCodeListInstBase.getInstVer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"instver", (Object)PSDynaCodeListInstBase.getJSONValue((Object)pSDynaCodeListInstBase.getInstVer()), (boolean)false);
        }
        if (bl || pSDynaCodeListInstBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDynaCodeListInstBase.getJSONValue((Object)pSDynaCodeListInstBase.getMemo()), (boolean)false);
        }
        if (bl || pSDynaCodeListInstBase.getPSDynaCodeListId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynacodelistid", (Object)PSDynaCodeListInstBase.getJSONValue((Object)pSDynaCodeListInstBase.getPSDynaCodeListId()), (boolean)false);
        }
        if (bl || pSDynaCodeListInstBase.getPSDynaCodeListInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynacodelistinstid", (Object)PSDynaCodeListInstBase.getJSONValue((Object)pSDynaCodeListInstBase.getPSDynaCodeListInstId()), (boolean)false);
        }
        if (bl || pSDynaCodeListInstBase.getPSDynaCodeListInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynacodelistinstname", (Object)PSDynaCodeListInstBase.getJSONValue((Object)pSDynaCodeListInstBase.getPSDynaCodeListInstName()), (boolean)false);
        }
        if (bl || pSDynaCodeListInstBase.getPSDynaCodeListName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynacodelistname", (Object)PSDynaCodeListInstBase.getJSONValue((Object)pSDynaCodeListInstBase.getPSDynaCodeListName()), (boolean)false);
        }
        if (bl || pSDynaCodeListInstBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSDynaCodeListInstBase.getJSONValue((Object)pSDynaCodeListInstBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSDynaCodeListInstBase.getPSDynaInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstname", (Object)PSDynaCodeListInstBase.getJSONValue((Object)pSDynaCodeListInstBase.getPSDynaInstName()), (boolean)false);
        }
        if (bl || pSDynaCodeListInstBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDynaCodeListInstBase.getJSONValue((Object)pSDynaCodeListInstBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDynaCodeListInstBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDynaCodeListInstBase.getJSONValue((Object)pSDynaCodeListInstBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDynaCodeListInstBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDynaCodeListInstBase.getJSONValue((Object)pSDynaCodeListInstBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDynaCodeListInstBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDynaCodeListInstBase pSDynaCodeListInstBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDynaCodeListInstBase.getCreateDate() != null) {
            object = pSDynaCodeListInstBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDynaCodeListInstBase.getCreateMan() != null) {
            object = pSDynaCodeListInstBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDynaCodeListInstBase.getDynaModel() != null) {
            object = pSDynaCodeListInstBase.getDynaModel();
            xmlNode.setAttribute(FIELD_DYNAMODEL, object == null ? "" : (String)object);
        }
        if (bl || pSDynaCodeListInstBase.getInstVer() != null) {
            object = pSDynaCodeListInstBase.getInstVer();
            xmlNode.setAttribute(FIELD_INSTVER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDynaCodeListInstBase.getMemo() != null) {
            object = pSDynaCodeListInstBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDynaCodeListInstBase.getPSDynaCodeListId() != null) {
            object = pSDynaCodeListInstBase.getPSDynaCodeListId();
            xmlNode.setAttribute(FIELD_PSDYNACODELISTID, object == null ? "" : (String)object);
        }
        if (bl || pSDynaCodeListInstBase.getPSDynaCodeListInstId() != null) {
            object = pSDynaCodeListInstBase.getPSDynaCodeListInstId();
            xmlNode.setAttribute(FIELD_PSDYNACODELISTINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDynaCodeListInstBase.getPSDynaCodeListInstName() != null) {
            object = pSDynaCodeListInstBase.getPSDynaCodeListInstName();
            xmlNode.setAttribute(FIELD_PSDYNACODELISTINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDynaCodeListInstBase.getPSDynaCodeListName() != null) {
            object = pSDynaCodeListInstBase.getPSDynaCodeListName();
            xmlNode.setAttribute(FIELD_PSDYNACODELISTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDynaCodeListInstBase.getPSDynaInstId() != null) {
            object = pSDynaCodeListInstBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDynaCodeListInstBase.getPSDynaInstName() != null) {
            object = pSDynaCodeListInstBase.getPSDynaInstName();
            xmlNode.setAttribute(FIELD_PSDYNAINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDynaCodeListInstBase.getUpdateDate() != null) {
            object = pSDynaCodeListInstBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDynaCodeListInstBase.getUpdateMan() != null) {
            object = pSDynaCodeListInstBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDynaCodeListInstBase.getValidFlag() != null) {
            object = pSDynaCodeListInstBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDynaCodeListInstBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDynaCodeListInstBase pSDynaCodeListInstBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDynaCodeListInstBase.isCreateDateDirty() && (bl || pSDynaCodeListInstBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDynaCodeListInstBase.getCreateDate());
        }
        if (pSDynaCodeListInstBase.isCreateManDirty() && (bl || pSDynaCodeListInstBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDynaCodeListInstBase.getCreateMan());
        }
        if (pSDynaCodeListInstBase.isDynaModelDirty() && (bl || pSDynaCodeListInstBase.getDynaModel() != null)) {
            iDataObject.set(FIELD_DYNAMODEL, (Object)pSDynaCodeListInstBase.getDynaModel());
        }
        if (pSDynaCodeListInstBase.isInstVerDirty() && (bl || pSDynaCodeListInstBase.getInstVer() != null)) {
            iDataObject.set(FIELD_INSTVER, (Object)pSDynaCodeListInstBase.getInstVer());
        }
        if (pSDynaCodeListInstBase.isMemoDirty() && (bl || pSDynaCodeListInstBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDynaCodeListInstBase.getMemo());
        }
        if (pSDynaCodeListInstBase.isPSDynaCodeListIdDirty() && (bl || pSDynaCodeListInstBase.getPSDynaCodeListId() != null)) {
            iDataObject.set(FIELD_PSDYNACODELISTID, (Object)pSDynaCodeListInstBase.getPSDynaCodeListId());
        }
        if (pSDynaCodeListInstBase.isPSDynaCodeListInstIdDirty() && (bl || pSDynaCodeListInstBase.getPSDynaCodeListInstId() != null)) {
            iDataObject.set(FIELD_PSDYNACODELISTINSTID, (Object)pSDynaCodeListInstBase.getPSDynaCodeListInstId());
        }
        if (pSDynaCodeListInstBase.isPSDynaCodeListInstNameDirty() && (bl || pSDynaCodeListInstBase.getPSDynaCodeListInstName() != null)) {
            iDataObject.set(FIELD_PSDYNACODELISTINSTNAME, (Object)pSDynaCodeListInstBase.getPSDynaCodeListInstName());
        }
        if (pSDynaCodeListInstBase.isPSDynaCodeListNameDirty() && (bl || pSDynaCodeListInstBase.getPSDynaCodeListName() != null)) {
            iDataObject.set(FIELD_PSDYNACODELISTNAME, (Object)pSDynaCodeListInstBase.getPSDynaCodeListName());
        }
        if (pSDynaCodeListInstBase.isPSDynaInstIdDirty() && (bl || pSDynaCodeListInstBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSDynaCodeListInstBase.getPSDynaInstId());
        }
        if (pSDynaCodeListInstBase.isPSDynaInstNameDirty() && (bl || pSDynaCodeListInstBase.getPSDynaInstName() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTNAME, (Object)pSDynaCodeListInstBase.getPSDynaInstName());
        }
        if (pSDynaCodeListInstBase.isUpdateDateDirty() && (bl || pSDynaCodeListInstBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDynaCodeListInstBase.getUpdateDate());
        }
        if (pSDynaCodeListInstBase.isUpdateManDirty() && (bl || pSDynaCodeListInstBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDynaCodeListInstBase.getUpdateMan());
        }
        if (pSDynaCodeListInstBase.isValidFlagDirty() && (bl || pSDynaCodeListInstBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDynaCodeListInstBase.getValidFlag());
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
        return PSDynaCodeListInstBase.remove(this, n);
    }

    private static boolean remove(PSDynaCodeListInstBase pSDynaCodeListInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDynaCodeListInstBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDynaCodeListInstBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDynaCodeListInstBase.resetDynaModel();
                return true;
            }
            case 3: {
                pSDynaCodeListInstBase.resetInstVer();
                return true;
            }
            case 4: {
                pSDynaCodeListInstBase.resetMemo();
                return true;
            }
            case 5: {
                pSDynaCodeListInstBase.resetPSDynaCodeListId();
                return true;
            }
            case 6: {
                pSDynaCodeListInstBase.resetPSDynaCodeListInstId();
                return true;
            }
            case 7: {
                pSDynaCodeListInstBase.resetPSDynaCodeListInstName();
                return true;
            }
            case 8: {
                pSDynaCodeListInstBase.resetPSDynaCodeListName();
                return true;
            }
            case 9: {
                pSDynaCodeListInstBase.resetPSDynaInstId();
                return true;
            }
            case 10: {
                pSDynaCodeListInstBase.resetPSDynaInstName();
                return true;
            }
            case 11: {
                pSDynaCodeListInstBase.resetUpdateDate();
                return true;
            }
            case 12: {
                pSDynaCodeListInstBase.resetUpdateMan();
                return true;
            }
            case 13: {
                pSDynaCodeListInstBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDynaCodeList getPSDynaCodeList() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaCodeList();
        }
        if (this.getPSDynaCodeListId() == null) {
            return null;
        }
        Integer n = this.objPSDynaCodeListLock;
        synchronized (n) {
            if (this.psdynacodelist != null && DataTypeHelper.compare((int)25, (Object)this.getPSDynaCodeListId(), (Object)this.psdynacodelist.getPSDynaCodeListId()) != 0L) {
                this.psdynacodelist = null;
            }
            if (this.psdynacodelist == null) {
                PSDynaCodeList pSDynaCodeList = new PSDynaCodeList();
                pSDynaCodeList.setPSDynaCodeListId(this.getPSDynaCodeListId());
                PSDynaCodeListService pSDynaCodeListService = (PSDynaCodeListService)ServiceGlobal.getService(PSDynaCodeListService.class, (SessionFactory)this.getSessionFactory());
                pSDynaCodeListService.autoGet(pSDynaCodeList);
                this.psdynacodelist = pSDynaCodeList;
            }
            return this.psdynacodelist;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDynaInst getPSDynaInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaInst();
        }
        if (this.getPSDynaInstId() == null) {
            return null;
        }
        Integer n = this.objPSDynaInstLock;
        synchronized (n) {
            if (this.psdynainst != null && DataTypeHelper.compare((int)25, (Object)this.getPSDynaInstId(), (Object)this.psdynainst.getPSDynaInstId()) != 0L) {
                this.psdynainst = null;
            }
            if (this.psdynainst == null) {
                PSDynaInst pSDynaInst = new PSDynaInst();
                pSDynaInst.setPSDynaInstId(this.getPSDynaInstId());
                PSDynaInstService pSDynaInstService = (PSDynaInstService)ServiceGlobal.getService(PSDynaInstService.class, (SessionFactory)this.getSessionFactory());
                pSDynaInstService.autoGet(pSDynaInst);
                this.psdynainst = pSDynaInst;
            }
            return this.psdynainst;
        }
    }

    private PSDynaCodeListInstBase getProxyEntity() {
        return this.proxyPSDynaCodeListInstBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDynaCodeListInstBase = null;
        if (iDataObject != null && iDataObject instanceof PSDynaCodeListInstBase) {
            this.proxyPSDynaCodeListInstBase = (PSDynaCodeListInstBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dynasys.service.PSDynaCodeListInstService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DYNAMODEL, 2);
        fieldIndexMap.put(FIELD_INSTVER, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PSDYNACODELISTID, 5);
        fieldIndexMap.put(FIELD_PSDYNACODELISTINSTID, 6);
        fieldIndexMap.put(FIELD_PSDYNACODELISTINSTNAME, 7);
        fieldIndexMap.put(FIELD_PSDYNACODELISTNAME, 8);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 9);
        fieldIndexMap.put(FIELD_PSDYNAINSTNAME, 10);
        fieldIndexMap.put(FIELD_UPDATEDATE, 11);
        fieldIndexMap.put(FIELD_UPDATEMAN, 12);
        fieldIndexMap.put(FIELD_VALIDFLAG, 13);
    }
}

