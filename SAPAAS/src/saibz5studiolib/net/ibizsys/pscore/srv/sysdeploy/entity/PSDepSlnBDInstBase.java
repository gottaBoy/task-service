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
package net.ibizsys.pscore.srv.sysdeploy.entity;

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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCBDInst;
import net.ibizsys.pscore.srv.devcenter.service.PSDCBDInstService;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSln;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDepSlnBDInstBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDepSlnBDInstBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDCBDINSTID = "PSDCBDINSTID";
    public static final String FIELD_PSDCBDINSTNAME = "PSDCBDINSTNAME";
    public static final String FIELD_PSDEPSLNBDINSTID = "PSDEPSLNBDINSTID";
    public static final String FIELD_PSDEPSLNBDINSTNAME = "PSDEPSLNBDINSTNAME";
    public static final String FIELD_PSDEPSLNID = "PSDEPSLNID";
    public static final String FIELD_PSDEPSLNNAME = "PSDEPSLNNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSDCBDINSTID = 3;
    private static final int INDEX_PSDCBDINSTNAME = 4;
    private static final int INDEX_PSDEPSLNBDINSTID = 5;
    private static final int INDEX_PSDEPSLNBDINSTNAME = 6;
    private static final int INDEX_PSDEPSLNID = 7;
    private static final int INDEX_PSDEPSLNNAME = 8;
    private static final int INDEX_UPDATEDATE = 9;
    private static final int INDEX_UPDATEMAN = 10;
    private static final int INDEX_VALIDFLAG = 11;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDepSlnBDInstBase proxyPSDepSlnBDInstBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdcbdinstidDirtyFlag = false;
    private boolean psdcbdinstnameDirtyFlag = false;
    private boolean psdepslnbdinstidDirtyFlag = false;
    private boolean psdepslnbdinstnameDirtyFlag = false;
    private boolean psdepslnidDirtyFlag = false;
    private boolean psdepslnnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psdcbdinstid")
    private String psdcbdinstid;
    @Column(name="psdcbdinstname")
    private String psdcbdinstname;
    @Column(name="psdepslnbdinstid")
    private String psdepslnbdinstid;
    @Column(name="psdepslnbdinstname")
    private String psdepslnbdinstname;
    @Column(name="psdepslnid")
    private String psdepslnid;
    @Column(name="psdepslnname")
    private String psdepslnname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSDCBDInstLock = new Integer(1);
    private PSDCBDInst psdcbdinst = null;
    private Integer objPSDepSlnLock = new Integer(1);
    private PSDepSln psdepsln = null;

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

    public void setPSDCBDInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCBDInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcbdinstid = string;
        this.psdcbdinstidDirtyFlag = true;
    }

    public String getPSDCBDInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCBDInstId();
        }
        return this.psdcbdinstid;
    }

    public boolean isPSDCBDInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCBDInstIdDirty();
        }
        return this.psdcbdinstidDirtyFlag;
    }

    public void resetPSDCBDInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCBDInstId();
            return;
        }
        this.psdcbdinstidDirtyFlag = false;
        this.psdcbdinstid = null;
    }

    public void setPSDCBDInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCBDInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcbdinstname = string;
        this.psdcbdinstnameDirtyFlag = true;
    }

    public String getPSDCBDInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCBDInstName();
        }
        return this.psdcbdinstname;
    }

    public boolean isPSDCBDInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCBDInstNameDirty();
        }
        return this.psdcbdinstnameDirtyFlag;
    }

    public void resetPSDCBDInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCBDInstName();
            return;
        }
        this.psdcbdinstnameDirtyFlag = false;
        this.psdcbdinstname = null;
    }

    public void setPSDepSlnBDInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnBDInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnbdinstid = string;
        this.psdepslnbdinstidDirtyFlag = true;
    }

    public String getPSDepSlnBDInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnBDInstId();
        }
        return this.psdepslnbdinstid;
    }

    public boolean isPSDepSlnBDInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnBDInstIdDirty();
        }
        return this.psdepslnbdinstidDirtyFlag;
    }

    public void resetPSDepSlnBDInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnBDInstId();
            return;
        }
        this.psdepslnbdinstidDirtyFlag = false;
        this.psdepslnbdinstid = null;
    }

    public void setPSDepSlnBDInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnBDInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnbdinstname = string;
        this.psdepslnbdinstnameDirtyFlag = true;
    }

    public String getPSDepSlnBDInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnBDInstName();
        }
        return this.psdepslnbdinstname;
    }

    public boolean isPSDepSlnBDInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnBDInstNameDirty();
        }
        return this.psdepslnbdinstnameDirtyFlag;
    }

    public void resetPSDepSlnBDInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnBDInstName();
            return;
        }
        this.psdepslnbdinstnameDirtyFlag = false;
        this.psdepslnbdinstname = null;
    }

    public void setPSDepSlnId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnid = string;
        this.psdepslnidDirtyFlag = true;
    }

    public String getPSDepSlnId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnId();
        }
        return this.psdepslnid;
    }

    public boolean isPSDepSlnIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnIdDirty();
        }
        return this.psdepslnidDirtyFlag;
    }

    public void resetPSDepSlnId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnId();
            return;
        }
        this.psdepslnidDirtyFlag = false;
        this.psdepslnid = null;
    }

    public void setPSDepSlnName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnname = string;
        this.psdepslnnameDirtyFlag = true;
    }

    public String getPSDepSlnName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnName();
        }
        return this.psdepslnname;
    }

    public boolean isPSDepSlnNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnNameDirty();
        }
        return this.psdepslnnameDirtyFlag;
    }

    public void resetPSDepSlnName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnName();
            return;
        }
        this.psdepslnnameDirtyFlag = false;
        this.psdepslnname = null;
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
        PSDepSlnBDInstBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDepSlnBDInstBase pSDepSlnBDInstBase) {
        pSDepSlnBDInstBase.resetCreateDate();
        pSDepSlnBDInstBase.resetCreateMan();
        pSDepSlnBDInstBase.resetMemo();
        pSDepSlnBDInstBase.resetPSDCBDInstId();
        pSDepSlnBDInstBase.resetPSDCBDInstName();
        pSDepSlnBDInstBase.resetPSDepSlnBDInstId();
        pSDepSlnBDInstBase.resetPSDepSlnBDInstName();
        pSDepSlnBDInstBase.resetPSDepSlnId();
        pSDepSlnBDInstBase.resetPSDepSlnName();
        pSDepSlnBDInstBase.resetUpdateDate();
        pSDepSlnBDInstBase.resetUpdateMan();
        pSDepSlnBDInstBase.resetValidFlag();
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
        if (!bl || this.isPSDCBDInstIdDirty()) {
            hashMap.put(FIELD_PSDCBDINSTID, this.getPSDCBDInstId());
        }
        if (!bl || this.isPSDCBDInstNameDirty()) {
            hashMap.put(FIELD_PSDCBDINSTNAME, this.getPSDCBDInstName());
        }
        if (!bl || this.isPSDepSlnBDInstIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNBDINSTID, this.getPSDepSlnBDInstId());
        }
        if (!bl || this.isPSDepSlnBDInstNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNBDINSTNAME, this.getPSDepSlnBDInstName());
        }
        if (!bl || this.isPSDepSlnIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNID, this.getPSDepSlnId());
        }
        if (!bl || this.isPSDepSlnNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNNAME, this.getPSDepSlnName());
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
        return PSDepSlnBDInstBase.get(this, n);
    }

    private static Object get(PSDepSlnBDInstBase pSDepSlnBDInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnBDInstBase.getCreateDate();
            }
            case 1: {
                return pSDepSlnBDInstBase.getCreateMan();
            }
            case 2: {
                return pSDepSlnBDInstBase.getMemo();
            }
            case 3: {
                return pSDepSlnBDInstBase.getPSDCBDInstId();
            }
            case 4: {
                return pSDepSlnBDInstBase.getPSDCBDInstName();
            }
            case 5: {
                return pSDepSlnBDInstBase.getPSDepSlnBDInstId();
            }
            case 6: {
                return pSDepSlnBDInstBase.getPSDepSlnBDInstName();
            }
            case 7: {
                return pSDepSlnBDInstBase.getPSDepSlnId();
            }
            case 8: {
                return pSDepSlnBDInstBase.getPSDepSlnName();
            }
            case 9: {
                return pSDepSlnBDInstBase.getUpdateDate();
            }
            case 10: {
                return pSDepSlnBDInstBase.getUpdateMan();
            }
            case 11: {
                return pSDepSlnBDInstBase.getValidFlag();
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
        PSDepSlnBDInstBase.set(this, n, object);
    }

    private static void set(PSDepSlnBDInstBase pSDepSlnBDInstBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDepSlnBDInstBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDepSlnBDInstBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDepSlnBDInstBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDepSlnBDInstBase.setPSDCBDInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDepSlnBDInstBase.setPSDCBDInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDepSlnBDInstBase.setPSDepSlnBDInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDepSlnBDInstBase.setPSDepSlnBDInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDepSlnBDInstBase.setPSDepSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDepSlnBDInstBase.setPSDepSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDepSlnBDInstBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 10: {
                pSDepSlnBDInstBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDepSlnBDInstBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDepSlnBDInstBase.isNull(this, n);
    }

    private static boolean isNull(PSDepSlnBDInstBase pSDepSlnBDInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnBDInstBase.getCreateDate() == null;
            }
            case 1: {
                return pSDepSlnBDInstBase.getCreateMan() == null;
            }
            case 2: {
                return pSDepSlnBDInstBase.getMemo() == null;
            }
            case 3: {
                return pSDepSlnBDInstBase.getPSDCBDInstId() == null;
            }
            case 4: {
                return pSDepSlnBDInstBase.getPSDCBDInstName() == null;
            }
            case 5: {
                return pSDepSlnBDInstBase.getPSDepSlnBDInstId() == null;
            }
            case 6: {
                return pSDepSlnBDInstBase.getPSDepSlnBDInstName() == null;
            }
            case 7: {
                return pSDepSlnBDInstBase.getPSDepSlnId() == null;
            }
            case 8: {
                return pSDepSlnBDInstBase.getPSDepSlnName() == null;
            }
            case 9: {
                return pSDepSlnBDInstBase.getUpdateDate() == null;
            }
            case 10: {
                return pSDepSlnBDInstBase.getUpdateMan() == null;
            }
            case 11: {
                return pSDepSlnBDInstBase.getValidFlag() == null;
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
        return PSDepSlnBDInstBase.contains(this, n);
    }

    private static boolean contains(PSDepSlnBDInstBase pSDepSlnBDInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnBDInstBase.isCreateDateDirty();
            }
            case 1: {
                return pSDepSlnBDInstBase.isCreateManDirty();
            }
            case 2: {
                return pSDepSlnBDInstBase.isMemoDirty();
            }
            case 3: {
                return pSDepSlnBDInstBase.isPSDCBDInstIdDirty();
            }
            case 4: {
                return pSDepSlnBDInstBase.isPSDCBDInstNameDirty();
            }
            case 5: {
                return pSDepSlnBDInstBase.isPSDepSlnBDInstIdDirty();
            }
            case 6: {
                return pSDepSlnBDInstBase.isPSDepSlnBDInstNameDirty();
            }
            case 7: {
                return pSDepSlnBDInstBase.isPSDepSlnIdDirty();
            }
            case 8: {
                return pSDepSlnBDInstBase.isPSDepSlnNameDirty();
            }
            case 9: {
                return pSDepSlnBDInstBase.isUpdateDateDirty();
            }
            case 10: {
                return pSDepSlnBDInstBase.isUpdateManDirty();
            }
            case 11: {
                return pSDepSlnBDInstBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDepSlnBDInstBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDepSlnBDInstBase pSDepSlnBDInstBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDepSlnBDInstBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDepSlnBDInstBase.getJSONValue((Object)pSDepSlnBDInstBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDepSlnBDInstBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDepSlnBDInstBase.getJSONValue((Object)pSDepSlnBDInstBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDepSlnBDInstBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDepSlnBDInstBase.getJSONValue((Object)pSDepSlnBDInstBase.getMemo()), (boolean)false);
        }
        if (bl || pSDepSlnBDInstBase.getPSDCBDInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcbdinstid", (Object)PSDepSlnBDInstBase.getJSONValue((Object)pSDepSlnBDInstBase.getPSDCBDInstId()), (boolean)false);
        }
        if (bl || pSDepSlnBDInstBase.getPSDCBDInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcbdinstname", (Object)PSDepSlnBDInstBase.getJSONValue((Object)pSDepSlnBDInstBase.getPSDCBDInstName()), (boolean)false);
        }
        if (bl || pSDepSlnBDInstBase.getPSDepSlnBDInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnbdinstid", (Object)PSDepSlnBDInstBase.getJSONValue((Object)pSDepSlnBDInstBase.getPSDepSlnBDInstId()), (boolean)false);
        }
        if (bl || pSDepSlnBDInstBase.getPSDepSlnBDInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnbdinstname", (Object)PSDepSlnBDInstBase.getJSONValue((Object)pSDepSlnBDInstBase.getPSDepSlnBDInstName()), (boolean)false);
        }
        if (bl || pSDepSlnBDInstBase.getPSDepSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnid", (Object)PSDepSlnBDInstBase.getJSONValue((Object)pSDepSlnBDInstBase.getPSDepSlnId()), (boolean)false);
        }
        if (bl || pSDepSlnBDInstBase.getPSDepSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnname", (Object)PSDepSlnBDInstBase.getJSONValue((Object)pSDepSlnBDInstBase.getPSDepSlnName()), (boolean)false);
        }
        if (bl || pSDepSlnBDInstBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDepSlnBDInstBase.getJSONValue((Object)pSDepSlnBDInstBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDepSlnBDInstBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDepSlnBDInstBase.getJSONValue((Object)pSDepSlnBDInstBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDepSlnBDInstBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDepSlnBDInstBase.getJSONValue((Object)pSDepSlnBDInstBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDepSlnBDInstBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDepSlnBDInstBase pSDepSlnBDInstBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDepSlnBDInstBase.getCreateDate() != null) {
            object = pSDepSlnBDInstBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSlnBDInstBase.getCreateMan() != null) {
            object = pSDepSlnBDInstBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnBDInstBase.getMemo() != null) {
            object = pSDepSlnBDInstBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnBDInstBase.getPSDCBDInstId() != null) {
            object = pSDepSlnBDInstBase.getPSDCBDInstId();
            xmlNode.setAttribute(FIELD_PSDCBDINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnBDInstBase.getPSDCBDInstName() != null) {
            object = pSDepSlnBDInstBase.getPSDCBDInstName();
            xmlNode.setAttribute(FIELD_PSDCBDINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnBDInstBase.getPSDepSlnBDInstId() != null) {
            object = pSDepSlnBDInstBase.getPSDepSlnBDInstId();
            xmlNode.setAttribute(FIELD_PSDEPSLNBDINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnBDInstBase.getPSDepSlnBDInstName() != null) {
            object = pSDepSlnBDInstBase.getPSDepSlnBDInstName();
            xmlNode.setAttribute(FIELD_PSDEPSLNBDINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnBDInstBase.getPSDepSlnId() != null) {
            object = pSDepSlnBDInstBase.getPSDepSlnId();
            xmlNode.setAttribute(FIELD_PSDEPSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnBDInstBase.getPSDepSlnName() != null) {
            object = pSDepSlnBDInstBase.getPSDepSlnName();
            xmlNode.setAttribute(FIELD_PSDEPSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnBDInstBase.getUpdateDate() != null) {
            object = pSDepSlnBDInstBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSlnBDInstBase.getUpdateMan() != null) {
            object = pSDepSlnBDInstBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnBDInstBase.getValidFlag() != null) {
            object = pSDepSlnBDInstBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDepSlnBDInstBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDepSlnBDInstBase pSDepSlnBDInstBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDepSlnBDInstBase.isCreateDateDirty() && (bl || pSDepSlnBDInstBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDepSlnBDInstBase.getCreateDate());
        }
        if (pSDepSlnBDInstBase.isCreateManDirty() && (bl || pSDepSlnBDInstBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDepSlnBDInstBase.getCreateMan());
        }
        if (pSDepSlnBDInstBase.isMemoDirty() && (bl || pSDepSlnBDInstBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDepSlnBDInstBase.getMemo());
        }
        if (pSDepSlnBDInstBase.isPSDCBDInstIdDirty() && (bl || pSDepSlnBDInstBase.getPSDCBDInstId() != null)) {
            iDataObject.set(FIELD_PSDCBDINSTID, (Object)pSDepSlnBDInstBase.getPSDCBDInstId());
        }
        if (pSDepSlnBDInstBase.isPSDCBDInstNameDirty() && (bl || pSDepSlnBDInstBase.getPSDCBDInstName() != null)) {
            iDataObject.set(FIELD_PSDCBDINSTNAME, (Object)pSDepSlnBDInstBase.getPSDCBDInstName());
        }
        if (pSDepSlnBDInstBase.isPSDepSlnBDInstIdDirty() && (bl || pSDepSlnBDInstBase.getPSDepSlnBDInstId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNBDINSTID, (Object)pSDepSlnBDInstBase.getPSDepSlnBDInstId());
        }
        if (pSDepSlnBDInstBase.isPSDepSlnBDInstNameDirty() && (bl || pSDepSlnBDInstBase.getPSDepSlnBDInstName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNBDINSTNAME, (Object)pSDepSlnBDInstBase.getPSDepSlnBDInstName());
        }
        if (pSDepSlnBDInstBase.isPSDepSlnIdDirty() && (bl || pSDepSlnBDInstBase.getPSDepSlnId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNID, (Object)pSDepSlnBDInstBase.getPSDepSlnId());
        }
        if (pSDepSlnBDInstBase.isPSDepSlnNameDirty() && (bl || pSDepSlnBDInstBase.getPSDepSlnName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNNAME, (Object)pSDepSlnBDInstBase.getPSDepSlnName());
        }
        if (pSDepSlnBDInstBase.isUpdateDateDirty() && (bl || pSDepSlnBDInstBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDepSlnBDInstBase.getUpdateDate());
        }
        if (pSDepSlnBDInstBase.isUpdateManDirty() && (bl || pSDepSlnBDInstBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDepSlnBDInstBase.getUpdateMan());
        }
        if (pSDepSlnBDInstBase.isValidFlagDirty() && (bl || pSDepSlnBDInstBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDepSlnBDInstBase.getValidFlag());
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
        return PSDepSlnBDInstBase.remove(this, n);
    }

    private static boolean remove(PSDepSlnBDInstBase pSDepSlnBDInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDepSlnBDInstBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDepSlnBDInstBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDepSlnBDInstBase.resetMemo();
                return true;
            }
            case 3: {
                pSDepSlnBDInstBase.resetPSDCBDInstId();
                return true;
            }
            case 4: {
                pSDepSlnBDInstBase.resetPSDCBDInstName();
                return true;
            }
            case 5: {
                pSDepSlnBDInstBase.resetPSDepSlnBDInstId();
                return true;
            }
            case 6: {
                pSDepSlnBDInstBase.resetPSDepSlnBDInstName();
                return true;
            }
            case 7: {
                pSDepSlnBDInstBase.resetPSDepSlnId();
                return true;
            }
            case 8: {
                pSDepSlnBDInstBase.resetPSDepSlnName();
                return true;
            }
            case 9: {
                pSDepSlnBDInstBase.resetUpdateDate();
                return true;
            }
            case 10: {
                pSDepSlnBDInstBase.resetUpdateMan();
                return true;
            }
            case 11: {
                pSDepSlnBDInstBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCBDInst getPSDCBDInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCBDInst();
        }
        if (this.getPSDCBDInstId() == null) {
            return null;
        }
        Integer n = this.objPSDCBDInstLock;
        synchronized (n) {
            if (this.psdcbdinst != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCBDInstId(), (Object)this.psdcbdinst.getPSDCBDInstId()) != 0L) {
                this.psdcbdinst = null;
            }
            if (this.psdcbdinst == null) {
                PSDCBDInst pSDCBDInst = new PSDCBDInst();
                pSDCBDInst.setPSDCBDInstId(this.getPSDCBDInstId());
                PSDCBDInstService pSDCBDInstService = (PSDCBDInstService)ServiceGlobal.getService(PSDCBDInstService.class, (SessionFactory)this.getSessionFactory());
                pSDCBDInstService.autoGet(pSDCBDInst);
                this.psdcbdinst = pSDCBDInst;
            }
            return this.psdcbdinst;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDepSln getPSDepSln() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSln();
        }
        if (this.getPSDepSlnId() == null) {
            return null;
        }
        Integer n = this.objPSDepSlnLock;
        synchronized (n) {
            if (this.psdepsln != null && DataTypeHelper.compare((int)25, (Object)this.getPSDepSlnId(), (Object)this.psdepsln.getPSDepSlnId()) != 0L) {
                this.psdepsln = null;
            }
            if (this.psdepsln == null) {
                PSDepSln pSDepSln = new PSDepSln();
                pSDepSln.setPSDepSlnId(this.getPSDepSlnId());
                PSDepSlnService pSDepSlnService = (PSDepSlnService)ServiceGlobal.getService(PSDepSlnService.class, (SessionFactory)this.getSessionFactory());
                pSDepSlnService.autoGet(pSDepSln);
                this.psdepsln = pSDepSln;
            }
            return this.psdepsln;
        }
    }

    private PSDepSlnBDInstBase getProxyEntity() {
        return this.proxyPSDepSlnBDInstBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDepSlnBDInstBase = null;
        if (iDataObject != null && iDataObject instanceof PSDepSlnBDInstBase) {
            this.proxyPSDepSlnBDInstBase = (PSDepSlnBDInstBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnBDInstService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSDCBDINSTID, 3);
        fieldIndexMap.put(FIELD_PSDCBDINSTNAME, 4);
        fieldIndexMap.put(FIELD_PSDEPSLNBDINSTID, 5);
        fieldIndexMap.put(FIELD_PSDEPSLNBDINSTNAME, 6);
        fieldIndexMap.put(FIELD_PSDEPSLNID, 7);
        fieldIndexMap.put(FIELD_PSDEPSLNNAME, 8);
        fieldIndexMap.put(FIELD_UPDATEDATE, 9);
        fieldIndexMap.put(FIELD_UPDATEMAN, 10);
        fieldIndexMap.put(FIELD_VALIDFLAG, 11);
    }
}

