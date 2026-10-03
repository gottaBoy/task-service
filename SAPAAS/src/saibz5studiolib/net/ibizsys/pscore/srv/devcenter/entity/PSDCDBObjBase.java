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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterDBInst;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevUser;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevUserService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCDBObjBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCDBObjBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DBOBJCODE = "DBOBJCODE";
    public static final String FIELD_DBOBJTYPE = "DBOBJTYPE";
    public static final String FIELD_PSDCDBINSTID = "PSDCDBINSTID";
    public static final String FIELD_PSDCDBINSTNAME = "PSDCDBINSTNAME";
    public static final String FIELD_PSDCDBOBJID = "PSDCDBOBJID";
    public static final String FIELD_PSDCDBOBJNAME = "PSDCDBOBJNAME";
    public static final String FIELD_PSDEVUSERID = "PSDEVUSERID";
    public static final String FIELD_PSDEVUSERNAME = "PSDEVUSERNAME";
    public static final String FIELD_SQL = "SQL";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DBOBJCODE = 2;
    private static final int INDEX_DBOBJTYPE = 3;
    private static final int INDEX_PSDCDBINSTID = 4;
    private static final int INDEX_PSDCDBINSTNAME = 5;
    private static final int INDEX_PSDCDBOBJID = 6;
    private static final int INDEX_PSDCDBOBJNAME = 7;
    private static final int INDEX_PSDEVUSERID = 8;
    private static final int INDEX_PSDEVUSERNAME = 9;
    private static final int INDEX_SQL = 10;
    private static final int INDEX_UPDATEDATE = 11;
    private static final int INDEX_UPDATEMAN = 12;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCDBObjBase proxyPSDCDBObjBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dbobjcodeDirtyFlag = false;
    private boolean dbobjtypeDirtyFlag = false;
    private boolean psdcdbinstidDirtyFlag = false;
    private boolean psdcdbinstnameDirtyFlag = false;
    private boolean psdcdbobjidDirtyFlag = false;
    private boolean psdcdbobjnameDirtyFlag = false;
    private boolean psdevuseridDirtyFlag = false;
    private boolean psdevusernameDirtyFlag = false;
    private boolean sqlDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dbobjcode")
    private String dbobjcode;
    @Column(name="dbobjtype")
    private String dbobjtype;
    @Column(name="psdcdbinstid")
    private String psdcdbinstid;
    @Column(name="psdcdbinstname")
    private String psdcdbinstname;
    @Column(name="psdcdbobjid")
    private String psdcdbobjid;
    @Column(name="psdcdbobjname")
    private String psdcdbobjname;
    @Column(name="psdevuserid")
    private String psdevuserid;
    @Column(name="psdevusername")
    private String psdevusername;
    @Column(name="sql")
    private String sql;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDCDBInstLock = new Integer(1);
    private PSDevCenterDBInst psdcdbinst = null;
    private Integer objPSDevUserLock = new Integer(1);
    private PSDevUser psdevuser = null;

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

    public void setDBObjCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDBObjCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dbobjcode = string;
        this.dbobjcodeDirtyFlag = true;
    }

    public String getDBObjCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDBObjCode();
        }
        return this.dbobjcode;
    }

    public boolean isDBObjCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDBObjCodeDirty();
        }
        return this.dbobjcodeDirtyFlag;
    }

    public void resetDBObjCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDBObjCode();
            return;
        }
        this.dbobjcodeDirtyFlag = false;
        this.dbobjcode = null;
    }

    public void setDBObjType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDBObjType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dbobjtype = string;
        this.dbobjtypeDirtyFlag = true;
    }

    public String getDBObjType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDBObjType();
        }
        return this.dbobjtype;
    }

    public boolean isDBObjTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDBObjTypeDirty();
        }
        return this.dbobjtypeDirtyFlag;
    }

    public void resetDBObjType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDBObjType();
            return;
        }
        this.dbobjtypeDirtyFlag = false;
        this.dbobjtype = null;
    }

    public void setPSDCDBInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCDBInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcdbinstid = string;
        this.psdcdbinstidDirtyFlag = true;
    }

    public String getPSDCDBInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCDBInstId();
        }
        return this.psdcdbinstid;
    }

    public boolean isPSDCDBInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCDBInstIdDirty();
        }
        return this.psdcdbinstidDirtyFlag;
    }

    public void resetPSDCDBInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCDBInstId();
            return;
        }
        this.psdcdbinstidDirtyFlag = false;
        this.psdcdbinstid = null;
    }

    public void setPSDCDBInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCDBInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcdbinstname = string;
        this.psdcdbinstnameDirtyFlag = true;
    }

    public String getPSDCDBInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCDBInstName();
        }
        return this.psdcdbinstname;
    }

    public boolean isPSDCDBInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCDBInstNameDirty();
        }
        return this.psdcdbinstnameDirtyFlag;
    }

    public void resetPSDCDBInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCDBInstName();
            return;
        }
        this.psdcdbinstnameDirtyFlag = false;
        this.psdcdbinstname = null;
    }

    public void setPSDCDBObjId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCDBObjId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcdbobjid = string;
        this.psdcdbobjidDirtyFlag = true;
    }

    public String getPSDCDBObjId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCDBObjId();
        }
        return this.psdcdbobjid;
    }

    public boolean isPSDCDBObjIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCDBObjIdDirty();
        }
        return this.psdcdbobjidDirtyFlag;
    }

    public void resetPSDCDBObjId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCDBObjId();
            return;
        }
        this.psdcdbobjidDirtyFlag = false;
        this.psdcdbobjid = null;
    }

    public void setPSDCDBObjName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCDBObjName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcdbobjname = string;
        this.psdcdbobjnameDirtyFlag = true;
    }

    public String getPSDCDBObjName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCDBObjName();
        }
        return this.psdcdbobjname;
    }

    public boolean isPSDCDBObjNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCDBObjNameDirty();
        }
        return this.psdcdbobjnameDirtyFlag;
    }

    public void resetPSDCDBObjName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCDBObjName();
            return;
        }
        this.psdcdbobjnameDirtyFlag = false;
        this.psdcdbobjname = null;
    }

    public void setPSDevUserId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevUserId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevuserid = string;
        this.psdevuseridDirtyFlag = true;
    }

    public String getPSDevUserId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevUserId();
        }
        return this.psdevuserid;
    }

    public boolean isPSDevUserIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevUserIdDirty();
        }
        return this.psdevuseridDirtyFlag;
    }

    public void resetPSDevUserId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevUserId();
            return;
        }
        this.psdevuseridDirtyFlag = false;
        this.psdevuserid = null;
    }

    public void setPSDevUserName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevUserName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevusername = string;
        this.psdevusernameDirtyFlag = true;
    }

    public String getPSDevUserName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevUserName();
        }
        return this.psdevusername;
    }

    public boolean isPSDevUserNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevUserNameDirty();
        }
        return this.psdevusernameDirtyFlag;
    }

    public void resetPSDevUserName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevUserName();
            return;
        }
        this.psdevusernameDirtyFlag = false;
        this.psdevusername = null;
    }

    public void setSQL(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSQL(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sql = string;
        this.sqlDirtyFlag = true;
    }

    public String getSQL() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSQL();
        }
        return this.sql;
    }

    public boolean isSQLDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSQLDirty();
        }
        return this.sqlDirtyFlag;
    }

    public void resetSQL() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSQL();
            return;
        }
        this.sqlDirtyFlag = false;
        this.sql = null;
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
        PSDCDBObjBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCDBObjBase pSDCDBObjBase) {
        pSDCDBObjBase.resetCreateDate();
        pSDCDBObjBase.resetCreateMan();
        pSDCDBObjBase.resetDBObjCode();
        pSDCDBObjBase.resetDBObjType();
        pSDCDBObjBase.resetPSDCDBInstId();
        pSDCDBObjBase.resetPSDCDBInstName();
        pSDCDBObjBase.resetPSDCDBObjId();
        pSDCDBObjBase.resetPSDCDBObjName();
        pSDCDBObjBase.resetPSDevUserId();
        pSDCDBObjBase.resetPSDevUserName();
        pSDCDBObjBase.resetSQL();
        pSDCDBObjBase.resetUpdateDate();
        pSDCDBObjBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDBObjCodeDirty()) {
            hashMap.put(FIELD_DBOBJCODE, this.getDBObjCode());
        }
        if (!bl || this.isDBObjTypeDirty()) {
            hashMap.put(FIELD_DBOBJTYPE, this.getDBObjType());
        }
        if (!bl || this.isPSDCDBInstIdDirty()) {
            hashMap.put(FIELD_PSDCDBINSTID, this.getPSDCDBInstId());
        }
        if (!bl || this.isPSDCDBInstNameDirty()) {
            hashMap.put(FIELD_PSDCDBINSTNAME, this.getPSDCDBInstName());
        }
        if (!bl || this.isPSDCDBObjIdDirty()) {
            hashMap.put(FIELD_PSDCDBOBJID, this.getPSDCDBObjId());
        }
        if (!bl || this.isPSDCDBObjNameDirty()) {
            hashMap.put(FIELD_PSDCDBOBJNAME, this.getPSDCDBObjName());
        }
        if (!bl || this.isPSDevUserIdDirty()) {
            hashMap.put(FIELD_PSDEVUSERID, this.getPSDevUserId());
        }
        if (!bl || this.isPSDevUserNameDirty()) {
            hashMap.put(FIELD_PSDEVUSERNAME, this.getPSDevUserName());
        }
        if (!bl || this.isSQLDirty()) {
            hashMap.put(FIELD_SQL, this.getSQL());
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
        return PSDCDBObjBase.get(this, n);
    }

    private static Object get(PSDCDBObjBase pSDCDBObjBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCDBObjBase.getCreateDate();
            }
            case 1: {
                return pSDCDBObjBase.getCreateMan();
            }
            case 2: {
                return pSDCDBObjBase.getDBObjCode();
            }
            case 3: {
                return pSDCDBObjBase.getDBObjType();
            }
            case 4: {
                return pSDCDBObjBase.getPSDCDBInstId();
            }
            case 5: {
                return pSDCDBObjBase.getPSDCDBInstName();
            }
            case 6: {
                return pSDCDBObjBase.getPSDCDBObjId();
            }
            case 7: {
                return pSDCDBObjBase.getPSDCDBObjName();
            }
            case 8: {
                return pSDCDBObjBase.getPSDevUserId();
            }
            case 9: {
                return pSDCDBObjBase.getPSDevUserName();
            }
            case 10: {
                return pSDCDBObjBase.getSQL();
            }
            case 11: {
                return pSDCDBObjBase.getUpdateDate();
            }
            case 12: {
                return pSDCDBObjBase.getUpdateMan();
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
        PSDCDBObjBase.set(this, n, object);
    }

    private static void set(PSDCDBObjBase pSDCDBObjBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCDBObjBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDCDBObjBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDCDBObjBase.setDBObjCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDCDBObjBase.setDBObjType(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDCDBObjBase.setPSDCDBInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDCDBObjBase.setPSDCDBInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDCDBObjBase.setPSDCDBObjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDCDBObjBase.setPSDCDBObjName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDCDBObjBase.setPSDevUserId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDCDBObjBase.setPSDevUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDCDBObjBase.setSQL(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDCDBObjBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSDCDBObjBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDCDBObjBase.isNull(this, n);
    }

    private static boolean isNull(PSDCDBObjBase pSDCDBObjBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCDBObjBase.getCreateDate() == null;
            }
            case 1: {
                return pSDCDBObjBase.getCreateMan() == null;
            }
            case 2: {
                return pSDCDBObjBase.getDBObjCode() == null;
            }
            case 3: {
                return pSDCDBObjBase.getDBObjType() == null;
            }
            case 4: {
                return pSDCDBObjBase.getPSDCDBInstId() == null;
            }
            case 5: {
                return pSDCDBObjBase.getPSDCDBInstName() == null;
            }
            case 6: {
                return pSDCDBObjBase.getPSDCDBObjId() == null;
            }
            case 7: {
                return pSDCDBObjBase.getPSDCDBObjName() == null;
            }
            case 8: {
                return pSDCDBObjBase.getPSDevUserId() == null;
            }
            case 9: {
                return pSDCDBObjBase.getPSDevUserName() == null;
            }
            case 10: {
                return pSDCDBObjBase.getSQL() == null;
            }
            case 11: {
                return pSDCDBObjBase.getUpdateDate() == null;
            }
            case 12: {
                return pSDCDBObjBase.getUpdateMan() == null;
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
        return PSDCDBObjBase.contains(this, n);
    }

    private static boolean contains(PSDCDBObjBase pSDCDBObjBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCDBObjBase.isCreateDateDirty();
            }
            case 1: {
                return pSDCDBObjBase.isCreateManDirty();
            }
            case 2: {
                return pSDCDBObjBase.isDBObjCodeDirty();
            }
            case 3: {
                return pSDCDBObjBase.isDBObjTypeDirty();
            }
            case 4: {
                return pSDCDBObjBase.isPSDCDBInstIdDirty();
            }
            case 5: {
                return pSDCDBObjBase.isPSDCDBInstNameDirty();
            }
            case 6: {
                return pSDCDBObjBase.isPSDCDBObjIdDirty();
            }
            case 7: {
                return pSDCDBObjBase.isPSDCDBObjNameDirty();
            }
            case 8: {
                return pSDCDBObjBase.isPSDevUserIdDirty();
            }
            case 9: {
                return pSDCDBObjBase.isPSDevUserNameDirty();
            }
            case 10: {
                return pSDCDBObjBase.isSQLDirty();
            }
            case 11: {
                return pSDCDBObjBase.isUpdateDateDirty();
            }
            case 12: {
                return pSDCDBObjBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCDBObjBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCDBObjBase pSDCDBObjBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCDBObjBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCDBObjBase.getJSONValue((Object)pSDCDBObjBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCDBObjBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCDBObjBase.getJSONValue((Object)pSDCDBObjBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCDBObjBase.getDBObjCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dbobjcode", (Object)PSDCDBObjBase.getJSONValue((Object)pSDCDBObjBase.getDBObjCode()), (boolean)false);
        }
        if (bl || pSDCDBObjBase.getDBObjType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dbobjtype", (Object)PSDCDBObjBase.getJSONValue((Object)pSDCDBObjBase.getDBObjType()), (boolean)false);
        }
        if (bl || pSDCDBObjBase.getPSDCDBInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcdbinstid", (Object)PSDCDBObjBase.getJSONValue((Object)pSDCDBObjBase.getPSDCDBInstId()), (boolean)false);
        }
        if (bl || pSDCDBObjBase.getPSDCDBInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcdbinstname", (Object)PSDCDBObjBase.getJSONValue((Object)pSDCDBObjBase.getPSDCDBInstName()), (boolean)false);
        }
        if (bl || pSDCDBObjBase.getPSDCDBObjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcdbobjid", (Object)PSDCDBObjBase.getJSONValue((Object)pSDCDBObjBase.getPSDCDBObjId()), (boolean)false);
        }
        if (bl || pSDCDBObjBase.getPSDCDBObjName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcdbobjname", (Object)PSDCDBObjBase.getJSONValue((Object)pSDCDBObjBase.getPSDCDBObjName()), (boolean)false);
        }
        if (bl || pSDCDBObjBase.getPSDevUserId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevuserid", (Object)PSDCDBObjBase.getJSONValue((Object)pSDCDBObjBase.getPSDevUserId()), (boolean)false);
        }
        if (bl || pSDCDBObjBase.getPSDevUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevusername", (Object)PSDCDBObjBase.getJSONValue((Object)pSDCDBObjBase.getPSDevUserName()), (boolean)false);
        }
        if (bl || pSDCDBObjBase.getSQL() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sql", (Object)PSDCDBObjBase.getJSONValue((Object)pSDCDBObjBase.getSQL()), (boolean)false);
        }
        if (bl || pSDCDBObjBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCDBObjBase.getJSONValue((Object)pSDCDBObjBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCDBObjBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCDBObjBase.getJSONValue((Object)pSDCDBObjBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCDBObjBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCDBObjBase pSDCDBObjBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCDBObjBase.getCreateDate() != null) {
            object = pSDCDBObjBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCDBObjBase.getCreateMan() != null) {
            object = pSDCDBObjBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBObjBase.getDBObjCode() != null) {
            object = pSDCDBObjBase.getDBObjCode();
            xmlNode.setAttribute(FIELD_DBOBJCODE, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBObjBase.getDBObjType() != null) {
            object = pSDCDBObjBase.getDBObjType();
            xmlNode.setAttribute(FIELD_DBOBJTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBObjBase.getPSDCDBInstId() != null) {
            object = pSDCDBObjBase.getPSDCDBInstId();
            xmlNode.setAttribute(FIELD_PSDCDBINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBObjBase.getPSDCDBInstName() != null) {
            object = pSDCDBObjBase.getPSDCDBInstName();
            xmlNode.setAttribute(FIELD_PSDCDBINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBObjBase.getPSDCDBObjId() != null) {
            object = pSDCDBObjBase.getPSDCDBObjId();
            xmlNode.setAttribute(FIELD_PSDCDBOBJID, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBObjBase.getPSDCDBObjName() != null) {
            object = pSDCDBObjBase.getPSDCDBObjName();
            xmlNode.setAttribute(FIELD_PSDCDBOBJNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBObjBase.getPSDevUserId() != null) {
            object = pSDCDBObjBase.getPSDevUserId();
            xmlNode.setAttribute(FIELD_PSDEVUSERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBObjBase.getPSDevUserName() != null) {
            object = pSDCDBObjBase.getPSDevUserName();
            xmlNode.setAttribute(FIELD_PSDEVUSERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBObjBase.getSQL() != null) {
            object = pSDCDBObjBase.getSQL();
            xmlNode.setAttribute(FIELD_SQL, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBObjBase.getUpdateDate() != null) {
            object = pSDCDBObjBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCDBObjBase.getUpdateMan() != null) {
            object = pSDCDBObjBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCDBObjBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCDBObjBase pSDCDBObjBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCDBObjBase.isCreateDateDirty() && (bl || pSDCDBObjBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCDBObjBase.getCreateDate());
        }
        if (pSDCDBObjBase.isCreateManDirty() && (bl || pSDCDBObjBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCDBObjBase.getCreateMan());
        }
        if (pSDCDBObjBase.isDBObjCodeDirty() && (bl || pSDCDBObjBase.getDBObjCode() != null)) {
            iDataObject.set(FIELD_DBOBJCODE, (Object)pSDCDBObjBase.getDBObjCode());
        }
        if (pSDCDBObjBase.isDBObjTypeDirty() && (bl || pSDCDBObjBase.getDBObjType() != null)) {
            iDataObject.set(FIELD_DBOBJTYPE, (Object)pSDCDBObjBase.getDBObjType());
        }
        if (pSDCDBObjBase.isPSDCDBInstIdDirty() && (bl || pSDCDBObjBase.getPSDCDBInstId() != null)) {
            iDataObject.set(FIELD_PSDCDBINSTID, (Object)pSDCDBObjBase.getPSDCDBInstId());
        }
        if (pSDCDBObjBase.isPSDCDBInstNameDirty() && (bl || pSDCDBObjBase.getPSDCDBInstName() != null)) {
            iDataObject.set(FIELD_PSDCDBINSTNAME, (Object)pSDCDBObjBase.getPSDCDBInstName());
        }
        if (pSDCDBObjBase.isPSDCDBObjIdDirty() && (bl || pSDCDBObjBase.getPSDCDBObjId() != null)) {
            iDataObject.set(FIELD_PSDCDBOBJID, (Object)pSDCDBObjBase.getPSDCDBObjId());
        }
        if (pSDCDBObjBase.isPSDCDBObjNameDirty() && (bl || pSDCDBObjBase.getPSDCDBObjName() != null)) {
            iDataObject.set(FIELD_PSDCDBOBJNAME, (Object)pSDCDBObjBase.getPSDCDBObjName());
        }
        if (pSDCDBObjBase.isPSDevUserIdDirty() && (bl || pSDCDBObjBase.getPSDevUserId() != null)) {
            iDataObject.set(FIELD_PSDEVUSERID, (Object)pSDCDBObjBase.getPSDevUserId());
        }
        if (pSDCDBObjBase.isPSDevUserNameDirty() && (bl || pSDCDBObjBase.getPSDevUserName() != null)) {
            iDataObject.set(FIELD_PSDEVUSERNAME, (Object)pSDCDBObjBase.getPSDevUserName());
        }
        if (pSDCDBObjBase.isSQLDirty() && (bl || pSDCDBObjBase.getSQL() != null)) {
            iDataObject.set(FIELD_SQL, (Object)pSDCDBObjBase.getSQL());
        }
        if (pSDCDBObjBase.isUpdateDateDirty() && (bl || pSDCDBObjBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCDBObjBase.getUpdateDate());
        }
        if (pSDCDBObjBase.isUpdateManDirty() && (bl || pSDCDBObjBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCDBObjBase.getUpdateMan());
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
        return PSDCDBObjBase.remove(this, n);
    }

    private static boolean remove(PSDCDBObjBase pSDCDBObjBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCDBObjBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDCDBObjBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDCDBObjBase.resetDBObjCode();
                return true;
            }
            case 3: {
                pSDCDBObjBase.resetDBObjType();
                return true;
            }
            case 4: {
                pSDCDBObjBase.resetPSDCDBInstId();
                return true;
            }
            case 5: {
                pSDCDBObjBase.resetPSDCDBInstName();
                return true;
            }
            case 6: {
                pSDCDBObjBase.resetPSDCDBObjId();
                return true;
            }
            case 7: {
                pSDCDBObjBase.resetPSDCDBObjName();
                return true;
            }
            case 8: {
                pSDCDBObjBase.resetPSDevUserId();
                return true;
            }
            case 9: {
                pSDCDBObjBase.resetPSDevUserName();
                return true;
            }
            case 10: {
                pSDCDBObjBase.resetSQL();
                return true;
            }
            case 11: {
                pSDCDBObjBase.resetUpdateDate();
                return true;
            }
            case 12: {
                pSDCDBObjBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterDBInst getPSDCDBInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCDBInst();
        }
        if (this.getPSDCDBInstId() == null) {
            return null;
        }
        Integer n = this.objPSDCDBInstLock;
        synchronized (n) {
            if (this.psdcdbinst != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCDBInstId(), (Object)this.psdcdbinst.getPSDevCenterDBInstId()) != 0L) {
                this.psdcdbinst = null;
            }
            if (this.psdcdbinst == null) {
                PSDevCenterDBInst pSDevCenterDBInst = new PSDevCenterDBInst();
                pSDevCenterDBInst.setPSDevCenterDBInstId(this.getPSDCDBInstId());
                PSDevCenterDBInstService pSDevCenterDBInstService = (PSDevCenterDBInstService)ServiceGlobal.getService(PSDevCenterDBInstService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterDBInstService.autoGet(pSDevCenterDBInst);
                this.psdcdbinst = pSDevCenterDBInst;
            }
            return this.psdcdbinst;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevUser getPSDevUser() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevUser();
        }
        if (this.getPSDevUserId() == null) {
            return null;
        }
        Integer n = this.objPSDevUserLock;
        synchronized (n) {
            if (this.psdevuser != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevUserId(), (Object)this.psdevuser.getPSDevUserId()) != 0L) {
                this.psdevuser = null;
            }
            if (this.psdevuser == null) {
                PSDevUser pSDevUser = new PSDevUser();
                pSDevUser.setPSDevUserId(this.getPSDevUserId());
                PSDevUserService pSDevUserService = (PSDevUserService)ServiceGlobal.getService(PSDevUserService.class, (SessionFactory)this.getSessionFactory());
                pSDevUserService.autoGet(pSDevUser);
                this.psdevuser = pSDevUser;
            }
            return this.psdevuser;
        }
    }

    private PSDCDBObjBase getProxyEntity() {
        return this.proxyPSDCDBObjBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCDBObjBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCDBObjBase) {
            this.proxyPSDCDBObjBase = (PSDCDBObjBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCDBObjService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DBOBJCODE, 2);
        fieldIndexMap.put(FIELD_DBOBJTYPE, 3);
        fieldIndexMap.put(FIELD_PSDCDBINSTID, 4);
        fieldIndexMap.put(FIELD_PSDCDBINSTNAME, 5);
        fieldIndexMap.put(FIELD_PSDCDBOBJID, 6);
        fieldIndexMap.put(FIELD_PSDCDBOBJNAME, 7);
        fieldIndexMap.put(FIELD_PSDEVUSERID, 8);
        fieldIndexMap.put(FIELD_PSDEVUSERNAME, 9);
        fieldIndexMap.put(FIELD_SQL, 10);
        fieldIndexMap.put(FIELD_UPDATEDATE, 11);
        fieldIndexMap.put(FIELD_UPDATEMAN, 12);
    }
}

